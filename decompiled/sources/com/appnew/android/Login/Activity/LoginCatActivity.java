package com.appnew.android.Login.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Login.Fragment.ChooseLanguageIBT;
import com.appnew.android.Login.Fragment.SignupForm;
import com.appnew.android.Login.Fragment.changepassword;
import com.appnew.android.Login.Fragment.forgetpassword;
import com.appnew.android.Login.Fragment.otpverification;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Progress;
import com.appnew.android.home.Activity.BaseABNoNavActivity;
import com.facebook.appevents.AppEventsLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginCatActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020D2\u0006\u0010]\u001a\u00020D2\b\u0010^\u001a\u0004\u0018\u00010_H\u0014J\b\u0010`\u001a\u00020[H\u0014J\b\u0010a\u001a\u00020\u0014H\u0014J\b\u0010b\u001a\u00020cH\u0014J\b\u0010d\u001a\u00020[H\u0014J\b\u0010e\u001a\u00020[H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR\u001c\u0010*\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u0010\tR\u001c\u00105\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u0010\tR\u001c\u00108\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010\tR\u001a\u0010;\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0012\u0010C\u001a\u00020D8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0007\"\u0004\bP\u0010\tR\u001a\u0010Q\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0007\"\u0004\bS\u0010\tR\u001a\u0010T\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0007\"\u0004\bV\u0010\tR\u0014\u0010W\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Y\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/appnew/android/Login/Activity/LoginCatActivity;", "Lcom/appnew/android/home/Activity/BaseABNoNavActivity;", "<init>", "()V", Const.OTP, "", "getOtp", "()Ljava/lang/String;", "setOtp", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "Frag_type", "getFrag_type", "setFrag_type", "subcat", "getSubcat", "setSubcat", "resetpass", "", "getResetpass", "()Z", "setResetpass", "(Z)V", "isChangePass", "setChangePass", "isphone", "getIsphone", "setIsphone", "type", "getType", "setType", "mprogress", "Lcom/appnew/android/Utils/Progress;", "getMprogress", "()Lcom/appnew/android/Utils/Progress;", "setMprogress", "(Lcom/appnew/android/Utils/Progress;)V", "socialType", "getSocialType", "setSocialType", "isSocial", "setSocial", "c_flagArr", "", "getC_flagArr", "()[B", "setC_flagArr", "([B)V", "c_code", "getC_code", "setC_code", Const.C_NAME, "getC_name", "setC_name", "c_nameCode", "getC_nameCode", "setC_nameCode", "isUpdate", "setUpdate", "logger", "Lcom/facebook/appevents/AppEventsLogger;", "getLogger", "()Lcom/facebook/appevents/AppEventsLogger;", "setLogger", "(Lcom/facebook/appevents/AppEventsLogger;)V", Const.NOTIFICATION_CODE, "", "message", "url", Const.MESSAGE_TARGET, "shareType", "post_id", Const.BANNER_ID, "course_id", "fieldid", "topicid", "testid", "getTestid", "setTestid", "testname", "getTestname", "setTestname", "testquestion", "getTestquestion", "setTestquestion", "tiletype", "tileid", "revertapi", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "initViews", "addBackButton", "getFragment", "Landroidx/fragment/app/Fragment;", "onResume", "onBackPressed", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginCatActivity extends BaseABNoNavActivity {
    public static final int $stable = 8;
    private String c_code;
    private String c_name;
    private String c_nameCode;
    private boolean isChangePass;
    private String isSocial;
    private boolean isUpdate;
    private boolean isphone;
    private AppEventsLogger logger;
    private Progress mprogress;
    public int notification_code;
    private String otp;
    private boolean resetpass;
    private String socialType;
    private String title;
    private String Frag_type = "";
    private String subcat = "";
    private String type = "0";
    private byte[] c_flagArr = new byte[0];
    public String message = "";
    public String url = "";
    public String message_target = "";
    public String shareType = "";
    public String post_id = "";
    public String banner_id = "";
    public String course_id = "";
    public String fieldid = "";
    public String topicid = "";
    private String testid = "";
    private String testname = "";
    private String testquestion = "";
    public String tiletype = "";
    public String tileid = "";
    public String revertapi = "";

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected boolean addBackButton() {
        return true;
    }

    public final String getOtp() {
        return this.otp;
    }

    public final void setOtp(String str) {
        this.otp = str;
    }

    @Override // android.app.Activity
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getFrag_type() {
        return this.Frag_type;
    }

    public final void setFrag_type(String str) {
        this.Frag_type = str;
    }

    public final String getSubcat() {
        return this.subcat;
    }

    public final void setSubcat(String str) {
        this.subcat = str;
    }

    public final boolean getResetpass() {
        return this.resetpass;
    }

    public final void setResetpass(boolean z) {
        this.resetpass = z;
    }

    /* JADX INFO: renamed from: isChangePass, reason: from getter */
    public final boolean getIsChangePass() {
        return this.isChangePass;
    }

    public final void setChangePass(boolean z) {
        this.isChangePass = z;
    }

    public final boolean getIsphone() {
        return this.isphone;
    }

    public final void setIsphone(boolean z) {
        this.isphone = z;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final Progress getMprogress() {
        return this.mprogress;
    }

    public final void setMprogress(Progress progress) {
        this.mprogress = progress;
    }

    public final String getSocialType() {
        return this.socialType;
    }

    public final void setSocialType(String str) {
        this.socialType = str;
    }

    /* JADX INFO: renamed from: isSocial, reason: from getter */
    public final String getIsSocial() {
        return this.isSocial;
    }

    public final void setSocial(String str) {
        this.isSocial = str;
    }

    public final byte[] getC_flagArr() {
        return this.c_flagArr;
    }

    public final void setC_flagArr(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.c_flagArr = bArr;
    }

    public final String getC_code() {
        return this.c_code;
    }

    public final void setC_code(String str) {
        this.c_code = str;
    }

    public final String getC_name() {
        return this.c_name;
    }

    public final void setC_name(String str) {
        this.c_name = str;
    }

    public final String getC_nameCode() {
        return this.c_nameCode;
    }

    public final void setC_nameCode(String str) {
        this.c_nameCode = str;
    }

    /* JADX INFO: renamed from: isUpdate, reason: from getter */
    public final boolean getIsUpdate() {
        return this.isUpdate;
    }

    public final void setUpdate(boolean z) {
        this.isUpdate = z;
    }

    public final AppEventsLogger getLogger() {
        return this.logger;
    }

    public final void setLogger(AppEventsLogger appEventsLogger) {
        this.logger = appEventsLogger;
    }

    public final String getTestid() {
        return this.testid;
    }

    public final void setTestid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testid = str;
    }

    public final String getTestname() {
        return this.testname;
    }

    public final void setTestname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testname = str;
    }

    public final String getTestquestion() {
        return this.testquestion;
    }

    public final void setTestquestion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testquestion = str;
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected void initViews() {
        LoginCatActivity loginCatActivity = this;
        FacebookEventLogger.logFbSdkInitialize(loginCatActivity);
        Progress progress = new Progress(loginCatActivity);
        this.mprogress = progress;
        Intrinsics.checkNotNull(progress);
        progress.setCancelable(false);
        if (getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            this.Frag_type = extras.getString(Const.FRAG_TYPE);
            Bundle extras2 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras2);
            this.subcat = extras2.getString(Const.SUB_CAT);
            Bundle extras3 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras3);
            this.otp = extras3.getString(Const.OTP);
            Bundle extras4 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras4);
            this.type = extras4.getString("type");
            Bundle extras5 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras5);
            this.title = extras5.getString("title");
            Bundle extras6 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras6);
            this.resetpass = extras6.getBoolean(Const.RESET_PASS);
            Bundle extras7 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras7);
            this.isChangePass = extras7.getBoolean(Const.IS_CHANGE_PASS);
            Bundle extras8 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras8);
            this.isphone = extras8.getBoolean("isphone");
            Bundle extras9 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras9);
            this.socialType = extras9.getString(Const.SOCIAL_TYPE);
            Bundle extras10 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras10);
            this.isSocial = extras10.getString(Const.IS_SOCIAL);
            Bundle extras11 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras11);
            this.c_code = extras11.getString("c_code");
            Bundle extras12 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras12);
            this.c_name = extras12.getString(Const.C_NAME);
            Bundle extras13 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras13);
            this.c_nameCode = extras13.getString(Const.C_NAME_CODE);
            if (getIntent().hasExtra("isUpdate")) {
                this.isUpdate = true;
            }
            Bundle extras14 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras14);
            if (extras14.getByteArray(Const.C_FLAG) != null) {
                Bundle extras15 = getIntent().getExtras();
                Intrinsics.checkNotNull(extras15);
                byte[] byteArray = extras15.getByteArray(Const.C_FLAG);
                Intrinsics.checkNotNull(byteArray, "null cannot be cast to non-null type kotlin.ByteArray");
                this.c_flagArr = byteArray;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity
    protected Fragment getFragment() {
        String str = this.Frag_type;
        if (str != null) {
            int i = 0;
            switch (str.hashCode()) {
                case -1963788536:
                    if (str.equals(Const.CHANGELANGUAGE)) {
                        this.toolbar.setVisibility(8);
                        String str2 = this.type;
                        Intrinsics.checkNotNull(str2);
                        ChooseLanguageIBT chooseLanguageIBTNewInstance = ChooseLanguageIBT.newInstance(Integer.parseInt(str2));
                        Intrinsics.checkNotNullExpressionValue(chooseLanguageIBTNewInstance, "newInstance(...)");
                        return chooseLanguageIBTNewInstance;
                    }
                    break;
                case -1764532344:
                    if (str.equals(Const.FORGETPASSWORD)) {
                        return forgetpassword.INSTANCE.newInstance(this.resetpass, this.isChangePass);
                    }
                    break;
                case -1350309703:
                    if (str.equals(Const.REGISTRATION)) {
                        if (this.isUpdate) {
                            SignupForm signupFormNewInstance = SignupForm.newInstance(this.otp, this.socialType, this.isSocial, this.c_code, this.c_name, this.c_nameCode, this.c_flagArr, true);
                            Intrinsics.checkNotNullExpressionValue(signupFormNewInstance, "newInstance(...)");
                            return signupFormNewInstance;
                        }
                        SignupForm signupFormNewInstance2 = SignupForm.newInstance(this.otp, this.socialType, this.isSocial, this.c_code, this.c_name, this.c_nameCode, this.c_flagArr);
                        Intrinsics.checkNotNullExpressionValue(signupFormNewInstance2, "newInstance(...)");
                        return signupFormNewInstance2;
                    }
                    break;
                case 866786891:
                    if (str.equals(Const.CHANGEPASSWORD)) {
                        return changepassword.INSTANCE.newInstance(this.otp, this.resetpass, this.isChangePass, this.isphone);
                    }
                    break;
                case 1212419324:
                    if (str.equals(Const.LoginWithOtp)) {
                        otpverification.Companion companion = otpverification.INSTANCE;
                        String str3 = this.otp;
                        if (!TextUtils.isEmpty(this.type) && TextUtils.isDigitsOnly(this.type)) {
                            String str4 = this.type;
                            Intrinsics.checkNotNull(str4);
                            i = Integer.parseInt(str4);
                        }
                        return companion.newInstance(str3, i, Const.LoginWithOtp, this.isphone, this.socialType, this.isSocial, this.c_code, this.c_name, this.c_nameCode, this.c_flagArr);
                    }
                    break;
                case 1333468358:
                    if (str.equals(Const.OTPVERIFICATION)) {
                        otpverification.Companion companion2 = otpverification.INSTANCE;
                        String str5 = this.otp;
                        if (!TextUtils.isEmpty(this.type) && TextUtils.isDigitsOnly(this.type)) {
                            String str6 = this.type;
                            Intrinsics.checkNotNull(str6);
                            i = Integer.parseInt(str6);
                        }
                        return companion2.newInstance(str5, i, this.resetpass, this.isChangePass, this.isphone, this.socialType, this.isSocial, this.c_code, this.c_name, this.c_nameCode, this.c_flagArr);
                    }
                    break;
            }
        }
        return forgetpassword.INSTANCE.newInstance(this.resetpass, this.isChangePass);
    }

    @Override // com.appnew.android.home.Activity.BaseABNoNavActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        FacebookEventLogger.logScreenViewed(this, getClass().getSimpleName());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
