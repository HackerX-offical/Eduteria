package org.jivesoftware.smackx.privacy.filter;

import org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.privacy.packet.Privacy;

/* JADX INFO: loaded from: classes10.dex */
public final class SetActiveListFilter extends FlexibleStanzaTypeFilter<Privacy> {
    public static final SetActiveListFilter INSTANCE = new SetActiveListFilter();

    private SetActiveListFilter() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jivesoftware.smack.filter.FlexibleStanzaTypeFilter
    public boolean acceptSpecific(Privacy privacy) {
        if (privacy.getType() != IQ.Type.set) {
            return false;
        }
        return privacy.getActiveName() != null || privacy.isDeclineActiveList();
    }
}
