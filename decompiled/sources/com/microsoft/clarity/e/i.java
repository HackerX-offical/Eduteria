package com.microsoft.clarity.e;

import com.microsoft.clarity.e.h;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((h.a) t2).c()), Integer.valueOf(((h.a) t).c()));
    }
}
