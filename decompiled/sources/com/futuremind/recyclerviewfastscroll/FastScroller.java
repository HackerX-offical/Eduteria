package com.futuremind.recyclerviewfastscroll;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.futuremind.recyclerviewfastscroll.RecyclerViewScrollListener;
import com.futuremind.recyclerviewfastscroll.viewprovider.DefaultScrollerViewProvider;
import com.futuremind.recyclerviewfastscroll.viewprovider.ScrollerViewProvider;
import com.hbb20.R;

/* JADX INFO: loaded from: classes7.dex */
public class FastScroller extends LinearLayout {
    private static final int STYLE_NONE = -1;
    private View bubble;
    private int bubbleColor;
    private int bubbleOffset;
    private int bubbleTextAppearance;
    private TextView bubbleTextView;
    private View handle;
    private int handleColor;
    private boolean manuallyChangingPosition;
    private int maxVisibility;
    private RecyclerView recyclerView;
    private final RecyclerViewScrollListener scrollListener;
    private int scrollerOrientation;
    private SectionTitleProvider titleProvider;
    private ScrollerViewProvider viewProvider;

    public FastScroller(Context context) {
        this(context, null);
    }

    public FastScroller(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FastScroller(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.scrollListener = new RecyclerViewScrollListener(this);
        setClipChildren(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.fastscroll__fastScroller, R.attr.fastscroll__style, 0);
        try {
            this.bubbleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.fastscroll__fastScroller_fastscroll__bubbleColor, -1);
            this.handleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.fastscroll__fastScroller_fastscroll__handleColor, -1);
            this.bubbleTextAppearance = typedArrayObtainStyledAttributes.getResourceId(R.styleable.fastscroll__fastScroller_fastscroll__bubbleTextAppearance, -1);
            typedArrayObtainStyledAttributes.recycle();
            this.maxVisibility = getVisibility();
            setViewProvider(new DefaultScrollerViewProvider());
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        if (recyclerView.getAdapter() instanceof SectionTitleProvider) {
            this.titleProvider = (SectionTitleProvider) recyclerView.getAdapter();
        }
        recyclerView.addOnScrollListener(this.scrollListener);
        invalidateVisibility();
        recyclerView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.futuremind.recyclerviewfastscroll.FastScroller.1
            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View parent, View child) {
                FastScroller.this.invalidateVisibility();
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View parent, View child) {
                FastScroller.this.invalidateVisibility();
            }
        });
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int orientation) {
        this.scrollerOrientation = orientation;
        super.setOrientation(orientation == 0 ? 1 : 0);
    }

    public void setBubbleColor(int color) {
        this.bubbleColor = color;
        invalidate();
    }

    public void setHandleColor(int color) {
        this.handleColor = color;
        invalidate();
    }

    public void setBubbleTextAppearance(int textAppearanceResourceId) {
        this.bubbleTextAppearance = textAppearanceResourceId;
        invalidate();
    }

    public void addScrollerListener(RecyclerViewScrollListener.ScrollerListener listener) {
        this.scrollListener.addScrollerListener(listener);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        initHandleMovement();
        this.bubbleOffset = this.viewProvider.getBubbleOffset();
        applyStyling();
        if (isInEditMode()) {
            return;
        }
        this.scrollListener.updateHandlePosition(this.recyclerView);
    }

    private void applyStyling() {
        int i = this.bubbleColor;
        if (i != -1) {
            setBackgroundTint(this.bubbleTextView, i);
        }
        int i2 = this.handleColor;
        if (i2 != -1) {
            setBackgroundTint(this.handle, i2);
        }
        int i3 = this.bubbleTextAppearance;
        if (i3 != -1) {
            TextViewCompat.setTextAppearance(this.bubbleTextView, i3);
        }
    }

    private void setBackgroundTint(View view, int color) {
        Drawable drawableWrap = DrawableCompat.wrap(view.getBackground());
        if (drawableWrap == null) {
            return;
        }
        DrawableCompat.setTint(drawableWrap.mutate(), color);
        Utils.setBackground(view, drawableWrap);
    }

    private void initHandleMovement() {
        this.handle.setOnTouchListener(new View.OnTouchListener() { // from class: com.futuremind.recyclerviewfastscroll.FastScroller.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                FastScroller.this.requestDisallowInterceptTouchEvent(true);
                if (event.getAction() == 0 || event.getAction() == 2) {
                    if (FastScroller.this.titleProvider != null && event.getAction() == 0) {
                        FastScroller.this.viewProvider.onHandleGrabbed();
                    }
                    FastScroller.this.manuallyChangingPosition = true;
                    float relativeTouchPosition = FastScroller.this.getRelativeTouchPosition(event);
                    FastScroller.this.setScrollerPosition(relativeTouchPosition);
                    FastScroller.this.setRecyclerViewPosition(relativeTouchPosition);
                    return true;
                }
                if (event.getAction() != 1) {
                    return false;
                }
                FastScroller.this.manuallyChangingPosition = false;
                if (FastScroller.this.titleProvider != null) {
                    FastScroller.this.viewProvider.onHandleReleased();
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getRelativeTouchPosition(MotionEvent event) {
        float rawX;
        int width;
        int width2;
        if (isVertical()) {
            rawX = event.getRawY() - Utils.getViewRawY(this.handle);
            width = getHeight();
            width2 = this.handle.getHeight();
        } else {
            rawX = event.getRawX() - Utils.getViewRawX(this.handle);
            width = getWidth();
            width2 = this.handle.getWidth();
        }
        return rawX / (width - width2);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        this.maxVisibility = visibility;
        invalidateVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateVisibility() {
        if (this.recyclerView.getAdapter() == null || this.recyclerView.getAdapter().getItemCount() == 0 || this.recyclerView.getChildAt(0) == null || isRecyclerViewNotScrollable() || this.maxVisibility != 0) {
            super.setVisibility(4);
        } else {
            super.setVisibility(0);
        }
    }

    private boolean isRecyclerViewNotScrollable() {
        return isVertical() ? this.recyclerView.getChildAt(0).getHeight() * this.recyclerView.getAdapter().getItemCount() <= this.recyclerView.getHeight() : this.recyclerView.getChildAt(0).getWidth() * this.recyclerView.getAdapter().getItemCount() <= this.recyclerView.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecyclerViewPosition(float relativePos) {
        TextView textView;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            return;
        }
        int itemCount = recyclerView.getAdapter().getItemCount();
        int valueInRange = (int) Utils.getValueInRange(0.0f, itemCount - 1, (int) (relativePos * itemCount));
        this.recyclerView.scrollToPosition(valueInRange);
        SectionTitleProvider sectionTitleProvider = this.titleProvider;
        if (sectionTitleProvider == null || (textView = this.bubbleTextView) == null) {
            return;
        }
        textView.setText(sectionTitleProvider.getSectionTitle(valueInRange));
    }

    void setScrollerPosition(float relativePos) {
        if (isVertical()) {
            this.bubble.setY(Utils.getValueInRange(0.0f, getHeight() - this.bubble.getHeight(), ((getHeight() - this.handle.getHeight()) * relativePos) + this.bubbleOffset));
            this.handle.setY(Utils.getValueInRange(0.0f, getHeight() - this.handle.getHeight(), relativePos * (getHeight() - this.handle.getHeight())));
        } else {
            this.bubble.setX(Utils.getValueInRange(0.0f, getWidth() - this.bubble.getWidth(), ((getWidth() - this.handle.getWidth()) * relativePos) + this.bubbleOffset));
            this.handle.setX(Utils.getValueInRange(0.0f, getWidth() - this.handle.getWidth(), relativePos * (getWidth() - this.handle.getWidth())));
        }
    }

    public boolean isVertical() {
        return this.scrollerOrientation == 1;
    }

    boolean shouldUpdateHandlePosition() {
        return (this.handle == null || this.manuallyChangingPosition || this.recyclerView.getChildCount() <= 0) ? false : true;
    }

    ScrollerViewProvider getViewProvider() {
        return this.viewProvider;
    }

    public void setViewProvider(ScrollerViewProvider viewProvider) {
        removeAllViews();
        this.viewProvider = viewProvider;
        viewProvider.setFastScroller(this);
        this.bubble = viewProvider.provideBubbleView(this);
        this.handle = viewProvider.provideHandleView(this);
        this.bubbleTextView = viewProvider.provideBubbleTextView();
        addView(this.bubble);
        addView(this.handle);
    }
}
