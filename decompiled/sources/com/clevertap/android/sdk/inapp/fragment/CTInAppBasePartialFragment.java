package com.clevertap.android.sdk.inapp.fragment;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.inapp.InAppDisplayListener;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CTInAppBasePartialFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBasePartialFragment;", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFragment;", "Lcom/clevertap/android/sdk/inapp/InAppDisplayListener;", "<init>", "()V", "isCleanedUp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onStart", "", "onStop", "cleanup", "generateListener", "registerInAppDisplayListener", "unregisterInAppDisplayListener", "hideInApp", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CTInAppBasePartialFragment extends CTInAppBaseFragment implements InAppDisplayListener {
    private final AtomicBoolean isCleanedUp = new AtomicBoolean();

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.isCleanedUp.get()) {
            cleanup();
        }
        registerInAppDisplayListener();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        unregisterInAppDisplayListener();
    }

    @Override // com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFragment
    protected void cleanup() {
        FragmentActivity activity = getActivity();
        if (activity == null || Utils.isActivityDead(activity) || !this.isCleanedUp.compareAndSet(false, true)) {
            return;
        }
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        try {
            fragmentTransactionBeginTransaction.remove(this).commit();
        } catch (IllegalStateException unused) {
            supportFragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
        }
    }

    @Override // com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFragment
    protected void generateListener() {
        setListener(CleverTapAPI.instanceWithConfig(requireContext(), getConfig()).getCoreState().getInAppController());
    }

    private final void registerInAppDisplayListener() {
        Context context = getContext();
        if (context != null) {
            CleverTapAPI.instanceWithConfig(context, getConfig()).getCoreState().getInAppController().registerInAppDisplayListener(this);
        }
    }

    private final void unregisterInAppDisplayListener() {
        Context context = getContext();
        if (context != null) {
            CleverTapAPI.instanceWithConfig(context, getConfig()).getCoreState().getInAppController().unregisterInAppDisplayListener();
        }
    }

    @Override // com.clevertap.android.sdk.inapp.InAppDisplayListener
    public void hideInApp() {
        didDismiss(null);
    }
}
