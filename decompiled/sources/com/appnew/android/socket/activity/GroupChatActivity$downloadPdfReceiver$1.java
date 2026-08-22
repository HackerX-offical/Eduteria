package com.appnew.android.socket.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appnew.android.Model.chatPojo;
import com.appnew.android.socket.adapter.GroupChatAdapter2;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GroupChatActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/appnew/android/socket/activity/GroupChatActivity$downloadPdfReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupChatActivity$downloadPdfReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ GroupChatActivity this$0;

    GroupChatActivity$downloadPdfReceiver$1(GroupChatActivity groupChatActivity) {
        this.this$0 = groupChatActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            final GroupChatActivity groupChatActivity = this.this$0;
            if (intent.hasExtra("chatId")) {
                String stringExtra = intent.getStringExtra("chatId");
                int size = groupChatActivity.chatList.size();
                for (final int i = 0; i < size; i++) {
                    if (Intrinsics.areEqual(((chatPojo) groupChatActivity.chatList.get(i)).getId(), stringExtra)) {
                        groupChatActivity.runOnUiThread(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$downloadPdfReceiver$1$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                GroupChatActivity$downloadPdfReceiver$1.onReceive$lambda$1$lambda$0(groupChatActivity, i);
                            }
                        });
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReceive$lambda$1$lambda$0(GroupChatActivity groupChatActivity, int i) {
        if (groupChatActivity.groupChatAdapter2 != null) {
            GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
            Intrinsics.checkNotNull(groupChatAdapter2);
            groupChatAdapter2.notifyItemChanged(i);
        }
    }
}
