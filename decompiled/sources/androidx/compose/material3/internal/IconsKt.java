package androidx.compose.material3.internal;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: Icons.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0082\b\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0082\b\u001aK\u0010\n\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0005¢\u0006\u0002\b\u0007H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014\"\u000e\u0010\u0015\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"materialIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "name", "", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Lkotlin/ExtensionFunctionType;", "autoMirror", "", "materialPath", "fillAlpha", "", "strokeAlpha", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "materialPath-YwgOQQI", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;FFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "MaterialIconDimension", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconsKt {
    private static final float MaterialIconDimension = 24.0f;

    private static final ImageVector materialIcon(String str, Function1<? super ImageVector.Builder, ImageVector.Builder> function1) {
        return function1.invoke(new ImageVector.Builder(str, Dp.m8830constructorimpl(MaterialIconDimension), Dp.m8830constructorimpl(MaterialIconDimension), MaterialIconDimension, MaterialIconDimension, 0L, 0, false, 224, null)).build();
    }

    private static final ImageVector materialIcon(String str, boolean z, Function1<? super ImageVector.Builder, ImageVector.Builder> function1) {
        return function1.invoke(new ImageVector.Builder(str, Dp.m8830constructorimpl(MaterialIconDimension), Dp.m8830constructorimpl(MaterialIconDimension), MaterialIconDimension, MaterialIconDimension, 0L, 0, z, 96, null)).build();
    }

    static /* synthetic */ ImageVector materialIcon$default(String str, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return ((ImageVector.Builder) function1.invoke(new ImageVector.Builder(str, Dp.m8830constructorimpl(MaterialIconDimension), Dp.m8830constructorimpl(MaterialIconDimension), MaterialIconDimension, MaterialIconDimension, 0L, 0, z, 96, null))).build();
    }

    /* JADX INFO: renamed from: materialPath-YwgOQQI$default, reason: not valid java name */
    static /* synthetic */ ImageVector.Builder m4063materialPathYwgOQQI$default(ImageVector.Builder builder, float f2, float f3, int i, Function1 function1, int i2, Object obj) {
        float f4 = (i2 & 1) != 0 ? 1.0f : f2;
        float f5 = (i2 & 2) != 0 ? 1.0f : f3;
        int defaultFillType = (i2 & 4) != 0 ? VectorKt.getDefaultFillType() : i;
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m5994getBlack0d7_KjU(), null);
        int iM6344getButtKaPHkGw = StrokeCap.INSTANCE.m6344getButtKaPHkGw();
        int iM6354getBevelLxFBmk8 = StrokeJoin.INSTANCE.m6354getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        function1.invoke(pathBuilder);
        return ImageVector.Builder.m6706addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, f4, null, f5, 1.0f, iM6344getButtKaPHkGw, iM6354getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    }

    /* JADX INFO: renamed from: materialPath-YwgOQQI, reason: not valid java name */
    private static final ImageVector.Builder m4062materialPathYwgOQQI(ImageVector.Builder builder, float f2, float f3, int i, Function1<? super PathBuilder, Unit> function1) {
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m5994getBlack0d7_KjU(), null);
        int iM6344getButtKaPHkGw = StrokeCap.INSTANCE.m6344getButtKaPHkGw();
        int iM6354getBevelLxFBmk8 = StrokeJoin.INSTANCE.m6354getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        function1.invoke(pathBuilder);
        return ImageVector.Builder.m6706addPathoIyEayM$default(builder, pathBuilder.getNodes(), i, "", solidColor, f2, null, f3, 1.0f, iM6344getButtKaPHkGw, iM6354getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    }
}
