package com.appnew.android.Courses.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.appnew.android.Model.Courses.EMIInfo;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.HelperProgress;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class EMIListAdapter extends BaseAdapter {
    private static LayoutInflater inflater;
    Context context;
    private List<EMIInfo> filteredList;

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public EMIListAdapter(Context context, List<EMIInfo> filteredList) {
        this.context = context;
        this.filteredList = filteredList;
        inflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.filteredList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return Integer.valueOf(position);
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_emi, (ViewGroup) null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.title);
        TextView textView2 = (TextView) convertView.findViewById(R.id.desc);
        LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.status_ll);
        TextView textView3 = (TextView) convertView.findViewById(R.id.text_status);
        TextView textView4 = (TextView) convertView.findViewById(R.id.next_payment_txt);
        EMIInfo eMIInfo = this.filteredList.get(position);
        if (!TextUtils.isEmpty(eMIInfo.getValidTo())) {
            linearLayout.setVisibility(0);
            textView4.setVisibility(0);
            if (eMIInfo.getTxnStatus().equalsIgnoreCase("1")) {
                textView3.setText(this.context.getResources().getString(R.string.complete));
                textView3.setBackground(this.context.getResources().getDrawable(R.drawable.button_background_status_completed));
                String formatDateMillis = HelperProgress.getFormatDateMillis(Long.valueOf(Long.parseLong(eMIInfo.getComletionDate()) * 1000));
                textView4.setTextColor(this.context.getResources().getColor(R.color.green_met));
                textView4.setText(this.context.getResources().getString(R.string.payment) + this.context.getResources().getString(R.string.rs) + " " + eMIInfo.getEmiMrp() + "/- completed on " + formatDateMillis);
            } else {
                String formatDateMillis2 = HelperProgress.getFormatDateMillis(Long.valueOf(Long.parseLong(eMIInfo.getValidTo()) * 1000));
                textView3.setText(this.context.getResources().getString(R.string.pending));
                textView3.setBackground(this.context.getResources().getDrawable(R.drawable.button_background_status_pending));
                textView4.setTextColor(this.context.getResources().getColor(R.color.app_bg));
                textView4.setText(this.context.getResources().getString(R.string.next_payment) + this.context.getResources().getString(R.string.rs) + " " + eMIInfo.getEmiMrp() + "/- due on " + formatDateMillis2);
            }
        } else {
            linearLayout.setVisibility(8);
            textView4.setVisibility(8);
        }
        textView.setText(eMIInfo.getEmiNo() + Helper.getDaySuffix(Integer.parseInt(eMIInfo.getEmiNo())) + this.context.getResources().getString(R.string.installment) + Constants.currencyType + eMIInfo.getEmiMrp() + "/ " + eMIInfo.getEmiValidity() + "Days");
        textView2.setText(eMIInfo.getAttribute());
        return convertView;
    }
}
