package com.appnew.android.Utils.shortcuts;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.LiveClass.Activity.LiveClassActivity;
import com.appnew.android.LiveTest.Activity.LivetestActivity;
import com.appnew.android.Login.Activity.SignInActivity;
import com.appnew.android.Login.Activity.SplashScreen;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme3;
import com.appnew.android.Theme.DashboardActivityTheme4;
import com.appnew.android.Theme.DashboardActivityTheme5;
import com.appnew.android.Utils.Const;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.eduteria.app.app.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Shortsuts.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ=\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0010J5\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0011J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¨\u0006\u0017"}, d2 = {"Lcom/appnew/android/Utils/shortcuts/Shortsuts;", "", "<init>", "()V", "addShortscuts", "Landroidx/core/content/pm/ShortcutInfoCompat;", "context", "Landroid/content/Context;", "name", "", "resIcon", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "id", "", "(Landroid/content/Context;Ljava/lang/String;I[Landroid/content/Intent;Ljava/lang/String;)Landroidx/core/content/pm/ShortcutInfoCompat;", "(Landroid/content/Context;Ljava/lang/String;[Landroid/content/Intent;Ljava/lang/String;)Landroidx/core/content/pm/ShortcutInfoCompat;", "createShortcuts", "", "updateShortcuts", "getDashboardIntent", "activity", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Shortsuts {
    public static final int $stable = 0;
    public static final Shortsuts INSTANCE = new Shortsuts();

    private Shortsuts() {
    }

    public final ShortcutInfoCompat addShortscuts(Context context, String name, int resIcon, Intent intent, String id) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(id);
        String str = name;
        ShortcutInfoCompat shortcutInfoCompatBuild = new ShortcutInfoCompat.Builder(context, id).setShortLabel(str).setLongLabel(str).setIcon(IconCompat.createWithResource(context, resIcon)).setIntent(intent).build();
        Intrinsics.checkNotNullExpressionValue(shortcutInfoCompatBuild, "build(...)");
        return shortcutInfoCompatBuild;
    }

    public final ShortcutInfoCompat addShortscuts(Context context, String name, int resIcon, Intent[] intent, String id) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(id);
        String str = name;
        ShortcutInfoCompat shortcutInfoCompatBuild = new ShortcutInfoCompat.Builder(context, id).setShortLabel(str).setLongLabel(str).setIcon(IconCompat.createWithResource(context, resIcon)).setIntents(intent).build();
        Intrinsics.checkNotNullExpressionValue(shortcutInfoCompatBuild, "build(...)");
        return shortcutInfoCompatBuild;
    }

    public final ShortcutInfoCompat addShortscuts(Context context, String name, Intent[] intent, String id) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(id);
        String str = name;
        ShortcutInfoCompat shortcutInfoCompatBuild = new ShortcutInfoCompat.Builder(context, id).setShortLabel(str).setLongLabel(str).setIntents(intent).build();
        Intrinsics.checkNotNullExpressionValue(shortcutInfoCompatBuild, "build(...)");
        return shortcutInfoCompatBuild;
    }

    public final ShortcutInfoCompat addShortscuts(Context context, String name, Intent intent, String id) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(id);
        String str = name;
        ShortcutInfoCompat shortcutInfoCompatBuild = new ShortcutInfoCompat.Builder(context, id).setShortLabel(str).setLongLabel(str).setIntent(intent).build();
        Intrinsics.checkNotNullExpressionValue(shortcutInfoCompatBuild, "build(...)");
        return shortcutInfoCompatBuild;
    }

    public final void createShortcuts(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent dashboardIntent = getDashboardIntent(context);
        Intent[] intentArr = {dashboardIntent, new Intent("android.intent.action.VIEW", null, context, DownloadActivity.class).addFlags(32768)};
        Intent[] intentArr2 = {dashboardIntent, new Intent("android.intent.action.VIEW", null, context, LiveClassActivity.class).addFlags(32768)};
        Intent[] intentArr3 = {dashboardIntent, new Intent("android.intent.action.VIEW", null, context, LivetestActivity.class).addFlags(32768)};
        Intent[] intentArr4 = {dashboardIntent, new Intent("android.intent.action.VIEW", null, context, MyLibraryActivty.class).addFlags(32768)};
        ShortcutManagerCompat.pushDynamicShortcut(context, addShortscuts(context, "Downloads", R.mipmap.ic_downloads, intentArr, "Downloads"));
        ShortcutManagerCompat.pushDynamicShortcut(context, addShortscuts(context, "LiveClass", R.mipmap.live_classes, intentArr2, "LiveClass"));
        ShortcutManagerCompat.pushDynamicShortcut(context, addShortscuts(context, "LiveTest", R.mipmap.live_tests, intentArr3, "LiveTest"));
        ShortcutManagerCompat.pushDynamicShortcut(context, addShortscuts(context, "MyLibrary", R.mipmap.my_library, intentArr4, "MyLibrary"));
    }

    public final void updateShortcuts(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.intent.action.VIEW", null, context, SplashScreen.class);
        ShortcutManagerCompat.updateShortcuts(context, CollectionsKt.listOf((Object[]) new ShortcutInfoCompat[]{addShortscuts(context, "Downloads", R.mipmap.ic_downloads, intent, "Downloads"), addShortscuts(context, "LiveClass", R.mipmap.live_classes, intent, "LiveClass"), addShortscuts(context, "LiveTest", R.mipmap.live_tests, intent, "LiveTest"), addShortscuts(context, "MyLibrary", R.mipmap.my_library, intent, "MyLibrary")}));
    }

    private final Intent getDashboardIntent(Context activity) {
        Intent intent;
        if (!StringsKt.equals("1", "1", true)) {
            if (!StringsKt.equals("1", "2", true)) {
                if (!StringsKt.equals("1", "3", true)) {
                    if (!StringsKt.equals("1", "4", true)) {
                        if (StringsKt.equals("1", "5", true)) {
                            intent = new Intent("android.intent.action.VIEW", null, activity, DashboardActivityTheme5.class);
                        } else {
                            Intent intent2 = new Intent("android.intent.action.VIEW", null, activity, SignInActivity.class);
                            intent2.putExtra("type", Const.SIGNIN);
                            intent2.putExtra(Const.OPEN_WITH, "user");
                            Intrinsics.checkNotNull(intent2.putExtra(Const.SOCIAL_TYPE, "1"));
                            intent = intent2;
                        }
                    } else {
                        intent = new Intent("android.intent.action.VIEW", null, activity, DashboardActivityTheme4.class);
                    }
                } else {
                    intent = new Intent("android.intent.action.VIEW", null, activity, DashboardActivityTheme3.class);
                }
            } else {
                intent = new Intent("android.intent.action.VIEW", null, activity, DashboardActivityTheme2.class);
            }
        } else {
            intent = new Intent("android.intent.action.VIEW", null, activity, DashboardActivityTheme1.class);
        }
        intent.addFlags(32768);
        return intent;
    }
}
