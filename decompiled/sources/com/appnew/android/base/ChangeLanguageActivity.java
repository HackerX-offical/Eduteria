package com.appnew.android.base;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme3;
import com.appnew.android.Theme.DashboardActivityTheme4;
import com.appnew.android.Theme.DashboardActivityTheme5;
import com.appnew.android.Theme.DashboardActivityTheme7;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomContextWrapper;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityChangeLanguageBinding;
import com.eduteria.app.app.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ChangeLanguageActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/appnew/android/base/ChangeLanguageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityChangeLanguageBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityChangeLanguageBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityChangeLanguageBinding;)V", Const.FRAG_TYPE, "", "getFrag_type", "()Ljava/lang/String;", "setFrag_type", "(Ljava/lang/String;)V", "languageDecider", "getLanguageDecider", "setLanguageDecider", "onStop", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "initView", "nextActivity", "lngCode", "", Const.LANGUAGE, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChangeLanguageActivity extends AppCompatActivity {
    public static final int $stable = 8;
    public ActivityChangeLanguageBinding binding;
    private String frag_type = "";
    private String languageDecider = "";

    public final ActivityChangeLanguageBinding getBinding() {
        ActivityChangeLanguageBinding activityChangeLanguageBinding = this.binding;
        if (activityChangeLanguageBinding != null) {
            return activityChangeLanguageBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityChangeLanguageBinding activityChangeLanguageBinding) {
        Intrinsics.checkNotNullParameter(activityChangeLanguageBinding, "<set-?>");
        this.binding = activityChangeLanguageBinding;
    }

    public final String getFrag_type() {
        return this.frag_type;
    }

    public final void setFrag_type(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.frag_type = str;
    }

    public final String getLanguageDecider() {
        return this.languageDecider;
    }

    public final void setLanguageDecider(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.languageDecider = str;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding((ActivityChangeLanguageBinding) DataBindingUtil.setContentView(this, R.layout.activity_change_language));
        initView();
        if (SharedPreference.getInstance().getInt(Const.LANGUAGE) == 1) {
            getBinding().hindiRadio.setChecked(false);
            getBinding().engRadio.setChecked(true);
        } else if (SharedPreference.getInstance().getInt(Const.LANGUAGE) == 2) {
            getBinding().hindiRadio.setChecked(true);
            getBinding().engRadio.setChecked(false);
        }
    }

    private final void initView() {
        getBinding().hindiRadio.setChecked(false);
        getBinding().englishRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.ChangeLanguageActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeLanguageActivity.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().hindiRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.ChangeLanguageActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeLanguageActivity.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().engRadio.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.ChangeLanguageActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeLanguageActivity.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().hindiRadio.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.ChangeLanguageActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeLanguageActivity.initView$lambda$3(this.f$0, view);
            }
        });
        getBinding().continueBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.base.ChangeLanguageActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ChangeLanguageActivity.initView$lambda$4(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ChangeLanguageActivity changeLanguageActivity, View view) {
        changeLanguageActivity.getBinding().hindiRadio.setChecked(false);
        changeLanguageActivity.getBinding().engRadio.setChecked(true);
        changeLanguageActivity.languageDecider = Const.ENGLISH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ChangeLanguageActivity changeLanguageActivity, View view) {
        changeLanguageActivity.getBinding().hindiRadio.setChecked(true);
        changeLanguageActivity.getBinding().engRadio.setChecked(false);
        changeLanguageActivity.languageDecider = Const.HINDI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ChangeLanguageActivity changeLanguageActivity, View view) {
        changeLanguageActivity.getBinding().hindiRadio.setChecked(false);
        changeLanguageActivity.getBinding().engRadio.setChecked(true);
        changeLanguageActivity.languageDecider = Const.ENGLISH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ChangeLanguageActivity changeLanguageActivity, View view) {
        changeLanguageActivity.getBinding().hindiRadio.setChecked(true);
        changeLanguageActivity.getBinding().engRadio.setChecked(false);
        changeLanguageActivity.languageDecider = Const.HINDI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$4(ChangeLanguageActivity changeLanguageActivity) {
        if (StringsKt.equals(changeLanguageActivity.languageDecider, Const.HINDI, true)) {
            changeLanguageActivity.nextActivity(2, Const.HINDI);
        } else if (StringsKt.equals(changeLanguageActivity.languageDecider, Const.ENGLISH, true)) {
            changeLanguageActivity.nextActivity(1, Const.ENGLISH);
        } else {
            View root = changeLanguageActivity.getBinding().getRoot();
            Resources resources = changeLanguageActivity.getResources();
            Helper.showSnackBar(root, resources != null ? resources.getString(R.string.please_choose_a_language) : null);
        }
        return Unit.INSTANCE;
    }

    private final void nextActivity(int lngCode, String language) {
        SharedPreference.getInstance().putInt(Const.LANGUAGE, lngCode);
        SharedPreference.getInstance().putString(Const.APP_LANGUAGE, language);
        ChangeLanguageActivity changeLanguageActivity = this;
        CustomContextWrapper.wrap(changeLanguageActivity, language);
        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE), changeLanguageActivity);
        if (!StringsKt.equals("1", "1", true)) {
            if (!StringsKt.equals("1", "2", true)) {
                if (!StringsKt.equals("1", "3", true)) {
                    if (!StringsKt.equals("1", "4", true)) {
                        if (!StringsKt.equals("1", "5", true)) {
                            if (!StringsKt.equals("1", "6", true)) {
                                if (StringsKt.equals("1", "7", true)) {
                                    Helper.gotoActivity(this, (Class<?>) DashboardActivityTheme8.class);
                                }
                            } else {
                                Helper.gotoActivity(this, (Class<?>) DashboardActivityTheme7.class);
                            }
                        } else {
                            Helper.gotoActivity(this, (Class<?>) DashboardActivityTheme5.class);
                        }
                    } else {
                        Helper.gotoActivity(this, (Class<?>) DashboardActivityTheme4.class);
                    }
                } else {
                    Helper.gotoActivity(this, (Class<?>) DashboardActivityTheme3.class);
                }
            } else {
                Helper.gotoActivity(this, (Class<?>) DashboardActivityTheme2.class);
            }
        } else {
            Helper.gotoActivity(this, (Class<?>) DashboardActivityTheme1.class);
        }
        finishAffinity();
    }
}
