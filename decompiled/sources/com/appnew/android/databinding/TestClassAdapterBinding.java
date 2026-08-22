package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class TestClassAdapterBinding implements ViewBinding {
    public final TextView attemp;
    public final Button booklet;
    public final TextView cName;
    public final ImageView courseImage;
    public final TextView dateTv;
    public final LinearLayout detaisLayout;
    public final RelativeLayout detaisLayout1;
    public final TextView endDateTv;
    public final ImageView forwardIV;
    public final LinearLayout layoutTest;
    public final TextView learn;
    public final ImageView liveIV;
    public final Button marks;
    public final Button paper;
    public final TextView practice;
    public final RelativeLayout rlTextMode;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final TextView showRank;
    public final TextView startedin;
    public final TextView studyItemTitleTV;
    public final RelativeLayout studySingleItemLL;
    public final LinearLayout subjectBTNLL;
    public final TextView testModeTv;
    public final TextView testResume;
    public final RelativeLayout thumbRl;
    public final TextView time;
    public final Button upload;

    private TestClassAdapterBinding(RelativeLayout rootView, TextView attemp, Button booklet, TextView cName, ImageView courseImage, TextView dateTv, LinearLayout detaisLayout, RelativeLayout detaisLayout1, TextView endDateTv, ImageView forwardIV, LinearLayout layoutTest, TextView learn, ImageView liveIV, Button marks, Button paper, TextView practice, RelativeLayout rlTextMode, ImageView share, TextView showRank, TextView startedin, TextView studyItemTitleTV, RelativeLayout studySingleItemLL, LinearLayout subjectBTNLL, TextView testModeTv, TextView testResume, RelativeLayout thumbRl, TextView time, Button upload) {
        this.rootView = rootView;
        this.attemp = attemp;
        this.booklet = booklet;
        this.cName = cName;
        this.courseImage = courseImage;
        this.dateTv = dateTv;
        this.detaisLayout = detaisLayout;
        this.detaisLayout1 = detaisLayout1;
        this.endDateTv = endDateTv;
        this.forwardIV = forwardIV;
        this.layoutTest = layoutTest;
        this.learn = learn;
        this.liveIV = liveIV;
        this.marks = marks;
        this.paper = paper;
        this.practice = practice;
        this.rlTextMode = rlTextMode;
        this.share = share;
        this.showRank = showRank;
        this.startedin = startedin;
        this.studyItemTitleTV = studyItemTitleTV;
        this.studySingleItemLL = studySingleItemLL;
        this.subjectBTNLL = subjectBTNLL;
        this.testModeTv = testModeTv;
        this.testResume = testResume;
        this.thumbRl = thumbRl;
        this.time = time;
        this.upload = upload;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TestClassAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TestClassAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.test_class_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TestClassAdapterBinding bind(View rootView) {
        int i = R.id.attemp;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.attemp);
        if (textView != null) {
            i = R.id.booklet;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.booklet);
            if (button != null) {
                i = R.id.c_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.c_name);
                if (textView2 != null) {
                    i = R.id.courseImage;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImage);
                    if (imageView != null) {
                        i = R.id.date_tv;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_tv);
                        if (textView3 != null) {
                            i = R.id.detais_layout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.detais_layout);
                            if (linearLayout != null) {
                                i = R.id.detais_layout1;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.detais_layout1);
                                if (relativeLayout != null) {
                                    i = R.id.endDate_tv;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.endDate_tv);
                                    if (textView4 != null) {
                                        i = R.id.forwardIV;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.forwardIV);
                                        if (imageView2 != null) {
                                            i = R.id.layout_test;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_test);
                                            if (linearLayout2 != null) {
                                                i = R.id.learn;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.learn);
                                                if (textView5 != null) {
                                                    i = R.id.liveIV;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                                    if (imageView3 != null) {
                                                        i = R.id.marks;
                                                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.marks);
                                                        if (button2 != null) {
                                                            i = R.id.paper;
                                                            Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.paper);
                                                            if (button3 != null) {
                                                                i = R.id.practice;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.practice);
                                                                if (textView6 != null) {
                                                                    i = R.id.rl_text_mode;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_text_mode);
                                                                    if (relativeLayout2 != null) {
                                                                        i = R.id.share;
                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                                                        if (imageView4 != null) {
                                                                            i = R.id.show_rank;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.show_rank);
                                                                            if (textView7 != null) {
                                                                                i = R.id.startedin;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.startedin);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.study_item_titleTV;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.study_item_titleTV);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.study_single_itemLL;
                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                                                        if (relativeLayout3 != null) {
                                                                                            i = R.id.subjectBTNLL;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.subjectBTNLL);
                                                                                            if (linearLayout3 != null) {
                                                                                                i = R.id.test_mode_tv;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_mode_tv);
                                                                                                if (textView10 != null) {
                                                                                                    i = R.id.testResume;
                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testResume);
                                                                                                    if (textView11 != null) {
                                                                                                        i = R.id.thumbRl;
                                                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.thumbRl);
                                                                                                        if (relativeLayout4 != null) {
                                                                                                            i = R.id.time;
                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.time);
                                                                                                            if (textView12 != null) {
                                                                                                                i = R.id.upload;
                                                                                                                Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.upload);
                                                                                                                if (button4 != null) {
                                                                                                                    return new TestClassAdapterBinding((RelativeLayout) rootView, textView, button, textView2, imageView, textView3, linearLayout, relativeLayout, textView4, imageView2, linearLayout2, textView5, imageView3, button2, button3, textView6, relativeLayout2, imageView4, textView7, textView8, textView9, relativeLayout3, linearLayout3, textView10, textView11, relativeLayout4, textView12, button4);
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
