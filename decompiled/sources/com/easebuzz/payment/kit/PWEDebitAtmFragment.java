package com.easebuzz.payment.kit;

import adapters.PWEDebitAtmAdapter;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import datamodels.PWEBankCodeModel;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;
import java.util.Locale;
import listeners.ConnectionDetector;
import listeners.PWEDebitAtmListener;

/* JADX INFO: loaded from: classes7.dex */
public class PWEDebitAtmFragment extends Fragment {
    private ArrayList<PWEBankCodeModel> bankNamesList;
    private Button buttonPayDebitAtm;
    private PWECouponsActivity couponsActivity;
    private PWEDebitAtmAdapter debitAtmAdapter;
    private View debitAtmView;
    private EditText editSearchBank;
    private PWEGeneralHelper generalHelper;
    private ConnectionDetector internetDetecter;
    private ListView lvDebitAtmPinBanks;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private boolean open_payment_option = true;
    private String bankname = "";
    private int selectedItemPosition = -1;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.debitAtmView = layoutInflater.inflate(R.layout.fragment_pwe_debit_atm_pin, viewGroup, false);
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.internetDetecter = new ConnectionDetector(getActivity());
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        initViews();
        return this.debitAtmView;
    }

    private void initViews() {
        this.bankNamesList = new ArrayList<>();
        EditText editText = (EditText) this.debitAtmView.findViewById(R.id.edit_searchview_atm_debit_pin);
        this.editSearchBank = editText;
        this.generalHelper.pweDisableCopyAndPaste(editText);
        this.editSearchBank.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEDebitAtmFragment.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEDebitAtmFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEDebitAtmFragment.this.editSearchBank.setBackground(PWEDebitAtmFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEDebitAtmFragment.this.editSearchBank.setBackground(PWEDebitAtmFragment.this.getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        this.lvDebitAtmPinBanks = (ListView) this.debitAtmView.findViewById(R.id.list_atm_debit_pin_banks);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.lvDebitAtmPinBanks.setSelector(getResources().getDrawable(R.drawable.pwe_listview_item_selector));
        }
        this.buttonPayDebitAtm = (Button) this.debitAtmView.findViewById(R.id.button_proceed_for_payment);
        this.bankNamesList = this.generalHelper.getBankNameCodeList(PWEStaticDataModel.PAYOPT_DEBIT_ATM_NAME, PWEStaticDataModel.PAYOPT_DEBITCARD_DISPLAY_NAME, "NA");
        setBankNameAdpter();
        this.editSearchBank.setFocusable(false);
        this.editSearchBank.clearFocus();
        this.editSearchBank.setOnTouchListener(new View.OnTouchListener() { // from class: com.easebuzz.payment.kit.PWEDebitAtmFragment.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                PWEDebitAtmFragment.this.editSearchBank.setFocusableInTouchMode(true);
                return false;
            }
        });
        this.editSearchBank.addTextChangedListener(new TextWatcher() { // from class: com.easebuzz.payment.kit.PWEDebitAtmFragment.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PWEDebitAtmFragment.this.debitAtmAdapter.filter(PWEDebitAtmFragment.this.editSearchBank.getText().toString().toLowerCase(Locale.getDefault()));
            }
        });
        this.buttonPayDebitAtm.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEDebitAtmFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PWEDebitAtmFragment.this.internetDetecter.isConnectingToInternet()) {
                    PWEDebitAtmFragment.this.open_payment_option = true;
                    PWEDebitAtmFragment.this.generalHelper.showPweToast(PWEStaticDataModel.NO_INTERNET_CONNECTION_TEXT);
                } else if (PWEDebitAtmFragment.this.validateAllFields() && PWEDebitAtmFragment.this.open_payment_option) {
                    PWEDebitAtmFragment.this.open_payment_option = false;
                    PWEDebitAtmFragment.this.couponsActivity.submitPayment(PWEDebitAtmFragment.this.bankname, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                }
            }
        });
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonPayDebitAtm.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.buttonPayDebitAtm);
        }
    }

    private void setBankNameAdpter() {
        PWEDebitAtmAdapter pWEDebitAtmAdapter = new PWEDebitAtmAdapter(getActivity(), this.bankNamesList, this.paymentInfoHandler);
        this.debitAtmAdapter = pWEDebitAtmAdapter;
        this.lvDebitAtmPinBanks.setAdapter((ListAdapter) pWEDebitAtmAdapter);
        this.lvDebitAtmPinBanks.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.easebuzz.payment.kit.PWEDebitAtmFragment.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PWEDebitAtmFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    PWEDebitAtmFragment.this.debitAtmAdapter.selectDebitAtmOption(view, i);
                    PWEDebitAtmFragment.this.debitAtmAdapter.setSelectedBankId(((PWEBankCodeModel) PWEDebitAtmFragment.this.bankNamesList.get(i)).bank_id);
                }
            }
        });
        this.generalHelper.setListViewHeightBasedOnChildren(this.lvDebitAtmPinBanks);
        this.debitAtmAdapter.setDebitAtmListener(new PWEDebitAtmListener() { // from class: com.easebuzz.payment.kit.PWEDebitAtmFragment.6
            @Override // listeners.PWEDebitAtmListener
            public void selectDebitAtmOption(PWEBankCodeModel pWEBankCodeModel, int i) {
                PWEDebitAtmFragment.this.bankname = pWEBankCodeModel.getBank_id();
                PWEDebitAtmFragment.this.selectedItemPosition = i;
            }
        });
    }

    boolean validateAllFields() {
        String str = this.bankname;
        if (str != null && !str.equals("")) {
            return true;
        }
        this.generalHelper.showPweToast("Please select the bank of your debit card.");
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        int i;
        this.open_payment_option = true;
        try {
            if (this.debitAtmAdapter != null && this.bankNamesList.size() > 0 && this.selectedItemPosition < this.bankNamesList.size() && (i = this.selectedItemPosition) != -1) {
                this.debitAtmAdapter.setSelectedBankId(this.bankNamesList.get(i).getBank_id());
                this.debitAtmAdapter.notifyDataSetChanged();
                this.selectedItemPosition = -1;
            } else {
                this.selectedItemPosition = -1;
                this.bankname = "";
            }
        } catch (Exception unused) {
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
