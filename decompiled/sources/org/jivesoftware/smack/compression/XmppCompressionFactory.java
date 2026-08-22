package org.jivesoftware.smack.compression;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XmppInputOutputFilter;

/* JADX INFO: loaded from: classes10.dex */
public abstract class XmppCompressionFactory implements Comparable<XmppCompressionFactory> {
    private final String method;
    private final int priority;

    public abstract XmppInputOutputFilter fabricate(ConnectionConfiguration connectionConfiguration);

    protected XmppCompressionFactory(String str, int i) {
        this.method = str;
        this.priority = i;
    }

    public final String getCompressionMethod() {
        return this.method;
    }

    public final int getPriority() {
        return this.priority;
    }

    @Override // java.lang.Comparable
    public final int compareTo(XmppCompressionFactory xmppCompressionFactory) {
        return Integer.compare(getPriority(), xmppCompressionFactory.getPriority());
    }
}
