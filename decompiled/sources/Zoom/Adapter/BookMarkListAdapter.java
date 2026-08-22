package Zoom.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Model.ZoomModel.PdfData;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Zoom.Activity.ZoomRecodedPlayer;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
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
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: BookMarkListAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B/\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\u0010\u0010!\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020\nJ\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0016H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006&"}, d2 = {"LZoom/Adapter/BookMarkListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "LZoom/Adapter/BookMarkListAdapter$ViewHolder;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/PdfData;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "type", "", "<init>", "(Ljava/util/ArrayList;Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "getdate", "timestamp", "API_REQUEST_VIDEO_LINK", "videoData", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BookMarkListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private final ArrayList<PdfData> data;
    private Integer pos;
    private String type;

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public BookMarkListAdapter(ArrayList<PdfData> data, Context context, String type) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        this.data = data;
        this.context = context;
        this.type = type;
        this.pos = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_bookmark_list_new, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBookmark_title().setText(this.data.get(position).getTitle());
        if (StringsKt.equals(this.type, "PDF", true)) {
            holder.getImg_play_pause().setVisibility(8);
        } else if (StringsKt.equals(this.type, "Video", true)) {
            holder.getImg_play_pause().setVisibility(0);
            holder.getBookmark_image().setVisibility(0);
        } else {
            holder.getImg_play_pause().setVisibility(8);
            holder.getBookmark_image().setVisibility(8);
        }
        Glide.with(holder.itemView.getContext()).load(this.data.get(position).getThumbnail_url()).centerCrop().placeholder(R.mipmap.square_placeholder).apply((BaseRequestOptions<?>) new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(16))).thumbnail(0.5f).into(holder.getBookmark_image());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: Zoom.Adapter.BookMarkListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookMarkListAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(BookMarkListAdapter bookMarkListAdapter, int i, View view) {
        if (!Helper.isConnected(bookMarkListAdapter.context)) {
            Context context = bookMarkListAdapter.context;
            Toast.makeText(context, context.getResources().getString(R.string.no_internet_connection), 0).show();
            return;
        }
        if (StringsKt.equals(bookMarkListAdapter.type, "PDF", true)) {
            Intent intent = new Intent(bookMarkListAdapter.context, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("title", bookMarkListAdapter.data.get(i).getContent_id());
            intent.putExtra("url", bookMarkListAdapter.data.get(i).getFile_url());
            intent.putExtra("pdf_name", bookMarkListAdapter.data.get(i).getTitle());
            intent.putExtra("course_id", bookMarkListAdapter.data.get(i).getCourse_ids());
            intent.putExtra("save", false);
            intent.putExtra("bookmark", "1");
            if (bookMarkListAdapter.data.get(i).getIs_download().equals("1")) {
                intent.putExtra(Const.IS_DOWNLOAD, true);
            } else {
                intent.putExtra(Const.IS_DOWNLOAD, false);
            }
            bookMarkListAdapter.context.startActivity(intent);
        }
        if (StringsKt.equals(bookMarkListAdapter.type, "Video", true)) {
            if (bookMarkListAdapter.data.get(i).getVideo_type().equals("9")) {
                if (bookMarkListAdapter.data.get(i).getFile_url().equals("")) {
                    String file_url = bookMarkListAdapter.data.get(i).getFile_url();
                    Intrinsics.checkNotNullExpressionValue(file_url, "getFile_url(...)");
                    if (file_url.length() == 0) {
                        Toast.makeText(bookMarkListAdapter.context, "No video found!", 0).show();
                        return;
                    }
                }
                Intent intent2 = new Intent(bookMarkListAdapter.context, (Class<?>) ZoomRecodedPlayer.class);
                intent2.putExtra("videoUrl", bookMarkListAdapter.data.get(i).getFile_url());
                intent2.putExtra(Const.VIDEO_ID, bookMarkListAdapter.data.get(i).getContent_id());
                intent2.putExtra("bookmark", "1");
                intent2.putExtra("live", "0");
                bookMarkListAdapter.context.startActivity(intent2);
                return;
            }
            if (TextUtils.isEmpty(bookMarkListAdapter.data.get(i).getFile_url()) && TextUtils.isEmpty(bookMarkListAdapter.data.get(i).getContent_id())) {
                Toast.makeText(bookMarkListAdapter.context, "No video found!", 0).show();
                return;
            }
            Helper.audio_service_close((Activity) bookMarkListAdapter.context);
            PdfData pdfData = bookMarkListAdapter.data.get(i);
            Intrinsics.checkNotNullExpressionValue(pdfData, "get(...)");
            bookMarkListAdapter.API_REQUEST_VIDEO_LINK(pdfData, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: BookMarkListAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"LZoom/Adapter/BookMarkListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bookmark_title", "Landroid/widget/TextView;", "getBookmark_title", "()Landroid/widget/TextView;", "setBookmark_title", "(Landroid/widget/TextView;)V", "bookmark_subject", "getBookmark_subject", "setBookmark_subject", "bookmark_image", "Landroid/widget/ImageView;", "getBookmark_image", "()Landroid/widget/ImageView;", "setBookmark_image", "(Landroid/widget/ImageView;)V", "img_play_pause", "getImg_play_pause", "setImg_play_pause", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private ImageView bookmark_image;
        private TextView bookmark_subject;
        private TextView bookmark_title;
        private ImageView img_play_pause;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.bookmark_tittle);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.bookmark_title = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.bookmark_subject);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.bookmark_subject = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.bookmark_image);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.bookmark_image = (ImageView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.img_play_pause);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.img_play_pause = (ImageView) viewFindViewById4;
        }

        public final TextView getBookmark_title() {
            return this.bookmark_title;
        }

        public final void setBookmark_title(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.bookmark_title = textView;
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
    }

    public final String getdate(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * ((long) 1000))));
    }

    private final void API_REQUEST_VIDEO_LINK(PdfData videoData, int position) {
        if (videoData.getFile_type().equals("10")) {
            this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + videoData.getFile_url())));
        } else if (videoData.getVideo_type().equals("1")) {
            Helper.GoToLiveVideoActivity("", (Activity) this.context, videoData.getFile_url(), videoData.getVideo_type(), videoData.getContent_id(), videoData.getTitle(), "0", videoData.getThumbnail_url(), "0", videoData.getContent_id(), String.valueOf(position), SingleStudy.parentCourseId, "1013", "Video", "1", "0", new ArrayList());
        } else if (videoData.getVideo_type().equals("7")) {
            Helper.GoToLiveAwsVideoActivity1(videoData.getVideo_type(), "", (Activity) this.context, videoData.getVdc_id(), videoData.getVideo_type(), videoData.getContent_id(), videoData.getTitle(), "0", videoData.getThumbnail_url(), videoData.getContent_id(), videoData.getTile_id(), videoData.getType(), "", String.valueOf(position), SingleStudy.parentCourseId, "1", new ArrayList());
        }
    }
}
