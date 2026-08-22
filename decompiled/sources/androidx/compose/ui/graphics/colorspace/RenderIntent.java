package androidx.compose.ui.graphics.colorspace;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RenderIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "", "value", "", "constructor-impl", "(I)I", InAppPurchaseConstants.METHOD_TO_STRING, "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class RenderIntent {
    private final int value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Perceptual = m6421constructorimpl(0);
    private static final int Relative = m6421constructorimpl(1);
    private static final int Saturation = m6421constructorimpl(2);
    private static final int Absolute = m6421constructorimpl(3);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ RenderIntent m6420boximpl(int i) {
        return new RenderIntent(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m6421constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m6422equalsimpl(int i, Object obj) {
        return (obj instanceof RenderIntent) && i == ((RenderIntent) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6423equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m6424hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m6422equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m6424hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: RenderIntent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent$Companion;", "", "<init>", "()V", "Perceptual", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "getPerceptual-uksYyKA", "()I", "I", "Relative", "getRelative-uksYyKA", ExifInterface.TAG_SATURATION, "getSaturation-uksYyKA", "Absolute", "getAbsolute-uksYyKA", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getPerceptual-uksYyKA, reason: not valid java name */
        public final int m6428getPerceptualuksYyKA() {
            return RenderIntent.Perceptual;
        }

        /* JADX INFO: renamed from: getRelative-uksYyKA, reason: not valid java name */
        public final int m6429getRelativeuksYyKA() {
            return RenderIntent.Relative;
        }

        /* JADX INFO: renamed from: getSaturation-uksYyKA, reason: not valid java name */
        public final int m6430getSaturationuksYyKA() {
            return RenderIntent.Saturation;
        }

        /* JADX INFO: renamed from: getAbsolute-uksYyKA, reason: not valid java name */
        public final int m6427getAbsoluteuksYyKA() {
            return RenderIntent.Absolute;
        }
    }

    private /* synthetic */ RenderIntent(int i) {
        this.value = i;
    }

    public String toString() {
        return m6425toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m6425toStringimpl(int i) {
        return m6423equalsimpl0(i, Perceptual) ? "Perceptual" : m6423equalsimpl0(i, Relative) ? "Relative" : m6423equalsimpl0(i, Saturation) ? ExifInterface.TAG_SATURATION : m6423equalsimpl0(i, Absolute) ? "Absolute" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
