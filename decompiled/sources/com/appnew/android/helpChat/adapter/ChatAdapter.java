package com.appnew.android.helpChat.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Helper;
import com.appnew.android.helpChat.model.ChatQuery;
import com.eduteria.app.app.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
public class ChatAdapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<ChatQuery> chat_list;
    private Context context;
    private int SENDER = 1;
    private int RECIEVER = 2;

    public ChatAdapter(ArrayList<ChatQuery> chat_list) {
        this.chat_list = chat_list;
    }

    public String getdate(String timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp))));
    }

    class SenderViewHolder extends ViewHolder {
        TextView sender_chat;
        TextView sender_chat_time;

        public SenderViewHolder(View itemView) {
            super(itemView);
            this.sender_chat = (TextView) itemView.findViewById(R.id.sender_chat);
            this.sender_chat_time = (TextView) itemView.findViewById(R.id.sender_chat_time);
        }

        @Override // com.appnew.android.helpChat.adapter.ChatAdapter.ViewHolder
        void onBind(int position) {
            this.sender_chat.setText(ChatAdapter.this.chat_list.get(position).getText());
            if (TextUtils.isEmpty(ChatAdapter.this.chat_list.get(position).getCreateDate())) {
                this.sender_chat_time.setText(ChatAdapter.this.context.getResources().getString(R.string.n_a));
                return;
            }
            try {
                this.sender_chat_time.setText(ChatAdapter.this.getdate(String.valueOf(Long.parseLong(ChatAdapter.this.chat_list.get(position).getCreateDate()) * 1000)));
            } catch (Exception unused) {
                this.sender_chat_time.setText(ChatAdapter.this.context.getResources().getString(R.string.n_a));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.chat_list.get(position).getType().equalsIgnoreCase("1") ? this.SENDER : this.RECIEVER;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        return i == this.SENDER ? new SenderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_sender, viewGroup, false)) : new RecieverViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_reciever, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.onBind(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.chat_list.size();
    }

    public abstract class ViewHolder extends RecyclerView.ViewHolder {
        abstract void onBind(int position);

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    class RecieverViewHolder extends ViewHolder {
        TextView reciever_chat;
        TextView reciever_chat_time;

        public RecieverViewHolder(View itemView) {
            super(itemView);
            this.reciever_chat = (TextView) itemView.findViewById(R.id.reciever_chat);
            this.reciever_chat_time = (TextView) itemView.findViewById(R.id.reciever_chat_time);
        }

        @Override // com.appnew.android.helpChat.adapter.ChatAdapter.ViewHolder
        void onBind(int position) {
            this.reciever_chat.setText(ChatAdapter.this.chat_list.get(position).getText());
            if (TextUtils.isEmpty(ChatAdapter.this.chat_list.get(position).getCreateDate())) {
                this.reciever_chat_time.setText(ChatAdapter.this.context.getResources().getString(R.string.n_a));
                return;
            }
            try {
                this.reciever_chat_time.setText(ChatAdapter.this.getdate(String.valueOf(Long.parseLong(ChatAdapter.this.chat_list.get(position).getCreateDate()) * 1000)));
            } catch (Exception unused) {
                this.reciever_chat_time.setText(ChatAdapter.this.context.getResources().getString(R.string.n_a));
            }
        }
    }
}
