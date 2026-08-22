package adapters;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import datamodels.CancellationReasonModel;
import java.util.ArrayList;
import listeners.CancelReasonListener;

/* JADX INFO: loaded from: classes.dex */
public class PWECancellationReasonAdapter extends ArrayAdapter {
    private CancelReasonListener c_r_Listener;
    private ArrayList<CancellationReasonModel> cancellationReasoArrayList;
    private Context context;
    private CancellationHolder holder;

    private class CancellationHolder {
        private LinearLayout linearRootLayout;
        private RadioButton rbSelectReason;
        private TextView tvReason;

        private CancellationHolder() {
        }
    }

    public void setCancelReasonListener(CancelReasonListener cancelReasonListener) {
        this.c_r_Listener = cancelReasonListener;
    }

    public PWECancellationReasonAdapter(Context context, ArrayList<CancellationReasonModel> arrayList) {
        super(context, R.layout.simple_list_item_1);
        this.context = context;
        this.cancellationReasoArrayList = arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.cancellationReasoArrayList.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(com.easebuzz.payment.kit.R.layout.pwe_item_cancellation_reason, (ViewGroup) null);
            CancellationHolder cancellationHolder = new CancellationHolder();
            cancellationHolder.rbSelectReason = (RadioButton) view.findViewById(com.easebuzz.payment.kit.R.id.rb_cn_reason);
            cancellationHolder.tvReason = (TextView) view.findViewById(com.easebuzz.payment.kit.R.id.txt_cn_reason);
            cancellationHolder.linearRootLayout = (LinearLayout) view.findViewById(com.easebuzz.payment.kit.R.id.linear_root_cancellation_resoans);
            view.setTag(cancellationHolder);
        }
        CancellationHolder cancellationHolder2 = (CancellationHolder) view.getTag();
        this.holder = cancellationHolder2;
        cancellationHolder2.tvReason.setText(this.cancellationReasoArrayList.get(i).getReason());
        if (this.cancellationReasoArrayList.get(i).isSelected_flag()) {
            this.holder.rbSelectReason.setChecked(true);
        } else {
            this.holder.rbSelectReason.setChecked(false);
        }
        this.holder.linearRootLayout.setOnClickListener(new View.OnClickListener() { // from class: adapters.PWECancellationReasonAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!((CancellationReasonModel) PWECancellationReasonAdapter.this.cancellationReasoArrayList.get(i)).isSelected_flag()) {
                    PWECancellationReasonAdapter.this.c_r_Listener.selectReason((CancellationReasonModel) PWECancellationReasonAdapter.this.cancellationReasoArrayList.get(i), true, i);
                } else {
                    PWECancellationReasonAdapter.this.c_r_Listener.selectReason((CancellationReasonModel) PWECancellationReasonAdapter.this.cancellationReasoArrayList.get(i), true, i);
                }
            }
        });
        this.holder.rbSelectReason.setOnClickListener(new View.OnClickListener() { // from class: adapters.PWECancellationReasonAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!((CancellationReasonModel) PWECancellationReasonAdapter.this.cancellationReasoArrayList.get(i)).isSelected_flag()) {
                    PWECancellationReasonAdapter.this.c_r_Listener.selectReason((CancellationReasonModel) PWECancellationReasonAdapter.this.cancellationReasoArrayList.get(i), true, i);
                } else {
                    PWECancellationReasonAdapter.this.c_r_Listener.selectReason((CancellationReasonModel) PWECancellationReasonAdapter.this.cancellationReasoArrayList.get(i), true, i);
                }
            }
        });
        return view;
    }
}
