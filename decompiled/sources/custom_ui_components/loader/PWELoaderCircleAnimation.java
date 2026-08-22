package custom_ui_components.loader;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes9.dex */
public class PWELoaderCircleAnimation extends PWELoaderAnimationShapes {
    @Override // custom_ui_components.loader.PWELoaderAnimation
    public ValueAnimator onCreateAnimation() {
        return null;
    }

    @Override // custom_ui_components.loader.PWELoaderAnimationShapes
    public void drawShape(Canvas canvas, Paint paint) {
        if (getDrawBounds() != null) {
            canvas.drawCircle(getDrawBounds().centerX(), getDrawBounds().centerY(), Math.min(getDrawBounds().width(), getDrawBounds().height()) / 2, paint);
        }
    }
}
