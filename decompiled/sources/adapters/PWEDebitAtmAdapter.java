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
import datamodels.PWEBankCodeModel;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;
import java.util.Locale;
import listeners.PWEDebitAtmListener;

/* JADX INFO: loaded from: classes.dex */
public class PWEDebitAtmAdapter extends ArrayAdapter<PWEBankCodeModel> {
    private ArrayList<PWEBankCodeModel> backupBankNamesList;
    private ArrayList<PWEBankCodeModel> bankNamesList;
    private Activity context;
    private PWEDebitAtmListener debitAtmListener;
    private PWEGeneralHelper generalHelper;
    private String getSelectedBankId;
    private View lastSelectedView;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private int selectedPosition;

    public PWEDebitAtmAdapter(Activity activity, ArrayList<PWEBankCodeModel> arrayList, PWEPaymentInfoHandler pWEPaymentInfoHandler) {
        super(activity, R.layout.pwe_item_debit_atm, arrayList);
        this.getSelectedBankId = "";
        this.selectedPosition = -1;
        this.context = activity;
        this.generalHelper = new PWEGeneralHelper(this.context);
        this.bankNamesList = arrayList;
        ArrayList<PWEBankCodeModel> arrayList2 = new ArrayList<>();
        this.backupBankNamesList = arrayList2;
        arrayList2.addAll(this.bankNamesList);
        this.paymentInfoHandler = pWEPaymentInfoHandler;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.pwe_item_debit_atm, (ViewGroup) null, true);
            view.setTag(new DebitAtmHolder(view));
        }
        DebitAtmHolder debitAtmHolder = (DebitAtmHolder) view.getTag();
        debitAtmHolder.tvBankName.setText(this.bankNamesList.get(i).getBank_name());
        debitAtmHolder.linearRoot.setOnClickListener(new View.OnClickListener() { // from class: adapters.PWEDebitAtmAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PWEDebitAtmAdapter.this.paymentInfoHandler.getPWEDeviceType().equals("NORMAL")) {
                    PWEDebitAtmAdapter pWEDebitAtmAdapter = PWEDebitAtmAdapter.this;
                    pWEDebitAtmAdapter.setSelectedBankId(((PWEBankCodeModel) pWEDebitAtmAdapter.bankNamesList.get(i)).bank_id);
                    PWEDebitAtmAdapter.this.selectDebitAtmOption(view2, i);
                }
            }
        });
        if (this.bankNamesList.get(i).bank_id == getSelectedBankId()) {
            selectDebitAtmOption(debitAtmHolder.linearRoot, i);
            return view;
        }
        deselect(debitAtmHolder.linearRoot);
        return view;
    }

    private static class DebitAtmHolder {
        private ImageView imgSelectedOption;
        private LinearLayout linearRoot;
        private TextView tvBankName;

        public DebitAtmHolder(View view) {
            this.imgSelectedOption = (ImageView) view.findViewById(R.id.img_debit_atm_pin);
            this.tvBankName = (TextView) view.findViewById(R.id.text_debit_atm_pin_bank);
            this.linearRoot = (LinearLayout) view.findViewById(R.id.linear_debit_atm_root);
        }
    }

    public void filter(String str) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        this.bankNamesList.clear();
        if (lowerCase.length() == 0) {
            this.bankNamesList.addAll(this.backupBankNamesList);
        } else {
            for (PWEBankCodeModel pWEBankCodeModel : this.backupBankNamesList) {
                if (pWEBankCodeModel.bank_name.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
                    this.bankNamesList.add(pWEBankCodeModel);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void selectDebitAtmOption(View view, int i) {
        this.debitAtmListener.selectDebitAtmOption(this.bankNamesList.get(i), i);
        View view2 = this.lastSelectedView;
        if (view2 != null) {
            deselect(view2);
        }
        select(view);
        this.lastSelectedView = view;
    }

    private void select(View view) {
        this.generalHelper.setImageToImageView("", (ImageView) view.findViewById(R.id.img_debit_atm_pin), PWEStaticDataModel.PWEDefaultSelectedCircleIcon);
        ((LinearLayout) view.findViewById(R.id.linear_debit_atm_root)).setBackground(this.context.getResources().getDrawable(R.drawable.pwe_selected_item_background));
    }

    private void deselect(View view) {
        this.generalHelper.setImageToImageView("", (ImageView) view.findViewById(R.id.img_debit_atm_pin), PWEStaticDataModel.PWEDefaultNotSelectedCircleIcon);
        ((LinearLayout) view.findViewById(R.id.linear_debit_atm_root)).setBackground(this.context.getResources().getDrawable(R.drawable.pwe_custom_card_background));
    }

    public void setDebitAtmListener(PWEDebitAtmListener pWEDebitAtmListener) {
        this.debitAtmListener = pWEDebitAtmListener;
    }

    public String getSelectedBankId() {
        return this.getSelectedBankId;
    }

    public void setSelectedBankId(String str) {
        this.getSelectedBankId = str;
        notifyDataSetChanged();
    }
}
