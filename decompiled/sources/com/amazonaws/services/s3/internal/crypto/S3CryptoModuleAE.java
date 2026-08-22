package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.internal.SdkFilterInputStream;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazonaws.services.s3.internal.S3Direct;
import com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.services.s3.model.EncryptedGetObjectRequest;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.ExtraMaterialsDescription;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectId;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.json.JsonUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
class S3CryptoModuleAE extends S3CryptoModuleBase<MultipartUploadCryptoContext> {
    private static final int BIT_SIZE = 8;
    private static final int DEFAULT_BYTE_SIZE = 10240;

    protected boolean isStrict() {
        return false;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    final void updateUploadContext(MultipartUploadCryptoContext multipartUploadCryptoContext, SdkFilterInputStream sdkFilterInputStream) {
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    final SdkFilterInputStream wrapForMultipart(CipherLiteInputStream cipherLiteInputStream, long j) {
        return cipherLiteInputStream;
    }

    static {
        CryptoRuntime.enableBouncyCastle();
    }

    S3CryptoModuleAE(AWSKMSClient aWSKMSClient, S3Direct s3Direct, AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        super(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, cryptoConfiguration);
        CryptoMode cryptoMode = cryptoConfiguration.getCryptoMode();
        if (cryptoMode != CryptoMode.StrictAuthenticatedEncryption && cryptoMode != CryptoMode.AuthenticatedEncryption) {
            throw new IllegalArgumentException();
        }
    }

    S3CryptoModuleAE(S3Direct s3Direct, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this(null, s3Direct, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfiguration);
    }

    S3CryptoModuleAE(AWSKMSClient aWSKMSClient, S3Direct s3Direct, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this(aWSKMSClient, s3Direct, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfiguration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.amazonaws.services.s3.internal.crypto.S3CryptoModuleAE] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.amazonaws.services.s3.internal.crypto.S3CryptoModuleAE] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public S3Object getObjectSecurely(GetObjectRequest getObjectRequest) {
        appendUserAgent(getObjectRequest, AmazonS3EncryptionClient.USER_AGENT);
        long[] range = getObjectRequest.getRange();
        if (isStrict() && (range != null || getObjectRequest.getPartNumber() != null)) {
            throw new SecurityException("Range get and getting a part are not allowed in strict crypto mode");
        }
        long[] adjustedCryptoRange = getAdjustedCryptoRange(range);
        if (adjustedCryptoRange != null) {
            getObjectRequest.setRange(adjustedCryptoRange[0], adjustedCryptoRange[1]);
        }
        S3Object object = this.s3.getObject(getObjectRequest);
        if (object == null) {
            return null;
        }
        ?? r1 = getObjectRequest instanceof EncryptedGetObjectRequest;
        String instructionFileSuffix = r1 != 0 ? ((EncryptedGetObjectRequest) getObjectRequest).getInstructionFileSuffix() : null;
        try {
            if (instructionFileSuffix != null) {
                try {
                    if (!instructionFileSuffix.trim().isEmpty()) {
                        return decipherWithInstFileSuffix(getObjectRequest, range, adjustedCryptoRange, object, instructionFileSuffix);
                    }
                } catch (Error e2) {
                    e = e2;
                    r1 = this;
                    Error error = e;
                    IOUtils.closeQuietly(object, r1.log);
                    throw error;
                } catch (RuntimeException e3) {
                    e = e3;
                    r1 = this;
                    RuntimeException runtimeException = e;
                    IOUtils.closeQuietly(object, r1.log);
                    throw runtimeException;
                }
            }
            return decipher(getObjectRequest, range, adjustedCryptoRange, object);
        } catch (Error e4) {
            e = e4;
        } catch (RuntimeException e5) {
            e = e5;
        }
    }

    private S3Object decipher(GetObjectRequest getObjectRequest, long[] jArr, long[] jArr2, S3Object s3Object) throws Throwable {
        S3CryptoModuleAE s3CryptoModuleAE;
        S3CryptoModuleAE s3CryptoModuleAE2;
        long[] jArr3;
        S3ObjectWrapper s3ObjectWrapper = new S3ObjectWrapper(s3Object, getObjectRequest.getS3ObjectId());
        if (s3ObjectWrapper.hasEncryptionInfo()) {
            return decipherWithMetadata(getObjectRequest, jArr, jArr2, s3ObjectWrapper);
        }
        S3ObjectWrapper s3ObjectWrapperFetchInstructionFile = fetchInstructionFile(getObjectRequest.getS3ObjectId(), null);
        if (s3ObjectWrapperFetchInstructionFile != null) {
            try {
                if (s3ObjectWrapperFetchInstructionFile.isInstructionFile()) {
                    s3CryptoModuleAE = this;
                    try {
                        S3Object s3ObjectDecipherWithInstructionFile = s3CryptoModuleAE.decipherWithInstructionFile(getObjectRequest, jArr, jArr2, s3ObjectWrapper, s3ObjectWrapperFetchInstructionFile);
                        IOUtils.closeQuietly(s3ObjectWrapperFetchInstructionFile, s3CryptoModuleAE.log);
                        return s3ObjectDecipherWithInstructionFile;
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        IOUtils.closeQuietly(s3ObjectWrapperFetchInstructionFile, s3CryptoModuleAE.log);
                        throw th2;
                    }
                }
                s3CryptoModuleAE2 = this;
                jArr3 = jArr;
                IOUtils.closeQuietly(s3ObjectWrapperFetchInstructionFile, s3CryptoModuleAE2.log);
            } catch (Throwable th3) {
                th = th3;
                s3CryptoModuleAE = this;
            }
        } else {
            s3CryptoModuleAE2 = this;
            jArr3 = jArr;
        }
        if (isStrict() || !s3CryptoModuleAE2.cryptoConfig.isIgnoreMissingInstructionFile()) {
            IOUtils.closeQuietly(s3ObjectWrapper, s3CryptoModuleAE2.log);
            throw new SecurityException("Instruction file not found for S3 object with bucket name: " + s3Object.getBucketName() + ", key: " + s3Object.getKey());
        }
        s3CryptoModuleAE2.log.warn(String.format("Unable to detect encryption information for object '%s' in bucket '%s'. Returning object without decryption.", s3Object.getKey(), s3Object.getBucketName()));
        return adjustToDesiredRange(s3ObjectWrapper, jArr3, null).getS3Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.amazonaws.services.s3.internal.crypto.S3CryptoModuleAE] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    private S3Object decipherWithInstFileSuffix(GetObjectRequest getObjectRequest, long[] jArr, long[] jArr2, S3Object s3Object, String str) throws Throwable {
        ?? IsInstructionFile;
        S3ObjectId s3ObjectId = getObjectRequest.getS3ObjectId();
        S3ObjectWrapper s3ObjectWrapperFetchInstructionFile = fetchInstructionFile(s3ObjectId, str);
        if (s3ObjectWrapperFetchInstructionFile == null) {
            throw new AmazonClientException("Instruction file with suffix " + str + " is not found for " + s3Object);
        }
        try {
            IsInstructionFile = s3ObjectWrapperFetchInstructionFile.isInstructionFile();
            try {
                if (IsInstructionFile != 0) {
                    S3Object s3ObjectDecipherWithInstructionFile = decipherWithInstructionFile(getObjectRequest, jArr, jArr2, new S3ObjectWrapper(s3Object, s3ObjectId), s3ObjectWrapperFetchInstructionFile);
                    IOUtils.closeQuietly(s3ObjectWrapperFetchInstructionFile, this.log);
                    return s3ObjectDecipherWithInstructionFile;
                }
                throw new AmazonClientException("Invalid Instruction file with suffix " + str + " detected for " + s3Object);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            IsInstructionFile = this;
        }
        Throwable th3 = th;
        IOUtils.closeQuietly(s3ObjectWrapperFetchInstructionFile, IsInstructionFile.log);
        throw th3;
    }

    private S3Object decipherWithInstructionFile(GetObjectRequest getObjectRequest, long[] jArr, long[] jArr2, S3ObjectWrapper s3ObjectWrapper, S3ObjectWrapper s3ObjectWrapper2) {
        ExtraMaterialsDescription extraMaterialDescription = ExtraMaterialsDescription.NONE;
        boolean zIsStrict = isStrict();
        if (getObjectRequest instanceof EncryptedGetObjectRequest) {
            EncryptedGetObjectRequest encryptedGetObjectRequest = (EncryptedGetObjectRequest) getObjectRequest;
            extraMaterialDescription = encryptedGetObjectRequest.getExtraMaterialDescription();
            if (!zIsStrict) {
                zIsStrict = encryptedGetObjectRequest.isKeyWrapExpected();
            }
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(JsonUtils.jsonToMap(s3ObjectWrapper2.toJsonString()));
        ContentCryptoMaterial contentCryptoMaterialFromInstructionFile = ContentCryptoMaterial.fromInstructionFile(mapUnmodifiableMap, this.kekMaterialsProvider, this.cryptoConfig.getCryptoProvider(), jArr2, extraMaterialDescription, zIsStrict, this.kms);
        securityCheck(contentCryptoMaterialFromInstructionFile, s3ObjectWrapper);
        return adjustToDesiredRange(decrypt(s3ObjectWrapper, contentCryptoMaterialFromInstructionFile, jArr2), jArr, mapUnmodifiableMap).getS3Object();
    }

    private S3Object decipherWithMetadata(GetObjectRequest getObjectRequest, long[] jArr, long[] jArr2, S3ObjectWrapper s3ObjectWrapper) {
        ExtraMaterialsDescription extraMaterialDescription = ExtraMaterialsDescription.NONE;
        boolean zIsStrict = isStrict();
        if (getObjectRequest instanceof EncryptedGetObjectRequest) {
            EncryptedGetObjectRequest encryptedGetObjectRequest = (EncryptedGetObjectRequest) getObjectRequest;
            extraMaterialDescription = encryptedGetObjectRequest.getExtraMaterialDescription();
            if (!zIsStrict) {
                zIsStrict = encryptedGetObjectRequest.isKeyWrapExpected();
            }
        }
        ContentCryptoMaterial contentCryptoMaterialFromObjectMetadata = ContentCryptoMaterial.fromObjectMetadata(s3ObjectWrapper.getObjectMetadata(), this.kekMaterialsProvider, this.cryptoConfig.getCryptoProvider(), jArr2, extraMaterialDescription, zIsStrict, this.kms);
        securityCheck(contentCryptoMaterialFromObjectMetadata, s3ObjectWrapper);
        return adjustToDesiredRange(decrypt(s3ObjectWrapper, contentCryptoMaterialFromObjectMetadata, jArr2), jArr, null).getS3Object();
    }

    protected final S3ObjectWrapper adjustToDesiredRange(S3ObjectWrapper s3ObjectWrapper, long[] jArr, Map<String, String> map) {
        if (jArr != null) {
            long instanceLength = (s3ObjectWrapper.getObjectMetadata().getInstanceLength() - ((long) (s3ObjectWrapper.encryptionSchemeOf(map).getTagLengthInBits() / 8))) - 1;
            if (jArr[1] > instanceLength) {
                jArr[1] = instanceLength;
                if (jArr[0] > instanceLength) {
                    IOUtils.closeQuietly(s3ObjectWrapper.getObjectContent(), this.log);
                    s3ObjectWrapper.setObjectContent(new ByteArrayInputStream(new byte[0]));
                    return s3ObjectWrapper;
                }
            }
            if (jArr[0] <= jArr[1]) {
                try {
                    S3ObjectInputStream objectContent = s3ObjectWrapper.getObjectContent();
                    s3ObjectWrapper.setObjectContent(new S3ObjectInputStream(new AdjustedRangeInputStream(objectContent, jArr[0], jArr[1]), objectContent.getHttpRequest()));
                    return s3ObjectWrapper;
                } catch (IOException e2) {
                    throw new AmazonClientException("Error adjusting output to desired byte range: " + e2.getMessage());
                }
            }
        }
        return s3ObjectWrapper;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public ObjectMetadata getObjectSecurely(GetObjectRequest getObjectRequest, File file) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        assertParameterNotNull(file, "The destination file parameter must be specified when downloading an object directly to a file");
        S3Object objectSecurely = getObjectSecurely(getObjectRequest);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            if (objectSecurely == null) {
                return null;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (IOException e2) {
                e = e2;
            }
            try {
                byte[] bArr = new byte[10240];
                while (true) {
                    int i = objectSecurely.getObjectContent().read(bArr);
                    if (i > -1) {
                        bufferedOutputStream.write(bArr, 0, i);
                    } else {
                        IOUtils.closeQuietly(bufferedOutputStream, this.log);
                        IOUtils.closeQuietly(objectSecurely.getObjectContent(), this.log);
                        return objectSecurely.getObjectMetadata();
                    }
                }
            } catch (IOException e3) {
                e = e3;
                throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream2 = bufferedOutputStream;
                IOUtils.closeQuietly(bufferedOutputStream2, this.log);
                IOUtils.closeQuietly(objectSecurely.getObjectContent(), this.log);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    final MultipartUploadCryptoContext newUploadContext(InitiateMultipartUploadRequest initiateMultipartUploadRequest, ContentCryptoMaterial contentCryptoMaterial) {
        return new MultipartUploadCryptoContext(initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey(), contentCryptoMaterial);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    final CipherLite cipherLiteForNextPart(MultipartUploadCryptoContext multipartUploadCryptoContext) {
        return multipartUploadCryptoContext.getCipherLite();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    final long computeLastPartSize(UploadPartRequest uploadPartRequest) {
        return uploadPartRequest.getPartSize() + ((long) (this.contentCryptoScheme.getTagLengthInBits() / 8));
    }

    private S3ObjectWrapper decrypt(S3ObjectWrapper s3ObjectWrapper, ContentCryptoMaterial contentCryptoMaterial, long[] jArr) {
        S3ObjectInputStream objectContent = s3ObjectWrapper.getObjectContent();
        s3ObjectWrapper.setObjectContent(new S3ObjectInputStream(new CipherLiteInputStream(objectContent, contentCryptoMaterial.getCipherLite(), 2048), objectContent.getHttpRequest()));
        return s3ObjectWrapper;
    }

    private void assertParameterNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    protected final long ciphertextLength(long j) {
        return j + ((long) (this.contentCryptoScheme.getTagLengthInBits() / 8));
    }
}
