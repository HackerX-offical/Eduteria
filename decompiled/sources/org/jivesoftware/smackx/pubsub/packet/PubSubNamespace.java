package org.jivesoftware.smackx.pubsub.packet;

/* JADX INFO: loaded from: classes10.dex */
public enum PubSubNamespace {
    basic(null),
    error("errors"),
    event("event"),
    owner("owner");

    private final String fragment;
    private final String fullNamespace;

    PubSubNamespace(String str) {
        this.fragment = str;
        if (str != null) {
            this.fullNamespace = "http://jabber.org/protocol/pubsub#" + str;
        } else {
            this.fullNamespace = "http://jabber.org/protocol/pubsub";
        }
    }

    public String getXmlns() {
        return this.fullNamespace;
    }

    public String getFragment() {
        return this.fragment;
    }

    public static PubSubNamespace valueOfFromXmlns(String str) {
        int iLastIndexOf = str.lastIndexOf(35);
        if (iLastIndexOf != -1) {
            if (iLastIndexOf > str.length()) {
                throw new IllegalArgumentException(str + " is not a valid PubSub namespace");
            }
            return valueOf(str.substring(iLastIndexOf + 1));
        }
        if (!"http://jabber.org/protocol/pubsub".equals(str)) {
            throw new IllegalArgumentException(str + " is not a valid PubSub namespace");
        }
        return basic;
    }
}
