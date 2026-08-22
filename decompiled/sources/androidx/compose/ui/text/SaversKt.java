package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
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
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010\u0005*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\u0010\n\u001aP\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010\u0005*\u00020\u0001\"\u0006\b\u0003\u0010\f\u0018\u00012\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00052\u0006\u0010\u0007\u001a\u0002H\u0002H\u0080\b¢\u0006\u0002\u0010\r\u001ay\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000f\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012.\u0010\u0000\u001a*\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0010¢\u0006\u0002\b\u00132#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0014H\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u0002H\u0000¢\u0006\u0002\u0010\u0015\u001a\"\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0006\b\u0000\u0010\f\u0018\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0080\b¢\u0006\u0002\u0010\u0015\" \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"(\u0010\u001a\u001a\u001c\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001c0\u001b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u001d\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001c\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001f\"\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001f\"\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019\" \u0010,\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019\" \u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019\"$\u00102\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010\u0003*\u0002048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u00106\"\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u0003*\u0002098@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010:\"\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010\u0003*\u00020=8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010>\"\u001a\u0010?\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00010\u0003*\u00020A8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010B\"\u001a\u0010C\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00010\u0003*\u00020E8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010F\"\u001a\u0010G\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010\u0003*\u00020I8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010J\"\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00010\u0003*\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010N\"\u001a\u0010O\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00010\u0003*\u00020Q8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010R\"\u001a\u0010S\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00010\u0003*\u00020U8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010V\"\u001a\u0010W\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00010\u0003*\u00020Y8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010Z\"\u001a\u0010[\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u00010\u0003*\u00020]8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010^\"\u001a\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00010\u0003*\u00020a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010b\" \u0010c\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\u0019\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u00010\u0003*\u00020f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010g\" \u0010h\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u0019\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020\u00010\u0003*\u00020k8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010l\"\u001a\u0010m\u001a\u000e\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\u00010\u0003*\u00020o8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010p\" \u0010q\u001a\u000e\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\u00010\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010s\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u00010\u0003*\u00020u8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010v\"\u001a\u0010w\u001a\u000e\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020x\u0012\u0004\u0012\u00020\u00010\u0003*\u00020y8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010z\"\u001a\u0010{\u001a\u000e\u0012\u0004\u0012\u00020x\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020\u00010\u0003*\u00020}8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010~\"\u001a\u0010\u007f\u001a\u000e\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"'\u00102\u001a\u000f\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u0081\u00018@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b5\u0010\u0082\u0001\"\u001c\u0010\u0083\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"'\u00102\u001a\u000f\u0012\u0005\u0012\u00030\u0084\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u0085\u00018BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b5\u0010\u0086\u0001\"\u001c\u0010\u0087\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0084\u0001\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"'\u00102\u001a\u000f\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u0089\u00018BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b5\u0010\u008a\u0001\"\u001c\u0010\u008b\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"'\u00102\u001a\u000f\u0012\u0005\u0012\u00030\u008c\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u008d\u00018BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b5\u0010\u008e\u0001\"\u001c\u0010\u008f\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u008c\u0001\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001"}, d2 = {"save", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/saveable/Saver;", "Original", "Saveable", "value", "saver", "scope", "Landroidx/compose/runtime/saveable/SaverScope;", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaverScope;)Ljava/lang/Object;", "restore", "Result", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;)Ljava/lang/Object;", "NonNullValueClassSaver", "Landroidx/compose/ui/text/NonNullValueClassSaver;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "Lkotlin/Function1;", "(Ljava/lang/Object;)Ljava/lang/Object;", "AnnotatedStringSaver", "Landroidx/compose/ui/text/AnnotatedString;", "getAnnotatedStringSaver", "()Landroidx/compose/runtime/saveable/Saver;", "AnnotationRangeListSaver", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "AnnotationRangeSaver", "getAnnotationRangeSaver$annotations", "()V", "VerbatimTtsAnnotationSaver", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "UrlAnnotationSaver", "Landroidx/compose/ui/text/UrlAnnotation;", "getUrlAnnotationSaver$annotations", "LinkSaver", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "ClickableSaver", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "ParagraphStyleSaver", "Landroidx/compose/ui/text/ParagraphStyle;", "getParagraphStyleSaver", "SpanStyleSaver", "Landroidx/compose/ui/text/SpanStyle;", "getSpanStyleSaver", "TextLinkStylesSaver", "Landroidx/compose/ui/text/TextLinkStyles;", "getTextLinkStylesSaver", "Saver", "Landroidx/compose/ui/text/style/TextDecoration;", "Landroidx/compose/ui/text/style/TextDecoration$Companion;", "getSaver", "(Landroidx/compose/ui/text/style/TextDecoration$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextDecorationSaver", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "(Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextGeometricTransformSaver", "Landroidx/compose/ui/text/style/TextIndent;", "Landroidx/compose/ui/text/style/TextIndent$Companion;", "(Landroidx/compose/ui/text/style/TextIndent$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextIndentSaver", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/runtime/saveable/Saver;", "FontWeightSaver", "Landroidx/compose/ui/text/style/BaselineShift;", "Landroidx/compose/ui/text/style/BaselineShift$Companion;", "(Landroidx/compose/ui/text/style/BaselineShift$Companion;)Landroidx/compose/runtime/saveable/Saver;", "BaselineShiftSaver", "Landroidx/compose/ui/text/TextRange;", "Landroidx/compose/ui/text/TextRange$Companion;", "(Landroidx/compose/ui/text/TextRange$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextRangeSaver", "Landroidx/compose/ui/graphics/Shadow;", "Landroidx/compose/ui/graphics/Shadow$Companion;", "(Landroidx/compose/ui/graphics/Shadow$Companion;)Landroidx/compose/runtime/saveable/Saver;", "ShadowSaver", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/ui/graphics/Color$Companion;", "(Landroidx/compose/ui/graphics/Color$Companion;)Landroidx/compose/runtime/saveable/Saver;", "ColorSaver", "Landroidx/compose/ui/text/style/TextAlign;", "Landroidx/compose/ui/text/style/TextAlign$Companion;", "(Landroidx/compose/ui/text/style/TextAlign$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextAlignSaver", "Landroidx/compose/ui/text/style/TextDirection;", "Landroidx/compose/ui/text/style/TextDirection$Companion;", "(Landroidx/compose/ui/text/style/TextDirection$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextDirectionSaver", "Landroidx/compose/ui/text/style/Hyphens;", "Landroidx/compose/ui/text/style/Hyphens$Companion;", "(Landroidx/compose/ui/text/style/Hyphens$Companion;)Landroidx/compose/runtime/saveable/Saver;", "HyphensSaver", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontStyle$Companion;", "(Landroidx/compose/ui/text/font/FontStyle$Companion;)Landroidx/compose/runtime/saveable/Saver;", "FontStyleSaver", "getFontStyleSaver", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroidx/compose/ui/text/font/FontSynthesis$Companion;", "(Landroidx/compose/ui/text/font/FontSynthesis$Companion;)Landroidx/compose/runtime/saveable/Saver;", "FontSynthesisSaver", "getFontSynthesisSaver", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/TextUnit$Companion;", "(Landroidx/compose/ui/unit/TextUnit$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextUnitSaver", "Landroidx/compose/ui/unit/TextUnitType;", "Landroidx/compose/ui/unit/TextUnitType$Companion;", "(Landroidx/compose/ui/unit/TextUnitType$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextUnitTypeSaver", "getTextUnitTypeSaver", "()Landroidx/compose/ui/text/NonNullValueClassSaver;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Offset$Companion;", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/runtime/saveable/Saver;", "OffsetSaver", "Landroidx/compose/ui/text/intl/LocaleList;", "Landroidx/compose/ui/text/intl/LocaleList$Companion;", "(Landroidx/compose/ui/text/intl/LocaleList$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LocaleListSaver", "Landroidx/compose/ui/text/intl/Locale;", "Landroidx/compose/ui/text/intl/Locale$Companion;", "(Landroidx/compose/ui/text/intl/Locale$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LocaleSaver", "Landroidx/compose/ui/text/style/LineHeightStyle;", "Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleSaver", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleAlignmentSaver", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleTrimSaver", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Mode$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleModeSaver", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SaversKt {
    private static final Saver<AnnotatedString, Object> AnnotatedStringSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.AnnotatedStringSaver$lambda$0((SaverScope) obj, (AnnotatedString) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.AnnotatedStringSaver$lambda$1(obj);
        }
    });
    private static final Saver<List<AnnotatedString.Range<? extends Object>>, Object> AnnotationRangeListSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda14
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.AnnotationRangeListSaver$lambda$0((SaverScope) obj, (List) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda26
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.AnnotationRangeListSaver$lambda$1(obj);
        }
    });
    private static final Saver<AnnotatedString.Range<? extends Object>, Object> AnnotationRangeSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda38
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.AnnotationRangeSaver$lambda$0((SaverScope) obj, (AnnotatedString.Range) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda50
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.AnnotationRangeSaver$lambda$1(obj);
        }
    });
    private static final Saver<VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda53
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.VerbatimTtsAnnotationSaver$lambda$0((SaverScope) obj, (VerbatimTtsAnnotation) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda54
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.VerbatimTtsAnnotationSaver$lambda$1(obj);
        }
    });
    private static final Saver<UrlAnnotation, Object> UrlAnnotationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda56
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.UrlAnnotationSaver$lambda$0((SaverScope) obj, (UrlAnnotation) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda57
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.UrlAnnotationSaver$lambda$1(obj);
        }
    });
    private static final Saver<LinkAnnotation.Url, Object> LinkSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LinkSaver$lambda$0((SaverScope) obj, (LinkAnnotation.Url) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda22
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LinkSaver$lambda$1(obj);
        }
    });
    private static final Saver<LinkAnnotation.Clickable, Object> ClickableSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda33
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.ClickableSaver$lambda$0((SaverScope) obj, (LinkAnnotation.Clickable) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda44
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.ClickableSaver$lambda$1(obj);
        }
    });
    private static final Saver<ParagraphStyle, Object> ParagraphStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda55
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.ParagraphStyleSaver$lambda$0((SaverScope) obj, (ParagraphStyle) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda58
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.ParagraphStyleSaver$lambda$1(obj);
        }
    });
    private static final Saver<SpanStyle, Object> SpanStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda59
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.SpanStyleSaver$lambda$0((SaverScope) obj, (SpanStyle) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda60
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.SpanStyleSaver$lambda$1(obj);
        }
    });
    private static final Saver<TextLinkStyles, Object> TextLinkStylesSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda61
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextLinkStylesSaver$lambda$0((SaverScope) obj, (TextLinkStyles) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextLinkStylesSaver$lambda$1(obj);
        }
    });
    private static final Saver<TextDecoration, Object> TextDecorationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextDecorationSaver$lambda$0((SaverScope) obj, (TextDecoration) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextDecorationSaver$lambda$1(obj);
        }
    });
    private static final Saver<TextGeometricTransform, Object> TextGeometricTransformSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextGeometricTransformSaver$lambda$0((SaverScope) obj, (TextGeometricTransform) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextGeometricTransformSaver$lambda$1(obj);
        }
    });
    private static final Saver<TextIndent, Object> TextIndentSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextIndentSaver$lambda$0((SaverScope) obj, (TextIndent) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextIndentSaver$lambda$1(obj);
        }
    });
    private static final Saver<FontWeight, Object> FontWeightSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.FontWeightSaver$lambda$0((SaverScope) obj, (FontWeight) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.FontWeightSaver$lambda$1(obj);
        }
    });
    private static final Saver<BaselineShift, Object> BaselineShiftSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.BaselineShiftSaver$lambda$0((SaverScope) obj, (BaselineShift) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.BaselineShiftSaver$lambda$1(obj);
        }
    });
    private static final Saver<TextRange, Object> TextRangeSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda15
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextRangeSaver$lambda$0((SaverScope) obj, (TextRange) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda16
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextRangeSaver$lambda$1(obj);
        }
    });
    private static final Saver<Shadow, Object> ShadowSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda17
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.ShadowSaver$lambda$0((SaverScope) obj, (Shadow) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda18
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.ShadowSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<Color, Object> ColorSaver = NonNullValueClassSaver(new Function2<SaverScope, Color, Object>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Color color) {
            return m8199invoke4WTKRHQ(saverScope, color.m5978unboximpl());
        }

        /* JADX INFO: renamed from: invoke-4WTKRHQ, reason: not valid java name */
        public final Object m8199invoke4WTKRHQ(SaverScope saverScope, long j) {
            if (j == 16) {
                return false;
            }
            return Integer.valueOf(ColorKt.m6022toArgb8_81llA(j));
        }
    }, new Function1<Object, Color>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke-ijrfgN4, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Color invoke(Object obj) {
            if (Intrinsics.areEqual(obj, (Object) false)) {
                return Color.m5958boximpl(Color.INSTANCE.m6004getUnspecified0d7_KjU());
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return Color.m5958boximpl(ColorKt.Color(((Integer) obj).intValue()));
        }
    });
    private static final NonNullValueClassSaver<TextAlign, Object> TextAlignSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda19
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextAlignSaver$lambda$0((SaverScope) obj, (TextAlign) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda20
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextAlignSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<TextDirection, Object> TextDirectionSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda21
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextDirectionSaver$lambda$0((SaverScope) obj, (TextDirection) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda23
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextDirectionSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<Hyphens, Object> HyphensSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda24
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.HyphensSaver$lambda$0((SaverScope) obj, (Hyphens) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda25
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.HyphensSaver$lambda$1(obj);
        }
    });
    private static final Saver<FontStyle, Object> FontStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda27
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.FontStyleSaver$lambda$0((SaverScope) obj, (FontStyle) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda28
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.FontStyleSaver$lambda$1(obj);
        }
    });
    private static final Saver<FontSynthesis, Object> FontSynthesisSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda29
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.FontSynthesisSaver$lambda$0((SaverScope) obj, (FontSynthesis) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda30
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.FontSynthesisSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<TextUnit, Object> TextUnitSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda31
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextUnitSaver$lambda$0((SaverScope) obj, (TextUnit) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda32
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextUnitSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<TextUnitType, Object> TextUnitTypeSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda34
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextUnitTypeSaver$lambda$0((SaverScope) obj, (TextUnitType) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda35
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextUnitTypeSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<Offset, Object> OffsetSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda36
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.OffsetSaver$lambda$0((SaverScope) obj, (Offset) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda37
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.OffsetSaver$lambda$1(obj);
        }
    });
    private static final Saver<LocaleList, Object> LocaleListSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda39
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LocaleListSaver$lambda$0((SaverScope) obj, (LocaleList) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda40
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LocaleListSaver$lambda$1(obj);
        }
    });
    private static final Saver<Locale, Object> LocaleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda41
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LocaleSaver$lambda$0((SaverScope) obj, (Locale) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda42
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LocaleSaver$lambda$1(obj);
        }
    });
    private static final Saver<LineHeightStyle, Object> LineHeightStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda43
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LineHeightStyleSaver$lambda$0((SaverScope) obj, (LineHeightStyle) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda45
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LineHeightStyleSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<LineHeightStyle.Alignment, Object> LineHeightStyleAlignmentSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda46
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LineHeightStyleAlignmentSaver$lambda$0((SaverScope) obj, (LineHeightStyle.Alignment) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda47
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LineHeightStyleAlignmentSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<LineHeightStyle.Trim, Object> LineHeightStyleTrimSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda48
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LineHeightStyleTrimSaver$lambda$0((SaverScope) obj, (LineHeightStyle.Trim) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda49
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LineHeightStyleTrimSaver$lambda$1(obj);
        }
    });
    private static final NonNullValueClassSaver<LineHeightStyle.Mode, Object> LineHeightStyleModeSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda51
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LineHeightStyleModeSaver$lambda$0((SaverScope) obj, (LineHeightStyle.Mode) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda52
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LineHeightStyleModeSaver$lambda$1(obj);
        }
    });

    /* JADX INFO: compiled from: Savers.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.Paragraph.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.Span.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.Url.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.Link.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.Clickable.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationType.String.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static /* synthetic */ void getAnnotationRangeSaver$annotations() {
    }

    private static /* synthetic */ void getUrlAnnotationSaver$annotations() {
    }

    public static final <T> T save(T t) {
        return t;
    }

    public static final <T extends Saver<Original, Saveable>, Original, Saveable> Object save(Original original, T t, SaverScope saverScope) {
        Object objSave;
        if (original == null || (objSave = t.save(saverScope, original)) == null) {
            return false;
        }
        return objSave;
    }

    public static final /* synthetic */ <T extends Saver<Original, Saveable>, Original, Saveable, Result> Result restore(Saveable saveable, T t) {
        if ((Intrinsics.areEqual((Object) saveable, (Object) false) && !(t instanceof NonNullValueClassSaver)) || saveable == null) {
            return null;
        }
        Result result = (Result) t.restore(saveable);
        Intrinsics.reifiedOperationMarker(1, "Result");
        return result;
    }

    private static final <Original, Saveable> NonNullValueClassSaver<Original, Saveable> NonNullValueClassSaver(final Function2<? super SaverScope, ? super Original, ? extends Saveable> function2, final Function1<? super Saveable, ? extends Original> function1) {
        return new NonNullValueClassSaver<Original, Saveable>() { // from class: androidx.compose.ui.text.SaversKt.NonNullValueClassSaver.1
            @Override // androidx.compose.runtime.saveable.Saver
            public Saveable save(SaverScope saverScope, Original original) {
                return function2.invoke(saverScope, original);
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public Original restore(Saveable value) {
                return function1.invoke(value);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <Result> Result restore(Object obj) {
        if (obj == 0) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(1, "Result");
        return obj;
    }

    public static final Saver<AnnotatedString, Object> getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AnnotatedStringSaver$lambda$0(SaverScope saverScope, AnnotatedString annotatedString) {
        return CollectionsKt.arrayListOf(save(annotatedString.getText()), save(annotatedString.getAnnotations$ui_text(), AnnotationRangeListSaver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString AnnotatedStringSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(1);
        Saver<List<AnnotatedString.Range<? extends Object>>, Object> saver = AnnotationRangeListSaver;
        List<AnnotatedString.Range<? extends Object>> listRestore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Object obj3 = list.get(0);
        String str = obj3 != null ? (String) obj3 : null;
        Intrinsics.checkNotNull(str);
        return new AnnotatedString(listRestore, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List AnnotationRangeListSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = list.get(i);
            ArrayList arrayList2 = arrayList;
            Saver<AnnotatedString.Range<? extends Object>, Object> saver = AnnotationRangeSaver;
            AnnotatedString.Range<? extends Object> rangeRestore = null;
            if ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                rangeRestore = saver.restore(obj2);
            }
            Intrinsics.checkNotNull(rangeRestore);
            arrayList2.add(rangeRestore);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AnnotationRangeSaver$lambda$0(SaverScope saverScope, AnnotatedString.Range range) {
        AnnotationType annotationType;
        Object objSave;
        Object item = range.getItem();
        if (item instanceof ParagraphStyle) {
            annotationType = AnnotationType.Paragraph;
        } else if (item instanceof SpanStyle) {
            annotationType = AnnotationType.Span;
        } else if (item instanceof VerbatimTtsAnnotation) {
            annotationType = AnnotationType.VerbatimTts;
        } else if (item instanceof UrlAnnotation) {
            annotationType = AnnotationType.Url;
        } else if (item instanceof LinkAnnotation.Url) {
            annotationType = AnnotationType.Link;
        } else if (item instanceof LinkAnnotation.Clickable) {
            annotationType = AnnotationType.Clickable;
        } else {
            if (!(item instanceof StringAnnotation)) {
                throw new UnsupportedOperationException();
            }
            annotationType = AnnotationType.String;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
            case 1:
                Object item2 = range.getItem();
                Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                objSave = save((ParagraphStyle) item2, ParagraphStyleSaver, saverScope);
                break;
            case 2:
                Object item3 = range.getItem();
                Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                objSave = save((SpanStyle) item3, SpanStyleSaver, saverScope);
                break;
            case 3:
                Object item4 = range.getItem();
                Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                objSave = save((VerbatimTtsAnnotation) item4, VerbatimTtsAnnotationSaver, saverScope);
                break;
            case 4:
                Object item5 = range.getItem();
                Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                objSave = save((UrlAnnotation) item5, UrlAnnotationSaver, saverScope);
                break;
            case 5:
                Object item6 = range.getItem();
                Intrinsics.checkNotNull(item6, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                objSave = save((LinkAnnotation.Url) item6, LinkSaver, saverScope);
                break;
            case 6:
                Object item7 = range.getItem();
                Intrinsics.checkNotNull(item7, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
                objSave = save((LinkAnnotation.Clickable) item7, ClickableSaver, saverScope);
                break;
            case 7:
                Object item8 = range.getItem();
                Intrinsics.checkNotNull(item8, "null cannot be cast to non-null type androidx.compose.ui.text.StringAnnotation");
                objSave = save(((StringAnnotation) item8).m8226unboximpl());
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return CollectionsKt.arrayListOf(save(annotationType), objSave, save(Integer.valueOf(range.getStart())), save(Integer.valueOf(range.getEnd())), save(range.getTag()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString.Range AnnotationRangeSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        ParagraphStyle paragraphStyleRestore = null;
        clickableRestore = null;
        LinkAnnotation.Clickable clickableRestore = null;
        urlRestore = null;
        LinkAnnotation.Url urlRestore = null;
        urlAnnotationRestore = null;
        UrlAnnotation urlAnnotationRestore = null;
        verbatimTtsAnnotationRestore = null;
        VerbatimTtsAnnotation verbatimTtsAnnotationRestore = null;
        spanStyleRestore = null;
        SpanStyle spanStyleRestore = null;
        paragraphStyleRestore = null;
        AnnotationType annotationType = obj2 != null ? (AnnotationType) obj2 : null;
        Intrinsics.checkNotNull(annotationType);
        Object obj3 = list.get(2);
        Integer num = obj3 != null ? (Integer) obj3 : null;
        Intrinsics.checkNotNull(num);
        int iIntValue = num.intValue();
        Object obj4 = list.get(3);
        Integer num2 = obj4 != null ? (Integer) obj4 : null;
        Intrinsics.checkNotNull(num2);
        int iIntValue2 = num2.intValue();
        Object obj5 = list.get(4);
        String str = obj5 != null ? (String) obj5 : null;
        Intrinsics.checkNotNull(str);
        switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
            case 1:
                Object obj6 = list.get(1);
                Saver<ParagraphStyle, Object> saver = ParagraphStyleSaver;
                if ((!Intrinsics.areEqual(obj6, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj6 != null) {
                    paragraphStyleRestore = saver.restore(obj6);
                }
                Intrinsics.checkNotNull(paragraphStyleRestore);
                return new AnnotatedString.Range(paragraphStyleRestore, iIntValue, iIntValue2, str);
            case 2:
                Object obj7 = list.get(1);
                Saver<SpanStyle, Object> saver2 = SpanStyleSaver;
                if ((!Intrinsics.areEqual(obj7, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj7 != null) {
                    spanStyleRestore = saver2.restore(obj7);
                }
                Intrinsics.checkNotNull(spanStyleRestore);
                return new AnnotatedString.Range(spanStyleRestore, iIntValue, iIntValue2, str);
            case 3:
                Object obj8 = list.get(1);
                Saver<VerbatimTtsAnnotation, Object> saver3 = VerbatimTtsAnnotationSaver;
                if ((!Intrinsics.areEqual(obj8, (Object) false) || (saver3 instanceof NonNullValueClassSaver)) && obj8 != null) {
                    verbatimTtsAnnotationRestore = saver3.restore(obj8);
                }
                Intrinsics.checkNotNull(verbatimTtsAnnotationRestore);
                return new AnnotatedString.Range(verbatimTtsAnnotationRestore, iIntValue, iIntValue2, str);
            case 4:
                Object obj9 = list.get(1);
                Saver<UrlAnnotation, Object> saver4 = UrlAnnotationSaver;
                if ((!Intrinsics.areEqual(obj9, (Object) false) || (saver4 instanceof NonNullValueClassSaver)) && obj9 != null) {
                    urlAnnotationRestore = saver4.restore(obj9);
                }
                Intrinsics.checkNotNull(urlAnnotationRestore);
                return new AnnotatedString.Range(urlAnnotationRestore, iIntValue, iIntValue2, str);
            case 5:
                Object obj10 = list.get(1);
                Saver<LinkAnnotation.Url, Object> saver5 = LinkSaver;
                if ((!Intrinsics.areEqual(obj10, (Object) false) || (saver5 instanceof NonNullValueClassSaver)) && obj10 != null) {
                    urlRestore = saver5.restore(obj10);
                }
                Intrinsics.checkNotNull(urlRestore);
                return new AnnotatedString.Range(urlRestore, iIntValue, iIntValue2, str);
            case 6:
                Object obj11 = list.get(1);
                Saver<LinkAnnotation.Clickable, Object> saver6 = ClickableSaver;
                if ((!Intrinsics.areEqual(obj11, (Object) false) || (saver6 instanceof NonNullValueClassSaver)) && obj11 != null) {
                    clickableRestore = saver6.restore(obj11);
                }
                Intrinsics.checkNotNull(clickableRestore);
                return new AnnotatedString.Range(clickableRestore, iIntValue, iIntValue2, str);
            case 7:
                Object obj12 = list.get(1);
                String str2 = obj12 != null ? (String) obj12 : null;
                Intrinsics.checkNotNull(str2);
                return new AnnotatedString.Range(StringAnnotation.m8220boximpl(StringAnnotation.m8221constructorimpl(str2)), iIntValue, iIntValue2, str);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object VerbatimTtsAnnotationSaver$lambda$0(SaverScope saverScope, VerbatimTtsAnnotation verbatimTtsAnnotation) {
        return save(verbatimTtsAnnotation.getVerbatim());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VerbatimTtsAnnotation VerbatimTtsAnnotationSaver$lambda$1(Object obj) {
        String str = obj != null ? (String) obj : null;
        Intrinsics.checkNotNull(str);
        return new VerbatimTtsAnnotation(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object UrlAnnotationSaver$lambda$0(SaverScope saverScope, UrlAnnotation urlAnnotation) {
        return save(urlAnnotation.getUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UrlAnnotation UrlAnnotationSaver$lambda$1(Object obj) {
        String str = obj != null ? (String) obj : null;
        Intrinsics.checkNotNull(str);
        return new UrlAnnotation(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LinkSaver$lambda$0(SaverScope saverScope, LinkAnnotation.Url url) {
        return CollectionsKt.arrayListOf(save(url.getUrl()), save(url.getStyles(), TextLinkStylesSaver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkAnnotation.Url LinkSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextLinkStyles textLinkStylesRestore = null;
        String str = obj2 != null ? (String) obj2 : null;
        Intrinsics.checkNotNull(str);
        Object obj3 = list.get(1);
        Saver<TextLinkStyles, Object> saver = TextLinkStylesSaver;
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) {
            textLinkStylesRestore = saver.restore(obj3);
        }
        return new LinkAnnotation.Url(str, textLinkStylesRestore, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ClickableSaver$lambda$0(SaverScope saverScope, LinkAnnotation.Clickable clickable) {
        return CollectionsKt.arrayListOf(save(clickable.getTag()), save(clickable.getStyles(), TextLinkStylesSaver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkAnnotation.Clickable ClickableSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        String str = obj2 != null ? (String) obj2 : null;
        Intrinsics.checkNotNull(str);
        Object obj3 = list.get(1);
        Saver<TextLinkStyles, Object> saver = TextLinkStylesSaver;
        return new LinkAnnotation.Clickable(str, ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) ? saver.restore(obj3) : null, null);
    }

    public static final Saver<ParagraphStyle, Object> getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ParagraphStyleSaver$lambda$0(SaverScope saverScope, ParagraphStyle paragraphStyle) {
        return CollectionsKt.arrayListOf(save(TextAlign.m8701boximpl(paragraphStyle.getTextAlign()), getSaver(TextAlign.INSTANCE), saverScope), save(TextDirection.m8718boximpl(paragraphStyle.getTextDirection()), getSaver(TextDirection.INSTANCE), saverScope), save(TextUnit.m9014boximpl(paragraphStyle.getLineHeight()), getSaver(TextUnit.INSTANCE), saverScope), save(paragraphStyle.getTextIndent(), getSaver(TextIndent.INSTANCE), saverScope), save(paragraphStyle.getPlatformStyle(), Savers_androidKt.getSaver(PlatformParagraphStyle.INSTANCE), saverScope), save(paragraphStyle.getLineHeightStyle(), getSaver(LineHeightStyle.INSTANCE), saverScope), save(LineBreak.m8606boximpl(paragraphStyle.getLineBreak()), Savers_androidKt.getSaver(LineBreak.INSTANCE), saverScope), save(Hyphens.m8593boximpl(paragraphStyle.getHyphens()), getSaver(Hyphens.INSTANCE), saverScope), save(paragraphStyle.getTextMotion(), Savers_androidKt.getSaver(TextMotion.INSTANCE), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParagraphStyle ParagraphStyleSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<TextAlign, Object> saver = getSaver(TextAlign.INSTANCE);
        TextMotion textMotionRestore = null;
        TextAlign textAlignRestore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(textAlignRestore);
        int iM8707unboximpl = textAlignRestore.m8707unboximpl();
        Object obj3 = list.get(1);
        Saver<TextDirection, Object> saver2 = getSaver(TextDirection.INSTANCE);
        TextDirection textDirectionRestore = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? saver2.restore(obj3) : null;
        Intrinsics.checkNotNull(textDirectionRestore);
        int iM8724unboximpl = textDirectionRestore.m8724unboximpl();
        Object obj4 = list.get(2);
        Saver<TextUnit, Object> saver3 = getSaver(TextUnit.INSTANCE);
        TextUnit textUnitRestore = ((!Intrinsics.areEqual(obj4, (Object) false) || (saver3 instanceof NonNullValueClassSaver)) && obj4 != null) ? saver3.restore(obj4) : null;
        Intrinsics.checkNotNull(textUnitRestore);
        long packedValue = textUnitRestore.getPackedValue();
        Object obj5 = list.get(3);
        Saver<TextIndent, Object> saver4 = getSaver(TextIndent.INSTANCE);
        TextIndent textIndentRestore = ((!Intrinsics.areEqual(obj5, (Object) false) || (saver4 instanceof NonNullValueClassSaver)) && obj5 != null) ? saver4.restore(obj5) : null;
        Object obj6 = list.get(4);
        Saver<PlatformParagraphStyle, Object> saver5 = Savers_androidKt.getSaver(PlatformParagraphStyle.INSTANCE);
        PlatformParagraphStyle platformParagraphStyleRestore = ((!Intrinsics.areEqual(obj6, (Object) false) || (saver5 instanceof NonNullValueClassSaver)) && obj6 != null) ? saver5.restore(obj6) : null;
        Object obj7 = list.get(5);
        Saver<LineHeightStyle, Object> saver6 = getSaver(LineHeightStyle.INSTANCE);
        LineHeightStyle lineHeightStyleRestore = ((!Intrinsics.areEqual(obj7, (Object) false) || (saver6 instanceof NonNullValueClassSaver)) && obj7 != null) ? saver6.restore(obj7) : null;
        Object obj8 = list.get(6);
        Saver<LineBreak, Object> saver7 = Savers_androidKt.getSaver(LineBreak.INSTANCE);
        LineBreak lineBreakRestore = ((!Intrinsics.areEqual(obj8, (Object) false) || (saver7 instanceof NonNullValueClassSaver)) && obj8 != null) ? saver7.restore(obj8) : null;
        Intrinsics.checkNotNull(lineBreakRestore);
        int mask = lineBreakRestore.getMask();
        Object obj9 = list.get(7);
        Saver<Hyphens, Object> saver8 = getSaver(Hyphens.INSTANCE);
        Hyphens hyphensRestore = ((!Intrinsics.areEqual(obj9, (Object) false) || (saver8 instanceof NonNullValueClassSaver)) && obj9 != null) ? saver8.restore(obj9) : null;
        Intrinsics.checkNotNull(hyphensRestore);
        int iM8599unboximpl = hyphensRestore.m8599unboximpl();
        Object obj10 = list.get(8);
        Saver<TextMotion, Object> saver9 = Savers_androidKt.getSaver(TextMotion.INSTANCE);
        if ((!Intrinsics.areEqual(obj10, (Object) false) || (saver9 instanceof NonNullValueClassSaver)) && obj10 != null) {
            textMotionRestore = saver9.restore(obj10);
        }
        return new ParagraphStyle(iM8707unboximpl, iM8724unboximpl, packedValue, textIndentRestore, platformParagraphStyleRestore, lineHeightStyleRestore, mask, iM8599unboximpl, textMotionRestore, (DefaultConstructorMarker) null);
    }

    public static final Saver<SpanStyle, Object> getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SpanStyleSaver$lambda$0(SaverScope saverScope, SpanStyle spanStyle) {
        return CollectionsKt.arrayListOf(save(Color.m5958boximpl(spanStyle.m8213getColor0d7_KjU()), getSaver(Color.INSTANCE), saverScope), save(TextUnit.m9014boximpl(spanStyle.getFontSize()), getSaver(TextUnit.INSTANCE), saverScope), save(spanStyle.getFontWeight(), getSaver(FontWeight.INSTANCE), saverScope), save(spanStyle.getFontStyle(), getSaver(FontStyle.INSTANCE), saverScope), save(spanStyle.getFontSynthesis(), getSaver(FontSynthesis.INSTANCE), saverScope), save(-1), save(spanStyle.getFontFeatureSettings()), save(TextUnit.m9014boximpl(spanStyle.getLetterSpacing()), getSaver(TextUnit.INSTANCE), saverScope), save(spanStyle.getBaselineShift(), getSaver(BaselineShift.INSTANCE), saverScope), save(spanStyle.getTextGeometricTransform(), getSaver(TextGeometricTransform.INSTANCE), saverScope), save(spanStyle.getLocaleList(), getSaver(LocaleList.INSTANCE), saverScope), save(Color.m5958boximpl(spanStyle.getBackground()), getSaver(Color.INSTANCE), saverScope), save(spanStyle.getTextDecoration(), getSaver(TextDecoration.INSTANCE), saverScope), save(spanStyle.getShadow(), getSaver(Shadow.INSTANCE), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 androidx.compose.ui.text.SpanStyle, still in use, count: 2, list:
          (r1v1 androidx.compose.ui.text.SpanStyle) from 0x0129: MOVE (r16v2 androidx.compose.ui.text.SpanStyle) = (r1v1 androidx.compose.ui.text.SpanStyle)
          (r1v1 androidx.compose.ui.text.SpanStyle) from 0x0122: MOVE (r16v7 androidx.compose.ui.text.SpanStyle) = (r1v1 androidx.compose.ui.text.SpanStyle)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public static final androidx.compose.ui.text.SpanStyle SpanStyleSaver$lambda$1(java.lang.Object r24) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SaversKt.SpanStyleSaver$lambda$1(java.lang.Object):androidx.compose.ui.text.SpanStyle");
    }

    public static final Saver<TextLinkStyles, Object> getTextLinkStylesSaver() {
        return TextLinkStylesSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextLinkStylesSaver$lambda$0(SaverScope saverScope, TextLinkStyles textLinkStyles) {
        SpanStyle style = textLinkStyles.getStyle();
        Saver<SpanStyle, Object> saver = SpanStyleSaver;
        return CollectionsKt.arrayListOf(save(style, saver, saverScope), save(textLinkStyles.getFocusedStyle(), saver, saverScope), save(textLinkStyles.getHoveredStyle(), saver, saverScope), save(textLinkStyles.getPressedStyle(), saver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextLinkStyles TextLinkStylesSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<SpanStyle, Object> saver = SpanStyleSaver;
        SpanStyle spanStyleRestore = null;
        SpanStyle spanStyleRestore2 = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Object obj3 = list.get(1);
        SpanStyle spanStyleRestore3 = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) ? saver.restore(obj3) : null;
        Object obj4 = list.get(2);
        SpanStyle spanStyleRestore4 = ((!Intrinsics.areEqual(obj4, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj4 != null) ? saver.restore(obj4) : null;
        Object obj5 = list.get(3);
        if ((!Intrinsics.areEqual(obj5, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj5 != null) {
            spanStyleRestore = saver.restore(obj5);
        }
        return new TextLinkStyles(spanStyleRestore2, spanStyleRestore3, spanStyleRestore4, spanStyleRestore);
    }

    public static final Saver<TextDecoration, Object> getSaver(TextDecoration.Companion companion) {
        return TextDecorationSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextDecorationSaver$lambda$0(SaverScope saverScope, TextDecoration textDecoration) {
        return Integer.valueOf(textDecoration.getMask());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextDecoration TextDecorationSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return new TextDecoration(((Integer) obj).intValue());
    }

    public static final Saver<TextGeometricTransform, Object> getSaver(TextGeometricTransform.Companion companion) {
        return TextGeometricTransformSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextGeometricTransformSaver$lambda$0(SaverScope saverScope, TextGeometricTransform textGeometricTransform) {
        return CollectionsKt.arrayListOf(Float.valueOf(textGeometricTransform.getScaleX()), Float.valueOf(textGeometricTransform.getSkewX()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextGeometricTransform TextGeometricTransformSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
        List list = (List) obj;
        return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
    }

    public static final Saver<TextIndent, Object> getSaver(TextIndent.Companion companion) {
        return TextIndentSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextIndentSaver$lambda$0(SaverScope saverScope, TextIndent textIndent) {
        return CollectionsKt.arrayListOf(save(TextUnit.m9014boximpl(textIndent.getFirstLine()), getSaver(TextUnit.INSTANCE), saverScope), save(TextUnit.m9014boximpl(textIndent.getRestLine()), getSaver(TextUnit.INSTANCE), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextIndent TextIndentSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<TextUnit, Object> saver = getSaver(TextUnit.INSTANCE);
        TextUnit textUnitRestore = null;
        TextUnit textUnitRestore2 = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(textUnitRestore2);
        long packedValue = textUnitRestore2.getPackedValue();
        Object obj3 = list.get(1);
        Saver<TextUnit, Object> saver2 = getSaver(TextUnit.INSTANCE);
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) {
            textUnitRestore = saver2.restore(obj3);
        }
        Intrinsics.checkNotNull(textUnitRestore);
        return new TextIndent(packedValue, textUnitRestore.getPackedValue(), null);
    }

    public static final Saver<FontWeight, Object> getSaver(FontWeight.Companion companion) {
        return FontWeightSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object FontWeightSaver$lambda$0(SaverScope saverScope, FontWeight fontWeight) {
        return Integer.valueOf(fontWeight.getWeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontWeight FontWeightSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return new FontWeight(((Integer) obj).intValue());
    }

    public static final Saver<BaselineShift, Object> getSaver(BaselineShift.Companion companion) {
        return BaselineShiftSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object BaselineShiftSaver$lambda$0(SaverScope saverScope, BaselineShift baselineShift) {
        return Float.valueOf(baselineShift.m8576unboximpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaselineShift BaselineShiftSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
        return BaselineShift.m8570boximpl(BaselineShift.m8571constructorimpl(((Float) obj).floatValue()));
    }

    public static final Saver<TextRange, Object> getSaver(TextRange.Companion companion) {
        return TextRangeSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object TextRangeSaver$lambda$0(SaverScope saverScope, TextRange textRange) {
        return CollectionsKt.arrayListOf(save(Integer.valueOf(TextRange.m8273getStartimpl(textRange.getPackedValue()))), save(Integer.valueOf(TextRange.m8268getEndimpl(textRange.getPackedValue()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextRange TextRangeSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Integer num = obj2 != null ? (Integer) obj2 : null;
        Intrinsics.checkNotNull(num);
        int iIntValue = num.intValue();
        Object obj3 = list.get(1);
        Integer num2 = obj3 != null ? (Integer) obj3 : null;
        Intrinsics.checkNotNull(num2);
        return TextRange.m8261boximpl(TextRangeKt.TextRange(iIntValue, num2.intValue()));
    }

    public static final Saver<Shadow, Object> getSaver(Shadow.Companion companion) {
        return ShadowSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ShadowSaver$lambda$0(SaverScope saverScope, Shadow shadow) {
        return CollectionsKt.arrayListOf(save(Color.m5958boximpl(shadow.getColor()), getSaver(Color.INSTANCE), saverScope), save(Offset.m5712boximpl(shadow.getOffset()), getSaver(Offset.INSTANCE), saverScope), save(Float.valueOf(shadow.getBlurRadius())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shadow ShadowSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<Color, Object> saver = getSaver(Color.INSTANCE);
        Color colorRestore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(colorRestore);
        long jM5978unboximpl = colorRestore.m5978unboximpl();
        Object obj3 = list.get(1);
        Saver<Offset, Object> saver2 = getSaver(Offset.INSTANCE);
        Offset offsetRestore = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? saver2.restore(obj3) : null;
        Intrinsics.checkNotNull(offsetRestore);
        long jM5733unboximpl = offsetRestore.m5733unboximpl();
        Object obj4 = list.get(2);
        Float f2 = obj4 != null ? (Float) obj4 : null;
        Intrinsics.checkNotNull(f2);
        return new Shadow(jM5978unboximpl, jM5733unboximpl, f2.floatValue(), null);
    }

    public static final Saver<Color, Object> getSaver(Color.Companion companion) {
        return ColorSaver;
    }

    public static final Saver<TextAlign, Object> getSaver(TextAlign.Companion companion) {
        return TextAlignSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextAlignSaver$lambda$0(SaverScope saverScope, TextAlign textAlign) {
        return Integer.valueOf(textAlign.m8707unboximpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextAlign TextAlignSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return TextAlign.m8701boximpl(TextAlign.m8702constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<TextDirection, Object> getSaver(TextDirection.Companion companion) {
        return TextDirectionSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextDirectionSaver$lambda$0(SaverScope saverScope, TextDirection textDirection) {
        return Integer.valueOf(textDirection.m8724unboximpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextDirection TextDirectionSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return TextDirection.m8718boximpl(TextDirection.m8719constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<Hyphens, Object> getSaver(Hyphens.Companion companion) {
        return HyphensSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object HyphensSaver$lambda$0(SaverScope saverScope, Hyphens hyphens) {
        return Integer.valueOf(hyphens.m8599unboximpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Hyphens HyphensSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return Hyphens.m8593boximpl(Hyphens.m8594constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<FontStyle, Object> getSaver(FontStyle.Companion companion) {
        return FontStyleSaver;
    }

    public static final Saver<FontStyle, Object> getFontStyleSaver() {
        return FontStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object FontStyleSaver$lambda$0(SaverScope saverScope, FontStyle fontStyle) {
        return save(Integer.valueOf(fontStyle.m8390unboximpl()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontStyle FontStyleSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return FontStyle.m8384boximpl(FontStyle.m8385constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<FontSynthesis, Object> getSaver(FontSynthesis.Companion companion) {
        return FontSynthesisSaver;
    }

    public static final Saver<FontSynthesis, Object> getFontSynthesisSaver() {
        return FontSynthesisSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object FontSynthesisSaver$lambda$0(SaverScope saverScope, FontSynthesis fontSynthesis) {
        return Integer.valueOf(fontSynthesis.m8403unboximpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontSynthesis FontSynthesisSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return FontSynthesis.m8395boximpl(FontSynthesis.m8396constructorimpl(((Integer) obj).intValue()));
    }

    public static final Saver<TextUnit, Object> getSaver(TextUnit.Companion companion) {
        return TextUnitSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextUnitSaver$lambda$0(SaverScope saverScope, TextUnit textUnit) {
        if (textUnit == null ? false : TextUnit.m9021equalsimpl0(textUnit.getPackedValue(), TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE())) {
            return (Serializable) false;
        }
        return CollectionsKt.arrayListOf(save(Float.valueOf(TextUnit.m9024getValueimpl(textUnit.getPackedValue()))), save(TextUnitType.m9049boximpl(TextUnit.m9023getTypeUIouoOA(textUnit.getPackedValue())), getSaver(TextUnitType.INSTANCE), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextUnit TextUnitSaver$lambda$1(Object obj) {
        if (Intrinsics.areEqual(obj, (Object) false)) {
            return TextUnit.m9014boximpl(TextUnit.INSTANCE.m9035getUnspecifiedXSAIIZE());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextUnitType textUnitTypeRestore = null;
        Float f2 = obj2 != null ? (Float) obj2 : null;
        Intrinsics.checkNotNull(f2);
        float fFloatValue = f2.floatValue();
        Object obj3 = list.get(1);
        Saver<TextUnitType, Object> saver = getSaver(TextUnitType.INSTANCE);
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) {
            textUnitTypeRestore = saver.restore(obj3);
        }
        Intrinsics.checkNotNull(textUnitTypeRestore);
        return TextUnit.m9014boximpl(TextUnitKt.m9036TextUnitanM5pPY(fFloatValue, textUnitTypeRestore.getType()));
    }

    public static final Saver<TextUnitType, Object> getSaver(TextUnitType.Companion companion) {
        return TextUnitTypeSaver;
    }

    public static final NonNullValueClassSaver<TextUnitType, Object> getTextUnitTypeSaver() {
        return TextUnitTypeSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextUnitTypeSaver$lambda$0(SaverScope saverScope, TextUnitType textUnitType) {
        long type = textUnitType.getType();
        if (TextUnitType.m9052equalsimpl0(type, TextUnitType.INSTANCE.m9056getEmUIouoOA())) {
            return 0;
        }
        return TextUnitType.m9052equalsimpl0(type, TextUnitType.INSTANCE.m9057getSpUIouoOA()) ? 1 : false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextUnitType TextUnitTypeSaver$lambda$1(Object obj) {
        return Intrinsics.areEqual(obj, (Object) 0) ? TextUnitType.m9049boximpl(TextUnitType.INSTANCE.m9056getEmUIouoOA()) : Intrinsics.areEqual(obj, (Object) 1) ? TextUnitType.m9049boximpl(TextUnitType.INSTANCE.m9057getSpUIouoOA()) : TextUnitType.m9049boximpl(TextUnitType.INSTANCE.m9058getUnspecifiedUIouoOA());
    }

    public static final Saver<Offset, Object> getSaver(Offset.Companion companion) {
        return OffsetSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object OffsetSaver$lambda$0(SaverScope saverScope, Offset offset) {
        return offset == null ? false : Offset.m5720equalsimpl0(offset.m5733unboximpl(), Offset.INSTANCE.m5738getUnspecifiedF1C5BW0()) ? (Serializable) false : CollectionsKt.arrayListOf(save(Float.valueOf(Float.intBitsToFloat((int) (offset.m5733unboximpl() >> 32)))), save(Float.valueOf(Float.intBitsToFloat((int) (offset.m5733unboximpl() & 4294967295L)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset OffsetSaver$lambda$1(Object obj) {
        if (Intrinsics.areEqual(obj, (Object) false)) {
            return Offset.m5712boximpl(Offset.INSTANCE.m5738getUnspecifiedF1C5BW0());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Float f2 = obj2 != null ? (Float) obj2 : null;
        Intrinsics.checkNotNull(f2);
        float fFloatValue = f2.floatValue();
        Object obj3 = list.get(1);
        Float f3 = obj3 != null ? (Float) obj3 : null;
        Intrinsics.checkNotNull(f3);
        return Offset.m5712boximpl(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(f3.floatValue())) & 4294967295L)));
    }

    public static final Saver<LocaleList, Object> getSaver(LocaleList.Companion companion) {
        return LocaleListSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LocaleListSaver$lambda$0(SaverScope saverScope, LocaleList localeList) {
        List<Locale> localeList2 = localeList.getLocaleList();
        ArrayList arrayList = new ArrayList(localeList2.size());
        int size = localeList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(save(localeList2.get(i), getSaver(Locale.INSTANCE), saverScope));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocaleList LocaleListSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = list.get(i);
            ArrayList arrayList2 = arrayList;
            Saver<Locale, Object> saver = getSaver(Locale.INSTANCE);
            Locale localeRestore = null;
            if ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                localeRestore = saver.restore(obj2);
            }
            Intrinsics.checkNotNull(localeRestore);
            arrayList2.add(localeRestore);
        }
        return new LocaleList(arrayList);
    }

    public static final Saver<Locale, Object> getSaver(Locale.Companion companion) {
        return LocaleSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LocaleSaver$lambda$0(SaverScope saverScope, Locale locale) {
        return locale.toLanguageTag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale LocaleSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        return new Locale((String) obj);
    }

    public static final Saver<LineHeightStyle, Object> getSaver(LineHeightStyle.Companion companion) {
        return LineHeightStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LineHeightStyleSaver$lambda$0(SaverScope saverScope, LineHeightStyle lineHeightStyle) {
        return CollectionsKt.arrayListOf(save(LineHeightStyle.Alignment.m8667boximpl(lineHeightStyle.getAlignment()), getSaver(LineHeightStyle.Alignment.INSTANCE), saverScope), save(LineHeightStyle.Trim.m8688boximpl(lineHeightStyle.getTrim()), getSaver(LineHeightStyle.Trim.INSTANCE), saverScope), save(LineHeightStyle.Mode.m8678boximpl(lineHeightStyle.getMode()), getSaver(LineHeightStyle.Mode.INSTANCE), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LineHeightStyle LineHeightStyleSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<LineHeightStyle.Alignment, Object> saver = getSaver(LineHeightStyle.Alignment.INSTANCE);
        LineHeightStyle.Alignment alignmentRestore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(alignmentRestore);
        float topRatio = alignmentRestore.getTopRatio();
        Object obj3 = list.get(1);
        Saver<LineHeightStyle.Trim, Object> saver2 = getSaver(LineHeightStyle.Trim.INSTANCE);
        LineHeightStyle.Trim trimRestore = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? saver2.restore(obj3) : null;
        Intrinsics.checkNotNull(trimRestore);
        int value = trimRestore.getValue();
        Object obj4 = list.get(2);
        Saver<LineHeightStyle.Mode, Object> saver3 = getSaver(LineHeightStyle.Mode.INSTANCE);
        LineHeightStyle.Mode modeRestore = ((!Intrinsics.areEqual(obj4, (Object) false) || (saver3 instanceof NonNullValueClassSaver)) && obj4 != null) ? saver3.restore(obj4) : null;
        Intrinsics.checkNotNull(modeRestore);
        return new LineHeightStyle(topRatio, value, modeRestore.getValue(), null);
    }

    private static final Saver<LineHeightStyle.Alignment, Object> getSaver(LineHeightStyle.Alignment.Companion companion) {
        return LineHeightStyleAlignmentSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LineHeightStyleAlignmentSaver$lambda$0(SaverScope saverScope, LineHeightStyle.Alignment alignment) {
        return Float.valueOf(alignment.getTopRatio());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LineHeightStyle.Alignment LineHeightStyleAlignmentSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
        return LineHeightStyle.Alignment.m8667boximpl(LineHeightStyle.Alignment.m8668constructorimpl(((Float) obj).floatValue()));
    }

    private static final Saver<LineHeightStyle.Trim, Object> getSaver(LineHeightStyle.Trim.Companion companion) {
        return LineHeightStyleTrimSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LineHeightStyleTrimSaver$lambda$0(SaverScope saverScope, LineHeightStyle.Trim trim) {
        return Integer.valueOf(trim.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LineHeightStyle.Trim LineHeightStyleTrimSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return LineHeightStyle.Trim.m8688boximpl(LineHeightStyle.Trim.m8689constructorimpl(((Integer) obj).intValue()));
    }

    private static final Saver<LineHeightStyle.Mode, Object> getSaver(LineHeightStyle.Mode.Companion companion) {
        return LineHeightStyleModeSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LineHeightStyleModeSaver$lambda$0(SaverScope saverScope, LineHeightStyle.Mode mode) {
        return Integer.valueOf(mode.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LineHeightStyle.Mode LineHeightStyleModeSaver$lambda$1(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return LineHeightStyle.Mode.m8678boximpl(LineHeightStyle.Mode.m8679constructorimpl(((Integer) obj).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AnnotationRangeListSaver$lambda$0(SaverScope saverScope, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(save((AnnotatedString.Range) list.get(i), AnnotationRangeSaver, saverScope));
        }
        return arrayList;
    }
}
