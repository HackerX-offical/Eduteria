package com.easebuzz.payment.kit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import datamodels.CouponDataModel;
import datamodels.PWEStaticDataModel;

/* JADX INFO: loaded from: classes7.dex */
public class PWECouponsDetailsFragment extends Fragment {
    private PWECouponsActivity couponsActivity;
    private PWEGeneralHelper generalHelper;
    private ImageView img_couponBrand;
    public CouponDataModel selectedCouponModel;
    private TextView textCouponBrand;
    private TextView textCouponOfferDetail;
    private TextView textCouponTnc;
    private TextView textOfferTitle;
    public TextView tv_internet_label;
    private View viewCouponDetails;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.viewCouponDetails = layoutInflater.inflate(R.layout.fragment_pwecoupons_details, viewGroup, false);
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.generalHelper = new PWEGeneralHelper(getActivity());
        if (this.couponsActivity.getSelectedCouponModel() != null) {
            this.selectedCouponModel = this.couponsActivity.getSelectedCouponModel();
            initView();
            mapCouponDetailInfo();
        }
        return this.viewCouponDetails;
    }

    private void initView() {
        this.tv_internet_label = (TextView) this.viewCouponDetails.findViewById(R.id.no_internet_text);
        this.img_couponBrand = (ImageView) this.viewCouponDetails.findViewById(R.id.image_coupon_brand);
        this.textOfferTitle = (TextView) this.viewCouponDetails.findViewById(R.id.text_coup_offer_titile);
        this.textCouponOfferDetail = (TextView) this.viewCouponDetails.findViewById(R.id.text_coup_offer_description);
        this.textCouponTnc = (TextView) this.viewCouponDetails.findViewById(R.id.text_coupon_tnc);
        this.textCouponBrand = (TextView) this.viewCouponDetails.findViewById(R.id.text_coupon_brandname);
    }

    private void mapCouponDetailInfo() {
        this.generalHelper.setImageToImageView("", this.img_couponBrand, PWEStaticDataModel.PWEDefaultPlaceholder);
        try {
            this.generalHelper.setImageToImageView(this.selectedCouponModel.coupon_image_location, this.img_couponBrand, PWEStaticDataModel.PWEDefaultPlaceholder);
            this.textCouponBrand.setText(this.selectedCouponModel.coupon_brand);
            this.textCouponOfferDetail.setText(this.selectedCouponModel.coupon_content);
            this.textOfferTitle.setText(this.selectedCouponModel.coupon_offer_title);
            this.textCouponTnc.setText(this.selectedCouponModel.coupon_tnc);
        } catch (Exception unused) {
        }
    }
}
