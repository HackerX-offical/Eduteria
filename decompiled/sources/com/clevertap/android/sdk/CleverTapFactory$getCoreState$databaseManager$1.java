package com.clevertap.android.sdk;

import com.clevertap.android.sdk.network.NetworkRepo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CleverTapFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class CleverTapFactory$getCoreState$databaseManager$1 extends FunctionReferenceImpl implements Function0<Unit> {
    CleverTapFactory$getCoreState$databaseManager$1(Object obj) {
        super(0, obj, NetworkRepo.class, "clearFirstRequestTs", "clearFirstRequestTs()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((NetworkRepo) this.receiver).clearFirstRequestTs();
    }
}
