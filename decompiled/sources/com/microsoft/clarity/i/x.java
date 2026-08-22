package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.typefaces.FontCoordinate;
import com.microsoft.clarity.models.display.typefaces.FontStyle;
import com.microsoft.clarity.models.display.typefaces.Typeface;
import java.util.ArrayList;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class x implements b<Typeface> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.h.d f1048a;

    public x(com.microsoft.clarity.h.d dVar) {
        this.f1048a = dVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x004c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x004f. Please report as an issue. */
    public static Typeface c(g buffer) {
        UInt uInt;
        String str;
        byte[] bArrA;
        UInt uInt2;
        String str2;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int iO = buffer.o();
        int iM12488constructorimpl = UInt.m12488constructorimpl(UInt.m12488constructorimpl(iO >>> 16) & 65535);
        int i = 255;
        int iM12488constructorimpl2 = UInt.m12488constructorimpl(UInt.m12488constructorimpl(iO >>> 8) & 255);
        int iM12488constructorimpl3 = UInt.m12488constructorimpl(iO & 255);
        UInt uIntM12482boximpl = null;
        String strB = null;
        UInt uIntM12482boximpl2 = null;
        String strB2 = null;
        String strB3 = null;
        Float fValueOf = null;
        Float fValueOf2 = null;
        Float fValueOf3 = null;
        Float fValueOf4 = null;
        ArrayList arrayList = null;
        while (true) {
            int iO2 = buffer.o();
            if (iO2 == 1) {
                strB = buffer.b(buffer.o());
            } else if (iO2 == 4) {
                strB2 = buffer.b(buffer.o());
            } else if (iO2 == 6) {
                strB3 = buffer.b(buffer.o());
            } else if (iO2 != 253) {
                int i2 = 0;
                if (iO2 != i) {
                    switch (iO2) {
                        case 16:
                            fValueOf = Float.valueOf(buffer.f());
                            break;
                        case 17:
                            fValueOf2 = Float.valueOf(buffer.f());
                            break;
                        case 18:
                            fValueOf3 = Float.valueOf(buffer.f());
                            break;
                        case 19:
                            fValueOf4 = Float.valueOf(buffer.f());
                            break;
                        default:
                            switch (iO2) {
                                case 248:
                                    uIntM12482boximpl2 = UInt.m12482boximpl(buffer.o());
                                    break;
                                case 249:
                                    uInt2 = uIntM12482boximpl;
                                    str2 = strB;
                                    int iO3 = buffer.o();
                                    while (i2 < iO3) {
                                        buffer.o();
                                        buffer.k();
                                        i2++;
                                    }
                                    uIntM12482boximpl = uInt2;
                                    strB = str2;
                                    break;
                                case 250:
                                    int iO4 = buffer.o();
                                    ArrayList arrayList2 = new ArrayList();
                                    while (i2 < iO4) {
                                        arrayList2.add(new FontCoordinate(buffer.k(), buffer.f()));
                                        i2++;
                                        uIntM12482boximpl = uIntM12482boximpl;
                                        strB = strB;
                                    }
                                    arrayList = arrayList2;
                                    break;
                                case 251:
                                    int iO5 = buffer.o();
                                    while (i2 < iO5) {
                                        buffer.g();
                                        i2++;
                                    }
                                    uInt2 = uIntM12482boximpl;
                                    str2 = strB;
                                    uIntM12482boximpl = uInt2;
                                    strB = str2;
                                    break;
                                default:
                                    uInt = uIntM12482boximpl;
                                    str = strB;
                                    break;
                            }
                            break;
                    }
                } else {
                    uInt = uIntM12482boximpl;
                    str = strB;
                    int iO6 = buffer.o();
                    if (Integer.compareUnsigned(iO6, 0) > 0) {
                        bArrA = buffer.a(iO6);
                    }
                }
            } else {
                uIntM12482boximpl = UInt.m12482boximpl(buffer.o());
            }
            i = 255;
        }
        bArrA = null;
        if (str == null || bArrA == null) {
            return null;
        }
        return new Typeface(str, strB2, strB3, new FontStyle(((long) iM12488constructorimpl) & 4294967295L, ((long) iM12488constructorimpl2) & 4294967295L, ((long) iM12488constructorimpl3) & 4294967295L), uInt != null ? Long.valueOf(((long) uInt.getData()) & 4294967295L) : null, fValueOf, fValueOf2, fValueOf3, fValueOf4, uIntM12482boximpl2 != null ? Long.valueOf(((long) uIntM12482boximpl2.getData()) & 4294967295L) : null, arrayList, bArrA, com.microsoft.clarity.n.b.b(bArrA));
    }

    @Override // com.microsoft.clarity.i.b
    public final /* bridge */ /* synthetic */ Typeface a(g gVar) {
        return c(gVar);
    }

    public final ArrayList b(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = buffer.i();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            Typeface typefaceC = c(buffer);
            if (typefaceC != null) {
                arrayList.add(typefaceC);
            }
        }
        return arrayList;
    }
}
