package easypay.appinvoke.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;
import java.util.Locale;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes9.dex */
public class OtpEditText extends AppCompatEditText {
    private static final String TAG = "OtpEditText";
    private boolean isActive;
    protected boolean mActivateError;
    protected float mAllowedNumChars;
    protected boolean mAnimateOnError;
    protected boolean mAnimateOnInput;
    protected Drawable mCharBackground;
    protected float[] mCharBottom;
    private float[] mCharDrawSize;
    protected Paint mCharPaint;
    protected float mCharSize;
    protected float mCharsSpace;
    protected View.OnClickListener mClickListener;
    protected int mErrorAnimationType;
    protected boolean mHasError;
    protected int mInputAnimationType;
    protected boolean mIsCharInSquare;
    protected Paint mLastCharPaint;
    protected RectF[] mLineCoords;
    protected int mLineErrorTextColor;
    protected int mLineFocusedColor;
    protected int mLineNextCharColor;
    protected int mLineUnFocusedColor;
    protected Paint mLinesPaint;
    protected View.OnLongClickListener mLongClickListener;
    protected String mMask;
    protected StringBuilder mMaskChars;
    protected int mMaxCharLength;
    protected OnOtpEnteredListener mOnPinEnteredListener;
    protected OnTextChangedListener mOnTextChangedListener;
    protected ColorStateList mOriginalTextColors;
    protected int mOtpErrorColor;
    protected float mStrokeLineSelectedWidth;
    protected float mStrokeLineWidth;
    protected float mTextBottomLinePadding;
    protected Rect mTextHeight;

    public interface OnOtpEnteredListener {
        void onOtpCompleted(CharSequence charSequence);
    }

    public interface OnTextChangedListener {
        void onTextChanged();

        void onTextPasted();
    }

    public OtpEditText(Context context) {
        super(context);
        this.mMaxCharLength = 6;
        this.mTextHeight = new Rect();
        this.mIsCharInSquare = false;
        this.mMask = null;
        this.mMaskChars = null;
        this.mInputAnimationType = 0;
        this.mErrorAnimationType = 0;
        this.mCharsSpace = 24.0f;
        this.mAllowedNumChars = 6.0f;
        this.mTextBottomLinePadding = 8.0f;
        this.mOnPinEnteredListener = null;
        this.mOnTextChangedListener = null;
        this.mStrokeLineWidth = 1.0f;
        this.mStrokeLineSelectedWidth = 2.0f;
        this.mAnimateOnInput = false;
        this.mAnimateOnError = false;
        this.mHasError = false;
        this.mActivateError = false;
        this.mOtpErrorColor = 0;
        this.isActive = true;
    }

