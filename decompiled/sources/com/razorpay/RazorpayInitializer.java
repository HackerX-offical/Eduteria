package com.razorpay;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.startup.Initializer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RazorpayInitializer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\t0\bH\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"Lcom/razorpay/RazorpayInitializer;", "Landroidx/startup/Initializer;", "", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "registerWebViewWarmup", "appContext", "checkout-otpelf-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RazorpayInitializer implements Initializer<Unit> {
    @Override // androidx.startup.Initializer
    public final /* bridge */ /* synthetic */ Unit create(Context context) {
        create2(context);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
    public final void create2(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 34) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.razorpay.RazorpayInitializer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    RazorpayInitializer.m12337create$lambda0(this.f$0, context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: create$lambda-0, reason: not valid java name */
    public static final void m12337create$lambda0(RazorpayInitializer this$0, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this$0.registerWebViewWarmup(applicationContext);
    }

    @Override // androidx.startup.Initializer
    public final List<Class<? extends Initializer<?>>> dependencies() {
        return new ArrayList();
    }

    private final void registerWebViewWarmup(Context appContext) {
        Application application = appContext instanceof Application ? (Application) appContext : null;
        if (application == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new RazorpayInitializer$registerWebViewWarmup$callbacks$1(new boolean[]{false}, application, appContext, new Handler(Looper.getMainLooper())));
    }
}
