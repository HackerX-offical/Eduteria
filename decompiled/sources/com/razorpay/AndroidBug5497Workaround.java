package com.razorpay;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: CheckoutUtils.java */
/* JADX INFO: loaded from: classes9.dex */
class AndroidBug5497Workaround {
    private FrameLayout.LayoutParams frameLayoutParams;
    private View mChildOfContent;
    private int restoreHeight;
    private int usableHeightPrevious;

    static void assistActivity(Activity activity) {
        new AndroidBug5497Workaround(activity);
    }

    private AndroidBug5497Workaround(Activity activity) {
        View childAt = ((FrameLayout) activity.findViewById(android.R.id.content)).getChildAt(0);
        this.mChildOfContent = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.razorpay.AndroidBug5497Workaround.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AndroidBug5497Workaround.this.possiblyResizeChildOfContent();
            }
        });
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mChildOfContent.getLayoutParams();
        this.frameLayoutParams = layoutParams;
        this.restoreHeight = layoutParams.height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        int iComputeUsableHeight = computeUsableHeight();
        if (iComputeUsableHeight != this.usableHeightPrevious) {
            int height = this.mChildOfContent.getRootView().getHeight();
            if (height - iComputeUsableHeight > height / 4) {
                this.frameLayoutParams.height = iComputeUsableHeight;
            } else {
                this.frameLayoutParams.height = this.restoreHeight;
            }
            this.mChildOfContent.requestLayout();
            this.usableHeightPrevious = iComputeUsableHeight;
        }
    }

    private int computeUsableHeight() {
        Rect rect = new Rect();
        this.mChildOfContent.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }
}
