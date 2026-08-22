package com.microsoft.clarity.g;

import android.app.Activity;
import com.microsoft.clarity.g.e;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f992b;

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m f995c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, Activity activity, m mVar) {
            super(0);
            this.f993a = lVar;
            this.f994b = activity;
            this.f995c = mVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.f993a.b(this.f994b);
            l lVar = this.f993a;
            if (lVar.f978f > 5) {
                com.microsoft.clarity.n.i.e("Number of registrations exceeded the limit.");
            } else {
                lVar.f974b.postDelayed(this.f995c, com.microsoft.clarity.a.d.f685b);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Exception, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f996a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l lVar) {
            super(1);
            this.f996a = lVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            l.a(this.f996a, it, ErrorType.SettingWindowCallback);
            return Unit.INSTANCE;
        }
    }

    public m(l lVar, Activity activity) {
        this.f991a = lVar;
        this.f992b = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.microsoft.clarity.n.e.a(new a(this.f991a, this.f992b, this), new b(this.f991a), (e.c) null, 26);
    }
}
