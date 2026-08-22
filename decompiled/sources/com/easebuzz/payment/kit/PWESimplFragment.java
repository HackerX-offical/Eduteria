package com.easebuzz.payment.kit;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import clientRequestsApi.ApiClient;
import clientRequestsApi.RetroAPI;
import com.amazonaws.services.s3.internal.Constants;
import datamodels.PWEStaticDataModel;
import helper.PWECustomComponentHelper;
import listeners.ConnectionDetector;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes7.dex */
public class PWESimplFragment extends Fragment implements View.OnClickListener {
    private View SimplView;
    private Button buttonPaySimpl;
    private PWECouponsActivity couponsActivity;
    private PWEGeneralHelper generalHelper;
    private ImageView imgViewIcon;
    private ConnectionDetector internetDetecter;
    private ImageView ivRefresh;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private PWECustomComponentHelper pwe_custom_component_helper;
    private Dialog pwe_loader;
    private TextView tvSimplEligibilityError;
    private TextView tvSimplEligibilityMessage;
    private TextView tvSimplMobileMessage;
    private TextView tvSimpleNoteMessage;
    private String EndPointUrl = "";
    public String access_key = null;
    private boolean open_payment_option = true;
    String dataJson_string = "";

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.SimplView = layoutInflater.inflate(R.layout.fragment_pwe_olamoney, viewGroup, false);
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.pwe_custom_component_helper = new PWECustomComponentHelper(getActivity());
        this.internetDetecter = new ConnectionDetector(getActivity());
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.open_payment_option = true;
        this.access_key = this.paymentInfoHandler.getMerchantAccessKey();
        this.EndPointUrl = this.generalHelper.getAPIBaseURL();
        initViews();
        checkSimplEligibility();
        return this.SimplView;
    }

    private void initViews() {
        this.pwe_loader = this.pwe_custom_component_helper.getPWELoader(getActivity(), PWEStaticDataModel.PWE_LOADER_STYLE);
        this.imgViewIcon = (ImageView) this.SimplView.findViewById(R.id.image_pwe_complete_icon);
        this.tvSimplEligibilityMessage = (TextView) this.SimplView.findViewById(R.id.text_ola_message);
        this.tvSimplEligibilityError = (TextView) this.SimplView.findViewById(R.id.text_ola_error_details);
        this.tvSimplMobileMessage = (TextView) this.SimplView.findViewById(R.id.text_ola_mobile_number_message);
        ImageView imageView = (ImageView) this.SimplView.findViewById(R.id.img_refresh);
        this.ivRefresh = imageView;
        imageView.setOnClickListener(this);
        this.ivRefresh.setVisibility(8);
        this.imgViewIcon.setImageResource(R.drawable.pwe_simpl_complete_icon);
        this.buttonPaySimpl = (Button) this.SimplView.findViewById(R.id.button_proceed_for_payment);
        this.tvSimpleNoteMessage = (TextView) this.SimplView.findViewById(R.id.text_note_message);
        if (this.paymentInfoHandler.getPayLaterNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getPayLaterNoteMessage().equals("")) {
            this.tvSimpleNoteMessage.setVisibility(8);
        } else {
            this.tvSimpleNoteMessage.setVisibility(0);
            this.tvSimpleNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getPayLaterNoteMessage()));
        }
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonPaySimpl.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.buttonPaySimpl);
        }
        this.buttonPaySimpl.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWESimplFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PWESimplFragment.this.internetDetecter.isConnectingToInternet()) {
                    if (PWESimplFragment.this.open_payment_option) {
                        PWESimplFragment.this.open_payment_option = false;
                        PWESimplFragment.this.couponsActivity.submitPayment("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", PWESimplFragment.this.dataJson_string, PWEStaticDataModel.SIMPL_DISPLAY_NAME);
                        return;
                    }
                    return;
                }
                PWESimplFragment.this.open_payment_option = true;
                PWESimplFragment.this.generalHelper.showPweToast(PWEStaticDataModel.NO_INTERNET_CONNECTION_TEXT);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ConnectionDetector connectionDetector = new ConnectionDetector(getActivity());
        int id = view.getId();
        if (connectionDetector.isConnectingToInternet() && id == R.id.img_refresh) {
            checkSimplEligibility();
        }
    }

    public void checkSimplEligibility() {
        this.pwe_loader.show();
        ((RetroAPI) ApiClient.getClient(this.EndPointUrl).create(RetroAPI.class)).checkSimplEligibilty(this.access_key, PWEStaticDataModel.SIMPL_DISPLAY_NAME).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWESimplFragment.2
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                String strOptString;
                String str;
                String string;
                JSONObject jSONObject;
                boolean z;
                String str2 = "";
                if (PWESimplFragment.this.pwe_loader != null) {
                    PWESimplFragment.this.pwe_loader.dismiss();
                }
                PWESimplFragment.this.tvSimplMobileMessage.setText("We will proceed with the Mobile Number +91 " + PWESimplFragment.this.paymentInfoHandler.getCustomerPhone());
                PWESimplFragment.this.tvSimplEligibilityMessage.setTextColor(PWESimplFragment.this.getActivity().getResources().getColor(R.color.pwe_ola_money_eligibility_msg));
                try {
                    try {
                        jSONObject = new JSONObject(response.body().toString());
                        z = jSONObject.getBoolean("status");
                        strOptString = jSONObject.optString("message", "");
                        str = "You can not pay using Simpl .Please check your Simpl account.";
                    } catch (JSONException unused) {
                        string = "";
                    }
                } catch (Exception unused2) {
                    strOptString = PWEStaticDataModel.SERVER_ERROR_STR;
                    PWESimplFragment.this.ivRefresh.setVisibility(0);
                    PWESimplFragment.this.buttonPaySimpl.setVisibility(8);
                    PWESimplFragment.this.tvSimplMobileMessage.setVisibility(8);
                    str = "Unable to check eligibilty.";
                }
                if (z) {
                    PWESimplFragment.this.tvSimplEligibilityMessage.setTextColor(PWESimplFragment.this.getActivity().getResources().getColor(R.color.pwe_ola_money_eligibility_msg_success));
                    PWESimplFragment.this.tvSimplEligibilityError.setVisibility(8);
                    PWESimplFragment.this.tvSimplMobileMessage.setVisibility(0);
                    PWESimplFragment.this.ivRefresh.setVisibility(8);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (jSONObject2.getString("status").equals("eligible")) {
                        PWESimplFragment.this.buttonPaySimpl.setEnabled(true);
                        PWESimplFragment.this.dataJson_string = jSONObject2.toString();
                        str = "You can pay using Simpl Wallet.";
                        PWESimplFragment.this.tvSimplEligibilityMessage.setText(str);
                        PWESimplFragment.this.tvSimplEligibilityError.setText(strOptString);
                    }
                    string = jSONObject2.getString("error_code");
                    PWESimplFragment.this.tvSimplEligibilityMessage.setTextColor(PWESimplFragment.this.getActivity().getResources().getColor(R.color.pwe_ola_money_eligibility_msg));
                    try {
                        PWESimplFragment.this.buttonPaySimpl.setEnabled(false);
                        PWESimplFragment.this.buttonPaySimpl.setAlpha(0.5f);
                    } catch (JSONException unused3) {
                        str2 = "You can not pay using Simpl .Please check your Simpl account.";
                        str = str2;
                    }
                    strOptString = string;
                    PWESimplFragment.this.tvSimplEligibilityMessage.setText(str);
                    PWESimplFragment.this.tvSimplEligibilityError.setText(strOptString);
                }
                strOptString = jSONObject.getJSONObject("error").getString("message");
                try {
                    PWESimplFragment.this.tvSimplEligibilityMessage.setTextColor(PWESimplFragment.this.getActivity().getResources().getColor(R.color.pwe_ola_money_eligibility_msg));
                    PWESimplFragment.this.tvSimplEligibilityError.setVisibility(0);
                    PWESimplFragment.this.ivRefresh.setVisibility(0);
                    PWESimplFragment.this.buttonPaySimpl.setVisibility(0);
                    PWESimplFragment.this.buttonPaySimpl.setEnabled(false);
                    PWESimplFragment.this.buttonPaySimpl.setAlpha(0.5f);
                } catch (JSONException unused4) {
                    string = strOptString;
                    str2 = "You can not pay using Simpl .Please check your Simpl account.";
                    str = str2;
                    strOptString = string;
                }
                PWESimplFragment.this.tvSimplEligibilityMessage.setText(str);
                PWESimplFragment.this.tvSimplEligibilityError.setText(strOptString);
                str = str2;
                strOptString = string;
                PWESimplFragment.this.tvSimplEligibilityMessage.setText(str);
                PWESimplFragment.this.tvSimplEligibilityError.setText(strOptString);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                if (PWESimplFragment.this.pwe_loader != null) {
                    PWESimplFragment.this.pwe_loader.dismiss();
                }
                PWESimplFragment.this.tvSimplEligibilityMessage.setText("Unable to check eligibilty.");
                PWESimplFragment.this.tvSimplEligibilityError.setText(PWEStaticDataModel.SERVER_ERROR_STR);
                PWESimplFragment.this.ivRefresh.setVisibility(0);
                PWESimplFragment.this.buttonPaySimpl.setVisibility(8);
                PWESimplFragment.this.tvSimplMobileMessage.setVisibility(8);
            }
        });
    }
}
