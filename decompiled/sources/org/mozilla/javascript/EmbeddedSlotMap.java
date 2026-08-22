package org.mozilla.javascript;

import java.util.Iterator;
import org.mozilla.javascript.ScriptableObject;

/* JADX INFO: loaded from: classes10.dex */
public class EmbeddedSlotMap implements SlotMap {
    private static final int INITIAL_SLOT_SIZE = 4;
    private int count;
    private ScriptableObject.Slot firstAdded;
    private ScriptableObject.Slot lastAdded;
    private ScriptableObject.Slot[] slots;

    private static int getSlotIndex(int i, int i2) {
        return (i - 1) & i2;
    }

    private static final class Iter implements Iterator<ScriptableObject.Slot> {
        private ScriptableObject.Slot next;

        Iter(ScriptableObject.Slot slot) {
            this.next = slot;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public ScriptableObject.Slot next() {
            ScriptableObject.Slot slot = this.next;
            this.next = slot.orderedNext;
            return slot;
        }
    }

    @Override // org.mozilla.javascript.SlotMap
    public int size() {
        return this.count;
    }

    @Override // org.mozilla.javascript.SlotMap
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<ScriptableObject.Slot> iterator() {
        return new Iter(this.firstAdded);
    }

    @Override // org.mozilla.javascript.SlotMap
    public ScriptableObject.Slot query(Object obj, int i) {
        if (this.slots == null) {
            return null;
        }
        if (obj != null) {
            i = obj.hashCode();
        }
        for (ScriptableObject.Slot slot = this.slots[getSlotIndex(this.slots.length, i)]; slot != null; slot = slot.next) {
            Object obj2 = slot.name;
            if (i == slot.indexOrHash && (obj2 == obj || (obj != null && obj.equals(obj2)))) {
                return slot;
            }
        }
        return null;
    }

    @Override // org.mozilla.javascript.SlotMap
    public ScriptableObject.Slot get(Object obj, int i, ScriptableObject.SlotAccess slotAccess) {
        ScriptableObject.Slot slot = null;
        if (this.slots == null && slotAccess == ScriptableObject.SlotAccess.QUERY) {
            return null;
        }
        if (obj != null) {
            i = obj.hashCode();
        }
        ScriptableObject.Slot[] slotArr = this.slots;
        if (slotArr != null) {
            slot = this.slots[getSlotIndex(slotArr.length, i)];
            while (slot != null) {
                Object obj2 = slot.name;
                if (i == slot.indexOrHash && (obj2 == obj || (obj != null && obj.equals(obj2)))) {
                    break;
                }
                slot = slot.next;
            }
            int i2 = AnonymousClass1.$SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess[slotAccess.ordinal()];
            if (i2 == 1 || (i2 == 2 || i2 == 3 ? slot != null : !(i2 == 4 ? !(slot instanceof ScriptableObject.GetterSlot) : i2 != 5 || (slot instanceof ScriptableObject.GetterSlot)))) {
                return slot;
            }
        }
        return createSlot(obj, i, slotAccess, slot);
    }

