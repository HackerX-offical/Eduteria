package com.appnew.android.ExtraClass.Activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.ui.DefaultTimeBar;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.customview.TrackSelectionDialog;
import com.eduteria.app.app.R;
import com.pallycon.exoplayersample.simple.TrackSelectionHelper;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class DrmExtraPlayer extends AppCompatActivity {
    private static DefaultBandwidthMeter BANDWIDTH_METER;
    private static long playPosition;
    TextView floatingText;
    private boolean inErrorState;
    private boolean isShowingTrackSelectionDialog;
    private String islive;
    private TrackGroupArray lastSeenTrackGroupArray;
    private FrameLayout mFullScreenButton;
    private Dialog mFullScreenDialog;
    private ImageView mFullScreenIcon;
    private DataSource.Factory mediaDataSourceFactory;
    MediaSource mediaSource;
    private ExoPlayer player;
    ProgressBar progressBar;
    ImageView quality;
    View rootView;
    private int savedOrientation;
    private List<String> sparseAdaptiveResolutionList;
    private HashMap<String, String> sparseAdaptiveVideoUrlList;
    private TextView speedTV;
    private TrackSelectionHelper trackSelectionHelper;
    DefaultTrackSelector trackSelector;
    private DefaultTrackSelector.Parameters trackSelectorParameters;
    private TextView tvGoLive;
    private String userAgent;
    TextView video_name_text;
    String fileUrl = "";
    String type = "";
    String name = "";
    boolean bitrateapply = false;
    int lastseleted = -1;
    private boolean mExoPlayerFullscreen = false;
    private final String STATE_PLAYER_FULLSCREEN = "playerFullscreen";
    String speedx = "";
    String link = "";
    String token = "";
    String userId = "";

    private void hit_api_for_video_link() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPortrait(int orientation) {
        return orientation < 85 || orientation > 100;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        setContentView(R.layout.activity_drm_extra_player);
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.quality = (ImageView) findViewById(R.id.quality);
        this.video_name_text = (TextView) findViewById(R.id.video_name);
        this.floatingText = (TextView) findViewById(R.id.floatingText_new);
        this.rootView = findViewById(R.id.root_new);
        BANDWIDTH_METER = new DefaultBandwidthMeter.Builder(this).build();
        if (getIntent() != null) {
            this.token = (String) getIntent().getSerializableExtra("vcd_id");
            this.userId = getIntent().getStringExtra("userid");
            this.name = getIntent().getStringExtra("videoname");
            this.type = getIntent().getStringExtra("type");
        }
        this.video_name_text.setSelected(true);
        this.video_name_text.setText(this.name);
        this.floatingText.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
        this.floatingText.measure(0, 0);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.ExtraClass.Activity.DrmExtraPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                DrmExtraPlayer.this.blink();
            }
        }, 3000L);
        this.floatingText.setVisibility(0);
        if (savedInstanceState != null) {
            this.mExoPlayerFullscreen = savedInstanceState.getBoolean("playerFullscreen");
        }
        this.userAgent = Util.getUserAgent(this, "ExoPlayerDemo");
        this.trackSelectorParameters = new DefaultTrackSelector.ParametersBuilder().build();
        if (this.type.equalsIgnoreCase("8")) {
            this.islive = "5";
        } else if (this.type.equalsIgnoreCase("7")) {
            this.islive = "0";
        }
        String str = this.token;
        if (str == null || str.equalsIgnoreCase("")) {
            Toast.makeText(this, getResources().getString(R.string.url_is_not_found), 0).show();
        } else {
            hit_api_for_video_link();
        }
        findViewById(R.id.quality).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.ExtraClass.Activity.DrmExtraPlayer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$1();
            }
        }));
        initFullscreenButton();
        initFullscreenDialog();
        try {
            new OrientationEventListener(getApplicationContext()) { // from class: com.appnew.android.ExtraClass.Activity.DrmExtraPlayer.2
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int orientation) {
                    try {
                        if (Settings.System.getInt(DrmExtraPlayer.this.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                            boolean zIsPortrait = DrmExtraPlayer.this.isPortrait(orientation);
                            if (!zIsPortrait && DrmExtraPlayer.this.savedOrientation == 1) {
                                DrmExtraPlayer.this.savedOrientation = 0;
                                DrmExtraPlayer.this.setRequestedOrientation(2);
                            } else if (zIsPortrait && DrmExtraPlayer.this.savedOrientation == 0) {
                                DrmExtraPlayer.this.savedOrientation = 1;
                                DrmExtraPlayer.this.setRequestedOrientation(2);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }.enable();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$1() {
        if (Helper.isConnected(this)) {
            DefaultTrackSelector defaultTrackSelector = this.trackSelector;
            if (defaultTrackSelector != null && defaultTrackSelector.getCurrentMappedTrackInfo() != null) {
                if (this.trackSelector.getCurrentMappedTrackInfo() != null) {
                    this.isShowingTrackSelectionDialog = true;
                    TrackSelectionDialog.createForTrackSelector(this.trackSelector, new DialogInterface.OnDismissListener() { // from class: com.appnew.android.ExtraClass.Activity.DrmExtraPlayer$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            this.f$0.lambda$onCreate$0(dialogInterface);
                        }
                    }, -1, "240p").show(getSupportFragmentManager(), (String) null);
                }
            } else {
                Toast.makeText(this, getResources().getString(R.string.player_not_ready_try_again), 0).show();
            }
        } else {
            Toast.makeText(this, getResources().getString(R.string.no_internet_connection), 0).show();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(DialogInterface dialogInterface) {
        this.isShowingTrackSelectionDialog = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        try {
            boolean z = true;
            if (newConfig.orientation == 1) {
                this.mExoPlayerFullscreen = false;
                this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
                this.video_name_text.setVisibility(0);
                getWindow().clearFlags(1024);
                float f2 = getResources().getDisplayMetrics().density;
                if ((getResources().getConfiguration().screenLayout & 15) != 4) {
                    z = false;
                }
                this.rootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) ((f2 * ((getResources().getConfiguration().screenLayout & 15) == 3 ? 350.0f : z ? 450.0f : 230.0f)) + 0.5f)));
                return;
            }
            this.mExoPlayerFullscreen = true;
            this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231273));
            this.video_name_text.setVisibility(8);
            getWindow().setFlags(1024, 1024);
            this.rootView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void initFullscreenButton() {
        if (this.islive.equalsIgnoreCase("5")) {
            this.speedTV.setVisibility(8);
            this.tvGoLive.setVisibility(0);
            DefaultTimeBar defaultTimeBar = null;
            defaultTimeBar.setVisibility(4);
            throw null;
        }
        this.speedTV.setVisibility(0);
        this.tvGoLive.setVisibility(8);
        TextView textView = this.speedTV;
        if (textView != null) {
            textView.setText(getResources().getString(R.string.normal));
            this.speedTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.ExtraClass.Activity.DrmExtraPlayer.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DrmExtraPlayer.this.showSpeedOptions();
                }
            });
        }
        TextView textView2 = this.tvGoLive;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.ExtraClass.Activity.DrmExtraPlayer.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    DrmExtraPlayer.this.goLive();
                }
            });
        }
        if (TextUtils.isEmpty(this.speedx)) {
            return;
        }
        this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf(this.speedx.replace("x", "")).floatValue(), 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goLive() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.seekTo(exoPlayer.getDuration());
        }
    }

    private void openFullscreenDialog() {
        this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231273));
        this.mExoPlayerFullscreen = true;
        setRequestedOrientation(0);
    }

    private void initFullscreenDialog() {
        this.mFullScreenDialog = new Dialog(this, android.R.style.Theme.Black.NoTitleBar.Fullscreen) { // from class: com.appnew.android.ExtraClass.Activity.DrmExtraPlayer.5
            @Override // android.app.Dialog
            public void onBackPressed() {
                if (DrmExtraPlayer.this.mExoPlayerFullscreen) {
                    DrmExtraPlayer.this.closeFullscreenDialog();
                }
                super.onBackPressed();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeFullscreenDialog() {
        this.mExoPlayerFullscreen = false;
        setRequestedOrientation(1);
        this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSpeedOptions() {
        String[] stringArray;
        PopupMenu popupMenu = new PopupMenu(this, this.speedTV, R.style.MyPopupMenu);
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
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.ExtraClass.Activity.DrmExtraPlayer.6
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem item) {
                    String string = item.getTitle().toString();
                    if (DrmExtraPlayer.this.player == null) {
                        return false;
                    }
                    DrmExtraPlayer.this.speedTV.setText(string);
                    if (string.equalsIgnoreCase(Const.Normal)) {
                        DrmExtraPlayer.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                        return false;
                    }
                    DrmExtraPlayer.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf(string.replace("x", "")).floatValue(), 1.0f));
                    return false;
                }
            });
            popupMenu.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blink() {
        try {
            this.floatingText.setVisibility(4);
        } catch (IllegalArgumentException unused) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getResources().getConfiguration().orientation == 2) {
            closeFullscreenDialog();
        } else {
            releasePlayer();
            super.onBackPressed();
        }
    }

    private void releasePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            playPosition = exoPlayer.getCurrentPosition();
            this.player.release();
            this.fileUrl = "";
        }
    }

    private void pausePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            this.player.getPlaybackState();
        }
    }

    private void resumePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(true);
            this.player.getPlaybackState();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            playPosition = exoPlayer.getCurrentPosition();
            this.player.release();
            this.player = null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.release();
            this.player = null;
        }
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        resumePlayer();
    }
}
