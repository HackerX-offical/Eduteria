package com.appnew.android.Dao;

import com.appnew.android.table.CourseDetailTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CourseDetailDao {
    long addCoursedetail(CourseDetailTable coursedetail);

    int deletecoursedetail(String courseid, String userid);

    void deletedata();

    List<CourseDetailTable> getcoursedetail(String courseid, String userid);

    boolean isRecordExistsUserId(String userid, String course_id);

    int updaterecord(String courseid, String userid, String is_activate);
}
