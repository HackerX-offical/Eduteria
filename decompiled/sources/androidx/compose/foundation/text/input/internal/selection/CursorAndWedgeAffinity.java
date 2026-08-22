package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;

/* JADX INFO: compiled from: TextPreparedSelection.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/CursorAndWedgeAffinity;", "", "value", "", "constructor-impl", "(J)J", "cursor", "", "(I)J", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "(ILandroidx/compose/foundation/text/input/internal/WedgeAffinity;)J", "getCursor-impl", "(J)I", "getWedgeAffinity-impl", "(J)Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "component1", "component1-impl", "component2", "component2-impl", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class CursorAndWedgeAffinity {
    private final long value;

    /* JADX INFO: compiled from: TextPreparedSelection.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WedgeAffinity.values().length];
            try {
                iArr[WedgeAffinity.Start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WedgeAffinity.End.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CursorAndWedgeAffinity m2139boximpl(long j) {
        return new CursorAndWedgeAffinity(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2144constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2145equalsimpl(long j, Object obj) {
        return (obj instanceof CursorAndWedgeAffinity) && j == ((CursorAndWedgeAffinity) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2146equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getCursor-impl, reason: not valid java name */
    public static final int m2147getCursorimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2149hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2150toStringimpl(long j) {
        return "CursorAndWedgeAffinity(value=" + j + ')';
    }

    public boolean equals(Object other) {
        return m2145equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m2149hashCodeimpl(this.value);
    }

    public String toString() {
        return m2150toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    private /* synthetic */ CursorAndWedgeAffinity(long j) {
        this.value = j;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2142constructorimpl(int i) {
        return m2144constructorimpl((((long) i) << 32) | (((long) (-1)) & 4294967295L));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m2143constructorimpl(int i, WedgeAffinity wedgeAffinity) {
        int i2 = -1;
        int i3 = wedgeAffinity == null ? -1 : WhenMappings.$EnumSwitchMapping$0[wedgeAffinity.ordinal()];
        if (i3 != -1) {
            i2 = 1;
            if (i3 == 1) {
                i2 = 0;
            } else if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return m2144constructorimpl((((long) i) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: getWedgeAffinity-impl, reason: not valid java name */
    public static final WedgeAffinity m2148getWedgeAffinityimpl(long j) {
        int i = (int) (j & 4294967295L);
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return WedgeAffinity.Start;
        }
        return WedgeAffinity.End;
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m2140component1impl(long j) {
        return m2147getCursorimpl(j);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final WedgeAffinity m2141component2impl(long j) {
        return m2148getWedgeAffinityimpl(j);
    }
}
