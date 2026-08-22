package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentQuizResultScreenBinding implements ViewBinding {
    public final ImageView appLogoIV;
    public final TextView correctTv;
    public final ImageView leaderboardIV;
    public final NestedScrollView mainLL;
    public final TextView nameValueTV;
    public final LinearLayout questionDistrLL;
    public final LinearLayout rankLL;
    public final TextView rankValueTV;
    public final ImageView rankreloadIV;
    public final TextView rewardsValueTV;
    private final LinearLayout rootView;
    public final LinearLayout scoreLL;
    public final TextView scoreValueTV;
    public final LinearLayout shareRankLL;
    public final TextView testSeriesnameTV;
    public final TextView timeSpentValueTV;
    public final TextView unattemptedTv;
    public final TextView wrongTv;

    private FragmentQuizResultScreenBinding(LinearLayout rootView, ImageView appLogoIV, TextView correctTv, ImageView leaderboardIV, NestedScrollView mainLL, TextView nameValueTV, LinearLayout questionDistrLL, LinearLayout rankLL, TextView rankValueTV, ImageView rankreloadIV, TextView rewardsValueTV, LinearLayout scoreLL, TextView scoreValueTV, LinearLayout shareRankLL, TextView testSeriesnameTV, TextView timeSpentValueTV, TextView unattemptedTv, TextView wrongTv) {
        this.rootView = rootView;
        this.appLogoIV = appLogoIV;
        this.correctTv = correctTv;
        this.leaderboardIV = leaderboardIV;
        this.mainLL = mainLL;
        this.nameValueTV = nameValueTV;
        this.questionDistrLL = questionDistrLL;
        this.rankLL = rankLL;
        this.rankValueTV = rankValueTV;
        this.rankreloadIV = rankreloadIV;
        this.rewardsValueTV = rewardsValueTV;
        this.scoreLL = scoreLL;
        this.scoreValueTV = scoreValueTV;
        this.shareRankLL = shareRankLL;
        this.testSeriesnameTV = testSeriesnameTV;
        this.timeSpentValueTV = timeSpentValueTV;
        this.unattemptedTv = unattemptedTv;
        this.wrongTv = wrongTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentQuizResultScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentQuizResultScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_quiz_result_screen, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentQuizResultScreenBinding bind(View rootView) {
        int i = R.id.appLogoIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.appLogoIV);
        if (imageView != null) {
            i = R.id.correctTv;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.correctTv);
            if (textView != null) {
                i = R.id.leaderboardIV;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.leaderboardIV);
                if (imageView2 != null) {
                    i = R.id.mainLL;
                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.mainLL);
                    if (nestedScrollView != null) {
                        i = R.id.nameValueTV;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameValueTV);
                        if (textView2 != null) {
                            i = R.id.questionDistrLL;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.questionDistrLL);
                            if (linearLayout != null) {
                                i = R.id.rankLL;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rankLL);
                                if (linearLayout2 != null) {
                                    i = R.id.rankValueTV;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rankValueTV);
                                    if (textView3 != null) {
                                        i = R.id.rankreloadIV;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.rankreloadIV);
                                        if (imageView3 != null) {
                                            i = R.id.rewardsValueTV;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rewardsValueTV);
                                            if (textView4 != null) {
                                                i = R.id.scoreLL;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.scoreLL);
                                                if (linearLayout3 != null) {
                                                    i = R.id.scoreValueTV;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.scoreValueTV);
                                                    if (textView5 != null) {
                                                        i = R.id.shareRankLL;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.shareRankLL);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.testSeriesnameTV;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testSeriesnameTV);
                                                            if (textView6 != null) {
                                                                i = R.id.timeSpentValueTV;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timeSpentValueTV);
                                                                if (textView7 != null) {
                                                                    i = R.id.unattemptedTv;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.unattemptedTv);
                                                                    if (textView8 != null) {
                                                                        i = R.id.wrongTv;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.wrongTv);
                                                                        if (textView9 != null) {
                                                                            return new FragmentQuizResultScreenBinding((LinearLayout) rootView, imageView, textView, imageView2, nestedScrollView, textView2, linearLayout, linearLayout2, textView3, imageView3, textView4, linearLayout3, textView5, linearLayout4, textView6, textView7, textView8, textView9);
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
