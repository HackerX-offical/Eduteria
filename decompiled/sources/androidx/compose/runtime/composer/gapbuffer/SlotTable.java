package androidx.compose.runtime.composer.gapbuffer;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.GapComposerKt;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.collection.ExtensionsKt;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.clevertap.android.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.httpfileupload.element.Slot;
import org.jivesoftware.smackx.message_fastening.element.FasteningElement;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: SlotTable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010(\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J7\u0010@\u001a\u0002HA\"\u0004\b\u0000\u0010A2!\u0010B\u001a\u001d\u0012\u0013\u0012\u00110D¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0004\u0012\u0002HA0CH\u0086\b¢\u0006\u0002\u0010HJ7\u0010I\u001a\u0002HA\"\u0004\b\u0000\u0010A2!\u0010B\u001a\u001d\u0012\u0013\u0012\u00110J¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u0002HA0CH\u0086\b¢\u0006\u0002\u0010HJ\u0006\u0010K\u001a\u00020DJ\u0006\u0010L\u001a\u00020JJ\u000e\u0010M\u001a\u00020&2\u0006\u0010N\u001a\u00020\fJ\u0012\u0010O\u001a\u0004\u0018\u00010&2\u0006\u0010N\u001a\u00020\fH\u0002J\u000e\u0010P\u001a\u00020\f2\u0006\u0010M\u001a\u00020&J\u000e\u0010Q\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020&J\u0018\u0010R\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\f2\u0006\u0010M\u001a\u00020TH\u0016J\u0018\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020TH\u0016J=\u0010X\u001a\u00020=2\u0006\u0010G\u001a\u00020D2&\u0010,\u001a\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/H\u0000¢\u0006\u0002\bYJ\u008f\u0001\u0010X\u001a\u00020=2\u0006\u0010\u001d\u001a\u00020J2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0016\u001a\u00020\f2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'2&\u0010,\u001a\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0000¢\u0006\u0004\bY\u0010ZJ\u0087\u0001\u0010[\u001a\u00020=2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0016\u001a\u00020\f2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'2&\u0010,\u001a\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/2\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0000¢\u0006\u0004\b\\\u0010]J\u0018\u0010^\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010_2\u0006\u0010a\u001a\u00020\fH\u0016J\u0010\u0010b\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020`H\u0016J\u0006\u0010d\u001a\u00020\u001cJ\u0010\u0010e\u001a\u0004\u0018\u00010.2\u0006\u0010S\u001a\u00020\fJ\u0012\u0010f\u001a\u0004\u0018\u00010`2\u0006\u0010S\u001a\u00020\fH\u0002J\b\u0010g\u001a\u00020=H\u0016J\b\u0010h\u001a\u00020=H\u0002J\u0010\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0003H\u0016J\b\u0010i\u001a\u00020=H\u0016J\b\u0010j\u001a\u00020=H\u0016J\u0010\u0010k\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010l\u001a\u00020=H\u0016J.\u0010m\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020p0n2\n\u0010q\u001a\u0006\u0012\u0002\b\u00030r2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020o0tH\u0016J\u0018\u0010u\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010v\u001a\u00020pH\u0016J\b\u0010w\u001a\u00020=H\u0016J\b\u0010x\u001a\u00020yH\u0016J \u0010z\u001a\u00020\f*\u00060{j\u0002`|2\u0006\u0010N\u001a\u00020\f2\u0006\u0010}\u001a\u00020\fH\u0002J\u000e\u0010~\u001a\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000e\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000f\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000f\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000f\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u001f\u0010\u0083\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110_2\u0006\u0010S\u001a\u00020\fH\u0000¢\u0006\u0003\b\u0084\u0001J\"\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010S\u001a\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\b\u0087\u0001J\u0011\u0010\u008b\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u008c\u0001H\u0096\u0002J\u0014\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u008e\u0001\u001a\u00020\u0011H\u0016R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR0\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00060\u0011j\u0002`\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010#R*\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R:\u0010,\u001a\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u000105X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u001fR\u001d\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006\u008f\u0001"}, d2 = {"Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "Landroidx/compose/runtime/SlotStorage;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "<init>", "()V", "value", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "readers", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "", "writer", "getWriter$runtime", "()Z", "version", "getVersion$runtime", "setVersion$runtime", "(I)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime", "()Ljava/util/ArrayList;", "setAnchors$runtime", "(Ljava/util/ArrayList;)V", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;", "Lkotlin/collections/HashMap;", "getSourceInformationMap$runtime", "()Ljava/util/HashMap;", "setSourceInformationMap$runtime", "(Ljava/util/HashMap;)V", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "getCalledByMap$runtime", "()Landroidx/collection/MutableIntObjectMap;", "setCalledByMap$runtime", "(Landroidx/collection/MutableIntObjectMap;)V", "isEmpty", FasteningElement.ATTR_CLEAR, "", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "read", ExifInterface.GPS_DIRECTION_TRUE, BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "Lkotlin/ParameterName;", "name", "reader", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "write", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "openReader", "openWriter", ReferenceElement.ATTR_ANCHOR, FirebaseAnalytics.Param.INDEX, "tryAnchor", "anchorIndex", "ownsAnchor", "groupContainsAnchor", "group", "Landroidx/compose/runtime/Anchor;", "inGroup", Message.Thread.PARENT_ATTRIBUTE_NAME, "child", "close", "close$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "setTo", "setTo$runtime", "([II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "invalidateGroupsWithKey", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", TypedValues.AttributesType.S_TARGET, "ownsRecomposeScope", "scope", "containsMark", "sourceInformationOf", "findEffectiveRecomposeScope", "verifyWellFormed", "validateRecomposeScopeAnchors", "collectCalledByInformation", "collectSourceInformation", "deactivateAll", "dispose", "extractNestedStates", "Landroidx/collection/ScatterMap;", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "applier", "Landroidx/compose/runtime/Applier;", "references", "Landroidx/collection/ObjectList;", "disposeUnusedMovableContent", "state", "invalidateAll", "toDebugString", "", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", FirebaseAnalytics.Param.LEVEL, "keys", "nodes", "parentIndexes", "dataIndexes", "groupSizes", "slotsOf", "slotsOf$runtime", Slot.ELEMENT, "slotIndex", "slot$runtime", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "iterator", "", "find", "identityToFind", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlotTable extends SlotStorage implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    public static final int $stable = 8;
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private int groupsSize;
    private int readers;
    private int slotsSize;
    private HashMap<GapAnchor, GapGroupSourceInformation> sourceInformationMap;
    private int version;
    private boolean writer;
    private int[] groups = new int[0];
    private Object[] slots = new Object[0];
    private final Object lock = new Object();
    private ArrayList<GapAnchor> anchors = new ArrayList<>();

    @Override // androidx.compose.runtime.SlotStorage
    public void dispose() {
    }

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    /* JADX INFO: renamed from: getWriter$runtime, reason: from getter */
    public final boolean getWriter() {
        return this.writer;
    }

    /* JADX INFO: renamed from: getVersion$runtime, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final void setVersion$runtime(int i) {
        this.version = i;
    }

    public final ArrayList<GapAnchor> getAnchors$runtime() {
        return this.anchors;
    }

    public final void setAnchors$runtime(ArrayList<GapAnchor> arrayList) {
        this.anchors = arrayList;
    }

    public final HashMap<GapAnchor, GapGroupSourceInformation> getSourceInformationMap$runtime() {
        return this.sourceInformationMap;
    }

    public final void setSourceInformationMap$runtime(HashMap<GapAnchor, GapGroupSourceInformation> map) {
        this.sourceInformationMap = map;
    }

    public final MutableIntObjectMap<MutableIntSet> getCalledByMap$runtime() {
        return this.calledByMap;
    }

    public final void setCalledByMap$runtime(MutableIntObjectMap<MutableIntSet> mutableIntObjectMap) {
        this.calledByMap = mutableIntObjectMap;
    }

    @Override // androidx.compose.runtime.SlotStorage, androidx.compose.runtime.tooling.CompositionData
    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    public final <T> T read(Function1<? super SlotReader, ? extends T> block) {
        SlotReader slotReaderOpenReader = openReader();
        try {
            return block.invoke(slotReaderOpenReader);
        } finally {
            slotReaderOpenReader.close();
        }
    }

    public final <T> T write(Function1<? super SlotWriter, ? extends T> block) {
        SlotWriter slotWriterOpenWriter = openWriter();
        try {
            T tInvoke = block.invoke(slotWriterOpenWriter);
            slotWriterOpenWriter.close(true);
            return tInvoke;
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    public final SlotReader openReader() {
        if (this.writer) {
            throw new IllegalStateException("Cannot read while a writer is pending".toString());
        }
        this.readers++;
        return new SlotReader(this);
    }

    public final SlotWriter openWriter() {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }
        if (!(this.readers <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    }

    public final GapAnchor anchor(int index) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to create an anchor location instead");
        }
        boolean z = false;
        if (index >= 0 && index < this.groupsSize) {
            z = true;
        }
        if (!z) {
            PreconditionsKt.throwIllegalArgumentException("Parameter index is out of range");
        }
        ArrayList<GapAnchor> arrayList = this.anchors;
        int iSearch = SlotTableKt.search(arrayList, index, this.groupsSize);
        if (iSearch < 0) {
            GapAnchor gapAnchor = new GapAnchor(index);
            arrayList.add(-(iSearch + 1), gapAnchor);
            return gapAnchor;
        }
        return arrayList.get(iSearch);
    }

    private final GapAnchor tryAnchor(int index) {
        int i;
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to crate an anchor for location instead");
        }
        if (index < 0 || index >= (i = this.groupsSize)) {
            return null;
        }
        return SlotTableKt.find(this.anchors, index, i);
    }

    public final int anchorIndex(GapAnchor anchor) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Use active SlotWriter to determine anchor location instead");
        }
        if (!anchor.getValid()) {
            PreconditionsKt.throwIllegalArgumentException("Anchor refers to a group that was removed");
        }
        return anchor.getLocation();
    }

    public final boolean ownsAnchor(GapAnchor anchor) {
        int iSearch;
        return anchor.getValid() && (iSearch = SlotTableKt.search(this.anchors, anchor.getLocation(), this.groupsSize)) >= 0 && Intrinsics.areEqual(this.anchors.get(iSearch), anchor);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean groupContainsAnchor(int group, Anchor anchor) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Writer is active");
        }
        if (!(group >= 0 && group < this.groupsSize)) {
            ComposerKt.composeImmediateRuntimeError("Invalid group index");
        }
        GapAnchor gapAnchorAsGapAnchor = GapAnchorKt.asGapAnchor(anchor);
        if (ownsAnchor(gapAnchorAsGapAnchor)) {
            int iGroupSize = SlotTableKt.groupSize(this.groups, group) + group;
            int location = gapAnchorAsGapAnchor.getLocation();
            if (group <= location && location < iGroupSize) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean inGroup(Anchor parent, Anchor child) {
        int location = GapAnchorKt.asGapAnchor(parent).getLocation();
        int iGroupSize = SlotTableKt.groupSize(this.groups, location) + location;
        int location2 = GapAnchorKt.asGapAnchor(child).getLocation();
        return location <= location2 && location2 < iGroupSize;
    }

    public final void close$runtime(SlotReader reader, HashMap<GapAnchor, GapGroupSourceInformation> sourceInformationMap) {
        if (!(reader.getTable() == this && this.readers > 0)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected reader close()");
        }
        this.readers--;
        if (sourceInformationMap != null) {
            synchronized (this.lock) {
                HashMap<GapAnchor, GapGroupSourceInformation> map = this.sourceInformationMap;
                if (map != null) {
                    map.putAll(sourceInformationMap);
                } else {
                    this.sourceInformationMap = sourceInformationMap;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void close$runtime(SlotWriter writer, int[] groups, int groupsSize, Object[] slots, int slotsSize, ArrayList<GapAnchor> anchors, HashMap<GapAnchor, GapGroupSourceInformation> sourceInformationMap, MutableIntObjectMap<MutableIntSet> calledByMap) {
        if (!(writer.getTable() == this && this.writer)) {
            PreconditionsKt.throwIllegalArgumentException("Unexpected writer close()");
        }
        this.writer = false;
        setTo$runtime(groups, groupsSize, slots, slotsSize, anchors, sourceInformationMap, calledByMap);
    }

    public final void setTo$runtime(int[] groups, int groupsSize, Object[] slots, int slotsSize, ArrayList<GapAnchor> anchors, HashMap<GapAnchor, GapGroupSourceInformation> sourceInformationMap, MutableIntObjectMap<MutableIntSet> calledByMap) {
        this.groups = groups;
        this.groupsSize = groupsSize;
        this.slots = slots;
        this.slotsSize = slotsSize;
        this.anchors = anchors;
        this.sourceInformationMap = sourceInformationMap;
        this.calledByMap = calledByMap;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public List<RecomposeScopeImpl> invalidateGroupsWithKey(int target) {
        MutableIntSet mutableIntSet;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        MutableIntSet mutableIntSet2 = new MutableIntSet(0, 1, null);
        mutableIntSet2.add(target);
        mutableIntSet2.add(-3);
        MutableIntObjectMap<MutableIntSet> mutableIntObjectMap = this.calledByMap;
        if (mutableIntObjectMap != null && (mutableIntSet = mutableIntObjectMap.get(target)) != null) {
            mutableIntSet2.addAll(mutableIntSet);
        }
        SlotReader slotReaderOpenReader = openReader();
        try {
            invalidateGroupsWithKey$lambda$2$scanGroup(slotReaderOpenReader, mutableIntSet2, arrayList, booleanRef, this, arrayList2);
            Unit unit = Unit.INSTANCE;
            slotReaderOpenReader.close();
            SlotWriter slotWriterOpenWriter = openWriter();
            try {
                slotWriterOpenWriter.startGroup();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    GapAnchor gapAnchor = (GapAnchor) arrayList.get(i);
                    if (gapAnchor.toIndexFor(slotWriterOpenWriter) >= slotWriterOpenWriter.getCurrentGroup()) {
                        slotWriterOpenWriter.seek(gapAnchor);
                        slotWriterOpenWriter.bashCurrentGroup();
                    }
                }
                slotWriterOpenWriter.skipToGroupEnd();
                slotWriterOpenWriter.endGroup();
                slotWriterOpenWriter.close(true);
                if (booleanRef.element) {
                    return arrayList2;
                }
                return null;
            } catch (Throwable th) {
                slotWriterOpenWriter.close(false);
                throw th;
            }
        } catch (Throwable th2) {
            slotReaderOpenReader.close();
            throw th2;
        }
    }

    private static final void invalidateGroupsWithKey$lambda$2$scanGroup(SlotReader slotReader, MutableIntSet mutableIntSet, List<GapAnchor> list, Ref.BooleanRef booleanRef, SlotTable slotTable, List<RecomposeScopeImpl> list2) {
        GapAnchor gapAnchorAsGapAnchor;
        RecomposeScopeImpl recomposeScopeImplFindEffectiveRecomposeScope;
        int groupKey = slotReader.getGroupKey();
        if (mutableIntSet.contains(groupKey)) {
            if (groupKey != -3) {
                list.add(SlotReader.anchor$default(slotReader, 0, 1, null));
            }
            if (booleanRef.element) {
                RecomposeScopeImpl recomposeScopeImplFindEffectiveRecomposeScope2 = slotTable.findEffectiveRecomposeScope(slotReader.getCurrentGroup());
                if (recomposeScopeImplFindEffectiveRecomposeScope2 != null) {
                    list2.add(recomposeScopeImplFindEffectiveRecomposeScope2);
                    Anchor anchor = recomposeScopeImplFindEffectiveRecomposeScope2.getAnchor();
                    if (anchor != null && (gapAnchorAsGapAnchor = GapAnchorKt.asGapAnchor(anchor)) != null && gapAnchorAsGapAnchor.getLocation() == slotReader.getCurrentGroup() && (recomposeScopeImplFindEffectiveRecomposeScope = slotTable.findEffectiveRecomposeScope(slotReader.getParent())) != null) {
                        list2.add(recomposeScopeImplFindEffectiveRecomposeScope);
                    }
                } else {
                    booleanRef.element = false;
                    list2.clear();
                }
            }
            slotReader.skipGroup();
            return;
        }
        slotReader.startGroup();
        while (!slotReader.isGroupEnd()) {
            invalidateGroupsWithKey$lambda$2$scanGroup(slotReader, mutableIntSet, list, booleanRef, slotTable, list2);
        }
        slotReader.endGroup();
    }

    @Override // androidx.compose.runtime.SlotStorage
    public boolean ownsRecomposeScope(RecomposeScopeImpl scope) {
        Anchor anchor = scope.getAnchor();
        return anchor != null && ownsAnchor(GapAnchorKt.asGapAnchor(anchor));
    }

    public final boolean containsMark() {
        return this.groupsSize > 0 && (this.groups[1] & 67108864) != 0;
    }

    public final GapGroupSourceInformation sourceInformationOf(int group) {
        GapAnchor gapAnchorTryAnchor;
        HashMap<GapAnchor, GapGroupSourceInformation> map = this.sourceInformationMap;
        if (map == null || (gapAnchorTryAnchor = tryAnchor(group)) == null) {
            return null;
        }
        return map.get(gapAnchorTryAnchor);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int group) {
        int i = group;
        while (i > 0) {
            for (Object obj : new DataIterator(this, i)) {
                if (obj instanceof RecomposeScopeImpl) {
                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
                    if (recomposeScopeImpl.getUsed() && i != group) {
                        return recomposeScopeImpl;
                    }
                    recomposeScopeImpl.setForcedRecompose(true);
                }
            }
            i = this.groups[(i * 5) + 2];
        }
        return null;
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void verifyWellFormed() {
        Ref.IntRef intRef = new Ref.IntRef();
        int i = -1;
        if (this.groupsSize > 0) {
            while (intRef.element < this.groupsSize) {
                verifyWellFormed$validateGroup(intRef, this, -1, intRef.element + SlotTableKt.groupSize(this.groups, intRef.element));
            }
            if (!(intRef.element == this.groupsSize)) {
                PreconditionsKt.throwIllegalStateException("Incomplete group at root " + intRef.element + " expected to be " + this.groupsSize);
            }
        }
        int length = this.slots.length;
        for (int i2 = this.slotsSize; i2 < length; i2++) {
            if (!(this.slots[i2] == null)) {
                PreconditionsKt.throwIllegalStateException("Non null value in the slot gap at index " + i2);
            }
        }
        ArrayList<GapAnchor> arrayList = this.anchors;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            int indexFor = arrayList.get(i3).toIndexFor(this);
            if (!(indexFor >= 0 && indexFor <= this.groupsSize)) {
                PreconditionsKt.throwIllegalArgumentException("Invalid anchor, location out of bound");
            }
            if (!(i < indexFor)) {
                PreconditionsKt.throwIllegalArgumentException("Anchor is out of order");
            }
            i3++;
            i = indexFor;
        }
        HashMap<GapAnchor, GapGroupSourceInformation> map = this.sourceInformationMap;
        if (map != null) {
            for (Map.Entry<GapAnchor, GapGroupSourceInformation> entry : map.entrySet()) {
                GapAnchor key = entry.getKey();
                GapGroupSourceInformation value = entry.getValue();
                if (!key.getValid()) {
                    PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
                }
                if (!ownsAnchor(key)) {
                    PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                }
                verifyWellFormed$verifySourceGroup(this, value);
            }
        }
        validateRecomposeScopeAnchors();
    }

    private static final int verifyWellFormed$validateGroup(Ref.IntRef intRef, SlotTable slotTable, int i, int i2) {
        int i3 = intRef.element;
        int i4 = i3 + 1;
        intRef.element = i4;
        int i5 = i3 * 5;
        int i6 = slotTable.groups[i5 + 2];
        if (!(i6 == i)) {
            PreconditionsKt.throwIllegalStateException("Invalid parent index detected at " + i3 + ", expected parent index to be " + i + " found " + i6);
        }
        int iGroupSize = SlotTableKt.groupSize(slotTable.groups, i3) + i3;
        if (!(iGroupSize <= slotTable.groupsSize)) {
            PreconditionsKt.throwIllegalStateException("A group extends past the end of the table at " + i3);
        }
        if (!(iGroupSize <= i2)) {
            PreconditionsKt.throwIllegalStateException("A group extends past its parent group at " + i3);
        }
        int[] iArr = slotTable.groups;
        int i7 = i5 + 4;
        int i8 = iArr[i7];
        int i9 = i3 >= slotTable.groupsSize - 1 ? slotTable.slotsSize : iArr[(i4 * 5) + 4];
        if (!(i9 <= slotTable.slots.length)) {
            PreconditionsKt.throwIllegalStateException("Slots for " + i3 + " extend past the end of the slot table");
        }
        if (!(i8 <= i9)) {
            PreconditionsKt.throwIllegalStateException("Invalid data anchor at " + i3);
        }
        if (!(SlotTableKt.slotAnchor(slotTable.groups, i3) <= i9)) {
            PreconditionsKt.throwIllegalStateException("Slots start out of range at " + i3);
        }
        int i10 = i5 + 1;
        int i11 = slotTable.groups[i10];
        if (!(i9 - i8 >= (((i11 & 1073741824) != 0 ? 1 : 0) + ((536870912 & i11) != 0 ? 1 : 0)) + ((i11 & 268435456) != 0 ? 1 : 0))) {
            PreconditionsKt.throwIllegalStateException("Not enough slots added for group " + i3);
        }
        int[] iArr2 = slotTable.groups;
        boolean z = (iArr2[i10] & 1073741824) != 0;
        if (!((z && slotTable.slots[iArr2[i7]] == null) ? false : true)) {
            PreconditionsKt.throwIllegalStateException("No node recorded for a node group at " + i3);
        }
        int iVerifyWellFormed$validateGroup = 0;
        while (intRef.element < iGroupSize) {
            iVerifyWellFormed$validateGroup += verifyWellFormed$validateGroup(intRef, slotTable, i3, iGroupSize);
        }
        int[] iArr3 = slotTable.groups;
        int i12 = iArr3[i10] & 67108863;
        int iGroupSize2 = SlotTableKt.groupSize(iArr3, i3);
        if (!(i12 == iVerifyWellFormed$validateGroup)) {
            PreconditionsKt.throwIllegalStateException("Incorrect node count detected at " + i3 + ", expected " + i12 + ", received " + iVerifyWellFormed$validateGroup);
        }
        int i13 = intRef.element - i3;
        if (!(iGroupSize2 == i13)) {
            PreconditionsKt.throwIllegalStateException("Incorrect slot count detected at " + i3 + ", expected " + iGroupSize2 + ", received " + i13);
        }
        int[] iArr4 = slotTable.groups;
        if ((iArr4[i10] & 201326592) != 0) {
            if (!(i3 <= 0 || (iArr4[(i * 5) + 1] & 67108864) != 0)) {
                PreconditionsKt.throwIllegalStateException("Expected group " + i + " to record it contains a mark because " + i3 + " does");
            }
        }
        if (z) {
            return 1;
        }
        return iVerifyWellFormed$validateGroup;
    }

    private static final void verifyWellFormed$verifySourceGroup(SlotTable slotTable, GapGroupSourceInformation gapGroupSourceInformation) {
        ArrayList<Object> groups = gapGroupSourceInformation.getGroups();
        if (groups != null) {
            ArrayList<Object> arrayList = groups;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof GapAnchor) {
                    GapAnchor gapAnchor = (GapAnchor) obj;
                    if (!gapAnchor.getValid()) {
                        PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
                    }
                    if (!slotTable.ownsAnchor(gapAnchor)) {
                        PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                    }
                } else if (obj instanceof GapGroupSourceInformation) {
                    verifyWellFormed$verifySourceGroup(slotTable, (GapGroupSourceInformation) obj);
                }
            }
        }
    }

    private final void validateRecomposeScopeAnchors() {
        GapAnchor gapAnchorAsGapAnchor;
        Object[] objArr = this.slots;
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList2.get(i);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && (gapAnchorAsGapAnchor = GapAnchorKt.asGapAnchor(anchor)) != null && !slotsOf$runtime(gapAnchorAsGapAnchor.toIndexFor(this)).contains(recomposeScopeImpl2)) {
                PreconditionsKt.throwIllegalStateException("Misaligned anchor " + gapAnchorAsGapAnchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt.indexOf((RecomposeScopeImpl[]) this.slots, recomposeScopeImpl2));
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.composer.gapbuffer.SlotTable$getSlots$1, reason: invalid class name */
    /* JADX INFO: compiled from: SlotTable.kt */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0011\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H\u0096\u0002¨\u0006\u0005"}, d2 = {"androidx/compose/runtime/composer/gapbuffer/SlotTable$getSlots$1", "", "", "iterator", "", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterable<Object>, KMappedMarker {
        AnonymousClass1() {
        }

        @Override // java.lang.Iterable
        public Iterator<Object> iterator() {
            return SequencesKt.iterator(new SlotTable$getSlots$1$iterator$1(SlotTable.this, null));
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    /* JADX INFO: renamed from: getSlots */
    public Iterable<Object> mo5220getSlots() {
        return new AnonymousClass1();
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void collectCalledByInformation() {
        this.calledByMap = new MutableIntObjectMap<>(0, 1, null);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void collectSourceInformation() {
        this.sourceInformationMap = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer extractNestedStates$lambda$1(SlotTable slotTable, MovableContentStateReference movableContentStateReference) {
        return Integer.valueOf(slotTable.anchorIndex(GapAnchorKt.asGapAnchor(movableContentStateReference.getAnchor())));
    }

    private static final void extractNestedStates$lambda$2$closeToGroupContaining(SlotWriter slotWriter, int i) {
        while (slotWriter.getParent() >= 0 && slotWriter.getCurrentGroupEnd() <= i) {
            slotWriter.skipToGroupEnd();
            slotWriter.endGroup();
        }
    }

    private static final void extractNestedStates$lambda$2$openParent(SlotWriter slotWriter, int i) {
        extractNestedStates$lambda$2$closeToGroupContaining(slotWriter, i);
        while (slotWriter.getCurrentGroup() != i && !slotWriter.isGroupEnd()) {
            if (i < SlotTableKt.getNextGroup(slotWriter)) {
                slotWriter.startGroup();
            } else {
                slotWriter.skipGroup();
            }
        }
        if (!(slotWriter.getCurrentGroup() == i)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected slot table structure");
        }
        slotWriter.startGroup();
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void invalidateAll() {
        for (Object obj : this.slots) {
            RecomposeScope recomposeScope = obj instanceof RecomposeScope ? (RecomposeScope) obj : null;
            if (recomposeScope != null) {
                recomposeScope.invalidate();
            }
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public String toDebugString() {
        if (this.writer) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append('\n');
        int i = this.groupsSize;
        if (i > 0) {
            int iEmitGroup = 0;
            while (iEmitGroup < i) {
                iEmitGroup += emitGroup(sb, iEmitGroup, 0);
            }
        } else {
            sb.append("<EMPTY>");
        }
        return sb.toString();
    }

    private final int emitGroup(StringBuilder sb, int i, int i2) {
        String sourceInformation;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(' ');
        }
        sb.append("Group(");
        sb.append(i);
        sb.append(")");
        GapGroupSourceInformation gapGroupSourceInformationSourceInformationOf = sourceInformationOf(i);
        if (gapGroupSourceInformationSourceInformationOf != null && (sourceInformation = gapGroupSourceInformationSourceInformationOf.getSourceInformation()) != null && (StringsKt.startsWith$default(sourceInformation, "C(", false, 2, (Object) null) || StringsKt.startsWith$default(sourceInformation, "CC(", false, 2, (Object) null))) {
            String str = sourceInformation;
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, "(", 0, false, 6, (Object) null) + 1;
            int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str, ')', 0, false, 6, (Object) null);
            sb.append(" ");
            String strSubstring = sourceInformation.substring(iIndexOf$default, iIndexOf$default2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            sb.append(strSubstring);
            sb.append("()");
        }
        sb.append(" key=");
        int i4 = i * 5;
        sb.append(this.groups[i4]);
        int iGroupSize = SlotTableKt.groupSize(this.groups, i);
        sb.append(", nodes=");
        int i5 = i4 + 1;
        sb.append(this.groups[i5] & 67108863);
        sb.append(", size=");
        sb.append(iGroupSize);
        if ((this.groups[i5] & 134217728) != 0) {
            sb.append(", mark");
        }
        if ((this.groups[i5] & 67108864) != 0) {
            sb.append(", contains mark");
        }
        int iEmitGroup$dataIndex = emitGroup$dataIndex(this, i);
        int iEmitGroup = i + 1;
        int iEmitGroup$dataIndex2 = emitGroup$dataIndex(this, iEmitGroup);
        if (iEmitGroup$dataIndex < 0 || iEmitGroup$dataIndex > iEmitGroup$dataIndex2 || iEmitGroup$dataIndex2 > this.slotsSize) {
            sb.append(", *invalid data offsets " + iEmitGroup$dataIndex + '-' + iEmitGroup$dataIndex2 + '*');
        } else {
            if ((this.groups[i5] & 536870912) != 0) {
                sb.append(" objectKey=" + SlotTableKt.summarize(String.valueOf(this.slots[SlotTableKt.objectKeyIndex(this.groups, i)]), 10));
            }
            if ((this.groups[i5] & 1073741824) != 0) {
                sb.append(" node=" + SlotTableKt.summarize(String.valueOf(this.slots[this.groups[i4 + 4]]), 10));
            }
            if ((this.groups[i5] & 268435456) != 0) {
                sb.append(" aux=" + SlotTableKt.summarize(String.valueOf(this.slots[SlotTableKt.auxIndex(this.groups, i)]), 10));
            }
            int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, i);
            if (iSlotAnchor < iEmitGroup$dataIndex2) {
                sb.append(", slots=[");
                sb.append(iSlotAnchor);
                sb.append(": ");
                for (int i6 = iSlotAnchor; i6 < iEmitGroup$dataIndex2; i6++) {
                    if (i6 != iSlotAnchor) {
                        sb.append(", ");
                    }
                    sb.append(SlotTableKt.summarize(String.valueOf(this.slots[i6]), 10));
                }
                sb.append(Constants.AES_SUFFIX);
            }
        }
        sb.append('\n');
        int i7 = i + iGroupSize;
        while (iEmitGroup < i7) {
            iEmitGroup += emitGroup(sb, iEmitGroup, i2 + 1);
        }
        return iGroupSize;
    }

    private static final int emitGroup$dataIndex(SlotTable slotTable, int i) {
        return i >= slotTable.groupsSize ? slotTable.slotsSize : slotTable.groups[(i * 5) + 4];
    }

    private final List<Integer> keys() {
        return SlotTableKt.keys(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> nodes() {
        return SlotTableKt.nodeCounts(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> parentIndexes() {
        return SlotTableKt.parentAnchors(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> dataIndexes() {
        return SlotTableKt.dataAnchors(this.groups, this.groupsSize * 5);
    }

    private final List<Integer> groupSizes() {
        return SlotTableKt.groupSizes(this.groups, this.groupsSize * 5);
    }

    public final List<Object> slotsOf$runtime(int group) {
        int length;
        int[] iArr = this.groups;
        int i = iArr[(group * 5) + 4];
        int i2 = group + 1;
        if (i2 >= this.groupsSize) {
            length = this.slots.length;
        } else {
            length = iArr[(i2 * 5) + 4];
        }
        return ArraysKt.toList(this.slots).subList(i, length);
    }

    public final Object slot$runtime(int group, int slotIndex) {
        int length;
        int iSlotAnchor = SlotTableKt.slotAnchor(this.groups, group);
        int i = group + 1;
        if (i >= this.groupsSize) {
            length = this.slots.length;
        } else {
            length = this.groups[(i * 5) + 4];
        }
        return (slotIndex < 0 || slotIndex >= length - iSlotAnchor) ? Composer.INSTANCE.getEmpty() : this.slots[iSlotAnchor + slotIndex];
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Iterable<CompositionGroup> getCompositionGroups() {
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public CompositionGroup find(Object identityToFind) {
        return new SlotTableGroup(this, 0, 0, 4, null).find(identityToFind);
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void clear(RememberManager rememberManager) {
        SlotWriter slotWriterOpenWriter = openWriter();
        try {
            ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberManager);
            Unit unit = Unit.INSTANCE;
            slotWriterOpenWriter.close(true);
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void deactivateAll(RememberManager rememberManager) {
        SlotWriter slotWriterOpenWriter = openWriter();
        try {
            GapComposerKt.deactivateCurrentGroup(slotWriterOpenWriter, rememberManager);
            Unit unit = Unit.INSTANCE;
            slotWriterOpenWriter.close(true);
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public ScatterMap<MovableContentStateReference, MovableContentState> extractNestedStates(Applier<?> applier, ObjectList<MovableContentStateReference> references) {
        Object[] objArr = references.content;
        int i = references._size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            if (ownsAnchor(GapAnchorKt.asGapAnchor(((MovableContentStateReference) objArr[i2]).getAnchor()))) {
                i2++;
            } else {
                MutableObjectList mutableObjectList = new MutableObjectList(0, 1, null);
                Object[] objArr2 = references.content;
                int i3 = references._size;
                for (int i4 = 0; i4 < i3; i4++) {
                    Object obj = objArr2[i4];
                    if (ownsAnchor(GapAnchorKt.asGapAnchor(((MovableContentStateReference) obj).getAnchor()))) {
                        mutableObjectList.add(obj);
                    }
                }
                references = mutableObjectList;
            }
        }
        ObjectList objectListSortedBy = ExtensionsKt.sortedBy(references, new Function1() { // from class: androidx.compose.runtime.composer.gapbuffer.SlotTable$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return SlotTable.extractNestedStates$lambda$1(this.f$0, (MovableContentStateReference) obj2);
            }
        });
        if (objectListSortedBy.isEmpty()) {
            return ScatterMapKt.emptyScatterMap();
        }
        MutableScatterMap mutableScatterMapMutableScatterMapOf = ScatterMapKt.mutableScatterMapOf();
        SlotWriter slotWriterOpenWriter = openWriter();
        try {
            Object[] objArr3 = objectListSortedBy.content;
            int i5 = objectListSortedBy._size;
            for (int i6 = 0; i6 < i5; i6++) {
                MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr3[i6];
                int iAnchorIndex = slotWriterOpenWriter.anchorIndex(GapAnchorKt.asGapAnchor(movableContentStateReference.getAnchor()));
                int iParent = slotWriterOpenWriter.parent(iAnchorIndex);
                extractNestedStates$lambda$2$closeToGroupContaining(slotWriterOpenWriter, iParent);
                extractNestedStates$lambda$2$openParent(slotWriterOpenWriter, iParent);
                slotWriterOpenWriter.advanceBy(iAnchorIndex - slotWriterOpenWriter.getCurrentGroup());
                mutableScatterMapMutableScatterMapOf.set(movableContentStateReference, ComposerKt.extractMovableContentAtCurrent(movableContentStateReference.getComposition(), movableContentStateReference, slotWriterOpenWriter, applier));
            }
            extractNestedStates$lambda$2$closeToGroupContaining(slotWriterOpenWriter, Integer.MAX_VALUE);
            Unit unit = Unit.INSTANCE;
            slotWriterOpenWriter.close(true);
            return mutableScatterMapMutableScatterMapOf;
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.SlotStorage
    public void disposeUnusedMovableContent(RememberManager rememberManager, MovableContentState state) {
        SlotWriter slotWriterOpenWriter = openWriter();
        try {
            ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberManager);
            Unit unit = Unit.INSTANCE;
            slotWriterOpenWriter.close(true);
        } catch (Throwable th) {
            slotWriterOpenWriter.close(false);
            throw th;
        }
    }
}
