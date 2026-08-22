package com.appnew.android.Login.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomContextWrapper;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class ChooseLanguageIBT extends Fragment {
    Activity activity;
    Button continue_btn;
    RadioButton engRadio;
    LinearLayout englishRL;
    LinearLayout hindiRL;
    RadioButton hindiRadio;
    int languageCode;
    String frag_type = "";
    String languageDecider = "";

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        Window window = getActivity().getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.white));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        getActivity().getWindow().getDecorView().setSystemUiVisibility(8192);
    }

    public static ChooseLanguageIBT newInstance(int type) {
        ChooseLanguageIBT chooseLanguageIBT = new ChooseLanguageIBT();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        chooseLanguageIBT.setArguments(bundle);
        return chooseLanguageIBT;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.frag_type = getArguments().getString("type");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ibt_fragment_choose_language, (ViewGroup) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.activity = getActivity();
        initView(view);
    }

    private void initView(View view) {
        this.englishRL = (LinearLayout) view.findViewById(R.id.englishRL);
        this.hindiRL = (LinearLayout) view.findViewById(R.id.hindiRL);
        this.continue_btn = (Button) view.findViewById(R.id.continue_btn);
        this.engRadio = (RadioButton) view.findViewById(R.id.engRadio);
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.hindiRadio);
        this.hindiRadio = radioButton;
        radioButton.setChecked(false);
        this.engRadio.setChecked(false);
        this.englishRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.ChooseLanguageIBT.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ChooseLanguageIBT.this.hindiRadio.setChecked(false);
                ChooseLanguageIBT.this.engRadio.setChecked(true);
                ChooseLanguageIBT.this.languageDecider = Const.ENGLISH;
            }
        });
        this.hindiRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.ChooseLanguageIBT.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ChooseLanguageIBT.this.hindiRadio.setChecked(true);
                ChooseLanguageIBT.this.engRadio.setChecked(false);
                ChooseLanguageIBT.this.languageDecider = Const.HINDI;
            }
        });
        this.engRadio.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.ChooseLanguageIBT.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ChooseLanguageIBT.this.hindiRadio.setChecked(false);
                ChooseLanguageIBT.this.engRadio.setChecked(true);
                ChooseLanguageIBT.this.languageDecider = Const.ENGLISH;
            }
        });
        this.hindiRadio.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Login.Fragment.ChooseLanguageIBT.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ChooseLanguageIBT.this.hindiRadio.setChecked(true);
                ChooseLanguageIBT.this.engRadio.setChecked(false);
                ChooseLanguageIBT.this.languageDecider = Const.HINDI;
            }
        });
        this.continue_btn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Login.Fragment.ChooseLanguageIBT$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$initView$0();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$initView$0() {
        if (this.languageDecider.equalsIgnoreCase(Const.HINDI)) {
            nextActivity(2, Const.HINDI);
            return null;
        }
        if (this.languageDecider.equalsIgnoreCase(Const.ENGLISH)) {
            nextActivity(1, Const.ENGLISH);
            return null;
        }
        Helper.showSnackBar(getView(), this.activity.getResources().getString(R.string.please_choose_a_language));
        return null;
    }

    private void nextActivity(int lngCode, String language) {
        SharedPreference.getInstance().putInt(Const.LANGUAGE, lngCode);
        SharedPreference.getInstance().putString(Const.APP_LANGUAGE, language);
        CustomContextWrapper.wrap(this.activity, language);
        Helper.changeLang(SharedPreference.getInstance().getString(Const.APP_LANGUAGE), this.activity);
        Intent intent = new Intent(this.activity, Helper.setSignInActivity());
        intent.putExtra("type", Const.SIGNIN);
        intent.putExtra(Const.OPEN_WITH, "user");
        intent.putExtra(Const.SOCIAL_TYPE, "1");
        this.activity.finish();
        startActivity(intent);
        Helper.activityAnimation(this.activity);
    }
}
