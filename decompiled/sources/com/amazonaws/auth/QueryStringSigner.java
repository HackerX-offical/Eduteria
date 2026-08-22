package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.util.DateUtils;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class QueryStringSigner extends AbstractAWSSigner implements Signer {
    private Date overriddenDate;

    @Override // com.amazonaws.auth.Signer
    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        sign(request, SignatureVersion.V2, SigningAlgorithm.HmacSHA256, aWSCredentials);
    }

    public void sign(Request<?> request, SignatureVersion signatureVersion, SigningAlgorithm signingAlgorithm, AWSCredentials aWSCredentials) {
        String strCalculateStringToSignV2;
        if (aWSCredentials instanceof AnonymousAWSCredentials) {
            return;
        }
        AWSCredentials aWSCredentialsSanitizeCredentials = sanitizeCredentials(aWSCredentials);
        request.addParameter("AWSAccessKeyId", aWSCredentialsSanitizeCredentials.getAWSAccessKeyId());
        request.addParameter("SignatureVersion", signatureVersion.toString());
        request.addParameter("Timestamp", getFormattedTimestamp(getTimeOffset(request)));
        if (aWSCredentialsSanitizeCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) aWSCredentialsSanitizeCredentials);
        }
        if (signatureVersion.equals(SignatureVersion.V1)) {
            strCalculateStringToSignV2 = calculateStringToSignV1(request.getParameters());
        } else if (signatureVersion.equals(SignatureVersion.V2)) {
            request.addParameter("SignatureMethod", signingAlgorithm.toString());
            strCalculateStringToSignV2 = calculateStringToSignV2(request);
        } else {
            throw new AmazonClientException("Invalid Signature Version specified");
        }
        request.addParameter("Signature", signAndBase64Encode(strCalculateStringToSignV2, aWSCredentialsSanitizeCredentials.getAWSSecretKey(), signingAlgorithm));
    }

    private String calculateStringToSignV1(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(map);
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append((String) entry.getValue());
        }
        return sb.toString();
    }

    private String calculateStringToSignV2(Request<?> request) {
        URI endpoint = request.getEndpoint();
        Map<String, String> parameters = request.getParameters();
        StringBuilder sb = new StringBuilder("POST\n");
        sb.append(getCanonicalizedEndpoint(endpoint)).append("\n");
        sb.append(getCanonicalizedResourcePath(request)).append("\n");
        sb.append(getCanonicalizedQueryString(parameters));
        return sb.toString();
    }

    private String getCanonicalizedResourcePath(Request<?> request) {
        String str = request.getEndpoint().getPath() != null ? "" + request.getEndpoint().getPath() : "";
        if (request.getResourcePath() != null) {
            if (str.length() > 0 && !str.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR) && !request.getResourcePath().startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                str = str + MqttTopic.TOPIC_LEVEL_SEPARATOR;
            }
            str = str + request.getResourcePath();
        } else if (!str.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            str = str + MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
        if (!str.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            str = MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
        }
        return str.startsWith("//") ? str.substring(1) : str;
    }

    private String getFormattedTimestamp(int i) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO8601_DATE_PATTERN);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = this.overriddenDate;
        if (date != null) {
            return simpleDateFormat.format(date);
        }
        return simpleDateFormat.format(getSignatureDate(i));
    }

    void overrideDate(Date date) {
        this.overriddenDate = date;
    }

    @Override // com.amazonaws.auth.AbstractAWSSigner
    protected void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addParameter("SecurityToken", aWSSessionCredentials.getSessionToken());
    }
}
