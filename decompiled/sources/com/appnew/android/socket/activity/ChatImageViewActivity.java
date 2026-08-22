package com.appnew.android.socket.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Helper;
import com.appnew.android.databinding.ActivityChatImageViewBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChatImageViewActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/socket/activity/ChatImageViewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityChatImageViewBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatImageViewActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private ActivityChatImageViewBinding binding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChatImageViewActivity chatImageViewActivity = this;
        Helper.setSystemBarLight(chatImageViewActivity);
        Helper.enableScreenShot(chatImageViewActivity);
        ActivityChatImageViewBinding activityChatImageViewBindingInflate = ActivityChatImageViewBinding.inflate(getLayoutInflater());
        this.binding = activityChatImageViewBindingInflate;
        ActivityChatImageViewBinding activityChatImageViewBinding = null;
        if (activityChatImageViewBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityChatImageViewBindingInflate = null;
        }
        setContentView(activityChatImageViewBindingInflate.getRoot());
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("url")) {
            String stringExtra = intent.getStringExtra("url");
            ActivityChatImageViewBinding activityChatImageViewBinding2 = this.binding;
            if (activityChatImageViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityChatImageViewBinding2 = null;
            }
            Glide.with((FragmentActivity) this).load(stringExtra).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.color.colorPrimary).error(R.color.colorPrimary).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate()).into(activityChatImageViewBinding2.image);
        }
        ActivityChatImageViewBinding activityChatImageViewBinding3 = this.binding;
        if (activityChatImageViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityChatImageViewBinding = activityChatImageViewBinding3;
        }
        activityChatImageViewBinding.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.socket.activity.ChatImageViewActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ChatImageViewActivity.onCreate$lambda$3$lambda$2(this.f$0);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3$lambda$2(ChatImageViewActivity chatImageViewActivity) {
        chatImageViewActivity.getOnBackPressedDispatcher().onBackPressed();
        return Unit.INSTANCE;
    }
}
