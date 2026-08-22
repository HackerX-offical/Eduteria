package com.microsoft.clarity.f;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class i extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f838a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar) {
        super(0);
        this.f838a = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0099  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Unit invoke() {
        /*
            r9 = this;
            com.microsoft.clarity.f.k r0 = r9.f838a
            boolean r1 = r0.f844e
            r2 = 1
            if (r1 != 0) goto L39
            android.content.Context r0 = r0.f840a
            boolean r0 = com.microsoft.clarity.n.c.b(r0)
            if (r0 == 0) goto L39
            com.microsoft.clarity.f.k r0 = r9.f838a
            r0.f844e = r2
            com.microsoft.clarity.f.l r0 = r0.f841b
            java.lang.String r1 = "Clarity_LowDeviceMemory_EventQueueSize"
            r0.a(r1, r2)
            com.microsoft.clarity.f.k r0 = r9.f838a
            com.microsoft.clarity.f.m r0 = r0.f842c
            r0.c()
            com.microsoft.clarity.f.k r0 = r9.f838a
            com.microsoft.clarity.f.l r0 = r0.f841b
            java.lang.String r1 = "LowDeviceMemory"
            r0.b(r1)
            com.microsoft.clarity.f.k r0 = r9.f838a
            com.microsoft.clarity.e.e r0 = r0.f843d
            double r1 = com.microsoft.clarity.n.c.a()
            java.lang.String r3 = "Clarity_LowDeviceMemory_ApplicationFreeMemoryPercentage"
            r0.a(r3, r1)
            goto Lb8
        L39:
            com.microsoft.clarity.f.k r0 = r9.f838a
            boolean r0 = r0.f844e
            r1 = 0
            r3 = 4599075939470750515(0x3fd3333333333333, double:0.3)
            if (r0 != 0) goto L99
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()
            long r5 = r0.totalMemory()
            long r7 = r0.freeMemory()
            long r5 = r5 - r7
            long r7 = r0.maxMemory()
            long r7 = r7 - r5
            long r5 = r0.maxMemory()
            double r7 = (double) r7
            double r5 = (double) r5
            double r7 = r7 / r5
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 >= 0) goto L99
            com.microsoft.clarity.f.k r0 = r9.f838a
            r0.f844e = r2
            com.microsoft.clarity.f.l r0 = r0.f841b
            java.lang.String r2 = "Clarity_LowApplicationMemory_EventQueueSize"
            r0.a(r2, r1)
            com.microsoft.clarity.f.k r0 = r9.f838a
            com.microsoft.clarity.f.l r0 = r0.f841b
            java.lang.String r1 = "LowApplicationFreeMemory"
            r0.b(r1)
            com.microsoft.clarity.f.k r0 = r9.f838a
            com.microsoft.clarity.e.e r0 = r0.f843d
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()
            long r2 = r1.totalMemory()
            long r4 = r1.freeMemory()
            long r2 = r2 - r4
            long r4 = r1.maxMemory()
            long r4 = r4 - r2
            long r1 = r1.maxMemory()
            double r3 = (double) r4
            double r1 = (double) r1
            double r3 = r3 / r1
            java.lang.String r1 = "Clarity_LowApplicationMemory_ApplicationFreeMemoryPercentage"
            r0.a(r1, r3)
            goto Lb8
        L99:
            com.microsoft.clarity.f.k r0 = r9.f838a
            boolean r2 = r0.f844e
            if (r2 == 0) goto Lb8
            android.content.Context r0 = r0.f840a
            boolean r0 = com.microsoft.clarity.n.c.b(r0)
            if (r0 != 0) goto Lb8
            double r5 = com.microsoft.clarity.n.c.a()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 < 0) goto Lb8
            com.microsoft.clarity.f.k r0 = r9.f838a
            r0.f844e = r1
            com.microsoft.clarity.f.l r0 = r0.f841b
            r0.a()
        Lb8:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.f.i.invoke():java.lang.Object");
    }
}
