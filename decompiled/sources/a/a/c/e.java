package a.a.c;

import android.view.View;
import com.billdesk.sdk.EmiActivity;

/* JADX INFO: loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmiActivity f145a;

    public e(EmiActivity emiActivity) {
        this.f145a = emiActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f145a.f392b.setCurrentItem(1);
    }
}
