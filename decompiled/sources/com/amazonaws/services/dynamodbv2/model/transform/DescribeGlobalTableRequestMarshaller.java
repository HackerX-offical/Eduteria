package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class DescribeGlobalTableRequestMarshaller implements Marshaller<Request<DescribeGlobalTableRequest>, DescribeGlobalTableRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<DescribeGlobalTableRequest> marshall(DescribeGlobalTableRequest describeGlobalTableRequest) {
        if (describeGlobalTableRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(DescribeGlobalTableRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(describeGlobalTableRequest, "AmazonDynamoDB");
        defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.DescribeGlobalTable");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (describeGlobalTableRequest.getGlobalTableName() != null) {
                String globalTableName = describeGlobalTableRequest.getGlobalTableName();
                jsonWriter.name("GlobalTableName");
                jsonWriter.value(globalTableName);
            }
            jsonWriter.endObject();
            jsonWriter.close();
            String string = stringWriter.toString();
            byte[] bytes = string.getBytes(StringUtils.UTF8);
            defaultRequest.setContent(new StringInputStream(string));
            defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
            if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.0");
            }
            return defaultRequest;
        } catch (Throwable th) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }
}
