package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavDeepLink;
import androidx.navigation.serialization.RouteSerializerKt;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializersKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: NavDestination.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 `2\u00020\u0001:\u0003_`aB\u0017\b\u0016\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\nJ\u000e\u00106\u001a\u0002032\u0006\u00107\u001a\u00020\u0014J\u000e\u00106\u001a\u0002032\u0006\u00108\u001a\u00020\u0006J\u0014\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:H\u0007J\u0014\u0010<\u001a\u00020=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0000H\u0007J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u001a\u0010B\u001a\u0004\u0018\u00010\u00062\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010:J\u0012\u0010F\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u0018\u001a\u00020\u0019J\u0010\u0010G\u001a\u00020@2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010G\u001a\u00020@2\u0006\u0010J\u001a\u00020KH\u0016J.\u0010L\u001a\u00020@2\u0006\u0010H\u001a\u00020\u00142\b\u0010M\u001a\u0004\u0018\u00010I2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u000fH\u0002J\u001a\u0010N\u001a\u00020@2\u0006\u0010-\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010:H\u0007J\b\u0010O\u001a\u00020\u0019H\u0016J\u0012\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u00020KH\u0017J\u0012\u0010S\u001a\u0004\u0018\u00010Q2\u0006\u0010-\u001a\u00020\u0006H\u0007J\u0018\u0010T\u001a\u0002032\u0006\u0010C\u001a\u00020D2\u0006\u0010U\u001a\u00020VH\u0017J\u0018\u0010W\u001a\u0002032\b\b\u0001\u0010X\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020\rJ\u001a\u0010W\u001a\u0002032\b\b\u0001\u0010X\u001a\u00020\u00192\b\b\u0001\u0010Z\u001a\u00020\u0019J\u0010\u0010[\u001a\u0002032\b\b\u0001\u0010X\u001a\u00020\u0019J\u000e\u0010\\\u001a\u0002032\u0006\u00104\u001a\u00020\u0006J\b\u0010]\u001a\u00020@H\u0017J\b\u0010^\u001a\u00020\u0006H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00068WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u0018\u001a\u00020\u00198G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010'@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010-\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0007R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Landroidx/navigation/NavDestination;", "", "navigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "navigatorName", "", "(Ljava/lang/String;)V", "_arguments", "", "Landroidx/navigation/NavArgument;", Constants.KEY_ACTIONS, "Landroidx/collection/SparseArrayCompat;", "Landroidx/navigation/NavAction;", "arguments", "", "getArguments", "()Ljava/util/Map;", "deepLinks", "", "Landroidx/navigation/NavDeepLink;", "displayName", "getDisplayName", "()Ljava/lang/String;", "id", "", "getId", "()I", "setId", "(I)V", "idName", "label", "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "getNavigatorName", "<set-?>", "Landroidx/navigation/NavGraph;", Message.Thread.PARENT_ATTRIBUTE_NAME, "getParent", "()Landroidx/navigation/NavGraph;", "setParent", "(Landroidx/navigation/NavGraph;)V", "route", "getRoute", "setRoute", "routeDeepLink", "Lkotlin/Lazy;", "addArgument", "", "argumentName", "argument", "addDeepLink", "navDeepLink", "uriPattern", "addInDefaultArgs", "Landroid/os/Bundle;", "args", "buildDeepLinkIds", "", "previousDestination", "equals", "", "other", "fillInLabel", "context", "Landroid/content/Context;", "bundle", "getAction", "hasDeepLink", SDKConstants.PARAM_DEEP_LINK, "Landroid/net/Uri;", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "hasRequiredArguments", "uri", "hasRoute", "hashCode", "matchDeepLink", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "matchRoute", "onInflate", "attrs", "Landroid/util/AttributeSet;", "putAction", "actionId", "action", "destId", "removeAction", "removeArgument", "supportsActions", InAppPurchaseConstants.METHOD_TO_STRING, "ClassType", "Companion", "DeepLinkMatch", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class NavDestination {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Class<?>> classes = new LinkedHashMap();
    private Map<String, NavArgument> _arguments;
    private final SparseArrayCompat<NavAction> actions;
    private final List<NavDeepLink> deepLinks;
    private int id;
    private String idName;
    private CharSequence label;
    private final String navigatorName;
    private NavGraph parent;
    private String route;
    private Lazy<NavDeepLink> routeDeepLink;

    /* JADX INFO: compiled from: NavDestination.kt */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/navigation/NavDestination$ClassType;", "", "value", "Lkotlin/reflect/KClass;", "()Ljava/lang/Class;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface ClassType {
        Class<?> value();
    }

    @JvmStatic
    public static final String getDisplayName(Context context, int i) {
        return INSTANCE.getDisplayName(context, i);
    }

    public static final Sequence<NavDestination> getHierarchy(NavDestination navDestination) {
        return INSTANCE.getHierarchy(navDestination);
    }

    @JvmStatic
    public static final <T> boolean hasRoute(NavDestination navDestination, KClass<T> kClass) {
        return INSTANCE.hasRoute(navDestination, kClass);
    }

    @JvmStatic
    protected static final <C> Class<? extends C> parseClassFromName(Context context, String str, Class<? extends C> cls) {
        return INSTANCE.parseClassFromName(context, str, cls);
    }

    @JvmStatic
    public static final <C> Class<? extends C> parseClassFromNameInternal(Context context, String str, Class<? extends C> cls) {
        return INSTANCE.parseClassFromNameInternal(context, str, cls);
    }

    public final int[] buildDeepLinkIds() {
        return buildDeepLinkIds$default(this, null, 1, null);
    }

    public boolean supportsActions() {
        return true;
    }

    public NavDestination(String navigatorName) {
        Intrinsics.checkNotNullParameter(navigatorName, "navigatorName");
        this.navigatorName = navigatorName;
        this.deepLinks = new ArrayList();
        this.actions = new SparseArrayCompat<>(0, 1, null);
        this._arguments = new LinkedHashMap();
    }

    public final String getNavigatorName() {
        return this.navigatorName;
    }

    /* JADX INFO: compiled from: NavDestination.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/navigation/NavDestination$DeepLinkMatch;", "", "destination", "Landroidx/navigation/NavDestination;", "matchingArgs", "Landroid/os/Bundle;", "isExactDeepLink", "", "matchingPathSegments", "", "hasMatchingAction", "mimeTypeMatchLevel", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZIZI)V", "getDestination", "()Landroidx/navigation/NavDestination;", "getMatchingArgs", "()Landroid/os/Bundle;", "compareTo", "other", "hasMatchingArgs", "arguments", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;
        private final Bundle matchingArgs;
        private final int matchingPathSegments;
        private final int mimeTypeMatchLevel;

        public DeepLinkMatch(NavDestination destination, Bundle bundle, boolean z, int i, boolean z2, int i2) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            this.destination = destination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z;
            this.matchingPathSegments = i;
            this.hasMatchingAction = z2;
            this.mimeTypeMatchLevel = i2;
        }

        public final NavDestination getDestination() {
            return this.destination;
        }

        public final Bundle getMatchingArgs() {
            return this.matchingArgs;
        }

        @Override // java.lang.Comparable
        public int compareTo(DeepLinkMatch other) {
            Intrinsics.checkNotNullParameter(other, "other");
            boolean z = this.isExactDeepLink;
            if (z && !other.isExactDeepLink) {
                return 1;
            }
            if (!z && other.isExactDeepLink) {
                return -1;
            }
            int i = this.matchingPathSegments - other.matchingPathSegments;
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            Bundle bundle = this.matchingArgs;
            if (bundle != null && other.matchingArgs == null) {
                return 1;
            }
            if (bundle == null && other.matchingArgs != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size();
                Bundle bundle2 = other.matchingArgs;
                Intrinsics.checkNotNull(bundle2);
                int size2 = size - bundle2.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z2 = this.hasMatchingAction;
            if (z2 && !other.hasMatchingAction) {
                return 1;
            }
            if (z2 || !other.hasMatchingAction) {
                return this.mimeTypeMatchLevel - other.mimeTypeMatchLevel;
            }
            return -1;
        }

        public final boolean hasMatchingArgs(Bundle arguments) {
            Bundle bundle;
            Object obj;
            if (arguments == null || (bundle = this.matchingArgs) == null) {
                return false;
            }
            Set<String> setKeySet = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "matchingArgs.keySet()");
            for (String key : setKeySet) {
                if (!arguments.containsKey(key)) {
                    return false;
                }
                NavArgument navArgument = (NavArgument) this.destination._arguments.get(key);
                Object obj2 = null;
                NavType<Object> type = navArgument != null ? navArgument.getType() : null;
                if (type != null) {
                    Bundle bundle2 = this.matchingArgs;
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    obj = type.get(bundle2, key);
                } else {
                    obj = null;
                }
                if (type != null) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    obj2 = type.get(arguments, key);
                }
                if (type != null && !type.valueEquals(obj, obj2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public final NavGraph getParent() {
        return this.parent;
    }

    public final void setParent(NavGraph navGraph) {
        this.parent = navGraph;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
    }

    public final Map<String, NavArgument> getArguments() {
        return MapsKt.toMap(this._arguments);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.INSTANCE.getNameForNavigator$navigation_common_release(navigator.getClass()));
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }

    public void onInflate(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.Navigator);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainAttributes, "context.resources.obtain…s, R.styleable.Navigator)");
        setRoute(typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.Navigator_route));
        if (typedArrayObtainAttributes.hasValue(androidx.navigation.common.R.styleable.Navigator_android_id)) {
            setId(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.Navigator_android_id, 0));
            this.idName = INSTANCE.getDisplayName(context, this.id);
        }
        this.label = typedArrayObtainAttributes.getText(androidx.navigation.common.R.styleable.Navigator_android_label);
        Unit unit = Unit.INSTANCE;
        typedArrayObtainAttributes.recycle();
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
        this.idName = null;
    }

    public final String getRoute() {
        return this.route;
    }

    public final void setRoute(String str) {
        if (str == null) {
            setId(0);
        } else {
            if (StringsKt.isBlank(str)) {
                throw new IllegalArgumentException("Cannot have an empty route".toString());
            }
            final String strCreateRoute = INSTANCE.createRoute(str);
            final NavDeepLink navDeepLinkBuild = new NavDeepLink.Builder().setUriPattern(strCreateRoute).build();
            List<String> listMissingRequiredArguments = NavArgumentKt.missingRequiredArguments(this._arguments, new Function1<String, Boolean>() { // from class: androidx.navigation.NavDestination$route$missingRequiredArguments$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String key) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    return Boolean.valueOf(!navDeepLinkBuild.getArgumentsNames$navigation_common_release().contains(key));
                }
            });
            if (!listMissingRequiredArguments.isEmpty()) {
                throw new IllegalArgumentException(("Cannot set route \"" + str + "\" for destination " + this + ". Following required arguments are missing: " + listMissingRequiredArguments).toString());
            }
            this.routeDeepLink = LazyKt.lazy(new Function0<NavDeepLink>() { // from class: androidx.navigation.NavDestination$route$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final NavDeepLink invoke() {
                    return new NavDeepLink.Builder().setUriPattern(strCreateRoute).build();
                }
            });
            setId(strCreateRoute.hashCode());
        }
        this.route = str;
    }

    public String getDisplayName() {
        String str = this.idName;
        return str == null ? String.valueOf(this.id) : str;
    }

    public boolean hasDeepLink(Uri deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        return hasDeepLink(new NavDeepLinkRequest(deepLink, null, null));
    }

    public boolean hasDeepLink(NavDeepLinkRequest deepLinkRequest) {
        Intrinsics.checkNotNullParameter(deepLinkRequest, "deepLinkRequest");
        return matchDeepLink(deepLinkRequest) != null;
    }

    public final void addDeepLink(String uriPattern) {
        Intrinsics.checkNotNullParameter(uriPattern, "uriPattern");
        addDeepLink(new NavDeepLink.Builder().setUriPattern(uriPattern).build());
    }

    public final void addDeepLink(final NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        List<String> listMissingRequiredArguments = NavArgumentKt.missingRequiredArguments(this._arguments, new Function1<String, Boolean>() { // from class: androidx.navigation.NavDestination$addDeepLink$missingRequiredArguments$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return Boolean.valueOf(!navDeepLink.getArgumentsNames$navigation_common_release().contains(key));
            }
        });
        if (!listMissingRequiredArguments.isEmpty()) {
            throw new IllegalArgumentException(("Deep link " + navDeepLink.getUriPattern() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + listMissingRequiredArguments).toString());
        }
        this.deepLinks.add(navDeepLink);
    }

    public final DeepLinkMatch matchRoute(String route) {
        NavDeepLink value;
        Intrinsics.checkNotNullParameter(route, "route");
        Lazy<NavDeepLink> lazy = this.routeDeepLink;
        if (lazy == null || (value = lazy.getValue()) == null) {
            return null;
        }
        Uri uri = Uri.parse(INSTANCE.createRoute(route));
        Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
        Bundle matchingArguments = value.getMatchingArguments(uri, this._arguments);
        if (matchingArguments == null) {
            return null;
        }
        return new DeepLinkMatch(this, matchingArguments, value.getIsExactDeepLink(), value.calculateMatchingPathSegments$navigation_common_release(uri), false, -1);
    }

    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        if (this.deepLinks.isEmpty()) {
            return null;
        }
        DeepLinkMatch deepLinkMatch = null;
        for (NavDeepLink navDeepLink : this.deepLinks) {
            Uri uri = navDeepLinkRequest.getUri();
            if (navDeepLink.matches$navigation_common_release(navDeepLinkRequest)) {
                Bundle matchingArguments = uri != null ? navDeepLink.getMatchingArguments(uri, this._arguments) : null;
                int iCalculateMatchingPathSegments$navigation_common_release = navDeepLink.calculateMatchingPathSegments$navigation_common_release(uri);
                String action = navDeepLinkRequest.getAction();
                boolean z = action != null && Intrinsics.areEqual(action, navDeepLink.getAction());
                String mimeType = navDeepLinkRequest.getMimeType();
                int mimeTypeMatchRating = mimeType != null ? navDeepLink.getMimeTypeMatchRating(mimeType) : -1;
                if (matchingArguments == null) {
                    if (z || mimeTypeMatchRating > -1) {
                        if (hasRequiredArguments(navDeepLink, uri, this._arguments)) {
                        }
                    }
                }
                DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, matchingArguments, navDeepLink.getIsExactDeepLink(), iCalculateMatchingPathSegments$navigation_common_release, z, mimeTypeMatchRating);
                if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                    deepLinkMatch = deepLinkMatch2;
                }
            }
        }
        return deepLinkMatch;
    }

    private final boolean hasRequiredArguments(NavDeepLink deepLink, Uri uri, Map<String, NavArgument> arguments) {
        final Bundle matchingPathAndQueryArgs$navigation_common_release = deepLink.getMatchingPathAndQueryArgs$navigation_common_release(uri, arguments);
        return NavArgumentKt.missingRequiredArguments(arguments, new Function1<String, Boolean>() { // from class: androidx.navigation.NavDestination$hasRequiredArguments$missingRequiredArguments$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return Boolean.valueOf(!matchingPathAndQueryArgs$navigation_common_release.containsKey(key));
            }
        }).isEmpty();
    }

    public static /* synthetic */ int[] buildDeepLinkIds$default(NavDestination navDestination, NavDestination navDestination2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
        }
        if ((i & 1) != 0) {
            navDestination2 = null;
        }
        return navDestination.buildDeepLinkIds(navDestination2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] buildDeepLinkIds(androidx.navigation.NavDestination r6) {
        /*
            r5 = this;
            kotlin.collections.ArrayDeque r0 = new kotlin.collections.ArrayDeque
            r0.<init>()
            r1 = r5
        L6:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.navigation.NavGraph r2 = r1.parent
            if (r6 == 0) goto L10
            androidx.navigation.NavGraph r3 = r6.parent
            goto L11
        L10:
            r3 = 0
        L11:
            if (r3 == 0) goto L24
            androidx.navigation.NavGraph r3 = r6.parent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int r4 = r1.id
            androidx.navigation.NavDestination r3 = r3.findNode(r4)
            if (r3 != r1) goto L24
            r0.addFirst(r1)
            goto L3d
        L24:
            if (r2 == 0) goto L2e
            int r3 = r2.getStartDestId()
            int r4 = r1.id
            if (r3 == r4) goto L31
        L2e:
            r0.addFirst(r1)
        L31:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r6)
            if (r1 == 0) goto L38
            goto L3d
        L38:
            r1 = r2
            androidx.navigation.NavDestination r1 = (androidx.navigation.NavDestination) r1
            if (r1 != 0) goto L6
        L3d:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r6 = kotlin.collections.CollectionsKt.toList(r0)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r6 = r6.iterator()
        L56:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L6c
            java.lang.Object r1 = r6.next()
            androidx.navigation.NavDestination r1 = (androidx.navigation.NavDestination) r1
            int r1 = r1.id
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L56
        L6c:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            int[] r6 = kotlin.collections.CollectionsKt.toIntArray(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.buildDeepLinkIds(androidx.navigation.NavDestination):int[]");
    }

    public final boolean hasRoute(String route, Bundle arguments) {
        Intrinsics.checkNotNullParameter(route, "route");
        if (Intrinsics.areEqual(this.route, route)) {
            return true;
        }
        DeepLinkMatch deepLinkMatchMatchRoute = matchRoute(route);
        if (Intrinsics.areEqual(this, deepLinkMatchMatchRoute != null ? deepLinkMatchMatchRoute.getDestination() : null)) {
            return deepLinkMatchMatchRoute.hasMatchingArgs(arguments);
        }
        return false;
    }

    public final NavAction getAction(int id) {
        NavAction navAction = this.actions.getIsEmpty() ? null : this.actions.get(id);
        if (navAction != null) {
            return navAction;
        }
        NavGraph navGraph = this.parent;
        if (navGraph != null) {
            return navGraph.getAction(id);
        }
        return null;
    }

    public final void putAction(int actionId, int destId) {
        putAction(actionId, new NavAction(destId, null, null, 6, null));
    }

    public final void putAction(int actionId, NavAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!supportsActions()) {
            throw new UnsupportedOperationException("Cannot add action " + actionId + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        }
        if (actionId == 0) {
            throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
        }
        this.actions.put(actionId, action);
    }

    public final void removeAction(int actionId) {
        this.actions.remove(actionId);
    }

    public final void addArgument(String argumentName, NavArgument argument) {
        Intrinsics.checkNotNullParameter(argumentName, "argumentName");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this._arguments.put(argumentName, argument);
    }

    public final void removeArgument(String argumentName) {
        Intrinsics.checkNotNullParameter(argumentName, "argumentName");
        this._arguments.remove(argumentName);
    }

    public final Bundle addInDefaultArgs(Bundle args) {
        if (args == null && this._arguments.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, NavArgument> entry : this._arguments.entrySet()) {
            entry.getValue().putDefaultValue(entry.getKey(), bundle);
        }
        if (args != null) {
            bundle.putAll(args);
            for (Map.Entry<String, NavArgument> entry2 : this._arguments.entrySet()) {
                String key = entry2.getKey();
                NavArgument value = entry2.getValue();
                if (!value.getIsDefaultValueUnknown() && !value.verify(key, bundle)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + key + "' in argument bundle. " + value.getType().getName() + " expected.").toString());
                }
            }
        }
        return bundle;
    }

    public final String fillInLabel(Context context, Bundle bundle) {
        NavArgument navArgument;
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence charSequence = this.label;
        if (charSequence == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String argName = matcher.group(1);
            if (bundle != null && bundle.containsKey(argName)) {
                matcher.appendReplacement(stringBuffer, "");
                NavType<Object> type = (argName == null || (navArgument = this._arguments.get(argName)) == null) ? null : navArgument.getType();
                if (Intrinsics.areEqual(type, NavType.ReferenceType)) {
                    NavType<Integer> navType = NavType.ReferenceType;
                    Intrinsics.checkNotNullExpressionValue(argName, "argName");
                    Integer num = navType.get(bundle, argName);
                    Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
                    String string = context.getString(num.intValue());
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …                        )");
                    stringBuffer.append(string);
                } else {
                    Intrinsics.checkNotNull(type);
                    Intrinsics.checkNotNullExpressionValue(argName, "argName");
                    stringBuffer.append(String.valueOf(type.get(bundle, argName)));
                }
            } else {
                throw new IllegalArgumentException("Could not find \"" + argName + "\" in " + bundle + " to fill label \"" + ((Object) charSequence) + '\"');
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.idName;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.id));
        } else {
            sb.append(str);
        }
        sb.append(")");
        String str2 = this.route;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            sb.append(" route=");
            sb.append(this.route);
        }
        if (this.label != null) {
            sb.append(" label=");
            sb.append(this.label);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2 A[EDGE_INSN: B:31:0x00a2->B:32:0x00a3 BREAK  A[LOOP:1: B:23:0x0073->B:47:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 1
            if (r8 != r9) goto L4
            return r0
        L4:
            r1 = 0
            if (r9 == 0) goto Lba
            boolean r2 = r9 instanceof androidx.navigation.NavDestination
            if (r2 != 0) goto Ld
            goto Lba
        Ld:
            java.util.List<androidx.navigation.NavDeepLink> r2 = r8.deepLinks
            androidx.navigation.NavDestination r9 = (androidx.navigation.NavDestination) r9
            java.util.List<androidx.navigation.NavDeepLink> r3 = r9.deepLinks
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            androidx.collection.SparseArrayCompat<androidx.navigation.NavAction> r3 = r8.actions
            int r3 = r3.size()
            androidx.collection.SparseArrayCompat<androidx.navigation.NavAction> r4 = r9.actions
            int r4 = r4.size()
            if (r3 != r4) goto L5a
            androidx.collection.SparseArrayCompat<androidx.navigation.NavAction> r3 = r8.actions
            kotlin.collections.IntIterator r3 = androidx.collection.SparseArrayKt.keyIterator(r3)
            java.util.Iterator r3 = (java.util.Iterator) r3
            kotlin.sequences.Sequence r3 = kotlin.sequences.SequencesKt.asSequence(r3)
            java.util.Iterator r3 = r3.iterator()
        L35:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L58
            java.lang.Object r4 = r3.next()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            androidx.collection.SparseArrayCompat<androidx.navigation.NavAction> r5 = r8.actions
            java.lang.Object r5 = r5.get(r4)
            androidx.collection.SparseArrayCompat<androidx.navigation.NavAction> r6 = r9.actions
            java.lang.Object r4 = r6.get(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r4)
            if (r4 != 0) goto L35
            goto L5a
        L58:
            r3 = r0
            goto L5b
        L5a:
            r3 = r1
        L5b:
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r4 = r8._arguments
            int r4 = r4.size()
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r5 = r9._arguments
            int r5 = r5.size()
            if (r4 != r5) goto La2
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r4 = r8._arguments
            kotlin.sequences.Sequence r4 = kotlin.collections.MapsKt.asSequence(r4)
            java.util.Iterator r4 = r4.iterator()
        L73:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto La0
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r6 = r9._arguments
            java.lang.Object r7 = r5.getKey()
            boolean r6 = r6.containsKey(r7)
            if (r6 == 0) goto La2
            java.util.Map<java.lang.String, androidx.navigation.NavArgument> r6 = r9._arguments
            java.lang.Object r7 = r5.getKey()
            java.lang.Object r6 = r6.get(r7)
            java.lang.Object r5 = r5.getValue()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r5)
            if (r5 == 0) goto La2
            goto L73
        La0:
            r4 = r0
            goto La3
        La2:
            r4 = r1
        La3:
            int r5 = r8.id
            int r6 = r9.id
            if (r5 != r6) goto Lba
            java.lang.String r5 = r8.route
            java.lang.String r9 = r9.route
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r9)
            if (r9 == 0) goto Lba
            if (r2 == 0) goto Lba
            if (r3 == 0) goto Lba
            if (r4 == 0) goto Lba
            return r0
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Set<String> setKeySet;
        int i = this.id * 31;
        String str = this.route;
        int iHashCode = i + (str != null ? str.hashCode() : 0);
        for (NavDeepLink navDeepLink : this.deepLinks) {
            int i2 = iHashCode * 31;
            String uriPattern = navDeepLink.getUriPattern();
            int iHashCode2 = (i2 + (uriPattern != null ? uriPattern.hashCode() : 0)) * 31;
            String action = navDeepLink.getAction();
            int iHashCode3 = (iHashCode2 + (action != null ? action.hashCode() : 0)) * 31;
            String mimeType = navDeepLink.getMimeType();
            iHashCode = iHashCode3 + (mimeType != null ? mimeType.hashCode() : 0);
        }
        Iterator itValueIterator = SparseArrayKt.valueIterator(this.actions);
        while (itValueIterator.hasNext()) {
            NavAction navAction = (NavAction) itValueIterator.next();
            int destinationId = ((iHashCode * 31) + navAction.getDestinationId()) * 31;
            NavOptions navOptions = navAction.getNavOptions();
            iHashCode = destinationId + (navOptions != null ? navOptions.hashCode() : 0);
            Bundle defaultArguments = navAction.getDefaultArguments();
            if (defaultArguments != null && (setKeySet = defaultArguments.keySet()) != null) {
                Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet()");
                for (String str2 : setKeySet) {
                    int i3 = iHashCode * 31;
                    Bundle defaultArguments2 = navAction.getDefaultArguments();
                    Intrinsics.checkNotNull(defaultArguments2);
                    Object obj = defaultArguments2.get(str2);
                    iHashCode = i3 + (obj != null ? obj.hashCode() : 0);
                }
            }
        }
        for (String str3 : this._arguments.keySet()) {
            int iHashCode4 = ((iHashCode * 31) + str3.hashCode()) * 31;
            NavArgument navArgument = this._arguments.get(str3);
            iHashCode = iHashCode4 + (navArgument != null ? navArgument.hashCode() : 0);
        }
        return iHashCode;
    }

    /* JADX INFO: compiled from: NavDestination.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J:\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0010\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006H\u0005J:\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0010\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00160\u0006H\u0007J\u0019\u0010\u001a\u001a\u00020\u001b\"\n\b\u0000\u0010\u001c\u0018\u0001*\u00020\u0001*\u00020\tH\u0087\bJ$\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\u001c*\u00020\u0001*\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001dH\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavDestination$Companion;", "", "()V", "classes", "", "", "Ljava/lang/Class;", "hierarchy", "Lkotlin/sequences/Sequence;", "Landroidx/navigation/NavDestination;", "getHierarchy$annotations", "(Landroidx/navigation/NavDestination;)V", "getHierarchy", "(Landroidx/navigation/NavDestination;)Lkotlin/sequences/Sequence;", "createRoute", "route", "getDisplayName", "context", "Landroid/content/Context;", "id", "", "parseClassFromName", "C", "name", "expectedClassType", "parseClassFromNameInternal", "hasRoute", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getHierarchy$annotations(NavDestination navDestination) {
        }

        private Companion() {
        }

        @JvmStatic
        protected final <C> Class<? extends C> parseClassFromName(Context context, String name, Class<? extends C> expectedClassType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(expectedClassType, "expectedClassType");
            String str = name.charAt(0) == '.' ? context.getPackageName() + name : name;
            Class<? extends C> cls = (Class) NavDestination.classes.get(str);
            if (cls == null) {
                try {
                    cls = (Class<? extends C>) Class.forName(str, true, context.getClassLoader());
                    NavDestination.classes.put(name, cls);
                } catch (ClassNotFoundException e2) {
                    throw new IllegalArgumentException(e2);
                }
            }
            Intrinsics.checkNotNull(cls);
            if (expectedClassType.isAssignableFrom(cls)) {
                return cls;
            }
            throw new IllegalArgumentException((str + " must be a subclass of " + expectedClassType).toString());
        }

        @JvmStatic
        public final <C> Class<? extends C> parseClassFromNameInternal(Context context, String name, Class<? extends C> expectedClassType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(expectedClassType, "expectedClassType");
            return NavDestination.parseClassFromName(context, name, expectedClassType);
        }

        @JvmStatic
        public final String getDisplayName(Context context, int id) {
            String strValueOf;
            Intrinsics.checkNotNullParameter(context, "context");
            if (id <= 16777215) {
                return String.valueOf(id);
            }
            try {
                strValueOf = context.getResources().getResourceName(id);
            } catch (Resources.NotFoundException unused) {
                strValueOf = String.valueOf(id);
            }
            Intrinsics.checkNotNullExpressionValue(strValueOf, "try {\n                  …tring()\n                }");
            return strValueOf;
        }

        public final String createRoute(String route) {
            return route != null ? "android-app://androidx.navigation/" + route : "";
        }

        public final Sequence<NavDestination> getHierarchy(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            return SequencesKt.generateSequence(navDestination, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavDestination$Companion$hierarchy$1
                @Override // kotlin.jvm.functions.Function1
                public final NavDestination invoke(NavDestination it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getParent();
                }
            });
        }

        @JvmStatic
        public final /* synthetic */ <T> boolean hasRoute(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return hasRoute(navDestination, Reflection.getOrCreateKotlinClass(Object.class));
        }

        @JvmStatic
        public final <T> boolean hasRoute(NavDestination navDestination, KClass<T> route) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            Intrinsics.checkNotNullParameter(route, "route");
            return RouteSerializerKt.generateHashCode(SerializersKt.serializer(route)) == navDestination.getId();
        }
    }
}
