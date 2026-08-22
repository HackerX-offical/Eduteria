package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class NewDishaFragmentBinding implements ViewBinding {
    public final RelativeLayout ISBNRL;
    public final LinearLayout UploadPdfImageAudio;
    public final LinearLayout addPdf;
    public final RelativeLayout allDataFillRL;
    public final ImageView camScannerIV;
    public final CheckBox checkBoxDoubt;
    public final RelativeLayout checkbox;
    public final EditText comment;
    public final RelativeLayout commentRL;
    public final TextView isbnTV;
    public final LinearLayout linearLayoutImages;
    public final RelativeLayout pageNoRelative;
    public final TextView pageNoTV;
    public final RelativeLayout questionNoRL;
    public final TextView questionNoTV;
    private final ScrollView rootView;
    public final ImageView spinnerIV;
    public final ImageView spinnerIVTopic;
    public final RelativeLayout subjectRL;
    public final TextView subjectTV;
    public final Button submitDoubt;
    public final RelativeLayout topic;
    public final TextView topicspinner;
    public final RelativeLayout uploadAudio;
    public final TextView uploadAudioTV;
    public final RelativeLayout uploadImage;
    public final TextView uploadImageTv;
    public final RelativeLayout uploadPdf;
    public final TextView uploadPdfTV;
    public final RelativeLayout uploadRl;

    private NewDishaFragmentBinding(ScrollView rootView, RelativeLayout ISBNRL, LinearLayout UploadPdfImageAudio, LinearLayout addPdf, RelativeLayout allDataFillRL, ImageView camScannerIV, CheckBox checkBoxDoubt, RelativeLayout checkbox, EditText comment, RelativeLayout commentRL, TextView isbnTV, LinearLayout linearLayoutImages, RelativeLayout pageNoRelative, TextView pageNoTV, RelativeLayout questionNoRL, TextView questionNoTV, ImageView spinnerIV, ImageView spinnerIVTopic, RelativeLayout subjectRL, TextView subjectTV, Button submitDoubt, RelativeLayout topic, TextView topicspinner, RelativeLayout uploadAudio, TextView uploadAudioTV, RelativeLayout uploadImage, TextView uploadImageTv, RelativeLayout uploadPdf, TextView uploadPdfTV, RelativeLayout uploadRl) {
        this.rootView = rootView;
        this.ISBNRL = ISBNRL;
        this.UploadPdfImageAudio = UploadPdfImageAudio;
        this.addPdf = addPdf;
        this.allDataFillRL = allDataFillRL;
        this.camScannerIV = camScannerIV;
        this.checkBoxDoubt = checkBoxDoubt;
        this.checkbox = checkbox;
        this.comment = comment;
        this.commentRL = commentRL;
        this.isbnTV = isbnTV;
        this.linearLayoutImages = linearLayoutImages;
        this.pageNoRelative = pageNoRelative;
        this.pageNoTV = pageNoTV;
        this.questionNoRL = questionNoRL;
        this.questionNoTV = questionNoTV;
        this.spinnerIV = spinnerIV;
        this.spinnerIVTopic = spinnerIVTopic;
        this.subjectRL = subjectRL;
        this.subjectTV = subjectTV;
        this.submitDoubt = submitDoubt;
        this.topic = topic;
        this.topicspinner = topicspinner;
        this.uploadAudio = uploadAudio;
        this.uploadAudioTV = uploadAudioTV;
        this.uploadImage = uploadImage;
        this.uploadImageTv = uploadImageTv;
        this.uploadPdf = uploadPdf;
        this.uploadPdfTV = uploadPdfTV;
        this.uploadRl = uploadRl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static NewDishaFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NewDishaFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.new_disha_fragment, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NewDishaFragmentBinding bind(View rootView) {
        int i = R.id.ISBNRL;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ISBNRL);
        if (relativeLayout != null) {
            i = R.id.Upload_pdf_image_audio;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Upload_pdf_image_audio);
            if (linearLayout != null) {
                i = R.id.add_pdf;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.add_pdf);
                if (linearLayout2 != null) {
                    i = R.id.all_data_fillRL;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.all_data_fillRL);
                    if (relativeLayout2 != null) {
                        i = R.id.cam_scannerIV;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cam_scannerIV);
                        if (imageView != null) {
                            i = R.id.checkBox_doubt;
                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.checkBox_doubt);
                            if (checkBox != null) {
                                i = R.id.checkbox;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.checkbox);
                                if (relativeLayout3 != null) {
                                    i = R.id.comment;
                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.comment);
                                    if (editText != null) {
                                        i = R.id.commentRL;
                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.commentRL);
                                        if (relativeLayout4 != null) {
                                            i = R.id.isbnTV;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.isbnTV);
                                            if (textView != null) {
                                                i = R.id.linearLayoutImages;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayoutImages);
                                                if (linearLayout3 != null) {
                                                    i = R.id.page_no_relative;
                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.page_no_relative);
                                                    if (relativeLayout5 != null) {
                                                        i = R.id.page_no_TV;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.page_no_TV);
                                                        if (textView2 != null) {
                                                            i = R.id.question_no_RL;
                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.question_no_RL);
                                                            if (relativeLayout6 != null) {
                                                                i = R.id.question_no_TV;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.question_no_TV);
                                                                if (textView3 != null) {
                                                                    i = R.id.spinnerIV;
                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.spinnerIV);
                                                                    if (imageView2 != null) {
                                                                        i = R.id.spinnerIVTopic;
                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.spinnerIVTopic);
                                                                        if (imageView3 != null) {
                                                                            i = R.id.subjectRL;
                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.subjectRL);
                                                                            if (relativeLayout7 != null) {
                                                                                i = R.id.subjectTV;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subjectTV);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.submit_doubt;
                                                                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submit_doubt);
                                                                                    if (button != null) {
                                                                                        i = R.id.topic;
                                                                                        RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.topic);
                                                                                        if (relativeLayout8 != null) {
                                                                                            i = R.id.topicspinner;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.topicspinner);
                                                                                            if (textView5 != null) {
                                                                                                i = R.id.upload_audio;
                                                                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upload_audio);
                                                                                                if (relativeLayout9 != null) {
                                                                                                    i = R.id.uploadAudioTV;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadAudioTV);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.upload_image;
                                                                                                        RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upload_image);
                                                                                                        if (relativeLayout10 != null) {
                                                                                                            i = R.id.uploadImageTv;
                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadImageTv);
                                                                                                            if (textView7 != null) {
                                                                                                                i = R.id.upload_pdf;
                                                                                                                RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upload_pdf);
                                                                                                                if (relativeLayout11 != null) {
                                                                                                                    i = R.id.uploadPdfTV;
                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadPdfTV);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i = R.id.upload_Rl;
                                                                                                                        RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upload_Rl);
                                                                                                                        if (relativeLayout12 != null) {
                                                                                                                            return new NewDishaFragmentBinding((ScrollView) rootView, relativeLayout, linearLayout, linearLayout2, relativeLayout2, imageView, checkBox, relativeLayout3, editText, relativeLayout4, textView, linearLayout3, relativeLayout5, textView2, relativeLayout6, textView3, imageView2, imageView3, relativeLayout7, textView4, button, relativeLayout8, textView5, relativeLayout9, textView6, relativeLayout10, textView7, relativeLayout11, textView8, relativeLayout12);
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
