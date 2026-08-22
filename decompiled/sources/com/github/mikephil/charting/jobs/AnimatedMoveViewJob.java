package com.github.mikephil.charting.jobs;

import android.animation.ValueAnimator;
import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes7.dex */
public class AnimatedMoveViewJob extends AnimatedViewPortJob {
    private static ObjectPool<AnimatedMoveViewJob> pool;

    static {
        ObjectPool<AnimatedMoveViewJob> objectPoolCreate = ObjectPool.create(4, new AnimatedMoveViewJob(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L));
        pool = objectPoolCreate;
        objectPoolCreate.setReplenishPercentage(0.5f);
    }

    public static AnimatedMoveViewJob getInstance(ViewPortHandler viewPortHandler, float f2, float f3, Transformer transformer, View view, float f4, float f5, long j) {
        AnimatedMoveViewJob animatedMoveViewJob = (AnimatedMoveViewJob) pool.get();
        animatedMoveViewJob.mViewPortHandler = viewPortHandler;
        animatedMoveViewJob.xValue = f2;
        animatedMoveViewJob.yValue = f3;
        animatedMoveViewJob.mTrans = transformer;
        animatedMoveViewJob.view = view;
        animatedMoveViewJob.xOrigin = f4;
        animatedMoveViewJob.yOrigin = f5;
        animatedMoveViewJob.animator.setDuration(j);
        return animatedMoveViewJob;
    }

    public static void recycleInstance(AnimatedMoveViewJob animatedMoveViewJob) {
        pool.recycle(animatedMoveViewJob);
    }

    public AnimatedMoveViewJob(ViewPortHandler viewPortHandler, float f2, float f3, Transformer transformer, View view, float f4, float f5, long j) {
        super(viewPortHandler, f2, f3, transformer, view, f4, f5, j);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.pts[0] = this.xOrigin + ((this.xValue - this.xOrigin) * this.phase);
        this.pts[1] = this.yOrigin + ((this.yValue - this.yOrigin) * this.phase);
        this.mTrans.pointValuesToPixel(this.pts);
        this.mViewPortHandler.centerViewPort(this.pts, this.view);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public void recycleSelf() {
        recycleInstance(this);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new AnimatedMoveViewJob(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L);
    }
}
