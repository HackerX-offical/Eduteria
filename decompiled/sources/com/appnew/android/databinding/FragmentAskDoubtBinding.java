package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentAskDoubtBinding implements ViewBinding {
    public final RelativeLayout ISBNRL;
    public final LinearLayout UploadPdfImageAudio;
    public final LinearLayout addPdf;
    public final RelativeLayout allDataFillRL;
    public final RelativeLayout bookNoRelative;
    public final TextView bookNoTV;
    public final ImageView camScannerIV;
    public final CheckBox checkBoxDoubt;
    public final RelativeLayout checkbox;
    public final EditText comment;
    public final RelativeLayout commentRL;
    public final ImageView crossAudio;
    public final ImageView crossImage;
    public final ImageView crossPdf;
    public final ImageView deleteAudio;
    public final ImageView deleteImage;
    public final ImageView deletePdf;
    public final LinearLayout doubtImage;
    public final ImageView doubtSetAudio;
    public final ImageView doubtSetImage;
    public final ImageView doubtSetPdf;
    public final ImageView errorReportIcon;
    public final TextView errorTextId;
    public final EditText isbnTV;
    public final LinearLayout linearLayoutImages;
    public final RelativeLayout pageNoRelative;
    public final EditText pageNoTV;
    public final ProgressBar progressBarAudio;
    public final ProgressBar progressBarImage;
    public final ProgressBar progressBarPdf;
    public final LinearLayout progressRow;
    public final RelativeLayout questionNoRL;
    public final EditText questionNoTV;
    private final ScrollView rootView;
    public final ImageView spinnerIV;
    public final ImageView spinnerIVTopic;
    public final RelativeLayout subjectRL;
    public final TextView subjectTV;
    public final Button submitDoubt;
    public final RelativeLayout topic;
    public final TextView topicspinner;
    public final LinearLayout uploadAudio;
    public final RelativeLayout uploadAudioProgress;
    public final TextView uploadAudioTV;
    public final RelativeLayout uploadImage;
    public final TextView uploadImageTv;
    public final RelativeLayout uploadPdf;
    public final TextView uploadPdfTV;
    public final RelativeLayout uploadRl;

    private FragmentAskDoubtBinding(ScrollView rootView, RelativeLayout ISBNRL, LinearLayout UploadPdfImageAudio, LinearLayout addPdf, RelativeLayout allDataFillRL, RelativeLayout bookNoRelative, TextView bookNoTV, ImageView camScannerIV, CheckBox checkBoxDoubt, RelativeLayout checkbox, EditText comment, RelativeLayout commentRL, ImageView crossAudio, ImageView crossImage, ImageView crossPdf, ImageView deleteAudio, ImageView deleteImage, ImageView deletePdf, LinearLayout doubtImage, ImageView doubtSetAudio, ImageView doubtSetImage, ImageView doubtSetPdf, ImageView errorReportIcon, TextView errorTextId, EditText isbnTV, LinearLayout linearLayoutImages, RelativeLayout pageNoRelative, EditText pageNoTV, ProgressBar progressBarAudio, ProgressBar progressBarImage, ProgressBar progressBarPdf, LinearLayout progressRow, RelativeLayout questionNoRL, EditText questionNoTV, ImageView spinnerIV, ImageView spinnerIVTopic, RelativeLayout subjectRL, TextView subjectTV, Button submitDoubt, RelativeLayout topic, TextView topicspinner, LinearLayout uploadAudio, RelativeLayout uploadAudioProgress, TextView uploadAudioTV, RelativeLayout uploadImage, TextView uploadImageTv, RelativeLayout uploadPdf, TextView uploadPdfTV, RelativeLayout uploadRl) {
        this.rootView = rootView;
        this.ISBNRL = ISBNRL;
        this.UploadPdfImageAudio = UploadPdfImageAudio;
        this.addPdf = addPdf;
        this.allDataFillRL = allDataFillRL;
        this.bookNoRelative = bookNoRelative;
        this.bookNoTV = bookNoTV;
        this.camScannerIV = camScannerIV;
        this.checkBoxDoubt = checkBoxDoubt;
        this.checkbox = checkbox;
        this.comment = comment;
        this.commentRL = commentRL;
        this.crossAudio = crossAudio;
        this.crossImage = crossImage;
        this.crossPdf = crossPdf;
        this.deleteAudio = deleteAudio;
        this.deleteImage = deleteImage;
        this.deletePdf = deletePdf;
        this.doubtImage = doubtImage;
        this.doubtSetAudio = doubtSetAudio;
        this.doubtSetImage = doubtSetImage;
        this.doubtSetPdf = doubtSetPdf;
        this.errorReportIcon = errorReportIcon;
        this.errorTextId = errorTextId;
        this.isbnTV = isbnTV;
        this.linearLayoutImages = linearLayoutImages;
        this.pageNoRelative = pageNoRelative;
        this.pageNoTV = pageNoTV;
        this.progressBarAudio = progressBarAudio;
        this.progressBarImage = progressBarImage;
        this.progressBarPdf = progressBarPdf;
        this.progressRow = progressRow;
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
        this.uploadAudioProgress = uploadAudioProgress;
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

    public static FragmentAskDoubtBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentAskDoubtBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_ask_doubt, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAskDoubtBinding bind(View rootView) {
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
                        i = R.id.book_no_relative;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.book_no_relative);
                        if (relativeLayout3 != null) {
                            i = R.id.book_no_TV;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.book_no_TV);
                            if (textView != null) {
                                i = R.id.cam_scannerIV;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cam_scannerIV);
                                if (imageView != null) {
                                    i = R.id.checkBox_doubt;
                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.checkBox_doubt);
                                    if (checkBox != null) {
                                        i = R.id.checkbox;
                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.checkbox);
                                        if (relativeLayout4 != null) {
                                            i = R.id.comment;
                                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.comment);
                                            if (editText != null) {
                                                i = R.id.commentRL;
                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.commentRL);
                                                if (relativeLayout5 != null) {
                                                    i = R.id.crossAudio;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.crossAudio);
                                                    if (imageView2 != null) {
                                                        i = R.id.crossImage;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.crossImage);
                                                        if (imageView3 != null) {
                                                            i = R.id.crossPdf;
                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.crossPdf);
                                                            if (imageView4 != null) {
                                                                i = R.id.deleteAudio;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteAudio);
                                                                if (imageView5 != null) {
                                                                    i = R.id.deleteImage;
                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deleteImage);
                                                                    if (imageView6 != null) {
                                                                        i = R.id.deletePdf;
                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.deletePdf);
                                                                        if (imageView7 != null) {
                                                                            i = R.id.doubt_image;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doubt_image);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.doubt_setAudio;
                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doubt_setAudio);
                                                                                if (imageView8 != null) {
                                                                                    i = R.id.doubt_setImage;
                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doubt_setImage);
                                                                                    if (imageView9 != null) {
                                                                                        i = R.id.doubt_setPdf;
                                                                                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doubt_setPdf);
                                                                                        if (imageView10 != null) {
                                                                                            i = R.id.errorReportIcon;
                                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.errorReportIcon);
                                                                                            if (imageView11 != null) {
                                                                                                i = R.id.errorTextId;
                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.errorTextId);
                                                                                                if (textView2 != null) {
                                                                                                    i = R.id.isbnTV;
                                                                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.isbnTV);
                                                                                                    if (editText2 != null) {
                                                                                                        i = R.id.linearLayoutImages;
                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayoutImages);
                                                                                                        if (linearLayout4 != null) {
                                                                                                            i = R.id.page_no_relative;
                                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.page_no_relative);
                                                                                                            if (relativeLayout6 != null) {
                                                                                                                i = R.id.page_no_TV;
                                                                                                                EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.page_no_TV);
                                                                                                                if (editText3 != null) {
                                                                                                                    i = R.id.progressBarAudio;
                                                                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBarAudio);
                                                                                                                    if (progressBar != null) {
                                                                                                                        i = R.id.progressBarImage;
                                                                                                                        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBarImage);
                                                                                                                        if (progressBar2 != null) {
                                                                                                                            i = R.id.progressBarPdf;
                                                                                                                            ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBarPdf);
                                                                                                                            if (progressBar3 != null) {
                                                                                                                                i = R.id.progressRow;
                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.progressRow);
                                                                                                                                if (linearLayout5 != null) {
                                                                                                                                    i = R.id.question_no_RL;
                                                                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.question_no_RL);
                                                                                                                                    if (relativeLayout7 != null) {
                                                                                                                                        i = R.id.question_no_TV;
                                                                                                                                        EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.question_no_TV);
                                                                                                                                        if (editText4 != null) {
                                                                                                                                            i = R.id.spinnerIV;
                                                                                                                                            ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.spinnerIV);
                                                                                                                                            if (imageView12 != null) {
                                                                                                                                                i = R.id.spinnerIVTopic;
                                                                                                                                                ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.spinnerIVTopic);
                                                                                                                                                if (imageView13 != null) {
                                                                                                                                                    i = R.id.subjectRL;
                                                                                                                                                    RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.subjectRL);
                                                                                                                                                    if (relativeLayout8 != null) {
                                                                                                                                                        i = R.id.subjectTV;
                                                                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subjectTV);
                                                                                                                                                        if (textView3 != null) {
                                                                                                                                                            i = R.id.submit_doubt;
                                                                                                                                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submit_doubt);
                                                                                                                                                            if (button != null) {
                                                                                                                                                                i = R.id.topic;
                                                                                                                                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.topic);
                                                                                                                                                                if (relativeLayout9 != null) {
                                                                                                                                                                    i = R.id.topicspinner;
                                                                                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.topicspinner);
                                                                                                                                                                    if (textView4 != null) {
                                                                                                                                                                        i = R.id.upload_audio;
                                                                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.upload_audio);
                                                                                                                                                                        if (linearLayout6 != null) {
                                                                                                                                                                            i = R.id.upload_audio_progress;
                                                                                                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upload_audio_progress);
                                                                                                                                                                            if (relativeLayout10 != null) {
                                                                                                                                                                                i = R.id.uploadAudioTV;
                                                                                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadAudioTV);
                                                                                                                                                                                if (textView5 != null) {
                                                                                                                                                                                    i = R.id.upload_image;
                                                                                                                                                                                    RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upload_image);
                                                                                                                                                                                    if (relativeLayout11 != null) {
                                                                                                                                                                                        i = R.id.uploadImageTv;
                                                                                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadImageTv);
                                                                                                                                                                                        if (textView6 != null) {
                                                                                                                                                                                            i = R.id.upload_pdf;
                                                                                                                                                                                            RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upload_pdf);
                                                                                                                                                                                            if (relativeLayout12 != null) {
                                                                                                                                                                                                i = R.id.uploadPdfTV;
                                                                                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.uploadPdfTV);
                                                                                                                                                                                                if (textView7 != null) {
                                                                                                                                                                                                    i = R.id.upload_Rl;
                                                                                                                                                                                                    RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upload_Rl);
                                                                                                                                                                                                    if (relativeLayout13 != null) {
                                                                                                                                                                                                        return new FragmentAskDoubtBinding((ScrollView) rootView, relativeLayout, linearLayout, linearLayout2, relativeLayout2, relativeLayout3, textView, imageView, checkBox, relativeLayout4, editText, relativeLayout5, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout3, imageView8, imageView9, imageView10, imageView11, textView2, editText2, linearLayout4, relativeLayout6, editText3, progressBar, progressBar2, progressBar3, linearLayout5, relativeLayout7, editText4, imageView12, imageView13, relativeLayout8, textView3, button, relativeLayout9, textView4, linearLayout6, relativeLayout10, textView5, relativeLayout11, textView6, relativeLayout12, textView7, relativeLayout13);
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
