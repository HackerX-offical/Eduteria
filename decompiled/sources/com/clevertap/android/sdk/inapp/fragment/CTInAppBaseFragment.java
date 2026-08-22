package com.clevertap.android.sdk.inapp.fragment;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.DidClickForHardPermissionListener;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.CTInAppAction;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inapp.CTInAppNotificationButton;
import com.clevertap.android.sdk.inapp.InAppActionType;
import com.clevertap.android.sdk.inapp.InAppListener;
import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import com.clevertap.android.sdk.utils.UriHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CTInAppBaseFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000 E2\u00020\u0001:\u0002EFB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010!\u001a\u00020\"H$J\b\u0010#\u001a\u00020\"H$J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0016\u0010,\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\"\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u00010+J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u000201J\u0010\u00105\u001a\u00020\"2\b\u00106\u001a\u0004\u0018\u00010+J\u0010\u00107\u001a\u00020\"2\b\u00106\u001a\u0004\u0018\u00010+J\b\u00108\u001a\u0004\u0018\u00010\u001eJ\u000e\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u001eJ\u000e\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u0011J\u000e\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\u0011J\u0006\u0010?\u001a\u00020@J\u0012\u0010A\u001a\u0004\u0018\u00010+2\u0006\u0010B\u001a\u00020CH\u0002J$\u0010D\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010+H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "inAppNotification", "Lcom/clevertap/android/sdk/inapp/CTInAppNotification;", "getInAppNotification", "()Lcom/clevertap/android/sdk/inapp/CTInAppNotification;", "setInAppNotification", "(Lcom/clevertap/android/sdk/inapp/CTInAppNotification;)V", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "getConfig", "()Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "setConfig", "(Lcom/clevertap/android/sdk/CleverTapInstanceConfig;)V", "currentOrientation", "", "getCurrentOrientation", "()I", "setCurrentOrientation", "(I)V", "closeImageView", "Lcom/clevertap/android/sdk/customviews/CloseImageView;", "getCloseImageView", "()Lcom/clevertap/android/sdk/customviews/CloseImageView;", "setCloseImageView", "(Lcom/clevertap/android/sdk/customviews/CloseImageView;)V", "listenerWeakReference", "Ljava/lang/ref/WeakReference;", "Lcom/clevertap/android/sdk/inapp/InAppListener;", "didClickForHardPermissionListener", "Lcom/clevertap/android/sdk/DidClickForHardPermissionListener;", "cleanup", "", "generateListener", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setArguments", "triggerAction", "action", "Lcom/clevertap/android/sdk/inapp/CTInAppAction;", "callToAction", "", "additionalData", "openActionUrl", "url", "didDismiss", "data", "didShow", "getListener", InAppPurchaseConstants.METHOD_SET_LISTENER, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getScaledPixels", "raw", "handleButtonClickAtIndex", FirebaseAnalytics.Param.INDEX, "resourceProvider", "Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "didClick", "button", "Lcom/clevertap/android/sdk/inapp/CTInAppNotificationButton;", "notifyActionTriggered", "Companion", "CTInAppNativeButtonClickListener", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CTInAppBaseFragment extends Fragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CloseImageView closeImageView;
    protected CleverTapInstanceConfig config;
    private int currentOrientation;
    private DidClickForHardPermissionListener didClickForHardPermissionListener;
    protected CTInAppNotification inAppNotification;
    private WeakReference<InAppListener> listenerWeakReference;

    protected abstract void cleanup();

    protected abstract void generateListener();

    /* JADX INFO: compiled from: CTInAppBaseFragment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFragment$Companion;", "", "<init>", "()V", "showOnActivity", "", "inAppFragment", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFragment;", "activity", "Landroid/app/Activity;", "inAppNotification", "Lcom/clevertap/android/sdk/inapp/CTInAppNotification;", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "logTag", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean showOnActivity(CTInAppBaseFragment inAppFragment, Activity activity, CTInAppNotification inAppNotification, CleverTapInstanceConfig config, String logTag) {
            Intrinsics.checkNotNullParameter(inAppFragment, "inAppFragment");
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(inAppNotification, "inAppNotification");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(logTag, "logTag");
            try {
                FragmentTransaction fragmentTransactionBeginTransaction = ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                inAppFragment.setArguments(inAppNotification, config);
                fragmentTransactionBeginTransaction.setCustomAnimations(R.animator.fade_in, R.animator.fade_out);
                fragmentTransactionBeginTransaction.add(R.id.content, inAppFragment, inAppNotification.getType());
                Logger.v(logTag, "calling InAppFragment " + inAppNotification.getCampaignId());
                fragmentTransactionBeginTransaction.commitNow();
                return true;
            } catch (ClassCastException e2) {
                Logger.v(logTag, "Fragment not able to render, please ensure your Activity is an instance of AppCompatActivity", e2);
                return false;
            } catch (Throwable th) {
                Logger.v(logTag, "Fragment not able to render", th);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: CTInAppBaseFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0084\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFragment$CTInAppNativeButtonClickListener;", "Landroid/view/View$OnClickListener;", "<init>", "(Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFragment;)V", "onClick", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    protected final class CTInAppNativeButtonClickListener implements View.OnClickListener {
        public CTInAppNativeButtonClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Object tag = view.getTag();
            Integer num = tag instanceof Integer ? (Integer) tag : null;
            if (num != null) {
                CTInAppBaseFragment.this.handleButtonClickAtIndex(num.intValue());
            }
        }
    }

    protected final CTInAppNotification getInAppNotification() {
        CTInAppNotification cTInAppNotification = this.inAppNotification;
        if (cTInAppNotification != null) {
            return cTInAppNotification;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inAppNotification");
        return null;
    }

    protected final void setInAppNotification(CTInAppNotification cTInAppNotification) {
        Intrinsics.checkNotNullParameter(cTInAppNotification, "<set-?>");
        this.inAppNotification = cTInAppNotification;
    }

    protected final CleverTapInstanceConfig getConfig() {
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (cleverTapInstanceConfig != null) {
            return cleverTapInstanceConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    protected final void setConfig(CleverTapInstanceConfig cleverTapInstanceConfig) {
        Intrinsics.checkNotNullParameter(cleverTapInstanceConfig, "<set-?>");
        this.config = cleverTapInstanceConfig;
    }

    protected final int getCurrentOrientation() {
        return this.currentOrientation;
    }

    protected final void setCurrentOrientation(int i) {
        this.currentOrientation = i;
    }

    protected final CloseImageView getCloseImageView() {
        return this.closeImageView;
    }

    protected final void setCloseImageView(CloseImageView closeImageView) {
        this.closeImageView = closeImageView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Parcelable parcelable = arguments.getParcelable(Constants.INAPP_KEY);
            Intrinsics.checkNotNull(parcelable);
            setInAppNotification((CTInAppNotification) parcelable);
            Parcelable parcelable2 = arguments.getParcelable("config");
            Intrinsics.checkNotNull(parcelable2);
            setConfig((CleverTapInstanceConfig) parcelable2);
            this.currentOrientation = getResources().getConfiguration().orientation;
            generateListener();
            if (context instanceof DidClickForHardPermissionListener) {
                this.didClickForHardPermissionListener = (DidClickForHardPermissionListener) context;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        didShow(null);
    }

    public final void setArguments(CTInAppNotification inAppNotification, CleverTapInstanceConfig config) {
        Intrinsics.checkNotNullParameter(inAppNotification, "inAppNotification");
        Intrinsics.checkNotNullParameter(config, "config");
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.INAPP_KEY, inAppNotification);
        bundle.putParcelable("config", config);
        setArguments(bundle);
    }

    public final void triggerAction(CTInAppAction action, String callToAction, Bundle additionalData) throws UnsupportedEncodingException {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action.getType() == InAppActionType.OPEN_URL) {
            Bundle allKeyValuePairs = UriHelper.getAllKeyValuePairs(action.getActionUrl(), false);
            String string = allKeyValuePairs.getString(Constants.KEY_C2A);
            allKeyValuePairs.remove(Constants.KEY_C2A);
            if (additionalData != null) {
                allKeyValuePairs.putAll(additionalData);
            }
            if (string != null) {
                List listSplit$default = StringsKt.split$default((CharSequence) string, new String[]{Constants.URL_PARAM_DL_SEPARATOR}, false, 0, 6, (Object) null);
                if (listSplit$default.size() == 2) {
                    try {
                        string = URLDecoder.decode((String) listSplit$default.get(0), "UTF-8");
                    } catch (Exception e2) {
                        getConfig().getLogger().debug("Error parsing c2a param", e2);
                    }
                    action = CTInAppAction.INSTANCE.createOpenUrlAction((String) listSplit$default.get(1));
                }
            }
            additionalData = allKeyValuePairs;
            if (callToAction == null) {
                callToAction = string;
            }
        }
        if (callToAction == null) {
            callToAction = "";
        }
        didDismiss(notifyActionTriggered(action, callToAction, additionalData));
    }

    public final void openActionUrl(String url) throws UnsupportedEncodingException {
        Intrinsics.checkNotNullParameter(url, "url");
        triggerAction(CTInAppAction.INSTANCE.createOpenUrlAction(url), null, null);
    }

    public final void didDismiss(Bundle data) {
        cleanup();
        InAppListener listener = getListener();
        if (listener != null) {
            listener.inAppNotificationDidDismiss(getInAppNotification(), data);
        }
    }

    public final void didShow(Bundle data) {
        InAppListener listener = getListener();
        if (listener != null) {
            listener.inAppNotificationDidShow(getInAppNotification(), data);
        }
    }

    public final InAppListener getListener() {
        WeakReference<InAppListener> weakReference = this.listenerWeakReference;
        InAppListener inAppListener = weakReference != null ? weakReference.get() : null;
        if (inAppListener == null) {
            getConfig().getLogger().verbose(getConfig().getAccountId(), "InAppListener is null for notification: " + getInAppNotification().getJsonDescription());
        }
        return inAppListener;
    }

    public final void setListener(InAppListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listenerWeakReference = new WeakReference<>(listener);
    }

    public final int getScaledPixels(int raw) {
        return (int) TypedValue.applyDimension(1, raw, getResources().getDisplayMetrics());
    }

    public final void handleButtonClickAtIndex(int index) {
        DidClickForHardPermissionListener didClickForHardPermissionListener;
        DidClickForHardPermissionListener didClickForHardPermissionListener2;
        try {
            CTInAppNotificationButton cTInAppNotificationButton = getInAppNotification().getButtons().get(index);
            Bundle bundleDidClick = didClick(cTInAppNotificationButton);
            if (getInAppNotification().getIsLocalInApp() && (didClickForHardPermissionListener2 = this.didClickForHardPermissionListener) != null) {
                if (index == 0) {
                    if (didClickForHardPermissionListener2 != null) {
                        didClickForHardPermissionListener2.didClickForHardPermissionWithFallbackSettings(getInAppNotification().getFallBackToNotificationSettings());
                        return;
                    }
                    return;
                } else if (index == 1 && didClickForHardPermissionListener2 != null) {
                    didClickForHardPermissionListener2.didCancelPermissionRequest();
                }
            }
            CTInAppAction cTInAppAction = cTInAppNotificationButton.action;
            if (cTInAppAction == null || InAppActionType.REQUEST_FOR_PERMISSIONS != cTInAppAction.getType() || (didClickForHardPermissionListener = this.didClickForHardPermissionListener) == null) {
                didDismiss(bundleDidClick);
            } else if (didClickForHardPermissionListener != null) {
                didClickForHardPermissionListener.didClickForHardPermissionWithFallbackSettings(cTInAppAction.getShouldFallbackToSettings());
            }
        } catch (Throwable th) {
            getConfig().getLogger().debug("Error handling notification button click", th);
            didDismiss(null);
        }
    }

    public final FileResourceProvider resourceProvider() {
        FileResourceProvider.Companion companion = FileResourceProvider.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return companion.getInstance(contextRequireContext, getConfig().getLogger());
    }

    private final Bundle didClick(CTInAppNotificationButton button) {
        CTInAppAction cTInAppActionCreateCloseAction = button.action;
        if (cTInAppActionCreateCloseAction == null) {
            cTInAppActionCreateCloseAction = CTInAppAction.INSTANCE.createCloseAction();
        }
        return notifyActionTriggered(cTInAppActionCreateCloseAction, button.getText(), null);
    }

    private final Bundle notifyActionTriggered(CTInAppAction action, String callToAction, Bundle additionalData) {
        InAppListener listener = getListener();
        if (listener != null) {
            return listener.inAppNotificationActionTriggered(getInAppNotification(), action, callToAction, additionalData, getActivity());
        }
        return null;
    }
}
