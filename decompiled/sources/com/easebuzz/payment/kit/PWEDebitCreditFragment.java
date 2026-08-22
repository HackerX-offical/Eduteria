package com.easebuzz.payment.kit;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.internal.Constants;
import datamodels.CardValidationModel;
import datamodels.PWEStaticDataModel;
import helper.RsaHelper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Calendar;
import kotlinx.coroutines.DebugKt;
import listeners.ConnectionDetector;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes7.dex */
public class PWEDebitCreditFragment extends Fragment {
    private Button buttonPayDebit;
    private CheckBox cbSaveCard;
    private PWECouponsActivity couponsActivity;
    private View creditDebitView;
    private EditText editCVVNumber;
    private EditText editCardNumber;
    private EditText editExpireDate;
    private EditText editNameOnCard;
    private PWEGeneralHelper generalHelper;
    private ConnectionDetector internetDetecter;
    private ImageView ivCardType;
    private LinearLayout linearCardNameHolder;
    private LinearLayout linearCardNumberHolder;
    private LinearLayout linearCvvNumberHolder;
    private LinearLayout linearLayoutExpDateHolder;
    LinearLayout linearLayoutRoot;
    private LinearLayout linearSaveCardCheckHolder;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private RsaHelper rsaHelper;
    private TextView tvCardNumberError;
    private TextView tvCardType;
    private TextView tvCvvError;
    private TextView tvExpiryDateError;
    private TextView tvNameOnCardError;
    private TextView txtCardNoteMessage;
    private String selectedEMIPlanObj = "";
    private String selected_payment_option = "";
    private ArrayList<CardValidationModel> listCardExpression = new ArrayList<>();
    private String selected_card_type = "";
    public String no_cvv_flag = "";
    private String save_card_flag = "";
    private String name_on_card = "";
    private String card_num = "";
    private String exp_date = "";
    private String cvv = "";
    public boolean open_payment_option = true;
    private boolean isExpireDateValid = true;
    private String epireDateMsg = "";

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        PWEPaymentInfoHandler pWEPaymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.paymentInfoHandler = pWEPaymentInfoHandler;
        this.selected_payment_option = pWEPaymentInfoHandler.getSelectedPaymentOption();
        this.rsaHelper = new RsaHelper();
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.internetDetecter = new ConnectionDetector(getActivity());
        this.creditDebitView = layoutInflater.inflate(R.layout.fragment_pwe_debit_credit, viewGroup, false);
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.open_payment_option = true;
        this.listCardExpression = new ArrayList<>();
        this.listCardExpression = this.generalHelper.getCardTypeExpressionsList();
        initViews();
        predictCardType();
        return this.creditDebitView;
    }

    private void initViews() {
        this.tvCardType = (TextView) this.creditDebitView.findViewById(R.id.text_card_type_label);
        this.tvCardNumberError = (TextView) this.creditDebitView.findViewById(R.id.text_card_no_error);
        this.tvNameOnCardError = (TextView) this.creditDebitView.findViewById(R.id.text_name_on_card_error);
        this.tvCvvError = (TextView) this.creditDebitView.findViewById(R.id.text_cvv_error);
        this.linearSaveCardCheckHolder = (LinearLayout) this.creditDebitView.findViewById(R.id.linear_check_save_card_holder);
        this.linearLayoutExpDateHolder = (LinearLayout) this.creditDebitView.findViewById(R.id.linear_exp_date_holder_dc);
        if (this.selected_payment_option.equals(PWEStaticDataModel.PAYOPT_CREDITCARD_NAME) || this.selected_payment_option.equals(PWEStaticDataModel.EMI_NAME)) {
            this.tvCardType.setText(PWEStaticDataModel.PAYOPT_CREDITCARD_DISPLAY_NAME);
        } else {
            this.tvCardType.setText(PWEStaticDataModel.PAYOPT_DEBITCARD_DISPLAY_NAME);
        }
        if (this.selected_payment_option.equals(PWEStaticDataModel.EMI_NAME)) {
            this.selectedEMIPlanObj = getArguments().getString("emi_pan");
        } else {
            this.selectedEMIPlanObj = "";
            this.linearLayoutRoot = (LinearLayout) this.creditDebitView.findViewById(R.id.linear_root_debit_credit);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(30, 30, 30, 30);
            this.linearLayoutRoot.setLayoutParams(layoutParams);
        }
        this.editCVVNumber = (EditText) this.creditDebitView.findViewById(R.id.edit_cvv_number);
        this.linearCvvNumberHolder = (LinearLayout) this.creditDebitView.findViewById(R.id.cvv_number_holder);
        this.editCVVNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEDebitCreditFragment.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEDebitCreditFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEDebitCreditFragment.this.linearCvvNumberHolder.setBackground(PWEDebitCreditFragment.this.getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEDebitCreditFragment.this.linearCvvNumberHolder.setBackground(PWEDebitCreditFragment.this.getActivity().getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        this.editCVVNumber.addTextChangedListener(new TextWatcher() { // from class: com.easebuzz.payment.kit.PWEDebitCreditFragment.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (PWEDebitCreditFragment.this.tvCvvError.getVisibility() == 0) {
                    PWEDebitCreditFragment.this.tvCvvError.setVisibility(4);
                    PWEDebitCreditFragment.this.hideErrorMsgView();
                }
            }
        });
        this.cbSaveCard = (CheckBox) this.creditDebitView.findViewById(R.id.check_save_card);
        if (this.paymentInfoHandler.getIsSavedCard() == 1) {
            this.linearSaveCardCheckHolder.setVisibility(0);
        } else {
            this.linearSaveCardCheckHolder.setVisibility(8);
        }
        this.editNameOnCard = (EditText) this.creditDebitView.findViewById(R.id.edit_name_on_card);
        this.linearCardNameHolder = (LinearLayout) this.creditDebitView.findViewById(R.id.card_name_holder);
        this.editNameOnCard.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEDebitCreditFragment.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEDebitCreditFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEDebitCreditFragment.this.linearCardNameHolder.setBackground(PWEDebitCreditFragment.this.getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEDebitCreditFragment.this.linearCardNameHolder.setBackground(PWEDebitCreditFragment.this.getActivity().getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        this.editNameOnCard.addTextChangedListener(new TextWatcher() { // from class: com.easebuzz.payment.kit.PWEDebitCreditFragment.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (PWEDebitCreditFragment.this.tvNameOnCardError.getVisibility() == 0) {
                    PWEDebitCreditFragment.this.tvNameOnCardError.setVisibility(4);
                    PWEDebitCreditFragment.this.hideErrorMsgView();
                }
            }
        });
        this.editCardNumber = (EditText) this.creditDebitView.findViewById(R.id.edit_card_number);
        this.linearCardNumberHolder = (LinearLayout) this.creditDebitView.findViewById(R.id.card_number_holder);
        this.editCardNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEDebitCreditFragment.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEDebitCreditFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEDebitCreditFragment.this.linearCardNumberHolder.setBackground(PWEDebitCreditFragment.this.getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEDebitCreditFragment.this.linearCardNumberHolder.setBackground(PWEDebitCreditFragment.this.getActivity().getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        this.ivCardType = (ImageView) this.creditDebitView.findViewById(R.id.imgv_card_type);
        this.cbSaveCard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.easebuzz.payment.kit.PWEDebitCreditFragment.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    PWEDebitCreditFragment.this.save_card_flag = "true";
                } else {
                    PWEDebitCreditFragment.this.save_card_flag = "";
                }
            }
        });
        this.editExpireDate = (EditText) this.creditDebitView.findViewById(R.id.edit_expiry_date);
        this.tvExpiryDateError = (TextView) this.creditDebitView.findViewById(R.id.text_expiry_date_error);
        this.editExpireDate.addTextChangedListener(new TextWatcher() { // from class: com.easebuzz.payment.kit.PWEDebitCreditFragment.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String string = charSequence.toString();
                if (string.length() == 1 && i2 == 0) {
                    if (!string.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR) && Integer.parseInt(string) > 1) {
                        String str = "0" + string + MqttTopic.TOPIC_LEVEL_SEPARATOR;
                        PWEDebitCreditFragment.this.editExpireDate.setText(str);
                        PWEDebitCreditFragment.this.editExpireDate.setSelection(str.length());
                    }
                } else if (string.length() == 2 && i2 == 0) {
                    if (string.equals("00")) {
                        PWEDebitCreditFragment.this.editExpireDate.setText("");
                    } else if (!string.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR) && Integer.parseInt(string) >= 1 && Integer.parseInt(string) <= 12) {
                        String str2 = string + MqttTopic.TOPIC_LEVEL_SEPARATOR;
                        PWEDebitCreditFragment.this.editExpireDate.setText(str2);
                        PWEDebitCreditFragment.this.editExpireDate.setSelection(str2.length());
                    } else {
                        String strSubstring = string.substring(0, string.length() - 1);
                        if (!strSubstring.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR) && Integer.parseInt(strSubstring) > 1 && Integer.parseInt(strSubstring) < 12) {
                            strSubstring = "0" + strSubstring + MqttTopic.TOPIC_LEVEL_SEPARATOR;
                        }
                        PWEDebitCreditFragment.this.editExpireDate.setText(strSubstring);
                        PWEDebitCreditFragment.this.editExpireDate.setSelection(strSubstring.length());
                    }
                } else if (string.length() == 3 && !string.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                    String str3 = string.substring(0, 2) + MqttTopic.TOPIC_LEVEL_SEPARATOR + string.substring(2);
                    PWEDebitCreditFragment.this.editExpireDate.setText(str3);
                    PWEDebitCreditFragment.this.editExpireDate.setSelection(str3.length());
                    PWEDebitCreditFragment.this.isExpireDateValid = false;
                    PWEDebitCreditFragment.this.epireDateMsg = "Enter date MM/YYYY";
                } else if (string.length() == 5 && string.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR) && string.charAt(2) == '/' && PWEDebitCreditFragment.this.validateExpiryDate(string)) {
                    PWEDebitCreditFragment.this.isExpireDateValid = true;
                } else if (string.length() == 7 && i2 == 0 && string.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR) && string.charAt(2) == '/' && PWEDebitCreditFragment.this.validateExpiryDate(string)) {
                    PWEDebitCreditFragment.this.isExpireDateValid = true;
                } else if (string.length() != 7 && string.length() != 5) {
                    PWEDebitCreditFragment.this.isExpireDateValid = false;
                    PWEDebitCreditFragment.this.epireDateMsg = "Enter date MM/YYYY";
                }
                if (PWEDebitCreditFragment.this.tvExpiryDateError.getVisibility() == 0) {
                    PWEDebitCreditFragment.this.tvExpiryDateError.setVisibility(4);
                    PWEDebitCreditFragment.this.hideErrorMsgView();
                }
            }
        });
        this.editExpireDate.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWEDebitCreditFragment.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWEDebitCreditFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWEDebitCreditFragment.this.linearLayoutExpDateHolder.setBackground(PWEDebitCreditFragment.this.getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWEDebitCreditFragment.this.linearLayoutExpDateHolder.setBackground(PWEDebitCreditFragment.this.getActivity().getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        this.buttonPayDebit = (Button) this.creditDebitView.findViewById(R.id.button_proceed_for_payment);
        this.txtCardNoteMessage = (TextView) this.creditDebitView.findViewById(R.id.text_note_message);
        if (this.selected_payment_option.equals(PWEStaticDataModel.PAYOPT_CREDITCARD_NAME)) {
            if (this.paymentInfoHandler.getCreditCardNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getCreditCardNoteMessage().equals("")) {
                this.txtCardNoteMessage.setVisibility(8);
            } else {
                this.txtCardNoteMessage.setVisibility(0);
                this.txtCardNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getCreditCardNoteMessage()));
            }
        } else if (this.selected_payment_option.equals(PWEStaticDataModel.EMI_NAME)) {
            if (this.paymentInfoHandler.getEmiNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getEmiNoteMessage().equals("")) {
                this.txtCardNoteMessage.setVisibility(8);
            } else {
                this.txtCardNoteMessage.setVisibility(0);
                this.txtCardNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getEmiNoteMessage()));
            }
        } else if (this.paymentInfoHandler.getDebitCardNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getDebitCardNoteMessage().equals("")) {
            this.txtCardNoteMessage.setVisibility(8);
        } else {
            this.txtCardNoteMessage.setVisibility(0);
            this.txtCardNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getDebitCardNoteMessage()));
        }
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonPayDebit.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.buttonPayDebit);
        }
        this.generalHelper.pweDisableCopyAndPaste(this.editCVVNumber);
        this.generalHelper.pweDisableCopyAndPaste(this.editCardNumber);
        this.generalHelper.pweDisableCopyAndPaste(this.editNameOnCard);
        this.generalHelper.pweDisableCopyAndPaste(this.editExpireDate);
        this.buttonPayDebit.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEDebitCreditFragment.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String strEncodeToString;
                String strEncodeToString2;
                String strEncodeToString3;
                if (PWEDebitCreditFragment.this.internetDetecter.isConnectingToInternet()) {
                    String strEncodeToString4 = "";
                    String strReplaceAll = PWEDebitCreditFragment.this.editCardNumber.getText().toString().replaceAll("-", "");
                    if (PWEDebitCreditFragment.this.generalHelper.validatePweCardByLunh(strReplaceAll) && PWEDebitCreditFragment.this.validateAllFields()) {
                        PWEDebitCreditFragment.this.tvCardNumberError.setVisibility(8);
                        PWEDebitCreditFragment.this.card_num = strReplaceAll.trim();
                        PWEDebitCreditFragment pWEDebitCreditFragment = PWEDebitCreditFragment.this;
                        pWEDebitCreditFragment.name_on_card = pWEDebitCreditFragment.editNameOnCard.getText().toString();
                        PWEDebitCreditFragment pWEDebitCreditFragment2 = PWEDebitCreditFragment.this;
                        pWEDebitCreditFragment2.exp_date = pWEDebitCreditFragment2.editExpireDate.getText().toString();
                        if (PWEDebitCreditFragment.this.exp_date.length() == 5 && PWEDebitCreditFragment.this.exp_date.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                            PWEDebitCreditFragment.this.exp_date = PWEDebitCreditFragment.this.exp_date.substring(0, 3) + ("20" + PWEDebitCreditFragment.this.exp_date.substring(3));
                        }
                        PWEDebitCreditFragment pWEDebitCreditFragment3 = PWEDebitCreditFragment.this;
                        pWEDebitCreditFragment3.cvv = pWEDebitCreditFragment3.editCVVNumber.getText().toString().trim();
                        PWEDebitCreditFragment.this.no_cvv_flag = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                        try {
                            RsaHelper rsaHelper = PWEDebitCreditFragment.this.rsaHelper;
                            String str = PWEDebitCreditFragment.this.card_num;
                            RsaHelper unused = PWEDebitCreditFragment.this.rsaHelper;
                            strEncodeToString = Base64.encodeToString(rsaHelper.RSAEncrypt(str, RsaHelper.loadPublicKey(PWEStaticDataModel.public_key_for_rsa)), 2);
                            try {
                                RsaHelper rsaHelper2 = PWEDebitCreditFragment.this.rsaHelper;
                                String str2 = PWEDebitCreditFragment.this.name_on_card;
                                RsaHelper unused2 = PWEDebitCreditFragment.this.rsaHelper;
                                strEncodeToString2 = Base64.encodeToString(rsaHelper2.RSAEncrypt(str2, RsaHelper.loadPublicKey(PWEStaticDataModel.public_key_for_rsa)), 2);
                                try {
                                    RsaHelper rsaHelper3 = PWEDebitCreditFragment.this.rsaHelper;
                                    String str3 = PWEDebitCreditFragment.this.exp_date;
                                    RsaHelper unused3 = PWEDebitCreditFragment.this.rsaHelper;
                                    strEncodeToString3 = Base64.encodeToString(rsaHelper3.RSAEncrypt(str3, RsaHelper.loadPublicKey(PWEStaticDataModel.public_key_for_rsa)), 2);
                                    try {
                                        RsaHelper rsaHelper4 = PWEDebitCreditFragment.this.rsaHelper;
                                        String str4 = PWEDebitCreditFragment.this.cvv;
                                        RsaHelper unused4 = PWEDebitCreditFragment.this.rsaHelper;
                                        strEncodeToString4 = Base64.encodeToString(rsaHelper4.RSAEncrypt(str4, RsaHelper.loadPublicKey(PWEStaticDataModel.public_key_for_rsa)), 2);
                                    } catch (IOException | Error | GeneralSecurityException | Exception unused5) {
                                    }
                                } catch (IOException | Error | GeneralSecurityException | Exception unused6) {
                                    strEncodeToString3 = "";
                                }
                            } catch (IOException unused7) {
                                strEncodeToString2 = "";
                                strEncodeToString3 = strEncodeToString2;
                            } catch (Error unused8) {
                                strEncodeToString2 = "";
                                strEncodeToString3 = strEncodeToString2;
                            } catch (GeneralSecurityException unused9) {
                                strEncodeToString2 = "";
                                strEncodeToString3 = strEncodeToString2;
                            } catch (Exception unused10) {
                                strEncodeToString2 = "";
                                strEncodeToString3 = strEncodeToString2;
                            }
                        } catch (IOException unused11) {
                            strEncodeToString = "";
                            strEncodeToString2 = strEncodeToString;
                        } catch (Error unused12) {
                            strEncodeToString = "";
                            strEncodeToString2 = strEncodeToString;
                        } catch (GeneralSecurityException unused13) {
                            strEncodeToString = "";
                            strEncodeToString2 = strEncodeToString;
                        } catch (Exception unused14) {
                            strEncodeToString = "";
                            strEncodeToString2 = strEncodeToString;
                        }
                        String str5 = strEncodeToString;
                        String str6 = strEncodeToString4;
                        String str7 = strEncodeToString2;
                        String str8 = strEncodeToString3;
                        if (PWEDebitCreditFragment.this.open_payment_option) {
                            PWEDebitCreditFragment.this.open_payment_option = false;
                            PWEDebitCreditFragment.this.couponsActivity.submitPayment("", "", "", str5, str7, str8, PWEDebitCreditFragment.this.selected_card_type, str6, PWEDebitCreditFragment.this.no_cvv_flag, "", "", PWEDebitCreditFragment.this.save_card_flag, PWEDebitCreditFragment.this.selectedEMIPlanObj, "", "", "", "", "", "", "", "", "");
                            return;
                        }
                        return;
                    }
                    PWEDebitCreditFragment.this.open_payment_option = true;
                    if (strReplaceAll == null || strReplaceAll.isEmpty()) {
                        PWEDebitCreditFragment.this.tvCardNumberError.setText("Please enter a card number");
                        PWEDebitCreditFragment.this.tvCardNumberError.setVisibility(0);
                        PWEDebitCreditFragment.this.tvExpiryDateError.setVisibility(4);
                        return;
                    } else {
                        if (PWEDebitCreditFragment.this.generalHelper.validatePweCardByLunh(strReplaceAll)) {
                            return;
                        }
                        PWEDebitCreditFragment.this.tvCardNumberError.setText("Invalid card number");
                        PWEDebitCreditFragment.this.tvCardNumberError.setVisibility(0);
                        PWEDebitCreditFragment.this.tvExpiryDateError.setVisibility(4);
                        return;
                    }
                }
                PWEDebitCreditFragment.this.open_payment_option = true;
                PWEDebitCreditFragment.this.generalHelper.showPweToast(PWEStaticDataModel.NO_INTERNET_CONNECTION_TEXT);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateExpiryDate(String str) {
        String strSubstring = str.substring(3);
        String strSubstring2 = str.substring(0, 2);
        int i = Calendar.getInstance().get(1);
        if (strSubstring.length() == 2 && !strSubstring.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            strSubstring = "20" + strSubstring;
        }
        if ((strSubstring2.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR) && strSubstring2.equals("00")) || Integer.parseInt(strSubstring2) < 1 || Integer.parseInt(strSubstring2) > 12) {
            String strSubstring3 = str.substring(0, strSubstring2.length() - 1);
            this.editExpireDate.setText(strSubstring3);
            this.editExpireDate.setSelection(strSubstring3.length());
            this.epireDateMsg = "Enter date MM/YYYY";
            return false;
        }
        if (!strSubstring.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR) && Integer.parseInt(strSubstring) >= i) {
            this.epireDateMsg = "";
            return true;
        }
        this.epireDateMsg = "Invalid expiry date";
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(1:4)(2:(1:16)(2:12|(1:14)(8:15|18|(1:20)(1:21)|22|(3:33|24|27)(1:27)|35|28|32))|17)|5|18|(0)(0)|22|(0)(0)|35|28|32) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009b, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
    
        r9.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081 A[PHI: r2
      0x0081: PHI (r2v4 java.lang.String) = (r2v0 java.lang.String), (r2v2 java.lang.String) binds: [B:23:0x006b, B:24:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject validateDiscountCodeOuter(java.util.ArrayList<datamodels.DiscountCodeDataModel> r9, com.easebuzz.payment.kit.PWEDiscountHelper r10) {
        /*
            r8 = this;
            java.lang.String r10 = "Invalid bin number"
            android.widget.EditText r0 = r8.editCardNumber
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "-"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replaceAll(r1, r2)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            int r9 = r9.size()
            r3 = 0
            r4 = 1
            if (r9 >= r4) goto L26
            java.lang.String r9 = "Discount codes are not available for this payment mode"
            r5 = r2
        L24:
            r4 = r3
            goto L4b
        L26:
            if (r0 == 0) goto L45
            boolean r9 = r0.isEmpty()
            if (r9 != 0) goto L45
            boolean r9 = r0.equals(r2)
            if (r9 == 0) goto L35
            goto L45
        L35:
            com.easebuzz.payment.kit.PWEGeneralHelper r9 = r8.generalHelper
            boolean r9 = r9.validatePweCardByLunh(r0)
            if (r9 != 0) goto L42
            java.lang.String r9 = "Please enter valid card number before applying discount code"
            java.lang.String r4 = "Invalid card number"
            goto L49
        L42:
            r9 = r2
            r5 = r9
            goto L4b
        L45:
            java.lang.String r9 = "Please enter card number before applying discount code"
            java.lang.String r4 = "Please enter a card number"
        L49:
            r5 = r4
            goto L24
        L4b:
            r6 = 4
            if (r4 == 0) goto L59
            android.widget.TextView r7 = r8.tvCardNumberError
            r7.setVisibility(r6)
            android.widget.TextView r7 = r8.tvExpiryDateError
            r7.setVisibility(r6)
            goto L68
        L59:
            android.widget.TextView r7 = r8.tvCardNumberError
            r7.setText(r5)
            android.widget.TextView r7 = r8.tvCardNumberError
            r7.setVisibility(r3)
            android.widget.TextView r7 = r8.tvExpiryDateError
            r7.setVisibility(r6)
        L68:
            r8.hideErrorMsgView()
            if (r4 == 0) goto L81
            helper.RsaHelper r6 = r8.rsaHelper     // Catch: java.lang.Throwable -> L7f
            java.lang.String r7 = datamodels.PWEStaticDataModel.public_key_for_rsa     // Catch: java.lang.Throwable -> L7f
            java.security.PublicKey r7 = helper.RsaHelper.loadPublicKey(r7)     // Catch: java.lang.Throwable -> L7f
            byte[] r0 = r6.RSAEncrypt(r0, r7)     // Catch: java.lang.Throwable -> L7f
            r6 = 2
            java.lang.String r2 = android.util.Base64.encodeToString(r0, r6)     // Catch: java.lang.Throwable -> L7f
            goto L81
        L7f:
            r5 = r10
            goto L83
        L81:
            r10 = r9
            r3 = r4
        L83:
            java.lang.String r9 = "status"
            r1.put(r9, r3)     // Catch: org.json.JSONException -> L9b
            java.lang.String r9 = "bin_number"
            r1.put(r9, r2)     // Catch: org.json.JSONException -> L9b
            java.lang.String r9 = "toast_error_message"
            r1.put(r9, r10)     // Catch: org.json.JSONException -> L9b
            java.lang.String r9 = "text_error_message"
            r1.put(r9, r5)     // Catch: org.json.JSONException -> L9b
            goto L9f
        L9b:
            r9 = move-exception
            r9.printStackTrace()
        L9f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easebuzz.payment.kit.PWEDebitCreditFragment.validateDiscountCodeOuter(java.util.ArrayList, com.easebuzz.payment.kit.PWEDiscountHelper):org.json.JSONObject");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|(1:4)(1:5)|6|(3:8|(1:10)(1:11)|12)(2:13|(1:15)(13:17|18|(1:20)(2:22|(10:27|54|28|(2:30|(3:52|32|33))|39|(1:41)(1:42)|43|(1:45)(2:46|(1:48)(1:49))|50|51)(1:26))|21|54|28|(0)|39|(0)(0)|43|(0)(0)|50|51))|16|18|(0)(0)|21|54|28|(0)|39|(0)(0)|43|(0)(0)|50|51) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0116, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0117, code lost:
    
        r3 = r0;
        r0 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e4 A[Catch: ParseException -> 0x0116, TRY_LEAVE, TryCatch #1 {ParseException -> 0x0116, blocks: (B:28:0x00c3, B:30:0x00e4), top: B:54:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean validateAllFields() {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easebuzz.payment.kit.PWEDebitCreditFragment.validateAllFields():boolean");
    }

    void hideErrorMsgView() {
        if (this.tvCardNumberError.getVisibility() == 4 && this.tvExpiryDateError.getVisibility() == 4) {
            this.tvCardNumberError.setVisibility(8);
            this.tvExpiryDateError.setVisibility(8);
        }
        if (this.tvNameOnCardError.getVisibility() == 4 && this.tvCvvError.getVisibility() == 4) {
            this.tvNameOnCardError.setVisibility(8);
            this.tvCvvError.setVisibility(8);
        }
    }

    private void predictCardType() {
        this.editCardNumber.addTextChangedListener(new TextWatcher() { // from class: com.easebuzz.payment.kit.PWEDebitCreditFragment.10
            private static final char space = '-';

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (PWEDebitCreditFragment.this.tvCardNumberError.getVisibility() == 0) {
                    PWEDebitCreditFragment.this.tvCardNumberError.setVisibility(4);
                    PWEDebitCreditFragment.this.hideErrorMsgView();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    if (PWEDebitCreditFragment.this.paymentInfoHandler.IsCancelTransactionFragmentOpen()) {
                        return;
                    }
                    if (!editable.toString().isEmpty() && !editable.toString().equals("")) {
                        String string = editable.toString();
                        if (editable.length() > 0 && editable.length() % 5 == 0 && '-' == editable.charAt(editable.length() - 1)) {
                            editable.delete(editable.length() - 1, editable.length());
                        }
                        if (editable.length() > 0 && editable.length() % 5 == 0 && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), String.valueOf(space)).length <= 4) {
                            editable.insert(editable.length() - 1, String.valueOf(space));
                        }
                        PWEDebitCreditFragment.this.setCardTypeImage(string);
                        if (PWEDebitCreditFragment.this.paymentInfoHandler.getIsDiscountCouponApplied()) {
                            PWEDebitCreditFragment.this.couponsActivity.resetDiscountCode();
                            return;
                        }
                        return;
                    }
                    PWEDebitCreditFragment.this.generalHelper.setImageToImageView("", PWEDebitCreditFragment.this.ivCardType, PWEStaticDataModel.PWEDefaultCardTypeIcon);
                } catch (Error unused) {
                    PWEDebitCreditFragment.this.generalHelper.setImageToImageView("", PWEDebitCreditFragment.this.ivCardType, PWEStaticDataModel.PWEDefaultCardTypeIcon);
                } catch (Exception unused2) {
                    PWEDebitCreditFragment.this.generalHelper.setImageToImageView("", PWEDebitCreditFragment.this.ivCardType, PWEStaticDataModel.PWEDefaultCardTypeIcon);
                }
            }
        });
    }

    public void setCardTypeImage(String str) {
        String strReplaceAll = str.replaceAll("-", "");
        try {
            for (CardValidationModel cardValidationModel : this.listCardExpression) {
                if (strReplaceAll.matches(cardValidationModel.getCard_reg_exp())) {
                    this.generalHelper.setImageToImageView(PWEStaticDataModel.REST_BASE_URL + cardValidationModel.getCard_type_image(), this.ivCardType, PWEStaticDataModel.PWEDefaultCardTypeIcon);
                    if (cardValidationModel.getCard_type() != null) {
                        this.selected_card_type = cardValidationModel.getCard_type();
                        return;
                    }
                    return;
                }
            }
        } catch (Error | Exception unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.open_payment_option = true;
        this.paymentInfoHandler.setIsCancelTransactionFragmentOpen(false);
        setCardTypeImage(this.editCardNumber.getText().toString());
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
