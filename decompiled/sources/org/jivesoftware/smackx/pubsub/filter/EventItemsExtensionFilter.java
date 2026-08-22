package org.jivesoftware.smackx.pubsub.filter;

import org.jivesoftware.smack.filter.ExtensionElementFilter;
import org.jivesoftware.smackx.pubsub.EventElement;
import org.jivesoftware.smackx.pubsub.EventElementType;

/* JADX INFO: loaded from: classes10.dex */
public final class EventItemsExtensionFilter extends ExtensionElementFilter<EventElement> {
    public static final EventItemsExtensionFilter INSTANCE = new EventItemsExtensionFilter();

    private EventItemsExtensionFilter() {
        super(EventElement.class);
    }

    @Override // org.jivesoftware.smack.filter.ExtensionElementFilter
    public boolean accept(EventElement eventElement) {
        return eventElement.getEventType() == EventElementType.items;
    }
}
