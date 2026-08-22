package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.InvalidationResult;
import androidx.compose.runtime.MovableContent;
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RecomposeScopeOwner;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.ReusableRememberObserverHolder;
import androidx.compose.runtime.ScopeInvalidated;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.runtime.tooling.ObjectLocation;
import com.clevertap.android.sdk.Constants;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\b\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b*\u00020\u00062\n\u0010\f\u001a\u00060\u0003j\u0002`\rH\u0000\u001a\u0014\u0010\u000e\u001a\u00020\t*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\t*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u00032\n\u0010\u0014\u001a\u00060\u0003j\u0002`\r2\u0006\u0010\u0015\u001a\u00020\u0006H\u0000\u001a.\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001eH\u0002\u001a3\u0010\u001f\u001a\u0004\u0018\u00010 *\u00020\u00062#\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'0\"H\u0000\u001a \u0010(\u001a\u00020\t*\u00020\u00062\n\u0010\f\u001a\u00060\u0003j\u0002`\r2\u0006\u0010)\u001a\u00020*H\u0000\u001a'\u0010+\u001a\u0004\u0018\u00010,*\n\u0012\u0006\u0012\u0004\u0018\u00010#0-2\n\u0010.\u001a\u00060\u0003j\u0002`/H\u0002¢\u0006\u0002\u00100\u001a\u0015\u00101\u001a\u000602j\u0002`3*\u00060\u0003j\u0002`\rH\u0082\b\u001a\u0016\u00104\u001a\u00020\u0001*\u0004\u0018\u00010#2\u0006\u00105\u001a\u00020\u0003H\u0002\"\u000e\u00106\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"flagsNames", "", "flags", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "asLinkBufferSlotTable", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "Landroidx/compose/runtime/SlotStorage;", "throwConcurrentModificationException", "", "compositionGroupOf", "Landroidx/compose/runtime/tooling/CompositionGroup;", "group", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "removeCurrentGroup", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "deactivateCurrentGroup", "nodeIndexOf", "groupAddress", "table", "extractMovableContentAtCurrent", "Landroidx/compose/runtime/MovableContentState;", "composition", "Landroidx/compose/runtime/ControlledComposition;", ReferenceElement.ELEMENT, "Landroidx/compose/runtime/MovableContentStateReference;", "slots", "applier", "Landroidx/compose/runtime/Applier;", "findLocation", "Landroidx/compose/runtime/tooling/ObjectLocation;", "filter", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "value", "", "adoptScopesInGroupToNewParent", "newOwner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "recomposeScopeOrNullInRegion", "Landroidx/compose/runtime/RecomposeScopeImpl;", "", "slotRegion", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "([Ljava/lang/Object;I)Landroidx/compose/runtime/RecomposeScopeImpl;", "toGroupHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "summarize", "size", "LIVE_EDIT_INVALID_KEY", "runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SlotTableKt {
    private static final int LIVE_EDIT_INVALID_KEY = -3;

    /* JADX INFO: Access modifiers changed from: private */
    public static final String flagsNames(int i) {
        String str = (i & 8388608) == 8388608 ? "N" : "";
        if ((i & 16777216) == 16777216) {
            str = str + 'O';
        }
        if ((i & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
            str = str + 'A';
        }
        if ((i & 67108864) == 67108864) {
            str = str + Matrix.MATRIX_TYPE_RANDOM_REGULAR;
        }
        if ((i & 134217728) == 134217728) {
            str = str + Constants.INAPP_POSITION_RIGHT;
        }
        if ((i & 268435456) == 268435456) {
            str = str + 'C';
        }
        if ((i & 536870912) == 536870912) {
            str = str + Constants.INAPP_POSITION_CENTER;
        }
        if ((i & 1073741824) == 1073741824) {
            str = str + 'S';
        }
        if ((i & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            str = str + 's';
        }
        int i2 = 8388607 & i;
        if (i2 == 0) {
            return str;
        }
        if ((i & (-8388608)) != 0) {
            str = str + ' ';
        }
        return str + "CC(" + i2 + ')';
    }

    public static final SlotTable asLinkBufferSlotTable(SlotStorage slotStorage) {
        SlotTable slotTable = slotStorage instanceof SlotTable ? (SlotTable) slotStorage : null;
        if (slotTable != null) {
            return slotTable;
        }
        ComposerKt.composeRuntimeError("Inconsistent composer");
        throw new KotlinNothingValueException();
    }

    public static final void throwConcurrentModificationException() {
        throw new ConcurrentModificationException();
    }

    public static final CompositionGroup compositionGroupOf(SlotTable slotTable, int i) {
        return new SlotTableGroup(slotTable, i, slotTable.getVersion());
    }

    public static final void removeCurrentGroup(SlotTableEditor slotTableEditor, final RememberManager rememberManager) {
        slotTableEditor.visitSlotsInRememberOrder(slotTableEditor.getCurrent(), new SlotTableEditor.VisitSlotsInRememberOrderCallback() { // from class: androidx.compose.runtime.composer.linkbuffer.SlotTableKt$$ExternalSyntheticLambda1
            @Override // androidx.compose.runtime.composer.linkbuffer.SlotTableEditor.VisitSlotsInRememberOrderCallback
            public final boolean visit(int i, int i2, Object obj) {
                return SlotTableKt.removeCurrentGroup$lambda$0(rememberManager, i, i2, obj);
            }
        });
        SlotTableEditor.removeGroup$default(slotTableEditor, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCurrentGroup$lambda$0(RememberManager rememberManager, int i, int i2, Object obj) {
        if (obj instanceof ComposeNodeLifecycleCallback) {
            rememberManager.releasing((ComposeNodeLifecycleCallback) obj);
        }
        if (obj instanceof RememberObserverHolder) {
            rememberManager.forgetting((RememberObserverHolder) obj);
        }
        if (!(obj instanceof RecomposeScopeImpl)) {
            return false;
        }
        ((RecomposeScopeImpl) obj).release();
        return false;
    }

    public static final void deactivateCurrentGroup(SlotTableEditor slotTableEditor, final RememberManager rememberManager) {
        slotTableEditor.visitSlotsInRememberOrder(slotTableEditor.getCurrent(), new SlotTableEditor.VisitSlotsInRememberOrderCallback() { // from class: androidx.compose.runtime.composer.linkbuffer.SlotTableKt$$ExternalSyntheticLambda0
            @Override // androidx.compose.runtime.composer.linkbuffer.SlotTableEditor.VisitSlotsInRememberOrderCallback
            public final boolean visit(int i, int i2, Object obj) {
                return SlotTableKt.deactivateCurrentGroup$lambda$0(rememberManager, i, i2, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deactivateCurrentGroup$lambda$0(RememberManager rememberManager, int i, int i2, Object obj) {
        if (obj instanceof ComposeNodeLifecycleCallback) {
            rememberManager.deactivating((ComposeNodeLifecycleCallback) obj);
            return false;
        }
        if (obj instanceof ReusableRememberObserverHolder) {
            return false;
        }
        if (obj instanceof RememberObserverHolder) {
            rememberManager.forgetting((RememberObserverHolder) obj);
            return true;
        }
        if (!(obj instanceof RecomposeScopeImpl)) {
            return false;
        }
        ((RecomposeScopeImpl) obj).release();
        return true;
    }

    public static final int nodeIndexOf(int i, SlotTable slotTable) {
        SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
        int[] groups = addressSpace.getGroups();
        int i2 = 0;
        while (i > 0) {
            int i3 = groups[i + 2];
            int[] groups2 = addressSpace.getGroups();
            for (int i4 = groups2[i3 + 3]; i4 > 0 && i4 != i; i4 = groups2[i4 + 1]) {
                int i5 = groups[i + 4];
                i2 += (i5 & 8388608) == 8388608 ? 1 : 8388607 & i5;
            }
            if ((groups[i3 + 4] & 8388608) == 8388608) {
                return i2;
            }
            i = i3;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MovableContentState extractMovableContentAtCurrent(final ControlledComposition controlledComposition, final MovableContentStateReference movableContentStateReference, SlotTableEditor slotTableEditor, Applier<?> applier) {
        int current = slotTableEditor.getCurrent();
        if (applier != null && slotTableEditor.nodeCountOf(current) > 0) {
            SlotTableAddressSpace addressSpace = slotTableEditor.getTable().getAddressSpace();
            int parent = slotTableEditor.getParent();
            int[] groups = addressSpace.getGroups();
            int i = groups[parent + 2];
            while (true) {
                if (i <= 0) {
                    if (!(i != 0)) {
                        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + parent);
                    }
                    i = -1;
                } else {
                    if (slotTableEditor.isNode(i)) {
                        break;
                    }
                    i = groups[i + 2];
                }
            }
            if (i >= 0 && slotTableEditor.isNode(i)) {
                Object objNode = slotTableEditor.node(i);
                if (objNode == null) {
                    ComposerKt.composeImmediateRuntimeError("Invalid slot table structure");
                    objNode = Unit.INSTANCE;
                }
                int iNodeIndexOf = nodeIndexOf(current, slotTableEditor.getTable());
                int iNodeCountOf = slotTableEditor.nodeCountOf(current);
                applier.down(objNode);
                applier.remove(iNodeIndexOf, iNodeCountOf);
                applier.up();
            }
        }
        SlotTable table = slotTableEditor.getTable();
        SlotTable.Companion companion = SlotTable.INSTANCE;
        SlotTableBuilder slotTableBuilder = new SlotTableBuilder(table.getAddressSpace(), false, false);
        slotTableBuilder.buildStart();
        MovableContent<Object> content$runtime = movableContentStateReference.getContent$runtime();
        slotTableBuilder.startNewGroup(MovableContentKt.movableContentKey, content$runtime == Composer.INSTANCE.getEmpty() ? 0 : 16777216, content$runtime, null, null);
        slotTableBuilder.addFlags(268435456);
        slotTableBuilder.append(movableContentStateReference.getParameter());
        slotTableBuilder.moveFrom(slotTableEditor, (((long) 0) << 32) | (((long) UInt.m12488constructorimpl(slotTableEditor.firstChildOf(LinkAnchorKt.asLinkAnchor(movableContentStateReference.getAnchor()).getAddress()))) & 4294967295L));
        slotTableBuilder.endGroup();
        SlotTable slotTableBuild = slotTableBuilder.build();
        MovableContentState movableContentState = new MovableContentState(slotTableBuild);
        if (slotTableBuild.getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot read while an editor is pending");
        }
        SlotTableAddressSpace addressSpace2 = slotTableBuild.getAddressSpace();
        int root = slotTableBuild.getRoot();
        if (root < 0) {
            return movableContentState;
        }
        IntStack intStack = new IntStack();
        int[] groups2 = addressSpace2.getGroups();
        RecomposeScopeOwner recomposeScopeOwner = null;
        while (true) {
            int i2 = slotTableBuild.getGroups()[root + 5];
            if (i2 != -1) {
                SlotTableAddressSpace addressSpace3 = slotTableBuild.getAddressSpace();
                int i3 = (i2 & 15) + 1;
                int i4 = i2 >> 4;
                if (i3 > 15) {
                    i3 = addressSpace3.getLargeSizes().get(i4);
                }
                for (int i5 = 0; i5 < i3; i5++) {
                    Object obj = slotTableBuild.getSlots()[i4 + i5];
                    if (Intrinsics.areEqual(obj, Composer.INSTANCE.getEmpty())) {
                        break;
                    }
                    if (obj instanceof RecomposeScopeImpl) {
                        RecomposeScopeOwner recomposeScopeOwner2 = recomposeScopeOwner;
                        if (recomposeScopeOwner2 == null) {
                            recomposeScopeOwner = new RecomposeScopeOwner() { // from class: androidx.compose.runtime.composer.linkbuffer.SlotTableKt$extractMovableContentAtCurrent$1$owner$1
                                @Override // androidx.compose.runtime.RecomposeScopeOwner
                                public void recomposeScopeReleased(RecomposeScopeImpl scope) {
                                }

                                @Override // androidx.compose.runtime.RecomposeScopeOwner
                                public void recordReadOf(Object value) {
                                }

                                @Override // androidx.compose.runtime.RecomposeScopeOwner
                                public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
                                    InvalidationResult invalidationResultInvalidate;
                                    ControlledComposition controlledComposition2 = controlledComposition;
                                    RecomposeScopeOwner recomposeScopeOwner3 = controlledComposition2 instanceof RecomposeScopeOwner ? (RecomposeScopeOwner) controlledComposition2 : null;
                                    if (recomposeScopeOwner3 == null || (invalidationResultInvalidate = recomposeScopeOwner3.invalidate(scope, instance)) == null) {
                                        invalidationResultInvalidate = InvalidationResult.IGNORED;
                                    }
                                    if (invalidationResultInvalidate != InvalidationResult.IGNORED) {
                                        return invalidationResultInvalidate;
                                    }
                                    MovableContentStateReference movableContentStateReference2 = movableContentStateReference;
                                    List<Pair<RecomposeScopeImpl, Object>> invalidations$runtime = movableContentStateReference2.getInvalidations$runtime();
                                    if (instance == null) {
                                        instance = ScopeInvalidated.INSTANCE;
                                    }
                                    movableContentStateReference2.setInvalidations$runtime(CollectionsKt.plus((Collection<? extends Pair>) invalidations$runtime, TuplesKt.to(scope, instance)));
                                    return InvalidationResult.SCHEDULED;
                                }
                            };
                            recomposeScopeOwner2 = recomposeScopeOwner;
                        }
                        ((RecomposeScopeImpl) obj).adoptedBy(recomposeScopeOwner2);
                    }
                }
            }
            int i6 = groups2[root + 1];
            if (i6 >= 0) {
                intStack.push(i6);
            }
            root = groups2[root + 3];
            if (root < 0) {
                if (intStack.tos == 0) {
                    return movableContentState;
                }
                root = intStack.pop();
            }
        }
    }

    public static final void adoptScopesInGroupToNewParent(SlotTable slotTable, int i, RecomposeScopeOwner recomposeScopeOwner) {
        int i2;
        int[] groups = slotTable.getAddressSpace().getGroups();
        Object[] slots = slotTable.getAddressSpace().getSlots();
        SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
        if (i < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups2 = addressSpace.getGroups();
        int iPop = i;
        while (true) {
            RecomposeScopeImpl recomposeScopeImplRecomposeScopeOrNullInRegion = recomposeScopeOrNullInRegion(slots, groups[iPop + 5]);
            if (recomposeScopeImplRecomposeScopeOrNullInRegion != null) {
                recomposeScopeImplRecomposeScopeOrNullInRegion.adoptedBy(recomposeScopeOwner);
            }
            if (iPop != i && (i2 = groups2[iPop + 1]) >= 0) {
                intStack.push(i2);
            }
            iPop = groups2[iPop + 3];
            if (iPop < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    iPop = intStack.pop();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecomposeScopeImpl recomposeScopeOrNullInRegion(Object[] objArr, int i) {
        if (i < 0) {
            return null;
        }
        Object obj = objArr[i >> 4];
        if (obj instanceof RecomposeScopeImpl) {
            return (RecomposeScopeImpl) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String summarize(Object obj, int i) {
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            return str;
        }
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(String.valueOf(obj), "androidx.", "a.", false, 4, (Object) null), "compose.", "c.", false, 4, (Object) null), "runtime.", "r.", false, 4, (Object) null), "internal.", "ι.", false, 4, (Object) null), "ui.", "u.", false, 4, (Object) null), "foundation.", "f.", false, 4, (Object) null), "Modifier", "μ", false, 4, (Object) null), "material.", "m.", false, 4, (Object) null), "Function", "λ", false, 4, (Object) null), "OpaqueKey", "κ", false, 4, (Object) null), "MutableState", "σ", false, 4, (Object) null);
        String strSubstring = strReplace$default.substring(0, Math.min(i, strReplace$default.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final ObjectLocation findLocation(SlotTable slotTable, Function1<Object, Boolean> function1) {
        int i;
        SlotTableReader slotTableReaderOpenReader = slotTable.openReader();
        try {
            int root = slotTable.getRoot();
            SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
            if (root >= 0) {
                IntStack intStack = new IntStack();
                int[] groups = addressSpace.getGroups();
                int iPop = root;
                while (true) {
                    if (slotTableReaderOpenReader.isNode(iPop) && function1.invoke(slotTableReaderOpenReader.node(iPop)).booleanValue()) {
                        return new ObjectLocation(iPop, null);
                    }
                    int i2 = slotTable.getGroups()[iPop + 5];
                    if (i2 != -1) {
                        SlotTableAddressSpace addressSpace2 = slotTable.getAddressSpace();
                        int i3 = (i2 & 15) + 1;
                        int i4 = i2 >> 4;
                        if (i3 > 15) {
                            i3 = addressSpace2.getLargeSizes().get(i4);
                        }
                        for (int i5 = 0; i5 < i3; i5++) {
                            Object obj = slotTable.getSlots()[i4 + i5];
                            if (Intrinsics.areEqual(obj, Composer.INSTANCE.getEmpty())) {
                                break;
                            }
                            if (function1.invoke(obj).booleanValue()) {
                                return new ObjectLocation(iPop, Integer.valueOf(i5));
                            }
                        }
                    }
                    if (iPop != root && (i = groups[iPop + 1]) >= 0) {
                        intStack.push(i);
                    }
                    iPop = groups[iPop + 3];
                    if (iPop < 0) {
                        if (intStack.tos == 0) {
                            break;
                        }
                        iPop = intStack.pop();
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            return null;
        } finally {
            slotTableReaderOpenReader.close();
        }
    }

    private static final long toGroupHandle(int i) {
        return (((long) 0) << 32) | (((long) UInt.m12488constructorimpl(i)) & 4294967295L);
    }
}
