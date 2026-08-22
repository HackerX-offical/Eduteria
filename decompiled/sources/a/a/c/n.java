package a.a.c;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import com.billdesk.sdk.QuickPayView;

/* JADX INFO: loaded from: classes.dex */
public class n implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver f167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ListView f168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ QuickPayView f169c;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.f169c.p.a();
            n.this.f169c.q = false;
            n.this.f169c.j.setEnabled(true);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.f169c.p.a();
            n.this.f169c.q = false;
            n.this.f169c.j.setEnabled(true);
        }
    }

    public n(QuickPayView quickPayView, ViewTreeObserver viewTreeObserver, ListView listView) {
        this.f169c = quickPayView;
        this.f167a = viewTreeObserver;
        this.f168b = listView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        Runnable bVar;
        this.f167a.removeOnPreDrawListener(this);
        int firstVisiblePosition = this.f168b.getFirstVisiblePosition();
        boolean z = true;
        for (int i = 0; i < this.f168b.getChildCount(); i++) {
            View childAt = this.f168b.getChildAt(i);
            Integer num = this.f169c.s.get(Long.valueOf(this.f169c.i.getItemId(firstVisiblePosition + i)));
            int top = childAt.getTop();
            if (num == null) {
                int height = childAt.getHeight() + this.f168b.getDividerHeight();
                if (i <= 0) {
                    height = -height;
                }
                childAt.setTranslationY(Integer.valueOf(height + top).intValue() - top);
                childAt.animate().setDuration(150L).translationY(0.0f);
                if (z) {
                    viewPropertyAnimatorAnimate = childAt.animate();
                    bVar = new b();
                    viewPropertyAnimatorAnimate.withEndAction(bVar);
                    z = false;
                }
            } else if (num.intValue() != top) {
                childAt.setTranslationY(num.intValue() - top);
                childAt.animate().setDuration(150L).translationY(0.0f);
                if (z) {
                    viewPropertyAnimatorAnimate = childAt.animate();
                    bVar = new a();
                    viewPropertyAnimatorAnimate.withEndAction(bVar);
                    z = false;
                }
            }
        }
        this.f169c.s.clear();
        return true;
    }
}
