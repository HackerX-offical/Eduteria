package com.clevertap.android.sdk;

import com.clevertap.android.sdk.network.NetworkRepo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CleverTapFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class CleverTapFactory$getCoreState$queueHeaderBuilder$1 extends FunctionReferenceImpl implements Function0<Integer> {
    CleverTapFactory$getCoreState$queueHeaderBuilder$1(Object obj) {
        super(0, obj, NetworkRepo.class, "getFirstRequestTs", "getFirstRequestTs()I", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        return Integer.valueOf(((NetworkRepo) this.receiver).getFirstRequestTs());
    }
}
