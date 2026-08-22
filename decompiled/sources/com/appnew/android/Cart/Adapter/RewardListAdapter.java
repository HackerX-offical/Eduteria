package com.appnew.android.Cart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.CartModel.RewardModel;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.NetworkCall;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: RewardListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B/\u0012\u001e\u0010\u0003\u001a\u001a\u0012\b\u0012\u00060\u0005R\u00020\u00060\u0004j\f\u0012\b\u0012\u00060\u0005R\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0011H\u0017J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010 \u001a\u0004\u0018\u00010\u00142\u0006\u0010!\u001a\u00020\u0014R&\u0010\u0003\u001a\u001a\u0012\b\u0012\u00060\u0005R\u00020\u00060\u0004j\f\u0012\b\u0012\u00060\u0005R\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/appnew/android/Cart/Adapter/RewardListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Cart/Adapter/RewardListAdapter$ViewHolder;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/CartModel/RewardModel$RewardTxn;", "Lcom/appnew/android/Model/CartModel/RewardModel;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "<init>", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "deleteItem", "", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "getdate", "timestamp", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RewardListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private final ArrayList<RewardModel.RewardTxn> data;
    private String deleteItem;
    private NetworkCall networkCall;
    private Integer pos;

    public RewardListAdapter(ArrayList<RewardModel.RewardTxn> data, Context context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = data;
        this.context = context;
        this.pos = 0;
        this.deleteItem = "";
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_reward_list, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getRewordCount().setText((position + 1) + ". ");
        TextView rewordPointTime = holder.getRewordPointTime();
        String creation_time = this.data.get(position).creation_time;
        Intrinsics.checkNotNullExpressionValue(creation_time, "creation_time");
        rewordPointTime.setText(getdate(creation_time));
        holder.getRewordPoint().setText(this.data.get(position).reward + " Coin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: RewardListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/appnew/android/Cart/Adapter/RewardListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rewordCount", "Landroid/widget/TextView;", "getRewordCount", "()Landroid/widget/TextView;", "setRewordCount", "(Landroid/widget/TextView;)V", "rewordPoint", "getRewordPoint", "setRewordPoint", "rewordPointTime", "getRewordPointTime", "setRewordPointTime", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private TextView rewordCount;
        private TextView rewordPoint;
        private TextView rewordPointTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.rewordCount);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.rewordCount = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.rewordPoint);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.rewordPoint = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.rewordPointTime);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.rewordPointTime = (TextView) viewFindViewById3;
        }

        public final TextView getRewordCount() {
            return this.rewordCount;
        }

        public final void setRewordCount(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.rewordCount = textView;
        }

        public final TextView getRewordPoint() {
            return this.rewordPoint;
        }

        public final void setRewordPoint(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.rewordPoint = textView;
        }

        public final TextView getRewordPointTime() {
            return this.rewordPointTime;
        }

        public final void setRewordPointTime(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.rewordPointTime = textView;
        }
    }

    public final String getdate(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * ((long) 1000))));
    }
}
