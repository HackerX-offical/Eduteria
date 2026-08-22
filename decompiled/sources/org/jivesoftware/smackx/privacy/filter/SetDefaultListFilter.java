package org.jivesoftware.smackx.privacy.filter;

import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.privacy.packet.Privacy;

/* JADX INFO: loaded from: classes10.dex */
public final class SetDefaultListFilter extends FlexibleStanzaTypeFilter<Privacy> {
    public static final SetDefaultListFilter INSTANCE = new SetDefaultListFilter();

    private SetDefaultListFilter() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Privacy privacy) {
        if (privacy.getType() != IQ.Type.set) {
            return false;
        }
        return privacy.getDefaultName() != null || privacy.isDeclineDefaultList();
    }
}
