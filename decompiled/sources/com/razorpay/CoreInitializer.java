package com.razorpay;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.startup.Initializer;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CoreInitializer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u001a\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u000b0\nH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\r"}, d2 = {"Lcom/razorpay/CoreInitializer;", "Landroidx/startup/Initializer;", "", "()V", "create", "context", "Landroid/content/Context;", "deferCoreInitUntilFirstActivity", "appContext", "dependencies", "", "Ljava/lang/Class;", "initGPayInABoxIfAvailable", "checkout-otpelf-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CoreInitializer implements Initializer<Unit> {
    @Override // androidx.startup.Initializer
    public final /* bridge */ /* synthetic */ Unit create(Context context) {
        create2(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public final void create2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final Context applicationContext = context.getApplicationContext();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.razorpay.CoreInitializer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CoreInitializer.m12322create$lambda1(this.f$0, applicationContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: create$lambda-1, reason: not valid java name */
    public static final void m12322create$lambda1(final CoreInitializer this$0, final Context appContext) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new Thread(new Runnable() { // from class: com.razorpay.CoreInitializer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CoreInitializer.m12323create$lambda1$lambda0(this.f$0, appContext);
            }
        }).start();
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        this$0.deferCoreInitUntilFirstActivity(appContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: create$lambda-1$lambda-0, reason: not valid java name */
    public static final void m12323create$lambda1$lambda0(CoreInitializer this$0, Context appContext) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
            this$0.initGPayInABoxIfAvailable(appContext);
        } catch (Throwable th) {
            Logger.e("Error initializing GPayInABox", th);
        }
    }

    @Override // androidx.startup.Initializer
    public final List<Class<? extends Initializer<?>>> dependencies() {
        return new ArrayList();
    }

    private final void deferCoreInitUntilFirstActivity(Context appContext) {
        Application application = appContext instanceof Application ? (Application) appContext : null;
        if (application == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new CoreInitializer$deferCoreInitUntilFirstActivity$callbacks$1(new boolean[]{false}, application, appContext));
    }

    private final void initGPayInABoxIfAvailable(Context context) {
        Object next;
        String str;
        Object objM12393constructorimpl;
        Class<?> clsLoadClass;
        Constructor<?> declaredConstructor;
        Set<Map.Entry<String, String>> setEntrySet = BaseUtils.getAllPluginsFromManifest(context).entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "pluginsMap.entries");
        Iterator<T> it = setEntrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Map.Entry entry = (Map.Entry) next;
            Intrinsics.checkNotNullExpressionValue(entry, "(key, _)");
            String key = (String) entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            if (StringsKt.contains((CharSequence) key, (CharSequence) "gpay_in_a_box", true)) {
                break;
            }
        }
        Map.Entry entry2 = (Map.Entry) next;
        if (entry2 == null || (str = (String) entry2.getValue()) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            ClassLoader classLoader = RzpPlugin.class.getClassLoader();
            Object objNewInstance = (classLoader == null || (clsLoadClass = classLoader.loadClass(str)) == null || (declaredConstructor = clsLoadClass.getDeclaredConstructor(new Class[0])) == null) ? null : declaredConstructor.newInstance(new Object[0]);
            objM12393constructorimpl = Result.m12393constructorimpl(objNewInstance instanceof RzpGPayInABoxExternalPlugin ? (RzpGPayInABoxExternalPlugin) objNewInstance : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12393constructorimpl = Result.m12393constructorimpl(ResultKt.createFailure(th));
        }
        RzpGPayInABoxExternalPlugin rzpGPayInABoxExternalPlugin = (RzpGPayInABoxExternalPlugin) (Result.m12399isFailureimpl(objM12393constructorimpl) ? null : objM12393constructorimpl);
        if (rzpGPayInABoxExternalPlugin != null) {
            rzpGPayInABoxExternalPlugin.initializePaymentMethods(context);
        }
    }
}
