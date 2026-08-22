package com.appnew.android.TeacherTimeTable.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.Noticeboard.Data;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Zoom.Activity.CurrentAffairInfoActivity;
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

/* JADX INFO: compiled from: NoticeboardAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Adapter/NoticeboardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/TeacherTimeTable/Adapter/NoticeboardAdapter$ViewHolder;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/Noticeboard/Data;", "context", "Landroid/content/Context;", "<init>", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "getdate", "", "timestamp", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoticeboardAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private final ArrayList<Data> data;
    private Integer pos;

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public NoticeboardAdapter(ArrayList<Data> data, Context context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = data;
        this.context = context;
        this.pos = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_noticeboard, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getNoticeTitle().setText(this.data.get(position).getTitle());
        holder.getNoticeDate().setText(getdate(this.data.get(position).getCreationTime()));
        holder.getNoticeText().setText(Html.fromHtml(this.data.get(position).getText(), 63));
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.TeacherTimeTable.Adapter.NoticeboardAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NoticeboardAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(NoticeboardAdapter noticeboardAdapter, int i, View view) {
        if (Helper.isNetworkConnected(noticeboardAdapter.context)) {
            Intent intent = new Intent(noticeboardAdapter.context, (Class<?>) CurrentAffairInfoActivity.class);
            intent.putExtra("id", noticeboardAdapter.data.get(i).getId());
            intent.putExtra("type", "notice_board");
            intent.putExtra("title", noticeboardAdapter.data.get(i).getTitle());
            intent.putExtra("text", noticeboardAdapter.data.get(i).getText());
            intent.putExtra("url", noticeboardAdapter.data.get(i).getLink());
            noticeboardAdapter.context.startActivity(intent);
            return;
        }
        Context context = noticeboardAdapter.context;
        Toast.makeText(context, context.getResources().getString(R.string.no_internet_connection), 0).show();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: NoticeboardAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/appnew/android/TeacherTimeTable/Adapter/NoticeboardAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "noticeDate", "Landroid/widget/TextView;", "getNoticeDate", "()Landroid/widget/TextView;", "setNoticeDate", "(Landroid/widget/TextView;)V", "noticeTitle", "getNoticeTitle", "setNoticeTitle", "noticeText", "getNoticeText", "setNoticeText", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private TextView noticeDate;
        private TextView noticeText;
        private TextView noticeTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.noticeDate);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.noticeDate = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.noticeTitle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.noticeTitle = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.noticeText);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.noticeText = (TextView) viewFindViewById3;
        }

        public final TextView getNoticeDate() {
            return this.noticeDate;
        }

        public final void setNoticeDate(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.noticeDate = textView;
        }

        public final TextView getNoticeTitle() {
            return this.noticeTitle;
        }

        public final void setNoticeTitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.noticeTitle = textView;
        }

        public final TextView getNoticeText() {
            return this.noticeText;
        }

        public final void setNoticeText(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.noticeText = textView;
        }
    }

    public final String getdate(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * ((long) 1000))));
    }
}
