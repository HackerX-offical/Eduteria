package com.microsoft.clarity.i;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1025b;

    public a(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.f1024a = bytes;
    }

    public final boolean a() {
        return this.f1025b < this.f1024a.length;
    }

    public final byte[] a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot read 0 length segment of the byte buffer!");
        }
        byte[] bArr = this.f1024a;
        int i2 = this.f1025b;
        byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArr, i2, i2 + i);
        this.f1025b += i;
        return bArrCopyOfRange;
    }

    public final String b(int i) {
        byte[] bArr = this.f1024a;
        int i2 = this.f1025b;
        String str = new String(ArraysKt.copyOfRange(bArr, i2, i2 + i), Charsets.UTF_8);
        this.f1025b += i;
        return str;
    }

    public final byte[] b() {
        return this.f1024a;
    }

    public final int c() {
        return this.f1025b;
    }

    public final void c(int i) {
        this.f1025b = i;
    }

    public final int d() {
        byte[] bArr = this.f1024a;
        int i = this.f1025b;
        byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArr, i, i + 4);
        int iM12488constructorimpl = UInt.m12488constructorimpl(UInt.m12488constructorimpl(UInt.m12488constructorimpl(UByte.m12411constructorimpl(bArrCopyOfRange[3]) & 255)) + UInt.m12488constructorimpl(UInt.m12488constructorimpl(UInt.m12488constructorimpl(UByte.m12411constructorimpl(bArrCopyOfRange[2]) & 255) << 8) + UInt.m12488constructorimpl(UInt.m12488constructorimpl(UInt.m12488constructorimpl(UByte.m12411constructorimpl(bArrCopyOfRange[1]) & 255) << 16) + UInt.m12488constructorimpl(UInt.m12488constructorimpl(UInt.m12488constructorimpl(UByte.m12411constructorimpl(bArrCopyOfRange[0]) & 255) << 24)))));
        this.f1025b += 4;
        return iM12488constructorimpl;
    }

    public final void d(int i) {
        this.f1025b += i;
    }

    public final int e() {
        byte[] bArr = this.f1024a;
        int i = this.f1025b;
        byte b2 = bArr[i];
        this.f1025b = i + 1;
        return b2;
    }

    public final float f() {
        byte[] bArr = this.f1024a;
        int i = this.f1025b;
        float f2 = ByteBuffer.wrap(ArraysKt.copyOfRange(bArr, i, i + 4)).order(ByteOrder.nativeOrder()).getFloat();
        this.f1025b += 4;
        return f2;
    }

    public final int g() {
        byte[] bArr = this.f1024a;
        int i = this.f1025b;
        int i2 = ByteBuffer.wrap(ArraysKt.copyOfRange(bArr, i, i + 4)).order(ByteOrder.nativeOrder()).getInt();
        this.f1025b += 4;
        return i2;
    }

    public final int h() {
        byte[] bArr = this.f1024a;
        int i = this.f1025b;
        byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArr, i, i + 2);
        int iM12488constructorimpl = UInt.m12488constructorimpl(UInt.m12488constructorimpl(UInt.m12488constructorimpl(UByte.m12411constructorimpl(bArrCopyOfRange[1]) & 255) << 8) + UInt.m12488constructorimpl(UInt.m12488constructorimpl(UByte.m12411constructorimpl(bArrCopyOfRange[0]) & 255)));
        this.f1025b += 2;
        return iM12488constructorimpl;
    }

    public final int i() {
        byte[] bArr = this.f1024a;
        int i = this.f1025b;
        byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArr, i, i + 4);
        int iM12488constructorimpl = UInt.m12488constructorimpl(UInt.m12488constructorimpl(UInt.m12488constructorimpl(UByte.m12411constructorimpl(bArrCopyOfRange[3]) & 255) << 24) + UInt.m12488constructorimpl(UInt.m12488constructorimpl(UInt.m12488constructorimpl(UByte.m12411constructorimpl(bArrCopyOfRange[2]) & 255) << 16) + UInt.m12488constructorimpl(UInt.m12488constructorimpl(UInt.m12488constructorimpl(UByte.m12411constructorimpl(bArrCopyOfRange[1]) & 255) << 8) + UInt.m12488constructorimpl(UInt.m12488constructorimpl(UByte.m12411constructorimpl(bArrCopyOfRange[0]) & 255)))));
        this.f1025b += 4;
        return iM12488constructorimpl;
    }
}
