package datamodels;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class PWEUPIOptionsDataModel {
    ArrayList<PWEUPIPspDataModel> psp_list;
    String lable = "";
    String image = "";
    String key = "";
    String pkg_name = "";
    boolean show_label = false;

    public String getLable() {
        return this.lable;
    }

    public void setLable(String str) {
        this.lable = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public ArrayList<PWEUPIPspDataModel> getPsp_list() {
        return this.psp_list;
    }

    public boolean isShow_label() {
        return this.show_label;
    }

    public void setShow_label(boolean z) {
        this.show_label = z;
    }

    public void setPsp_list(ArrayList<PWEUPIPspDataModel> arrayList) {
        this.psp_list = arrayList;
    }

    public String getPkg_name() {
        return this.pkg_name;
    }

    public void setPkg_name(String str) {
        this.pkg_name = str;
    }
}
