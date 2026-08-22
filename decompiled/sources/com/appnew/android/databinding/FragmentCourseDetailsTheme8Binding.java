package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentCourseDetailsTheme8Binding implements ViewBinding {
    public final TextView CourseContentTxt;
    public final TextView addGst;
    public final TextView addIngst;
    public final LinearLayout asktousLl;
    public final RelativeLayout buyNow;
    public final RelativeLayout buyNowLayout;
    public final RelativeLayout courseContentLayout;
    public final RelativeLayout courseDataView;
    public final ImageView courseImageIcon;
    public final TextView courseIntro;
    public final RelativeLayout courseIntroLayout;
    public final TextView courseIntroText;
    public final LinearLayout courseLayout;
    public final TextView courseName;
    public final TextView courseStartDate;
    public final TextView cutAmount;
    public final TextView deliveryId;
    public final TextView deliveryId1;
    public final TextView deliveryMethodText;
    public final TextView deliveryMethodText1;
    public final ImageView faq;
    public final ImageView features;
    public final ImageView hideImgData;
    public final TextView ibtSingleVdTvDay;
    public final ConstraintLayout imageRL;
    public final ImageView infoIcon;
    public final RelativeLayout introLayout;
    public final RelativeLayout layout;
    public final LinearLayout layoutFeatureFaq;
    public final ImageView liveIV;
    public final LinearLayout logoImageLL;
    public final NestedScrollView nestedScrollDashboard;
    public final NoDataFoundBinding noDataFond;
    public final RelativeLayout parentLayout;
    public final TextView price;
    public final RelativeLayout purchasedLayout;
    public final TextView purchasedLayoutButton;
    private final NestedScrollView rootView;
    public final ImageView share;
    public final ImageView showImgData;
    public final LinearLayoutCompat subscriptionSectionId;
    public final RecyclerView tagsrecyclerview;
    public final Button talktousBTN;
    public final TextView txtButton;
    public final TextView validityId;
    public final TextView validityText;
    public final WebView webViewDesc;

    private FragmentCourseDetailsTheme8Binding(NestedScrollView rootView, TextView CourseContentTxt, TextView addGst, TextView addIngst, LinearLayout asktousLl, RelativeLayout buyNow, RelativeLayout buyNowLayout, RelativeLayout courseContentLayout, RelativeLayout courseDataView, ImageView courseImageIcon, TextView courseIntro, RelativeLayout courseIntroLayout, TextView courseIntroText, LinearLayout courseLayout, TextView courseName, TextView courseStartDate, TextView cutAmount, TextView deliveryId, TextView deliveryId1, TextView deliveryMethodText, TextView deliveryMethodText1, ImageView faq, ImageView features, ImageView hideImgData, TextView ibtSingleVdTvDay, ConstraintLayout imageRL, ImageView infoIcon, RelativeLayout introLayout, RelativeLayout layout, LinearLayout layoutFeatureFaq, ImageView liveIV, LinearLayout logoImageLL, NestedScrollView nestedScrollDashboard, NoDataFoundBinding noDataFond, RelativeLayout parentLayout, TextView price, RelativeLayout purchasedLayout, TextView purchasedLayoutButton, ImageView share, ImageView showImgData, LinearLayoutCompat subscriptionSectionId, RecyclerView tagsrecyclerview, Button talktousBTN, TextView txtButton, TextView validityId, TextView validityText, WebView webViewDesc) {
        this.rootView = rootView;
        this.CourseContentTxt = CourseContentTxt;
        this.addGst = addGst;
        this.addIngst = addIngst;
        this.asktousLl = asktousLl;
        this.buyNow = buyNow;
        this.buyNowLayout = buyNowLayout;
        this.courseContentLayout = courseContentLayout;
        this.courseDataView = courseDataView;
        this.courseImageIcon = courseImageIcon;
        this.courseIntro = courseIntro;
        this.courseIntroLayout = courseIntroLayout;
        this.courseIntroText = courseIntroText;
        this.courseLayout = courseLayout;
        this.courseName = courseName;
        this.courseStartDate = courseStartDate;
        this.cutAmount = cutAmount;
        this.deliveryId = deliveryId;
        this.deliveryId1 = deliveryId1;
        this.deliveryMethodText = deliveryMethodText;
        this.deliveryMethodText1 = deliveryMethodText1;
        this.faq = faq;
        this.features = features;
        this.hideImgData = hideImgData;
        this.ibtSingleVdTvDay = ibtSingleVdTvDay;
        this.imageRL = imageRL;
        this.infoIcon = infoIcon;
        this.introLayout = introLayout;
        this.layout = layout;
        this.layoutFeatureFaq = layoutFeatureFaq;
        this.liveIV = liveIV;
        this.logoImageLL = logoImageLL;
        this.nestedScrollDashboard = nestedScrollDashboard;
        this.noDataFond = noDataFond;
        this.parentLayout = parentLayout;
        this.price = price;
        this.purchasedLayout = purchasedLayout;
        this.purchasedLayoutButton = purchasedLayoutButton;
        this.share = share;
        this.showImgData = showImgData;
        this.subscriptionSectionId = subscriptionSectionId;
        this.tagsrecyclerview = tagsrecyclerview;
        this.talktousBTN = talktousBTN;
        this.txtButton = txtButton;
        this.validityId = validityId;
        this.validityText = validityText;
        this.webViewDesc = webViewDesc;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentCourseDetailsTheme8Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCourseDetailsTheme8Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_course_details_theme8, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCourseDetailsTheme8Binding bind(View rootView) {
        int i = R.id._course_content_txt;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id._course_content_txt);
        if (textView != null) {
            i = R.id.add_gst;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_gst);
            if (textView2 != null) {
                i = R.id.add_ingst;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_ingst);
                if (textView3 != null) {
                    i = R.id.asktous_ll;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.asktous_ll);
                    if (linearLayout != null) {
                        i = R.id.buy_now;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.buy_now);
                        if (relativeLayout != null) {
                            i = R.id.buy_now_layout;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.buy_now_layout);
                            if (relativeLayout2 != null) {
                                i = R.id.course_content_layout;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.course_content_layout);
                                if (relativeLayout3 != null) {
                                    i = R.id.course_data_view;
                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.course_data_view);
                                    if (relativeLayout4 != null) {
                                        i = R.id.courseImageIcon;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImageIcon);
                                        if (imageView != null) {
                                            i = R.id.course_intro;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_intro);
                                            if (textView4 != null) {
                                                i = R.id.course_intro_layout;
                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.course_intro_layout);
                                                if (relativeLayout5 != null) {
                                                    i = R.id.course_intro_text;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_intro_text);
                                                    if (textView5 != null) {
                                                        i = R.id.course_layout;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.course_layout);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.course_name;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_name);
                                                            if (textView6 != null) {
                                                                i = R.id.course_start_date;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_start_date);
                                                                if (textView7 != null) {
                                                                    i = R.id.cut_amount;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cut_amount);
                                                                    if (textView8 != null) {
                                                                        i = R.id.deliveryId;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.deliveryId);
                                                                        if (textView9 != null) {
                                                                            i = R.id.deliveryId1;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.deliveryId1);
                                                                            if (textView10 != null) {
                                                                                i = R.id.deliveryMethodText;
                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.deliveryMethodText);
                                                                                if (textView11 != null) {
                                                                                    i = R.id.deliveryMethodText1;
                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.deliveryMethodText1);
                                                                                    if (textView12 != null) {
                                                                                        i = R.id.faq;
                                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.faq);
                                                                                        if (imageView2 != null) {
                                                                                            i = R.id.features;
                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.features);
                                                                                            if (imageView3 != null) {
                                                                                                i = R.id.hide_img_data;
                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.hide_img_data);
                                                                                                if (imageView4 != null) {
                                                                                                    i = R.id.ibt_single_vd_tv_day;
                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_tv_day);
                                                                                                    if (textView13 != null) {
                                                                                                        i = R.id.imageRL;
                                                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                                                                                                        if (constraintLayout != null) {
                                                                                                            i = R.id.info_icon;
                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.info_icon);
                                                                                                            if (imageView5 != null) {
                                                                                                                i = R.id.intro_layout;
                                                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.intro_layout);
                                                                                                                if (relativeLayout6 != null) {
                                                                                                                    i = R.id.layout;
                                                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout);
                                                                                                                    if (relativeLayout7 != null) {
                                                                                                                        i = R.id.layout_feature_faq;
                                                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_feature_faq);
                                                                                                                        if (linearLayout3 != null) {
                                                                                                                            i = R.id.liveIV;
                                                                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                                                                                                            if (imageView6 != null) {
                                                                                                                                i = R.id.logoImageLL;
                                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.logoImageLL);
                                                                                                                                if (linearLayout4 != null) {
                                                                                                                                    i = R.id.nestedScroll_dashboard;
                                                                                                                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nestedScroll_dashboard);
                                                                                                                                    if (nestedScrollView != null) {
                                                                                                                                        i = R.id.no_data_fond;
                                                                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.no_data_fond);
                                                                                                                                        if (viewFindChildViewById != null) {
                                                                                                                                            NoDataFoundBinding noDataFoundBindingBind = NoDataFoundBinding.bind(viewFindChildViewById);
                                                                                                                                            i = R.id.parent_layout;
                                                                                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parent_layout);
                                                                                                                                            if (relativeLayout8 != null) {
                                                                                                                                                i = R.id.price;
                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.price);
                                                                                                                                                if (textView14 != null) {
                                                                                                                                                    i = R.id.purchased_layout;
                                                                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.purchased_layout);
                                                                                                                                                    if (relativeLayout9 != null) {
                                                                                                                                                        i = R.id.purchased_layout_button;
                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.purchased_layout_button);
                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                            i = R.id.share;
                                                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                                                                                                                                            if (imageView7 != null) {
                                                                                                                                                                i = R.id.show_img_data;
                                                                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.show_img_data);
                                                                                                                                                                if (imageView8 != null) {
                                                                                                                                                                    i = R.id.subscriptionSectionId;
                                                                                                                                                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.subscriptionSectionId);
                                                                                                                                                                    if (linearLayoutCompat != null) {
                                                                                                                                                                        i = R.id.tagsrecyclerview;
                                                                                                                                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tagsrecyclerview);
                                                                                                                                                                        if (recyclerView != null) {
                                                                                                                                                                            i = R.id.talktousBTN;
                                                                                                                                                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.talktousBTN);
                                                                                                                                                                            if (button != null) {
                                                                                                                                                                                i = R.id.txt_button;
                                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_button);
                                                                                                                                                                                if (textView16 != null) {
                                                                                                                                                                                    i = R.id.validityId;
                                                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityId);
                                                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                                                        i = R.id.validityText;
                                                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityText);
                                                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                                                            i = R.id.webViewDesc;
                                                                                                                                                                                            WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.webViewDesc);
                                                                                                                                                                                            if (webView != null) {
                                                                                                                                                                                                return new FragmentCourseDetailsTheme8Binding((NestedScrollView) rootView, textView, textView2, textView3, linearLayout, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, imageView, textView4, relativeLayout5, textView5, linearLayout2, textView6, textView7, textView8, textView9, textView10, textView11, textView12, imageView2, imageView3, imageView4, textView13, constraintLayout, imageView5, relativeLayout6, relativeLayout7, linearLayout3, imageView6, linearLayout4, nestedScrollView, noDataFoundBindingBind, relativeLayout8, textView14, relativeLayout9, textView15, imageView7, imageView8, linearLayoutCompat, recyclerView, button, textView16, textView17, textView18, webView);
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
