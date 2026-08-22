package com.appnew.android.Zoom.Activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.ui.PlayerControlView;
import androidx.media3.ui.PlayerView;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Zoom.Activity.ZoomRecodedPlayer;
import com.appnew.android.databinding.ActivityZoomRecodedPlayerBinding;
import com.appnew.android.table.YoutubePlayerTable;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: ZoomRecodedPlayer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010o\u001a\u00020p2\b\u0010q\u001a\u0004\u0018\u00010rH\u0015J\b\u0010s\u001a\u00020pH\u0002J\u0010\u0010t\u001a\u00020p2\u0006\u0010u\u001a\u00020vH\u0016J\b\u0010w\u001a\u00020pH\u0002J\u001a\u0010x\u001a\u00020p2\b\u0010y\u001a\u0004\u0018\u00010\u00072\u0006\u0010z\u001a\u00020\u001dH\u0007J\b\u0010{\u001a\u00020pH\u0014J\b\u0010|\u001a\u00020pH\u0014J\u0012\u0010}\u001a\u00020p2\b\u0010~\u001a\u0004\u0018\u00010#H\u0016J3\u0010\u007f\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0080\u00012\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00072\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J2\u0010\u0085\u0001\u001a\u00020p2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u0088\u0001\u001a\u000204H\u0016J*\u0010\u0089\u0001\u001a\u00020p2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0007H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001c\u00100\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010*\"\u0004\bC\u0010,R\u001a\u0010D\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010*\"\u0004\bF\u0010,R\u001a\u0010G\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010*\"\u0004\bI\u0010,R\u001a\u0010J\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001f\"\u0004\bL\u0010!R\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010S\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020_X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0010\u0010d\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070iX\u0086\u000e¢\u0006\u0010\n\u0002\u0010n\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m¨\u0006\u008a\u0001"}, d2 = {"Lcom/appnew/android/Zoom/Activity/ZoomRecodedPlayer;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "<init>", "()V", "url", "", "playPosition", "", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "binding", "Lcom/appnew/android/databinding/ActivityZoomRecodedPlayerBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityZoomRecodedPlayerBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityZoomRecodedPlayerBinding;)V", "simpleExoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "getSimpleExoPlayer", "()Landroidx/media3/exoplayer/ExoPlayer;", "setSimpleExoPlayer", "(Landroidx/media3/exoplayer/ExoPlayer;)V", "hightrootView", "", "getHightrootView", "()I", "setHightrootView", "(I)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "videoURL", "getVideoURL", "()Ljava/lang/String;", "setVideoURL", "(Ljava/lang/String;)V", Const.VIDEO_ID, "getVideo_id", "setVideo_id", "add_bookmark", "getAdd_bookmark", "setAdd_bookmark", "playerState", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "setSharedPreferences", "(Landroid/content/SharedPreferences;)V", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "bookmarkState", "getBookmarkState", "setBookmarkState", "videoId_value", "getVideoId_value", "setVideoId_value", "islive", "getIslive", "setIslive", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "getI", "setI", "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "state", "getState", "()Z", "setState", "(Z)V", "speedTV", "Landroid/widget/TextView;", "getSpeedTV", "()Landroid/widget/TextView;", "setSpeedTV", "(Landroid/widget/TextView;)V", "fullScreen", "Landroid/widget/ImageView;", "getFullScreen", "()Landroid/widget/ImageView;", "setFullScreen", "(Landroid/widget/ImageView;)V", "mFullScreenIcon", "mExoPlayerFullscreen", "playerView", "Landroidx/media3/ui/PlayerControlView;", TransferTable.COLUMN_SPEED, "", "getSpeed", "()[Ljava/lang/String;", "setSpeed", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setOrientation", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "blink", "playVideo", "uri", "type", "onPause", "onDestroy", "onClick", "v", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonstring", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZoomRecodedPlayer extends AppCompatActivity implements View.OnClickListener, NetworkCall.MyNetworkCallBack {
    public static final int $stable = 8;
    private String add_bookmark;
    public ActivityZoomRecodedPlayerBinding binding;
    private String bookmarkState;
    public SharedPreferences.Editor editor;
    public ImageView fullScreen;
    private int hightrootView;
    private int i;
    private String islive;
    private boolean mExoPlayerFullscreen;
    private ImageView mFullScreenIcon;
    private NetworkCall networkCall;
    private long playPosition;
    private boolean playerState;
    private PlayerControlView playerView;
    private View rootView;
    public SharedPreferences sharedPreferences;
    private ExoPlayer simpleExoPlayer;
    private String[] speed;
    private TextView speedTV;
    private boolean state;
    private String url = "";
    private UtkashRoom utkashRoom;
    private String videoId_value;
    private String videoURL;
    private String video_id;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public static final /* synthetic */ void access$blink(ZoomRecodedPlayer zoomRecodedPlayer) {
        zoomRecodedPlayer.blink();
    }

    public ZoomRecodedPlayer() {
        UtkashRoom appDatabase = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
        Intrinsics.checkNotNullExpressionValue(appDatabase, "getAppDatabase(...)");
        this.utkashRoom = appDatabase;
        this.playerState = true;
        this.bookmarkState = "";
        this.videoId_value = "";
        this.islive = "";
        this.speed = new String[]{"0.25x", "0.5x", Const.Normal, "1.5x", "2x"};
    }

    public final UtkashRoom getUtkashRoom() {
        return this.utkashRoom;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(utkashRoom, "<set-?>");
        this.utkashRoom = utkashRoom;
    }

    public final ActivityZoomRecodedPlayerBinding getBinding() {
        ActivityZoomRecodedPlayerBinding activityZoomRecodedPlayerBinding = this.binding;
        if (activityZoomRecodedPlayerBinding != null) {
            return activityZoomRecodedPlayerBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityZoomRecodedPlayerBinding activityZoomRecodedPlayerBinding) {
        Intrinsics.checkNotNullParameter(activityZoomRecodedPlayerBinding, "<set-?>");
        this.binding = activityZoomRecodedPlayerBinding;
    }

    public final ExoPlayer getSimpleExoPlayer() {
        return this.simpleExoPlayer;
    }

    public final void setSimpleExoPlayer(ExoPlayer exoPlayer) {
        this.simpleExoPlayer = exoPlayer;
    }

    public final int getHightrootView() {
        return this.hightrootView;
    }

    public final void setHightrootView(int i) {
        this.hightrootView = i;
    }

    public final View getRootView() {
        return this.rootView;
    }

    public final void setRootView(View view) {
        this.rootView = view;
    }

    public final String getVideoURL() {
        return this.videoURL;
    }

    public final void setVideoURL(String str) {
        this.videoURL = str;
    }

    public final String getVideo_id() {
        return this.video_id;
    }

    public final void setVideo_id(String str) {
        this.video_id = str;
    }

    public final String getAdd_bookmark() {
        return this.add_bookmark;
    }

    public final void setAdd_bookmark(String str) {
        this.add_bookmark = str;
    }

    public final SharedPreferences getSharedPreferences() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
        return null;
    }

    public final void setSharedPreferences(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<set-?>");
        this.sharedPreferences = sharedPreferences;
    }

    public final SharedPreferences.Editor getEditor() {
        SharedPreferences.Editor editor = this.editor;
        if (editor != null) {
            return editor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("editor");
        return null;
    }

    public final void setEditor(SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "<set-?>");
        this.editor = editor;
    }

    public final String getBookmarkState() {
        return this.bookmarkState;
    }

    public final void setBookmarkState(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bookmarkState = str;
    }

    public final String getVideoId_value() {
        return this.videoId_value;
    }

    public final void setVideoId_value(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoId_value = str;
    }

    public final String getIslive() {
        return this.islive;
    }

    public final void setIslive(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.islive = str;
    }

    public final int getI() {
        return this.i;
    }

    public final void setI(int i) {
        this.i = i;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    public final boolean getState() {
        return this.state;
    }

    public final void setState(boolean z) {
        this.state = z;
    }

    public final TextView getSpeedTV() {
        return this.speedTV;
    }

    public final void setSpeedTV(TextView textView) {
        this.speedTV = textView;
    }

    public final ImageView getFullScreen() {
        ImageView imageView = this.fullScreen;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fullScreen");
        return null;
    }

    public final void setFullScreen(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.fullScreen = imageView;
    }

    public final String[] getSpeed() {
        return this.speed;
    }

    public final void setSpeed(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.speed = strArr;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ZoomRecodedPlayer zoomRecodedPlayer = this;
        Helper.setSystemBarLight(zoomRecodedPlayer);
        setBinding(ActivityZoomRecodedPlayerBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        setOrientation();
        Helper.enableScreenShot(zoomRecodedPlayer);
        ZoomRecodedPlayer zoomRecodedPlayer2 = this;
        this.networkCall = new NetworkCall(this, zoomRecodedPlayer2);
        this.simpleExoPlayer = new ExoPlayer.Builder(zoomRecodedPlayer2).setSeekForwardIncrementMs(10000L).setSeekBackIncrementMs(10000L).build();
        setFullScreen((ImageView) findViewById(R.id.exo_fullscreen_icon));
        findViewById(R.id.quality).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.exo_playback_speed);
        this.speedTV = textView;
        if (textView != null) {
            textView.setEnabled(false);
        }
        TextView textView2 = this.speedTV;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZoomRecodedPlayer.onCreate$lambda$5(this.f$0, view);
                }
            });
        }
        if (getIntent() != null) {
            this.url = getIntent().getStringExtra("videoUrl");
            this.video_id = getIntent().getStringExtra(Const.VIDEO_ID);
            this.add_bookmark = getIntent().getStringExtra("bookmark");
            this.islive = String.valueOf(getIntent().getStringExtra("live"));
            playVideo(getIntent().getStringExtra("videoUrl"), 1);
        } else {
            finish();
        }
        if (!this.islive.equals("1")) {
            ImageView imageView = getBinding().videoBookmark;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            setSharedPreferences(getSharedPreferences("VIDEO_BOOKMARK", 0));
            setEditor(getSharedPreferences().edit());
            SharedPreferences sharedPreferences = getSharedPreferences();
            String strValueOf = String.valueOf(sharedPreferences != null ? sharedPreferences.getString(this.video_id, "") : null);
            this.videoId_value = strValueOf;
            if (strValueOf.length() != 0 || !Intrinsics.areEqual(this.videoId_value, "")) {
                if (Intrinsics.areEqual(this.videoId_value, "0")) {
                    ImageView imageView2 = getBinding().videoBookmark;
                    if (imageView2 != null) {
                        imageView2.setImageResource(R.mipmap.bookmark_selected);
                    }
                    this.bookmarkState = "0";
                } else {
                    ImageView imageView3 = getBinding().videoBookmark;
                    if (imageView3 != null) {
                        imageView3.setImageResource(R.mipmap.bookmark_unselected);
                    }
                    this.bookmarkState = "1";
                }
            } else {
                String str = this.add_bookmark;
                if (str != null && Intrinsics.areEqual(str, "1")) {
                    ImageView imageView4 = getBinding().videoBookmark;
                    if (imageView4 != null) {
                        imageView4.setImageResource(R.mipmap.bookmark_selected);
                    }
                    this.bookmarkState = "0";
                }
            }
            ImageView imageView5 = getBinding().videoBookmark;
            if (imageView5 != null) {
                imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ZoomRecodedPlayer.onCreate$lambda$6(this.f$0, view);
                    }
                });
            }
        }
        getFullScreen().setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZoomRecodedPlayer.onCreate$lambda$7(this.f$0, view);
            }
        });
        TextView textView3 = getBinding().floatingTextNew;
        if (textView3 != null) {
            textView3.setText(SharedPreference.getInstance().getLoggedInUser().getMobile());
        }
        TextView textView4 = getBinding().floatingTextNew;
        if (textView4 != null) {
            textView4.measure(0, 0);
        }
        TextView textView5 = getBinding().floatingTextNew;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(final ZoomRecodedPlayer zoomRecodedPlayer, View view) {
        final Dialog dialog = new Dialog(zoomRecodedPlayer);
        dialog.setContentView(R.layout.speed_dailog);
        View viewFindViewById = dialog.findViewById(R.id.tvVarySmall);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = dialog.findViewById(R.id.tvSmall);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        View viewFindViewById3 = dialog.findViewById(R.id.tvMedium);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        View viewFindViewById4 = dialog.findViewById(R.id.tvLarge);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        View viewFindViewById5 = dialog.findViewById(R.id.tv720);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        View viewFindViewById6 = dialog.findViewById(R.id.tv1080);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        View viewFindViewById7 = dialog.findViewById(R.id.tvHighRes);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        ((TextView) viewFindViewById).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZoomRecodedPlayer.onCreate$lambda$5$lambda$0(this.f$0, dialog, view2);
            }
        });
        ((TextView) viewFindViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZoomRecodedPlayer.onCreate$lambda$5$lambda$1(this.f$0, dialog, view2);
            }
        });
        ((TextView) viewFindViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZoomRecodedPlayer.onCreate$lambda$5$lambda$2(this.f$0, dialog, view2);
            }
        });
        ((TextView) viewFindViewById4).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZoomRecodedPlayer.onCreate$lambda$5$lambda$3(this.f$0, dialog, view2);
            }
        });
        ((TextView) viewFindViewById5).setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ZoomRecodedPlayer.onCreate$lambda$5$lambda$4(this.f$0, dialog, view2);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5$lambda$0(ZoomRecodedPlayer zoomRecodedPlayer, Dialog dialog, View view) {
        TextView textView = zoomRecodedPlayer.speedTV;
        Intrinsics.checkNotNull(textView);
        textView.setText("0.25x");
        PlaybackParameters playbackParameters = new PlaybackParameters(0.25f);
        dialog.dismiss();
        ExoPlayer exoPlayer = zoomRecodedPlayer.simpleExoPlayer;
        Intrinsics.checkNotNull(exoPlayer);
        exoPlayer.setPlaybackParameters(playbackParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5$lambda$1(ZoomRecodedPlayer zoomRecodedPlayer, Dialog dialog, View view) {
        TextView textView = zoomRecodedPlayer.speedTV;
        Intrinsics.checkNotNull(textView);
        textView.setText("0.5x");
        PlaybackParameters playbackParameters = new PlaybackParameters(0.5f);
        dialog.dismiss();
        ExoPlayer exoPlayer = zoomRecodedPlayer.simpleExoPlayer;
        Intrinsics.checkNotNull(exoPlayer);
        exoPlayer.setPlaybackParameters(playbackParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5$lambda$2(ZoomRecodedPlayer zoomRecodedPlayer, Dialog dialog, View view) {
        TextView textView = zoomRecodedPlayer.speedTV;
        Intrinsics.checkNotNull(textView);
        textView.setText("1x");
        PlaybackParameters playbackParameters = new PlaybackParameters(1.0f);
        dialog.dismiss();
        ExoPlayer exoPlayer = zoomRecodedPlayer.simpleExoPlayer;
        Intrinsics.checkNotNull(exoPlayer);
        exoPlayer.setPlaybackParameters(playbackParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5$lambda$3(ZoomRecodedPlayer zoomRecodedPlayer, Dialog dialog, View view) {
        TextView textView = zoomRecodedPlayer.speedTV;
        Intrinsics.checkNotNull(textView);
        textView.setText("1.5x");
        PlaybackParameters playbackParameters = new PlaybackParameters(1.5f);
        dialog.dismiss();
        ExoPlayer exoPlayer = zoomRecodedPlayer.simpleExoPlayer;
        Intrinsics.checkNotNull(exoPlayer);
        exoPlayer.setPlaybackParameters(playbackParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5$lambda$4(ZoomRecodedPlayer zoomRecodedPlayer, Dialog dialog, View view) {
        TextView textView = zoomRecodedPlayer.speedTV;
        Intrinsics.checkNotNull(textView);
        textView.setText("2x");
        PlaybackParameters playbackParameters = new PlaybackParameters(2.0f);
        dialog.dismiss();
        ExoPlayer exoPlayer = zoomRecodedPlayer.simpleExoPlayer;
        Intrinsics.checkNotNull(exoPlayer);
        exoPlayer.setPlaybackParameters(playbackParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(ZoomRecodedPlayer zoomRecodedPlayer, View view) {
        int i = zoomRecodedPlayer.i;
        if (i < 3) {
            zoomRecodedPlayer.i = i + 1;
            if (Intrinsics.areEqual(zoomRecodedPlayer.bookmarkState, "0")) {
                zoomRecodedPlayer.bookmarkState = "1";
                zoomRecodedPlayer.getEditor().remove(zoomRecodedPlayer.video_id);
                zoomRecodedPlayer.getEditor().apply();
                zoomRecodedPlayer.getBinding().videoBookmark.setImageResource(R.mipmap.bookmark_unselected);
                NetworkCall networkCall = zoomRecodedPlayer.networkCall;
                Intrinsics.checkNotNull(networkCall);
                networkCall.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", true, false);
                return;
            }
            zoomRecodedPlayer.bookmarkState = "0";
            zoomRecodedPlayer.getEditor().putString(zoomRecodedPlayer.video_id, zoomRecodedPlayer.bookmarkState);
            zoomRecodedPlayer.getEditor().apply();
            zoomRecodedPlayer.getBinding().videoBookmark.setImageResource(R.mipmap.bookmark_selected);
            NetworkCall networkCall2 = zoomRecodedPlayer.networkCall;
            Intrinsics.checkNotNull(networkCall2);
            networkCall2.NetworkAPICall(API.API_ADD_TO_BOOKMARK, "", true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$7(ZoomRecodedPlayer zoomRecodedPlayer, View view) {
        if (zoomRecodedPlayer.state) {
            zoomRecodedPlayer.setRequestedOrientation(1);
            zoomRecodedPlayer.state = false;
        } else {
            zoomRecodedPlayer.setRequestedOrientation(0);
            zoomRecodedPlayer.state = true;
        }
    }

    private final void setOrientation() {
        try {
            if (this.playerState) {
                this.playerState = false;
                getBinding().rootNew.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) ((((getResources().getConfiguration().screenLayout & 15) == 3 ? 350 : (getResources().getConfiguration().screenLayout & 15) == 4 ? 450 : 230) * getResources().getDisplayMetrics().density) + 0.5f)));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        try {
            boolean z = true;
            if (newConfig.orientation == 1) {
                float f2 = getResources().getDisplayMetrics().density;
                if ((getResources().getConfiguration().screenLayout & 15) != 4) {
                    z = false;
                }
                getBinding().rootNew.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) ((((getResources().getConfiguration().screenLayout & 15) == 3 ? 350 : z ? 450 : 230) * f2) + 0.5f)));
                return;
            }
            getBinding().rootNew.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void blink() {
        try {
            TextView textView = getBinding().floatingTextNew;
            if (textView != null) {
                textView.setVisibility(4);
            }
            if (getBinding().ExoPlayer != null) {
                PlayerView playerView = getBinding().ExoPlayer;
                Intrinsics.checkNotNull(playerView);
                playerView.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1());
            }
        } catch (IllegalArgumentException unused) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer$blink$1, reason: invalid class name */
    /* JADX INFO: compiled from: ZoomRecodedPlayer.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004"}, d2 = {"com/appnew/android/Zoom/Activity/ZoomRecodedPlayer$blink$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements ViewTreeObserver.OnPreDrawListener {
        AnonymousClass1() {
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0081  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onPreDraw() {
            /*
                Method dump skipped, instruction units count: 358
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer.AnonymousClass1.onPreDraw():boolean");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPreDraw$lambda$2(Handler handler, final ZoomRecodedPlayer zoomRecodedPlayer) {
            try {
                Thread.sleep(1000);
            } catch (Exception unused) {
            }
            handler.post(new Runnable() { // from class: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer$blink$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ZoomRecodedPlayer.AnonymousClass1.onPreDraw$lambda$2$lambda$1(zoomRecodedPlayer);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPreDraw$lambda$2$lambda$1(final ZoomRecodedPlayer zoomRecodedPlayer) {
            TextView textView = zoomRecodedPlayer.getBinding().floatingTextNew;
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(0);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer$blink$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ZoomRecodedPlayer.access$blink(zoomRecodedPlayer);
                }
            }, 3000L);
        }
    }

    public final void playVideo(String uri, int type) {
        new DefaultHttpDataSource.Factory();
        PlayerView playerView = getBinding().ExoPlayer;
        Intrinsics.checkNotNull(playerView, "null cannot be cast to non-null type androidx.media3.ui.PlayerView");
        playerView.setPlayer(this.simpleExoPlayer);
        Intrinsics.checkNotNull(uri);
        MediaItem mediaItemFromUri = MediaItem.fromUri(uri);
        Intrinsics.checkNotNullExpressionValue(mediaItemFromUri, "fromUri(...)");
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setMediaItem(mediaItemFromUri);
        }
        ExoPlayer exoPlayer2 = this.simpleExoPlayer;
        if (exoPlayer2 != null) {
            exoPlayer2.prepare();
        }
        if (this.utkashRoom.getyoutubedata().isUserExist(this.video_id, MakeMyExam.userId, "0")) {
            this.playPosition = this.utkashRoom.getyoutubedata().getyoutubedata(MakeMyExam.userId, this.video_id, "0");
        }
        PlayerView playerView2 = getBinding().ExoPlayer;
        if (playerView2 != null) {
            playerView2.setKeepScreenOn(true);
        }
        ExoPlayer exoPlayer3 = this.simpleExoPlayer;
        if (exoPlayer3 != null) {
            exoPlayer3.seekTo(this.playPosition);
        }
        ExoPlayer exoPlayer4 = this.simpleExoPlayer;
        if (exoPlayer4 != null) {
            exoPlayer4.setPlayWhenReady(true);
        }
        getBinding().progressBar.setVisibility(0);
        ExoPlayer exoPlayer5 = this.simpleExoPlayer;
        if (exoPlayer5 != null) {
            exoPlayer5.addListener(new Player.Listener() { // from class: com.appnew.android.Zoom.Activity.ZoomRecodedPlayer.playVideo.1
                @Override // androidx.media3.common.Player.Listener
                public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                    Intrinsics.checkNotNullParameter(audioAttributes, "audioAttributes");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onAudioSessionIdChanged(int audioSessionId) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onAvailableCommandsChanged(Player.Commands availableCommands) {
                    Intrinsics.checkNotNullParameter(availableCommands, "availableCommands");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onCues(List<Cue> cues) {
                    Intrinsics.checkNotNullParameter(cues, "cues");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                    Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onDeviceVolumeChanged(int volume, boolean muted) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onEvents(Player player, Player.Events events) {
                    Intrinsics.checkNotNullParameter(player, "player");
                    Intrinsics.checkNotNullParameter(events, "events");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onIsLoadingChanged(boolean isLoading) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onIsPlayingChanged(boolean isPlaying) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onMediaItemTransition(MediaItem mediaItem, int reason) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                    Intrinsics.checkNotNullParameter(mediaMetadata, "mediaMetadata");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onMetadata(androidx.media3.common.Metadata metadata) {
                    Intrinsics.checkNotNullParameter(metadata, "metadata");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                    Intrinsics.checkNotNullParameter(playbackParameters, "playbackParameters");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onPlaybackSuppressionReasonChanged(int playbackSuppressionReason) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onPlayerError(PlaybackException error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onPlayerErrorChanged(PlaybackException error) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                    Intrinsics.checkNotNullParameter(mediaMetadata, "mediaMetadata");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onPositionDiscontinuity(Player.PositionInfo oldPosition, Player.PositionInfo newPosition, int reason) {
                    Intrinsics.checkNotNullParameter(oldPosition, "oldPosition");
                    Intrinsics.checkNotNullParameter(newPosition, "newPosition");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onRenderedFirstFrame() {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onRepeatModeChanged(int repeatMode) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onSeekBackIncrementChanged(long seekBackIncrementMs) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onSeekForwardIncrementChanged(long seekForwardIncrementMs) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onSkipSilenceEnabledChanged(boolean skipSilenceEnabled) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onSurfaceSizeChanged(int width, int height) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onTimelineChanged(Timeline timeline, int reason) {
                    Intrinsics.checkNotNullParameter(timeline, "timeline");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onVideoSizeChanged(VideoSize videoSize) {
                    Intrinsics.checkNotNullParameter(videoSize, "videoSize");
                }

                @Override // androidx.media3.common.Player.Listener
                public void onVolumeChanged(float volume) {
                }

                @Override // androidx.media3.common.Player.Listener
                public void onPlaybackStateChanged(int playbackState) {
                    if (playbackState == 2) {
                        ZoomRecodedPlayer.this.getBinding().progressBar.setVisibility(0);
                        return;
                    }
                    if (playbackState == 3) {
                        ZoomRecodedPlayer.this.getBinding().progressBar.setVisibility(8);
                        TextView speedTV = ZoomRecodedPlayer.this.getSpeedTV();
                        if (speedTV != null) {
                            speedTV.setEnabled(true);
                            return;
                        }
                        return;
                    }
                    if (playbackState != 4) {
                        return;
                    }
                    try {
                        if (ZoomRecodedPlayer.this.getUtkashRoom().getyoutubedata().isUserExist(ZoomRecodedPlayer.this.getVideo_id(), MakeMyExam.userId, "0")) {
                            ZoomRecodedPlayer.this.getUtkashRoom().getyoutubedata().updateTime(Long.valueOf(ZoomRecodedPlayer.this.playPosition), ZoomRecodedPlayer.this.getVideo_id(), MakeMyExam.userId, "0");
                            return;
                        }
                        YoutubePlayerTable youtubePlayerTable = new YoutubePlayerTable();
                        youtubePlayerTable.setYoutubeid(ZoomRecodedPlayer.this.url);
                        youtubePlayerTable.setYoutubetime(ZoomRecodedPlayer.this.playPosition);
                        youtubePlayerTable.setIsaudio("0");
                        youtubePlayerTable.setVideoid(ZoomRecodedPlayer.this.getVideo_id());
                        youtubePlayerTable.setVideoname("");
                        youtubePlayerTable.setUserid(MakeMyExam.userId);
                        ZoomRecodedPlayer.this.getUtkashRoom().getyoutubedata().addVideo(youtubePlayerTable);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setPlayWhenReady(false);
        }
        ExoPlayer exoPlayer2 = this.simpleExoPlayer;
        Long lValueOf = exoPlayer2 != null ? Long.valueOf(exoPlayer2.getCurrentPosition()) : null;
        Intrinsics.checkNotNull(lValueOf);
        this.playPosition = lValueOf.longValue();
        try {
            if (this.utkashRoom.getyoutubedata().isUserExist(this.video_id, MakeMyExam.userId, "0")) {
                this.utkashRoom.getyoutubedata().updateTime(Long.valueOf(this.playPosition), this.video_id, MakeMyExam.userId, "0");
                return;
            }
            YoutubePlayerTable youtubePlayerTable = new YoutubePlayerTable();
            youtubePlayerTable.setYoutubeid(this.url);
            youtubePlayerTable.setYoutubetime(this.playPosition);
            youtubePlayerTable.setIsaudio("0");
            youtubePlayerTable.setVideoid(this.video_id);
            youtubePlayerTable.setVideoname("");
            youtubePlayerTable.setUserid(MakeMyExam.userId);
            this.utkashRoom.getyoutubedata().addVideo(youtubePlayerTable);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ExoPlayer exoPlayer = this.simpleExoPlayer;
        Long lValueOf = exoPlayer != null ? Long.valueOf(exoPlayer.getCurrentPosition()) : null;
        Intrinsics.checkNotNull(lValueOf);
        this.playPosition = lValueOf.longValue();
        try {
            if (this.utkashRoom.getyoutubedata().isUserExist(this.video_id, MakeMyExam.userId, "0")) {
                this.utkashRoom.getyoutubedata().updateTime(Long.valueOf(this.playPosition), this.video_id, MakeMyExam.userId, "0");
                return;
            }
            YoutubePlayerTable youtubePlayerTable = new YoutubePlayerTable();
            youtubePlayerTable.setYoutubeid(this.url);
            youtubePlayerTable.setYoutubetime(this.playPosition);
            youtubePlayerTable.setIsaudio("0");
            youtubePlayerTable.setVideoid(this.video_id);
            youtubePlayerTable.setVideoname("");
            youtubePlayerTable.setUserid(MakeMyExam.userId);
            this.utkashRoom.getyoutubedata().addVideo(youtubePlayerTable);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (!Intrinsics.areEqual(apitype, API.API_ADD_TO_BOOKMARK)) {
            return null;
        }
        EncryptionData encryptionData = new EncryptionData();
        encryptionData.setContent_type("3");
        encryptionData.setContent_id(this.video_id);
        encryptionData.setIs_unbookmarked(this.bookmarkState);
        return service.addPdfBookMark(AES.encrypt(new Gson().toJson(encryptionData)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonstring, "jsonstring");
        if (Intrinsics.areEqual(apitype, API.API_ADD_TO_BOOKMARK)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonstring.getString("status").equals("true")) {
                    Toast.makeText(this, jsonstring.optString("message"), 0).show();
                } else {
                    ErrorCallBack(jsonstring.getString("message"), apitype, typeApi);
                    RetrofitResponse.GetApiData(this, jsonstring.getString("auth_code"), jsonstring.getString("message"), false);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
