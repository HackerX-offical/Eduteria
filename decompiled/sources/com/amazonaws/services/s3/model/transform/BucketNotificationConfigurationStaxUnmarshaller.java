package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazonaws.services.s3.model.NotificationConfiguration;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes4.dex */
public class BucketNotificationConfigurationStaxUnmarshaller implements Unmarshaller<BucketNotificationConfiguration, InputStream> {
    private static BucketNotificationConfigurationStaxUnmarshaller instance = new BucketNotificationConfigurationStaxUnmarshaller();
    private static final XmlPullParserFactory xmlPullParserFactory;

    static {
        try {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new AmazonClientException("Couldn't initialize XmlPullParserFactory", e2);
        }
    }

    public static BucketNotificationConfigurationStaxUnmarshaller getInstance() {
        return instance;
    }

    private BucketNotificationConfigurationStaxUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public BucketNotificationConfiguration unmarshall(InputStream inputStream) throws Exception {
        XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactory.newPullParser();
        xmlPullParserNewPullParser.setInput(inputStream, null);
        StaxUnmarshallerContext staxUnmarshallerContext = new StaxUnmarshallerContext(xmlPullParserNewPullParser, null);
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i = currentDepth + 2;
        }
        BucketNotificationConfiguration bucketNotificationConfiguration = new BucketNotificationConfiguration();
        while (true) {
            int iNextEvent = staxUnmarshallerContext.nextEvent();
            if (iNextEvent == 1) {
                break;
            }
            if (iNextEvent == 2) {
                if (staxUnmarshallerContext.testExpression("TopicConfiguration", i)) {
                    Map.Entry<String, NotificationConfiguration> entryUnmarshall = TopicConfigurationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    bucketNotificationConfiguration.addConfiguration(entryUnmarshall.getKey(), entryUnmarshall.getValue());
                } else if (staxUnmarshallerContext.testExpression("QueueConfiguration", i)) {
                    Map.Entry<String, NotificationConfiguration> entryUnmarshall2 = QueueConfigurationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    bucketNotificationConfiguration.addConfiguration(entryUnmarshall2.getKey(), entryUnmarshall2.getValue());
                } else if (staxUnmarshallerContext.testExpression("CloudFunctionConfiguration", i)) {
                    Map.Entry<String, NotificationConfiguration> entryUnmarshall3 = LambdaConfigurationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    bucketNotificationConfiguration.addConfiguration(entryUnmarshall3.getKey(), entryUnmarshall3.getValue());
                }
            } else if (iNextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                break;
            }
        }
        return bucketNotificationConfiguration;
    }
}
