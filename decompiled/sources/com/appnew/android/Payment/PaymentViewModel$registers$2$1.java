package com.appnew.android.Payment;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: PaymentViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/appnew/android/Payment/PaymentViewModel$registers$2$1", "Ljava/lang/Thread;", "run", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaymentViewModel$registers$2$1 extends Thread {
    final /* synthetic */ String $html_str_data;
    final /* synthetic */ PaymentGatewayListener $paymentGatewayListener;
    final /* synthetic */ PaymentViewModel this$0;

    PaymentViewModel$registers$2$1(String str, PaymentViewModel paymentViewModel, PaymentGatewayListener paymentGatewayListener) {
        this.$html_str_data = str;
        this.this$0 = paymentViewModel;
        this.$paymentGatewayListener = paymentGatewayListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Element elementFirst = Jsoup.parse(this.$html_str_data).select("table").first();
        Intrinsics.checkNotNull(elementFirst);
        final Element element = elementFirst.select("tr").get(1).select("td").get(1);
        AppCompatActivity appCompatActivity = this.this$0.activity;
        if (appCompatActivity != null) {
            final PaymentGatewayListener paymentGatewayListener = this.$paymentGatewayListener;
            appCompatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Payment.PaymentViewModel$registers$2$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PaymentViewModel$registers$2$1.run$lambda$0(element, paymentGatewayListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$0(Element element, PaymentGatewayListener paymentGatewayListener) {
        paymentGatewayListener.onSuccess(element.text());
    }
}
