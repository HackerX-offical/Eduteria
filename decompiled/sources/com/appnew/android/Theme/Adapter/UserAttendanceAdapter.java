package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.UserAttendanceModel.UserAttendance;
import com.eduteria.app.app.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
public class UserAttendanceAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context contextm;
    List<UserAttendance> userAttendanceList;

    public UserAttendanceAdapter(Context contextm, List<UserAttendance> userAttendanceList) {
        this.contextm = contextm;
        this.userAttendanceList = userAttendanceList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.contextm).inflate(R.layout.item11, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserAttendance userAttendance = this.userAttendanceList.get(position);
        switch (position) {
            case 0:
                holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.firstTile));
            case 1:
                holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.secondTile));
            case 2:
                holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.thirdTile));
            case 3:
                holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.fourthTile));
            case 4:
                holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.fifthTile));
            case 5:
                holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.sixthTile));
            case 6:
                holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.seventhTile));
                break;
        }
        if (position == 0) {
            holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.firstTile));
        }
        if (position == 1) {
            holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.secondTile));
        }
        if (position == 2) {
            holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.thirdTile));
        }
        if (position == 3) {
            holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.fourthTile));
        }
        if (position == 4) {
            holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.fifthTile));
        }
        if (position == 5) {
            holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.sixthTile));
        }
        if (position == 6) {
            holder.main.setBackgroundColor(ContextCompat.getColor(this.contextm, R.color.seventhTile));
        }
        holder.text1.setText(new SimpleDateFormat("dd MMM", Locale.ENGLISH).format(new Date(Long.parseLong(userAttendance.getIn_time()) * 1000)));
        holder.text2.setText(new SimpleDateFormat("hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(userAttendance.getIn_time()) * 1000)));
        holder.text3.setText(new SimpleDateFormat("hh:mm aa", Locale.ENGLISH).format(new Date(Long.parseLong(userAttendance.getOut_time()) * 1000)));
        if (!TextUtils.isEmpty(userAttendance.getOut_time())) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            holder.text4.setText(simpleDateFormat.format(new Date((Long.parseLong(userAttendance.getOut_time()) - Long.parseLong(userAttendance.getIn_time())) * 1000)));
            return;
        }
        holder.text4.setText("---");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.userAttendanceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout main;
        TextView text1;
        TextView text2;
        TextView text3;
        TextView text4;

        public ViewHolder(View itemView) {
            super(itemView);
            this.text1 = (TextView) itemView.findViewById(R.id.text1);
            this.text2 = (TextView) itemView.findViewById(R.id.text2);
            this.text3 = (TextView) itemView.findViewById(R.id.text3);
            this.text4 = (TextView) itemView.findViewById(R.id.text4);
            this.main = (LinearLayout) itemView.findViewById(R.id.main);
        }
    }
}
