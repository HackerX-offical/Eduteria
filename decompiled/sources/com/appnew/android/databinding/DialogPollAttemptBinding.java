package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogPollAttemptBinding implements ViewBinding {
    public final RelativeLayout RelPollRank;
    public final RelativeLayout RlEnd;
    public final RelativeLayout RlStart;
    public final CardView cardView1;
    public final CardView cardView2;
    public final CardView cardView3;
    public final LinearLayout cvrQuestions;
    public final ImageView ivClose;
    public final RelativeLayout layout1;
    public final RelativeLayout layout2;
    public final RelativeLayout layout3;
    public final LinearLayout layout4;
    public final Button leaderBoardBtn;
    public final RelativeLayout leaderboardDrag;
    public final RelativeLayout leaderboardRL;
    public final RelativeLayout mainlayout;
    public final ImageView myImageIcon;
    public final FrameLayout outerTouchArea;
    public final RelativeLayout pollDrag;
    public final RelativeLayout pollRL;
    public final TextView pollTime;
    public final TextView pollTypeTxt;
    public final RelativeLayout quesLL;
    public final RecyclerView recyclerViewPollRank;
    public final RecyclerView recyclerViewRank;
    public final Button resultBtn;
    public final Button resultBtnTwo;
    private final FrameLayout rootView;
    public final TextView student1;
    public final TextView student2;
    public final TextView student3;
    public final TextView studentOne;
    public final TextView studentThree;
    public final TextView studentTwo;
    public final Button submit;
    public final TextView time;
    public final RelativeLayout topHeader;
    public final TextView txtQues;
    public final LayoutItemPollQuestionsNextToppersBinding typeA;
    public final LayoutItemPollQuestionsNextToppersBinding typeB;
    public final LayoutItemPollQuestionsNextToppersBinding typeC;
    public final LayoutItemPollQuestionsNextToppersBinding typeD;

    private DialogPollAttemptBinding(FrameLayout rootView, RelativeLayout RelPollRank, RelativeLayout RlEnd, RelativeLayout RlStart, CardView cardView1, CardView cardView2, CardView cardView3, LinearLayout cvrQuestions, ImageView ivClose, RelativeLayout layout1, RelativeLayout layout2, RelativeLayout layout3, LinearLayout layout4, Button leaderBoardBtn, RelativeLayout leaderboardDrag, RelativeLayout leaderboardRL, RelativeLayout mainlayout, ImageView myImageIcon, FrameLayout outerTouchArea, RelativeLayout pollDrag, RelativeLayout pollRL, TextView pollTime, TextView pollTypeTxt, RelativeLayout quesLL, RecyclerView recyclerViewPollRank, RecyclerView recyclerViewRank, Button resultBtn, Button resultBtnTwo, TextView student1, TextView student2, TextView student3, TextView studentOne, TextView studentThree, TextView studentTwo, Button submit, TextView time, RelativeLayout topHeader, TextView txtQues, LayoutItemPollQuestionsNextToppersBinding typeA, LayoutItemPollQuestionsNextToppersBinding typeB, LayoutItemPollQuestionsNextToppersBinding typeC, LayoutItemPollQuestionsNextToppersBinding typeD) {
        this.rootView = rootView;
        this.RelPollRank = RelPollRank;
        this.RlEnd = RlEnd;
        this.RlStart = RlStart;
        this.cardView1 = cardView1;
        this.cardView2 = cardView2;
        this.cardView3 = cardView3;
        this.cvrQuestions = cvrQuestions;
        this.ivClose = ivClose;
        this.layout1 = layout1;
        this.layout2 = layout2;
        this.layout3 = layout3;
        this.layout4 = layout4;
        this.leaderBoardBtn = leaderBoardBtn;
        this.leaderboardDrag = leaderboardDrag;
        this.leaderboardRL = leaderboardRL;
        this.mainlayout = mainlayout;
        this.myImageIcon = myImageIcon;
        this.outerTouchArea = outerTouchArea;
        this.pollDrag = pollDrag;
        this.pollRL = pollRL;
        this.pollTime = pollTime;
        this.pollTypeTxt = pollTypeTxt;
        this.quesLL = quesLL;
        this.recyclerViewPollRank = recyclerViewPollRank;
        this.recyclerViewRank = recyclerViewRank;
        this.resultBtn = resultBtn;
        this.resultBtnTwo = resultBtnTwo;
        this.student1 = student1;
        this.student2 = student2;
        this.student3 = student3;
        this.studentOne = studentOne;
        this.studentThree = studentThree;
        this.studentTwo = studentTwo;
        this.submit = submit;
        this.time = time;
        this.topHeader = topHeader;
        this.txtQues = txtQues;
        this.typeA = typeA;
        this.typeB = typeB;
        this.typeC = typeC;
        this.typeD = typeD;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogPollAttemptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogPollAttemptBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_poll_attempt, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogPollAttemptBinding bind(View rootView) {
        int i = R.id.RelPollRank;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RelPollRank);
        if (relativeLayout != null) {
            i = R.id.RlEnd;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RlEnd);
            if (relativeLayout2 != null) {
                i = R.id.RlStart;
                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RlStart);
                if (relativeLayout3 != null) {
                    i = R.id.cardView1;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.cardView1);
                    if (cardView != null) {
                        i = R.id.cardView2;
                        CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.cardView2);
                        if (cardView2 != null) {
                            i = R.id.cardView3;
                            CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, R.id.cardView3);
                            if (cardView3 != null) {
                                i = R.id.cvrQuestions;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrQuestions);
                                if (linearLayout != null) {
                                    i = R.id.ivClose;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivClose);
                                    if (imageView != null) {
                                        i = R.id.layout1;
                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout1);
                                        if (relativeLayout4 != null) {
                                            i = R.id.layout2;
                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout2);
                                            if (relativeLayout5 != null) {
                                                i = R.id.layout3;
                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout3);
                                                if (relativeLayout6 != null) {
                                                    i = R.id.layout4;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout4);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.leaderBoardBtn;
                                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.leaderBoardBtn);
                                                        if (button != null) {
                                                            i = R.id.leaderboardDrag;
                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.leaderboardDrag);
                                                            if (relativeLayout7 != null) {
                                                                i = R.id.leaderboardRL;
                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.leaderboardRL);
                                                                if (relativeLayout8 != null) {
                                                                    i = R.id.mainlayout;
                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mainlayout);
                                                                    if (relativeLayout9 != null) {
                                                                        i = R.id.my_image_icon;
                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.my_image_icon);
                                                                        if (imageView2 != null) {
                                                                            FrameLayout frameLayout = (FrameLayout) rootView;
                                                                            i = R.id.pollDrag;
                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pollDrag);
                                                                            if (relativeLayout10 != null) {
                                                                                i = R.id.pollRL;
                                                                                RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pollRL);
                                                                                if (relativeLayout11 != null) {
                                                                                    i = R.id.pollTime;
                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.pollTime);
                                                                                    if (textView != null) {
                                                                                        i = R.id.pollTypeTxt;
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pollTypeTxt);
                                                                                        if (textView2 != null) {
                                                                                            i = R.id.quesLL;
                                                                                            RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.quesLL);
                                                                                            if (relativeLayout12 != null) {
                                                                                                i = R.id.recyclerViewPollRank;
                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recyclerViewPollRank);
                                                                                                if (recyclerView != null) {
                                                                                                    i = R.id.recyclerViewRank;
                                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recyclerViewRank);
                                                                                                    if (recyclerView2 != null) {
                                                                                                        i = R.id.resultBtn;
                                                                                                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.resultBtn);
                                                                                                        if (button2 != null) {
                                                                                                            i = R.id.resultBtnTwo;
                                                                                                            Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.resultBtnTwo);
                                                                                                            if (button3 != null) {
                                                                                                                i = R.id.student1;
                                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student1);
                                                                                                                if (textView3 != null) {
                                                                                                                    i = R.id.student2;
                                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student2);
                                                                                                                    if (textView4 != null) {
                                                                                                                        i = R.id.student3;
                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student3);
                                                                                                                        if (textView5 != null) {
                                                                                                                            i = R.id.studentOne;
                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentOne);
                                                                                                                            if (textView6 != null) {
                                                                                                                                i = R.id.studentThree;
                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentThree);
                                                                                                                                if (textView7 != null) {
                                                                                                                                    i = R.id.studentTwo;
                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentTwo);
                                                                                                                                    if (textView8 != null) {
                                                                                                                                        i = R.id.submit;
                                                                                                                                        Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.submit);
                                                                                                                                        if (button4 != null) {
                                                                                                                                            i = R.id.time;
                                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.time);
                                                                                                                                            if (textView9 != null) {
                                                                                                                                                i = R.id.topHeader;
                                                                                                                                                RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.topHeader);
                                                                                                                                                if (relativeLayout13 != null) {
                                                                                                                                                    i = R.id.txtQues;
                                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtQues);
                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                        i = R.id.typeA;
                                                                                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.typeA);
                                                                                                                                                        if (viewFindChildViewById != null) {
                                                                                                                                                            LayoutItemPollQuestionsNextToppersBinding layoutItemPollQuestionsNextToppersBindingBind = LayoutItemPollQuestionsNextToppersBinding.bind(viewFindChildViewById);
                                                                                                                                                            i = R.id.typeB;
                                                                                                                                                            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.typeB);
                                                                                                                                                            if (viewFindChildViewById2 != null) {
                                                                                                                                                                LayoutItemPollQuestionsNextToppersBinding layoutItemPollQuestionsNextToppersBindingBind2 = LayoutItemPollQuestionsNextToppersBinding.bind(viewFindChildViewById2);
                                                                                                                                                                i = R.id.typeC;
                                                                                                                                                                View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.typeC);
                                                                                                                                                                if (viewFindChildViewById3 != null) {
                                                                                                                                                                    LayoutItemPollQuestionsNextToppersBinding layoutItemPollQuestionsNextToppersBindingBind3 = LayoutItemPollQuestionsNextToppersBinding.bind(viewFindChildViewById3);
                                                                                                                                                                    i = R.id.typeD;
                                                                                                                                                                    View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.typeD);
                                                                                                                                                                    if (viewFindChildViewById4 != null) {
                                                                                                                                                                        return new DialogPollAttemptBinding(frameLayout, relativeLayout, relativeLayout2, relativeLayout3, cardView, cardView2, cardView3, linearLayout, imageView, relativeLayout4, relativeLayout5, relativeLayout6, linearLayout2, button, relativeLayout7, relativeLayout8, relativeLayout9, imageView2, frameLayout, relativeLayout10, relativeLayout11, textView, textView2, relativeLayout12, recyclerView, recyclerView2, button2, button3, textView3, textView4, textView5, textView6, textView7, textView8, button4, textView9, relativeLayout13, textView10, layoutItemPollQuestionsNextToppersBindingBind, layoutItemPollQuestionsNextToppersBindingBind2, layoutItemPollQuestionsNextToppersBindingBind3, LayoutItemPollQuestionsNextToppersBinding.bind(viewFindChildViewById4));
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
