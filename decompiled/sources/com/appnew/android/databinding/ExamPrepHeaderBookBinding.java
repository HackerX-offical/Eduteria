package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
public final class ExamPrepHeaderBookBinding implements ViewBinding {
    public final Button addButton;
    public final TextView authorname;
    public final TextView buyNowId;
    public final TextView cartCountText;
    public final ImageView cartIcon;
    public final TextView cartRating;
    public final RelativeLayout cartSection;
    public final ImageView courseImagebg;
    public final TextView courseName;
    public final TextView courseid;
    public final LinearLayout currentAffairRL;
    public final RelativeLayout cvrLayout;
    public final TextView dicountValue;
    public final RelativeLayout headerLL;
    public final TextView ibtSingleVdTvDay;
    public final LinearLayout imageRL;
    public final RelativeLayout inStockRL;
    public final TextView inStockText;
    public final LinearLayout layout1;
    public final ImageView liveIV;
    public final LinearLayoutCompat llCompat;
    public final RelativeLayout maiView;
    public final TextView mrpCutTV;
    public final ImageView newCourse;
    public final TextView offerinside;
    public final TextView priceTV;
    public final RelativeLayout quantityCountRL;
    public final TextView quantityText;
    public final RelativeLayout ratingRL;
    private final RelativeLayout rootView;
    public final TextView someText;
    public final Button subtractButton;
    public final RecyclerView tagRecyclerview;
    public final RelativeLayout tileRL;
    public final RecyclerView tileRv;
    public final TextView title;
    public final TextView tvCourseExpireDate;
    public final TextView tvStreamOffered;
    public final TextView type;
    public final TextView userRatedCounts;
    public final TextView validityTV;
    public final TextView validityTextTV;
    public final RelativeLayout videoplayerRL;

