package com.appnew.android.TeacherTimeTable.Interface;

import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.TeacherTimeTable.BatchTimetable;
import com.appnew.android.Utils.Const;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: compiled from: DateItemClick.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Interface/DateItemClick;", "", "onClickTimeTableDate", "", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/TeacherTimeTable/BatchTimetable;", "Lkotlin/collections/ArrayList;", Const.POSITION, "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DateItemClick {
    void onClickTimeTableDate(ArrayList<BatchTimetable> data, int position, RecyclerView recyclerView);
}
