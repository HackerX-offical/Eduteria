package com.appnew.android.Dao;

import androidx.sqlite.db.SupportSQLiteQuery;
import com.appnew.android.Model.ExtraJson;
import com.appnew.android.table.CourseDataTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CourseDataDao {
    long addCoursedata(CourseDataTable coursedetail);

    void deleteMultipleId(List<String> ids);

    int deletecoursedata(String main_id, String userid);

    void deletedata();

    List<CourseDataTable> getcoursedata(String main_id, String userid);

    List<CourseDataTable> getcoursedatafilterforfree(String main_id, String userid, String category, String subject_id, String langid);

    List<CourseDataTable> getcoursedatafilterforfree2(SupportSQLiteQuery query);

    List<CourseDataTable> getcoursedatafilterforpaid(String main_id, String userid, String category, String subject_id, String langid);

    List<CourseDataTable> getcoursedatafilterforpaid2(SupportSQLiteQuery query);

    List<CourseDataTable> getcoursedatawithfilter(String main_id, String userid, String category);

    boolean isRecordExistsUserId(String mainid, String userid, String courseid, String type_id);

    void updateExtraJson(String courseId, String mainId, String userId, ExtraJson extraJson);
}
