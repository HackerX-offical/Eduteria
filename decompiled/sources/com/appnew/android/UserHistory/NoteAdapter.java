package com.appnew.android.UserHistory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.contactUsForm.ItemConversation;
import com.appnew.android.UserHistory.NoteAdapter;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.databinding.ItemViewConversatiuonBinding;
import com.eduteria.app.app.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.Message;

/* JADX INFO: compiled from: NoteAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0011\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/appnew/android/UserHistory/NoteAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/appnew/android/Model/contactUsForm/ItemConversation;", "Lcom/appnew/android/UserHistory/NoteAdapter$NoteViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onCreateViewHolder", Message.Thread.PARENT_ATTRIBUTE_NAME, "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", Const.POSITION, "NoteViewHolder", "ComparatorDiffUtil", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoteAdapter extends ListAdapter<ItemConversation, NoteViewHolder> {
    public static final int $stable = 8;
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteAdapter(Context context) {
        super(new ComparatorDiffUtil());
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemViewConversatiuonBinding itemViewConversatiuonBindingInflate = ItemViewConversatiuonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemViewConversatiuonBindingInflate, "inflate(...)");
        return new NoteViewHolder(this, itemViewConversatiuonBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemConversation item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    /* JADX INFO: compiled from: NoteAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/appnew/android/UserHistory/NoteAdapter$NoteViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/appnew/android/databinding/ItemViewConversatiuonBinding;", "<init>", "(Lcom/appnew/android/UserHistory/NoteAdapter;Lcom/appnew/android/databinding/ItemViewConversatiuonBinding;)V", Bind.ELEMENT, "", Const.NOTE, "Lcom/appnew/android/Model/contactUsForm/ItemConversation;", "hideIfTextEmpty", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class NoteViewHolder extends RecyclerView.ViewHolder {
        private final ItemViewConversatiuonBinding binding;
        final /* synthetic */ NoteAdapter this$0;

        private final void hideIfTextEmpty() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoteViewHolder(NoteAdapter noteAdapter, ItemViewConversatiuonBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = noteAdapter;
            this.binding = binding;
        }

        public final void bind(final ItemConversation note) {
            String str;
            Intrinsics.checkNotNullParameter(note, "note");
            String reply = note.getReply();
            if (reply == null || reply.length() == 0) {
                this.binding.leftMessageRelative.setVisibility(0);
                this.binding.rightMessageRelative.setVisibility(8);
                this.binding.message.setText(note.getMessage());
                this.binding.mobile.setText("Mobile: " + note.getMobile());
                this.binding.email.setText("Email: " + note.getEmail());
                CardView cardView = this.binding.leftMessageCard;
                if (cardView != null) {
                    cardView.setBackgroundColor(this.this$0.context.getColor(R.color.whie));
                }
                CardView cardView2 = this.binding.rightMessageCard;
                if (cardView2 != null) {
                    cardView2.setBackgroundColor(this.this$0.context.getColor(R.color.whie));
                }
                TextView textView = this.binding.dateLeftMessage;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                TextView textView2 = this.binding.dateRightMessage;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else {
                CardView cardView3 = this.binding.leftMessageCard;
                if (cardView3 != null) {
                    cardView3.setBackgroundColor(this.this$0.context.getColor(R.color.chat_left_color));
                }
                CardView cardView4 = this.binding.rightMessageCard;
                if (cardView4 != null) {
                    cardView4.setBackgroundColor(this.this$0.context.getColor(R.color.chat_right_color));
                }
                try {
                    if (StringsKt.equals(note.getReply_user_name(), "admin", true)) {
                        this.binding.leftMessageRelative.setVisibility(0);
                        this.binding.rightMessageRelative.setVisibility(8);
                        this.binding.message.setText(note.getReply());
                        this.binding.mobile.setText("UserName: " + note.getReply_user_name());
                        this.binding.email.setVisibility(8);
                        TextView textView3 = this.binding.dateLeftMessage;
                        if (textView3 != null) {
                            textView3.setText(Helper.getTimeOnly(Long.parseLong(String.valueOf(Long.parseLong(note.getTime()) * ((long) 1000)))));
                        }
                    } else {
                        this.binding.leftMessageRelative.setVisibility(8);
                        this.binding.rightMessageRelative.setVisibility(0);
                        this.binding.message1.setText(note.getReply());
                        this.binding.mobile1.setText("UserName: " + note.getReply_user_name());
                        this.binding.email1.setVisibility(8);
                        TextView textView4 = this.binding.dateRightMessage;
                        if (textView4 != null) {
                            textView4.setText(Helper.getTimeOnly(Long.parseLong(String.valueOf(Long.parseLong(note.getTime()) * ((long) 1000)))));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (StringsKt.equals(note.getType(), "0", true)) {
                str = "Payment Issue";
            } else if (StringsKt.equals(note.getType(), "1", true)) {
                str = "Video Class";
            } else if (StringsKt.equals(note.getType(), "2", true)) {
                str = "Test Series";
            } else if (StringsKt.equals(note.getType(), "3", true)) {
                str = "Others";
            } else {
                str = "N/A";
            }
            this.binding.issue.setText("Issue: ".concat(str));
            ConstraintLayout constraintLayout = this.binding.mainLLConversation;
            final NoteAdapter noteAdapter = this.this$0;
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.UserHistory.NoteAdapter$NoteViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NoteAdapter.NoteViewHolder.bind$lambda$1(note, noteAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(ItemConversation itemConversation, NoteAdapter noteAdapter, View view) {
            String reply = itemConversation.getReply();
            if (reply == null || reply.length() == 0) {
                if (!Helper.isNetworkConnected(noteAdapter.context)) {
                    Helper.showInternetToast(noteAdapter.context);
                    return;
                }
                Intent intent = new Intent(noteAdapter.context, (Class<?>) ConversationReplyActivity.class);
                intent.putExtra(Const.CONTATUS_ID, itemConversation.getId());
                intent.putExtra(Const.APP_ID, itemConversation.getAppId());
                noteAdapter.context.startActivity(intent);
            }
        }
    }

    /* JADX INFO: compiled from: NoteAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/appnew/android/UserHistory/NoteAdapter$ComparatorDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/appnew/android/Model/contactUsForm/ItemConversation;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ComparatorDiffUtil extends DiffUtil.ItemCallback<ItemConversation> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(ItemConversation oldItem, ItemConversation newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(ItemConversation oldItem, ItemConversation newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
        }
    }
}
