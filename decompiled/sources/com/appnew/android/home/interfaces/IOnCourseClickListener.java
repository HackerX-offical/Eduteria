package com.appnew.android.home.interfaces;

import com.appnew.android.Utils.Const;
import com.appnew.android.table.CourseTypeMasterTable;
import kotlin.Metadata;

/* JADX INFO: compiled from: IOnCourseClickListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/appnew/android/home/interfaces/IOnCourseClickListener;", "", "onCourseItemClick", "", "courseTypeMasterTable", "Lcom/appnew/android/table/CourseTypeMasterTable;", Const.POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IOnCourseClickListener {
    void onCourseItemClick(CourseTypeMasterTable courseTypeMasterTable, int position);
}
