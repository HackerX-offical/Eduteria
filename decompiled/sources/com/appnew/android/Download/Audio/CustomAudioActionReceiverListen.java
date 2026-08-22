package com.appnew.android.Download.Audio;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.Player;
import androidx.media3.ui.PlayerNotificationManager;
import com.appnew.android.player.music_player.MusicService;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class CustomAudioActionReceiverListen implements PlayerNotificationManager.CustomActionReceiver {
    String[] audioPlayBackSpeedList;
    AudioPlayerService audioPlayerService;
    Context mContext;

    @Override // androidx.media3.ui.PlayerNotificationManager.CustomActionReceiver
    public Map<String, NotificationCompat.Action> createCustomActions(Context context, int instanceId) {
        this.mContext = context;
        NotificationCompat.Action action = new NotificationCompat.Action(R.drawable.white_cross, "cross", PendingIntent.getBroadcast(context, instanceId, new Intent("cross").setPackage(context.getPackageName()), Build.VERSION.SDK_INT >= 31 ? GroupFlagsKt.HasAuxSlotFlag : 268435456));
        HashMap map = new HashMap();
        map.put("cross", action);
        return map;
    }

    @Override // androidx.media3.ui.PlayerNotificationManager.CustomActionReceiver
    public List<String> getCustomActions(Player player) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("cross");
        return arrayList;
    }

    @Override // androidx.media3.ui.PlayerNotificationManager.CustomActionReceiver
    public void onCustomAction(Player player, String action, Intent intent) {
        if (!action.equalsIgnoreCase("cross") || this.audioPlayerService == null) {
            return;
        }
        if (player != null) {
            player.stop();
            player.release();
        }
        this.audioPlayerService.releaseAll();
        this.audioPlayerService.sendResults(true);
    }

    public CustomAudioActionReceiverListen(AudioPlayerService audioPlayerService) {
        this.audioPlayerService = audioPlayerService;
    }

    private void sendOnAudioPlayer() {
        Intent intent = new Intent(MusicService.MUSIC_PLAYER_ACTION_STOP);
        intent.putExtra("result", true);
        intent.putExtra("CLOSE_MUSIC_PLAYER", true);
        LocalBroadcastManager.getInstance(this.audioPlayerService).sendBroadcast(intent);
    }
}
