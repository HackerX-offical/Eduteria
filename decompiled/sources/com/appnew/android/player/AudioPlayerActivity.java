package com.appnew.android.player;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.appnew.android.Model.Video;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.player.music_player.MusicService;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class AudioPlayerActivity extends AppCompatActivity {
    private ImageView audioImage;
    private ImageView backwardbtn;
    private TextView courseName;
    private TextView exo_playback_speed;
    private ImageView forwardbtn;
    private Handler handler;
    private ImageView image_back;
    private MediaPlayer mediaPlayer;
    private ImageView pausebtn;
    private ImageView playbtn;
    private TextView songName;
    private SeekBar songPrgs;
    private TextView songTime;
    private TextView startTime;
    private TextView toolbarTitleTV;
    Video videodata;
    private int oneTime = 0;
    private int sTime = 0;
    private int endTime = 0;
    private int forwardTime = 10000;
    private int backwardTime = 10000;
    private Handler hdlr = new Handler();
    private String url = "";
    private String playerSpeed = Const.Normal;
    private final Runnable UpdateSongTime = new Runnable() { // from class: com.appnew.android.player.AudioPlayerActivity.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                AudioPlayerActivity audioPlayerActivity = AudioPlayerActivity.this;
                audioPlayerActivity.sTime = audioPlayerActivity.mediaPlayer.getCurrentPosition();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String strValueOf = String.valueOf(TimeUnit.MILLISECONDS.toMinutes(AudioPlayerActivity.this.sTime));
            String strValueOf2 = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(AudioPlayerActivity.this.sTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(AudioPlayerActivity.this.sTime)));
            TextView textView = AudioPlayerActivity.this.startTime;
            StringBuilder sb = new StringBuilder();
            if (strValueOf.length() <= 1) {
                strValueOf = "0" + strValueOf;
            }
            StringBuilder sbAppend = sb.append(strValueOf).append(" : ");
            if (strValueOf2.length() <= 1) {
                strValueOf2 = "0" + strValueOf2;
            }
            textView.setText(sbAppend.append(strValueOf2).toString());
            AudioPlayerActivity.this.songPrgs.setProgress(AudioPlayerActivity.this.sTime);
            AudioPlayerActivity.this.hdlr.postDelayed(this, 100L);
        }
    };
    private BroadcastReceiver musicServiceReceiver = new BroadcastReceiver() { // from class: com.appnew.android.player.AudioPlayerActivity.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("result", false);
            boolean booleanExtra2 = intent.getBooleanExtra("CLOSE_MUSIC_PLAYER", false);
            if (booleanExtra) {
                int intExtra = intent.getIntExtra(MusicService.VIDEO_POS, 0);
                if (AudioPlayerActivity.this.mediaPlayer != null) {
                    AudioPlayerActivity.this.mediaPlayer.seekTo(intExtra);
                    AudioPlayerActivity.this.mediaPlayer.start();
                    AudioPlayerActivity.this.playbtn.setImageResource(R.drawable.ic_baseline_pause_24);
                }
                if (booleanExtra2) {
                    AudioPlayerActivity.this.finish();
                }
            }
        }
    };

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);
        this.backwardbtn = (ImageView) findViewById(R.id.btnBackward);
        this.forwardbtn = (ImageView) findViewById(R.id.btnForward);
        this.playbtn = (ImageView) findViewById(R.id.btnPlay);
        this.audioImage = (ImageView) findViewById(R.id.audioImage);
        this.image_back = (ImageView) findViewById(R.id.appbar).findViewById(R.id.image_back);
        this.toolbarTitleTV = (TextView) findViewById(R.id.appbar).findViewById(R.id.toolbarTitleTV);
        this.songName = (TextView) findViewById(R.id.songName);
        this.courseName = (TextView) findViewById(R.id.txtSname);
        this.songPrgs = (SeekBar) findViewById(R.id.sBar);
        this.startTime = (TextView) findViewById(R.id.txtStartTime);
        this.songTime = (TextView) findViewById(R.id.txtSongTime);
        this.exo_playback_speed = (TextView) findViewById(R.id.exo_playback_speed);
        this.songPrgs = (SeekBar) findViewById(R.id.sBar);
        this.toolbarTitleTV.setText("Audio Player");
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        if (getIntent().getSerializableExtra("video") != null) {
            Video video = (Video) getIntent().getSerializableExtra("video");
            this.videodata = video;
            this.courseName.setText(video.getTitle());
            this.songName.setText(this.videodata.getVideo_title());
            this.url = this.videodata.getFile_url();
            Helper.setThumbnailImage(this, this.videodata.getThumbnail_url(), AppCompatResources.getDrawable(this, R.drawable.video_placeholder), this.audioImage);
        }
        if (getIntent() != null && getIntent().getSerializableExtra(Const.VIDEODATA) != null) {
            Video video2 = (Video) getIntent().getSerializableExtra(Const.VIDEODATA);
            this.videodata = video2;
            this.courseName.setText(video2.getTitle());
            this.songName.setText(this.videodata.getVideo_title());
            this.url = this.videodata.getFile_url();
            Helper.setThumbnailImage(this, this.videodata.getThumbnail_url(), AppCompatResources.getDrawable(this, R.drawable.video_placeholder), this.audioImage);
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.seekTo(getIntent().getIntExtra(Constants.INAPP_POSITION, 0));
            }
        }
        this.exo_playback_speed.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.AudioPlayerActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        try {
            Helper.showProgressDialog(this);
            this.songPrgs.setMax(0);
            this.songPrgs.setProgress(0);
            this.mediaPlayer.setDataSource(this.url);
            this.mediaPlayer.prepareAsync();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.songPrgs.setClickable(false);
        this.mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.appnew.android.player.AudioPlayerActivity$$ExternalSyntheticLambda2
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer3, int i, int i2) {
                return this.f$0.lambda$onCreate$1(mediaPlayer3, i, i2);
            }
        });
        this.mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.appnew.android.player.AudioPlayerActivity$$ExternalSyntheticLambda3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer3) {
                this.f$0.lambda$onCreate$2(mediaPlayer3);
            }
        });
        this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.appnew.android.player.AudioPlayerActivity$$ExternalSyntheticLambda4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer3) {
                this.f$0.lambda$onCreate$3(mediaPlayer3);
            }
        });
        this.playbtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.AudioPlayerActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$4(view);
            }
        });
        this.songPrgs.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.appnew.android.player.AudioPlayerActivity.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (AudioPlayerActivity.this.mediaPlayer == null || !fromUser) {
                    return;
                }
                AudioPlayerActivity.this.mediaPlayer.seekTo(progress);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                AudioPlayerActivity.this.mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        this.forwardbtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.AudioPlayerActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
        this.backwardbtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.AudioPlayerActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
        this.image_back.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.AudioPlayerActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$7(view);
            }
        });
        LocalBroadcastManager.getInstance(this).registerReceiver(this.musicServiceReceiver, new IntentFilter(MusicService.MUSIC_PLAYER_ACTION_STOP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        showSpeedOptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreate$1(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 701) {
            Helper.showProgressDialog(this);
            this.songPrgs.setEnabled(false);
            this.songPrgs.setClickable(false);
        } else if (i == 702) {
            Helper.dismissProgressDialog();
            this.songPrgs.setEnabled(true);
            this.songPrgs.setClickable(true);
        } else {
            this.songPrgs.setEnabled(true);
            this.songPrgs.setClickable(true);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        this.endTime = this.mediaPlayer.getDuration();
        this.sTime = this.mediaPlayer.getCurrentPosition();
        if (this.oneTime == 0) {
            this.songPrgs.setMax(this.endTime);
            this.oneTime = 1;
        }
        String strValueOf = String.valueOf(TimeUnit.MILLISECONDS.toMinutes(this.endTime));
        String strValueOf2 = String.valueOf(TimeUnit.MILLISECONDS.toMinutes(this.sTime));
        String strValueOf3 = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.endTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(this.endTime)));
        String strValueOf4 = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.sTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(this.sTime)));
        TextView textView = this.songTime;
        StringBuilder sb = new StringBuilder();
        if (strValueOf.length() <= 1) {
            strValueOf = "0" + strValueOf;
        }
        StringBuilder sbAppend = sb.append(strValueOf).append(" : ");
        if (strValueOf3.length() <= 1) {
            strValueOf3 = "0" + strValueOf3;
        }
        textView.setText(sbAppend.append(strValueOf3).toString());
        TextView textView2 = this.startTime;
        StringBuilder sb2 = new StringBuilder();
        if (strValueOf2.length() <= 1) {
            strValueOf2 = "0" + strValueOf2;
        }
        StringBuilder sbAppend2 = sb2.append(strValueOf2).append(" : ");
        if (strValueOf4.length() <= 1) {
            strValueOf4 = "0" + strValueOf4;
        }
        textView2.setText(sbAppend2.append(strValueOf4).toString());
        this.songPrgs.setProgress(this.sTime);
        this.hdlr.postDelayed(this.UpdateSongTime, 100L);
        Helper.dismissProgressDialog();
        this.playbtn.setImageResource(R.drawable.ic_baseline_pause_24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(MediaPlayer mediaPlayer) {
        this.sTime = 0;
        this.startTime.setText("00 : 00");
        this.songPrgs.setProgress(0);
        this.mediaPlayer.seekTo(0);
        this.playbtn.setImageResource(R.drawable.ic_baseline_play_arrow_24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        if (Helper.isConnected(this)) {
            if (this.mediaPlayer.isPlaying()) {
                this.mediaPlayer.pause();
                this.playbtn.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                return;
            } else {
                this.mediaPlayer.start();
                this.playbtn.setImageResource(R.drawable.ic_baseline_pause_24);
                return;
            }
        }
        Helper.buildDialogNoInternet(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        int i = this.sTime;
        int i2 = this.forwardTime;
        if (i + i2 <= this.endTime) {
            int i3 = i + i2;
            this.sTime = i3;
            this.mediaPlayer.seekTo(i3);
        } else {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            mediaPlayer.seekTo(mediaPlayer.getDuration());
        }
        if (this.playbtn.isEnabled()) {
            return;
        }
        this.playbtn.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        int i = this.sTime;
        int i2 = this.backwardTime;
        if (i - i2 > 0) {
            int i3 = i - i2;
            this.sTime = i3;
            this.mediaPlayer.seekTo(i3);
        } else {
            this.sTime = 0;
            this.mediaPlayer.seekTo(0);
        }
        if (this.playbtn.isEnabled()) {
            return;
        }
        this.playbtn.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.mediaPlayer.pause();
            this.playbtn.setImageResource(R.drawable.play_arrow);
            doBindService();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.musicServiceReceiver);
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mediaPlayer.reset();
            this.mediaPlayer.release();
            Handler handler = this.hdlr;
            if (handler != null) {
                handler.removeCallbacks(this.UpdateSongTime);
            }
            if (this.handler != null) {
                this.handler = null;
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            if (checkServiceStatus() && MusicService.INSTANCE.isAudioPlaying()) {
                Intent intent = new Intent(this, (Class<?>) MusicService.class);
                intent.setAction("Stop_Service");
                startService(intent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    private void doBindService() {
        if (MusicService.INSTANCE.isAudioPlaying()) {
            Intent intent = new Intent(this, (Class<?>) MusicService.class);
            intent.setAction("Stop_Service");
            intent.putExtra("videoUrl", this.url);
            intent.putExtra("title", getString(R.string.app_name));
            intent.putExtra("subTitle", this.videodata.getTitle());
            intent.putExtra(Constants.INAPP_POSITION, this.mediaPlayer.getCurrentPosition());
            intent.putExtra("player_pos", this.mediaPlayer.getCurrentPosition());
            intent.putExtra(Const.VIDEO_ID, this.videodata.getId());
            intent.putExtra("playerSpeed", this.playerSpeed);
            intent.putExtra(Const.VIDEODATA, this.videodata);
            startService(intent);
        }
        Intent intent2 = new Intent(this, (Class<?>) MusicService.class);
        intent2.setAction("Start_Service");
        intent2.putExtra("videoUrl", this.url);
        intent2.putExtra("title", getString(R.string.app_name));
        intent2.putExtra("subTitle", this.videodata.getTitle());
        intent2.putExtra(Constants.INAPP_POSITION, this.mediaPlayer.getCurrentPosition());
        intent2.putExtra("player_pos", this.mediaPlayer.getCurrentPosition());
        intent2.putExtra(Const.VIDEO_ID, this.videodata.getId());
        intent2.putExtra("playerSpeed", this.playerSpeed);
        intent2.putExtra(Const.VIDEODATA, this.videodata);
        startService(intent2);
    }

    private boolean checkServiceStatus() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if ("com.appnew.android.player.music_player.MusicService".equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private void showSpeedOptions() {
        String[] stringArray;
        PopupMenu popupMenu = new PopupMenu(this, this.exo_playback_speed, R.style.MyPopupMenu);
        Menu menu = popupMenu.getMenu();
        if (SharedPreference.getInstance().getString(Const.MAX_SPEED).equalsIgnoreCase("1")) {
            stringArray = getResources().getStringArray(R.array.speed_values_max);
        } else {
            stringArray = getResources().getStringArray(R.array.speed_values);
        }
        if (stringArray.length != 0) {
            for (String str : stringArray) {
                if (str.equalsIgnoreCase("1")) {
                    menu.add(Const.Normal);
                } else {
                    menu.add(str + "x");
                }
            }
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.player.AudioPlayerActivity$$ExternalSyntheticLambda0
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return this.f$0.lambda$showSpeedOptions$8(menuItem);
                }
            });
            popupMenu.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showSpeedOptions$8(MenuItem menuItem) {
        String string = menuItem.getTitle().toString();
        this.playerSpeed = string;
        if (this.mediaPlayer == null) {
            return false;
        }
        this.exo_playback_speed.setText(string);
        if (this.playerSpeed.equalsIgnoreCase(Const.Normal)) {
            PlaybackParams playbackParams = new PlaybackParams();
            playbackParams.setSpeed(1.0f);
            this.mediaPlayer.setPlaybackParams(playbackParams);
        } else {
            PlaybackParams playbackParams2 = new PlaybackParams();
            playbackParams2.setSpeed(Float.valueOf(this.playerSpeed.replace("x", "")).floatValue());
            this.mediaPlayer.setPlaybackParams(playbackParams2);
        }
        this.playbtn.setImageResource(R.drawable.ic_baseline_pause_24);
        return false;
    }
}
