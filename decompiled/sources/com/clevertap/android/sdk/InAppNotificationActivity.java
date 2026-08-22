package com.clevertap.android.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.activity.OnBackPressedCallback;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import com.clevertap.android.sdk.PushPermissionHandler;
import com.clevertap.android.sdk.inapp.CTInAppAction;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inapp.CTInAppNotificationButton;
import com.clevertap.android.sdk.inapp.CTInAppType;
import com.clevertap.android.sdk.inapp.InAppActionType;
import com.clevertap.android.sdk.inapp.InAppDisplayListener;
import com.clevertap.android.sdk.inapp.InAppListener;
import com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFullFragment;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class InAppNotificationActivity extends FragmentActivity implements InAppListener, DidClickForHardPermissionListener, PushPermissionHandler.PushPermissionResultCallback, InAppDisplayListener {
    private static final String INTENT_EXTRA_CT_CONFIG = "config";
    private static final String INTENT_EXTRA_DISPLAY_PUSH_PERMISSION_PROMPT = "displayPushPermissionPrompt";
    private static final String INTENT_EXTRA_PUSH_PERMISSION_FALLBACK_TO_SETTINGS = "shouldShowFallbackSettings";
    private static boolean isAlertVisible = false;
    private CleverTapInstanceConfig config;
    private CTInAppNotification inAppNotification;
    private boolean invokedCallbacks = false;
    private WeakReference<InAppListener> listenerWeakReference;
    private PushPermissionHandler pushPermissionHandler;

    public static void launchForPushPermissionPrompt(Activity activity, CleverTapInstanceConfig cleverTapInstanceConfig, boolean z) {
        if (activity.getClass().equals(InAppNotificationActivity.class)) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) InAppNotificationActivity.class);
        intent.putExtra("config", cleverTapInstanceConfig);
        intent.putExtra(INTENT_EXTRA_DISPLAY_PUSH_PERMISSION_PROMPT, true);
        intent.putExtra(INTENT_EXTRA_PUSH_PERMISSION_FALLBACK_TO_SETTINGS, z);
        activity.startActivity(intent);
    }

    public static void launchForInAppNotification(Context context, CTInAppNotification cTInAppNotification, CleverTapInstanceConfig cleverTapInstanceConfig) {
        Intent intent = new Intent(context, (Class<?>) InAppNotificationActivity.class);
        intent.putExtra(Constants.INAPP_KEY, cTInAppNotification);
        intent.putExtra("config", cleverTapInstanceConfig);
        context.startActivity(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) { // from class: com.clevertap.android.sdk.InAppNotificationActivity.1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                InAppNotificationActivity.this.finish();
                InAppNotificationActivity.this.didDismiss(null);
            }
        });
        int i = getResources().getConfiguration().orientation;
        if (i == 2 && (window = getWindow()) != null) {
            window.addFlags(1024);
            new WindowInsetsControllerCompat(window, window.getDecorView()).hide(WindowInsetsCompat.Type.systemBars());
        }
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                throw new IllegalArgumentException();
            }
            CleverTapInstanceConfig cleverTapInstanceConfig = (CleverTapInstanceConfig) extras.getParcelable("config");
            this.config = cleverTapInstanceConfig;
            if (cleverTapInstanceConfig == null) {
                throw new IllegalArgumentException();
            }
            CoreState coreState = CleverTapAPI.instanceWithConfig(this, cleverTapInstanceConfig).getCoreState();
            this.pushPermissionHandler = new PushPermissionHandler(this.config, coreState.getCallbackManager().getPushPermissionResponseListenerList(), this);
            if (extras.getBoolean(INTENT_EXTRA_DISPLAY_PUSH_PERMISSION_PROMPT, false)) {
                showPushPermissionPrompt(extras.getBoolean(INTENT_EXTRA_PUSH_PERMISSION_FALLBACK_TO_SETTINGS, false));
                return;
            }
            setListener(coreState.getInAppController());
            coreState.getInAppController().registerInAppDisplayListener(this);
            CTInAppNotification cTInAppNotification = (CTInAppNotification) extras.getParcelable(Constants.INAPP_KEY);
            this.inAppNotification = cTInAppNotification;
            if (cTInAppNotification == null) {
                finish();
                return;
            }
            if (cTInAppNotification.getIsPortrait() && !this.inAppNotification.getIsLandscape()) {
                if (i == 2) {
                    Logger.d("App in Landscape, dismissing portrait InApp Notification");
                    finish();
                    didDismiss(null);
                    return;
                }
                Logger.d("App in Portrait, displaying InApp Notification anyway");
            }
            if (!this.inAppNotification.getIsPortrait() && this.inAppNotification.getIsLandscape()) {
                if (i == 1) {
                    Logger.d("App in Portrait, dismissing landscape InApp Notification");
                    finish();
                    didDismiss(null);
                    return;
                }
                Logger.d("App in Landscape, displaying InApp Notification anyway");
            }
            if (bundle == null) {
                CTInAppBaseFullFragment cTInAppBaseFullFragmentCreateContentFragment = createContentFragment();
                if (cTInAppBaseFullFragmentCreateContentFragment != null) {
                    cTInAppBaseFullFragmentCreateContentFragment.setArguments(this.inAppNotification, this.config);
                    getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).add(android.R.id.content, cTInAppBaseFullFragmentCreateContentFragment, getFragmentTag()).commitNow();
                    return;
                }
                return;
            }
            if (isAlertVisible) {
                createContentFragment();
            }
        } catch (Throwable th) {
            Logger.v("Cannot find a valid notification bundle to show!", th);
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.pushPermissionHandler.onActivityResume(this);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (Build.VERSION.SDK_INT >= 34) {
            overrideActivityTransition(1, android.R.anim.fade_in, android.R.anim.fade_out);
        } else {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public Bundle inAppNotificationDidClick(CTInAppNotification cTInAppNotification, CTInAppNotificationButton cTInAppNotificationButton, Context context) {
        InAppListener listener = getListener();
        if (listener != null) {
            return listener.inAppNotificationDidClick(cTInAppNotification, cTInAppNotificationButton, this);
        }
        return null;
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public void inAppNotificationDidDismiss(CTInAppNotification cTInAppNotification, Bundle bundle) {
        didDismiss(bundle);
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public void inAppNotificationDidShow(CTInAppNotification cTInAppNotification, Bundle bundle) {
        didShow(bundle);
    }

    @Override // com.clevertap.android.sdk.inapp.InAppListener
    public Bundle inAppNotificationActionTriggered(CTInAppNotification cTInAppNotification, CTInAppAction cTInAppAction, String str, Bundle bundle, Context context) {
        InAppListener listener = getListener();
        if (listener != null) {
            return listener.inAppNotificationActionTriggered(cTInAppNotification, cTInAppAction, str, bundle, this);
        }
        return null;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(android.R.style.Theme.Translucent.NoTitleBar);
    }

    @Override // com.clevertap.android.sdk.DidClickForHardPermissionListener
    public void didClickForHardPermissionWithFallbackSettings(boolean z) {
        showPushPermissionPrompt(z);
    }

    @Override // com.clevertap.android.sdk.DidClickForHardPermissionListener
    public void didCancelPermissionRequest() {
        this.pushPermissionHandler.notifyPushPermissionExternalListeners(this);
    }

    public void showPushPermissionPrompt(boolean z) {
        this.pushPermissionHandler.requestPermission(this, z);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.pushPermissionHandler.onRequestPermissionsResult(this, i, iArr);
    }

    @Override // com.clevertap.android.sdk.PushPermissionHandler.PushPermissionResultCallback
    public void onPushPermissionResult(boolean z) {
        Bundle bundle;
        CTInAppNotification cTInAppNotification = this.inAppNotification;
        if (cTInAppNotification == null || !cTInAppNotification.getIsLocalInApp()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle.putString(Constants.KEY_C2A, this.inAppNotification.getButtons().get(0).getText());
            bundle.putString(Constants.NOTIFICATION_ID_TAG, "");
        }
        didDismiss(bundle);
    }

    void didDismiss(Bundle bundle) {
        didDismiss(bundle, true);
    }

    void didDismiss(Bundle bundle, boolean z) {
        CTInAppNotification cTInAppNotification;
        if (isAlertVisible) {
            isAlertVisible = false;
        }
        if (!this.invokedCallbacks) {
            InAppListener listener = getListener();
            if (listener != null && (cTInAppNotification = this.inAppNotification) != null) {
                listener.inAppNotificationDidDismiss(cTInAppNotification, bundle);
            }
            this.invokedCallbacks = true;
        }
        if (z) {
            finish();
        }
    }

    void didShow(Bundle bundle) {
        InAppListener listener = getListener();
        if (listener != null) {
            listener.inAppNotificationDidShow(this.inAppNotification, bundle);
        }
    }

    InAppListener getListener() {
        InAppListener inAppListener;
        try {
            inAppListener = this.listenerWeakReference.get();
        } catch (Throwable unused) {
            inAppListener = null;
        }
        if (inAppListener == null && this.inAppNotification != null) {
            this.config.getLogger().verbose(this.config.getAccountId(), "InAppActivityListener is null for notification: " + this.inAppNotification.getJsonDescription());
        }
        return inAppListener;
    }

    void setListener(InAppListener inAppListener) {
        this.listenerWeakReference = new WeakReference<>(inAppListener);
    }

    private Bundle didClick(CTInAppNotificationButton cTInAppNotificationButton) {
        InAppListener listener = getListener();
        if (listener != null) {
            return listener.inAppNotificationDidClick(this.inAppNotification, cTInAppNotificationButton, this);
        }
        return null;
    }

    private CTInAppBaseFullFragment createContentFragment() {
        CTInAppType inAppType = this.inAppNotification.getInAppType();
        switch (AnonymousClass2.$SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType[inAppType.ordinal()]) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                showAlertDialogForInApp();
                break;
            default:
                this.config.getLogger().verbose("InAppNotificationActivity: Unhandled InApp Type: " + inAppType);
                break;
        }
        return null;
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.InAppNotificationActivity$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType;

        static {
            int[] iArr = new int[CTInAppType.values().length];
            $SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType = iArr;
            try {
                iArr[CTInAppType.CTInAppTypeCoverHTML.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType[CTInAppType.CTInAppTypeInterstitialHTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType[CTInAppType.CTInAppTypeHalfInterstitialHTML.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType[CTInAppType.CTInAppTypeCover.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType[CTInAppType.CTInAppTypeInterstitial.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType[CTInAppType.CTInAppTypeHalfInterstitial.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType[CTInAppType.CTInAppTypeCoverImageOnly.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType[CTInAppType.CTInAppTypeInterstitialImageOnly.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType[CTInAppType.CTInAppTypeHalfInterstitialImageOnly.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$clevertap$android$sdk$inapp$CTInAppType[CTInAppType.CTInAppTypeAlert.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private String getFragmentTag() {
        return this.config.getAccountId() + ":CT_INAPP_CONTENT_FRAGMENT";
    }

    private void showAlertDialogForInApp() {
        List<CTInAppNotificationButton> buttons = this.inAppNotification.getButtons();
        if (buttons.isEmpty()) {
            this.config.getLogger().debug("InAppNotificationActivity: Notification has no buttons, not showing Alert InApp");
            return;
        }
        final CTInAppNotificationButton cTInAppNotificationButton = buttons.get(0);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this, android.R.style.Theme.Material.Light.Dialog.Alert).setCancelable(false).setTitle(this.inAppNotification.getTitle()).setMessage(this.inAppNotification.getMessage()).setPositiveButton(cTInAppNotificationButton.getText(), new DialogInterface.OnClickListener() { // from class: com.clevertap.android.sdk.InAppNotificationActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.m11874x9d56a46d(cTInAppNotificationButton, dialogInterface, i);
            }
        }).create();
        if (this.inAppNotification.getButtons().size() == 2) {
            final CTInAppNotificationButton cTInAppNotificationButton2 = buttons.get(1);
            alertDialogCreate.setButton(-2, cTInAppNotificationButton2.getText(), new DialogInterface.OnClickListener() { // from class: com.clevertap.android.sdk.InAppNotificationActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.m11875x2a9155ee(cTInAppNotificationButton2, dialogInterface, i);
                }
            });
        }
        if (buttons.size() > 2) {
            final CTInAppNotificationButton cTInAppNotificationButton3 = buttons.get(2);
            alertDialogCreate.setButton(-3, cTInAppNotificationButton3.getText(), new DialogInterface.OnClickListener() { // from class: com.clevertap.android.sdk.InAppNotificationActivity$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.m11878xd2416a71(cTInAppNotificationButton3, dialogInterface, i);
                }
            });
        }
        alertDialogCreate.show();
        isAlertVisible = true;
        didShow(null);
    }

    /* JADX INFO: renamed from: lambda$showAlertDialogForInApp$0$com-clevertap-android-sdk-InAppNotificationActivity, reason: not valid java name */
    /* synthetic */ void m11874x9d56a46d(CTInAppNotificationButton cTInAppNotificationButton, DialogInterface dialogInterface, int i) {
        onAlertButtonClick(cTInAppNotificationButton, true);
    }

    /* JADX INFO: renamed from: lambda$showAlertDialogForInApp$1$com-clevertap-android-sdk-InAppNotificationActivity, reason: not valid java name */
    /* synthetic */ void m11875x2a9155ee(CTInAppNotificationButton cTInAppNotificationButton, DialogInterface dialogInterface, int i) {
        onAlertButtonClick(cTInAppNotificationButton, false);
    }

    /* JADX INFO: renamed from: lambda$showAlertDialogForInApp$2$com-clevertap-android-sdk-InAppNotificationActivity, reason: not valid java name */
    /* synthetic */ void m11876xb7cc076f(CTInAppNotificationButton cTInAppNotificationButton, DialogInterface dialogInterface, int i) {
        onAlertButtonClickLegacy(cTInAppNotificationButton);
    }

    /* JADX INFO: renamed from: lambda$showAlertDialogForInApp$3$com-clevertap-android-sdk-InAppNotificationActivity, reason: not valid java name */
    /* synthetic */ void m11877x4506b8f0(CTInAppNotificationButton cTInAppNotificationButton, DialogInterface dialogInterface, int i) {
        onAlertButtonClickLegacy(cTInAppNotificationButton);
    }

    /* JADX INFO: renamed from: lambda$showAlertDialogForInApp$4$com-clevertap-android-sdk-InAppNotificationActivity, reason: not valid java name */
    /* synthetic */ void m11878xd2416a71(CTInAppNotificationButton cTInAppNotificationButton, DialogInterface dialogInterface, int i) {
        onAlertButtonClickLegacy(cTInAppNotificationButton);
    }

    private void onAlertButtonClickLegacy(CTInAppNotificationButton cTInAppNotificationButton) {
        didDismiss(didClick(cTInAppNotificationButton));
    }

    private void onAlertButtonClick(CTInAppNotificationButton cTInAppNotificationButton, boolean z) {
        Bundle bundleDidClick = didClick(cTInAppNotificationButton);
        if (this.inAppNotification.getIsLocalInApp()) {
            if (z) {
                showPushPermissionPrompt(this.inAppNotification.getFallBackToNotificationSettings());
                return;
            }
            didCancelPermissionRequest();
        }
        CTInAppAction cTInAppAction = cTInAppNotificationButton.action;
        if (cTInAppAction != null && InAppActionType.REQUEST_FOR_PERMISSIONS == cTInAppAction.getType()) {
            showPushPermissionPrompt(cTInAppAction.getShouldFallbackToSettings());
        } else {
            didDismiss(bundleDidClick);
        }
    }

    @Override // com.clevertap.android.sdk.inapp.InAppDisplayListener
    public void hideInApp() {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        CleverTapAPI cleverTapAPIInstanceWithConfig;
        CoreState coreState;
        super.onDestroy();
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (cleverTapInstanceConfig != null && (cleverTapAPIInstanceWithConfig = CleverTapAPI.instanceWithConfig(this, cleverTapInstanceConfig)) != null && (coreState = cleverTapAPIInstanceWithConfig.getCoreState()) != null) {
            coreState.getInAppController().unregisterInAppDisplayListener();
        }
        if (isChangingConfigurations()) {
            return;
        }
        didDismiss(null, false);
    }
}
