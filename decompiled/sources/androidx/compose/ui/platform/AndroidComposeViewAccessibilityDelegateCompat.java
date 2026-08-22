package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.ArraySet;
import androidx.collection.IntIntMapKt;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.AndroidComposeUiFlags;
import androidx.compose.ui.R;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsNode_androidKt;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;

/* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000þ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u009d\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\n\u009d\u0002\u009e\u0002\u009f\u0002 \u0002¡\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010z\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020{H\u0016J\u0010\u0010|\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020{H\u0016J\u0010\u0010}\u001a\u00020.2\u0006\u0010~\u001a\u00020\u0016H\u0016J\u0010\u0010\u007f\u001a\u00020.2\u0006\u0010~\u001a\u00020\u0016H\u0016J.\u0010\u0080\u0001\u001a\u00020\u00162\u0007\u0010\u0081\u0001\u001a\u00020\u00162\u0007\u0010\u0082\u0001\u001a\u00020\f2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J<\u0010\u0080\u0001\u001a\u00020\u00162\f\u0010]\u001a\b\u0012\u0004\u0012\u00020_0^2\u0007\u0010\u0081\u0001\u001a\u00020\u00162\u0007\u0010\u0082\u0001\u001a\u00020\f2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\t\u0010\u0089\u0001\u001a\u00020\u0016H\u0002J\u0014\u0010\u008a\u0001\u001a\u0004\u0018\u00010F2\u0007\u0010\u008b\u0001\u001a\u00020\fH\u0002J\u000b\u0010\u008c\u0001\u001a\u0004\u0018\u00010FH\u0002J\u0013\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020_H\u0002J2\u0010\u0090\u0001\u001a\u00030\u008e\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0092\u00012\b\u0010\u0094\u0001\u001a\u00030\u0092\u00012\b\u0010\u0095\u0001\u001a\u00030\u0092\u0001H\u0002J%\u0010\u0096\u0001\u001a\u00020.2\u0007\u0010\u008b\u0001\u001a\u00020\f2\u0007\u0010\u0097\u0001\u001a\u00020F2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0002J\u001c\u0010\u009a\u0001\u001a\u00020.2\b\u0010\u008f\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u0097\u0001\u001a\u00020FH\u0002J\u0017\u0010\u009b\u0001\u001a\u00020.*\u00020F2\b\u0010\u008f\u0001\u001a\u00030\u0099\u0001H\u0002J\u0011\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001*\u00030\u009e\u0001H\u0002J\u001c\u0010\u009f\u0001\u001a\u00020.2\b\u0010\u008f\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u0097\u0001\u001a\u00020FH\u0002J\u0012\u0010 \u0001\u001a\u00020\u00162\u0007\u0010\u008b\u0001\u001a\u00020\fH\u0002J\u0012\u0010¡\u0001\u001a\u00020\u00162\u0007\u0010\u008b\u0001\u001a\u00020\fH\u0002JA\u0010¢\u0001\u001a\u00020\u00162\u0007\u0010\u008b\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\f2\u000b\b\u0002\u0010¤\u0001\u001a\u0004\u0018\u00010\f2\u0011\b\u0002\u0010¥\u0001\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010+H\u0002¢\u0006\u0003\u0010¦\u0001J\u0012\u0010§\u0001\u001a\u00020\u00162\u0007\u0010¨\u0001\u001a\u00020\u0015H\u0002J\u001b\u0010©\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\f2\u0007\u0010£\u0001\u001a\u00020\fH\u0003JD\u0010ª\u0001\u001a\u00020\u00152\u0007\u0010\u008b\u0001\u001a\u00020\f2\t\u0010«\u0001\u001a\u0004\u0018\u00010\f2\t\u0010¬\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\f2\t\u0010®\u0001\u001a\u0004\u0018\u00010OH\u0002¢\u0006\u0003\u0010¯\u0001J\u0012\u0010°\u0001\u001a\u00020\u00162\u0007\u0010\u008b\u0001\u001a\u00020\fH\u0002J'\u0010±\u0001\u001a\u00020\u00162\u0007\u0010\u008b\u0001\u001a\u00020\f2\u0007\u0010²\u0001\u001a\u00020\f2\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001H\u0002J\u000e\u0010µ\u0001\u001a\u00020\u0016*\u00030\u0099\u0001H\u0003J\u000e\u0010¶\u0001\u001a\u00020\u0016*\u00030\u0099\u0001H\u0002J,\u0010·\u0001\u001a\u00030\u0084\u0001*\u00030\u0099\u00012\b\u0010¸\u0001\u001a\u00030\u0099\u00012\b\u0010¹\u0001\u001a\u00030\u0084\u0001H\u0002¢\u0006\u0006\bº\u0001\u0010»\u0001J,\u0010¼\u0001\u001a\u00030\u0084\u0001*\u00030\u0099\u00012\b\u0010¸\u0001\u001a\u00030\u0099\u00012\b\u0010½\u0001\u001a\u00030\u0084\u0001H\u0002¢\u0006\u0006\b¾\u0001\u0010»\u0001J0\u0010¿\u0001\u001a\u00020.2\u0007\u0010\u008b\u0001\u001a\u00020\f2\u0007\u0010\u0097\u0001\u001a\u00020F2\u0007\u0010À\u0001\u001a\u00020n2\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001H\u0002J(\u0010Ã\u0001\u001a\u00030Ä\u00012\b\u0010\u008f\u0001\u001a\u00030\u0099\u00012\b\u0010Å\u0001\u001a\u00030\u008e\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u0001H\u0002J\u0019\u0010È\u0001\u001a\u00030Ä\u0001*\u00030\u008e\u00012\b\u0010Å\u0001\u001a\u00030\u008e\u0001H\u0002J\"\u0010É\u0001\u001a\u0005\u0018\u00010Ê\u00012\n\u0010Ë\u0001\u001a\u0005\u0018\u00010\u0099\u00012\b\u0010Ì\u0001\u001a\u00030Ä\u0001H\u0002J,\u0010Í\u0001\u001a\u00030Î\u0001*\u00030Ç\u00012\b\u0010Ï\u0001\u001a\u00030Ð\u00012\b\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0002¢\u0006\u0006\bÓ\u0001\u0010Ô\u0001J%\u0010Õ\u0001\u001a\u0005\u0018\u00010\u008e\u0001*\u00030Î\u00012\b\u0010Ö\u0001\u001a\u00030\u0092\u00012\b\u0010×\u0001\u001a\u00030\u0092\u0001H\u0002J\u0011\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u0001*\u00030Î\u0001H\u0002J%\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u0001*\u00030Î\u00012\b\u0010Ö\u0001\u001a\u00030\u0092\u00012\b\u0010×\u0001\u001a\u00030\u0092\u0001H\u0002J'\u0010Õ\u0001\u001a\u00030\u008e\u0001*\u00030Ä\u00012\n\b\u0002\u0010Ö\u0001\u001a\u00030\u0092\u00012\n\b\u0002\u0010×\u0001\u001a\u00030\u0092\u0001H\u0002J\u0019\u0010Ü\u0001\u001a\u00020\u00162\b\u0010¨\u0001\u001a\u00030Ý\u0001H\u0000¢\u0006\u0003\bÞ\u0001J#\u0010ß\u0001\u001a\u00020\f2\b\u0010à\u0001\u001a\u00030\u0092\u00012\b\u0010á\u0001\u001a\u00030\u0092\u0001H\u0001¢\u0006\u0003\bâ\u0001J\u0012\u0010ã\u0001\u001a\u00020.2\u0007\u0010\u008b\u0001\u001a\u00020\fH\u0002J\u0013\u0010ä\u0001\u001a\u00030å\u00012\u0007\u0010æ\u0001\u001a\u00020{H\u0016J4\u0010ç\u0001\u001a\u0005\u0018\u0001Hè\u0001\"\t\b\u0000\u0010è\u0001*\u00020O2\n\u0010®\u0001\u001a\u0005\u0018\u0001Hè\u00012\t\b\u0001\u0010Ï\u0001\u001a\u00020\fH\u0002¢\u0006\u0003\u0010é\u0001J\u000f\u0010ì\u0001\u001a\u00020.H\u0000¢\u0006\u0003\bí\u0001J\u0013\u0010î\u0001\u001a\u00020.H\u0080@¢\u0006\u0006\bï\u0001\u0010ð\u0001J\u0018\u0010ñ\u0001\u001a\u00020.2\u0007\u0010ò\u0001\u001a\u00020WH\u0000¢\u0006\u0003\bó\u0001J\u0012\u0010ô\u0001\u001a\u00020.2\u0007\u0010ò\u0001\u001a\u00020WH\u0002J\u0012\u0010õ\u0001\u001a\u00020.2\u0007\u0010ò\u0001\u001a\u00020WH\u0002J\u001b\u0010ö\u0001\u001a\u00020.2\u0007\u0010ò\u0001\u001a\u00020W2\u0007\u0010÷\u0001\u001a\u00020cH\u0002J\t\u0010ø\u0001\u001a\u00020.H\u0002J\t\u0010ù\u0001\u001a\u00020.H\u0002J\u0018\u0010ú\u0001\u001a\u00020.2\r\u0010û\u0001\u001a\b\u0012\u0004\u0012\u00020_0^H\u0002J\"\u0010\u0080\u0002\u001a\u00020\u00162\u0007\u0010\u0081\u0002\u001a\u00020\f2\u000e\u0010\u0082\u0002\u001a\t\u0012\u0005\u0012\u00030þ\u00010+H\u0002J\u0013\u0010\u0083\u0002\u001a\u00020.2\b\u0010\u0084\u0002\u001a\u00030þ\u0001H\u0002J&\u0010\u0085\u0002\u001a\u00020.2\u0007\u0010\u0086\u0002\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\f2\t\u0010\u0087\u0002\u001a\u0004\u0018\u00010nH\u0002J\u001c\u0010\u0088\u0002\u001a\u00020.2\b\u0010\u0089\u0002\u001a\u00030\u0099\u00012\u0007\u0010\u008a\u0002\u001a\u00020vH\u0002J\u0012\u0010\u008b\u0002\u001a\u00020\f2\u0007\u0010\u0081\u0002\u001a\u00020\fH\u0002J.\u0010\u008c\u0002\u001a\u00020\u00162\b\u0010\u008f\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u008d\u0002\u001a\u00020\f2\u0007\u0010\u008e\u0002\u001a\u00020\u00162\u0007\u0010\u008f\u0002\u001a\u00020\u0016H\u0002J\u0012\u0010\u0090\u0002\u001a\u00020.2\u0007\u0010\u0086\u0002\u001a\u00020\fH\u0002J.\u0010\u0091\u0002\u001a\u00020\u00162\b\u0010\u008f\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u0092\u0002\u001a\u00020\f2\u0007\u0010\u0093\u0002\u001a\u00020\f2\u0007\u0010\u0094\u0002\u001a\u00020\u0016H\u0002J\u0013\u0010\u0095\u0002\u001a\u00020\f2\b\u0010\u008f\u0001\u001a\u00030\u0099\u0001H\u0002J\u0013\u0010\u0096\u0002\u001a\u00020\f2\b\u0010\u008f\u0001\u001a\u00030\u0099\u0001H\u0002J\u0013\u0010\u0097\u0002\u001a\u00020\u00162\b\u0010\u008f\u0001\u001a\u00030\u0099\u0001H\u0002J!\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0099\u00022\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0099\u00012\u0007\u0010\u008d\u0002\u001a\u00020\fH\u0002J\u0017\u0010\u009a\u0002\u001a\u0004\u0018\u00010n2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0002J\u0011\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u009e\u0001*\u00030\u009c\u0002H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0016@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u0010!R\u0014\u00104\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u0010!R\u001e\u00105\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u0004\u0018\u00010<8BX\u0082\u0004¢\u0006\f\u0012\u0004\b>\u0010\u000e\u001a\u0004\b?\u0010@R\u0012\u0010A\u001a\u00060BR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020K0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0N0NX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0Q0NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010S\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010TR\u0014\u0010U\u001a\b\u0012\u0004\u0012\u00020W0VX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00020.0YX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020_0^8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u000e\u0010b\u001a\u00020cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010d\u001a\u00020eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001a\u0010j\u001a\u00020eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010g\"\u0004\bl\u0010iR\u0014\u0010m\u001a\u00020nX\u0080D¢\u0006\b\n\u0000\u001a\u0004\bo\u0010pR\u0014\u0010q\u001a\u00020nX\u0080D¢\u0006\b\n\u0000\u001a\u0004\br\u0010pR\u000e\u0010s\u001a\u00020tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010u\u001a\b\u0012\u0004\u0012\u00020v0JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020vX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u008d\u0001\u001a\u00030\u008e\u0001*\u00020F8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÁ\u0001\u0010Â\u0001R\u0010\u0010ê\u0001\u001a\u00030ë\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010ü\u0001\u001a\n\u0012\u0005\u0012\u00030þ\u00010ý\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010ÿ\u0001\u001a\u000f\u0012\u0005\u0012\u00030þ\u0001\u0012\u0004\u0012\u00020.0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¢\u0002"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", ViewHierarchyConstants.VIEW_KEY, "Landroidx/compose/ui/platform/AndroidComposeView;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "hoveredVirtualViewId", "", "getHoveredVirtualViewId$ui$annotations", "()V", "getHoveredVirtualViewId$ui", "()I", "setHoveredVirtualViewId$ui", "(I)V", "onSendAccessibilityEvent", "Lkotlin/Function1;", "Landroid/view/accessibility/AccessibilityEvent;", "", "getOnSendAccessibilityEvent$ui$annotations", "getOnSendAccessibilityEvent$ui", "()Lkotlin/jvm/functions/Function1;", "setOnSendAccessibilityEvent$ui", "(Lkotlin/jvm/functions/Function1;)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "value", "accessibilityForceEnabledForTesting", "getAccessibilityForceEnabledForTesting$ui", "()Z", "setAccessibilityForceEnabledForTesting$ui", "(Z)V", "SendRecurringAccessibilityEventsIntervalMillis", "", "getSendRecurringAccessibilityEventsIntervalMillis$ui", "()J", "setSendRecurringAccessibilityEventsIntervalMillis$ui", "(J)V", "_enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "resetEnabledAccessibilityServiceList", "", "enabledServices", "getEnabledServices", "()Ljava/util/List;", "isEnabled", "isEnabled$ui", "isTouchExplorationEnabled", "requestFromAccessibilityToolForTesting", "getRequestFromAccessibilityToolForTesting$ui", "()Ljava/lang/Boolean;", "setRequestFromAccessibilityToolForTesting$ui", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "legacyMainHandler", "Landroid/os/Handler;", "handler", "getHandler$annotations", "getHandler", "()Landroid/os/Handler;", "nodeProvider", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "accessibilityFocusedVirtualViewId", "focusedVirtualViewId", "currentlyAccessibilityFocusedANI", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "currentlyFocusedANI", "sendingFocusAffectingEvent", "pendingHorizontalScrollEvents", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "pendingVerticalScrollEvents", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "labelToActionId", "Landroidx/collection/MutableObjectIntMap;", "accessibilityCursorPosition", "previousTraversedNode", "Ljava/lang/Integer;", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "currentSemanticsNodesInvalidated", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/semantics/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Landroidx/collection/IntObjectMap;", "paneDisplayed", "Landroidx/collection/MutableIntSet;", "idToBeforeMap", "Landroidx/collection/MutableIntIntMap;", "getIdToBeforeMap$ui", "()Landroidx/collection/MutableIntIntMap;", "setIdToBeforeMap$ui", "(Landroidx/collection/MutableIntIntMap;)V", "idToAfterMap", "getIdToAfterMap$ui", "setIdToAfterMap$ui", "ExtraDataTestTraversalBeforeVal", "", "getExtraDataTestTraversalBeforeVal$ui", "()Ljava/lang/String;", "ExtraDataTestTraversalAfterVal", "getExtraDataTestTraversalAfterVal$ui", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "checkingForSemanticsChanges", "drawingOrder", "onViewAttachedToWindow", "Landroid/view/View;", "onViewDetachedFromWindow", "onAccessibilityStateChanged", StreamManagement.Enabled.ELEMENT, "onTouchExplorationStateChanged", "canScroll", "vertical", "direction", Const.POSITION, "Landroidx/compose/ui/geometry/Offset;", "canScroll-0AR0LA0$ui", "(ZIJ)Z", "canScroll-moWRBKg", "(Landroidx/collection/IntObjectMap;ZIJ)Z", "isRequestFromAccessibilityTool", "createNodeInfo", "virtualViewId", "emptyNodeInfoOrNull", "boundsInScreen", "Landroid/graphics/Rect;", NodeElement.ELEMENT, "toBoundsInScreen", "left", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "populateAccessibilityNodeInfoProperties", "info", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "setContentInvalid", "setInvisibleIfEmptyBounds", "toSpannableString", "Landroid/text/SpannableString;", "Landroidx/compose/ui/text/AnnotatedString;", "setText", "isAccessibilityFocused", "requestAccessibilityFocus", "sendEventForVirtualView", "eventType", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendEvent", "event", "createEvent", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "clearAccessibilityFocus", "performActionHelper", "action", "arguments", "Landroid/os/Bundle;", "legacyScrollOntoScreen", "scrollOntoScreen", "adjustForReversedScrollingAndRtl", "scrollableAncestor", "offset", "adjustForReversedScrollingAndRtl-RE3cj74", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/semantics/SemanticsNode;J)J", "scrollDxDyForNodeVisible", "offsetAdjustment", "scrollDxDyForNodeVisible-RE3cj74", "addExtraDataToAccessibilityNodeInfoHelper", "extraDataKey", "getBoundsInScreen", "(Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)Landroid/graphics/Rect;", "getShapeBounds", "Landroidx/compose/ui/geometry/Rect;", "nodeBoundsInScreen", "shape", "Landroidx/compose/ui/graphics/Shape;", "toBoundsRelativeToNodeBounds", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "createOutline-12SF9DM", "(Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "toAndroidRect", "leftOffset", "topOffset", "toCornerArray", "", "toRegion", "Landroid/graphics/Region;", "dispatchHoverEvent", "Landroid/view/MotionEvent;", "dispatchHoverEvent$ui", "hitTestSemanticsAt", "x", "y", "hitTestSemanticsAt$ui", "updateHoveredVirtualView", "getAccessibilityNodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", JingleS5BTransportCandidate.ATTR_HOST, "trimToSize", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "onSemanticsChange", "onSemanticsChange$ui", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLayoutChange", "layoutNode", "onLayoutChange$ui", "notifySubtreeAccessibilityStateChangedIfNeeded", "sendTypeViewScrolledAccessibilityEvent", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "checkForSemanticsChanges", "updateSemanticsNodesCopyAndPanes", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "scrollObservationScopes", "", "Landroidx/compose/ui/platform/ScrollObservationScope;", "scheduleScrollEventIfNeededLambda", "registerScrollingId", "id", "oldScrollObservationScopes", "scheduleScrollEventIfNeeded", "scrollObservationScope", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "semanticsNodeIdToAccessibilityVirtualNodeId", "traverseAtGranularity", "granularity", "forward", "extendSelection", "sendPendingTextTraversedAtGranularityEvent", "setAccessibilitySelection", "start", "end", "traversalMode", "getAccessibilitySelectionStart", "getAccessibilitySelectionEnd", "isAccessibilitySelectionExtendable", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "getIterableTextForAccessibility", "getTextForTextField", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Companion", "PendingTextTraversedEvent", "ComposeAccessibilityNodeProvider", "Api24Impl", "Api29Impl", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat implements View.OnAttachStateChangeListener, AccessibilityManager.AccessibilityStateChangeListener, AccessibilityManager.TouchExplorationStateChangeListener {
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final int CONTENT_CHANGE_TYPE_CHECKED = 8192;
    public static final String ClassName = "android.view.View";
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataShapeRectCornersKey = "androidx.compose.ui.semantics.shapeCorners";
    public static final String ExtraDataShapeRectKey = "androidx.compose.ui.semantics.shapeRect";
    public static final String ExtraDataShapeRegionKey = "androidx.compose.ui.semantics.shapeRegion";
    public static final int ExtraDataShapeTypeGeneric = 2;
    public static final String ExtraDataShapeTypeKey = "androidx.compose.ui.semantics.shapeType";
    public static final int ExtraDataShapeTypeRectangle = 0;
    public static final int ExtraDataShapeTypeRounded = 1;
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private final String ExtraDataTestTraversalAfterVal;
    private final String ExtraDataTestTraversalBeforeVal;
    private long SendRecurringAccessibilityEventsIntervalMillis;
    private List<? extends AccessibilityServiceInfo> _enabledServices;
    private int accessibilityCursorPosition;
    private int accessibilityFocusedVirtualViewId;
    private boolean accessibilityForceEnabledForTesting;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private AccessibilityNodeInfoCompat currentlyAccessibilityFocusedANI;
    private AccessibilityNodeInfoCompat currentlyFocusedANI;
    private final MutableIntIntMap drawingOrder;
    private int focusedVirtualViewId;
    private MutableIntIntMap idToAfterMap;
    private MutableIntIntMap idToBeforeMap;
    private SparseArrayCompat<MutableObjectIntMap<CharSequence>> labelToActionId;
    private final Handler legacyMainHandler;
    private ComposeAccessibilityNodeProvider nodeProvider;
    private MutableIntSet paneDisplayed;
    private final MutableIntObjectMap<ScrollAxisRange> pendingHorizontalScrollEvents;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private final MutableIntObjectMap<ScrollAxisRange> pendingVerticalScrollEvents;
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private Boolean requestFromAccessibilityToolForTesting;
    private final Function1<ScrollObservationScope, Unit> scheduleScrollEventIfNeededLambda;
    private final List<ScrollObservationScope> scrollObservationScopes;
    private final Runnable semanticsChangeChecker;
    private boolean sendingFocusAffectingEvent;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;
    public static final int $stable = 8;
    private static final IntList AccessibilityActionsResourceIds = IntListKt.intListOf(R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31);
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private Function1<? super AccessibilityEvent, Boolean> onSendAccessibilityEvent = new Function1<AccessibilityEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AccessibilityEvent accessibilityEvent) {
            return Boolean.valueOf(this.this$0.getView().getParent().requestSendAccessibilityEvent(this.this$0.getView(), accessibilityEvent));
        }
    };

    private static /* synthetic */ void getHandler$annotations() {
    }

    public static /* synthetic */ void getHoveredVirtualViewId$ui$annotations() {
    }

    public static /* synthetic */ void getOnSendAccessibilityEvent$ui$annotations() {
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.view = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        this.SendRecurringAccessibilityEventsIntervalMillis = 100L;
        this.legacyMainHandler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new ComposeAccessibilityNodeProvider();
        this.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.pendingHorizontalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.pendingVerticalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.actionIdToLabel = new SparseArrayCompat<>(0, 1, null);
        this.labelToActionId = new SparseArrayCompat<>(0, 1, null);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>(0, 1, null);
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.paneDisplayed = new MutableIntSet(0, 1, null);
        this.idToBeforeMap = new MutableIntIntMap(0, 1, null);
        this.idToAfterMap = new MutableIntIntMap(0, 1, null);
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        this.drawingOrder = IntIntMapKt.mutableIntIntMapOf();
        androidComposeView.addOnAttachStateChangeListener(this);
        this.semanticsChangeChecker = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker$lambda$0(this.f$0);
            }
        };
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new Function1<ScrollObservationScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollObservationScope scrollObservationScope) {
                invoke2(scrollObservationScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollObservationScope scrollObservationScope) {
                this.this$0.scheduleScrollEventIfNeeded(scrollObservationScope);
            }
        };
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    /* JADX INFO: renamed from: getHoveredVirtualViewId$ui, reason: from getter */
    public final int getHoveredVirtualViewId() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final Function1<AccessibilityEvent, Boolean> getOnSendAccessibilityEvent$ui() {
        return this.onSendAccessibilityEvent;
    }

    public final void setOnSendAccessibilityEvent$ui(Function1<? super AccessibilityEvent, Boolean> function1) {
        this.onSendAccessibilityEvent = function1;
    }

    /* JADX INFO: renamed from: getAccessibilityForceEnabledForTesting$ui, reason: from getter */
    public final boolean getAccessibilityForceEnabledForTesting() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
        this.currentSemanticsNodesInvalidated = true;
    }

    /* JADX INFO: renamed from: getSendRecurringAccessibilityEventsIntervalMillis$ui, reason: from getter */
    public final long getSendRecurringAccessibilityEventsIntervalMillis() {
        return this.SendRecurringAccessibilityEventsIntervalMillis;
    }

    public final void setSendRecurringAccessibilityEventsIntervalMillis$ui(long j) {
        this.SendRecurringAccessibilityEventsIntervalMillis = j;
    }

    private final void resetEnabledAccessibilityServiceList() {
        this._enabledServices = null;
    }

    private final List<AccessibilityServiceInfo> getEnabledServices() {
        List list = this._enabledServices;
        if (list != null) {
            return list;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this._enabledServices = enabledAccessibilityServiceList;
        return enabledAccessibilityServiceList;
    }

    public final boolean isEnabled$ui() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        return this.accessibilityManager.isEnabled() && !getEnabledServices().isEmpty();
    }

    private final boolean isTouchExplorationEnabled() {
        if (this.accessibilityForceEnabledForTesting) {
            return true;
        }
        return this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled();
    }

    /* JADX INFO: renamed from: getRequestFromAccessibilityToolForTesting$ui, reason: from getter */
    public final Boolean getRequestFromAccessibilityToolForTesting() {
        return this.requestFromAccessibilityToolForTesting;
    }

    public final void setRequestFromAccessibilityToolForTesting$ui(Boolean bool) {
        this.requestFromAccessibilityToolForTesting = bool;
    }

    private final Handler getHandler() {
        if (AndroidComposeUiFlags.isViewBasedSemanticsHandlerEnabled) {
            return this.view.getHandler();
        }
        return this.legacyMainHandler;
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", NodeElement.ELEMENT, "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "<init>", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getAction", "()I", "getGranularity", "getFromIndex", "getToIndex", "getTraverseTime", "()J", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int i, int i2, int i3, int i4, long j) {
            this.node = semanticsNode;
            this.action = i;
            this.granularity = i2;
            this.fromIndex = i3;
            this.toIndex = i4;
            this.traverseTime = j;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsOwnerKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner(), -1, new Function1<SemanticsNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$currentSemanticsNodes$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SemanticsNode semanticsNode) {
                    return Boolean.valueOf(SemanticsNode_androidKt.isAccessibilityIgnoredLink(semanticsNode));
                }
            });
            if (isEnabled$ui()) {
                AndroidComposeViewAccessibilityDelegateCompat_androidKt.setTraversalValues(this.currentSemanticsNodes, this.idToBeforeMap, this.idToAfterMap, this.view.getContext().getResources());
            }
        }
        return this.currentSemanticsNodes;
    }

    /* JADX INFO: renamed from: getIdToBeforeMap$ui, reason: from getter */
    public final MutableIntIntMap getIdToBeforeMap() {
        return this.idToBeforeMap;
    }

    public final void setIdToBeforeMap$ui(MutableIntIntMap mutableIntIntMap) {
        this.idToBeforeMap = mutableIntIntMap;
    }

    /* JADX INFO: renamed from: getIdToAfterMap$ui, reason: from getter */
    public final MutableIntIntMap getIdToAfterMap() {
        return this.idToAfterMap;
    }

    public final void setIdToAfterMap$ui(MutableIntIntMap mutableIntIntMap) {
        this.idToAfterMap = mutableIntIntMap;
    }

    /* JADX INFO: renamed from: getExtraDataTestTraversalBeforeVal$ui, reason: from getter */
    public final String getExtraDataTestTraversalBeforeVal() {
        return this.ExtraDataTestTraversalBeforeVal;
    }

    /* JADX INFO: renamed from: getExtraDataTestTraversalAfterVal$ui, reason: from getter */
    public final String getExtraDataTestTraversalAfterVal() {
        return this.ExtraDataTestTraversalAfterVal;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        if (this.accessibilityManager.isEnabled()) {
            resetEnabledAccessibilityServiceList();
        }
        this.accessibilityManager.addAccessibilityStateChangeListener(this);
        this.accessibilityManager.addTouchExplorationStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Handler handler = getHandler();
        Intrinsics.checkNotNull(handler);
        handler.removeCallbacks(this.semanticsChangeChecker);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this);
        this.accessibilityManager.removeTouchExplorationStateChangeListener(this);
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean enabled) {
        resetEnabledAccessibilityServiceList();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public void onTouchExplorationStateChanged(boolean enabled) {
        resetEnabledAccessibilityServiceList();
    }

    /* JADX INFO: renamed from: canScroll-0AR0LA0$ui, reason: not valid java name */
    public final boolean m7896canScroll0AR0LA0$ui(boolean vertical, int direction, long position) {
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return m7893canScrollmoWRBKg(getCurrentSemanticsNodes(), vertical, direction, position);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e5  */
    /* JADX INFO: renamed from: canScroll-moWRBKg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean m7893canScrollmoWRBKg(androidx.collection.IntObjectMap<androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds> r21, boolean r22, int r23, long r24) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.m7893canScrollmoWRBKg(androidx.collection.IntObjectMap, boolean, int, long):boolean");
    }

    private final boolean isRequestFromAccessibilityTool() {
        Boolean bool = this.requestFromAccessibilityToolForTesting;
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) bool, (Object) false)) {
            return false;
        }
        return AccessibilityManagerCompat.isRequestFromAccessibilityTool(this.accessibilityManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfoCompat createNodeInfo(int virtualViewId) {
        if (this.view.getComposeViewContext().getLifecycleOwner().getLifecycle().getState() == Lifecycle.State.DESTROYED) {
            return emptyNodeInfoOrNull();
        }
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null) {
            return emptyNodeInfoOrNull();
        }
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
        boolean zAreEqual = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getIsSensitiveData()), (Object) true);
        if (zAreEqual && !isRequestFromAccessibilityTool()) {
            return null;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain();
        accessibilityNodeInfoCompatObtain.setAccessibilityDataSensitive(zAreEqual);
        if (virtualViewId == -1) {
            ViewParent parentForAccessibility = this.view.getParentForAccessibility();
            accessibilityNodeInfoCompatObtain.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else {
            SemanticsNode parent = semanticsNode.getParent();
            Integer numValueOf = parent != null ? Integer.valueOf(parent.getId()) : null;
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                accessibilityNodeInfoCompatObtain.setParent(this.view, iIntValue != this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId() ? iIntValue : -1);
            } else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + virtualViewId + " has null parent");
                throw new KotlinNothingValueException();
            }
        }
        accessibilityNodeInfoCompatObtain.setSource(this.view, virtualViewId);
        accessibilityNodeInfoCompatObtain.setBoundsInScreen(boundsInScreen(semanticsNodeWithAdjustedBounds));
        populateAccessibilityNodeInfoProperties(virtualViewId, accessibilityNodeInfoCompatObtain, semanticsNode);
        return accessibilityNodeInfoCompatObtain;
    }

    private final AccessibilityNodeInfoCompat emptyNodeInfoOrNull() {
        if (this.accessibilityManager.isEnabled()) {
            return null;
        }
        return AccessibilityNodeInfoCompat.obtain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect boundsInScreen(SemanticsNodeWithAdjustedBounds node) {
        IntRect adjustedBounds = node.getAdjustedBounds();
        return toBoundsInScreen(adjustedBounds.getLeft(), adjustedBounds.getTop(), adjustedBounds.getRight(), adjustedBounds.getBottom());
    }

    private final Rect toBoundsInScreen(float left, float top, float right, float bottom) {
        long jMo7394localToScreenMKHz9U = this.view.mo7394localToScreenMKHz9U(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(top)) & 4294967295L) | (Float.floatToRawIntBits(left) << 32)));
        long jMo7394localToScreenMKHz9U2 = this.view.mo7394localToScreenMKHz9U(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(bottom)) & 4294967295L) | (Float.floatToRawIntBits(right) << 32)));
        int i = (int) (jMo7394localToScreenMKHz9U >> 32);
        int i2 = (int) (jMo7394localToScreenMKHz9U2 >> 32);
        int i3 = (int) (jMo7394localToScreenMKHz9U & 4294967295L);
        int i4 = (int) (jMo7394localToScreenMKHz9U2 & 4294967295L);
        return new Rect((int) Math.floor(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.floor(Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2))), (int) Math.ceil(Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4))));
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x06a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void populateAccessibilityNodeInfoProperties(int r23, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r24, androidx.compose.ui.semantics.SemanticsNode r25) {
        /*
            Method dump skipped, instruction units count: 2725
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties(int, androidx.core.view.accessibility.AccessibilityNodeInfoCompat, androidx.compose.ui.semantics.SemanticsNode):void");
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        if (scrollAxisRange.getValue().invoke().floatValue() >= scrollAxisRange.getMaxValue().invoke().floatValue() || scrollAxisRange.getReverseScrolling()) {
            return scrollAxisRange.getValue().invoke().floatValue() > 0.0f && scrollAxisRange.getReverseScrolling();
        }
        return true;
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        if (scrollAxisRange.getValue().invoke().floatValue() <= 0.0f || scrollAxisRange.getReverseScrolling()) {
            return scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && scrollAxisRange.getReverseScrolling();
        }
        return true;
    }

    private final void setContentInvalid(SemanticsNode node, AccessibilityNodeInfoCompat info2) {
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getError())) {
            info2.setContentInvalid(true);
            info2.setError((CharSequence) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final void setInvisibleIfEmptyBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
        if (semanticsNode.getTouchBoundsInRoot().isEmpty()) {
            accessibilityNodeInfoCompat.setVisibleToUser(false);
        }
    }

    private final SpannableString toSpannableString(AnnotatedString annotatedString) {
        return (SpannableString) trimToSize(AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), this.view.getFontFamilyResolver(), this.urlSpanCache), 100000);
    }

    private final void setText(SemanticsNode node, AccessibilityNodeInfoCompat info2) {
        AnnotatedString infoText = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getInfoText(node);
        info2.setText(infoText != null ? toSpannableString(infoText) : null);
    }

    private final boolean isAccessibilityFocused(int virtualViewId) {
        return this.accessibilityFocusedVirtualViewId == virtualViewId;
    }

    private final boolean requestAccessibilityFocus(int virtualViewId) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        int i = this.accessibilityFocusedVirtualViewId;
        if (i != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, i, 65536, null, null, 12, null);
        }
        this.accessibilityFocusedVirtualViewId = virtualViewId;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 32768, null, null, 12, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int virtualViewId, int eventType, Integer contentChangeType, List<String> contentDescription) {
        if (virtualViewId == Integer.MIN_VALUE || !isEnabled$ui()) {
            return false;
        }
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(virtualViewId, eventType);
        if (contentChangeType != null) {
            accessibilityEventCreateEvent.setContentChangeTypes(contentChangeType.intValue());
        }
        if (contentDescription != null) {
            accessibilityEventCreateEvent.setContentDescription(ListUtilsKt.fastJoinToString$default(contentDescription, Constants.SEPARATOR_COMMA, null, null, 0, null, null, 62, null));
        }
        return sendEvent(accessibilityEventCreateEvent);
    }

    private final boolean sendEvent(AccessibilityEvent event) {
        if (!isEnabled$ui()) {
            return false;
        }
        if (event.getEventType() == 2048 || event.getEventType() == 32768) {
            this.sendingFocusAffectingEvent = true;
        }
        try {
            return this.onSendAccessibilityEvent.invoke(event).booleanValue();
        } finally {
            this.sendingFocusAffectingEvent = false;
        }
    }

    private final AccessibilityEvent createEvent(int virtualViewId, int eventType) {
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(eventType);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setClassName(ClassName);
        accessibilityEventObtain.setPackageName(this.view.getContext().getPackageName());
        accessibilityEventObtain.setSource(this.view, virtualViewId);
        if (isEnabled$ui() && (semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId)) != null) {
            accessibilityEventObtain.setPassword(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword()));
            AccessibilityEventCompat.setAccessibilityDataSensitive(accessibilityEventObtain, Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNodeWithAdjustedBounds.getSemanticsNode().getUnmergedConfig(), SemanticsProperties.INSTANCE.getIsSensitiveData()), (Object) true));
        }
        return accessibilityEventObtain;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int virtualViewId, Integer fromIndex, Integer toIndex, Integer itemCount, CharSequence text) {
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(virtualViewId, 8192);
        if (fromIndex != null) {
            accessibilityEventCreateEvent.setFromIndex(fromIndex.intValue());
        }
        if (toIndex != null) {
            accessibilityEventCreateEvent.setToIndex(toIndex.intValue());
        }
        if (itemCount != null) {
            accessibilityEventCreateEvent.setItemCount(itemCount.intValue());
        }
        if (text != null) {
            accessibilityEventCreateEvent.getText().add(text);
        }
        return accessibilityEventCreateEvent;
    }

    private final boolean clearAccessibilityFocus(int virtualViewId) {
        if (!isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        this.accessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.currentlyAccessibilityFocusedANI = null;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 65536, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean performActionHelper(int virtualViewId, int action, Bundle arguments) {
        SemanticsNode semanticsNode;
        Function0 function0;
        Function0 function02;
        Function0 function03;
        Function0 function04;
        float f2;
        int steps;
        float f3;
        float fIntBitsToFloat;
        AccessibilityAction accessibilityAction;
        Function0 function05;
        float fIntBitsToFloat2;
        AccessibilityAction accessibilityAction2;
        Function0 function06;
        Function0 function07;
        Function0 function08;
        Function0 function09;
        Function0 function010;
        Function0 function011;
        Function1 function1;
        AccessibilityAction accessibilityAction3;
        Function1 function12;
        Function0 function012;
        CharSequence charSequence;
        List list;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return false;
        }
        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getIsSensitiveData()), (Object) true) && !isRequestFromAccessibilityTool()) {
            return false;
        }
        if (action == 64) {
            return requestAccessibilityFocus(virtualViewId);
        }
        if (action == 128) {
            return clearAccessibilityFocus(virtualViewId);
        }
        if (action == 256 || action == 512) {
            if (arguments != null) {
                return traverseAtGranularity(semanticsNode, arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT), action == 256, arguments.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN));
            }
            return false;
        }
        if (action == 16384) {
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCopyText());
            if (accessibilityAction4 == null || (function0 = (Function0) accessibilityAction4.getAction()) == null) {
                return false;
            }
            return ((Boolean) function0.invoke()).booleanValue();
        }
        if (action != 131072) {
            if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                return false;
            }
            if (action == 1) {
                if (this.view.isInTouchMode()) {
                    this.view.requestFocusFromTouch();
                }
                AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getRequestFocus());
                if (accessibilityAction5 == null || (function02 = (Function0) accessibilityAction5.getAction()) == null) {
                    return false;
                }
                return ((Boolean) function02.invoke()).booleanValue();
            }
            if (action != 2) {
                Boolean bool = null;
                switch (action) {
                    case 16:
                        AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnClick());
                        if (accessibilityAction6 != null && (function03 = (Function0) accessibilityAction6.getAction()) != null) {
                            bool = (Boolean) function03.invoke();
                        }
                        sendEventForVirtualView$default(this, virtualViewId, 1, null, null, 12, null);
                        if (bool != null) {
                            return bool.booleanValue();
                        }
                        return false;
                    case 32:
                        AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnLongClick());
                        if (accessibilityAction7 == null || (function04 = (Function0) accessibilityAction7.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function04.invoke()).booleanValue();
                    case 4096:
                    case 8192:
                        break;
                    case 32768:
                        AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPasteText());
                        if (accessibilityAction8 == null || (function07 = (Function0) accessibilityAction8.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function07.invoke()).booleanValue();
                    case 65536:
                        AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCutText());
                        if (accessibilityAction9 == null || (function08 = (Function0) accessibilityAction9.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function08.invoke()).booleanValue();
                    case 262144:
                        AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getExpand());
                        if (accessibilityAction10 == null || (function09 = (Function0) accessibilityAction10.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function09.invoke()).booleanValue();
                    case 524288:
                        AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCollapse());
                        if (accessibilityAction11 == null || (function010 = (Function0) accessibilityAction11.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function010.invoke()).booleanValue();
                    case 1048576:
                        AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getDismiss());
                        if (accessibilityAction12 == null || (function011 = (Function0) accessibilityAction12.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function011.invoke()).booleanValue();
                    case 2097152:
                        String string = arguments != null ? arguments.getString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE) : null;
                        AccessibilityAction accessibilityAction13 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetText());
                        if (accessibilityAction13 == null || (function1 = (Function1) accessibilityAction13.getAction()) == null) {
                            return false;
                        }
                        if (string == null) {
                            string = "";
                        }
                        return ((Boolean) function1.invoke(new AnnotatedString(string, null, 2, null))).booleanValue();
                    case android.R.id.accessibilityActionShowOnScreen:
                        if (AndroidComposeUiFlags.isAccessibilityShowOnScreenNestedScrollingEnabled) {
                            return scrollOntoScreen(semanticsNode);
                        }
                        return legacyScrollOntoScreen(semanticsNode);
                    case android.R.id.accessibilityActionSetProgress:
                        if (arguments == null || !arguments.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE) || (accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) == null || (function12 = (Function1) accessibilityAction3.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function12.invoke(Float.valueOf(arguments.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)))).booleanValue();
                    case android.R.id.accessibilityActionImeEnter:
                        AccessibilityAction accessibilityAction14 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnImeAction());
                        if (accessibilityAction14 == null || (function012 = (Function0) accessibilityAction14.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function012.invoke()).booleanValue();
                    default:
                        switch (action) {
                            case android.R.id.accessibilityActionScrollUp:
                            case android.R.id.accessibilityActionScrollLeft:
                            case android.R.id.accessibilityActionScrollDown:
                            case android.R.id.accessibilityActionScrollRight:
                                break;
                            default:
                                switch (action) {
                                    case android.R.id.accessibilityActionPageUp:
                                        AccessibilityAction accessibilityAction15 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                                        if (accessibilityAction15 != null && (r1 = (Function0) accessibilityAction15.getAction()) != null) {
                                            break;
                                        }
                                        break;
                                    case android.R.id.accessibilityActionPageDown:
                                        AccessibilityAction accessibilityAction16 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown());
                                        if (accessibilityAction16 != null && (r1 = (Function0) accessibilityAction16.getAction()) != null) {
                                            break;
                                        }
                                        break;
                                    case android.R.id.accessibilityActionPageLeft:
                                        AccessibilityAction accessibilityAction17 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                                        if (accessibilityAction17 != null && (r1 = (Function0) accessibilityAction17.getAction()) != null) {
                                            break;
                                        }
                                        break;
                                    case android.R.id.accessibilityActionPageRight:
                                        AccessibilityAction accessibilityAction18 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight());
                                        if (accessibilityAction18 != null && (r1 = (Function0) accessibilityAction18.getAction()) != null) {
                                            break;
                                        }
                                        break;
                                    default:
                                        SparseArrayCompat<CharSequence> sparseArrayCompat = this.actionIdToLabel.get(virtualViewId);
                                        if (sparseArrayCompat != null && (charSequence = sparseArrayCompat.get(action)) != null && (list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions())) != null) {
                                            int size = list.size();
                                            for (int i = 0; i < size; i++) {
                                                CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list.get(i);
                                                if (Intrinsics.areEqual(customAccessibilityAction.getLabel(), charSequence)) {
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                        break;
                                }
                                break;
                        }
                        return false;
                }
                boolean z = action == 4096;
                boolean z2 = action == 8192;
                boolean z3 = action == 16908345;
                boolean z4 = action == 16908347;
                boolean z5 = action == 16908344;
                boolean z6 = action == 16908346;
                boolean z7 = z3 || z4 || z || z2;
                boolean z8 = z5 || z6 || z || z2;
                if (z || z2) {
                    ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
                    AccessibilityAction accessibilityAction19 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress());
                    if (progressBarRangeInfo != null && accessibilityAction19 != null) {
                        float fCoerceAtLeast = RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue());
                        float fCoerceAtMost = RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue());
                        if (progressBarRangeInfo.getSteps() > 0) {
                            f2 = fCoerceAtLeast - fCoerceAtMost;
                            steps = progressBarRangeInfo.getSteps() + 1;
                        } else {
                            f2 = fCoerceAtLeast - fCoerceAtMost;
                            steps = 20;
                        }
                        float f4 = f2 / steps;
                        if (z2) {
                            f4 = -f4;
                        }
                        Function1 function13 = (Function1) accessibilityAction19.getAction();
                        if (function13 != null) {
                            return ((Boolean) function13.invoke(Float.valueOf(progressBarRangeInfo.getCurrent() + f4))).booleanValue();
                        }
                        return false;
                    }
                }
                long jM5756getSizeNHjbRc = LayoutCoordinatesKt.boundsInParent(semanticsNode.getLayoutInfo().getCoordinates()).m5756getSizeNHjbRc();
                Float scrollViewportLength = SemanticsUtils_androidKt.getScrollViewportLength(semanticsNode.getUnmergedConfig());
                AccessibilityAction accessibilityAction20 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollBy());
                if (accessibilityAction20 == null) {
                    return false;
                }
                ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                if (scrollAxisRange == null || !z7) {
                    f3 = 0.0f;
                } else {
                    if (scrollViewportLength != null) {
                        fIntBitsToFloat2 = scrollViewportLength.floatValue();
                        f3 = 0.0f;
                    } else {
                        f3 = 0.0f;
                        fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM5756getSizeNHjbRc >> 32));
                    }
                    if (z3 || z2) {
                        fIntBitsToFloat2 = -fIntBitsToFloat2;
                    }
                    if (scrollAxisRange.getReverseScrolling()) {
                        fIntBitsToFloat2 = -fIntBitsToFloat2;
                    }
                    if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode) && (z3 || z4)) {
                        fIntBitsToFloat2 = -fIntBitsToFloat2;
                    }
                    if (performActionHelper$canScroll(scrollAxisRange, fIntBitsToFloat2)) {
                        if (!semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getPageLeft()) && !semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getPageRight())) {
                            Function2 function2 = (Function2) accessibilityAction20.getAction();
                            if (function2 != null) {
                                return ((Boolean) function2.invoke(Float.valueOf(fIntBitsToFloat2), Float.valueOf(f3))).booleanValue();
                            }
                            return false;
                        }
                        if (fIntBitsToFloat2 > f3) {
                            accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight());
                        } else {
                            accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                        }
                        if (accessibilityAction2 == null || (function06 = (Function0) accessibilityAction2.getAction()) == null) {
                            return false;
                        }
                        return ((Boolean) function06.invoke()).booleanValue();
                    }
                }
                ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                if (scrollAxisRange2 != null && z8) {
                    if (scrollViewportLength != null) {
                        fIntBitsToFloat = scrollViewportLength.floatValue();
                    } else {
                        fIntBitsToFloat = Float.intBitsToFloat((int) (4294967295L & jM5756getSizeNHjbRc));
                    }
                    if (z5 || z2) {
                        fIntBitsToFloat = -fIntBitsToFloat;
                    }
                    if (scrollAxisRange2.getReverseScrolling()) {
                        fIntBitsToFloat = -fIntBitsToFloat;
                    }
                    if (performActionHelper$canScroll(scrollAxisRange2, fIntBitsToFloat)) {
                        if (!semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getPageUp()) && !semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getPageDown())) {
                            Function2 function22 = (Function2) accessibilityAction20.getAction();
                            if (function22 != null) {
                                return ((Boolean) function22.invoke(Float.valueOf(f3), Float.valueOf(fIntBitsToFloat))).booleanValue();
                            }
                            return false;
                        }
                        if (fIntBitsToFloat > f3) {
                            accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown());
                        } else {
                            accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                        }
                        if (accessibilityAction != null && (function05 = (Function0) accessibilityAction.getAction()) != null) {
                            return ((Boolean) function05.invoke()).booleanValue();
                        }
                    }
                }
                return false;
            }
            if (!Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getFocused()), (Object) true)) {
                return false;
            }
            this.view.getFocusOwner().mo5614clearFocusI7lrPNg(false, true, true, FocusDirection.INSTANCE.m5604getExitdhqQ8s());
            return true;
        }
        boolean accessibilitySelection = setAccessibilitySelection(semanticsNode, arguments != null ? arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT, -1) : -1, arguments != null ? arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT, -1) : -1, false);
        if (accessibilitySelection) {
            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), 0, null, null, 12, null);
        }
        return accessibilitySelection;
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f2) {
        if (f2 >= 0.0f || scrollAxisRange.getValue().invoke().floatValue() <= 0.0f) {
            return f2 > 0.0f && scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue();
        }
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x001a -> B:8:0x001b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:8:0x001b
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @kotlin.Deprecated(message = "This method is deprecated. Use scrollOntoScreen instead.")
    private final boolean legacyScrollOntoScreen(androidx.compose.ui.semantics.SemanticsNode r9) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.legacyScrollOntoScreen(androidx.compose.ui.semantics.SemanticsNode):boolean");
    }

    private static final float legacyScrollOntoScreen$scrollDelta(float f2, float f3) {
        if (Math.signum(f2) == Math.signum(f3)) {
            return Math.abs(f2) < Math.abs(f3) ? f2 : f3;
        }
        return 0.0f;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x001a -> B:8:0x001b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:8:0x001b
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private final boolean scrollOntoScreen(androidx.compose.ui.semantics.SemanticsNode r15) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.scrollOntoScreen(androidx.compose.ui.semantics.SemanticsNode):boolean");
    }

    /* JADX INFO: renamed from: adjustForReversedScrollingAndRtl-RE3cj74, reason: not valid java name */
    private final long m7892adjustForReversedScrollingAndRtlRE3cj74(SemanticsNode semanticsNode, SemanticsNode semanticsNode2, long j) {
        if (Offset.m5720equalsimpl0(j, Offset.INSTANCE.m5739getZeroF1C5BW0())) {
            return j;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        if (scrollAxisRange != null && scrollAxisRange.getReverseScrolling()) {
            fIntBitsToFloat = -fIntBitsToFloat;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
            fIntBitsToFloat = -fIntBitsToFloat;
        }
        ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (scrollAxisRange2 != null && scrollAxisRange2.getReverseScrolling()) {
            fIntBitsToFloat2 = -fIntBitsToFloat2;
        }
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: scrollDxDyForNodeVisible-RE3cj74, reason: not valid java name */
    private final long m7895scrollDxDyForNodeVisibleRE3cj74(SemanticsNode semanticsNode, SemanticsNode semanticsNode2, long j) {
        androidx.compose.ui.geometry.Rect rectBoundsInParent = LayoutCoordinatesKt.boundsInParent(semanticsNode2.getLayoutInfo().getCoordinates());
        LayoutCoordinates parentLayoutCoordinates = semanticsNode2.getLayoutInfo().getCoordinates().getParentLayoutCoordinates();
        androidx.compose.ui.geometry.Rect rectM5760translatek4lQ0M = rectBoundsInParent.m5760translatek4lQ0M(parentLayoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(parentLayoutCoordinates) : Offset.INSTANCE.m5739getZeroF1C5BW0());
        androidx.compose.ui.geometry.Rect rectM5763Recttz77jQw = RectKt.m5763Recttz77jQw(Offset.m5728plusMKHz9U(semanticsNode.m8023getPositionInRootF1C5BW0(), j), IntSizeKt.m9013toSizeozmzZPI(semanticsNode.m8026getSizeYbymL2g()));
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(scrollDxDyForNodeVisible_RE3cj74$scrollDelta(rectM5763Recttz77jQw.getLeft() - rectM5760translatek4lQ0M.getLeft(), rectM5763Recttz77jQw.getRight() - rectM5760translatek4lQ0M.getRight()))) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(scrollDxDyForNodeVisible_RE3cj74$scrollDelta(rectM5763Recttz77jQw.getTop() - rectM5760translatek4lQ0M.getTop(), rectM5763Recttz77jQw.getBottom() - rectM5760translatek4lQ0M.getBottom())))));
    }

    private static final float scrollDxDyForNodeVisible_RE3cj74$scrollDelta(float f2, float f3) {
        if (Math.signum(f2) == Math.signum(f3)) {
            return Math.abs(f2) < Math.abs(f3) ? f2 : f3;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfoCompat info2, String extraDataKey, Bundle arguments) {
        SemanticsNode semanticsNode;
        float[] cornerArray;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalBeforeVal)) {
            int orDefault = this.idToBeforeMap.getOrDefault(virtualViewId, -1);
            if (orDefault != -1) {
                info2.getExtras().putInt(extraDataKey, orDefault);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalAfterVal)) {
            int orDefault2 = this.idToAfterMap.getOrDefault(virtualViewId, -1);
            if (orDefault2 != -1) {
                info2.getExtras().putInt(extraDataKey, orDefault2);
                return;
            }
            return;
        }
        int i = 0;
        if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && arguments != null && Intrinsics.areEqual(extraDataKey, AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY)) {
            int i2 = arguments.getInt(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX, -1);
            int i3 = arguments.getInt(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH, -1);
            if (i3 > 0 && i2 >= 0) {
                if (i2 < (iterableTextForAccessibility != null ? iterableTextForAccessibility.length() : Integer.MAX_VALUE)) {
                    TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(semanticsNode.getUnmergedConfig());
                    if (textLayoutResult == null) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < i3; i4++) {
                        int i5 = i2 + i4;
                        if (i5 >= textLayoutResult.getLayoutInput().getText().length()) {
                            arrayList.add(null);
                        } else {
                            arrayList.add(toScreenCoords(semanticsNode, textLayoutResult.getBoundingBox(i5)));
                        }
                    }
                    info2.getExtras().putParcelableArray(extraDataKey, (Parcelable[]) arrayList.toArray(new RectF[0]));
                    return;
                }
            }
            Log.e(LogTag, "Invalid arguments for accessibility character locations");
            return;
        }
        if (semanticsNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag()) && arguments != null && Intrinsics.areEqual(extraDataKey, ExtraDataTestTagKey)) {
            String str = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag());
            if (str != null) {
                info2.getExtras().putCharSequence(extraDataKey, str);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataIdKey)) {
            info2.getExtras().putInt(extraDataKey, semanticsNode.getId());
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataShapeTypeKey)) {
            Shape shape = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getShape());
            if (shape != null) {
                androidx.compose.ui.geometry.Rect shapeBounds = getShapeBounds(semanticsNode, getBoundsInScreen(info2), shape);
                Outline outlineM7894createOutline12SF9DM = m7894createOutline12SF9DM(shape, shapeBounds.m5756getSizeNHjbRc(), semanticsNode.getLayoutInfo().getLayoutDirection());
                if (outlineM7894createOutline12SF9DM instanceof Outline.Rectangle) {
                    info2.getExtras().putInt(ExtraDataShapeTypeKey, 0);
                    info2.getExtras().putParcelable(ExtraDataShapeRectKey, toAndroidRect(outlineM7894createOutline12SF9DM, shapeBounds.getLeft(), shapeBounds.getTop()));
                    return;
                } else if (outlineM7894createOutline12SF9DM instanceof Outline.Rounded) {
                    info2.getExtras().putInt(ExtraDataShapeTypeKey, 1);
                    info2.getExtras().putParcelable(ExtraDataShapeRectKey, toAndroidRect(outlineM7894createOutline12SF9DM, shapeBounds.getLeft(), shapeBounds.getTop()));
                    info2.getExtras().putFloatArray(ExtraDataShapeRectCornersKey, toCornerArray(outlineM7894createOutline12SF9DM));
                    return;
                } else {
                    if (outlineM7894createOutline12SF9DM instanceof Outline.Generic) {
                        info2.getExtras().putInt(ExtraDataShapeTypeKey, 2);
                        info2.getExtras().putParcelable(ExtraDataShapeRegionKey, toRegion(outlineM7894createOutline12SF9DM, shapeBounds.getLeft(), shapeBounds.getTop()));
                        return;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataShapeRectKey)) {
            Shape shape2 = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getShape());
            if (shape2 != null) {
                androidx.compose.ui.geometry.Rect shapeBounds2 = getShapeBounds(semanticsNode, getBoundsInScreen(info2), shape2);
                Rect androidRect = toAndroidRect(m7894createOutline12SF9DM(shape2, shapeBounds2.m5756getSizeNHjbRc(), semanticsNode.getLayoutInfo().getLayoutDirection()), shapeBounds2.getLeft(), shapeBounds2.getTop());
                if (androidRect != null) {
                    info2.getExtras().putParcelable(ExtraDataShapeRectKey, androidRect);
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataShapeRectCornersKey)) {
            Shape shape3 = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getShape());
            if (shape3 == null || (cornerArray = toCornerArray(m7894createOutline12SF9DM(shape3, getShapeBounds(semanticsNode, getBoundsInScreen(info2), shape3).m5756getSizeNHjbRc(), semanticsNode.getLayoutInfo().getLayoutDirection()))) == null) {
                return;
            }
            info2.getExtras().putFloatArray(ExtraDataShapeRectCornersKey, cornerArray);
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataShapeRegionKey)) {
            Shape shape4 = (Shape) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getShape());
            if (shape4 != null) {
                androidx.compose.ui.geometry.Rect shapeBounds3 = getShapeBounds(semanticsNode, getBoundsInScreen(info2), shape4);
                Region region = toRegion(m7894createOutline12SF9DM(shape4, shapeBounds3.m5756getSizeNHjbRc(), semanticsNode.getLayoutInfo().getLayoutDirection()), shapeBounds3.getLeft(), shapeBounds3.getTop());
                if (region != null) {
                    info2.getExtras().putParcelable(ExtraDataShapeRegionKey, region);
                    return;
                }
                return;
            }
            return;
        }
        ScatterSet<SemanticsPropertyKey<?>> accessibilityExtraKeys$ui = semanticsNode.getUnmergedConfig().getAccessibilityExtraKeys$ui();
        if (accessibilityExtraKeys$ui == null) {
            return;
        }
        Object[] objArr = accessibilityExtraKeys$ui.elements;
        long[] jArr = accessibilityExtraKeys$ui.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j = jArr[i6];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = i; i8 < i7; i8++) {
                    if ((255 & j) < 128) {
                        SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) objArr[(i6 << 3) + i8];
                        String accessibilityExtraKey = semanticsPropertyKey.getAccessibilityExtraKey();
                        if (Intrinsics.areEqual(accessibilityExtraKey, extraDataKey)) {
                            Object orNull = SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsPropertyKey);
                            if (orNull instanceof Serializable) {
                                info2.getExtras().putSerializable(accessibilityExtraKey, (Serializable) orNull);
                            } else {
                                if (!(orNull instanceof Parcelable)) {
                                    throw new IllegalStateException("Accessibility extra values must be either Serializable or Parcelable.");
                                }
                                info2.getExtras().putParcelable(accessibilityExtraKey, (Parcelable) orNull);
                            }
                        } else {
                            continue;
                        }
                    }
                    j >>= 8;
                }
                if (i7 != 8) {
                    return;
                }
            }
            if (i6 == length) {
                return;
            }
            i6++;
            i = 0;
        }
    }

    private final Rect getBoundsInScreen(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Rect rect = new Rect();
        accessibilityNodeInfoCompat.getBoundsInScreen(rect);
        return rect;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0091 A[LOOP:0: B:5:0x0021->B:40:0x0091, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0096 A[EDGE_INSN: B:53:0x0096->B:41:0x0096 BREAK  A[LOOP:0: B:5:0x0021->B:40:0x0091], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$getShapeBounds$shapeNodeMatcher$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.ui.geometry.Rect getShapeBounds(androidx.compose.ui.semantics.SemanticsNode r11, android.graphics.Rect r12, final androidx.compose.ui.graphics.Shape r13) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.getShapeBounds(androidx.compose.ui.semantics.SemanticsNode, android.graphics.Rect, androidx.compose.ui.graphics.Shape):androidx.compose.ui.geometry.Rect");
    }

    private final androidx.compose.ui.geometry.Rect toBoundsRelativeToNodeBounds(Rect rect, Rect rect2) {
        float f2 = rect.left - rect2.left;
        float f3 = rect.top - rect2.top;
        return new androidx.compose.ui.geometry.Rect(f2, f3, rect.width() + f2, rect.height() + f3);
    }

    private final RectF toScreenCoords(SemanticsNode textNode, androidx.compose.ui.geometry.Rect bounds) {
        if (textNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect rectM5760translatek4lQ0M = bounds.m5760translatek4lQ0M(textNode.m8023getPositionInRootF1C5BW0());
        androidx.compose.ui.geometry.Rect boundsInRoot = textNode.getBoundsInRoot();
        androidx.compose.ui.geometry.Rect rectIntersect = rectM5760translatek4lQ0M.overlaps(boundsInRoot) ? rectM5760translatek4lQ0M.intersect(boundsInRoot) : null;
        if (rectIntersect == null) {
            return null;
        }
        AndroidComposeView androidComposeView = this.view;
        float left = rectIntersect.getLeft();
        long jMo7394localToScreenMKHz9U = androidComposeView.mo7394localToScreenMKHz9U(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(rectIntersect.getTop())) & 4294967295L) | (((long) Float.floatToRawIntBits(left)) << 32)));
        long jMo7394localToScreenMKHz9U2 = this.view.mo7394localToScreenMKHz9U(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(rectIntersect.getRight())) << 32) | (((long) Float.floatToRawIntBits(rectIntersect.getBottom())) & 4294967295L)));
        int i = (int) (jMo7394localToScreenMKHz9U >> 32);
        int i2 = (int) (jMo7394localToScreenMKHz9U2 >> 32);
        int i3 = (int) (jMo7394localToScreenMKHz9U & 4294967295L);
        int i4 = (int) (jMo7394localToScreenMKHz9U2 & 4294967295L);
        return new RectF(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)));
    }

    /* JADX INFO: renamed from: createOutline-12SF9DM, reason: not valid java name */
    private final Outline m7894createOutline12SF9DM(Shape shape, long j, LayoutDirection layoutDirection) {
        return shape.mo382createOutlinePq9zytI(j, layoutDirection, this.view.getDensity());
    }

    private final Rect toAndroidRect(Outline outline, float f2, float f3) {
        if ((outline instanceof Outline.Rectangle) || (outline instanceof Outline.Rounded)) {
            return toAndroidRect(outline.getRect(), f2, f3);
        }
        return null;
    }

    private final float[] toCornerArray(Outline outline) {
        if (!(outline instanceof Outline.Rounded)) {
            return null;
        }
        Outline.Rounded rounded = (Outline.Rounded) outline;
        return new float[]{Float.intBitsToFloat((int) (rounded.getRoundRect().m5773getTopLeftCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5773getTopLeftCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5774getTopRightCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5774getTopRightCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5772getBottomRightCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5772getBottomRightCornerRadiuskKHJgLs() & 4294967295L)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5771getBottomLeftCornerRadiuskKHJgLs() >> 32)), Float.intBitsToFloat((int) (rounded.getRoundRect().m5771getBottomLeftCornerRadiuskKHJgLs() & 4294967295L))};
    }

    private final Region toRegion(Outline outline, float f2, float f3) {
        if (!(outline instanceof Outline.Generic)) {
            return null;
        }
        Outline.Generic generic = (Outline.Generic) outline;
        Region region = new Region(toAndroidRect$default(this, generic.getRect().translate(f2, f3), 0.0f, 0.0f, 3, null));
        Region region2 = new Region();
        Path path = generic.getPath();
        if (path instanceof AndroidPath) {
            android.graphics.Path internalPath = ((AndroidPath) path).getInternalPath();
            internalPath.offset(f2, f3);
            region2.setPath(internalPath, region);
            return region2;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    static /* synthetic */ Rect toAndroidRect$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, androidx.compose.ui.geometry.Rect rect, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i & 2) != 0) {
            f3 = 0.0f;
        }
        return androidComposeViewAccessibilityDelegateCompat.toAndroidRect(rect, f2, f3);
    }

    private final Rect toAndroidRect(androidx.compose.ui.geometry.Rect rect, float f2, float f3) {
        return new Rect((int) (rect.getLeft() + f2), (int) (rect.getTop() + f3), (int) (rect.getRight() + f2), (int) (rect.getBottom() + f3));
    }

    public final boolean dispatchHoverEvent$ui(MotionEvent event) {
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        int action = event.getAction();
        if (action == 7 || action == 9) {
            int iHitTestSemanticsAt$ui = hitTestSemanticsAt$ui(event.getX(), event.getY());
            boolean zDispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui().dispatchGenericMotionEvent(event);
            updateHoveredVirtualView(iHitTestSemanticsAt$ui);
            if (iHitTestSemanticsAt$ui == Integer.MIN_VALUE) {
                return zDispatchGenericMotionEvent;
            }
            return true;
        }
        if (action != 10) {
            return false;
        }
        if (this.hoveredVirtualViewId != Integer.MIN_VALUE) {
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
        return this.view.getAndroidViewsHandler$ui().dispatchGenericMotionEvent(event);
    }

    public final int hitTestSemanticsAt$ui(float x, float y) {
        int iSemanticsNodeIdToAccessibilityVirtualNodeId;
        Owner.measureAndLayout$default(this.view, false, 1, null);
        HitTestResult hitTestResult = new HitTestResult();
        LayoutNode.m7669hitTestSemantics6fMxITs$ui$default(this.view.getRoot(), Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(y)) & 4294967295L) | (Float.floatToRawIntBits(x) << 32)), hitTestResult, 0, false, 12, null);
        int lastIndex = CollectionsKt.getLastIndex(hitTestResult);
        while (true) {
            iSemanticsNodeIdToAccessibilityVirtualNodeId = Integer.MIN_VALUE;
            if (-1 >= lastIndex) {
                break;
            }
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(hitTestResult.get(lastIndex));
            if (this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().get(layoutNodeRequireLayoutNode) != null) {
                return Integer.MIN_VALUE;
            }
            if (layoutNodeRequireLayoutNode.getNodes().m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(8))) {
                iSemanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(layoutNodeRequireLayoutNode.getSemanticsId());
                SemanticsNode SemanticsNode = SemanticsNodeKt.SemanticsNode(layoutNodeRequireLayoutNode, false);
                if (SemanticsOwnerKt.isImportantForAccessibility(SemanticsNode) && !SemanticsNode_androidKt.isAccessibilityIgnoredLink(SemanticsNode)) {
                    break;
                }
            }
            lastIndex--;
        }
        return iSemanticsNodeIdToAccessibilityVirtualNodeId;
    }

    private final void updateHoveredVirtualView(int virtualViewId) {
        int i = this.hoveredVirtualViewId;
        if (i == virtualViewId) {
            return;
        }
        this.hoveredVirtualViewId = virtualViewId;
        sendEventForVirtualView$default(this, virtualViewId, 128, null, null, 12, null);
        sendEventForVirtualView$default(this, i, 256, null, null, 12, null);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T text, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size should be greater than 0".toString());
        }
        if (text == null || text.length() == 0 || text.length() <= size) {
            return text;
        }
        int i = size - 1;
        if (Character.isHighSurrogate(text.charAt(i)) && Character.isLowSurrogate(text.charAt(size))) {
            size = i;
        }
        T t = (T) text.subSequence(0, size);
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void semanticsChangeChecker$lambda$0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Trace.beginSection("measureAndLayout");
        try {
            Owner.measureAndLayout$default(androidComposeViewAccessibilityDelegateCompat.view, false, 1, null);
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("checkForSemanticsChanges");
            try {
                androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
            } finally {
            }
        } finally {
        }
    }

    public final void onSemanticsChange$ui() {
        this.currentSemanticsNodesInvalidated = true;
        Handler handler = getHandler();
        if (!isEnabled$ui() || this.checkingForSemanticsChanges || handler == null) {
            return;
        }
        this.checkingForSemanticsChanges = true;
        handler.post(this.semanticsChangeChecker);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c6, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r7, r0) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072 A[Catch: all -> 0x00d1, TryCatch #0 {all -> 0x00d1, blocks: (B:13:0x0032, B:22:0x005a, B:26:0x006a, B:28:0x0072, B:30:0x007b, B:32:0x0086, B:33:0x0097, B:36:0x00a4, B:37:0x00ab, B:18:0x0047, B:21:0x004e), top: B:45:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c6 -> B:14:0x0035). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object boundsUpdatesEventLoop$ui(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop$ui(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onLayoutChange$ui(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo13895trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendTypeViewScrolledAccessibilityEvent(LayoutNode layoutNode) {
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int semanticsId = layoutNode.getSemanticsId();
            ScrollAxisRange scrollAxisRange = this.pendingHorizontalScrollEvents.get(semanticsId);
            ScrollAxisRange scrollAxisRange2 = this.pendingVerticalScrollEvents.get(semanticsId);
            if (scrollAxisRange == null && scrollAxisRange2 == null) {
                return;
            }
            AccessibilityEvent accessibilityEventCreateEvent = createEvent(semanticsId, 4096);
            if (scrollAxisRange != null) {
                accessibilityEventCreateEvent.setScrollX((int) scrollAxisRange.getValue().invoke().floatValue());
                accessibilityEventCreateEvent.setMaxScrollX((int) scrollAxisRange.getMaxValue().invoke().floatValue());
            }
            if (scrollAxisRange2 != null) {
                accessibilityEventCreateEvent.setScrollY((int) scrollAxisRange2.getValue().invoke().floatValue());
                accessibilityEventCreateEvent.setMaxScrollY((int) scrollAxisRange2.getMaxValue().invoke().floatValue());
            }
            sendEvent(accessibilityEventCreateEvent);
        }
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, MutableIntSet subtreeChangedSemanticsNodesIds) {
        SemanticsConfiguration semanticsConfiguration;
        LayoutNode layoutNodeFindClosestParentNode;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui().getLayoutNodeToHolder().containsKey(layoutNode)) {
            if (!layoutNode.getNodes().m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(8))) {
                layoutNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(LayoutNode layoutNode2) {
                        return Boolean.valueOf(layoutNode2.getNodes().m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(8)));
                    }
                });
            }
            if (layoutNode == null || (semanticsConfiguration = layoutNode.getSemanticsConfiguration()) == null) {
                return;
            }
            if (!semanticsConfiguration.getIsMergingSemanticsOfDescendants() && (layoutNodeFindClosestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSubtreeChangeAccessibilityEvents.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode layoutNode2) {
                    SemanticsConfiguration semanticsConfiguration2 = layoutNode2.getSemanticsConfiguration();
                    boolean z = false;
                    if (semanticsConfiguration2 != null && semanticsConfiguration2.getIsMergingSemanticsOfDescendants()) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            })) != null) {
                layoutNode = layoutNodeFindClosestParentNode;
            }
            if (layoutNode != null) {
                int semanticsId = layoutNode.getSemanticsId();
                if (subtreeChangedSemanticsNodesIds.add(semanticsId)) {
                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsId), 2048, 1, null, 8, null);
                }
            }
        }
    }

    private final void checkForSemanticsChanges() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (isEnabled$ui()) {
                sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    updateSemanticsNodesCopyAndPanes();
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateSemanticsNodesCopyAndPanes() {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.updateSemanticsNodesCopyAndPanes():void");
    }

    private final void sendSemanticsPropertyChangeEvents(IntObjectMap<SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        ArrayList arrayList;
        int[] iArr;
        long[] jArr;
        int i;
        int i2;
        ArrayList arrayList2;
        int[] iArr2;
        long[] jArr2;
        int i3;
        char c2;
        int i4;
        int i5;
        SemanticsNode semanticsNode;
        int i6;
        boolean zPropertiesDeleted;
        Object[] objArr;
        int i7;
        int i8;
        Object[] objArr2;
        ArrayList arrayList3;
        int i9;
        long[] jArr3;
        SemanticsNode semanticsNode2;
        int[] iArr3;
        int i10;
        int i11;
        int i12;
        String text;
        int i13;
        int i14;
        int i15;
        boolean z;
        AccessibilityEvent accessibilityEventCreateTextSelectionChangedEvent;
        boolean zSendEventForVirtualView$default;
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> intObjectMap = newSemanticsNodes;
        ArrayList arrayList4 = new ArrayList(androidComposeViewAccessibilityDelegateCompat.scrollObservationScopes);
        androidComposeViewAccessibilityDelegateCompat.scrollObservationScopes.clear();
        int[] iArr4 = intObjectMap.keys;
        long[] jArr4 = intObjectMap.metadata;
        int i16 = 2;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i17 = 0;
        while (true) {
            long j = jArr4[i17];
            char c3 = 7;
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i18 = 8;
                int i19 = 8 - ((~(i17 - length)) >>> 31);
                long j2 = j;
                int i20 = 0;
                while (i20 < i19) {
                    if ((j2 & 255) < 128) {
                        int i21 = iArr4[(i17 << 3) + i20];
                        SemanticsNodeCopy semanticsNodeCopy = androidComposeViewAccessibilityDelegateCompat.previousSemanticsNodes.get(i21);
                        if (semanticsNodeCopy == null) {
                            i2 = i20;
                            arrayList2 = arrayList4;
                            iArr2 = iArr4;
                            jArr2 = jArr4;
                            i3 = i16;
                            c2 = c3;
                            i4 = i19;
                        } else {
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = intObjectMap.get(i21);
                            SemanticsNode semanticsNode3 = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                            if (semanticsNode3 != null) {
                                MutableScatterMap<SemanticsPropertyKey<?>, Object> props$ui = semanticsNode3.getUnmergedConfig().getProps$ui();
                                i3 = i16;
                                Object[] objArr3 = props$ui.keys;
                                Object[] objArr4 = props$ui.values;
                                long[] jArr5 = props$ui.metadata;
                                c2 = c3;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    int i22 = i18;
                                    SemanticsNode semanticsNode4 = semanticsNode3;
                                    zPropertiesDeleted = false;
                                    int i23 = 0;
                                    while (true) {
                                        long j3 = jArr5[i23];
                                        long[] jArr6 = jArr5;
                                        if ((((~j3) << c2) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i24 = 8 - ((~(i23 - length2)) >>> 31);
                                            long j4 = j3;
                                            int i25 = 0;
                                            while (i25 < i24) {
                                                if ((j4 & 255) < 128) {
                                                    int i26 = (i23 << 3) + i25;
                                                    Object obj = objArr3[i26];
                                                    Object obj2 = objArr4[i26];
                                                    SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) obj;
                                                    i8 = i20;
                                                    if (((Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) || Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) ? androidComposeViewAccessibilityDelegateCompat.registerScrollingId(i21, arrayList4) : false) || !Intrinsics.areEqual(obj2, SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), semanticsPropertyKey))) {
                                                        if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getPaneTitle())) {
                                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                                                            String str = (String) obj2;
                                                            if (semanticsNodeCopy.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                                                androidComposeViewAccessibilityDelegateCompat.sendPaneChangeEvents(i21, i22, str);
                                                            }
                                                            Unit unit = Unit.INSTANCE;
                                                        } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getStateDescription())) {
                                                            i9 = i25;
                                                            arrayList3 = arrayList4;
                                                            jArr3 = jArr4;
                                                            objArr2 = objArr3;
                                                            i12 = i19;
                                                            i10 = i23;
                                                            semanticsNode2 = semanticsNode4;
                                                            iArr3 = iArr4;
                                                            i11 = i21;
                                                            sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i21), 2048, 64, null, 8, null);
                                                            Boolean.valueOf(sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 2048, 0, null, 8, null));
                                                        } else {
                                                            i9 = i25;
                                                            arrayList3 = arrayList4;
                                                            jArr3 = jArr4;
                                                            objArr2 = objArr3;
                                                            i10 = i23;
                                                            i12 = i19;
                                                            semanticsNode2 = semanticsNode4;
                                                            iArr3 = iArr4;
                                                            i11 = i21;
                                                            if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getToggleableState())) {
                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 2048, 8192, null, 8, null);
                                                                Boolean.valueOf(sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 2048, 0, null, 8, null));
                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getError())) {
                                                                Boolean.valueOf(sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 2048, 3072, null, 8, null));
                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getProgressBarRangeInfo())) {
                                                                sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 2048, 64, null, 8, null);
                                                                Boolean.valueOf(sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 2048, 0, null, 8, null));
                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getSelected())) {
                                                                Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
                                                                if (role == null ? false : Role.m8009equalsimpl0(role.getValue(), Role.INSTANCE.m8020getTabo7Vup1c())) {
                                                                    if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected()), (Object) true)) {
                                                                        AccessibilityEvent accessibilityEventCreateEvent = androidComposeViewAccessibilityDelegateCompat.createEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 4);
                                                                        SemanticsNode semanticsNodeCopyWithMergingEnabled$ui = semanticsNode2.copyWithMergingEnabled$ui();
                                                                        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopyWithMergingEnabled$ui.getConfig(), SemanticsProperties.INSTANCE.getContentDescription());
                                                                        String strFastJoinToString$default = list != null ? ListUtilsKt.fastJoinToString$default(list, Constants.SEPARATOR_COMMA, null, null, 0, null, null, 62, null) : null;
                                                                        List list2 = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopyWithMergingEnabled$ui.getConfig(), SemanticsProperties.INSTANCE.getText());
                                                                        String strFastJoinToString$default2 = list2 != null ? ListUtilsKt.fastJoinToString$default(list2, Constants.SEPARATOR_COMMA, null, null, 0, null, null, 62, null) : null;
                                                                        if (strFastJoinToString$default != null) {
                                                                            accessibilityEventCreateEvent.setContentDescription(strFastJoinToString$default);
                                                                            Unit unit2 = Unit.INSTANCE;
                                                                            Unit unit3 = Unit.INSTANCE;
                                                                        }
                                                                        if (strFastJoinToString$default2 != null) {
                                                                            Boolean.valueOf(accessibilityEventCreateEvent.getText().add(strFastJoinToString$default2));
                                                                        }
                                                                        zSendEventForVirtualView$default = androidComposeViewAccessibilityDelegateCompat.sendEvent(accessibilityEventCreateEvent);
                                                                    } else {
                                                                        zSendEventForVirtualView$default = sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 2048, 0, null, 8, null);
                                                                    }
                                                                } else {
                                                                    sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 2048, 64, null, 8, null);
                                                                    zSendEventForVirtualView$default = sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 2048, 0, null, 8, null);
                                                                }
                                                                Boolean.valueOf(zSendEventForVirtualView$default);
                                                            } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getContentDescription())) {
                                                                int iSemanticsNodeIdToAccessibilityVirtualNodeId = androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11);
                                                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                                                Boolean.valueOf(androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(iSemanticsNodeIdToAccessibilityVirtualNodeId, 2048, 4, (List) obj2));
                                                            } else {
                                                                String str2 = "";
                                                                if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getEditableText())) {
                                                                    if (semanticsNode2.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetText())) {
                                                                        AnnotatedString textForTextField = androidComposeViewAccessibilityDelegateCompat.getTextForTextField(semanticsNodeCopy.getUnmergedConfig());
                                                                        String str3 = textForTextField != null ? textForTextField : "";
                                                                        AnnotatedString textForTextField2 = androidComposeViewAccessibilityDelegateCompat.getTextForTextField(semanticsNode2.getUnmergedConfig());
                                                                        String str4 = textForTextField2 != null ? textForTextField2 : "";
                                                                        CharSequence charSequenceTrimToSize = androidComposeViewAccessibilityDelegateCompat.trimToSize(str4, 100000);
                                                                        int length3 = str3.length();
                                                                        int length4 = str4.length();
                                                                        int iCoerceAtMost = RangesKt.coerceAtMost(length3, length4);
                                                                        int i27 = 0;
                                                                        while (true) {
                                                                            i13 = length3;
                                                                            if (i27 >= iCoerceAtMost) {
                                                                                i14 = length4;
                                                                                break;
                                                                            }
                                                                            i14 = length4;
                                                                            if (str3.charAt(i27) != str4.charAt(i27)) {
                                                                                break;
                                                                            }
                                                                            i27++;
                                                                            length3 = i13;
                                                                            length4 = i14;
                                                                        }
                                                                        int i28 = 0;
                                                                        while (true) {
                                                                            if (i28 >= iCoerceAtMost - i27) {
                                                                                i15 = i28;
                                                                                break;
                                                                            }
                                                                            i15 = i28;
                                                                            if (str3.charAt((i13 - 1) - i28) != str4.charAt((i14 - 1) - i15)) {
                                                                                break;
                                                                            } else {
                                                                                i28 = i15 + 1;
                                                                            }
                                                                        }
                                                                        int i29 = (i13 - i15) - i27;
                                                                        int i30 = (i14 - i15) - i27;
                                                                        boolean zContains = semanticsNodeCopy.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword());
                                                                        boolean zContains2 = semanticsNode2.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword());
                                                                        boolean zContains3 = semanticsNodeCopy.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText());
                                                                        boolean z2 = zContains3 && !zContains && zContains2;
                                                                        boolean z3 = zContains3 && zContains && !zContains2;
                                                                        if (z2 || z3) {
                                                                            z = z2;
                                                                            accessibilityEventCreateTextSelectionChangedEvent = androidComposeViewAccessibilityDelegateCompat.createTextSelectionChangedEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 0, 0, Integer.valueOf(i14), charSequenceTrimToSize);
                                                                        } else {
                                                                            z = z2;
                                                                            accessibilityEventCreateTextSelectionChangedEvent = androidComposeViewAccessibilityDelegateCompat.createEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 16);
                                                                            accessibilityEventCreateTextSelectionChangedEvent.setFromIndex(i27);
                                                                            accessibilityEventCreateTextSelectionChangedEvent.setRemovedCount(i29);
                                                                            accessibilityEventCreateTextSelectionChangedEvent.setAddedCount(i30);
                                                                            accessibilityEventCreateTextSelectionChangedEvent.setBeforeText(str3);
                                                                            accessibilityEventCreateTextSelectionChangedEvent.getText().add(charSequenceTrimToSize);
                                                                        }
                                                                        accessibilityEventCreateTextSelectionChangedEvent.setClassName(TextFieldClassName);
                                                                        androidComposeViewAccessibilityDelegateCompat.sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                        if (z || z3) {
                                                                            long packedValue = ((TextRange) semanticsNode2.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue();
                                                                            accessibilityEventCreateTextSelectionChangedEvent.setFromIndex(TextRange.m8273getStartimpl(packedValue));
                                                                            accessibilityEventCreateTextSelectionChangedEvent.setToIndex(TextRange.m8268getEndimpl(packedValue));
                                                                            androidComposeViewAccessibilityDelegateCompat.sendEvent(accessibilityEventCreateTextSelectionChangedEvent);
                                                                        }
                                                                        Unit unit4 = Unit.INSTANCE;
                                                                    } else {
                                                                        Boolean.valueOf(sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), 2048, Integer.valueOf(i3), null, 8, null));
                                                                    }
                                                                } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getTextSelectionRange())) {
                                                                    AnnotatedString textForTextField3 = androidComposeViewAccessibilityDelegateCompat.getTextForTextField(semanticsNode2.getUnmergedConfig());
                                                                    if (textForTextField3 != null && (text = textForTextField3.getText()) != null) {
                                                                        str2 = text;
                                                                    }
                                                                    long packedValue2 = ((TextRange) semanticsNode2.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue();
                                                                    androidComposeViewAccessibilityDelegateCompat.sendEvent(androidComposeViewAccessibilityDelegateCompat.createTextSelectionChangedEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i11), Integer.valueOf(TextRange.m8273getStartimpl(packedValue2)), Integer.valueOf(TextRange.m8268getEndimpl(packedValue2)), Integer.valueOf(str2.length()), androidComposeViewAccessibilityDelegateCompat.trimToSize(str2, 100000)));
                                                                    androidComposeViewAccessibilityDelegateCompat.sendPendingTextTraversedAtGranularityEvent(semanticsNode2.getId());
                                                                    Unit unit5 = Unit.INSTANCE;
                                                                } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()) || Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getVerticalScrollAxisRange())) {
                                                                    androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode2.getLayoutNode());
                                                                    ScrollObservationScope scrollObservationScopeFindById = SemanticsUtils_androidKt.findById(androidComposeViewAccessibilityDelegateCompat.scrollObservationScopes, i11);
                                                                    Intrinsics.checkNotNull(scrollObservationScopeFindById);
                                                                    scrollObservationScopeFindById.setHorizontalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange()));
                                                                    scrollObservationScopeFindById.setVerticalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode2.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange()));
                                                                    androidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeeded(scrollObservationScopeFindById);
                                                                    Unit unit6 = Unit.INSTANCE;
                                                                } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsProperties.INSTANCE.getFocused())) {
                                                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                                                    if (((Boolean) obj2).booleanValue()) {
                                                                        androidComposeViewAccessibilityDelegateCompat.sendEvent(androidComposeViewAccessibilityDelegateCompat.createEvent(androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode2.getId()), 8));
                                                                    }
                                                                    Boolean.valueOf(sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode2.getId()), 2048, 0, null, 8, null));
                                                                } else if (Intrinsics.areEqual(semanticsPropertyKey, SemanticsActions.INSTANCE.getCustomActions())) {
                                                                    List list3 = (List) semanticsNode2.getUnmergedConfig().get(SemanticsActions.INSTANCE.getCustomActions());
                                                                    List list4 = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions());
                                                                    if (list4 != null) {
                                                                        MutableScatterSet mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
                                                                        int size = list3.size();
                                                                        for (int i31 = 0; i31 < size; i31++) {
                                                                            mutableScatterSetMutableScatterSetOf.add(((CustomAccessibilityAction) list3.get(i31)).getLabel());
                                                                        }
                                                                        MutableScatterSet mutableScatterSetMutableScatterSetOf2 = ScatterSetKt.mutableScatterSetOf();
                                                                        int size2 = list4.size();
                                                                        for (int i32 = 0; i32 < size2; i32++) {
                                                                            mutableScatterSetMutableScatterSetOf2.add(((CustomAccessibilityAction) list4.get(i32)).getLabel());
                                                                        }
                                                                        zPropertiesDeleted = !Intrinsics.areEqual(mutableScatterSetMutableScatterSetOf, mutableScatterSetMutableScatterSetOf2);
                                                                    } else if (!list3.isEmpty()) {
                                                                        zPropertiesDeleted = true;
                                                                    }
                                                                    Unit unit7 = Unit.INSTANCE;
                                                                } else {
                                                                    zPropertiesDeleted = ((obj2 instanceof AccessibilityAction) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals((AccessibilityAction) obj2, SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), semanticsPropertyKey))) ? false : true;
                                                                    Unit unit8 = Unit.INSTANCE;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    j4 >>= 8;
                                                    i25 = i9 + 1;
                                                    i19 = i12;
                                                    i21 = i11;
                                                    i22 = 8;
                                                    iArr4 = iArr3;
                                                    semanticsNode4 = semanticsNode2;
                                                    i20 = i8;
                                                    arrayList4 = arrayList3;
                                                    objArr3 = objArr2;
                                                    i23 = i10;
                                                    jArr4 = jArr3;
                                                } else {
                                                    i8 = i20;
                                                }
                                                i9 = i25;
                                                arrayList3 = arrayList4;
                                                jArr3 = jArr4;
                                                objArr2 = objArr3;
                                                i10 = i23;
                                                i12 = i19;
                                                semanticsNode2 = semanticsNode4;
                                                iArr3 = iArr4;
                                                i11 = i21;
                                                j4 >>= 8;
                                                i25 = i9 + 1;
                                                i19 = i12;
                                                i21 = i11;
                                                i22 = 8;
                                                iArr4 = iArr3;
                                                semanticsNode4 = semanticsNode2;
                                                i20 = i8;
                                                arrayList4 = arrayList3;
                                                objArr3 = objArr2;
                                                i23 = i10;
                                                jArr4 = jArr3;
                                            }
                                            i2 = i20;
                                            arrayList2 = arrayList4;
                                            jArr2 = jArr4;
                                            objArr = objArr3;
                                            i7 = i23;
                                            i4 = i19;
                                            semanticsNode = semanticsNode4;
                                            iArr2 = iArr4;
                                            i6 = i21;
                                            if (i24 != i22) {
                                                break;
                                            }
                                        } else {
                                            i2 = i20;
                                            arrayList2 = arrayList4;
                                            jArr2 = jArr4;
                                            objArr = objArr3;
                                            i7 = i23;
                                            i4 = i19;
                                            semanticsNode = semanticsNode4;
                                            iArr2 = iArr4;
                                            i6 = i21;
                                        }
                                        if (i7 == length2) {
                                            break;
                                        }
                                        int i33 = i7 + 1;
                                        i19 = i4;
                                        i21 = i6;
                                        iArr4 = iArr2;
                                        semanticsNode4 = semanticsNode;
                                        jArr5 = jArr6;
                                        jArr4 = jArr2;
                                        arrayList4 = arrayList2;
                                        objArr3 = objArr;
                                        i22 = 8;
                                        i23 = i33;
                                        i20 = i2;
                                    }
                                } else {
                                    i2 = i20;
                                    semanticsNode = semanticsNode3;
                                    arrayList2 = arrayList4;
                                    iArr2 = iArr4;
                                    jArr2 = jArr4;
                                    i6 = i21;
                                    i4 = i19;
                                    zPropertiesDeleted = false;
                                }
                                if (!zPropertiesDeleted) {
                                    zPropertiesDeleted = AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(semanticsNode, semanticsNodeCopy.getUnmergedConfig());
                                }
                                if (zPropertiesDeleted) {
                                    sendEventForVirtualView$default(androidComposeViewAccessibilityDelegateCompat, androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(i6), 2048, 0, null, 8, null);
                                }
                            } else {
                                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
                                throw new KotlinNothingValueException();
                            }
                        }
                        i5 = 8;
                    } else {
                        i2 = i20;
                        arrayList2 = arrayList4;
                        iArr2 = iArr4;
                        jArr2 = jArr4;
                        i3 = i16;
                        c2 = c3;
                        i4 = i19;
                        i5 = i18;
                    }
                    j2 >>= i5;
                    i20 = i2 + 1;
                    androidComposeViewAccessibilityDelegateCompat = this;
                    intObjectMap = newSemanticsNodes;
                    i19 = i4;
                    i18 = i5;
                    i16 = i3;
                    c3 = c2;
                    iArr4 = iArr2;
                    jArr4 = jArr2;
                    arrayList4 = arrayList2;
                }
                arrayList = arrayList4;
                iArr = iArr4;
                jArr = jArr4;
                i = i16;
                if (i19 != i18) {
                    return;
                }
            } else {
                arrayList = arrayList4;
                iArr = iArr4;
                jArr = jArr4;
                i = i16;
            }
            if (i17 == length) {
                return;
            }
            i17++;
            androidComposeViewAccessibilityDelegateCompat = this;
            intObjectMap = newSemanticsNodes;
            i16 = i;
            iArr4 = iArr;
            jArr4 = jArr;
            arrayList4 = arrayList;
        }
    }

    private final boolean registerScrollingId(int id, List<ScrollObservationScope> oldScrollObservationScopes) {
        boolean z;
        ScrollObservationScope scrollObservationScopeFindById = SemanticsUtils_androidKt.findById(oldScrollObservationScopes, id);
        if (scrollObservationScopeFindById != null) {
            z = false;
        } else {
            ScrollObservationScope scrollObservationScope = new ScrollObservationScope(id, this.scrollObservationScopes, null, null, null, null);
            z = true;
            scrollObservationScopeFindById = scrollObservationScope;
        }
        this.scrollObservationScopes.add(scrollObservationScopeFindById);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleScrollEventIfNeeded(final ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValidOwnerScope()) {
            OwnerSnapshotObserver snapshotObserver = this.view.getSnapshotObserver();
            snapshotObserver.observer.observeReads(scrollObservationScope, this.scheduleScrollEventIfNeededLambda, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeeded.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SemanticsNode semanticsNode;
                    LayoutNode layoutNode;
                    ScrollAxisRange horizontalScrollAxisRange = scrollObservationScope.getHorizontalScrollAxisRange();
                    ScrollAxisRange verticalScrollAxisRange = scrollObservationScope.getVerticalScrollAxisRange();
                    Float oldXValue = scrollObservationScope.getOldXValue();
                    Float oldYValue = scrollObservationScope.getOldYValue();
                    float fFloatValue = (horizontalScrollAxisRange == null || oldXValue == null) ? 0.0f : horizontalScrollAxisRange.getValue().invoke().floatValue() - oldXValue.floatValue();
                    float fFloatValue2 = (verticalScrollAxisRange == null || oldYValue == null) ? 0.0f : verticalScrollAxisRange.getValue().invoke().floatValue() - oldYValue.floatValue();
                    if (fFloatValue != 0.0f || fFloatValue2 != 0.0f) {
                        int iSemanticsNodeIdToAccessibilityVirtualNodeId = this.semanticsNodeIdToAccessibilityVirtualNodeId(scrollObservationScope.getSemanticsNodeId());
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) this.getCurrentSemanticsNodes().get(this.accessibilityFocusedVirtualViewId);
                        if (semanticsNodeWithAdjustedBounds != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this;
                            try {
                                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI;
                                if (accessibilityNodeInfoCompat != null) {
                                    accessibilityNodeInfoCompat.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat.boundsInScreen(semanticsNodeWithAdjustedBounds));
                                    Unit unit = Unit.INSTANCE;
                                }
                            } catch (IllegalStateException unused) {
                                Unit unit2 = Unit.INSTANCE;
                            }
                        }
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) this.getCurrentSemanticsNodes().get(this.focusedVirtualViewId);
                        if (semanticsNodeWithAdjustedBounds2 != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = this;
                            try {
                                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = androidComposeViewAccessibilityDelegateCompat2.currentlyFocusedANI;
                                if (accessibilityNodeInfoCompat2 != null) {
                                    accessibilityNodeInfoCompat2.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat2.boundsInScreen(semanticsNodeWithAdjustedBounds2));
                                    Unit unit3 = Unit.INSTANCE;
                                }
                            } catch (IllegalStateException unused2) {
                                Unit unit4 = Unit.INSTANCE;
                            }
                        }
                        this.getView().invalidate();
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds3 = (SemanticsNodeWithAdjustedBounds) this.getCurrentSemanticsNodes().get(iSemanticsNodeIdToAccessibilityVirtualNodeId);
                        if (semanticsNodeWithAdjustedBounds3 != null && (semanticsNode = semanticsNodeWithAdjustedBounds3.getSemanticsNode()) != null && (layoutNode = semanticsNode.getLayoutNode()) != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat3 = this;
                            if (horizontalScrollAxisRange != null) {
                                androidComposeViewAccessibilityDelegateCompat3.pendingHorizontalScrollEvents.set(iSemanticsNodeIdToAccessibilityVirtualNodeId, horizontalScrollAxisRange);
                            }
                            if (verticalScrollAxisRange != null) {
                                androidComposeViewAccessibilityDelegateCompat3.pendingVerticalScrollEvents.set(iSemanticsNodeIdToAccessibilityVirtualNodeId, verticalScrollAxisRange);
                            }
                            androidComposeViewAccessibilityDelegateCompat3.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                        }
                    }
                    if (horizontalScrollAxisRange != null) {
                        scrollObservationScope.setOldXValue(horizontalScrollAxisRange.getValue().invoke());
                    }
                    if (verticalScrollAxisRange != null) {
                        scrollObservationScope.setOldYValue(verticalScrollAxisRange.getValue().invoke());
                    }
                }
            });
        }
    }

    private final void sendPaneChangeEvents(int semanticsNodeId, int contentChangeType, String title) {
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNodeId), 32);
        accessibilityEventCreateEvent.setContentChangeTypes(contentChangeType);
        if (title != null) {
            accessibilityEventCreateEvent.getText().add(title);
        }
        sendEvent(accessibilityEventCreateEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void sendAccessibilitySemanticsStructureChangeEvents(androidx.compose.ui.semantics.SemanticsNode r17, androidx.compose.ui.platform.SemanticsNodeCopy r18) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendAccessibilitySemanticsStructureChangeEvents(androidx.compose.ui.semantics.SemanticsNode, androidx.compose.ui.platform.SemanticsNodeCopy):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int id) {
        if (id == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return id;
    }

    private final boolean traverseAtGranularity(SemanticsNode node, int granularity, boolean forward, boolean extendSelection) {
        AccessibilityIterators.TextSegmentIterator iteratorForGranularity;
        int accessibilitySelectionStart;
        int i;
        int id = node.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(node.getId());
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(node);
        String str = iterableTextForAccessibility;
        if (str == null || str.length() == 0 || (iteratorForGranularity = getIteratorForGranularity(node, granularity)) == null) {
            return false;
        }
        int accessibilitySelectionEnd = getAccessibilitySelectionEnd(node);
        if (accessibilitySelectionEnd == -1) {
            accessibilitySelectionEnd = forward ? 0 : iterableTextForAccessibility.length();
        }
        int[] iArrFollowing = forward ? iteratorForGranularity.following(accessibilitySelectionEnd) : iteratorForGranularity.preceding(accessibilitySelectionEnd);
        if (iArrFollowing == null) {
            return false;
        }
        int i2 = iArrFollowing[0];
        int i3 = iArrFollowing[1];
        if (extendSelection && isAccessibilitySelectionExtendable(node)) {
            accessibilitySelectionStart = getAccessibilitySelectionStart(node);
            if (accessibilitySelectionStart == -1) {
                accessibilitySelectionStart = forward ? i2 : i3;
            }
            i = forward ? i3 : i2;
        } else {
            accessibilitySelectionStart = forward ? i3 : i2;
            i = accessibilitySelectionStart;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(node, forward ? 256 : 512, granularity, i2, i3, SystemClock.uptimeMillis());
        setAccessibilitySelection(node, accessibilitySelectionStart, i, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int semanticsNodeId) {
        PendingTextTraversedEvent pendingTextTraversedEvent = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent != null) {
            if (semanticsNodeId != pendingTextTraversedEvent.getNode().getId()) {
                return;
            }
            if (SystemClock.uptimeMillis() - pendingTextTraversedEvent.getTraverseTime() <= 1000) {
                AccessibilityEvent accessibilityEventCreateEvent = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent.getNode().getId()), 131072);
                accessibilityEventCreateEvent.setFromIndex(pendingTextTraversedEvent.getFromIndex());
                accessibilityEventCreateEvent.setToIndex(pendingTextTraversedEvent.getToIndex());
                accessibilityEventCreateEvent.setAction(pendingTextTraversedEvent.getAction());
                accessibilityEventCreateEvent.setMovementGranularity(pendingTextTraversedEvent.getGranularity());
                accessibilityEventCreateEvent.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent.getNode()));
                sendEvent(accessibilityEventCreateEvent);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode node, int start, int end, boolean traversalMode) {
        String iterableTextForAccessibility;
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(node)) {
            Function3 function3 = (Function3) ((AccessibilityAction) node.getUnmergedConfig().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(traversalMode))).booleanValue();
            }
            return false;
        }
        if ((start == end && end == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(node)) == null) {
            return false;
        }
        if (start < 0 || start != end || end > iterableTextForAccessibility.length()) {
            start = -1;
        }
        this.accessibilityCursorPosition = start;
        String str = iterableTextForAccessibility;
        boolean z = str.length() > 0;
        sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(node.getId()), z ? Integer.valueOf(this.accessibilityCursorPosition) : null, z ? Integer.valueOf(this.accessibilityCursorPosition) : null, z ? Integer.valueOf(iterableTextForAccessibility.length()) : null, str));
        sendPendingTextTraversedAtGranularityEvent(node.getId());
        return true;
    }

    private final int getAccessibilitySelectionStart(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m8273getStartimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m8268getEndimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode node) {
        return !node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(androidx.compose.ui.semantics.SemanticsNode r6, int r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = r5.getIterableTextForAccessibility(r6)
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto Lb1
            int r2 = r2.length()
            if (r2 != 0) goto L15
            goto Lb1
        L15:
            r2 = 1
            if (r7 == r2) goto L90
            r2 = 2
            if (r7 == r2) goto L71
            r2 = 4
            if (r7 == r2) goto L34
            r3 = 8
            if (r7 == r3) goto L27
            r3 = 16
            if (r7 == r3) goto L34
            return r0
        L27:
            androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator$Companion r6 = androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator.INSTANCE
            androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator r6 = r6.getInstance()
            androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator r6 = (androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator) r6
            r6.initialize(r1)
            goto Lae
        L34:
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r6.getUnmergedConfig()
            androidx.compose.ui.semantics.SemanticsActions r4 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r4.getGetTextLayoutResult()
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L45
            return r0
        L45:
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r6.getUnmergedConfig()
            androidx.compose.ui.text.TextLayoutResult r3 = androidx.compose.ui.platform.SemanticsUtils_androidKt.getTextLayoutResult(r3)
            if (r3 != 0) goto L50
            return r0
        L50:
            if (r7 != r2) goto L61
            androidx.compose.ui.platform.AccessibilityIterators$LineTextSegmentIterator$Companion r6 = androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator.INSTANCE
            androidx.compose.ui.platform.AccessibilityIterators$LineTextSegmentIterator r6 = r6.getInstance()
            androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator r6 = (androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator) r6
            r7 = r6
            androidx.compose.ui.platform.AccessibilityIterators$LineTextSegmentIterator r7 = (androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator) r7
            r7.initialize(r1, r3)
            goto Lae
        L61:
            androidx.compose.ui.platform.AccessibilityIterators$PageTextSegmentIterator$Companion r7 = androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator.INSTANCE
            androidx.compose.ui.platform.AccessibilityIterators$PageTextSegmentIterator r7 = r7.getInstance()
            androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator r7 = (androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator) r7
            r0 = r7
            androidx.compose.ui.platform.AccessibilityIterators$PageTextSegmentIterator r0 = (androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator) r0
            r0.initialize(r1, r3, r6)
            r6 = r7
            goto Lae
        L71:
            androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator$Companion r6 = androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator.INSTANCE
            androidx.compose.ui.platform.AndroidComposeView r7 = r5.view
            android.content.Context r7 = r7.getContext()
            android.content.res.Resources r7 = r7.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            java.util.Locale r7 = r7.locale
            androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator r6 = r6.getInstance(r7)
            androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator r6 = (androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator) r6
            r7 = r6
            androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator r7 = (androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator) r7
            r7.initialize(r1)
            goto Lae
        L90:
            androidx.compose.ui.platform.AccessibilityIterators$CharacterTextSegmentIterator$Companion r6 = androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator.INSTANCE
            androidx.compose.ui.platform.AndroidComposeView r7 = r5.view
            android.content.Context r7 = r7.getContext()
            android.content.res.Resources r7 = r7.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            java.util.Locale r7 = r7.locale
            androidx.compose.ui.platform.AccessibilityIterators$CharacterTextSegmentIterator r6 = r6.getInstance(r7)
            androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator r6 = (androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator) r6
            r7 = r6
            androidx.compose.ui.platform.AccessibilityIterators$CharacterTextSegmentIterator r7 = (androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator) r7
            r7.initialize(r1)
        Lae:
            androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator r6 = (androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator) r6
            return r6
        Lb1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.getIteratorForGranularity(androidx.compose.ui.semantics.SemanticsNode, int):androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator");
    }

    private final String getIterableTextForAccessibility(SemanticsNode node) {
        AnnotatedString annotatedString;
        if (node == null) {
            return null;
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return ListUtilsKt.fastJoinToString$default((List) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getContentDescription()), Constants.SEPARATOR_COMMA, null, null, 0, null, null, 62, null);
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getEditableText());
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "createAccessibilityNodeInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "virtualViewId", "", "performAction", "", "action", "arguments", "Landroid/os/Bundle;", "addExtraDataToAccessibilityNodeInfo", "", "info", "extraDataKey", "", "findFocus", "focus", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {
        public ComposeAccessibilityNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int virtualViewId) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatCreateNodeInfo = AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(virtualViewId);
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            if (androidComposeViewAccessibilityDelegateCompat.sendingFocusAffectingEvent) {
                if (virtualViewId == androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId) {
                    androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI = accessibilityNodeInfoCompatCreateNodeInfo;
                }
                if (virtualViewId == androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId) {
                    androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI = accessibilityNodeInfoCompatCreateNodeInfo;
                }
            }
            return accessibilityNodeInfoCompatCreateNodeInfo;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(virtualViewId, action, arguments);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfoCompat info2, String extraDataKey, Bundle arguments) {
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info2, extraDataKey, arguments);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int focus) {
            if (focus != 1) {
                if (focus == 2) {
                    return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityFocusedVirtualViewId);
                }
                throw new IllegalArgumentException("Unknown focus type: " + focus);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId);
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "<init>", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info2, SemanticsNode semanticsNode) {
            AccessibilityAction accessibilityAction;
            if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) == null) {
                return;
            }
            info2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionSetProgress, accessibilityAction.getLabel()));
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "<init>", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat info2, SemanticsNode semanticsNode) {
            Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (role == null ? false : Role.m8009equalsimpl0(role.getValue(), Role.INSTANCE.m8014getCarouselo7Vup1c())) {
                    return;
                }
                AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                if (accessibilityAction != null) {
                    info2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageUp, accessibilityAction.getLabel()));
                }
                AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown());
                if (accessibilityAction2 != null) {
                    info2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageDown, accessibilityAction2.getLabel()));
                }
                AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                if (accessibilityAction3 != null) {
                    info2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageLeft, accessibilityAction3.getLabel()));
                }
                AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight());
                if (accessibilityAction4 != null) {
                    info2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageRight, accessibilityAction4.getLabel()));
                }
            }
        }
    }
}
