package com.appnew.android.Theme.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.TimeTable.Data;
import com.appnew.android.TeacherTimeTable.Activity.StudentListActivity;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
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
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: TimeTableDateAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\b\b\u0001\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\""}, d2 = {"Lcom/appnew/android/Theme/Adapter/TimeTableDateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Theme/Adapter/TimeTableDateAdapter$ViewHolder;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/TimeTable/Data;", "context", "Landroid/app/Activity;", "<init>", "(Ljava/util/ArrayList;Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "state", "", "getState", "()Z", "setState", "(Z)V", "state1", "getState1", "setState1", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeTableDateAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final Activity context;
    private final ArrayList<Data> data;
    private Integer pos;
    private boolean state;
    private boolean state1;

    public TimeTableDateAdapter(ArrayList<Data> data, Activity context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = data;
        this.context = context;
        this.pos = 0;
    }

    public final Activity getContext() {
        return this.context;
    }

    public final boolean getState() {
        return this.state;
    }

    public final void setState(boolean z) {
        this.state = z;
    }

    public final boolean getState1() {
        return this.state1;
    }

    public final void setState1(boolean z) {
        this.state1 = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_timetable_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        List listEmptyList;
        List listEmptyList2;
        List listEmptyList3;
        List listEmptyList4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        TextView timeTableDate = holder.getTimeTableDate();
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
        String str = ((String[]) listEmptyList.toArray(new String[0]))[0];
        List<String> listSplit2 = new Regex(":").split(this.data.get(position).getStartTime(), 0);
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
        String str2 = ((String[]) listEmptyList2.toArray(new String[0]))[1];
        List<String> listSplit3 = new Regex(":").split(this.data.get(position).getEndTime(), 0);
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
        List<String> listSplit4 = new Regex(":").split(this.data.get(position).getEndTime(), 0);
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
        timeTableDate.setText(str + ":" + str2 + " to " + str3 + ":" + ((String[]) listEmptyList4.toArray(new String[0]))[1]);
        holder.getTimeTableTitle().setText(this.data.get(position).getTitle());
        if (StringsKt.equals(this.data.get(position).getType(), "1", true)) {
            String str4 = "";
            for (String str5 : StringsKt.split$default((CharSequence) this.data.get(position).getSubjectName(), new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null)) {
                str4 = StringsKt.equals(str4, "", true) ? str4 + str5 : str4 + ",\n" + str5;
            }
            holder.getTimeTableTeacherCode().setText(Html.fromHtml("<font color=" + Color.parseColor("#007FBE") + ">Doubt Session </font> \n" + str4));
        } else {
            holder.getTimeTableTeacherCode().setText(this.data.get(position).getSubjectName());
        }
        holder.getCenterName().setText("Center : " + this.data.get(position).getTestCenterName());
        if (SharedPreference.getInstance().getBoolean("Expert_key")) {
            holder.getViewCenterDetails().setVisibility(0);
        }
        holder.getViewCenterDetails().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.TimeTableDateAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeTableDateAdapter.onBindViewHolder$lambda$4(this.f$0, holder, view);
            }
        });
        holder.getLinearLayout3().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.TimeTableDateAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimeTableDateAdapter.onBindViewHolder$lambda$5(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4(TimeTableDateAdapter timeTableDateAdapter, ViewHolder viewHolder, View view) {
        if (!timeTableDateAdapter.state) {
            timeTableDateAdapter.state = true;
            viewHolder.getCourseTimeTableview().setVisibility(0);
            viewHolder.getCenterDetailLL().setVisibility(0);
            viewHolder.getViewCenterDetails().setImageResource(R.drawable.sub_button);
            return;
        }
        timeTableDateAdapter.state = false;
        viewHolder.getCourseTimeTableview().setVisibility(8);
        viewHolder.getCenterDetailLL().setVisibility(8);
        viewHolder.getViewCenterDetails().setImageResource(R.drawable.add_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5(TimeTableDateAdapter timeTableDateAdapter, int i, View view) {
        if (SharedPreference.getInstance().getBoolean("Expert_  key")) {
            if (Helper.isNetworkConnected(timeTableDateAdapter.context)) {
                Intent intent = new Intent(timeTableDateAdapter.context, (Class<?>) StudentListActivity.class);
                intent.putExtra("id", timeTableDateAdapter.data.get(i).getBatch());
                timeTableDateAdapter.context.startActivity(intent);
            } else {
                Activity activity = timeTableDateAdapter.context;
                Toast.makeText(activity, activity.getResources().getString(R.string.no_internet_connection), 0).show();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: TimeTableDateAdapter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u0005R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010!\"\u0004\b0\u0010#¨\u00061"}, d2 = {"Lcom/appnew/android/Theme/Adapter/TimeTableDateAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "timeTableDate", "Landroid/widget/TextView;", "getTimeTableDate", "()Landroid/widget/TextView;", "setTimeTableDate", "(Landroid/widget/TextView;)V", "timeTableTitle", "getTimeTableTitle", "setTimeTableTitle", "timeTableTeacherCode", "getTimeTableTeacherCode", "setTimeTableTeacherCode", "centerName", "getCenterName", "setCenterName", "courseName", "getCourseName", "setCourseName", "cancelRl", "Landroid/widget/RelativeLayout;", "getCancelRl", "()Landroid/widget/RelativeLayout;", "setCancelRl", "(Landroid/widget/RelativeLayout;)V", "centerDetailLL", "Landroid/widget/LinearLayout;", "getCenterDetailLL", "()Landroid/widget/LinearLayout;", "setCenterDetailLL", "(Landroid/widget/LinearLayout;)V", "courseTimeTableview", "getCourseTimeTableview", "()Landroid/view/View;", "setCourseTimeTableview", "viewCenterDetails", "Landroid/widget/ImageView;", "getViewCenterDetails", "()Landroid/widget/ImageView;", "setViewCenterDetails", "(Landroid/widget/ImageView;)V", "linearLayout3", "getLinearLayout3", "setLinearLayout3", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private RelativeLayout cancelRl;
        private LinearLayout centerDetailLL;
        private TextView centerName;
        private TextView courseName;
        private View courseTimeTableview;
        private LinearLayout linearLayout3;
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
            View viewFindViewById6 = view.findViewById(R.id.cancelRl);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.cancelRl = (RelativeLayout) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.centerDetailLL);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.centerDetailLL = (LinearLayout) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.courseTimeTableview);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.courseTimeTableview = viewFindViewById8;
            View viewFindViewById9 = view.findViewById(R.id.viewCenterDetails);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.viewCenterDetails = (ImageView) viewFindViewById9;
            View viewFindViewById10 = view.findViewById(R.id.linearLayout3);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            this.linearLayout3 = (LinearLayout) viewFindViewById10;
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

        public final RelativeLayout getCancelRl() {
            return this.cancelRl;
        }

        public final void setCancelRl(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.cancelRl = relativeLayout;
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

        public final LinearLayout getLinearLayout3() {
            return this.linearLayout3;
        }

        public final void setLinearLayout3(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.linearLayout3 = linearLayout;
        }
    }
}
