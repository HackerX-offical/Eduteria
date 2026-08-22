package com.easebuzz.payment.kit;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.crashlytics.internal.common.IdManager;
import kotlinx.coroutines.DebugKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes7.dex */
public class PWEPaymentInfoHandler {
    private static final String APPLIED_DISCOUNT_COUPON_CODE = "pwe_applied_coupon_code";
    private static final String APPLIED_DISCOUNT_TYPE = "pwe_applied_discount_type";
    private static final String CANCEL_REASONS = "pwe_cancel_reasons";
    private static final String CASH_BACK_PERCENTAGE = "pwe_cashback_percentage";
    private static final String CUSTOMER_SURCHARGE = "pwe_customer_surcharge";
    private static final String DIRECT_DEBIT_NOTE = "pwe_is_direct_debit_name";
    private static final String DISCOUNTED_PAYMENT_AMOUNT_DETAILS = "pwe_discounted_payment_amount_details";
    private static final String DISCOUNT_CODE_LIST_DETAILS = "pwe_discount_code_list_details";
    private static final String IS_CUSTOMER_SURCHARGE = "pwe_is_customer_surcharge";
    private static final String IS_C_REASON_EABLED = "pwe_is_c_reason_enabled";
    private static final String IS_DISCOUNT_COUPON_APPLIED = "pwe_is_discount_coupon_applied";
    private static final String IS_DISCOUNT_COUPON_ENABLED = "pwe_is_discount_coupoon_enabled";
    private static final String IS_ENABLE_DIRECT_DEBIT = "pwe_is_direct_debit_enabled";
    private static final String IS_ENABLE_GOOGLE_PAY = "pwe_is_google_pay_enabled";
    private static final String IS_ENABLE_SAVE_CARD = "pwe_is_save_card_enable";
    private static final String IS_ENACH_PAPER_BASE_EABLED = "pwe_enach_paper_base_enabled";
    private static final String IS_MINIMIZE = "pwe_is_app_minimize";
    private static final String IS_TXN_SESSION_EXPIRE = "pwe_is_txn_session_expire";
    private static final String IS_TXN_TIMER_STOPPED = "pwe_is_txn_timer_stopped";
    private static final String MERCHANT_ACCESS_KEY = "pwe_merchant_access_key";
    private static final String MERCHANT_NAME = "pwe_merchant_name";
    private static final String MERCHANT_TXN_ID = "pwe_merchant_txn_id";
    private static final String PAYMENT_MODE = "pwe_payment_mode";
    private static final String PAY_AMOUNT_STR = "pwe_payment_amount_str";
    private static final String PREF_NAME = "pwe_merchant_payment_info";
    private static final String PWE_AUTODEBITUPI_NOTE = "pwe_autodebit_upi_note_message";
    private static final String PWE_AUTO_OTP_CLASS_NAME = "pwe_auto_otp_class_name";
    private static final String PWE_AUTO_OTP_EXTRA_DATA = "pwe_auto_otp_extra_data";
    private static final String PWE_AUTO_OTP_J_URL = "pwe_auto_otp_j_url";
    private static final String PWE_AUTO_OTP_PKG_NAME = "pwe_auto_otp_pkg_name";
    private static final String PWE_AUTO_OTP_REG_EX = "pwe_auto_otp_reg_ex";
    private static final String PWE_BANK_CODES = "pwe_bank_codes";
    private static final String PWE_CARD_TYPES_ARRAY = "pwe_card_types_array";
    private static final String PWE_CASHBACK_COUPONS_DATA = "pwe_cashback_coupons_data";
    private static final String PWE_CD_NOTE_MESSAGE = "pwe_cc_note_message";
    private static final String PWE_CUSTOMER_PHONE = "pwe_customer_phone";
    private static final String PWE_DC_NOTE_MESSAGE = "pwe_dc_note_message";
    private static final String PWE_DEFAULT_SELETED_SAVED_CARD_FLAG = "pwe_default_selected_saved_card_flag";
    private static final String PWE_DEVICE_TYPE = "pwe_device_type";
    private static final String PWE_DISCOUNT_VISIBILITY_FLAG = "pwe_discount_visibility_flag";
    private static final String PWE_EMI_BANKS_AND_PLANS_DATA = "pwe_emi_plans_banks_data";
    private static final String PWE_EMI_NOTE_MESSAGE = "pwe_emi_note_message";
    private static final String PWE_ENABLED_PAYMENT_OPTIONS_LIST = "pwe_enable_payment_option_list";
    private static final String PWE_ENACH_ACCOUNT_HOLDER_NAME = "pwe_enach_account_holder_name";
    private static final String PWE_ENACH_ACCOUNT_NUMNER = "pwe_enach_account_number";
    private static final String PWE_ENACH_ACCOUNT_TYPE = "pwe_enach_account_type";
    private static final String PWE_ENACH_AUTH_MODE = "pwe_enach_auth_mode";
    private static final String PWE_ENACH_BANK_CODE = "pwe_enach_bank_code";
    private static final String PWE_ENACH_BANK_NAME = "pwe_enach_bank_name";
    private static final String PWE_ENACH_COLLECTION_DATE = "pwe_enach_collection_date";
    private static final String PWE_ENACH_IFSC = "pwe_enach_ifsc_code";
    private static final String PWE_ENACH_NOTE_MESSAGE = "pwe_enach_note_message";
    private static final String PWE_ENACH_NOT_SUPPORTANLE_ANDROID_VERSION = "pwe_enach_not_supportable_android_version";
    private static final String PWE_GPAY_ELIGIBILITY_CHECK_FLAG = "pwe_gpay_eligibility_check_flag";
    private static final String PWE_IMPS_NOTE_MESSAGE = "pwe_insta_note_message";
    private static final String PWE_IS_CANCEL_TRANSACTION_FRGMENT_OPEN = "pwe_is_cancel_transaction_fragment_is_open";
    private static final String PWE_IS_CASHBACK_ENABLED = "pwe_is_cashback_enabled";
    private static final String PWE_MAIN_SAVED_STATE = "pwe_main_saved_state";
    private static final String PWE_MERCHANT_LOGO_URL = "pwe_merchant_logo_url";
    private static final String PWE_MERCHANT_PKG_NAME = "pwe_merchant_pkg_name";
    private static final String PWE_NETBANK_NOTE_MESSAGE = "pwe_netbank_note_message";
    private static final String PWE_OLA_NOTE_MESSAGE = "pwe_ola_note_message";
    private static final String PWE_PAYMENT_OPTION_MSGS = "pwe_payment_option_msgs";
    private static final String PWE_SELECTED_BANK_CODE = "pwe_selected_bankCode";
    private static final String PWE_SELECTED_BANK_NAME = "pwe_selected_bank_name";
    private static final String PWE_SELECTED_CARD_ID = "pwe_selected_saved_card_id";
    private static final String PWE_SELECTED_CARD_NUM = "pwe_selected_card_num";
    private static final String PWE_SELECTED_CARD_TYPE = "pwe_selected_cardType";
    private static final String PWE_SELECTED_CASHBACK_COUPONS_COUNT = "pwe_selected_cashback_couopons_count";
    private static final String PWE_SELECTED_CASHBACK_WORTH = "pwe_selected_cashback_worth";
    private static final String PWE_SELECTED_COUPON_ID_LIST = "pwe_selected_coupon_id_list";
    private static final String PWE_SELECTED_CVV_STRING = "pwe_selected_cvv_string";
    private static final String PWE_SELECTED_EMI_BANK = "pwe_selected_emi_bank";
    private static final String PWE_SELECTED_EMI_BANK_CODE = "pwe_selected_emi_bankCode";
    private static final String PWE_SELECTED_EMI_DICT = "pwe_selected_emi_dict";
    private static final String PWE_SELECTED_EMI_ID = "pwe_selected_emi_id";
    private static final String PWE_SELECTED_EMI_PLAN_DESC = "pwe_selected_emi_plan_desc";
    private static final String PWE_SELECTED_EXP_DATE = "pwe_selected_exp_date";
    private static final String PWE_SELECTED_IS_CVV = "pwe_is_cvv_selected";
    private static final String PWE_SELECTED_NAME_ON_CARD = "pwe_selected_name_on_card";
    private static final String PWE_SELECTED_OTHER_BANK_NAME = "pwe_selected_otherbankname";
    private static final String PWE_SELECTED_PAYMENT_OPTION = "pwe_selected_payment_option";
    private static final String PWE_SELECTED_SAVED_CARD_CVV = "pwe_selected_saved_card_cvv";
    private static final String PWE_SELECTED_SAVED_CARD_FLAG = "pwe_saved_card_flag";
    private static final String PWE_SHOW_MESSAGE_FLAG = "pwe_show_message_on_card_page_flag";
    private static final String PWE_SIMPL_ELIGIBLE_DATA = "pwe_simple_eligible_data";
    private static final String PWE_SIMPL_NOTE_MESSAGE = "pwe_simpl_note_message";
    private static final String PWE_SIMPL_PAY_LATER_APP = "pwe_simple_pay_later_app";
    private static final String PWE_TRXN_LAST_STATUS = "pwe_transaction_last_status";
    private static final String PWE_UPI_ADDRESS_VISIBILITY_FLAG = "pwe_upi_address_Visibility_flag";
    private static final String PWE_UPI_LIST = "pwe_upi_list";
    private static final String PWE_UPI_NOTE_MESSAGE = "pwe_upi_note_message";
    private static final String PWE_UPI_QR_VISIBILITY_FLAG = "pwe_upi_qr_Visibility_flag";
    private static final String PWE_UPI_SAVED_STATE = "pwe_upi_saved_state";
    private static final String PWE_WALLET_NOTE_MESSAGE = "pwe_wallet_note_message";
    private static final String SAVED_CARDS = "pwe_saved_cards";
    private static final String TXN_CURRENT_TIME = "pwe_txn_current_time";
    private static final String TXN_INITIATE_TIME = "pwe_txn_initiate_time";
    private int PRIVATE_MODE = 0;
    private Context _context;
    private SharedPreferences.Editor editor;
    private SharedPreferences pref;

