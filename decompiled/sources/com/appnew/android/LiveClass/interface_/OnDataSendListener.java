package com.appnew.android.LiveClass.interface_;

import kotlin.Metadata;

/* JADX INFO: compiled from: OnDataSendListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/appnew/android/LiveClass/interface_/OnDataSendListener;", "", "onDataSent", "", "isLive", "", "particularId", "", "attemptOrReAttempt", "ratingType", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OnDataSendListener {
    void onDataSent(long isLive, String particularId, String attemptOrReAttempt, int ratingType);

    /* JADX INFO: compiled from: OnDataSendListener.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onDataSent$default(OnDataSendListener onDataSendListener, long j, String str, String str2, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDataSent");
            }
            if ((i2 & 4) != 0) {
                str2 = null;
            }
            onDataSendListener.onDataSent(j, str, str2, i);
        }
    }
}
