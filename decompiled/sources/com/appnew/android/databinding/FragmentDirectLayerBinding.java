package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentDirectLayerBinding implements ViewBinding {
    public final TextView authorname;
    public final ImageView courseImagebg;
    public final TextView courseName;
    public final TextView courseid;
    public final RelativeLayout headerLL;
    public final LinearLayout imageRL;
    private final RelativeLayout rootView;
    public final RecyclerView studyCourseRV;
    public final LinearLayout tileLL;
    public final RecyclerView tileRv;
    public final TextView type;
    public final TextView validityTV;

    private FragmentDirectLayerBinding(RelativeLayout rootView, TextView authorname, ImageView courseImagebg, TextView courseName, TextView courseid, RelativeLayout headerLL, LinearLayout imageRL, RecyclerView studyCourseRV, LinearLayout tileLL, RecyclerView tileRv, TextView type, TextView validityTV) {
        this.rootView = rootView;
        this.authorname = authorname;
        this.courseImagebg = courseImagebg;
        this.courseName = courseName;
        this.courseid = courseid;
        this.headerLL = headerLL;
        this.imageRL = imageRL;
        this.studyCourseRV = studyCourseRV;
        this.tileLL = tileLL;
        this.tileRv = tileRv;
        this.type = type;
        this.validityTV = validityTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDirectLayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentDirectLayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_direct_layer, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDirectLayerBinding bind(View rootView) {
        int i = R.id.authorname;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.authorname);
        if (textView != null) {
            i = R.id.courseImagebg;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImagebg);
            if (imageView != null) {
                i = R.id.course_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_name);
                if (textView2 != null) {
                    i = R.id.courseid;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseid);
                    if (textView3 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) rootView;
                        i = R.id.imageRL;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                        if (linearLayout != null) {
                            i = R.id.studyCourseRV;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.studyCourseRV);
                            if (recyclerView != null) {
                                i = R.id.tileLL;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.tileLL);
                                if (linearLayout2 != null) {
                                    i = R.id.tileRv;
                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tileRv);
                                    if (recyclerView2 != null) {
                                        i = R.id.type;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.type);
                                        if (textView4 != null) {
                                            i = R.id.validityTV;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTV);
                                            if (textView5 != null) {
                                                return new FragmentDirectLayerBinding(relativeLayout, textView, imageView, textView2, textView3, relativeLayout, linearLayout, recyclerView, linearLayout2, recyclerView2, textView4, textView5);
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
