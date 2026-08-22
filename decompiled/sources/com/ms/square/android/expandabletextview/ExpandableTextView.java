package com.ms.square.android.expandabletextview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes9.dex */
public class ExpandableTextView extends LinearLayout implements View.OnClickListener {
    private static final float DEFAULT_ANIM_ALPHA_START = 0.7f;
    private static final int DEFAULT_ANIM_DURATION = 300;
    private static final int MAX_COLLAPSED_LINES = 8;
    private static final String TAG = "ExpandableTextView";
    private float mAnimAlphaStart;
    private boolean mAnimating;
    private int mAnimationDuration;
    protected ImageButton mButton;
    private Drawable mCollapseDrawable;
    private boolean mCollapsed;
    private int mCollapsedHeight;
    private SparseBooleanArray mCollapsedStatus;
    private Drawable mExpandDrawable;
    private OnExpandStateChangeListener mListener;
    private int mMarginBetweenTxtAndBottom;
    private int mMaxCollapsedLines;
    private int mPosition;
    private boolean mRelayout;
    private int mTextHeightWithMaxLines;
    protected TextView mTv;

    public interface OnExpandStateChangeListener {
        void onExpandStateChanged(TextView textView, boolean z);
    }

    private static boolean isPostHoneycomb() {
        return true;
    }

