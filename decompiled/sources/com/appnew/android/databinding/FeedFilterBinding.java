package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FeedFilterBinding implements ViewBinding {
    public final ImageView cancel;
    public final Button filterdata;
    public final ImageView launguageIV;
    public final RelativeLayout posttype;
    public final TextView posttypeytext;
    public final RelativeLayout rl1;
    public final RelativeLayout rl2;
    private final RelativeLayout rootView;
    public final ImageView spinnerIV;
    public final RelativeLayout subcat;
    public final TextView subcatspinner;
    public final TextView txt1;
    public final TextView txt2;
    public final TextView txt3;

    private FeedFilterBinding(RelativeLayout rootView, ImageView cancel, Button filterdata, ImageView launguageIV, RelativeLayout posttype, TextView posttypeytext, RelativeLayout rl1, RelativeLayout rl2, ImageView spinnerIV, RelativeLayout subcat, TextView subcatspinner, TextView txt1, TextView txt2, TextView txt3) {
        this.rootView = rootView;
        this.cancel = cancel;
        this.filterdata = filterdata;
        this.launguageIV = launguageIV;
        this.posttype = posttype;
        this.posttypeytext = posttypeytext;
        this.rl1 = rl1;
        this.rl2 = rl2;
        this.spinnerIV = spinnerIV;
        this.subcat = subcat;
        this.subcatspinner = subcatspinner;
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.txt3 = txt3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FeedFilterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FeedFilterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.feed_filter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FeedFilterBinding bind(View rootView) {
        int i = R.id.cancel;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel);
        if (imageView != null) {
            i = R.id.filterdata;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.filterdata);
            if (button != null) {
                i = R.id.launguageIV;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.launguageIV);
                if (imageView2 != null) {
                    i = R.id.posttype;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.posttype);
                    if (relativeLayout != null) {
                        i = R.id.posttypeytext;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.posttypeytext);
                        if (textView != null) {
                            i = R.id.rl1;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl1);
                            if (relativeLayout2 != null) {
                                i = R.id.rl2;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl2);
                                if (relativeLayout3 != null) {
                                    i = R.id.spinnerIV;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.spinnerIV);
                                    if (imageView3 != null) {
                                        i = R.id.subcat;
                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.subcat);
                                        if (relativeLayout4 != null) {
                                            i = R.id.subcatspinner;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subcatspinner);
                                            if (textView2 != null) {
                                                i = R.id.txt1;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt1);
                                                if (textView3 != null) {
                                                    i = R.id.txt2;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt2);
                                                    if (textView4 != null) {
                                                        i = R.id.txt3;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt3);
                                                        if (textView5 != null) {
                                                            return new FeedFilterBinding((RelativeLayout) rootView, imageView, button, imageView2, relativeLayout, textView, relativeLayout2, relativeLayout3, imageView3, relativeLayout4, textView2, textView3, textView4, textView5);
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
