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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import clientRequestsApi.RetroAPI;
import com.amazonaws.services.s3.internal.Constants;
import datamodels.PWEStaticDataModel;
import helper.PWECustomComponentHelper;
import helper.ToStringConverterFactory;
import listeners.ConnectionDetector;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes7.dex */
public class PWEOlaFragment extends Fragment implements View.OnClickListener {
    private Button buttonPayOla;
    private PWECouponsActivity couponsActivity;
    private PWEGeneralHelper generalHelper;
    private ImageView imgViewIcon;
    private ConnectionDetector internetDetecter;
    private ImageView ivRefresh;
    private LinearLayout linearMainViewHolder;
    private View olaView;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private PWECustomComponentHelper pwe_custom_component_helper;
    private Dialog pwe_loader;
    private TextView tvOlaEligibilityError;
    private TextView tvOlaEligibilityMessage;
    private TextView tvOlaMobileMessage;
    private TextView txtOlaNoteMessage;
    private String selected_payment_option = "";
    private String EndPointUrl = "";
    public String access_key = null;
    public String paymentoption = PWEStaticDataModel.OLA_MONEY_NAME;
    public String selected_coupon = "";
    public String userAgent = "";
    public String device = "";
    private boolean open_payment_option = true;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.olaView = layoutInflater.inflate(R.layout.fragment_pwe_olamoney, viewGroup, false);
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.pwe_custom_component_helper = new PWECustomComponentHelper(getActivity());
        this.internetDetecter = new ConnectionDetector(getActivity());
        this.selected_payment_option = this.paymentInfoHandler.getSelectedPaymentOption();
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.open_payment_option = true;
        this.access_key = this.paymentInfoHandler.getMerchantAccessKey();
        this.EndPointUrl = this.generalHelper.getAPIBaseURL();
        initViews();
        checkOlaEligibility();
        return this.olaView;
    }

    private void initViews() {
        this.pwe_loader = this.pwe_custom_component_helper.getPWELoader(getActivity(), PWEStaticDataModel.PWE_LOADER_STYLE);
        this.linearMainViewHolder = (LinearLayout) this.olaView.findViewById(R.id.linear_dc_view_holder);
        this.imgViewIcon = (ImageView) this.olaView.findViewById(R.id.image_pwe_complete_icon);
        this.tvOlaEligibilityMessage = (TextView) this.olaView.findViewById(R.id.text_ola_message);
        this.tvOlaEligibilityError = (TextView) this.olaView.findViewById(R.id.text_ola_error_details);
        this.tvOlaMobileMessage = (TextView) this.olaView.findViewById(R.id.text_ola_mobile_number_message);
        ImageView imageView = (ImageView) this.olaView.findViewById(R.id.img_refresh);
        this.ivRefresh = imageView;
        imageView.setOnClickListener(this);
        this.ivRefresh.setVisibility(8);
        this.imgViewIcon.setImageResource(R.drawable.pwe_olamoney_complete_icon);
        this.buttonPayOla = (Button) this.olaView.findViewById(R.id.button_proceed_for_payment);
        this.txtOlaNoteMessage = (TextView) this.olaView.findViewById(R.id.text_note_message);
        if (this.paymentInfoHandler.getOlaMoneyNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getOlaMoneyNoteMessage().equals("")) {
            this.txtOlaNoteMessage.setVisibility(8);
        } else {
            this.txtOlaNoteMessage.setVisibility(0);
            this.txtOlaNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getOlaMoneyNoteMessage()));
        }
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonPayOla.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.buttonPayOla);
        }
        this.buttonPayOla.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEOlaFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PWEOlaFragment.this.internetDetecter.isConnectingToInternet()) {
                    if (PWEOlaFragment.this.open_payment_option) {
                        PWEOlaFragment.this.open_payment_option = false;
                        PWEOlaFragment.this.couponsActivity.submitPayment("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                        return;
                    }
                    return;
                }
                PWEOlaFragment.this.open_payment_option = true;
                PWEOlaFragment.this.generalHelper.showPweToast(PWEStaticDataModel.NO_INTERNET_CONNECTION_TEXT);
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
            checkOlaEligibility();
        }
    }

    public void checkOlaEligibility() {
        this.pwe_loader.show();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.EndPointUrl).addConverterFactory(new ToStringConverterFactory()).callFactory(this.generalHelper.getRetrofitConnectionFactory()).build().create(RetroAPI.class)).checkOlaEligibilty(this.access_key).enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWEOlaFragment.2
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                String str;
                String str2;
                String strOptString = "";
                if (PWEOlaFragment.this.pwe_loader != null) {
                    PWEOlaFragment.this.pwe_loader.dismiss();
                }
                PWEOlaFragment.this.tvOlaMobileMessage.setText("We will proceed with the Mobile Number +91 " + PWEOlaFragment.this.paymentInfoHandler.getCustomerPhone());
                PWEOlaFragment.this.tvOlaEligibilityMessage.setTextColor(PWEOlaFragment.this.getActivity().getResources().getColor(R.color.pwe_ola_money_eligibility_msg));
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(response.body().toString());
                        boolean z = jSONObject.getBoolean("status");
                        strOptString = jSONObject.optString("message", "");
                        if (z) {
                            PWEOlaFragment.this.tvOlaEligibilityMessage.setTextColor(PWEOlaFragment.this.getActivity().getResources().getColor(R.color.pwe_ola_money_eligibility_msg_success));
                            PWEOlaFragment.this.tvOlaEligibilityError.setVisibility(8);
                            PWEOlaFragment.this.tvOlaMobileMessage.setVisibility(0);
                            PWEOlaFragment.this.buttonPayOla.setVisibility(0);
                            PWEOlaFragment.this.ivRefresh.setVisibility(8);
                            str = strOptString;
                        } else {
                            str = "You can not pay using Ola Money Please check your Ola Money account.";
                            try {
                                PWEOlaFragment.this.tvOlaEligibilityError.setVisibility(0);
                                PWEOlaFragment.this.ivRefresh.setVisibility(0);
                                PWEOlaFragment.this.buttonPayOla.setVisibility(0);
                                PWEOlaFragment.this.buttonPayOla.setEnabled(false);
                                PWEOlaFragment.this.buttonPayOla.setAlpha(0.5f);
                            } catch (JSONException unused) {
                                str2 = strOptString;
                                strOptString = "You can not pay using Ola Money Please check your Ola Money account.";
                                String str3 = str2;
                                str = strOptString;
                                strOptString = str3;
                            }
                        }
                    } catch (JSONException unused2) {
                        str2 = strOptString;
                    }
                } catch (Exception unused3) {
                    strOptString = PWEStaticDataModel.SERVER_ERROR_STR;
                    PWEOlaFragment.this.ivRefresh.setVisibility(0);
                    PWEOlaFragment.this.buttonPayOla.setVisibility(8);
                    PWEOlaFragment.this.tvOlaMobileMessage.setVisibility(8);
                    str = "Unable to check eligibilty.";
                }
                PWEOlaFragment.this.tvOlaEligibilityMessage.setText(str);
                PWEOlaFragment.this.tvOlaEligibilityError.setText(strOptString);
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                if (PWEOlaFragment.this.pwe_loader != null) {
                    PWEOlaFragment.this.pwe_loader.dismiss();
                }
                PWEOlaFragment.this.tvOlaEligibilityMessage.setText("Unable to check eligibilty.");
                PWEOlaFragment.this.tvOlaEligibilityError.setText(PWEStaticDataModel.SERVER_ERROR_STR);
                PWEOlaFragment.this.ivRefresh.setVisibility(0);
                PWEOlaFragment.this.buttonPayOla.setVisibility(8);
                PWEOlaFragment.this.tvOlaMobileMessage.setVisibility(8);
            }
        });
    }
}
