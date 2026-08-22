package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.variables.CTVariableUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a)\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a3\u0010\u001b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#\u001aJ\u0010$\u001a\u00020\u0001*\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0(H\u0082@¢\u0006\u0004\b)\u0010*\u001a1\u0010/\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0013H\u0001¢\u0006\u0002\u00100\u001a1\u00101\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0013H\u0001¢\u0006\u0002\u00100\u001a%\u00102\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u00103\u001a\u001d\u00104\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00105\u001a\u001d\u00106\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00105\u001a\u001d\u00107\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00105\u001a%\u00108\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00109\u001a%\u0010:\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00109\u001a=\u0010;\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?H\u0003¢\u0006\u0002\u0010A\u001aQ\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020?2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00010F2\u0006\u0010\u0006\u001a\u00020\u00072\u001c\u0010G\u001a\u0018\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00010H¢\u0006\u0002\bJ¢\u0006\u0002\bKH\u0003¢\u0006\u0002\u0010L\u001a\u0015\u0010M\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010N\u001a7\u0010O\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0004\bS\u0010T\u001a-\u0010U\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010V\u001a\u001c\u0010W\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a-\u0010X\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020%2\u0006\u0010P\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010Y\u001ah\u0010Z\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010P\u001a\u00020[2\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020\u00102\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00130_2!\u0010`\u001a\u001d\u0012\u0013\u0012\u00110[¢\u0006\f\ba\u0012\b\bb\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u00010HH\u0002¢\u0006\u0004\bc\u0010d\u001a_\u0010e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010P\u001a\u00020[2\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\u00010H2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010g\u001a\u00020h2\b\b\u0002\u0010i\u001a\u00020j2\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0004\bk\u0010l\u001a4\u0010m\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010n\u001a\u00020\u001d2\u0011\u0010G\u001a\r\u0012\u0004\u0012\u00020\u00010F¢\u0006\u0002\bJH\u0003¢\u0006\u0002\u0010o\u001a'\u0010p\u001a\u00020q2\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010r\u001a\u00020\u0010H\u0001¢\u0006\u0004\bs\u0010t\u001a(\u0010u\u001a\u00020\u001d2\u0006\u0010v\u001a\u00020\u001d2\u0006\u0010w\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u0010H\u0002\u001a\u0018\u0010z\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u0016\u0010\u009d\u0001\u001a\u00020\u0005*\u00020\u00052\u0007\u0010\u009d\u0001\u001a\u00020\u0013H\u0003\"\u0015\u0010\u0015\u001a\u00020\u0013*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0018\u0010\u0018\u001a\u00020\u0010*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0018\u0010+\u001a\u00020,*\u00020%8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u001a\u0010{\u001a\u00020\t8AX\u0080\u0004¢\u0006\f\u0012\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u000f\u0010\u0080\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0081\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0084\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0085\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0086\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0087\u0001\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000f\u0010\u0088\u0001\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u008c\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u008d\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u008e\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u008f\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u0090\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u0091\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0010\u0010\u0092\u0001\u001a\u00030\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0094\u0001\u001a\u00030\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0095\u0001\u001a\u00030\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0096\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u0097\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u0098\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u0099\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u001b\u0010\u009a\u0001\u001a\u00030\u008a\u0001X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008b\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001¨\u0006\u009e\u0001²\u0006\u000b\u0010\u009f\u0001\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\u000b\u0010 \u0001\u001a\u00020[X\u008a\u008e\u0002²\u0006\u000b\u0010¡\u0001\u001a\u00020[X\u008a\u008e\u0002²\u0006\u000b\u0010 \u001a\u00030¢\u0001X\u008a\u008e\u0002²\u0006\u000b\u0010£\u0001\u001a\u00020!X\u008a\u008e\u0002²\u0006\f\u0010¤\u0001\u001a\u00030¥\u0001X\u008a\u008e\u0002²\u0006\u000b\u0010¦\u0001\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"TimePicker", "", "state", "Landroidx/compose/material3/TimePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "Landroidx/compose/material3/TimePickerColors;", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "rememberTimePickerState", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "isPm", "(Landroidx/compose/material3/TimePickerState;)Z", "TimePickerState", "hourForDisplay", "getHourForDisplay", "(Landroidx/compose/material3/TimePickerState;)I", "moveSelector", "x", "", "y", "maxDist", "center", "Landroidx/compose/ui/unit/IntOffset;", "moveSelector-d3b8Pxo", "(Landroidx/compose/material3/TimePickerState;FFFJ)V", "onTap", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "onTap-uYHVD98", "(Landroidx/compose/material3/AnalogTimePickerState;FFFZJLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos", "(Landroidx/compose/material3/AnalogTimePickerState;)J", "VerticalTimePicker", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "HorizontalTimePicker", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "ClockDisplayNumbers", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalPeriodToggle", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", "onClick", "Lkotlin/Function0;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "TimeSelector", "value", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "TimeSelector-SAnMeKU", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ClockFace", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "drawSelector", "ClockText", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "timeInputOnChange", "Landroidx/compose/ui/text/input/TextFieldValue;", "prevValue", Constants.PRIORITY_MAX, "userOverride", "Landroidx/compose/ui/node/Ref;", "onNewValue", "Lkotlin/ParameterName;", "name", "timeInputOnChange-_K77t-0", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILandroidx/compose/ui/node/Ref;Lkotlin/jvm/functions/Function1;)V", "TimePickerTextField", "onValueChange", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-1vLObsk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "CircularLayout", "radiusToSizeRatio", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "numberContentDescription", "", CTVariableUtils.NUMBER, "numberContentDescription-dSwYdS4", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "dist", "x1", "y1", "x2", "y2", "atan", "defaultTimePickerLayoutType", "getDefaultTimePickerLayoutType$annotations", "()V", "getDefaultTimePickerLayoutType", "(Landroidx/compose/runtime/Composer;I)I", "FullCircle", "HalfCircle", "QuarterCircle", "", "RadiansPerMinute", "RadiansPerHour", "SeparatorZIndex", "OuterCircleToSizeRatio", "InnerCircleToSizeRatio", "ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "SupportLabelTop", "TimeInputBottomPadding", "MaxDistance", "MinimumInteractiveSize", "Minutes", "Landroidx/collection/IntList;", "Hours", "ExtraHours", "PeriodToggleMargin", "TimePickerMaxHeight", "TimePickerMidHeight", "ClockDialMidContainerSize", "ClockDialMinContainerSize", "getClockDialMinContainerSize", "()F", "visible", "material3", "a11yServicesEnabled", "hourValue", "minuteValue", "Landroidx/compose/ui/geometry/Offset;", "parentCenter", "boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "selected"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TimePickerKt {
    private static final float ClockDialMidContainerSize;
    private static final float ClockDialMinContainerSize;
    private static final float ClockFaceBottomMargin;
    private static final float DisplaySeparatorWidth;
    private static final IntList ExtraHours;
    private static final float FullCircle = 6.2831855f;
    private static final float HalfCircle = 3.1415927f;
    private static final IntList Hours;
    private static final float PeriodToggleMargin;
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float TimeInputBottomPadding;
    private static final float TimePickerMaxHeight;
    private static final float TimePickerMidHeight;
    private static final float OuterCircleToSizeRatio = Dp.m8830constructorimpl(101) / TimePickerTokens.INSTANCE.m4876getClockDialContainerSizeD9Ej5fM();
    private static final float InnerCircleToSizeRatio = Dp.m8830constructorimpl(69) / TimePickerTokens.INSTANCE.m4876getClockDialContainerSizeD9Ej5fM();
    private static final float ClockDisplayBottomMargin = Dp.m8830constructorimpl(36);
    private static final float SupportLabelTop = Dp.m8830constructorimpl(7);
    private static final float MaxDistance = Dp.m8830constructorimpl(74);
    private static final float MinimumInteractiveSize = Dp.m8830constructorimpl(48);
    private static final IntList Minutes = IntListKt.intListOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularLayout$lambda$96(Modifier modifier, float f2, Function2 function2, int i, int i2, Composer composer, int i3) {
        CircularLayout(modifier, f2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockDisplayNumbers$lambda$35(TimePickerState timePickerState, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        ClockDisplayNumbers(timePickerState, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockFace$lambda$60(Modifier modifier, AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors, boolean z, int i, Composer composer, int i2) {
        ClockFace(modifier, analogTimePickerState, timePickerColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockText$lambda$84(Modifier modifier, AnalogTimePickerState analogTimePickerState, int i, boolean z, int i2, Composer composer, int i3) {
        ClockText(modifier, analogTimePickerState, i, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplaySeparator$lambda$54(Modifier modifier, int i, Composer composer, int i2) {
        DisplaySeparator(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalClockDisplay$lambda$31(TimePickerState timePickerState, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        HorizontalClockDisplay(timePickerState, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalPeriodToggle$lambda$37(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        HorizontalPeriodToggle(modifier, timePickerState, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalTimePicker$lambda$15(AnalogTimePickerState analogTimePickerState, Modifier modifier, TimePickerColors timePickerColors, boolean z, int i, int i2, Composer composer, int i3) {
        HorizontalTimePicker(analogTimePickerState, modifier, timePickerColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PeriodToggleImpl$lambda$47(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, MeasurePolicy measurePolicy, Shape shape, Shape shape2, int i, Composer composer, int i2) {
        PeriodToggleImpl(modifier, timePickerState, timePickerColors, measurePolicy, shape, shape2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeInput$lambda$5(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, int i2, Composer composer, int i3) {
        TimeInput(timePickerState, modifier, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeInputImpl$lambda$28(Modifier modifier, TimePickerColors timePickerColors, TimePickerState timePickerState, int i, Composer composer, int i2) {
        TimeInputImpl(modifier, timePickerColors, timePickerState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerTextField_1vLObsk$lambda$94(Modifier modifier, TextFieldValue textFieldValue, Function1 function1, TimePickerState timePickerState, int i, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, TimePickerColors timePickerColors, int i2, int i3, Composer composer, int i4) {
        m3756TimePickerTextField1vLObsk(modifier, textFieldValue, function1, timePickerState, i, keyboardOptions, keyboardActions, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePicker_mT9BvqQ$lambda$4(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, int i2, int i3, Composer composer, int i4) {
        m3755TimePickermT9BvqQ(timePickerState, modifier, timePickerColors, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeSelector_SAnMeKU$lambda$59(Modifier modifier, int i, TimePickerState timePickerState, int i2, TimePickerColors timePickerColors, int i3, Composer composer, int i4) {
        m3757TimeSelectorSAnMeKU(modifier, i, timePickerState, i2, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleItem$lambda$50(boolean z, Shape shape, Function0 function0, TimePickerColors timePickerColors, Function3 function3, int i, Composer composer, int i2) {
        ToggleItem(z, shape, function0, timePickerColors, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalClockDisplay$lambda$34(TimePickerState timePickerState, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        VerticalClockDisplay(timePickerState, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalPeriodToggle$lambda$39(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, int i, Composer composer, int i2) {
        VerticalPeriodToggle(modifier, timePickerState, timePickerColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalTimePicker$lambda$11(AnalogTimePickerState analogTimePickerState, Modifier modifier, TimePickerColors timePickerColors, boolean z, int i, int i2, Composer composer, int i3) {
        VerticalTimePicker(analogTimePickerState, modifier, timePickerColors, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getDefaultTimePickerLayoutType$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0146  */
    /* JADX INFO: renamed from: TimePicker-mT9BvqQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3755TimePickermT9BvqQ(final androidx.compose.material3.TimePickerState r17, androidx.compose.ui.Modifier r18, androidx.compose.material3.TimePickerColors r19, int r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m3755TimePickermT9BvqQ(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TimeInput(final androidx.compose.material3.TimePickerState r7, androidx.compose.ui.Modifier r8, androidx.compose.material3.TimePickerColors r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.TimeInput(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final TimePickerState rememberTimePickerState(final int i, final int i2, final boolean z, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 1237715277, "C(rememberTimePickerState)N(initialHour,initialMinute,is24Hour)586@29390L14,589@29526L185,589@29472L239:TimePicker.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = TimeFormat_androidKt.is24HourFormat(composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1237715277, i3, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:587)");
        }
        Object[] objArr = new Object[0];
        Saver<TimePickerStateImpl, ?> Saver = TimePickerStateImpl.INSTANCE.Saver();
        ComposerKt.sourceInformationMarkerStart(composer, -261550618, "CC(remember):TimePicker.kt#9igjgp");
        boolean z2 = true;
        boolean z3 = ((((i3 & 14) ^ 6) > 4 && composer.changed(i)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(i2)) || (i3 & 48) == 32);
        if ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !composer.changed(z)) && (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
            z2 = false;
        }
        boolean z4 = z3 | z2;
        Object objRememberedValue = composer.rememberedValue();
        if (z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TimePickerKt.rememberTimePickerState$lambda$7$lambda$6(i, i2, z);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TimePickerStateImpl timePickerStateImpl = (TimePickerStateImpl) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return timePickerStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerStateImpl rememberTimePickerState$lambda$7$lambda$6(int i, int i2, boolean z) {
        return new TimePickerStateImpl(i, i2, z);
    }

    public static final boolean isPm(TimePickerState timePickerState) {
        return timePickerState.getHour() >= 12;
    }

    public static final TimePickerState TimePickerState(int i, int i2, boolean z) {
        return new TimePickerStateImpl(i, i2, z);
    }

    public static final int getHourForDisplay(TimePickerState timePickerState) {
        if (timePickerState.getIs24hour()) {
            return timePickerState.getHour() % 24;
        }
        if (timePickerState.getHour() % 12 == 0) {
            return 12;
        }
        return isPm(timePickerState) ? timePickerState.getHour() - 12 : timePickerState.getHour();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: moveSelector-d3b8Pxo, reason: not valid java name */
    public static final void m3763moveSelectord3b8Pxo(TimePickerState timePickerState, float f2, float f3, float f4, long j) {
        if (TimePickerSelectionMode.m3786equalsimpl0(timePickerState.mo2417getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m3790getHouryecRtBI()) && timePickerState.getIs24hour()) {
            float fDist = dist(f2, f3, IntOffset.m8958getXimpl(j), IntOffset.m8959getYimpl(j));
            if (isPm(timePickerState)) {
                timePickerState.setHour(timePickerState.getHour() - (fDist < f4 ? 0 : 12));
            } else {
                timePickerState.setHour(timePickerState.getHour() + (fDist >= f4 ? 0 : 12));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX INFO: renamed from: onTap-uYHVD98, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m3765onTapuYHVD98(androidx.compose.material3.AnalogTimePickerState r13, float r14, float r15, float r16, boolean r17, long r18, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m3765onTapuYHVD98(androidx.compose.material3.AnalogTimePickerState, float, float, float, boolean, long, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final long getSelectorPos(AnalogTimePickerState analogTimePickerState) {
        float fM8830constructorimpl;
        float fM8830constructorimpl2 = Dp.m8830constructorimpl(Dp.m8830constructorimpl(TimePickerTokens.INSTANCE.m4878getClockDialSelectorHandleContainerSizeD9Ej5fM() / 2.0f) * (analogTimePickerState.m2416getCurrentDiameterD9Ej5fM() / TimePickerTokens.INSTANCE.m4876getClockDialContainerSizeD9Ej5fM()));
        if (analogTimePickerState.getIs24hour() && isPm(analogTimePickerState) && TimePickerSelectionMode.m3786equalsimpl0(analogTimePickerState.mo2417getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m3790getHouryecRtBI())) {
            fM8830constructorimpl = Dp.m8830constructorimpl(analogTimePickerState.m2416getCurrentDiameterD9Ej5fM() * InnerCircleToSizeRatio);
        } else {
            fM8830constructorimpl = Dp.m8830constructorimpl(analogTimePickerState.m2416getCurrentDiameterD9Ej5fM() * OuterCircleToSizeRatio);
        }
        float fM8830constructorimpl3 = Dp.m8830constructorimpl(((Dp) RangesKt.coerceAtLeast(Dp.m8828boximpl(Dp.m8830constructorimpl(fM8830constructorimpl - fM8830constructorimpl2)), Dp.m8828boximpl(Dp.m8830constructorimpl(0)))).m8844unboximpl() + fM8830constructorimpl2);
        float f2 = 2;
        return DpOffset.m8886constructorimpl((((long) Float.floatToRawIntBits(Dp.m8830constructorimpl(Dp.m8830constructorimpl(((float) Math.cos(analogTimePickerState.getCurrentAngle())) * fM8830constructorimpl3) + Dp.m8830constructorimpl(analogTimePickerState.m2416getCurrentDiameterD9Ej5fM() / f2)))) << 32) | (((long) Float.floatToRawIntBits(Dp.m8830constructorimpl(Dp.m8830constructorimpl(fM8830constructorimpl3 * ((float) Math.sin(analogTimePickerState.getCurrentAngle()))) + Dp.m8830constructorimpl(analogTimePickerState.m2416getCurrentDiameterD9Ej5fM() / f2)))) & 4294967295L));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void VerticalTimePicker(final androidx.compose.material3.AnalogTimePickerState r16, androidx.compose.ui.Modifier r17, androidx.compose.material3.TimePickerColors r18, final boolean r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.VerticalTimePicker(androidx.compose.material3.AnalogTimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalTimePicker$lambda$9$lambda$8(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void HorizontalTimePicker(final androidx.compose.material3.AnalogTimePickerState r16, androidx.compose.ui.Modifier r17, androidx.compose.material3.TimePickerColors r18, final boolean r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.HorizontalTimePicker(androidx.compose.material3.AnalogTimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalTimePicker$lambda$13$lambda$12(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    private static final void TimeInputImpl(Modifier modifier, TimePickerColors timePickerColors, TimePickerState timePickerState, Composer composer, final int i) {
        int i2;
        final Modifier modifier2;
        final TimePickerColors timePickerColors2;
        Ref ref;
        MutableState mutableState;
        MutableState mutableState2;
        final TimePickerState timePickerState2 = timePickerState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-475657989);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimeInputImpl)N(modifier,colors,state)1002@42753L35,1002@42701L87,1005@42873L37,1005@42821L89,1007@42935L27,1009@43044L177,1009@43003L218,1017@43227L4621:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= (i & 512) == 0 ? composerStartRestartGroup.changed(timePickerState2) : composerStartRestartGroup.changedInstance(timePickerState2) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            modifier2 = modifier;
            timePickerColors2 = timePickerColors;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-475657989, i3, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:997)");
            }
            Object[] objArr = new Object[0];
            Saver<TextFieldValue, Object> saver = TextFieldValue.INSTANCE.getSaver();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1840782178, "CC(remember):TimePicker.kt#9igjgp");
            int i4 = i3 & 896;
            boolean z = i4 == 256 || ((i3 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState2));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimePickerKt.TimeInputImpl$lambda$17$lambda$16(timePickerState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            MutableState mutableStateRememberSaveable = RememberSaveableKt.rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composerStartRestartGroup, 0);
            Object[] objArr2 = new Object[0];
            Saver<TextFieldValue, Object> saver2 = TextFieldValue.INSTANCE.getSaver();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1840778336, "CC(remember):TimePicker.kt#9igjgp");
            boolean z2 = i4 == 256 || ((i3 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState2));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimePickerKt.TimeInputImpl$lambda$21$lambda$20(timePickerState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            MutableState mutableStateRememberSaveable2 = RememberSaveableKt.rememberSaveable(objArr2, (Saver) saver2, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1840776362, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Ref();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Ref ref2 = (Ref) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Integer numValueOf = Integer.valueOf(timePickerState2.getHour());
            Integer numValueOf2 = Integer.valueOf(timePickerState2.getMinute());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1840772724, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChangedInstance = (i4 == 256 || ((i3 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState2))) | composerStartRestartGroup.changedInstance(ref2) | composerStartRestartGroup.changed(mutableStateRememberSaveable) | composerStartRestartGroup.changed(mutableStateRememberSaveable2);
            TimePickerKt$TimeInputImpl$1$1 timePickerKt$TimeInputImpl$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || timePickerKt$TimeInputImpl$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                TimePickerKt$TimeInputImpl$1$1 timePickerKt$TimeInputImpl$1$1 = new TimePickerKt$TimeInputImpl$1$1(ref2, timePickerState2, mutableStateRememberSaveable, mutableStateRememberSaveable2, null);
                ref = ref2;
                mutableState = mutableStateRememberSaveable;
                mutableState2 = mutableStateRememberSaveable2;
                timePickerKt$TimeInputImpl$1$1RememberedValue = timePickerKt$TimeInputImpl$1$1;
                composerStartRestartGroup.updateRememberedValue(timePickerKt$TimeInputImpl$1$1RememberedValue);
            } else {
                mutableState2 = mutableStateRememberSaveable2;
                ref = ref2;
                mutableState = mutableStateRememberSaveable;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, numValueOf2, (Function2) timePickerKt$TimeInputImpl$1$1RememberedValue, composerStartRestartGroup, 0);
            Modifier modifierM1155paddingqDBjuR0$default = PaddingKt.m1155paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, TimeInputBottomPadding, 7, null);
            modifier2 = modifier;
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), top, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1155paddingqDBjuR0$default);
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
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1385914133, "C1022@43428L5,1031@43794L3669,1027@43572L3891:TimePicker.kt#uh7d8r");
            timePickerColors2 = timePickerColors;
            timePickerState2 = timePickerState;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TextStyle.m8286copyp1EtxEg$default(TypographyKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldLabelTextFont(), composerStartRestartGroup, 6), timePickerColors.m3726timeSelectorContentColorvNxB06k$material3(true), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8708getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null)), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(1306700887, true, new TimePickerKt$TimeInputImpl$2$1(mutableState, timePickerState2, ref, timePickerColors2, mutableState2), composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (!timePickerState2.getIs24hour()) {
                composerStartRestartGroup.startReplaceGroup(-1381942321);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1120@47508L324");
                Modifier modifierM1155paddingqDBjuR0$default2 = PaddingKt.m1155paddingqDBjuR0$default(Modifier.INSTANCE, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1155paddingqDBjuR0$default2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1377011131, "C1121@47576L242:TimePicker.kt#uh7d8r");
                VerticalPeriodToggle(SizeKt.m1223sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m4871getPeriodSelectorContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m4870getPeriodSelectorContainerHeightD9Ej5fM()), timePickerState2, timePickerColors2, composerStartRestartGroup, ((i3 >> 3) & 112) | 6 | ((i3 << 3) & 896));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1381607893);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.TimeInputImpl$lambda$28(modifier2, timePickerColors2, timePickerState2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$hourTextValue(TimePickerState timePickerState) {
        return new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(getHourForDisplay(timePickerState), 2, 0, false, null, 14, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$minuteTextValue(TimePickerState timePickerState) {
        return new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(timePickerState.getMinute(), 2, 0, false, null, 14, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState TimeInputImpl$lambda$17$lambda$16(TimePickerState timePickerState) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TimeInputImpl$hourTextValue(timePickerState), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$18(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState TimeInputImpl$lambda$21$lambda$20(TimePickerState timePickerState) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TimeInputImpl$minuteTextValue(timePickerState), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$22(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    private static final void HorizontalClockDisplay(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(755539561);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalClockDisplay)N(state,colors)1134@47955L591:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755539561, i2, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:1133)");
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 998514658, "C1135@48014L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState, timePickerColors, composerStartRestartGroup, i2 & 126);
            if (!timePickerState.getIs24hour()) {
                composerStartRestartGroup.startReplaceGroup(998576161);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1137@48092L438");
                Modifier modifierM1155paddingqDBjuR0$default = PaddingKt.m1155paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, PeriodToggleMargin, 0.0f, 0.0f, 13, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1155paddingqDBjuR0$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1710314390, "C1138@48169L347:TimePicker.kt#uh7d8r");
                int i3 = i2 << 3;
                HorizontalPeriodToggle(SizeKt.m1223sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m4882getPeriodSelectorHorizontalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m4881getPeriodSelectorHorizontalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, (i3 & 896) | (i3 & 112) | 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(999020143);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.HorizontalClockDisplay$lambda$31(timePickerState, timePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void VerticalClockDisplay(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2054675515);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalClockDisplay)N(state,colors)1154@48651L586:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054675515, i2, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:1153)");
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1364225858, "C1155@48709L34:TimePicker.kt#uh7d8r");
            ClockDisplayNumbers(timePickerState, timePickerColors, composerStartRestartGroup, i2 & 126);
            if (!timePickerState.getIs24hour()) {
                composerStartRestartGroup.startReplaceGroup(1364287361);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1157@48787L434");
                Modifier modifierM1155paddingqDBjuR0$default = PaddingKt.m1155paddingqDBjuR0$default(Modifier.INSTANCE, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1155paddingqDBjuR0$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2145741896, "C1158@48866L341:TimePicker.kt#uh7d8r");
                int i3 = i2 << 3;
                VerticalPeriodToggle(SizeKt.m1223sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m4885getPeriodSelectorVerticalContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m4884getPeriodSelectorVerticalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, (i3 & 896) | (i3 & 112) | 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1364727499);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.VerticalClockDisplay$lambda$34(timePickerState, timePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ClockDisplayNumbers(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-934561141);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ClockDisplayNumbers)N(state,colors)1175@49425L5,1178@49561L775,1174@49341L995:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934561141, i2, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:1173)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont(), composerStartRestartGroup, 6)), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(-477913269, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockDisplayNumbers.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C1179@49571L759:TimePicker.kt#uh7d8r");
                    if (!composer2.shouldExecute((i3 & 3) != 2, i3 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-477913269, i3, -1, "androidx.compose.material3.ClockDisplayNumbers.<anonymous> (TimePicker.kt:1179)");
                    }
                    TimePickerState timePickerState2 = timePickerState;
                    TimePickerColors timePickerColors2 = timePickerColors;
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer2);
                    Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 2065726649, "C1180@49589L294,1187@49896L123,1190@50032L288:TimePicker.kt#uh7d8r");
                    TimePickerKt.m3757TimeSelectorSAnMeKU(SizeKt.m1223sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m4888getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m4887getTimeSelectorContainerHeightD9Ej5fM()), TimePickerKt.getHourForDisplay(timePickerState2), timePickerState2, TimePickerSelectionMode.INSTANCE.m3790getHouryecRtBI(), timePickerColors2, composer2, 3078);
                    TimePickerKt.DisplaySeparator(SizeKt.m1223sizeVpY3zN4(Modifier.INSTANCE, TimePickerKt.DisplaySeparatorWidth, TimePickerTokens.INSTANCE.m4884getPeriodSelectorVerticalContainerHeightD9Ej5fM()), composer2, 6);
                    TimePickerKt.m3757TimeSelectorSAnMeKU(SizeKt.m1223sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m4888getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m4887getTimeSelectorContainerHeightD9Ej5fM()), timePickerState2.getMinute(), timePickerState2, TimePickerSelectionMode.INSTANCE.m3791getMinuteyecRtBI(), timePickerColors2, composer2, 3078);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.ClockDisplayNumbers$lambda$35(timePickerState, timePickerColors, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void HorizontalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        final Modifier modifier2;
        final TimePickerState timePickerState2;
        final TimePickerColors timePickerColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1261215927);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalPeriodToggle)N(modifier,state,colors)1207@50498L1014,1235@51559L5,1237@51590L207:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261215927, i2, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:1206)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 847734445, "CC(remember):TimePicker.kt#9igjgp");
            TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1 timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue = TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) timePickerKt$HorizontalPeriodToggle$measurePolicy$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            PeriodToggleImpl(modifier2, timePickerState2, timePickerColors2, measurePolicy, ShapesKt.start$default(cornerBasedShape, null, 1, null), ShapesKt.end$default(cornerBasedShape, null, 1, null), composerStartRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.HorizontalPeriodToggle$lambda$37(modifier2, timePickerState2, timePickerColors2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void VerticalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, final int i) {
        int i2;
        final Modifier modifier2;
        final TimePickerState timePickerState2;
        final TimePickerColors timePickerColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1898918107);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalPeriodToggle)N(modifier,state,colors)1253@51957L1022,1281@53026L5,1283@53057L208:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898918107, i2, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:1252)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 500805987, "CC(remember):TimePicker.kt#9igjgp");
            TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1 timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue = TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) timePickerKt$VerticalPeriodToggle$measurePolicy$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            PeriodToggleImpl(modifier2, timePickerState2, timePickerColors2, measurePolicy, ShapesKt.top$default(cornerBasedShape, null, 1, null), ShapesKt.bottom$default(cornerBasedShape, null, 1, null), composerStartRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.VerticalPeriodToggle$lambda$39(modifier2, timePickerState2, timePickerColors2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PeriodToggleImpl(final Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors, final MeasurePolicy measurePolicy, final Shape shape, final Shape shape2, Composer composer, final int i) {
        int i2;
        Shape shape3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1374241901);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PeriodToggleImpl)N(modifier,state,colors,measurePolicy,startShape,endShape)1305@53644L5,1306@53699L41,1310@53820L128,1307@53745L1360:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(measurePolicy) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            shape3 = shape2;
            i2 |= composerStartRestartGroup.changed(shape3) ? 131072 : 65536;
        } else {
            shape3 = shape2;
        }
        boolean z = true;
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1374241901, i2, -1, "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:1301)");
            }
            BorderStroke borderStrokeM348BorderStrokecXLIe8U = BorderStrokeKt.m348BorderStrokecXLIe8U(TimePickerTokens.INSTANCE.m4883getPeriodSelectorOutlineWidthD9Ej5fM(), timePickerColors.getPeriodSelectorBorderColor());
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            Strings.Companion companion = Strings.INSTANCE;
            final String strM4145getString2EP1pXo = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_time_picker_period_toggle_description), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2091524749, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strM4145getString2EP1pXo);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.PeriodToggleImpl$lambda$41$lambda$40(strM4145getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierBorder = BorderKt.border(SelectableGroupKt.selectableGroup(SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, null)), borderStrokeM348BorderStrokecXLIe8U, cornerBasedShape);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBorder);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1677874453, "C1321@54231L120,1318@54118L367,1330@54498L219,1339@54840L121,1336@54730L358:TimePicker.kt#uh7d8r");
            boolean z2 = !isPm(timePickerState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -222966916, "CC(remember):TimePicker.kt#9igjgp");
            int i3 = i2 & 112;
            boolean z3 = i3 == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(timePickerState));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimePickerKt.PeriodToggleImpl$lambda$46$lambda$43$lambda$42(timePickerState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = (i2 << 3) & 7168;
            ToggleItem(z2, shape, (Function0) objRememberedValue2, timePickerColors, ComposableSingletons$TimePickerKt.INSTANCE.getLambda$1425358052$material3(), composerStartRestartGroup, ((i2 >> 9) & 112) | 24576 | i4);
            SpacerKt.Spacer(BackgroundKt.m313backgroundbw27NRU$default(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(LayoutIdKt.layoutId(Modifier.INSTANCE, "Spacer"), 2.0f), 0.0f, 1, null), timePickerColors.getPeriodSelectorBorderColor(), null, 2, null), composerStartRestartGroup, 0);
            boolean zIsPm = isPm(timePickerState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -222947427, "CC(remember):TimePicker.kt#9igjgp");
            if (i3 != 32 && ((i2 & 64) == 0 || !composerStartRestartGroup.changedInstance(timePickerState))) {
                z = false;
            }
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimePickerKt.PeriodToggleImpl$lambda$46$lambda$45$lambda$44(timePickerState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ToggleItem(zIsPm, shape3, (Function0) objRememberedValue3, timePickerColors, ComposableSingletons$TimePickerKt.INSTANCE.m2714getLambda$1179219109$material3(), composerStartRestartGroup, ((i2 >> 12) & 112) | 24576 | i4);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.PeriodToggleImpl$lambda$47(modifier, timePickerState, timePickerColors, measurePolicy, shape, shape2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PeriodToggleImpl$lambda$41$lambda$40(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PeriodToggleImpl$lambda$46$lambda$43$lambda$42(TimePickerState timePickerState) {
        if (isPm(timePickerState)) {
            timePickerState.setHour(timePickerState.getHour() - 12);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PeriodToggleImpl$lambda$46$lambda$45$lambda$44(TimePickerState timePickerState) {
        if (!isPm(timePickerState)) {
            timePickerState.setHour(timePickerState.getHour() + 12);
        }
        return Unit.INSTANCE;
    }

    private static final void ToggleItem(final boolean z, final Shape shape, final Function0<Unit> function0, final TimePickerColors timePickerColors, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1523811083);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleItem)N(checked,shape,onClick,colors,content)1365@55539L22,1371@55730L125,1363@55431L431:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1523811083, i2, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1359)");
            }
            long jM3724periodSelectorContentColorvNxB06k$material3 = timePickerColors.m3724periodSelectorContentColorvNxB06k$material3(z);
            long jM3723periodSelectorContainerColorvNxB06k$material3 = timePickerColors.m3723periodSelectorContainerColorvNxB06k$material3(z);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, z ? 0.0f : 1.0f), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -201383391, "CC(remember):TimePicker.kt#9igjgp");
            boolean z2 = (i2 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.ToggleItem$lambda$49$lambda$48(z, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.TextButton(function0, SemanticsModifierKt.semantics$default(modifierFillMaxSize$default, false, (Function1) objRememberedValue, 1, null), false, shape, ButtonDefaults.INSTANCE.m2519textButtonColorsro_MJ88(jM3723periodSelectorContainerColorvNxB06k$material3, jM3724periodSelectorContentColorvNxB06k$material3, 0L, 0L, composerStartRestartGroup, 24576, 12), null, null, PaddingKt.m1144PaddingValues0680j_4(Dp.m8830constructorimpl(0)), null, function3, composerStartRestartGroup, ((i2 >> 6) & 14) | 12582912 | ((i2 << 6) & 7168) | ((i2 << 15) & 1879048192), 356);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.ToggleItem$lambda$50(z, shape, function0, timePickerColors, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleItem$lambda$49$lambda$48(boolean z, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DisplaySeparator(final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2100674302);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisplaySeparator)N(modifier)1381@55968L7,1390@56286L2,1390@56241L172:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100674302, i2, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1379)");
            }
            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localTextStyle);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextStyle textStyleM8286copyp1EtxEg$default = TextStyle.m8286copyp1EtxEg$default((TextStyle) objConsume, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m8708getCentere0LSkKk(), 0, 0L, null, null, new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m8675getCenterPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m8697getBothEVpEnUU(), (DefaultConstructorMarker) null), 0, 0, null, 15695871, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 113388544, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.DisplaySeparator$lambda$52$lambda$51((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (Function1) objRememberedValue);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClearAndSetSemantics);
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
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2101554693, "C1391@56386L5,1391@56337L70:TimePicker.kt#uh7d8r");
            composer2 = composerStartRestartGroup;
            TextKt.m3703TextNvy7gAk(":", null, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), composerStartRestartGroup, 6), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleM8286copyp1EtxEg$default, composer2, 6, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.DisplaySeparator$lambda$54(modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplaySeparator$lambda$52$lambda$51(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: TimeSelector-SAnMeKU, reason: not valid java name */
    public static final void m3757TimeSelectorSAnMeKU(final Modifier modifier, final int i, final TimePickerState timePickerState, final int i2, final TimePickerColors timePickerColors, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        int iM4066constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1148055889);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimeSelector)N(modifier,value,state,selection:c#material3.TimePickerSelectionMode,colors)1406@56730L214,1418@57168L124,1428@57503L5,1422@57312L117,1430@57548L498,1416@57084L962:TimePicker.kt#uh7d8r");
        if ((i3 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= (i3 & 512) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(timePickerColors) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1148055889, i4, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1403)");
            }
            boolean zM3786equalsimpl0 = TimePickerSelectionMode.m3786equalsimpl0(timePickerState.mo2417getSelectionyecRtBI(), i2);
            if (TimePickerSelectionMode.m3786equalsimpl0(i2, TimePickerSelectionMode.INSTANCE.m3790getHouryecRtBI())) {
                Strings.Companion companion = Strings.INSTANCE;
                iM4066constructorimpl = Strings.m4066constructorimpl(R.string.m3c_time_picker_hour_selection);
            } else {
                Strings.Companion companion2 = Strings.INSTANCE;
                iM4066constructorimpl = Strings.m4066constructorimpl(R.string.m3c_time_picker_minute_selection);
            }
            final String strM4145getString2EP1pXo = Strings_androidKt.m4145getString2EP1pXo(iM4066constructorimpl, composerStartRestartGroup, 0);
            long jM3725timeSelectorContainerColorvNxB06k$material3 = timePickerColors.m3725timeSelectorContainerColorvNxB06k$material3(zM3786equalsimpl0);
            long jM3726timeSelectorContentColorvNxB06k$material3 = timePickerColors.m3726timeSelectorContentColorvNxB06k$material3(zM3786equalsimpl0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 524909899, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strM4145getString2EP1pXo);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda37
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.TimeSelector_SAnMeKU$lambda$56$lambda$55(strM4145getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, true, (Function1) objRememberedValue);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorContainerShape(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 524914500, "CC(remember):TimePicker.kt#9igjgp");
            boolean z = ((i4 & 7168) == 2048) | ((i4 & 896) == 256 || ((i4 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState)));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimePickerKt.TimeSelector_SAnMeKU$lambda$58$lambda$57(i2, timePickerState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            SurfaceKt.m3532Surfaced85dljk(zM3786equalsimpl0, (Function0<Unit>) objRememberedValue2, modifierSemantics, false, value, jM3725timeSelectorContainerColorvNxB06k$material3, 0L, 0.0f, 0.0f, (BorderStroke) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1477282471, true, new TimePickerKt$TimeSelector$3(i2, timePickerState, i, jM3726timeSelectorContentColorvNxB06k$material3), composerStartRestartGroup, 54), composer2, 0, 48, 1992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.TimeSelector_SAnMeKU$lambda$59(modifier, i, timePickerState, i2, timePickerColors, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeSelector_SAnMeKU$lambda$56$lambda$55(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8032setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8018getRadioButtono7Vup1c());
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeSelector_SAnMeKU$lambda$58$lambda$57(int i, TimePickerState timePickerState) {
        if (!TimePickerSelectionMode.m3786equalsimpl0(i, timePickerState.mo2417getSelectionyecRtBI())) {
            timePickerState.mo2419setSelection6_8s6DQ(i);
        }
        return Unit.INSTANCE;
    }

    public static final void ClockFace(final Modifier modifier, AnalogTimePickerState analogTimePickerState, final TimePickerColors timePickerColors, final boolean z, Composer composer, final int i) {
        int i2;
        final AnalogTimePickerState analogTimePickerState2 = analogTimePickerState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-478841003);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ClockFace)N(modifier,state,colors,autoSwitchToMinute)1602@63170L7,1607@63371L7,1608@63386L2054,1593@62800L2640:TimePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(analogTimePickerState2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-478841003, i2, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1591)");
            }
            analogTimePickerState2 = analogTimePickerState;
            CrossfadeKt.Crossfade(analogTimePickerState2.getClockFaceValues(), drawSelector(BackgroundKt.m312backgroundbw27NRU(modifier, timePickerColors.getClockDialColor(), RoundedCornerShapeKt.getCircleShape()).then(new ClockDialModifier(analogTimePickerState, z, analogTimePickerState.mo2417getSelectionyecRtBI(), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6), null)), analogTimePickerState2, timePickerColors), (FiniteAnimationSpec<Float>) MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), (String) null, ComposableLambdaKt.rememberComposableLambda(747010833, true, new C04101(timePickerColors, analogTimePickerState2, z), composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.ClockFace$lambda$60(modifier, analogTimePickerState2, timePickerColors, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockFace$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TimePicker.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class C04101 implements Function3<IntList, Composer, Integer, Unit> {
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ AnalogTimePickerState $state;

        C04101(TimePickerColors timePickerColors, AnalogTimePickerState analogTimePickerState, boolean z) {
            this.$colors = timePickerColors;
            this.$state = analogTimePickerState;
            this.$autoSwitchToMinute = z;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(IntList intList, Composer composer, Integer num) {
            invoke(intList, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            SemanticsPropertiesKt.selectableGroup(semanticsPropertyReceiver);
            return Unit.INSTANCE;
        }

        public final void invoke(final IntList intList, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "CN(screen)1610@63493L21,1612@63582L1852,1609@63406L2028:TimePicker.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(747010833, i, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1609)");
            }
            Modifier modifierM1221size3ABfNKs = SizeKt.m1221size3ABfNKs(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m4876getClockDialContainerSizeD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composer, 617875526, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.C04101.invoke$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM1221size3ABfNKs, false, (Function1) objRememberedValue, 1, null);
            float f2 = TimePickerKt.OuterCircleToSizeRatio;
            final TimePickerColors timePickerColors = this.$colors;
            final AnalogTimePickerState analogTimePickerState = this.$state;
            final boolean z = this.$autoSwitchToMinute;
            TimePickerKt.CircularLayout(modifierSemantics$default, f2, ComposableLambdaKt.rememberComposableLambda(-99063847, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: TimePicker.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                static final class C00551 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ boolean $autoSwitchToMinute;
                    final /* synthetic */ IntList $screen;
                    final /* synthetic */ AnalogTimePickerState $state;

                    C00551(IntList intList, AnalogTimePickerState analogTimePickerState, boolean z) {
                        this.$screen = intList;
                        this.$state = analogTimePickerState;
                        this.$autoSwitchToMinute = z;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        int i2;
                        ComposerKt.sourceInformation(composer, "C:TimePicker.kt#uh7d8r");
                        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-596940007, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1616)");
                        }
                        composer.startReplaceGroup(1866272144);
                        ComposerKt.sourceInformation(composer, "*1624@64134L41,1623@64069L277");
                        int i3 = this.$screen._size;
                        AnalogTimePickerState analogTimePickerState = this.$state;
                        IntList intList = this.$screen;
                        boolean z = this.$autoSwitchToMinute;
                        for (final int i4 = 0; i4 < i3; i4++) {
                            if (!analogTimePickerState.getIs24hour() || TimePickerSelectionMode.m3786equalsimpl0(analogTimePickerState.mo2417getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m3791getMinuteyecRtBI())) {
                                i2 = intList.get(i4);
                            } else {
                                i2 = intList.get(i4) % 12;
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer, -121641742, "CC(remember):TimePicker.kt#9igjgp");
                            boolean zChanged = composer.changed(i4);
                            Object objRememberedValue = composer.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TimePickerKt.C04101.AnonymousClass2.C00551.invoke$lambda$2$lambda$1$lambda$0(i4, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            boolean z2 = z;
                            TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), analogTimePickerState, i2, z2, composer, 0);
                            z = z2;
                        }
                        composer.endReplaceGroup();
                        if (TimePickerSelectionMode.m3786equalsimpl0(this.$state.mo2417getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m3790getHouryecRtBI()) && this.$state.getIs24hour()) {
                            composer.startReplaceGroup(2020585964);
                            ComposerKt.sourceInformation(composer, "1638@64839L553,1632@64475L917");
                            TimePickerKt.CircularLayout(BackgroundKt.m312backgroundbw27NRU(SizeKt.m1221size3ABfNKs(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m4876getClockDialContainerSizeD9Ej5fM()), Color.INSTANCE.m6003getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), TimePickerKt.InnerCircleToSizeRatio, ComposableLambdaKt.rememberComposableLambda(-1385767514, true, new C00562(this.$state, this.$autoSwitchToMinute), composer, 54), composer, 432, 0);
                            composer.endReplaceGroup();
                        } else {
                            composer.startReplaceGroup(2021505641);
                            composer.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$2$lambda$1$lambda$0(int i, SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, i + 1.0f);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$2, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: TimePicker.kt */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                    static final class C00562 implements Function2<Composer, Integer, Unit> {
                        final /* synthetic */ boolean $autoSwitchToMinute;
                        final /* synthetic */ AnalogTimePickerState $state;

                        C00562(AnalogTimePickerState analogTimePickerState, boolean z) {
                            this.$state = analogTimePickerState;
                            this.$autoSwitchToMinute = z;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer, int i) {
                            ComposerKt.sourceInformation(composer, "C*1643@65100L41,1641@64991L353:TimePicker.kt#uh7d8r");
                            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1385767514, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1639)");
                            }
                            int i2 = TimePickerKt.ExtraHours._size;
                            AnalogTimePickerState analogTimePickerState = this.$state;
                            boolean z = this.$autoSwitchToMinute;
                            for (final int i3 = 0; i3 < i2; i3++) {
                                int i4 = TimePickerKt.ExtraHours.get(i3);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer, -1870016769, "CC(remember):TimePicker.kt#9igjgp");
                                boolean zChanged = composer.changed(i3);
                                Object objRememberedValue = composer.rememberedValue();
                                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$2$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return TimePickerKt.C04101.AnonymousClass2.C00551.C00562.invoke$lambda$2$lambda$1$lambda$0(i3, (SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composer.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer);
                                TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), analogTimePickerState, i4, z, composer, 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit invoke$lambda$2$lambda$1$lambda$0(int i, SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 12 + i);
                            return Unit.INSTANCE;
                        }
                    }
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C1615@63715L1709,1613@63596L1828:TimePicker.kt#uh7d8r");
                    if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-99063847, i2, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1613)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(timePickerColors.m3707clockDialContentColorvNxB06k$material3(false))), ComposableLambdaKt.rememberComposableLambda(-596940007, true, new C00551(intList, analogTimePickerState, z), composer2, 54), composer2, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    private static final Modifier drawSelector(Modifier modifier, final AnalogTimePickerState analogTimePickerState, final TimePickerColors timePickerColors) {
        return DrawModifierKt.drawWithContent(modifier, new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TimePickerKt.drawSelector$lambda$61(analogTimePickerState, timePickerColors, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawSelector$lambda$61(AnalogTimePickerState analogTimePickerState, TimePickerColors timePickerColors, ContentDrawScope contentDrawScope) {
        float f2 = contentDrawScope.mo488toPx0680j_4(DpOffset.m8891getXD9Ej5fM(getSelectorPos(analogTimePickerState)));
        long jM5715constructorimpl = Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(contentDrawScope.mo488toPx0680j_4(DpOffset.m8893getYD9Ej5fM(getSelectorPos(analogTimePickerState))))) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
        float f3 = ((contentDrawScope.mo488toPx0680j_4(TimePickerTokens.INSTANCE.m4878getClockDialSelectorHandleContainerSizeD9Ej5fM()) / 2.0f) * contentDrawScope.mo482roundToPx0680j_4(analogTimePickerState.m2416getCurrentDiameterD9Ej5fM())) / contentDrawScope.mo482roundToPx0680j_4(TimePickerTokens.INSTANCE.m4876getClockDialContainerSizeD9Ej5fM());
        long selectorColor = timePickerColors.getSelectorColor();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m6530drawCircleVaOC9Bg$default(contentDrawScope2, Color.INSTANCE.m5994getBlack0d7_KjU(), f3, jM5715constructorimpl, 0.0f, null, null, BlendMode.INSTANCE.m5881getClear0nO6VwU(), 56, null);
        contentDrawScope.drawContent();
        DrawScope.m6530drawCircleVaOC9Bg$default(contentDrawScope2, selectorColor, f3, jM5715constructorimpl, 0.0f, null, null, BlendMode.INSTANCE.m5909getXor0nO6VwU(), 56, null);
        float f4 = contentDrawScope.mo488toPx0680j_4(TimePickerTokens.INSTANCE.m4879getClockDialSelectorTrackContainerWidthD9Ej5fM());
        float fCos = ((float) Math.cos(analogTimePickerState.getCurrentAngle())) * f3;
        DrawScope.m6535drawLineNGM6Ib0$default(contentDrawScope2, selectorColor, androidx.compose.ui.geometry.SizeKt.m5802getCenteruvyYCjk(contentDrawScope.mo6549getSizeNHjbRc()), Offset.m5727minusMKHz9U(jM5715constructorimpl, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(((float) Math.sin(analogTimePickerState.getCurrentAngle())) * f3)) & 4294967295L) | (Float.floatToRawIntBits(fCos) << 32))), f4, 0, null, 0.0f, null, BlendMode.INSTANCE.m5908getSrcOver0nO6VwU(), 240, null);
        DrawScope.m6530drawCircleVaOC9Bg$default(contentDrawScope2, selectorColor, contentDrawScope.mo488toPx0680j_4(TimePickerTokens.INSTANCE.m4877getClockDialSelectorCenterContainerSizeD9Ej5fM()) / 2, androidx.compose.ui.geometry.SizeKt.m5802getCenteruvyYCjk(contentDrawScope.mo6549getSizeNHjbRc()), 0.0f, null, null, 0, 120, null);
        DrawScope.m6530drawCircleVaOC9Bg$default(contentDrawScope2, timePickerColors.m3707clockDialContentColorvNxB06k$material3(true), f3, jM5715constructorimpl, 0.0f, null, null, BlendMode.INSTANCE.m5891getDstOver0nO6VwU(), 56, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockText(final Modifier modifier, final AnalogTimePickerState analogTimePickerState, final int i, final boolean z, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-206784607);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ClockText)N(modifier,state,value,autoSwitchToMinute)1728@67678L5,1729@67724L7,1731@67805L40,1732@67870L43,1733@67940L38,1734@67995L24,1736@68057L143,1744@68267L268,1757@68741L215,1765@69135L612,1753@68613L1344:TimePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(analogTimePickerState) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        int i4 = i3;
        if (!composerStartRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-206784607, i4, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1727)");
            }
            TextStyle value = TypographyKt.getValue(TimePickerTokens.INSTANCE.getClockDialLabelTextFont(), composerStartRestartGroup, 6);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Density density = (Density) objConsume;
            final float fMo488toPx0680j_4 = density.mo488toPx0680j_4(MaxDistance);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1151501687, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m5712boximpl(Offset.INSTANCE.m5739getZeroF1C5BW0()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1151499604, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m8949boximpl(IntOffset.INSTANCE.m8969getZeronOccac()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1151497369, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Rect.INSTANCE.getZero(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final String strM3764numberContentDescriptiondSwYdS4 = m3764numberContentDescriptiondSwYdS4(analogTimePickerState.mo2417getSelectionyecRtBI(), analogTimePickerState.getIs24hour(), i, composerStartRestartGroup, i4 & 896);
            String localString$default = CalendarLocale_jvmKt.toLocalString$default(i, 0, 0, false, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1151486675, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(analogTimePickerState);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(TimePickerKt.ClockText$lambda$74$lambda$73(analogTimePickerState, density, mutableState3));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final State state = (State) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1151471560, "CC(remember):TimePicker.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.ClockText$lambda$77$lambda$76(mutableState2, mutableState3, mutableState, (LayoutCoordinates) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFocusable$default = FocusableKt.focusable$default(SizeKt.m1221size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) objRememberedValue6)), MinimumInteractiveSize), false, null, 3, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1151458555, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(analogTimePickerState) | composerStartRestartGroup.changed(fMo488toPx0680j_4) | ((i4 & 7168) == 2048) | composerStartRestartGroup.changed(state);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.ClockText$lambda$80$lambda$79(coroutineScope, analogTimePickerState, fMo488toPx0680j_4, z, mutableState, mutableState2, state, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function1);
                objRememberedValue7 = function1;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierFocusable$default, true, (Function1) objRememberedValue7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics);
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
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -866292798, "C1784@69840L48,1782@69765L186:TimePicker.kt#uh7d8r");
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2106152649, "CC(remember):TimePicker.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(strM3764numberContentDescriptiondSwYdS4);
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimePickerKt.ClockText$lambda$83$lambda$82$lambda$81(strM3764numberContentDescriptiondSwYdS4, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            TextKt.m3703TextNvy7gAk(localString$default, SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue8), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, value, composer2, 0, 0, 131068);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.ClockText$lambda$84(modifier, analogTimePickerState, i, z, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ClockText$lambda$64(MutableState<Offset> mutableState) {
        return mutableState.getValue().m5733unboximpl();
    }

    private static final void ClockText$lambda$65(MutableState<Offset> mutableState, long j) {
        mutableState.setValue(Offset.m5712boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ClockText$lambda$67(MutableState<IntOffset> mutableState) {
        return mutableState.getValue().m8967unboximpl();
    }

    private static final void ClockText$lambda$68(MutableState<IntOffset> mutableState, long j) {
        mutableState.setValue(IntOffset.m8949boximpl(j));
    }

    private static final Rect ClockText$lambda$70(MutableState<Rect> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ClockText$lambda$74$lambda$73(AnalogTimePickerState analogTimePickerState, Density density, MutableState mutableState) {
        long selectorPos = getSelectorPos(analogTimePickerState);
        float fMo488toPx0680j_4 = density.mo488toPx0680j_4(DpOffset.m8891getXD9Ej5fM(selectorPos));
        return ClockText$lambda$70(mutableState).m5749containsk4lQ0M(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(density.mo488toPx0680j_4(DpOffset.m8893getYD9Ej5fM(selectorPos)))) & 4294967295L) | (Float.floatToRawIntBits(fMo488toPx0680j_4) << 32)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockText$lambda$77$lambda$76(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentCoordinates = layoutCoordinates.getParentCoordinates();
        ClockText$lambda$68(mutableState, parentCoordinates != null ? IntSizeKt.m9007getCenterozmzZPI(parentCoordinates.mo7453getSizeYbymL2g()) : IntOffset.INSTANCE.m8969getZeronOccac());
        mutableState2.setValue(LayoutCoordinatesKt.boundsInParent(layoutCoordinates));
        ClockText$lambda$65(mutableState3, ClockText$lambda$70(mutableState2).m5753getCenterF1C5BW0());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockText$lambda$80$lambda$79(final CoroutineScope coroutineScope, final AnalogTimePickerState analogTimePickerState, final float f2, final boolean z, final MutableState mutableState, final MutableState mutableState2, State state, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(TimePickerKt.ClockText$lambda$80$lambda$79$lambda$78(coroutineScope, analogTimePickerState, f2, z, mutableState, mutableState2));
            }
        }, 1, null);
        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, ClockText$lambda$75(state));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ClockText$lambda$80$lambda$79$lambda$78(CoroutineScope coroutineScope, AnalogTimePickerState analogTimePickerState, float f2, boolean z, MutableState mutableState, MutableState mutableState2) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TimePickerKt$ClockText$2$1$1$1(analogTimePickerState, f2, z, mutableState, mutableState2, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClockText$lambda$83$lambda$82$lambda$81(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: timeInputOnChange-_K77t-0, reason: not valid java name */
    public static final void m3766timeInputOnChange_K77t0(int i, TimePickerState timePickerState, TextFieldValue textFieldValue, TextFieldValue textFieldValue2, int i2, Ref<Boolean> ref, Function1<? super TextFieldValue, Unit> function1) {
        int iDigitToInt;
        int i3 = 0;
        ref.setValue(false);
        if (Intrinsics.areEqual(textFieldValue.getText(), textFieldValue2.getText())) {
            function1.invoke(textFieldValue);
            return;
        }
        int i4 = 12;
        if (textFieldValue.getText().length() == 0) {
            if (TimePickerSelectionMode.m3786equalsimpl0(i, TimePickerSelectionMode.INSTANCE.m3790getHouryecRtBI())) {
                if (isPm(timePickerState) && !timePickerState.getIs24hour()) {
                    i3 = 12;
                }
                timePickerState.setHour(i3);
            } else {
                timePickerState.setMinute(0);
            }
            function1.invoke(TextFieldValue.m8523copy3r_uNRQ$default(textFieldValue, "", 0L, (TextRange) null, 6, (Object) null));
            return;
        }
        try {
            if (textFieldValue.getText().length() == 3 && TextRange.m8273getStartimpl(textFieldValue.getSelection()) == 1) {
                iDigitToInt = CharsKt.digitToInt(textFieldValue.getText().charAt(0));
            } else {
                iDigitToInt = Integer.parseInt(textFieldValue.getText());
            }
            if (iDigitToInt <= i2) {
                if (TimePickerSelectionMode.m3786equalsimpl0(i, TimePickerSelectionMode.INSTANCE.m3790getHouryecRtBI())) {
                    if (iDigitToInt != 12 || !isPm(timePickerState)) {
                        if (iDigitToInt != 12 || isPm(timePickerState) || timePickerState.getIs24hour()) {
                            if (!isPm(timePickerState) || timePickerState.getIs24hour()) {
                                i4 = 0;
                            }
                            i4 += iDigitToInt;
                        } else {
                            i4 = 0;
                        }
                    }
                    timePickerState.setHour(i4);
                    if (iDigitToInt > 1 && !timePickerState.getIs24hour()) {
                        timePickerState.mo2419setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m3791getMinuteyecRtBI());
                    }
                } else {
                    timePickerState.setMinute(iDigitToInt);
                }
                function1.invoke(textFieldValue.getText().length() <= 2 ? textFieldValue : TextFieldValue.m8523copy3r_uNRQ$default(textFieldValue, String.valueOf(textFieldValue.getText().charAt(0)), 0L, (TextRange) null, 6, (Object) null));
            }
        } catch (NumberFormatException | IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:170:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x06d9  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x06e1  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06e9  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0706  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010b  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: TimePickerTextField-1vLObsk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3756TimePickerTextField1vLObsk(final androidx.compose.ui.Modifier r114, final androidx.compose.ui.text.input.TextFieldValue r115, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r116, androidx.compose.material3.TimePickerState r117, final int r118, androidx.compose.foundation.text.KeyboardOptions r119, androidx.compose.foundation.text.KeyboardActions r120, final androidx.compose.material3.TimePickerColors r121, androidx.compose.runtime.Composer r122, final int r123, final int r124) {
        /*
            Method dump skipped, instruction units count: 1840
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m3756TimePickerTextField1vLObsk(androidx.compose.ui.Modifier, androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.material3.TimePickerState, int, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerTextField_1vLObsk$lambda$92$lambda$89$lambda$88$lambda$87(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimePickerTextField_1vLObsk$lambda$92$lambda$91$lambda$90(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CircularLayout(Modifier modifier, final float f2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1041042571);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularLayout)N(modifier,radiusToSizeRatio,content)1979@76688L1660,1979@76641L1707:TimePicker.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1041042571, i3, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1978)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 285478289, "CC(remember):TimePicker.kt#9igjgp");
            boolean z = (i3 & 112) == 32;
            TimePickerKt$CircularLayout$1$1 timePickerKt$CircularLayout$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || timePickerKt$CircularLayout$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                timePickerKt$CircularLayout$1$1RememberedValue = new TimePickerKt$CircularLayout$1$1(f2);
                composerStartRestartGroup.updateRememberedValue(timePickerKt$CircularLayout$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) timePickerKt$CircularLayout$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = ((i3 >> 6) & 14) | ((i3 << 3) & 112);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i6 = ((i5 << 6) & 896) | 6;
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
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TimePickerKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimePickerKt.CircularLayout$lambda$96(modifier2, f2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: numberContentDescription-dSwYdS4, reason: not valid java name */
    public static final String m3764numberContentDescriptiondSwYdS4(int i, boolean z, int i2, Composer composer, int i3) {
        int iM4066constructorimpl;
        ComposerKt.sourceInformationMarkerStart(composer, 194237364, "C(numberContentDescription)N(selection:c#material3.TimePickerSelectionMode,is24Hour,number)2029@78784L21:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(194237364, i3, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:2019)");
        }
        if (TimePickerSelectionMode.m3786equalsimpl0(i, TimePickerSelectionMode.INSTANCE.m3791getMinuteyecRtBI())) {
            Strings.Companion companion = Strings.INSTANCE;
            iM4066constructorimpl = Strings.m4066constructorimpl(R.string.m3c_time_picker_minute_suffix);
        } else if (z) {
            Strings.Companion companion2 = Strings.INSTANCE;
            iM4066constructorimpl = Strings.m4066constructorimpl(R.string.m3c_time_picker_hour_24h_suffix);
        } else {
            Strings.Companion companion3 = Strings.INSTANCE;
            iM4066constructorimpl = Strings.m4066constructorimpl(R.string.m3c_time_picker_hour_suffix);
        }
        String strM4146getStringqBjtwXw = Strings_androidKt.m4146getStringqBjtwXw(iM4066constructorimpl, new Object[]{Integer.valueOf(i2)}, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strM4146getStringqBjtwXw;
    }

    private static final float dist(float f2, float f3, int i, int i2) {
        return (float) Math.hypot(i - f2, i2 - f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float atan(float f2, float f3) {
        float fAtan2 = ((float) Math.atan2(f2, f3)) - 1.5707964f;
        return fAtan2 < 0.0f ? fAtan2 + FullCircle : fAtan2;
    }

    public static final int getDefaultTimePickerLayoutType(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 435687004, "C(<get-defaultTimePickerLayoutType>)2051@79436L29:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(435687004, i, -1, "androidx.compose.material3.<get-defaultTimePickerLayoutType> (TimePicker.kt:2051)");
        }
        int iDefaultTimePickerLayoutType = TimePicker_androidKt.defaultTimePickerLayoutType(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iDefaultTimePickerLayoutType;
    }

    public static final float getClockDialMinContainerSize() {
        return ClockDialMinContainerSize;
    }

    private static final Modifier visible(Modifier modifier, final boolean z) {
        return modifier.then(new VisibleModifier(z, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TimePickerKt$visible$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("visible");
                inspectorInfo.getProperties().set("visible", Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean ClockText$lambda$75(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static {
        float f2 = 24;
        ClockFaceBottomMargin = Dp.m8830constructorimpl(f2);
        DisplaySeparatorWidth = Dp.m8830constructorimpl(f2);
        TimeInputBottomPadding = Dp.m8830constructorimpl(f2);
        IntList intListIntListOf = IntListKt.intListOf(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Hours = intListIntListOf;
        MutableIntList mutableIntList = new MutableIntList(intListIntListOf._size);
        int[] iArr = intListIntListOf.content;
        int i = intListIntListOf._size;
        for (int i2 = 0; i2 < i; i2++) {
            mutableIntList.add((iArr[i2] % 12) + 12);
        }
        ExtraHours = mutableIntList;
        PeriodToggleMargin = Dp.m8830constructorimpl(12);
        TimePickerMaxHeight = Dp.m8830constructorimpl(RendererCapabilities.DECODER_SUPPORT_MASK);
        TimePickerMidHeight = Dp.m8830constructorimpl(330);
        ClockDialMidContainerSize = Dp.m8830constructorimpl(238);
        ClockDialMinContainerSize = Dp.m8830constructorimpl(200);
    }
}
