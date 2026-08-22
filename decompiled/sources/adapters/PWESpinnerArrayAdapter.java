package adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.easebuzz.payment.kit.R;
import datamodels.PWEBankCodeModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PWESpinnerArrayAdapter extends ArrayAdapter<PWEBankCodeModel> {
    private ArrayList<PWEBankCodeModel> bankNamesList;
    private Activity context;
    private String hint;

    public PWESpinnerArrayAdapter(Activity activity, ArrayList<PWEBankCodeModel> arrayList, String str) {
        super(activity, R.layout.pwe_custom_spinner_item, arrayList);
        this.hint = str;
        this.context = activity;
        this.bankNamesList = arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.bankNamesList.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setPadding(4, 0, 4, 0);
        linearLayout.setGravity(3);
        TextView textView = new TextView(this.context);
        textView.setPadding(4, 6, 0, 6);
        textView.setTextSize(13.0f);
        if (i == 0) {
            textView.setHint(this.hint);
        } else {
            textView.setText(this.bankNamesList.get(i).bank_name);
        }
        textView.setHintTextColor(this.context.getResources().getColor(R.color.pwe_hint_color));
        textView.setTextColor(this.context.getResources().getColor(R.color.pwe_text_color));
        linearLayout.addView(textView);
        return linearLayout;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return initView(i, view, viewGroup);
    }

    private View initView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.pwe_custom_spinner_item, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.text_bank_name);
        PWEBankCodeModel item = getItem(i);
        if (item != null) {
            String str = item.bank_name;
            if (i == 0) {
                textView.setGravity(3);
                textView.setTextColor(this.context.getResources().getColor(R.color.pwe_hint_color));
                textView.setText(this.hint);
                return view;
            }
            textView.setTextColor(this.context.getResources().getColor(R.color.pwe_text_color));
            textView.setText(str);
        }
        return view;
    }
}
