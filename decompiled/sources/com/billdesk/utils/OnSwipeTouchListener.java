package com.billdesk.utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public class OnSwipeTouchListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureDetector f508a;

    public final class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            float x = motionEvent2.getX() - motionEvent.getX();
            if (Math.abs(x) <= Math.abs(motionEvent2.getY() - motionEvent.getY()) || Math.abs(x) <= 100.0f || Math.abs(f2) <= 100.0f) {
                return false;
            }
            if (x > 0.0f) {
                OnSwipeTouchListener.this.getClass();
            } else {
                OnSwipeTouchListener.this.getClass();
            }
            OnSwipeTouchListener.this.a();
            return true;
        }
    }

    public OnSwipeTouchListener(Context context) {
        this.f508a = new GestureDetector(context, new b());
    }

    public void a() {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f508a.onTouchEvent(motionEvent);
    }
}
