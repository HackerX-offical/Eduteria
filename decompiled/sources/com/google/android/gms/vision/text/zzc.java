package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.vision.zzab;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes8.dex */
final class zzc {
    static Rect zza(Text text) {
        int iMin = Integer.MAX_VALUE;
        int iMax = Integer.MIN_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        for (Point point : text.getCornerPoints()) {
            iMin = Math.min(iMin, point.x);
            iMax2 = Math.max(iMax2, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax = Math.max(iMax, point.y);
        }
        return new Rect(iMin, iMin2, iMax2, iMax);
    }

    static Point[] zza(zzab zzabVar) {
        Point[] pointArr = new Point[4];
        double dSin = Math.sin(Math.toRadians(zzabVar.zze));
        double dCos = Math.cos(Math.toRadians(zzabVar.zze));
        pointArr[0] = new Point(zzabVar.zza, zzabVar.zzb);
        pointArr[1] = new Point((int) (((double) zzabVar.zza) + (((double) zzabVar.zzc) * dCos)), (int) (((double) zzabVar.zzb) + (((double) zzabVar.zzc) * dSin)));
        pointArr[2] = new Point((int) (((double) pointArr[1].x) - (((double) zzabVar.zzd) * dSin)), (int) (((double) pointArr[1].y) + (((double) zzabVar.zzd) * dCos)));
        pointArr[3] = new Point(pointArr[0].x + (pointArr[2].x - pointArr[1].x), pointArr[0].y + (pointArr[2].y - pointArr[1].y));
        return pointArr;
    }
}
