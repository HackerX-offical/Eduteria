package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class HomeOurEducatorsItemBinding implements ViewBinding {
    public final RelativeLayout educatorExpRel;
    public final TextView educatorFullName;
    public final CircleImageView educatorProfileImage;
    public final RelativeLayout educatorsCard;
    private final RelativeLayout rootView;
    public final TextView teachingExp;

    private HomeOurEducatorsItemBinding(RelativeLayout rootView, RelativeLayout educatorExpRel, TextView educatorFullName, CircleImageView educatorProfileImage, RelativeLayout educatorsCard, TextView teachingExp) {
        this.rootView = rootView;
        this.educatorExpRel = educatorExpRel;
        this.educatorFullName = educatorFullName;
        this.educatorProfileImage = educatorProfileImage;
        this.educatorsCard = educatorsCard;
        this.teachingExp = teachingExp;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HomeOurEducatorsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HomeOurEducatorsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.home_our_educators_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HomeOurEducatorsItemBinding bind(View rootView) {
        int i = R.id.educatorExpRel;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.educatorExpRel);
        if (relativeLayout != null) {
            i = R.id.educatorFullName;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.educatorFullName);
            if (textView != null) {
                i = R.id.educatorProfileImage;
                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.educatorProfileImage);
                if (circleImageView != null) {
                    i = R.id.educatorsCard;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.educatorsCard);
                    if (relativeLayout2 != null) {
                        i = R.id.teachingExp;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.teachingExp);
                        if (textView2 != null) {
                            return new HomeOurEducatorsItemBinding((RelativeLayout) rootView, relativeLayout, textView, circleImageView, relativeLayout2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
