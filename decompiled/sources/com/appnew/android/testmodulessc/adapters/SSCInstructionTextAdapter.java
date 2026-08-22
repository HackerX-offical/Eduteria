package com.appnew.android.testmodulessc.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.ItemSscPatternInstructionTextBinding;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: SSCInstructionTextAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCInstructionTextAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/testmodulessc/adapters/SSCInstructionTextAdapter$VH;", FirebaseAnalytics.Param.ITEMS, "", "", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "VH", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SSCInstructionTextAdapter extends RecyclerView.Adapter<VH> {
    public static final int $stable = 8;
    private final List<String> items;

    public SSCInstructionTextAdapter(List<String> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.items = items;
    }

    /* JADX INFO: compiled from: SSCInstructionTextAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/testmodulessc/adapters/SSCInstructionTextAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemSscPatternInstructionTextBinding;", "<init>", "(Lcom/appnew/android/databinding/ItemSscPatternInstructionTextBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemSscPatternInstructionTextBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VH extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ItemSscPatternInstructionTextBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VH(ItemSscPatternInstructionTextBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemSscPatternInstructionTextBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemSscPatternInstructionTextBinding itemSscPatternInstructionTextBindingInflate = ItemSscPatternInstructionTextBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemSscPatternInstructionTextBindingInflate, "inflate(...)");
        return new VH(itemSscPatternInstructionTextBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBinding().instructionText.setText(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }
}
