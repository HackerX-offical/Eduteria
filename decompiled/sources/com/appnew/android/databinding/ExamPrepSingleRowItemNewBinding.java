package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class ExamPrepSingleRowItemNewBinding implements ViewBinding {
    public final LinearLayout LogsLL;
    public final LinearLayout actalll;
    public final TextView actualduration;
    public final LinearLayout attemptLL;
    public final CardView cardView;
    public final LinearLayout classdurationll;
    public final LinearLayout cvrClickItems;
    public final ProgressBar downloadprogess;
    public final TextView duration;
    public final LinearLayout durationLL;
    public final TextView examPrepTitleTV;
    public final TextView examPrepTitleTVNew;
    public final ImageView forwardIV;
    public final CardView ibtSingleSubVdRL;
    public final RelativeLayout imageRL;
    public final RelativeLayout layoutFun;
    public final TextView learn;
    public final TextView listneNow;
    public final ImageView liveIV;
    public final RelativeLayout lockRL;
    public final TextView messageTV;
    public final AppCompatImageView optionMenuImgView;
    public final TextView playNow;
    public final TextView practice;
    public final ImageView profileImage;
    public final LinearLayout progressLL;
    public final TextView readNow;
    public final TextView remainingTime;
    public final LinearLayout remainingtimell;
    public final RelativeLayout rl;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final RelativeLayout studySingleItemLL;
    public final TextView subItemRV;
    public final TextView totalViewTime;
    public final LinearLayout totalviewtimell;
    public final TextView watchNow;

    private ExamPrepSingleRowItemNewBinding(RelativeLayout rootView, LinearLayout LogsLL, LinearLayout actalll, TextView actualduration, LinearLayout attemptLL, CardView cardView, LinearLayout classdurationll, LinearLayout cvrClickItems, ProgressBar downloadprogess, TextView duration, LinearLayout durationLL, TextView examPrepTitleTV, TextView examPrepTitleTVNew, ImageView forwardIV, CardView ibtSingleSubVdRL, RelativeLayout imageRL, RelativeLayout layoutFun, TextView learn, TextView listneNow, ImageView liveIV, RelativeLayout lockRL, TextView messageTV, AppCompatImageView optionMenuImgView, TextView playNow, TextView practice, ImageView profileImage, LinearLayout progressLL, TextView readNow, TextView remainingTime, LinearLayout remainingtimell, RelativeLayout rl, ImageView share, RelativeLayout studySingleItemLL, TextView subItemRV, TextView totalViewTime, LinearLayout totalviewtimell, TextView watchNow) {
        this.rootView = rootView;
        this.LogsLL = LogsLL;
        this.actalll = actalll;
        this.actualduration = actualduration;
        this.attemptLL = attemptLL;
        this.cardView = cardView;
        this.classdurationll = classdurationll;
        this.cvrClickItems = cvrClickItems;
        this.downloadprogess = downloadprogess;
        this.duration = duration;
        this.durationLL = durationLL;
        this.examPrepTitleTV = examPrepTitleTV;
        this.examPrepTitleTVNew = examPrepTitleTVNew;
        this.forwardIV = forwardIV;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.imageRL = imageRL;
        this.layoutFun = layoutFun;
        this.learn = learn;
        this.listneNow = listneNow;
        this.liveIV = liveIV;
        this.lockRL = lockRL;
        this.messageTV = messageTV;
        this.optionMenuImgView = optionMenuImgView;
        this.playNow = playNow;
        this.practice = practice;
        this.profileImage = profileImage;
        this.progressLL = progressLL;
        this.readNow = readNow;
        this.remainingTime = remainingTime;
        this.remainingtimell = remainingtimell;
        this.rl = rl;
        this.share = share;
        this.studySingleItemLL = studySingleItemLL;
        this.subItemRV = subItemRV;
        this.totalViewTime = totalViewTime;
        this.totalviewtimell = totalviewtimell;
        this.watchNow = watchNow;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepSingleRowItemNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepSingleRowItemNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_single_row_item_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepSingleRowItemNewBinding bind(View rootView) {
        int i = R.id.LogsLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.LogsLL);
        if (linearLayout != null) {
            i = R.id.actalll;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.actalll);
            if (linearLayout2 != null) {
                i = R.id.actualduration;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.actualduration);
                if (textView != null) {
                    i = R.id.attemptLL;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.attemptLL);
                    if (linearLayout3 != null) {
                        i = R.id.cardView;
                        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.cardView);
                        if (cardView != null) {
                            i = R.id.classdurationll;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.classdurationll);
                            if (linearLayout4 != null) {
                                i = R.id.cvrClickItems;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrClickItems);
                                if (linearLayout5 != null) {
                                    i = R.id.downloadprogess;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.downloadprogess);
                                    if (progressBar != null) {
                                        i = R.id.duration;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.duration);
                                        if (textView2 != null) {
                                            i = R.id.durationLL;
                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.durationLL);
                                            if (linearLayout6 != null) {
                                                i = R.id.examPrepTitleTV;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.examPrepTitleTV);
                                                if (textView3 != null) {
                                                    i = R.id.examPrepTitleTV_new;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.examPrepTitleTV_new);
                                                    if (textView4 != null) {
                                                        i = R.id.forwardIV;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.forwardIV);
                                                        if (imageView != null) {
                                                            i = R.id.ibt_single_sub_vd_RL;
                                                            CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                                                            if (cardView2 != null) {
                                                                i = R.id.imageRL;
                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                                                                if (relativeLayout != null) {
                                                                    i = R.id.layout_fun;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout_fun);
                                                                    if (relativeLayout2 != null) {
                                                                        i = R.id.learn;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.learn);
                                                                        if (textView5 != null) {
                                                                            i = R.id.listne_now;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.listne_now);
                                                                            if (textView6 != null) {
                                                                                i = R.id.liveIV;
                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                                                                if (imageView2 != null) {
                                                                                    i = R.id.lockRL;
                                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                                                                                    if (relativeLayout3 != null) {
                                                                                        i = R.id.messageTV;
                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.messageTV);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.optionMenuImgView;
                                                                                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, R.id.optionMenuImgView);
                                                                                            if (appCompatImageView != null) {
                                                                                                i = R.id.play_now;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.play_now);
                                                                                                if (textView8 != null) {
                                                                                                    i = R.id.practice;
                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.practice);
                                                                                                    if (textView9 != null) {
                                                                                                        i = R.id.profileImage;
                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                                                                                        if (imageView3 != null) {
                                                                                                            i = R.id.progressLL;
                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.progressLL);
                                                                                                            if (linearLayout7 != null) {
                                                                                                                i = R.id.read_now;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.read_now);
                                                                                                                if (textView10 != null) {
                                                                                                                    i = R.id.remaining_time;
                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remaining_time);
                                                                                                                    if (textView11 != null) {
                                                                                                                        i = R.id.remainingtimell;
                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.remainingtimell);
                                                                                                                        if (linearLayout8 != null) {
                                                                                                                            i = R.id.rl;
                                                                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl);
                                                                                                                            if (relativeLayout4 != null) {
                                                                                                                                i = R.id.share;
                                                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                                                                                                                if (imageView4 != null) {
                                                                                                                                    i = R.id.study_single_itemLL;
                                                                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                                                                                                    if (relativeLayout5 != null) {
                                                                                                                                        i = R.id.subItemRV;
                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subItemRV);
                                                                                                                                        if (textView12 != null) {
                                                                                                                                            i = R.id.total_view_time;
                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.total_view_time);
                                                                                                                                            if (textView13 != null) {
                                                                                                                                                i = R.id.totalviewtimell;
                                                                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.totalviewtimell);
                                                                                                                                                if (linearLayout9 != null) {
                                                                                                                                                    i = R.id.watch_now;
                                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.watch_now);
                                                                                                                                                    if (textView14 != null) {
                                                                                                                                                        return new ExamPrepSingleRowItemNewBinding((RelativeLayout) rootView, linearLayout, linearLayout2, textView, linearLayout3, cardView, linearLayout4, linearLayout5, progressBar, textView2, linearLayout6, textView3, textView4, imageView, cardView2, relativeLayout, relativeLayout2, textView5, textView6, imageView2, relativeLayout3, textView7, appCompatImageView, textView8, textView9, imageView3, linearLayout7, textView10, textView11, linearLayout8, relativeLayout4, imageView4, relativeLayout5, textView12, textView13, linearLayout9, textView14);
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
