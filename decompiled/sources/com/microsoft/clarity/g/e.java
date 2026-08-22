package com.microsoft.clarity.g;

import android.app.Activity;
import com.microsoft.clarity.models.display.ErrorDisplayFrame;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.microsoft.clarity.g.b f943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f946d;

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.microsoft.clarity.g.b f947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f948b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.microsoft.clarity.g.b bVar, Activity activity) {
            super(0);
            this.f947a = bVar;
            this.f948b = activity;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            com.microsoft.clarity.g.b bVar = this.f947a;
            com.microsoft.clarity.n.m.a("Clarity_CaptureFrame", bVar.f887d, new d(bVar, this.f948b));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Exception, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.microsoft.clarity.g.b f949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f951c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.microsoft.clarity.g.b bVar, String str, int i) {
            super(1);
            this.f949a = bVar;
            this.f950b = str;
            this.f951c = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            this.f949a.b(it, ErrorType.FramePictureCapture);
            com.microsoft.clarity.g.b bVar = this.f949a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            String activityName = this.f950b;
            Intrinsics.checkNotNullExpressionValue(activityName, "activityName");
            int i = this.f951c;
            String message = it.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.b(new ErrorDisplayFrame(jCurrentTimeMillis, activityName, i, message));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.microsoft.clarity.g.b f952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f953b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.microsoft.clarity.g.b bVar, e eVar) {
            super(0);
            this.f952a = bVar;
            this.f953b = eVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.f952a.j.postDelayed(this.f953b, com.microsoft.clarity.a.d.f684a);
            return Unit.INSTANCE;
        }
    }

    public e(com.microsoft.clarity.g.b bVar, Activity activity, String str, int i) {
        this.f943a = bVar;
        this.f944b = activity;
        this.f945c = str;
        this.f946d = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.microsoft.clarity.n.e.a(new a(this.f943a, this.f944b), new b(this.f943a, this.f945c, this.f946d), new c(this.f943a, this), 18);
    }
}
