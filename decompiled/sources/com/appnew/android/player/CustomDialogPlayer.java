package com.appnew.android.player;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.ui.DefaultTimeBar;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionDialog;
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionHelper;
import com.appnew.android.testmodule.activity.ViewSolutionActivity;
import com.eduteria.app.app.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class CustomDialogPlayer extends Dialog {
    private static DefaultBandwidthMeter BANDWIDTH_METER;
    private static String youtubeUri;
    Context context;
    ImageView cross;
    String[] data;
    private TextView exo_duration;
    private ImageButton exo_ffwd;
    private TextView exo_position;
    private DefaultTimeBar exo_progress;
    private ImageButton exo_rew;
    Handler handler;
    private boolean isShowingTrackSelectionDialog;
    private FrameLayout mFullScreenButton;
    private ImageView mFullScreenIcon;
    private DataSource.Factory mediaDataSourceFactory;
    MediaSource mediaSource;
    private ExoPlayer player;
    ProgressBar progressBar;
    ImageView quality;
    Runnable runnable;
    private List<Integer> sparseAdaptiveResolutionList;
    private HashMap<Integer, String> sparseAdaptiveVideoUrlList;
    private List<Integer> sparseKeyList;
    private List<Integer> sparseMuxedResolutionList;
    private HashMap<Integer, String> sparseMuxedVideoUrlList;
    private List<String> sparseOPUSAudioUrl;
    private TextView speedTV;
    private TrackSelectionHelper trackSelectionHelper;
    DefaultTrackSelector trackSelector;
    private DefaultTrackSelector.Parameters trackSelectorParameters;
    String url;
    private String userAgent;

    private void extractYoutubeUrl(String url) {
    }

    public CustomDialogPlayer(Context context, String url) {
        super(context);
        this.context = context;
        this.url = url;
    }

    public CustomDialogPlayer(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialogPlayer(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_player);
        this.handler = new Handler();
        this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.quality = (ImageView) findViewById(R.id.quality);
        this.cross = (ImageView) findViewById(R.id.cross);
        this.userAgent = Util.getUserAgent(getContext(), "ExoPlayerDemo");
        BANDWIDTH_METER = new DefaultBandwidthMeter.Builder(this.context).build();
        this.trackSelectorParameters = new DefaultTrackSelector.ParametersBuilder().build();
        String[] strArrSplit = this.url.split(MqttTopic.MULTI_LEVEL_WILDCARD);
        this.data = strArrSplit;
        String str = strArrSplit[0];
        if (str != null) {
            extractYoutubeUrl(str);
        } else {
            extractYoutubeUrl(this.url);
        }
        this.cross.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.CustomDialogPlayer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        findViewById(R.id.quality).setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.player.CustomDialogPlayer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$2();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        youtubeUri = "";
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.release();
            this.player = null;
        }
        dismiss();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$2() {
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector != null && defaultTrackSelector.getCurrentMappedTrackInfo() != null && this.player.getPlayWhenReady()) {
            if (this.trackSelector.getCurrentMappedTrackInfo() != null) {
                this.isShowingTrackSelectionDialog = true;
                TrackSelectionDialog.createForTrackSelector(this.trackSelector, new DialogInterface.OnDismissListener() { // from class: com.appnew.android.player.CustomDialogPlayer$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.lambda$onCreate$1(dialogInterface);
                    }
                }).show(((ViewSolutionActivity) this.context).getSupportFragmentManager(), (String) null);
            }
        } else {
            Toast.makeText(getContext(), this.context.getResources().getString(R.string.player_not_ready_try_again), 0).show();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(DialogInterface dialogInterface) {
        this.isShowingTrackSelectionDialog = false;
    }

    private void showSpeedOptions() {
        PopupMenu popupMenu = new PopupMenu(getContext(), this.speedTV, R.style.MyPopupMenu);
        Menu menu = popupMenu.getMenu();
        String[] stringArray = getContext().getResources().getStringArray(R.array.speed_values);
        if (stringArray.length != 0) {
            for (String str : stringArray) {
                menu.add(str + "x");
            }
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.player.CustomDialogPlayer.1
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem item) {
                    String string = item.getTitle().toString();
                    if (CustomDialogPlayer.this.player == null) {
                        return false;
                    }
                    CustomDialogPlayer.this.speedTV.setText(string);
                    CustomDialogPlayer.this.player.setPlaybackParameters(new PlaybackParameters(Float.valueOf(string.replace("x", "")).floatValue(), 1.0f));
                    return false;
                }
            });
            popupMenu.show();
        }
    }
}
