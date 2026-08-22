package adapters;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.easebuzz.payment.kit.PWEPaymentInfoHandler;
import datamodels.PWEPaymentOptionDataModel;
import java.util.ArrayList;
import listeners.PWEPaymentOptionListener;

/* JADX INFO: loaded from: classes.dex */
public class PWEPaymentOptionAdapter extends ArrayAdapter<PWEPaymentOptionDataModel> {
    private Context context;
    private PaymentOptionViewHolder holder;
    public PWEPaymentInfoHandler paymentInfoHandler;
    public PWEPaymentOptionListener paymentOptionListener;
    private ArrayList<PWEPaymentOptionDataModel> payment_option_list;

    class PaymentOptionViewHolder {
        ImageView imgPaymentOption;
        LinearLayout linearRootLayout;
        TextView tvPaymentNote;
        TextView tvPaymentOptionName;

        PaymentOptionViewHolder() {
        }
    }

    public PWEPaymentOptionAdapter(Context context, ArrayList<PWEPaymentOptionDataModel> arrayList, PWEPaymentInfoHandler pWEPaymentInfoHandler) {
        super(context, R.layout.simple_expandable_list_item_1);
        this.context = context;
        this.payment_option_list = arrayList;
        this.paymentInfoHandler = pWEPaymentInfoHandler;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.payment_option_list.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(com.easebuzz.payment.kit.R.layout.pwe_item_payment_option, (ViewGroup) null);
            PaymentOptionViewHolder paymentOptionViewHolder = new PaymentOptionViewHolder();
            paymentOptionViewHolder.linearRootLayout = (LinearLayout) view.findViewById(com.easebuzz.payment.kit.R.id.linear_root_layout_option);
            paymentOptionViewHolder.imgPaymentOption = (ImageView) view.findViewById(com.easebuzz.payment.kit.R.id.image_payment_option);
            paymentOptionViewHolder.tvPaymentOptionName = (TextView) view.findViewById(com.easebuzz.payment.kit.R.id.text_payment_option);
            paymentOptionViewHolder.tvPaymentNote = (TextView) view.findViewById(com.easebuzz.payment.kit.R.id.text_payment_option_note);
            view.setTag(paymentOptionViewHolder);
        }
        PaymentOptionViewHolder paymentOptionViewHolder2 = (PaymentOptionViewHolder) view.getTag();
        this.holder = paymentOptionViewHolder2;
        paymentOptionViewHolder2.imgPaymentOption.setImageResource(this.payment_option_list.get(i).getDisplay_icon());
        this.holder.tvPaymentOptionName.setText(this.payment_option_list.get(i).getDisplay_name());
        this.holder.tvPaymentNote.setText(this.payment_option_list.get(i).getDisplay_note());
        this.holder.linearRootLayout.setOnClickListener(new View.OnClickListener() { // from class: adapters.PWEPaymentOptionAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (PWEPaymentOptionAdapter.this.paymentInfoHandler.getPWEDeviceType().equals("NORMAL")) {
                    PWEPaymentOptionAdapter.this.paymentOptionListener.selectPaymentOption((PWEPaymentOptionDataModel) PWEPaymentOptionAdapter.this.payment_option_list.get(i), i);
                }
            }
        });
        return view;
    }

    public void setPayment_option_list(ArrayList<PWEPaymentOptionDataModel> arrayList) {
        this.payment_option_list = arrayList;
    }

    public void setPWEPaymentOptionListener(PWEPaymentOptionListener pWEPaymentOptionListener) {
        this.paymentOptionListener = pWEPaymentOptionListener;
    }

    public void selectPaymentOption(View view, int i) {
        this.paymentOptionListener.selectPaymentOption(this.payment_option_list.get(i), i);
    }
}
