package com.google.firebase.database.core.view.filter;

import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class ChildChangeAccumulator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Map<ChildKey, Change> changeMap = new HashMap();

    public void trackChildChange(Change change) {
        Event.EventType eventType = change.getEventType();
        ChildKey childKey = change.getChildKey();
        if (this.changeMap.containsKey(childKey)) {
            Change change2 = this.changeMap.get(childKey);
            Event.EventType eventType2 = change2.getEventType();
            if (eventType == Event.EventType.CHILD_ADDED && eventType2 == Event.EventType.CHILD_REMOVED) {
                this.changeMap.put(change.getChildKey(), Change.childChangedChange(childKey, change.getIndexedNode(), change2.getIndexedNode()));
                return;
            }
            if (eventType == Event.EventType.CHILD_REMOVED && eventType2 == Event.EventType.CHILD_ADDED) {
                this.changeMap.remove(childKey);
                return;
            }
            if (eventType == Event.EventType.CHILD_REMOVED && eventType2 == Event.EventType.CHILD_CHANGED) {
                this.changeMap.put(childKey, Change.childRemovedChange(childKey, change2.getOldIndexedNode()));
                return;
            }
            if (eventType == Event.EventType.CHILD_CHANGED && eventType2 == Event.EventType.CHILD_ADDED) {
                this.changeMap.put(childKey, Change.childAddedChange(childKey, change.getIndexedNode()));
                return;
            } else {
                if (eventType == Event.EventType.CHILD_CHANGED && eventType2 == Event.EventType.CHILD_CHANGED) {
                    this.changeMap.put(childKey, Change.childChangedChange(childKey, change.getIndexedNode(), change2.getOldIndexedNode()));
                    return;
                }
                throw new IllegalStateException("Illegal combination of changes: " + change + " occurred after " + change2);
            }
        }
        this.changeMap.put(change.getChildKey(), change);
    }

    public List<Change> getChanges() {
        return new ArrayList(this.changeMap.values());
    }
}
