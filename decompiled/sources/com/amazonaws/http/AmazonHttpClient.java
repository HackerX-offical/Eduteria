package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.TimingInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AmazonHttpClient {
    private static final String HEADER_SDK_RETRY_INFO = "aws-sdk-retry";
    private static final String HEADER_SDK_TRANSACTION_ID = "aws-sdk-invocation-id";
    private static final String HEADER_USER_AGENT = "User-Agent";
    private static final int HTTP_STATUS_MULTIPLE_CHOICES = 300;
    private static final int HTTP_STATUS_OK = 200;
    private static final int HTTP_STATUS_REQ_TOO_LONG = 413;
    private static final int HTTP_STATUS_SERVICE_UNAVAILABLE = 503;
    private static final int HTTP_STATUS_TEMP_REDIRECT = 307;
    private static final int TIME_MILLISEC = 1000;
    final ClientConfiguration config;
    final HttpClient httpClient;
    private final HttpRequestFactory requestFactory;
    private final RequestMetricCollector requestMetricCollector;
    private static final Log REQUEST_LOG = LogFactory.getLog("com.amazonaws.request");
    static final Log log = LogFactory.getLog(AmazonHttpClient.class);

    @Deprecated
    public ResponseMetadata getResponseMetadataForRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        return null;
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration), requestMetricCollector);
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = null;
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient, RequestMetricCollector requestMetricCollector) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = requestMetricCollector;
    }

    public <T> Response<T> execute(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponseHandler<AmazonServiceException> httpResponseHandler2, ExecutionContext executionContext) throws Throwable {
        Response<T> responseExecuteHelper;
        if (executionContext == null) {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
        List<RequestHandler2> listRequestHandler2s = requestHandler2s(request, executionContext);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        try {
            responseExecuteHelper = executeHelper(request, httpResponseHandler, httpResponseHandler2, executionContext);
            try {
                afterResponse(request, listRequestHandler2s, responseExecuteHelper, awsRequestMetrics.getTimingInfo().endTiming());
                return responseExecuteHelper;
            } catch (AmazonClientException e2) {
                e = e2;
                afterError(request, responseExecuteHelper, listRequestHandler2s, e);
                throw e;
            }
        } catch (AmazonClientException e3) {
            e = e3;
            responseExecuteHelper = null;
        }
    }

    void afterError(Request<?> request, Response<?> response, List<RequestHandler2> list, AmazonClientException amazonClientException) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().afterError(request, response, amazonClientException);
        }
    }

    <T> void afterResponse(Request<?> request, List<RequestHandler2> list, Response<T> response, TimingInfo timingInfo) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().afterResponse(request, response);
        }
    }

    List<RequestHandler2> requestHandler2s(Request<?> request, ExecutionContext executionContext) {
        List<RequestHandler2> requestHandler2s = executionContext.getRequestHandler2s();
        if (requestHandler2s == null) {
            return Collections.emptyList();
        }
        for (RequestHandler2 requestHandler2 : requestHandler2s) {
            if (requestHandler2 instanceof CredentialsRequestHandler) {
                ((CredentialsRequestHandler) requestHandler2).setCredentials(executionContext.getCredentials());
            }
            requestHandler2.beforeRequest(request);
        }
        return requestHandler2s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x030a A[Catch: IOException -> 0x0312, TRY_LEAVE, TryCatch #18 {IOException -> 0x0312, blocks: (B:156:0x0304, B:158:0x030a), top: B:289:0x0304 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03e0 A[Catch: all -> 0x0463, TRY_ENTER, TryCatch #33 {all -> 0x0463, blocks: (B:243:0x03d6, B:246:0x03e0, B:247:0x03f8, B:249:0x0437, B:260:0x0462, B:210:0x0393, B:211:0x0398), top: B:297:0x03d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0437 A[Catch: all -> 0x0463, TRY_LEAVE, TryCatch #33 {all -> 0x0463, blocks: (B:243:0x03d6, B:246:0x03e0, B:247:0x03f8, B:249:0x0437, B:260:0x0462, B:210:0x0393, B:211:0x0398), top: B:297:0x03d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0468 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0462 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:333:? A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0143 A[Catch: all -> 0x00e4, IOException -> 0x03a3, Error -> 0x03b1, RuntimeException -> 0x03bc, TRY_ENTER, TRY_LEAVE, TryCatch #24 {IOException -> 0x03a3, blocks: (B:44:0x0126, B:46:0x012e, B:48:0x0135, B:49:0x013a, B:50:0x013b, B:52:0x0143), top: B:291:0x0126 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0160  */
    /* JADX WARN: Type inference failed for: r0v44, types: [com.amazonaws.http.HttpRequestFactory] */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.amazonaws.http.AmazonHttpClient] */
    /* JADX WARN: Type inference failed for: r2v27, types: [com.amazonaws.logging.Log] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.amazonaws.logging.Log] */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.amazonaws.http.ExecutionContext] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v54 */
    /* JADX WARN: Type inference failed for: r8v55 */
    /* JADX WARN: Type inference failed for: r8v56 */
    /* JADX WARN: Type inference failed for: r8v57 */
    /* JADX WARN: Type inference failed for: r8v58 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v60 */
    /* JADX WARN: Type inference failed for: r8v61 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    <T> com.amazonaws.Response<T> executeHelper(com.amazonaws.Request<?> r25, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonWebServiceResponse<T>> r26, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonServiceException> r27, com.amazonaws.http.ExecutionContext r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1151
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.executeHelper(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.ExecutionContext):com.amazonaws.Response");
    }

    private <T extends Throwable> T handleUnexpectedFailure(T t, AWSRequestMetrics aWSRequestMetrics) {
        aWSRequestMetrics.incrementCounter(AWSRequestMetrics.Field.Exception);
        aWSRequestMetrics.addProperty(AWSRequestMetrics.Field.Exception, t);
        return t;
    }

    void resetRequestAfterError(Request<?> request, Exception exc) {
        if (request.getContent() == null) {
            return;
        }
        if (!request.getContent().markSupported()) {
            throw new AmazonClientException("Encountered an exception and stream is not resettable", exc);
        }
        try {
            request.getContent().reset();
        } catch (IOException unused) {
            throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exc);
        }
    }

    void setUserAgent(Request<?> request) {
        RequestClientOptions requestClientOptions;
        String clientMarker;
        String strCreateUserAgentString = ClientConfiguration.DEFAULT_USER_AGENT;
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest != null && (requestClientOptions = originalRequest.getRequestClientOptions()) != null && (clientMarker = requestClientOptions.getClientMarker(RequestClientOptions.Marker.USER_AGENT)) != null) {
            strCreateUserAgentString = createUserAgentString(strCreateUserAgentString, clientMarker);
        }
        if (!ClientConfiguration.DEFAULT_USER_AGENT.equals(this.config.getUserAgent())) {
            strCreateUserAgentString = createUserAgentString(strCreateUserAgentString, this.config.getUserAgent());
        }
        request.addHeader("User-Agent", strCreateUserAgentString);
    }

    static String createUserAgentString(String str, String str2) {
        return str.contains(str2) ? str : str.trim() + " " + str2.trim();
    }

    public void shutdown() {
        this.httpClient.shutdown();
    }

    private boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, InputStream inputStream, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 1;
        int maxErrorRetry = this.config.getMaxErrorRetry();
        if (maxErrorRetry < 0 || !retryPolicy.isMaxErrorRetryInClientConfigHonored()) {
            maxErrorRetry = retryPolicy.getMaxErrorRetry();
        }
        if (i2 >= maxErrorRetry) {
            return false;
        }
        if (inputStream != null && !inputStream.markSupported()) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("Content not repeatable");
            }
            return false;
        }
        return retryPolicy.getRetryCondition().shouldRetry(amazonWebServiceRequest, amazonClientException, i2);
    }

    private static boolean isTemporaryRedirect(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        String str = httpResponse.getHeaders().get("Location");
        return (statusCode != 307 || str == null || str.isEmpty()) ? false : true;
    }

    private boolean isRequestSuccessful(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        return statusCode >= 200 && statusCode < 300;
    }

    <T> T handleResponse(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponse httpResponse, ExecutionContext executionContext) throws IOException {
        try {
            AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
            awsRequestMetrics.startEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
            try {
                AmazonWebServiceResponse<T> amazonWebServiceResponseHandle = httpResponseHandler.handle(httpResponse);
                if (amazonWebServiceResponseHandle == null) {
                    throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText());
                }
                Log log2 = REQUEST_LOG;
                if (log2.isDebugEnabled()) {
                    log2.debug("Received successful response: " + httpResponse.getStatusCode() + ", AWS Request ID: " + amazonWebServiceResponseHandle.getRequestId());
                }
                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, amazonWebServiceResponseHandle.getRequestId());
                return amazonWebServiceResponseHandle.getResult();
            } finally {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
            }
        } catch (CRC32MismatchException e2) {
            throw e2;
        } catch (IOException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new AmazonClientException("Unable to unmarshall response (" + e4.getMessage() + "). Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText(), e4);
        }
    }

    AmazonServiceException handleErrorResponse(Request<?> request, HttpResponseHandler<AmazonServiceException> httpResponseHandler, HttpResponse httpResponse) throws IOException {
        AmazonServiceException amazonServiceException;
        int statusCode = httpResponse.getStatusCode();
        try {
            amazonServiceException = httpResponseHandler.handle(httpResponse);
            REQUEST_LOG.debug("Received error response: " + amazonServiceException.toString());
        } catch (Exception e2) {
            if (statusCode == 413) {
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(413);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
                amazonServiceException.setErrorCode("Request entity too large");
            } else if (statusCode == 503 && "Service Unavailable".equalsIgnoreCase(httpResponse.getStatusText())) {
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(503);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
                amazonServiceException.setErrorCode("Service unavailable");
            } else {
                if (e2 instanceof IOException) {
                    throw ((IOException) e2);
                }
                throw new AmazonClientException("Unable to unmarshall error response (" + e2.getMessage() + "). Response Code: " + statusCode + ", Response Text: " + httpResponse.getStatusText() + ", Response Headers: " + httpResponse.getHeaders(), e2);
            }
        }
        amazonServiceException.setStatusCode(statusCode);
        amazonServiceException.setServiceName(request.getServiceName());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    private long pauseBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 2;
        long jDelayBeforeNextRetry = retryPolicy.getBackoffStrategy().delayBeforeNextRetry(amazonWebServiceRequest, amazonClientException, i2);
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Retriable error detected, will retry in " + jDelayBeforeNextRetry + "ms, attempt number: " + i2);
        }
        try {
            Thread.sleep(jDelayBeforeNextRetry);
            return jDelayBeforeNextRetry;
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw new AmazonClientException(e2.getMessage(), e2);
        }
    }

    private String getServerDateFromException(String str) {
        int iIndexOf;
        int iIndexOf2 = str.indexOf("(");
        if (str.contains(" + 15")) {
            iIndexOf = str.indexOf(" + 15");
        } else {
            iIndexOf = str.indexOf(" - 15");
        }
        return str.substring(iIndexOf2 + 1, iIndexOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020 A[Catch: RuntimeException -> 0x003c, TRY_ENTER, TRY_LEAVE, TryCatch #1 {RuntimeException -> 0x003c, blocks: (B:4:0x0014, B:9:0x0020), top: B:21:0x0014 }] */
    /* JADX WARN: Type inference failed for: r4v14, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int parseClockSkewOffset(com.amazonaws.http.HttpResponse r4, com.amazonaws.AmazonServiceException r5) {
        /*
            r3 = this;
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            java.util.Map r4 = r4.getHeaders()
            java.lang.String r1 = "Date"
            java.lang.Object r4 = r4.get(r1)
            java.lang.String r4 = (java.lang.String) r4
            r1 = 0
            if (r4 == 0) goto L20
            boolean r2 = r4.isEmpty()     // Catch: java.lang.RuntimeException -> L3c
            if (r2 == 0) goto L1b
            goto L20
        L1b:
            java.util.Date r4 = com.amazonaws.util.DateUtils.parseRFC822Date(r4)     // Catch: java.lang.RuntimeException -> L3a
            goto L2c
        L20:
            java.lang.String r4 = r5.getMessage()     // Catch: java.lang.RuntimeException -> L3c
            java.lang.String r4 = r3.getServerDateFromException(r4)     // Catch: java.lang.RuntimeException -> L3c
            java.util.Date r4 = com.amazonaws.util.DateUtils.parseCompressedISO8601Date(r4)     // Catch: java.lang.RuntimeException -> L3a
        L2c:
            long r0 = r0.getTime()
            long r4 = r4.getTime()
            long r0 = r0 - r4
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r4
            int r4 = (int) r0
            return r4
        L3a:
            r5 = move-exception
            goto L3e
        L3c:
            r5 = move-exception
            r4 = r1
        L3e:
            com.amazonaws.logging.Log r0 = com.amazonaws.http.AmazonHttpClient.log
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unable to parse clock skew offset from response: "
            r1.<init>(r2)
            java.lang.StringBuilder r4 = r1.append(r4)
            java.lang.String r4 = r4.toString()
            r0.warn(r4, r5)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.parseClockSkewOffset(com.amazonaws.http.HttpResponse, com.amazonaws.AmazonServiceException):int");
    }

    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }

    public RequestMetricCollector getRequestMetricCollector() {
        return this.requestMetricCollector;
    }
}
