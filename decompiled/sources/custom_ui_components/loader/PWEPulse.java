package custom_ui_components.loader;

import android.animation.ValueAnimator;
import custom_animations.animator.PWESpriteAnimatorBuilder;

/* JADX INFO: loaded from: classes9.dex */
public class PWEPulse extends PWELoaderCircleAnimation {
    public PWEPulse() {
        setScale(0.0f);
    }

    @Override // custom_ui_components.loader.PWELoaderCircleAnimation, custom_ui_components.loader.PWELoaderAnimation
    public ValueAnimator onCreateAnimation() {
        float[] fArr = {0.0f, 1.0f};
        return new PWESpriteAnimatorBuilder(this).scale(fArr, Float.valueOf(0.0f), Float.valueOf(1.0f)).alpha(fArr, 255, 0).duration(1000L).easeInOut(fArr).build();
    }
}
