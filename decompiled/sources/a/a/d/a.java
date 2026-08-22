package a.a.d;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f177b;

    public a(Context context, String str) {
        this.f176a = context;
        this.f177b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f176a, this.f177b, 1).show();
    }
}
