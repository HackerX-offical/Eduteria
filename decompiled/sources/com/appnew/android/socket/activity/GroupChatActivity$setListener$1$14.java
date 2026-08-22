package com.appnew.android.socket.activity;

import android.os.SystemClock;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.chatPojo;
import com.appnew.android.databinding.ActivityGroupChat2Binding;
import com.appnew.android.socket.SocketManager;
import com.appnew.android.socket.adapter.GroupChatAdapter2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: GroupChatActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/appnew/android/socket/activity/GroupChatActivity$setListener$1$14", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupChatActivity$setListener$1$14 extends RecyclerView.OnScrollListener {
    final /* synthetic */ ActivityGroupChat2Binding $this_apply;
    final /* synthetic */ GroupChatActivity this$0;

    GroupChatActivity$setListener$1$14(GroupChatActivity groupChatActivity, ActivityGroupChat2Binding activityGroupChat2Binding) {
        this.this$0 = groupChatActivity;
        this.$this_apply = activityGroupChat2Binding;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        if (dy < 0) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            System.out.println(iFindFirstVisibleItemPosition);
            if (iFindFirstVisibleItemPosition != 0 || SystemClock.elapsedRealtime() - this.this$0.lastClickTime < 2000) {
                return;
            }
            this.this$0.lastClickTime = SystemClock.elapsedRealtime();
            RecyclerView recyclerView2 = this.$this_apply.chatRecycler;
            final GroupChatActivity groupChatActivity = this.this$0;
            recyclerView2.postDelayed(new Runnable() { // from class: com.appnew.android.socket.activity.GroupChatActivity$setListener$1$14$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    GroupChatActivity$setListener$1$14.onScrolled$lambda$0(groupChatActivity);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScrolled$lambda$0(GroupChatActivity groupChatActivity) throws JSONException {
        if (groupChatActivity.socketManager != null) {
            groupChatActivity.hasUserScrolled = true;
            if (groupChatActivity.chatList.isEmpty() || groupChatActivity.chatList.size() <= 1 || !groupChatActivity.hasNextData) {
                return;
            }
            SocketManager socketManager = null;
            if (Intrinsics.areEqual(((chatPojo) groupChatActivity.chatList.get(0)).getViewType(), "date")) {
                SocketManager socketManager2 = groupChatActivity.socketManager;
                if (socketManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("socketManager");
                } else {
                    socketManager = socketManager2;
                }
                socketManager.fetchMessageHistory(groupChatActivity.Chat_node, ((chatPojo) groupChatActivity.chatList.get(1)).getId());
            } else {
                SocketManager socketManager3 = groupChatActivity.socketManager;
                if (socketManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("socketManager");
                } else {
                    socketManager = socketManager3;
                }
                socketManager.fetchMessageHistory(groupChatActivity.Chat_node, ((chatPojo) groupChatActivity.chatList.get(0)).getId());
            }
            groupChatActivity.chatList.add(0, new chatPojo("loader", ((chatPojo) groupChatActivity.chatList.get(0)).getDate()));
            if (groupChatActivity.groupChatAdapter2 != null) {
                GroupChatAdapter2 groupChatAdapter2 = groupChatActivity.groupChatAdapter2;
                Intrinsics.checkNotNull(groupChatAdapter2);
                groupChatAdapter2.notifyItemRangeInserted(0, 1);
            }
        }
    }
}
