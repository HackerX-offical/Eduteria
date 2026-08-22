package com.futuremind.recyclerviewfastscroll.viewprovider;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultBubbleBehavior implements ViewBehavior {
    private final VisibilityAnimationManager animationManager;

    @Override // com.futuremind.recyclerviewfastscroll.viewprovider.ViewBehavior
    public void onScrollFinished() {
    }

    @Override // com.futuremind.recyclerviewfastscroll.viewprovider.ViewBehavior
    public void onScrollStarted() {
    }

    public DefaultBubbleBehavior(VisibilityAnimationManager animationManager) {
        this.animationManager = animationManager;
    }

    @Override // com.futuremind.recyclerviewfastscroll.viewprovider.ViewBehavior
    public void onHandleGrabbed() {
        this.animationManager.show();
    }

    @Override // com.futuremind.recyclerviewfastscroll.viewprovider.ViewBehavior
    public void onHandleReleased() {
        this.animationManager.hide();
    }
}
