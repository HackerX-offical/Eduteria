package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ChallengeDialogBinding implements ViewBinding {
    public final Button btnSubmit;
    public final EditText editQuery;
    public final ImageView imgCrossFile;
    public final ImageView imgFileAttached;
    public final LinearLayout layoutFileAttach;
    public final RelativeLayout layoutFileDetail;
    private final LinearLayout rootView;
    public final TextView txtFileName;
    public final TextView txtFileSize;
    public final ImageView txtResume;
    public final TextView txtTapAddNote;

    private ChallengeDialogBinding(LinearLayout rootView, Button btnSubmit, EditText editQuery, ImageView imgCrossFile, ImageView imgFileAttached, LinearLayout layoutFileAttach, RelativeLayout layoutFileDetail, TextView txtFileName, TextView txtFileSize, ImageView txtResume, TextView txtTapAddNote) {
        this.rootView = rootView;
        this.btnSubmit = btnSubmit;
        this.editQuery = editQuery;
        this.imgCrossFile = imgCrossFile;
        this.imgFileAttached = imgFileAttached;
        this.layoutFileAttach = layoutFileAttach;
        this.layoutFileDetail = layoutFileDetail;
        this.txtFileName = txtFileName;
        this.txtFileSize = txtFileSize;
        this.txtResume = txtResume;
        this.txtTapAddNote = txtTapAddNote;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ChallengeDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChallengeDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.challenge_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChallengeDialogBinding bind(View rootView) {
        int i = R.id.btn_submit;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
        if (button != null) {
            i = R.id.edit_query;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.edit_query);
            if (editText != null) {
                i = R.id.img_crossFile;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_crossFile);
                if (imageView != null) {
                    i = R.id.img_fileAttached;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_fileAttached);
                    if (imageView2 != null) {
                        i = R.id.layout_fileAttach;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_fileAttach);
                        if (linearLayout != null) {
                            i = R.id.layout_fileDetail;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout_fileDetail);
                            if (relativeLayout != null) {
                                i = R.id.txt_fileName;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_fileName);
                                if (textView != null) {
                                    i = R.id.txt_fileSize;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_fileSize);
                                    if (textView2 != null) {
                                        i = R.id.txt_resume;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.txt_resume);
                                        if (imageView3 != null) {
                                            i = R.id.txt_tapAddNote;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_tapAddNote);
                                            if (textView3 != null) {
                                                return new ChallengeDialogBinding((LinearLayout) rootView, button, editText, imageView, imageView2, linearLayout, relativeLayout, textView, textView2, imageView3, textView3);
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
