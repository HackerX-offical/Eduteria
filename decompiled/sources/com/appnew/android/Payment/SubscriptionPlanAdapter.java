package com.appnew.android.Payment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.subscription.SubscriptionDataItem;
import com.appnew.android.Payment.SubscriptionPlanAdapter;
import com.appnew.android.R;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.SubscriptionPlanItemBinding;
import com.clevertap.android.sdk.Constants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: SubscriptionPlanAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002 !B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u001c\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/appnew/android/Payment/SubscriptionPlanAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Payment/SubscriptionPlanAdapter$PlanViewHolder;", "context", "Landroid/content/Context;", "subscriptionDataItemList", "", "Lcom/appnew/android/Model/subscription/SubscriptionDataItem;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/appnew/android/Payment/SubscriptionPlanAdapter$OnPlanClickListener;", "<init>", "(Landroid/content/Context;[Lcom/appnew/android/Model/subscription/SubscriptionDataItem;Lcom/appnew/android/Payment/SubscriptionPlanAdapter$OnPlanClickListener;)V", "getContext", "()Landroid/content/Context;", "getSubscriptionDataItemList", "()[Lcom/appnew/android/Model/subscription/SubscriptionDataItem;", "[Lcom/appnew/android/Model/subscription/SubscriptionDataItem;", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "firstTime", "", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemViewType", "getItemCount", "PlanViewHolder", "OnPlanClickListener", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubscriptionPlanAdapter extends RecyclerView.Adapter<PlanViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private boolean firstTime;
    private final OnPlanClickListener listener;
    private Integer pos;
    private final SubscriptionDataItem[] subscriptionDataItemList;

    /* JADX INFO: compiled from: SubscriptionPlanAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/Payment/SubscriptionPlanAdapter$OnPlanClickListener;", "", "onPlanClick", "", "item", "Lcom/appnew/android/Model/subscription/SubscriptionDataItem;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnPlanClickListener {
        void onPlanClick(SubscriptionDataItem item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position;
    }

    public final Context getContext() {
        return this.context;
    }

    public final SubscriptionDataItem[] getSubscriptionDataItemList() {
        return this.subscriptionDataItemList;
    }

    public SubscriptionPlanAdapter(Context context, SubscriptionDataItem[] subscriptionDataItemList, OnPlanClickListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subscriptionDataItemList, "subscriptionDataItemList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.subscriptionDataItemList = subscriptionDataItemList;
        this.listener = listener;
        this.pos = 0;
        this.firstTime = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PlanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SubscriptionPlanItemBinding subscriptionPlanItemBindingInflate = SubscriptionPlanItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(subscriptionPlanItemBindingInflate, "inflate(...)");
        return new PlanViewHolder(this, subscriptionPlanItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PlanViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SubscriptionDataItem subscriptionDataItem = this.subscriptionDataItemList[position];
        View itemView = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        holder.bind(subscriptionDataItem, itemView, position);
    }

    /* JADX INFO: compiled from: SubscriptionPlanAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/appnew/android/Payment/SubscriptionPlanAdapter$PlanViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/SubscriptionPlanItemBinding;", "<init>", "(Lcom/appnew/android/Payment/SubscriptionPlanAdapter;Lcom/appnew/android/databinding/SubscriptionPlanItemBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/SubscriptionPlanItemBinding;", Bind.ELEMENT, "", "plan", "Lcom/appnew/android/Model/subscription/SubscriptionDataItem;", "holder", "Landroid/view/View;", Const.POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class PlanViewHolder extends RecyclerView.ViewHolder {
        private final SubscriptionPlanItemBinding binding;
        final /* synthetic */ SubscriptionPlanAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlanViewHolder(SubscriptionPlanAdapter subscriptionPlanAdapter, SubscriptionPlanItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = subscriptionPlanAdapter;
            this.binding = binding;
        }

        public final SubscriptionPlanItemBinding getBinding() {
            return this.binding;
        }

        public final void bind(final SubscriptionDataItem plan, final View holder, final int position) {
            Intrinsics.checkNotNullParameter(plan, "plan");
            Intrinsics.checkNotNullParameter(holder, "holder");
            this.binding.subscriptionDetalis.setText(plan.getShort_description());
            this.binding.subscriptionPrice.setText("₹" + plan.getRecurring_amount());
            TextView textView = this.binding.subscriptionPlanType;
            if (textView != null) {
                textView.setText(plan.getPlan_type());
            }
            Integer num = this.this$0.pos;
            if (num != null && num.intValue() == position) {
                holder.setBackgroundResource(R.drawable.bg_mcq_selected);
                this.binding.subscriptionSelect.setBackgroundResource(com.eduteria.app.app.R.drawable.check_circle_subs);
                if (this.this$0.firstTime) {
                    this.this$0.listener.onPlanClick(plan);
                    this.this$0.firstTime = false;
                }
            } else {
                holder.setBackgroundResource(com.eduteria.app.app.R.drawable.background_mcq);
                this.binding.subscriptionSelect.setBackgroundResource(com.eduteria.app.app.R.drawable.bg_question);
            }
            final SubscriptionPlanAdapter subscriptionPlanAdapter = this.this$0;
            holder.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Payment.SubscriptionPlanAdapter$PlanViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubscriptionPlanAdapter.PlanViewHolder.bind$lambda$0(this.f$0, holder, subscriptionPlanAdapter, position, plan, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(PlanViewHolder planViewHolder, View view, SubscriptionPlanAdapter subscriptionPlanAdapter, int i, SubscriptionDataItem subscriptionDataItem, View view2) {
            planViewHolder.binding.subscriptionSelect.setBackgroundResource(com.eduteria.app.app.R.drawable.check_circle_subs);
            view.setBackgroundResource(R.drawable.bg_mcq_selected);
            subscriptionPlanAdapter.pos = Integer.valueOf(i);
            subscriptionPlanAdapter.notifyDataSetChanged();
            subscriptionPlanAdapter.listener.onPlanClick(subscriptionDataItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.subscriptionDataItemList.length;
    }
}
