package com.appnew.android.Zoom.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.ZoomModel.CurrentAffairData;
import com.appnew.android.Model.ZoomModel.CurrentAffairDataModel;
import com.appnew.android.Utils.Const;
import com.appnew.android.Zoom.ItemClickListener;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: CurrentAffairCategoryAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0001\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0014\u0010\u0016\u001a\u00020\u00122\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/CurrentAffairCategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/CurrentAffairCategoryAdapter$ViewHolder;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/CurrentAffairData;", "itemClickListener", "Lcom/appnew/android/Zoom/ItemClickListener;", "<init>", "(Ljava/util/ArrayList;Lcom/appnew/android/Zoom/ItemClickListener;)V", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "updateData", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CurrentAffairCategoryAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final ArrayList<CurrentAffairData> data;
    private ItemClickListener itemClickListener;
    private Integer pos;

    public CurrentAffairCategoryAdapter(ArrayList<CurrentAffairData> data, ItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.data = data;
        this.itemClickListener = itemClickListener;
        this.pos = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_doubt_sub, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getTitle().setText(this.data.get(position).getCategory());
        Integer num = this.pos;
        if (num != null && num.intValue() == position) {
            holder.getTitle().setBackgroundResource(R.drawable.background_bg_next);
            holder.getTitle().setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            holder.getTitle().setBackgroundResource(R.drawable.background_mcq);
            holder.getTitle().setTextColor(Color.parseColor("#545454"));
        }
        holder.getTitle().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.CurrentAffairCategoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentAffairCategoryAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(CurrentAffairCategoryAdapter currentAffairCategoryAdapter, int i, View view) {
        currentAffairCategoryAdapter.pos = Integer.valueOf(i);
        currentAffairCategoryAdapter.notifyDataSetChanged();
        ItemClickListener itemClickListener = currentAffairCategoryAdapter.itemClickListener;
        ArrayList<CurrentAffairDataModel> data = currentAffairCategoryAdapter.data.get(i).getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        itemClickListener.onClickCurrentAffair(data);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final void updateData(ArrayList<CurrentAffairData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: CurrentAffairCategoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/CurrentAffairCategoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.doubt_subject_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.title = (TextView) viewFindViewById;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final void setTitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.title = textView;
        }
    }
}
