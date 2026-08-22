package Zoom.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.Model.ZoomModel.QuestionData;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Zoom.Activity.ViewQuestionActivity;
import com.appnew.android.Zoom.Interface.BookmarkItem;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: QuestionBookMarkListAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0017H\u0017J\b\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\t2\u0006\u0010#\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006&"}, d2 = {"LZoom/Adapter/QuestionBookMarkListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "LZoom/Adapter/QuestionBookMarkListAdapter$ViewHolder;", "data", "", "Lcom/appnew/android/Model/ZoomModel/QuestionData;", "context", "Landroid/content/Context;", "type", "", "bookMarkItem", "Lcom/appnew/android/Zoom/Interface/BookmarkItem;", "<init>", "(Ljava/util/List;Landroid/content/Context;Ljava/lang/String;Lcom/appnew/android/Zoom/Interface/BookmarkItem;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "getdate", "timestamp", "removeItem", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuestionBookMarkListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private BookmarkItem bookMarkItem;
    private Context context;
    private final List<QuestionData> data;
    private Integer pos;
    private String type;

    public QuestionBookMarkListAdapter(List<QuestionData> data, Context context, String type, BookmarkItem bookMarkItem) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(bookMarkItem, "bookMarkItem");
        this.data = data;
        this.context = context;
        this.type = type;
        this.bookMarkItem = bookMarkItem;
        this.pos = 0;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getType() {
        return this.type;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_bookmark_list_new, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBookmark_title().setVisibility(0);
        Helper.testQuestionFont(holder.getBookmark_title(), position, this.data.get(position).getQuestion(), "2");
        holder.getBookmark_count().setVisibility(8);
        holder.getImg_bookmark().setVisibility(0);
        holder.getBookmark_image().setVisibility(8);
        holder.getImg_play_pause().setVisibility(8);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: Zoom.Adapter.QuestionBookMarkListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionBookMarkListAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
        holder.getImg_bookmark().setOnClickListener(new View.OnClickListener() { // from class: Zoom.Adapter.QuestionBookMarkListAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionBookMarkListAdapter.onBindViewHolder$lambda$1(this.f$0, position, holder, view);
            }
        });
        holder.getBookmark_title().setOnClickListener(new View.OnClickListener() { // from class: Zoom.Adapter.QuestionBookMarkListAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionBookMarkListAdapter.onBindViewHolder$lambda$2(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(QuestionBookMarkListAdapter questionBookMarkListAdapter, int i, View view) {
        Intent intent = new Intent(questionBookMarkListAdapter.context, (Class<?>) ViewQuestionActivity.class);
        intent.putExtra("data", questionBookMarkListAdapter.data.get(i));
        List<QuestionData> list = questionBookMarkListAdapter.data;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.io.Serializable");
        intent.putExtra("data_list", (Serializable) list);
        intent.putExtra(Const.POSITION, i);
        questionBookMarkListAdapter.context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(QuestionBookMarkListAdapter questionBookMarkListAdapter, int i, ViewHolder viewHolder, View view) {
        BookmarkItem bookmarkItem = questionBookMarkListAdapter.bookMarkItem;
        if (bookmarkItem != null) {
            String config_id = questionBookMarkListAdapter.data.get(i).getConfig_id();
            Intrinsics.checkNotNullExpressionValue(config_id, "getConfig_id(...)");
            bookmarkItem.onClick(config_id, "");
        }
        questionBookMarkListAdapter.removeItem(viewHolder.getAdapterPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(QuestionBookMarkListAdapter questionBookMarkListAdapter, int i, View view) {
        Intent intent = new Intent(questionBookMarkListAdapter.context, (Class<?>) ViewQuestionActivity.class);
        intent.putExtra("data", questionBookMarkListAdapter.data.get(i));
        List<QuestionData> list = questionBookMarkListAdapter.data;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.io.Serializable");
        intent.putExtra("data_list", (Serializable) list);
        intent.putExtra(Const.POSITION, i);
        questionBookMarkListAdapter.context.startActivity(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: QuestionBookMarkListAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001a¨\u0006!"}, d2 = {"LZoom/Adapter/QuestionBookMarkListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bookmark_title", "Lcom/ahmadnemati/clickablewebview/ClickableWebView;", "getBookmark_title", "()Lcom/ahmadnemati/clickablewebview/ClickableWebView;", "setBookmark_title", "(Lcom/ahmadnemati/clickablewebview/ClickableWebView;)V", "bookmark_count", "Landroid/widget/TextView;", "getBookmark_count", "()Landroid/widget/TextView;", "setBookmark_count", "(Landroid/widget/TextView;)V", "bookmark_subject", "getBookmark_subject", "setBookmark_subject", "bookmark_image", "Landroid/widget/ImageView;", "getBookmark_image", "()Landroid/widget/ImageView;", "setBookmark_image", "(Landroid/widget/ImageView;)V", "img_play_pause", "getImg_play_pause", "setImg_play_pause", "img_bookmark", "getImg_bookmark", "setImg_bookmark", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private TextView bookmark_count;
        private ImageView bookmark_image;
        private TextView bookmark_subject;
        private ClickableWebView bookmark_title;
        private ImageView img_bookmark;
        private ImageView img_play_pause;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.bookmark_tittle_question);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.bookmark_title = (ClickableWebView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.bookmark_count);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.bookmark_count = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.bookmark_subject);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.bookmark_subject = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.bookmark_image);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.bookmark_image = (ImageView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.img_play_pause);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.img_play_pause = (ImageView) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.img_bookmark);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.img_bookmark = (ImageView) viewFindViewById6;
        }

        public final ClickableWebView getBookmark_title() {
            return this.bookmark_title;
        }

        public final void setBookmark_title(ClickableWebView clickableWebView) {
            Intrinsics.checkNotNullParameter(clickableWebView, "<set-?>");
            this.bookmark_title = clickableWebView;
        }

        public final TextView getBookmark_count() {
            return this.bookmark_count;
        }

        public final void setBookmark_count(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.bookmark_count = textView;
        }

        public final TextView getBookmark_subject() {
            return this.bookmark_subject;
        }

        public final void setBookmark_subject(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.bookmark_subject = textView;
        }

        public final ImageView getBookmark_image() {
            return this.bookmark_image;
        }

        public final void setBookmark_image(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.bookmark_image = imageView;
        }

        public final ImageView getImg_play_pause() {
            return this.img_play_pause;
        }

        public final void setImg_play_pause(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.img_play_pause = imageView;
        }

        public final ImageView getImg_bookmark() {
            return this.img_bookmark;
        }

        public final void setImg_bookmark(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.img_bookmark = imageView;
        }
    }

    public final String getdate(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * ((long) 1000))));
    }

    public final void removeItem(int position) {
        this.data.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, this.data.size());
    }
}
