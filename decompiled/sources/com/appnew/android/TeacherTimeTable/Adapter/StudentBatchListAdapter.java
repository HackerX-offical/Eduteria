package com.appnew.android.TeacherTimeTable.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.StudentModel.Data;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: StudentBatchListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Adapter/StudentBatchListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/TeacherTimeTable/Adapter/StudentBatchListAdapter$ViewHolder;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/StudentModel/Data;", "context", "Landroid/app/Activity;", "<init>", "(Ljava/util/ArrayList;Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StudentBatchListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final Activity context;
    private final ArrayList<Data> data;
    private Integer pos;

    public StudentBatchListAdapter(ArrayList<Data> data, Activity context) {
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
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_student_batch_list, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getStudentName().setText(this.data.get(position).getName());
        holder.getBatchName().setText(this.data.get(position).getBatchName());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: StudentBatchListAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Adapter/StudentBatchListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "studentName", "Landroid/widget/TextView;", "getStudentName", "()Landroid/widget/TextView;", "setStudentName", "(Landroid/widget/TextView;)V", "studentImage", "Landroid/widget/ImageView;", "getStudentImage", "()Landroid/widget/ImageView;", "setStudentImage", "(Landroid/widget/ImageView;)V", "batchName", "getBatchName", "setBatchName", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private TextView batchName;
        private ImageView studentImage;
        private TextView studentName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.studentName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.studentName = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.studentImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.studentImage = (ImageView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.batch_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.batchName = (TextView) viewFindViewById3;
        }

        public final TextView getStudentName() {
            return this.studentName;
        }

        public final void setStudentName(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.studentName = textView;
        }

        public final ImageView getStudentImage() {
            return this.studentImage;
        }

        public final void setStudentImage(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.studentImage = imageView;
        }

        public final TextView getBatchName() {
            return this.batchName;
        }

        public final void setBatchName(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.batchName = textView;
        }
    }
}
