package com.easebuzz.payment.kit;

import adapters.PWESavedCardAdapter;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import clientRequestsApi.RetroAPI;
import datamodels.CardDataModel;
import datamodels.DiscountCodeDataModel;
import datamodels.PWEStaticDataModel;
import helper.RsaHelper;
import helper.ToStringConverterFactory;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;
import listeners.ConnectionDetector;
import listeners.PWESavedCardListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes7.dex */
public class PWESavedCardFragment extends Fragment {
    private Button buttonPaySavedCard;
    private ArrayList<CardDataModel> cardDataList;
    private PWECouponsActivity couponsActivity;
    private PWEDiscountHelper discountCodeHelper;
    private PWEGeneralHelper generalHelper;
    private ConnectionDetector internetDetecter;
    private LinearLayout linearNoSavedCardsLayout;
    private LinearLayout linearRootSavedCardLayout;
    private ListView lvCards;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private RsaHelper rsaHelper;
    private PWESavedCardAdapter savedCardAdapter;
    private View savedCardView;
    private String selected_payment_option = "";
    private String saved_card = "";
    private String paymentoption = "";
    private String no_cvv_flag = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
    private boolean open_payment_option = true;
    private String cardId = "";
    private String cardType = "";
    private String cvv = "";
    private int selectedItemPosition = -1;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.savedCardView = layoutInflater.inflate(R.layout.fragment_pwe_saved_card, viewGroup, false);
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.internetDetecter = new ConnectionDetector(getActivity());
        this.rsaHelper = new RsaHelper();
        this.paymentInfoHandler.setDefaultCardSelectionFlag(false);
        this.open_payment_option = true;
        this.cardId = "";
        this.selected_payment_option = this.paymentInfoHandler.getSelectedPaymentOption();
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.discountCodeHelper = this.couponsActivity.getDiscountHelper();
        this.saved_card = this.paymentInfoHandler.getSavedCards();
        initViews();
        return this.savedCardView;
    }

    private void initViews() {
        this.cardDataList = new ArrayList<>();
        this.lvCards = (ListView) this.savedCardView.findViewById(R.id.list_cards);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.lvCards.setSelector(getResources().getDrawable(R.drawable.pwe_listview_item_selector));
        }
        this.linearRootSavedCardLayout = (LinearLayout) this.savedCardView.findViewById(R.id.root_linear_saved_card);
        this.linearNoSavedCardsLayout = (LinearLayout) this.savedCardView.findViewById(R.id.linear_no_saved_card_holder);
        this.buttonPaySavedCard = (Button) this.savedCardView.findViewById(R.id.button_proceed_for_payment);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonPaySavedCard.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.buttonPaySavedCard);
        }
        this.buttonPaySavedCard.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWESavedCardFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PWESavedCardFragment.this.internetDetecter.isConnectingToInternet()) {
                    JSONObject jSONObjectCheckIfCardSelected = PWESavedCardFragment.this.checkIfCardSelected();
                    if (jSONObjectCheckIfCardSelected.optBoolean("status", false)) {
                        String strEncodeToString = "";
                        PWESavedCardFragment.this.savedCardAdapter.showValidationError("", false);
                        try {
                            RsaHelper rsaHelper = PWESavedCardFragment.this.rsaHelper;
                            String str = PWESavedCardFragment.this.cvv;
                            RsaHelper unused = PWESavedCardFragment.this.rsaHelper;
                            strEncodeToString = Base64.encodeToString(rsaHelper.RSAEncrypt(str, RsaHelper.loadPublicKey(PWEStaticDataModel.public_key_for_rsa)), 2);
                        } catch (IOException | GeneralSecurityException | Exception unused2) {
                        }
                        String str2 = strEncodeToString;
                        if (PWESavedCardFragment.this.open_payment_option) {
                            PWESavedCardFragment.this.open_payment_option = false;
                            PWESavedCardFragment.this.couponsActivity.submitPayment("", "", "", "", "", "", PWESavedCardFragment.this.cardType, "", PWESavedCardFragment.this.no_cvv_flag, PWESavedCardFragment.this.cardId, str2, "", "", "", "", "", "", "", "", "", "", "");
                            return;
                        }
                        return;
                    }
                    PWESavedCardFragment.this.open_payment_option = true;
                    String strOptString = jSONObjectCheckIfCardSelected.optString("error", "Select saved card");
                    PWESavedCardFragment.this.savedCardAdapter.showValidationError(strOptString, true);
                    PWESavedCardFragment.this.generalHelper.showPweToast(strOptString);
                    return;
                }
                PWESavedCardFragment.this.open_payment_option = true;
                PWESavedCardFragment.this.generalHelper.showPweToast(PWEStaticDataModel.NO_INTERNET_CONNECTION_TEXT);
            }
        });
        showCards();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject checkIfCardSelected() {
        String str;
        String str2 = "Please select card to proceed";
        JSONObject jSONObject = new JSONObject();
        boolean z = false;
        try {
            String str3 = this.cardId;
            if (str3 != null && !str3.isEmpty() && !this.cardId.equals("")) {
                if (!this.no_cvv_flag.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF) || (!this.cvv.equals("") && !this.cvv.isEmpty() && this.cvv != null)) {
                    if (this.no_cvv_flag.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF) && !this.cvv.isEmpty()) {
                        if (this.cvv.length() < 3) {
                            str = "Invalid CVV number";
                        }
                    }
                    z = true;
                    str2 = "";
                } else {
                    str = "Enter CVV number";
                }
                str2 = str;
            }
        } catch (Error | Exception unused) {
        }
        try {
            jSONObject.put("status", z);
            jSONObject.put("error", str2);
        } catch (JSONException | Exception unused2) {
        }
        return jSONObject;
    }

    private void showCards() {
        this.cardDataList.clear();
        try {
            JSONArray jSONArray = new JSONArray(this.saved_card);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                this.cardDataList.add(new CardDataModel(jSONObject.getInt("saved_card_id"), jSONObject.getString("saved_card_number"), jSONObject.getString("card_type"), ""));
            }
        } catch (JSONException unused) {
        }
        initializeAdapter(this.cardDataList);
    }

    private void initializeAdapter(ArrayList<CardDataModel> arrayList) {
        this.cardDataList = arrayList;
        if (arrayList.size() > 0) {
            this.linearRootSavedCardLayout.setVisibility(0);
            this.linearNoSavedCardsLayout.setVisibility(8);
            PWESavedCardAdapter pWESavedCardAdapter = new PWESavedCardAdapter(getActivity(), this.cardDataList, this.paymentInfoHandler);
            this.savedCardAdapter = pWESavedCardAdapter;
            this.lvCards.setAdapter((ListAdapter) pWESavedCardAdapter);
            this.savedCardAdapter.setSavedCardListener(new PWESavedCardListener() { // from class: com.easebuzz.payment.kit.PWESavedCardFragment.2
                @Override // listeners.PWESavedCardListener
                public void selectCard(CardDataModel cardDataModel, int i) {
                    PWESavedCardFragment.this.setSelectedCardDetails(cardDataModel);
                    PWESavedCardFragment.this.selectedItemPosition = i;
                    if (!PWESavedCardFragment.this.paymentInfoHandler.getIsDiscountCouponApplied() || PWESavedCardFragment.this.paymentInfoHandler.getDefaultCardSelectionFlag()) {
                        return;
                    }
                    PWESavedCardFragment.this.couponsActivity.resetDiscountCode();
                }

                @Override // listeners.PWESavedCardListener
                public void deleteCard(CardDataModel cardDataModel, int i) {
                    PWESavedCardFragment.this.couponsActivity.showUserConfirmationDialog("Delete Card", "Do you really want to remove card?", "", 0, "DELETED_SAVE_CARD", Integer.toString(cardDataModel.card_id), i);
                    if (PWESavedCardFragment.this.cardDataList.size() > 0) {
                        PWESavedCardFragment.this.savedCardAdapter.setSelectedCardId(((CardDataModel) PWESavedCardFragment.this.cardDataList.get(0)).card_id);
                        PWESavedCardFragment.this.savedCardAdapter.notifyDataSetChanged();
                    }
                }

                @Override // listeners.PWESavedCardListener
                public void updateCVV(CardDataModel cardDataModel, int i) {
                    PWESavedCardFragment.this.setSelectedCardDetails(cardDataModel);
                }

                @Override // listeners.PWESavedCardListener
                public void updateDefaultCardSelectionFlag(boolean z) {
                    PWESavedCardFragment.this.paymentInfoHandler.setDefaultCardSelectionFlag(z);
                }

                @Override // listeners.PWESavedCardListener
                public boolean getDefaultCardSelectionFlag() {
                    return PWESavedCardFragment.this.paymentInfoHandler.getDefaultCardSelectionFlag();
                }
            });
            this.generalHelper.setListViewHeightBasedOnChildren(this.lvCards);
            this.lvCards.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.easebuzz.payment.kit.PWESavedCardFragment.3
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (PWESavedCardFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                        View viewFindViewById = view.findViewById(R.id.linear_main_layout);
                        PWESavedCardFragment.this.savedCardAdapter.setSelectedCardId(((CardDataModel) PWESavedCardFragment.this.cardDataList.get(i)).card_id);
                        PWESavedCardFragment.this.paymentInfoHandler.setDefaultCardSelectionFlag(false);
                        PWESavedCardFragment.this.savedCardAdapter.selectSavedCard(viewFindViewById, i);
                    }
                }
            });
            return;
        }
        this.linearRootSavedCardLayout.setVisibility(8);
        this.linearNoSavedCardsLayout.setVisibility(0);
        this.couponsActivity.setDiscountCodeVisibiliy("hide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedCardDetails(CardDataModel cardDataModel) {
        this.cardId = Integer.toString(cardDataModel.card_id);
        this.cardType = cardDataModel.card_type;
        this.cvv = cardDataModel.cvv;
    }

    public JSONObject validateDiscountCodeOuter(ArrayList<DiscountCodeDataModel> arrayList, PWEDiscountHelper pWEDiscountHelper) {
        String str;
        String str2;
        boolean z;
        this.discountCodeHelper = pWEDiscountHelper;
        JSONObject jSONObject = new JSONObject();
        if (arrayList.size() < 1) {
            str = "Discount codes are not available for this payment mode";
            z = false;
            str2 = "";
        } else {
            String str3 = this.cardId;
            if (str3 == null || str3.isEmpty() || this.cardId.equals("")) {
                str = "Please select saved card";
                str2 = "Select saved card";
            } else if (this.no_cvv_flag.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF) && (this.cvv.equals("") || this.cvv.isEmpty() || this.cvv == null)) {
                str = "Please enter CVV number before applying discount code";
                str2 = "Enter CVV number";
            } else if (!this.no_cvv_flag.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF) || this.cvv.isEmpty()) {
                z = true;
                str = "";
                str2 = str;
            } else {
                if (this.cvv.length() < 3) {
                    str = "Please enter valid CVV number before applying discount code";
                    str2 = "Invalid CVV number";
                    z = false;
                } else {
                    z = true;
                    str = "";
                    str2 = str;
                }
                this.savedCardAdapter.showValidationError(str2, true);
            }
            z = false;
        }
        if (z) {
            this.savedCardAdapter.showValidationError("", false);
        } else {
            this.savedCardAdapter.showValidationError(str2, true);
        }
        try {
            jSONObject.put("status", z);
            jSONObject.put("card_id", this.cardId);
            jSONObject.put("toast_error_message", str);
            jSONObject.put("text_error_message", str2);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public void deleteSavedCard(String str, final int i) {
        this.couponsActivity.showPWELoader();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.generalHelper.getAPIBaseURL()).addConverterFactory(new ToStringConverterFactory()).build().create(RetroAPI.class)).deleteSavedCard(this.paymentInfoHandler.getMerchantAccessKey(), str).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWESavedCardFragment.4
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    PWESavedCardFragment.this.handleDeleteCardResponse(response.body().toString(), i);
                } catch (Exception unused) {
                    PWESavedCardFragment.this.couponsActivity.hidePWELoader();
                    PWESavedCardFragment.this.generalHelper.showPweToast("Please try again.");
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                PWESavedCardFragment.this.couponsActivity.hidePWELoader();
                PWESavedCardFragment.this.generalHelper.showPweToast("Please try again.");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDeleteCardResponse(String str, int i) {
        try {
            if (new JSONObject(str).getBoolean("status")) {
                this.cardDataList.remove(i);
                this.savedCardAdapter.removeCard(this.cardDataList);
                JSONArray jSONArray = new JSONArray(this.paymentInfoHandler.getSavedCards());
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (i2 != i) {
                        jSONArray2.put(jSONArray.get(i2));
                    }
                }
                this.paymentInfoHandler.setSavedCards(jSONArray2.toString());
                this.couponsActivity.resetDiscountCode();
            } else {
                this.generalHelper.showPweToast("Unable to delete the card, Please try again.");
            }
            setCardsVisibility();
        } catch (JSONException unused) {
            this.generalHelper.showPweToast("Exception occured, Please try again.");
        }
        this.couponsActivity.hidePWELoader();
    }

    private void setCardsVisibility() {
        if (this.cardDataList.size() > 0) {
            this.linearRootSavedCardLayout.setVisibility(0);
            this.linearNoSavedCardsLayout.setVisibility(8);
        } else {
            this.linearRootSavedCardLayout.setVisibility(8);
            this.linearNoSavedCardsLayout.setVisibility(0);
            this.couponsActivity.setDiscountCodeVisibiliy("hide");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.open_payment_option = true;
        try {
            if (this.savedCardAdapter != null && this.cardDataList.size() > 0) {
                int i = this.selectedItemPosition;
                if (i != -1 && i < this.cardDataList.size()) {
                    CardDataModel cardDataModel = this.cardDataList.get(this.selectedItemPosition);
                    cardDataModel.cvv = this.cvv;
                    this.savedCardAdapter.setSelectedCardId(cardDataModel.card_id);
                    this.selectedItemPosition = -1;
                } else {
                    this.savedCardAdapter.setSelectedCardId(this.cardDataList.get(0).card_id);
                }
                this.savedCardAdapter.notifyDataSetChanged();
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
