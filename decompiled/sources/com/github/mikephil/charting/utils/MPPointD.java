package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class MPPointD extends ObjectPool.Poolable {
    private static ObjectPool<MPPointD> pool;
    public double x;
    public double y;

    static {
        ObjectPool<MPPointD> objectPoolCreate = ObjectPool.create(64, new MPPointD(0.0d, 0.0d));
        pool = objectPoolCreate;
        objectPoolCreate.setReplenishPercentage(0.5f);
    }

    public static MPPointD getInstance(double d2, double d3) {
        MPPointD mPPointD = (MPPointD) pool.get();
        mPPointD.x = d2;
        mPPointD.y = d3;
        return mPPointD;
    }

    public static void recycleInstance(MPPointD mPPointD) {
        pool.recycle(mPPointD);
    }

    public static void recycleInstances(List<MPPointD> list) {
        pool.recycle(list);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new MPPointD(0.0d, 0.0d);
    }

    private MPPointD(double d2, double d3) {
        this.x = d2;
        this.y = d3;
    }

    public String toString() {
        return "MPPointD, x: " + this.x + ", y: " + this.y;
    }
}
