package com.appnew.android.testmodulessc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.ItemSscPatternSubjectPartBinding;
import com.appnew.android.testmodulessc.models.SSCTestSection;
import com.eduteria.app.app.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: SSCSectionPartAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCSectionPartAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/testmodulessc/adapters/SSCSectionPartAdapter$VH;", "context", "Landroid/content/Context;", "sections", "", "Lcom/appnew/android/testmodulessc/models/SSCTestSection;", "onClick", "Lkotlin/Function2;", "", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "selectedIndex", "getItemId", "", Const.POSITION, "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "setSelectedIndex", FirebaseAnalytics.Param.INDEX, "VH", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SSCSectionPartAdapter extends RecyclerView.Adapter<VH> {
    public static final int $stable = 8;
    private final Context context;
    private final Function2<SSCTestSection, Integer, Unit> onClick;
    private final List<SSCTestSection> sections;
    private int selectedIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public SSCSectionPartAdapter(Context context, List<SSCTestSection> sections, Function2<? super SSCTestSection, ? super Integer, Unit> onClick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.context = context;
        this.sections = sections;
        this.onClick = onClick;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.sections.get(position).getId() != null ? r3.hashCode() : 0;
    }

    /* JADX INFO: compiled from: SSCSectionPartAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCSectionPartAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemSscPatternSubjectPartBinding;", "<init>", "(Lcom/appnew/android/databinding/ItemSscPatternSubjectPartBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemSscPatternSubjectPartBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VH extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ItemSscPatternSubjectPartBinding binding;

        public final ItemSscPatternSubjectPartBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(ItemSscPatternSubjectPartBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemSscPatternSubjectPartBinding itemSscPatternSubjectPartBindingInflate = ItemSscPatternSubjectPartBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemSscPatternSubjectPartBindingInflate, "inflate(...)");
        return new VH(itemSscPatternSubjectPartBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final VH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBinding().sectionPartTxt.setText(this.context.getString(R.string.ssc_part_label, String.valueOf((char) (position + 65))));
        boolean z = position == this.selectedIndex;
        holder.getBinding().sectionPartTxt.setBackgroundResource(z ? R.drawable.shape_rect_blue_solid : R.drawable.btn_outline_gray);
        holder.getBinding().sectionPartTxt.setTextColor(this.context.getColor(z ? R.color.white : R.color.ssc_gray));
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.testmodulessc.adapters.SSCSectionPartAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SSCSectionPartAdapter.onBindViewHolder$lambda$0(holder, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(VH vh, SSCSectionPartAdapter sSCSectionPartAdapter, View view) {
        int bindingAdapterPosition = vh.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int i = sSCSectionPartAdapter.selectedIndex;
        if (i != bindingAdapterPosition) {
            sSCSectionPartAdapter.selectedIndex = bindingAdapterPosition;
            sSCSectionPartAdapter.notifyItemChanged(i);
            sSCSectionPartAdapter.notifyItemChanged(sSCSectionPartAdapter.selectedIndex);
        }
        sSCSectionPartAdapter.onClick.invoke(sSCSectionPartAdapter.sections.get(bindingAdapterPosition), Integer.valueOf(bindingAdapterPosition));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.sections.size();
    }

    public final void setSelectedIndex(int index) {
        int i;
        if (index < 0 || index >= this.sections.size() || (i = this.selectedIndex) == index) {
            return;
        }
        this.selectedIndex = index;
        notifyItemChanged(i);
        notifyItemChanged(this.selectedIndex);
    }
}
