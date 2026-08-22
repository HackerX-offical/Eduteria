package com.google.android.gms.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public class Face {
    public static final float UNCOMPUTED_PROBABILITY = -1.0f;
    private int zza;
    private PointF zzb;
    private float zzc;
    private float zzd;
    private float zze;
    private float zzf;
    private float zzg;
    private List<Landmark> zzh;
    private final List<Contour> zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private final float zzm;

    private static float zza(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            return -1.0f;
        }
        return f2;
    }

    public PointF getPosition() {
        return new PointF(this.zzb.x - (this.zzc / 2.0f), this.zzb.y - (this.zzd / 2.0f));
    }

    public float getWidth() {
        return this.zzc;
    }

    public float getHeight() {
        return this.zzd;
    }

    public float getEulerY() {
        return this.zze;
    }

    public float getEulerZ() {
        return this.zzf;
    }

    public float getEulerX() {
        return this.zzg;
    }

    public List<Landmark> getLandmarks() {
        return this.zzh;
    }

    public List<Contour> getContours() {
        return this.zzi;
    }

    public float getIsLeftEyeOpenProbability() {
        return this.zzj;
    }

    public float getIsRightEyeOpenProbability() {
        return this.zzk;
    }

    public float getIsSmilingProbability() {
        return this.zzl;
    }

    public int getId() {
        return this.zza;
    }

    public Face(int i, PointF pointF, float f2, float f3, float f4, float f5, float f6, Landmark[] landmarkArr, Contour[] contourArr, float f7, float f8, float f9, float f10) {
        this.zza = i;
        this.zzb = pointF;
        this.zzc = f2;
        this.zzd = f3;
        this.zze = f4;
        this.zzf = f5;
        this.zzg = f6;
        this.zzh = Arrays.asList(landmarkArr);
        this.zzi = Arrays.asList(contourArr);
        this.zzj = zza(f7);
        this.zzk = zza(f8);
        this.zzl = zza(f9);
        this.zzm = zza(f10);
    }
}
