package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.internal.ChildParentSemanticsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: Surface.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aj\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u009c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u001f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001b\u0010 \u001a5\u0010!\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020#H\u0003¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010&\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\nH\u0003¢\u0006\u0004\b(\u0010)\"\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Surface", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", Constants.KEY_BORDER, "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "onClick", StreamManagement.Enabled.ELEMENT, "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surface", "backgroundColor", "", "surface-XO-JAsU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SurfaceKt {
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurfaceKt.LocalAbsoluteTonalElevation$lambda$3();
        }
    }, 1, null);

    /* JADX INFO: renamed from: Surface-T9BRK9s, reason: not valid java name */
    public static final void m3531SurfaceT9BRK9s(Modifier modifier, Shape shape, long j, long j2, float f2, float f3, BorderStroke borderStroke, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1093433818, "C(Surface)N(modifier,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)98@5172L11,99@5219L22,105@5437L7,109@5611L884,106@5466L1029:Surface.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if ((i2 & 4) != 0) {
            j = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface();
        }
        if ((i2 & 8) != 0) {
            j2 = ColorSchemeKt.m2664contentColorForek8zF_U(j, composer, (i >> 6) & 14);
        }
        if ((i2 & 16) != 0) {
            f2 = Dp.m8830constructorimpl(0);
        }
        if ((i2 & 32) != 0) {
            f3 = Dp.m8830constructorimpl(0);
        }
        if ((i2 & 64) != 0) {
            borderStroke = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1093433818, i, -1, "androidx.compose.material3.Surface (Surface.kt:104)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fM8830constructorimpl = Dp.m8830constructorimpl(((Dp) objConsume).m8844unboximpl() + f2);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(j2)), providableCompositionLocal.provides(Dp.m8828boximpl(fM8830constructorimpl))}, ComposableLambdaKt.rememberComposableLambda(421772006, true, new SurfaceKt$Surface$1(modifier, shape, j, fM8830constructorimpl, borderStroke, f3, function2), composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: Surface-o_FOJdg, reason: not valid java name */
    public static final void m3534Surfaceo_FOJdg(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, float f2, float f3, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2, int i3) {
        char c2;
        ComposerKt.sourceInformationMarkerStart(composer, -1472753265, "C(Surface)N(onClick,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,interactionSource,content)200@10898L11,201@10945L22,210@11341L7,214@11515L870,211@11370L1015:Surface.kt#uh7d8r");
        final Modifier modifier2 = (i3 & 2) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z2 = (i3 & 4) != 0 ? true : z;
        final Shape rectangleShape = (i3 & 8) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long surface = (i3 & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface() : j;
        long jM2664contentColorForek8zF_U = (i3 & 32) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(surface, composer, (i >> 12) & 14) : j2;
        float fM8830constructorimpl = (i3 & 64) != 0 ? Dp.m8830constructorimpl(0) : f2;
        final float fM8830constructorimpl2 = (i3 & 128) != 0 ? Dp.m8830constructorimpl(0) : f3;
        BorderStroke borderStroke2 = (i3 & 256) != 0 ? null : borderStroke;
        MutableInteractionSource mutableInteractionSource2 = (i3 & 512) == 0 ? mutableInteractionSource : null;
        if (ComposerKt.isTraceInProgress()) {
            c2 = 1;
            ComposerKt.traceEventStart(-1472753265, i, i2, "androidx.compose.material3.Surface (Surface.kt:207)");
        } else {
            c2 = 1;
        }
        if (mutableInteractionSource2 == null) {
            composer.startReplaceGroup(-1701037204);
            ComposerKt.sourceInformation(composer, "209@11245L39");
            ComposerKt.sourceInformationMarkerStart(composer, 2023337814, "CC(remember):Surface.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            composer.startReplaceGroup(2023337163);
        }
        composer.endReplaceGroup();
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final float fM8830constructorimpl3 = Dp.m8830constructorimpl(((Dp) objConsume).m8844unboximpl() + fM8830constructorimpl);
        ProvidedValue[] providedValueArr = new ProvidedValue[2];
        providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(jM2664contentColorForek8zF_U));
        providedValueArr[c2] = providableCompositionLocal.provides(Dp.m8828boximpl(fM8830constructorimpl3));
        final BorderStroke borderStroke3 = borderStroke2;
        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.rememberComposableLambda(849208527, c2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                ComposerKt.sourceInformation(composer2, "C222@11772L69,224@11944L7,215@11525L854:Surface.kt#uh7d8r");
                if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(849208527, i4, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:215)");
                }
                Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                Shape shape2 = rectangleShape;
                long jM3538surfaceColorAtElevationCLU3JFs = SurfaceKt.m3538surfaceColorAtElevationCLU3JFs(surface, fM8830constructorimpl3, composer2, 0);
                BorderStroke borderStroke4 = borderStroke3;
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierChildSemantics$default = ChildParentSemanticsKt.childSemantics$default(ClickableKt.m355clickableO2vRcR0$default(SurfaceKt.m3537surfaceXOJAsU(modifierMinimumInteractiveComponentSize, shape2, jM3538surfaceColorAtElevationCLU3JFs, borderStroke4, ((Density) objConsume2).mo488toPx0680j_4(fM8830constructorimpl2)), mutableInteractionSource3, RippleKt.m3315rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z2, null, null, function0, 24, null), null, 1, null);
                Function2<Composer, Integer, Unit> function22 = function2;
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierChildSemantics$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer2);
                Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -361808591, "C235@12360L9:Surface.kt#uh7d8r");
                function22.invoke(composer2, 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m3532Surfaced85dljk(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, Shape shape, long j, long j2, float f2, float f3, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2, int i3) {
        char c2;
        ComposerKt.sourceInformationMarkerStart(composer, 1416521139, "C(Surface)N(selected,onClick,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,interactionSource,content)306@16724L11,307@16771L22,316@17167L7,320@17341L916,317@17196L1061:Surface.kt#uh7d8r");
        final Modifier modifier2 = (i3 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z3 = (i3 & 8) != 0 ? true : z2;
        final Shape rectangleShape = (i3 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long surface = (i3 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface() : j;
        long jM2664contentColorForek8zF_U = (i3 & 64) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(surface, composer, (i >> 15) & 14) : j2;
        float fM8830constructorimpl = (i3 & 128) != 0 ? Dp.m8830constructorimpl(0) : f2;
        final float fM8830constructorimpl2 = (i3 & 256) != 0 ? Dp.m8830constructorimpl(0) : f3;
        BorderStroke borderStroke2 = (i3 & 512) != 0 ? null : borderStroke;
        MutableInteractionSource mutableInteractionSource2 = (i3 & 1024) == 0 ? mutableInteractionSource : null;
        if (ComposerKt.isTraceInProgress()) {
            c2 = 1;
            ComposerKt.traceEventStart(1416521139, i, i2, "androidx.compose.material3.Surface (Surface.kt:313)");
        } else {
            c2 = 1;
        }
        if (mutableInteractionSource2 == null) {
            composer.startReplaceGroup(1528143336);
            ComposerKt.sourceInformation(composer, "315@17071L39");
            ComposerKt.sourceInformationMarkerStart(composer, -227799718, "CC(remember):Surface.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            composer.startReplaceGroup(-227800369);
        }
        composer.endReplaceGroup();
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final float fM8830constructorimpl3 = Dp.m8830constructorimpl(((Dp) objConsume).m8844unboximpl() + fM8830constructorimpl);
        ProvidedValue[] providedValueArr = new ProvidedValue[2];
        providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(jM2664contentColorForek8zF_U));
        providedValueArr[c2] = providableCompositionLocal.provides(Dp.m8828boximpl(fM8830constructorimpl3));
        final BorderStroke borderStroke3 = borderStroke2;
        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.rememberComposableLambda(1508735219, c2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                ComposerKt.sourceInformation(composer2, "C328@17598L69,330@17770L7,321@17351L900:Surface.kt#uh7d8r");
                if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1508735219, i4, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:321)");
                }
                Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                Shape shape2 = rectangleShape;
                long jM3538surfaceColorAtElevationCLU3JFs = SurfaceKt.m3538surfaceColorAtElevationCLU3JFs(surface, fM8830constructorimpl3, composer2, 0);
                BorderStroke borderStroke4 = borderStroke3;
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierChildSemantics$default = ChildParentSemanticsKt.childSemantics$default(SelectableKt.m1493selectableO2vRcR0$default(SurfaceKt.m3537surfaceXOJAsU(modifierMinimumInteractiveComponentSize, shape2, jM3538surfaceColorAtElevationCLU3JFs, borderStroke4, ((Density) objConsume2).mo488toPx0680j_4(fM8830constructorimpl2)), z, mutableInteractionSource3, RippleKt.m3315rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z3, null, function0, 16, null), null, 1, null);
                Function2<Composer, Integer, Unit> function22 = function2;
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierChildSemantics$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer2);
                Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 2010194061, "C342@18232L9:Surface.kt#uh7d8r");
                function22.invoke(composer2, 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m3533Surfaced85dljk(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, long j, long j2, float f2, float f3, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2, int i3) {
        char c2;
        ComposerKt.sourceInformationMarkerStart(composer, -1931279214, "C(Surface)N(checked,onCheckedChange,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,interactionSource,content)413@22663L11,414@22710L22,423@23106L7,427@23280L926,424@23135L1071:Surface.kt#uh7d8r");
        final Modifier modifier2 = (i3 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z3 = (i3 & 8) != 0 ? true : z2;
        final Shape rectangleShape = (i3 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long surface = (i3 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface() : j;
        long jM2664contentColorForek8zF_U = (i3 & 64) != 0 ? ColorSchemeKt.m2664contentColorForek8zF_U(surface, composer, (i >> 15) & 14) : j2;
        float fM8830constructorimpl = (i3 & 128) != 0 ? Dp.m8830constructorimpl(0) : f2;
        final float fM8830constructorimpl2 = (i3 & 256) != 0 ? Dp.m8830constructorimpl(0) : f3;
        BorderStroke borderStroke2 = (i3 & 512) != 0 ? null : borderStroke;
        MutableInteractionSource mutableInteractionSource2 = (i3 & 1024) == 0 ? mutableInteractionSource : null;
        if (ComposerKt.isTraceInProgress()) {
            c2 = 1;
            ComposerKt.traceEventStart(-1931279214, i, i2, "androidx.compose.material3.Surface (Surface.kt:420)");
        } else {
            c2 = 1;
        }
        if (mutableInteractionSource2 == null) {
            composer.startReplaceGroup(643421417);
            ComposerKt.sourceInformation(composer, "422@23010L39");
            ComposerKt.sourceInformationMarkerStart(composer, -533433799, "CC(remember):Surface.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            composer.startReplaceGroup(-533434450);
        }
        composer.endReplaceGroup();
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final float fM8830constructorimpl3 = Dp.m8830constructorimpl(((Dp) objConsume).m8844unboximpl() + fM8830constructorimpl);
        ProvidedValue[] providedValueArr = new ProvidedValue[2];
        providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m5958boximpl(jM2664contentColorForek8zF_U));
        providedValueArr[c2] = providableCompositionLocal.provides(Dp.m8828boximpl(fM8830constructorimpl3));
        final BorderStroke borderStroke3 = borderStroke2;
        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.rememberComposableLambda(-1839065134, c2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i4) {
                ComposerKt.sourceInformation(composer2, "C435@23537L69,437@23709L7,428@23290L910:Surface.kt#uh7d8r");
                if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1839065134, i4, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:428)");
                }
                Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                Shape shape2 = rectangleShape;
                long jM3538surfaceColorAtElevationCLU3JFs = SurfaceKt.m3538surfaceColorAtElevationCLU3JFs(surface, fM8830constructorimpl3, composer2, 0);
                BorderStroke borderStroke4 = borderStroke3;
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composer2.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierChildSemantics$default = ChildParentSemanticsKt.childSemantics$default(ToggleableKt.m1500toggleableO2vRcR0$default(SurfaceKt.m3537surfaceXOJAsU(modifierMinimumInteractiveComponentSize, shape2, jM3538surfaceColorAtElevationCLU3JFs, borderStroke4, ((Density) objConsume2).mo488toPx0680j_4(fM8830constructorimpl2)), z, mutableInteractionSource3, RippleKt.m3315rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z3, null, function1, 16, null), null, 1, null);
                Function2<Composer, Integer, Unit> function22 = function2;
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierChildSemantics$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer2);
                Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1125458254, "C449@24181L9:Surface.kt#uh7d8r");
                function22.invoke(composer2, 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: surface-XO-JAsU, reason: not valid java name */
    public static final Modifier m3537surfaceXOJAsU(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f2) {
        Shape shape2;
        Modifier.Companion companionM6132graphicsLayerAp8cVGQ;
        if (f2 > 0.0f) {
            shape2 = shape;
            companionM6132graphicsLayerAp8cVGQ = GraphicsLayerModifierKt.m6132graphicsLayerAp8cVGQ(Modifier.INSTANCE, (124895 & 1) != 0 ? 1.0f : 0.0f, (124895 & 2) != 0 ? 1.0f : 0.0f, (124895 & 4) == 0 ? 0.0f : 1.0f, (124895 & 8) != 0 ? 0.0f : 0.0f, (124895 & 16) != 0 ? 0.0f : 0.0f, (124895 & 32) != 0 ? 0.0f : f2, (124895 & 64) != 0 ? 0.0f : 0.0f, (124895 & 128) != 0 ? 0.0f : 0.0f, (124895 & 256) == 0 ? 0.0f : 0.0f, (124895 & 512) != 0 ? 8.0f : 0.0f, (124895 & 1024) != 0 ? TransformOrigin.INSTANCE.m6383getCenterSzJe1aQ() : 0L, (124895 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : shape2, (124895 & 4096) != 0 ? false : false, (124895 & 8192) != 0 ? null : null, (124895 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (32768 & 124895) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (124895 & 65536) != 0 ? CompositingStrategy.INSTANCE.m6059getAutoNrFUSI() : 0);
        } else {
            shape2 = shape;
            companionM6132graphicsLayerAp8cVGQ = Modifier.INSTANCE;
        }
        return ClipKt.clip(BackgroundKt.m312backgroundbw27NRU(modifier.then(companionM6132graphicsLayerAp8cVGQ).then(borderStroke != null ? BorderKt.border(Modifier.INSTANCE, borderStroke, shape2) : Modifier.INSTANCE), j, shape2), shape2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    public static final long m3538surfaceColorAtElevationCLU3JFs(long j, float f2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2079918090, "C(surfaceColorAtElevation)N(color:c#ui.graphics.Color,elevation:c#ui.unit.Dp)478@24926L11,478@24938L37:Surface.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, i, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:478)");
        }
        long jM2662applyTonalElevationRFCenO8 = ColorSchemeKt.m2662applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j, f2, composer, (i << 3) & 1008);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM2662applyTonalElevationRFCenO8;
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp LocalAbsoluteTonalElevation$lambda$3() {
        return Dp.m8828boximpl(Dp.m8830constructorimpl(0));
    }
}
