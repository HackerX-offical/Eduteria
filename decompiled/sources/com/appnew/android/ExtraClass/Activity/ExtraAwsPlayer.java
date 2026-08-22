package com.appnew.android.ExtraClass.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.AsyncTask;
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
import androidx.media3.exoplayer.SimpleExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.ui.DefaultTimeBar;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionHelper;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class ExtraAwsPlayer extends AppCompatActivity {
    private static DefaultBandwidthMeter BANDWIDTH_METER;
    private static long playPosition;
    TextView floatingText;
    private boolean inErrorState;
    private String islive;
    private FrameLayout mFullScreenButton;
    private Dialog mFullScreenDialog;
    private ImageView mFullScreenIcon;
    private DataSource.Factory mediaDataSourceFactory;
    MediaSource mediaSource;
    private SimpleExoPlayer player;
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
    String url = "";

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPortrait(int orientation) {
        return orientation < 85 || orientation > 100;
    }

    private void releasePlayer() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        setContentView(R.layout.activity_extra_aws_player);
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.quality = (ImageView) findViewById(R.id.quality);
        this.video_name_text = (TextView) findViewById(R.id.video_name);
        this.floatingText = (TextView) findViewById(R.id.floatingText_new);
        this.rootView = findViewById(R.id.root_new);
        BANDWIDTH_METER = new DefaultBandwidthMeter.Builder(this).build();
        if (getIntent() != null) {
            this.fileUrl = (String) getIntent().getSerializableExtra("videourl");
            this.type = getIntent().getStringExtra("type");
            this.name = getIntent().getStringExtra("videoname");
        }
        this.video_name_text.setSelected(true);
        this.video_name_text.setText(this.name);
        this.floatingText.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
        this.floatingText.measure(0, 0);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                ExtraAwsPlayer.this.blink();
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
        String str = this.fileUrl;
        if (str == null || str.equalsIgnoreCase("")) {
            Toast.makeText(this, getResources().getString(R.string.url_is_not_found), 0).show();
        } else if (this.type.equalsIgnoreCase("0") || this.type.equalsIgnoreCase("7") || this.type.equalsIgnoreCase("5") || this.type.equalsIgnoreCase("8")) {
            extractquality(this.fileUrl);
        }
        findViewById(R.id.quality).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        initFullscreenButton();
        initFullscreenDialog();
        try {
            new OrientationEventListener(getApplicationContext()) { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer.2
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int orientation) {
                    try {
                        if (Settings.System.getInt(ExtraAwsPlayer.this.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                            boolean zIsPortrait = ExtraAwsPlayer.this.isPortrait(orientation);
                            if (!zIsPortrait && ExtraAwsPlayer.this.savedOrientation == 1) {
                                ExtraAwsPlayer.this.savedOrientation = 0;
                                ExtraAwsPlayer.this.setRequestedOrientation(2);
                            } else if (zIsPortrait && ExtraAwsPlayer.this.savedOrientation == 0) {
                                ExtraAwsPlayer.this.savedOrientation = 1;
                                ExtraAwsPlayer.this.setRequestedOrientation(2);
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
    public /* synthetic */ Unit lambda$onCreate$0() {
        if (this.sparseAdaptiveResolutionList == null) {
            Toast.makeText(this, getResources().getString(R.string.no_quality_found_till_yet), 0).show();
            return null;
        }
        if (this.player != null) {
            showAlertDialog();
            return null;
        }
        Toast.makeText(this, getResources().getString(R.string.no_quality_found_till_yet), 0).show();
        return null;
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
            this.speedTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ExtraAwsPlayer.this.showSpeedOptions();
                }
            });
        }
        TextView textView2 = this.tvGoLive;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer.4
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    ExtraAwsPlayer.this.goLive();
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
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.seekTo(simpleExoPlayer.getDuration());
        }
    }

    private void openFullscreenDialog() {
        this.mFullScreenIcon.setImageDrawable(ContextCompat.getDrawable(this, 2131231273));
        this.mExoPlayerFullscreen = true;
        setRequestedOrientation(0);
    }

    private void initFullscreenDialog() {
        this.mFullScreenDialog = new Dialog(this, android.R.style.Theme.Black.NoTitleBar.Fullscreen) { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer.5
            @Override // android.app.Dialog
            public void onBackPressed() {
                if (ExtraAwsPlayer.this.mExoPlayerFullscreen) {
                    ExtraAwsPlayer.this.closeFullscreenDialog();
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
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer.6
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem item) {
                    String string = item.getTitle().toString();
                    if (ExtraAwsPlayer.this.player == null) {
                        return false;
                    }
                    ExtraAwsPlayer.this.speedTV.setText(string);
                    if (string.equalsIgnoreCase(Const.Normal)) {
                        ExtraAwsPlayer.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                        return false;
                    }
                    ExtraAwsPlayer.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf(string.replace("x", "")).floatValue(), 1.0f));
                    return false;
                }
            });
            popupMenu.show();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void blink() {
        try {
            this.floatingText.setVisibility(4);
        } catch (IllegalArgumentException unused) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void showAlertDialog() {
        final int[] iArr = {-1};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.select_track));
        String[] strArr = new String[this.sparseAdaptiveResolutionList.size()];
        for (int i = 0; i < this.sparseAdaptiveResolutionList.size(); i++) {
            if (this.sparseAdaptiveResolutionList.get(i).contains("720")) {
                strArr[i] = getResources().getString(R.string.very_high_quality);
            } else if (this.sparseAdaptiveResolutionList.get(i).contains("480")) {
                strArr[i] = getResources().getString(R.string.high_quality);
            } else if (this.sparseAdaptiveResolutionList.get(i).contains("360")) {
                strArr[i] = getResources().getString(R.string.medium_quality);
            } else if (this.sparseAdaptiveResolutionList.get(i).contains("240")) {
                strArr[i] = getResources().getString(R.string.low_quality);
            } else if (this.sparseAdaptiveResolutionList.get(i).contains("1080")) {
                strArr[i] = getResources().getString(R.string.extremly_high_quality);
            }
        }
        int i2 = this.lastseleted;
        if (i2 == -1) {
            i2 = 0;
        }
        builder.setSingleChoiceItems(strArr, i2, new DialogInterface.OnClickListener() { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                iArr[0] = which;
                ExtraAwsPlayer.this.lastseleted = which;
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                ExtraAwsPlayer.playPosition = ExtraAwsPlayer.this.player.getCurrentPosition();
                ExtraAwsPlayer.this.bitrateapply = true;
                if (iArr[0] == -1) {
                    ExtraAwsPlayer extraAwsPlayer = ExtraAwsPlayer.this;
                    Toast.makeText(extraAwsPlayer, extraAwsPlayer.getResources().getString(R.string.please_change_quality_first), 0).show();
                    return;
                }
                if (ExtraAwsPlayer.this.player != null) {
                    ExtraAwsPlayer.this.player.release();
                    ExtraAwsPlayer.this.player = null;
                }
                ExtraAwsPlayer extraAwsPlayer2 = ExtraAwsPlayer.this;
                extraAwsPlayer2.initiallizeplayer((String) extraAwsPlayer2.sparseAdaptiveVideoUrlList.get(ExtraAwsPlayer.this.sparseAdaptiveResolutionList.get(iArr[0])));
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    private void extractquality(final String url) {
        this.sparseAdaptiveVideoUrlList = new HashMap<>();
        this.sparseAdaptiveResolutionList = new ArrayList();
        AsyncTask.execute(new Runnable() { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$extractquality$2(url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extractquality$2(String str) {
        List<String> list;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if (line.contains("RESOLUTION")) {
                        for (String str2 : line.split(Constants.SEPARATOR_COMMA)) {
                            if (str2.contains("RESOLUTION")) {
                                this.sparseAdaptiveResolutionList.add(str2);
                            }
                        }
                    }
                    if (line.contains(".m3u8") && (list = this.sparseAdaptiveResolutionList) != null && list.size() > 0) {
                        this.sparseAdaptiveVideoUrlList.put(this.sparseAdaptiveResolutionList.get(r4.size() - 1), generateurl(line, str));
                    }
                } else {
                    runOnUiThread(new Runnable() { // from class: com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$extractquality$1();
                        }
                    });
                    bufferedReader.close();
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$extractquality$1() {
        List<String> list = this.sparseAdaptiveResolutionList;
        if (list == null || list.size() <= 0) {
            return;
        }
        initiallizeplayer(this.sparseAdaptiveVideoUrlList.get(this.sparseAdaptiveResolutionList.get(0)));
    }

    private String generateurl(String input, String url) {
        String[] strArrSplit = url.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        String str = "";
        int i = 0;
        while (i < strArrSplit.length) {
            if (i == strArrSplit.length - 1) {
                str = str + MqttTopic.TOPIC_LEVEL_SEPARATOR + input;
            } else {
                str = i == 0 ? str + strArrSplit[i] : str + MqttTopic.TOPIC_LEVEL_SEPARATOR + strArrSplit[i];
            }
            i++;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initiallizeplayer(String url1) {
        try {
            this.bitrateapply = false;
            this.url = url1;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void pausePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
            this.player.getPlaybackState();
        }
    }
}
