package com.appnew.android.sme.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Zoom.Activity.DoubtChatActivityFirebase;
import com.appnew.android.sme.Adapter.SmeDoubtAdapter;
import com.appnew.android.sme.Doubt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
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

/* JADX INFO: compiled from: SmeDoubtAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0015H\u0016J\u0016\u0010%\u001a\u00020&2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u001a\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00022\b\b\u0001\u0010*\u001a\u00020\u0015H\u0017J\b\u0010+\u001a\u00020\u0015H\u0016J\u0018\u0010,\u001a\u00020&2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0015H\u0002J\u0010\u0010-\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020\tJ*\u0010/\u001a\u00020&2\u0006\u0010)\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001022\u0006\u0010*\u001a\u00020\u0015J\u0006\u00104\u001a\u00020&R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00066"}, d2 = {"Lcom/appnew/android/sme/Adapter/SmeDoubtAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/sme/Adapter/SmeDoubtAdapter$ViewHolder;", "data", "", "Lcom/appnew/android/sme/Doubt;", "context", "Landroid/content/Context;", "doubtType", "", "<init>", "(Ljava/util/List;Landroid/content/Context;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDoubtType", "()Ljava/lang/String;", "setDoubtType", "(Ljava/lang/String;)V", Constants.INAPP_POSITION, "", "Ljava/lang/Integer;", "mediaPlayer", "Landroid/media/MediaPlayer;", "lastselected", "timer", "Ljava/util/Timer;", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "getI", "()I", "setI", "(I)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "setData", "", "data1", "onBindViewHolder", "holder", Const.POSITION, "getItemCount", "handleOnCheck", "getdate", "timestamp", "starttimer", "Landroid/app/Dialog;", "pauser", "Landroid/widget/Button;", "play", "stoptimer", "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SmeDoubtAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private Context context;
    private List<Doubt> data;
    private String doubtType;
    private int i;
    private int lastselected;
    private MediaPlayer mediaPlayer;
    private Integer pos;
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

    public SmeDoubtAdapter(List<Doubt> data, Context context, String doubtType) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(doubtType, "doubtType");
        this.data = data;
        this.context = context;
        this.doubtType = doubtType;
        this.pos = 0;
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
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_doubt_layout_new, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }

    public final void setData(List<Doubt> data1) {
        if (data1 != null) {
            this.data = data1;
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getTitle().setText(this.data.get(position).getDoubtMessage());
        holder.getUser_name().setText(this.data.get(position).getDoubtMessage());
        if (this.data.get(position).getDoubtAudio().equals("") || this.data.get(position).getDoubtAudio().length() == 0) {
            holder.getUser_doubtAudio().setVisibility(8);
            holder.getLinearLayoutAudio().setVisibility(8);
        } else if (StringsKt.contains$default((CharSequence) this.data.get(position).getDoubtAudio(), (CharSequence) ".mp3", false, 2, (Object) null)) {
            holder.getUser_doubtAudio().setVisibility(0);
            holder.getLinearLayoutAudio().setVisibility(0);
        }
        handleOnCheck(holder, position);
        holder.getLinearLayoutAudio().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.SmeDoubtAdapter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmeDoubtAdapter.onBindViewHolder$lambda$0(this.f$0, view);
            }
        });
        if (this.data.get(position).getDoubtImage().equals("") || this.data.get(position).getDoubtImage().length() == 0) {
            holder.getLinearLayoutImage().setVisibility(8);
        } else if (StringsKt.contains$default((CharSequence) this.data.get(position).getDoubtImage(), (CharSequence) ".jpg", false, 2, (Object) null)) {
            holder.getLinearLayoutImage().setVisibility(0);
        }
        if (this.data.get(position).getDoubtImage().equals("") || this.data.get(position).getDoubtImage().length() == 0) {
            holder.getLinearLayoutPdf().setVisibility(8);
        } else if (StringsKt.contains$default((CharSequence) this.data.get(position).getDoubtImage(), (CharSequence) ".pdf", false, 2, (Object) null)) {
            holder.getLinearLayoutPdf().setVisibility(0);
        }
        holder.getReplayChat().setVisibility(0);
        holder.getReplayChat().setText("Solve Query >>");
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.SmeDoubtAdapter$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmeDoubtAdapter.onBindViewHolder$lambda$1(this.f$0, position, view);
            }
        });
        if (this.data.get(position).getUserId() != null) {
            if (this.data.get(position).getStatus().equals("1")) {
                holder.getUser_name().setVisibility(8);
                holder.getSubject_status().setVisibility(0);
                holder.getSubject_status().setText(this.context.getResources().getString(R.string.review));
                holder.getSubject_status().setTextColor(Color.parseColor("#00a651"));
                if (this.data.get(position).isComplete().equals("1")) {
                    holder.getSubject_status().setText(this.context.getResources().getString(R.string.resolved));
                }
            } else {
                holder.getUser_name().setVisibility(8);
                holder.getSubject_status().setVisibility(0);
                holder.getSubject_status().setText(this.context.getResources().getString(R.string.pending));
                holder.getSubject_status().setTextColor(Color.parseColor("#CC0000"));
            }
        }
        holder.getUser_comment().setText(this.data.get(position).getDoubtMessage());
        holder.getDate_time().setText(getdate(this.data.get(position).getCreatedAt()));
        holder.getLinearLayoutAudio().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.SmeDoubtAdapter$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmeDoubtAdapter.onBindViewHolder$lambda$6(this.f$0, position, view);
            }
        });
        holder.getLinearLayoutImage().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.SmeDoubtAdapter$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmeDoubtAdapter.onBindViewHolder$lambda$8(this.f$0, position, view);
            }
        });
        holder.getLinearLayoutPdf().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.SmeDoubtAdapter$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmeDoubtAdapter.onBindViewHolder$lambda$9(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(SmeDoubtAdapter smeDoubtAdapter, View view) {
        Helper.showToast(smeDoubtAdapter.context, "This functionality will be available soon", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(SmeDoubtAdapter smeDoubtAdapter, int i, View view) {
        if (Helper.isNetworkConnected(smeDoubtAdapter.context)) {
            if (!TextUtils.isEmpty(smeDoubtAdapter.data.get(i).getChatNode())) {
                Intent intent = new Intent(smeDoubtAdapter.context, (Class<?>) DoubtChatActivityFirebase.class);
                intent.putExtra("Chat_node", smeDoubtAdapter.data.get(i).getChatNode());
                intent.putExtra("doubtType", "SME");
                intent.putExtra("doubtId", smeDoubtAdapter.data.get(i).getId());
                smeDoubtAdapter.context.startActivity(intent);
                return;
            }
            Toast.makeText(smeDoubtAdapter.context, "No chat node found.", 0).show();
            return;
        }
        Helper.showInternetToast(smeDoubtAdapter.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v12, types: [T, android.widget.Button] */
    /* JADX WARN: Type inference failed for: r9v9, types: [T, android.widget.Button] */
    public static final void onBindViewHolder$lambda$6(final SmeDoubtAdapter smeDoubtAdapter, final int i, View view) {
        if (!Helper.isNetworkConnected(smeDoubtAdapter.context)) {
            Helper.showInternetToast(smeDoubtAdapter.context);
            return;
        }
        final Dialog dialog = new Dialog(smeDoubtAdapter.context);
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
        ((TextView) viewFindViewById4).setText(smeDoubtAdapter.data.get(i).getSubjectName());
        ((Button) objectRef.element).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.SmeDoubtAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SmeDoubtAdapter.onBindViewHolder$lambda$6$lambda$3(this.f$0, objectRef, objectRef2, i, dialog, view2);
            }
        });
        ((Button) objectRef2.element).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.SmeDoubtAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SmeDoubtAdapter.onBindViewHolder$lambda$6$lambda$4(objectRef, objectRef2, smeDoubtAdapter, view2);
            }
        });
        ((ImageView) viewFindViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.SmeDoubtAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SmeDoubtAdapter.onBindViewHolder$lambda$6$lambda$5(this.f$0, dialog, view2);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onBindViewHolder$lambda$6$lambda$3(SmeDoubtAdapter smeDoubtAdapter, final Ref.ObjectRef objectRef, final Ref.ObjectRef objectRef2, int i, Dialog dialog, View view) {
        if (!Helper.isNetworkConnected(smeDoubtAdapter.context)) {
            Helper.showInternetToast(smeDoubtAdapter.context);
            return;
        }
        ((Button) objectRef.element).setVisibility(8);
        ((Button) objectRef2.element).setVisibility(0);
        MediaPlayer mediaPlayer = smeDoubtAdapter.mediaPlayer;
        if (mediaPlayer == null) {
            smeDoubtAdapter.lastselected = i;
            MediaPlayer mediaPlayerCreate = MediaPlayer.create(smeDoubtAdapter.context, Uri.parse(smeDoubtAdapter.data.get(i).getDoubtAudio()));
            smeDoubtAdapter.mediaPlayer = mediaPlayerCreate;
            if (mediaPlayerCreate != null) {
                mediaPlayerCreate.start();
            }
            smeDoubtAdapter.starttimer(dialog, (Button) objectRef2.element, (Button) objectRef.element, i);
        } else {
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                MediaPlayer mediaPlayer2 = smeDoubtAdapter.mediaPlayer;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.pause();
                }
                smeDoubtAdapter.stoptimer();
                MediaPlayer mediaPlayerCreate2 = MediaPlayer.create(smeDoubtAdapter.context, Uri.parse(smeDoubtAdapter.data.get(i).getDoubtAudio()));
                smeDoubtAdapter.mediaPlayer = mediaPlayerCreate2;
                if (mediaPlayerCreate2 != null) {
                    mediaPlayerCreate2.start();
                }
                smeDoubtAdapter.starttimer(dialog, (Button) objectRef2.element, (Button) objectRef.element, i);
            } else {
                smeDoubtAdapter.lastselected = i;
                smeDoubtAdapter.notifyItemChanged(i);
                MediaPlayer mediaPlayerCreate3 = MediaPlayer.create(smeDoubtAdapter.context, Uri.parse(smeDoubtAdapter.data.get(i).getDoubtAudio()));
                smeDoubtAdapter.mediaPlayer = mediaPlayerCreate3;
                if (mediaPlayerCreate3 != null) {
                    mediaPlayerCreate3.start();
                }
                smeDoubtAdapter.starttimer(dialog, (Button) objectRef2.element, (Button) objectRef.element, i);
            }
        }
        MediaPlayer mediaPlayer3 = smeDoubtAdapter.mediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer3);
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.appnew.android.sme.Adapter.SmeDoubtAdapter$$ExternalSyntheticLambda3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer4) {
                SmeDoubtAdapter.onBindViewHolder$lambda$6$lambda$3$lambda$2(objectRef, objectRef2, mediaPlayer4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onBindViewHolder$lambda$6$lambda$3$lambda$2(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, MediaPlayer mediaPlayer) {
        ((Button) objectRef.element).setVisibility(0);
        ((Button) objectRef2.element).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onBindViewHolder$lambda$6$lambda$4(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, SmeDoubtAdapter smeDoubtAdapter, View view) {
        ((Button) objectRef.element).setVisibility(0);
        ((Button) objectRef2.element).setVisibility(8);
        MediaPlayer mediaPlayer = smeDoubtAdapter.mediaPlayer;
        Intrinsics.checkNotNull(mediaPlayer);
        if (mediaPlayer.isPlaying()) {
            MediaPlayer mediaPlayer2 = smeDoubtAdapter.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.pause();
            }
            smeDoubtAdapter.stoptimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$6$lambda$5(SmeDoubtAdapter smeDoubtAdapter, Dialog dialog, View view) {
        MediaPlayer mediaPlayer = smeDoubtAdapter.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$8(SmeDoubtAdapter smeDoubtAdapter, int i, View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(smeDoubtAdapter.context);
        Context context = smeDoubtAdapter.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        View viewInflate = layoutInflater.inflate(R.layout.image_layout, (ViewGroup) null);
        builder.setView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.cancel);
        String str = "";
        for (String str2 : StringsKt.split$default((CharSequence) smeDoubtAdapter.data.get(i).getDoubtImage(), new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null)) {
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) ".jpg", false, 2, (Object) null)) {
                str = str2;
            }
        }
        if (!Intrinsics.areEqual(smeDoubtAdapter.data.get(i).getUserId(), "")) {
            Intrinsics.checkNotNull(Glide.with(smeDoubtAdapter.context.getApplicationContext()).load(str).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.color.colorPrimary).error(R.color.colorPrimary).diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate()).into(imageView));
        } else {
            imageView.setImageResource(com.appnew.android.R.drawable.profile_grey);
        }
        final AlertDialog alertDialogShow = builder.show();
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.sme.Adapter.SmeDoubtAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                alertDialogShow.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$9(SmeDoubtAdapter smeDoubtAdapter, int i, View view) {
        if (Helper.isNetworkConnected(smeDoubtAdapter.context)) {
            String str = "";
            for (String str2 : StringsKt.split$default((CharSequence) smeDoubtAdapter.data.get(i).getDoubtImage(), new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null)) {
                if (StringsKt.contains$default((CharSequence) str2, (CharSequence) ".pdf", false, 2, (Object) null)) {
                    str = str2;
                }
            }
            Intent intent = new Intent(smeDoubtAdapter.context, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("url", str);
            intent.putExtra("from", "ChatAdapter");
            smeDoubtAdapter.context.startActivity(intent);
            return;
        }
        Helper.showInternetToast(smeDoubtAdapter.context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    /* JADX INFO: compiled from: SmeDoubtAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b$\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u001a\u0010*\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR\u001a\u0010-\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR\u001a\u00100\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0005R\u001a\u00104\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0014R\u001a\u00107\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\t\"\u0004\b9\u0010\u000bR\u001a\u0010:\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\t\"\u0004\b<\u0010\u000bR\u001a\u0010=\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\t\"\u0004\b?\u0010\u000b¨\u0006@"}, d2 = {"Lcom/appnew/android/sme/Adapter/SmeDoubtAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "Subject_status", "getSubject_status", "setSubject_status", "linearLayoutAudio", "Landroid/widget/LinearLayout;", "getLinearLayoutAudio", "()Landroid/widget/LinearLayout;", "setLinearLayoutAudio", "(Landroid/widget/LinearLayout;)V", "linearLayoutImage", "getLinearLayoutImage", "setLinearLayoutImage", "linearLayoutPdf", "getLinearLayoutPdf", "setLinearLayoutPdf", "user_doubtAudio", "Landroid/widget/ImageView;", "getUser_doubtAudio", "()Landroid/widget/ImageView;", "setUser_doubtAudio", "(Landroid/widget/ImageView;)V", AnalyticsConstants.user_name, "getUser_name", "setUser_name", "user_comment", "getUser_comment", "setUser_comment", "date_time", "getDate_time", "setDate_time", "replayChat", "getReplayChat", "setReplayChat", "replayMsg", "getReplayMsg", "setReplayMsg", "isbnLineId", "getIsbnLineId", "()Landroid/view/View;", "setIsbnLineId", "isbnLayout", "getIsbnLayout", "setIsbnLayout", "bookNameText", "getBookNameText", "setBookNameText", "pageNoText", "getPageNoText", "setPageNoText", "questionNoText", "getQuestionNoText", "setQuestionNoText", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private TextView Subject_status;
        private TextView bookNameText;
        private TextView date_time;
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
    }

    private final void handleOnCheck(ViewHolder holder, int position) {
        holder.getIsbnLayout().setVisibility(0);
        holder.getIsbnLineId().setVisibility(0);
        holder.getBookNameText().setText(this.data.get(position).getSubjectName());
        holder.getPageNoText().setText(this.data.get(position).getPageNo());
        holder.getQuestionNoText().setText(this.data.get(position).getQuestionNo());
    }

    public final String getdate(String timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp) * ((long) 1000))));
    }

    /* JADX INFO: renamed from: com.appnew.android.sme.Adapter.SmeDoubtAdapter$starttimer$1, reason: invalid class name */
    /* JADX INFO: compiled from: SmeDoubtAdapter.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/appnew/android/sme/Adapter/SmeDoubtAdapter$starttimer$1", "Ljava/util/TimerTask;", "run", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 extends TimerTask {
        AnonymousClass1() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Context context = SmeDoubtAdapter.this.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            final SmeDoubtAdapter smeDoubtAdapter = SmeDoubtAdapter.this;
            ((Activity) context).runOnUiThread(new Runnable() { // from class: com.appnew.android.sme.Adapter.SmeDoubtAdapter$starttimer$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    SmeDoubtAdapter.AnonymousClass1.run$lambda$0(smeDoubtAdapter);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void run$lambda$0(SmeDoubtAdapter smeDoubtAdapter) {
            if (smeDoubtAdapter.timer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("timer");
            }
            MediaPlayer mediaPlayer = smeDoubtAdapter.mediaPlayer;
            Intrinsics.checkNotNull(mediaPlayer);
            if (mediaPlayer.isPlaying()) {
                return;
            }
            smeDoubtAdapter.stoptimer();
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
