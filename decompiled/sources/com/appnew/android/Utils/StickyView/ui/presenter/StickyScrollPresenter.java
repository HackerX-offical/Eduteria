package com.appnew.android.Utils.StickyView.ui.presenter;

import com.appnew.android.Utils.StickyView.provider.interfaces.IResourceProvider;
import com.appnew.android.Utils.StickyView.provider.interfaces.IScreenInfoProvider;
import com.appnew.android.Utils.StickyView.ui.presentation.IStickyScrollPresentation;

/* JADX INFO: loaded from: classes6.dex */
public class StickyScrollPresenter {
    private int mDeviceHeight;
    private boolean mIsFooterSticky;
    private boolean mIsHeaderSticky;
    public boolean mScrolled;
    private int mStickyFooterHeight;
    private int mStickyFooterInitialLocation;
    private int mStickyFooterInitialTranslation;
    private int mStickyHeaderInitialLocation;
    private IStickyScrollPresentation mStickyScrollPresentation;
    private final IResourceProvider mTypedArrayResourceProvider;

    public StickyScrollPresenter(IStickyScrollPresentation stickyScrollPresentation, IScreenInfoProvider screenInfoProvider, IResourceProvider typedArrayResourceProvider) {
        this.mDeviceHeight = screenInfoProvider.getScreenHeight();
        this.mTypedArrayResourceProvider = typedArrayResourceProvider;
        this.mStickyScrollPresentation = stickyScrollPresentation;
    }

    public void onGlobalLayoutChange(int headerRes, int footerRes) {
        int resourceId = this.mTypedArrayResourceProvider.getResourceId(headerRes);
        if (resourceId != 0) {
            this.mStickyScrollPresentation.initHeaderView(resourceId);
        }
        int resourceId2 = this.mTypedArrayResourceProvider.getResourceId(footerRes);
        if (resourceId2 != 0) {
            this.mStickyScrollPresentation.initFooterView(resourceId2);
        }
        this.mTypedArrayResourceProvider.recycle();
    }

    public void initStickyFooter(int measuredHeight, int initialStickyFooterLocation) {
        this.mStickyFooterHeight = measuredHeight;
        this.mStickyFooterInitialLocation = initialStickyFooterLocation;
        int i = this.mDeviceHeight;
        int i2 = (i - initialStickyFooterLocation) - measuredHeight;
        this.mStickyFooterInitialTranslation = i2;
        if (initialStickyFooterLocation > i - measuredHeight) {
            this.mStickyScrollPresentation.stickFooter(i2);
            this.mIsFooterSticky = true;
        }
    }

    public void initStickyHeader(int headerTop) {
        this.mStickyHeaderInitialLocation = headerTop;
    }

    public void onScroll(int scrollY) {
        this.mScrolled = true;
        handleFooterStickiness(scrollY);
        handleHeaderStickiness(scrollY);
    }

    private void handleFooterStickiness(int scrollY) {
        if (scrollY > (this.mStickyFooterInitialLocation - this.mDeviceHeight) + this.mStickyFooterHeight) {
            this.mStickyScrollPresentation.freeFooter();
            this.mIsFooterSticky = false;
        } else {
            this.mStickyScrollPresentation.stickFooter(this.mStickyFooterInitialTranslation + scrollY);
            this.mIsFooterSticky = true;
        }
    }

    private void handleHeaderStickiness(int scrollY) {
        int i = this.mStickyHeaderInitialLocation;
        if (scrollY > i) {
            this.mStickyScrollPresentation.stickHeader(scrollY - i);
            this.mIsHeaderSticky = true;
        } else {
            this.mStickyScrollPresentation.freeHeader();
            this.mIsHeaderSticky = false;
        }
    }

    public boolean isFooterSticky() {
        return this.mIsFooterSticky;
    }

    public boolean isHeaderSticky() {
        return this.mIsHeaderSticky;
    }

    public void recomputeFooterLocation(int footerTop) {
        if (this.mScrolled) {
            this.mStickyFooterInitialTranslation = (this.mDeviceHeight - footerTop) - this.mStickyFooterHeight;
            this.mStickyFooterInitialLocation = footerTop;
        } else {
            initStickyFooter(this.mStickyFooterHeight, footerTop);
        }
        handleFooterStickiness(this.mStickyScrollPresentation.getCurrentScrollYPos());
    }

    public void recomputeHeaderLocation(int headerTop) {
        initStickyHeader(headerTop);
        handleHeaderStickiness(this.mStickyScrollPresentation.getCurrentScrollYPos());
    }
}
