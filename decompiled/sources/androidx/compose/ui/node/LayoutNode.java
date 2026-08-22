package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.tooling.CompositionErrorContext;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.message_correct.element.MessageCorrectExtension;

/* JADX INFO: compiled from: LayoutNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0001\u0018\u0000 £\u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\b¢\u0003£\u0003¤\u0003¥\u0003B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010?\u001a\u00020@H\u0002J\b\u0010G\u001a\u00020@H\u0002J\r\u0010K\u001a\u00020@H\u0000¢\u0006\u0002\bLJ\u001d\u0010M\u001a\u00020@2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020@0OH\u0086\bJ#\u0010P\u001a\u00020@2\u0018\u0010N\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020@0QH\u0086\bJ\u0015\u0010d\u001a\n\u0018\u00010ej\u0004\u0018\u0001`fH\u0017¢\u0006\u0002\u0010gJ\u001d\u0010y\u001a\u00020@2\u0006\u0010z\u001a\u00020\f2\u0006\u0010{\u001a\u00020\u0000H\u0000¢\u0006\u0002\b|J\u0010\u0010}\u001a\u00020~2\u0006\u0010{\u001a\u00020\u0000H\u0002J\u000e\u0010\u007f\u001a\u00020@H\u0000¢\u0006\u0003\b\u0080\u0001J \u0010\u0081\u0001\u001a\u00020@2\u0006\u0010z\u001a\u00020\f2\u0007\u0010\u0082\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\b\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020@H\u0000¢\u0006\u0003\b\u0085\u0001J\u0012\u0010\u0086\u0001\u001a\u00020@2\u0007\u0010\u0087\u0001\u001a\u00020\u0000H\u0002J*\u0010\u0088\u0001\u001a\u00020@2\u0007\u0010\u0089\u0001\u001a\u00020\f2\u0007\u0010\u008a\u0001\u001a\u00020\f2\u0007\u0010\u0082\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\b\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020\nH\u0016J\u000f\u0010\u0090\u0001\u001a\u00020@H\u0000¢\u0006\u0003\b\u0091\u0001J\u000f\u0010\u0092\u0001\u001a\u00020@H\u0000¢\u0006\u0003\b\u0093\u0001J\n\u0010\u009a\u0001\u001a\u00030\u0095\u0001H\u0002J\u0017\u0010\u009b\u0001\u001a\u00020@2\u0006\u0010Y\u001a\u00020XH\u0000¢\u0006\u0003\b\u009c\u0001J\u000f\u0010\u009d\u0001\u001a\u00020@H\u0000¢\u0006\u0003\b\u009e\u0001J\t\u0010¦\u0001\u001a\u00020~H\u0016J\u0013\u0010©\u0001\u001a\u00020~2\b\b\u0002\u0010i\u001a\u00020\fH\u0002J\n\u0010²\u0001\u001a\u00030±\u0001H\u0002J\u0010\u0010³\u0001\u001a\u00020\f2\u0007\u0010´\u0001\u001a\u00020\fJ\u0010\u0010µ\u0001\u001a\u00020\f2\u0007\u0010¶\u0001\u001a\u00020\fJ\u0010\u0010·\u0001\u001a\u00020\f2\u0007\u0010´\u0001\u001a\u00020\fJ\u0010\u0010¸\u0001\u001a\u00020\f2\u0007\u0010¶\u0001\u001a\u00020\fJ\u0010\u0010¹\u0001\u001a\u00020\f2\u0007\u0010´\u0001\u001a\u00020\fJ\u0010\u0010º\u0001\u001a\u00020\f2\u0007\u0010¶\u0001\u001a\u00020\fJ\u0010\u0010»\u0001\u001a\u00020\f2\u0007\u0010´\u0001\u001a\u00020\fJ\u0010\u0010¼\u0001\u001a\u00020\f2\u0007\u0010¶\u0001\u001a\u00020\fJ\u0012\u0010Ù\u0001\u001a\u00030Ú\u00012\b\u0010Û\u0001\u001a\u00030Ü\u0001J\t\u0010Ý\u0001\u001a\u00020@H\u0002J\u000f\u0010\u0097\u0002\u001a\u00020@H\u0000¢\u0006\u0003\b\u0098\u0002J\u0013\u0010£\u0002\u001a\u00020@2\b\u0010\u009e\u0002\u001a\u00030\u009a\u0002H\u0002J\t\u0010¤\u0002\u001a\u00020@H\u0002J\u000f\u0010¥\u0002\u001a\u00020@H\u0000¢\u0006\u0003\b¦\u0002J!\u0010¹\u0002\u001a\u00020@2\u0007\u0010º\u0002\u001a\u00020\f2\u0007\u0010»\u0002\u001a\u00020\fH\u0000¢\u0006\u0003\b¼\u0002J\u000f\u0010½\u0002\u001a\u00020@H\u0000¢\u0006\u0003\b¾\u0002J\u000f\u0010¿\u0002\u001a\u00020@H\u0000¢\u0006\u0003\bÀ\u0002J%\u0010Á\u0002\u001a\u00020@2\b\u0010Â\u0002\u001a\u00030Ã\u00022\n\u0010Ä\u0002\u001a\u0005\u0018\u00010Å\u0002H\u0000¢\u0006\u0003\bÆ\u0002J=\u0010Ç\u0002\u001a\u00020@2\b\u0010È\u0002\u001a\u00030É\u00022\b\u0010Ê\u0002\u001a\u00030Ë\u00022\n\b\u0002\u0010Ì\u0002\u001a\u00030Í\u00022\t\b\u0002\u0010Î\u0002\u001a\u00020\nH\u0000¢\u0006\u0006\bÏ\u0002\u0010Ð\u0002J=\u0010Ñ\u0002\u001a\u00020@2\b\u0010È\u0002\u001a\u00030É\u00022\b\u0010Ò\u0002\u001a\u00030Ë\u00022\n\b\u0002\u0010Ì\u0002\u001a\u00030Í\u00022\t\b\u0002\u0010Î\u0002\u001a\u00020\nH\u0000¢\u0006\u0006\bÓ\u0002\u0010Ð\u0002J\u0018\u0010Ô\u0002\u001a\u00020@2\u0007\u0010Õ\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\bÖ\u0002J0\u0010×\u0002\u001a\u00020@2\t\b\u0002\u0010Ø\u0002\u001a\u00020\n2\t\b\u0002\u0010Ù\u0002\u001a\u00020\n2\t\b\u0002\u0010Ú\u0002\u001a\u00020\nH\u0000¢\u0006\u0003\bÛ\u0002J0\u0010Ü\u0002\u001a\u00020@2\t\b\u0002\u0010Ø\u0002\u001a\u00020\n2\t\b\u0002\u0010Ù\u0002\u001a\u00020\n2\t\b\u0002\u0010Ú\u0002\u001a\u00020\nH\u0000¢\u0006\u0003\bÝ\u0002J\u000f\u0010Þ\u0002\u001a\u00020@H\u0000¢\u0006\u0003\bß\u0002J\u000f\u0010à\u0002\u001a\u00020@H\u0000¢\u0006\u0003\bá\u0002J\u0019\u0010â\u0002\u001a\u00020@2\b\u0010ã\u0002\u001a\u00030þ\u0001H\u0000¢\u0006\u0003\bä\u0002J*\u0010x\u001a\u0003Hå\u0002\"\u0005\b\u0000\u0010å\u00022\u000e\u0010N\u001a\n\u0012\u0005\u0012\u0003Hå\u00020æ\u0002H\u0080\b¢\u0006\u0006\bç\u0002\u0010è\u0002J\u001a\u0010é\u0002\u001a\u00020@2\t\b\u0002\u0010Ø\u0002\u001a\u00020\nH\u0000¢\u0006\u0003\bê\u0002J\u001a\u0010ë\u0002\u001a\u00020@2\t\b\u0002\u0010Ø\u0002\u001a\u00020\nH\u0000¢\u0006\u0003\bì\u0002J\u000f\u0010í\u0002\u001a\u00020@H\u0000¢\u0006\u0003\bî\u0002J\u0010\u0010ï\u0002\u001a\t\u0012\u0005\u0012\u00030ð\u00020:H\u0016J\u000f\u0010ñ\u0002\u001a\u00020@H\u0000¢\u0006\u0003\bò\u0002J\u001d\u0010ó\u0002\u001a\u00020\n2\f\b\u0002\u0010ô\u0002\u001a\u0005\u0018\u00010õ\u0002H\u0000¢\u0006\u0003\bö\u0002J\u001d\u0010÷\u0002\u001a\u00020\n2\f\b\u0002\u0010ô\u0002\u001a\u0005\u0018\u00010õ\u0002H\u0000¢\u0006\u0003\bø\u0002J\u000f\u0010\u0081\u0003\u001a\u00020@H\u0000¢\u0006\u0003\b\u0082\u0003J\u000f\u0010\u0083\u0003\u001a\u00020@H\u0000¢\u0006\u0003\b\u0084\u0003J\u000f\u0010\u0085\u0003\u001a\u00020@H\u0000¢\u0006\u0003\b\u0086\u0003J\u0012\u0010\u0087\u0003\u001a\u00020@2\t\b\u0002\u0010\u0088\u0003\u001a\u00020\nJ\u0007\u0010\u0089\u0003\u001a\u00020@J\u0012\u0010\u008a\u0003\u001a\u00020@2\t\b\u0002\u0010\u0088\u0003\u001a\u00020\nJ\u000f\u0010\u008b\u0003\u001a\u00020@H\u0000¢\u0006\u0003\b\u008c\u0003J\t\u0010\u008d\u0003\u001a\u00020@H\u0016J\t\u0010\u008e\u0003\u001a\u00020@H\u0016J%\u0010\u008f\u0003\u001a\u00020@2\u0013\u0010N\u001a\u000f\u0012\u0005\u0012\u00030\u0090\u0003\u0012\u0004\u0012\u00020@0OH\u0080\b¢\u0006\u0003\b\u0091\u0003J%\u0010\u0092\u0003\u001a\u00020@2\u0013\u0010N\u001a\u000f\u0012\u0005\u0012\u00030þ\u0001\u0012\u0004\u0012\u00020@0OH\u0080\b¢\u0006\u0003\b\u0093\u0003J\u000f\u0010\u0094\u0003\u001a\u00020@H\u0000¢\u0006\u0003\b\u0095\u0003J\t\u0010\u0096\u0003\u001a\u00020@H\u0002J\u000f\u0010\u0097\u0003\u001a\u00020@H\u0000¢\u0006\u0003\b\u0098\u0003J\t\u0010\u009f\u0003\u001a\u00020@H\u0016J\t\u0010 \u0003\u001a\u00020@H\u0016J\t\u0010¡\u0003\u001a\u00020@H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u0019X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\"\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001a\u0010%\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001a\u0010(\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R\u001a\u0010+\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R(\u0010/\u001a\u0004\u0018\u00010\u00002\b\u0010.\u001a\u0004\u0018\u00010\u0000@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u000008X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u00000:8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020B0:8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bC\u0010<R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020B0:8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bE\u0010<R\u000e\u0010F\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000>8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00000:8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bS\u0010<R\u0010\u0010T\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010U\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bV\u00101R\"\u0010Y\u001a\u0004\u0018\u00010X2\b\u0010W\u001a\u0004\u0018\u00010X@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R$\u0010\\\u001a\n\u0018\u00010]j\u0004\u0018\u0001`^X\u0080\u000e¢\u0006\u0010\n\u0002\u0010c\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0014\u0010h\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\u0015R\u001a\u0010i\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0010\"\u0004\bk\u0010\u0012R\u0014\u0010l\u001a\u00020m8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0016\u0010p\u001a\u0004\u0018\u00010q8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u0014\u0010t\u001a\u00020u8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u000e\u0010x\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008d\u0001\u001a\u00020\nX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u0015\"\u0005\b\u008f\u0001\u0010\u0017R\u0012\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u000f\u0010\u0099\u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010 \u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000>8@X\u0081\u0004¢\u0006\u000f\u0012\u0006\b¢\u0001\u0010£\u0001\u001a\u0005\b¤\u0001\u0010JR\u0016\u0010¥\u0001\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010\u0015R\u0016\u0010§\u0001\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010\u0015R+\u0010«\u0001\u001a\u00030ª\u00012\u0007\u0010W\u001a\u00030ª\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R\u0012\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010¾\u0001\u001a\u00030½\u00012\u0007\u0010W\u001a\u00030½\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R+\u0010Ä\u0001\u001a\u00030Ã\u00012\u0007\u0010W\u001a\u00030Ã\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R+\u0010Ê\u0001\u001a\u00030É\u00012\u0007\u0010W\u001a\u00030É\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R+\u0010Ð\u0001\u001a\u00030Ï\u00012\u0007\u0010W\u001a\u00030Ï\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R\u001a\u0010Õ\u0001\u001a\u0005\u0018\u00010Ö\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b×\u0001\u0010Ø\u0001R\u0016\u0010¶\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÞ\u0001\u0010\u0010R\u0016\u0010´\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bß\u0001\u0010\u0010R\u0016\u0010à\u0001\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bá\u0001\u0010\u0015R\u0018\u0010â\u0001\u001a\u00030ã\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bä\u0001\u0010å\u0001R\u0016\u0010æ\u0001\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bæ\u0001\u0010\u0015R\u0013\u0010ç\u0001\u001a\u00020\n8F¢\u0006\u0007\u001a\u0005\bç\u0001\u0010\u0015R\u0016\u0010è\u0001\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bé\u0001\u0010\u0010R\u0018\u0010ê\u0001\u001a\u00030ë\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bì\u0001\u0010í\u0001R\u0018\u0010î\u0001\u001a\u00030ë\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bï\u0001\u0010í\u0001R \u0010ð\u0001\u001a\u00030ë\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bñ\u0001\u0010í\u0001\"\u0006\bò\u0001\u0010ó\u0001R\u0010\u0010ô\u0001\u001a\u00030ë\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010õ\u0001\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0000\u0012\u0006\bö\u0001\u0010£\u0001\u001a\u0005\b÷\u0001\u0010\u0015\"\u0005\bø\u0001\u0010\u0017R\u0018\u0010ù\u0001\u001a\u00030ú\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\bû\u0001\u0010ü\u0001R\u0018\u0010ý\u0001\u001a\u00030þ\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bÿ\u0001\u0010\u0080\u0002R\u0018\u0010\u0081\u0002\u001a\u00030\u0082\u0002X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0018\u0010\u0085\u0002\u001a\u00030þ\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0086\u0002\u0010\u0080\u0002R\u0018\u0010\u0087\u0002\u001a\u00030\u0088\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002R\"\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u008c\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0002\u0010\u008e\u0002\"\u0006\b\u008f\u0002\u0010\u0090\u0002R\u0012\u0010\u0091\u0002\u001a\u0005\u0018\u00010þ\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0092\u0002\u001a\u00020\nX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0002\u0010\u0015\"\u0005\b\u0094\u0002\u0010\u0017R\u001a\u0010\u0095\u0002\u001a\u0005\u0018\u00010þ\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0096\u0002\u0010\u0080\u0002R\u0010\u0010\u0099\u0002\u001a\u00030\u009a\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u009a\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u009c\u0002\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u009d\u0002\u0010\u0015R+\u0010\u009e\u0002\u001a\u00030\u009a\u00022\u0007\u0010W\u001a\u00030\u009a\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u009f\u0002\u0010 \u0002\"\u0006\b¡\u0002\u0010¢\u0002R\u0018\u0010§\u0002\u001a\u00030¨\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b©\u0002\u0010ª\u0002R-\u0010«\u0002\u001a\u0010\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020@\u0018\u00010OX\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0002\u0010\u00ad\u0002\"\u0006\b®\u0002\u0010¯\u0002R-\u0010°\u0002\u001a\u0010\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020@\u0018\u00010OX\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b±\u0002\u0010\u00ad\u0002\"\u0006\b²\u0002\u0010¯\u0002R\u001d\u0010³\u0002\u001a\u00020\nX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0002\u0010\u0015\"\u0005\bµ\u0002\u0010\u0017R'\u0010¶\u0002\u001a\u00020\f2\u0006\u0010W\u001a\u00020\f@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0002\u0010\u0010\"\u0005\b¸\u0002\u0010\u0012R\u0016\u0010ù\u0002\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bú\u0002\u0010\u0015R\u0016\u0010û\u0002\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bü\u0002\u0010\u0015R\u0016\u0010ý\u0002\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bþ\u0002\u0010\u0015R\u0016\u0010ÿ\u0002\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0003\u0010\u0015R\u0019\u0010\u0099\u0003\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009a\u0003\u0010\u009b\u0003R\u001c\u0010\u009c\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050:8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009d\u0003\u0010<R \u0010\u009e\u0003\u001a\u00020\n2\u0006\u0010W\u001a\u00020\n@RX\u0096\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u009e\u0003\u0010\u0015¨\u0006¦\u0003"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/semantics/SemanticsInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/InteroperableComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "<init>", "(ZI)V", "getSemanticsId", "()I", "setSemanticsId", "(I)V", "hasPositionalLayerTransformationsInOffsetFromRoot", "getHasPositionalLayerTransformationsInOffsetFromRoot$ui", "()Z", "setHasPositionalLayerTransformationsInOffsetFromRoot$ui", "(Z)V", "outerToInnerOffset", "Landroidx/compose/ui/unit/IntOffset;", "getOuterToInnerOffset-nOcc-ac$ui", "()J", "setOuterToInnerOffset--gyyYBs$ui", "(J)V", "J", "outerToInnerOffsetDirty", "getOuterToInnerOffsetDirty$ui", "setOuterToInnerOffsetDirty$ui", "rectInParentDirty", "getRectInParentDirty$ui", "setRectInParentDirty$ui", "addedToRectList", "getAddedToRectList$ui", "setAddedToRectList$ui", "compositeKeyHash", "getCompositeKeyHash", "setCompositeKeyHash", "isVirtualLookaheadRoot", "isVirtualLookaheadRoot$ui", "setVirtualLookaheadRoot$ui", "newRoot", "lookaheadRoot", "getLookaheadRoot$ui", "()Landroidx/compose/ui/node/LayoutNode;", "setLookaheadRoot", "(Landroidx/compose/ui/node/LayoutNode;)V", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "virtualChildrenCount", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "foldedChildren", "", "getFoldedChildren$ui", "()Ljava/util/List;", "_unfoldedChildren", "Landroidx/compose/runtime/collection/MutableVector;", "recreateUnfoldedChildrenIfDirty", "", "childMeasurables", "Landroidx/compose/ui/layout/Measurable;", "getChildMeasurables$ui", "childLookaheadMeasurables", "getChildLookaheadMeasurables$ui", "unfoldedVirtualChildrenListDirty", "invalidateUnfoldedVirtualChildren", "_children", "get_children$ui", "()Landroidx/compose/runtime/collection/MutableVector;", "updateChildrenIfDirty", "updateChildrenIfDirty$ui", "forEachChild", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "forEachChildIndexed", "Lkotlin/Function2;", "children", "getChildren$ui", "_foldedParent", Message.Thread.PARENT_ATTRIBUTE_NAME, "getParent$ui", "value", "Landroidx/compose/ui/node/Owner;", "owner", "getOwner$ui", "()Landroidx/compose/ui/node/Owner;", "interopViewFactoryHolder", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/viewinterop/InteropViewFactoryHolder;", "getInteropViewFactoryHolder$ui", "()Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "setInteropViewFactoryHolder$ui", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "getInteropView", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "()Landroid/view/View;", "isAttached", "depth", "getDepth$ui", "setDepth$ui", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LookaheadPassDelegate;", "getLookaheadPassDelegate$ui", "()Landroidx/compose/ui/node/LookaheadPassDelegate;", "measurePassDelegate", "Landroidx/compose/ui/node/MeasurePassDelegate;", "getMeasurePassDelegate$ui", "()Landroidx/compose/ui/node/MeasurePassDelegate;", "ignoreRemeasureRequests", "insertAt", FirebaseAnalytics.Param.INDEX, "instance", "insertAt$ui", "exceptionMessageForParentingOrOwnership", "", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui", "removeAt", "count", "removeAt$ui", "removeAll", "removeAll$ui", "onChildRemoved", "child", "move", "from", "to", "move$ui", "isTransparent", "isSemanticsInvalidated", "isSemanticsInvalidated$ui", "setSemanticsInvalidated$ui", "requestAutofill", "requestAutofill$ui", "invalidateSemantics", "invalidateSemantics$ui", "_semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "semanticsConfiguration", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "isCurrentlyCalculatingSemanticsConfiguration", "calculateSemanticsConfiguration", "attach", "attach$ui", "detach", "detach$ui", "_zSortedChildren", "zSortedChildrenInvalidated", "zSortedChildren", "getZSortedChildren$annotations", "()V", "getZSortedChildren", "isValidOwnerScope", InAppPurchaseConstants.METHOD_TO_STRING, "hasFixedInnerContentConstraints", "getHasFixedInnerContentConstraints$ui", "debugTreeToString", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getOrCreateIntrinsicsPolicy", "minLookaheadIntrinsicWidth", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "minLookaheadIntrinsicHeight", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "maxLookaheadIntrinsicWidth", "maxLookaheadIntrinsicHeight", "minIntrinsicWidth", "minIntrinsicHeight", "maxIntrinsicWidth", "maxIntrinsicHeight", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "Landroidx/compose/runtime/CompositionLocalMap;", "compositionLocalMap", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "traceContext", "Landroidx/compose/runtime/tooling/CompositionErrorContext;", "getTraceContext", "()Landroidx/compose/runtime/tooling/CompositionErrorContext;", "rethrowWithComposeStackTrace", "", "e", "", "onDensityOrLayoutDirectionChanged", "getWidth", "getHeight", "alignmentLinesRequired", "getAlignmentLinesRequired$ui", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "isPlaced", "isPlacedByParent", "placeOrder", "getPlaceOrder$ui", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui", "intrinsicsUsageByParent", "getIntrinsicsUsageByParent$ui", "setIntrinsicsUsageByParent$ui", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "previousIntrinsicsUsageByParent", "canMultiMeasure", "getCanMultiMeasure$ui$annotations", "getCanMultiMeasure$ui", "setCanMultiMeasure$ui", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui", "()Landroidx/compose/ui/node/NodeChain;", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator$ui", "()Landroidx/compose/ui/node/NodeCoordinator;", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "outerCoordinator", "getOuterCoordinator$ui", "zIndex", "", "getZIndex", "()F", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "_innerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui", "setInnerLayerCoordinatorIsDirty$ui", "innerLayerCoordinator", "getInnerLayerCoordinator$ui", "invalidateLayer", "invalidateLayer$ui", "_modifier", "Landroidx/compose/ui/Modifier;", "pendingModifier", "applyingModifierOnAttach", "getApplyingModifierOnAttach$ui", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "applyModifier", "resetModifierState", "invalidateParentData", "invalidateParentData$ui", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "onAttach", "getOnAttach$ui", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui", "setOnDetach$ui", "needsOnGloballyPositionedDispatch", "getNeedsOnGloballyPositionedDispatch$ui", "setNeedsOnGloballyPositionedDispatch$ui", "globallyPositionedObservers", "getGloballyPositionedObservers", "setGloballyPositionedObservers", "place", "x", "y", "place$ui", MessageCorrectExtension.ELEMENT, "replace$ui", "lookaheadReplace", "lookaheadReplace$ui", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw$ui", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "hitTest-6fMxITs$ui", "(JLandroidx/compose/ui/node/HitTestResult;IZ)V", "hitTestSemantics", "hitSemanticsEntities", "hitTestSemantics-6fMxITs$ui", "rescheduleRemeasureOrRelayout", "it", "rescheduleRemeasureOrRelayout$ui", "requestRemeasure", "forceRequest", "scheduleMeasureAndLayout", "invalidateIntrinsics", "requestRemeasure$ui", "requestLookaheadRemeasure", "requestLookaheadRemeasure$ui", "invalidateMeasurements", "invalidateMeasurements$ui", "invalidateOnPositioned", "invalidateOnPositioned$ui", "onCoordinatorRectChanged", "coordinator", "onCoordinatorRectChanged$ui", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "ignoreRemeasureRequests$ui", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "requestRelayout", "requestRelayout$ui", "requestLookaheadRelayout", "requestLookaheadRelayout$ui", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "invalidateLayers", "invalidateLayers$ui", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui", "remeasure", "remeasure-_Sx5XlM$ui", "measurePending", "getMeasurePending$ui", "layoutPending", "getLayoutPending$ui", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui", "markLayoutPending", "markLayoutPending$ui", "markMeasurePending", "markMeasurePending$ui", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui", "invalidateSubtree", "isRootOfInvalidation", "invalidateMeasurementForSubtree", "invalidateDrawForSubtree", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui", "forceRemeasure", "onLayoutComplete", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinator$ui", "forEachCoordinatorIncludingInner", "forEachCoordinatorIncludingInner$ui", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui", "clearSubtreePlacementIntrinsicsUsage", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/semantics/SemanticsInfo;", "childrenInfo", "getChildrenInfo", "isDeactivated", "onReuse", "onDeactivate", "onRelease", "NoIntrinsicsMeasurePolicy", "Companion", "LayoutState", "UsageByParent", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, OwnerScope, LayoutInfo, SemanticsInfo, ComposeUiNode, InteroperableComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;
    private LayoutNode _foldedParent;
    private NodeCoordinator _innerLayerCoordinator;
    private Modifier _modifier;
    private SemanticsConfiguration _semanticsConfiguration;
    private MutableVector<LayoutNode> _unfoldedChildren;
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean addedToRectList;
    private boolean canMultiMeasure;
    private int compositeKeyHash;
    private CompositionLocalMap compositionLocalMap;
    private Density density;
    private int depth;
    private int globallyPositionedObservers;
    private boolean hasPositionalLayerTransformationsInOffsetFromRoot;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    private AndroidViewHolder interopViewFactoryHolder;
    private IntrinsicsPolicy intrinsicsPolicy;
    private UsageByParent intrinsicsUsageByParent;
    private boolean isCurrentlyCalculatingSemanticsConfiguration;
    private boolean isDeactivated;
    private boolean isSemanticsInvalidated;
    private final boolean isVirtual;
    private boolean isVirtualLookaheadRoot;
    private final LayoutNodeLayoutDelegate layoutDelegate;
    private LayoutDirection layoutDirection;
    private LayoutNode lookaheadRoot;
    private MeasurePolicy measurePolicy;
    private boolean needsOnGloballyPositionedDispatch;
    private final NodeChain nodes;
    private Function1<? super Owner, Unit> onAttach;
    private Function1<? super Owner, Unit> onDetach;
    private long outerToInnerOffset;
    private boolean outerToInnerOffsetDirty;
    private Owner owner;
    private Modifier pendingModifier;
    private UsageByParent previousIntrinsicsUsageByParent;
    private boolean rectInParentDirty;
    private int semanticsId;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private boolean zSortedChildrenInvalidated;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new NoIntrinsicsMeasurePolicy() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1
        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* JADX INFO: renamed from: measure-3p2s80s */
        public /* bridge */ /* synthetic */ MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List list, long j) {
            return (MeasureResult) m7679measure3p2s80s(measureScope, (List<? extends Measurable>) list, j);
        }

        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
        public Void m7679measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
            throw new IllegalStateException("Undefined measure and it is required".toString());
        }
    };
    private static final Function0<LayoutNode> Constructor = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.LayoutNode$Companion$Constructor$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutNode invoke() {
            return new LayoutNode(false, 0 == true ? 1 : 0, 3, null);
        }
    };
    private static final ViewConfiguration DummyViewConfiguration = new ViewConfiguration() { // from class: androidx.compose.ui.node.LayoutNode$Companion$DummyViewConfiguration$1
        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapMinTimeMillis() {
            return 40L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapTimeoutMillis() {
            return 300L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getLongPressTimeoutMillis() {
            return 400L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public float getTouchSlop() {
            return 16.0f;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public long mo7678getMinimumTouchTargetSizeMYxV2XQ() {
            return DpSize.INSTANCE.m8938getZeroMYxV2XQ();
        }
    };
    private static final Comparator<LayoutNode> ZComparator = new Comparator() { // from class: androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return LayoutNode.ZComparator$lambda$0((LayoutNode) obj, (LayoutNode) obj2);
        }
    };

    /* JADX INFO: compiled from: LayoutNode.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNode() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui$annotations() {
    }

    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public LayoutNode(boolean z, int i) {
        this.isVirtual = z;
        this.semanticsId = i;
        this.outerToInnerOffset = IntOffset.INSTANCE.m8968getMaxnOccac();
        this.outerToInnerOffsetDirty = true;
        this.rectInParentDirty = true;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16], 0), new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$_foldedChildren$1
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
                this.this$0.getLayoutDelegate().markChildrenDirty();
            }
        });
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.density = LayoutNodeKt.DefaultDensity;
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.compositionLocalMap = CompositionLocalMap.INSTANCE.getEmpty();
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        this.previousIntrinsicsUsageByParent = UsageByParent.NotUsed;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this._modifier = Modifier.INSTANCE;
    }

    public /* synthetic */ LayoutNode(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? SemanticsModifierKt.generateSemanticsId() : i);
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getSemanticsId() {
        return this.semanticsId;
    }

    public void setSemanticsId(int i) {
        this.semanticsId = i;
    }

    /* JADX INFO: renamed from: getHasPositionalLayerTransformationsInOffsetFromRoot$ui, reason: from getter */
    public final boolean getHasPositionalLayerTransformationsInOffsetFromRoot() {
        return this.hasPositionalLayerTransformationsInOffsetFromRoot;
    }

    public final void setHasPositionalLayerTransformationsInOffsetFromRoot$ui(boolean z) {
        this.hasPositionalLayerTransformationsInOffsetFromRoot = z;
    }

    /* JADX INFO: renamed from: getOuterToInnerOffset-nOcc-ac$ui, reason: not valid java name and from getter */
    public final long getOuterToInnerOffset() {
        return this.outerToInnerOffset;
    }

    /* JADX INFO: renamed from: setOuterToInnerOffset--gyyYBs$ui, reason: not valid java name */
    public final void m7677setOuterToInnerOffsetgyyYBs$ui(long j) {
        this.outerToInnerOffset = j;
    }

    /* JADX INFO: renamed from: getOuterToInnerOffsetDirty$ui, reason: from getter */
    public final boolean getOuterToInnerOffsetDirty() {
        return this.outerToInnerOffsetDirty;
    }

    public final void setOuterToInnerOffsetDirty$ui(boolean z) {
        this.outerToInnerOffsetDirty = z;
    }

    /* JADX INFO: renamed from: getRectInParentDirty$ui, reason: from getter */
    public final boolean getRectInParentDirty() {
        return this.rectInParentDirty;
    }

    public final void setRectInParentDirty$ui(boolean z) {
        this.rectInParentDirty = z;
    }

    /* JADX INFO: renamed from: getAddedToRectList$ui, reason: from getter */
    public final boolean getAddedToRectList() {
        return this.addedToRectList;
    }

    public final void setAddedToRectList$ui(boolean z) {
        this.addedToRectList = z;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public int getCompositeKeyHash() {
        return this.compositeKeyHash;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setCompositeKeyHash(int i) {
        this.compositeKeyHash = i;
    }

    /* JADX INFO: renamed from: isVirtualLookaheadRoot$ui, reason: from getter */
    public final boolean getIsVirtualLookaheadRoot() {
        return this.isVirtualLookaheadRoot;
    }

    public final void setVirtualLookaheadRoot$ui(boolean z) {
        this.isVirtualLookaheadRoot = z;
    }

    /* JADX INFO: renamed from: getLookaheadRoot$ui, reason: from getter */
    public final LayoutNode getLookaheadRoot() {
        return this.lookaheadRoot;
    }

    private final void setLookaheadRoot(LayoutNode layoutNode) {
        if (Intrinsics.areEqual(layoutNode, this.lookaheadRoot)) {
            return;
        }
        this.lookaheadRoot = layoutNode;
        if (layoutNode != null) {
            this.layoutDelegate.ensureLookaheadDelegateCreated$ui();
            NodeCoordinator wrapped = getInnerCoordinator$ui().getWrapped();
            for (NodeCoordinator outerCoordinator$ui = getOuterCoordinator$ui(); !Intrinsics.areEqual(outerCoordinator$ui, wrapped) && outerCoordinator$ui != null; outerCoordinator$ui = outerCoordinator$ui.getWrapped()) {
                outerCoordinator$ui.ensureLookaheadDelegateCreated();
            }
        } else {
            this.layoutDelegate.onRemovedFromLookaheadScope();
        }
        invalidateMeasurements$ui();
    }

    public final Boolean isPlacedInLookahead() {
        LookaheadPassDelegate lookaheadPassDelegate$ui = getLookaheadPassDelegate$ui();
        if (lookaheadPassDelegate$ui != null) {
            return Boolean.valueOf(lookaheadPassDelegate$ui.isPlaced$ui());
        }
        return null;
    }

    public final List<LayoutNode> getFoldedChildren$ui() {
        return this._foldedChildren.getVector().asMutableList();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                mutableVector = new MutableVector<>(new LayoutNode[16], 0);
                this._unfoldedChildren = mutableVector;
            }
            mutableVector.clear();
            MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
            LayoutNode[] layoutNodeArr = vector.content;
            int size = vector.getSize();
            for (int i = 0; i < size; i++) {
                LayoutNode layoutNode = layoutNodeArr[i];
                if (!layoutNode.isVirtual) {
                    mutableVector.add(layoutNode);
                } else {
                    mutableVector.addAll(mutableVector.getSize(), layoutNode.get_children$ui());
                }
            }
            this.layoutDelegate.markChildrenDirty();
        }
    }

    public final List<Measurable> getChildMeasurables$ui() {
        return getMeasurePassDelegate$ui().getChildDelegates$ui();
    }

    public final List<Measurable> getChildLookaheadMeasurables$ui() {
        LookaheadPassDelegate lookaheadPassDelegate$ui = getLookaheadPassDelegate$ui();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui);
        return lookaheadPassDelegate$ui.getChildDelegates$ui();
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode layoutNode;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (!this.isVirtual || (layoutNode = this._foldedParent) == null) {
            return;
        }
        layoutNode.invalidateUnfoldedVirtualChildren();
    }

    public final MutableVector<LayoutNode> get_children$ui() {
        updateChildrenIfDirty$ui();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    public final void updateChildrenIfDirty$ui() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }

    public final void forEachChild(Function1<? super LayoutNode, Unit> block) {
        MutableVector<LayoutNode> mutableVector = get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            block.invoke(layoutNodeArr[i]);
        }
    }

    public final void forEachChildIndexed(Function2<? super Integer, ? super LayoutNode, Unit> block) {
        MutableVector<LayoutNode> mutableVector = get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            block.invoke(Integer.valueOf(i), layoutNodeArr[i]);
        }
    }

    public final List<LayoutNode> getChildren$ui() {
        return get_children$ui().asMutableList();
    }

    public final LayoutNode getParent$ui() {
        LayoutNode layoutNode = this._foldedParent;
        while (layoutNode != null && layoutNode.isVirtual) {
            layoutNode = layoutNode._foldedParent;
        }
        return layoutNode;
    }

    /* JADX INFO: renamed from: getOwner$ui, reason: from getter */
    public final Owner getOwner() {
        return this.owner;
    }

    /* JADX INFO: renamed from: getInteropViewFactoryHolder$ui, reason: from getter */
    public final AndroidViewHolder getInteropViewFactoryHolder() {
        return this.interopViewFactoryHolder;
    }

    public final void setInteropViewFactoryHolder$ui(AndroidViewHolder androidViewHolder) {
        this.interopViewFactoryHolder = androidViewHolder;
    }

    @Override // androidx.compose.ui.node.InteroperableComposeUiNode
    public View getInteropView() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            return androidViewHolder.getInteropView();
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isAttached() {
        return this.owner != null;
    }

    /* JADX INFO: renamed from: getDepth$ui, reason: from getter */
    public final int getDepth() {
        return this.depth;
    }

    public final void setDepth$ui(int i) {
        this.depth = i;
    }

    public final LayoutState getLayoutState$ui() {
        return this.layoutDelegate.getLayoutState();
    }

    public final LookaheadPassDelegate getLookaheadPassDelegate$ui() {
        return this.layoutDelegate.getLookaheadPassDelegate();
    }

    public final MeasurePassDelegate getMeasurePassDelegate$ui() {
        return this.layoutDelegate.getMeasurePassDelegate();
    }

    public final void insertAt$ui(int index, LayoutNode instance) {
        if (!(instance._foldedParent == null || instance.owner == null)) {
            InlineClassHelperKt.throwIllegalStateException(exceptionMessageForParentingOrOwnership(instance));
        }
        instance._foldedParent = this;
        this._foldedChildren.add(index, instance);
        onZSortedChildrenInvalidated$ui();
        if (instance.isVirtual) {
            this.virtualChildrenCount++;
        }
        invalidateUnfoldedVirtualChildren();
        Owner owner = this.owner;
        if (owner != null) {
            instance.attach$ui(owner);
        }
        if (instance.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() + 1);
        }
        if (instance.globallyPositionedObservers > 0) {
            setGloballyPositionedObservers(this.globallyPositionedObservers + 1);
        }
    }

    private final String exceptionMessageForParentingOrOwnership(LayoutNode instance) {
        StringBuilder sbAppend = new StringBuilder("Cannot insert ").append(instance).append(" because it already has a parent or an owner. This tree: ").append(debugTreeToString$default(this, 0, 1, null)).append(" Other tree: ");
        LayoutNode layoutNode = instance._foldedParent;
        return sbAppend.append(layoutNode != null ? debugTreeToString$default(layoutNode, 0, 1, null) : null).toString();
    }

    public final void onZSortedChildrenInvalidated$ui() {
        if (this.isVirtual) {
            LayoutNode parent$ui = getParent$ui();
            if (parent$ui != null) {
                parent$ui.onZSortedChildrenInvalidated$ui();
                return;
            }
            return;
        }
        this.zSortedChildrenInvalidated = true;
    }

    public final void removeAt$ui(int index, int count) {
        if (!(count >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("count (" + count + ") must be greater than 0");
        }
        int i = (count + index) - 1;
        if (index > i) {
            return;
        }
        while (true) {
            onChildRemoved(this._foldedChildren.getVector().content[i]);
            this._foldedChildren.removeAt(i);
            if (i == index) {
                return;
            } else {
                i--;
            }
        }
    }

    public final void removeAll$ui() {
        int size = this._foldedChildren.getVector().getSize();
        while (true) {
            size--;
            if (-1 < size) {
                onChildRemoved(this._foldedChildren.getVector().content[size]);
            } else {
                this._foldedChildren.clear();
                return;
            }
        }
    }

    private final void onChildRemoved(LayoutNode child) {
        if (child.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            this.layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(r0.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }
        if (this.owner != null) {
            child.detach$ui();
        }
        child._foldedParent = null;
        if (child.globallyPositionedObservers > 0) {
            setGloballyPositionedObservers(this.globallyPositionedObservers - 1);
        }
        child.getOuterCoordinator$ui().setWrappedBy$ui(null);
        if (child.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector<LayoutNode> vector = child._foldedChildren.getVector();
            LayoutNode[] layoutNodeArr = vector.content;
            int size = vector.getSize();
            for (int i = 0; i < size; i++) {
                layoutNodeArr[i].getOuterCoordinator$ui().setWrappedBy$ui(null);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui();
    }

    public final void move$ui(int from, int to, int count) {
        if (from == to) {
            return;
        }
        for (int i = 0; i < count; i++) {
            this._foldedChildren.add(from > to ? to + i : (to + count) - 2, this._foldedChildren.removeAt(from > to ? from + i : from));
        }
        onZSortedChildrenInvalidated$ui();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui();
    }

    @Override // androidx.compose.ui.semantics.SemanticsInfo
    public boolean isTransparent() {
        return getOuterCoordinator$ui().isTransparent();
    }

    /* JADX INFO: renamed from: isSemanticsInvalidated$ui, reason: from getter */
    public final boolean getIsSemanticsInvalidated() {
        return this.isSemanticsInvalidated;
    }

    public final void setSemanticsInvalidated$ui(boolean z) {
        this.isSemanticsInvalidated = z;
    }

    public final void requestAutofill$ui() {
        if (this.isCurrentlyCalculatingSemanticsConfiguration) {
            return;
        }
        LayoutNodeKt.requireOwner(this).requestAutofill(this);
    }

    public final void invalidateSemantics$ui() {
        if (this.isCurrentlyCalculatingSemanticsConfiguration) {
            return;
        }
        if (this.nodes.isUpdating$ui() || getApplyingModifierOnAttach$ui()) {
            this.isSemanticsInvalidated = true;
            return;
        }
        SemanticsConfiguration semanticsConfiguration = this._semanticsConfiguration;
        this._semanticsConfiguration = calculateSemanticsConfiguration();
        this.isSemanticsInvalidated = false;
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(this);
        ownerRequireOwner.getSemanticsOwner().notifySemanticsChange$ui(this, semanticsConfiguration);
        ownerRequireOwner.onSemanticsChange();
    }

    @Override // androidx.compose.ui.semantics.SemanticsInfo
    public SemanticsConfiguration getSemanticsConfiguration() {
        if (isAttached() && !getIsDeactivated() && this.nodes.m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(8))) {
            return this._semanticsConfiguration;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.compose.ui.semantics.SemanticsConfiguration] */
    private final SemanticsConfiguration calculateSemanticsConfiguration() {
        this.isCurrentlyCalculatingSemanticsConfiguration = true;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new SemanticsConfiguration();
        OwnerSnapshotObserver snapshotObserver = LayoutNodeKt.requireOwner(this).getSnapshotObserver();
        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode.calculateSemanticsConfiguration.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v6 */
            /* JADX WARN: Type inference failed for: r6v7, types: [T, androidx.compose.ui.semantics.SemanticsConfiguration] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NodeChain nodes = LayoutNode.this.getNodes();
                int iM7763constructorimpl = NodeKind.m7763constructorimpl(8);
                Ref.ObjectRef<SemanticsConfiguration> objectRef2 = objectRef;
                if ((nodes.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
                    for (Modifier.Node tail = nodes.getTail(); tail != null; tail = tail.getParent()) {
                        if ((tail.getKindSet() & iM7763constructorimpl) != 0) {
                            Modifier.Node nodePop = tail;
                            MutableVector mutableVector = null;
                            while (nodePop != 0) {
                                if (nodePop instanceof SemanticsModifierNode) {
                                    SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) nodePop;
                                    if (semanticsModifierNode.getIsClearingSemantics()) {
                                        objectRef2.element = new SemanticsConfiguration();
                                        objectRef2.element.setClearingSemantics(true);
                                    }
                                    if (semanticsModifierNode.getShouldMergeDescendantSemantics()) {
                                        objectRef2.element.setMergingSemanticsOfDescendants(true);
                                    }
                                    semanticsModifierNode.applySemantics(objectRef2.element);
                                } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate();
                                    int i = 0;
                                    nodePop = nodePop;
                                    while (delegate$ui != null) {
                                        if ((delegate$ui.getKindSet() & iM7763constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate$ui;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != 0) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(nodePop);
                                                    }
                                                    nodePop = 0;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui);
                                                }
                                            }
                                        }
                                        delegate$ui = delegate$ui.getChild();
                                        nodePop = nodePop;
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                    }
                }
            }
        };
        Function1 function1 = snapshotObserver.onCommitAffectingSemantics;
        snapshotObserver.observer.observeReads(this, function1, function0);
        this.isCurrentlyCalculatingSemanticsConfiguration = false;
        return (SemanticsConfiguration) objectRef.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void attach$ui(androidx.compose.ui.node.Owner r7) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.attach$ui(androidx.compose.ui.node.Owner):void");
    }

    public final void detach$ui() {
        Owner owner = this.owner;
        if (owner == null) {
            StringBuilder sb = new StringBuilder("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui = getParent$ui();
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(sb.append(parent$ui != null ? debugTreeToString$default(parent$ui, 0, 1, null) : null).toString());
            throw new KotlinNothingValueException();
        }
        LayoutNode parent$ui2 = getParent$ui();
        if (parent$ui2 != null) {
            parent$ui2.invalidateLayer$ui();
            parent$ui2.invalidateMeasurements$ui();
            getMeasurePassDelegate$ui().setMeasuredByParent$ui(UsageByParent.NotUsed);
            LookaheadPassDelegate lookaheadPassDelegate$ui = getLookaheadPassDelegate$ui();
            if (lookaheadPassDelegate$ui != null) {
                lookaheadPassDelegate$ui.setMeasuredByParent$ui(UsageByParent.NotUsed);
            }
        }
        this.layoutDelegate.resetAlignmentLines();
        NodeCoordinator wrapped = getInnerCoordinator$ui().getWrapped();
        for (NodeCoordinator outerCoordinator$ui = getOuterCoordinator$ui(); !Intrinsics.areEqual(outerCoordinator$ui, wrapped) && outerCoordinator$ui != null; outerCoordinator$ui = outerCoordinator$ui.getWrapped()) {
            outerCoordinator$ui.onLayoutNodeDetach();
        }
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner);
        }
        this.nodes.runDetachLifecycle$ui();
        this.ignoreRemeasureRequests = true;
        MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
        LayoutNode[] layoutNodeArr = vector.content;
        int size = vector.getSize();
        for (int i = 0; i < size; i++) {
            layoutNodeArr[i].detach$ui();
        }
        Unit unit = Unit.INSTANCE;
        this.ignoreRemeasureRequests = false;
        this.nodes.markAsDetached$ui();
        owner.onDetach(this);
        owner.getRectManager().remove(this);
        this.owner = null;
        setLookaheadRoot(null);
        this.depth = 0;
        getMeasurePassDelegate$ui().onNodeDetached();
        LookaheadPassDelegate lookaheadPassDelegate$ui2 = getLookaheadPassDelegate$ui();
        if (lookaheadPassDelegate$ui2 != null) {
            lookaheadPassDelegate$ui2.onNodeDetached();
        }
        if (this.nodes.m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(8))) {
            SemanticsConfiguration semanticsConfiguration = this._semanticsConfiguration;
            this._semanticsConfiguration = null;
            this.isSemanticsInvalidated = false;
            owner.getSemanticsOwner().notifySemanticsChange$ui(this, semanticsConfiguration);
            owner.onSemanticsChange();
        }
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector<LayoutNode> mutableVector = this._zSortedChildren;
            mutableVector.addAll(mutableVector.getSize(), get_children$ui());
            this._zSortedChildren.sortWith(ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return isAttached();
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + " children: " + getChildren$ui().size() + " measurePolicy: " + getMeasurePolicy() + " deactivated: " + getIsDeactivated();
    }

    public final boolean getHasFixedInnerContentConstraints$ui() {
        long jM7747getLastMeasurementConstraintsmsEJaDk$ui = getInnerCoordinator$ui().m7747getLastMeasurementConstraintsmsEJaDk$ui();
        return Constraints.m8781getHasFixedWidthimpl(jM7747getLastMeasurementConstraintsmsEJaDk$ui) && Constraints.m8780getHasFixedHeightimpl(jM7747getLastMeasurementConstraintsmsEJaDk$ui);
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return layoutNode.debugTreeToString(i);
    }

    private final String debugTreeToString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        MutableVector<LayoutNode> mutableVector = get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(layoutNodeArr[i2].debugTreeToString(depth + 1));
        }
        String string = sb.toString();
        if (depth != 0) {
            return string;
        }
        String strSubstring = string.substring(0, string.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX INFO: compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b!\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\"\u0010\u0010\u001a\u00020\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u0011\u001a\u00020\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "<init>", "(Ljava/lang/String;)V", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "minIntrinsicHeight", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "maxIntrinsicWidth", "maxIntrinsicHeight", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        public static final int $stable = 0;
        private final String error;

        public NoIntrinsicsMeasurePolicy(String str) {
            this.error = str;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m7680maxIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m7681maxIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m7682minIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m7683minIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        /* JADX INFO: renamed from: minIntrinsicWidth, reason: collision with other method in class */
        public Void m7683minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        /* JADX INFO: renamed from: minIntrinsicHeight, reason: collision with other method in class */
        public Void m7682minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        /* JADX INFO: renamed from: maxIntrinsicWidth, reason: collision with other method in class */
        public Void m7681maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }

        /* JADX INFO: renamed from: maxIntrinsicHeight, reason: collision with other method in class */
        public Void m7680maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
            throw new IllegalStateException(this.error.toString());
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setMeasurePolicy(MeasurePolicy measurePolicy) {
        if (Intrinsics.areEqual(this.measurePolicy, measurePolicy)) {
            return;
        }
        this.measurePolicy = measurePolicy;
        IntrinsicsPolicy intrinsicsPolicy = this.intrinsicsPolicy;
        if (intrinsicsPolicy != null) {
            intrinsicsPolicy.updateFrom(getMeasurePolicy());
        }
        invalidateMeasurements$ui();
    }

    private final IntrinsicsPolicy getOrCreateIntrinsicsPolicy() {
        IntrinsicsPolicy intrinsicsPolicy = this.intrinsicsPolicy;
        if (intrinsicsPolicy != null) {
            return intrinsicsPolicy;
        }
        IntrinsicsPolicy intrinsicsPolicy2 = new IntrinsicsPolicy(this, getMeasurePolicy());
        this.intrinsicsPolicy = intrinsicsPolicy2;
        return intrinsicsPolicy2;
    }

    public final int minLookaheadIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicWidth(height);
    }

    public final int minLookaheadIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().minLookaheadIntrinsicHeight(width);
    }

    public final int maxLookaheadIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicWidth(height);
    }

    public final int maxLookaheadIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().maxLookaheadIntrinsicHeight(width);
    }

    public final int minIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().minIntrinsicWidth(height);
    }

    public final int minIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().minIntrinsicHeight(width);
    }

    public final int maxIntrinsicWidth(int height) {
        return getOrCreateIntrinsicsPolicy().maxIntrinsicWidth(height);
    }

    public final int maxIntrinsicHeight(int width) {
        return getOrCreateIntrinsicsPolicy().maxIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setDensity(Density density) {
        if (Intrinsics.areEqual(this.density, density)) {
            return;
        }
        this.density = density;
        onDensityOrLayoutDirectionChanged();
        for (Modifier.Node head = this.nodes.getHead(); head != null; head = head.getChild()) {
            head.onDensityChange();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setLayoutDirection(LayoutDirection layoutDirection) {
        if (this.layoutDirection != layoutDirection) {
            this.layoutDirection = layoutDirection;
            onDensityOrLayoutDirectionChanged();
            for (Modifier.Node head = this.nodes.getHead(); head != null; head = head.getChild()) {
                head.onLayoutDirectionChange();
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setViewConfiguration(ViewConfiguration viewConfiguration) {
        if (Intrinsics.areEqual(this.viewConfiguration, viewConfiguration)) {
            return;
        }
        this.viewConfiguration = viewConfiguration;
        NodeChain nodeChain = this.nodes;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(16);
        if ((nodeChain.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM7763constructorimpl) != 0) {
                    Modifier.Node nodePop = head;
                    MutableVector mutableVector = null;
                    while (nodePop != 0) {
                        if (nodePop instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) nodePop).onViewConfigurationChange();
                        } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate();
                            int i = 0;
                            nodePop = nodePop;
                            while (delegate$ui != null) {
                                if ((delegate$ui.getKindSet() & iM7763constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate$ui;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != 0) {
                                            if (mutableVector != null) {
                                                mutableVector.add(nodePop);
                                            }
                                            nodePop = 0;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                                delegate$ui = delegate$ui.getChild();
                                nodePop = nodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & iM7763constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public CompositionLocalMap getCompositionLocalMap() {
        return this.compositionLocalMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setCompositionLocalMap(CompositionLocalMap compositionLocalMap) {
        this.compositionLocalMap = compositionLocalMap;
        setDensity((Density) compositionLocalMap.get(CompositionLocalsKt.getLocalDensity()));
        setLayoutDirection((LayoutDirection) compositionLocalMap.get(CompositionLocalsKt.getLocalLayoutDirection()));
        setViewConfiguration((ViewConfiguration) compositionLocalMap.get(CompositionLocalsKt.getLocalViewConfiguration()));
        NodeChain nodeChain = this.nodes;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(32768);
        if ((nodeChain.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM7763constructorimpl) != 0) {
                    Modifier.Node nodePop = head;
                    MutableVector mutableVector = null;
                    while (nodePop != 0) {
                        if (nodePop instanceof CompositionLocalConsumerModifierNode) {
                            Modifier.Node node = ((CompositionLocalConsumerModifierNode) nodePop).getNode();
                            if (node.getIsAttached()) {
                                NodeKindKt.autoInvalidateUpdatedNode(node);
                            } else {
                                node.setUpdatedNodeAwaitingAttachForInvalidation$ui(true);
                            }
                        } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate();
                            int i = 0;
                            nodePop = nodePop;
                            while (delegate$ui != null) {
                                if ((delegate$ui.getKindSet() & iM7763constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate$ui;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != 0) {
                                            if (mutableVector != null) {
                                                mutableVector.add(nodePop);
                                            }
                                            nodePop = 0;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                                delegate$ui = delegate$ui.getChild();
                                nodePop = nodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & iM7763constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    private final CompositionErrorContext getTraceContext() {
        return (CompositionErrorContext) getCompositionLocalMap().get(CompositionErrorContextKt.getLocalCompositionErrorContext());
    }

    public final Void rethrowWithComposeStackTrace(Throwable e2) throws Throwable {
        CompositionErrorContext traceContext = getTraceContext();
        if (traceContext == null) {
            throw e2;
        }
        traceContext.attachComposeStackTrace(e2, this);
        throw e2;
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui();
        LayoutNode parent$ui = getParent$ui();
        if (parent$ui != null) {
            parent$ui.invalidateLayer$ui();
        } else {
            Owner owner = this.owner;
            if (owner != null) {
                owner.invalidateRootLayer();
            }
        }
        invalidateLayers$ui();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getWidth() {
        return this.layoutDelegate.getWidth$ui();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getHeight() {
        return this.layoutDelegate.getHeight$ui();
    }

    public final boolean getAlignmentLinesRequired$ui() {
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui;
        AlignmentLines alignmentLines;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        return layoutNodeLayoutDelegate.getAlignmentLinesOwner$ui().getAlignmentLines().getRequired$ui() || !((lookaheadAlignmentLinesOwner$ui = layoutNodeLayoutDelegate.getLookaheadAlignmentLinesOwner$ui()) == null || (alignmentLines = lookaheadAlignmentLinesOwner$ui.getAlignmentLines()) == null || !alignmentLines.getRequired$ui());
    }

    public final LayoutNodeDrawScope getMDrawScope$ui() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isPlaced() {
        return getMeasurePassDelegate$ui().isPlaced$ui();
    }

    public final boolean isPlacedByParent() {
        return getMeasurePassDelegate$ui().isPlacedByParent();
    }

    public final int getPlaceOrder$ui() {
        return getMeasurePassDelegate$ui().getPlaceOrder();
    }

    public final UsageByParent getMeasuredByParent$ui() {
        return getMeasurePassDelegate$ui().getMeasuredByParent$ui();
    }

    public final UsageByParent getMeasuredByParentInLookahead$ui() {
        UsageByParent measuredByParent$ui;
        LookaheadPassDelegate lookaheadPassDelegate$ui = getLookaheadPassDelegate$ui();
        return (lookaheadPassDelegate$ui == null || (measuredByParent$ui = lookaheadPassDelegate$ui.getMeasuredByParent$ui()) == null) ? UsageByParent.NotUsed : measuredByParent$ui;
    }

    /* JADX INFO: renamed from: getIntrinsicsUsageByParent$ui, reason: from getter */
    public final UsageByParent getIntrinsicsUsageByParent() {
        return this.intrinsicsUsageByParent;
    }

    public final void setIntrinsicsUsageByParent$ui(UsageByParent usageByParent) {
        this.intrinsicsUsageByParent = usageByParent;
    }

    /* JADX INFO: renamed from: getCanMultiMeasure$ui, reason: from getter */
    public final boolean getCanMultiMeasure() {
        return this.canMultiMeasure;
    }

    public final void setCanMultiMeasure$ui(boolean z) {
        this.canMultiMeasure = z;
    }

    /* JADX INFO: renamed from: getNodes$ui, reason: from getter */
    public final NodeChain getNodes() {
        return this.nodes;
    }

    public final NodeCoordinator getInnerCoordinator$ui() {
        return this.nodes.getInnerCoordinator();
    }

    /* JADX INFO: renamed from: getLayoutDelegate$ui, reason: from getter */
    public final LayoutNodeLayoutDelegate getLayoutDelegate() {
        return this.layoutDelegate;
    }

    public final NodeCoordinator getOuterCoordinator$ui() {
        return this.nodes.getOuterCoordinator();
    }

    private final float getZIndex() {
        return getMeasurePassDelegate$ui().getZIndex$ui();
    }

    /* JADX INFO: renamed from: getSubcompositionsState$ui, reason: from getter */
    public final LayoutNodeSubcompositionsState getSubcompositionsState() {
        return this.subcompositionsState;
    }

    public final void setSubcompositionsState$ui(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    /* JADX INFO: renamed from: getInnerLayerCoordinatorIsDirty$ui, reason: from getter */
    public final boolean getInnerLayerCoordinatorIsDirty() {
        return this.innerLayerCoordinatorIsDirty;
    }

    public final void setInnerLayerCoordinatorIsDirty$ui(boolean z) {
        this.innerLayerCoordinatorIsDirty = z;
    }

    public final NodeCoordinator getInnerLayerCoordinator$ui() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator innerCoordinator$ui = getInnerCoordinator$ui();
            NodeCoordinator wrappedBy = getOuterCoordinator$ui().getWrappedBy();
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual(innerCoordinator$ui, wrappedBy)) {
                    break;
                }
                if ((innerCoordinator$ui != null ? innerCoordinator$ui.getLayer() : null) != null) {
                    this._innerLayerCoordinator = innerCoordinator$ui;
                    break;
                }
                innerCoordinator$ui = innerCoordinator$ui != null ? innerCoordinator$ui.getWrappedBy() : null;
            }
            this.innerLayerCoordinatorIsDirty = false;
        }
        NodeCoordinator nodeCoordinator = this._innerLayerCoordinator;
        if (nodeCoordinator == null || nodeCoordinator.getLayer() != null) {
            return nodeCoordinator;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("layer was not set. This error is usually caused by operating off of the UI thread. Did you call invalidate() instead of postInvalidate()?");
        throw new KotlinNothingValueException();
    }

    public final void invalidateLayer$ui() {
        NodeCoordinator innerLayerCoordinator$ui = getInnerLayerCoordinator$ui();
        if (innerLayerCoordinator$ui != null) {
            innerLayerCoordinator$ui.invalidateLayer();
            return;
        }
        LayoutNode parent$ui = getParent$ui();
        if (parent$ui != null) {
            parent$ui.invalidateLayer$ui();
            return;
        }
        Owner owner = this.owner;
        if (owner != null) {
            owner.invalidateRootLayer();
        }
    }

    public final boolean getApplyingModifierOnAttach$ui() {
        return this.pendingModifier != null;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    /* JADX INFO: renamed from: getModifier, reason: from getter */
    public Modifier get_modifier() {
        return this._modifier;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setModifier(Modifier modifier) {
        if (!(!this.isVirtual || get_modifier() == Modifier.INSTANCE)) {
            InlineClassHelperKt.throwIllegalArgumentException("Modifiers are not supported on virtual LayoutNodes");
        }
        if (getIsDeactivated()) {
            InlineClassHelperKt.throwIllegalArgumentException("modifier is updated when deactivated");
        }
        if (isAttached()) {
            applyModifier(modifier);
            if (this.isSemanticsInvalidated) {
                invalidateSemantics$ui();
                return;
            }
            return;
        }
        this.pendingModifier = modifier;
    }

    private final void applyModifier(Modifier modifier) {
        boolean zM7723hasH91voCI$ui = this.nodes.m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(16));
        boolean zM7723hasH91voCI$ui2 = this.nodes.m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(1024));
        this._modifier = modifier;
        this.nodes.updateFrom$ui(modifier);
        boolean zM7723hasH91voCI$ui3 = this.nodes.m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(16));
        boolean zM7723hasH91voCI$ui4 = this.nodes.m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(1024));
        this.layoutDelegate.updateParentData();
        if (this.lookaheadRoot == null && this.nodes.m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(512))) {
            setLookaheadRoot(this);
        }
        if (zM7723hasH91voCI$ui == zM7723hasH91voCI$ui3 && zM7723hasH91voCI$ui2 == zM7723hasH91voCI$ui4) {
            return;
        }
        LayoutNodeKt.requireOwner(this).getRectManager().updateFlagsFor(this, zM7723hasH91voCI$ui4, zM7723hasH91voCI$ui3);
    }

    private final void resetModifierState() {
        this.nodes.resetState$ui();
    }

    public final void invalidateParentData$ui() {
        this.layoutDelegate.invalidateParentData();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui();
    }

    public final Function1<Owner, Unit> getOnAttach$ui() {
        return this.onAttach;
    }

    public final void setOnAttach$ui(Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final Function1<Owner, Unit> getOnDetach$ui() {
        return this.onDetach;
    }

    public final void setOnDetach$ui(Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    /* JADX INFO: renamed from: getNeedsOnGloballyPositionedDispatch$ui, reason: from getter */
    public final boolean getNeedsOnGloballyPositionedDispatch() {
        return this.needsOnGloballyPositionedDispatch;
    }

    public final void setNeedsOnGloballyPositionedDispatch$ui(boolean z) {
        this.needsOnGloballyPositionedDispatch = z;
    }

    public final int getGloballyPositionedObservers() {
        return this.globallyPositionedObservers;
    }

    public final void setGloballyPositionedObservers(int i) {
        LayoutNode parent$ui;
        LayoutNode parent$ui2;
        int i2 = this.globallyPositionedObservers;
        if (i2 != i) {
            if (i > 0 && i2 == 0 && (parent$ui2 = getParent$ui()) != null) {
                parent$ui2.setGloballyPositionedObservers(parent$ui2.globallyPositionedObservers + 1);
            }
            if (i == 0 && this.globallyPositionedObservers > 0 && (parent$ui = getParent$ui()) != null) {
                parent$ui.setGloballyPositionedObservers(parent$ui.globallyPositionedObservers - 1);
            }
            this.globallyPositionedObservers = i;
        }
    }

    public final void place$ui(int x, int y) {
        Placeable.PlacementScope placementScope;
        NodeCoordinator innerCoordinator$ui;
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNode parent$ui = getParent$ui();
        if (parent$ui == null || (innerCoordinator$ui = parent$ui.getInnerCoordinator$ui()) == null || (placementScope = innerCoordinator$ui.getPlacementScope()) == null) {
            placementScope = LayoutNodeKt.requireOwner(this).getPlacementScope();
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, getMeasurePassDelegate$ui(), x, y, 0.0f, 4, null);
    }

    public final void replace$ui() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        getMeasurePassDelegate$ui().replace();
    }

    public final void lookaheadReplace$ui() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LookaheadPassDelegate lookaheadPassDelegate$ui = getLookaheadPassDelegate$ui();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui);
        lookaheadPassDelegate$ui.replace();
    }

    public final void draw$ui(Canvas canvas, GraphicsLayer graphicsLayer) throws Throwable {
        try {
            getOuterCoordinator$ui().draw(canvas, graphicsLayer);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            rethrowWithComposeStackTrace(th);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: hitTest-6fMxITs$ui$default, reason: not valid java name */
    public static /* synthetic */ void m7668hitTest6fMxITs$ui$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = PointerType.INSTANCE.m7393getUnknownT8wyACA();
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z = true;
        }
        layoutNode.m7673hitTest6fMxITs$ui(j, hitTestResult, i3, z);
    }

    /* JADX INFO: renamed from: hitTest-6fMxITs$ui, reason: not valid java name */
    public final void m7673hitTest6fMxITs$ui(long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer) {
        getOuterCoordinator$ui().m7750hitTestqzLsGqo(NodeCoordinator.INSTANCE.getPointerInputSource(), NodeCoordinator.m7731fromParentPosition8S9VItk$default(getOuterCoordinator$ui(), pointerPosition, false, 2, null), hitTestResult, pointerType, isInLayer);
    }

    /* JADX INFO: renamed from: hitTestSemantics-6fMxITs$ui$default, reason: not valid java name */
    public static /* synthetic */ void m7669hitTestSemantics6fMxITs$ui$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = PointerType.INSTANCE.m7392getTouchT8wyACA();
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z = true;
        }
        layoutNode.m7674hitTestSemantics6fMxITs$ui(j, hitTestResult, i3, z);
    }

    /* JADX INFO: renamed from: hitTestSemantics-6fMxITs$ui, reason: not valid java name */
    public final void m7674hitTestSemantics6fMxITs$ui(long pointerPosition, HitTestResult hitSemanticsEntities, int pointerType, boolean isInLayer) {
        getOuterCoordinator$ui().m7750hitTestqzLsGqo(NodeCoordinator.INSTANCE.getSemanticsSource(), NodeCoordinator.m7731fromParentPosition8S9VItk$default(getOuterCoordinator$ui(), pointerPosition, false, 2, null), hitSemanticsEntities, PointerType.INSTANCE.m7392getTouchT8wyACA(), isInLayer);
    }

    public final void rescheduleRemeasureOrRelayout$ui(LayoutNode it) {
        if (WhenMappings.$EnumSwitchMapping$0[it.getLayoutState$ui().ordinal()] == 1) {
            if (it.getLookaheadMeasurePending$ui()) {
                requestLookaheadRemeasure$ui$default(it, true, false, false, 6, null);
                return;
            }
            if (it.getLookaheadLayoutPending$ui()) {
                it.requestLookaheadRelayout$ui(true);
            }
            if (it.getMeasurePending$ui()) {
                requestRemeasure$ui$default(it, true, false, false, 6, null);
                return;
            } else {
                if (it.getLayoutPending$ui()) {
                    it.requestRelayout$ui(true);
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("Unexpected state " + it.getLayoutState$ui());
    }

    public static /* synthetic */ void requestRemeasure$ui$default(LayoutNode layoutNode, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        layoutNode.requestRemeasure$ui(z, z2, z3);
    }

    public final void requestRemeasure$ui(boolean forceRequest, boolean scheduleMeasureAndLayout, boolean invalidateIntrinsics) {
        Owner owner;
        if (this.ignoreRemeasureRequests || this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestMeasure$default(owner, this, false, forceRequest, scheduleMeasureAndLayout, 2, null);
        if (invalidateIntrinsics) {
            getMeasurePassDelegate$ui().invalidateIntrinsicsParent(forceRequest);
        }
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui$default(LayoutNode layoutNode, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        layoutNode.requestLookaheadRemeasure$ui(z, z2, z3);
    }

    public final void requestLookaheadRemeasure$ui(boolean forceRequest, boolean scheduleMeasureAndLayout, boolean invalidateIntrinsics) {
        if (!(this.lookaheadRoot != null)) {
            InlineClassHelperKt.throwIllegalStateException("Lookahead measure cannot be requested on a node that is not a part of the LookaheadScope");
        }
        Owner owner = this.owner;
        if (owner == null || this.ignoreRemeasureRequests || this.isVirtual) {
            return;
        }
        owner.onRequestMeasure(this, true, forceRequest, scheduleMeasureAndLayout);
        if (invalidateIntrinsics) {
            LookaheadPassDelegate lookaheadPassDelegate$ui = getLookaheadPassDelegate$ui();
            Intrinsics.checkNotNull(lookaheadPassDelegate$ui);
            lookaheadPassDelegate$ui.invalidateIntrinsicsParent(forceRequest);
        }
    }

    public final void invalidateMeasurements$ui() {
        if (this.isVirtual) {
            LayoutNode parent$ui = getParent$ui();
            if (parent$ui != null) {
                parent$ui.invalidateMeasurements$ui();
                return;
            }
            return;
        }
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui$default(this, false, false, false, 7, null);
        } else {
            requestRemeasure$ui$default(this, false, false, false, 7, null);
        }
    }

    public final void invalidateOnPositioned$ui() {
        if (this.globallyPositionedObservers == 0 || getLayoutPending$ui() || getMeasurePending$ui() || this.needsOnGloballyPositionedDispatch) {
            return;
        }
        LayoutNodeKt.requireOwner(this).requestOnPositionedCallback(this);
    }

    public final void onCoordinatorRectChanged$ui(NodeCoordinator coordinator) {
        Owner owner = this.owner;
        RectManager rectManager = owner != null ? owner.getRectManager() : null;
        boolean z = getLayoutState$ui() != LayoutState.Idle || getMeasurePending$ui() || getLayoutPending$ui();
        if (this.addedToRectList && rectManager != null) {
            if (coordinator == getOuterCoordinator$ui()) {
                this.rectInParentDirty = true;
                if (!z) {
                    rectManager.recalculateRectIfDirty(this);
                }
            } else {
                this.outerToInnerOffsetDirty = true;
                MutableVector<LayoutNode> mutableVector = get_children$ui();
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i = 0; i < size; i++) {
                    LayoutNode layoutNode = layoutNodeArr[i];
                    layoutNode.rectInParentDirty = true;
                    if (!z) {
                        rectManager.recalculateRectIfDirty(layoutNode);
                    }
                }
                rectManager.invalidateCallbacksFor(this);
            }
        }
        this.layoutDelegate.getMeasurePassDelegate().requestLayoutIfCoordinatesAreUsedAndNotifyChildren();
    }

    public final <T> T ignoreRemeasureRequests$ui(Function0<? extends T> block) {
        this.ignoreRemeasureRequests = true;
        T tInvoke = block.invoke();
        this.ignoreRemeasureRequests = false;
        return tInvoke;
    }

    public static /* synthetic */ void requestRelayout$ui$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRelayout$ui(z);
    }

    public final void requestRelayout$ui(boolean forceRequest) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestRelayout$default(owner, this, false, forceRequest, 2, null);
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRelayout$ui(z);
    }

    public final void requestLookaheadRelayout$ui(boolean forceRequest) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        owner.onRequestRelayout(this, true, forceRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final void dispatchOnPositionedCallbacks$ui() {
        if (getLayoutState$ui() != LayoutState.Idle || getLayoutPending$ui() || getMeasurePending$ui() || getIsDeactivated() || !isPlaced()) {
            return;
        }
        NodeChain nodeChain = this.nodes;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(256);
        if ((nodeChain.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM7763constructorimpl) != 0) {
                    Modifier.Node nodePop = head;
                    MutableVector mutableVector = null;
                    while (nodePop != 0) {
                        if (nodePop instanceof GlobalPositionAwareModifierNode) {
                            GlobalPositionAwareModifierNode globalPositionAwareModifierNode = (GlobalPositionAwareModifierNode) nodePop;
                            globalPositionAwareModifierNode.onGloballyPositioned(DelegatableNodeKt.m7617requireCoordinator64DMado(globalPositionAwareModifierNode, NodeKind.m7763constructorimpl(256)));
                        } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate();
                            int i = 0;
                            nodePop = nodePop;
                            while (delegate$ui != null) {
                                if ((delegate$ui.getKindSet() & iM7763constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate$ui;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != 0) {
                                            if (mutableVector != null) {
                                                mutableVector.add(nodePop);
                                            }
                                            nodePop = 0;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                                delegate$ui = delegate$ui.getChild();
                                nodePop = nodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & iM7763constructorimpl) == 0) {
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    /* JADX INFO: renamed from: lookaheadRemeasure-_Sx5XlM$ui$default, reason: not valid java name */
    public static /* synthetic */ boolean m7670lookaheadRemeasure_Sx5XlM$ui$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m7687getLastLookaheadConstraintsDWUhwKw();
        }
        return layoutNode.m7675lookaheadRemeasure_Sx5XlM$ui(constraints);
    }

    /* JADX INFO: renamed from: lookaheadRemeasure-_Sx5XlM$ui, reason: not valid java name */
    public final boolean m7675lookaheadRemeasure_Sx5XlM$ui(Constraints constraints) {
        if (constraints == null || this.lookaheadRoot == null) {
            return false;
        }
        LookaheadPassDelegate lookaheadPassDelegate$ui = getLookaheadPassDelegate$ui();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui);
        return lookaheadPassDelegate$ui.m7707remeasureBRTryo0(constraints.getValue());
    }

    /* JADX INFO: renamed from: remeasure-_Sx5XlM$ui$default, reason: not valid java name */
    public static /* synthetic */ boolean m7671remeasure_Sx5XlM$ui$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m7686getLastConstraintsDWUhwKw();
        }
        return layoutNode.m7676remeasure_Sx5XlM$ui(constraints);
    }

    /* JADX INFO: renamed from: remeasure-_Sx5XlM$ui, reason: not valid java name */
    public final boolean m7676remeasure_Sx5XlM$ui(Constraints constraints) {
        if (constraints == null) {
            return false;
        }
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage$ui();
        }
        return getMeasurePassDelegate$ui().m7718remeasureBRTryo0(constraints.getValue());
    }

    public final boolean getMeasurePending$ui() {
        return this.layoutDelegate.getMeasurePending$ui();
    }

    public final boolean getLayoutPending$ui() {
        return this.layoutDelegate.getLayoutPending$ui();
    }

    public final boolean getLookaheadMeasurePending$ui() {
        return this.layoutDelegate.getLookaheadMeasurePending();
    }

    public final boolean getLookaheadLayoutPending$ui() {
        return this.layoutDelegate.getLookaheadLayoutPending();
    }

    public final void markLayoutPending$ui() {
        this.layoutDelegate.markLayoutPending$ui();
    }

    public final void markMeasurePending$ui() {
        this.layoutDelegate.markMeasurePending$ui();
    }

    public final void markLookaheadLayoutPending$ui() {
        this.layoutDelegate.markLookaheadLayoutPending$ui();
    }

    public static /* synthetic */ void invalidateSubtree$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        layoutNode.invalidateSubtree(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    public final void invalidateSubtree(boolean isRootOfInvalidation) {
        if (isRootOfInvalidation) {
            LayoutNode parent$ui = getParent$ui();
            if (parent$ui != null) {
                parent$ui.invalidateLayer$ui();
            } else {
                Owner owner = this.owner;
                if (owner != null) {
                    owner.invalidateRootLayer();
                }
            }
        }
        invalidateSemantics$ui();
        requestRemeasure$ui$default(this, false, false, false, 7, null);
        NodeChain nodeChain = this.nodes;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(2);
        if ((nodeChain.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM7763constructorimpl) != 0) {
                    Modifier.Node nodePop = head;
                    MutableVector mutableVector = null;
                    while (nodePop != 0) {
                        if (nodePop instanceof LayoutModifierNode) {
                            OwnedLayer layer = DelegatableNodeKt.m7617requireCoordinator64DMado((LayoutModifierNode) nodePop, NodeKind.m7763constructorimpl(2)).getLayer();
                            if (layer != null) {
                                layer.invalidate();
                            }
                        } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate();
                            int i = 0;
                            nodePop = nodePop;
                            while (delegate$ui != null) {
                                if ((delegate$ui.getKindSet() & iM7763constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate$ui;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != 0) {
                                            if (mutableVector != null) {
                                                mutableVector.add(nodePop);
                                            }
                                            nodePop = 0;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                                delegate$ui = delegate$ui.getChild();
                                nodePop = nodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & iM7763constructorimpl) == 0) {
                    break;
                }
            }
        }
        MutableVector<LayoutNode> mutableVector2 = get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector2.content;
        int size = mutableVector2.getSize();
        for (int i2 = 0; i2 < size; i2++) {
            layoutNodeArr[i2].invalidateSubtree(false);
        }
    }

    public final void invalidateMeasurementForSubtree() {
        requestRemeasure$ui$default(this, false, false, false, 7, null);
        MutableVector<LayoutNode> mutableVector = get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            layoutNodeArr[i].invalidateMeasurementForSubtree();
        }
    }

    public static /* synthetic */ void invalidateDrawForSubtree$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        layoutNode.invalidateDrawForSubtree(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final void invalidateDrawForSubtree(boolean isRootOfInvalidation) {
        if (isRootOfInvalidation) {
            LayoutNode parent$ui = getParent$ui();
            if (parent$ui != null) {
                parent$ui.invalidateLayer$ui();
            } else {
                Owner owner = this.owner;
                if (owner != null) {
                    owner.invalidateRootLayer();
                }
            }
        }
        NodeChain nodeChain = this.nodes;
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(2);
        if ((nodeChain.getAggregateChildKindSet() & iM7763constructorimpl) != 0) {
            for (Modifier.Node head = nodeChain.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM7763constructorimpl) != 0) {
                    Modifier.Node nodePop = head;
                    MutableVector mutableVector = null;
                    while (nodePop != 0) {
                        if (nodePop instanceof LayoutModifierNode) {
                            OwnedLayer layer = DelegatableNodeKt.m7617requireCoordinator64DMado((LayoutModifierNode) nodePop, NodeKind.m7763constructorimpl(2)).getLayer();
                            if (layer != null) {
                                layer.invalidate();
                            }
                        } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate();
                            int i = 0;
                            nodePop = nodePop;
                            while (delegate$ui != null) {
                                if ((delegate$ui.getKindSet() & iM7763constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        nodePop = delegate$ui;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != 0) {
                                            if (mutableVector != null) {
                                                mutableVector.add(nodePop);
                                            }
                                            nodePop = 0;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui);
                                        }
                                    }
                                }
                                delegate$ui = delegate$ui.getChild();
                                nodePop = nodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & iM7763constructorimpl) == 0) {
                    break;
                }
            }
        }
        MutableVector<LayoutNode> mutableVector2 = get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector2.content;
        int size = mutableVector2.getSize();
        for (int i2 = 0; i2 < size; i2++) {
            layoutNodeArr[i2].invalidateDrawForSubtree(false);
        }
    }

    public final void markLookaheadMeasurePending$ui() {
        this.layoutDelegate.markLookaheadMeasurePending$ui();
    }

    @Override // androidx.compose.ui.layout.Remeasurement
    public void forceRemeasure() {
        LayoutNode layoutNode;
        if (this.lookaheadRoot != null) {
            layoutNode = this;
            requestLookaheadRemeasure$ui$default(layoutNode, false, false, false, 5, null);
        } else {
            requestRemeasure$ui$default(this, false, false, false, 5, null);
            layoutNode = this;
        }
        Constraints constraintsM7686getLastConstraintsDWUhwKw = layoutNode.layoutDelegate.m7686getLastConstraintsDWUhwKw();
        if (constraintsM7686getLastConstraintsDWUhwKw != null) {
            Owner owner = layoutNode.owner;
            if (owner != null) {
                owner.mo7830measureAndLayout0kLqBqw(this, constraintsM7686getLastConstraintsDWUhwKw.getValue());
                return;
            }
            return;
        }
        Owner owner2 = layoutNode.owner;
        if (owner2 != null) {
            Owner.measureAndLayout$default(owner2, false, 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void onLayoutComplete() {
        NodeCoordinator innerCoordinator$ui = getInnerCoordinator$ui();
        int iM7763constructorimpl = NodeKind.m7763constructorimpl(4194304);
        boolean zM7772getIncludeSelfInTraversalH91voCI = NodeKindKt.m7772getIncludeSelfInTraversalH91voCI(iM7763constructorimpl);
        Modifier.Node tail = innerCoordinator$ui.getTail();
        if (!zM7772getIncludeSelfInTraversalH91voCI && (tail = tail.getParent()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = innerCoordinator$ui.headNode(zM7772getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet() & iM7763constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild()) {
            if ((nodeHeadNode.getKindSet() & iM7763constructorimpl) != 0) {
                Modifier.Node nodePop = nodeHeadNode;
                MutableVector mutableVector = null;
                while (nodePop != 0) {
                    if (nodePop instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) nodePop).onPlaced(getInnerCoordinator$ui());
                    } else if ((nodePop.getKindSet() & iM7763constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui = ((DelegatingNode) nodePop).getDelegate();
                        int i = 0;
                        nodePop = nodePop;
                        while (delegate$ui != null) {
                            if ((delegate$ui.getKindSet() & iM7763constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    nodePop = delegate$ui;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (nodePop != 0) {
                                        if (mutableVector != null) {
                                            mutableVector.add(nodePop);
                                        }
                                        nodePop = 0;
                                    }
                                    if (mutableVector != null) {
                                        mutableVector.add(delegate$ui);
                                    }
                                }
                            }
                            delegate$ui = delegate$ui.getChild();
                            nodePop = nodePop;
                        }
                        if (i == 1) {
                        }
                    }
                    nodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    public final void forEachCoordinator$ui(Function1<? super LayoutModifierNodeCoordinator, Unit> block) {
        NodeCoordinator outerCoordinator$ui = getOuterCoordinator$ui();
        NodeCoordinator innerCoordinator$ui = getInnerCoordinator$ui();
        while (outerCoordinator$ui != innerCoordinator$ui) {
            Intrinsics.checkNotNull(outerCoordinator$ui, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui;
            block.invoke(layoutModifierNodeCoordinator);
            outerCoordinator$ui = layoutModifierNodeCoordinator.getWrapped();
        }
    }

    public final void forEachCoordinatorIncludingInner$ui(Function1<? super NodeCoordinator, Unit> block) {
        NodeCoordinator wrapped = getInnerCoordinator$ui().getWrapped();
        for (NodeCoordinator outerCoordinator$ui = getOuterCoordinator$ui(); !Intrinsics.areEqual(outerCoordinator$ui, wrapped) && outerCoordinator$ui != null; outerCoordinator$ui = outerCoordinator$ui.getWrapped()) {
            block.invoke(outerCoordinator$ui);
        }
    }

    public final void clearSubtreeIntrinsicsUsage$ui() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            if (layoutNode.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                layoutNode.clearSubtreeIntrinsicsUsage$ui();
            }
        }
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            if (layoutNode.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                layoutNode.clearSubtreePlacementIntrinsicsUsage();
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public SemanticsInfo getParentInfo() {
        return getParent$ui();
    }

    @Override // androidx.compose.ui.semantics.SemanticsInfo
    public List<SemanticsInfo> getChildrenInfo() {
        return getChildren$ui();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    /* JADX INFO: renamed from: isDeactivated, reason: from getter */
    public boolean getIsDeactivated() {
        return this.isDeactivated;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        RectManager rectManager;
        RectManager rectManager2;
        if (!isAttached()) {
            InlineClassHelperKt.throwIllegalArgumentException("onReuse is only expected on attached node");
        }
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onReuse();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onReuse();
        }
        this.isCurrentlyCalculatingSemanticsConfiguration = false;
        if (getIsDeactivated()) {
            this.isDeactivated = false;
        } else {
            resetModifierState();
        }
        int semanticsId = getSemanticsId();
        Owner owner = this.owner;
        if (owner != null && (rectManager2 = owner.getRectManager()) != null) {
            rectManager2.remove(this);
        }
        setSemanticsId(SemanticsModifierKt.generateSemanticsId());
        Owner owner2 = this.owner;
        if (owner2 != null) {
            owner2.onPreLayoutNodeReused(this, semanticsId);
        }
        this.nodes.markAsAttached();
        this.nodes.runAttachLifecycle();
        if (this.nodes.m7723hasH91voCI$ui(NodeKind.m7763constructorimpl(8))) {
            invalidateSemantics$ui();
        }
        rescheduleRemeasureOrRelayout$ui(this);
        Owner owner3 = this.owner;
        if (owner3 != null) {
            owner3.onPostLayoutNodeReused(this, semanticsId);
        }
        Owner owner4 = this.owner;
        if (owner4 == null || (rectManager = owner4.getRectManager()) == null) {
            return;
        }
        rectManager.recalculateRectIfDirty(this);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onDeactivate();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onDeactivate();
        }
        this.isDeactivated = true;
        resetModifierState();
        if (isAttached()) {
            this._semanticsConfiguration = null;
            this.isSemanticsInvalidated = false;
        }
        Owner owner = this.owner;
        if (owner != null) {
            owner.onLayoutNodeDeactivated(this);
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onRelease();
        }
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.subcompositionsState;
        if (layoutNodeSubcompositionsState != null) {
            layoutNodeSubcompositionsState.onRelease();
        }
        NodeCoordinator wrapped = getInnerCoordinator$ui().getWrapped();
        for (NodeCoordinator outerCoordinator$ui = getOuterCoordinator$ui(); !Intrinsics.areEqual(outerCoordinator$ui, wrapped) && outerCoordinator$ui != null; outerCoordinator$ui = outerCoordinator$ui.getWrapped()) {
            outerCoordinator$ui.onRelease();
        }
    }

    /* JADX INFO: compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "<init>", "()V", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "getNotPlacedPlaceOrder$ui$annotations", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ZComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getZComparator$ui", "()Ljava/util/Comparator;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getNotPlacedPlaceOrder$ui$annotations() {
        }

        private Companion() {
        }

        public final Function0<LayoutNode> getConstructor$ui() {
            return LayoutNode.Constructor;
        }

        public final ViewConfiguration getDummyViewConfiguration$ui() {
            return LayoutNode.DummyViewConfiguration;
        }

        public final Comparator<LayoutNode> getZComparator$ui() {
            return LayoutNode.ZComparator;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ZComparator$lambda$0(LayoutNode layoutNode, LayoutNode layoutNode2) {
        if (layoutNode.getZIndex() == layoutNode2.getZIndex()) {
            return Intrinsics.compare(layoutNode.getPlaceOrder$ui(), layoutNode2.getPlaceOrder$ui());
        }
        return Float.compare(layoutNode.getZIndex(), layoutNode2.getZIndex());
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "<init>", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LayoutState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LayoutState[] $VALUES;
        public static final LayoutState Measuring = new LayoutState("Measuring", 0);
        public static final LayoutState LookaheadMeasuring = new LayoutState("LookaheadMeasuring", 1);
        public static final LayoutState LayingOut = new LayoutState("LayingOut", 2);
        public static final LayoutState LookaheadLayingOut = new LayoutState("LookaheadLayingOut", 3);
        public static final LayoutState Idle = new LayoutState("Idle", 4);

        private static final /* synthetic */ LayoutState[] $values() {
            return new LayoutState[]{Measuring, LookaheadMeasuring, LayingOut, LookaheadLayingOut, Idle};
        }

        public static EnumEntries<LayoutState> getEntries() {
            return $ENTRIES;
        }

        public static LayoutState valueOf(String str) {
            return (LayoutState) Enum.valueOf(LayoutState.class, str);
        }

        public static LayoutState[] values() {
            return (LayoutState[]) $VALUES.clone();
        }

        private LayoutState(String str, int i) {
        }

        static {
            LayoutState[] layoutStateArr$values = $values();
            $VALUES = layoutStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(layoutStateArr$values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: LayoutNode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "<init>", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UsageByParent {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UsageByParent[] $VALUES;
        public static final UsageByParent InMeasureBlock = new UsageByParent("InMeasureBlock", 0);
        public static final UsageByParent InLayoutBlock = new UsageByParent("InLayoutBlock", 1);
        public static final UsageByParent NotUsed = new UsageByParent("NotUsed", 2);

        private static final /* synthetic */ UsageByParent[] $values() {
            return new UsageByParent[]{InMeasureBlock, InLayoutBlock, NotUsed};
        }

        public static EnumEntries<UsageByParent> getEntries() {
            return $ENTRIES;
        }

        public static UsageByParent valueOf(String str) {
            return (UsageByParent) Enum.valueOf(UsageByParent.class, str);
        }

        public static UsageByParent[] values() {
            return (UsageByParent[]) $VALUES.clone();
        }

        private UsageByParent(String str, int i) {
        }

        static {
            UsageByParent[] usageByParentArr$values = $values();
            $VALUES = usageByParentArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(usageByParentArr$values);
        }
    }

    public final void invalidateLayers$ui() {
        NodeCoordinator outerCoordinator$ui = getOuterCoordinator$ui();
        NodeCoordinator innerCoordinator$ui = getInnerCoordinator$ui();
        while (outerCoordinator$ui != innerCoordinator$ui) {
            Intrinsics.checkNotNull(outerCoordinator$ui, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui;
            OwnedLayer layer = layoutModifierNodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
            outerCoordinator$ui = layoutModifierNodeCoordinator.getWrapped();
        }
        OwnedLayer layer2 = getInnerCoordinator$ui().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    public final void resetSubtreeIntrinsicsUsage$ui() {
        MutableVector<LayoutNode> mutableVector = get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            UsageByParent usageByParent = layoutNode.previousIntrinsicsUsageByParent;
            layoutNode.intrinsicsUsageByParent = usageByParent;
            if (usageByParent != UsageByParent.NotUsed) {
                layoutNode.resetSubtreeIntrinsicsUsage$ui();
            }
        }
    }
}
