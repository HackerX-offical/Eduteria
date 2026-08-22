package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class ListNetworkRequest extends NetworkRequest {
    private final Integer maxPageSize;
    private final String nextPageToken;

    public ListNetworkRequest(Uri uri, FirebaseApp firebaseApp, Integer num, String str) {
        super(uri, firebaseApp);
        this.maxPageSize = num;
        this.nextPageToken = str;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String getAction() {
        return "GET";
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected Uri getURL() {
        return Uri.parse(sNetworkRequestUrl + "/b/" + this.mGsUri.getAuthority() + "/o");
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected Map<String, String> getQueryParameters() {
        HashMap map = new HashMap();
        String pathWithoutBucket = getPathWithoutBucket();
        if (!pathWithoutBucket.isEmpty()) {
            map.put("prefix", pathWithoutBucket + MqttTopic.TOPIC_LEVEL_SEPARATOR);
        }
        map.put("delimiter", MqttTopic.TOPIC_LEVEL_SEPARATOR);
        Integer num = this.maxPageSize;
        if (num != null) {
            map.put("maxResults", Integer.toString(num.intValue()));
        }
        if (!TextUtils.isEmpty(this.nextPageToken)) {
            map.put("pageToken", this.nextPageToken);
        }
        return map;
    }
}
