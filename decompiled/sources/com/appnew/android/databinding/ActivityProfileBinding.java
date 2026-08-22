package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.hbb20.CountryCodePicker;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityProfileBinding implements ViewBinding {
    public final RelativeLayout Caste;
    public final RelativeLayout Gender;
    public final RelativeLayout Language;
    public final RelativeLayout State;
    public final EditText addressTV;
    public final EditText alternateNumberTV;
    public final RelativeLayout casteRl;
    public final TextView casteSpinner;
    public final LinearLayoutCompat changeLanguage;
    public final TextView changeNumber;
    public final TextView changePass;
    public final RelativeLayout city;
    public final ImageView cityimage;
    public final CountryCodePicker countryDropDown;
    public final TextView districtSpinner;
    public final ImageView downarrowCasteIV;
    public final ImageView downarrowGenderIV;
    public final ImageView downarrowIV;
    public final ImageView downarrowIV2;
    public final ImageView downarrowLanguageIV;
    public final ImageView downarrowstudentCatType;
    public final ImageView downarrowstudentClass;
    public final EditText emailTV;
    public final EditText etPhone;
    public final EditText etdistrictSpinner;
    public final EditText etgenderSpinner;
    public final EditText expertTV;
    public final EditText fatherNameTV;
    public final RelativeLayout fatherRl;
    public final RelativeLayout flagCountryLL;
    public final RelativeLayout flagMainLL;
    public final RelativeLayout flagRL;
    public final RelativeLayout genderRl;
    public final TextView genderSpinner;
    public final ImageView genderimage;
    public final ImageView govIDImage;
    public final EditText govId;
    public final EditText gstnTV;
    public final ImageView im1;
    public final ImageView im2;
    public final ImageView imageBack;
    public final ImageView imageStudentCatType;
    public final ImageView imageStudentClass;
    public final ImageView imagecaste;
    public final ImageView imagelanguage;
    public final RelativeLayout imagelayout;
    public final ImageView imagepass;
    public final ImageView imagestate;
    public final ImageView imagflag;
    public final ImageView imf;
    public final CardView languageCard;
    public final TextView languageSpinner;
    public final View loginView1;
    public final Toolbar mainToolbar;
    public final CircleImageView marksheetImage;
    public final ImageView mentorImg;
    public final RelativeLayout mentorLay;
    public final RelativeLayout mobileNumberRL;
    public final EditText nameMentorProfile;
    public final EditText nameTV;
    public final RelativeLayout passwordRelative;
    public final EditText pincodeTV;
    public final CircleImageView profileImage;
    public final TextView profileRatingText;
    public final RelativeLayout relativeGovtID;
    public final RelativeLayout relativeLayoutNew;
    public final RelativeLayout relativeRollNo;
    public final CardView rewardCart;
    public final RelativeLayout rlGSTIN;
    public final RelativeLayout rlStudentCatType;
    public final RelativeLayout rlStudentClass;
    public final EditText rollNoET;
    public final ImageView rollnoImage;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final ScrollView scrollViewId;
    public final TextView stateSpinner;
    public final TextView studentCatTypeSpinner;
    public final TextView studentClassSpinner;
    public final Button submit;
    public final TextView toolbarTitleTV;
    public final TextView tvCode;
    public final TextView tvLanguageError;
    public final TextView tvStudentCatTypeError;
    public final TextView tvStudentClassError;
    public final RelativeLayout uploadImg;
    public final RelativeLayout uploadTenth;

    private ActivityProfileBinding(RelativeLayout rootView, RelativeLayout Caste, RelativeLayout Gender, RelativeLayout Language, RelativeLayout State, EditText addressTV, EditText alternateNumberTV, RelativeLayout casteRl, TextView casteSpinner, LinearLayoutCompat changeLanguage, TextView changeNumber, TextView changePass, RelativeLayout city, ImageView cityimage, CountryCodePicker countryDropDown, TextView districtSpinner, ImageView downarrowCasteIV, ImageView downarrowGenderIV, ImageView downarrowIV, ImageView downarrowIV2, ImageView downarrowLanguageIV, ImageView downarrowstudentCatType, ImageView downarrowstudentClass, EditText emailTV, EditText etPhone, EditText etdistrictSpinner, EditText etgenderSpinner, EditText expertTV, EditText fatherNameTV, RelativeLayout fatherRl, RelativeLayout flagCountryLL, RelativeLayout flagMainLL, RelativeLayout flagRL, RelativeLayout genderRl, TextView genderSpinner, ImageView genderimage, ImageView govIDImage, EditText govId, EditText gstnTV, ImageView im1, ImageView im2, ImageView imageBack, ImageView imageStudentCatType, ImageView imageStudentClass, ImageView imagecaste, ImageView imagelanguage, RelativeLayout imagelayout, ImageView imagepass, ImageView imagestate, ImageView imagflag, ImageView imf, CardView languageCard, TextView languageSpinner, View loginView1, Toolbar mainToolbar, CircleImageView marksheetImage, ImageView mentorImg, RelativeLayout mentorLay, RelativeLayout mobileNumberRL, EditText nameMentorProfile, EditText nameTV, RelativeLayout passwordRelative, EditText pincodeTV, CircleImageView profileImage, TextView profileRatingText, RelativeLayout relativeGovtID, RelativeLayout relativeLayoutNew, RelativeLayout relativeRollNo, CardView rewardCart, RelativeLayout rlGSTIN, RelativeLayout rlStudentCatType, RelativeLayout rlStudentClass, EditText rollNoET, ImageView rollnoImage, RelativeLayout root, ScrollView scrollViewId, TextView stateSpinner, TextView studentCatTypeSpinner, TextView studentClassSpinner, Button submit, TextView toolbarTitleTV, TextView tvCode, TextView tvLanguageError, TextView tvStudentCatTypeError, TextView tvStudentClassError, RelativeLayout uploadImg, RelativeLayout uploadTenth) {
        this.rootView = rootView;
        this.Caste = Caste;
        this.Gender = Gender;
        this.Language = Language;
        this.State = State;
        this.addressTV = addressTV;
        this.alternateNumberTV = alternateNumberTV;
        this.casteRl = casteRl;
        this.casteSpinner = casteSpinner;
        this.changeLanguage = changeLanguage;
        this.changeNumber = changeNumber;
        this.changePass = changePass;
        this.city = city;
        this.cityimage = cityimage;
        this.countryDropDown = countryDropDown;
        this.districtSpinner = districtSpinner;
        this.downarrowCasteIV = downarrowCasteIV;
        this.downarrowGenderIV = downarrowGenderIV;
        this.downarrowIV = downarrowIV;
        this.downarrowIV2 = downarrowIV2;
        this.downarrowLanguageIV = downarrowLanguageIV;
        this.downarrowstudentCatType = downarrowstudentCatType;
        this.downarrowstudentClass = downarrowstudentClass;
        this.emailTV = emailTV;
        this.etPhone = etPhone;
        this.etdistrictSpinner = etdistrictSpinner;
        this.etgenderSpinner = etgenderSpinner;
        this.expertTV = expertTV;
        this.fatherNameTV = fatherNameTV;
        this.fatherRl = fatherRl;
        this.flagCountryLL = flagCountryLL;
        this.flagMainLL = flagMainLL;
        this.flagRL = flagRL;
        this.genderRl = genderRl;
        this.genderSpinner = genderSpinner;
        this.genderimage = genderimage;
        this.govIDImage = govIDImage;
        this.govId = govId;
        this.gstnTV = gstnTV;
        this.im1 = im1;
        this.im2 = im2;
        this.imageBack = imageBack;
        this.imageStudentCatType = imageStudentCatType;
        this.imageStudentClass = imageStudentClass;
        this.imagecaste = imagecaste;
        this.imagelanguage = imagelanguage;
        this.imagelayout = imagelayout;
        this.imagepass = imagepass;
        this.imagestate = imagestate;
        this.imagflag = imagflag;
        this.imf = imf;
        this.languageCard = languageCard;
        this.languageSpinner = languageSpinner;
        this.loginView1 = loginView1;
        this.mainToolbar = mainToolbar;
        this.marksheetImage = marksheetImage;
        this.mentorImg = mentorImg;
        this.mentorLay = mentorLay;
        this.mobileNumberRL = mobileNumberRL;
        this.nameMentorProfile = nameMentorProfile;
        this.nameTV = nameTV;
        this.passwordRelative = passwordRelative;
        this.pincodeTV = pincodeTV;
        this.profileImage = profileImage;
        this.profileRatingText = profileRatingText;
        this.relativeGovtID = relativeGovtID;
        this.relativeLayoutNew = relativeLayoutNew;
        this.relativeRollNo = relativeRollNo;
        this.rewardCart = rewardCart;
        this.rlGSTIN = rlGSTIN;
        this.rlStudentCatType = rlStudentCatType;
        this.rlStudentClass = rlStudentClass;
        this.rollNoET = rollNoET;
        this.rollnoImage = rollnoImage;
        this.root = root;
        this.scrollViewId = scrollViewId;
        this.stateSpinner = stateSpinner;
        this.studentCatTypeSpinner = studentCatTypeSpinner;
        this.studentClassSpinner = studentClassSpinner;
        this.submit = submit;
        this.toolbarTitleTV = toolbarTitleTV;
        this.tvCode = tvCode;
        this.tvLanguageError = tvLanguageError;
        this.tvStudentCatTypeError = tvStudentCatTypeError;
        this.tvStudentClassError = tvStudentClassError;
        this.uploadImg = uploadImg;
        this.uploadTenth = uploadTenth;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityProfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityProfileBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_profile, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityProfileBinding bind(View rootView) {
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
                            i = R.id.alternateNumberTV;
                            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.alternateNumberTV);
                            if (editText2 != null) {
                                i = R.id.caste_rl;
                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.caste_rl);
                                if (relativeLayout5 != null) {
                                    i = R.id.casteSpinner;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.casteSpinner);
                                    if (textView != null) {
                                        i = R.id.changeLanguage;
                                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.changeLanguage);
                                        if (linearLayoutCompat != null) {
                                            i = R.id.changeNumber;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.changeNumber);
                                            if (textView2 != null) {
                                                i = R.id.change_pass;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.change_pass);
                                                if (textView3 != null) {
                                                    i = R.id.city;
                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.city);
                                                    if (relativeLayout6 != null) {
                                                        i = R.id.cityimage;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cityimage);
                                                        if (imageView != null) {
                                                            i = R.id.countryDropDown;
                                                            CountryCodePicker countryCodePicker = (CountryCodePicker) ViewBindings.findChildViewById(rootView, R.id.countryDropDown);
                                                            if (countryCodePicker != null) {
                                                                i = R.id.districtSpinner;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.districtSpinner);
                                                                if (textView4 != null) {
                                                                    i = R.id.downarrowCasteIV;
                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowCasteIV);
                                                                    if (imageView2 != null) {
                                                                        i = R.id.downarrowGenderIV;
                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowGenderIV);
                                                                        if (imageView3 != null) {
                                                                            i = R.id.downarrowIV;
                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                                                                            if (imageView4 != null) {
                                                                                i = R.id.downarrowIV2;
                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV2);
                                                                                if (imageView5 != null) {
                                                                                    i = R.id.downarrowLanguageIV;
                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowLanguageIV);
                                                                                    if (imageView6 != null) {
                                                                                        i = R.id.downarrowstudent_catType;
                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowstudent_catType);
                                                                                        if (imageView7 != null) {
                                                                                            i = R.id.downarrowstudent_class;
                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowstudent_class);
                                                                                            if (imageView8 != null) {
                                                                                                i = R.id.emailTV;
                                                                                                EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.emailTV);
                                                                                                if (editText3 != null) {
                                                                                                    i = R.id.et_phone;
                                                                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_phone);
                                                                                                    if (editText4 != null) {
                                                                                                        i = R.id.etdistrictSpinner;
                                                                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.etdistrictSpinner);
                                                                                                        if (editText5 != null) {
                                                                                                            i = R.id.etgenderSpinner;
                                                                                                            EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.etgenderSpinner);
                                                                                                            if (editText6 != null) {
                                                                                                                i = R.id.expertTV;
                                                                                                                EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.expertTV);
                                                                                                                if (editText7 != null) {
                                                                                                                    i = R.id.fatherNameTV;
                                                                                                                    EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fatherNameTV);
                                                                                                                    if (editText8 != null) {
                                                                                                                        i = R.id.father_rl;
                                                                                                                        RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.father_rl);
                                                                                                                        if (relativeLayout7 != null) {
                                                                                                                            i = R.id.flagCountryLL;
                                                                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagCountryLL);
                                                                                                                            if (relativeLayout8 != null) {
                                                                                                                                i = R.id.flagMainLL;
                                                                                                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagMainLL);
                                                                                                                                if (relativeLayout9 != null) {
                                                                                                                                    i = R.id.flagRL;
                                                                                                                                    RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagRL);
                                                                                                                                    if (relativeLayout10 != null) {
                                                                                                                                        i = R.id.gender_rl;
                                                                                                                                        RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.gender_rl);
                                                                                                                                        if (relativeLayout11 != null) {
                                                                                                                                            i = R.id.genderSpinner;
                                                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.genderSpinner);
                                                                                                                                            if (textView5 != null) {
                                                                                                                                                i = R.id.genderimage;
                                                                                                                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.genderimage);
                                                                                                                                                if (imageView9 != null) {
                                                                                                                                                    i = R.id.govID_image;
                                                                                                                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.govID_image);
                                                                                                                                                    if (imageView10 != null) {
                                                                                                                                                        i = R.id.govId;
                                                                                                                                                        EditText editText9 = (EditText) ViewBindings.findChildViewById(rootView, R.id.govId);
                                                                                                                                                        if (editText9 != null) {
                                                                                                                                                            i = R.id.gstnTV;
                                                                                                                                                            EditText editText10 = (EditText) ViewBindings.findChildViewById(rootView, R.id.gstnTV);
                                                                                                                                                            if (editText10 != null) {
                                                                                                                                                                i = R.id.im1;
                                                                                                                                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.im1);
                                                                                                                                                                if (imageView11 != null) {
                                                                                                                                                                    i = R.id.im2;
                                                                                                                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.im2);
                                                                                                                                                                    if (imageView12 != null) {
                                                                                                                                                                        i = R.id.image_back;
                                                                                                                                                                        ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                                                                                                                                                                        if (imageView13 != null) {
                                                                                                                                                                            i = R.id.image_student_catType;
                                                                                                                                                                            ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_student_catType);
                                                                                                                                                                            if (imageView14 != null) {
                                                                                                                                                                                i = R.id.image_student_class;
                                                                                                                                                                                ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_student_class);
                                                                                                                                                                                if (imageView15 != null) {
                                                                                                                                                                                    i = R.id.imagecaste;
                                                                                                                                                                                    ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagecaste);
                                                                                                                                                                                    if (imageView16 != null) {
                                                                                                                                                                                        i = R.id.imagelanguage;
                                                                                                                                                                                        ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagelanguage);
                                                                                                                                                                                        if (imageView17 != null) {
                                                                                                                                                                                            i = R.id.imagelayout;
                                                                                                                                                                                            RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imagelayout);
                                                                                                                                                                                            if (relativeLayout12 != null) {
                                                                                                                                                                                                i = R.id.imagepass;
                                                                                                                                                                                                ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagepass);
                                                                                                                                                                                                if (imageView18 != null) {
                                                                                                                                                                                                    i = R.id.imagestate;
                                                                                                                                                                                                    ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                                                                                                                                                                                    if (imageView19 != null) {
                                                                                                                                                                                                        i = R.id.imagflag;
                                                                                                                                                                                                        ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagflag);
                                                                                                                                                                                                        if (imageView20 != null) {
                                                                                                                                                                                                            i = R.id.imf;
                                                                                                                                                                                                            ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imf);
                                                                                                                                                                                                            if (imageView21 != null) {
                                                                                                                                                                                                                i = R.id.languageCard;
                                                                                                                                                                                                                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.languageCard);
                                                                                                                                                                                                                if (cardView != null) {
                                                                                                                                                                                                                    i = R.id.languageSpinner;
                                                                                                                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.languageSpinner);
                                                                                                                                                                                                                    if (textView6 != null) {
                                                                                                                                                                                                                        i = R.id.loginView1;
                                                                                                                                                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.loginView1);
                                                                                                                                                                                                                        if (viewFindChildViewById != null) {
                                                                                                                                                                                                                            i = R.id.main_toolbar;
                                                                                                                                                                                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                                                                                                                                                                                                            if (toolbar != null) {
                                                                                                                                                                                                                                i = R.id.marksheetImage;
                                                                                                                                                                                                                                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.marksheetImage);
                                                                                                                                                                                                                                if (circleImageView != null) {
                                                                                                                                                                                                                                    i = R.id.mentorImg;
                                                                                                                                                                                                                                    ImageView imageView22 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.mentorImg);
                                                                                                                                                                                                                                    if (imageView22 != null) {
                                                                                                                                                                                                                                        i = R.id.mentorLay;
                                                                                                                                                                                                                                        RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mentorLay);
                                                                                                                                                                                                                                        if (relativeLayout13 != null) {
                                                                                                                                                                                                                                            i = R.id.mobileNumberRL;
                                                                                                                                                                                                                                            RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mobileNumberRL);
                                                                                                                                                                                                                                            if (relativeLayout14 != null) {
                                                                                                                                                                                                                                                i = R.id.nameMentorProfile;
                                                                                                                                                                                                                                                EditText editText11 = (EditText) ViewBindings.findChildViewById(rootView, R.id.nameMentorProfile);
                                                                                                                                                                                                                                                if (editText11 != null) {
                                                                                                                                                                                                                                                    i = R.id.nameTV;
                                                                                                                                                                                                                                                    EditText editText12 = (EditText) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                                                                                                                                                                                                                                                    if (editText12 != null) {
                                                                                                                                                                                                                                                        i = R.id.password_relative;
                                                                                                                                                                                                                                                        RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.password_relative);
                                                                                                                                                                                                                                                        if (relativeLayout15 != null) {
                                                                                                                                                                                                                                                            i = R.id.pincodeTV;
                                                                                                                                                                                                                                                            EditText editText13 = (EditText) ViewBindings.findChildViewById(rootView, R.id.pincodeTV);
                                                                                                                                                                                                                                                            if (editText13 != null) {
                                                                                                                                                                                                                                                                i = R.id.profileImage;
                                                                                                                                                                                                                                                                CircleImageView circleImageView2 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                                                                                                                                                                                                                                                if (circleImageView2 != null) {
                                                                                                                                                                                                                                                                    i = R.id.profileRating_text;
                                                                                                                                                                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.profileRating_text);
                                                                                                                                                                                                                                                                    if (textView7 != null) {
                                                                                                                                                                                                                                                                        i = R.id.relativeGovtID;
                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeGovtID);
                                                                                                                                                                                                                                                                        if (relativeLayout16 != null) {
                                                                                                                                                                                                                                                                            i = R.id.relativeLayoutNew;
                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLayoutNew);
                                                                                                                                                                                                                                                                            if (relativeLayout17 != null) {
                                                                                                                                                                                                                                                                                i = R.id.relativeRollNo;
                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeRollNo);
                                                                                                                                                                                                                                                                                if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.rewardCart;
                                                                                                                                                                                                                                                                                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.rewardCart);
                                                                                                                                                                                                                                                                                    if (cardView2 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.rlGSTIN;
                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rlGSTIN);
                                                                                                                                                                                                                                                                                        if (relativeLayout19 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.rl_student_catType;
                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout20 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_student_catType);
                                                                                                                                                                                                                                                                                            if (relativeLayout20 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.rl_student_class;
                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout21 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_student_class);
                                                                                                                                                                                                                                                                                                if (relativeLayout21 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.rollNoET;
                                                                                                                                                                                                                                                                                                    EditText editText14 = (EditText) ViewBindings.findChildViewById(rootView, R.id.rollNoET);
                                                                                                                                                                                                                                                                                                    if (editText14 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.rollno_image;
                                                                                                                                                                                                                                                                                                        ImageView imageView23 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.rollno_image);
                                                                                                                                                                                                                                                                                                        if (imageView23 != null) {
                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout22 = (RelativeLayout) rootView;
                                                                                                                                                                                                                                                                                                            i = R.id.scrollViewId;
                                                                                                                                                                                                                                                                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollViewId);
                                                                                                                                                                                                                                                                                                            if (scrollView != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.stateSpinner;
                                                                                                                                                                                                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateSpinner);
                                                                                                                                                                                                                                                                                                                if (textView8 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.student_catType_Spinner;
                                                                                                                                                                                                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student_catType_Spinner);
                                                                                                                                                                                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.student_class_Spinner;
                                                                                                                                                                                                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student_class_Spinner);
                                                                                                                                                                                                                                                                                                                        if (textView10 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.submit;
                                                                                                                                                                                                                                                                                                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submit);
                                                                                                                                                                                                                                                                                                                            if (button != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.toolbarTitleTV;
                                                                                                                                                                                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                                                                                                                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.tv_code;
                                                                                                                                                                                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                                                                                                                                                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.tv_languageError;
                                                                                                                                                                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_languageError);
                                                                                                                                                                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.tv_student_catType_Error;
                                                                                                                                                                                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_student_catType_Error);
                                                                                                                                                                                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.tv_student_class_Error;
                                                                                                                                                                                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_student_class_Error);
                                                                                                                                                                                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.uploadImg;
                                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout23 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.uploadImg);
                                                                                                                                                                                                                                                                                                                                                    if (relativeLayout23 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.uploadTenth;
                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout24 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.uploadTenth);
                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout24 != null) {
                                                                                                                                                                                                                                                                                                                                                            return new ActivityProfileBinding(relativeLayout22, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, editText, editText2, relativeLayout5, textView, linearLayoutCompat, textView2, textView3, relativeLayout6, imageView, countryCodePicker, textView4, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, editText3, editText4, editText5, editText6, editText7, editText8, relativeLayout7, relativeLayout8, relativeLayout9, relativeLayout10, relativeLayout11, textView5, imageView9, imageView10, editText9, editText10, imageView11, imageView12, imageView13, imageView14, imageView15, imageView16, imageView17, relativeLayout12, imageView18, imageView19, imageView20, imageView21, cardView, textView6, viewFindChildViewById, toolbar, circleImageView, imageView22, relativeLayout13, relativeLayout14, editText11, editText12, relativeLayout15, editText13, circleImageView2, textView7, relativeLayout16, relativeLayout17, relativeLayout18, cardView2, relativeLayout19, relativeLayout20, relativeLayout21, editText14, imageView23, relativeLayout22, scrollView, textView8, textView9, textView10, button, textView11, textView12, textView13, textView14, textView15, relativeLayout23, relativeLayout24);
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
