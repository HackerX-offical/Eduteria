package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class HomeStdFeedbackItemBinding implements ViewBinding {
    public final LinearLayout feedbackTxtLay0;
    public final LinearLayout feedbackTxtLay1;
    public final CardView homeStdFeedBackCard;
    public final TextView homeStdFeedBackFeedbackTxt;
    public final CircleImageView homeStdFeedBackTeacherImage;
    public final TextView homeStdFeedBackTeacherName;
    private final CardView rootView;
    public final ImageView testimonialvideo;

    private HomeStdFeedbackItemBinding(CardView rootView, LinearLayout feedbackTxtLay0, LinearLayout feedbackTxtLay1, CardView homeStdFeedBackCard, TextView homeStdFeedBackFeedbackTxt, CircleImageView homeStdFeedBackTeacherImage, TextView homeStdFeedBackTeacherName, ImageView testimonialvideo) {
        this.rootView = rootView;
        this.feedbackTxtLay0 = feedbackTxtLay0;
        this.feedbackTxtLay1 = feedbackTxtLay1;
        this.homeStdFeedBackCard = homeStdFeedBackCard;
        this.homeStdFeedBackFeedbackTxt = homeStdFeedBackFeedbackTxt;
        this.homeStdFeedBackTeacherImage = homeStdFeedBackTeacherImage;
        this.homeStdFeedBackTeacherName = homeStdFeedBackTeacherName;
        this.testimonialvideo = testimonialvideo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static HomeStdFeedbackItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HomeStdFeedbackItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.home_std_feedback_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HomeStdFeedbackItemBinding bind(View rootView) {
        int i = R.id.feedbackTxtLay0;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.feedbackTxtLay0);
        if (linearLayout != null) {
            i = R.id.feedbackTxtLay1;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.feedbackTxtLay1);
            if (linearLayout2 != null) {
                CardView cardView = (CardView) rootView;
                i = R.id.home_stdFeedBack_feedbackTxt;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.home_stdFeedBack_feedbackTxt);
                if (textView != null) {
                    i = R.id.home_stdFeedBack_teacherImage;
                    CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.home_stdFeedBack_teacherImage);
                    if (circleImageView != null) {
                        i = R.id.home_stdFeedBack_teacherName;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.home_stdFeedBack_teacherName);
                        if (textView2 != null) {
                            i = R.id.testimonialvideo;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.testimonialvideo);
                            if (imageView != null) {
                                return new HomeStdFeedbackItemBinding(cardView, linearLayout, linearLayout2, cardView, textView, circleImageView, textView2, imageView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
