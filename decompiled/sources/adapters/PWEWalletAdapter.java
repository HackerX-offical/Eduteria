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
import datamodels.CashCardWalletDataModel;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PWEWalletAdapter extends ArrayAdapter<CashCardWalletDataModel> {
    private ArrayList<CashCardWalletDataModel> cashCardNamesList;
    private final Activity context;
    private PWEGeneralHelper generalHelper;
    private int selectedPosition;

    public PWEWalletAdapter(Activity activity, ArrayList<CashCardWalletDataModel> arrayList) {
        super(activity, R.layout.pwe_item_grid_payment_option, arrayList);
        this.selectedPosition = -1;
        this.context = activity;
        this.cashCardNamesList = arrayList;
        this.generalHelper = new PWEGeneralHelper(activity);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.cashCardNamesList.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        WalletViewHolder walletViewHolder;
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.pwe_item_grid_payment_option, (ViewGroup) null, true);
            walletViewHolder = new WalletViewHolder(view);
            view.setTag(walletViewHolder);
        } else {
            walletViewHolder = (WalletViewHolder) view.getTag();
        }
        walletViewHolder.textPaymentOpt.setText(this.cashCardNamesList.get(i).bank_name);
        walletViewHolder.imageView.setImageResource(PWEStaticDataModel.PWEDefaultBankPaymentIcon);
        try {
            this.generalHelper.setImageToImageView(PWEStaticDataModel.REST_BASE_URL + this.cashCardNamesList.get(i).cash_card_img_url, walletViewHolder.imageView, PWEStaticDataModel.PWEDefaultBankPaymentIcon);
        } catch (Exception unused) {
        }
        walletViewHolder.image_check.setTag(Integer.valueOf(i));
        walletViewHolder.image_check.setVisibility(0);
        if (i == getSelectedPosition()) {
            walletViewHolder.linearGridItemLayout.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_selected_item_background));
        } else {
            walletViewHolder.linearGridItemLayout.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_custom_card_background));
        }
        return view;
    }

    private class WalletViewHolder {
        private ImageView imageView;
        private ImageView image_check;
        LinearLayout linearGridItemLayout;
        private TextView textPaymentOpt;

        public WalletViewHolder(View view) {
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
