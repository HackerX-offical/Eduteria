package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YouTubePlayerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0018\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020&2\b\b\u0001\u0010'\u001a\u00020\nJ\u000e\u0010(\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010(\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*J\u0016\u0010(\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\rJ\u001e\u0010(\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\r2\u0006\u0010)\u001a\u00020*J(\u0010(\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-J\u0006\u0010.\u001a\u00020 J\b\u0010/\u001a\u00020 H\u0002J\u0018\u00100\u001a\u00020 2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020 H\u0002J\u0006\u00106\u001a\u00020 J\u000e\u00107\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0014J\u000e\u00108\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020&J\u0018\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0002J\u0006\u0010>\u001a\u00020 R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006?"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/SixteenByNineFrameLayout;", "Landroidx/lifecycle/LifecycleEventObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableAutomaticInitialization", "", "getEnableAutomaticInitialization", "()Z", "setEnableAutomaticInitialization", "(Z)V", "fullscreenListeners", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/FullscreenListener;", "legacyTubePlayerView", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/LegacyYouTubePlayerView;", "webViewFullscreenListener", "com/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView$webViewFullscreenListener$1", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView$webViewFullscreenListener$1;", "addFullscreenListener", "fullscreenListener", "addYouTubePlayerListener", "youTubePlayerListener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "enableBackgroundPlayback", "", "enable", "getYouTubePlayerWhenReady", "youTubePlayerCallback", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerCallback;", "inflateCustomPlayerUi", "Landroid/view/View;", "layoutId", "initialize", "playerOptions", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "handleNetworkEvents", "videoId", "", "matchParent", "onResume", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "onStop", "release", "removeFullscreenListener", "removeYouTubePlayerListener", "setCustomPlayerUi", ViewHierarchyConstants.VIEW_KEY, "setLayoutParams", "targetWidth", "targetHeight", "wrapContent", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class YouTubePlayerView extends SixteenByNineFrameLayout implements LifecycleEventObserver {
    private boolean enableAutomaticInitialization;
    private final List<FullscreenListener> fullscreenListeners;
    private final LegacyYouTubePlayerView legacyTubePlayerView;
    private final YouTubePlayerView$webViewFullscreenListener$1 webViewFullscreenListener;

    /* JADX INFO: compiled from: YouTubePlayerView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ YouTubePlayerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView$webViewFullscreenListener$1] */
    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.fullscreenListeners = new ArrayList();
        ?? r10 = new FullscreenListener() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView$webViewFullscreenListener$1
            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
            public void onEnterFullscreen(View fullscreenView, Function0<Unit> exitFullscreen) {
                Intrinsics.checkNotNullParameter(fullscreenView, "fullscreenView");
                Intrinsics.checkNotNullParameter(exitFullscreen, "exitFullscreen");
                if (this.this$0.fullscreenListeners.isEmpty()) {
                    throw new IllegalStateException("To enter fullscreen you need to first register a FullscreenListener.");
                }
                Iterator it = this.this$0.fullscreenListeners.iterator();
                while (it.hasNext()) {
                    ((FullscreenListener) it.next()).onEnterFullscreen(fullscreenView, exitFullscreen);
                }
            }

            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
            public void onExitFullscreen() {
                if (this.this$0.fullscreenListeners.isEmpty()) {
                    throw new IllegalStateException("To enter fullscreen you need to first register a FullscreenListener.");
                }
                Iterator it = this.this$0.fullscreenListeners.iterator();
                while (it.hasNext()) {
                    ((FullscreenListener) it.next()).onExitFullscreen();
                }
            }
        };
        this.webViewFullscreenListener = r10;
        LegacyYouTubePlayerView legacyYouTubePlayerView = new LegacyYouTubePlayerView(context, (FullscreenListener) r10, null, 0, 12, null);
        this.legacyTubePlayerView = legacyYouTubePlayerView;
        addView(legacyYouTubePlayerView, YouTubePlayerViewKt.getMatchParent());
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.YouTubePlayerView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl….YouTubePlayerView, 0, 0)");
        this.enableAutomaticInitialization = typedArrayObtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_enableAutomaticInitialization, true);
        final boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_autoPlay, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.YouTubePlayerView_handleNetworkEvents, true);
        final String string = typedArrayObtainStyledAttributes.getString(R.styleable.YouTubePlayerView_videoId);
        typedArrayObtainStyledAttributes.recycle();
        if (z && string == null) {
            throw new IllegalStateException("YouTubePlayerView: videoId is not set but autoPlay is set to true. This combination is not allowed.");
        }
        AbstractYouTubePlayerListener abstractYouTubePlayerListener = new AbstractYouTubePlayerListener() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView$youTubePlayerListener$1
            @Override // com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener, com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
            public void onReady(YouTubePlayer youTubePlayer) {
                Intrinsics.checkNotNullParameter(youTubePlayer, "youTubePlayer");
                String str = string;
                if (str != null) {
                    YouTubePlayerUtils.loadOrCueVideo(youTubePlayer, this.legacyTubePlayerView.getCanPlay() && z, str, 0.0f);
                }
                youTubePlayer.removeListener(this);
            }
        };
        if (this.enableAutomaticInitialization) {
            legacyYouTubePlayerView.initialize(abstractYouTubePlayerListener, z2, IFramePlayerOptions.INSTANCE.getDefault(), string);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ YouTubePlayerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final boolean getEnableAutomaticInitialization() {
        return this.enableAutomaticInitialization;
    }

    public final void setEnableAutomaticInitialization(boolean z) {
        this.enableAutomaticInitialization = z;
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener, boolean handleNetworkEvents, IFramePlayerOptions playerOptions, String videoId) {
        Intrinsics.checkNotNullParameter(youTubePlayerListener, "youTubePlayerListener");
        Intrinsics.checkNotNullParameter(playerOptions, "playerOptions");
        if (this.enableAutomaticInitialization) {
            throw new IllegalStateException("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false.");
        }
        this.legacyTubePlayerView.initialize(youTubePlayerListener, handleNetworkEvents, playerOptions, videoId);
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener, boolean handleNetworkEvents, IFramePlayerOptions playerOptions) {
        Intrinsics.checkNotNullParameter(youTubePlayerListener, "youTubePlayerListener");
        Intrinsics.checkNotNullParameter(playerOptions, "playerOptions");
        if (this.enableAutomaticInitialization) {
            throw new IllegalStateException("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false.");
        }
        this.legacyTubePlayerView.initialize(youTubePlayerListener, handleNetworkEvents, playerOptions, null);
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener, boolean handleNetworkEvents) {
        Intrinsics.checkNotNullParameter(youTubePlayerListener, "youTubePlayerListener");
        if (this.enableAutomaticInitialization) {
            throw new IllegalStateException("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false.");
        }
        this.legacyTubePlayerView.initialize(youTubePlayerListener, handleNetworkEvents, IFramePlayerOptions.INSTANCE.getDefault());
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener, IFramePlayerOptions playerOptions) {
        Intrinsics.checkNotNullParameter(youTubePlayerListener, "youTubePlayerListener");
        Intrinsics.checkNotNullParameter(playerOptions, "playerOptions");
        if (this.enableAutomaticInitialization) {
            throw new IllegalStateException("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false.");
        }
        this.legacyTubePlayerView.initialize(youTubePlayerListener, true, playerOptions);
    }

    public final void initialize(YouTubePlayerListener youTubePlayerListener) {
        Intrinsics.checkNotNullParameter(youTubePlayerListener, "youTubePlayerListener");
        if (this.enableAutomaticInitialization) {
            throw new IllegalStateException("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false.");
        }
        this.legacyTubePlayerView.initialize(youTubePlayerListener, true);
    }

    public final void getYouTubePlayerWhenReady(YouTubePlayerCallback youTubePlayerCallback) {
        Intrinsics.checkNotNullParameter(youTubePlayerCallback, "youTubePlayerCallback");
        this.legacyTubePlayerView.getYouTubePlayerWhenReady(youTubePlayerCallback);
    }

    public final View inflateCustomPlayerUi(int layoutId) {
        return this.legacyTubePlayerView.inflateCustomPlayerUi(layoutId);
    }

    public final void setCustomPlayerUi(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.legacyTubePlayerView.setCustomPlayerUi(view);
    }

    public final void enableBackgroundPlayback(boolean enable) {
        this.legacyTubePlayerView.enableBackgroundPlayback(enable);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            onResume();
        } else if (i == 2) {
            onStop();
        } else {
            if (i != 3) {
                return;
            }
            release();
        }
    }

    public final void release() {
        this.legacyTubePlayerView.release();
    }

    private final void onResume() {
        this.legacyTubePlayerView.onResume$core_release();
    }

    private final void onStop() {
        this.legacyTubePlayerView.onStop$core_release();
    }

    public final boolean addYouTubePlayerListener(YouTubePlayerListener youTubePlayerListener) {
        Intrinsics.checkNotNullParameter(youTubePlayerListener, "youTubePlayerListener");
        return this.legacyTubePlayerView.getWebViewYouTubePlayer().addListener(youTubePlayerListener);
    }

    public final boolean removeYouTubePlayerListener(YouTubePlayerListener youTubePlayerListener) {
        Intrinsics.checkNotNullParameter(youTubePlayerListener, "youTubePlayerListener");
        return this.legacyTubePlayerView.getWebViewYouTubePlayer().removeListener(youTubePlayerListener);
    }

    public final boolean addFullscreenListener(FullscreenListener fullscreenListener) {
        Intrinsics.checkNotNullParameter(fullscreenListener, "fullscreenListener");
        return this.fullscreenListeners.add(fullscreenListener);
    }

    public final boolean removeFullscreenListener(FullscreenListener fullscreenListener) {
        Intrinsics.checkNotNullParameter(fullscreenListener, "fullscreenListener");
        return this.fullscreenListeners.remove(fullscreenListener);
    }

    public final void matchParent() {
        setLayoutParams(-1, -1);
    }

    public final void wrapContent() {
        setLayoutParams(-1, -2);
    }

    private final void setLayoutParams(int targetWidth, int targetHeight) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = targetWidth;
        layoutParams.height = targetHeight;
        setLayoutParams(layoutParams);
    }
}
