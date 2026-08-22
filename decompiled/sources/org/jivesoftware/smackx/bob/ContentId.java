package org.jivesoftware.smackx.bob;

import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class ContentId {
    private final String cid;
    private final String hash;
    private final String hashType;

    private ContentId(String str, String str2, String str3) {
        this.hash = (String) StringUtils.requireNotNullNorEmpty(str, "hash must not be null nor empty");
        this.hashType = (String) StringUtils.requireNotNullNorEmpty(str2, "hashType must not be null nor empty");
        this.cid = str3;
    }

    public ContentId(String str, String str2) {
        this(str, str2, str2 + '+' + str + "@bob.xmpp.org");
    }

    public String getHash() {
        return this.hash;
    }

    public String getHashType() {
        return this.hashType;
    }

    public String toSrc() {
        return "cid:" + getCid();
    }

    public String getCid() {
        return this.cid;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ContentId) {
            return this.cid.equals(((ContentId) obj).cid);
        }
        return false;
    }

    public int hashCode() {
        return this.cid.hashCode();
    }

    public static ContentId fromSrc(String str) {
        return new ContentId(str.substring(str.indexOf(MqttTopic.SINGLE_LEVEL_WILDCARD) + 1, str.indexOf("@bob.xmpp.org")), str.substring(str.lastIndexOf("cid:") + 4, str.indexOf(MqttTopic.SINGLE_LEVEL_WILDCARD)));
    }

    public static ContentId fromCid(String str) {
        return new ContentId(str.substring(str.indexOf(MqttTopic.SINGLE_LEVEL_WILDCARD) + 1, str.indexOf("@bob.xmpp.org")), str.substring(0, str.indexOf(MqttTopic.SINGLE_LEVEL_WILDCARD)), str);
    }
}
