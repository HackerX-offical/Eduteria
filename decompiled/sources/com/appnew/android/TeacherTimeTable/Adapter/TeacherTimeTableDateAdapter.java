package com.appnew.android.TeacherTimeTable.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.TeacherTimeTable.BatchTimetable;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: TeacherTimeTableDateAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherTimeTableDateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherTimeTableDateAdapter$ViewHolder;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/TeacherTimeTable/BatchTimetable;", "context", "Landroid/app/Activity;", "<init>", "(Ljava/util/ArrayList;Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TeacherTimeTableDateAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final Activity context;
    private final ArrayList<BatchTimetable> data;
    private Integer pos;

    public TeacherTimeTableDateAdapter(ArrayList<BatchTimetable> data, Activity context) {
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
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_timetable_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, int position) {
        List listEmptyList;
        List listEmptyList2;
        List listEmptyList3;
        List listEmptyList4;
        List listEmptyList5;
        List listEmptyList6;
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<String> listSplit = new Regex(":").split(this.data.get(position).getStartTime(), 0);
        if (listSplit.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        int i = Integer.parseInt(((String[]) listEmptyList.toArray(new String[0]))[0]);
        List<String> listSplit2 = new Regex(":").split(this.data.get(position).getEndTime(), 0);
        if (listSplit2.isEmpty()) {
            listEmptyList2 = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
            while (listIterator2.hasPrevious()) {
                if (listIterator2.previous().length() != 0) {
                    listEmptyList2 = CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList2 = CollectionsKt.emptyList();
        }
        int i2 = Integer.parseInt(((String[]) listEmptyList2.toArray(new String[0]))[0]);
        String str = i >= 12 ? "PM" : "AM";
        String str2 = i2 < 12 ? "AM" : "PM";
        TextView timeTableDate = holder.getTimeTableDate();
        List<String> listSplit3 = new Regex(":").split(this.data.get(position).getStartTime(), 0);
        if (listSplit3.isEmpty()) {
            listEmptyList3 = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator3 = listSplit3.listIterator(listSplit3.size());
            while (listIterator3.hasPrevious()) {
                if (listIterator3.previous().length() != 0) {
                    listEmptyList3 = CollectionsKt.take(listSplit3, listIterator3.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList3 = CollectionsKt.emptyList();
        }
        String str3 = ((String[]) listEmptyList3.toArray(new String[0]))[0];
        List<String> listSplit4 = new Regex(":").split(this.data.get(position).getStartTime(), 0);
        if (listSplit4.isEmpty()) {
            listEmptyList4 = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator4 = listSplit4.listIterator(listSplit4.size());
            while (listIterator4.hasPrevious()) {
                if (listIterator4.previous().length() != 0) {
                    listEmptyList4 = CollectionsKt.take(listSplit4, listIterator4.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList4 = CollectionsKt.emptyList();
        }
        String str4 = ((String[]) listEmptyList4.toArray(new String[0]))[1];
        List<String> listSplit5 = new Regex(":").split(this.data.get(position).getEndTime(), 0);
        if (listSplit5.isEmpty()) {
            listEmptyList5 = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator5 = listSplit5.listIterator(listSplit5.size());
            while (listIterator5.hasPrevious()) {
                if (listIterator5.previous().length() != 0) {
                    listEmptyList5 = CollectionsKt.take(listSplit5, listIterator5.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList5 = CollectionsKt.emptyList();
        }
        String str5 = ((String[]) listEmptyList5.toArray(new String[0]))[0];
        List<String> listSplit6 = new Regex(":").split(this.data.get(position).getStartTime(), 0);
        if (listSplit6.isEmpty()) {
            listEmptyList6 = CollectionsKt.emptyList();
        } else {
            ListIterator<String> listIterator6 = listSplit6.listIterator(listSplit6.size());
            while (listIterator6.hasPrevious()) {
                if (listIterator6.previous().length() != 0) {
                    listEmptyList6 = CollectionsKt.take(listSplit6, listIterator6.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList6 = CollectionsKt.emptyList();
        }
        timeTableDate.setText(str3 + ":" + str4 + " " + str + " to " + str5 + ":" + ((String[]) listEmptyList6.toArray(new String[0]))[1] + " " + str2);
        holder.getTimeTableTitle().setText(this.data.get(position).getTitle());
        holder.getTimeTableTeacherCode().setText(this.data.get(position).getSubjectName());
        holder.getCenterName().setText("Center : " + this.data.get(position).getTestCenterName());
        holder.getCourseName().setText("Course : " + this.data.get(position).getCourseName());
        holder.getCourseTimeTableview().setVisibility(0);
        holder.getCenterDetailLL().setVisibility(0);
        holder.getViewCenterDetails().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TeacherTimeTable.Adapter.TeacherTimeTableDateAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeacherTimeTableDateAdapter.onBindViewHolder$lambda$6(holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$6(ViewHolder viewHolder, View view) {
        viewHolder.getCourseTimeTableview().setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: TeacherTimeTableDateAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0005R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherTimeTableDateAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "timeTableDate", "Landroid/widget/TextView;", "getTimeTableDate", "()Landroid/widget/TextView;", "setTimeTableDate", "(Landroid/widget/TextView;)V", "timeTableTitle", "getTimeTableTitle", "setTimeTableTitle", "timeTableTeacherCode", "getTimeTableTeacherCode", "setTimeTableTeacherCode", "centerName", "getCenterName", "setCenterName", "courseName", "getCourseName", "setCourseName", "centerDetailLL", "Landroid/widget/LinearLayout;", "getCenterDetailLL", "()Landroid/widget/LinearLayout;", "setCenterDetailLL", "(Landroid/widget/LinearLayout;)V", "courseTimeTableview", "getCourseTimeTableview", "()Landroid/view/View;", "setCourseTimeTableview", "viewCenterDetails", "Landroid/widget/ImageView;", "getViewCenterDetails", "()Landroid/widget/ImageView;", "setViewCenterDetails", "(Landroid/widget/ImageView;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private LinearLayout centerDetailLL;
        private TextView centerName;
        private TextView courseName;
        private View courseTimeTableview;
        private TextView timeTableDate;
        private TextView timeTableTeacherCode;
        private TextView timeTableTitle;
        private ImageView viewCenterDetails;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.timeTableDate);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.timeTableDate = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.timeTableTitle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.timeTableTitle = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.timeTableTeacherCode);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.timeTableTeacherCode = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.centerName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.centerName = (TextView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.courseName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.courseName = (TextView) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.centerDetailLL);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.centerDetailLL = (LinearLayout) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.courseTimeTableview);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.courseTimeTableview = viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.viewCenterDetails);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.viewCenterDetails = (ImageView) viewFindViewById8;
        }

        public final TextView getTimeTableDate() {
            return this.timeTableDate;
        }

        public final void setTimeTableDate(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.timeTableDate = textView;
        }

        public final TextView getTimeTableTitle() {
            return this.timeTableTitle;
        }

        public final void setTimeTableTitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.timeTableTitle = textView;
        }

        public final TextView getTimeTableTeacherCode() {
            return this.timeTableTeacherCode;
        }

        public final void setTimeTableTeacherCode(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.timeTableTeacherCode = textView;
        }

        public final TextView getCenterName() {
            return this.centerName;
        }

        public final void setCenterName(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.centerName = textView;
        }

        public final TextView getCourseName() {
            return this.courseName;
        }

        public final void setCourseName(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.courseName = textView;
        }

        public final LinearLayout getCenterDetailLL() {
            return this.centerDetailLL;
        }

        public final void setCenterDetailLL(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.centerDetailLL = linearLayout;
        }

        public final View getCourseTimeTableview() {
            return this.courseTimeTableview;
        }

        public final void setCourseTimeTableview(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.courseTimeTableview = view;
        }

        public final ImageView getViewCenterDetails() {
            return this.viewCenterDetails;
        }

        public final void setViewCenterDetails(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.viewCenterDetails = imageView;
        }
    }
}
