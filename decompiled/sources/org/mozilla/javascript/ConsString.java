package org.mozilla.javascript;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class ConsString implements CharSequence, Serializable {
    private static final long serialVersionUID = -8432806714471372570L;
    private boolean isFlat = false;
    private CharSequence left;
    private final int length;
    private CharSequence right;

    public ConsString(CharSequence charSequence, CharSequence charSequence2) {
        this.left = charSequence;
        this.right = charSequence2;
        this.length = charSequence.length() + this.right.length();
    }

    private Object writeReplace() {
        return toString();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.isFlat ? (String) this.left : flatten();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[Catch: all -> 0x005d, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0015, B:8:0x0019, B:10:0x001f, B:11:0x0022, B:17:0x0049, B:12:0x002a, B:15:0x0041, B:18:0x0057), top: B:24:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized java.lang.String flatten() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.isFlat     // Catch: java.lang.Throwable -> L5d
            if (r0 != 0) goto L57
            int r0 = r6.length     // Catch: java.lang.Throwable -> L5d
            char[] r1 = new char[r0]     // Catch: java.lang.Throwable -> L5d
            java.util.ArrayDeque r2 = new java.util.ArrayDeque     // Catch: java.lang.Throwable -> L5d
            r2.<init>()     // Catch: java.lang.Throwable -> L5d
            java.lang.CharSequence r3 = r6.left     // Catch: java.lang.Throwable -> L5d
            r2.addFirst(r3)     // Catch: java.lang.Throwable -> L5d
            java.lang.CharSequence r3 = r6.right     // Catch: java.lang.Throwable -> L5d
        L15:
            boolean r4 = r3 instanceof org.mozilla.javascript.ConsString     // Catch: java.lang.Throwable -> L5d
            if (r4 == 0) goto L2a
            org.mozilla.javascript.ConsString r3 = (org.mozilla.javascript.ConsString) r3     // Catch: java.lang.Throwable -> L5d
            boolean r4 = r3.isFlat     // Catch: java.lang.Throwable -> L5d
            if (r4 == 0) goto L22
            java.lang.CharSequence r3 = r3.left     // Catch: java.lang.Throwable -> L5d
            goto L2a
        L22:
            java.lang.CharSequence r4 = r3.left     // Catch: java.lang.Throwable -> L5d
            r2.addFirst(r4)     // Catch: java.lang.Throwable -> L5d
            java.lang.CharSequence r3 = r3.right     // Catch: java.lang.Throwable -> L5d
            goto L47
        L2a:
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L5d
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L5d
            int r0 = r0 - r4
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L5d
            r5 = 0
            r3.getChars(r5, r4, r1, r0)     // Catch: java.lang.Throwable -> L5d
            boolean r3 = r2.isEmpty()     // Catch: java.lang.Throwable -> L5d
            if (r3 == 0) goto L41
            r3 = 0
            goto L47
        L41:
            java.lang.Object r3 = r2.removeFirst()     // Catch: java.lang.Throwable -> L5d
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Throwable -> L5d
        L47:
            if (r3 != 0) goto L15
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L5d
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L5d
            r6.left = r0     // Catch: java.lang.Throwable -> L5d
            java.lang.String r0 = ""
            r6.right = r0     // Catch: java.lang.Throwable -> L5d
            r0 = 1
            r6.isFlat = r0     // Catch: java.lang.Throwable -> L5d
        L57:
            java.lang.CharSequence r0 = r6.left     // Catch: java.lang.Throwable -> L5d
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L5d
            monitor-exit(r6)
            return r0
        L5d:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L5d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ConsString.flatten():java.lang.String");
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return (this.isFlat ? (String) this.left : flatten()).charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return (this.isFlat ? (String) this.left : flatten()).substring(i, i2);
    }
}
