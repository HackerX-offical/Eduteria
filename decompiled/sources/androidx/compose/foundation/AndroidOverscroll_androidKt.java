package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidOverscroll.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\tH\u0000\u001a\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0001¢\u0006\u0002\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0013\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0014\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015\"\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"rememberPlatformOverscrollFactory", "Landroidx/compose/foundation/OverscrollFactory;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "rememberPlatformOverscrollFactory-3J-VO9M", "(JLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/OverscrollFactory;", "defaultOverscrollFactory", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "rememberPlatformOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "destretchMultiplier", "", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "destretchMultiplier-GyEprt8", "(I)F", "FlingDestretchFactor", "DefaultGlowColor", "J", "DefaultGlowPaddingValues", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AndroidOverscroll_androidKt {
    private static final long DefaultGlowColor = ColorKt.Color(4284900966L);
    private static final PaddingValues DefaultGlowPaddingValues = PaddingKt.m1146PaddingValuesYgX7TsA$default(0.0f, 0.0f, 3, null);
    private static final float FlingDestretchFactor = 4.0f;

    /* JADX INFO: renamed from: rememberPlatformOverscrollFactory-3J-VO9M, reason: not valid java name */
    public static final OverscrollFactory m311rememberPlatformOverscrollFactory3JVO9M(long j, PaddingValues paddingValues, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2017030679, "C(rememberPlatformOverscrollFactory)N(glowColor:c#ui.graphics.Color,glowDrawPadding)85@3926L7,86@3965L7:AndroidOverscroll.android.kt#71ulvw");
        if ((i2 & 1) != 0) {
            j = DefaultGlowColor;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            paddingValues = DefaultGlowPaddingValues;
        }
        PaddingValues paddingValues2 = paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2017030679, i, -1, "androidx.compose.foundation.rememberPlatformOverscrollFactory (AndroidOverscroll.android.kt:84)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        AndroidEdgeEffectOverscrollFactory androidEdgeEffectOverscrollFactory = new AndroidEdgeEffectOverscrollFactory(context, (Density) objConsume2, j2, paddingValues2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidEdgeEffectOverscrollFactory;
    }

    public static final OverscrollFactory defaultOverscrollFactory(CompositionLocalAccessorScope compositionLocalAccessorScope) {
        Context context = (Context) compositionLocalAccessorScope.getCurrentValue(AndroidCompositionLocals_androidKt.getLocalContext());
        Density density = (Density) compositionLocalAccessorScope.getCurrentValue(CompositionLocalsKt.getLocalDensity());
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) compositionLocalAccessorScope.getCurrentValue(OverscrollConfiguration_androidKt.getLocalOverscrollConfiguration());
        if (overscrollConfiguration == null) {
            return null;
        }
        return new AndroidEdgeEffectOverscrollFactory(context, density, overscrollConfiguration.getGlowColor(), overscrollConfiguration.getDrawPadding(), null);
    }

    public static final OverscrollEffect rememberPlatformOverscrollEffect(Composer composer, int i) {
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect;
        ComposerKt.sourceInformationMarkerStart(composer, 1569526143, "C(rememberPlatformOverscrollEffect)107@4732L7,108@4771L7,109@4825L7:AndroidOverscroll.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1569526143, i, -1, "androidx.compose.foundation.rememberPlatformOverscrollEffect (AndroidOverscroll.android.kt:106)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume2;
        ProvidableCompositionLocal<OverscrollConfiguration> localOverscrollConfiguration = OverscrollConfiguration_androidKt.getLocalOverscrollConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume3 = composer.consume(localOverscrollConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) objConsume3;
        if (overscrollConfiguration == null) {
            composer.startReplaceGroup(-1555403601);
            composer.endReplaceGroup();
            androidEdgeEffectOverscrollEffect = null;
        } else {
            composer.startReplaceGroup(-1555370896);
            ComposerKt.sourceInformation(composer, "113@4900L227");
            ComposerKt.sourceInformationMarkerStart(composer, 781111042, "CC(remember):AndroidOverscroll.android.kt#9igjgp");
            boolean zChanged = composer.changed(context) | composer.changed(density) | composer.changed(overscrollConfiguration);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object androidEdgeEffectOverscrollEffect2 = new AndroidEdgeEffectOverscrollEffect(context, density, overscrollConfiguration.getGlowColor(), overscrollConfiguration.getDrawPadding(), null);
                composer.updateRememberedValue(androidEdgeEffectOverscrollEffect2);
                objRememberedValue = androidEdgeEffectOverscrollEffect2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
            androidEdgeEffectOverscrollEffect = (AndroidEdgeEffectOverscrollEffect) objRememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidEdgeEffectOverscrollEffect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: destretchMultiplier-GyEprt8, reason: not valid java name */
    public static final float m310destretchMultiplierGyEprt8(int i) {
        return NestedScrollSource.m7169equalsimpl0(i, NestedScrollSource.INSTANCE.m7180getSideEffectWNlRxjI()) ? 4.0f : 1.0f;
    }
}
