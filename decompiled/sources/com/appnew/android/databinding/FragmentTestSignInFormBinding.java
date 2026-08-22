package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentTestSignInFormBinding implements ViewBinding {
    public final RelativeLayout BloodGroup;
    public final RelativeLayout Caste;
    public final RelativeLayout Gender;
    public final EditText aadharTV;
    public final View addressProgressBar;
    public final TextView bloodGroupSpinner;
    public final Button buyNowBtn;
    public final View cartProgressBar;
    public final TextView casteSpinner;
    public final CheckBox checkboxWhatsaap;
    public final RelativeLayout dobRl;
    public final TextView dobTV;
    public final RelativeLayout dobTopRl;
    public final ImageView downArrowIV1;
    public final ImageView downarrowCasteIV;
    public final ImageView downarrowGenderIV;
    public final ImageView downarrowbloodGroupIV;
    public final EditText emailTV;
    public final TextView firstProgressBarText;
    public final View fourthProgressBar;
    public final TextView fourthProgressBarText;
    public final TextView genderSpinner;
    public final TextView gstTeg;
    public final ImageView ivBack;
    public final EditText lastSchoolNameTV;
    public final EditText lastStudentIdTv;
    public final LinearLayout llBottom;
    public final LinearLayout llBottom1;
    public final LinearLayout llBottomPrice;
    public final EditText mobileTV;
    public final TextView mrpCutTV;
    public final EditText nameTV;
    public final RelativeLayout naraynaRelative;
    public final View paymentProgressBar;
    public final LinearLayout paymentStepProgress;
    public final LinearLayout paymentStepProgress1;
    public final ImageView presentClassDropDown;
    public final RelativeLayout presentClassRelative;
    public final TextView presentClassTextView;
    public final Button previousBtn;
    public final LinearLayout priceLL;
    public final TextView priceTV;
    public final TextView pricetext;
    public final CircleImageView profileImage;
    public final RelativeLayout rlChooshPhoto;
    public final RelativeLayout rlMain;
    private final RelativeLayout rootView;
    public final TextView secondProgressBarText;
    public final ImageView selectStudentDropDown;
    public final TextView studentFormTextView;
    public final RelativeLayout svMain;
    public final TextView thirdProgressBarText;
    public final TextView title;
    public final TextView tvBloodGroupError;
    public final TextView tvCasteError;
    public final TextView tvDobError;
    public final TextView tvGenderError;
    public final TextView tvPresentClassError;
    public final TextView tvSelectStudentError;
    public final TextView tvStudentIdHint;
    public final TextView tvWhattsappHint;
    public final RelativeLayout uploadImg;
    public final View view0;
    public final View view11;
    public final View viewAdhar;
    public final View viewBlood;
    public final View viewBottom;
    public final View viewC;
    public final View viewG;
    public final View viewLastSchool;
    public final View viewPresent;
    public final View viewStudent;
    public final EditText whattspNumberTv;

    private FragmentTestSignInFormBinding(RelativeLayout rootView, RelativeLayout BloodGroup, RelativeLayout Caste, RelativeLayout Gender, EditText aadharTV, View addressProgressBar, TextView bloodGroupSpinner, Button buyNowBtn, View cartProgressBar, TextView casteSpinner, CheckBox checkboxWhatsaap, RelativeLayout dobRl, TextView dobTV, RelativeLayout dobTopRl, ImageView downArrowIV1, ImageView downarrowCasteIV, ImageView downarrowGenderIV, ImageView downarrowbloodGroupIV, EditText emailTV, TextView firstProgressBarText, View fourthProgressBar, TextView fourthProgressBarText, TextView genderSpinner, TextView gstTeg, ImageView ivBack, EditText lastSchoolNameTV, EditText lastStudentIdTv, LinearLayout llBottom, LinearLayout llBottom1, LinearLayout llBottomPrice, EditText mobileTV, TextView mrpCutTV, EditText nameTV, RelativeLayout naraynaRelative, View paymentProgressBar, LinearLayout paymentStepProgress, LinearLayout paymentStepProgress1, ImageView presentClassDropDown, RelativeLayout presentClassRelative, TextView presentClassTextView, Button previousBtn, LinearLayout priceLL, TextView priceTV, TextView pricetext, CircleImageView profileImage, RelativeLayout rlChooshPhoto, RelativeLayout rlMain, TextView secondProgressBarText, ImageView selectStudentDropDown, TextView studentFormTextView, RelativeLayout svMain, TextView thirdProgressBarText, TextView title, TextView tvBloodGroupError, TextView tvCasteError, TextView tvDobError, TextView tvGenderError, TextView tvPresentClassError, TextView tvSelectStudentError, TextView tvStudentIdHint, TextView tvWhattsappHint, RelativeLayout uploadImg, View view0, View view11, View viewAdhar, View viewBlood, View viewBottom, View viewC, View viewG, View viewLastSchool, View viewPresent, View viewStudent, EditText whattspNumberTv) {
        this.rootView = rootView;
        this.BloodGroup = BloodGroup;
        this.Caste = Caste;
        this.Gender = Gender;
        this.aadharTV = aadharTV;
        this.addressProgressBar = addressProgressBar;
        this.bloodGroupSpinner = bloodGroupSpinner;
        this.buyNowBtn = buyNowBtn;
        this.cartProgressBar = cartProgressBar;
        this.casteSpinner = casteSpinner;
        this.checkboxWhatsaap = checkboxWhatsaap;
        this.dobRl = dobRl;
        this.dobTV = dobTV;
        this.dobTopRl = dobTopRl;
        this.downArrowIV1 = downArrowIV1;
        this.downarrowCasteIV = downarrowCasteIV;
        this.downarrowGenderIV = downarrowGenderIV;
        this.downarrowbloodGroupIV = downarrowbloodGroupIV;
        this.emailTV = emailTV;
        this.firstProgressBarText = firstProgressBarText;
        this.fourthProgressBar = fourthProgressBar;
        this.fourthProgressBarText = fourthProgressBarText;
        this.genderSpinner = genderSpinner;
        this.gstTeg = gstTeg;
        this.ivBack = ivBack;
        this.lastSchoolNameTV = lastSchoolNameTV;
        this.lastStudentIdTv = lastStudentIdTv;
        this.llBottom = llBottom;
        this.llBottom1 = llBottom1;
        this.llBottomPrice = llBottomPrice;
        this.mobileTV = mobileTV;
        this.mrpCutTV = mrpCutTV;
        this.nameTV = nameTV;
        this.naraynaRelative = naraynaRelative;
        this.paymentProgressBar = paymentProgressBar;
        this.paymentStepProgress = paymentStepProgress;
        this.paymentStepProgress1 = paymentStepProgress1;
        this.presentClassDropDown = presentClassDropDown;
        this.presentClassRelative = presentClassRelative;
        this.presentClassTextView = presentClassTextView;
        this.previousBtn = previousBtn;
        this.priceLL = priceLL;
        this.priceTV = priceTV;
        this.pricetext = pricetext;
        this.profileImage = profileImage;
        this.rlChooshPhoto = rlChooshPhoto;
        this.rlMain = rlMain;
        this.secondProgressBarText = secondProgressBarText;
        this.selectStudentDropDown = selectStudentDropDown;
        this.studentFormTextView = studentFormTextView;
        this.svMain = svMain;
        this.thirdProgressBarText = thirdProgressBarText;
        this.title = title;
        this.tvBloodGroupError = tvBloodGroupError;
        this.tvCasteError = tvCasteError;
        this.tvDobError = tvDobError;
        this.tvGenderError = tvGenderError;
        this.tvPresentClassError = tvPresentClassError;
        this.tvSelectStudentError = tvSelectStudentError;
        this.tvStudentIdHint = tvStudentIdHint;
        this.tvWhattsappHint = tvWhattsappHint;
        this.uploadImg = uploadImg;
        this.view0 = view0;
        this.view11 = view11;
        this.viewAdhar = viewAdhar;
        this.viewBlood = viewBlood;
        this.viewBottom = viewBottom;
        this.viewC = viewC;
        this.viewG = viewG;
        this.viewLastSchool = viewLastSchool;
        this.viewPresent = viewPresent;
        this.viewStudent = viewStudent;
        this.whattspNumberTv = whattspNumberTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTestSignInFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTestSignInFormBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_test_sign_in_form, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTestSignInFormBinding bind(View rootView) {
        int i = R.id.BloodGroup;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.BloodGroup);
        if (relativeLayout != null) {
            i = R.id.Caste;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.Caste);
            if (relativeLayout2 != null) {
                i = R.id.Gender;
                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.Gender);
                if (relativeLayout3 != null) {
                    i = R.id.aadharTV;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.aadharTV);
                    if (editText != null) {
                        i = R.id.address_progress_bar;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.address_progress_bar);
                        if (viewFindChildViewById != null) {
                            i = R.id.bloodGroupSpinner;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.bloodGroupSpinner);
                            if (textView != null) {
                                i = R.id.buyNowBtn;
                                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buyNowBtn);
                                if (button != null) {
                                    i = R.id.cart_progress_bar;
                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.cart_progress_bar);
                                    if (viewFindChildViewById2 != null) {
                                        i = R.id.casteSpinner;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.casteSpinner);
                                        if (textView2 != null) {
                                            i = R.id.checkbox_whatsaap;
                                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.checkbox_whatsaap);
                                            if (checkBox != null) {
                                                i = R.id.dobRl;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.dobRl);
                                                if (relativeLayout4 != null) {
                                                    i = R.id.dobTV;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dobTV);
                                                    if (textView3 != null) {
                                                        i = R.id.dobTopRl;
                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.dobTopRl);
                                                        if (relativeLayout5 != null) {
                                                            i = R.id.downArrowIV1;
                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downArrowIV1);
                                                            if (imageView != null) {
                                                                i = R.id.downarrowCasteIV;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowCasteIV);
                                                                if (imageView2 != null) {
                                                                    i = R.id.downarrowGenderIV;
                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowGenderIV);
                                                                    if (imageView3 != null) {
                                                                        i = R.id.downarrowbloodGroupIV;
                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowbloodGroupIV);
                                                                        if (imageView4 != null) {
                                                                            i = R.id.emailTV;
                                                                            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.emailTV);
                                                                            if (editText2 != null) {
                                                                                i = R.id.first_progress_bar_text;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_progress_bar_text);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.fourth_progress_bar;
                                                                                    View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.fourth_progress_bar);
                                                                                    if (viewFindChildViewById3 != null) {
                                                                                        i = R.id.fourth_progress_bar_text;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fourth_progress_bar_text);
                                                                                        if (textView5 != null) {
                                                                                            i = R.id.genderSpinner;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.genderSpinner);
                                                                                            if (textView6 != null) {
                                                                                                i = R.id.gstTeg;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gstTeg);
                                                                                                if (textView7 != null) {
                                                                                                    i = R.id.iv_back;
                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                                                                                                    if (imageView5 != null) {
                                                                                                        i = R.id.lastSchoolNameTV;
                                                                                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.lastSchoolNameTV);
                                                                                                        if (editText3 != null) {
                                                                                                            i = R.id.last_student_id_tv;
                                                                                                            EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.last_student_id_tv);
                                                                                                            if (editText4 != null) {
                                                                                                                i = R.id.ll_bottom;
                                                                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_bottom);
                                                                                                                if (linearLayout != null) {
                                                                                                                    i = R.id.llBottom;
                                                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llBottom);
                                                                                                                    if (linearLayout2 != null) {
                                                                                                                        i = R.id.ll_bottom_price;
                                                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_bottom_price);
                                                                                                                        if (linearLayout3 != null) {
                                                                                                                            i = R.id.mobileTV;
                                                                                                                            EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobileTV);
                                                                                                                            if (editText5 != null) {
                                                                                                                                i = R.id.mrpCutTV;
                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    i = R.id.nameTV;
                                                                                                                                    EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                                                                                                                                    if (editText6 != null) {
                                                                                                                                        i = R.id.naraynaRelative;
                                                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.naraynaRelative);
                                                                                                                                        if (relativeLayout6 != null) {
                                                                                                                                            i = R.id.payment_progress_bar;
                                                                                                                                            View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.payment_progress_bar);
                                                                                                                                            if (viewFindChildViewById4 != null) {
                                                                                                                                                i = R.id.payment_step_progress;
                                                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.payment_step_progress);
                                                                                                                                                if (linearLayout4 != null) {
                                                                                                                                                    i = R.id.payment_step_progress_1;
                                                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.payment_step_progress_1);
                                                                                                                                                    if (linearLayout5 != null) {
                                                                                                                                                        i = R.id.presentClassDropDown;
                                                                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.presentClassDropDown);
                                                                                                                                                        if (imageView6 != null) {
                                                                                                                                                            i = R.id.presentClassRelative;
                                                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.presentClassRelative);
                                                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                                                i = R.id.presentClassTextView;
                                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.presentClassTextView);
                                                                                                                                                                if (textView9 != null) {
                                                                                                                                                                    i = R.id.previousBtn;
                                                                                                                                                                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.previousBtn);
                                                                                                                                                                    if (button2 != null) {
                                                                                                                                                                        i = R.id.priceLL;
                                                                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.priceLL);
                                                                                                                                                                        if (linearLayout6 != null) {
                                                                                                                                                                            i = R.id.priceTV;
                                                                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                                                                                                                                                            if (textView10 != null) {
                                                                                                                                                                                i = R.id.pricetext;
                                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pricetext);
                                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                                    i = R.id.profileImage;
                                                                                                                                                                                    CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                                                                                                                                                                    if (circleImageView != null) {
                                                                                                                                                                                        i = R.id.rl_choosh_photo;
                                                                                                                                                                                        RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_choosh_photo);
                                                                                                                                                                                        if (relativeLayout8 != null) {
                                                                                                                                                                                            i = R.id.rl_main;
                                                                                                                                                                                            RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_main);
                                                                                                                                                                                            if (relativeLayout9 != null) {
                                                                                                                                                                                                i = R.id.second_progress_bar_text;
                                                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.second_progress_bar_text);
                                                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                                                    i = R.id.selectStudentDropDown;
                                                                                                                                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.selectStudentDropDown);
                                                                                                                                                                                                    if (imageView7 != null) {
                                                                                                                                                                                                        i = R.id.studentFormTextView;
                                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentFormTextView);
                                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) rootView;
                                                                                                                                                                                                            i = R.id.third_progress_bar_text;
                                                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.third_progress_bar_text);
                                                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                                                i = R.id.title;
                                                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                                                    i = R.id.tv_bloodGroupError;
                                                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_bloodGroupError);
                                                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                                                        i = R.id.tv_casteError;
                                                                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_casteError);
                                                                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                                                                            i = R.id.tv_dobError;
                                                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_dobError);
                                                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                                                i = R.id.tv_genderError;
                                                                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_genderError);
                                                                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                                                                    i = R.id.tv_presentClassError;
                                                                                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_presentClassError);
                                                                                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                                                                                        i = R.id.tv_selectStudentError;
                                                                                                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_selectStudentError);
                                                                                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                                                                                            i = R.id.tv_student_id_hint;
                                                                                                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_student_id_hint);
                                                                                                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                                                                                                i = R.id.tv_whattsapp_hint;
                                                                                                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_whattsapp_hint);
                                                                                                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                                                                                                    i = R.id.uploadImg;
                                                                                                                                                                                                                                                    RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.uploadImg);
                                                                                                                                                                                                                                                    if (relativeLayout11 != null) {
                                                                                                                                                                                                                                                        i = R.id.view0;
                                                                                                                                                                                                                                                        View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.view0);
                                                                                                                                                                                                                                                        if (viewFindChildViewById5 != null) {
                                                                                                                                                                                                                                                            i = R.id.view11;
                                                                                                                                                                                                                                                            View viewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.view11);
                                                                                                                                                                                                                                                            if (viewFindChildViewById6 != null) {
                                                                                                                                                                                                                                                                i = R.id.viewAdhar;
                                                                                                                                                                                                                                                                View viewFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.viewAdhar);
                                                                                                                                                                                                                                                                if (viewFindChildViewById7 != null) {
                                                                                                                                                                                                                                                                    i = R.id.viewBlood;
                                                                                                                                                                                                                                                                    View viewFindChildViewById8 = ViewBindings.findChildViewById(rootView, R.id.viewBlood);
                                                                                                                                                                                                                                                                    if (viewFindChildViewById8 != null) {
                                                                                                                                                                                                                                                                        i = R.id.view_bottom;
                                                                                                                                                                                                                                                                        View viewFindChildViewById9 = ViewBindings.findChildViewById(rootView, R.id.view_bottom);
                                                                                                                                                                                                                                                                        if (viewFindChildViewById9 != null) {
                                                                                                                                                                                                                                                                            i = R.id.viewC;
                                                                                                                                                                                                                                                                            View viewFindChildViewById10 = ViewBindings.findChildViewById(rootView, R.id.viewC);
                                                                                                                                                                                                                                                                            if (viewFindChildViewById10 != null) {
                                                                                                                                                                                                                                                                                i = R.id.viewG;
                                                                                                                                                                                                                                                                                View viewFindChildViewById11 = ViewBindings.findChildViewById(rootView, R.id.viewG);
                                                                                                                                                                                                                                                                                if (viewFindChildViewById11 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.viewLastSchool;
                                                                                                                                                                                                                                                                                    View viewFindChildViewById12 = ViewBindings.findChildViewById(rootView, R.id.viewLastSchool);
                                                                                                                                                                                                                                                                                    if (viewFindChildViewById12 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.viewPresent;
                                                                                                                                                                                                                                                                                        View viewFindChildViewById13 = ViewBindings.findChildViewById(rootView, R.id.viewPresent);
                                                                                                                                                                                                                                                                                        if (viewFindChildViewById13 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.viewStudent;
                                                                                                                                                                                                                                                                                            View viewFindChildViewById14 = ViewBindings.findChildViewById(rootView, R.id.viewStudent);
                                                                                                                                                                                                                                                                                            if (viewFindChildViewById14 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.whattsp_number_tv;
                                                                                                                                                                                                                                                                                                EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.whattsp_number_tv);
                                                                                                                                                                                                                                                                                                if (editText7 != null) {
                                                                                                                                                                                                                                                                                                    return new FragmentTestSignInFormBinding(relativeLayout10, relativeLayout, relativeLayout2, relativeLayout3, editText, viewFindChildViewById, textView, button, viewFindChildViewById2, textView2, checkBox, relativeLayout4, textView3, relativeLayout5, imageView, imageView2, imageView3, imageView4, editText2, textView4, viewFindChildViewById3, textView5, textView6, textView7, imageView5, editText3, editText4, linearLayout, linearLayout2, linearLayout3, editText5, textView8, editText6, relativeLayout6, viewFindChildViewById4, linearLayout4, linearLayout5, imageView6, relativeLayout7, textView9, button2, linearLayout6, textView10, textView11, circleImageView, relativeLayout8, relativeLayout9, textView12, imageView7, textView13, relativeLayout10, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, relativeLayout11, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7, viewFindChildViewById8, viewFindChildViewById9, viewFindChildViewById10, viewFindChildViewById11, viewFindChildViewById12, viewFindChildViewById13, viewFindChildViewById14, editText7);
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
