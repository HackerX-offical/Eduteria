package org.jivesoftware.smackx.mam.filter;

import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.jivesoftware.smackx.mam.element.MamQueryIQ;

/* JADX INFO: loaded from: classes10.dex */
public class MamResultFilter extends FlexibleStanzaTypeFilter<Message> {
    private final String queryId;

    public MamResultFilter(MamQueryIQ mamQueryIQ) {
        super(Message.class);
        this.queryId = mamQueryIQ.getQueryId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Message message) {
        MamElements.MamResultExtension mamResultExtensionFrom = MamElements.MamResultExtension.from(message);
        if (mamResultExtensionFrom == null) {
            return false;
        }
        String queryId = mamResultExtensionFrom.getQueryId();
        String str = this.queryId;
        if (str == null && queryId == null) {
            return true;
        }
        return str != null && str.equals(queryId);
    }
}
