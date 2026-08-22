package custom_animations.animator;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Log;
import android.util.Property;
import android.view.animation.Interpolator;
import custom_animations.interpolators.KeyFrameInterpolator;
import custom_ui_components.loader.PWELoaderAnimation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class PWESpriteAnimatorBuilder {
    private static final String TAG = "SpriteAnimatorBuilder";
    private Interpolator interpolator;
    private PWELoaderAnimation sprite;
    private int repeatCount = -1;
    private long duration = 2000;
    private int startFrame = 0;
    private Map<String, FrameData> fds = new HashMap();

    class FrameData<T> {
        float[] fractions;
        Property property;
        T[] values;

        public FrameData(float[] fArr, Property property, T[] tArr) {
            this.fractions = fArr;
            this.property = property;
            this.values = tArr;
        }
    }

    class IntFrameData extends FrameData<Integer> {
        public IntFrameData(float[] fArr, Property property, Integer[] numArr) {
            super(fArr, property, numArr);
        }
    }

    class FloatFrameData extends FrameData<Float> {
        public FloatFrameData(float[] fArr, Property property, Float[] fArr2) {
            super(fArr, property, fArr2);
        }
    }

    public PWESpriteAnimatorBuilder(PWELoaderAnimation pWELoaderAnimation) {
        this.sprite = pWELoaderAnimation;
    }

    public PWESpriteAnimatorBuilder scale(float[] fArr, Float... fArr2) {
        holder(fArr, PWELoaderAnimation.SCALE, fArr2);
        return this;
    }

    public PWESpriteAnimatorBuilder alpha(float[] fArr, Integer... numArr) {
        holder(fArr, PWELoaderAnimation.ALPHA, numArr);
        return this;
    }

    public PWESpriteAnimatorBuilder scaleX(float[] fArr, Float... fArr2) {
        holder(fArr, PWELoaderAnimation.SCALE, fArr2);
        return this;
    }

    public PWESpriteAnimatorBuilder scaleY(float[] fArr, Float... fArr2) {
        holder(fArr, PWELoaderAnimation.SCALE_Y, fArr2);
        return this;
    }

    public PWESpriteAnimatorBuilder rotateX(float[] fArr, Integer... numArr) {
        holder(fArr, PWELoaderAnimation.ROTATE_X, numArr);
        return this;
    }

    public PWESpriteAnimatorBuilder rotateY(float[] fArr, Integer... numArr) {
        holder(fArr, PWELoaderAnimation.ROTATE_Y, numArr);
        return this;
    }

    public PWESpriteAnimatorBuilder translateX(float[] fArr, Integer... numArr) {
        holder(fArr, PWELoaderAnimation.TRANSLATE_X, numArr);
        return this;
    }

    public PWESpriteAnimatorBuilder translateY(float[] fArr, Integer... numArr) {
        holder(fArr, PWELoaderAnimation.TRANSLATE_Y, numArr);
        return this;
    }

    public PWESpriteAnimatorBuilder rotate(float[] fArr, Integer... numArr) {
        holder(fArr, PWELoaderAnimation.ROTATE, numArr);
        return this;
    }

    public PWESpriteAnimatorBuilder translateXPercentage(float[] fArr, Float... fArr2) {
        holder(fArr, PWELoaderAnimation.TRANSLATE_X_PERCENTAGE, fArr2);
        return this;
    }

    public PWESpriteAnimatorBuilder translateYPercentage(float[] fArr, Float... fArr2) {
        holder(fArr, PWELoaderAnimation.TRANSLATE_Y_PERCENTAGE, fArr2);
        return this;
    }

    private void holder(float[] fArr, Property property, Float[] fArr2) {
        ensurePair(fArr.length, fArr2.length);
        this.fds.put(property.getName(), new FloatFrameData(fArr, property, fArr2));
    }

    private void holder(float[] fArr, Property property, Integer[] numArr) {
        ensurePair(fArr.length, numArr.length);
        this.fds.put(property.getName(), new IntFrameData(fArr, property, numArr));
    }

    private void ensurePair(int i, int i2) {
        if (i != i2) {
            throw new IllegalStateException(String.format(Locale.getDefault(), "The fractions.length must equal values.length, fraction.length[%d], values.length[%d]", Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public PWESpriteAnimatorBuilder interpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        return this;
    }

    public PWESpriteAnimatorBuilder easeInOut(float... fArr) {
        interpolator(KeyFrameInterpolator.easeInOut(fArr));
        return this;
    }

    public PWESpriteAnimatorBuilder duration(long j) {
        this.duration = j;
        return this;
    }

    public PWESpriteAnimatorBuilder repeatCount(int i) {
        this.repeatCount = i;
        return this;
    }

    public PWESpriteAnimatorBuilder startFrame(int i) {
        if (i < 0) {
            Log.w(TAG, "startFrame should always be non-negative");
            i = 0;
        }
        this.startFrame = i;
        return this;
    }

    public ObjectAnimator build() {
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[this.fds.size()];
        Iterator<Map.Entry<String, FrameData>> it = this.fds.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            FrameData value = it.next().getValue();
            Keyframe[] keyframeArr = new Keyframe[value.fractions.length];
            float[] fArr = value.fractions;
            int i2 = this.startFrame;
            float f2 = fArr[i2];
            while (i2 < this.startFrame + value.values.length) {
                int i3 = i2 - this.startFrame;
                int length = i2 % value.values.length;
                float f3 = fArr[length] - f2;
                if (f3 < 0.0f) {
                    f3 += fArr[fArr.length - 1];
                }
                if (value instanceof IntFrameData) {
                    keyframeArr[i3] = Keyframe.ofInt(f3, ((Integer) value.values[length]).intValue());
                } else if (value instanceof FloatFrameData) {
                    keyframeArr[i3] = Keyframe.ofFloat(f3, ((Float) value.values[length]).floatValue());
                } else {
                    keyframeArr[i3] = Keyframe.ofObject(f3, value.values[length]);
                }
                i2++;
            }
            propertyValuesHolderArr[i] = PropertyValuesHolder.ofKeyframe(value.property, keyframeArr);
            i++;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.sprite, propertyValuesHolderArr);
        objectAnimatorOfPropertyValuesHolder.setDuration(this.duration);
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(this.repeatCount);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(this.interpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
