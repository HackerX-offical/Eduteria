package com.appnew.android.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LiveStreamingYoutube.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$downloadPdfReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveStreamingYoutube$downloadPdfReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ LiveStreamingYoutube this$0;

    LiveStreamingYoutube$downloadPdfReceiver$1(LiveStreamingYoutube liveStreamingYoutube) {
        this.this$0 = liveStreamingYoutube;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            final LiveStreamingYoutube liveStreamingYoutube = this.this$0;
            if (intent.hasExtra("chatId")) {
                intent.getStringExtra("chatId");
                liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$downloadPdfReceiver$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveStreamingYoutube$downloadPdfReceiver$1.onReceive$lambda$1$lambda$0(liveStreamingYoutube);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReceive$lambda$1$lambda$0(LiveStreamingYoutube liveStreamingYoutube) {
        if (liveStreamingYoutube.recyclerChat != null) {
            RecyclerView recyclerView = liveStreamingYoutube.recyclerChat;
            Intrinsics.checkNotNull(recyclerView);
            if (recyclerView.getAdapter() != null) {
                RecyclerView recyclerView2 = liveStreamingYoutube.recyclerChat;
                Intrinsics.checkNotNull(recyclerView2);
                if (recyclerView2.getAdapter() instanceof ChatAdapter) {
                    RecyclerView recyclerView3 = liveStreamingYoutube.recyclerChat;
                    Intrinsics.checkNotNull(recyclerView3);
                    RecyclerView.Adapter adapter = recyclerView3.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