    public OtpEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxCharLength = 6;
        this.mTextHeight = new Rect();
        this.mIsCharInSquare = false;
        this.mMask = null;
        this.mMaskChars = null;
        this.mInputAnimationType = 0;
        this.mErrorAnimationType = 0;
        this.mCharsSpace = 24.0f;
        this.mAllowedNumChars = 6.0f;
        this.mTextBottomLinePadding = 8.0f;
        this.mOnPinEnteredListener = null;
        this.mOnTextChangedListener = null;
        this.mStrokeLineWidth = 1.0f;
        this.mStrokeLineSelectedWidth = 2.0f;
        this.mAnimateOnInput = false;
        this.mAnimateOnError = false;
        this.mHasError = false;
        this.mActivateError = false;
        this.mOtpErrorColor = 0;
        this.isActive = true;
        init(context, attributeSet);
    }

    public OtpEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxCharLength = 6;
        this.mTextHeight = new Rect();
        this.mIsCharInSquare = false;
        this.mMask = null;
        this.mMaskChars = null;
        this.mInputAnimationType = 0;
        this.mErrorAnimationType = 0;
        this.mCharsSpace = 24.0f;
        this.mAllowedNumChars = 6.0f;
        this.mTextBottomLinePadding = 8.0f;
        this.mOnPinEnteredListener = null;
        this.mOnTextChangedListener = null;
        this.mStrokeLineWidth = 1.0f;
        this.mStrokeLineSelectedWidth = 2.0f;
        this.mAnimateOnInput = false;
        this.mAnimateOnError = false;
        this.mHasError = false;
        this.mActivateError = false;
        this.mOtpErrorColor = 0;
        this.isActive = true;
        init(context, attributeSet);
    }

    public OtpEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.mMaxCharLength = 6;
        this.mTextHeight = new Rect();
        this.mIsCharInSquare = false;
        this.mMask = null;
        this.mMaskChars = null;
        this.mInputAnimationType = 0;
        this.mErrorAnimationType = 0;
        this.mCharsSpace = 24.0f;
        this.mAllowedNumChars = 6.0f;
        this.mTextBottomLinePadding = 8.0f;
        this.mOnPinEnteredListener = null;
        this.mOnTextChangedListener = null;
        this.mStrokeLineWidth = 1.0f;
        this.mStrokeLineSelectedWidth = 2.0f;
        this.mAnimateOnInput = false;
        this.mAnimateOnError = false;
        this.mHasError = false;
        this.mActivateError = false;
        this.mOtpErrorColor = 0;
        this.isActive = true;
        init(context, attributeSet);
    }

    public void setMaxLength(int i) {
        this.mMaxCharLength = i;
        float f2 = i;
        this.mAllowedNumChars = f2;
        this.mCharDrawSize = new float[(int) f2];
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        setText((CharSequence) null);
        invalidate();
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }

    private void init(Context context, AttributeSet attributeSet) {
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mStrokeLineWidth *= f2;
        this.mStrokeLineSelectedWidth *= f2;
        this.mCharsSpace *= f2;
        this.mTextBottomLinePadding = f2 * this.mTextBottomLinePadding;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OtpEditText, 0, 0);
        try {
            TypedValue typedValue = new TypedValue();
            typedArrayObtainStyledAttributes.getValue(R.styleable.OtpEditText_otpInputAnimStyle, typedValue);
            this.mInputAnimationType = typedValue.data;
            typedArrayObtainStyledAttributes.getValue(R.styleable.OtpEditText_otpErrorAnimStyle, typedValue);
            this.mErrorAnimationType = typedValue.data;
            this.mStrokeLineWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpStrokeLineHeight, this.mStrokeLineWidth);
            this.mStrokeLineSelectedWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpStrokeLineSelectedHeight, this.mStrokeLineSelectedWidth);
            this.mCharsSpace = typedArrayObtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpCharacterSpacing, this.mCharsSpace);
            this.mTextBottomLinePadding = typedArrayObtainStyledAttributes.getDimension(R.styleable.OtpEditText_otpTextBottomLinePadding, this.mTextBottomLinePadding);
            this.mIsCharInSquare = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OtpEditText_otpBackgroundIsSquare, this.mIsCharInSquare);
            this.mCharBackground = typedArrayObtainStyledAttributes.getDrawable(R.styleable.OtpEditText_otpBackgroundDrawable);
            this.mOtpErrorColor = typedArrayObtainStyledAttributes.getColor(R.styleable.OtpEditText_otpErrorTextColor, -7829368);
            this.mLineErrorTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineErrorColor, getTextColors().getColorForState(new int[]{android.R.attr.state_active}, Color.parseColor("#fd5c5c")));
            this.mLineFocusedColor = typedArrayObtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineFocusedColor, getTextColors().getColorForState(new int[]{android.R.attr.state_focused}, -12303292));
            this.mLineNextCharColor = typedArrayObtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineNextCharColor, getTextColors().getColorForState(new int[]{android.R.attr.state_focused}, -12303292));
            this.mLineUnFocusedColor = typedArrayObtainStyledAttributes.getColor(R.styleable.OtpEditText_otpLineUnFocusedColor, getTextColors().getColorForState(new int[]{android.R.attr.state_active}, -7829368));
            typedArrayObtainStyledAttributes.recycle();
            this.mCharPaint = new Paint(getPaint());
            this.mLastCharPaint = new Paint(getPaint());
            Paint paint = new Paint(getPaint());
            this.mLinesPaint = paint;
            paint.setStrokeWidth(this.mStrokeLineWidth);
            setBackgroundResource(0);
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLength", 6);
            this.mMaxCharLength = attributeIntValue;
            float f3 = attributeIntValue;
            this.mAllowedNumChars = f3;
            this.mCharDrawSize = new float[(int) f3];
            super.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: easypay.appinvoke.widget.OtpEditText.1
                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode actionMode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                    return false;
                }
            });
            super.setOnClickListener(new View.OnClickListener() { // from class: easypay.appinvoke.widget.OtpEditText.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OtpEditText otpEditText = OtpEditText.this;
                    otpEditText.setSelection(otpEditText.getText().length());
                    if (OtpEditText.this.mClickListener != null) {
                        OtpEditText.this.mClickListener.onClick(view);
                    }
                }
            });
            super.setOnLongClickListener(new View.OnLongClickListener() { // from class: easypay.appinvoke.widget.OtpEditText.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    OtpEditText otpEditText = OtpEditText.this;
                    otpEditText.setSelection(otpEditText.getText().length());
                    if (OtpEditText.this.mLongClickListener == null) {
                        return false;
                    }
                    return OtpEditText.this.mLongClickListener.onLongClick(view);
                }
            });
            if ((getInputType() & 128) == 128 || (getInputType() & 16) == 16) {
                this.mMask = "●";
            }
            if (!TextUtils.isEmpty(this.mMask)) {
                this.mMaskChars = getMaskChars();
            }
            getPaint().getTextBounds("|", 0, 1, this.mTextHeight);
            this.mAnimateOnInput = this.mInputAnimationType > -1;
            this.mAnimateOnError = this.mErrorAnimationType > -1;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingStart;
        float f2;
        super.onSizeChanged(i, i2, i3, i4);
        ColorStateList textColors = getTextColors();
        this.mOriginalTextColors = textColors;
        if (textColors != null) {
            this.mLastCharPaint.setColor(textColors.getDefaultColor());
            this.mCharPaint.setColor(this.mOriginalTextColors.getDefaultColor());
        }
        int width = (getWidth() - ViewCompat.getPaddingEnd(this)) - ViewCompat.getPaddingStart(this);
        float f3 = this.mCharsSpace;
        if (f3 < 0.0f) {
            this.mCharSize = width / ((this.mAllowedNumChars * 2.0f) - 1.0f);
        } else {
            float f4 = this.mAllowedNumChars;
            this.mCharSize = ((width - (f3 * (f4 - 1.0f))) / f4) + convertDpToPixel(2);
        }
        float f5 = this.mAllowedNumChars;
        this.mLineCoords = new RectF[(int) f5];
        this.mCharBottom = new float[(int) f5];
        int height = getHeight() - getPaddingBottom();
        int i5 = 1;
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            paddingStart = (int) ((getWidth() - ViewCompat.getPaddingStart(this)) - this.mCharSize);
            i5 = -1;
        } else {
            paddingStart = ViewCompat.getPaddingStart(this) + convertDpToPixel(2);
        }
        for (int i6 = 0; i6 < this.mAllowedNumChars; i6++) {
            float f6 = paddingStart;
            float f7 = height;
            this.mLineCoords[i6] = new RectF(f6, f7, this.mCharSize + f6, f7);
            if (this.mCharBackground != null) {
                if (this.mIsCharInSquare) {
                    this.mLineCoords[i6].top = getPaddingTop();
                    RectF rectF = this.mLineCoords[i6];
                    rectF.right = rectF.height() + f6;
                } else {
                    this.mLineCoords[i6].top -= this.mTextHeight.height() + (this.mTextBottomLinePadding * 2.0f);
                }
            }
            float f8 = this.mCharsSpace;
            if (f8 < 0.0f) {
                f2 = f6 + (i5 * this.mCharSize * 2.0f);
            } else {
                f2 = f6 + (i5 * (this.mCharSize + f8));
            }
            paddingStart = (int) f2;
            this.mCharBottom[i6] = this.mLineCoords[i6].bottom - this.mTextBottomLinePadding;
        }
    }

    private int convertDpToPixel(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getApplicationContext().getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() is not allowed.");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas canvas2;
        CharSequence fullText = getFullText();
        int length = fullText.length();
        float[] fArr = this.mCharDrawSize;
        if (length > fArr.length) {
            length = fArr.length;
        }
        int i = length;
        getPaint().getTextWidths(fullText, 0, i, this.mCharDrawSize);
        int i2 = 0;
        while (i2 < this.mAllowedNumChars) {
            if (this.mCharBackground != null) {
                updateDrawableState(i2 < i, i2 == i);
                this.mCharBackground.setBounds((int) this.mLineCoords[i2].left, (int) this.mLineCoords[i2].top, (int) this.mLineCoords[i2].right, (int) this.mLineCoords[i2].bottom);
                canvas2 = canvas;
                this.mCharBackground.draw(canvas2);
            } else {
                canvas2 = canvas;
            }
            float f2 = this.mLineCoords[i2].left + (this.mCharSize / 2.0f);
            if (i > i2) {
                if (!this.mAnimateOnInput || i2 != i - 1) {
                    canvas.drawText(fullText, i2, i2 + 1, f2 - (this.mCharDrawSize[i2] / 2.0f), this.mCharBottom[i2], this.mCharPaint);
                } else {
                    canvas2.drawText(fullText, i2, i2 + 1, f2 - (this.mCharDrawSize[i2] / 2.0f), this.mCharBottom[i2], this.mLastCharPaint);
                }
            }
            if (this.mCharBackground == null) {
                updateColorForLines(i2, i);
                canvas.drawLine(this.mLineCoords[i2].left, this.mLineCoords[i2].top, this.mLineCoords[i2].right, this.mLineCoords[i2].bottom, this.mLinesPaint);
            }
            i2++;
        }
    }

    private CharSequence getFullText() {
        if (this.mMask == null) {
            return getText();
        }
        return getMaskChars();
    }

    private StringBuilder getMaskChars() {
        if (this.mMaskChars == null) {
            this.mMaskChars = new StringBuilder();
        }
        int length = getText().length();
        while (this.mMaskChars.length() != length) {
            if (this.mMaskChars.length() < length) {
                this.mMaskChars.append(this.mMask);
            } else {
                this.mMaskChars.deleteCharAt(r1.length() - 1);
            }
        }
        return this.mMaskChars;
    }

    private void updateColorForLines(int i, int i2) {
        int i3;
        if (this.mHasError) {
            this.mLinesPaint.setColor(this.mLineErrorTextColor);
            return;
        }
        if (isFocused()) {
            this.mLinesPaint.setStrokeWidth(this.mStrokeLineSelectedWidth);
            if (i == i2 || (i2 == (i3 = this.mMaxCharLength) && i == i3 - 1 && this.isActive)) {
                this.mLinesPaint.setColor(this.mLineNextCharColor);
                return;
            } else if (i < i2) {
                this.mLinesPaint.setColor(this.mLineFocusedColor);
                return;
            } else {
                this.mLinesPaint.setColor(this.mLineUnFocusedColor);
                return;
            }
        }
        this.mLinesPaint.setStrokeWidth(this.mStrokeLineWidth);
        this.mLinesPaint.setColor(this.mLineUnFocusedColor);
    }

    protected void updateDrawableState(boolean z, boolean z2) {
        if (this.mHasError) {
            this.mCharBackground.setState(new int[]{android.R.attr.state_active});
            return;
        }
        if (isFocused()) {
            this.mCharBackground.setState(new int[]{android.R.attr.state_focused});
            if (z2) {
                this.mCharBackground.setState(new int[]{android.R.attr.state_focused, android.R.attr.state_selected});
                return;
            } else {
                if (z) {
                    this.mCharBackground.setState(new int[]{android.R.attr.state_focused, android.R.attr.state_checked});
                    return;
                }
                return;
            }
        }
        this.mCharBackground.setState(new int[]{-16842908});
    }

    public void setError(boolean z) {
        this.mHasError = z;
    }

    public boolean isError() {
        return this.mHasError;
    }

    public void focus() {
        requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 0);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        boolean zOnTextContextMenuItem = super.onTextContextMenuItem(i);
        if (i != 16908322) {
            return zOnTextContextMenuItem;
        }
        this.mOnTextChangedListener.onTextPasted();
        return zOnTextContextMenuItem;
    }

    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        this.mOnTextChangedListener = onTextChangedListener;
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        setError(false);
        OnTextChangedListener onTextChangedListener = this.mOnTextChangedListener;
        if (onTextChangedListener != null) {
            onTextChangedListener.onTextChanged();
        }
        if (this.mActivateError || this.mHasError) {
            this.mActivateError = false;
            this.mHasError = false;
            ColorStateList colorStateList = this.mOriginalTextColors;
            if (colorStateList != null) {
                this.mLastCharPaint.setColor(colorStateList.getDefaultColor());
                this.mCharPaint.setColor(this.mOriginalTextColors.getDefaultColor());
            }
        }
        if (this.mLineCoords == null || !this.mAnimateOnInput) {
            if (this.mOnPinEnteredListener == null || charSequence.length() != this.mMaxCharLength) {
                return;
            }
            this.mOnPinEnteredListener.onOtpCompleted(charSequence);
            return;
        }
        int i4 = this.mInputAnimationType;
        if (i4 == -1) {
            invalidate();
        } else if (i3 > i2) {
            if (i4 == 0) {
                animatePopIn();
            } else {
                animateBottomUp(charSequence, i);
            }
        }
    }

    private void animatePopIn() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, getPaint().getTextSize());
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: easypay.appinvoke.widget.OtpEditText.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                OtpEditText.this.mLastCharPaint.setTextSize(((Float) valueAnimator.getAnimatedValue()).floatValue());
                OtpEditText.this.invalidate();
            }
        });
        if (getText().length() == this.mMaxCharLength && this.mOnPinEnteredListener != null) {
            valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: easypay.appinvoke.widget.OtpEditText.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    OtpEditText.this.mOnPinEnteredListener.onOtpCompleted(OtpEditText.this.getText());
                }
            });
        }
        valueAnimatorOfFloat.start();
    }

    private void animateBottomUp(CharSequence charSequence, final int i) {
        this.mCharBottom[i] = this.mLineCoords[i].bottom - this.mTextBottomLinePadding;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mCharBottom[i] + getPaint().getTextSize(), this.mCharBottom[i]);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: easypay.appinvoke.widget.OtpEditText.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                OtpEditText.this.mCharBottom[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                OtpEditText.this.invalidate();
            }
        });
        this.mLastCharPaint.setAlpha(255);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 255);
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: easypay.appinvoke.widget.OtpEditText.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                OtpEditText.this.mLastCharPaint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        if (charSequence.length() == this.mMaxCharLength && this.mOnPinEnteredListener != null) {
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: easypay.appinvoke.widget.OtpEditText.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    OtpEditText.this.mOnPinEnteredListener.onOtpCompleted(OtpEditText.this.getText());
                }
            });
        }
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfInt);
        animatorSet.start();
    }

    public void animateText(boolean z) {
        this.mAnimateOnInput = z;
    }

    public void setOnPinEnteredListener(OnOtpEnteredListener onOtpEnteredListener) {
        this.mOnPinEnteredListener = onOtpEnteredListener;
    }

    @Override // android.widget.TextView
    public CharSequence getError() {
        return super.getError();
    }

    @Override // android.widget.TextView
    public void setError(CharSequence charSequence) {
        Log.e(TAG, "setError(CharSequence error) is not supported");
    }

    @Override // android.widget.TextView
    public void setError(CharSequence charSequence, Drawable drawable) {
        Log.e(TAG, "setError(CharSequence error, Drawable icon) is not supported");
    }

    public void activateOtpError() {
        this.mActivateError = true;
        this.mHasError = true;
        this.mCharPaint.setColor(this.mOtpErrorColor);
        this.mLastCharPaint.setColor(this.mOtpErrorColor);
        invalidate();
        if (this.mAnimateOnError) {
            if (this.mErrorAnimationType == 0) {
                animateShakeOnError();
            } else {
                animateBounceOnError();
            }
        }
    }

    private void animateShakeOnError() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "translationX", 0.0f, 25.0f, -25.0f, 25.0f, -25.0f, 15.0f, -15.0f, 6.0f, -6.0f, 0.0f));
        animatorSet.start();
    }

    private void animateBounceOnError() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(1000L);
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "translationY", 0.0f, 0.0f, -30.0f, 0.0f, -15.0f, 0.0f, 0.0f));
        animatorSet.start();
    }
}
