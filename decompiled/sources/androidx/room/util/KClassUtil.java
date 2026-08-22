package androidx.room.util;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.dynamiclinks.DynamicLink;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: KClassUtil.jvmAndroid.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"findAndInstantiateDatabaseImpl", ExifInterface.GPS_DIRECTION_TRUE, "C", "klass", "Ljava/lang/Class;", DynamicLink.Builder.KEY_SUFFIX, "", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "room-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KClassUtil {
    public static /* synthetic */ Object findAndInstantiateDatabaseImpl$default(Class cls, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "_Impl";
        }
        return findAndInstantiateDatabaseImpl(cls, str);
    }

    public static final <T, C> T findAndInstantiateDatabaseImpl(Class<C> klass, String suffix) {
        String name;
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        Package r0 = klass.getPackage();
        if (r0 == null || (name = r0.getName()) == null) {
            name = "";
        }
        String canonicalName = klass.getCanonicalName();
        Intrinsics.checkNotNull(canonicalName);
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
            Intrinsics.checkNotNullExpressionValue(canonicalName, "substring(...)");
        }
        String str = StringsKt.replace$default(canonicalName, '.', '_', false, 4, (Object) null) + suffix;
        try {
            Class<?> cls = Class.forName(name.length() == 0 ? str : name + '.' + str, true, klass.getClassLoader());
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.util.KClassUtil.findAndInstantiateDatabaseImpl>");
            return (T) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("Cannot find implementation for " + klass.getCanonicalName() + ". " + str + " does not exist. Is Room annotation processor correctly configured?", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Cannot access the constructor " + klass.getCanonicalName(), e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException("Failed to create an instance of " + klass.getCanonicalName(), e4);
        }
    }
}
