package a.a.c;

import android.view.View;
import com.billdesk.sdk.EmiActivity;

/* JADX INFO: loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmiActivity f144a;

    public d(EmiActivity emiActivity) {
        this.f144a = emiActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f144a.f392b.setCurrentItem(0);
    }
}
