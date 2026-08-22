package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomDoubtLayoutBinding implements ViewBinding {
    public final TextView SubjectName;
    public final TextView SubjectStatus;
    public final TextView dateTime;
    public final LinearLayout linearLayoutAudio;
    public final TextView replayChat;
    public final TextView replayMsg;
    private final ConstraintLayout rootView;
    public final TextView userComment;
    public final ImageView userDoubtAudio;
    public final ImageView userDoubtImage;
    public final TextView userName;

    private CustomDoubtLayoutBinding(ConstraintLayout rootView, TextView SubjectName, TextView SubjectStatus, TextView dateTime, LinearLayout linearLayoutAudio, TextView replayChat, TextView replayMsg, TextView userComment, ImageView userDoubtAudio, ImageView userDoubtImage, TextView userName) {
        this.rootView = rootView;
        this.SubjectName = SubjectName;
        this.SubjectStatus = SubjectStatus;
        this.dateTime = dateTime;
        this.linearLayoutAudio = linearLayoutAudio;
        this.replayChat = replayChat;
        this.replayMsg = replayMsg;
        this.userComment = userComment;
        this.userDoubtAudio = userDoubtAudio;
        this.userDoubtImage = userDoubtImage;
        this.userName = userName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CustomDoubtLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomDoubtLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_doubt_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomDoubtLayoutBinding bind(View rootView) {
        int i = R.id.Subject_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.Subject_name);
        if (textView != null) {
            i = R.id.Subject_status;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Subject_status);
            if (textView2 != null) {
                i = R.id.date_time;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_time);
                if (textView3 != null) {
                    i = R.id.linearLayoutAudio;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayoutAudio);
                    if (linearLayout != null) {
                        i = R.id.replayChat;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.replayChat);
                        if (textView4 != null) {
                            i = R.id.replayMsg;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.replayMsg);
                            if (textView5 != null) {
                                i = R.id.user_comment;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.user_comment);
                                if (textView6 != null) {
                                    i = R.id.user_doubtAudio;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.user_doubtAudio);
                                    if (imageView != null) {
                                        i = R.id.user_doubt_image;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.user_doubt_image);
                                        if (imageView2 != null) {
                                            i = R.id.user_name;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.user_name);
                                            if (textView7 != null) {
                                                return new CustomDoubtLayoutBinding((ConstraintLayout) rootView, textView, textView2, textView3, linearLayout, textView4, textView5, textView6, imageView, imageView2, textView7);
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
