package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class TextFormatterDialogLayoutBinding implements ViewBinding {
    public final AppCompatSeekBar brightnessSeekBar;
    public final Button darkbackbtn;
    public final View dividerView;
    public final View markBlack;
    public final View markWhite;
    private final RelativeLayout rootView;
    public final LinearLayout testSizeBtnLayout;
    public final FrameLayout textSizeDecrease;
    public final FrameLayout textSizeIncrease;
    public final RelativeLayout textformatterdialog;
    public final LinearLayout textsizelayout;
    public final Button whitebackbtn;

    private TextFormatterDialogLayoutBinding(RelativeLayout rootView, AppCompatSeekBar brightnessSeekBar, Button darkbackbtn, View dividerView, View markBlack, View markWhite, LinearLayout testSizeBtnLayout, FrameLayout textSizeDecrease, FrameLayout textSizeIncrease, RelativeLayout textformatterdialog, LinearLayout textsizelayout, Button whitebackbtn) {
        this.rootView = rootView;
        this.brightnessSeekBar = brightnessSeekBar;
        this.darkbackbtn = darkbackbtn;
        this.dividerView = dividerView;
        this.markBlack = markBlack;
        this.markWhite = markWhite;
        this.testSizeBtnLayout = testSizeBtnLayout;
        this.textSizeDecrease = textSizeDecrease;
        this.textSizeIncrease = textSizeIncrease;
        this.textformatterdialog = textformatterdialog;
        this.textsizelayout = textsizelayout;
        this.whitebackbtn = whitebackbtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TextFormatterDialogLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TextFormatterDialogLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.text_formatter_dialog_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TextFormatterDialogLayoutBinding bind(View rootView) {
        int i = R.id.brightnessSeekBar;
        AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) ViewBindings.findChildViewById(rootView, R.id.brightnessSeekBar);
        if (appCompatSeekBar != null) {
            i = R.id.darkbackbtn;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.darkbackbtn);
            if (button != null) {
                i = R.id.dividerView;
                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.dividerView);
                if (viewFindChildViewById != null) {
                    i = R.id.markBlack;
                    View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.markBlack);
                    if (viewFindChildViewById2 != null) {
                        i = R.id.markWhite;
                        View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.markWhite);
                        if (viewFindChildViewById3 != null) {
                            i = R.id.testSizeBtnLayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.testSizeBtnLayout);
                            if (linearLayout != null) {
                                i = R.id.textSizeDecrease;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.textSizeDecrease);
                                if (frameLayout != null) {
                                    i = R.id.textSizeIncrease;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.textSizeIncrease);
                                    if (frameLayout2 != null) {
                                        RelativeLayout relativeLayout = (RelativeLayout) rootView;
                                        i = R.id.textsizelayout;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.textsizelayout);
                                        if (linearLayout2 != null) {
                                            i = R.id.whitebackbtn;
                                            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.whitebackbtn);
                                            if (button2 != null) {
                                                return new TextFormatterDialogLayoutBinding(relativeLayout, appCompatSeekBar, button, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, linearLayout, frameLayout, frameLayout2, relativeLayout, linearLayout2, button2);
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
