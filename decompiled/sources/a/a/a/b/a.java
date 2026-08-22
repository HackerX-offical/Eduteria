package a.a.a.b;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f123b;

    public a(Context context, String str) {
        this.f122a = context;
        this.f123b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f122a, this.f123b, 0).show();
    }
}
