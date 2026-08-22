package custom_ui_components.loader;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import custom_animations.animator.AnimationUtils;

/* JADX INFO: loaded from: classes9.dex */
public abstract class PWELoaderContainer extends PWELoaderAnimation {
    private int color;
    private PWELoaderAnimation[] sprites = onCreateChild();

    @Override // custom_ui_components.loader.PWELoaderAnimation
    protected void drawSelf(Canvas canvas) {
    }

    public void onChildCreated(PWELoaderAnimation... pWELoaderAnimationArr) {
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation
    public ValueAnimator onCreateAnimation() {
        return null;
    }

    public abstract PWELoaderAnimation[] onCreateChild();

    public PWELoaderContainer() {
        initCallBack();
        onChildCreated(this.sprites);
    }

    private void initCallBack() {
        PWELoaderAnimation[] pWELoaderAnimationArr = this.sprites;
        if (pWELoaderAnimationArr != null) {
            for (PWELoaderAnimation pWELoaderAnimation : pWELoaderAnimationArr) {
                pWELoaderAnimation.setCallback(this);
            }
        }
    }

    public int getChildCount() {
        PWELoaderAnimation[] pWELoaderAnimationArr = this.sprites;
        if (pWELoaderAnimationArr == null) {
            return 0;
        }
        return pWELoaderAnimationArr.length;
    }

    public PWELoaderAnimation getChildAt(int i) {
        PWELoaderAnimation[] pWELoaderAnimationArr = this.sprites;
        if (pWELoaderAnimationArr == null) {
            return null;
        }
        return pWELoaderAnimationArr[i];
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation
    public void setColor(int i) {
        this.color = i;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).setColor(i);
        }
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation
    public int getColor() {
        return this.color;
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawChild(canvas);
    }

    public void drawChild(Canvas canvas) {
        PWELoaderAnimation[] pWELoaderAnimationArr = this.sprites;
        if (pWELoaderAnimationArr != null) {
            for (PWELoaderAnimation pWELoaderAnimation : pWELoaderAnimationArr) {
                int iSave = canvas.save();
                pWELoaderAnimation.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        for (PWELoaderAnimation pWELoaderAnimation : this.sprites) {
            pWELoaderAnimation.setBounds(rect);
        }
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation, android.graphics.drawable.Animatable
    public void start() {
        super.start();
        AnimationUtils.start(this.sprites);
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation, android.graphics.drawable.Animatable
    public void stop() {
        super.stop();
        AnimationUtils.stop(this.sprites);
    }

    @Override // custom_ui_components.loader.PWELoaderAnimation, android.graphics.drawable.Animatable
    public boolean isRunning() {
        return AnimationUtils.isRunning(this.sprites) || super.isRunning();
    }
}
