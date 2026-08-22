package com.appnew.android.feeds.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.session.MediaSession;
import androidx.media3.ui.PlayerControlView;
import androidx.media3.ui.PlayerView;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.player.YTubePlayerView;
import com.appnew.android.player.YTubePlayerViewShorts;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FeedVideoPlayer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0006´\u0001µ\u0001¶\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010j\u001a\u00020\u00062\u0006\u0010k\u001a\u00020MH\u0002J\u0016\u0010\u0097\u0001\u001a\u00030\u0098\u00012\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0014J\n\u0010\u009b\u0001\u001a\u00030\u0098\u0001H\u0002J\t\u0010 \u001a\u00030\u0098\u0001H\u0002J\n\u0010\u009c\u0001\u001a\u00030\u0098\u0001H\u0014J\n\u0010\u009d\u0001\u001a\u00030\u0098\u0001H\u0014J\u0011\u0010\u009e\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u009f\u0001\u001a\u00020\nJ\n\u0010 \u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010¡\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010¥\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010¦\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010§\u0001\u001a\u00030\u0098\u0001H\u0002J\u0014\u0010¨\u0001\u001a\u00030\u0098\u00012\b\u0010©\u0001\u001a\u00030ª\u0001H\u0016J\n\u0010«\u0001\u001a\u00030\u0098\u0001H\u0016J\n\u0010¬\u0001\u001a\u00030\u0098\u0001H\u0014J\u0017\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u00012\t\u0010¯\u0001\u001a\u0004\u0018\u00010\nH\u0017J\n\u0010°\u0001\u001a\u00030\u0098\u0001H\u0002J\u0013\u0010±\u0001\u001a\u00020\u00062\b\u0010²\u0001\u001a\u00030³\u0001H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020+X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010Q\"\u0004\bV\u0010SR\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010]\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010$\"\u0004\b_\u0010&R\u001a\u0010`\u001a\u00020aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001a\u0010f\u001a\u00020aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010c\"\u0004\bh\u0010eR\u000e\u0010i\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u0004\u0018\u00010mX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0010\u0010t\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010v\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010$\"\u0004\bx\u0010&R\u0010\u0010y\u001a\u0004\u0018\u00010zX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010~\u001a\u0004\u0018\u00010\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0082\u0001\u001a\u0004\u0018\u00010}X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R!\u0010\u0087\u0001\u001a\u0004\u0018\u00010}X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0084\u0001\"\u0006\b\u0089\u0001\u0010\u0086\u0001R\"\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010$\"\u0005\b\u0092\u0001\u0010&R\u0015\u0010\u0093\u0001\u001a\u00030\u0094\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0017\u0010¢\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010£\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006·\u0001"}, d2 = {"Lcom/appnew/android/feeds/activity/FeedVideoPlayer;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/text/Html$ImageGetter;", "<init>", "()V", "isPause", "", "webView", "Landroid/webkit/WebView;", "isYoutube", "", "videoId", "youtubeShortPlayerView", "youtubePlayerView", "yTubeShortPlayerView", "Lcom/appnew/android/player/YTubePlayerViewShorts;", "getYTubeShortPlayerView", "()Lcom/appnew/android/player/YTubePlayerViewShorts;", "setYTubeShortPlayerView", "(Lcom/appnew/android/player/YTubePlayerViewShorts;)V", "yTubePlayerView", "Lcom/appnew/android/player/YTubePlayerView;", "getYTubePlayerView", "()Lcom/appnew/android/player/YTubePlayerView;", "setYTubePlayerView", "(Lcom/appnew/android/player/YTubePlayerView;)V", "gestureDetector", "Landroid/view/GestureDetector;", "exoPlayer", "Landroidx/media3/ui/PlayerView;", "getExoPlayer", "()Landroidx/media3/ui/PlayerView;", "setExoPlayer", "(Landroidx/media3/ui/PlayerView;)V", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "des", "getDes", "setDes", "playPosition", "", "getPlayPosition", "()J", "mediaSource", "Landroidx/media3/exoplayer/source/MediaSource;", "getMediaSource", "()Landroidx/media3/exoplayer/source/MediaSource;", "setMediaSource", "(Landroidx/media3/exoplayer/source/MediaSource;)V", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "getPlayer", "()Landroidx/media3/exoplayer/ExoPlayer;", "setPlayer", "(Landroidx/media3/exoplayer/ExoPlayer;)V", "loadControl", "Landroidx/media3/exoplayer/DefaultLoadControl;", "getLoadControl", "()Landroidx/media3/exoplayer/DefaultLoadControl;", "setLoadControl", "(Landroidx/media3/exoplayer/DefaultLoadControl;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "data_layout", "Landroid/widget/RelativeLayout;", "getData_layout", "()Landroid/widget/RelativeLayout;", "setData_layout", "(Landroid/widget/RelativeLayout;)V", "newOrientation", "", "exo_ffwd", "Landroid/widget/ImageButton;", "getExo_ffwd", "()Landroid/widget/ImageButton;", "setExo_ffwd", "(Landroid/widget/ImageButton;)V", "exo_rew", "getExo_rew", "setExo_rew", "htmldata", "Landroid/text/Spanned;", "getHtmldata", "()Landroid/text/Spanned;", "setHtmldata", "(Landroid/text/Spanned;)V", "speedx", "getSpeedx", "setSpeedx", "descritption", "Landroid/widget/TextView;", "getDescritption", "()Landroid/widget/TextView;", "setDescritption", "(Landroid/widget/TextView;)V", "readmore", "getReadmore", "setReadmore", "savedOrientation", "isPortrait", Constants.KEY_ORIENTATION, "trackSelectorParameters", "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;", "trackSelector", "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;", "getTrackSelector", "()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;", "setTrackSelector", "(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;)V", "mFullScreenButton", "Landroid/widget/FrameLayout;", "spped_title", "getSpped_title", "setSpped_title", "mFullScreenDialog", "Landroid/app/Dialog;", "mExoPlayerFullscreen", "mFullScreenIcon", "Landroid/widget/ImageView;", "powerMenu", "Lcom/skydoves/powermenu/PowerMenu;", "tvGoLive", "speedTV", "quality", "getQuality", "()Landroid/widget/ImageView;", "setQuality", "(Landroid/widget/ImageView;)V", "icon", "getIcon", "setIcon", "rootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "view_type", "getView_type", "setView_type", "BANDWIDTH_METER", "Landroidx/media3/exoplayer/upstream/DefaultBandwidthMeter;", "getBANDWIDTH_METER", "()Landroidx/media3/exoplayer/upstream/DefaultBandwidthMeter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initPlayerWebView", "onPause", "onResume", "descriptionCheck", "it", "initFullscreenButton", "showSpeedOptions", "onIconMenuItemClickListener", "Lcom/skydoves/powermenu/OnMenuItemClickListener;", "Lcom/skydoves/powermenu/PowerMenuItem;", "openFullscreenDialog", "closeFullscreenDialog", "initFullscreenDialog", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", "onDestroy", "getDrawable", "Landroid/graphics/drawable/Drawable;", CmcdData.Factory.STREAMING_FORMAT_SS, "initShortPlayerWebView", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "PlayerWebViewClient", "ShortPlayerWebViewClient", "CustomGestureListener", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedVideoPlayer extends AppCompatActivity implements Html.ImageGetter {
    public static final int $stable = 8;
    private final DefaultBandwidthMeter BANDWIDTH_METER;
    private RelativeLayout data_layout;
    private String des;
    public TextView descritption;
    private PlayerView exoPlayer;
    private ImageButton exo_ffwd;
    private ImageButton exo_rew;
    private GestureDetector gestureDetector;
    private Spanned htmldata;
    private ImageView icon;
    private boolean isPause;
    private DefaultLoadControl loadControl;
    private boolean mExoPlayerFullscreen;
    private FrameLayout mFullScreenButton;
    private Dialog mFullScreenDialog;
    private ImageView mFullScreenIcon;
    private MediaSource mediaSource;
    private int newOrientation;
    private final OnMenuItemClickListener<PowerMenuItem> onIconMenuItemClickListener;
    private final long playPosition;
    public ExoPlayer player;
    private PowerMenu powerMenu;
    private ProgressBar progressBar;
    private ImageView quality;
    public TextView readmore;
    private ConstraintLayout rootView;
    private int savedOrientation;
    private TextView speedTV;
    private DefaultTrackSelector trackSelector;
    private DefaultTrackSelector.Parameters trackSelectorParameters;
    private TextView tvGoLive;
    private WebView webView;
    private YTubePlayerView yTubePlayerView;
    private YTubePlayerViewShorts yTubeShortPlayerView;
    private WebView youtubePlayerView;
    private WebView youtubeShortPlayerView;
    private String isYoutube = "0";
    private String videoId = "";
    private String url = "";
    private String speedx = "";
    private String spped_title = "";
    private String view_type = "1";

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPortrait(int orientation) {
        return orientation < 85 || orientation > 100;
    }

    public FeedVideoPlayer() {
        DefaultBandwidthMeter defaultBandwidthMeterBuild = new DefaultBandwidthMeter.Builder(this).build();
        Intrinsics.checkNotNullExpressionValue(defaultBandwidthMeterBuild, "build(...)");
        this.BANDWIDTH_METER = defaultBandwidthMeterBuild;
        this.onIconMenuItemClickListener = new OnMenuItemClickListener() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer$$ExternalSyntheticLambda0
            @Override // com.skydoves.powermenu.OnMenuItemClickListener
            public final void onItemClick(int i, Object obj) {
                FeedVideoPlayer.onIconMenuItemClickListener$lambda$10(this.f$0, i, (PowerMenuItem) obj);
            }
        };
    }

    public final YTubePlayerViewShorts getYTubeShortPlayerView() {
        return this.yTubeShortPlayerView;
    }

    public final void setYTubeShortPlayerView(YTubePlayerViewShorts yTubePlayerViewShorts) {
        this.yTubeShortPlayerView = yTubePlayerViewShorts;
    }

    public final YTubePlayerView getYTubePlayerView() {
        return this.yTubePlayerView;
    }

    public final void setYTubePlayerView(YTubePlayerView yTubePlayerView) {
        this.yTubePlayerView = yTubePlayerView;
    }

    public final PlayerView getExoPlayer() {
        return this.exoPlayer;
    }

    public final void setExoPlayer(PlayerView playerView) {
        this.exoPlayer = playerView;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final String getDes() {
        return this.des;
    }

    public final void setDes(String str) {
        this.des = str;
    }

    public final long getPlayPosition() {
        return this.playPosition;
    }

    public final MediaSource getMediaSource() {
        return this.mediaSource;
    }

    public final void setMediaSource(MediaSource mediaSource) {
        this.mediaSource = mediaSource;
    }

    public final ExoPlayer getPlayer() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            return exoPlayer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("player");
        return null;
    }

    public final void setPlayer(ExoPlayer exoPlayer) {
        Intrinsics.checkNotNullParameter(exoPlayer, "<set-?>");
        this.player = exoPlayer;
    }

    public final DefaultLoadControl getLoadControl() {
        return this.loadControl;
    }

    public final void setLoadControl(DefaultLoadControl defaultLoadControl) {
        this.loadControl = defaultLoadControl;
    }

    public final ProgressBar getProgressBar() {
        return this.progressBar;
    }

    public final void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public final RelativeLayout getData_layout() {
        return this.data_layout;
    }

    public final void setData_layout(RelativeLayout relativeLayout) {
        this.data_layout = relativeLayout;
    }

    public final ImageButton getExo_ffwd() {
        return this.exo_ffwd;
    }

    public final void setExo_ffwd(ImageButton imageButton) {
        this.exo_ffwd = imageButton;
    }

    public final ImageButton getExo_rew() {
        return this.exo_rew;
    }

    public final void setExo_rew(ImageButton imageButton) {
        this.exo_rew = imageButton;
    }

    public final Spanned getHtmldata() {
        return this.htmldata;
    }

    public final void setHtmldata(Spanned spanned) {
        this.htmldata = spanned;
    }

    public final String getSpeedx() {
        return this.speedx;
    }

    public final void setSpeedx(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.speedx = str;
    }

    public final TextView getDescritption() {
        TextView textView = this.descritption;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("descritption");
        return null;
    }

    public final void setDescritption(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.descritption = textView;
    }

    public final TextView getReadmore() {
        TextView textView = this.readmore;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("readmore");
        return null;
    }

    public final void setReadmore(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.readmore = textView;
    }

    public final DefaultTrackSelector getTrackSelector() {
        return this.trackSelector;
    }

    public final void setTrackSelector(DefaultTrackSelector defaultTrackSelector) {
        this.trackSelector = defaultTrackSelector;
    }

    public final String getSpped_title() {
        return this.spped_title;
    }

    public final void setSpped_title(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.spped_title = str;
    }

    public final ImageView getQuality() {
        return this.quality;
    }

    public final void setQuality(ImageView imageView) {
        this.quality = imageView;
    }

    public final ImageView getIcon() {
        return this.icon;
    }

    public final void setIcon(ImageView imageView) {
        this.icon = imageView;
    }

    public final ConstraintLayout getRootView() {
        return this.rootView;
    }

    public final void setRootView(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public final String getView_type() {
        return this.view_type;
    }

    public final void setView_type(String str) {
        this.view_type = str;
    }

    public final DefaultBandwidthMeter getBANDWIDTH_METER() {
        return this.BANDWIDTH_METER;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_video_player);
        Helper.enableScreenShot(this);
        try {
            this.progressBar = (ProgressBar) findViewById(R.id.progress_bar);
            this.data_layout = (RelativeLayout) findViewById(R.id.data_layout);
            setDescritption((TextView) findViewById(R.id.descritption));
            setReadmore((TextView) findViewById(R.id.read_more));
            this.rootView = (ConstraintLayout) findViewById(R.id.root_new);
            this.exoPlayer = (PlayerView) findViewById(R.id.exoplayer);
            this.exo_ffwd = (ImageButton) findViewById(R.id.exo_forward);
            this.exo_rew = (ImageButton) findViewById(R.id.exo_rewind);
            this.youtubeShortPlayerView = (WebView) findViewById(R.id.youtube_short_player_view);
            this.youtubePlayerView = (WebView) findViewById(R.id.youtube_player_view);
            String stringExtra = getIntent().getStringExtra("url");
            Intrinsics.checkNotNull(stringExtra);
            this.url = stringExtra;
            this.des = getIntent().getStringExtra("des");
            this.isYoutube = getIntent().getStringExtra("isYoutube");
            String stringExtra2 = getIntent().getStringExtra("view_type");
            if (stringExtra2 != null) {
                this.view_type = stringExtra2;
            }
            String str = this.des;
            if (str != null) {
                descriptionCheck(str);
            }
            this.trackSelectorParameters = new DefaultTrackSelector.ParametersBuilder().build();
            initFullscreenButton();
            initFullscreenDialog();
            ImageButton imageButton = this.exo_ffwd;
            if (imageButton != null) {
                imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedVideoPlayer.onCreate$lambda$2(this.f$0, view);
                    }
                });
            }
            ImageButton imageButton2 = this.exo_rew;
            if (imageButton2 != null) {
                imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedVideoPlayer.onCreate$lambda$3(this.f$0, view);
                    }
                });
            }
            if (StringsKt.equals$default(this.isYoutube, "0", false, 2, null)) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                ConstraintLayout constraintLayout = this.rootView;
                if (constraintLayout != null) {
                    constraintLayout.setLayoutParams(layoutParams);
                }
            } else if (StringsKt.equals$default(this.isYoutube, "2", false, 2, null)) {
                getWindow().clearFlags(1024);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) ((((getResources().getConfiguration().screenLayout & 15) == 3 ? 350 : (getResources().getConfiguration().screenLayout & 15) == 4 ? 450 : 250) * getResources().getDisplayMetrics().density) + 0.5f));
                ConstraintLayout constraintLayout2 = this.rootView;
                if (constraintLayout2 != null) {
                    constraintLayout2.setLayoutParams(layoutParams2);
                }
            } else {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
                ConstraintLayout constraintLayout3 = this.rootView;
                if (constraintLayout3 != null) {
                    constraintLayout3.setLayoutParams(layoutParams3);
                }
            }
            if (StringsKt.equals$default(this.view_type, "2", false, 2, null)) {
                FrameLayout frameLayout = this.mFullScreenButton;
                Intrinsics.checkNotNull(frameLayout);
                frameLayout.setVisibility(8);
                PlayerView playerView = this.exoPlayer;
                ViewGroup.LayoutParams layoutParams4 = playerView != null ? playerView.getLayoutParams() : null;
                Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams4).dimensionRatio = "9:16";
            } else if (StringsKt.equals$default(this.isYoutube, "0", false, 2, null)) {
                try {
                    final Context applicationContext = getApplicationContext();
                    new OrientationEventListener(applicationContext) { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer$onCreate$orientationEventListener$1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int orientation) {
                            try {
                                if (Settings.System.getInt(this.this$0.getContentResolver(), "accelerometer_rotation", 0) == 1) {
                                    boolean zIsPortrait = this.this$0.isPortrait(orientation);
                                    if (zIsPortrait || this.this$0.savedOrientation != 1) {
                                        if (zIsPortrait && this.this$0.savedOrientation == 0) {
                                            this.this$0.savedOrientation = 1;
                                            this.this$0.setRequestedOrientation(2);
                                            return;
                                        }
                                        return;
                                    }
                                    this.this$0.savedOrientation = 0;
                                    this.this$0.setRequestedOrientation(2);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }.enable();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                Helper.showProgressDialog(this);
            }
            this.loadControl = new DefaultLoadControl.Builder().setAllocator(new DefaultAllocator(true, 16)).setBufferDurationsMs(20000, 20000, 1500, 1500).setTargetBufferBytes(-1).setPrioritizeTimeOverSizeThresholds(true).build();
            if (StringsKt.equals(this.isYoutube, "1", true)) {
                PlayerView playerView2 = this.exoPlayer;
                if (playerView2 != null) {
                    playerView2.setVisibility(8);
                }
                WebView webView = this.youtubeShortPlayerView;
                if (webView != null) {
                    webView.setVisibility(0);
                }
                ProgressBar progressBar = this.progressBar;
                Intrinsics.checkNotNull(progressBar);
                progressBar.setVisibility(8);
                WebView webView2 = this.youtubePlayerView;
                Intrinsics.checkNotNull(webView2);
                webView2.setVisibility(8);
                initShortPlayerWebView();
                return;
            }
            if (StringsKt.equals(this.isYoutube, "2", true)) {
                PlayerView playerView3 = this.exoPlayer;
                if (playerView3 != null) {
                    playerView3.setVisibility(8);
                }
                WebView webView3 = this.youtubePlayerView;
                if (webView3 != null) {
                    webView3.setVisibility(0);
                }
                WebView webView4 = this.youtubeShortPlayerView;
                if (webView4 != null) {
                    webView4.setVisibility(8);
                }
                ProgressBar progressBar2 = this.progressBar;
                Intrinsics.checkNotNull(progressBar2);
                progressBar2.setVisibility(8);
                initPlayerWebView();
                return;
            }
            PlayerView playerView4 = this.exoPlayer;
            if (playerView4 != null) {
                playerView4.setVisibility(0);
            }
            WebView webView5 = this.youtubeShortPlayerView;
            if (webView5 != null) {
                webView5.setVisibility(8);
            }
            WebView webView6 = this.youtubePlayerView;
            if (webView6 != null) {
                webView6.setVisibility(8);
            }
            ProgressBar progressBar3 = this.progressBar;
            Intrinsics.checkNotNull(progressBar3);
            progressBar3.setVisibility(0);
            setExoPlayer();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(FeedVideoPlayer feedVideoPlayer, View view) {
        long j = 10000;
        if (feedVideoPlayer.getPlayer().getCurrentPosition() < feedVideoPlayer.getPlayer().getDuration() - j) {
            feedVideoPlayer.getPlayer().seekTo(feedVideoPlayer.getPlayer().getCurrentPosition() + j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(FeedVideoPlayer feedVideoPlayer, View view) {
        if (feedVideoPlayer.getPlayer().getCurrentPosition() > 10000) {
            feedVideoPlayer.getPlayer().seekTo(feedVideoPlayer.getPlayer().getCurrentPosition() - ((long) 10000));
        }
    }

    private final void initPlayerWebView() {
        YTubePlayerView yTubePlayerView = new YTubePlayerView(this);
        this.yTubePlayerView = yTubePlayerView;
        Intrinsics.checkNotNull(yTubePlayerView);
        yTubePlayerView.setInstanseOfActivity(this);
        this.webView = this.youtubePlayerView;
        WebView webView = this.webView;
        Intrinsics.checkNotNull(webView);
        webView.setLayerType(2, null);
        WebView webView2 = this.webView;
        Intrinsics.checkNotNull(webView2);
        webView2.setWebViewClient(new PlayerWebViewClient());
        WebView webView3 = this.webView;
        Intrinsics.checkNotNull(webView3);
        webView3.loadUrl(this.url);
    }

    private final void setExoPlayer() {
        FeedVideoPlayer feedVideoPlayer = this;
        setPlayer(new ExoPlayer.Builder(feedVideoPlayer).setSeekBackIncrementMs(10000L).setSeekForwardIncrementMs(10000L).build());
        PlayerView playerView = this.exoPlayer;
        Intrinsics.checkNotNull(playerView);
        playerView.setPlayer(getPlayer());
        MediaItem mediaItemFromUri = MediaItem.fromUri(this.url);
        Intrinsics.checkNotNullExpressionValue(mediaItemFromUri, "fromUri(...)");
        getPlayer().setMediaItem(mediaItemFromUri);
        getPlayer().prepare();
        getPlayer().play();
        getPlayer().seekTo(this.playPosition);
        getPlayer().addListener(new Player.Listener() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer.setExoPlayer.1
            @Override // androidx.media3.common.Player.Listener
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                if (playbackState == 3) {
                    ProgressBar progressBar = FeedVideoPlayer.this.getProgressBar();
                    Intrinsics.checkNotNull(progressBar);
                    progressBar.setVisibility(8);
                }
                if (playbackState == 2) {
                    ProgressBar progressBar2 = FeedVideoPlayer.this.getProgressBar();
                    Intrinsics.checkNotNull(progressBar2);
                    progressBar2.setVisibility(0);
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackStateChanged(int playbackState) {
                super.onPlaybackStateChanged(playbackState);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
                super.onPlayWhenReadyChanged(playWhenReady, reason);
            }
        });
        Object systemService = getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        if (((AudioManager) systemService).isWiredHeadsetOn()) {
            new MediaSession.Builder(feedVideoPlayer, getPlayer());
        } else {
            new MediaSession.Builder(feedVideoPlayer, getPlayer());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isPause = true;
        if (StringsKt.equals$default(this.isYoutube, "0", false, 2, null)) {
            if (this.player != null) {
                if (getPlayer().isPlaying()) {
                    getPlayer().pause();
                }
                getPlayer().setPlayWhenReady(false);
                return;
            }
            return;
        }
        if (StringsKt.equals$default(this.isYoutube, "1", false, 2, null)) {
            YTubePlayerViewShorts yTubePlayerViewShorts = this.yTubeShortPlayerView;
            if (yTubePlayerViewShorts != null) {
                try {
                    Intrinsics.checkNotNull(yTubePlayerViewShorts);
                    yTubePlayerViewShorts.loadUrl("about:blank");
                    YTubePlayerViewShorts yTubePlayerViewShorts2 = this.yTubeShortPlayerView;
                    Intrinsics.checkNotNull(yTubePlayerViewShorts2);
                    yTubePlayerViewShorts2.clearHistory();
                    YTubePlayerViewShorts yTubePlayerViewShorts3 = this.yTubeShortPlayerView;
                    Intrinsics.checkNotNull(yTubePlayerViewShorts3);
                    yTubePlayerViewShorts3.stopLoading();
                    YTubePlayerViewShorts yTubePlayerViewShorts4 = this.yTubeShortPlayerView;
                    Intrinsics.checkNotNull(yTubePlayerViewShorts4);
                    yTubePlayerViewShorts4.clearCache(true);
                    YTubePlayerViewShorts yTubePlayerViewShorts5 = this.yTubeShortPlayerView;
                    Intrinsics.checkNotNull(yTubePlayerViewShorts5);
                    yTubePlayerViewShorts5.clearView();
                    YTubePlayerViewShorts yTubePlayerViewShorts6 = this.yTubeShortPlayerView;
                    Intrinsics.checkNotNull(yTubePlayerViewShorts6);
                    yTubePlayerViewShorts6.freeMemory();
                    YTubePlayerViewShorts yTubePlayerViewShorts7 = this.yTubeShortPlayerView;
                    Intrinsics.checkNotNull(yTubePlayerViewShorts7);
                    yTubePlayerViewShorts7.destroy();
                    WebView webView = this.webView;
                    Intrinsics.checkNotNull(webView);
                    webView.loadUrl("about:blank");
                    WebView webView2 = this.webView;
                    Intrinsics.checkNotNull(webView2);
                    webView2.clearHistory();
                    WebView webView3 = this.webView;
                    Intrinsics.checkNotNull(webView3);
                    webView3.stopLoading();
                    WebView webView4 = this.webView;
                    Intrinsics.checkNotNull(webView4);
                    webView4.clearCache(true);
                    WebView webView5 = this.webView;
                    Intrinsics.checkNotNull(webView5);
                    webView5.clearView();
                    WebView webView6 = this.webView;
                    Intrinsics.checkNotNull(webView6);
                    webView6.freeMemory();
                    this.webView = null;
                    return;
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                    return;
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    return;
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                    return;
                } catch (NoSuchMethodException e5) {
                    e5.printStackTrace();
                    return;
                } catch (SecurityException e6) {
                    e6.printStackTrace();
                    return;
                } catch (InvocationTargetException e7) {
                    e7.printStackTrace();
                    return;
                }
            }
            return;
        }
        try {
            YTubePlayerView yTubePlayerView = this.yTubePlayerView;
            if (yTubePlayerView != null) {
                try {
                    try {
                        try {
                            try {
                                Intrinsics.checkNotNull(yTubePlayerView);
                                yTubePlayerView.loadUrl("about:blank");
                                YTubePlayerView yTubePlayerView2 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView2);
                                yTubePlayerView2.clearHistory();
                                YTubePlayerView yTubePlayerView3 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView3);
                                yTubePlayerView3.stopLoading();
                                YTubePlayerView yTubePlayerView4 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView4);
                                yTubePlayerView4.clearCache(true);
                                YTubePlayerView yTubePlayerView5 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView5);
                                yTubePlayerView5.clearView();
                                YTubePlayerView yTubePlayerView6 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView6);
                                yTubePlayerView6.freeMemory();
                                YTubePlayerView yTubePlayerView7 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView7);
                                yTubePlayerView7.destroy();
                                WebView webView7 = this.webView;
                                Intrinsics.checkNotNull(webView7);
                                webView7.loadUrl("about:blank");
                                WebView webView8 = this.webView;
                                Intrinsics.checkNotNull(webView8);
                                webView8.clearHistory();
                                WebView webView9 = this.webView;
                                Intrinsics.checkNotNull(webView9);
                                webView9.stopLoading();
                                WebView webView10 = this.webView;
                                Intrinsics.checkNotNull(webView10);
                                webView10.clearCache(true);
                                WebView webView11 = this.webView;
                                Intrinsics.checkNotNull(webView11);
                                webView11.clearView();
                                WebView webView12 = this.webView;
                                Intrinsics.checkNotNull(webView12);
                                webView12.freeMemory();
                                this.webView = null;
                            } catch (SecurityException e8) {
                                e8.printStackTrace();
                            }
                        } catch (IllegalAccessException e9) {
                            e9.printStackTrace();
                        }
                    } catch (IllegalArgumentException e10) {
                        e10.printStackTrace();
                    } catch (InvocationTargetException e11) {
                        e11.printStackTrace();
                    }
                } catch (ClassNotFoundException e12) {
                    e12.printStackTrace();
                } catch (NoSuchMethodException e13) {
                    e13.printStackTrace();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.player != null) {
            if (!getPlayer().isPlaying()) {
                getPlayer().play();
            }
            getPlayer().setPlayWhenReady(true);
            return;
        }
        if (this.isPause) {
            this.isPause = false;
            Helper.showProgressDialog(this);
            if (StringsKt.equals(this.isYoutube, "1", true)) {
                PlayerView playerView = this.exoPlayer;
                if (playerView != null) {
                    playerView.setVisibility(8);
                }
                WebView webView = this.youtubeShortPlayerView;
                if (webView != null) {
                    webView.setVisibility(0);
                }
                ProgressBar progressBar = this.progressBar;
                Intrinsics.checkNotNull(progressBar);
                progressBar.setVisibility(8);
                WebView webView2 = this.youtubePlayerView;
                Intrinsics.checkNotNull(webView2);
                webView2.setVisibility(8);
                initShortPlayerWebView();
                return;
            }
            if (StringsKt.equals(this.isYoutube, "2", true)) {
                PlayerView playerView2 = this.exoPlayer;
                if (playerView2 != null) {
                    playerView2.setVisibility(8);
                }
                WebView webView3 = this.youtubePlayerView;
                if (webView3 != null) {
                    webView3.setVisibility(0);
                }
                WebView webView4 = this.youtubeShortPlayerView;
                if (webView4 != null) {
                    webView4.setVisibility(8);
                }
                ProgressBar progressBar2 = this.progressBar;
                Intrinsics.checkNotNull(progressBar2);
                progressBar2.setVisibility(8);
                initPlayerWebView();
            }
        }
    }

    public final void descriptionCheck(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.length() == 0) {
            getDescritption().setVisibility(8);
            return;
        }
        getDescritption().setVisibility(0);
        RelativeLayout relativeLayout = this.data_layout;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.setVisibility(0);
        Spanned spannedFromHtml = Html.fromHtml(it, 0, this, null);
        this.htmldata = spannedFromHtml;
        if (spannedFromHtml != null) {
            Intrinsics.checkNotNull(spannedFromHtml);
            if (spannedFromHtml.length() > 200) {
                getDescritption().setVisibility(0);
                TextView descritption = getDescritption();
                Spanned spanned = this.htmldata;
                Intrinsics.checkNotNull(spanned);
                descritption.setText(spanned.subSequence(0, 200).toString() + "...");
                getReadmore().setVisibility(0);
            } else {
                getDescritption().setText(this.htmldata);
                getReadmore().setVisibility(8);
            }
        }
        getDescritption().setMovementMethod(LinkMovementMethod.getInstance());
        getReadmore().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoPlayer.descriptionCheck$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void descriptionCheck$lambda$5(FeedVideoPlayer feedVideoPlayer, View view) {
        if (feedVideoPlayer.getReadmore().getText().equals("Read More")) {
            feedVideoPlayer.getDescritption().setText(feedVideoPlayer.htmldata);
            feedVideoPlayer.getReadmore().setText("Read Less");
            return;
        }
        TextView descritption = feedVideoPlayer.getDescritption();
        Spanned spanned = feedVideoPlayer.htmldata;
        Intrinsics.checkNotNull(spanned);
        descritption.setText(spanned.subSequence(0, 200).toString() + "...");
        feedVideoPlayer.getReadmore().setText("Read More");
    }

    private final void initFullscreenButton() {
        this.newOrientation = getResources().getConfiguration().orientation;
        PlayerView playerView = this.exoPlayer;
        Intrinsics.checkNotNull(playerView);
        View viewFindViewById = playerView.findViewById(R.id.exo_controller);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        PlayerControlView playerControlView = (PlayerControlView) viewFindViewById;
        this.mFullScreenIcon = (ImageView) playerControlView.findViewById(R.id.exo_fullscreen_icon);
        TextView textView = (TextView) playerControlView.findViewById(R.id.speedTV);
        this.speedTV = textView;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(0);
        this.tvGoLive = (TextView) playerControlView.findViewById(R.id.tv_go_live);
        this.quality = (ImageView) playerControlView.findViewById(R.id.quality);
        ImageView imageView = (ImageView) playerControlView.findViewById(R.id.icon);
        this.icon = imageView;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(8);
        ImageView imageView2 = this.quality;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setVisibility(8);
        ImageView imageView3 = this.icon;
        Intrinsics.checkNotNull(imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoPlayer.initFullscreenButton$lambda$6(this.f$0, view);
            }
        });
        TextView textView2 = this.speedTV;
        if (textView2 != null) {
            Intrinsics.checkNotNull(textView2);
            textView2.setText(Const.Normal);
            TextView textView3 = this.speedTV;
            Intrinsics.checkNotNull(textView3);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.showSpeedOptions();
                }
            });
        }
        if (!TextUtils.isEmpty(this.speedx)) {
            ExoPlayer player = getPlayer();
            Float fValueOf = Float.valueOf(StringsKt.replace$default(this.speedx, "x", "", false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(...)");
            player.setPlaybackParameters(new PlaybackParameters(fValueOf.floatValue(), 1.0f));
        }
        FrameLayout frameLayout = (FrameLayout) playerControlView.findViewById(R.id.exo_fullscreen_button);
        this.mFullScreenButton = frameLayout;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoPlayer.initFullscreenButton$lambda$8(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFullscreenButton$lambda$6(FeedVideoPlayer feedVideoPlayer, View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new PowerMenuItem((CharSequence) (Intrinsics.areEqual(feedVideoPlayer.spped_title, "") ? Const.Normal : feedVideoPlayer.spped_title), false));
        FeedVideoPlayer feedVideoPlayer2 = feedVideoPlayer;
        PowerMenu powerMenuBuild = new PowerMenu.Builder(feedVideoPlayer2).addItemList(arrayList).setAnimation(MenuAnimation.SHOWUP_BOTTOM_RIGHT).setMenuRadius(10.0f).setMenuShadow(10.0f).setWidth(feedVideoPlayer.getResources().getDisplayMetrics().widthPixels / 4).setTextColor(feedVideoPlayer.getResources().getColor(R.color.blackApp)).setMenuColor(-1).setDivider(new ColorDrawable(ContextCompat.getColor(feedVideoPlayer2, R.color.blackApp))).setDividerHeight(2).setSelectedTextColor(-1).setSelectedMenuColor(ContextCompat.getColor(feedVideoPlayer2, R.color.colorPrimary)).setOnMenuItemClickListener(feedVideoPlayer.onIconMenuItemClickListener).build();
        feedVideoPlayer.powerMenu = powerMenuBuild;
        Intrinsics.checkNotNull(powerMenuBuild);
        powerMenuBuild.showAsAnchorRightBottom(feedVideoPlayer.icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFullscreenButton$lambda$8(FeedVideoPlayer feedVideoPlayer, View view) {
        if (feedVideoPlayer.mExoPlayerFullscreen) {
            feedVideoPlayer.closeFullscreenDialog();
        } else {
            feedVideoPlayer.openFullscreenDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSpeedOptions() {
        String[] stringArray;
        PopupMenu popupMenu = new PopupMenu(this, this.speedTV, R.style.MyPopupMenu);
        Menu menu = popupMenu.getMenu();
        if (StringsKt.equals(SharedPreference.getInstance().getString(Const.MAX_SPEED), "1", true)) {
            stringArray = getResources().getStringArray(R.array.speed_values_max);
            Intrinsics.checkNotNull(stringArray);
        } else {
            stringArray = getResources().getStringArray(R.array.speed_values);
            Intrinsics.checkNotNull(stringArray);
        }
        if (stringArray.length != 0) {
            for (String str : stringArray) {
                if (StringsKt.equals(str, "1", true)) {
                    menu.add(Const.Normal);
                } else {
                    menu.add(str + "x");
                }
            }
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer$$ExternalSyntheticLambda1
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return FeedVideoPlayer.showSpeedOptions$lambda$9(this.f$0, menuItem);
                }
            });
            popupMenu.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showSpeedOptions$lambda$9(FeedVideoPlayer feedVideoPlayer, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        feedVideoPlayer.spped_title = String.valueOf(item.getTitle());
        if (feedVideoPlayer.getPlayer() == null || feedVideoPlayer.player == null) {
            return false;
        }
        if (StringsKt.equals(feedVideoPlayer.spped_title, Const.Normal, true)) {
            ExoPlayer player = feedVideoPlayer.getPlayer();
            Float fValueOf = Float.valueOf("1");
            Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(...)");
            player.setPlaybackParameters(new PlaybackParameters(fValueOf.floatValue(), 1.0f));
        } else {
            ExoPlayer player2 = feedVideoPlayer.getPlayer();
            Float fValueOf2 = Float.valueOf(StringsKt.replace$default(feedVideoPlayer.spped_title, "x", "", false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(fValueOf2, "valueOf(...)");
            player2.setPlaybackParameters(new PlaybackParameters(fValueOf2.floatValue(), 1.0f));
        }
        TextView textView = feedVideoPlayer.speedTV;
        Intrinsics.checkNotNull(textView);
        textView.setText(feedVideoPlayer.spped_title);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onIconMenuItemClickListener$lambda$10(FeedVideoPlayer feedVideoPlayer, int i, PowerMenuItem powerMenuItem) {
        feedVideoPlayer.showSpeedOptions();
        PowerMenu powerMenu = feedVideoPlayer.powerMenu;
        Intrinsics.checkNotNull(powerMenu);
        powerMenu.dismiss();
    }

    private final void openFullscreenDialog() {
        ImageView imageView = this.mFullScreenIcon;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, 2131231273));
        this.mExoPlayerFullscreen = true;
        int i = this.newOrientation;
        if (i == 1) {
            setRequestedOrientation(0);
        } else if (i == 2) {
            setRequestedOrientation(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeFullscreenDialog() {
        this.mExoPlayerFullscreen = false;
        setRequestedOrientation(1);
        ImageView imageView = this.mFullScreenIcon;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
    }

    private final void initFullscreenDialog() {
        this.mFullScreenDialog = new Dialog() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer.initFullscreenDialog.1
            {
                super(FeedVideoPlayer.this, android.R.style.Theme.Black.NoTitleBar.Fullscreen);
            }

            @Override // android.app.Dialog
            public void onBackPressed() {
                if (FeedVideoPlayer.this.mExoPlayerFullscreen) {
                    FeedVideoPlayer.this.closeFullscreenDialog();
                }
                super.onBackPressed();
            }
        };
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (StringsKt.equals$default(this.isYoutube, "1", false, 2, null) || StringsKt.equals$default(this.isYoutube, "2", false, 2, null)) {
            return;
        }
        try {
            this.newOrientation = newConfig.orientation;
            if (newConfig.orientation == 1) {
                this.mExoPlayerFullscreen = false;
                ImageView imageView = this.mFullScreenIcon;
                Intrinsics.checkNotNull(imageView);
                imageView.setImageDrawable(ContextCompat.getDrawable(this, 2131231272));
                Spanned spanned = this.htmldata;
                if (spanned != null) {
                    Intrinsics.checkNotNull(spanned);
                    if (spanned.length() > 0) {
                        RelativeLayout relativeLayout = this.data_layout;
                        Intrinsics.checkNotNull(relativeLayout);
                        relativeLayout.setVisibility(0);
                    }
                }
                getWindow().clearFlags(1024);
                int i = (int) ((((getResources().getConfiguration().screenLayout & 15) == 3 ? 350 : (getResources().getConfiguration().screenLayout & 15) == 4 ? 450 : 230) * getResources().getDisplayMetrics().density) + 0.5f);
                PlayerView playerView = this.exoPlayer;
                if (playerView != null) {
                    playerView.setLayoutParams(new ConstraintLayout.LayoutParams(-1, i));
                    return;
                }
                return;
            }
            this.mExoPlayerFullscreen = true;
            ImageView imageView2 = this.mFullScreenIcon;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setImageDrawable(ContextCompat.getDrawable(this, 2131231273));
            getWindow().setFlags(1024, 1024);
            RelativeLayout relativeLayout2 = this.data_layout;
            Intrinsics.checkNotNull(relativeLayout2);
            relativeLayout2.setVisibility(8);
            PlayerView playerView2 = this.exoPlayer;
            if (playerView2 != null) {
                playerView2.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getResources().getConfiguration().orientation == 2) {
            closeFullscreenDialog();
            return;
        }
        try {
            if (StringsKt.equals$default(this.isYoutube, "0", false, 2, null)) {
                if (getPlayer() != null) {
                    getPlayer().release();
                }
            } else if (StringsKt.equals$default(this.isYoutube, "1", false, 2, null)) {
                YTubePlayerViewShorts yTubePlayerViewShorts = this.yTubeShortPlayerView;
                if (yTubePlayerViewShorts != null) {
                    try {
                        try {
                            try {
                                Intrinsics.checkNotNull(yTubePlayerViewShorts);
                                yTubePlayerViewShorts.loadUrl("about:blank");
                                YTubePlayerViewShorts yTubePlayerViewShorts2 = this.yTubeShortPlayerView;
                                Intrinsics.checkNotNull(yTubePlayerViewShorts2);
                                yTubePlayerViewShorts2.clearHistory();
                                YTubePlayerViewShorts yTubePlayerViewShorts3 = this.yTubeShortPlayerView;
                                Intrinsics.checkNotNull(yTubePlayerViewShorts3);
                                yTubePlayerViewShorts3.stopLoading();
                                YTubePlayerViewShorts yTubePlayerViewShorts4 = this.yTubeShortPlayerView;
                                Intrinsics.checkNotNull(yTubePlayerViewShorts4);
                                yTubePlayerViewShorts4.clearCache(true);
                                YTubePlayerViewShorts yTubePlayerViewShorts5 = this.yTubeShortPlayerView;
                                Intrinsics.checkNotNull(yTubePlayerViewShorts5);
                                yTubePlayerViewShorts5.clearView();
                                YTubePlayerViewShorts yTubePlayerViewShorts6 = this.yTubeShortPlayerView;
                                Intrinsics.checkNotNull(yTubePlayerViewShorts6);
                                yTubePlayerViewShorts6.freeMemory();
                                YTubePlayerViewShorts yTubePlayerViewShorts7 = this.yTubeShortPlayerView;
                                Intrinsics.checkNotNull(yTubePlayerViewShorts7);
                                yTubePlayerViewShorts7.destroy();
                                WebView webView = this.webView;
                                Intrinsics.checkNotNull(webView);
                                webView.loadUrl("about:blank");
                                WebView webView2 = this.webView;
                                Intrinsics.checkNotNull(webView2);
                                webView2.clearHistory();
                                WebView webView3 = this.webView;
                                Intrinsics.checkNotNull(webView3);
                                webView3.stopLoading();
                                this.yTubeShortPlayerView = null;
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            } catch (SecurityException e3) {
                                e3.printStackTrace();
                            }
                        } catch (NoSuchMethodException e4) {
                            e4.printStackTrace();
                        } catch (InvocationTargetException e5) {
                            e5.printStackTrace();
                        }
                    } catch (ClassNotFoundException e6) {
                        e6.printStackTrace();
                    } catch (IllegalArgumentException e7) {
                        e7.printStackTrace();
                    }
                }
            } else {
                YTubePlayerView yTubePlayerView = this.yTubePlayerView;
                if (yTubePlayerView != null) {
                    try {
                        try {
                            try {
                                Intrinsics.checkNotNull(yTubePlayerView);
                                yTubePlayerView.loadUrl("about:blank");
                                YTubePlayerView yTubePlayerView2 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView2);
                                yTubePlayerView2.clearHistory();
                                YTubePlayerView yTubePlayerView3 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView3);
                                yTubePlayerView3.stopLoading();
                                YTubePlayerView yTubePlayerView4 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView4);
                                yTubePlayerView4.clearCache(true);
                                YTubePlayerView yTubePlayerView5 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView5);
                                yTubePlayerView5.clearView();
                                YTubePlayerView yTubePlayerView6 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView6);
                                yTubePlayerView6.freeMemory();
                                YTubePlayerView yTubePlayerView7 = this.yTubePlayerView;
                                Intrinsics.checkNotNull(yTubePlayerView7);
                                yTubePlayerView7.destroy();
                                WebView webView4 = this.webView;
                                Intrinsics.checkNotNull(webView4);
                                webView4.loadUrl("about:blank");
                                WebView webView5 = this.webView;
                                Intrinsics.checkNotNull(webView5);
                                webView5.clearHistory();
                                WebView webView6 = this.webView;
                                Intrinsics.checkNotNull(webView6);
                                webView6.stopLoading();
                                this.yTubePlayerView = null;
                            } catch (ClassNotFoundException e8) {
                                e8.printStackTrace();
                            } catch (SecurityException e9) {
                                e9.printStackTrace();
                            }
                        } catch (IllegalAccessException e10) {
                            e10.printStackTrace();
                        } catch (NoSuchMethodException e11) {
                            e11.printStackTrace();
                        }
                    } catch (IllegalArgumentException e12) {
                        e12.printStackTrace();
                    } catch (InvocationTargetException e13) {
                        e13.printStackTrace();
                    }
                }
            }
        } catch (Exception unused) {
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (StringsKt.equals$default(this.isYoutube, "0", false, 2, null)) {
            if (getPlayer() == null || this.player == null) {
                return;
            }
            getPlayer().stop();
            getPlayer().release();
            return;
        }
        if (StringsKt.equals$default(this.isYoutube, "1", false, 2, null)) {
            YTubePlayerViewShorts yTubePlayerViewShorts = this.yTubeShortPlayerView;
            if (yTubePlayerViewShorts != null) {
                try {
                    try {
                        try {
                            Intrinsics.checkNotNull(yTubePlayerViewShorts);
                            yTubePlayerViewShorts.loadUrl("about:blank");
                            YTubePlayerViewShorts yTubePlayerViewShorts2 = this.yTubeShortPlayerView;
                            Intrinsics.checkNotNull(yTubePlayerViewShorts2);
                            yTubePlayerViewShorts2.clearHistory();
                            YTubePlayerViewShorts yTubePlayerViewShorts3 = this.yTubeShortPlayerView;
                            Intrinsics.checkNotNull(yTubePlayerViewShorts3);
                            yTubePlayerViewShorts3.stopLoading();
                            YTubePlayerViewShorts yTubePlayerViewShorts4 = this.yTubeShortPlayerView;
                            Intrinsics.checkNotNull(yTubePlayerViewShorts4);
                            yTubePlayerViewShorts4.clearCache(true);
                            YTubePlayerViewShorts yTubePlayerViewShorts5 = this.yTubeShortPlayerView;
                            Intrinsics.checkNotNull(yTubePlayerViewShorts5);
                            yTubePlayerViewShorts5.clearView();
                            YTubePlayerViewShorts yTubePlayerViewShorts6 = this.yTubeShortPlayerView;
                            Intrinsics.checkNotNull(yTubePlayerViewShorts6);
                            yTubePlayerViewShorts6.freeMemory();
                            YTubePlayerViewShorts yTubePlayerViewShorts7 = this.yTubeShortPlayerView;
                            Intrinsics.checkNotNull(yTubePlayerViewShorts7);
                            yTubePlayerViewShorts7.destroy();
                            WebView webView = this.webView;
                            Intrinsics.checkNotNull(webView);
                            webView.loadUrl("about:blank");
                            WebView webView2 = this.webView;
                            Intrinsics.checkNotNull(webView2);
                            webView2.clearHistory();
                            WebView webView3 = this.webView;
                            Intrinsics.checkNotNull(webView3);
                            webView3.stopLoading();
                            this.yTubeShortPlayerView = null;
                            return;
                        } catch (NoSuchMethodException e2) {
                            e2.printStackTrace();
                            return;
                        } catch (SecurityException e3) {
                            e3.printStackTrace();
                            return;
                        }
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                        return;
                    } catch (InvocationTargetException e5) {
                        e5.printStackTrace();
                        return;
                    }
                } catch (ClassNotFoundException e6) {
                    e6.printStackTrace();
                    return;
                } catch (IllegalArgumentException e7) {
                    e7.printStackTrace();
                    return;
                }
            }
            return;
        }
        YTubePlayerView yTubePlayerView = this.yTubePlayerView;
        if (yTubePlayerView != null) {
            try {
                try {
                    try {
                        Intrinsics.checkNotNull(yTubePlayerView);
                        yTubePlayerView.loadUrl("about:blank");
                        YTubePlayerView yTubePlayerView2 = this.yTubePlayerView;
                        Intrinsics.checkNotNull(yTubePlayerView2);
                        yTubePlayerView2.clearHistory();
                        YTubePlayerView yTubePlayerView3 = this.yTubePlayerView;
                        Intrinsics.checkNotNull(yTubePlayerView3);
                        yTubePlayerView3.stopLoading();
                        YTubePlayerView yTubePlayerView4 = this.yTubePlayerView;
                        Intrinsics.checkNotNull(yTubePlayerView4);
                        yTubePlayerView4.clearCache(true);
                        YTubePlayerView yTubePlayerView5 = this.yTubePlayerView;
                        Intrinsics.checkNotNull(yTubePlayerView5);
                        yTubePlayerView5.clearView();
                        YTubePlayerView yTubePlayerView6 = this.yTubePlayerView;
                        Intrinsics.checkNotNull(yTubePlayerView6);
                        yTubePlayerView6.freeMemory();
                        YTubePlayerView yTubePlayerView7 = this.yTubePlayerView;
                        Intrinsics.checkNotNull(yTubePlayerView7);
                        yTubePlayerView7.destroy();
                        WebView webView4 = this.webView;
                        Intrinsics.checkNotNull(webView4);
                        webView4.loadUrl("about:blank");
                        WebView webView5 = this.webView;
                        Intrinsics.checkNotNull(webView5);
                        webView5.clearHistory();
                        WebView webView6 = this.webView;
                        Intrinsics.checkNotNull(webView6);
                        webView6.stopLoading();
                        this.yTubePlayerView = null;
                    } catch (ClassNotFoundException e8) {
                        e8.printStackTrace();
                    } catch (IllegalArgumentException e9) {
                        e9.printStackTrace();
                    }
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                } catch (NoSuchMethodException e11) {
                    e11.printStackTrace();
                }
            } catch (SecurityException e12) {
                e12.printStackTrace();
            } catch (InvocationTargetException e13) {
                e13.printStackTrace();
            }
        }
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String s) {
        LevelListDrawable levelListDrawable = new LevelListDrawable();
        Drawable drawable = getResources().getDrawable(R.mipmap.course_placeholder);
        levelListDrawable.addLevel(0, 0, drawable);
        levelListDrawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(s, levelListDrawable, this, null), 3, null);
        return levelListDrawable;
    }

    /* JADX INFO: renamed from: com.appnew.android.feeds.activity.FeedVideoPlayer$getDrawable$1, reason: invalid class name */
    /* JADX INFO: compiled from: FeedVideoPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.feeds.activity.FeedVideoPlayer$getDrawable$1", f = "FeedVideoPlayer.kt", i = {}, l = {920}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LevelListDrawable $d;
        final /* synthetic */ String $s;
        int label;
        final /* synthetic */ FeedVideoPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, LevelListDrawable levelListDrawable, FeedVideoPlayer feedVideoPlayer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$s = str;
            this.$d = levelListDrawable;
            this.this$0 = feedVideoPlayer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$s, this.$d, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new URL(this.$s).openStream());
                    if (bitmapDecodeStream != null) {
                        this.$d.addLevel(1, 1, new BitmapDrawable(bitmapDecodeStream));
                        this.$d.setBounds(0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                        this.$d.setLevel(1);
                        this.label = 1;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C01101(this.this$0, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (MalformedURLException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.appnew.android.feeds.activity.FeedVideoPlayer$getDrawable$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FeedVideoPlayer.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.appnew.android.feeds.activity.FeedVideoPlayer$getDrawable$1$1", f = "FeedVideoPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ FeedVideoPlayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01101(FeedVideoPlayer feedVideoPlayer, Continuation<? super C01101> continuation) {
                super(2, continuation);
                this.this$0 = feedVideoPlayer;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01101(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                TextView descritption = this.this$0.getDescritption();
                Intrinsics.checkNotNull(descritption);
                CharSequence text = descritption.getText();
                TextView descritption2 = this.this$0.getDescritption();
                Intrinsics.checkNotNull(descritption2);
                descritption2.setText(text);
                return Unit.INSTANCE;
            }
        }
    }

    private final void initShortPlayerWebView() {
        FeedVideoPlayer feedVideoPlayer = this;
        YTubePlayerViewShorts yTubePlayerViewShorts = new YTubePlayerViewShorts(feedVideoPlayer);
        this.yTubeShortPlayerView = yTubePlayerViewShorts;
        Intrinsics.checkNotNull(yTubePlayerViewShorts);
        yTubePlayerViewShorts.setInstanseOfActivity(this);
        this.webView = this.youtubeShortPlayerView;
        WebView webView = this.webView;
        Intrinsics.checkNotNull(webView);
        webView.setLayerType(2, null);
        WebView webView2 = this.webView;
        Intrinsics.checkNotNull(webView2);
        webView2.setWebViewClient(new ShortPlayerWebViewClient());
        WebView webView3 = this.webView;
        Intrinsics.checkNotNull(webView3);
        webView3.loadUrl(this.url);
        if (StringsKt.equals$default(this.isYoutube, "1", false, 2, null)) {
            this.gestureDetector = new GestureDetector(feedVideoPlayer, new CustomGestureListener());
            WebView webView4 = this.youtubeShortPlayerView;
            if (webView4 != null) {
                webView4.setOnTouchListener(new View.OnTouchListener() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return FeedVideoPlayer.initShortPlayerWebView$lambda$12(this.f$0, view, motionEvent);
                    }
                });
            }
            WebView webView5 = this.webView;
            if (webView5 != null) {
                webView5.setOnTouchListener(new View.OnTouchListener() { // from class: com.appnew.android.feeds.activity.FeedVideoPlayer$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return FeedVideoPlayer.initShortPlayerWebView$lambda$13(this.f$0, view, motionEvent);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initShortPlayerWebView$lambda$12(FeedVideoPlayer feedVideoPlayer, View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector = feedVideoPlayer.gestureDetector;
        Intrinsics.checkNotNull(gestureDetector);
        Intrinsics.checkNotNull(motionEvent);
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initShortPlayerWebView$lambda$13(FeedVideoPlayer feedVideoPlayer, View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector = feedVideoPlayer.gestureDetector;
        Intrinsics.checkNotNull(gestureDetector);
        Intrinsics.checkNotNull(motionEvent);
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 1) {
            event.setAction(3);
            super.onTouchEvent(event);
            event.setAction(0);
            super.onTouchEvent(event);
            event.setAction(1);
        }
        return super.onTouchEvent(event);
    }

    /* JADX INFO: compiled from: FeedVideoPlayer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016¨\u0006\u0015"}, d2 = {"Lcom/appnew/android/feeds/activity/FeedVideoPlayer$PlayerWebViewClient;", "Landroid/webkit/WebViewClient;", "<init>", "(Lcom/appnew/android/feeds/activity/FeedVideoPlayer;)V", "shouldOverrideUrlLoading", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "url", "", "onPageFinished", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "webView", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "", "str", "str2", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class PlayerWebViewClient extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            return true;
        }

        public PlayerWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            WebView webView = FeedVideoPlayer.this.webView;
            if (webView != null) {
                webView.loadUrl("javascript:(function() { document.getElementsByClassName('ytp-play-button ytp-button')[0].click(); })()");
            }
            YTubePlayerView yTubePlayerView = FeedVideoPlayer.this.getYTubePlayerView();
            if (yTubePlayerView != null) {
                yTubePlayerView.hideSomeSectionOfBlog(FeedVideoPlayer.this.webView);
            }
            YTubePlayerView yTubePlayerView2 = FeedVideoPlayer.this.getYTubePlayerView();
            if (yTubePlayerView2 != null) {
                yTubePlayerView2.scheduleHideContent(FeedVideoPlayer.this.webView);
            }
            Helper.dismissProgressDialog();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageStarted(view, url, favicon);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(str, "str");
            Intrinsics.checkNotNullParameter(str2, "str2");
            webView.getSettings();
            webView.loadData("Please try after some time.", Mimetypes.MIMETYPE_HTML, "UTF-8");
        }
    }

    /* JADX INFO: compiled from: FeedVideoPlayer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016¨\u0006\u0015"}, d2 = {"Lcom/appnew/android/feeds/activity/FeedVideoPlayer$ShortPlayerWebViewClient;", "Landroid/webkit/WebViewClient;", "<init>", "(Lcom/appnew/android/feeds/activity/FeedVideoPlayer;)V", "shouldOverrideUrlLoading", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "url", "", "onPageFinished", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "webView", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "", "str", "str2", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ShortPlayerWebViewClient extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            return true;
        }

        public ShortPlayerWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            WebView webView = FeedVideoPlayer.this.webView;
            if (webView != null) {
                webView.loadUrl("javascript:(function() { document.getElementsByClassName('ytp-play-button ytp-button')[0].click(); })()");
            }
            YTubePlayerViewShorts yTubeShortPlayerView = FeedVideoPlayer.this.getYTubeShortPlayerView();
            if (yTubeShortPlayerView != null) {
                yTubeShortPlayerView.hideSomeSectionOfBlog(FeedVideoPlayer.this.webView);
            }
            YTubePlayerViewShorts yTubeShortPlayerView2 = FeedVideoPlayer.this.getYTubeShortPlayerView();
            if (yTubeShortPlayerView2 != null) {
                yTubeShortPlayerView2.scheduleHideContent(FeedVideoPlayer.this.webView);
            }
            Helper.dismissProgressDialog();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageStarted(view, url, favicon);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(str, "str");
            Intrinsics.checkNotNullParameter(str2, "str2");
            webView.getSettings();
            webView.loadData("Please try after some time.", Mimetypes.MIMETYPE_HTML, "UTF-8");
        }
    }

    /* JADX INFO: compiled from: FeedVideoPlayer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/appnew/android/feeds/activity/FeedVideoPlayer$CustomGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/appnew/android/feeds/activity/FeedVideoPlayer;)V", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {
        public CustomGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e2) {
            String url;
            Intrinsics.checkNotNullParameter(e2, "e");
            WebView webView = FeedVideoPlayer.this.webView;
            return (webView == null || (url = webView.getUrl()) == null || !StringsKt.contains$default((CharSequence) url, (CharSequence) "youtube.com", false, 2, (Object) null)) ? false : true;
        }
    }
}
