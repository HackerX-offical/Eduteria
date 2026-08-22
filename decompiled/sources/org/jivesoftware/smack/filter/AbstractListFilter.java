package org.jivesoftware.smack.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractListFilter implements StanzaFilter {
    protected final List<StanzaFilter> filters;

    protected AbstractListFilter() {
        this.filters = new ArrayList();
    }

    protected AbstractListFilter(StanzaFilter... stanzaFilterArr) {
        this(new ArrayList(Arrays.asList(stanzaFilterArr)));
    }

    protected AbstractListFilter(List<StanzaFilter> list) {
        Objects.requireNonNull(list, "Parameter must not be null.");
        Iterator<StanzaFilter> it = list.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next(), "Parameter must not be null.");
        }
        this.filters = list;
    }

    public void addFilter(StanzaFilter stanzaFilter) {
        Objects.requireNonNull(stanzaFilter, "Parameter must not be null.");
        this.filters.add(stanzaFilter);
    }

    public final String toString() {
        return getClass().getSimpleName() + ": (" + ((CharSequence) StringUtils.toStringBuilder(this.filters, ", ")) + ')';
    }
}
