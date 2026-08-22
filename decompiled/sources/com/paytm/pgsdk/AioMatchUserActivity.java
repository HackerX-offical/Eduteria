package com.paytm.pgsdk;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* JADX INFO: loaded from: classes9.dex */
public class AioMatchUserActivity extends AppCompatActivity {
    public static final String CHECK_USER_LOGIN_ONLY = "check_user_login_only";
    private final int userCompareRequestCode = 12;
    private final int userLoggedInRequestCode = 13;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(R.style.TransparentActivityTheme);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        if (getIntent().getBooleanExtra(CHECK_USER_LOGIN_ONLY, false)) {
            invokePaytmAppToCheckIfAppIsLoggedIn();
        } else {
            if (invokePaytmAppToCompareUsers(getIntent())) {
                return;
            }
            publishBroadcast(false);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        boolean z = false;
        if (i == 12 && intent != null) {
            if (i2 == -1 && intent.getExtras() != null) {
                z = intent.getExtras().getBoolean("IF_USER_MATCHES", false);
            }
            publishBroadcast(z);
            return;
        }
        if (i != 13 || intent == null) {
            return;
        }
        if (i2 == -1 && intent.getExtras() != null) {
            z = intent.getExtras().getBoolean("user_logged_in", false);
        }
        publishBroadcastWithLoggedInResult(true, z);
    }

    private boolean invokePaytmAppToCompareUsers(Intent intent) {
        if (PaytmUtility.isPaytmAppInstalled(this)) {
            try {
                Intent intent2 = new Intent();
                intent2.putExtras(intent);
                intent2.setComponent(new ComponentName(TransactionManager.PAYTM_APP_PACKAGE, "net.one97.paytm.AJRUserPhoneMatchActivity"));
                PaytmUtility.debugLog("Launching Paytm App");
                startActivityForResult(intent2, 12);
                return true;
            } catch (Exception e2) {
                PaytmUtility.printStackTrace(e2);
            }
        }
        return false;
    }

    private void invokePaytmAppToCheckIfAppIsLoggedIn() {
        if (PaytmUtility.isPaytmAppInstalled(this)) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(TransactionManager.PAYTM_APP_PACKAGE, "net.one97.paytm.AJRUserLoggedInCheckActivity"));
                PaytmUtility.debugLog("Launching Paytm App");
                startActivityForResult(intent, 13);
                return;
            } catch (ActivityNotFoundException e2) {
                PaytmUtility.printStackTrace(e2);
                publishBroadcastWithLoggedInResult(false, false);
                return;
            } catch (Exception e3) {
                PaytmUtility.printStackTrace(e3);
                publishBroadcastWithLoggedInResult(false, false);
                return;
            }
        }
        publishBroadcastWithLoggedInResult(false, false);
    }

    private void publishBroadcast(boolean z) {
        Intent intent = new Intent();
        intent.setAction(Constants.USER_MATCH_RESULT_ACTION);
        intent.putExtra(Constants.USER_MATCHES, z);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        finish();
    }

    private void publishBroadcastWithLoggedInResult(boolean z, boolean z2) {
        Intent intent = new Intent();
        intent.setAction(Constants.USER_LOGIN_STATUS_RESULT_ACTION);
        intent.putExtra("user_logged_in", z2);
        intent.putExtra(Constants.FEATURE_AVAILABLE_IN_APP, z);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        finish();
    }
}
