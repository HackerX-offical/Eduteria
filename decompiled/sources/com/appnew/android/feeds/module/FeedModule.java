package com.appnew.android.feeds.module;

import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.mvvmwithretrofit.repository.Repository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeedModule.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/appnew/android/feeds/module/FeedModule;", "", "<init>", "()V", "repositroyInstance", "Lcom/appnew/mvvmwithretrofit/repository/Repository;", "apiInterface", "Lcom/appnew/android/Utils/Network/APIInterface;", "apiInterfaceInstance", "roomDbInsatance", "Lcom/appnew/android/Room/UtkashRoom;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedModule {
    public static final int $stable = 0;

    public final Repository repositroyInstance(APIInterface apiInterface) {
        Intrinsics.checkNotNullParameter(apiInterface, "apiInterface");
        return new Repository(apiInterface);
    }

    public final APIInterface apiInterfaceInstance() {
        Object objCreate = MakeMyExam.getRetrofitInstance().create(APIInterface.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        return (APIInterface) objCreate;
    }

    public final UtkashRoom roomDbInsatance() {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        Intrinsics.checkNotNullExpressionValue(appDatabase, "getAppDatabase(...)");
        return appDatabase;
    }
}
