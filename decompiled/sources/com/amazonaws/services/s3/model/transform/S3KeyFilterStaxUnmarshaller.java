package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.model.S3KeyFilter;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* JADX INFO: loaded from: classes4.dex */
class S3KeyFilterStaxUnmarshaller implements Unmarshaller<S3KeyFilter, StaxUnmarshallerContext> {
    private static S3KeyFilterStaxUnmarshaller instance = new S3KeyFilterStaxUnmarshaller();

    public static S3KeyFilterStaxUnmarshaller getInstance() {
        return instance;
    }

    private S3KeyFilterStaxUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public S3KeyFilter unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i = currentDepth + 2;
        }
        S3KeyFilter s3KeyFilter = new S3KeyFilter();
        while (true) {
            int iNextEvent = staxUnmarshallerContext.nextEvent();
            if (iNextEvent == 1) {
                break;
            }
            if (iNextEvent == 2) {
                if (staxUnmarshallerContext.testExpression("FilterRule", i)) {
                    s3KeyFilter.addFilterRule(FilterRuleStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (iNextEvent == 3 && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                break;
            }
        }
        return s3KeyFilter;
    }
}
