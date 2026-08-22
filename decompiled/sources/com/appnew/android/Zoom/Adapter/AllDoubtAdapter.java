package com.appnew.android.Zoom.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.ZoomModel.DoubtData;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Zoom.Activity.DoubtChatActivity;
import com.appnew.android.Zoom.Activity.DoubtChatActivityFirebase;
import com.appnew.android.Zoom.Activity.DoubtsActivity;
import com.appnew.android.Zoom.Adapter.AllDoubtAdapter;
import com.appnew.android.player.music_player.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: AllDoubtAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001[B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0018H\u0016J\u001a\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00022\b\b\u0001\u0010;\u001a\u00020\u0018H\u0017J\u0018\u0010<\u001a\u0002092\u0006\u0010:\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u0018H\u0002J \u0010=\u001a\u0002092\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010;\u001a\u00020\u0018H\u0002J\b\u0010B\u001a\u000209H\u0002J*\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010D2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020HH\u0016J(\u0010I\u001a\u0002092\u0006\u0010J\u001a\u00020K2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010L\u001a\u00020AH\u0016J \u0010M\u001a\u0002092\u0006\u0010J\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nH\u0016J\u0010\u0010N\u001a\u0002092\u0006\u0010O\u001a\u00020\nH\u0002J\u0018\u0010P\u001a\u0002092\u0006\u0010:\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u0018H\u0002J\b\u0010Q\u001a\u00020\u0018H\u0016J\u0010\u0010R\u001a\u0004\u0018\u00010\n2\u0006\u0010S\u001a\u00020\nJ*\u0010T\u001a\u0002092\u0006\u0010:\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010;\u001a\u00020\u0018J\u0018\u0010Y\u001a\u0002092\u0006\u0010:\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u0018H\u0002J\u0006\u0010Z\u001a\u000209R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010201X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006\\"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/AllDoubtAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/AllDoubtAdapter$ViewHolder;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "data", "", "Lcom/appnew/android/Model/ZoomModel/DoubtData;", "context", "Landroid/content/Context;", "doubtType", "", "<init>", "(Ljava/util/List;Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDoubtType", "()Ljava/lang/String;", "setDoubtType", "(Ljava/lang/String;)V", "mediaPlayer", "Landroid/media/MediaPlayer;", "lastselected", "", "timer", "Ljava/util/Timer;", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "getI", "()I", "setI", "(I)V", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", Const.RATINGS, "ratingType", "ratingMessage", "mLastClickTime", "", "getMLastClickTime", "()J", "setMLastClickTime", "(J)V", "currentItemPosition", "feedbackDialog", "", "Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog;", "[Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "setClicks", "manageFeedbackButton", "doubtFeedback", "Landroid/widget/TextView;", "isReviewSubmitted", "", "openFeedbackBottomSheet", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "showMessage", "message", "setData", "getItemCount", "getdate", "timestamp", "starttimer", "Landroid/app/Dialog;", "pauser", "Landroid/widget/Button;", "play", "handleOnCheck", "stoptimer", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AllDoubtAdapter extends RecyclerView.Adapter<ViewHolder> implements NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private Context context;
    private int currentItemPosition;
    private final List<DoubtData> data;
    private String doubtType;
    private final Utils.FeedbackBottomSheetDialog[] feedbackDialog;
    private int i;
    private int lastselected;
    private long mLastClickTime;
    private MediaPlayer mediaPlayer;
    private NetworkCall networkCall;
    private String rating;
    private String ratingMessage;
    private final int ratingType;
    private Timer timer;

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final String getDoubtType() {
        return this.doubtType;
    }

    public final void setDoubtType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.doubtType = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AllDoubtAdapter(List<? extends DoubtData> data, Context context, String doubtType) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(doubtType, "doubtType");
        this.data = data;
        this.context = context;
        this.doubtType = doubtType;
        this.rating = "";
        this.ratingType = 4;
        this.ratingMessage = "";
        this.currentItemPosition = -1;
        this.feedbackDialog = new Utils.FeedbackBottomSheetDialog[1];
    }

    public final int getI() {
        return this.i;
    }

    public final void setI(int i) {
        this.i = i;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final long getMLastClickTime() {
        return this.mLastClickTime;
    }

    public final void setMLastClickTime(long j) {
        this.mLastClickTime = j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.doubt_layout_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0128  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(com.appnew.android.Zoom.Adapter.AllDoubtAdapter.ViewHolder r9, final int r10) {
        /*
            Method dump skipped, instruction units count: 657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Zoom.Adapter.AllDoubtAdapter.onBindViewHolder(com.appnew.android.Zoom.Adapter.AllDoubtAdapter$ViewHolder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(AllDoubtAdapter allDoubtAdapter, int i, View view) {
        if (Helper.isNetworkConnected(allDoubtAdapter.context)) {
            if (SharedPreference.getInstance().getString(Const.DOUBT_FIREBASE_CHAT).equals("1")) {
                if (!TextUtils.isEmpty(allDoubtAdapter.data.get(i).getChat_node())) {
                    Intent intent = new Intent(allDoubtAdapter.context, (Class<?>) DoubtChatActivityFirebase.class);
                    intent.putExtra("Chat_type", "1");
                    intent.putExtra("data", allDoubtAdapter.data.get(i));
                    intent.putExtra("doubtType", allDoubtAdapter.doubtType);
                    intent.putExtra("doubtId", allDoubtAdapter.data.get(i).getDoubt_id());
                    intent.putExtra("Chat_node", allDoubtAdapter.data.get(i).getChat_node());
                    allDoubtAdapter.context.startActivity(intent);
                    return;
                }
                Toast.makeText(allDoubtAdapter.context, "Chat node not enable.", 0).show();
                return;
            }
            Intent intent2 = new Intent(allDoubtAdapter.context, (Class<?>) DoubtChatActivity.class);
            intent2.putExtra("Chat_type", "1");
            intent2.putExtra("data", allDoubtAdapter.data.get(i));
            intent2.putExtra("doubtType", allDoubtAdapter.doubtType);
            intent2.putExtra("doubtId", allDoubtAdapter.data.get(i).getDoubt_id());
            intent2.putExtra("Chat_node", allDoubtAdapter.data.get(i).getChat_node());
            allDoubtAdapter.context.startActivity(intent2);
            return;
        }
        Helper.showInternetToast(allDoubtAdapter.context);
    }

    private final void setClicks(ViewHolder holder, final int position) {
        holder.getLinearLayoutImage().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AllDoubtAdapter.setClicks$lambda$2(this.f$0, position, view);
            }
        });
        holder.getLinearLayoutAudio().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AllDoubtAdapter.setClicks$lambda$7(this.f$0, position, view);
            }
        });
        holder.getLinearLayoutPdf().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AllDoubtAdapter.setClicks$lambda$8(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClicks$lambda$2(AllDoubtAdapter allDoubtAdapter, int i, View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(allDoubtAdapter.context);
        Context context = allDoubtAdapter.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        View viewInflate = layoutInflater.inflate(R.layout.image_layout, (ViewGroup) null);
        builder.setView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.cancel);
        String doubt_image = allDoubtAdapter.data.get(i).getDoubt_image();
        Intrinsics.checkNotNullExpressionValue(doubt_image, "getDoubt_image(...)");
        String str = "";
        for (String str2 : StringsKt.split$default((CharSequence) doubt_image, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null)) {
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) ".jpg", false, 2, (Object) null)) {
                str = str2;
            }
        }
        if (!Intrinsics.areEqual(allDoubtAdapter.data.get(i).getUser_name(), "")) {
            Intrinsics.checkNotNull(Glide.with(allDoubtAdapter.context.getApplicationContext()).load(str).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.color.colorPrimary).error(R.color.colorPrimary).diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate()).into(imageView));
        } else {
            imageView.setImageResource(com.appnew.android.R.drawable.profile_grey);
        }
        final AlertDialog alertDialogShow = builder.show();
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                alertDialogShow.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v12, types: [T, android.widget.Button] */
    /* JADX WARN: Type inference failed for: r9v9, types: [T, android.widget.Button] */
    public static final void setClicks$lambda$7(final AllDoubtAdapter allDoubtAdapter, final int i, View view) {
        if (!Helper.isNetworkConnected(allDoubtAdapter.context)) {
            Helper.showInternetToast(allDoubtAdapter.context);
            return;
        }
        final Dialog dialog = new Dialog(allDoubtAdapter.context);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_audioplayer);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        View viewFindViewById = dialog.findViewById(R.id.audioplay1);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.Button");
        objectRef.element = (Button) viewFindViewById;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        View viewFindViewById2 = dialog.findViewById(R.id.audiopause1);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.Button");
        objectRef2.element = (Button) viewFindViewById2;
        View viewFindViewById3 = dialog.findViewById(R.id.cancel);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        View viewFindViewById4 = dialog.findViewById(R.id.audioText_username);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById4).setText(allDoubtAdapter.data.get(i).getUser_name());
        ((Button) objectRef.element).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AllDoubtAdapter.setClicks$lambda$7$lambda$4(this.f$0, objectRef, objectRef2, i, dialog, view2);
            }
        });
        ((Button) objectRef2.element).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AllDoubtAdapter.setClicks$lambda$7$lambda$5(objectRef, objectRef2, allDoubtAdapter, view2);
            }
        });
        ((ImageView) viewFindViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AllDoubtAdapter.setClicks$lambda$7$lambda$6(this.f$0, dialog, view2);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setClicks$lambda$7$lambda$4(AllDoubtAdapter allDoubtAdapter, final Ref.ObjectRef objectRef, final Ref.ObjectRef objectRef2, int i, Dialog dialog, View view) {
        if (!Helper.isNetworkConnected(allDoubtAdapter.context)) {
            Helper.showInternetToast(allDoubtAdapter.context);
            return;
        }
        Context context = allDoubtAdapter.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.Zoom.Activity.DoubtsActivity");
        ((DoubtsActivity) context).setDialogShown(true);
        ((Button) objectRef.element).setVisibility(8);
        ((Button) objectRef2.element).setVisibility(0);
        MediaPlayer mediaPlayer = allDoubtAdapter.mediaPlayer;
        if (mediaPlayer == null) {
            allDoubtAdapter.lastselected = i;
            MediaPlayer mediaPlayerCreate = MediaPlayer.create(allDoubtAdapter.context, Uri.parse(allDoubtAdapter.data.get(i).getDoubt_audio()));
            allDoubtAdapter.mediaPlayer = mediaPlayerCreate;
            if (mediaPlayerCreate != null) {
                mediaPlayerCreate.start();
            }
            allDoubtAdapter.starttimer(dialog, (Button) objectRef2.element, (Button) objectRef.element, i);
        } else {
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = allDoubtAdapter.mediaPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.pause();
                }
                allDoubtAdapter.stoptimer();
                MediaPlayer mediaPlayerCreate2 = MediaPlayer.create(allDoubtAdapter.context, Uri.parse(allDoubtAdapter.data.get(i).getDoubt_audio()));
                allDoubtAdapter.mediaPlayer = mediaPlayerCreate2;
                if (mediaPlayerCreate2 != null) {
                    mediaPlayerCreate2.start();
                }
                allDoubtAdapter.starttimer(dialog, (Button) objectRef2.element, (Button) objectRef.element, i);
            } else {
                allDoubtAdapter.lastselected = i;
                allDoubtAdapter.notifyItemChanged(i);
                MediaPlayer mediaPlayerCreate3 = MediaPlayer.create(allDoubtAdapter.context, Uri.parse(allDoubtAdapter.data.get(i).getDoubt_audio()));
                allDoubtAdapter.mediaPlayer = mediaPlayerCreate3;
                if (mediaPlayerCreate3 != null) {
                    mediaPlayerCreate3.start();
                }
                allDoubtAdapter.starttimer(dialog, (Button) objectRef2.element, (Button) objectRef.element, i);
            }
        }
        MediaPlayer mediaPlayer3 = allDoubtAdapter.mediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer3);
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer4) {
                AllDoubtAdapter.setClicks$lambda$7$lambda$4$lambda$3(objectRef, objectRef2, mediaPlayer4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setClicks$lambda$7$lambda$4$lambda$3(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, MediaPlayer mediaPlayer) {
        ((Button) objectRef.element).setVisibility(0);
        ((Button) objectRef2.element).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setClicks$lambda$7$lambda$5(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, AllDoubtAdapter allDoubtAdapter, View view) {
        ((Button) objectRef.element).setVisibility(0);
        ((Button) objectRef2.element).setVisibility(8);
        MediaPlayer mediaPlayer = allDoubtAdapter.mediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer);
        if (mediaPlayer.isPlaying()) {
            MediaPlayer mediaPlayer2 = allDoubtAdapter.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.pause();
            }
            allDoubtAdapter.stoptimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClicks$lambda$7$lambda$6(AllDoubtAdapter allDoubtAdapter, Dialog dialog, View view) {
        MediaPlayer mediaPlayer = allDoubtAdapter.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClicks$lambda$8(AllDoubtAdapter allDoubtAdapter, int i, View view) {
        if (Helper.isNetworkConnected(allDoubtAdapter.context)) {
            String doubt_image = allDoubtAdapter.data.get(i).getDoubt_image();
            Intrinsics.checkNotNullExpressionValue(doubt_image, "getDoubt_image(...)");
            String str = "";
            for (String str2 : StringsKt.split$default((CharSequence) doubt_image, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null)) {
                if (StringsKt.contains$default((CharSequence) str2, (CharSequence) ".pdf", false, 2, (Object) null)) {
                    str = str2;
                }
            }
            Intent intent = new Intent(allDoubtAdapter.context, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("url", str);
            intent.putExtra("from", "ChatAdapter");
            allDoubtAdapter.context.startActivity(intent);
            return;
        }
        Helper.showInternetToast(allDoubtAdapter.context);
    }

    private final void manageFeedbackButton(TextView doubtFeedback, boolean isReviewSubmitted, final int position) {
        if (isReviewSubmitted) {
            doubtFeedback.setText("Review Submitted");
            doubtFeedback.setTextColor(Color.parseColor("#00a651"));
            doubtFeedback.setEnabled(false);
            doubtFeedback.setOnClickListener(null);
            return;
        }
        doubtFeedback.setEnabled(true);
        doubtFeedback.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AllDoubtAdapter.manageFeedbackButton$lambda$9(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void manageFeedbackButton$lambda$9(AllDoubtAdapter allDoubtAdapter, int i, View view) {
        if (!Helper.isConnected(allDoubtAdapter.context)) {
            String string = allDoubtAdapter.context.getString(R.string.please_connect_internet_connection);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            allDoubtAdapter.showMessage(string);
        } else {
            if (SystemClock.uptimeMillis() - allDoubtAdapter.mLastClickTime < 800) {
                return;
            }
            allDoubtAdapter.mLastClickTime = SystemClock.uptimeMillis();
            allDoubtAdapter.currentItemPosition = i;
            allDoubtAdapter.openFeedbackBottomSheet();
        }
    }

    private final void openFeedbackBottomSheet() {
        this.feedbackDialog[0] = new Utils.FeedbackBottomSheetDialog(this.context, new AnonymousClass1());
        Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog = this.feedbackDialog[0];
        if (feedbackBottomSheetDialog != null) {
            Utils.INSTANCE.bottomSheet(new Utils.FeedbackBottomSheetDialog[]{feedbackBottomSheetDialog});
        }
        Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog2 = this.feedbackDialog[0];
        if (feedbackBottomSheetDialog2 != null) {
            feedbackBottomSheetDialog2.show();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$openFeedbackBottomSheet$1, reason: invalid class name */
    /* JADX INFO: compiled from: AllDoubtAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/appnew/android/Zoom/Adapter/AllDoubtAdapter$openFeedbackBottomSheet$1", "Lcom/appnew/android/player/music_player/Utils$FeedbackBottomSheetDialog$Listener;", "onClose", "", "onSubmit", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements Utils.FeedbackBottomSheetDialog.Listener {
        AnonymousClass1() {
        }

        @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
        public void onClose() {
            Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog = AllDoubtAdapter.this.feedbackDialog[0];
            if (feedbackBottomSheetDialog != null) {
                feedbackBottomSheetDialog.dismiss();
            }
        }

        @Override // com.appnew.android.player.music_player.Utils.FeedbackBottomSheetDialog.Listener
        public void onSubmit() {
            Activity activity;
            Utils.FeedbackBottomSheetDialog feedbackBottomSheetDialog = AllDoubtAdapter.this.feedbackDialog[0];
            if (feedbackBottomSheetDialog == null || !feedbackBottomSheetDialog.isShowing()) {
                Context context = AllDoubtAdapter.this.getContext();
                activity = context instanceof Activity ? (Activity) context : null;
                if (activity != null) {
                    final AllDoubtAdapter allDoubtAdapter = AllDoubtAdapter.this;
                    activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$openFeedbackBottomSheet$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            AllDoubtAdapter.AnonymousClass1.onSubmit$lambda$0(allDoubtAdapter);
                        }
                    });
                    return;
                }
                return;
            }
            RatingBar ratingBar = (RatingBar) feedbackBottomSheetDialog.findViewById(R.id.ratingBar);
            EditText editText = (EditText) feedbackBottomSheetDialog.findViewById(R.id.ratingComment);
            if (ratingBar == null || editText == null) {
                feedbackBottomSheetDialog.dismiss();
                Context context2 = AllDoubtAdapter.this.getContext();
                activity = context2 instanceof Activity ? (Activity) context2 : null;
                if (activity != null) {
                    final AllDoubtAdapter allDoubtAdapter2 = AllDoubtAdapter.this;
                    activity.runOnUiThread(new Runnable() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$openFeedbackBottomSheet$1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AllDoubtAdapter.AnonymousClass1.onSubmit$lambda$1(allDoubtAdapter2);
                        }
                    });
                    return;
                }
                return;
            }
            float rating = ratingBar.getRating();
            String string = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
            if (rating <= 0.0f) {
                Toast.makeText(AllDoubtAdapter.this.getContext(), R.string.pls_select_rating, 0).show();
                return;
            }
            if (string.length() != 0) {
                AllDoubtAdapter.this.rating = String.valueOf(rating);
                AllDoubtAdapter.this.ratingMessage = string;
                feedbackBottomSheetDialog.dismiss();
                NetworkCall networkCall = AllDoubtAdapter.this.getNetworkCall();
                if (networkCall != null) {
                    networkCall.NetworkAPICall(API.POST_COURSE_REVIEW, "", true, false);
                    return;
                }
                return;
            }
            Toast.makeText(AllDoubtAdapter.this.getContext(), R.string.pls_write_rating, 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSubmit$lambda$0(AllDoubtAdapter allDoubtAdapter) {
            Toast.makeText(allDoubtAdapter.getContext(), R.string.something_went_wrong, 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onSubmit$lambda$1(AllDoubtAdapter allDoubtAdapter) {
            Toast.makeText(allDoubtAdapter.getContext(), R.string.something_went_wrong, 0).show();
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.POST_COURSE_REVIEW)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setCourse_id(this.data.get(this.currentItemPosition).getDoubt_id());
        encryptionData.setRating(this.rating);
        encryptionData.setMessage(this.ratingMessage);
        encryptionData.setRating_type(Integer.valueOf(this.ratingType));
        return service.postCourseReview(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        if (Intrinsics.areEqual(apitype, API.POST_COURSE_REVIEW)) {
            if (Intrinsics.areEqual(jsonstring.optString("status"), "true")) {
                int i = this.currentItemPosition;
                if (i != -1) {
                    this.data.get(i).setStatus("1");
                    this.data.get(this.currentItemPosition).setIsReviewSubmitted("1");
                    notifyItemChanged(this.currentItemPosition);
                }
                Utils.INSTANCE.showGreetingDialog(this.context, "Thank’s for your valuable feedback !");
                return;
            }
            String strOptString = jsonstring.optString("message", this.context.getString(R.string.something_went_wrong));
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            showMessage(strOptString);
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        Intrinsics.checkNotNullParameter(apitype, "apitype");
        Intrinsics.checkNotNullParameter(typeApi, "typeApi");
        showMessage("Something went wrong");
    }

    private final void showMessage(final String message) {
        com.clevertap.android.sdk.Utils.runOnUiThread(new Runnable() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AllDoubtAdapter.showMessage$lambda$12(message, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMessage$lambda$12(String str, AllDoubtAdapter allDoubtAdapter) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (StringsKt.contains((CharSequence) str2, (CharSequence) "failed to connect", true)) {
            str = "Failed to connect with server";
        }
        Toast.makeText(allDoubtAdapter.context, str, 0).show();
    }

    private final void setData(ViewHolder holder, int position) {
        holder.getTitle().setText(this.data.get(position).getSubject_name());
        holder.getUser_name().setText(this.data.get(position).getUser_name());
        holder.getUser_comment().setText(this.data.get(position).getDoubt_message());
        TextView date_time = holder.getDate_time();
        String created_at = this.data.get(position).getCreated_at();
        Intrinsics.checkNotNullExpressionValue(created_at, "getCreated_at(...)");
        date_time.setText(getdate(created_at));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: AllDoubtAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b'\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u001a\u0010*\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR\u001a\u0010-\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR\u001a\u00100\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0005R\u001a\u00104\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0014R\u001a\u00107\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\t\"\u0004\b9\u0010\u000bR\u001a\u0010:\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\t\"\u0004\b<\u0010\u000bR\u001a\u0010=\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\t\"\u0004\b?\u0010\u000bR\u001a\u0010@\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\t\"\u0004\bB\u0010\u000b¨\u0006C"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/AllDoubtAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "Subject_status", "getSubject_status", "setSubject_status", "linearLayoutAudio", "Landroid/widget/LinearLayout;", "getLinearLayoutAudio", "()Landroid/widget/LinearLayout;", "setLinearLayoutAudio", "(Landroid/widget/LinearLayout;)V", "linearLayoutImage", "getLinearLayoutImage", "setLinearLayoutImage", "linearLayoutPdf", "getLinearLayoutPdf", "setLinearLayoutPdf", "user_doubtAudio", "Landroid/widget/ImageView;", "getUser_doubtAudio", "()Landroid/widget/ImageView;", "setUser_doubtAudio", "(Landroid/widget/ImageView;)V", AnalyticsConstants.user_name, "getUser_name", "setUser_name", "user_comment", "getUser_comment", "setUser_comment", "date_time", "getDate_time", "setDate_time", "replayChat", "getReplayChat", "setReplayChat", "replayMsg", "getReplayMsg", "setReplayMsg", "isbnLineId", "getIsbnLineId", "()Landroid/view/View;", "setIsbnLineId", "isbnLayout", "getIsbnLayout", "setIsbnLayout", "bookNameText", "getBookNameText", "setBookNameText", "pageNoText", "getPageNoText", "setPageNoText", "questionNoText", "getQuestionNoText", "setQuestionNoText", "doubtFeedback", "getDoubtFeedback", "setDoubtFeedback", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private TextView Subject_status;
        private TextView bookNameText;
        private TextView date_time;
        private TextView doubtFeedback;
        private LinearLayout isbnLayout;
        private View isbnLineId;
        private LinearLayout linearLayoutAudio;
        private LinearLayout linearLayoutImage;
        private LinearLayout linearLayoutPdf;
        private TextView pageNoText;
        private TextView questionNoText;
        private TextView replayChat;
        private TextView replayMsg;
        private TextView title;
        private TextView user_comment;
        private ImageView user_doubtAudio;
        private TextView user_name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.Subject_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.Subject_status);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.Subject_status = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.linearLayoutAudio);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.linearLayoutAudio = (LinearLayout) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.linearLayoutImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.linearLayoutImage = (LinearLayout) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.linearLayoutPdf);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.linearLayoutPdf = (LinearLayout) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.user_doubtAudio);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.user_doubtAudio = (ImageView) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.user_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.user_name = (TextView) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.user_comment);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.user_comment = (TextView) viewFindViewById8;
            View viewFindViewById9 = view.findViewById(R.id.date_time);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.date_time = (TextView) viewFindViewById9;
            View viewFindViewById10 = view.findViewById(R.id.replayChat);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
            this.replayChat = (TextView) viewFindViewById10;
            View viewFindViewById11 = view.findViewById(R.id.replayMsg);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
            this.replayMsg = (TextView) viewFindViewById11;
            View viewFindViewById12 = view.findViewById(R.id.isbnLineId);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
            this.isbnLineId = viewFindViewById12;
            View viewFindViewById13 = view.findViewById(R.id.isbnLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
            this.isbnLayout = (LinearLayout) viewFindViewById13;
            View viewFindViewById14 = view.findViewById(R.id.bookNameText);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
            this.bookNameText = (TextView) viewFindViewById14;
            View viewFindViewById15 = view.findViewById(R.id.pageNoText);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
            this.pageNoText = (TextView) viewFindViewById15;
            View viewFindViewById16 = view.findViewById(R.id.questionNoText);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
            this.questionNoText = (TextView) viewFindViewById16;
            View viewFindViewById17 = view.findViewById(R.id.doubtFeedback);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
            this.doubtFeedback = (TextView) viewFindViewById17;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final void setTitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.title = textView;
        }

        public final TextView getSubject_status() {
            return this.Subject_status;
        }

        public final void setSubject_status(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.Subject_status = textView;
        }

        public final LinearLayout getLinearLayoutAudio() {
            return this.linearLayoutAudio;
        }

        public final void setLinearLayoutAudio(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.linearLayoutAudio = linearLayout;
        }

        public final LinearLayout getLinearLayoutImage() {
            return this.linearLayoutImage;
        }

        public final void setLinearLayoutImage(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.linearLayoutImage = linearLayout;
        }

        public final LinearLayout getLinearLayoutPdf() {
            return this.linearLayoutPdf;
        }

        public final void setLinearLayoutPdf(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.linearLayoutPdf = linearLayout;
        }

        public final ImageView getUser_doubtAudio() {
            return this.user_doubtAudio;
        }

        public final void setUser_doubtAudio(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.user_doubtAudio = imageView;
        }

        public final TextView getUser_name() {
            return this.user_name;
        }

        public final void setUser_name(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.user_name = textView;
        }

        public final TextView getUser_comment() {
            return this.user_comment;
        }

        public final void setUser_comment(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.user_comment = textView;
        }

        public final TextView getDate_time() {
            return this.date_time;
        }

        public final void setDate_time(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.date_time = textView;
        }

        public final TextView getReplayChat() {
            return this.replayChat;
        }

        public final void setReplayChat(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.replayChat = textView;
        }

        public final TextView getReplayMsg() {
            return this.replayMsg;
        }

        public final void setReplayMsg(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.replayMsg = textView;
        }

        public final View getIsbnLineId() {
            return this.isbnLineId;
        }

        public final void setIsbnLineId(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.isbnLineId = view;
        }

        public final LinearLayout getIsbnLayout() {
            return this.isbnLayout;
        }

        public final void setIsbnLayout(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.isbnLayout = linearLayout;
        }

        public final TextView getBookNameText() {
            return this.bookNameText;
        }

        public final void setBookNameText(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.bookNameText = textView;
        }

        public final TextView getPageNoText() {
            return this.pageNoText;
        }

        public final void setPageNoText(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.pageNoText = textView;
        }

        public final TextView getQuestionNoText() {
            return this.questionNoText;
        }

        public final void setQuestionNoText(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.questionNoText = textView;
        }

        public final TextView getDoubtFeedback() {
            return this.doubtFeedback;
        }

        public final void setDoubtFeedback(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.doubtFeedback = textView;
        }
    }

    public final String getdate(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * ((long) 1000))));
    }

    /* JADX INFO: renamed from: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$starttimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AllDoubtAdapter.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/appnew/android/Zoom/Adapter/AllDoubtAdapter$starttimer$1", "Ljava/util/TimerTask;", "run", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C05611 extends TimerTask {
        C05611() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Context context = AllDoubtAdapter.this.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            final AllDoubtAdapter allDoubtAdapter = AllDoubtAdapter.this;
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.appnew.android.Zoom.Adapter.AllDoubtAdapter$starttimer$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AllDoubtAdapter.C05611.run$lambda$0(allDoubtAdapter);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(AllDoubtAdapter allDoubtAdapter) {
            if (allDoubtAdapter.timer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
            }
            MediaPlayer mediaPlayer = allDoubtAdapter.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                return;
            }
            allDoubtAdapter.stoptimer();
        }
    }

    public final void starttimer(Dialog holder, Button pauser, Button play, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(new C05611(), 0L, 1000L);
    }

    private final void handleOnCheck(ViewHolder holder, int position) {
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.DOUBT_ISBN_BASED), "1", true)) {
            holder.getIsbnLayout().setVisibility(0);
            holder.getIsbnLineId().setVisibility(0);
            holder.getBookNameText().setText(this.data.get(position).getSubject_name());
            holder.getPageNoText().setText(this.data.get(position).getPageNo());
            holder.getQuestionNoText().setText(this.data.get(position).getQuestionNo());
            return;
        }
        holder.getIsbnLayout().setVisibility(8);
        holder.getIsbnLineId().setVisibility(8);
    }

    public final void stoptimer() {
        if (this.timer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
        }
        Timer timer = this.timer;
        if (timer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
            timer = null;
        }
        timer.cancel();
    }
}
