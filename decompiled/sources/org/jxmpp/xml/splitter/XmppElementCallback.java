package org.jxmpp.xml.splitter;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface XmppElementCallback extends CompleteElementCallback {
    void streamClosed();

    void streamOpened(String str, Map<String, String> map);
}
