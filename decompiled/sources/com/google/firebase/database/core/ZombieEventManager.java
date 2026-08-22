package com.google.firebase.database.core;

import com.google.firebase.database.core.view.QuerySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class ZombieEventManager implements EventRegistrationZombieListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ZombieEventManager defaultInstance = new ZombieEventManager();
    final HashMap<EventRegistration, List<EventRegistration>> globalEventRegistrations = new HashMap<>();

    private ZombieEventManager() {
    }

    public static ZombieEventManager getInstance() {
        return defaultInstance;
    }

    public void recordEventRegistration(EventRegistration eventRegistration) {
        synchronized (this.globalEventRegistrations) {
            List<EventRegistration> arrayList = this.globalEventRegistrations.get(eventRegistration);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.globalEventRegistrations.put(eventRegistration, arrayList);
            }
            arrayList.add(eventRegistration);
            if (!eventRegistration.getQuerySpec().isDefault()) {
                EventRegistration eventRegistrationClone = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()));
                List<EventRegistration> arrayList2 = this.globalEventRegistrations.get(eventRegistrationClone);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                    this.globalEventRegistrations.put(eventRegistrationClone, arrayList2);
                }
                arrayList2.add(eventRegistration);
            }
            eventRegistration.setIsUserInitiated(true);
            eventRegistration.setOnZombied(this);
        }
    }

    private void unRecordEventRegistration(EventRegistration eventRegistration) {
        EventRegistration eventRegistrationClone;
        List<EventRegistration> list;
        synchronized (this.globalEventRegistrations) {
            List<EventRegistration> list2 = this.globalEventRegistrations.get(eventRegistration);
            int i = 0;
            if (list2 != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list2.size()) {
                        break;
                    }
                    if (list2.get(i2) == eventRegistration) {
                        list2.remove(i2);
                        break;
                    }
                    i2++;
                }
                if (list2.isEmpty()) {
                    this.globalEventRegistrations.remove(eventRegistration);
                }
            }
            if (!eventRegistration.getQuerySpec().isDefault() && (list = this.globalEventRegistrations.get((eventRegistrationClone = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()))))) != null) {
                while (true) {
                    if (i >= list.size()) {
                        break;
                    }
                    if (list.get(i) == eventRegistration) {
                        list.remove(i);
                        break;
                    }
                    i++;
                }
                if (list.isEmpty()) {
                    this.globalEventRegistrations.remove(eventRegistrationClone);
                }
            }
        }
    }

    public void zombifyForRemove(EventRegistration eventRegistration) {
        synchronized (this.globalEventRegistrations) {
            List<EventRegistration> list = this.globalEventRegistrations.get(eventRegistration);
            if (list != null && !list.isEmpty()) {
                if (eventRegistration.getQuerySpec().isDefault()) {
                    HashSet hashSet = new HashSet();
                    for (int size = list.size() - 1; size >= 0; size--) {
                        EventRegistration eventRegistration2 = list.get(size);
                        if (!hashSet.contains(eventRegistration2.getQuerySpec())) {
                            hashSet.add(eventRegistration2.getQuerySpec());
                            eventRegistration2.zombify();
                        }
                    }
                } else {
                    list.get(0).zombify();
                }
            }
        }
    }

    @Override // com.google.firebase.database.core.EventRegistrationZombieListener
    public void onZombied(EventRegistration eventRegistration) {
        unRecordEventRegistration(eventRegistration);
    }
}