    protected PWEPaymentInfoHandler(Context context) {
        this._context = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        this.pref = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    protected String getCustomerPhone() {
        return this.pref.getString(PWE_CUSTOMER_PHONE, "");
    }

    protected void setCustomerPhone(String str) {
        this.editor.putString(PWE_CUSTOMER_PHONE, str);
        this.editor.commit();
    }

    protected void setPayUpiAddressVisibilityFlag(boolean z) {
        this.editor.putBoolean(PWE_UPI_ADDRESS_VISIBILITY_FLAG, z);
        this.editor.commit();
    }

    protected boolean getPayUpiAddressVisibilityFlag() {
        return this.pref.getBoolean(PWE_UPI_ADDRESS_VISIBILITY_FLAG, false);
    }

    protected void setPayUpiQrVisibilityFlag(boolean z) {
        this.editor.putBoolean(PWE_UPI_QR_VISIBILITY_FLAG, z);
        this.editor.commit();
    }

    protected boolean getPayUpiQrVisibilityFlag() {
        return this.pref.getBoolean(PWE_UPI_QR_VISIBILITY_FLAG, false);
    }

    public String getPWEDeviceType() {
        return this.pref.getString(PWE_DEVICE_TYPE, "NORMAL");
    }

    protected void setPWEDeviceType(String str) {
        this.editor.putString(PWE_DEVICE_TYPE, str);
        this.editor.commit();
    }

    public String getPWEMerchantPkg() {
        return this.pref.getString(PWE_MERCHANT_PKG_NAME, "NA");
    }

    protected void setPWEMerchantPkg(String str) {
        this.editor.putString(PWE_MERCHANT_PKG_NAME, str);
        this.editor.commit();
    }

    protected String getPWESimplEligibleData() {
        return this.pref.getString(PWE_SIMPL_ELIGIBLE_DATA, "");
    }

    protected void setPWESimplEligibleData(String str) {
        this.editor.putString(PWE_SIMPL_ELIGIBLE_DATA, str);
        this.editor.commit();
    }

    protected String getPWESimplPayLaterAppName() {
        return this.pref.getString(PWE_SIMPL_PAY_LATER_APP, "");
    }

    protected void setPWESimplPayLaterAppName(String str) {
        this.editor.putString(PWE_SIMPL_PAY_LATER_APP, str);
        this.editor.commit();
    }

    protected String getPWEEnachAccountType() {
        return this.pref.getString(PWE_ENACH_ACCOUNT_TYPE, "");
    }

    protected void setPWEEnachAccountType(String str) {
        this.editor.putString(PWE_ENACH_ACCOUNT_TYPE, str);
        this.editor.commit();
    }

    protected String getPWEEnachAccountHolderName() {
        return this.pref.getString(PWE_ENACH_ACCOUNT_HOLDER_NAME, "");
    }

    protected void setPWEEnachAccountHolderName(String str) {
        this.editor.putString(PWE_ENACH_ACCOUNT_HOLDER_NAME, str);
        this.editor.commit();
    }

    protected String getPWEEnachAccountNumber() {
        return this.pref.getString(PWE_ENACH_ACCOUNT_NUMNER, "");
    }

    protected void setPWEEnachAccountNumber(String str) {
        this.editor.putString(PWE_ENACH_ACCOUNT_NUMNER, str);
        this.editor.commit();
    }

    protected String getPWEEnachAuthMode() {
        return this.pref.getString(PWE_ENACH_AUTH_MODE, "");
    }

    protected void setPWEEnachAuthMode(String str) {
        this.editor.putString(PWE_ENACH_AUTH_MODE, str);
        this.editor.commit();
    }

    protected String getPWEEnachBankName() {
        return this.pref.getString(PWE_ENACH_BANK_NAME, "");
    }

    protected void setPWEEnachBankName(String str) {
        this.editor.putString(PWE_ENACH_BANK_NAME, str);
        this.editor.commit();
    }

    protected String getPWEEnachBankCode() {
        return this.pref.getString(PWE_ENACH_BANK_CODE, "");
    }

    protected void setPWEEnachBankCode(String str) {
        this.editor.putString(PWE_ENACH_BANK_CODE, str);
        this.editor.commit();
    }

    protected String getPWEEnachIFSCCode() {
        return this.pref.getString(PWE_ENACH_IFSC, "");
    }

    protected void setPWEEnachIFSCCode(String str) {
        this.editor.putString(PWE_ENACH_IFSC, str);
        this.editor.commit();
    }

    protected String getPWEEmiBanksPlansData() {
        return this.pref.getString(PWE_EMI_BANKS_AND_PLANS_DATA, "");
    }

    protected void setPWEEmiBanksPlansData(String str) {
        this.editor.putString(PWE_EMI_BANKS_AND_PLANS_DATA, str);
        this.editor.commit();
    }

    protected String getPWEMerchantLogoURL() {
        return this.pref.getString(PWE_MERCHANT_LOGO_URL, "");
    }

    protected void setPWEMerchantLogoURL(String str) {
        this.editor.putString(PWE_MERCHANT_LOGO_URL, str);
        this.editor.commit();
    }

    protected void setDefaultCardSelectionFlag(boolean z) {
        this.editor.putBoolean(PWE_DEFAULT_SELETED_SAVED_CARD_FLAG, z);
        this.editor.commit();
    }

    protected boolean getDefaultCardSelectionFlag() {
        return this.pref.getBoolean(PWE_DEFAULT_SELETED_SAVED_CARD_FLAG, false);
    }

    protected void setDiscountVisibilityFlag(boolean z) {
        this.editor.putBoolean(PWE_DISCOUNT_VISIBILITY_FLAG, z);
        this.editor.commit();
    }

    protected boolean getDiscountVisibilityFlag() {
        return this.pref.getBoolean(PWE_DISCOUNT_VISIBILITY_FLAG, false);
    }

    protected void setGpayEligibilityCheckFlag(boolean z) {
        this.editor.putBoolean(PWE_GPAY_ELIGIBILITY_CHECK_FLAG, z);
        this.editor.commit();
    }

    protected boolean getGpayEligibilityCheckFlag() {
        return this.pref.getBoolean(PWE_GPAY_ELIGIBILITY_CHECK_FLAG, false);
    }

    protected void setSelectedCashbackCouponCount(int i) {
        this.editor.putInt(PWE_SELECTED_CASHBACK_COUPONS_COUNT, i);
        this.editor.commit();
    }

    protected int getSelectedCashbackCouponCount() {
        return this.pref.getInt(PWE_SELECTED_CASHBACK_COUPONS_COUNT, 0);
    }

    protected void setSelectedCashbackWorth(String str) {
        this.editor.putString(PWE_SELECTED_CASHBACK_WORTH, str);
        this.editor.commit();
    }

    protected String getSelectedCashbackWorth() {
        return this.pref.getString(PWE_SELECTED_CASHBACK_WORTH, IdManager.DEFAULT_VERSION_NAME);
    }

    protected void setShowMessageFlag(boolean z) {
        this.editor.putBoolean(PWE_SHOW_MESSAGE_FLAG, z);
        this.editor.commit();
    }

    protected boolean getShowMessageFlag() {
        return this.pref.getBoolean(PWE_SHOW_MESSAGE_FLAG, false);
    }

    protected void setSelectedSavedCardCvv(String str) {
        this.editor.putString(PWE_SELECTED_SAVED_CARD_CVV, str);
        this.editor.commit();
    }

    protected String getSelectedSavedCardCvv() {
        return this.pref.getString(PWE_SELECTED_SAVED_CARD_CVV, "");
    }

    protected void setSelectedBankCode(String str) {
        this.editor.putString(PWE_SELECTED_BANK_CODE, str);
        this.editor.commit();
    }

    protected String getSelectedbankCode() {
        return this.pref.getString(PWE_SELECTED_BANK_CODE, "");
    }

    protected void setSelectedEMIPlanDesc(String str) {
        this.editor.putString(PWE_SELECTED_EMI_PLAN_DESC, str);
        this.editor.commit();
    }

    protected String getSelectedEMIPlanDesc() {
        return this.pref.getString(PWE_SELECTED_EMI_PLAN_DESC, "");
    }

    protected void setSelectedEMIBankCode(String str) {
        this.editor.putString(PWE_SELECTED_EMI_BANK_CODE, str);
        this.editor.commit();
    }

    protected String getSelectedEMIbankCode() {
        return this.pref.getString(PWE_SELECTED_EMI_BANK_CODE, "");
    }

    protected void setSelectedEMIDict(String str) {
        this.editor.putString(PWE_SELECTED_EMI_DICT, str);
        this.editor.commit();
    }

    protected String getSelectedEMIDict() {
        return this.pref.getString(PWE_SELECTED_EMI_DICT, "");
    }

    protected void setSelectedCVVString(String str) {
        this.editor.putString(PWE_SELECTED_CVV_STRING, str);
        this.editor.commit();
    }

    protected String getSelectedCVVString() {
        return this.pref.getString(PWE_SELECTED_CVV_STRING, "");
    }

    protected void setSelectedOtherBankName(String str) {
        this.editor.putString(PWE_SELECTED_OTHER_BANK_NAME, str);
        this.editor.commit();
    }

    protected String getSelectedOtherBankName() {
        return this.pref.getString(PWE_SELECTED_OTHER_BANK_NAME, "");
    }

    protected void setSelectedEMIBank(String str) {
        this.editor.putString(PWE_SELECTED_EMI_BANK, str);
        this.editor.commit();
    }

    protected String getSelectedEMIBank() {
        return this.pref.getString(PWE_SELECTED_EMI_BANK, "");
    }

    protected void setSelectedCardID(String str) {
        this.editor.putString(PWE_SELECTED_CARD_ID, str);
        this.editor.commit();
    }

    protected String getSelectedCardID() {
        return this.pref.getString(PWE_SELECTED_CARD_ID, "");
    }

    protected void setSelectedSavedCardFlag(String str) {
        this.editor.putString(PWE_SELECTED_SAVED_CARD_FLAG, str);
        this.editor.commit();
    }

    protected String getSelectedSavedCardFlag() {
        return this.pref.getString(PWE_SELECTED_SAVED_CARD_FLAG, "");
    }

    protected void setNoCVVFlag(String str) {
        this.editor.putString(PWE_SELECTED_IS_CVV, str);
        this.editor.commit();
    }

    protected String getNoCVVFlag() {
        return this.pref.getString(PWE_SELECTED_IS_CVV, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
    }

    protected void setSelectedExpDate(String str) {
        this.editor.putString(PWE_SELECTED_EXP_DATE, str);
        this.editor.commit();
    }

    protected String getSelectedExpDate() {
        return this.pref.getString(PWE_SELECTED_EXP_DATE, "");
    }

    protected void setSelectedCardType(String str) {
        this.editor.putString(PWE_SELECTED_CARD_TYPE, str);
        this.editor.commit();
    }

    protected String getSelectedCardType() {
        return this.pref.getString(PWE_SELECTED_CARD_TYPE, "");
    }

    protected void setSelectedNameOnCard(String str) {
        this.editor.putString(PWE_SELECTED_NAME_ON_CARD, str);
        this.editor.commit();
    }

    protected String getSelectedNameOnCard() {
        return this.pref.getString(PWE_SELECTED_NAME_ON_CARD, "");
    }

    protected void setSelectedCardNumber(String str) {
        this.editor.putString(PWE_SELECTED_CARD_NUM, str);
        this.editor.commit();
    }

    protected String getSelectedCardNumber() {
        return this.pref.getString(PWE_SELECTED_CARD_NUM, "");
    }

    protected void setSelectedBankName(String str) {
        this.editor.putString(PWE_SELECTED_BANK_NAME, str);
        this.editor.commit();
    }

    protected String getSelectedBankName() {
        return this.pref.getString(PWE_SELECTED_BANK_NAME, "");
    }

    protected void setSelectedPaymentOption(String str) {
        this.editor.putString(PWE_SELECTED_PAYMENT_OPTION, str);
        this.editor.commit();
    }

    protected String getSelectedPaymentOption() {
        return this.pref.getString(PWE_SELECTED_PAYMENT_OPTION, "");
    }

    protected void setSelectedCouponIdList(String str) {
        this.editor.putString(PWE_SELECTED_COUPON_ID_LIST, str);
        this.editor.commit();
    }

    protected String getSelectedCouponIdList() {
        return this.pref.getString(PWE_SELECTED_COUPON_ID_LIST, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }

    protected void setEnabledPaymentOptionList(String str) {
        this.editor.putString(PWE_ENABLED_PAYMENT_OPTIONS_LIST, str);
        this.editor.commit();
    }

    protected String getEnabledPaymentOptionList() {
        return this.pref.getString(PWE_ENABLED_PAYMENT_OPTIONS_LIST, "");
    }

    public void setIsCashbackCouponEnabled(int i) {
        this.editor.putInt(PWE_IS_CASHBACK_ENABLED, i);
        this.editor.commit();
    }

    protected int getIsCashbackCouponEnabled() {
        return this.pref.getInt(PWE_IS_CASHBACK_ENABLED, 0);
    }

    protected void setCashbackCouponsData(String str) {
        this.editor.putString(PWE_CASHBACK_COUPONS_DATA, str);
        this.editor.commit();
    }

    protected String getCashbackCouponsData() {
        return this.pref.getString(PWE_CASHBACK_COUPONS_DATA, "");
    }

    protected void setUpiListString(String str) {
        this.editor.putString(PWE_UPI_LIST, str);
        this.editor.commit();
    }

    protected String getUpiListString() {
        return this.pref.getString(PWE_UPI_LIST, "");
    }

    protected void setCardTypsExpJson(String str) {
        this.editor.putString(PWE_CARD_TYPES_ARRAY, str);
        this.editor.commit();
    }

    protected String getCardTypsExpJson() {
        return this.pref.getString(PWE_CARD_TYPES_ARRAY, "");
    }

    protected void setBankCodeString(String str) {
        this.editor.putString(PWE_BANK_CODES, str);
        this.editor.commit();
    }

    protected String getBankCodeString() {
        return this.pref.getString(PWE_BANK_CODES, "");
    }

    protected String getMerchantAccessKey() {
        return this.pref.getString(MERCHANT_ACCESS_KEY, "");
    }

    protected void setMerchantAccessKey(String str) {
        this.editor.putString(MERCHANT_ACCESS_KEY, str);
        this.editor.commit();
    }

    protected void setIsDirectDebitEnabled(int i) {
        this.editor.putInt(IS_ENABLE_DIRECT_DEBIT, i);
        this.editor.commit();
    }

    protected int getIsDirectDebitEnabled() {
        return this.pref.getInt(IS_ENABLE_DIRECT_DEBIT, 0);
    }

    protected String getDirectDebitNote() {
        return this.pref.getString(DIRECT_DEBIT_NOTE, "");
    }

    protected void setDirectDebitNote(String str) {
        this.editor.putString(DIRECT_DEBIT_NOTE, str);
        this.editor.commit();
    }

    protected void setIsCustomerSurcharge(int i) {
        this.editor.putInt(IS_CUSTOMER_SURCHARGE, i);
        this.editor.commit();
    }

    protected int getIsCustomerSurcharge() {
        return this.pref.getInt(IS_CUSTOMER_SURCHARGE, 0);
    }

    protected void setIsDiscountCouponEnabled(boolean z) {
        this.editor.putBoolean(IS_DISCOUNT_COUPON_ENABLED, z);
        this.editor.commit();
    }

    protected boolean getIsDiscountCouponEnabled() {
        return this.pref.getBoolean(IS_DISCOUNT_COUPON_ENABLED, false);
    }

    protected void setIsDiscountCouponApplied(boolean z) {
        this.editor.putBoolean(IS_DISCOUNT_COUPON_APPLIED, z);
        this.editor.commit();
    }

    protected boolean getIsDiscountCouponApplied() {
        return this.pref.getBoolean(IS_DISCOUNT_COUPON_APPLIED, false);
    }

    protected void setCustomerSurchargeDetails(String str) {
        this.editor.putString(CUSTOMER_SURCHARGE, str);
        this.editor.commit();
    }

    protected String getCustomerSurchargeDetails() {
        return this.pref.getString(CUSTOMER_SURCHARGE, "");
    }

    protected void setDiscountedCouponDetails(String str) {
        this.editor.putString(DISCOUNTED_PAYMENT_AMOUNT_DETAILS, str);
        this.editor.commit();
    }

    protected String getDiscountedCouponDetails() {
        return this.pref.getString(DISCOUNTED_PAYMENT_AMOUNT_DETAILS, "");
    }

    protected void setDiscountCodeListDetails(String str) {
        this.editor.putString(DISCOUNT_CODE_LIST_DETAILS, str);
        this.editor.commit();
    }

    protected String getDiscountCodeListDetails() {
        return this.pref.getString(DISCOUNT_CODE_LIST_DETAILS, "");
    }

    protected void setAppliedDiscountCouponCode(String str) {
        this.editor.putString(APPLIED_DISCOUNT_COUPON_CODE, str);
        this.editor.commit();
    }

    protected String getAppliedDiscountCouponCode() {
        return this.pref.getString(APPLIED_DISCOUNT_COUPON_CODE, "");
    }

    protected void setAppliedDiscountType(String str) {
        this.editor.putString(APPLIED_DISCOUNT_TYPE, str);
        this.editor.commit();
    }

    protected String getAppliedDiscountType() {
        return this.pref.getString(APPLIED_DISCOUNT_TYPE, "");
    }

    protected void setMerchantName(String str) {
        this.editor.putString(MERCHANT_NAME, str);
        this.editor.commit();
    }

    protected String getMerchantName() {
        return this.pref.getString(MERCHANT_NAME, "");
    }

    protected void setTxnInitiateTime(String str) {
        this.editor.putString(TXN_INITIATE_TIME, str);
        this.editor.commit();
    }

    protected String getPaymentMode() {
        return this.pref.getString(PAYMENT_MODE, "production");
    }

    protected void setPaymentMode(String str) {
        this.editor.putString(PAYMENT_MODE, str);
        this.editor.commit();
    }

    protected String getSavedCards() {
        return this.pref.getString(SAVED_CARDS, "");
    }

    protected void setSavedCards(String str) {
        this.editor.putString(SAVED_CARDS, str);
        this.editor.commit();
    }

    protected void setTxnCurrentTime(String str) {
        this.editor.putString(TXN_CURRENT_TIME, str);
        this.editor.commit();
    }

    protected void setCancelResons(String str) {
        this.editor.putString(CANCEL_REASONS, str);
        this.editor.commit();
    }

    protected void setIsCReasonEabled(int i) {
        this.editor.putInt(IS_C_REASON_EABLED, i);
        this.editor.commit();
    }

    protected int getIsCReasonEabled() {
        return this.pref.getInt(IS_C_REASON_EABLED, 0);
    }

    protected String getCancelReasons() {
        return this.pref.getString(CANCEL_REASONS, "");
    }

    protected int getIsSavedCard() {
        return this.pref.getInt(IS_ENABLE_SAVE_CARD, 0);
    }

    protected void setIsSavedCard(int i) {
        this.editor.putInt(IS_ENABLE_SAVE_CARD, i);
        this.editor.commit();
    }

    protected int getCashbackPercentage() {
        return this.pref.getInt(CASH_BACK_PERCENTAGE, 0);
    }

    protected void setCashBackPercentage(int i) {
        this.editor.putInt(CASH_BACK_PERCENTAGE, i);
        this.editor.commit();
    }

    protected String getMerchantTxnId() {
        return this.pref.getString(MERCHANT_TXN_ID, "");
    }

    protected void setMerchantTxnId(String str) {
        this.editor.putString(MERCHANT_TXN_ID, str);
        this.editor.commit();
    }

    protected void setPayAmountStr(String str) {
        this.editor.putString(PAY_AMOUNT_STR, str);
        this.editor.commit();
    }

    protected String getPayAmountStr() {
        return this.pref.getString(PAY_AMOUNT_STR, IdManager.DEFAULT_VERSION_NAME);
    }

    protected void setIsEnableGpay(int i) {
        this.editor.putInt(IS_ENABLE_GOOGLE_PAY, i);
        this.editor.commit();
    }

    protected int getIsEnableGpay() {
        return this.pref.getInt(IS_ENABLE_GOOGLE_PAY, 0);
    }

    protected void saveMessage(String str) {
        this.editor.putString(PWE_PAYMENT_OPTION_MSGS, str);
        this.editor.commit();
    }

    protected String getCardViewMsg() {
        return this.pref.getString(PWE_PAYMENT_OPTION_MSGS, "");
    }

    protected void setPweUpiSaveState(String str) {
        this.editor.putString(PWE_UPI_SAVED_STATE, str);
        this.editor.commit();
    }

    protected String getPweUpiSaveState() {
        return this.pref.getString(PWE_UPI_SAVED_STATE, "{}");
    }

    protected void setPweMainState(String str) {
        this.editor.putString(PWE_MAIN_SAVED_STATE, str);
        this.editor.commit();
    }

    protected String getPweMainState() {
        return this.pref.getString(PWE_MAIN_SAVED_STATE, "{}");
    }

    protected void setPweLastTransactionStatus(String str) {
        this.editor.putString(PWE_TRXN_LAST_STATUS, str);
        this.editor.commit();
    }

    protected String getPweLastTransactionStatus() {
        return this.pref.getString(PWE_TRXN_LAST_STATUS, "");
    }

    protected void setIsMinimize(boolean z) {
        this.editor.putBoolean(IS_MINIMIZE, z);
        this.editor.commit();
    }

    protected void setIsTxnSessionExpire(boolean z) {
        this.editor.putBoolean(IS_TXN_SESSION_EXPIRE, z);
        this.editor.commit();
    }

    protected void setIsTxnTimerStopped(boolean z) {
        this.editor.putBoolean(IS_TXN_TIMER_STOPPED, z);
        this.editor.commit();
    }

    protected boolean IsTxnTimerStopped() {
        return this.pref.getBoolean(IS_TXN_TIMER_STOPPED, false);
    }

    protected boolean IsMinimize() {
        return this.pref.getBoolean(IS_MINIMIZE, false);
    }

    protected boolean IsTxnSessionExpire() {
        return this.pref.getBoolean(IS_TXN_SESSION_EXPIRE, false);
    }

    protected void setEnachNotSupportableAndroidOsVersion(int i) {
        this.editor.putInt(PWE_ENACH_NOT_SUPPORTANLE_ANDROID_VERSION, i);
        this.editor.commit();
    }

    protected int getEnachNotSupportableAndroidOsVersion() {
        return this.pref.getInt(PWE_ENACH_NOT_SUPPORTANLE_ANDROID_VERSION, 0);
    }

    protected void setIsCancelTransactionFragmentOpen(boolean z) {
        this.editor.putBoolean(PWE_IS_CANCEL_TRANSACTION_FRGMENT_OPEN, z);
        this.editor.commit();
    }

    protected boolean IsCancelTransactionFragmentOpen() {
        return this.pref.getBoolean(PWE_IS_CANCEL_TRANSACTION_FRGMENT_OPEN, false);
    }

    public String getAutoOtpJURL() {
        return this.pref.getString(PWE_AUTO_OTP_J_URL, "");
    }

    public String getAutoOtpRegEx() {
        return this.pref.getString(PWE_AUTO_OTP_REG_EX, "");
    }

    public String getAutoOtpExtraData() {
        return this.pref.getString(PWE_AUTO_OTP_EXTRA_DATA, "");
    }

    public void setAutoOtpJURL(String str) {
        this.editor.putString(PWE_AUTO_OTP_J_URL, str);
        this.editor.commit();
    }

    public void setAutoOtpRegEx(String str) {
        this.editor.putString(PWE_AUTO_OTP_REG_EX, str);
        this.editor.commit();
    }

    public void setAutoOtpExtraData(String str) {
        this.editor.putString(PWE_AUTO_OTP_EXTRA_DATA, str);
        this.editor.commit();
    }

    public String getPWEAutoOtpSafePkg() {
        return this.pref.getString(PWE_AUTO_OTP_PKG_NAME, "NA");
    }

    protected void setPWEAutoOtpSafePkg(String str) {
        this.editor.putString(PWE_AUTO_OTP_PKG_NAME, str);
        this.editor.commit();
    }

    public String getPWEAutoOtpSafeClass() {
        return this.pref.getString(PWE_AUTO_OTP_CLASS_NAME, "NA");
    }

    protected void setPWEAutoOtpSafeClass(String str) {
        this.editor.putString(PWE_AUTO_OTP_CLASS_NAME, str);
        this.editor.commit();
    }

    protected void setIsPaperBaseEnabled(int i) {
        this.editor.putInt(IS_ENACH_PAPER_BASE_EABLED, i);
        this.editor.commit();
    }

    protected int getIsPaperBaseEnabled() {
        return this.pref.getInt(IS_ENACH_PAPER_BASE_EABLED, 0);
    }

    protected void setDebitCardNoteMessage(String str) {
        this.editor.putString(PWE_DC_NOTE_MESSAGE, str);
        this.editor.commit();
    }

    protected String getDebitCardNoteMessage() {
        return this.pref.getString(PWE_DC_NOTE_MESSAGE, "");
    }

    protected void setCreditCardNoteMessage(String str) {
        this.editor.putString(PWE_CD_NOTE_MESSAGE, str);
        this.editor.commit();
    }

    protected String getCreditCardNoteMessage() {
        return this.pref.getString(PWE_CD_NOTE_MESSAGE, "");
    }

    protected void setNetBankingNoteMessage(String str) {
        this.editor.putString(PWE_NETBANK_NOTE_MESSAGE, str);
        this.editor.commit();
    }

    protected String getNetBankingNoteMessage() {
        return this.pref.getString(PWE_NETBANK_NOTE_MESSAGE, "");
    }

    protected void setUpiLimitNoteMessage(String str) {
        this.editor.putString(PWE_UPI_NOTE_MESSAGE, str);
        this.editor.commit();
    }

    protected String getUpiLimitNoteMessage() {
        return this.pref.getString(PWE_UPI_NOTE_MESSAGE, "");
    }

    protected void setEmiNoteMessage(String str) {
        this.editor.putString(PWE_EMI_NOTE_MESSAGE, str);
        this.editor.commit();
    }

    protected String getEmiNoteMessage() {
        return this.pref.getString(PWE_EMI_NOTE_MESSAGE, "");
    }

    protected void setWalletNoteMessage(String str) {
        this.editor.putString(PWE_WALLET_NOTE_MESSAGE, str);
        this.editor.commit();
    }

    protected String getWalletNoteMessage() {
        return this.pref.getString(PWE_WALLET_NOTE_MESSAGE, "");
    }

    protected void setOlaMoneyNoteMessage(String str) {
        this.editor.putString(PWE_OLA_NOTE_MESSAGE, str);
        this.editor.commit();
    }

    protected String getOlaMoneyNoteMessage() {
        return this.pref.getString(PWE_OLA_NOTE_MESSAGE, "");
    }

    protected void setPayLaterNoteMessage(String str) {
        this.editor.putString(PWE_SIMPL_NOTE_MESSAGE, str);
        this.editor.commit();
    }

    protected String getPayLaterNoteMessage() {
        return this.pref.getString(PWE_SIMPL_NOTE_MESSAGE, "");
    }

    protected void setInstacollectNoteMessage(String str) {
        this.editor.putString(PWE_IMPS_NOTE_MESSAGE, str);
        this.editor.commit();
    }

    protected String getInstacollectNoteMessage() {
        return this.pref.getString(PWE_IMPS_NOTE_MESSAGE, "");
    }

    protected void setAutodebitUpiNoteMessage(String str) {
        this.editor.putString(PWE_AUTODEBITUPI_NOTE, str);
        this.editor.commit();
    }

    protected String getAutodebitUpiNoteMessage() {
        return this.pref.getString(PWE_AUTODEBITUPI_NOTE, "");
    }

    protected void setEnachNoteMessage(String str) {
        this.editor.putString(PWE_ENACH_NOTE_MESSAGE, str);
        this.editor.commit();
    }

    protected String getEnachNoteMessage() {
        return this.pref.getString(PWE_ENACH_NOTE_MESSAGE, "");
    }
}
