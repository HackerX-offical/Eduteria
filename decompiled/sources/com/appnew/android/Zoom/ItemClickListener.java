package com.appnew.android.Zoom;

import com.appnew.android.Model.TimeTable.Data;
import com.appnew.android.Model.ZoomModel.CurrentAffairDataModel;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: OnClicked.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J(\u0010\t\u001a\u00020\u00032\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u0004\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH&¨\u0006\u0011"}, d2 = {"Lcom/appnew/android/Zoom/ItemClickListener;", "", "onClick", "", Const.POSITION, "", "onClickCurrentAffair", "", "Lcom/appnew/android/Model/ZoomModel/CurrentAffairDataModel;", "onClickTimeTableDate", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/TimeTable/Data;", "Lkotlin/collections/ArrayList;", "", "getPosition", Constants.INAPP_POSITION, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ItemClickListener {
    void getPosition(int pos);

    void onClick(String position);

    void onClickCurrentAffair(List<CurrentAffairDataModel> position);

    void onClickTimeTableDate(ArrayList<Data> data, int position);
}