    /* JADX INFO: renamed from: org.mozilla.javascript.EmbeddedSlotMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess;

        static {
            int[] iArr = new int[ScriptableObject.SlotAccess.values().length];
            $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess = iArr;
            try {
                iArr[ScriptableObject.SlotAccess.QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess[ScriptableObject.SlotAccess.MODIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess[ScriptableObject.SlotAccess.MODIFY_CONST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess[ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess[ScriptableObject.SlotAccess.CONVERT_ACCESSOR_TO_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private ScriptableObject.Slot createSlot(Object obj, int i, ScriptableObject.SlotAccess slotAccess, ScriptableObject.Slot slot) {
        ScriptableObject.Slot slot2;
        if (this.count == 0) {
            this.slots = new ScriptableObject.Slot[4];
        } else if (slot != null) {
            int slotIndex = getSlotIndex(this.slots.length, i);
            ScriptableObject.Slot slot3 = this.slots[slotIndex];
            ScriptableObject.Slot slot4 = slot3;
            while (slot3 != null && (slot3.indexOrHash != i || (slot3.name != obj && (obj == null || !obj.equals(slot3.name))))) {
                slot4 = slot3;
                slot3 = slot3.next;
            }
            if (slot3 != null) {
                if (slotAccess == ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER && !(slot3 instanceof ScriptableObject.GetterSlot)) {
                    slot2 = new ScriptableObject.GetterSlot(obj, i, slot3.getAttributes());
                } else if (slotAccess == ScriptableObject.SlotAccess.CONVERT_ACCESSOR_TO_DATA && (slot3 instanceof ScriptableObject.GetterSlot)) {
                    slot2 = new ScriptableObject.Slot(obj, i, slot3.getAttributes());
                } else {
                    if (slotAccess == ScriptableObject.SlotAccess.MODIFY_CONST) {
                        return null;
                    }
                    return slot3;
                }
                slot2.value = slot3.value;
                slot2.next = slot3.next;
                ScriptableObject.Slot slot5 = this.firstAdded;
                if (slot3 == slot5) {
                    this.firstAdded = slot2;
                } else {
                    while (slot5 != null && slot5.orderedNext != slot3) {
                        slot5 = slot5.orderedNext;
                    }
                    if (slot5 != null) {
                        slot5.orderedNext = slot2;
                    }
                }
                slot2.orderedNext = slot3.orderedNext;
                if (slot3 == this.lastAdded) {
                    this.lastAdded = slot2;
                }
                if (slot4 == slot3) {
                    this.slots[slotIndex] = slot2;
                    return slot2;
                }
                slot4.next = slot2;
                return slot2;
            }
        }
        int i2 = (this.count + 1) * 4;
        ScriptableObject.Slot[] slotArr = this.slots;
        if (i2 > slotArr.length * 3) {
            ScriptableObject.Slot[] slotArr2 = new ScriptableObject.Slot[slotArr.length * 2];
            copyTable(slotArr, slotArr2);
            this.slots = slotArr2;
        }
        ScriptableObject.Slot getterSlot = slotAccess == ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER ? new ScriptableObject.GetterSlot(obj, i, 0) : new ScriptableObject.Slot(obj, i, 0);
        if (slotAccess == ScriptableObject.SlotAccess.MODIFY_CONST) {
            getterSlot.setAttributes(13);
        }
        insertNewSlot(getterSlot);
        return getterSlot;
    }

    @Override // org.mozilla.javascript.SlotMap
    public void addSlot(ScriptableObject.Slot slot) {
        if (this.slots == null) {
            this.slots = new ScriptableObject.Slot[4];
        }
        insertNewSlot(slot);
    }

    private void insertNewSlot(ScriptableObject.Slot slot) {
        this.count++;
        ScriptableObject.Slot slot2 = this.lastAdded;
        if (slot2 != null) {
            slot2.orderedNext = slot;
        }
        if (this.firstAdded == null) {
            this.firstAdded = slot;
        }
        this.lastAdded = slot;
        addKnownAbsentSlot(this.slots, slot);
    }

    @Override // org.mozilla.javascript.SlotMap
    public void remove(Object obj, int i) {
        if (obj != null) {
            i = obj.hashCode();
        }
        if (this.count != 0) {
            int slotIndex = getSlotIndex(this.slots.length, i);
            ScriptableObject.Slot slot = this.slots[slotIndex];
            ScriptableObject.Slot slot2 = slot;
            while (slot != null && (slot.indexOrHash != i || (slot.name != obj && (obj == null || !obj.equals(slot.name))))) {
                slot2 = slot;
                slot = slot.next;
            }
            if (slot != null) {
                if ((slot.getAttributes() & 4) != 0) {
                    if (Context.getContext().isStrictMode()) {
                        throw ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", obj);
                    }
                    return;
                }
                this.count--;
                if (slot2 == slot) {
                    this.slots[slotIndex] = slot.next;
                } else {
                    slot2.next = slot.next;
                }
                ScriptableObject.Slot slot3 = this.firstAdded;
                if (slot == slot3) {
                    this.firstAdded = slot.orderedNext;
                    slot3 = null;
                } else {
                    while (slot3.orderedNext != slot) {
                        slot3 = slot3.orderedNext;
                    }
                    slot3.orderedNext = slot.orderedNext;
                }
                if (slot == this.lastAdded) {
                    this.lastAdded = slot3;
                }
            }
        }
    }

    private void copyTable(ScriptableObject.Slot[] slotArr, ScriptableObject.Slot[] slotArr2) {
        for (ScriptableObject.Slot slot : slotArr) {
            while (slot != null) {
                ScriptableObject.Slot slot2 = slot.next;
                slot.next = null;
                addKnownAbsentSlot(slotArr2, slot);
                slot = slot2;
            }
        }
    }

    private void addKnownAbsentSlot(ScriptableObject.Slot[] slotArr, ScriptableObject.Slot slot) {
        int slotIndex = getSlotIndex(slotArr.length, slot.indexOrHash);
        ScriptableObject.Slot slot2 = slotArr[slotIndex];
        slotArr[slotIndex] = slot;
        slot.next = slot2;
    }
}
