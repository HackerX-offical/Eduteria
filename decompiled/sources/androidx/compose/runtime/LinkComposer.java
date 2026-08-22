package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.GroupKind;
import androidx.compose.runtime.composer.ThrowingRememberManagerStub;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsSpec;
import androidx.compose.runtime.composer.linkbuffer.GroupHandleKt;
import androidx.compose.runtime.composer.linkbuffer.KeyInfo;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchor;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchorKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableBuilder;
import androidx.compose.runtime.composer.linkbuffer.SlotTableBuilderKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTableReader;
import androidx.compose.runtime.composer.linkbuffer.SlotTableReaderKt;
import androidx.compose.runtime.composer.linkbuffer.changelist.ChangeList;
import androidx.compose.runtime.composer.linkbuffer.changelist.ChangeListKt;
import androidx.compose.runtime.composer.linkbuffer.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.composer.linkbuffer.changelist.ComposerChangeListWriterAddressMode;
import androidx.compose.runtime.composer.linkbuffer.changelist.FixupList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionErrorContext;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.runtime.tooling.ObjectLocation;
import androidx.exifinterface.media.ExifInterface;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: LinkComposer.kt */
/* JADX INFO: loaded from: classes.dex */
@ComposeCompilerApi
@Metadata(d1 = {"\u0000³\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\r\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001V\b\u0001\u0018\u00002\u00020\u0001:\u0004ó\u0002ô\u0002BQ\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010m\u001a\u00020nH\u0016J\b\u0010o\u001a\u00020nH\u0016J\b\u0010p\u001a\u00020nH\u0016J\r\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\b|J\u001e\u0010\u007f\u001a\u00020n2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u00020n0\u0081\u0001H\u0010¢\u0006\u0003\b\u0082\u0001J\u0013\u0010\u008a\u0001\u001a\u00020n2\b\u0010\u008b\u0001\u001a\u00030\u0084\u0001H\u0016JJ\u0010\u008e\u0001\u001a\u00020n\"\u0005\b\u0000\u0010\u008f\u0001\"\u0005\b\u0001\u0010\u0090\u00012\u0007\u0010Y\u001a\u0003H\u008f\u00012\"\u0010\u0080\u0001\u001a\u001d\u0012\u0005\u0012\u0003H\u0090\u0001\u0012\u0005\u0012\u0003H\u008f\u0001\u0012\u0004\u0012\u00020n0\u0091\u0001¢\u0006\u0003\b\u0092\u0001H\u0016¢\u0006\u0003\u0010\u0093\u0001J\t\u0010\u0099\u0001\u001a\u00020\u0005H\u0017J\u0013\u0010\u009a\u0001\u001a\u00020,2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0016J\u0013\u0010\u009b\u0001\u001a\u00020,2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u009a\u0001\u001a\u00020,2\u0007\u0010Y\u001a\u00030\u009c\u0001H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020,2\u0007\u0010Y\u001a\u00030\u009d\u0001H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020,2\u0007\u0010Y\u001a\u00030\u009e\u0001H\u0016J\u0011\u0010\u009a\u0001\u001a\u00020,2\u0006\u0010Y\u001a\u00020,H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020,2\u0007\u0010Y\u001a\u00030\u009f\u0001H\u0016J\u0011\u0010\u009a\u0001\u001a\u00020,2\u0006\u0010Y\u001a\u00020cH\u0016J\u0012\u0010\u009a\u0001\u001a\u00020,2\u0007\u0010Y\u001a\u00030 \u0001H\u0016J\u0011\u0010\u009a\u0001\u001a\u00020,2\u0006\u0010Y\u001a\u00020#H\u0016J\t\u0010¡\u0001\u001a\u00020nH\u0016JH\u0010¢\u0001\u001a\u00020n2\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0014\u0010¤\u0001\u001a\u000f\u0012\u0004\u0012\u00020n0\u0081\u0001¢\u0006\u0003\b¥\u00012\t\u0010¦\u0001\u001a\u0004\u0018\u00010wH\u0011¢\u0006\u0006\b§\u0001\u0010¨\u0001J(\u0010¬\u0001\u001a\u0003H\u0090\u0001\"\u0005\b\u0000\u0010\u0090\u00012\u000f\u0010\u00ad\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0090\u00010®\u0001H\u0017¢\u0006\u0003\u0010¯\u0001J!\u0010°\u0001\u001a\u00020n\"\u0005\b\u0000\u0010\u0090\u00012\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0090\u00010\u0081\u0001H\u0016J\u000f\u0010º\u0001\u001a\u00020nH\u0010¢\u0006\u0003\b»\u0001J\u0012\u0010¼\u0001\u001a\u00020n2\u0007\u0010\u009a\u0001\u001a\u00020,H\u0016J\u000f\u0010½\u0001\u001a\u00020nH\u0010¢\u0006\u0003\b¾\u0001J\t\u0010¿\u0001\u001a\u00020nH\u0016J\t\u0010À\u0001\u001a\u00020nH\u0016J\t\u0010Á\u0001\u001a\u00020nH\u0017J\t\u0010Â\u0001\u001a\u00020nH\u0017J\t\u0010Ã\u0001\u001a\u00020nH\u0016J\f\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001H\u0016J\t\u0010Æ\u0001\u001a\u00020nH\u0017J\t\u0010Ç\u0001\u001a\u00020nH\u0016J\u000f\u0010È\u0001\u001a\u00020nH\u0010¢\u0006\u0003\bÉ\u0001J\t\u0010Ê\u0001\u001a\u00020nH\u0016J\u0017\u0010Ë\u0001\u001a\u00020n2\f\u0010Ì\u0001\u001a\u00070#j\u0003`·\u0001H\u0016J!\u0010Ï\u0001\u001a\u00020n2\u000b\u0010Y\u001a\u0007\u0012\u0002\b\u00030Ð\u00012\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u001bH\u0017J*\u0010Ò\u0001\u001a\u00020n2\u001f\u0010Ó\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030Ö\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010Õ\u00010Ô\u0001H\u0017J\u001f\u0010×\u0001\u001a\u00020\u001b2\t\u0010Ø\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010Ù\u0001\u001a\u0004\u0018\u00010\u001bH\u0016J\u000f\u0010Ú\u0001\u001a\u00020#H\u0011¢\u0006\u0003\bÛ\u0001J\u0017\u0010Ü\u0001\u001a\n\u0012\u0005\u0012\u00030Ý\u00010Ô\u0001H\u0010¢\u0006\u0003\bÞ\u0001J2\u0010ß\u0001\u001a\u00020,2\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\t\u0010¦\u0001\u001a\u0004\u0018\u00010wH\u0011¢\u0006\u0006\bà\u0001\u0010á\u0001J\u0019\u0010â\u0001\u001a\u00020n2\u000e\u0010ã\u0001\u001a\t\u0012\u0004\u0012\u00020n0\u0081\u0001H\u0017J\u000b\u0010ä\u0001\u001a\u0004\u0018\u00010\u001bH\u0016J\u001b\u0010å\u0001\u001a\u00020,2\u0007\u0010æ\u0001\u001a\u00020,2\u0007\u0010ç\u0001\u001a\u00020#H\u0017J\t\u0010è\u0001\u001a\u00020nH\u0017J\t\u0010é\u0001\u001a\u00020nH\u0017J\u001a\u0010ê\u0001\u001a\u00030ë\u00012\u000e\u0010ì\u0001\u001a\t\u0012\u0004\u0012\u00020n0\u0081\u0001H\u0016J\u0013\u0010í\u0001\u001a\u00020n2\b\u0010í\u0001\u001a\u00030î\u0001H\u0016J\t\u0010ï\u0001\u001a\u00020nH\u0016J\u001c\u0010ð\u0001\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#2\b\u0010í\u0001\u001a\u00030î\u0001H\u0016J\u000f\u0010ñ\u0001\u001a\u00020#H\u0010¢\u0006\u0003\bò\u0001J\u001a\u0010ó\u0001\u001a\u00030ô\u00012\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0010¢\u0006\u0003\bõ\u0001J\t\u0010ö\u0001\u001a\u00020nH\u0016J\t\u0010÷\u0001\u001a\u00020nH\u0016J\u0016\u0010ø\u0001\u001a\u00020n2\u000b\u0010Y\u001a\u0007\u0012\u0002\b\u00030ù\u0001H\u0017J&\u0010ú\u0001\u001a\u00020n2\u0015\u0010û\u0001\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030ù\u00010ü\u0001H\u0017¢\u0006\u0003\u0010ý\u0001J\u0012\u0010þ\u0001\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#H\u0016J\u0012\u0010ÿ\u0001\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#H\u0016J\u0013\u0010\u0080\u0002\u001a\u00030\u0081\u00022\u0007\u0010\u00ad\u0001\u001a\u00020#H\u0016J\u001d\u0010\u0082\u0002\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u0084\u0002\u001a\u00020nH\u0016J\u000f\u0010\u0085\u0002\u001a\u00020nH\u0010¢\u0006\u0003\b\u0086\u0002J\u001d\u0010\u0087\u0002\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001bH\u0016J#\u0010\u0088\u0002\u001a\u00020,2\u0007\u0010\u008b\u0001\u001a\u00020\u001a2\t\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u001bH\u0010¢\u0006\u0003\b\u008a\u0002J'\u0010\u008b\u0002\u001a\u00020n2\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019H\u0010¢\u0006\u0006\b\u008c\u0002\u0010\u008d\u0002J\u0013\u0010\u008e\u0002\u001a\u00020n2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u008f\u0002\u001a\u00020nH\u0016J\u000f\u0010\u0090\u0002\u001a\u00020nH\u0010¢\u0006\u0003\b\u0091\u0002J\u0011\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0003\b\u0093\u0002J\u0011\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0003\b\u0095\u0002J\u0013\u0010\u0096\u0002\u001a\u00020n2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0001J\t\u0010\u0097\u0002\u001a\u00020nH\u0002J\t\u0010\u0098\u0002\u001a\u00020nH\u0002J\t\u0010\u0099\u0002\u001a\u00020nH\u0002J\t\u0010\u009a\u0002\u001a\u00020nH\u0002J\f\u0010\u009b\u0002\u001a\u0005\u0018\u00010ô\u0001H\u0002J?\u0010\u009c\u0002\u001a\u00020n2\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0016\u0010¤\u0001\u001a\u0011\u0012\u0004\u0012\u00020n\u0018\u00010\u0081\u0001¢\u0006\u0003\b¥\u0001H\u0003¢\u0006\u0006\b\u009d\u0002\u0010\u009e\u0002J\u0012\u0010\u009f\u0002\u001a\u00020n2\u0007\u0010 \u0002\u001a\u00020,H\u0002J\t\u0010¡\u0002\u001a\u00020nH\u0002J\t\u0010¢\u0002\u001a\u00020nH\u0002J\u000f\u0010£\u0002\u001a\u00020nH\u0010¢\u0006\u0003\b¤\u0002J\u001d\u0010¥\u0002\u001a\u00020n2\u0007\u0010 \u0002\u001a\u00020,2\t\u0010¦\u0002\u001a\u0004\u0018\u00010\u001fH\u0002J\t\u0010§\u0002\u001a\u00020nH\u0002J\u001a\u0010¨\u0002\u001a\u00020n2\u0007\u0010©\u0002\u001a\u00020#2\u0006\u0010}\u001a\u00020,H\u0002J\t\u0010ª\u0002\u001a\u00020nH\u0002J\t\u0010«\u0002\u001a\u00020nH\u0002J\t\u0010¬\u0002\u001a\u000201H\u0002J\u0017\u0010¬\u0002\u001a\u0002012\f\u0010\u00ad\u0002\u001a\u00070#j\u0003`·\u0001H\u0002J*\u0010®\u0002\u001a\u00020n2\u001f\u0010Ó\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030Ö\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010Õ\u00010Ô\u0001H\u0003Jt\u0010¯\u0002\u001a\u0003H°\u0002\"\u0005\b\u0000\u0010°\u00022\f\b\u0002\u0010±\u0002\u001a\u0005\u0018\u00010²\u00022\f\b\u0002\u0010³\u0002\u001a\u0005\u0018\u00010²\u00022\u000e\b\u0002\u0010´\u0002\u001a\u00070#j\u0003`·\u00012\u001e\b\u0002\u0010\u0018\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0Õ\u00010Ô\u00012\u000f\u0010\u0080\u0001\u001a\n\u0012\u0005\u0012\u0003H°\u00020\u0081\u0001H\u0002¢\u0006\u0003\u0010µ\u0002J8\u0010¶\u0002\u001a\u00020n2\u0010\u0010¤\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0Ð\u00012\u0007\u0010·\u0002\u001a\u0002012\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010¸\u0002\u001a\u00020,H\u0003J\u0017\u0010¹\u0002\u001a\u00020,2\f\u0010\u00ad\u0002\u001a\u00070cj\u0003`º\u0002H\u0002J\t\u0010»\u0002\u001a\u00020nH\u0003J\t\u0010¼\u0002\u001a\u00020nH\u0002J\u0017\u0010½\u0002\u001a\u00020n2\f\u0010¾\u0002\u001a\u00070cj\u0003`º\u0002H\u0002J\u0012\u0010¿\u0002\u001a\u00020n2\u0007\u0010À\u0002\u001a\u000201H\u0002J\t\u0010Á\u0002\u001a\u00020nH\u0002J\u0017\u0010Â\u0002\u001a\u00020n2\f\u0010Ã\u0002\u001a\u00070cj\u0003`º\u0002H\u0002J\u0012\u0010Ä\u0002\u001a\u00020n2\u0007\u0010½\u0001\u001a\u00020,H\u0002J\u0017\u0010Å\u0002\u001a\u00020\u001a2\f\u0010\u00ad\u0002\u001a\u00070#j\u0003`·\u0001H\u0002J\u0017\u0010Æ\u0002\u001a\u00020,2\f\u0010\u00ad\u0002\u001a\u00070#j\u0003`·\u0001H\u0002J\u0017\u0010Ç\u0002\u001a\u00020#2\f\u0010\u00ad\u0002\u001a\u00070#j\u0003`·\u0001H\u0002J\t\u0010È\u0002\u001a\u00020nH\u0002J\t\u0010É\u0002\u001a\u00020nH\u0002J;\u0010Ê\u0002\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#2\t\u0010Ë\u0002\u001a\u0004\u0018\u00010\u001b2\b\u0010Ì\u0002\u001a\u00030Í\u00022\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0006\bÏ\u0002\u0010Ð\u0002J\u0013\u0010Ñ\u0002\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#H\u0082\bJ\u001d\u0010Ñ\u0002\u001a\u00020n2\u0007\u0010\u00ad\u0001\u001a\u00020#2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001bH\u0002J\u001d\u0010Ò\u0002\u001a\u00020n2\u0007\u0010 \u0002\u001a\u00020,2\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u001bH\u0002J\t\u0010Ó\u0002\u001a\u00020nH\u0002J+\u0010Ô\u0002\u001a\n\u0012\u0005\u0012\u00030Ý\u00010Ô\u00012\u0007\u0010\u00ad\u0002\u001a\u00020#2\t\u0010Õ\u0002\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0003\u0010Ö\u0002J\u0019\u0010×\u0002\u001a\u00020n2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0003\bØ\u0002J \u0010Ù\u0002\u001a\u00020n2\f\u0010Ú\u0002\u001a\u00070cj\u0003`Û\u00022\u0007\u0010Ü\u0002\u001a\u00020#H\u0002J \u0010Ý\u0002\u001a\u00020n2\f\u0010Þ\u0002\u001a\u00070cj\u0003`Û\u00022\u0007\u0010ß\u0002\u001a\u00020#H\u0002J\u001b\u0010à\u0002\u001a\u0002012\u0007\u0010á\u0002\u001a\u0002012\u0007\u0010â\u0002\u001a\u000201H\u0002J\u0013\u0010ã\u0002\u001a\u00020n2\b\u0010Y\u001a\u0004\u0018\u00010\u001bH\u0002J\u0017\u0010ä\u0002\u001a\u00020#2\f\u0010Þ\u0002\u001a\u00070cj\u0003`Û\u0002H\u0002J\u0011\u0010å\u0002\u001a\u0004\u0018\u00010\u001b*\u0004\u0018\u00010\u001bH\u0002J1\u0010æ\u0002\u001a\u0003H°\u0002\"\u0005\b\u0000\u0010°\u00022\u0006\u00109\u001a\u00020:2\u000f\u0010\u0080\u0001\u001a\n\u0012\u0005\u0012\u0003H°\u00020\u0081\u0001H\u0082\b¢\u0006\u0003\u0010ç\u0002J\u0012\u0010è\u0002\u001a\u00020n2\u0007\u0010\u008b\u0001\u001a\u00020\u001aH\u0002J\"\u0010é\u0002\u001a\u0012\u0012\u0005\u0012\u00030ë\u0002\u0012\u0004\u0012\u00020n\u0018\u00010ê\u00022\u0007\u0010\u008b\u0001\u001a\u00020\u001aH\u0002J1\u0010ì\u0002\u001a\u00020n2\u0007\u0010í\u0002\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001b2\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u001bH\u0082\bJ\u001b\u0010î\u0002\u001a\u00020n2\u0007\u0010í\u0002\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0082\bJ1\u0010ï\u0002\u001a\u00020n2\u0007\u0010í\u0002\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001b2\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u001bH\u0082\bJ\u001b\u0010ð\u0002\u001a\u00020n2\u0007\u0010í\u0002\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0082\bJ\t\u0010ñ\u0002\u001a\u00020nH\u0002J\t\u0010ò\u0002\u001a\u00020nH\u0002R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0018\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020:X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010KR\u000e\u0010N\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020,X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0010\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u001e\u0010Z\u001a\u00020,2\u0006\u0010Y\u001a\u00020,@RX\u0090\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u0010RR\u001e\u0010\\\u001a\u00020,2\u0006\u0010Y\u001a\u00020,@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b]\u0010RR\u0014\u0010^\u001a\u00020,8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b_\u0010RR\u0016\u0010`\u001a\u0004\u0018\u00010\u001a8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR0\u0010e\u001a\u00060cj\u0002`d2\n\u0010Y\u001a\u00060cj\u0002`d8\u0016@RX\u0097\u000e¢\u0006\u0010\n\u0002\u0010j\u0012\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010RR\u001c\u0010q\u001a\u0004\u0018\u00010\fX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010x\u001a\u0004\u0018\u00010y8PX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u001e\u0010}\u001a\u00020,2\u0006\u0010Y\u001a\u00020,@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b~\u0010RR\u001a\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0016\u0010\u008c\u0001\u001a\u00020,8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008d\u0001\u0010RR!\u0010\u0094\u0001\u001a\u00030\u0095\u00018\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u0096\u0001\u0010g\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010©\u0001\u001a\u00020E8VX\u0096\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0018\u0010²\u0001\u001a\u00030³\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b´\u0001\u0010µ\u0001R\u001c\u0010¶\u0001\u001a\u00070#j\u0003`·\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¸\u0001\u0010¹\u0001R\u0016\u0010Í\u0001\u001a\u00020,8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0001\u0010R¨\u0006õ\u0002"}, d2 = {"Landroidx/compose/runtime/LinkComposer;", "Landroidx/compose/runtime/InternalComposer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "slotTable", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "changes", "Landroidx/compose/runtime/Changes;", "lateChanges", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "composition", "Landroidx/compose/runtime/CompositionImpl;", "<init>", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Ljava/util/Set;Landroidx/compose/runtime/composer/linkbuffer/SlotTable;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/CompositionObserverHolder;Landroidx/compose/runtime/CompositionImpl;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "invalidations", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "", "Landroidx/collection/MutableScatterMap;", "pendingStack", "Landroidx/compose/runtime/Stack;", "Landroidx/compose/runtime/LinkPending;", "Ljava/util/ArrayList;", PWEStaticDataModel.PWE_STATUS_PENDING, "nodeIndex", "", "groupNodeCount", "rGroupIndex", "parentStateStack", "Landroidx/compose/runtime/IntStack;", "nodeCountOverrides", "Landroidx/collection/MutableIntIntMap;", "nodeCountVirtualOverrides", "forceRecomposeScopes", "", "forciblyRecompose", "nodeExpected", "entersStack", "rootProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "providerUpdates", "Landroidx/collection/MutableIntObjectMap;", "providersInvalid", "providersInvalidStack", "reusing", "reusingGroup", "providerCache", "reader", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "getReader$runtime", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "setReader$runtime", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;)V", "builder", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "builderHasAProvider", "changeListWriter", "Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriter;", "_compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "lastPlacedChildGroup", "insertFixups", "Landroidx/compose/runtime/composer/linkbuffer/changelist/FixupList;", "insertTable", "getInsertTable$runtime", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "readerTable", "getReaderTable$runtime", "childrenComposing", "compositionToken", "sourceMarkersEnabled", "getSourceMarkersEnabled$runtime", "()Z", "setSourceMarkersEnabled$runtime", "(Z)V", "derivedStateObserver", "androidx/compose/runtime/LinkComposer$derivedStateObserver$1", "Landroidx/compose/runtime/LinkComposer$derivedStateObserver$1;", "invalidateStack", "value", "isComposing", "isComposing$runtime", "isDisposed", "isDisposed$runtime", "areChildrenComposing", "getAreChildrenComposing$runtime", "currentRecomposeScope", "getCurrentRecomposeScope$runtime", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "compositeKeyHashCode", "getCompositeKeyHashCode$annotations", "()V", "getCompositeKeyHashCode", "()J", "J", "defaultsInvalid", "getDefaultsInvalid", "disableReusing", "", "disableSourceInformation", "enableReusing", "deferredChanges", "getDeferredChanges$runtime", "()Landroidx/compose/runtime/Changes;", "setDeferredChanges$runtime", "(Landroidx/compose/runtime/Changes;)V", "shouldPauseCallback", "Landroidx/compose/runtime/ShouldPauseCallback;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "getErrorContext$runtime", "()Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "forceRecomposeScopes$runtime", "inserting", "getInserting", "prepareCompose", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "prepareCompose$runtime", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "recordUsed", "scope", "skipping", "getSkipping", "apply", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext$annotations", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "buildContext", "changed", "changedInstance", "", "", "", "", "", "collectParameterInformation", "composeContent", "invalidationsRequested", "content", "Landroidx/compose/runtime/Composable;", "shouldPause", "composeContent--ZbOJvo$runtime", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ShouldPauseCallback;)V", "compositionData", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createNode", "factory", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentMarker", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "getCurrentMarker", "()I", "deactivate", "deactivate$runtime", "deactivateToEndGroup", "dispose", "dispose$runtime", "endDefaults", "endNode", "endProvider", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReplaceGroup", "endReusableGroup", "endReuseFromRoot", "endReuseFromRoot$runtime", "endMovableGroup", "endToMarker", "marker", "hasPendingChanges", "getHasPendingChanges$runtime", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentReferences", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "joinKey", "left", "right", "parentKey", "parentKey$runtime", "parentStackTrace", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "parentStackTrace$runtime", "recompose", "recompose-aFTiNEg$runtime", "(Landroidx/collection/MutableScatterMap;Landroidx/compose/runtime/ShouldPauseCallback;)Z", "recordSideEffect", "effect", "rememberedValue", "shouldExecute", "parametersChanged", "flags", "skipCurrentGroup", "skipToGroupEnd", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "stacksSize", "stacksSize$runtime", "stackTraceForValue", "Landroidx/compose/runtime/tooling/ComposeStackTrace;", "stackTraceForValue$runtime", "startDefaults", "startNode", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReplaceableGroup", "startReplaceGroup", "startRestartGroup", "Landroidx/compose/runtime/Composer;", "startReusableGroup", "dataKey", "startReusableNode", "startReuseFromRoot", "startReuseFromRoot$runtime", "startMovableGroup", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime", "updateComposerInvalidations", "updateComposerInvalidations-RY85e9Y$runtime", "(Landroidx/collection/MutableScatterMap;)V", "updateRememberedValue", "useNode", "verifyConsistent", "verifyConsistent$runtime", "nextSlot", "nextSlot$runtime", "nextSlotForCache", "nextSlotForCache$runtime", "updateValue", "abortRoot", "addRecomposeScope", "cleanUpCompose", "clearUpdatedNodeCounts", "currentStackTrace", "doCompose", "doCompose-aFTiNEg", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;)V", "end", "isNode", "endGroup", "endRoot", "changesApplied", "changesApplied$runtime", "enterGroup", "newPending", "executeChangesImmediatelyWithoutApplier", "exitGroup", "expectedNodeCount", "ensureBuilder", "finalizeCompose", "currentCompositionLocalScope", "group", "insertMovableContentGuarded", "recomposeMovableContent", "R", "from", "Landroidx/compose/runtime/ControlledComposition;", "to", "address", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;ILjava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "invokeMovableContentLambda", "locals", "force", "isGroupAfterCurrentReaderPosition", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "recomposeToGroupEnd", "recordDelete", "recordInsert", "source", "recordProviderUpdate", "providers", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "resetInsertBuilder", "requireRecomposeScope", "requiresRecomposition", "rGroupIndexOf", "skipGroup", "skipReaderToGroupEnd", "start", "objectKey", "kind", "Landroidx/compose/runtime/composer/GroupKind;", "data", "start-AzEfcrM", "(ILjava/lang/Object;ILjava/lang/Object;)V", "startGroup", "startReaderGroup", "startRoot", "stackTraceForGroup", "dataOffset", "(ILjava/lang/Integer;)Ljava/util/List;", "updateCachedValue", "updateCachedValue$runtime", "updateChildNodeCount", "virtualGroup", "Landroidx/compose/runtime/VirtualGroupHandle;", "count", "updateNodeCountOverrides", "virtualHandle", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateSlot", "updatedNodeCount", "unwrapRememberObserverHolder", "withReader", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "enterRecomposeScope", "exitRecomposeScope", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "updateCompositeKeyWhenWeEnterGroup", "groupKey", "updateCompositeKeyWhenWeEnterGroupKeyHash", "updateCompositeKeyWhenWeExitGroup", "updateCompositeKeyWhenWeExitGroupKeyHash", "validateNodeExpected", "validateNodeNotExpected", "CompositionContextImpl", "CompositionContextHolder", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkComposer extends InternalComposer {
    public static final int $stable = 8;
    private CompositionData _compositionData;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final CoroutineContext applyCoroutineContext;
    private SlotTableBuilder builder;
    private boolean builderHasAProvider;
    private final ComposerChangeListWriter changeListWriter;
    private Changes changes;
    private int childrenComposing;
    private long compositeKeyHashCode;
    private final CompositionImpl composition;
    private int compositionToken;
    private Changes deferredChanges;
    private final LinkComposer$derivedStateObserver$1 derivedStateObserver;
    private final CompositionErrorContextImpl errorContext;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private FixupList insertFixups;
    private boolean inserting;
    private final ArrayList<RecomposeScopeImpl> invalidateStack;
    private boolean isComposing;
    private boolean isDisposed;
    private int lastPlacedChildGroup;
    private Changes lateChanges;
    private MutableIntIntMap nodeCountOverrides;
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parentContext;
    private LinkPending pending;
    private PersistentCompositionLocalMap providerCache;
    private MutableIntObjectMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private int rGroupIndex;
    private SlotTableReader reader;
    private boolean reusing;
    private ShouldPauseCallback shouldPauseCallback;
    private final SlotTable slotTable;
    private boolean sourceMarkersEnabled;
    private final MutableScatterMap<Object, Object> invalidations = ScopeMap.m5109constructorimpl$default(null, 1, null);
    private final ArrayList<LinkPending> pendingStack = Stack.m5052constructorimpl$default(null, 1, null);
    private final IntStack parentStateStack = new IntStack();
    private final IntStack entersStack = new IntStack();
    private PersistentCompositionLocalMap rootProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
    private final IntStack providersInvalidStack = new IntStack();
    private int reusingGroup = -1;

    public static /* synthetic */ void getApplyCoroutineContext$annotations() {
    }

    public static /* synthetic */ void getCompositeKeyHashCode$annotations() {
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.runtime.LinkComposer$derivedStateObserver$1] */
    public LinkComposer(Applier<?> applier, CompositionContext compositionContext, Set<RememberObserver> set, SlotTable slotTable, Changes changes, Changes changes2, CompositionObserverHolder compositionObserverHolder, CompositionImpl compositionImpl) {
        this.applier = applier;
        this.parentContext = compositionContext;
        this.abandonSet = set;
        this.slotTable = slotTable;
        this.changes = changes;
        this.lateChanges = changes2;
        this.observerHolder = compositionObserverHolder;
        this.composition = compositionImpl;
        SlotTableReader slotTableReaderOpenReader = slotTable.openReader();
        slotTableReaderOpenReader.close();
        this.reader = slotTableReaderOpenReader;
        SlotTableBuilder slotTableBuilder = new SlotTableBuilder(slotTable.getAddressSpace(), false, false);
        slotTableBuilder.close();
        this.builder = slotTableBuilder;
        this.changeListWriter = new ComposerChangeListWriter(this, ChangeListKt.asLinkBufferChangeList(this.changes));
        this.lastPlacedChildGroup = -1;
        this.insertFixups = new FixupList();
        this.sourceMarkersEnabled = compositionContext.getCollectingSourceInformation() || compositionContext.getCollectingCallByInformation$runtime();
        this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.LinkComposer$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                this.this$0.childrenComposing++;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                this.this$0.childrenComposing--;
            }
        };
        this.invalidateStack = Stack.m5052constructorimpl$default(null, 1, null);
        this.errorContext = new CompositionErrorContextImpl(this);
        CoroutineContext effectCoroutineContext = compositionContext.getEffectCoroutineContext();
        CoroutineContext errorContext$runtime = getErrorContext$runtime();
        this.applyCoroutineContext = effectCoroutineContext.plus(errorContext$runtime == null ? EmptyCoroutineContext.INSTANCE : errorContext$runtime);
    }

    @Override // androidx.compose.runtime.Composer
    public Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionImpl getComposition() {
        return this.composition;
    }

    /* JADX INFO: renamed from: getReader$runtime, reason: from getter */
    public final SlotTableReader getReader() {
        return this.reader;
    }

    public final void setReader$runtime(SlotTableReader slotTableReader) {
        this.reader = slotTableReader;
    }

    public final SlotTable getInsertTable$runtime() {
        return this.builder.getTable();
    }

    public final SlotTable getReaderTable$runtime() {
        return this.reader.getTable();
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* JADX INFO: renamed from: getSourceMarkersEnabled$runtime, reason: from getter */
    public boolean getSourceMarkersEnabled() {
        return this.sourceMarkersEnabled;
    }

    public void setSourceMarkersEnabled$runtime(boolean z) {
        this.sourceMarkersEnabled = z;
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* JADX INFO: renamed from: isComposing$runtime, reason: from getter */
    public boolean getIsComposing() {
        return this.isComposing;
    }

    /* JADX INFO: renamed from: isDisposed$runtime, reason: from getter */
    public final boolean getIsDisposed() {
        return this.isDisposed;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean getAreChildrenComposing$runtime() {
        return this.childrenComposing > 0;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public RecomposeScopeImpl getCurrentRecomposeScope$runtime() {
        ArrayList<RecomposeScopeImpl> arrayList = this.invalidateStack;
        if (this.childrenComposing == 0 && Stack.m5058isNotEmptyimpl(arrayList)) {
            return (RecomposeScopeImpl) Stack.m5059peekimpl(arrayList);
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public long getCompositeKeyHashCode() {
        return this.compositeKeyHashCode;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        return !getSkipping() || this.providersInvalid || ((currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) != null && currentRecomposeScope$runtime.getDefaultsInvalid());
    }

    @Override // androidx.compose.runtime.Composer
    public void disableReusing() {
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void disableSourceInformation() {
        setSourceMarkersEnabled$runtime(false);
    }

    @Override // androidx.compose.runtime.Composer
    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* JADX INFO: renamed from: getDeferredChanges$runtime, reason: from getter */
    public Changes getDeferredChanges() {
        return this.deferredChanges;
    }

    public void setDeferredChanges$runtime(Changes changes) {
        this.deferredChanges = changes;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public CompositionErrorContextImpl getErrorContext$runtime() {
        if (getSourceMarkersEnabled()) {
            return this.errorContext;
        }
        return null;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean forceRecomposeScopes$runtime() {
        if (this.forceRecomposeScopes) {
            return false;
        }
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void prepareCompose$runtime(Function0<Unit> block) {
        if (getIsComposing()) {
            ComposerKt.composeImmediateRuntimeError("Preparing a composition while composing is not supported");
        }
        this.isComposing = true;
        try {
            block.invoke();
        } finally {
            this.isComposing = false;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime();
    }

    @Override // androidx.compose.runtime.Composer
    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime != null) {
            return currentRecomposeScope$runtime.getAnchor();
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public void recordUsed(RecomposeScope scope) {
        RecomposeScopeImpl recomposeScopeImpl = scope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) scope : null;
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setUsed(true);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        return (getInserting() || this.reusing || this.providersInvalid || (currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) == null || currentRecomposeScope$runtime.getRequiresRecompose() || this.forciblyRecompose) ? false : true;
    }

    @Override // androidx.compose.runtime.Composer
    public <V, T> void apply(V value, Function2<? super T, ? super V, Unit> block) {
        if (getInserting()) {
            this.insertFixups.updateNode(value, block);
        } else {
            this.changeListWriter.updateNode(value, block);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public CoroutineContext getApplyCoroutineContext() {
        return this.applyCoroutineContext;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionContext buildContext() {
        startGroup(206, ComposerKt.getReference());
        if (getInserting()) {
            this.builder.addFlags(1073741824);
        }
        Object objNextSlot$runtime = nextSlot$runtime();
        ReusableLinkRememberObserverHolder reusableLinkRememberObserverHolder = objNextSlot$runtime instanceof ReusableRememberObserverHolder ? (ReusableRememberObserverHolder) objNextSlot$runtime : null;
        if (reusableLinkRememberObserverHolder == null) {
            reusableLinkRememberObserverHolder = new ReusableLinkRememberObserverHolder(new CompositionContextHolder(new CompositionContextImpl(getCompositeKeyHashCode(), this.forceRecomposeScopes, getSourceMarkersEnabled(), getComposition().getObserverHolder())), LinkAnchorKt.getNullAnchor());
            updateValue(reusableLinkRememberObserverHolder);
        }
        RememberObserver wrapped = reusableLinkRememberObserverHolder.getWrapped();
        Intrinsics.checkNotNull(wrapped, "null cannot be cast to non-null type androidx.compose.runtime.LinkComposer.CompositionContextHolder");
        CompositionContextHolder compositionContextHolder = (CompositionContextHolder) wrapped;
        compositionContextHolder.getRef().updateCompositionLocalScope(currentCompositionLocalScope());
        endGroup();
        return compositionContextHolder.getRef();
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(Object value) {
        if (Intrinsics.areEqual(nextSlot$runtime(), value)) {
            return false;
        }
        updateValue(value);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changedInstance(Object value) {
        if (nextSlot$runtime() == value) {
            return false;
        }
        updateValue(value);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(char value) {
        Object objNextSlot$runtime = nextSlot$runtime();
        if ((objNextSlot$runtime instanceof Character) && value == ((Character) objNextSlot$runtime).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(byte value) {
        Object objNextSlot$runtime = nextSlot$runtime();
        if ((objNextSlot$runtime instanceof Byte) && value == ((Number) objNextSlot$runtime).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(short value) {
        Object objNextSlot$runtime = nextSlot$runtime();
        if ((objNextSlot$runtime instanceof Short) && value == ((Number) objNextSlot$runtime).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(boolean value) {
        Object objNextSlot$runtime = nextSlot$runtime();
        if ((objNextSlot$runtime instanceof Boolean) && value == ((Boolean) objNextSlot$runtime).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(float value) {
        Object objNextSlot$runtime = nextSlot$runtime();
        if ((objNextSlot$runtime instanceof Float) && Intrinsics.areEqual(value, (Float) objNextSlot$runtime)) {
            return false;
        }
        updateValue(Float.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(long value) {
        Object objNextSlot$runtime = nextSlot$runtime();
        boolean z = objNextSlot$runtime instanceof Long;
        if (z && z && value == ((Number) objNextSlot$runtime).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(double value) {
        Object objNextSlot$runtime = nextSlot$runtime();
        if ((objNextSlot$runtime instanceof Double) && Intrinsics.areEqual(value, (Double) objNextSlot$runtime)) {
            return false;
        }
        updateValue(Double.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean changed(int value) {
        Object objNextSlot$runtime = nextSlot$runtime();
        boolean z = objNextSlot$runtime instanceof Integer;
        if (z && z && value == ((Number) objNextSlot$runtime).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
        setSourceMarkersEnabled$runtime(true);
        this.slotTable.collectSourceInformation();
        this.builder.collectSourceInformation();
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* JADX INFO: renamed from: composeContent--ZbOJvo$runtime */
    public void mo5015composeContentZbOJvo$runtime(MutableScatterMap<Object, Object> invalidationsRequested, Function2<? super Composer, ? super Integer, Unit> content, ShouldPauseCallback shouldPause) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        this.shouldPauseCallback = shouldPause;
        try {
            m5023doComposeaFTiNEg(invalidationsRequested, content);
        } finally {
            this.shouldPauseCallback = null;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionData getCompositionData() {
        CompositionData compositionData = this._compositionData;
        if (compositionData != null) {
            return compositionData;
        }
        LinkCompositionDataImpl linkCompositionDataImpl = new LinkCompositionDataImpl(getComposition());
        this._compositionData = linkCompositionDataImpl;
        return linkCompositionDataImpl;
    }

    @Override // androidx.compose.runtime.Composer
    public <T> T consume(CompositionLocal<T> key) {
        return (T) CompositionLocalMapKt.read(currentCompositionLocalScope(), key);
    }

    @Override // androidx.compose.runtime.Composer
    public <T> void createNode(Function0<? extends T> factory) {
        validateNodeExpected();
        if (!getInserting()) {
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }
        int iPeek = this.parentStateStack.peek();
        this.groupNodeCount++;
        long parentHandle = this.builder.getParentHandle();
        if (this.changeListWriter.isInAnchorMode()) {
            this.insertFixups.createAndInsertNodeByAnchor(factory, iPeek, this.builder.getTable().getAddressSpace().anchorOfAddress(GroupHandleKt.getGroup(parentHandle)));
        } else {
            this.insertFixups.createAndInsertNode(factory, iPeek, this.builder.getParentHandle());
        }
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    @Override // androidx.compose.runtime.Composer
    public int getCurrentMarker() {
        return getInserting() ? -this.builder.getParent() : this.reader.getParent();
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void deactivate$runtime() {
        Stack.m5050clearimpl(this.invalidateStack);
        ScopeMap.m5107clearimpl(this.invalidations);
        this.changes.clear();
        this.providerUpdates = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void deactivateToEndGroup(boolean changed) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling deactivateToEndGroup");
        }
        if (getInserting()) {
            return;
        }
        if (!changed) {
            skipReaderToGroupEnd();
        } else {
            this.changeListWriter.deactivateCurrentGroup();
            this.reader.skipToGroupEnd();
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void dispose$runtime() {
        this.slotTable.dispose();
        this.parentContext.unregisterComposer$runtime(this);
        deactivate$runtime();
        getApplier().clear();
        this.isDisposed = true;
    }

    @Override // androidx.compose.runtime.Composer
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime == null || !currentRecomposeScope$runtime.getUsed()) {
            return;
        }
        currentRecomposeScope$runtime.setDefaultsInScope(true);
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    public void endProvider() {
        endGroup();
        endGroup();
        this.providersInvalid = LinkComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = LinkComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void endReplaceableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public ScopeUpdateScope endRestartGroup() {
        LinkAnchor parentAnchor;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl recomposeScopeImpl2 = Stack.m5058isNotEmptyimpl(this.invalidateStack) ? (RecomposeScopeImpl) Stack.m5061popimpl(this.invalidateStack) : null;
        if (recomposeScopeImpl2 != null) {
            recomposeScopeImpl2.setRequiresRecompose(false);
            Function1<Composition, Unit> function1ExitRecomposeScope = exitRecomposeScope(recomposeScopeImpl2);
            if (function1ExitRecomposeScope != null) {
                this.changeListWriter.endCompositionScope(function1ExitRecomposeScope, getComposition());
            }
            if (recomposeScopeImpl2.getResuming()) {
                recomposeScopeImpl2.setResuming(false);
                this.changeListWriter.endResumingScope(recomposeScopeImpl2);
                recomposeScopeImpl2.setReusing(false);
                if (recomposeScopeImpl2.getResetReusing() && this.reusingGroup == this.reader.getParent()) {
                    recomposeScopeImpl2.setResetReusing(false);
                    this.reusingGroup = -1;
                    this.reusing = false;
                }
            }
        }
        if (recomposeScopeImpl2 != null && !recomposeScopeImpl2.getSkipped$runtime() && (recomposeScopeImpl2.getUsed() || this.forceRecomposeScopes)) {
            if (recomposeScopeImpl2.getAnchor() == null) {
                if (getInserting()) {
                    parentAnchor = this.builder.getParentAnchor();
                } else {
                    parentAnchor = this.reader.getParentAnchor();
                }
                recomposeScopeImpl2.setAnchor(parentAnchor);
            }
            recomposeScopeImpl2.setDefaultsInvalid(false);
            recomposeScopeImpl = recomposeScopeImpl2;
        }
        end(false);
        return recomposeScopeImpl;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void endReuseFromRoot$runtime() {
        int i = this.reusingGroup;
        if (!(!getIsComposing() && (i < 0 ? 100 : this.reader.groupKey(i)) == 100)) {
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }
        this.reusingGroup = -1;
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void endMovableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endToMarker(int marker) {
        if (marker < 0) {
            int i = -marker;
            SlotTableBuilder slotTableBuilder = this.builder;
            MutableIntSet mutableIntSet = new MutableIntSet(0, 1, null);
            int[] groups = getReaderTable$runtime().getAddressSpace().getGroups();
            int i2 = i;
            while (i2 > 0) {
                mutableIntSet.add(i2);
                i2 = groups[i2 + 2];
            }
            if (!(i2 != 0)) {
                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + i);
            }
            while (!mutableIntSet.contains(slotTableBuilder.getParent())) {
                end(slotTableBuilder.isNode());
            }
            return;
        }
        if (getInserting()) {
            SlotTableBuilder slotTableBuilder2 = this.builder;
            while (getInserting()) {
                end(slotTableBuilder2.isNode());
            }
        }
        MutableIntSet mutableIntSet2 = new MutableIntSet(0, 1, null);
        int[] groups2 = getReaderTable$runtime().getAddressSpace().getGroups();
        int i3 = marker;
        while (i3 > 0) {
            mutableIntSet2.add(i3);
            i3 = groups2[i3 + 2];
        }
        if (!(i3 != 0)) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + marker);
        }
        SlotTableReader slotTableReader = this.reader;
        for (int parent = slotTableReader.getParent(); !mutableIntSet2.contains(parent); parent = slotTableReader.getParent()) {
            end((slotTableReader.flagsOf(parent) & 8388608) == 8388608);
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean getHasPendingChanges$runtime() {
        return this.changes.isNotEmpty();
    }

    @Override // androidx.compose.runtime.Composer
    public void insertMovableContent(MovableContent<?> value, Object parameter) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        invokeMovableContentLambda(value, currentCompositionLocalScope(), parameter, false);
    }

    @Override // androidx.compose.runtime.Composer
    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        try {
            insertMovableContentGuarded(references);
            cleanUpCompose();
        } catch (Throwable th) {
            abortRoot();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public Object joinKey(Object left, Object right) {
        Object key = LinkComposerKt.getKey(getInserting() ? null : this.reader.getGroupObjectKey(), left, right);
        return key == null ? new JoinedKey(left, right) : key;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public int parentKey$runtime() {
        if (getInserting()) {
            SlotTableBuilder slotTableBuilder = this.builder;
            return slotTableBuilder.groupKey(slotTableBuilder.getParent());
        }
        SlotTableReader slotTableReader = this.reader;
        return slotTableReader.groupKey(slotTableReader.getParent());
    }

    @Override // androidx.compose.runtime.InternalComposer
    public List<ComposeStackTraceFrame> parentStackTrace$runtime() {
        Composition composition$runtime = this.parentContext.getComposition$runtime();
        CompositionImpl compositionImpl = composition$runtime instanceof CompositionImpl ? (CompositionImpl) composition$runtime : null;
        if (compositionImpl == null) {
            return CollectionsKt.emptyList();
        }
        Integer numFindSubcompositionContextGroup = LinkComposerKt.findSubcompositionContextGroup(SlotTableKt.asLinkBufferSlotTable(compositionImpl.getSlotStorage()), this.parentContext);
        if (numFindSubcompositionContextGroup == null) {
            return CollectionsKt.emptyList();
        }
        SlotTableReader slotTableReaderOpenReader = SlotTableKt.asLinkBufferSlotTable(compositionImpl.getSlotStorage()).openReader();
        try {
            List<ComposeStackTraceFrame> listTraceForGroup = SlotTableReaderKt.traceForGroup(slotTableReaderOpenReader, numFindSubcompositionContextGroup.intValue(), 0);
            slotTableReaderOpenReader.close();
            return CollectionsKt.plus((Collection) listTraceForGroup, (Iterable) compositionImpl.getComposer().parentStackTrace$runtime());
        } catch (Throwable th) {
            slotTableReaderOpenReader.close();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* JADX INFO: renamed from: recompose-aFTiNEg$runtime */
    public boolean mo5016recomposeaFTiNEg$runtime(MutableScatterMap<Object, Object> invalidationsRequested, ShouldPauseCallback shouldPause) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        if (ScopeMap.m5117getSizeimpl(invalidationsRequested) <= 0 && !ScopeMap.m5120isNotEmptyimpl(this.invalidations) && ((this.slotTable.getRoot() < 0 || !requiresRecomposition(this.slotTable.getRoot())) && !this.forciblyRecompose)) {
            return false;
        }
        this.shouldPauseCallback = shouldPause;
        try {
            this.changeListWriter.startComposition();
            m5023doComposeaFTiNEg(invalidationsRequested, null);
            this.shouldPauseCallback = null;
            if (ChangeListKt.asLinkBufferChangeList(this.changes).hasChangesRequiringApplication()) {
                return true;
            }
            if (!this.changes.isNotEmpty()) {
                return false;
            }
            executeChangesImmediatelyWithoutApplier();
            return false;
        } catch (Throwable th) {
            this.shouldPauseCallback = null;
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void recordSideEffect(Function0<Unit> effect) {
        this.changeListWriter.sideEffect(effect);
    }

    @Override // androidx.compose.runtime.Composer
    public Object rememberedValue() {
        return unwrapRememberObserverHolder(nextSlotForCache$runtime());
    }

    @Override // androidx.compose.runtime.Composer
    public boolean shouldExecute(boolean parametersChanged, int flags) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        if ((flags & 1) != 0 || (!getInserting() && !this.reusing)) {
            return parametersChanged || !getSkipping();
        }
        ShouldPauseCallback shouldPauseCallback = this.shouldPauseCallback;
        if (shouldPauseCallback == null || (currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) == null || !shouldPauseCallback.shouldPause() || currentRecomposeScope$runtime.getResuming()) {
            return true;
        }
        currentRecomposeScope$runtime.setUsed(true);
        currentRecomposeScope$runtime.setReusing(this.reusing);
        currentRecomposeScope$runtime.setPaused(true);
        this.changeListWriter.rememberPausingScope(currentRecomposeScope$runtime);
        this.parentContext.reportPausedScope$runtime(currentRecomposeScope$runtime);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cc  */
    @Override // androidx.compose.runtime.Composer
    @androidx.compose.runtime.ComposeCompilerApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void skipCurrentGroup() {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.LinkComposer.skipCurrentGroup():void");
    }

    @Override // androidx.compose.runtime.Composer
    public void skipToGroupEnd() {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling skipAndEndGroup");
        }
        if (getInserting()) {
            return;
        }
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime != null) {
            currentRecomposeScope$runtime.scopeSkipped();
        }
        if (this.reader.getCurrentGroup() < 0 || !requiresRecomposition(this.reader.getParent())) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    public CancellationHandle scheduleFrameEndCallback(Function0<Unit> action) {
        return this.parentContext.scheduleFrameEndCallback(action);
    }

    @Override // androidx.compose.runtime.Composer
    public void sourceInformation(String sourceInformation) {
        if (getInserting() && getSourceMarkersEnabled()) {
            this.builder.recordGroupSourceInformation(sourceInformation);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void sourceInformationMarkerEnd() {
        if (getInserting() && getSourceMarkersEnabled()) {
            this.builder.recordGrouplessCallSourceInformationEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void sourceInformationMarkerStart(int key, String sourceInformation) {
        if (getInserting() && getSourceMarkersEnabled()) {
            this.builder.recordGrouplessCallSourceInformationStart(key, sourceInformation);
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public int stacksSize$runtime() {
        return this.entersStack.tos + Stack.m5055getSizeimpl(this.invalidateStack) + this.providersInvalidStack.tos + Stack.m5055getSizeimpl(this.pendingStack) + this.parentStateStack.tos;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public ComposeStackTrace stackTraceForValue$runtime(final Object value) {
        List listEmptyList;
        if (!getSourceMarkersEnabled()) {
            return new ComposeStackTrace(CollectionsKt.emptyList(), false);
        }
        ObjectLocation objectLocationFindLocation = SlotTableKt.findLocation(this.slotTable, new Function1() { // from class: androidx.compose.runtime.LinkComposer$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(LinkComposer.stackTraceForValue$lambda$0(value, obj));
            }
        });
        if (objectLocationFindLocation == null || (listEmptyList = CollectionsKt.plus((Collection) stackTraceForGroup(objectLocationFindLocation.getGroup(), objectLocationFindLocation.getDataOffset()), (Iterable) parentStackTrace$runtime())) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return new ComposeStackTrace(listEmptyList, getSourceMarkersEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stackTraceForValue$lambda$0(Object obj, Object obj2) {
        if (obj2 == obj) {
            return true;
        }
        RememberObserverHolder rememberObserverHolder = obj2 instanceof RememberObserverHolder ? (RememberObserverHolder) obj2 : null;
        return (rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null) == obj;
    }

    @Override // androidx.compose.runtime.Composer
    public void startDefaults() {
        m5024startAzEfcrM(ComposerKt.defaultsKey, null, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        m5024startAzEfcrM(125, null, GroupKind.INSTANCE.m5139getNode9udXigM(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    public void startProvider(ProvidedValue<?> value) {
        ValueHolder<?> valueHolder;
        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        Object objRememberedValue = rememberedValue();
        if (Intrinsics.areEqual(objRememberedValue, Composer.INSTANCE.getEmpty())) {
            valueHolder = null;
        } else {
            Intrinsics.checkNotNull(objRememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            valueHolder = (ValueHolder) objRememberedValue;
        }
        CompositionLocal<?> compositionLocal = value.getCompositionLocal();
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        ValueHolder<?> valueHolderUpdatedStateOf$runtime = compositionLocal.updatedStateOf$runtime(value, valueHolder);
        boolean zAreEqual = Intrinsics.areEqual(valueHolderUpdatedStateOf$runtime, valueHolder);
        if (!zAreEqual) {
            updateRememberedValue(valueHolderUpdatedStateOf$runtime);
        }
        boolean z = true;
        boolean z2 = false;
        if (getInserting()) {
            if (value.getCanOverride() || !CompositionLocalMapKt.contains(persistentCompositionLocalMapCurrentCompositionLocalScope, compositionLocal)) {
                persistentCompositionLocalMapCurrentCompositionLocalScope = persistentCompositionLocalMapCurrentCompositionLocalScope.putValue(compositionLocal, valueHolderUpdatedStateOf$runtime);
            }
            this.builderHasAProvider = true;
        } else {
            SlotTableReader slotTableReader = this.reader;
            Object objGroupAux = slotTableReader.groupAux(slotTableReader.getCurrentGroup());
            Intrinsics.checkNotNull(objGroupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) objGroupAux;
            if ((!getSkipping() || !zAreEqual) && (value.getCanOverride() || !CompositionLocalMapKt.contains(persistentCompositionLocalMapCurrentCompositionLocalScope, compositionLocal))) {
                persistentCompositionLocalMapCurrentCompositionLocalScope = persistentCompositionLocalMapCurrentCompositionLocalScope.putValue(compositionLocal, valueHolderUpdatedStateOf$runtime);
            } else if ((zAreEqual && !this.providersInvalid) || !this.providersInvalid) {
                persistentCompositionLocalMapCurrentCompositionLocalScope = persistentCompositionLocalMap;
            }
            if (!this.reusing && persistentCompositionLocalMap == persistentCompositionLocalMapCurrentCompositionLocalScope) {
                z = false;
            }
            z2 = z;
        }
        if (z2 && !getInserting()) {
            recordProviderUpdate(persistentCompositionLocalMapCurrentCompositionLocalScope);
        }
        this.providersInvalidStack.push(LinkComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z2;
        this.providerCache = persistentCompositionLocalMapCurrentCompositionLocalScope;
        m5024startAzEfcrM(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m5138getGroup9udXigM(), persistentCompositionLocalMapCurrentCompositionLocalScope);
    }

    @Override // androidx.compose.runtime.Composer
    public void startProviders(ProvidedValue<?>[] values) {
        PersistentCompositionLocalMap persistentCompositionLocalMapUpdateProviderMapGroup;
        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        boolean z = true;
        boolean z2 = false;
        if (getInserting()) {
            persistentCompositionLocalMapUpdateProviderMapGroup = updateProviderMapGroup(persistentCompositionLocalMapCurrentCompositionLocalScope, CompositionLocalMapKt.updateCompositionMap$default(values, persistentCompositionLocalMapCurrentCompositionLocalScope, null, 4, null));
            this.builderHasAProvider = true;
        } else {
            Object obj = this.reader.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) obj;
            Object obj2 = this.reader.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) obj2;
            PersistentCompositionLocalMap persistentCompositionLocalMapUpdateCompositionMap = CompositionLocalMapKt.updateCompositionMap(values, persistentCompositionLocalMapCurrentCompositionLocalScope, persistentCompositionLocalMap2);
            if (!getSkipping() || this.reusing || !Intrinsics.areEqual(persistentCompositionLocalMap2, persistentCompositionLocalMapUpdateCompositionMap)) {
                persistentCompositionLocalMapUpdateProviderMapGroup = updateProviderMapGroup(persistentCompositionLocalMapCurrentCompositionLocalScope, persistentCompositionLocalMapUpdateCompositionMap);
                if (!this.reusing && Intrinsics.areEqual(persistentCompositionLocalMapUpdateProviderMapGroup, persistentCompositionLocalMap)) {
                    z = false;
                }
                z2 = z;
            } else {
                skipGroup();
                persistentCompositionLocalMapUpdateProviderMapGroup = persistentCompositionLocalMap;
            }
        }
        if (z2 && !getInserting()) {
            recordProviderUpdate(persistentCompositionLocalMapUpdateProviderMapGroup);
        }
        this.providersInvalidStack.push(LinkComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z2;
        this.providerCache = persistentCompositionLocalMapUpdateProviderMapGroup;
        m5024startAzEfcrM(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m5138getGroup9udXigM(), persistentCompositionLocalMapUpdateProviderMapGroup);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReplaceableGroup(int key) {
        m5024startAzEfcrM(key, null, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReplaceGroup(int key) {
        if (this.pending != null) {
            m5024startAzEfcrM(key, null, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
            return;
        }
        validateNodeNotExpected();
        this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ ((long) key), 3) ^ ((long) this.rGroupIndex);
        this.rGroupIndex++;
        SlotTableReader slotTableReader = this.reader;
        if (getInserting()) {
            slotTableReader.beginEmpty();
            SlotTableBuilder slotTableBuilder = this.builder;
            Object empty = Composer.INSTANCE.getEmpty();
            slotTableBuilder.startNewGroup(key, empty == Composer.INSTANCE.getEmpty() ? 0 : 16777216, empty, null, null);
            enterGroup(false, null);
            return;
        }
        if (slotTableReader.getGroupKey() == key && !slotTableReader.getHasObjectKey()) {
            slotTableReader.startGroup();
            enterGroup(false, null);
            return;
        }
        if (!slotTableReader.isGroupEnd()) {
            int i = this.nodeIndex;
            recordDelete();
            this.changeListWriter.removeNode(i, slotTableReader.skipGroup());
        }
        slotTableReader.beginEmpty();
        this.inserting = true;
        this.providerCache = null;
        ensureBuilder();
        SlotTableBuilder slotTableBuilder2 = this.builder;
        Object empty2 = Composer.INSTANCE.getEmpty();
        slotTableBuilder2.startNewGroup(key, empty2 == Composer.INSTANCE.getEmpty() ? 0 : 16777216, empty2, null, null);
        enterGroup(false, null);
    }

    @Override // androidx.compose.runtime.Composer
    public Composer startRestartGroup(int key) {
        startReplaceGroup(key);
        addRecomposeScope();
        return this;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int key, Object dataKey) {
        if (!getInserting() && this.reader.getGroupKey() == key && !Intrinsics.areEqual(this.reader.getGroupAux(), dataKey) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        m5024startAzEfcrM(key, null, GroupKind.INSTANCE.m5138getGroup9udXigM(), dataKey);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        m5024startAzEfcrM(125, null, GroupKind.INSTANCE.m5140getReusableNode9udXigM(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void startReuseFromRoot$runtime() {
        this.reusingGroup = this.slotTable.getRoot();
        this.reusing = true;
    }

    @Override // androidx.compose.runtime.Composer
    public void startMovableGroup(int key, Object dataKey) {
        m5024startAzEfcrM(key, dataKey, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean tryImminentInvalidation$runtime(RecomposeScopeImpl scope, Object instance) {
        int address;
        Anchor anchor = scope.getAnchor();
        if (anchor == null || (address = LinkAnchorKt.asLinkAnchor(anchor).getAddress()) < 0 || !getIsComposing() || !isGroupAfterCurrentReaderPosition((((long) 0) << 32) | (((long) UInt.m12488constructorimpl(address)) & 4294967295L))) {
            return false;
        }
        this.reader.addFlag(address, 67108864);
        if (instance == null || Intrinsics.areEqual(instance, ScopeInvalidated.INSTANCE)) {
            ScopeMap.m5126setimpl(this.invalidations, scope, ScopeInvalidated.INSTANCE);
            return true;
        }
        if (instance instanceof ScatterSet) {
            MutableScatterMap<Object, Object> mutableScatterMap = this.invalidations;
            Intrinsics.checkNotNull(instance, "null cannot be cast to non-null type androidx.collection.ScatterSet<kotlin.Any>");
            ScopeMap.m5103addAllimpl(mutableScatterMap, scope, (ScatterSet) instance);
            return true;
        }
        if (Intrinsics.areEqual(ScopeMap.m5116getimpl(this.invalidations, scope), ScopeInvalidated.INSTANCE)) {
            return true;
        }
        ScopeMap.m5102addimpl(this.invalidations, scope, instance);
        return true;
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* JADX INFO: renamed from: updateComposerInvalidations-RY85e9Y$runtime */
    public void mo5017updateComposerInvalidationsRY85e9Y$runtime(MutableScatterMap<Object, Object> invalidationsRequested) {
        MutableScatterMap<Object, Object> mutableScatterMap = invalidationsRequested;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
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
                        int i4 = (i << 3) + i3;
                        Object obj = objArr[i4];
                        Object obj2 = objArr2[i4];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                        Anchor anchor = ((RecomposeScopeImpl) obj).getAnchor();
                        LinkAnchor linkAnchorAsLinkAnchor = anchor != null ? LinkAnchorKt.asLinkAnchor(anchor) : null;
                        if (linkAnchorAsLinkAnchor != null && linkAnchorAsLinkAnchor.getValid()) {
                            int address = linkAnchorAsLinkAnchor.getAddress();
                            this.reader.addFlag(address, 67108864);
                            if (Intrinsics.areEqual(obj2, ScopeInvalidated.INSTANCE)) {
                                ScopeMap.m5126setimpl(this.invalidations, obj, ScopeInvalidated.INSTANCE);
                            } else if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<kotlin.Any>");
                                ScopeMap.m5103addAllimpl(this.invalidations, obj, (ScatterSet) obj2);
                            } else {
                                ScopeMap.m5102addimpl(this.invalidations, obj, obj2);
                            }
                            this.reader.addFlag(address, 67108864);
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

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(Object value) {
        updateCachedValue$runtime(value);
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        validateNodeExpected();
        if (getInserting()) {
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }
        Object parentNode = this.reader.getParentNode();
        this.changeListWriter.moveDown(parentNode);
        if (this.reusing && (parentNode instanceof ComposeNodeLifecycleCallback)) {
            this.changeListWriter.useNode(parentNode);
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void verifyConsistent$runtime() {
        if (getIsComposing()) {
            return;
        }
        getInsertTable$runtime().verifyWellFormed();
    }

    public final Object nextSlot$runtime() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.INSTANCE.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserverHolder)) ? next : Composer.INSTANCE.getEmpty();
    }

    public final Object nextSlotForCache$runtime() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.INSTANCE.getEmpty();
        }
        Object next = this.reader.next();
        if (this.reusing && !(next instanceof ReusableRememberObserverHolder)) {
            return Composer.INSTANCE.getEmpty();
        }
        if (next instanceof RememberObserverHolder) {
            this.changeListWriter.updateRememberOrdering(LinkComposerKt.asLinkRememberObserverHolder((RememberObserverHolder) next), getReaderTable$runtime().getAddressSpace().anchorOfAddress(this.lastPlacedChildGroup));
        }
        return next;
    }

    public final void updateValue(Object value) {
        if (getInserting()) {
            this.builder.append(value);
        } else if (this.reader.getHadNext()) {
            this.changeListWriter.updateValue(this.reader.getParentCurrentSlotOffset() - 1, value);
        } else {
            this.changeListWriter.appendValue(value);
        }
    }

    private final void abortRoot() {
        cleanUpCompose();
        Stack.m5050clearimpl(this.pendingStack);
        this.parentStateStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates = null;
        this.insertFixups.clear();
        this.compositeKeyHashCode = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
        this.reusingGroup = -1;
        if (!this.reader.getIsClosed()) {
            this.reader.close();
        }
        resetInsertBuilder(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addRecomposeScope() {
        /*
            r5 = this;
            boolean r0 = r5.getInserting()
            if (r0 == 0) goto L1d
            androidx.compose.runtime.RecomposeScopeImpl r0 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.CompositionImpl r1 = r5.getComposition()
            androidx.compose.runtime.RecomposeScopeOwner r1 = (androidx.compose.runtime.RecomposeScopeOwner) r1
            r0.<init>(r1)
            java.util.ArrayList<androidx.compose.runtime.RecomposeScopeImpl> r1 = r5.invalidateStack
            androidx.compose.runtime.Stack.m5062pushimpl(r1, r0)
            r5.updateValue(r0)
            r5.enterRecomposeScope(r0)
            return
        L1d:
            androidx.compose.runtime.composer.linkbuffer.SlotTableReader r0 = r5.reader
            int r0 = r0.getParent()
            androidx.compose.runtime.composer.linkbuffer.SlotTableReader r1 = r5.reader
            androidx.compose.runtime.RecomposeScopeImpl r1 = androidx.compose.runtime.LinkComposerKt.getRecomposeScopeOrNull(r1, r0)
            if (r1 == 0) goto L32
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r2 = r5.invalidations
            java.lang.Object r1 = androidx.compose.runtime.collection.ScopeMap.m5121removeimpl(r2, r1)
            goto L33
        L32:
            r1 = 0
        L33:
            androidx.compose.runtime.composer.linkbuffer.SlotTableReader r2 = r5.reader
            boolean r0 = r2.recomposeRequired(r0)
            if (r0 == 0) goto L42
            androidx.compose.runtime.composer.linkbuffer.SlotTableReader r2 = r5.reader
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            r2.removeFlag(r3)
        L42:
            androidx.compose.runtime.composer.linkbuffer.SlotTableReader r2 = r5.reader
            java.lang.Object r2 = r2.next()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.INSTANCE
            java.lang.Object r3 = r3.getEmpty()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r3 == 0) goto L63
            androidx.compose.runtime.RecomposeScopeImpl r2 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.CompositionImpl r3 = r5.getComposition()
            androidx.compose.runtime.RecomposeScopeOwner r3 = (androidx.compose.runtime.RecomposeScopeOwner) r3
            r2.<init>(r3)
            r5.updateValue(r2)
            goto L6a
        L63:
            java.lang.String r3 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            androidx.compose.runtime.RecomposeScopeImpl r2 = (androidx.compose.runtime.RecomposeScopeImpl) r2
        L6a:
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L7e
            if (r1 != 0) goto L7e
            boolean r0 = r2.getForcedRecompose()
            if (r0 == 0) goto L79
            r2.setForcedRecompose(r3)
        L79:
            if (r0 == 0) goto L7c
            goto L7e
        L7c:
            r0 = r3
            goto L7f
        L7e:
            r0 = r4
        L7f:
            r2.setRequiresRecompose(r0)
            java.util.ArrayList<androidx.compose.runtime.RecomposeScopeImpl> r0 = r5.invalidateStack
            androidx.compose.runtime.Stack.m5062pushimpl(r0, r2)
            r5.enterRecomposeScope(r2)
            boolean r0 = r2.getPaused()
            if (r0 == 0) goto Lb2
            r2.setPaused(r3)
            r2.setResuming(r4)
            androidx.compose.runtime.composer.linkbuffer.changelist.ComposerChangeListWriter r0 = r5.changeListWriter
            r0.startResumingScope(r2)
            boolean r0 = r5.reusing
            if (r0 != 0) goto Lb2
            boolean r0 = r2.getReusing()
            if (r0 == 0) goto Lb2
            r5.reusing = r4
            androidx.compose.runtime.composer.linkbuffer.SlotTableReader r0 = r5.reader
            int r0 = r0.getParent()
            r5.reusingGroup = r0
            r2.setResetReusing(r4)
        Lb2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.LinkComposer.addRecomposeScope():void");
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.compositeKeyHashCode = 0L;
        this.nodeExpected = false;
        Stack.m5050clearimpl(this.invalidateStack);
        clearUpdatedNodeCounts();
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ComposeStackTrace currentStackTrace() {
        if (!getSourceMarkersEnabled()) {
            return null;
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.addAll(SlotTableBuilderKt.buildTrace(this.builder));
        listCreateListBuilder.addAll(SlotTableReaderKt.buildTrace(this.reader));
        listCreateListBuilder.addAll(parentStackTrace$runtime());
        return new ComposeStackTrace(CollectionsKt.build(listCreateListBuilder), getSourceMarkersEnabled());
    }

    /* JADX INFO: renamed from: doCompose-aFTiNEg, reason: not valid java name */
    private final void m5023doComposeaFTiNEg(MutableScatterMap<Object, Object> invalidationsRequested, Function2<? super Composer, ? super Integer, Unit> content) {
        if (getIsComposing()) {
            ComposerKt.composeImmediateRuntimeError("Reentrant composition is not supported");
        }
        CompositionObserver compositionObserverCurrent = this.observerHolder.current();
        Object objBeginSection = Trace.INSTANCE.beginSection("Compose:recompose");
        try {
            this.compositionToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            this.providerUpdates = null;
            mo5017updateComposerInvalidationsRY85e9Y$runtime(invalidationsRequested);
            this.nodeIndex = 0;
            this.isComposing = true;
            if (compositionObserverCurrent != null) {
                compositionObserverCurrent.onBeginComposition(getComposition());
            }
            try {
                startRoot();
                Object objNextSlot$runtime = nextSlot$runtime();
                if (objNextSlot$runtime != content && content != null) {
                    updateValue(content);
                }
                LinkComposer$derivedStateObserver$1 linkComposer$derivedStateObserver$1 = this.derivedStateObserver;
                MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
                try {
                    mutableVectorDerivedStateObservers.add(linkComposer$derivedStateObserver$1);
                    if (content != null) {
                        startGroup(200, ComposerKt.getInvocation());
                        Expect_jvmKt.invokeComposable(this, content);
                        endGroup();
                    } else if ((this.forciblyRecompose || this.providersInvalid) && objNextSlot$runtime != null && !Intrinsics.areEqual(objNextSlot$runtime, Composer.INSTANCE.getEmpty())) {
                        startGroup(200, ComposerKt.getInvocation());
                        Expect_jvmKt.invokeComposable(this, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(objNextSlot$runtime, 2));
                        endGroup();
                    } else {
                        skipCurrentGroup();
                    }
                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                    endRoot();
                    if (compositionObserverCurrent != null) {
                        compositionObserverCurrent.onEndComposition(getComposition());
                    }
                    this.isComposing = false;
                    resetInsertBuilder(false);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
                    throw th;
                }
            } finally {
            }
        } finally {
            Trace.INSTANCE.endSection(objBeginSection);
        }
    }

    private final void end(boolean isNode) {
        long jRotateRight;
        long j;
        List<KeyInfo> list;
        List<KeyInfo> list2;
        long jRotateRight2;
        long j2;
        int iPeek2 = this.parentStateStack.peek2() - 1;
        if (getInserting()) {
            int parent = this.builder.getParent();
            int iGroupKey = this.builder.groupKey(parent);
            Object objGroupObjectKey = this.builder.groupObjectKey(parent);
            Object objGroupAux = this.builder.groupAux(parent);
            if (objGroupObjectKey == null) {
                if (objGroupAux != null && iGroupKey == 207 && !Intrinsics.areEqual(objGroupAux, Composer.INSTANCE.getEmpty())) {
                    this.compositeKeyHashCode = Long.rotateRight(((long) objGroupAux.hashCode()) ^ Long.rotateRight(getCompositeKeyHashCode() ^ ((long) iPeek2), 3), 3);
                } else {
                    jRotateRight2 = Long.rotateRight(getCompositeKeyHashCode() ^ ((long) iPeek2), 3);
                    j2 = iGroupKey;
                }
            } else {
                int iOrdinal = objGroupObjectKey instanceof Enum ? ((Enum) objGroupObjectKey).ordinal() : objGroupObjectKey.hashCode();
                jRotateRight2 = Long.rotateRight(getCompositeKeyHashCode() ^ ((long) 0), 3);
                j2 = iOrdinal;
            }
            this.compositeKeyHashCode = Long.rotateRight(jRotateRight2 ^ j2, 3);
        } else {
            int parent2 = this.reader.getParent();
            int iGroupKey2 = this.reader.groupKey(parent2);
            Object objGroupObjectKey2 = this.reader.groupObjectKey(parent2);
            Object objGroupAux2 = this.reader.groupAux(parent2);
            if (objGroupObjectKey2 == null) {
                if (objGroupAux2 != null && iGroupKey2 == 207 && !Intrinsics.areEqual(objGroupAux2, Composer.INSTANCE.getEmpty())) {
                    this.compositeKeyHashCode = Long.rotateRight(((long) objGroupAux2.hashCode()) ^ Long.rotateRight(getCompositeKeyHashCode() ^ ((long) iPeek2), 3), 3);
                } else {
                    jRotateRight = Long.rotateRight(getCompositeKeyHashCode() ^ ((long) iPeek2), 3);
                    j = iGroupKey2;
                }
            } else {
                int iOrdinal2 = objGroupObjectKey2 instanceof Enum ? ((Enum) objGroupObjectKey2).ordinal() : objGroupObjectKey2.hashCode();
                jRotateRight = Long.rotateRight(getCompositeKeyHashCode() ^ ((long) 0), 3);
                j = iOrdinal2;
            }
            this.compositeKeyHashCode = Long.rotateRight(jRotateRight ^ j, 3);
        }
        int i = this.groupNodeCount;
        LinkPending linkPending = this.pending;
        if (linkPending != null && !linkPending.getKeyInfos().isEmpty()) {
            List<KeyInfo> keyInfos = linkPending.getKeyInfos();
            List<KeyInfo> used = linkPending.getUsed();
            Set setFastToSet = ListUtilsKt.fastToSet(used);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = used.size();
            int size2 = keyInfos.size();
            int i2 = 0;
            int i3 = 0;
            int iUpdatedNodeCountOf = 0;
            while (i2 < size2) {
                KeyInfo keyInfo = keyInfos.get(i2);
                if (!setFastToSet.contains(keyInfo)) {
                    this.changeListWriter.removeNode(linkPending.nodePositionOf(keyInfo) + linkPending.getStartIndex(), keyInfo.getNodes());
                    linkPending.updateNodeCount(GroupHandleKt.getGroup(keyInfo.getHandle()), 0);
                    this.reader.reposition(keyInfo.getHandle());
                    recordDelete();
                    this.reader.skipGroup();
                } else if (!linkedHashSet.contains(keyInfo)) {
                    if (i3 < size) {
                        KeyInfo keyInfo2 = used.get(i3);
                        if (keyInfo2 != keyInfo) {
                            int iNodePositionOf = linkPending.nodePositionOf(keyInfo2);
                            linkedHashSet.add(keyInfo2);
                            if (iNodePositionOf != iUpdatedNodeCountOf) {
                                int iUpdatedNodeCountOf2 = linkPending.updatedNodeCountOf(keyInfo2);
                                list = keyInfos;
                                list2 = used;
                                this.changeListWriter.moveNode(iNodePositionOf + linkPending.getStartIndex(), iUpdatedNodeCountOf + linkPending.getStartIndex(), iUpdatedNodeCountOf2);
                                linkPending.registerMoveNode(iNodePositionOf, iUpdatedNodeCountOf, iUpdatedNodeCountOf2);
                            } else {
                                list = keyInfos;
                                list2 = used;
                            }
                        } else {
                            list = keyInfos;
                            list2 = used;
                            i2++;
                        }
                        i3++;
                        iUpdatedNodeCountOf += linkPending.updatedNodeCountOf(keyInfo2);
                        keyInfos = list;
                        used = list2;
                    }
                }
                i2++;
            }
            this.changeListWriter.endNodeMovement();
            if (!keyInfos.isEmpty()) {
                this.reader.skipToGroupEnd();
            }
        }
        boolean inserting = getInserting();
        if (!inserting) {
            int i4 = this.nodeIndex;
            int i5 = this.reader.get_previousSibling();
            SlotTable readerTable$runtime = getReaderTable$runtime();
            int currentGroup = this.reader.getCurrentGroup();
            int[] groups = readerTable$runtime.getAddressSpace().getGroups();
            while (true) {
                int i6 = currentGroup;
                int i7 = i5;
                i5 = i6;
                if (i5 < 0) {
                    break;
                }
                reportFreeMovableContent(GroupHandleKt.makeGroupHandle(this.reader.getParent(), i7, i5));
                this.changeListWriter.removeNode(i4, this.reader.nodeCount(i5));
                this.changeListWriter.endNodeMovement();
                currentGroup = groups[i5 + 1];
            }
            this.changeListWriter.removeTailGroupsAndValues(this.reader.getCurrentGroup(), this.reader.getRemainingSlots());
        }
        if (inserting) {
            if (isNode) {
                this.insertFixups.endNodeInsert();
                i = 1;
            }
            this.lastPlacedChildGroup = this.builder.getParent();
            this.reader.endEmpty();
            this.builder.endGroup();
            if (!this.reader.getInEmpty()) {
                long jLastRoot = this.builder.lastRoot();
                recordInsert(jLastRoot);
                this.inserting = false;
                if (!getReaderTable$runtime().isEmpty()) {
                    long insertAddress = LinkComposerKt.toInsertAddress(jLastRoot);
                    updateChildNodeCount(insertAddress, 0);
                    updateNodeCountOverrides(insertAddress, i);
                }
            }
        } else {
            if (isNode) {
                this.changeListWriter.moveUp();
            }
            long parentHandle = this.reader.getParentHandle();
            if (i != updatedNodeCount(parentHandle)) {
                updateNodeCountOverrides(parentHandle, i);
            }
            int i8 = isNode ? 1 : i;
            this.lastPlacedChildGroup = GroupHandleKt.getGroup(parentHandle);
            this.reader.endGroup();
            this.changeListWriter.endNodeMovement();
            i = i8;
        }
        exitGroup(i, inserting);
    }

    private final void endGroup() {
        end(false);
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime();
        endGroup();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
        this.providersInvalid = LinkComposerKt.asBool(this.providersInvalidStack.pop());
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void changesApplied$runtime() {
        this.providerUpdates = null;
    }

    private final void enterGroup(boolean isNode, LinkPending newPending) {
        Stack.m5062pushimpl(this.pendingStack, this.pending);
        this.pending = newPending;
        this.parentStateStack.push(this.groupNodeCount);
        this.parentStateStack.push(this.rGroupIndex);
        this.parentStateStack.push(this.nodeIndex);
        if (isNode) {
            this.nodeIndex = 0;
        }
        this.groupNodeCount = 0;
        this.rGroupIndex = 0;
        this.lastPlacedChildGroup = -1;
    }

    private final void executeChangesImmediatelyWithoutApplier() {
        SlotTableEditor slotTableEditorOpenEditor = this.slotTable.openEditor();
        try {
            ChangeListKt.asLinkBufferChangeList(this.changes).executeAndFlushAllPendingChanges(ThrowingApplierStub.INSTANCE, slotTableEditorOpenEditor, ThrowingRememberManagerStub.INSTANCE, getErrorContext$runtime());
            Unit unit = Unit.INSTANCE;
        } finally {
            slotTableEditorOpenEditor.close();
        }
    }

    private final void exitGroup(int expectedNodeCount, boolean inserting) {
        LinkPending linkPending = (LinkPending) Stack.m5061popimpl(this.pendingStack);
        if (linkPending != null && !inserting) {
            linkPending.setGroupIndex(linkPending.getGroupIndex() + 1);
        }
        this.pending = linkPending;
        this.nodeIndex = this.parentStateStack.pop() + expectedNodeCount;
        this.rGroupIndex = this.parentStateStack.pop();
        this.groupNodeCount = this.parentStateStack.pop() + expectedNodeCount;
    }

    private final void ensureBuilder() {
        if (this.builder.getIsClosed()) {
            SlotTableBuilder slotTableBuilder = new SlotTableBuilder(this.slotTable.getAddressSpace(), this.slotTable.getRecordSourceInformation(), this.slotTable.getRecordCallByInformation());
            this.builder = slotTableBuilder;
            slotTableBuilder.buildStart();
            this.builderHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void finalizeCompose() {
        this.changeListWriter.finalizeComposition();
        if (!Stack.m5057isEmptyimpl(this.pendingStack)) {
            ComposerKt.composeImmediateRuntimeError("Start/end imbalance");
        }
        cleanUpCompose();
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerCache;
        return persistentCompositionLocalMap != null ? persistentCompositionLocalMap : currentCompositionLocalScope(this.reader.getParent());
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int group) {
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        if (getInserting() && this.builderHasAProvider) {
            int parent = this.builder.getParent();
            while (parent >= 0) {
                if (this.builder.groupKey(parent) == 202 && Intrinsics.areEqual(this.builder.groupObjectKey(parent), ComposerKt.getCompositionLocalMap())) {
                    Object objGroupAux = this.builder.groupAux(parent);
                    Intrinsics.checkNotNull(objGroupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) objGroupAux;
                    this.providerCache = persistentCompositionLocalMap2;
                    return persistentCompositionLocalMap2;
                }
                parent = this.builder.parent(parent);
            }
        }
        if (!this.reader.isEmpty()) {
            while (group >= 0) {
                if (this.reader.groupKey(group) == 202 && Intrinsics.areEqual(this.reader.groupObjectKey(group), ComposerKt.getCompositionLocalMap())) {
                    MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
                    if (mutableIntObjectMap == null || (persistentCompositionLocalMap = mutableIntObjectMap.get(group)) == null) {
                        Object objGroupAux2 = this.reader.groupAux(group);
                        Intrinsics.checkNotNull(objGroupAux2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        persistentCompositionLocalMap = (PersistentCompositionLocalMap) objGroupAux2;
                    }
                    this.providerCache = persistentCompositionLocalMap;
                    return persistentCompositionLocalMap;
                }
                group = this.reader.parentOf(group);
            }
        }
        PersistentCompositionLocalMap persistentCompositionLocalMap3 = this.rootProvider;
        this.providerCache = persistentCompositionLocalMap3;
        return persistentCompositionLocalMap3;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(34:(43:40|(1:42)|46|148|47|171|48|144|49|50|177|51|52|159|53|54|142|55|56|150|57|58|175|59|60|157|61|62|155|63|152|64|(1:66)(1:67)|68|146|69|136|70|140|71|154|72|180)(1:44)|177|51|52|159|53|54|142|55|56|150|57|58|175|59|60|157|61|62|155|63|152|64|(0)(0)|68|146|69|136|70|140|71|154|72|180)|171|48|144|49|50) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0285, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0286, code lost:
    
        r8 = r5;
        r17 = r12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x025d  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void insertMovableContentGuarded(java.util.List<kotlin.Pair<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentStateReference>> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.LinkComposer.insertMovableContentGuarded(java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertMovableContentGuarded$lambda$0$0$0$0(LinkComposer linkComposer, ChangeList changeList, SlotTableReader slotTableReader, long j, MovableContentStateReference movableContentStateReference) {
        ComposerChangeListWriter composerChangeListWriter = linkComposer.changeListWriter;
        ChangeList changeList2 = composerChangeListWriter.getChangeList();
        try {
            composerChangeListWriter.setChangeList(changeList);
            SlotTableReader slotTableReader2 = linkComposer.reader;
            MutableIntIntMap mutableIntIntMap = linkComposer.nodeCountOverrides;
            MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = linkComposer.providerUpdates;
            linkComposer.nodeCountOverrides = null;
            linkComposer.providerUpdates = null;
            try {
                linkComposer.reader = slotTableReader;
                ComposerChangeListWriter composerChangeListWriter2 = linkComposer.changeListWriter;
                boolean implicitRootStart = composerChangeListWriter2.getImplicitRootStart();
                try {
                    composerChangeListWriter2.setImplicitRootStart(false);
                    ComposerChangeListWriter composerChangeListWriter3 = linkComposer.changeListWriter;
                    composerChangeListWriter3.editorCurrentPosition = j;
                    ComposerChangeListWriterAddressMode composerChangeListWriterAddressMode = ComposerChangeListWriterAddressMode.RelativeAddressing;
                    ComposerChangeListWriterAddressMode addressMode = composerChangeListWriter3.getAddressMode();
                    long j2 = composerChangeListWriter3.editorCurrentPosition;
                    composerChangeListWriter3.setAddressMode$runtime(composerChangeListWriterAddressMode);
                    try {
                        linkComposer.invokeMovableContentLambda(movableContentStateReference.getContent$runtime(), movableContentStateReference.getLocals(), movableContentStateReference.getParameter(), true);
                        composerChangeListWriter2.setImplicitRootStart(implicitRootStart);
                        Unit unit = Unit.INSTANCE;
                        composerChangeListWriter.setChangeList(changeList2);
                        return Unit.INSTANCE;
                    } finally {
                        composerChangeListWriter3.setAddressMode$runtime(addressMode);
                        if (addressMode != ComposerChangeListWriterAddressMode.RelativeAddressing) {
                            j2 = -1;
                        }
                        composerChangeListWriter3.editorCurrentPosition = j2;
                    }
                } catch (Throwable th) {
                    composerChangeListWriter2.setImplicitRootStart(implicitRootStart);
                    throw th;
                }
            } finally {
                linkComposer.reader = slotTableReader2;
                linkComposer.nodeCountOverrides = mutableIntIntMap;
                linkComposer.providerUpdates = mutableIntObjectMap;
            }
        } catch (Throwable th2) {
            composerChangeListWriter.setChangeList(changeList2);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0(LinkComposer linkComposer, MovableContentStateReference movableContentStateReference) {
        linkComposer.invokeMovableContentLambda(movableContentStateReference.getContent$runtime(), movableContentStateReference.getLocals(), movableContentStateReference.getParameter(), true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object recomposeMovableContent$default(LinkComposer linkComposer, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, int i, List list, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            controlledComposition = null;
        }
        if ((i2 & 2) != 0) {
            controlledComposition2 = null;
        }
        if ((i2 & 4) != 0) {
            i = -1;
        }
        if ((i2 & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        return linkComposer.recomposeMovableContent(controlledComposition, controlledComposition2, i, list, function0);
    }

    private final <R> R recomposeMovableContent(ControlledComposition from, ControlledComposition to, int address, List<? extends Pair<RecomposeScopeImpl, ? extends Object>> invalidations, Function0<? extends R> block) {
        R rInvoke;
        boolean isComposing = getIsComposing();
        int i = this.nodeIndex;
        try {
            this.isComposing = true;
            this.nodeIndex = 0;
            int size = invalidations.size();
            for (int i2 = 0; i2 < size; i2++) {
                Pair<RecomposeScopeImpl, ? extends Object> pair = invalidations.get(i2);
                RecomposeScopeImpl recomposeScopeImplComponent1 = pair.component1();
                Object objComponent2 = pair.component2();
                if (objComponent2 != null) {
                    tryImminentInvalidation$runtime(recomposeScopeImplComponent1, objComponent2);
                } else {
                    tryImminentInvalidation$runtime(recomposeScopeImplComponent1, null);
                }
            }
            if (from == null || (rInvoke = (R) from.delegateInvalidations(to, address, block)) == null) {
                rInvoke = block.invoke();
            }
            return rInvoke;
        } finally {
            this.isComposing = isComposing;
            this.nodeIndex = i;
        }
    }

    /* JADX WARN: Finally extract failed */
    private final void invokeMovableContentLambda(final MovableContent<Object> content, PersistentCompositionLocalMap locals, final Object parameter, boolean force) {
        startMovableGroup(MovableContentKt.movableContentKey, content);
        updateSlot(parameter);
        long compositeKeyHashCode = getCompositeKeyHashCode();
        try {
            this.compositeKeyHashCode = MovableContentKt.movableContentKey;
            if (getInserting()) {
                this.builder.addFlags(268435456);
            }
            boolean z = false;
            if (!getInserting() && !Intrinsics.areEqual(this.reader.getGroupAux(), locals)) {
                z = true;
            }
            if (z) {
                recordProviderUpdate(locals);
            }
            m5024startAzEfcrM(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m5138getGroup9udXigM(), locals);
            this.providerCache = null;
            if (getInserting() && !force) {
                this.builderHasAProvider = true;
                SlotTableBuilder slotTableBuilder = this.builder;
                this.parentContext.insertMovableContent$runtime(new MovableContentStateReference(content, parameter, getComposition(), this.builder.getTable(), this.builder.getTable().getAddressSpace().anchorOfAddress(slotTableBuilder.parent(slotTableBuilder.getParent())), CollectionsKt.emptyList(), currentCompositionLocalScope(), null));
            } else {
                boolean z2 = this.providersInvalid;
                this.providersInvalid = z;
                this.changeListWriter.seekTo(this.reader.handle(), true);
                ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                composerChangeListWriter.editorCurrentPosition = -1L;
                ComposerChangeListWriterAddressMode composerChangeListWriterAddressMode = ComposerChangeListWriterAddressMode.AnchorAddressing;
                ComposerChangeListWriterAddressMode addressMode = composerChangeListWriter.getAddressMode();
                long j = composerChangeListWriter.editorCurrentPosition;
                composerChangeListWriter.setAddressMode$runtime(composerChangeListWriterAddressMode);
                try {
                    Expect_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(-1241221479, true, new Function2() { // from class: androidx.compose.runtime.LinkComposer$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LinkComposer.invokeMovableContentLambda$lambda$0$0(content, parameter, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }));
                    composerChangeListWriter.setAddressMode$runtime(addressMode);
                    composerChangeListWriter.editorCurrentPosition = addressMode == ComposerChangeListWriterAddressMode.RelativeAddressing ? j : -1L;
                    this.providersInvalid = z2;
                } catch (Throwable th) {
                    composerChangeListWriter.setAddressMode$runtime(addressMode);
                    composerChangeListWriter.editorCurrentPosition = addressMode == ComposerChangeListWriterAddressMode.RelativeAddressing ? j : -1L;
                    throw th;
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeMovableContentLambda$lambda$0$0(MovableContent movableContent, Object obj, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2031@81096L18:LinkComposer.kt#9igjgp");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1241221479, i, -1, "androidx.compose.runtime.LinkComposer.invokeMovableContentLambda.<anonymous>.<anonymous> (LinkComposer.kt:2031)");
            }
            movableContent.getContent().invoke(obj, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final boolean isGroupAfterCurrentReaderPosition(long group) {
        long jHandle = this.reader.handle();
        return jHandle == -1 || LinkComposerKt.firstGroupInTopologicalOrder(getReaderTable$runtime(), group, jHandle) == jHandle;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0288 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void recomposeToGroupEnd() {
        /*
            Method dump skipped, instruction units count: 722
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.LinkComposer.recomposeToGroupEnd():void");
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.handle());
        this.changeListWriter.removeGroup();
    }

    private final void recordInsert(long source) {
        if (this.insertFixups.isEmpty()) {
            this.changeListWriter.insertSlots(this.builder.getTable(), source);
        } else {
            this.changeListWriter.insertSlots(this.builder.getTable(), source, this.insertFixups);
            this.insertFixups = new FixupList();
        }
    }

    private final void recordProviderUpdate(PersistentCompositionLocalMap providers) {
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
            this.providerUpdates = mutableIntObjectMap;
        }
        mutableIntObjectMap.set(this.reader.getCurrentGroup(), providers);
    }

    private final void reportAllMovableContent() {
        if (this.slotTable.containsFlags(536870912)) {
            getComposition().updateMovingInvalidations$runtime();
            ChangeList changeList = new ChangeList();
            setDeferredChanges$runtime(changeList);
            SlotTableReader slotTableReaderOpenReader = this.slotTable.openReader();
            try {
                this.reader = slotTableReaderOpenReader;
                ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                ChangeList changeList2 = composerChangeListWriter.getChangeList();
                try {
                    composerChangeListWriter.setChangeList(changeList);
                    reportFreeMovableContent(slotTableReaderOpenReader.rootHandle());
                    composerChangeListWriter.setChangeList(changeList2);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    composerChangeListWriter.setChangeList(changeList2);
                    throw th;
                }
            } finally {
                slotTableReaderOpenReader.close();
            }
        }
    }

    private static final MovableContentStateReference reportFreeMovableContent$createMovableContentReferenceForGroup(LinkComposer linkComposer, int i, List<MovableContentStateReference> list) {
        Object objGroupObjectKey = linkComposer.reader.groupObjectKey(i);
        Intrinsics.checkNotNull(objGroupObjectKey, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        MovableContent movableContent = (MovableContent) objGroupObjectKey;
        Object obj = linkComposer.reader.get(i, 0);
        List<Pair<RecomposeScopeImpl, Object>> listM5025findInvalidationsVpaz1Sg = LinkComposerKt.m5025findInvalidationsVpaz1Sg(linkComposer.reader, i, linkComposer.invalidations);
        return new MovableContentStateReference(movableContent, obj, linkComposer.getComposition(), linkComposer.getReaderTable$runtime(), linkComposer.getReaderTable$runtime().getAddressSpace().anchorOfAddress(i), listM5025findInvalidationsVpaz1Sg, linkComposer.currentCompositionLocalScope(i), list);
    }

    private static final MovableContentStateReference reportFreeMovableContent$movableContentReferenceFor(LinkComposer linkComposer, int i) {
        boolean z;
        int iFlagsOf = linkComposer.reader.flagsOf(i);
        List listBuild = null;
        if ((iFlagsOf & 268435456) != 268435456) {
            return null;
        }
        if ((iFlagsOf & 536870912) == 536870912) {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            SlotTableReader slotTableReader = linkComposer.reader;
            int iFirstChildOf = slotTableReader.firstChildOf(i);
            loop0: while (iFirstChildOf != -1) {
                if ((linkComposer.reader.flagsOf(iFirstChildOf) & 268435456) == 268435456) {
                    MovableContentStateReference movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor = reportFreeMovableContent$movableContentReferenceFor(linkComposer, iFirstChildOf);
                    if (movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor != null) {
                        listCreateListBuilder.add(movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor);
                    }
                    z = true;
                } else {
                    z = false;
                }
                int iFirstChildOf2 = slotTableReader.firstChildOf(iFirstChildOf);
                if (z || iFirstChildOf2 == -1 || (linkComposer.reader.flagsOf(iFirstChildOf) & 536870912) != 536870912) {
                    int iParentOf = iFirstChildOf;
                    iFirstChildOf = slotTableReader.nextSiblingOf(iFirstChildOf);
                    while (iFirstChildOf == -1) {
                        iParentOf = slotTableReader.parentOf(iParentOf);
                        if (iParentOf == -1 || iParentOf == i) {
                            break loop0;
                        }
                        iFirstChildOf = slotTableReader.nextSiblingOf(iParentOf);
                    }
                } else {
                    iFirstChildOf = iFirstChildOf2;
                }
            }
            listBuild = CollectionsKt.build(listCreateListBuilder);
        }
        return reportFreeMovableContent$createMovableContentReferenceForGroup(linkComposer, i, listBuild);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004c A[PHI: r0
      0x004c: PHI (r0v5 int) = (r0v2 int), (r0v4 int), (r0v9 int) binds: [B:64:0x0138, B:34:0x00a7, B:13:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int reportFreeMovableContent$reportGroup(androidx.compose.runtime.LinkComposer r16, long r17, boolean r19, int r20) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.LinkComposer.reportFreeMovableContent$reportGroup(androidx.compose.runtime.LinkComposer, long, boolean, int):int");
    }

    private final void reportFreeMovableContent(long groupBeingRemoved) {
        int group = GroupHandleKt.getGroup(groupBeingRemoved);
        boolean z = (this.reader.flagsOf(group) & 8388608) == 8388608;
        if (z) {
            this.changeListWriter.endNodeMovement();
            this.changeListWriter.moveDown(this.reader.node(group));
        }
        reportFreeMovableContent$reportGroup(this, groupBeingRemoved, z, 0);
        this.changeListWriter.endNodeMovement();
        if (z) {
            this.changeListWriter.moveUp();
        }
    }

    private final void resetInsertBuilder(boolean dispose) {
        if (!this.builder.getIsClosed()) {
            SlotTable slotTableBuild = this.builder.build();
            if (dispose) {
                slotTableBuild.dispose();
            }
        }
        SlotTableBuilder slotTableBuilder = new SlotTableBuilder(this.slotTable.getAddressSpace(), false, false);
        slotTableBuilder.close();
        this.builder = slotTableBuilder;
    }

    private final RecomposeScopeImpl requireRecomposeScope(int group) {
        Object obj = this.reader.get(group, 0);
        if (Intrinsics.areEqual(obj, Composer.INSTANCE.getEmpty())) {
            ComposerKt.composeImmediateRuntimeError("Cannot obtain RecomposeScope. Group does not have a corresponding slot.");
        }
        if (!(obj instanceof RecomposeScopeImpl)) {
            ComposerKt.composeImmediateRuntimeError("Expected a RecomposeScope in the first non-utility slot, found " + obj + '.');
        }
        return (RecomposeScopeImpl) obj;
    }

    private final boolean requiresRecomposition(int group) {
        return this.reader.hasRecomposeRequired(group);
    }

    private final int rGroupIndexOf(int group) {
        int iFirstChildOf;
        int iParentOf = this.reader.parentOf(group);
        if (iParentOf < 0) {
            iFirstChildOf = getReaderTable$runtime().getRoot();
        } else {
            iFirstChildOf = this.reader.firstChildOf(iParentOf);
        }
        int[] groups = getReaderTable$runtime().getAddressSpace().getGroups();
        int i = 0;
        while (iFirstChildOf >= 0 && iFirstChildOf != group) {
            if (!this.reader.hasObjectKey(iFirstChildOf)) {
                i++;
            }
            iFirstChildOf = groups[iFirstChildOf + 1];
        }
        return i;
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodeCount();
        this.reader.skipToGroupEnd();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0120  */
    /* JADX INFO: renamed from: start-AzEfcrM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m5024startAzEfcrM(int r18, java.lang.Object r19, int r20, java.lang.Object r21) {
        /*
            Method dump skipped, instruction units count: 597
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.LinkComposer.m5024startAzEfcrM(int, java.lang.Object, int, java.lang.Object):void");
    }

    private final void startGroup(int key) {
        m5024startAzEfcrM(key, null, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
    }

    private final void startGroup(int key, Object dataKey) {
        m5024startAzEfcrM(key, dataKey, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
    }

    private final void startReaderGroup(boolean isNode, Object data) {
        if (isNode) {
            this.reader.startNode();
            return;
        }
        if (data != null && this.reader.getGroupAux() != data) {
            this.changeListWriter.updateAuxData(data);
        }
        this.reader.startGroup();
    }

    private final void startRoot() {
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        m5024startAzEfcrM(100, null, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
        this.parentContext.startComposing$runtime();
        PersistentCompositionLocalMap compositionLocalScope$runtime = this.parentContext.getCompositionLocalScope$runtime();
        this.providersInvalidStack.push(LinkComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = changed(compositionLocalScope$runtime);
        this.providerCache = null;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation();
        }
        if (!getSourceMarkersEnabled()) {
            setSourceMarkersEnabled$runtime(this.parentContext.getCollectingSourceInformation());
        }
        if (getSourceMarkersEnabled()) {
            CompositionLocal<CompositionErrorContext> localCompositionErrorContext = CompositionErrorContextKt.getLocalCompositionErrorContext();
            Intrinsics.checkNotNull(localCompositionErrorContext, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
            compositionLocalScope$runtime = compositionLocalScope$runtime.putValue(localCompositionErrorContext, new StaticValueHolder(getErrorContext$runtime()));
        }
        this.rootProvider = compositionLocalScope$runtime;
        Set<CompositionData> set = (Set) CompositionLocalMapKt.read(compositionLocalScope$runtime, InspectionTablesKt.getLocalInspectionTables());
        if (set != null) {
            set.add(getCompositionData());
            this.parentContext.recordInspectionTable$runtime(set);
        }
        m5024startAzEfcrM(Long.hashCode(this.parentContext.getCompositeKeyHashCode()), null, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
    }

    private final List<ComposeStackTraceFrame> stackTraceForGroup(int group, Integer dataOffset) {
        if (!getSourceMarkersEnabled()) {
            return CollectionsKt.emptyList();
        }
        SlotTableReader slotTableReaderOpenReader = this.slotTable.openReader();
        try {
            return SlotTableReaderKt.traceForGroup(slotTableReaderOpenReader, group, dataOffset);
        } finally {
            slotTableReaderOpenReader.close();
        }
    }

    public final void updateCachedValue$runtime(Object value) {
        if (value instanceof RememberObserver) {
            LinkRememberObserverHolder linkRememberObserverHolder = new LinkRememberObserverHolder((RememberObserver) value, getReaderTable$runtime().getAddressSpace().anchorOfAddress(this.lastPlacedChildGroup));
            if (getInserting()) {
                this.changeListWriter.remember(linkRememberObserverHolder);
            }
            this.abandonSet.add(value);
            value = linkRememberObserverHolder;
        }
        updateValue(value);
    }

    private final void updateChildNodeCount(long virtualGroup, int count) {
        if (updatedNodeCount(virtualGroup) != count) {
            if (LinkComposerKt.isInsertHandle(virtualGroup)) {
                MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
                if (mutableIntIntMap == null) {
                    mutableIntIntMap = new MutableIntIntMap(0, 1, null);
                    this.nodeCountVirtualOverrides = mutableIntIntMap;
                }
                mutableIntIntMap.set(GroupHandleKt.getGroup(virtualGroup), count);
                return;
            }
            MutableIntIntMap mutableIntIntMap2 = this.nodeCountOverrides;
            if (mutableIntIntMap2 == null) {
                mutableIntIntMap2 = new MutableIntIntMap(0, 1, null);
                this.nodeCountOverrides = mutableIntIntMap2;
            }
            LinkComposerKt.isInsertHandle(virtualGroup);
            mutableIntIntMap2.set(GroupHandleKt.getGroup(virtualGroup), count);
        }
    }

    private final void updateNodeCountOverrides(long virtualHandle, int newCount) {
        int iUpdatedNodeCount = updatedNodeCount(virtualHandle);
        if (iUpdatedNodeCount != newCount) {
            int i = newCount - iUpdatedNodeCount;
            int iM5055getSizeimpl = Stack.m5055getSizeimpl(this.pendingStack) - 1;
            while (GroupHandleKt.getGroup(virtualHandle) != -1) {
                int iUpdatedNodeCount2 = updatedNodeCount(virtualHandle) + i;
                updateChildNodeCount(virtualHandle, iUpdatedNodeCount2);
                int i2 = iM5055getSizeimpl;
                while (true) {
                    if (-1 < i2) {
                        LinkPending linkPending = (LinkPending) Stack.m5060peekimpl(this.pendingStack, i2);
                        if (linkPending != null && linkPending.updateNodeCount(GroupHandleKt.getGroup(virtualHandle), iUpdatedNodeCount2)) {
                            iM5055getSizeimpl = i2 - 1;
                            break;
                        }
                        i2--;
                    } else {
                        break;
                    }
                }
                if (LinkComposerKt.isInsertHandle(virtualHandle)) {
                    virtualHandle = this.reader.getParentHandle();
                } else {
                    int[] groups = getReaderTable$runtime().getAddressSpace().getGroups();
                    int group = GroupHandleKt.getGroup(virtualHandle);
                    if ((groups[group + 4] & 8388608) == 8388608) {
                        return;
                    }
                    virtualHandle = (((long) UInt.m12488constructorimpl(groups[group + 2])) & 4294967295L) | (((long) 0) << 32);
                }
            }
        }
    }

    private final void updateSlot(Object value) {
        nextSlot$runtime();
        updateValue(value);
    }

    private final int updatedNodeCount(long virtualHandle) {
        int orDefault;
        if (!LinkComposerKt.isInsertHandle(virtualHandle)) {
            LinkComposerKt.isInsertHandle(virtualHandle);
            int group = GroupHandleKt.getGroup(virtualHandle);
            MutableIntIntMap mutableIntIntMap = this.nodeCountOverrides;
            return (mutableIntIntMap == null || (orDefault = mutableIntIntMap.getOrDefault(group, -1)) < 0) ? getReaderTable$runtime().getAddressSpace().getGroups()[group + 4] & GroupFlagsSpec.CHILD_NODE_COUNT_MASK : orDefault;
        }
        MutableIntIntMap mutableIntIntMap2 = this.nodeCountVirtualOverrides;
        if (mutableIntIntMap2 != null) {
            return mutableIntIntMap2.getOrDefault(GroupHandleKt.getGroup(virtualHandle), 0);
        }
        return 0;
    }

    private final Object unwrapRememberObserverHolder(Object obj) {
        return obj instanceof RememberObserverHolder ? ((RememberObserverHolder) obj).getWrapped() : obj;
    }

    private final <R> R withReader(SlotTableReader reader, Function0<? extends R> block) {
        SlotTableReader slotTableReader = this.reader;
        MutableIntIntMap mutableIntIntMap = this.nodeCountOverrides;
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
        this.nodeCountOverrides = null;
        this.providerUpdates = null;
        try {
            this.reader = reader;
            return block.invoke();
        } finally {
            this.reader = slotTableReader;
            this.nodeCountOverrides = mutableIntIntMap;
            this.providerUpdates = mutableIntObjectMap;
        }
    }

    private final void enterRecomposeScope(RecomposeScopeImpl scope) {
        scope.start(this.compositionToken);
        CompositionObserver compositionObserverCurrent = this.observerHolder.current();
        if (compositionObserverCurrent != null) {
            compositionObserverCurrent.onScopeEnter(scope);
        }
    }

    private final Function1<Composition, Unit> exitRecomposeScope(RecomposeScopeImpl scope) {
        CompositionObserver compositionObserverCurrent = this.observerHolder.current();
        if (compositionObserverCurrent != null) {
            compositionObserverCurrent.onScopeExit(scope);
        }
        return scope.end(this.compositionToken);
    }

    private final void updateCompositeKeyWhenWeEnterGroup(int groupKey, int rGroupIndex, Object dataKey, Object data) {
        if (dataKey == null) {
            if (data != null && groupKey == 207 && !Intrinsics.areEqual(data, Composer.INSTANCE.getEmpty())) {
                this.compositeKeyHashCode = ((long) rGroupIndex) ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ ((long) data.hashCode()), 3);
                return;
            } else {
                this.compositeKeyHashCode = ((long) rGroupIndex) ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ ((long) groupKey), 3);
                return;
            }
        }
        if (!(dataKey instanceof Enum)) {
            this.compositeKeyHashCode = ((long) 0) ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ ((long) dataKey.hashCode()), 3);
        } else {
            this.compositeKeyHashCode = ((long) 0) ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ ((long) ((Enum) dataKey).ordinal()), 3);
        }
    }

    private final void updateCompositeKeyWhenWeEnterGroupKeyHash(int groupKey, int rGroupIndex) {
        this.compositeKeyHashCode = ((long) rGroupIndex) ^ Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ ((long) groupKey), 3);
    }

    private final void updateCompositeKeyWhenWeExitGroup(int groupKey, int rGroupIndex, Object dataKey, Object data) {
        if (dataKey == null) {
            if (data != null && groupKey == 207 && !Intrinsics.areEqual(data, Composer.INSTANCE.getEmpty())) {
                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ ((long) rGroupIndex), 3) ^ ((long) data.hashCode()), 3);
                return;
            } else {
                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ ((long) rGroupIndex), 3) ^ ((long) groupKey), 3);
                return;
            }
        }
        if (!(dataKey instanceof Enum)) {
            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ ((long) 0), 3) ^ ((long) dataKey.hashCode()), 3);
        } else {
            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ ((long) 0), 3) ^ ((long) ((Enum) dataKey).ordinal()), 3);
        }
    }

    private final void updateCompositeKeyWhenWeExitGroupKeyHash(int groupKey, int rGroupIndex) {
        this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(getCompositeKeyHashCode() ^ ((long) rGroupIndex), 3) ^ ((long) groupKey), 3);
    }

    private final void validateNodeExpected() {
        if (!this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.nodeExpected = false;
    }

    private final void validateNodeNotExpected() {
        if (this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
        }
    }

    /* JADX INFO: compiled from: LinkComposer.kt */
    @Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\"\u001a\u00020#J\u0015\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0010¢\u0006\u0002\b'J\u0015\u0010(\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0010¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0010¢\u0006\u0002\b3J*\u00108\u001a\u00020#2\u0006\u0010+\u001a\u00020,2\u0011\u00109\u001a\r\u0012\u0004\u0012\u00020#0:¢\u0006\u0002\b;H\u0011¢\u0006\u0004\b<\u0010=J8\u0010>\u001a\b\u0012\u0004\u0012\u0002020?2\u0006\u0010+\u001a\u00020,2\u0006\u0010@\u001a\u00020A2\u0011\u00109\u001a\r\u0012\u0004\u0012\u00020#0:¢\u0006\u0002\b;H\u0011¢\u0006\u0004\bB\u0010CJ1\u0010D\u001a\b\u0012\u0004\u0012\u0002020?2\u0006\u0010+\u001a\u00020,2\u0006\u0010@\u001a\u00020A2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002020?H\u0010¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0010¢\u0006\u0002\bJJ\r\u0010N\u001a\u00020LH\u0010¢\u0006\u0002\bTJ\u000e\u0010U\u001a\u00020#2\u0006\u00101\u001a\u00020LJ\u001b\u0010V\u001a\u00020#2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0010¢\u0006\u0002\bXJ\r\u0010Y\u001a\u00020#H\u0010¢\u0006\u0002\bZJ\r\u0010[\u001a\u00020#H\u0010¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020#2\u0006\u0010^\u001a\u00020_H\u0010¢\u0006\u0002\b`J\u0015\u0010a\u001a\u00020#2\u0006\u0010^\u001a\u00020_H\u0010¢\u0006\u0002\bbJ\u0017\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010^\u001a\u00020_H\u0010¢\u0006\u0002\beJ)\u0010f\u001a\u00020#2\u0006\u0010^\u001a\u00020_2\u0006\u0010g\u001a\u00020d2\n\u0010h\u001a\u0006\u0012\u0002\b\u00030iH\u0010¢\u0006\u0002\bjJ\u0015\u0010k\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0010¢\u0006\u0002\blJ\u0016\u0010p\u001a\u00020q2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020#0:H\u0016R\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0090\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0010R\u0014\u0010 \u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0010R\u0014\u00104\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R+\u0010M\u001a\u00020L2\u0006\u0010K\u001a\u00020L8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0014\u0010+\u001a\u00020m8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bn\u0010o¨\u0006s"}, d2 = {"Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHashCode", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "collectingParameterInformation", "", "collectingSourceInformation", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "<init>", "(Landroidx/compose/runtime/LinkComposer;JZZLandroidx/compose/runtime/CompositionObserverHolder;)V", "getCompositeKeyHashCode$runtime", "()J", "J", "getCollectingParameterInformation$runtime", "()Z", "getCollectingSourceInformation$runtime", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "inspectionTables", "", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "()Ljava/util/Set;", "setInspectionTables", "(Ljava/util/Set;)V", "composers", "Landroidx/compose/runtime/LinkComposer;", "getComposers", "collectingCallByInformation", "getCollectingCallByInformation$runtime", "stackTraceEnabled", "getStackTraceEnabled$runtime", "dispose", "", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime", "unregisterComposer", "unregisterComposer$runtime", "registerComposition", "composition", "Landroidx/compose/runtime/ControlledComposition;", "registerComposition$runtime", "unregisterComposition", "unregisterComposition$runtime", "reportPausedScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "reportPausedScope$runtime", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "composeInitial", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitialPaused", "Landroidx/collection/ScatterSet;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function2;)Landroidx/collection/ScatterSet;", "recomposePaused", "invalidScopes", "recomposePaused$runtime", "invalidate", "invalidate$runtime", "invalidateScope", "invalidateScope$runtime", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompositionLocalScope$runtime", "updateCompositionLocalScope", "recordInspectionTable", "table", "recordInspectionTable$runtime", "startComposing", "startComposing$runtime", "doneComposing", "doneComposing$runtime", "insertMovableContent", ReferenceElement.ELEMENT, "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContent$runtime", "deletedMovableContent", "deletedMovableContent$runtime", "movableContentStateResolve", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve$runtime", "movableContentStateReleased", "data", "applier", "Landroidx/compose/runtime/Applier;", "movableContentStateReleased$runtime", "reportRemovedComposition", "reportRemovedComposition$runtime", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;
        private final long compositeKeyHashCode;
        private Set<Set<CompositionData>> inspectionTables;
        private final CompositionObserverHolder observerHolder;
        private final Set<LinkComposer> composers = new LinkedHashSet();

        /* JADX INFO: renamed from: compositionLocalScope$delegate, reason: from kotlin metadata */
        private final MutableState compositionLocalScope = SnapshotStateKt.mutableStateOf(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), SnapshotStateKt.referentialEqualityPolicy());

        public CompositionContextImpl(long j, boolean z, boolean z2, CompositionObserverHolder compositionObserverHolder) {
            this.compositeKeyHashCode = j;
            this.collectingParameterInformation = z;
            this.collectingSourceInformation = z2;
            this.observerHolder = compositionObserverHolder;
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* JADX INFO: renamed from: getCompositeKeyHashCode$runtime, reason: from getter */
        public long getCompositeKeyHashCode() {
            return this.compositeKeyHashCode;
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* JADX INFO: renamed from: getCollectingParameterInformation$runtime, reason: from getter */
        public boolean getCollectingParameterInformation() {
            return this.collectingParameterInformation;
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* JADX INFO: renamed from: getCollectingSourceInformation$runtime, reason: from getter */
        public boolean getCollectingSourceInformation() {
            return this.collectingSourceInformation;
        }

        @Override // androidx.compose.runtime.CompositionContext
        /* JADX INFO: renamed from: getObserverHolder$runtime, reason: from getter */
        public CompositionObserverHolder getObserverHolder() {
            return this.observerHolder;
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        public final void setInspectionTables(Set<Set<CompositionData>> set) {
            this.inspectionTables = set;
        }

        public final Set<LinkComposer> getComposers() {
            return this.composers;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingCallByInformation$runtime() {
            return LinkComposer.this.parentContext.getCollectingCallByInformation$runtime();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getStackTraceEnabled$runtime() {
            return LinkComposer.this.parentContext.getStackTraceEnabled$runtime();
        }

        public final void dispose() {
            if (this.composers.isEmpty()) {
                return;
            }
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                for (LinkComposer linkComposer : this.composers) {
                    Iterator<Set<CompositionData>> it = set.iterator();
                    while (it.hasNext()) {
                        it.next().remove(linkComposer.getCompositionData());
                    }
                }
            }
            this.composers.clear();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime(Composer composer) {
            super.registerComposer$runtime(composer);
            this.composers.add(LinkComposerKt.asLinkComposer(composer));
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime(Composer composer) {
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    ((Set) it.next()).remove(LinkComposerKt.asLinkComposer(composer).getCompositionData());
                }
            }
            TypeIntrinsics.asMutableCollection(this.composers).remove(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposition$runtime(ControlledComposition composition) {
            LinkComposer.this.parentContext.registerComposition$runtime(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime(ControlledComposition composition) {
            LinkComposer.this.parentContext.unregisterComposition$runtime(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportPausedScope$runtime(RecomposeScopeImpl scope) {
            LinkComposer.this.parentContext.reportPausedScope$runtime(scope);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext getEffectCoroutineContext() {
            return LinkComposer.this.parentContext.getEffectCoroutineContext();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void composeInitial$runtime(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) {
            LinkComposer.this.parentContext.composeInitial$runtime(composition, content);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public ScatterSet<RecomposeScopeImpl> composeInitialPaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, Function2<? super Composer, ? super Integer, Unit> content) {
            return LinkComposer.this.parentContext.composeInitialPaused$runtime(composition, shouldPause, content);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public ScatterSet<RecomposeScopeImpl> recomposePaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, ScatterSet<RecomposeScopeImpl> invalidScopes) {
            return LinkComposer.this.parentContext.recomposePaused$runtime(composition, shouldPause, invalidScopes);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime(ControlledComposition composition) {
            LinkComposer.this.parentContext.invalidate$runtime(LinkComposer.this.getComposition());
            LinkComposer.this.parentContext.invalidate$runtime(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidateScope$runtime(RecomposeScopeImpl scope) {
            LinkComposer.this.parentContext.invalidateScope$runtime(scope);
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            return (PersistentCompositionLocalMap) this.compositionLocalScope.getValue();
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            this.compositionLocalScope.setValue(persistentCompositionLocalMap);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public PersistentCompositionLocalMap getCompositionLocalScope$runtime() {
            return getCompositionLocalScope();
        }

        public final void updateCompositionLocalScope(PersistentCompositionLocalMap scope) {
            setCompositionLocalScope(scope);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void recordInspectionTable$runtime(Set<CompositionData> table) {
            HashSet hashSet = this.inspectionTables;
            if (hashSet == null) {
                hashSet = new HashSet();
                this.inspectionTables = hashSet;
            }
            hashSet.add(table);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void startComposing$runtime() {
            LinkComposer.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime() {
            LinkComposer.this.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime(MovableContentStateReference reference) {
            LinkComposer.this.parentContext.insertMovableContent$runtime(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void deletedMovableContent$runtime(MovableContentStateReference reference) {
            LinkComposer.this.parentContext.deletedMovableContent$runtime(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference reference) {
            return LinkComposer.this.parentContext.movableContentStateResolve$runtime(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void movableContentStateReleased$runtime(MovableContentStateReference reference, MovableContentState data, Applier<?> applier) {
            LinkComposer.this.parentContext.movableContentStateReleased$runtime(reference, data, applier);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportRemovedComposition$runtime(ControlledComposition composition) {
            LinkComposer.this.parentContext.reportRemovedComposition$runtime(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public Composition getComposition$runtime() {
            return LinkComposer.this.getComposition();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CancellationHandle scheduleFrameEndCallback(Function0<Unit> action) {
            return LinkComposer.this.parentContext.scheduleFrameEndCallback(action);
        }
    }

    /* JADX INFO: compiled from: LinkComposer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/LinkComposer$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;", "Landroidx/compose/runtime/LinkComposer;", "<init>", "(Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;", "onRemembered", "", "onAbandoned", "onForgotten", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CompositionContextHolder implements RememberObserver {
        public static final int $stable = 8;
        private final CompositionContextImpl ref;

        @Override // androidx.compose.runtime.RememberObserver
        public void onRemembered() {
        }

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            this.ref = compositionContextImpl;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onForgotten() {
            this.ref.dispose();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.runtime.PersistentCompositionLocalMap, java.lang.Object] */
    private final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap parentScope, PersistentCompositionLocalMap currentProviders) {
        PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builderBuilder2 = parentScope.builder2();
        builderBuilder2.putAll(currentProviders);
        ?? Build2 = builderBuilder2.build2();
        startGroup(204, ComposerKt.getProviderMaps());
        updateSlot(Build2);
        updateSlot(currentProviders);
        endGroup();
        return Build2;
    }
}
