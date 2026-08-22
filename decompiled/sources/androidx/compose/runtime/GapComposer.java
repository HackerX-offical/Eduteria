package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.GroupKind;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.GapAnchorKt;
import androidx.compose.runtime.composer.gapbuffer.KeyInfo;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList;
import androidx.compose.runtime.composer.gapbuffer.changelist.ChangeListKt;
import androidx.compose.runtime.composer.gapbuffer.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.FixupList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.ComposeStackTraceBuilderKt;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionErrorContext;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.runtime.tooling.ObjectLocation;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.reference.element.ReferenceElement;

/* JADX INFO: compiled from: GapComposer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000·\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\f\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001?\b\u0001\u0018\u00002\u00020\u0001:\u0004\u0087\u0003\u0088\u0003BQ\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001eH\u0017J\b\u0010u\u001a\u00020sH\u0017J\u0010\u0010v\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001eH\u0017J\b\u0010w\u001a\u00020sH\u0017J\b\u0010x\u001a\u00020sH\u0017J\b\u0010y\u001a\u00020sH\u0017J\u001b\u0010~\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001e2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0017J\t\u0010\u0081\u0001\u001a\u00020sH\u0017J\t\u0010\u0082\u0001\u001a\u00020sH\u0002J\t\u0010\u0083\u0001\u001a\u00020sH\u0002J\t\u0010\u0084\u0001\u001a\u00020sH\u0002J\u000f\u0010\u0085\u0001\u001a\u00020sH\u0010¢\u0006\u0003\b\u0086\u0001J\t\u0010\u0094\u0001\u001a\u00020sH\u0016J\u001a\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u000e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020s0\u0098\u0001H\u0016J\u000f\u0010\u0099\u0001\u001a\u00020sH\u0010¢\u0006\u0003\b\u009a\u0001J\u000f\u0010\u009b\u0001\u001a\u00020sH\u0010¢\u0006\u0003\b\u009c\u0001J\u000e\u0010'\u001a\u00020(H\u0010¢\u0006\u0003\b\u009d\u0001J\u0011\u0010\u009e\u0001\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001eH\u0002J\u001c\u0010\u009e\u0001\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001e2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0002J\t\u0010\u009f\u0001\u001a\u00020sH\u0002J\t\u0010 \u0001\u001a\u00020sH\u0002J\t\u0010¡\u0001\u001a\u00020sH\u0016J\t\u0010¢\u0001\u001a\u00020sH\u0016J!\u0010£\u0001\u001a\u00020s\"\u0005\b\u0000\u0010¤\u00012\u000f\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u0003H¤\u00010\u0098\u0001H\u0016J\t\u0010¦\u0001\u001a\u00020sH\u0016J\t\u0010§\u0001\u001a\u00020sH\u0016J\u001c\u0010¨\u0001\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001e2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\t\u0010©\u0001\u001a\u00020sH\u0016J\t\u0010ª\u0001\u001a\u00020sH\u0016J\t\u0010«\u0001\u001a\u00020sH\u0016J\u000f\u0010¬\u0001\u001a\u00020sH\u0010¢\u0006\u0003\b\u00ad\u0001J\u000f\u0010®\u0001\u001a\u00020sH\u0010¢\u0006\u0003\b¯\u0001J\u0012\u0010³\u0001\u001a\u00020s2\u0007\u0010´\u0001\u001a\u00020\u001eH\u0016JJ\u0010µ\u0001\u001a\u00020s\"\u0005\b\u0000\u0010¶\u0001\"\u0005\b\u0001\u0010¤\u00012\u0007\u0010C\u001a\u0003H¶\u00012\"\u0010·\u0001\u001a\u001d\u0012\u0005\u0012\u0003H¤\u0001\u0012\u0005\u0012\u0003H¶\u0001\u0012\u0004\u0012\u00020s0¸\u0001¢\u0006\u0003\b¹\u0001H\u0016¢\u0006\u0003\u0010º\u0001J\"\u0010»\u0001\u001a\u00030\u0080\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u0080\u00012\n\u0010½\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0017J\f\u0010¾\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0001J\f\u0010¿\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0001J\u0014\u0010À\u0001\u001a\u00020(2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0017J\u0014\u0010Á\u0001\u001a\u00020(2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030Â\u0001H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030Ã\u0001H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030Ä\u0001H\u0017J\u0011\u0010À\u0001\u001a\u00020(2\u0006\u0010C\u001a\u00020(H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030Å\u0001H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030\u008d\u0001H\u0017J\u0012\u0010À\u0001\u001a\u00020(2\u0007\u0010C\u001a\u00030Æ\u0001H\u0017J\u0011\u0010À\u0001\u001a\u00020(2\u0006\u0010C\u001a\u00020\u001eH\u0017J2\u0010Ç\u0001\u001a\u0003H¤\u0001\"\u0005\b\u0000\u0010¤\u00012\u0007\u0010È\u0001\u001a\u00020(2\u000f\u0010·\u0001\u001a\n\u0012\u0005\u0012\u0003H¤\u00010\u0098\u0001H\u0087\b¢\u0006\u0003\u0010É\u0001J\u0014\u0010Ê\u0001\u001a\u00020s2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0002J\u0014\u0010Ë\u0001\u001a\u00020s2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0001J\u0014\u0010Ì\u0001\u001a\u00020s2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0001J\t\u0010Í\u0001\u001a\u00020\u001eH\u0002J\u0019\u0010Ó\u0001\u001a\u00020s2\u000e\u0010Ô\u0001\u001a\t\u0012\u0004\u0012\u00020s0\u0098\u0001H\u0016J\t\u0010Õ\u0001\u001a\u000200H\u0002J\u0012\u0010Õ\u0001\u001a\u0002002\u0007\u0010Ú\u0001\u001a\u00020\u001eH\u0002J\u001b\u0010Û\u0001\u001a\u0002002\u0007\u0010Ü\u0001\u001a\u0002002\u0007\u0010Ý\u0001\u001a\u000200H\u0002J\u0016\u0010Þ\u0001\u001a\u00020s2\u000b\u0010C\u001a\u0007\u0012\u0002\b\u00030ß\u0001H\u0017J\u0012\u0010à\u0001\u001a\u00020s2\u0007\u0010á\u0001\u001a\u000200H\u0002J\t\u0010â\u0001\u001a\u00020sH\u0017J&\u0010ã\u0001\u001a\u00020s2\u0015\u0010ä\u0001\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030ß\u00010å\u0001H\u0017¢\u0006\u0003\u0010æ\u0001J\t\u0010ç\u0001\u001a\u00020sH\u0017J'\u0010è\u0001\u001a\u0003H¤\u0001\"\u0005\b\u0000\u0010¤\u00012\u000e\u0010t\u001a\n\u0012\u0005\u0012\u0003H¤\u00010é\u0001H\u0017¢\u0006\u0003\u0010ê\u0001J\t\u0010ë\u0001\u001a\u00020\u0005H\u0016J\t\u0010ï\u0001\u001a\u00020sH\u0002J\t\u0010ð\u0001\u001a\u00020sH\u0002J\t\u0010ñ\u0001\u001a\u00020sH\u0002J\u001e\u0010ò\u0001\u001a\u00020s2\u0007\u0010ó\u0001\u001a\u00020(2\n\u0010ô\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0002J<\u0010õ\u0001\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001e2\n\u0010ö\u0001\u001a\u0005\u0018\u00010\u0080\u00012\b\u0010÷\u0001\u001a\u00030ø\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0002¢\u0006\u0006\bù\u0001\u0010ú\u0001J\u001d\u0010û\u0001\u001a\u00020s2\u0007\u0010ó\u0001\u001a\u00020(2\t\u0010ü\u0001\u001a\u0004\u0018\u00010\u001aH\u0002J\u001b\u0010ý\u0001\u001a\u00020s2\u0007\u0010þ\u0001\u001a\u00020\u001e2\u0007\u0010\u0087\u0001\u001a\u00020(H\u0002J\u0012\u0010ÿ\u0001\u001a\u00020s2\u0007\u0010ó\u0001\u001a\u00020(H\u0002J\t\u0010\u0080\u0002\u001a\u00020sH\u0002J\u0012\u0010\u0081\u0002\u001a\u00020\u001e2\u0007\u0010\u0082\u0002\u001a\u00020\u001eH\u0002J\u001b\u0010\u0083\u0002\u001a\u00020s2\u0007\u0010Ú\u0001\u001a\u00020\u001e2\u0007\u0010\u0084\u0002\u001a\u00020\u001eH\u0002J-\u0010\u0085\u0002\u001a\u00020\u001e2\u0007\u0010\u0086\u0002\u001a\u00020\u001e2\u0007\u0010Ú\u0001\u001a\u00020\u001e2\u0007\u0010\u0087\u0002\u001a\u00020\u001e2\u0007\u0010\u0088\u0002\u001a\u00020\u001eH\u0002J\u0012\u0010\u0089\u0002\u001a\u00020\u001e2\u0007\u0010Ú\u0001\u001a\u00020\u001eH\u0002J\u0012\u0010\u008a\u0002\u001a\u00020\u001e2\u0007\u0010Ú\u0001\u001a\u00020\u001eH\u0002J\u001b\u0010\u008b\u0002\u001a\u00020s2\u0007\u0010Ú\u0001\u001a\u00020\u001e2\u0007\u0010\u008c\u0002\u001a\u00020\u001eH\u0002J\t\u0010\u008d\u0002\u001a\u00020sH\u0002J$\u0010\u008e\u0002\u001a\u00020s2\u0007\u0010\u008f\u0002\u001a\u00020\u001e2\u0007\u0010\u0090\u0002\u001a\u00020\u001e2\u0007\u0010\u0091\u0002\u001a\u00020\u001eH\u0002J\u001b\u0010\u0092\u0002\u001a\u00020s2\u0007\u0010Ú\u0001\u001a\u00020\u001e2\u0007\u0010\u0093\u0002\u001a\u00020\u001eH\u0002J6\u0010\u0094\u0002\u001a\b0\u008d\u0001j\u0003`\u008e\u00012\u0007\u0010Ú\u0001\u001a\u00020\u001e2\u0007\u0010\u0087\u0002\u001a\u00020\u001e2\r\u0010\u0095\u0002\u001a\b0\u008d\u0001j\u0003`\u008e\u0001H\u0002¢\u0006\u0003\u0010\u0096\u0002J\u0016\u0010\u0097\u0002\u001a\u00020\u001e*\u00020M2\u0007\u0010Ú\u0001\u001a\u00020\u001eH\u0002J$\u0010\u0098\u0002\u001a\u00020(2\u0007\u0010\u0099\u0002\u001a\u00020B2\n\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u0080\u0001H\u0010¢\u0006\u0003\b\u009b\u0002J\u000f\u0010\u009c\u0002\u001a\u00020\u001eH\u0011¢\u0006\u0003\b\u009d\u0002J\t\u0010\u009e\u0002\u001a\u00020sH\u0017J\t\u0010\u009f\u0002\u001a\u00020sH\u0002J\u001b\u0010 \u0002\u001a\u00020(2\u0007\u0010¡\u0002\u001a\u00020(2\u0007\u0010¢\u0002\u001a\u00020\u001eH\u0017J\t\u0010£\u0002\u001a\u00020sH\u0017J\u0012\u0010¤\u0002\u001a\u00020s2\u0007\u0010À\u0001\u001a\u00020(H\u0017J\u0012\u0010¥\u0002\u001a\u00030¦\u00022\u0006\u0010t\u001a\u00020\u001eH\u0017J\t\u0010§\u0002\u001a\u00020sH\u0002J\u0012\u0010¨\u0002\u001a\u00020s2\u0007\u0010\u0099\u0002\u001a\u00020BH\u0002J\f\u0010©\u0002\u001a\u0005\u0018\u00010ª\u0002H\u0017J\"\u0010«\u0002\u001a\u0012\u0012\u0005\u0012\u00030\u00ad\u0002\u0012\u0004\u0012\u00020s\u0018\u00010¬\u00022\u0007\u0010\u0099\u0002\u001a\u00020BH\u0002J\"\u0010®\u0002\u001a\u00020s2\u000b\u0010C\u001a\u0007\u0012\u0002\b\u00030¯\u00022\n\u0010°\u0002\u001a\u0005\u0018\u00010\u0080\u0001H\u0017J:\u0010±\u0002\u001a\u00020s2\u0011\u0010²\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010¯\u00022\u0007\u0010³\u0002\u001a\u0002002\n\u0010°\u0002\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010´\u0002\u001a\u00020(H\u0002J*\u0010µ\u0002\u001a\u00020s2\u001f\u0010¶\u0002\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030¹\u0002\u0012\u0007\u0012\u0005\u0018\u00010¹\u00020¸\u00020·\u0002H\u0017J*\u0010º\u0002\u001a\u00020s2\u001f\u0010¶\u0002\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030¹\u0002\u0012\u0007\u0012\u0005\u0018\u00010¹\u00020¸\u00020·\u0002H\u0002J1\u0010»\u0002\u001a\u0003H¼\u0002\"\u0005\b\u0000\u0010¼\u00022\u0006\u0010L\u001a\u00020M2\u000f\u0010·\u0001\u001a\n\u0012\u0005\u0012\u0003H¼\u00020\u0098\u0001H\u0082\b¢\u0006\u0003\u0010½\u0002Jr\u0010¾\u0002\u001a\u0003H¼\u0002\"\u0005\b\u0000\u0010¼\u00022\f\b\u0002\u0010¿\u0002\u001a\u0005\u0018\u00010À\u00022\f\b\u0002\u0010Á\u0002\u001a\u0005\u0018\u00010À\u00022\u000b\b\u0002\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u001e2\u001f\b\u0002\u0010+\u001a\u0019\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020B\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010¸\u00020·\u00022\u000f\u0010·\u0001\u001a\n\u0012\u0005\u0012\u0003H¼\u00020\u0098\u0001H\u0002¢\u0006\u0003\u0010Â\u0002J\u0013\u0010Ã\u0002\u001a\u00020s2\b\u0010Ã\u0002\u001a\u00030Ä\u0002H\u0017J\u001b\u0010Å\u0002\u001a\u00020s2\u0006\u0010t\u001a\u00020\u001e2\b\u0010Ã\u0002\u001a\u00030Ä\u0002H\u0017J\t\u0010Æ\u0002\u001a\u00020sH\u0017J\t\u0010Ç\u0002\u001a\u00020sH\u0016J\u001b\u0010È\u0002\u001a\u00030É\u00022\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0010¢\u0006\u0003\bÊ\u0002J\f\u0010Ë\u0002\u001a\u0005\u0018\u00010É\u0002H\u0002J+\u0010Ì\u0002\u001a\n\u0012\u0005\u0012\u00030Í\u00020·\u00022\u0007\u0010Ú\u0001\u001a\u00020\u001e2\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0003\u0010Ï\u0002J\u0017\u0010Ð\u0002\u001a\n\u0012\u0005\u0012\u00030Í\u00020·\u0002H\u0010¢\u0006\u0003\bÑ\u0002JJ\u0010Ò\u0002\u001a\u00020s2\u0015\u0010Ó\u0002\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u00022\u0014\u0010²\u0002\u001a\u000f\u0012\u0004\u0012\u00020s0\u0098\u0001¢\u0006\u0003\bÕ\u00022\t\u0010Ö\u0002\u001a\u0004\u0018\u00010iH\u0010¢\u0006\u0006\b×\u0002\u0010Ø\u0002J\u001f\u0010Ù\u0002\u001a\u00020s2\u000e\u0010·\u0001\u001a\t\u0012\u0004\u0012\u00020s0\u0098\u0001H\u0010¢\u0006\u0003\bÚ\u0002J4\u0010Û\u0002\u001a\u00020(2\u0015\u0010Ó\u0002\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u00022\t\u0010Ö\u0002\u001a\u0004\u0018\u00010iH\u0010¢\u0006\u0006\bÜ\u0002\u0010Ý\u0002J)\u0010Þ\u0002\u001a\u00020s2\u0015\u0010Ó\u0002\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u0002H\u0010¢\u0006\u0006\bß\u0002\u0010à\u0002JA\u0010á\u0002\u001a\u00020s2\u0015\u0010Ó\u0002\u001a\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u00022\u0016\u0010²\u0002\u001a\u0011\u0012\u0004\u0012\u00020s\u0018\u00010\u0098\u0001¢\u0006\u0003\bÕ\u0002H\u0002¢\u0006\u0006\bâ\u0002\u0010ã\u0002J\u0019\u0010é\u0002\u001a\u0005\u0018\u00010\u0080\u0001*\u00020M2\u0007\u0010\u0082\u0002\u001a\u00020\u001eH\u0002J\t\u0010ê\u0002\u001a\u00020sH\u0002J\t\u0010ë\u0002\u001a\u00020sH\u0002J\u0012\u0010ì\u0002\u001a\u00020s2\u0007\u0010í\u0002\u001a\u00020dH\u0002J\t\u0010î\u0002\u001a\u00020sH\u0002J\u0012\u0010ï\u0002\u001a\u00020s2\u0007\u0010ð\u0002\u001a\u00020\u001eH\u0002J\t\u0010ñ\u0002\u001a\u00020sH\u0002J\t\u0010ò\u0002\u001a\u00020sH\u0002J\t\u0010ó\u0002\u001a\u00020sH\u0002J\u000f\u0010ô\u0002\u001a\u00020sH\u0010¢\u0006\u0003\bõ\u0002J2\u0010ö\u0002\u001a\u00020s2\u0007\u0010÷\u0002\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0082\bJ\u001b\u0010ø\u0002\u001a\u00020s2\u0007\u0010÷\u0002\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0082\bJ2\u0010ù\u0002\u001a\u00020s2\u0007\u0010÷\u0002\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\t\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0082\bJ\u001b\u0010ú\u0002\u001a\u00020s2\u0007\u0010÷\u0002\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0082\bJ\u000f\u0010û\u0002\u001a\u00020\u001eH\u0010¢\u0006\u0003\bü\u0002J\f\u0010\u0084\u0003\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\u0014\u0010\u0085\u0003\u001a\u00020s2\t\u0010C\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\u0013\u0010\u0086\u0003\u001a\u00020s2\b\u0010\u0099\u0002\u001a\u00030þ\u0002H\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020(X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0010\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@R\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u001e\u0010D\u001a\u00020(2\u0006\u0010C\u001a\u00020(@RX\u0090\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010;R\u001e\u0010F\u001a\u00020(2\u0006\u0010C\u001a\u00020(@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010;R\u0014\u0010H\u001a\u00020(8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bI\u0010;R\u0014\u0010J\u001a\u00020(8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bK\u0010;R\u001a\u0010L\u001a\u00020MX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010W\u001a\u00020XX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u000e\u0010a\u001a\u00020bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010j\u001a\u0004\u0018\u00010k8PX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020oX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u001a\u0010z\u001a\u00020(8VX\u0097\u0004¢\u0006\f\u0012\u0004\b{\u0010|\u001a\u0004\b}\u0010;R)\u0010\u0087\u0001\u001a\u00020(2\u0006\u0010C\u001a\u00020(8\u0016@RX\u0097\u000e¢\u0006\u0010\n\u0000\u0012\u0005\b\u0088\u0001\u0010|\u001a\u0005\b\u0089\u0001\u0010;R\u001d\u0010\u008a\u0001\u001a\u00020(8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\b\u008b\u0001\u0010|\u001a\u0005\b\u008c\u0001\u0010;R9\u0010\u008f\u0001\u001a\b0\u008d\u0001j\u0003`\u008e\u00012\f\u0010C\u001a\b0\u008d\u0001j\u0003`\u008e\u00018\u0016@RX\u0097\u000e¢\u0006\u0014\n\u0003\u0010\u0093\u0001\u0012\u0005\b\u0090\u0001\u0010|\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0017\u0010°\u0001\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001R\u0012\u0010Î\u0001\u001a\u0005\u0018\u00010Ï\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010Ð\u0001\u001a\u00030Ï\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ö\u0001\u001a\u00030×\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bØ\u0001\u0010Ù\u0001R\u0019\u0010ì\u0001\u001a\u0004\u0018\u00010B8PX\u0090\u0004¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001R\u0013\u0010ä\u0002\u001a\u00020(8F¢\u0006\u0007\u001a\u0005\bå\u0002\u0010;R\u001e\u0010æ\u0002\u001a\u0005\u0018\u00010\u0080\u0001*\u00020M8BX\u0082\u0004¢\u0006\b\u001a\u0006\bç\u0002\u0010è\u0002R\u001a\u0010ý\u0002\u001a\u0005\u0018\u00010þ\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÿ\u0002\u0010\u0080\u0003R\u001a\u0010\u0081\u0003\u001a\u0005\u0018\u00010\u0080\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0082\u0003\u0010\u0083\u0003¨\u0006\u0089\u0003"}, d2 = {"Landroidx/compose/runtime/GapComposer;", "Landroidx/compose/runtime/InternalComposer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "Landroidx/compose/runtime/Changes;", "lateChanges", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "composition", "Landroidx/compose/runtime/CompositionImpl;", "<init>", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/composer/gapbuffer/SlotTable;Ljava/util/Set;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/CompositionObserverHolder;Landroidx/compose/runtime/CompositionImpl;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "pendingStack", "Landroidx/compose/runtime/Stack;", "Landroidx/compose/runtime/GapPending;", "Ljava/util/ArrayList;", PWEStaticDataModel.PWE_STATUS_PENDING, "nodeIndex", "", "groupNodeCount", "rGroupIndex", "parentStateStack", "Landroidx/compose/runtime/IntStack;", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Landroidx/collection/MutableIntIntMap;", "forceRecomposeScopes", "", "forciblyRecompose", "nodeExpected", "invalidations", "", "Landroidx/compose/runtime/Invalidation;", "entersStack", "rootProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "providerUpdates", "Landroidx/collection/MutableIntObjectMap;", "providersInvalid", "providersInvalidStack", "reusing", "reusingGroup", "childrenComposing", "compositionToken", "sourceMarkersEnabled", "getSourceMarkersEnabled$runtime", "()Z", "setSourceMarkersEnabled$runtime", "(Z)V", "derivedStateObserver", "androidx/compose/runtime/GapComposer$derivedStateObserver$1", "Landroidx/compose/runtime/GapComposer$derivedStateObserver$1;", "invalidateStack", "Landroidx/compose/runtime/RecomposeScopeImpl;", "value", "isComposing", "isComposing$runtime", "isDisposed", "isDisposed$runtime", "areChildrenComposing", "getAreChildrenComposing$runtime", "hasPendingChanges", "getHasPendingChanges$runtime", "reader", "Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "getReader$runtime", "()Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "setReader$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/SlotReader;)V", "insertTable", "getInsertTable$runtime", "()Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "setInsertTable$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;)V", "writer", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "writerHasAProvider", "providerCache", "deferredChanges", "Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;", "getDeferredChanges$runtime", "()Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;", "setDeferredChanges$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;)V", "changeListWriter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/ComposerChangeListWriter;", "insertAnchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "insertFixups", "Landroidx/compose/runtime/composer/gapbuffer/changelist/FixupList;", "pausable", "shouldPauseCallback", "Landroidx/compose/runtime/ShouldPauseCallback;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "getErrorContext$runtime", "()Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "startReplaceableGroup", "", "key", "endReplaceableGroup", "startReplaceGroup", "endReplaceGroup", "startDefaults", "endDefaults", "defaultsInvalid", "getDefaultsInvalid$annotations", "()V", "getDefaultsInvalid", "startMovableGroup", "dataKey", "", "endMovableGroup", "startRoot", "endRoot", "abortRoot", "changesApplied", "changesApplied$runtime", "inserting", "getInserting$annotations", "getInserting", "skipping", "getSkipping$annotations", "getSkipping", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "compositeKeyHashCode", "getCompositeKeyHashCode$annotations", "getCompositeKeyHashCode", "()J", "J", "collectParameterInformation", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "Lkotlin/Function0;", "dispose", "dispose$runtime", "deactivate", "deactivate$runtime", "forceRecomposeScopes$runtime", "startGroup", "endGroup", "skipGroup", "startNode", "startReusableNode", "createNode", ExifInterface.GPS_DIRECTION_TRUE, "factory", "useNode", "endNode", "startReusableGroup", "endReusableGroup", "disableReusing", "enableReusing", "startReuseFromRoot", "startReuseFromRoot$runtime", "endReuseFromRoot", "endReuseFromRoot$runtime", "currentMarker", "getCurrentMarker", "()I", "endToMarker", "marker", "apply", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, BlockContactsIQ.ELEMENT, "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "joinKey", "left", "right", "nextSlot", "nextSlotForCache", "changed", "changedInstance", "", "", "", "", "", "cache", "invalid", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateSlot", "updateValue", "updateCachedValue", "rememberObserverGroupIndex", "_compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "compositionData", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "recordSideEffect", "effect", "currentCompositionLocalScope", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "group", "updateProviderMapGroup", "parentScope", "currentProviders", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "recordProviderUpdate", "providers", "endProvider", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "endProviders", "consume", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "buildContext", "currentRecomposeScope", "getCurrentRecomposeScope$runtime", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "ensureWriter", "createFreshInsertTable", "forceFreshInsertTable", "startReaderGroup", "isNode", "data", "start", "objectKey", "kind", "Landroidx/compose/runtime/composer/GroupKind;", "start-AzEfcrM", "(ILjava/lang/Object;ILjava/lang/Object;)V", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "end", "recomposeToGroupEnd", "insertedGroupVirtualIndex", FirebaseAnalytics.Param.INDEX, "updateNodeCountOverrides", "newCount", "nodeIndexOf", "groupLocation", "recomposeGroup", "recomposeIndex", "rGroupIndexOf", "updatedNodeCount", "updateNodeCount", "count", "clearUpdatedNodeCounts", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "doRecordDownsFor", "nearestCommonRoot", "compositeKeyOf", "recomposeKey", "(IIJ)J", "groupCompositeKeyPart", "tryImminentInvalidation", "scope", "instance", "tryImminentInvalidation$runtime", "parentKey", "parentKey$runtime", "skipCurrentGroup", "skipReaderToGroupEnd", "shouldExecute", "parametersChanged", "flags", "skipToGroupEnd", "deactivateToEndGroup", "startRestartGroup", "Landroidx/compose/runtime/Composer;", "addRecomposeScope", "enterRecomposeScope", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "exitRecomposeScope", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "invokeMovableContentLambda", "content", "locals", "force", "insertMovableContentReferences", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentGuarded", "withReader", "R", "(Landroidx/compose/runtime/composer/gapbuffer/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeMovableContent", "from", "Landroidx/compose/runtime/ControlledComposition;", "to", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "sourceInformation", "", "sourceInformationMarkerStart", "sourceInformationMarkerEnd", "disableSourceInformation", "stackTraceForValue", "Landroidx/compose/runtime/tooling/ComposeStackTrace;", "stackTraceForValue$runtime", "currentStackTrace", "stackTraceForGroup", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "dataOffset", "(ILjava/lang/Integer;)Ljava/util/List;", "parentStackTrace", "parentStackTrace$runtime", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/Composable;", "shouldPause", "composeContent--ZbOJvo$runtime", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ShouldPauseCallback;)V", "prepareCompose", "prepareCompose$runtime", "recompose", "recompose-aFTiNEg$runtime", "(Landroidx/collection/MutableScatterMap;Landroidx/compose/runtime/ShouldPauseCallback;)Z", "updateComposerInvalidations", "updateComposerInvalidations-RY85e9Y$runtime", "(Landroidx/collection/MutableScatterMap;)V", "doCompose", "doCompose-aFTiNEg", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;)V", "hasInvalidations", "getHasInvalidations", NodeElement.ELEMENT, "getNode", "(Landroidx/compose/runtime/composer/gapbuffer/SlotReader;)Ljava/lang/Object;", "nodeAt", "validateNodeExpected", "validateNodeNotExpected", "recordInsert", ReferenceElement.ATTR_ANCHOR, "recordDelete", "reportFreeMovableContent", "groupBeingRemoved", "reportAllMovableContent", "finalizeCompose", "cleanUpCompose", "verifyConsistent", "verifyConsistent$runtime", "updateCompositeKeyWhenWeEnterGroup", "groupKey", "updateCompositeKeyWhenWeEnterGroupKeyHash", "updateCompositeKeyWhenWeExitGroup", "updateCompositeKeyWhenWeExitGroupKeyHash", "stacksSize", "stacksSize$runtime", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "rememberedValue", "updateRememberedValue", "recordUsed", "CompositionContextHolder", "CompositionContextImpl", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GapComposer extends InternalComposer {
    public static final int $stable = 8;
    private CompositionData _compositionData;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final CoroutineContext applyCoroutineContext;
    private final ComposerChangeListWriter changeListWriter;
    private Changes changes;
    private int childrenComposing;
    private long compositeKeyHashCode;
    private final CompositionImpl composition;
    private int compositionToken;
    private ChangeList deferredChanges;
    private final GapComposer$derivedStateObserver$1 derivedStateObserver;
    private final CompositionErrorContextImpl errorContext;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private GapAnchor insertAnchor;
    private FixupList insertFixups;
    private SlotTable insertTable;
    private boolean inserting;
    private final ArrayList<RecomposeScopeImpl> invalidateStack;
    private boolean isComposing;
    private boolean isDisposed;
    private Changes lateChanges;
    private int[] nodeCountOverrides;
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parentContext;
    private boolean pausable;
    private GapPending pending;
    private PersistentCompositionLocalMap providerCache;
    private MutableIntObjectMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private int rGroupIndex;
    private SlotReader reader;
    private boolean reusing;
    private ShouldPauseCallback shouldPauseCallback;
    private final SlotTable slotTable;
    private boolean sourceMarkersEnabled;
    private SlotWriter writer;
    private boolean writerHasAProvider;
    private final ArrayList<GapPending> pendingStack = Stack.m5052constructorimpl$default(null, 1, null);
    private final IntStack parentStateStack = new IntStack();
    private final List<Invalidation> invalidations = new ArrayList();
    private final IntStack entersStack = new IntStack();
    private PersistentCompositionLocalMap rootProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
    private final IntStack providersInvalidStack = new IntStack();
    private int reusingGroup = -1;

    public static /* synthetic */ void getCompositeKeyHashCode$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    private final int insertedGroupVirtualIndex(int index) {
        return (-2) - index;
    }

    /* JADX WARN: Type inference failed for: r5v13, types: [androidx.compose.runtime.GapComposer$derivedStateObserver$1] */
    public GapComposer(Applier<?> applier, CompositionContext compositionContext, SlotTable slotTable, Set<RememberObserver> set, Changes changes, Changes changes2, CompositionObserverHolder compositionObserverHolder, CompositionImpl compositionImpl) {
        this.applier = applier;
        this.parentContext = compositionContext;
        this.slotTable = slotTable;
        this.abandonSet = set;
        this.changes = changes;
        this.lateChanges = changes2;
        this.observerHolder = compositionObserverHolder;
        this.composition = compositionImpl;
        this.sourceMarkersEnabled = compositionContext.getCollectingSourceInformation() || compositionContext.getCollectingCallByInformation$runtime();
        this.derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.GapComposer$derivedStateObserver$1
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
        SlotReader slotReaderOpenReader = slotTable.openReader();
        slotReaderOpenReader.close();
        this.reader = slotReaderOpenReader;
        SlotTable slotTable2 = new SlotTable();
        if (compositionContext.getCollectingSourceInformation()) {
            slotTable2.collectSourceInformation();
        }
        if (compositionContext.getCollectingCallByInformation$runtime()) {
            slotTable2.collectCalledByInformation();
        }
        this.insertTable = slotTable2;
        SlotWriter slotWriterOpenWriter = slotTable2.openWriter();
        slotWriterOpenWriter.close(true);
        this.writer = slotWriterOpenWriter;
        this.changeListWriter = new ComposerChangeListWriter(this, ChangeListKt.asGapBufferChangeList(this.changes));
        SlotReader slotReaderOpenReader2 = this.insertTable.openReader();
        try {
            GapAnchor gapAnchorAnchor = slotReaderOpenReader2.anchor(0);
            slotReaderOpenReader2.close();
            this.insertAnchor = gapAnchorAnchor;
            this.insertFixups = new FixupList();
            this.errorContext = new CompositionErrorContextImpl(this);
            CoroutineContext effectCoroutineContext = compositionContext.getEffectCoroutineContext();
            CoroutineContext errorContext$runtime = getErrorContext$runtime();
            this.applyCoroutineContext = effectCoroutineContext.plus(errorContext$runtime == null ? EmptyCoroutineContext.INSTANCE : errorContext$runtime);
        } catch (Throwable th) {
            slotReaderOpenReader2.close();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionImpl getComposition() {
        return this.composition;
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
    public boolean getHasPendingChanges$runtime() {
        return this.changes.isNotEmpty();
    }

    /* JADX INFO: renamed from: getReader$runtime, reason: from getter */
    public final SlotReader getReader() {
        return this.reader;
    }

    public final void setReader$runtime(SlotReader slotReader) {
        this.reader = slotReader;
    }

    /* JADX INFO: renamed from: getInsertTable$runtime, reason: from getter */
    public final SlotTable getInsertTable() {
        return this.insertTable;
    }

    public final void setInsertTable$runtime(SlotTable slotTable) {
        this.insertTable = slotTable;
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* JADX INFO: renamed from: getDeferredChanges$runtime, reason: from getter */
    public ChangeList getDeferredChanges() {
        return this.deferredChanges;
    }

    public void setDeferredChanges$runtime(ChangeList changeList) {
        this.deferredChanges = changeList;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public CompositionErrorContextImpl getErrorContext$runtime() {
        if (this.parentContext.getStackTraceEnabled$runtime()) {
            return this.errorContext;
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public CoroutineContext getApplyCoroutineContext() {
        return this.applyCoroutineContext;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceableGroup(int key) {
        m5014startAzEfcrM(key, null, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceGroup(int key) {
        if (this.pending != null) {
            m5014startAzEfcrM(key, null, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
            return;
        }
        validateNodeNotExpected();
        this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(getCompositeKeyHashCode(), 3) ^ ((long) key), 3) ^ ((long) this.rGroupIndex);
        this.rGroupIndex++;
        SlotReader slotReader = this.reader;
        if (getInserting()) {
            slotReader.beginEmpty();
            this.writer.startGroup(key, Composer.INSTANCE.getEmpty());
            enterGroup(false, null);
            return;
        }
        if (slotReader.getGroupKey() == key && !slotReader.getHasObjectKey()) {
            slotReader.startGroup();
            enterGroup(false, null);
            return;
        }
        if (!slotReader.isGroupEnd()) {
            int i = this.nodeIndex;
            int currentGroup = slotReader.getCurrentGroup();
            recordDelete();
            this.changeListWriter.removeNode(i, slotReader.skipGroup());
            GapComposerKt.removeRange(this.invalidations, currentGroup, slotReader.getCurrentGroup());
        }
        slotReader.beginEmpty();
        this.inserting = true;
        this.providerCache = null;
        ensureWriter();
        SlotWriter slotWriter = this.writer;
        slotWriter.beginInsert();
        int currentGroup2 = slotWriter.getCurrentGroup();
        slotWriter.startGroup(key, Composer.INSTANCE.getEmpty());
        this.insertAnchor = slotWriter.anchor(currentGroup2);
        enterGroup(false, null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startDefaults() {
        m5014startAzEfcrM(ComposerKt.defaultsKey, null, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime();
        if (currentRecomposeScope$runtime == null || !currentRecomposeScope$runtime.getUsed()) {
            return;
        }
        currentRecomposeScope$runtime.setDefaultsInScope(true);
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        return !getSkipping() || this.providersInvalid || ((currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) != null && currentRecomposeScope$runtime.getDefaultsInvalid());
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startMovableGroup(int key, Object dataKey) {
        m5014startAzEfcrM(key, dataKey, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    private final void startRoot() {
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime();
        PersistentCompositionLocalMap compositionLocalScope$runtime = this.parentContext.getCompositionLocalScope$runtime();
        this.providersInvalidStack.push(GapComposerKt.asInt(this.providersInvalid));
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
        startGroup(Long.hashCode(this.parentContext.getCompositeKeyHashCode()));
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime();
        endGroup();
        this.changeListWriter.endRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
        this.providersInvalid = GapComposerKt.asBool(this.providersInvalidStack.pop());
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
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (this.writer.getClosed()) {
            return;
        }
        forceFreshInsertTable();
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void changesApplied$runtime() {
        this.providerUpdates = null;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        return (getInserting() || this.reusing || this.providersInvalid || (currentRecomposeScope$runtime = getCurrentRecomposeScope$runtime()) == null || currentRecomposeScope$runtime.getRequiresRecompose() || this.forciblyRecompose) ? false : true;
    }

    @Override // androidx.compose.runtime.Composer
    public long getCompositeKeyHashCode() {
        return this.compositeKeyHashCode;
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
        setSourceMarkersEnabled$runtime(true);
        this.slotTable.collectSourceInformation();
        this.insertTable.collectSourceInformation();
        this.writer.updateToTableMaps();
    }

    @Override // androidx.compose.runtime.Composer
    public CancellationHandle scheduleFrameEndCallback(Function0<Unit> action) {
        return this.parentContext.scheduleFrameEndCallback(action);
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void dispose$runtime() {
        Object objBeginSection = Trace.INSTANCE.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime(this);
            deactivate$runtime();
            getApplier().clear();
            this.isDisposed = true;
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.INSTANCE.endSection(objBeginSection);
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void deactivate$runtime() {
        Stack.m5050clearimpl(this.invalidateStack);
        this.invalidations.clear();
        this.changes.clear();
        this.providerUpdates = null;
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

    private final void startGroup(int key) {
        m5014startAzEfcrM(key, null, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
    }

    private final void startGroup(int key, Object dataKey) {
        m5014startAzEfcrM(key, dataKey, GroupKind.INSTANCE.m5138getGroup9udXigM(), null);
    }

    private final void endGroup() {
        end(false);
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        m5014startAzEfcrM(125, null, GroupKind.INSTANCE.m5139getNode9udXigM(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        m5014startAzEfcrM(125, null, GroupKind.INSTANCE.m5140getReusableNode9udXigM(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    public <T> void createNode(Function0<? extends T> factory) {
        validateNodeExpected();
        if (!getInserting()) {
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }
        int iPeek = this.parentStateStack.peek();
        SlotWriter slotWriter = this.writer;
        GapAnchor gapAnchorAnchor = slotWriter.anchor(slotWriter.getParent());
        this.groupNodeCount++;
        this.insertFixups.createAndInsertNode(factory, iPeek, gapAnchorAnchor);
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        validateNodeExpected();
        if (getInserting()) {
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }
        Object node = getNode(this.reader);
        this.changeListWriter.moveDown(node);
        if (this.reusing && (node instanceof ComposeNodeLifecycleCallback)) {
            this.changeListWriter.useNode(node);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int key, Object dataKey) {
        if (!getInserting() && this.reader.getGroupKey() == key && !Intrinsics.areEqual(this.reader.getGroupAux(), dataKey) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }
        m5014startAzEfcrM(key, null, GroupKind.INSTANCE.m5138getGroup9udXigM(), dataKey);
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }
        end(false);
    }

    @Override // androidx.compose.runtime.Composer
    public void disableReusing() {
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void enableReusing() {
        this.reusing = this.reusingGroup >= 0;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void startReuseFromRoot$runtime() {
        this.reusingGroup = 0;
        this.reusing = true;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void endReuseFromRoot$runtime() {
        if (!(!getIsComposing() && this.reusingGroup == 0)) {
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }
        this.reusingGroup = -1;
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public int getCurrentMarker() {
        return getInserting() ? -this.writer.getParent() : this.reader.getParent();
    }

    @Override // androidx.compose.runtime.Composer
    public void endToMarker(int marker) {
        if (marker < 0) {
            int i = -marker;
            SlotWriter slotWriter = this.writer;
            while (true) {
                int parent = slotWriter.getParent();
                if (parent <= i) {
                    return;
                } else {
                    end(slotWriter.isNode(parent));
                }
            }
        } else {
            if (getInserting()) {
                SlotWriter slotWriter2 = this.writer;
                while (getInserting()) {
                    end(slotWriter2.isNode(slotWriter2.getParent()));
                }
            }
            SlotReader slotReader = this.reader;
            while (true) {
                int parent2 = slotReader.getParent();
                if (parent2 <= marker) {
                    return;
                } else {
                    end(slotReader.isNode(parent2));
                }
            }
        }
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
    @ComposeCompilerApi
    public Object joinKey(Object left, Object right) {
        Object key = GapComposerKt.getKey(this.reader.getGroupObjectKey(), left, right);
        return key == null ? new JoinedKey(left, right) : key;
    }

    public final Object nextSlot() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.INSTANCE.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserverHolder)) ? next : Composer.INSTANCE.getEmpty();
    }

    public final Object nextSlotForCache() {
        if (getInserting()) {
            validateNodeNotExpected();
            return Composer.INSTANCE.getEmpty();
        }
        Object next = this.reader.next();
        return (!this.reusing || (next instanceof ReusableRememberObserverHolder)) ? next instanceof RememberObserverHolder ? ((RememberObserverHolder) next).getWrapped() : next : Composer.INSTANCE.getEmpty();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(Object value) {
        if (Intrinsics.areEqual(nextSlot(), value)) {
            return false;
        }
        updateValue(value);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changedInstance(Object value) {
        if (nextSlot() == value) {
            return false;
        }
        updateValue(value);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(char value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Character) && value == ((Character) objNextSlot).charValue()) {
            return false;
        }
        updateValue(Character.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(byte value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Byte) && value == ((Number) objNextSlot).byteValue()) {
            return false;
        }
        updateValue(Byte.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(short value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Short) && value == ((Number) objNextSlot).shortValue()) {
            return false;
        }
        updateValue(Short.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(boolean value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Boolean) && value == ((Boolean) objNextSlot).booleanValue()) {
            return false;
        }
        updateValue(Boolean.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(float value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Float) && value == ((Number) objNextSlot).floatValue()) {
            return false;
        }
        updateValue(Float.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(long value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Long) && value == ((Number) objNextSlot).longValue()) {
            return false;
        }
        updateValue(Long.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(double value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Double) && value == ((Number) objNextSlot).doubleValue()) {
            return false;
        }
        updateValue(Double.valueOf(value));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(int value) {
        Object objNextSlot = nextSlot();
        if ((objNextSlot instanceof Integer) && value == ((Number) objNextSlot).intValue()) {
            return false;
        }
        updateValue(Integer.valueOf(value));
        return true;
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean invalid, Function0<? extends T> block) {
        T t = (T) nextSlotForCache();
        if (t != Composer.INSTANCE.getEmpty() && !invalid) {
            return t;
        }
        T tInvoke = block.invoke();
        updateCachedValue(tInvoke);
        return tInvoke;
    }

    private final void updateSlot(Object value) {
        nextSlot();
        updateValue(value);
    }

    public final void updateValue(Object value) {
        if (getInserting()) {
            this.writer.update(value);
            return;
        }
        if (this.reader.getHadNext()) {
            int groupSlotIndex = this.reader.getGroupSlotIndex() - 1;
            if (this.changeListWriter.getPastParent()) {
                ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                SlotReader slotReader = this.reader;
                composerChangeListWriter.updateAnchoredValue(value, slotReader.anchor(slotReader.getParent()), groupSlotIndex);
                return;
            }
            this.changeListWriter.updateValue(value, groupSlotIndex);
            return;
        }
        ComposerChangeListWriter composerChangeListWriter2 = this.changeListWriter;
        SlotReader slotReader2 = this.reader;
        composerChangeListWriter2.appendValue(slotReader2.anchor(slotReader2.getParent()), value);
    }

    public final void updateCachedValue(Object value) {
        if (value instanceof RememberObserver) {
            GapRememberObserverHolder gapRememberObserverHolder = new GapRememberObserverHolder((RememberObserver) value, rememberObserverGroupIndex());
            if (getInserting()) {
                this.changeListWriter.remember(gapRememberObserverHolder);
            }
            this.abandonSet.add(value);
            value = gapRememberObserverHolder;
        }
        updateValue(value);
    }

    private final int rememberObserverGroupIndex() {
        return this.rGroupIndex - 1;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionData getCompositionData() {
        CompositionData compositionData = this._compositionData;
        if (compositionData != null) {
            return compositionData;
        }
        GapCompositionDataImpl gapCompositionDataImpl = new GapCompositionDataImpl(getComposition());
        this._compositionData = gapCompositionDataImpl;
        return gapCompositionDataImpl;
    }

    @Override // androidx.compose.runtime.Composer
    public void recordSideEffect(Function0<Unit> effect) {
        this.changeListWriter.sideEffect(effect);
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.providerCache;
        return persistentCompositionLocalMap != null ? persistentCompositionLocalMap : currentCompositionLocalScope(this.reader.getParent());
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int group) {
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        if (getInserting() && this.writerHasAProvider) {
            int parent = this.writer.getParent();
            while (parent > 0) {
                if (this.writer.groupKey(parent) == 202 && Intrinsics.areEqual(this.writer.groupObjectKey(parent), ComposerKt.getCompositionLocalMap())) {
                    Object objGroupAux = this.writer.groupAux(parent);
                    Intrinsics.checkNotNull(objGroupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) objGroupAux;
                    this.providerCache = persistentCompositionLocalMap2;
                    return persistentCompositionLocalMap2;
                }
                parent = this.writer.parent(parent);
            }
        }
        if (this.reader.getGroupsSize() > 0) {
            while (group > 0) {
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
                group = this.reader.parent(group);
            }
        }
        PersistentCompositionLocalMap persistentCompositionLocalMap3 = this.rootProvider;
        this.providerCache = persistentCompositionLocalMap3;
        return persistentCompositionLocalMap3;
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
            this.writerHasAProvider = true;
        } else {
            SlotReader slotReader = this.reader;
            Object objGroupAux = slotReader.groupAux(slotReader.getCurrentGroup());
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
        this.providersInvalidStack.push(GapComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z2;
        this.providerCache = persistentCompositionLocalMapCurrentCompositionLocalScope;
        m5014startAzEfcrM(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m5138getGroup9udXigM(), persistentCompositionLocalMapCurrentCompositionLocalScope);
    }

    private final void recordProviderUpdate(PersistentCompositionLocalMap providers) {
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
            this.providerUpdates = mutableIntObjectMap;
        }
        mutableIntObjectMap.set(this.reader.getCurrentGroup(), providers);
    }

    @Override // androidx.compose.runtime.Composer
    public void endProvider() {
        endGroup();
        endGroup();
        this.providersInvalid = GapComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
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
            this.writerHasAProvider = true;
        } else {
            Object objGroupGet = this.reader.groupGet(0);
            Intrinsics.checkNotNull(objGroupGet, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) objGroupGet;
            Object objGroupGet2 = this.reader.groupGet(1);
            Intrinsics.checkNotNull(objGroupGet2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) objGroupGet2;
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
        this.providersInvalidStack.push(GapComposerKt.asInt(this.providersInvalid));
        this.providersInvalid = z2;
        this.providerCache = persistentCompositionLocalMapUpdateProviderMapGroup;
        m5014startAzEfcrM(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m5138getGroup9udXigM(), persistentCompositionLocalMapUpdateProviderMapGroup);
    }

    @Override // androidx.compose.runtime.Composer
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = GapComposerKt.asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    public <T> T consume(CompositionLocal<T> key) {
        return (T) CompositionLocalMapKt.read(currentCompositionLocalScope(), key);
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionContext buildContext() {
        startGroup(206, ComposerKt.getReference());
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, null);
        }
        Object objNextSlot = nextSlot();
        ReusableGapRememberObserverHolder reusableGapRememberObserverHolder = objNextSlot instanceof RememberObserverHolder ? (RememberObserverHolder) objNextSlot : null;
        if (reusableGapRememberObserverHolder == null) {
            reusableGapRememberObserverHolder = new ReusableGapRememberObserverHolder(new CompositionContextHolder(new CompositionContextImpl(getCompositeKeyHashCode(), this.forceRecomposeScopes, getSourceMarkersEnabled(), getComposition().getObserverHolder())), -1);
            updateValue(reusableGapRememberObserverHolder);
        }
        RememberObserver wrapped = reusableGapRememberObserverHolder.getWrapped();
        Intrinsics.checkNotNull(wrapped, "null cannot be cast to non-null type androidx.compose.runtime.GapComposer.CompositionContextHolder");
        CompositionContextHolder compositionContextHolder = (CompositionContextHolder) wrapped;
        compositionContextHolder.getRef().updateCompositionLocalScope(currentCompositionLocalScope());
        endGroup();
        return compositionContextHolder.getRef();
    }

    @Override // androidx.compose.runtime.InternalComposer
    public RecomposeScopeImpl getCurrentRecomposeScope$runtime() {
        ArrayList<RecomposeScopeImpl> arrayList = this.invalidateStack;
        if (this.childrenComposing == 0 && Stack.m5058isNotEmptyimpl(arrayList)) {
            return (RecomposeScopeImpl) Stack.m5059peekimpl(arrayList);
        }
        return null;
    }

    private final void ensureWriter() {
        if (this.writer.getClosed()) {
            SlotWriter slotWriterOpenWriter = this.insertTable.openWriter();
            this.writer = slotWriterOpenWriter;
            slotWriterOpenWriter.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void createFreshInsertTable() {
        if (!this.writer.getClosed()) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }
        forceFreshInsertTable();
    }

    private final void forceFreshInsertTable() {
        SlotTable slotTable = new SlotTable();
        if (getSourceMarkersEnabled()) {
            slotTable.collectSourceInformation();
        }
        if (this.parentContext.getCollectingCallByInformation$runtime()) {
            slotTable.collectCalledByInformation();
        }
        this.insertTable = slotTable;
        SlotWriter slotWriterOpenWriter = slotTable.openWriter();
        slotWriterOpenWriter.close(true);
        this.writer = slotWriterOpenWriter;
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e3  */
    /* JADX INFO: renamed from: start-AzEfcrM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m5014startAzEfcrM(int r13, java.lang.Object r14, int r15, java.lang.Object r16) {
        /*
            Method dump skipped, instruction units count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.GapComposer.m5014startAzEfcrM(int, java.lang.Object, int, java.lang.Object):void");
    }

    private final void enterGroup(boolean isNode, GapPending newPending) {
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
    }

    private final void exitGroup(int expectedNodeCount, boolean inserting) {
        GapPending gapPending = (GapPending) Stack.m5061popimpl(this.pendingStack);
        if (gapPending != null && !inserting) {
            gapPending.setGroupIndex(gapPending.getGroupIndex() + 1);
        }
        this.pending = gapPending;
        this.nodeIndex = this.parentStateStack.pop() + expectedNodeCount;
        this.rGroupIndex = this.parentStateStack.pop();
        this.groupNodeCount = this.parentStateStack.pop() + expectedNodeCount;
    }

    private final void end(boolean isNode) {
        long jRotateRight;
        long j;
        int remainingSlots;
        List<KeyInfo> list;
        List<KeyInfo> list2;
        long jRotateRight2;
        long j2;
        int iPeek2 = this.parentStateStack.peek2() - 1;
        if (getInserting()) {
            int parent = this.writer.getParent();
            int iGroupKey = this.writer.groupKey(parent);
            Object objGroupObjectKey = this.writer.groupObjectKey(parent);
            Object objGroupAux = this.writer.groupAux(parent);
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
        GapPending gapPending = this.pending;
        if (gapPending != null && gapPending.getKeyInfos().size() > 0) {
            List<KeyInfo> keyInfos = gapPending.getKeyInfos();
            List<KeyInfo> used = gapPending.getUsed();
            Set setFastToSet = ListUtilsKt.fastToSet(used);
            MutableScatterSet mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            int size = used.size();
            int size2 = keyInfos.size();
            int i2 = 0;
            int i3 = 0;
            int iUpdatedNodeCountOf = 0;
            while (i2 < size2) {
                KeyInfo keyInfo = keyInfos.get(i2);
                if (!setFastToSet.contains(keyInfo)) {
                    this.changeListWriter.removeNode(gapPending.nodePositionOf(keyInfo) + gapPending.getStartIndex(), keyInfo.getNodes());
                    gapPending.updateNodeCount(keyInfo.getLocation(), 0);
                    this.changeListWriter.moveReaderRelativeTo(keyInfo.getLocation());
                    this.reader.reposition(keyInfo.getLocation());
                    recordDelete();
                    this.reader.skipGroup();
                    list = keyInfos;
                    GapComposerKt.removeRange(this.invalidations, keyInfo.getLocation(), keyInfo.getLocation() + this.reader.groupSize(keyInfo.getLocation()));
                } else {
                    list = keyInfos;
                    if (!mutableScatterSetMutableScatterSetOf.contains(keyInfo)) {
                        if (i3 < size) {
                            KeyInfo keyInfo2 = used.get(i3);
                            if (keyInfo2 != keyInfo) {
                                int iNodePositionOf = gapPending.nodePositionOf(keyInfo2);
                                mutableScatterSetMutableScatterSetOf.add(keyInfo2);
                                if (iNodePositionOf != iUpdatedNodeCountOf) {
                                    int iUpdatedNodeCountOf2 = gapPending.updatedNodeCountOf(keyInfo2);
                                    list2 = used;
                                    this.changeListWriter.moveNode(gapPending.getStartIndex() + iNodePositionOf, iUpdatedNodeCountOf + gapPending.getStartIndex(), iUpdatedNodeCountOf2);
                                    gapPending.registerMoveNode(iNodePositionOf, iUpdatedNodeCountOf, iUpdatedNodeCountOf2);
                                } else {
                                    list2 = used;
                                }
                            } else {
                                list2 = used;
                                i2++;
                            }
                            i3++;
                            iUpdatedNodeCountOf += gapPending.updatedNodeCountOf(keyInfo2);
                            keyInfos = list;
                            used = list2;
                        }
                    }
                    keyInfos = list;
                }
                i2++;
                keyInfos = list;
            }
            this.changeListWriter.endNodeMovement();
            if (keyInfos.size() > 0) {
                this.changeListWriter.moveReaderRelativeTo(this.reader.getGroupEnd());
                this.reader.skipToGroupEnd();
            }
        }
        boolean inserting = getInserting();
        if (!inserting && (remainingSlots = this.reader.getRemainingSlots()) > 0) {
            this.changeListWriter.trimValues(remainingSlots);
        }
        int i4 = this.nodeIndex;
        while (!this.reader.isGroupEnd()) {
            int currentGroup = this.reader.getCurrentGroup();
            recordDelete();
            this.changeListWriter.removeNode(i4, this.reader.skipGroup());
            GapComposerKt.removeRange(this.invalidations, currentGroup, this.reader.getCurrentGroup());
        }
        if (inserting) {
            if (isNode) {
                this.insertFixups.endNodeInsert();
                i = 1;
            }
            this.reader.endEmpty();
            int parent3 = this.writer.getParent();
            this.writer.endGroup();
            if (!this.reader.getInEmpty()) {
                int iInsertedGroupVirtualIndex = insertedGroupVirtualIndex(parent3);
                this.writer.endInsert();
                this.writer.close(true);
                recordInsert(this.insertAnchor);
                this.inserting = false;
                if (!this.slotTable.isEmpty()) {
                    updateNodeCount(iInsertedGroupVirtualIndex, 0);
                    updateNodeCountOverrides(iInsertedGroupVirtualIndex, i);
                }
            }
        } else {
            if (isNode) {
                this.changeListWriter.moveUp();
            }
            this.changeListWriter.endCurrentGroup();
            int parent4 = this.reader.getParent();
            if (i != updatedNodeCount(parent4)) {
                updateNodeCountOverrides(parent4, i);
            }
            if (isNode) {
                i = 1;
            }
            this.reader.endGroup();
            this.changeListWriter.endNodeMovement();
        }
        exitGroup(i, inserting);
    }

    private final void recomposeToGroupEnd() {
        boolean isComposing = getIsComposing();
        this.isComposing = true;
        int parent = this.reader.getParent();
        int iGroupSize = this.reader.groupSize(parent) + parent;
        int i = this.nodeIndex;
        long compositeKeyHashCode = getCompositeKeyHashCode();
        int i2 = this.groupNodeCount;
        int i3 = this.rGroupIndex;
        Invalidation invalidationFirstInRange = GapComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), iGroupSize);
        boolean z = false;
        int i4 = parent;
        while (invalidationFirstInRange != null) {
            int location = invalidationFirstInRange.getLocation();
            RecomposeScopeImpl scope = invalidationFirstInRange.getScope();
            GapComposerKt.removeLocation(this.invalidations, location);
            if (invalidationFirstInRange.isInvalid()) {
                this.reader.reposition(location);
                int currentGroup = this.reader.getCurrentGroup();
                recordUpsAndDowns(i4, currentGroup, parent);
                this.nodeIndex = nodeIndexOf(location, currentGroup, parent, i);
                this.rGroupIndex = rGroupIndexOf(currentGroup);
                this.compositeKeyHashCode = compositeKeyOf(this.reader.parent(currentGroup), parent, compositeKeyHashCode);
                this.providerCache = null;
                scope.compose(this);
                this.providerCache = null;
                this.reader.restoreParent(parent);
                z = true;
                i4 = currentGroup;
            } else {
                Stack.m5062pushimpl(this.invalidateStack, scope);
                CompositionObserver compositionObserverCurrent = this.observerHolder.current();
                if (compositionObserverCurrent != null) {
                    try {
                        compositionObserverCurrent.onScopeEnter(scope);
                        scope.rereadTrackedInstances();
                    } finally {
                        compositionObserverCurrent.onScopeExit(scope);
                    }
                } else {
                    scope.rereadTrackedInstances();
                }
                Stack.m5061popimpl(this.invalidateStack);
            }
            invalidationFirstInRange = GapComposerKt.firstInRange(this.invalidations, this.reader.getCurrentGroup(), iGroupSize);
        }
        if (z) {
            recordUpsAndDowns(i4, parent, parent);
            this.reader.skipToGroupEnd();
            int iUpdatedNodeCount = updatedNodeCount(parent);
            this.nodeIndex = i + iUpdatedNodeCount;
            this.groupNodeCount = i2 + iUpdatedNodeCount;
            this.rGroupIndex = i3;
        } else {
            skipReaderToGroupEnd();
        }
        this.compositeKeyHashCode = compositeKeyHashCode;
        this.isComposing = isComposing;
    }

    private final void updateNodeCountOverrides(int group, int newCount) {
        int iUpdatedNodeCount = updatedNodeCount(group);
        if (iUpdatedNodeCount != newCount) {
            int i = newCount - iUpdatedNodeCount;
            int iM5055getSizeimpl = Stack.m5055getSizeimpl(this.pendingStack) - 1;
            while (group != -1) {
                int iUpdatedNodeCount2 = updatedNodeCount(group) + i;
                updateNodeCount(group, iUpdatedNodeCount2);
                int i2 = iM5055getSizeimpl;
                while (true) {
                    if (-1 < i2) {
                        GapPending gapPending = (GapPending) Stack.m5060peekimpl(this.pendingStack, i2);
                        if (gapPending != null && gapPending.updateNodeCount(group, iUpdatedNodeCount2)) {
                            iM5055getSizeimpl = i2 - 1;
                            break;
                        }
                        i2--;
                    } else {
                        break;
                    }
                }
                if (group < 0) {
                    group = this.reader.getParent();
                } else if (this.reader.isNode(group)) {
                    return;
                } else {
                    group = this.reader.parent(group);
                }
            }
        }
    }

    private final int nodeIndexOf(int groupLocation, int group, int recomposeGroup, int recomposeIndex) {
        int iParent = this.reader.parent(group);
        while (iParent != recomposeGroup && !this.reader.isNode(iParent)) {
            iParent = this.reader.parent(iParent);
        }
        if (this.reader.isNode(iParent)) {
            recomposeIndex = 0;
        }
        if (iParent == group) {
            return recomposeIndex;
        }
        int iUpdatedNodeCount = (updatedNodeCount(iParent) - this.reader.nodeCount(group)) + recomposeIndex;
        loop1: while (recomposeIndex < iUpdatedNodeCount && iParent != groupLocation) {
            iParent++;
            while (iParent < groupLocation) {
                int iGroupSize = this.reader.groupSize(iParent) + iParent;
                if (groupLocation >= iGroupSize) {
                    recomposeIndex += this.reader.isNode(iParent) ? 1 : updatedNodeCount(iParent);
                    iParent = iGroupSize;
                }
            }
            break loop1;
        }
        return recomposeIndex;
    }

    private final int rGroupIndexOf(int group) {
        int iParent = this.reader.parent(group) + 1;
        int i = 0;
        while (iParent < group) {
            if (!this.reader.hasObjectKey(iParent)) {
                i++;
            }
            iParent += this.reader.groupSize(iParent);
        }
        return i;
    }

    private final int updatedNodeCount(int group) {
        int i;
        if (group < 0) {
            MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
            if (mutableIntIntMap == null || !mutableIntIntMap.containsKey(group)) {
                return 0;
            }
            return mutableIntIntMap.get(group);
        }
        int[] iArr = this.nodeCountOverrides;
        return (iArr == null || (i = iArr[group]) < 0) ? this.reader.nodeCount(group) : i;
    }

    private final void updateNodeCount(int group, int count) {
        if (updatedNodeCount(group) != count) {
            if (group < 0) {
                MutableIntIntMap mutableIntIntMap = this.nodeCountVirtualOverrides;
                if (mutableIntIntMap == null) {
                    mutableIntIntMap = new MutableIntIntMap(0, 1, null);
                    this.nodeCountVirtualOverrides = mutableIntIntMap;
                }
                mutableIntIntMap.set(group, count);
                return;
            }
            int[] iArr = this.nodeCountOverrides;
            if (iArr == null) {
                int[] iArr2 = new int[this.reader.getGroupsSize()];
                ArraysKt.fill$default(iArr2, -1, 0, 0, 6, (Object) null);
                this.nodeCountOverrides = iArr2;
                iArr = iArr2;
            }
            iArr[group] = count;
        }
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final void recordUpsAndDowns(int oldGroup, int newGroup, int commonRoot) {
        SlotReader slotReader = this.reader;
        int iNearestCommonRootOf = GapComposerKt.nearestCommonRootOf(slotReader, oldGroup, newGroup, commonRoot);
        while (oldGroup > 0 && oldGroup != iNearestCommonRootOf) {
            if (slotReader.isNode(oldGroup)) {
                this.changeListWriter.moveUp();
            }
            oldGroup = slotReader.parent(oldGroup);
        }
        doRecordDownsFor(newGroup, iNearestCommonRootOf);
    }

    private final void doRecordDownsFor(int group, int nearestCommonRoot) {
        if (group <= 0 || group == nearestCommonRoot) {
            return;
        }
        doRecordDownsFor(this.reader.parent(group), nearestCommonRoot);
        if (this.reader.isNode(group)) {
            this.changeListWriter.moveDown(nodeAt(this.reader, group));
        }
    }

    private final int groupCompositeKeyPart(SlotReader slotReader, int i) {
        Object objGroupAux;
        if (slotReader.hasObjectKey(i)) {
            Object objGroupObjectKey = slotReader.groupObjectKey(i);
            if (objGroupObjectKey != null) {
                return objGroupObjectKey instanceof Enum ? ((Enum) objGroupObjectKey).ordinal() : objGroupObjectKey instanceof MovableContent ? MovableContentKt.movableContentKey : objGroupObjectKey.hashCode();
            }
            return 0;
        }
        int iGroupKey = slotReader.groupKey(i);
        return (iGroupKey != 207 || (objGroupAux = slotReader.groupAux(i)) == null || Intrinsics.areEqual(objGroupAux, Composer.INSTANCE.getEmpty())) ? iGroupKey : objGroupAux.hashCode();
    }

    @Override // androidx.compose.runtime.InternalComposer
    public boolean tryImminentInvalidation$runtime(RecomposeScopeImpl scope, Object instance) {
        Anchor anchor = scope.getAnchor();
        if (anchor == null) {
            return false;
        }
        int indexFor = GapAnchorKt.asGapAnchor(anchor).toIndexFor(this.reader.getTable());
        if (!getIsComposing() || indexFor < this.reader.getCurrentGroup()) {
            return false;
        }
        GapComposerKt.insertIfMissing(this.invalidations, indexFor, scope, instance);
        return true;
    }

    @Override // androidx.compose.runtime.InternalComposer
    public int parentKey$runtime() {
        if (getInserting()) {
            SlotWriter slotWriter = this.writer;
            return slotWriter.groupKey(slotWriter.getParent());
        }
        SlotReader slotReader = this.reader;
        return slotReader.groupKey(slotReader.getParent());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8  */
    @Override // androidx.compose.runtime.Composer
    @androidx.compose.runtime.ComposeCompilerApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void skipCurrentGroup() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.GapComposer.skipCurrentGroup():void");
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
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

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
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
        if (this.invalidations.isEmpty()) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean changed) {
        if (!(this.groupNodeCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling deactivateToEndGroup");
        }
        if (getInserting()) {
            return;
        }
        if (!changed) {
            skipReaderToGroupEnd();
            return;
        }
        int currentGroup = this.reader.getCurrentGroup();
        int currentEnd = this.reader.getCurrentEnd();
        this.changeListWriter.deactivateCurrentGroup();
        GapComposerKt.removeRange(this.invalidations, currentGroup, currentEnd);
        this.reader.skipToGroupEnd();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public Composer startRestartGroup(int key) {
        startReplaceGroup(key);
        addRecomposeScope();
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addRecomposeScope() {
        /*
            r4 = this;
            boolean r0 = r4.getInserting()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl"
            if (r0 == 0) goto L22
            androidx.compose.runtime.RecomposeScopeImpl r0 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.CompositionImpl r2 = r4.getComposition()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r1)
            androidx.compose.runtime.RecomposeScopeOwner r2 = (androidx.compose.runtime.RecomposeScopeOwner) r2
            r0.<init>(r2)
            java.util.ArrayList<androidx.compose.runtime.RecomposeScopeImpl> r1 = r4.invalidateStack
            androidx.compose.runtime.Stack.m5062pushimpl(r1, r0)
            r4.updateValue(r0)
            r4.enterRecomposeScope(r0)
            return
        L22:
            java.util.List<androidx.compose.runtime.Invalidation> r0 = r4.invalidations
            androidx.compose.runtime.composer.gapbuffer.SlotReader r2 = r4.reader
            int r2 = r2.getParent()
            androidx.compose.runtime.Invalidation r0 = androidx.compose.runtime.GapComposerKt.access$removeLocation(r0, r2)
            androidx.compose.runtime.composer.gapbuffer.SlotReader r2 = r4.reader
            java.lang.Object r2 = r2.next()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.INSTANCE
            java.lang.Object r3 = r3.getEmpty()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r3 == 0) goto L52
            androidx.compose.runtime.RecomposeScopeImpl r2 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.CompositionImpl r3 = r4.getComposition()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r1)
            androidx.compose.runtime.RecomposeScopeOwner r3 = (androidx.compose.runtime.RecomposeScopeOwner) r3
            r2.<init>(r3)
            r4.updateValue(r2)
            goto L59
        L52:
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r1)
            androidx.compose.runtime.RecomposeScopeImpl r2 = (androidx.compose.runtime.RecomposeScopeImpl) r2
        L59:
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L6b
            boolean r0 = r2.getForcedRecompose()
            if (r0 == 0) goto L66
            r2.setForcedRecompose(r1)
        L66:
            if (r0 == 0) goto L69
            goto L6b
        L69:
            r0 = r1
            goto L6c
        L6b:
            r0 = r3
        L6c:
            r2.setRequiresRecompose(r0)
            java.util.ArrayList<androidx.compose.runtime.RecomposeScopeImpl> r0 = r4.invalidateStack
            androidx.compose.runtime.Stack.m5062pushimpl(r0, r2)
            r4.enterRecomposeScope(r2)
            boolean r0 = r2.getPaused()
            if (r0 == 0) goto L9f
            r2.setPaused(r1)
            r2.setResuming(r3)
            androidx.compose.runtime.composer.gapbuffer.changelist.ComposerChangeListWriter r0 = r4.changeListWriter
            r0.startResumingScope(r2)
            boolean r0 = r4.reusing
            if (r0 != 0) goto L9f
            boolean r0 = r2.getReusing()
            if (r0 == 0) goto L9f
            r4.reusing = r3
            androidx.compose.runtime.composer.gapbuffer.SlotReader r0 = r4.reader
            int r0 = r0.getParent()
            r4.reusingGroup = r0
            r2.setResetReusing(r3)
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.GapComposer.addRecomposeScope():void");
    }

    private final void enterRecomposeScope(RecomposeScopeImpl scope) {
        scope.start(this.compositionToken);
        CompositionObserver compositionObserverCurrent = this.observerHolder.current();
        if (compositionObserverCurrent != null) {
            compositionObserverCurrent.onScopeEnter(scope);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        GapAnchor gapAnchorAnchor;
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
                if (recomposeScopeImpl2.getResetReusing()) {
                    recomposeScopeImpl2.setResetReusing(false);
                    if (this.reusingGroup == this.reader.getParent()) {
                        this.reusing = false;
                        this.reusingGroup = -1;
                    }
                }
            }
        }
        if (recomposeScopeImpl2 != null && !recomposeScopeImpl2.getSkipped$runtime() && (recomposeScopeImpl2.getUsed() || this.forceRecomposeScopes)) {
            if (recomposeScopeImpl2.getAnchor() == null) {
                if (getInserting()) {
                    SlotWriter slotWriter = this.writer;
                    gapAnchorAnchor = slotWriter.anchor(slotWriter.getParent());
                } else {
                    SlotReader slotReader = this.reader;
                    gapAnchorAnchor = slotReader.anchor(slotReader.getParent());
                }
                recomposeScopeImpl2.setAnchor(gapAnchorAnchor);
            }
            recomposeScopeImpl2.setDefaultsInvalid(false);
            recomposeScopeImpl = recomposeScopeImpl2;
        }
        end(false);
        return recomposeScopeImpl;
    }

    private final Function1<Composition, Unit> exitRecomposeScope(RecomposeScopeImpl scope) {
        CompositionObserver compositionObserverCurrent = this.observerHolder.current();
        if (compositionObserverCurrent != null) {
            compositionObserverCurrent.onScopeExit(scope);
        }
        return scope.end(this.compositionToken);
    }

    @Override // androidx.compose.runtime.Composer
    public void insertMovableContent(MovableContent<?> value, Object parameter) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        invokeMovableContentLambda(value, currentCompositionLocalScope(), parameter, false);
    }

    private final void invokeMovableContentLambda(final MovableContent<Object> content, PersistentCompositionLocalMap locals, final Object parameter, boolean force) {
        startMovableGroup(MovableContentKt.movableContentKey, content);
        updateSlot(parameter);
        long compositeKeyHashCode = getCompositeKeyHashCode();
        try {
            this.compositeKeyHashCode = MovableContentKt.movableContentKey;
            boolean z = false;
            if (getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, null);
            }
            if (!getInserting() && !Intrinsics.areEqual(this.reader.getGroupAux(), locals)) {
                z = true;
            }
            if (z) {
                recordProviderUpdate(locals);
            }
            m5014startAzEfcrM(202, ComposerKt.getCompositionLocalMap(), GroupKind.INSTANCE.m5138getGroup9udXigM(), locals);
            this.providerCache = null;
            if (getInserting() && !force) {
                this.writerHasAProvider = true;
                SlotWriter slotWriter = this.writer;
                this.parentContext.insertMovableContent$runtime(new MovableContentStateReference(content, parameter, getComposition(), this.insertTable, slotWriter.anchor(slotWriter.parent(slotWriter.getParent())), CollectionsKt.emptyList(), currentCompositionLocalScope(), null));
            } else {
                boolean z2 = this.providersInvalid;
                this.providersInvalid = z;
                Expect_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(-59194059, true, new Function2() { // from class: androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GapComposer.invokeMovableContentLambda$lambda$0(content, parameter, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }));
                this.providersInvalid = z2;
            }
        } catch (Throwable th) {
            try {
                throw ComposeStackTraceKt.attachComposeStackTrace(th, new Function0() { // from class: androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.currentStackTrace();
                    }
                });
            } finally {
                endGroup();
                this.providerCache = null;
                this.compositeKeyHashCode = compositeKeyHashCode;
                endMovableGroup();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeMovableContentLambda$lambda$0(MovableContent movableContent, Object obj, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C2265@91036L18:GapComposer.kt#9igjgp");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-59194059, i, -1, "androidx.compose.runtime.GapComposer.invokeMovableContentLambda.<anonymous> (GapComposer.kt:2265)");
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

    @Override // androidx.compose.runtime.Composer
    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        Object objBeginSection = Trace.INSTANCE.beginSection("Compose:insertMovableContent");
        try {
            try {
                insertMovableContentGuarded(references);
                cleanUpCompose();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                abortRoot();
                throw th;
            }
        } finally {
            Trace.INSTANCE.endSection(objBeginSection);
        }
    }

    private final void insertMovableContentGuarded(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) throws Throwable {
        ComposerChangeListWriter composerChangeListWriter;
        ChangeList changeList;
        ComposerChangeListWriter composerChangeListWriter2;
        ChangeList changeList2;
        SlotReader slotReader;
        int[] iArr;
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap;
        ChangeList changeList3;
        int i;
        int i2;
        GapAnchor gapAnchorAnchor;
        SlotStorage slotStorage;
        List<Pair<MovableContentStateReference, MovableContentStateReference>> list = references;
        ComposerChangeListWriter composerChangeListWriter3 = this.changeListWriter;
        ChangeList changeListAsGapBufferChangeList = ChangeListKt.asGapBufferChangeList(this.lateChanges);
        ChangeList changeList4 = composerChangeListWriter3.getChangeList();
        try {
            composerChangeListWriter3.setChangeList(changeListAsGapBufferChangeList);
            this.changeListWriter.resetSlots();
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                try {
                    Pair<MovableContentStateReference, MovableContentStateReference> pair = list.get(i4);
                    final MovableContentStateReference movableContentStateReferenceComponent1 = pair.component1();
                    MovableContentStateReference movableContentStateReferenceComponent2 = pair.component2();
                    GapAnchor gapAnchorAsGapAnchor = GapAnchorKt.asGapAnchor(movableContentStateReferenceComponent1.getAnchor());
                    SlotTable slotTableAsGapBufferSlotTable = SlotTableKt.asGapBufferSlotTable(movableContentStateReferenceComponent1.getSlotStorage());
                    int iAnchorIndex = slotTableAsGapBufferSlotTable.anchorIndex(gapAnchorAsGapAnchor);
                    IntRef intRef = new IntRef(i3, 1, null);
                    this.changeListWriter.determineMovableContentNodeIndex(intRef, gapAnchorAsGapAnchor);
                    if (movableContentStateReferenceComponent2 == null) {
                        if (Intrinsics.areEqual(slotTableAsGapBufferSlotTable, this.insertTable)) {
                            createFreshInsertTable();
                        }
                        final SlotReader slotReaderOpenReader = slotTableAsGapBufferSlotTable.openReader();
                        try {
                            slotReaderOpenReader.reposition(iAnchorIndex);
                            this.changeListWriter.moveReaderToAbsolute(iAnchorIndex);
                            final ChangeList changeList5 = new ChangeList();
                            recomposeMovableContent$default(this, null, null, null, null, new Function0() { // from class: androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return GapComposer.insertMovableContentGuarded$lambda$0$0$0$0(this.f$0, changeList5, slotReaderOpenReader, movableContentStateReferenceComponent1);
                                }
                            }, 15, null);
                            this.changeListWriter.includeOperationsIn(changeList5, intRef);
                            Unit unit = Unit.INSTANCE;
                            slotReaderOpenReader.close();
                            composerChangeListWriter2 = composerChangeListWriter3;
                            changeList2 = changeList4;
                            i = size;
                            i2 = i4;
                        } finally {
                        }
                    } else {
                        MovableContentState movableContentStateMovableContentStateResolve$runtime = this.parentContext.movableContentStateResolve$runtime(movableContentStateReferenceComponent2);
                        SlotTable slotTableAsGapBufferSlotTable2 = (movableContentStateMovableContentStateResolve$runtime == null || (slotStorage = movableContentStateMovableContentStateResolve$runtime.getSlotStorage()) == null) ? null : SlotTableKt.asGapBufferSlotTable(slotStorage);
                        SlotTable slotTableAsGapBufferSlotTable3 = slotTableAsGapBufferSlotTable2 == null ? SlotTableKt.asGapBufferSlotTable(movableContentStateReferenceComponent2.getSlotStorage()) : slotTableAsGapBufferSlotTable2;
                        GapAnchor gapAnchorAsGapAnchor2 = GapAnchorKt.asGapAnchor((slotTableAsGapBufferSlotTable2 == null || (gapAnchorAnchor = slotTableAsGapBufferSlotTable2.anchor(0)) == null) ? movableContentStateReferenceComponent2.getAnchor() : gapAnchorAnchor);
                        List<? extends Object> listCollectNodesFrom = GapComposerKt.collectNodesFrom(slotTableAsGapBufferSlotTable3, gapAnchorAsGapAnchor2);
                        if (!listCollectNodesFrom.isEmpty()) {
                            this.changeListWriter.copyNodesToNewAnchorLocation(listCollectNodesFrom, intRef);
                            if (Intrinsics.areEqual(slotTableAsGapBufferSlotTable, this.slotTable)) {
                                int iAnchorIndex2 = this.slotTable.anchorIndex(gapAnchorAsGapAnchor);
                                updateNodeCount(iAnchorIndex2, updatedNodeCount(iAnchorIndex2) + listCollectNodesFrom.size());
                            }
                        }
                        this.changeListWriter.copySlotTableToAnchorLocation(movableContentStateMovableContentStateResolve$runtime, this.parentContext, movableContentStateReferenceComponent2, movableContentStateReferenceComponent1);
                        SlotReader slotReaderOpenReader2 = slotTableAsGapBufferSlotTable3.openReader();
                        try {
                            SlotReader slotReader2 = this.reader;
                            int[] iArr2 = this.nodeCountOverrides;
                            MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap2 = this.providerUpdates;
                            this.nodeCountOverrides = null;
                            this.providerUpdates = null;
                            try {
                                this.reader = slotReaderOpenReader2;
                                int iAnchorIndex3 = slotTableAsGapBufferSlotTable3.anchorIndex(GapAnchorKt.asGapAnchor(gapAnchorAsGapAnchor2));
                                slotReaderOpenReader2.reposition(iAnchorIndex3);
                                this.changeListWriter.moveReaderToAbsolute(iAnchorIndex3);
                                ChangeList changeList6 = new ChangeList();
                                ComposerChangeListWriter composerChangeListWriter4 = this.changeListWriter;
                                ChangeList changeList7 = composerChangeListWriter4.getChangeList();
                                try {
                                    composerChangeListWriter4.setChangeList(changeList6);
                                    slotReader = slotReaderOpenReader2;
                                    try {
                                        ComposerChangeListWriter composerChangeListWriter5 = this.changeListWriter;
                                        i = size;
                                        boolean implicitRootStart = composerChangeListWriter5.getImplicitRootStart();
                                        try {
                                            composerChangeListWriter5.setImplicitRootStart(false);
                                            try {
                                                i2 = i4;
                                                iArr = iArr2;
                                                composerChangeListWriter2 = composerChangeListWriter3;
                                                mutableIntObjectMap = mutableIntObjectMap2;
                                                changeList2 = changeList4;
                                                changeList3 = changeList7;
                                                try {
                                                    recomposeMovableContent(movableContentStateReferenceComponent2.getComposition(), movableContentStateReferenceComponent1.getComposition(), Integer.valueOf(slotReader.getCurrentGroup()), movableContentStateReferenceComponent2.getInvalidations$runtime(), new Function0() { // from class: androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda2
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            return GapComposer.insertMovableContentGuarded$lambda$0$0$1$0$0$0$0(this.f$0, movableContentStateReferenceComponent1);
                                                        }
                                                    });
                                                    try {
                                                        composerChangeListWriter5.setImplicitRootStart(implicitRootStart);
                                                        try {
                                                            composerChangeListWriter4.setChangeList(changeList3);
                                                            this.changeListWriter.includeOperationsIn(changeList6, intRef);
                                                            Unit unit2 = Unit.INSTANCE;
                                                            try {
                                                                this.reader = slotReader2;
                                                                this.nodeCountOverrides = iArr;
                                                                this.providerUpdates = mutableIntObjectMap;
                                                                Unit unit3 = Unit.INSTANCE;
                                                                try {
                                                                    slotReader.close();
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    composerChangeListWriter = composerChangeListWriter2;
                                                                    changeList = changeList2;
                                                                    composerChangeListWriter.setChangeList(changeList);
                                                                    throw th;
                                                                }
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                slotReader.close();
                                                                throw th;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            this.reader = slotReader2;
                                                            this.nodeCountOverrides = iArr;
                                                            this.providerUpdates = mutableIntObjectMap;
                                                            throw th;
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        composerChangeListWriter4.setChangeList(changeList3);
                                                        throw th;
                                                    }
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    composerChangeListWriter5.setImplicitRootStart(implicitRootStart);
                                                    throw th;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                iArr = iArr2;
                                                changeList3 = changeList7;
                                                mutableIntObjectMap = mutableIntObjectMap2;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            iArr = iArr2;
                                            mutableIntObjectMap = mutableIntObjectMap2;
                                            changeList3 = changeList7;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        iArr = iArr2;
                                        mutableIntObjectMap = mutableIntObjectMap2;
                                        changeList3 = changeList7;
                                        composerChangeListWriter4.setChangeList(changeList3);
                                        throw th;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    iArr = iArr2;
                                    slotReader = slotReaderOpenReader2;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                iArr = iArr2;
                                slotReader = slotReaderOpenReader2;
                                mutableIntObjectMap = mutableIntObjectMap2;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            slotReader = slotReaderOpenReader2;
                        }
                    }
                    this.changeListWriter.skipToEndOfCurrentGroup();
                    i4 = i2 + 1;
                    list = references;
                    size = i;
                    composerChangeListWriter3 = composerChangeListWriter2;
                    changeList4 = changeList2;
                    i3 = 0;
                } catch (Throwable th12) {
                    th = th12;
                    composerChangeListWriter2 = composerChangeListWriter3;
                    changeList2 = changeList4;
                }
            }
            ComposerChangeListWriter composerChangeListWriter6 = composerChangeListWriter3;
            ChangeList changeList8 = changeList4;
            this.changeListWriter.endMovableContentPlacement();
            this.changeListWriter.moveReaderToAbsolute(0);
            composerChangeListWriter6.setChangeList(changeList8);
        } catch (Throwable th13) {
            th = th13;
            composerChangeListWriter = composerChangeListWriter3;
            changeList = changeList4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertMovableContentGuarded$lambda$0$0$0$0(GapComposer gapComposer, ChangeList changeList, SlotReader slotReader, MovableContentStateReference movableContentStateReference) {
        ComposerChangeListWriter composerChangeListWriter = gapComposer.changeListWriter;
        ChangeList changeList2 = composerChangeListWriter.getChangeList();
        try {
            composerChangeListWriter.setChangeList(changeList);
            SlotReader slotReader2 = gapComposer.reader;
            int[] iArr = gapComposer.nodeCountOverrides;
            MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = gapComposer.providerUpdates;
            gapComposer.nodeCountOverrides = null;
            gapComposer.providerUpdates = null;
            try {
                gapComposer.reader = slotReader;
                ComposerChangeListWriter composerChangeListWriter2 = gapComposer.changeListWriter;
                boolean implicitRootStart = composerChangeListWriter2.getImplicitRootStart();
                try {
                    composerChangeListWriter2.setImplicitRootStart(false);
                    gapComposer.invokeMovableContentLambda(movableContentStateReference.getContent$runtime(), movableContentStateReference.getLocals(), movableContentStateReference.getParameter(), true);
                    composerChangeListWriter2.setImplicitRootStart(implicitRootStart);
                    Unit unit = Unit.INSTANCE;
                    composerChangeListWriter.setChangeList(changeList2);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    composerChangeListWriter2.setImplicitRootStart(implicitRootStart);
                    throw th;
                }
            } finally {
                gapComposer.reader = slotReader2;
                gapComposer.nodeCountOverrides = iArr;
                gapComposer.providerUpdates = mutableIntObjectMap;
            }
        } catch (Throwable th2) {
            composerChangeListWriter.setChangeList(changeList2);
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertMovableContentGuarded$lambda$0$0$1$0$0$0$0(GapComposer gapComposer, MovableContentStateReference movableContentStateReference) {
        gapComposer.invokeMovableContentLambda(movableContentStateReference.getContent$runtime(), movableContentStateReference.getLocals(), movableContentStateReference.getParameter(), true);
        return Unit.INSTANCE;
    }

    private final <R> R withReader(SlotReader reader, Function0<? extends R> block) {
        SlotReader slotReader = this.reader;
        int[] iArr = this.nodeCountOverrides;
        MutableIntObjectMap<PersistentCompositionLocalMap> mutableIntObjectMap = this.providerUpdates;
        this.nodeCountOverrides = null;
        this.providerUpdates = null;
        try {
            this.reader = reader;
            return block.invoke();
        } finally {
            this.reader = slotReader;
            this.nodeCountOverrides = iArr;
            this.providerUpdates = mutableIntObjectMap;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object recomposeMovableContent$default(GapComposer gapComposer, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            controlledComposition = null;
        }
        if ((i & 2) != 0) {
            controlledComposition2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        return gapComposer.recomposeMovableContent(controlledComposition, controlledComposition2, num, list, function0);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #0 {all -> 0x004b, blocks: (B:3:0x0007, B:5:0x0015, B:7:0x0027, B:9:0x002f, B:8:0x002b, B:12:0x0036, B:14:0x003c, B:16:0x0042), top: B:22:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final <R> R recomposeMovableContent(androidx.compose.runtime.ControlledComposition r7, androidx.compose.runtime.ControlledComposition r8, java.lang.Integer r9, java.util.List<? extends kotlin.Pair<androidx.compose.runtime.RecomposeScopeImpl, ? extends java.lang.Object>> r10, kotlin.jvm.functions.Function0<? extends R> r11) {
        /*
            r6 = this;
            boolean r0 = r6.getIsComposing()
            int r1 = r6.nodeIndex
            r2 = 1
            r6.isComposing = r2     // Catch: java.lang.Throwable -> L4b
            r2 = 0
            r6.nodeIndex = r2     // Catch: java.lang.Throwable -> L4b
            r3 = r10
            java.util.Collection r3 = (java.util.Collection) r3     // Catch: java.lang.Throwable -> L4b
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L4b
        L13:
            if (r2 >= r3) goto L32
            java.lang.Object r4 = r10.get(r2)     // Catch: java.lang.Throwable -> L4b
            kotlin.Pair r4 = (kotlin.Pair) r4     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r5 = r4.component1()     // Catch: java.lang.Throwable -> L4b
            androidx.compose.runtime.RecomposeScopeImpl r5 = (androidx.compose.runtime.RecomposeScopeImpl) r5     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r4 = r4.component2()     // Catch: java.lang.Throwable -> L4b
            if (r4 == 0) goto L2b
            r6.tryImminentInvalidation$runtime(r5, r4)     // Catch: java.lang.Throwable -> L4b
            goto L2f
        L2b:
            r4 = 0
            r6.tryImminentInvalidation$runtime(r5, r4)     // Catch: java.lang.Throwable -> L4b
        L2f:
            int r2 = r2 + 1
            goto L13
        L32:
            if (r7 == 0) goto L42
            if (r9 == 0) goto L3b
            int r9 = r9.intValue()     // Catch: java.lang.Throwable -> L4b
            goto L3c
        L3b:
            r9 = -1
        L3c:
            java.lang.Object r7 = r7.delegateInvalidations(r8, r9, r11)     // Catch: java.lang.Throwable -> L4b
            if (r7 != 0) goto L46
        L42:
            java.lang.Object r7 = r11.invoke()     // Catch: java.lang.Throwable -> L4b
        L46:
            r6.isComposing = r0
            r6.nodeIndex = r1
            return r7
        L4b:
            r7 = move-exception
            r6.isComposing = r0
            r6.nodeIndex = r1
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.GapComposer.recomposeMovableContent(androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.ControlledComposition, java.lang.Integer, java.util.List, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformation(String sourceInformation) {
        if (getInserting() && getSourceMarkersEnabled()) {
            this.writer.recordGroupSourceInformation(sourceInformation);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int key, String sourceInformation) {
        if (getInserting() && getSourceMarkersEnabled()) {
            this.writer.recordGrouplessCallSourceInformationStart(key, sourceInformation);
        }
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        if (getInserting() && getSourceMarkersEnabled()) {
            this.writer.recordGrouplessCallSourceInformationEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void disableSourceInformation() {
        setSourceMarkersEnabled$runtime(false);
    }

    @Override // androidx.compose.runtime.InternalComposer
    public ComposeStackTrace stackTraceForValue$runtime(final Object value) {
        List listEmptyList;
        ObjectLocation objectLocationFindLocation = ComposeStackTraceBuilderKt.findLocation(this.slotTable, new Function1() { // from class: androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GapComposer.stackTraceForValue$lambda$0(value, obj));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final ComposeStackTrace currentStackTrace() {
        if (!this.parentContext.getStackTraceEnabled$runtime()) {
            return null;
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.addAll(ComposeStackTraceBuilderKt.buildTrace$default(this.writer, null, 0, null, 7, null));
        listCreateListBuilder.addAll(ComposeStackTraceBuilderKt.buildTrace(this.reader));
        listCreateListBuilder.addAll(parentStackTrace$runtime());
        return new ComposeStackTrace(CollectionsKt.build(listCreateListBuilder), getSourceMarkersEnabled());
    }

    private final List<ComposeStackTraceFrame> stackTraceForGroup(int group, Integer dataOffset) {
        SlotReader slotReaderOpenReader = this.slotTable.openReader();
        try {
            return ComposeStackTraceBuilderKt.traceForGroup(slotReaderOpenReader, group, dataOffset);
        } finally {
            slotReaderOpenReader.close();
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    public List<ComposeStackTraceFrame> parentStackTrace$runtime() {
        Composition composition$runtime = this.parentContext.getComposition$runtime();
        CompositionImpl compositionImpl = composition$runtime instanceof CompositionImpl ? (CompositionImpl) composition$runtime : null;
        if (compositionImpl == null) {
            return CollectionsKt.emptyList();
        }
        Integer numFindSubcompositionContextGroup = ComposeStackTraceBuilderKt.findSubcompositionContextGroup(SlotTableKt.asGapBufferSlotTable(compositionImpl.getSlotStorage()), this.parentContext);
        if (numFindSubcompositionContextGroup == null) {
            return CollectionsKt.emptyList();
        }
        SlotReader slotReaderOpenReader = SlotTableKt.asGapBufferSlotTable(compositionImpl.getSlotStorage()).openReader();
        try {
            List<ComposeStackTraceFrame> listTraceForGroup = ComposeStackTraceBuilderKt.traceForGroup(slotReaderOpenReader, numFindSubcompositionContextGroup.intValue(), 0);
            slotReaderOpenReader.close();
            return CollectionsKt.plus((Collection) listTraceForGroup, (Iterable) compositionImpl.getComposer().parentStackTrace$runtime());
        } catch (Throwable th) {
            slotReaderOpenReader.close();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.InternalComposer
    /* JADX INFO: renamed from: composeContent--ZbOJvo$runtime, reason: not valid java name */
    public void mo5015composeContentZbOJvo$runtime(MutableScatterMap<Object, Object> invalidationsRequested, Function2<? super Composer, ? super Integer, Unit> content, ShouldPauseCallback shouldPause) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        this.shouldPauseCallback = shouldPause;
        try {
            m5013doComposeaFTiNEg(invalidationsRequested, content);
        } finally {
            this.shouldPauseCallback = null;
        }
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

    @Override // androidx.compose.runtime.InternalComposer
    /* JADX INFO: renamed from: recompose-aFTiNEg$runtime, reason: not valid java name */
    public boolean mo5016recomposeaFTiNEg$runtime(MutableScatterMap<Object, Object> invalidationsRequested, ShouldPauseCallback shouldPause) {
        if (!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        if (ScopeMap.m5117getSizeimpl(invalidationsRequested) <= 0 && this.invalidations.isEmpty() && !this.forciblyRecompose) {
            return false;
        }
        this.shouldPauseCallback = shouldPause;
        try {
            m5013doComposeaFTiNEg(invalidationsRequested, null);
            this.shouldPauseCallback = null;
            return this.changes.isNotEmpty();
        } catch (Throwable th) {
            this.shouldPauseCallback = null;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    @Override // androidx.compose.runtime.InternalComposer
    /* JADX INFO: renamed from: updateComposerInvalidations-RY85e9Y$runtime, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo5017updateComposerInvalidationsRY85e9Y$runtime(androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r18) {
        /*
            r17 = this;
            r0 = r17
            java.util.List<androidx.compose.runtime.Invalidation> r1 = r0.invalidations
            int r1 = kotlin.collections.CollectionsKt.getLastIndex(r1)
        L8:
            r3 = -1
            if (r3 >= r1) goto L45
            java.util.List<androidx.compose.runtime.Invalidation> r3 = r0.invalidations
            java.lang.Object r3 = r3.get(r1)
            androidx.compose.runtime.Invalidation r3 = (androidx.compose.runtime.Invalidation) r3
            androidx.compose.runtime.RecomposeScopeImpl r4 = r3.getScope()
            androidx.compose.runtime.Anchor r4 = r4.getAnchor()
            if (r4 == 0) goto L22
            androidx.compose.runtime.composer.gapbuffer.GapAnchor r2 = androidx.compose.runtime.composer.gapbuffer.GapAnchorKt.asGapAnchor(r4)
            goto L23
        L22:
            r2 = 0
        L23:
            if (r2 == 0) goto L3d
            boolean r4 = r2.getValid()
            if (r4 == 0) goto L3d
            int r4 = r3.getLocation()
            int r5 = r2.getLocation()
            if (r4 == r5) goto L42
            int r2 = r2.getLocation()
            r3.setLocation(r2)
            goto L42
        L3d:
            java.util.List<androidx.compose.runtime.Invalidation> r2 = r0.invalidations
            r2.remove(r1)
        L42:
            int r1 = r1 + (-1)
            goto L8
        L45:
            r1 = r18
            androidx.collection.ScatterMap r1 = (androidx.collection.ScatterMap) r1
            java.lang.Object[] r3 = r1.keys
            java.lang.Object[] r4 = r1.values
            long[] r1 = r1.metadata
            int r5 = r1.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto Lb2
            r7 = 0
        L55:
            r8 = r1[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto Lad
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = 0
        L6f:
            if (r12 >= r10) goto Lab
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto La7
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r4[r13]
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r15)
            androidx.compose.runtime.RecomposeScopeImpl r14 = (androidx.compose.runtime.RecomposeScopeImpl) r14
            androidx.compose.runtime.Anchor r15 = r14.getAnchor()
            if (r15 == 0) goto La7
            androidx.compose.runtime.composer.gapbuffer.GapAnchor r15 = androidx.compose.runtime.composer.gapbuffer.GapAnchorKt.asGapAnchor(r15)
            if (r15 == 0) goto La7
            int r15 = r15.getLocation()
            java.util.List<androidx.compose.runtime.Invalidation> r2 = r0.invalidations
            androidx.compose.runtime.ScopeInvalidated r6 = androidx.compose.runtime.ScopeInvalidated.INSTANCE
            if (r13 != r6) goto L9f
            r13 = 0
        L9f:
            androidx.compose.runtime.Invalidation r6 = new androidx.compose.runtime.Invalidation
            r6.<init>(r14, r15, r13)
            r2.add(r6)
        La7:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L6f
        Lab:
            if (r10 != r11) goto Lb2
        Lad:
            if (r7 == r5) goto Lb2
            int r7 = r7 + 1
            goto L55
        Lb2:
            java.util.List<androidx.compose.runtime.Invalidation> r1 = r0.invalidations
            java.util.Comparator r2 = androidx.compose.runtime.GapComposerKt.access$getInvalidationLocationAscending$p()
            kotlin.collections.CollectionsKt.sortWith(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.GapComposer.mo5017updateComposerInvalidationsRY85e9Y$runtime(androidx.collection.MutableScatterMap):void");
    }

    /* JADX INFO: renamed from: doCompose-aFTiNEg, reason: not valid java name */
    private final void m5013doComposeaFTiNEg(MutableScatterMap<Object, Object> invalidationsRequested, Function2<? super Composer, ? super Integer, Unit> content) {
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
                Object objNextSlot = nextSlot();
                if (objNextSlot != content && content != null) {
                    updateValue(content);
                }
                GapComposer$derivedStateObserver$1 gapComposer$derivedStateObserver$1 = this.derivedStateObserver;
                MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
                try {
                    mutableVectorDerivedStateObservers.add(gapComposer$derivedStateObserver$1);
                    if (content != null) {
                        startGroup(200, ComposerKt.getInvocation());
                        Expect_jvmKt.invokeComposable(this, content);
                        endGroup();
                    } else if ((this.forciblyRecompose || this.providersInvalid) && objNextSlot != null && !Intrinsics.areEqual(objNextSlot, Composer.INSTANCE.getEmpty())) {
                        startGroup(200, ComposerKt.getInvocation());
                        Expect_jvmKt.invokeComposable(this, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(objNextSlot, 2));
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
                    this.invalidations.clear();
                    createFreshInsertTable();
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

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    private final Object getNode(SlotReader slotReader) {
        return slotReader.node(slotReader.getParent());
    }

    private final Object nodeAt(SlotReader slotReader, int i) {
        return slotReader.node(i);
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

    private final void recordInsert(GapAnchor anchor) {
        if (this.insertFixups.isEmpty()) {
            this.changeListWriter.insertSlots(anchor, this.insertTable);
        } else {
            this.changeListWriter.insertSlots(anchor, this.insertTable, this.insertFixups);
            this.insertFixups = new FixupList();
        }
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        this.changeListWriter.removeCurrentGroup();
    }

    private static final MovableContentStateReference reportFreeMovableContent$createMovableContentReferenceForGroup(GapComposer gapComposer, int i, List<MovableContentStateReference> list) {
        Object objGroupObjectKey = gapComposer.reader.groupObjectKey(i);
        Intrinsics.checkNotNull(objGroupObjectKey, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        MovableContent movableContent = (MovableContent) objGroupObjectKey;
        Object objGroupGet = gapComposer.reader.groupGet(i, 0);
        GapAnchor gapAnchorAnchor = gapComposer.reader.anchor(i);
        int iGroupSize = gapComposer.reader.groupSize(i) + i;
        ArrayList arrayList = new ArrayList();
        List<Invalidation> list2 = gapComposer.invalidations;
        for (int iFindInsertLocation = GapComposerKt.findInsertLocation(list2, i); iFindInsertLocation < list2.size(); iFindInsertLocation++) {
            Invalidation invalidation = list2.get(iFindInsertLocation);
            if (invalidation.getLocation() >= iGroupSize) {
                break;
            }
            arrayList.add(TuplesKt.to(invalidation.getScope(), invalidation.getInstances()));
        }
        return new MovableContentStateReference(movableContent, objGroupGet, gapComposer.getComposition(), gapComposer.slotTable, gapAnchorAnchor, arrayList, gapComposer.currentCompositionLocalScope(i), list);
    }

    private static final MovableContentStateReference reportFreeMovableContent$movableContentReferenceFor(GapComposer gapComposer, int i) {
        int iGroupKey = gapComposer.reader.groupKey(i);
        Object objGroupObjectKey = gapComposer.reader.groupObjectKey(i);
        ArrayList arrayList = null;
        if (iGroupKey != 126665345 || !(objGroupObjectKey instanceof MovableContent)) {
            return null;
        }
        if (gapComposer.reader.containsMark(i)) {
            ArrayList arrayList2 = new ArrayList();
            reportFreeMovableContent$movableContentReferenceFor$traverseGroups(gapComposer, arrayList2, i);
            if (!arrayList2.isEmpty()) {
                arrayList = arrayList2;
            }
        }
        return reportFreeMovableContent$createMovableContentReferenceForGroup(gapComposer, i, arrayList);
    }

    private static final void reportFreeMovableContent$movableContentReferenceFor$traverseGroups(GapComposer gapComposer, List<MovableContentStateReference> list, int i) {
        int iGroupSize = gapComposer.reader.groupSize(i) + i;
        int iGroupSize2 = i + 1;
        while (iGroupSize2 < iGroupSize) {
            if (gapComposer.reader.hasMark(iGroupSize2)) {
                MovableContentStateReference movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor = reportFreeMovableContent$movableContentReferenceFor(gapComposer, iGroupSize2);
                if (movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor != null) {
                    list.add(movableContentStateReferenceReportFreeMovableContent$movableContentReferenceFor);
                }
            } else if (gapComposer.reader.containsMark(iGroupSize2)) {
                reportFreeMovableContent$movableContentReferenceFor$traverseGroups(gapComposer, list, iGroupSize2);
            }
            iGroupSize2 += gapComposer.reader.groupSize(iGroupSize2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int reportFreeMovableContent$reportGroup(androidx.compose.runtime.GapComposer r17, int r18, int r19, boolean r20, int r21) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.GapComposer.reportFreeMovableContent$reportGroup(androidx.compose.runtime.GapComposer, int, int, boolean, int):int");
    }

    private final void reportFreeMovableContent(int groupBeingRemoved) {
        boolean zIsNode = this.reader.isNode(groupBeingRemoved);
        if (zIsNode) {
            this.changeListWriter.endNodeMovement();
            this.changeListWriter.moveDown(this.reader.node(groupBeingRemoved));
        }
        reportFreeMovableContent$reportGroup(this, groupBeingRemoved, groupBeingRemoved, zIsNode, 0);
        this.changeListWriter.endNodeMovement();
        if (zIsNode) {
            this.changeListWriter.moveUp();
        }
    }

    private final void reportAllMovableContent() {
        if (this.slotTable.containsMark()) {
            getComposition().updateMovingInvalidations$runtime();
            ChangeList changeList = new ChangeList();
            setDeferredChanges$runtime(changeList);
            SlotReader slotReaderOpenReader = this.slotTable.openReader();
            try {
                this.reader = slotReaderOpenReader;
                ComposerChangeListWriter composerChangeListWriter = this.changeListWriter;
                ChangeList changeList2 = composerChangeListWriter.getChangeList();
                try {
                    composerChangeListWriter.setChangeList(changeList);
                    reportFreeMovableContent(0);
                    this.changeListWriter.releaseMovableContent();
                    composerChangeListWriter.setChangeList(changeList2);
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    composerChangeListWriter.setChangeList(changeList2);
                    throw th;
                }
            } finally {
                slotReaderOpenReader.close();
            }
        }
    }

    private final void finalizeCompose() {
        this.changeListWriter.finalizeComposition();
        if (!Stack.m5057isEmptyimpl(this.pendingStack)) {
            ComposerKt.composeImmediateRuntimeError("Start/end imbalance");
        }
        cleanUpCompose();
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.compositeKeyHashCode = 0L;
        this.nodeExpected = false;
        this.changeListWriter.resetTransientState();
        Stack.m5050clearimpl(this.invalidateStack);
        clearUpdatedNodeCounts();
    }

    @Override // androidx.compose.runtime.InternalComposer
    public void verifyConsistent$runtime() {
        this.insertTable.verifyWellFormed();
    }

    /* JADX INFO: compiled from: GapComposer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/GapComposer$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/GapComposer$CompositionContextImpl;", "Landroidx/compose/runtime/GapComposer;", "<init>", "(Landroidx/compose/runtime/GapComposer$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/GapComposer$CompositionContextImpl;", "onRemembered", "", "onAbandoned", "onForgotten", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GapComposer.kt */
    @Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010$\u001a\u00020%J\u0015\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0010¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0010¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0010¢\u0006\u0002\b/J\u0015\u00100\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0010¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020%2\u0006\u00103\u001a\u000204H\u0010¢\u0006\u0002\b5J*\u0010:\u001a\u00020%2\u0006\u0010-\u001a\u00020.2\u0011\u0010;\u001a\r\u0012\u0004\u0012\u00020%0<¢\u0006\u0002\b=H\u0011¢\u0006\u0004\b>\u0010?J8\u0010@\u001a\b\u0012\u0004\u0012\u0002040A2\u0006\u0010-\u001a\u00020.2\u0006\u0010B\u001a\u00020C2\u0011\u0010;\u001a\r\u0012\u0004\u0012\u00020%0<¢\u0006\u0002\b=H\u0011¢\u0006\u0004\bD\u0010EJ1\u0010F\u001a\b\u0012\u0004\u0012\u0002040A2\u0006\u0010-\u001a\u00020.2\u0006\u0010B\u001a\u00020C2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002040AH\u0010¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0010¢\u0006\u0002\bJJ\u0015\u0010K\u001a\u00020%2\u0006\u00103\u001a\u000204H\u0010¢\u0006\u0002\bLJ\r\u0010P\u001a\u00020NH\u0010¢\u0006\u0002\bVJ\u000e\u0010W\u001a\u00020%2\u0006\u00103\u001a\u00020NJ\u001b\u0010X\u001a\u00020%2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0010¢\u0006\u0002\bZJ\r\u0010[\u001a\u00020%H\u0010¢\u0006\u0002\b\\J\r\u0010]\u001a\u00020%H\u0010¢\u0006\u0002\b^J\u0015\u0010_\u001a\u00020%2\u0006\u0010`\u001a\u00020aH\u0010¢\u0006\u0002\bbJ\u0015\u0010c\u001a\u00020%2\u0006\u0010`\u001a\u00020aH\u0010¢\u0006\u0002\bdJ\u0017\u0010e\u001a\u0004\u0018\u00010f2\u0006\u0010`\u001a\u00020aH\u0010¢\u0006\u0002\bgJ)\u0010h\u001a\u00020%2\u0006\u0010`\u001a\u00020a2\u0006\u0010i\u001a\u00020f2\n\u0010j\u001a\u0006\u0012\u0002\b\u00030kH\u0010¢\u0006\u0002\blJ\u0015\u0010m\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0010¢\u0006\u0002\bnJ\u0016\u0010r\u001a\u00020s2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020%0<H\u0016R\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0090\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0010R\u0014\u0010\"\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0010R\u0014\u00106\u001a\u0002078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R+\u0010O\u001a\u00020N2\u0006\u0010M\u001a\u00020N8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0014\u0010-\u001a\u00020o8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bp\u0010q¨\u0006u"}, d2 = {"Landroidx/compose/runtime/GapComposer$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHashCode", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "collectingParameterInformation", "", "collectingSourceInformation", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "<init>", "(Landroidx/compose/runtime/GapComposer;JZZLandroidx/compose/runtime/CompositionObserverHolder;)V", "getCompositeKeyHashCode$runtime", "()J", "J", "getCollectingParameterInformation$runtime", "()Z", "getCollectingSourceInformation$runtime", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "inspectionTables", "", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "()Ljava/util/Set;", "setInspectionTables", "(Ljava/util/Set;)V", "composers", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/GapComposer;", "getComposers", "()Landroidx/collection/MutableScatterSet;", "collectingCallByInformation", "getCollectingCallByInformation$runtime", "stackTraceEnabled", "getStackTraceEnabled$runtime", "dispose", "", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime", "unregisterComposer", "unregisterComposer$runtime", "registerComposition", "composition", "Landroidx/compose/runtime/ControlledComposition;", "registerComposition$runtime", "unregisterComposition", "unregisterComposition$runtime", "reportPausedScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "reportPausedScope$runtime", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "composeInitial", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitialPaused", "Landroidx/collection/ScatterSet;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function2;)Landroidx/collection/ScatterSet;", "recomposePaused", "invalidScopes", "recomposePaused$runtime", "invalidate", "invalidate$runtime", "invalidateScope", "invalidateScope$runtime", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompositionLocalScope$runtime", "updateCompositionLocalScope", "recordInspectionTable", "table", "recordInspectionTable$runtime", "startComposing", "startComposing$runtime", "doneComposing", "doneComposing$runtime", "insertMovableContent", ReferenceElement.ELEMENT, "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContent$runtime", "deletedMovableContent", "deletedMovableContent$runtime", "movableContentStateResolve", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve$runtime", "movableContentStateReleased", "data", "applier", "Landroidx/compose/runtime/Applier;", "movableContentStateReleased$runtime", "reportRemovedComposition", "reportRemovedComposition$runtime", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;
        private final long compositeKeyHashCode;
        private Set<Set<CompositionData>> inspectionTables;
        private final CompositionObserverHolder observerHolder;
        private final MutableScatterSet<GapComposer> composers = ScatterSetKt.mutableScatterSetOf();

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

        public final MutableScatterSet<GapComposer> getComposers() {
            return this.composers;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingCallByInformation$runtime() {
            return GapComposer.this.parentContext.getCollectingCallByInformation$runtime();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getStackTraceEnabled$runtime() {
            return GapComposer.this.parentContext.getStackTraceEnabled$runtime();
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void dispose() {
            /*
                r15 = this;
                androidx.collection.MutableScatterSet<androidx.compose.runtime.GapComposer> r0 = r15.composers
                boolean r0 = r0.isNotEmpty()
                if (r0 == 0) goto L6f
                java.util.Set<java.util.Set<androidx.compose.runtime.tooling.CompositionData>> r0 = r15.inspectionTables
                if (r0 == 0) goto L6a
                androidx.collection.MutableScatterSet<androidx.compose.runtime.GapComposer> r1 = r15.composers
                androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
                java.lang.Object[] r2 = r1.elements
                long[] r1 = r1.metadata
                int r3 = r1.length
                int r3 = r3 + (-2)
                if (r3 < 0) goto L6a
                r4 = 0
                r5 = r4
            L1b:
                r6 = r1[r5]
                long r8 = ~r6
                r10 = 7
                long r8 = r8 << r10
                long r8 = r8 & r6
                r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r8 = r8 & r10
                int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r8 == 0) goto L65
                int r8 = r5 - r3
                int r8 = ~r8
                int r8 = r8 >>> 31
                r9 = 8
                int r8 = 8 - r8
                r10 = r4
            L35:
                if (r10 >= r8) goto L63
                r11 = 255(0xff, double:1.26E-321)
                long r11 = r11 & r6
                r13 = 128(0x80, double:6.3E-322)
                int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r11 >= 0) goto L5f
                int r11 = r5 << 3
                int r11 = r11 + r10
                r11 = r2[r11]
                androidx.compose.runtime.GapComposer r11 = (androidx.compose.runtime.GapComposer) r11
                java.util.Iterator r12 = r0.iterator()
            L4b:
                boolean r13 = r12.hasNext()
                if (r13 == 0) goto L5f
                java.lang.Object r13 = r12.next()
                java.util.Set r13 = (java.util.Set) r13
                androidx.compose.runtime.tooling.CompositionData r14 = r11.getCompositionData()
                r13.remove(r14)
                goto L4b
            L5f:
                long r6 = r6 >> r9
                int r10 = r10 + 1
                goto L35
            L63:
                if (r8 != r9) goto L6a
            L65:
                if (r5 == r3) goto L6a
                int r5 = r5 + 1
                goto L1b
            L6a:
                androidx.collection.MutableScatterSet<androidx.compose.runtime.GapComposer> r0 = r15.composers
                r0.clear()
            L6f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.GapComposer.CompositionContextImpl.dispose():void");
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime(Composer composer) {
            Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.GapComposer");
            super.registerComposer$runtime((GapComposer) composer);
            this.composers.add(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime(Composer composer) {
            Set<Set<CompositionData>> set = this.inspectionTables;
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    Set set2 = (Set) it.next();
                    Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.GapComposer");
                    set2.remove(((GapComposer) composer).getCompositionData());
                }
            }
            if (composer instanceof GapComposer) {
                this.composers.remove(composer);
            }
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposition$runtime(ControlledComposition composition) {
            GapComposer.this.parentContext.registerComposition$runtime(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime(ControlledComposition composition) {
            GapComposer.this.parentContext.unregisterComposition$runtime(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportPausedScope$runtime(RecomposeScopeImpl scope) {
            GapComposer.this.parentContext.reportPausedScope$runtime(scope);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext getEffectCoroutineContext() {
            return GapComposer.this.parentContext.getEffectCoroutineContext();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void composeInitial$runtime(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) {
            GapComposer.this.parentContext.composeInitial$runtime(composition, content);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public ScatterSet<RecomposeScopeImpl> composeInitialPaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, Function2<? super Composer, ? super Integer, Unit> content) {
            return GapComposer.this.parentContext.composeInitialPaused$runtime(composition, shouldPause, content);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public ScatterSet<RecomposeScopeImpl> recomposePaused$runtime(ControlledComposition composition, ShouldPauseCallback shouldPause, ScatterSet<RecomposeScopeImpl> invalidScopes) {
            return GapComposer.this.parentContext.recomposePaused$runtime(composition, shouldPause, invalidScopes);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime(ControlledComposition composition) {
            GapComposer.this.parentContext.invalidate$runtime(GapComposer.this.getComposition());
            GapComposer.this.parentContext.invalidate$runtime(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidateScope$runtime(RecomposeScopeImpl scope) {
            GapComposer.this.parentContext.invalidateScope$runtime(scope);
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
            GapComposer.this.childrenComposing++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime() {
            GapComposer.this.childrenComposing--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime(MovableContentStateReference reference) {
            GapComposer.this.parentContext.insertMovableContent$runtime(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void deletedMovableContent$runtime(MovableContentStateReference reference) {
            GapComposer.this.parentContext.deletedMovableContent$runtime(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference reference) {
            return GapComposer.this.parentContext.movableContentStateResolve$runtime(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void movableContentStateReleased$runtime(MovableContentStateReference reference, MovableContentState data, Applier<?> applier) {
            GapComposer.this.parentContext.movableContentStateReleased$runtime(reference, data, applier);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportRemovedComposition$runtime(ControlledComposition composition) {
            GapComposer.this.parentContext.reportRemovedComposition$runtime(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public Composition getComposition$runtime() {
            return GapComposer.this.getComposition();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CancellationHandle scheduleFrameEndCallback(Function0<Unit> action) {
            return GapComposer.this.parentContext.scheduleFrameEndCallback(action);
        }
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

    @Override // androidx.compose.runtime.InternalComposer
    public int stacksSize$runtime() {
        return this.entersStack.tos + Stack.m5055getSizeimpl(this.invalidateStack) + this.providersInvalidStack.tos + Stack.m5055getSizeimpl(this.pendingStack) + this.parentStateStack.tos;
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
    public Object rememberedValue() {
        return nextSlotForCache();
    }

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(Object value) {
        updateCachedValue(value);
    }

    @Override // androidx.compose.runtime.Composer
    public void recordUsed(RecomposeScope scope) {
        RecomposeScopeImpl recomposeScopeImpl = scope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) scope : null;
        if (recomposeScopeImpl != null) {
            recomposeScopeImpl.setUsed(true);
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

    private final long compositeKeyOf(int group, int recomposeGroup, long recomposeKey) {
        long jRotateLeft;
        long jRotateLeft2 = 0;
        int i = 3;
        int i2 = 0;
        while (group >= 0) {
            if (group != recomposeGroup) {
                int iGroupCompositeKeyPart = groupCompositeKeyPart(this.reader, group);
                if (iGroupCompositeKeyPart == 126665345) {
                    jRotateLeft = Long.rotateLeft(iGroupCompositeKeyPart, i2);
                } else {
                    jRotateLeft2 = (jRotateLeft2 ^ Long.rotateLeft(iGroupCompositeKeyPart, i)) ^ Long.rotateLeft(this.reader.hasObjectKey(group) ? 0 : rGroupIndexOf(group), i2);
                    i = (i + 6) % 64;
                    i2 = (i2 + 6) % 64;
                    group = this.reader.parent(group);
                }
            } else {
                jRotateLeft = Long.rotateLeft(recomposeKey, i2);
            }
            return jRotateLeft ^ jRotateLeft2;
        }
        return jRotateLeft2;
    }
}
