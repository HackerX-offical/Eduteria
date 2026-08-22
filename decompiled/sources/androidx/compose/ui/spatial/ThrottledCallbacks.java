package androidx.compose.ui.spatial;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.iot.discovery.element.IoTUnregister;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: ThrottledCallbacks.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001f\b\u0001\u0018\u00002\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000fH\u0002J:\u00102\u001a\u0002032\u0006\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:J:\u0010=\u001a\u0002032\u0006\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:J&\u0010>\u001a\u00020<2\u0006\u00104\u001a\u00020,2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000fJ!\u0010B\u001a\u00020<2\u0016\u00109\u001a\u0012\u0012\b\u0012\u00060\u0006R\u00020\u0000\u0012\u0004\u0012\u00020<0:H\u0086\bJ\u000e\u0010C\u001a\u00020<2\u0006\u0010A\u001a\u00020\u000fJ\u000e\u0010D\u001a\u00020<2\u0006\u0010A\u001a\u00020\u000fJ\u000e\u0010E\u001a\u00020<2\u0006\u0010A\u001a\u00020\u000fJ1\u0010F\u001a\u00020<2\n\u0010G\u001a\u00060\u0006R\u00020\u00002\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000fH\u0000¢\u0006\u0002\bHJ=\u0010I\u001a\u00020<2\n\u0010G\u001a\u00060\u0006R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010A\u001a\u00020\u000fH\u0002¢\u0006\u0004\bJ\u0010KJE\u0010L\u001a\u00020\u000f2\n\u0010G\u001a\u00060\u0006R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000fH\u0002¢\u0006\u0004\bN\u0010OJ\u0014\u0010P\u001a\u00020<2\n\u0010G\u001a\u00060\u0006R\u00020\u0000H\u0002J\u0014\u0010Q\u001a\u00020'2\n\u0010G\u001a\u00060\u0006R\u00020\u0000H\u0002J)\u0010R\u001a\u00020<*\u00060\u0006R\u00020\u00002\u0016\u0010S\u001a\u0012\u0012\b\u0012\u00060\u0006R\u00020\u0000\u0012\u0004\u0012\u00020<0:H\u0082\bJ/\u0010T\u001a\u00020<*\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u00052\u0016\u0010S\u001a\u0012\u0012\b\u0012\u00060\u0006R\u00020\u0000\u0012\u0004\u0012\u00020<0:H\u0082\bJ7\u0010U\u001a\u00020<*\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u00052\u0006\u00104\u001a\u00020,2\u0016\u0010S\u001a\u0012\u0012\b\u0012\u00060\u0006R\u00020\u0000\u0012\u0004\u0012\u00020<0:H\u0082\bJ.\u0010V\u001a\u00060\u0006R\u00020\u0000*\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u00052\u0006\u0010W\u001a\u00020,2\n\u0010X\u001a\u00060\u0006R\u00020\u0000H\u0002J*\u0010Y\u001a\u00020'*\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u00052\u0006\u0010W\u001a\u00020,2\n\u0010X\u001a\u00060\u0006R\u00020\u0000H\u0002R\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0018\u00010\u0006R\u00020\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0019\u001a\u00020\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u001c\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001e\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006["}, d2 = {"Landroidx/compose/ui/spatial/ThrottledCallbacks;", "", "<init>", "()V", "rectChangedMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "getRectChangedMap", "()Landroidx/collection/MutableIntObjectMap;", "globalChangeEntries", "getGlobalChangeEntries", "()Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "setGlobalChangeEntries", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;)V", "minDebounceDeadline", "", "getMinDebounceDeadline", "()J", "setMinDebounceDeadline", "(J)V", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "getWindowOffset-nOcc-ac", "setWindowOffset--gyyYBs", "J", "screenOffset", "getScreenOffset-nOcc-ac", "setScreenOffset--gyyYBs", "windowSize", "getWindowSize", "setWindowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "getViewToWindowMatrix-3i98HWw", "()[F", "setViewToWindowMatrix-Q8lPUPs", "([F)V", "[F", "updateOffsets", "", "screen", "window", "matrix", "windowWidth", "", "windowHeight", "updateOffsets-LDcG7Xg", "(JJ[FII)Z", "roundDownToMultipleOf8", "x", "registerOnRectChanged", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "throttleMillis", "debounceMillis", NodeElement.ELEMENT, "Landroidx/compose/ui/node/DelegatableNode;", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "registerOnGlobalChange", "fireOnUpdatedRect", "topLeft", "bottomRight", "currentMillis", "forEachNewCallbackNeverInvoked", "fireOnRectChangedEntries", "fireGlobalChangeEntries", "triggerDebounced", "fireWithUpdatedRect", "entry", "fireWithUpdatedRect$ui", "fire", "fire-WY9HvpM", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;JJ[FJ)V", "debounceEntry", "minDeadline", "debounceEntry-b8qMvQI", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;JJ[FJJ)J", "addToGlobalEntries", "removeFromGlobalEntries", "linkedForEach", BlockContactsIQ.ELEMENT, "multiForEach", "runFor", "multiPut", "key", "value", "multiRemove", "Entry", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThrottledCallbacks {
    public static final int $stable = 8;
    private Entry globalChangeEntries;
    private float[] viewToWindowMatrix;
    private long windowSize;
    private final MutableIntObjectMap<Entry> rectChangedMap = IntObjectMapKt.mutableIntObjectMapOf();
    private long minDebounceDeadline = -1;
    private long windowOffset = IntOffset.INSTANCE.m8969getZeronOccac();
    private long screenOffset = IntOffset.INSTANCE.m8969getZeronOccac();

    private final long roundDownToMultipleOf8(long x) {
        return (x >> 3) << 3;
    }

    /* JADX INFO: compiled from: ThrottledCallbacks.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010+\u001a\u00020\fH\u0016J7\u0010,\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u000101¢\u0006\u0004\b2\u00103R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0018\u00010\u0000R\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010!R\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010!¨\u00064"}, d2 = {"Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "", "throttleMillis", "", "debounceMillis", NodeElement.ELEMENT, "Landroidx/compose/ui/node/DelegatableNode;", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "", "<init>", "(Landroidx/compose/ui/spatial/ThrottledCallbacks;IJJLandroidx/compose/ui/node/DelegatableNode;Lkotlin/jvm/functions/Function1;)V", "getId", "()I", "getThrottleMillis", "()J", "getDebounceMillis", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "getCallback", "()Lkotlin/jvm/functions/Function1;", ES6Iterator.NEXT_METHOD, "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "getNext", "()Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;", "setNext", "(Landroidx/compose/ui/spatial/ThrottledCallbacks$Entry;)V", "topLeft", "getTopLeft", "setTopLeft", "(J)V", "bottomRight", "getBottomRight", "setBottomRight", "lastInvokeMillis", "getLastInvokeMillis", "setLastInvokeMillis", "lastUninvokedFireMillis", "getLastUninvokedFireMillis", "setLastUninvokedFireMillis", IoTUnregister.ELEMENT, "fire", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "fire-9b-9wPM", "(JJJJ[F)V", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Entry implements DelegatableNode.RegistrationHandle {
        private long bottomRight;
        private final Function1<RelativeLayoutBounds, Unit> callback;
        private final long debounceMillis;
        private final int id;
        private long lastInvokeMillis = Long.MIN_VALUE;
        private long lastUninvokedFireMillis = -1;
        private Entry next;
        private final DelegatableNode node;
        private final long throttleMillis;
        private long topLeft;

        /* JADX WARN: Multi-variable type inference failed */
        public Entry(int i, long j, long j2, DelegatableNode delegatableNode, Function1<? super RelativeLayoutBounds, Unit> function1) {
            this.id = i;
            this.throttleMillis = j;
            this.debounceMillis = j2;
            this.node = delegatableNode;
            this.callback = function1;
        }

        public final int getId() {
            return this.id;
        }

        public final long getThrottleMillis() {
            return this.throttleMillis;
        }

        public final long getDebounceMillis() {
            return this.debounceMillis;
        }

        public final DelegatableNode getNode() {
            return this.node;
        }

        public final Function1<RelativeLayoutBounds, Unit> getCallback() {
            return this.callback;
        }

        public final Entry getNext() {
            return this.next;
        }

        public final void setNext(Entry entry) {
            this.next = entry;
        }

        public final long getTopLeft() {
            return this.topLeft;
        }

        public final void setTopLeft(long j) {
            this.topLeft = j;
        }

        public final long getBottomRight() {
            return this.bottomRight;
        }

        public final void setBottomRight(long j) {
            this.bottomRight = j;
        }

        public final long getLastInvokeMillis() {
            return this.lastInvokeMillis;
        }

        public final void setLastInvokeMillis(long j) {
            this.lastInvokeMillis = j;
        }

        public final long getLastUninvokedFireMillis() {
            return this.lastUninvokedFireMillis;
        }

        public final void setLastUninvokedFireMillis(long j) {
            this.lastUninvokedFireMillis = j;
        }

        @Override // androidx.compose.ui.node.DelegatableNode.RegistrationHandle
        public void unregister() {
            ThrottledCallbacks throttledCallbacks = ThrottledCallbacks.this;
            if (throttledCallbacks.multiRemove(throttledCallbacks.getRectChangedMap(), this.id, this)) {
                return;
            }
            ThrottledCallbacks.this.removeFromGlobalEntries(this);
        }

        /* JADX INFO: renamed from: fire-9b-9wPM, reason: not valid java name */
        public final void m8055fire9b9wPM(long topLeft, long bottomRight, long windowOffset, long screenOffset, float[] viewToWindowMatrix) {
            RelativeLayoutBounds relativeLayoutBoundsM8056rectInfoForDg36KO4 = ThrottledCallbacksKt.m8056rectInfoForDg36KO4(this.node, topLeft, bottomRight, windowOffset, screenOffset, ThrottledCallbacks.this.getWindowSize(), viewToWindowMatrix);
            if (relativeLayoutBoundsM8056rectInfoForDg36KO4 == null) {
                return;
            }
            this.callback.invoke(relativeLayoutBoundsM8056rectInfoForDg36KO4);
        }
    }

    public final MutableIntObjectMap<Entry> getRectChangedMap() {
        return this.rectChangedMap;
    }

    public final Entry getGlobalChangeEntries() {
        return this.globalChangeEntries;
    }

    public final void setGlobalChangeEntries(Entry entry) {
        this.globalChangeEntries = entry;
    }

    public final long getMinDebounceDeadline() {
        return this.minDebounceDeadline;
    }

    public final void setMinDebounceDeadline(long j) {
        this.minDebounceDeadline = j;
    }

    /* JADX INFO: renamed from: getWindowOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getWindowOffset() {
        return this.windowOffset;
    }

    /* JADX INFO: renamed from: setWindowOffset--gyyYBs, reason: not valid java name */
    public final void m8053setWindowOffsetgyyYBs(long j) {
        this.windowOffset = j;
    }

    /* JADX INFO: renamed from: getScreenOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getScreenOffset() {
        return this.screenOffset;
    }

    /* JADX INFO: renamed from: setScreenOffset--gyyYBs, reason: not valid java name */
    public final void m8051setScreenOffsetgyyYBs(long j) {
        this.screenOffset = j;
    }

    public final long getWindowSize() {
        return this.windowSize;
    }

    public final void setWindowSize(long j) {
        this.windowSize = j;
    }

    /* JADX INFO: renamed from: getViewToWindowMatrix-3i98HWw, reason: not valid java name and from getter */
    public final float[] getViewToWindowMatrix() {
        return this.viewToWindowMatrix;
    }

    /* JADX INFO: renamed from: setViewToWindowMatrix-Q8lPUPs, reason: not valid java name */
    public final void m8052setViewToWindowMatrixQ8lPUPs(float[] fArr) {
        this.viewToWindowMatrix = fArr;
    }

    /* JADX INFO: renamed from: updateOffsets-LDcG7Xg, reason: not valid java name */
    public final boolean m8054updateOffsetsLDcG7Xg(long screen, long window, float[] matrix, int windowWidth, int windowHeight) {
        boolean z;
        if (IntOffset.m8957equalsimpl0(window, this.windowOffset)) {
            z = false;
        } else {
            this.windowOffset = window;
            z = true;
        }
        if (!IntOffset.m8957equalsimpl0(screen, this.screenOffset)) {
            this.screenOffset = screen;
            z = true;
        }
        if (matrix != null) {
            this.viewToWindowMatrix = matrix;
            z = true;
        }
        long j = (((long) windowWidth) << 32) | (((long) windowHeight) & 4294967295L);
        if (j == this.windowSize) {
            return z;
        }
        this.windowSize = j;
        return true;
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChanged(int id, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        return multiPut(this.rectChangedMap, id, new Entry(id, throttleMillis, debounceMillis == 0 ? throttleMillis : debounceMillis, node, callback));
    }

    public final DelegatableNode.RegistrationHandle registerOnGlobalChange(int id, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        Entry entry = new Entry(id, throttleMillis, debounceMillis == 0 ? throttleMillis : debounceMillis, node, callback);
        addToGlobalEntries(entry);
        return entry;
    }

    public final void fireOnUpdatedRect(int id, long topLeft, long bottomRight, long currentMillis) {
        Entry next = this.rectChangedMap.get(id);
        while (true) {
            Entry entry = next;
            if (entry == null) {
                return;
            }
            next = entry.getNext();
            fireWithUpdatedRect$ui(entry, topLeft, bottomRight, currentMillis);
        }
    }

    public final void forEachNewCallbackNeverInvoked(Function1<? super Entry, Unit> callback) {
        MutableIntObjectMap<Entry> rectChangedMap = getRectChangedMap();
        Object[] objArr = rectChangedMap.values;
        long[] jArr = rectChangedMap.metadata;
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
                        Entry entry = (Entry) objArr[(i << 3) + i3];
                        for (Entry next = entry; next != null; next = next.getNext()) {
                            if (entry.getLastInvokeMillis() == Long.MIN_VALUE) {
                                callback.invoke(entry);
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
    }

    public final void fireOnRectChangedEntries(long currentMillis) {
        ThrottledCallbacks throttledCallbacks = this;
        long j = throttledCallbacks.windowOffset;
        long j2 = throttledCallbacks.screenOffset;
        float[] fArr = throttledCallbacks.viewToWindowMatrix;
        MutableIntObjectMap<Entry> mutableIntObjectMap = throttledCallbacks.rectChangedMap;
        Object[] objArr = mutableIntObjectMap.values;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j3 = jArr[i];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                long j4 = j3;
                int i3 = 0;
                while (i3 < i2) {
                    if ((j4 & 255) < 128) {
                        Entry next = (Entry) objArr[(i << 3) + i3];
                        while (next != null) {
                            int i4 = i3;
                            Entry entry = next;
                            throttledCallbacks.m8047fireWY9HvpM(entry, j, j2, fArr, currentMillis);
                            next = entry.getNext();
                            throttledCallbacks = this;
                            i3 = i4;
                        }
                    }
                    j4 >>= 8;
                    i3++;
                    throttledCallbacks = this;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
            throttledCallbacks = this;
        }
    }

    public final void fireGlobalChangeEntries(long currentMillis) {
        long j = this.windowOffset;
        long j2 = this.screenOffset;
        float[] fArr = this.viewToWindowMatrix;
        Entry next = this.globalChangeEntries;
        if (next != null) {
            while (next != null) {
                LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(next.getNode());
                long jM8036getOffsetFromRectListForBjo55l4 = LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode).getRectManager().m8036getOffsetFromRectListForBjo55l4(layoutNodeRequireLayoutNode);
                next.setTopLeft(jM8036getOffsetFromRectListForBjo55l4);
                int iM8958getXimpl = IntOffset.m8958getXimpl(jM8036getOffsetFromRectListForBjo55l4) + layoutNodeRequireLayoutNode.getWidth();
                next.setBottomRight((((long) (IntOffset.m8959getYimpl(jM8036getOffsetFromRectListForBjo55l4) + layoutNodeRequireLayoutNode.getHeight())) & 4294967295L) | (((long) iM8958getXimpl) << 32));
                m8047fireWY9HvpM(next, j, j2, fArr, currentMillis);
                next = next.getNext();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008d A[LOOP:0: B:8:0x0025->B:24:0x008d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0097 A[EDGE_INSN: B:38:0x0097->B:26:0x0097 BREAK  A[LOOP:0: B:8:0x0025->B:24:0x008d], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void triggerDebounced(long r27) {
        /*
            r26 = this;
            r0 = r26
            long r1 = r0.minDebounceDeadline
            int r1 = (r1 > r27 ? 1 : (r1 == r27 ? 0 : -1))
            if (r1 <= 0) goto L9
            return
        L9:
            long r2 = r0.windowOffset
            long r4 = r0.screenOffset
            float[] r6 = r0.viewToWindowMatrix
            androidx.collection.MutableIntObjectMap<androidx.compose.ui.spatial.ThrottledCallbacks$Entry> r1 = r0.rectChangedMap
            androidx.collection.IntObjectMap r1 = (androidx.collection.IntObjectMap) r1
            java.lang.Object[] r11 = r1.values
            long[] r12 = r1.metadata
            int r1 = r12.length
            int r13 = r1 + (-2)
            if (r13 < 0) goto L90
            r16 = 0
            r1 = r16
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L25:
            r9 = r12[r1]
            r17 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r14 = ~r9
            r19 = 7
            long r14 = r14 << r19
            long r14 = r14 & r9
            r19 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r19
            int r14 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r14 == 0) goto L8b
            int r14 = r1 - r13
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r19 = r9
            r9 = r16
        L4a:
            if (r9 >= r14) goto L85
            r21 = 255(0xff, double:1.26E-321)
            long r21 = r19 & r21
            r23 = 128(0x80, double:6.3E-322)
            int r10 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r10 >= 0) goto L7a
            int r10 = r1 << 3
            int r10 = r10 + r9
            r10 = r11[r10]
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r10 = (androidx.compose.ui.spatial.ThrottledCallbacks.Entry) r10
        L5d:
            if (r10 == 0) goto L76
            r25 = r1
            r21 = r9
            r1 = r10
            r9 = r7
            r7 = r27
            long r9 = r0.m8046debounceEntryb8qMvQI(r1, r2, r4, r6, r7, r9)
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r1 = r1.getNext()
            r7 = r9
            r9 = r21
            r10 = r1
            r1 = r25
            goto L5d
        L76:
            r21 = r9
            r9 = r7
            goto L7c
        L7a:
            r21 = r9
        L7c:
            r25 = r1
            long r19 = r19 >> r15
            int r9 = r21 + 1
            r1 = r25
            goto L4a
        L85:
            r25 = r1
            if (r14 != r15) goto L97
            r1 = r25
        L8b:
            if (r1 == r13) goto L97
            int r1 = r1 + 1
            goto L25
        L90:
            r17 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r7 = r17
        L97:
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r1 = r0.globalChangeEntries
            if (r1 == 0) goto Laa
            r9 = r7
        L9c:
            if (r1 == 0) goto La9
            r7 = r27
            long r9 = r0.m8046debounceEntryb8qMvQI(r1, r2, r4, r6, r7, r9)
            androidx.compose.ui.spatial.ThrottledCallbacks$Entry r1 = r1.getNext()
            goto L9c
        La9:
            r7 = r9
        Laa:
            int r1 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r1 != 0) goto Lb0
            r7 = -1
        Lb0:
            r0.minDebounceDeadline = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.ThrottledCallbacks.triggerDebounced(long):void");
    }

    public final void fireWithUpdatedRect$ui(Entry entry, long topLeft, long bottomRight, long currentMillis) {
        long lastInvokeMillis = entry.getLastInvokeMillis();
        long throttleMillis = entry.getThrottleMillis();
        long debounceMillis = entry.getDebounceMillis();
        boolean z = currentMillis - lastInvokeMillis >= throttleMillis || lastInvokeMillis == Long.MIN_VALUE;
        boolean z2 = debounceMillis == 0;
        boolean z3 = throttleMillis == 0;
        entry.setTopLeft(topLeft);
        entry.setBottomRight(bottomRight);
        boolean z4 = !(z2 || z3) || z2;
        if (z && z4) {
            entry.setLastUninvokedFireMillis(-1L);
            entry.setLastInvokeMillis(currentMillis);
            entry.m8055fire9b9wPM(topLeft, bottomRight, this.windowOffset, this.screenOffset, this.viewToWindowMatrix);
        } else {
            if (z2) {
                return;
            }
            entry.setLastUninvokedFireMillis(currentMillis);
            long j = this.minDebounceDeadline;
            long j2 = currentMillis + debounceMillis;
            if (j <= 0 || j2 >= j) {
                return;
            }
            this.minDebounceDeadline = j;
        }
    }

    /* JADX INFO: renamed from: fire-WY9HvpM, reason: not valid java name */
    private final void m8047fireWY9HvpM(Entry entry, long windowOffset, long screenOffset, float[] viewToWindowMatrix, long currentMillis) {
        long lastInvokeMillis = entry.getLastInvokeMillis();
        boolean z = currentMillis - lastInvokeMillis > entry.getThrottleMillis() || lastInvokeMillis == Long.MIN_VALUE;
        boolean z2 = entry.getDebounceMillis() == 0;
        entry.setLastUninvokedFireMillis(currentMillis);
        if (z && z2) {
            entry.setLastInvokeMillis(currentMillis);
            entry.m8055fire9b9wPM(entry.getTopLeft(), entry.getBottomRight(), windowOffset, screenOffset, viewToWindowMatrix);
        }
        if (z2) {
            return;
        }
        long j = this.minDebounceDeadline;
        long debounceMillis = entry.getDebounceMillis() + currentMillis;
        if (j <= 0 || debounceMillis >= j) {
            return;
        }
        this.minDebounceDeadline = j;
    }

    /* JADX INFO: renamed from: debounceEntry-b8qMvQI, reason: not valid java name */
    private final long m8046debounceEntryb8qMvQI(Entry entry, long windowOffset, long screenOffset, float[] viewToWindowMatrix, long currentMillis, long minDeadline) {
        if (entry.getDebounceMillis() <= 0 || entry.getLastUninvokedFireMillis() <= 0) {
            return minDeadline;
        }
        if (currentMillis - entry.getLastUninvokedFireMillis() >= entry.getDebounceMillis()) {
            entry.setLastInvokeMillis(currentMillis);
            entry.setLastUninvokedFireMillis(-1L);
            entry.m8055fire9b9wPM(entry.getTopLeft(), entry.getBottomRight(), windowOffset, screenOffset, viewToWindowMatrix);
            return minDeadline;
        }
        return Math.min(minDeadline, entry.getLastUninvokedFireMillis() + entry.getDebounceMillis());
    }

    private final void addToGlobalEntries(Entry entry) {
        entry.setNext(this.globalChangeEntries);
        this.globalChangeEntries = entry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeFromGlobalEntries(Entry entry) {
        Entry entry2 = this.globalChangeEntries;
        if (entry2 == entry) {
            this.globalChangeEntries = entry2.getNext();
            entry.setNext(null);
            return true;
        }
        Entry next = entry2 != null ? entry2.getNext() : null;
        while (true) {
            Entry entry3 = next;
            Entry entry4 = entry2;
            entry2 = entry3;
            if (entry2 == null) {
                return false;
            }
            if (entry2 == entry) {
                if (entry4 != null) {
                    entry4.setNext(entry2.getNext());
                }
                entry.setNext(null);
                return true;
            }
            next = entry2.getNext();
        }
    }

    private final void linkedForEach(Entry entry, Function1<? super Entry, Unit> function1) {
        while (entry != null) {
            function1.invoke(entry);
            entry = entry.getNext();
        }
    }

    private final void multiForEach(MutableIntObjectMap<Entry> mutableIntObjectMap, Function1<? super Entry, Unit> function1) {
        MutableIntObjectMap<Entry> mutableIntObjectMap2 = mutableIntObjectMap;
        Object[] objArr = mutableIntObjectMap2.values;
        long[] jArr = mutableIntObjectMap2.metadata;
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
                        for (Entry next = (Entry) objArr[(i << 3) + i3]; next != null; next = next.getNext()) {
                            function1.invoke(next);
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
    }

    private final void runFor(MutableIntObjectMap<Entry> mutableIntObjectMap, int i, Function1<? super Entry, Unit> function1) {
        Entry entry = mutableIntObjectMap.get(i);
        while (entry != null) {
            Entry next = entry.getNext();
            function1.invoke(entry);
            entry = next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean multiRemove(MutableIntObjectMap<Entry> mutableIntObjectMap, int i, Entry entry) {
        Entry entryRemove = mutableIntObjectMap.remove(i);
        if (entryRemove == null) {
            return false;
        }
        if (Intrinsics.areEqual(entryRemove, entry)) {
            Entry next = entry.getNext();
            entry.setNext(null);
            if (next != null) {
                mutableIntObjectMap.put(i, next);
            } else {
                LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(entry.getNode().getNode());
                if (layoutNodeRequireLayoutNode.getAddedToRectList()) {
                    LayoutNodeKt.requireOwner(layoutNodeRequireLayoutNode).getRectManager().unsetHasCallbacksFor(layoutNodeRequireLayoutNode);
                }
            }
            return true;
        }
        mutableIntObjectMap.put(i, entryRemove);
        while (true) {
            if (entryRemove == null) {
                break;
            }
            Entry next2 = entryRemove.getNext();
            if (next2 == null) {
                return false;
            }
            if (next2 == entry) {
                entryRemove.setNext(entry.getNext());
                entry.setNext(null);
                break;
            }
            entryRemove = entryRemove.getNext();
        }
        return true;
    }

    private final Entry multiPut(MutableIntObjectMap<Entry> mutableIntObjectMap, int i, Entry entry) {
        Entry entry2 = mutableIntObjectMap.get(i);
        if (entry2 == null) {
            mutableIntObjectMap.set(i, entry);
            entry2 = entry;
        }
        Entry next = entry2;
        if (next != entry) {
            while (next.getNext() != null) {
                next = next.getNext();
                Intrinsics.checkNotNull(next);
            }
            next.setNext(entry);
        }
        return entry;
    }
}
