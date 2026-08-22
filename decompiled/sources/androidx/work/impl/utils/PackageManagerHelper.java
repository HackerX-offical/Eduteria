package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: loaded from: classes4.dex */
public class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    private static boolean isComponentEnabled(int setting, boolean defaults) {
        return setting == 0 ? defaults : setting == 1;
    }

    private PackageManagerHelper() {
    }

    public static void setComponentEnabled(Context context, Class<?> klazz, boolean enabled) {
        String str = StreamManagement.Enabled.ELEMENT;
        try {
            if (enabled == isComponentEnabled(getComponentEnabledSetting(context, klazz.getName()), false)) {
                Logger.get().debug(TAG, "Skipping component enablement for " + klazz.getName());
            } else {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, klazz.getName()), enabled ? 1 : 2, 1);
                Logger.get().debug(TAG, klazz.getName() + " " + (enabled ? StreamManagement.Enabled.ELEMENT : "disabled"));
            }
        } catch (Exception e2) {
            Logger logger = Logger.get();
            String str2 = TAG;
            StringBuilder sbAppend = new StringBuilder().append(klazz.getName()).append("could not be ");
            if (!enabled) {
                str = "disabled";
            }
            logger.debug(str2, sbAppend.append(str).toString(), e2);
        }
    }

    public static boolean isComponentExplicitlyEnabled(Context context, Class<?> klazz) {
        return isComponentEnabled(getComponentEnabledSetting(context, klazz.getName()), false);
    }

    public static boolean isComponentExplicitlyEnabled(Context context, String className) {
        return getComponentEnabledSetting(context, className) == 1;
    }

    private static int getComponentEnabledSetting(Context context, String className) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, className));
    }
}