    private static boolean isPostLolipop() {
        return true;
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCollapsed = true;
        init(attributeSet);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCollapsed = true;
        init(attributeSet);
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
        }
        super.setOrientation(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ExpandCollapseAnimation expandCollapseAnimation;
        if (this.mButton.getVisibility() != 0) {
            return;
        }
        boolean z = this.mCollapsed;
        this.mCollapsed = !z;
        this.mButton.setImageDrawable(!z ? this.mExpandDrawable : this.mCollapseDrawable);
        SparseBooleanArray sparseBooleanArray = this.mCollapsedStatus;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(this.mPosition, this.mCollapsed);
        }
        this.mAnimating = true;
        if (this.mCollapsed) {
            expandCollapseAnimation = new ExpandCollapseAnimation(this, getHeight(), this.mCollapsedHeight);
        } else {
            expandCollapseAnimation = new ExpandCollapseAnimation(this, getHeight(), (getHeight() + this.mTextHeightWithMaxLines) - this.mTv.getHeight());
        }
        expandCollapseAnimation.setFillAfter(true);
        expandCollapseAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ms.square.android.expandabletextview.ExpandableTextView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                ExpandableTextView.applyAlphaAnimation(ExpandableTextView.this.mTv, ExpandableTextView.this.mAnimAlphaStart);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ExpandableTextView.this.clearAnimation();
                ExpandableTextView.this.mAnimating = false;
                if (ExpandableTextView.this.mListener != null) {
                    ExpandableTextView.this.mListener.onExpandStateChanged(ExpandableTextView.this.mTv, !ExpandableTextView.this.mCollapsed);
                }
            }
        });
        clearAnimation();
        startAnimation(expandCollapseAnimation);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mAnimating;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        findViews();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.mRelayout || getVisibility() == 8) {
            super.onMeasure(i, i2);
            return;
        }
        this.mRelayout = false;
        this.mButton.setVisibility(8);
        this.mTv.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(i, i2);
        if (this.mTv.getLineCount() <= this.mMaxCollapsedLines) {
            return;
        }
        this.mTextHeightWithMaxLines = getRealTextViewHeight(this.mTv);
        if (this.mCollapsed) {
            this.mTv.setMaxLines(this.mMaxCollapsedLines);
        }
        this.mButton.setVisibility(0);
        super.onMeasure(i, i2);
        if (this.mCollapsed) {
            this.mTv.post(new Runnable() { // from class: com.ms.square.android.expandabletextview.ExpandableTextView.2
                @Override // java.lang.Runnable
                public void run() {
                    ExpandableTextView expandableTextView = ExpandableTextView.this;
                    expandableTextView.mMarginBetweenTxtAndBottom = expandableTextView.getHeight() - ExpandableTextView.this.mTv.getHeight();
                }
            });
            this.mCollapsedHeight = getMeasuredHeight();
        }
    }

    public void setOnExpandStateChangeListener(OnExpandStateChangeListener onExpandStateChangeListener) {
        this.mListener = onExpandStateChangeListener;
    }

    public void setText(CharSequence charSequence) {
        this.mRelayout = true;
        this.mTv.setText(charSequence);
        setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void setText(CharSequence charSequence, SparseBooleanArray sparseBooleanArray, int i) {
        this.mCollapsedStatus = sparseBooleanArray;
        this.mPosition = i;
        boolean z = sparseBooleanArray.get(i, true);
        clearAnimation();
        this.mCollapsed = z;
        this.mButton.setImageDrawable(z ? this.mExpandDrawable : this.mCollapseDrawable);
        setText(charSequence);
        getLayoutParams().height = -2;
        requestLayout();
    }

    public CharSequence getText() {
        TextView textView = this.mTv;
        if (textView == null) {
            return "";
        }
        return textView.getText();
    }

    private void init(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ExpandableTextView);
        this.mMaxCollapsedLines = typedArrayObtainStyledAttributes.getInt(R.styleable.ExpandableTextView_maxCollapsedLines, 8);
        this.mAnimationDuration = typedArrayObtainStyledAttributes.getInt(R.styleable.ExpandableTextView_animDuration, 300);
        this.mAnimAlphaStart = typedArrayObtainStyledAttributes.getFloat(R.styleable.ExpandableTextView_animAlphaStart, 0.7f);
        this.mExpandDrawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ExpandableTextView_expandDrawable);
        this.mCollapseDrawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ExpandableTextView_collapseDrawable);
        if (this.mExpandDrawable == null) {
            this.mExpandDrawable = getDrawable(getContext(), R.drawable.ic_expand_small_holo_light);
        }
        if (this.mCollapseDrawable == null) {
            this.mCollapseDrawable = getDrawable(getContext(), R.drawable.ic_collapse_small_holo_light);
        }
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(1);
        setVisibility(8);
    }

    private void findViews() {
        TextView textView = (TextView) findViewById(R.id.expandable_text);
        this.mTv = textView;
        textView.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) findViewById(R.id.expand_collapse);
        this.mButton = imageButton;
        imageButton.setImageDrawable(this.mCollapsed ? this.mExpandDrawable : this.mCollapseDrawable);
        this.mButton.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void applyAlphaAnimation(View view, float f2) {
        if (isPostHoneycomb()) {
            view.setAlpha(f2);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f2);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private static Drawable getDrawable(Context context, int i) {
        Resources resources = context.getResources();
        if (isPostLolipop()) {
            return resources.getDrawable(i, context.getTheme());
        }
        return resources.getDrawable(i);
    }

    private static int getRealTextViewHeight(TextView textView) {
        return textView.getLayout().getLineTop(textView.getLineCount()) + textView.getCompoundPaddingTop() + textView.getCompoundPaddingBottom();
    }

    class ExpandCollapseAnimation extends Animation {
        private final int mEndHeight;
        private final int mStartHeight;
        private final View mTargetView;

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }

        public ExpandCollapseAnimation(View view, int i, int i2) {
            this.mTargetView = view;
            this.mStartHeight = i;
            this.mEndHeight = i2;
            setDuration(ExpandableTextView.this.mAnimationDuration);
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f2, Transformation transformation) {
            int i = this.mEndHeight;
            int i2 = (int) (((i - r0) * f2) + this.mStartHeight);
            ExpandableTextView.this.mTv.setMaxHeight(i2 - ExpandableTextView.this.mMarginBetweenTxtAndBottom);
            if (Float.compare(ExpandableTextView.this.mAnimAlphaStart, 1.0f) != 0) {
                ExpandableTextView.applyAlphaAnimation(ExpandableTextView.this.mTv, ExpandableTextView.this.mAnimAlphaStart + (f2 * (1.0f - ExpandableTextView.this.mAnimAlphaStart)));
            }
            this.mTargetView.getLayoutParams().height = i2;
            this.mTargetView.requestLayout();
        }

        @Override // android.view.animation.Animation
        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
        }
    }
}
