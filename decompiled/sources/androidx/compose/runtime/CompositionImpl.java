package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.composer.linkbuffer.changelist.ChangeList;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.ObservableComposition;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: Composition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010R\u001a\u00020OH\u0002J\b\u0010S\u001a\u000206H\u0002J \u0010e\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010_J \u0010g\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010_J \u0010h\u001a\u00020i2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010jJ \u0010k\u001a\u00020i2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010jJ\u001d\u0010l\u001a\u00020Z2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010nH\u0000¢\u0006\u0002\bpJ \u0010q\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010_J(\u0010r\u001a\u00020i2\u0006\u0010s\u001a\u00020;2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010tJ \u0010u\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010_J\b\u0010v\u001a\u00020ZH\u0002J\b\u0010w\u001a\u00020;H\u0002J\u0010\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{H\u0016J\u000e\u0010|\u001a\u00020Z2\u0006\u0010}\u001a\u00020GJ\b\u0010~\u001a\u00020ZH\u0002J\b\u0010\u007f\u001a\u00020ZH\u0002J\t\u0010\u0080\u0001\u001a\u00020ZH\u0002J!\u0010\u0081\u0001\u001a\u00020Z2\u0011\u0010f\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0017¢\u0006\u0002\u0010_J\u000f\u0010\u0082\u0001\u001a\u00020ZH\u0000¢\u0006\u0003\b\u0083\u0001J\t\u0010\u0084\u0001\u001a\u00020ZH\u0016J\u0018\u0010\u0087\u0001\u001a\u00020Z2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110'H\u0016J\u0018\u0010\u0089\u0001\u001a\u00020;2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110'H\u0016J\u0018\u0010\u008a\u0001\u001a\u00020Z2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020Z0YH\u0016J,\u0010\u008c\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110\u008d\u0001022\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0000¢\u0006\u0003\b\u0090\u0001J:\u0010\u0091\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110\u008d\u0001022\u0015\u0010\u0092\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u008f\u0001\u0012\u0004\u0012\u00020;0\u0093\u0001H\u0080\b¢\u0006\u0003\b\u0094\u0001J\u001b\u0010\u0095\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u00112\u0007\u0010\u0097\u0001\u001a\u00020;H\u0002J!\u0010\u0095\u0001\u001a\u00020Z2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110'2\u0007\u0010\u0097\u0001\u001a\u00020;H\u0002J\t\u0010\u0098\u0001\u001a\u00020ZH\u0002J\u0012\u0010\u0099\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u0011H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u009b\u0001\u001a\u00020Z2\u0007\u0010\u0096\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u009c\u0001\u001a\u00020;H\u0016J)\u0010\u009d\u0001\u001a\u00020Z2\u001e\u0010\u009e\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u009f\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009f\u00010\u008d\u000102H\u0016J\u0012\u0010 \u0001\u001a\u00020Z2\u0007\u0010U\u001a\u00030¡\u0001H\u0016J\u0011\u0010¢\u0001\u001a\u00020Z2\u0006\u00105\u001a\u000206H\u0002J\t\u0010£\u0001\u001a\u00020ZH\u0016J\t\u0010¤\u0001\u001a\u00020ZH\u0016J\t\u0010¥\u0001\u001a\u00020ZH\u0016JL\u0010¦\u0001\u001a\u0003H§\u0001\"\u0005\b\u0000\u0010§\u000122\u0010\u008b\u0001\u001a-\u0012!\u0012\u001f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#¢\u0006\u000e\b¨\u0001\u0012\t\b©\u0001\u0012\u0004\b\b(5\u0012\u0005\u0012\u0003H§\u00010\u0093\u0001H\u0082\b¢\u0006\u0003\u0010ª\u0001J(\u0010«\u0001\u001a\u0003H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u0003H§\u00010YH\u0082\b¢\u0006\u0003\u0010¬\u0001J\t\u0010\u00ad\u0001\u001a\u00020ZH\u0016J\t\u0010®\u0001\u001a\u00020ZH\u0016J\t\u0010¯\u0001\u001a\u00020ZH\u0016J;\u0010°\u0001\u001a\u0003H±\u0001\"\u0005\b\u0000\u0010±\u00012\t\u0010²\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010³\u0001\u001a\u00020G2\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u0003H±\u00010YH\u0016¢\u0006\u0003\u0010´\u0001J\u0015\u0010µ\u0001\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u001e\u0010¶\u0001\u001a\u00030·\u00012\u0007\u0010¸\u0001\u001a\u00020$2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010º\u0001\u001a\u00020Z2\u0007\u0010¸\u0001\u001a\u00020$H\u0016J)\u0010»\u0001\u001a\u0005\u0018\u0001H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000e\u0010}\u001a\n\u0012\u0005\u0012\u0003H§\u00010¼\u0001H\u0016¢\u0006\u0003\u0010½\u0001J\u001d\u0010¾\u0001\u001a\u00020;2\u0007\u0010¸\u0001\u001a\u00020$2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J(\u0010¿\u0001\u001a\u00030·\u00012\u0007\u0010¸\u0001\u001a\u00020$2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J!\u0010À\u0001\u001a\u00020Z2\u0007\u0010¹\u0001\u001a\u00020\u00112\u0007\u0010¸\u0001\u001a\u00020$H\u0000¢\u0006\u0003\bÁ\u0001J\u001b\u0010Â\u0001\u001a\u00020Z2\n\u0010U\u001a\u0006\u0012\u0002\b\u00030.H\u0000¢\u0006\u0003\bÃ\u0001J\u001e\u0010Ä\u0001\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#H\u0002¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J(\u0010Ç\u0001\u001a\u0003H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000e\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u0003H§\u00010YH\u0082\b¢\u0006\u0003\u0010¬\u0001J\n\u0010z\u001a\u0004\u0018\u00010{H\u0002J\t\u0010È\u0001\u001a\u00020ZH\u0016J\u000f\u0010É\u0001\u001a\u00020GH\u0000¢\u0006\u0003\bÊ\u0001R\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001a\u00060\u0011j\u0002`\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110'8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030.0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110'8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b0\u0010)R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020$028AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001c\u00109\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#X\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R \u0010:\u001a\u00020;X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\u001b\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\u00020IX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010N\u001a\u00020OX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010T\u001a\u00020;¢\u0006\b\n\u0000\u001a\u0004\bT\u0010>R\u000e\u0010U\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\u00020;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010>R'\u0010X\u001a\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[X\u0086\u000e¢\u0006\u0010\n\u0002\u0010`\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010>R\u0014\u0010b\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010>R\u0014\u0010c\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010>R\u0016\u0010\u0085\u0001\u001a\u00020;8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010>¨\u0006Ë\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "Landroidx/compose/runtime/PausableComposition;", "Landroidx/compose/runtime/tooling/ObservableComposition;", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "<init>", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;)V", "getParent", "()Landroidx/compose/runtime/CompositionContext;", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "getAbandonSet$annotations", "()V", "slotStorage", "Landroidx/compose/runtime/SlotStorage;", "getSlotStorage$runtime$annotations", "getSlotStorage$runtime", "()Landroidx/compose/runtime/SlotStorage;", "createSlotStorage", "observations", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/collection/MutableScatterMap;", "observedObjects", "", "getObservedObjects$runtime", "()Ljava/util/Set;", "invalidatedScopes", "Landroidx/collection/MutableScatterSet;", "conditionallyInvalidatedScopes", "derivedStates", "Landroidx/compose/runtime/DerivedState;", "derivedStateDependencies", "getDerivedStateDependencies$runtime", "conditionalScopes", "", "getConditionalScopes$runtime", "()Ljava/util/List;", "changes", "Landroidx/compose/runtime/Changes;", "lateChanges", "observationsProcessed", "invalidations", "pendingInvalidScopes", "", "getPendingInvalidScopes$runtime$annotations", "getPendingInvalidScopes$runtime", "()Z", "setPendingInvalidScopes$runtime", "(Z)V", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "pendingPausedComposition", "Landroidx/compose/runtime/PausedCompositionImpl;", "invalidationDelegate", "invalidationDelegateGroup", "", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "composer", "Landroidx/compose/runtime/InternalComposer;", "getComposer$runtime", "()Landroidx/compose/runtime/InternalComposer;", "createComposer", "createChangeList", "isRoot", "state", "areChildrenComposing", "getAreChildrenComposing", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "isComposing", "isDisposed", "hasPendingChanges", "getHasPendingChanges", "setContent", "content", "setContentWithReuse", "setPausableContent", "Landroidx/compose/runtime/PausedComposition;", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "setPausableContentWithReuse", "pausedCompositionFinished", "ignoreSet", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RememberObserverHolder;", "pausedCompositionFinished$runtime", "composeInitial", "composeInitialPaused", "reusable", "(ZLkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "composeInitialWithReuse", "ensureRunning", "clearDeactivated", "setObserver", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "invalidateGroupsWithKey", "key", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "drainPendingModificationsOutOfBandLocked", "composeContent", "updateMovingInvalidations", "updateMovingInvalidations$runtime", "dispose", "hasInvalidations", "getHasInvalidations", "recordModificationsOf", "values", "observesAnyOf", "prepareCompose", BlockContactsIQ.ELEMENT, "extractInvalidationsOf", "Lkotlin/Pair;", ReferenceElement.ATTR_ANCHOR, "Landroidx/compose/runtime/Anchor;", "extractInvalidationsOf$runtime", "extractInvalidationsOfGroup", "inGroup", "Lkotlin/Function1;", "extractInvalidationsOfGroup$runtime", "addPendingInvalidationsLocked", "value", "forgetConditionalScopes", "cleanUpDerivedStateObservations", "recordReadOf", "invalidateScopeOfLocked", "recordWriteOf", "recompose", "insertMovableContent", "references", "Landroidx/compose/runtime/MovableContentStateReference;", "disposeUnusedMovableContent", "Landroidx/compose/runtime/MovableContentState;", "applyChangesInLocked", "applyChanges", "applyLateChanges", "changesApplied", "guardInvalidationsLocked", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "abandonChanges", "invalidateAll", "verifyConsistent", "delegateInvalidations", "R", "to", "groupIndex", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAndSetShouldPauseCallback", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "recomposeScopeReleased", "getCompositionService", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "tryImminentInvalidation", "invalidateChecked", "removeObservation", "removeObservation$runtime", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime", "takeInvalidations", "takeInvalidations-afanTW4", "()Landroidx/collection/MutableScatterMap;", "trackAbandonedValues", "deactivate", "composerStacksSizes", "composerStacksSizes$runtime", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices, PausableComposition, ObservableComposition {
    public static final int $stable = 8;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final Changes changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final InternalComposer composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final MutableScatterMap<Object, Object> derivedStates;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private MutableScatterMap<Object, Object> invalidations;
    private final boolean isRoot;
    private final Changes lateChanges;
    private final MutableScatterMap<Object, Object> observations;
    private final MutableScatterMap<Object, Object> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private PausedCompositionImpl pendingPausedComposition;
    private final RememberEventDispatcher rememberManager;
    private ShouldPauseCallback shouldPause;
    private final SlotStorage slotStorage;
    private int state;
    private final AtomicReference<Object> pendingModifications = new AtomicReference<>(null);
    private final Object lock = new Object();

    private static /* synthetic */ void getAbandonSet$annotations() {
    }

    public static /* synthetic */ void getPendingInvalidScopes$runtime$annotations() {
    }

    public static /* synthetic */ void getSlotStorage$runtime$annotations() {
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier) {
        this.parent = compositionContext;
        this.applier = applier;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i = 0;
        int i2 = 1;
        this.abandonSet = new MutableScatterSet(i, i2, defaultConstructorMarker).asMutableSet();
        SlotStorage slotStorageCreateSlotStorage = createSlotStorage();
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            slotStorageCreateSlotStorage.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation()) {
            slotStorageCreateSlotStorage.collectSourceInformation();
        }
        this.slotStorage = slotStorageCreateSlotStorage;
        this.observations = ScopeMap.m5109constructorimpl$default(null, 1, null);
        this.invalidatedScopes = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
        this.derivedStates = ScopeMap.m5109constructorimpl$default(null, 1, null);
        this.changes = createChangeList();
        this.lateChanges = createChangeList();
        this.observationsProcessed = ScopeMap.m5109constructorimpl$default(null, 1, null);
        this.invalidations = ScopeMap.m5109constructorimpl$default(null, 1, null);
        this.observerHolder = new CompositionObserverHolder(null, false, compositionContext, 3, null);
        this.rememberManager = new RememberEventDispatcher();
        InternalComposer internalComposerCreateComposer = createComposer();
        compositionContext.registerComposer$runtime(internalComposerCreateComposer);
        this.composer = internalComposerCreateComposer;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$954879418$runtime();
    }

    public final CompositionContext getParent() {
        return this.parent;
    }

    /* JADX INFO: renamed from: getSlotStorage$runtime, reason: from getter */
    public final SlotStorage getSlotStorage() {
        return this.slotStorage;
    }

    private final SlotStorage createSlotStorage() {
        if (ComposeRuntimeFlags.isLinkBufferComposerEnabled) {
            return new SlotTable(0, null, false, false, 15, null);
        }
        return new androidx.compose.runtime.composer.gapbuffer.SlotTable();
    }

    public final Set<Object> getObservedObjects$runtime() {
        return this.observations.asMap().keySet();
    }

    public final Set<Object> getDerivedStateDependencies$runtime() {
        return this.derivedStates.asMap().keySet();
    }

    public final List<RecomposeScopeImpl> getConditionalScopes$runtime() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes.asSet());
    }

    /* JADX INFO: renamed from: getPendingInvalidScopes$runtime, reason: from getter */
    public final boolean getPendingInvalidScopes() {
        return this.pendingInvalidScopes;
    }

    public final void setPendingInvalidScopes$runtime(boolean z) {
        this.pendingInvalidScopes = z;
    }

    /* JADX INFO: renamed from: getObserverHolder$runtime, reason: from getter */
    public final CompositionObserverHolder getObserverHolder() {
        return this.observerHolder;
    }

    /* JADX INFO: renamed from: getComposer$runtime, reason: from getter */
    public final InternalComposer getComposer() {
        return this.composer;
    }

    private final InternalComposer createComposer() {
        if (ComposeRuntimeFlags.isLinkBufferComposerEnabled) {
            return new LinkComposer(this.applier, this.parent, this.abandonSet, SlotTableKt.asLinkBufferSlotTable(this.slotStorage), this.changes, this.lateChanges, this.observerHolder, this);
        }
        return new GapComposer(this.applier, this.parent, androidx.compose.runtime.composer.gapbuffer.SlotTableKt.asGapBufferSlotTable(this.slotStorage), this.abandonSet, this.changes, this.lateChanges, this.observerHolder, this);
    }

    private final Changes createChangeList() {
        if (ComposeRuntimeFlags.isLinkBufferComposerEnabled) {
            return new ChangeList();
        }
        return new androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList();
    }

    /* JADX INFO: renamed from: isRoot, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime();
    }

    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    public final void setComposable(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.composable = function2;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.state == 3;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime;
        synchronized (this.lock) {
            hasPendingChanges$runtime = this.composer.getHasPendingChanges$runtime();
        }
        return hasPendingChanges$runtime;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        boolean zClearDeactivated = clearDeactivated();
        ensureRunning();
        if (zClearDeactivated) {
            composeInitialWithReuse(content);
        } else {
            composeInitial(content);
        }
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        clearDeactivated();
        ensureRunning();
        composeInitialWithReuse(content);
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContent(Function2<? super Composer, ? super Integer, Unit> content) {
        return composeInitialPaused(clearDeactivated(), content);
    }

    @Override // androidx.compose.runtime.PausableComposition
    public PausedComposition setPausableContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        clearDeactivated();
        ensureRunning();
        return composeInitialPaused(true, content);
    }

    public final void pausedCompositionFinished$runtime(ScatterSet<RememberObserverHolder> ignoreSet) {
        this.pendingPausedComposition = null;
        if (ignoreSet != null) {
            this.rememberManager.ignoreForgotten(ignoreSet);
            this.state = 2;
        }
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composable = content;
        this.parent.composeInitial$runtime(this, content);
    }

    private final PausedComposition composeInitialPaused(boolean reusable, Function2<? super Composer, ? super Integer, Unit> content) {
        if (!(this.pendingPausedComposition == null)) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
        PausedCompositionImpl pausedCompositionImpl = new PausedCompositionImpl(this, this.parent, this.composer, this.abandonSet, content, reusable, this.applier, this.lock);
        this.pendingPausedComposition = pausedCompositionImpl;
        return pausedCompositionImpl;
    }

    private final void composeInitialWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composer.startReuseFromRoot$runtime();
        composeInitial(content);
        this.composer.endReuseFromRoot$runtime();
    }

    private final void ensureRunning() {
        String str;
        int i = this.state;
        if (!(i == 0)) {
            if (i == 1) {
                str = "The composition should be activated before setting content.";
            } else if (i == 2) {
                str = "A previous pausable composition for this composition was cancelled. This composition must be disposed.";
            } else if (i == 3) {
                str = "The composition is disposed";
            } else {
                str = "";
            }
            PreconditionsKt.throwIllegalStateException(str);
        }
        if (this.pendingPausedComposition == null) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
    }

    private final boolean clearDeactivated() {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (this.state != 1) {
                z = false;
            }
            if (z) {
                this.state = 0;
            }
        }
        return z;
    }

    @Override // androidx.compose.runtime.tooling.ObservableComposition
    public CompositionObserverHandle setObserver(final CompositionObserver observer) {
        synchronized (this.lock) {
            this.observerHolder.setObserver(observer);
            this.observerHolder.setRoot(true);
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.CompositionImpl.setObserver.2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object obj = CompositionImpl.this.lock;
                CompositionImpl compositionImpl = CompositionImpl.this;
                CompositionObserver compositionObserver = observer;
                synchronized (obj) {
                    if (Intrinsics.areEqual(compositionImpl.getObserverHolder().getObserver(), compositionObserver)) {
                        compositionImpl.getObserverHolder().setObserver(null);
                        compositionImpl.getObserverHolder().setRoot(false);
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    public final void invalidateGroupsWithKey(int key) {
        List<RecomposeScopeImpl> listInvalidateGroupsWithKey;
        synchronized (this.lock) {
            listInvalidateGroupsWithKey = this.slotStorage.invalidateGroupsWithKey(key);
        }
        if (listInvalidateGroupsWithKey != null) {
            int size = listInvalidateGroupsWithKey.size();
            for (int i = 0; i < size; i++) {
                if (listInvalidateGroupsWithKey.get(i).invalidateForResult(null) != InvalidationResult.IGNORED) {
                }
            }
            return;
        }
        if (this.composer.forceRecomposeScopes$runtime()) {
            this.parent.invalidate$runtime(this);
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet != null) {
            if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) andSet, true);
                return;
            }
            if (andSet instanceof Object[]) {
                for (Set<? extends Object> set : (Set[]) andSet) {
                    addPendingInvalidationsLocked(set, true);
                }
                return;
            }
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet(null);
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        if (andSet == null) {
            if (this.pendingPausedComposition == null) {
                ComposerKt.composeImmediateRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
                return;
            }
            return;
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    private final void drainPendingModificationsOutOfBandLocked() {
        Object andSet = this.pendingModifications.getAndSet(SetsKt.emptySet());
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                MutableScatterMap<Object, Object> mutableScatterMapM5009takeInvalidationsafanTW4 = m5009takeInvalidationsafanTW4();
                try {
                    this.composer.mo5015composeContentZbOJvo$runtime(mutableScatterMapM5009takeInvalidationsafanTW4, content, this.shouldPause);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th) {
                    this.invalidations = mutableScatterMapM5009takeInvalidationsafanTW4;
                    throw th;
                }
            }
            Unit unit3 = Unit.INSTANCE;
        } catch (Throwable th2) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th3) {
                        rememberEventDispatcher.clear();
                        throw th3;
                    }
                }
                throw th2;
            } catch (Throwable th4) {
                abandonChanges();
                throw th4;
            }
        }
    }

    public final void updateMovingInvalidations$runtime() {
        synchronized (this.lock) {
            drainPendingModificationsOutOfBandLocked();
            MutableScatterMap<Object, Object> mutableScatterMapM5009takeInvalidationsafanTW4 = m5009takeInvalidationsafanTW4();
            try {
                this.composer.mo5017updateComposerInvalidationsRY85e9Y$runtime(mutableScatterMapM5009takeInvalidationsafanTW4);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                this.invalidations = mutableScatterMapM5009takeInvalidationsafanTW4;
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            if (this.composer.getIsComposing()) {
                PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            }
            if (this.state != 3) {
                this.state = 3;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$1918065384$runtime();
                Changes deferredChanges$runtime = this.composer.getDeferredChanges();
                if (deferredChanges$runtime != null) {
                    applyChangesInLocked(deferredChanges$runtime);
                }
                boolean zIsEmpty = this.slotStorage.isEmpty();
                if (!zIsEmpty || !this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        if (!zIsEmpty) {
                            this.applier.onBeginChanges();
                            this.slotStorage.clear(this.rememberManager);
                            this.applier.clear();
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        }
                        rememberEventDispatcher.dispatchAbandons();
                    } finally {
                        rememberEventDispatcher.clear();
                    }
                }
                this.composer.dispose$runtime();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z;
        synchronized (this.lock) {
            z = ScopeMap.m5117getSizeimpl(this.invalidations) > 0;
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Object objPlus;
        do {
            obj = this.pendingModifications.get();
            if (obj == null || Intrinsics.areEqual(obj, CompositionKt.PendingApplyNoModifications)) {
                objPlus = values;
            } else if (obj instanceof Set) {
                objPlus = new Set[]{obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                objPlus = ArraysKt.plus((Set<? extends Object>[]) obj, values);
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, obj, objPlus));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        this.composer.prepareCompose$runtime(block);
    }

    public final List<Pair<RecomposeScopeImpl, Object>> extractInvalidationsOf$runtime(Anchor anchor) {
        long[] jArr;
        long[] jArr2;
        int i;
        int i2;
        long j;
        char c2;
        long j2;
        int i3;
        boolean zIsEmpty;
        Object[] objArr;
        int i4;
        long j3;
        Object[] objArr2;
        boolean z;
        if (ScopeMap.m5117getSizeimpl(this.invalidations) > 0) {
            ArrayList arrayList = new ArrayList();
            SlotStorage slotStorage = this.slotStorage;
            MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j4 = jArr3[i5];
                    char c3 = 7;
                    long j5 = -9187201950435737472L;
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8;
                        int i7 = 8 - ((~(i5 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j4 & 255) < 128) {
                                c2 = c3;
                                int i9 = (i5 << 3) + i8;
                                j2 = j5;
                                Object obj = mutableScatterMap.keys[i9];
                                Object obj2 = mutableScatterMap.values[i9];
                                int i10 = i6;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                                boolean z2 = true;
                                if (obj2 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                    Object[] objArr3 = mutableScatterSet.elements;
                                    long[] jArr4 = mutableScatterSet.metadata;
                                    jArr2 = jArr3;
                                    int length2 = jArr4.length - 2;
                                    if (length2 >= 0) {
                                        j = j4;
                                        int i11 = 0;
                                        while (true) {
                                            long j6 = jArr4[i11];
                                            i = length;
                                            i2 = i8;
                                            if ((((~j6) << c2) & j6 & j2) != j2) {
                                                int i12 = 8 - ((~(i11 - length2)) >>> 31);
                                                int i13 = 0;
                                                while (i13 < i12) {
                                                    if ((j6 & 255) < 128) {
                                                        i4 = i13;
                                                        int i14 = (i11 << 3) + i4;
                                                        j3 = j6;
                                                        Object obj3 = objArr3[i14];
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                                                        objArr2 = objArr3;
                                                        Anchor anchor2 = recomposeScopeImpl.getAnchor();
                                                        if (anchor2 == null || !slotStorage.inGroup(anchor, anchor2)) {
                                                            z = false;
                                                        } else {
                                                            arrayList.add(TuplesKt.to(recomposeScopeImpl, obj3));
                                                            z = true;
                                                        }
                                                        if (z) {
                                                            mutableScatterSet.removeElementAt(i14);
                                                        }
                                                    } else {
                                                        i4 = i13;
                                                        j3 = j6;
                                                        objArr2 = objArr3;
                                                    }
                                                    j6 = j3 >> i10;
                                                    i13 = i4 + 1;
                                                    objArr3 = objArr2;
                                                }
                                                objArr = objArr3;
                                                if (i12 != i10) {
                                                    break;
                                                }
                                            } else {
                                                objArr = objArr3;
                                            }
                                            if (i11 == length2) {
                                                break;
                                            }
                                            i11++;
                                            length = i;
                                            i8 = i2;
                                            objArr3 = objArr;
                                            i10 = 8;
                                        }
                                    } else {
                                        i = length;
                                        i2 = i8;
                                        j = j4;
                                    }
                                    zIsEmpty = mutableScatterSet.isEmpty();
                                } else {
                                    jArr2 = jArr3;
                                    i = length;
                                    i2 = i8;
                                    j = j4;
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
                                    Anchor anchor3 = recomposeScopeImpl2.getAnchor();
                                    if (anchor3 == null || !slotStorage.inGroup(anchor, anchor3)) {
                                        z2 = false;
                                    } else {
                                        arrayList.add(TuplesKt.to(recomposeScopeImpl2, obj2));
                                    }
                                    zIsEmpty = z2;
                                }
                                if (zIsEmpty) {
                                    mutableScatterMap.removeValueAt(i9);
                                }
                                i3 = 8;
                            } else {
                                jArr2 = jArr3;
                                i = length;
                                i2 = i8;
                                j = j4;
                                c2 = c3;
                                j2 = j5;
                                i3 = i6;
                            }
                            j4 = j >> i3;
                            i6 = i3;
                            c3 = c2;
                            j5 = j2;
                            jArr3 = jArr2;
                            length = i;
                            i8 = i2 + 1;
                        }
                        jArr = jArr3;
                        int i15 = length;
                        if (i7 != i6) {
                            break;
                        }
                        length = i15;
                    } else {
                        jArr = jArr3;
                    }
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                    jArr3 = jArr;
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    public final List<Pair<RecomposeScopeImpl, Object>> extractInvalidationsOfGroup$runtime(Function1<? super Anchor, Boolean> inGroup) {
        long[] jArr;
        long[] jArr2;
        long j;
        char c2;
        long j2;
        int i;
        int i2;
        boolean zIsEmpty;
        Object obj;
        long j3;
        Object obj2;
        int i3;
        boolean z;
        if (ScopeMap.m5117getSizeimpl(this.invalidations) > 0) {
            ArrayList arrayList = new ArrayList();
            MutableScatterMap mutableScatterMap = this.invalidations;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i4 = 0;
                while (true) {
                    long j4 = jArr3[i4];
                    char c3 = 7;
                    long j5 = -9187201950435737472L;
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i5 = 8;
                        int i6 = 8 - ((~(i4 - length)) >>> 31);
                        int i7 = 0;
                        while (i7 < i6) {
                            if ((j4 & 255) < 128) {
                                int i8 = (i4 << 3) + i7;
                                c2 = c3;
                                Object obj3 = mutableScatterMap.keys[i8];
                                j2 = j5;
                                Object obj4 = mutableScatterMap.values[i8];
                                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                                boolean z2 = true;
                                if (obj4 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj4;
                                    Object[] objArr = mutableScatterSet.elements;
                                    long[] jArr4 = mutableScatterSet.metadata;
                                    int i9 = i5;
                                    int length2 = jArr4.length - 2;
                                    jArr2 = jArr3;
                                    j = j4;
                                    if (length2 >= 0) {
                                        int i10 = 0;
                                        while (true) {
                                            long j6 = jArr4[i10];
                                            Object[] objArr2 = objArr;
                                            i = i7;
                                            if ((((~j6) << c2) & j6 & j2) != j2) {
                                                int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                                int i12 = 0;
                                                while (i12 < i11) {
                                                    if ((j6 & 255) < 128) {
                                                        j3 = j6;
                                                        int i13 = (i10 << 3) + i12;
                                                        Object obj5 = objArr2[i13];
                                                        obj2 = obj3;
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj2;
                                                        i3 = i12;
                                                        Anchor anchor = recomposeScopeImpl.getAnchor();
                                                        if (anchor == null || !inGroup.invoke(anchor).booleanValue()) {
                                                            z = false;
                                                        } else {
                                                            arrayList.add(TuplesKt.to(recomposeScopeImpl, obj5));
                                                            z = true;
                                                        }
                                                        if (z) {
                                                            mutableScatterSet.removeElementAt(i13);
                                                        }
                                                    } else {
                                                        j3 = j6;
                                                        obj2 = obj3;
                                                        i3 = i12;
                                                    }
                                                    j6 = j3 >> i9;
                                                    i12 = i3 + 1;
                                                    obj3 = obj2;
                                                }
                                                obj = obj3;
                                                if (i11 != i9) {
                                                    break;
                                                }
                                            } else {
                                                obj = obj3;
                                            }
                                            if (i10 == length2) {
                                                break;
                                            }
                                            i10++;
                                            i7 = i;
                                            objArr = objArr2;
                                            obj3 = obj;
                                            i9 = 8;
                                        }
                                    } else {
                                        i = i7;
                                    }
                                    zIsEmpty = mutableScatterSet.isEmpty();
                                } else {
                                    jArr2 = jArr3;
                                    j = j4;
                                    i = i7;
                                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj3;
                                    Anchor anchor2 = recomposeScopeImpl2.getAnchor();
                                    if (anchor2 == null || !inGroup.invoke(anchor2).booleanValue()) {
                                        z2 = false;
                                    } else {
                                        arrayList.add(TuplesKt.to(recomposeScopeImpl2, obj4));
                                    }
                                    zIsEmpty = z2;
                                }
                                if (zIsEmpty) {
                                    mutableScatterMap.removeValueAt(i8);
                                }
                                i2 = 8;
                            } else {
                                jArr2 = jArr3;
                                j = j4;
                                c2 = c3;
                                j2 = j5;
                                i = i7;
                                i2 = i5;
                            }
                            i7 = i + 1;
                            i5 = i2;
                            j4 = j >> i2;
                            c3 = c2;
                            j5 = j2;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i6 != i5) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                    jArr3 = jArr;
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    private final void addPendingInvalidationsLocked(Object value, boolean forgetConditionalScopes) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (!ScopeMap.m5122removeimpl(this.observationsProcessed, value, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(value) != InvalidationResult.IGNORED) {
                                if (recomposeScopeImpl.isConditional() && !forgetConditionalScopes) {
                                    this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                } else {
                                    this.invalidatedScopes.add(recomposeScopeImpl);
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (ScopeMap.m5122removeimpl(this.observationsProcessed, value, recomposeScopeImpl2) || recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IGNORED) {
                return;
            }
            if (recomposeScopeImpl2.isConditional() && !forgetConditionalScopes) {
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
            } else {
                this.invalidatedScopes.add(recomposeScopeImpl2);
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        long j;
        char c2;
        long j2;
        long j3;
        long[] jArr;
        long[] jArr2;
        int i;
        long j4;
        char c3;
        long j5;
        int i2;
        long[] jArr3;
        int i3;
        int i4;
        MutableScatterMap<Object, Object> mutableScatterMap = this.derivedStates;
        long[] jArr4 = mutableScatterMap.metadata;
        int length = jArr4.length - 2;
        long j6 = 255;
        char c4 = 7;
        long j7 = -9187201950435737472L;
        int i5 = 8;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j8 = jArr4[i6];
                j3 = 128;
                if ((((~j8) << c4) & j8 & j7) != j7) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j8 & j6) < 128) {
                            j4 = j6;
                            int i9 = (i6 << 3) + i8;
                            Object obj = mutableScatterMap.keys[i9];
                            Object obj2 = mutableScatterMap.values[i9];
                            c3 = c4;
                            boolean zIsEmpty = true;
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.elements;
                                j5 = j7;
                                long[] jArr5 = mutableScatterSet.metadata;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    int i10 = i5;
                                    int i11 = 0;
                                    while (true) {
                                        long j9 = jArr5[i11];
                                        Object[] objArr2 = objArr;
                                        long[] jArr6 = jArr5;
                                        if ((((~j9) << c3) & j9 & j5) != j5) {
                                            int i12 = 8 - ((~(i11 - length2)) >>> 31);
                                            int i13 = 0;
                                            while (i13 < i12) {
                                                if ((j9 & j4) < 128) {
                                                    jArr3 = jArr4;
                                                    int i14 = (i11 << 3) + i13;
                                                    i3 = i8;
                                                    i4 = i13;
                                                    if (!ScopeMap.m5110containsimpl(this.observations, (DerivedState) objArr2[i14])) {
                                                        mutableScatterSet.removeElementAt(i14);
                                                    }
                                                } else {
                                                    jArr3 = jArr4;
                                                    i3 = i8;
                                                    i4 = i13;
                                                }
                                                j9 >>= i10;
                                                i13 = i4 + 1;
                                                jArr4 = jArr3;
                                                i8 = i3;
                                            }
                                            jArr2 = jArr4;
                                            i = i8;
                                            if (i12 != i10) {
                                                break;
                                            }
                                        } else {
                                            jArr2 = jArr4;
                                            i = i8;
                                        }
                                        int i15 = i11;
                                        if (i15 == length2) {
                                            break;
                                        }
                                        i11 = i15 + 1;
                                        objArr = objArr2;
                                        jArr5 = jArr6;
                                        jArr4 = jArr2;
                                        i8 = i;
                                        i10 = 8;
                                    }
                                } else {
                                    jArr2 = jArr4;
                                    i = i8;
                                }
                                zIsEmpty = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr4;
                                i = i8;
                                j5 = j7;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                if (ScopeMap.m5110containsimpl(this.observations, (DerivedState) obj2)) {
                                    zIsEmpty = false;
                                }
                            }
                            if (zIsEmpty) {
                                mutableScatterMap.removeValueAt(i9);
                            }
                            i2 = 8;
                        } else {
                            jArr2 = jArr4;
                            i = i8;
                            j4 = j6;
                            c3 = c4;
                            j5 = j7;
                            i2 = i5;
                        }
                        j8 >>= i2;
                        i8 = i + 1;
                        i5 = i2;
                        c4 = c3;
                        j6 = j4;
                        j7 = j5;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    j = j6;
                    c2 = c4;
                    j2 = j7;
                    if (i7 != i5) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                    j = j6;
                    c2 = c4;
                    j2 = j7;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
                c4 = c2;
                j6 = j;
                j7 = j2;
                jArr4 = jArr;
                i5 = 8;
            }
        } else {
            j = 255;
            c2 = 7;
            j2 = -9187201950435737472L;
            j3 = 128;
        }
        if (!this.conditionallyInvalidatedScopes.isNotEmpty()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        Object[] objArr3 = mutableScatterSet2.elements;
        long[] jArr7 = mutableScatterSet2.metadata;
        int length3 = jArr7.length - 2;
        if (length3 < 0) {
            return;
        }
        int i16 = 0;
        while (true) {
            long j10 = jArr7[i16];
            if ((((~j10) << c2) & j10 & j2) != j2) {
                int i17 = 8 - ((~(i16 - length3)) >>> 31);
                for (int i18 = 0; i18 < i17; i18++) {
                    if ((j10 & j) < j3) {
                        int i19 = (i16 << 3) + i18;
                        if (!((RecomposeScopeImpl) objArr3[i19]).isConditional()) {
                            mutableScatterSet2.removeElementAt(i19);
                        }
                    }
                    j10 >>= 8;
                }
                if (i17 != 8) {
                    return;
                }
            }
            if (i16 == length3) {
                return;
            } else {
                i16++;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        int i;
        int i2;
        int i3;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime = this.composer.getCurrentRecomposeScope$runtime()) == null) {
            return;
        }
        int i4 = 1;
        currentRecomposeScope$runtime.setUsed(true);
        boolean zRecordRead = currentRecomposeScope$runtime.recordRead(value);
        CompositionObserver compositionObserverObserver = observer();
        if (compositionObserverObserver != null) {
            compositionObserverObserver.onReadInScope(currentRecomposeScope$runtime, value);
        }
        if (zRecordRead) {
            return;
        }
        if (value instanceof StateObjectImpl) {
            ReaderKind.Companion companion = ReaderKind.INSTANCE;
            ((StateObjectImpl) value).m5378recordReadInh_f27i8$runtime(ReaderKind.m5362constructorimpl(1));
        }
        ScopeMap.m5102addimpl(this.observations, value, currentRecomposeScope$runtime);
        if (value instanceof DerivedState) {
            DerivedState<?> derivedState = (DerivedState) value;
            DerivedState.Record<?> currentRecord = derivedState.getCurrentRecord();
            ScopeMap.m5124removeScopeimpl(this.derivedStates, value);
            ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
            Object[] objArr = dependencies.keys;
            long[] jArr = dependencies.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j = jArr[i5];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8;
                        int i7 = 8 - ((~(i5 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j & 255) < 128) {
                                i2 = i4;
                                StateObject stateObject = (StateObject) objArr[(i5 << 3) + i8];
                                if (stateObject instanceof StateObjectImpl) {
                                    ReaderKind.Companion companion2 = ReaderKind.INSTANCE;
                                    i3 = i6;
                                    ((StateObjectImpl) stateObject).m5378recordReadInh_f27i8$runtime(ReaderKind.m5362constructorimpl(i2));
                                } else {
                                    i3 = i6;
                                }
                                ScopeMap.m5102addimpl(this.derivedStates, stateObject, value);
                            } else {
                                i2 = i4;
                                i3 = i6;
                            }
                            j >>= i3;
                            i8++;
                            i4 = i2;
                            i6 = i3;
                        }
                        i = i4;
                        if (i7 != i6) {
                            break;
                        }
                    } else {
                        i = i4;
                    }
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                    i4 = i;
                }
            }
            currentRecomposeScope$runtime.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        Object obj = this.observations.get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i << 3) + i3];
                            if (recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                                ScopeMap.m5102addimpl(this.observationsProcessed, value, recomposeScopeImpl);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i == length) {
                    return;
                } else {
                    i++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                ScopeMap.m5102addimpl(this.observationsProcessed, value, recomposeScopeImpl2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void recordWriteOf(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.lock
            monitor-enter(r0)
            r14.invalidateScopeOfLocked(r15)     // Catch: java.lang.Throwable -> L64
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r1 = r14.derivedStates     // Catch: java.lang.Throwable -> L64
            java.lang.Object r15 = r1.get(r15)     // Catch: java.lang.Throwable -> L64
            if (r15 == 0) goto L60
            boolean r1 = r15 instanceof androidx.collection.MutableScatterSet     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L5b
            androidx.collection.MutableScatterSet r15 = (androidx.collection.MutableScatterSet) r15     // Catch: java.lang.Throwable -> L64
            androidx.collection.ScatterSet r15 = (androidx.collection.ScatterSet) r15     // Catch: java.lang.Throwable -> L64
            java.lang.Object[] r1 = r15.elements     // Catch: java.lang.Throwable -> L64
            long[] r15 = r15.metadata     // Catch: java.lang.Throwable -> L64
            int r2 = r15.length     // Catch: java.lang.Throwable -> L64
            int r2 = r2 + (-2)
            if (r2 < 0) goto L60
            r3 = 0
            r4 = r3
        L21:
            r5 = r15[r4]     // Catch: java.lang.Throwable -> L64
            long r7 = ~r5     // Catch: java.lang.Throwable -> L64
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L56
            int r7 = r4 - r2
            int r7 = ~r7     // Catch: java.lang.Throwable -> L64
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L3b:
            if (r9 >= r7) goto L54
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L50
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]     // Catch: java.lang.Throwable -> L64
            androidx.compose.runtime.DerivedState r10 = (androidx.compose.runtime.DerivedState) r10     // Catch: java.lang.Throwable -> L64
            r14.invalidateScopeOfLocked(r10)     // Catch: java.lang.Throwable -> L64
        L50:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L3b
        L54:
            if (r7 != r8) goto L60
        L56:
            if (r4 == r2) goto L60
            int r4 = r4 + 1
            goto L21
        L5b:
            androidx.compose.runtime.DerivedState r15 = (androidx.compose.runtime.DerivedState) r15     // Catch: java.lang.Throwable -> L64
            r14.invalidateScopeOfLocked(r15)     // Catch: java.lang.Throwable -> L64
        L60:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L64
            monitor-exit(r0)
            return
        L64:
            r15 = move-exception
            monitor-exit(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordWriteOf(java.lang.Object):void");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        synchronized (this.lock) {
            PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
            if (pausedCompositionImpl != null && !pausedCompositionImpl.isRecomposing$runtime()) {
                pausedCompositionImpl.markIncomplete$runtime();
                pausedCompositionImpl.getPausableApplier$runtime().markRecomposePending();
                return false;
            }
            drainPendingModificationsForCompositionLocked();
            try {
                try {
                    boolean zMo5016recomposeaFTiNEg$runtime = this.composer.mo5016recomposeaFTiNEg$runtime(m5009takeInvalidationsafanTW4(), this.shouldPause);
                    if (!zMo5016recomposeaFTiNEg$runtime) {
                        drainPendingModificationsLocked();
                    }
                    return zMo5016recomposeaFTiNEg$runtime;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
            state.getSlotStorage().disposeUnusedMovableContent(this.rememberManager, state);
            rememberEventDispatcher.dispatchRememberObservers();
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    private final void applyChangesInLocked(Changes changes) {
        String str;
        RememberEventDispatcher rememberManager$runtime;
        long[] jArr;
        long[] jArr2;
        long j;
        char c2;
        long j2;
        int i;
        boolean zIsEmpty;
        long[] jArr3;
        RecordingApplier<Object> pausableApplier$runtime;
        this.rememberManager.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
        try {
            if (!changes.isEmpty()) {
                PausedCompositionImpl pausedCompositionImpl = this.pendingPausedComposition;
                RecordingApplier<Object> recordingApplier = (pausedCompositionImpl == null || (pausableApplier$runtime = pausedCompositionImpl.getPausableApplier$runtime()) == null) ? this.applier : pausableApplier$runtime;
                PausedCompositionImpl pausedCompositionImpl2 = this.pendingPausedComposition;
                if (Intrinsics.areEqual(recordingApplier, pausedCompositionImpl2 != null ? pausedCompositionImpl2.getPausableApplier$runtime() : null)) {
                    str = "Compose:recordChanges";
                } else {
                    str = "Compose:applyChanges";
                }
                Object objBeginSection = Trace.INSTANCE.beginSection(str);
                try {
                    PausedCompositionImpl pausedCompositionImpl3 = this.pendingPausedComposition;
                    if (pausedCompositionImpl3 == null || (rememberManager$runtime = pausedCompositionImpl3.getRememberManager()) == null) {
                        rememberManager$runtime = this.rememberManager;
                    }
                    recordingApplier.onBeginChanges();
                    changes.execute(this.slotStorage, recordingApplier, rememberManager$runtime, this.composer.getErrorContext$runtime());
                    recordingApplier.onEndChanges();
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(objBeginSection);
                    this.rememberManager.dispatchRememberObservers();
                    this.rememberManager.dispatchSideEffects();
                    if (this.pendingInvalidScopes) {
                        objBeginSection = Trace.INSTANCE.beginSection("Compose:unobserve");
                        int i2 = 0;
                        try {
                            this.pendingInvalidScopes = false;
                            MutableScatterMap<Object, Object> mutableScatterMap = this.observations;
                            long[] jArr4 = mutableScatterMap.metadata;
                            int length = jArr4.length - 2;
                            if (length >= 0) {
                                int i3 = 0;
                                while (true) {
                                    long j3 = jArr4[i3];
                                    char c3 = 7;
                                    long j4 = -9187201950435737472L;
                                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i4 = 8;
                                        int i5 = 8 - ((~(i3 - length)) >>> 31);
                                        int i6 = i2;
                                        while (i6 < i5) {
                                            if ((j3 & 255) < 128) {
                                                int i7 = (i3 << 3) + i6;
                                                c2 = c3;
                                                Object obj = mutableScatterMap.keys[i7];
                                                Object obj2 = mutableScatterMap.values[i7];
                                                j2 = j4;
                                                if (obj2 instanceof MutableScatterSet) {
                                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                                    MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                                    Object[] objArr = mutableScatterSet.elements;
                                                    long[] jArr5 = mutableScatterSet.metadata;
                                                    int length2 = jArr5.length - 2;
                                                    if (length2 >= 0) {
                                                        j = j3;
                                                        int i8 = i4;
                                                        int i9 = 0;
                                                        while (true) {
                                                            long j5 = jArr5[i9];
                                                            Object[] objArr2 = objArr;
                                                            long[] jArr6 = jArr5;
                                                            if ((((~j5) << c2) & j5 & j2) != j2) {
                                                                int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                                                int i11 = 0;
                                                                while (i11 < i10) {
                                                                    if ((j5 & 255) < 128) {
                                                                        jArr3 = jArr4;
                                                                        int i12 = (i9 << 3) + i11;
                                                                        if (!((RecomposeScopeImpl) objArr2[i12]).getValid()) {
                                                                            mutableScatterSet.removeElementAt(i12);
                                                                        }
                                                                    } else {
                                                                        jArr3 = jArr4;
                                                                    }
                                                                    j5 >>= i8;
                                                                    i11++;
                                                                    jArr4 = jArr3;
                                                                }
                                                                jArr2 = jArr4;
                                                                if (i10 != i8) {
                                                                    break;
                                                                }
                                                            } else {
                                                                jArr2 = jArr4;
                                                            }
                                                            if (i9 == length2) {
                                                                break;
                                                            }
                                                            i9++;
                                                            objArr = objArr2;
                                                            jArr5 = jArr6;
                                                            jArr4 = jArr2;
                                                            i8 = 8;
                                                        }
                                                    } else {
                                                        jArr2 = jArr4;
                                                        j = j3;
                                                    }
                                                    zIsEmpty = mutableScatterSet.isEmpty();
                                                } else {
                                                    jArr2 = jArr4;
                                                    j = j3;
                                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                                    zIsEmpty = !((RecomposeScopeImpl) obj2).getValid();
                                                }
                                                if (zIsEmpty) {
                                                    mutableScatterMap.removeValueAt(i7);
                                                }
                                                i = 8;
                                            } else {
                                                jArr2 = jArr4;
                                                j = j3;
                                                c2 = c3;
                                                j2 = j4;
                                                i = i4;
                                            }
                                            j3 = j >> i;
                                            i6++;
                                            i4 = i;
                                            c3 = c2;
                                            j4 = j2;
                                            jArr4 = jArr2;
                                        }
                                        jArr = jArr4;
                                        if (i5 != i4) {
                                            break;
                                        }
                                    } else {
                                        jArr = jArr4;
                                    }
                                    if (i3 == length) {
                                        break;
                                    }
                                    i3++;
                                    jArr4 = jArr;
                                    i2 = 0;
                                }
                            }
                            cleanUpDerivedStateObservations();
                            Unit unit2 = Unit.INSTANCE;
                            Trace.INSTANCE.endSection(objBeginSection);
                        } finally {
                        }
                    }
                    try {
                        if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                            this.rememberManager.dispatchAbandons();
                        }
                    } finally {
                    }
                } finally {
                }
            } else {
                try {
                    if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                        this.rememberManager.dispatchAbandons();
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            try {
                if (this.lateChanges.isEmpty() && this.pendingPausedComposition == null) {
                    this.rememberManager.dispatchAbandons();
                }
                throw th;
            } finally {
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } catch (Throwable th2) {
                            rememberEventDispatcher.clear();
                            throw th2;
                        }
                    }
                    throw th;
                } catch (Throwable th3) {
                    abandonChanges();
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        RememberEventDispatcher rememberEventDispatcher;
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime();
                if (!this.abandonSet.isEmpty()) {
                    rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } finally {
                    }
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        rememberEventDispatcher = this.rememberManager;
                        try {
                            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                            rememberEventDispatcher.dispatchAbandons();
                            rememberEventDispatcher.clear();
                        } finally {
                        }
                    }
                    throw th;
                } catch (Throwable th2) {
                    abandonChanges();
                    throw th2;
                }
            }
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super ScopeMap<RecomposeScopeImpl, Object>, ? extends T> block) {
        MutableScatterMap<Object, Object> mutableScatterMapM5009takeInvalidationsafanTW4 = m5009takeInvalidationsafanTW4();
        try {
            return block.invoke(ScopeMap.m5106boximpl(mutableScatterMapM5009takeInvalidationsafanTW4));
        } catch (Throwable th) {
            this.invalidations = mutableScatterMapM5009takeInvalidationsafanTW4;
            throw th;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (this.abandonSet.isEmpty()) {
            return;
        }
        RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
        try {
            rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
            rememberEventDispatcher.dispatchAbandons();
        } finally {
            rememberEventDispatcher.clear();
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        this.slotStorage.invalidateAll();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime();
                this.slotStorage.verifyWellFormed();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        if (to != null && !Intrinsics.areEqual(to, this) && groupIndex >= 0) {
            this.invalidationDelegate = (CompositionImpl) to;
            this.invalidationDelegateGroup = groupIndex;
            try {
                return block.invoke();
            } finally {
                this.invalidationDelegate = null;
                this.invalidationDelegateGroup = 0;
            }
        }
        return block.invoke();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public ShouldPauseCallback getAndSetShouldPauseCallback(ShouldPauseCallback shouldPause) {
        ShouldPauseCallback shouldPauseCallback = this.shouldPause;
        this.shouldPause = shouldPause;
        return shouldPauseCallback;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        CompositionObserver compositionObserverObserver;
        CompositionImpl compositionImpl;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (this.slotStorage.ownsRecomposeScope(scope)) {
            if (!scope.getCanRecompose()) {
                return InvalidationResult.IGNORED;
            }
            InvalidationResult invalidationResultInvalidateChecked = invalidateChecked(scope, anchor, instance);
            if (invalidationResultInvalidateChecked != InvalidationResult.IGNORED && (compositionObserverObserver = observer()) != null) {
                compositionObserverObserver.onScopeInvalidated(scope, instance);
            }
            return invalidationResultInvalidateChecked;
        }
        synchronized (this.lock) {
            compositionImpl = this.invalidationDelegate;
        }
        if (compositionImpl != null && compositionImpl.tryImminentInvalidation(scope, instance)) {
            return InvalidationResult.IMMINENT;
        }
        return InvalidationResult.IGNORED;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
        CompositionObserver compositionObserverObserver = observer();
        if (compositionObserverObserver != null) {
            compositionObserverObserver.onScopeDisposed(scope);
        }
    }

    @Override // androidx.compose.runtime.CompositionServices
    public <T> T getCompositionService(CompositionServiceKey<T> key) {
        if (Intrinsics.areEqual(key, CompositionKt.getObservableCompositionServiceKey())) {
            return (T) this;
        }
        return null;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime(scope, instance);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4 A[Catch: all -> 0x00c5, EDGE_INSN: B:63:0x00a4->B:47:0x00a4 BREAK  A[LOOP:0: B:29:0x005b->B:43:0x009c], EDGE_INSN: B:64:0x00a4->B:47:0x00a4 BREAK  A[LOOP:0: B:29:0x005b->B:43:0x009c], TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x0010, B:12:0x001f, B:14:0x0025, B:18:0x002b, B:19:0x0034, B:21:0x0038, B:22:0x0041, B:24:0x0049, B:26:0x004d, B:29:0x005b, B:31:0x006b, B:33:0x0077, B:35:0x0081, B:39:0x0090, B:43:0x009c, B:44:0x009f, B:47:0x00a4), top: B:61:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.runtime.InvalidationResult invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl r21, androidx.compose.runtime.Anchor r22, java.lang.Object r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r22
            r3 = r23
            java.lang.Object r4 = r1.lock
            monitor-enter(r4)
            androidx.compose.runtime.CompositionImpl r5 = r1.invalidationDelegate     // Catch: java.lang.Throwable -> Lc5
            r6 = 0
            if (r5 == 0) goto L1d
            androidx.compose.runtime.SlotStorage r7 = r1.slotStorage     // Catch: java.lang.Throwable -> Lc5
            int r8 = r1.invalidationDelegateGroup     // Catch: java.lang.Throwable -> Lc5
            boolean r7 = r7.groupContainsAnchor(r8, r2)     // Catch: java.lang.Throwable -> Lc5
            if (r7 == 0) goto L1b
            goto L1c
        L1b:
            r5 = r6
        L1c:
            r6 = r5
        L1d:
            if (r6 != 0) goto La9
            boolean r5 = r1.tryImminentInvalidation(r0, r3)     // Catch: java.lang.Throwable -> Lc5
            if (r5 == 0) goto L29
            androidx.compose.runtime.InvalidationResult r0 = androidx.compose.runtime.InvalidationResult.IMMINENT     // Catch: java.lang.Throwable -> Lc5
            monitor-exit(r4)
            return r0
        L29:
            if (r3 != 0) goto L34
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r5 = r1.invalidations     // Catch: java.lang.Throwable -> Lc5
            androidx.compose.runtime.ScopeInvalidated r7 = androidx.compose.runtime.ScopeInvalidated.INSTANCE     // Catch: java.lang.Throwable -> Lc5
            androidx.compose.runtime.collection.ScopeMap.m5126setimpl(r5, r0, r7)     // Catch: java.lang.Throwable -> Lc5
            goto La9
        L34:
            boolean r5 = r3 instanceof androidx.compose.runtime.DerivedState     // Catch: java.lang.Throwable -> Lc5
            if (r5 != 0) goto L41
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r5 = r1.invalidations     // Catch: java.lang.Throwable -> Lc5
            androidx.compose.runtime.ScopeInvalidated r7 = androidx.compose.runtime.ScopeInvalidated.INSTANCE     // Catch: java.lang.Throwable -> Lc5
            androidx.compose.runtime.collection.ScopeMap.m5126setimpl(r5, r0, r7)     // Catch: java.lang.Throwable -> Lc5
            goto La9
        L41:
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r5 = r1.invalidations     // Catch: java.lang.Throwable -> Lc5
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Throwable -> Lc5
            if (r5 == 0) goto La4
            boolean r7 = r5 instanceof androidx.collection.MutableScatterSet     // Catch: java.lang.Throwable -> Lc5
            if (r7 == 0) goto L9f
            androidx.collection.MutableScatterSet r5 = (androidx.collection.MutableScatterSet) r5     // Catch: java.lang.Throwable -> Lc5
            androidx.collection.ScatterSet r5 = (androidx.collection.ScatterSet) r5     // Catch: java.lang.Throwable -> Lc5
            java.lang.Object[] r7 = r5.elements     // Catch: java.lang.Throwable -> Lc5
            long[] r5 = r5.metadata     // Catch: java.lang.Throwable -> Lc5
            int r8 = r5.length     // Catch: java.lang.Throwable -> Lc5
            int r8 = r8 + (-2)
            if (r8 < 0) goto La4
            r10 = 0
        L5b:
            r11 = r5[r10]     // Catch: java.lang.Throwable -> Lc5
            long r13 = ~r11     // Catch: java.lang.Throwable -> Lc5
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L9a
            int r13 = r10 - r8
            int r13 = ~r13     // Catch: java.lang.Throwable -> Lc5
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L75:
            if (r15 >= r13) goto L97
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L8e
            int r16 = r10 << 3
            int r16 = r16 + r15
            r9 = r7[r16]     // Catch: java.lang.Throwable -> Lc5
            r16 = r14
            androidx.compose.runtime.ScopeInvalidated r14 = androidx.compose.runtime.ScopeInvalidated.INSTANCE     // Catch: java.lang.Throwable -> Lc5
            if (r9 != r14) goto L90
            goto La9
        L8e:
            r16 = r14
        L90:
            long r11 = r11 >> r16
            int r15 = r15 + 1
            r14 = r16
            goto L75
        L97:
            r9 = r14
            if (r13 != r9) goto La4
        L9a:
            if (r10 == r8) goto La4
            int r10 = r10 + 1
            goto L5b
        L9f:
            androidx.compose.runtime.ScopeInvalidated r7 = androidx.compose.runtime.ScopeInvalidated.INSTANCE     // Catch: java.lang.Throwable -> Lc5
            if (r5 != r7) goto La4
            goto La9
        La4:
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r5 = r1.invalidations     // Catch: java.lang.Throwable -> Lc5
            androidx.compose.runtime.collection.ScopeMap.m5102addimpl(r5, r0, r3)     // Catch: java.lang.Throwable -> Lc5
        La9:
            monitor-exit(r4)
            if (r6 == 0) goto Lb1
            androidx.compose.runtime.InvalidationResult r0 = r6.invalidateChecked(r0, r2, r3)
            return r0
        Lb1:
            androidx.compose.runtime.CompositionContext r0 = r1.parent
            r2 = r1
            androidx.compose.runtime.ControlledComposition r2 = (androidx.compose.runtime.ControlledComposition) r2
            r0.invalidate$runtime(r2)
            boolean r0 = r1.isComposing()
            if (r0 == 0) goto Lc2
            androidx.compose.runtime.InvalidationResult r0 = androidx.compose.runtime.InvalidationResult.DEFERRED
            return r0
        Lc2:
            androidx.compose.runtime.InvalidationResult r0 = androidx.compose.runtime.InvalidationResult.SCHEDULED
            return r0
        Lc5:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.Anchor, java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    public final void removeObservation$runtime(Object instance, RecomposeScopeImpl scope) {
        ScopeMap.m5122removeimpl(this.observations, instance, scope);
    }

    public final void removeDerivedStateObservation$runtime(DerivedState<?> state) {
        if (ScopeMap.m5110containsimpl(this.observations, state)) {
            return;
        }
        ScopeMap.m5124removeScopeimpl(this.derivedStates, state);
    }

    /* JADX INFO: renamed from: takeInvalidations-afanTW4, reason: not valid java name */
    private final MutableScatterMap<Object, Object> m5009takeInvalidationsafanTW4() {
        MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
        this.invalidations = ScopeMap.m5109constructorimpl$default(null, 1, null);
        return mutableScatterMap;
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> block) {
        try {
            return block.invoke();
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                try {
                    rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                    rememberEventDispatcher.dispatchAbandons();
                } finally {
                    rememberEventDispatcher.clear();
                }
            }
            throw th;
        }
    }

    private final CompositionObserver observer() {
        return this.observerHolder.current();
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        synchronized (this.lock) {
            if (!(this.pendingPausedComposition == null)) {
                PreconditionsKt.throwIllegalStateException("Deactivate is not supported while pausable composition is in progress");
            }
            boolean zIsEmpty = this.slotStorage.isEmpty();
            if (!zIsEmpty || !this.abandonSet.isEmpty()) {
                Object objBeginSection = Trace.INSTANCE.beginSection("Compose:deactivate");
                try {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        if (!zIsEmpty) {
                            this.applier.onBeginChanges();
                            this.slotStorage.deactivateAll(this.rememberManager);
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        }
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        rememberEventDispatcher.clear();
                        throw th;
                    }
                } finally {
                    Trace.INSTANCE.endSection(objBeginSection);
                }
            }
            ScopeMap.m5107clearimpl(this.observations);
            ScopeMap.m5107clearimpl(this.derivedStates);
            ScopeMap.m5107clearimpl(this.invalidations);
            this.changes.clear();
            this.lateChanges.clear();
            this.composer.deactivate$runtime();
            this.state = 1;
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public final int composerStacksSizes$runtime() {
        return this.composer.stacksSize$runtime();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean observesAnyOf(java.util.Set<? extends java.lang.Object> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5c
            androidx.compose.runtime.collection.ScatterSetWrapper r15 = (androidx.compose.runtime.collection.ScatterSetWrapper) r15
            androidx.collection.ScatterSet r15 = r15.getSet$runtime()
            java.lang.Object[] r0 = r15.elements
            long[] r15 = r15.metadata
            int r3 = r15.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L7d
            r4 = r1
        L16:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r1
        L30:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r11 = r14.observations
            boolean r11 = androidx.compose.runtime.collection.ScopeMap.m5110containsimpl(r11, r10)
            if (r11 != 0) goto L50
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r11 = r14.derivedStates
            boolean r10 = androidx.compose.runtime.collection.ScopeMap.m5110containsimpl(r11, r10)
            if (r10 == 0) goto L51
        L50:
            return r2
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L30
        L55:
            if (r7 != r8) goto L7d
        L57:
            if (r4 == r3) goto L7d
            int r4 = r4 + 1
            goto L16
        L5c:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
        L62:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L7d
            java.lang.Object r0 = r15.next()
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r3 = r14.observations
            boolean r3 = androidx.compose.runtime.collection.ScopeMap.m5110containsimpl(r3, r0)
            if (r3 != 0) goto L7c
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r3 = r14.derivedStates
            boolean r0 = androidx.compose.runtime.collection.ScopeMap.m5110containsimpl(r3, r0)
            if (r0 == 0) goto L62
        L7c:
            return r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addPendingInvalidationsLocked(java.util.Set<? extends java.lang.Object> r34, boolean r35) {
        /*
            Method dump skipped, instruction units count: 1014
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.addPendingInvalidationsLocked(java.util.Set, boolean):void");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        int size = references.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!Intrinsics.areEqual(references.get(i).getFirst().getComposition(), this)) {
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th2) {
                        rememberEventDispatcher.clear();
                        throw th2;
                    }
                }
                throw th;
            } catch (Throwable th3) {
                abandonChanges();
                throw th3;
            }
        }
    }

    private final <T> T guardChanges(Function0<? extends T> block) {
        try {
            return block.invoke();
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    RememberEventDispatcher rememberEventDispatcher = this.rememberManager;
                    try {
                        rememberEventDispatcher.prepare(this.abandonSet, this.composer.getErrorContext$runtime());
                        rememberEventDispatcher.dispatchAbandons();
                        rememberEventDispatcher.clear();
                    } catch (Throwable th2) {
                        rememberEventDispatcher.clear();
                        throw th2;
                    }
                }
                throw th;
            } catch (Throwable th3) {
                abandonChanges();
                throw th3;
            }
        }
    }
}
