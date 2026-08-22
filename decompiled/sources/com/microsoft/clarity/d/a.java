package com.microsoft.clarity.d;

import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f707c = new HashMap();

    /* JADX INFO: renamed from: com.microsoft.clarity.d.a$a, reason: collision with other inner class name */
    public static class C0185a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final short f710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f711d;

        public C0185a(int i, int i2, short s, int i3) {
            this.f708a = i;
            this.f709b = i2;
            this.f710c = s;
            this.f711d = i3;
        }
    }

    public final int a() {
        return this.f705a;
    }

    public final int a(int i) {
        Integer num = (Integer) this.f707c.get(Integer.valueOf(i));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
