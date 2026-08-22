package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.SSEAlgorithm;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.net.ssl.SSLProtocolException;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class ServiceUtils {
    public static final boolean APPEND_MODE = true;
    private static final int DEAFAULT_BYTE_SIZE = 10240;
    public static final boolean OVERWRITE_MODE = false;
    private static final Log log = LogFactory.getLog(ServiceUtils.class);

    @Deprecated
    protected static final DateUtils DATE_UTILS = new DateUtils();

    public interface RetryableS3DownloadTask {
        S3Object getS3ObjectStream();

        boolean needIntegrityCheck();
    }

    public static Date parseIso8601Date(String str) {
        return DateUtils.parseISO8601Date(str);
    }

    public static String formatIso8601Date(Date date) {
        return DateUtils.formatISO8601Date(date);
    }

    public static Date parseRfc822Date(String str) {
        return DateUtils.parseRFC822Date(str);
    }

    public static String formatRfc822Date(Date date) {
        return DateUtils.formatRFC822Date(date);
    }

    public static boolean isMultipartUploadETag(String str) {
        return str.contains("-");
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(StringUtils.UTF8);
    }

    public static String removeQuotes(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("\"")) {
            strTrim = strTrim.substring(1);
        }
        return strTrim.endsWith("\"") ? strTrim.substring(0, strTrim.length() - 1) : strTrim;
    }

    public static URL convertRequestToUrl(Request<?> request) {
        return convertRequestToUrl(request, false);
    }

    public static URL convertRequestToUrl(Request<?> request, boolean z) {
        String str;
        boolean z2 = true;
        String strUrlEncode = S3HttpUtils.urlEncode(request.getResourcePath(), true);
        if (z && strUrlEncode.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            strUrlEncode = strUrlEncode.substring(1);
        }
        String str2 = request.getEndpoint() + (MqttTopic.TOPIC_LEVEL_SEPARATOR + strUrlEncode).replaceAll("(?<=/)/", "%2F");
        for (String str3 : request.getParameters().keySet()) {
            if (z2) {
                str = str2 + "?";
                z2 = false;
            } else {
                str = str2 + "&";
            }
            str2 = str + str3 + "=" + S3HttpUtils.urlEncode(request.getParameters().get(str3), false);
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e2) {
            throw new AmazonClientException("Unable to convert request to well formed URL: " + e2.getMessage(), e2);
        }
    }

    public static String join(List<String> list) {
        String str = "";
        boolean z = true;
        for (String str2 : list) {
            if (!z) {
                str = str + ", ";
            }
            str = str + str2;
            z = false;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void downloadObjectToFile(com.amazonaws.services.s3.model.S3Object r5, java.io.File r6, boolean r7, boolean r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.internal.ServiceUtils.downloadObjectToFile(com.amazonaws.services.s3.model.S3Object, java.io.File, boolean, boolean):void");
    }

    public static S3Object retryableDownloadS3ObjectToFile(File file, RetryableS3DownloadTask retryableS3DownloadTask, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        while (true) {
            S3Object s3ObjectStream = retryableS3DownloadTask.getS3ObjectStream();
            if (s3ObjectStream == null) {
                return null;
            }
            try {
                try {
                    downloadObjectToFile(s3ObjectStream, file, retryableS3DownloadTask.needIntegrityCheck(), z);
                    s3ObjectStream.getObjectContent().abort();
                    z3 = z4;
                    z2 = false;
                } catch (AmazonClientException e2) {
                    if (!e2.isRetryable()) {
                        throw e2;
                    }
                    if ((e2.getCause() instanceof SocketException) || (e2.getCause() instanceof SSLProtocolException)) {
                        throw e2;
                    }
                    if (z4) {
                        throw e2;
                    }
                    log.info("Retry the download of object " + s3ObjectStream.getKey() + " (bucket " + s3ObjectStream.getBucketName() + ")", e2);
                    s3ObjectStream.getObjectContent().abort();
                    z2 = true;
                    z3 = true;
                }
                if (!z2) {
                    return s3ObjectStream;
                }
                z4 = z3;
            } catch (Throwable th) {
                s3ObjectStream.getObjectContent().abort();
                throw th;
            }
        }
    }

    public static boolean skipMd5CheckPerResponse(ObjectMetadata objectMetadata) {
        if (objectMetadata == null) {
            return false;
        }
        return objectMetadata.getSSECustomerAlgorithm() != null || SSEAlgorithm.KMS.toString().equals(objectMetadata.getSSEAlgorithm());
    }

    public static boolean skipMd5CheckPerRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        if (System.getProperty("com.amazonaws.services.s3.disableGetObjectMD5Validation") != null) {
            return true;
        }
        if (amazonWebServiceRequest instanceof GetObjectRequest) {
            GetObjectRequest getObjectRequest = (GetObjectRequest) amazonWebServiceRequest;
            if (getObjectRequest.getRange() != null || getObjectRequest.getSSECustomerKey() != null) {
                return true;
            }
        } else if (amazonWebServiceRequest instanceof PutObjectRequest) {
            PutObjectRequest putObjectRequest = (PutObjectRequest) amazonWebServiceRequest;
            ObjectMetadata metadata = putObjectRequest.getMetadata();
            if ((metadata != null && metadata.getSSEAlgorithm() != null) || putObjectRequest.getSSECustomerKey() != null) {
                return true;
            }
            if (putObjectRequest.getSSEAwsKeyManagementParams() != null && (putObjectRequest.getSSEAwsKeyManagementParams().getEncryption() != null || putObjectRequest.getSSEAwsKeyManagementParams().getAwsKmsKeyId() != null)) {
                return true;
            }
        } else if ((amazonWebServiceRequest instanceof UploadPartRequest) && ((UploadPartRequest) amazonWebServiceRequest).getSSECustomerKey() != null) {
            return true;
        }
        return false;
    }
}
