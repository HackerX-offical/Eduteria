package com.amazonaws.services.dynamodbv2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
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
import com.amazonaws.services.dynamodbv2.model.ListBackupsRequest;
import com.amazonaws.services.dynamodbv2.model.ListBackupsResult;
import com.amazonaws.services.dynamodbv2.model.ListGlobalTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult;
import com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceRequest;
import com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult;
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
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public interface AmazonDynamoDBAsync extends AmazonDynamoDB {
    Future<BatchGetItemResult> batchGetItemAsync(BatchGetItemRequest batchGetItemRequest) throws AmazonClientException;

    Future<BatchGetItemResult> batchGetItemAsync(BatchGetItemRequest batchGetItemRequest, AsyncHandler<BatchGetItemRequest, BatchGetItemResult> asyncHandler) throws AmazonClientException;

    Future<BatchWriteItemResult> batchWriteItemAsync(BatchWriteItemRequest batchWriteItemRequest) throws AmazonClientException;

    Future<BatchWriteItemResult> batchWriteItemAsync(BatchWriteItemRequest batchWriteItemRequest, AsyncHandler<BatchWriteItemRequest, BatchWriteItemResult> asyncHandler) throws AmazonClientException;

    Future<CreateBackupResult> createBackupAsync(CreateBackupRequest createBackupRequest) throws AmazonClientException;

    Future<CreateBackupResult> createBackupAsync(CreateBackupRequest createBackupRequest, AsyncHandler<CreateBackupRequest, CreateBackupResult> asyncHandler) throws AmazonClientException;

    Future<CreateGlobalTableResult> createGlobalTableAsync(CreateGlobalTableRequest createGlobalTableRequest) throws AmazonClientException;

    Future<CreateGlobalTableResult> createGlobalTableAsync(CreateGlobalTableRequest createGlobalTableRequest, AsyncHandler<CreateGlobalTableRequest, CreateGlobalTableResult> asyncHandler) throws AmazonClientException;

    Future<CreateTableResult> createTableAsync(CreateTableRequest createTableRequest) throws AmazonClientException;

    Future<CreateTableResult> createTableAsync(CreateTableRequest createTableRequest, AsyncHandler<CreateTableRequest, CreateTableResult> asyncHandler) throws AmazonClientException;

    Future<DeleteBackupResult> deleteBackupAsync(DeleteBackupRequest deleteBackupRequest) throws AmazonClientException;

    Future<DeleteBackupResult> deleteBackupAsync(DeleteBackupRequest deleteBackupRequest, AsyncHandler<DeleteBackupRequest, DeleteBackupResult> asyncHandler) throws AmazonClientException;

    Future<DeleteItemResult> deleteItemAsync(DeleteItemRequest deleteItemRequest) throws AmazonClientException;

    Future<DeleteItemResult> deleteItemAsync(DeleteItemRequest deleteItemRequest, AsyncHandler<DeleteItemRequest, DeleteItemResult> asyncHandler) throws AmazonClientException;

    Future<DeleteTableResult> deleteTableAsync(DeleteTableRequest deleteTableRequest) throws AmazonClientException;

    Future<DeleteTableResult> deleteTableAsync(DeleteTableRequest deleteTableRequest, AsyncHandler<DeleteTableRequest, DeleteTableResult> asyncHandler) throws AmazonClientException;

    Future<DescribeBackupResult> describeBackupAsync(DescribeBackupRequest describeBackupRequest) throws AmazonClientException;

    Future<DescribeBackupResult> describeBackupAsync(DescribeBackupRequest describeBackupRequest, AsyncHandler<DescribeBackupRequest, DescribeBackupResult> asyncHandler) throws AmazonClientException;

    Future<DescribeContinuousBackupsResult> describeContinuousBackupsAsync(DescribeContinuousBackupsRequest describeContinuousBackupsRequest) throws AmazonClientException;

    Future<DescribeContinuousBackupsResult> describeContinuousBackupsAsync(DescribeContinuousBackupsRequest describeContinuousBackupsRequest, AsyncHandler<DescribeContinuousBackupsRequest, DescribeContinuousBackupsResult> asyncHandler) throws AmazonClientException;

    Future<DescribeEndpointsResult> describeEndpointsAsync(DescribeEndpointsRequest describeEndpointsRequest) throws AmazonClientException;

    Future<DescribeEndpointsResult> describeEndpointsAsync(DescribeEndpointsRequest describeEndpointsRequest, AsyncHandler<DescribeEndpointsRequest, DescribeEndpointsResult> asyncHandler) throws AmazonClientException;

    Future<DescribeGlobalTableResult> describeGlobalTableAsync(DescribeGlobalTableRequest describeGlobalTableRequest) throws AmazonClientException;

    Future<DescribeGlobalTableResult> describeGlobalTableAsync(DescribeGlobalTableRequest describeGlobalTableRequest, AsyncHandler<DescribeGlobalTableRequest, DescribeGlobalTableResult> asyncHandler) throws AmazonClientException;

    Future<DescribeGlobalTableSettingsResult> describeGlobalTableSettingsAsync(DescribeGlobalTableSettingsRequest describeGlobalTableSettingsRequest) throws AmazonClientException;

    Future<DescribeGlobalTableSettingsResult> describeGlobalTableSettingsAsync(DescribeGlobalTableSettingsRequest describeGlobalTableSettingsRequest, AsyncHandler<DescribeGlobalTableSettingsRequest, DescribeGlobalTableSettingsResult> asyncHandler) throws AmazonClientException;

    Future<DescribeLimitsResult> describeLimitsAsync(DescribeLimitsRequest describeLimitsRequest) throws AmazonClientException;

    Future<DescribeLimitsResult> describeLimitsAsync(DescribeLimitsRequest describeLimitsRequest, AsyncHandler<DescribeLimitsRequest, DescribeLimitsResult> asyncHandler) throws AmazonClientException;

    Future<DescribeTableResult> describeTableAsync(DescribeTableRequest describeTableRequest) throws AmazonClientException;

    Future<DescribeTableResult> describeTableAsync(DescribeTableRequest describeTableRequest, AsyncHandler<DescribeTableRequest, DescribeTableResult> asyncHandler) throws AmazonClientException;

    Future<DescribeTimeToLiveResult> describeTimeToLiveAsync(DescribeTimeToLiveRequest describeTimeToLiveRequest) throws AmazonClientException;

    Future<DescribeTimeToLiveResult> describeTimeToLiveAsync(DescribeTimeToLiveRequest describeTimeToLiveRequest, AsyncHandler<DescribeTimeToLiveRequest, DescribeTimeToLiveResult> asyncHandler) throws AmazonClientException;

    Future<GetItemResult> getItemAsync(GetItemRequest getItemRequest) throws AmazonClientException;

    Future<GetItemResult> getItemAsync(GetItemRequest getItemRequest, AsyncHandler<GetItemRequest, GetItemResult> asyncHandler) throws AmazonClientException;

    Future<ListBackupsResult> listBackupsAsync(ListBackupsRequest listBackupsRequest) throws AmazonClientException;

    Future<ListBackupsResult> listBackupsAsync(ListBackupsRequest listBackupsRequest, AsyncHandler<ListBackupsRequest, ListBackupsResult> asyncHandler) throws AmazonClientException;

    Future<ListGlobalTablesResult> listGlobalTablesAsync(ListGlobalTablesRequest listGlobalTablesRequest) throws AmazonClientException;

    Future<ListGlobalTablesResult> listGlobalTablesAsync(ListGlobalTablesRequest listGlobalTablesRequest, AsyncHandler<ListGlobalTablesRequest, ListGlobalTablesResult> asyncHandler) throws AmazonClientException;

    Future<ListTablesResult> listTablesAsync(ListTablesRequest listTablesRequest) throws AmazonClientException;

    Future<ListTablesResult> listTablesAsync(ListTablesRequest listTablesRequest, AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler) throws AmazonClientException;

    Future<ListTagsOfResourceResult> listTagsOfResourceAsync(ListTagsOfResourceRequest listTagsOfResourceRequest) throws AmazonClientException;

    Future<ListTagsOfResourceResult> listTagsOfResourceAsync(ListTagsOfResourceRequest listTagsOfResourceRequest, AsyncHandler<ListTagsOfResourceRequest, ListTagsOfResourceResult> asyncHandler) throws AmazonClientException;

    Future<PutItemResult> putItemAsync(PutItemRequest putItemRequest) throws AmazonClientException;

    Future<PutItemResult> putItemAsync(PutItemRequest putItemRequest, AsyncHandler<PutItemRequest, PutItemResult> asyncHandler) throws AmazonClientException;

    Future<QueryResult> queryAsync(QueryRequest queryRequest) throws AmazonClientException;

    Future<QueryResult> queryAsync(QueryRequest queryRequest, AsyncHandler<QueryRequest, QueryResult> asyncHandler) throws AmazonClientException;

    Future<RestoreTableFromBackupResult> restoreTableFromBackupAsync(RestoreTableFromBackupRequest restoreTableFromBackupRequest) throws AmazonClientException;

    Future<RestoreTableFromBackupResult> restoreTableFromBackupAsync(RestoreTableFromBackupRequest restoreTableFromBackupRequest, AsyncHandler<RestoreTableFromBackupRequest, RestoreTableFromBackupResult> asyncHandler) throws AmazonClientException;

    Future<RestoreTableToPointInTimeResult> restoreTableToPointInTimeAsync(RestoreTableToPointInTimeRequest restoreTableToPointInTimeRequest) throws AmazonClientException;

    Future<RestoreTableToPointInTimeResult> restoreTableToPointInTimeAsync(RestoreTableToPointInTimeRequest restoreTableToPointInTimeRequest, AsyncHandler<RestoreTableToPointInTimeRequest, RestoreTableToPointInTimeResult> asyncHandler) throws AmazonClientException;

    Future<ScanResult> scanAsync(ScanRequest scanRequest) throws AmazonClientException;

    Future<ScanResult> scanAsync(ScanRequest scanRequest, AsyncHandler<ScanRequest, ScanResult> asyncHandler) throws AmazonClientException;

    Future<Void> tagResourceAsync(TagResourceRequest tagResourceRequest) throws AmazonClientException;

    Future<Void> tagResourceAsync(TagResourceRequest tagResourceRequest, AsyncHandler<TagResourceRequest, Void> asyncHandler) throws AmazonClientException;

    Future<Void> untagResourceAsync(UntagResourceRequest untagResourceRequest) throws AmazonClientException;

    Future<Void> untagResourceAsync(UntagResourceRequest untagResourceRequest, AsyncHandler<UntagResourceRequest, Void> asyncHandler) throws AmazonClientException;

    Future<UpdateContinuousBackupsResult> updateContinuousBackupsAsync(UpdateContinuousBackupsRequest updateContinuousBackupsRequest) throws AmazonClientException;

    Future<UpdateContinuousBackupsResult> updateContinuousBackupsAsync(UpdateContinuousBackupsRequest updateContinuousBackupsRequest, AsyncHandler<UpdateContinuousBackupsRequest, UpdateContinuousBackupsResult> asyncHandler) throws AmazonClientException;

    Future<UpdateGlobalTableResult> updateGlobalTableAsync(UpdateGlobalTableRequest updateGlobalTableRequest) throws AmazonClientException;

    Future<UpdateGlobalTableResult> updateGlobalTableAsync(UpdateGlobalTableRequest updateGlobalTableRequest, AsyncHandler<UpdateGlobalTableRequest, UpdateGlobalTableResult> asyncHandler) throws AmazonClientException;

    Future<UpdateGlobalTableSettingsResult> updateGlobalTableSettingsAsync(UpdateGlobalTableSettingsRequest updateGlobalTableSettingsRequest) throws AmazonClientException;

    Future<UpdateGlobalTableSettingsResult> updateGlobalTableSettingsAsync(UpdateGlobalTableSettingsRequest updateGlobalTableSettingsRequest, AsyncHandler<UpdateGlobalTableSettingsRequest, UpdateGlobalTableSettingsResult> asyncHandler) throws AmazonClientException;

    Future<UpdateItemResult> updateItemAsync(UpdateItemRequest updateItemRequest) throws AmazonClientException;

    Future<UpdateItemResult> updateItemAsync(UpdateItemRequest updateItemRequest, AsyncHandler<UpdateItemRequest, UpdateItemResult> asyncHandler) throws AmazonClientException;

    Future<UpdateTableResult> updateTableAsync(UpdateTableRequest updateTableRequest) throws AmazonClientException;

    Future<UpdateTableResult> updateTableAsync(UpdateTableRequest updateTableRequest, AsyncHandler<UpdateTableRequest, UpdateTableResult> asyncHandler) throws AmazonClientException;

    Future<UpdateTimeToLiveResult> updateTimeToLiveAsync(UpdateTimeToLiveRequest updateTimeToLiveRequest) throws AmazonClientException;

    Future<UpdateTimeToLiveResult> updateTimeToLiveAsync(UpdateTimeToLiveRequest updateTimeToLiveRequest, AsyncHandler<UpdateTimeToLiveRequest, UpdateTimeToLiveResult> asyncHandler) throws AmazonClientException;
}
