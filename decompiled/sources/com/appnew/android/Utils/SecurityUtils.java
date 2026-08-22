package com.appnew.android.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import com.eduteria.app.app.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SecurityUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/appnew/android/Utils/SecurityUtils;", "", "<init>", "()V", "displayWatcherRegistered", "", "isBlockingInProgress", "startDisplayWatcher", "", "context", "Landroid/content/Context;", "callback", "Lcom/appnew/android/Utils/SecurityUtils$SecurityCallback;", "checkDisplayAndNotify", "displayId", "", "checkSecurityAsync", "activity", "Landroid/app/Activity;", "notifyRisk", "reason", "", "isCasting", "isCastingDisplayName", "name", "isVirtualSystemOverlay", "display", "Landroid/view/Display;", "getDisplayTypeViaReflection", "SecurityCallback", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecurityUtils {
    private static boolean displayWatcherRegistered;
    private static boolean isBlockingInProgress;
    public static final SecurityUtils INSTANCE = new SecurityUtils();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SecurityUtils.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/appnew/android/Utils/SecurityUtils$SecurityCallback;", "", "onSecurityRiskDetected", "", "reason", "", "onSafe", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SecurityCallback {
        void onSafe();

        void onSecurityRiskDetected(String reason);
    }

    private SecurityUtils() {
    }

    public final void startDisplayWatcher(Context context, final SecurityCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (displayWatcherRegistered) {
            return;
        }
        displayWatcherRegistered = true;
        final Context applicationContext = context.getApplicationContext();
        Object systemService = applicationContext.getSystemService("display");
        final DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
        if (displayManager == null) {
            return;
        }
        displayManager.registerDisplayListener(new DisplayManager.DisplayListener() { // from class: com.appnew.android.Utils.SecurityUtils.startDisplayWatcher.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int displayId) {
                SecurityUtils securityUtils = SecurityUtils.INSTANCE;
                Context context2 = applicationContext;
                Intrinsics.checkNotNull(context2);
                securityUtils.checkDisplayAndNotify(context2, displayId, callback);
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int displayId) {
                Display display;
                if (displayId == 0 || (display = displayManager.getDisplay(displayId)) == null || SecurityUtils.INSTANCE.isVirtualSystemOverlay(display)) {
                    return;
                }
                SecurityUtils securityUtils = SecurityUtils.INSTANCE;
                Context context2 = applicationContext;
                Intrinsics.checkNotNull(context2);
                securityUtils.checkDisplayAndNotify(context2, displayId, callback);
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int displayId) {
                Display[] displays;
                Object systemService2 = applicationContext.getSystemService("display");
                DisplayManager displayManager2 = systemService2 instanceof DisplayManager ? (DisplayManager) systemService2 : null;
                if (displayManager2 == null || (displays = displayManager2.getDisplays()) == null || displays.length != 1) {
                    return;
                }
                SecurityUtils securityUtils = SecurityUtils.INSTANCE;
                SecurityUtils.isBlockingInProgress = false;
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkDisplayAndNotify(Context context, int displayId, SecurityCallback callback) {
        if (displayId == 0 || isBlockingInProgress || !isCasting(context)) {
            return;
        }
        isBlockingInProgress = true;
        notifyRisk(callback, "Screen casting / wireless display detected. Please disable it.");
    }

    public final void checkSecurityAsync(final Activity activity, final SecurityCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Context applicationContext = activity.getApplicationContext();
        new Thread(new Runnable() { // from class: com.appnew.android.Utils.SecurityUtils$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SecurityUtils.checkSecurityAsync$lambda$1(applicationContext, callback, activity);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSecurityAsync$lambda$1(Context context, final SecurityCallback securityCallback, Activity activity) {
        List<ApplicationInfo> listEmptyList;
        String strBluestack;
        String str;
        String str2;
        PackageManager packageManager = context.getPackageManager();
        try {
            listEmptyList = packageManager.getInstalledApplications(128);
            Intrinsics.checkNotNull(listEmptyList);
        } catch (Exception unused) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Set of = SetsKt.setOf((Object[]) new String[]{"de.robv.android.xposed", "de.robv.android.xposed.installer", "com.liof.screenrecfree", "com.hecorat.screenrecorder.free", "vidma.screenrecorder.videorecorder.videoeditor.pro", "me.weishu.exp", "io.virtualapp", "com.topjohnwu.magisk"});
        Iterator<ApplicationInfo> it = listEmptyList.iterator();
        while (true) {
            if (it.hasNext()) {
                ApplicationInfo next = it.next();
                try {
                    str = next.packageName;
                    CharSequence applicationLabel = packageManager.getApplicationLabel(next);
                    str2 = applicationLabel instanceof String ? (String) applicationLabel : null;
                    if (str2 == null) {
                        str2 = "";
                    }
                } catch (Exception unused2) {
                }
                if (of.contains(str) || StringsKt.equals(str2, "VirtualXposed", true)) {
                    SecurityUtils securityUtils = INSTANCE;
                    String string = context.getString(R.string.screen_capturing_msg);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    securityUtils.notifyRisk(securityCallback, string);
                    return;
                }
            } else {
                String HOST = Build.HOST;
                Intrinsics.checkNotNullExpressionValue(HOST, "HOST");
                if (!StringsKt.startsWith$default(HOST, "Build", false, 2, (Object) null) && !Intrinsics.areEqual(Build.PRODUCT, "google_sdk")) {
                    String MODEL = Build.MODEL;
                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                    if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Emulator", false, 2, (Object) null)) {
                        String HARDWARE = Build.HARDWARE;
                        Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
                        if (!StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "BlueStack", false, 2, (Object) null)) {
                            String MANUFACTURER = Build.MANUFACTURER;
                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                            if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null) && !EmulatorDetector.isEmulator(context)) {
                                if (!TextUtils.isEmpty(Helper.bluestack()) && (strBluestack = Helper.bluestack()) != null && StringsKt.contains$default((CharSequence) strBluestack, (CharSequence) "bluestack", false, 2, (Object) null)) {
                                    INSTANCE.notifyRisk(securityCallback, "Physical device requirement validation failed.");
                                    return;
                                }
                                if (RootUtil.isDeviceRooted() || RootUtil.detectFullRoot(context)) {
                                    INSTANCE.notifyRisk(securityCallback, "Rooted Device Detected");
                                    return;
                                }
                                Activity activity2 = activity;
                                if (RootUtil.check_proxy(activity2)) {
                                    INSTANCE.notifyRisk(securityCallback, "VPN or Proxy Detected");
                                    return;
                                }
                                if (!Helper.isNetworkConnected(context)) {
                                    SecurityUtils securityUtils2 = INSTANCE;
                                    String string2 = context.getString(R.string.no_internet_connection);
                                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                    securityUtils2.notifyRisk(securityCallback, string2);
                                    return;
                                }
                                SecurityUtils securityUtils3 = INSTANCE;
                                if (securityUtils3.isCasting(activity2)) {
                                    securityUtils3.notifyRisk(securityCallback, "Screen casting / wireless display detected. Please disable it.");
                                    return;
                                } else {
                                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appnew.android.Utils.SecurityUtils$$ExternalSyntheticLambda0
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            securityCallback.onSafe();
                                        }
                                    });
                                    return;
                                }
                            }
                        }
                    }
                }
                INSTANCE.notifyRisk(securityCallback, "Emulator Detected");
                return;
            }
        }
    }

    private final void notifyRisk(final SecurityCallback callback, final String reason) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appnew.android.Utils.SecurityUtils$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                callback.onSecurityRiskDetected(reason);
            }
        });
    }

    private final boolean isCasting(Context context) {
        Object systemService = context.getSystemService("display");
        DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
        if (displayManager == null) {
            return false;
        }
        Iterator it = ArrayIteratorKt.iterator(displayManager.getDisplays());
        while (it.hasNext()) {
            Display display = (Display) it.next();
            if (display.getDisplayId() != 0) {
                Intrinsics.checkNotNull(display);
                if (!isVirtualSystemOverlay(display)) {
                    int flags = display.getFlags();
                    boolean z = (flags & 8) != 0;
                    boolean z2 = (flags & 4) != 0;
                    int displayTypeViaReflection = getDisplayTypeViaReflection(display);
                    if (displayTypeViaReflection != 2 && displayTypeViaReflection != 3) {
                        if (z && !z2) {
                            String name = display.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            if (isCastingDisplayName(name)) {
                            }
                        }
                    }
                    return true;
                }
                continue;
            }
        }
        return false;
    }

    private final boolean isCastingDisplayName(String name) {
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"miracast", "wfd", "wireless", "cast", "hdmi", "screen mirroring", "remote display", "virtual display"});
        if ((listListOf instanceof Collection) && listListOf.isEmpty()) {
            return false;
        }
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) it.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isVirtualSystemOverlay(Display display) {
        int flags = display.getFlags();
        boolean z = (flags & 8) != 0;
        return getDisplayTypeViaReflection(display) == 4 ? !z : ((flags & 16) == 0 || z) ? false : true;
    }

    private final int getDisplayTypeViaReflection(Display display) {
        try {
            Object objInvoke = display.getClass().getMethod("getType", new Class[0]).invoke(display, new Object[0]);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            return ((Integer) objInvoke).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }
}
