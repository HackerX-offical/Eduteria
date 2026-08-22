package com.appnew.android.Cart.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Cart.Interface.CartItemClick;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.Model.CartModel.CartItemModel;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.bumptech.glide.Glide;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: CartItemAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0012H\u0017J\b\u0010 \u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u0004\u0018\u00010\u00152\u0006\u0010\"\u001a\u00020\u0015J.\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u00152\b\u0010&\u001a\u0004\u0018\u00010\u00152\u0006\u0010'\u001a\u00020(H\u0016J,\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\b\u0010%\u001a\u0004\u0018\u00010\u00152\b\u0010&\u001a\u0004\u0018\u00010\u00152\u0006\u0010,\u001a\u00020-H\u0016J$\u0010.\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010\u00152\u0006\u0010%\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010\u0015H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/appnew/android/Cart/Adapter/CartItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Cart/Adapter/CartItemAdapter$ViewHolder;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/CartModel/CartItemModel;", "context", "Landroid/content/Context;", "itemClickListener", "Lcom/appnew/android/Cart/Interface/CartItemClick;", "<init>", "(Ljava/util/ArrayList;Landroid/content/Context;Lcom/appnew/android/Cart/Interface/CartItemClick;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "deleteItem", "", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "getdate", "timestamp", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "", "ErrorCallBack", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CartItemAdapter extends RecyclerView.Adapter<ViewHolder> implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private Context context;
    private final ArrayList<CartItemModel> data;
    private String deleteItem;
    private CartItemClick itemClickListener;
    private NetworkCall networkCall;
    private Integer pos;

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public CartItemAdapter(ArrayList<CartItemModel> data, Context context, CartItemClick itemClickListener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.data = data;
        this.context = context;
        this.itemClickListener = itemClickListener;
        this.pos = 0;
        this.deleteItem = "";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cartitem, parent, false);
        this.networkCall = new NetworkCall(this, this.context);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.IS_RATING), "1", true)) {
            holder.getRating_Linear().setVisibility(0);
        } else {
            holder.getRating_Linear().setVisibility(8);
        }
        holder.getCartItem_tittle().setText(this.data.get(position).getCourseName());
        holder.getCartItem_tittle().setSelected(true);
        if (!this.data.get(position).getTax().equals("0")) {
            holder.getCartItem_price().setText(this.context.getResources().getString(R.string.rs) + this.data.get(position).getCoursePrice() + this.context.getResources().getString(R.string.plus_operator) + this.context.getResources().getString(R.string.rs) + this.data.get(position).getTax() + this.context.getResources().getString(R.string.gst_mark));
        }
        holder.getCourseTax().setText(this.data.get(position).getTax() + " " + this.context.getResources().getString(R.string.tax));
        holder.getCartRating_textView().setText(this.data.get(position).getAvgRating());
        holder.getCourseValidity().setText(this.data.get(position).getValidity() + " " + this.context.getResources().getString(R.string._days_validity));
        RatingBar rating_bar_indicator = holder.getRating_bar_indicator();
        String avgRating = this.data.get(position).getAvgRating();
        Intrinsics.checkNotNullExpressionValue(avgRating, "getAvgRating(...)");
        rating_bar_indicator.setRating(Float.parseFloat(avgRating));
        holder.getCartRatingUser_textView().setText(this.data.get(position).getUser_rated() + this.context.getResources().getString(R.string.enrolled));
        holder.getCartItem_type().setText(this.context.getResources().getString(R.string.online_course_));
        Glide.with(holder.itemView.getContext()).load(this.data.get(position).getCoverImage()).centerCrop().placeholder(R.mipmap.square_placeholder).thumbnail(0.5f).into(holder.getCartItem_image());
        holder.getDeleteItem().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Cart.Adapter.CartItemAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CartItemAdapter.onBindViewHolder$lambda$2(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(final CartItemAdapter cartItemAdapter, final int i, View view) {
        final Dialog dialog = new Dialog(cartItemAdapter.context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_item_delete_dialog);
        View viewFindViewById = dialog.findViewById(R.id.deleteBtn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = dialog.findViewById(R.id.cancelBtn);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((Button) viewFindViewById).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Cart.Adapter.CartItemAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CartItemAdapter.onBindViewHolder$lambda$2$lambda$0(this.f$0, i, dialog, view2);
            }
        });
        ((Button) viewFindViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Cart.Adapter.CartItemAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$lambda$0(CartItemAdapter cartItemAdapter, int i, Dialog dialog, View view) {
        if (Helper.isNetworkConnected(cartItemAdapter.context)) {
            cartItemAdapter.deleteItem = cartItemAdapter.data.get(i).getId();
            Helper.showProgressDialog(cartItemAdapter.context);
            NetworkCall networkCall = cartItemAdapter.networkCall;
            if (networkCall != null) {
                networkCall.NetworkAPICall(API.COURSE_REMOVE_ITEM, "", false, false);
            }
        } else {
            Helper.showInternetToast(cartItemAdapter.context);
        }
        dialog.dismiss();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: CartItemAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR\u001a\u00100\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u00069"}, d2 = {"Lcom/appnew/android/Cart/Adapter/CartItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "cartItem_tittle", "Landroid/widget/TextView;", "getCartItem_tittle", "()Landroid/widget/TextView;", "setCartItem_tittle", "(Landroid/widget/TextView;)V", "cartItem_image", "Lcom/google/android/material/imageview/ShapeableImageView;", "getCartItem_image", "()Lcom/google/android/material/imageview/ShapeableImageView;", "setCartItem_image", "(Lcom/google/android/material/imageview/ShapeableImageView;)V", "cartItem_price", "getCartItem_price", "setCartItem_price", "cartItem_type", "getCartItem_type", "setCartItem_type", "courseValidity", "getCourseValidity", "setCourseValidity", "deleteItem", "Landroid/widget/ImageView;", "getDeleteItem", "()Landroid/widget/ImageView;", "setDeleteItem", "(Landroid/widget/ImageView;)V", "cartRating_textView", "getCartRating_textView", "setCartRating_textView", "cartRatingUser_textView", "getCartRatingUser_textView", "setCartRatingUser_textView", "rating_bar_indicator", "Landroid/widget/RatingBar;", "getRating_bar_indicator", "()Landroid/widget/RatingBar;", "setRating_bar_indicator", "(Landroid/widget/RatingBar;)V", "courseTax", "getCourseTax", "setCourseTax", "cartItem_gst", "getCartItem_gst", "setCartItem_gst", "rating_Linear", "Landroid/widget/LinearLayout;", "getRating_Linear", "()Landroid/widget/LinearLayout;", "setRating_Linear", "(Landroid/widget/LinearLayout;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private TextView cartItem_gst;
        private ShapeableImageView cartItem_image;
        private TextView cartItem_price;
        private TextView cartItem_tittle;
        private TextView cartItem_type;
        private TextView cartRatingUser_textView;
        private TextView cartRating_textView;
        private TextView courseTax;
        private TextView courseValidity;
        private ImageView deleteItem;
        private LinearLayout rating_Linear;
        private RatingBar rating_bar_indicator;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.cartItem_tittle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.cartItem_tittle = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.cartItem_image);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.cartItem_image = (ShapeableImageView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.cartItem_price);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.cartItem_price = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.cartItem_type);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.cartItem_type = (TextView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.courseValidity);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.courseValidity = (TextView) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.deleteItem);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.deleteItem = (ImageView) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.cartRating_textView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.cartRating_textView = (TextView) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.cartRatingUser_textView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.cartRatingUser_textView = (TextView) viewFindViewById8;
            View viewFindViewById9 = view.findViewById(R.id.rating_bar_indicator);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.rating_bar_indicator = (RatingBar) viewFindViewById9;
            View viewFindViewById10 = view.findViewById(R.id.courseTax);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            this.courseTax = (TextView) viewFindViewById10;
            View viewFindViewById11 = view.findViewById(R.id.cartItem_gst);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
            this.cartItem_gst = (TextView) viewFindViewById11;
            View viewFindViewById12 = view.findViewById(R.id.rating_Linear);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
            this.rating_Linear = (LinearLayout) viewFindViewById12;
        }

        public final TextView getCartItem_tittle() {
            return this.cartItem_tittle;
        }

        public final void setCartItem_tittle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.cartItem_tittle = textView;
        }

        public final ShapeableImageView getCartItem_image() {
            return this.cartItem_image;
        }

        public final void setCartItem_image(ShapeableImageView shapeableImageView) {
            Intrinsics.checkNotNullParameter(shapeableImageView, "<set-?>");
            this.cartItem_image = shapeableImageView;
        }

        public final TextView getCartItem_price() {
            return this.cartItem_price;
        }

        public final void setCartItem_price(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.cartItem_price = textView;
        }

        public final TextView getCartItem_type() {
            return this.cartItem_type;
        }

        public final void setCartItem_type(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.cartItem_type = textView;
        }

        public final TextView getCourseValidity() {
            return this.courseValidity;
        }

        public final void setCourseValidity(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.courseValidity = textView;
        }

        public final ImageView getDeleteItem() {
            return this.deleteItem;
        }

        public final void setDeleteItem(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.deleteItem = imageView;
        }

        public final TextView getCartRating_textView() {
            return this.cartRating_textView;
        }

        public final void setCartRating_textView(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.cartRating_textView = textView;
        }

        public final TextView getCartRatingUser_textView() {
            return this.cartRatingUser_textView;
        }

        public final void setCartRatingUser_textView(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.cartRatingUser_textView = textView;
        }

        public final RatingBar getRating_bar_indicator() {
            return this.rating_bar_indicator;
        }

        public final void setRating_bar_indicator(RatingBar ratingBar) {
            Intrinsics.checkNotNullParameter(ratingBar, "<set-?>");
            this.rating_bar_indicator = ratingBar;
        }

        public final TextView getCourseTax() {
            return this.courseTax;
        }

        public final void setCourseTax(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.courseTax = textView;
        }

        public final TextView getCartItem_gst() {
            return this.cartItem_gst;
        }

        public final void setCartItem_gst(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.cartItem_gst = textView;
        }

        public final LinearLayout getRating_Linear() {
            return this.rating_Linear;
        }

        public final void setRating_Linear(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.rating_Linear = linearLayout;
        }
    }

    public final String getdate(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * ((long) 1000))));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.COURSE_REMOVE_ITEM)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setItem_id(this.deleteItem);
        return service.getRemoveItem(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.COURSE_REMOVE_ITEM)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    XtensionFunctionKt.showSmallLengthToast(this.context, "Course Remove");
                    this.itemClickListener.onClick(true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.areEqual(apitype, API.COURSE_SHOW_CART);
    }
}
