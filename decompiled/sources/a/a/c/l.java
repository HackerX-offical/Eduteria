package a.a.c;

import android.content.DialogInterface;
import android.util.Log;
import android.webkit.SslErrorHandler;
import com.billdesk.sdk.PaymentWebView;
import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SslErrorHandler f164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PaymentWebView f165b;

    public l(PaymentWebView paymentWebView, SslErrorHandler sslErrorHandler) {
        this.f165b = paymentWebView;
        this.f164a = sslErrorHandler;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.f164a.cancel();
            this.f165b.finish();
        } catch (Exception e2) {
            Log.e(this.f165b.f416a, "Error in Ssl bypass-no : [" + e2.getMessage() + Constants.AES_SUFFIX);
        }
    }
}
