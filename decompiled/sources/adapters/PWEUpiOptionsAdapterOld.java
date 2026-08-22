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
import com.easebuzz.payment.kit.PWEPaymentInfoHandler;
import com.easebuzz.payment.kit.R;
import datamodels.PWEStaticDataModel;
import datamodels.PWEUPIOptionsDataModel;
import java.util.ArrayList;
import listeners.PWEUpiOptionListener;

/* JADX INFO: loaded from: classes.dex */
public class PWEUpiOptionsAdapterOld extends ArrayAdapter<PWEUPIOptionsDataModel> {
    private final Activity context;
    private PWEGeneralHelper generalHelper;
    private View last_selected_view;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private int selectedPosition;
    private String selectedUpiOptionKey;
    private PWEUpiOptionListener upiOptionListener;
    private ArrayList<PWEUPIOptionsDataModel> upi_option_list;

    public PWEUpiOptionsAdapterOld(Activity activity, ArrayList<PWEUPIOptionsDataModel> arrayList, String str, PWEPaymentInfoHandler pWEPaymentInfoHandler) {
        super(activity, R.layout.pwe_item_grid_upi_option, arrayList);
        this.selectedPosition = -1;
        this.selectedUpiOptionKey = "";
        this.context = activity;
        this.upi_option_list = arrayList;
        this.generalHelper = new PWEGeneralHelper(activity);
        this.selectedUpiOptionKey = str;
        this.paymentInfoHandler = pWEPaymentInfoHandler;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        UPIViewHolder uPIViewHolder;
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.pwe_item_grid_upi_option_old, (ViewGroup) null, true);
            uPIViewHolder = new UPIViewHolder(view);
            view.setTag(uPIViewHolder);
        } else {
            uPIViewHolder = (UPIViewHolder) view.getTag();
        }
        uPIViewHolder.image_check.setImageResource(PWEStaticDataModel.PWEDefaultSelectedIcon);
        uPIViewHolder.image_check.setVisibility(4);
        uPIViewHolder.imageView.setImageResource(PWEStaticDataModel.PWEDefaultBankPaymentIcon);
        try {
            this.generalHelper.setImageToImageView(PWEStaticDataModel.REST_BASE_URL + this.upi_option_list.get(i).getImage(), uPIViewHolder.imageView, PWEStaticDataModel.PWEDefaultBankPaymentIcon);
        } catch (Exception unused) {
        }
        if (this.upi_option_list.get(i).isShow_label()) {
            uPIViewHolder.tvDisplayName.setVisibility(0);
            uPIViewHolder.tvDisplayName.setText(this.upi_option_list.get(i).getLable());
        } else {
            uPIViewHolder.tvDisplayName.setVisibility(4);
        }
        if (this.upi_option_list.get(i).getKey().equals(getSelectedUpiOptionKey())) {
            selectUpiOption(uPIViewHolder.linearRoot, i);
        } else {
            deselect(uPIViewHolder.linearRoot);
        }
        uPIViewHolder.linearRoot.setOnClickListener(new View.OnClickListener() { // from class: adapters.PWEUpiOptionsAdapterOld.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PWEUpiOptionsAdapterOld.this.paymentInfoHandler.getPWEDeviceType().equals("NORMAL")) {
                    PWEUpiOptionsAdapterOld pWEUpiOptionsAdapterOld = PWEUpiOptionsAdapterOld.this;
                    pWEUpiOptionsAdapterOld.setSelectedUpiOptionKey(((PWEUPIOptionsDataModel) pWEUpiOptionsAdapterOld.upi_option_list.get(i)).getKey());
                    PWEUpiOptionsAdapterOld.this.selectUpiOption(view2, i);
                }
            }
        });
        return view;
    }

    public void selectUpiOption(View view, int i) {
        this.upiOptionListener.selectUPIOption(this.upi_option_list.get(i), i);
        View view2 = this.last_selected_view;
        if (view2 != null) {
            deselect(view2);
        }
        select(view);
        this.last_selected_view = view;
    }

    private void select(View view) {
        view.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_selected_item_background));
    }

    private void deselect(View view) {
        view.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_custom_card_background));
    }

    public void setPWEUpiOptionListener(PWEUpiOptionListener pWEUpiOptionListener) {
        this.upiOptionListener = pWEUpiOptionListener;
    }

    public String getSelectedUpiOptionKey() {
        return this.selectedUpiOptionKey;
    }

    public void setSelectedUpiOptionKey(String str) {
        this.selectedUpiOptionKey = str;
        notifyDataSetChanged();
    }

    private static class UPIViewHolder {
        private ImageView imageView;
        private ImageView image_check;
        private LinearLayout linearRoot;
        private TextView tvDisplayName;

        public UPIViewHolder(View view) {
            this.linearRoot = (LinearLayout) view.findViewById(R.id.linear_upi_option_root);
            this.image_check = (ImageView) view.findViewById(R.id.img_select_upi);
            this.imageView = (ImageView) view.findViewById(R.id.img_upi_option);
            this.tvDisplayName = (TextView) view.findViewById(R.id.text_upi_option_display_name);
        }
    }
}
