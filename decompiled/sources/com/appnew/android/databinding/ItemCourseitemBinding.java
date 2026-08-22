package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemCourseitemBinding implements ViewBinding {
    public final RelativeLayout cvr;
    public final TextView desc;
    public final Button live;
    public final LinearLayout main;
    private final LinearLayout rootView;
    public final CircleImageView subjectImage;
    public final TextView title;
    public final CardView topCV;

    private ItemCourseitemBinding(LinearLayout rootView, RelativeLayout cvr, TextView desc, Button live, LinearLayout main, CircleImageView subjectImage, TextView title, CardView topCV) {
        this.rootView = rootView;
        this.cvr = cvr;
        this.desc = desc;
        this.live = live;
        this.main = main;
        this.subjectImage = subjectImage;
        this.title = title;
        this.topCV = topCV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemCourseitemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemCourseitemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_courseitem, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemCourseitemBinding bind(View rootView) {
        int i = R.id.cvr;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvr);
        if (relativeLayout != null) {
            i = R.id.desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.desc);
            if (textView != null) {
                i = R.id.live;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.live);
                if (button != null) {
                    LinearLayout linearLayout = (LinearLayout) rootView;
                    i = R.id.subjectImage;
                    CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.subjectImage);
                    if (circleImageView != null) {
                        i = R.id.title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                        if (textView2 != null) {
                            i = R.id.topCV;
                            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.topCV);
                            if (cardView != null) {
                                return new ItemCourseitemBinding(linearLayout, relativeLayout, textView, button, linearLayout, circleImageView, textView2, cardView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
