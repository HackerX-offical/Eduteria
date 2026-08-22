package com.appnew.android.Login.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.eduteria.app.app.R;
import com.tv9news.utils.helpers.AnalyticsConstants;

/* JADX INFO: loaded from: classes6.dex */
public class PermissionSettingActivity extends AppCompatActivity implements View.OnClickListener {
    Activity context;
    private TextView settingsBtn;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        this.context = this;
        setContentView(R.layout.permission_setting_layout);
        init();
    }

    private void init() {
        TextView textView = (TextView) findViewById(R.id.settingsbtn);
        this.settingsBtn = textView;
        textView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.settingsbtn) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(AnalyticsConstants.PACKAGE, getPackageName(), null));
        startActivity(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (checkStoragePerm()) {
            Intent intent = new Intent(this, Helper.setSignInActivity());
            intent.setFlags(268468224);
            intent.putExtra("type", Const.SIGNIN);
            intent.putExtra(Const.OPEN_WITH, "user");
            startActivity(intent);
            finish();
        }
    }

    private boolean checkStoragePerm() {
        return ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
