package com.microsoft.clarity.d;

import java.io.IOException;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public final class g {
    public static j a(f fVar, Set set) throws IOException {
        j jVar = new j(fVar);
        fVar.c();
        jVar.f729d = set;
        int iH = fVar.h();
        fVar.h();
        fVar.h();
        fVar.h();
        for (int i = 0; i < iH; i++) {
            String strE = fVar.e();
            h bVar = strE.equals("cmap") ? new b(jVar) : strE.equals("maxp") ? new c(jVar) : new h(jVar);
            bVar.f717a = strE;
            fVar.g();
            bVar.f718b = fVar.g();
            long jG = fVar.g();
            bVar.f719c = jG;
            if (jG == 0 && !strE.equals("glyf")) {
                bVar = null;
            }
            if (bVar != null) {
                if (bVar.f718b + bVar.f719c > jVar.f728c.b()) {
                    com.microsoft.clarity.n.i.e(com.microsoft.clarity.a.b.a("Skip table '").append(bVar.f717a).append("' which goes past the file size; offset: ").append(bVar.f718b).append(", size: ").append(bVar.f719c).append(", font size: ").append(jVar.f728c.b()).toString());
                } else {
                    jVar.f727b.put(bVar.f717a, bVar);
                }
            }
        }
        return jVar;
    }

    public static j a(byte[] bArr, Set set) {
        return a(new d(bArr), set);
    }
}
