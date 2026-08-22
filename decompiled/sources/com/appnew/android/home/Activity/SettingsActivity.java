package com.appnew.android.home.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Webview.WebViewActivty;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button clearCacheButton;
    private ImageView iv_back;
    private FirebaseAnalytics mFirebaseAnalytics;
    private TextView mLogout;
    private TextView mOpenSourceLicenses;
    private TextView mPrivacyPolicy;
    private Toolbar mSettingsToolbar;
    private TextView mTeamPage;
    private TextView mTermsConditionsText;
    private TextView mWriteRview;
    private SwitchCompat makeBetterSwitch;
    private ImageButton screenMirroring;
    private TextView versionTV;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.settings_activity);
        init();
    }

    private void init() {
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        this.mPrivacyPolicy = (TextView) findViewById(R.id.privacypolicytext);
        this.mOpenSourceLicenses = (TextView) findViewById(R.id.opensourcelicensetext);
        this.mTermsConditionsText = (TextView) findViewById(R.id.termsofservicetext);
        this.mSettingsToolbar = (Toolbar) findViewById(R.id.settingsactionbar);
        this.mWriteRview = (TextView) findViewById(R.id.enterreviewtext);
        Button button = (Button) findViewById(R.id.clearcachebtn);
        this.clearCacheButton = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.SettingsActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        this.mLogout = (TextView) findViewById(R.id.logouttext);
        this.versionTV = (TextView) findViewById(R.id.versionTV);
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        this.iv_back = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.SettingsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SettingsActivity.this.onBackPressed();
            }
        });
        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.makebettertoggle);
        this.makeBetterSwitch = switchCompat;
        switchCompat.setChecked(true);
        this.screenMirroring = (ImageButton) findViewById(R.id.screencast);
        this.versionTV.setText(Html.fromHtml(getResources().getString(R.string.app_version) + Helper.getVersionName(this)));
        this.screenMirroring.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.SettingsActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$1(view);
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Settings_screen");
        bundle.putString("content_type", "screen");
        this.mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        if (getSupportActionBar() == null) {
            setSupportActionBar(this.mSettingsToolbar);
        }
        this.mPrivacyPolicy.setOnClickListener(this);
        this.mOpenSourceLicenses.setOnClickListener(this);
        this.mTermsConditionsText.setOnClickListener(this);
        this.mWriteRview.setOnClickListener(this);
        this.mLogout.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        deleteCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(View view) {
        Helper.startCast(this);
    }

    private void deleteCache() {
        try {
            Toast.makeText(this, getResources().getString(R.string.removing_application_cache), 0).show();
            deleteDir(getCacheDir());
        } catch (Exception unused) {
        }
    }

    private boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            for (String str : dir.list()) {
                if (!deleteDir(new File(dir, str))) {
                    return false;
                }
            }
            return dir.delete();
        }
        if (dir == null || !dir.isFile()) {
            return false;
        }
        return dir.delete();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.enterreviewtext /* 2131363160 */:
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())));
                } catch (ActivityNotFoundException unused) {
                    return;
                }
                break;
            case R.id.logouttext /* 2131364136 */:
                getLogoutDialog(this, getResources().getString(R.string.logout_title), getResources().getString(R.string.logout_confirmation_message));
                break;
            case R.id.opensourcelicensetext /* 2131364499 */:
                Helper.gotoActivity(new Intent(this, (Class<?>) LibrariesUsedActivity.class), this);
                break;
            case R.id.privacypolicytext /* 2131364787 */:
                Intent intent = new Intent(this, (Class<?>) WebViewActivty.class);
                intent.putExtra("type", Const.PRIVACY);
                intent.putExtra("url", API.PRIVACY_POLICY_URL);
                Helper.gotoActivity(intent, this);
                break;
            case R.id.termsofservicetext /* 2131365662 */:
                Intent intent2 = new Intent(this, (Class<?>) WebViewActivty.class);
                intent2.putExtra("type", "Terms of Service");
                intent2.putExtra("url", API.TERMS_AND_CONDITIONS);
                Helper.gotoActivity(intent2, this);
                break;
        }
    }

    public void getLogoutDialog(final Activity ctx, final String title, final String message) {
        DialogUtils.makeDialog(this, title, message, getResources().getString(R.string.yes), getResources().getString(R.string.no), true, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.home.Activity.SettingsActivity.2
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
            public void onOKClick() {
                if (Helper.isNetworkConnected(SettingsActivity.this)) {
                    Helper.SignOutUser(SettingsActivity.this);
                } else {
                    SettingsActivity settingsActivity = SettingsActivity.this;
                    Toast.makeText(settingsActivity, settingsActivity.getResources().getString(R.string.no_internet_connection), 0).show();
                }
            }
        }, new DialogUtils.onDialogUtilsCancelClick() { // from class: com.appnew.android.home.Activity.SettingsActivity.3
            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsCancelClick
            public void onCancelClick() {
            }
        });
    }

    private void showLogoutDialog() {
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.appnew.android.home.Activity.SettingsActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsActivity.lambda$showLogoutDialog$2(dialogInterface, i);
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(String.format(getResources().getString(R.string.logout_s), getResources().getString(R.string.app_name)));
        builder.setMessage(getResources().getString(R.string.are_you_sure_you_want_to_logout_from_the_application)).setPositiveButton(getResources().getString(R.string.yes), onClickListener).setNegativeButton(getResources().getString(R.string.no), onClickListener).show();
    }

    static /* synthetic */ void lambda$showLogoutDialog$2(DialogInterface dialogInterface, int i) {
        if (i != -2) {
            return;
        }
        dialogInterface.dismiss();
    }

    private void openWebBrowser(String url) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }
}
