package com.clevertap.android.sdk.customviews;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.clevertap.android.sdk.R;
import com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder;
import com.clevertap.android.sdk.video.InboxVideoPlayerHandle;
import com.clevertap.android.sdk.video.VideoLibChecker;
import com.clevertap.android.sdk.video.VideoLibraryIntegrated;
import com.clevertap.android.sdk.video.inbox.ExoplayerHandle;
import com.clevertap.android.sdk.video.inbox.Media3Handle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaPlayerRecyclerView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0017J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/clevertap/android/sdk/customviews/MediaPlayerRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handle", "Lcom/clevertap/android/sdk/video/InboxVideoPlayerHandle;", "rect", "Landroid/graphics/Rect;", "onScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onChildAttachStateChangeListener", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "playingHolder", "Lcom/clevertap/android/sdk/inbox/CTInboxBaseMessageViewHolder;", "onPausePlayer", "", "onRestartPlayer", "playVideo", "stop", "findBestVisibleMediaHolder", "initialize", "bufferingStarted", "playerReady", "artworkAsset", "Landroid/graphics/drawable/Drawable;", "recyclerViewListeners", "removeVideoView", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MediaPlayerRecyclerView extends RecyclerView {
    private final InboxVideoPlayerHandle handle;
    private final RecyclerView.OnChildAttachStateChangeListener onChildAttachStateChangeListener;
    private final RecyclerView.OnScrollListener onScrollListener;
    private CTInboxBaseMessageViewHolder playingHolder;
    private final Rect rect;

    /* JADX INFO: compiled from: MediaPlayerRecyclerView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoLibraryIntegrated.values().length];
            try {
                iArr[VideoLibraryIntegrated.MEDIA3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaPlayerRecyclerView(Context context) {
        ExoplayerHandle exoplayerHandle;
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        if (WhenMappings.$EnumSwitchMapping$0[VideoLibChecker.mediaLibType.ordinal()] == 1) {
            exoplayerHandle = new Media3Handle();
        } else {
            exoplayerHandle = new ExoplayerHandle();
        }
        this.handle = exoplayerHandle;
        this.rect = new Rect();
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView$onScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0) {
                    this.this$0.playVideo();
                }
            }
        };
        this.onChildAttachStateChangeListener = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView$onChildAttachStateChangeListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = this.this$0.playingHolder;
                if (cTInboxBaseMessageViewHolder != null) {
                    MediaPlayerRecyclerView mediaPlayerRecyclerView = this.this$0;
                    if (Intrinsics.areEqual(cTInboxBaseMessageViewHolder.itemView, view)) {
                        mediaPlayerRecyclerView.stop();
                    }
                }
            }
        };
        initialize();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaPlayerRecyclerView(Context context, AttributeSet attrs) {
        ExoplayerHandle exoplayerHandle;
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        if (WhenMappings.$EnumSwitchMapping$0[VideoLibChecker.mediaLibType.ordinal()] == 1) {
            exoplayerHandle = new Media3Handle();
        } else {
            exoplayerHandle = new ExoplayerHandle();
        }
        this.handle = exoplayerHandle;
        this.rect = new Rect();
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView$onScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0) {
                    this.this$0.playVideo();
                }
            }
        };
        this.onChildAttachStateChangeListener = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView$onChildAttachStateChangeListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = this.this$0.playingHolder;
                if (cTInboxBaseMessageViewHolder != null) {
                    MediaPlayerRecyclerView mediaPlayerRecyclerView = this.this$0;
                    if (Intrinsics.areEqual(cTInboxBaseMessageViewHolder.itemView, view)) {
                        mediaPlayerRecyclerView.stop();
                    }
                }
            }
        };
        initialize();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaPlayerRecyclerView(Context context, AttributeSet attrs, int i) {
        ExoplayerHandle exoplayerHandle;
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        if (WhenMappings.$EnumSwitchMapping$0[VideoLibChecker.mediaLibType.ordinal()] == 1) {
            exoplayerHandle = new Media3Handle();
        } else {
            exoplayerHandle = new ExoplayerHandle();
        }
        this.handle = exoplayerHandle;
        this.rect = new Rect();
        this.onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView$onScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0) {
                    this.this$0.playVideo();
                }
            }
        };
        this.onChildAttachStateChangeListener = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView$onChildAttachStateChangeListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = this.this$0.playingHolder;
                if (cTInboxBaseMessageViewHolder != null) {
                    MediaPlayerRecyclerView mediaPlayerRecyclerView = this.this$0;
                    if (Intrinsics.areEqual(cTInboxBaseMessageViewHolder.itemView, view)) {
                        mediaPlayerRecyclerView.stop();
                    }
                }
            }
        };
        initialize();
    }

    public final void onPausePlayer() {
        this.handle.setPlayWhenReady(false);
    }

    public final void onRestartPlayer() {
        initialize();
        playVideo();
    }

    public final void playVideo() {
        CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolderFindBestVisibleMediaHolder = findBestVisibleMediaHolder();
        if (cTInboxBaseMessageViewHolderFindBestVisibleMediaHolder == null) {
            removeVideoView();
            return;
        }
        CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = this.playingHolder;
        if (cTInboxBaseMessageViewHolder != null && Intrinsics.areEqual(cTInboxBaseMessageViewHolder.itemView, cTInboxBaseMessageViewHolderFindBestVisibleMediaHolder.itemView)) {
            if (((cTInboxBaseMessageViewHolder.itemView.getGlobalVisibleRect(this.rect) ? this.rect.height() : 0) >= 400) && cTInboxBaseMessageViewHolder.shouldAutoPlay()) {
                this.handle.setPlayWhenReady(true);
                return;
            } else {
                this.handle.setPlayWhenReady(false);
                return;
            }
        }
        removeVideoView();
        initialize();
        if (cTInboxBaseMessageViewHolderFindBestVisibleMediaHolder.addMediaPlayer(this.handle.playerVolume(), new Function0() { // from class: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MediaPlayerRecyclerView.playVideo$lambda$1(this.f$0);
            }
        }, new Function3() { // from class: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MediaPlayerRecyclerView.playVideo$lambda$2(this.f$0, (String) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue());
            }
        }, this.handle.videoSurface())) {
            this.playingHolder = cTInboxBaseMessageViewHolderFindBestVisibleMediaHolder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Float playVideo$lambda$1(MediaPlayerRecyclerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handle.handleMute();
        return Float.valueOf(this$0.handle.playerVolume());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void playVideo$lambda$2(MediaPlayerRecyclerView this$0, String uri, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uri, "uri");
        InboxVideoPlayerHandle inboxVideoPlayerHandle = this$0.handle;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        inboxVideoPlayerHandle.startPlaying(context, uri, z, z2);
        return null;
    }

    public final void stop() {
        this.handle.pause();
        this.playingHolder = null;
    }

    private final CTInboxBaseMessageViewHolder findBestVisibleMediaHolder() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
        int iFindFirstVisibleItemPosition = linearLayoutManager != null ? linearLayoutManager.findFirstVisibleItemPosition() : 0;
        LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) getLayoutManager();
        int iFindLastVisibleItemPosition = linearLayoutManager2 != null ? linearLayoutManager2.findLastVisibleItemPosition() : 0;
        if (iFindFirstVisibleItemPosition > iFindLastVisibleItemPosition) {
            return null;
        }
        int i = iFindFirstVisibleItemPosition;
        int i2 = 0;
        CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = null;
        while (true) {
            View childAt = getChildAt(i - iFindFirstVisibleItemPosition);
            if (childAt != null) {
                Object tag = childAt.getTag();
                CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder2 = tag instanceof CTInboxBaseMessageViewHolder ? (CTInboxBaseMessageViewHolder) tag : null;
                if (cTInboxBaseMessageViewHolder2 != null && cTInboxBaseMessageViewHolder2.needsMediaPlayer()) {
                    int iHeight = cTInboxBaseMessageViewHolder2.itemView.getGlobalVisibleRect(this.rect) ? this.rect.height() : 0;
                    if (iHeight > i2) {
                        cTInboxBaseMessageViewHolder = cTInboxBaseMessageViewHolder2;
                        i2 = iHeight;
                    }
                }
            }
            if (i == iFindLastVisibleItemPosition) {
                return cTInboxBaseMessageViewHolder;
            }
            i++;
        }
    }

    private final void initialize() {
        InboxVideoPlayerHandle inboxVideoPlayerHandle = this.handle;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        inboxVideoPlayerHandle.initExoplayer(context, new AnonymousClass1(this), new AnonymousClass2(this));
        InboxVideoPlayerHandle inboxVideoPlayerHandle2 = this.handle;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        inboxVideoPlayerHandle2.initPlayerView(context2, new AnonymousClass3(this));
        recyclerViewListeners();
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView$initialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaPlayerRecyclerView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object obj) {
            super(0, obj, MediaPlayerRecyclerView.class, "bufferingStarted", "bufferingStarted()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((MediaPlayerRecyclerView) this.receiver).bufferingStarted();
        }
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView$initialize$2, reason: invalid class name */
    /* JADX INFO: compiled from: MediaPlayerRecyclerView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass2(Object obj) {
            super(0, obj, MediaPlayerRecyclerView.class, "playerReady", "playerReady()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((MediaPlayerRecyclerView) this.receiver).playerReady();
        }
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView$initialize$3, reason: invalid class name */
    /* JADX INFO: compiled from: MediaPlayerRecyclerView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Drawable> {
        AnonymousClass3(Object obj) {
            super(0, obj, MediaPlayerRecyclerView.class, "artworkAsset", "artworkAsset()Landroid/graphics/drawable/Drawable;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Drawable invoke() {
            return ((MediaPlayerRecyclerView) this.receiver).artworkAsset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bufferingStarted() {
        CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = this.playingHolder;
        if (cTInboxBaseMessageViewHolder != null) {
            cTInboxBaseMessageViewHolder.playerBuffering();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playerReady() {
        CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = this.playingHolder;
        if (cTInboxBaseMessageViewHolder != null) {
            cTInboxBaseMessageViewHolder.playerReady();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable artworkAsset() {
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ct_audio, null);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    private final void recyclerViewListeners() {
        removeOnScrollListener(this.onScrollListener);
        removeOnChildAttachStateChangeListener(this.onChildAttachStateChangeListener);
        addOnScrollListener(this.onScrollListener);
        addOnChildAttachStateChangeListener(this.onChildAttachStateChangeListener);
    }

    private final void removeVideoView() {
        this.handle.pause();
        CTInboxBaseMessageViewHolder cTInboxBaseMessageViewHolder = this.playingHolder;
        if (cTInboxBaseMessageViewHolder != null) {
            cTInboxBaseMessageViewHolder.playerRemoved();
        }
    }
}
