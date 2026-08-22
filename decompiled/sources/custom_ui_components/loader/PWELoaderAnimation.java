package custom_ui_components.loader;

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.appnew.android.Utils.imagecropper.CropImage;
import custom_animations.FloatProperty;
import custom_animations.IntProperty;
import custom_animations.animator.AnimationUtils;

/* JADX INFO: loaded from: classes9.dex */
public abstract class PWELoaderAnimation extends Drawable implements ValueAnimator.AnimatorUpdateListener, Animatable, Drawable.Callback {
    private int animationDelay;
    private ValueAnimator animator;
    private float pivotX;
    private float pivotY;
    private int rotate;
    private int rotateX;
    private int rotateY;
    private int translateX;
    private float translateXPercentage;
    private int translateY;
    private float translateYPercentage;
    private static final Rect ZERO_BOUNDS_RECT = new Rect();
    public static final Property<PWELoaderAnimation, Integer> ROTATE_X = new IntProperty<PWELoaderAnimation>("rotateX") { // from class: custom_ui_components.loader.PWELoaderAnimation.1
        @Override // custom_animations.IntProperty
        public void setValue(PWELoaderAnimation pWELoaderAnimation, int i) {
            pWELoaderAnimation.setRotateX(i);
        }

        @Override // android.util.Property
        public Integer get(PWELoaderAnimation pWELoaderAnimation) {
            return Integer.valueOf(pWELoaderAnimation.getRotateX());
        }
    };
    public static final Property<PWELoaderAnimation, Integer> ROTATE = new IntProperty<PWELoaderAnimation>("rotate") { // from class: custom_ui_components.loader.PWELoaderAnimation.2
        @Override // custom_animations.IntProperty
        public void setValue(PWELoaderAnimation pWELoaderAnimation, int i) {
            pWELoaderAnimation.setRotate(i);
        }

        @Override // android.util.Property
        public Integer get(PWELoaderAnimation pWELoaderAnimation) {
            return Integer.valueOf(pWELoaderAnimation.getRotate());
        }
    };
    public static final Property<PWELoaderAnimation, Integer> ROTATE_Y = new IntProperty<PWELoaderAnimation>("rotateY") { // from class: custom_ui_components.loader.PWELoaderAnimation.3
        @Override // custom_animations.IntProperty
        public void setValue(PWELoaderAnimation pWELoaderAnimation, int i) {
            pWELoaderAnimation.setRotateY(i);
        }

        @Override // android.util.Property
        public Integer get(PWELoaderAnimation pWELoaderAnimation) {
            return Integer.valueOf(pWELoaderAnimation.getRotateY());
        }
    };
    public static final Property<PWELoaderAnimation, Integer> TRANSLATE_X = new IntProperty<PWELoaderAnimation>("translateX") { // from class: custom_ui_components.loader.PWELoaderAnimation.4
        @Override // custom_animations.IntProperty
        public void setValue(PWELoaderAnimation pWELoaderAnimation, int i) {
            pWELoaderAnimation.setTranslateX(i);
        }

        @Override // android.util.Property
        public Integer get(PWELoaderAnimation pWELoaderAnimation) {
            return Integer.valueOf(pWELoaderAnimation.getTranslateX());
        }
    };
    public static final Property<PWELoaderAnimation, Integer> TRANSLATE_Y = new IntProperty<PWELoaderAnimation>("translateY") { // from class: custom_ui_components.loader.PWELoaderAnimation.5
        @Override // custom_animations.IntProperty
        public void setValue(PWELoaderAnimation pWELoaderAnimation, int i) {
            pWELoaderAnimation.setTranslateY(i);
        }

        @Override // android.util.Property
        public Integer get(PWELoaderAnimation pWELoaderAnimation) {
            return Integer.valueOf(pWELoaderAnimation.getTranslateY());
        }
    };
    public static final Property<PWELoaderAnimation, Float> TRANSLATE_X_PERCENTAGE = new FloatProperty<PWELoaderAnimation>("translateXPercentage") { // from class: custom_ui_components.loader.PWELoaderAnimation.6
        @Override // custom_animations.FloatProperty
        public void setValue(PWELoaderAnimation pWELoaderAnimation, float f2) {
            pWELoaderAnimation.setTranslateXPercentage(f2);
        }

        @Override // android.util.Property
        public Float get(PWELoaderAnimation pWELoaderAnimation) {
            return Float.valueOf(pWELoaderAnimation.getTranslateXPercentage());
        }
    };
    public static final Property<PWELoaderAnimation, Float> TRANSLATE_Y_PERCENTAGE = new FloatProperty<PWELoaderAnimation>("translateYPercentage") { // from class: custom_ui_components.loader.PWELoaderAnimation.7
        @Override // custom_animations.FloatProperty
        public void setValue(PWELoaderAnimation pWELoaderAnimation, float f2) {
            pWELoaderAnimation.setTranslateYPercentage(f2);
        }

        @Override // android.util.Property
        public Float get(PWELoaderAnimation pWELoaderAnimation) {
            return Float.valueOf(pWELoaderAnimation.getTranslateYPercentage());
        }
    };
    public static final Property<PWELoaderAnimation, Float> SCALE_X = new FloatProperty<PWELoaderAnimation>("scaleX") { // from class: custom_ui_components.loader.PWELoaderAnimation.8
        @Override // custom_animations.FloatProperty
        public void setValue(PWELoaderAnimation pWELoaderAnimation, float f2) {
            pWELoaderAnimation.setScaleX(f2);
        }

        @Override // android.util.Property
        public Float get(PWELoaderAnimation pWELoaderAnimation) {
            return Float.valueOf(pWELoaderAnimation.getScaleX());
        }
    };
    public static final Property<PWELoaderAnimation, Float> SCALE_Y = new FloatProperty<PWELoaderAnimation>("scaleY") { // from class: custom_ui_components.loader.PWELoaderAnimation.9
        @Override // custom_animations.FloatProperty
        public void setValue(PWELoaderAnimation pWELoaderAnimation, float f2) {
            pWELoaderAnimation.setScaleY(f2);
        }

        @Override // android.util.Property
        public Float get(PWELoaderAnimation pWELoaderAnimation) {
            return Float.valueOf(pWELoaderAnimation.getScaleY());
        }
    };
    public static final Property<PWELoaderAnimation, Float> SCALE = new FloatProperty<PWELoaderAnimation>(CropImage.SCALE) { // from class: custom_ui_components.loader.PWELoaderAnimation.10
        @Override // custom_animations.FloatProperty
        public void setValue(PWELoaderAnimation pWELoaderAnimation, float f2) {
            pWELoaderAnimation.setScale(f2);
        }

        @Override // android.util.Property
        public Float get(PWELoaderAnimation pWELoaderAnimation) {
            return Float.valueOf(pWELoaderAnimation.getScale());
        }
    };
    public static final Property<PWELoaderAnimation, Integer> ALPHA = new IntProperty<PWELoaderAnimation>("alpha") { // from class: custom_ui_components.loader.PWELoaderAnimation.11
        @Override // custom_animations.IntProperty
        public void setValue(PWELoaderAnimation pWELoaderAnimation, int i) {
            pWELoaderAnimation.setAlpha(i);
        }

        @Override // android.util.Property
        public Integer get(PWELoaderAnimation pWELoaderAnimation) {
            return Integer.valueOf(pWELoaderAnimation.getAlpha());
        }
    };
    private float scale = 1.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private int alpha = 255;
    protected Rect drawBounds = ZERO_BOUNDS_RECT;
    private Camera mCamera = new Camera();
    private Matrix mMatrix = new Matrix();

