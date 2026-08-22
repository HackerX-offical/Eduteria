package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.textfield.TextInputLayout;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentSignupFormBinding implements ViewBinding {
    public final RelativeLayout Caste;
    public final RelativeLayout Gender;
    public final RelativeLayout Language;
    public final RelativeLayout State;
    public final EditText addressTV;
    public final EditText alternateMobileTV;
    public final TextView casteSpinner;
    public final TextView categorySpinner;
    public final RelativeLayout categorySpinnerLayout;
    public final RelativeLayout city;
    public final ImageView cityimage;
    public final EditText confirmPasswordET;
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
    public final ImageView downarrowstudentCatType;
    public final ImageView downarrowstudentClass;
    public final EditText emailTV;
    public final EditText etMobile;
    public final RelativeLayout expertRL;
    public final TextView expertSpinner;
    public final RelativeLayout expertTopRL;
    public final EditText fatherNameTV;
    public final TextView genderSpinner;
    public final EditText gstinTV;
    public final ImageView imageCategory;
    public final ImageView imageExpert;
    public final ImageView imageStudentCatType;
    public final ImageView imageStudentClass;
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
    public final EditText nameMentor;
    public final EditText nameTV;
    public final EditText passwordET;
    public final EditText pincodeTV;
    public final CircleImageView profileImage;
    public final TextView profilePicTxt;
    public final RelativeLayout profileRl;
    public final CardView rewardCart;
    public final RelativeLayout rlStudentCatType;
    public final RelativeLayout rlStudentClass;
    public final EditText rollNumberTV;
    private final NestedScrollView rootView;
    public final Button signupBtn;
    public final TextView stateSpinner;
    public final TextView studentCatTypeSpinner;
    public final TextView studentClassSpinner;
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
    public final TextView tvStudentCatTypeError;
    public final TextView tvStudentClassError;
    public final TextView tvVerifyEmail;
    public final RelativeLayout uploadImg;
    public final RelativeLayout uploadTenth;
    public final View view0;
    public final View view1;
    public final View view2;
    public final View viewA;
    public final View viewAd;
    public final View viewC;
    public final View viewF;
    public final View viewG;
    public final View viewL;
    public final View viewMentor;
    public final View viewPin;

    private FragmentSignupFormBinding(NestedScrollView rootView, RelativeLayout Caste, RelativeLayout Gender, RelativeLayout Language, RelativeLayout State, EditText addressTV, EditText alternateMobileTV, TextView casteSpinner, TextView categorySpinner, RelativeLayout categorySpinnerLayout, RelativeLayout city, ImageView cityimage, EditText confirmPasswordET, RelativeLayout country, TextView countrySpinner, RelativeLayout countryTopRl, ImageView datePickerIV, EditText districtSpinner, TextView districtSpinnerTV, RelativeLayout dobRl, TextView dobTV, RelativeLayout dobTopRl, ImageView downArrowIV, ImageView downArrowIV1, ImageView downarrowCasteIV, ImageView downarrowGenderIV, ImageView downarrowIV, ImageView downarrowIV2, ImageView downarrowIV3, ImageView downarrowIV4, ImageView downarrowLanguageIV, ImageView downarrowstudentCatType, ImageView downarrowstudentClass, EditText emailTV, EditText etMobile, RelativeLayout expertRL, TextView expertSpinner, RelativeLayout expertTopRL, EditText fatherNameTV, TextView genderSpinner, EditText gstinTV, ImageView imageCategory, ImageView imageExpert, ImageView imageStudentCatType, ImageView imageStudentClass, ImageView imagecaste, ImageView imagecountry, ImageView imagegender, ImageView imagelanguage, RelativeLayout imagelayout, ImageView imagestate, ImageView imagestates, RelativeLayout img1, ImageView ivBack, TextView languageSpinner, CircleImageView marksheetImage, RelativeLayout marksheetRl, TextView marksheetTxt, EditText nameMentor, EditText nameTV, EditText passwordET, EditText pincodeTV, CircleImageView profileImage, TextView profilePicTxt, RelativeLayout profileRl, CardView rewardCart, RelativeLayout rlStudentCatType, RelativeLayout rlStudentClass, EditText rollNumberTV, Button signupBtn, TextView stateSpinner, TextView studentCatTypeSpinner, TextView studentClassSpinner, TextInputLayout tilConfirmPassword, TextInputLayout tilPassword, TextView title, TextView tvCasteError, TextView tvCategoryError, TextView tvCode, TextView tvCountryError, TextView tvDistrictError, TextView tvDobError, TextView tvExpertError, TextView tvGenderError, TextView tvLanguageError, TextView tvStateError, TextView tvStudentCatTypeError, TextView tvStudentClassError, TextView tvVerifyEmail, RelativeLayout uploadImg, RelativeLayout uploadTenth, View view0, View view1, View view2, View viewA, View viewAd, View viewC, View viewF, View viewG, View viewL, View viewMentor, View viewPin) {
        this.rootView = rootView;
        this.Caste = Caste;
        this.Gender = Gender;
        this.Language = Language;
        this.State = State;
        this.addressTV = addressTV;
        this.alternateMobileTV = alternateMobileTV;
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
        this.downarrowstudentCatType = downarrowstudentCatType;
        this.downarrowstudentClass = downarrowstudentClass;
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
        this.imageStudentCatType = imageStudentCatType;
        this.imageStudentClass = imageStudentClass;
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
        this.nameMentor = nameMentor;
        this.nameTV = nameTV;
        this.passwordET = passwordET;
        this.pincodeTV = pincodeTV;
        this.profileImage = profileImage;
        this.profilePicTxt = profilePicTxt;
        this.profileRl = profileRl;
        this.rewardCart = rewardCart;
        this.rlStudentCatType = rlStudentCatType;
        this.rlStudentClass = rlStudentClass;
        this.rollNumberTV = rollNumberTV;
        this.signupBtn = signupBtn;
        this.stateSpinner = stateSpinner;
        this.studentCatTypeSpinner = studentCatTypeSpinner;
        this.studentClassSpinner = studentClassSpinner;
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
        this.tvStudentCatTypeError = tvStudentCatTypeError;
        this.tvStudentClassError = tvStudentClassError;
        this.tvVerifyEmail = tvVerifyEmail;
        this.uploadImg = uploadImg;
        this.uploadTenth = uploadTenth;
        this.view0 = view0;
        this.view1 = view1;
        this.view2 = view2;
        this.viewA = viewA;
        this.viewAd = viewAd;
        this.viewC = viewC;
        this.viewF = viewF;
        this.viewG = viewG;
        this.viewL = viewL;
        this.viewMentor = viewMentor;
        this.viewPin = viewPin;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentSignupFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentSignupFormBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_signup_form, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSignupFormBinding bind(View rootView) {
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
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.addressTV);
                        if (editText != null) {
                            i = R.id.alternateMobileTV;
                            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.alternateMobileTV);
                            if (editText2 != null) {
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
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cityimage);
                                                if (imageView != null) {
                                                    i = R.id.confirmPasswordET;
                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.confirmPasswordET);
                                                    if (editText3 != null) {
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
                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.datePickerIV);
                                                                    if (imageView2 != null) {
                                                                        i = R.id.districtSpinner;
                                                                        EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.districtSpinner);
                                                                        if (editText4 != null) {
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
                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downArrowIV);
                                                                                            if (imageView3 != null) {
                                                                                                i = R.id.downArrowIV1;
                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downArrowIV1);
                                                                                                if (imageView4 != null) {
                                                                                                    i = R.id.downarrowCasteIV;
                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowCasteIV);
                                                                                                    if (imageView5 != null) {
                                                                                                        i = R.id.downarrowGenderIV;
                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowGenderIV);
                                                                                                        if (imageView6 != null) {
                                                                                                            i = R.id.downarrowIV;
                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                                                                                                            if (imageView7 != null) {
                                                                                                                i = R.id.downarrowIV2;
                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV2);
                                                                                                                if (imageView8 != null) {
                                                                                                                    i = R.id.downarrowIV3;
                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV3);
                                                                                                                    if (imageView9 != null) {
                                                                                                                        i = R.id.downarrowIV4;
                                                                                                                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV4);
                                                                                                                        if (imageView10 != null) {
                                                                                                                            i = R.id.downarrowLanguageIV;
                                                                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowLanguageIV);
                                                                                                                            if (imageView11 != null) {
                                                                                                                                i = R.id.downarrowstudent_catType;
                                                                                                                                ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowstudent_catType);
                                                                                                                                if (imageView12 != null) {
                                                                                                                                    i = R.id.downarrowstudent_class;
                                                                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowstudent_class);
                                                                                                                                    if (imageView13 != null) {
                                                                                                                                        i = R.id.emailTV;
                                                                                                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.emailTV);
                                                                                                                                        if (editText5 != null) {
                                                                                                                                            i = R.id.et_mobile;
                                                                                                                                            EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_mobile);
                                                                                                                                            if (editText6 != null) {
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
                                                                                                                                                            EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fatherNameTV);
                                                                                                                                                            if (editText7 != null) {
                                                                                                                                                                i = R.id.genderSpinner;
                                                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.genderSpinner);
                                                                                                                                                                if (textView7 != null) {
                                                                                                                                                                    i = R.id.gstinTV;
                                                                                                                                                                    EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.gstinTV);
                                                                                                                                                                    if (editText8 != null) {
                                                                                                                                                                        i = R.id.imageCategory;
                                                                                                                                                                        ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageCategory);
                                                                                                                                                                        if (imageView14 != null) {
                                                                                                                                                                            i = R.id.imageExpert;
                                                                                                                                                                            ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageExpert);
                                                                                                                                                                            if (imageView15 != null) {
                                                                                                                                                                                i = R.id.image_student_catType;
                                                                                                                                                                                ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_student_catType);
                                                                                                                                                                                if (imageView16 != null) {
                                                                                                                                                                                    i = R.id.image_student_class;
                                                                                                                                                                                    ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_student_class);
                                                                                                                                                                                    if (imageView17 != null) {
                                                                                                                                                                                        i = R.id.imagecaste;
                                                                                                                                                                                        ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagecaste);
                                                                                                                                                                                        if (imageView18 != null) {
                                                                                                                                                                                            i = R.id.imagecountry;
                                                                                                                                                                                            ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagecountry);
                                                                                                                                                                                            if (imageView19 != null) {
                                                                                                                                                                                                i = R.id.imagegender;
                                                                                                                                                                                                ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagegender);
                                                                                                                                                                                                if (imageView20 != null) {
                                                                                                                                                                                                    i = R.id.imagelanguage;
                                                                                                                                                                                                    ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagelanguage);
                                                                                                                                                                                                    if (imageView21 != null) {
                                                                                                                                                                                                        i = R.id.imagelayout;
                                                                                                                                                                                                        RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imagelayout);
                                                                                                                                                                                                        if (relativeLayout13 != null) {
                                                                                                                                                                                                            i = R.id.imagestate;
                                                                                                                                                                                                            ImageView imageView22 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                                                                                                                                                                                            if (imageView22 != null) {
                                                                                                                                                                                                                i = R.id.imagestates;
                                                                                                                                                                                                                ImageView imageView23 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestates);
                                                                                                                                                                                                                if (imageView23 != null) {
                                                                                                                                                                                                                    i = R.id.img1;
                                                                                                                                                                                                                    RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.img1);
                                                                                                                                                                                                                    if (relativeLayout14 != null) {
                                                                                                                                                                                                                        i = R.id.iv_back;
                                                                                                                                                                                                                        ImageView imageView24 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                                                                                                                                                                                                                        if (imageView24 != null) {
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
                                                                                                                                                                                                                                            i = R.id.nameMentor;
                                                                                                                                                                                                                                            EditText editText9 = (EditText) ViewBindings.findChildViewById(rootView, R.id.nameMentor);
                                                                                                                                                                                                                                            if (editText9 != null) {
                                                                                                                                                                                                                                                i = R.id.nameTV;
                                                                                                                                                                                                                                                EditText editText10 = (EditText) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                                                                                                                                                                                                                                                if (editText10 != null) {
                                                                                                                                                                                                                                                    i = R.id.passwordET;
                                                                                                                                                                                                                                                    EditText editText11 = (EditText) ViewBindings.findChildViewById(rootView, R.id.passwordET);
                                                                                                                                                                                                                                                    if (editText11 != null) {
                                                                                                                                                                                                                                                        i = R.id.pincodeTV;
                                                                                                                                                                                                                                                        EditText editText12 = (EditText) ViewBindings.findChildViewById(rootView, R.id.pincodeTV);
                                                                                                                                                                                                                                                        if (editText12 != null) {
                                                                                                                                                                                                                                                            i = R.id.profileImage;
                                                                                                                                                                                                                                                            CircleImageView circleImageView2 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                                                                                                                                                                                                                                            if (circleImageView2 != null) {
                                                                                                                                                                                                                                                                i = R.id.profile_pic_txt;
                                                                                                                                                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.profile_pic_txt);
                                                                                                                                                                                                                                                                if (textView10 != null) {
                                                                                                                                                                                                                                                                    i = R.id.profile_rl;
                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.profile_rl);
                                                                                                                                                                                                                                                                    if (relativeLayout16 != null) {
                                                                                                                                                                                                                                                                        i = R.id.rewardCart;
                                                                                                                                                                                                                                                                        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.rewardCart);
                                                                                                                                                                                                                                                                        if (cardView != null) {
                                                                                                                                                                                                                                                                            i = R.id.rl_student_catType;
                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_student_catType);
                                                                                                                                                                                                                                                                            if (relativeLayout17 != null) {
                                                                                                                                                                                                                                                                                i = R.id.rl_student_class;
                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_student_class);
                                                                                                                                                                                                                                                                                if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.rollNumberTV;
                                                                                                                                                                                                                                                                                    EditText editText13 = (EditText) ViewBindings.findChildViewById(rootView, R.id.rollNumberTV);
                                                                                                                                                                                                                                                                                    if (editText13 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.signupBtn;
                                                                                                                                                                                                                                                                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.signupBtn);
                                                                                                                                                                                                                                                                                        if (button != null) {
                                                                                                                                                                                                                                                                                            i = R.id.stateSpinner;
                                                                                                                                                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateSpinner);
                                                                                                                                                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.student_catType_Spinner;
                                                                                                                                                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student_catType_Spinner);
                                                                                                                                                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.student_class_Spinner;
                                                                                                                                                                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student_class_Spinner);
                                                                                                                                                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.til_confirm_password;
                                                                                                                                                                                                                                                                                                        TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.til_confirm_password);
                                                                                                                                                                                                                                                                                                        if (textInputLayout != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.til_password;
                                                                                                                                                                                                                                                                                                            TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.til_password);
                                                                                                                                                                                                                                                                                                            if (textInputLayout2 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.title;
                                                                                                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                                                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.tv_casteError;
                                                                                                                                                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_casteError);
                                                                                                                                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.tv_categoryError;
                                                                                                                                                                                                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_categoryError);
                                                                                                                                                                                                                                                                                                                        if (textView16 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.tv_code;
                                                                                                                                                                                                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                                                                                                                                                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.tv_countryError;
                                                                                                                                                                                                                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_countryError);
                                                                                                                                                                                                                                                                                                                                if (textView18 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.tv_districtError;
                                                                                                                                                                                                                                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_districtError);
                                                                                                                                                                                                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.tv_dobError;
                                                                                                                                                                                                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_dobError);
                                                                                                                                                                                                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.tv_expertError;
                                                                                                                                                                                                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_expertError);
                                                                                                                                                                                                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.tv_genderError;
                                                                                                                                                                                                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_genderError);
                                                                                                                                                                                                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.tv_languageError;
                                                                                                                                                                                                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_languageError);
                                                                                                                                                                                                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.tv_stateError;
                                                                                                                                                                                                                                                                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_stateError);
                                                                                                                                                                                                                                                                                                                                                        if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.tv_student_catType_Error;
                                                                                                                                                                                                                                                                                                                                                            TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_student_catType_Error);
                                                                                                                                                                                                                                                                                                                                                            if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.tv_student_class_Error;
                                                                                                                                                                                                                                                                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_student_class_Error);
                                                                                                                                                                                                                                                                                                                                                                if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.tv_verify_email;
                                                                                                                                                                                                                                                                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_verify_email);
                                                                                                                                                                                                                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.uploadImg;
                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.uploadImg);
                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.uploadTenth;
                                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout20 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.uploadTenth);
                                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i = R.id.view0;
                                                                                                                                                                                                                                                                                                                                                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view0);
                                                                                                                                                                                                                                                                                                                                                                                if (viewFindChildViewById != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.view1;
                                                                                                                                                                                                                                                                                                                                                                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view1);
                                                                                                                                                                                                                                                                                                                                                                                    if (viewFindChildViewById2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.view2;
                                                                                                                                                                                                                                                                                                                                                                                        View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                                                                                                                                                                                                                                                                                                                                        if (viewFindChildViewById3 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.viewA;
                                                                                                                                                                                                                                                                                                                                                                                            View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.viewA);
                                                                                                                                                                                                                                                                                                                                                                                            if (viewFindChildViewById4 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.viewAd;
                                                                                                                                                                                                                                                                                                                                                                                                View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.viewAd);
                                                                                                                                                                                                                                                                                                                                                                                                if (viewFindChildViewById5 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.viewC;
                                                                                                                                                                                                                                                                                                                                                                                                    View viewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.viewC);
                                                                                                                                                                                                                                                                                                                                                                                                    if (viewFindChildViewById6 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.viewF;
                                                                                                                                                                                                                                                                                                                                                                                                        View viewFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.viewF);
                                                                                                                                                                                                                                                                                                                                                                                                        if (viewFindChildViewById7 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.viewG;
                                                                                                                                                                                                                                                                                                                                                                                                            View viewFindChildViewById8 = ViewBindings.findChildViewById(rootView, R.id.viewG);
                                                                                                                                                                                                                                                                                                                                                                                                            if (viewFindChildViewById8 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.viewL;
                                                                                                                                                                                                                                                                                                                                                                                                                View viewFindChildViewById9 = ViewBindings.findChildViewById(rootView, R.id.viewL);
                                                                                                                                                                                                                                                                                                                                                                                                                if (viewFindChildViewById9 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.viewMentor;
                                                                                                                                                                                                                                                                                                                                                                                                                    View viewFindChildViewById10 = ViewBindings.findChildViewById(rootView, R.id.viewMentor);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (viewFindChildViewById10 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.viewPin;
                                                                                                                                                                                                                                                                                                                                                                                                                        View viewFindChildViewById11 = ViewBindings.findChildViewById(rootView, R.id.viewPin);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (viewFindChildViewById11 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            return new FragmentSignupFormBinding((NestedScrollView) rootView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, editText, editText2, textView, textView2, relativeLayout5, relativeLayout6, imageView, editText3, relativeLayout7, textView3, relativeLayout8, imageView2, editText4, textView4, relativeLayout9, textView5, relativeLayout10, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, editText5, editText6, relativeLayout11, textView6, relativeLayout12, editText7, textView7, editText8, imageView14, imageView15, imageView16, imageView17, imageView18, imageView19, imageView20, imageView21, relativeLayout13, imageView22, imageView23, relativeLayout14, imageView24, textView8, circleImageView, relativeLayout15, textView9, editText9, editText10, editText11, editText12, circleImageView2, textView10, relativeLayout16, cardView, relativeLayout17, relativeLayout18, editText13, button, textView11, textView12, textView13, textInputLayout, textInputLayout2, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, relativeLayout19, relativeLayout20, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7, viewFindChildViewById8, viewFindChildViewById9, viewFindChildViewById10, viewFindChildViewById11);
                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
