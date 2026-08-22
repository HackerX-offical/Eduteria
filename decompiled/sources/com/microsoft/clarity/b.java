package com.microsoft.clarity;

import android.app.Activity;
import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ClarityConfig f687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f688c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Activity activity, Context context, ClarityConfig clarityConfig) {
        super(0);
        this.f686a = context;
        this.f687b = clarityConfig;
        this.f688c = activity;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Unit invoke() {
        /*
            r4 = this;
            boolean r0 = com.microsoft.clarity.a.h()
            if (r0 == 0) goto Ld
            java.lang.String r0 = "Clarity already initialized."
        L8:
            com.microsoft.clarity.n.i.d(r0)
            goto L82
        Ld:
            boolean r0 = com.microsoft.clarity.a.C0182a.a()
            if (r0 != 0) goto L16
            java.lang.String r0 = "API level not supported. We currently support 29-33 inclusive."
            goto L8
        L16:
            android.content.Context r0 = r4.f686a
            boolean r0 = r0 instanceof android.app.Application
            if (r0 != 0) goto L22
            java.lang.String r0 = "You should pass the application context."
        L1e:
            com.microsoft.clarity.n.i.c(r0)
            goto L82
        L22:
            com.microsoft.clarity.ClarityConfig r0 = r4.f687b
            java.lang.String r0 = r0.getProjectId()
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L31
            java.lang.String r0 = "Invalid project id. It cannot be a blank string."
            goto L1e
        L31:
            com.microsoft.clarity.ClarityConfig r0 = r4.f687b
            boolean r0 = r0.isReactNative$sdk_prodRelease()
            r1 = 1
            java.lang.String r2 = "LiveIngest"
            java.lang.String r3 = "prod"
            if (r0 != 0) goto L4e
            com.microsoft.clarity.ClarityConfig r0 = r4.f687b
            boolean r0 = r0.isCordova$sdk_prodRelease()
            if (r0 != 0) goto L4e
            com.microsoft.clarity.ClarityConfig r0 = r4.f687b
            boolean r0 = r0.isIonic$sdk_prodRelease()
            if (r0 == 0) goto L5e
        L4e:
            android.app.Activity r0 = r4.f688c
            if (r0 != 0) goto L5e
            java.lang.String r0 = "For Cordova, Ionic & ReactNative apps, 'activity' cannot be null."
            com.microsoft.clarity.n.i.c(r0)
            boolean r0 = kotlin.text.StringsKt.contains(r3, r2, r1)
            if (r0 != 0) goto L5e
            goto L82
        L5e:
            boolean r0 = kotlin.text.StringsKt.contains(r3, r2, r1)
            if (r0 != 0) goto L6d
            boolean r0 = androidx.work.WorkManager.isInitialized()
            if (r0 != 0) goto L6d
            java.lang.String r0 = "Work manager has to be initialized before starting Clarity."
            goto L1e
        L6d:
            android.content.Context r0 = r4.f686a
            com.microsoft.clarity.ClarityConfig r1 = r4.f687b
            com.microsoft.clarity.a.C0182a.a(r0, r1)
            android.content.Context r0 = r4.f686a
            android.app.Application r0 = (android.app.Application) r0
            com.microsoft.clarity.ClarityConfig r1 = r4.f687b
            android.app.Activity r2 = r4.f688c
            com.microsoft.clarity.a.C0182a.a(r0, r1, r2)
            com.microsoft.clarity.a.i()
        L82:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.b.invoke():java.lang.Object");
    }
}
