package com.billdesk.sdk;

import a.a.c.d;
import a.a.c.e;
import a.a.c.f;
import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.billdesk.utils.ResourceConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class EmiActivity extends BaseClass {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager f392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap<String, Object> f396f;

    public class a extends FragmentStatePagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String[] f397a;

        public a(FragmentManager fragmentManager, String[] strArr) {
            super(fragmentManager);
            this.f397a = strArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            if (i == 0) {
                EmiActivity emiActivity = EmiActivity.this;
                return new TenureFragment(emiActivity.f393c, emiActivity.f396f, emiActivity);
            }
            if (i != 1) {
                return null;
            }
            EmiActivity emiActivity2 = EmiActivity.this;
            return new BankFragment(emiActivity2.f393c, emiActivity2.f396f, emiActivity2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.f397a[i];
        }
    }

    @Override // com.billdesk.sdk.BaseClass, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        try {
            setRequestedOrientation(1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(Helper.a(this, 17, -1, -1, new int[]{0, 0, 0, 0}));
        linearLayout.setBackgroundColor(Helper.c("bd_body_bg", ResourceConstants.f522b, this));
        linearLayout.setOrientation(1);
        linearLayout.addView(Helper.a("", (Activity) this));
        setContentView(linearLayout);
        Bundle extras = getIntent().getExtras();
        this.f396f = (HashMap) extras.get("paymentDetail");
        this.f393c = extras.getString("data");
        int i = (int) (getResources().getDisplayMetrics().density * 10.0f);
        LinearLayout linearLayoutA = Helper.a((Activity) this);
        linearLayoutA.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayoutA.setPadding(i, i, i, i);
        linearLayoutA.setGravity(48);
        TextView textView = new TextView(this);
        textView.setText("Payment Amount: ₹ " + PaymentLibConstants.f514e);
        Helper.a(textView, false, (Activity) this);
        textView.setGravity(17);
        textView.setTextSize(2, 20.0f);
        textView.setPadding(10, 30, 10, 30);
        linearLayoutA.addView(textView);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setWeightSum(2.0f);
        linearLayout2.setPadding(0, i, 0, i);
        TextView textView2 = new TextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        textView2.setLayoutParams(layoutParams);
        textView2.setText("Tenure");
        textView2.setGravity(17);
        Helper.a(textView2, false, (Activity) this);
        textView2.setTextSize(2, 18.0f);
        textView2.setOnClickListener(new d(this));
        linearLayout2.addView(textView2);
        TextView textView3 = new TextView(this);
        textView3.setLayoutParams(layoutParams);
        textView3.setText("Bank");
        textView3.setGravity(17);
        Helper.a(textView3, false, (Activity) this);
        textView3.setTextSize(2, 18.0f);
        textView3.setOnClickListener(new e(this));
        linearLayout2.addView(textView3);
        linearLayoutA.addView(linearLayout2);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(0);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, i / 5));
        linearLayout3.setWeightSum(2.0f);
        this.f394d = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1, 1.0f);
        this.f394d.setLayoutParams(layoutParams2);
        this.f394d.setBackgroundColor(getResources().getColor(R.color.bd_button_bg));
        LinearLayout linearLayout4 = new LinearLayout(this);
        this.f395e = linearLayout4;
        linearLayout4.setLayoutParams(layoutParams2);
        this.f395e.setBackgroundColor(-7829368);
        linearLayout3.addView(this.f394d);
        linearLayout3.addView(this.f395e);
        linearLayoutA.addView(linearLayout3);
        ViewPager viewPager = new ViewPager(this);
        this.f392b = viewPager;
        viewPager.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f392b.setOnPageChangeListener(new f(this));
        linearLayoutA.addView(this.f392b);
        a aVar = new a(getSupportFragmentManager(), new String[]{"Tenure", "Bank"});
        this.f391a = aVar;
        this.f392b.setAdapter(aVar);
        linearLayout.addView(linearLayoutA);
    }
}
