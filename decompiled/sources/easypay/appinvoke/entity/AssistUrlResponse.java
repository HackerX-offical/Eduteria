package easypay.appinvoke.entity;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class AssistUrlResponse {

    @SerializedName("operations")
    private ArrayList<Operation> operations = null;

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public ArrayList<Operation> getOperations() {
        return this.operations;
    }

    public void setOperations(ArrayList<Operation> arrayList) {
        this.operations = arrayList;
    }
}
