package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.easebuzz.payment.kit.PWEGeneralHelper;
import com.easebuzz.payment.kit.PWEPaymentInfoHandler;
import com.easebuzz.payment.kit.R;
import datamodels.DiscountCodeDataModel;
import java.util.ArrayList;
import listeners.PWEDiscountListener;

/* JADX INFO: loaded from: classes.dex */
public class PWEDiscountCodeListAdapter extends ArrayAdapter<DiscountCodeDataModel> {
    private Context context;
    private ArrayList<DiscountCodeDataModel> discountCodeList;
    private PWEDiscountListener discountCodeListener;
    private PWEGeneralHelper generalHelper;
    private LayoutInflater inflater;
    private PWEPaymentInfoHandler paymentInfoHandler;

    public PWEDiscountCodeListAdapter(Context context, ArrayList<DiscountCodeDataModel> arrayList, PWEPaymentInfoHandler pWEPaymentInfoHandler) {
        super(context, R.layout.pwe_item_discount_code, arrayList);
        this.context = context;
        this.discountCodeList = arrayList;
        this.paymentInfoHandler = pWEPaymentInfoHandler;
        this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.generalHelper = new PWEGeneralHelper(this.context);
    }

    public void setDiscountCodeListener(PWEDiscountListener pWEDiscountListener) {
        this.discountCodeListener = pWEDiscountListener;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.inflater.inflate(R.layout.pwe_item_discount_code, (ViewGroup) null, true);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvTitle.setText("" + this.discountCodeList.get(i).getDiscount_code());
        viewHolder.tvDesc.setText("" + this.discountCodeList.get(i).getDiscount_description());
        viewHolder.tvCode.setText("" + this.discountCodeList.get(i).getDiscount_code());
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            viewHolder.btnApply.setBackground(this.context.getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
        }
        viewHolder.btnApply.setOnClickListener(new View.OnClickListener() { // from class: adapters.PWEDiscountCodeListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PWEDiscountCodeListAdapter.this.generalHelper.hideKeyboard(PWEDiscountCodeListAdapter.this.getContext(), view2);
                PWEDiscountCodeListAdapter.this.discountCodeListener.applySelectedDiscountCode((DiscountCodeDataModel) PWEDiscountCodeListAdapter.this.discountCodeList.get(i), i);
            }
        });
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.discountCodeList.size();
    }

    private static class ViewHolder {
        private Button btnApply;
        private TextView tvCode;
        private TextView tvDesc;
        private TextView tvTitle;

        public ViewHolder(View view) {
            this.tvTitle = (TextView) view.findViewById(R.id.text_discount_title);
            this.tvDesc = (TextView) view.findViewById(R.id.text_discount_description);
            this.tvCode = (TextView) view.findViewById(R.id.text_discount_code);
            this.btnApply = (Button) view.findViewById(R.id.btn_apply_discount_coupon_code);
        }
    }
}
