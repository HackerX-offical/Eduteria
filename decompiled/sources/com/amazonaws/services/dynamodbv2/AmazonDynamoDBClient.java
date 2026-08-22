package com.amazonaws.services.dynamodbv2;

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
import com.amazonaws.regions.ServiceAbbreviations;
import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.CreateBackupRequest;
import com.amazonaws.services.dynamodbv2.model.CreateBackupResult;
import com.amazonaws.services.dynamodbv2.model.CreateGlobalTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateGlobalTableResult;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.DeleteBackupRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteBackupResult;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeBackupRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeBackupResult;
import com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeContinuousBackupsResult;
import com.amazonaws.services.dynamodbv2.model.DescribeEndpointsRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult;
import com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsResult;
import com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveRequest;
import com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazonaws.services.dynamodbv2.model.ListBackupsRequest;
import com.amazonaws.services.dynamodbv2.model.ListBackupsResult;
import com.amazonaws.services.dynamodbv2.model.ListGlobalTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceRequest;
import com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupRequest;
import com.amazonaws.services.dynamodbv2.model.RestoreTableFromBackupResult;
import com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeRequest;
import com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.TagResourceRequest;
import com.amazonaws.services.dynamodbv2.model.UntagResourceRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsResult;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableResult;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsResult;
import com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.services.dynamodbv2.model.UpdateTableRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateTableResult;
import com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveRequest;
import com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult;
import com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazonaws.services.dynamodbv2.model.transform.BackupInUseExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.BackupNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ConditionalCheckFailedExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ContinuousBackupsUnavailableExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.CreateBackupRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.CreateBackupResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.CreateGlobalTableRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.CreateGlobalTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.CreateTableRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.CreateTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DeleteBackupRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DeleteBackupResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DeleteItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DeleteItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DeleteTableRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DeleteTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeBackupRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeBackupResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeContinuousBackupsRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeContinuousBackupsResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeEndpointsRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeEndpointsResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableSettingsRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableSettingsResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeTableRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeTimeToLiveRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.DescribeTimeToLiveResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.GetItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.GetItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.GlobalTableAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.GlobalTableNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.IndexNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.InternalServerErrorExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.InvalidRestoreTimeExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ItemCollectionSizeLimitExceededExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ListBackupsRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ListBackupsResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ListGlobalTablesRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ListGlobalTablesResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ListTablesRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ListTablesResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ListTagsOfResourceRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ListTagsOfResourceResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.PointInTimeRecoveryUnavailableExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ProvisionedThroughputExceededExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.PutItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.PutItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.QueryRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.QueryResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ReplicaAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ReplicaNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ResourceInUseExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.RestoreTableFromBackupRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.RestoreTableFromBackupResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.RestoreTableToPointInTimeRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.RestoreTableToPointInTimeResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ScanRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.ScanResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.TableAlreadyExistsExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.TableInUseExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.TableNotFoundExceptionUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.TagResourceRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UntagResourceRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateContinuousBackupsRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateContinuousBackupsResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableSettingsRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableSettingsResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateItemRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateItemResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateTableRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateTableResultJsonUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateTimeToLiveRequestMarshaller;
import com.amazonaws.services.dynamodbv2.model.transform.UpdateTimeToLiveResultJsonUnmarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AmazonDynamoDBClient extends AmazonWebServiceClient implements AmazonDynamoDB {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    @Deprecated
    public AmazonDynamoDBClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public AmazonDynamoDBClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonDynamoDBClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonDynamoDBClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AmazonDynamoDBClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        ArrayList arrayList = new ArrayList();
        this.jsonErrorUnmarshallers = arrayList;
        arrayList.add(new BackupInUseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new BackupNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ConditionalCheckFailedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ContinuousBackupsUnavailableExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new GlobalTableAlreadyExistsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new GlobalTableNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new IndexNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InternalServerErrorExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidRestoreTimeExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ItemCollectionSizeLimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new PointInTimeRecoveryUnavailableExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ProvisionedThroughputExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ReplicaAlreadyExistsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ReplicaNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceInUseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TableAlreadyExistsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TableInUseExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TableNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("dynamodb.us-east-1.amazonaws.com");
        this.endpointPrefix = ServiceAbbreviations.Dynamodb;
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/dynamodbv2/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/dynamodbv2/request.handler2s"));
    }

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        ClientConfiguration clientConfiguration2 = new ClientConfiguration(clientConfiguration);
        if (clientConfiguration2.getRetryPolicy() == PredefinedRetryPolicies.DEFAULT) {
            clientConfiguration2.setRetryPolicy(PredefinedRetryPolicies.DYNAMODB_DEFAULT);
        }
        return clientConfiguration2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public BatchGetItemResult batchGetItem(BatchGetItemRequest batchGetItemRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(batchGetItemRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<BatchGetItemRequest> requestMarshall = new BatchGetItemRequestMarshaller().marshall(batchGetItemRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new BatchGetItemResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        BatchGetItemResult batchGetItemResult = (BatchGetItemResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return batchGetItemResult;
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
            r3 = batchGetItemRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public BatchWriteItemResult batchWriteItem(BatchWriteItemRequest batchWriteItemRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(batchWriteItemRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<BatchWriteItemRequest> requestMarshall = new BatchWriteItemRequestMarshaller().marshall(batchWriteItemRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new BatchWriteItemResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        BatchWriteItemResult batchWriteItemResult = (BatchWriteItemResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return batchWriteItemResult;
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
            r3 = batchWriteItemRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public CreateBackupResult createBackup(CreateBackupRequest createBackupRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(createBackupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<CreateBackupRequest> requestMarshall = new CreateBackupRequestMarshaller().marshall(createBackupRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new CreateBackupResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        CreateBackupResult createBackupResult = (CreateBackupResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return createBackupResult;
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
            r3 = createBackupRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public CreateGlobalTableResult createGlobalTable(CreateGlobalTableRequest createGlobalTableRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(createGlobalTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<CreateGlobalTableRequest> requestMarshall = new CreateGlobalTableRequestMarshaller().marshall(createGlobalTableRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new CreateGlobalTableResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        CreateGlobalTableResult createGlobalTableResult = (CreateGlobalTableResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return createGlobalTableResult;
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
            r3 = createGlobalTableRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public CreateTableResult createTable(CreateTableRequest createTableRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(createTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<CreateTableRequest> requestMarshall = new CreateTableRequestMarshaller().marshall(createTableRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new CreateTableResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        CreateTableResult createTableResult = (CreateTableResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return createTableResult;
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
            r3 = createTableRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DeleteBackupResult deleteBackup(DeleteBackupRequest deleteBackupRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(deleteBackupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DeleteBackupRequest> requestMarshall = new DeleteBackupRequestMarshaller().marshall(deleteBackupRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DeleteBackupResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DeleteBackupResult deleteBackupResult = (DeleteBackupResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return deleteBackupResult;
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
            r3 = deleteBackupRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DeleteItemResult deleteItem(DeleteItemRequest deleteItemRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(deleteItemRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DeleteItemRequest> requestMarshall = new DeleteItemRequestMarshaller().marshall(deleteItemRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DeleteItemResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DeleteItemResult deleteItemResult = (DeleteItemResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return deleteItemResult;
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
            r3 = deleteItemRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DeleteTableResult deleteTable(DeleteTableRequest deleteTableRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(deleteTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DeleteTableRequest> requestMarshall = new DeleteTableRequestMarshaller().marshall(deleteTableRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DeleteTableResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DeleteTableResult deleteTableResult = (DeleteTableResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return deleteTableResult;
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
            r3 = deleteTableRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeBackupResult describeBackup(DescribeBackupRequest describeBackupRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeBackupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeBackupRequest> requestMarshall = new DescribeBackupRequestMarshaller().marshall(describeBackupRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeBackupResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeBackupResult describeBackupResult = (DescribeBackupResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeBackupResult;
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
            r3 = describeBackupRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeContinuousBackupsResult describeContinuousBackups(DescribeContinuousBackupsRequest describeContinuousBackupsRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeContinuousBackupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeContinuousBackupsRequest> requestMarshall = new DescribeContinuousBackupsRequestMarshaller().marshall(describeContinuousBackupsRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeContinuousBackupsResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeContinuousBackupsResult describeContinuousBackupsResult = (DescribeContinuousBackupsResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeContinuousBackupsResult;
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
            r3 = describeContinuousBackupsRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeEndpointsResult describeEndpoints(DescribeEndpointsRequest describeEndpointsRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeEndpointsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeEndpointsRequest> requestMarshall = new DescribeEndpointsRequestMarshaller().marshall(describeEndpointsRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeEndpointsResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeEndpointsResult describeEndpointsResult = (DescribeEndpointsResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeEndpointsResult;
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
            r3 = describeEndpointsRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeGlobalTableResult describeGlobalTable(DescribeGlobalTableRequest describeGlobalTableRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeGlobalTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeGlobalTableRequest> requestMarshall = new DescribeGlobalTableRequestMarshaller().marshall(describeGlobalTableRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeGlobalTableResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeGlobalTableResult describeGlobalTableResult = (DescribeGlobalTableResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeGlobalTableResult;
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
            r3 = describeGlobalTableRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeGlobalTableSettingsResult describeGlobalTableSettings(DescribeGlobalTableSettingsRequest describeGlobalTableSettingsRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeGlobalTableSettingsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeGlobalTableSettingsRequest> requestMarshall = new DescribeGlobalTableSettingsRequestMarshaller().marshall(describeGlobalTableSettingsRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeGlobalTableSettingsResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeGlobalTableSettingsResult describeGlobalTableSettingsResult = (DescribeGlobalTableSettingsResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeGlobalTableSettingsResult;
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
            r3 = describeGlobalTableSettingsRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeLimitsResult describeLimits(DescribeLimitsRequest describeLimitsRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeLimitsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeLimitsRequest> requestMarshall = new DescribeLimitsRequestMarshaller().marshall(describeLimitsRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeLimitsResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeLimitsResult describeLimitsResult = (DescribeLimitsResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeLimitsResult;
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
            r3 = describeLimitsRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeTableResult describeTable(DescribeTableRequest describeTableRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeTableRequest> requestMarshall = new DescribeTableRequestMarshaller().marshall(describeTableRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeTableResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeTableResult describeTableResult = (DescribeTableResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeTableResult;
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
            r3 = describeTableRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeTimeToLiveResult describeTimeToLive(DescribeTimeToLiveRequest describeTimeToLiveRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeTimeToLiveRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<DescribeTimeToLiveRequest> requestMarshall = new DescribeTimeToLiveRequestMarshaller().marshall(describeTimeToLiveRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeTimeToLiveResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeTimeToLiveResult describeTimeToLiveResult = (DescribeTimeToLiveResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeTimeToLiveResult;
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
            r3 = describeTimeToLiveRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public GetItemResult getItem(GetItemRequest getItemRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getItemRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<GetItemRequest> requestMarshall = new GetItemRequestMarshaller().marshall(getItemRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new GetItemResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GetItemResult getItemResult = (GetItemResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return getItemResult;
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
            r3 = getItemRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListBackupsResult listBackups(ListBackupsRequest listBackupsRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listBackupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ListBackupsRequest> requestMarshall = new ListBackupsRequestMarshaller().marshall(listBackupsRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListBackupsResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListBackupsResult listBackupsResult = (ListBackupsResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listBackupsResult;
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
            r3 = listBackupsRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListGlobalTablesResult listGlobalTables(ListGlobalTablesRequest listGlobalTablesRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listGlobalTablesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ListGlobalTablesRequest> requestMarshall = new ListGlobalTablesRequestMarshaller().marshall(listGlobalTablesRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListGlobalTablesResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListGlobalTablesResult listGlobalTablesResult = (ListGlobalTablesResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listGlobalTablesResult;
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
            r3 = listGlobalTablesRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListTablesResult listTables(ListTablesRequest listTablesRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listTablesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ListTablesRequest> requestMarshall = new ListTablesRequestMarshaller().marshall(listTablesRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListTablesResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListTablesResult listTablesResult = (ListTablesResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listTablesResult;
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
            r3 = listTablesRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListTagsOfResourceResult listTagsOfResource(ListTagsOfResourceRequest listTagsOfResourceRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listTagsOfResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ListTagsOfResourceRequest> requestMarshall = new ListTagsOfResourceRequestMarshaller().marshall(listTagsOfResourceRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListTagsOfResourceResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListTagsOfResourceResult listTagsOfResourceResult = (ListTagsOfResourceResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listTagsOfResourceResult;
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
            r3 = listTagsOfResourceRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public PutItemResult putItem(PutItemRequest putItemRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(putItemRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<PutItemRequest> requestMarshall = new PutItemRequestMarshaller().marshall(putItemRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new PutItemResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        PutItemResult putItemResult = (PutItemResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return putItemResult;
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
            r3 = putItemRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public QueryResult query(QueryRequest queryRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(queryRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<QueryRequest> requestMarshall = new QueryRequestMarshaller().marshall(queryRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new QueryResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        QueryResult queryResult = (QueryResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return queryResult;
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
            r3 = queryRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public RestoreTableFromBackupResult restoreTableFromBackup(RestoreTableFromBackupRequest restoreTableFromBackupRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(restoreTableFromBackupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<RestoreTableFromBackupRequest> requestMarshall = new RestoreTableFromBackupRequestMarshaller().marshall(restoreTableFromBackupRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new RestoreTableFromBackupResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        RestoreTableFromBackupResult restoreTableFromBackupResult = (RestoreTableFromBackupResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return restoreTableFromBackupResult;
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
            r3 = restoreTableFromBackupRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public RestoreTableToPointInTimeResult restoreTableToPointInTime(RestoreTableToPointInTimeRequest restoreTableToPointInTimeRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(restoreTableToPointInTimeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<RestoreTableToPointInTimeRequest> requestMarshall = new RestoreTableToPointInTimeRequestMarshaller().marshall(restoreTableToPointInTimeRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new RestoreTableToPointInTimeResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        RestoreTableToPointInTimeResult restoreTableToPointInTimeResult = (RestoreTableToPointInTimeResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return restoreTableToPointInTimeResult;
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
            r3 = restoreTableToPointInTimeRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ScanResult scan(ScanRequest scanRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(scanRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<ScanRequest> requestMarshall = new ScanRequestMarshaller().marshall(scanRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ScanResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ScanResult scanResult = (ScanResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return scanResult;
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
            r3 = scanRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.TagResourceRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public void tagResource(TagResourceRequest tagResourceRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(tagResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<TagResourceRequest> requestMarshall = new TagResourceRequestMarshaller().marshall((TagResourceRequest) tagResourceRequest);
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
    /* JADX WARN: Type inference failed for: r5v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.dynamodbv2.model.UntagResourceRequest] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
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
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateContinuousBackupsResult updateContinuousBackups(UpdateContinuousBackupsRequest updateContinuousBackupsRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(updateContinuousBackupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UpdateContinuousBackupsRequest> requestMarshall = new UpdateContinuousBackupsRequestMarshaller().marshall(updateContinuousBackupsRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new UpdateContinuousBackupsResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        UpdateContinuousBackupsResult updateContinuousBackupsResult = (UpdateContinuousBackupsResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return updateContinuousBackupsResult;
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
            r3 = updateContinuousBackupsRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateGlobalTableResult updateGlobalTable(UpdateGlobalTableRequest updateGlobalTableRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(updateGlobalTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UpdateGlobalTableRequest> requestMarshall = new UpdateGlobalTableRequestMarshaller().marshall(updateGlobalTableRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new UpdateGlobalTableResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        UpdateGlobalTableResult updateGlobalTableResult = (UpdateGlobalTableResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return updateGlobalTableResult;
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
            r3 = updateGlobalTableRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateGlobalTableSettingsResult updateGlobalTableSettings(UpdateGlobalTableSettingsRequest updateGlobalTableSettingsRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(updateGlobalTableSettingsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UpdateGlobalTableSettingsRequest> requestMarshall = new UpdateGlobalTableSettingsRequestMarshaller().marshall(updateGlobalTableSettingsRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new UpdateGlobalTableSettingsResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        UpdateGlobalTableSettingsResult updateGlobalTableSettingsResult = (UpdateGlobalTableSettingsResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return updateGlobalTableSettingsResult;
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
            r3 = updateGlobalTableSettingsRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateItemResult updateItem(UpdateItemRequest updateItemRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(updateItemRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UpdateItemRequest> requestMarshall = new UpdateItemRequestMarshaller().marshall(updateItemRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new UpdateItemResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        UpdateItemResult updateItemResult = (UpdateItemResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return updateItemResult;
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
            r3 = updateItemRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateTableResult updateTable(UpdateTableRequest updateTableRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(updateTableRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UpdateTableRequest> requestMarshall = new UpdateTableRequestMarshaller().marshall(updateTableRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new UpdateTableResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        UpdateTableResult updateTableResult = (UpdateTableResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return updateTableResult;
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
            r3 = updateTableRequest;
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
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient] */
    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateTimeToLiveResult updateTimeToLive(UpdateTimeToLiveRequest updateTimeToLiveRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(updateTimeToLiveRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ClientExecuteTime);
        ?? r3 = 0;
        try {
            try {
                awsRequestMetrics.startEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                try {
                    Request<UpdateTimeToLiveRequest> requestMarshall = new UpdateTimeToLiveRequestMarshaller().marshall(updateTimeToLiveRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new UpdateTimeToLiveResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        UpdateTimeToLiveResult updateTimeToLiveResult = (UpdateTimeToLiveResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return updateTimeToLiveResult;
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
            r3 = updateTimeToLiveRequest;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r3, response, true);
            throw th;
        }
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public PutItemResult putItem(String str, Map<String, AttributeValue> map) throws AmazonClientException {
        PutItemRequest putItemRequest = new PutItemRequest();
        putItemRequest.setTableName(str);
        putItemRequest.setItem(map);
        return putItem(putItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public PutItemResult putItem(String str, Map<String, AttributeValue> map, String str2) throws AmazonClientException {
        PutItemRequest putItemRequest = new PutItemRequest();
        putItemRequest.setTableName(str);
        putItemRequest.setItem(map);
        putItemRequest.setReturnValues(str2);
        return putItem(putItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateItemResult updateItem(String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2) throws AmazonClientException {
        UpdateItemRequest updateItemRequest = new UpdateItemRequest();
        updateItemRequest.setTableName(str);
        updateItemRequest.setKey(map);
        updateItemRequest.setAttributeUpdates(map2);
        return updateItem(updateItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateItemResult updateItem(String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2, String str2) throws AmazonClientException {
        UpdateItemRequest updateItemRequest = new UpdateItemRequest();
        updateItemRequest.setTableName(str);
        updateItemRequest.setKey(map);
        updateItemRequest.setAttributeUpdates(map2);
        updateItemRequest.setReturnValues(str2);
        return updateItem(updateItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DescribeTableResult describeTable(String str) throws AmazonClientException {
        DescribeTableRequest describeTableRequest = new DescribeTableRequest();
        describeTableRequest.setTableName(str);
        return describeTable(describeTableRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ScanResult scan(String str, List<String> list) throws AmazonClientException {
        ScanRequest scanRequest = new ScanRequest();
        scanRequest.setTableName(str);
        scanRequest.setAttributesToGet(list);
        return scan(scanRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ScanResult scan(String str, Map<String, Condition> map) throws AmazonClientException {
        ScanRequest scanRequest = new ScanRequest();
        scanRequest.setTableName(str);
        scanRequest.setScanFilter(map);
        return scan(scanRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ScanResult scan(String str, List<String> list, Map<String, Condition> map) throws AmazonClientException {
        ScanRequest scanRequest = new ScanRequest();
        scanRequest.setTableName(str);
        scanRequest.setAttributesToGet(list);
        scanRequest.setScanFilter(map);
        return scan(scanRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DeleteItemResult deleteItem(String str, Map<String, AttributeValue> map) throws AmazonClientException {
        DeleteItemRequest deleteItemRequest = new DeleteItemRequest();
        deleteItemRequest.setTableName(str);
        deleteItemRequest.setKey(map);
        return deleteItem(deleteItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DeleteItemResult deleteItem(String str, Map<String, AttributeValue> map, String str2) throws AmazonClientException {
        DeleteItemRequest deleteItemRequest = new DeleteItemRequest();
        deleteItemRequest.setTableName(str);
        deleteItemRequest.setKey(map);
        deleteItemRequest.setReturnValues(str2);
        return deleteItem(deleteItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public DeleteTableResult deleteTable(String str) throws AmazonClientException {
        DeleteTableRequest deleteTableRequest = new DeleteTableRequest();
        deleteTableRequest.setTableName(str);
        return deleteTable(deleteTableRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public CreateTableResult createTable(List<AttributeDefinition> list, String str, List<KeySchemaElement> list2, ProvisionedThroughput provisionedThroughput) throws AmazonClientException {
        CreateTableRequest createTableRequest = new CreateTableRequest();
        createTableRequest.setAttributeDefinitions(list);
        createTableRequest.setTableName(str);
        createTableRequest.setKeySchema(list2);
        createTableRequest.setProvisionedThroughput(provisionedThroughput);
        return createTable(createTableRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public GetItemResult getItem(String str, Map<String, AttributeValue> map) throws AmazonClientException {
        GetItemRequest getItemRequest = new GetItemRequest();
        getItemRequest.setTableName(str);
        getItemRequest.setKey(map);
        return getItem(getItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public GetItemResult getItem(String str, Map<String, AttributeValue> map, Boolean bool) throws AmazonClientException {
        GetItemRequest getItemRequest = new GetItemRequest();
        getItemRequest.setTableName(str);
        getItemRequest.setKey(map);
        getItemRequest.setConsistentRead(bool);
        return getItem(getItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListTablesResult listTables() throws AmazonClientException {
        return listTables(new ListTablesRequest());
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListTablesResult listTables(String str) throws AmazonClientException {
        ListTablesRequest listTablesRequest = new ListTablesRequest();
        listTablesRequest.setExclusiveStartTableName(str);
        return listTables(listTablesRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListTablesResult listTables(String str, Integer num) throws AmazonClientException {
        ListTablesRequest listTablesRequest = new ListTablesRequest();
        listTablesRequest.setExclusiveStartTableName(str);
        listTablesRequest.setLimit(num);
        return listTables(listTablesRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public ListTablesResult listTables(Integer num) throws AmazonClientException {
        ListTablesRequest listTablesRequest = new ListTablesRequest();
        listTablesRequest.setLimit(num);
        return listTables(listTablesRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public UpdateTableResult updateTable(String str, ProvisionedThroughput provisionedThroughput) throws AmazonClientException {
        UpdateTableRequest updateTableRequest = new UpdateTableRequest();
        updateTableRequest.setTableName(str);
        updateTableRequest.setProvisionedThroughput(provisionedThroughput);
        return updateTable(updateTableRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> map, String str) throws AmazonClientException {
        BatchGetItemRequest batchGetItemRequest = new BatchGetItemRequest();
        batchGetItemRequest.setRequestItems(map);
        batchGetItemRequest.setReturnConsumedCapacity(str);
        return batchGetItem(batchGetItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> map) throws AmazonClientException {
        BatchGetItemRequest batchGetItemRequest = new BatchGetItemRequest();
        batchGetItemRequest.setRequestItems(map);
        return batchGetItem(batchGetItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
    public BatchWriteItemResult batchWriteItem(Map<String, List<WriteRequest>> map) throws AmazonClientException {
        BatchWriteItemRequest batchWriteItemRequest = new BatchWriteItemRequest();
        batchWriteItemRequest.setRequestItems(map);
        return batchWriteItem(batchWriteItemRequest);
    }

    @Override // com.amazonaws.services.dynamodbv2.AmazonDynamoDB
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
