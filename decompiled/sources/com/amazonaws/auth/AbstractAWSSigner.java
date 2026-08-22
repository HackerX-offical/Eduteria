package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.internal.SdkDigestInputStream;
import com.amazonaws.util.Base64;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractAWSSigner implements Signer {
    private static final int BUFFER_SIZE_MULTIPLIER = 5;
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int TIME_MILLISEC = 1000;
    private static final ThreadLocal<MessageDigest> SHA256_MESSAGE_DIGEST = new ThreadLocal<MessageDigest>() { // from class: com.amazonaws.auth.AbstractAWSSigner.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e2) {
                throw new AmazonClientException("Unable to get SHA256 Function" + e2.getMessage(), e2);
            }
        }
    };
    public static final String EMPTY_STRING_SHA256_HEX = BinaryUtils.toHex(doHash(""));

    protected abstract void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials);

    protected String signAndBase64Encode(String str, String str2, SigningAlgorithm signingAlgorithm) {
        return signAndBase64Encode(str.getBytes(StringUtils.UTF8), str2, signingAlgorithm);
    }

    protected String signAndBase64Encode(byte[] bArr, String str, SigningAlgorithm signingAlgorithm) {
        try {
            return Base64.encodeAsString(sign(bArr, str.getBytes(StringUtils.UTF8), signingAlgorithm));
        } catch (Exception e2) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e2.getMessage(), e2);
        }
    }

    public byte[] sign(String str, byte[] bArr, SigningAlgorithm signingAlgorithm) {
        try {
            return sign(str.getBytes(StringUtils.UTF8), bArr, signingAlgorithm);
        } catch (Exception e2) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e2.getMessage(), e2);
        }
    }

    protected byte[] sign(byte[] bArr, byte[] bArr2, SigningAlgorithm signingAlgorithm) {
        try {
            Mac mac = Mac.getInstance(signingAlgorithm.toString());
            mac.init(new SecretKeySpec(bArr2, signingAlgorithm.toString()));
            return mac.doFinal(bArr);
        } catch (Exception e2) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e2.getMessage(), e2);
        }
    }

    public byte[] hash(String str) {
        return doHash(str);
    }

    private static byte[] doHash(String str) {
        try {
            MessageDigest messageDigestInstance = getMessageDigestInstance();
            messageDigestInstance.update(str.getBytes(StringUtils.UTF8));
            return messageDigestInstance.digest();
        } catch (Exception e2) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e2.getMessage(), e2);
        }
    }

    protected byte[] hash(InputStream inputStream) {
        try {
            SdkDigestInputStream sdkDigestInputStream = new SdkDigestInputStream(inputStream, getMessageDigestInstance());
            while (sdkDigestInputStream.read(new byte[1024]) > -1) {
            }
            return sdkDigestInputStream.getMessageDigest().digest();
        } catch (Exception e2) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e2.getMessage(), e2);
        }
    }

    public byte[] hash(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e2) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e2.getMessage(), e2);
        }
    }

    protected String getCanonicalizedQueryString(Map<String, String> map) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            treeMap.put(HttpUtils.urlEncode(entry.getKey(), false), HttpUtils.urlEncode(entry.getValue(), false));
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append((String) entry2.getKey());
            sb.append("=");
            sb.append((String) entry2.getValue());
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    protected String getCanonicalizedQueryString(Request<?> request) {
        if (HttpUtils.usePayloadForQueryParameters(request)) {
            return "";
        }
        return getCanonicalizedQueryString(request.getParameters());
    }

    protected byte[] getBinaryRequestPayload(Request<?> request) {
        if (HttpUtils.usePayloadForQueryParameters(request)) {
            String strEncodeParameters = HttpUtils.encodeParameters(request);
            if (strEncodeParameters == null) {
                return new byte[0];
            }
            return strEncodeParameters.getBytes(StringUtils.UTF8);
        }
        return getBinaryRequestPayloadWithoutQueryParams(request);
    }

    protected String getRequestPayload(Request<?> request) {
        return newString(getBinaryRequestPayload(request));
    }

    protected String getRequestPayloadWithoutQueryParams(Request<?> request) {
        return newString(getBinaryRequestPayloadWithoutQueryParams(request));
    }

    protected byte[] getBinaryRequestPayloadWithoutQueryParams(Request<?> request) {
        InputStream binaryRequestPayloadStreamWithoutQueryParams = getBinaryRequestPayloadStreamWithoutQueryParams(request);
        try {
            binaryRequestPayloadStreamWithoutQueryParams.mark(-1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[5120];
            while (true) {
                int i = binaryRequestPayloadStreamWithoutQueryParams.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byteArrayOutputStream.close();
                    binaryRequestPayloadStreamWithoutQueryParams.reset();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (Exception e2) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e2.getMessage(), e2);
        }
    }

    protected InputStream getBinaryRequestPayloadStream(Request<?> request) {
        if (HttpUtils.usePayloadForQueryParameters(request)) {
            String strEncodeParameters = HttpUtils.encodeParameters(request);
            if (strEncodeParameters == null) {
                return new ByteArrayInputStream(new byte[0]);
            }
            return new ByteArrayInputStream(strEncodeParameters.getBytes(StringUtils.UTF8));
        }
        return getBinaryRequestPayloadStreamWithoutQueryParams(request);
    }

    protected InputStream getBinaryRequestPayloadStreamWithoutQueryParams(Request<?> request) {
        try {
            InputStream content = request.getContent();
            if (content == null) {
                return new ByteArrayInputStream(new byte[0]);
            }
            if (content instanceof StringInputStream) {
                return content;
            }
            if (!content.markSupported()) {
                throw new AmazonClientException("Unable to read request payload to sign request.");
            }
            return request.getContent();
        } catch (Exception e2) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e2.getMessage(), e2);
        }
    }

    protected String getCanonicalizedResourcePath(String str) {
        return getCanonicalizedResourcePath(str, true);
    }

    protected String getCanonicalizedResourcePath(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
        if (z) {
            str = HttpUtils.urlEncode(str, true);
        }
        return str.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR) ? str : MqttTopic.TOPIC_LEVEL_SEPARATOR.concat(str);
    }

    protected String getCanonicalizedEndpoint(URI uri) {
        String strLowerCase = StringUtils.lowerCase(uri.getHost());
        return HttpUtils.isUsingNonDefaultPort(uri) ? strLowerCase + ":" + uri.getPort() : strLowerCase;
    }

    protected AWSCredentials sanitizeCredentials(AWSCredentials aWSCredentials) {
        String aWSAccessKeyId;
        String aWSSecretKey;
        String sessionToken;
        synchronized (aWSCredentials) {
            aWSAccessKeyId = aWSCredentials.getAWSAccessKeyId();
            aWSSecretKey = aWSCredentials.getAWSSecretKey();
            sessionToken = aWSCredentials instanceof AWSSessionCredentials ? ((AWSSessionCredentials) aWSCredentials).getSessionToken() : null;
        }
        if (aWSSecretKey != null) {
            aWSSecretKey = aWSSecretKey.trim();
        }
        if (aWSAccessKeyId != null) {
            aWSAccessKeyId = aWSAccessKeyId.trim();
        }
        if (sessionToken != null) {
            sessionToken = sessionToken.trim();
        }
        if (aWSCredentials instanceof AWSSessionCredentials) {
            return new BasicSessionCredentials(aWSAccessKeyId, aWSSecretKey, sessionToken);
        }
        return new BasicAWSCredentials(aWSAccessKeyId, aWSSecretKey);
    }

    protected String newString(byte[] bArr) {
        return new String(bArr, StringUtils.UTF8);
    }

    protected Date getSignatureDate(int i) {
        Date date = new Date();
        return i != 0 ? new Date(date.getTime() - ((long) (i * 1000))) : date;
    }

    protected int getTimeOffset(Request<?> request) {
        return SDKGlobalConfiguration.getGlobalTimeOffset() != 0 ? SDKGlobalConfiguration.getGlobalTimeOffset() : request.getTimeOffset();
    }

    private static MessageDigest getMessageDigestInstance() {
        MessageDigest messageDigest = SHA256_MESSAGE_DIGEST.get();
        messageDigest.reset();
        return messageDigest;
    }
}
