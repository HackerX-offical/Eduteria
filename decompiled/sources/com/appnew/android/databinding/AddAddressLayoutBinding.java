package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AddAddressLayoutBinding implements ViewBinding {
    public final EditText alternateMobileTV;
    public final EditText cityTV;
    public final TextView delete;
    public final EditText districtTV;
    public final EditText fullAddressTV;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final EditText mobileTV;
    public final EditText nameTV;
    public final EditText orderNotesTV;
    public final EditText pincodeTV;
    public final RecyclerView recyclerViewSavedAddress;
    private final RelativeLayout rootView;
    public final CheckBox selectAllDelete;
    public final EditText stateTV;
    public final Button submit;
    public final TextView toolbarTitleTV;

    private AddAddressLayoutBinding(RelativeLayout rootView, EditText alternateMobileTV, EditText cityTV, TextView delete, EditText districtTV, EditText fullAddressTV, ImageView imageBack, Toolbar mainToolbar, EditText mobileTV, EditText nameTV, EditText orderNotesTV, EditText pincodeTV, RecyclerView recyclerViewSavedAddress, CheckBox selectAllDelete, EditText stateTV, Button submit, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.alternateMobileTV = alternateMobileTV;
        this.cityTV = cityTV;
        this.delete = delete;
        this.districtTV = districtTV;
        this.fullAddressTV = fullAddressTV;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.mobileTV = mobileTV;
        this.nameTV = nameTV;
        this.orderNotesTV = orderNotesTV;
        this.pincodeTV = pincodeTV;
        this.recyclerViewSavedAddress = recyclerViewSavedAddress;
        this.selectAllDelete = selectAllDelete;
        this.stateTV = stateTV;
        this.submit = submit;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AddAddressLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AddAddressLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.add_address_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AddAddressLayoutBinding bind(View rootView) {
        int i = R.id.alternateMobileTV;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.alternateMobileTV);
        if (editText != null) {
            i = R.id.cityTV;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.cityTV);
            if (editText2 != null) {
                i = R.id.delete;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
                if (textView != null) {
                    i = R.id.districtTV;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.districtTV);
                    if (editText3 != null) {
                        i = R.id.fullAddressTV;
                        EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fullAddressTV);
                        if (editText4 != null) {
                            i = R.id.image_back;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                            if (imageView != null) {
                                i = R.id.main_toolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                if (toolbar != null) {
                                    i = R.id.mobileTV;
                                    EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobileTV);
                                    if (editText5 != null) {
                                        i = R.id.nameTV;
                                        EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                                        if (editText6 != null) {
                                            i = R.id.orderNotesTV;
                                            EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.orderNotesTV);
                                            if (editText7 != null) {
                                                i = R.id.pincodeTV;
                                                EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.pincodeTV);
                                                if (editText8 != null) {
                                                    i = R.id.recyclerViewSavedAddress;
                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recyclerViewSavedAddress);
                                                    if (recyclerView != null) {
                                                        i = R.id.select_all_delete;
                                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                                                        if (checkBox != null) {
                                                            i = R.id.stateTV;
                                                            EditText editText9 = (EditText) ViewBindings.findChildViewById(rootView, R.id.stateTV);
                                                            if (editText9 != null) {
                                                                i = R.id.submit;
                                                                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submit);
                                                                if (button != null) {
                                                                    i = R.id.toolbarTitleTV;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                    if (textView2 != null) {
                                                                        return new AddAddressLayoutBinding((RelativeLayout) rootView, editText, editText2, textView, editText3, editText4, imageView, toolbar, editText5, editText6, editText7, editText8, recyclerView, checkBox, editText9, button, textView2);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
