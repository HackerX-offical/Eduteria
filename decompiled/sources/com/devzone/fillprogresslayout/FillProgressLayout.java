package com.devzone.fillprogresslayout;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.clevertap.android.sdk.Constants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FillProgressLayout.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0013\u0018\u0000 z2\u00020\u0001:\u0001zB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010@\u001a\u00020*H\u0002J\u0012\u0010A\u001a\u00020*2\b\u0010B\u001a\u0004\u0018\u00010CH\u0014J\u0012\u0010D\u001a\u00020*2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0012\u0010E\u001a\u00020*2\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0010\u0010F\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\u000eH\u0002J\b\u0010H\u001a\u00020\tH\u0002J\b\u0010I\u001a\u00020\tH\u0002J\b\u0010J\u001a\u00020*H\u0002J\u001a\u0010K\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010L\u001a\u00020 2\u0006\u0010M\u001a\u00020\tH\u0002J\u0010\u0010N\u001a\u00020*2\u0006\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u00020*H\u0014J\u0012\u0010R\u001a\u00020*2\b\u0010B\u001a\u0004\u0018\u00010CH\u0014J(\u0010S\u001a\u00020*2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020\tH\u0014J\u000e\u0010X\u001a\u00020*2\u0006\u0010Y\u001a\u00020\fJ\u0012\u0010Z\u001a\u00020*2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\u0010\u0010]\u001a\u00020*2\u0006\u0010^\u001a\u00020\tH\u0016J\u0012\u0010_\u001a\u00020*2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\u0010\u0010`\u001a\u00020*2\u0006\u0010a\u001a\u00020\tH\u0016J\u000e\u0010b\u001a\u00020*2\u0006\u0010c\u001a\u00020\u001bJ+\u0010d\u001a\u00020*2#\u0010e\u001a\u001f\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*\u0018\u00010%J\u000e\u0010f\u001a\u00020*2\u0006\u0010g\u001a\u00020hJ\u000e\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\tJ\u000e\u0010k\u001a\u00020*2\u0006\u0010j\u001a\u00020\tJ\u000e\u0010l\u001a\u00020*2\u0006\u0010m\u001a\u00020 J\u0018\u0010n\u001a\u00020*2\u0006\u0010o\u001a\u00020\t2\b\b\u0002\u0010p\u001a\u00020 J\u000e\u0010q\u001a\u00020*2\u0006\u0010^\u001a\u00020\tJ\u000e\u0010r\u001a\u00020*2\u0006\u0010^\u001a\u00020\tJ\u0010\u0010s\u001a\u00020*2\b\b\u0001\u0010t\u001a\u000207J+\u0010u\u001a\u00020*2#\u0010e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020*\u0018\u00010%J\u000e\u0010v\u001a\u00020*2\u0006\u0010-\u001a\u00020 J\u000e\u0010w\u001a\u00020*2\u0006\u0010,\u001a\u00020 J\u0010\u0010x\u001a\u00020*2\u0006\u0010y\u001a\u00020\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R+\u0010$\u001a\u001f\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0013\u001a\u0004\u0018\u00010.@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010>\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020*\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006{"}, d2 = {"Lcom/devzone/fillprogresslayout/FillProgressLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animInterpolator", "Landroid/animation/TimeInterpolator;", "backRectF", "Landroid/graphics/RectF;", "backgroundPaint", "Landroid/graphics/Paint;", "clipPath", "Landroid/graphics/Path;", "<set-?>", "currentProgress", "getCurrentProgress", "()I", "defAnimInterpolator", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "defBackgroundColor", "defCornerRadius", "", "defDirection", "defDuration", "defDurationFactor", "defGradientMovement", "", "defIsRestart", "defIsRounded", "defProgressColor", "doOnProgressEnd", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "", "gradientMovement", "isRestart", "isRounded", "Landroid/animation/ValueAnimator;", "mAnimator", "getMAnimator", "()Landroid/animation/ValueAnimator;", "mBackgroundColor", "mCornerRadius", "mDirection", "mDurationFactor", "mGradientColors", "", "mGradientDirection", "mProgressColor", "maxProgress", "oldProgress", "progressPaint", "progressRectF", "progressUpdateListener", "progress", "applyGradientIfAny", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawNormalProgress", "drawRoundedProgress", "getGradientRect", "progressRect", "getProgress", "getSize", "initPaint", "initUI", "isValidRes", "res", "log", "logValue", "", "onDetachedFromWindow", "onDraw", "onSizeChanged", Constants.INAPP_WINDOW, "h", "oldw", "oldh", "setAnimationInterpolator", "interpolator", "setBackground", "background", "Landroid/graphics/drawable/Drawable;", "setBackgroundColor", "color", "setBackgroundDrawable", "setBackgroundResource", "resid", "setCornerRadius", Constants.KEY_RADIUS, "setDoOnProgressEnd", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDuration", TypedValues.TransitionType.S_DURATION, "", "setFillDirection", "direction", "setGradientDirection", "setGradientMovement", "gradMovement", "setProgress", "inputProgress", "animated", "setProgressBackgroundColor", "setProgressColor", "setProgressColors", "resIds", "setProgressUpdateListener", "setRoundedCorners", "shouldStartFromZero", "updateRect", "rectF", "Companion", "fillprogresslayout_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FillProgressLayout extends LinearLayout {
    public static final int BOTTOM_LEFT_TO_TOP_RIGHT = 7;
    public static final int BOTTOM_RIGHT_TO_TOP_LEFT = 6;
    public static final int BOTTOM_TO_TOP = 3;
    public static final int LEFT_TO_RIGHT = 0;
    public static final int RIGHT_TO_LEFT = 1;
    public static final int TOP_LEFT_TO_BOTTOM_RIGHT = 4;
    public static final int TOP_RIGHT_TO_BOTTOM_LEFT = 5;
    public static final int TOP_TO_BOTTOM = 2;
    private TimeInterpolator animInterpolator;
    private RectF backRectF;
    private Paint backgroundPaint;
    private final Path clipPath;
    private int currentProgress;
    private final AccelerateDecelerateInterpolator defAnimInterpolator;
    private final int defBackgroundColor;
    private final float defCornerRadius;
    private final int defDirection;
    private final int defDuration;
    private final int defDurationFactor;
    private final boolean defGradientMovement;
    private final boolean defIsRestart;
    private final boolean defIsRounded;
    private final int defProgressColor;
    private Function1<? super View, Unit> doOnProgressEnd;
    private boolean gradientMovement;
    private boolean isRestart;
    private boolean isRounded;
    private ValueAnimator mAnimator;
    private int mBackgroundColor;
    private float mCornerRadius;
    private int mDirection;
    private int mDurationFactor;
    private int[] mGradientColors;
    private int mGradientDirection;
    private int mProgressColor;
    private final int maxProgress;
    private int oldProgress;
    private Paint progressPaint;
    private RectF progressRectF;
    private Function1<? super Integer, Unit> progressUpdateListener;

    private final boolean isValidRes(int res) {
        return res != -1;
    }

    private final void log(String logValue) {
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable background) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int resid) {
    }

    public final ValueAnimator getMAnimator() {
        return this.mAnimator;
    }

    public final int getCurrentProgress() {
        return this.currentProgress;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FillProgressLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxProgress = 100;
        this.defDurationFactor = 20;
        this.defDuration = 100 * 20;
        this.defCornerRadius = 20.0f;
        this.defBackgroundColor = -3355444;
        this.defProgressColor = -7829368;
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        this.defAnimInterpolator = accelerateDecelerateInterpolator;
        this.isRounded = this.defIsRounded;
        this.isRestart = this.defIsRestart;
        this.gradientMovement = this.defGradientMovement;
        this.mDurationFactor = 20;
        int i = this.defDirection;
        this.mDirection = i;
        this.mCornerRadius = 20.0f;
        this.mBackgroundColor = -3355444;
        this.mProgressColor = -7829368;
        this.mGradientDirection = i;
        this.mGradientColors = new int[0];
        this.animInterpolator = accelerateDecelerateInterpolator;
        this.progressPaint = new Paint(1);
        this.backgroundPaint = new Paint(1);
        this.clipPath = new Path();
        this.progressRectF = new RectF();
        this.backRectF = new RectF();
        initUI(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FillProgressLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxProgress = 100;
        this.defDurationFactor = 20;
        this.defDuration = 100 * 20;
        this.defCornerRadius = 20.0f;
        this.defBackgroundColor = -3355444;
        this.defProgressColor = -7829368;
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        this.defAnimInterpolator = accelerateDecelerateInterpolator;
        this.isRounded = this.defIsRounded;
        this.isRestart = this.defIsRestart;
        this.gradientMovement = this.defGradientMovement;
        this.mDurationFactor = 20;
        int i = this.defDirection;
        this.mDirection = i;
        this.mCornerRadius = 20.0f;
        this.mBackgroundColor = -3355444;
        this.mProgressColor = -7829368;
        this.mGradientDirection = i;
        this.mGradientColors = new int[0];
        this.animInterpolator = accelerateDecelerateInterpolator;
        this.progressPaint = new Paint(1);
        this.backgroundPaint = new Paint(1);
        this.clipPath = new Path();
        this.progressRectF = new RectF();
        this.backRectF = new RectF();
        initUI(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FillProgressLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxProgress = 100;
        this.defDurationFactor = 20;
        this.defDuration = 100 * 20;
        this.defCornerRadius = 20.0f;
        this.defBackgroundColor = -3355444;
        this.defProgressColor = -7829368;
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        this.defAnimInterpolator = accelerateDecelerateInterpolator;
        this.isRounded = this.defIsRounded;
        this.isRestart = this.defIsRestart;
        this.gradientMovement = this.defGradientMovement;
        this.mDurationFactor = 20;
        int i2 = this.defDirection;
        this.mDirection = i2;
        this.mCornerRadius = 20.0f;
        this.mBackgroundColor = -3355444;
        this.mProgressColor = -7829368;
        this.mGradientDirection = i2;
        this.mGradientColors = new int[0];
        this.animInterpolator = accelerateDecelerateInterpolator;
        this.progressPaint = new Paint(1);
        this.backgroundPaint = new Paint(1);
        this.clipPath = new Path();
        this.progressRectF = new RectF();
        this.backRectF = new RectF();
        initUI(context, attributeSet);
    }

    private final void initUI(Context context, AttributeSet attrs) {
        setWillNotDraw(false);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.FillProgressLayout);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(it, R.styleable.FillProgressLayout)");
            if (typedArrayObtainStyledAttributes.length() > 0) {
                this.mBackgroundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.FillProgressLayout_fpl_backgroundColor, this.defBackgroundColor);
                this.mProgressColor = typedArrayObtainStyledAttributes.getColor(R.styleable.FillProgressLayout_fpl_progressColor, this.defProgressColor);
                shouldStartFromZero(typedArrayObtainStyledAttributes.getBoolean(R.styleable.FillProgressLayout_fpl_shouldRestart, this.defIsRestart));
                setCornerRadius(typedArrayObtainStyledAttributes.getFloat(R.styleable.FillProgressLayout_fpl_roundedCornerRadius, this.defCornerRadius));
                setRoundedCorners(typedArrayObtainStyledAttributes.getBoolean(R.styleable.FillProgressLayout_fpl_isRounded, this.defIsRounded));
                setDuration(typedArrayObtainStyledAttributes.getInt(R.styleable.FillProgressLayout_fpl_progressDuration, this.defDuration));
                setFillDirection(typedArrayObtainStyledAttributes.getInt(R.styleable.FillProgressLayout_fpl_progressDirection, this.defDirection));
                setProgress$default(this, typedArrayObtainStyledAttributes.getInt(R.styleable.FillProgressLayout_fpl_progress, getCurrentProgress()), false, 2, null);
                setGradientDirection(typedArrayObtainStyledAttributes.getInt(R.styleable.FillProgressLayout_fpl_gradientDirection, this.defDirection));
                setGradientMovement(typedArrayObtainStyledAttributes.getBoolean(R.styleable.FillProgressLayout_fpl_gradientMovement, this.defGradientMovement));
                try {
                    int[] intArray = typedArrayObtainStyledAttributes.getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(R.styleable.FillProgressLayout_fpl_gradientColors, 0));
                    Intrinsics.checkNotNullExpressionValue(intArray, "array.resources.getIntArray(colorsId)");
                    if (!(intArray.length == 0)) {
                        setProgressColors(intArray);
                    }
                } catch (Exception unused) {
                    log("Error setting Gradient colors! Use @array/colors or int array of R.color.colorName values");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        initPaint();
    }

    private final void initPaint() {
        Paint paint = this.backgroundPaint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.mBackgroundColor);
        Paint paint2 = this.progressPaint;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(this.mGradientColors.length == 0 ? this.mProgressColor : -16777216);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        float f2 = w;
        float f3 = h2;
        this.backRectF = new RectF(0.0f, 0.0f, f2, f3);
        RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
        this.progressRectF = rectF;
        rectF.bottom = f3;
        updateRect(this.progressRectF);
        if (this.isRounded) {
            Path path = this.clipPath;
            RectF rectF2 = this.backRectF;
            float f4 = this.mCornerRadius;
            path.addRoundRect(rectF2, f4, f4, Path.Direction.CW);
            this.clipPath.close();
        }
    }

    private final int getProgress() {
        return (getSize() * this.currentProgress) / 100;
    }

    private final int getSize() {
        int i = this.mDirection;
        return (i == 0 || i == 1) ? getWidth() : getHeight();
    }

    private final void updateRect(RectF rectF) {
        int i = this.mDirection;
        if (i == 0) {
            rectF.right = getProgress();
            return;
        }
        if (i == 1) {
            rectF.left = getSize() - getProgress();
        } else if (i == 2) {
            rectF.bottom = getProgress();
        } else {
            if (i != 3) {
                return;
            }
            rectF.top = getSize() - getProgress();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.isRounded) {
            drawRoundedProgress(canvas);
        } else {
            drawNormalProgress(canvas);
        }
        super.onDraw(canvas);
    }

    private final void drawNormalProgress(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        canvas.drawRect(this.backRectF, this.backgroundPaint);
        applyGradientIfAny();
        canvas.drawRect(this.progressRectF, this.progressPaint);
    }

    private final void drawRoundedProgress(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        canvas.save();
        RectF rectF = this.backRectF;
        float f2 = this.mCornerRadius;
        canvas.drawRoundRect(rectF, f2, f2, this.backgroundPaint);
        canvas.clipPath(this.clipPath);
        applyGradientIfAny();
        canvas.drawRect(this.progressRectF, this.progressPaint);
        canvas.restore();
    }

    private final void applyGradientIfAny() {
        if (this.mGradientColors.length == 0) {
            return;
        }
        RectF gradientRect = getGradientRect(this.gradientMovement ? this.progressRectF : this.backRectF);
        this.progressPaint.setShader(new LinearGradient(gradientRect.left, gradientRect.top, gradientRect.right, gradientRect.bottom, this.mGradientColors, (float[]) null, Shader.TileMode.MIRROR));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        clearAnimation();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.isRounded && canvas != null) {
            canvas.clipPath(this.clipPath);
        }
        super.dispatchDraw(canvas);
    }

    public static /* synthetic */ void setProgress$default(FillProgressLayout fillProgressLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        fillProgressLayout.setProgress(i, z);
    }

    public final void setProgress(final int inputProgress, boolean animated) {
        ValueAnimator valueAnimator;
        if (inputProgress < 0 || inputProgress > this.maxProgress) {
            return;
        }
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning() && (valueAnimator = this.mAnimator) != null) {
            valueAnimator.end();
        }
        clearAnimation();
        if (animated) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.oldProgress, inputProgress);
            valueAnimatorOfInt.setInterpolator(this.animInterpolator);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.devzone.fillprogresslayout.FillProgressLayout$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    FillProgressLayout.m11949setProgress$lambda7$lambda5(this.f$0, valueAnimator3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(valueAnimatorOfInt, "");
            valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.devzone.fillprogresslayout.FillProgressLayout$setProgress$lambda-7$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    Function1 function1 = this.this$0.doOnProgressEnd;
                    if (function1 != null) {
                        function1.invoke(this.this$0);
                    }
                    if (this.this$0.isRestart) {
                        return;
                    }
                    this.this$0.oldProgress = inputProgress;
                }
            });
            valueAnimatorOfInt.setDuration(Math.abs(inputProgress - this.oldProgress) * this.mDurationFactor);
            Unit unit = Unit.INSTANCE;
            this.mAnimator = valueAnimatorOfInt;
            if (valueAnimatorOfInt == null) {
                return;
            }
            valueAnimatorOfInt.start();
            return;
        }
        this.currentProgress = inputProgress;
        Function1<? super Integer, Unit> function1 = this.progressUpdateListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(inputProgress));
        }
        if (!this.isRestart) {
            this.oldProgress = inputProgress;
        }
        updateRect(this.progressRectF);
        ViewCompat.postInvalidateOnAnimation(this);
        Function1<? super View, Unit> function12 = this.doOnProgressEnd;
        if (function12 == null) {
            return;
        }
        function12.invoke(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setProgress$lambda-7$lambda-5, reason: not valid java name */
    public static final void m11949setProgress$lambda7$lambda5(FillProgressLayout this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        this$0.currentProgress = ((Integer) animatedValue).intValue();
        Function1<? super Integer, Unit> function1 = this$0.progressUpdateListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this$0.getCurrentProgress()));
        }
        this$0.updateRect(this$0.progressRectF);
        ViewCompat.postInvalidateOnAnimation(this$0);
    }

    public final void setAnimationInterpolator(TimeInterpolator interpolator) {
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        this.animInterpolator = interpolator;
    }

    public final void setProgressBackgroundColor(int color) {
        try {
            color = ContextCompat.getColor(getContext(), color);
        } catch (Exception unused) {
        }
        this.mBackgroundColor = color;
        initPaint();
    }

    public final void setProgressColor(int color) {
        try {
            color = ContextCompat.getColor(getContext(), color);
        } catch (Exception unused) {
        }
        this.mProgressColor = color;
        initPaint();
    }

    public final void setCornerRadius(float radius) {
        if (0.0f > radius || radius > this.maxProgress) {
            return;
        }
        setRoundedCorners(true);
        this.mCornerRadius = radius;
    }

    public final void setRoundedCorners(boolean isRounded) {
        this.isRounded = isRounded;
    }

    public final void setGradientMovement(boolean gradMovement) {
        this.gradientMovement = gradMovement;
    }

    public final void setDuration(long duration) {
        if (((int) duration) == 0 || duration < 0) {
            return;
        }
        this.mDurationFactor = (int) (duration / ((long) 100));
    }

    public final void shouldStartFromZero(boolean isRestart) {
        this.isRestart = isRestart;
    }

    public final void setFillDirection(int direction) {
        if (direction < 0 || direction > 3) {
            direction = this.defDirection;
        }
        this.mDirection = direction;
    }

    public final void setGradientDirection(int direction) {
        if (direction < 0 || direction > 7) {
            direction = this.defDirection;
        }
        this.mGradientDirection = direction;
    }

    public final void setDoOnProgressEnd(Function1<? super View, Unit> listener) {
        this.doOnProgressEnd = listener;
    }

    public final void setProgressUpdateListener(Function1<? super Integer, Unit> listener) {
        this.progressUpdateListener = listener;
    }

    private final RectF getGradientRect(RectF progressRect) {
        RectF rectF = new RectF(progressRect);
        switch (this.mGradientDirection) {
            case 0:
                rectF.left = progressRect.left;
                rectF.top = progressRect.centerY();
                rectF.right = progressRect.right;
                rectF.bottom = progressRect.centerY();
                break;
            case 1:
                rectF.left = progressRect.right;
                rectF.top = progressRect.centerY();
                rectF.right = progressRect.left;
                rectF.bottom = progressRect.centerY();
                break;
            case 2:
                rectF.left = progressRect.centerX();
                rectF.top = progressRect.top;
                rectF.right = progressRect.centerX();
                rectF.bottom = progressRect.bottom;
                break;
            case 3:
                rectF.left = progressRect.centerX();
                rectF.top = progressRect.bottom;
                rectF.right = progressRect.centerX();
                rectF.bottom = progressRect.top;
                break;
            case 4:
                rectF.left = progressRect.left;
                rectF.top = progressRect.top;
                rectF.right = progressRect.right;
                rectF.bottom = progressRect.bottom;
                break;
            case 5:
                rectF.left = progressRect.right;
                rectF.top = progressRect.top;
                rectF.right = progressRect.left;
                rectF.bottom = progressRect.bottom;
                break;
            case 6:
                rectF.left = progressRect.right;
                rectF.top = progressRect.bottom;
                rectF.right = progressRect.left;
                rectF.bottom = progressRect.top;
                break;
            case 7:
                rectF.left = progressRect.left;
                rectF.top = progressRect.bottom;
                rectF.right = progressRect.right;
                rectF.bottom = progressRect.top;
                break;
        }
        return rectF;
    }

    public final void setProgressColors(int[] resIds) {
        Intrinsics.checkNotNullParameter(resIds, "resIds");
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (int i2 : resIds) {
                if (isValidRes(i2)) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            ArrayList arrayList2 = arrayList;
            this.mGradientColors = new int[arrayList2.size()];
            for (Object obj : arrayList2) {
                int i3 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int iIntValue = ((Number) obj).intValue();
                int[] iArr = this.mGradientColors;
                try {
                    iIntValue = ContextCompat.getColor(getContext(), iIntValue);
                } catch (Exception unused) {
                }
                iArr[i] = iIntValue;
                i = i3;
            }
            initPaint();
        } catch (Exception unused2) {
            log("Cannot use current color values!! Use integer array of R.color.colorName values");
        }
    }
}
