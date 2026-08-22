package com.appnew.android.Login.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.FragmentSignUpFormNaveenBinding;
import com.eduteria.app.app.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignUpFormNaveen.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/appnew/android/Login/Fragment/SignUpFormNaveen;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", Const.OTP, "", "socialType", "isSocial", "c_code", "c_flagArr", "", "binding", "Lcom/appnew/android/databinding/FragmentSignUpFormNaveenBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentSignUpFormNaveenBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentSignUpFormNaveenBinding;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignUpFormNaveen extends Fragment {
    public FragmentSignUpFormNaveenBinding binding;
    private String c_code;
    private byte[] c_flagArr;
    private String isSocial;
    private String otp;
    private String socialType;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final SignUpFormNaveen newInstance(String str, String str2, String str3, String str4, byte[] bArr) {
        return INSTANCE.newInstance(str, str2, str3, str4, bArr);
    }

    public final FragmentSignUpFormNaveenBinding getBinding() {
        FragmentSignUpFormNaveenBinding fragmentSignUpFormNaveenBinding = this.binding;
        if (fragmentSignUpFormNaveenBinding != null) {
            return fragmentSignUpFormNaveenBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentSignUpFormNaveenBinding fragmentSignUpFormNaveenBinding) {
        Intrinsics.checkNotNullParameter(fragmentSignUpFormNaveenBinding, "<set-?>");
        this.binding = fragmentSignUpFormNaveenBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.otp = arguments.getString(Const.OTP);
            this.socialType = arguments.getString("socialType");
            this.isSocial = arguments.getString("isSocial");
            this.c_code = arguments.getString("c_code");
            this.c_flagArr = arguments.getByteArray("c_flagArr");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(FragmentSignUpFormNaveenBinding.inflate(getLayoutInflater()));
        NestedScrollView root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: compiled from: SignUpFormNaveen.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/appnew/android/Login/Fragment/SignUpFormNaveen$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/Login/Fragment/SignUpFormNaveen;", Const.OTP, "", "socialType", "isSocial", "c_code", "c_flagArr", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SignUpFormNaveen newInstance(String otp, String socialType, String isSocial, String c_code, byte[] c_flagArr) {
            Intrinsics.checkNotNullParameter(otp, "otp");
            Intrinsics.checkNotNullParameter(socialType, "socialType");
            Intrinsics.checkNotNullParameter(isSocial, "isSocial");
            Intrinsics.checkNotNullParameter(c_flagArr, "c_flagArr");
            SignUpFormNaveen signUpFormNaveen = new SignUpFormNaveen();
            Bundle bundle = new Bundle();
            bundle.putString(Const.OTP, otp);
            bundle.putString("socialType", socialType);
            bundle.putString("isSocial", isSocial);
            bundle.putString("c_code", c_code);
            bundle.putByteArray("c_flagArr", c_flagArr);
            signUpFormNaveen.setArguments(bundle);
            return signUpFormNaveen;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        Intrinsics.checkNotNull(appCompatActivity);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.hide();
        Window window = requireActivity().getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(ContextCompat.getColor(requireActivity(), R.color.white));
    }
}
