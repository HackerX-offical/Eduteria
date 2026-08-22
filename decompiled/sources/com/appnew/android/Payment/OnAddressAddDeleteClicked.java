package com.appnew.android.Payment;

import android.app.Dialog;
import com.appnew.android.Courses.Adapter.AddressAdapter;
import com.appnew.android.Model.AddressMaster;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public interface OnAddressAddDeleteClicked {
    void onAddAddressClicked(Dialog dialog, AddressMaster addressMaster);

    void onDeleteAddressClicked(ArrayList<AddressMaster> addressMasterList, AddressAdapter addressAdapter, int adapterPosition);
}
