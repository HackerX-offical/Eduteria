package com.appnew.android.Courses.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.Address;
import com.appnew.android.Model.AddressMaster;
import com.appnew.android.Payment.OnAddressAddDeleteClicked;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class AddressAdapter extends RecyclerView.Adapter<ViewHolder> {
    ArrayList<AddressMaster> addressMasterList;
    Context context;
    Dialog dialog;
    ListPopupWindow mPopupWindow;
    OnAddressAddDeleteClicked onAddressAddDeleteClicked;

    public AddressAdapter(Context context, Dialog dialog, ArrayList<AddressMaster> addressMasterList, OnAddressAddDeleteClicked onAddressAddDeleteClicked) {
        this.context = context;
        this.dialog = dialog;
        this.addressMasterList = addressMasterList;
        this.onAddressAddDeleteClicked = onAddressAddDeleteClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.address_new_theme_2, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final AddressMaster addressMaster = this.addressMasterList.get(position);
        Address address = (Address) new Gson().fromJson(addressMaster.getAddress(), Address.class);
        if (addressMaster.isChecked()) {
            holder.checkBoxAddress.setChecked(true);
            holder.editAddressIV.setVisibility(0);
        }
        if (!addressMaster.isChecked()) {
            holder.checkBoxAddress.setChecked(false);
            holder.editAddressIV.setVisibility(8);
        }
        if (addressMaster.getIs_default().equalsIgnoreCase("1")) {
            holder.defaultAddressIV.setVisibility(0);
        }
        if (!addressMaster.getIs_default().equalsIgnoreCase("1")) {
            holder.defaultAddressIV.setVisibility(8);
        }
        if (address.getName() != null) {
            holder.nameAddressTv.setText(address.getName());
        } else {
            holder.nameAddressTv.setText("Some Name");
        }
        if (address.getAddress() != null && !TextUtils.isEmpty(address.getAddress())) {
            holder.addedAddressTV.setText(address.getAddress() + ",\n" + address.getCity() + "\n" + address.getState() + ",\n" + address.getPincode());
        } else {
            holder.addedAddressTV.setText("Some Address");
        }
        holder.editAddressIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.AddressAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$0(holder, addressMaster, position, view);
            }
        });
        holder.addressCV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Courses.Adapter.AddressAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onBindViewHolder$1(position, holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(ViewHolder viewHolder, AddressMaster addressMaster, int i, View view) {
        setupPopupWindow(viewHolder.editAddressIV, addressMaster, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1(int i, ViewHolder viewHolder, View view) {
        int i2 = 0;
        while (i2 < this.addressMasterList.size()) {
            this.addressMasterList.get(i2).setChecked(i2 == i);
            viewHolder.addedAddressLL.setBackground(ContextCompat.getDrawable(this.context, R.drawable.orange_round_circle));
            i2++;
        }
        notifyDataSetChanged();
    }

    private void setupPopupWindow(View anchorView, final AddressMaster addressMaster, final int adapterPosition) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.context, android.R.layout.simple_spinner_dropdown_item, new String[]{"EDIT", "DELETE"});
        ListPopupWindow listPopupWindow = new ListPopupWindow(this.context);
        this.mPopupWindow = listPopupWindow;
        listPopupWindow.setAdapter(arrayAdapter);
        this.mPopupWindow.setAnchorView(anchorView);
        this.mPopupWindow.setWidth(500);
        this.mPopupWindow.setHorizontalOffset(-380);
        this.mPopupWindow.setBackgroundDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.bg_round_corner_fill_white, this.context.getTheme()));
        this.mPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.appnew.android.Courses.Adapter.AddressAdapter$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.lambda$setupPopupWindow$2(addressMaster, adapterPosition, adapterView, view, i, j);
            }
        });
        this.mPopupWindow.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupPopupWindow$2(AddressMaster addressMaster, int i, AdapterView adapterView, View view, int i2, long j) {
        if (i2 == 0) {
            OnAddressAddDeleteClicked onAddressAddDeleteClicked = this.onAddressAddDeleteClicked;
            if (onAddressAddDeleteClicked != null) {
                onAddressAddDeleteClicked.onAddAddressClicked(this.dialog, addressMaster);
            }
        } else {
            OnAddressAddDeleteClicked onAddressAddDeleteClicked2 = this.onAddressAddDeleteClicked;
            if (onAddressAddDeleteClicked2 != null) {
                onAddressAddDeleteClicked2.onDeleteAddressClicked(this.addressMasterList, this, i);
            }
        }
        this.mPopupWindow.dismiss();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.addressMasterList.size();
    }

    public void setList(ArrayList<AddressMaster> addressMasterList) {
        this.addressMasterList = addressMasterList;
        notifyDataSetChanged();
        if (addressMasterList.size() == 0) {
            this.dialog.dismiss();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout addedAddressLL;
        TextView addedAddressTV;
        RelativeLayout addressCV;
        CheckBox checkBoxAddress;
        ImageView defaultAddressIV;
        ImageView editAddressIV;
        TextView mobileNumber;
        TextView mobileNumberAlternate;
        TextView nameAddressTv;

        public ViewHolder(View itemView) {
            super(itemView);
            this.addressCV = (RelativeLayout) itemView.findViewById(R.id.addressCV);
            this.nameAddressTv = (TextView) itemView.findViewById(R.id.nameAddressTv);
            this.addedAddressTV = (TextView) itemView.findViewById(R.id.addedAddressTV);
            this.mobileNumber = (TextView) itemView.findViewById(R.id.mobileNumber);
            this.mobileNumberAlternate = (TextView) itemView.findViewById(R.id.mobileNumberAlternate);
            this.editAddressIV = (ImageView) itemView.findViewById(R.id.editAddressIV);
            this.checkBoxAddress = (CheckBox) itemView.findViewById(R.id.checkBoxAddress);
            this.defaultAddressIV = (ImageView) itemView.findViewById(R.id.defaultAddressIV);
            this.addedAddressLL = (LinearLayout) itemView.findViewById(R.id.addedAddressLL);
        }
    }
}
