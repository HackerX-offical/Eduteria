package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.appnew.android.Utils.imagecropper.CropImage;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a³\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010\u0019\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001b\u001a}\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010\u001f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001aä\u0001\u0010\u001f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00132\u0019\b\u0002\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\b\b\u0003\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010&\u001a\u0098\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020$2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00132\u0019\b\u0002\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010'\u001a_\u0010(\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010)\u001a`\u0010*\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0002\u001a\u0080\u0001\u0010-\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010.\u001a(\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0002\u001a2\u00105\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0003\u0018\u000106*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0082@¢\u0006\u0004\b=\u0010>\u001a\u0010\u0010?\u001a\u0002022\u0006\u0010\f\u001a\u00020\rH\u0002\u001a0\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0003H\u0002\u001a?\u0010@\u001a\u00020F2\u0006\u0010G\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010H\u001a\u00020F2\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0003H\u0002¢\u0006\u0004\bI\u0010J\u001a \u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H\u0002\u001a\u001c\u0010O\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001c\u0010P\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001c\u0010Q\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\f\u0010R\u001a\u00020S*\u00020\u0003H\u0002\u001a$\u0010T\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0003\u001a,\u0010U\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0003\u001aC\u0010d\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010e\u001aM\u0010f\u001a\u00020$2\b\b\u0002\u0010g\u001a\u00020\u00032\b\b\u0002\u0010h\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010i\u001a\u001d\u0010j\u001a\u00020F2\u0006\u0010k\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010m\u001a\u001b\u0010j\u001a\u00020F2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0001¢\u0006\u0002\u0010o\"\u0016\u0010V\u001a\u00020WX\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bX\u0010Y\"\u0016\u0010[\u001a\u00020WX\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b\\\u0010Y\"\u0010\u0010]\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010a\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010b\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010c\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u001e\u0010p\u001a\u00020\t*\u00020F8@X\u0081\u0004¢\u0006\f\u0012\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0014\u0010u\u001a\u00020vX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010x¨\u0006y"}, d2 = {"Slider", "", "value", "", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", StreamManagement.Enabled.ELEMENT, "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/SliderColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "thumb", "Landroidx/compose/material3/SliderState;", "Landroidx/compose/runtime/Composable;", "track", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;III)V", "state", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "VerticalSlider", "reverseDirection", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "RangeSlider", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "startInteractionSource", "endInteractionSource", "startThumb", "Landroidx/compose/material3/RangeSliderState;", "endThumb", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "slideOnKeyEvents", "onValueChangeState", "onValueChangeFinishedState", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "snapValueToTick", "current", "tickFractions", "", "minPx", "maxPx", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stepsToTickFractions", CropImage.SCALE, "a1", "b1", "x1", "a2", "b2", "Landroidx/compose/material3/SliderRange;", "isStart", "x", "scale-2geJ7wY", "(ZFFJFF)J", "calcFraction", "a", "b", Constants.INAPP_POSITION, "sliderSemantics", "rangeSliderStartThumbSemantics", "rangeSliderEndThumbSemantics", "formatForSemantics", "", "sliderTapModifier", "rangeSliderPressDragModifier", "TrackHeight", "Landroidx/compose/ui/unit/Dp;", "getTrackHeight", "()F", "F", "ThumbWidth", "getThumbWidth", "ThumbHeight", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "VerticalThumbSize", "ThumbTrackGapSize", "TrackInsideCornerSize", "rememberSliderState", "(FILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SliderState;", "rememberRangeSliderState", "activeRangeStart", "activeRangeEnd", "(FFILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RangeSliderState;", "SliderRange", "start", "endInclusive", "(FF)J", "range", "(Lkotlin/ranges/ClosedFloatingPointRange;)J", "isSpecified", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified-If1S1O4", "(J)Z", "CornerSizeAlignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "getCornerSizeAlignmentLine", "()Landroidx/compose/ui/layout/VerticalAlignmentLine;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SliderKt {
    private static final VerticalAlignmentLine CornerSizeAlignmentLine;
    private static final float ThumbHeight;
    private static final long ThumbSize;
    private static final float ThumbTrackGapSize;
    private static final float ThumbWidth;
    private static final float TrackHeight = SliderTokens.INSTANCE.m4792getInactiveTrackHeightD9Ej5fM();
    private static final float TrackInsideCornerSize;
    private static final long VerticalThumbSize;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSlider$lambda$13(ClosedFloatingPointRange closedFloatingPointRange, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange2, int i, Function0 function0, SliderColors sliderColors, int i2, int i3, Composer composer, int i4) {
        RangeSlider(closedFloatingPointRange, function1, modifier, z, closedFloatingPointRange2, i, function0, sliderColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSlider$lambda$19(ClosedFloatingPointRange closedFloatingPointRange, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange2, Function0 function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3 function3, Function3 function32, Function3 function33, int i, int i2, int i3, int i4, Composer composer, int i5) {
        RangeSlider(closedFloatingPointRange, function1, modifier, z, closedFloatingPointRange2, function0, sliderColors, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSlider$lambda$23(RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3 function3, Function3 function32, Function3 function33, int i, int i2, Composer composer, int i3) {
        RangeSlider(rangeSliderState, modifier, z, sliderColors, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSliderImpl$lambda$46(Modifier modifier, RangeSliderState rangeSliderState, boolean z, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3 function3, Function3 function32, Function3 function33, int i, Composer composer, int i2) {
        RangeSliderImpl(modifier, rangeSliderState, z, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Slider$lambda$1(float f2, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange, int i, Function0 function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        Slider(f2, function1, modifier, z, closedFloatingPointRange, i, function0, sliderColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Slider$lambda$4(float f2, Function1 function1, Modifier modifier, boolean z, Function0 function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, int i, Function3 function3, Function3 function32, ClosedFloatingPointRange closedFloatingPointRange, int i2, int i3, int i4, Composer composer, int i5) {
        Slider(f2, function1, modifier, z, function0, sliderColors, mutableInteractionSource, i, function3, function32, closedFloatingPointRange, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Slider$lambda$7(SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        Slider(sliderState, modifier, z, sliderColors, mutableInteractionSource, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SliderImpl$lambda$31(Modifier modifier, SliderState sliderState, boolean z, MutableInteractionSource mutableInteractionSource, Function3 function3, Function3 function32, int i, Composer composer, int i2) {
        SliderImpl(modifier, sliderState, z, mutableInteractionSource, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalSlider$lambda$10(SliderState sliderState, Modifier modifier, boolean z, boolean z2, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        VerticalSlider(sliderState, modifier, z, z2, sliderColors, mutableInteractionSource, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: isSpecified-If1S1O4$annotations, reason: not valid java name */
    public static /* synthetic */ void m3495isSpecifiedIf1S1O4$annotations(long j) {
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Slider(final float r27, final kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r31, int r32, kotlin.jvm.functions.Function0<kotlin.Unit> r33, androidx.compose.material3.SliderColors r34, androidx.compose.foundation.interaction.MutableInteractionSource r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Slider(final float r26, final kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, boolean r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.material3.SliderColors r31, androidx.compose.foundation.interaction.MutableInteractionSource r32, int r33, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 779
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, int, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.ranges.ClosedFloatingPointRange, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Slider(final androidx.compose.material3.SliderState r17, androidx.compose.ui.Modifier r18, boolean r19, androidx.compose.material3.SliderColors r20, androidx.compose.foundation.interaction.MutableInteractionSource r21, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void VerticalSlider(final androidx.compose.material3.SliderState r21, androidx.compose.ui.Modifier r22, boolean r23, boolean r24, androidx.compose.material3.SliderColors r25, androidx.compose.foundation.interaction.MutableInteractionSource r26, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.VerticalSlider(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RangeSlider(final kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r28, final kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, boolean r31, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r32, int r33, kotlin.jvm.functions.Function0<kotlin.Unit> r34, androidx.compose.material3.SliderColors r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:243:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RangeSlider(final kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r31, final kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r32, androidx.compose.ui.Modifier r33, boolean r34, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r35, kotlin.jvm.functions.Function0<kotlin.Unit> r36, androidx.compose.material3.SliderColors r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, androidx.compose.foundation.interaction.MutableInteractionSource r39, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, int r43, androidx.compose.runtime.Composer r44, final int r45, final int r46, final int r47) {
        /*
            Method dump skipped, instruction units count: 1061
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, int, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSlider$lambda$18$lambda$17(Function1 function1, SliderRange sliderRange) {
        function1.invoke(RangesKt.rangeTo(SliderRange.m3505getStartimpl(sliderRange.m3508unboximpl()), SliderRange.m3504getEndInclusiveimpl(sliderRange.m3508unboximpl())));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RangeSlider(final androidx.compose.material3.RangeSliderState r22, androidx.compose.ui.Modifier r23, boolean r24, androidx.compose.material3.SliderColors r25, androidx.compose.foundation.interaction.MutableInteractionSource r26, androidx.compose.foundation.interaction.MutableInteractionSource r27, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function3<? super androidx.compose.material3.RangeSliderState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 646
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void SliderImpl(final Modifier modifier, final SliderState sliderState, final boolean z, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i) {
        int i2;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifierWrapContentWidth$default;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34 = function32;
        Composer composerStartRestartGroup = composer.startRestartGroup(898172835);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SliderImpl)N(modifier,state,enabled,interactionSource,thumb,track)751@33925L7,762@34446L28,806@36026L3110,773@34814L4322:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(sliderState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function34) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            function33 = function3;
            mutableInteractionSource2 = mutableInteractionSource;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(898172835, i2, -1, "androidx.compose.material3.SliderImpl (Slider.kt:750)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            sliderState.setRtl$material3(objConsume == LayoutDirection.Rtl);
            boolean z2 = (sliderState.getOrientation() == Orientation.Horizontal && sliderState.getIsRtl()) || (sliderState.getOrientation() == Orientation.Vertical && sliderState.getReverseVerticalDirection());
            Modifier modifierSliderTapModifier = sliderTapModifier(Modifier.INSTANCE, sliderState, mutableInteractionSource, z);
            Modifier.Companion companion = Modifier.INSTANCE;
            Orientation orientation$material3 = sliderState.getOrientation();
            boolean z3 = z2;
            boolean zIsDragging = sliderState.isDragging();
            Modifier.Companion companion2 = companion;
            SliderState sliderState2 = sliderState;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -144304801, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(sliderState);
            SliderKt$SliderImpl$drag$1$1 sliderKt$SliderImpl$drag$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || sliderKt$SliderImpl$drag$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                sliderKt$SliderImpl$drag$1$1RememberedValue = new SliderKt$SliderImpl$drag$1$1(sliderState, null);
                composerStartRestartGroup.updateRememberedValue(sliderKt$SliderImpl$drag$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2;
            Modifier modifierDraggable$default = DraggableKt.draggable$default(companion2, sliderState2, orientation$material3, z, mutableInteractionSource, zIsDragging, null, (Function3) sliderKt$SliderImpl$drag$1$1RememberedValue, z3, 32, null);
            mutableInteractionSource2 = mutableInteractionSource;
            if (sliderState.getOrientation() == Orientation.Vertical) {
                modifierWrapContentWidth$default = SizeKt.wrapContentHeight$default(LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.THUMB), null, false, 3, null);
            } else {
                modifierWrapContentWidth$default = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.THUMB), null, false, 3, null);
            }
            Modifier modifierThen = slideOnKeyEvents(FocusableKt.focusable(sliderSemantics(SizeKt.m1217requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), sliderState.getOrientation() == Orientation.Vertical ? TrackHeight : ThumbWidth, sliderState.getOrientation() == Orientation.Vertical ? ThumbWidth : TrackHeight, 0.0f, 0.0f, 12, null), sliderState, z), z, mutableInteractionSource2), z, sliderState.getSteps(), sliderState.getValueRange(), sliderState.getValue(), z3, sliderState.getOnValueChange(), sliderState.getOnValueChangeFinished()).then(modifierSliderTapModifier).then(modifierDraggable$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -144251159, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(sliderState);
            SliderKt$SliderImpl$2$1 sliderKt$SliderImpl$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || sliderKt$SliderImpl$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                sliderKt$SliderImpl$2$1RememberedValue = new SliderKt$SliderImpl$2$1(sliderState);
                composerStartRestartGroup.updateRememberedValue(sliderKt$SliderImpl$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) sliderKt$SliderImpl$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1885666906, "C777@34924L129,775@34844L268,784@35125L74:Slider.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1878837019, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(sliderState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.SliderImpl$lambda$29$lambda$26$lambda$25(sliderState, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierWrapContentWidth$default, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -294052009, "C782@35086L12:Slider.kt#uh7d8r");
            int i4 = (i3 >> 3) & 14;
            function33 = function3;
            function33.invoke(sliderState, composerStartRestartGroup, Integer.valueOf(((i3 >> 9) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl3 = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5069constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5069constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5077setimpl(composerM5069constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -836287744, "C784@35185L12:Slider.kt#uh7d8r");
            function34 = function32;
            function34.invoke(sliderState, composerStartRestartGroup, Integer.valueOf(((i3 >> 12) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35 = function34;
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function36 = function33;
            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.SliderImpl$lambda$31(modifier, sliderState, z, mutableInteractionSource3, function36, function35, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SliderImpl$lambda$29$lambda$26$lambda$25(SliderState sliderState, IntSize intSize) {
        sliderState.setThumbWidth$material3((int) (intSize.m9005unboximpl() >> 32));
        sliderState.setThumbHeight$material3((int) (intSize.m9005unboximpl() & 4294967295L));
        return Unit.INSTANCE;
    }

    private static final Modifier slideOnKeyEvents(Modifier modifier, final boolean z, final int i, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final float f2, final boolean z2, final Function1<? super Float, Unit> function1, final Function0<Unit> function0) {
        if (i < 0) {
            throw new IllegalArgumentException("steps should be >= 0".toString());
        }
        return KeyInputModifierKt.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.SliderKt.slideOnKeyEvents.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m3497invokeZmokQxo(keyEvent.m7133unboximpl());
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m3497invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z3 = false;
                if (!z || function1 == null) {
                    return false;
                }
                int iM7145getTypeZmokQxo = KeyEvent_androidKt.m7145getTypeZmokQxo(keyEvent);
                if (KeyEventType.m7137equalsimpl0(iM7145getTypeZmokQxo, KeyEventType.INSTANCE.m7141getKeyDownCS__XNY())) {
                    float fAbs = Math.abs(closedFloatingPointRange.getEndInclusive().floatValue() - closedFloatingPointRange.getStart().floatValue());
                    int i2 = i;
                    float f3 = fAbs / (i2 > 0 ? i2 + 1 : 100);
                    int i3 = z2 ? -1 : 1;
                    long jM7144getKeyZmokQxo = KeyEvent_androidKt.m7144getKeyZmokQxo(keyEvent);
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6903getDirectionUpEK5gGoQ())) {
                        function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f2 + (i3 * f3)), closedFloatingPointRange));
                    } else if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6898getDirectionDownEK5gGoQ())) {
                        function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f2 - (i3 * f3)), closedFloatingPointRange));
                    } else if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6902getDirectionRightEK5gGoQ())) {
                        function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f2 + (i3 * f3)), closedFloatingPointRange));
                    } else if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6901getDirectionLeftEK5gGoQ())) {
                        function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f2 - (i3 * f3)), closedFloatingPointRange));
                    } else if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6977getMoveHomeEK5gGoQ())) {
                        function1.invoke(closedFloatingPointRange.getStart());
                    } else if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6976getMoveEndEK5gGoQ())) {
                        function1.invoke(closedFloatingPointRange.getEndInclusive());
                    } else if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7024getPageUpEK5gGoQ())) {
                        function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f2 - (RangesKt.coerceIn(r2 / 10, 1, 10) * f3)), closedFloatingPointRange));
                    } else if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7023getPageDownEK5gGoQ())) {
                        function1.invoke((Float) RangesKt.coerceIn(Float.valueOf(f2 + (RangesKt.coerceIn(r2 / 10, 1, 10) * f3)), closedFloatingPointRange));
                    }
                    z3 = true;
                } else if (KeyEventType.m7137equalsimpl0(iM7145getTypeZmokQxo, KeyEventType.INSTANCE.m7142getKeyUpCS__XNY())) {
                    long jM7144getKeyZmokQxo2 = KeyEvent_androidKt.m7144getKeyZmokQxo(keyEvent);
                    if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6903getDirectionUpEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6898getDirectionDownEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6902getDirectionRightEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6901getDirectionLeftEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6977getMoveHomeEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m6976getMoveEndEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7024getPageUpEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo2, Key.INSTANCE.m7023getPageDownEK5gGoQ())) {
                        Function0<Unit> function02 = function0;
                        if (function02 != null) {
                            function02.invoke();
                        }
                        z3 = true;
                    }
                }
                return Boolean.valueOf(z3);
            }
        });
    }

    private static final void RangeSliderImpl(final Modifier modifier, final RangeSliderState rangeSliderState, final boolean z, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35 = function33;
        Composer composerStartRestartGroup = composer.startRestartGroup(-287468326);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RangeSliderImpl)N(modifier,state,enabled,startInteractionSource,endInteractionSource,startThumb,endThumb,track)971@42967L7,981@43221L35,982@43289L33,1025@45118L3284,984@43328L5074:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(rangeSliderState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function32) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function35) ? 8388608 : 4194304;
        }
        if (!composerStartRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            function34 = function32;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-287468326, i2, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:970)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            rangeSliderState.setRtl$material3(objConsume == LayoutDirection.Rtl);
            Modifier modifierRangeSliderPressDragModifier = rangeSliderPressDragModifier(Modifier.INSTANCE, rangeSliderState, mutableInteractionSource, mutableInteractionSource2, z);
            Strings.Companion companion = Strings.INSTANCE;
            final String strM4145getString2EP1pXo = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(androidx.compose.ui.R.string.range_start), composerStartRestartGroup, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            final String strM4145getString2EP1pXo2 = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(androidx.compose.ui.R.string.range_end), composerStartRestartGroup, 0);
            Modifier modifierThen = SizeKt.m1217requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2), ThumbWidth, TrackHeight, 0.0f, 0.0f, 12, null).then(modifierRangeSliderPressDragModifier);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1379067122, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(rangeSliderState);
            SliderKt$RangeSliderImpl$2$1 sliderKt$RangeSliderImpl$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || sliderKt$RangeSliderImpl$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                sliderKt$RangeSliderImpl$2$1RememberedValue = new SliderKt$RangeSliderImpl$2$1(rangeSliderState);
                composerStartRestartGroup.updateRememberedValue(sliderKt$RangeSliderImpl$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) sliderKt$RangeSliderImpl$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            int i3 = i2;
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1046432705, "C990@43545L171,995@43849L100,986@43358L723,1006@44279L167,1011@44577L98,1002@44094L709,1018@44816L79:Slider.kt#uh7d8r");
            Modifier modifierWrapContentWidth$default = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.STARTTHUMB), null, false, 3, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1905911374, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(rangeSliderState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$34$lambda$33(rangeSliderState, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierRangeSliderStartThumbSemantics = rangeSliderStartThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(modifierWrapContentWidth$default, (Function1) objRememberedValue), rangeSliderState, z);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1905921031, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strM4145getString2EP1pXo);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$36$lambda$35(strM4145getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFocusable = FocusableKt.focusable(SemanticsModifierKt.semantics(modifierRangeSliderStartThumbSemantics, true, (Function1) objRememberedValue2), z, mutableInteractionSource);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusable);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 239610549, "C1000@44050L17:Slider.kt#uh7d8r");
            int i4 = (i3 >> 3) & 14;
            function3.invoke(rangeSliderState, composerStartRestartGroup, Integer.valueOf(((i3 >> 12) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierWrapContentWidth$default2 = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.ENDTHUMB), null, false, 3, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1905934858, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(rangeSliderState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$39$lambda$38(rangeSliderState, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierRangeSliderEndThumbSemantics = rangeSliderEndThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(modifierWrapContentWidth$default2, (Function1) objRememberedValue3), rangeSliderState, z);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1905944325, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(strM4145getString2EP1pXo2);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$41$lambda$40(strM4145getString2EP1pXo2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFocusable2 = FocusableKt.focusable(SemanticsModifierKt.semantics(modifierRangeSliderEndThumbSemantics, true, (Function1) objRememberedValue4), z, mutableInteractionSource2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusable2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl3 = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5069constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5069constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5077setimpl(composerM5069constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 85810862, "C1016@44774L15:Slider.kt#uh7d8r");
            function34 = function32;
            function34.invoke(rangeSliderState, composerStartRestartGroup, Integer.valueOf(((i3 >> 15) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl4 = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM5069constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM5069constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m5077setimpl(composerM5069constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -979172334, "C1018@44881L12:Slider.kt#uh7d8r");
            Integer numValueOf = Integer.valueOf(((i3 >> 18) & 112) | i4);
            function35 = function33;
            function35.invoke(rangeSliderState, composerStartRestartGroup, numValueOf);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36 = function34;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.RangeSliderImpl$lambda$46(modifier, rangeSliderState, z, mutableInteractionSource, mutableInteractionSource2, function3, function36, function35, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSliderImpl$lambda$44$lambda$34$lambda$33(RangeSliderState rangeSliderState, IntSize intSize) {
        rangeSliderState.setStartThumbWidth$material3((int) (intSize.m9005unboximpl() >> 32));
        rangeSliderState.setStartThumbHeight$material3((int) (intSize.m9005unboximpl() & 4294967295L));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSliderImpl$lambda$44$lambda$36$lambda$35(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSliderImpl$lambda$44$lambda$39$lambda$38(RangeSliderState rangeSliderState, IntSize intSize) {
        rangeSliderState.setEndThumbWidth$material3((int) (intSize.m9005unboximpl() >> 32));
        rangeSliderState.setEndThumbHeight$material3((int) (intSize.m9005unboximpl() & 4294967295L));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSliderImpl$lambda$44$lambda$41$lambda$40(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m3493awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material3.SliderKt$awaitSlop$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = (androidx.compose.material3.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = new androidx.compose.material3.SliderKt$awaitSlop$1
            r0.<init>(r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r8 = r6.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L55
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2 r5 = new androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
            r5.<init>()
            r6.L$0 = r12
            r6.label = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = androidx.compose.material3.internal.DragGestureDetectorCopyKt.m4052awaitHorizontalPointerSlopOrCancellationgDDlDlE(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L52
            return r0
        L52:
            r7 = r12
            r12 = r8
            r8 = r7
        L55:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto L64
            float r8 = r8.element
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r12, r8)
            return r8
        L64:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.m3493awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit awaitSlop_8vUncbI$lambda$49(Ref.FloatRef floatRef, PointerInputChange pointerInputChange, float f2) {
        pointerInputChange.consume();
        floatRef.element = f2;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int i) {
        if (i == 0) {
            return new float[0];
        }
        int i2 = i + 2;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = i3 / (i + 1);
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float f2, float f3, float f4, float f5, float f6) {
        return MathHelpersKt.lerp(f5, f6, calcFraction(f2, f3, f4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: scale-2geJ7wY, reason: not valid java name */
    public static final long m3496scale2geJ7wY(boolean z, float f2, float f3, long j, float f4, float f5) {
        float fScale = scale(f2, f3, SliderRange.m3505getStartimpl(j), f4, f5);
        float fScale2 = scale(f2, f3, SliderRange.m3504getEndInclusiveimpl(j), f4, f5);
        if (z) {
            return SliderRange(RangesKt.coerceAtMost(fScale, fScale2), fScale2);
        }
        return SliderRange(fScale, RangesKt.coerceAtLeast(fScale2, fScale));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calcFraction(float f2, float f3, float f4) {
        float f5 = f3 - f2;
        return RangesKt.coerceIn(f5 == 0.0f ? 0.0f : (f4 - f2) / f5, 0.0f, 1.0f);
    }

    private static final Modifier sliderSemantics(Modifier modifier, final SliderState sliderState, final boolean z) {
        Modifier increaseHorizontalSemanticsBounds;
        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderKt.sliderSemantics$lambda$52(z, sliderState, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null);
        if (sliderState.getOrientation() == Orientation.Vertical) {
            increaseHorizontalSemanticsBounds = AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds();
        } else {
            increaseHorizontalSemanticsBounds = AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds();
        }
        return ProgressSemanticsKt.progressSemantics(modifierSemantics$default.then(increaseHorizontalSemanticsBounds), sliderState.getValue(), RangesKt.rangeTo(sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue()), sliderState.getSteps());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sliderSemantics$lambda$52(boolean z, final SliderState sliderState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!z) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, formatForSemantics(sliderState.getValue()));
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SliderKt.sliderSemantics$lambda$52$lambda$51(sliderState, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sliderSemantics$lambda$52$lambda$51(SliderState sliderState, float f2) {
        int steps;
        float fCoerceIn = RangesKt.coerceIn(f2, sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue());
        if (sliderState.getSteps() > 0 && (steps = sliderState.getSteps() + 1) >= 0) {
            float fAbs = fCoerceIn;
            float f3 = fAbs;
            int i = 0;
            while (true) {
                float fLerp = MathHelpersKt.lerp(sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue(), i / (sliderState.getSteps() + 1));
                float f4 = fLerp - fCoerceIn;
                if (Math.abs(f4) <= fAbs) {
                    fAbs = Math.abs(f4);
                    f3 = fLerp;
                }
                if (i == steps) {
                    break;
                }
                i++;
            }
            fCoerceIn = f3;
        }
        if (fCoerceIn == sliderState.getValue()) {
            return false;
        }
        if (fCoerceIn != sliderState.getValue()) {
            if (sliderState.getOnValueChange() != null) {
                Function1<Float, Unit> onValueChange = sliderState.getOnValueChange();
                if (onValueChange != null) {
                    onValueChange.invoke(Float.valueOf(fCoerceIn));
                }
            } else {
                sliderState.setValue(fCoerceIn);
            }
        }
        Function0<Unit> onValueChangeFinished = sliderState.getOnValueChangeFinished();
        if (onValueChangeFinished != null) {
            onValueChangeFinished.invoke();
        }
        return true;
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z) {
        final ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(rangeSliderState.getValueRange().getStart().floatValue(), rangeSliderState.getActiveRangeEnd());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderKt.rangeSliderStartThumbSemantics$lambda$55(z, rangeSliderState, closedFloatingPointRangeRangeTo, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), rangeSliderState.getActiveRangeStart(), closedFloatingPointRangeRangeTo, rangeSliderState.getStartSteps$material3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rangeSliderStartThumbSemantics$lambda$55(boolean z, final RangeSliderState rangeSliderState, final ClosedFloatingPointRange closedFloatingPointRange, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!z) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, formatForSemantics(rangeSliderState.getActiveRangeStart()));
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SliderKt.rangeSliderStartThumbSemantics$lambda$55$lambda$54(closedFloatingPointRange, rangeSliderState, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean rangeSliderStartThumbSemantics$lambda$55$lambda$54(ClosedFloatingPointRange closedFloatingPointRange, RangeSliderState rangeSliderState, float f2) {
        int startSteps$material3;
        float fCoerceIn = RangesKt.coerceIn(f2, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
        if (rangeSliderState.getStartSteps$material3() > 0 && (startSteps$material3 = rangeSliderState.getStartSteps$material3() + 1) >= 0) {
            float fAbs = fCoerceIn;
            float f3 = fAbs;
            int i = 0;
            while (true) {
                float fLerp = MathHelpersKt.lerp(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i / (rangeSliderState.getStartSteps$material3() + 1));
                float f4 = fLerp - fCoerceIn;
                if (Math.abs(f4) <= fAbs) {
                    fAbs = Math.abs(f4);
                    f3 = fLerp;
                }
                if (i == startSteps$material3) {
                    break;
                }
                i++;
            }
            fCoerceIn = f3;
        }
        if (fCoerceIn == rangeSliderState.getActiveRangeStart()) {
            return false;
        }
        long jSliderRange = SliderRange(fCoerceIn, rangeSliderState.getActiveRangeEnd());
        if (!SliderRange.m3503equalsimpl0(jSliderRange, SliderRange(rangeSliderState.getActiveRangeStart(), rangeSliderState.getActiveRangeEnd()))) {
            if (rangeSliderState.getOnValueChange$material3() != null) {
                Function1<SliderRange, Unit> onValueChange$material3 = rangeSliderState.getOnValueChange$material3();
                if (onValueChange$material3 != null) {
                    onValueChange$material3.invoke(SliderRange.m3500boximpl(jSliderRange));
                }
            } else {
                rangeSliderState.setActiveRangeStart(SliderRange.m3505getStartimpl(jSliderRange));
                rangeSliderState.setActiveRangeEnd(SliderRange.m3504getEndInclusiveimpl(jSliderRange));
            }
        }
        Function0<Unit> onValueChangeFinished = rangeSliderState.getOnValueChangeFinished();
        if (onValueChangeFinished != null) {
            onValueChangeFinished.invoke();
        }
        return true;
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z) {
        final ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(rangeSliderState.getActiveRangeStart(), rangeSliderState.getValueRange().getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderKt.rangeSliderEndThumbSemantics$lambda$58(z, rangeSliderState, closedFloatingPointRangeRangeTo, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), rangeSliderState.getActiveRangeEnd(), closedFloatingPointRangeRangeTo, rangeSliderState.getEndSteps$material3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rangeSliderEndThumbSemantics$lambda$58(boolean z, final RangeSliderState rangeSliderState, final ClosedFloatingPointRange closedFloatingPointRange, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!z) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, formatForSemantics(rangeSliderState.getActiveRangeEnd()));
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SliderKt.rangeSliderEndThumbSemantics$lambda$58$lambda$57(closedFloatingPointRange, rangeSliderState, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean rangeSliderEndThumbSemantics$lambda$58$lambda$57(ClosedFloatingPointRange closedFloatingPointRange, RangeSliderState rangeSliderState, float f2) {
        int endSteps$material3;
        float fCoerceIn = RangesKt.coerceIn(f2, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
        if (rangeSliderState.getEndSteps$material3() > 0 && (endSteps$material3 = rangeSliderState.getEndSteps$material3() + 1) >= 0) {
            float fAbs = fCoerceIn;
            float f3 = fAbs;
            int i = 0;
            while (true) {
                float fLerp = MathHelpersKt.lerp(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i / (rangeSliderState.getEndSteps$material3() + 1));
                float f4 = fLerp - fCoerceIn;
                if (Math.abs(f4) <= fAbs) {
                    fAbs = Math.abs(f4);
                    f3 = fLerp;
                }
                if (i == endSteps$material3) {
                    break;
                }
                i++;
            }
            fCoerceIn = f3;
        }
        if (fCoerceIn == rangeSliderState.getActiveRangeEnd()) {
            return false;
        }
        long jSliderRange = SliderRange(rangeSliderState.getActiveRangeStart(), fCoerceIn);
        if (!SliderRange.m3503equalsimpl0(jSliderRange, SliderRange(rangeSliderState.getActiveRangeStart(), rangeSliderState.getActiveRangeEnd()))) {
            if (rangeSliderState.getOnValueChange$material3() != null) {
                Function1<SliderRange, Unit> onValueChange$material3 = rangeSliderState.getOnValueChange$material3();
                if (onValueChange$material3 != null) {
                    onValueChange$material3.invoke(SliderRange.m3500boximpl(jSliderRange));
                }
            } else {
                rangeSliderState.setActiveRangeStart(SliderRange.m3505getStartimpl(jSliderRange));
                rangeSliderState.setActiveRangeEnd(SliderRange.m3504getEndInclusiveimpl(jSliderRange));
            }
        }
        Function0<Unit> onValueChangeFinished = rangeSliderState.getOnValueChangeFinished();
        if (onValueChangeFinished != null) {
            onValueChangeFinished.invoke();
        }
        return true;
    }

    private static final String formatForSemantics(float f2) {
        return String.valueOf(MathKt.roundToInt(f2 * 100) / 100.0f);
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class C04081 implements PointerInputEventHandler {
        final /* synthetic */ SliderState $state;

        C04081(SliderState sliderState) {
            this.$state = sliderState;
        }

        /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Slider.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$1$1", f = "Slider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00521 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
            final /* synthetic */ SliderState $state;
            /* synthetic */ long J$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00521(SliderState sliderState, Continuation<? super C00521> continuation) {
                super(3, continuation);
                this.$state = sliderState;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                return m3499invoked4ec7I(pressGestureScope, offset.m5733unboximpl(), continuation);
            }

            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
            public final Object m3499invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                C00521 c00521 = new C00521(this.$state, continuation);
                c00521.J$0 = j;
                return c00521.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$state.m3511onPressk4lQ0M$material3(this.J$0);
                return Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            C00521 c00521 = new C00521(this.$state, null);
            final SliderState sliderState = this.$state;
            Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, c00521, new Function1() { // from class: androidx.compose.material3.SliderKt$sliderTapModifier$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SliderKt.C04081.invoke$lambda$0(sliderState, (Offset) obj);
                }
            }, continuation, 3, null);
            return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$0(SliderState sliderState, Offset offset) {
            sliderState.dispatchRawDelta(0.0f);
            sliderState.getGestureEndAction$material3().invoke();
            return Unit.INSTANCE;
        }
    }

    private static final Modifier sliderTapModifier(Modifier modifier, SliderState sliderState, MutableInteractionSource mutableInteractionSource, boolean z) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, sliderState, mutableInteractionSource, new C04081(sliderState)) : modifier;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier modifier, final RangeSliderState rangeSliderState, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, boolean z) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, rangeSliderState}, new PointerInputEventHandler() { // from class: androidx.compose.material3.SliderKt.rangeSliderPressDragModifier.1

            /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Slider.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", i = {}, l = {2437}, m = "invokeSuspend", n = {}, s = {})
            static final class C00501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ RangeSliderState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00501(PointerInputScope pointerInputScope, RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, Continuation<? super C00501> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = rangeSliderState;
                    this.$rangeSliderLogic = rangeSliderLogic;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00501 c00501 = new C00501(this.$this_pointerInput, this.$state, this.$rangeSliderLogic, continuation);
                    c00501.L$0 = obj;
                    return c00501;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Slider.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", i = {0, 1, 1, 1, 1, 1, 2, 2}, l = {2438, 2450, 2473}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "event", "interaction", "posX", "draggingStart", "interaction", "draggingStart"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
                static final class C00511 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    final /* synthetic */ RangeSliderState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00511(RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, CoroutineScope coroutineScope, Continuation<? super C00511> continuation) {
                        super(2, continuation);
                        this.$state = rangeSliderState;
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$$this$coroutineScope = coroutineScope;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00511 c00511 = new C00511(this.$state, this.$rangeSliderLogic, this.$$this$coroutineScope, continuation);
                        c00511.L$0 = obj;
                        return c00511;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00511) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:38:0x00f5  */
                    /* JADX WARN: Removed duplicated region for block: B:56:0x018a  */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x0194 A[Catch: all -> 0x0026, CancellationException -> 0x01a6, TryCatch #0 {all -> 0x0026, blocks: (B:8:0x001f, B:57:0x018c, B:59:0x0194, B:60:0x019c, B:63:0x01a6, B:53:0x0164), top: B:69:0x000f }] */
                    /* JADX WARN: Removed duplicated region for block: B:60:0x019c A[Catch: all -> 0x0026, CancellationException -> 0x01a6, TRY_LEAVE, TryCatch #0 {all -> 0x0026, blocks: (B:8:0x001f, B:57:0x018c, B:59:0x0194, B:60:0x019c, B:63:0x01a6, B:53:0x0164), top: B:69:0x000f }] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
                        /*
                            Method dump skipped, instruction units count: 477
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.C04061.C00501.C00511.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invokeSuspend$lambda$1(RangeSliderState rangeSliderState, Ref.BooleanRef booleanRef, PointerInputChange pointerInputChange) {
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (PointerEventKt.positionChange(pointerInputChange) >> 32));
                        boolean z = booleanRef.element;
                        if (rangeSliderState.isRtl$material3()) {
                            fIntBitsToFloat = -fIntBitsToFloat;
                        }
                        rangeSliderState.onDrag$material3(z, fIntBitsToFloat);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Slider.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", i = {}, l = {2493}, m = "invokeSuspend", n = {}, s = {})
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Ref.BooleanRef $draggingStart;
                        final /* synthetic */ DragInteraction $finishInteraction;
                        final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.$rangeSliderLogic = rangeSliderLogic;
                            this.$draggingStart = booleanRef;
                            this.$finishInteraction = dragInteraction;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$rangeSliderLogic.activeInteraction(this.$draggingStart.element).emit(this.$finishInteraction, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C00511(this.$state, this.$rangeSliderLogic, coroutineScope, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C00501(pointerInputScope, rangeSliderState, new RangeSliderLogic(rangeSliderState, mutableInteractionSource, mutableInteractionSource2), null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }) : modifier;
    }

    static {
        float fM4790getHandleWidthD9Ej5fM = SliderTokens.INSTANCE.m4790getHandleWidthD9Ej5fM();
        ThumbWidth = fM4790getHandleWidthD9Ej5fM;
        float fM4789getHandleHeightD9Ej5fM = SliderTokens.INSTANCE.m4789getHandleHeightD9Ej5fM();
        ThumbHeight = fM4789getHandleHeightD9Ej5fM;
        ThumbSize = DpKt.m8852DpSizeYgX7TsA(fM4790getHandleWidthD9Ej5fM, fM4789getHandleHeightD9Ej5fM);
        VerticalThumbSize = DpKt.m8852DpSizeYgX7TsA(fM4789getHandleHeightD9Ej5fM, fM4790getHandleWidthD9Ej5fM);
        ThumbTrackGapSize = SliderTokens.INSTANCE.m4782getActiveHandleLeadingSpaceD9Ej5fM();
        TrackInsideCornerSize = Dp.m8830constructorimpl(2);
        CornerSizeAlignmentLine = new VerticalAlignmentLine(SliderKt$CornerSizeAlignmentLine$1.INSTANCE);
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final SliderState rememberSliderState(final float f2, final int i, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1193499219, "C(rememberSliderState)N(value,steps,onValueChangeFinished,valueRange)2912@125235L188,2912@125156L267:Slider.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        if ((i3 & 8) != 0) {
            closedFloatingPointRange = RangesKt.rangeTo(0.0f, 1.0f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1193499219, i2, -1, "androidx.compose.material3.rememberSliderState (Slider.kt:2911)");
        }
        Object[] objArr = new Object[0];
        Saver<SliderState, ?> Saver = SliderState.INSTANCE.Saver(function0, closedFloatingPointRange);
        ComposerKt.sourceInformationMarkerStart(composer, 196492495, "CC(remember):Slider.kt#9igjgp");
        boolean z = true;
        boolean z2 = ((((i2 & 14) ^ 6) > 4 && composer.changed(f2)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(i)) || (i2 & 48) == 32) | ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(function0)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        if ((((i2 & 7168) ^ 3072) <= 2048 || !composer.changed(closedFloatingPointRange)) && (i2 & 3072) != 2048) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SliderKt.rememberSliderState$lambda$60$lambda$59(f2, i, function0, closedFloatingPointRange);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SliderState sliderState = (SliderState) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sliderState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SliderState rememberSliderState$lambda$60$lambda$59(float f2, int i, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange) {
        return new SliderState(f2, i, function0, closedFloatingPointRange);
    }

    public static final RangeSliderState rememberRangeSliderState(float f2, float f3, int i, Function0<Unit> function0, ClosedFloatingPointRange<Float> closedFloatingPointRange, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 756708139, "C(rememberRangeSliderState)N(activeRangeStart,activeRangeEnd,steps,onValueChangeFinished,valueRange)3126@135179L260,3126@135095L344:Slider.kt#uh7d8r");
        final float f4 = (i3 & 1) != 0 ? 0.0f : f2;
        final float f5 = (i3 & 2) != 0 ? 1.0f : f3;
        final int i4 = (i3 & 4) != 0 ? 0 : i;
        final Function0<Unit> function02 = (i3 & 8) != 0 ? null : function0;
        final ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = (i3 & 16) != 0 ? RangesKt.rangeTo(0.0f, 1.0f) : closedFloatingPointRange;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(756708139, i2, -1, "androidx.compose.material3.rememberRangeSliderState (Slider.kt:3125)");
        }
        Object[] objArr = new Object[0];
        Saver<RangeSliderState, ?> Saver = RangeSliderState.INSTANCE.Saver(function02, closedFloatingPointRangeRangeTo);
        ComposerKt.sourceInformationMarkerStart(composer, 1347061551, "CC(remember):Slider.kt#9igjgp");
        boolean z = true;
        boolean z2 = ((((i2 & 14) ^ 6) > 4 && composer.changed(f4)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(f5)) || (i2 & 48) == 32) | ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(i4)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(function02)) || (i2 & 3072) == 2048);
        if ((((57344 & i2) ^ 24576) <= 16384 || !composer.changed(closedFloatingPointRangeRangeTo)) && (i2 & 24576) != 16384) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Function0 function03 = new Function0() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SliderKt.rememberRangeSliderState$lambda$62$lambda$61(f4, f5, i4, function02, closedFloatingPointRangeRangeTo);
                }
            };
            composer.updateRememberedValue(function03);
            objRememberedValue = function03;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        RangeSliderState rangeSliderState = (RangeSliderState) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rangeSliderState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RangeSliderState rememberRangeSliderState$lambda$62$lambda$61(float f2, float f3, int i, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange) {
        return new RangeSliderState(f2, f3, i, function0, closedFloatingPointRange);
    }

    public static final long SliderRange(float f2, float f3) {
        if ((!Float.isNaN(f2) || !Float.isNaN(f3)) && f2 > f3) {
            throw new IllegalArgumentException(("start(" + f2 + ") must be <= endInclusive(" + f3 + ')').toString());
        }
        return SliderRange.m3501constructorimpl((((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
    }

    public static final long SliderRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        float fFloatValue = closedFloatingPointRange.getStart().floatValue();
        float fFloatValue2 = closedFloatingPointRange.getEndInclusive().floatValue();
        if ((!Float.isNaN(fFloatValue) || !Float.isNaN(fFloatValue2)) && fFloatValue > fFloatValue2) {
            throw new IllegalArgumentException(("ClosedFloatingPointRange<Float>.start(" + fFloatValue + ") must be <= ClosedFloatingPoint.endInclusive(" + fFloatValue2 + ')').toString());
        }
        return SliderRange.m3501constructorimpl((((long) Float.floatToRawIntBits(fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(fFloatValue2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: isSpecified-If1S1O4, reason: not valid java name */
    public static final boolean m3494isSpecifiedIf1S1O4(long j) {
        return j != SliderRange.INSTANCE.m3510getUnspecifiedFYbKRX4();
    }

    public static final VerticalAlignmentLine getCornerSizeAlignmentLine() {
        return CornerSizeAlignmentLine;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float snapValueToTick(float f2, float[] fArr, float f3, float f4) {
        Float fValueOf;
        if (fArr.length == 0) {
            fValueOf = null;
        } else {
            float f5 = fArr[0];
            int lastIndex = ArraysKt.getLastIndex(fArr);
            if (lastIndex != 0) {
                float fAbs = Math.abs(MathHelpersKt.lerp(f3, f4, f5) - f2);
                int i = 1;
                if (1 <= lastIndex) {
                    while (true) {
                        float f6 = fArr[i];
                        float fAbs2 = Math.abs(MathHelpersKt.lerp(f3, f4, f6) - f2);
                        if (Float.compare(fAbs, fAbs2) > 0) {
                            f5 = f6;
                            fAbs = fAbs2;
                        }
                        if (i == lastIndex) {
                            break;
                        }
                        i++;
                    }
                }
                fValueOf = Float.valueOf(f5);
            } else {
                fValueOf = Float.valueOf(f5);
            }
        }
        return fValueOf != null ? MathHelpersKt.lerp(f3, f4, fValueOf.floatValue()) : f2;
    }
}
