package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogPopupBinding implements ViewBinding {
    public final TextView partATV;
    public final TextView partBTV;
    public final TextView partCTV;
    public final TextView partDTV;
    public final TextView partETV;
    public final TextView partFTV;
    public final TextView partGTV;
    public final TextView partHTV;
    public final TextView partITV;
    public final TextView partJTV;
    public final TextView partKTV;
    public final TextView partLTV;
    public final TextView partMTV;
    public final TextView partNTV;
    public final TextView partOTV;
    private final ScrollView rootView;
    public final View view1;
    public final View view10;
    public final View view11;
    public final View view12;
    public final View view13;
    public final View view14;
    public final View view15;
    public final View view2;
    public final View view3;
    public final View view4;
    public final View view5;
    public final View view6;
    public final View view7;
    public final View view8;
    public final View view9;

    private DialogPopupBinding(ScrollView rootView, TextView partATV, TextView partBTV, TextView partCTV, TextView partDTV, TextView partETV, TextView partFTV, TextView partGTV, TextView partHTV, TextView partITV, TextView partJTV, TextView partKTV, TextView partLTV, TextView partMTV, TextView partNTV, TextView partOTV, View view1, View view10, View view11, View view12, View view13, View view14, View view15, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9) {
        this.rootView = rootView;
        this.partATV = partATV;
        this.partBTV = partBTV;
        this.partCTV = partCTV;
        this.partDTV = partDTV;
        this.partETV = partETV;
        this.partFTV = partFTV;
        this.partGTV = partGTV;
        this.partHTV = partHTV;
        this.partITV = partITV;
        this.partJTV = partJTV;
        this.partKTV = partKTV;
        this.partLTV = partLTV;
        this.partMTV = partMTV;
        this.partNTV = partNTV;
        this.partOTV = partOTV;
        this.view1 = view1;
        this.view10 = view10;
        this.view11 = view11;
        this.view12 = view12;
        this.view13 = view13;
        this.view14 = view14;
        this.view15 = view15;
        this.view2 = view2;
        this.view3 = view3;
        this.view4 = view4;
        this.view5 = view5;
        this.view6 = view6;
        this.view7 = view7;
        this.view8 = view8;
        this.view9 = view9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static DialogPopupBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogPopupBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_popup, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogPopupBinding bind(View rootView) {
        int i = R.id.partATV;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.partATV);
        if (textView != null) {
            i = R.id.partBTV;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partBTV);
            if (textView2 != null) {
                i = R.id.partCTV;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partCTV);
                if (textView3 != null) {
                    i = R.id.partDTV;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partDTV);
                    if (textView4 != null) {
                        i = R.id.partETV;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partETV);
                        if (textView5 != null) {
                            i = R.id.partFTV;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partFTV);
                            if (textView6 != null) {
                                i = R.id.partGTV;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partGTV);
                                if (textView7 != null) {
                                    i = R.id.partHTV;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partHTV);
                                    if (textView8 != null) {
                                        i = R.id.partITV;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partITV);
                                        if (textView9 != null) {
                                            i = R.id.partJTV;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partJTV);
                                            if (textView10 != null) {
                                                i = R.id.partKTV;
                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partKTV);
                                                if (textView11 != null) {
                                                    i = R.id.partLTV;
                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partLTV);
                                                    if (textView12 != null) {
                                                        i = R.id.partMTV;
                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partMTV);
                                                        if (textView13 != null) {
                                                            i = R.id.partNTV;
                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partNTV);
                                                            if (textView14 != null) {
                                                                i = R.id.partOTV;
                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.partOTV);
                                                                if (textView15 != null) {
                                                                    i = R.id.view1;
                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                                                                    if (viewFindChildViewById != null) {
                                                                        i = R.id.view10;
                                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view10);
                                                                        if (viewFindChildViewById2 != null) {
                                                                            i = R.id.view11;
                                                                            View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view11);
                                                                            if (viewFindChildViewById3 != null) {
                                                                                i = R.id.view12;
                                                                                View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.view12);
                                                                                if (viewFindChildViewById4 != null) {
                                                                                    i = R.id.view13;
                                                                                    View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.view13);
                                                                                    if (viewFindChildViewById5 != null) {
                                                                                        i = R.id.view14;
                                                                                        View viewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.view14);
                                                                                        if (viewFindChildViewById6 != null) {
                                                                                            i = R.id.view15;
                                                                                            View viewFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.view15);
                                                                                            if (viewFindChildViewById7 != null) {
                                                                                                i = R.id.view2;
                                                                                                View viewFindChildViewById8 = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                                                if (viewFindChildViewById8 != null) {
                                                                                                    i = R.id.view3;
                                                                                                    View viewFindChildViewById9 = ViewBindings.findChildViewById(rootView, R.id.view3);
                                                                                                    if (viewFindChildViewById9 != null) {
                                                                                                        i = R.id.view4;
                                                                                                        View viewFindChildViewById10 = ViewBindings.findChildViewById(rootView, R.id.view4);
                                                                                                        if (viewFindChildViewById10 != null) {
                                                                                                            i = R.id.view5;
                                                                                                            View viewFindChildViewById11 = ViewBindings.findChildViewById(rootView, R.id.view5);
                                                                                                            if (viewFindChildViewById11 != null) {
                                                                                                                i = R.id.view6;
                                                                                                                View viewFindChildViewById12 = ViewBindings.findChildViewById(rootView, R.id.view6);
                                                                                                                if (viewFindChildViewById12 != null) {
                                                                                                                    i = R.id.view7;
                                                                                                                    View viewFindChildViewById13 = ViewBindings.findChildViewById(rootView, R.id.view7);
                                                                                                                    if (viewFindChildViewById13 != null) {
                                                                                                                        i = R.id.view8;
                                                                                                                        View viewFindChildViewById14 = ViewBindings.findChildViewById(rootView, R.id.view8);
                                                                                                                        if (viewFindChildViewById14 != null) {
                                                                                                                            i = R.id.view9;
                                                                                                                            View viewFindChildViewById15 = ViewBindings.findChildViewById(rootView, R.id.view9);
                                                                                                                            if (viewFindChildViewById15 != null) {
                                                                                                                                return new DialogPopupBinding((ScrollView) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7, viewFindChildViewById8, viewFindChildViewById9, viewFindChildViewById10, viewFindChildViewById11, viewFindChildViewById12, viewFindChildViewById13, viewFindChildViewById14, viewFindChildViewById15);
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
