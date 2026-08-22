package androidx.compose.runtime.composer.linkbuffer;

import androidx.collection.IntSetKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.httpfileupload.element.Slot;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.message_fastening.element.FasteningElement;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0015\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\b\u0001\u0018\u0000 §\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0006¥\u0001¦\u0001§\u0001B/\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fJ\b\u0010%\u001a\u00020&H\u0016J\"\u0010'\u001a\u00020\u00002\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020&0)¢\u0006\u0002\b+H\u0086\bJ-\u0010,\u001a\u0002H-\"\u0004\b\u0000\u0010-2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u0002H-0)¢\u0006\u0002\b+H\u0086\b¢\u0006\u0002\u0010.J-\u0010/\u001a\u0002H-\"\u0004\b\u0000\u0010-2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002H-0)¢\u0006\u0002\b+H\u0086\b¢\u0006\u0002\u0010.J\u0006\u00101\u001a\u000200J\u000e\u00102\u001a\u00020&2\u0006\u00103\u001a\u000200J\u0006\u00104\u001a\u00020\u001bJ\u000e\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\u001bJ\u0015\u00107\u001a\u00020\n2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0086\u0002J\u0011\u00107\u001a\u00020\n2\u0006\u0010:\u001a\u00020;H\u0086\u0002J\u0012\u0010<\u001a\u00020\n2\n\u0010=\u001a\u00060\u0006j\u0002`>J\u0012\u0010?\u001a\u00020\n2\n\u00108\u001a\u00060\u0006j\u0002`9J\u0016\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020;J\u0010\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020&2\u0006\u0010D\u001a\u00020EH\u0016J.\u0010G\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J0H2\n\u0010K\u001a\u0006\u0012\u0002\b\u00030L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020I0NH\u0016J\u0012\u0010O\u001a\u0004\u0018\u00010\u00042\u0006\u0010P\u001a\u00020QH\u0016J\u0018\u0010R\u001a\u00020\n2\u0006\u00108\u001a\u00020\u00062\u0006\u0010:\u001a\u00020SH\u0016J\u0018\u0010@\u001a\u00020\n2\u0006\u0010T\u001a\u00020S2\u0006\u0010U\u001a\u00020SH\u0016J\u0018\u0010V\u001a\u00020&2\u0006\u0010D\u001a\u00020E2\u0006\u0010W\u001a\u00020JH\u0016J\b\u0010X\u001a\u00020&H\u0016J\u0018\u0010Y\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010Z2\u0006\u0010\\\u001a\u00020\u0006H\u0016J\u0010\u0010]\u001a\u00020\n2\u0006\u0010^\u001a\u00020[H\u0016J\u0016\u0010_\u001a\u0004\u0018\u00010[2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0002J\u001b\u0010`\u001a\u0004\u0018\u00010[2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0002\baJA\u0010b\u001a\u00020&2\n\u00108\u001a\u00060\u0006j\u0002`92%\u0010c\u001a!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bfJA\u0010g\u001a\u00020&2\n\u00108\u001a\u00060\u0006j\u0002`92%\u0010c\u001a!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bhJA\u0010i\u001a\u00020&2\n\u00108\u001a\u00060\u0006j\u0002`92%\u0010c\u001a!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bjJK\u0010k\u001a\u00020&2\n\u00108\u001a\u00060\u0006j\u0002`92\b\b\u0002\u0010l\u001a\u00020\n2%\u0010c\u001a!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bmJ5\u0010n\u001a\u00020&2%\u0010c\u001a!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\boJ%\u0010p\u001a\u00020\n2\n\u0010U\u001a\u00060\u0006j\u0002`92\n\u0010T\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0002\bqJ3\u0010r\u001a\u00020&2#\u0010s\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010Q¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(t\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\buJT\u0010v\u001a\u00020&2\n\u00108\u001a\u00060\u0006j\u0002`928\u0010s\u001a4\u0012\u0015\u0012\u0013\u0018\u00010Q¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020&0wH\u0080\b¢\u0006\u0002\byJ\u0006\u0010z\u001a\u00020\u0000J\b\u0010{\u001a\u00020&H\u0016J\b\u0010|\u001a\u00020&H\u0016J\b\u0010}\u001a\u00020~H\u0016J\u000e\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\nJ\t\u0010\u0080\u0001\u001a\u00020&H\u0016J\u0011\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u0086\u0001H\u0096\u0002J\u001b\u0010\u0087\u0001\u001a\u00020\u00062\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0088\u0001J\u001b\u0010\u0089\u0001\u001a\u00020\u00062\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u008a\u0001J\u001b\u0010\u008b\u0001\u001a\u00020\n2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u008c\u0001J%\u0010\u008d\u0001\u001a\u0004\u0018\u00010Q2\n\u00108\u001a\u00060\u0006j\u0002`92\u0006\u0010x\u001a\u00020\u0006H\u0000¢\u0006\u0003\b\u008e\u0001J\u001d\u0010\u008f\u0001\u001a\u0004\u0018\u00010Q2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0090\u0001J\u001d\u0010\u0091\u0001\u001a\u0004\u0018\u00010Q2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0092\u0001J\u001d\u0010\u0093\u0001\u001a\u0004\u0018\u00010Q2\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0094\u0001J\u001b\u0010\u0095\u0001\u001a\u00020\u00062\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0096\u0001J\u001b\u0010\u0097\u0001\u001a\u00020\u00062\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0098\u0001J\u001b\u0010\u0099\u0001\u001a\u00020\u00062\n\u00108\u001a\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u009a\u0001J\u0011\u0010¡\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Q0\u0003H\u0016J\u000f\u0010£\u0001\u001a\u00020QH\u0000¢\u0006\u0003\b¤\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000fR\u0011\u0010#\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b$\u0010\u0015R\u001d\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0084\u0001\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u0015R\u0018\u0010\u009b\u0001\u001a\u00030\u009c\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R \u0010\u009f\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010Q0 \u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¡\u0001\u0010¢\u0001¨\u0006¨\u0001"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "Landroidx/compose/runtime/SlotStorage;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "root", "", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "recordSourceInformation", "", "recordCallByInformation", "<init>", "(ILandroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;ZZ)V", "getRoot", "()I", "setRoot", "(I)V", "getAddressSpace", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "getRecordSourceInformation", "()Z", "setRecordSourceInformation", "(Z)V", "getRecordCallByInformation", "setRecordCallByInformation", "currentEditor", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "openReaders", "rootHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "value", "version", "getVersion", "hasEditor", "getHasEditor", "dispose", "", "buildSubTable", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "Lkotlin/ExtensionFunctionType;", "edit", ExifInterface.GPS_DIRECTION_TRUE, "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "read", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "openReader", "closeReader", "reader", "openEditor", "closeEditor", "editor", "contains", "group", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", ReferenceElement.ATTR_ANCHOR, "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "containsFlags", "flags", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "hasRecomposeScopes", "inGroup", "groupAnchor", "childAnchor", FasteningElement.ATTR_CLEAR, "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "deactivateAll", "extractNestedStates", "Landroidx/collection/ScatterMap;", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "applier", "Landroidx/compose/runtime/Applier;", "references", "Landroidx/collection/ObjectList;", "find", "identityToFind", "", "groupContainsAnchor", "Landroidx/compose/runtime/Anchor;", Message.Thread.PARENT_ATTRIBUTE_NAME, "child", "disposeUnusedMovableContent", "state", "invalidateAll", "invalidateGroupsWithKey", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", TypedValues.AttributesType.S_TARGET, "ownsRecomposeScope", "scope", "findEffectiveRecomposeScope", "getRecomposeScopeOrNull", "getRecomposeScopeOrNull$runtime", "traverseSiblings", "visit", "Lkotlin/ParameterName;", "name", "traverseSiblings$runtime", "traverseGroupAndParents", "traverseGroupAndParents$runtime", "traverseChildren", "traverseChildren$runtime", "traverseGroup", "includeSiblingsOfStartGroup", "traverseGroup$runtime", "traverseTable", "traverseTable$runtime", "isGroupAChildOf", "isGroupAChildOf$runtime", "forEachSlot", "action", Slot.ELEMENT, "forEachSlot$runtime", "forEachGroupSlot", "Lkotlin/Function2;", FirebaseAnalytics.Param.INDEX, "forEachGroupSlot$runtime", "newTableInSameAddressSpace", "collectSourceInformation", "collectCalledByInformation", "toDebugString", "", "includeSlots", "verifyWellFormed", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "isEmpty", "iterator", "", "nextSiblingOf", "nextSiblingOf$runtime", "firstChildOf", "firstChildOf$runtime", "groupHasAux", "groupHasAux$runtime", "groupSlotAtIndex", "groupSlotAtIndex$runtime", "groupObjectKey", "groupObjectKey$runtime", "groupAux", "groupAux$runtime", "groupNode", "groupNode$runtime", "groupKeyOf", "groupKeyOf$runtime", "groupSlotRange", "groupSlotRange$runtime", "groupFlags", "groupFlags$runtime", "groups", "", "getGroups", "()[I", "slots", "", "getSlots", "()[Ljava/lang/Object;", "toDebugTree", "toDebugTree$runtime", "DebugGroup", "DebugSlotRange", "Companion", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlotTable extends SlotStorage implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    private final SlotTableAddressSpace addressSpace;
    private SlotTableEditor currentEditor;
    private int openReaders;
    private boolean recordCallByInformation;
    private boolean recordSourceInformation;
    private int root;
    private int version;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public SlotTable() {
        this(0, null, false, false, 15, null);
    }

    public SlotTable(int i, SlotTableAddressSpace slotTableAddressSpace, boolean z, boolean z2) {
        this.root = i;
        this.addressSpace = slotTableAddressSpace;
        this.recordSourceInformation = z;
        this.recordCallByInformation = z2;
    }

    public final int getRoot() {
        return this.root;
    }

    public final void setRoot(int i) {
        this.root = i;
    }

    public /* synthetic */ SlotTable(int i, SlotTableAddressSpace slotTableAddressSpace, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? new SlotTableAddressSpace() : slotTableAddressSpace, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2);
    }

    public final SlotTableAddressSpace getAddressSpace() {
        return this.addressSpace;
    }

    public final boolean getRecordSourceInformation() {
        return this.recordSourceInformation;
    }

    public final void setRecordSourceInformation(boolean z) {
        this.recordSourceInformation = z;
    }

    public final boolean getRecordCallByInformation() {
        return this.recordCallByInformation;
    }

    public final void setRecordCallByInformation(boolean z) {
        this.recordCallByInformation = z;
    }

    public final long rootHandle() {
        return (((long) (-1)) << 32) | (((long) UInt.m12488constructorimpl(this.root)) & 4294967295L);
    }

    public final int getVersion() {
        return this.version;
    }

    public final boolean getHasEditor() {
        return this.currentEditor != null;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void dispose() {
        int i = this.root;
        if (i != -1) {
            this.addressSpace.freeGroupTree(i);
            this.root = -1;
        }
    }

    public final SlotTable buildSubTable(Function1<? super SlotTableBuilder, Unit> block) {
        SlotTableBuilder slotTableBuilder = new SlotTableBuilder(getAddressSpace(), false, false);
        slotTableBuilder.buildStart();
        block.invoke(slotTableBuilder);
        return slotTableBuilder.build();
    }

    public final <T> T edit(Function1<? super SlotTableEditor, ? extends T> block) {
        SlotTableEditor slotTableEditorOpenEditor = openEditor();
        try {
            return block.invoke(slotTableEditorOpenEditor);
        } finally {
            slotTableEditorOpenEditor.close();
        }
    }

    public final <T> T read(Function1<? super SlotTableReader, ? extends T> block) {
        SlotTableReader slotTableReaderOpenReader = openReader();
        try {
            return block.invoke(slotTableReaderOpenReader);
        } finally {
            slotTableReaderOpenReader.close();
        }
    }

    public final SlotTableReader openReader() {
        if (getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot read while a writer is pending");
        }
        this.openReaders++;
        return new SlotTableReader(this);
    }

    public final void closeReader(SlotTableReader reader) {
        if (!(reader.getTable() == this && this.openReaders > 0)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected reader close()");
        }
        this.openReaders--;
    }

    public final SlotTableEditor openEditor() {
        if (getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }
        if (!(this.openReaders <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }
        this.version++;
        SlotTableEditor slotTableEditor = new SlotTableEditor(this);
        this.currentEditor = slotTableEditor;
        return slotTableEditor;
    }

    public final void closeEditor(SlotTableEditor editor) {
        if (!(this.currentEditor == editor)) {
            ComposerKt.composeImmediateRuntimeError("Attempted to close an editor that was not the current editor");
        }
        this.currentEditor = null;
    }

    public final boolean contains(int group) {
        if (group >= 0 && this.addressSpace.contains(group)) {
            int[] groups = this.addressSpace.getGroups();
            int i = groups[group + 2];
            while (true) {
                if (i <= 0) {
                    if (!(i != 0)) {
                        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group);
                    }
                } else {
                    if (i == this.root) {
                        return true;
                    }
                    i = groups[i + 2];
                }
            }
        }
        return false;
    }

    public final boolean contains(LinkAnchor anchor) {
        return anchor.getValid() && this.addressSpace.ownsAnchor(anchor) && contains(anchor.getAddress());
    }

    public final boolean containsFlags(int flags) {
        return !isEmpty() && (this.addressSpace.getGroups()[this.root + 4] & flags) == flags;
    }

    public final boolean hasRecomposeScopes(int group) {
        int i;
        int[] groups = this.addressSpace.getGroups();
        Object[] slots = this.addressSpace.getSlots();
        SlotTableAddressSpace addressSpace = getAddressSpace();
        if (group < 0) {
            return false;
        }
        IntStack intStack = new IntStack();
        int[] groups2 = addressSpace.getGroups();
        int iPop = group;
        while (SlotTableKt.recomposeScopeOrNullInRegion(slots, groups[iPop + 5]) == null) {
            if (iPop != group && (i = groups2[iPop + 1]) >= 0) {
                intStack.push(i);
            }
            iPop = groups2[iPop + 3];
            if (iPop < 0) {
                if (intStack.tos == 0) {
                    return false;
                }
                iPop = intStack.pop();
            }
        }
        return true;
    }

    public final boolean inGroup(LinkAnchor groupAnchor, LinkAnchor childAnchor) {
        if (!groupAnchor.getValid() || !childAnchor.getValid()) {
            return false;
        }
        if (Intrinsics.areEqual(groupAnchor, childAnchor)) {
            return true;
        }
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        if (!slotTableAddressSpace.ownsAnchor(childAnchor) || !slotTableAddressSpace.ownsAnchor(groupAnchor)) {
            return false;
        }
        int address = groupAnchor.getAddress();
        int address2 = childAnchor.getAddress();
        if (!slotTableAddressSpace.contains(address) || !slotTableAddressSpace.contains(address2)) {
            return false;
        }
        int[] groups = slotTableAddressSpace.getGroups();
        int i = groups[address2 + 2];
        while (i > 0) {
            if (i == address) {
                return true;
            }
            if (address <= 0) {
                return false;
            }
            i = groups[i + 2];
        }
        if (!(i != 0)) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + address2);
        }
        return false;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public ScatterMap<MovableContentStateReference, MovableContentState> extractNestedStates(Applier<?> applier, ObjectList<MovableContentStateReference> references) {
        MutableScatterMap mutableScatterMapMutableScatterMapOf = ScatterMapKt.mutableScatterMapOf();
        SlotTableEditor slotTableEditorOpenEditor = openEditor();
        try {
            Object[] objArr = references.content;
            int i = references._size;
            for (int i2 = 0; i2 < i; i2++) {
                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr[i2];
                LinkAnchor linkAnchorAsLinkAnchor = LinkAnchorKt.asLinkAnchor(movableContentStateReference.getAnchor());
                if (slotTableEditorOpenEditor.getTable().contains(linkAnchorAsLinkAnchor)) {
                    slotTableEditorOpenEditor.seek(linkAnchorAsLinkAnchor);
                    mutableScatterMapMutableScatterMapOf.set(movableContentStateReference, SlotTableKt.extractMovableContentAtCurrent(movableContentStateReference.getComposition(), movableContentStateReference, slotTableEditorOpenEditor, applier));
                }
            }
            Unit unit = Unit.INSTANCE;
            slotTableEditorOpenEditor.close();
            return mutableScatterMapMutableScatterMapOf;
        } catch (Throwable th) {
            slotTableEditorOpenEditor.close();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object identityToFind) {
        return new SlotTableGroup(this, this.root, this.version).find(identityToFind);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean groupContainsAnchor(int group, Anchor anchor) {
        LinkAnchor linkAnchorAsLinkAnchor = LinkAnchorKt.asLinkAnchor(anchor);
        return this.addressSpace.ownsAnchor(linkAnchorAsLinkAnchor) && isGroupAChildOf$runtime(linkAnchorAsLinkAnchor.getAddress(), group);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean inGroup(Anchor parent, Anchor child) {
        return inGroup(LinkAnchorKt.asLinkAnchor(parent), LinkAnchorKt.asLinkAnchor(child));
    }

    @Override // androidx.compose.runtime.SlotStorage
    public List<RecomposeScopeImpl> invalidateGroupsWithKey(int target) {
        List<RecomposeScopeImpl> list;
        ArrayList arrayList;
        List<RecomposeScopeImpl> list2;
        ArrayList arrayList2;
        int i;
        int i2;
        int i3;
        RecomposeScopeImpl recomposeScopeImplFindEffectiveRecomposeScope;
        LinkAnchor linkAnchorAsLinkAnchor;
        MutableIntSet mutableIntSet;
        int i4 = 0;
        boolean z = true;
        List<RecomposeScopeImpl> list3 = null;
        MutableIntSet mutableIntSet2 = new MutableIntSet(0, 1, null);
        ArrayList arrayList3 = new ArrayList();
        MutableIntSet mutableIntSet3 = new MutableIntSet(0, 1, null);
        mutableIntSet3.add(target);
        mutableIntSet3.add(-3);
        MutableIntObjectMap<MutableIntSet> calledByMap$runtime = this.addressSpace.getCalledByMap$runtime();
        if (calledByMap$runtime != null && (mutableIntSet = calledByMap$runtime.get(target)) != null) {
            mutableIntSet3.addAll(mutableIntSet);
        }
        int i5 = this.root;
        SlotTableAddressSpace addressSpace = getAddressSpace();
        if (i5 >= 0) {
            IntStack intStack = new IntStack();
            int[] groups = addressSpace.getGroups();
            int iPop = i5;
            while (true) {
                int i6 = this.addressSpace.getGroups()[iPop];
                if (mutableIntSet3.contains(i6)) {
                    if (i6 != -3) {
                        mutableIntSet2.plusAssign(iPop);
                    }
                    if (z) {
                        RecomposeScopeImpl recomposeScopeImplFindEffectiveRecomposeScope2 = findEffectiveRecomposeScope(iPop);
                        if (recomposeScopeImplFindEffectiveRecomposeScope2 != null) {
                            ArrayList arrayList4 = arrayList3;
                            arrayList4.add(recomposeScopeImplFindEffectiveRecomposeScope2);
                            Anchor anchor = recomposeScopeImplFindEffectiveRecomposeScope2.getAnchor();
                            Integer numValueOf = (anchor == null || (linkAnchorAsLinkAnchor = LinkAnchorKt.asLinkAnchor(anchor)) == null) ? null : Integer.valueOf(linkAnchorAsLinkAnchor.getAddress());
                            if (numValueOf != null && numValueOf.intValue() == iPop && (recomposeScopeImplFindEffectiveRecomposeScope = findEffectiveRecomposeScope(this.addressSpace.getGroups()[iPop + 2])) != null) {
                                arrayList4.add(recomposeScopeImplFindEffectiveRecomposeScope);
                            }
                        } else {
                            arrayList3.clear();
                            z = false;
                        }
                    }
                }
                if (iPop != i5 && (i3 = groups[iPop + 1]) >= 0) {
                    intStack.push(i3);
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
        SlotTableEditor slotTableEditorOpenEditor = openEditor();
        try {
            MutableIntSet mutableIntSet4 = mutableIntSet2;
            int[] iArr = mutableIntSet4.elements;
            long[] jArr = mutableIntSet4.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i7 = 0;
                while (true) {
                    long j = jArr[i7];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i8 = 8;
                        int i9 = 8 - ((~(i7 - length)) >>> 31);
                        int i10 = i4;
                        while (i10 < i9) {
                            if ((j & 255) < 128) {
                                list2 = list3;
                                arrayList2 = arrayList3;
                                i = i8;
                                i2 = i10;
                                slotTableEditorOpenEditor.seek((((long) i4) << 32) | (((long) UInt.m12488constructorimpl(iArr[(i7 << 3) + i10])) & 4294967295L));
                                slotTableEditorOpenEditor.bashGroup$runtime(-3);
                            } else {
                                list2 = list3;
                                arrayList2 = arrayList3;
                                i = i8;
                                i2 = i10;
                            }
                            j >>= i;
                            i10 = i2 + 1;
                            i8 = i;
                            list3 = list2;
                            arrayList3 = arrayList2;
                            i4 = 0;
                        }
                        list = list3;
                        arrayList = arrayList3;
                        if (i9 != i8) {
                            break;
                        }
                    } else {
                        list = list3;
                        arrayList = arrayList3;
                    }
                    if (i7 == length) {
                        break;
                    }
                    i7++;
                    list3 = list;
                    arrayList3 = arrayList;
                    i4 = 0;
                }
            } else {
                list = null;
                arrayList = arrayList3;
            }
            Unit unit = Unit.INSTANCE;
            return z ? arrayList : list;
        } finally {
            slotTableEditorOpenEditor.close();
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean ownsRecomposeScope(RecomposeScopeImpl scope) {
        Anchor anchor = scope.getAnchor();
        if (anchor != null) {
            LinkAnchor linkAnchorAsLinkAnchor = LinkAnchorKt.asLinkAnchor(anchor);
            if (this.addressSpace.ownsAnchor(linkAnchorAsLinkAnchor) && isGroupAChildOf$runtime(linkAnchorAsLinkAnchor.getAddress(), this.root)) {
                return true;
            }
        }
        return false;
    }

    public final RecomposeScopeImpl getRecomposeScopeOrNull$runtime(int group) {
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int[] groups = slotTableAddressSpace.getGroups();
        Object[] slots = slotTableAddressSpace.getSlots();
        int i = groups[group + 5];
        if (i == -1) {
            return null;
        }
        int i2 = (i & 15) + 1;
        int i3 = i >> 4;
        if (i2 > 15) {
            i2 = slotTableAddressSpace.getLargeSizes().get(i3);
        }
        int i4 = i2 + i3;
        int iUtilitySlotsCountForFlags = i3 + GroupFlagsKt.utilitySlotsCountForFlags(groups[group + 4]);
        if (iUtilitySlotsCountForFlags <= i4) {
            Object obj = slots[iUtilitySlotsCountForFlags];
            if (obj instanceof RecomposeScopeImpl) {
                return (RecomposeScopeImpl) obj;
            }
        }
        return null;
    }

    public final void traverseSiblings$runtime(int group, Function1<? super Integer, Unit> visit) {
        int[] groups = getAddressSpace().getGroups();
        while (group >= 0) {
            visit.invoke(Integer.valueOf(group));
            group = groups[group + 1];
        }
    }

    public final void traverseGroupAndParents$runtime(int group, Function1<? super Integer, Unit> visit) {
        int[] groups = getAddressSpace().getGroups();
        int i = group;
        while (i > 0) {
            visit.invoke(Integer.valueOf(i));
            i = groups[i + 2];
        }
        if (i != 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group);
    }

    public final void traverseChildren$runtime(int group, Function1<? super Integer, Unit> visit) {
        int[] groups = getAddressSpace().getGroups();
        for (int i = groups[group + 3]; i > 0; i = groups[i + 1]) {
            visit.invoke(Integer.valueOf(i));
        }
    }

    public static /* synthetic */ void traverseGroup$runtime$default(SlotTable slotTable, int i, boolean z, Function1 function1, int i2, Object obj) {
        int i3;
        if ((i2 & 2) != 0) {
            z = false;
        }
        SlotTableAddressSpace addressSpace = slotTable.getAddressSpace();
        if (i < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        int iPop = i;
        while (true) {
            function1.invoke(Integer.valueOf(iPop));
            if ((iPop != i || z) && (i3 = groups[iPop + 1]) >= 0) {
                intStack.push(i3);
            }
            iPop = groups[iPop + 3];
            if (iPop < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    iPop = intStack.pop();
                }
            }
        }
    }

    public final void traverseGroup$runtime(int group, boolean includeSiblingsOfStartGroup, Function1<? super Integer, Unit> visit) {
        int i;
        SlotTableAddressSpace addressSpace = getAddressSpace();
        if (group < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        int iPop = group;
        while (true) {
            visit.invoke(Integer.valueOf(iPop));
            if ((iPop != group || includeSiblingsOfStartGroup) && (i = groups[iPop + 1]) >= 0) {
                intStack.push(i);
            }
            iPop = groups[iPop + 3];
            if (iPop < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    iPop = intStack.pop();
                }
            }
        }
    }

    public final void traverseTable$runtime(Function1<? super Integer, Unit> visit) {
        SlotTableAddressSpace addressSpace = getAddressSpace();
        int root = getRoot();
        if (root < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        while (true) {
            visit.invoke(Integer.valueOf(root));
            int i = groups[root + 1];
            if (i >= 0) {
                intStack.push(i);
            }
            root = groups[root + 3];
            if (root < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    root = intStack.pop();
                }
            }
        }
    }

    public final void forEachSlot$runtime(Function1<Object, Unit> action) {
        if (getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot read while an editor is pending");
        }
        SlotTableAddressSpace addressSpace = getAddressSpace();
        int root = getRoot();
        if (root < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        while (true) {
            int i = getGroups()[root + 5];
            if (i != -1) {
                SlotTableAddressSpace addressSpace2 = getAddressSpace();
                int i2 = (i & 15) + 1;
                int i3 = i >> 4;
                if (i2 > 15) {
                    i2 = addressSpace2.getLargeSizes().get(i3);
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj = getSlots()[i3 + i4];
                    if (Intrinsics.areEqual(obj, Composer.INSTANCE.getEmpty())) {
                        break;
                    }
                    action.invoke(obj);
                }
            }
            int i5 = groups[root + 1];
            if (i5 >= 0) {
                intStack.push(i5);
            }
            root = groups[root + 3];
            if (root < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    root = intStack.pop();
                }
            }
        }
    }

    public final void forEachGroupSlot$runtime(int group, Function2<Object, ? super Integer, Unit> action) {
        int i = getGroups()[group + 5];
        if (i != -1) {
            SlotTableAddressSpace addressSpace = getAddressSpace();
            int i2 = (i & 15) + 1;
            int i3 = i >> 4;
            if (i2 > 15) {
                i2 = addressSpace.getLargeSizes().get(i3);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = getSlots()[i3 + i4];
                if (Intrinsics.areEqual(obj, Composer.INSTANCE.getEmpty())) {
                    return;
                }
                action.invoke(obj, Integer.valueOf(i4));
            }
        }
    }

    public final SlotTable newTableInSameAddressSpace() {
        return new SlotTable(0, this.addressSpace, this.recordSourceInformation, this.recordCallByInformation, 1, null);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void collectSourceInformation() {
        this.recordSourceInformation = true;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void collectCalledByInformation() {
        this.recordCallByInformation = true;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public String toDebugString() {
        return toDebugString(true);
    }

    public final String toDebugString(boolean includeSlots) {
        StringBuilder sb = new StringBuilder();
        sb.append("SlotTable(\n");
        int[] groups = getAddressSpace().getGroups();
        for (int i = this.root; i >= 0; i = groups[i + 1]) {
            toDebugString$lambda$0$dumpGroup(sb, this, includeSlots, i, "  ");
        }
        sb.append(")");
        return sb.toString();
    }

    private static final void toDebugString$lambda$0$dumpGroup(StringBuilder sb, SlotTable slotTable, boolean z, int i, String str) {
        int i2;
        sb.append(str);
        int[] groups = slotTable.addressSpace.getGroups();
        sb.append("Group(" + i + ") key: " + groups[i]);
        Object[] slots = slotTable.addressSpace.getSlots();
        int i3 = groups[i + 5];
        int i4 = groups[i + 4];
        int i5 = 8388607 & i4;
        if (i5 > 0) {
            sb.append(" Nodes: ");
            sb.append(i5);
        }
        if (((-67108864) & i4) != 0) {
            sb.append(" Marks: ");
            if ((i4 & 268435456) == 268435456) {
                sb.append('C');
            }
            if ((i4 & 536870912) == 536870912) {
                sb.append(Constants.INAPP_POSITION_CENTER);
            }
            if ((i4 & 1073741824) == 1073741824) {
                sb.append('S');
            }
            if ((i4 & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                sb.append('s');
            }
            if ((i4 & 67108864) == 67108864) {
                sb.append(Matrix.MATRIX_TYPE_RANDOM_REGULAR);
            }
            if ((i4 & 134217728) == 134217728) {
                sb.append(Constants.INAPP_POSITION_RIGHT);
            }
        }
        if (z) {
            int i6 = i3 >> 4;
            if (i3 != -1) {
                SlotTableAddressSpace slotTableAddressSpace = slotTable.addressSpace;
                if (i3 == -1) {
                    i2 = 0;
                } else {
                    i2 = (i3 & 15) + 1;
                    if (i2 > 15) {
                        i2 = slotTableAddressSpace.getLargeSizes().get(i6);
                    }
                }
                int i7 = i2 + i6;
                if ((i4 & 8388608) == 8388608) {
                    sb.append(" Node: ");
                    sb.append(SlotTableKt.summarize(slots[i6], 10));
                    i6++;
                }
                if ((i4 & 16777216) == 16777216) {
                    sb.append(" Key: ");
                    sb.append(SlotTableKt.summarize(slots[i6], 10));
                    i6++;
                }
                if ((i4 & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
                    sb.append(" Aux: ");
                    sb.append(SlotTableKt.summarize(slots[i6], 10));
                    i6++;
                }
                if (i6 < i7) {
                    sb.append(" (" + i6 + '-' + i7 + ")[");
                    while (i6 < i7) {
                        int i8 = i6 + 1;
                        sb.append(SlotTableKt.summarize(slots[i6], 10));
                        if (i8 < i7) {
                            sb.append(", ");
                        }
                        i6 = i8;
                    }
                    sb.append(Constants.AES_SUFFIX);
                }
            }
        }
        sb.append(':').append('\n');
        String str2 = str + "  ";
        int[] groups2 = slotTable.getAddressSpace().getGroups();
        for (int i9 = groups2[i + 3]; i9 > 0; i9 = groups2[i9 + 1]) {
            toDebugString$lambda$0$dumpGroup(sb, slotTable, z, i9, str2);
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void verifyWellFormed() {
        this.addressSpace.validate();
        int[] groups = this.addressSpace.getGroups();
        Object[] slots = this.addressSpace.getSlots();
        MutableIntSet mutableIntSetMutableIntSetOf = IntSetKt.mutableIntSetOf();
        int i = this.root;
        int[] groups2 = getAddressSpace().getGroups();
        for (int i2 = i; i2 >= 0; i2 = groups2[i2 + 1]) {
            verifyWellFormed$validateGroup(mutableIntSetMutableIntSetOf, groups, this, slots, -1, i2);
        }
    }

    private static final void verifyWellFormed$validateSlotRange(SlotTable slotTable, Object[] objArr, int i, int i2) {
        if (i2 == -1) {
            return;
        }
        SlotTableAddressSpace slotTableAddressSpace = slotTable.addressSpace;
        int i3 = (i2 & 15) + 1;
        int i4 = i2 >> 4;
        if (i3 > 15) {
            slotTableAddressSpace.getLargeSizes().get(i4);
        }
        if (i4 < 0 || i4 >= objArr.length) {
            throw new IllegalStateException(("Slot index for group " + i + " out of bounds: " + i4).toString());
        }
    }

    private static final int verifyWellFormed$validateGroup(MutableIntSet mutableIntSet, int[] iArr, SlotTable slotTable, Object[] objArr, int i, int i2) {
        if (i2 == -1) {
            return 0;
        }
        if (mutableIntSet.contains(i2)) {
            throw new IllegalStateException(("Circular group encountered at " + i2).toString());
        }
        mutableIntSet.add(i2);
        if (i2 % 6 != 0) {
            throw new IllegalStateException(("Invalid group address: " + i2).toString());
        }
        if (iArr[i2 + 2] != i) {
            throw new IllegalStateException(("Invalid parent link in group " + i2).toString());
        }
        SlotTable slotTable2 = slotTable;
        Object[] objArr2 = objArr;
        verifyWellFormed$validateSlotRange(slotTable2, objArr2, i2, iArr[i2 + 5]);
        int i3 = i2 + 4;
        int i4 = iArr[i3] & GroupFlagsKt.HasMarkFlags;
        int[] groups = slotTable2.getAddressSpace().getGroups();
        int i5 = groups[i2 + 3];
        int iVerifyWellFormed$validateGroup = 0;
        int i6 = 0;
        while (i5 > 0) {
            iVerifyWellFormed$validateGroup += verifyWellFormed$validateGroup(mutableIntSet, iArr, slotTable2, objArr2, i2, i5);
            int iPropagatingFlagsOf = GroupFlagsKt.propagatingFlagsOf(iArr[i5 + 4]);
            i6 |= iPropagatingFlagsOf;
            if (iPropagatingFlagsOf != 0 && (i4 & iPropagatingFlagsOf) == 0) {
                StringBuilder sbAppend = new StringBuilder("Group ").append(i5).append(" contains a flag that the parent, ").append(i2).append(", is not recorded as having, ");
                String string = Integer.toString(iPropagatingFlagsOf, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                throw new IllegalStateException(sbAppend.append(string).append(' ').append(SlotTableKt.flagsNames(iPropagatingFlagsOf)).toString().toString());
            }
            i5 = groups[i5 + 1];
            slotTable2 = slotTable;
            objArr2 = objArr;
        }
        int i7 = iArr[i3];
        int i8 = i7 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
        if (i8 != iVerifyWellFormed$validateGroup) {
            throw new IllegalStateException(("Unexpected node count for group " + i2 + ", expected " + iVerifyWellFormed$validateGroup + ", received: " + i8).toString());
        }
        if (i4 == i6) {
            if ((i7 & 8388608) == 8388608) {
                return 1;
            }
            return i7 & GroupFlagsSpec.CHILD_NODE_COUNT_MASK;
        }
        StringBuilder sbAppend2 = new StringBuilder("Unexpected has mark flags for group ").append(i2).append(", expected ");
        String string2 = Integer.toString(i6, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        StringBuilder sbAppend3 = sbAppend2.append(string2).append(' ').append(SlotTableKt.flagsNames(i6)).append(", received ");
        String string3 = Integer.toString(i4, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        throw new IllegalStateException(sbAppend3.append(string3).append(' ').append(SlotTableKt.flagsNames(i4)).toString().toString());
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    @Override // androidx.compose.runtime.SlotStorage, androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        return this.root == -1;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, this.root);
    }

    public final int nextSiblingOf$runtime(int group) {
        return getGroups()[group + 1];
    }

    public final int firstChildOf$runtime(int group) {
        return getGroups()[group + 3];
    }

    public final boolean groupHasAux$runtime(int group) {
        return (getGroups()[group + 4] & GroupFlagsKt.HasAuxSlotFlag) == 33554432;
    }

    public final Object groupSlotAtIndex$runtime(int group, int index) {
        int i = group + 5;
        if (getGroups()[i] == -1 || index < 0) {
            return null;
        }
        int i2 = getGroups()[i];
        SlotTableAddressSpace slotTableAddressSpace = this.addressSpace;
        int i3 = (i2 & 15) + 1;
        int i4 = i2 >> 4;
        if (i3 > 15) {
            i3 = slotTableAddressSpace.getLargeSizes().get(i4);
        }
        if (index >= i3) {
            return null;
        }
        return getSlots()[i4 + index];
    }

    public final Object groupObjectKey$runtime(int group) {
        int i = getGroups()[group + 4];
        if ((i & 16777216) == 16777216) {
            return groupSlotAtIndex$runtime(group, Integer.bitCount(i & 8388608));
        }
        return null;
    }

    public final Object groupAux$runtime(int group) {
        int i = getGroups()[group + 4];
        if ((i & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
            return groupSlotAtIndex$runtime(group, Integer.bitCount(i & 25165824));
        }
        return null;
    }

    public final Object groupNode$runtime(int group) {
        if ((getGroups()[group + 4] & 8388608) == 8388608) {
            return groupSlotAtIndex$runtime(group, 0);
        }
        return null;
    }

    public final int groupKeyOf$runtime(int group) {
        return getGroups()[group];
    }

    public final int groupSlotRange$runtime(int group) {
        return getGroups()[group + 5];
    }

    public final int groupFlags$runtime(int group) {
        return getGroups()[group + 4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] getGroups() {
        return this.addressSpace.getGroups();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] getSlots() {
        return this.addressSpace.getSlots();
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.composer.linkbuffer.SlotTable$getSlots$1, reason: invalid class name */
    /* JADX INFO: compiled from: SlotTable.kt */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0011\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H\u0096\u0002¨\u0006\u0005"}, d2 = {"androidx/compose/runtime/composer/linkbuffer/SlotTable$getSlots$1", "", "", "iterator", "", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterable<Object>, KMappedMarker {
        AnonymousClass1() {
        }

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return SequencesKt.iterator(new SlotTable$getSlots$1$iterator$1(SlotTable.this, null));
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    /* JADX INFO: renamed from: getSlots, reason: collision with other method in class */
    public Iterable<Object> mo5220getSlots() {
        return new AnonymousClass1();
    }

    public final Object toDebugTree$runtime() {
        List list = SequencesKt.toList(SequencesKt.sequence(new SlotTable$toDebugTree$1(this, null)));
        return list.size() == 1 ? CollectionsKt.first(list) : list;
    }

    /* JADX INFO: compiled from: SlotTable.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010+\u001a\u00020,H\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\f\u0012\b\u0012\u00060\u0000R\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\bR\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\bR\u0015\u0010\u0014\u001a\u00060\u0015R\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0011\u0010\"\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0011\u0010#\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b$\u0010!R\u0011\u0010%\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b%\u0010!R\u0011\u0010&\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b'\u0010!R\u0011\u0010(\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b(\u0010!R\u0011\u0010)\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b*\u0010!¨\u0006-"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugGroup;", "", "address", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;I)V", "getAddress", "()I", "children", "", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "getChildren", "()Ljava/util/List;", "slots", "getSlots", "key", "getKey", "flags", "getFlags", "slotRange", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugSlotRange;", "getSlotRange", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugSlotRange;", "objectKey", "getObjectKey", "()Ljava/lang/Object;", NodeElement.ELEMENT, "getNode", "aux", "getAux", "isNode", "", "()Z", "isMovableContent", "hasMovableContent", "getHasMovableContent", "isSubComposition", "hasSubComposition", "getHasSubComposition", "isRecomposeRequired", "hasRecomposeRequired", "getHasRecomposeRequired", InAppPurchaseConstants.METHOD_TO_STRING, "", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DebugGroup {
        private final int address;

        public DebugGroup(int i) {
            this.address = i;
        }

        public final int getAddress() {
            return this.address;
        }

        public final List<DebugGroup> getChildren() {
            return SequencesKt.toList(SequencesKt.sequence(new SlotTable$DebugGroup$children$1(SlotTable.this, this, null)));
        }

        public final List<Object> getSlots() {
            return SequencesKt.toList(SequencesKt.sequence(new SlotTable$DebugGroup$slots$1(this, SlotTable.this, null)));
        }

        public final int getKey() {
            return SlotTable.this.getGroups()[this.address];
        }

        public final int getFlags() {
            return SlotTable.this.getGroups()[this.address + 4];
        }

        public final DebugSlotRange getSlotRange() {
            SlotTable slotTable = SlotTable.this;
            return slotTable.new DebugSlotRange(slotTable.getGroups()[this.address + 5]);
        }

        public final Object getObjectKey() {
            if ((getFlags() & 16777216) == 16777216) {
                return SlotTable.this.getSlots()[getSlotRange().getAddress() + Integer.bitCount(getFlags() & 8388608)];
            }
            return Composer.INSTANCE.getEmpty();
        }

        public final Object getNode() {
            if ((getFlags() & 8388608) == 8388608) {
                Object[] slots = SlotTable.this.getSlots();
                int address = getSlotRange().getAddress();
                getFlags();
                return slots[address];
            }
            return Composer.INSTANCE.getEmpty();
        }

        public final Object getAux() {
            if ((getFlags() & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
                return SlotTable.this.getSlots()[getSlotRange().getAddress() + Integer.bitCount(getFlags() & 25165824)];
            }
            return Composer.INSTANCE.getEmpty();
        }

        public final boolean isNode() {
            return (getFlags() & 8388608) == 8388608;
        }

        public final boolean isMovableContent() {
            return (getFlags() & 268435456) == 268435456;
        }

        public final boolean getHasMovableContent() {
            return (getFlags() & 536870912) == 536870912;
        }

        public final boolean isSubComposition() {
            return (getFlags() & 67108864) == 67108864;
        }

        public final boolean getHasSubComposition() {
            return (getFlags() & Integer.MIN_VALUE) == Integer.MIN_VALUE;
        }

        public final boolean isRecomposeRequired() {
            return (getFlags() & 67108864) == 67108864;
        }

        public final boolean getHasRecomposeRequired() {
            return (getFlags() & 134217728) == 134217728;
        }

        public String toString() {
            SlotTable slotTable = SlotTable.this;
            StringBuilder sb = new StringBuilder("Group(");
            sb.append(getKey());
            if ((getFlags() & (-67108864)) != 0) {
                sb.append(", flags=");
                if (isMovableContent()) {
                    sb.append('C');
                }
                if (getHasMovableContent()) {
                    sb.append(Constants.INAPP_POSITION_CENTER);
                }
                if (isSubComposition()) {
                    sb.append('S');
                }
                if (getHasSubComposition()) {
                    sb.append('s');
                }
                if (isRecomposeRequired()) {
                    sb.append(Matrix.MATRIX_TYPE_RANDOM_REGULAR);
                }
                if (getHasRecomposeRequired()) {
                    sb.append(Constants.INAPP_POSITION_RIGHT);
                }
            }
            if ((getFlags() & 16777216) == 16777216) {
                sb.append(", object key");
            }
            if ((getFlags() & GroupFlagsKt.HasAuxSlotFlag) == 33554432) {
                sb.append(", aux");
            }
            if (isNode()) {
                sb.append(", node");
            }
            int[] groups = slotTable.getGroups();
            int i = this.address;
            if (groups[i + 3] != -1) {
                int[] groups2 = slotTable.getAddressSpace().getGroups();
                int i2 = 0;
                for (int i3 = groups2[i + 3]; i3 > 0; i3 = groups2[i3 + 1]) {
                    i2++;
                }
                sb.append(", ");
                sb.append(i2);
                sb.append(i2 == 1 ? " child" : " children");
            }
            if (slotTable.getGroups()[this.address + 5] != -1) {
                sb.append(", ");
                sb.append(getSlotRange().getSize());
                sb.append(" slots");
            }
            sb.append(')');
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: SlotTable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugSlotRange;", "", "range", "", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;I)V", "getRange", "()I", "address", "getAddress", "size", "getSize", "end", "getEnd", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DebugSlotRange {
        private final int range;

        public DebugSlotRange(int i) {
            this.range = i;
        }

        public final int getRange() {
            return this.range;
        }

        public final int getAddress() {
            return this.range >> 4;
        }

        public final int getSize() {
            SlotTableAddressSpace addressSpace = SlotTable.this.getAddressSpace();
            int i = this.range;
            if (i == -1) {
                return 0;
            }
            int i2 = (i & 15) + 1;
            return i2 > 15 ? addressSpace.getLargeSizes().get(i >> 4) : i2;
        }

        public final int getEnd() {
            return getAddress() + getSize();
        }
    }

    /* JADX INFO: compiled from: SlotTable.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0086\b¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/composer/linkbuffer/SlotTable$Companion;", "", "<init>", "()V", InAppPurchaseConstants.METHOD_BUILD, "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "", "Lkotlin/ExtensionFunctionType;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SlotTable build$default(Companion companion, SlotTableAddressSpace slotTableAddressSpace, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                slotTableAddressSpace = new SlotTableAddressSpace();
            }
            SlotTableBuilder slotTableBuilder = new SlotTableBuilder(slotTableAddressSpace, false, false);
            slotTableBuilder.buildStart();
            function1.invoke(slotTableBuilder);
            return slotTableBuilder.build();
        }

        public final SlotTable build(SlotTableAddressSpace addressSpace, Function1<? super SlotTableBuilder, Unit> block) {
            SlotTableBuilder slotTableBuilder = new SlotTableBuilder(addressSpace, false, false);
            slotTableBuilder.buildStart();
            block.invoke(slotTableBuilder);
            return slotTableBuilder.build();
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void clear(RememberManager rememberManager) {
        SlotTableEditor slotTableEditorOpenEditor = openEditor();
        try {
            SlotTableKt.removeCurrentGroup(slotTableEditorOpenEditor, rememberManager);
            Unit unit = Unit.INSTANCE;
        } finally {
            slotTableEditorOpenEditor.close();
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void deactivateAll(RememberManager rememberManager) {
        SlotTableEditor slotTableEditorOpenEditor = openEditor();
        try {
            SlotTableKt.deactivateCurrentGroup(slotTableEditorOpenEditor, rememberManager);
            Unit unit = Unit.INSTANCE;
        } finally {
            slotTableEditorOpenEditor.close();
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void disposeUnusedMovableContent(RememberManager rememberManager, MovableContentState state) {
        SlotTableEditor slotTableEditorOpenEditor = openEditor();
        try {
            SlotTableKt.removeCurrentGroup(slotTableEditorOpenEditor, rememberManager);
            Unit unit = Unit.INSTANCE;
        } finally {
            slotTableEditorOpenEditor.close();
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void invalidateAll() {
        if (getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot read while an editor is pending");
        }
        SlotTableAddressSpace addressSpace = getAddressSpace();
        int root = getRoot();
        if (root < 0) {
            return;
        }
        IntStack intStack = new IntStack();
        int[] groups = addressSpace.getGroups();
        while (true) {
            int i = getGroups()[root + 5];
            if (i != -1) {
                SlotTableAddressSpace addressSpace2 = getAddressSpace();
                int i2 = (i & 15) + 1;
                int i3 = i >> 4;
                if (i2 > 15) {
                    i2 = addressSpace2.getLargeSizes().get(i3);
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj = getSlots()[i3 + i4];
                    if (Intrinsics.areEqual(obj, Composer.INSTANCE.getEmpty())) {
                        break;
                    }
                    RecomposeScope recomposeScope = obj instanceof RecomposeScope ? (RecomposeScope) obj : null;
                    if (recomposeScope != null) {
                        recomposeScope.invalidate();
                    }
                }
            }
            int i5 = groups[root + 1];
            if (i5 >= 0) {
                intStack.push(i5);
            }
            root = groups[root + 3];
            if (root < 0) {
                if (intStack.tos == 0) {
                    return;
                } else {
                    root = intStack.pop();
                }
            }
        }
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int group) {
        int[] groups = getAddressSpace().getGroups();
        int i = group;
        while (true) {
            if (i <= 0) {
                if (i != 0) {
                    return null;
                }
                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + group);
                return null;
            }
            RecomposeScopeImpl recomposeScopeOrNull$runtime = getRecomposeScopeOrNull$runtime(i);
            if (recomposeScopeOrNull$runtime != null) {
                if (recomposeScopeOrNull$runtime.getUsed() && i != group) {
                    return recomposeScopeOrNull$runtime;
                }
                recomposeScopeOrNull$runtime.setForcedRecompose(true);
            }
            i = groups[i + 2];
        }
    }

    public final boolean isGroupAChildOf$runtime(int child, int parent) {
        int[] groups = getAddressSpace().getGroups();
        int i = child;
        while (true) {
            if (i <= 0) {
                if (!(i != 0)) {
                    ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + child);
                }
                return false;
            }
            if (i == parent) {
                return true;
            }
            i = groups[i + 2];
        }
    }
}
