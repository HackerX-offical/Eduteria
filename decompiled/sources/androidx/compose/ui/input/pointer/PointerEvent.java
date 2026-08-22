package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import androidx.compose.ui.ComposeUiFlags;
import com.clevertap.android.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PointerEvent.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0017\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u000f\u0010#\u001a\u00020\u001eH\u0002¢\u0006\u0004\b$\u0010\u0015J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001e\u0010&\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u00020\u0017¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u001a\u001a\u00020\u001b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0015R&\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "<init>", "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "(Ljava/util/List;)V", "getChanges", "()Ljava/util/List;", "getInternalPointerEvent$ui", "()Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent", "()Landroid/view/MotionEvent;", "classification", "", "getClassification", "()I", Constants.KEY_BUTTONS, "Landroidx/compose/ui/input/pointer/PointerButtons;", "getButtons-ry648PA", "I", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "value", "Landroidx/compose/ui/input/pointer/PointerEventType;", "type", "getType-7fucELk", "setType-EhbLWgg$ui", "(I)V", "calculatePointerEventType", "calculatePointerEventType-7fucELk", "component1", Constants.COPY_TYPE, "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PointerEvent {
    public static final int $stable = 8;
    private final int buttons;
    private final List<PointerInputChange> changes;
    private final int classification;
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    public PointerEvent(List<PointerInputChange> list, InternalPointerEvent internalPointerEvent) {
        MotionEvent motionEvent;
        this.changes = list;
        this.internalPointerEvent = internalPointerEvent;
        this.classification = (Build.VERSION.SDK_INT < 29 || (motionEvent = getMotionEvent()) == null) ? 0 : motionEvent.getClassification();
        MotionEvent motionEvent2 = getMotionEvent();
        this.buttons = PointerButtons.m7236constructorimpl(motionEvent2 != null ? motionEvent2.getButtonState() : 0);
        MotionEvent motionEvent3 = getMotionEvent();
        this.keyboardModifiers = PointerKeyboardModifiers.m7376constructorimpl(motionEvent3 != null ? motionEvent3.getMetaState() : 0);
        this.type = m7242calculatePointerEventType7fucELk();
    }

    public final List<PointerInputChange> getChanges() {
        return this.changes;
    }

    /* JADX INFO: renamed from: getInternalPointerEvent$ui, reason: from getter */
    public final InternalPointerEvent getInternalPointerEvent() {
        return this.internalPointerEvent;
    }

    public final MotionEvent getMotionEvent() {
        InternalPointerEvent internalPointerEvent = this.internalPointerEvent;
        if (internalPointerEvent != null) {
            return internalPointerEvent.getMotionEvent();
        }
        return null;
    }

    public final int getClassification() {
        return this.classification;
    }

    public PointerEvent(List<PointerInputChange> list) {
        this(list, null);
    }

    /* JADX INFO: renamed from: getButtons-ry648PA, reason: not valid java name and from getter */
    public final int getButtons() {
        return this.buttons;
    }

    /* JADX INFO: renamed from: getKeyboardModifiers-k7X9c1A, reason: not valid java name and from getter */
    public final int getKeyboardModifiers() {
        return this.keyboardModifiers;
    }

    /* JADX INFO: renamed from: getType-7fucELk, reason: not valid java name and from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: setType-EhbLWgg$ui, reason: not valid java name */
    public final void m7246setTypeEhbLWgg$ui(int i) {
        this.type = i;
    }

    /* JADX INFO: renamed from: calculatePointerEventType-7fucELk, reason: not valid java name */
    private final int m7242calculatePointerEventType7fucELk() {
        MotionEvent motionEvent = getMotionEvent();
        int i = 0;
        if (motionEvent != null) {
            boolean z = Build.VERSION.SDK_INT >= 29 && motionEvent.getClassification() == 3;
            if (Build.VERSION.SDK_INT >= 29 && motionEvent.getClassification() == 5) {
                i = 1;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (z && ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                    return PointerEventType.INSTANCE.m7261getPanStart7fucELk();
                }
                if (i != 0 && ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                    return PointerEventType.INSTANCE.m7266getScaleStart7fucELk();
                }
                return PointerEventType.INSTANCE.m7262getPress7fucELk();
            }
            if (actionMasked == 1) {
                if (z && ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                    return PointerEventType.INSTANCE.m7259getPanEnd7fucELk();
                }
                if (i != 0 && ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                    return PointerEventType.INSTANCE.m7265getScaleEnd7fucELk();
                }
                return PointerEventType.INSTANCE.m7263getRelease7fucELk();
            }
            if (actionMasked != 2) {
                switch (actionMasked) {
                    case 5:
                        if (z && ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                            return PointerEventType.INSTANCE.m7261getPanStart7fucELk();
                        }
                        if (i != 0 && ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                            return PointerEventType.INSTANCE.m7264getScaleChange7fucELk();
                        }
                        return PointerEventType.INSTANCE.m7262getPress7fucELk();
                    case 6:
                        if (z && ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                            return PointerEventType.INSTANCE.m7259getPanEnd7fucELk();
                        }
                        if (i != 0 && ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                            return PointerEventType.INSTANCE.m7264getScaleChange7fucELk();
                        }
                        return PointerEventType.INSTANCE.m7263getRelease7fucELk();
                    case 7:
                        break;
                    case 8:
                        return PointerEventType.INSTANCE.m7267getScroll7fucELk();
                    case 9:
                        return PointerEventType.INSTANCE.m7256getEnter7fucELk();
                    case 10:
                        return PointerEventType.INSTANCE.m7257getExit7fucELk();
                    default:
                        return PointerEventType.INSTANCE.m7268getUnknown7fucELk();
                }
            }
            if (z && ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                return PointerEventType.INSTANCE.m7260getPanMove7fucELk();
            }
            if (i != 0 && ComposeUiFlags.isTrackpadGestureHandlingEnabled) {
                return PointerEventType.INSTANCE.m7264getScaleChange7fucELk();
            }
            return PointerEventType.INSTANCE.m7258getMove7fucELk();
        }
        List<PointerInputChange> list = this.changes;
        int size = list.size();
        while (i < size) {
            PointerInputChange pointerInputChange = list.get(i);
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.INSTANCE.m7263getRelease7fucELk();
            }
            if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.INSTANCE.m7262getPress7fucELk();
            }
            i++;
        }
        return PointerEventType.INSTANCE.m7258getMove7fucELk();
    }

    public final List<PointerInputChange> component1() {
        return this.changes;
    }

    public final PointerEvent copy(List<PointerInputChange> changes, MotionEvent motionEvent) {
        if (motionEvent == null) {
            return new PointerEvent(changes, null);
        }
        if (Intrinsics.areEqual(motionEvent, getMotionEvent())) {
            return new PointerEvent(changes, this.internalPointerEvent);
        }
        LongSparseArray longSparseArray = new LongSparseArray(changes.size());
        ArrayList arrayList = new ArrayList(changes.size());
        int size = changes.size();
        int i = 0;
        while (i < size) {
            PointerInputChange pointerInputChange = changes.get(i);
            longSparseArray.put(pointerInputChange.getId(), pointerInputChange);
            ArrayList arrayList2 = arrayList;
            long id = pointerInputChange.getId();
            long uptimeMillis = pointerInputChange.getUptimeMillis();
            long position = pointerInputChange.getPosition();
            long position2 = pointerInputChange.getPosition();
            boolean pressed = pointerInputChange.getPressed();
            float pressure = pointerInputChange.getPressure();
            int type = pointerInputChange.getType();
            InternalPointerEvent internalPointerEvent = this.internalPointerEvent;
            ArrayList arrayList3 = arrayList;
            int i2 = size;
            arrayList2.add(new PointerInputEventData(id, uptimeMillis, position, position2, pressed, pressure, type, internalPointerEvent != null && internalPointerEvent.m7217activeHoverEvent0FcD4WY(pointerInputChange.getId()), null, 0L, pointerInputChange.getScaleFactor(), pointerInputChange.getPanOffset(), 0L, 4864, null));
            i++;
            arrayList = arrayList3;
            size = i2;
        }
        return new PointerEvent(changes, new InternalPointerEvent(longSparseArray, new PointerInputEvent(motionEvent.getEventTime(), arrayList, motionEvent)));
    }
}
