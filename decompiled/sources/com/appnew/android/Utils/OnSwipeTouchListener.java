package com.appnew.android.Utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public class OnSwipeTouchListener implements View.OnTouchListener {
    private final GestureDetector gestureDetector;

    public void onSwipeBottom() {
    }

    public void onSwipeLeft() {
    }

    public void onSwipeRight() {
    }

    public void onSwipeTop() {
    }

    public OnSwipeTouchListener(Context ctx) {
        this.gestureDetector = new GestureDetector(ctx, new GestureListener());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return this.gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e2) {
            return true;
        }

        private GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                float y = e2.getY() - e1.getY();
                float x = e2.getX() - e1.getX();
                if (Math.abs(x) > Math.abs(y)) {
                    if (Math.abs(x) > 100.0f && Math.abs(velocityX) > 100.0f) {
                        if (x > 0.0f) {
                            OnSwipeTouchListener.this.onSwipeRight();
                        } else {
                            OnSwipeTouchListener.this.onSwipeLeft();
                        }
                        return true;
                    }
                } else if (Math.abs(y) > 100.0f && Math.abs(velocityY) > 100.0f) {
                    if (y > 0.0f) {
                        OnSwipeTouchListener.this.onSwipeBottom();
                    } else {
                        OnSwipeTouchListener.this.onSwipeTop();
                    }
                    return true;
                }
                return false;
            } catch (Exception e3) {
                e3.printStackTrace();
                return false;
            }
        }
    }
}
