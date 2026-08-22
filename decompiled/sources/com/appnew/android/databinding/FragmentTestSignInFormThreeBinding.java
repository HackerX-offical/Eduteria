package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentTestSignInFormThreeBinding implements ViewBinding {
    public final LinearLayout StateCityLR;
    public final Button buyNowBtn;
    public final TextView cityET;
    public final ImageView cityIV;
    public final RelativeLayout cityRL;
    public final TextView classroomCenetrTV;
    public final RelativeLayout classroomRL;
    public final ImageView downarrowClassroomIV;
    public final ImageView downarrowTestCenterIV;
    public final ImageView downarrowTestIV;
    public final TextView gstTeg;
    public final ImageView ivBack;
    public final LinearLayout llBottom;
    public final LinearLayout llCenterDetail;
    public final LinearLayout llTestCenter;
    public final TextView mrpCutTV;
    public final LinearLayout priceLL;
    public final TextView priceTV;
    public final TextView pricetext;
    public final RadioGroup radioGroup;
    public final RadioButton rbOffline;
    public final RadioButton rbOnline;
    public final RelativeLayout rlCenterAddress;
    public final RelativeLayout rlMain;
    private final RelativeLayout rootView;
    public final TextView scholorshipTestTV;
    public final TextView stateET;
    public final ImageView stateIV;
    public final RelativeLayout stateRL;
    public final RelativeLayout svMain;
    public final TextView testCenterAddressTV;
    public final RelativeLayout testCenterRL;
    public final TextView testCenterTV;
    public final TextView testCityET;
    public final ImageView testCityIV;
    public final RelativeLayout testCityRL;
    public final RelativeLayout testRL;
    public final RecyclerView testSlotRV;
    public final TextView testSlotTv;
    public final LinearLayout testStateCityLR;
    public final TextView testStateET;
    public final ImageView testStateIV;
    public final RelativeLayout testStateRL;
    public final TextView title;
    public final TextView tvClassroomError;
    public final TextView tvTestCenterAdd;
    public final TextView tvTestError;
    public final View viewAd;
    public final View viewAd1;
    public final View viewTest;
    public final View viewTestSlot;

    private FragmentTestSignInFormThreeBinding(RelativeLayout rootView, LinearLayout StateCityLR, Button buyNowBtn, TextView cityET, ImageView cityIV, RelativeLayout cityRL, TextView classroomCenetrTV, RelativeLayout classroomRL, ImageView downarrowClassroomIV, ImageView downarrowTestCenterIV, ImageView downarrowTestIV, TextView gstTeg, ImageView ivBack, LinearLayout llBottom, LinearLayout llCenterDetail, LinearLayout llTestCenter, TextView mrpCutTV, LinearLayout priceLL, TextView priceTV, TextView pricetext, RadioGroup radioGroup, RadioButton rbOffline, RadioButton rbOnline, RelativeLayout rlCenterAddress, RelativeLayout rlMain, TextView scholorshipTestTV, TextView stateET, ImageView stateIV, RelativeLayout stateRL, RelativeLayout svMain, TextView testCenterAddressTV, RelativeLayout testCenterRL, TextView testCenterTV, TextView testCityET, ImageView testCityIV, RelativeLayout testCityRL, RelativeLayout testRL, RecyclerView testSlotRV, TextView testSlotTv, LinearLayout testStateCityLR, TextView testStateET, ImageView testStateIV, RelativeLayout testStateRL, TextView title, TextView tvClassroomError, TextView tvTestCenterAdd, TextView tvTestError, View viewAd, View viewAd1, View viewTest, View viewTestSlot) {
        this.rootView = rootView;
        this.StateCityLR = StateCityLR;
        this.buyNowBtn = buyNowBtn;
        this.cityET = cityET;
        this.cityIV = cityIV;
        this.cityRL = cityRL;
        this.classroomCenetrTV = classroomCenetrTV;
        this.classroomRL = classroomRL;
        this.downarrowClassroomIV = downarrowClassroomIV;
        this.downarrowTestCenterIV = downarrowTestCenterIV;
        this.downarrowTestIV = downarrowTestIV;
        this.gstTeg = gstTeg;
        this.ivBack = ivBack;
        this.llBottom = llBottom;
        this.llCenterDetail = llCenterDetail;
        this.llTestCenter = llTestCenter;
        this.mrpCutTV = mrpCutTV;
        this.priceLL = priceLL;
        this.priceTV = priceTV;
        this.pricetext = pricetext;
        this.radioGroup = radioGroup;
        this.rbOffline = rbOffline;
        this.rbOnline = rbOnline;
        this.rlCenterAddress = rlCenterAddress;
        this.rlMain = rlMain;
        this.scholorshipTestTV = scholorshipTestTV;
        this.stateET = stateET;
        this.stateIV = stateIV;
        this.stateRL = stateRL;
        this.svMain = svMain;
        this.testCenterAddressTV = testCenterAddressTV;
        this.testCenterRL = testCenterRL;
        this.testCenterTV = testCenterTV;
        this.testCityET = testCityET;
        this.testCityIV = testCityIV;
        this.testCityRL = testCityRL;
        this.testRL = testRL;
        this.testSlotRV = testSlotRV;
        this.testSlotTv = testSlotTv;
        this.testStateCityLR = testStateCityLR;
        this.testStateET = testStateET;
        this.testStateIV = testStateIV;
        this.testStateRL = testStateRL;
        this.title = title;
        this.tvClassroomError = tvClassroomError;
        this.tvTestCenterAdd = tvTestCenterAdd;
        this.tvTestError = tvTestError;
        this.viewAd = viewAd;
        this.viewAd1 = viewAd1;
        this.viewTest = viewTest;
        this.viewTestSlot = viewTestSlot;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTestSignInFormThreeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTestSignInFormThreeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_test_sign_in_form_three, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTestSignInFormThreeBinding bind(View rootView) {
        int i = R.id.StateCityLR;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.StateCityLR);
        if (linearLayout != null) {
            i = R.id.buyNowBtn;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buyNowBtn);
            if (button != null) {
                i = R.id.cityET;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cityET);
                if (textView != null) {
                    i = R.id.cityIV;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cityIV);
                    if (imageView != null) {
                        i = R.id.cityRL;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cityRL);
                        if (relativeLayout != null) {
                            i = R.id.classroomCenetrTV;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.classroomCenetrTV);
                            if (textView2 != null) {
                                i = R.id.classroomRL;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.classroomRL);
                                if (relativeLayout2 != null) {
                                    i = R.id.downarrowClassroomIV;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowClassroomIV);
                                    if (imageView2 != null) {
                                        i = R.id.downarrowTestCenterIV;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowTestCenterIV);
                                        if (imageView3 != null) {
                                            i = R.id.downarrowTestIV;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowTestIV);
                                            if (imageView4 != null) {
                                                i = R.id.gstTeg;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gstTeg);
                                                if (textView3 != null) {
                                                    i = R.id.iv_back;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                                                    if (imageView5 != null) {
                                                        i = R.id.ll_bottom;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_bottom);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.ll_center_detail;
                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_center_detail);
                                                            if (linearLayout3 != null) {
                                                                i = R.id.ll_test_center;
                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_test_center);
                                                                if (linearLayout4 != null) {
                                                                    i = R.id.mrpCutTV;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                                                                    if (textView4 != null) {
                                                                        i = R.id.priceLL;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.priceLL);
                                                                        if (linearLayout5 != null) {
                                                                            i = R.id.priceTV;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                                                            if (textView5 != null) {
                                                                                i = R.id.pricetext;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pricetext);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.radioGroup;
                                                                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.radioGroup);
                                                                                    if (radioGroup != null) {
                                                                                        i = R.id.rb_offline;
                                                                                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb_offline);
                                                                                        if (radioButton != null) {
                                                                                            i = R.id.rb_online;
                                                                                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb_online);
                                                                                            if (radioButton2 != null) {
                                                                                                i = R.id.rl_center_address;
                                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_center_address);
                                                                                                if (relativeLayout3 != null) {
                                                                                                    i = R.id.rl_main;
                                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_main);
                                                                                                    if (relativeLayout4 != null) {
                                                                                                        i = R.id.scholorshipTestTV;
                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.scholorshipTestTV);
                                                                                                        if (textView7 != null) {
                                                                                                            i = R.id.stateET;
                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateET);
                                                                                                            if (textView8 != null) {
                                                                                                                i = R.id.stateIV;
                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.stateIV);
                                                                                                                if (imageView6 != null) {
                                                                                                                    i = R.id.stateRL;
                                                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.stateRL);
                                                                                                                    if (relativeLayout5 != null) {
                                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) rootView;
                                                                                                                        i = R.id.testCenterAddressTV;
                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testCenterAddressTV);
                                                                                                                        if (textView9 != null) {
                                                                                                                            i = R.id.testCenterRL;
                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.testCenterRL);
                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                i = R.id.testCenterTV;
                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testCenterTV);
                                                                                                                                if (textView10 != null) {
                                                                                                                                    i = R.id.test_cityET;
                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_cityET);
                                                                                                                                    if (textView11 != null) {
                                                                                                                                        i = R.id.test_cityIV;
                                                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.test_cityIV);
                                                                                                                                        if (imageView7 != null) {
                                                                                                                                            i = R.id.test_cityRL;
                                                                                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.test_cityRL);
                                                                                                                                            if (relativeLayout8 != null) {
                                                                                                                                                i = R.id.testRL;
                                                                                                                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.testRL);
                                                                                                                                                if (relativeLayout9 != null) {
                                                                                                                                                    i = R.id.testSlotRV;
                                                                                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.testSlotRV);
                                                                                                                                                    if (recyclerView != null) {
                                                                                                                                                        i = R.id.test_slot_tv;
                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_slot_tv);
                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                            i = R.id.test_StateCityLR;
                                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.test_StateCityLR);
                                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                                i = R.id.test_stateET;
                                                                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_stateET);
                                                                                                                                                                if (textView13 != null) {
                                                                                                                                                                    i = R.id.test_stateIV;
                                                                                                                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.test_stateIV);
                                                                                                                                                                    if (imageView8 != null) {
                                                                                                                                                                        i = R.id.test_stateRL;
                                                                                                                                                                        RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.test_stateRL);
                                                                                                                                                                        if (relativeLayout10 != null) {
                                                                                                                                                                            i = R.id.title;
                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                i = R.id.tv_classroomError;
                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_classroomError);
                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                    i = R.id.tv_test_center_add;
                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_test_center_add);
                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                        i = R.id.tv_testError;
                                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_testError);
                                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                                            i = R.id.viewAd;
                                                                                                                                                                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewAd);
                                                                                                                                                                                            if (viewFindChildViewById != null) {
                                                                                                                                                                                                i = R.id.viewAd1;
                                                                                                                                                                                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.viewAd1);
                                                                                                                                                                                                if (viewFindChildViewById2 != null) {
                                                                                                                                                                                                    i = R.id.viewTest;
                                                                                                                                                                                                    View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.viewTest);
                                                                                                                                                                                                    if (viewFindChildViewById3 != null) {
                                                                                                                                                                                                        i = R.id.viewTestSlot;
                                                                                                                                                                                                        View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.viewTestSlot);
                                                                                                                                                                                                        if (viewFindChildViewById4 != null) {
                                                                                                                                                                                                            return new FragmentTestSignInFormThreeBinding(relativeLayout6, linearLayout, button, textView, imageView, relativeLayout, textView2, relativeLayout2, imageView2, imageView3, imageView4, textView3, imageView5, linearLayout2, linearLayout3, linearLayout4, textView4, linearLayout5, textView5, textView6, radioGroup, radioButton, radioButton2, relativeLayout3, relativeLayout4, textView7, textView8, imageView6, relativeLayout5, relativeLayout6, textView9, relativeLayout7, textView10, textView11, imageView7, relativeLayout8, relativeLayout9, recyclerView, textView12, linearLayout6, textView13, imageView8, relativeLayout10, textView14, textView15, textView16, textView17, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
