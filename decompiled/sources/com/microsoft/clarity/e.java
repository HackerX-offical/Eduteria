package com.microsoft.clarity;

import android.app.Application;
import android.os.Handler;
import com.microsoft.clarity.a;
import com.microsoft.clarity.g.e;
import com.microsoft.clarity.models.DynamicConfig;
import com.microsoft.clarity.models.telemetry.ErrorType;
import com.microsoft.clarity.n.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ClarityConfig f731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.microsoft.clarity.g.g f732c;

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ClarityConfig f734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.microsoft.clarity.g.g f735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f736d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Application application, ClarityConfig clarityConfig, com.microsoft.clarity.g.g gVar, e eVar) {
            super(0);
            this.f733a = application;
            this.f734b = clarityConfig;
            this.f735c = gVar;
            this.f736d = eVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            if (DynamicConfig.INSTANCE.isFetched(this.f733a)) {
                i.d("Clarity server config has been fetched.");
                DynamicConfig dynamicConfig = new DynamicConfig(this.f733a);
                if (dynamicConfig.getIsClarityActivated()) {
                    Handler handler = com.microsoft.clarity.a.f656a;
                    a.C0182a.a(this.f733a, this.f734b, dynamicConfig, this.f735c);
                    i.d("Clarity started.");
                } else {
                    i.e("Clarity is deactivated.");
                    this.f735c.d();
                }
            } else {
                int i = com.microsoft.clarity.a.f659d + 1;
                com.microsoft.clarity.a.f659d = i;
                if (i < 25) {
                    com.microsoft.clarity.a.f656a.postDelayed(this.f736d, 1000L);
                } else {
                    i.c("Clarity failed to fetch project configuration from the servers, please check your network.");
                    this.f735c.d();
                    com.microsoft.clarity.a.f658c = false;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Exception, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f737a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            Handler handler = com.microsoft.clarity.a.f656a;
            a.C0182a.a(it, ErrorType.Initialization);
            return Unit.INSTANCE;
        }
    }

    public e(Application application, ClarityConfig clarityConfig, com.microsoft.clarity.g.g gVar) {
        this.f730a = application;
        this.f731b = clarityConfig;
        this.f732c = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.microsoft.clarity.n.e.a(new a(this.f730a, this.f731b, this.f732c, this), b.f737a, (e.c) null, 26);
    }
}
