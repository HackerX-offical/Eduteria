package datamodels;

import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class NetBankingChild implements Serializable {
    private String BankCode;
    private String BankId;
    private int Image;
    private String Name;
    private String image_Path;
    String image_name;

    public String getName() {
        return this.Name;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public int getImage() {
        return this.Image;
    }

    public void setImage(int i) {
        this.Image = i;
    }

    public String getBankId() {
        return this.BankId;
    }

    public void setBankId(String str) {
        this.BankId = str;
    }

    public String getImage_Path() {
        return this.image_Path;
    }

    public void setImage_Path(String str) {
        this.image_Path = str;
    }

    public String getBankCode() {
        return this.BankCode;
    }

    public void setBankCode(String str) {
        this.BankCode = str;
    }

    public NetBankingChild(String str, String str2, String str3) {
        this.Name = str;
        this.BankId = str2;
        this.image_Path = str3;
    }

    public NetBankingChild() {
    }

    public String getImageName() {
        return this.image_name;
    }

    public void setImageName(String str) {
        this.image_name = str;
    }
}
