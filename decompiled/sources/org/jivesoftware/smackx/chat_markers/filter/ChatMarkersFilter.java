package org.jivesoftware.smackx.chat_markers.filter;

import org.jivesoftware.smack.filter.StanzaExtensionFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smackx.chat_markers.element.ChatMarkersElements;

/* JADX INFO: loaded from: classes10.dex */
public final class ChatMarkersFilter extends StanzaExtensionFilter {
    public static final StanzaFilter INSTANCE = new ChatMarkersFilter(ChatMarkersElements.NAMESPACE);

    private ChatMarkersFilter(String str) {
        super(str);
    }
}
