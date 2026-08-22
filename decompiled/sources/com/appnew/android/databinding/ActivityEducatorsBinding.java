package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityEducatorsBinding implements ViewBinding {
    public final TextView educatorExperienceTV;
    public final TextView educatorNameTV;
    public final CircleImageView educatorPicIV;
    public final RecyclerView educatorRecyclerView;
    public final FragmentContainerView fragmentContainerView;
    public final FrameLayout frameLayout;
    public final ImageView imageBack;
    public final RelativeLayout main;
    public final Toolbar mainToolbar;
    private final RelativeLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityEducatorsBinding(RelativeLayout rootView, TextView educatorExperienceTV, TextView educatorNameTV, CircleImageView educatorPicIV, RecyclerView educatorRecyclerView, FragmentContainerView fragmentContainerView, FrameLayout frameLayout, ImageView imageBack, RelativeLayout main, Toolbar mainToolbar, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.educatorExperienceTV = educatorExperienceTV;
        this.educatorNameTV = educatorNameTV;
        this.educatorPicIV = educatorPicIV;
        this.educatorRecyclerView = educatorRecyclerView;
        this.fragmentContainerView = fragmentContainerView;
        this.frameLayout = frameLayout;
        this.imageBack = imageBack;
        this.main = main;
        this.mainToolbar = mainToolbar;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityEducatorsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityEducatorsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_educators, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityEducatorsBinding bind(View rootView) {
        int i = R.id.educatorExperienceTV;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.educatorExperienceTV);
        if (textView != null) {
            i = R.id.educatorNameTV;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.educatorNameTV);
            if (textView2 != null) {
                i = R.id.educatorPicIV;
                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.educatorPicIV);
                if (circleImageView != null) {
                    i = R.id.educatorRecyclerView;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.educatorRecyclerView);
                    if (recyclerView != null) {
                        i = R.id.fragmentContainerView;
                        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(rootView, R.id.fragmentContainerView);
                        if (fragmentContainerView != null) {
                            i = R.id.frameLayout;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frameLayout);
                            if (frameLayout != null) {
                                i = R.id.image_back;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                                if (imageView != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                                    i = R.id.main_toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                    if (toolbar != null) {
                                        i = R.id.toolbarTitleTV;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                        if (textView3 != null) {
                                            return new ActivityEducatorsBinding(relativeLayout, textView, textView2, circleImageView, recyclerView, fragmentContainerView, frameLayout, imageView, relativeLayout, toolbar, textView3);
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
