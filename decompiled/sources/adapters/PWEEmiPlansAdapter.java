package adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.easebuzz.payment.kit.PWEPaymentInfoHandler;
import com.easebuzz.payment.kit.R;
import datamodels.EmiPlansModel;
import java.util.List;
import listeners.PWEEMIPlanListener;

/* JADX INFO: loaded from: classes.dex */
public class PWEEmiPlansAdapter extends ArrayAdapter<EmiPlansModel> {
    public Activity context;
    private PWEEMIPlanListener emiPlanListener;
    private List<EmiPlansModel> emiPlansList;
    private View lastSelectedView;
    private PWEPaymentInfoHandler paymentInfoHandler;

    public PWEEmiPlansAdapter(List<EmiPlansModel> list, Activity activity, PWEPaymentInfoHandler pWEPaymentInfoHandler) {
        super(activity, R.layout.pwe_item_emi_plan, list);
        this.emiPlansList = list;
        this.paymentInfoHandler = pWEPaymentInfoHandler;
        this.context = activity;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        EmiPlanViewHolder emiPlanViewHolder;
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.pwe_item_emi_plan, (ViewGroup) null, true);
            emiPlanViewHolder = new EmiPlanViewHolder(view);
            view.setTag(emiPlanViewHolder);
        } else {
            emiPlanViewHolder = (EmiPlanViewHolder) view.getTag();
        }
        emiPlanViewHolder.tvEmiPlan.setText(this.emiPlansList.get(i).getEmi_desc() + "@" + this.emiPlansList.get(i).getEmi_roi() + "%");
        emiPlanViewHolder.tvEmiInstalment.setText(Double.toString(this.emiPlansList.get(i).getEmi_amount()));
        emiPlanViewHolder.tvEmiTotalCost.setText(Double.toString(this.emiPlansList.get(i).getEmi_total_cost()));
        emiPlanViewHolder.linearRoot.setOnClickListener(new View.OnClickListener() { // from class: adapters.PWEEmiPlansAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PWEEmiPlansAdapter.this.paymentInfoHandler.getPWEDeviceType().equals("NORMAL")) {
                    PWEEmiPlansAdapter.this.selectEMIPlan(view2, i);
                }
            }
        });
        return view;
    }

    public void setEmiPlanListener(PWEEMIPlanListener pWEEMIPlanListener) {
        this.emiPlanListener = pWEEMIPlanListener;
    }

    public static class EmiPlanViewHolder {
        private LinearLayout linearRoot;
        private TextView tvEmiInstalment;
        private TextView tvEmiPlan;
        private TextView tvEmiTotalCost;

        EmiPlanViewHolder(View view) {
            this.tvEmiPlan = (TextView) view.findViewById(R.id.txt_emi_plan);
            this.tvEmiInstalment = (TextView) view.findViewById(R.id.txt_emi_instalment);
            this.tvEmiTotalCost = (TextView) view.findViewById(R.id.txt_emi_total_cost);
            this.linearRoot = (LinearLayout) view.findViewById(R.id.linear_single_plan_holder);
        }
    }

    public void selectEMIPlan(View view, int i) {
        this.emiPlanListener.selectPlan(this.emiPlansList.get(i), i);
        View view2 = this.lastSelectedView;
        if (view2 != null) {
            deselect(view2);
        }
        select(view);
        this.lastSelectedView = view;
    }

    private void select(View view) {
        ((LinearLayout) view.findViewById(R.id.linear_single_plan_holder)).setBackground(this.context.getResources().getDrawable(R.drawable.pwe_selected_item_background));
    }

    private void deselect(View view) {
        ((LinearLayout) view.findViewById(R.id.linear_single_plan_holder)).setBackground(this.context.getResources().getDrawable(R.drawable.pwe_custom_card_background));
    }
}
