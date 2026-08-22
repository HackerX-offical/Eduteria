package com.microsoft.clarity.h;

import android.app.Activity;
import com.microsoft.clarity.models.telemetry.ErrorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface e extends d {

    public static final class a {
        public static void a(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public static void a(Exception exception, ErrorType errorType) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            Intrinsics.checkNotNullParameter(errorType, "errorType");
        }

        public static void b(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public static void c(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    @Override // com.microsoft.clarity.h.d
    void a(Exception exc, ErrorType errorType);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);
}
