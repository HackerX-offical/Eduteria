package adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.easebuzz.payment.kit.PWEGeneralHelper;
import com.easebuzz.payment.kit.PWEPaymentInfoHandler;
import com.easebuzz.payment.kit.R;
import datamodels.CouponDataModel;
import datamodels.PWEStaticDataModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import listeners.selectedCouponListener;

/* JADX INFO: loaded from: classes.dex */
public class PWECouponsAdapter extends ArrayAdapter<CouponDataModel> {
    private double allowedCouponWorth;
    private Activity context;
    private ArrayList<CouponDataModel> couponDataList;
    private CouponViewHolder couponViewHolder;
    private double currentCouponWorth;
    private PWEGeneralHelper generalHelper;
    private double newSelectedWorth;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private selectedCouponListener selectedCouponListener;
    private double selectedCouponWorth;

    private class CouponViewHolder {
        private ImageView imageCoupon;
        LinearLayout linearCouponDataHolder;
        private TextView tvBrand;
        private TextView tvPrice;
        private TextView tvTitle;
        private TextView tvViewCouponDetails;

        private CouponViewHolder() {
        }
    }

    public PWECouponsAdapter(Activity activity, ArrayList<CouponDataModel> arrayList, PWEPaymentInfoHandler pWEPaymentInfoHandler) {
        super(activity, R.layout.pwe_item_coupon, arrayList);
        this.context = activity;
        this.couponDataList = arrayList;
        this.paymentInfoHandler = pWEPaymentInfoHandler;
        this.generalHelper = new PWEGeneralHelper(this.context);
    }

    public void setSelectedCouponListener(selectedCouponListener selectedcouponlistener) {
        this.selectedCouponListener = selectedcouponlistener;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.couponDataList.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.pwe_item_coupon, (ViewGroup) null);
            CouponViewHolder couponViewHolder = new CouponViewHolder();
            couponViewHolder.imageCoupon = (ImageView) view.findViewById(R.id.img_coupon);
            couponViewHolder.tvBrand = (TextView) view.findViewById(R.id.text_coupons_brand_name);
            couponViewHolder.tvTitle = (TextView) view.findViewById(R.id.text_coupons_offer_title);
            couponViewHolder.tvPrice = (TextView) view.findViewById(R.id.text_coupon_price);
            couponViewHolder.tvViewCouponDetails = (TextView) view.findViewById(R.id.text_coupon_view);
            couponViewHolder.linearCouponDataHolder = (LinearLayout) view.findViewById(R.id.linear_coupon_data_holder);
            view.setTag(couponViewHolder);
        }
        this.couponViewHolder = (CouponViewHolder) view.getTag();
        this.generalHelper.setImageToImageView(this.couponDataList.get(i).coupon_image_location, this.couponViewHolder.imageCoupon, PWEStaticDataModel.PWEDefaultPlaceholder);
        this.couponViewHolder.tvBrand.setText(this.couponDataList.get(i).coupon_brand);
        this.couponViewHolder.tvTitle.setText(this.couponDataList.get(i).coupon_offer_title);
        this.couponViewHolder.tvPrice.setText(this.context.getResources().getString(R.string.rupees) + "" + (" " + new DecimalFormat("##.##").format(Double.valueOf(Double.parseDouble(new Float(this.couponDataList.get(i).coupon_price).toString())))));
        if (this.couponDataList.get(i).coupon_selectedFlag == 1) {
            this.couponViewHolder.linearCouponDataHolder.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_selected_item_background));
        } else {
            this.couponViewHolder.linearCouponDataHolder.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_custom_card_background));
        }
        this.couponViewHolder.linearCouponDataHolder.setOnClickListener(new View.OnClickListener() { // from class: adapters.PWECouponsAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PWECouponsAdapter.this.paymentInfoHandler.getPWEDeviceType().equals("NORMAL")) {
                    PWECouponsAdapter.this.selectCoupon(i);
                }
            }
        });
        this.couponViewHolder.tvViewCouponDetails.setOnClickListener(new View.OnClickListener() { // from class: adapters.PWECouponsAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PWECouponsAdapter.this.selectedCouponListener.viewSelectedCoupon((CouponDataModel) PWECouponsAdapter.this.couponDataList.get(i));
            }
        });
        return view;
    }

    public void selectCoupon(int i) {
        this.allowedCouponWorth = PWEStaticDataModel.ALLOWED_COUPON_WORTH.doubleValue();
        this.selectedCouponWorth = PWEStaticDataModel.SELECTED_COUPON_WORTH.doubleValue();
        double d2 = this.couponDataList.get(i).coupon_price;
        this.currentCouponWorth = d2;
        this.newSelectedWorth = this.selectedCouponWorth + d2;
        if (this.couponDataList.get(i).coupon_selectedFlag != 0) {
            this.couponDataList.get(i).coupon_selectedFlag = 0;
            this.selectedCouponListener.selectedCouponPrice(this.couponDataList.get(i), false, i);
        } else if (this.newSelectedWorth <= this.allowedCouponWorth) {
            this.couponDataList.get(i).coupon_selectedFlag = 1;
            this.selectedCouponListener.selectedCouponPrice(this.couponDataList.get(i), true, i);
        } else {
            this.generalHelper.showPweToast("Sorry ! you can not select more coupons");
        }
        notifyDataSetChanged();
    }
}
