package datamodels;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class NetBankingGroupModel implements Serializable {
    private ArrayList<NetBankingChild> Items;
    private String Name;

    public String getName() {
        return this.Name;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public ArrayList<NetBankingChild> getItems() {
        return this.Items;
    }

    public void setItems(ArrayList<NetBankingChild> arrayList) {
        this.Items = arrayList;
    }
}
