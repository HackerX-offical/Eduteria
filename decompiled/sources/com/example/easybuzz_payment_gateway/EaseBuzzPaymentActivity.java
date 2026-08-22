package com.example.easybuzz_payment_gateway;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.Utils.Const;
import com.easebuzz.payment.kit.PWECouponsActivity;
import com.paytm.pgsdk.PaytmConstants;
import datamodels.PWEStaticDataModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: EaseBuzzPaymentActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/example/easybuzz_payment_gateway/EaseBuzzPaymentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "pweActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getPweActivityResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setPweActivityResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "Companion", "easybuzz_payment_gateway_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EaseBuzzPaymentActivity extends AppCompatActivity {
    public static final int CANCEL = 102;
    public static final int FAILED = 101;
    public static final int SUCCESS = 100;
    private ActivityResultLauncher<Intent> pweActivityResultLauncher;

    public final ActivityResultLauncher<Intent> getPweActivityResultLauncher() {
        return this.pweActivityResultLauncher;
    }

    public final void setPweActivityResultLauncher(ActivityResultLauncher<Intent> activityResultLauncher) {
        this.pweActivityResultLauncher = activityResultLauncher;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ease_buzz_payment);
        if (getIntent() == null) {
            return;
        }
        this.pweActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.example.easybuzz_payment_gateway.EaseBuzzPaymentActivity$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                EaseBuzzPaymentActivity.onCreate$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        String stringExtra = getIntent().getStringExtra("mode");
        String stringExtra2 = getIntent().getStringExtra("access_code");
        Intent intent = new Intent(getBaseContext(), (Class<?>) PWECouponsActivity.class);
        intent.setFlags(131072);
        intent.putExtra(Const.ZOOM_ACCESS_KEY, stringExtra2);
        intent.putExtra("pay_mode", StringsKt.equals$default(stringExtra, "dev", false, 2, null) ? Const.TEST : "production");
        ActivityResultLauncher<Intent> activityResultLauncher = this.pweActivityResultLauncher;
        Intrinsics.checkNotNull(activityResultLauncher);
        activityResultLauncher.launch(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(EaseBuzzPaymentActivity easeBuzzPaymentActivity, ActivityResult activityResult) {
        Intent data = activityResult.getData();
        if (data != null) {
            try {
                if (StringsKt.equals$default(data.getStringExtra("result"), PWEStaticDataModel.TXN_SUCCESS_CODE, false, 2, null)) {
                    String strOptString = new JSONObject(data.getStringExtra("payment_response")).optString("easepayid");
                    Intent intent = easeBuzzPaymentActivity.getIntent();
                    intent.putExtra(PaytmConstants.TRANSACTION_ID, strOptString);
                    easeBuzzPaymentActivity.setResult(100, intent);
                    easeBuzzPaymentActivity.finish();
                    Toast.makeText(easeBuzzPaymentActivity, "Payment Successful.", 0).show();
                    return;
                }
                easeBuzzPaymentActivity.setResult(101, easeBuzzPaymentActivity.getIntent());
                easeBuzzPaymentActivity.finish();
                Toast.makeText(easeBuzzPaymentActivity, "Payment Failed.", 0).show();
            } catch (Exception e2) {
                Log.e("EaseBuzzPaymentActivity", "Exception: " + e2.getLocalizedMessage());
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        try {
            setResult(101, getIntent());
        } catch (Exception unused) {
        }
    }
}
