package custom_ui_components.loader;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import custom_animations.animator.PWESpriteAnimatorBuilder;

/* JADX INFO: loaded from: classes9.dex */
public class PWEThreeBounce extends PWELoaderContainer {
    @Override // custom_ui_components.loader.PWELoaderContainer
    public PWELoaderAnimation[] onCreateChild() {
        return new PWELoaderAnimation[]{new Bounce(), new Bounce(), new Bounce()};
    }

    @Override // custom_ui_components.loader.PWELoaderContainer
    public void onChildCreated(PWELoaderAnimation... pWELoaderAnimationArr) {
        super.onChildCreated(pWELoaderAnimationArr);
        pWELoaderAnimationArr[1].setAnimationDelay(160);
        pWELoaderAnimationArr[2].setAnimationDelay(320);
    }

    @Override // custom_ui_components.loader.PWELoaderContainer, custom_ui_components.loader.PWELoaderAnimation, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect rectClipSquare = clipSquare(rect);
        int iWidth = rectClipSquare.width() / 8;
        int iCenterY = rectClipSquare.centerY() - iWidth;
        int iCenterY2 = rectClipSquare.centerY() + iWidth;
        for (int i = 0; i < getChildCount(); i++) {
            int iWidth2 = ((rectClipSquare.width() * i) / 3) + rectClipSquare.left;
            getChildAt(i).setDrawBounds(iWidth2, iCenterY, (iWidth * 2) + iWidth2, iCenterY2);
        }
    }

    private class Bounce extends PWELoaderCircleAnimation {
        Bounce() {
            setScale(0.0f);
        }

        @Override // custom_ui_components.loader.PWELoaderCircleAnimation, custom_ui_components.loader.PWELoaderAnimation
        public ValueAnimator onCreateAnimation() {
            float[] fArr = {0.0f, 0.4f, 0.8f, 1.0f};
            PWESpriteAnimatorBuilder pWESpriteAnimatorBuilder = new PWESpriteAnimatorBuilder(this);
            Float fValueOf = Float.valueOf(0.0f);
            return pWESpriteAnimatorBuilder.scale(fArr, fValueOf, Float.valueOf(1.0f), fValueOf, fValueOf).duration(1400L).easeInOut(fArr).build();
        }
    }
}
