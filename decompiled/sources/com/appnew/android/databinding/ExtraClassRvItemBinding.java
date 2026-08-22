package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExtraClassRvItemBinding implements ViewBinding {
    public final LinearLayout LogsLL;
    public final LinearLayout attemptLL;
    public final Button booklet;
    public final CardView card;
    public final RelativeLayout dataLayout;
    public final ProgressBar downloadprogess;
    public final TextView duration;
    public final TextView durationTV;
    public final ImageView ibtSingleSubVdIv;
    public final CardView ibtSingleSubVdRL;
    public final TextView ibtSingleSubVdTvTitle;
    public final LinearLayout l1;
    public final TextView learn;
    public final TextView listneNow;
    public final ImageView liveIV;
    public final RelativeLayout lockRL;
    public final Button marks;
    public final TextView messageTV;
    public final AppCompatImageView optionMenuImgView;
    public final Button paper;
    public final TextView practice;
    public final TextView readNow;
    public final RelativeLayout realte;
    public final TextView remainingTime;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final RelativeLayout studySingleItemLL;
    public final LinearLayout subjectBTNLL;
    public final TextView totalViewTime;
    public final Button upload;
    public final TextView watchNow;

    private ExtraClassRvItemBinding(RelativeLayout rootView, LinearLayout LogsLL, LinearLayout attemptLL, Button booklet, CardView card, RelativeLayout dataLayout, ProgressBar downloadprogess, TextView duration, TextView durationTV, ImageView ibtSingleSubVdIv, CardView ibtSingleSubVdRL, TextView ibtSingleSubVdTvTitle, LinearLayout l1, TextView learn, TextView listneNow, ImageView liveIV, RelativeLayout lockRL, Button marks, TextView messageTV, AppCompatImageView optionMenuImgView, Button paper, TextView practice, TextView readNow, RelativeLayout realte, TextView remainingTime, ImageView share, RelativeLayout studySingleItemLL, LinearLayout subjectBTNLL, TextView totalViewTime, Button upload, TextView watchNow) {
        this.rootView = rootView;
        this.LogsLL = LogsLL;
        this.attemptLL = attemptLL;
        this.booklet = booklet;
        this.card = card;
        this.dataLayout = dataLayout;
        this.downloadprogess = downloadprogess;
        this.duration = duration;
        this.durationTV = durationTV;
        this.ibtSingleSubVdIv = ibtSingleSubVdIv;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.ibtSingleSubVdTvTitle = ibtSingleSubVdTvTitle;
        this.l1 = l1;
        this.learn = learn;
        this.listneNow = listneNow;
        this.liveIV = liveIV;
        this.lockRL = lockRL;
        this.marks = marks;
        this.messageTV = messageTV;
        this.optionMenuImgView = optionMenuImgView;
        this.paper = paper;
        this.practice = practice;
        this.readNow = readNow;
        this.realte = realte;
        this.remainingTime = remainingTime;
        this.share = share;
        this.studySingleItemLL = studySingleItemLL;
        this.subjectBTNLL = subjectBTNLL;
        this.totalViewTime = totalViewTime;
        this.upload = upload;
        this.watchNow = watchNow;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExtraClassRvItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExtraClassRvItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.extra_class_rv_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExtraClassRvItemBinding bind(View rootView) {
        int i = R.id.LogsLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.LogsLL);
        if (linearLayout != null) {
            i = R.id.attemptLL;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.attemptLL);
            if (linearLayout2 != null) {
                i = R.id.booklet;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.booklet);
                if (button != null) {
                    i = R.id.card;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.card);
                    if (cardView != null) {
                        i = R.id.data_layout;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.data_layout);
                        if (relativeLayout != null) {
                            i = R.id.downloadprogess;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.downloadprogess);
                            if (progressBar != null) {
                                i = R.id.duration;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.duration);
                                if (textView != null) {
                                    i = R.id.durationTV;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.durationTV);
                                    if (textView2 != null) {
                                        i = R.id.ibt_single_sub_vd_iv;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_iv);
                                        if (imageView != null) {
                                            i = R.id.ibt_single_sub_vd_RL;
                                            CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                                            if (cardView2 != null) {
                                                i = R.id.ibt_single_sub_vd_tv_title;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_tv_title);
                                                if (textView3 != null) {
                                                    i = R.id.l1;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.l1);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.learn;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.learn);
                                                        if (textView4 != null) {
                                                            i = R.id.listne_now;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.listne_now);
                                                            if (textView5 != null) {
                                                                i = R.id.liveIV;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                                                if (imageView2 != null) {
                                                                    i = R.id.lockRL;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                                                                    if (relativeLayout2 != null) {
                                                                        i = R.id.marks;
                                                                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.marks);
                                                                        if (button2 != null) {
                                                                            i = R.id.messageTV;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.messageTV);
                                                                            if (textView6 != null) {
                                                                                i = R.id.optionMenuImgView;
                                                                                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, R.id.optionMenuImgView);
                                                                                if (appCompatImageView != null) {
                                                                                    i = R.id.paper;
                                                                                    Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.paper);
                                                                                    if (button3 != null) {
                                                                                        i = R.id.practice;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.practice);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.read_now;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.read_now);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.realte;
                                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.realte);
                                                                                                if (relativeLayout3 != null) {
                                                                                                    i = R.id.remaining_time;
                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remaining_time);
                                                                                                    if (textView9 != null) {
                                                                                                        i = R.id.share;
                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                                                                                        if (imageView3 != null) {
                                                                                                            i = R.id.study_single_itemLL;
                                                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                                                                            if (relativeLayout4 != null) {
                                                                                                                i = R.id.subjectBTNLL;
                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.subjectBTNLL);
                                                                                                                if (linearLayout4 != null) {
                                                                                                                    i = R.id.total_view_time;
                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.total_view_time);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i = R.id.upload;
                                                                                                                        Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.upload);
                                                                                                                        if (button4 != null) {
                                                                                                                            i = R.id.watch_now;
                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.watch_now);
                                                                                                                            if (textView11 != null) {
                                                                                                                                return new ExtraClassRvItemBinding((RelativeLayout) rootView, linearLayout, linearLayout2, button, cardView, relativeLayout, progressBar, textView, textView2, imageView, cardView2, textView3, linearLayout3, textView4, textView5, imageView2, relativeLayout2, button2, textView6, appCompatImageView, button3, textView7, textView8, relativeLayout3, textView9, imageView3, relativeLayout4, linearLayout4, textView10, button4, textView11);
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
