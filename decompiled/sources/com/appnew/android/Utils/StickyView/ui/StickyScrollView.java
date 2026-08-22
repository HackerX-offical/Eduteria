package com.appnew.android.Utils.StickyView.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import com.appnew.android.R;
import com.appnew.android.Utils.StickyView.provider.ResourceProvider;
import com.appnew.android.Utils.StickyView.provider.ScreenInfoProvider;
import com.appnew.android.Utils.StickyView.ui.interfaces.IScrollViewListener;
import com.appnew.android.Utils.StickyView.ui.presentation.IStickyScrollPresentation;
import com.appnew.android.Utils.StickyView.ui.presenter.StickyScrollPresenter;

/* JADX INFO: loaded from: classes6.dex */
public class StickyScrollView extends ScrollView implements IStickyScrollPresentation {
    private static final String SCROLL_STATE = "scroll_state";
    private static final String SUPER_STATE = "super_state";
    private StickyScrollPresenter mStickyScrollPresenter;
    private IScrollViewListener scrollViewListener;
    private View stickyFooterView;
    private View stickyHeaderView;

    public StickyScrollView(Context context) {
        this(context, null);
    }

    public StickyScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StickyScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mStickyScrollPresenter = new StickyScrollPresenter(this, new ScreenInfoProvider(context), new ResourceProvider(context, attrs, R.styleable.StickyScrollView));
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appnew.android.Utils.StickyView.ui.StickyScrollView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                StickyScrollView.this.mStickyScrollPresenter.onGlobalLayoutChange(1, 0);
                StickyScrollView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        View view = this.stickyFooterView;
        if (view != null && !changed) {
            this.mStickyScrollPresenter.recomputeFooterLocation(getRelativeTop(view));
        }
        View view2 = this.stickyHeaderView;
        if (view2 != null) {
            this.mStickyScrollPresenter.recomputeHeaderLocation(view2.getTop());
        }
    }

    private int getRelativeTop(View myView) {
        if (myView.getParent() == myView.getRootView()) {
            return myView.getTop();
        }
        return myView.getTop() + getRelativeTop((View) myView.getParent());
    }

    @Override // com.appnew.android.Utils.StickyView.ui.presentation.IStickyScrollPresentation
    public void initHeaderView(int id) {
        View viewFindViewById = findViewById(id);
        this.stickyHeaderView = viewFindViewById;
        StickyScrollPresenter stickyScrollPresenter = this.mStickyScrollPresenter;
        if (stickyScrollPresenter == null || viewFindViewById == null) {
            return;
        }
        stickyScrollPresenter.initStickyHeader(viewFindViewById.getTop());
    }

    @Override // com.appnew.android.Utils.StickyView.ui.presentation.IStickyScrollPresentation
    public void initFooterView(int id) {
        View viewFindViewById = findViewById(id);
        this.stickyFooterView = viewFindViewById;
        StickyScrollPresenter stickyScrollPresenter = this.mStickyScrollPresenter;
        if (stickyScrollPresenter == null || viewFindViewById == null) {
            return;
        }
        stickyScrollPresenter.initStickyFooter(viewFindViewById.getMeasuredHeight(), getRelativeTop(this.stickyFooterView));
    }

    @Override // com.appnew.android.Utils.StickyView.ui.presentation.IStickyScrollPresentation
    public void freeHeader() {
        View view = this.stickyHeaderView;
        if (view != null) {
            view.setTranslationY(0.0f);
            PropertySetter.setTranslationZ(this.stickyHeaderView, 0.0f);
        }
    }

    @Override // com.appnew.android.Utils.StickyView.ui.presentation.IStickyScrollPresentation
    public void freeFooter() {
        View view = this.stickyFooterView;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // com.appnew.android.Utils.StickyView.ui.presentation.IStickyScrollPresentation
    public void stickHeader(int translationY) {
        View view = this.stickyHeaderView;
        if (view != null) {
            view.setTranslationY(translationY);
            PropertySetter.setTranslationZ(this.stickyHeaderView, 1.0f);
        }
    }

    @Override // com.appnew.android.Utils.StickyView.ui.presentation.IStickyScrollPresentation
    public void stickFooter(int translationY) {
        View view = this.stickyFooterView;
        if (view != null) {
            view.setTranslationY(translationY);
        }
    }

    @Override // com.appnew.android.Utils.StickyView.ui.presentation.IStickyScrollPresentation
    public int getCurrentScrollYPos() {
        return getScrollY();
    }

    @Override // android.view.View
    protected void onScrollChanged(int mScrollX, int mScrollY, int oldX, int oldY) {
        super.onScrollChanged(mScrollX, mScrollY, oldX, oldY);
        this.mStickyScrollPresenter.onScroll(mScrollY);
        IScrollViewListener iScrollViewListener = this.scrollViewListener;
        if (iScrollViewListener != null) {
            iScrollViewListener.onScrollChanged(mScrollX, mScrollY, oldX, oldY);
        }
    }

    public IScrollViewListener getScrollViewListener() {
        return this.scrollViewListener;
    }

    public void setScrollViewListener(IScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    public boolean isFooterSticky() {
        return this.mStickyScrollPresenter.isFooterSticky();
    }

    public boolean isHeaderSticky() {
        return this.mStickyScrollPresenter.isHeaderSticky();
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        IScrollViewListener iScrollViewListener = this.scrollViewListener;
        if (iScrollViewListener != null) {
            iScrollViewListener.onScrollStopped(clampedY);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE, super.onSaveInstanceState());
        bundle.putBoolean(SCROLL_STATE, this.mStickyScrollPresenter.mScrolled);
        return bundle;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.mStickyScrollPresenter.mScrolled = bundle.getBoolean(SCROLL_STATE);
            state = bundle.getParcelable(SUPER_STATE);
        }
        super.onRestoreInstanceState(state);
    }
}
