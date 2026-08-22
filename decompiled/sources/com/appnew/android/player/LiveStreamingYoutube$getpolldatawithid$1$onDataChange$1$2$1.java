package com.appnew.android.player;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.PlayerPojo.Polldata;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LiveStreamingYoutube.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/appnew/android/player/LiveStreamingYoutube$getpolldatawithid$1$onDataChange$1$2$1", "Landroid/os/CountDownTimer;", "onTick", "", "millisUntilFinished", "", "onFinish", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveStreamingYoutube$getpolldatawithid$1$onDataChange$1$2$1 extends CountDownTimer {
    final /* synthetic */ Polldata $polldata;
    final /* synthetic */ String $randomid;
    final /* synthetic */ LiveStreamingYoutube this$0;

    @Override // android.os.CountDownTimer
    public void onTick(long millisUntilFinished) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LiveStreamingYoutube$getpolldatawithid$1$onDataChange$1$2$1(String str, Polldata polldata, LiveStreamingYoutube liveStreamingYoutube, long j) {
        super(j, 1000L);
        this.$randomid = str;
        this.$polldata = polldata;
        this.this$0 = liveStreamingYoutube;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        String str = this.$randomid;
        if (str != null) {
            this.$polldata.setRendomkey(str);
            this.$polldata.setStatus("1");
            Log.e("TAG_APP", "onDataChange: 3209");
            final LiveStreamingYoutube liveStreamingYoutube = this.this$0;
            liveStreamingYoutube.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getpolldatawithid$1$onDataChange$1$2$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube$getpolldatawithid$1$onDataChange$1$2$1.onFinish$lambda$0(liveStreamingYoutube);
                }
            });
            ((Polldata) Objects.requireNonNull(this.$polldata)).setMyAnswer("0");
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, this.$polldata);
            arrayList.addAll(this.this$0.getPollarraylist());
            this.this$0.getPollarraylist().clear();
            this.this$0.getPollarraylist().addAll(arrayList);
            final LiveStreamingYoutube liveStreamingYoutube2 = this.this$0;
            liveStreamingYoutube2.runOnUiThread(new Runnable() { // from class: com.appnew.android.player.LiveStreamingYoutube$getpolldatawithid$1$onDataChange$1$2$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LiveStreamingYoutube$getpolldatawithid$1$onDataChange$1$2$1.onFinish$lambda$1(liveStreamingYoutube2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFinish$lambda$0(LiveStreamingYoutube liveStreamingYoutube) {
        View rootView = liveStreamingYoutube.getRootView();
        Intrinsics.checkNotNull(rootView);
        Snackbar.make(rootView.getRootView(), "New Poll Added", -1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFinish$lambda$1(LiveStreamingYoutube liveStreamingYoutube) {
        if (liveStreamingYoutube.recylerViewPollOperator != null) {
            RecyclerView recyclerView = liveStreamingYoutube.recylerViewPollOperator;
            Intrinsics.checkNotNull(recyclerView);
            if (recyclerView.getAdapter() != null) {
                RecyclerView recyclerView2 = liveStreamingYoutube.recylerViewPollOperator;
                Intrinsics.checkNotNull(recyclerView2);
                if (recyclerView2.getAdapter() instanceof PollAdapter) {
                    RecyclerView recyclerView3 = liveStreamingYoutube.recylerViewPollOperator;
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
