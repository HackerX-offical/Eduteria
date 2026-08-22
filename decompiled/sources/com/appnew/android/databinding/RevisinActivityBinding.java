package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class RevisinActivityBinding implements ViewBinding {
    public final TextView addAonther;
    public final TextView addRevisionDialog;
    public final TextView delete;
    public final EditText descriptionEdittext;
    public final ImageView flashCardImg;
    public final CardView flashCards;
    public final LinearLayout frame;
    public final View holderView;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final ImageView mcqCardImg;
    public final CardView mcqCards;
    public final RelativeLayout questionLayout;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final TextView saveRevision;
    public final CheckBox selectAllDelete;
    public final EditText termsEdittext;
    public final TextView toolbarTitleTV;

    private RevisinActivityBinding(RelativeLayout rootView, TextView addAonther, TextView addRevisionDialog, TextView delete, EditText descriptionEdittext, ImageView flashCardImg, CardView flashCards, LinearLayout frame, View holderView, ImageView imageBack, Toolbar mainToolbar, ImageView mcqCardImg, CardView mcqCards, RelativeLayout questionLayout, RelativeLayout root, TextView saveRevision, CheckBox selectAllDelete, EditText termsEdittext, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.addAonther = addAonther;
        this.addRevisionDialog = addRevisionDialog;
        this.delete = delete;
        this.descriptionEdittext = descriptionEdittext;
        this.flashCardImg = flashCardImg;
        this.flashCards = flashCards;
        this.frame = frame;
        this.holderView = holderView;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.mcqCardImg = mcqCardImg;
        this.mcqCards = mcqCards;
        this.questionLayout = questionLayout;
        this.root = root;
        this.saveRevision = saveRevision;
        this.selectAllDelete = selectAllDelete;
        this.termsEdittext = termsEdittext;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevisinActivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RevisinActivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.revisin_activity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RevisinActivityBinding bind(View rootView) {
        int i = R.id.add_aonther;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_aonther);
        if (textView != null) {
            i = R.id.add_revision_dialog;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_revision_dialog);
            if (textView2 != null) {
                i = R.id.delete;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
                if (textView3 != null) {
                    i = R.id.description_edittext;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.description_edittext);
                    if (editText != null) {
                        i = R.id.flashCardImg;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.flashCardImg);
                        if (imageView != null) {
                            i = R.id.flashCards;
                            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.flashCards);
                            if (cardView != null) {
                                i = R.id.frame;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.frame);
                                if (linearLayout != null) {
                                    i = R.id.holderView;
                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.holderView);
                                    if (viewFindChildViewById != null) {
                                        i = R.id.image_back;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                                        if (imageView2 != null) {
                                            i = R.id.main_toolbar;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                            if (toolbar != null) {
                                                i = R.id.mcqCardImg;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.mcqCardImg);
                                                if (imageView3 != null) {
                                                    i = R.id.mcqCards;
                                                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.mcqCards);
                                                    if (cardView2 != null) {
                                                        i = R.id.question_layout;
                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.question_layout);
                                                        if (relativeLayout != null) {
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) rootView;
                                                            i = R.id.save_revision;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.save_revision);
                                                            if (textView4 != null) {
                                                                i = R.id.select_all_delete;
                                                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                                                                if (checkBox != null) {
                                                                    i = R.id.terms_edittext;
                                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.terms_edittext);
                                                                    if (editText2 != null) {
                                                                        i = R.id.toolbarTitleTV;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                        if (textView5 != null) {
                                                                            return new RevisinActivityBinding(relativeLayout2, textView, textView2, textView3, editText, imageView, cardView, linearLayout, viewFindChildViewById, imageView2, toolbar, imageView3, cardView2, relativeLayout, relativeLayout2, textView4, checkBox, editText2, textView5);
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
