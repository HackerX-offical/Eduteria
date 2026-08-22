package com.appnew.android.Login.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.BuildConfig;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.feeds.ExtensionFucationKt;
import com.appnew.android.home.Constants;
import com.appnew.android.pojo.Userinfo.Data;
import com.eduteria.app.app.R;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import com.hbb20.CountryCodePicker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: forgetpassword.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 x2\u00020\u0001:\u0001xB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020]H\u0016J\u0012\u0010_\u001a\u00020]2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J&\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u001a\u0010h\u001a\u00020]2\u0006\u0010i\u001a\u00020c2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0006\u0010j\u001a\u00020]J\b\u0010k\u001a\u00020]H\u0002J&\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00110m2\u0006\u0010n\u001a\u00020\u00112\u0006\u0010o\u001a\u00020\u00112\u0006\u0010p\u001a\u00020qH\u0016J(\u0010r\u001a\u00020]2\u0006\u0010s\u001a\u00020t2\u0006\u0010n\u001a\u00020\u00112\u0006\u0010o\u001a\u00020\u00112\u0006\u0010u\u001a\u00020\"H\u0016J \u0010v\u001a\u00020]2\u0006\u0010w\u001a\u00020\u00112\u0006\u0010n\u001a\u00020\u00112\u0006\u0010o\u001a\u00020\u0011H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001c\u0010:\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR\u001a\u0010=\u001a\u00020>X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR\u001c\u0010J\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001c\"\u0004\bL\u0010\u001eR\u001c\u0010M\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001c\"\u0004\bO\u0010\u001eR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006y"}, d2 = {"Lcom/appnew/android/Login/Fragment/forgetpassword;", "Lcom/appnew/android/Utils/Network/MainFragment;", "<init>", "()V", "mphonenumberET", "Landroid/widget/EditText;", "getMphonenumberET", "()Landroid/widget/EditText;", "setMphonenumberET", "(Landroid/widget/EditText;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "phone", "", "getPhone", "()Ljava/lang/String;", "setPhone", "(Ljava/lang/String;)V", "c_code", "getC_code", "setC_code", "mobileRl", "Landroid/widget/RelativeLayout;", "getMobileRl", "()Landroid/widget/RelativeLayout;", "setMobileRl", "(Landroid/widget/RelativeLayout;)V", "loginBtn", "Landroid/widget/Button;", "isphone", "", "resetPass", "isChangePass", "user", "Lcom/appnew/android/pojo/Userinfo/Data;", "getUser", "()Lcom/appnew/android/pojo/Userinfo/Data;", "setUser", "(Lcom/appnew/android/pojo/Userinfo/Data;)V", "iv_back", "Landroid/widget/ImageView;", "getIv_back", "()Landroid/widget/ImageView;", "setIv_back", "(Landroid/widget/ImageView;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "loginUsingTV", "getLoginUsingTV", "setLoginUsingTV", "emailET", "getEmailET", "setEmailET", "emailLL", "Landroid/widget/LinearLayout;", "getEmailLL", "()Landroid/widget/LinearLayout;", "setEmailLL", "(Landroid/widget/LinearLayout;)V", "is_show_email", "()Z", "set_show_email", "(Z)V", UserDataStore.COUNTRY, "getCountry", "setCountry", "flagRL", "getFlagRL", "setFlagRL", "flagCountryLL", "getFlagCountryLL", "setFlagCountryLL", "cpp", "Lcom/hbb20/CountryCodePicker;", "getCpp", "()Lcom/hbb20/CountryCodePicker;", "setCpp", "(Lcom/hbb20/CountryCodePicker;)V", "countryFlag", "Landroid/graphics/drawable/Drawable;", "getCountryFlag", "()Landroid/graphics/drawable/Drawable;", "setCountryFlag", "(Landroid/graphics/drawable/Drawable;)V", "onResume", "", "onStop", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "showMailOrMobile", "CheckValidationNew", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonObject", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class forgetpassword extends MainFragment {
    private Activity activity;
    private String c_code;
    private boolean country;
    private Drawable countryFlag;
    private CountryCodePicker cpp;
    private EditText emailET;
    public LinearLayout emailLL;
    private RelativeLayout flagCountryLL;
    private RelativeLayout flagRL;
    private boolean isChangePass;
    private boolean is_show_email;
    private boolean isphone;
    private ImageView iv_back;
    private Button loginBtn;
    private TextView loginUsingTV;
    private RelativeLayout mobileRl;
    private EditText mphonenumberET;
    private String phone;
    private boolean resetPass;
    private TextView title;
    public Data user;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public final EditText getMphonenumberET() {
        return this.mphonenumberET;
    }

    public final void setMphonenumberET(EditText editText) {
        this.mphonenumberET = editText;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final void setActivity(Activity activity) {
        this.activity = activity;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final String getC_code() {
        return this.c_code;
    }

    public final void setC_code(String str) {
        this.c_code = str;
    }

    public final RelativeLayout getMobileRl() {
        return this.mobileRl;
    }

    public final void setMobileRl(RelativeLayout relativeLayout) {
        this.mobileRl = relativeLayout;
    }

    public final Data getUser() {
        Data data = this.user;
        if (data != null) {
            return data;
        }
        Intrinsics.throwUninitializedPropertyAccessException("user");
        return null;
    }

    public final void setUser(Data data) {
        Intrinsics.checkNotNullParameter(data, "<set-?>");
        this.user = data;
    }

    public final ImageView getIv_back() {
        return this.iv_back;
    }

    public final void setIv_back(ImageView imageView) {
        this.iv_back = imageView;
    }

    public final TextView getTitle() {
        return this.title;
    }

    public final void setTitle(TextView textView) {
        this.title = textView;
    }

    public final TextView getLoginUsingTV() {
        return this.loginUsingTV;
    }

    public final void setLoginUsingTV(TextView textView) {
        this.loginUsingTV = textView;
    }

    public final EditText getEmailET() {
        return this.emailET;
    }

    public final void setEmailET(EditText editText) {
        this.emailET = editText;
    }

    public final LinearLayout getEmailLL() {
        LinearLayout linearLayout = this.emailLL;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("emailLL");
        return null;
    }

    public final void setEmailLL(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.emailLL = linearLayout;
    }

    /* JADX INFO: renamed from: is_show_email, reason: from getter */
    public final boolean getIs_show_email() {
        return this.is_show_email;
    }

    public final void set_show_email(boolean z) {
        this.is_show_email = z;
    }

    public final boolean getCountry() {
        return this.country;
    }

    public final void setCountry(boolean z) {
        this.country = z;
    }

    public final RelativeLayout getFlagRL() {
        return this.flagRL;
    }

    public final void setFlagRL(RelativeLayout relativeLayout) {
        this.flagRL = relativeLayout;
    }

    public final RelativeLayout getFlagCountryLL() {
        return this.flagCountryLL;
    }

    public final void setFlagCountryLL(RelativeLayout relativeLayout) {
        this.flagCountryLL = relativeLayout;
    }

    public final CountryCodePicker getCpp() {
        return this.cpp;
    }

    public final void setCpp(CountryCodePicker countryCodePicker) {
        this.cpp = countryCodePicker;
    }

    public final Drawable getCountryFlag() {
        return this.countryFlag;
    }

    public final void setCountryFlag(Drawable drawable) {
        this.countryFlag = drawable;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        Intrinsics.checkNotNull(appCompatActivity);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.hide();
        requireActivity().getWindow();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        Intrinsics.checkNotNull(appCompatActivity);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.show();
        requireActivity().getWindow().getDecorView().setSystemUiVisibility(8192);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        if (getArguments() != null) {
            this.resetPass = requireArguments().getBoolean(Const.RESET_PASS);
            this.isChangePass = requireArguments().getBoolean(Const.IS_CHANGE_PASS);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.ibt_fragment_forget_password, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Resources resources;
        TextView textView;
        Resources resources2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.loginUsingTV);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.loginUsingTV = (TextView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.mobileRl);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.mobileRl = (RelativeLayout) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.mobileTV);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.EditText");
        this.mphonenumberET = (EditText) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.emailTV);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.EditText");
        this.emailET = (EditText) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.loginBtn);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.Button");
        this.loginBtn = (Button) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.emailLL);
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.LinearLayout");
        setEmailLL((LinearLayout) viewFindViewById6);
        View viewFindViewById7 = view.findViewById(R.id.iv_back);
        Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.widget.ImageView");
        this.iv_back = (ImageView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.title);
        Intrinsics.checkNotNull(viewFindViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.title = (TextView) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.flagRL);
        Intrinsics.checkNotNull(viewFindViewById9, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.flagRL = (RelativeLayout) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.flagCountryLL);
        Intrinsics.checkNotNull(viewFindViewById10, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.flagCountryLL = (RelativeLayout) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.countryDropDown);
        Intrinsics.checkNotNull(viewFindViewById11, "null cannot be cast to non-null type com.hbb20.CountryCodePicker");
        this.cpp = (CountryCodePicker) viewFindViewById11;
        this.is_show_email = StringsKt.equals(SharedPreference.getInstance().getString(Const.EMAIL_SHOW), "1", true);
        if (Intrinsics.areEqual(SharedPreference.getInstance().getString(Const.COUNTRY_SHOW), "1")) {
            this.country = true;
        }
        if (this.country) {
            RelativeLayout relativeLayout = this.flagCountryLL;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = this.flagRL;
            Intrinsics.checkNotNull(relativeLayout2);
            relativeLayout2.setVisibility(8);
        } else {
            RelativeLayout relativeLayout3 = this.flagCountryLL;
            Intrinsics.checkNotNull(relativeLayout3);
            relativeLayout3.setVisibility(8);
            RelativeLayout relativeLayout4 = this.flagRL;
            Intrinsics.checkNotNull(relativeLayout4);
            relativeLayout4.setVisibility(0);
        }
        CountryCodePicker countryCodePicker = this.cpp;
        Intrinsics.checkNotNull(countryCodePicker);
        EditText editText = this.mphonenumberET;
        Intrinsics.checkNotNull(editText);
        countryCodePicker.registerCarrierNumberEditText(editText);
        EditText editText2 = this.mphonenumberET;
        if (editText2 != null) {
            editText2.setFilters(new InputFilter[]{new InputFilter() { // from class: com.appnew.android.Login.Fragment.forgetpassword$$ExternalSyntheticLambda0
                @Override // android.text.InputFilter
                public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    return forgetpassword.onViewCreated$lambda$0(charSequence, i, i2, spanned, i3, i4);
                }
            }, new InputFilter.LengthFilter(10)});
        }
        if (this.isChangePass) {
            EditText editText3 = this.mphonenumberET;
            Intrinsics.checkNotNull(editText3);
            editText3.setEnabled(false);
            EditText editText4 = this.mphonenumberET;
            Intrinsics.checkNotNull(editText4);
            editText4.setFocusable(false);
            EditText editText5 = this.mphonenumberET;
            Intrinsics.checkNotNull(editText5);
            editText5.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
            TextView textView2 = this.title;
            Intrinsics.checkNotNull(textView2);
            Activity activity = this.activity;
            textView2.setText((activity == null || (resources2 = activity.getResources()) == null) ? null : resources2.getString(R.string.change_password));
            if (this.country) {
                String cCode = SharedPreference.getInstance().getLoggedInUser().getCCode();
                CountryCodePicker countryCodePicker2 = this.cpp;
                Intrinsics.checkNotNull(countryCodePicker2);
                countryCodePicker2.setCcpClickable(false);
                CountryCodePicker countryCodePicker3 = this.cpp;
                Intrinsics.checkNotNull(countryCodePicker3);
                countryCodePicker3.setCountryForPhoneCode(Helper.converToIntCountryCode(cCode));
            }
            EditText editText6 = this.emailET;
            Intrinsics.checkNotNull(editText6);
            editText6.setEnabled(false);
            EditText editText7 = this.emailET;
            Intrinsics.checkNotNull(editText7);
            editText7.setFocusable(false);
            EditText editText8 = this.emailET;
            Intrinsics.checkNotNull(editText8);
            editText8.setText(SharedPreference.getInstance().getLoggedInUser().getEmail());
        } else {
            TextView textView3 = this.title;
            Intrinsics.checkNotNull(textView3);
            Activity activity2 = this.activity;
            textView3.setText((activity2 == null || (resources = activity2.getResources()) == null) ? null : resources.getString(R.string.forget_password));
        }
        if (this.is_show_email && (textView = this.loginUsingTV) != null) {
            XtensionFunctionKt.visible(textView);
        }
        TextView textView4 = this.loginUsingTV;
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.forgetpassword$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.showMailOrMobile();
                }
            });
        }
        ImageView imageView = this.iv_back;
        Intrinsics.checkNotNull(imageView);
        imageView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.forgetpassword$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return forgetpassword.onViewCreated$lambda$2(this.f$0);
            }
        }));
        Button button = this.loginBtn;
        Intrinsics.checkNotNull(button);
        button.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.forgetpassword$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return forgetpassword.onViewCreated$lambda$3(this.f$0);
            }
        }));
        if (StringsKt.equals(BuildConfig.FLAVOR, "physicsgalaxy", true)) {
            ImageView imageView2 = this.iv_back;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setImageTintList(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onViewCreated$lambda$0(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (!Intrinsics.areEqual(charSequence, "")) {
            if (!new Regex("[0-9]+").matches(charSequence.toString())) {
                return "";
            }
        }
        return charSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(forgetpassword forgetpasswordVar) {
        FragmentActivity activity = forgetpasswordVar.getActivity();
        if (activity != null) {
            activity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(forgetpassword forgetpasswordVar) {
        forgetpasswordVar.CheckValidationNew();
        return Unit.INSTANCE;
    }

    public final void showMailOrMobile() {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        TextView textView = this.loginUsingTV;
        String string = null;
        CharSequence text = textView != null ? textView.getText() : null;
        Activity activity = this.activity;
        if (StringsKt.contentEquals(text, (activity == null || (resources4 = activity.getResources()) == null) ? null : resources4.getString(R.string.recover_using_email))) {
            XtensionFunctionKt.visible(getEmailLL());
            RelativeLayout relativeLayout = this.mobileRl;
            if (relativeLayout != null) {
                XtensionFunctionKt.gone(relativeLayout);
            }
            TextView textView2 = this.loginUsingTV;
            if (textView2 != null) {
                Activity activity2 = this.activity;
                if (activity2 != null && (resources3 = activity2.getResources()) != null) {
                    string = resources3.getString(R.string.recover_using_mobile_number);
                }
                textView2.setText(string);
                return;
            }
            return;
        }
        TextView textView3 = this.loginUsingTV;
        CharSequence text2 = textView3 != null ? textView3.getText() : null;
        Activity activity3 = this.activity;
        if (StringsKt.contentEquals(text2, (activity3 == null || (resources2 = activity3.getResources()) == null) ? null : resources2.getString(R.string.recover_using_mobile_number))) {
            RelativeLayout relativeLayout2 = this.mobileRl;
            if (relativeLayout2 != null) {
                XtensionFunctionKt.visible(relativeLayout2);
            }
            XtensionFunctionKt.gone(getEmailLL());
            TextView textView4 = this.loginUsingTV;
            if (textView4 != null) {
                Activity activity4 = this.activity;
                if (activity4 != null && (resources = activity4.getResources()) != null) {
                    string = resources.getString(R.string.recover_using_email);
                }
                textView4.setText(string);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void CheckValidationNew() {
        /*
            Method dump skipped, instruction units count: 681
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Login.Fragment.forgetpassword.CheckValidationNew():void");
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        String mobile;
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.API_SEND_OTP_VERIFICATION)) {
            EncryptionData encryptionData = new EncryptionData();
            if (!this.isphone || TextUtils.isEmpty(getUser().getMobile())) {
                mobile = getUser().getEmail();
            } else {
                mobile = getUser().getMobile();
            }
            encryptionData.setMobile(mobile);
            encryptionData.setOtp("");
            encryptionData.setIs_registration("0");
            encryptionData.setResend("0");
            return service.getOtpVerification(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        return service.getOtpVerification("");
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonObject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        if (Intrinsics.areEqual(apitype, API.API_SEND_OTP_VERIFICATION)) {
            if (Intrinsics.areEqual(jsonObject.optString("status"), "true")) {
                if (this.isphone) {
                    Constants.MOBILE_NO = getUser().getMobile();
                } else {
                    Constants.MOBILE_NO = getUser().getEmail();
                }
                SharedPreference.getInstance().putString(Const.FORGETPASSWORD, jsonObject.optString("message"));
                Helper.GoToOtpVerificationActivity(this.activity, "", 2, Const.OTPVERIFICATION, this.resetPass, this.isChangePass, this.isphone, this.countryFlag, this.c_code);
                return;
            }
            RetrofitResponse.GetApiData(this.activity, jsonObject.optString("auth_code"), jsonObject.optString("message"), false);
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            String strOptString = jsonObject.optString("message");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            ExtensionFucationKt.showToast(contextRequireContext, strOptString);
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        if (Intrinsics.areEqual(apitype, API.API_SEND_OTP_VERIFICATION)) {
            Toast.makeText(this.activity, jsonstring, 0).show();
        }
    }

    /* JADX INFO: compiled from: forgetpassword.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/appnew/android/Login/Fragment/forgetpassword$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/Login/Fragment/forgetpassword;", "resetpass", "", "isChangePass", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final forgetpassword newInstance(boolean resetpass, boolean isChangePass) {
            forgetpassword forgetpasswordVar = new forgetpassword();
            Bundle bundle = new Bundle();
            bundle.putBoolean(Const.RESET_PASS, resetpass);
            bundle.putBoolean(Const.IS_CHANGE_PASS, isChangePass);
            forgetpasswordVar.setArguments(bundle);
            return forgetpasswordVar;
        }
    }
}
