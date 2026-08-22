package com.easebuzz.payment.kit;

import adapters.PWESpinnerAdapter;
import adapters.PWESpinnerArrayAdapter;
import android.os.Bundle;
import android.text.Html;
import android.text.InputFilter;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.internal.Constants;
import datamodels.PWEBankCodeModel;
import datamodels.PWEStaticDataModel;
import helper.RsaHelper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import listeners.ConnectionDetector;

/* JADX INFO: loaded from: classes7.dex */
public class PWEEnachFragment extends Fragment {
    private ArrayList<String> authTypeList;
    private PWESpinnerArrayAdapter bankNameAdapter;
    private ArrayList<PWEBankCodeModel> bankNamesList;
    private ArrayList<String> bankTypeList;
    private Button buttonPayEnach;
    private PWECouponsActivity couponsActivity;
    private EditText editBankAccountNumber;
    private EditText editBankIFSCCode;
    private EditText editNameOfBankAccountHolder;
    private View enachView;
    private PWEGeneralHelper generalHelper;
    private ConnectionDetector internetDetecter;
    private LinearLayout layout_bankList;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private RsaHelper rsaHelper;
    private Spinner spinnerAccountType;
    private PWESpinnerAdapter spinnerAdapterAuthType;
    private PWESpinnerAdapter spinnerAdapterBankType;
    private Spinner spinnerAuthType;
    private Spinner spinnerBankName;
    private TextView tvAuthTypeError;
    private TextView tvBankAccountNumberError;
    private TextView tvBankTypeError;
    private TextView tvEnachNoteMessage;
    private TextView tvIFSCCodeError;
    private TextView tvNameOfBankAccountHolderError;
    public boolean open_payment_option = true;
    private String bankNameHint = "Bank Name";
    private String selected_account_type = "";
    private String selected_bank_name = "";
    private String selected_bank_code = "";
    private String selected_auth_type = "";
    String bank_account_number = "";
    String account_holder_name = "";
    String bank_ifsc_code = "";
    String base64AccNo = "";
    String base64AccholderName = "";
    String base64AccountType = "";

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.enachView = layoutInflater.inflate(R.layout.fragment_pwe_enach, viewGroup, false);
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.open_payment_option = true;
        this.internetDetecter = new ConnectionDetector(getActivity());
        this.rsaHelper = new RsaHelper();
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        initViews();
        prepareEnachBankData();
        return this.enachView;
    }

    private void initViews() {
        this.bankNamesList = new ArrayList<>();
        this.bankTypeList = new ArrayList<>();
        this.authTypeList = new ArrayList<>();
        EditText editText = (EditText) this.enachView.findViewById(R.id.edit_name_of_bank_account_holder);
        this.editNameOfBankAccountHolder = editText;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEEnachFragment.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEEnachFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEEnachFragment.this.editNameOfBankAccountHolder.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEEnachFragment.this.editNameOfBankAccountHolder.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        this.editBankAccountNumber = (EditText) this.enachView.findViewById(R.id.edit_bank_account_number);
        EditText editText2 = (EditText) this.enachView.findViewById(R.id.edit_bank_ifsc_code);
        this.editBankIFSCCode = editText2;
        editText2.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        this.editBankIFSCCode.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEEnachFragment.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEEnachFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEEnachFragment.this.editBankIFSCCode.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEEnachFragment.this.editBankIFSCCode.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        this.editBankAccountNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEEnachFragment.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEEnachFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEEnachFragment.this.editBankAccountNumber.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEEnachFragment.this.editBankAccountNumber.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        this.spinnerAccountType = (Spinner) this.enachView.findViewById(R.id.spin_bank_account_type);
        this.spinnerBankName = (Spinner) this.enachView.findViewById(R.id.spin_bank_name);
        this.spinnerAuthType = (Spinner) this.enachView.findViewById(R.id.spin_auth_type);
        this.layout_bankList = (LinearLayout) this.enachView.findViewById(R.id.layout_bankList);
        this.spinnerAccountType.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEEnachFragment.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEEnachFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEEnachFragment.this.spinnerAccountType.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEEnachFragment.this.spinnerAccountType.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_text_button_default));
                    }
                }
            }
        });
        this.spinnerAuthType.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEEnachFragment.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEEnachFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEEnachFragment.this.spinnerAuthType.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEEnachFragment.this.spinnerAuthType.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_text_button_default));
                    }
                }
            }
        });
        this.spinnerBankName.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEEnachFragment.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEEnachFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEEnachFragment.this.spinnerBankName.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEEnachFragment.this.spinnerBankName.setBackground(PWEEnachFragment.this.getResources().getDrawable(R.drawable.pwe_android_tv_text_button_default));
                    }
                }
            }
        });
        this.tvNameOfBankAccountHolderError = (TextView) this.enachView.findViewById(R.id.text_name_of_bank_account_holder_error);
        this.tvBankAccountNumberError = (TextView) this.enachView.findViewById(R.id.text_bank_account_no_error);
        this.tvBankTypeError = (TextView) this.enachView.findViewById(R.id.text_bank_type_error);
        this.tvIFSCCodeError = (TextView) this.enachView.findViewById(R.id.text_ifsc_code_error);
        this.tvAuthTypeError = (TextView) this.enachView.findViewById(R.id.text_auth_type_error);
        this.buttonPayEnach = (Button) this.enachView.findViewById(R.id.button_proceed_for_payment);
        this.tvEnachNoteMessage = (TextView) this.enachView.findViewById(R.id.text_note_message);
        if (this.paymentInfoHandler.getEnachNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getEnachNoteMessage().equals("")) {
            this.tvEnachNoteMessage.setVisibility(8);
        } else {
            this.tvEnachNoteMessage.setVisibility(0);
            this.tvEnachNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getEnachNoteMessage()));
        }
        this.buttonPayEnach.setText("Authorize E-NACH");
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonPayEnach.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.buttonPayEnach);
        }
        this.buttonPayEnach.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEEnachFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PWEEnachFragment.this.internetDetecter.isConnectingToInternet()) {
                    if (PWEEnachFragment.this.validateAllFields()) {
                        PWEEnachFragment.this.bankDeatilsEncryption();
                        if (PWEEnachFragment.this.open_payment_option) {
                            PWEEnachFragment.this.open_payment_option = false;
                            PWEEnachFragment.this.couponsActivity.submitPayment("", "", "", "", "", "", "", "", "", "", "", "", "", PWEEnachFragment.this.base64AccNo, PWEEnachFragment.this.base64AccholderName, PWEEnachFragment.this.base64AccountType, PWEEnachFragment.this.bank_ifsc_code, PWEEnachFragment.this.selected_auth_type, PWEEnachFragment.this.selected_bank_name, PWEEnachFragment.this.selected_bank_code, "", "");
                            return;
                        }
                        return;
                    }
                    PWEEnachFragment.this.open_payment_option = true;
                    return;
                }
                PWEEnachFragment.this.open_payment_option = true;
                PWEEnachFragment.this.generalHelper.showPweToast(PWEStaticDataModel.NO_INTERNET_CONNECTION_TEXT);
            }
        });
        this.generalHelper.pweDisableCopyAndPaste(this.editBankAccountNumber);
        this.generalHelper.pweDisableCopyAndPaste(this.editBankIFSCCode);
        this.generalHelper.pweDisableCopyAndPaste(this.editNameOfBankAccountHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bankDeatilsEncryption() {
        this.bank_account_number = this.bank_account_number.trim();
        this.account_holder_name = this.account_holder_name.trim();
        this.selected_account_type = this.selected_account_type.toUpperCase().trim();
        try {
            this.base64AccNo = Base64.encodeToString(this.rsaHelper.RSAEncrypt(this.bank_account_number, RsaHelper.loadPublicKey(PWEStaticDataModel.public_key_for_rsa)), 2);
            this.base64AccholderName = Base64.encodeToString(this.rsaHelper.RSAEncrypt(this.account_holder_name, RsaHelper.loadPublicKey(PWEStaticDataModel.public_key_for_rsa)), 2);
            this.base64AccountType = Base64.encodeToString(this.rsaHelper.RSAEncrypt(this.selected_account_type, RsaHelper.loadPublicKey(PWEStaticDataModel.public_key_for_rsa)), 2);
        } catch (IOException | Error | GeneralSecurityException | Exception unused) {
        }
    }

    private void prepareEnachBankData() {
        this.bankTypeList = this.generalHelper.pweGetAccountTypeList();
        PWESpinnerAdapter pWESpinnerAdapter = new PWESpinnerAdapter(getActivity(), this.bankTypeList, "Account Type");
        this.spinnerAdapterBankType = pWESpinnerAdapter;
        this.spinnerAccountType.setAdapter((SpinnerAdapter) pWESpinnerAdapter);
        this.spinnerAccountType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.easebuzz.payment.kit.PWEEnachFragment.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                PWEEnachFragment.this.selected_account_type = adapterView.getItemAtPosition(i).toString();
                PWEEnachFragment pWEEnachFragment = PWEEnachFragment.this;
                pWEEnachFragment.selected_account_type = pWEEnachFragment.selected_account_type.toUpperCase().trim();
            }
        });
        ArrayList<PWEBankCodeModel> bankNameCodeList = this.generalHelper.getBankNameCodeList(PWEStaticDataModel.PAYOPT_ENACH_NAME, PWEStaticDataModel.PAYOPT_ENACH_DISPLAY_NAME, "ENACH_BANK_NAMES");
        this.bankNamesList = bankNameCodeList;
        if (bankNameCodeList.size() > 1 && this.paymentInfoHandler.getIsPaperBaseEnabled() == 1) {
            this.layout_bankList.setVisibility(0);
            PWESpinnerArrayAdapter pWESpinnerArrayAdapter = new PWESpinnerArrayAdapter(getActivity(), this.bankNamesList, this.bankNameHint);
            this.bankNameAdapter = pWESpinnerArrayAdapter;
            this.spinnerBankName.setAdapter((SpinnerAdapter) pWESpinnerArrayAdapter);
            this.spinnerBankName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.easebuzz.payment.kit.PWEEnachFragment.9
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    PWEBankCodeModel pWEBankCodeModel = (PWEBankCodeModel) adapterView.getItemAtPosition(i);
                    PWEEnachFragment.this.selected_bank_name = pWEBankCodeModel.getBank_name();
                    PWEEnachFragment.this.selected_bank_code = pWEBankCodeModel.getBank_code();
                }
            });
        } else {
            this.layout_bankList.setVisibility(8);
        }
        this.authTypeList = this.generalHelper.pweGetAuthTypeList();
        PWESpinnerAdapter pWESpinnerAdapter2 = new PWESpinnerAdapter(getActivity(), this.authTypeList, "Auth Type");
        this.spinnerAdapterAuthType = pWESpinnerAdapter2;
        this.spinnerAuthType.setAdapter((SpinnerAdapter) pWESpinnerAdapter2);
        this.spinnerAuthType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.easebuzz.payment.kit.PWEEnachFragment.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                PWEEnachFragment.this.selected_auth_type = adapterView.getItemAtPosition(i).toString();
                if (PWEEnachFragment.this.selected_auth_type.equals("Paper Base")) {
                    PWEEnachFragment.this.selected_auth_type = "Physical";
                }
                PWEEnachFragment pWEEnachFragment = PWEEnachFragment.this;
                pWEEnachFragment.selected_auth_type = pWEEnachFragment.selected_auth_type.trim();
                PWEEnachFragment pWEEnachFragment2 = PWEEnachFragment.this;
                pWEEnachFragment2.selected_auth_type = pWEEnachFragment2.selected_auth_type.replace(" ", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f6 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean validateAllFields() {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easebuzz.payment.kit.PWEEnachFragment.validateAllFields():boolean");
    }
}
