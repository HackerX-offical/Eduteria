package com.appnew.android.ExtraClass.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.ExtraClass.Activity.DrmExtraPlayer;
import com.appnew.android.ExtraClass.Activity.ExtraAwsPlayer;
import com.appnew.android.ExtraClass.Activity.YoutubeExtraPlayer;
import com.appnew.android.Theme.Adapter.ExtensionsKt;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ExtraClassRvItemBinding;
import com.appnew.android.home.model.ExtraParams;
import com.appnew.android.home.model.ExtraVideoType;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: ExtraClassRVAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB3\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006 "}, d2 = {"Lcom/appnew/android/ExtraClass/adapters/ExtraClassRVAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/ExtraClass/adapters/ExtraClassRVAdapter$ExtraClassRVHolder;", "context", "Landroid/content/Context;", "videoTypeArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/home/model/ExtraVideoType;", "Lkotlin/collections/ArrayList;", "isFromLive", "", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Z)V", "getContext", "()Landroid/content/Context;", "getVideoTypeArrayList", "()Ljava/util/ArrayList;", "()Z", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "formatSeconds", "", "timeInSeconds", "ExtraClassRVHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtraClassRVAdapter extends RecyclerView.Adapter<ExtraClassRVHolder> {
    public static final int $stable = 8;
    private final Context context;
    private final boolean isFromLive;
    private final ArrayList<ExtraVideoType> videoTypeArrayList;

    public /* synthetic */ ExtraClassRVAdapter(Context context, ArrayList arrayList, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, arrayList, (i & 4) != 0 ? true : z);
    }

    public final Context getContext() {
        return this.context;
    }

    public final ArrayList<ExtraVideoType> getVideoTypeArrayList() {
        return this.videoTypeArrayList;
    }

    /* JADX INFO: renamed from: isFromLive, reason: from getter */
    public final boolean getIsFromLive() {
        return this.isFromLive;
    }

    public ExtraClassRVAdapter(Context context, ArrayList<ExtraVideoType> videoTypeArrayList, boolean z) {
        Intrinsics.checkNotNullParameter(videoTypeArrayList, "videoTypeArrayList");
        this.context = context;
        this.videoTypeArrayList = videoTypeArrayList;
        this.isFromLive = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ExtraClassRVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ExtraClassRvItemBinding extraClassRvItemBindingInflate = ExtraClassRvItemBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(extraClassRvItemBindingInflate, "inflate(...)");
        return new ExtraClassRVHolder(extraClassRvItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ExtraClassRVHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ExtraParams extraParams = this.videoTypeArrayList.get(position).getExtraParams();
        Intrinsics.checkNotNull(extraParams);
        if (StringsKt.equals$default(extraParams.isLimited(), "1", false, 2, null)) {
            holder.getExtraClassRvItemBinding().LogsLL.setVisibility(0);
            TextView textView = holder.getExtraClassRvItemBinding().duration;
            String videoLength = this.videoTypeArrayList.get(position).getVideoLength();
            Intrinsics.checkNotNull(videoLength);
            textView.setText(formatSeconds(Integer.parseInt(videoLength)));
            TextView textView2 = holder.getExtraClassRvItemBinding().totalViewTime;
            String videoLength2 = this.videoTypeArrayList.get(position).getVideoLength();
            Intrinsics.checkNotNull(videoLength2);
            long j = Long.parseLong(videoLength2);
            String remainingTime = this.videoTypeArrayList.get(position).getRemainingTime();
            Intrinsics.checkNotNull(remainingTime);
            textView2.setText(formatSeconds((int) (j - Long.parseLong((String) StringsKt.split$default((CharSequence) remainingTime, new String[]{"_"}, false, 0, 6, (Object) null).get(0)))));
            TextView textView3 = holder.getExtraClassRvItemBinding().remainingTime;
            String remainingTime2 = this.videoTypeArrayList.get(position).getRemainingTime();
            Intrinsics.checkNotNull(remainingTime2);
            textView3.setText(formatSeconds(Integer.parseInt((String) StringsKt.split$default((CharSequence) remainingTime2, new String[]{"_"}, false, 0, 6, (Object) null).get(0))));
        } else {
            holder.getExtraClassRvItemBinding().LogsLL.setVisibility(8);
        }
        if (this.videoTypeArrayList.get(position).getThumbnailUrl() != null) {
            String thumbnailUrl = this.videoTypeArrayList.get(position).getThumbnailUrl();
            Intrinsics.checkNotNull(thumbnailUrl);
            if (thumbnailUrl.length() > 0 && this.context != null) {
                ImageView ibtSingleSubVdIv = holder.getExtraClassRvItemBinding().ibtSingleSubVdIv;
                Intrinsics.checkNotNullExpressionValue(ibtSingleSubVdIv, "ibtSingleSubVdIv");
                Context context = this.context;
                String thumbnailUrl2 = this.videoTypeArrayList.get(position).getThumbnailUrl();
                Intrinsics.checkNotNull(thumbnailUrl2);
                ExtensionsKt.load(ibtSingleSubVdIv, context, thumbnailUrl2);
            }
        }
        holder.getExtraClassRvItemBinding().ibtSingleSubVdTvTitle.setText(this.videoTypeArrayList.get(position).getTitle());
        TextView textView4 = holder.getExtraClassRvItemBinding().durationTV;
        Context context2 = this.context;
        Intrinsics.checkNotNull(context2);
        textView4.setText(context2.getResources().getString(R.string.duration) + this.videoTypeArrayList.get(position).getVideoLength());
        holder.getExtraClassRvItemBinding().attemptLL.setVisibility(8);
        holder.getExtraClassRvItemBinding().share.setVisibility(8);
        holder.getExtraClassRvItemBinding().realte.setVisibility(0);
        holder.getExtraClassRvItemBinding().learn.setVisibility(8);
        holder.getExtraClassRvItemBinding().practice.setVisibility(8);
        holder.getExtraClassRvItemBinding().readNow.setVisibility(8);
        holder.getExtraClassRvItemBinding().subjectBTNLL.setVisibility(8);
        holder.getExtraClassRvItemBinding().practice.setVisibility(8);
        holder.getExtraClassRvItemBinding().watchNow.setVisibility(0);
        holder.getExtraClassRvItemBinding().watchNow.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.ExtraClass.adapters.ExtraClassRVAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExtraClassRVAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(ExtraClassRVAdapter extraClassRVAdapter, int i, View view) {
        String videoType = extraClassRVAdapter.videoTypeArrayList.get(i).getVideoType();
        if (videoType != null) {
            int iHashCode = videoType.hashCode();
            if (iHashCode == 49) {
                if (videoType.equals("1")) {
                    Intent intent = new Intent(extraClassRVAdapter.context, (Class<?>) YoutubeExtraPlayer.class);
                    intent.putExtra("videourl", extraClassRVAdapter.videoTypeArrayList.get(i).getFileUrl());
                    intent.putExtra("videoname", extraClassRVAdapter.videoTypeArrayList.get(i).getTitle());
                    intent.putExtra("type", "1");
                    Context context = extraClassRVAdapter.context;
                    Intrinsics.checkNotNull(context);
                    context.startActivity(intent);
                    return;
                }
                return;
            }
            if (iHashCode == 52) {
                if (videoType.equals("4")) {
                    Intent intent2 = new Intent(extraClassRVAdapter.context, (Class<?>) YoutubeExtraPlayer.class);
                    intent2.putExtra("videourl", extraClassRVAdapter.videoTypeArrayList.get(i).getFileUrl());
                    intent2.putExtra("videoname", extraClassRVAdapter.videoTypeArrayList.get(i).getTitle());
                    intent2.putExtra("type", "4");
                    Context context2 = extraClassRVAdapter.context;
                    Intrinsics.checkNotNull(context2);
                    context2.startActivity(intent2);
                    return;
                }
                return;
            }
            if (iHashCode == 55) {
                if (videoType.equals("7")) {
                    if (StringsKt.equals$default(extraClassRVAdapter.videoTypeArrayList.get(i).isDrm(), "0", false, 2, null)) {
                        Intent intent3 = new Intent(extraClassRVAdapter.context, (Class<?>) ExtraAwsPlayer.class);
                        intent3.putExtra("videourl", extraClassRVAdapter.videoTypeArrayList.get(i).getFileUrl());
                        intent3.putExtra("videoname", extraClassRVAdapter.videoTypeArrayList.get(i).getTitle());
                        intent3.putExtra("type", "7");
                        Context context3 = extraClassRVAdapter.context;
                        Intrinsics.checkNotNull(context3);
                        context3.startActivity(intent3);
                        return;
                    }
                    Intent intent4 = new Intent(extraClassRVAdapter.context, (Class<?>) DrmExtraPlayer.class);
                    intent4.putExtra("vcd_id", extraClassRVAdapter.videoTypeArrayList.get(i).getVdcId());
                    intent4.putExtra("videoname", extraClassRVAdapter.videoTypeArrayList.get(i).getTitle());
                    intent4.putExtra("userid", SharedPreference.getInstance().getLoggedInUser().getId());
                    intent4.putExtra("type", "7");
                    Context context4 = extraClassRVAdapter.context;
                    Intrinsics.checkNotNull(context4);
                    context4.startActivity(intent4);
                    return;
                }
                return;
            }
            if (iHashCode == 56 && videoType.equals("8")) {
                if (StringsKt.equals$default(extraClassRVAdapter.videoTypeArrayList.get(i).isDrm(), "0", false, 2, null)) {
                    Intent intent5 = new Intent(extraClassRVAdapter.context, (Class<?>) ExtraAwsPlayer.class);
                    intent5.putExtra("videourl", extraClassRVAdapter.videoTypeArrayList.get(i).getFileUrl());
                    intent5.putExtra("videoname", extraClassRVAdapter.videoTypeArrayList.get(i).getTitle());
                    intent5.putExtra("type", "8");
                    Context context5 = extraClassRVAdapter.context;
                    Intrinsics.checkNotNull(context5);
                    context5.startActivity(intent5);
                    return;
                }
                Intent intent6 = new Intent(extraClassRVAdapter.context, (Class<?>) DrmExtraPlayer.class);
                intent6.putExtra("vcd_id", extraClassRVAdapter.videoTypeArrayList.get(i).getVdcId());
                intent6.putExtra("videoname", extraClassRVAdapter.videoTypeArrayList.get(i).getTitle());
                intent6.putExtra("userid", SharedPreference.getInstance().getLoggedInUser().getId());
                intent6.putExtra("type", "8");
                Context context6 = extraClassRVAdapter.context;
                Intrinsics.checkNotNull(context6);
                context6.startActivity(intent6);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.videoTypeArrayList.size();
    }

    public final String formatSeconds(int timeInSeconds) {
        int i = timeInSeconds / 3600;
        int i2 = timeInSeconds - (i * 3600);
        int i3 = i2 / 60;
        int i4 = i2 - (i3 * 60);
        String str = (i < 10 ? "0" : "") + i + ":";
        if (i3 < 10) {
            str = str + "0";
        }
        String str2 = str + i3 + ":";
        if (i4 < 10) {
            str2 = str2 + "0";
        }
        return str2 + i4;
    }

    /* JADX INFO: compiled from: ExtraClassRVAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/appnew/android/ExtraClass/adapters/ExtraClassRVAdapter$ExtraClassRVHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "extraClassRvItemBinding", "Lcom/appnew/android/databinding/ExtraClassRvItemBinding;", "<init>", "(Lcom/appnew/android/databinding/ExtraClassRvItemBinding;)V", "getExtraClassRvItemBinding", "()Lcom/appnew/android/databinding/ExtraClassRvItemBinding;", "setExtraClassRvItemBinding", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ExtraClassRVHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private ExtraClassRvItemBinding extraClassRvItemBinding;

        public final ExtraClassRvItemBinding getExtraClassRvItemBinding() {
            return this.extraClassRvItemBinding;
        }

        public final void setExtraClassRvItemBinding(ExtraClassRvItemBinding extraClassRvItemBinding) {
            Intrinsics.checkNotNullParameter(extraClassRvItemBinding, "<set-?>");
            this.extraClassRvItemBinding = extraClassRvItemBinding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExtraClassRVHolder(ExtraClassRvItemBinding extraClassRvItemBinding) {
            super(extraClassRvItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(extraClassRvItemBinding, "extraClassRvItemBinding");
            this.extraClassRvItemBinding = extraClassRvItemBinding;
        }
    }
}
