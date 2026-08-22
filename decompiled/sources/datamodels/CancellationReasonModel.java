package datamodels;

/* JADX INFO: loaded from: classes9.dex */
public class CancellationReasonModel {
    int id;
    String reason;
    boolean selected_flag;

    public CancellationReasonModel(int i, String str, boolean z) {
        this.id = i;
        this.reason = str;
        this.selected_flag = z;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public boolean isSelected_flag() {
        return this.selected_flag;
    }

    public void setSelected_flag(boolean z) {
        this.selected_flag = z;
    }
}
