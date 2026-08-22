package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import com.clevertap.android.sdk.Constants;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import cz.msebera.android.httpclient.HttpHost;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;

/* JADX INFO: loaded from: classes4.dex */
public class AWS3Signer extends AbstractAWSSigner {
    private static final String AUTHORIZATION_HEADER = "X-Amzn-Authorization";
    private static final String HTTPS_SCHEME = "AWS3-HTTPS";
    private static final String HTTP_SCHEME = "AWS3";
    private static final String NONCE_HEADER = "x-amz-nonce";
    private static final Log log = LogFactory.getLog(AWS3Signer.class);
    private String overriddenDate;

    @Override // com.amazonaws.auth.Signer
    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
        if (aWSCredentials instanceof AnonymousAWSCredentials) {
            return;
        }
        AWSCredentials aWSCredentialsSanitizeCredentials = sanitizeCredentials(aWSCredentials);
        SigningAlgorithm signingAlgorithm = SigningAlgorithm.HmacSHA256;
        UUID.randomUUID().toString();
        String rFC822Date = DateUtils.formatRFC822Date(getSignatureDate(getTimeOffset(request)));
        String str = this.overriddenDate;
        if (str != null) {
            rFC822Date = str;
        }
        request.addHeader("Date", rFC822Date);
        request.addHeader("X-Amz-Date", rFC822Date);
        String host = request.getEndpoint().getHost();
        if (HttpUtils.isUsingNonDefaultPort(request.getEndpoint())) {
            host = host + ":" + request.getEndpoint().getPort();
        }
        request.addHeader("Host", host);
        if (aWSCredentialsSanitizeCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) aWSCredentialsSanitizeCredentials);
        }
        String str2 = request.getHttpMethod().toString() + "\n" + getCanonicalizedResourcePath(HttpUtils.appendUri(request.getEndpoint().getPath(), request.getResourcePath())) + "\n" + getCanonicalizedQueryString(request.getParameters()) + "\n" + getCanonicalizedHeadersForStringToSign(request) + "\n" + getRequestPayloadWithoutQueryParams(request);
        byte[] bArrHash = hash(str2);
        log.debug("Calculated StringToSign: " + str2);
        String strSignAndBase64Encode = signAndBase64Encode(bArrHash, aWSCredentialsSanitizeCredentials.getAWSSecretKey(), signingAlgorithm);
        StringBuilder sb = new StringBuilder();
        sb.append(HTTP_SCHEME).append(" ");
        sb.append("AWSAccessKeyId=" + aWSCredentialsSanitizeCredentials.getAWSAccessKeyId() + Constants.SEPARATOR_COMMA);
        sb.append("Algorithm=" + signingAlgorithm.toString() + Constants.SEPARATOR_COMMA);
        sb.append(getSignedHeadersComponent(request) + Constants.SEPARATOR_COMMA);
        sb.append("Signature=" + strSignAndBase64Encode);
        request.addHeader(AUTHORIZATION_HEADER, sb.toString());
    }

    private String getSignedHeadersComponent(Request<?> request) {
        StringBuilder sb = new StringBuilder("SignedHeaders=");
        boolean z = true;
        for (String str : getHeadersForStringToSign(request)) {
            if (!z) {
                sb.append(";");
            }
            sb.append(str);
            z = false;
        }
        return sb.toString();
    }

    protected List<String> getHeadersForStringToSign(Request<?> request) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = request.getHeaders().entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            String strLowerCase = StringUtils.lowerCase(key);
            if (strLowerCase.startsWith("x-amz") || JingleS5BTransportCandidate.ATTR_HOST.equals(strLowerCase)) {
                arrayList.add(key);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    void overrideDate(String str) {
        this.overriddenDate = str;
    }

    protected String getCanonicalizedHeadersForStringToSign(Request<?> request) {
        List<String> headersForStringToSign = getHeadersForStringToSign(request);
        for (int i = 0; i < headersForStringToSign.size(); i++) {
            headersForStringToSign.set(i, StringUtils.lowerCase(headersForStringToSign.get(i)));
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, String> entry : request.getHeaders().entrySet()) {
            if (headersForStringToSign.contains(StringUtils.lowerCase(entry.getKey()))) {
                treeMap.put(StringUtils.lowerCase(entry.getKey()), entry.getValue());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry2 : treeMap.entrySet()) {
            sb.append(StringUtils.lowerCase((String) entry2.getKey())).append(":").append((String) entry2.getValue()).append("\n");
        }
        return sb.toString();
    }

    boolean shouldUseHttpsScheme(Request<?> request) {
        try {
            String strLowerCase = StringUtils.lowerCase(request.getEndpoint().toURL().getProtocol());
            if (HttpHost.DEFAULT_SCHEME_NAME.equals(strLowerCase)) {
                return false;
            }
            if (TournamentShareDialogURIBuilder.scheme.equals(strLowerCase)) {
                return true;
            }
            throw new AmazonClientException("Unknown request endpoint protocol encountered while signing request: " + strLowerCase);
        } catch (MalformedURLException e2) {
            throw new AmazonClientException("Unable to parse request endpoint during signing", e2);
        }
    }

    @Override // com.amazonaws.auth.AbstractAWSSigner
    protected void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.addHeader(Headers.SECURITY_TOKEN, aWSSessionCredentials.getSessionToken());
    }
}
