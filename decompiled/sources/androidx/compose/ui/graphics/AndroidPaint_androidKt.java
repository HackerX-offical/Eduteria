package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AndroidPaint.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\n\u001a\u00020\u000b\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\u0001\u001a\b\u0010\u0010\u001a\u00020\u0001H\u0000\u001a\u001b\u0010\u0011\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0016\u0010\u0017\u001a\u00020\u0012*\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u0001H\u0000\u001a\u0014\u0010\u001c\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u001bH\u0000\u001a\f\u0010\u001d\u001a\u00020\u001e*\u00020\u0001H\u0000\u001a\u0014\u0010\u001f\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u001eH\u0000\u001a\u0011\u0010 \u001a\u00020!*\u00020\u0001H\u0000¢\u0006\u0002\u0010\"\u001a\u001b\u0010#\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0018\u001a\u00020!H\u0000¢\u0006\u0004\b$\u0010%\u001a\u001b\u0010&\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0018\u001a\u00020'H\u0000¢\u0006\u0004\b(\u0010\u0016\u001a\u0011\u0010)\u001a\u00020'*\u00020\u0001H\u0000¢\u0006\u0002\u0010*\u001a\f\u0010+\u001a\u00020\u001b*\u00020\u0001H\u0000\u001a\u0014\u0010,\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u001bH\u0000\u001a\u0011\u0010-\u001a\u00020.*\u00020\u0001H\u0000¢\u0006\u0002\u0010*\u001a\u001b\u0010/\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0018\u001a\u00020.H\u0000¢\u0006\u0004\b0\u0010\u0016\u001a\u0011\u00101\u001a\u000202*\u00020\u0001H\u0000¢\u0006\u0002\u0010*\u001a\u001b\u00103\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0018\u001a\u000202H\u0000¢\u0006\u0004\b4\u0010\u0016\u001a\f\u00105\u001a\u00020\u001b*\u00020\u0001H\u0000\u001a\u0014\u00106\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u001bH\u0000\u001a\u0011\u00107\u001a\u000208*\u00020\u0001H\u0000¢\u0006\u0002\u0010*\u001a\u001b\u00109\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0018\u001a\u000208H\u0000¢\u0006\u0004\b:\u0010\u0016\u001a\u001c\u0010;\u001a\u00020\u0012*\u00020\u00012\u000e\u0010\u0018\u001a\n\u0018\u00010<j\u0004\u0018\u0001`=H\u0000\u001a\u0016\u0010>\u001a\u00020\u0012*\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010?H\u0000\"\u0015\u0010\r\u001a\u00020\u0001*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f*8\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B*\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u001c\b\u0005\u0012\u0018\b\u000bB\u0014\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\b\t\u0012\u0002\b\f¨\u0006@"}, d2 = {"NativePaint", "Landroid/graphics/Paint;", "Lkotlin/Deprecated;", "message", "Use android.graphics.Paint directly instead", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "android.graphics.Paint", "imports", "Paint", "Landroidx/compose/ui/graphics/Paint;", "asComposePaint", "nativePaint", "getNativePaint", "(Landroidx/compose/ui/graphics/Paint;)Landroid/graphics/Paint;", "makeNativePaint", "setNativeBlendMode", "", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setNativeBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "setNativeColorFilter", "value", "Landroidx/compose/ui/graphics/ColorFilter;", "getNativeAlpha", "", "setNativeAlpha", "getNativeAntiAlias", "", "setNativeAntiAlias", "getNativeColor", "Landroidx/compose/ui/graphics/Color;", "(Landroid/graphics/Paint;)J", "setNativeColor", "setNativeColor-4WTKRHQ", "(Landroid/graphics/Paint;J)V", "setNativeStyle", "Landroidx/compose/ui/graphics/PaintingStyle;", "setNativeStyle--5YerkU", "getNativeStyle", "(Landroid/graphics/Paint;)I", "getNativeStrokeWidth", "setNativeStrokeWidth", "getNativeStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "setNativeStrokeCap", "setNativeStrokeCap-CSYIeUk", "getNativeStrokeJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "setNativeStrokeJoin", "setNativeStrokeJoin-kLtJ_vA", "getNativeStrokeMiterLimit", "setNativeStrokeMiterLimit", "getNativeFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "setNativeFilterQuality", "setNativeFilterQuality-50PEsBU", "setNativeShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "setNativePathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "ui-graphics"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AndroidPaint_androidKt {

    /* JADX INFO: compiled from: AndroidPaint.android.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            try {
                iArr[Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            try {
                iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            try {
                iArr3[Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @Deprecated(message = "Use android.graphics.Paint directly instead", replaceWith = @ReplaceWith(expression = "android.graphics.Paint", imports = {}))
    public static /* synthetic */ void NativePaint$annotations() {
    }

    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final Paint asComposePaint(android.graphics.Paint paint) {
        return new AndroidPaint(paint);
    }

    public static final android.graphics.Paint getNativePaint(Paint paint) {
        if (!(paint instanceof AndroidPaint)) {
            InlineClassHelperKt.throwIllegalArgumentException("Extracting native reference is only supported from androidx.compose.ui.graphics.AndroidPaint instances but received " + Reflection.getOrCreateKotlinClass(paint.getClass()).getQualifiedName());
        }
        return ((AndroidPaint) paint).getInternalPaint$ui_graphics();
    }

    public static final android.graphics.Paint makeNativePaint() {
        return new android.graphics.Paint(7);
    }

    /* JADX INFO: renamed from: setNativeBlendMode-GB0RdKg, reason: not valid java name */
    public static final void m5849setNativeBlendModeGB0RdKg(android.graphics.Paint paint, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m6396setBlendModeGB0RdKg(paint, i);
        } else {
            paint.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m5816toPorterDuffModes9anfk8(i)));
        }
    }

    public static final void setNativeColorFilter(android.graphics.Paint paint, ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
    }

    public static final float getNativeAlpha(android.graphics.Paint paint) {
        return paint.getAlpha() / 255.0f;
    }

    public static final void setNativeAlpha(android.graphics.Paint paint, float f2) {
        paint.setAlpha((int) Math.rint(f2 * 255.0f));
    }

    public static final boolean getNativeAntiAlias(android.graphics.Paint paint) {
        return paint.isAntiAlias();
    }

    public static final void setNativeAntiAlias(android.graphics.Paint paint, boolean z) {
        paint.setAntiAlias(z);
    }

    public static final long getNativeColor(android.graphics.Paint paint) {
        return ColorKt.Color(paint.getColor());
    }

    /* JADX INFO: renamed from: setNativeColor-4WTKRHQ, reason: not valid java name */
    public static final void m5850setNativeColor4WTKRHQ(android.graphics.Paint paint, long j) {
        paint.setColor(ColorKt.m6022toArgb8_81llA(j));
    }

    /* JADX INFO: renamed from: setNativeStyle--5YerkU, reason: not valid java name */
    public static final void m5854setNativeStyle5YerkU(android.graphics.Paint paint, int i) {
        paint.setStyle(PaintingStyle.m6247equalsimpl0(i, PaintingStyle.INSTANCE.m6252getStrokeTiuSbCo()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }

    public static final int getNativeStyle(android.graphics.Paint paint) {
        Paint.Style style = paint.getStyle();
        if ((style == null ? -1 : WhenMappings.$EnumSwitchMapping$0[style.ordinal()]) == 1) {
            return PaintingStyle.INSTANCE.m6252getStrokeTiuSbCo();
        }
        return PaintingStyle.INSTANCE.m6251getFillTiuSbCo();
    }

    public static final float getNativeStrokeWidth(android.graphics.Paint paint) {
        return paint.getStrokeWidth();
    }

    public static final void setNativeStrokeWidth(android.graphics.Paint paint, float f2) {
        paint.setStrokeWidth(f2);
    }

    public static final int getNativeStrokeCap(android.graphics.Paint paint) {
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i = strokeCap == null ? -1 : WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        if (i == 1) {
            return StrokeCap.INSTANCE.m6344getButtKaPHkGw();
        }
        if (i == 2) {
            return StrokeCap.INSTANCE.m6345getRoundKaPHkGw();
        }
        if (i == 3) {
            return StrokeCap.INSTANCE.m6346getSquareKaPHkGw();
        }
        return StrokeCap.INSTANCE.m6344getButtKaPHkGw();
    }

    /* JADX INFO: renamed from: setNativeStrokeCap-CSYIeUk, reason: not valid java name */
    public static final void m5852setNativeStrokeCapCSYIeUk(android.graphics.Paint paint, int i) {
        Paint.Cap cap;
        if (StrokeCap.m6340equalsimpl0(i, StrokeCap.INSTANCE.m6346getSquareKaPHkGw())) {
            cap = Paint.Cap.SQUARE;
        } else if (StrokeCap.m6340equalsimpl0(i, StrokeCap.INSTANCE.m6345getRoundKaPHkGw())) {
            cap = Paint.Cap.ROUND;
        } else {
            cap = StrokeCap.m6340equalsimpl0(i, StrokeCap.INSTANCE.m6344getButtKaPHkGw()) ? Paint.Cap.BUTT : Paint.Cap.BUTT;
        }
        paint.setStrokeCap(cap);
    }

    public static final int getNativeStrokeJoin(android.graphics.Paint paint) {
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i = strokeJoin == null ? -1 : WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        if (i == 1) {
            return StrokeJoin.INSTANCE.m6355getMiterLxFBmk8();
        }
        if (i == 2) {
            return StrokeJoin.INSTANCE.m6354getBevelLxFBmk8();
        }
        if (i == 3) {
            return StrokeJoin.INSTANCE.m6356getRoundLxFBmk8();
        }
        return StrokeJoin.INSTANCE.m6355getMiterLxFBmk8();
    }

    /* JADX INFO: renamed from: setNativeStrokeJoin-kLtJ_vA, reason: not valid java name */
    public static final void m5853setNativeStrokeJoinkLtJ_vA(android.graphics.Paint paint, int i) {
        Paint.Join join;
        if (StrokeJoin.m6350equalsimpl0(i, StrokeJoin.INSTANCE.m6355getMiterLxFBmk8())) {
            join = Paint.Join.MITER;
        } else if (StrokeJoin.m6350equalsimpl0(i, StrokeJoin.INSTANCE.m6354getBevelLxFBmk8())) {
            join = Paint.Join.BEVEL;
        } else {
            join = StrokeJoin.m6350equalsimpl0(i, StrokeJoin.INSTANCE.m6356getRoundLxFBmk8()) ? Paint.Join.ROUND : Paint.Join.MITER;
        }
        paint.setStrokeJoin(join);
    }

    public static final float getNativeStrokeMiterLimit(android.graphics.Paint paint) {
        return paint.getStrokeMiter();
    }

    public static final void setNativeStrokeMiterLimit(android.graphics.Paint paint, float f2) {
        paint.setStrokeMiter(f2);
    }

    public static final int getNativeFilterQuality(android.graphics.Paint paint) {
        if (!paint.isFilterBitmap()) {
            return FilterQuality.INSTANCE.m6072getNonefv9h1I();
        }
        return FilterQuality.INSTANCE.m6070getLowfv9h1I();
    }

    /* JADX INFO: renamed from: setNativeFilterQuality-50PEsBU, reason: not valid java name */
    public static final void m5851setNativeFilterQuality50PEsBU(android.graphics.Paint paint, int i) {
        paint.setFilterBitmap(!FilterQuality.m6065equalsimpl0(i, FilterQuality.INSTANCE.m6072getNonefv9h1I()));
    }

    public static final void setNativeShader(android.graphics.Paint paint, Shader shader) {
        paint.setShader(shader);
    }

    public static final void setNativePathEffect(android.graphics.Paint paint, PathEffect pathEffect) {
        AndroidPathEffect androidPathEffect = (AndroidPathEffect) pathEffect;
        paint.setPathEffect(androidPathEffect != null ? androidPathEffect.getNativePathEffect() : null);
    }
}
