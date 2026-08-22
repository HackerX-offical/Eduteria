package com.appnew.android.Zoom.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.ZoomModel.FaqModel;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.CustomExpendLayoutBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: RvAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u001f\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0017J\b\u0010\u0012\u001a\u00020\rH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/RvAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/RvAdapter$ViewHolder;", "languageList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/FaqModel;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RvAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private ArrayList<FaqModel> languageList;

    public RvAdapter(ArrayList<FaqModel> languageList) {
        Intrinsics.checkNotNullParameter(languageList, "languageList");
        this.languageList = languageList;
    }

    /* JADX INFO: compiled from: RvAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/RvAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/CustomExpendLayoutBinding;", "<init>", "(Lcom/appnew/android/Zoom/Adapter/RvAdapter;Lcom/appnew/android/databinding/CustomExpendLayoutBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/CustomExpendLayoutBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final CustomExpendLayoutBinding binding;
        final /* synthetic */ RvAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(RvAdapter rvAdapter, CustomExpendLayoutBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = rvAdapter;
            this.binding = binding;
        }

        public final CustomExpendLayoutBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CustomExpendLayoutBinding customExpendLayoutBindingInflate = CustomExpendLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(customExpendLayoutBindingInflate, "inflate(...)");
        return new ViewHolder(this, customExpendLayoutBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final FaqModel faqModel = this.languageList.get(position);
        holder.getBinding().tvLangName.setText((position + 1) + ". " + faqModel.getQuestion());
        holder.getBinding().tvDescription.setText(faqModel.getDescription().toString());
        holder.getBinding().expandedView.setVisibility(faqModel.getExpand().booleanValue() ? 0 : 8);
        holder.getBinding().cardLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.RvAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RvAdapter.onBindViewHolder$lambda$2$lambda$1$lambda$0(faqModel, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$lambda$1$lambda$0(FaqModel faqModel, RvAdapter rvAdapter, View view) {
        faqModel.setExpand(Boolean.valueOf(!faqModel.getExpand().booleanValue()));
        rvAdapter.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.languageList.size();
    }
}
