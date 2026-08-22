package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CropimageBinding implements ViewBinding {
    public final Button discard;
    public final View image;
    private final RelativeLayout rootView;
    public final ImageButton rotateLeft;
    public final ImageButton rotateRight;
    public final Button save;

    private CropimageBinding(RelativeLayout rootView, Button discard, View image, ImageButton rotateLeft, ImageButton rotateRight, Button save) {
        this.rootView = rootView;
        this.discard = discard;
        this.image = image;
        this.rotateLeft = rotateLeft;
        this.rotateRight = rotateRight;
        this.save = save;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CropimageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CropimageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.cropimage, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CropimageBinding bind(View rootView) {
        int i = R.id.discard;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.discard);
        if (button != null) {
            i = R.id.image;
            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.image);
            if (viewFindChildViewById != null) {
                i = R.id.rotateLeft;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.rotateLeft);
                if (imageButton != null) {
                    i = R.id.rotateRight;
                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.rotateRight);
                    if (imageButton2 != null) {
                        i = R.id.save;
                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.save);
                        if (button2 != null) {
                            return new CropimageBinding((RelativeLayout) rootView, button, viewFindChildViewById, imageButton, imageButton2, button2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
