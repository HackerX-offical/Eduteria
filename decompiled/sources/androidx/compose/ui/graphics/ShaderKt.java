package androidx.compose.ui.graphics;

import android.graphics.Shader;
import com.clevertap.android.sdk.Constants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: Shader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000e\u001aK\u0010\u000f\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013\u001a9\u0010\u0014\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a-\u0010\u0017\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001d\u001a1\u0010\u001e\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u001f\u001a\u00060\u0001j\u0002`\u00022\n\u0010 \u001a\u00060\u0001j\u0002`\u00022\u0006\u0010!\u001a\u00020\"¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"LinearGradientShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "LinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "RadialGradientShader", "center", Constants.KEY_RADIUS, "RadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "SweepGradientShader", "SweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "ImageShader", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "tileModeY", "ImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "CompositeShader", "dst", "src", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "CompositeShader-7EN7VTw", "(Landroid/graphics/Shader;Landroid/graphics/Shader;I)Landroid/graphics/Shader;", "ui-graphics"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ShaderKt {
    /* JADX INFO: renamed from: LinearGradientShader-VjE6UOU$default, reason: not valid java name */
    public static /* synthetic */ Shader m6305LinearGradientShaderVjE6UOU$default(long j, long j2, List list, List list2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            i = TileMode.INSTANCE.m6365getClamp3opZhB0();
        }
        return m6304LinearGradientShaderVjE6UOU(j, j2, list, list3, i);
    }

    /* JADX INFO: renamed from: LinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m6304LinearGradientShaderVjE6UOU(long j, long j2, List<Color> list, List<Float> list2, int i) {
        return AndroidShader_androidKt.m5867ActualLinearGradientShaderVjE6UOU(j, j2, list, list2, i);
    }

    /* JADX INFO: renamed from: RadialGradientShader-8uybcMk$default, reason: not valid java name */
    public static /* synthetic */ Shader m6307RadialGradientShader8uybcMk$default(long j, float f2, List list, List list2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            i = TileMode.INSTANCE.m6365getClamp3opZhB0();
        }
        return m6306RadialGradientShader8uybcMk(j, f2, list, list3, i);
    }

    /* JADX INFO: renamed from: RadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m6306RadialGradientShader8uybcMk(long j, float f2, List<Color> list, List<Float> list2, int i) {
        return AndroidShader_androidKt.m5868ActualRadialGradientShader8uybcMk(j, f2, list, list2, i);
    }

    /* JADX INFO: renamed from: SweepGradientShader-9KIMszo$default, reason: not valid java name */
    public static /* synthetic */ Shader m6309SweepGradientShader9KIMszo$default(long j, List list, List list2, int i, Object obj) {
        if ((i & 4) != 0) {
            list2 = null;
        }
        return m6308SweepGradientShader9KIMszo(j, list, list2);
    }

    /* JADX INFO: renamed from: SweepGradientShader-9KIMszo, reason: not valid java name */
    public static final Shader m6308SweepGradientShader9KIMszo(long j, List<Color> list, List<Float> list2) {
        return AndroidShader_androidKt.m5869ActualSweepGradientShader9KIMszo(j, list, list2);
    }

    /* JADX INFO: renamed from: ImageShader-F49vj9s$default, reason: not valid java name */
    public static /* synthetic */ Shader m6303ImageShaderF49vj9s$default(ImageBitmap imageBitmap, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = TileMode.INSTANCE.m6365getClamp3opZhB0();
        }
        if ((i3 & 4) != 0) {
            i2 = TileMode.INSTANCE.m6365getClamp3opZhB0();
        }
        return m6302ImageShaderF49vj9s(imageBitmap, i, i2);
    }

    /* JADX INFO: renamed from: ImageShader-F49vj9s, reason: not valid java name */
    public static final Shader m6302ImageShaderF49vj9s(ImageBitmap imageBitmap, int i, int i2) {
        return AndroidShader_androidKt.m5866ActualImageShaderF49vj9s(imageBitmap, i, i2);
    }

    /* JADX INFO: renamed from: CompositeShader-7EN7VTw, reason: not valid java name */
    public static final Shader m6301CompositeShader7EN7VTw(Shader shader, Shader shader2, int i) {
        return AndroidShader_androidKt.m5865ActualCompositeShader7EN7VTw(shader, shader2, i);
    }
}
