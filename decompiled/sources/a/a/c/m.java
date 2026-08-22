package a.a.c;

import android.content.Context;
import com.billdesk.sdk.QuickPayView;
import com.billdesk.utils.OnSwipeTouchListener;

/* JADX INFO: loaded from: classes.dex */
public class m extends OnSwipeTouchListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ QuickPayView f166b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(QuickPayView quickPayView, Context context) {
        super(context);
        this.f166b = quickPayView;
    }

    @Override // com.billdesk.utils.OnSwipeTouchListener
    public void a() {
        this.f166b.b();
    }
}
