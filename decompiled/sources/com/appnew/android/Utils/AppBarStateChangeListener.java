package com.appnew.android.Utils;

import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {
    private State mCurrentState = State.IDLE;

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state);

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            if (this.mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED);
            }
            this.mCurrentState = State.EXPANDED;
        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            if (this.mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED);
            }
            this.mCurrentState = State.COLLAPSED;
        } else {
            if (this.mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE);
            }
            this.mCurrentState = State.IDLE;
        }
    }
}
