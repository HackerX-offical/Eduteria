package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
public final class ExamPrepSingleRowItemBinding implements ViewBinding {
    public final LinearLayout LogsLL;
    public final LinearLayout actalll;
    public final TextView actualduration;
    public final LinearLayout attemptLL;
    public final CheckBox checkMark;
    public final LinearLayout classTimingRow;
    public final LinearLayout classdurationll;
    public final LinearLayout cvrClickItems;
    public final ProgressBar downloadprogess;
    public final TextView duration;
    public final LinearLayout durationLL;
    public final TextView endDate;
    public final TextView examPrepTitleTV;
    public final ImageView forwardIV;
    public final CardView ibtSingleSubVdRL;
    public final RelativeLayout imageRL;
    public final CardView layerCard;
    public final RelativeLayout layoutFun;
    public final TextView learn;
    public final TextView listneNow;
    public final ImageView liveIV;
    public final LinearLayout llMarkRead;
    public final RelativeLayout lockRL;
    public final TextView messageTV;
    public final AppCompatImageView optionMenuImgView;
    public final TextView pdfTV;
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
    public final TextView startDate;
    public final RelativeLayout studySingleItemLL;
    public final TextView subItemRV;
    public final TextView totalViewTime;
    public final LinearLayout totalviewtimell;
    public final TextView tvMark;
    public final TextView watchNow;

