package com.microsoft.clarity.g;

import com.amazonaws.services.s3.internal.Constants;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class n {
    public static int[] _values() {
        return com.microsoft.clarity.e.g.b(4);
    }

    public static /* synthetic */ String a(int i) {
        return i == 1 ? "Undefined" : i == 2 ? "Inactive" : i == 3 ? "WaitingPort" : i == 4 ? "Active" : Constants.NULL_VERSION_ID;
    }
}
