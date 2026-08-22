package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AddAddressLayoutTheme2Binding implements ViewBinding {
    public final RelativeLayout addAddressLayout;
    public final EditText alternateMobileTV;
    public final EditText cityTV;
    public final TextView delete;
    public final LinearLayoutCompat dialogRoot;
    public final EditText districtTV;
    public final EditText fullAddressTV;
    public final ImageView imageBack;
    public final ScrollView mainRl;
    public final ConstraintLayout mainToolbar;
    public final EditText mobileTV;
    public final EditText nameTV;
    public final EditText orderNotesTV;
    public final EditText pincodeTV;
    public final RecyclerView recyclerViewSavedAddress;
    private final LinearLayoutCompat rootView;
    public final Button saveAddress;
    public final CheckBox selectAllDelete;
    public final AppCompatCheckBox setAsDefaultCheckBox;
    public final RelativeLayout setAsDefaultRl;
    public final EditText stateTV;
    public final RelativeLayout subRL;
    public final Button submit;
    public final TextView toolbarTitleTV;

    private AddAddressLayoutTheme2Binding(LinearLayoutCompat rootView, RelativeLayout addAddressLayout, EditText alternateMobileTV, EditText cityTV, TextView delete, LinearLayoutCompat dialogRoot, EditText districtTV, EditText fullAddressTV, ImageView imageBack, ScrollView mainRl, ConstraintLayout mainToolbar, EditText mobileTV, EditText nameTV, EditText orderNotesTV, EditText pincodeTV, RecyclerView recyclerViewSavedAddress, Button saveAddress, CheckBox selectAllDelete, AppCompatCheckBox setAsDefaultCheckBox, RelativeLayout setAsDefaultRl, EditText stateTV, RelativeLayout subRL, Button submit, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.addAddressLayout = addAddressLayout;
        this.alternateMobileTV = alternateMobileTV;
        this.cityTV = cityTV;
        this.delete = delete;
        this.dialogRoot = dialogRoot;
        this.districtTV = districtTV;
        this.fullAddressTV = fullAddressTV;
        this.imageBack = imageBack;
        this.mainRl = mainRl;
        this.mainToolbar = mainToolbar;
        this.mobileTV = mobileTV;
        this.nameTV = nameTV;
        this.orderNotesTV = orderNotesTV;
        this.pincodeTV = pincodeTV;
        this.recyclerViewSavedAddress = recyclerViewSavedAddress;
        this.saveAddress = saveAddress;
        this.selectAllDelete = selectAllDelete;
        this.setAsDefaultCheckBox = setAsDefaultCheckBox;
        this.setAsDefaultRl = setAsDefaultRl;
        this.stateTV = stateTV;
        this.subRL = subRL;
        this.submit = submit;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static AddAddressLayoutTheme2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AddAddressLayoutTheme2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.add_address_layout_theme_2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AddAddressLayoutTheme2Binding bind(View rootView) {
        int i = R.id.addAddressLayout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.addAddressLayout);
        if (relativeLayout != null) {
            i = R.id.alternateMobileTV;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.alternateMobileTV);
            if (editText != null) {
                i = R.id.cityTV;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.cityTV);
                if (editText2 != null) {
                    i = R.id.delete;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
                    if (textView != null) {
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) rootView;
                        i = R.id.districtTV;
                        EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.districtTV);
                        if (editText3 != null) {
                            i = R.id.fullAddressTV;
                            EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fullAddressTV);
                            if (editText4 != null) {
                                i = R.id.image_back;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                                if (imageView != null) {
                                    i = R.id.main_rl;
                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, R.id.main_rl);
                                    if (scrollView != null) {
                                        i = R.id.main_toolbar;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                        if (constraintLayout != null) {
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
                                                                i = R.id.saveAddress;
                                                                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.saveAddress);
                                                                if (button != null) {
                                                                    i = R.id.select_all_delete;
                                                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                                                                    if (checkBox != null) {
                                                                        i = R.id.setAsDefaultCheckBox;
                                                                        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(rootView, R.id.setAsDefaultCheckBox);
                                                                        if (appCompatCheckBox != null) {
                                                                            i = R.id.setAsDefaultRl;
                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.setAsDefaultRl);
                                                                            if (relativeLayout2 != null) {
                                                                                i = R.id.stateTV;
                                                                                EditText editText9 = (EditText) ViewBindings.findChildViewById(rootView, R.id.stateTV);
                                                                                if (editText9 != null) {
                                                                                    i = R.id.subRL;
                                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.subRL);
                                                                                    if (relativeLayout3 != null) {
                                                                                        i = R.id.submit;
                                                                                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.submit);
                                                                                        if (button2 != null) {
                                                                                            i = R.id.toolbarTitleTV;
                                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                            if (textView2 != null) {
                                                                                                return new AddAddressLayoutTheme2Binding(linearLayoutCompat, relativeLayout, editText, editText2, textView, linearLayoutCompat, editText3, editText4, imageView, scrollView, constraintLayout, editText5, editText6, editText7, editText8, recyclerView, button, checkBox, appCompatCheckBox, relativeLayout2, editText9, relativeLayout3, button2, textView2);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
