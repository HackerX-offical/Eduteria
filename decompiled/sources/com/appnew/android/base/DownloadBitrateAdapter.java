package com.appnew.android.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.YoutubeVideoData;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.DownloadUrlBitrateBinding;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: DownloadBitrateAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B3\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001c\u0010\u0016\u001a\u00020\t2\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014H\u0016R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/base/DownloadBitrateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/base/DownloadBitrateAdapter$DownloadViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/YoutubeVideoData;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "<init>", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getList", "()Ljava/util/ArrayList;", "getListener", "()Lkotlin/jvm/functions/Function1;", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", Const.POSITION, "DownloadViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DownloadBitrateAdapter extends RecyclerView.Adapter<DownloadViewHolder> {
    public static final int $stable = 8;
    private final ArrayList<YoutubeVideoData> list;
    private final Function1<YoutubeVideoData, Unit> listener;

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadBitrateAdapter(ArrayList<YoutubeVideoData> list, Function1<? super YoutubeVideoData, Unit> listener) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.list = list;
        this.listener = listener;
    }

    public final ArrayList<YoutubeVideoData> getList() {
        return this.list;
    }

    public final Function1<YoutubeVideoData, Unit> getListener() {
        return this.listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DownloadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DownloadUrlBitrateBinding downloadUrlBitrateBindingInflate = DownloadUrlBitrateBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(downloadUrlBitrateBindingInflate, "inflate(...)");
        return new DownloadViewHolder(this, downloadUrlBitrateBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DownloadViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getBinding().quality.setText(this.list.get(position).getQuality());
        holder.getBinding().quality.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.base.DownloadBitrateAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadBitrateAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(DownloadBitrateAdapter downloadBitrateAdapter, int i, View view) {
        Function1<YoutubeVideoData, Unit> function1 = downloadBitrateAdapter.listener;
        YoutubeVideoData youtubeVideoData = downloadBitrateAdapter.list.get(i);
        Intrinsics.checkNotNullExpressionValue(youtubeVideoData, "get(...)");
        function1.invoke(youtubeVideoData);
    }

    /* JADX INFO: compiled from: DownloadBitrateAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/base/DownloadBitrateAdapter$DownloadViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/DownloadUrlBitrateBinding;", "<init>", "(Lcom/appnew/android/base/DownloadBitrateAdapter;Lcom/appnew/android/databinding/DownloadUrlBitrateBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/DownloadUrlBitrateBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DownloadViewHolder extends RecyclerView.ViewHolder {
        private final DownloadUrlBitrateBinding binding;
        final /* synthetic */ DownloadBitrateAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadViewHolder(DownloadBitrateAdapter downloadBitrateAdapter, DownloadUrlBitrateBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = downloadBitrateAdapter;
            this.binding = binding;
        }

        public final DownloadUrlBitrateBinding getBinding() {
            return this.binding;
        }
    }
}
