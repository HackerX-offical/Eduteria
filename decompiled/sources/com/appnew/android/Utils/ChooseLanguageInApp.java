package com.appnew.android.Utils;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.databinding.IbtFragmentChooseLanguageBinding;
import com.eduteria.app.app.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ChooseLanguageInApp.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0006\u0010\u0014\u001a\u00020\u0011J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/appnew/android/Utils/ChooseLanguageInApp;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/IbtFragmentChooseLanguageBinding;", "getBinding", "()Lcom/appnew/android/databinding/IbtFragmentChooseLanguageBinding;", "setBinding", "(Lcom/appnew/android/databinding/IbtFragmentChooseLanguageBinding;)V", "languageDecider", "", "getLanguageDecider", "()Ljava/lang/String;", "setLanguageDecider", "(Ljava/lang/String;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "nextActivity", "lngCode", "", Const.LANGUAGE, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseLanguageInApp extends AppCompatActivity {
    public static final int $stable = 8;
    public IbtFragmentChooseLanguageBinding binding;
    private String languageDecider = "";

    public final IbtFragmentChooseLanguageBinding getBinding() {
        IbtFragmentChooseLanguageBinding ibtFragmentChooseLanguageBinding = this.binding;
        if (ibtFragmentChooseLanguageBinding != null) {
            return ibtFragmentChooseLanguageBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(IbtFragmentChooseLanguageBinding ibtFragmentChooseLanguageBinding) {
        Intrinsics.checkNotNullParameter(ibtFragmentChooseLanguageBinding, "<set-?>");
        this.binding = ibtFragmentChooseLanguageBinding;
    }

    public final String getLanguageDecider() {
        return this.languageDecider;
    }

    public final void setLanguageDecider(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.languageDecider = str;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChooseLanguageInApp chooseLanguageInApp = this;
        Helper.setSystemBarLight(chooseLanguageInApp);
        Helper.enableScreenShot(chooseLanguageInApp);
        setBinding(IbtFragmentChooseLanguageBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        initView();
    }

    public final void initView() {
        getBinding().hindiRadio.setChecked(false);
        getBinding().engRadio.setChecked(false);
        getBinding().englishRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.ChooseLanguageInApp$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooseLanguageInApp.initView$lambda$0(this.f$0, view);
            }
        });
        getBinding().hindiRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.ChooseLanguageInApp$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooseLanguageInApp.initView$lambda$1(this.f$0, view);
            }
        });
        getBinding().engRadio.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.ChooseLanguageInApp$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooseLanguageInApp.initView$lambda$2(this.f$0, view);
            }
        });
        getBinding().hindiRadio.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.ChooseLanguageInApp$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooseLanguageInApp.initView$lambda$3(this.f$0, view);
            }
        });
        getBinding().continueBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Utils.ChooseLanguageInApp$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ChooseLanguageInApp.initView$lambda$4(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(ChooseLanguageInApp chooseLanguageInApp, View view) {
        chooseLanguageInApp.getBinding().hindiRadio.setChecked(false);
        chooseLanguageInApp.getBinding().engRadio.setChecked(true);
        chooseLanguageInApp.languageDecider = Const.ENGLISH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(ChooseLanguageInApp chooseLanguageInApp, View view) {
        chooseLanguageInApp.getBinding().hindiRadio.setChecked(true);
        chooseLanguageInApp.getBinding().engRadio.setChecked(false);
        chooseLanguageInApp.languageDecider = Const.HINDI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ChooseLanguageInApp chooseLanguageInApp, View view) {
        chooseLanguageInApp.getBinding().hindiRadio.setChecked(false);
        chooseLanguageInApp.getBinding().engRadio.setChecked(true);
        chooseLanguageInApp.languageDecider = Const.ENGLISH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ChooseLanguageInApp chooseLanguageInApp, View view) {
        chooseLanguageInApp.getBinding().hindiRadio.setChecked(true);
        chooseLanguageInApp.getBinding().engRadio.setChecked(false);
        chooseLanguageInApp.languageDecider = Const.HINDI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$4(ChooseLanguageInApp chooseLanguageInApp) {
        if (StringsKt.equals(chooseLanguageInApp.languageDecider, Const.HINDI, true)) {
            chooseLanguageInApp.nextActivity(2, Const.HINDI);
        } else if (StringsKt.equals(chooseLanguageInApp.languageDecider, Const.ENGLISH, true)) {
            chooseLanguageInApp.nextActivity(1, Const.ENGLISH);
        } else {
            Toast.makeText(chooseLanguageInApp, R.string.please_choose_a_language, 0).show();
        }
        return Unit.INSTANCE;
    }

    public final void nextActivity(int lngCode, String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        SharedPreference.getInstance().putInt(Const.LANGUAGE, lngCode);
        SharedPreference.getInstance().putString(Const.APP_LANGUAGE, language);
        if (lngCode == 1) {
            Locale locale = new Locale(Const.ENGLISH);
            Resources resources = getResources();
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.setLocale(locale);
            resources.updateConfiguration(configuration, displayMetrics);
        } else if (lngCode == 2) {
            Locale locale2 = new Locale(Const.HINDI);
            Resources resources2 = getResources();
            Configuration configuration2 = resources2.getConfiguration();
            DisplayMetrics displayMetrics2 = resources2.getDisplayMetrics();
            configuration2.setLocale(locale2);
            resources2.updateConfiguration(configuration2, displayMetrics2);
        }
        Intent intent = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
        intent.setFlags(268468224);
        finish();
        Helper.gotoActivity_finish(intent, this);
    }
}
