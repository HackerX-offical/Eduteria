package adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.easebuzz.payment.kit.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PWESpinnerAdapter extends BaseAdapter implements SpinnerAdapter {
    private final Context activity;
    private String hint;
    private ArrayList<String> list;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public PWESpinnerAdapter(Context context, ArrayList<String> arrayList, String str) {
        this.list = arrayList;
        this.activity = context;
        this.hint = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.list.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setPadding(4, 10, 4, 10);
        linearLayout.setGravity(3);
        TextView textView = new TextView(this.activity);
        textView.setPadding(5, 4, 5, 4);
        textView.setTextSize(13.0f);
        if (!this.hint.equals("Account Type")) {
            textView.setWidth(230);
        }
        textView.setText(this.list.get(i));
        textView.setGravity(17);
        textView.setTextColor(this.activity.getResources().getColor(R.color.pwe_text_color));
        linearLayout.addView(textView);
        return linearLayout;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setPadding(4, 0, 4, 0);
        linearLayout.setGravity(3);
        TextView textView = new TextView(this.activity);
        textView.setPadding(4, 6, 0, 6);
        textView.setTextSize(13.0f);
        textView.setWidth(290);
        if (i == 0) {
            textView.setHint(this.hint);
        } else {
            textView.setText(this.list.get(i));
        }
        textView.setHintTextColor(this.activity.getResources().getColor(R.color.pwe_hint_color));
        textView.setTextColor(this.activity.getResources().getColor(R.color.pwe_text_color));
        linearLayout.addView(textView);
        return linearLayout;
    }
}
