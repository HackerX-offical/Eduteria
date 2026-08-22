package adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.easebuzz.payment.kit.PWEGeneralHelper;
import com.easebuzz.payment.kit.R;
import datamodels.NetBankingChild;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SearchableSpinnerAdapter extends ArrayAdapter<String> {
    Activity context;
    private PWEGeneralHelper generalHelper;
    ArrayList<NetBankingChild> list;

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public SearchableSpinnerAdapter(Activity activity, int i, ArrayList<NetBankingChild> arrayList) {
        super(activity, i);
        this.generalHelper = new PWEGeneralHelper(activity);
        this.context = activity;
        this.list = arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public String getItem(int i) {
        return this.list.get(i).getName();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getCustomView(i, view, viewGroup);
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getCustomView(i, view, viewGroup);
    }

    public View getCustomView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.item_netbanking_child, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.bankNamne = (TextView) view.findViewById(R.id.netbaning_bank_name);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.netbaning_bank_logo);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.bankNamne.setText(this.list.get(i).getName());
        if (i == 0) {
            this.generalHelper.setImageToImageView("", viewHolder.imageView, android.R.drawable.ic_menu_search);
            return view;
        }
        this.generalHelper.setImageToImageView(PWEStaticDataModel.REST_BASE_URL + this.list.get(i).getImage_Path(), viewHolder.imageView, PWEStaticDataModel.PWEDefaultBankPaymentIcon);
        return view;
    }

    public class ViewHolder {
        TextView bankNamne;
        ImageView imageView;

        public ViewHolder() {
        }
    }
}
