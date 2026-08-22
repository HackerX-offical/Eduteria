package com.appnew.android.testmodule.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class TestSubmissionActivity extends AppCompatActivity {
    Button backBtn;
    ImageView backimag;
    TextView result;
    String result_date;
    TextView test_name;
    TextView test_submit;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.test_submittion_activity);
        Constants.REFRESHPAGENEW = "false";
        SharedPreference.getInstance().putBoolean(Const.TEST_RESUME_STATE, true);
        SharedPreference.getInstance().putBoolean(Const.IS_SUBMIT_TEST_S3, true);
        this.result = (TextView) findViewById(R.id.result);
        this.backimag = (ImageView) findViewById(R.id.backimag);
        this.backBtn = (Button) findViewById(R.id.backBtn);
        this.test_name = (TextView) findViewById(R.id.test_name);
        this.result_date = ((Bundle) Objects.requireNonNull(getIntent().getExtras())).getString("result_date");
        this.test_name.setText(getIntent().getExtras().getString(AnalyticsConstants.test_name));
        this.backimag.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestSubmissionActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodule.activity.TestSubmissionActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        String str = this.result_date;
        if (str != null && !str.equalsIgnoreCase("") && !this.result_date.equalsIgnoreCase("0") && !this.result_date.equalsIgnoreCase("1")) {
            this.result.setText(getResources().getString(R.string.your_result_will_be_declared_on) + new SimpleDateFormat("dd MMM yyyy hh:mm a").format(new Date(Long.parseLong(this.result_date) * 1000)));
        } else {
            this.result.setText("Your result is getting ready, please wait.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        finish();
    }
}
