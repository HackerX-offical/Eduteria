package androidx.compose.foundation;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AndroidExternalSurface.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001aZ\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001aR\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "AndroidExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "AndroidEmbeddedExternalSurface", "transform", "Landroidx/compose/ui/graphics/Matrix;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AndroidExternalSurface_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$3(Modifier modifier, boolean z, long j, float[] fArr, Function1 function1, int i, int i2, Composer composer, int i3) {
        m307AndroidEmbeddedExternalSurfacesv6N_fY(modifier, z, j, fArr, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidExternalSurface_58FFMhA$lambda$3(Modifier modifier, boolean z, long j, int i, boolean z2, Function1 function1, int i2, int i3, Composer composer, int i4) {
        m308AndroidExternalSurface58FFMhA(modifier, z, j, i, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private static final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -873615933, "C(rememberAndroidExternalSurfaceState)188@7180L24,189@7216L47:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-873615933, i, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:187)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -2026284846, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new AndroidExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        AndroidExternalSurfaceState androidExternalSurfaceState = (AndroidExternalSurfaceState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidExternalSurfaceState;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX INFO: renamed from: AndroidExternalSurface-58FFMhA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m308AndroidExternalSurface58FFMhA(androidx.compose.ui.Modifier r20, boolean r21, long r22, int r24, boolean r25, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.AndroidExternalSurfaceScope, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidExternalSurface_androidKt.m308AndroidExternalSurface58FFMhA(androidx.compose.ui.Modifier, boolean, long, int, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SurfaceView AndroidExternalSurface_58FFMhA$lambda$0$0(Function1 function1, AndroidExternalSurfaceState androidExternalSurfaceState, Context context) {
        SurfaceView surfaceView = new SurfaceView(context);
        function1.invoke(androidExternalSurfaceState);
        surfaceView.getHolder().addCallback(androidExternalSurfaceState);
        return surfaceView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidExternalSurface_58FFMhA$lambda$1$0(SurfaceView surfaceView) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidExternalSurface_58FFMhA$lambda$2$0(long j, boolean z, int i, boolean z2, SurfaceView surfaceView) {
        if (!IntSize.m8999equalsimpl0(j, IntSize.INSTANCE.m9006getZeroYbymL2g())) {
            surfaceView.getHolder().setFixedSize((int) (j >> 32), (int) (j & 4294967295L));
        } else {
            surfaceView.getHolder().setSizeFromLayout();
        }
        surfaceView.getHolder().setFormat(z ? -1 : -3);
        if (AndroidExternalSurfaceZOrder.m297equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m301getBehindB_4ceCc())) {
            surfaceView.setZOrderOnTop(false);
        } else if (AndroidExternalSurfaceZOrder.m297equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m302getMediaOverlayB_4ceCc())) {
            surfaceView.setZOrderMediaOverlay(true);
        } else if (AndroidExternalSurfaceZOrder.m297equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m303getOnTopB_4ceCc())) {
            surfaceView.setZOrderOnTop(true);
        }
        surfaceView.setSecure(z2);
        return Unit.INSTANCE;
    }

    private static final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1057437053, "C(rememberAndroidEmbeddedExternalSurfaceState)371@14901L24,372@14937L55:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1057437053, i, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:370)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1710245786, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new AndroidEmbeddedExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = (AndroidEmbeddedExternalSurfaceState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidEmbeddedExternalSurfaceState;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0135  */
    /* JADX INFO: renamed from: AndroidEmbeddedExternalSurface-sv6N_fY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m307AndroidEmbeddedExternalSurfacesv6N_fY(androidx.compose.ui.Modifier r23, boolean r24, long r25, float[] r27, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.AndroidExternalSurfaceScope, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidExternalSurface_androidKt.m307AndroidEmbeddedExternalSurfacesv6N_fY(androidx.compose.ui.Modifier, boolean, long, float[], kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextureView AndroidEmbeddedExternalSurface_sv6N_fY$lambda$0$0(Context context) {
        return new TextureView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$1$0(TextureView textureView) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(long j, AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState, Function1 function1, boolean z, float[] fArr, TextureView textureView) {
        Matrix matrix;
        SurfaceTexture surfaceTexture;
        if (!IntSize.m8999equalsimpl0(j, IntSize.INSTANCE.m9006getZeroYbymL2g()) && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
            surfaceTexture.setDefaultBufferSize((int) (j >> 32), (int) (4294967295L & j));
        }
        androidEmbeddedExternalSurfaceState.m293setSurfaceSizeozmzZPI(j);
        if (textureView.getSurfaceTextureListener() != androidEmbeddedExternalSurfaceState) {
            function1.invoke(androidEmbeddedExternalSurfaceState);
            textureView.setSurfaceTextureListener(androidEmbeddedExternalSurfaceState);
        }
        textureView.setOpaque(z);
        if (fArr != null) {
            matrix = androidEmbeddedExternalSurfaceState.getMatrix();
            AndroidMatrixConversions_androidKt.m5835setFromEL8BTi8(matrix, fArr);
        } else {
            matrix = null;
        }
        textureView.setTransform(matrix);
        return Unit.INSTANCE;
    }
}
