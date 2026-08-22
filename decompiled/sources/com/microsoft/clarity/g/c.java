package com.microsoft.clarity.g;

import android.webkit.WebView;
import com.microsoft.clarity.g.b.e;
import java.lang.reflect.InvocationHandler;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends Lambda implements Function0<InvocationHandler> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WebView f939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f940d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, WebView webView, Object obj) {
        super(0);
        this.f937a = bVar;
        this.f938b = i;
        this.f939c = webView;
        this.f940d = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final InvocationHandler invoke() {
        return this.f937a.new e(this.f938b, this.f939c.getWidth(), this.f939c.getHeight(), this.f940d, com.microsoft.clarity.n.n.a(this.f939c));
    }
}