    private ExamPrepSingleRowItemBinding(RelativeLayout rootView, LinearLayout LogsLL, LinearLayout actalll, TextView actualduration, LinearLayout attemptLL, CheckBox checkMark, LinearLayout classTimingRow, LinearLayout classdurationll, LinearLayout cvrClickItems, ProgressBar downloadprogess, TextView duration, LinearLayout durationLL, TextView endDate, TextView examPrepTitleTV, ImageView forwardIV, CardView ibtSingleSubVdRL, RelativeLayout imageRL, CardView layerCard, RelativeLayout layoutFun, TextView learn, TextView listneNow, ImageView liveIV, LinearLayout llMarkRead, RelativeLayout lockRL, TextView messageTV, AppCompatImageView optionMenuImgView, TextView pdfTV, TextView playNow, TextView practice, ImageView profileImage, LinearLayout progressLL, TextView readNow, TextView remainingTime, LinearLayout remainingtimell, RelativeLayout rl, ImageView share, TextView startDate, RelativeLayout studySingleItemLL, TextView subItemRV, TextView totalViewTime, LinearLayout totalviewtimell, TextView tvMark, TextView watchNow) {
        this.rootView = rootView;
        this.LogsLL = LogsLL;
        this.actalll = actalll;
        this.actualduration = actualduration;
        this.attemptLL = attemptLL;
        this.checkMark = checkMark;
        this.classTimingRow = classTimingRow;
        this.classdurationll = classdurationll;
        this.cvrClickItems = cvrClickItems;
        this.downloadprogess = downloadprogess;
        this.duration = duration;
        this.durationLL = durationLL;
        this.endDate = endDate;
        this.examPrepTitleTV = examPrepTitleTV;
        this.forwardIV = forwardIV;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.imageRL = imageRL;
        this.layerCard = layerCard;
        this.layoutFun = layoutFun;
        this.learn = learn;
        this.listneNow = listneNow;
        this.liveIV = liveIV;
        this.llMarkRead = llMarkRead;
        this.lockRL = lockRL;
        this.messageTV = messageTV;
        this.optionMenuImgView = optionMenuImgView;
        this.pdfTV = pdfTV;
        this.playNow = playNow;
        this.practice = practice;
        this.profileImage = profileImage;
        this.progressLL = progressLL;
        this.readNow = readNow;
        this.remainingTime = remainingTime;
        this.remainingtimell = remainingtimell;
        this.rl = rl;
        this.share = share;
        this.startDate = startDate;
        this.studySingleItemLL = studySingleItemLL;
        this.subItemRV = subItemRV;
        this.totalViewTime = totalViewTime;
        this.totalviewtimell = totalviewtimell;
        this.tvMark = tvMark;
        this.watchNow = watchNow;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepSingleRowItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepSingleRowItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_single_row_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepSingleRowItemBinding bind(View rootView) {
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
                        i = R.id.checkMark;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.checkMark);
                        if (checkBox != null) {
                            i = R.id.classTimingRow;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.classTimingRow);
                            if (linearLayout4 != null) {
                                i = R.id.classdurationll;
                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.classdurationll);
                                if (linearLayout5 != null) {
                                    i = R.id.cvrClickItems;
                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrClickItems);
                                    if (linearLayout6 != null) {
                                        i = R.id.downloadprogess;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.downloadprogess);
                                        if (progressBar != null) {
                                            i = R.id.duration;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.duration);
                                            if (textView2 != null) {
                                                i = R.id.durationLL;
                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.durationLL);
                                                if (linearLayout7 != null) {
                                                    i = R.id.endDate;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.endDate);
                                                    if (textView3 != null) {
                                                        i = R.id.examPrepTitleTV;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.examPrepTitleTV);
                                                        if (textView4 != null) {
                                                            i = R.id.forwardIV;
                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.forwardIV);
                                                            if (imageView != null) {
                                                                i = R.id.ibt_single_sub_vd_RL;
                                                                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                                                                if (cardView != null) {
                                                                    i = R.id.imageRL;
                                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                                                                    if (relativeLayout != null) {
                                                                        i = R.id.layer_card;
                                                                        CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.layer_card);
                                                                        if (cardView2 != null) {
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
                                                                                            i = R.id.llMarkRead;
                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llMarkRead);
                                                                                            if (linearLayout8 != null) {
                                                                                                i = R.id.lockRL;
                                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                                                                                                if (relativeLayout3 != null) {
                                                                                                    i = R.id.messageTV;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.messageTV);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R.id.optionMenuImgView;
                                                                                                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, R.id.optionMenuImgView);
                                                                                                        if (appCompatImageView != null) {
                                                                                                            i = R.id.pdf_TV;
                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdf_TV);
                                                                                                            if (textView8 != null) {
                                                                                                                i = R.id.play_now;
                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.play_now);
                                                                                                                if (textView9 != null) {
                                                                                                                    i = R.id.practice;
                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.practice);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i = R.id.profileImage;
                                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                                                                                                        if (imageView3 != null) {
                                                                                                                            i = R.id.progressLL;
                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.progressLL);
                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                i = R.id.read_now;
                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.read_now);
                                                                                                                                if (textView11 != null) {
                                                                                                                                    i = R.id.remaining_time;
                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remaining_time);
                                                                                                                                    if (textView12 != null) {
                                                                                                                                        i = R.id.remainingtimell;
                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.remainingtimell);
                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                            i = R.id.rl;
                                                                                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl);
                                                                                                                                            if (relativeLayout4 != null) {
                                                                                                                                                i = R.id.share;
                                                                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                                                                                                                                if (imageView4 != null) {
                                                                                                                                                    i = R.id.startDate;
                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.startDate);
                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                        i = R.id.study_single_itemLL;
                                                                                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                                                                                                                        if (relativeLayout5 != null) {
                                                                                                                                                            i = R.id.subItemRV;
                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subItemRV);
                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                i = R.id.total_view_time;
                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.total_view_time);
                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                    i = R.id.totalviewtimell;
                                                                                                                                                                    LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.totalviewtimell);
                                                                                                                                                                    if (linearLayout11 != null) {
                                                                                                                                                                        i = R.id.tvMark;
                                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvMark);
                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                            i = R.id.watch_now;
                                                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.watch_now);
                                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                                return new ExamPrepSingleRowItemBinding((RelativeLayout) rootView, linearLayout, linearLayout2, textView, linearLayout3, checkBox, linearLayout4, linearLayout5, linearLayout6, progressBar, textView2, linearLayout7, textView3, textView4, imageView, cardView, relativeLayout, cardView2, relativeLayout2, textView5, textView6, imageView2, linearLayout8, relativeLayout3, textView7, appCompatImageView, textView8, textView9, textView10, imageView3, linearLayout9, textView11, textView12, linearLayout10, relativeLayout4, imageView4, textView13, relativeLayout5, textView14, textView15, linearLayout11, textView16, textView17);
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
