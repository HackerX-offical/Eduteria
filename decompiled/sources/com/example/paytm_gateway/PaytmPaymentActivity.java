package com.example.paytm_gateway;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.paytm.pgsdk.PaytmConstants;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
import com.paytm.pgsdk.TransactionManager;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PaytmPaymentActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\"\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/example/paytm_gateway/PaytmPaymentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "paytmCallback", "com/example/paytm_gateway/PaytmPaymentActivity$paytmCallback$1", "Lcom/example/paytm_gateway/PaytmPaymentActivity$paytmCallback$1;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "paytm_gateway_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaytmPaymentActivity extends AppCompatActivity {
    public static final int CANCEL = 102;
    public static final int FAILED = 101;
    public static final int SUCCESS = 100;
    private final PaytmPaymentActivity$paytmCallback$1 paytmCallback = new PaytmPaymentTransactionCallback() { // from class: com.example.paytm_gateway.PaytmPaymentActivity$paytmCallback$1
        @Override // com.paytm.pgsdk.PaytmPaymentTransactionCallback
        public void clientAuthenticationFailed(String p0) {
        }

        @Override // com.paytm.pgsdk.PaytmPaymentTransactionCallback
        public void onBackPressedCancelTransaction() {
        }

        @Override // com.paytm.pgsdk.PaytmPaymentTransactionCallback
        public void onErrorLoadingWebPage(int p0, String p1, String p2) {
        }

        @Override // com.paytm.pgsdk.PaytmPaymentTransactionCallback
        public void onErrorProceed(String p0) {
        }

        @Override // com.paytm.pgsdk.PaytmPaymentTransactionCallback
        public void onTransactionCancel(String p0, Bundle p1) {
        }

        @Override // com.paytm.pgsdk.PaytmPaymentTransactionCallback
        public void someUIErrorOccurred(String p0) {
        }

        @Override // com.paytm.pgsdk.PaytmPaymentTransactionCallback
        public void onTransactionResponse(Bundle inResponse) {
            if (StringsKt.equals(inResponse != null ? inResponse.getString(PaytmConstants.STATUS) : null, "TXN_SUCCESS", true)) {
                Intent intent = this.this$0.getIntent();
                intent.putExtra(PaytmConstants.TRANSACTION_ID, inResponse != null ? inResponse.getString(PaytmConstants.TRANSACTION_ID) : null);
                this.this$0.setResult(100, intent);
                this.this$0.finish();
                Toast.makeText(this.this$0, "Payment Successful.", 0).show();
                return;
            }
            if (StringsKt.equals(inResponse != null ? inResponse.getString(PaytmConstants.STATUS) : null, "TXN_FAILURE", true)) {
                this.this$0.setResult(101, this.this$0.getIntent());
                this.this$0.finish();
                Toast.makeText(this.this$0, "Payment Failed.", 0).show();
            }
        }

        @Override // com.paytm.pgsdk.PaytmPaymentTransactionCallback
        public void networkNotAvailable() {
            Toast.makeText(this.this$0.getApplicationContext(), "No Internet.", 0).show();
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("pre_txtid");
            String stringExtra2 = getIntent().getStringExtra("mid");
            String stringExtra3 = getIntent().getStringExtra("txnToken");
            int intExtra = getIntent().getIntExtra("amount", 0);
            String stringExtra4 = getIntent().getStringExtra("url");
            TransactionManager transactionManager = new TransactionManager(new PaytmOrder(stringExtra, stringExtra2, stringExtra3, String.valueOf(intExtra), stringExtra4 + "/theia/paytmCallback?ORDER_ID=" + stringExtra), this.paytmCallback);
            transactionManager.setAppInvokeEnabled(false);
            transactionManager.setShowPaymentUrl(stringExtra4 + "/theia/api/v1/showPaymentPage");
            transactionManager.setEmiSubventionEnabled(true);
            PaytmPaymentActivity paytmPaymentActivity = this;
            transactionManager.startTransaction(paytmPaymentActivity, 100);
            transactionManager.startTransactionAfterCheckingLoginStatus(paytmPaymentActivity, stringExtra2, 100);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            String string = null;
            if (StringsKt.equals((data == null || (extras3 = data.getExtras()) == null) ? null : extras3.getString(PaytmConstants.STATUS), "TXN_SUCCESS", true)) {
                Intent intent = getIntent();
                if (data != null && (extras2 = data.getExtras()) != null) {
                    string = extras2.getString(PaytmConstants.TRANSACTION_ID);
                }
                intent.putExtra(PaytmConstants.TRANSACTION_ID, string);
                setResult(100, intent);
                finish();
                Toast.makeText(this, "Payment Successful.", 0).show();
                return;
            }
            if (data != null && (extras = data.getExtras()) != null) {
                string = extras.getString(PaytmConstants.STATUS);
            }
            if (StringsKt.equals(string, "TXN_FAILURE", true)) {
                setResult(101, getIntent());
                finish();
                Toast.makeText(this, "Payment Failed.", 0).show();
            }
        }
    }
}
