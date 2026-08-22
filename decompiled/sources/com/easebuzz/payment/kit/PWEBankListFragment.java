package com.easebuzz.payment.kit;

import adapters.PWEEmiBankAdapter;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import clientRequestsApi.RetroAPI;
import datamodels.EmiBanksModel;
import datamodels.PWEStaticDataModel;
import helper.PWECustomComponentHelper;
import helper.ToStringConverterFactory;
import java.util.ArrayList;
import listeners.ConnectionDetector;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes7.dex */
public class PWEBankListFragment extends Fragment {
    private static PWEBankListFragment instance;
    private LinearLayout LinearNoEmiOptionsError;
    private View bankView;
    private Button btnGoback;
    private PWECouponsActivity couponsActivity;
    private PWEEmiBankAdapter emiBankAdapter;
    private PWEGeneralHelper generalHelper;
    private ConnectionDetector internetDetecter;
    private LinearLayout linearEmiBanksHolder;
    private ListView lvEmiBanks;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private ArrayList<EmiBanksModel> popularBankList;
    private PWECustomComponentHelper pweCustomComponentHelper;
    private Dialog pwe_loader;
    private TextView tvEmiError;
    private String access_key = "";
    public boolean open_payment_option = true;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bankView = layoutInflater.inflate(R.layout.fragment_pwe_emi_bank_list, viewGroup, false);
        instance = this;
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.internetDetecter = new ConnectionDetector(getActivity());
        this.pweCustomComponentHelper = new PWECustomComponentHelper(getActivity());
        this.access_key = this.paymentInfoHandler.getMerchantAccessKey();
        this.open_payment_option = true;
        initViews();
        if (this.paymentInfoHandler.getPWEEmiBanksPlansData().equals("")) {
            getEMIOptions();
        } else {
            prepareEmiBanksAndPlans();
        }
        return this.bankView;
    }

    private void initViews() {
        this.pwe_loader = this.pweCustomComponentHelper.getPWELoader(getActivity(), PWEStaticDataModel.PWE_LOADER_STYLE);
        this.popularBankList = new ArrayList<>();
        this.linearEmiBanksHolder = (LinearLayout) this.bankView.findViewById(R.id.linear_emi_banks_holder);
        this.LinearNoEmiOptionsError = (LinearLayout) this.bankView.findViewById(R.id.linear_no_emi_options_error);
        this.tvEmiError = (TextView) this.bankView.findViewById(R.id.text_emi_option_error);
        this.lvEmiBanks = (ListView) this.bankView.findViewById(R.id.list_emi_banks);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.lvEmiBanks.setSelector(getResources().getDrawable(R.drawable.pwe_listview_item_selector));
        }
        this.lvEmiBanks.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.easebuzz.payment.kit.PWEBankListFragment.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PWEBankListFragment.this.internetDetecter.isConnectingToInternet()) {
                    if (PWEBankListFragment.this.open_payment_option) {
                        PWEBankListFragment.this.open_payment_option = false;
                        EmiBanksModel emiBanksModel = (EmiBanksModel) adapterView.getItemAtPosition(i);
                        PWEBankListFragment.this.paymentInfoHandler.setSelectedEMIBank(emiBanksModel.getBank_display_name());
                        PWEBankListFragment.this.paymentInfoHandler.setSelectedEMIBankCode(emiBanksModel.getBank_code());
                        PWEEmiFragment.getInstance().selectEMIBank(emiBanksModel);
                        return;
                    }
                    PWEBankListFragment.this.open_payment_option = true;
                    return;
                }
                PWEBankListFragment.this.open_payment_option = true;
                PWEBankListFragment.this.generalHelper.showPweToast(PWEStaticDataModel.NO_INTERNET_CONNECTION_TEXT);
            }
        });
        this.btnGoback = (Button) this.bankView.findViewById(R.id.button_back_to_payment_option);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.btnGoback.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.btnGoback);
        }
        this.btnGoback.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEBankListFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEBankListFragment.this.couponsActivity.onBackPressed();
            }
        });
    }

    public static PWEBankListFragment getInstance() {
        return instance;
    }

    private void initializeBanksAdapter() {
        PWEEmiBankAdapter pWEEmiBankAdapter = new PWEEmiBankAdapter(this.couponsActivity, this.popularBankList);
        this.emiBankAdapter = pWEEmiBankAdapter;
        this.lvEmiBanks.setAdapter((ListAdapter) pWEEmiBankAdapter);
        this.generalHelper.setListViewHeightBasedOnChildren(this.lvEmiBanks);
    }

    public void showNoEmiError(String str) {
        this.linearEmiBanksHolder.setVisibility(8);
        this.LinearNoEmiOptionsError.setVisibility(0);
        this.tvEmiError.setText(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.open_payment_option = true;
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

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.paymentInfoHandler.setSelectedEMIBank("");
        this.paymentInfoHandler.setSelectedEMIBankCode("");
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void prepareEmiBanksAndPlans() {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easebuzz.payment.kit.PWEBankListFragment.prepareEmiBanksAndPlans():void");
    }

    public void getEMIOptions() {
        this.pwe_loader.show();
        ((RetroAPI) new Retrofit.Builder().baseUrl(this.generalHelper.getAPIBaseURL()).addConverterFactory(new ToStringConverterFactory()).callFactory(this.generalHelper.getRetrofitConnectionFactory()).build().create(RetroAPI.class)).getEMIOptions(this.access_key, "1").enqueue(new Callback<String>() { // from class: com.easebuzz.payment.kit.PWEBankListFragment.3
            @Override // retrofit2.Callback
            public void onResponse(Call<String> call, Response<String> response) {
                try {
                    JSONObject jSONObject = new JSONObject(response.body().toString());
                    String strOptString = "Unable to get emi options, Please try again";
                    boolean z = true;
                    if (jSONObject.getBoolean("status")) {
                        PWEBankListFragment.this.paymentInfoHandler.setPWEEmiBanksPlansData(jSONObject.optString("data", ""));
                        PWEBankListFragment.this.prepareEmiBanksAndPlans();
                        z = false;
                    } else {
                        strOptString = jSONObject.optString("msg_desc", "Unable to get emi options, Please try again");
                    }
                    if (z) {
                        PWEBankListFragment.this.generalHelper.showPweToast(strOptString);
                        PWEBankListFragment.this.showNoEmiError(strOptString);
                    }
                } catch (JSONException unused) {
                    PWEBankListFragment.this.generalHelper.showPweToast("Failed, Please try again");
                }
                PWEBankListFragment.this.pwe_loader.dismiss();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<String> call, Throwable th) {
                PWEBankListFragment.this.generalHelper.showPweToast("Failed, Please try again");
                PWEBankListFragment.this.pwe_loader.dismiss();
            }
        });
    }
}
