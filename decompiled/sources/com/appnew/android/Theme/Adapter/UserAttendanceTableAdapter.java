package com.appnew.android.Theme.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.UserAttendanceModel.UserAttendance;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class UserAttendanceTableAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context contextm;
    List<UserAttendance> userAttendanceList;

    public UserAttendanceTableAdapter(Context contextm, List<UserAttendance> userAttendanceList) {
        this.contextm = contextm;
        this.userAttendanceList = userAttendanceList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.contextm).inflate(R.layout.attendance_report, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserAttendance userAttendance = this.userAttendanceList.get(position);
        if (userAttendance.getIn_time() != null && userAttendance.getIn_time().equalsIgnoreCase("")) {
            holder.attendanceDate.setText("--:--");
        } else {
            try {
                holder.attendanceInTime.setText(userAttendance.getIn_time().split(":")[0] + ":" + userAttendance.getIn_time().split(":")[1]);
            } catch (Exception unused) {
                holder.attendanceDate.setText("--:--");
            }
        }
        if (userAttendance.getIn_time() != null) {
            holder.attendanceDate.setText(userAttendance.getDate());
        }
        holder.attendanceInTime.setText(userAttendance.getIn_time().split(":")[0] + ":" + userAttendance.getIn_time().split(":")[1]);
        if (userAttendance.getStatus() != null && userAttendance.getStatus().equalsIgnoreCase("0")) {
            holder.attendanceStatus.setText("Absent");
            holder.attendanceStatus.setTextColor(this.contextm.getResources().getColor(R.color.notification_red));
        } else {
            holder.attendanceStatus.setText("Present");
            holder.attendanceStatus.setTextColor(this.contextm.getResources().getColor(R.color.whatsapp_green));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.userAttendanceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView attendanceDate;
        TextView attendanceInTime;
        TextView attendanceStatus;
        LinearLayout main;

        public ViewHolder(View itemView) {
            super(itemView);
            this.attendanceDate = (TextView) itemView.findViewById(R.id.attendanceDate);
            this.attendanceInTime = (TextView) itemView.findViewById(R.id.attendanceInTime);
            this.attendanceStatus = (TextView) itemView.findViewById(R.id.attendanceStatus);
        }
    }
}
