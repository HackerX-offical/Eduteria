package a.a.c;

import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.billdesk.sdk.EmiActivity;
import com.billdesk.sdk.R;

/* JADX INFO: loaded from: classes.dex */
public class f implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EmiActivity f146a;

    public f(EmiActivity emiActivity) {
        this.f146a = emiActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        LinearLayout linearLayout;
        if (i == 1) {
            EmiActivity emiActivity = this.f146a;
            emiActivity.f395e.setBackgroundColor(emiActivity.getResources().getColor(R.color.bd_button_bg));
            linearLayout = this.f146a.f394d;
        } else {
            EmiActivity emiActivity2 = this.f146a;
            emiActivity2.f394d.setBackgroundColor(emiActivity2.getResources().getColor(R.color.bd_button_bg));
            linearLayout = this.f146a.f395e;
        }
        linearLayout.setBackgroundColor(-7829368);
    }
}
