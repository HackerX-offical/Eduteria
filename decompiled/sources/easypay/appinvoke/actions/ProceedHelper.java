package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class ProceedHelper {
    Map<String, String> action;
    Activity activity;
    BroadcastReceiver customEventReceiver = new BroadcastReceiver() { // from class: easypay.appinvoke.actions.ProceedHelper.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String string = intent.getExtras().getString("eventName");
            string.hashCode();
            if (string.equals("proceedProceedHelper")) {
                ProceedHelper.this.proceed();
                ProceedHelper.this.fragment.logEvent("proceeded", ProceedHelper.this.action.get("id"));
            } else if (string.equals("activateProceedHelper")) {
                ProceedHelper.this.activate();
                ProceedHelper.this.fragment.logEvent(AppSettingsData.STATUS_ACTIVATED, ProceedHelper.this.action.get("id"));
            }
        }
    };
    String fields;
    EasypayBrowserFragment fragment;
    String inputKey;
    WebView webview;

    public ProceedHelper(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map) {
        String str;
        this.activity = activity;
        this.fragment = easypayBrowserFragment;
        this.action = map;
        this.webview = webView;
        this.activity.registerReceiver(this.customEventReceiver, new IntentFilter("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT"));
        String str2 = this.action.get(NotificationCompat.GROUP_KEY_SILENT);
        String str3 = this.action.get("autoproceed");
        str2 = str3 != null ? "true" : str2;
        String str4 = this.action.get("fields");
        if (!this.action.get("element").equals("form")) {
            str = "";
        } else {
            str = ".submit()";
        }
        webView.loadUrl("javascript:" + this.action.get("functionStart") + (str4 + "Android.showLog('inside proceed helper'); var a=fields; if(!" + str2 + "){ Android.sendEvent('activateProceedHelper', 0, 0); } if(typeof(autoSubmitForm) == 'undefined'){ autoSubmitForm=function(){Android.showLog('activating proceedhelper1'); a[0]" + (this.action.get("element").equals("input") ? ".click()" : str) + "}; }  if(" + str3 + "){ autoSubmitForm();}") + this.action.get("functionEnd"));
    }

    public void activate() {
        this.activity.runOnUiThread(new Runnable() { // from class: easypay.appinvoke.actions.ProceedHelper.2
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    public void proceed() {
        BroadcastReceiver broadcastReceiver = this.customEventReceiver;
        if (broadcastReceiver != null) {
            this.activity.unregisterReceiver(broadcastReceiver);
        }
        this.webview.loadUrl("javascript:if(typeof(autoSubmitForm) != 'undefined'){Android.showLog('activating proceedhelper0'); autoSubmitForm();}");
    }

    public void reset() {
        try {
            BroadcastReceiver broadcastReceiver = this.customEventReceiver;
            if (broadcastReceiver != null) {
                this.activity.unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
