package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.collection.ScatterMap;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontMatcher;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidFontListTypeface.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "This is not supported after downloadable fonts.")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000  2\u00020\u0001:\u0001 B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\b\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface;", "Landroidx/compose/ui/text/platform/AndroidTypeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontListFontFamily;", "context", "Landroid/content/Context;", "necessaryStyles", "", "Lkotlin/Pair;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "<init>", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroid/content/Context;Ljava/util/List;Landroidx/compose/ui/text/font/FontMatcher;)V", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "fontMatcher$1", "loadedTypefaces", "Landroidx/collection/ScatterMap;", "Landroidx/compose/ui/text/font/Font;", "Landroid/graphics/Typeface;", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getNativeTypeface", "fontWeight", "fontStyle", "synthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNativeTypeface-PYhJU0U", "(Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "Companion", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidFontListTypeface implements AndroidTypeface {
    private final FontFamily fontFamily;

    /* JADX INFO: renamed from: fontMatcher$1, reason: from kotlin metadata */
    private final FontMatcher fontMatcher;
    private final ScatterMap<Font, Typeface> loadedTypefaces;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final FontMatcher fontMatcher = new FontMatcher();

    /* JADX WARN: Removed duplicated region for block: B:22:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AndroidFontListTypeface(androidx.compose.ui.text.font.FontListFontFamily r9, android.content.Context r10, java.util.List<kotlin.Pair<androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle>> r11, androidx.compose.ui.text.font.FontMatcher r12) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidFontListTypeface.<init>(androidx.compose.ui.text.font.FontListFontFamily, android.content.Context, java.util.List, androidx.compose.ui.text.font.FontMatcher):void");
    }

    public /* synthetic */ AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context, List list, FontMatcher fontMatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontListFontFamily, context, (i & 4) != 0 ? null : list, (i & 8) != 0 ? fontMatcher : fontMatcher2);
    }

    public final FontMatcher getFontMatcher() {
        return this.fontMatcher;
    }

    /* JADX INFO: compiled from: AndroidFontListTypeface.android.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface$Companion;", "", "<init>", "()V", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FontMatcher getFontMatcher() {
            return AndroidFontListTypeface.fontMatcher;
        }
    }

    @Override // androidx.compose.ui.text.font.Typeface
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    /* JADX INFO: renamed from: getNativeTypeface-PYhJU0U */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface mo8531getNativeTypefacePYhJU0U(androidx.compose.ui.text.font.FontWeight r19, int r20, int r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            androidx.collection.ScatterMap<androidx.compose.ui.text.font.Font, android.graphics.Typeface> r4 = r0.loadedTypefaces
            java.lang.Object[] r5 = r4.keys
            long[] r4 = r4.metadata
            int r6 = r4.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L55
            r7 = 0
            r8 = r7
        L18:
            r9 = r4[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L50
            int r11 = r8 - r6
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r7
        L32:
            if (r13 >= r11) goto L4e
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L4a
            int r14 = r8 << 3
            int r14 = r14 + r13
            r14 = r5[r14]
            androidx.compose.ui.text.font.Font r14 = (androidx.compose.ui.text.font.Font) r14
            r15 = r3
            java.util.Collection r15 = (java.util.Collection) r15
            r15.add(r14)
        L4a:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L32
        L4e:
            if (r11 != r12) goto L55
        L50:
            if (r8 == r6) goto L55
            int r8 = r8 + 1
            goto L18
        L55:
            androidx.compose.ui.text.font.FontMatcher r4 = r0.fontMatcher
            java.util.List r3 = (java.util.List) r3
            java.util.List r3 = r4.m8383matchFontRetOiIg(r3, r1, r2)
            java.lang.Object r3 = kotlin.collections.CollectionsKt.firstOrNull(r3)
            androidx.compose.ui.text.font.Font r3 = (androidx.compose.ui.text.font.Font) r3
            if (r3 == 0) goto L88
            androidx.collection.ScatterMap<androidx.compose.ui.text.font.Font, android.graphics.Typeface> r4 = r0.loadedTypefaces
            java.lang.Object r4 = r4.get(r3)
            android.graphics.Typeface r4 = (android.graphics.Typeface) r4
            if (r4 == 0) goto L7d
            r5 = r21
            java.lang.Object r1 = androidx.compose.ui.text.font.FontSynthesis_androidKt.m8409synthesizeTypefaceFxwP2eA(r5, r4, r3, r1, r2)
            java.lang.String r2 = "null cannot be cast to non-null type android.graphics.Typeface"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            return r1
        L7d:
            java.lang.String r1 = "Could not load typeface"
            androidx.compose.ui.text.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(r1)
            kotlin.KotlinNothingValueException r1 = new kotlin.KotlinNothingValueException
            r1.<init>()
            throw r1
        L88:
            java.lang.String r1 = "Could not load font"
            androidx.compose.ui.text.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(r1)
            kotlin.KotlinNothingValueException r1 = new kotlin.KotlinNothingValueException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidFontListTypeface.mo8531getNativeTypefacePYhJU0U(androidx.compose.ui.text.font.FontWeight, int, int):android.graphics.Typeface");
    }
}
