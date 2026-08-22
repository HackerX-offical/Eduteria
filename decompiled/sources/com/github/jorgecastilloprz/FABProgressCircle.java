package com.github.jorgecastilloprz;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.github.jorgecastilloprz.completefab.CompleteFABListener;
import com.github.jorgecastilloprz.completefab.CompleteFABView;
import com.github.jorgecastilloprz.library.R;
import com.github.jorgecastilloprz.listeners.FABProgressListener;
import com.github.jorgecastilloprz.progressarc.ArcListener;
import com.github.jorgecastilloprz.progressarc.ProgressArcView;
import com.github.jorgecastilloprz.utils.LibraryUtils;

/* JADX INFO: loaded from: classes7.dex */
public class FABProgressCircle extends FrameLayout implements ArcListener, CompleteFABListener {
    private final int SIZE_MINI;
    private final int SIZE_NORMAL;
    private int arcColor;
    private int arcWidth;
    private int circleSize;
    private CompleteFABView completeFABView;
    private Drawable completeIconDrawable;
    private FABProgressListener listener;
    private ProgressArcView progressArc;
    private boolean reusable;
    private boolean roundedStroke;
    private boolean viewsAdded;

    public FABProgressCircle(Context context) {
        super(context);
        this.SIZE_NORMAL = 1;
        this.SIZE_MINI = 2;
        init(null);
    }

    public FABProgressCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.SIZE_NORMAL = 1;
        this.SIZE_MINI = 2;
        init(attributeSet);
    }

    public FABProgressCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.SIZE_NORMAL = 1;
        this.SIZE_MINI = 2;
        init(attributeSet);
    }

    public FABProgressCircle(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.SIZE_NORMAL = 1;
        this.SIZE_MINI = 2;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        setupInitialAttributes(attributeSet);
    }

    private void setupInitialAttributes(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = getAttributes(attributeSet);
            try {
                this.arcColor = attributes.getColor(R.styleable.FABProgressCircle_arcColor, getResources().getColor(R.color.fab_orange_dark));
                this.arcWidth = attributes.getDimensionPixelSize(R.styleable.FABProgressCircle_arcWidth, getResources().getDimensionPixelSize(R.dimen.progress_arc_stroke_width));
                this.completeIconDrawable = attributes.getDrawable(R.styleable.FABProgressCircle_finalIcon);
                this.circleSize = attributes.getInt(R.styleable.FABProgressCircle_circleSize, 1);
                this.roundedStroke = attributes.getBoolean(R.styleable.FABProgressCircle_roundedStroke, false);
                this.reusable = attributes.getBoolean(R.styleable.FABProgressCircle_reusable, false);
            } finally {
                attributes.recycle();
            }
        }
    }

    private TypedArray getAttributes(AttributeSet attributeSet) {
        return getContext().obtainStyledAttributes(attributeSet, R.styleable.FABProgressCircle, 0, 0);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        checkChildCount();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.viewsAdded) {
            return;
        }
        addArcView();
        setupFab();
        this.viewsAdded = true;
    }

    private void addArcView() {
        setClipChildren(false);
        ProgressArcView progressArcView = new ProgressArcView(getContext(), this.arcColor, this.arcWidth, this.roundedStroke);
        this.progressArc = progressArcView;
        progressArcView.setInternalListener(this);
        addView(this.progressArc, new FrameLayout.LayoutParams(getFabDimension() + this.arcWidth, getFabDimension() + this.arcWidth, 17));
    }

    private void setupFab() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getChildAt(0).getLayoutParams();
        layoutParams.gravity = 17;
        if (LibraryUtils.isAFutureSimpleFAB(getChildAt(0))) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.futuresimple_fab_shadow_offset);
        }
    }

    private void checkChildCount() {
        if (getChildCount() != 1) {
            throw new IllegalStateException(getResources().getString(R.string.child_count_error));
        }
    }

    public void attachListener(FABProgressListener fABProgressListener) {
        this.listener = fABProgressListener;
    }

    public void show() {
        this.progressArc.show();
    }

    public void hide() {
        this.progressArc.stop();
    }

    public void beginFinalAnimation() {
        this.progressArc.requestCompleteAnimation();
    }

    @Override // com.github.jorgecastilloprz.progressarc.ArcListener
    public void onArcAnimationComplete() {
        displayColorTransformAnimation();
    }

    private void displayColorTransformAnimation() {
        addCompleteFabView();
        ViewCompat.setElevation(this.completeFABView, ViewCompat.getElevation(getChildAt(0)) + 1.0f);
        this.completeFABView.animate(this.progressArc.getScaleDownAnimator());
    }

    private void addCompleteFabView() {
        CompleteFABView completeFABView = new CompleteFABView(getContext(), this.completeIconDrawable, this.arcColor);
        this.completeFABView = completeFABView;
        completeFABView.attachListener(this);
        addView(this.completeFABView, new FrameLayout.LayoutParams(getFabDimension(), getFabDimension(), 17));
    }

    @Override // com.github.jorgecastilloprz.completefab.CompleteFABListener
    public void onCompleteFABAnimationEnd() {
        doReusableReset();
        FABProgressListener fABProgressListener = this.listener;
        if (fABProgressListener != null) {
            fABProgressListener.onFABProgressAnimationEnd();
        }
    }

    private void doReusableReset() {
        if (isReusable()) {
            this.progressArc.reset();
            this.completeFABView.reset();
        }
    }

    private boolean isReusable() {
        return this.reusable;
    }

    private int getFabDimension() {
        if (this.circleSize == 1) {
            return getResources().getDimensionPixelSize(R.dimen.fab_size_normal);
        }
        return getResources().getDimensionPixelSize(R.dimen.fab_size_mini);
    }
}
