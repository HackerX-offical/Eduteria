package com.amazonaws.services.kms;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.JsonResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.services.kms.model.CancelKeyDeletionRequest;
import com.amazonaws.services.kms.model.CancelKeyDeletionResult;
import com.amazonaws.services.kms.model.ConnectCustomKeyStoreRequest;
import com.amazonaws.services.kms.model.ConnectCustomKeyStoreResult;
import com.amazonaws.services.kms.model.CreateAliasRequest;
import com.amazonaws.services.kms.model.CreateCustomKeyStoreRequest;
import com.amazonaws.services.kms.model.CreateCustomKeyStoreResult;
import com.amazonaws.services.kms.model.CreateGrantRequest;
import com.amazonaws.services.kms.model.CreateGrantResult;
import com.amazonaws.services.kms.model.CreateKeyRequest;
import com.amazonaws.services.kms.model.CreateKeyResult;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.DecryptResult;
import com.amazonaws.services.kms.model.DeleteAliasRequest;
import com.amazonaws.services.kms.model.DeleteCustomKeyStoreRequest;
import com.amazonaws.services.kms.model.DeleteCustomKeyStoreResult;
import com.amazonaws.services.kms.model.DeleteImportedKeyMaterialRequest;
import com.amazonaws.services.kms.model.DescribeCustomKeyStoresRequest;
import com.amazonaws.services.kms.model.DescribeCustomKeyStoresResult;
import com.amazonaws.services.kms.model.DescribeKeyRequest;
import com.amazonaws.services.kms.model.DescribeKeyResult;
import com.amazonaws.services.kms.model.DisableKeyRequest;
import com.amazonaws.services.kms.model.DisableKeyRotationRequest;
import com.amazonaws.services.kms.model.DisconnectCustomKeyStoreRequest;
import com.amazonaws.services.kms.model.DisconnectCustomKeyStoreResult;
import com.amazonaws.services.kms.model.EnableKeyRequest;
import com.amazonaws.services.kms.model.EnableKeyRotationRequest;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.amazonaws.services.kms.model.EncryptResult;
import com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import com.amazonaws.services.kms.model.GenerateDataKeyResult;
import com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextRequest;
import com.amazonaws.services.kms.model.GenerateDataKeyWithoutPlaintextResult;
import com.amazonaws.services.kms.model.GenerateRandomRequest;
import com.amazonaws.services.kms.model.GenerateRandomResult;
import com.amazonaws.services.kms.model.GetKeyPolicyRequest;
import com.amazonaws.services.kms.model.GetKeyPolicyResult;
import com.amazonaws.services.kms.model.GetKeyRotationStatusRequest;
import com.amazonaws.services.kms.model.GetKeyRotationStatusResult;
import com.amazonaws.services.kms.model.GetParametersForImportRequest;
import com.amazonaws.services.kms.model.GetParametersForImportResult;
import com.amazonaws.services.kms.model.ImportKeyMaterialRequest;
import com.amazonaws.services.kms.model.ImportKeyMaterialResult;
import com.amazonaws.services.kms.model.ListAliasesRequest;
import com.amazonaws.services.kms.model.ListAliasesResult;
import com.amazonaws.services.kms.model.ListGrantsRequest;
import com.amazonaws.services.kms.model.ListGrantsResult;
import com.amazonaws.services.kms.model.ListKeyPoliciesRequest;
import com.amazonaws.services.kms.model.ListKeyPoliciesResult;
import com.amazonaws.services.kms.model.ListKeysRequest;
import com.amazonaws.services.kms.model.ListKeysResult;
import com.amazonaws.services.kms.model.ListResourceTagsRequest;
import com.amazonaws.services.kms.model.ListResourceTagsResult;
import com.amazonaws.services.kms.model.ListRetirableGrantsRequest;
import com.amazonaws.services.kms.model.ListRetirableGrantsResult;
import com.amazonaws.services.kms.model.PutKeyPolicyRequest;
import com.amazonaws.services.kms.model.ReEncryptRequest;
import com.amazonaws.services.kms.model.ReEncryptResult;
import com.amazonaws.services.kms.model.RetireGrantRequest;
import com.amazonaws.services.kms.model.RevokeGrantRequest;
import com.amazonaws.services.kms.model.ScheduleKeyDeletionRequest;
import com.amazonaws.services.kms.model.ScheduleKeyDeletionResult;
import com.amazonaws.services.kms.model.TagResourceRequest;
import com.amazonaws.services.kms.model.UntagResourceRequest;
import com.amazonaws.services.kms.model.UpdateAliasRequest;
import com.amazonaws.services.kms.model.UpdateCustomKeyStoreRequest;
import com.amazonaws.services.kms.model.UpdateCustomKeyStoreResult;
import com.amazonaws.services.kms.model.UpdateKeyDescriptionRequest;
import com.amazonaws.services.kms.model.transform.AlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CancelKeyDeletionRequestMarshaller;
import com.amazonaws.services.kms.model.transform.CancelKeyDeletionResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterInUseExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterInvalidConfigurationExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterNotActiveExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterNotFoundExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CloudHsmClusterNotRelatedExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.ConnectCustomKeyStoreRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ConnectCustomKeyStoreResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.CreateAliasRequestMarshaller;
import com.amazonaws.services.kms.model.transform.CreateCustomKeyStoreRequestMarshaller;
import com.amazonaws.services.kms.model.transform.CreateCustomKeyStoreResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.CreateGrantRequestMarshaller;
import com.amazonaws.services.kms.model.transform.CreateGrantResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.CreateKeyRequestMarshaller;
import com.amazonaws.services.kms.model.transform.CreateKeyResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreHasCMKsExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreInvalidStateExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreNameInUseExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.CustomKeyStoreNotFoundExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.DecryptRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DecryptResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.DeleteAliasRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DeleteCustomKeyStoreRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DeleteCustomKeyStoreResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.DeleteImportedKeyMaterialRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DependencyTimeoutExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.DescribeCustomKeyStoresRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DescribeCustomKeyStoresResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.DescribeKeyRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DescribeKeyResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.DisableKeyRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DisableKeyRotationRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DisabledExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.DisconnectCustomKeyStoreRequestMarshaller;
import com.amazonaws.services.kms.model.transform.DisconnectCustomKeyStoreResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.EnableKeyRequestMarshaller;
import com.amazonaws.services.kms.model.transform.EnableKeyRotationRequestMarshaller;
import com.amazonaws.services.kms.model.transform.EncryptRequestMarshaller;
import com.amazonaws.services.kms.model.transform.EncryptResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.ExpiredImportTokenExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.GenerateDataKeyRequestMarshaller;
import com.amazonaws.services.kms.model.transform.GenerateDataKeyResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.GenerateDataKeyWithoutPlaintextRequestMarshaller;
import com.amazonaws.services.kms.model.transform.GenerateDataKeyWithoutPlaintextResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.GenerateRandomRequestMarshaller;
import com.amazonaws.services.kms.model.transform.GenerateRandomResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.GetKeyPolicyRequestMarshaller;
import com.amazonaws.services.kms.model.transform.GetKeyPolicyResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.GetKeyRotationStatusRequestMarshaller;
import com.amazonaws.services.kms.model.transform.GetKeyRotationStatusResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.GetParametersForImportRequestMarshaller;
import com.amazonaws.services.kms.model.transform.GetParametersForImportResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.ImportKeyMaterialRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ImportKeyMaterialResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.IncorrectKeyMaterialExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.IncorrectTrustAnchorExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidAliasNameExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidArnExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidCiphertextExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidGrantIdExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidGrantTokenExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidImportTokenExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidKeyUsageExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.InvalidMarkerExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KMSInternalExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KMSInvalidStateExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.KeyUnavailableExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.ListAliasesRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ListAliasesResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.ListGrantsRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ListGrantsResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.ListKeyPoliciesRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ListKeyPoliciesResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.ListKeysRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ListKeysResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.ListResourceTagsRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ListResourceTagsResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.ListRetirableGrantsRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ListRetirableGrantsResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.MalformedPolicyDocumentExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.NotFoundExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.PutKeyPolicyRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ReEncryptRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ReEncryptResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.RetireGrantRequestMarshaller;
import com.amazonaws.services.kms.model.transform.RevokeGrantRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ScheduleKeyDeletionRequestMarshaller;
import com.amazonaws.services.kms.model.transform.ScheduleKeyDeletionResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.TagExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.TagResourceRequestMarshaller;
import com.amazonaws.services.kms.model.transform.UnsupportedOperationExceptionUnmarshaller;
import com.amazonaws.services.kms.model.transform.UntagResourceRequestMarshaller;
import com.amazonaws.services.kms.model.transform.UpdateAliasRequestMarshaller;
import com.amazonaws.services.kms.model.transform.UpdateCustomKeyStoreRequestMarshaller;
import com.amazonaws.services.kms.model.transform.UpdateCustomKeyStoreResultJsonUnmarshaller;
import com.amazonaws.services.kms.model.transform.UpdateKeyDescriptionRequestMarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AWSKMSClient extends AmazonWebServiceClient implements AWSKMS {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    @Deprecated
    public AWSKMSClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public AWSKMSClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AWSKMSClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AWSKMSClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AWSKMSClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AWSKMSClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AWSKMSClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AWSKMSClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        ArrayList arrayList = new ArrayList();
        this.jsonErrorUnmarshallers = arrayList;
        arrayList.add(new AlreadyExistsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CloudHsmClusterInUseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CloudHsmClusterInvalidConfigurationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CloudHsmClusterNotActiveExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CloudHsmClusterNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CloudHsmClusterNotRelatedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CustomKeyStoreHasCMKsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CustomKeyStoreInvalidStateExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CustomKeyStoreNameInUseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new CustomKeyStoreNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new DependencyTimeoutExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new DisabledExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ExpiredImportTokenExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new IncorrectKeyMaterialExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new IncorrectTrustAnchorExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidAliasNameExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidArnExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidCiphertextExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidGrantIdExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidGrantTokenExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidImportTokenExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidKeyUsageExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidMarkerExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new KMSInternalExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new KMSInvalidStateExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new KeyUnavailableExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new MalformedPolicyDocumentExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new NotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TagExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new UnsupportedOperationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("kms.us-east-1.amazonaws.com");
        this.endpointPrefix = "kms";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/kms/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/kms/request.handler2s"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public CancelKeyDeletionResult cancelKeyDeletion(CancelKeyDeletionRequest cancelKeyDeletionRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(cancelKeyDeletionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<CancelKeyDeletionRequest> requestMarshall = new CancelKeyDeletionRequestMarshaller().marshall(cancelKeyDeletionRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new CancelKeyDeletionResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        CancelKeyDeletionResult cancelKeyDeletionResult = (CancelKeyDeletionResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return cancelKeyDeletionResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = cancelKeyDeletionRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public ConnectCustomKeyStoreResult connectCustomKeyStore(ConnectCustomKeyStoreRequest connectCustomKeyStoreRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(connectCustomKeyStoreRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ConnectCustomKeyStoreRequest> requestMarshall = new ConnectCustomKeyStoreRequestMarshaller().marshall(connectCustomKeyStoreRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ConnectCustomKeyStoreResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ConnectCustomKeyStoreResult connectCustomKeyStoreResult = (ConnectCustomKeyStoreResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return connectCustomKeyStoreResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = connectCustomKeyStoreRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.CreateAliasRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void createAlias(CreateAliasRequest createAliasRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(createAliasRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<CreateAliasRequest> requestMarshall = new CreateAliasRequestMarshaller().marshall((CreateAliasRequest) createAliasRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, createAliasRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            createAliasRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, createAliasRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public CreateCustomKeyStoreResult createCustomKeyStore(CreateCustomKeyStoreRequest createCustomKeyStoreRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(createCustomKeyStoreRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<CreateCustomKeyStoreRequest> requestMarshall = new CreateCustomKeyStoreRequestMarshaller().marshall(createCustomKeyStoreRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new CreateCustomKeyStoreResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        CreateCustomKeyStoreResult createCustomKeyStoreResult = (CreateCustomKeyStoreResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return createCustomKeyStoreResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = createCustomKeyStoreRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public CreateGrantResult createGrant(CreateGrantRequest createGrantRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(createGrantRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<CreateGrantRequest> requestMarshall2 = new CreateGrantRequestMarshaller().marshall(createGrantRequest);
                    try {
                        requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall2, new JsonResponseHandler(new CreateGrantResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        CreateGrantResult createGrantResult = (CreateGrantResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall2, responseInvoke, true);
                        return createGrantResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = createGrantRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public CreateKeyResult createKey(CreateKeyRequest createKeyRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(createKeyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<CreateKeyRequest> requestMarshall2 = new CreateKeyRequestMarshaller().marshall(createKeyRequest);
                    try {
                        requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall2, new JsonResponseHandler(new CreateKeyResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        CreateKeyResult createKeyResult = (CreateKeyResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall2, responseInvoke, true);
                        return createKeyResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = createKeyRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public DecryptResult decrypt(DecryptRequest decryptRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(decryptRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DecryptRequest> requestMarshall = new DecryptRequestMarshaller().marshall(decryptRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DecryptResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DecryptResult decryptResult = (DecryptResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return decryptResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = decryptRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.DeleteAliasRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void deleteAlias(DeleteAliasRequest deleteAliasRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(deleteAliasRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DeleteAliasRequest> requestMarshall = new DeleteAliasRequestMarshaller().marshall((DeleteAliasRequest) deleteAliasRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, deleteAliasRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            deleteAliasRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, deleteAliasRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public DeleteCustomKeyStoreResult deleteCustomKeyStore(DeleteCustomKeyStoreRequest deleteCustomKeyStoreRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(deleteCustomKeyStoreRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DeleteCustomKeyStoreRequest> requestMarshall = new DeleteCustomKeyStoreRequestMarshaller().marshall(deleteCustomKeyStoreRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DeleteCustomKeyStoreResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DeleteCustomKeyStoreResult deleteCustomKeyStoreResult = (DeleteCustomKeyStoreResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return deleteCustomKeyStoreResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = deleteCustomKeyStoreRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.DeleteImportedKeyMaterialRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void deleteImportedKeyMaterial(DeleteImportedKeyMaterialRequest deleteImportedKeyMaterialRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(deleteImportedKeyMaterialRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DeleteImportedKeyMaterialRequest> requestMarshall = new DeleteImportedKeyMaterialRequestMarshaller().marshall((DeleteImportedKeyMaterialRequest) deleteImportedKeyMaterialRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, deleteImportedKeyMaterialRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            deleteImportedKeyMaterialRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, deleteImportedKeyMaterialRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public DescribeCustomKeyStoresResult describeCustomKeyStores(DescribeCustomKeyStoresRequest describeCustomKeyStoresRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeCustomKeyStoresRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeCustomKeyStoresRequest> requestMarshall = new DescribeCustomKeyStoresRequestMarshaller().marshall(describeCustomKeyStoresRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeCustomKeyStoresResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeCustomKeyStoresResult describeCustomKeyStoresResult = (DescribeCustomKeyStoresResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeCustomKeyStoresResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = describeCustomKeyStoresRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public DescribeKeyResult describeKey(DescribeKeyRequest describeKeyRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeKeyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeKeyRequest> requestMarshall = new DescribeKeyRequestMarshaller().marshall(describeKeyRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeKeyResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeKeyResult describeKeyResult = (DescribeKeyResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeKeyResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = describeKeyRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.DisableKeyRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void disableKey(DisableKeyRequest disableKeyRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(disableKeyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DisableKeyRequest> requestMarshall = new DisableKeyRequestMarshaller().marshall((DisableKeyRequest) disableKeyRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, disableKeyRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            disableKeyRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, disableKeyRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.DisableKeyRotationRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void disableKeyRotation(DisableKeyRotationRequest disableKeyRotationRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(disableKeyRotationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DisableKeyRotationRequest> requestMarshall = new DisableKeyRotationRequestMarshaller().marshall((DisableKeyRotationRequest) disableKeyRotationRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, disableKeyRotationRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            disableKeyRotationRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, disableKeyRotationRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public DisconnectCustomKeyStoreResult disconnectCustomKeyStore(DisconnectCustomKeyStoreRequest disconnectCustomKeyStoreRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(disconnectCustomKeyStoreRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DisconnectCustomKeyStoreRequest> requestMarshall = new DisconnectCustomKeyStoreRequestMarshaller().marshall(disconnectCustomKeyStoreRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DisconnectCustomKeyStoreResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DisconnectCustomKeyStoreResult disconnectCustomKeyStoreResult = (DisconnectCustomKeyStoreResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return disconnectCustomKeyStoreResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = disconnectCustomKeyStoreRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.EnableKeyRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void enableKey(EnableKeyRequest enableKeyRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(enableKeyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<EnableKeyRequest> requestMarshall = new EnableKeyRequestMarshaller().marshall((EnableKeyRequest) enableKeyRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, enableKeyRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            enableKeyRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, enableKeyRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.EnableKeyRotationRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void enableKeyRotation(EnableKeyRotationRequest enableKeyRotationRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(enableKeyRotationRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<EnableKeyRotationRequest> requestMarshall = new EnableKeyRotationRequestMarshaller().marshall((EnableKeyRotationRequest) enableKeyRotationRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, enableKeyRotationRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            enableKeyRotationRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, enableKeyRotationRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public EncryptResult encrypt(EncryptRequest encryptRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(encryptRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<EncryptRequest> requestMarshall = new EncryptRequestMarshaller().marshall(encryptRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new EncryptResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        EncryptResult encryptResult = (EncryptResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return encryptResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = encryptRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public GenerateDataKeyResult generateDataKey(GenerateDataKeyRequest generateDataKeyRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(generateDataKeyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<GenerateDataKeyRequest> requestMarshall = new GenerateDataKeyRequestMarshaller().marshall(generateDataKeyRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new GenerateDataKeyResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GenerateDataKeyResult generateDataKeyResult = (GenerateDataKeyResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return generateDataKeyResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = generateDataKeyRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public GenerateDataKeyWithoutPlaintextResult generateDataKeyWithoutPlaintext(GenerateDataKeyWithoutPlaintextRequest generateDataKeyWithoutPlaintextRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(generateDataKeyWithoutPlaintextRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<GenerateDataKeyWithoutPlaintextRequest> requestMarshall = new GenerateDataKeyWithoutPlaintextRequestMarshaller().marshall(generateDataKeyWithoutPlaintextRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new GenerateDataKeyWithoutPlaintextResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GenerateDataKeyWithoutPlaintextResult generateDataKeyWithoutPlaintextResult = (GenerateDataKeyWithoutPlaintextResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return generateDataKeyWithoutPlaintextResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = generateDataKeyWithoutPlaintextRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public GenerateRandomResult generateRandom(GenerateRandomRequest generateRandomRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(generateRandomRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<GenerateRandomRequest> requestMarshall = new GenerateRandomRequestMarshaller().marshall(generateRandomRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new GenerateRandomResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GenerateRandomResult generateRandomResult = (GenerateRandomResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return generateRandomResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = generateRandomRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public GetKeyPolicyResult getKeyPolicy(GetKeyPolicyRequest getKeyPolicyRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getKeyPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<GetKeyPolicyRequest> requestMarshall = new GetKeyPolicyRequestMarshaller().marshall(getKeyPolicyRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new GetKeyPolicyResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GetKeyPolicyResult getKeyPolicyResult = (GetKeyPolicyResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return getKeyPolicyResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = getKeyPolicyRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public GetKeyRotationStatusResult getKeyRotationStatus(GetKeyRotationStatusRequest getKeyRotationStatusRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getKeyRotationStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<GetKeyRotationStatusRequest> requestMarshall = new GetKeyRotationStatusRequestMarshaller().marshall(getKeyRotationStatusRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new GetKeyRotationStatusResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GetKeyRotationStatusResult getKeyRotationStatusResult = (GetKeyRotationStatusResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return getKeyRotationStatusResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = getKeyRotationStatusRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public GetParametersForImportResult getParametersForImport(GetParametersForImportRequest getParametersForImportRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getParametersForImportRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<GetParametersForImportRequest> requestMarshall2 = new GetParametersForImportRequestMarshaller().marshall(getParametersForImportRequest);
                    try {
                        requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall2, new JsonResponseHandler(new GetParametersForImportResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GetParametersForImportResult getParametersForImportResult = (GetParametersForImportResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall2, responseInvoke, true);
                        return getParametersForImportResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = getParametersForImportRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public ImportKeyMaterialResult importKeyMaterial(ImportKeyMaterialRequest importKeyMaterialRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(importKeyMaterialRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ImportKeyMaterialRequest> requestMarshall = new ImportKeyMaterialRequestMarshaller().marshall(importKeyMaterialRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ImportKeyMaterialResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ImportKeyMaterialResult importKeyMaterialResult = (ImportKeyMaterialResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return importKeyMaterialResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = importKeyMaterialRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public ListAliasesResult listAliases(ListAliasesRequest listAliasesRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listAliasesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ListAliasesRequest> requestMarshall = new ListAliasesRequestMarshaller().marshall(listAliasesRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListAliasesResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListAliasesResult listAliasesResult = (ListAliasesResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listAliasesResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = listAliasesRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public ListGrantsResult listGrants(ListGrantsRequest listGrantsRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listGrantsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ListGrantsRequest> requestMarshall = new ListGrantsRequestMarshaller().marshall(listGrantsRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListGrantsResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListGrantsResult listGrantsResult = (ListGrantsResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listGrantsResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = listGrantsRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public ListKeyPoliciesResult listKeyPolicies(ListKeyPoliciesRequest listKeyPoliciesRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listKeyPoliciesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ListKeyPoliciesRequest> requestMarshall = new ListKeyPoliciesRequestMarshaller().marshall(listKeyPoliciesRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListKeyPoliciesResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListKeyPoliciesResult listKeyPoliciesResult = (ListKeyPoliciesResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listKeyPoliciesResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = listKeyPoliciesRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public ListKeysResult listKeys(ListKeysRequest listKeysRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listKeysRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ListKeysRequest> requestMarshall = new ListKeysRequestMarshaller().marshall(listKeysRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListKeysResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListKeysResult listKeysResult = (ListKeysResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listKeysResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = listKeysRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public ListResourceTagsResult listResourceTags(ListResourceTagsRequest listResourceTagsRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listResourceTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ListResourceTagsRequest> requestMarshall = new ListResourceTagsRequestMarshaller().marshall(listResourceTagsRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListResourceTagsResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListResourceTagsResult listResourceTagsResult = (ListResourceTagsResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listResourceTagsResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = listResourceTagsRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public ListRetirableGrantsResult listRetirableGrants(ListRetirableGrantsRequest listRetirableGrantsRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listRetirableGrantsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ListRetirableGrantsRequest> requestMarshall = new ListRetirableGrantsRequestMarshaller().marshall(listRetirableGrantsRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListRetirableGrantsResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListRetirableGrantsResult listRetirableGrantsResult = (ListRetirableGrantsResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listRetirableGrantsResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = listRetirableGrantsRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.PutKeyPolicyRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void putKeyPolicy(PutKeyPolicyRequest putKeyPolicyRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(putKeyPolicyRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<PutKeyPolicyRequest> requestMarshall = new PutKeyPolicyRequestMarshaller().marshall((PutKeyPolicyRequest) putKeyPolicyRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, putKeyPolicyRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            putKeyPolicyRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, putKeyPolicyRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public ReEncryptResult reEncrypt(ReEncryptRequest reEncryptRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(reEncryptRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ReEncryptRequest> requestMarshall = new ReEncryptRequestMarshaller().marshall(reEncryptRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ReEncryptResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ReEncryptResult reEncryptResult = (ReEncryptResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return reEncryptResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = reEncryptRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.RetireGrantRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void retireGrant(RetireGrantRequest retireGrantRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(retireGrantRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<RetireGrantRequest> requestMarshall = new RetireGrantRequestMarshaller().marshall((RetireGrantRequest) retireGrantRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, retireGrantRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            retireGrantRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, retireGrantRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.RevokeGrantRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void revokeGrant(RevokeGrantRequest revokeGrantRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(revokeGrantRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<RevokeGrantRequest> requestMarshall = new RevokeGrantRequestMarshaller().marshall((RevokeGrantRequest) revokeGrantRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, revokeGrantRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            revokeGrantRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, revokeGrantRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public ScheduleKeyDeletionResult scheduleKeyDeletion(ScheduleKeyDeletionRequest scheduleKeyDeletionRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(scheduleKeyDeletionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ScheduleKeyDeletionRequest> requestMarshall = new ScheduleKeyDeletionRequestMarshaller().marshall(scheduleKeyDeletionRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ScheduleKeyDeletionResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ScheduleKeyDeletionResult scheduleKeyDeletionResult = (ScheduleKeyDeletionResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return scheduleKeyDeletionResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = scheduleKeyDeletionRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.TagResourceRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void tagResource(TagResourceRequest tagResourceRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(tagResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<TagResourceRequest> requestMarshall2 = new TagResourceRequestMarshaller().marshall((TagResourceRequest) tagResourceRequest);
                    try {
                        requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall2, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall2, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, tagResourceRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            tagResourceRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, tagResourceRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.UntagResourceRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void untagResource(UntagResourceRequest untagResourceRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(untagResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UntagResourceRequest> requestMarshall = new UntagResourceRequestMarshaller().marshall((UntagResourceRequest) untagResourceRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, untagResourceRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            untagResourceRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, untagResourceRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.UpdateAliasRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void updateAlias(UpdateAliasRequest updateAliasRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(updateAliasRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UpdateAliasRequest> requestMarshall = new UpdateAliasRequestMarshaller().marshall((UpdateAliasRequest) updateAliasRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, updateAliasRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            updateAliasRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, updateAliasRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public UpdateCustomKeyStoreResult updateCustomKeyStore(UpdateCustomKeyStoreRequest updateCustomKeyStoreRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(updateCustomKeyStoreRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UpdateCustomKeyStoreRequest> requestMarshall = new UpdateCustomKeyStoreRequestMarshaller().marshall(updateCustomKeyStoreRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new UpdateCustomKeyStoreResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        UpdateCustomKeyStoreResult updateCustomKeyStoreResult = (UpdateCustomKeyStoreResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return updateCustomKeyStoreResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r3, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r3 = updateCustomKeyStoreRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.kms.AWSKMSClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.kms.model.UpdateKeyDescriptionRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.kms.AWSKMS
    public void updateKeyDescription(UpdateKeyDescriptionRequest updateKeyDescriptionRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(updateKeyDescriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UpdateKeyDescriptionRequest> requestMarshall = new UpdateKeyDescriptionRequestMarshaller().marshall((UpdateKeyDescriptionRequest) updateKeyDescriptionRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, updateKeyDescriptionRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            updateKeyDescriptionRequest = 0;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, updateKeyDescriptionRequest, null, true);
            throw th;
        }
    }

    @Override // com.amazonaws.services.kms.AWSKMS
    public CreateKeyResult createKey() throws AmazonClientException {
        return createKey(new CreateKeyRequest());
    }

    @Override // com.amazonaws.services.kms.AWSKMS
    public ListKeysResult listKeys() throws AmazonClientException {
        return listKeys(new ListKeysRequest());
    }

    @Override // com.amazonaws.services.kms.AWSKMS
    public ListAliasesResult listAliases() throws AmazonClientException {
        return listAliases(new ListAliasesRequest());
    }

    @Override // com.amazonaws.services.kms.AWSKMS
    public void retireGrant() throws Throwable {
        retireGrant(new RetireGrantRequest());
    }

    @Override // com.amazonaws.services.kms.AWSKMS
    public GenerateRandomResult generateRandom() throws AmazonClientException {
        return generateRandom(new GenerateRandomRequest());
    }

    @Override // com.amazonaws.services.kms.AWSKMS
    @Deprecated
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request, HttpResponseHandler<AmazonWebServiceResponse<X>> httpResponseHandler, ExecutionContext executionContext) {
        request.setEndpoint(this.endpoint);
        request.setTimeOffset(this.timeOffset);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
        try {
            AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
            if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
                credentials = originalRequest.getRequestCredentials();
            }
            executionContext.setCredentials(credentials);
            return this.client.execute(request, httpResponseHandler, new JsonErrorResponseHandler(this.jsonErrorUnmarshallers), executionContext);
        } catch (Throwable th) {
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            throw th;
        }
    }
}
