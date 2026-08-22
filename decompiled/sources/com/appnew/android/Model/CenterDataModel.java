package com.appnew.android.Model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class CenterDataModel {
    Data data;
    String message;
    boolean status;

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String toString() {
        return "CenterDataModel{status=" + this.status + ", message='" + this.message + "', data=" + this.data + '}';
    }

    public class Data {
        ArrayList<ClassStateAndCenterList> class_center;
        ArrayList<ClassStateAndCenterList> test_center;

        public Data() {
        }

        public ArrayList<ClassStateAndCenterList> getClass_center() {
            return this.class_center;
        }

        public void setClass_center(ArrayList<ClassStateAndCenterList> class_center) {
            this.class_center = class_center;
        }

        public ArrayList<ClassStateAndCenterList> getTest_center() {
            return this.test_center;
        }

        public void setTest_center(ArrayList<ClassStateAndCenterList> test_center) {
            this.test_center = test_center;
        }

        public String toString() {
            return "Data{class_center=" + this.class_center + ", test_center=" + this.test_center + '}';
        }
    }
}
