package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentCreateTestTwoBinding implements ViewBinding {
    public final RelativeLayout State;
    public final RelativeLayout btnpcd;
    public final Button buttonProceed;
    public final RecyclerView createTestRV;
    public final ImageView downarrowIV;
    public final LinearLayout llnote;
    public final RelativeLayout parentLL;
    private final RelativeLayout rootView;
    public final RelativeLayout spinnerLL;
    public final TextView topText;
    public final TextView typeSpinner;

    private FragmentCreateTestTwoBinding(RelativeLayout rootView, RelativeLayout State, RelativeLayout btnpcd, Button buttonProceed, RecyclerView createTestRV, ImageView downarrowIV, LinearLayout llnote, RelativeLayout parentLL, RelativeLayout spinnerLL, TextView topText, TextView typeSpinner) {
        this.rootView = rootView;
        this.State = State;
        this.btnpcd = btnpcd;
        this.buttonProceed = buttonProceed;
        this.createTestRV = createTestRV;
        this.downarrowIV = downarrowIV;
        this.llnote = llnote;
        this.parentLL = parentLL;
        this.spinnerLL = spinnerLL;
        this.topText = topText;
        this.typeSpinner = typeSpinner;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCreateTestTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCreateTestTwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_create_test_two, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCreateTestTwoBinding bind(View rootView) {
        int i = R.id.State;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.State);
        if (relativeLayout != null) {
            i = R.id.btnpcd;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.btnpcd);
            if (relativeLayout2 != null) {
                i = R.id.buttonProceed;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buttonProceed);
                if (button != null) {
                    i = R.id.createTestRV;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.createTestRV);
                    if (recyclerView != null) {
                        i = R.id.downarrowIV;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                        if (imageView != null) {
                            i = R.id.llnote;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llnote);
                            if (linearLayout != null) {
                                RelativeLayout relativeLayout3 = (RelativeLayout) rootView;
                                i = R.id.spinnerLL;
                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.spinnerLL);
                                if (relativeLayout4 != null) {
                                    i = R.id.topText;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.topText);
                                    if (textView != null) {
                                        i = R.id.typeSpinner;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.typeSpinner);
                                        if (textView2 != null) {
                                            return new FragmentCreateTestTwoBinding(relativeLayout3, relativeLayout, relativeLayout2, button, recyclerView, imageView, linearLayout, relativeLayout3, relativeLayout4, textView, textView2);
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
