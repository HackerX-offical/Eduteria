package androidx.window.area.utils;

import android.view.Window;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PresentationWindowCompatUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Landroidx/window/area/utils/PresentationWindowCompatUtils;", "", "<init>", "()V", "getWindowBeforeVendorApiLevel4", "Landroid/view/Window;", "extensionPresentation", "Landroidx/window/extensions/area/ExtensionWindowAreaPresentation;", "getWindowMethod", "Ljava/lang/reflect/Method;", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PresentationWindowCompatUtils {
    public static final PresentationWindowCompatUtils INSTANCE = new PresentationWindowCompatUtils();

    private PresentationWindowCompatUtils() {
    }

    public final Window getWindowBeforeVendorApiLevel4(ExtensionWindowAreaPresentation extensionPresentation) {
        Intrinsics.checkNotNullParameter(extensionPresentation, "extensionPresentation");
        Method windowMethod = getWindowMethod(extensionPresentation);
        if (windowMethod == null) {
            return null;
        }
        return (Window) windowMethod.invoke(extensionPresentation, new Object[0]);
    }

    private final Method getWindowMethod(ExtensionWindowAreaPresentation extensionPresentation) {
        Object obj;
        Method[] methods = extensionPresentation.getClass().getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "getMethods(...)");
        Method[] methodArr = methods;
        int length = methodArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Method method = methodArr[i];
            Method method2 = method;
            if (Intrinsics.areEqual(method2 != null ? method2.getName() : null, "getWindow") && Intrinsics.areEqual(method2.getReturnType(), Window.class)) {
                obj = method;
                break;
            }
            i++;
        }
        return (Method) obj;
    }
}