    protected abstract void drawSelf(Canvas canvas);

    public abstract int getColor();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public abstract ValueAnimator onCreateAnimation();

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    public abstract void setColor(int i);

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.alpha = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    public float getTranslateXPercentage() {
        return this.translateXPercentage;
    }

    public void setTranslateXPercentage(float f2) {
        this.translateXPercentage = f2;
    }

    public float getTranslateYPercentage() {
        return this.translateYPercentage;
    }

    public void setTranslateYPercentage(float f2) {
        this.translateYPercentage = f2;
    }

    public int getTranslateX() {
        return this.translateX;
    }

    public void setTranslateX(int i) {
        this.translateX = i;
    }

    public int getTranslateY() {
        return this.translateY;
    }

    public void setTranslateY(int i) {
        this.translateY = i;
    }

    public int getRotate() {
        return this.rotate;
    }

    public void setRotate(int i) {
        this.rotate = i;
    }

    public float getScale() {
        return this.scale;
    }

    public void setScale(float f2) {
        this.scale = f2;
        setScaleX(f2);
        setScaleY(f2);
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public void setScaleX(float f2) {
        this.scaleX = f2;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void setScaleY(float f2) {
        this.scaleY = f2;
    }

    public int getRotateX() {
        return this.rotateX;
    }

    public void setRotateX(int i) {
        this.rotateX = i;
    }

    public int getRotateY() {
        return this.rotateY;
    }

    public void setRotateY(int i) {
        this.rotateY = i;
    }

    public float getPivotX() {
        return this.pivotX;
    }

    public void setPivotX(float f2) {
        this.pivotX = f2;
    }

    public float getPivotY() {
        return this.pivotY;
    }

    public void setPivotY(float f2) {
        this.pivotY = f2;
    }

    public int getAnimationDelay() {
        return this.animationDelay;
    }

    public PWELoaderAnimation setAnimationDelay(int i) {
        this.animationDelay = i;
        return this;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (AnimationUtils.isStarted(this.animator)) {
            return;
        }
        ValueAnimator valueAnimatorObtainAnimation = obtainAnimation();
        this.animator = valueAnimatorObtainAnimation;
        if (valueAnimatorObtainAnimation == null) {
            return;
        }
        AnimationUtils.start(valueAnimatorObtainAnimation);
        invalidateSelf();
    }

    public ValueAnimator obtainAnimation() {
        if (this.animator == null) {
            this.animator = onCreateAnimation();
        }
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(this);
            this.animator.setStartDelay(this.animationDelay);
        }
        return this.animator;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (AnimationUtils.isStarted(this.animator)) {
            this.animator.removeAllUpdateListeners();
            this.animator.end();
            reset();
        }
    }

    public void reset() {
        this.scale = 1.0f;
        this.rotateX = 0;
        this.rotateY = 0;
        this.translateX = 0;
        this.translateY = 0;
        this.rotate = 0;
        this.translateXPercentage = 0.0f;
        this.translateYPercentage = 0.0f;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return AnimationUtils.isRunning(this.animator);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setDrawBounds(rect);
    }

    public void setDrawBounds(Rect rect) {
        setDrawBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setDrawBounds(int i, int i2, int i3, int i4) {
        this.drawBounds = new Rect(i, i2, i3, i4);
        setPivotX(getDrawBounds().centerX());
        setPivotY(getDrawBounds().centerY());
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public Rect getDrawBounds() {
        return this.drawBounds;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int translateX = getTranslateX();
        if (translateX == 0) {
            translateX = (int) (getBounds().width() * getTranslateXPercentage());
        }
        int translateY = getTranslateY();
        if (translateY == 0) {
            translateY = (int) (getBounds().height() * getTranslateYPercentage());
        }
        canvas.translate(translateX, translateY);
        canvas.scale(getScaleX(), getScaleY(), getPivotX(), getPivotY());
        canvas.rotate(getRotate(), getPivotX(), getPivotY());
        if (getRotateX() != 0 || getRotateY() != 0) {
            this.mCamera.save();
            this.mCamera.rotateX(getRotateX());
            this.mCamera.rotateY(getRotateY());
            this.mCamera.getMatrix(this.mMatrix);
            this.mMatrix.preTranslate(-getPivotX(), -getPivotY());
            this.mMatrix.postTranslate(getPivotX(), getPivotY());
            this.mCamera.restore();
            canvas.concat(this.mMatrix);
        }
        drawSelf(canvas);
    }

    public Rect clipSquare(Rect rect) {
        int iMin = Math.min(rect.width(), rect.height());
        int iCenterX = rect.centerX();
        int iCenterY = rect.centerY();
        int i = iMin / 2;
        return new Rect(iCenterX - i, iCenterY - i, iCenterX + i, iCenterY + i);
    }
}
