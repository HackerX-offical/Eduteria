package adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.easebuzz.payment.kit.PWEGeneralHelper;
import com.easebuzz.payment.kit.R;
import datamodels.NetBankingChild;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PWENetbankingAdapterNew extends ArrayAdapter<NetBankingChild> {
    private static PWEGeneralHelper generalHelper;
    private final Activity context;
    private ArrayList<NetBankingChild> pay_opt_list;
    private int selectedPosition;

    public PWENetbankingAdapterNew(Activity activity, ArrayList<NetBankingChild> arrayList) {
        super(activity, R.layout.pwe_item_grid_payment_option, arrayList);
        this.selectedPosition = -1;
        this.context = activity;
        this.pay_opt_list = arrayList;
        generalHelper = new PWEGeneralHelper(activity);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.pwe_item_grid_payment_option, (ViewGroup) null, true);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textPaymentOpt.setText(this.pay_opt_list.get(i).getName());
        viewHolder.imageView.setImageResource(PWEStaticDataModel.PWEDefaultBankPaymentIcon);
        try {
            generalHelper.setImageToImageView(PWEStaticDataModel.REST_BASE_URL + this.pay_opt_list.get(i).getImage_Path(), viewHolder.imageView, PWEStaticDataModel.PWEDefaultBankPaymentIcon);
        } catch (Exception unused) {
        }
        viewHolder.image_check.setTag(Integer.valueOf(i));
        viewHolder.image_check.setVisibility(0);
        if (i == getSelectedPosition()) {
            viewHolder.linearGridItemLayout.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_selected_item_background));
        } else {
            viewHolder.linearGridItemLayout.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_custom_card_background));
        }
        return view;
    }

    private static class ViewHolder {
        ImageView imageView;
        private ImageView image_check;
        LinearLayout linearGridItemLayout;
        private TextView textPaymentOpt;

        public ViewHolder(View view) {
            this.image_check = (ImageView) view.findViewById(R.id.img_select_image);
            this.textPaymentOpt = (TextView) view.findViewById(R.id.text_payment_option);
            this.imageView = (ImageView) view.findViewById(R.id.img_payment_option);
            this.linearGridItemLayout = (LinearLayout) view.findViewById(R.id.linear_payment_option);
        }
    }

    public int getSelectedPosition() {
        return this.selectedPosition;
    }

    public void setSelectedPosition(int i) {
        this.selectedPosition = i;
        notifyDataSetChanged();
    }
}
