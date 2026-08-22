package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentLanguageBinding implements ViewBinding {
    public final TextView choseTxt;
    public final ImageView englishImg;
    public final ImageView hindiImg;
    public final ImageView icGroup;
    private final RelativeLayout rootView;
    public final TextView selectTxt;

    private FragmentLanguageBinding(RelativeLayout rootView, TextView choseTxt, ImageView englishImg, ImageView hindiImg, ImageView icGroup, TextView selectTxt) {
        this.rootView = rootView;
        this.choseTxt = choseTxt;
        this.englishImg = englishImg;
        this.hindiImg = hindiImg;
        this.icGroup = icGroup;
        this.selectTxt = selectTxt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLanguageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentLanguageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_language, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentLanguageBinding bind(View rootView) {
        int i = R.id.chose_txt;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.chose_txt);
        if (textView != null) {
            i = R.id.english_img;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.english_img);
            if (imageView != null) {
                i = R.id.hindi_img;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.hindi_img);
                if (imageView2 != null) {
                    i = R.id.ic_group;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ic_group);
                    if (imageView3 != null) {
                        i = R.id.select_txt;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.select_txt);
                        if (textView2 != null) {
                            return new FragmentLanguageBinding((RelativeLayout) rootView, textView, imageView, imageView2, imageView3, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
