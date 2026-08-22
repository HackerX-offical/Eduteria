package com.appnew.android.Intro;

import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;

/* JADX INFO: compiled from: ItemSelected.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/appnew/android/Intro/ItemSelected;", "", "Selecteditem", "", "item", "", "mastercat", "Lcom/appnew/android/Intro/Mastercat;", "Selectedsubcat", Constants.INAPP_POSITION, "sucat", "Lcom/appnew/android/Intro/SubCat;", "type", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ItemSelected {
    void Selecteditem(int item, Mastercat mastercat);

    void Selectedsubcat(int pos, SubCat sucat, String type);
}
