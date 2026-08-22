package com.google.android.gms.vision.text;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zza implements Comparator<Map.Entry<String, Integer>> {
    zza(TextBlock textBlock) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
        return entry.getValue().compareTo(entry2.getValue());
    }
}
