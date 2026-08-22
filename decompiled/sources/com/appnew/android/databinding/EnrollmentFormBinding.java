package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class EnrollmentFormBinding implements ViewBinding {
    public final CircleImageView adharImage;
    public final TextView adharImageError;
    public final Button cancelBtn;
    public final RelativeLayout city;
    public final TextView cityError;
    public final TextView citySpinner;
    public final RelativeLayout country;
    public final TextView countryError;
    public final TextView countrySpinner;
    public final ImageView datePickerIV;
    public final TextView dobError;
    public final RelativeLayout dobRl;
    public final TextView dobTV;
    public final ImageView downArrowIV1;
    public final ImageView downarrowIVCity;
    public final ImageView downarrowIVcountry;
    public final ImageView downarrowIVstate;
    public final EditText emailTV;
    public final EditText etFmobile;
    public final EditText etFname;
    public final EditText etPAddress;
    public final EditText etStmobile;
    public final EditText etStname;
    public final ImageView imageBack;
    public final ImageView imagecity;
    public final ImageView imagecountry;
    public final RelativeLayout images;
    public final ImageView imagestate;
    public final Toolbar mainToolbar;
    public final RelativeLayout picAadharImgLL;
    public final RelativeLayout picUserImgLL;
    public final RadioButton rbFtProffAgri;
    public final RadioButton rbFtProffGovJob;
    public final RadioButton rbFtProffPvtJob;
    public final RadioButton rbStProffGovJob;
    public final RadioButton rbStProffPvtJob;
    public final RadioButton rbStProffStudent;
    public final RadioGroup rgFtProfession;
    public final RadioGroup rgStProfession;
    private final ScrollView rootView;
    public final RelativeLayout state;
    public final TextView stateError;
    public final TextView stateSpinner;
    public final Button submitBtn;
    public final TextView toolbarTitleTV;
    public final TextView tvAdharPic;
    public final TextView tvFtProfession;
    public final TextView tvFtProfessionError;
    public final TextView tvStProfession;
    public final TextView tvStProfessionError;
    public final TextView tvUserPic;
    public final RelativeLayout uploadAdarImg;
    public final RelativeLayout uploadUserImg;
    public final CircleImageView userImage;
    public final TextView userImageError;

    private EnrollmentFormBinding(ScrollView rootView, CircleImageView adharImage, TextView adharImageError, Button cancelBtn, RelativeLayout city, TextView cityError, TextView citySpinner, RelativeLayout country, TextView countryError, TextView countrySpinner, ImageView datePickerIV, TextView dobError, RelativeLayout dobRl, TextView dobTV, ImageView downArrowIV1, ImageView downarrowIVCity, ImageView downarrowIVcountry, ImageView downarrowIVstate, EditText emailTV, EditText etFmobile, EditText etFname, EditText etPAddress, EditText etStmobile, EditText etStname, ImageView imageBack, ImageView imagecity, ImageView imagecountry, RelativeLayout images, ImageView imagestate, Toolbar mainToolbar, RelativeLayout picAadharImgLL, RelativeLayout picUserImgLL, RadioButton rbFtProffAgri, RadioButton rbFtProffGovJob, RadioButton rbFtProffPvtJob, RadioButton rbStProffGovJob, RadioButton rbStProffPvtJob, RadioButton rbStProffStudent, RadioGroup rgFtProfession, RadioGroup rgStProfession, RelativeLayout state, TextView stateError, TextView stateSpinner, Button submitBtn, TextView toolbarTitleTV, TextView tvAdharPic, TextView tvFtProfession, TextView tvFtProfessionError, TextView tvStProfession, TextView tvStProfessionError, TextView tvUserPic, RelativeLayout uploadAdarImg, RelativeLayout uploadUserImg, CircleImageView userImage, TextView userImageError) {
        this.rootView = rootView;
        this.adharImage = adharImage;
        this.adharImageError = adharImageError;
        this.cancelBtn = cancelBtn;
        this.city = city;
        this.cityError = cityError;
        this.citySpinner = citySpinner;
        this.country = country;
        this.countryError = countryError;
        this.countrySpinner = countrySpinner;
        this.datePickerIV = datePickerIV;
        this.dobError = dobError;
        this.dobRl = dobRl;
        this.dobTV = dobTV;
        this.downArrowIV1 = downArrowIV1;
        this.downarrowIVCity = downarrowIVCity;
        this.downarrowIVcountry = downarrowIVcountry;
        this.downarrowIVstate = downarrowIVstate;
        this.emailTV = emailTV;
        this.etFmobile = etFmobile;
        this.etFname = etFname;
        this.etPAddress = etPAddress;
        this.etStmobile = etStmobile;
        this.etStname = etStname;
        this.imageBack = imageBack;
        this.imagecity = imagecity;
        this.imagecountry = imagecountry;
        this.images = images;
        this.imagestate = imagestate;
        this.mainToolbar = mainToolbar;
        this.picAadharImgLL = picAadharImgLL;
        this.picUserImgLL = picUserImgLL;
        this.rbFtProffAgri = rbFtProffAgri;
        this.rbFtProffGovJob = rbFtProffGovJob;
        this.rbFtProffPvtJob = rbFtProffPvtJob;
        this.rbStProffGovJob = rbStProffGovJob;
        this.rbStProffPvtJob = rbStProffPvtJob;
        this.rbStProffStudent = rbStProffStudent;
        this.rgFtProfession = rgFtProfession;
        this.rgStProfession = rgStProfession;
        this.state = state;
        this.stateError = stateError;
        this.stateSpinner = stateSpinner;
        this.submitBtn = submitBtn;
        this.toolbarTitleTV = toolbarTitleTV;
        this.tvAdharPic = tvAdharPic;
        this.tvFtProfession = tvFtProfession;
        this.tvFtProfessionError = tvFtProfessionError;
        this.tvStProfession = tvStProfession;
        this.tvStProfessionError = tvStProfessionError;
        this.tvUserPic = tvUserPic;
        this.uploadAdarImg = uploadAdarImg;
        this.uploadUserImg = uploadUserImg;
        this.userImage = userImage;
        this.userImageError = userImageError;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static EnrollmentFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EnrollmentFormBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.enrollment_form, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EnrollmentFormBinding bind(View rootView) {
        int i = R.id.adharImage;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.adharImage);
        if (circleImageView != null) {
            i = R.id.adharImageError;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.adharImageError);
            if (textView != null) {
                i = R.id.cancelBtn;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.cancelBtn);
                if (button != null) {
                    i = R.id.city;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.city);
                    if (relativeLayout != null) {
                        i = R.id.cityError;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cityError);
                        if (textView2 != null) {
                            i = R.id.citySpinner;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.citySpinner);
                            if (textView3 != null) {
                                i = R.id.country;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.country);
                                if (relativeLayout2 != null) {
                                    i = R.id.countryError;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.countryError);
                                    if (textView4 != null) {
                                        i = R.id.countrySpinner;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.countrySpinner);
                                        if (textView5 != null) {
                                            i = R.id.datePickerIV;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.datePickerIV);
                                            if (imageView != null) {
                                                i = R.id.dobError;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dobError);
                                                if (textView6 != null) {
                                                    i = R.id.dobRl;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.dobRl);
                                                    if (relativeLayout3 != null) {
                                                        i = R.id.dobTV;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dobTV);
                                                        if (textView7 != null) {
                                                            i = R.id.downArrowIV1;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downArrowIV1);
                                                            if (imageView2 != null) {
                                                                i = R.id.downarrowIVCity;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIVCity);
                                                                if (imageView3 != null) {
                                                                    i = R.id.downarrowIVcountry;
                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIVcountry);
                                                                    if (imageView4 != null) {
                                                                        i = R.id.downarrowIVstate;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIVstate);
                                                                        if (imageView5 != null) {
                                                                            i = R.id.emailTV;
                                                                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.emailTV);
                                                                            if (editText != null) {
                                                                                i = R.id.et_fmobile;
                                                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_fmobile);
                                                                                if (editText2 != null) {
                                                                                    i = R.id.et_fname;
                                                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_fname);
                                                                                    if (editText3 != null) {
                                                                                        i = R.id.et_pAddress;
                                                                                        EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_pAddress);
                                                                                        if (editText4 != null) {
                                                                                            i = R.id.et_stmobile;
                                                                                            EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_stmobile);
                                                                                            if (editText5 != null) {
                                                                                                i = R.id.et_stname;
                                                                                                EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_stname);
                                                                                                if (editText6 != null) {
                                                                                                    i = R.id.image_back;
                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                                                                                                    if (imageView6 != null) {
                                                                                                        i = R.id.imagecity;
                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagecity);
                                                                                                        if (imageView7 != null) {
                                                                                                            i = R.id.imagecountry;
                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagecountry);
                                                                                                            if (imageView8 != null) {
                                                                                                                i = R.id.images;
                                                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.images);
                                                                                                                if (relativeLayout4 != null) {
                                                                                                                    i = R.id.imagestate;
                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                                                                                                    if (imageView9 != null) {
                                                                                                                        i = R.id.main_toolbar;
                                                                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                                                                                                        if (toolbar != null) {
                                                                                                                            i = R.id.picAadharImgLL;
                                                                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.picAadharImgLL);
                                                                                                                            if (relativeLayout5 != null) {
                                                                                                                                i = R.id.picUserImgLL;
                                                                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.picUserImgLL);
                                                                                                                                if (relativeLayout6 != null) {
                                                                                                                                    i = R.id.rb_ftProff_agri;
                                                                                                                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb_ftProff_agri);
                                                                                                                                    if (radioButton != null) {
                                                                                                                                        i = R.id.rb_ftProff_govJob;
                                                                                                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb_ftProff_govJob);
                                                                                                                                        if (radioButton2 != null) {
                                                                                                                                            i = R.id.rb_ftProff_pvtJob;
                                                                                                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb_ftProff_pvtJob);
                                                                                                                                            if (radioButton3 != null) {
                                                                                                                                                i = R.id.rb_stProff_govJob;
                                                                                                                                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb_stProff_govJob);
                                                                                                                                                if (radioButton4 != null) {
                                                                                                                                                    i = R.id.rb_stProff_pvtJob;
                                                                                                                                                    RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb_stProff_pvtJob);
                                                                                                                                                    if (radioButton5 != null) {
                                                                                                                                                        i = R.id.rb_stProff_student;
                                                                                                                                                        RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.rb_stProff_student);
                                                                                                                                                        if (radioButton6 != null) {
                                                                                                                                                            i = R.id.rg_ftProfession;
                                                                                                                                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.rg_ftProfession);
                                                                                                                                                            if (radioGroup != null) {
                                                                                                                                                                i = R.id.rg_stProfession;
                                                                                                                                                                RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(rootView, R.id.rg_stProfession);
                                                                                                                                                                if (radioGroup2 != null) {
                                                                                                                                                                    i = R.id.state;
                                                                                                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.state);
                                                                                                                                                                    if (relativeLayout7 != null) {
                                                                                                                                                                        i = R.id.stateError;
                                                                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateError);
                                                                                                                                                                        if (textView8 != null) {
                                                                                                                                                                            i = R.id.stateSpinner;
                                                                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateSpinner);
                                                                                                                                                                            if (textView9 != null) {
                                                                                                                                                                                i = R.id.submitBtn;
                                                                                                                                                                                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.submitBtn);
                                                                                                                                                                                if (button2 != null) {
                                                                                                                                                                                    i = R.id.toolbarTitleTV;
                                                                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                                                        i = R.id.tv_AdharPic;
                                                                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_AdharPic);
                                                                                                                                                                                        if (textView11 != null) {
                                                                                                                                                                                            i = R.id.tv_ftProfession;
                                                                                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_ftProfession);
                                                                                                                                                                                            if (textView12 != null) {
                                                                                                                                                                                                i = R.id.tv_ftProfessionError;
                                                                                                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_ftProfessionError);
                                                                                                                                                                                                if (textView13 != null) {
                                                                                                                                                                                                    i = R.id.tv_stProfession;
                                                                                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_stProfession);
                                                                                                                                                                                                    if (textView14 != null) {
                                                                                                                                                                                                        i = R.id.tv_stProfessionError;
                                                                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_stProfessionError);
                                                                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                                                                            i = R.id.tv_userPic;
                                                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_userPic);
                                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                                i = R.id.uploadAdarImg;
                                                                                                                                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.uploadAdarImg);
                                                                                                                                                                                                                if (relativeLayout8 != null) {
                                                                                                                                                                                                                    i = R.id.uploadUserImg;
                                                                                                                                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.uploadUserImg);
                                                                                                                                                                                                                    if (relativeLayout9 != null) {
                                                                                                                                                                                                                        i = R.id.userImage;
                                                                                                                                                                                                                        CircleImageView circleImageView2 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.userImage);
                                                                                                                                                                                                                        if (circleImageView2 != null) {
                                                                                                                                                                                                                            i = R.id.userImageError;
                                                                                                                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userImageError);
                                                                                                                                                                                                                            if (textView17 != null) {
                                                                                                                                                                                                                                return new EnrollmentFormBinding((ScrollView) rootView, circleImageView, textView, button, relativeLayout, textView2, textView3, relativeLayout2, textView4, textView5, imageView, textView6, relativeLayout3, textView7, imageView2, imageView3, imageView4, imageView5, editText, editText2, editText3, editText4, editText5, editText6, imageView6, imageView7, imageView8, relativeLayout4, imageView9, toolbar, relativeLayout5, relativeLayout6, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioGroup, radioGroup2, relativeLayout7, textView8, textView9, button2, textView10, textView11, textView12, textView13, textView14, textView15, textView16, relativeLayout8, relativeLayout9, circleImageView2, textView17);
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
