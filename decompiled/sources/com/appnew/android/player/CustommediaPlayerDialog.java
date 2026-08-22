package com.appnew.android.player;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.ui.DefaultTimeBar;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionDialog;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionHelper;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class CustommediaPlayerDialog extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    private static DefaultBandwidthMeter BANDWIDTH_METER;
    private static long playPosition;
    private static String youtubeUri;
    Context context;
    ImageView cross;
    String[] data;
    private TextView exo_duration;
    private ImageButton exo_ffwd;
    private TextView exo_position;
    private DefaultTimeBar exo_progress;
    private ImageButton exo_rew;
    private boolean isShowingTrackSelectionDialog;
    private FrameLayout mFullScreenButton;
    private ImageView mFullScreenIcon;
    private DataSource.Factory mediaDataSourceFactory;
    MediaSource mediaSource;
    private ExoPlayer player;
    PositionListener positionListener;
    ProgressBar progressBar;
    ProgressTracker progressTracker;
    ImageView quality;
    private List<Integer> sparseAdaptiveResolutionList;
    private HashMap<Integer, String> sparseAdaptiveVideoUrlList;
    private List<Integer> sparseKeyList;
    private List<Integer> sparseMuxedResolutionList;
    private HashMap<Integer, String> sparseMuxedVideoUrlList;
    private List<String> sparseOPUSAudioUrl;
    private TextView speedTV;
    long startTimeMillis;
    private TrackSelectionHelper trackSelectionHelper;
    DefaultTrackSelector trackSelector;
    private DefaultTrackSelector.Parameters trackSelectorParameters;
    String url;
    private String userAgent;
    String id = "";
    int lastseleted = -1;

    private void extractYoutubeUrl(String url) {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(2132082704);
        super.onCreate(savedInstanceState);
        getWindow().setLayout(-1, 1200);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setFinishOnTouchOutside(false);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_custommedia_player_dialog);
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.quality = (ImageView) findViewById(R.id.quality);
        this.cross = (ImageView) findViewById(R.id.cross);
        this.userAgent = Util.getUserAgent(this, "ExoPlayerDemo");
        BANDWIDTH_METER = new DefaultBandwidthMeter.Builder(this).build();
        this.trackSelectorParameters = new DefaultTrackSelector.ParametersBuilder().build();
        if (getIntent() != null) {
            this.url = getIntent().getStringExtra("videoUrl");
            this.id = getIntent().getStringExtra("id");
        }
        if (this.url.contains("jwplatform")) {
            this.data = this.url.split(MqttTopic.MULTI_LEVEL_WILDCARD);
            new NetworkCall(this, this).NetworkAPICall(API.get_sign_test_link, "", true, false);
        } else {
            String[] strArrSplit = this.url.split(MqttTopic.MULTI_LEVEL_WILDCARD);
            this.data = strArrSplit;
            String str = strArrSplit[0];
            if (str != null) {
                extractYoutubeUrl(str);
            } else {
                extractYoutubeUrl(this.url);
            }
        }
        this.cross.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.CustommediaPlayerDialog$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        findViewById(R.id.quality).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.CustommediaPlayerDialog$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$2();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        youtubeUri = "";
        ProgressTracker progressTracker = this.progressTracker;
        if (progressTracker != null) {
            progressTracker.purgeHandler();
        }
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.release();
            this.player = null;
        }
        finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$2() {
        if (this.player != null) {
            if (youtubeUri.contains(".m3u8")) {
                DefaultTrackSelector defaultTrackSelector = this.trackSelector;
                if (defaultTrackSelector != null && defaultTrackSelector.getCurrentMappedTrackInfo() != null) {
                    if (this.trackSelector.getCurrentMappedTrackInfo() != null) {
                        this.isShowingTrackSelectionDialog = true;
                        TrackSelectionDialog.createForTrackSelector(this.trackSelector, new DialogInterface.OnDismissListener() { // from class: com.appnew.android.player.CustommediaPlayerDialog$$ExternalSyntheticLambda2
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.f$0.lambda$onCreate$1(dialogInterface);
                            }
                        }).show(getSupportFragmentManager(), (String) null);
                    }
                } else {
                    Snackbar.make(this.quality, getResources().getString(R.string.reloading_video_please_wait), 0).show();
                }
            } else {
                List<Integer> list = this.sparseAdaptiveResolutionList;
                if (list == null && list.size() == 0) {
                    Toast.makeText(this, getResources().getString(R.string.no_quality_found_till_yet), 0).show();
                } else {
                    showAlertDialog();
                }
            }
        } else {
            Toast.makeText(this, getResources().getString(R.string.no_quality_found_till_yet), 0).show();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(DialogInterface dialogInterface) {
        this.isShowingTrackSelectionDialog = false;
    }

    private void showAlertDialog() {
        final int[] iArr = {-1};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.select_quality));
        String[] strArr = new String[this.sparseAdaptiveResolutionList.size()];
        for (int i = 0; i < this.sparseAdaptiveResolutionList.size(); i++) {
            strArr[i] = String.valueOf(this.sparseAdaptiveResolutionList.get(i) + "  Quality");
        }
        int size = this.lastseleted;
        if (size == -1) {
            size = this.sparseAdaptiveResolutionList.size() - 1;
        }
        builder.setSingleChoiceItems(strArr, size, new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustommediaPlayerDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                iArr[0] = which;
                CustommediaPlayerDialog.this.lastseleted = which;
            }
        });
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustommediaPlayerDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                CustommediaPlayerDialog.playPosition = CustommediaPlayerDialog.this.player.getCurrentPosition();
                if (iArr[0] == -1) {
                    CustommediaPlayerDialog custommediaPlayerDialog = CustommediaPlayerDialog.this;
                    Toast.makeText(custommediaPlayerDialog, custommediaPlayerDialog.getResources().getString(R.string.please_change_quality_first), 0).show();
                } else if (CustommediaPlayerDialog.this.player != null) {
                    CustommediaPlayerDialog.this.player.release();
                    CustommediaPlayerDialog.this.player = null;
                }
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.CustommediaPlayerDialog.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                CustommediaPlayerDialog.this.resumePlayer();
                dialog.cancel();
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(true);
            this.player.getPlaybackState();
        }
    }

    private void showSpeedOptions() {
        PopupMenu popupMenu = new PopupMenu(this, this.speedTV, R.style.MyPopupMenu);
        Menu menu = popupMenu.getMenu();
        String[] stringArray = getResources().getStringArray(R.array.speed_values);
        if (stringArray.length != 0) {
            for (String str : stringArray) {
                if (str.equalsIgnoreCase("1")) {
                    menu.add(Const.Normal);
                } else {
                    menu.add(str + "x");
                }
            }
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.player.CustommediaPlayerDialog.4
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem item) {
                    String string = item.getTitle().toString();
                    if (CustommediaPlayerDialog.this.player == null) {
                        return false;
                    }
                    CustommediaPlayerDialog.this.speedTV.setText(string);
                    if (string.equalsIgnoreCase(Const.Normal)) {
                        CustommediaPlayerDialog.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf("1").floatValue(), 1.0f));
                        return false;
                    }
                    CustommediaPlayerDialog.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf(string.replace("x", "")).floatValue(), 1.0f));
                    return false;
                }
            });
            popupMenu.show();
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.get_sign_test_link)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setQuestion_id(this.id);
        encryptionData.setUrl(this.url);
        return service.getvideo_test_link(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        new Gson();
        apitype.hashCode();
        if (apitype.equals(API.get_sign_test_link)) {
            try {
                if (jsonstring.getString("status").equalsIgnoreCase("true")) {
                    JSONObject jSONObject = new JSONObject(jsonstring.toString());
                    if (jSONObject.has("data")) {
                        String string = jSONObject.getJSONObject("data").getString(Const.HLS);
                        this.progressBar.setVisibility(8);
                        this.sparseAdaptiveVideoUrlList = new HashMap<>();
                        youtubeUri = string;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class ProgressTracker implements Runnable {
        private static final int DELAY_MS = 1;
        private final Handler handler;
        private final Player player;
        private PositionListener positionListener;

        protected ProgressTracker(Player player, PositionListener positionListener) {
            this.player = player;
            this.positionListener = positionListener;
            Handler handler = new Handler();
            this.handler = handler;
            handler.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.positionListener.progress(this.player.getCurrentPosition());
            this.handler.postDelayed(this, 1L);
        }

        protected void purgeHandler() {
            this.handler.removeCallbacks(this);
        }
    }

    public class PositionListener {
        ExoPlayer simpleExoPlayer;
        long videoEndTimeMillis;

        public PositionListener(ExoPlayer player, long endTimeMillis, Context context) {
            this.simpleExoPlayer = player;
            this.videoEndTimeMillis = endTimeMillis;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void progress(long position) {
            if (this.videoEndTimeMillis > position || CustommediaPlayerDialog.this.player == null) {
                return;
            }
            CustommediaPlayerDialog.youtubeUri = "";
            if (CustommediaPlayerDialog.this.player != null) {
                CustommediaPlayerDialog.this.player.release();
                CustommediaPlayerDialog.this.player = null;
                if (CustommediaPlayerDialog.this.progressTracker != null) {
                    CustommediaPlayerDialog.this.progressTracker.purgeHandler();
                }
            }
            CustommediaPlayerDialog.this.finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private long getSeconds(String time) {
        if (time.contains(":")) {
            return (((long) Integer.parseInt(time.substring(0, time.indexOf(":")).trim())) * 60) + ((long) Integer.parseInt(time.substring(time.indexOf(":") + 1).trim()));
        }
        return Integer.parseInt(time);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            ((TelephonyManager) getSystemService("phone")).listen(new PhoneStateListener() { // from class: com.appnew.android.player.CustommediaPlayerDialog.5
                @Override // android.telephony.PhoneStateListener
                public void onCallStateChanged(int state, String incomingNumber) {
                    if (state == 1) {
                        CustommediaPlayerDialog.this.oncall(true);
                    }
                    if (state == 2) {
                        CustommediaPlayerDialog.this.oncall(true);
                    }
                    if (state == 0) {
                        CustommediaPlayerDialog.this.oncall(false);
                        ((AudioManager) CustommediaPlayerDialog.this.getApplicationContext().getSystemService("audio")).setMode(0);
                    }
                }
            }, 32);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String str = youtubeUri;
        if (str != null) {
            str.equalsIgnoreCase("");
        }
    }

    public void oncall(final boolean b2) {
        runOnUiThread(new Runnable() { // from class: com.appnew.android.player.CustommediaPlayerDialog.6
            @Override // java.lang.Runnable
            public void run() {
                if (b2) {
                    CustommediaPlayerDialog.this.pausePlayer();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
            this.player.getPlaybackState();
        }
    }
}
