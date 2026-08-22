package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContentDrawScope.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ContentDrawScope extends DrawScope {
    void drawContent();

    /* JADX INFO: compiled from: ContentDrawScope.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m6495drawImageAZ2fEMs(ContentDrawScope contentDrawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
            ContentDrawScope.super.mo6451drawImageAZ2fEMs(imageBitmap, j, j2, j3, j4, f2, drawStyle, colorFilter, i, i2);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m6496getCenterF1C5BW0(ContentDrawScope contentDrawScope) {
            return ContentDrawScope.super.mo6548getCenterF1C5BW0();
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m6497getSizeNHjbRc(ContentDrawScope contentDrawScope) {
            return ContentDrawScope.super.mo6549getSizeNHjbRc();
        }

        @Deprecated
        /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
        public static void m6498recordJVtK1S4(ContentDrawScope contentDrawScope, GraphicsLayer graphicsLayer, long j, Function1<? super DrawScope, Unit> function1) {
            ContentDrawScope.super.mo6550recordJVtK1S4(graphicsLayer, j, function1);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m6499roundToPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo481roundToPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m6500roundToPx0680j_4(ContentDrawScope contentDrawScope, float f2) {
            return ContentDrawScope.super.mo482roundToPx0680j_4(f2);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m6501toDpGaN1DYA(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo483toDpGaN1DYA(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6502toDpu2uoSUM(ContentDrawScope contentDrawScope, float f2) {
            return ContentDrawScope.super.mo484toDpu2uoSUM(f2);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6503toDpu2uoSUM(ContentDrawScope contentDrawScope, int i) {
            return ContentDrawScope.super.mo485toDpu2uoSUM(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6504toDpSizekrfVVM(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo486toDpSizekrfVVM(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m6505toPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo487toPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m6506toPx0680j_4(ContentDrawScope contentDrawScope, float f2) {
            return ContentDrawScope.super.mo488toPx0680j_4(f2);
        }

        @Deprecated
        public static Rect toRect(ContentDrawScope contentDrawScope, DpRect dpRect) {
            return ContentDrawScope.super.toRect(dpRect);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m6507toSizeXkaWNTQ(ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo489toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m6508toSp0xMU5do(ContentDrawScope contentDrawScope, float f2) {
            return ContentDrawScope.super.mo490toSp0xMU5do(f2);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6509toSpkPz2Gy4(ContentDrawScope contentDrawScope, float f2) {
            return ContentDrawScope.super.mo491toSpkPz2Gy4(f2);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6510toSpkPz2Gy4(ContentDrawScope contentDrawScope, int i) {
            return ContentDrawScope.super.mo492toSpkPz2Gy4(i);
        }
    }
}
