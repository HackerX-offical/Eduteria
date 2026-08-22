package androidx.compose.ui;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaQuery.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0004\u001b\u001c\u001d\u001eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078'X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005R\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/UiMediaScope;", "", "windowPosture", "Landroidx/compose/ui/UiMediaScope$Posture;", "getWindowPosture-m18o9QQ", "()Ljava/lang/String;", "windowWidth", "Landroidx/compose/ui/unit/Dp;", "getWindowWidth-D9Ej5fM", "()F", "windowHeight", "getWindowHeight-D9Ej5fM", "pointerPrecision", "Landroidx/compose/ui/UiMediaScope$PointerPrecision;", "getPointerPrecision-fpxItnM", "keyboardKind", "Landroidx/compose/ui/UiMediaScope$KeyboardKind;", "getKeyboardKind-J9_QTjY", "hasMicrophone", "", "getHasMicrophone", "()Z", "hasCamera", "getHasCamera", "viewingDistance", "Landroidx/compose/ui/UiMediaScope$ViewingDistance;", "getViewingDistance-tKro-MQ", "Posture", "PointerPrecision", "KeyboardKind", "ViewingDistance", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface UiMediaScope {
    boolean getHasCamera();

    boolean getHasMicrophone();

    /* JADX INFO: renamed from: getKeyboardKind-J9_QTjY, reason: not valid java name */
    String mo5414getKeyboardKindJ9_QTjY();

    /* JADX INFO: renamed from: getPointerPrecision-fpxItnM, reason: not valid java name */
    String mo5415getPointerPrecisionfpxItnM();

    /* JADX INFO: renamed from: getViewingDistance-tKro-MQ, reason: not valid java name */
    String mo5416getViewingDistancetKroMQ();

    /* JADX INFO: renamed from: getWindowHeight-D9Ej5fM, reason: not valid java name */
    float mo5417getWindowHeightD9Ej5fM();

    /* JADX INFO: renamed from: getWindowPosture-m18o9QQ, reason: not valid java name */
    String mo5418getWindowPosturem18o9QQ();

    /* JADX INFO: renamed from: getWindowWidth-D9Ej5fM, reason: not valid java name */
    float mo5419getWindowWidthD9Ej5fM();

    /* JADX INFO: compiled from: MediaQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/UiMediaScope$Posture;", "", "description", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "toString-impl", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class Posture {
        private final String description;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String Flat = m5442constructorimpl("Flat");
        private static final String Tabletop = m5442constructorimpl("Tabletop");
        private static final String Book = m5442constructorimpl("Book");

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Posture m5441boximpl(String str) {
            return new Posture(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static String m5442constructorimpl(String str) {
            return str;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m5443equalsimpl(String str, Object obj) {
            return (obj instanceof Posture) && Intrinsics.areEqual(str, ((Posture) obj).getDescription());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5444equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m5445hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m5446toStringimpl(String str) {
            return str;
        }

        public boolean equals(Object other) {
            return m5443equalsimpl(this.description, other);
        }

        public int hashCode() {
            return m5445hashCodeimpl(this.description);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ String getDescription() {
            return this.description;
        }

        private /* synthetic */ Posture(String str) {
            this.description = str;
        }

        public String toString() {
            return m5446toStringimpl(this.description);
        }

        /* JADX INFO: compiled from: MediaQuery.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/UiMediaScope$Posture$Companion;", "", "<init>", "()V", "Flat", "Landroidx/compose/ui/UiMediaScope$Posture;", "getFlat-m18o9QQ", "()Ljava/lang/String;", "Ljava/lang/String;", "Tabletop", "getTabletop-m18o9QQ", "Book", "getBook-m18o9QQ", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getFlat-m18o9QQ, reason: not valid java name */
            public final String m5449getFlatm18o9QQ() {
                return Posture.Flat;
            }

            /* JADX INFO: renamed from: getTabletop-m18o9QQ, reason: not valid java name */
            public final String m5450getTabletopm18o9QQ() {
                return Posture.Tabletop;
            }

            /* JADX INFO: renamed from: getBook-m18o9QQ, reason: not valid java name */
            public final String m5448getBookm18o9QQ() {
                return Posture.Book;
            }
        }
    }

    /* JADX INFO: compiled from: MediaQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/UiMediaScope$PointerPrecision;", "", "description", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "toString-impl", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class PointerPrecision {
        private final String description;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String Fine = m5431constructorimpl("Fine");
        private static final String Coarse = m5431constructorimpl("Coarse");
        private static final String Blunt = m5431constructorimpl("Blunt");
        private static final String None = m5431constructorimpl("None");

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ PointerPrecision m5430boximpl(String str) {
            return new PointerPrecision(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static String m5431constructorimpl(String str) {
            return str;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m5432equalsimpl(String str, Object obj) {
            return (obj instanceof PointerPrecision) && Intrinsics.areEqual(str, ((PointerPrecision) obj).getDescription());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5433equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m5434hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m5435toStringimpl(String str) {
            return str;
        }

        public boolean equals(Object other) {
            return m5432equalsimpl(this.description, other);
        }

        public int hashCode() {
            return m5434hashCodeimpl(this.description);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ String getDescription() {
            return this.description;
        }

        private /* synthetic */ PointerPrecision(String str) {
            this.description = str;
        }

        public String toString() {
            return m5435toStringimpl(this.description);
        }

        /* JADX INFO: compiled from: MediaQuery.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/UiMediaScope$PointerPrecision$Companion;", "", "<init>", "()V", "Fine", "Landroidx/compose/ui/UiMediaScope$PointerPrecision;", "getFine-fpxItnM", "()Ljava/lang/String;", "Ljava/lang/String;", "Coarse", "getCoarse-fpxItnM", "Blunt", "getBlunt-fpxItnM", "None", "getNone-fpxItnM", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getFine-fpxItnM, reason: not valid java name */
            public final String m5439getFinefpxItnM() {
                return PointerPrecision.Fine;
            }

            /* JADX INFO: renamed from: getCoarse-fpxItnM, reason: not valid java name */
            public final String m5438getCoarsefpxItnM() {
                return PointerPrecision.Coarse;
            }

            /* JADX INFO: renamed from: getBlunt-fpxItnM, reason: not valid java name */
            public final String m5437getBluntfpxItnM() {
                return PointerPrecision.Blunt;
            }

            /* JADX INFO: renamed from: getNone-fpxItnM, reason: not valid java name */
            public final String m5440getNonefpxItnM() {
                return PointerPrecision.None;
            }
        }
    }

    /* JADX INFO: compiled from: MediaQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/UiMediaScope$KeyboardKind;", "", "description", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "toString-impl", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class KeyboardKind {
        private final String description;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String Physical = m5421constructorimpl("Physical");
        private static final String Virtual = m5421constructorimpl("Virtual");
        private static final String None = m5421constructorimpl("None");

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ KeyboardKind m5420boximpl(String str) {
            return new KeyboardKind(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static String m5421constructorimpl(String str) {
            return str;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m5422equalsimpl(String str, Object obj) {
            return (obj instanceof KeyboardKind) && Intrinsics.areEqual(str, ((KeyboardKind) obj).getDescription());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5423equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m5424hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m5425toStringimpl(String str) {
            return str;
        }

        public boolean equals(Object other) {
            return m5422equalsimpl(this.description, other);
        }

        public int hashCode() {
            return m5424hashCodeimpl(this.description);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ String getDescription() {
            return this.description;
        }

        private /* synthetic */ KeyboardKind(String str) {
            this.description = str;
        }

        public String toString() {
            return m5425toStringimpl(this.description);
        }

        /* JADX INFO: compiled from: MediaQuery.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/UiMediaScope$KeyboardKind$Companion;", "", "<init>", "()V", "Physical", "Landroidx/compose/ui/UiMediaScope$KeyboardKind;", "getPhysical-J9_QTjY", "()Ljava/lang/String;", "Ljava/lang/String;", "Virtual", "getVirtual-J9_QTjY", "None", "getNone-J9_QTjY", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getPhysical-J9_QTjY, reason: not valid java name */
            public final String m5428getPhysicalJ9_QTjY() {
                return KeyboardKind.Physical;
            }

            /* JADX INFO: renamed from: getVirtual-J9_QTjY, reason: not valid java name */
            public final String m5429getVirtualJ9_QTjY() {
                return KeyboardKind.Virtual;
            }

            /* JADX INFO: renamed from: getNone-J9_QTjY, reason: not valid java name */
            public final String m5427getNoneJ9_QTjY() {
                return KeyboardKind.None;
            }
        }
    }

    /* JADX INFO: compiled from: MediaQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000b\u001a\u00020\fHÖ\u0081\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/UiMediaScope$ViewingDistance;", "", "description", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "toString-impl", "equals", "", "other", "hashCode", "", "Companion", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @JvmInline
    public static final class ViewingDistance {
        private final String description;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String Near = m5452constructorimpl("Near");
        private static final String Medium = m5452constructorimpl("Medium");
        private static final String Far = m5452constructorimpl("Far");

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ ViewingDistance m5451boximpl(String str) {
            return new ViewingDistance(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static String m5452constructorimpl(String str) {
            return str;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m5453equalsimpl(String str, Object obj) {
            return (obj instanceof ViewingDistance) && Intrinsics.areEqual(str, ((ViewingDistance) obj).getDescription());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m5454equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m5455hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m5456toStringimpl(String str) {
            return str;
        }

        public boolean equals(Object other) {
            return m5453equalsimpl(this.description, other);
        }

        public int hashCode() {
            return m5455hashCodeimpl(this.description);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ String getDescription() {
            return this.description;
        }

        private /* synthetic */ ViewingDistance(String str) {
            this.description = str;
        }

        public String toString() {
            return m5456toStringimpl(this.description);
        }

        /* JADX INFO: compiled from: MediaQuery.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/UiMediaScope$ViewingDistance$Companion;", "", "<init>", "()V", "Near", "Landroidx/compose/ui/UiMediaScope$ViewingDistance;", "getNear-tKro-MQ", "()Ljava/lang/String;", "Ljava/lang/String;", "Medium", "getMedium-tKro-MQ", "Far", "getFar-tKro-MQ", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getNear-tKro-MQ, reason: not valid java name */
            public final String m5460getNeartKroMQ() {
                return ViewingDistance.Near;
            }

            /* JADX INFO: renamed from: getMedium-tKro-MQ, reason: not valid java name */
            public final String m5459getMediumtKroMQ() {
                return ViewingDistance.Medium;
            }

            /* JADX INFO: renamed from: getFar-tKro-MQ, reason: not valid java name */
            public final String m5458getFartKroMQ() {
                return ViewingDistance.Far;
            }
        }
    }
}
