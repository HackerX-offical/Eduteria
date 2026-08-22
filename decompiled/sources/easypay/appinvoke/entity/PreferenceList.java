package easypay.appinvoke.entity;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class PreferenceList {

    @SerializedName("prefList")
    private List<AssistDetailsResponse> prefList = new ArrayList();

    public List<AssistDetailsResponse> getPrefList() {
        return this.prefList;
    }

    public void setPrefList(List<AssistDetailsResponse> list) {
        this.prefList = list;
    }
}
