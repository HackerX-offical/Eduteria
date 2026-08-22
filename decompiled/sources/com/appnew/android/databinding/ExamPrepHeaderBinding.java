package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExamPrepHeaderBinding implements ViewBinding {
    public final TextView authorname;
    public final LinearLayout buyNowButtonRL;
    public final TextView buyNowPrice;
    public final TextView buyNowText;
    public final ImageView courseImagebg;
    public final TextView courseName;
    public final TextView courseid;
    public final LinearLayout demoVideoLL;
    public final TextView headSyllabusTV;
    public final TextView headVideoTV;
    public final RelativeLayout headerLL;
    public final LinearLayout imageRL;
    public final LinearLayoutCompat llCompat;
    public final LinearLayout llScholorshipDiscount;
    public final LinearLayout newBuyNewButtonLL;
    public final LinearLayout rateYouLL;
    public final TextView ratingCount;
    private final RelativeLayout rootView;
    public final TextView scholarshipCouponTV;
    public final FrameLayout soldOutImg;
    public final LinearLayout syllabusLL;
    public final RecyclerView tileRv;
    public final TextView type;
    public final TextView validityTV;

    private ExamPrepHeaderBinding(RelativeLayout rootView, TextView authorname, LinearLayout buyNowButtonRL, TextView buyNowPrice, TextView buyNowText, ImageView courseImagebg, TextView courseName, TextView courseid, LinearLayout demoVideoLL, TextView headSyllabusTV, TextView headVideoTV, RelativeLayout headerLL, LinearLayout imageRL, LinearLayoutCompat llCompat, LinearLayout llScholorshipDiscount, LinearLayout newBuyNewButtonLL, LinearLayout rateYouLL, TextView ratingCount, TextView scholarshipCouponTV, FrameLayout soldOutImg, LinearLayout syllabusLL, RecyclerView tileRv, TextView type, TextView validityTV) {
        this.rootView = rootView;
        this.authorname = authorname;
        this.buyNowButtonRL = buyNowButtonRL;
        this.buyNowPrice = buyNowPrice;
        this.buyNowText = buyNowText;
        this.courseImagebg = courseImagebg;
        this.courseName = courseName;
        this.courseid = courseid;
        this.demoVideoLL = demoVideoLL;
        this.headSyllabusTV = headSyllabusTV;
        this.headVideoTV = headVideoTV;
        this.headerLL = headerLL;
        this.imageRL = imageRL;
        this.llCompat = llCompat;
        this.llScholorshipDiscount = llScholorshipDiscount;
        this.newBuyNewButtonLL = newBuyNewButtonLL;
        this.rateYouLL = rateYouLL;
        this.ratingCount = ratingCount;
        this.scholarshipCouponTV = scholarshipCouponTV;
        this.soldOutImg = soldOutImg;
        this.syllabusLL = syllabusLL;
        this.tileRv = tileRv;
        this.type = type;
        this.validityTV = validityTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepHeaderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepHeaderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_header, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepHeaderBinding bind(View rootView) {
        int i = R.id.authorname;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.authorname);
        if (textView != null) {
            i = R.id.buyNowButton_RL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.buyNowButton_RL);
            if (linearLayout != null) {
                i = R.id.buyNow_price;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.buyNow_price);
                if (textView2 != null) {
                    i = R.id.buyNow_text;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.buyNow_text);
                    if (textView3 != null) {
                        i = R.id.courseImagebg;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImagebg);
                        if (imageView != null) {
                            i = R.id.course_name;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_name);
                            if (textView4 != null) {
                                i = R.id.courseid;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseid);
                                if (textView5 != null) {
                                    i = R.id.demoVideoLL;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.demoVideoLL);
                                    if (linearLayout2 != null) {
                                        i = R.id.headSyllabus_TV;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.headSyllabus_TV);
                                        if (textView6 != null) {
                                            i = R.id.headVideo_TV;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.headVideo_TV);
                                            if (textView7 != null) {
                                                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                                                i = R.id.imageRL;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                                                if (linearLayout3 != null) {
                                                    i = R.id.ll_compat;
                                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.ll_compat);
                                                    if (linearLayoutCompat != null) {
                                                        i = R.id.ll_scholorship_discount;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_scholorship_discount);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.newBuyNewButtonLL;
                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.newBuyNewButtonLL);
                                                            if (linearLayout5 != null) {
                                                                i = R.id.rateYouLL;
                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rateYouLL);
                                                                if (linearLayout6 != null) {
                                                                    i = R.id.ratingCount;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ratingCount);
                                                                    if (textView8 != null) {
                                                                        i = R.id.scholarshipCouponTV;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.scholarshipCouponTV);
                                                                        if (textView9 != null) {
                                                                            i = R.id.soldOutImg;
                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.soldOutImg);
                                                                            if (frameLayout != null) {
                                                                                i = R.id.syllabusLL;
                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.syllabusLL);
                                                                                if (linearLayout7 != null) {
                                                                                    i = R.id.tileRv;
                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tileRv);
                                                                                    if (recyclerView != null) {
                                                                                        i = R.id.type;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.type);
                                                                                        if (textView10 != null) {
                                                                                            i = R.id.validityTV;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTV);
                                                                                            if (textView11 != null) {
                                                                                                return new ExamPrepHeaderBinding(relativeLayout, textView, linearLayout, textView2, textView3, imageView, textView4, textView5, linearLayout2, textView6, textView7, relativeLayout, linearLayout3, linearLayoutCompat, linearLayout4, linearLayout5, linearLayout6, textView8, textView9, frameLayout, linearLayout7, recyclerView, textView10, textView11);
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
