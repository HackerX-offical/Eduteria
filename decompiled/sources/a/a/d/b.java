package a.a.d;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f179b;

    public b(Context context, String str) {
        this.f178a = context;
        this.f179b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f178a, this.f179b, 1).show();
    }
}
