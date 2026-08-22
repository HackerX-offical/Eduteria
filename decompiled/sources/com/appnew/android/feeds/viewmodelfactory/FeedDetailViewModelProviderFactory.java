package com.appnew.android.feeds.viewmodelfactory;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.feeds.viewmodel.FeedDetailViewModel;
import com.appnew.mvvmwithretrofit.repository.Repository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FeedDetailViewModelProviderFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/appnew/android/feeds/viewmodelfactory/FeedDetailViewModelProviderFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "userRepository", "Lcom/appnew/mvvmwithretrofit/repository/Repository;", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "<init>", "(Lcom/appnew/mvvmwithretrofit/repository/Repository;Lcom/appnew/android/Room/UtkashRoom;)V", "getUserRepository", "()Lcom/appnew/mvvmwithretrofit/repository/Repository;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedDetailViewModelProviderFactory implements ViewModelProvider.Factory {
    public static final int $stable = 8;
    private final Repository userRepository;
    private final UtkashRoom utkashRoom;

    public FeedDetailViewModelProviderFactory(Repository userRepository, UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(userRepository, "userRepository");
        Intrinsics.checkNotNullParameter(utkashRoom, "utkashRoom");
        this.userRepository = userRepository;
        this.utkashRoom = utkashRoom;
    }

    public final Repository getUserRepository() {
        return this.userRepository;
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(FeedDetailViewModel.class)) {
            return new FeedDetailViewModel(this.userRepository, this.utkashRoom);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
