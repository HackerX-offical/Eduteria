package com.appnew.android.socket.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.COURSEDETAIL.CourseDetail;
import com.appnew.android.Utils.Const;
import com.appnew.android.databinding.ItemGroupChatTileBinding;
import com.appnew.android.socket.activity.GroupChatActivity;
import com.appnew.android.socket.models.ChatModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: SingleStudyGroupChatAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/appnew/android/socket/adapter/SingleStudyGroupChatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/appnew/android/socket/adapter/SingleStudyGroupChatAdapter$ViewHolder;", "context", "Landroid/content/Context;", "chatModel", "Ljava/util/ArrayList;", "Lcom/appnew/android/socket/models/ChatModel;", "Lkotlin/collections/ArrayList;", "singleStudy", "Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/appnew/android/Model/COURSEDETAIL/CourseDetail;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", Const.POSITION, "ViewHolder", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleStudyGroupChatAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final ArrayList<ChatModel> chatModel;
    private final Context context;
    private final CourseDetail singleStudy;

    /* JADX INFO: compiled from: SingleStudyGroupChatAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/socket/adapter/SingleStudyGroupChatAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemGroupChatTileBinding;", "<init>", "(Lcom/appnew/android/socket/adapter/SingleStudyGroupChatAdapter;Lcom/appnew/android/databinding/ItemGroupChatTileBinding;)V", "getBinding", "()Lcom/appnew/android/databinding/ItemGroupChatTileBinding;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemGroupChatTileBinding binding;
        final /* synthetic */ SingleStudyGroupChatAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(SingleStudyGroupChatAdapter singleStudyGroupChatAdapter, ItemGroupChatTileBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = singleStudyGroupChatAdapter;
            this.binding = binding;
        }

        public final ItemGroupChatTileBinding getBinding() {
            return this.binding;
        }
    }

    public SingleStudyGroupChatAdapter(Context context, ArrayList<ChatModel> chatModel, CourseDetail singleStudy) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(chatModel, "chatModel");
        Intrinsics.checkNotNullParameter(singleStudy, "singleStudy");
        this.context = context;
        this.chatModel = chatModel;
        this.singleStudy = singleStudy;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemGroupChatTileBinding itemGroupChatTileBindingInflate = ItemGroupChatTileBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemGroupChatTileBindingInflate, "inflate(...)");
        return new ViewHolder(this, itemGroupChatTileBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.chatModel.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemGroupChatTileBinding binding = holder.getBinding();
        binding.groupName.setText(this.chatModel.get(position).getGroup_name());
        binding.mainCv.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.socket.adapter.SingleStudyGroupChatAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SingleStudyGroupChatAdapter.onBindViewHolder$lambda$1$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(SingleStudyGroupChatAdapter singleStudyGroupChatAdapter, int i, View view) {
        Intent intent = new Intent(singleStudyGroupChatAdapter.context, (Class<?>) GroupChatActivity.class);
        intent.putExtra("data", singleStudyGroupChatAdapter.chatModel.get(i));
        intent.putExtra("courseId", singleStudyGroupChatAdapter.singleStudy.getData().getCourseDetail().getId());
        singleStudyGroupChatAdapter.context.startActivity(intent);
    }
}
