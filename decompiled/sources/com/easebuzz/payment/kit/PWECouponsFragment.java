package com.easebuzz.payment.kit;

import adapters.PWECouponsAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.clevertap.android.sdk.Constants;
import datamodels.CouponDataModel;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;
import listeners.selectedCouponListener;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class PWECouponsFragment extends Fragment {
    private JSONArray couponJSONARR;
    private PWECouponsActivity couponsActivity;
    private PWECouponsAdapter couponsAdapter;
    private ExpandableHeightGridView gridViewCoupons;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private ArrayList<CouponDataModel> receivedCouponList;
    private ArrayList<String> selectedCouponIdList;
    private Double selectedCouponWorth = Double.valueOf(0.0d);
    private TextView tvSelectedCashbackWorth;
    private View viewCoupon;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.viewCoupon = layoutInflater.inflate(R.layout.fragment_pwecoupons, viewGroup, false);
        this.selectedCouponIdList = new ArrayList<>();
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        String strTrim = this.paymentInfoHandler.getSelectedCouponIdList().trim();
        for (String str : strTrim.substring(1, strTrim.length() - 1).split(Constants.SEPARATOR_COMMA)) {
            this.selectedCouponIdList.add(str.trim());
        }
        initViews();
        retriveCouponList();
        return this.viewCoupon;
    }

    private void initViews() {
        this.gridViewCoupons = (ExpandableHeightGridView) this.viewCoupon.findViewById(R.id.grid_coupon);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.gridViewCoupons.setSelector(getResources().getDrawable(R.drawable.pwe_gridview_item_selector));
        }
        this.tvSelectedCashbackWorth = (TextView) this.viewCoupon.findViewById(R.id.txt_selected_coupon_worth);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.selectedCouponWorth = Double.valueOf(Double.parseDouble(this.paymentInfoHandler.getSelectedCashbackWorth()));
        PWEStaticDataModel.SELECTED_COUPON_COUNT = this.paymentInfoHandler.getSelectedCashbackCouponCount();
        setSelectedCouponData();
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
    public void onPause() {
        updateSelectedCouponList();
        super.onPause();
    }

    void retriveCouponList() {
        try {
            this.receivedCouponList = new ArrayList<>();
            this.couponJSONARR = new JSONArray(this.paymentInfoHandler.getCashbackCouponsData());
            for (int i = 0; i < this.couponJSONARR.length(); i++) {
                JSONObject jSONObject = this.couponJSONARR.getJSONObject(i);
                int iOptInt = jSONObject.optInt("id", 0);
                this.receivedCouponList.add(new CouponDataModel(iOptInt, jSONObject.optString("brand", ""), jSONObject.optString("title", ""), jSONObject.optString("brand_url", ""), jSONObject.optString("tnc", ""), jSONObject.optInt("amount", 0), jSONObject.optString("validity", ""), jSONObject.optString("image_location", ""), this.selectedCouponIdList.contains(Integer.toString(iOptInt)) ? 1 : 0, jSONObject.getString("image_location").split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r5.length - 1]));
                initializeAdapter();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void initializeAdapter() {
        PWECouponsAdapter pWECouponsAdapter = new PWECouponsAdapter(getActivity(), this.receivedCouponList, this.paymentInfoHandler);
        this.couponsAdapter = pWECouponsAdapter;
        this.gridViewCoupons.setAdapter((ListAdapter) pWECouponsAdapter);
        this.gridViewCoupons.setNumColumns(2);
        this.gridViewCoupons.setExpanded(true);
        this.couponsAdapter.setSelectedCouponListener(new selectedCouponListener() { // from class: com.easebuzz.payment.kit.PWECouponsFragment.1
            @Override // listeners.selectedCouponListener
            public void selectedCouponPrice(CouponDataModel couponDataModel, boolean z, int i) {
                float f2 = couponDataModel.coupon_price;
                if (z) {
                    ((CouponDataModel) PWECouponsFragment.this.receivedCouponList.get(i)).coupon_selectedFlag = 1;
                    PWEStaticDataModel.SELECTED_COUPON_COUNT++;
                    PWECouponsFragment pWECouponsFragment = PWECouponsFragment.this;
                    pWECouponsFragment.selectedCouponWorth = Double.valueOf(pWECouponsFragment.selectedCouponWorth.doubleValue() + ((double) f2));
                } else {
                    ((CouponDataModel) PWECouponsFragment.this.receivedCouponList.get(i)).coupon_selectedFlag = 0;
                    PWEStaticDataModel.SELECTED_COUPON_COUNT--;
                    PWECouponsFragment pWECouponsFragment2 = PWECouponsFragment.this;
                    pWECouponsFragment2.selectedCouponWorth = Double.valueOf(pWECouponsFragment2.selectedCouponWorth.doubleValue() - ((double) f2));
                }
                PWECouponsFragment pWECouponsFragment3 = PWECouponsFragment.this;
                pWECouponsFragment3.selectedCouponWorth = Double.valueOf(Double.parseDouble(String.format("%.2f", pWECouponsFragment3.selectedCouponWorth)));
                PWECouponsFragment.this.setSelectedCouponData();
            }

            @Override // listeners.selectedCouponListener
            public void viewSelectedCoupon(CouponDataModel couponDataModel) {
                PWECouponsFragment.this.couponsActivity.showMode("coupondetailsview");
                PWECouponsFragment.this.couponsActivity.setSelectedCouponModel(couponDataModel);
            }
        });
        this.gridViewCoupons.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.easebuzz.payment.kit.PWECouponsFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PWECouponsFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    PWECouponsFragment.this.couponsAdapter.selectCoupon(i);
                }
            }
        });
    }

    public void updateSelectedCouponList() {
        ArrayList arrayList = new ArrayList();
        for (CouponDataModel couponDataModel : this.receivedCouponList) {
            if (couponDataModel.coupon_selectedFlag == 1) {
                arrayList.add(Integer.toString(couponDataModel.coupon_id));
            }
        }
        this.paymentInfoHandler.setSelectedCouponIdList(arrayList.toString());
        this.paymentInfoHandler.setSelectedCashbackWorth(String.format("%.2f", this.selectedCouponWorth));
        this.paymentInfoHandler.setSelectedCashbackCouponCount(PWEStaticDataModel.SELECTED_COUPON_COUNT);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void setSelectedCouponData() {
        this.tvSelectedCashbackWorth.setText("" + getActivity().getString(R.string.rupees) + " " + this.selectedCouponWorth);
        PWEStaticDataModel.SELECTED_COUPON_WORTH = this.selectedCouponWorth;
        this.couponsActivity.updateSelectedCashBackData();
    }
}
