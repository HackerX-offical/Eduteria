package com.amazonaws.services.dynamodbv2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
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
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface AmazonDynamoDB {
    BatchGetItemResult batchGetItem(BatchGetItemRequest batchGetItemRequest) throws AmazonClientException;

    BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> map) throws AmazonClientException;

    BatchGetItemResult batchGetItem(Map<String, KeysAndAttributes> map, String str) throws AmazonClientException;

    BatchWriteItemResult batchWriteItem(BatchWriteItemRequest batchWriteItemRequest) throws AmazonClientException;

    BatchWriteItemResult batchWriteItem(Map<String, List<WriteRequest>> map) throws AmazonClientException;

    CreateBackupResult createBackup(CreateBackupRequest createBackupRequest) throws AmazonClientException;

    CreateGlobalTableResult createGlobalTable(CreateGlobalTableRequest createGlobalTableRequest) throws AmazonClientException;

    CreateTableResult createTable(CreateTableRequest createTableRequest) throws AmazonClientException;

    CreateTableResult createTable(List<AttributeDefinition> list, String str, List<KeySchemaElement> list2, ProvisionedThroughput provisionedThroughput) throws AmazonClientException;

    DeleteBackupResult deleteBackup(DeleteBackupRequest deleteBackupRequest) throws AmazonClientException;

    DeleteItemResult deleteItem(DeleteItemRequest deleteItemRequest) throws AmazonClientException;

    DeleteItemResult deleteItem(String str, Map<String, AttributeValue> map) throws AmazonClientException;

    DeleteItemResult deleteItem(String str, Map<String, AttributeValue> map, String str2) throws AmazonClientException;

    DeleteTableResult deleteTable(DeleteTableRequest deleteTableRequest) throws AmazonClientException;

    DeleteTableResult deleteTable(String str) throws AmazonClientException;

    DescribeBackupResult describeBackup(DescribeBackupRequest describeBackupRequest) throws AmazonClientException;

    DescribeContinuousBackupsResult describeContinuousBackups(DescribeContinuousBackupsRequest describeContinuousBackupsRequest) throws AmazonClientException;

    DescribeEndpointsResult describeEndpoints(DescribeEndpointsRequest describeEndpointsRequest) throws AmazonClientException;

    DescribeGlobalTableResult describeGlobalTable(DescribeGlobalTableRequest describeGlobalTableRequest) throws AmazonClientException;

    DescribeGlobalTableSettingsResult describeGlobalTableSettings(DescribeGlobalTableSettingsRequest describeGlobalTableSettingsRequest) throws AmazonClientException;

    DescribeLimitsResult describeLimits(DescribeLimitsRequest describeLimitsRequest) throws AmazonClientException;

    DescribeTableResult describeTable(DescribeTableRequest describeTableRequest) throws AmazonClientException;

    DescribeTableResult describeTable(String str) throws AmazonClientException;

    DescribeTimeToLiveResult describeTimeToLive(DescribeTimeToLiveRequest describeTimeToLiveRequest) throws AmazonClientException;

    ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest);

    GetItemResult getItem(GetItemRequest getItemRequest) throws AmazonClientException;

    GetItemResult getItem(String str, Map<String, AttributeValue> map) throws AmazonClientException;

    GetItemResult getItem(String str, Map<String, AttributeValue> map, Boolean bool) throws AmazonClientException;

    ListBackupsResult listBackups(ListBackupsRequest listBackupsRequest) throws AmazonClientException;

    ListGlobalTablesResult listGlobalTables(ListGlobalTablesRequest listGlobalTablesRequest) throws AmazonClientException;

    ListTablesResult listTables() throws AmazonClientException;

    ListTablesResult listTables(ListTablesRequest listTablesRequest) throws AmazonClientException;

    ListTablesResult listTables(Integer num) throws AmazonClientException;

    ListTablesResult listTables(String str) throws AmazonClientException;

    ListTablesResult listTables(String str, Integer num) throws AmazonClientException;

    ListTagsOfResourceResult listTagsOfResource(ListTagsOfResourceRequest listTagsOfResourceRequest) throws AmazonClientException;

    PutItemResult putItem(PutItemRequest putItemRequest) throws AmazonClientException;

    PutItemResult putItem(String str, Map<String, AttributeValue> map) throws AmazonClientException;

    PutItemResult putItem(String str, Map<String, AttributeValue> map, String str2) throws AmazonClientException;

    QueryResult query(QueryRequest queryRequest) throws AmazonClientException;

    RestoreTableFromBackupResult restoreTableFromBackup(RestoreTableFromBackupRequest restoreTableFromBackupRequest) throws AmazonClientException;

    RestoreTableToPointInTimeResult restoreTableToPointInTime(RestoreTableToPointInTimeRequest restoreTableToPointInTimeRequest) throws AmazonClientException;

    ScanResult scan(ScanRequest scanRequest) throws AmazonClientException;

    ScanResult scan(String str, List<String> list) throws AmazonClientException;

    ScanResult scan(String str, List<String> list, Map<String, Condition> map) throws AmazonClientException;

    ScanResult scan(String str, Map<String, Condition> map) throws AmazonClientException;

    void setEndpoint(String str) throws IllegalArgumentException;

    void setRegion(Region region) throws IllegalArgumentException;

    void shutdown();

    void tagResource(TagResourceRequest tagResourceRequest) throws AmazonClientException;

    void untagResource(UntagResourceRequest untagResourceRequest) throws AmazonClientException;

    UpdateContinuousBackupsResult updateContinuousBackups(UpdateContinuousBackupsRequest updateContinuousBackupsRequest) throws AmazonClientException;

    UpdateGlobalTableResult updateGlobalTable(UpdateGlobalTableRequest updateGlobalTableRequest) throws AmazonClientException;

    UpdateGlobalTableSettingsResult updateGlobalTableSettings(UpdateGlobalTableSettingsRequest updateGlobalTableSettingsRequest) throws AmazonClientException;

    UpdateItemResult updateItem(UpdateItemRequest updateItemRequest) throws AmazonClientException;

    UpdateItemResult updateItem(String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2) throws AmazonClientException;

    UpdateItemResult updateItem(String str, Map<String, AttributeValue> map, Map<String, AttributeValueUpdate> map2, String str2) throws AmazonClientException;

    UpdateTableResult updateTable(UpdateTableRequest updateTableRequest) throws AmazonClientException;

    UpdateTableResult updateTable(String str, ProvisionedThroughput provisionedThroughput) throws AmazonClientException;

    UpdateTimeToLiveResult updateTimeToLive(UpdateTimeToLiveRequest updateTimeToLiveRequest) throws AmazonClientException;
}
