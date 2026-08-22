package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.RecyclerView;
import com.clevertap.android.sdk.R;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes7.dex */
public class CTInboxBaseMessageViewHolder extends RecyclerView.ViewHolder {
    LinearLayout bodyRelativeLayout;
    RelativeLayout clickLayout;
    Context context;
    LinearLayout ctaLinearLayout;
    private CTInboxMessageContent firstContentItem;
    FrameLayout frameLayout;
    ImageView mediaImage;
    RelativeLayout mediaLayout;
    private CTInboxMessage message;
    private ImageView muteIcon;
    private WeakReference<CTInboxListViewFragment> parentWeakReference;
    FrameLayout progressBarFrameLayout;
    protected final ImageView readDot;
    RelativeLayout relativeLayout;
    private boolean requiresMediaPlayer;
    ImageView squareImage;

    int getImageBackgroundColor() {
        return 0;
    }

    CTInboxBaseMessageViewHolder(View view) {
        super(view);
        this.readDot = (ImageView) view.findViewById(R.id.read_circle);
    }

    public boolean addMediaPlayer(float f2, final Function0<Float> function0, Function3<String, Boolean, Boolean, Void> function3, View view) {
        FrameLayout layoutForMediaPlayer;
        int measuredHeight;
        int iRound;
        if (!this.requiresMediaPlayer || (layoutForMediaPlayer = getLayoutForMediaPlayer()) == null) {
            return false;
        }
        layoutForMediaPlayer.removeAllViews();
        layoutForMediaPlayer.setVisibility(8);
        Resources resources = this.context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (CTInboxActivity.orientation == 2) {
            if (this.message.getOrientation().equalsIgnoreCase(CmcdData.Factory.STREAM_TYPE_LIVE)) {
                measuredHeight = Math.round(this.mediaImage.getMeasuredHeight() * 1.76f);
                iRound = this.mediaImage.getMeasuredHeight();
            } else {
                measuredHeight = this.squareImage.getMeasuredHeight();
            }
        } else {
            measuredHeight = resources.getDisplayMetrics().widthPixels;
            iRound = this.message.getOrientation().equalsIgnoreCase(CmcdData.Factory.STREAM_TYPE_LIVE) ? Math.round(measuredHeight * 0.5625f) : measuredHeight;
        }
        view.setLayoutParams(new FrameLayout.LayoutParams(measuredHeight, iRound));
        layoutForMediaPlayer.addView(view);
        layoutForMediaPlayer.setBackgroundColor(Color.parseColor(this.message.getBgColor()));
        FrameLayout frameLayout = this.progressBarFrameLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        if (this.firstContentItem.mediaIsVideo()) {
            ImageView imageView = new ImageView(this.context);
            this.muteIcon = imageView;
            imageView.setVisibility(8);
            setMuteIconState(this.muteIcon, this.context, f2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 30.0f, displayMetrics), (int) TypedValue.applyDimension(1, 30.0f, displayMetrics));
            layoutParams.setMargins(0, (int) TypedValue.applyDimension(1, 4.0f, displayMetrics), (int) TypedValue.applyDimension(1, 2.0f, displayMetrics), 0);
            layoutParams.gravity = GravityCompat.END;
            this.muteIcon.setLayoutParams(layoutParams);
            this.muteIcon.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.m11925x3be7be9e(function0, view2);
                }
            });
            layoutForMediaPlayer.addView(this.muteIcon);
        }
        function3.invoke(this.firstContentItem.getMedia(), Boolean.valueOf(this.firstContentItem.mediaIsAudio()), Boolean.valueOf(this.firstContentItem.mediaIsVideo()));
        return true;
    }

    /* JADX INFO: renamed from: lambda$addMediaPlayer$0$com-clevertap-android-sdk-inbox-CTInboxBaseMessageViewHolder, reason: not valid java name */
    /* synthetic */ void m11925x3be7be9e(Function0 function0, View view) {
        setMuteIconState(this.muteIcon, this.context, ((Float) function0.invoke()).floatValue());
    }

    private void setMuteIconState(ImageView imageView, Context context, float f2) {
        int i;
        boolean z = f2 <= 0.0f;
        int i2 = z ? R.drawable.ct_volume_off : R.drawable.ct_volume_on;
        if (z) {
            i = R.string.ct_inbox_mute_button_content_description;
        } else {
            i = R.string.ct_inbox_unmute_button_content_description;
        }
        imageView.setContentDescription(context.getString(i));
        imageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), i2, null));
    }

    String calculateDisplayTimestamp(long j) {
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - j;
        if (jCurrentTimeMillis < 60) {
            return "Just Now";
        }
        if (jCurrentTimeMillis > 60 && jCurrentTimeMillis < 3540) {
            return (jCurrentTimeMillis / 60) + " mins ago";
        }
        if (jCurrentTimeMillis > 3540 && jCurrentTimeMillis < 81420) {
            long j2 = jCurrentTimeMillis / 3600;
            return j2 > 1 ? j2 + " hours ago" : j2 + " hour ago";
        }
        if (jCurrentTimeMillis > 86400 && jCurrentTimeMillis < 172800) {
            return "Yesterday";
        }
        return new SimpleDateFormat("dd MMM").format(new Date(j * 1000));
    }

    void configureWithMessage(CTInboxMessage cTInboxMessage, CTInboxListViewFragment cTInboxListViewFragment, int i) {
        this.context = cTInboxListViewFragment.getContext();
        this.parentWeakReference = new WeakReference<>(cTInboxListViewFragment);
        this.message = cTInboxMessage;
        CTInboxMessageContent cTInboxMessageContent = cTInboxMessage.getInboxMessageContents().get(0);
        this.firstContentItem = cTInboxMessageContent;
        this.requiresMediaPlayer = cTInboxMessageContent.mediaIsStreamable();
    }

    CTInboxListViewFragment getParent() {
        return this.parentWeakReference.get();
    }

    void hideOneButton(Button button, Button button2, Button button3) {
        button3.setVisibility(8);
        button.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 3.0f));
        button2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 3.0f));
        button3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
    }

    void hideTwoButtons(Button button, Button button2, Button button3) {
        button2.setVisibility(8);
        button3.setVisibility(8);
        button.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 6.0f));
        button2.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
        button3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 0.0f));
    }

    public boolean needsMediaPlayer() {
        return this.requiresMediaPlayer;
    }

    public void playerBuffering() {
        FrameLayout frameLayout = this.progressBarFrameLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    public void playerReady() {
        getLayoutForMediaPlayer().setVisibility(0);
        ImageView imageView = this.muteIcon;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        FrameLayout frameLayout = this.progressBarFrameLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    public void playerRemoved() {
        FrameLayout frameLayout = this.progressBarFrameLayout;
        if (frameLayout != null) {
            frameLayout.post(new Runnable() { // from class: com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11926xf820a4fc();
                }
            });
        }
        ImageView imageView = this.muteIcon;
        if (imageView != null) {
            imageView.post(new Runnable() { // from class: com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m11927x8c5f149b();
                }
            });
        }
        FrameLayout layoutForMediaPlayer = getLayoutForMediaPlayer();
        if (layoutForMediaPlayer != null) {
            layoutForMediaPlayer.removeAllViews();
        }
    }

    /* JADX INFO: renamed from: lambda$playerRemoved$1$com-clevertap-android-sdk-inbox-CTInboxBaseMessageViewHolder, reason: not valid java name */
    /* synthetic */ void m11926xf820a4fc() {
        this.progressBarFrameLayout.setVisibility(8);
    }

    /* JADX INFO: renamed from: lambda$playerRemoved$2$com-clevertap-android-sdk-inbox-CTInboxBaseMessageViewHolder, reason: not valid java name */
    /* synthetic */ void m11927x8c5f149b() {
        this.muteIcon.setVisibility(8);
    }

    void setDots(ImageView[] imageViewArr, int i, Context context, LinearLayout linearLayout) {
        for (int i2 = 0; i2 < i; i2++) {
            ImageView imageView = new ImageView(context);
            imageViewArr[i2] = imageView;
            imageView.setVisibility(0);
            imageViewArr[i2].setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ct_unselected_dot, null));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(8, 6, 4, 6);
            layoutParams.gravity = 17;
            if (linearLayout.getChildCount() < i) {
                linearLayout.addView(imageViewArr[i2], layoutParams);
            }
        }
    }

    public boolean shouldAutoPlay() {
        return this.firstContentItem.mediaIsVideo();
    }

    private FrameLayout getLayoutForMediaPlayer() {
        return this.frameLayout;
    }

    protected void markItemAsRead(final CTInboxMessage cTInboxMessage, final int i) {
        new Handler().postDelayed(new Runnable() { // from class: com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder.1
            @Override // java.lang.Runnable
            public void run() {
                FragmentActivity activity;
                final CTInboxListViewFragment parent = CTInboxBaseMessageViewHolder.this.getParent();
                if (parent == null || (activity = parent.getActivity()) == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CTInboxBaseMessageViewHolder.this.readDot.getVisibility() == 0) {
                            parent.didShow(null, i);
                        }
                        CTInboxBaseMessageViewHolder.this.readDot.setVisibility(8);
                        cTInboxMessage.setRead(true);
                    }
                });
            }
        }, 2000L);
    }
}
