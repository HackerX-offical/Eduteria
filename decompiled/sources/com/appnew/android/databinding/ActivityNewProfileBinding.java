package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.hbb20.CountryCodePicker;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityNewProfileBinding implements ViewBinding {
    public final RelativeLayout State;
    public final ImageView aadharCardImageV;
    public final RelativeLayout aadharCardRL;
    public final EditText aadharCardTextV;
    public final ImageView alternateNumberImageV;
    public final RelativeLayout alternateNumberRL;
    public final EditText alternateNumberTextV;
    public final ImageView casteCategoryImageV;
    public final RelativeLayout casteCategoryRL;
    public final TextView casteCategoryTextV;
    public final TextView changePass;
    public final RelativeLayout city;
    public final ImageView cityimage;
    public final CountryCodePicker countryDropDown;
    public final ImageView dateOfBirthImageV;
    public final RelativeLayout dateOfBirthRL;
    public final TextView dateOfBirthText;
    public final TextView districtSpinner;
    public final ImageView downarrowIV;
    public final ImageView downarrowIV2;
    public final ImageView educationQualificationImageV;
    public final RelativeLayout educationQualificationRL;
    public final EditText educationQualificationTextV;
    public final EditText emailTV;
    public final EditText etPhone;
    public final EditText etdistrictSpinner;
    public final RelativeLayout flagCountryLL;
    public final RelativeLayout flagMainLL;
    public final RelativeLayout flagRL;
    public final ImageView genderImageV;
    public final RelativeLayout genderRL;
    public final TextView genderText;
    public final EditText gstnTV;
    public final ImageView guardianImage;
    public final RelativeLayout guardianName;
    public final EditText guardianNameText;
    public final ImageView guardianNuImage;
    public final RelativeLayout guardianNumber;
    public final EditText guardianNumberText;
    public final ImageView im1;
    public final ImageView im2;
    public final ImageView imageBack;
    public final RelativeLayout imagelayout;
    public final ImageView imagepass;
    public final ImageView imagestate;
    public final ImageView imagflag;
    public final View loginView1;
    public final Toolbar mainToolbar;
    public final EditText nameTV;
    public final ImageView phStatusImageV;
    public final RelativeLayout phStatusRL;
    public final TextView phStatusTextV;
    public final ImageView pinCodeImage;
    public final RelativeLayout pinCodeRL;
    public final EditText pinCodeText;
    public final CircleImageView profileImage;
    public final CardView rewardCart;
    public final RelativeLayout rlGSTIN;
    private final RelativeLayout rootView;
    public final TextView stateSpinner;
    public final Button submit;
    public final TextView toolbarTitleTV;
    public final TextView tvCode;
    public final RelativeLayout uploadImg;
    public final ImageView userAddressImage;
    public final EditText userAddressText;

    private ActivityNewProfileBinding(RelativeLayout rootView, RelativeLayout State, ImageView aadharCardImageV, RelativeLayout aadharCardRL, EditText aadharCardTextV, ImageView alternateNumberImageV, RelativeLayout alternateNumberRL, EditText alternateNumberTextV, ImageView casteCategoryImageV, RelativeLayout casteCategoryRL, TextView casteCategoryTextV, TextView changePass, RelativeLayout city, ImageView cityimage, CountryCodePicker countryDropDown, ImageView dateOfBirthImageV, RelativeLayout dateOfBirthRL, TextView dateOfBirthText, TextView districtSpinner, ImageView downarrowIV, ImageView downarrowIV2, ImageView educationQualificationImageV, RelativeLayout educationQualificationRL, EditText educationQualificationTextV, EditText emailTV, EditText etPhone, EditText etdistrictSpinner, RelativeLayout flagCountryLL, RelativeLayout flagMainLL, RelativeLayout flagRL, ImageView genderImageV, RelativeLayout genderRL, TextView genderText, EditText gstnTV, ImageView guardianImage, RelativeLayout guardianName, EditText guardianNameText, ImageView guardianNuImage, RelativeLayout guardianNumber, EditText guardianNumberText, ImageView im1, ImageView im2, ImageView imageBack, RelativeLayout imagelayout, ImageView imagepass, ImageView imagestate, ImageView imagflag, View loginView1, Toolbar mainToolbar, EditText nameTV, ImageView phStatusImageV, RelativeLayout phStatusRL, TextView phStatusTextV, ImageView pinCodeImage, RelativeLayout pinCodeRL, EditText pinCodeText, CircleImageView profileImage, CardView rewardCart, RelativeLayout rlGSTIN, TextView stateSpinner, Button submit, TextView toolbarTitleTV, TextView tvCode, RelativeLayout uploadImg, ImageView userAddressImage, EditText userAddressText) {
        this.rootView = rootView;
        this.State = State;
        this.aadharCardImageV = aadharCardImageV;
        this.aadharCardRL = aadharCardRL;
        this.aadharCardTextV = aadharCardTextV;
        this.alternateNumberImageV = alternateNumberImageV;
        this.alternateNumberRL = alternateNumberRL;
        this.alternateNumberTextV = alternateNumberTextV;
        this.casteCategoryImageV = casteCategoryImageV;
        this.casteCategoryRL = casteCategoryRL;
        this.casteCategoryTextV = casteCategoryTextV;
        this.changePass = changePass;
        this.city = city;
        this.cityimage = cityimage;
        this.countryDropDown = countryDropDown;
        this.dateOfBirthImageV = dateOfBirthImageV;
        this.dateOfBirthRL = dateOfBirthRL;
        this.dateOfBirthText = dateOfBirthText;
        this.districtSpinner = districtSpinner;
        this.downarrowIV = downarrowIV;
        this.downarrowIV2 = downarrowIV2;
        this.educationQualificationImageV = educationQualificationImageV;
        this.educationQualificationRL = educationQualificationRL;
        this.educationQualificationTextV = educationQualificationTextV;
        this.emailTV = emailTV;
        this.etPhone = etPhone;
        this.etdistrictSpinner = etdistrictSpinner;
        this.flagCountryLL = flagCountryLL;
        this.flagMainLL = flagMainLL;
        this.flagRL = flagRL;
        this.genderImageV = genderImageV;
        this.genderRL = genderRL;
        this.genderText = genderText;
        this.gstnTV = gstnTV;
        this.guardianImage = guardianImage;
        this.guardianName = guardianName;
        this.guardianNameText = guardianNameText;
        this.guardianNuImage = guardianNuImage;
        this.guardianNumber = guardianNumber;
        this.guardianNumberText = guardianNumberText;
        this.im1 = im1;
        this.im2 = im2;
        this.imageBack = imageBack;
        this.imagelayout = imagelayout;
        this.imagepass = imagepass;
        this.imagestate = imagestate;
        this.imagflag = imagflag;
        this.loginView1 = loginView1;
        this.mainToolbar = mainToolbar;
        this.nameTV = nameTV;
        this.phStatusImageV = phStatusImageV;
        this.phStatusRL = phStatusRL;
        this.phStatusTextV = phStatusTextV;
        this.pinCodeImage = pinCodeImage;
        this.pinCodeRL = pinCodeRL;
        this.pinCodeText = pinCodeText;
        this.profileImage = profileImage;
        this.rewardCart = rewardCart;
        this.rlGSTIN = rlGSTIN;
        this.stateSpinner = stateSpinner;
        this.submit = submit;
        this.toolbarTitleTV = toolbarTitleTV;
        this.tvCode = tvCode;
        this.uploadImg = uploadImg;
        this.userAddressImage = userAddressImage;
        this.userAddressText = userAddressText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNewProfileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityNewProfileBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_new_profile, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityNewProfileBinding bind(View rootView) {
        int i = R.id.State;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.State);
        if (relativeLayout != null) {
            i = R.id.aadhar_card_imageV;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.aadhar_card_imageV);
            if (imageView != null) {
                i = R.id.aadhar_card_RL;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.aadhar_card_RL);
                if (relativeLayout2 != null) {
                    i = R.id.aadhar_card_TextV;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.aadhar_card_TextV);
                    if (editText != null) {
                        i = R.id.alternate_number_imageV;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.alternate_number_imageV);
                        if (imageView2 != null) {
                            i = R.id.alternate_number_RL;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.alternate_number_RL);
                            if (relativeLayout3 != null) {
                                i = R.id.alternate_number_TextV;
                                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.alternate_number_TextV);
                                if (editText2 != null) {
                                    i = R.id.caste_category_imageV;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.caste_category_imageV);
                                    if (imageView3 != null) {
                                        i = R.id.caste_category_RL;
                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.caste_category_RL);
                                        if (relativeLayout4 != null) {
                                            i = R.id.caste_category_TextV;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.caste_category_TextV);
                                            if (textView != null) {
                                                i = R.id.change_pass;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.change_pass);
                                                if (textView2 != null) {
                                                    i = R.id.city;
                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.city);
                                                    if (relativeLayout5 != null) {
                                                        i = R.id.cityimage;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cityimage);
                                                        if (imageView4 != null) {
                                                            i = R.id.countryDropDown;
                                                            CountryCodePicker countryCodePicker = (CountryCodePicker) ViewBindings.findChildViewById(rootView, R.id.countryDropDown);
                                                            if (countryCodePicker != null) {
                                                                i = R.id.date_of_birth_imageV;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.date_of_birth_imageV);
                                                                if (imageView5 != null) {
                                                                    i = R.id.date_of_birth_RL;
                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.date_of_birth_RL);
                                                                    if (relativeLayout6 != null) {
                                                                        i = R.id.date_of_birth_Text;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.date_of_birth_Text);
                                                                        if (textView3 != null) {
                                                                            i = R.id.districtSpinner;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.districtSpinner);
                                                                            if (textView4 != null) {
                                                                                i = R.id.downarrowIV;
                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                                                                                if (imageView6 != null) {
                                                                                    i = R.id.downarrowIV2;
                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV2);
                                                                                    if (imageView7 != null) {
                                                                                        i = R.id.education_qualification_imageV;
                                                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.education_qualification_imageV);
                                                                                        if (imageView8 != null) {
                                                                                            i = R.id.education_qualification_RL;
                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.education_qualification_RL);
                                                                                            if (relativeLayout7 != null) {
                                                                                                i = R.id.education_qualification_TextV;
                                                                                                EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.education_qualification_TextV);
                                                                                                if (editText3 != null) {
                                                                                                    i = R.id.emailTV;
                                                                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.emailTV);
                                                                                                    if (editText4 != null) {
                                                                                                        i = R.id.et_phone;
                                                                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_phone);
                                                                                                        if (editText5 != null) {
                                                                                                            i = R.id.etdistrictSpinner;
                                                                                                            EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.etdistrictSpinner);
                                                                                                            if (editText6 != null) {
                                                                                                                i = R.id.flagCountryLL;
                                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagCountryLL);
                                                                                                                if (relativeLayout8 != null) {
                                                                                                                    i = R.id.flagMainLL;
                                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagMainLL);
                                                                                                                    if (relativeLayout9 != null) {
                                                                                                                        i = R.id.flagRL;
                                                                                                                        RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagRL);
                                                                                                                        if (relativeLayout10 != null) {
                                                                                                                            i = R.id.gender_imageV;
                                                                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.gender_imageV);
                                                                                                                            if (imageView9 != null) {
                                                                                                                                i = R.id.gender_RL;
                                                                                                                                RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.gender_RL);
                                                                                                                                if (relativeLayout11 != null) {
                                                                                                                                    i = R.id.gender_Text;
                                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender_Text);
                                                                                                                                    if (textView5 != null) {
                                                                                                                                        i = R.id.gstnTV;
                                                                                                                                        EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.gstnTV);
                                                                                                                                        if (editText7 != null) {
                                                                                                                                            i = R.id.guardian_image;
                                                                                                                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.guardian_image);
                                                                                                                                            if (imageView10 != null) {
                                                                                                                                                i = R.id.guardian_name;
                                                                                                                                                RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.guardian_name);
                                                                                                                                                if (relativeLayout12 != null) {
                                                                                                                                                    i = R.id.guardian_name_Text;
                                                                                                                                                    EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.guardian_name_Text);
                                                                                                                                                    if (editText8 != null) {
                                                                                                                                                        i = R.id.guardian_nu_image;
                                                                                                                                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.guardian_nu_image);
                                                                                                                                                        if (imageView11 != null) {
                                                                                                                                                            i = R.id.guardian_number;
                                                                                                                                                            RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.guardian_number);
                                                                                                                                                            if (relativeLayout13 != null) {
                                                                                                                                                                i = R.id.guardian_number_Text;
                                                                                                                                                                EditText editText9 = (EditText) ViewBindings.findChildViewById(rootView, R.id.guardian_number_Text);
                                                                                                                                                                if (editText9 != null) {
                                                                                                                                                                    i = R.id.im1;
                                                                                                                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.im1);
                                                                                                                                                                    if (imageView12 != null) {
                                                                                                                                                                        i = R.id.im2;
                                                                                                                                                                        ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.im2);
                                                                                                                                                                        if (imageView13 != null) {
                                                                                                                                                                            i = R.id.image_back;
                                                                                                                                                                            ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                                                                                                                                                                            if (imageView14 != null) {
                                                                                                                                                                                i = R.id.imagelayout;
                                                                                                                                                                                RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imagelayout);
                                                                                                                                                                                if (relativeLayout14 != null) {
                                                                                                                                                                                    i = R.id.imagepass;
                                                                                                                                                                                    ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagepass);
                                                                                                                                                                                    if (imageView15 != null) {
                                                                                                                                                                                        i = R.id.imagestate;
                                                                                                                                                                                        ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                                                                                                                                                                        if (imageView16 != null) {
                                                                                                                                                                                            i = R.id.imagflag;
                                                                                                                                                                                            ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagflag);
                                                                                                                                                                                            if (imageView17 != null) {
                                                                                                                                                                                                i = R.id.loginView1;
                                                                                                                                                                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.loginView1);
                                                                                                                                                                                                if (viewFindChildViewById != null) {
                                                                                                                                                                                                    i = R.id.main_toolbar;
                                                                                                                                                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                                                                                                                                                                                    if (toolbar != null) {
                                                                                                                                                                                                        i = R.id.nameTV;
                                                                                                                                                                                                        EditText editText10 = (EditText) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                                                                                                                                                                                                        if (editText10 != null) {
                                                                                                                                                                                                            i = R.id.ph_status_imageV;
                                                                                                                                                                                                            ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ph_status_imageV);
                                                                                                                                                                                                            if (imageView18 != null) {
                                                                                                                                                                                                                i = R.id.ph_status_RL;
                                                                                                                                                                                                                RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ph_status_RL);
                                                                                                                                                                                                                if (relativeLayout15 != null) {
                                                                                                                                                                                                                    i = R.id.ph_status_TextV;
                                                                                                                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ph_status_TextV);
                                                                                                                                                                                                                    if (textView6 != null) {
                                                                                                                                                                                                                        i = R.id.pin_code_image;
                                                                                                                                                                                                                        ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pin_code_image);
                                                                                                                                                                                                                        if (imageView19 != null) {
                                                                                                                                                                                                                            i = R.id.pin_code_RL;
                                                                                                                                                                                                                            RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pin_code_RL);
                                                                                                                                                                                                                            if (relativeLayout16 != null) {
                                                                                                                                                                                                                                i = R.id.pin_code_Text;
                                                                                                                                                                                                                                EditText editText11 = (EditText) ViewBindings.findChildViewById(rootView, R.id.pin_code_Text);
                                                                                                                                                                                                                                if (editText11 != null) {
                                                                                                                                                                                                                                    i = R.id.profileImage;
                                                                                                                                                                                                                                    CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                                                                                                                                                                                                                    if (circleImageView != null) {
                                                                                                                                                                                                                                        i = R.id.rewardCart;
                                                                                                                                                                                                                                        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.rewardCart);
                                                                                                                                                                                                                                        if (cardView != null) {
                                                                                                                                                                                                                                            i = R.id.rlGSTIN;
                                                                                                                                                                                                                                            RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rlGSTIN);
                                                                                                                                                                                                                                            if (relativeLayout17 != null) {
                                                                                                                                                                                                                                                i = R.id.stateSpinner;
                                                                                                                                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateSpinner);
                                                                                                                                                                                                                                                if (textView7 != null) {
                                                                                                                                                                                                                                                    i = R.id.submit;
                                                                                                                                                                                                                                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submit);
                                                                                                                                                                                                                                                    if (button != null) {
                                                                                                                                                                                                                                                        i = R.id.toolbarTitleTV;
                                                                                                                                                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                                                                                                                                                                                        if (textView8 != null) {
                                                                                                                                                                                                                                                            i = R.id.tv_code;
                                                                                                                                                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                                                                                                                                                                                                                            if (textView9 != null) {
                                                                                                                                                                                                                                                                i = R.id.uploadImg;
                                                                                                                                                                                                                                                                RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.uploadImg);
                                                                                                                                                                                                                                                                if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                                    i = R.id.user_address_image;
                                                                                                                                                                                                                                                                    ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.user_address_image);
                                                                                                                                                                                                                                                                    if (imageView20 != null) {
                                                                                                                                                                                                                                                                        i = R.id.user_address_Text;
                                                                                                                                                                                                                                                                        EditText editText12 = (EditText) ViewBindings.findChildViewById(rootView, R.id.user_address_Text);
                                                                                                                                                                                                                                                                        if (editText12 != null) {
                                                                                                                                                                                                                                                                            return new ActivityNewProfileBinding((RelativeLayout) rootView, relativeLayout, imageView, relativeLayout2, editText, imageView2, relativeLayout3, editText2, imageView3, relativeLayout4, textView, textView2, relativeLayout5, imageView4, countryCodePicker, imageView5, relativeLayout6, textView3, textView4, imageView6, imageView7, imageView8, relativeLayout7, editText3, editText4, editText5, editText6, relativeLayout8, relativeLayout9, relativeLayout10, imageView9, relativeLayout11, textView5, editText7, imageView10, relativeLayout12, editText8, imageView11, relativeLayout13, editText9, imageView12, imageView13, imageView14, relativeLayout14, imageView15, imageView16, imageView17, viewFindChildViewById, toolbar, editText10, imageView18, relativeLayout15, textView6, imageView19, relativeLayout16, editText11, circleImageView, cardView, relativeLayout17, textView7, button, textView8, textView9, relativeLayout18, imageView20, editText12);
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
