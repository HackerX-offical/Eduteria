package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCardviewPollBinding implements ViewBinding {
    public final Button buyNowBtn;
    public final ImageView clockIV;
    public final TextView createTime;
    public final TextView expireddate;
    public final Button leaderBoardBtn;
    public final AppCompatButton leaderboard;
    public final RelativeLayout mainlayout;
    public final TextView pollNumber;
    private final RelativeLayout rootView;
    public final Button takeAPollBtn;
    public final TextView time;
    public final RelativeLayout timerLayout;
    public final TextView timerText;
    public final LinearLayout titleLayout;
    public final RelativeLayout topLayout;
    public final TextView userName;
    public final View view1;

    private ActivityCardviewPollBinding(RelativeLayout rootView, Button buyNowBtn, ImageView clockIV, TextView createTime, TextView expireddate, Button leaderBoardBtn, AppCompatButton leaderboard, RelativeLayout mainlayout, TextView pollNumber, Button takeAPollBtn, TextView time, RelativeLayout timerLayout, TextView timerText, LinearLayout titleLayout, RelativeLayout topLayout, TextView userName, View view1) {
        this.rootView = rootView;
        this.buyNowBtn = buyNowBtn;
        this.clockIV = clockIV;
        this.createTime = createTime;
        this.expireddate = expireddate;
        this.leaderBoardBtn = leaderBoardBtn;
        this.leaderboard = leaderboard;
        this.mainlayout = mainlayout;
        this.pollNumber = pollNumber;
        this.takeAPollBtn = takeAPollBtn;
        this.time = time;
        this.timerLayout = timerLayout;
        this.timerText = timerText;
        this.titleLayout = titleLayout;
        this.topLayout = topLayout;
        this.userName = userName;
        this.view1 = view1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCardviewPollBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCardviewPollBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_cardview_poll, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCardviewPollBinding bind(View rootView) {
        int i = R.id.buyNowBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buyNowBtn);
        if (button != null) {
            i = R.id.clockIV;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.clockIV);
            if (imageView != null) {
                i = R.id.createTime;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.createTime);
                if (textView != null) {
                    i = R.id.expireddate;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.expireddate);
                    if (textView2 != null) {
                        i = R.id.leaderBoardBtn;
                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.leaderBoardBtn);
                        if (button2 != null) {
                            i = R.id.leaderboard;
                            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(rootView, R.id.leaderboard);
                            if (appCompatButton != null) {
                                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                                i = R.id.pollNumber;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pollNumber);
                                if (textView3 != null) {
                                    i = R.id.takeAPollBtn;
                                    Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.takeAPollBtn);
                                    if (button3 != null) {
                                        i = R.id.time;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.time);
                                        if (textView4 != null) {
                                            i = R.id.timerLayout;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.timerLayout);
                                            if (relativeLayout2 != null) {
                                                i = R.id.timerText;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timerText);
                                                if (textView5 != null) {
                                                    i = R.id.titleLayout;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.titleLayout);
                                                    if (linearLayout != null) {
                                                        i = R.id.topLayout;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.topLayout);
                                                        if (relativeLayout3 != null) {
                                                            i = R.id.userName;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userName);
                                                            if (textView6 != null) {
                                                                i = R.id.view1;
                                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                                                                if (viewFindChildViewById != null) {
                                                                    return new ActivityCardviewPollBinding(relativeLayout, button, imageView, textView, textView2, button2, appCompatButton, relativeLayout, textView3, button3, textView4, relativeLayout2, textView5, linearLayout, relativeLayout3, textView6, viewFindChildViewById);
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
