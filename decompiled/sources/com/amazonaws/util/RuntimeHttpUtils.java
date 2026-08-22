package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.Request;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class RuntimeHttpUtils {
    private static final String COMMA = ", ";
    private static final String SPACE = " ";

    public static URI toUri(String str, ClientConfiguration clientConfiguration) {
        if (clientConfiguration == null) {
            throw new IllegalArgumentException("ClientConfiguration cannot be null");
        }
        return toUri(str, clientConfiguration.getProtocol());
    }

    public static URI toUri(String str, Protocol protocol) {
        if (str == null) {
            throw new IllegalArgumentException("endpoint cannot be null");
        }
        if (!str.contains("://")) {
            str = protocol.toString() + "://" + str;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static URL convertRequestToUrl(Request<?> request, boolean z, boolean z2) {
        String resourcePath;
        if (z2) {
            resourcePath = HttpUtils.urlEncode(request.getResourcePath(), true);
        } else {
            resourcePath = request.getResourcePath();
        }
        if (z && resourcePath.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            resourcePath = resourcePath.substring(1);
        }
        String strReplaceAll = (MqttTopic.TOPIC_LEVEL_SEPARATOR + resourcePath).replaceAll("(?<=/)/", "%2F");
        StringBuilder sb = new StringBuilder(request.getEndpoint().toString());
        sb.append(strReplaceAll);
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : request.getParameters().entrySet()) {
            sb2 = sb2.append(sb2.length() > 0 ? "&" : "?");
            sb2.append(HttpUtils.urlEncode(entry.getKey(), false)).append("=").append(HttpUtils.urlEncode(entry.getValue(), false));
        }
        sb.append(sb2.toString());
        try {
            return new URL(sb.toString());
        } catch (MalformedURLException e2) {
            throw new AmazonClientException("Unable to convert request to well formed URL: " + e2.getMessage(), e2);
        }
    }
}
