package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.DisableKeyRotationRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class DisableKeyRotationRequestMarshaller implements Marshaller<Request<DisableKeyRotationRequest>, DisableKeyRotationRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<DisableKeyRotationRequest> marshall(DisableKeyRotationRequest disableKeyRotationRequest) {
        if (disableKeyRotationRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(DisableKeyRotationRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(disableKeyRotationRequest, "AWSKMS");
        defaultRequest.addHeader("X-Amz-Target", "TrentService.DisableKeyRotation");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (disableKeyRotationRequest.getKeyId() != null) {
                String keyId = disableKeyRotationRequest.getKeyId();
                jsonWriter.name("KeyId");
                jsonWriter.value(keyId);
            }
            jsonWriter.endObject();
            jsonWriter.close();
            String string = stringWriter.toString();
            byte[] bytes = string.getBytes(StringUtils.UTF8);
            defaultRequest.setContent(new StringInputStream(string));
            defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
            if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.1");
            }
            return defaultRequest;
        } catch (Throwable th) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }
}
