package com.appnew.android.Model.COURSEDETAIL;

import com.appnew.android.Model.Courses.InstallmentResponse;
import com.appnew.android.Model.subscription.SubscriptionAllData;
import com.appnew.android.Utils.Const;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class Data implements Serializable {

    @SerializedName(Const.COURSE_DETAIL)
    private CourseDetailData courseDetail;

    @SerializedName("instalment")
    private InstallmentResponse instalment;

    @SerializedName("subscription_all_data")
    private SubscriptionAllData subscriptionAllData;
    private List<TilesItem> tiles;

    public SubscriptionAllData getSubscriptionAllData() {
        return this.subscriptionAllData;
    }

    public void setSubscriptionAllData(SubscriptionAllData subscriptionAllData) {
        this.subscriptionAllData = subscriptionAllData;
    }

    public InstallmentResponse getInstalment() {
        return this.instalment;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            Data data = (Data) o;
            if (Objects.equals(this.tiles, data.tiles) && Objects.equals(this.courseDetail, data.courseDetail) && Objects.equals(this.instalment, data.instalment)) {
                return true;
            }
        }
        return false;
    }

    public void setInstalment(InstallmentResponse instalment) {
        this.instalment = instalment;
    }

    public List<TilesItem> getTiles() {
        return this.tiles;
    }

    public CourseDetailData getCourseDetail() {
        return this.courseDetail;
    }

    public void setTiles(List<TilesItem> tiles) {
        this.tiles = tiles;
    }

    public void setCourseDetail(CourseDetailData courseDetail) {
        this.courseDetail = courseDetail;
    }
}
