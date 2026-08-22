package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.internal.ReleasableInputStream;
import com.amazonaws.internal.ResettableInputStream;
import com.amazonaws.internal.SdkFilterInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import com.amazonaws.services.kms.model.GenerateDataKeyResult;
import com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.S3Direct;
import com.amazonaws.services.s3.internal.crypto.MultipartUploadCryptoContext;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.AbstractPutObjectRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazonaws.services.s3.model.CopyPartResult;
import com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.services.s3.model.CryptoStorageMode;
import com.amazonaws.services.s3.model.EncryptionMaterials;
import com.amazonaws.services.s3.model.EncryptionMaterialsFactory;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.s3.model.MaterialsDescriptionProvider;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutInstructionFileRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3DataSource;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectId;
import com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.amazonaws.services.s3.util.Mimetypes;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.LengthCheckInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.JsonUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class S3CryptoModuleBase<T extends MultipartUploadCryptoContext> extends S3CryptoModule<T> {
    protected static final int DEFAULT_BUFFER_SIZE = 2048;
    private static final boolean IS_MULTI_PART = true;
    private static final int MAX_RETRY_COUNT = 9;
    protected final ContentCryptoScheme contentCryptoScheme;
    protected final CryptoConfiguration cryptoConfig;
    protected final S3CryptoScheme cryptoScheme;
    protected final EncryptionMaterialsProvider kekMaterialsProvider;
    protected final AWSKMSClient kms;
    protected final Log log = LogFactory.getLog(getClass());
    protected final Map<String, T> multipartUploadContexts = Collections.synchronizedMap(new HashMap());
    protected final S3Direct s3;

    abstract CipherLite cipherLiteForNextPart(T t);

    protected abstract long ciphertextLength(long j);

    abstract long computeLastPartSize(UploadPartRequest uploadPartRequest);

    abstract T newUploadContext(InitiateMultipartUploadRequest initiateMultipartUploadRequest, ContentCryptoMaterial contentCryptoMaterial);

    protected void securityCheck(ContentCryptoMaterial contentCryptoMaterial, S3ObjectWrapper s3ObjectWrapper) {
    }

    abstract void updateUploadContext(T t, SdkFilterInputStream sdkFilterInputStream);

    abstract <I extends CipherLiteInputStream> SdkFilterInputStream wrapForMultipart(I i, long j);

    protected S3CryptoModuleBase(AWSKMSClient aWSKMSClient, S3Direct s3Direct, AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        if (!cryptoConfiguration.isReadOnly()) {
            throw new IllegalArgumentException("The crypto configuration parameter is required to be read-only");
        }
        this.kekMaterialsProvider = encryptionMaterialsProvider;
        this.s3 = s3Direct;
        this.cryptoConfig = cryptoConfiguration;
        S3CryptoScheme s3CryptoSchemeFrom = S3CryptoScheme.from(cryptoConfiguration.getCryptoMode());
        this.cryptoScheme = s3CryptoSchemeFrom;
        this.contentCryptoScheme = s3CryptoSchemeFrom.getContentCryptoScheme();
        this.kms = aWSKMSClient;
    }

    protected S3CryptoModuleBase(S3Direct s3Direct, AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this.kekMaterialsProvider = encryptionMaterialsProvider;
        this.s3 = s3Direct;
        this.cryptoConfig = cryptoConfiguration;
        S3CryptoScheme s3CryptoSchemeFrom = S3CryptoScheme.from(cryptoConfiguration.getCryptoMode());
        this.cryptoScheme = s3CryptoSchemeFrom;
        this.contentCryptoScheme = s3CryptoSchemeFrom.getContentCryptoScheme();
        this.kms = null;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public PutObjectResult putObjectSecurely(PutObjectRequest putObjectRequest) {
        appendUserAgent(putObjectRequest, AmazonS3EncryptionClient.USER_AGENT);
        if (this.cryptoConfig.getStorageMode() == CryptoStorageMode.InstructionFile) {
            return putObjectUsingInstructionFile(putObjectRequest);
        }
        return putObjectUsingMetadata(putObjectRequest);
    }

    private PutObjectResult putObjectUsingMetadata(PutObjectRequest putObjectRequest) {
        ContentCryptoMaterial contentCryptoMaterialCreateContentCryptoMaterial = createContentCryptoMaterial(putObjectRequest);
        File file = putObjectRequest.getFile();
        InputStream inputStream = putObjectRequest.getInputStream();
        PutObjectRequest putObjectRequest2 = (PutObjectRequest) wrapWithCipher(putObjectRequest, contentCryptoMaterialCreateContentCryptoMaterial);
        putObjectRequest.setMetadata(updateMetadataWithContentCryptoMaterial(putObjectRequest.getMetadata(), putObjectRequest.getFile(), contentCryptoMaterialCreateContentCryptoMaterial));
        try {
            return this.s3.putObject(putObjectRequest2);
        } finally {
            S3DataSource.Utils.cleanupDataSource(putObjectRequest, file, inputStream, putObjectRequest2.getInputStream(), this.log);
        }
    }

    private PutObjectResult putObjectUsingInstructionFile(PutObjectRequest putObjectRequest) {
        File file = putObjectRequest.getFile();
        InputStream inputStream = putObjectRequest.getInputStream();
        PutObjectRequest putObjectRequestWithInputStream = putObjectRequest.mo9801clone().withFile((File) null).withInputStream((InputStream) null);
        putObjectRequestWithInputStream.setKey(putObjectRequestWithInputStream.getKey() + ".instruction");
        ContentCryptoMaterial contentCryptoMaterialCreateContentCryptoMaterial = createContentCryptoMaterial(putObjectRequest);
        PutObjectRequest putObjectRequest2 = (PutObjectRequest) wrapWithCipher(putObjectRequest, contentCryptoMaterialCreateContentCryptoMaterial);
        try {
            PutObjectResult putObjectResultPutObject = this.s3.putObject(putObjectRequest2);
            S3DataSource.Utils.cleanupDataSource(putObjectRequest, file, inputStream, putObjectRequest2.getInputStream(), this.log);
            this.s3.putObject(updateInstructionPutRequest(putObjectRequestWithInputStream, contentCryptoMaterialCreateContentCryptoMaterial));
            return putObjectResultPutObject;
        } catch (Throwable th) {
            S3DataSource.Utils.cleanupDataSource(putObjectRequest, file, inputStream, putObjectRequest2.getInputStream(), this.log);
            throw th;
        }
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public final void abortMultipartUploadSecurely(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        this.s3.abortMultipartUpload(abortMultipartUploadRequest);
        this.multipartUploadContexts.remove(abortMultipartUploadRequest.getUploadId());
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public final CopyPartResult copyPartSecurely(CopyPartRequest copyPartRequest) {
        T t = this.multipartUploadContexts.get(copyPartRequest.getUploadId());
        CopyPartResult copyPartResultCopyPart = this.s3.copyPart(copyPartRequest);
        if (t != null && !t.hasFinalPartBeenSeen()) {
            t.setHasFinalPartBeenSeen(true);
        }
        return copyPartResultCopyPart;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public InitiateMultipartUploadResult initiateMultipartUploadSecurely(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        appendUserAgent(initiateMultipartUploadRequest, AmazonS3EncryptionClient.USER_AGENT);
        ContentCryptoMaterial contentCryptoMaterialCreateContentCryptoMaterial = createContentCryptoMaterial(initiateMultipartUploadRequest);
        if (this.cryptoConfig.getStorageMode() == CryptoStorageMode.ObjectMetadata) {
            ObjectMetadata objectMetadata = initiateMultipartUploadRequest.getObjectMetadata();
            if (objectMetadata == null) {
                objectMetadata = new ObjectMetadata();
            }
            initiateMultipartUploadRequest.setObjectMetadata(updateMetadataWithContentCryptoMaterial(objectMetadata, null, contentCryptoMaterialCreateContentCryptoMaterial));
        }
        InitiateMultipartUploadResult initiateMultipartUploadResultInitiateMultipartUpload = this.s3.initiateMultipartUpload(initiateMultipartUploadRequest);
        MultipartUploadCryptoContext multipartUploadCryptoContextNewUploadContext = newUploadContext(initiateMultipartUploadRequest, contentCryptoMaterialCreateContentCryptoMaterial);
        if (initiateMultipartUploadRequest instanceof MaterialsDescriptionProvider) {
            multipartUploadCryptoContextNewUploadContext.setMaterialsDescription(((MaterialsDescriptionProvider) initiateMultipartUploadRequest).getMaterialsDescription());
        }
        this.multipartUploadContexts.put(initiateMultipartUploadResultInitiateMultipartUpload.getUploadId(), (T) multipartUploadCryptoContextNewUploadContext);
        return initiateMultipartUploadResultInitiateMultipartUpload;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public UploadPartResult uploadPartSecurely(UploadPartRequest uploadPartRequest) throws Throwable {
        appendUserAgent(uploadPartRequest, AmazonS3EncryptionClient.USER_AGENT);
        int blockSizeInBytes = this.contentCryptoScheme.getBlockSizeInBytes();
        boolean zIsLastPart = uploadPartRequest.isLastPart();
        String uploadId = uploadPartRequest.getUploadId();
        long partSize = uploadPartRequest.getPartSize();
        boolean z = 0 == partSize % ((long) blockSizeInBytes);
        if (!zIsLastPart && !z) {
            throw new AmazonClientException("Invalid part size: part sizes for encrypted multipart uploads must be multiples of the cipher block size (" + blockSizeInBytes + ") with the exception of the last part.");
        }
        T t = this.multipartUploadContexts.get(uploadId);
        if (t == null) {
            throw new AmazonClientException("No client-side information available on upload ID " + uploadId);
        }
        t.beginPartUpload(uploadPartRequest.getPartNumber());
        CipherLite cipherLiteCipherLiteForNextPart = cipherLiteForNextPart(t);
        File file = uploadPartRequest.getFile();
        InputStream inputStream = uploadPartRequest.getInputStream();
        CipherLiteInputStream cipherLiteInputStream = null;
        try {
            CipherLiteInputStream cipherLiteInputStreamNewMultipartS3CipherInputStream = newMultipartS3CipherInputStream(uploadPartRequest, cipherLiteCipherLiteForNextPart);
            try {
                SdkFilterInputStream sdkFilterInputStreamWrapForMultipart = wrapForMultipart(cipherLiteInputStreamNewMultipartS3CipherInputStream, partSize);
                uploadPartRequest.setInputStream(sdkFilterInputStreamWrapForMultipart);
                uploadPartRequest.setFile(null);
                uploadPartRequest.setFileOffset(0L);
                if (zIsLastPart) {
                    long jComputeLastPartSize = computeLastPartSize(uploadPartRequest);
                    if (jComputeLastPartSize > -1) {
                        uploadPartRequest.setPartSize(jComputeLastPartSize);
                    }
                    if (t.hasFinalPartBeenSeen()) {
                        throw new AmazonClientException("This part was specified as the last part in a multipart upload, but a previous part was already marked as the last part.  Only the last part of the upload should be marked as the last part.");
                    }
                }
                UploadPartResult uploadPartResultUploadPart = this.s3.uploadPart(uploadPartRequest);
                S3DataSource.Utils.cleanupDataSource(uploadPartRequest, file, inputStream, sdkFilterInputStreamWrapForMultipart, this.log);
                t.endPartUpload();
                if (zIsLastPart) {
                    t.setHasFinalPartBeenSeen(true);
                }
                updateUploadContext(t, sdkFilterInputStreamWrapForMultipart);
                return uploadPartResultUploadPart;
            } catch (Throwable th) {
                th = th;
                cipherLiteInputStream = cipherLiteInputStreamNewMultipartS3CipherInputStream;
                S3DataSource.Utils.cleanupDataSource(uploadPartRequest, file, inputStream, cipherLiteInputStream, this.log);
                t.endPartUpload();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v0 ??, still in use, count: 1, list:
          (r7v0 ?? I:??[OBJECT, ARRAY]) from 0x0054: MOVE (r4v2 ?? I:??[OBJECT, ARRAY]) = (r7v0 ?? I:??[OBJECT, ARRAY])
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    protected final com.amazonaws.services.s3.internal.crypto.CipherLiteInputStream newMultipartS3CipherInputStream(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v0 ??, still in use, count: 1, list:
          (r7v0 ?? I:??[OBJECT, ARRAY]) from 0x0054: MOVE (r4v2 ?? I:??[OBJECT, ARRAY]) = (r7v0 ?? I:??[OBJECT, ARRAY])
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r13v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:88)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public CompleteMultipartUploadResult completeMultipartUploadSecurely(CompleteMultipartUploadRequest completeMultipartUploadRequest) {
        appendUserAgent(completeMultipartUploadRequest, AmazonS3EncryptionClient.USER_AGENT);
        String uploadId = completeMultipartUploadRequest.getUploadId();
        T t = this.multipartUploadContexts.get(uploadId);
        if (t != null && !t.hasFinalPartBeenSeen()) {
            throw new AmazonClientException("Unable to complete an encrypted multipart upload without being told which part was the last.  Without knowing which part was the last, the encrypted data in Amazon S3 is incomplete and corrupt.");
        }
        CompleteMultipartUploadResult completeMultipartUploadResultCompleteMultipartUpload = this.s3.completeMultipartUpload(completeMultipartUploadRequest);
        if (t != null && this.cryptoConfig.getStorageMode() == CryptoStorageMode.InstructionFile) {
            this.s3.putObject(createInstructionPutRequest(t.getBucketName(), t.getKey(), t.getContentCryptoMaterial()));
        }
        this.multipartUploadContexts.remove(uploadId);
        return completeMultipartUploadResultCompleteMultipartUpload;
    }

    protected final ObjectMetadata updateMetadataWithContentCryptoMaterial(ObjectMetadata objectMetadata, File file, ContentCryptoMaterial contentCryptoMaterial) {
        if (objectMetadata == null) {
            objectMetadata = new ObjectMetadata();
        }
        if (file != null) {
            objectMetadata.setContentType(Mimetypes.getInstance().getMimetype(file));
        }
        return contentCryptoMaterial.toObjectMetadata(objectMetadata, this.cryptoConfig.getCryptoMode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final ContentCryptoMaterial createContentCryptoMaterial(AmazonWebServiceRequest amazonWebServiceRequest) {
        EncryptionMaterials encryptionMaterials;
        if ((amazonWebServiceRequest instanceof EncryptionMaterialsFactory) && (encryptionMaterials = ((EncryptionMaterialsFactory) amazonWebServiceRequest).getEncryptionMaterials()) != null) {
            return buildContentCryptoMaterial(encryptionMaterials, this.cryptoConfig.getCryptoProvider(), amazonWebServiceRequest);
        }
        if (amazonWebServiceRequest instanceof MaterialsDescriptionProvider) {
            Map<String, String> materialsDescription = ((MaterialsDescriptionProvider) amazonWebServiceRequest).getMaterialsDescription();
            ContentCryptoMaterial contentCryptoMaterialNewContentCryptoMaterial = newContentCryptoMaterial(this.kekMaterialsProvider, materialsDescription, this.cryptoConfig.getCryptoProvider(), amazonWebServiceRequest);
            if (contentCryptoMaterialNewContentCryptoMaterial != null) {
                return contentCryptoMaterialNewContentCryptoMaterial;
            }
            if (materialsDescription != null && !this.kekMaterialsProvider.getEncryptionMaterials().isKMSEnabled()) {
                throw new AmazonClientException("No material available from the encryption material provider for description " + materialsDescription);
            }
        }
        return newContentCryptoMaterial(this.kekMaterialsProvider, this.cryptoConfig.getCryptoProvider(), amazonWebServiceRequest);
    }

    private ContentCryptoMaterial newContentCryptoMaterial(EncryptionMaterialsProvider encryptionMaterialsProvider, Map<String, String> map, Provider provider, AmazonWebServiceRequest amazonWebServiceRequest) {
        EncryptionMaterials encryptionMaterials = encryptionMaterialsProvider.getEncryptionMaterials(map);
        if (encryptionMaterials == null) {
            return null;
        }
        return buildContentCryptoMaterial(encryptionMaterials, provider, amazonWebServiceRequest);
    }

    private ContentCryptoMaterial newContentCryptoMaterial(EncryptionMaterialsProvider encryptionMaterialsProvider, Provider provider, AmazonWebServiceRequest amazonWebServiceRequest) {
        EncryptionMaterials encryptionMaterials = encryptionMaterialsProvider.getEncryptionMaterials();
        if (encryptionMaterials == null) {
            throw new AmazonClientException("No material available from the encryption material provider");
        }
        return buildContentCryptoMaterial(encryptionMaterials, provider, amazonWebServiceRequest);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public final void putLocalObjectSecurely(UploadObjectRequest uploadObjectRequest, String str, OutputStream outputStream) throws IOException {
        UploadObjectRequest uploadObjectRequestMo9801clone = uploadObjectRequest.mo9801clone();
        File file = uploadObjectRequestMo9801clone.getFile();
        InputStream inputStream = uploadObjectRequestMo9801clone.getInputStream();
        T t = this.multipartUploadContexts.get(str);
        UploadObjectRequest uploadObjectRequest2 = (UploadObjectRequest) wrapWithCipher(uploadObjectRequestMo9801clone, t.getContentCryptoMaterial());
        try {
            IOUtils.copy(uploadObjectRequest2.getInputStream(), outputStream);
            t.setHasFinalPartBeenSeen(true);
        } finally {
            S3DataSource.Utils.cleanupDataSource(uploadObjectRequest2, file, inputStream, uploadObjectRequest2.getInputStream(), this.log);
            IOUtils.closeQuietly(outputStream, this.log);
        }
    }

    private ContentCryptoMaterial buildContentCryptoMaterial(EncryptionMaterials encryptionMaterials, Provider provider, AmazonWebServiceRequest amazonWebServiceRequest) throws Throwable {
        byte[] bArr = new byte[this.contentCryptoScheme.getIVLengthInBytes()];
        this.cryptoScheme.getSecureRandom().nextBytes(bArr);
        if (encryptionMaterials.isKMSEnabled()) {
            Map<String, String> mapMergeMaterialDescriptions = ContentCryptoMaterial.mergeMaterialDescriptions(encryptionMaterials, amazonWebServiceRequest);
            GenerateDataKeyRequest generateDataKeyRequestWithKeySpec = new GenerateDataKeyRequest().withEncryptionContext(mapMergeMaterialDescriptions).withKeyId(encryptionMaterials.getCustomerMasterKeyId()).withKeySpec(this.contentCryptoScheme.getKeySpec());
            generateDataKeyRequestWithKeySpec.withGeneralProgressListener(amazonWebServiceRequest.getGeneralProgressListener()).withRequestMetricCollector(amazonWebServiceRequest.getRequestMetricCollector());
            GenerateDataKeyResult generateDataKeyResultGenerateDataKey = this.kms.generateDataKey(generateDataKeyRequestWithKeySpec);
            return ContentCryptoMaterial.wrap(new SecretKeySpec(BinaryUtils.copyAllBytesFrom(generateDataKeyResultGenerateDataKey.getPlaintext()), this.contentCryptoScheme.getKeyGeneratorAlgorithm()), bArr, this.contentCryptoScheme, provider, new KMSSecuredCEK(BinaryUtils.copyAllBytesFrom(generateDataKeyResultGenerateDataKey.getCiphertextBlob()), mapMergeMaterialDescriptions));
        }
        return ContentCryptoMaterial.create(generateCEK(encryptionMaterials, provider), bArr, encryptionMaterials, this.cryptoScheme, provider, this.kms, amazonWebServiceRequest);
    }

    protected final SecretKey generateCEK(EncryptionMaterials encryptionMaterials, Provider provider) {
        KeyGenerator keyGenerator;
        boolean zEquals;
        String keyGeneratorAlgorithm = this.contentCryptoScheme.getKeyGeneratorAlgorithm();
        try {
            if (provider == null) {
                keyGenerator = KeyGenerator.getInstance(keyGeneratorAlgorithm);
            } else {
                keyGenerator = KeyGenerator.getInstance(keyGeneratorAlgorithm, provider);
            }
            keyGenerator.init(this.contentCryptoScheme.getKeyLengthInBits(), this.cryptoScheme.getSecureRandom());
            KeyPair keyPair = encryptionMaterials.getKeyPair();
            if (keyPair == null || this.cryptoScheme.getKeyWrapScheme().getKeyWrapAlgorithm(keyPair.getPublic(), provider) != null) {
                zEquals = false;
            } else {
                Provider provider2 = keyGenerator.getProvider();
                zEquals = BouncyCastleProvider.PROVIDER_NAME.equals(provider2 == null ? null : provider2.getName());
            }
            SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
            if (zEquals && secretKeyGenerateKey.getEncoded()[0] == 0) {
                for (int i = 0; i < 9; i++) {
                    SecretKey secretKeyGenerateKey2 = keyGenerator.generateKey();
                    if (secretKeyGenerateKey2.getEncoded()[0] != 0) {
                        return secretKeyGenerateKey2;
                    }
                }
                throw new AmazonClientException("Failed to generate secret key");
            }
            return secretKeyGenerateKey;
        } catch (NoSuchAlgorithmException e2) {
            throw new AmazonClientException("Unable to generate envelope symmetric key:" + e2.getMessage(), e2);
        }
    }

    protected final <R extends AbstractPutObjectRequest> R wrapWithCipher(R r, ContentCryptoMaterial contentCryptoMaterial) {
        ObjectMetadata metadata = r.getMetadata();
        if (metadata == null) {
            metadata = new ObjectMetadata();
        }
        if (metadata.getContentMD5() != null) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_MD5, metadata.getContentMD5());
        }
        metadata.setContentMD5(null);
        long jPlaintextLength = plaintextLength(r, metadata);
        if (jPlaintextLength >= 0) {
            metadata.addUserMetadata(Headers.UNENCRYPTED_CONTENT_LENGTH, Long.toString(jPlaintextLength));
            metadata.setContentLength(ciphertextLength(jPlaintextLength));
        }
        r.setMetadata(metadata);
        r.setInputStream(newS3CipherLiteInputStream(r, contentCryptoMaterial, jPlaintextLength));
        r.setFile(null);
        return r;
    }

    private CipherLiteInputStream newS3CipherLiteInputStream(AbstractPutObjectRequest abstractPutObjectRequest, ContentCryptoMaterial contentCryptoMaterial, long j) {
        File file = abstractPutObjectRequest.getFile();
        InputStream inputStream = abstractPutObjectRequest.getInputStream();
        InputStream resettableInputStream = null;
        try {
            if (file != null) {
                resettableInputStream = new ResettableInputStream(file);
            } else if (inputStream != null) {
                resettableInputStream = ReleasableInputStream.wrap(inputStream);
            }
            if (j > -1) {
                resettableInputStream = new LengthCheckInputStream(resettableInputStream, j, false);
            }
            CipherLite cipherLite = contentCryptoMaterial.getCipherLite();
            if (cipherLite.markSupported()) {
                return new CipherLiteInputStream(resettableInputStream, cipherLite, 2048);
            }
            return new RenewableCipherLiteInputStream(resettableInputStream, cipherLite, 2048);
        } catch (Exception e2) {
            S3DataSource.Utils.cleanupDataSource(abstractPutObjectRequest, file, inputStream, null, this.log);
            throw new AmazonClientException("Unable to create cipher input stream", e2);
        }
    }

    protected final long plaintextLength(AbstractPutObjectRequest abstractPutObjectRequest, ObjectMetadata objectMetadata) {
        if (abstractPutObjectRequest.getFile() != null) {
            return abstractPutObjectRequest.getFile().length();
        }
        if (abstractPutObjectRequest.getInputStream() == null || objectMetadata.getRawMetadataValue("Content-Length") == null) {
            return -1L;
        }
        return objectMetadata.getContentLength();
    }

    public final S3CryptoScheme getS3CryptoScheme() {
        return this.cryptoScheme;
    }

    protected final PutObjectRequest updateInstructionPutRequest(PutObjectRequest putObjectRequest, ContentCryptoMaterial contentCryptoMaterial) {
        byte[] bytes = contentCryptoMaterial.toJsonString(this.cryptoConfig.getCryptoMode()).getBytes(StringUtils.UTF8);
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        if (metadata == null) {
            metadata = new ObjectMetadata();
            putObjectRequest.setMetadata(metadata);
        }
        metadata.setContentLength(bytes.length);
        metadata.addUserMetadata(Headers.CRYPTO_INSTRUCTION_FILE, "");
        putObjectRequest.setMetadata(metadata);
        putObjectRequest.setInputStream(new ByteArrayInputStream(bytes));
        return putObjectRequest;
    }

    protected final PutObjectRequest createInstructionPutRequest(String str, String str2, ContentCryptoMaterial contentCryptoMaterial) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(contentCryptoMaterial.toJsonString(this.cryptoConfig.getCryptoMode()).getBytes(StringUtils.UTF8));
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(r7.length);
        objectMetadata.addUserMetadata(Headers.CRYPTO_INSTRUCTION_FILE, "");
        InstructionFileId instructionFileId = new S3ObjectId(str, str2).instructionFileId();
        return new PutObjectRequest(instructionFileId.getBucket(), instructionFileId.getKey(), byteArrayInputStream, objectMetadata);
    }

    final <X extends AmazonWebServiceRequest> X appendUserAgent(X x, String str) {
        x.getRequestClientOptions().appendUserAgent(str);
        return x;
    }

    final S3ObjectWrapper fetchInstructionFile(S3ObjectId s3ObjectId, String str) {
        try {
            S3Object object = this.s3.getObject(createInstructionGetRequest(s3ObjectId, str));
            if (object == null) {
                return null;
            }
            return new S3ObjectWrapper(object, s3ObjectId);
        } catch (AmazonServiceException e2) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("Unable to retrieve instruction file : " + e2.getMessage());
            }
            return null;
        }
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public final PutObjectResult putInstructionFileSecurely(PutInstructionFileRequest putInstructionFileRequest) {
        PutInstructionFileRequest putInstructionFileRequest2;
        ContentCryptoMaterial contentCryptoMaterialRecreate;
        S3ObjectId s3ObjectId = putInstructionFileRequest.getS3ObjectId();
        GetObjectRequest getObjectRequest = new GetObjectRequest(s3ObjectId);
        appendUserAgent(getObjectRequest, AmazonS3EncryptionClient.USER_AGENT);
        S3Object object = this.s3.getObject(getObjectRequest);
        IOUtils.closeQuietly(object, this.log);
        if (object == null) {
            throw new IllegalArgumentException("The specified S3 object (" + s3ObjectId + ") doesn't exist.");
        }
        S3ObjectWrapper s3ObjectWrapper = new S3ObjectWrapper(object, s3ObjectId);
        try {
            ContentCryptoMaterial contentCryptoMaterialContentCryptoMaterialOf = contentCryptoMaterialOf(s3ObjectWrapper);
            if (ContentCryptoScheme.AES_GCM.equals(contentCryptoMaterialContentCryptoMaterialOf.getContentCryptoScheme()) && this.cryptoConfig.getCryptoMode() == CryptoMode.EncryptionOnly) {
                throw new SecurityException("Lowering the protection of encryption material is not allowed");
            }
            securityCheck(contentCryptoMaterialContentCryptoMaterialOf, s3ObjectWrapper);
            EncryptionMaterials encryptionMaterials = putInstructionFileRequest.getEncryptionMaterials();
            if (encryptionMaterials == null) {
                putInstructionFileRequest2 = putInstructionFileRequest;
                contentCryptoMaterialRecreate = contentCryptoMaterialContentCryptoMaterialOf.recreate(putInstructionFileRequest.getMaterialsDescription(), this.kekMaterialsProvider, this.cryptoScheme, this.cryptoConfig.getCryptoProvider(), this.kms, putInstructionFileRequest2);
            } else {
                putInstructionFileRequest2 = putInstructionFileRequest;
                contentCryptoMaterialRecreate = contentCryptoMaterialContentCryptoMaterialOf.recreate(encryptionMaterials, this.kekMaterialsProvider, this.cryptoScheme, this.cryptoConfig.getCryptoProvider(), this.kms, putInstructionFileRequest2);
            }
            return this.s3.putObject(updateInstructionPutRequest(putInstructionFileRequest2.createPutObjectRequest(object), contentCryptoMaterialRecreate));
        } catch (Error e2) {
            IOUtils.closeQuietly(object, this.log);
            throw e2;
        } catch (RuntimeException e3) {
            IOUtils.closeQuietly(object, this.log);
            throw e3;
        }
    }

    private ContentCryptoMaterial contentCryptoMaterialOf(S3ObjectWrapper s3ObjectWrapper) {
        if (s3ObjectWrapper.hasEncryptionInfo()) {
            return ContentCryptoMaterial.fromObjectMetadata(s3ObjectWrapper.getObjectMetadata(), this.kekMaterialsProvider, this.cryptoConfig.getCryptoProvider(), false, this.kms);
        }
        S3ObjectWrapper s3ObjectWrapperFetchInstructionFile = fetchInstructionFile(s3ObjectWrapper.getS3ObjectId(), null);
        if (s3ObjectWrapperFetchInstructionFile == null) {
            throw new IllegalArgumentException("S3 object is not encrypted: " + s3ObjectWrapper);
        }
        if (!s3ObjectWrapperFetchInstructionFile.isInstructionFile()) {
            throw new AmazonClientException("Invalid instruction file for S3 object: " + s3ObjectWrapper);
        }
        return ccmFromJson(s3ObjectWrapperFetchInstructionFile.toJsonString());
    }

    private ContentCryptoMaterial ccmFromJson(String str) {
        return ContentCryptoMaterial.fromInstructionFile(Collections.unmodifiableMap(JsonUtils.jsonToMap(str)), this.kekMaterialsProvider, this.cryptoConfig.getCryptoProvider(), false, this.kms);
    }

    final GetObjectRequest createInstructionGetRequest(S3ObjectId s3ObjectId) {
        return createInstructionGetRequest(s3ObjectId, null);
    }

    final GetObjectRequest createInstructionGetRequest(S3ObjectId s3ObjectId, String str) {
        return new GetObjectRequest(s3ObjectId.instructionFileId(str));
    }

    static long[] getAdjustedCryptoRange(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        long j = jArr[0];
        if (j > jArr[1]) {
            return null;
        }
        return new long[]{getCipherBlockLowerBound(j), getCipherBlockUpperBound(jArr[1])};
    }

    private static long getCipherBlockLowerBound(long j) {
        long j2 = (j - (j % 16)) - 16;
        if (j2 < 0) {
            return 0L;
        }
        return j2;
    }

    private static long getCipherBlockUpperBound(long j) {
        long j2 = j + (16 - (j % 16)) + 16;
        if (j2 < 0) {
            return Long.MAX_VALUE;
        }
        return j2;
    }
}
