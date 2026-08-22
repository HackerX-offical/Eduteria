package com.appnew.android.Payment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.CommonEmiPlanModel;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes6.dex */
public class AdapterInstallmentDetails extends RecyclerView.Adapter<ExViewHolder> {
    CommonEmiPlanModel commonEmiPlanModel;
    long end_millis = 0;
    long millis = 0;

    public AdapterInstallmentDetails(CommonEmiPlanModel commonEmiPlanModel) {
        this.commonEmiPlanModel = commonEmiPlanModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ExViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_installment_show_adapter, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ExViewHolder holder, int position) {
        String str;
        long jCurrentTimeMillis;
        switch (position + 1) {
            case 1:
                str = "First";
                break;
            case 2:
                str = "Second";
                break;
            case 3:
                str = "Third";
                break;
            case 4:
                str = "Fourth";
                break;
            case 5:
                str = "Fifth";
                break;
            case 6:
                str = "Sixth";
                break;
            case 7:
                str = "Seventh";
                break;
            case 8:
                str = "Eighth";
                break;
            case 9:
                str = "Ninth";
                break;
            case 10:
                str = "Tenth";
                break;
            case 11:
                str = "Eleventh";
                break;
            case 12:
                str = "Twelfth";
                break;
            case 13:
                str = "Thirteenth";
                break;
            case 14:
                str = "Fourteenth";
                break;
            case 15:
                str = "Fifteenth";
                break;
            case 16:
                str = "Sixteenth";
                break;
            case 17:
                str = "Seventeenth";
                break;
            case 18:
                str = "Eighteenth";
                break;
            case 19:
                str = "Nineteenth";
                break;
            case 20:
                str = "Twentieth";
                break;
            case 21:
                str = "Twenty-first";
                break;
            case 22:
                str = "Twenty-second";
                break;
            case 23:
                str = "Twenty-third";
                break;
            case 24:
                str = "Twenty-fourth";
                break;
            case 25:
                str = "Twenty-fifth";
                break;
            case 26:
                str = "Twenty-Sixth";
                break;
            case 27:
                str = "Twenty-Seventh";
                break;
            case 28:
                str = "Twenty-Eighth";
                break;
            case 29:
                str = "Twenty-Ninth";
                break;
            case 30:
                str = "Thirtieth";
                break;
            case 31:
                str = "Thirty-first";
                break;
            case 32:
                str = "Thirty-second";
                break;
            default:
                str = "";
                break;
        }
        holder.countInstallment.setText(str.concat(" Installment"));
        holder.priceTxt.setText(Constants.currencyType + String.format("%.02f", Double.valueOf(Double.parseDouble(this.commonEmiPlanModel.getEmiList().get(position)))));
        holder.gstTxt.setText(Constants.currencyType + String.format("%.02f", Double.valueOf(Double.parseDouble(this.commonEmiPlanModel.getTaxList().get(position)))));
        holder.ttlTxt.setText(Constants.currencyType + String.format("%.02f", Double.valueOf(Double.parseDouble(this.commonEmiPlanModel.getEmiList().get(position)) + Double.parseDouble(this.commonEmiPlanModel.getTaxList().get(position)))));
        try {
            jCurrentTimeMillis = Long.parseLong(this.commonEmiPlanModel.getCycleList_date_ms().get(position));
            if (jCurrentTimeMillis < 1000000000000L) {
                jCurrentTimeMillis *= 1000;
            }
        } catch (Exception unused) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        holder.dueDateTxt.setText(simpleDateFormat.format(new Date(jCurrentTimeMillis)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.commonEmiPlanModel.getCycleList().size();
    }

    public class ExViewHolder extends RecyclerView.ViewHolder {
        TextView countInstallment;
        TextView dueDateTxt;
        TextView gstTxt;
        TextView priceTxt;
        TextView ttlTxt;

        public ExViewHolder(View itemView) {
            super(itemView);
            this.countInstallment = (TextView) itemView.findViewById(R.id.countInstallment);
            this.priceTxt = (TextView) itemView.findViewById(R.id.priceTxt);
            this.gstTxt = (TextView) itemView.findViewById(R.id.gstTxt);
            this.ttlTxt = (TextView) itemView.findViewById(R.id.ttlTxt);
            this.dueDateTxt = (TextView) itemView.findViewById(R.id.dueDateTxt);
        }
    }
}
