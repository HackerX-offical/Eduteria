package org.jivesoftware.smack.filter;

import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.Stanza;

/* JADX INFO: loaded from: classes10.dex */
public class AndFilter extends AbstractListFilter implements StanzaFilter {
    public AndFilter() {
    }

    public AndFilter(StanzaFilter... stanzaFilterArr) {
        super(stanzaFilterArr);
    }

    public AndFilter(List<StanzaFilter> list) {
        super(list);
    }

    @Override // org.jivesoftware.smack.filter.StanzaFilter
    public boolean accept(Stanza stanza) {
        Iterator<StanzaFilter> it = this.filters.iterator();
        while (it.hasNext()) {
            if (!it.next().accept(stanza)) {
                return false;
            }
        }
        return true;
    }
}
