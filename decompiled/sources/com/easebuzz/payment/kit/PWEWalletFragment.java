package com.easebuzz.payment.kit;

import adapters.PWEWalletAdapter;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.internal.Constants;
import com.appnew.android.Utils.Const;
import datamodels.CashCardWalletDataModel;
import datamodels.DiscountCodeDataModel;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;
import listeners.ConnectionDetector;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class PWEWalletFragment extends Fragment {
    private Button buttonPayWallet;
    private ArrayList<CashCardWalletDataModel> cashCardNamesList;
    private PWECouponsActivity couponsActivity;
    private PWEDiscountHelper discountCodeHelper;
    private PWEGeneralHelper generalHelper;
    private ExpandableHeightGridView gridWalletType;
    private ConnectionDetector internetDetecter;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private TextView txtWalletNoteMessage;
    private PWEWalletAdapter walletAdapter;
    private View walletView;
    private String selectedBankCode = "";
    private String bankname = "";
    private boolean open_payment_option = true;
    private String txn_id = "";
    private int selectedWalletItemPosition = -1;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.walletView = layoutInflater.inflate(R.layout.fragment_pwe_wallet, viewGroup, false);
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.internetDetecter = new ConnectionDetector(getActivity());
        this.internetDetecter = new ConnectionDetector(getActivity());
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.discountCodeHelper = this.couponsActivity.getDiscountHelper();
        this.open_payment_option = true;
        this.txn_id = this.paymentInfoHandler.getMerchantTxnId();
        initViews();
        return this.walletView;
    }

    private void initViews() {
        this.cashCardNamesList = new ArrayList<>();
        this.gridWalletType = (ExpandableHeightGridView) this.walletView.findViewById(R.id.cash_card_grid);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.gridWalletType.setSelector(getResources().getDrawable(R.drawable.pwe_gridview_item_selector));
        }
        this.buttonPayWallet = (Button) this.walletView.findViewById(R.id.button_proceed_for_payment);
        this.txtWalletNoteMessage = (TextView) this.walletView.findViewById(R.id.text_note_message);
        if (this.paymentInfoHandler.getWalletNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getWalletNoteMessage().equals("")) {
            this.txtWalletNoteMessage.setVisibility(8);
        } else {
            this.txtWalletNoteMessage.setVisibility(0);
            this.txtWalletNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getWalletNoteMessage()));
        }
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonPayWallet.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.buttonPayWallet);
        }
        this.buttonPayWallet.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEWalletFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PWEWalletFragment.this.internetDetecter.isConnectingToInternet()) {
                    if (PWEWalletFragment.this.validateCashCardId() && PWEWalletFragment.this.open_payment_option) {
                        PWEWalletFragment.this.open_payment_option = false;
                        PWEWalletFragment.this.couponsActivity.submitPayment(PWEWalletFragment.this.bankname, "", PWEWalletFragment.this.selectedBankCode, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                        return;
                    }
                    return;
                }
                PWEWalletFragment.this.open_payment_option = true;
                PWEWalletFragment.this.generalHelper.showPweToast(PWEStaticDataModel.NO_INTERNET_CONNECTION_TEXT);
            }
        });
        prepareCashCardNames();
        setCashCardListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateCashCardId() {
        String str = this.bankname;
        if (str != null && !str.equals("")) {
            return true;
        }
        this.generalHelper.showPweToast("Please select wallet.");
        return false;
    }

    private void prepareCashCardNames() {
        try {
            JSONArray jSONArray = new JSONArray(this.paymentInfoHandler.getBankCodeString());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.getString(Const.CATEGORY).equals("Cash Card")) {
                    String string = jSONObject.getString("bank_name");
                    String string2 = jSONObject.getString("image");
                    String string3 = jSONObject.getString("bank_id");
                    String string4 = jSONObject.getString("bank_code");
                    this.cashCardNamesList.add(new CashCardWalletDataModel(string, string3, string2, PWEStaticDataModel.PWEDefaultWalletIcon, string4, jSONObject.getString("image").split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r3.length - 1], false));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void setCashCardListAdapter() {
        PWEWalletAdapter pWEWalletAdapter = new PWEWalletAdapter(getActivity(), this.cashCardNamesList);
        this.walletAdapter = pWEWalletAdapter;
        this.gridWalletType.setAdapter((ListAdapter) pWEWalletAdapter);
        this.gridWalletType.setNumColumns(3);
        this.gridWalletType.setExpanded(true);
        this.gridWalletType.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.easebuzz.payment.kit.PWEWalletFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PWEWalletFragment.this.walletAdapter.setSelectedPosition(i);
                PWEWalletFragment.this.selectedWalletItemPosition = i;
                CashCardWalletDataModel cashCardWalletDataModel = (CashCardWalletDataModel) adapterView.getItemAtPosition(i);
                PWEWalletFragment.this.bankname = cashCardWalletDataModel.cash_card_id;
                PWEWalletFragment.this.selectedBankCode = cashCardWalletDataModel.bank_code;
                if (!PWEWalletFragment.this.paymentInfoHandler.getIsDiscountCouponApplied() || PWEWalletFragment.this.selectedWalletItemPosition == -1) {
                    return;
                }
                PWEWalletFragment.this.couponsActivity.resetDiscountCode();
            }
        });
    }

    public JSONObject validateDiscountCodeOuter(ArrayList<DiscountCodeDataModel> arrayList, PWEDiscountHelper pWEDiscountHelper) {
        String str = "";
        if (!this.selectedBankCode.equals("")) {
            try {
                this.discountCodeHelper.setBankCode(this.selectedBankCode);
            } catch (Error | Exception unused) {
            }
        } else {
            this.selectedBankCode = "";
        }
        this.discountCodeHelper = pWEDiscountHelper;
        JSONObject jSONObject = new JSONObject();
        String str2 = this.bankname;
        boolean z = false;
        if (str2 == null || str2.equals("")) {
            str = "Please select wallet before applying discount code";
        } else if (arrayList.size() < 1) {
            str = "Discount codes are not available for this payment mode";
        } else {
            z = true;
        }
        try {
            jSONObject.put("status", z);
            jSONObject.put("toast_error_message", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        int i;
        this.open_payment_option = true;
        if (this.walletAdapter != null && this.cashCardNamesList.size() > 0 && (i = this.selectedWalletItemPosition) != -1 && i < this.cashCardNamesList.size()) {
            this.walletAdapter.setSelectedPosition(this.selectedWalletItemPosition);
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }
}
