package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import androidx.collection.SieveCacheKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.core.view.InputDeviceCompat;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MotionEventAdapter.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b#J#\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0000¢\u0006\u0002\b(J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u0014J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010-\u001a\u00020\u0017*\u00020 2\u0006\u0010*\u001a\u00020\u0014H\u0002J\u0017\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0014H\u0002¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J7\u00104\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010\u001a2\u0006\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0017H\u0002¢\u0006\u0002\b8R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "<init>", "()V", "nextId", "", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui$annotations", "getMotionEventToComposePointerIdMap$ui", "()Landroid/util/SparseLongArray;", "activeHoverIds", "Landroid/util/SparseBooleanArray;", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "previousIndirectPointerEventData", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData;", "previousToolType", "", "previousSource", "isInFakeFingerGesture", "", "isReinterpretingFakeFingerGesture", "inferredCursorRawOffset", "Landroidx/compose/ui/geometry/Offset;", "resetFakeFingerGesture", "", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "motionEvent", "Landroid/view/MotionEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui", "convertToIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/AndroidIndirectPointerEvent;", "primaryDirectionalMotionAxisOverride", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "convertToIndirectPointerEvent-k92h6UU$ui", "endStream", "pointerId", "addFreshIds", "removeStaleIds", "hasPointerId", "getComposePointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "motionEventPointerId", "getComposePointerId-_I2yYro", "(I)J", "clearOnDeviceChange", "createPointerInputEventData", "rawPositionOverride", FirebaseAnalytics.Param.INDEX, "pressed", "createPointerInputEventData-InuC1xA", "IndirectPointerEventData", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MotionEventAdapter {
    public static final int $stable = 8;
    private Offset inferredCursorRawOffset;
    private boolean isInFakeFingerGesture;
    private boolean isReinterpretingFakeFingerGesture;
    private long nextId;
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private final SparseBooleanArray activeHoverIds = new SparseBooleanArray();
    private final List<PointerInputEventData> pointers = new ArrayList();
    private final LongSparseArray<IndirectPointerEventData> previousIndirectPointerEventData = new LongSparseArray<>(0, 1, null);
    private int previousToolType = -1;
    private int previousSource = -1;

    public static /* synthetic */ void getMotionEventToComposePointerIdMap$ui$annotations() {
    }

    /* JADX INFO: renamed from: getMotionEventToComposePointerIdMap$ui, reason: from getter */
    public final SparseLongArray getMotionEventToComposePointerIdMap() {
        return this.motionEventToComposePointerIdMap;
    }

    /* JADX INFO: compiled from: MotionEventAdapter.android.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0083@\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001b\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005\u0088\u0001\u0002¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData;", "", "packedValue", "", "constructor-impl", "(J)J", "uptime", Const.POSITION, "Landroidx/compose/ui/geometry/Offset;", "down", "", "(JJZ)J", "getPackedValue", "()J", "getDown-impl", "(J)Z", "getUptime-impl", "getPosition-F1C5BW0", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    private static final class IndirectPointerEventData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long packedValue;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ IndirectPointerEventData m7223boximpl(long j) {
            return new IndirectPointerEventData(j);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m7224constructorimpl(long j) {
            return j;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m7226equalsimpl(long j, Object obj) {
            return (obj instanceof IndirectPointerEventData) && j == ((IndirectPointerEventData) obj).m7233unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m7227equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* JADX INFO: renamed from: getDown-impl, reason: not valid java name */
        public static final boolean m7228getDownimpl(long j) {
            return (j & 1) != 0;
        }

        /* JADX INFO: renamed from: getUptime-impl, reason: not valid java name */
        public static final long m7230getUptimeimpl(long j) {
            return (j >> 1) & SieveCacheKt.NodeLinkMask;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m7231hashCodeimpl(long j) {
            return Long.hashCode(j);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m7232toStringimpl(long j) {
            return "IndirectPointerEventData(packedValue=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m7226equalsimpl(this.packedValue, obj);
        }

        public int hashCode() {
            return m7231hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m7232toStringimpl(this.packedValue);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m7233unboximpl() {
            return this.packedValue;
        }

        private /* synthetic */ IndirectPointerEventData(long j) {
            this.packedValue = j;
        }

        public final long getPackedValue() {
            return this.packedValue;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static long m7225constructorimpl(long j, long j2, boolean z) {
            return m7224constructorimpl(((j & SieveCacheKt.NodeLinkMask) << 1) | (z ? 1L : 0L) | (((long) INSTANCE.packShorts((short) Float.intBitsToFloat((int) (j2 >> 32)), (short) Float.intBitsToFloat((int) (j2 & 4294967295L)))) << 32));
        }

        /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
        public static final long m7229getPositionF1C5BW0(long j) {
            int i = (int) (j >>> 32);
            Companion companion = INSTANCE;
            float fUnpackShort1 = companion.unpackShort1(i);
            return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(companion.unpackShort2(i))) & 4294967295L) | (Float.floatToRawIntBits(fUnpackShort1) << 32));
        }

        /* JADX INFO: compiled from: MotionEventAdapter.android.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData$Companion;", "", "<init>", "()V", "packShorts", "", "val1", "", "val2", "unpackShort1", "value", "unpackShort2", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int packShorts(short val1, short val2) {
                return (val1 << 16) | (val2 & UShort.MAX_VALUE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final short unpackShort1(int value) {
                return (short) (value >>> 16);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final short unpackShort2(int value) {
                return (short) (value & 65535);
            }

            private Companion() {
            }
        }
    }

    private final void resetFakeFingerGesture() {
        this.isInFakeFingerGesture = false;
        this.isReinterpretingFakeFingerGesture = false;
        this.inferredCursorRawOffset = null;
    }

    public final PointerInputEvent convertToPointerInputEvent$ui(MotionEvent motionEvent, PositionCalculator positionCalculator) {
        int actionIndex;
        MotionEventAdapter motionEventAdapter;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.motionEventToComposePointerIdMap.clear();
            this.activeHoverIds.clear();
            resetFakeFingerGesture();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        boolean z = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z2 = actionMasked == 8;
        if (z) {
            this.activeHoverIds.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        if (actionMasked != 1) {
            actionIndex = actionMasked != 6 ? -1 : motionEvent.getActionIndex();
        } else {
            actionIndex = 0;
        }
        this.pointers.clear();
        if (ComposeUiFlags.isTrackpadGestureHandlingEnabled && motionEvent.getActionMasked() == 0) {
            boolean z3 = Build.VERSION.SDK_INT >= 34 && (motionEvent.getClassification() == 3 || motionEvent.getClassification() == 5);
            boolean z4 = motionEvent.getButtonState() == 0 && (motionEvent.isFromSource(8194) || motionEvent.isFromSource(InputDeviceCompat.SOURCE_TOUCHPAD));
            if (z3 || z4) {
                this.isInFakeFingerGesture = true;
            }
        }
        if (ComposeUiFlags.isTrackpadGestureHandlingEnabled && Build.VERSION.SDK_INT >= 34 && motionEvent.getClassification() == 3) {
            this.isReinterpretingFakeFingerGesture = true;
            if (motionEvent.getActionMasked() == 0) {
                this.inferredCursorRawOffset = Offset.m5712boximpl(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(motionEvent.getRawY(0))) & 4294967295L) | (((long) Float.floatToRawIntBits(motionEvent.getRawX(0))) << 32)));
            }
            motionEvent2 = motionEvent;
            motionEventAdapter = this;
            this.pointers.add(m7220createPointerInputEventDataInuC1xA(positionCalculator, motionEvent2, this.inferredCursorRawOffset, 0, false));
        } else {
            motionEventAdapter = this;
            MotionEvent motionEvent3 = motionEvent;
            PositionCalculator positionCalculator2 = positionCalculator;
            motionEventAdapter.isReinterpretingFakeFingerGesture = false;
            int pointerCount = motionEvent3.getPointerCount();
            int i = 0;
            while (i < pointerCount) {
                motionEventAdapter.pointers.add(motionEventAdapter.m7220createPointerInputEventDataInuC1xA(positionCalculator2, motionEvent3, null, i, (z || i == actionIndex || (z2 && motionEvent3.getButtonState() == 0)) ? false : true));
                i++;
                motionEvent3 = motionEvent3;
                positionCalculator2 = positionCalculator2;
            }
            motionEvent2 = motionEvent3;
        }
        if (motionEvent2.getActionMasked() == 1) {
            resetFakeFingerGesture();
        }
        removeStaleIds(motionEvent2);
        return new PointerInputEvent(motionEvent2.getEventTime(), motionEventAdapter.pointers, motionEvent2);
    }

    /* JADX INFO: renamed from: convertToIndirectPointerEvent-k92h6UU$ui$default, reason: not valid java name */
    public static /* synthetic */ AndroidIndirectPointerEvent m7219convertToIndirectPointerEventk92h6UU$ui$default(MotionEventAdapter motionEventAdapter, MotionEvent motionEvent, IndirectPointerEventPrimaryDirectionalMotionAxis indirectPointerEventPrimaryDirectionalMotionAxis, int i, Object obj) {
        if ((i & 2) != 0) {
            indirectPointerEventPrimaryDirectionalMotionAxis = null;
        }
        return motionEventAdapter.m7222convertToIndirectPointerEventk92h6UU$ui(motionEvent, indirectPointerEventPrimaryDirectionalMotionAxis);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d2  */
    /* JADX INFO: renamed from: convertToIndirectPointerEvent-k92h6UU$ui, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent m7222convertToIndirectPointerEventk92h6UU$ui(android.view.MotionEvent r28, androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis r29) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.MotionEventAdapter.m7222convertToIndirectPointerEventk92h6UU$ui(android.view.MotionEvent, androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis):androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent");
    }

    public final void endStream(int pointerId) {
        this.activeHoverIds.delete(pointerId);
        this.motionEventToComposePointerIdMap.delete(pointerId);
    }

    private final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                long j = this.nextId;
                this.nextId = 1 + j;
                sparseLongArray.put(pointerId, j);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
            long j2 = this.nextId;
            this.nextId = 1 + j2;
            sparseLongArray2.put(pointerId2, j2);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.activeHoverIds.put(pointerId2, true);
            }
        }
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.activeHoverIds.get(pointerId, false)) {
                this.motionEventToComposePointerIdMap.delete(pointerId);
                this.activeHoverIds.delete(pointerId);
            }
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            for (int size = this.motionEventToComposePointerIdMap.size() - 1; -1 < size; size--) {
                int iKeyAt = this.motionEventToComposePointerIdMap.keyAt(size);
                if (!hasPointerId(motionEvent, iKeyAt)) {
                    this.motionEventToComposePointerIdMap.removeAt(size);
                    this.activeHoverIds.delete(iKeyAt);
                }
            }
        }
    }

    private final boolean hasPointerId(MotionEvent motionEvent, int i) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (motionEvent.getPointerId(i2) == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: getComposePointerId-_I2yYro, reason: not valid java name */
    private final long m7221getComposePointerId_I2yYro(int motionEventPointerId) {
        long jValueAt;
        int iIndexOfKey = this.motionEventToComposePointerIdMap.indexOfKey(motionEventPointerId);
        if (iIndexOfKey >= 0) {
            jValueAt = this.motionEventToComposePointerIdMap.valueAt(iIndexOfKey);
        } else {
            jValueAt = this.nextId;
            this.nextId = 1 + jValueAt;
            this.motionEventToComposePointerIdMap.put(motionEventPointerId, jValueAt);
        }
        return PointerId.m7289constructorimpl(jValueAt);
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.previousToolType && source == this.previousSource) {
            return;
        }
        this.previousToolType = toolType;
        this.previousSource = source;
        this.activeHoverIds.clear();
        this.motionEventToComposePointerIdMap.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b2 A[EDGE_INSN: B:89:0x01b2->B:64:0x01b2 BREAK  A[LOOP:0: B:45:0x0104->B:63:0x01ac], SYNTHETIC] */
    /* JADX INFO: renamed from: createPointerInputEventData-InuC1xA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.ui.input.pointer.PointerInputEventData m7220createPointerInputEventDataInuC1xA(androidx.compose.ui.input.pointer.PositionCalculator r44, android.view.MotionEvent r45, androidx.compose.ui.geometry.Offset r46, int r47, boolean r48) {
        /*
            Method dump skipped, instruction units count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.MotionEventAdapter.m7220createPointerInputEventDataInuC1xA(androidx.compose.ui.input.pointer.PositionCalculator, android.view.MotionEvent, androidx.compose.ui.geometry.Offset, int, boolean):androidx.compose.ui.input.pointer.PointerInputEventData");
    }
}
