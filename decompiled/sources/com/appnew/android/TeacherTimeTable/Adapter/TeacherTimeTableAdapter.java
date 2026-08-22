package com.appnew.android.TeacherTimeTable.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.TeacherTimeTable.BatchTimetable;
import com.appnew.android.Model.TeacherTimeTable.Data;
import com.appnew.android.TeacherTimeTable.Interface.DateItemClick;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: TeacherTimeTableAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001 B'\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u000fH\u0016J4\u0010\u0019\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0005j\b\u0012\u0004\u0012\u00020\u001b`\u00072\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0016J0\u0010\u001d\u001a\u00020\u00162\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0005j\b\u0012\u0004\u0012\u00020\u001b`\u00072\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006!"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherTimeTableAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherTimeTableAdapter$ViewHolder;", "Lcom/appnew/android/TeacherTimeTable/Interface/DateItemClick;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/TeacherTimeTable/Data;", "Lkotlin/collections/ArrayList;", "context", "Landroid/app/Activity;", "<init>", "(Ljava/util/ArrayList;Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "setTimeSlot", "batchTimetable", "Lcom/appnew/android/Model/TeacherTimeTable/BatchTimetable;", "getItemCount", "onClickTimeTableDate", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TeacherTimeTableAdapter extends RecyclerView.Adapter<ViewHolder> implements DateItemClick {
    public static final int $stable = 8;
    private final Activity context;
    private final ArrayList<Data> data;
    private Integer pos;

    public TeacherTimeTableAdapter(ArrayList<Data> data, Activity context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = data;
        this.context = context;
        this.pos = 0;
    }

    public final Activity getContext() {
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_user_timetable, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBatchId().setText(this.data.get(position).getTitle());
        holder.getBatchRL().setVisibility(0);
        setTimeSlot(holder, this.data.get(position).getBatchTimetable(), position);
    }

    private final void setTimeSlot(ViewHolder holder, ArrayList<BatchTimetable> batchTimetable, int position) {
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.data.size();
        if (size >= 0) {
            int i = 0;
            while (true) {
                arrayList.add(this.data.get(position).getBatchTimetable().get(i).getDate());
                if (i == size) {
                    break;
                } else {
                    i++;
                }
            }
        }
        linkedHashSet.addAll(arrayList);
        arrayList.clear();
        arrayList.addAll(linkedHashSet);
        Activity activity = this.context;
        RecyclerView timeTableRecycler = holder.getTimeTableRecycler();
        Intrinsics.checkNotNullExpressionValue(timeTableRecycler, "<get-timeTableRecycler>(...)");
        TeacherDateTableAdapter teacherDateTableAdapter = new TeacherDateTableAdapter(arrayList, batchTimetable, activity, this, timeTableRecycler);
        holder.getDateTableRecycler().setLayoutManager(new LinearLayoutManager(this.context, 0, false));
        holder.getDateTableRecycler().setAdapter(teacherDateTableAdapter);
        holder.getDateTableRecycler().setNestedScrollingEnabled(false);
        ArrayList arrayList2 = new ArrayList();
        int size2 = batchTimetable.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (Intrinsics.areEqual(batchTimetable.get(0).getDate(), batchTimetable.get(i2).getDate())) {
                arrayList2.add(batchTimetable.get(i2));
            }
        }
        TeacherTimeTableDateAdapter teacherTimeTableDateAdapter = new TeacherTimeTableDateAdapter(arrayList2, this.context);
        holder.getTimeTableRecycler().setLayoutManager(new LinearLayoutManager(this.context));
        holder.getTimeTableRecycler().setAdapter(teacherTimeTableDateAdapter);
        holder.getTimeTableRecycler().setNestedScrollingEnabled(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: TeacherTimeTableAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\n \u0019*\u0004\u0018\u00010\u00130\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherTimeTableAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherTimeTableAdapter;Landroid/view/View;)V", "batchRL", "Landroid/widget/RelativeLayout;", "getBatchRL", "()Landroid/widget/RelativeLayout;", "setBatchRL", "(Landroid/widget/RelativeLayout;)V", "batchId", "Landroid/widget/TextView;", "getBatchId", "()Landroid/widget/TextView;", "setBatchId", "(Landroid/widget/TextView;)V", "DateTableRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "getDateTableRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setDateTableRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "timeTableRecycler", "kotlin.jvm.PlatformType", "getTimeTableRecycler", "setTimeTableRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView DateTableRecycler;
        private TextView batchId;
        private RelativeLayout batchRL;
        final /* synthetic */ TeacherTimeTableAdapter this$0;
        private RecyclerView timeTableRecycler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(TeacherTimeTableAdapter teacherTimeTableAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = teacherTimeTableAdapter;
            View viewFindViewById = view.findViewById(R.id.batchRL);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.batchRL = (RelativeLayout) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.batchId);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.batchId = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.DateTableRecycler);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.DateTableRecycler = (RecyclerView) viewFindViewById3;
            this.timeTableRecycler = (RecyclerView) view.findViewById(R.id.timeTableRecycler);
        }

        public final RelativeLayout getBatchRL() {
            return this.batchRL;
        }

        public final void setBatchRL(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.batchRL = relativeLayout;
        }

        public final TextView getBatchId() {
            return this.batchId;
        }

        public final void setBatchId(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.batchId = textView;
        }

        public final RecyclerView getDateTableRecycler() {
            return this.DateTableRecycler;
        }

        public final void setDateTableRecycler(RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.DateTableRecycler = recyclerView;
        }

        public final RecyclerView getTimeTableRecycler() {
            return this.timeTableRecycler;
        }

        public final void setTimeTableRecycler(RecyclerView recyclerView) {
            this.timeTableRecycler = recyclerView;
        }
    }

    @Override // com.appnew.android.TeacherTimeTable.Interface.DateItemClick
    public void onClickTimeTableDate(ArrayList<BatchTimetable> data, int position, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        TeacherTimeTableDateAdapter teacherTimeTableDateAdapter = new TeacherTimeTableDateAdapter(data, this.context);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        recyclerView.setAdapter(teacherTimeTableDateAdapter);
        recyclerView.setNestedScrollingEnabled(false);
    }
}
