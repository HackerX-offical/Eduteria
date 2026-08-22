package com.appnew.android.Zoom.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Fragment.SingleStudy2;
import com.appnew.android.Model.ZoomModel.CurrentAffairDataModel;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Zoom.Activity.CurrentAffairInfoActivity;
import com.appnew.android.Zoom.CurrentAffairDiffCallback;
import com.bumptech.glide.Glide;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: CurrentAffairAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bJ\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020 R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006#"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/CurrentAffairAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/CurrentAffairAdapter$ViewHolder;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/CurrentAffairDataModel;", "context", "Landroid/content/Context;", "<init>", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "getItemId", "", Const.POSITION, "updateData", "", "newData", "", "onBindViewHolder", "holder", "getItemCount", "getdate", "", "timestamp", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CurrentAffairAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private final ArrayList<CurrentAffairDataModel> data;
    private Integer pos;

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public CurrentAffairAdapter(ArrayList<CurrentAffairDataModel> data, Context context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = data;
        this.context = context;
        this.pos = 0;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_current_affair_two, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.data.get(position).getId().hashCode();
    }

    public final void updateData(List<? extends CurrentAffairDataModel> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new CurrentAffairDiffCallback(this.data, newData));
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
        this.data.clear();
        this.data.addAll(newData);
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getCurrentAffair_tittle().setText(this.data.get(position).getTitle());
        if (this.data.get(position).getSet_as_new().equals("1")) {
            holder.getBlinkNewCF().setVisibility(0);
        }
        holder.getCurrentAffair_subject().setText(Html.fromHtml(this.data.get(position).getDescription(), 63));
        TextView currentAffair_date = holder.getCurrentAffair_date();
        String created_at = this.data.get(position).getCreated_at();
        Intrinsics.checkNotNullExpressionValue(created_at, "getCreated_at(...)");
        currentAffair_date.setText(getdate(created_at));
        Glide.with(holder.itemView.getContext()).load(this.data.get(position).getImage()).centerCrop().placeholder(R.mipmap.square_placeholder).thumbnail(0.5f).into(holder.getCurrentAffair_image());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.CurrentAffairAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentAffairAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
        holder.getShareCurrentAffair().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.CurrentAffairAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrentAffairAdapter.onBindViewHolder$lambda$1(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(CurrentAffairAdapter currentAffairAdapter, int i, View view) {
        if (Helper.isNetworkConnected(currentAffairAdapter.context)) {
            Intent intent = new Intent(currentAffairAdapter.context, (Class<?>) CurrentAffairInfoActivity.class);
            intent.putExtra("id", currentAffairAdapter.data.get(i).getId());
            intent.putExtra("type", Const.CURRENT_AFFAIR);
            currentAffairAdapter.context.startActivity(intent);
            return;
        }
        Context context = currentAffairAdapter.context;
        Toast.makeText(context, context.getResources().getString(R.string.no_internet_connection), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(CurrentAffairAdapter currentAffairAdapter, int i, View view) {
        Helper.shareCurrentAffair((Activity) currentAffairAdapter.context, currentAffairAdapter.data.get(i).getId(), SingleStudy2.parentCourseId, AnalyticsConstants.course_name, "", currentAffairAdapter.data.get(i).getTitle());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final void updateData(ArrayList<CurrentAffairDataModel> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: CurrentAffairAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/CurrentAffairAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "currentAffair_tittle", "Landroid/widget/TextView;", "getCurrentAffair_tittle", "()Landroid/widget/TextView;", "setCurrentAffair_tittle", "(Landroid/widget/TextView;)V", "currentAffair_subject", "getCurrentAffair_subject", "setCurrentAffair_subject", "currentAffair_date", "getCurrentAffair_date", "setCurrentAffair_date", "currentAffair_image", "Landroid/widget/ImageView;", "getCurrentAffair_image", "()Landroid/widget/ImageView;", "setCurrentAffair_image", "(Landroid/widget/ImageView;)V", "shareCurrentAffair", "getShareCurrentAffair", "setShareCurrentAffair", "blinkNewCF", "getBlinkNewCF", "setBlinkNewCF", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private ImageView blinkNewCF;
        private TextView currentAffair_date;
        private ImageView currentAffair_image;
        private TextView currentAffair_subject;
        private TextView currentAffair_tittle;
        private ImageView shareCurrentAffair;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.currentAffair_tittle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.currentAffair_tittle = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.currentAffair_subject);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.currentAffair_subject = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.currentAffair_date);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.currentAffair_date = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.currentAffair_image);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.currentAffair_image = (ImageView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.shareCurrentAffair);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.shareCurrentAffair = (ImageView) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.blinkNewCF);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.blinkNewCF = (ImageView) viewFindViewById6;
        }

        public final TextView getCurrentAffair_tittle() {
            return this.currentAffair_tittle;
        }

        public final void setCurrentAffair_tittle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.currentAffair_tittle = textView;
        }

        public final TextView getCurrentAffair_subject() {
            return this.currentAffair_subject;
        }

        public final void setCurrentAffair_subject(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.currentAffair_subject = textView;
        }

        public final TextView getCurrentAffair_date() {
            return this.currentAffair_date;
        }

        public final void setCurrentAffair_date(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.currentAffair_date = textView;
        }

        public final ImageView getCurrentAffair_image() {
            return this.currentAffair_image;
        }

        public final void setCurrentAffair_image(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.currentAffair_image = imageView;
        }

        public final ImageView getShareCurrentAffair() {
            return this.shareCurrentAffair;
        }

        public final void setShareCurrentAffair(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.shareCurrentAffair = imageView;
        }

        public final ImageView getBlinkNewCF() {
            return this.blinkNewCF;
        }

        public final void setBlinkNewCF(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.blinkNewCF = imageView;
        }
    }

    public final String getdate(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * ((long) 1000))));
    }
}
