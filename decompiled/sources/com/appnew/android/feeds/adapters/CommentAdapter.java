package com.appnew.android.feeds.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.CommentAdapterBinding;
import com.appnew.android.feeds.dataclass.comment.Data;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: CommentAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\"B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0016H\u0017J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0014\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001e\u0010\u001e\u001a\u00020\u00182\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00070 j\b\u0012\u0004\u0012\u00020\u0007`!R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/appnew/android/feeds/adapters/CommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/feeds/adapters/CommentAdapter$CommentVH;", "context", "Landroid/content/Context;", "optionList", "", "Lcom/appnew/android/feeds/dataclass/comment/Data;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getOptionList", "()Ljava/util/List;", "setOptionList", "(Ljava/util/List;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "getItemCount", "addToExistingList", "feedatalist", "notifydata", "commentlist", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "CommentVH", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentAdapter extends RecyclerView.Adapter<CommentVH> {
    public static final int $stable = 8;
    private Context context;
    private List<Data> optionList;

    public CommentAdapter(Context context, List<Data> optionList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(optionList, "optionList");
        this.context = context;
        this.optionList = optionList;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<Data> getOptionList() {
        return this.optionList;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final void setOptionList(List<Data> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.optionList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CommentVH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        CommentAdapterBinding commentAdapterBindingInflate = CommentAdapterBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(commentAdapterBindingInflate, "inflate(...)");
        return new CommentVH(this, commentAdapterBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CommentVH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.optionList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.optionList.size();
    }

    public final void addToExistingList(List<Data> feedatalist) {
        Intrinsics.checkNotNullParameter(feedatalist, "feedatalist");
        this.optionList = feedatalist;
        notifyItemRangeChanged(feedatalist.size() - 1, feedatalist.size());
    }

    public final void notifydata(ArrayList<Data> commentlist) {
        Intrinsics.checkNotNullParameter(commentlist, "commentlist");
        this.optionList = commentlist;
        notifyDataSetChanged();
    }

    /* JADX INFO: compiled from: CommentAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/appnew/android/feeds/adapters/CommentAdapter$CommentVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "commentAdapterBinding", "Lcom/appnew/android/databinding/CommentAdapterBinding;", "<init>", "(Lcom/appnew/android/feeds/adapters/CommentAdapter;Lcom/appnew/android/databinding/CommentAdapterBinding;)V", Bind.ELEMENT, "", "data", "Lcom/appnew/android/feeds/dataclass/comment/Data;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CommentVH extends RecyclerView.ViewHolder {
        private final CommentAdapterBinding commentAdapterBinding;
        final /* synthetic */ CommentAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommentVH(CommentAdapter commentAdapter, CommentAdapterBinding commentAdapterBinding) {
            super(commentAdapterBinding.getRoot());
            Intrinsics.checkNotNullParameter(commentAdapterBinding, "commentAdapterBinding");
            this.this$0 = commentAdapter;
            this.commentAdapterBinding = commentAdapterBinding;
        }

        public final void bind(Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.commentAdapterBinding.setCommentdata(data);
        }
    }
}
