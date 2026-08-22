package com.appnew.android.Download.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.DownloadVideoPlayer;
import com.appnew.android.Download.Interface.onItemClick;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.VideosDownload;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadVideoAdapter extends RecyclerView.Adapter<StreamHolder> {
    BottomSetting bottomSetting;
    Context context;
    private boolean delete_check = false;
    private List<VideosDownload> download_videos;
    private onItemClick onclick;
    ThemeSettings themeSettings;
    public UtkashRoom utkashRoom;

    public DownloadVideoAdapter(Context context, List<VideosDownload> download_videos, onItemClick onclick) {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.context = context;
        this.download_videos = download_videos;
        this.onclick = onclick;
        ThemeSettings themeSettingsData = appDatabase.getthemeSettingdao().data();
        this.themeSettings = themeSettingsData;
        if (themeSettingsData != null) {
            this.themeSettings = this.utkashRoom.getthemeSettingdao().data();
            this.bottomSetting = (BottomSetting) new Gson().fromJson(this.themeSettings.getBottom(), BottomSetting.class);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public StreamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StreamHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.download_adpter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final StreamHolder holder, final int position) {
        holder.cancel_progress_layout.setVisibility(0);
        holder.video_time.setVisibility(0);
        holder.pauseLayout.setVisibility(0);
        try {
            setThumbRatio(holder.rlThumb);
            Glide.with(holder.courseImage).load(this.download_videos.get(position).getThumbnail_url()).placeholder(setThumbAccordingRatio() ? R.mipmap.square_placeholder : R.mipmap.square_placeholder_new).into(holder.courseImage);
            if (this.delete_check) {
                holder.file_mb.setText(this.download_videos.get(holder.getAbsoluteAdapterPosition()).getLengthInMb().equalsIgnoreCase("0 B") ? "" : this.download_videos.get(holder.getAbsoluteAdapterPosition()).getLengthInMb());
                if (this.download_videos.get(holder.getAbsoluteAdapterPosition()).getIs_complete().equalsIgnoreCase("1")) {
                    if (this.download_videos.get(holder.getAbsoluteAdapterPosition()).getIs_selected() != null && this.download_videos.get(holder.getAbsoluteAdapterPosition()).getIs_selected().equalsIgnoreCase("1")) {
                        holder.selected_video.setChecked(true);
                    } else {
                        holder.selected_video.setChecked(false);
                    }
                    holder.delete_layout.setVisibility(0);
                } else {
                    holder.delete_layout.setVisibility(0);
                }
            } else {
                holder.delete_layout.setVisibility(8);
            }
            holder.selected_video.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.Download.Adapter.DownloadVideoAdapter.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        ((VideosDownload) DownloadVideoAdapter.this.download_videos.get(holder.getAbsoluteAdapterPosition())).setIs_selected("1");
                    } else {
                        ((VideosDownload) DownloadVideoAdapter.this.download_videos.get(holder.getAbsoluteAdapterPosition())).setIs_selected("0");
                    }
                    ((DownloadActivity) DownloadVideoAdapter.this.context).visibleSelectButton(DownloadVideoAdapter.this.download_videos);
                }
            });
            holder.video_name.setText(this.download_videos.get(holder.getAbsoluteAdapterPosition()).getVideo_name());
            if (this.download_videos.get(holder.getAbsoluteAdapterPosition()).getVideotime() != null && !this.download_videos.get(holder.getAbsoluteAdapterPosition()).getVideotime().equalsIgnoreCase("")) {
                holder.video_time.setVisibility(8);
                holder.video_time.setText(this.context.getResources().getString(R.string.video__) + this.download_videos.get(holder.getAbsoluteAdapterPosition()).getVideotime());
            } else {
                holder.video_time.setVisibility(8);
            }
            if (this.download_videos.get(holder.getAbsoluteAdapterPosition()).getMp4_download_url() == null || this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() == 100) {
                if (this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() == 100) {
                    holder.pauseLayout.setVisibility(8);
                    holder.cancel_progress_layout.setVisibility(8);
                    holder.download_icon.setVisibility(0);
                    holder.download_icon.setImageResource(R.drawable.play_icon);
                } else {
                    holder.loadingProgress.setProgress(0);
                    holder.loadingProgress.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.circular_progess));
                    holder.percentageTxt.setText(this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() + "%");
                    holder.cancel_progress_layout.setVisibility(0);
                    holder.pauseLayout.setVisibility(8);
                    holder.download_icon.setVisibility(8);
                }
            } else if (this.download_videos.get(holder.getAbsoluteAdapterPosition()).getVideo_status().equalsIgnoreCase("Downloading Running")) {
                holder.pauseLayout.setVisibility(0);
                holder.download_icon.setVisibility(8);
                holder.cancel_progress_layout.setVisibility(0);
                holder.optionPauseImgView.setImageResource(R.drawable.ic_video_download_pause);
                holder.pauseTextView.setText(this.context.getResources().getString(R.string.downloading_running));
                if (this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() > 0 && this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() < 100) {
                    holder.loadingProgress.setProgress(this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage());
                    holder.loadingProgress.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.circular_progess));
                    holder.percentageTxt.setText(this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() + "%");
                } else if (this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() == 0) {
                    holder.loadingProgress.setProgress(0);
                    holder.loadingProgress.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.circular_progess));
                    holder.percentageTxt.setText(this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() + "%");
                }
            } else if (this.download_videos.get(holder.getAbsoluteAdapterPosition()).getVideo_status().equalsIgnoreCase("Downloading Pause")) {
                holder.cancel_progress_layout.setVisibility(0);
                holder.download_icon.setVisibility(8);
                holder.pauseLayout.setVisibility(0);
                holder.optionPauseImgView.setImageResource(R.drawable.download_icon);
                holder.pauseTextView.setText(this.context.getResources().getString(R.string.downloading_pause));
                if (this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() >= 0 && this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() < 100) {
                    holder.loadingProgress.setProgress(this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage());
                    holder.loadingProgress.setProgressDrawable(this.context.getResources().getDrawable(R.drawable.circular_progess));
                    holder.percentageTxt.setText(this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() + "%");
                }
            } else if (this.download_videos.get(holder.getAbsoluteAdapterPosition()).getPercentage() == 100) {
                holder.pauseLayout.setVisibility(8);
                holder.cancel_progress_layout.setVisibility(8);
                holder.download_icon.setVisibility(0);
                holder.download_icon.setImageResource(R.drawable.play_icon);
            }
            holder.optionPauseImgView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.Adapter.DownloadVideoAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onBindViewHolder$0(holder);
                }
            }));
            holder.pauseLayout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.Adapter.DownloadVideoAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onBindViewHolder$1(holder);
                }
            }));
            holder.cancel_progress_layout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.Adapter.DownloadVideoAdapter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onBindViewHolder$4(position);
                }
            }));
            holder.study_single_itemLL.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.Adapter.DownloadVideoAdapter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onBindViewHolder$5(holder);
                }
            }));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(StreamHolder streamHolder) {
        if (this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getPercentage() != 100) {
            if (!Helper.isConnected(this.context)) {
                Context context = this.context;
                Toast.makeText(context, context.getResources().getString(R.string.no_internet_connection), 0).show();
                return null;
            }
            if (this.onclick != null) {
                if (this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_status().equalsIgnoreCase("Downloading Running")) {
                    if (VideoDownloadService.isServiceRunning && VideoDownloadService.video_id.equalsIgnoreCase(this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id())) {
                        this.onclick.OnVideoClick(streamHolder.getAbsoluteAdapterPosition(), this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()), VideoDownloadService.PAUSE);
                    } else {
                        Snackbar.make(streamHolder.optionPauseImgView, this.context.getResources().getString(R.string.only_downloading_video_is_pause), -1).show();
                    }
                } else if (this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_status().equalsIgnoreCase("Downloading Pause")) {
                    this.onclick.OnVideoClick(streamHolder.getAbsoluteAdapterPosition(), this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()), "play");
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$1(StreamHolder streamHolder) {
        if (this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getPercentage() != 100) {
            if (!Helper.isConnected(this.context)) {
                Context context = this.context;
                Toast.makeText(context, context.getResources().getString(R.string.no_internet_connection), 0).show();
                return null;
            }
            if (this.onclick != null) {
                if (this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_status().equalsIgnoreCase("Downloading Running")) {
                    this.onclick.OnVideoClick(streamHolder.getAbsoluteAdapterPosition(), this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()), VideoDownloadService.PAUSE);
                }
                if (this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_status().equalsIgnoreCase("Downloading Pause")) {
                    this.onclick.OnVideoClick(streamHolder.getAbsoluteAdapterPosition(), this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()), "play");
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$4(final int i) {
        if (this.onclick != null) {
            if (!Helper.isConnected(this.context)) {
                Context context = this.context;
                Toast.makeText(context, context.getResources().getString(R.string.no_internet_connection), 0).show();
                return null;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle(this.context.getResources().getString(R.string.download_video));
            builder.setMessage(this.context.getResources().getString(R.string.do_you_want_to_delete_this_video));
            builder.setNegativeButton(this.context.getResources().getString(R.string.no), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Download.Adapter.DownloadVideoAdapter$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            builder.setPositiveButton(this.context.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() { // from class: com.appnew.android.Download.Adapter.DownloadVideoAdapter$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onBindViewHolder$3(i, dialogInterface, i2);
                }
            });
            builder.create().show();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$3(int i, DialogInterface dialogInterface, int i2) {
        try {
            if (this.download_videos.get(i) != null && this.download_videos.get(i).getPercentage() != 100) {
                this.onclick.OnVideoClick(i, this.download_videos.get(i), VideoDownloadService.CANCEL);
            } else {
                Context context = this.context;
                Toast.makeText(context, context.getResources().getString(R.string.video_is_downloaded), 0).show();
            }
        } catch (Exception e2) {
            try {
                if (this.download_videos.get(i) != null && this.download_videos.get(i).getPercentage() != 100) {
                    this.onclick.OnVideoClick(i, this.download_videos.get(i), VideoDownloadService.CANCEL);
                } else {
                    Context context2 = this.context;
                    Toast.makeText(context2, context2.getResources().getString(R.string.video_is_downloaded), 0).show();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            e2.printStackTrace();
        }
        dialogInterface.dismiss();
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$5(StreamHolder streamHolder) {
        if (this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getPercentage() == 100) {
            File file = new File(this.context.getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_history() + ".mp4");
            File file2 = new File(this.context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_history() + ".mp4");
            if (file.exists()) {
                Intent intent = new Intent(this.context, (Class<?>) DownloadVideoPlayer.class);
                intent.putExtra("video_name", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name());
                intent.putExtra(Const.VIDEO_ID, this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id());
                intent.putExtra("current_pos", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideoCurrentPosition());
                intent.putExtra("video", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_history());
                intent.putExtra("video_time", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideotime());
                intent.putExtra("course_id", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id());
                intent.putExtra("vdc_id", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVdcId());
                intent.putExtra(Const.remaining_time, this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getRemaining_time());
                intent.putExtra("is_limited", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getIs_limited());
                intent.putExtra(Const.VIDEO_TYPE, this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_type());
                this.context.startActivity(intent);
                return null;
            }
            if (file2.exists()) {
                Intent intent2 = new Intent(this.context, (Class<?>) DownloadVideoPlayer.class);
                intent2.putExtra("video_name", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name());
                intent2.putExtra(Const.VIDEO_ID, this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id());
                intent2.putExtra("current_pos", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideoCurrentPosition());
                intent2.putExtra("video", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_history());
                intent2.putExtra("video_time", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideotime());
                intent2.putExtra("course_id", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getCourse_id());
                intent2.putExtra("vdc_id", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVdcId());
                intent2.putExtra(Const.remaining_time, this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getRemaining_time());
                intent2.putExtra("is_limited", this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getIs_limited());
                intent2.putExtra(Const.VIDEO_TYPE, this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_type());
                this.context.startActivity(intent2);
                return null;
            }
            File file3 = new File(this.context.getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADING_VIDEOS + this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_history() + ".mp4");
            File file4 = new File(this.context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + VideoDownloadService.DOWNLOADED_VIDEOS + this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_history() + ".mp4");
            if (file3.exists()) {
                file3.delete();
                ((DownloadActivity) this.context).utkashRoom.getvideoDownloadao().delete_viavideoid(this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), MakeMyExam.userId);
                this.download_videos.remove(streamHolder.getAbsoluteAdapterPosition());
                return null;
            }
            if (!file4.exists()) {
                return null;
            }
            file4.delete();
            ((DownloadActivity) this.context).utkashRoom.getvideoDownloadao().delete_viavideoid(this.download_videos.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id(), MakeMyExam.userId);
            this.download_videos.remove(streamHolder.getAbsoluteAdapterPosition());
            return null;
        }
        Toast.makeText(this.context, "Video is Currently Downloading...", 0).show();
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<VideosDownload> list = this.download_videos;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.download_videos.size();
    }

    public void visible_layout(boolean delete_check, List<VideosDownload> download_videos) {
        try {
            this.delete_check = delete_check;
            if (!delete_check) {
                this.download_videos = download_videos;
            }
            notifyDataSetChanged();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private void setThumbRatio(RelativeLayout rlThum) {
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        ViewGroup.LayoutParams layoutParams = rlThum.getLayoutParams();
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting == null || bottomSetting.getLayout_type() == null || !this.bottomSetting.getLayout_type().equals("1")) {
            return;
        }
        layoutParams.height = (int) (Helper.grideHeight * displayMetrics.scaledDensity);
        layoutParams.width = (int) (Helper.grideWidth * displayMetrics.scaledDensity);
        rlThum.setLayoutParams(layoutParams);
    }

    private boolean setThumbAccordingRatio() {
        BottomSetting bottomSetting = this.bottomSetting;
        return (bottomSetting == null || bottomSetting.getLayout_type() == null || !this.bottomSetting.getLayout_type().equals("1")) ? false : true;
    }

    public void notifydata(List<VideosDownload> download_videos) {
        try {
            this.download_videos = download_videos;
            this.delete_check = false;
            notifyDataSetChanged();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public class StreamHolder extends RecyclerView.ViewHolder {
        RelativeLayout cancel_progress_layout;
        ImageView courseImage;
        RelativeLayout delete_layout;
        ImageView download_icon;
        TextView file_mb;
        ProgressBar loadingProgress;
        ImageView optionPauseImgView;
        RelativeLayout pauseLayout;
        TextView pauseTextView;
        TextView percentageTxt;
        RelativeLayout rlThumb;
        CheckBox selected_video;
        LinearLayout study_single_itemLL;
        TextView video_name;
        TextView video_time;

        public StreamHolder(View itemView) {
            super(itemView);
            this.rlThumb = (RelativeLayout) itemView.findViewById(R.id.rlThumb);
            this.video_time = (TextView) itemView.findViewById(R.id.video_time);
            this.file_mb = (TextView) itemView.findViewById(R.id.file_mb);
            this.selected_video = (CheckBox) itemView.findViewById(R.id.check_box);
            this.delete_layout = (RelativeLayout) itemView.findViewById(R.id.delete_layout);
            this.loadingProgress = (ProgressBar) itemView.findViewById(R.id.loadingProgress);
            this.percentageTxt = (TextView) itemView.findViewById(R.id.percentageTxt);
            this.download_icon = (ImageView) itemView.findViewById(R.id.download_icon);
            this.cancel_progress_layout = (RelativeLayout) itemView.findViewById(R.id.cancel_progress_layout);
            this.video_name = (TextView) itemView.findViewById(R.id.video_name);
            this.courseImage = (ImageView) itemView.findViewById(R.id.courseImage);
            this.pauseLayout = (RelativeLayout) itemView.findViewById(R.id.pauseLayout);
            this.pauseTextView = (TextView) itemView.findViewById(R.id.pauseTextView);
            this.optionPauseImgView = (ImageView) itemView.findViewById(R.id.optionPauseImgView);
            this.study_single_itemLL = (LinearLayout) itemView.findViewById(R.id.study_single_itemLL);
        }
    }
}
