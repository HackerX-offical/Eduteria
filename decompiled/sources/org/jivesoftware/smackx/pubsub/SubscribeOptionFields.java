package org.jivesoftware.smackx.pubsub;

/* JADX INFO: loaded from: classes10.dex */
public enum SubscribeOptionFields {
    deliver,
    digest,
    digest_frequency,
    expire,
    include_body,
    show_values,
    subscription_type,
    subscription_depth;

    public String getFieldName() {
        if (this == show_values) {
            return "pubsub#" + toString().replace('_', '-');
        }
        return "pubsub#" + toString();
    }

    public static SubscribeOptionFields valueOfFromElement(String str) {
        String strSubstring = str.substring(str.lastIndexOf(36));
        if ("show-values".equals(strSubstring)) {
            return show_values;
        }
        return valueOf(strSubstring);
    }
}
