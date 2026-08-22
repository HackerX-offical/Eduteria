package androidx.compose.ui.graphics;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidCanvas.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0001\"\u0015\u0010\u0010\u001a\u00020\u0001*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*8\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B*\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u001c\b\u0005\u0012\u0018\b\u000bB\u0014\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\b\t\u0012\u0002\b\f¨\u0006\u0014"}, d2 = {"NativeCanvas", "Landroid/graphics/Canvas;", "Lkotlin/Deprecated;", "message", "Use android.graphics.Canvas directly instead", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "android.graphics.Canvas", "imports", "ActualCanvas", "Landroidx/compose/ui/graphics/Canvas;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "Canvas", "c", "nativeCanvas", "getNativeCanvas", "(Landroidx/compose/ui/graphics/Canvas;)Landroid/graphics/Canvas;", "EmptyCanvas", "ui-graphics"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AndroidCanvas_androidKt {
    private static final android.graphics.Canvas EmptyCanvas = new android.graphics.Canvas();

    @Deprecated(message = "Use android.graphics.Canvas directly instead", replaceWith = @ReplaceWith(expression = "android.graphics.Canvas", imports = {}))
    public static /* synthetic */ void NativeCanvas$annotations() {
    }

    public static final Canvas ActualCanvas(ImageBitmap imageBitmap) {
        AndroidCanvas androidCanvas = new AndroidCanvas();
        androidCanvas.setInternalCanvas(new android.graphics.Canvas(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap)));
        return androidCanvas;
    }

    public static final Canvas Canvas(android.graphics.Canvas canvas) {
        AndroidCanvas androidCanvas = new AndroidCanvas();
        androidCanvas.setInternalCanvas(canvas);
        return androidCanvas;
    }

    public static final android.graphics.Canvas getNativeCanvas(Canvas canvas) {
        Intrinsics.checkNotNull(canvas, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidCanvas");
        return ((AndroidCanvas) canvas).getInternalCanvas();
    }
}
