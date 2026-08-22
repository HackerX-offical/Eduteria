package androidx.compose.foundation.style;

import androidx.collection.MutableIntList;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.platform.ValueElement;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.appnew.android.Utils.imagecropper.CropImage;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.message_fastening.element.FasteningElement;

/* JADX INFO: compiled from: ResolvedStyle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010Ä\u0001\u001a\u00020\u00062\u0007\u0010Å\u0001\u001a\u00020\u00002\t\b\u0002\u0010Æ\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0003\bÇ\u0001J\u000f\u0010È\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bÉ\u0001J\u000f\u0010Ê\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bË\u0001J\u0019\u0010Ì\u0001\u001a\u00030Í\u00012\u0007\u0010Î\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bÏ\u0001J\u0019\u0010Ð\u0001\u001a\u00030Í\u00012\u0007\u0010Î\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bÑ\u0001J\u0010\u0010Ò\u0001\u001a\u00030Í\u0001H\u0000¢\u0006\u0003\bÓ\u0001J4\u0010Ô\u0001\u001a\u00030Í\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010×\u0001\u001a\u00030Ø\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0003\bÙ\u0001J:\u0010Ú\u0001\u001a\u00030Í\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\b\u0010×\u0001\u001a\u00030Ø\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\f\b\u0002\u0010Û\u0001\u001a\u0005\u0018\u00010Ü\u0001H\u0000¢\u0006\u0003\bÝ\u0001J\u0019\u0010Þ\u0001\u001a\u00030Í\u00012\u0007\u0010ß\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bà\u0001J\u001a\u0010á\u0001\u001a\u00030â\u00012\b\u0010ã\u0001\u001a\u00030â\u0001H\u0000¢\u0006\u0003\bä\u0001J\u0011\u0010å\u0001\u001a\n\u0012\u0005\u0012\u00030ç\u00010æ\u0001H\u0002J\u001b\u0010\u0012\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bó\u0001\u0010\u0016J\u001b\u0010\u0017\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bô\u0001\u0010\u0016J\u001b\u0010\u001a\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bõ\u0001\u0010\u0016J\u001b\u0010\u001d\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bö\u0001\u0010\u0016J\u001c\u0010÷\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bø\u0001\u0010\u0016J\u001c\u0010ù\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bú\u0001\u0010\u0016J\u001c\u0010û\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\bü\u0001\u0010\u0016J9\u0010û\u0001\u001a\u00030Í\u00012\b\u0010ý\u0001\u001a\u00030ò\u00012\u0007\u0010>\u001a\u00030ò\u00012\b\u0010þ\u0001\u001a\u00030ò\u00012\u0007\u0010D\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\bÿ\u0001\u0010\u0080\u0002J'\u0010û\u0001\u001a\u00030Í\u00012\b\u0010\u0081\u0002\u001a\u00030ò\u00012\b\u0010\u0082\u0002\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\b\u0083\u0002\u0010\u0084\u0002J\u001b\u0010 \u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u0085\u0002\u0010\u0016J\u001b\u0010#\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u0086\u0002\u0010\u0016J\u001b\u0010&\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u0087\u0002\u0010\u0016J\u001b\u0010)\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u0088\u0002\u0010\u0016J\u001c\u0010\u0089\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u008a\u0002\u0010\u0016J\u001c\u0010\u008b\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u008c\u0002\u0010\u0016J\u001c\u0010\u008d\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u008e\u0002\u0010\u0016J9\u0010\u008d\u0002\u001a\u00030Í\u00012\b\u0010ý\u0001\u001a\u00030ò\u00012\u0007\u0010>\u001a\u00030ò\u00012\b\u0010þ\u0001\u001a\u00030ò\u00012\u0007\u0010D\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\b\u008f\u0002\u0010\u0080\u0002J'\u0010\u008d\u0002\u001a\u00030Í\u00012\b\u0010\u0081\u0002\u001a\u00030ò\u00012\b\u0010\u0082\u0002\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\b\u0090\u0002\u0010\u0084\u0002J\u001b\u0010,\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u0091\u0002\u0010\u0016J\u001a\u0010S\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020TH\u0016¢\u0006\u0005\b\u0092\u0002\u0010XJ\u0012\u0010Z\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020[H\u0016J%\u0010\u0093\u0002\u001a\u00030Í\u00012\u0007\u0010/\u001a\u00030ò\u00012\u0007\u0010\u0094\u0002\u001a\u00020TH\u0016¢\u0006\u0006\b\u0095\u0002\u0010\u0096\u0002J%\u0010\u0093\u0002\u001a\u00030Í\u00012\u0007\u0010/\u001a\u00030ò\u00012\u0007\u0010\u0097\u0002\u001a\u00020[H\u0016¢\u0006\u0006\b\u0098\u0002\u0010\u0099\u0002J\u001b\u0010/\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u009a\u0002\u0010\u0016J\u001b\u00102\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u009b\u0002\u0010\u0016J%\u0010\u009c\u0002\u001a\u00030Í\u00012\u0007\u0010/\u001a\u00030ò\u00012\u0007\u00102\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\b\u009d\u0002\u0010\u0084\u0002J\u001c\u0010\u009c\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b\u009e\u0002\u0010\u0016J\u001c\u0010\u009c\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030\u009f\u0002H\u0016¢\u0006\u0005\b \u0002\u0010XJ\u0012\u0010/\u001a\u00030Í\u00012\u0007\u0010¡\u0002\u001a\u00020\fH\u0016J\u0012\u00102\u001a\u00030Í\u00012\u0007\u0010¡\u0002\u001a\u00020\fH\u0016J\u001b\u0010;\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b¢\u0002\u0010\u0016J\u001b\u0010>\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b£\u0002\u0010\u0016J\u001b\u0010A\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b¤\u0002\u0010\u0016J\u001b\u0010D\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b¥\u0002\u0010\u0016J\u001b\u0010M\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b¦\u0002\u0010\u0016J\u001b\u0010G\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b§\u0002\u0010\u0016J\u001c\u0010¨\u0002\u001a\u00030Í\u00012\b\u0010\u009c\u0002\u001a\u00030\u009f\u0002H\u0016¢\u0006\u0005\b©\u0002\u0010XJ%\u0010¨\u0002\u001a\u00030Í\u00012\u0007\u0010/\u001a\u00030ò\u00012\u0007\u00102\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\bª\u0002\u0010\u0084\u0002J\u001b\u0010P\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b«\u0002\u0010\u0016J\u001b\u0010J\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030ò\u0001H\u0016¢\u0006\u0005\b¬\u0002\u0010\u0016J\u001c\u0010\u00ad\u0002\u001a\u00030Í\u00012\b\u0010\u009c\u0002\u001a\u00030\u009f\u0002H\u0016¢\u0006\u0005\b®\u0002\u0010XJ%\u0010\u00ad\u0002\u001a\u00030Í\u00012\u0007\u0010/\u001a\u00030ò\u00012\u0007\u00102\u001a\u00030ò\u0001H\u0016¢\u0006\u0006\b¯\u0002\u0010\u0084\u0002J\u0012\u0010w\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0012\u0010z\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0012\u0010}\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0013\u0010°\u0002\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u0080\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u0083\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u001c\u0010±\u0002\u001a\u00030Í\u00012\u0007\u0010²\u0002\u001a\u00020\f2\u0007\u0010³\u0002\u001a\u00020\fH\u0016J\u001c\u0010±\u0002\u001a\u00030Í\u00012\b\u0010´\u0002\u001a\u00030µ\u0002H\u0016¢\u0006\u0005\b¶\u0002\u0010XJ\u0013\u0010\u0086\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u0089\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u008c\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u001c\u0010\u008f\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030\u0090\u0001H\u0016¢\u0006\u0005\b·\u0002\u0010XJ\u0012\u0010l\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010\u0096\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020\fH\u0016J\u001b\u0010¸\u0002\u001a\u00030Í\u00012\u0007\u0010\u0094\u0002\u001a\u00020TH\u0016¢\u0006\u0005\b¹\u0002\u0010XJ\u0013\u0010¸\u0002\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020[H\u0016J\u001b\u0010º\u0002\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020TH\u0016¢\u0006\u0005\b»\u0002\u0010XJ\u0013\u0010º\u0002\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020[H\u0016J\u0012\u0010q\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020rH\u0016J\u0014\u0010¼\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ö\u0001H\u0016J$\u0010¼\u0002\u001a\u00030Í\u00012\u000e\u0010½\u0002\u001a\t\u0012\u0004\u0012\u00020\f0¾\u00022\b\u0010ñ\u0001\u001a\u00030Ö\u0001H\u0016J4\u0010¼\u0002\u001a\u00030Í\u00012\u000e\u0010¿\u0002\u001a\t\u0012\u0004\u0012\u00020\f0¾\u00022\u000e\u0010À\u0002\u001a\t\u0012\u0004\u0012\u00020\f0¾\u00022\b\u0010ñ\u0001\u001a\u00030Ö\u0001H\u0016J\u0014\u0010Æ\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ï\u0002H\u0016J(\u0010Æ\u0002\u001a\u00030Í\u00012\u0016\u0010ñ\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030Ï\u00020Ð\u0002\"\u00030Ï\u0002H\u0016¢\u0006\u0003\u0010Ñ\u0002J\u0014\u0010Ì\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ï\u0002H\u0016J(\u0010Ì\u0002\u001a\u00030Í\u00012\u0016\u0010ñ\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030Ï\u00020Ð\u0002\"\u00030Ï\u0002H\u0016¢\u0006\u0003\u0010Ñ\u0002J\u0014\u0010Ò\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030â\u0001H\u0016J\u001b\u0010\u0099\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020TH\u0016¢\u0006\u0005\bì\u0002\u0010XJ\u0013\u0010\u009c\u0001\u001a\u00030Í\u00012\u0007\u0010ñ\u0001\u001a\u00020[H\u0016J\u0014\u0010è\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030é\u0002H\u0016J\u0014\u0010\u009f\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030 \u0001H\u0016J\u0014\u0010¥\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030¦\u0001H\u0016J\u001c\u0010«\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030¬\u0001H\u0016¢\u0006\u0005\bí\u0002\u0010XJ\u001c\u0010¯\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030¬\u0001H\u0016¢\u0006\u0005\bî\u0002\u0010XJ\u001c\u0010²\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030¬\u0001H\u0016¢\u0006\u0005\bï\u0002\u0010XJ\u001c\u0010µ\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030¶\u0001H\u0016¢\u0006\u0005\bð\u0002\u0010\u0016J\u001d\u0010º\u0001\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030»\u0001H\u0016¢\u0006\u0006\bñ\u0002\u0010¿\u0001J\u001d\u0010Ó\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ô\u0002H\u0016¢\u0006\u0006\bò\u0002\u0010¿\u0001J\u001d\u0010Ö\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030×\u0002H\u0016¢\u0006\u0006\bó\u0002\u0010¿\u0001J\u001d\u0010Ù\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ú\u0002H\u0016¢\u0006\u0006\bô\u0002\u0010¿\u0001J\u001d\u0010Ü\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030Ý\u0002H\u0016¢\u0006\u0006\bõ\u0002\u0010¿\u0001J\u0014\u0010ß\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030à\u0002H\u0016J\u001d\u0010å\u0002\u001a\u00030Í\u00012\b\u0010ñ\u0001\u001a\u00030æ\u0002H\u0016¢\u0006\u0006\bö\u0002\u0010¿\u0001Ju\u0010Û\u0001\u001a\u00030Í\u0001\"\u0005\b\u0000\u0010Â\u00022\u000f\u0010÷\u0002\u001a\n\u0012\u0005\u0012\u0003HÂ\u00020ø\u00022\b\u0010ñ\u0001\u001a\u00030Ö\u00012G\u0010ù\u0002\u001aB\u0012\u001e\u0012\u001c\u0012\u0005\u0012\u0003HÂ\u00020ø\u0002¢\u0006\u000f\bû\u0002\u0012\n\bü\u0002\u0012\u0005\b\b(÷\u0002\u0012\u0017\u0012\u00150Ü\u0001¢\u0006\u000f\bû\u0002\u0012\n\bü\u0002\u0012\u0005\b\b(Û\u0001\u0012\u0004\u0012\u00020\u000f0ú\u0002H\u0016J*\u0010ý\u0002\u001a\u00030Í\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010×\u0001\u001a\u00030Ø\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0003\bþ\u0002J\u0010\u0010ÿ\u0002\u001a\u00030Í\u0001H\u0000¢\u0006\u0003\b\u0080\u0003J\u0012\u0010\u0081\u0003\u001a\u00020\t2\u0007\u0010\u0082\u0003\u001a\u00020\u0006H\u0002J%\u0010\u0083\u0003\u001a\u00030Í\u00012\u0007\u0010÷\u0002\u001a\u00020\u00062\u000f\u0010\u0084\u0003\u001a\n\u0012\u0005\u0012\u00030Í\u00010\u0085\u0003H\u0082\bJ&\u0010\u0083\u0003\u001a\u00030Í\u00012\u0007\u0010÷\u0002\u001a\u00020\u00062\u0007\u0010ù\u0002\u001a\u00020\u000f2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002J\u000b\u0010\u0086\u0003\u001a\u00030Í\u0001H\u0082\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010)\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001a\u0010/\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016R\u001a\u00102\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u001a\u00105\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u0016R\u001a\u00108\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u0010\u0016R\u001a\u0010;\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010\u0016R\u001a\u0010>\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R\u001a\u0010A\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0014\"\u0004\bC\u0010\u0016R\u001a\u0010D\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0014\"\u0004\bF\u0010\u0016R\u001a\u0010G\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010\u0016R\u001a\u0010J\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0014\"\u0004\bL\u0010\u0016R\u001a\u0010M\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0014\"\u0004\bO\u0010\u0016R\u001a\u0010P\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0014\"\u0004\bR\u0010\u0016R\u001c\u0010S\u001a\u00020TX\u0080\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Z\u001a\u0004\u0018\u00010[X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001c\u0010`\u001a\u00020TX\u0080\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\ba\u0010V\"\u0004\bb\u0010XR\u001c\u0010c\u001a\u0004\u0018\u00010[X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010]\"\u0004\be\u0010_R\u001c\u0010f\u001a\u00020TX\u0080\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\bg\u0010V\"\u0004\bh\u0010XR\u001c\u0010i\u001a\u0004\u0018\u00010[X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010]\"\u0004\bk\u0010_R\u001a\u0010l\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001a\u0010w\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0014\"\u0004\by\u0010\u0016R\u001a\u0010z\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0014\"\u0004\b|\u0010\u0016R\u001a\u0010}\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0014\"\u0004\b\u007f\u0010\u0016R\u001d\u0010\u0080\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0014\"\u0005\b\u0082\u0001\u0010\u0016R\u001d\u0010\u0083\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0014\"\u0005\b\u0085\u0001\u0010\u0016R\u001d\u0010\u0086\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0014\"\u0005\b\u0088\u0001\u0010\u0016R\u001d\u0010\u0089\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\u0014\"\u0005\b\u008b\u0001\u0010\u0016R\u001d\u0010\u008c\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u0014\"\u0005\b\u008e\u0001\u0010\u0016R \u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0080\u000e¢\u0006\u0012\n\u0002\u0010Y\u001a\u0005\b\u0091\u0001\u0010V\"\u0005\b\u0092\u0001\u0010XR\u001d\u0010\u0093\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0014\"\u0005\b\u0095\u0001\u0010\u0016R\u001d\u0010\u0096\u0001\u001a\u00020\fX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0014\"\u0005\b\u0098\u0001\u0010\u0016R\u001f\u0010\u0099\u0001\u001a\u00020TX\u0080\u000e¢\u0006\u0012\n\u0002\u0010Y\u001a\u0005\b\u009a\u0001\u0010V\"\u0005\b\u009b\u0001\u0010XR\u001f\u0010\u009c\u0001\u001a\u0004\u0018\u00010[X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010]\"\u0005\b\u009e\u0001\u0010_R\"\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\"\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R \u0010«\u0001\u001a\u00030¬\u0001X\u0080\u000e¢\u0006\u0012\n\u0002\u0010Y\u001a\u0005\b\u00ad\u0001\u0010V\"\u0005\b®\u0001\u0010XR \u0010¯\u0001\u001a\u00030¬\u0001X\u0080\u000e¢\u0006\u0012\n\u0002\u0010Y\u001a\u0005\b°\u0001\u0010V\"\u0005\b±\u0001\u0010XR \u0010²\u0001\u001a\u00030¬\u0001X\u0080\u000e¢\u0006\u0012\n\u0002\u0010Y\u001a\u0005\b³\u0001\u0010V\"\u0005\b´\u0001\u0010XR!\u0010µ\u0001\u001a\u00030¶\u0001X\u0080\u000e¢\u0006\u0013\n\u0003\u0010¹\u0001\u001a\u0005\b·\u0001\u0010\u0014\"\u0005\b¸\u0001\u0010\u0016R#\u0010º\u0001\u001a\u00030»\u0001X\u0080\u000e¢\u0006\u0015\n\u0003\u0010À\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R\u001f\u0010Á\u0001\u001a\u00020\u0006X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÂ\u0001\u0010½\u0001\"\u0006\bÃ\u0001\u0010¿\u0001R\u001f\u0010è\u0001\u001a\n\u0012\u0005\u0012\u00030ç\u00010é\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bê\u0001\u0010ë\u0001R\u0016\u0010×\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bì\u0001\u0010\u0014R\u0016\u0010í\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bî\u0001\u0010\u0014R\u0018\u0010Û\u0001\u001a\u00030Ü\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bï\u0001\u0010ð\u0001R+\u0010Á\u0002\u001a\u0003HÂ\u0002\"\u0005\b\u0000\u0010Â\u0002*\n\u0012\u0005\u0012\u0003HÂ\u00020Ã\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÄ\u0002\u0010Å\u0002R\"\u0010Æ\u0002\u001a\u0005\u0018\u00010Ç\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0002\u0010É\u0002\"\u0006\bÊ\u0002\u0010Ë\u0002R\"\u0010Ì\u0002\u001a\u0005\u0018\u00010Ç\u0002X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÍ\u0002\u0010É\u0002\"\u0006\bÎ\u0002\u0010Ë\u0002R\u0018\u0010Ó\u0002\u001a\u00030Ô\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bÕ\u0002\u0010½\u0001R\u0018\u0010Ö\u0002\u001a\u00030×\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bØ\u0002\u0010½\u0001R\u0018\u0010Ù\u0002\u001a\u00030Ú\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bÛ\u0002\u0010½\u0001R\u0018\u0010Ü\u0002\u001a\u00030Ý\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bÞ\u0002\u0010½\u0001R\u0018\u0010ß\u0002\u001a\u00030à\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bá\u0002\u0010â\u0002R\u0016\u0010ã\u0002\u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bä\u0002\u0010nR\u0018\u0010å\u0002\u001a\u00030æ\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bç\u0002\u0010½\u0001R\u0018\u0010è\u0002\u001a\u00030é\u00028@X\u0080\u0004¢\u0006\b\u001a\u0006\bê\u0002\u0010ë\u0002R\u0018\u0010\u0087\u0003\u001a\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\b\u0088\u0003\u0010½\u0001¨\u0006\u0089\u0003"}, d2 = {"Landroidx/compose/foundation/style/ResolvedStyle;", "Landroidx/compose/foundation/style/StyleScope;", "Landroidx/compose/ui/platform/InspectableValue;", "<init>", "()V", "compositeHash", "", "currentIndex", "indexStack", "Landroidx/collection/MutableIntList;", "flags", "_density", "", "_fontScale", "animating", "", NodeElement.ELEMENT, "Landroidx/compose/foundation/style/StyleOuterNode;", "contentPaddingStart", "getContentPaddingStart$foundation", "()F", "setContentPaddingStart$foundation", "(F)V", "contentPaddingEnd", "getContentPaddingEnd$foundation", "setContentPaddingEnd$foundation", "contentPaddingTop", "getContentPaddingTop$foundation", "setContentPaddingTop$foundation", "contentPaddingBottom", "getContentPaddingBottom$foundation", "setContentPaddingBottom$foundation", "externalPaddingStart", "getExternalPaddingStart$foundation", "setExternalPaddingStart$foundation", "externalPaddingEnd", "getExternalPaddingEnd$foundation", "setExternalPaddingEnd$foundation", "externalPaddingTop", "getExternalPaddingTop$foundation", "setExternalPaddingTop$foundation", "externalPaddingBottom", "getExternalPaddingBottom$foundation", "setExternalPaddingBottom$foundation", "borderWidth", "getBorderWidth$foundation", "setBorderWidth$foundation", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth$foundation", "setWidth$foundation", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "getHeight$foundation", "setHeight$foundation", "widthFraction", "getWidthFraction$foundation", "setWidthFraction$foundation", "heightFraction", "getHeightFraction$foundation", "setHeightFraction$foundation", "left", "getLeft$foundation", "setLeft$foundation", ViewHierarchyConstants.DIMENSION_TOP_KEY, "getTop$foundation", "setTop$foundation", "right", "getRight$foundation", "setRight$foundation", "bottom", "getBottom$foundation", "setBottom$foundation", "minHeight", "getMinHeight$foundation", "setMinHeight$foundation", "maxHeight", "getMaxHeight$foundation", "setMaxHeight$foundation", "minWidth", "getMinWidth$foundation", "setMinWidth$foundation", "maxWidth", "getMaxWidth$foundation", "setMaxWidth$foundation", "borderColor", "Landroidx/compose/ui/graphics/Color;", "getBorderColor-0d7_KjU$foundation", "()J", "setBorderColor-8_81llA$foundation", "(J)V", "J", "borderBrush", "Landroidx/compose/ui/graphics/Brush;", "getBorderBrush$foundation", "()Landroidx/compose/ui/graphics/Brush;", "setBorderBrush$foundation", "(Landroidx/compose/ui/graphics/Brush;)V", "backgroundColor", "getBackgroundColor-0d7_KjU$foundation", "setBackgroundColor-8_81llA$foundation", "backgroundBrush", "getBackgroundBrush$foundation", "setBackgroundBrush$foundation", "foregroundColor", "getForegroundColor-0d7_KjU$foundation", "setForegroundColor-8_81llA$foundation", "foregroundBrush", "getForegroundBrush$foundation", "setForegroundBrush$foundation", "clip", "getClip$foundation", "()Z", "setClip$foundation", "(Z)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape$foundation", "()Landroidx/compose/ui/graphics/Shape;", "setShape$foundation", "(Landroidx/compose/ui/graphics/Shape;)V", "alpha", "getAlpha$foundation", "setAlpha$foundation", "scaleX", "getScaleX$foundation", "setScaleX$foundation", "scaleY", "getScaleY$foundation", "setScaleY$foundation", "translationX", "getTranslationX$foundation", "setTranslationX$foundation", "translationY", "getTranslationY$foundation", "setTranslationY$foundation", "rotationX", "getRotationX$foundation", "setRotationX$foundation", "rotationY", "getRotationY$foundation", "setRotationY$foundation", "rotationZ", "getRotationZ$foundation", "setRotationZ$foundation", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ$foundation", "setTransformOrigin-__ExYCQ$foundation", "cameraDistance", "getCameraDistance$foundation", "setCameraDistance$foundation", "zIndex", "getZIndex$foundation", "setZIndex$foundation", "contentColor", "getContentColor-0d7_KjU$foundation", "setContentColor-8_81llA$foundation", "contentBrush", "getContentBrush$foundation", "setContentBrush$foundation", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily$foundation", "()Landroidx/compose/ui/text/font/FontFamily;", "setFontFamily$foundation", "(Landroidx/compose/ui/text/font/FontFamily;)V", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "getTextIndent$foundation", "()Landroidx/compose/ui/text/style/TextIndent;", "setTextIndent$foundation", "(Landroidx/compose/ui/text/style/TextIndent;)V", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "getFontSize-XSAIIZE$foundation", "setFontSize--R2X_6o$foundation", "lineHeight", "getLineHeight-XSAIIZE$foundation", "setLineHeight--R2X_6o$foundation", "letterSpacing", "getLetterSpacing-XSAIIZE$foundation", "setLetterSpacing--R2X_6o$foundation", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "getBaselineShift-y9eOQZs$foundation", "setBaselineShift-4Dl_Bck$foundation", "F", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "getLineBreak-rAG3T2k$foundation", "()I", "setLineBreak-CZqVlQI$foundation", "(I)V", "I", "textEnums", "getTextEnums$foundation", "setTextEnums$foundation", "diff", "other", "filterFlags", "diff$foundation", Constants.COPY_TYPE, "copy$foundation", "copyInheritedStyles", "copyInheritedStyles$foundation", "copyInheritedStylesInto", "", TypedValues.AttributesType.S_TARGET, "copyInheritedStylesInto$foundation", "copyInto", "copyInto$foundation", FasteningElement.ATTR_CLEAR, "clear$foundation", "resolve", "style", "Landroidx/compose/foundation/style/Style;", "density", "Landroidx/compose/ui/unit/Density;", "resolve$foundation", "resolveForTesting", "state", "Landroidx/compose/foundation/style/StyleState;", "resolveForTesting$foundation", "applyInheritableStyles", "source", "applyInheritableStyles$foundation", "toTextStyle", "Landroidx/compose/ui/text/TextStyle;", FallbackIndicationElement.ELEMENT, "toTextStyle$foundation", "valueElements", "", "Landroidx/compose/ui/platform/ValueElement;", "inspectableElements", "Lkotlin/sequences/Sequence;", "getInspectableElements", "()Lkotlin/sequences/Sequence;", "getDensity", "fontScale", "getFontScale", "getState", "()Landroidx/compose/foundation/style/StyleState;", "value", "Landroidx/compose/ui/unit/Dp;", "contentPaddingStart-0680j_4", "contentPaddingEnd-0680j_4", "contentPaddingTop-0680j_4", "contentPaddingBottom-0680j_4", "contentPaddingHorizontal", "contentPaddingHorizontal-0680j_4", "contentPaddingVertical", "contentPaddingVertical-0680j_4", "contentPadding", "contentPadding-0680j_4", "start", "end", "contentPadding-a9UjIt4", "(FFFF)V", "horizontal", "vertical", "contentPadding-YgX7TsA", "(FF)V", "externalPaddingStart-0680j_4", "externalPaddingEnd-0680j_4", "externalPaddingTop-0680j_4", "externalPaddingBottom-0680j_4", "externalPaddingHorizontal", "externalPaddingHorizontal-0680j_4", "externalPaddingVertical", "externalPaddingVertical-0680j_4", "externalPadding", "externalPadding-0680j_4", "externalPadding-a9UjIt4", "externalPadding-YgX7TsA", "borderWidth-0680j_4", "borderColor-8_81llA", Constants.KEY_BORDER, "color", "border-cXLIe8U", "(FJ)V", "brush", "border-D5KLDUw", "(FLandroidx/compose/ui/graphics/Brush;)V", "width-0680j_4", "height-0680j_4", "size", "size-YgX7TsA", "size-0680j_4", "Landroidx/compose/ui/unit/DpSize;", "size-EaSLcWc", "fraction", "left-0680j_4", "top-0680j_4", "right-0680j_4", "bottom-0680j_4", "minWidth-0680j_4", "minHeight-0680j_4", SDKConstants.PARAM_CONTEXT_MIN_SIZE, "minSize-EaSLcWc", "minSize-YgX7TsA", "maxWidth-0680j_4", "maxHeight-0680j_4", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "maxSize-EaSLcWc", "maxSize-YgX7TsA", CropImage.SCALE, "translation", "x", "y", "offset", "Landroidx/compose/ui/geometry/Offset;", "translation-k-4lQ0M", "transformOrigin-__ExYCQ", "background", "background-8_81llA", "foreground", "foreground-8_81llA", "animate", "spec", "Landroidx/compose/animation/core/AnimationSpec;", "toSpec", "fromSpec", "currentValue", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/CompositionLocal;", "getCurrentValue", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "dropShadow", "", "getDropShadow$foundation", "()Ljava/lang/Object;", "setDropShadow$foundation", "(Ljava/lang/Object;)V", "innerShadow", "getInnerShadow$foundation", "setInnerShadow$foundation", "Landroidx/compose/ui/graphics/shadow/Shadow;", "", "([Landroidx/compose/ui/graphics/shadow/Shadow;)V", "textStyle", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "getFontStyle-_-LCdwA$foundation", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "getTextAlign-e0LSkKk$foundation", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "getTextDirection-s_7X-co$foundation", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "getHyphens-vmbZdU8$foundation", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "getFontWeight$foundation", "()Landroidx/compose/ui/text/font/FontWeight;", "isFontWeightSpecified", "isFontWeightSpecified$foundation", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getFontSynthesis-GVVA2EU$foundation", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "getTextDecoration$foundation", "()Landroidx/compose/ui/text/style/TextDecoration;", "contentColor-8_81llA", "fontSize--R2X_6o", "lineHeight--R2X_6o", "letterSpacing--R2X_6o", "baselineShift-4Dl_Bck", "lineBreak-CZqVlQI", "fontStyle-nzbMABs", "textAlign-aXe7zB0", "textDirection-Hejc4pk", "hyphens--3fSNIE", "fontSynthesis-6p3vJLY", "key", "Landroidx/compose/foundation/style/StyleStateKey;", "active", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startResolve", "startResolve$foundation", "doneResolve", "doneResolve$foundation", "pushIndex", FirebaseAnalytics.Param.INDEX, "group", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "skippedGroup", "currentCompositeHash", "getCurrentCompositeHash", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResolvedStyle implements StyleScope, InspectableValue {
    public static final int $stable = 0;
    private boolean animating;
    private Brush backgroundBrush;
    private Brush borderBrush;
    private float borderWidth;
    private boolean clip;
    private int compositeHash;
    private Brush contentBrush;
    private float contentPaddingBottom;
    private float contentPaddingEnd;
    private float contentPaddingStart;
    private float contentPaddingTop;
    private int currentIndex;
    private Object dropShadow;
    private float externalPaddingBottom;
    private float externalPaddingEnd;
    private float externalPaddingStart;
    private float externalPaddingTop;
    public int flags;
    private FontFamily fontFamily;
    private Brush foregroundBrush;
    private MutableIntList indexStack;
    private Object innerShadow;
    private StyleOuterNode node;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private int textEnums;
    private TextIndent textIndent;
    private float translationX;
    private float translationY;
    private float zIndex;
    private float _density = 1.0f;
    private float _fontScale = 1.0f;
    private float width = Float.NaN;
    private float height = Float.NaN;
    private float widthFraction = Float.NaN;
    private float heightFraction = Float.NaN;
    private float left = Float.NaN;
    private float top = Float.NaN;
    private float right = Float.NaN;
    private float bottom = Float.NaN;
    private float minHeight = Float.NaN;
    private float maxHeight = Float.NaN;
    private float minWidth = Float.NaN;
    private float maxWidth = Float.NaN;
    private long borderColor = Color.INSTANCE.m5994getBlack0d7_KjU();
    private long backgroundColor = Color.INSTANCE.m6003getTransparent0d7_KjU();
    private long foregroundColor = Color.INSTANCE.m6004getUnspecified0d7_KjU();
    private Shape shape = RectangleShapeKt.getRectangleShape();
    private float alpha = 1.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private long transformOrigin = TransformOrigin.INSTANCE.m6383getCenterSzJe1aQ();
    private float cameraDistance = 1.0f;
    private long contentColor = Color.INSTANCE.m6004getUnspecified0d7_KjU();
    private long fontSize = TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE();
    private long lineHeight = TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE();
    private long letterSpacing = TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE();
    private float baselineShift = BaselineShift.INSTANCE.m8584getUnspecifiedy9eOQZs();
    private int lineBreak = LineBreak.INSTANCE.m8626getUnspecifiedrAG3T2k();

    /* JADX INFO: renamed from: getContentPaddingStart$foundation, reason: from getter */
    public final float getContentPaddingStart() {
        return this.contentPaddingStart;
    }

    public final void setContentPaddingStart$foundation(float f2) {
        this.contentPaddingStart = f2;
    }

    /* JADX INFO: renamed from: getContentPaddingEnd$foundation, reason: from getter */
    public final float getContentPaddingEnd() {
        return this.contentPaddingEnd;
    }

    public final void setContentPaddingEnd$foundation(float f2) {
        this.contentPaddingEnd = f2;
    }

    /* JADX INFO: renamed from: getContentPaddingTop$foundation, reason: from getter */
    public final float getContentPaddingTop() {
        return this.contentPaddingTop;
    }

    public final void setContentPaddingTop$foundation(float f2) {
        this.contentPaddingTop = f2;
    }

    /* JADX INFO: renamed from: getContentPaddingBottom$foundation, reason: from getter */
    public final float getContentPaddingBottom() {
        return this.contentPaddingBottom;
    }

    public final void setContentPaddingBottom$foundation(float f2) {
        this.contentPaddingBottom = f2;
    }

    /* JADX INFO: renamed from: getExternalPaddingStart$foundation, reason: from getter */
    public final float getExternalPaddingStart() {
        return this.externalPaddingStart;
    }

    public final void setExternalPaddingStart$foundation(float f2) {
        this.externalPaddingStart = f2;
    }

    /* JADX INFO: renamed from: getExternalPaddingEnd$foundation, reason: from getter */
    public final float getExternalPaddingEnd() {
        return this.externalPaddingEnd;
    }

    public final void setExternalPaddingEnd$foundation(float f2) {
        this.externalPaddingEnd = f2;
    }

    /* JADX INFO: renamed from: getExternalPaddingTop$foundation, reason: from getter */
    public final float getExternalPaddingTop() {
        return this.externalPaddingTop;
    }

    public final void setExternalPaddingTop$foundation(float f2) {
        this.externalPaddingTop = f2;
    }

    /* JADX INFO: renamed from: getExternalPaddingBottom$foundation, reason: from getter */
    public final float getExternalPaddingBottom() {
        return this.externalPaddingBottom;
    }

    public final void setExternalPaddingBottom$foundation(float f2) {
        this.externalPaddingBottom = f2;
    }

    /* JADX INFO: renamed from: getBorderWidth$foundation, reason: from getter */
    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final void setBorderWidth$foundation(float f2) {
        this.borderWidth = f2;
    }

    /* JADX INFO: renamed from: getWidth$foundation, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    public final void setWidth$foundation(float f2) {
        this.width = f2;
    }

    /* JADX INFO: renamed from: getHeight$foundation, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    public final void setHeight$foundation(float f2) {
        this.height = f2;
    }

    /* JADX INFO: renamed from: getWidthFraction$foundation, reason: from getter */
    public final float getWidthFraction() {
        return this.widthFraction;
    }

    public final void setWidthFraction$foundation(float f2) {
        this.widthFraction = f2;
    }

    /* JADX INFO: renamed from: getHeightFraction$foundation, reason: from getter */
    public final float getHeightFraction() {
        return this.heightFraction;
    }

    public final void setHeightFraction$foundation(float f2) {
        this.heightFraction = f2;
    }

    /* JADX INFO: renamed from: getLeft$foundation, reason: from getter */
    public final float getLeft() {
        return this.left;
    }

    public final void setLeft$foundation(float f2) {
        this.left = f2;
    }

    /* JADX INFO: renamed from: getTop$foundation, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    public final void setTop$foundation(float f2) {
        this.top = f2;
    }

    /* JADX INFO: renamed from: getRight$foundation, reason: from getter */
    public final float getRight() {
        return this.right;
    }

    public final void setRight$foundation(float f2) {
        this.right = f2;
    }

    /* JADX INFO: renamed from: getBottom$foundation, reason: from getter */
    public final float getBottom() {
        return this.bottom;
    }

    public final void setBottom$foundation(float f2) {
        this.bottom = f2;
    }

    /* JADX INFO: renamed from: getMinHeight$foundation, reason: from getter */
    public final float getMinHeight() {
        return this.minHeight;
    }

    public final void setMinHeight$foundation(float f2) {
        this.minHeight = f2;
    }

    /* JADX INFO: renamed from: getMaxHeight$foundation, reason: from getter */
    public final float getMaxHeight() {
        return this.maxHeight;
    }

    public final void setMaxHeight$foundation(float f2) {
        this.maxHeight = f2;
    }

    /* JADX INFO: renamed from: getMinWidth$foundation, reason: from getter */
    public final float getMinWidth() {
        return this.minWidth;
    }

    public final void setMinWidth$foundation(float f2) {
        this.minWidth = f2;
    }

    /* JADX INFO: renamed from: getMaxWidth$foundation, reason: from getter */
    public final float getMaxWidth() {
        return this.maxWidth;
    }

    public final void setMaxWidth$foundation(float f2) {
        this.maxWidth = f2;
    }

    /* JADX INFO: renamed from: getBorderColor-0d7_KjU$foundation, reason: not valid java name and from getter */
    public final long getBorderColor() {
        return this.borderColor;
    }

    /* JADX INFO: renamed from: setBorderColor-8_81llA$foundation, reason: not valid java name */
    public final void m1597setBorderColor8_81llA$foundation(long j) {
        this.borderColor = j;
    }

    /* JADX INFO: renamed from: getBorderBrush$foundation, reason: from getter */
    public final Brush getBorderBrush() {
        return this.borderBrush;
    }

    public final void setBorderBrush$foundation(Brush brush) {
        this.borderBrush = brush;
    }

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU$foundation, reason: not valid java name and from getter */
    public final long getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: setBackgroundColor-8_81llA$foundation, reason: not valid java name */
    public final void m1595setBackgroundColor8_81llA$foundation(long j) {
        this.backgroundColor = j;
    }

    /* JADX INFO: renamed from: getBackgroundBrush$foundation, reason: from getter */
    public final Brush getBackgroundBrush() {
        return this.backgroundBrush;
    }

    public final void setBackgroundBrush$foundation(Brush brush) {
        this.backgroundBrush = brush;
    }

    /* JADX INFO: renamed from: getForegroundColor-0d7_KjU$foundation, reason: not valid java name and from getter */
    public final long getForegroundColor() {
        return this.foregroundColor;
    }

    /* JADX INFO: renamed from: setForegroundColor-8_81llA$foundation, reason: not valid java name */
    public final void m1600setForegroundColor8_81llA$foundation(long j) {
        this.foregroundColor = j;
    }

    /* JADX INFO: renamed from: getForegroundBrush$foundation, reason: from getter */
    public final Brush getForegroundBrush() {
        return this.foregroundBrush;
    }

    public final void setForegroundBrush$foundation(Brush brush) {
        this.foregroundBrush = brush;
    }

    /* JADX INFO: renamed from: getClip$foundation, reason: from getter */
    public final boolean getClip() {
        return this.clip;
    }

    public final void setClip$foundation(boolean z) {
        this.clip = z;
    }

    /* JADX INFO: renamed from: getShape$foundation, reason: from getter */
    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape$foundation(Shape shape) {
        this.shape = shape;
    }

    /* JADX INFO: renamed from: getAlpha$foundation, reason: from getter */
    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha$foundation(float f2) {
        this.alpha = f2;
    }

    /* JADX INFO: renamed from: getScaleX$foundation, reason: from getter */
    public final float getScaleX() {
        return this.scaleX;
    }

    public final void setScaleX$foundation(float f2) {
        this.scaleX = f2;
    }

    /* JADX INFO: renamed from: getScaleY$foundation, reason: from getter */
    public final float getScaleY() {
        return this.scaleY;
    }

    public final void setScaleY$foundation(float f2) {
        this.scaleY = f2;
    }

    /* JADX INFO: renamed from: getTranslationX$foundation, reason: from getter */
    public final float getTranslationX() {
        return this.translationX;
    }

    public final void setTranslationX$foundation(float f2) {
        this.translationX = f2;
    }

    /* JADX INFO: renamed from: getTranslationY$foundation, reason: from getter */
    public final float getTranslationY() {
        return this.translationY;
    }

    public final void setTranslationY$foundation(float f2) {
        this.translationY = f2;
    }

    /* JADX INFO: renamed from: getRotationX$foundation, reason: from getter */
    public final float getRotationX() {
        return this.rotationX;
    }

    public final void setRotationX$foundation(float f2) {
        this.rotationX = f2;
    }

    /* JADX INFO: renamed from: getRotationY$foundation, reason: from getter */
    public final float getRotationY() {
        return this.rotationY;
    }

    public final void setRotationY$foundation(float f2) {
        this.rotationY = f2;
    }

    /* JADX INFO: renamed from: getRotationZ$foundation, reason: from getter */
    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final void setRotationZ$foundation(float f2) {
        this.rotationZ = f2;
    }

    /* JADX INFO: renamed from: getTransformOrigin-SzJe1aQ$foundation, reason: not valid java name and from getter */
    public final long getTransformOrigin() {
        return this.transformOrigin;
    }

    /* JADX INFO: renamed from: setTransformOrigin-__ExYCQ$foundation, reason: not valid java name */
    public final void m1604setTransformOrigin__ExYCQ$foundation(long j) {
        this.transformOrigin = j;
    }

    /* JADX INFO: renamed from: getCameraDistance$foundation, reason: from getter */
    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    public final void setCameraDistance$foundation(float f2) {
        this.cameraDistance = f2;
    }

    /* JADX INFO: renamed from: getZIndex$foundation, reason: from getter */
    public final float getZIndex() {
        return this.zIndex;
    }

    public final void setZIndex$foundation(float f2) {
        this.zIndex = f2;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU$foundation, reason: not valid java name and from getter */
    public final long getContentColor() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: setContentColor-8_81llA$foundation, reason: not valid java name */
    public final void m1598setContentColor8_81llA$foundation(long j) {
        this.contentColor = j;
    }

    /* JADX INFO: renamed from: getContentBrush$foundation, reason: from getter */
    public final Brush getContentBrush() {
        return this.contentBrush;
    }

    public final void setContentBrush$foundation(Brush brush) {
        this.contentBrush = brush;
    }

    /* JADX INFO: renamed from: getFontFamily$foundation, reason: from getter */
    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final void setFontFamily$foundation(FontFamily fontFamily) {
        this.fontFamily = fontFamily;
    }

    /* JADX INFO: renamed from: getTextIndent$foundation, reason: from getter */
    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public final void setTextIndent$foundation(TextIndent textIndent) {
        this.textIndent = textIndent;
    }

    /* JADX INFO: renamed from: getFontSize-XSAIIZE$foundation, reason: not valid java name and from getter */
    public final long getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: setFontSize--R2X_6o$foundation, reason: not valid java name */
    public final void m1599setFontSizeR2X_6o$foundation(long j) {
        this.fontSize = j;
    }

    /* JADX INFO: renamed from: getLineHeight-XSAIIZE$foundation, reason: not valid java name and from getter */
    public final long getLineHeight() {
        return this.lineHeight;
    }

    /* JADX INFO: renamed from: setLineHeight--R2X_6o$foundation, reason: not valid java name */
    public final void m1603setLineHeightR2X_6o$foundation(long j) {
        this.lineHeight = j;
    }

    /* JADX INFO: renamed from: getLetterSpacing-XSAIIZE$foundation, reason: not valid java name and from getter */
    public final long getLetterSpacing() {
        return this.letterSpacing;
    }

    /* JADX INFO: renamed from: setLetterSpacing--R2X_6o$foundation, reason: not valid java name */
    public final void m1601setLetterSpacingR2X_6o$foundation(long j) {
        this.letterSpacing = j;
    }

    /* JADX INFO: renamed from: getBaselineShift-y9eOQZs$foundation, reason: not valid java name and from getter */
    public final float getBaselineShift() {
        return this.baselineShift;
    }

    /* JADX INFO: renamed from: setBaselineShift-4Dl_Bck$foundation, reason: not valid java name */
    public final void m1596setBaselineShift4Dl_Bck$foundation(float f2) {
        this.baselineShift = f2;
    }

    /* JADX INFO: renamed from: getLineBreak-rAG3T2k$foundation, reason: not valid java name and from getter */
    public final int getLineBreak() {
        return this.lineBreak;
    }

    /* JADX INFO: renamed from: setLineBreak-CZqVlQI$foundation, reason: not valid java name */
    public final void m1602setLineBreakCZqVlQI$foundation(int i) {
        this.lineBreak = i;
    }

    /* JADX INFO: renamed from: getTextEnums$foundation, reason: from getter */
    public final int getTextEnums() {
        return this.textEnums;
    }

    public final void setTextEnums$foundation(int i) {
        this.textEnums = i;
    }

    public static /* synthetic */ int diff$foundation$default(ResolvedStyle resolvedStyle, ResolvedStyle resolvedStyle2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return resolvedStyle.diff$foundation(resolvedStyle2, i);
    }

    public final int diff$foundation(ResolvedStyle other, int filterFlags) {
        int i = this.flags;
        int i2 = other.flags;
        int i3 = i ^ i2;
        int i4 = filterFlags & i & i2;
        if ((i4 & 1) != 0 && (this.contentPaddingStart != other.contentPaddingStart || this.contentPaddingEnd != other.contentPaddingEnd || this.contentPaddingTop != other.contentPaddingTop || this.contentPaddingBottom != other.contentPaddingBottom || this.borderWidth != other.borderWidth)) {
            i3 |= 1;
        }
        if ((i4 & 8) != 0 && (this.width != other.width || this.height != other.height || this.widthFraction != other.widthFraction || this.heightFraction != other.heightFraction || this.externalPaddingStart != other.externalPaddingStart || this.externalPaddingEnd != other.externalPaddingEnd || this.externalPaddingTop != other.externalPaddingTop || this.externalPaddingBottom != other.externalPaddingBottom || Float.floatToRawIntBits(this.left) != Float.floatToRawIntBits(other.left) || Float.floatToRawIntBits(this.top) != Float.floatToRawIntBits(other.top) || Float.floatToRawIntBits(this.right) != Float.floatToRawIntBits(other.right) || Float.floatToRawIntBits(this.bottom) != Float.floatToRawIntBits(other.bottom) || Float.floatToRawIntBits(this.minWidth) != Float.floatToRawIntBits(other.minWidth) || Float.floatToRawIntBits(this.maxWidth) != Float.floatToRawIntBits(other.maxWidth) || Float.floatToRawIntBits(this.minHeight) != Float.floatToRawIntBits(other.minHeight) || Float.floatToRawIntBits(this.maxHeight) != Float.floatToRawIntBits(other.maxHeight))) {
            i3 |= 8;
        }
        if ((i4 & 2) != 0 && (this.borderWidth != other.borderWidth || !Color.m5969equalsimpl0(this.borderColor, other.borderColor) || !Intrinsics.areEqual(this.borderBrush, other.borderBrush) || !Color.m5969equalsimpl0(this.backgroundColor, other.backgroundColor) || !Intrinsics.areEqual(this.backgroundBrush, other.backgroundBrush) || !Intrinsics.areEqual(this.foregroundBrush, other.foregroundBrush) || !Intrinsics.areEqual(this.innerShadow, other.innerShadow) || !Intrinsics.areEqual(this.dropShadow, other.dropShadow) || !Intrinsics.areEqual(this.shape, other.shape))) {
            i3 |= 2;
        }
        if ((i4 & 4) != 0 && (this.alpha != other.alpha || this.scaleX != other.scaleX || this.scaleY != other.scaleY || this.translationX != other.translationX || this.translationY != other.translationY || this.rotationX != other.rotationX || this.rotationY != other.rotationY || this.rotationZ != other.rotationZ || !TransformOrigin.m6377equalsimpl0(this.transformOrigin, other.transformOrigin) || this.clip != other.clip)) {
            i3 |= 4;
        }
        if (!Intrinsics.areEqual(this.shape, other.shape)) {
            i3 |= 6;
        }
        if ((i4 & 64) != 0 && (!Color.m5969equalsimpl0(this.contentColor, other.contentColor) || !Intrinsics.areEqual(this.contentBrush, other.contentBrush))) {
            i3 |= 64;
        }
        return ((i4 & 32) == 0 || (Intrinsics.areEqual(this.fontFamily, other.fontFamily) && Intrinsics.areEqual(this.textIndent, other.textIndent) && TextUnit.m9021equalsimpl0(this.fontSize, other.fontSize) && TextUnit.m9021equalsimpl0(this.lineHeight, other.lineHeight) && TextUnit.m9021equalsimpl0(this.letterSpacing, other.letterSpacing) && BaselineShift.m8573equalsimpl0(this.baselineShift, other.baselineShift) && LineBreak.m8612equalsimpl0(this.lineBreak, other.lineBreak) && this.textEnums == other.textEnums)) ? i3 : i3 | 96;
    }

    public final ResolvedStyle copy$foundation() {
        ResolvedStyle resolvedStyle = new ResolvedStyle();
        copyInto$foundation(resolvedStyle);
        return resolvedStyle;
    }

    public final ResolvedStyle copyInheritedStyles$foundation() {
        ResolvedStyle resolvedStyle = new ResolvedStyle();
        copyInheritedStylesInto$foundation(resolvedStyle);
        return resolvedStyle;
    }

    public final void copyInheritedStylesInto$foundation(ResolvedStyle target) {
        target.contentColor = this.contentColor;
        target.contentBrush = this.contentBrush;
        target.fontFamily = this.fontFamily;
        target.textIndent = this.textIndent;
        target.fontSize = this.fontSize;
        target.lineHeight = this.lineHeight;
        target.letterSpacing = this.letterSpacing;
        target.baselineShift = this.baselineShift;
        target.lineBreak = this.lineBreak;
        target.textEnums = this.textEnums;
    }

    public final void copyInto$foundation(ResolvedStyle target) {
        target.flags = this.flags;
        target.left = this.left;
        target.top = this.top;
        target.right = this.right;
        target.bottom = this.bottom;
        target.minHeight = this.minHeight;
        target.maxHeight = this.maxHeight;
        target.minWidth = this.minWidth;
        target.maxWidth = this.maxWidth;
        target.contentPaddingStart = this.contentPaddingStart;
        target.contentPaddingEnd = this.contentPaddingEnd;
        target.contentPaddingTop = this.contentPaddingTop;
        target.contentPaddingBottom = this.contentPaddingBottom;
        target.externalPaddingStart = this.externalPaddingStart;
        target.externalPaddingEnd = this.externalPaddingEnd;
        target.externalPaddingTop = this.externalPaddingTop;
        target.externalPaddingBottom = this.externalPaddingBottom;
        target.borderWidth = this.borderWidth;
        target.shape = this.shape;
        target.alpha = this.alpha;
        target.scaleX = this.scaleX;
        target.scaleY = this.scaleY;
        target.translationX = this.translationX;
        target.translationY = this.translationY;
        target.rotationX = this.rotationX;
        target.rotationY = this.rotationY;
        target.rotationZ = this.rotationZ;
        target.transformOrigin = this.transformOrigin;
        target.zIndex = this.zIndex;
        target.cameraDistance = this.cameraDistance;
        target.borderColor = this.borderColor;
        target.borderBrush = this.borderBrush;
        target.backgroundColor = this.backgroundColor;
        target.backgroundBrush = this.backgroundBrush;
        target.foregroundBrush = this.foregroundBrush;
        target.dropShadow = this.dropShadow;
        target.innerShadow = this.innerShadow;
        target.clip = this.clip;
        target.width = this.width;
        target.height = this.height;
        target.widthFraction = this.widthFraction;
        target.heightFraction = this.heightFraction;
        copyInheritedStylesInto$foundation(target);
    }

    public final void clear$foundation() {
        ResolvedStyleKt.EmptyResolvedStyle.copyInto$foundation(this);
    }

    public final void resolve$foundation(Style style, StyleOuterNode node, Density density, boolean animating) {
        startResolve$foundation(node, density, animating);
        style.applyStyle(this);
        doneResolve$foundation();
    }

    public static /* synthetic */ void resolveForTesting$foundation$default(ResolvedStyle resolvedStyle, Style style, Density density, boolean z, StyleState styleState, int i, Object obj) {
        if ((i & 8) != 0) {
            styleState = null;
        }
        resolvedStyle.resolveForTesting$foundation(style, density, z, styleState);
    }

    public final void resolveForTesting$foundation(Style style, Density density, boolean animating, StyleState state) {
        this.currentIndex = 0;
        this.compositeHash = 0;
        this.node = new StyleOuterNode(state, style);
        this._density = density.getDensity();
        this.animating = animating;
        style.applyStyle(this);
        doneResolve$foundation();
    }

    public final void applyInheritableStyles$foundation(ResolvedStyle source) {
        int i = source.flags & 96;
        if (i == 0) {
            return;
        }
        this.flags = i | this.flags;
        long j = source.contentColor;
        long j2 = this.contentColor;
        if (j == 16) {
            j = j2;
        }
        this.contentColor = j;
        Brush brush = source.contentBrush;
        if (brush == null) {
            brush = this.contentBrush;
        }
        this.contentBrush = brush;
        FontFamily fontFamily = source.fontFamily;
        if (fontFamily == null) {
            fontFamily = this.fontFamily;
        }
        this.fontFamily = fontFamily;
        TextIndent textIndent = source.textIndent;
        if (textIndent == null) {
            textIndent = this.textIndent;
        }
        this.textIndent = textIndent;
        long j3 = source.fontSize;
        long j4 = this.fontSize;
        if (TextUnit.m9022getRawTypeimpl(j3) == 0) {
            j3 = j4;
        }
        this.fontSize = j3;
        long j5 = source.lineHeight;
        long j6 = this.lineHeight;
        if (TextUnit.m9022getRawTypeimpl(j5) == 0) {
            j5 = j6;
        }
        this.lineHeight = j5;
        long j7 = source.letterSpacing;
        long j8 = this.letterSpacing;
        if (TextUnit.m9022getRawTypeimpl(j7) == 0) {
            j7 = j8;
        }
        this.letterSpacing = j7;
        float f2 = source.baselineShift;
        float f3 = this.baselineShift;
        if (!BaselineShift.m8573equalsimpl0(f2, BaselineShift.INSTANCE.m8584getUnspecifiedy9eOQZs())) {
            f2 = f3;
        }
        this.baselineShift = f2;
        int i2 = source.lineBreak;
        int i3 = this.lineBreak;
        if (LineBreak.m8612equalsimpl0(i2, LineBreak.INSTANCE.m8626getUnspecifiedrAG3T2k())) {
            i2 = i3;
        }
        this.lineBreak = i2;
        int i4 = this.textEnums;
        int i5 = source.textEnums;
        int i6 = i5 & 3;
        int i7 = i4 & (-4);
        if (i6 != 0) {
            i4 = i6;
        }
        int i8 = i4 | i7;
        int i9 = i5 & 28;
        int i10 = i8 & (-29);
        if (i9 != 0) {
            i8 = i9;
        }
        int i11 = i8 | i10;
        int i12 = i5 & 112;
        int i13 = i11 & (-113);
        if (i12 != 0) {
            i11 = i12;
        }
        int i14 = i11 | i13;
        int i15 = i5 & 768;
        int i16 = i14 & (-769);
        if (i15 != 0) {
            i14 = i15;
        }
        int i17 = i14 | i16;
        int i18 = i5 & 15360;
        int i19 = i17 & (-15361);
        if (i18 != 0) {
            i17 = i18;
        }
        int i20 = i17 | i19;
        int i21 = i5 & 134086656;
        int i22 = (-134086657) & i20;
        if (i21 != 0) {
            i20 = i21;
        }
        this.textEnums = i22 | i20;
    }

    public final TextStyle toTextStyle$foundation(TextStyle fallback) {
        ResolvedStyle resolvedStyle = ResolvedStyleKt.EmptyResolvedStyle;
        long jM8303getColor0d7_KjU = this.contentColor;
        if (jM8303getColor0d7_KjU == 16) {
            jM8303getColor0d7_KjU = fallback.m8303getColor0d7_KjU();
        }
        long j = jM8303getColor0d7_KjU;
        long j2 = this.fontSize;
        long jM8304getFontSizeXSAIIZE = fallback.m8304getFontSizeXSAIIZE();
        if (!(TextUnit.m9022getRawTypeimpl(j2) == 0)) {
            jM8304getFontSizeXSAIIZE = j2;
        }
        FontWeight fontWeight$foundation = isFontWeightSpecified$foundation() ? getFontWeight$foundation() : fallback.getFontWeight();
        FontStyle fontStyleM8384boximpl = !FontStyle.m8387equalsimpl0(m1570getFontStyle_LCdwA$foundation(), resolvedStyle.m1570getFontStyle_LCdwA$foundation()) ? FontStyle.m8384boximpl(m1570getFontStyle_LCdwA$foundation()) : fallback.m8305getFontStyle4Lr2A7w();
        FontSynthesis fontSynthesisM8395boximpl = !FontSynthesis.m8398equalsimpl0(m1571getFontSynthesisGVVA2EU$foundation(), resolvedStyle.m1571getFontSynthesisGVVA2EU$foundation()) ? FontSynthesis.m8395boximpl(m1571getFontSynthesisGVVA2EU$foundation()) : fallback.m8306getFontSynthesisZQGJjVo();
        FontFamily fontFamily = this.fontFamily;
        if (fontFamily == null) {
            fontFamily = fallback.getFontFamily();
        }
        String fontFeatureSettings = fallback.getFontFeatureSettings();
        long j3 = this.letterSpacing;
        long jM8309getLetterSpacingXSAIIZE = fallback.m8309getLetterSpacingXSAIIZE();
        if (TextUnit.m9022getRawTypeimpl(j3) == 0) {
            j3 = jM8309getLetterSpacingXSAIIZE;
        }
        BaselineShift baselineShiftM8570boximpl = !Float.isNaN(this.baselineShift) ? BaselineShift.m8570boximpl(this.baselineShift) : fallback.m8302getBaselineShift5SSeXJ0();
        TextGeometricTransform textGeometricTransform = fallback.getTextGeometricTransform();
        LocaleList localeList = fallback.getLocaleList();
        long jM8301getBackground0d7_KjU = fallback.m8301getBackground0d7_KjU();
        TextDecoration textDecoration$foundation = !Intrinsics.areEqual(getTextDecoration$foundation(), resolvedStyle.getTextDecoration$foundation()) ? getTextDecoration$foundation() : fallback.getTextDecoration();
        Shadow shadow = fallback.getShadow();
        DrawStyle drawStyle = fallback.getDrawStyle();
        int iM1577getTextAligne0LSkKk$foundation = !TextAlign.m8704equalsimpl0(m1577getTextAligne0LSkKk$foundation(), resolvedStyle.m1577getTextAligne0LSkKk$foundation()) ? m1577getTextAligne0LSkKk$foundation() : fallback.m8314getTextAligne0LSkKk();
        int iM1578getTextDirections_7Xco$foundation = !TextDirection.m8721equalsimpl0(m1578getTextDirections_7Xco$foundation(), resolvedStyle.m1578getTextDirections_7Xco$foundation()) ? m1578getTextDirections_7Xco$foundation() : fallback.m8316getTextDirections_7Xco();
        FontWeight fontWeight = fontWeight$foundation;
        long j4 = this.lineHeight;
        long jM8312getLineHeightXSAIIZE = !((TextUnit.m9022getRawTypeimpl(j4) > 0L ? 1 : (TextUnit.m9022getRawTypeimpl(j4) == 0L ? 0 : -1)) == 0) ? j4 : fallback.m8312getLineHeightXSAIIZE();
        TextIndent textIndent = this.textIndent;
        if (textIndent == null) {
            textIndent = fallback.getTextIndent();
        }
        PlatformTextStyle platformStyle = fallback.getPlatformStyle();
        LineHeightStyle lineHeightStyle = fallback.getLineHeightStyle();
        int i = this.lineBreak;
        int iM8311getLineBreakrAG3T2k = fallback.m8311getLineBreakrAG3T2k();
        TextIndent textIndent2 = textIndent;
        if (LineBreak.m8612equalsimpl0(i, LineBreak.INSTANCE.m8626getUnspecifiedrAG3T2k())) {
            i = iM8311getLineBreakrAG3T2k;
        }
        BaselineShift baselineShift = baselineShiftM8570boximpl;
        TextDecoration textDecoration = textDecoration$foundation;
        FontStyle fontStyle = fontStyleM8384boximpl;
        TextStyle textStyle = new TextStyle(j, jM8304getFontSizeXSAIIZE, fontWeight, fontStyle, fontSynthesisM8395boximpl, fontFamily, fontFeatureSettings, j3, baselineShift, textGeometricTransform, localeList, jM8301getBackground0d7_KjU, textDecoration, shadow, drawStyle, iM1577getTextAligne0LSkKk$foundation, iM1578getTextDirections_7Xco$foundation, jM8312getLineHeightXSAIIZE, textIndent2, platformStyle, lineHeightStyle, i, !Hyphens.m8596equalsimpl0(m1573getHyphensvmbZdU8$foundation(), resolvedStyle.m1573getHyphensvmbZdU8$foundation()) ? m1573getHyphensvmbZdU8$foundation() : fallback.m8308getHyphensvmbZdU8(), fallback.getTextMotion(), (DefaultConstructorMarker) null);
        Brush brush = this.contentBrush;
        return brush != null ? TextStyle.m8284copyNs73l9s$default(textStyle, brush, 0.0f, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 33554430, null) : textStyle;
    }

    private final List<ValueElement> valueElements() {
        ArrayList arrayList = new ArrayList();
        ResolvedStyle resolvedStyle = ResolvedStyleKt.EmptyResolvedStyle;
        float f2 = resolvedStyle.contentPaddingStart;
        float f3 = this.contentPaddingStart;
        if (f2 != f3) {
            valueElements$lambda$0$add(arrayList, "contentPaddingStart", Float.valueOf(f3));
        }
        float f4 = resolvedStyle.contentPaddingEnd;
        float f5 = this.contentPaddingEnd;
        if (f4 != f5) {
            valueElements$lambda$0$add(arrayList, "contentPaddingEnd", Float.valueOf(f5));
        }
        float f6 = resolvedStyle.contentPaddingTop;
        float f7 = this.contentPaddingTop;
        if (f6 != f7) {
            valueElements$lambda$0$add(arrayList, "contentPaddingTop", Float.valueOf(f7));
        }
        float f8 = resolvedStyle.contentPaddingBottom;
        float f9 = this.contentPaddingBottom;
        if (f8 != f9) {
            valueElements$lambda$0$add(arrayList, "contentPaddingBottom", Float.valueOf(f9));
        }
        float f10 = resolvedStyle.externalPaddingStart;
        float f11 = this.externalPaddingStart;
        if (f10 != f11) {
            valueElements$lambda$0$add(arrayList, "externalPaddingStart", Float.valueOf(f11));
        }
        float f12 = resolvedStyle.externalPaddingEnd;
        float f13 = this.externalPaddingEnd;
        if (f12 != f13) {
            valueElements$lambda$0$add(arrayList, "externalPaddingEnd", Float.valueOf(f13));
        }
        float f14 = resolvedStyle.externalPaddingTop;
        float f15 = this.externalPaddingTop;
        if (f14 != f15) {
            valueElements$lambda$0$add(arrayList, "externalPaddingTop", Float.valueOf(f15));
        }
        float f16 = resolvedStyle.externalPaddingBottom;
        float f17 = this.externalPaddingBottom;
        if (f16 != f17) {
            valueElements$lambda$0$add(arrayList, "externalPaddingBottom", Float.valueOf(f17));
        }
        float f18 = resolvedStyle.borderWidth;
        float f19 = this.borderWidth;
        if (f18 != f19) {
            valueElements$lambda$0$add(arrayList, "borderWidth", Float.valueOf(f19));
        }
        float f20 = resolvedStyle.width;
        float f21 = this.width;
        if (f20 != f21) {
            valueElements$lambda$0$add(arrayList, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, Float.valueOf(f21));
        }
        float f22 = resolvedStyle.height;
        float f23 = this.height;
        if (f22 != f23) {
            valueElements$lambda$0$add(arrayList, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, Float.valueOf(f23));
        }
        if (Float.floatToRawIntBits(resolvedStyle.widthFraction) != Float.floatToRawIntBits(this.widthFraction)) {
            valueElements$lambda$0$add(arrayList, "widthFraction", Float.valueOf(this.widthFraction));
        }
        if (Float.floatToRawIntBits(resolvedStyle.heightFraction) != Float.floatToRawIntBits(this.heightFraction)) {
            valueElements$lambda$0$add(arrayList, "heightFraction", Float.valueOf(this.heightFraction));
        }
        float f24 = resolvedStyle.alpha;
        float f25 = this.alpha;
        if (f24 != f25) {
            valueElements$lambda$0$add(arrayList, "alpha", Float.valueOf(f25));
        }
        float f26 = resolvedStyle.scaleX;
        float f27 = this.scaleX;
        if (f26 != f27) {
            valueElements$lambda$0$add(arrayList, "scaleX", Float.valueOf(f27));
        }
        float f28 = resolvedStyle.scaleY;
        float f29 = this.scaleY;
        if (f28 != f29) {
            valueElements$lambda$0$add(arrayList, "scaleY", Float.valueOf(f29));
        }
        float f30 = resolvedStyle.translationX;
        float f31 = this.translationX;
        if (f30 != f31) {
            valueElements$lambda$0$add(arrayList, "translationX", Float.valueOf(f31));
        }
        float f32 = resolvedStyle.translationY;
        float f33 = this.translationY;
        if (f32 != f33) {
            valueElements$lambda$0$add(arrayList, "translationY", Float.valueOf(f33));
        }
        float f34 = resolvedStyle.rotationX;
        float f35 = this.rotationX;
        if (f34 != f35) {
            valueElements$lambda$0$add(arrayList, "rotationX", Float.valueOf(f35));
        }
        float f36 = resolvedStyle.rotationY;
        float f37 = this.rotationY;
        if (f36 != f37) {
            valueElements$lambda$0$add(arrayList, "rotationY", Float.valueOf(f37));
        }
        float f38 = resolvedStyle.rotationZ;
        float f39 = this.rotationZ;
        if (f38 != f39) {
            valueElements$lambda$0$add(arrayList, "rotationZ", Float.valueOf(f39));
        }
        if (!TransformOrigin.m6377equalsimpl0(resolvedStyle.transformOrigin, this.transformOrigin)) {
            valueElements$lambda$0$add(arrayList, "transformOrigin", TransformOrigin.m6370boximpl(this.transformOrigin));
        }
        float f40 = resolvedStyle.zIndex;
        float f41 = this.zIndex;
        if (f40 != f41) {
            valueElements$lambda$0$add(arrayList, "zIndex", Float.valueOf(f41));
        }
        float f42 = resolvedStyle.cameraDistance;
        float f43 = this.cameraDistance;
        if (f42 != f43) {
            valueElements$lambda$0$add(arrayList, "cameraDistance", Float.valueOf(f43));
        }
        if (!Color.m5969equalsimpl0(resolvedStyle.borderColor, this.borderColor)) {
            valueElements$lambda$0$add(arrayList, "borderColor", Color.m5958boximpl(this.borderColor));
        }
        if (!Intrinsics.areEqual(resolvedStyle.borderBrush, this.borderBrush)) {
            valueElements$lambda$0$add(arrayList, "borderBrush", this.borderBrush);
        }
        if (!Color.m5969equalsimpl0(resolvedStyle.backgroundColor, this.backgroundColor)) {
            valueElements$lambda$0$add(arrayList, "backgroundColor", Color.m5958boximpl(this.backgroundColor));
        }
        if (!Intrinsics.areEqual(resolvedStyle.backgroundBrush, this.backgroundBrush)) {
            valueElements$lambda$0$add(arrayList, "backgroundBrush", this.backgroundBrush);
        }
        if (!Intrinsics.areEqual(resolvedStyle.foregroundBrush, this.foregroundBrush)) {
            valueElements$lambda$0$add(arrayList, "foregroundBrush", this.foregroundBrush);
        }
        boolean z = resolvedStyle.clip;
        boolean z2 = this.clip;
        if (z != z2) {
            valueElements$lambda$0$add(arrayList, "clip", Boolean.valueOf(z2));
        }
        if (!Intrinsics.areEqual(resolvedStyle.shape, this.shape)) {
            valueElements$lambda$0$add(arrayList, "shape", this.shape);
        }
        if (resolvedStyle.contentColor != 16) {
            valueElements$lambda$0$add(arrayList, "contentColor", Color.m5958boximpl(this.contentColor));
        }
        if (!Intrinsics.areEqual(resolvedStyle.contentBrush, this.backgroundBrush)) {
            valueElements$lambda$0$add(arrayList, "contentBrush", this.contentBrush);
        }
        if (!Intrinsics.areEqual(resolvedStyle.fontFamily, this.fontFamily)) {
            valueElements$lambda$0$add(arrayList, "fontFamily", this.fontFamily);
        }
        if (!Intrinsics.areEqual(resolvedStyle.textIndent, this.textIndent)) {
            valueElements$lambda$0$add(arrayList, "textIndent", this.textIndent);
        }
        if (!TextUnit.m9021equalsimpl0(resolvedStyle.fontSize, this.fontSize)) {
            valueElements$lambda$0$add(arrayList, "fontSize", TextUnit.m9014boximpl(this.fontSize));
        }
        if (!TextUnit.m9021equalsimpl0(resolvedStyle.lineHeight, this.lineHeight)) {
            valueElements$lambda$0$add(arrayList, "lineHeight", TextUnit.m9014boximpl(this.lineHeight));
        }
        if (!TextUnit.m9021equalsimpl0(resolvedStyle.letterSpacing, this.letterSpacing)) {
            valueElements$lambda$0$add(arrayList, "letterSpacing", TextUnit.m9014boximpl(this.letterSpacing));
        }
        if (!BaselineShift.m8573equalsimpl0(resolvedStyle.baselineShift, this.baselineShift)) {
            valueElements$lambda$0$add(arrayList, "baselineShift", BaselineShift.m8570boximpl(this.baselineShift));
        }
        if (!LineBreak.m8612equalsimpl0(resolvedStyle.lineBreak, this.lineBreak)) {
            valueElements$lambda$0$add(arrayList, "lineBreak", LineBreak.m8606boximpl(this.lineBreak));
        }
        if (!TextAlign.m8704equalsimpl0(resolvedStyle.m1577getTextAligne0LSkKk$foundation(), m1577getTextAligne0LSkKk$foundation())) {
            valueElements$lambda$0$add(arrayList, "textAlign", TextAlign.m8701boximpl(m1577getTextAligne0LSkKk$foundation()));
        }
        if (!TextDirection.m8721equalsimpl0(resolvedStyle.m1578getTextDirections_7Xco$foundation(), m1578getTextDirections_7Xco$foundation())) {
            valueElements$lambda$0$add(arrayList, "textDirection", TextDirection.m8718boximpl(m1578getTextDirections_7Xco$foundation()));
        }
        if (!Hyphens.m8596equalsimpl0(resolvedStyle.m1573getHyphensvmbZdU8$foundation(), m1573getHyphensvmbZdU8$foundation())) {
            valueElements$lambda$0$add(arrayList, "hyphens", Hyphens.m8593boximpl(m1573getHyphensvmbZdU8$foundation()));
        }
        if (!FontStyle.m8387equalsimpl0(resolvedStyle.m1570getFontStyle_LCdwA$foundation(), m1570getFontStyle_LCdwA$foundation())) {
            valueElements$lambda$0$add(arrayList, "fontStyle", FontStyle.m8384boximpl(m1570getFontStyle_LCdwA$foundation()));
        }
        if (!Intrinsics.areEqual(resolvedStyle.getFontWeight$foundation(), getFontWeight$foundation())) {
            valueElements$lambda$0$add(arrayList, "fontWeight", getFontWeight$foundation());
        }
        if (!FontSynthesis.m8398equalsimpl0(resolvedStyle.m1571getFontSynthesisGVVA2EU$foundation(), m1571getFontSynthesisGVVA2EU$foundation())) {
            valueElements$lambda$0$add(arrayList, "fontSynthesis", FontSynthesis.m8395boximpl(m1571getFontSynthesisGVVA2EU$foundation()));
        }
        if (!Intrinsics.areEqual(resolvedStyle.getTextDecoration$foundation(), getTextDecoration$foundation())) {
            valueElements$lambda$0$add(arrayList, "textDecoration", getTextDecoration$foundation());
        }
        return arrayList;
    }

    private static final boolean valueElements$lambda$0$add(List<ValueElement> list, String str, Object obj) {
        return list.add(new ValueElement(str, obj));
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public Sequence<ValueElement> getInspectableElements() {
        return CollectionsKt.asSequence(valueElements());
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this._density;
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this._fontScale;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public StyleState getState() {
        StyleOuterNode styleOuterNode = this.node;
        Intrinsics.checkNotNull(styleOuterNode);
        return styleOuterNode.get_state();
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: contentPaddingStart-0680j_4, reason: not valid java name */
    public void mo1549contentPaddingStart0680j_4(float value) {
        this.flags |= 1;
        this.contentPaddingStart = mo482roundToPx0680j_4(value);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: contentPaddingEnd-0680j_4, reason: not valid java name */
    public void mo1547contentPaddingEnd0680j_4(float value) {
        this.flags |= 1;
        this.contentPaddingEnd = mo482roundToPx0680j_4(value);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: contentPaddingTop-0680j_4, reason: not valid java name */
    public void mo1550contentPaddingTop0680j_4(float value) {
        this.flags |= 1;
        this.contentPaddingTop = mo482roundToPx0680j_4(value);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: contentPaddingBottom-0680j_4, reason: not valid java name */
    public void mo1546contentPaddingBottom0680j_4(float value) {
        this.flags |= 1;
        this.contentPaddingBottom = mo482roundToPx0680j_4(value);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: contentPaddingHorizontal-0680j_4, reason: not valid java name */
    public void mo1548contentPaddingHorizontal0680j_4(float value) {
        this.flags |= 1;
        float f2 = mo482roundToPx0680j_4(value);
        this.contentPaddingStart = f2;
        this.contentPaddingEnd = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: contentPaddingVertical-0680j_4, reason: not valid java name */
    public void mo1551contentPaddingVertical0680j_4(float value) {
        this.flags |= 1;
        float f2 = mo482roundToPx0680j_4(value);
        this.contentPaddingTop = f2;
        this.contentPaddingBottom = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: contentPadding-0680j_4, reason: not valid java name */
    public void mo1543contentPadding0680j_4(float value) {
        this.flags |= 1;
        float f2 = mo482roundToPx0680j_4(value);
        this.contentPaddingStart = f2;
        this.contentPaddingEnd = f2;
        this.contentPaddingTop = f2;
        this.contentPaddingBottom = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: contentPadding-a9UjIt4, reason: not valid java name */
    public void mo1545contentPaddinga9UjIt4(float start, float top, float end, float bottom) {
        this.flags |= 1;
        this.contentPaddingTop = mo482roundToPx0680j_4(top);
        this.contentPaddingEnd = mo482roundToPx0680j_4(end);
        this.contentPaddingBottom = mo482roundToPx0680j_4(bottom);
        this.contentPaddingStart = mo482roundToPx0680j_4(start);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: contentPadding-YgX7TsA, reason: not valid java name */
    public void mo1544contentPaddingYgX7TsA(float horizontal, float vertical) {
        this.flags |= 1;
        float f2 = mo482roundToPx0680j_4(vertical);
        this.contentPaddingTop = f2;
        this.contentPaddingBottom = f2;
        float f3 = mo482roundToPx0680j_4(horizontal);
        this.contentPaddingEnd = f3;
        this.contentPaddingStart = f3;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: externalPaddingStart-0680j_4, reason: not valid java name */
    public void mo1558externalPaddingStart0680j_4(float value) {
        this.flags |= 8;
        this.externalPaddingStart = mo482roundToPx0680j_4(value);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: externalPaddingEnd-0680j_4, reason: not valid java name */
    public void mo1556externalPaddingEnd0680j_4(float value) {
        this.flags |= 8;
        this.externalPaddingEnd = mo482roundToPx0680j_4(value);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: externalPaddingTop-0680j_4, reason: not valid java name */
    public void mo1559externalPaddingTop0680j_4(float value) {
        this.flags |= 8;
        this.externalPaddingTop = mo482roundToPx0680j_4(value);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: externalPaddingBottom-0680j_4, reason: not valid java name */
    public void mo1555externalPaddingBottom0680j_4(float value) {
        this.flags |= 8;
        this.externalPaddingBottom = mo482roundToPx0680j_4(value);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: externalPaddingHorizontal-0680j_4, reason: not valid java name */
    public void mo1557externalPaddingHorizontal0680j_4(float value) {
        this.flags |= 8;
        float f2 = mo482roundToPx0680j_4(value);
        this.externalPaddingStart = f2;
        this.externalPaddingEnd = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: externalPaddingVertical-0680j_4, reason: not valid java name */
    public void mo1560externalPaddingVertical0680j_4(float value) {
        this.flags |= 8;
        float f2 = mo482roundToPx0680j_4(value);
        this.externalPaddingTop = f2;
        this.externalPaddingBottom = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: externalPadding-0680j_4, reason: not valid java name */
    public void mo1552externalPadding0680j_4(float value) {
        this.flags |= 8;
        float f2 = mo482roundToPx0680j_4(value);
        this.externalPaddingStart = f2;
        this.externalPaddingEnd = f2;
        this.externalPaddingTop = f2;
        this.externalPaddingBottom = f2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: externalPadding-a9UjIt4, reason: not valid java name */
    public void mo1554externalPaddinga9UjIt4(float start, float top, float end, float bottom) {
        this.flags |= 8;
        this.externalPaddingTop = mo482roundToPx0680j_4(top);
        this.externalPaddingEnd = mo482roundToPx0680j_4(end);
        this.externalPaddingBottom = mo482roundToPx0680j_4(bottom);
        this.externalPaddingStart = mo482roundToPx0680j_4(start);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: externalPadding-YgX7TsA, reason: not valid java name */
    public void mo1553externalPaddingYgX7TsA(float horizontal, float vertical) {
        this.flags |= 8;
        float f2 = mo482roundToPx0680j_4(vertical);
        this.externalPaddingTop = f2;
        this.externalPaddingBottom = f2;
        float f3 = mo482roundToPx0680j_4(horizontal);
        this.externalPaddingEnd = f3;
        this.externalPaddingStart = f3;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: borderWidth-0680j_4, reason: not valid java name */
    public void mo1540borderWidth0680j_4(float value) {
        float fCeil;
        this.flags |= 3;
        if (Dp.m8835equalsimpl0(value, Dp.INSTANCE.m8850getUnspecifiedD9Ej5fM())) {
            fCeil = 0.0f;
        } else {
            fCeil = Dp.m8835equalsimpl0(value, Dp.INSTANCE.m8848getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(value * this._density);
        }
        this.borderWidth = fCeil;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: borderColor-8_81llA, reason: not valid java name */
    public void mo1539borderColor8_81llA(long value) {
        this.flags |= 2;
        this.borderColor = value;
        this.borderBrush = null;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void borderBrush(Brush value) {
        this.flags |= 2;
        this.borderBrush = value;
        this.borderColor = Color.INSTANCE.m6004getUnspecified0d7_KjU();
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: border-cXLIe8U, reason: not valid java name */
    public void mo1538bordercXLIe8U(float width, long color) {
        mo1540borderWidth0680j_4(width);
        mo1539borderColor8_81llA(color);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: border-D5KLDUw, reason: not valid java name */
    public void mo1537borderD5KLDUw(float width, Brush brush) {
        mo1540borderWidth0680j_4(width);
        borderBrush(brush);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: width-0680j_4, reason: not valid java name */
    public void mo1613width0680j_4(float value) {
        this.flags |= 8;
        this.width = value * this._density;
        this.widthFraction = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: height-0680j_4, reason: not valid java name */
    public void mo1580height0680j_4(float value) {
        this.flags |= 8;
        this.height = value * this._density;
        this.heightFraction = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: size-YgX7TsA, reason: not valid java name */
    public void mo1607sizeYgX7TsA(float width, float height) {
        this.flags |= 8;
        float f2 = this._density;
        this.width = width * f2;
        this.widthFraction = Float.NaN;
        this.height = height * f2;
        this.heightFraction = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: size-0680j_4, reason: not valid java name */
    public void mo1605size0680j_4(float value) {
        this.flags |= 8;
        float f2 = value * this._density;
        this.width = f2;
        this.widthFraction = Float.NaN;
        this.height = f2;
        this.heightFraction = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: size-EaSLcWc, reason: not valid java name */
    public void mo1606sizeEaSLcWc(long value) {
        this.flags |= 8;
        this.width = DpSize.m8928getWidthD9Ej5fM(value) * this._density;
        this.widthFraction = Float.NaN;
        this.height = DpSize.m8926getHeightD9Ej5fM(value) * this._density;
        this.heightFraction = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void width(float fraction) {
        this.flags |= 8;
        this.widthFraction = fraction;
        this.width = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void height(float fraction) {
        this.flags |= 8;
        this.heightFraction = fraction;
        this.height = Float.NaN;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: left-0680j_4, reason: not valid java name */
    public void mo1582left0680j_4(float value) {
        this.flags |= 8;
        this.left = value * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: top-0680j_4, reason: not valid java name */
    public void mo1610top0680j_4(float value) {
        this.flags |= 8;
        this.top = value * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: right-0680j_4, reason: not valid java name */
    public void mo1594right0680j_4(float value) {
        this.flags |= 8;
        this.right = value * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: bottom-0680j_4, reason: not valid java name */
    public void mo1541bottom0680j_4(float value) {
        this.flags |= 8;
        this.bottom = value * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: minWidth-0680j_4, reason: not valid java name */
    public void mo1593minWidth0680j_4(float value) {
        this.flags |= 8;
        this.minWidth = value * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: minHeight-0680j_4, reason: not valid java name */
    public void mo1590minHeight0680j_4(float value) {
        this.flags |= 8;
        this.minHeight = value * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: minSize-EaSLcWc, reason: not valid java name */
    public void mo1591minSizeEaSLcWc(long size) {
        mo1593minWidth0680j_4(DpSize.m8928getWidthD9Ej5fM(size));
        mo1590minHeight0680j_4(DpSize.m8926getHeightD9Ej5fM(size));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: minSize-YgX7TsA, reason: not valid java name */
    public void mo1592minSizeYgX7TsA(float width, float height) {
        mo1593minWidth0680j_4(width);
        mo1590minHeight0680j_4(height);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: maxWidth-0680j_4, reason: not valid java name */
    public void mo1589maxWidth0680j_4(float value) {
        this.flags |= 8;
        this.maxWidth = value * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: maxHeight-0680j_4, reason: not valid java name */
    public void mo1586maxHeight0680j_4(float value) {
        this.flags |= 8;
        this.maxHeight = value * this._density;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: maxSize-EaSLcWc, reason: not valid java name */
    public void mo1587maxSizeEaSLcWc(long size) {
        mo1589maxWidth0680j_4(DpSize.m8928getWidthD9Ej5fM(size));
        mo1586maxHeight0680j_4(DpSize.m8926getHeightD9Ej5fM(size));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: maxSize-YgX7TsA, reason: not valid java name */
    public void mo1588maxSizeYgX7TsA(float width, float height) {
        mo1589maxWidth0680j_4(width);
        mo1586maxHeight0680j_4(height);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void alpha(float value) {
        this.flags |= 4;
        this.alpha = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void scaleX(float value) {
        this.flags |= 4;
        this.scaleX = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void scaleY(float value) {
        this.flags |= 4;
        this.scaleY = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void scale(float value) {
        this.flags |= 4;
        this.scaleX = value;
        this.scaleY = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void translationX(float value) {
        this.flags |= 4;
        this.translationX = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void translationY(float value) {
        this.flags |= 4;
        this.translationY = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void translation(float x, float y) {
        this.flags |= 4;
        this.translationX = x;
        this.translationY = y;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: translation-k-4lQ0M, reason: not valid java name */
    public void mo1612translationk4lQ0M(long offset) {
        this.flags |= 4;
        this.translationX = Float.intBitsToFloat((int) (offset >> 32));
        this.translationY = Float.intBitsToFloat((int) (offset & 4294967295L));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void rotationX(float value) {
        this.flags |= 4;
        this.rotationX = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void rotationY(float value) {
        this.flags |= 4;
        this.rotationY = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void rotationZ(float value) {
        this.flags |= 4;
        this.rotationZ = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: transformOrigin-__ExYCQ, reason: not valid java name */
    public void mo1611transformOrigin__ExYCQ(long value) {
        this.flags |= 4;
        this.transformOrigin = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void clip(boolean value) {
        this.flags |= 4;
        this.clip = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void zIndex(float value) {
        this.zIndex = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: background-8_81llA, reason: not valid java name */
    public void mo1535background8_81llA(long color) {
        this.flags |= 2;
        this.backgroundColor = color;
        this.backgroundBrush = null;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void background(Brush value) {
        this.flags |= 2;
        this.backgroundBrush = value;
        this.backgroundColor = Color.INSTANCE.m6004getUnspecified0d7_KjU();
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: foreground-8_81llA, reason: not valid java name */
    public void mo1564foreground8_81llA(long value) {
        this.flags |= 2;
        this.foregroundColor = value;
        this.foregroundBrush = null;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void foreground(Brush value) {
        this.flags |= 2;
        this.foregroundBrush = value;
        this.foregroundColor = Color.INSTANCE.m6004getUnspecified0d7_KjU();
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void shape(Shape value) {
        this.flags |= 6;
        this.shape = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void animate(Style value) {
        animate(ResolvedStyleKt.DefaultSpringSpec, ResolvedStyleKt.DefaultSpringSpec, value);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void animate(AnimationSpec<Float> spec, Style value) {
        animate(spec, spec, value);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void animate(AnimationSpec<Float> toSpec, AnimationSpec<Float> fromSpec, Style value) {
        this.flags |= 16;
        int i = this.currentIndex;
        int i2 = 1318433304 ^ i;
        this.compositeHash = ResolvedStyleKt.updateHashEnter(this.compositeHash, i2);
        MutableIntList mutableIntListPushIndex = pushIndex(i);
        this.currentIndex = 0;
        if (this.animating) {
            StyleScopeKt.apply(this, value);
        } else {
            StyleOuterNode styleOuterNode = this.node;
            Intrinsics.checkNotNull(styleOuterNode);
            StyleAnimations animations$foundation = styleOuterNode.getAnimations();
            if (animations$foundation == null) {
                animations$foundation = new StyleAnimations(styleOuterNode);
                styleOuterNode.setAnimations$foundation(animations$foundation);
            }
            animations$foundation.record(this.compositeHash ^ this.currentIndex, value, toSpec, fromSpec);
        }
        this.currentIndex = mutableIntListPushIndex.removeAt(mutableIntListPushIndex._size - 1) + 1;
        this.compositeHash = ResolvedStyleKt.updateHashExit(this.compositeHash, i2);
    }

    @Override // androidx.compose.runtime.CompositionLocalAccessorScope
    public <T> T getCurrentValue(CompositionLocal<T> compositionLocal) {
        StyleOuterNode styleOuterNode = this.node;
        Intrinsics.checkNotNull(styleOuterNode);
        return (T) CompositionLocalConsumerModifierNodeKt.currentValueOf(styleOuterNode, compositionLocal);
    }

    /* JADX INFO: renamed from: getDropShadow$foundation, reason: from getter */
    public final Object getDropShadow() {
        return this.dropShadow;
    }

    public final void setDropShadow$foundation(Object obj) {
        this.dropShadow = obj;
    }

    /* JADX INFO: renamed from: getInnerShadow$foundation, reason: from getter */
    public final Object getInnerShadow() {
        return this.innerShadow;
    }

    public final void setInnerShadow$foundation(Object obj) {
        this.innerShadow = obj;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void dropShadow(androidx.compose.ui.graphics.shadow.Shadow value) {
        this.dropShadow = value;
        this.flags |= 2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void dropShadow(androidx.compose.ui.graphics.shadow.Shadow... value) {
        this.dropShadow = value;
        this.flags |= 2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void innerShadow(androidx.compose.ui.graphics.shadow.Shadow value) {
        this.innerShadow = value;
        this.flags |= 2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void innerShadow(androidx.compose.ui.graphics.shadow.Shadow... value) {
        this.innerShadow = value;
        this.flags |= 2;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void textStyle(TextStyle value) {
        SpanStyle spanStyle = value.toSpanStyle();
        if (spanStyle.m8213getColor0d7_KjU() != 16) {
            mo1542contentColor8_81llA(spanStyle.m8213getColor0d7_KjU());
        }
        if (!(TextUnit.m9022getRawTypeimpl(spanStyle.getFontSize()) == 0)) {
            mo1561fontSizeR2X_6o(spanStyle.getFontSize());
        }
        if (!(TextUnit.m9022getRawTypeimpl(spanStyle.getLetterSpacing()) == 0)) {
            mo1583letterSpacingR2X_6o(spanStyle.getLetterSpacing());
        }
        Brush brush = spanStyle.getBrush();
        if (brush != null) {
            contentBrush(brush);
        }
        FontStyle fontStyle = spanStyle.getFontStyle();
        if (fontStyle != null) {
            mo1562fontStylenzbMABs(fontStyle.m8390unboximpl());
        }
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        if (baselineShift != null) {
            float fM8576unboximpl = baselineShift.m8576unboximpl();
            if (!Float.isNaN(fM8576unboximpl)) {
                mo1536baselineShift4Dl_Bck(fM8576unboximpl);
            }
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            fontWeight(fontWeight);
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            textDecoration(textDecoration);
        }
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        if (fontSynthesis != null) {
            mo1563fontSynthesis6p3vJLY(fontSynthesis.m8403unboximpl());
        }
        ParagraphStyle paragraphStyle = value.toParagraphStyle();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent != null) {
            textIndent(textIndent);
        }
        if (!(TextUnit.m9022getRawTypeimpl(paragraphStyle.getLineHeight()) == 0)) {
            mo1585lineHeightR2X_6o(paragraphStyle.getLineHeight());
        }
        if (!LineBreak.m8612equalsimpl0(paragraphStyle.getLineBreak(), LineBreak.INSTANCE.m8626getUnspecifiedrAG3T2k())) {
            mo1584lineBreakCZqVlQI(paragraphStyle.getLineBreak());
        }
        if (paragraphStyle.getHyphens() != 0) {
            mo1581hyphens3fSNIE(paragraphStyle.getHyphens());
        }
        if (paragraphStyle.getTextDirection() != 0) {
            mo1609textDirectionHejc4pk(paragraphStyle.getTextDirection());
        }
        if (paragraphStyle.getTextAlign() != 0) {
            mo1608textAlignaXe7zB0(paragraphStyle.getTextAlign());
        }
    }

    /* JADX INFO: renamed from: getFontStyle-_-LCdwA$foundation, reason: not valid java name */
    public final int m1570getFontStyle_LCdwA$foundation() {
        if ((this.textEnums & 1) == 1) {
            return FontStyle.INSTANCE.m8393getItalic_LCdwA();
        }
        return FontStyle.INSTANCE.m8394getNormal_LCdwA();
    }

    /* JADX INFO: renamed from: getTextAlign-e0LSkKk$foundation, reason: not valid java name */
    public final int m1577getTextAligne0LSkKk$foundation() {
        return TextAlign.INSTANCE.m8715valueOfIgVj0fw((this.textEnums & 28) >> 2);
    }

    /* JADX INFO: renamed from: getTextDirection-s_7X-co$foundation, reason: not valid java name */
    public final int m1578getTextDirections_7Xco$foundation() {
        return TextDirection.INSTANCE.m8731valueOfE8nx0Ws((this.textEnums & 112) >> 4);
    }

    /* JADX INFO: renamed from: getHyphens-vmbZdU8$foundation, reason: not valid java name */
    public final int m1573getHyphensvmbZdU8$foundation() {
        return Hyphens.INSTANCE.m8603valueOfkPa1_AA((this.textEnums & 768) >> 8);
    }

    public final FontWeight getFontWeight$foundation() {
        return new FontWeight((this.textEnums & 134086656) >> 17);
    }

    public final boolean isFontWeightSpecified$foundation() {
        return ((this.textEnums & 134086656) >> 17) != 0;
    }

    /* JADX INFO: renamed from: getFontSynthesis-GVVA2EU$foundation, reason: not valid java name */
    public final int m1571getFontSynthesisGVVA2EU$foundation() {
        return FontSynthesis.INSTANCE.m8408valueOf9CiegCU(((this.textEnums & 15360) >> 10) & 7);
    }

    public final TextDecoration getTextDecoration$foundation() {
        return TextDecoration.INSTANCE.valueOf(((this.textEnums & 114688) >> 14) & 3);
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: contentColor-8_81llA, reason: not valid java name */
    public void mo1542contentColor8_81llA(long value) {
        this.flags |= 64;
        this.contentColor = value;
        this.contentBrush = null;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void contentBrush(Brush value) {
        this.flags |= 64;
        this.contentBrush = value;
        this.contentColor = Color.INSTANCE.m6004getUnspecified0d7_KjU();
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void textDecoration(TextDecoration value) {
        this.flags |= 64;
        this.textEnums = ((value.getMask() | 4) << 14) | this.textEnums;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void fontFamily(FontFamily value) {
        this.flags |= 32;
        this.fontFamily = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void textIndent(TextIndent value) {
        this.flags |= 32;
        this.textIndent = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: fontSize--R2X_6o, reason: not valid java name */
    public void mo1561fontSizeR2X_6o(long value) {
        this.flags |= 32;
        this.fontSize = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: lineHeight--R2X_6o, reason: not valid java name */
    public void mo1585lineHeightR2X_6o(long value) {
        this.flags |= 32;
        this.lineHeight = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: letterSpacing--R2X_6o, reason: not valid java name */
    public void mo1583letterSpacingR2X_6o(long value) {
        this.flags |= 32;
        this.letterSpacing = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: baselineShift-4Dl_Bck, reason: not valid java name */
    public void mo1536baselineShift4Dl_Bck(float value) {
        this.flags |= 32;
        this.baselineShift = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: lineBreak-CZqVlQI, reason: not valid java name */
    public void mo1584lineBreakCZqVlQI(int value) {
        this.flags |= 32;
        this.lineBreak = value;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: fontStyle-nzbMABs, reason: not valid java name */
    public void mo1562fontStylenzbMABs(int value) {
        this.flags |= 32;
        this.textEnums = ((value | 2) & 3) | (this.textEnums & (-4));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: textAlign-aXe7zB0, reason: not valid java name */
    public void mo1608textAlignaXe7zB0(int value) {
        this.flags |= 32;
        this.textEnums = ((value << 2) & 28) | (this.textEnums & (-29));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: textDirection-Hejc4pk, reason: not valid java name */
    public void mo1609textDirectionHejc4pk(int value) {
        this.flags |= 32;
        this.textEnums = ((value << 4) & 112) | (this.textEnums & (-113));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: hyphens--3fSNIE, reason: not valid java name */
    public void mo1581hyphens3fSNIE(int value) {
        this.flags |= 32;
        this.textEnums = ((value << 8) & 768) | (this.textEnums & (-769));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public void fontWeight(FontWeight value) {
        this.flags |= 32;
        this.textEnums = ((value.getWeight() << 17) & 134086656) | (this.textEnums & (-134086657));
    }

    @Override // androidx.compose.foundation.style.StyleScope
    /* JADX INFO: renamed from: fontSynthesis-6p3vJLY, reason: not valid java name */
    public void mo1563fontSynthesis6p3vJLY(int value) {
        this.flags |= 32;
        this.textEnums = (((value & 7) | 8) << 10) | this.textEnums;
    }

    @Override // androidx.compose.foundation.style.StyleScope
    public <T> void state(StyleStateKey<T> key, Style value, Function2<? super StyleStateKey<T>, ? super StyleState, Boolean> active) {
        group(key.hashCode(), active.invoke(key, getState()).booleanValue(), value);
    }

    public final void startResolve$foundation(StyleOuterNode node, Density density, boolean animating) {
        this.currentIndex = 0;
        this.compositeHash = 0;
        this.node = node;
        this._density = density.getDensity();
        this.animating = animating;
    }

    public final void doneResolve$foundation() {
        this.node = null;
        this.animating = false;
    }

    private final MutableIntList pushIndex(int index) {
        MutableIntList mutableIntList = this.indexStack;
        if (mutableIntList == null) {
            mutableIntList = new MutableIntList(0, 1, null);
            this.indexStack = mutableIntList;
        }
        mutableIntList.add(index);
        return mutableIntList;
    }

    private final void group(int key, Function0<Unit> block) {
        int i = this.currentIndex;
        int i2 = key ^ i;
        this.compositeHash = ResolvedStyleKt.updateHashEnter(this.compositeHash, i2);
        MutableIntList mutableIntListPushIndex = pushIndex(i);
        this.currentIndex = 0;
        block.invoke();
        this.currentIndex = mutableIntListPushIndex.removeAt(mutableIntListPushIndex._size - 1) + 1;
        this.compositeHash = ResolvedStyleKt.updateHashExit(this.compositeHash, i2);
    }

    private final void skippedGroup() {
        this.currentIndex++;
    }

    private final int getCurrentCompositeHash() {
        return this.compositeHash ^ this.currentIndex;
    }

    private final void group(int key, boolean active, Style style) {
        if (active) {
            int i = this.currentIndex;
            int i2 = key ^ i;
            this.compositeHash = ResolvedStyleKt.updateHashEnter(this.compositeHash, i2);
            MutableIntList mutableIntListPushIndex = pushIndex(i);
            this.currentIndex = 0;
            style.applyStyle(this);
            this.currentIndex = mutableIntListPushIndex.removeAt(mutableIntListPushIndex._size - 1) + 1;
            this.compositeHash = ResolvedStyleKt.updateHashExit(this.compositeHash, i2);
            return;
        }
        this.currentIndex++;
    }
}
