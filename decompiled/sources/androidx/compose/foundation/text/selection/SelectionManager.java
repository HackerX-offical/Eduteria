package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMapKt;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: SelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u009a\u0001\u001a\u00020\u0017H\u0002J\u001c\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0000¢\u0006\u0003\b\u009f\u0001J\t\u0010 \u0001\u001a\u00020\u0017H\u0002J\u000f\u0010¡\u0001\u001a\u00020SH\u0000¢\u0006\u0003\b¢\u0001J:\u0010£\u0001\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\b0¥\u00010¤\u00012\b\u0010¦\u0001\u001a\u00030§\u00012\t\u0010¨\u0001\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0003\b©\u0001J\u000f\u0010ª\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b«\u0001J\u000f\u0010¬\u0001\u001a\u00020\u0017H\u0000¢\u0006\u0003\b\u00ad\u0001J\u000f\u0010®\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b¯\u0001J\u000f\u0010°\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\b±\u0001J\u0011\u0010²\u0001\u001a\u0004\u0018\u00010$H\u0000¢\u0006\u0003\b³\u0001J\u001f\u0010´\u0001\u001a\u0012\u0012\u0004\u0012\u00020$\u0012\u0005\u0012\u00030µ\u0001\u0018\u00010¤\u0001H\u0000¢\u0006\u0003\b¶\u0001J\u0083\u0001\u0010·\u0001\u001a\u00020\u00172q\b\u0004\u0010¸\u0001\u001aj\u0012\u0017\u0012\u00150§\u0001¢\u0006\u000f\bº\u0001\u0012\n\b»\u0001\u0012\u0005\b\b(¦\u0001\u0012\u0016\u0012\u00140$¢\u0006\u000f\bº\u0001\u0012\n\b»\u0001\u0012\u0005\b\b(¼\u0001\u0012\u0016\u0012\u00140µ\u0001¢\u0006\u000e\bº\u0001\u0012\t\b»\u0001\u0012\u0004\b\b(\n\u0012\u0016\u0012\u00140\u0010¢\u0006\u000f\bº\u0001\u0012\n\b»\u0001\u0012\u0005\b\b(½\u0001\u0012\u0004\u0012\u00020\u00100¹\u0001H\u0080\b¢\u0006\u0003\b¾\u0001J\u000f\u0010¿\u0001\u001a\u00020\u0017H\u0000¢\u0006\u0003\bÀ\u0001J\t\u0010Ä\u0001\u001a\u00020\u0017H\u0002J\t\u0010Å\u0001\u001a\u00020\u0017H\u0002J\u000f\u0010Æ\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\bÇ\u0001J\t\u0010È\u0001\u001a\u00020\u0017H\u0002J\u000b\u0010É\u0001\u001a\u0004\u0018\u00010JH\u0002J\u0007\u0010Ê\u0001\u001a\u00020\u0017J\u0011\u0010Ë\u0001\u001a\u00030Ì\u00012\u0007\u0010Í\u0001\u001a\u00020\u0010J\r\u0010Î\u0001\u001a\u00020F*\u00020FH\u0002J\u001d\u0010Ï\u0001\u001a\u00020F*\u00020F2\u000e\u0010¸\u0001\u001a\t\u0012\u0004\u0012\u00020\u00170Ð\u0001H\u0002J$\u0010Ñ\u0001\u001a\u00020R2\u0007\u0010Ò\u0001\u001a\u00020S2\u0007\u0010Ó\u0001\u001a\u00020RH\u0002¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J.\u0010Ö\u0001\u001a\u00020\u00172\u0007\u0010×\u0001\u001a\u00020R2\u0007\u0010Í\u0001\u001a\u00020\u00102\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0002¢\u0006\u0006\bÚ\u0001\u0010Û\u0001J8\u0010Ü\u0001\u001a\u00020\u00102\t\u0010Ý\u0001\u001a\u0004\u0018\u00010R2\u0006\u0010Q\u001a\u00020R2\u0007\u0010Í\u0001\u001a\u00020\u00102\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0000¢\u0006\u0006\bÞ\u0001\u0010ß\u0001J7\u0010Ü\u0001\u001a\u00020\u00102\u0007\u0010×\u0001\u001a\u00020R2\u0007\u0010à\u0001\u001a\u00020R2\u0007\u0010Í\u0001\u001a\u00020\u00102\b\u0010Ø\u0001\u001a\u00030Ù\u0001H\u0000¢\u0006\u0006\bá\u0001\u0010â\u0001J0\u0010ã\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0007\u0010×\u0001\u001a\u00020R2\u0007\u0010à\u0001\u001a\u00020R2\u0007\u0010Í\u0001\u001a\u00020\u0010H\u0002¢\u0006\u0006\bä\u0001\u0010å\u0001J\u001c\u0010æ\u0001\u001a\u00020\u00172\b\u0010ç\u0001\u001a\u00030\u0087\u00012\u0007\u0010è\u0001\u001a\u00020\bH\u0002J\u000f\u0010é\u0001\u001a\u00020\u0010H\u0001¢\u0006\u0003\bê\u0001J\u0018\u0010ë\u0001\u001a\u00020\u00172\u0007\u0010×\u0001\u001a\u00020R¢\u0006\u0005\bì\u0001\u0010cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R@\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00170\u00162\u0014\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00170\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u00020.8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R+\u0010<\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R\u0014\u0010A\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0012R\u001a\u0010B\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R\u0011\u0010E\u001a\u00020F8F¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bK\u0010LR\u0011\u0010O\u001a\u00020F8F¢\u0006\u0006\u001a\u0004\bP\u0010HR\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010T\u001a\u0004\u0018\u00010S2\b\u0010\t\u001a\u0004\u0018\u00010S@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR+\u0010Y\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00178B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010@\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R+\u0010_\u001a\u00020R2\u0006\u0010;\u001a\u00020R8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010@\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR+\u0010e\u001a\u00020R2\u0006\u0010;\u001a\u00020R8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bh\u0010@\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR/\u0010i\u001a\u0004\u0018\u00010R2\b\u0010;\u001a\u0004\u0018\u00010R8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bn\u0010@\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR/\u0010o\u001a\u0004\u0018\u00010R2\b\u0010;\u001a\u0004\u0018\u00010R8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\br\u0010@\u001a\u0004\bp\u0010k\"\u0004\bq\u0010mR/\u0010t\u001a\u0004\u0018\u00010s2\b\u0010;\u001a\u0004\u0018\u00010s8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\by\u0010@\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0011\u0010z\u001a\u00020{8F¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0011\u0010~\u001a\u00020{8F¢\u0006\u0006\u001a\u0004\b\u007f\u0010}R3\u0010\u0080\u0001\u001a\u0004\u0018\u00010R2\b\u0010;\u001a\u0004\u0018\u00010R8F@BX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010@\u001a\u0005\b\u0081\u0001\u0010k\"\u0005\b\u0082\u0001\u0010mR\u0016\u0010\u0084\u0001\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010\u0012R-\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0019\n\u0000\u0012\u0005\b\u0088\u0001\u00100\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u000f\u0010\u008d\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\"\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R'\u0010Á\u0001\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@@X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÂ\u0001\u0010\u0012\"\u0005\bÃ\u0001\u0010\u0014¨\u0006í\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "<init>", "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "_selection", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/selection/Selection;", "value", "selection", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "_isInTouchMode", "", "isInTouchMode", "()Z", "setInTouchMode", "(Z)V", "newOnSelectionChange", "Lkotlin/Function1;", "", "onSelectionChange", "getOnSelectionChange", "()Lkotlin/jvm/functions/Function1;", "setOnSelectionChange", "(Lkotlin/jvm/functions/Function1;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "onCopyHandler", "Landroidx/compose/ui/text/AnnotatedString;", "getOnCopyHandler", "setOnCopyHandler", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "getToolbarRequester$foundation$annotations", "()V", "getToolbarRequester$foundation", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setToolbarRequester$foundation", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "<set-?>", "hasFocus", "getHasFocus", "setHasFocus", "hasFocus$delegate", "Landroidx/compose/runtime/MutableState;", "isDraggingInProgress", "shouldIgnoreCopyKeyEvent", "getShouldIgnoreCopyKeyEvent$foundation", "setShouldIgnoreCopyKeyEvent$foundation", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "derivedContentRect", "Landroidx/compose/ui/geometry/Rect;", "getDerivedContentRect", "()Landroidx/compose/ui/geometry/Rect;", "derivedContentRect$delegate", "Landroidx/compose/runtime/State;", "contextMenuAreaModifier", "getContextMenuAreaModifier", "previousPosition", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "getContainerLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "positionChangeState", "getPositionChangeState", "()Lkotlin/Unit;", "setPositionChangeState", "(Lkotlin/Unit;)V", "positionChangeState$delegate", "dragBeginPosition", "getDragBeginPosition-F1C5BW0$foundation", "()J", "setDragBeginPosition-k-4lQ0M", "(J)V", "dragBeginPosition$delegate", "dragTotalDistance", "getDragTotalDistance-F1C5BW0$foundation", "setDragTotalDistance-k-4lQ0M", "dragTotalDistance$delegate", "startHandlePosition", "getStartHandlePosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setStartHandlePosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "startHandlePosition$delegate", "endHandlePosition", "getEndHandlePosition-_m7T9-E", "setEndHandlePosition-_kEHs6E", "endHandlePosition$delegate", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "startHandleLineHeight", "", "getStartHandleLineHeight", "()F", "endHandleLineHeight", "getEndHandleLineHeight", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "setCurrentDragPosition-_kEHs6E", "currentDragPosition$delegate", "shouldShowMagnifier", "getShouldShowMagnifier", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "getPreviousSelectionLayout$foundation$annotations", "getPreviousSelectionLayout$foundation", "()Landroidx/compose/foundation/text/selection/SelectionLayout;", "setPreviousSelectionLayout$foundation", "(Landroidx/compose/foundation/text/selection/SelectionLayout;)V", "isLongPressOrClickSelection", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$foundation", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope$foundation", "(Lkotlinx/coroutines/CoroutineScope;)V", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "getPlatformSelectionBehaviors$foundation", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "setPlatformSelectionBehaviors$foundation", "(Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "suggestSelectionForLongPressOrDoubleClick", "getAnchorSelectable", "Landroidx/compose/foundation/text/selection/Selectable;", ReferenceElement.ATTR_ANCHOR, "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getAnchorSelectable$foundation", "updateHandleOffsets", "requireContainerCoordinates", "requireContainerCoordinates$foundation", "selectAllInSelectable", "Lkotlin/Pair;", "Landroidx/collection/LongObjectMap;", "selectableId", "", "previousSelection", "selectAllInSelectable$foundation", "isEntireContainerSelected", "isEntireContainerSelected$foundation", "selectAll", "selectAll$foundation", "isTriviallyCollapsedSelection", "isTriviallyCollapsedSelection$foundation", "isNonEmptySelection", "isNonEmptySelection$foundation", "getSelectedText", "getSelectedText$foundation", "getContextTextAndSelection", "Landroidx/compose/ui/text/TextRange;", "getContextTextAndSelection$foundation", "forEachSelectableWithSelection", BlockContactsIQ.ELEMENT, "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "text", "isLastSelectable", "forEachSelectableWithSelection$foundation", Constants.COPY_TYPE, "copy$foundation", "showToolbar", "getShowToolbar$foundation", "setShowToolbar$foundation", "toolbarCopy", "updateSelectionToolbar", "canCopy", "canCopy$foundation", "updateSelectionTextToolbar", "getContentRect", "onRelease", "handleDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "isStartHandle", "addContextMenuComponents", "onClearSelectionRequested", "Lkotlin/Function0;", "convertToContainerCoordinates", "layoutCoordinates", "offset", "convertToContainerCoordinates-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "startSelection", Const.POSITION, "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "updateSelection", "newPosition", "updateSelection-qNKwrvQ$foundation", "(Landroidx/compose/ui/geometry/Offset;JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "previousHandlePosition", "updateSelection-jyLRC_s$foundation", "(JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "getSelectionLayout", "getSelectionLayout-Wko1d7g", "(JJZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "selectionChanged", "selectionLayout", "newSelection", "shouldPerformHaptics", "shouldPerformHaptics$foundation", "selectWordAtPositionIfNotAlreadySelected", "selectWordAtPositionIfNotAlreadySelected-k-4lQ0M", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectionManager {
    public static final int $stable = 8;
    private LayoutCoordinates containerLayoutCoordinates;
    private CoroutineScope coroutineScope;
    private HapticFeedback hapticFeedBack;
    private boolean isLongPressOrClickSelection;
    private Function1<? super AnnotatedString, Unit> onCopyHandler;
    private PlatformSelectionBehaviors platformSelectionBehaviors;
    private Offset previousPosition;
    private SelectionLayout previousSelectionLayout;
    private final SelectionRegistrarImpl selectionRegistrar;
    private boolean shouldIgnoreCopyKeyEvent;
    private boolean showToolbar;
    private TextToolbar textToolbar;
    private final MutableState<Selection> _selection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    private final MutableState<Boolean> _isInTouchMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
    private Function1<? super Selection, Unit> onSelectionChange = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SelectionManager.onSelectionChange$lambda$0(this.f$0, (Selection) obj);
        }
    };
    private ToolbarRequester toolbarRequester = new ToolbarRequesterImpl();
    private FocusRequester focusRequester = new FocusRequester();

    /* JADX INFO: renamed from: hasFocus$delegate, reason: from kotlin metadata */
    private final MutableState hasFocus = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: derivedContentRect$delegate, reason: from kotlin metadata */
    private final State derivedContentRect = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.f$0.getContentRect();
        }
    });

    /* JADX INFO: renamed from: positionChangeState$delegate, reason: from kotlin metadata */
    private final MutableState positionChangeState = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());

    /* JADX INFO: renamed from: dragBeginPosition$delegate, reason: from kotlin metadata */
    private final MutableState dragBeginPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m5712boximpl(Offset.INSTANCE.m5739getZeroF1C5BW0()), null, 2, null);

    /* JADX INFO: renamed from: dragTotalDistance$delegate, reason: from kotlin metadata */
    private final MutableState dragTotalDistance = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m5712boximpl(Offset.INSTANCE.m5739getZeroF1C5BW0()), null, 2, null);

    /* JADX INFO: renamed from: startHandlePosition$delegate, reason: from kotlin metadata */
    private final MutableState startHandlePosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: endHandlePosition$delegate, reason: from kotlin metadata */
    private final MutableState endHandlePosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    public static /* synthetic */ void getPreviousSelectionLayout$foundation$annotations() {
    }

    public static /* synthetic */ void getToolbarRequester$foundation$annotations() {
    }

    public SelectionManager(SelectionRegistrarImpl selectionRegistrarImpl) {
        this.selectionRegistrar = selectionRegistrarImpl;
        selectionRegistrarImpl.setOnPositionChangeCallback$foundation(new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SelectionManager._init_$lambda$0(this.f$0, ((Long) obj).longValue());
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateStartCallback$foundation(new Function4() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SelectionManager._init_$lambda$1(this.f$0, ((Boolean) obj).booleanValue(), (LayoutCoordinates) obj2, (Offset) obj3, (SelectionAdjustment) obj4);
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateSelectAll$foundation(new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SelectionManager._init_$lambda$2(this.f$0, ((Boolean) obj).booleanValue(), ((Long) obj2).longValue());
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateCallback$foundation(new Function6() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function6
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return Boolean.valueOf(SelectionManager._init_$lambda$3(this.f$0, ((Boolean) obj).booleanValue(), (LayoutCoordinates) obj2, (Offset) obj3, (Offset) obj4, ((Boolean) obj5).booleanValue(), (SelectionAdjustment) obj6));
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateEndCallback$foundation(new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SelectionManager._init_$lambda$4(this.f$0);
            }
        });
        selectionRegistrarImpl.setOnSelectableChangeCallback$foundation(new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SelectionManager._init_$lambda$5(this.f$0, ((Long) obj).longValue());
            }
        });
        selectionRegistrarImpl.setAfterSelectableUnsubscribe$foundation(new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SelectionManager._init_$lambda$6(this.f$0, ((Long) obj).longValue());
            }
        });
    }

    public final Selection getSelection() {
        return this._selection.getValue();
    }

    public final void setSelection(Selection selection) {
        this._selection.setValue(selection);
        if (selection != null) {
            updateHandleOffsets();
        }
    }

    public final boolean isInTouchMode() {
        return this._isInTouchMode.getValue().booleanValue();
    }

    public final void setInTouchMode(boolean z) {
        if (this._isInTouchMode.getValue().booleanValue() != z) {
            this._isInTouchMode.setValue(Boolean.valueOf(z));
            updateSelectionToolbar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSelectionChange$lambda$0(SelectionManager selectionManager, Selection selection) {
        selectionManager.setSelection(selection);
        return Unit.INSTANCE;
    }

    public final Function1<Selection, Unit> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    public final void setOnSelectionChange(final Function1<? super Selection, Unit> function1) {
        this.onSelectionChange = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SelectionManager._set_onSelectionChange_$lambda$0(this.f$0, function1, (Selection) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _set_onSelectionChange_$lambda$0(SelectionManager selectionManager, Function1 function1, Selection selection) {
        selectionManager.setSelection(selection);
        function1.invoke(selection);
        return Unit.INSTANCE;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final Function1<AnnotatedString, Unit> getOnCopyHandler() {
        return this.onCopyHandler;
    }

    public final void setOnCopyHandler(Function1<? super AnnotatedString, Unit> function1) {
        this.onCopyHandler = function1;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    /* JADX INFO: renamed from: getToolbarRequester$foundation, reason: from getter */
    public final ToolbarRequester getToolbarRequester() {
        return this.toolbarRequester;
    }

    public final void setToolbarRequester$foundation(ToolbarRequester toolbarRequester) {
        this.toolbarRequester = toolbarRequester;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus.getValue()).booleanValue();
    }

    public final void setHasFocus(boolean z) {
        this.hasFocus.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDraggingInProgress() {
        return getDraggingHandle() != null;
    }

    /* JADX INFO: renamed from: getShouldIgnoreCopyKeyEvent$foundation, reason: from getter */
    public final boolean getShouldIgnoreCopyKeyEvent() {
        return this.shouldIgnoreCopyKeyEvent;
    }

    public final void setShouldIgnoreCopyKeyEvent$foundation(boolean z) {
        this.shouldIgnoreCopyKeyEvent = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_modifier_$lambda$0(SelectionManager selectionManager) {
        selectionManager.onRelease();
        return Unit.INSTANCE;
    }

    public final Modifier getModifier() {
        return addContextMenuComponents(KeyInputModifierKt.onKeyEvent(SelectionGesturesKt.updateSelectionTouchMode(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(Modifier.INSTANCE, new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SelectionManager._get_modifier_$lambda$0(this.f$0);
            }
        }), new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SelectionManager._get_modifier_$lambda$1(this.f$0, (LayoutCoordinates) obj);
            }
        }), this.focusRequester), new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SelectionManager._get_modifier_$lambda$2(this.f$0, (FocusState) obj);
            }
        }), false, null, 3, null), new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SelectionManager._get_modifier_$lambda$3(this.f$0, ((Boolean) obj).booleanValue());
            }
        }), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m2338invokeZmokQxo(keyEvent.m7133unboximpl());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m2338invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (this.this$0.getShouldIgnoreCopyKeyEvent() || !SelectionManager_androidKt.m2345isCopyKeyEventZmokQxo(keyEvent)) {
                    z = false;
                } else {
                    this.this$0.copy$foundation();
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }).then(getShouldShowMagnifier() ? SelectionManager_androidKt.selectionMagnifier(Modifier.INSTANCE, this) : Modifier.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_modifier_$lambda$1(SelectionManager selectionManager, LayoutCoordinates layoutCoordinates) {
        selectionManager.setContainerLayoutCoordinates(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_modifier_$lambda$2(SelectionManager selectionManager, FocusState focusState) {
        if (!focusState.getHasFocus() && selectionManager.getHasFocus()) {
            selectionManager.onRelease();
        }
        selectionManager.setHasFocus(focusState.getHasFocus());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_modifier_$lambda$3(SelectionManager selectionManager, boolean z) {
        selectionManager.setInTouchMode(z);
        return Unit.INSTANCE;
    }

    private final Rect getDerivedContentRect() {
        return (Rect) this.derivedContentRect.getValue();
    }

    public final Modifier getContextMenuAreaModifier() {
        return TextContextMenuToolbarHandlerModifierKt.textContextMenuToolbarHandler$default(TextContextMenuGesturesModifierKt.showTextContextMenuOnSecondaryClick(Modifier.INSTANCE, new SelectionManager$contextMenuAreaModifier$1(this, null)), this.toolbarRequester, new SelectionManager$contextMenuAreaModifier$2(this, null), null, new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SelectionManager._get_contextMenuAreaModifier_$lambda$0(this.f$0, (LayoutCoordinates) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect _get_contextMenuAreaModifier_$lambda$0(SelectionManager selectionManager, LayoutCoordinates layoutCoordinates) {
        Rect derivedContentRect = selectionManager.getDerivedContentRect();
        if (derivedContentRect == null) {
            return null;
        }
        LayoutCoordinates layoutCoordinates2 = selectionManager.containerLayoutCoordinates;
        if (layoutCoordinates2 != null) {
            return TextContextMenuToolbarHandlerModifierKt.translateRootToDestination(derivedContentRect, layoutCoordinates2, layoutCoordinates);
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.containerLayoutCoordinates = layoutCoordinates;
        if (!getHasFocus() || getSelection() == null) {
            return;
        }
        Offset offsetM5712boximpl = layoutCoordinates != null ? Offset.m5712boximpl(LayoutCoordinatesKt.positionInWindow(layoutCoordinates)) : null;
        if (Intrinsics.areEqual(this.previousPosition, offsetM5712boximpl)) {
            return;
        }
        this.previousPosition = offsetM5712boximpl;
        updateHandleOffsets();
        updateSelectionToolbar();
    }

    private final Unit getPositionChangeState() {
        this.positionChangeState.getValue();
        return Unit.INSTANCE;
    }

    private final void setPositionChangeState(Unit unit) {
        this.positionChangeState.setValue(unit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setDragBeginPosition-k-4lQ0M, reason: not valid java name */
    public final void m2324setDragBeginPositionk4lQ0M(long j) {
        this.dragBeginPosition.setValue(Offset.m5712boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getDragBeginPosition-F1C5BW0$foundation, reason: not valid java name */
    public final long m2330getDragBeginPositionF1C5BW0$foundation() {
        return ((Offset) this.dragBeginPosition.getValue()).m5733unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setDragTotalDistance-k-4lQ0M, reason: not valid java name */
    public final void m2325setDragTotalDistancek4lQ0M(long j) {
        this.dragTotalDistance.setValue(Offset.m5712boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getDragTotalDistance-F1C5BW0$foundation, reason: not valid java name */
    public final long m2331getDragTotalDistanceF1C5BW0$foundation() {
        return ((Offset) this.dragTotalDistance.getValue()).m5733unboximpl();
    }

    /* JADX INFO: renamed from: setStartHandlePosition-_kEHs6E, reason: not valid java name */
    private final void m2327setStartHandlePosition_kEHs6E(Offset offset) {
        this.startHandlePosition.setValue(offset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getStartHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m2333getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition.getValue();
    }

    /* JADX INFO: renamed from: setEndHandlePosition-_kEHs6E, reason: not valid java name */
    private final void m2326setEndHandlePosition_kEHs6E(Offset offset) {
        this.endHandlePosition.setValue(offset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getEndHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m2332getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    public final float getStartHandleLineHeight() {
        Selectable anchorSelectable$foundation;
        Selection selection = getSelection();
        if (selection == null || (anchorSelectable$foundation = getAnchorSelectable$foundation(selection.getStart())) == null) {
            return 0.0f;
        }
        return anchorSelectable$foundation.getLineHeight(selection.getStart().getOffset());
    }

    public final float getEndHandleLineHeight() {
        Selectable anchorSelectable$foundation;
        Selection selection = getSelection();
        if (selection == null || (anchorSelectable$foundation = getAnchorSelectable$foundation(selection.getEnd())) == null) {
            return 0.0f;
        }
        return anchorSelectable$foundation.getLineHeight(selection.getEnd().getOffset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m2323setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition.setValue(offset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m2329getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition.getValue();
    }

    private final boolean getShouldShowMagnifier() {
        return isDraggingInProgress() && isInTouchMode() && !isTriviallyCollapsedSelection$foundation();
    }

    /* JADX INFO: renamed from: getPreviousSelectionLayout$foundation, reason: from getter */
    public final SelectionLayout getPreviousSelectionLayout() {
        return this.previousSelectionLayout;
    }

    public final void setPreviousSelectionLayout$foundation(SelectionLayout selectionLayout) {
        this.previousSelectionLayout = selectionLayout;
    }

    /* JADX INFO: renamed from: getCoroutineScope$foundation, reason: from getter */
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final void setCoroutineScope$foundation(CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
    }

    /* JADX INFO: renamed from: getPlatformSelectionBehaviors$foundation, reason: from getter */
    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors() {
        return this.platformSelectionBehaviors;
    }

    public final void setPlatformSelectionBehaviors$foundation(PlatformSelectionBehaviors platformSelectionBehaviors) {
        this.platformSelectionBehaviors = platformSelectionBehaviors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(SelectionManager selectionManager, long j) {
        if (selectionManager.selectionRegistrar.getSubselections().containsKey(j)) {
            selectionManager.setPositionChangeState(Unit.INSTANCE);
            selectionManager.updateHandleOffsets();
            selectionManager.updateSelectionToolbar();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(SelectionManager selectionManager, boolean z, LayoutCoordinates layoutCoordinates, Offset offset, SelectionAdjustment selectionAdjustment) {
        long jM2116coerceIn3MmeM6k;
        long jMo7453getSizeYbymL2g = layoutCoordinates.mo7453getSizeYbymL2g();
        Rect rect = new Rect(0.0f, 0.0f, (int) (jMo7453getSizeYbymL2g >> 32), (int) (jMo7453getSizeYbymL2g & 4294967295L));
        if (SelectionManagerKt.m2340containsInclusiveUv8p0NA(rect, offset.m5733unboximpl())) {
            jM2116coerceIn3MmeM6k = offset.m5733unboximpl();
        } else {
            jM2116coerceIn3MmeM6k = TextLayoutStateKt.m2116coerceIn3MmeM6k(offset.m5733unboximpl(), rect);
        }
        long jM2321convertToContainerCoordinatesR5De75A = selectionManager.m2321convertToContainerCoordinatesR5De75A(layoutCoordinates, jM2116coerceIn3MmeM6k);
        if ((9223372034707292159L & jM2321convertToContainerCoordinatesR5De75A) != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            selectionManager.setInTouchMode(z);
            selectionManager.m2328startSelection9KIMszo(jM2321convertToContainerCoordinatesR5De75A, false, selectionAdjustment);
            FocusRequester.m5628requestFocus3ESFkO8$default(selectionManager.focusRequester, 0, 1, null);
            selectionManager.setShowToolbar$foundation(false);
            selectionManager.isLongPressOrClickSelection = true;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(SelectionManager selectionManager, boolean z, long j) {
        Pair<Selection, LongObjectMap<Selection>> pairSelectAllInSelectable$foundation = selectionManager.selectAllInSelectable$foundation(j, selectionManager.getSelection());
        Selection selectionComponent1 = pairSelectAllInSelectable$foundation.component1();
        LongObjectMap<Selection> longObjectMapComponent2 = pairSelectAllInSelectable$foundation.component2();
        if (!Intrinsics.areEqual(selectionComponent1, selectionManager.getSelection())) {
            selectionManager.selectionRegistrar.setSubselections(longObjectMapComponent2);
            selectionManager.onSelectionChange.invoke(selectionComponent1);
        }
        selectionManager.setInTouchMode(z);
        FocusRequester.m5628requestFocus3ESFkO8$default(selectionManager.focusRequester, 0, 1, null);
        selectionManager.setShowToolbar$foundation(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$3(SelectionManager selectionManager, boolean z, LayoutCoordinates layoutCoordinates, Offset offset, Offset offset2, boolean z2, SelectionAdjustment selectionAdjustment) {
        long jM2321convertToContainerCoordinatesR5De75A = selectionManager.m2321convertToContainerCoordinatesR5De75A(layoutCoordinates, offset.m5733unboximpl());
        long jM2321convertToContainerCoordinatesR5De75A2 = selectionManager.m2321convertToContainerCoordinatesR5De75A(layoutCoordinates, offset2.m5733unboximpl());
        selectionManager.setInTouchMode(z);
        return selectionManager.m2336updateSelectionqNKwrvQ$foundation(Offset.m5712boximpl(jM2321convertToContainerCoordinatesR5De75A), jM2321convertToContainerCoordinatesR5De75A2, z2, selectionAdjustment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$4(SelectionManager selectionManager) {
        selectionManager.setShowToolbar$foundation(true);
        selectionManager.setDraggingHandle(null);
        selectionManager.m2323setCurrentDragPosition_kEHs6E(null);
        if (selectionManager.isLongPressOrClickSelection && selectionManager.isNonEmptySelection$foundation()) {
            selectionManager.suggestSelectionForLongPressOrDoubleClick();
        }
        selectionManager.isLongPressOrClickSelection = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$5(SelectionManager selectionManager, long j) {
        if (selectionManager.selectionRegistrar.getSubselections().containsKey(j)) {
            selectionManager.onRelease();
            selectionManager.setSelection(null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$6(SelectionManager selectionManager, long j) {
        Selection.AnchorInfo end;
        Selection.AnchorInfo start;
        Selection selection = selectionManager.getSelection();
        if (selection != null && (start = selection.getStart()) != null && j == start.getSelectableId()) {
            selectionManager.m2327setStartHandlePosition_kEHs6E(null);
        }
        Selection selection2 = selectionManager.getSelection();
        if (selection2 != null && (end = selection2.getEnd()) != null && j == end.getSelectableId()) {
            selectionManager.m2326setEndHandlePosition_kEHs6E(null);
        }
        if (selectionManager.selectionRegistrar.getSubselections().containsKey(j)) {
            selectionManager.updateSelectionToolbar();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [T, androidx.compose.ui.text.AnnotatedString] */
    /* JADX WARN: Type inference failed for: r0v11, types: [T, androidx.compose.ui.text.TextRange] */
    private final void suggestSelectionForLongPressOrDoubleClick() {
        int iNextIndex;
        CoroutineScope coroutineScope;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Ref.LongRef longRef = new Ref.LongRef();
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation());
        ListIterator<Selectable> listIterator = listSort.listIterator(listSort.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            Selection selection = this.selectionRegistrar.getSubselections().get(listIterator.previous().getSelectableId());
            if (selection != null && selection.getStart().getOffset() != selection.getEnd().getOffset()) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        if (iNextIndex != -1) {
            int size = listSort.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                Selectable selectable = listSort.get(i);
                Selection selection2 = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId());
                if (selection2 != null) {
                    ?? text = selectable.getText();
                    long jTextRange = TextRangeKt.TextRange(selection2.getStart().getOffset(), selection2.getEnd().getOffset());
                    boolean z = i >= iNextIndex;
                    long selectableId = selectable.getSelectableId();
                    if (z) {
                        objectRef.element = text;
                        objectRef2.element = TextRange.m8261boximpl(jTextRange);
                        longRef.element = selectableId;
                    }
                } else {
                    i++;
                }
            }
        }
        if (objectRef.element == 0 || objectRef2.element == 0 || longRef.element == 0 || ((CharSequence) objectRef.element).length() <= 0 || (coroutineScope = this.coroutineScope) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(objectRef, objectRef2, longRef, null), 3, null);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$suggestSelectionForLongPressOrDoubleClick$2, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionManager$suggestSelectionForLongPressOrDoubleClick$2", f = "SelectionManager.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<TextRange> $selectionInSelectable;
        final /* synthetic */ Ref.LongRef $targetSelectableId;
        final /* synthetic */ Ref.ObjectRef<CharSequence> $textInSelectable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<CharSequence> objectRef, Ref.ObjectRef<TextRange> objectRef2, Ref.LongRef longRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$textInSelectable = objectRef;
            this.$selectionInSelectable = objectRef2;
            this.$targetSelectableId = longRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SelectionManager.this.new AnonymousClass2(this.$textInSelectable, this.$selectionInSelectable, this.$targetSelectableId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 222
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Selectable getAnchorSelectable$foundation(Selection.AnchorInfo anchor) {
        return this.selectionRegistrar.getSelectableMap$foundation().get(anchor.getSelectableId());
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateHandleOffsets() {
        /*
            r17 = this;
            r0 = r17
            androidx.compose.foundation.text.selection.Selection r1 = r0.getSelection()
            androidx.compose.ui.layout.LayoutCoordinates r2 = r0.containerLayoutCoordinates
            r3 = 0
            if (r1 == 0) goto L16
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r4 = r1.getStart()
            if (r4 == 0) goto L16
            androidx.compose.foundation.text.selection.Selectable r4 = r0.getAnchorSelectable$foundation(r4)
            goto L17
        L16:
            r4 = r3
        L17:
            if (r1 == 0) goto L24
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r5 = r1.getEnd()
            if (r5 == 0) goto L24
            androidx.compose.foundation.text.selection.Selectable r5 = r0.getAnchorSelectable$foundation(r5)
            goto L25
        L24:
            r5 = r3
        L25:
            if (r4 == 0) goto L2c
            androidx.compose.ui.layout.LayoutCoordinates r6 = r4.getLayoutCoordinates()
            goto L2d
        L2c:
            r6 = r3
        L2d:
            if (r5 == 0) goto L34
            androidx.compose.ui.layout.LayoutCoordinates r7 = r5.getLayoutCoordinates()
            goto L35
        L34:
            r7 = r3
        L35:
            if (r1 == 0) goto Lab
            if (r2 == 0) goto Lab
            boolean r8 = r2.isAttached()
            if (r8 == 0) goto Lab
            if (r6 != 0) goto L44
            if (r7 != 0) goto L44
            goto Lab
        L44:
            androidx.compose.ui.geometry.Rect r8 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r2)
            r9 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            r11 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            if (r6 == 0) goto L7b
            r13 = 1
            long r13 = r4.mo2276getHandlePositiondBAh8RU(r1, r13)
            long r15 = r13 & r11
            int r4 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r4 != 0) goto L60
            goto L7b
        L60:
            long r13 = r2.mo7454localPositionOfR5De75A(r6, r13)
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m5712boximpl(r13)
            long r13 = r4.m5733unboximpl()
            androidx.compose.foundation.text.Handle r6 = r0.getDraggingHandle()
            androidx.compose.foundation.text.Handle r15 = androidx.compose.foundation.text.Handle.SelectionStart
            if (r6 == r15) goto L7c
            boolean r6 = androidx.compose.foundation.text.selection.SelectionManagerKt.m2340containsInclusiveUv8p0NA(r8, r13)
            if (r6 == 0) goto L7b
            goto L7c
        L7b:
            r4 = r3
        L7c:
            r0.m2327setStartHandlePosition_kEHs6E(r4)
            if (r7 == 0) goto La7
            r4 = 0
            long r4 = r5.mo2276getHandlePositiondBAh8RU(r1, r4)
            long r11 = r11 & r4
            int r1 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r1 != 0) goto L8c
            goto La7
        L8c:
            long r1 = r2.mo7454localPositionOfR5De75A(r7, r4)
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m5712boximpl(r1)
            long r4 = r1.m5733unboximpl()
            androidx.compose.foundation.text.Handle r2 = r0.getDraggingHandle()
            androidx.compose.foundation.text.Handle r6 = androidx.compose.foundation.text.Handle.SelectionEnd
            if (r2 == r6) goto La6
            boolean r2 = androidx.compose.foundation.text.selection.SelectionManagerKt.m2340containsInclusiveUv8p0NA(r8, r4)
            if (r2 == 0) goto La7
        La6:
            r3 = r1
        La7:
            r0.m2326setEndHandlePosition_kEHs6E(r3)
            return
        Lab:
            r0.m2327setStartHandlePosition_kEHs6E(r3)
            r0.m2326setEndHandlePosition_kEHs6E(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.updateHandleOffsets():void");
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation() {
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (layoutCoordinates != null) {
            if (!layoutCoordinates.isAttached()) {
                InlineClassHelperKt.throwIllegalArgumentException("unattached coordinates");
            }
            return layoutCoordinates;
        }
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null coordinates");
        throw new KotlinNothingValueException();
    }

    public final Pair<Selection, LongObjectMap<Selection>> selectAllInSelectable$foundation(long selectableId, Selection previousSelection) {
        HapticFeedback hapticFeedback;
        MutableLongObjectMap mutableLongObjectMapMutableLongObjectMapOf = LongObjectMapKt.mutableLongObjectMapOf();
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation());
        int size = listSort.size();
        Selection selectionMerge = null;
        for (int i = 0; i < size; i++) {
            Selectable selectable = listSort.get(i);
            Selection selectAllSelection = selectable.getSelectableId() == selectableId ? selectable.getSelectAllSelection() : null;
            if (selectAllSelection != null) {
                mutableLongObjectMapMutableLongObjectMapOf.set(selectable.getSelectableId(), selectAllSelection);
            }
            selectionMerge = SelectionManagerKt.merge(selectionMerge, selectAllSelection);
        }
        if (isInTouchMode() && !Intrinsics.areEqual(selectionMerge, previousSelection) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo6744performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m6761getTextHandleMove5zf0vsI());
        }
        return new Pair<>(selectionMerge, mutableLongObjectMapMutableLongObjectMapOf);
    }

    public final boolean isEntireContainerSelected$foundation() {
        Selection selection;
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation());
        if (listSort.isEmpty()) {
            return true;
        }
        int size = listSort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = listSort.get(i);
            AnnotatedString text = selectable.getText();
            if (text.length() != 0 && ((selection = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId())) == null || Math.abs(selection.getStart().getOffset() - selection.getEnd().getOffset()) != text.length())) {
                return false;
            }
        }
        return true;
    }

    public final void selectAll$foundation() {
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation());
        if (listSort.isEmpty()) {
            return;
        }
        MutableLongObjectMap mutableLongObjectMapMutableLongObjectMapOf = LongObjectMapKt.mutableLongObjectMapOf();
        int size = listSort.size();
        Selection selection = null;
        Selection selection2 = null;
        for (int i = 0; i < size; i++) {
            Selectable selectable = listSort.get(i);
            Selection selectAllSelection = selectable.getSelectAllSelection();
            if (selectAllSelection != null) {
                if (selection == null) {
                    selection = selectAllSelection;
                }
                mutableLongObjectMapMutableLongObjectMapOf.put(selectable.getSelectableId(), selectAllSelection);
                selection2 = selectAllSelection;
            }
        }
        if (mutableLongObjectMapMutableLongObjectMapOf.isEmpty()) {
            return;
        }
        if (selection != selection2) {
            Intrinsics.checkNotNull(selection);
            Selection.AnchorInfo start = selection.getStart();
            Intrinsics.checkNotNull(selection2);
            selection = new Selection(start, selection2.getEnd(), false);
        }
        this.selectionRegistrar.setSubselections(mutableLongObjectMapMutableLongObjectMapOf);
        this.onSelectionChange.invoke(selection);
        this.previousSelectionLayout = null;
    }

    public final boolean isTriviallyCollapsedSelection$foundation() {
        Selection selection = getSelection();
        if (selection == null) {
            return true;
        }
        return Intrinsics.areEqual(selection.getStart(), selection.getEnd());
    }

    public final boolean isNonEmptySelection$foundation() {
        Selection selection = getSelection();
        if (selection == null || Intrinsics.areEqual(selection.getStart(), selection.getEnd())) {
            return false;
        }
        if (selection.getStart().getSelectableId() == selection.getEnd().getSelectableId()) {
            return true;
        }
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation());
        int size = listSort.size();
        for (int i = 0; i < size; i++) {
            Selection selection2 = this.selectionRegistrar.getSubselections().get(listSort.get(i).getSelectableId());
            if (selection2 != null && selection2.getStart().getOffset() != selection2.getEnd().getOffset()) {
                return true;
            }
        }
        return false;
    }

    public final AnnotatedString getSelectedText$foundation() {
        int iNextIndex;
        if (getSelection() == null || this.selectionRegistrar.getSubselections().isEmpty()) {
            return null;
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation());
        ListIterator<Selectable> listIterator = listSort.listIterator(listSort.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            Selection selection = this.selectionRegistrar.getSubselections().get(listIterator.previous().getSelectableId());
            if (selection != null && selection.getStart().getOffset() != selection.getEnd().getOffset()) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        if (iNextIndex != -1) {
            int size = listSort.size();
            int i = 0;
            while (i < size) {
                Selectable selectable = listSort.get(i);
                Selection selection2 = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId());
                if (selection2 != null) {
                    AnnotatedString text = selectable.getText();
                    long jTextRange = TextRangeKt.TextRange(selection2.getStart().getOffset(), selection2.getEnd().getOffset());
                    boolean z = i >= iNextIndex;
                    selectable.getSelectableId();
                    builder.append(text, TextRange.m8271getMinimpl(jTextRange), TextRange.m8270getMaximpl(jTextRange));
                    if (!z) {
                        builder.append('\n');
                    }
                }
                i++;
            }
        }
        return builder.toAnnotatedString();
    }

    public final Pair<AnnotatedString, TextRange> getContextTextAndSelection$foundation() {
        int iNextIndex;
        int iM8271getMinimpl;
        int length;
        Pair<AnnotatedString, TextRange> pair;
        Pair<AnnotatedString, TextRange> pair2 = null;
        if (getSelection() != null && !this.selectionRegistrar.getSelectables$foundation().isEmpty()) {
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation());
            ListIterator<Selectable> listIterator = listSort.listIterator(listSort.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    iNextIndex = -1;
                    break;
                }
                Selection selection = this.selectionRegistrar.getSubselections().get(listIterator.previous().getSelectableId());
                if (selection != null && selection.getStart().getOffset() != selection.getEnd().getOffset()) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            }
            if (iNextIndex != -1) {
                int size = listSort.size();
                int i = 0;
                iM8271getMinimpl = -1;
                length = -1;
                while (i < size) {
                    Selectable selectable = listSort.get(i);
                    Selection selection2 = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId());
                    if (selection2 != null) {
                        AnnotatedString text = selectable.getText();
                        long jTextRange = TextRangeKt.TextRange(selection2.getStart().getOffset(), selection2.getEnd().getOffset());
                        boolean z = i >= iNextIndex;
                        selectable.getSelectableId();
                        if (iM8271getMinimpl == -1) {
                            iM8271getMinimpl = TextRange.m8271getMinimpl(jTextRange);
                            builder.append(text, 0, TextRange.m8271getMinimpl(jTextRange));
                        }
                        pair = pair2;
                        builder.append(text, TextRange.m8271getMinimpl(jTextRange), TextRange.m8270getMaximpl(jTextRange));
                        if (!z) {
                            builder.append('\n');
                        } else {
                            length = builder.getLength();
                            builder.append(text, TextRange.m8270getMaximpl(jTextRange), text.length());
                        }
                    } else {
                        pair = pair2;
                    }
                    i++;
                    pair2 = pair;
                }
            } else {
                iM8271getMinimpl = -1;
                length = -1;
            }
            return (iM8271getMinimpl == -1 || length == -1) ? pair2 : new Pair<>(builder.toAnnotatedString(), TextRange.m8261boximpl(TextRangeKt.TextRange(iM8271getMinimpl, length)));
        }
        return null;
    }

    public final void forEachSelectableWithSelection$foundation(Function4<? super Long, ? super AnnotatedString, ? super TextRange, ? super Boolean, Boolean> block) {
        int iNextIndex;
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation());
        ListIterator<Selectable> listIterator = listSort.listIterator(listSort.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex = -1;
                break;
            }
            Selection selection = this.selectionRegistrar.getSubselections().get(listIterator.previous().getSelectableId());
            if (selection != null && selection.getStart().getOffset() != selection.getEnd().getOffset()) {
                iNextIndex = listIterator.nextIndex();
                break;
            }
        }
        if (iNextIndex == -1) {
            return;
        }
        int size = listSort.size();
        int i = 0;
        while (i < size) {
            Selectable selectable = listSort.get(i);
            Selection selection2 = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId());
            if (selection2 != null) {
                if (!block.invoke(Long.valueOf(selectable.getSelectableId()), selectable.getText(), TextRange.m8261boximpl(TextRangeKt.TextRange(selection2.getStart().getOffset(), selection2.getEnd().getOffset())), Boolean.valueOf(i >= iNextIndex)).booleanValue()) {
                    return;
                }
            }
            i++;
        }
    }

    public final void copy$foundation() {
        Function1<? super AnnotatedString, Unit> function1;
        AnnotatedString selectedText$foundation = getSelectedText$foundation();
        if (selectedText$foundation != null) {
            if (selectedText$foundation.length() <= 0) {
                selectedText$foundation = null;
            }
            if (selectedText$foundation == null || (function1 = this.onCopyHandler) == null) {
                return;
            }
            function1.invoke(selectedText$foundation);
        }
    }

    /* JADX INFO: renamed from: getShowToolbar$foundation, reason: from getter */
    public final boolean getShowToolbar() {
        return this.showToolbar;
    }

    public final void setShowToolbar$foundation(boolean z) {
        this.showToolbar = z;
        updateSelectionToolbar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toolbarCopy() {
        copy$foundation();
        onRelease();
    }

    private final void updateSelectionToolbar() {
        if (getHasFocus()) {
            if (ComposeFoundationFlags.isNewContextMenuEnabled) {
                if (this.showToolbar && isInTouchMode()) {
                    if (getDerivedContentRect() == null) {
                        return;
                    }
                    this.toolbarRequester.show();
                    return;
                }
                this.toolbarRequester.hide();
                return;
            }
            updateSelectionTextToolbar();
        }
    }

    public final boolean canCopy$foundation() {
        return this.onCopyHandler != null && isNonEmptySelection$foundation();
    }

    private final void updateSelectionTextToolbar() {
        TextToolbar textToolbar = this.textToolbar;
        if (textToolbar == null) {
            return;
        }
        if (this.showToolbar && isInTouchMode()) {
            Rect contentRect = getContentRect();
            if (contentRect == null) {
                return;
            }
            TextToolbar.showMenu$default(textToolbar, contentRect, canCopy$foundation() ? new C03791(this) : null, null, null, isEntireContainerSelected$foundation() ? null : new C03802(this), null, 12, null);
            return;
        }
        if (textToolbar.getStatus() == TextToolbarStatus.Shown) {
            textToolbar.hide();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$updateSelectionTextToolbar$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelectionManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final /* synthetic */ class C03791 extends FunctionReferenceImpl implements Function0<Unit> {
        C03791(Object obj) {
            super(0, obj, SelectionManager.class, "toolbarCopy", "toolbarCopy()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((SelectionManager) this.receiver).toolbarCopy();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$updateSelectionTextToolbar$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelectionManager.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final /* synthetic */ class C03802 extends FunctionReferenceImpl implements Function0<Unit> {
        C03802(Object obj) {
            super(0, obj, SelectionManager.class, "selectAll", "selectAll$foundation()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((SelectionManager) this.receiver).selectAll$foundation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        LayoutCoordinates layoutCoordinates;
        getPositionChangeState();
        if (getSelection() == null || (layoutCoordinates = this.containerLayoutCoordinates) == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation());
        ArrayList arrayList = new ArrayList(listSort.size());
        int size = listSort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = listSort.get(i);
            Selection selection = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId());
            Pair pair = selection != null ? TuplesKt.to(selectable, selection) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        List listFirstAndLast = SelectionManagerKt.firstAndLast(arrayList);
        if (listFirstAndLast.isEmpty()) {
            return null;
        }
        Rect selectedRegionRect = SelectionManagerKt.getSelectedRegionRect(listFirstAndLast, layoutCoordinates);
        if (Intrinsics.areEqual(selectedRegionRect, SelectionManagerKt.invertedInfiniteRect)) {
            return null;
        }
        Rect rectIntersect = SelectionManagerKt.visibleBounds(layoutCoordinates).intersect(selectedRegionRect);
        if (rectIntersect.getRight() - rectIntersect.getLeft() < 0.0f || rectIntersect.getBottom() - rectIntersect.getTop() < 0.0f) {
            return null;
        }
        Rect rectM5760translatek4lQ0M = rectIntersect.m5760translatek4lQ0M(LayoutCoordinatesKt.positionInRoot(layoutCoordinates));
        return Rect.copy$default(rectM5760translatek4lQ0M, 0.0f, 0.0f, 0.0f, rectM5760translatek4lQ0M.getBottom() + (SelectionHandlesKt.getHandleHeight() * 4), 7, null);
    }

    public final void onRelease() {
        HapticFeedback hapticFeedback;
        this.selectionRegistrar.setSubselections(LongObjectMapKt.emptyLongObjectMap());
        setShowToolbar$foundation(false);
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            if (!isInTouchMode() || (hapticFeedback = this.hapticFeedBack) == null) {
                return;
            }
            hapticFeedback.mo6744performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m6761getTextHandleMove5zf0vsI());
        }
    }

    public final TextDragObserver handleDragObserver(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.SelectionManager.handleDragObserver.1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo1818onDownk4lQ0M(long point) {
                LayoutCoordinates layoutCoordinates;
                Offset offsetM2333getStartHandlePosition_m7T9E = isStartHandle ? this.m2333getStartHandlePosition_m7T9E() : this.m2332getEndHandlePosition_m7T9E();
                if (offsetM2333getStartHandlePosition_m7T9E != null) {
                    offsetM2333getStartHandlePosition_m7T9E.m5733unboximpl();
                    Selection selection = this.getSelection();
                    if (selection == null) {
                        return;
                    }
                    Selectable anchorSelectable$foundation = this.getAnchorSelectable$foundation(isStartHandle ? selection.getStart() : selection.getEnd());
                    if (anchorSelectable$foundation == null || (layoutCoordinates = anchorSelectable$foundation.getLayoutCoordinates()) == null) {
                        return;
                    }
                    long jMo2276getHandlePositiondBAh8RU = anchorSelectable$foundation.mo2276getHandlePositiondBAh8RU(selection, isStartHandle);
                    if ((9223372034707292159L & jMo2276getHandlePositiondBAh8RU) == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
                        return;
                    }
                    long jM2306getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m2306getAdjustedCoordinatesk4lQ0M(jMo2276getHandlePositiondBAh8RU);
                    SelectionManager selectionManager = this;
                    selectionManager.m2323setCurrentDragPosition_kEHs6E(Offset.m5712boximpl(selectionManager.requireContainerCoordinates$foundation().mo7454localPositionOfR5De75A(layoutCoordinates, jM2306getAdjustedCoordinatesk4lQ0M)));
                    this.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                    this.setShowToolbar$foundation(false);
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-3MmeM6k */
            public void mo1820onStart3MmeM6k(long startPoint, SelectionAdjustment selectionAdjustment) {
                if (this.getDraggingHandle() == null) {
                    return;
                }
                Selection selection = this.getSelection();
                Intrinsics.checkNotNull(selection);
                Selectable selectable = this.selectionRegistrar.getSelectableMap$foundation().get((isStartHandle ? selection.getStart() : selection.getEnd()).getSelectableId());
                if (selectable != null) {
                    Selectable selectable2 = selectable;
                    LayoutCoordinates layoutCoordinates = selectable2.getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        long jMo2276getHandlePositiondBAh8RU = selectable2.mo2276getHandlePositiondBAh8RU(selection, isStartHandle);
                        if ((9223372034707292159L & jMo2276getHandlePositiondBAh8RU) == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
                            return;
                        }
                        long jM2306getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m2306getAdjustedCoordinatesk4lQ0M(jMo2276getHandlePositiondBAh8RU);
                        SelectionManager selectionManager = this;
                        selectionManager.m2324setDragBeginPositionk4lQ0M(selectionManager.requireContainerCoordinates$foundation().mo7454localPositionOfR5De75A(layoutCoordinates, jM2306getAdjustedCoordinatesk4lQ0M));
                        this.m2325setDragTotalDistancek4lQ0M(Offset.INSTANCE.m5739getZeroF1C5BW0());
                        return;
                    }
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Current selectable should have layout coordinates.");
                    throw new KotlinNothingValueException();
                }
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("SelectionRegistrar should contain the current selection's selectableIds");
                throw new KotlinNothingValueException();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo1819onDragk4lQ0M(long delta) {
                if (this.getDraggingHandle() == null) {
                    return;
                }
                SelectionManager selectionManager = this;
                selectionManager.m2325setDragTotalDistancek4lQ0M(Offset.m5728plusMKHz9U(selectionManager.m2331getDragTotalDistanceF1C5BW0$foundation(), delta));
                long jM5728plusMKHz9U = Offset.m5728plusMKHz9U(this.m2330getDragBeginPositionF1C5BW0$foundation(), this.m2331getDragTotalDistanceF1C5BW0$foundation());
                if (this.m2336updateSelectionqNKwrvQ$foundation(Offset.m5712boximpl(jM5728plusMKHz9U), this.m2330getDragBeginPositionF1C5BW0$foundation(), isStartHandle, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate())) {
                    this.m2324setDragBeginPositionk4lQ0M(jM5728plusMKHz9U);
                    this.m2325setDragTotalDistancek4lQ0M(Offset.INSTANCE.m5739getZeroF1C5BW0());
                }
            }

            private final void done() {
                this.setShowToolbar$foundation(true);
                this.setDraggingHandle(null);
                this.m2323setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                done();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                done();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                done();
            }
        };
    }

    private final Modifier addContextMenuComponents(Modifier modifier) {
        return ComposeFoundationFlags.isNewContextMenuEnabled ? SelectionManager_androidKt.addSelectionContainerTextContextMenuComponents(modifier, this) : modifier;
    }

    private final Modifier onClearSelectionRequested(Modifier modifier, final Function0<Unit> function0) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, Unit.INSTANCE, new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionManager.onClearSelectionRequested.1

            /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SelectionManager.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1$1", f = "SelectionManager.kt", i = {0}, l = {1001, 1007}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"}, v = 1)
            static final class C00411 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function0<Unit> $block;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ SelectionManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00411(SelectionManager selectionManager, Function0<Unit> function0, Continuation<? super C00411> continuation) {
                    super(2, continuation);
                    this.this$0 = selectionManager;
                    this.$block = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00411 c00411 = new C00411(this.this$0, this.$block, continuation);
                    c00411.L$0 = obj;
                    return c00411;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C00411) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
                
                    if (r11 == r0) goto L16;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r10.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L22
                        if (r1 == r3) goto L1a
                        if (r1 != r2) goto L12
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L50
                    L12:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r0)
                        throw r11
                    L1a:
                        java.lang.Object r1 = r10.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L3d
                    L22:
                        kotlin.ResultKt.throwOnFailure(r11)
                        java.lang.Object r11 = r10.L$0
                        r4 = r11
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                        r7 = r10
                        kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                        r10.L$0 = r4
                        r10.label = r3
                        r5 = 0
                        r6 = 0
                        r8 = 2
                        r9 = 0
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitPrimaryFirstDown$default(r4, r5, r6, r7, r8, r9)
                        if (r11 != r0) goto L3c
                        goto L4f
                    L3c:
                        r1 = r4
                    L3d:
                        androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                        androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r4 = r10
                        kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                        r5 = 0
                        r10.L$0 = r5
                        r10.label = r2
                        java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitAllPointersUpWithSlopDetection(r1, r11, r3, r4)
                        if (r11 != r0) goto L50
                    L4f:
                        return r0
                    L50:
                        java.lang.Boolean r11 = (java.lang.Boolean) r11
                        boolean r11 = r11.booleanValue()
                        if (r11 != 0) goto L65
                        androidx.compose.foundation.text.selection.SelectionManager r11 = r10.this$0
                        boolean r11 = androidx.compose.foundation.text.selection.SelectionManager.access$isDraggingInProgress(r11)
                        if (r11 != 0) goto L65
                        kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r10.$block
                        r11.invoke()
                    L65:
                        kotlin.Unit r11 = kotlin.Unit.INSTANCE
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.C03781.C00411.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C00411(SelectionManager.this, function0, null), continuation);
                return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: renamed from: convertToContainerCoordinates-R5De75A, reason: not valid java name */
    private final long m2321convertToContainerCoordinatesR5De75A(LayoutCoordinates layoutCoordinates, long offset) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        return requireContainerCoordinates$foundation().mo7454localPositionOfR5De75A(layoutCoordinates, offset);
    }

    /* JADX INFO: renamed from: startSelection-9KIMszo, reason: not valid java name */
    private final void m2328startSelection9KIMszo(long position, boolean isStartHandle, SelectionAdjustment adjustment) {
        this.previousSelectionLayout = null;
        m2335updateSelectionjyLRC_s$foundation(position, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0(), isStartHandle, adjustment);
    }

    /* JADX INFO: renamed from: updateSelection-qNKwrvQ$foundation, reason: not valid java name */
    public final boolean m2336updateSelectionqNKwrvQ$foundation(Offset newPosition, long previousPosition, boolean isStartHandle, SelectionAdjustment adjustment) {
        if (newPosition == null) {
            return false;
        }
        return m2335updateSelectionjyLRC_s$foundation(newPosition.m5733unboximpl(), previousPosition, isStartHandle, adjustment);
    }

    /* JADX INFO: renamed from: updateSelection-jyLRC_s$foundation, reason: not valid java name */
    public final boolean m2335updateSelectionjyLRC_s$foundation(long position, long previousHandlePosition, boolean isStartHandle, SelectionAdjustment adjustment) {
        setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
        m2323setCurrentDragPosition_kEHs6E(Offset.m5712boximpl(position));
        SelectionLayout selectionLayoutM2322getSelectionLayoutWko1d7g = m2322getSelectionLayoutWko1d7g(position, previousHandlePosition, isStartHandle);
        if (selectionLayoutM2322getSelectionLayoutWko1d7g == null || !selectionLayoutM2322getSelectionLayoutWko1d7g.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return false;
        }
        Selection selectionAdjust = adjustment.adjust(selectionLayoutM2322getSelectionLayoutWko1d7g);
        if (!Intrinsics.areEqual(selectionAdjust, getSelection())) {
            selectionChanged(selectionLayoutM2322getSelectionLayoutWko1d7g, selectionAdjust);
            this.isLongPressOrClickSelection = false;
        }
        this.previousSelectionLayout = selectionLayoutM2322getSelectionLayoutWko1d7g;
        return true;
    }

    /* JADX INFO: renamed from: getSelectionLayout-Wko1d7g, reason: not valid java name */
    private final SelectionLayout m2322getSelectionLayoutWko1d7g(long position, long previousHandlePosition, boolean isStartHandle) {
        LayoutCoordinates layoutCoordinatesRequireContainerCoordinates$foundation = requireContainerCoordinates$foundation();
        List<Selectable> listSort = this.selectionRegistrar.sort(layoutCoordinatesRequireContainerCoordinates$foundation);
        final MutableLongIntMap mutableLongIntMapMutableLongIntMapOf = LongIntMapKt.mutableLongIntMapOf();
        List<Selectable> list = listSort;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mutableLongIntMapMutableLongIntMapOf.set(listSort.get(i).getSelectableId(), i);
        }
        SelectionLayoutBuilder selectionLayoutBuilder = new SelectionLayoutBuilder(position, previousHandlePosition, layoutCoordinatesRequireContainerCoordinates$foundation, isStartHandle, (previousHandlePosition & 9223372034707292159L) == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? null : getSelection(), new Comparator() { // from class: androidx.compose.foundation.text.selection.SelectionManager$getSelectionLayout-Wko1d7g$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(mutableLongIntMapMutableLongIntMapOf.get(((Number) t).longValue())), Integer.valueOf(mutableLongIntMapMutableLongIntMapOf.get(((Number) t2).longValue())));
            }
        }, null);
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            listSort.get(i2).appendSelectableInfoToBuilder(selectionLayoutBuilder);
        }
        return selectionLayoutBuilder.build();
    }

    private final void selectionChanged(SelectionLayout selectionLayout, Selection newSelection) {
        HapticFeedback hapticFeedback;
        if (shouldPerformHaptics$foundation() && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo6744performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m6761getTextHandleMove5zf0vsI());
        }
        this.selectionRegistrar.setSubselections(selectionLayout.createSubSelections(newSelection));
        this.onSelectionChange.invoke(newSelection);
    }

    public final boolean shouldPerformHaptics$foundation() {
        if (isInTouchMode()) {
            List<Selectable> selectables$foundation = this.selectionRegistrar.getSelectables$foundation();
            int size = selectables$foundation.size();
            for (int i = 0; i < size; i++) {
                if (selectables$foundation.get(i).getText().length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX INFO: renamed from: selectWordAtPositionIfNotAlreadySelected-k-4lQ0M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2334selectWordAtPositionIfNotAlreadySelectedk4lQ0M(long r12) {
        /*
            r11 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r11.containerLayoutCoordinates
            if (r0 != 0) goto L5
            goto Lb
        L5:
            boolean r1 = r0.isAttached()
            if (r1 != 0) goto Lc
        Lb:
            return
        Lc:
            androidx.compose.foundation.text.selection.SelectionRegistrarImpl r1 = r11.selectionRegistrar
            java.util.List r1 = r1.getSelectables$foundation()
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r3 = 0
            r4 = r3
        L1b:
            if (r4 >= r2) goto L5b
            java.lang.Object r5 = r1.get(r4)
            androidx.compose.foundation.text.selection.Selectable r5 = (androidx.compose.foundation.text.selection.Selectable) r5
            androidx.compose.foundation.text.selection.SelectionRegistrarImpl r6 = r11.selectionRegistrar
            androidx.collection.LongObjectMap r6 = r6.getSubselections()
            long r7 = r5.getSelectableId()
            java.lang.Object r6 = r6.get(r7)
            androidx.compose.foundation.text.selection.Selection r6 = (androidx.compose.foundation.text.selection.Selection) r6
            if (r6 != 0) goto L37
        L35:
            r5 = r3
            goto L55
        L37:
            androidx.compose.ui.layout.LayoutCoordinates r7 = r5.getLayoutCoordinates()
            if (r7 != 0) goto L3e
            goto L35
        L3e:
            long r7 = r7.mo7454localPositionOfR5De75A(r0, r12)
            androidx.compose.ui.text.TextLayoutResult r5 = r5.textLayoutResult()
            if (r5 != 0) goto L49
            goto L35
        L49:
            long r9 = r6.m2296toTextRanged9O1mEE()
            androidx.compose.ui.text.TextRange r6 = androidx.compose.ui.text.TextRange.m8261boximpl(r9)
            boolean r5 = androidx.compose.foundation.text.TextLayoutHelperKt.m1859isPositionInsideSelectionuaM50fQ(r5, r7, r6)
        L55:
            if (r5 == 0) goto L58
            return
        L58:
            int r4 = r4 + 1
            goto L1b
        L5b:
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r0 = androidx.compose.foundation.text.selection.SelectionAdjustment.INSTANCE
            androidx.compose.foundation.text.selection.SelectionAdjustment r0 = r0.getWord()
            r1 = 1
            r11.m2328startSelection9KIMszo(r12, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.m2334selectWordAtPositionIfNotAlreadySelectedk4lQ0M(long):void");
    }
}
