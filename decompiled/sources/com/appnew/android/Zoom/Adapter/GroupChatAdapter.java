package com.appnew.android.Zoom.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Activity.PdfDetailScreen;
import com.appnew.android.Model.DoubtChatPojo;
import com.appnew.android.Model.PostFile;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Zoom.Activity.DoubtChatActivityFirebase;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
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
public class GroupChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Serializable {
    private static final String TAG = "LiveAdapter";
    public ArrayList<DoubtChatPojo> dataSet;
    public int i;
    private int lastselected;
    Context mContext;
    MediaPlayer mediaPlayer;
    private MyViewHolder tempHolder;
    private int templistPosition;
    private Timer timer;
    String type;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 0;
    }

    public GroupChatAdapter(Context context, ArrayList<DoubtChatPojo> dataSet) {
        this.mContext = context;
        this.dataSet = dataSet;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, int listPosition) {
        if (getItemViewType(listPosition) == 1) {
            setTransparentData((MyViewHolder2) holder1, listPosition);
        } else {
            setData((MyViewHolder) holder1, listPosition);
        }
    }

    public void updateList(DoubtChatPojo Data) {
        this.dataSet.add(Data);
        notifyDataSetChanged();
    }

    public void clearList() {
        this.dataSet.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doubt_recycler_chat_layout, parent, false));
    }

    public void upDateData(ArrayList<DoubtChatPojo> pinchatList) {
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
        TextView leftimagetime;
        TextView lefttexttime;
        TextView lefttexttimeUrl;
        TextView letfmessageTv;
        ImageView letfmessageTvimage;
        TextView pdfText_username;
        TextView pdfText_usernameLeft;
        LinearLayout pdfViewLeft;
        LinearLayout pdfViewRight;
        TextView pdf_timeLeft;
        TextView pdf_timeLeftPdf;
        RelativeLayout pdfdownloadLeft;
        ImageView reply_file_img;
        LinearLayout reply_file_ll;
        TextView reply_file_name;
        TextView rightimagettime;
        TextView rightmessage;
        ImageView rightmessageimage;
        TextView righttexttime;
        TextView righttexttimeAudio;
        TextView righttexttimePdf;
        TextView righttexttimeUrl;
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
            this.cvrLeft = (RelativeLayout) itemView.findViewById(R.id.cvrLeft);
            this.cvrRightpdf = (RelativeLayout) itemView.findViewById(R.id.cvrRightpdf);
            this.cvrLeftimage = (RelativeLayout) itemView.findViewById(R.id.cvrLeftimage);
            this.cvrRight = (RelativeLayout) itemView.findViewById(R.id.cvrRight);
            this.cvrRightimage = (RelativeLayout) itemView.findViewById(R.id.cvrRightimage);
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
            this.righttexttimePdf = (TextView) itemView.findViewById(R.id.righttexttimePdf);
            this.pdf_timeLeftPdf = (TextView) itemView.findViewById(R.id.pdf_timeLeftPdf);
            this.userNameright = (TextView) itemView.findViewById(R.id.userNameright);
            this.userNamerightimage = (TextView) itemView.findViewById(R.id.userNamerightimage);
            this.rightmessage = (TextView) itemView.findViewById(R.id.rightmessage);
            this.rightmessageimage = (ImageView) itemView.findViewById(R.id.rightmessageimage);
            this.cvrDownLoadRight = (RelativeLayout) itemView.findViewById(R.id.cvrDownLoadRight);
            this.righttexttime = (TextView) itemView.findViewById(R.id.righttexttime);
            this.rightimagettime = (TextView) itemView.findViewById(R.id.rightimagettime);
            this.righttexttimeUrl = (TextView) itemView.findViewById(R.id.righttexttimeUrl);
            this.lefttexttimeUrl = (TextView) itemView.findViewById(R.id.lefttexttimeUrl);
            this.userNamerightUrl = (TextView) itemView.findViewById(R.id.userNamerightUrl);
            this.userNameUrlLeft = (TextView) itemView.findViewById(R.id.userNameUrlLeft);
        }
    }

    public void setData(final MyViewHolder holder, final int listPosition) {
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
        holder.cvrRightimage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setData$0(listPosition, view);
            }
        });
        holder.cvrLeftimage.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setData$2(listPosition, view);
            }
        });
        holder.pdfViewLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setData$3(listPosition, view);
            }
        });
        holder.pdfViewRight.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setData$4(listPosition, view);
            }
        });
        if (this.dataSet.get(listPosition).getId().equals(SharedPreference.getInstance().getLoggedInUser().getId())) {
            if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("text")) {
                holder.cvrRight.setVisibility(0);
                holder.rightmessage.setText(this.dataSet.get(listPosition).getMessage().trim());
                holder.userNameright.setText(this.dataSet.get(listPosition).getName().trim());
                holder.righttexttime.setText(getdate(String.valueOf(this.dataSet.get(listPosition).getDate())));
                return;
            }
            if (this.dataSet.get(listPosition).getType().equalsIgnoreCase(Const.PDF)) {
                holder.cvrRightpdf.setVisibility(0);
                holder.cvrLeftpdf.setVisibility(8);
                holder.pdfText_username.setText(this.dataSet.get(listPosition).getName().trim());
                holder.righttexttimePdf.setText(getdate(String.valueOf(this.dataSet.get(listPosition).getDate())));
                holder.cvrDownLoadRight.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (Helper.isNetworkConnected(GroupChatAdapter.this.mContext)) {
                            GroupChatAdapter groupChatAdapter = GroupChatAdapter.this;
                            groupChatAdapter.ActivityInstanceDownload(groupChatAdapter.dataSet.get(listPosition).getMessage());
                        } else {
                            Helper.showInternetToast(GroupChatAdapter.this.mContext);
                        }
                    }
                });
                return;
            }
            if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("url")) {
                holder.cvrUrlRight.setVisibility(0);
                holder.cvrUrlLeft.setVisibility(8);
                holder.urlRightTv.setText(this.dataSet.get(listPosition).getMessage().trim());
                holder.urlRightTv.setText(this.dataSet.get(listPosition).getMessage().trim());
                Linkify.addLinks(holder.urlRightTv, 1);
                holder.userNamerightUrl.setText(this.dataSet.get(listPosition).getName().trim());
                holder.righttexttimeUrl.setText(getdate(String.valueOf(this.dataSet.get(listPosition).getDate())));
                return;
            }
            if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("audio")) {
                holder.cvrRightAudio.setVisibility(0);
                holder.cvrLeftAudio.setVisibility(8);
                holder.audioText_username.setText(this.dataSet.get(listPosition).getName().trim());
                holder.righttexttimeAudio.setText(getdate(String.valueOf(this.dataSet.get(listPosition).getDate())));
                holder.audioplay.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Helper.isNetworkConnected(GroupChatAdapter.this.mContext)) {
                            GroupChatAdapter.this.pauseAudio();
                            if (GroupChatAdapter.this.mediaPlayer == null) {
                                DoubtChatPojo doubtChatPojo = GroupChatAdapter.this.dataSet.get(listPosition);
                                doubtChatPojo.setIsplaying(true);
                                GroupChatAdapter.this.dataSet.set(listPosition, doubtChatPojo);
                                GroupChatAdapter.this.lastselected = listPosition;
                                GroupChatAdapter groupChatAdapter = GroupChatAdapter.this;
                                groupChatAdapter.notifyItemChanged(groupChatAdapter.lastselected);
                                GroupChatAdapter groupChatAdapter2 = GroupChatAdapter.this;
                                groupChatAdapter2.mediaPlayer = MediaPlayer.create(groupChatAdapter2.mContext, Uri.parse(GroupChatAdapter.this.dataSet.get(listPosition).getMessage()));
                                GroupChatAdapter.this.mediaPlayer.start();
                                GroupChatAdapter groupChatAdapter3 = GroupChatAdapter.this;
                                MyViewHolder myViewHolder = holder;
                                groupChatAdapter3.starttimer(myViewHolder, myViewHolder.audiopause, holder.audioplay, listPosition);
                                return;
                            }
                            if (GroupChatAdapter.this.mediaPlayer.isPlaying()) {
                                GroupChatAdapter.this.mediaPlayer.pause();
                                GroupChatAdapter.this.stoptimer();
                                DoubtChatPojo doubtChatPojo2 = GroupChatAdapter.this.dataSet.get(GroupChatAdapter.this.lastselected);
                                doubtChatPojo2.setIsplaying(false);
                                GroupChatAdapter.this.dataSet.set(GroupChatAdapter.this.lastselected, doubtChatPojo2);
                                DoubtChatPojo doubtChatPojo3 = GroupChatAdapter.this.dataSet.get(listPosition);
                                doubtChatPojo3.setIsplaying(true);
                                GroupChatAdapter.this.dataSet.set(listPosition, doubtChatPojo3);
                                GroupChatAdapter.this.lastselected = listPosition;
                                GroupChatAdapter groupChatAdapter4 = GroupChatAdapter.this;
                                groupChatAdapter4.notifyItemChanged(groupChatAdapter4.lastselected);
                                GroupChatAdapter groupChatAdapter5 = GroupChatAdapter.this;
                                groupChatAdapter5.mediaPlayer = MediaPlayer.create(groupChatAdapter5.mContext, Uri.parse(GroupChatAdapter.this.dataSet.get(listPosition).getMessage()));
                                GroupChatAdapter.this.mediaPlayer.start();
                                GroupChatAdapter groupChatAdapter6 = GroupChatAdapter.this;
                                MyViewHolder myViewHolder2 = holder;
                                groupChatAdapter6.starttimer(myViewHolder2, myViewHolder2.audiopause, holder.audioplay, listPosition);
                                return;
                            }
                            DoubtChatPojo doubtChatPojo4 = GroupChatAdapter.this.dataSet.get(listPosition);
                            doubtChatPojo4.setIsplaying(true);
                            GroupChatAdapter.this.dataSet.set(listPosition, doubtChatPojo4);
                            GroupChatAdapter.this.lastselected = listPosition;
                            GroupChatAdapter groupChatAdapter7 = GroupChatAdapter.this;
                            groupChatAdapter7.notifyItemChanged(groupChatAdapter7.lastselected);
                            GroupChatAdapter groupChatAdapter8 = GroupChatAdapter.this;
                            groupChatAdapter8.mediaPlayer = MediaPlayer.create(groupChatAdapter8.mContext, Uri.parse(GroupChatAdapter.this.dataSet.get(listPosition).getMessage()));
                            GroupChatAdapter.this.mediaPlayer.start();
                            GroupChatAdapter groupChatAdapter9 = GroupChatAdapter.this;
                            MyViewHolder myViewHolder3 = holder;
                            groupChatAdapter9.starttimer(myViewHolder3, myViewHolder3.audiopause, holder.audioplay, listPosition);
                            return;
                        }
                        Helper.showInternetToast(GroupChatAdapter.this.mContext);
                    }
                });
                holder.audiopause.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$setData$5(listPosition, view);
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
            holder.cvrRightimage.setVisibility(0);
            Glide.with(this.mContext.getApplicationContext()).load(this.dataSet.get(listPosition).getMessage().trim()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.default_pic)).into(holder.rightmessageimage);
            holder.userNamerightimage.setText(this.dataSet.get(listPosition).getName().trim());
            holder.rightimagettime.setText(getdate(String.valueOf(this.dataSet.get(listPosition).getDate())));
            return;
        }
        if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("text")) {
            holder.cvrLeft.setVisibility(0);
            holder.letfmessageTv.setText(this.dataSet.get(listPosition).getMessage().trim());
            holder.userName.setVisibility(0);
            holder.userName.setText(this.dataSet.get(listPosition).getName().trim());
            holder.lefttexttime.setText(getdate(String.valueOf(this.dataSet.get(listPosition).getDate())));
            return;
        }
        if (this.dataSet.get(listPosition).getType().equalsIgnoreCase(Const.PDF)) {
            holder.cvrRightpdf.setVisibility(8);
            holder.cvrLeftpdf.setVisibility(0);
            holder.pdfText_usernameLeft.setVisibility(0);
            holder.pdfText_usernameLeft.setText(this.dataSet.get(listPosition).getName().trim());
            holder.pdf_timeLeftPdf.setText(getdate(String.valueOf(this.dataSet.get(listPosition).getDate())));
            holder.pdfdownloadLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (Helper.isNetworkConnected(GroupChatAdapter.this.mContext)) {
                        GroupChatAdapter groupChatAdapter = GroupChatAdapter.this;
                        groupChatAdapter.ActivityInstanceDownload(groupChatAdapter.dataSet.get(listPosition).getMessage());
                    } else {
                        Helper.showInternetToast(GroupChatAdapter.this.mContext);
                    }
                }
            });
            return;
        }
        if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("url")) {
            holder.cvrUrlRight.setVisibility(8);
            holder.cvrUrlLeft.setVisibility(0);
            holder.urlLeftTv.setText(this.dataSet.get(listPosition).getMessage().trim());
            Linkify.addLinks(holder.urlLeftTv, 1);
            holder.userNameUrlLeft.setVisibility(0);
            holder.userNameUrlLeft.setText(this.dataSet.get(listPosition).getName().trim());
            holder.lefttexttimeUrl.setText(getdate(String.valueOf(this.dataSet.get(listPosition).getDate())));
            return;
        }
        if (this.dataSet.get(listPosition).getType().equalsIgnoreCase("audio")) {
            holder.cvrRightAudio.setVisibility(8);
            holder.cvrLeftAudio.setVisibility(0);
            holder.audioText_usernameLeft.setVisibility(0);
            holder.audioText_usernameLeft.setText(this.dataSet.get(listPosition).getName().trim());
            holder.audio_timeLeftAudio.setText(getdate(String.valueOf(this.dataSet.get(listPosition).getDate())));
            holder.audioplayLeft.setBackgroundTintList(ColorStateList.valueOf(this.mContext.getColor(R.color.white)));
            holder.audiopauseLeft.setBackgroundTintList(ColorStateList.valueOf(this.mContext.getColor(R.color.white)));
            holder.audioplayLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (Helper.isNetworkConnected(GroupChatAdapter.this.mContext)) {
                        GroupChatAdapter.this.pauseAudio();
                        if (GroupChatAdapter.this.mediaPlayer == null) {
                            DoubtChatPojo doubtChatPojo = GroupChatAdapter.this.dataSet.get(listPosition);
                            doubtChatPojo.setIsplaying(true);
                            GroupChatAdapter.this.dataSet.set(listPosition, doubtChatPojo);
                            GroupChatAdapter.this.lastselected = listPosition;
                            GroupChatAdapter groupChatAdapter = GroupChatAdapter.this;
                            groupChatAdapter.notifyItemChanged(groupChatAdapter.lastselected);
                            GroupChatAdapter groupChatAdapter2 = GroupChatAdapter.this;
                            groupChatAdapter2.mediaPlayer = MediaPlayer.create(groupChatAdapter2.mContext, Uri.parse(GroupChatAdapter.this.dataSet.get(listPosition).getMessage()));
                            GroupChatAdapter.this.mediaPlayer.start();
                            GroupChatAdapter groupChatAdapter3 = GroupChatAdapter.this;
                            MyViewHolder myViewHolder = holder;
                            groupChatAdapter3.starttimer(myViewHolder, myViewHolder.audiopause, holder.audioplay, listPosition);
                            return;
                        }
                        if (GroupChatAdapter.this.mediaPlayer.isPlaying()) {
                            GroupChatAdapter.this.mediaPlayer.pause();
                            GroupChatAdapter groupChatAdapter4 = GroupChatAdapter.this;
                            groupChatAdapter4.notifyItemChanged(groupChatAdapter4.lastselected);
                            GroupChatAdapter.this.stoptimer();
                            DoubtChatPojo doubtChatPojo2 = GroupChatAdapter.this.dataSet.get(GroupChatAdapter.this.lastselected);
                            doubtChatPojo2.setIsplaying(false);
                            GroupChatAdapter.this.dataSet.set(GroupChatAdapter.this.lastselected, doubtChatPojo2);
                            DoubtChatPojo doubtChatPojo3 = GroupChatAdapter.this.dataSet.get(listPosition);
                            doubtChatPojo3.setIsplaying(true);
                            GroupChatAdapter.this.dataSet.set(listPosition, doubtChatPojo3);
                            GroupChatAdapter.this.lastselected = listPosition;
                            GroupChatAdapter groupChatAdapter5 = GroupChatAdapter.this;
                            groupChatAdapter5.notifyItemChanged(groupChatAdapter5.lastselected);
                            GroupChatAdapter groupChatAdapter6 = GroupChatAdapter.this;
                            groupChatAdapter6.mediaPlayer = MediaPlayer.create(groupChatAdapter6.mContext, Uri.parse(GroupChatAdapter.this.dataSet.get(listPosition).getMessage()));
                            GroupChatAdapter.this.mediaPlayer.start();
                            GroupChatAdapter groupChatAdapter7 = GroupChatAdapter.this;
                            MyViewHolder myViewHolder2 = holder;
                            groupChatAdapter7.starttimer(myViewHolder2, myViewHolder2.audiopause, holder.audioplay, listPosition);
                            return;
                        }
                        DoubtChatPojo doubtChatPojo4 = GroupChatAdapter.this.dataSet.get(listPosition);
                        doubtChatPojo4.setIsplaying(true);
                        GroupChatAdapter.this.dataSet.set(listPosition, doubtChatPojo4);
                        GroupChatAdapter.this.lastselected = listPosition;
                        GroupChatAdapter groupChatAdapter8 = GroupChatAdapter.this;
                        groupChatAdapter8.notifyItemChanged(groupChatAdapter8.lastselected);
                        GroupChatAdapter groupChatAdapter9 = GroupChatAdapter.this;
                        groupChatAdapter9.mediaPlayer = MediaPlayer.create(groupChatAdapter9.mContext, Uri.parse(GroupChatAdapter.this.dataSet.get(listPosition).getMessage()));
                        GroupChatAdapter.this.mediaPlayer.start();
                        GroupChatAdapter groupChatAdapter10 = GroupChatAdapter.this;
                        MyViewHolder myViewHolder3 = holder;
                        groupChatAdapter10.starttimer(myViewHolder3, myViewHolder3.audiopause, holder.audioplay, listPosition);
                        return;
                    }
                    Helper.showInternetToast(GroupChatAdapter.this.mContext);
                }
            });
            holder.audiopauseLeft.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GroupChatAdapter.this.stoptimer();
                    DoubtChatPojo doubtChatPojo = GroupChatAdapter.this.dataSet.get(listPosition);
                    doubtChatPojo.setIsplaying(false);
                    GroupChatAdapter.this.dataSet.set(listPosition, doubtChatPojo);
                    GroupChatAdapter.this.notifyItemChanged(listPosition);
                    GroupChatAdapter.this.mediaPlayer.pause();
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
        Glide.with(this.mContext.getApplicationContext()).load(this.dataSet.get(listPosition).getMessage().trim()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.default_pic)).into(holder.letfmessageTvimage);
        holder.userNameimage.setVisibility(0);
        holder.userNameimage.setText(this.dataSet.get(listPosition).getName().trim());
        holder.leftimagetime.setText(getdate(String.valueOf(this.dataSet.get(listPosition).getDate())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$0(int i, View view) {
        pauseAudio();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        View viewInflate = ((Activity) this.mContext).getLayoutInflater().inflate(R.layout.image_layout, (ViewGroup) null);
        builder.setView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.cancel);
        if (!this.dataSet.get(i).getMessage().equals("")) {
            Glide.with(this.mContext.getApplicationContext()).load(this.dataSet.get(i).getMessage().replaceAll(" ", "%20")).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.color.colorPrimary).error(R.color.colorPrimary).diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate()).into(imageView);
        } else {
            imageView.setImageResource(com.appnew.android.R.drawable.profile_grey);
        }
        final AlertDialog alertDialogShow = builder.show();
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                alertDialogShow.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$2(int i, View view) {
        pauseAudio();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        View viewInflate = ((Activity) this.mContext).getLayoutInflater().inflate(R.layout.image_layout, (ViewGroup) null);
        builder.setView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.cancel);
        if (!this.dataSet.get(i).getMessage().equals("")) {
            Glide.with(this.mContext.getApplicationContext()).load(this.dataSet.get(i).getMessage().replaceAll(" ", "%20")).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.color.colorPrimary).error(R.color.colorPrimary).diskCacheStrategy(DiskCacheStrategy.DATA).dontAnimate()).into(imageView);
        } else {
            imageView.setImageResource(com.appnew.android.R.drawable.profile_grey);
        }
        final AlertDialog alertDialogShow = builder.show();
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                alertDialogShow.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$3(int i, View view) {
        pauseAudio();
        if (Helper.isNetworkConnected(this.mContext)) {
            Intent intent = new Intent(this.mContext, (Class<?>) PdfDetailScreen.class);
            intent.putExtra("url", this.dataSet.get(i).getMessage());
            intent.putExtra("from", "GroupChatAdapter");
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
            intent.putExtra("from", "GroupChatAdapter");
            this.mContext.startActivity(intent);
            return;
        }
        Helper.showInternetToast(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$5(int i, View view) {
        stoptimer();
        DoubtChatPojo doubtChatPojo = this.dataSet.get(i);
        doubtChatPojo.setIsplaying(false);
        this.dataSet.set(i, doubtChatPojo);
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mediaPlayer.pause();
        }
        notifyItemChanged(i);
    }

    public void pauseAudio() {
        if (this.tempHolder != null) {
            stoptimer();
            DoubtChatPojo doubtChatPojo = this.dataSet.get(this.templistPosition);
            doubtChatPojo.setIsplaying(false);
            this.dataSet.set(this.templistPosition, doubtChatPojo);
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
    public void ActivityInstanceDownload(String data) {
        final PostFile postFile = new PostFile();
        postFile.setLink(data);
        postFile.setFile_type(Const.PDF);
        String str = data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1];
        if (!str.contains(" ")) {
            postFile.setFile_info(data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1]);
        } else {
            postFile.setFile_info(str.replaceAll(" ", "_"));
        }
        try {
            Dexter.withContext(this.mContext).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter.7
                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionsChecked(MultiplePermissionsReport report) {
                    if (Helper.getStorageInstance(GroupChatAdapter.this.mContext).getRecordObject(Const.PDF) != null) {
                        Helper.DownloadfilefromURL((DoubtChatActivityFirebase) GroupChatAdapter.this.mContext, (PostFile) Helper.getStorageInstance(GroupChatAdapter.this.mContext).getRecordObject(Const.PDF));
                        Helper.getStorageInstance(GroupChatAdapter.this.mContext).deleteRecord(Const.PDF);
                        return;
                    }
                    Helper.DownloadfilefromURL((DoubtChatActivityFirebase) GroupChatAdapter.this.mContext, postFile);
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
        if (!this.dataSet.get(listPosition).getProfile_picture().equals("")) {
            Glide.with(this.mContext.getApplicationContext()).load(this.dataSet.get(listPosition).getProfile_picture()).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.default_pic)).into(holder.ivAdmin);
        } else {
            holder.ivAdmin.setImageResource(R.mipmap.default_pic);
        }
        holder.llAdmin.setVisibility(0);
        holder.tvAdmin.setText(this.dataSet.get(listPosition).getMessage());
        holder.tv_username.setText(this.dataSet.get(listPosition).getName());
        holder.tv_time.setText(String.valueOf(this.dataSet.get(listPosition).getDate()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataSet.size();
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
        timer.schedule(new TimerTask() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter.8
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ((Activity) GroupChatAdapter.this.mContext).runOnUiThread(new Runnable() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GroupChatAdapter.this.timer == null || GroupChatAdapter.this.mediaPlayer.isPlaying()) {
                            return;
                        }
                        GroupChatAdapter.this.stoptimer();
                        DoubtChatPojo doubtChatPojo = GroupChatAdapter.this.dataSet.get(listPosition);
                        doubtChatPojo.setIsplaying(false);
                        GroupChatAdapter.this.dataSet.set(listPosition, doubtChatPojo);
                        GroupChatAdapter.this.notifyItemChanged(GroupChatAdapter.this.lastselected);
                    }
                });
            }
        }, 0L, 1000L);
    }

    public void starttimer2(final MyViewHolder2 holder, final Button pauser, final Button play, final int listPosition) {
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(new TimerTask() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter.9
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ((Activity) GroupChatAdapter.this.mContext).runOnUiThread(new Runnable() { // from class: com.appnew.android.Zoom.Adapter.GroupChatAdapter.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GroupChatAdapter.this.timer == null) {
                            return;
                        }
                        if (GroupChatAdapter.this.mediaPlayer.isPlaying()) {
                            int i = GroupChatAdapter.this.i;
                            return;
                        }
                        GroupChatAdapter.this.stoptimer();
                        DoubtChatPojo doubtChatPojo = GroupChatAdapter.this.dataSet.get(listPosition);
                        doubtChatPojo.setIsplaying(false);
                        GroupChatAdapter.this.dataSet.set(listPosition, doubtChatPojo);
                        GroupChatAdapter.this.notifyItemChanged(GroupChatAdapter.this.lastselected);
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
}
