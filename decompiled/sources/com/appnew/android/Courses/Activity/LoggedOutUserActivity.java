package com.appnew.android.Courses.Activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.databinding.DataBindingUtil;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityLoggedOutUserBinding;
import com.appnew.android.pojo.Userinfo.Data;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import com.eduteria.app.app.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LoggedOutUserActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020$H\u0014J\b\u0010(\u001a\u00020$H\u0014J\b\u0010)\u001a\u00020$H\u0014J\b\u0010*\u001a\u00020$H\u0014J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020$H\u0002J\b\u0010.\u001a\u00020$H\u0002J\b\u0010/\u001a\u00020$H\u0002J\b\u00100\u001a\u00020$H\u0016J\b\u00101\u001a\u00020$H\u0002J\u0010\u00102\u001a\u00020$2\u0006\u00103\u001a\u000204H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/appnew/android/Courses/Activity/LoggedOutUserActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityLoggedOutUserBinding;", "url", "", Const.NOTIFICATION_CODE, "", "course_id", "fieldid", "id", CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, "", "coupon_for", "topicid", Const.VIDEO_TYPE, "tiletype", "tileid", "revertapi", "type", "imageUrl", Const.MESSAGE_TARGET, "message", Const.shareparentid, Const.FOLDER_ID, Const.FOLDER_CONTENT_TYPE, "solutions", "test_series_name", "test_series_date", "post_id", Const.status_free, "test_id", Constants.PT_NOTIF_ID, "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "onRestart", "onPause", "onResume", "logoutUser", "", "getBundledData", "redirectionToUrl", "redirectionToDashboardActivityTheme", "onBackPressed", "redirectionAccordingToUser", "onNewIntent", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoggedOutUserActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private ActivityLoggedOutUserBinding binding;
    private int notification_code;
    private long ts;
    private String url = "";
    private String course_id = "";
    private String fieldid = "";
    private String id = "";
    private String coupon_for = "";
    private String topicid = "";
    private String video_type = "";
    private String tiletype = "";
    private String tileid = "";
    private String revertapi = "";
    private String type = "";
    private String imageUrl = "";
    private String message_target = "";
    private String message = "";
    private String parentid = "";
    private String folder_id = "";
    private String folderContentType = "";
    private String solutions = "";
    private String test_series_name = "";
    private String test_series_date = "";
    private String post_id = "";
    private String status_free = "";
    private String test_id = "";
    private String notificationId = "";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = (ActivityLoggedOutUserBinding) DataBindingUtil.setContentView(this, R.layout.activity_logged_out_user);
        Log.e("TAG_AP", "onCreate: " + this.notificationId);
        getBundledData();
        redirectionAccordingToUser();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        Log.e("TAG_AP", "onStop: " + this.notificationId);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG_AP", "onRestart: " + this.notificationId);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Log.e("TAG_AP", "onPause: " + this.notificationId);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Log.e("TAG_AP", "onResume: " + this.notificationId);
    }

    private final boolean logoutUser() {
        String str = MakeMyExam.userId;
        if (str == null || str.length() == 0) {
            return true;
        }
        Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
        String id = loggedInUser != null ? loggedInUser.getId() : null;
        return id == null || id.length() == 0;
    }

    private final void getBundledData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.notification_code = intent.getIntExtra(Const.NOTIFICATION_CODE, 0);
            String stringExtra = intent.getStringExtra(Const.NOTIFICATION_ID);
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.notificationId = stringExtra;
            String stringExtra2 = intent.getStringExtra("course_id");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.course_id = stringExtra2;
            String stringExtra3 = intent.getStringExtra("file_id");
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            this.fieldid = stringExtra3;
            String stringExtra4 = intent.getStringExtra("test_id");
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            this.test_id = stringExtra4;
            String stringExtra5 = intent.getStringExtra("coupon_for");
            if (stringExtra5 == null) {
                stringExtra5 = "";
            }
            this.coupon_for = stringExtra5;
            this.ts = intent.getLongExtra(CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, 0L);
            String stringExtra6 = intent.getStringExtra(Const.TOPIC_ID);
            if (stringExtra6 == null) {
                stringExtra6 = "";
            }
            this.topicid = stringExtra6;
            String stringExtra7 = intent.getStringExtra("type");
            if (stringExtra7 == null) {
                stringExtra7 = "";
            }
            this.video_type = stringExtra7;
            String stringExtra8 = intent.getStringExtra(Const.TILE_TYPE);
            if (stringExtra8 == null) {
                stringExtra8 = "";
            }
            this.tiletype = stringExtra8;
            String stringExtra9 = intent.getStringExtra("tile_id");
            if (stringExtra9 == null) {
                stringExtra9 = "";
            }
            this.tileid = stringExtra9;
            String stringExtra10 = intent.getStringExtra(Const.REVERT_API);
            if (stringExtra10 == null) {
                stringExtra10 = "";
            }
            this.revertapi = stringExtra10;
            String stringExtra11 = intent.getStringExtra("type");
            if (stringExtra11 == null) {
                stringExtra11 = "";
            }
            this.type = stringExtra11;
            String stringExtra12 = intent.getStringExtra("title");
            if (stringExtra12 == null) {
                stringExtra12 = "";
            }
            setTitle(stringExtra12);
            String stringExtra13 = intent.getStringExtra(TypedValues.AttributesType.S_TARGET);
            if (stringExtra13 == null) {
                stringExtra13 = "";
            }
            this.message_target = stringExtra13;
            String stringExtra14 = intent.getStringExtra("url");
            if (stringExtra14 == null) {
                stringExtra14 = "";
            }
            this.url = stringExtra14;
            String stringExtra15 = intent.getStringExtra("imageUrl");
            if (stringExtra15 == null) {
                stringExtra15 = "";
            }
            this.imageUrl = stringExtra15;
            String stringExtra16 = intent.getStringExtra("description");
            if (stringExtra16 == null) {
                stringExtra16 = "";
            }
            this.message = stringExtra16;
            String stringExtra17 = intent.getStringExtra(Const.shareparentid);
            if (stringExtra17 == null) {
                stringExtra17 = "";
            }
            this.parentid = stringExtra17;
            String stringExtra18 = intent.getStringExtra(Const.FOLDER_ID);
            if (stringExtra18 == null) {
                stringExtra18 = "";
            }
            this.folder_id = stringExtra18;
            String stringExtra19 = intent.getStringExtra(Const.FOLDER_CONTENT_TYPE);
            if (stringExtra19 == null) {
                stringExtra19 = "";
            }
            this.folderContentType = stringExtra19;
            String stringExtra20 = intent.getStringExtra("test_series_name");
            if (stringExtra20 == null) {
                stringExtra20 = "";
            }
            this.test_series_name = stringExtra20;
            String stringExtra21 = intent.getStringExtra("solutions");
            if (stringExtra21 == null) {
                stringExtra21 = "";
            }
            this.solutions = stringExtra21;
            String stringExtra22 = intent.getStringExtra("result_date");
            if (stringExtra22 == null) {
                stringExtra22 = "";
            }
            this.test_series_date = stringExtra22;
            String stringExtra23 = intent.getStringExtra("id");
            if (stringExtra23 == null) {
                stringExtra23 = "";
            }
            this.id = stringExtra23;
            String stringExtra24 = intent.getStringExtra("post_id");
            if (stringExtra24 == null) {
                stringExtra24 = "";
            }
            this.post_id = stringExtra24;
            String stringExtra25 = intent.getStringExtra(Const.status_free);
            this.status_free = stringExtra25 != null ? stringExtra25 : "";
            Log.e("TAG_AP", "getBundledData:  " + this.notificationId + " url ;- " + this.url);
        }
    }

    private final void redirectionToUrl() {
        int i = this.notification_code;
        if ((i == 90001 || i == 10009) && StringsKt.equals(this.message_target, "6", true)) {
            try {
                if (!TextUtils.isEmpty(this.url)) {
                    SharedPreference sharedPreference = SharedPreference.getInstance();
                    String str = this.notificationId;
                    sharedPreference.putString(str, str);
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.url)));
                    finishAffinity();
                } else {
                    Toast.makeText(this, "Link not found.", 0).show();
                }
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(this, "No application found to open this link.", 0).show();
            }
        }
    }

    private final void redirectionToDashboardActivityTheme() {
        Intent intent = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
        intent.putExtra("title", getTitle());
        intent.putExtra(Const.NOTIFICATION_CODE, this.notification_code);
        intent.putExtra(Const.NOTIFICATION_ID, this.notificationId);
        intent.putExtra("url", this.url);
        intent.putExtra("imageUrl", this.imageUrl);
        intent.putExtra(TypedValues.AttributesType.S_TARGET, this.message_target);
        intent.setData(Uri.parse("custom://" + this.notificationId));
        intent.setFlags(335544320);
        startActivity(intent);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Log.e("TAG_AP", "onBackPressed: " + this.notificationId);
        if (logoutUser()) {
            finishAffinity();
        } else {
            finish();
        }
        super.onBackPressed();
    }

    private final void redirectionAccordingToUser() {
        if (logoutUser() && !Intrinsics.areEqual(this.notificationId, SharedPreference.getInstance().getString(this.notificationId))) {
            redirectionToUrl();
        } else {
            redirectionToDashboardActivityTheme();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        SharedPreference.getInstance().putString(this.notificationId, "");
        this.notification_code = intent.getIntExtra(Const.NOTIFICATION_CODE, 0);
        String stringExtra = intent.getStringExtra(Const.NOTIFICATION_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.notificationId = stringExtra;
        String stringExtra2 = intent.getStringExtra("course_id");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.course_id = stringExtra2;
        String stringExtra3 = intent.getStringExtra("file_id");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.fieldid = stringExtra3;
        String stringExtra4 = intent.getStringExtra("test_id");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        this.test_id = stringExtra4;
        String stringExtra5 = intent.getStringExtra("coupon_for");
        if (stringExtra5 == null) {
            stringExtra5 = "";
        }
        this.coupon_for = stringExtra5;
        this.ts = intent.getLongExtra(CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, 0L);
        String stringExtra6 = intent.getStringExtra(Const.TOPIC_ID);
        if (stringExtra6 == null) {
            stringExtra6 = "";
        }
        this.topicid = stringExtra6;
        String stringExtra7 = intent.getStringExtra("type");
        if (stringExtra7 == null) {
            stringExtra7 = "";
        }
        this.video_type = stringExtra7;
        String stringExtra8 = intent.getStringExtra(Const.TILE_TYPE);
        if (stringExtra8 == null) {
            stringExtra8 = "";
        }
        this.tiletype = stringExtra8;
        String stringExtra9 = intent.getStringExtra("tile_id");
        if (stringExtra9 == null) {
            stringExtra9 = "";
        }
        this.tileid = stringExtra9;
        String stringExtra10 = intent.getStringExtra(Const.REVERT_API);
        if (stringExtra10 == null) {
            stringExtra10 = "";
        }
        this.revertapi = stringExtra10;
        String stringExtra11 = intent.getStringExtra("type");
        if (stringExtra11 == null) {
            stringExtra11 = "";
        }
        this.type = stringExtra11;
        String stringExtra12 = intent.getStringExtra("title");
        if (stringExtra12 == null) {
            stringExtra12 = "";
        }
        setTitle(stringExtra12);
        String stringExtra13 = intent.getStringExtra(TypedValues.AttributesType.S_TARGET);
        if (stringExtra13 == null) {
            stringExtra13 = "";
        }
        this.message_target = stringExtra13;
        String stringExtra14 = intent.getStringExtra("url");
        if (stringExtra14 == null) {
            stringExtra14 = "";
        }
        this.url = stringExtra14;
        String stringExtra15 = intent.getStringExtra("imageUrl");
        if (stringExtra15 == null) {
            stringExtra15 = "";
        }
        this.imageUrl = stringExtra15;
        String stringExtra16 = intent.getStringExtra("description");
        if (stringExtra16 == null) {
            stringExtra16 = "";
        }
        this.message = stringExtra16;
        String stringExtra17 = intent.getStringExtra(Const.shareparentid);
        if (stringExtra17 == null) {
            stringExtra17 = "";
        }
        this.parentid = stringExtra17;
        String stringExtra18 = intent.getStringExtra(Const.FOLDER_ID);
        if (stringExtra18 == null) {
            stringExtra18 = "";
        }
        this.folder_id = stringExtra18;
        String stringExtra19 = intent.getStringExtra(Const.FOLDER_CONTENT_TYPE);
        if (stringExtra19 == null) {
            stringExtra19 = "";
        }
        this.folderContentType = stringExtra19;
        String stringExtra20 = intent.getStringExtra("test_series_name");
        if (stringExtra20 == null) {
            stringExtra20 = "";
        }
        this.test_series_name = stringExtra20;
        String stringExtra21 = intent.getStringExtra("solutions");
        if (stringExtra21 == null) {
            stringExtra21 = "";
        }
        this.solutions = stringExtra21;
        String stringExtra22 = intent.getStringExtra("result_date");
        if (stringExtra22 == null) {
            stringExtra22 = "";
        }
        this.test_series_date = stringExtra22;
        String stringExtra23 = intent.getStringExtra("id");
        if (stringExtra23 == null) {
            stringExtra23 = "";
        }
        this.id = stringExtra23;
        String stringExtra24 = intent.getStringExtra("post_id");
        if (stringExtra24 == null) {
            stringExtra24 = "";
        }
        this.post_id = stringExtra24;
        String stringExtra25 = intent.getStringExtra(Const.status_free);
        this.status_free = stringExtra25 != null ? stringExtra25 : "";
        redirectionToUrl();
        Log.e("TAG_AP", "onNewIntent: onNewIntent " + this.notificationId);
    }
}
