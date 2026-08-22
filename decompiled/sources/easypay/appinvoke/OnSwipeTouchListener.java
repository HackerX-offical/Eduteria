package easypay.appinvoke;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public class OnSwipeTouchListener implements View.OnTouchListener {
    private final GestureDetector gestureDetector;

    public void onClickView() {
    }

    public void onSwipeBottom() {
    }

    public void onSwipeLeft() {
    }

    public void onSwipeRight() {
    }

    public void onSwipeTop() {
    }

    public OnSwipeTouchListener(Context context) {
        this.gestureDetector = new GestureDetector(context, new GestureListener());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.gestureDetector.onTouchEvent(motionEvent);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_DISTANCE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        private GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            OnSwipeTouchListener.this.onClickView();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent2.getY() - motionEvent.getY();
            if (Math.abs(x) > Math.abs(y) && Math.abs(x) > 100.0f && Math.abs(f2) > 100.0f) {
                if (x > 0.0f) {
                    OnSwipeTouchListener.this.onSwipeRight();
                    return true;
                }
                OnSwipeTouchListener.this.onSwipeLeft();
                return true;
            }
            if (Math.abs(y) <= 100.0f || Math.abs(f3) <= 100.0f) {
                return false;
            }
            if (y > 0.0f) {
                OnSwipeTouchListener.this.onSwipeBottom();
                return false;
            }
            OnSwipeTouchListener.this.onSwipeTop();
            return false;
        }
    }
}
