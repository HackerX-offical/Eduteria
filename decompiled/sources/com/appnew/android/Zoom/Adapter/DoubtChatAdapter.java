package com.appnew.android.Zoom.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.Model.ZoomModel.ReplyModel;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Zoom.Activity.DoubtChatActivity;
import com.appnew.android.Zoom.Adapter.DoubtChatAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: DoubtChatAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u001cJ\b\u0010#\u001a\u00020\u000fH\u0016J*\u0010$\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u001e\u001a\u00020\u000fJ\u0006\u0010)\u001a\u00020\u001cR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/DoubtChatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/Zoom/Adapter/DoubtChatAdapter$ViewHolder;", "data", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/ZoomModel/ReplyModel;", "context", "Landroid/content/Context;", "<init>", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mediaPlayer", "Landroid/media/MediaPlayer;", "lastselected", "", "timer", "Ljava/util/Timer;", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "getI", "()I", "setI", "(I)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", Const.POSITION, "setClickImage", "setClickAudio", "updateList", "clearList", "getItemCount", "starttimer", "Landroid/app/Dialog;", "pauser", "Landroid/widget/Button;", "play", "stoptimer", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubtChatAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private final ArrayList<ReplyModel> data;
    private int i;
    private int lastselected;
    private MediaPlayer mediaPlayer;
    private Timer timer;

    public DoubtChatAdapter(ArrayList<ReplyModel> arrayList, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = arrayList;
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getI() {
        return this.i;
    }

    public final void setI(int i) {
        this.i = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_doubt_chat_new, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ArrayList<ReplyModel> arrayList = this.data;
        Intrinsics.checkNotNull(arrayList);
        if (arrayList.get(position).getIs_admin().equals("1")) {
            ArrayList<ReplyModel> arrayList2 = this.data;
            Intrinsics.checkNotNull(arrayList2);
            if (arrayList2.get(position).getType().equals("1")) {
                holder.getCvrLeftimage().setVisibility(8);
                holder.getCvrLeftAudio().setVisibility(8);
                holder.getMasterMessageCard().setVisibility(0);
                holder.getUserMessageCard().setVisibility(8);
                Helper.TestWebHTMLLoad(holder.getReplayMessage(), this.data.get(position).getReply());
                ClickableWebView replayMessage = holder.getReplayMessage();
                replayMessage.setBackgroundColor(0);
                replayMessage.setLayerType(2, null);
                holder.getTv_time().setGravity(GravityCompat.START);
            } else {
                ArrayList<ReplyModel> arrayList3 = this.data;
                Intrinsics.checkNotNull(arrayList3);
                if (arrayList3.get(position).getType().equals("2")) {
                    holder.getCvrLeftimage().setVisibility(0);
                    holder.getCvrLeftAudio().setVisibility(8);
                    holder.getMasterMessageCard().setVisibility(8);
                    holder.getUserMessageCard().setVisibility(8);
                    Glide.with(this.context).load(this.data.get(position).getReply()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder)).into(holder.getLetfmessageTvimage());
                    holder.getTv_time().setGravity(GravityCompat.START);
                } else {
                    ArrayList<ReplyModel> arrayList4 = this.data;
                    Intrinsics.checkNotNull(arrayList4);
                    if (arrayList4.get(position).getType().equals("3")) {
                        holder.getCvrLeftimage().setVisibility(8);
                        holder.getCvrLeftAudio().setVisibility(0);
                        holder.getMasterMessageCard().setVisibility(8);
                        holder.getUserMessageCard().setVisibility(8);
                        Helper.TestWebHTMLLoad(holder.getReplayMessage(), this.data.get(position).getReply());
                        ClickableWebView replayMessage2 = holder.getReplayMessage();
                        replayMessage2.setBackgroundColor(0);
                        replayMessage2.setLayerType(2, null);
                        holder.getTv_time().setGravity(GravityCompat.START);
                    }
                }
            }
        } else if (this.data.get(position).getIs_admin().equals("0")) {
            holder.getMasterMessageCard().setVisibility(8);
            holder.getUserMessageCard().setVisibility(0);
            holder.getUserMessage().setText(this.data.get(position).getReply());
            holder.getTv_time().setGravity(GravityCompat.END);
        } else {
            holder.getMasterMessageCard().setVisibility(8);
            holder.getUserMessageCard().setVisibility(8);
            holder.getTv_time().setVisibility(8);
        }
        try {
            String created_at = this.data.get(position).getCreated_at();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm aa");
            Intrinsics.checkNotNull(created_at);
            long j = Long.parseLong(created_at) * ((long) 1000);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            holder.getTv_time().setText(simpleDateFormat.format(calendar.getTime()));
        } catch (Exception unused) {
        }
        holder.getCvrLeftAudio().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.DoubtChatAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.setClickAudio(holder, position);
            }
        });
        holder.getCvrLeftimage().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.DoubtChatAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.setClickImage(holder, position);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setClickImage(ViewHolder holder, int position) {
        String str;
        ReplyModel replyModel;
        ReplyModel replyModel2;
        String reply;
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        String reply2 = null;
        View viewInflate = layoutInflater.inflate(R.layout.image_layout_new, (ViewGroup) null);
        builder.setView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.cancel);
        ArrayList<ReplyModel> arrayList = this.data;
        List<String> listSplit$default = (arrayList == null || (replyModel2 = arrayList.get(position)) == null || (reply = replyModel2.getReply()) == null) ? null : StringsKt.split$default((CharSequence) reply, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null);
        if (listSplit$default == null) {
            str = "";
        } else {
            str = "";
            for (String str2 : listSplit$default) {
                String str3 = str2;
                if (StringsKt.contains$default((CharSequence) str3, (CharSequence) ".jpg", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str3, (CharSequence) ".png", false, 2, (Object) null)) {
                    str = str2;
                }
            }
        }
        ArrayList<ReplyModel> arrayList2 = this.data;
        if (arrayList2 != null && (replyModel = arrayList2.get(position)) != null) {
            reply2 = replyModel.getReply();
        }
        if (!Intrinsics.areEqual(reply2, "")) {
            Intrinsics.checkNotNull(Glide.with(((Activity) this.context).getApplicationContext()).load(str).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.color.colorPrimary).error(R.color.colorPrimary).diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate()).into(imageView));
        } else {
            imageView.setImageResource(com.appnew.android.R.drawable.profile_grey);
        }
        final AlertDialog alertDialogShow = builder.show();
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.DoubtChatAdapter$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogShow.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v12, types: [T, android.widget.Button] */
    /* JADX WARN: Type inference failed for: r8v9, types: [T, android.widget.Button] */
    public final void setClickAudio(ViewHolder holder, final int position) {
        if (!Helper.isNetworkConnected(this.context)) {
            Helper.showInternetToast(this.context);
            return;
        }
        final Dialog dialog = new Dialog(this.context);
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
        ((TextView) viewFindViewById4).setText("Audio");
        ((Button) objectRef.element).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.DoubtChatAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DoubtChatAdapter.setClickAudio$lambda$6(this.f$0, objectRef, objectRef2, position, dialog, view);
            }
        });
        ((Button) objectRef2.element).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.DoubtChatAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DoubtChatAdapter.setClickAudio$lambda$7(objectRef, objectRef2, this, view);
            }
        });
        ((ImageView) viewFindViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.DoubtChatAdapter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DoubtChatAdapter.setClickAudio$lambda$8(this.f$0, dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setClickAudio$lambda$6(DoubtChatAdapter doubtChatAdapter, final Ref.ObjectRef objectRef, final Ref.ObjectRef objectRef2, int i, Dialog dialog, View view) {
        ReplyModel replyModel;
        ReplyModel replyModel2;
        ReplyModel replyModel3;
        if (!Helper.isNetworkConnected(doubtChatAdapter.context)) {
            Helper.showInternetToast(doubtChatAdapter.context);
            return;
        }
        Context context = doubtChatAdapter.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.appnew.android.Zoom.Activity.DoubtChatActivity");
        ((DoubtChatActivity) context).setDialogShown(true);
        ((Button) objectRef.element).setVisibility(8);
        ((Button) objectRef2.element).setVisibility(0);
        MediaPlayer mediaPlayer = doubtChatAdapter.mediaPlayer;
        String reply = null;
        if (mediaPlayer == null) {
            doubtChatAdapter.lastselected = i;
            Context context2 = doubtChatAdapter.context;
            ArrayList<ReplyModel> arrayList = doubtChatAdapter.data;
            if (arrayList != null && (replyModel3 = arrayList.get(i)) != null) {
                reply = replyModel3.getReply();
            }
            MediaPlayer mediaPlayerCreate = MediaPlayer.create(context2, Uri.parse(reply));
            doubtChatAdapter.mediaPlayer = mediaPlayerCreate;
            if (mediaPlayerCreate != null) {
                mediaPlayerCreate.start();
            }
            doubtChatAdapter.starttimer(dialog, (Button) objectRef2.element, (Button) objectRef.element, i);
        } else {
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = doubtChatAdapter.mediaPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.pause();
                }
                doubtChatAdapter.stoptimer();
                Context context3 = doubtChatAdapter.context;
                ArrayList<ReplyModel> arrayList2 = doubtChatAdapter.data;
                if (arrayList2 != null && (replyModel2 = arrayList2.get(i)) != null) {
                    reply = replyModel2.getReply();
                }
                MediaPlayer mediaPlayerCreate2 = MediaPlayer.create(context3, Uri.parse(reply));
                doubtChatAdapter.mediaPlayer = mediaPlayerCreate2;
                if (mediaPlayerCreate2 != null) {
                    mediaPlayerCreate2.start();
                }
                doubtChatAdapter.starttimer(dialog, (Button) objectRef2.element, (Button) objectRef.element, i);
            } else {
                doubtChatAdapter.lastselected = i;
                doubtChatAdapter.notifyItemChanged(i);
                Context context4 = doubtChatAdapter.context;
                ArrayList<ReplyModel> arrayList3 = doubtChatAdapter.data;
                if (arrayList3 != null && (replyModel = arrayList3.get(i)) != null) {
                    reply = replyModel.getReply();
                }
                MediaPlayer mediaPlayerCreate3 = MediaPlayer.create(context4, Uri.parse(reply));
                doubtChatAdapter.mediaPlayer = mediaPlayerCreate3;
                if (mediaPlayerCreate3 != null) {
                    mediaPlayerCreate3.start();
                }
                doubtChatAdapter.starttimer(dialog, (Button) objectRef2.element, (Button) objectRef.element, i);
            }
        }
        MediaPlayer mediaPlayer3 = doubtChatAdapter.mediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer3);
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.appnew.android.Zoom.Adapter.DoubtChatAdapter$$ExternalSyntheticLambda2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer4) {
                DoubtChatAdapter.setClickAudio$lambda$6$lambda$5(objectRef, objectRef2, mediaPlayer4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setClickAudio$lambda$6$lambda$5(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, MediaPlayer mediaPlayer) {
        ((Button) objectRef.element).setVisibility(0);
        ((Button) objectRef2.element).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setClickAudio$lambda$7(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, DoubtChatAdapter doubtChatAdapter, View view) {
        ((Button) objectRef.element).setVisibility(0);
        ((Button) objectRef2.element).setVisibility(8);
        MediaPlayer mediaPlayer = doubtChatAdapter.mediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer);
        if (mediaPlayer.isPlaying()) {
            MediaPlayer mediaPlayer2 = doubtChatAdapter.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.pause();
            }
            doubtChatAdapter.stoptimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClickAudio$lambda$8(DoubtChatAdapter doubtChatAdapter, Dialog dialog, View view) {
        MediaPlayer mediaPlayer = doubtChatAdapter.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        dialog.dismiss();
    }

    public final void updateList(ReplyModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList<ReplyModel> arrayList = this.data;
        if (arrayList != null) {
            arrayList.add(data);
        }
        notifyDataSetChanged();
    }

    public final void clearList() {
        ArrayList<ReplyModel> arrayList = this.data;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<ReplyModel> arrayList = this.data;
        Intrinsics.checkNotNull(arrayList);
        return arrayList.size();
    }

    /* JADX INFO: compiled from: DoubtChatAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#¨\u0006-"}, d2 = {"Lcom/appnew/android/Zoom/Adapter/DoubtChatAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "replayMessage", "Lcom/ahmadnemati/clickablewebview/ClickableWebView;", "getReplayMessage", "()Lcom/ahmadnemati/clickablewebview/ClickableWebView;", "setReplayMessage", "(Lcom/ahmadnemati/clickablewebview/ClickableWebView;)V", "userMessage", "Landroid/widget/TextView;", "getUserMessage", "()Landroid/widget/TextView;", "setUserMessage", "(Landroid/widget/TextView;)V", "masterMessageCard", "Landroid/widget/LinearLayout;", "getMasterMessageCard", "()Landroid/widget/LinearLayout;", "setMasterMessageCard", "(Landroid/widget/LinearLayout;)V", "userMessageCard", "getUserMessageCard", "setUserMessageCard", "tv_time", "getTv_time", "setTv_time", "cvrLeftimage", "Landroid/widget/RelativeLayout;", "getCvrLeftimage", "()Landroid/widget/RelativeLayout;", "setCvrLeftimage", "(Landroid/widget/RelativeLayout;)V", "letfmessageTvimage", "Landroid/widget/ImageView;", "getLetfmessageTvimage", "()Landroid/widget/ImageView;", "setLetfmessageTvimage", "(Landroid/widget/ImageView;)V", "cvrLeftAudio", "getCvrLeftAudio", "setCvrLeftAudio", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private RelativeLayout cvrLeftAudio;
        private RelativeLayout cvrLeftimage;
        private ImageView letfmessageTvimage;
        private LinearLayout masterMessageCard;
        private ClickableWebView replayMessage;
        private TextView tv_time;
        private TextView userMessage;
        private LinearLayout userMessageCard;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.replayMessage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.replayMessage = (ClickableWebView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.userMessage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.userMessage = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.masterMessageCard);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.masterMessageCard = (LinearLayout) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.userMessageCard);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.userMessageCard = (LinearLayout) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.tv_time);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.tv_time = (TextView) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.cvrLeftimage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.cvrLeftimage = (RelativeLayout) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.letfmessageTvimage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.letfmessageTvimage = (ImageView) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.cvrLeftAudio);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.cvrLeftAudio = (RelativeLayout) viewFindViewById8;
        }

        public final ClickableWebView getReplayMessage() {
            return this.replayMessage;
        }

        public final void setReplayMessage(ClickableWebView clickableWebView) {
            Intrinsics.checkNotNullParameter(clickableWebView, "<set-?>");
            this.replayMessage = clickableWebView;
        }

        public final TextView getUserMessage() {
            return this.userMessage;
        }

        public final void setUserMessage(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.userMessage = textView;
        }

        public final LinearLayout getMasterMessageCard() {
            return this.masterMessageCard;
        }

        public final void setMasterMessageCard(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.masterMessageCard = linearLayout;
        }

        public final LinearLayout getUserMessageCard() {
            return this.userMessageCard;
        }

        public final void setUserMessageCard(LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.userMessageCard = linearLayout;
        }

        public final TextView getTv_time() {
            return this.tv_time;
        }

        public final void setTv_time(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tv_time = textView;
        }

        public final RelativeLayout getCvrLeftimage() {
            return this.cvrLeftimage;
        }

        public final void setCvrLeftimage(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.cvrLeftimage = relativeLayout;
        }

        public final ImageView getLetfmessageTvimage() {
            return this.letfmessageTvimage;
        }

        public final void setLetfmessageTvimage(ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.letfmessageTvimage = imageView;
        }

        public final RelativeLayout getCvrLeftAudio() {
            return this.cvrLeftAudio;
        }

        public final void setCvrLeftAudio(RelativeLayout relativeLayout) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.cvrLeftAudio = relativeLayout;
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Zoom.Adapter.DoubtChatAdapter$starttimer$1, reason: invalid class name */
    /* JADX INFO: compiled from: DoubtChatAdapter.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/appnew/android/Zoom/Adapter/DoubtChatAdapter$starttimer$1", "Ljava/util/TimerTask;", "run", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 extends TimerTask {
        AnonymousClass1() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Context context = DoubtChatAdapter.this.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            final DoubtChatAdapter doubtChatAdapter = DoubtChatAdapter.this;
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.appnew.android.Zoom.Adapter.DoubtChatAdapter$starttimer$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DoubtChatAdapter.AnonymousClass1.run$lambda$0(doubtChatAdapter);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(DoubtChatAdapter doubtChatAdapter) {
            if (doubtChatAdapter.timer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
            }
            MediaPlayer mediaPlayer = doubtChatAdapter.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                return;
            }
            doubtChatAdapter.stoptimer();
        }
    }

    public final void starttimer(Dialog holder, Button pauser, Button play, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(new AnonymousClass1(), 0L, 1000L);
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
