package androidx.compose.ui.platform;

import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.HostDefaultProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.MediaQueryKt;
import androidx.compose.ui.R;
import androidx.compose.ui.UiMediaScope;
import androidx.compose.ui.adaptive.MediaQuery_androidKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.res.ImageVectorCache;
import androidx.compose.ui.res.ResourceIdCache;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.IntSize;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: ComposeViewContext.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ß\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001g\b\u0007\u0018\u00002\u00020\u0001BG\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010B;\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0011J\r\u0010i\u001a\u00020jH\u0000¢\u0006\u0002\bkJ\r\u0010l\u001a\u00020jH\u0000¢\u0006\u0002\bmJ\b\u0010n\u001a\u00020jH\u0002J\b\u0010o\u001a\u00020jH\u0002J\u0015\u0010p\u001a\u00020j2\u0006\u0010&\u001a\u00020%H\u0000¢\u0006\u0002\bqJ:\u0010r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ*\u0010s\u001a\u00020j2\u0006\u0010t\u001a\u00020u2\u0011\u0010v\u001a\r\u0012\u0004\u0012\u00020j0d¢\u0006\u0002\bwH\u0001¢\u0006\u0004\bx\u0010yR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020%0'X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u000203X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u000207X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020A0'X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010)R\u0014\u0010C\u001a\u00020DX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020HX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020LX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020PX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020TX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR \u0010Y\u001a\u00020X2\u0006\u0010W\u001a\u00020X8\u0001@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001e\u0010\\\u001a\u00020]8\u0001X\u0080\u000e¢\u0006\u0010\n\u0002\u0010b\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020e0dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u00020gX\u0082\u0004¢\u0006\u0004\n\u0002\u0010h¨\u0006z"}, d2 = {"Landroidx/compose/ui/platform/ComposeViewContext;", "", "composeViewContext", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "matchesContext", "", "<init>", "(Landroidx/compose/ui/platform/ComposeViewContext;Landroid/view/View;Landroidx/compose/runtime/CompositionContext;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/lifecycle/ViewModelStoreOwner;Z)V", "(Landroid/view/View;Landroidx/compose/runtime/CompositionContext;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/lifecycle/ViewModelStoreOwner;)V", "getView$ui", "()Landroid/view/View;", "getCompositionContext$ui", "()Landroidx/compose/runtime/CompositionContext;", "getLifecycleOwner$ui", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner$ui", "()Landroidx/savedstate/SavedStateRegistryOwner;", "getViewModelStoreOwner$ui", "()Landroidx/lifecycle/ViewModelStoreOwner;", "imageVectorCache", "Landroidx/compose/ui/res/ImageVectorCache;", "getImageVectorCache$ui", "()Landroidx/compose/ui/res/ImageVectorCache;", "resourceIdCache", "Landroidx/compose/ui/res/ResourceIdCache;", "getResourceIdCache$ui", "()Landroidx/compose/ui/res/ResourceIdCache;", "currentConfiguration", "Landroid/content/res/Configuration;", "configuration", "Landroidx/compose/runtime/MutableState;", "getConfiguration$ui", "()Landroidx/compose/runtime/MutableState;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager$ui", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "uriHandler", "Landroidx/compose/ui/platform/AndroidUriHandler;", "getUriHandler$ui", "()Landroidx/compose/ui/platform/AndroidUriHandler;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager$ui", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "clipboard", "Landroidx/compose/ui/platform/AndroidClipboard;", "getClipboard$ui", "()Landroidx/compose/ui/platform/AndroidClipboard;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$ui$annotations", "()V", "getFontLoader$ui", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getFontFamilyResolver$ui", "hapticFeedback", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedback$ui", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "viewConfiguration", "Landroidx/compose/ui/platform/AndroidViewConfiguration;", "getViewConfiguration$ui", "()Landroidx/compose/ui/platform/AndroidViewConfiguration;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope$ui", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "windowInfo", "Landroidx/compose/ui/platform/LazyWindowInfo;", "getWindowInfo$ui", "()Landroidx/compose/ui/platform/LazyWindowInfo;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "getCanvasHolder$ui", "()Landroidx/compose/ui/graphics/CanvasHolder;", "value", "", "viewCount", "getViewCount$ui", "()I", "testWindowSize", "Landroidx/compose/ui/unit/IntSize;", "getTestWindowSize-YbymL2g$ui", "()J", "setTestWindowSize-ozmzZPI$ui", "(J)V", "J", "calculateWindowSizeLambda", "Lkotlin/Function0;", "Landroidx/compose/ui/platform/DerivedSize;", "callback", "androidx/compose/ui/platform/ComposeViewContext$callback$1", "Landroidx/compose/ui/platform/ComposeViewContext$callback$1;", "incrementViewCount", "", "incrementViewCount$ui", "decrementViewCount", "decrementViewCount$ui", "startObserving", "stopObserving", "onConfigurationChanged", "onConfigurationChanged$ui", Constants.COPY_TYPE, "ProvideCompositionLocals", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "content", "Landroidx/compose/runtime/Composable;", "ProvideCompositionLocals$ui", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComposeViewContext {
    public static final int $stable = 8;
    private final AndroidAccessibilityManager accessibilityManager;
    private final Function0<DerivedSize> calculateWindowSizeLambda;
    private final ComposeViewContext$callback$1 callback;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboard clipboard;
    private final AndroidClipboardManager clipboardManager;
    private final CompositionContext compositionContext;
    private final MutableState<Configuration> configuration;
    private final Configuration currentConfiguration;
    private final MutableState<FontFamily.Resolver> fontFamilyResolver;
    private final Font.ResourceLoader fontLoader;
    private final HapticFeedback hapticFeedback;
    private final ImageVectorCache imageVectorCache;
    private final LifecycleOwner lifecycleOwner;
    private final ResourceIdCache resourceIdCache;
    private final SavedStateRegistryOwner savedStateRegistryOwner;
    private final LayoutNodeDrawScope sharedDrawScope;
    private long testWindowSize;
    private final AndroidUriHandler uriHandler;
    private final View view;
    private final AndroidViewConfiguration viewConfiguration;
    private int viewCount;
    private final ViewModelStoreOwner viewModelStoreOwner;
    private final LazyWindowInfo windowInfo;

    public static /* synthetic */ void getFontLoader$ui$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ComposeViewContext(ComposeViewContext composeViewContext, View view, CompositionContext compositionContext, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, boolean z) {
        ImageVectorCache imageVectorCache;
        Configuration configuration;
        MutableState<Configuration> mutableStateMutableStateOf$default;
        AndroidAccessibilityManager androidAccessibilityManager;
        AndroidUriHandler androidUriHandler;
        AndroidClipboardManager androidClipboardManager;
        AndroidClipboard androidClipboard;
        AndroidFontResourceLoader androidFontResourceLoader;
        MutableState<FontFamily.Resolver> mutableStateMutableStateOf;
        PlatformHapticFeedback platformHapticFeedback;
        AndroidViewConfiguration androidViewConfiguration;
        CanvasHolder canvasHolder;
        LayoutNodeDrawScope layoutNodeDrawScope;
        ResourceIdCache resourceIdCache;
        this.view = view;
        this.compositionContext = compositionContext;
        this.lifecycleOwner = lifecycleOwner;
        this.savedStateRegistryOwner = savedStateRegistryOwner;
        this.viewModelStoreOwner = viewModelStoreOwner;
        if (z) {
            Intrinsics.checkNotNull(composeViewContext);
            imageVectorCache = composeViewContext.imageVectorCache;
        } else {
            imageVectorCache = new ImageVectorCache();
        }
        this.imageVectorCache = imageVectorCache;
        this.resourceIdCache = (composeViewContext == null || (resourceIdCache = composeViewContext.resourceIdCache) == null) ? new ResourceIdCache() : resourceIdCache;
        if (z) {
            Intrinsics.checkNotNull(composeViewContext);
            configuration = composeViewContext.currentConfiguration;
        } else {
            configuration = new Configuration(view.getContext().getResources().getConfiguration());
        }
        this.currentConfiguration = configuration;
        CanvasDrawScope canvasDrawScope = null;
        Object[] objArr = 0;
        if (!z) {
            mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Configuration(configuration), null, 2, null);
        } else {
            Intrinsics.checkNotNull(composeViewContext);
            mutableStateMutableStateOf$default = composeViewContext.configuration;
        }
        this.configuration = mutableStateMutableStateOf$default;
        if (z) {
            Intrinsics.checkNotNull(composeViewContext);
            androidAccessibilityManager = composeViewContext.accessibilityManager;
        } else {
            androidAccessibilityManager = new AndroidAccessibilityManager(view.getContext());
        }
        this.accessibilityManager = androidAccessibilityManager;
        if (z) {
            Intrinsics.checkNotNull(composeViewContext);
            androidUriHandler = composeViewContext.uriHandler;
        } else {
            androidUriHandler = new AndroidUriHandler(view.getContext());
        }
        this.uriHandler = androidUriHandler;
        if (z) {
            Intrinsics.checkNotNull(composeViewContext);
            androidClipboardManager = composeViewContext.clipboardManager;
        } else {
            androidClipboardManager = new AndroidClipboardManager(view.getContext());
        }
        this.clipboardManager = androidClipboardManager;
        if (z) {
            Intrinsics.checkNotNull(composeViewContext);
            androidClipboard = composeViewContext.clipboard;
        } else {
            androidClipboard = new AndroidClipboard(androidClipboardManager);
        }
        this.clipboard = androidClipboard;
        if (z) {
            Intrinsics.checkNotNull(composeViewContext);
            androidFontResourceLoader = composeViewContext.fontLoader;
        } else {
            androidFontResourceLoader = new AndroidFontResourceLoader(view.getContext());
        }
        this.fontLoader = androidFontResourceLoader;
        if (z) {
            Intrinsics.checkNotNull(composeViewContext);
            mutableStateMutableStateOf = composeViewContext.fontFamilyResolver;
        } else {
            mutableStateMutableStateOf = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(view.getContext()), SnapshotStateKt.referentialEqualityPolicy());
        }
        this.fontFamilyResolver = mutableStateMutableStateOf;
        if (view == (composeViewContext != null ? composeViewContext.view : null)) {
            platformHapticFeedback = composeViewContext.hapticFeedback;
        } else {
            platformHapticFeedback = new PlatformHapticFeedback(view);
        }
        this.hapticFeedback = platformHapticFeedback;
        if (z) {
            Intrinsics.checkNotNull(composeViewContext);
            androidViewConfiguration = composeViewContext.viewConfiguration;
        } else {
            androidViewConfiguration = new AndroidViewConfiguration(android.view.ViewConfiguration.get(view.getContext()));
        }
        this.viewConfiguration = androidViewConfiguration;
        this.sharedDrawScope = (composeViewContext == null || (layoutNodeDrawScope = composeViewContext.sharedDrawScope) == null) ? new LayoutNodeDrawScope(canvasDrawScope, 1, objArr == true ? 1 : 0) : layoutNodeDrawScope;
        this.windowInfo = new LazyWindowInfo();
        this.canvasHolder = (composeViewContext == null || (canvasHolder = composeViewContext.canvasHolder) == null) ? new CanvasHolder() : canvasHolder;
        this.testWindowSize = IntSize.INSTANCE.m9006getZeroYbymL2g();
        this.calculateWindowSizeLambda = new Function0<DerivedSize>() { // from class: androidx.compose.ui.platform.ComposeViewContext$calculateWindowSizeLambda$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DerivedSize invoke() {
                if (IntSize.m8999equalsimpl0(this.this$0.getTestWindowSize(), IntSize.INSTANCE.m9006getZeroYbymL2g())) {
                    return AndroidWindowInfo_androidKt.calculateWindowSize(this.this$0.getView());
                }
                return DerivedSize.INSTANCE.m7928fromPxSizeviCIZxY(this.this$0.getTestWindowSize(), AndroidDensity_androidKt.Density(this.this$0.getView().getContext()));
            }
        };
        this.callback = new ComposeViewContext$callback$1(this);
    }

    /* JADX INFO: renamed from: getView$ui, reason: from getter */
    public final View getView() {
        return this.view;
    }

    /* JADX INFO: renamed from: getCompositionContext$ui, reason: from getter */
    public final CompositionContext getCompositionContext() {
        return this.compositionContext;
    }

    /* JADX INFO: renamed from: getLifecycleOwner$ui, reason: from getter */
    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    /* JADX INFO: renamed from: getSavedStateRegistryOwner$ui, reason: from getter */
    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    /* JADX INFO: renamed from: getViewModelStoreOwner$ui, reason: from getter */
    public final ViewModelStoreOwner getViewModelStoreOwner() {
        return this.viewModelStoreOwner;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* synthetic */ ComposeViewContext(ComposeViewContext composeViewContext, View view, CompositionContext compositionContext, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        View view2;
        if ((i & 64) != 0) {
            z = Intrinsics.areEqual((composeViewContext == null || (view2 = composeViewContext.view) == null) ? null : view2.getContext(), view.getContext());
        }
        this(composeViewContext, view, compositionContext, lifecycleOwner, savedStateRegistryOwner, viewModelStoreOwner, z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ComposeViewContext(View view, CompositionContext compositionContext, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0 && (compositionContext = WindowRecomposer_androidKt.findViewTreeCompositionContext(view)) == null) {
            compositionContext = WindowRecomposer_androidKt.getWindowRecomposer(view);
        }
        CompositionContext compositionContext2 = compositionContext;
        if ((i & 4) != 0 && (lifecycleOwner = ViewTreeLifecycleOwner.get(view)) == null) {
            throw new IllegalStateException("Composed into a View which doesn't propagate ViewTreeLifecycleOwner!");
        }
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        if ((i & 8) == 0 || (savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(view)) != null) {
            this(view, compositionContext2, lifecycleOwner2, savedStateRegistryOwner, (i & 16) != 0 ? ViewTreeViewModelStoreOwner.get(view) : viewModelStoreOwner);
            return;
        }
        throw new IllegalStateException("Composed into a View which doesn't propagate ViewTreeSavedStateRegistryOwner!");
    }

    public ComposeViewContext(View view, CompositionContext compositionContext, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner) {
        this(ComposeView_androidKt.findViewTreeComposeViewContext(view), view, compositionContext, lifecycleOwner, savedStateRegistryOwner, viewModelStoreOwner, false, 64, null);
    }

    /* JADX INFO: renamed from: getImageVectorCache$ui, reason: from getter */
    public final ImageVectorCache getImageVectorCache() {
        return this.imageVectorCache;
    }

    /* JADX INFO: renamed from: getResourceIdCache$ui, reason: from getter */
    public final ResourceIdCache getResourceIdCache() {
        return this.resourceIdCache;
    }

    public final MutableState<Configuration> getConfiguration$ui() {
        return this.configuration;
    }

    /* JADX INFO: renamed from: getAccessibilityManager$ui, reason: from getter */
    public final AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    /* JADX INFO: renamed from: getUriHandler$ui, reason: from getter */
    public final AndroidUriHandler getUriHandler() {
        return this.uriHandler;
    }

    /* JADX INFO: renamed from: getClipboardManager$ui, reason: from getter */
    public final AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    /* JADX INFO: renamed from: getClipboard$ui, reason: from getter */
    public final AndroidClipboard getClipboard() {
        return this.clipboard;
    }

    /* JADX INFO: renamed from: getFontLoader$ui, reason: from getter */
    public final Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    public final MutableState<FontFamily.Resolver> getFontFamilyResolver$ui() {
        return this.fontFamilyResolver;
    }

    /* JADX INFO: renamed from: getHapticFeedback$ui, reason: from getter */
    public final HapticFeedback getHapticFeedback() {
        return this.hapticFeedback;
    }

    /* JADX INFO: renamed from: getViewConfiguration$ui, reason: from getter */
    public final AndroidViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    /* JADX INFO: renamed from: getSharedDrawScope$ui, reason: from getter */
    public final LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    /* JADX INFO: renamed from: getWindowInfo$ui, reason: from getter */
    public final LazyWindowInfo getWindowInfo() {
        return this.windowInfo;
    }

    /* JADX INFO: renamed from: getCanvasHolder$ui, reason: from getter */
    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    /* JADX INFO: renamed from: getViewCount$ui, reason: from getter */
    public final int getViewCount() {
        return this.viewCount;
    }

    /* JADX INFO: renamed from: getTestWindowSize-YbymL2g$ui, reason: not valid java name and from getter */
    public final long getTestWindowSize() {
        return this.testWindowSize;
    }

    /* JADX INFO: renamed from: setTestWindowSize-ozmzZPI$ui, reason: not valid java name */
    public final void m7918setTestWindowSizeozmzZPI$ui(long j) {
        this.testWindowSize = j;
    }

    public final void incrementViewCount$ui() {
        int i = this.viewCount + 1;
        this.viewCount = i;
        if (i == 1) {
            startObserving();
        }
    }

    public final void decrementViewCount$ui() {
        int i = this.viewCount - 1;
        this.viewCount = i;
        if (i < 0) {
            Log.e("ComposeViewContext", "View count has dropped below 0");
            this.viewCount = 0;
        }
        if (this.viewCount == 0) {
            stopObserving();
        }
    }

    private final void startObserving() {
        this.view.getContext().registerComponentCallbacks(this.callback);
        onConfigurationChanged$ui(this.view.getResources().getConfiguration());
        this.windowInfo.setWindowFocused(this.view.hasWindowFocus());
        this.windowInfo.setOnInitializeContainerSize(this.calculateWindowSizeLambda);
        LazyWindowInfo lazyWindowInfo = this.windowInfo;
        Function0<DerivedSize> function0 = this.calculateWindowSizeLambda;
        MutableState mutableState = lazyWindowInfo._containerSize;
        if (mutableState != null) {
            mutableState.setValue(function0.invoke());
        }
        this.view.getViewTreeObserver().addOnWindowFocusChangeListener(this.callback);
    }

    private final void stopObserving() {
        this.view.getContext().unregisterComponentCallbacks(this.callback);
        this.windowInfo.setOnInitializeContainerSize(null);
        this.view.getViewTreeObserver().removeOnWindowFocusChangeListener(this.callback);
    }

    public final void onConfigurationChanged$ui(Configuration configuration) {
        int iUpdateFrom = this.currentConfiguration.updateFrom(configuration);
        if (iUpdateFrom != 0) {
            this.imageVectorCache.prune(iUpdateFrom);
            this.configuration.setValue(new Configuration(configuration));
            this.resourceIdCache.clear();
            if ((268435456 & iUpdateFrom) != 0) {
                this.fontFamilyResolver.setValue(FontFamilyResolver_androidKt.createFontFamilyResolver(this.view.getContext()));
            }
            if (((-1342235264) & iUpdateFrom) != 0) {
                LazyWindowInfo lazyWindowInfo = this.windowInfo;
                Function0<DerivedSize> function0 = this.calculateWindowSizeLambda;
                MutableState mutableState = lazyWindowInfo._containerSize;
                if (mutableState != null) {
                    mutableState.setValue(function0.invoke());
                }
            }
        }
    }

    public static /* synthetic */ ComposeViewContext copy$default(ComposeViewContext composeViewContext, View view, CompositionContext compositionContext, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, int i, Object obj) {
        if ((i & 1) != 0) {
            view = composeViewContext.view;
        }
        if ((i & 2) != 0) {
            compositionContext = composeViewContext.compositionContext;
        }
        if ((i & 4) != 0) {
            lifecycleOwner = composeViewContext.lifecycleOwner;
        }
        if ((i & 8) != 0) {
            savedStateRegistryOwner = composeViewContext.savedStateRegistryOwner;
        }
        if ((i & 16) != 0) {
            viewModelStoreOwner = composeViewContext.viewModelStoreOwner;
        }
        ViewModelStoreOwner viewModelStoreOwner2 = viewModelStoreOwner;
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        return composeViewContext.copy(view, compositionContext, lifecycleOwner2, savedStateRegistryOwner, viewModelStoreOwner2);
    }

    public final ComposeViewContext copy(View view, CompositionContext compositionContext, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner) {
        return new ComposeViewContext(this, view, compositionContext, lifecycleOwner, savedStateRegistryOwner, viewModelStoreOwner, false, 64, null);
    }

    public final void ProvideCompositionLocals$ui(final AndroidComposeView androidComposeView, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(123858079);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideCompositionLocals)N(owner,content)413@17790L96,416@17918L49,416@17895L72,419@18048L7,420@18123L64,435@19025L683,422@18232L1476:ComposeViewContext.android.kt#itgzvw");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(androidComposeView) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(123858079, i2, -1, "androidx.compose.ui.platform.ComposeViewContext.ProvideCompositionLocals (ComposeViewContext.android.kt:403)");
            }
            Object tag = androidComposeView.getTag(R.id.inspection_slot_table_set);
            Set<CompositionData> set = null;
            Set<CompositionData> set2 = TypeIntrinsics.isMutableSet(tag) ? (Set) tag : null;
            if (set2 == null) {
                Object parent = androidComposeView.getParent();
                View view = parent instanceof View ? (View) parent : null;
                Object tag2 = view != null ? view.getTag(R.id.inspection_slot_table_set) : null;
                if (TypeIntrinsics.isMutableSet(tag2)) {
                    set = (Set) tag2;
                }
            } else {
                set = set2;
            }
            if (set != null) {
                set.add(composerStartRestartGroup.getCompositionData());
                composerStartRestartGroup.collectParameterInformation();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1231450689, "CC(remember):ComposeViewContext.android.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry(androidComposeView, this.savedStateRegistryOwner);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final DisposableSaveableStateRegistry disposableSaveableStateRegistry = (DisposableSaveableStateRegistry) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1231446640, "CC(remember):ComposeViewContext.android.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(disposableSaveableStateRegistry);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.platform.ComposeViewContext$ProvideCompositionLocals$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final DisposableSaveableStateRegistry disposableSaveableStateRegistry2 = disposableSaveableStateRegistry;
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.platform.ComposeViewContext$ProvideCompositionLocals$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                disposableSaveableStateRegistry2.dispose();
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 6);
            CompositionLocal<Boolean> localScrollCaptureInProgress = CompositionLocalsKt.getLocalScrollCaptureInProgress();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localScrollCaptureInProgress);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean zBooleanValue = ((Boolean) objConsume).booleanValue() | androidComposeView.getScrollCaptureInProgress$ui();
            View view2 = androidComposeView.getView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1231440065, "CC(remember):ComposeViewContext.android.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(view2);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new ViewTreeHostDefaultProvider(androidComposeView.getView());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalLifecycleOwnerKt.getLocalLifecycleOwner().provides(this.lifecycleOwner), LocalSavedStateRegistryOwnerKt.getLocalSavedStateRegistryOwner().provides(this.savedStateRegistryOwner), AndroidCompositionLocals_androidKt.getLocalImageVectorCache().provides(this.imageVectorCache), AndroidCompositionLocals_androidKt.getLocalResourceIdCache().provides(this.resourceIdCache), AndroidCompositionLocals_androidKt.getLocalContext().provides(androidComposeView.getContext()), InspectionTablesKt.getLocalInspectionTables().provides(set), AndroidCompositionLocals_androidKt.getLocalConfiguration().provides(androidComposeView.getConfiguration()), SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(disposableSaveableStateRegistry), AndroidCompositionLocals_androidKt.getLocalView().provides(androidComposeView.getView()), CompositionLocalsKt.getLocalProvidableScrollCaptureInProgress().provides(Boolean.valueOf(zBooleanValue)), CompositionLocalsKt.getLocalViewConfiguration().provides(androidComposeView.getViewConfiguration()), HostDefaultProviderKt.getLocalHostDefaultProvider().provides((ViewTreeHostDefaultProvider) objRememberedValue3)}, ComposableLambdaKt.rememberComposableLambda(1317454175, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.ComposeViewContext$ProvideCompositionLocals$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C:ComposeViewContext.android.kt#itgzvw");
                    if (!composer2.shouldExecute((i3 & 3) != 2, i3 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1317454175, i3, -1, "androidx.compose.ui.platform.ComposeViewContext.ProvideCompositionLocals.<anonymous> (ComposeViewContext.android.kt:436)");
                    }
                    if (ComposeUiFlags.isMediaQueryIntegrationEnabled) {
                        composer2.startReplaceGroup(866239106);
                        ComposerKt.sourceInformation(composer2, "437@19110L63,438@19254L224,438@19190L288");
                        ProvidedValue<UiMediaScope> providedValueProvides = MediaQueryKt.getLocalUiMediaScope().provides(MediaQuery_androidKt.obtainUiMediaScope(androidComposeView.getContext(), androidComposeView.getView(), androidComposeView.getWindowInfo(), composer2, 0));
                        final AndroidComposeView androidComposeView2 = androidComposeView;
                        final ComposeViewContext composeViewContext = this;
                        final Function2<Composer, Integer, Unit> function22 = function2;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(-1423844166, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.ComposeViewContext$ProvideCompositionLocals$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i4) {
                                ComposerKt.sourceInformation(composer3, "C439@19276L184:ComposeViewContext.android.kt#itgzvw");
                                if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1423844166, i4, -1, "androidx.compose.ui.platform.ComposeViewContext.ProvideCompositionLocals.<anonymous>.<anonymous> (ComposeViewContext.android.kt:439)");
                                }
                                CompositionLocalsKt.ProvideCommonCompositionLocals(androidComposeView2, composeViewContext.getUriHandler(), function22, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(866651995);
                        ComposerKt.sourceInformation(composer2, "446@19516L168");
                        CompositionLocalsKt.ProvideCommonCompositionLocals(androidComposeView, this.getUriHandler(), function2, composer2, 0);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.ComposeViewContext$ProvideCompositionLocals$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    this.$tmp4_rcvr.ProvideCompositionLocals$ui(androidComposeView, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
