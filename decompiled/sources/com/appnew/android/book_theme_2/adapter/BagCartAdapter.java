package com.appnew.android.book_theme_2.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.book_theme_2.models.Cartdata;
import com.appnew.android.databinding.CartItemBookBinding;
import com.eduteria.app.app.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: BagCartAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0014\u001a\u00020\t2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0014\u0010\u0017\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/book_theme_2/adapter/BagCartAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/book_theme_2/adapter/BagCartAdapter$CartViewHolder;", "data", "", "Lcom/appnew/android/book_theme_2/models/Cartdata;", "deleteClick", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/appnew/android/databinding/CartItemBookBinding;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", Const.POSITION, "updateData", "cartdata", "CartViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BagCartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    public static final int $stable = 8;
    private CartItemBookBinding binding;
    private final List<Cartdata> data;
    private final Function1<String, Unit> deleteClick;

    /* JADX WARN: Multi-variable type inference failed */
    public BagCartAdapter(List<Cartdata> data, Function1<? super String, Unit> deleteClick) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(deleteClick, "deleteClick");
        this.data = data;
        this.deleteClick = deleteClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.binding = (CartItemBookBinding) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.cart_item_book, parent, false);
        CartItemBookBinding cartItemBookBinding = this.binding;
        if (cartItemBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cartItemBookBinding = null;
        }
        return new CartViewHolder(this, cartItemBookBinding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final CartViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CartItemBookBinding cartItemBookBinding = this.binding;
        CartItemBookBinding cartItemBookBinding2 = null;
        if (cartItemBookBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cartItemBookBinding = null;
        }
        cartItemBookBinding.setData(this.data.get(holder.getBindingAdapterPosition()));
        CartItemBookBinding cartItemBookBinding3 = this.binding;
        if (cartItemBookBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cartItemBookBinding3 = null;
        }
        TextView textView = cartItemBookBinding3.cartPrice;
        CartItemBookBinding cartItemBookBinding4 = this.binding;
        if (cartItemBookBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cartItemBookBinding4 = null;
        }
        String string = cartItemBookBinding4.getRoot().getContext().getResources().getString(R.string.rs);
        String coursePrice = this.data.get(position).getCoursePrice();
        CartItemBookBinding cartItemBookBinding5 = this.binding;
        if (cartItemBookBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cartItemBookBinding5 = null;
        }
        String string2 = cartItemBookBinding5.getRoot().getContext().getResources().getString(R.string.plus_operator);
        CartItemBookBinding cartItemBookBinding6 = this.binding;
        if (cartItemBookBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cartItemBookBinding6 = null;
        }
        String string3 = cartItemBookBinding6.getRoot().getContext().getResources().getString(R.string.rs);
        String tax = this.data.get(position).getTax();
        CartItemBookBinding cartItemBookBinding7 = this.binding;
        if (cartItemBookBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cartItemBookBinding7 = null;
        }
        textView.setText(string + coursePrice + string2 + string3 + tax + cartItemBookBinding7.getRoot().getContext().getResources().getString(R.string.gst_mark));
        CartItemBookBinding cartItemBookBinding8 = this.binding;
        if (cartItemBookBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cartItemBookBinding8 = null;
        }
        TextView textView2 = cartItemBookBinding8.cartOffPrice;
        CartItemBookBinding cartItemBookBinding9 = this.binding;
        if (cartItemBookBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cartItemBookBinding9 = null;
        }
        textView2.setText(cartItemBookBinding9.getRoot().getContext().getResources().getString(R.string.rs) + " 1000");
        CartItemBookBinding cartItemBookBinding10 = this.binding;
        if (cartItemBookBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cartItemBookBinding2 = cartItemBookBinding10;
        }
        cartItemBookBinding2.cartOffPrice.setPaintFlags(16);
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.IS_RATING), "1", true)) {
            holder.getBinding().cartRating.setVisibility(0);
        } else {
            holder.getBinding().cartRating.setVisibility(8);
        }
        holder.getBinding().deleteId.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.book_theme_2.adapter.BagCartAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BagCartAdapter.onBindViewHolder$lambda$2(holder, this, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(CartViewHolder cartViewHolder, final BagCartAdapter bagCartAdapter, final int i, View view) {
        final Context context = cartViewHolder.getBinding().getRoot().getContext();
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_item_delete_dialog);
        View viewFindViewById = dialog.findViewById(R.id.deleteBtn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = dialog.findViewById(R.id.cancelBtn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((Button) viewFindViewById).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.book_theme_2.adapter.BagCartAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BagCartAdapter.onBindViewHolder$lambda$2$lambda$0(context, bagCartAdapter, i, dialog, view2);
            }
        });
        ((Button) viewFindViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.book_theme_2.adapter.BagCartAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$lambda$0(Context context, BagCartAdapter bagCartAdapter, int i, Dialog dialog, View view) {
        if (Helper.isNetworkConnected(context)) {
            bagCartAdapter.deleteClick.invoke(bagCartAdapter.data.get(i).getId());
            Helper.showProgressDialog(context);
        } else {
            Helper.showInternetToast(context);
        }
        dialog.dismiss();
    }

    public final void updateData(List<Cartdata> cartdata) {
        Intrinsics.checkNotNullParameter(cartdata, "cartdata");
        this.data.clear();
        this.data.addAll(cartdata);
        notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: BagCartAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/book_theme_2/adapter/BagCartAdapter$CartViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/CartItemBookBinding;", "<init>", "(Lcom/appnew/android/book_theme_2/adapter/BagCartAdapter;Lcom/appnew/android/databinding/CartItemBookBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/CartItemBookBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CartViewHolder extends RecyclerView.ViewHolder {
        private final CartItemBookBinding binding;
        final /* synthetic */ BagCartAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CartViewHolder(BagCartAdapter bagCartAdapter, CartItemBookBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = bagCartAdapter;
            this.binding = binding;
        }

        public final CartItemBookBinding getBinding() {
            return this.binding;
        }
    }
}
