package com.easebuzz.payment.kit;

import adapters.PWEPaymentOptionAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import datamodels.PWEPaymentOptionDataModel;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;
import listeners.PWEPaymentOptionListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class PWEPaymentOptionsFragment extends Fragment {
    private PWECouponsActivity couponsActivity;
    private PWEGeneralHelper generalHelper;
    private ListView lvPaymentOptions;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private PWEPaymentOptionAdapter paymentOptionAdapter;
    private View paymentOptionView;
    private ArrayList<PWEPaymentOptionDataModel> payment_option_list = new ArrayList<>();

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.paymentOptionView = layoutInflater.inflate(R.layout.fragment_pwepayment_options, viewGroup, false);
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.generalHelper = new PWEGeneralHelper(getActivity());
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        initViews();
        preparePaymentOptionList();
        return this.paymentOptionView;
    }

    private void initViews() {
        this.lvPaymentOptions = (ListView) this.paymentOptionView.findViewById(R.id.listview_payment_options);
        PWEPaymentOptionAdapter pWEPaymentOptionAdapter = new PWEPaymentOptionAdapter(getActivity(), this.payment_option_list, this.paymentInfoHandler);
        this.paymentOptionAdapter = pWEPaymentOptionAdapter;
        this.lvPaymentOptions.setAdapter((ListAdapter) pWEPaymentOptionAdapter);
        this.paymentOptionAdapter.setPWEPaymentOptionListener(new PWEPaymentOptionListener() { // from class: com.easebuzz.payment.kit.PWEPaymentOptionsFragment.1
            @Override // listeners.PWEPaymentOptionListener
            public void selectPaymentOption(PWEPaymentOptionDataModel pWEPaymentOptionDataModel, int i) {
                try {
                    PWEPaymentOptionsFragment.this.couponsActivity.selectPaymentMode(pWEPaymentOptionDataModel);
                } catch (Error unused) {
                    PWEPaymentOptionsFragment.this.generalHelper.showPweToast("Please initiate new transaction.");
                } catch (Exception unused2) {
                    PWEPaymentOptionsFragment.this.generalHelper.showPweToast("Please initiate new transaction.");
                }
            }
        });
        this.lvPaymentOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.easebuzz.payment.kit.PWEPaymentOptionsFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PWEPaymentOptionsFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    PWEPaymentOptionsFragment.this.paymentOptionAdapter.selectPaymentOption(view, i);
                }
            }
        });
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.lvPaymentOptions.setSelector(getResources().getDrawable(R.drawable.pwe_listview_item_selector));
        }
    }

    private void preparePaymentOptionList() {
        this.payment_option_list = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(this.paymentInfoHandler.getEnabledPaymentOptionList());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String strOptString = jSONObject.optString("payment_option_name", "");
                String strOptString2 = jSONObject.optString("payment_option_key", "");
                String strOptString3 = jSONObject.optString("display_name", "");
                String strOptString4 = jSONObject.optString("display_note", "");
                this.payment_option_list.add(new PWEPaymentOptionDataModel(strOptString, strOptString2, strOptString3, jSONObject.optInt("display_icon", PWEStaticDataModel.PWEDefaultBankPaymentIcon), strOptString4));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.paymentOptionAdapter.setPayment_option_list(this.payment_option_list);
        this.paymentOptionAdapter.notifyDataSetChanged();
        this.generalHelper.setListViewHeightBasedOnChildren(this.lvPaymentOptions);
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
