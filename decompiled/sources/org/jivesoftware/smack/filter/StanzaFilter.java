package org.jivesoftware.smack.filter;

import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.Predicate;

/* JADX INFO: loaded from: classes10.dex */
public interface StanzaFilter extends Predicate<Stanza> {
    boolean accept(Stanza stanza);

    @Override // org.jivesoftware.smack.util.Predicate
    default boolean test(Stanza stanza) {
        return accept(stanza);
    }

    default <S extends Stanza> Predicate<S> asPredicate(final Class<?> cls) {
        return new Predicate() { // from class: org.jivesoftware.smack.filter.StanzaFilter$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.Predicate
            public final boolean test(Object obj) {
                return StanzaFilter.lambda$asPredicate$0(this.f$0, cls, (Stanza) obj);
            }
        };
    }

    static /* synthetic */ boolean lambda$asPredicate$0(StanzaFilter _this, Class cls, Stanza stanza) {
        if (cls.isAssignableFrom(stanza.getClass())) {
            return _this.accept(stanza);
        }
        return false;
    }
}
