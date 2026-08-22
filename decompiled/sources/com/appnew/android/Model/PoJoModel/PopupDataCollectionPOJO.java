package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class PopupDataCollectionPOJO implements Serializable {
    String course_id;
    String popup_id;

    public PopupDataCollectionPOJO(String popup_id, String course_id) {
        this.popup_id = popup_id;
        this.course_id = course_id;
    }

    public String getPopup_id() {
        return this.popup_id;
    }

    public void setPopup_id(String popup_id) {
        this.popup_id = popup_id;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
