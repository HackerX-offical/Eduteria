package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.LabeledEditText;
import com.eduteria.app.app.R;
import com.google.android.material.textfield.TextInputLayout;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentSignupFormNewBinding implements ViewBinding {
    public final RelativeLayout Caste;
    public final RelativeLayout Gender;
    public final RelativeLayout Language;
    public final RelativeLayout State;
    public final LabeledEditText addressTV;
    public final LabeledEditText alternateMobileTV;
    public final ImageView arrowFlag;
    public final TextView casteSpinner;
    public final TextView categorySpinner;
    public final RelativeLayout categorySpinnerLayout;
    public final RelativeLayout city;
    public final ImageView cityimage;
    public final LabeledEditText confirmPasswordET;
    public final RelativeLayout country;
    public final TextView countrySpinner;
    public final RelativeLayout countryTopRl;
    public final ImageView datePickerIV;
    public final EditText districtSpinner;
    public final TextView districtSpinnerTV;
    public final RelativeLayout dobRl;
    public final TextView dobTV;
    public final RelativeLayout dobTopRl;
    public final ImageView downArrowIV;
    public final ImageView downArrowIV1;
    public final ImageView downarrowCasteIV;
    public final ImageView downarrowGenderIV;
    public final ImageView downarrowIV;
    public final ImageView downarrowIV2;
    public final ImageView downarrowIV3;
    public final ImageView downarrowIV4;
    public final ImageView downarrowLanguageIV;
    public final LabeledEditText emailTV;
    public final EditText etMobile;
    public final RelativeLayout expertRL;
    public final TextView expertSpinner;
    public final RelativeLayout expertTopRL;
    public final LabeledEditText fatherNameTV;
    public final TextView genderSpinner;
    public final LabeledEditText gstinTV;
    public final ImageView imageCategory;
    public final ImageView imageExpert;
    public final ImageView imagecaste;
    public final ImageView imagecountry;
    public final ImageView imagegender;
    public final ImageView imagelanguage;
    public final RelativeLayout imagelayout;
    public final ImageView imagestate;
    public final ImageView imagestates;
    public final RelativeLayout img1;
    public final ImageView ivBack;
    public final TextView languageSpinner;
    public final CircleImageView marksheetImage;
    public final RelativeLayout marksheetRl;
    public final TextView marksheetTxt;
    public final RelativeLayout mobileRL;
    public final LabeledEditText nameMentor;
    public final LabeledEditText nameTV;
    public final LabeledEditText passwordET;
    public final LabeledEditText pincodeTV;
    public final CircleImageView profileImage;
    public final TextView profilePicTxt;
    public final RelativeLayout profileRl;
    public final CardView rewardCart;
    public final LabeledEditText rollNumberTV;
    private final LinearLayout rootView;
    public final Button signupBtn;
    public final TextView stateSpinner;
    public final TextInputLayout tilConfirmPassword;
    public final TextInputLayout tilPassword;
    public final TextView title;
    public final TextView tvCasteError;
    public final TextView tvCategoryError;
    public final TextView tvCode;
    public final TextView tvCountryError;
    public final TextView tvDistrictError;
    public final TextView tvDobError;
    public final TextView tvExpertError;
    public final TextView tvGenderError;
    public final TextView tvLanguageError;
    public final TextView tvStateError;
    public final TextView tvVerifyEmail;
    public final RelativeLayout uploadImg;
    public final RelativeLayout uploadTenth;

    private FragmentSignupFormNewBinding(LinearLayout rootView, RelativeLayout Caste, RelativeLayout Gender, RelativeLayout Language, RelativeLayout State, LabeledEditText addressTV, LabeledEditText alternateMobileTV, ImageView arrowFlag, TextView casteSpinner, TextView categorySpinner, RelativeLayout categorySpinnerLayout, RelativeLayout city, ImageView cityimage, LabeledEditText confirmPasswordET, RelativeLayout country, TextView countrySpinner, RelativeLayout countryTopRl, ImageView datePickerIV, EditText districtSpinner, TextView districtSpinnerTV, RelativeLayout dobRl, TextView dobTV, RelativeLayout dobTopRl, ImageView downArrowIV, ImageView downArrowIV1, ImageView downarrowCasteIV, ImageView downarrowGenderIV, ImageView downarrowIV, ImageView downarrowIV2, ImageView downarrowIV3, ImageView downarrowIV4, ImageView downarrowLanguageIV, LabeledEditText emailTV, EditText etMobile, RelativeLayout expertRL, TextView expertSpinner, RelativeLayout expertTopRL, LabeledEditText fatherNameTV, TextView genderSpinner, LabeledEditText gstinTV, ImageView imageCategory, ImageView imageExpert, ImageView imagecaste, ImageView imagecountry, ImageView imagegender, ImageView imagelanguage, RelativeLayout imagelayout, ImageView imagestate, ImageView imagestates, RelativeLayout img1, ImageView ivBack, TextView languageSpinner, CircleImageView marksheetImage, RelativeLayout marksheetRl, TextView marksheetTxt, RelativeLayout mobileRL, LabeledEditText nameMentor, LabeledEditText nameTV, LabeledEditText passwordET, LabeledEditText pincodeTV, CircleImageView profileImage, TextView profilePicTxt, RelativeLayout profileRl, CardView rewardCart, LabeledEditText rollNumberTV, Button signupBtn, TextView stateSpinner, TextInputLayout tilConfirmPassword, TextInputLayout tilPassword, TextView title, TextView tvCasteError, TextView tvCategoryError, TextView tvCode, TextView tvCountryError, TextView tvDistrictError, TextView tvDobError, TextView tvExpertError, TextView tvGenderError, TextView tvLanguageError, TextView tvStateError, TextView tvVerifyEmail, RelativeLayout uploadImg, RelativeLayout uploadTenth) {
        this.rootView = rootView;
        this.Caste = Caste;
        this.Gender = Gender;
        this.Language = Language;
        this.State = State;
        this.addressTV = addressTV;
        this.alternateMobileTV = alternateMobileTV;
        this.arrowFlag = arrowFlag;
        this.casteSpinner = casteSpinner;
        this.categorySpinner = categorySpinner;
        this.categorySpinnerLayout = categorySpinnerLayout;
        this.city = city;
        this.cityimage = cityimage;
        this.confirmPasswordET = confirmPasswordET;
        this.country = country;
        this.countrySpinner = countrySpinner;
        this.countryTopRl = countryTopRl;
        this.datePickerIV = datePickerIV;
        this.districtSpinner = districtSpinner;
        this.districtSpinnerTV = districtSpinnerTV;
        this.dobRl = dobRl;
        this.dobTV = dobTV;
        this.dobTopRl = dobTopRl;
        this.downArrowIV = downArrowIV;
        this.downArrowIV1 = downArrowIV1;
        this.downarrowCasteIV = downarrowCasteIV;
        this.downarrowGenderIV = downarrowGenderIV;
        this.downarrowIV = downarrowIV;
        this.downarrowIV2 = downarrowIV2;
        this.downarrowIV3 = downarrowIV3;
        this.downarrowIV4 = downarrowIV4;
        this.downarrowLanguageIV = downarrowLanguageIV;
        this.emailTV = emailTV;
        this.etMobile = etMobile;
        this.expertRL = expertRL;
        this.expertSpinner = expertSpinner;
        this.expertTopRL = expertTopRL;
        this.fatherNameTV = fatherNameTV;
        this.genderSpinner = genderSpinner;
        this.gstinTV = gstinTV;
        this.imageCategory = imageCategory;
        this.imageExpert = imageExpert;
        this.imagecaste = imagecaste;
        this.imagecountry = imagecountry;
        this.imagegender = imagegender;
        this.imagelanguage = imagelanguage;
        this.imagelayout = imagelayout;
        this.imagestate = imagestate;
        this.imagestates = imagestates;
        this.img1 = img1;
        this.ivBack = ivBack;
        this.languageSpinner = languageSpinner;
        this.marksheetImage = marksheetImage;
        this.marksheetRl = marksheetRl;
        this.marksheetTxt = marksheetTxt;
        this.mobileRL = mobileRL;
        this.nameMentor = nameMentor;
        this.nameTV = nameTV;
        this.passwordET = passwordET;
        this.pincodeTV = pincodeTV;
        this.profileImage = profileImage;
        this.profilePicTxt = profilePicTxt;
        this.profileRl = profileRl;
        this.rewardCart = rewardCart;
        this.rollNumberTV = rollNumberTV;
        this.signupBtn = signupBtn;
        this.stateSpinner = stateSpinner;
        this.tilConfirmPassword = tilConfirmPassword;
        this.tilPassword = tilPassword;
        this.title = title;
        this.tvCasteError = tvCasteError;
        this.tvCategoryError = tvCategoryError;
        this.tvCode = tvCode;
        this.tvCountryError = tvCountryError;
        this.tvDistrictError = tvDistrictError;
        this.tvDobError = tvDobError;
        this.tvExpertError = tvExpertError;
        this.tvGenderError = tvGenderError;
        this.tvLanguageError = tvLanguageError;
        this.tvStateError = tvStateError;
        this.tvVerifyEmail = tvVerifyEmail;
        this.uploadImg = uploadImg;
        this.uploadTenth = uploadTenth;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSignupFormNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentSignupFormNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_signup_form_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSignupFormNewBinding bind(View rootView) {
        int i = R.id.Caste;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.Caste);
        if (relativeLayout != null) {
            i = R.id.Gender;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.Gender);
            if (relativeLayout2 != null) {
                i = R.id.Language;
                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.Language);
                if (relativeLayout3 != null) {
                    i = R.id.State;
                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.State);
                    if (relativeLayout4 != null) {
                        i = R.id.addressTV;
                        LabeledEditText labeledEditText = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.addressTV);
                        if (labeledEditText != null) {
                            i = R.id.alternateMobileTV;
                            LabeledEditText labeledEditText2 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.alternateMobileTV);
                            if (labeledEditText2 != null) {
                                i = R.id.arrowFlag;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrowFlag);
                                if (imageView != null) {
                                    i = R.id.casteSpinner;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.casteSpinner);
                                    if (textView != null) {
                                        i = R.id.categorySpinner;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.categorySpinner);
                                        if (textView2 != null) {
                                            i = R.id.categorySpinnerLayout;
                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.categorySpinnerLayout);
                                            if (relativeLayout5 != null) {
                                                i = R.id.city;
                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.city);
                                                if (relativeLayout6 != null) {
                                                    i = R.id.cityimage;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cityimage);
                                                    if (imageView2 != null) {
                                                        i = R.id.confirmPasswordET;
                                                        LabeledEditText labeledEditText3 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.confirmPasswordET);
                                                        if (labeledEditText3 != null) {
                                                            i = R.id.country;
                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.country);
                                                            if (relativeLayout7 != null) {
                                                                i = R.id.countrySpinner;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.countrySpinner);
                                                                if (textView3 != null) {
                                                                    i = R.id.countryTopRl;
                                                                    RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.countryTopRl);
                                                                    if (relativeLayout8 != null) {
                                                                        i = R.id.datePickerIV;
                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.datePickerIV);
                                                                        if (imageView3 != null) {
                                                                            i = R.id.districtSpinner;
                                                                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.districtSpinner);
                                                                            if (editText != null) {
                                                                                i = R.id.districtSpinnerTV;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.districtSpinnerTV);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.dobRl;
                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.dobRl);
                                                                                    if (relativeLayout9 != null) {
                                                                                        i = R.id.dobTV;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dobTV);
                                                                                        if (textView5 != null) {
                                                                                            i = R.id.dobTopRl;
                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.dobTopRl);
                                                                                            if (relativeLayout10 != null) {
                                                                                                i = R.id.downArrowIV;
                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downArrowIV);
                                                                                                if (imageView4 != null) {
                                                                                                    i = R.id.downArrowIV1;
                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downArrowIV1);
                                                                                                    if (imageView5 != null) {
                                                                                                        i = R.id.downarrowCasteIV;
                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowCasteIV);
                                                                                                        if (imageView6 != null) {
                                                                                                            i = R.id.downarrowGenderIV;
                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowGenderIV);
                                                                                                            if (imageView7 != null) {
                                                                                                                i = R.id.downarrowIV;
                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                                                                                                                if (imageView8 != null) {
                                                                                                                    i = R.id.downarrowIV2;
                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV2);
                                                                                                                    if (imageView9 != null) {
                                                                                                                        i = R.id.downarrowIV3;
                                                                                                                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV3);
                                                                                                                        if (imageView10 != null) {
                                                                                                                            i = R.id.downarrowIV4;
                                                                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV4);
                                                                                                                            if (imageView11 != null) {
                                                                                                                                i = R.id.downarrowLanguageIV;
                                                                                                                                ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowLanguageIV);
                                                                                                                                if (imageView12 != null) {
                                                                                                                                    i = R.id.emailTV;
                                                                                                                                    LabeledEditText labeledEditText4 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.emailTV);
                                                                                                                                    if (labeledEditText4 != null) {
                                                                                                                                        i = R.id.et_mobile;
                                                                                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_mobile);
                                                                                                                                        if (editText2 != null) {
                                                                                                                                            i = R.id.expertRL;
                                                                                                                                            RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.expertRL);
                                                                                                                                            if (relativeLayout11 != null) {
                                                                                                                                                i = R.id.expertSpinner;
                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.expertSpinner);
                                                                                                                                                if (textView6 != null) {
                                                                                                                                                    i = R.id.expertTopRL;
                                                                                                                                                    RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.expertTopRL);
                                                                                                                                                    if (relativeLayout12 != null) {
                                                                                                                                                        i = R.id.fatherNameTV;
                                                                                                                                                        LabeledEditText labeledEditText5 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.fatherNameTV);
                                                                                                                                                        if (labeledEditText5 != null) {
                                                                                                                                                            i = R.id.genderSpinner;
                                                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.genderSpinner);
                                                                                                                                                            if (textView7 != null) {
                                                                                                                                                                i = R.id.gstinTV;
                                                                                                                                                                LabeledEditText labeledEditText6 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.gstinTV);
                                                                                                                                                                if (labeledEditText6 != null) {
                                                                                                                                                                    i = R.id.imageCategory;
                                                                                                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageCategory);
                                                                                                                                                                    if (imageView13 != null) {
                                                                                                                                                                        i = R.id.imageExpert;
                                                                                                                                                                        ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageExpert);
                                                                                                                                                                        if (imageView14 != null) {
                                                                                                                                                                            i = R.id.imagecaste;
                                                                                                                                                                            ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagecaste);
                                                                                                                                                                            if (imageView15 != null) {
                                                                                                                                                                                i = R.id.imagecountry;
                                                                                                                                                                                ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagecountry);
                                                                                                                                                                                if (imageView16 != null) {
                                                                                                                                                                                    i = R.id.imagegender;
                                                                                                                                                                                    ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagegender);
                                                                                                                                                                                    if (imageView17 != null) {
                                                                                                                                                                                        i = R.id.imagelanguage;
                                                                                                                                                                                        ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagelanguage);
                                                                                                                                                                                        if (imageView18 != null) {
                                                                                                                                                                                            i = R.id.imagelayout;
                                                                                                                                                                                            RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imagelayout);
                                                                                                                                                                                            if (relativeLayout13 != null) {
                                                                                                                                                                                                i = R.id.imagestate;
                                                                                                                                                                                                ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                                                                                                                                                                                if (imageView19 != null) {
                                                                                                                                                                                                    i = R.id.imagestates;
                                                                                                                                                                                                    ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestates);
                                                                                                                                                                                                    if (imageView20 != null) {
                                                                                                                                                                                                        i = R.id.img1;
                                                                                                                                                                                                        RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.img1);
                                                                                                                                                                                                        if (relativeLayout14 != null) {
                                                                                                                                                                                                            i = R.id.iv_back;
                                                                                                                                                                                                            ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                                                                                                                                                                                                            if (imageView21 != null) {
                                                                                                                                                                                                                i = R.id.languageSpinner;
                                                                                                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.languageSpinner);
                                                                                                                                                                                                                if (textView8 != null) {
                                                                                                                                                                                                                    i = R.id.marksheetImage;
                                                                                                                                                                                                                    CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.marksheetImage);
                                                                                                                                                                                                                    if (circleImageView != null) {
                                                                                                                                                                                                                        i = R.id.marksheet_rl;
                                                                                                                                                                                                                        RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.marksheet_rl);
                                                                                                                                                                                                                        if (relativeLayout15 != null) {
                                                                                                                                                                                                                            i = R.id.marksheet_txt;
                                                                                                                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.marksheet_txt);
                                                                                                                                                                                                                            if (textView9 != null) {
                                                                                                                                                                                                                                i = R.id.mobileRL;
                                                                                                                                                                                                                                RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mobileRL);
                                                                                                                                                                                                                                if (relativeLayout16 != null) {
                                                                                                                                                                                                                                    i = R.id.nameMentor;
                                                                                                                                                                                                                                    LabeledEditText labeledEditText7 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.nameMentor);
                                                                                                                                                                                                                                    if (labeledEditText7 != null) {
                                                                                                                                                                                                                                        i = R.id.nameTV;
                                                                                                                                                                                                                                        LabeledEditText labeledEditText8 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                                                                                                                                                                                                                                        if (labeledEditText8 != null) {
                                                                                                                                                                                                                                            i = R.id.passwordET;
                                                                                                                                                                                                                                            LabeledEditText labeledEditText9 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.passwordET);
                                                                                                                                                                                                                                            if (labeledEditText9 != null) {
                                                                                                                                                                                                                                                i = R.id.pincodeTV;
                                                                                                                                                                                                                                                LabeledEditText labeledEditText10 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.pincodeTV);
                                                                                                                                                                                                                                                if (labeledEditText10 != null) {
                                                                                                                                                                                                                                                    i = R.id.profileImage;
                                                                                                                                                                                                                                                    CircleImageView circleImageView2 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                                                                                                                                                                                                                                    if (circleImageView2 != null) {
                                                                                                                                                                                                                                                        i = R.id.profile_pic_txt;
                                                                                                                                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.profile_pic_txt);
                                                                                                                                                                                                                                                        if (textView10 != null) {
                                                                                                                                                                                                                                                            i = R.id.profile_rl;
                                                                                                                                                                                                                                                            RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.profile_rl);
                                                                                                                                                                                                                                                            if (relativeLayout17 != null) {
                                                                                                                                                                                                                                                                i = R.id.rewardCart;
                                                                                                                                                                                                                                                                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.rewardCart);
                                                                                                                                                                                                                                                                if (cardView != null) {
                                                                                                                                                                                                                                                                    i = R.id.rollNumberTV;
                                                                                                                                                                                                                                                                    LabeledEditText labeledEditText11 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.rollNumberTV);
                                                                                                                                                                                                                                                                    if (labeledEditText11 != null) {
                                                                                                                                                                                                                                                                        i = R.id.signupBtn;
                                                                                                                                                                                                                                                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.signupBtn);
                                                                                                                                                                                                                                                                        if (button != null) {
                                                                                                                                                                                                                                                                            i = R.id.stateSpinner;
                                                                                                                                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateSpinner);
                                                                                                                                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                                                                                                                                i = R.id.til_confirm_password;
                                                                                                                                                                                                                                                                                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.til_confirm_password);
                                                                                                                                                                                                                                                                                if (textInputLayout != null) {
                                                                                                                                                                                                                                                                                    i = R.id.til_password;
                                                                                                                                                                                                                                                                                    TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.til_password);
                                                                                                                                                                                                                                                                                    if (textInputLayout2 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.title;
                                                                                                                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                                                                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.tv_casteError;
                                                                                                                                                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_casteError);
                                                                                                                                                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.tv_categoryError;
                                                                                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_categoryError);
                                                                                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.tv_code;
                                                                                                                                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                                                                                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.tv_countryError;
                                                                                                                                                                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_countryError);
                                                                                                                                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.tv_districtError;
                                                                                                                                                                                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_districtError);
                                                                                                                                                                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.tv_dobError;
                                                                                                                                                                                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_dobError);
                                                                                                                                                                                                                                                                                                                if (textView18 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.tv_expertError;
                                                                                                                                                                                                                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_expertError);
                                                                                                                                                                                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.tv_genderError;
                                                                                                                                                                                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_genderError);
                                                                                                                                                                                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.tv_languageError;
                                                                                                                                                                                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_languageError);
                                                                                                                                                                                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.tv_stateError;
                                                                                                                                                                                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_stateError);
                                                                                                                                                                                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.tv_verify_email;
                                                                                                                                                                                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_verify_email);
                                                                                                                                                                                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.uploadImg;
                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.uploadImg);
                                                                                                                                                                                                                                                                                                                                        if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.uploadTenth;
                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.uploadTenth);
                                                                                                                                                                                                                                                                                                                                            if (relativeLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                return new FragmentSignupFormNewBinding((LinearLayout) rootView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, labeledEditText, labeledEditText2, imageView, textView, textView2, relativeLayout5, relativeLayout6, imageView2, labeledEditText3, relativeLayout7, textView3, relativeLayout8, imageView3, editText, textView4, relativeLayout9, textView5, relativeLayout10, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, labeledEditText4, editText2, relativeLayout11, textView6, relativeLayout12, labeledEditText5, textView7, labeledEditText6, imageView13, imageView14, imageView15, imageView16, imageView17, imageView18, relativeLayout13, imageView19, imageView20, relativeLayout14, imageView21, textView8, circleImageView, relativeLayout15, textView9, relativeLayout16, labeledEditText7, labeledEditText8, labeledEditText9, labeledEditText10, circleImageView2, textView10, relativeLayout17, cardView, labeledEditText11, button, textView11, textInputLayout, textInputLayout2, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, relativeLayout18, relativeLayout19);
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
