package com.appnew.android.Download.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Download.DownloadActivity;
import com.appnew.android.Download.Interface.onItemClick;
import com.appnew.android.DownloadServices.VideoDownloadService;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.Model.Video;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.player.AudioPlayerActivity;
import com.appnew.android.player.music_player.MusicService;
import com.appnew.android.table.ThemeSettings;
import com.appnew.android.table.VideosDownload;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadAudioAdapter extends RecyclerView.Adapter<StreamHolder> {
    BottomSetting bottomSetting;
    Context context;
    private boolean delete_check = false;
    private List<VideosDownload> download_audios;
    private onItemClick onclick;
    ThemeSettings themeSettings;
    public UtkashRoom utkashRoom;

    public DownloadAudioAdapter(Context context, List<VideosDownload> download_audios, onItemClick onclick) {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        this.utkashRoom = appDatabase;
        this.context = context;
        this.download_audios = download_audios;
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
        return new StreamHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.download_audio_adapter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final StreamHolder holder, final int position) {
        try {
            setThumbRatio(holder.rlThumb);
            holder.cancel_progress_layout.setVisibility(0);
            holder.video_name.setText(this.download_audios.get(holder.getAbsoluteAdapterPosition()).getVideo_name());
            String thumbnail_url = this.download_audios.get(holder.getAbsoluteAdapterPosition()).getThumbnail_url();
            int i = R.mipmap.square_placeholder;
            if (thumbnail_url != null && !this.download_audios.get(holder.getAbsoluteAdapterPosition()).getThumbnail_url().equalsIgnoreCase("")) {
                RequestBuilder<Drawable> requestBuilderLoad = Glide.with(holder.courseImage).load(this.download_audios.get(position).getThumbnail_url());
                if (!setThumbAccordingRatio()) {
                    i = R.mipmap.square_placeholder_new;
                }
                requestBuilderLoad.placeholder(i).into(holder.courseImage);
            } else {
                ImageView imageView = holder.courseImage;
                if (!setThumbAccordingRatio()) {
                    i = R.mipmap.square_placeholder_new;
                }
                imageView.setImageResource(i);
            }
            if (MusicService.INSTANCE.isAudioPlaying() && MusicService.INSTANCE.getVideoid().equalsIgnoreCase(this.download_audios.get(holder.getAbsoluteAdapterPosition()).getVideo_id())) {
                holder.percentageTxt.setText(this.context.getResources().getString(R.string.stop));
            } else {
                holder.percentageTxt.setText(this.context.getResources().getString(R.string.play));
            }
            holder.cancel_progress_layout.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Download.Adapter.DownloadAudioAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onBindViewHolder$0(holder);
                }
            }));
            holder.selected_video.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.appnew.android.Download.Adapter.DownloadAudioAdapter.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        ((VideosDownload) DownloadAudioAdapter.this.download_audios.get(holder.getAbsoluteAdapterPosition())).setIs_selected("1");
                    } else {
                        ((VideosDownload) DownloadAudioAdapter.this.download_audios.get(holder.getAbsoluteAdapterPosition())).setIs_selected("0");
                    }
                    ((DownloadActivity) DownloadAudioAdapter.this.context).visibleSelectButton(DownloadAudioAdapter.this.download_audios);
                }
            });
            if (this.delete_check) {
                holder.file_mb.setText("Select");
                if (this.download_audios.get(holder.getAbsoluteAdapterPosition()).getIs_selected() != null && this.download_audios.get(holder.getAbsoluteAdapterPosition()).getIs_selected().equalsIgnoreCase("1")) {
                    holder.selected_video.setChecked(true);
                } else {
                    holder.selected_video.setChecked(false);
                }
                holder.delete_layout.setVisibility(0);
                return;
            }
            holder.delete_layout.setVisibility(8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(StreamHolder streamHolder) {
        if (MusicService.INSTANCE.isAudioPlaying()) {
            Intent intent = new Intent(this.context, (Class<?>) MusicService.class);
            intent.setAction("Stop_Service");
            intent.putExtra("isRefresh", false);
            this.context.startService(intent);
        }
        if (streamHolder.percentageTxt.getText().equals(this.context.getResources().getString(R.string.play))) {
            if (TextUtils.isEmpty(this.download_audios.get(streamHolder.getAbsoluteAdapterPosition()).getMp4_download_url()) && TextUtils.isEmpty(this.download_audios.get(streamHolder.getAbsoluteAdapterPosition()).getMp4_download_url())) {
                Context context = this.context;
                Toast.makeText(context, context.getResources().getString(R.string.no_audio_found), 0).show();
            } else {
                streamHolder.percentageTxt.setText(this.context.getResources().getString(R.string.stop));
                File file = new File(this.context.getFilesDir().getAbsolutePath() + VideoDownloadService.DOWNLOADED_AUDIOS + this.download_audios.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_history() + ".mp3");
                if (file.exists()) {
                    Intent intent2 = new Intent(this.context, (Class<?>) AudioPlayerActivity.class);
                    Video video = new Video();
                    video.setFile_url(file.getPath());
                    video.setTitle(this.download_audios.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_name());
                    video.setThumbnail_url(this.download_audios.get(streamHolder.getAbsoluteAdapterPosition()).getThumbnail_url());
                    video.setId(this.download_audios.get(streamHolder.getAbsoluteAdapterPosition()).getVideo_id());
                    intent2.putExtra("video", video);
                    this.context.startActivity(intent2);
                }
            }
        } else {
            streamHolder.percentageTxt.setText(this.context.getResources().getString(R.string.play));
        }
        notifyDataSetChanged();
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<VideosDownload> list = this.download_audios;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.download_audios.size();
    }

    public void visible_layout(boolean delete_check, ArrayList<VideosDownload> download_audios) {
        this.delete_check = delete_check;
        notifyDataSetChanged();
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

    public void notifydata(List<VideosDownload> download_audios) {
        this.download_audios = download_audios;
        this.delete_check = false;
        notifyDataSetChanged();
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
