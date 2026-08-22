package com.microsoft.clarity.g;

import android.app.Activity;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.microsoft.clarity.g.o;
import com.microsoft.clarity.models.observers.SerializedWebViewEvent;
import com.microsoft.clarity.models.telemetry.ErrorType;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class p extends WebMessagePort.WebMessageCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f1014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WebView f1016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f1017d;

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f1018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebView f1020c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WebMessage f1021d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f1022e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar, int i, WebView webView, WebMessage webMessage, String str) {
            super(0);
            this.f1018a = oVar;
            this.f1019b = i;
            this.f1020c = webView;
            this.f1021d = webMessage;
            this.f1022e = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            Activity activity;
            o oVar = this.f1018a;
            if (!oVar.q) {
                WeakReference<Activity> weakReferenceF = oVar.f997a.f();
                if (weakReferenceF == null || (activity = weakReferenceF.get()) == null || this.f1019b != activity.hashCode()) {
                    com.microsoft.clarity.n.i.b(com.microsoft.clarity.a.b.a("Host Activity in background! Dropping message from webView with Id  ").append(this.f1020c.getUniqueDrawingId()).toString());
                } else {
                    WebMessage webMessage = this.f1021d;
                    String data = webMessage != null ? webMessage.getData() : null;
                    if (data != null) {
                        SerializedWebViewEvent serializedWebViewEventCreate = SerializedWebViewEvent.INSTANCE.create(data, this.f1019b, this.f1022e, this.f1020c.hashCode());
                        Iterator it = this.f1018a.f1000d.iterator();
                        while (it.hasNext()) {
                            ((com.microsoft.clarity.h.g) it.next()).a(serializedWebViewEventCreate);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Exception, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f1023a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(o oVar) {
            super(1);
            this.f1023a = oVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            o.a(this.f1023a, it, ErrorType.WebViewChannelMessageProcessing);
            return Unit.INSTANCE;
        }
    }

    public p(int i, WebView webView, o oVar, String str) {
        this.f1014a = oVar;
        this.f1015b = i;
        this.f1016c = webView;
        this.f1017d = str;
    }

    @Override // android.webkit.WebMessagePort.WebMessageCallback
    public final void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
        com.microsoft.clarity.n.e.a(new a(this.f1014a, this.f1015b, this.f1016c, webMessage, this.f1017d), new b(this.f1014a), (o.c) null, 10);
    }
}
