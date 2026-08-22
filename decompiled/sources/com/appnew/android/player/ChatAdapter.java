package com.appnew.android.player;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Model.LeftMenu;
import com.appnew.android.Model.PostFile;
import com.appnew.android.Model.chatPojo;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.player.music_player.Utils;
import com.appnew.android.socket.extension.SocketKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Serializable {
    private static final String TAG = "LiveAdapter";
    public ArrayList<chatPojo> dataSet;
    public int i;
    private Boolean in_app_download;
    private int lastselected;
    private LeftMenu leftMenu;
    Context mContext;
    MediaPlayer mediaPlayer;
    private MyViewHolder tempHolder;
    private int templistPosition;
    private Timer timer;
    String type;
    UtkashRoom utkashRoom;

    public ChatAdapter(Context context, String type, ArrayList<chatPojo> dataSet) {
        this.mContext = context;
        this.dataSet = dataSet;
        this.type = type;
        getThemeData(context);
    }

    public ChatAdapter(Context context, String type, ArrayList<chatPojo> dataSet, LeftMenu leftMenu) {
        this.mContext = context;
        this.dataSet = dataSet;
        this.type = type;
        this.leftMenu = leftMenu;
    }

    void getThemeData(Context context) {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(context);
        this.utkashRoom = appDatabase;
        if (appDatabase.getthemeSettingdao().is_setting_exit()) {
            this.leftMenu = (LeftMenu) new Gson().fromJson(this.utkashRoom.getthemeSettingdao().data().getLeft_menu(), LeftMenu.class);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, int listPosition) {
        try {
            if (getItemViewType(listPosition) == 1) {
                setTransparentData((MyViewHolder2) holder1, listPosition);
            } else {
                setData((MyViewHolder) holder1, listPosition);
            }
        } catch (Exception e2) {
            Log.d("TAGChatAdapter", "onBindViewHolder: " + e2.getMessage());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        if (viewType == 1) {
            return new MyViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_trans_chat_layout, parent, false));
        }
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_chat_layout, parent, false));
    }

    public void upDateData(ArrayList<chatPojo> pinchatList) {
        pauseAudio();
        this.dataSet = pinchatList;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mediaPlayer.pause();
        }
        notifyDataSetChanged();
    }

    public void stopMusic() {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mediaPlayer.pause();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView audioImage_user;
        CircleImageView audioImage_userLeft;
        TextView audioText_username;
        TextView audioText_usernameLeft;
        TextView audio_timeLeftAudio;
        Button audiopause;
        Button audiopauseLeft;
        Button audioplay;
        Button audioplayLeft;
        RelativeLayout cvrDownLoadRight;
        RelativeLayout cvrLeft;
        RelativeLayout cvrLeftAudio;
        RelativeLayout cvrLeftimage;
        RelativeLayout cvrLeftpdf;
        RelativeLayout cvrRight;
        RelativeLayout cvrRightAudio;
        RelativeLayout cvrRightimage;
        RelativeLayout cvrRightpdf;
        RelativeLayout cvrUrlLeft;
        RelativeLayout cvrUrlRight;
        ConstraintLayout imageLeftParentCL;
        ConstraintLayout imageRightParentCL;
        ImageView imageThumbnailPdfLeft;
        ImageView imageThumbnailPdfRight;
        ImageView ivPinAudio;
        ImageView ivPinImage;
        ImageView ivPinMsg;
        ImageView ivPinPdf;
        ImageView ivPinUrl;
        LinearLayout iv_img_click_left;
        LinearLayout iv_img_click_right;
        TextView leftimagetime;
        TextView lefttexttime;
        TextView lefttexttimeUrl;
        TextView letfmessageTv;
        ImageView letfmessageTvimage;
        TextView pdfFile_name;
        TextView pdfFile_nameLeft;
        CircleImageView pdfImage_user;
        CircleImageView pdfImage_userLeft;
        TextView pdfText_username;
        TextView pdfText_usernameLeft;
        LinearLayout pdfViewLeft;
        LinearLayout pdfViewRight;
        LinearLayout pdf_right_click;
        TextView pdf_timeLeft;
        TextView pdf_timeLeftPdf;
        RelativeLayout pdfdownloadLeft;
        CircleImageView profileImage;
        CircleImageView profileImage2;
        CircleImageView profileImage2Url;
        CircleImageView profileImage2image;
        CircleImageView profileImageUrlLeft;
        CircleImageView profileImageimage;
        ImageView reply_file_img;
        LinearLayout reply_file_ll;
        TextView reply_file_name;
        LinearLayout rightSideAudioLL;
        LinearLayout rightSidePdfLL;
        LinearLayout rightSideTextLL;
        LinearLayout rightSideUrlLL;
        TextView rightimagettime;
        TextView rightmessage;
        ImageView rightmessageimage;
        TextView righttexttime;
        TextView righttexttimeAudio;
        TextView righttexttimePdf;
        TextView righttexttimeUrl;
        RelativeLayout rl_audio_right;
        RelativeLayout rl_text_click;
        RelativeLayout rl_url_click;
        LinearLayout studentCot_linear;
        TextView studentMessageTv;
        TextView studentName;
        TextView urlLeftTv;
        TextView urlRightTv;
        TextView userName;
        TextView userNameUrlLeft;
        TextView userNameimage;
        TextView userNameright;
        TextView userNamerightUrl;
        TextView userNamerightimage;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.rl_url_click = (RelativeLayout) itemView.findViewById(R.id.rl_url_click);
            this.rl_text_click = (RelativeLayout) itemView.findViewById(R.id.rl_text_click);
            this.pdf_right_click = (LinearLayout) itemView.findViewById(R.id.pdf_right_click);
            this.rl_audio_right = (RelativeLayout) itemView.findViewById(R.id.rl_audio_right);
            this.cvrLeft = (RelativeLayout) itemView.findViewById(R.id.cvrLeft);
            this.cvrRightpdf = (RelativeLayout) itemView.findViewById(R.id.cvrRightpdf);
            this.ivPinMsg = (ImageView) itemView.findViewById(R.id.ivPinMsg);
            this.cvrLeftimage = (RelativeLayout) itemView.findViewById(R.id.cvrLeftimage);
            this.cvrRight = (RelativeLayout) itemView.findViewById(R.id.cvrRight);
            this.cvrRightimage = (RelativeLayout) itemView.findViewById(R.id.cvrRightimage);
            this.iv_img_click_right = (LinearLayout) itemView.findViewById(R.id.iv_img_click_right);
            this.iv_img_click_left = (LinearLayout) itemView.findViewById(R.id.iv_img_left_click);
            this.cvrUrlLeft = (RelativeLayout) itemView.findViewById(R.id.cvrUrlLeft);
            this.cvrUrlRight = (RelativeLayout) itemView.findViewById(R.id.cvrUrlRight);
            this.urlLeftTv = (TextView) itemView.findViewById(R.id.letfmessageTvUrl);
            this.urlRightTv = (TextView) itemView.findViewById(R.id.rightmessageUrl);
            this.studentCot_linear = (LinearLayout) itemView.findViewById(R.id.studentCot_linear);
            this.studentName = (TextView) itemView.findViewById(R.id.studentName);
            this.studentMessageTv = (TextView) itemView.findViewById(R.id.studentMessageTv);
            this.reply_file_name = (TextView) itemView.findViewById(R.id.reply_file_name);
            this.reply_file_img = (ImageView) itemView.findViewById(R.id.reply_file_img);
            this.reply_file_ll = (LinearLayout) itemView.findViewById(R.id.reply_file_ll);
            this.audioText_usernameLeft = (TextView) itemView.findViewById(R.id.audioText_usernameLeft);
            this.audio_timeLeftAudio = (TextView) itemView.findViewById(R.id.audio_timeLeftAudio);
            this.audioText_username = (TextView) itemView.findViewById(R.id.audioText_username);
            this.righttexttimeAudio = (TextView) itemView.findViewById(R.id.righttexttimeAudio);
            this.cvrLeftAudio = (RelativeLayout) itemView.findViewById(R.id.cvrLeftAudio);
            this.cvrRightAudio = (RelativeLayout) itemView.findViewById(R.id.cvrRightAudio);
            this.audioplay = (Button) itemView.findViewById(R.id.audioplay);
            this.audiopause = (Button) itemView.findViewById(R.id.audiopause);
            this.audioplayLeft = (Button) itemView.findViewById(R.id.audioplayLeft);
            this.audiopauseLeft = (Button) itemView.findViewById(R.id.audiopauseLeft);
            this.profileImage = (CircleImageView) itemView.findViewById(R.id.profileImage);
            this.profileImageimage = (CircleImageView) itemView.findViewById(R.id.profileImageimage);
            this.userName = (TextView) itemView.findViewById(R.id.userName);
            this.userNameimage = (TextView) itemView.findViewById(R.id.userNameimage);
            this.letfmessageTv = (TextView) itemView.findViewById(R.id.letfmessageTv);
            this.letfmessageTvimage = (ImageView) itemView.findViewById(R.id.letfmessageTvimage);
            this.lefttexttime = (TextView) itemView.findViewById(R.id.lefttexttime);
            this.leftimagetime = (TextView) itemView.findViewById(R.id.leftimagetime);
            this.cvrLeftpdf = (RelativeLayout) itemView.findViewById(R.id.cvrLeftpdf);
            this.pdfdownloadLeft = (RelativeLayout) itemView.findViewById(R.id.cvrDownLoadLeft);
            this.pdfViewRight = (LinearLayout) itemView.findViewById(R.id.pdfViewRight);
            this.pdfViewLeft = (LinearLayout) itemView.findViewById(R.id.pdfViewLeft);
            this.pdfText_username = (TextView) itemView.findViewById(R.id.pdfText_username);
            this.pdfText_usernameLeft = (TextView) itemView.findViewById(R.id.pdfText_usernameLeft);
            this.pdfImage_user = (CircleImageView) itemView.findViewById(R.id.pdfImage_user);
            this.righttexttimePdf = (TextView) itemView.findViewById(R.id.righttexttimePdf);
            this.pdf_timeLeftPdf = (TextView) itemView.findViewById(R.id.pdf_timeLeftPdf);
            this.pdfImage_userLeft = (CircleImageView) itemView.findViewById(R.id.pdfImage_userLeft);
            this.profileImage2 = (CircleImageView) itemView.findViewById(R.id.profileImage2);
            this.profileImage2image = (CircleImageView) itemView.findViewById(R.id.profileImage2image);
            this.userNameright = (TextView) itemView.findViewById(R.id.userNameright);
            this.userNamerightimage = (TextView) itemView.findViewById(R.id.userNamerightimage);
            this.rightmessage = (TextView) itemView.findViewById(R.id.rightmessage);
            this.rightmessageimage = (ImageView) itemView.findViewById(R.id.rightmessageimage);
            this.cvrDownLoadRight = (RelativeLayout) itemView.findViewById(R.id.cvrDownLoadRight);
            this.righttexttime = (TextView) itemView.findViewById(R.id.righttexttime);
            this.rightimagettime = (TextView) itemView.findViewById(R.id.rightimagettime);
            this.ivPinImage = (ImageView) itemView.findViewById(R.id.ivPinImage);
            this.ivPinPdf = (ImageView) itemView.findViewById(R.id.ivPinPdf);
            this.ivPinAudio = (ImageView) itemView.findViewById(R.id.ivPinAudio);
            this.ivPinUrl = (ImageView) itemView.findViewById(R.id.ivPinUrl);
            this.righttexttimeUrl = (TextView) itemView.findViewById(R.id.righttexttimeUrl);
            this.lefttexttimeUrl = (TextView) itemView.findViewById(R.id.lefttexttimeUrl);
            this.userNamerightUrl = (TextView) itemView.findViewById(R.id.userNamerightUrl);
            this.userNameUrlLeft = (TextView) itemView.findViewById(R.id.userNameUrlLeft);
            this.profileImageUrlLeft = (CircleImageView) itemView.findViewById(R.id.profileImageUrlLeft);
            this.profileImage2Url = (CircleImageView) itemView.findViewById(R.id.profileImage2Url);
            this.audioImage_user = (CircleImageView) itemView.findViewById(R.id.audioImage_user);
            this.audioImage_userLeft = (CircleImageView) itemView.findViewById(R.id.audioImage_userLeft);
            this.rightSideTextLL = (LinearLayout) itemView.findViewById(R.id.rightSideTextLL);
            this.rightSidePdfLL = (LinearLayout) itemView.findViewById(R.id.rightSidePdfLL);
            this.rightSideAudioLL = (LinearLayout) itemView.findViewById(R.id.rightSideAudioLL);
            this.rightSideUrlLL = (LinearLayout) itemView.findViewById(R.id.rightSideUrlLL);
            this.pdfFile_name = (TextView) itemView.findViewById(R.id.pdfFile_name);
            this.pdfFile_nameLeft = (TextView) itemView.findViewById(R.id.pdfFile_nameLeft);
            this.imageThumbnailPdfRight = (ImageView) itemView.findViewById(R.id.imageThumbnail);
            this.imageThumbnailPdfLeft = (ImageView) itemView.findViewById(R.id.imageThumbnailLeft);
            this.imageRightParentCL = (ConstraintLayout) itemView.findViewById(R.id.imageRightParentCL);
            this.imageLeftParentCL = (ConstraintLayout) itemView.findViewById(R.id.imageLeftParentCL);
        }
    }

    public void setData(final MyViewHolder holder, final int listPosition) {
        Context context = this.mContext;
        if (context instanceof Liveawsactivity) {
            ((Liveawsactivity) context).ischatload = true;
        } else if (context instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) context).ischatload = true;
        } else if (context instanceof VODPlayerActivity) {
            ((VODPlayerActivity) context).ischatload = true;
        }
        holder.cvrLeft.setVisibility(8);
        holder.cvrLeftimage.setVisibility(8);
        holder.cvrRight.setVisibility(8);
        holder.cvrRightimage.setVisibility(8);
        holder.cvrRightpdf.setVisibility(8);
        holder.cvrLeftpdf.setVisibility(8);
        holder.cvrRightAudio.setVisibility(8);
        holder.cvrLeftAudio.setVisibility(8);
        holder.cvrUrlLeft.setVisibility(8);
        holder.cvrUrlRight.setVisibility(8);
        Utils.INSTANCE.setDynamicTint(holder.rightSideTextLL, 0.1f);
        Utils.INSTANCE.setDynamicTint(holder.iv_img_click_right, 0.1f);
        Utils.INSTANCE.setDynamicTint(holder.rightSidePdfLL, 0.1f);
        Utils.INSTANCE.setDynamicTint(holder.rightSideAudioLL, 0.1f);
        Utils.INSTANCE.setDynamicTint(holder.rightSideUrlLL, 0.1f);
        if (this.dataSet.get(listPosition).getOriginal() != null) {
            if ((this.dataSet.get(listPosition).getOriginal().getMessage() != null && !this.dataSet.get(listPosition).getOriginal().getMessage().equalsIgnoreCase("")) || (this.dataSet.get(listPosition).getOriginal().getName() != null && !this.dataSet.get(listPosition).getOriginal().getName().equalsIgnoreCase(""))) {
                holder.studentCot_linear.setVisibility(0);
                if (this.dataSet.get(listPosition).getOriginal().getOriginal_type().equalsIgnoreCase(Const.PDF)) {
                    holder.studentMessageTv.setVisibility(8);
                    holder.reply_file_ll.setVisibility(0);
                    holder.reply_file_img.setImageResource(R.mipmap.pdf_icon);
                    holder.reply_file_name.setText("PDF");
                } else if (this.dataSet.get(listPosition).getOriginal().getOriginal_type().equalsIgnoreCase("image")) {
                    holder.studentMessageTv.setVisibility(8);
                    holder.reply_file_ll.setVisibility(0);
                    holder.reply_file_img.setImageResource(com.appnew.android.R.drawable.ic_image);
                    holder.reply_file_name.setText("Image");
                } else if (this.dataSet.get(listPosition).getOriginal().getOriginal_type().equalsIgnoreCase("audio")) {
                    holder.studentMessageTv.setVisibility(8);
                    holder.reply_file_ll.setVisibility(0);
                    holder.reply_file_img.setImageResource(R.drawable.headphones);
                    holder.reply_file_name.setText("Audio");
                } else {
                    holder.studentMessageTv.setText(this.dataSet.get(listPosition).getOriginal().getMessage());
                    holder.studentMessageTv.setVisibility(0);
                    holder.reply_file_ll.setVisibility(8);
                }
                holder.studentName.setText(this.dataSet.get(listPosition).getOriginal().getName());
            } else {
                holder.studentCot_linear.setVisibility(8);
            }
        } else {
            holder.studentCot_linear.setVisibility(8);
        }
        holder.iv_img_click_right.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setData$0(listPosition, view);
            }
        });
        holder.iv_img_click_left.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setData$2(listPosition, view);
            }
        });
        holder.imageThumbnailPdfLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setData$3(listPosition, view);
            }
        });
        if (SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS).equalsIgnoreCase("1")) {
            this.in_app_download = true;
        } else {
            this.in_app_download = false;
        }
        String message = this.dataSet.get(listPosition).getMessage();
        Log.e("TAG_APP", "setData: ==> messageRight" + message + SharedPreference.getInstance().getString(Const.IN_APP_DOWNLOADS) + " in_app_download " + this.in_app_download);
        bindPdfData(this.mContext, message, holder.pdfFile_name, holder.cvrDownLoadRight, holder.imageThumbnailPdfRight, false, this.in_app_download);
        bindPdfData(this.mContext, this.dataSet.get(listPosition).getMessage(), holder.pdfFile_nameLeft, holder.pdfdownloadLeft, holder.imageThumbnailPdfLeft, true, this.in_app_download);
        holder.imageThumbnailPdfRight.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setData$4(listPosition, view);
            }
        });
        LeftMenu leftMenu = this.leftMenu;
        if (leftMenu != null && leftMenu.getChatPinUnPin() != null && this.leftMenu.getChatPinUnPin().equalsIgnoreCase("1")) {
            holder.rl_text_click.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda8
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.lambda$setData$5(listPosition, view);
                }
            });
            holder.iv_img_click_right.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda9
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.lambda$setData$6(listPosition, view);
                }
            });
            holder.rl_audio_right.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda10
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.lambda$setData$7(listPosition, view);
                }
            });
            holder.pdf_right_click.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda11
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.lambda$setData$8(listPosition, view);
                }
            });
            holder.pdfViewRight.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda12
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.lambda$setData$9(listPosition, view);
                }
            });
            holder.rl_url_click.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.lambda$setData$10(listPosition, view);
                }
            });
        }
        if (this.dataSet.get(listPosition).getId().equals(SharedPreference.getInstance().getLoggedInUser().getId())) {
            if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("text")) {
                if (!TextUtils.isEmpty(this.dataSet.get(listPosition).getPin()) && this.dataSet.get(listPosition).getPin().equals("1")) {
                    holder.ivPinMsg.setVisibility(0);
                } else {
                    holder.ivPinMsg.setVisibility(8);
                }
                holder.cvrRight.setVisibility(0);
                if (this.dataSet.get(listPosition).getMessage() != null) {
                    holder.rightmessage.setText(this.dataSet.get(listPosition).getMessage().trim());
                }
                if (this.dataSet.get(listPosition).getName() != null) {
                    holder.userNameright.setText(this.dataSet.get(listPosition).getName().trim());
                }
                holder.righttexttime.setText(getTime(String.valueOf(this.dataSet.get(listPosition).getDate())));
                if (!"1".equalsIgnoreCase("2") && !TextUtils.isEmpty(this.dataSet.get(listPosition).getProfile_picture())) {
                    showServerImage(holder.profileImage2, this.dataSet.get(listPosition).getProfile_picture(), com.appnew.android.R.drawable.profile_grey);
                    return;
                } else {
                    holder.profileImage2.setImageResource(com.appnew.android.R.drawable.profile_grey);
                    return;
                }
            }
            if (this.dataSet.get(listPosition).getType().equalsIgnoreCase(Const.PDF)) {
                if (!TextUtils.isEmpty(this.dataSet.get(listPosition).getPin()) && this.dataSet.get(listPosition).getPin().equals("1")) {
                    holder.ivPinPdf.setVisibility(0);
                } else {
                    holder.ivPinPdf.setVisibility(8);
                }
                holder.cvrRightpdf.setVisibility(0);
                holder.cvrLeftpdf.setVisibility(8);
                holder.pdfText_username.setText(this.dataSet.get(listPosition).getName().trim());
                if (!TextUtils.isEmpty(this.dataSet.get(listPosition).getProfile_picture())) {
                    showServerImage(holder.pdfImage_user, this.dataSet.get(listPosition).getProfile_picture(), R.mipmap.default_pic);
                } else {
                    holder.pdfImage_user.setImageResource(R.mipmap.default_pic);
                }
                holder.righttexttimePdf.setText(getTime(String.valueOf(this.dataSet.get(listPosition).getDate())));
                holder.cvrDownLoadRight.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        Log.e("TAG_APP", "onClick: " + ChatAdapter.this.dataSet.get(listPosition).getMessage());
                        if (Helper.isNetworkConnected(ChatAdapter.this.mContext)) {
                            if (ChatAdapter.this.mContext instanceof Liveawsactivity) {
                                ChatAdapter chatAdapter = ChatAdapter.this;
                                chatAdapter.liveAwsActivityInstanceDownload(chatAdapter.dataSet.get(listPosition).getMessage(), listPosition, holder.cvrDownLoadRight);
                                return;
                            } else if (ChatAdapter.this.mContext instanceof LiveStreamingYoutube) {
                                ChatAdapter chatAdapter2 = ChatAdapter.this;
                                chatAdapter2.liveStreamingYoutubeInstanceDownload(chatAdapter2.dataSet.get(listPosition).getMessage(), listPosition, holder.cvrDownLoadRight);
                                return;
                            } else {
                                if (ChatAdapter.this.mContext instanceof VODPlayerActivity) {
                                    ChatAdapter chatAdapter3 = ChatAdapter.this;
                                    chatAdapter3.VODPlayerActivityInstanceDownload(chatAdapter3.dataSet.get(listPosition).getMessage(), listPosition, holder.cvrDownLoadRight);
                                    return;
                                }
                                return;
                            }
                        }
                        Helper.showInternetToast(ChatAdapter.this.mContext);
                    }
                });
                return;
            }
            if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("url")) {
                if (!TextUtils.isEmpty(this.dataSet.get(listPosition).getPin()) && this.dataSet.get(listPosition).getPin().equals("1")) {
                    holder.ivPinUrl.setVisibility(0);
                } else {
                    holder.ivPinUrl.setVisibility(8);
                }
                holder.cvrUrlRight.setVisibility(0);
                holder.cvrUrlLeft.setVisibility(8);
                holder.urlRightTv.setText(this.dataSet.get(listPosition).getMessage().trim());
                holder.urlRightTv.setText(this.dataSet.get(listPosition).getMessage().trim());
                holder.userNamerightUrl.setText(this.dataSet.get(listPosition).getName().trim());
                holder.righttexttimeUrl.setText(getTime(String.valueOf(this.dataSet.get(listPosition).getDate())));
                if (!"1".equalsIgnoreCase("2") && !TextUtils.isEmpty(this.dataSet.get(listPosition).getProfile_picture())) {
                    showServerImage(holder.profileImage2Url, this.dataSet.get(listPosition).getProfile_picture(), R.mipmap.default_pic);
                    return;
                } else {
                    holder.profileImage2Url.setImageResource(R.mipmap.default_pic);
                    return;
                }
            }
            if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("audio")) {
                if (!TextUtils.isEmpty(this.dataSet.get(listPosition).getPin()) && this.dataSet.get(listPosition).getPin().equals("1")) {
                    holder.ivPinAudio.setVisibility(0);
                } else {
                    holder.ivPinAudio.setVisibility(8);
                }
                holder.cvrRightAudio.setVisibility(0);
                holder.cvrLeftAudio.setVisibility(8);
                holder.audioText_username.setText(this.dataSet.get(listPosition).getName().trim());
                holder.righttexttimeAudio.setText(getTime(String.valueOf(this.dataSet.get(listPosition).getDate())));
                if (!"1".equalsIgnoreCase("2") && !TextUtils.isEmpty(this.dataSet.get(listPosition).getProfile_picture())) {
                    showServerImage(holder.audioImage_user, this.dataSet.get(listPosition).getProfile_picture(), R.mipmap.default_pic);
                } else {
                    holder.audioImage_user.setImageResource(R.mipmap.default_pic);
                }
                holder.audioplay.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Helper.isNetworkConnected(ChatAdapter.this.mContext)) {
                            ChatAdapter chatAdapter = ChatAdapter.this;
                            chatAdapter.pauseVideoPlayer(chatAdapter.mContext);
                            ChatAdapter.this.pauseAudio();
                            String message2 = ChatAdapter.this.dataSet.get(listPosition).getMessage();
                            if (message2 == null || message2.isEmpty()) {
                                Toast.makeText(ChatAdapter.this.mContext, "Audio file corrupted.", 0).show();
                                return;
                            }
                            if (ChatAdapter.this.mediaPlayer == null) {
                                chatPojo chatpojo = ChatAdapter.this.dataSet.get(listPosition);
                                chatpojo.setIsplaying(true);
                                ChatAdapter.this.dataSet.set(listPosition, chatpojo);
                                ChatAdapter.this.lastselected = listPosition;
                                ChatAdapter chatAdapter2 = ChatAdapter.this;
                                chatAdapter2.notifyItemChanged(chatAdapter2.lastselected);
                                ChatAdapter chatAdapter3 = ChatAdapter.this;
                                chatAdapter3.mediaPlayer = MediaPlayer.create(chatAdapter3.mContext, Uri.parse(ChatAdapter.this.dataSet.get(listPosition).getMessage()));
                                ChatAdapter.this.mediaPlayer.start();
                                ChatAdapter chatAdapter4 = ChatAdapter.this;
                                MyViewHolder myViewHolder = holder;
                                chatAdapter4.starttimer(myViewHolder, myViewHolder.audiopause, holder.audioplay, listPosition);
                                return;
                            }
                            if (ChatAdapter.this.mediaPlayer.isPlaying()) {
                                ChatAdapter.this.mediaPlayer.pause();
                                ChatAdapter.this.stoptimer();
                                chatPojo chatpojo2 = ChatAdapter.this.dataSet.get(ChatAdapter.this.lastselected);
                                chatpojo2.setIsplaying(false);
                                ChatAdapter.this.dataSet.set(ChatAdapter.this.lastselected, chatpojo2);
                                chatPojo chatpojo3 = ChatAdapter.this.dataSet.get(listPosition);
                                chatpojo3.setIsplaying(true);
                                ChatAdapter.this.dataSet.set(listPosition, chatpojo3);
                                ChatAdapter.this.lastselected = listPosition;
                                ChatAdapter chatAdapter5 = ChatAdapter.this;
                                chatAdapter5.notifyItemChanged(chatAdapter5.lastselected);
                                ChatAdapter chatAdapter6 = ChatAdapter.this;
                                chatAdapter6.mediaPlayer = MediaPlayer.create(chatAdapter6.mContext, Uri.parse(ChatAdapter.this.dataSet.get(listPosition).getMessage()));
                                ChatAdapter.this.mediaPlayer.start();
                                ChatAdapter chatAdapter7 = ChatAdapter.this;
                                MyViewHolder myViewHolder2 = holder;
                                chatAdapter7.starttimer(myViewHolder2, myViewHolder2.audiopause, holder.audioplay, listPosition);
                                return;
                            }
                            chatPojo chatpojo4 = ChatAdapter.this.dataSet.get(listPosition);
                            chatpojo4.setIsplaying(true);
                            ChatAdapter.this.dataSet.set(listPosition, chatpojo4);
                            ChatAdapter.this.lastselected = listPosition;
                            ChatAdapter chatAdapter8 = ChatAdapter.this;
                            chatAdapter8.notifyItemChanged(chatAdapter8.lastselected);
                            ChatAdapter chatAdapter9 = ChatAdapter.this;
                            chatAdapter9.mediaPlayer = MediaPlayer.create(chatAdapter9.mContext, Uri.parse(ChatAdapter.this.dataSet.get(listPosition).getMessage()));
                            ChatAdapter.this.mediaPlayer.start();
                            ChatAdapter chatAdapter10 = ChatAdapter.this;
                            MyViewHolder myViewHolder3 = holder;
                            chatAdapter10.starttimer(myViewHolder3, myViewHolder3.audiopause, holder.audioplay, listPosition);
                            return;
                        }
                        Helper.showInternetToast(ChatAdapter.this.mContext);
                    }
                });
                holder.audiopause.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$11(listPosition, view);
                    }
                });
                if (this.dataSet.get(listPosition).isIsplaying()) {
                    holder.audiopause.setVisibility(0);
                    holder.audioplay.setVisibility(8);
                    return;
                } else {
                    holder.audiopause.setVisibility(8);
                    holder.audioplay.setVisibility(0);
                    return;
                }
            }
            if (!TextUtils.isEmpty(this.dataSet.get(listPosition).getPin()) && this.dataSet.get(listPosition).getPin().equals("1")) {
                holder.ivPinImage.setVisibility(0);
            } else {
                holder.ivPinImage.setVisibility(8);
            }
            holder.cvrRightimage.setVisibility(0);
            if (!"1".equalsIgnoreCase("2") && !TextUtils.isEmpty(this.dataSet.get(listPosition).getMessage())) {
                Utils.INSTANCE.loadImageWithDynamicDimensions(this.mContext, this.dataSet.get(listPosition).getMessage(), holder.imageRightParentCL, holder.rightmessageimage);
                showServerImage(holder.rightmessageimage, this.dataSet.get(listPosition).getMessage(), R.mipmap.default_pic);
            } else {
                holder.rightmessageimage.setImageResource(R.mipmap.default_pic);
            }
            holder.userNamerightimage.setText(this.dataSet.get(listPosition).getName().trim());
            holder.rightimagettime.setText(getTime(String.valueOf(this.dataSet.get(listPosition).getDate())));
            if (!"1".equalsIgnoreCase("2") && !TextUtils.isEmpty(this.dataSet.get(listPosition).getProfile_picture())) {
                showServerImage(holder.profileImage2image, this.dataSet.get(listPosition).getProfile_picture(), R.mipmap.default_pic);
                return;
            } else {
                holder.profileImage2image.setImageResource(R.mipmap.default_pic);
                return;
            }
        }
        if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("text")) {
            holder.cvrLeft.setVisibility(0);
            if (this.dataSet.get(listPosition).getMessage() != null) {
                holder.letfmessageTv.setText(this.dataSet.get(listPosition).getMessage().trim());
            }
            if (this.dataSet.get(listPosition).getName() != null) {
                holder.userName.setText(this.dataSet.get(listPosition).getName().trim());
            }
            holder.lefttexttime.setText(getTime(String.valueOf(this.dataSet.get(listPosition).getDate())));
            if (!TextUtils.isEmpty(this.dataSet.get(listPosition).getProfile_picture())) {
                showServerImage(holder.profileImage, this.dataSet.get(listPosition).getProfile_picture(), R.mipmap.default_pic);
                return;
            } else {
                holder.profileImage.setImageResource(R.mipmap.default_pic);
                return;
            }
        }
        if (this.dataSet.get(listPosition).getType().equalsIgnoreCase(Const.PDF)) {
            holder.cvrRightpdf.setVisibility(8);
            holder.cvrLeftpdf.setVisibility(0);
            holder.pdfText_usernameLeft.setText(this.dataSet.get(listPosition).getName().trim());
            holder.pdf_timeLeftPdf.setText(getTime(String.valueOf(this.dataSet.get(listPosition).getDate())));
            if (!"1".equalsIgnoreCase("2") && !TextUtils.isEmpty(this.dataSet.get(listPosition).getProfile_picture())) {
                showServerImage(holder.pdfImage_userLeft, this.dataSet.get(listPosition).getProfile_picture(), R.mipmap.default_pic);
            } else {
                holder.pdfImage_userLeft.setImageResource(R.mipmap.default_pic);
            }
            holder.pdfdownloadLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter.6
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Helper.isNetworkConnected(ChatAdapter.this.mContext)) {
                        if (ChatAdapter.this.mContext instanceof Liveawsactivity) {
                            ChatAdapter chatAdapter = ChatAdapter.this;
                            chatAdapter.liveAwsActivityInstanceDownload(chatAdapter.dataSet.get(listPosition).getMessage(), listPosition, holder.cvrDownLoadRight);
                            return;
                        } else if (ChatAdapter.this.mContext instanceof LiveStreamingYoutube) {
                            ChatAdapter chatAdapter2 = ChatAdapter.this;
                            chatAdapter2.liveStreamingYoutubeInstanceDownload(chatAdapter2.dataSet.get(listPosition).getMessage(), listPosition, holder.pdfdownloadLeft);
                            return;
                        } else {
                            if (ChatAdapter.this.mContext instanceof VODPlayerActivity) {
                                ChatAdapter chatAdapter3 = ChatAdapter.this;
                                chatAdapter3.VODPlayerActivityInstanceDownload(chatAdapter3.dataSet.get(listPosition).getMessage(), listPosition, holder.cvrDownLoadRight);
                                return;
                            }
                            return;
                        }
                    }
                    Helper.showInternetToast(ChatAdapter.this.mContext);
                }
            });
            return;
        }
        if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("url")) {
            holder.cvrUrlRight.setVisibility(8);
            holder.cvrUrlLeft.setVisibility(0);
            holder.urlLeftTv.setText(this.dataSet.get(listPosition).getMessage().trim());
            Linkify.addLinks(holder.urlLeftTv, 1);
            holder.userNameUrlLeft.setText(this.dataSet.get(listPosition).getName().trim());
            holder.lefttexttimeUrl.setText(getTime(String.valueOf(this.dataSet.get(listPosition).getDate())));
            if (!"1".equalsIgnoreCase("2") && !TextUtils.isEmpty(this.dataSet.get(listPosition).getProfile_picture())) {
                showServerImage(holder.profileImageUrlLeft, this.dataSet.get(listPosition).getProfile_picture(), R.mipmap.default_pic);
                return;
            } else {
                holder.profileImageUrlLeft.setImageResource(R.mipmap.default_pic);
                return;
            }
        }
        if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("audio")) {
            holder.cvrRightAudio.setVisibility(8);
            holder.cvrLeftAudio.setVisibility(0);
            holder.audioText_usernameLeft.setText(this.dataSet.get(listPosition).getName().trim());
            holder.audio_timeLeftAudio.setText(getTime(String.valueOf(this.dataSet.get(listPosition).getDate())));
            if (!"1".equalsIgnoreCase("2") && !TextUtils.isEmpty(this.dataSet.get(listPosition).getProfile_picture())) {
                showServerImage(holder.audioImage_userLeft, this.dataSet.get(listPosition).getProfile_picture(), R.mipmap.default_pic);
            } else {
                holder.audioImage_userLeft.setImageResource(R.mipmap.default_pic);
            }
            holder.audioplayLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (Helper.isNetworkConnected(ChatAdapter.this.mContext)) {
                        ChatAdapter.this.pauseAudio();
                        ChatAdapter chatAdapter = ChatAdapter.this;
                        chatAdapter.pauseVideoPlayer(chatAdapter.mContext);
                        if (ChatAdapter.this.mediaPlayer == null) {
                            chatPojo chatpojo = ChatAdapter.this.dataSet.get(listPosition);
                            chatpojo.setIsplaying(true);
                            ChatAdapter.this.dataSet.set(listPosition, chatpojo);
                            ChatAdapter.this.lastselected = listPosition;
                            ChatAdapter chatAdapter2 = ChatAdapter.this;
                            chatAdapter2.notifyItemChanged(chatAdapter2.lastselected);
                            ChatAdapter chatAdapter3 = ChatAdapter.this;
                            chatAdapter3.mediaPlayer = MediaPlayer.create(chatAdapter3.mContext, Uri.parse(ChatAdapter.this.dataSet.get(listPosition).getMessage()));
                            ChatAdapter.this.mediaPlayer.start();
                            ChatAdapter chatAdapter4 = ChatAdapter.this;
                            MyViewHolder myViewHolder = holder;
                            chatAdapter4.starttimer(myViewHolder, myViewHolder.audiopause, holder.audioplay, listPosition);
                            return;
                        }
                        if (ChatAdapter.this.mediaPlayer.isPlaying()) {
                            ChatAdapter.this.mediaPlayer.pause();
                            ChatAdapter chatAdapter5 = ChatAdapter.this;
                            chatAdapter5.notifyItemChanged(chatAdapter5.lastselected);
                            ChatAdapter.this.stoptimer();
                            chatPojo chatpojo2 = ChatAdapter.this.dataSet.get(ChatAdapter.this.lastselected);
                            chatpojo2.setIsplaying(false);
                            ChatAdapter.this.dataSet.set(ChatAdapter.this.lastselected, chatpojo2);
                            chatPojo chatpojo3 = ChatAdapter.this.dataSet.get(listPosition);
                            chatpojo3.setIsplaying(true);
                            ChatAdapter.this.dataSet.set(listPosition, chatpojo3);
                            ChatAdapter.this.lastselected = listPosition;
                            ChatAdapter chatAdapter6 = ChatAdapter.this;
                            chatAdapter6.notifyItemChanged(chatAdapter6.lastselected);
                            ChatAdapter chatAdapter7 = ChatAdapter.this;
                            chatAdapter7.mediaPlayer = MediaPlayer.create(chatAdapter7.mContext, Uri.parse(ChatAdapter.this.dataSet.get(listPosition).getMessage()));
                            ChatAdapter.this.mediaPlayer.start();
                            ChatAdapter chatAdapter8 = ChatAdapter.this;
                            MyViewHolder myViewHolder2 = holder;
                            chatAdapter8.starttimer(myViewHolder2, myViewHolder2.audiopause, holder.audioplay, listPosition);
                            return;
                        }
                        chatPojo chatpojo4 = ChatAdapter.this.dataSet.get(listPosition);
                        chatpojo4.setIsplaying(true);
                        ChatAdapter.this.dataSet.set(listPosition, chatpojo4);
                        ChatAdapter.this.lastselected = listPosition;
                        ChatAdapter chatAdapter9 = ChatAdapter.this;
                        chatAdapter9.notifyItemChanged(chatAdapter9.lastselected);
                        ChatAdapter chatAdapter10 = ChatAdapter.this;
                        chatAdapter10.mediaPlayer = MediaPlayer.create(chatAdapter10.mContext, Uri.parse(ChatAdapter.this.dataSet.get(listPosition).getMessage()));
                        ChatAdapter.this.mediaPlayer.start();
                        ChatAdapter chatAdapter11 = ChatAdapter.this;
                        MyViewHolder myViewHolder3 = holder;
                        chatAdapter11.starttimer(myViewHolder3, myViewHolder3.audiopause, holder.audioplay, listPosition);
                        return;
                    }
                    Helper.showInternetToast(ChatAdapter.this.mContext);
                }
            });
            holder.audiopauseLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ChatAdapter.this.stoptimer();
                    chatPojo chatpojo = ChatAdapter.this.dataSet.get(listPosition);
                    chatpojo.setIsplaying(false);
                    ChatAdapter.this.dataSet.set(listPosition, chatpojo);
                    ChatAdapter.this.notifyItemChanged(listPosition);
                    ChatAdapter.this.mediaPlayer.pause();
                    ChatAdapter chatAdapter = ChatAdapter.this;
                    chatAdapter.playVideoPlayer(chatAdapter.mContext);
                }
            });
            if (this.dataSet.get(listPosition).isIsplaying()) {
                holder.audiopauseLeft.setVisibility(0);
                holder.audioplayLeft.setVisibility(8);
                return;
            } else {
                holder.audiopauseLeft.setVisibility(8);
                holder.audioplayLeft.setVisibility(0);
                return;
            }
        }
        holder.cvrLeftimage.setVisibility(0);
        if (!TextUtils.isEmpty(this.dataSet.get(listPosition).getMessage())) {
            holder.letfmessageTvimage.setLayerType(1, null);
            Utils.INSTANCE.loadImageWithDynamicDimensions(this.mContext, this.dataSet.get(listPosition).getMessage(), holder.imageLeftParentCL, holder.letfmessageTvimage);
            showServerImage(holder.letfmessageTvimage, this.dataSet.get(listPosition).getMessage(), R.mipmap.default_pic);
        } else {
            holder.letfmessageTvimage.setImageResource(R.mipmap.default_pic);
        }
        holder.userNameimage.setText(this.dataSet.get(listPosition).getName().trim());
        if (!"1".equalsIgnoreCase("2") && !TextUtils.isEmpty(this.dataSet.get(listPosition).getProfile_picture())) {
            showServerImage(holder.profileImageimage, this.dataSet.get(listPosition).getProfile_picture(), R.mipmap.default_pic);
        } else {
            holder.profileImageimage.setImageResource(R.mipmap.default_pic);
        }
        holder.leftimagetime.setText(getTime(String.valueOf(this.dataSet.get(listPosition).getDate())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$0(int i, View view) {
        pauseVideoPlayer(this.mContext);
        pauseAudio();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        View viewInflate = ((Activity) this.mContext).getLayoutInflater().inflate(R.layout.image_layout, (ViewGroup) null);
        builder.setView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.cancel);
        if (!TextUtils.isEmpty(this.dataSet.get(i).getMessage())) {
            showServerImage(imageView, this.dataSet.get(i).getMessage().replaceAll(" ", "%20"), com.appnew.android.R.drawable.profile_grey);
        } else {
            imageView.setImageResource(com.appnew.android.R.drawable.profile_grey);
        }
        final AlertDialog alertDialogShow = builder.show();
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                alertDialogShow.dismiss();
            }
        });
        alertDialogShow.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.player.ChatAdapter.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialog) {
                ChatAdapter chatAdapter = ChatAdapter.this;
                chatAdapter.playVideoPlayer(chatAdapter.mContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$2(int i, View view) {
        pauseVideoPlayer(this.mContext);
        pauseAudio();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        View viewInflate = ((Activity) this.mContext).getLayoutInflater().inflate(R.layout.image_layout, (ViewGroup) null);
        builder.setView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.cancel);
        if (!"1".equalsIgnoreCase("2") && !TextUtils.isEmpty(this.dataSet.get(i).getMessage())) {
            showServerImage(imageView, this.dataSet.get(i).getMessage().replaceAll(" ", "%20"), com.appnew.android.R.drawable.profile_grey);
        } else {
            imageView.setImageResource(com.appnew.android.R.drawable.profile_grey);
        }
        final AlertDialog alertDialogShow = builder.show();
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                alertDialogShow.dismiss();
            }
        });
        alertDialogShow.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appnew.android.player.ChatAdapter.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialog) {
                ChatAdapter chatAdapter = ChatAdapter.this;
                chatAdapter.playVideoPlayer(chatAdapter.mContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$3(int i, View view) {
        pauseAudio();
        if (Helper.isNetworkConnected(this.mContext)) {
            Intent intent = new Intent(this.mContext, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("url", this.dataSet.get(i).getMessage());
            intent.putExtra("from", "ChatAdapter");
            this.mContext.startActivity(intent);
            return;
        }
        Helper.showInternetToast(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$4(int i, View view) {
        pauseAudio();
        if (Helper.isNetworkConnected(this.mContext)) {
            Intent intent = new Intent(this.mContext, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("url", this.dataSet.get(i).getMessage());
            intent.putExtra("from", "ChatAdapter");
            this.mContext.startActivity(intent);
            return;
        }
        Helper.showInternetToast(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setData$5(int i, View view) {
        Context context = this.mContext;
        if (context instanceof Liveawsactivity) {
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (context instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) context).ischatload = true;
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (!(context instanceof VODPlayerActivity)) {
            return false;
        }
        ((VODPlayerActivity) context).ischatload = true;
        if (Const.SHOW_PIN.equals(this.type)) {
            return false;
        }
        setLableAndPin(i);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setData$6(int i, View view) {
        Context context = this.mContext;
        if (context instanceof Liveawsactivity) {
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (context instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) context).ischatload = true;
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (!(context instanceof VODPlayerActivity)) {
            return false;
        }
        ((VODPlayerActivity) context).ischatload = true;
        if (Const.SHOW_PIN.equals(this.type)) {
            return false;
        }
        setLableAndPin(i);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setData$7(int i, View view) {
        Context context = this.mContext;
        if (context instanceof Liveawsactivity) {
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (context instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) context).ischatload = true;
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (!(context instanceof VODPlayerActivity)) {
            return false;
        }
        ((VODPlayerActivity) context).ischatload = true;
        if (Const.SHOW_PIN.equals(this.type)) {
            return false;
        }
        setLableAndPin(i);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setData$8(int i, View view) {
        Context context = this.mContext;
        if (context instanceof Liveawsactivity) {
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (context instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) context).ischatload = true;
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (!(context instanceof VODPlayerActivity)) {
            return false;
        }
        ((VODPlayerActivity) context).ischatload = true;
        if (Const.SHOW_PIN.equals(this.type)) {
            return false;
        }
        setLableAndPin(i);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setData$9(int i, View view) {
        Context context = this.mContext;
        if (context instanceof Liveawsactivity) {
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (context instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) context).ischatload = true;
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (!(context instanceof VODPlayerActivity)) {
            return false;
        }
        ((VODPlayerActivity) context).ischatload = true;
        if (Const.SHOW_PIN.equals(this.type)) {
            return false;
        }
        setLableAndPin(i);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setData$10(int i, View view) {
        Context context = this.mContext;
        if (context instanceof Liveawsactivity) {
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (context instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) context).ischatload = true;
            if (Const.SHOW_PIN.equals(this.type)) {
                return false;
            }
            setLableAndPin(i);
            return false;
        }
        if (!(context instanceof VODPlayerActivity)) {
            return false;
        }
        ((VODPlayerActivity) context).ischatload = true;
        if (Const.SHOW_PIN.equals(this.type)) {
            return false;
        }
        setLableAndPin(i);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$11(int i, View view) {
        stoptimer();
        chatPojo chatpojo = this.dataSet.get(i);
        chatpojo.setIsplaying(false);
        this.dataSet.set(i, chatpojo);
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mediaPlayer.pause();
        }
        notifyItemChanged(i);
        playVideoPlayer(this.mContext);
    }

    public void pauseAudio() {
        if (this.tempHolder != null) {
            stoptimer();
            chatPojo chatpojo = this.dataSet.get(this.templistPosition);
            chatpojo.setIsplaying(false);
            this.dataSet.set(this.templistPosition, chatpojo);
            this.tempHolder.audiopause.setVisibility(8);
            this.tempHolder.audioplay.setVisibility(0);
            notifyItemChanged(this.templistPosition);
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.mediaPlayer.pause();
            }
            this.tempHolder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVideoPlayer(Context mContext) {
        if (mContext instanceof Liveawsactivity) {
            ((Liveawsactivity) mContext).resumePlayer();
        } else if (mContext instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) mContext).resumePlayer();
        } else if (mContext instanceof VODPlayerActivity) {
            ((VODPlayerActivity) mContext).resumePlayer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideoPlayer(Context mContext) {
        if (mContext instanceof Liveawsactivity) {
            ((Liveawsactivity) mContext).pausePlayer();
        } else if (mContext instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) mContext).pausePlayerFromAdapter();
        } else if (mContext instanceof VODPlayerActivity) {
            ((VODPlayerActivity) mContext).pausePlayer();
        }
    }

    private void setPinChat(Context mContext, int position) {
        if (mContext instanceof Liveawsactivity) {
            ((Liveawsactivity) mContext).setpin(this.dataSet.get(position), position);
        } else if (mContext instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) mContext).setpin(this.dataSet.get(position), position);
        } else if (mContext instanceof VODPlayerActivity) {
            ((VODPlayerActivity) mContext).setpin(this.dataSet.get(position), position);
        }
    }

    private void setUnPin(Context mContext, int position) {
        if (mContext instanceof Liveawsactivity) {
            ((Liveawsactivity) mContext).setunPin(this.dataSet.get(position), position);
        } else if (mContext instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) mContext).setunPin(this.dataSet.get(position), position);
        } else if (mContext instanceof VODPlayerActivity) {
            ((VODPlayerActivity) mContext).setunPin(this.dataSet.get(position), position);
        }
    }

    private void setLableAndPin(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        View viewInflate = ((AppCompatActivity) this.mContext).getLayoutInflater().inflate(R.layout.dialog_star_lable_layout, (ViewGroup) null);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(true);
        final chatPojo chatpojo = this.dataSet.get(position);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.llDelete);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tvPin);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tvDelete);
        if (chatpojo.getId().equals(SharedPreference.getInstance().getLoggedInUser().getId())) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
        if (!TextUtils.isEmpty(chatpojo.getPin()) && chatpojo.getPin().equals("1")) {
            textView.setText(this.mContext.getResources().getString(R.string.un_pin));
        } else {
            textView.setText(this.mContext.getResources().getString(R.string.pin));
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.ChatAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setLableAndPin$12(chatpojo, position, alertDialogCreate, view);
            }
        });
        textView2.setVisibility(8);
        alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Context context = this.mContext;
        if (context instanceof Liveawsactivity) {
            if (!((Liveawsactivity) context).isChatPin) {
                alertDialogCreate.show();
            }
        } else if (context instanceof LiveStreamingYoutube) {
            if (!((LiveStreamingYoutube) context).isChatPin) {
                alertDialogCreate.show();
            }
        } else if ((context instanceof VODPlayerActivity) && !((VODPlayerActivity) context).isPinChat) {
            alertDialogCreate.show();
        }
        alertDialogCreate.getWindow().setGravity(17);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((AppCompatActivity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        alertDialogCreate.getWindow().setLayout((displayMetrics.widthPixels * 50) / 100, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setLableAndPin$12(chatPojo chatpojo, int i, AlertDialog alertDialog, View view) {
        if (!TextUtils.isEmpty(chatpojo.getPin()) && chatpojo.getPin().equals("1")) {
            setUnPin(this.mContext, i);
        } else {
            setPinChat(this.mContext, i);
        }
        alertDialog.dismiss();
    }

    private void deleteChat(Context mContext, int position) {
        if (mContext instanceof Liveawsactivity) {
            ((Liveawsactivity) mContext).deleteChat(position);
        } else if (mContext instanceof LiveStreamingYoutube) {
            ((LiveStreamingYoutube) mContext).deleteChat(position);
        } else if (mContext instanceof VODPlayerActivity) {
            ((VODPlayerActivity) mContext).deleteChat(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VODPlayerActivityInstanceDownload(String data, final int listPositionKey, final RelativeLayout cvrDownLoad) {
        final PostFile postFile = new PostFile();
        postFile.setLink(data);
        postFile.setFile_type(Const.PDF);
        String str = data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1];
        if (!str.contains("")) {
            postFile.setFile_info(data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1]);
        } else {
            postFile.setFile_info(str.replaceAll(" ", "_"));
        }
        try {
            Dexter.withContext((VODPlayerActivity) this.mContext).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.player.ChatAdapter.9
                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionsChecked(MultiplePermissionsReport report) {
                    if (Helper.getStorageInstance(ChatAdapter.this.mContext).getRecordObject(Const.PDF) != null) {
                        SocketKt.downloadFileFromURL((Activity) ChatAdapter.this.mContext, (PostFile) Helper.getStorageInstance(ChatAdapter.this.mContext).getRecordObject(Const.PDF), ChatAdapter.this.dataSet.get(listPositionKey), cvrDownLoad, ChatAdapter.this.in_app_download.booleanValue(), false);
                        Helper.getStorageInstance(ChatAdapter.this.mContext).deleteRecord(Const.PDF);
                        return;
                    }
                    SocketKt.downloadFileFromURL((Activity) ChatAdapter.this.mContext, postFile, ChatAdapter.this.dataSet.get(listPositionKey), cvrDownLoad, ChatAdapter.this.in_app_download.booleanValue(), false);
                }

                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    token.continuePermissionRequest();
                }
            }).check();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void liveStreamingYoutubeInstanceDownload(String data, final int listPositionKey, final RelativeLayout cvrDownLoad) {
        final PostFile postFile = new PostFile();
        postFile.setLink(data);
        postFile.setFile_type(Const.PDF);
        String str = data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1];
        if (!str.contains("")) {
            postFile.setFile_info(data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1]);
        } else {
            postFile.setFile_info(str.replaceAll(" ", "_"));
        }
        try {
            Dexter.withContext((LiveStreamingYoutube) this.mContext).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.player.ChatAdapter.10
                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionsChecked(MultiplePermissionsReport report) {
                    Log.e("TAG_APP", "onPermissionsChecked_: insodepdf");
                    if (Helper.getStorageInstance(ChatAdapter.this.mContext).getRecordObject(Const.PDF) != null) {
                        PostFile postFile2 = (PostFile) Helper.getStorageInstance(ChatAdapter.this.mContext).getRecordObject(Const.PDF);
                        Log.e("TAG_APP", "onPermissionsChecked: insode");
                        SocketKt.downloadFileFromURL((Activity) ChatAdapter.this.mContext, postFile2, ChatAdapter.this.dataSet.get(listPositionKey), cvrDownLoad, ChatAdapter.this.in_app_download.booleanValue(), false);
                        Helper.getStorageInstance(ChatAdapter.this.mContext).deleteRecord(Const.PDF);
                    } else {
                        Log.e("TAG_APP", "onPermissionsChecked: out");
                    }
                    SocketKt.downloadFileFromURL((Activity) ChatAdapter.this.mContext, postFile, ChatAdapter.this.dataSet.get(listPositionKey), cvrDownLoad, ChatAdapter.this.in_app_download.booleanValue(), false);
                }

                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    token.continuePermissionRequest();
                }
            }).check();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void liveAwsActivityInstanceDownload(String data, final int listPositionKey, final RelativeLayout cvrDownLoad) {
        final PostFile postFile = new PostFile();
        postFile.setLink(data);
        postFile.setFile_type(Const.PDF);
        String str = data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1];
        if (!str.contains("")) {
            postFile.setFile_info(data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1]);
        } else {
            postFile.setFile_info(str.replaceAll(" ", "_"));
        }
        try {
            Dexter.withContext((Liveawsactivity) this.mContext).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.player.ChatAdapter.11
                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionsChecked(MultiplePermissionsReport report) {
                    if (Helper.getStorageInstance(ChatAdapter.this.mContext).getRecordObject(Const.PDF) != null) {
                        SocketKt.downloadFileFromURL((Activity) ChatAdapter.this.mContext, (PostFile) Helper.getStorageInstance(ChatAdapter.this.mContext).getRecordObject(Const.PDF), ChatAdapter.this.dataSet.get(listPositionKey), cvrDownLoad, ChatAdapter.this.in_app_download.booleanValue(), false);
                        Helper.getStorageInstance(ChatAdapter.this.mContext).deleteRecord(Const.PDF);
                        return;
                    }
                    SocketKt.downloadFileFromURL((Activity) ChatAdapter.this.mContext, postFile, ChatAdapter.this.dataSet.get(listPositionKey), cvrDownLoad, ChatAdapter.this.in_app_download.booleanValue(), false);
                }

                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    token.continuePermissionRequest();
                }
            }).check();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {
        ImageView ivAdmin;
        LinearLayout llAdmin;
        TextView tvAdmin;
        TextView tv_time;
        TextView tv_username;

        public MyViewHolder2(View itemView) {
            super(itemView);
            this.tv_username = (TextView) itemView.findViewById(R.id.tv_username);
            this.tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            this.ivAdmin = (ImageView) itemView.findViewById(R.id.iv_admin);
            this.tvAdmin = (TextView) itemView.findViewById(R.id.tv_admin);
            this.llAdmin = (LinearLayout) itemView.findViewById(R.id.ll_admin);
        }
    }

    private void setTransparentData(final MyViewHolder2 holder, int listPosition) {
        if (!TextUtils.isEmpty(this.dataSet.get(listPosition).getProfile_picture())) {
            showServerImage(holder.ivAdmin, this.dataSet.get(listPosition).getProfile_picture(), R.mipmap.default_pic);
        } else {
            holder.ivAdmin.setImageResource(R.mipmap.default_pic);
        }
        holder.llAdmin.setVisibility(0);
        holder.tvAdmin.setText(this.dataSet.get(listPosition).getMessage());
        holder.tv_username.setText(this.dataSet.get(listPosition).getName());
        holder.tv_time.setText(String.valueOf(this.dataSet.get(listPosition).getDate()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.type.equals("trans") ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<chatPojo> arrayList = this.dataSet;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public String getdate(String timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp))));
    }

    public void starttimer(final MyViewHolder holder, final Button pauser, final Button play, final int listPosition) {
        this.tempHolder = holder;
        this.templistPosition = listPosition;
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(new TimerTask() { // from class: com.appnew.android.player.ChatAdapter.12
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ((Activity) ChatAdapter.this.mContext).runOnUiThread(new Runnable() { // from class: com.appnew.android.player.ChatAdapter.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ChatAdapter.this.timer == null) {
                            return;
                        }
                        if (ChatAdapter.this.mediaPlayer.isPlaying()) {
                            if (ChatAdapter.this.i == 0) {
                                if (ChatAdapter.this.mContext instanceof Liveawsactivity) {
                                    ((Liveawsactivity) ChatAdapter.this.mContext).oncall(true);
                                    return;
                                } else if (ChatAdapter.this.mContext instanceof LiveStreamingYoutube) {
                                    ((LiveStreamingYoutube) ChatAdapter.this.mContext).oncall(true);
                                    return;
                                } else {
                                    if (ChatAdapter.this.mContext instanceof VODPlayerActivity) {
                                        ((VODPlayerActivity) ChatAdapter.this.mContext).oncall(true);
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        ChatAdapter.this.stoptimer();
                        chatPojo chatpojo = ChatAdapter.this.dataSet.get(listPosition);
                        chatpojo.setIsplaying(false);
                        ChatAdapter.this.dataSet.set(listPosition, chatpojo);
                        ChatAdapter.this.notifyItemChanged(ChatAdapter.this.lastselected);
                        ChatAdapter.this.playVideoPlayer(ChatAdapter.this.mContext);
                    }
                });
            }
        }, 0L, 1000L);
    }

    public void stoptimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    public void updateList(chatPojo data) {
        this.dataSet.add(data);
        notifyDataSetChanged();
    }

    public void clearList() {
        this.dataSet.clear();
    }

    private void showServerImage(ImageView imageView, String url, int defaultImage) {
        try {
            RequestManager requestManagerWith = Glide.with(imageView.getContext());
            if (TextUtils.isEmpty(url.trim())) {
                url = "";
            }
            requestManagerWith.load(url).apply((BaseRequestOptions<?>) new RequestOptions().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)).placeholder(defaultImage).error(defaultImage).into(imageView);
        } catch (Exception unused) {
            imageView.setImageResource(defaultImage);
        }
    }

    private String getTime(String timestamp) {
        if (timestamp == null || timestamp.isEmpty()) {
            return "Invalid timestamp";
        }
        try {
            long j = Long.parseLong(timestamp);
            Calendar calendar = Calendar.getInstance();
            calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
            return Helper.changeAMPM(new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date(j)));
        } catch (NumberFormatException unused) {
            return "Invalid timestamp format";
        } catch (Exception unused2) {
            return "Error formatting date";
        }
    }

    public Pair<Boolean, File> isFileExist(Context context, String fileName, boolean isLeft, boolean inAppDownload) {
        File file;
        boolean zExists;
        Log.e("TAG_APP", "isFileExist ==>: " + fileName);
        if (isLeft) {
            if (inAppDownload) {
                File file2 = new File(context.getFilesDir().getPath());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(context.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
                zExists = file.exists();
            } else {
                File file3 = new File(Environment.getExternalStorageDirectory().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + Environment.DIRECTORY_DOWNLOADS + "/EDUTERIA_doc_folder");
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                file = new File(file3.getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
                zExists = file.exists();
            }
        } else if (inAppDownload) {
            File file4 = new File(context.getFilesDir().getPath());
            if (!file4.exists()) {
                file4.mkdirs();
            }
            file = new File(context.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
            zExists = file.exists();
        } else {
            File file5 = new File(Environment.getExternalStorageDirectory().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + Environment.DIRECTORY_DOWNLOADS + "/EDUTERIA_doc_folder");
            if (!file5.exists()) {
                file5.mkdirs();
            }
            file = new File(file5.getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + fileName);
            zExists = file.exists();
        }
        return new Pair<>(Boolean.valueOf(zExists), file);
    }

    private void bindPdfData(Context context, String message, TextView pdfFileName, View downloadButton, ImageView thumbnail, boolean isLeft, Boolean in_app_download_key) {
        if (TextUtils.isEmpty(message) || !message.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            return;
        }
        String str = message.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r4.length - 1];
        pdfFileName.setText(str);
        Pair<Boolean, File> pairIsFileExist = isFileExist(context, str, isLeft, in_app_download_key.booleanValue());
        Log.e("TAG_APP", "bindPdfData:  isLeft " + isLeft + " getFirst " + pairIsFileExist.first + " fileStatus.getSecond() " + pairIsFileExist.second);
        downloadButton.setVisibility(((Boolean) pairIsFileExist.first).booleanValue() ? 8 : 0);
        if (((Boolean) pairIsFileExist.first).booleanValue() && ((File) pairIsFileExist.second).exists()) {
            try {
                thumbnail.setImageBitmap(SocketKt.generateImageFromPdf(context, FileProvider.getUriForFile(context, context.getPackageName() + ".provider", (File) pairIsFileExist.second)));
            } catch (IllegalArgumentException e2) {
                Log.e("FileProvider", "Invalid FileProvider URI for file: " + ((File) pairIsFileExist.second).getAbsolutePath(), e2);
            }
        }
    }
}
