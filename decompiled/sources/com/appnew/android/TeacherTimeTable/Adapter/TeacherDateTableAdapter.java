package com.appnew.android.TeacherTimeTable.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.TeacherTimeTable.BatchTimetable;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: TeacherDateTableAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\b\b\u0001\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006!"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherDateTableAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherDateTableAdapter$ViewHolder;", "dateArray", "Ljava/util/ArrayList;", "", "data", "Lcom/appnew/android/Model/TeacherTimeTable/BatchTimetable;", "context", "Landroid/app/Activity;", "itemClickListener", "Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherTimeTableAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Landroid/app/Activity;Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherTimeTableAdapter;Landroidx/recyclerview/widget/RecyclerView;)V", "getContext", "()Landroid/app/Activity;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TeacherDateTableAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final Activity context;
    private final ArrayList<BatchTimetable> data;
    private final ArrayList<String> dateArray;
    private TeacherTimeTableAdapter itemClickListener;
    private Integer pos;
    private final RecyclerView recyclerView;

    public TeacherDateTableAdapter(ArrayList<String> dateArray, ArrayList<BatchTimetable> data, Activity context, TeacherTimeTableAdapter itemClickListener, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(dateArray, "dateArray");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.dateArray = dateArray;
        this.data = data;
        this.context = context;
        this.itemClickListener = itemClickListener;
        this.recyclerView = recyclerView;
        this.pos = 0;
    }

    public final Activity getContext() {
        return this.context;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_date_table, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getTimeTableDate().setText(this.dateArray.get(position));
        Integer num = this.pos;
        if (num != null && num.intValue() == position) {
            holder.getTimeTableDate().setTextColor(Color.parseColor("#FFFFFF"));
            holder.getTimeTableDate().setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.common_round_corners_button_drawable));
        } else {
            holder.getTimeTableDate().setTextColor(Color.parseColor("#7f7f7f"));
        }
        holder.getTimeTableDate().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TeacherTimeTable.Adapter.TeacherDateTableAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeacherDateTableAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void onBindViewHolder$lambda$0(TeacherDateTableAdapter teacherDateTableAdapter, int i, View view) {
        teacherDateTableAdapter.pos = Integer.valueOf(i);
        teacherDateTableAdapter.notifyDataSetChanged();
        ArrayList<BatchTimetable> arrayList = new ArrayList<>();
        try {
            int size = teacherDateTableAdapter.data.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (teacherDateTableAdapter.data.get(i2).getDate().equals(teacherDateTableAdapter.dateArray.get(i))) {
                    arrayList.add(teacherDateTableAdapter.data.get(i2));
                }
            }
        } catch (Exception unused) {
        }
        teacherDateTableAdapter.itemClickListener.onClickTimeTableDate(arrayList, i, teacherDateTableAdapter.recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dateArray.size();
    }

    /* JADX INFO: compiled from: TeacherDateTableAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Adapter/TeacherDateTableAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "timeTableDate", "Landroid/widget/TextView;", "getTimeTableDate", "()Landroid/widget/TextView;", "setTimeTableDate", "(Landroid/widget/TextView;)V", "underLine", "getUnderLine", "()Landroid/view/View;", "setUnderLine", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private TextView timeTableDate;
        private View underLine;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.dateItem);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.timeTableDate = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.underLine);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.underLine = viewFindViewById2;
        }

        public final TextView getTimeTableDate() {
            return this.timeTableDate;
        }

        public final void setTimeTableDate(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.timeTableDate = textView;
        }

        public final View getUnderLine() {
            return this.underLine;
        }

        public final void setUnderLine(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.underLine = view;
        }
    }
}
