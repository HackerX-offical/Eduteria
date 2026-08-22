package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public class TextBlock implements Text {
    private zzah[] zza;
    private Point[] zzb;
    private List<Line> zzc;
    private String zzd;
    private Rect zze;

    TextBlock(SparseArray<zzah> sparseArray) {
        this.zza = new zzah[sparseArray.size()];
        int i = 0;
        while (true) {
            zzah[] zzahVarArr = this.zza;
            if (i >= zzahVarArr.length) {
                return;
            }
            zzahVarArr[i] = sparseArray.valueAt(i);
            i++;
        }
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getLanguage() {
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        HashMap map = new HashMap();
        for (zzah zzahVar : this.zza) {
            map.put(zzahVar.zzd, Integer.valueOf((map.containsKey(zzahVar.zzd) ? ((Integer) map.get(zzahVar.zzd)).intValue() : 0) + 1));
        }
        String str2 = (String) ((Map.Entry) Collections.max(map.entrySet(), new zza(this))).getKey();
        this.zzd = str2;
        if (str2 == null || str2.isEmpty()) {
            this.zzd = "und";
        }
        return this.zzd;
    }

    @Override // com.google.android.gms.vision.text.Text
    public String getValue() {
        if (this.zza.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(this.zza[0].zzc);
        for (int i = 1; i < this.zza.length; i++) {
            sb.append("\n");
            sb.append(this.zza[i].zzc);
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.vision.text.Text
    public Point[] getCornerPoints() {
        zzah[] zzahVarArr;
        if (this.zzb == null) {
            int i = 0;
            if (this.zza.length == 0) {
                this.zzb = new Point[0];
            } else {
                int iMax = Integer.MIN_VALUE;
                int i2 = 0;
                int iMin = Integer.MAX_VALUE;
                int iMin2 = Integer.MAX_VALUE;
                int iMax2 = Integer.MIN_VALUE;
                while (true) {
                    zzahVarArr = this.zza;
                    if (i2 >= zzahVarArr.length) {
                        break;
                    }
                    zzab zzabVar = zzahVarArr[i2].zzb;
                    zzab zzabVar2 = this.zza[i].zzb;
                    int i3 = -zzabVar2.zza;
                    int i4 = -zzabVar2.zzb;
                    double dSin = Math.sin(Math.toRadians(zzabVar2.zze));
                    int i5 = i;
                    double dCos = Math.cos(Math.toRadians(zzabVar2.zze));
                    Point[] pointArr = new Point[4];
                    Point point = new Point(zzabVar.zza, zzabVar.zzb);
                    pointArr[i5] = point;
                    point.offset(i3, i4);
                    int i6 = (int) ((((double) pointArr[i5].x) * dCos) + (((double) pointArr[i5].y) * dSin));
                    int i7 = (int) ((((double) (-pointArr[i5].x)) * dSin) + (((double) pointArr[i5].y) * dCos));
                    pointArr[i5].x = i6;
                    pointArr[i5].y = i7;
                    pointArr[1] = new Point(zzabVar.zzc + i6, i7);
                    pointArr[2] = new Point(zzabVar.zzc + i6, zzabVar.zzd + i7);
                    pointArr[3] = new Point(i6, i7 + zzabVar.zzd);
                    iMax2 = iMax2;
                    for (int i8 = i5; i8 < 4; i8++) {
                        Point point2 = pointArr[i8];
                        iMin = Math.min(iMin, point2.x);
                        iMax = Math.max(iMax, point2.x);
                        iMin2 = Math.min(iMin2, point2.y);
                        iMax2 = Math.max(iMax2, point2.y);
                    }
                    i2++;
                    i = i5;
                }
                int i9 = i;
                int i10 = iMax2;
                zzab zzabVar3 = zzahVarArr[i9].zzb;
                int i11 = zzabVar3.zza;
                int i12 = zzabVar3.zzb;
                double dSin2 = Math.sin(Math.toRadians(zzabVar3.zze));
                double dCos2 = Math.cos(Math.toRadians(zzabVar3.zze));
                Point[] pointArr2 = new Point[4];
                pointArr2[i9] = new Point(iMin, iMin2);
                pointArr2[1] = new Point(iMax, iMin2);
                pointArr2[2] = new Point(iMax, i10);
                pointArr2[3] = new Point(iMin, i10);
                for (int i13 = i9; i13 < 4; i13++) {
                    int i14 = (int) ((((double) pointArr2[i13].x) * dCos2) - (((double) pointArr2[i13].y) * dSin2));
                    int i15 = (int) ((((double) pointArr2[i13].x) * dSin2) + (((double) pointArr2[i13].y) * dCos2));
                    pointArr2[i13].x = i14;
                    pointArr2[i13].y = i15;
                    pointArr2[i13].offset(i11, i12);
                }
                this.zzb = pointArr2;
            }
        }
        return this.zzb;
    }

    @Override // com.google.android.gms.vision.text.Text
    public List<? extends Text> getComponents() {
        if (this.zza.length == 0) {
            return new ArrayList(0);
        }
        if (this.zzc == null) {
            this.zzc = new ArrayList(this.zza.length);
            for (zzah zzahVar : this.zza) {
                this.zzc.add(new Line(zzahVar));
            }
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.vision.text.Text
    public Rect getBoundingBox() {
        if (this.zze == null) {
            this.zze = zzc.zza(this);
        }
        return this.zze;
    }
}
