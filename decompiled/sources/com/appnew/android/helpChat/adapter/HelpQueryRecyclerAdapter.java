package com.appnew.android.helpChat.adapter;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Utils.Helper;
import com.appnew.android.helpChat.helper.OnQueryItemListener;
import com.appnew.android.helpChat.model.HelpSupportChatModel;
import com.eduteria.app.app.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
public class HelpQueryRecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    private ArrayList<HelpSupportChatModel.DataBean> data;
    private OnQueryItemListener mListener;

    public HelpQueryRecyclerAdapter(Context context, ArrayList<HelpSupportChatModel.DataBean> items) {
        this.data = items;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.help_query_item, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final HelpSupportChatModel.DataBean dataBean = this.data.get(position);
        holder.queryIDTV.setText(TextUtils.isEmpty(dataBean.getTime()) ? this.context.getResources().getString(R.string.n_a) : dataBean.getQuery_id());
        holder.queryTextTV.setText(TextUtils.isEmpty(dataBean.getTime()) ? this.context.getResources().getString(R.string.n_a) : dataBean.getTitle());
        if (dataBean.getClose_date().equalsIgnoreCase("0")) {
            holder.querystatusTV.setText(Html.fromHtml("Status: <font color='black'><b>Open</b></font>"));
        } else {
            holder.querystatusTV.setText(Html.fromHtml("Status: <font color='green'><b>Closed</b></font>"));
        }
        if (TextUtils.isEmpty(dataBean.getTime())) {
            holder.queryTimeTV.setText(this.context.getResources().getString(R.string.n_a));
        } else {
            try {
                holder.queryTimeTV.setText(getdate(String.valueOf(Long.parseLong(dataBean.getTime()) * 1000)));
            } catch (Exception unused) {
                holder.queryTimeTV.setText(this.context.getResources().getString(R.string.n_a));
            }
        }
        holder.queryLL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.helpChat.adapter.HelpQueryRecyclerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                HelpQueryRecyclerAdapter helpQueryRecyclerAdapter = HelpQueryRecyclerAdapter.this;
                helpQueryRecyclerAdapter.mListener = (OnQueryItemListener) helpQueryRecyclerAdapter.context;
                if (HelpQueryRecyclerAdapter.this.mListener != null) {
                    HelpQueryRecyclerAdapter.this.mListener.onQueryItemClick(dataBean);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        TextView queryIDTV;
        RelativeLayout queryLL;
        TextView queryTextTV;
        TextView queryTimeTV;
        TextView querystatusTV;

        public ViewHolder(View view) {
            super(view);
            this.mView = view;
            this.queryLL = (RelativeLayout) this.itemView.findViewById(R.id.queryLL);
            this.queryIDTV = (TextView) this.itemView.findViewById(R.id.queryIDTV);
            this.queryTextTV = (TextView) this.itemView.findViewById(R.id.queryTextTV);
            this.querystatusTV = (TextView) this.itemView.findViewById(R.id.querystatusTV);
            this.queryTimeTV = (TextView) this.itemView.findViewById(R.id.queryTimeTV);
        }
    }

    public String getdate(String timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return Helper.changeAMPM(new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.getDefault()).format(new Date(Long.parseLong(timestamp))));
    }
}
