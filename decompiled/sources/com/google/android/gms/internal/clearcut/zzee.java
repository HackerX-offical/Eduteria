package com.google.android.gms.internal.clearcut;

/* JADX INFO: loaded from: classes8.dex */
final class zzee {

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    private final String f612info;
    private int position = 0;

    zzee(String str) {
        this.f612info = str;
    }

    final boolean hasNext() {
        return this.position < this.f612info.length();
    }

    final int next() {
        String str = this.f612info;
        int i = this.position;
        this.position = i + 1;
        char cCharAt = str.charAt(i);
        if (cCharAt < 55296) {
            return cCharAt;
        }
        int i2 = cCharAt & 8191;
        int i3 = 13;
        while (true) {
            String str2 = this.f612info;
            int i4 = this.position;
            this.position = i4 + 1;
            char cCharAt2 = str2.charAt(i4);
            if (cCharAt2 < 55296) {
                return i2 | (cCharAt2 << i3);
            }
            i2 |= (cCharAt2 & 8191) << i3;
            i3 += 13;
        }
    }
}
