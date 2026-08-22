package org.jivesoftware.smack.util;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class CleaningWeakReferenceMap<K, V> extends HashMap<K, WeakReference<V>> {
    private static final long serialVersionUID = 0;
    private final int cleanInterval;
    private int numberOfInsertsSinceLastClean;

    public CleaningWeakReferenceMap() {
        this(50);
    }

    public CleaningWeakReferenceMap(int i) {
        this.numberOfInsertsSinceLastClean = 0;
        this.cleanInterval = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public WeakReference<V> put(K k, WeakReference<V> weakReference) {
        WeakReference<V> weakReference2 = (WeakReference) super.put(k, weakReference);
        int i = this.numberOfInsertsSinceLastClean;
        this.numberOfInsertsSinceLastClean = i + 1;
        if (i > this.cleanInterval) {
            this.numberOfInsertsSinceLastClean = 0;
            clean();
        }
        return weakReference2;
    }

    private void clean() {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (next != null && next.getValue() != null && ((WeakReference) next.getValue()).get() == null) {
                it.remove();
            }
        }
    }
}
