package com.pierfrancescosoffritti.androidyoutubeplayer.core.customui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.YouTubePlayerMenu;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.menu.defaultMenu.DefaultYouTubePlayerMenu;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.utils.FadeViewHelper;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.views.YouTubePlayerSeekBar;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.views.YouTubePlayerSeekBarListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultPlayerUiController.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000*\u0001)\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0012H\u0016J\b\u00101\u001a\u00020'H\u0016J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\u0010\u00105\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\bH\u0016J\u001a\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010:\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u001bH\u0016J\u0010\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u001bH\u0016J\u0010\u0010?\u001a\u00020\u00012\u0006\u0010$\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010C\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010D\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010E\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010F\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010G\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010H\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010I\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010J\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010K\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010L\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010M\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0010\u0010N\u001a\u0002032\u0006\u0010O\u001a\u00020\u0012H\u0002J\u0010\u0010P\u001a\u0002032\u0006\u0010Q\u001a\u00020RH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/DefaultPlayerUiController;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/PlayerUiController;", "youTubePlayerView", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "youTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;)V", "controlsContainer", "Landroid/view/View;", "customActionLeft", "Landroid/widget/ImageView;", "customActionRight", "extraViewsContainer", "Landroid/widget/LinearLayout;", "fadeControlsContainer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/utils/FadeViewHelper;", "fullscreenButton", "isCustomActionLeftEnabled", "", "isCustomActionRightEnabled", "isMatchParent", "isPlayPauseButtonEnabled", "isPlaying", "liveVideoIndicator", "Landroid/widget/TextView;", "menuButton", "onFullscreenButtonListener", "Landroid/view/View$OnClickListener;", "onMenuButtonClickListener", "panel", "playPauseButton", "progressBar", "Landroid/widget/ProgressBar;", "rootView", "getRootView", "()Landroid/view/View;", "videoTitle", "youTubeButton", "youTubePlayerMenu", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/menu/YouTubePlayerMenu;", "youTubePlayerStateListener", "com/pierfrancescosoffritti/androidyoutubeplayer/core/customui/DefaultPlayerUiController$youTubePlayerStateListener$1", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/DefaultPlayerUiController$youTubePlayerStateListener$1;", "youtubePlayerSeekBar", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/customui/views/YouTubePlayerSeekBar;", "addView", ViewHierarchyConstants.VIEW_KEY, "enableLiveVideoUi", "enable", "getMenu", "initClickListeners", "", "onPlayButtonPressed", "removeView", "setCustomAction1", "icon", "Landroid/graphics/drawable/Drawable;", "clickListener", "setCustomAction2", "setFullscreenButtonClickListener", "customFullscreenButtonClickListener", "setMenuButtonClickListener", "customMenuButtonClickListener", "setVideoTitle", "", "showBufferingProgress", "show", "showCurrentTime", "showCustomAction1", "showCustomAction2", "showDuration", "showFullscreenButton", "showMenuButton", "showPlayPauseButton", "showSeekBar", "showUi", "showVideoTitle", "showYouTubeButton", "updatePlayPauseButtonIcon", "playing", "updateState", "state", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "custom-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultPlayerUiController implements PlayerUiController {
    private final View controlsContainer;
    private final ImageView customActionLeft;
    private final ImageView customActionRight;
    private final LinearLayout extraViewsContainer;
    private final FadeViewHelper fadeControlsContainer;
    private final ImageView fullscreenButton;
    private boolean isCustomActionLeftEnabled;
    private boolean isCustomActionRightEnabled;
    private boolean isMatchParent;
    private boolean isPlayPauseButtonEnabled;
    private boolean isPlaying;
    private final TextView liveVideoIndicator;
    private final ImageView menuButton;
    private View.OnClickListener onFullscreenButtonListener;
    private View.OnClickListener onMenuButtonClickListener;
    private final View panel;
    private final ImageView playPauseButton;
    private final ProgressBar progressBar;
    private final View rootView;
    private final TextView videoTitle;
    private final ImageView youTubeButton;
    private final YouTubePlayer youTubePlayer;
    private YouTubePlayerMenu youTubePlayerMenu;
    private final DefaultPlayerUiController$youTubePlayerStateListener$1 youTubePlayerStateListener;
    private final YouTubePlayerView youTubePlayerView;
    private final YouTubePlayerSeekBar youtubePlayerSeekBar;

    /* JADX INFO: compiled from: DefaultPlayerUiController.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerConstants.PlayerState.values().length];
            try {
                iArr[PlayerConstants.PlayerState.ENDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayerConstants.PlayerState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlayerConstants.PlayerState.PLAYING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DefaultPlayerUiController(YouTubePlayerView youTubePlayerView, YouTubePlayer youTubePlayer) {
        Intrinsics.checkNotNullParameter(youTubePlayerView, "youTubePlayerView");
        Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
        this.youTubePlayerView = youTubePlayerView;
        this.youTubePlayer = youTubePlayer;
        View viewInflate = View.inflate(youTubePlayerView.getContext(), R.layout.ayp_default_player_ui, null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(youTubePlayerVie…_default_player_ui, null)");
        this.rootView = viewInflate;
        Context context = youTubePlayerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "youTubePlayerView.context");
        this.youTubePlayerMenu = new DefaultYouTubePlayerMenu(context);
        View viewFindViewById = viewInflate.findViewById(R.id.panel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "rootView.findViewById(R.id.panel)");
        this.panel = viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.controls_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "rootView.findViewById(R.id.controls_container)");
        this.controlsContainer = viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.extra_views_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "rootView.findViewById(R.id.extra_views_container)");
        this.extraViewsContainer = (LinearLayout) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.video_title);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "rootView.findViewById(R.id.video_title)");
        this.videoTitle = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.live_video_indicator);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "rootView.findViewById(R.id.live_video_indicator)");
        this.liveVideoIndicator = (TextView) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "rootView.findViewById(R.id.progress)");
        this.progressBar = (ProgressBar) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.menu_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "rootView.findViewById(R.id.menu_button)");
        this.menuButton = (ImageView) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.play_pause_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "rootView.findViewById(R.id.play_pause_button)");
        this.playPauseButton = (ImageView) viewFindViewById8;
        View viewFindViewById9 = viewInflate.findViewById(R.id.youtube_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "rootView.findViewById(R.id.youtube_button)");
        this.youTubeButton = (ImageView) viewFindViewById9;
        View viewFindViewById10 = viewInflate.findViewById(R.id.fullscreen_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "rootView.findViewById(R.id.fullscreen_button)");
        this.fullscreenButton = (ImageView) viewFindViewById10;
        View viewFindViewById11 = viewInflate.findViewById(R.id.custom_action_left_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "rootView.findViewById(R.…ustom_action_left_button)");
        this.customActionLeft = (ImageView) viewFindViewById11;
        View viewFindViewById12 = viewInflate.findViewById(R.id.custom_action_right_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "rootView.findViewById(R.…stom_action_right_button)");
        this.customActionRight = (ImageView) viewFindViewById12;
        View viewFindViewById13 = viewInflate.findViewById(R.id.youtube_player_seekbar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "rootView.findViewById(R.id.youtube_player_seekbar)");
        this.youtubePlayerSeekBar = (YouTubePlayerSeekBar) viewFindViewById13;
        this.fadeControlsContainer = new FadeViewHelper(viewFindViewById2);
        this.isPlayPauseButtonEnabled = true;
        this.youTubePlayerStateListener = new DefaultPlayerUiController$youTubePlayerStateListener$1(this);
        this.onFullscreenButtonListener = new View.OnClickListener() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultPlayerUiController._init_$lambda$0(this.f$0, view);
            }
        };
        this.onMenuButtonClickListener = new View.OnClickListener() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultPlayerUiController._init_$lambda$1(this.f$0, view);
            }
        };
        initClickListeners();
    }

    public final View getRootView() {
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(DefaultPlayerUiController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z = this$0.isMatchParent;
        boolean z2 = !z;
        this$0.isMatchParent = z2;
        if (z2) {
            this$0.youTubePlayerView.matchParent();
        } else if (z) {
            this$0.youTubePlayerView.wrapContent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(DefaultPlayerUiController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.youTubePlayerMenu.show(this$0.menuButton);
    }

    private final void initClickListeners() {
        this.youTubePlayer.addListener(this.youtubePlayerSeekBar);
        this.youTubePlayer.addListener(this.fadeControlsContainer);
        this.youTubePlayer.addListener(this.youTubePlayerStateListener);
        this.youtubePlayerSeekBar.setYoutubePlayerSeekBarListener(new YouTubePlayerSeekBarListener() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController.initClickListeners.1
            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.views.YouTubePlayerSeekBarListener
            public void seekTo(float time) {
                DefaultPlayerUiController.this.youTubePlayer.seekTo(time);
            }
        });
        this.panel.setOnClickListener(new View.OnClickListener() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultPlayerUiController.initClickListeners$lambda$2(this.f$0, view);
            }
        });
        this.playPauseButton.setOnClickListener(new View.OnClickListener() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultPlayerUiController.initClickListeners$lambda$3(this.f$0, view);
            }
        });
        this.fullscreenButton.setOnClickListener(new View.OnClickListener() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultPlayerUiController.initClickListeners$lambda$4(this.f$0, view);
            }
        });
        this.menuButton.setOnClickListener(new View.OnClickListener() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultPlayerUiController.initClickListeners$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$2(DefaultPlayerUiController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fadeControlsContainer.toggleVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$3(DefaultPlayerUiController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onPlayButtonPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$4(DefaultPlayerUiController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onFullscreenButtonListener.onClick(this$0.fullscreenButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$5(DefaultPlayerUiController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onMenuButtonClickListener.onClick(this$0.menuButton);
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showVideoTitle(boolean show) {
        this.videoTitle.setVisibility(show ? 0 : 8);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController setVideoTitle(String videoTitle) {
        Intrinsics.checkNotNullParameter(videoTitle, "videoTitle");
        this.videoTitle.setText(videoTitle);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showUi(boolean show) {
        this.fadeControlsContainer.setDisabled(!show);
        this.controlsContainer.setVisibility(show ? 0 : 4);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showPlayPauseButton(boolean show) {
        this.playPauseButton.setVisibility(show ? 0 : 8);
        this.isPlayPauseButtonEnabled = show;
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController enableLiveVideoUi(boolean enable) {
        this.youtubePlayerSeekBar.setVisibility(enable ? 4 : 0);
        this.liveVideoIndicator.setVisibility(enable ? 0 : 8);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController setCustomAction1(Drawable icon, View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.customActionLeft.setImageDrawable(icon);
        this.customActionLeft.setOnClickListener(clickListener);
        showCustomAction1(true);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController setCustomAction2(Drawable icon, View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.customActionRight.setImageDrawable(icon);
        this.customActionRight.setOnClickListener(clickListener);
        showCustomAction2(true);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showCustomAction1(boolean show) {
        this.isCustomActionLeftEnabled = show;
        this.customActionLeft.setVisibility(show ? 0 : 8);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showCustomAction2(boolean show) {
        this.isCustomActionRightEnabled = show;
        this.customActionRight.setVisibility(show ? 0 : 8);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showMenuButton(boolean show) {
        this.menuButton.setVisibility(show ? 0 : 8);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController setMenuButtonClickListener(View.OnClickListener customMenuButtonClickListener) {
        Intrinsics.checkNotNullParameter(customMenuButtonClickListener, "customMenuButtonClickListener");
        this.onMenuButtonClickListener = customMenuButtonClickListener;
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showCurrentTime(boolean show) {
        this.youtubePlayerSeekBar.getVideoCurrentTimeTextView().setVisibility(show ? 0 : 8);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showDuration(boolean show) {
        this.youtubePlayerSeekBar.getVideoDurationTextView().setVisibility(show ? 0 : 8);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showSeekBar(boolean show) {
        this.youtubePlayerSeekBar.getSeekBar().setVisibility(show ? 0 : 4);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showBufferingProgress(boolean show) {
        this.youtubePlayerSeekBar.setShowBufferingProgress(show);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showYouTubeButton(boolean show) {
        this.youTubeButton.setVisibility(show ? 0 : 8);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController addView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.extraViewsContainer.addView(view, 0);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.extraViewsContainer.removeView(view);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    /* JADX INFO: renamed from: getMenu, reason: from getter */
    public YouTubePlayerMenu getYouTubePlayerMenu() {
        return this.youTubePlayerMenu;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController showFullscreenButton(boolean show) {
        this.fullscreenButton.setVisibility(show ? 0 : 8);
        return this;
    }

    @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.PlayerUiController
    public PlayerUiController setFullscreenButtonClickListener(View.OnClickListener customFullscreenButtonClickListener) {
        Intrinsics.checkNotNullParameter(customFullscreenButtonClickListener, "customFullscreenButtonClickListener");
        this.onFullscreenButtonListener = customFullscreenButtonClickListener;
        return this;
    }

    private final void onPlayButtonPressed() {
        if (this.isPlaying) {
            this.youTubePlayer.pause();
        } else {
            this.youTubePlayer.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(PlayerConstants.PlayerState state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1 || i == 2) {
            this.isPlaying = false;
        } else if (i == 3) {
            this.isPlaying = true;
        }
        updatePlayPauseButtonIcon(!this.isPlaying);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePlayPauseButtonIcon(boolean playing) {
        this.playPauseButton.setImageResource(playing ? R.drawable.ayp_ic_pause_36dp : R.drawable.ayp_ic_play_36dp);
    }
}
