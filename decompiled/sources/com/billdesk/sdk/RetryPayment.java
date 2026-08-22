package com.billdesk.sdk;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.billdesk.utils.ResourceConstants;

/* JADX INFO: loaded from: classes6.dex */
public class RetryPayment extends BaseClass {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f447a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f448b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnClickListener f449c = new b();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(RetryPayment.this, (Class<?>) PaymentWebView.class);
            intent.putExtra("paymentDetail", PaymentLibConstants.n);
            intent.putExtra("url", PaymentLibConstants.m);
            RetryPayment.this.startActivity(intent);
            RetryPayment.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RetryPayment.this.finish();
        }
    }

    @Override // com.billdesk.sdk.BaseClass, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Helper.c(this);
        this.f447a = getIntent().getExtras().getString("error");
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(Helper.a(this, 17, -2, 0, new int[]{0, 0, 0, 0}));
        linearLayout.setBackgroundColor(Helper.c("bd_body_bg", ResourceConstants.f522b, this));
        linearLayout.setOrientation(1);
        linearLayout.addView(Helper.a("", (Activity) this));
        int i = (int) (getResources().getDisplayMetrics().density * 10.0f);
        ScrollView scrollView = new ScrollView(this);
        LinearLayout linearLayoutA = Helper.a((Activity) this);
        linearLayoutA.setLayoutParams(Helper.a(this, 48, -1, -1, new int[]{0, 0, 0, 0}));
        linearLayoutA.setPadding(i, i, i, i);
        linearLayoutA.setGravity(48);
        TextView textView = new TextView(this);
        textView.setText("Transaction Declined - " + this.f447a);
        Helper.a(textView, false, (Activity) this);
        textView.setGravity(17);
        textView.setTextSize(2, 20.0f);
        int i2 = i * 3;
        textView.setPadding(i, i2, i, i2);
        byte[] bArrDecode = Base64.decode("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", 0);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        int i3 = i * 4;
        bitmapDrawable.setBounds(0, 0, i3, i3);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        linearLayoutA.addView(textView);
        int iA = Helper.a("bd_label_bg_img", getApplicationContext());
        Button button = new Button(this);
        button.setText("Retry Payment");
        Helper.a((TextView) button, false, (Activity) this);
        button.setTextSize(2, Helper.a("button_font_size", ResourceConstants.f527g, this) / getResources().getDisplayMetrics().density);
        button.setTextColor(getResources().getColor(R.color.bd_label_text));
        button.setLayoutParams(Helper.a(this, 17, 12, 90, new int[]{i, i, i, i}));
        if (iA != 0) {
            button.setBackgroundDrawable(getResources().getDrawable(iA));
        } else {
            button.setBackground(ContextCompat.getDrawable(this, R.drawable.label_bg_img));
        }
        button.setOnClickListener(this.f448b);
        linearLayoutA.addView(button);
        Button button2 = new Button(this);
        button2.setText("Return to " + getResources().getString(R.string.app_name));
        Helper.a((TextView) button2, false, (Activity) this);
        button2.setTextSize(2, Helper.a("button_font_size", ResourceConstants.f527g, this) / getResources().getDisplayMetrics().density);
        button2.setTextColor(getResources().getColor(R.color.bd_label_text));
        button2.setLayoutParams(Helper.a(this, 17, 12, 90, new int[]{i, i, i, i}));
        if (iA != 0) {
            button2.setBackgroundDrawable(getResources().getDrawable(iA));
        } else {
            button.setBackground(ContextCompat.getDrawable(this, R.drawable.label_bg_img));
        }
        button2.setOnClickListener(this.f449c);
        linearLayoutA.addView(button2);
        linearLayoutA.addView(a(true));
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 0.85f));
        scrollView.addView(linearLayoutA);
        scrollView.setFillViewport(true);
        linearLayout.addView(scrollView);
        setContentView(linearLayout);
    }
}
