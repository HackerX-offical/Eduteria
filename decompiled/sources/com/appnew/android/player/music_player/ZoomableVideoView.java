package com.appnew.android.player.music_player;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import androidx.media3.ui.PlayerView;

/* JADX INFO: loaded from: classes6.dex */
public class ZoomableVideoView extends FrameLayout implements ScaleGestureDetector.OnScaleGestureListener, GestureDetector.OnGestureListener {
    private GestureDetector gestureDetector;
    private boolean isZoomed;
    private PlayerTouchListener playerTouchListener;
    private float scaleFactor;
    private ScaleGestureDetector scaleGestureDetector;
    private float translationX;
    private float translationY;
    private View videoView;
    private ZoomListener zoomListener;

    public interface ZoomListener {
        void onSingleTap();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent e2) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e2) {
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector detector) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent e2) {
    }

    public ZoomableVideoView(Context context) {
        super(context);
        this.scaleFactor = 1.0f;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.isZoomed = false;
        init(context);
    }

    public ZoomableVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.scaleFactor = 1.0f;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.isZoomed = false;
        init(context);
    }

    public ZoomableVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.scaleFactor = 1.0f;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.isZoomed = false;
        init(context);
    }

    private void init(Context context) {
        this.scaleGestureDetector = new ScaleGestureDetector(context, this);
        this.gestureDetector = new GestureDetector(context, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt instanceof PlayerView) {
                PlayerView playerView = (PlayerView) childAt;
                this.videoView = playerView.getVideoSurfaceView();
                PlayerTouchListener playerTouchListener = new PlayerTouchListener(playerView);
                this.playerTouchListener = playerTouchListener;
                playerView.setOnTouchListener(playerTouchListener);
                Log.e("PlayerView", "onAttachedToWindow: PlayerView assigned");
                return;
            }
            this.videoView = childAt;
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        if (this.videoView == null) {
            return false;
        }
        float fMax = Math.max(1.0f, Math.min(this.scaleFactor * detector.getScaleFactor(), 4.0f));
        this.scaleFactor = fMax;
        this.isZoomed = fMax > 1.0f;
        this.videoView.setScaleX(fMax);
        this.videoView.setScaleY(this.scaleFactor);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e2) {
        ZoomListener zoomListener = this.zoomListener;
        if (zoomListener == null) {
            return true;
        }
        zoomListener.onSingleTap();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (!this.isZoomed) {
            return false;
        }
        this.translationX -= distanceX;
        this.translationY -= distanceY;
        applyTranslation();
        return true;
    }

    private void applyTranslation() {
        if (this.videoView == null) {
            return;
        }
        float width = (getWidth() * (this.scaleFactor - 1.0f)) / 2.0f;
        float height = (getHeight() * (this.scaleFactor - 1.0f)) / 2.0f;
        this.translationX = Math.max(-width, Math.min(this.translationX, width));
        this.translationY = Math.max(-height, Math.min(this.translationY, height));
        this.videoView.setTranslationX(this.translationX);
        this.videoView.setTranslationY(this.translationY);
    }

    public void setZoomListener(ZoomListener listener) {
        this.zoomListener = listener;
    }

    private class PlayerTouchListener implements View.OnTouchListener {
        private final PlayerView playerView;

        public PlayerTouchListener(PlayerView playerView) {
            this.playerView = playerView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            ZoomableVideoView.this.scaleGestureDetector.onTouchEvent(event);
            ZoomableVideoView.this.gestureDetector.onTouchEvent(event);
            return true;
        }
    }
}
