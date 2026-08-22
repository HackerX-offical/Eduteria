package com.appnew.android.Theme.Adapter;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import com.appnew.android.databinding.DialogChangePasswordSuccessBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChangePasswordSuccessDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/appnew/android/Theme/Adapter/ChangePasswordSuccessDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/DialogChangePasswordSuccessBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChangePasswordSuccessDialog extends DialogFragment {
    public static final int $stable = 8;
    private DialogChangePasswordSuccessBinding binding;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Dialog dialog;
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.binding = DialogChangePasswordSuccessBinding.inflate(inflater, container, false);
        DialogChangePasswordSuccessBinding dialogChangePasswordSuccessBinding = null;
        if (getDialog() != null) {
            Dialog dialog2 = getDialog();
            if ((dialog2 != null ? dialog2.getWindow() : null) != null && (dialog = getDialog()) != null && (window = dialog.getWindow()) != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
        }
        DialogChangePasswordSuccessBinding dialogChangePasswordSuccessBinding2 = this.binding;
        if (dialogChangePasswordSuccessBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogChangePasswordSuccessBinding = dialogChangePasswordSuccessBinding2;
        }
        return dialogChangePasswordSuccessBinding.getRoot();
    }
}
