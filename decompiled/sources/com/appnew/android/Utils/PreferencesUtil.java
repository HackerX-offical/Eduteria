package com.appnew.android.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageButton;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import com.eduteria.app.app.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Preference.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ \u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\"\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u000e\u0010!\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c¨\u0006\""}, d2 = {"Lcom/appnew/android/Utils/PreferencesUtil;", "", "<init>", "()V", "getSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "setStringPreference", "", "key", "", "val", "setBooleanPreference", "", "setIntegerPreference", "", "getStringPreference", "getStringPreference1", "getBooleanPreference", "getIntegerPreference", "getAllPreference", "removePreference", "removeAllPreference", "setupPlayPauseButtonVisibility", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "playerView", "Landroidx/media3/ui/PlayerView;", "updatePlayPauseVisibility", "playButton", "Landroid/view/View;", "pauseButton", "changeFastForwardBackwardIcons", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreferencesUtil {
    public static final int $stable = 0;
    public static final PreferencesUtil INSTANCE = new PreferencesUtil();

    private PreferencesUtil() {
    }

    private final SharedPreferences getSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tag", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public final void setStringPreference(Context context, String key, String val) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.putString(key, val);
        editorEdit.apply();
    }

    public final void setBooleanPreference(Context context, String key, boolean val) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.putBoolean(key, val);
        editorEdit.commit();
    }

    public final void setIntegerPreference(Context context, String key, int val) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.putInt(key, val);
        editorEdit.commit();
    }

    public final String getStringPreference(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getString(key, "");
    }

    public final String getStringPreference1(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getString(key, "0");
    }

    public final boolean getBooleanPreference(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getBoolean(key, false);
    }

    public final int getIntegerPreference(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getInt(key, -1);
    }

    public final String getAllPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Map<String, ?> all = getSharedPreferences(context).getAll();
        String str = "";
        try {
            Intrinsics.checkNotNull(all);
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Intrinsics.checkNotNull(value);
                str = str + "\t" + key + " = " + value + "\t";
            }
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public final void removePreference(Context context, String key) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.remove(key);
        editorEdit.commit();
    }

    public final void removeAllPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = getSharedPreferences(context).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    public final void setupPlayPauseButtonVisibility(final ExoPlayer exoPlayer, PlayerView playerView) {
        Intrinsics.checkNotNullParameter(exoPlayer, "exoPlayer");
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        final View viewFindViewById = playerView.findViewById(R.id.exo_play);
        final View viewFindViewById2 = playerView.findViewById(R.id.exo_pause);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.PreferencesUtil$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreferencesUtil.setupPlayPauseButtonVisibility$lambda$0(exoPlayer, viewFindViewById, viewFindViewById2, view);
                }
            });
        }
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.PreferencesUtil$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PreferencesUtil.setupPlayPauseButtonVisibility$lambda$1(exoPlayer, viewFindViewById, viewFindViewById2, view);
                }
            });
        }
        exoPlayer.addListener(new Player.Listener() { // from class: com.appnew.android.Utils.PreferencesUtil.setupPlayPauseButtonVisibility.3
            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackStateChanged(int playbackState) {
                PreferencesUtil.INSTANCE.updatePlayPauseVisibility(exoPlayer, viewFindViewById, viewFindViewById2);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onIsPlayingChanged(boolean isPlaying) {
                PreferencesUtil.INSTANCE.updatePlayPauseVisibility(exoPlayer, viewFindViewById, viewFindViewById2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupPlayPauseButtonVisibility$lambda$0(ExoPlayer exoPlayer, View view, View view2, View view3) {
        if (!exoPlayer.isPlaying()) {
            exoPlayer.play();
        }
        INSTANCE.updatePlayPauseVisibility(exoPlayer, view, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupPlayPauseButtonVisibility$lambda$1(ExoPlayer exoPlayer, View view, View view2, View view3) {
        if (exoPlayer.isPlaying()) {
            exoPlayer.pause();
        }
        INSTANCE.updatePlayPauseVisibility(exoPlayer, view, view2);
    }

    public final void updatePlayPauseVisibility(ExoPlayer exoPlayer, View playButton, View pauseButton) {
        Intrinsics.checkNotNullParameter(exoPlayer, "exoPlayer");
        if (exoPlayer.isPlaying()) {
            if (playButton != null) {
                playButton.setVisibility(8);
            }
            if (pauseButton != null) {
                pauseButton.setVisibility(0);
                return;
            }
            return;
        }
        if (playButton != null) {
            playButton.setVisibility(0);
        }
        if (pauseButton != null) {
            pauseButton.setVisibility(8);
        }
    }

    public final void changeFastForwardBackwardIcons(PlayerView playerView) {
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        ImageButton imageButton = (ImageButton) playerView.findViewById(R.id.exo_rew);
        ImageButton imageButton2 = (ImageButton) playerView.findViewById(R.id.exo_ffwd);
        if (imageButton != null) {
            imageButton.setImageResource(R.drawable.ic_fast_rewind_white_24);
        }
        if (imageButton2 != null) {
            imageButton2.setImageResource(R.drawable.ic_fast_ffd_white_24);
        }
    }
}
