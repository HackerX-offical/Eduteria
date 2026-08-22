package com.billdesk.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.billdesk.utils.Helper;
import com.billdesk.utils.PaymentLibConstants;
import com.billdesk.utils.URLUtilAsync;
import com.clevertap.android.sdk.Constants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class BaseClass extends FragmentActivity {

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PaymentLibConstants.f515f = false;
            PaymentLibConstants.f516g = false;
            PaymentLibConstants.w = true;
            BaseClass.this.finish();
        }
    }

    public final View a(boolean z) {
        URLUtilAsync uRLUtilAsync;
        int i = getResources().getConfiguration().orientation == 2 ? 38 : 12;
        Button button = new Button(this);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        button.setText("<< Pay via Other Modes");
        button.setBackgroundColor(getResources().getColor(R.color.bd_footer_bg));
        button.setTextColor(getResources().getColor(R.color.bd_button_bg));
        button.setPaintFlags(button.getPaintFlags() | 8);
        button.setLayoutParams(Helper.a(this, 16, i, 70, new int[]{0, 0, 0, 0}));
        button.setGravity(19);
        if (PaymentLibConstants.f515f && z) {
            linearLayout.addView(button);
        } else {
            TextView textView = new TextView(this);
            textView.setText("");
            textView.setBackgroundColor(getResources().getColor(R.color.bd_footer_bg));
            textView.setLayoutParams(Helper.a(this, 16, i, 70, new int[]{0, 0, 0, 0}));
            textView.setGravity(19);
            linearLayout.addView(textView);
        }
        button.setOnClickListener(new a());
        LinearLayout linearLayout2 = new LinearLayout(this);
        int i2 = getResources().getConfiguration().orientation == 2 ? 20 : 12;
        linearLayout2.setLayoutParams(Helper.a(this, 17, i2, 30, new int[]{0, 0, 0, 0}));
        linearLayout2.setBackgroundColor(getResources().getColor(R.color.bd_footer_bg));
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_END);
        imageView.setPadding(0, 0, 30, 40);
        HashMap<String, String> map = PaymentLibConstants.o;
        if (map != null) {
            String str = map.get("footer_logo");
            Context applicationContext = getApplicationContext();
            HashMap<String, Object> map2 = PaymentLibConstants.p;
            if (map2 == null) {
                PaymentLibConstants.p = new HashMap<>();
                uRLUtilAsync = new URLUtilAsync(imageView, str, applicationContext);
            } else if (map2.get(str) != null) {
                imageView.setImageBitmap((Bitmap) PaymentLibConstants.p.get(str));
                uRLUtilAsync = null;
            } else {
                String str2 = "Fetching for key [" + str + Constants.AES_SUFFIX;
                uRLUtilAsync = new URLUtilAsync(imageView, str, applicationContext);
            }
            String str3 = "huh [" + uRLUtilAsync + Constants.AES_SUFFIX;
        }
        imageView.setLayoutParams(Helper.a(this, 17, i2, 30, new int[]{0, 0, 0, 0}));
        linearLayout2.addView(imageView);
        linearLayout.addView(linearLayout2);
        return linearLayout;
    }

    public final Button a(String str) {
        return Helper.a((Activity) this, str);
    }

    public final LinearLayout a() {
        return Helper.a((Activity) this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setTheme(android.R.style.Theme.Holo.Light);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
