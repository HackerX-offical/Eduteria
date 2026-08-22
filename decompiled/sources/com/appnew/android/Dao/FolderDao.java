package com.appnew.android.Dao;

import com.appnew.android.table.FolderEntity;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface FolderDao {
    long addFolderData(FolderEntity folderEntity);

    void deleteData();

    void deleteDataParticular(String hitCount);

    List<FolderEntity> getAllUser();

    FolderEntity getParticularData(String hitCount);

    boolean hasFolderData(String hitCount);
}
