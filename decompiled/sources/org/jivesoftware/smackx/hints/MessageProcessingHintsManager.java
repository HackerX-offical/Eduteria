package org.jivesoftware.smackx.hints;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.hints.element.MessageProcessingHintType;
import org.jivesoftware.smackx.hints.element.NoCopyHint;
import org.jivesoftware.smackx.hints.element.NoPermanentStoreHint;
import org.jivesoftware.smackx.hints.element.NoStoreHint;
import org.jivesoftware.smackx.hints.element.StoreHint;

/* JADX INFO: loaded from: classes10.dex */
public class MessageProcessingHintsManager {
    public static Set<MessageProcessingHintType> getHintsFrom(Message message) {
        HashSet hashSet;
        if (NoCopyHint.hasHint(message)) {
            hashSet = new HashSet(MessageProcessingHintType.values().length);
            hashSet.add(MessageProcessingHintType.no_copy);
        } else {
            hashSet = null;
        }
        if (NoPermanentStoreHint.hasHint(message)) {
            if (hashSet == null) {
                hashSet = new HashSet(MessageProcessingHintType.values().length);
            }
            hashSet.add(MessageProcessingHintType.no_permanent_store);
        }
        if (NoStoreHint.hasHint(message)) {
            if (hashSet == null) {
                hashSet = new HashSet(MessageProcessingHintType.values().length);
            }
            hashSet.add(MessageProcessingHintType.no_store);
        }
        if (StoreHint.hasHint(message)) {
            if (hashSet == null) {
                hashSet = new HashSet(MessageProcessingHintType.values().length);
            }
            hashSet.add(MessageProcessingHintType.store);
        }
        return hashSet == null ? Collections.emptySet() : hashSet;
    }
}
