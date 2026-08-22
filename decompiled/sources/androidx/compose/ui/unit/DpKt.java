package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: Dp.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u001a\"\u0010\n\u001a\u00020\u0002*\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0086\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u001a\u001a\u00020\u0002*\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001a\u001a\u00020\u0002*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u001c\u0010\u001a\u001a\u00020\u0002*\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001f\u001a \u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b#\u0010\u001d\u001a \u0010$\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b%\u0010\u001d\u001a$\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b)\u0010*\u001a\u001c\u0010+\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b,\u0010\u001d\u001a\u001c\u0010-\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b.\u0010\u001d\u001a'\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0018H\u0007¢\u0006\u0004\b6\u0010*\u001a \u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b;\u0010<\u001a\"\u0010\n\u001a\u000208*\u0002082\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002080\fH\u0086\b¢\u0006\u0004\bC\u0010D\u001a'\u00102\u001a\u0002082\u0006\u00103\u001a\u0002082\u0006\u00104\u001a\u0002082\u0006\u00105\u001a\u00020\u0018H\u0007¢\u0006\u0004\bE\u0010F\u001a\u001f\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u0002H\u0007¢\u0006\u0004\bK\u0010<\u001a\"\u0010\n\u001a\u00020H*\u00020H2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020H0\fH\u0086\b¢\u0006\u0004\bP\u0010D\u001a\u001c\u0010\u001a\u001a\u00020H*\u00020\u00102\u0006\u0010U\u001a\u00020HH\u0087\n¢\u0006\u0004\bV\u0010W\u001a\u001c\u0010\u001a\u001a\u00020H*\u00020\u00182\u0006\u0010U\u001a\u00020HH\u0087\n¢\u0006\u0004\bV\u0010X\u001a'\u00102\u001a\u00020H2\u0006\u00103\u001a\u00020H2\u0006\u00104\u001a\u00020H2\u0006\u00105\u001a\u00020\u0018H\u0007¢\u0006\u0004\bY\u0010F\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\u00108Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\u00158Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017\"\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\u00188Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0013\u0010\u0019\"\u001f\u0010/\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u001f\u0010\u0000\u001a\u00020\u0001*\u0002088Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u001f\u0010\u0007\u001a\u00020\u0001*\u0002088Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010>\u001a\u0004\bB\u0010@\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020H8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010>\u001a\u0004\bM\u0010@\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020H8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bN\u0010>\u001a\u0004\bO\u0010@\"\u001e\u0010Q\u001a\u000208*\u00020H8FX\u0087\u0004¢\u0006\f\u0012\u0004\bR\u0010>\u001a\u0004\bS\u0010T\"\u001f\u0010I\u001a\u00020\u0002*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u001f\u0010J\u001a\u00020\u0002*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b_\u0010\\\u001a\u0004\b`\u0010^\"\u001f\u0010U\u001a\u00020H*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010\\\u001a\u0004\bb\u0010c¨\u0006d"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/unit/Dp;", "isSpecified-0680j_4$annotations", "(F)V", "isSpecified-0680j_4", "(F)Z", "isUnspecified", "isUnspecified-0680j_4$annotations", "isUnspecified-0680j_4", "takeOrElse", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "takeOrElse-D5KLDUw", "(FLkotlin/jvm/functions/Function0;)F", "dp", "", "getDp$annotations", "(I)V", "getDp", "(I)F", "", "(D)V", "(D)F", "", "(F)F", "times", "other", "times-3ABfNKs", "(FF)F", "(DF)F", "(IF)F", "min", "a", "b", "min-YgX7TsA", Constants.PRIORITY_MAX, "max-YgX7TsA", "coerceIn", "minimumValue", "maximumValue", "coerceIn-2z7ARbQ", "(FFF)F", "coerceAtLeast", "coerceAtLeast-YgX7TsA", "coerceAtMost", "coerceAtMost-YgX7TsA", "isFinite", "isFinite-0680j_4$annotations", "isFinite-0680j_4", "lerp", "start", "stop", "fraction", "lerp-Md-fbLM", "DpOffset", "Landroidx/compose/ui/unit/DpOffset;", "x", "y", "DpOffset-YgX7TsA", "(FF)J", "isSpecified-jo-Fl9I$annotations", "(J)V", "isSpecified-jo-Fl9I", "(J)Z", "isUnspecified-jo-Fl9I$annotations", "isUnspecified-jo-Fl9I", "takeOrElse-gVKV90s", "(JLkotlin/jvm/functions/Function0;)J", "lerp-xhh869w", "(JJF)J", "DpSize", "Landroidx/compose/ui/unit/DpSize;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "DpSize-YgX7TsA", "isSpecified-EaSLcWc$annotations", "isSpecified-EaSLcWc", "isUnspecified-EaSLcWc$annotations", "isUnspecified-EaSLcWc", "takeOrElse-itqla9I", "center", "getCenter-EaSLcWc$annotations", "getCenter-EaSLcWc", "(J)J", "size", "times-6HolHcs", "(IJ)J", "(FJ)J", "lerp-IDex15A", "Landroidx/compose/ui/unit/DpRect;", "getWidth$annotations", "(Landroidx/compose/ui/unit/DpRect;)V", "getWidth", "(Landroidx/compose/ui/unit/DpRect;)F", "getHeight$annotations", "getHeight", "getSize$annotations", "getSize", "(Landroidx/compose/ui/unit/DpRect;)J", "ui-unit"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DpKt {
    /* JADX INFO: renamed from: getCenter-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m8857getCenterEaSLcWc$annotations(long j) {
    }

    public static /* synthetic */ void getDp$annotations(double d2) {
    }

    public static /* synthetic */ void getDp$annotations(float f2) {
    }

    public static /* synthetic */ void getDp$annotations(int i) {
    }

    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    /* JADX INFO: renamed from: isFinite-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m8859isFinite0680j_4$annotations(float f2) {
    }

    /* JADX INFO: renamed from: isSpecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m8861isSpecified0680j_4$annotations(float f2) {
    }

    /* JADX INFO: renamed from: isSpecified-EaSLcWc, reason: not valid java name */
    public static final boolean m8862isSpecifiedEaSLcWc(long j) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: isSpecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m8863isSpecifiedEaSLcWc$annotations(long j) {
    }

    /* JADX INFO: renamed from: isSpecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m8864isSpecifiedjoFl9I(long j) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: isSpecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m8865isSpecifiedjoFl9I$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m8867isUnspecified0680j_4$annotations(float f2) {
    }

    /* JADX INFO: renamed from: isUnspecified-EaSLcWc, reason: not valid java name */
    public static final boolean m8868isUnspecifiedEaSLcWc(long j) {
        return j == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: isUnspecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m8869isUnspecifiedEaSLcWc$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m8870isUnspecifiedjoFl9I(long j) {
        return j == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m8871isUnspecifiedjoFl9I$annotations(long j) {
    }

    /* JADX INFO: renamed from: isSpecified-0680j_4, reason: not valid java name */
    public static final boolean m8860isSpecified0680j_4(float f2) {
        return !Float.isNaN(f2);
    }

    /* JADX INFO: renamed from: isUnspecified-0680j_4, reason: not valid java name */
    public static final boolean m8866isUnspecified0680j_4(float f2) {
        return Float.isNaN(f2);
    }

    public static final float getDp(int i) {
        return Dp.m8830constructorimpl(i);
    }

    public static final float getDp(double d2) {
        return Dp.m8830constructorimpl((float) d2);
    }

    public static final float getDp(float f2) {
        return Dp.m8830constructorimpl(f2);
    }

    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m8881times3ABfNKs(float f2, float f3) {
        return Dp.m8830constructorimpl(f2 * f3);
    }

    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m8880times3ABfNKs(double d2, float f2) {
        return Dp.m8830constructorimpl(((float) d2) * f2);
    }

    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m8882times3ABfNKs(int i, float f2) {
        return Dp.m8830constructorimpl(i * f2);
    }

    /* JADX INFO: renamed from: min-YgX7TsA, reason: not valid java name */
    public static final float m8876minYgX7TsA(float f2, float f3) {
        return Dp.m8830constructorimpl(Math.min(f2, f3));
    }

    /* JADX INFO: renamed from: max-YgX7TsA, reason: not valid java name */
    public static final float m8875maxYgX7TsA(float f2, float f3) {
        return Dp.m8830constructorimpl(Math.max(f2, f3));
    }

    /* JADX INFO: renamed from: coerceIn-2z7ARbQ, reason: not valid java name */
    public static final float m8855coerceIn2z7ARbQ(float f2, float f3, float f4) {
        return Dp.m8830constructorimpl(RangesKt.coerceIn(f2, f3, f4));
    }

    /* JADX INFO: renamed from: coerceAtLeast-YgX7TsA, reason: not valid java name */
    public static final float m8853coerceAtLeastYgX7TsA(float f2, float f3) {
        return Dp.m8830constructorimpl(RangesKt.coerceAtLeast(f2, f3));
    }

    /* JADX INFO: renamed from: coerceAtMost-YgX7TsA, reason: not valid java name */
    public static final float m8854coerceAtMostYgX7TsA(float f2, float f3) {
        return Dp.m8830constructorimpl(RangesKt.coerceAtMost(f2, f3));
    }

    /* JADX INFO: renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m8873lerpMdfbLM(float f2, float f3, float f4) {
        return Dp.m8830constructorimpl(MathHelpersKt.lerp(f2, f3, f4));
    }

    /* JADX INFO: renamed from: takeOrElse-gVKV90s, reason: not valid java name */
    public static final long m8878takeOrElsegVKV90s(long j, Function0<DpOffset> function0) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? j : function0.invoke().m8899unboximpl();
    }

    /* JADX INFO: renamed from: lerp-xhh869w, reason: not valid java name */
    public static final long m8874lerpxhh869w(long j, long j2, float f2) {
        float fLerp = MathHelpersKt.lerp(DpOffset.m8891getXD9Ej5fM(j), DpOffset.m8891getXD9Ej5fM(j2), f2);
        float fLerp2 = MathHelpersKt.lerp(DpOffset.m8893getYD9Ej5fM(j), DpOffset.m8893getYD9Ej5fM(j2), f2);
        return DpOffset.m8886constructorimpl((((long) Float.floatToRawIntBits(fLerp)) << 32) | (((long) Float.floatToRawIntBits(fLerp2)) & 4294967295L));
    }

    /* JADX INFO: renamed from: takeOrElse-itqla9I, reason: not valid java name */
    public static final long m8879takeOrElseitqla9I(long j, Function0<DpSize> function0) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? j : function0.invoke().getPackedValue();
    }

    /* JADX INFO: renamed from: getCenter-EaSLcWc, reason: not valid java name */
    public static final long m8856getCenterEaSLcWc(long j) {
        float fM8830constructorimpl = Dp.m8830constructorimpl(DpSize.m8928getWidthD9Ej5fM(j) / 2.0f);
        return DpOffset.m8886constructorimpl((((long) Float.floatToRawIntBits(Dp.m8830constructorimpl(DpSize.m8926getHeightD9Ej5fM(j) / 2.0f))) & 4294967295L) | (Float.floatToRawIntBits(fM8830constructorimpl) << 32));
    }

    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m8884times6HolHcs(int i, long j) {
        return DpSize.m8934timesGh9hcWk(j, i);
    }

    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m8883times6HolHcs(float f2, long j) {
        return DpSize.m8933timesGh9hcWk(j, f2);
    }

    /* JADX INFO: renamed from: lerp-IDex15A, reason: not valid java name */
    public static final long m8872lerpIDex15A(long j, long j2, float f2) {
        float fM8873lerpMdfbLM = m8873lerpMdfbLM(DpSize.m8928getWidthD9Ej5fM(j), DpSize.m8928getWidthD9Ej5fM(j2), f2);
        float fM8873lerpMdfbLM2 = m8873lerpMdfbLM(DpSize.m8926getHeightD9Ej5fM(j), DpSize.m8926getHeightD9Ej5fM(j2), f2);
        return DpSize.m8919constructorimpl((((long) Float.floatToRawIntBits(fM8873lerpMdfbLM)) << 32) | (((long) Float.floatToRawIntBits(fM8873lerpMdfbLM2)) & 4294967295L));
    }

    public static final float getWidth(DpRect dpRect) {
        return Dp.m8830constructorimpl(dpRect.m8914getRightD9Ej5fM() - dpRect.m8913getLeftD9Ej5fM());
    }

    public static final float getHeight(DpRect dpRect) {
        return Dp.m8830constructorimpl(dpRect.m8912getBottomD9Ej5fM() - dpRect.m8915getTopD9Ej5fM());
    }

    /* JADX INFO: renamed from: takeOrElse-D5KLDUw, reason: not valid java name */
    public static final float m8877takeOrElseD5KLDUw(float f2, Function0<Dp> function0) {
        return !Float.isNaN(f2) ? f2 : function0.invoke().m8844unboximpl();
    }

    /* JADX INFO: renamed from: isFinite-0680j_4, reason: not valid java name */
    public static final boolean m8858isFinite0680j_4(float f2) {
        return (Float.floatToRawIntBits(f2) & Integer.MAX_VALUE) < 2139095040;
    }

    /* JADX INFO: renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m8851DpOffsetYgX7TsA(float f2, float f3) {
        return DpOffset.m8886constructorimpl((((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
    }

    /* JADX INFO: renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m8852DpSizeYgX7TsA(float f2, float f3) {
        return DpSize.m8919constructorimpl((((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
    }

    public static final long getSize(DpRect dpRect) {
        return m8852DpSizeYgX7TsA(Dp.m8830constructorimpl(dpRect.m8914getRightD9Ej5fM() - dpRect.m8913getLeftD9Ej5fM()), Dp.m8830constructorimpl(dpRect.m8912getBottomD9Ej5fM() - dpRect.m8915getTopD9Ej5fM()));
    }
}
