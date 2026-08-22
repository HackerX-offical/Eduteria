package com.appnew.android.Zoom.Activity;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appnew.android.Model.ZoomModel.DoubtData;
import com.appnew.android.Model.ZoomModel.DoubtDetail;
import com.appnew.android.Model.ZoomModel.DoubtSubject;
import com.appnew.android.Model.ZoomModel.DoubtSubjectDetail;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Zoom.Adapter.AllDoubtAdapter;
import com.appnew.android.Zoom.Adapter.CustomAdapter;
import com.appnew.android.Zoom.ItemClickListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AllDoubtsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010]\u001a\u00020^\"\u0004\b\u0000\u0010_*\n\u0012\u0004\u0012\u0002H_\u0018\u00010 H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000\"\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\"\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\".\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\"\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\"\u001e\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102\"\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109\"\u000e\u0010:\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\"\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\".\u0010G\u001a\u0016\u0012\u0004\u0012\u00020B\u0018\u00010 j\n\u0012\u0004\u0012\u00020B\u0018\u0001`\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010$\"\u0004\bI\u0010&\"\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O\"\u001c\u0010P\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T\"\u001c\u0010U\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010R\"\u0004\bW\u0010T\"\u001a\u0010X\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010R\"\u0004\bZ\u0010T\"\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"ARG_PARAM1", "", "ARG_PARAM2", "subject", "", "[Ljava/lang/String;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager1", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/CustomAdapter$ViewHolder;", "allDoubtAdapter", "Lcom/appnew/android/Zoom/Adapter/AllDoubtAdapter$ViewHolder;", "no_data_found_RL", "Landroid/widget/RelativeLayout;", "recyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "doubt_list_recycler", "paginationLoader", "Landroid/widget/ProgressBar;", "getPaginationLoader", "()Landroid/widget/ProgressBar;", "setPaginationLoader", "(Landroid/widget/ProgressBar;)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "doubtDetailData", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/DoubtData;", "Lkotlin/collections/ArrayList;", "getDoubtDetailData", "()Ljava/util/ArrayList;", "setDoubtDetailData", "(Ljava/util/ArrayList;)V", "doubtDetail", "Lcom/appnew/android/Model/ZoomModel/DoubtDetail;", "getDoubtDetail", "()Lcom/appnew/android/Model/ZoomModel/DoubtDetail;", "setDoubtDetail", "(Lcom/appnew/android/Model/ZoomModel/DoubtDetail;)V", "time", "", "getTime", "()Ljava/lang/Long;", "setTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "status", "", "getStatus", "()Z", "setStatus", "(Z)V", "isPaginationAvailable", "doubtSubjectDetail", "Lcom/appnew/android/Model/ZoomModel/DoubtSubjectDetail;", "getDoubtSubjectDetail", "()Lcom/appnew/android/Model/ZoomModel/DoubtSubjectDetail;", "setDoubtSubjectDetail", "(Lcom/appnew/android/Model/ZoomModel/DoubtSubjectDetail;)V", "doubtSubject", "Lcom/appnew/android/Model/ZoomModel/DoubtSubject;", "getDoubtSubject", "()Lcom/appnew/android/Model/ZoomModel/DoubtSubject;", "setDoubtSubject", "(Lcom/appnew/android/Model/ZoomModel/DoubtSubject;)V", "doubtSubjectArray", "getDoubtSubjectArray", "setDoubtSubjectArray", "itemClickListener", "Lcom/appnew/android/Zoom/ItemClickListener;", "getItemClickListener", "()Lcom/appnew/android/Zoom/ItemClickListener;", "setItemClickListener", "(Lcom/appnew/android/Zoom/ItemClickListener;)V", "subjectId", "getSubjectId", "()Ljava/lang/String;", "setSubjectId", "(Ljava/lang/String;)V", "topicId", "getTopicId", "setTopicId", "clicktype", "getClicktype", "setClicktype", "pullToReferesh", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "add", "", ExifInterface.LONGITUDE_EAST, "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AllDoubtsFragmentKt {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static RecyclerView.Adapter<CustomAdapter.ViewHolder> adapter;
    private static RecyclerView.Adapter<AllDoubtAdapter.ViewHolder> allDoubtAdapter;
    private static DoubtDetail doubtDetail;
    private static ArrayList<DoubtData> doubtDetailData;
    private static DoubtSubject doubtSubject;
    private static ArrayList<DoubtSubject> doubtSubjectArray;
    private static DoubtSubjectDetail doubtSubjectDetail;
    private static RecyclerView doubt_list_recycler;
    private static ItemClickListener itemClickListener;
    private static RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.LayoutManager layoutManager1;
    private static NetworkCall networkCall;
    private static RelativeLayout no_data_found_RL;
    private static ProgressBar paginationLoader;
    private static SwipeRefreshLayout pullToReferesh;
    private static RecyclerView recyclerview;
    private static boolean status;
    private static String subjectId;
    private static Long time;
    private static String topicId;
    private static final String[] subject = {"All", "English", "Hindi", "Math", "Science", "Sanskrit", "Social Science"};
    private static boolean isPaginationAvailable = true;
    private static String clicktype = "";

    public static final ProgressBar getPaginationLoader() {
        return paginationLoader;
    }

    public static final void setPaginationLoader(ProgressBar progressBar) {
        paginationLoader = progressBar;
    }

    public static final NetworkCall getNetworkCall() {
        return networkCall;
    }

    public static final void setNetworkCall(NetworkCall networkCall2) {
        networkCall = networkCall2;
    }

    public static final ArrayList<DoubtData> getDoubtDetailData() {
        return doubtDetailData;
    }

    public static final void setDoubtDetailData(ArrayList<DoubtData> arrayList) {
        doubtDetailData = arrayList;
    }

    public static final DoubtDetail getDoubtDetail() {
        return doubtDetail;
    }

    public static final void setDoubtDetail(DoubtDetail doubtDetail2) {
        doubtDetail = doubtDetail2;
    }

    public static final Long getTime() {
        return time;
    }

    public static final void setTime(Long l) {
        time = l;
    }

    public static final boolean getStatus() {
        return status;
    }

    public static final void setStatus(boolean z) {
        status = z;
    }

    public static final DoubtSubjectDetail getDoubtSubjectDetail() {
        return doubtSubjectDetail;
    }

    public static final void setDoubtSubjectDetail(DoubtSubjectDetail doubtSubjectDetail2) {
        doubtSubjectDetail = doubtSubjectDetail2;
    }

    public static final DoubtSubject getDoubtSubject() {
        return doubtSubject;
    }

    public static final void setDoubtSubject(DoubtSubject doubtSubject2) {
        doubtSubject = doubtSubject2;
    }

    public static final ArrayList<DoubtSubject> getDoubtSubjectArray() {
        return doubtSubjectArray;
    }

    public static final void setDoubtSubjectArray(ArrayList<DoubtSubject> arrayList) {
        doubtSubjectArray = arrayList;
    }

    public static final ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public static final void setItemClickListener(ItemClickListener itemClickListener2) {
        itemClickListener = itemClickListener2;
    }

    public static final String getSubjectId() {
        return subjectId;
    }

    public static final void setSubjectId(String str) {
        subjectId = str;
    }

    public static final String getTopicId() {
        return topicId;
    }

    public static final void setTopicId(String str) {
        topicId = str;
    }

    public static final String getClicktype() {
        return clicktype;
    }

    public static final void setClicktype(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        clicktype = str;
    }

    private static final <E> void add(ArrayList<E> arrayList) {
        DoubtSubject doubtSubject2;
        DoubtSubject doubtSubject3;
        DoubtSubject doubtSubject4;
        ArrayList<DoubtSubject> arrayList2 = doubtSubjectArray;
        if (arrayList2 != null && (doubtSubject4 = arrayList2.get(0)) != null) {
            doubtSubject4.setId("1");
        }
        ArrayList<DoubtSubject> arrayList3 = doubtSubjectArray;
        if (arrayList3 != null && (doubtSubject3 = arrayList3.get(0)) != null) {
            doubtSubject3.setPosition("0");
        }
        ArrayList<DoubtSubject> arrayList4 = doubtSubjectArray;
        if (arrayList4 == null || (doubtSubject2 = arrayList4.get(0)) == null) {
            return;
        }
        doubtSubject2.setName("All");
    }
}
