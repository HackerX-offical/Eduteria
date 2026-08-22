package com.appnew.android.socket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.chatPojo;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Helper;
import com.appnew.android.databinding.ActivityPinnedChatBinding;
import com.appnew.android.socket.adapter.GroupChatAdapter2;
import com.appnew.android.socket.models.ChatModel;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PinnedChatActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/socket/activity/PinnedChatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityPinnedChatBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityPinnedChatBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityPinnedChatBinding;)V", "groupChatAdapter2", "Lcom/appnew/android/socket/adapter/GroupChatAdapter2;", "chatList", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/chatPojo;", "Lkotlin/collections/ArrayList;", "chatModel", "Lcom/appnew/android/socket/models/ChatModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setData", "onDestroy", "onPause", "pauseAudio", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PinnedChatActivity extends AppCompatActivity {
    public static final int $stable = 8;
    public ActivityPinnedChatBinding binding;
    private ArrayList<chatPojo> chatList = new ArrayList<>();
    private ChatModel chatModel;
    private GroupChatAdapter2 groupChatAdapter2;

    public final ActivityPinnedChatBinding getBinding() {
        ActivityPinnedChatBinding activityPinnedChatBinding = this.binding;
        if (activityPinnedChatBinding != null) {
            return activityPinnedChatBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityPinnedChatBinding activityPinnedChatBinding) {
        Intrinsics.checkNotNullParameter(activityPinnedChatBinding, "<set-?>");
        this.binding = activityPinnedChatBinding;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PinnedChatActivity pinnedChatActivity = this;
        Helper.setSystemBarLight(pinnedChatActivity);
        Helper.enableScreenShot(pinnedChatActivity);
        setBinding(ActivityPinnedChatBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("data")) {
                Serializable serializableExtra = intent.getSerializableExtra("data");
                Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.ArrayList<com.appnew.android.Model.chatPojo>");
                ArrayList<chatPojo> arrayList = (ArrayList) serializableExtra;
                this.chatList = arrayList;
                if (arrayList.size() > 0 && !Intrinsics.areEqual(this.chatList.get(0).getViewType(), "date")) {
                    this.chatList.add(0, new chatPojo("date", this.chatList.get(0).getDate()));
                }
            }
            if (intent.hasExtra("chat_model")) {
                Serializable serializableExtra2 = intent.getSerializableExtra("chat_model");
                Intrinsics.checkNotNull(serializableExtra2, "null cannot be cast to non-null type com.appnew.android.socket.models.ChatModel");
                this.chatModel = (ChatModel) serializableExtra2;
            }
            setData();
        }
    }

    private final ActivityPinnedChatBinding setData() {
        ActivityPinnedChatBinding binding = getBinding();
        PinnedChatActivity pinnedChatActivity = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(pinnedChatActivity);
        linearLayoutManager.setAutoMeasureEnabled(false);
        linearLayoutManager.setStackFromEnd(true);
        binding.chatRecycler.setLayoutManager(linearLayoutManager);
        ChatModel chatModel = this.chatModel;
        if (chatModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chatModel");
            chatModel = null;
        }
        this.groupChatAdapter2 = new GroupChatAdapter2(pinnedChatActivity, "", chatModel, this.chatList, null, 16, null);
        binding.chatRecycler.setAdapter(this.groupChatAdapter2);
        if (!this.chatList.isEmpty()) {
            ProgressBar progressBar = binding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
            progressBar.setVisibility(8);
            RelativeLayout noDataFoundRL = binding.ndf.noDataFoundRL;
            Intrinsics.checkNotNullExpressionValue(noDataFoundRL, "noDataFoundRL");
            noDataFoundRL.setVisibility(8);
            RecyclerView chatRecycler = binding.chatRecycler;
            Intrinsics.checkNotNullExpressionValue(chatRecycler, "chatRecycler");
            chatRecycler.setVisibility(0);
        } else {
            ProgressBar progressBar2 = binding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar2, "progressBar");
            progressBar2.setVisibility(8);
            RelativeLayout noDataFoundRL2 = binding.ndf.noDataFoundRL;
            Intrinsics.checkNotNullExpressionValue(noDataFoundRL2, "noDataFoundRL");
            noDataFoundRL2.setVisibility(0);
            RecyclerView chatRecycler2 = binding.chatRecycler;
            Intrinsics.checkNotNullExpressionValue(chatRecycler2, "chatRecycler");
            chatRecycler2.setVisibility(8);
        }
        binding.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.PinnedChatActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PinnedChatActivity.setData$lambda$2$lambda$1(this.f$0);
            }
        }));
        return binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setData$lambda$2$lambda$1(PinnedChatActivity pinnedChatActivity) {
        pinnedChatActivity.onBackPressed();
        return Unit.INSTANCE;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        pauseAudio();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        pauseAudio();
    }

    private final void pauseAudio() {
        GroupChatAdapter2 groupChatAdapter2 = this.groupChatAdapter2;
        if (groupChatAdapter2 == null || groupChatAdapter2 == null) {
            return;
        }
        groupChatAdapter2.pauseAudio();
    }
}
