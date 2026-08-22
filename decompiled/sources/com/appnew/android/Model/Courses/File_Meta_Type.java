package com.appnew.android.Model.Courses;

import com.appnew.android.Model.Courses.Curriculam;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class File_Meta_Type implements Serializable {
    ArrayList<Curriculam.File_meta> fileMetaArrayList;
    String filetype;

    public String getFiletype() {
        return this.filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public ArrayList<Curriculam.File_meta> getFileMetaArrayList() {
        return this.fileMetaArrayList;
    }

    public void setFileMetaArrayList(ArrayList<Curriculam.File_meta> fileMetaArrayList) {
        this.fileMetaArrayList = fileMetaArrayList;
    }

    public void addFileMetaType(Curriculam.File_meta fileMeta) {
        ArrayList<Curriculam.File_meta> arrayList = this.fileMetaArrayList;
        if (arrayList != null && arrayList.size() > 0) {
            this.fileMetaArrayList.add(fileMeta);
            return;
        }
        ArrayList<Curriculam.File_meta> arrayList2 = new ArrayList<>();
        this.fileMetaArrayList = arrayList2;
        arrayList2.add(fileMeta);
    }
}
