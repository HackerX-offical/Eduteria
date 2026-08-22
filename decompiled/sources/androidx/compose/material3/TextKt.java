package androidx.compose.material3;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.tokens.TypographyTokensKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b$\u0010%\u001aï\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b*\u0010+\u001aÏ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b,\u0010-\u001aã\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b.\u0010/\u001aÃ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b0\u00101\u001aÙ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b,\u00102\u001a(\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020#2\u0011\u00109\u001a\r\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010<\u001a\u0018\u0010=\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020&2\u0006\u0010>\u001a\u00020?H\u0002\u001a\r\u0010@\u001a\u00020?H\u0003¢\u0006\u0002\u0010A\"\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020#04¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006B"}, d2 = {"Text", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Landroidx/compose/ui/text/TextStyle;", "Text-Nvy7gAk", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/text/TextAutoSize;JLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "Text-Z58ophY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/text/TextAutoSize;JLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createTextWithLinkStyles", "linkStyles", "Landroidx/compose/ui/text/TextLinkStyles;", "rememberTextLinkStyles", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextLinkStyles;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TypographyTokensKt.getDefaultTextStyle();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideTextStyle$lambda$20(TextStyle textStyle, Function2 function2, int i, Composer composer, int i2) {
        ProvideTextStyle(textStyle, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text_IbK3jfQ$lambda$12(AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map map, Function1 function1, TextStyle textStyle, int i4, int i5, int i6, Composer composer, int i7) {
        m3702TextIbK3jfQ(annotatedString, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, i3, map, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text_Nvy7gAk$lambda$2(String str, Modifier modifier, long j, TextAutoSize textAutoSize, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Function1 function1, TextStyle textStyle, int i4, int i5, int i6, Composer composer, int i7) {
        m3703TextNvy7gAk(str, modifier, j, textAutoSize, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, i3, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text_Z58ophY$lambda$8(AnnotatedString annotatedString, Modifier modifier, long j, TextAutoSize textAutoSize, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map map, Function1 function1, TextStyle textStyle, int i4, int i5, int i6, Composer composer, int i7) {
        m3704TextZ58ophY(annotatedString, modifier, j, textAutoSize, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, i3, map, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text__4IGK_g$lambda$18(AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Map map, Function1 function1, TextStyle textStyle, int i3, int i4, int i5, Composer composer, int i6) {
        m3700Text4IGK_g(annotatedString, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, map, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text__4IGK_g$lambda$9(String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Function1 function1, TextStyle textStyle, int i4, int i5, int i6, Composer composer, int i7) {
        m3701Text4IGK_g(str, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, i3, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text_fLXpl1I$lambda$15(String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextDecoration textDecoration, TextAlign textAlign, long j4, int i, boolean z, int i2, Function1 function1, TextStyle textStyle, int i3, int i4, int i5, Composer composer, int i6) {
        m3705TextfLXpl1I(str, modifier, j, j2, fontStyle, fontWeight, fontFamily, j3, textDecoration, textAlign, j4, i, z, i2, function1, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:283:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0134  */
    /* JADX INFO: renamed from: Text-Nvy7gAk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3703TextNvy7gAk(final java.lang.String r47, androidx.compose.ui.Modifier r48, long r49, androidx.compose.foundation.text.TextAutoSize r51, long r52, androidx.compose.ui.text.font.FontStyle r54, androidx.compose.ui.text.font.FontWeight r55, androidx.compose.ui.text.font.FontFamily r56, long r57, androidx.compose.ui.text.style.TextDecoration r59, androidx.compose.ui.text.style.TextAlign r60, long r61, int r63, boolean r64, int r65, int r66, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r67, androidx.compose.ui.text.TextStyle r68, androidx.compose.runtime.Composer r69, final int r70, final int r71, final int r72) {
        /*
            Method dump skipped, instruction units count: 1215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m3703TextNvy7gAk(java.lang.String, androidx.compose.ui.Modifier, long, androidx.compose.foundation.text.TextAutoSize, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text_Z58ophY$lambda$4$lambda$3(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:310:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0134  */
    /* JADX INFO: renamed from: Text-Z58ophY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3704TextZ58ophY(final androidx.compose.ui.text.AnnotatedString r66, androidx.compose.ui.Modifier r67, long r68, androidx.compose.foundation.text.TextAutoSize r70, long r71, androidx.compose.ui.text.font.FontStyle r73, androidx.compose.ui.text.font.FontWeight r74, androidx.compose.ui.text.font.FontFamily r75, long r76, androidx.compose.ui.text.style.TextDecoration r78, androidx.compose.ui.text.style.TextAlign r79, long r80, int r82, boolean r83, int r84, int r85, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r86, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r87, androidx.compose.ui.text.TextStyle r88, androidx.compose.runtime.Composer r89, final int r90, final int r91, final int r92) {
        /*
            Method dump skipped, instruction units count: 1362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m3704TextZ58ophY(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, androidx.compose.foundation.text.TextAutoSize, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:259:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011c  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with autoSize instead")
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3701Text4IGK_g(final java.lang.String r45, androidx.compose.ui.Modifier r46, long r47, long r49, androidx.compose.ui.text.font.FontStyle r51, androidx.compose.ui.text.font.FontWeight r52, androidx.compose.ui.text.font.FontFamily r53, long r54, androidx.compose.ui.text.style.TextDecoration r56, androidx.compose.ui.text.style.TextAlign r57, long r58, int r60, boolean r61, int r62, int r63, kotlin.jvm.functions.Function1 r64, androidx.compose.ui.text.TextStyle r65, androidx.compose.runtime.Composer r66, final int r67, final int r68, final int r69) {
        /*
            Method dump skipped, instruction units count: 1034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m3701Text4IGK_g(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text_IbK3jfQ$lambda$11$lambda$10(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:274:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012f  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with autoSize instead")
    /* JADX INFO: renamed from: Text-IbK3jfQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3702TextIbK3jfQ(final androidx.compose.ui.text.AnnotatedString r39, androidx.compose.ui.Modifier r40, long r41, long r43, androidx.compose.ui.text.font.FontStyle r45, androidx.compose.ui.text.font.FontWeight r46, androidx.compose.ui.text.font.FontFamily r47, long r48, androidx.compose.ui.text.style.TextDecoration r50, androidx.compose.ui.text.style.TextAlign r51, long r52, int r54, boolean r55, int r56, int r57, java.util.Map r58, kotlin.jvm.functions.Function1 r59, androidx.compose.ui.text.TextStyle r60, androidx.compose.runtime.Composer r61, final int r62, final int r63, final int r64) {
        /*
            Method dump skipped, instruction units count: 1130
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m3702TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text_fLXpl1I$lambda$14$lambda$13(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:249:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011a  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* JADX INFO: renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3705TextfLXpl1I(final java.lang.String r43, androidx.compose.ui.Modifier r44, long r45, long r47, androidx.compose.ui.text.font.FontStyle r49, androidx.compose.ui.text.font.FontWeight r50, androidx.compose.ui.text.font.FontFamily r51, long r52, androidx.compose.ui.text.style.TextDecoration r54, androidx.compose.ui.text.style.TextAlign r55, long r56, int r58, boolean r59, int r60, kotlin.jvm.functions.Function1 r61, androidx.compose.ui.text.TextStyle r62, androidx.compose.runtime.Composer r63, final int r64, final int r65, final int r66) {
        /*
            Method dump skipped, instruction units count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m3705TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Text__4IGK_g$lambda$17$lambda$16(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:264:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011c  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* JADX INFO: renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3700Text4IGK_g(final androidx.compose.ui.text.AnnotatedString r45, androidx.compose.ui.Modifier r46, long r47, long r49, androidx.compose.ui.text.font.FontStyle r51, androidx.compose.ui.text.font.FontWeight r52, androidx.compose.ui.text.font.FontFamily r53, long r54, androidx.compose.ui.text.style.TextDecoration r56, androidx.compose.ui.text.style.TextAlign r57, long r58, int r60, boolean r61, int r62, java.util.Map r63, kotlin.jvm.functions.Function1 r64, androidx.compose.ui.text.TextStyle r65, androidx.compose.runtime.Composer r66, final int r67, final int r68, final int r69) {
        /*
            Method dump skipped, instruction units count: 1079
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextKt.m3700Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(15327438);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideTextStyle)N(value,content)460@19447L7,461@19472L80:Text.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(15327438, i2, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:459)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(((TextStyle) objConsume).merge(textStyle)), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TextKt.ProvideTextStyle$lambda$20(textStyle, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final AnnotatedString createTextWithLinkStyles(AnnotatedString annotatedString, final TextLinkStyles textLinkStyles) {
        return annotatedString.mapAnnotations(new Function1() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextKt.createTextWithLinkStyles$lambda$21(textLinkStyles, (AnnotatedString.Range) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString.Range createTextWithLinkStyles$lambda$21(TextLinkStyles textLinkStyles, AnnotatedString.Range range) {
        AnnotatedString.Annotation annotation = (AnnotatedString.Annotation) range.getItem();
        if (annotation instanceof LinkAnnotation.Url) {
            LinkAnnotation.Url url = (LinkAnnotation.Url) annotation;
            if (url.getStyles() == null) {
                Intrinsics.checkNotNull(range, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation.Url>");
                return AnnotatedString.Range.copy$default(range, LinkAnnotation.Url.copy$default(url, null, textLinkStyles, null, 5, null), 0, 0, null, 14, null);
            }
        }
        if (annotation instanceof LinkAnnotation.Clickable) {
            LinkAnnotation.Clickable clickable = (LinkAnnotation.Clickable) annotation;
            if (clickable.getStyles() == null) {
                Intrinsics.checkNotNull(range, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation.Clickable>");
                return AnnotatedString.Range.copy$default(range, LinkAnnotation.Clickable.copy$default(clickable, null, textLinkStyles, null, 5, null), 0, 0, null, 14, null);
            }
        }
        return range;
    }

    private static final TextLinkStyles rememberTextLinkStyles(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1113329403, "C(rememberTextLinkStyles)482@20251L11,483@20282L159:Text.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1113329403, i, -1, "androidx.compose.material3.rememberTextLinkStyles (Text.kt:481)");
        }
        long primary = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getPrimary();
        ComposerKt.sourceInformationMarkerStart(composer, 462704058, "CC(remember):Text.kt#9igjgp");
        boolean zChanged = composer.changed(primary);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            TextLinkStyles textLinkStyles = new TextLinkStyles(new SpanStyle(primary, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.INSTANCE.getUnderline(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61438, (DefaultConstructorMarker) null), null, null, null, 14, null);
            composer.updateRememberedValue(textLinkStyles);
            objRememberedValue = textLinkStyles;
        }
        TextLinkStyles textLinkStyles2 = (TextLinkStyles) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return textLinkStyles2;
    }
}
