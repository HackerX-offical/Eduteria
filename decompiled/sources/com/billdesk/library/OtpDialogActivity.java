package com.billdesk.library;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.appnew.android.Payment.Credentials;
import org.jivesoftware.smack.sasl.packet.SaslNonza;

/* JADX INFO: loaded from: classes6.dex */
public class OtpDialogActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f336f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f338h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f331a = OtpDialogActivity.class.getName();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f337g = 0;
    public final String[] i = {"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"};
    public Runnable j = new d();
    public BroadcastReceiver k = new e();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OtpDialogActivity otpDialogActivity = OtpDialogActivity.this;
            int i = otpDialogActivity.f337g;
            if (i <= 0) {
                Toast.makeText(otpDialogActivity, "Powered By BillDesk", 1).show();
                OtpDialogActivity.a(OtpDialogActivity.this);
                OtpDialogActivity otpDialogActivity2 = OtpDialogActivity.this;
                otpDialogActivity2.f338h.postDelayed(otpDialogActivity2.j, 30000L);
                return;
            }
            if (i < 8) {
                otpDialogActivity.f338h.postDelayed(otpDialogActivity.j, 30000L);
                OtpDialogActivity.a(OtpDialogActivity.this);
            } else if (i >= 8) {
                Toast.makeText(otpDialogActivity, "BillDesk OTP Reader v1.0.3", 1).show();
                OtpDialogActivity otpDialogActivity3 = OtpDialogActivity.this;
                otpDialogActivity3.f338h.postDelayed(otpDialogActivity3.j, 30000L);
                OtpDialogActivity.a(OtpDialogActivity.this);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OtpDialogActivity.this.finish();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (OtpDialogActivity.this.f335e.equals("APPROVE")) {
                OtpDialogActivity.this.a(true);
            } else {
                OtpDialogActivity otpDialogActivity = OtpDialogActivity.this;
                String str = otpDialogActivity.f333c;
                otpDialogActivity.getClass();
                ((ClipboardManager) otpDialogActivity.f336f.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str));
                Toast.makeText(otpDialogActivity.f336f, "OTP copied to clipboard", 0).show();
            }
            OtpDialogActivity.this.finish();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OtpDialogActivity.this.f338h.removeCallbacks(this);
            String str = OtpDialogActivity.this.f331a;
            String str2 = "Timer reset from " + OtpDialogActivity.this.f337g;
            OtpDialogActivity.this.f337g = 0;
        }
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            OtpDialogActivity otpDialogActivity = OtpDialogActivity.this;
            String str = otpDialogActivity.f331a;
            otpDialogActivity.finish();
        }
    }

    public static /* synthetic */ int a(OtpDialogActivity otpDialogActivity) {
        int i = otpDialogActivity.f337g;
        otpDialogActivity.f337g = i + 1;
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View a() {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.billdesk.library.OtpDialogActivity.a():android.view.View");
    }

    public final void a(boolean z) {
        Intent intent = new Intent("com.billdesk.library.DialogRequest");
        intent.putExtra(SaslNonza.Response.ELEMENT, z);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f338h = new Handler();
            LocalBroadcastManager.getInstance(this).registerReceiver(this.k, new IntentFilter("com.billdesk.library.CloseDialog"));
            this.f336f = this;
            this.f337g = 0;
            this.f332b = (int) ((getResources().getDisplayMetrics().densityDpi / 160.0f) * 8.0f);
            this.f333c = getIntent().getStringExtra("OTP");
            try {
                this.f334d = getIntent().getStringExtra("sender");
            } catch (Exception unused) {
                this.f334d = Credentials.BILLDESK;
            }
            try {
                this.f335e = getIntent().getStringExtra("type");
            } catch (Exception unused2) {
                this.f335e = "COPY";
            }
            requestWindowFeature(1);
            setContentView(a());
            Window window = getWindow();
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setLayout(-1, -2);
            window.setGravity(17);
            setFinishOnTouchOutside(false);
        } catch (Exception e2) {
            Log.e(this.f331a, "Unable to show otpdialog", e2);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.k);
        super.onDestroy();
    }
}
