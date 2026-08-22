package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.motion.widget.Key;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Transformable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a(\u0010\f\u001a\u00020\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u001a\u0016\u0010\u0019\u001a\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001b\u001a<\u0010\u001c\u001a\u00020\r*\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bH\u0082@¢\u0006\u0002\u0010\u001e\"\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "", StreamManagement.Enabled.ELEMENT, "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "SCROLL_FACTOR", "", "detectNonTouchGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePointerEventAsCtrlScrollOrNull", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointer", "Landroidx/compose/ui/input/pointer/PointerEvent;", "consumePointerEventAsPanOrNull", "consumePointerEventAsScaleOrNull", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerEvent;)Ljava/lang/Float;", "detectZoom", "panZoomLock", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TransformableKt {
    public static final float SCROLL_FACTOR = 545.0f;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transformable.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {461, 463, 521}, m = "detectZoom", n = {"$this$detectZoom", "channel", "canPan", "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "channel", "canPan", "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", "channel", "canPan", "event", "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "canceled"}, s = {"L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformableKt.detectZoom(null, false, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean transformable$lambda$0(Offset offset) {
        return true;
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        return transformable(modifier, transformableState, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TransformableKt.transformable$lambda$0((Offset) obj));
            }
        }, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function1 function1, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function1, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        return modifier.then(new TransformableElement(transformableState, function1, z, z2));
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2, reason: invalid class name */
    /* JADX INFO: compiled from: Transformable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectNonTouchGestures$2", f = "Transformable.kt", i = {0, 1, 2, 3}, l = {288, 315, 331, 349}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0", "L$0", "L$0"}, v = 1)
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<TransformEvent> $channel;
        final /* synthetic */ CoroutineContext $currentContext;
        final /* synthetic */ ScrollConfig $scrollConfig;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CoroutineContext coroutineContext, ScrollConfig scrollConfig, Channel<TransformEvent> channel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$currentContext = coroutineContext;
            this.$scrollConfig = scrollConfig;
            this.$channel = channel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(PointerInputChange pointerInputChange) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$1(PointerInputChange pointerInputChange) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$3(PointerInputChange pointerInputChange) {
            return true;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$currentContext, this.$scrollConfig, this.$channel, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x0164, code lost:
        
            if (r9 != r0) goto L55;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x007e A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0084 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0167, B:57:0x016f, B:52:0x0137, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d3, B:41:0x00dd, B:43:0x00e4, B:44:0x00f0, B:47:0x011a, B:49:0x0122, B:51:0x0129, B:60:0x017d, B:61:0x0188, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0167, B:57:0x016f, B:52:0x0137, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d3, B:41:0x00dd, B:43:0x00e4, B:44:0x00f0, B:47:0x011a, B:49:0x0122, B:51:0x0129, B:60:0x017d, B:61:0x0188, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0122 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:9:0x001c, B:55:0x0167, B:57:0x016f, B:52:0x0137, B:27:0x005d, B:30:0x006c, B:35:0x0084, B:36:0x008f, B:39:0x00d3, B:41:0x00dd, B:43:0x00e4, B:44:0x00f0, B:47:0x011a, B:49:0x0122, B:51:0x0129, B:60:0x017d, B:61:0x0188, B:14:0x002f, B:17:0x003a, B:20:0x0045), top: B:66:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0191  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0080 -> B:27:0x005d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00db -> B:59:0x0174). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00dd -> B:36:0x008f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0120 -> B:59:0x0174). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0122 -> B:44:0x00f0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0164 -> B:55:0x0167). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 404
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset consumePointerEventAsCtrlScrollOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent, ScrollConfig scrollConfig) {
        long jM5739getZeroF1C5BW0;
        PointerInputChange pointerInputChange;
        if (!PointerEvent_androidKt.m7276isCtrlPressed5xRPYO0(pointerEvent.getKeyboardModifiers()) || (!PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7267getScroll7fucELk()) && !PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7261getPanStart7fucELk()) && !PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7260getPanMove7fucELk()) && !PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7259getPanEnd7fucELk()))) {
            return null;
        }
        long jMo517calculateMouseWheelScroll8xgXZGE = scrollConfig.mo517calculateMouseWheelScroll8xgXZGE(awaitPointerEventScope, pointerEvent, awaitPointerEventScope.mo7197getSizeYbymL2g());
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled || (pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull((List) pointerEvent.getChanges())) == null) {
            jM5739getZeroF1C5BW0 = Offset.INSTANCE.m5739getZeroF1C5BW0();
        } else {
            long jM5715constructorimpl = Offset.m5715constructorimpl(pointerInputChange.getPanOffset() ^ (-9223372034707292160L));
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            Offset offsetM5712boximpl = Offset.m5712boximpl(Offset.INSTANCE.m5739getZeroF1C5BW0());
            int size = historical.size();
            for (int i = 0; i < size; i++) {
                offsetM5712boximpl = Offset.m5712boximpl(Offset.m5727minusMKHz9U(offsetM5712boximpl.m5733unboximpl(), historical.get(i).getPanOffset()));
            }
            jM5739getZeroF1C5BW0 = Offset.m5728plusMKHz9U(jM5715constructorimpl, offsetM5712boximpl.m5733unboximpl());
        }
        long jM5728plusMKHz9U = Offset.m5728plusMKHz9U(jMo517calculateMouseWheelScroll8xgXZGE, jM5739getZeroF1C5BW0);
        if (Offset.m5720equalsimpl0(jM5728plusMKHz9U, Offset.INSTANCE.m5739getZeroF1C5BW0())) {
            return null;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size2 = changes.size();
        for (int i2 = 0; i2 < size2; i2++) {
            changes.get(i2).consume();
        }
        return Offset.m5712boximpl(jM5728plusMKHz9U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset consumePointerEventAsPanOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent) {
        long jM5739getZeroF1C5BW0;
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled || (!PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7261getPanStart7fucELk()) && !PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7260getPanMove7fucELk()) && !PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7259getPanEnd7fucELk()))) {
            return null;
        }
        PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull((List) pointerEvent.getChanges());
        if (pointerInputChange == null) {
            jM5739getZeroF1C5BW0 = Offset.INSTANCE.m5739getZeroF1C5BW0();
        } else {
            long jM5715constructorimpl = Offset.m5715constructorimpl(pointerInputChange.getPanOffset() ^ (-9223372034707292160L));
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            Offset offsetM5712boximpl = Offset.m5712boximpl(Offset.INSTANCE.m5739getZeroF1C5BW0());
            int size = historical.size();
            for (int i = 0; i < size; i++) {
                offsetM5712boximpl = Offset.m5712boximpl(Offset.m5727minusMKHz9U(offsetM5712boximpl.m5733unboximpl(), historical.get(i).getPanOffset()));
            }
            jM5739getZeroF1C5BW0 = Offset.m5728plusMKHz9U(jM5715constructorimpl, offsetM5712boximpl.m5733unboximpl());
        }
        if (Offset.m5720equalsimpl0(jM5739getZeroF1C5BW0, Offset.INSTANCE.m5739getZeroF1C5BW0())) {
            return null;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size2 = changes.size();
        for (int i2 = 0; i2 < size2; i2++) {
            changes.get(i2).consume();
        }
        return Offset.m5712boximpl(jM5739getZeroF1C5BW0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float consumePointerEventAsScaleOrNull(AwaitPointerEventScope awaitPointerEventScope, PointerEvent pointerEvent) {
        if (!ComposeFoundationFlags.isTrackpadGestureHandlingEnabled || (!PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7266getScaleStart7fucELk()) && !PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7264getScaleChange7fucELk()) && !PointerEventType.m7252equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7265getScaleEnd7fucELk()))) {
            return null;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        float scaleFactor = 1.0f;
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            scaleFactor *= pointerInputChange.getScaleFactor();
            List<HistoricalChange> historical = pointerInputChange.getHistorical();
            int size2 = historical.size();
            for (int i2 = 0; i2 < size2; i2++) {
                scaleFactor *= historical.get(i2).getScaleFactor();
            }
        }
        if (scaleFactor == 1.0f) {
            return null;
        }
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size3 = changes2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            changes2.get(i3).consume();
        }
        return Float.valueOf(scaleFactor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x032d, code lost:
    
        if (r6 != 0) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x032f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0153, code lost:
    
        if (androidx.compose.foundation.ComposeFoundationFlags.isTrackpadGestureHandlingEnabled == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0163, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventType.m7252equalsimpl0(r0.getType(), androidx.compose.ui.input.pointer.PointerEventType.INSTANCE.m7261getPanStart7fucELk()) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0173, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventType.m7252equalsimpl0(r0.getType(), androidx.compose.ui.input.pointer.PointerEventType.INSTANCE.m7260getPanMove7fucELk()) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0183, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventType.m7252equalsimpl0(r0.getType(), androidx.compose.ui.input.pointer.PointerEventType.INSTANCE.m7259getPanEnd7fucELk()) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0193, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventType.m7252equalsimpl0(r0.getType(), androidx.compose.ui.input.pointer.PointerEventType.INSTANCE.m7266getScaleStart7fucELk()) == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01a3, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventType.m7252equalsimpl0(r0.getType(), androidx.compose.ui.input.pointer.PointerEventType.INSTANCE.m7264getScaleChange7fucELk()) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01b3, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventType.m7252equalsimpl0(r0.getType(), androidx.compose.ui.input.pointer.PointerEventType.INSTANCE.m7265getScaleEnd7fucELk()) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01b7, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0334 A[EDGE_INSN: B:117:0x0334->B:106:0x0334 BREAK  A[LOOP:0: B:100:0x031f->B:105:0x0331], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0151 A[EDGE_INSN: B:121:0x0151->B:32:0x0151 BREAK  A[LOOP:2: B:27:0x013f->B:31:0x014e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0301  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x0301 -> B:99:0x030e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope r31, boolean r32, kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.TransformEvent> r33, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Offset, java.lang.Boolean> r34, kotlin.coroutines.Continuation<? super kotlin.Unit> r35) {
        /*
            Method dump skipped, instruction units count: 869
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.detectZoom(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, kotlinx.coroutines.channels.Channel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectNonTouchGestures(PointerInputScope pointerInputScope, Channel<TransformEvent> channel, ScrollConfig scrollConfig, Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new AnonymousClass2(continuation.get$context(), scrollConfig, channel, null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }
}
