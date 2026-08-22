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
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DetailSingleItemTheme6Binding implements ViewBinding {
    public final LinearLayout LogsLL;
    public final LinearLayout actalll;
    public final TextView actualduration;
    public final LinearLayout attemptLL;
    public final Button booklet;
    public final CardView card;
    public final LinearLayout classdurationll;
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
    public final TextView liveDate;
    public final ImageView liveIV;
    public final TextView liveTime;
    public final RelativeLayout lockRL;
    public final Button marks;
    public final TextView messageTV;
    public final LinearLayout offlineLinearL;
    public final ImageView optionMenuImgView;
    public final Button paper;
    public final TextView playNow;
    public final TextView practice;
    public final TextView readNow;
    public final RelativeLayout realte;
    public final TextView registerText;
    public final TextView remainingTime;
    public final LinearLayout remainingtimell;
    public final TextView resultText;
    public final RelativeLayout rlTextMode;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final RelativeLayout studySingleItemLL;
    public final LinearLayout subjectBTNLL;
    public final TextView testModeTv;
    public final TextView testResume;
    public final TextView timing;
    public final TextView totalViewTime;
    public final LinearLayout totalviewtimell;
    public final Button upload;
    public final TextView viewResult;
    public final TextView watchNow;
    public final LinearLayout zoomDateTime;

    private DetailSingleItemTheme6Binding(RelativeLayout rootView, LinearLayout LogsLL, LinearLayout actalll, TextView actualduration, LinearLayout attemptLL, Button booklet, CardView card, LinearLayout classdurationll, RelativeLayout dataLayout, ProgressBar downloadprogess, TextView duration, TextView durationTV, ImageView ibtSingleSubVdIv, CardView ibtSingleSubVdRL, TextView ibtSingleSubVdTvTitle, LinearLayout l1, TextView learn, TextView listneNow, TextView liveDate, ImageView liveIV, TextView liveTime, RelativeLayout lockRL, Button marks, TextView messageTV, LinearLayout offlineLinearL, ImageView optionMenuImgView, Button paper, TextView playNow, TextView practice, TextView readNow, RelativeLayout realte, TextView registerText, TextView remainingTime, LinearLayout remainingtimell, TextView resultText, RelativeLayout rlTextMode, ImageView share, RelativeLayout studySingleItemLL, LinearLayout subjectBTNLL, TextView testModeTv, TextView testResume, TextView timing, TextView totalViewTime, LinearLayout totalviewtimell, Button upload, TextView viewResult, TextView watchNow, LinearLayout zoomDateTime) {
        this.rootView = rootView;
        this.LogsLL = LogsLL;
        this.actalll = actalll;
        this.actualduration = actualduration;
        this.attemptLL = attemptLL;
        this.booklet = booklet;
        this.card = card;
        this.classdurationll = classdurationll;
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
        this.liveDate = liveDate;
        this.liveIV = liveIV;
        this.liveTime = liveTime;
        this.lockRL = lockRL;
        this.marks = marks;
        this.messageTV = messageTV;
        this.offlineLinearL = offlineLinearL;
        this.optionMenuImgView = optionMenuImgView;
        this.paper = paper;
        this.playNow = playNow;
        this.practice = practice;
        this.readNow = readNow;
        this.realte = realte;
        this.registerText = registerText;
        this.remainingTime = remainingTime;
        this.remainingtimell = remainingtimell;
        this.resultText = resultText;
        this.rlTextMode = rlTextMode;
        this.share = share;
        this.studySingleItemLL = studySingleItemLL;
        this.subjectBTNLL = subjectBTNLL;
        this.testModeTv = testModeTv;
        this.testResume = testResume;
        this.timing = timing;
        this.totalViewTime = totalViewTime;
        this.totalviewtimell = totalviewtimell;
        this.upload = upload;
        this.viewResult = viewResult;
        this.watchNow = watchNow;
        this.zoomDateTime = zoomDateTime;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DetailSingleItemTheme6Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DetailSingleItemTheme6Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.detail_single_item_theme6, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DetailSingleItemTheme6Binding bind(View rootView) {
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
                        i = R.id.booklet;
                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.booklet);
                        if (button != null) {
                            i = R.id.card;
                            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.card);
                            if (cardView != null) {
                                i = R.id.classdurationll;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.classdurationll);
                                if (linearLayout4 != null) {
                                    i = R.id.data_layout;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.data_layout);
                                    if (relativeLayout != null) {
                                        i = R.id.downloadprogess;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.downloadprogess);
                                        if (progressBar != null) {
                                            i = R.id.duration;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.duration);
                                            if (textView2 != null) {
                                                i = R.id.durationTV;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.durationTV);
                                                if (textView3 != null) {
                                                    i = R.id.ibt_single_sub_vd_iv;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_iv);
                                                    if (imageView != null) {
                                                        i = R.id.ibt_single_sub_vd_RL;
                                                        CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                                                        if (cardView2 != null) {
                                                            i = R.id.ibt_single_sub_vd_tv_title;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_tv_title);
                                                            if (textView4 != null) {
                                                                i = R.id.l1;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.l1);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.learn;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.learn);
                                                                    if (textView5 != null) {
                                                                        i = R.id.listne_now;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.listne_now);
                                                                        if (textView6 != null) {
                                                                            i = R.id.liveDate;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.liveDate);
                                                                            if (textView7 != null) {
                                                                                i = R.id.liveIV;
                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                                                                if (imageView2 != null) {
                                                                                    i = R.id.liveTime;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.liveTime);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.lockRL;
                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                                                                                        if (relativeLayout2 != null) {
                                                                                            i = R.id.marks;
                                                                                            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.marks);
                                                                                            if (button2 != null) {
                                                                                                i = R.id.messageTV;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.messageTV);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.offlineLinearL;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.offlineLinearL);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        i = R.id.optionMenuImgView;
                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.optionMenuImgView);
                                                                                                        if (imageView3 != null) {
                                                                                                            i = R.id.paper;
                                                                                                            Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.paper);
                                                                                                            if (button3 != null) {
                                                                                                                i = R.id.play_now;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.play_now);
                                                                                                                if (textView10 != null) {
                                                                                                                    i = R.id.practice;
                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.practice);
                                                                                                                    if (textView11 != null) {
                                                                                                                        i = R.id.read_now;
                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.read_now);
                                                                                                                        if (textView12 != null) {
                                                                                                                            i = R.id.realte;
                                                                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.realte);
                                                                                                                            if (relativeLayout3 != null) {
                                                                                                                                i = R.id.registerText;
                                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.registerText);
                                                                                                                                if (textView13 != null) {
                                                                                                                                    i = R.id.remaining_time;
                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remaining_time);
                                                                                                                                    if (textView14 != null) {
                                                                                                                                        i = R.id.remainingtimell;
                                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.remainingtimell);
                                                                                                                                        if (linearLayout7 != null) {
                                                                                                                                            i = R.id.resultText;
                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultText);
                                                                                                                                            if (textView15 != null) {
                                                                                                                                                i = R.id.rl_text_mode;
                                                                                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_text_mode);
                                                                                                                                                if (relativeLayout4 != null) {
                                                                                                                                                    i = R.id.share;
                                                                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                                                                                                                                    if (imageView4 != null) {
                                                                                                                                                        i = R.id.study_single_itemLL;
                                                                                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                                                                                                                        if (relativeLayout5 != null) {
                                                                                                                                                            i = R.id.subjectBTNLL;
                                                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.subjectBTNLL);
                                                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                                                i = R.id.test_mode_tv;
                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_mode_tv);
                                                                                                                                                                if (textView16 != null) {
                                                                                                                                                                    i = R.id.testResume;
                                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testResume);
                                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                                        i = R.id.timing;
                                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timing);
                                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                                            i = R.id.total_view_time;
                                                                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.total_view_time);
                                                                                                                                                                            if (textView19 != null) {
                                                                                                                                                                                i = R.id.totalviewtimell;
                                                                                                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.totalviewtimell);
                                                                                                                                                                                if (linearLayout9 != null) {
                                                                                                                                                                                    i = R.id.upload;
                                                                                                                                                                                    Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.upload);
                                                                                                                                                                                    if (button4 != null) {
                                                                                                                                                                                        i = R.id.view_result;
                                                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.view_result);
                                                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                                                            i = R.id.watch_now;
                                                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.watch_now);
                                                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                                                i = R.id.zoom_date_time;
                                                                                                                                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.zoom_date_time);
                                                                                                                                                                                                if (linearLayout10 != null) {
                                                                                                                                                                                                    return new DetailSingleItemTheme6Binding((RelativeLayout) rootView, linearLayout, linearLayout2, textView, linearLayout3, button, cardView, linearLayout4, relativeLayout, progressBar, textView2, textView3, imageView, cardView2, textView4, linearLayout5, textView5, textView6, textView7, imageView2, textView8, relativeLayout2, button2, textView9, linearLayout6, imageView3, button3, textView10, textView11, textView12, relativeLayout3, textView13, textView14, linearLayout7, textView15, relativeLayout4, imageView4, relativeLayout5, linearLayout8, textView16, textView17, textView18, textView19, linearLayout9, button4, textView20, textView21, linearLayout10);
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
