package custom_ui_components.loader;

import android.animation.ValueAnimator;
import custom_animations.animator.PWESpriteAnimatorBuilder;

/* JADX INFO: loaded from: classes9.dex */
public class PWERotatingCircle extends PWELoaderCircleAnimation {
    @Override // custom_ui_components.loader.PWELoaderCircleAnimation, custom_ui_components.loader.PWELoaderAnimation
    public ValueAnimator onCreateAnimation() {
        float[] fArr = {0.0f, 0.5f, 1.0f};
        return new PWESpriteAnimatorBuilder(this).rotateX(fArr, 0, -180, -180).rotateY(fArr, 0, 0, -180).duration(1200L).easeInOut(fArr).build();
    }
}