    private ExamPrepHeaderBookBinding(RelativeLayout rootView, Button addButton, TextView authorname, TextView buyNowId, TextView cartCountText, ImageView cartIcon, TextView cartRating, RelativeLayout cartSection, ImageView courseImagebg, TextView courseName, TextView courseid, LinearLayout currentAffairRL, RelativeLayout cvrLayout, TextView dicountValue, RelativeLayout headerLL, TextView ibtSingleVdTvDay, LinearLayout imageRL, RelativeLayout inStockRL, TextView inStockText, LinearLayout layout1, ImageView liveIV, LinearLayoutCompat llCompat, RelativeLayout maiView, TextView mrpCutTV, ImageView newCourse, TextView offerinside, TextView priceTV, RelativeLayout quantityCountRL, TextView quantityText, RelativeLayout ratingRL, TextView someText, Button subtractButton, RecyclerView tagRecyclerview, RelativeLayout tileRL, RecyclerView tileRv, TextView title, TextView tvCourseExpireDate, TextView tvStreamOffered, TextView type, TextView userRatedCounts, TextView validityTV, TextView validityTextTV, RelativeLayout videoplayerRL) {
        this.rootView = rootView;
        this.addButton = addButton;
        this.authorname = authorname;
        this.buyNowId = buyNowId;
        this.cartCountText = cartCountText;
        this.cartIcon = cartIcon;
        this.cartRating = cartRating;
        this.cartSection = cartSection;
        this.courseImagebg = courseImagebg;
        this.courseName = courseName;
        this.courseid = courseid;
        this.currentAffairRL = currentAffairRL;
        this.cvrLayout = cvrLayout;
        this.dicountValue = dicountValue;
        this.headerLL = headerLL;
        this.ibtSingleVdTvDay = ibtSingleVdTvDay;
        this.imageRL = imageRL;
        this.inStockRL = inStockRL;
        this.inStockText = inStockText;
        this.layout1 = layout1;
        this.liveIV = liveIV;
        this.llCompat = llCompat;
        this.maiView = maiView;
        this.mrpCutTV = mrpCutTV;
        this.newCourse = newCourse;
        this.offerinside = offerinside;
        this.priceTV = priceTV;
        this.quantityCountRL = quantityCountRL;
        this.quantityText = quantityText;
        this.ratingRL = ratingRL;
        this.someText = someText;
        this.subtractButton = subtractButton;
        this.tagRecyclerview = tagRecyclerview;
        this.tileRL = tileRL;
        this.tileRv = tileRv;
        this.title = title;
        this.tvCourseExpireDate = tvCourseExpireDate;
        this.tvStreamOffered = tvStreamOffered;
        this.type = type;
        this.userRatedCounts = userRatedCounts;
        this.validityTV = validityTV;
        this.validityTextTV = validityTextTV;
        this.videoplayerRL = videoplayerRL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepHeaderBookBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepHeaderBookBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_header_book, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepHeaderBookBinding bind(View rootView) {
        int i = R.id.addButton;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.addButton);
        if (button != null) {
            i = R.id.authorname;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.authorname);
            if (textView != null) {
                i = R.id.buyNowId;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.buyNowId);
                if (textView2 != null) {
                    i = R.id.cartCountText;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartCountText);
                    if (textView3 != null) {
                        i = R.id.cartIcon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cartIcon);
                        if (imageView != null) {
                            i = R.id.cartRating;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cartRating);
                            if (textView4 != null) {
                                i = R.id.cartSection;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cartSection);
                                if (relativeLayout != null) {
                                    i = R.id.courseImagebg;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImagebg);
                                    if (imageView2 != null) {
                                        i = R.id.course_name;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_name);
                                        if (textView5 != null) {
                                            i = R.id.courseid;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseid);
                                            if (textView6 != null) {
                                                i = R.id.currentAffairRL;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.currentAffairRL);
                                                if (linearLayout != null) {
                                                    i = R.id.cvrLayout;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLayout);
                                                    if (relativeLayout2 != null) {
                                                        i = R.id.dicount_value;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dicount_value);
                                                        if (textView7 != null) {
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) rootView;
                                                            i = R.id.ibt_single_vd_tv_day;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_tv_day);
                                                            if (textView8 != null) {
                                                                i = R.id.imageRL;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                                                                if (linearLayout2 != null) {
                                                                    i = R.id.inStockRL;
                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.inStockRL);
                                                                    if (relativeLayout4 != null) {
                                                                        i = R.id.inStockText;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.inStockText);
                                                                        if (textView9 != null) {
                                                                            i = R.id.layout1;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout1);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.liveIV;
                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                                                                if (imageView3 != null) {
                                                                                    i = R.id.ll_compat;
                                                                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.ll_compat);
                                                                                    if (linearLayoutCompat != null) {
                                                                                        i = R.id.maiView;
                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.maiView);
                                                                                        if (relativeLayout5 != null) {
                                                                                            i = R.id.mrpCutTV;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.new_course;
                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.new_course);
                                                                                                if (imageView4 != null) {
                                                                                                    i = R.id.offerinside;
                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.offerinside);
                                                                                                    if (textView11 != null) {
                                                                                                        i = R.id.priceTV;
                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                                                                                        if (textView12 != null) {
                                                                                                            i = R.id.quantityCountRL;
                                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.quantityCountRL);
                                                                                                            if (relativeLayout6 != null) {
                                                                                                                i = R.id.quantityText;
                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.quantityText);
                                                                                                                if (textView13 != null) {
                                                                                                                    i = R.id.ratingRL;
                                                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ratingRL);
                                                                                                                    if (relativeLayout7 != null) {
                                                                                                                        i = R.id.someText;
                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.someText);
                                                                                                                        if (textView14 != null) {
                                                                                                                            i = R.id.subtractButton;
                                                                                                                            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.subtractButton);
                                                                                                                            if (button2 != null) {
                                                                                                                                i = R.id.tag_recyclerview;
                                                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tag_recyclerview);
                                                                                                                                if (recyclerView != null) {
                                                                                                                                    i = R.id.tileRL;
                                                                                                                                    RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.tileRL);
                                                                                                                                    if (relativeLayout8 != null) {
                                                                                                                                        i = R.id.tileRv;
                                                                                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tileRv);
                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                            i = R.id.title;
                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                                                                                            if (textView15 != null) {
                                                                                                                                                i = R.id.tv_course_expire_date;
                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_course_expire_date);
                                                                                                                                                if (textView16 != null) {
                                                                                                                                                    i = R.id.tv_stream_offered;
                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_stream_offered);
                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                        i = R.id.type;
                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.type);
                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                            i = R.id.userRatedCounts;
                                                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userRatedCounts);
                                                                                                                                                            if (textView19 != null) {
                                                                                                                                                                i = R.id.validityTV;
                                                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTV);
                                                                                                                                                                if (textView20 != null) {
                                                                                                                                                                    i = R.id.validityTextTV;
                                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTextTV);
                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                        i = R.id.videoplayerRL;
                                                                                                                                                                        RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.videoplayerRL);
                                                                                                                                                                        if (relativeLayout9 != null) {
                                                                                                                                                                            return new ExamPrepHeaderBookBinding(relativeLayout3, button, textView, textView2, textView3, imageView, textView4, relativeLayout, imageView2, textView5, textView6, linearLayout, relativeLayout2, textView7, relativeLayout3, textView8, linearLayout2, relativeLayout4, textView9, linearLayout3, imageView3, linearLayoutCompat, relativeLayout5, textView10, imageView4, textView11, textView12, relativeLayout6, textView13, relativeLayout7, textView14, button2, recyclerView, relativeLayout8, recyclerView2, textView15, textView16, textView17, textView18, textView19, textView20, textView21, relativeLayout9);
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
