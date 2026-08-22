package com.appnew.android.Dao;

import com.appnew.android.table.CourseTypeMasterTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CourseTypeMasterDao {
    long addUser(CourseTypeMasterTable courseTypeMasterTable);

    int deleteUser(CourseTypeMasterTable courseTypeMasterTable);

    void deletedata();

    List<CourseTypeMasterTable> getAllUser();

    List<CourseTypeMasterTable> getcourse_typemaster(String userid);

    int updateUser(CourseTypeMasterTable courseTypeMasterTable);
}
