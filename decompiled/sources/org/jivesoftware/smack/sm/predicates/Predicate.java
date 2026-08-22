package org.jivesoftware.smack.sm.predicates;

import org.jivesoftware.smack.filter.StanzaFilter;

/* JADX INFO: loaded from: classes10.dex */
public class Predicate {
    public static StanzaFilter forMessagesOrAfter5Stanzas() {
        return new ForMatchingPredicateOrAfterXStanzas(ForEveryMessage.INSTANCE, 5);
    }

    public static AfterXStanzas after5Stanzas() {
        return new AfterXStanzas(5);
    }
}
