package com.appnew.android.pendingPurchase;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.databinding.PendingPurchaseBannerItemBinding;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: PendingPurchaseAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\u001d\u001e\u001fB;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/appnew/android/pendingPurchase/PendingPurchaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/pendingPurchase/PendingPurchaseAdapter$SliderViewHolder;", "context", "Landroid/content/Context;", "pendingPurchaseList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/Courselist;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/appnew/android/pendingPurchase/PendingPurchaseAdapter$BuyNowClickListener;", "onCloseClick", "Lcom/appnew/android/pendingPurchase/PendingPurchaseAdapter$CloseClickListener;", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/appnew/android/pendingPurchase/PendingPurchaseAdapter$BuyNowClickListener;Lcom/appnew/android/pendingPurchase/PendingPurchaseAdapter$CloseClickListener;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "setImageViewWidth", "imageView", "Landroid/widget/ImageView;", "courseDetailData", "BuyNowClickListener", "CloseClickListener", "SliderViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PendingPurchaseAdapter extends RecyclerView.Adapter<SliderViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private final BuyNowClickListener listener;
    private final CloseClickListener onCloseClick;
    private final ArrayList<Courselist> pendingPurchaseList;

    /* JADX INFO: compiled from: PendingPurchaseAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/pendingPurchase/PendingPurchaseAdapter$BuyNowClickListener;", "", "onBuyNow", "", "pendingPurchaseData", "Lcom/appnew/android/Model/Courselist;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface BuyNowClickListener {
        void onBuyNow(Courselist pendingPurchaseData);
    }

    /* JADX INFO: compiled from: PendingPurchaseAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/appnew/android/pendingPurchase/PendingPurchaseAdapter$CloseClickListener;", "", "onCloseClick", "", "pendingPurchaseData", "Lcom/appnew/android/Model/Courselist;", Const.POSITION, "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface CloseClickListener {
        void onCloseClick(Courselist pendingPurchaseData, int position);
    }

    public PendingPurchaseAdapter(Context context, ArrayList<Courselist> arrayList, BuyNowClickListener listener, CloseClickListener onCloseClick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        this.context = context;
        this.pendingPurchaseList = arrayList;
        this.listener = listener;
        this.onCloseClick = onCloseClick;
    }

    /* JADX INFO: compiled from: PendingPurchaseAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/pendingPurchase/PendingPurchaseAdapter$SliderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/PendingPurchaseBannerItemBinding;", "<init>", "(Lcom/appnew/android/pendingPurchase/PendingPurchaseAdapter;Lcom/appnew/android/databinding/PendingPurchaseBannerItemBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/PendingPurchaseBannerItemBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SliderViewHolder extends RecyclerView.ViewHolder {
        private final PendingPurchaseBannerItemBinding binding;
        final /* synthetic */ PendingPurchaseAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SliderViewHolder(PendingPurchaseAdapter pendingPurchaseAdapter, PendingPurchaseBannerItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = pendingPurchaseAdapter;
            this.binding = binding;
        }

        public final PendingPurchaseBannerItemBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SliderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        PendingPurchaseBannerItemBinding pendingPurchaseBannerItemBindingInflate = PendingPurchaseBannerItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(pendingPurchaseBannerItemBindingInflate, "inflate(...)");
        return new SliderViewHolder(this, pendingPurchaseBannerItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SliderViewHolder holder, final int position) {
        final Courselist courselist;
        Intrinsics.checkNotNullParameter(holder, "holder");
        ArrayList<Courselist> arrayList = this.pendingPurchaseList;
        if (arrayList == null || (courselist = arrayList.get(position)) == null) {
            return;
        }
        PendingPurchaseBannerItemBinding binding = holder.getBinding();
        binding.courseTitleTV.setText(courselist.getTitle());
        SpannableString spannableString = new SpannableString(Constants.currencyType + courselist.getMrp() + "/-");
        spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
        binding.mrpCutTV.setText(spannableString);
        binding.priceTV.setText(Constants.currencyType + courselist.getCourseSp() + "/-");
        binding.btnBuyNow.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.pendingPurchase.PendingPurchaseAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PendingPurchaseAdapter.onBindViewHolder$lambda$2$lambda$0(this.f$0, courselist, view);
            }
        });
        binding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.pendingPurchase.PendingPurchaseAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PendingPurchaseAdapter.onBindViewHolder$lambda$2$lambda$1(this.f$0, courselist, position, view);
            }
        });
        ShapeableImageView imageSlider = holder.getBinding().imageSlider;
        Intrinsics.checkNotNullExpressionValue(imageSlider, "imageSlider");
        setImageViewWidth(imageSlider, courselist);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$lambda$0(PendingPurchaseAdapter pendingPurchaseAdapter, Courselist courselist, View view) {
        pendingPurchaseAdapter.listener.onBuyNow(courselist);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$lambda$1(PendingPurchaseAdapter pendingPurchaseAdapter, Courselist courselist, int i, View view) {
        pendingPurchaseAdapter.onCloseClick.onCloseClick(courselist, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<Courselist> arrayList = this.pendingPurchaseList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    private final void setImageViewWidth(ImageView imageView, Courselist courseDetailData) {
        int i = (int) (120 * this.context.getResources().getDisplayMetrics().density);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = i;
        imageView.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(courseDetailData.getDescHeaderImage())) {
            Helper.setThumbnailImage(this.context, courseDetailData.getDescHeaderImage(), ResourcesCompat.getDrawable(this.context.getResources(), R.mipmap.placeholder_course, this.context.getTheme()), imageView);
        } else {
            imageView.setImageResource(R.mipmap.placeholder_course);
        }
    }
}
