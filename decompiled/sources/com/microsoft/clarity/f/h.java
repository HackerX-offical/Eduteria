package com.microsoft.clarity.f;

import com.microsoft.clarity.g.o;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes9.dex */
public final class h extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f837a;

    public h(k kVar) {
        this.f837a = kVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        com.microsoft.clarity.n.e.a(new i(this.f837a), new j(this.f837a), (o.c) null, 10);
    }
}
