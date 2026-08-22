package adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.easebuzz.payment.kit.PWEGeneralHelper;
import com.easebuzz.payment.kit.R;
import datamodels.EmiBanksModel;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PWEEmiBankAdapter extends ArrayAdapter<EmiBanksModel> {
    private static PWEGeneralHelper generalHelper;
    private ArrayList<EmiBanksModel> back_up_pay_opt_list;
    private final Activity context;
    private ArrayList<EmiBanksModel> pay_opt_list;

    public PWEEmiBankAdapter(Activity activity, ArrayList<EmiBanksModel> arrayList) {
        super(activity, R.layout.pwe_item_emi_bank, arrayList);
        this.context = activity;
        this.pay_opt_list = arrayList;
        ArrayList<EmiBanksModel> arrayList2 = new ArrayList<>();
        this.back_up_pay_opt_list = arrayList2;
        arrayList2.addAll(arrayList);
        generalHelper = new PWEGeneralHelper(activity);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.pwe_item_emi_bank, (ViewGroup) null, true);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textBankName.setText(this.pay_opt_list.get(i).getBank_display_name());
        viewHolder.imgBank.setImageResource(PWEStaticDataModel.PWEDefaultEMIIcon);
        try {
            generalHelper.setImageToImageView(PWEStaticDataModel.REST_BASE_URL + this.pay_opt_list.get(i).getBank_logo(), viewHolder.imgBank, PWEStaticDataModel.PWEDefaultEMIIcon);
        } catch (Exception unused) {
        }
        return view;
    }

    private static class ViewHolder {
        private ImageView imgBank;
        private TextView textBankName;

        public ViewHolder(View view) {
            this.imgBank = (ImageView) view.findViewById(R.id.image_emi_bank);
            this.textBankName = (TextView) view.findViewById(R.id.text_emi_bank_name);
        }
    }
}
