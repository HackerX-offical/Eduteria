package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DoubtLayoutItemBinding implements ViewBinding {
    public final TextView SubjectName;
    public final TextView SubjectStatus;
    public final TextView bookNameText;
    public final TextView dateTime;
    public final TextView doubtFeedback;
    public final LinearLayout isbnLayout;
    public final View isbnLineId;
    public final LinearLayout linearLayoutAudio;
    public final LinearLayout linearLayoutImage;
    public final LinearLayout linearLayoutPdf;
    public final TextView pageNoText;
    public final TextView questionNoText;
    public final TextView replayChat;
    public final TextView replayMsg;
    public final RelativeLayout rlAboveIsbn;
    public final RelativeLayout rlImg;
    public final LinearLayout rlReplyOrStatus;
    private final ConstraintLayout rootView;
    public final TextView userComment;
    public final ImageView userDoubtAudio;
    public final ImageView userDoubtImage;
    public final ImageView userDoubtPdf;
    public final TextView userName;

    private DoubtLayoutItemBinding(ConstraintLayout rootView, TextView SubjectName, TextView SubjectStatus, TextView bookNameText, TextView dateTime, TextView doubtFeedback, LinearLayout isbnLayout, View isbnLineId, LinearLayout linearLayoutAudio, LinearLayout linearLayoutImage, LinearLayout linearLayoutPdf, TextView pageNoText, TextView questionNoText, TextView replayChat, TextView replayMsg, RelativeLayout rlAboveIsbn, RelativeLayout rlImg, LinearLayout rlReplyOrStatus, TextView userComment, ImageView userDoubtAudio, ImageView userDoubtImage, ImageView userDoubtPdf, TextView userName) {
        this.rootView = rootView;
        this.SubjectName = SubjectName;
        this.SubjectStatus = SubjectStatus;
        this.bookNameText = bookNameText;
        this.dateTime = dateTime;
        this.doubtFeedback = doubtFeedback;
        this.isbnLayout = isbnLayout;
        this.isbnLineId = isbnLineId;
        this.linearLayoutAudio = linearLayoutAudio;
        this.linearLayoutImage = linearLayoutImage;
        this.linearLayoutPdf = linearLayoutPdf;
        this.pageNoText = pageNoText;
        this.questionNoText = questionNoText;
        this.replayChat = replayChat;
        this.replayMsg = replayMsg;
        this.rlAboveIsbn = rlAboveIsbn;
        this.rlImg = rlImg;
        this.rlReplyOrStatus = rlReplyOrStatus;
        this.userComment = userComment;
        this.userDoubtAudio = userDoubtAudio;
        this.userDoubtImage = userDoubtImage;
        this.userDoubtPdf = userDoubtPdf;
        this.userName = userName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DoubtLayoutItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DoubtLayoutItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.doubt_layout_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DoubtLayoutItemBinding bind(View rootView) {
        int i = R.id.Subject_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.Subject_name);
        if (textView != null) {
            i = R.id.Subject_status;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Subject_status);
            if (textView2 != null) {
                i = R.id.bookNameText;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bookNameText);
                if (textView3 != null) {
                    i = R.id.date_time;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_time);
                    if (textView4 != null) {
                        i = R.id.doubtFeedback;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doubtFeedback);
                        if (textView5 != null) {
                            i = R.id.isbnLayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.isbnLayout);
                            if (linearLayout != null) {
                                i = R.id.isbnLineId;
                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.isbnLineId);
                                if (viewFindChildViewById != null) {
                                    i = R.id.linearLayoutAudio;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayoutAudio);
                                    if (linearLayout2 != null) {
                                        i = R.id.linearLayoutImage;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayoutImage);
                                        if (linearLayout3 != null) {
                                            i = R.id.linearLayoutPdf;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayoutPdf);
                                            if (linearLayout4 != null) {
                                                i = R.id.pageNoText;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pageNoText);
                                                if (textView6 != null) {
                                                    i = R.id.questionNoText;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.questionNoText);
                                                    if (textView7 != null) {
                                                        i = R.id.replayChat;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.replayChat);
                                                        if (textView8 != null) {
                                                            i = R.id.replayMsg;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.replayMsg);
                                                            if (textView9 != null) {
                                                                i = R.id.rl_above_isbn;
                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_above_isbn);
                                                                if (relativeLayout != null) {
                                                                    i = R.id.rl_img;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_img);
                                                                    if (relativeLayout2 != null) {
                                                                        i = R.id.rl_reply_or_status;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rl_reply_or_status);
                                                                        if (linearLayout5 != null) {
                                                                            i = R.id.user_comment;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.user_comment);
                                                                            if (textView10 != null) {
                                                                                i = R.id.user_doubtAudio;
                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.user_doubtAudio);
                                                                                if (imageView != null) {
                                                                                    i = R.id.user_doubtImage;
                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.user_doubtImage);
                                                                                    if (imageView2 != null) {
                                                                                        i = R.id.user_doubtPdf;
                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.user_doubtPdf);
                                                                                        if (imageView3 != null) {
                                                                                            i = R.id.user_name;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.user_name);
                                                                                            if (textView11 != null) {
                                                                                                return new DoubtLayoutItemBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, textView5, linearLayout, viewFindChildViewById, linearLayout2, linearLayout3, linearLayout4, textView6, textView7, textView8, textView9, relativeLayout, relativeLayout2, linearLayout5, textView10, imageView, imageView2, imageView3, textView11);
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
