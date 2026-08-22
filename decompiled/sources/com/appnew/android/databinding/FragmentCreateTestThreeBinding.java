package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentCreateTestThreeBinding implements ViewBinding {
    public final RelativeLayout State;
    public final Button buttonProceed;
    public final ImageView downarrowIV;
    public final EditText etMax;
    public final TextView highTV;
    public final LinearLayout lltop;
    public final TextView lowTV;
    public final TextView maxTV;
    public final TextView mediumTV;
    public final RelativeLayout parentLL;
    private final ScrollView rootView;
    public final RelativeLayout spinnerLL;
    public final TextView totalquestion;
    public final TextView typeSpinner;

    private FragmentCreateTestThreeBinding(ScrollView rootView, RelativeLayout State, Button buttonProceed, ImageView downarrowIV, EditText etMax, TextView highTV, LinearLayout lltop, TextView lowTV, TextView maxTV, TextView mediumTV, RelativeLayout parentLL, RelativeLayout spinnerLL, TextView totalquestion, TextView typeSpinner) {
        this.rootView = rootView;
        this.State = State;
        this.buttonProceed = buttonProceed;
        this.downarrowIV = downarrowIV;
        this.etMax = etMax;
        this.highTV = highTV;
        this.lltop = lltop;
        this.lowTV = lowTV;
        this.maxTV = maxTV;
        this.mediumTV = mediumTV;
        this.parentLL = parentLL;
        this.spinnerLL = spinnerLL;
        this.totalquestion = totalquestion;
        this.typeSpinner = typeSpinner;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentCreateTestThreeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCreateTestThreeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_create_test_three, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCreateTestThreeBinding bind(View rootView) {
        int i = R.id.State;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.State);
        if (relativeLayout != null) {
            i = R.id.buttonProceed;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buttonProceed);
            if (button != null) {
                i = R.id.downarrowIV;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                if (imageView != null) {
                    i = R.id.et_max;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_max);
                    if (editText != null) {
                        i = R.id.highTV;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.highTV);
                        if (textView != null) {
                            i = R.id.lltop;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lltop);
                            if (linearLayout != null) {
                                i = R.id.lowTV;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.lowTV);
                                if (textView2 != null) {
                                    i = R.id.maxTV;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.maxTV);
                                    if (textView3 != null) {
                                        i = R.id.mediumTV;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mediumTV);
                                        if (textView4 != null) {
                                            i = R.id.parentLL;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parentLL);
                                            if (relativeLayout2 != null) {
                                                i = R.id.spinnerLL;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.spinnerLL);
                                                if (relativeLayout3 != null) {
                                                    i = R.id.totalquestion;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalquestion);
                                                    if (textView5 != null) {
                                                        i = R.id.typeSpinner;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.typeSpinner);
                                                        if (textView6 != null) {
                                                            return new FragmentCreateTestThreeBinding((ScrollView) rootView, relativeLayout, button, imageView, editText, textView, linearLayout, textView2, textView3, textView4, relativeLayout2, relativeLayout3, textView5, textView6);
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
