package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityRegistrationPreviewBinding implements ViewBinding {
    public final TextView ClassName;
    public final TextView ClassNameText;
    public final TextView address;
    public final TextView addressTwo;
    public final TextView adharId;
    public final TextView adharTextId;
    public final TextView bloodGrp;
    public final TextView bloodGrpText;
    public final Button buyNowBtn;
    public final TextView category;
    public final TextView categoryText;
    public final TextView centerAdd;
    public final TextView city;
    public final TextView cityTwo;
    public final TextView classCity;
    public final TextView classRoom;
    public final TextView classRoomId;
    public final TextView classState;
    public final TextView dob;
    public final TextView dobText;
    public final TextView emailText;
    public final TextView emailText1;
    public final TextView father;
    public final TextView fatherContact;
    public final TextView fatherContactText;
    public final TextView fatherContactTextText;
    public final TextView fatherOccupation1;
    public final TextView fatherText;
    public final TextView gender;
    public final TextView genderText;
    public final ImageView ivBack;
    public final LinearLayout llBottom;
    public final LinearLayout llCenterDetail;
    public final LinearLayout llTest;
    public final NestedScrollView main;
    public final TextView mobileText;
    public final TextView mobileText1;
    public final TextView mother;
    public final TextView motherContact;
    public final TextView motherContactText;
    public final TextView motherOccupation;
    public final TextView motherOccupationText;
    public final TextView motherText;
    public final TextView mrpCutTV;
    public final TextView nameText;
    public final TextView nameText1;
    public final TextView permanentAdd;
    public final TextView pincode;
    public final TextView pincodeTwo;
    public final TextView presentAddress;
    public final RelativeLayout presentAddressLL;
    public final RelativeLayout presentAddressLLTwo;
    public final CircleImageView presentClass;
    public final TextView presentClassText;
    public final LinearLayout priceLL;
    public final TextView priceTV;
    public final RelativeLayout rlMain;
    private final RelativeLayout rootView;
    public final TextView schoolText;
    public final TextView state;
    public final TextView stateTwo;
    public final TextView streamDivision;
    public final TextView student;
    public final TextView studentIdHint;
    public final TextView studentIdTv;
    public final TextView studentText;
    public final TextView testCenter;
    public final TextView testCenterText;
    public final TextView testCity;
    public final TextView testDate;
    public final TextView testDateText;
    public final TextView testMode;
    public final TextView testName;
    public final TextView testState;
    public final TextView title;
    public final TextView whatsapText;
    public final TextView whatsappTextTv;

    private ActivityRegistrationPreviewBinding(RelativeLayout rootView, TextView ClassName, TextView ClassNameText, TextView address, TextView addressTwo, TextView adharId, TextView adharTextId, TextView bloodGrp, TextView bloodGrpText, Button buyNowBtn, TextView category, TextView categoryText, TextView centerAdd, TextView city, TextView cityTwo, TextView classCity, TextView classRoom, TextView classRoomId, TextView classState, TextView dob, TextView dobText, TextView emailText, TextView emailText1, TextView father, TextView fatherContact, TextView fatherContactText, TextView fatherContactTextText, TextView fatherOccupation1, TextView fatherText, TextView gender, TextView genderText, ImageView ivBack, LinearLayout llBottom, LinearLayout llCenterDetail, LinearLayout llTest, NestedScrollView main, TextView mobileText, TextView mobileText1, TextView mother, TextView motherContact, TextView motherContactText, TextView motherOccupation, TextView motherOccupationText, TextView motherText, TextView mrpCutTV, TextView nameText, TextView nameText1, TextView permanentAdd, TextView pincode, TextView pincodeTwo, TextView presentAddress, RelativeLayout presentAddressLL, RelativeLayout presentAddressLLTwo, CircleImageView presentClass, TextView presentClassText, LinearLayout priceLL, TextView priceTV, RelativeLayout rlMain, TextView schoolText, TextView state, TextView stateTwo, TextView streamDivision, TextView student, TextView studentIdHint, TextView studentIdTv, TextView studentText, TextView testCenter, TextView testCenterText, TextView testCity, TextView testDate, TextView testDateText, TextView testMode, TextView testName, TextView testState, TextView title, TextView whatsapText, TextView whatsappTextTv) {
        this.rootView = rootView;
        this.ClassName = ClassName;
        this.ClassNameText = ClassNameText;
        this.address = address;
        this.addressTwo = addressTwo;
        this.adharId = adharId;
        this.adharTextId = adharTextId;
        this.bloodGrp = bloodGrp;
        this.bloodGrpText = bloodGrpText;
        this.buyNowBtn = buyNowBtn;
        this.category = category;
        this.categoryText = categoryText;
        this.centerAdd = centerAdd;
        this.city = city;
        this.cityTwo = cityTwo;
        this.classCity = classCity;
        this.classRoom = classRoom;
        this.classRoomId = classRoomId;
        this.classState = classState;
        this.dob = dob;
        this.dobText = dobText;
        this.emailText = emailText;
        this.emailText1 = emailText1;
        this.father = father;
        this.fatherContact = fatherContact;
        this.fatherContactText = fatherContactText;
        this.fatherContactTextText = fatherContactTextText;
        this.fatherOccupation1 = fatherOccupation1;
        this.fatherText = fatherText;
        this.gender = gender;
        this.genderText = genderText;
        this.ivBack = ivBack;
        this.llBottom = llBottom;
        this.llCenterDetail = llCenterDetail;
        this.llTest = llTest;
        this.main = main;
        this.mobileText = mobileText;
        this.mobileText1 = mobileText1;
        this.mother = mother;
        this.motherContact = motherContact;
        this.motherContactText = motherContactText;
        this.motherOccupation = motherOccupation;
        this.motherOccupationText = motherOccupationText;
        this.motherText = motherText;
        this.mrpCutTV = mrpCutTV;
        this.nameText = nameText;
        this.nameText1 = nameText1;
        this.permanentAdd = permanentAdd;
        this.pincode = pincode;
        this.pincodeTwo = pincodeTwo;
        this.presentAddress = presentAddress;
        this.presentAddressLL = presentAddressLL;
        this.presentAddressLLTwo = presentAddressLLTwo;
        this.presentClass = presentClass;
        this.presentClassText = presentClassText;
        this.priceLL = priceLL;
        this.priceTV = priceTV;
        this.rlMain = rlMain;
        this.schoolText = schoolText;
        this.state = state;
        this.stateTwo = stateTwo;
        this.streamDivision = streamDivision;
        this.student = student;
        this.studentIdHint = studentIdHint;
        this.studentIdTv = studentIdTv;
        this.studentText = studentText;
        this.testCenter = testCenter;
        this.testCenterText = testCenterText;
        this.testCity = testCity;
        this.testDate = testDate;
        this.testDateText = testDateText;
        this.testMode = testMode;
        this.testName = testName;
        this.testState = testState;
        this.title = title;
        this.whatsapText = whatsapText;
        this.whatsappTextTv = whatsappTextTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRegistrationPreviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityRegistrationPreviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_registration_preview, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRegistrationPreviewBinding bind(View rootView) {
        int i = R.id.ClassName;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ClassName);
        if (textView != null) {
            i = R.id.ClassNameText;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ClassNameText);
            if (textView2 != null) {
                i = R.id.address;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address);
                if (textView3 != null) {
                    i = R.id.addressTwo;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.addressTwo);
                    if (textView4 != null) {
                        i = R.id.adharId;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.adharId);
                        if (textView5 != null) {
                            i = R.id.adharTextId;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.adharTextId);
                            if (textView6 != null) {
                                i = R.id.bloodGrp;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bloodGrp);
                                if (textView7 != null) {
                                    i = R.id.bloodGrpText;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bloodGrpText);
                                    if (textView8 != null) {
                                        i = R.id.buyNowBtn;
                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buyNowBtn);
                                        if (button != null) {
                                            i = R.id.category;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.category);
                                            if (textView9 != null) {
                                                i = R.id.categoryText;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.categoryText);
                                                if (textView10 != null) {
                                                    i = R.id.centerAdd;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.centerAdd);
                                                    if (textView11 != null) {
                                                        i = R.id.city;
                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.city);
                                                        if (textView12 != null) {
                                                            i = R.id.cityTwo;
                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cityTwo);
                                                            if (textView13 != null) {
                                                                i = R.id.class_city;
                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.class_city);
                                                                if (textView14 != null) {
                                                                    i = R.id.classRoom;
                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.classRoom);
                                                                    if (textView15 != null) {
                                                                        i = R.id.classRoomId;
                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.classRoomId);
                                                                        if (textView16 != null) {
                                                                            i = R.id.class_state;
                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.class_state);
                                                                            if (textView17 != null) {
                                                                                i = R.id.dob;
                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dob);
                                                                                if (textView18 != null) {
                                                                                    i = R.id.dobText;
                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dobText);
                                                                                    if (textView19 != null) {
                                                                                        i = R.id.emailText;
                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.emailText);
                                                                                        if (textView20 != null) {
                                                                                            i = R.id.emailText1;
                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.emailText1);
                                                                                            if (textView21 != null) {
                                                                                                i = R.id.father;
                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.father);
                                                                                                if (textView22 != null) {
                                                                                                    i = R.id.fatherContact;
                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fatherContact);
                                                                                                    if (textView23 != null) {
                                                                                                        i = R.id.fatherContactText;
                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fatherContactText);
                                                                                                        if (textView24 != null) {
                                                                                                            i = R.id.fatherContactTextText;
                                                                                                            TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fatherContactTextText);
                                                                                                            if (textView25 != null) {
                                                                                                                i = R.id.fatherOccupation1;
                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fatherOccupation1);
                                                                                                                if (textView26 != null) {
                                                                                                                    i = R.id.fatherText;
                                                                                                                    TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fatherText);
                                                                                                                    if (textView27 != null) {
                                                                                                                        i = R.id.gender;
                                                                                                                        TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gender);
                                                                                                                        if (textView28 != null) {
                                                                                                                            i = R.id.genderText;
                                                                                                                            TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.genderText);
                                                                                                                            if (textView29 != null) {
                                                                                                                                i = R.id.iv_back;
                                                                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                                                                                                                                if (imageView != null) {
                                                                                                                                    i = R.id.ll_bottom;
                                                                                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_bottom);
                                                                                                                                    if (linearLayout != null) {
                                                                                                                                        i = R.id.ll_center_detail;
                                                                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_center_detail);
                                                                                                                                        if (linearLayout2 != null) {
                                                                                                                                            i = R.id.ll_test;
                                                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_test);
                                                                                                                                            if (linearLayout3 != null) {
                                                                                                                                                i = R.id.main;
                                                                                                                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.main);
                                                                                                                                                if (nestedScrollView != null) {
                                                                                                                                                    i = R.id.mobileText;
                                                                                                                                                    TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobileText);
                                                                                                                                                    if (textView30 != null) {
                                                                                                                                                        i = R.id.mobileText1;
                                                                                                                                                        TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobileText1);
                                                                                                                                                        if (textView31 != null) {
                                                                                                                                                            i = R.id.mother;
                                                                                                                                                            TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mother);
                                                                                                                                                            if (textView32 != null) {
                                                                                                                                                                i = R.id.motherContact;
                                                                                                                                                                TextView textView33 = (TextView) ViewBindings.findChildViewById(rootView, R.id.motherContact);
                                                                                                                                                                if (textView33 != null) {
                                                                                                                                                                    i = R.id.motherContactText;
                                                                                                                                                                    TextView textView34 = (TextView) ViewBindings.findChildViewById(rootView, R.id.motherContactText);
                                                                                                                                                                    if (textView34 != null) {
                                                                                                                                                                        i = R.id.motherOccupation;
                                                                                                                                                                        TextView textView35 = (TextView) ViewBindings.findChildViewById(rootView, R.id.motherOccupation);
                                                                                                                                                                        if (textView35 != null) {
                                                                                                                                                                            i = R.id.motherOccupationText;
                                                                                                                                                                            TextView textView36 = (TextView) ViewBindings.findChildViewById(rootView, R.id.motherOccupationText);
                                                                                                                                                                            if (textView36 != null) {
                                                                                                                                                                                i = R.id.motherText;
                                                                                                                                                                                TextView textView37 = (TextView) ViewBindings.findChildViewById(rootView, R.id.motherText);
                                                                                                                                                                                if (textView37 != null) {
                                                                                                                                                                                    i = R.id.mrpCutTV;
                                                                                                                                                                                    TextView textView38 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                                                                                                                                                                                    if (textView38 != null) {
                                                                                                                                                                                        i = R.id.nameText;
                                                                                                                                                                                        TextView textView39 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameText);
                                                                                                                                                                                        if (textView39 != null) {
                                                                                                                                                                                            i = R.id.nameText1;
                                                                                                                                                                                            TextView textView40 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameText1);
                                                                                                                                                                                            if (textView40 != null) {
                                                                                                                                                                                                i = R.id.permanentAdd;
                                                                                                                                                                                                TextView textView41 = (TextView) ViewBindings.findChildViewById(rootView, R.id.permanentAdd);
                                                                                                                                                                                                if (textView41 != null) {
                                                                                                                                                                                                    i = R.id.pincode;
                                                                                                                                                                                                    TextView textView42 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pincode);
                                                                                                                                                                                                    if (textView42 != null) {
                                                                                                                                                                                                        i = R.id.pincodeTwo;
                                                                                                                                                                                                        TextView textView43 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pincodeTwo);
                                                                                                                                                                                                        if (textView43 != null) {
                                                                                                                                                                                                            i = R.id.presentAddress;
                                                                                                                                                                                                            TextView textView44 = (TextView) ViewBindings.findChildViewById(rootView, R.id.presentAddress);
                                                                                                                                                                                                            if (textView44 != null) {
                                                                                                                                                                                                                i = R.id.presentAddressLL;
                                                                                                                                                                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.presentAddressLL);
                                                                                                                                                                                                                if (relativeLayout != null) {
                                                                                                                                                                                                                    i = R.id.presentAddressLLTwo;
                                                                                                                                                                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.presentAddressLLTwo);
                                                                                                                                                                                                                    if (relativeLayout2 != null) {
                                                                                                                                                                                                                        i = R.id.presentClass;
                                                                                                                                                                                                                        CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.presentClass);
                                                                                                                                                                                                                        if (circleImageView != null) {
                                                                                                                                                                                                                            i = R.id.presentClassText;
                                                                                                                                                                                                                            TextView textView45 = (TextView) ViewBindings.findChildViewById(rootView, R.id.presentClassText);
                                                                                                                                                                                                                            if (textView45 != null) {
                                                                                                                                                                                                                                i = R.id.priceLL;
                                                                                                                                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.priceLL);
                                                                                                                                                                                                                                if (linearLayout4 != null) {
                                                                                                                                                                                                                                    i = R.id.priceTV;
                                                                                                                                                                                                                                    TextView textView46 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                                                                                                                                                                                                                    if (textView46 != null) {
                                                                                                                                                                                                                                        i = R.id.rl_main;
                                                                                                                                                                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_main);
                                                                                                                                                                                                                                        if (relativeLayout3 != null) {
                                                                                                                                                                                                                                            i = R.id.schoolText;
                                                                                                                                                                                                                                            TextView textView47 = (TextView) ViewBindings.findChildViewById(rootView, R.id.schoolText);
                                                                                                                                                                                                                                            if (textView47 != null) {
                                                                                                                                                                                                                                                i = R.id.state;
                                                                                                                                                                                                                                                TextView textView48 = (TextView) ViewBindings.findChildViewById(rootView, R.id.state);
                                                                                                                                                                                                                                                if (textView48 != null) {
                                                                                                                                                                                                                                                    i = R.id.stateTwo;
                                                                                                                                                                                                                                                    TextView textView49 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateTwo);
                                                                                                                                                                                                                                                    if (textView49 != null) {
                                                                                                                                                                                                                                                        i = R.id.stream_division;
                                                                                                                                                                                                                                                        TextView textView50 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stream_division);
                                                                                                                                                                                                                                                        if (textView50 != null) {
                                                                                                                                                                                                                                                            i = R.id.student;
                                                                                                                                                                                                                                                            TextView textView51 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student);
                                                                                                                                                                                                                                                            if (textView51 != null) {
                                                                                                                                                                                                                                                                i = R.id.student_id_hint;
                                                                                                                                                                                                                                                                TextView textView52 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student_id_hint);
                                                                                                                                                                                                                                                                if (textView52 != null) {
                                                                                                                                                                                                                                                                    i = R.id.student_id_tv;
                                                                                                                                                                                                                                                                    TextView textView53 = (TextView) ViewBindings.findChildViewById(rootView, R.id.student_id_tv);
                                                                                                                                                                                                                                                                    if (textView53 != null) {
                                                                                                                                                                                                                                                                        i = R.id.studentText;
                                                                                                                                                                                                                                                                        TextView textView54 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studentText);
                                                                                                                                                                                                                                                                        if (textView54 != null) {
                                                                                                                                                                                                                                                                            i = R.id.testCenter;
                                                                                                                                                                                                                                                                            TextView textView55 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testCenter);
                                                                                                                                                                                                                                                                            if (textView55 != null) {
                                                                                                                                                                                                                                                                                i = R.id.testCenterText;
                                                                                                                                                                                                                                                                                TextView textView56 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testCenterText);
                                                                                                                                                                                                                                                                                if (textView56 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.test_city;
                                                                                                                                                                                                                                                                                    TextView textView57 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_city);
                                                                                                                                                                                                                                                                                    if (textView57 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.testDate;
                                                                                                                                                                                                                                                                                        TextView textView58 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testDate);
                                                                                                                                                                                                                                                                                        if (textView58 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.testDateText;
                                                                                                                                                                                                                                                                                            TextView textView59 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testDateText);
                                                                                                                                                                                                                                                                                            if (textView59 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.testMode;
                                                                                                                                                                                                                                                                                                TextView textView60 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testMode);
                                                                                                                                                                                                                                                                                                if (textView60 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.testName;
                                                                                                                                                                                                                                                                                                    TextView textView61 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testName);
                                                                                                                                                                                                                                                                                                    if (textView61 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.test_state;
                                                                                                                                                                                                                                                                                                        TextView textView62 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_state);
                                                                                                                                                                                                                                                                                                        if (textView62 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.title;
                                                                                                                                                                                                                                                                                                            TextView textView63 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                                                                                                                                                                                                                                                            if (textView63 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.whatsapText;
                                                                                                                                                                                                                                                                                                                TextView textView64 = (TextView) ViewBindings.findChildViewById(rootView, R.id.whatsapText);
                                                                                                                                                                                                                                                                                                                if (textView64 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.whatsapp_text_tv;
                                                                                                                                                                                                                                                                                                                    TextView textView65 = (TextView) ViewBindings.findChildViewById(rootView, R.id.whatsapp_text_tv);
                                                                                                                                                                                                                                                                                                                    if (textView65 != null) {
                                                                                                                                                                                                                                                                                                                        return new ActivityRegistrationPreviewBinding((RelativeLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, button, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, imageView, linearLayout, linearLayout2, linearLayout3, nestedScrollView, textView30, textView31, textView32, textView33, textView34, textView35, textView36, textView37, textView38, textView39, textView40, textView41, textView42, textView43, textView44, relativeLayout, relativeLayout2, circleImageView, textView45, linearLayout4, textView46, relativeLayout3, textView47, textView48, textView49, textView50, textView51, textView52, textView53, textView54, textView55, textView56, textView57, textView58, textView59, textView60, textView61, textView62, textView63, textView64, textView65);
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
