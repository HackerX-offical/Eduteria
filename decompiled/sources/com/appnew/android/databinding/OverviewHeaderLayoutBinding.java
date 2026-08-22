package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class OverviewHeaderLayoutBinding implements ViewBinding {
    public final LinearLayout bookidLL;
    public final LinearLayout ceoOneLL;
    public final WebView ceoTwoTV;
    public final TextView courseid;
    public final LinearLayout descMainLL;
    public final WebView descriptionOneTV;
    public final TextView engTextView;
    public final TextView hindiTextView;
    public final LinearLayout relatedCoursesLL;
    public final RecyclerView relatedCoursesRv;
    private final LinearLayout rootView;
    public final LinearLayout signInUpLayout;
    public final TextView titleOneTV;

    private OverviewHeaderLayoutBinding(LinearLayout rootView, LinearLayout bookidLL, LinearLayout ceoOneLL, WebView ceoTwoTV, TextView courseid, LinearLayout descMainLL, WebView descriptionOneTV, TextView engTextView, TextView hindiTextView, LinearLayout relatedCoursesLL, RecyclerView relatedCoursesRv, LinearLayout signInUpLayout, TextView titleOneTV) {
        this.rootView = rootView;
        this.bookidLL = bookidLL;
        this.ceoOneLL = ceoOneLL;
        this.ceoTwoTV = ceoTwoTV;
        this.courseid = courseid;
        this.descMainLL = descMainLL;
        this.descriptionOneTV = descriptionOneTV;
        this.engTextView = engTextView;
        this.hindiTextView = hindiTextView;
        this.relatedCoursesLL = relatedCoursesLL;
        this.relatedCoursesRv = relatedCoursesRv;
        this.signInUpLayout = signInUpLayout;
        this.titleOneTV = titleOneTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static OverviewHeaderLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static OverviewHeaderLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.overview_header_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static OverviewHeaderLayoutBinding bind(View rootView) {
        int i = R.id.bookidLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bookidLL);
        if (linearLayout != null) {
            i = R.id.ceoOneLL;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ceoOneLL);
            if (linearLayout2 != null) {
                i = R.id.ceoTwoTV;
                WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.ceoTwoTV);
                if (webView != null) {
                    i = R.id.courseid;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseid);
                    if (textView != null) {
                        i = R.id.descMainLL;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.descMainLL);
                        if (linearLayout3 != null) {
                            i = R.id.descriptionOneTV;
                            WebView webView2 = (WebView) ViewBindings.findChildViewById(rootView, R.id.descriptionOneTV);
                            if (webView2 != null) {
                                i = R.id.engTextView;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.engTextView);
                                if (textView2 != null) {
                                    i = R.id.hindiTextView;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.hindiTextView);
                                    if (textView3 != null) {
                                        i = R.id.relatedCoursesLL;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.relatedCoursesLL);
                                        if (linearLayout4 != null) {
                                            i = R.id.relatedCoursesRv;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.relatedCoursesRv);
                                            if (recyclerView != null) {
                                                i = R.id.signInUpLayout;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.signInUpLayout);
                                                if (linearLayout5 != null) {
                                                    i = R.id.titleOneTV;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleOneTV);
                                                    if (textView4 != null) {
                                                        return new OverviewHeaderLayoutBinding((LinearLayout) rootView, linearLayout, linearLayout2, webView, textView, linearLayout3, webView2, textView2, textView3, linearLayout4, recyclerView, linearLayout5, textView4);
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
