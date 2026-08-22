package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.DescribeLimitsRequest;
import com.amazonaws.transform.Marshaller;
import java.io.ByteArrayInputStream;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class DescribeLimitsRequestMarshaller implements Marshaller<Request<DescribeLimitsRequest>, DescribeLimitsRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<DescribeLimitsRequest> marshall(DescribeLimitsRequest describeLimitsRequest) {
        if (describeLimitsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(DescribeLimitsRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(describeLimitsRequest, "AmazonDynamoDB");
        defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.DescribeLimits");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        defaultRequest.addHeader("Content-Length", "0");
        defaultRequest.setContent(new ByteArrayInputStream(new byte[0]));
        if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
            defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.0");
        }
        return defaultRequest;
    }
}
