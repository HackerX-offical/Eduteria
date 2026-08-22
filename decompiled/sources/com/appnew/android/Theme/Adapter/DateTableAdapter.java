package com.appnew.android.Theme.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.TimeTable.Data;
import com.appnew.android.Utils.Const;
import com.appnew.android.Zoom.ItemClickListener;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: DateTableAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dBG\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DateTableAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Theme/Adapter/DateTableAdapter$ViewHolder;", "dateArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "data", "Lcom/appnew/android/Model/TimeTable/Data;", "context", "Landroid/app/Activity;", "itemClickListener", "Lcom/appnew/android/Zoom/ItemClickListener;", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Landroid/app/Activity;Lcom/appnew/android/Zoom/ItemClickListener;)V", "getContext", "()Landroid/app/Activity;", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DateTableAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final Activity context;
    private final ArrayList<Data> data;
    private final ArrayList<String> dateArray;
    private ItemClickListener itemClickListener;
    private Integer pos;

    public DateTableAdapter(ArrayList<String> dateArray, ArrayList<Data> data, Activity context, ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(dateArray, "dateArray");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.dateArray = dateArray;
        this.data = data;
        this.context = context;
        this.itemClickListener = itemClickListener;
        this.pos = 0;
    }

    public final Activity getContext() {
        return this.context;
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
            holder.getTimeTableDate().setBackgroundColor(this.context.getResources().getColor(R.color.light_quiz_grey));
        }
        holder.getTimeTableDate().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Theme.Adapter.DateTableAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateTableAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
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
    public static final void onBindViewHolder$lambda$0(DateTableAdapter dateTableAdapter, int i, View view) {
        dateTableAdapter.pos = Integer.valueOf(i);
        dateTableAdapter.notifyDataSetChanged();
        ArrayList<Data> arrayList = new ArrayList<>();
        arrayList.clear();
        try {
            int size = dateTableAdapter.data.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (dateTableAdapter.data.get(i2).getDate().equals(dateTableAdapter.dateArray.get(i))) {
                    arrayList.add(dateTableAdapter.data.get(i2));
                }
            }
        } catch (Exception unused) {
        }
        ItemClickListener itemClickListener = dateTableAdapter.itemClickListener;
        if (itemClickListener != null) {
            itemClickListener.onClickTimeTableDate(arrayList, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dateArray.size();
    }

    /* JADX INFO: compiled from: DateTableAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/appnew/android/Theme/Adapter/DateTableAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "timeTableDate", "Landroid/widget/TextView;", "getTimeTableDate", "()Landroid/widget/TextView;", "setTimeTableDate", "(Landroid/widget/TextView;)V", "underLine", "getUnderLine", "()Landroid/view/View;", "setUnderLine", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
