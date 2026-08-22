package org.jivesoftware.smackx.pubsub.listener;

import org.jivesoftware.smackx.pubsub.ItemDeleteEvent;

/* JADX INFO: loaded from: classes10.dex */
public interface ItemDeleteListener {
    void handleDeletedItems(ItemDeleteEvent itemDeleteEvent);

    void handlePurge();
}
