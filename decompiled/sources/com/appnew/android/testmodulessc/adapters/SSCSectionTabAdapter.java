package com.appnew.android.testmodulessc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.ItemSscPatternSubjectTabBinding;
import com.appnew.android.testmodulessc.models.SSCTestSection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: SSCSectionTabAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCSectionTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/testmodulessc/adapters/SSCSectionTabAdapter$ViewHolder;", "context", "Landroid/content/Context;", "sectionParts", "", "Lcom/appnew/android/testmodulessc/models/SSCTestSection;", "onSectionPartSelected", "Lkotlin/Function1;", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "", "getItemId", "", Const.POSITION, "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "setSelectedPosition", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SSCSectionTabAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private final Function1<SSCTestSection, Unit> onSectionPartSelected;
    private final List<SSCTestSection> sectionParts;
    private int selectedPosition;

    /* JADX WARN: Multi-variable type inference failed */
    public SSCSectionTabAdapter(Context context, List<SSCTestSection> sectionParts, Function1<? super SSCTestSection, Unit> onSectionPartSelected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sectionParts, "sectionParts");
        Intrinsics.checkNotNullParameter(onSectionPartSelected, "onSectionPartSelected");
        this.context = context;
        this.sectionParts = sectionParts;
        this.onSectionPartSelected = onSectionPartSelected;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.sectionParts.get(position).getId() != null ? r3.hashCode() : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemSscPatternSubjectTabBinding itemSscPatternSubjectTabBindingInflate = ItemSscPatternSubjectTabBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemSscPatternSubjectTabBindingInflate, "inflate(...)");
        return new ViewHolder(itemSscPatternSubjectTabBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBinding().tvSubjectName.setText(this.sectionParts.get(position).getName());
        holder.getBinding().viewIndicator.setVisibility(position == this.selectedPosition ? 0 : 8);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.adapters.SSCSectionTabAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SSCSectionTabAdapter.onBindViewHolder$lambda$0(holder, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(ViewHolder viewHolder, SSCSectionTabAdapter sSCSectionTabAdapter, View view) {
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        sSCSectionTabAdapter.setSelectedPosition(bindingAdapterPosition);
        sSCSectionTabAdapter.onSectionPartSelected.invoke(sSCSectionTabAdapter.sectionParts.get(bindingAdapterPosition));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.sectionParts.size();
    }

    public final void setSelectedPosition(int position) {
        int i;
        if (position < 0 || position >= this.sectionParts.size() || position == (i = this.selectedPosition)) {
            return;
        }
        this.selectedPosition = position;
        notifyItemChanged(i);
        notifyItemChanged(this.selectedPosition);
    }

    /* JADX INFO: compiled from: SSCSectionTabAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCSectionTabAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemSscPatternSubjectTabBinding;", "<init>", "(Lcom/appnew/android/databinding/ItemSscPatternSubjectTabBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemSscPatternSubjectTabBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ItemSscPatternSubjectTabBinding binding;

        public final ItemSscPatternSubjectTabBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ItemSscPatternSubjectTabBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }
    }
}
