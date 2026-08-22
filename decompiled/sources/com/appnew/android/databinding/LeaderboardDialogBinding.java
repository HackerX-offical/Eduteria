package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LeaderboardDialogBinding implements ViewBinding {
    public final LinearLayout LayRank;
    public final RelativeLayout RankList;
    public final RelativeLayout RelPollRank;
    public final RelativeLayout RlEnd;
    public final RelativeLayout RlStart;
    public final CardView cardView1;
    public final CardView cardView2;
    public final CardView cardView3;
    public final ImageView closeLb;
    public final RelativeLayout layout1;
    public final RelativeLayout layout2;
    public final RelativeLayout layout3;
    public final RelativeLayout leaderBoardRelative;
    public final ImageView myImageIcon;
    public final RecyclerView recyclerViewPollRank;
    public final RecyclerView recyclerViewRank;
    private final RelativeLayout rootView;
    public final NestedScrollView scrollRank;
    public final TextView student1;
    public final TextView student2;
    public final TextView student3;
    public final TextView studentOne;
    public final TextView studentThree;
    public final TextView studentTwo;
    public final TextView time;

    private LeaderboardDialogBinding(RelativeLayout rootView, LinearLayout LayRank, RelativeLayout RankList, RelativeLayout RelPollRank, RelativeLayout RlEnd, RelativeLayout RlStart, CardView cardView1, CardView cardView2, CardView cardView3, ImageView closeLb, RelativeLayout layout1, RelativeLayout layout2, RelativeLayout layout3, RelativeLayout leaderBoardRelative, ImageView myImageIcon, RecyclerView recyclerViewPollRank, RecyclerView recyclerViewRank, NestedScrollView scrollRank, TextView student1, TextView student2, TextView student3, TextView studentOne, TextView studentThree, TextView studentTwo, TextView time) {
        this.rootView = rootView;
        this.LayRank = LayRank;
        this.RankList = RankList;
        this.RelPollRank = RelPollRank;
        this.RlEnd = RlEnd;
        this.RlStart = RlStart;
        this.cardView1 = cardView1;
        this.cardView2 = cardView2;
        this.cardView3 = cardView3;
        this.closeLb = closeLb;
        this.layout1 = layout1;
        this.layout2 = layout2;
        this.layout3 = layout3;
        this.leaderBoardRelative = leaderBoardRelative;
        this.myImageIcon = myImageIcon;
        this.recyclerViewPollRank = recyclerViewPollRank;
        this.recyclerViewRank = recyclerViewRank;
        this.scrollRank = scrollRank;
        this.student1 = student1;
        this.student2 = student2;
        this.student3 = student3;
        this.studentOne = studentOne;
        this.studentThree = studentThree;
        this.studentTwo = studentTwo;
        this.time = time;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LeaderboardDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LeaderboardDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.leaderboard_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LeaderboardDialogBinding bind(View rootView) {
        int i = R.id.LayRank;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.LayRank);
        if (linearLayout != null) {
            i = R.id.RankList;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RankList);
            if (relativeLayout != null) {
                i = R.id.RelPollRank;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RelPollRank);
                if (relativeLayout2 != null) {
                    i = R.id.RlEnd;
                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RlEnd);
                    if (relativeLayout3 != null) {
                        i = R.id.RlStart;
                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RlStart);
                        if (relativeLayout4 != null) {
                            i = R.id.cardView1;
                            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.cardView1);
                            if (cardView != null) {
                                i = R.id.cardView2;
                                CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.cardView2);
                                if (cardView2 != null) {
                                    i = R.id.cardView3;
                                    CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, R.id.cardView3);
                                    if (cardView3 != null) {
                                        i = R.id.close_lb;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.close_lb);
                                        if (imageView != null) {
                                            i = R.id.layout1;
                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout1);
                                            if (relativeLayout5 != null) {
                                                i = R.id.layout2;
                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout2);
                                                if (relativeLayout6 != null) {
                                                    i = R.id.layout3;
                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout3);
                                                    if (relativeLayout7 != null) {
                                                        RelativeLayout relativeLayout8 = (RelativeLayout) rootView;
                                                        i = R.id.my_image_icon;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.my_image_icon);
                                                        if (imageView2 != null) {
                                                            i = R.id.recyclerViewPollRank;
                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recyclerViewPollRank);
                                                            if (recyclerView != null) {
                                                                i = R.id.recyclerViewRank;
                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recyclerViewRank);
                                                                if (recyclerView2 != null) {
                                                                    i = R.id.scrollRank;
                                                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollRank);
                                                                    if (nestedScrollView != null) {
                                                                        i = R.id.student1;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.student1);
                                                                        if (textView != null) {
                                                                            i = R.id.student2;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student2);
                                                                            if (textView2 != null) {
                                                                                i = R.id.student3;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student3);
                                                                                if (textView3 != null) {
                                                                                    i = R.id.studentOne;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentOne);
                                                                                    if (textView4 != null) {
                                                                                        i = R.id.studentThree;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentThree);
                                                                                        if (textView5 != null) {
                                                                                            i = R.id.studentTwo;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentTwo);
                                                                                            if (textView6 != null) {
                                                                                                i = R.id.time;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.time);
                                                                                                if (textView7 != null) {
                                                                                                    return new LeaderboardDialogBinding(relativeLayout8, linearLayout, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, cardView, cardView2, cardView3, imageView, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, imageView2, recyclerView, recyclerView2, nestedScrollView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
