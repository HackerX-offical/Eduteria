package com.appnew.android.loginRevamp.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme3;
import com.appnew.android.Theme.DashboardActivityTheme4;
import com.appnew.android.Theme.DashboardActivityTheme5;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.DialogUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.databinding.FragmentChangepasswordNewBinding;
import com.appnew.android.home.Constants;
import com.appnew.android.loginRevamp.Activity.SignInNewActivity;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: changepasswordnew.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u001a\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010-\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J,\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110/2\b\u00100\u001a\u0004\u0018\u00010\u00112\b\u00101\u001a\u0004\u0018\u00010\u00112\b\u00102\u001a\u0004\u0018\u000103H\u0016J.\u00104\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u0001062\b\u00100\u001a\u0004\u0018\u00010\u00112\b\u00101\u001a\u0004\u0018\u00010\u00112\u0006\u00107\u001a\u00020\u001dH\u0016J&\u00108\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010\u00112\b\u00100\u001a\u0004\u0018\u00010\u00112\b\u00101\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010:\u001a\u00020)R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/appnew/android/loginRevamp/Fragment/changepasswordnew;", "Lcom/appnew/android/Utils/Network/MainFragment;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/FragmentChangepasswordNewBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentChangepasswordNewBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentChangepasswordNewBinding;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "retrypassword", "", "getRetrypassword", "()Ljava/lang/String;", "setRetrypassword", "(Ljava/lang/String;)V", "newpassword", "getNewpassword", "setNewpassword", Const.OTP, "getOtp", "setOtp", "resetPass", "", "isChangePass", "isphone", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onStop", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "onCreate", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "CheckValidations", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class changepasswordnew extends MainFragment {
    private Activity activity;
    public FragmentChangepasswordNewBinding binding;
    private boolean isChangePass;
    private boolean isphone;
    public String newpassword;
    private String otp;
    private boolean resetPass;
    private String retrypassword;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public final FragmentChangepasswordNewBinding getBinding() {
        FragmentChangepasswordNewBinding fragmentChangepasswordNewBinding = this.binding;
        if (fragmentChangepasswordNewBinding != null) {
            return fragmentChangepasswordNewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentChangepasswordNewBinding fragmentChangepasswordNewBinding) {
        Intrinsics.checkNotNullParameter(fragmentChangepasswordNewBinding, "<set-?>");
        this.binding = fragmentChangepasswordNewBinding;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final void setActivity(Activity activity) {
        this.activity = activity;
    }

    public final String getRetrypassword() {
        return this.retrypassword;
    }

    public final void setRetrypassword(String str) {
        this.retrypassword = str;
    }

    public final String getNewpassword() {
        String str = this.newpassword;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("newpassword");
        return null;
    }

    public final void setNewpassword(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.newpassword = str;
    }

    public final String getOtp() {
        return this.otp;
    }

    public final void setOtp(String str) {
        this.otp = str;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(FragmentChangepasswordNewBinding.inflate(inflater, container, false));
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        Intrinsics.checkNotNull(appCompatActivity);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.hide();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        Intrinsics.checkNotNull(appCompatActivity);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().newpasswordET.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.loginRevamp.Fragment.changepasswordnew$$ExternalSyntheticLambda0
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return changepasswordnew.onViewCreated$lambda$1(charSequence, i, i2, spanned, i3, i4);
            }
        }});
        getBinding().retrypasswordET.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.loginRevamp.Fragment.changepasswordnew$$ExternalSyntheticLambda1
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return changepasswordnew.onViewCreated$lambda$3(charSequence, i, i2, spanned, i3, i4);
            }
        }});
        getBinding().submitBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.changepasswordnew$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.CheckValidations();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onViewCreated$lambda$1(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) throws IOException {
        String string = charSequence.toString();
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < string.length(); i5++) {
            char cCharAt = string.charAt(i5);
            if (!CharsKt.isWhitespace(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onViewCreated$lambda$3(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) throws IOException {
        String string = charSequence.toString();
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < string.length(); i5++) {
            char cCharAt = string.charAt(i5);
            if (!CharsKt.isWhitespace(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        this.activity = activity;
        Helper.setStatusBarIconsLight(activity, activity != null ? activity.getWindow() : null, false);
        if (getArguments() != null) {
            this.otp = requireArguments().getString(Const.OTP);
            this.resetPass = requireArguments().getBoolean(Const.RESET_PASS);
            this.isChangePass = requireArguments().getBoolean(Const.IS_CHANGE_PASS);
            this.isphone = requireArguments().getBoolean("isphone");
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (Intrinsics.areEqual(apitype, API.API_UPDATE_PASSWORD_WITH_OTP)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setOtp(this.otp);
            encryptionData.setMobile(Constants.MOBILE_NO);
            encryptionData.setPassword(String.valueOf(getBinding().retrypasswordET.getText()));
            String strEncrypt = AES.encrypt(new Gson().toJson(encryptionData));
            Intrinsics.checkNotNull(service);
            return service.getSingleCalVideoData(strEncrypt);
        }
        Intrinsics.checkNotNull(service);
        return service.getSingleCalVideoData("profiledoseStrScr");
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        Resources resources6;
        Resources resources7;
        Resources resources8;
        Resources resources9;
        Resources resources10;
        Resources resources11;
        Resources resources12;
        Resources resources13;
        Resources resources14;
        Resources resources15;
        if (Intrinsics.areEqual(apitype, API.API_UPDATE_PASSWORD_WITH_OTP)) {
            if (Intrinsics.areEqual(jsonObject != null ? jsonObject.optString("status") : null, "true")) {
                if (StringsKt.equals(BuildConfig.FLAVOR, "utkarsh", true)) {
                    if (!this.isChangePass) {
                        Activity activity = this.activity;
                        Activity activity2 = activity;
                        String string = (activity == null || (resources15 = activity.getResources()) == null) ? null : resources15.getString(R.string.congratulations);
                        Activity activity3 = this.activity;
                        String string2 = (activity3 == null || (resources14 = activity3.getResources()) == null) ? null : resources14.getString(R.string.you_have_successfully_changed_your_password);
                        Activity activity4 = this.activity;
                        String string3 = (activity4 == null || (resources13 = activity4.getResources()) == null) ? null : resources13.getString(R.string.go_back_login);
                        Activity activity5 = this.activity;
                        if (activity5 != null && (resources12 = activity5.getResources()) != null) {
                            string = resources12.getString(R.string.close);
                        }
                        DialogUtils.makeCompleteCPDialog(activity2, string, string2, string3, string, false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.loginRevamp.Fragment.changepasswordnew$$ExternalSyntheticLambda3
                            @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                            public final void onOKClick() {
                                changepasswordnew.SuccessCallBack$lambda$5(this.f$0);
                            }
                        });
                        return;
                    }
                    Activity activity6 = this.activity;
                    Activity activity7 = activity6;
                    String string4 = (activity6 == null || (resources11 = activity6.getResources()) == null) ? null : resources11.getString(R.string.congratulations);
                    Activity activity8 = this.activity;
                    String string5 = (activity8 == null || (resources10 = activity8.getResources()) == null) ? null : resources10.getString(R.string.you_have_successfully_changed_your_password);
                    Activity activity9 = this.activity;
                    String string6 = (activity9 == null || (resources9 = activity9.getResources()) == null) ? null : resources9.getString(R.string.go_back_to_home);
                    Activity activity10 = this.activity;
                    if (activity10 != null && (resources8 = activity10.getResources()) != null) {
                        string = resources8.getString(R.string.close);
                    }
                    DialogUtils.makeCompleteCPDialog(activity7, string4, string5, string6, string, false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.loginRevamp.Fragment.changepasswordnew$$ExternalSyntheticLambda4
                        @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                        public final void onOKClick() {
                            changepasswordnew.SuccessCallBack$lambda$6(this.f$0);
                        }
                    });
                    return;
                }
                if (!this.isChangePass) {
                    Activity activity11 = this.activity;
                    Activity activity12 = activity11;
                    String string7 = (activity11 == null || (resources7 = activity11.getResources()) == null) ? null : resources7.getString(R.string.congratulations);
                    Activity activity13 = this.activity;
                    String string8 = (activity13 == null || (resources6 = activity13.getResources()) == null) ? null : resources6.getString(R.string.you_have_successfully_changed_your_password);
                    Activity activity14 = this.activity;
                    if (activity14 != null && (resources5 = activity14.getResources()) != null) {
                        string = resources5.getString(R.string.close);
                    }
                    DialogUtils.makeRoundedCarDialog(activity12, string7, string8, "Log In", string, false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.loginRevamp.Fragment.changepasswordnew$$ExternalSyntheticLambda5
                        @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                        public final void onOKClick() {
                            changepasswordnew.SuccessCallBack$lambda$7(this.f$0);
                        }
                    });
                    return;
                }
                Activity activity15 = this.activity;
                Activity activity16 = activity15;
                String string9 = (activity15 == null || (resources4 = activity15.getResources()) == null) ? null : resources4.getString(R.string.congratulations);
                Activity activity17 = this.activity;
                String string10 = (activity17 == null || (resources3 = activity17.getResources()) == null) ? null : resources3.getString(R.string.you_have_successfully_changed_your_password);
                Activity activity18 = this.activity;
                String string11 = (activity18 == null || (resources2 = activity18.getResources()) == null) ? null : resources2.getString(R.string.go_back_to_home);
                Activity activity19 = this.activity;
                if (activity19 != null && (resources = activity19.getResources()) != null) {
                    string = resources.getString(R.string.close);
                }
                DialogUtils.makeRoundedCarDialog(activity16, string9, string10, string11, string, false, new DialogUtils.onDialogUtilsOkClick() { // from class: com.appnew.android.loginRevamp.Fragment.changepasswordnew$$ExternalSyntheticLambda6
                    @Override // com.appnew.android.Utils.DialogUtils.onDialogUtilsOkClick
                    public final void onOKClick() {
                        changepasswordnew.SuccessCallBack$lambda$8(this.f$0);
                    }
                });
                return;
            }
            RetrofitResponse.GetApiData(this.activity, jsonObject != null ? jsonObject.optString("auth_code") : null, jsonObject != null ? jsonObject.optString("message") : null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuccessCallBack$lambda$5(changepasswordnew changepasswordnewVar) {
        Intent intent = new Intent(changepasswordnewVar.activity, (Class<?>) SignInNewActivity.class);
        intent.setFlags(268468224);
        intent.putExtra("type", Const.SIGNIN);
        intent.putExtra(Const.OPEN_WITH, "user");
        changepasswordnewVar.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuccessCallBack$lambda$6(changepasswordnew changepasswordnewVar) {
        if (StringsKt.equals("1", "1", true)) {
            Intent intent = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme1.class);
            intent.setFlags(268468224);
            changepasswordnewVar.startActivity(intent);
            return;
        }
        if (StringsKt.equals("1", "2", true)) {
            Intent intent2 = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme2.class);
            intent2.setFlags(268468224);
            changepasswordnewVar.startActivity(intent2);
            return;
        }
        if (StringsKt.equals("1", "3", true)) {
            Intent intent3 = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme3.class);
            intent3.setFlags(268468224);
            changepasswordnewVar.startActivity(intent3);
            return;
        }
        if (StringsKt.equals("1", "4", true)) {
            Intent intent4 = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme4.class);
            intent4.setFlags(268468224);
            changepasswordnewVar.startActivity(intent4);
        } else if (StringsKt.equals("1", "5", true)) {
            Intent intent5 = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme5.class);
            intent5.setFlags(268468224);
            changepasswordnewVar.startActivity(intent5);
        } else if (StringsKt.equals("1", "6", true)) {
            Intent intent6 = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme7.class);
            intent6.setFlags(268468224);
            changepasswordnewVar.startActivity(intent6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuccessCallBack$lambda$7(changepasswordnew changepasswordnewVar) {
        Intent intent = new Intent(changepasswordnewVar.activity, (Class<?>) SignInNewActivity.class);
        intent.setFlags(268468224);
        intent.putExtra("type", Const.SIGNIN);
        intent.putExtra(Const.OPEN_WITH, "user");
        changepasswordnewVar.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SuccessCallBack$lambda$8(changepasswordnew changepasswordnewVar) {
        if (StringsKt.equals("1", "1", true)) {
            Intent intent = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme1.class);
            intent.setFlags(268468224);
            changepasswordnewVar.startActivity(intent);
            return;
        }
        if (StringsKt.equals("1", "2", true)) {
            Intent intent2 = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme2.class);
            intent2.setFlags(268468224);
            changepasswordnewVar.startActivity(intent2);
            return;
        }
        if (StringsKt.equals("1", "3", true)) {
            Intent intent3 = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme3.class);
            intent3.setFlags(268468224);
            changepasswordnewVar.startActivity(intent3);
            return;
        }
        if (StringsKt.equals("1", "4", true)) {
            Intent intent4 = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme4.class);
            intent4.setFlags(268468224);
            changepasswordnewVar.startActivity(intent4);
            return;
        }
        if (StringsKt.equals("1", "5", true)) {
            Intent intent5 = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme5.class);
            intent5.setFlags(268468224);
            changepasswordnewVar.startActivity(intent5);
        } else if (StringsKt.equals("1", "6", true)) {
            Intent intent6 = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme7.class);
            intent6.setFlags(268468224);
            changepasswordnewVar.startActivity(intent6);
        } else if (StringsKt.equals("1", "7", true)) {
            Intent intent7 = new Intent(changepasswordnewVar.activity, (Class<?>) DashboardActivityTheme8.class);
            intent7.setFlags(268468224);
            changepasswordnewVar.startActivity(intent7);
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        FragmentActivity activity;
        if (!Intrinsics.areEqual(apitype, API.API_UPDATE_PASSWORD_WITH_OTP) || jsonstring == null || (activity = getActivity()) == null) {
            return;
        }
        XtensionFunctionKt.showSmallLengthToast(activity, jsonstring);
    }

    public final void CheckValidations() {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        setNewpassword(Helper.GetText(getBinding().newpasswordET));
        this.retrypassword = Helper.GetText(getBinding().retrypasswordET);
        String string = null;
        if (TextUtils.isEmpty(getNewpassword())) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                FragmentActivity fragmentActivity = activity;
                Activity activity2 = this.activity;
                if (activity2 != null && (resources5 = activity2.getResources()) != null) {
                    string = resources5.getString(R.string.please_fill_change_password);
                }
                XtensionFunctionKt.showSmallLengthToast(fragmentActivity, String.valueOf(string));
            }
        } else {
            if (getNewpassword().length() < 8 || getNewpassword().length() > 13) {
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    FragmentActivity fragmentActivity2 = activity3;
                    Activity activity4 = this.activity;
                    if (activity4 != null && (resources = activity4.getResources()) != null) {
                        string = resources.getString(R.string.change_password_must_vary_from_8_to_13_characters);
                    }
                    XtensionFunctionKt.showSmallLengthToast(fragmentActivity2, String.valueOf(string));
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(this.retrypassword)) {
                FragmentActivity activity5 = getActivity();
                if (activity5 != null) {
                    FragmentActivity fragmentActivity3 = activity5;
                    Activity activity6 = this.activity;
                    if (activity6 != null && (resources4 = activity6.getResources()) != null) {
                        string = resources4.getString(R.string.please_fill_confirm_password);
                    }
                    XtensionFunctionKt.showSmallLengthToast(fragmentActivity3, String.valueOf(string));
                }
            } else {
                String str = this.retrypassword;
                Intrinsics.checkNotNull(str);
                if (str.length() >= 8) {
                    String str2 = this.retrypassword;
                    Intrinsics.checkNotNull(str2);
                    if (str2.length() <= 13) {
                        if (!Intrinsics.areEqual(getNewpassword(), this.retrypassword)) {
                            FragmentActivity activity7 = getActivity();
                            if (activity7 != null) {
                                FragmentActivity fragmentActivity4 = activity7;
                                Activity activity8 = this.activity;
                                if (activity8 != null && (resources3 = activity8.getResources()) != null) {
                                    string = resources3.getString(R.string.password_does_not_match);
                                }
                                XtensionFunctionKt.showSmallLengthToast(fragmentActivity4, String.valueOf(string));
                                return;
                            }
                        } else {
                            NetworkAPICall(API.API_UPDATE_PASSWORD_WITH_OTP, "", true, false, false);
                            return;
                        }
                    }
                }
                FragmentActivity activity9 = getActivity();
                if (activity9 != null) {
                    FragmentActivity fragmentActivity5 = activity9;
                    Activity activity10 = this.activity;
                    if (activity10 != null && (resources2 = activity10.getResources()) != null) {
                        string = resources2.getString(R.string.change_password_must_vary_from_8_to_13_characters);
                    }
                    XtensionFunctionKt.showSmallLengthToast(fragmentActivity5, String.valueOf(string));
                }
            }
        }
    }

    /* JADX INFO: compiled from: changepasswordnew.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¨\u0006\f"}, d2 = {"Lcom/appnew/android/loginRevamp/Fragment/changepasswordnew$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/loginRevamp/Fragment/changepasswordnew;", Const.OTP, "", "resetpass", "", "isChangePass", "isphone", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final changepasswordnew newInstance(String otp, boolean resetpass, boolean isChangePass, boolean isphone) {
            changepasswordnew changepasswordnewVar = new changepasswordnew();
            Bundle bundle = new Bundle();
            bundle.putString(Const.OTP, otp);
            bundle.putBoolean(Const.RESET_PASS, resetpass);
            bundle.putBoolean(Const.IS_CHANGE_PASS, isChangePass);
            bundle.putBoolean("isphone", isphone);
            changepasswordnewVar.setArguments(bundle);
            return changepasswordnewVar;
        }
    }
}
