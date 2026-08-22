package com.hbb20;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.appnew.android.Utils.Const;
import com.appnew.android.home.Constants;
import com.clevertap.android.sdk.Constants;
import com.google.firebase.dynamiclinks.DynamicLink;
import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.michaelrocks.libphonenumber.android.Phonenumber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class CountryCodePicker extends RelativeLayout {
    private static String ANDROID_NAME_SPACE = "http://schemas.android.com/apk/res/android";
    static String BUNDLE_SELECTED_CODE = "selectedCode";
    static final int DEFAULT_UNSET = -99;
    static int LIB_DEFAULT_COUNTRY_CODE = 91;
    static String TAG = "CCP";
    private static int TEXT_GRAVITY_CENTER = 0;
    private static int TEXT_GRAVITY_LEFT = -1;
    private static int TEXT_GRAVITY_RIGHT = 1;
    String CCP_PREF_FILE;
    TextWatcher areaCodeCountryDetectorTextWatcher;
    int arrowColor;
    boolean autoDetectCountryEnabled;
    boolean autoDetectLanguageEnabled;
    int borderFlagColor;
    boolean ccpClickable;
    boolean ccpDialogInitialScrollToSelection;
    boolean ccpDialogShowFlag;
    boolean ccpDialogShowNameCode;
    boolean ccpDialogShowPhoneCode;
    boolean ccpDialogShowTitle;
    int ccpPadding;
    int ccpTextgGravity;
    boolean ccpUseDummyEmojiForPreview;
    boolean ccpUseEmoji;
    CountryCodePicker codePicker;
    int contentColor;
    Context context;
    boolean countryChangedDueToAreaCode;
    View.OnClickListener countryCodeHolderClickListener;
    boolean countryDetectionBasedOnAreaAllowed;
    String countryPreference;
    private CCPCountryGroup currentCountryGroup;
    TextGravity currentTextGravity;
    private View.OnClickListener customClickListener;
    Language customDefaultLanguage;
    private CustomDialogTextProvider customDialogTextProvider;
    List<CCPCountry> customMasterCountriesList;
    String customMasterCountriesParam;
    CCPCountry defaultCCPCountry;
    int defaultCountryCode;
    String defaultCountryNameCode;
    boolean detectCountryWithAreaCode;
    private int dialogBackgroundColor;
    private int dialogBackgroundResId;
    private float dialogCornerRadius;
    private DialogEventsListener dialogEventsListener;
    boolean dialogKeyboardAutoPopup;
    private int dialogSearchEditTextTintColor;
    private int dialogTextColor;
    Typeface dialogTypeFace;
    int dialogTypeFaceStyle;
    EditText editText_registeredCarrierNumber;
    String excludedCountriesParam;
    private FailureListener failureListener;
    int fastScrollerBubbleColor;
    private int fastScrollerBubbleTextAppearance;
    private int fastScrollerHandleColor;
    InternationalPhoneTextWatcher formattingTextWatcher;
    boolean hintExampleNumberEnabled;
    PhoneNumberType hintExampleNumberType;
    RelativeLayout holder;
    View holderView;
    ImageView imageViewArrow;
    ImageView imageViewFlag;
    boolean internationalFormattingOnly;
    Language languageToApply;
    String lastCheckedAreaCode;
    int lastCursorPosition;
    LinearLayout linearFlagBorder;
    LinearLayout linearFlagHolder;
    LayoutInflater mInflater;
    boolean numberAutoFormattingEnabled;
    private OnCountryChangeListener onCountryChangeListener;
    String originalHint;
    private PhoneNumberValidityChangeListener phoneNumberValidityChangeListener;
    PhoneNumberUtil phoneUtil;
    List<CCPCountry> preferredCountries;
    RelativeLayout relativeClickConsumer;
    boolean rememberLastSelection;
    boolean reportedValidity;
    boolean searchAllowed;
    AutoDetectionPref selectedAutoDetectionPref;
    CCPCountry selectedCCPCountry;
    String selectionMemoryTag;
    boolean showArrow;
    boolean showCloseIcon;
    boolean showFastScroller;
    boolean showFlag;
    boolean showFullName;
    boolean showNameCode;
    boolean showPhoneCode;
    private CCPTalkBackTextProvider talkBackTextProvider;
    TextView textView_selectedCountry;
    TextWatcher validityTextWatcher;
    String xmlWidth;

    public interface CustomDialogTextProvider {
        String getCCPDialogNoResultACK(Language language, String defaultNoResultACK);

        String getCCPDialogSearchHintText(Language language, String defaultSearchHintText);

        String getCCPDialogTitle(Language language, String defaultTitle);
    }

    public interface DialogEventsListener {
        void onCcpDialogCancel(DialogInterface dialogInterface);

        void onCcpDialogDismiss(DialogInterface dialogInterface);

        void onCcpDialogOpen(Dialog dialog);
    }

    public interface FailureListener {
        void onCountryAutoDetectionFailed();
    }

    public interface OnCountryChangeListener {
        void onCountrySelected();
    }

    public enum PhoneNumberType {
        MOBILE,
        FIXED_LINE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    public interface PhoneNumberValidityChangeListener {
        void onValidityChanged(boolean isValidNumber);
    }

    public CountryCodePicker(Context context) {
        super(context);
        this.talkBackTextProvider = new InternalTalkBackTextProvider();
        this.CCP_PREF_FILE = "CCP_PREF_FILE";
        this.originalHint = "";
        this.selectedAutoDetectionPref = AutoDetectionPref.SIM_NETWORK_LOCALE;
        this.showNameCode = true;
        this.showPhoneCode = true;
        this.ccpDialogShowPhoneCode = true;
        this.showFlag = true;
        this.showFullName = false;
        this.showFastScroller = true;
        this.ccpDialogShowTitle = true;
        this.ccpDialogShowFlag = true;
        this.searchAllowed = true;
        this.showArrow = true;
        this.showCloseIcon = false;
        this.rememberLastSelection = false;
        this.detectCountryWithAreaCode = true;
        this.ccpDialogShowNameCode = true;
        this.ccpDialogInitialScrollToSelection = false;
        this.ccpUseEmoji = false;
        this.ccpUseDummyEmojiForPreview = false;
        this.internationalFormattingOnly = true;
        this.hintExampleNumberType = PhoneNumberType.MOBILE;
        this.selectionMemoryTag = "ccp_last_selection";
        this.contentColor = DEFAULT_UNSET;
        this.arrowColor = DEFAULT_UNSET;
        this.ccpTextgGravity = TEXT_GRAVITY_CENTER;
        this.fastScrollerBubbleColor = 0;
        this.customDefaultLanguage = Language.ENGLISH;
        this.languageToApply = Language.ENGLISH;
        this.dialogKeyboardAutoPopup = true;
        this.ccpClickable = true;
        this.autoDetectLanguageEnabled = false;
        this.autoDetectCountryEnabled = false;
        this.numberAutoFormattingEnabled = true;
        this.hintExampleNumberEnabled = false;
        this.xmlWidth = "notSet";
        this.lastCheckedAreaCode = null;
        this.lastCursorPosition = 0;
        this.countryChangedDueToAreaCode = false;
        this.fastScrollerHandleColor = 0;
        this.fastScrollerBubbleTextAppearance = 0;
        this.countryCodeHolderClickListener = new View.OnClickListener() { // from class: com.hbb20.CountryCodePicker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (CountryCodePicker.this.customClickListener != null) {
                    CountryCodePicker.this.customClickListener.onClick(v);
                    return;
                }
                if (CountryCodePicker.this.isCcpClickable()) {
                    if (CountryCodePicker.this.ccpDialogInitialScrollToSelection) {
                        CountryCodePicker countryCodePicker = CountryCodePicker.this;
                        countryCodePicker.launchCountrySelectionDialog(countryCodePicker.getSelectedCountryNameCode());
                    } else {
                        CountryCodePicker.this.launchCountrySelectionDialog();
                    }
                }
            }
        };
        this.context = context;
        init(null);
    }

    public CountryCodePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.talkBackTextProvider = new InternalTalkBackTextProvider();
        this.CCP_PREF_FILE = "CCP_PREF_FILE";
        this.originalHint = "";
        this.selectedAutoDetectionPref = AutoDetectionPref.SIM_NETWORK_LOCALE;
        this.showNameCode = true;
        this.showPhoneCode = true;
        this.ccpDialogShowPhoneCode = true;
        this.showFlag = true;
        this.showFullName = false;
        this.showFastScroller = true;
        this.ccpDialogShowTitle = true;
        this.ccpDialogShowFlag = true;
        this.searchAllowed = true;
        this.showArrow = true;
        this.showCloseIcon = false;
        this.rememberLastSelection = false;
        this.detectCountryWithAreaCode = true;
        this.ccpDialogShowNameCode = true;
        this.ccpDialogInitialScrollToSelection = false;
        this.ccpUseEmoji = false;
        this.ccpUseDummyEmojiForPreview = false;
        this.internationalFormattingOnly = true;
        this.hintExampleNumberType = PhoneNumberType.MOBILE;
        this.selectionMemoryTag = "ccp_last_selection";
        this.contentColor = DEFAULT_UNSET;
        this.arrowColor = DEFAULT_UNSET;
        this.ccpTextgGravity = TEXT_GRAVITY_CENTER;
        this.fastScrollerBubbleColor = 0;
        this.customDefaultLanguage = Language.ENGLISH;
        this.languageToApply = Language.ENGLISH;
        this.dialogKeyboardAutoPopup = true;
        this.ccpClickable = true;
        this.autoDetectLanguageEnabled = false;
        this.autoDetectCountryEnabled = false;
        this.numberAutoFormattingEnabled = true;
        this.hintExampleNumberEnabled = false;
        this.xmlWidth = "notSet";
        this.lastCheckedAreaCode = null;
        this.lastCursorPosition = 0;
        this.countryChangedDueToAreaCode = false;
        this.fastScrollerHandleColor = 0;
        this.fastScrollerBubbleTextAppearance = 0;
        this.countryCodeHolderClickListener = new View.OnClickListener() { // from class: com.hbb20.CountryCodePicker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (CountryCodePicker.this.customClickListener != null) {
                    CountryCodePicker.this.customClickListener.onClick(v);
                    return;
                }
                if (CountryCodePicker.this.isCcpClickable()) {
                    if (CountryCodePicker.this.ccpDialogInitialScrollToSelection) {
                        CountryCodePicker countryCodePicker = CountryCodePicker.this;
                        countryCodePicker.launchCountrySelectionDialog(countryCodePicker.getSelectedCountryNameCode());
                    } else {
                        CountryCodePicker.this.launchCountrySelectionDialog();
                    }
                }
            }
        };
        this.context = context;
        init(attrs);
    }

    public CountryCodePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.talkBackTextProvider = new InternalTalkBackTextProvider();
        this.CCP_PREF_FILE = "CCP_PREF_FILE";
        this.originalHint = "";
        this.selectedAutoDetectionPref = AutoDetectionPref.SIM_NETWORK_LOCALE;
        this.showNameCode = true;
        this.showPhoneCode = true;
        this.ccpDialogShowPhoneCode = true;
        this.showFlag = true;
        this.showFullName = false;
        this.showFastScroller = true;
        this.ccpDialogShowTitle = true;
        this.ccpDialogShowFlag = true;
        this.searchAllowed = true;
        this.showArrow = true;
        this.showCloseIcon = false;
        this.rememberLastSelection = false;
        this.detectCountryWithAreaCode = true;
        this.ccpDialogShowNameCode = true;
        this.ccpDialogInitialScrollToSelection = false;
        this.ccpUseEmoji = false;
        this.ccpUseDummyEmojiForPreview = false;
        this.internationalFormattingOnly = true;
        this.hintExampleNumberType = PhoneNumberType.MOBILE;
        this.selectionMemoryTag = "ccp_last_selection";
        this.contentColor = DEFAULT_UNSET;
        this.arrowColor = DEFAULT_UNSET;
        this.ccpTextgGravity = TEXT_GRAVITY_CENTER;
        this.fastScrollerBubbleColor = 0;
        this.customDefaultLanguage = Language.ENGLISH;
        this.languageToApply = Language.ENGLISH;
        this.dialogKeyboardAutoPopup = true;
        this.ccpClickable = true;
        this.autoDetectLanguageEnabled = false;
        this.autoDetectCountryEnabled = false;
        this.numberAutoFormattingEnabled = true;
        this.hintExampleNumberEnabled = false;
        this.xmlWidth = "notSet";
        this.lastCheckedAreaCode = null;
        this.lastCursorPosition = 0;
        this.countryChangedDueToAreaCode = false;
        this.fastScrollerHandleColor = 0;
        this.fastScrollerBubbleTextAppearance = 0;
        this.countryCodeHolderClickListener = new View.OnClickListener() { // from class: com.hbb20.CountryCodePicker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (CountryCodePicker.this.customClickListener != null) {
                    CountryCodePicker.this.customClickListener.onClick(v);
                    return;
                }
                if (CountryCodePicker.this.isCcpClickable()) {
                    if (CountryCodePicker.this.ccpDialogInitialScrollToSelection) {
                        CountryCodePicker countryCodePicker = CountryCodePicker.this;
                        countryCodePicker.launchCountrySelectionDialog(countryCodePicker.getSelectedCountryNameCode());
                    } else {
                        CountryCodePicker.this.launchCountrySelectionDialog();
                    }
                }
            }
        };
        this.context = context;
        init(attrs);
    }

    private boolean isNumberAutoFormattingEnabled() {
        return this.numberAutoFormattingEnabled;
    }

    public void setNumberAutoFormattingEnabled(boolean numberAutoFormattingEnabled) {
        this.numberAutoFormattingEnabled = numberAutoFormattingEnabled;
        if (this.editText_registeredCarrierNumber != null) {
            updateFormattingTextWatcher();
        }
    }

    private boolean isInternationalFormattingOnlyEnabled() {
        return this.internationalFormattingOnly;
    }

    public void setInternationalFormattingOnly(boolean internationalFormattingOnly) {
        this.internationalFormattingOnly = internationalFormattingOnly;
        if (this.editText_registeredCarrierNumber != null) {
            updateFormattingTextWatcher();
        }
    }

    private void init(AttributeSet attrs) {
        String str;
        this.mInflater = LayoutInflater.from(this.context);
        if (attrs != null) {
            this.xmlWidth = attrs.getAttributeValue(ANDROID_NAME_SPACE, "layout_width");
        }
        removeAllViewsInLayout();
        if (attrs != null && (str = this.xmlWidth) != null && (str.equals("-1") || this.xmlWidth.equals("-1") || this.xmlWidth.equals("fill_parent") || this.xmlWidth.equals("match_parent"))) {
            this.holderView = this.mInflater.inflate(R.layout.layout_full_width_code_picker, (ViewGroup) this, true);
        } else {
            this.holderView = this.mInflater.inflate(R.layout.layout_code_picker, (ViewGroup) this, true);
        }
        this.textView_selectedCountry = (TextView) this.holderView.findViewById(R.id.textView_selectedCountry);
        this.holder = (RelativeLayout) this.holderView.findViewById(R.id.countryCodeHolder);
        this.imageViewArrow = (ImageView) this.holderView.findViewById(R.id.imageView_arrow);
        this.imageViewFlag = (ImageView) this.holderView.findViewById(R.id.image_flag);
        this.linearFlagHolder = (LinearLayout) this.holderView.findViewById(R.id.linear_flag_holder);
        this.linearFlagBorder = (LinearLayout) this.holderView.findViewById(R.id.linear_flag_border);
        this.relativeClickConsumer = (RelativeLayout) this.holderView.findViewById(R.id.rlClickConsumer);
        this.codePicker = this;
        if (attrs != null) {
            applyCustomProperty(attrs);
        }
        this.relativeClickConsumer.setOnClickListener(this.countryCodeHolderClickListener);
    }

    private void applyCustomProperty(AttributeSet attrs) {
        boolean z;
        int color;
        int color2;
        TypedArray typedArrayObtainStyledAttributes = this.context.getTheme().obtainStyledAttributes(attrs, R.styleable.CountryCodePicker, 0, 0);
        try {
            this.showNameCode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_showNameCode, true);
            this.numberAutoFormattingEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_autoFormatNumber, true);
            this.showPhoneCode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_showPhoneCode, true);
            this.ccpDialogShowPhoneCode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_showPhoneCode, this.showPhoneCode);
            this.ccpDialogShowNameCode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_showNameCode, true);
            this.ccpDialogShowTitle = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_showTitle, true);
            this.ccpUseEmoji = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_useFlagEmoji, false);
            this.ccpUseDummyEmojiForPreview = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_useDummyEmojiForPreview, false);
            this.ccpDialogShowFlag = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_showFlag, true);
            this.ccpDialogInitialScrollToSelection = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_initialScrollToSelection, false);
            this.showFullName = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_showFullName, false);
            this.showFastScroller = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_showFastScroller, true);
            this.fastScrollerBubbleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccpDialog_fastScroller_bubbleColor, 0);
            this.fastScrollerHandleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccpDialog_fastScroller_handleColor, 0);
            this.fastScrollerBubbleTextAppearance = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CountryCodePicker_ccpDialog_fastScroller_bubbleTextAppearance, 0);
            this.autoDetectLanguageEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_autoDetectLanguage, false);
            this.detectCountryWithAreaCode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_areaCodeDetectedCountry, true);
            this.rememberLastSelection = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_rememberLastSelection, false);
            this.hintExampleNumberEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_hintExampleNumber, false);
            this.internationalFormattingOnly = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_internationalFormattingOnly, true);
            int dimension = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.CountryCodePicker_ccp_padding, this.context.getResources().getDimension(R.dimen.ccp_padding));
            this.ccpPadding = dimension;
            this.relativeClickConsumer.setPadding(dimension, dimension, dimension, dimension);
            this.hintExampleNumberType = PhoneNumberType.values()[typedArrayObtainStyledAttributes.getInt(R.styleable.CountryCodePicker_ccp_hintExampleNumberType, 0)];
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.CountryCodePicker_ccp_selectionMemoryTag);
            this.selectionMemoryTag = string;
            if (string == null) {
                this.selectionMemoryTag = "CCP_last_selection";
            }
            this.selectedAutoDetectionPref = AutoDetectionPref.getPrefForValue(String.valueOf(typedArrayObtainStyledAttributes.getInt(R.styleable.CountryCodePicker_ccp_countryAutoDetectionPref, 123)));
            this.autoDetectCountryEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_autoDetectCountry, false);
            this.showArrow = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_showArrow, true);
            refreshArrowViewVisibility();
            this.showCloseIcon = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_showCloseIcon, false);
            showFlag(typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_showFlag, true));
            setDialogKeyboardAutoPopup(typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_keyboardAutoPopup, true));
            this.customDefaultLanguage = getLanguageEnum(typedArrayObtainStyledAttributes.getInt(R.styleable.CountryCodePicker_ccp_defaultLanguage, Language.ENGLISH.ordinal()));
            updateLanguageToApply();
            this.customMasterCountriesParam = typedArrayObtainStyledAttributes.getString(R.styleable.CountryCodePicker_ccp_customMasterCountries);
            this.excludedCountriesParam = typedArrayObtainStyledAttributes.getString(R.styleable.CountryCodePicker_ccp_excludedCountries);
            if (!isInEditMode()) {
                refreshCustomMasterList();
            }
            this.countryPreference = typedArrayObtainStyledAttributes.getString(R.styleable.CountryCodePicker_ccp_countryPreference);
            if (!isInEditMode()) {
                refreshPreferredCountries();
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CountryCodePicker_ccp_textGravity)) {
                this.ccpTextgGravity = typedArrayObtainStyledAttributes.getInt(R.styleable.CountryCodePicker_ccp_textGravity, TEXT_GRAVITY_CENTER);
            }
            applyTextGravity(this.ccpTextgGravity);
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.CountryCodePicker_ccp_defaultNameCode);
            this.defaultCountryNameCode = string2;
            if (string2 == null || string2.length() == 0) {
                z = false;
            } else {
                if (!isInEditMode()) {
                    if (CCPCountry.getCountryForNameCodeFromLibraryMasterList(getContext(), getLanguageToApply(), this.defaultCountryNameCode) != null) {
                        setDefaultCountry(CCPCountry.getCountryForNameCodeFromLibraryMasterList(getContext(), getLanguageToApply(), this.defaultCountryNameCode));
                        setSelectedCountry(this.defaultCCPCountry);
                        z = true;
                    }
                    z = false;
                } else {
                    if (CCPCountry.getCountryForNameCodeFromEnglishList(this.defaultCountryNameCode) != null) {
                        setDefaultCountry(CCPCountry.getCountryForNameCodeFromEnglishList(this.defaultCountryNameCode));
                        setSelectedCountry(this.defaultCCPCountry);
                        z = true;
                    }
                    z = false;
                }
                if (!z) {
                    setDefaultCountry(CCPCountry.getCountryForNameCodeFromEnglishList("IN"));
                    setSelectedCountry(this.defaultCCPCountry);
                    z = true;
                }
            }
            int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.CountryCodePicker_ccp_defaultPhoneCode, -1);
            if (!z && integer != -1) {
                if (isInEditMode()) {
                    CCPCountry countryForCodeFromEnglishList = CCPCountry.getCountryForCodeFromEnglishList(integer + "");
                    if (countryForCodeFromEnglishList == null) {
                        countryForCodeFromEnglishList = CCPCountry.getCountryForCodeFromEnglishList(LIB_DEFAULT_COUNTRY_CODE + "");
                    }
                    setDefaultCountry(countryForCodeFromEnglishList);
                    setSelectedCountry(countryForCodeFromEnglishList);
                } else {
                    if (integer != -1 && CCPCountry.getCountryForCode(getContext(), getLanguageToApply(), this.preferredCountries, integer) == null) {
                        integer = LIB_DEFAULT_COUNTRY_CODE;
                    }
                    setDefaultCountryUsingPhoneCode(integer);
                    setSelectedCountry(this.defaultCCPCountry);
                }
            }
            if (getDefaultCountry() == null) {
                setDefaultCountry(CCPCountry.getCountryForNameCodeFromEnglishList("IN"));
                if (getSelectedCountry() == null) {
                    setSelectedCountry(this.defaultCCPCountry);
                }
            }
            if (isAutoDetectCountryEnabled() && !isInEditMode()) {
                setAutoDetectedCountry(true);
            }
            if (this.rememberLastSelection && !isInEditMode()) {
                loadLastSelectedCountryInCCP();
            }
            setArrowColor(typedArrayObtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccp_arrowColor, DEFAULT_UNSET));
            if (isInEditMode()) {
                color = typedArrayObtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccp_contentColor, DEFAULT_UNSET);
            } else {
                color = typedArrayObtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccp_contentColor, this.context.getResources().getColor(R.color.defaultContentColor));
            }
            if (color != DEFAULT_UNSET) {
                setContentColor(color);
            }
            if (isInEditMode()) {
                color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccp_flagBorderColor, 0);
            } else {
                color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccp_flagBorderColor, this.context.getResources().getColor(R.color.defaultBorderFlagColor));
            }
            if (color2 != 0) {
                setFlagBorderColor(color2);
            }
            setDialogBackgroundColor(typedArrayObtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccpDialog_backgroundColor, 0));
            setDialogBackground(typedArrayObtainStyledAttributes.getResourceId(R.styleable.CountryCodePicker_ccpDialog_background, 0));
            setDialogTextColor(typedArrayObtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccpDialog_textColor, 0));
            setDialogSearchEditTextTintColor(typedArrayObtainStyledAttributes.getColor(R.styleable.CountryCodePicker_ccpDialog_searchEditTextTint, 0));
            setDialogCornerRaius(typedArrayObtainStyledAttributes.getDimension(R.styleable.CountryCodePicker_ccpDialog_cornerRadius, 0.0f));
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CountryCodePicker_ccp_textSize, 0);
            if (dimensionPixelSize > 0) {
                this.textView_selectedCountry.setTextSize(0, dimensionPixelSize);
                setFlagSize(dimensionPixelSize);
                setArrowSize(dimensionPixelSize);
            }
            int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CountryCodePicker_ccp_arrowSize, 0);
            if (dimensionPixelSize2 > 0) {
                setArrowSize(dimensionPixelSize2);
            }
            this.searchAllowed = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccpDialog_allowSearch, true);
            setCcpClickable(typedArrayObtainStyledAttributes.getBoolean(R.styleable.CountryCodePicker_ccp_clickable, true));
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void refreshArrowViewVisibility() {
        if (this.showArrow) {
            this.imageViewArrow.setVisibility(0);
        } else {
            this.imageViewArrow.setVisibility(8);
        }
    }

    private void loadLastSelectedCountryInCCP() {
        String string = this.context.getSharedPreferences(this.CCP_PREF_FILE, 0).getString(this.selectionMemoryTag, null);
        if (string != null) {
            setCountryForNameCode(string);
        }
    }

    void storeSelectedCountryNameCode(String selectedCountryNameCode) {
        SharedPreferences.Editor editorEdit = this.context.getSharedPreferences(this.CCP_PREF_FILE, 0).edit();
        editorEdit.putString(this.selectionMemoryTag, selectedCountryNameCode);
        editorEdit.apply();
    }

    boolean isCcpDialogShowPhoneCode() {
        return this.ccpDialogShowPhoneCode;
    }

    public void setCcpDialogShowPhoneCode(boolean ccpDialogShowPhoneCode) {
        this.ccpDialogShowPhoneCode = ccpDialogShowPhoneCode;
    }

    public boolean getCcpDialogShowNameCode() {
        return this.ccpDialogShowNameCode;
    }

    public void setCcpDialogShowNameCode(boolean ccpDialogShowNameCode) {
        this.ccpDialogShowNameCode = ccpDialogShowNameCode;
    }

    public boolean getCcpDialogShowTitle() {
        return this.ccpDialogShowTitle;
    }

    public void setCcpDialogShowTitle(boolean ccpDialogShowTitle) {
        this.ccpDialogShowTitle = ccpDialogShowTitle;
    }

    public boolean getCcpDialogShowFlag() {
        return this.ccpDialogShowFlag;
    }

    public void setCcpDialogShowFlag(boolean ccpDialogShowFlag) {
        this.ccpDialogShowFlag = ccpDialogShowFlag;
    }

    boolean isShowPhoneCode() {
        return this.showPhoneCode;
    }

    public void setShowPhoneCode(boolean showPhoneCode) {
        this.showPhoneCode = showPhoneCode;
        setSelectedCountry(this.selectedCCPCountry);
    }

    protected DialogEventsListener getDialogEventsListener() {
        return this.dialogEventsListener;
    }

    public void setDialogEventsListener(DialogEventsListener dialogEventsListener) {
        this.dialogEventsListener = dialogEventsListener;
    }

    int getFastScrollerBubbleTextAppearance() {
        return this.fastScrollerBubbleTextAppearance;
    }

    public void setFastScrollerBubbleTextAppearance(int fastScrollerBubbleTextAppearance) {
        this.fastScrollerBubbleTextAppearance = fastScrollerBubbleTextAppearance;
    }

    int getFastScrollerHandleColor() {
        return this.fastScrollerHandleColor;
    }

    public void setFastScrollerHandleColor(int fastScrollerHandleColor) {
        this.fastScrollerHandleColor = fastScrollerHandleColor;
    }

    int getFastScrollerBubbleColor() {
        return this.fastScrollerBubbleColor;
    }

    public void setFastScrollerBubbleColor(int fastScrollerBubbleColor) {
        this.fastScrollerBubbleColor = fastScrollerBubbleColor;
    }

    TextGravity getCurrentTextGravity() {
        return this.currentTextGravity;
    }

    public void setCurrentTextGravity(TextGravity textGravity) {
        this.currentTextGravity = textGravity;
        applyTextGravity(textGravity.enumIndex);
    }

    private void applyTextGravity(int enumIndex) {
        if (enumIndex == TextGravity.LEFT.enumIndex) {
            this.textView_selectedCountry.setGravity(3);
        } else if (enumIndex == TextGravity.CENTER.enumIndex) {
            this.textView_selectedCountry.setGravity(17);
        } else {
            this.textView_selectedCountry.setGravity(5);
        }
    }

    private void updateLanguageToApply() {
        if (isInEditMode()) {
            Language language = this.customDefaultLanguage;
            if (language != null) {
                this.languageToApply = language;
                return;
            } else {
                this.languageToApply = Language.ENGLISH;
                return;
            }
        }
        if (isAutoDetectLanguageEnabled()) {
            Language cCPLanguageFromLocale = getCCPLanguageFromLocale();
            if (cCPLanguageFromLocale == null) {
                if (getCustomDefaultLanguage() != null) {
                    this.languageToApply = getCustomDefaultLanguage();
                    return;
                } else {
                    this.languageToApply = Language.ENGLISH;
                    return;
                }
            }
            this.languageToApply = cCPLanguageFromLocale;
            return;
        }
        if (getCustomDefaultLanguage() != null) {
            this.languageToApply = this.customDefaultLanguage;
        } else {
            this.languageToApply = Language.ENGLISH;
        }
    }

    private Language getCCPLanguageFromLocale() {
        Locale locale = this.context.getResources().getConfiguration().locale;
        for (Language language : Language.values()) {
            if (language.getCode().equalsIgnoreCase(locale.getLanguage()) && (language.getCountry() == null || language.getCountry().equalsIgnoreCase(locale.getCountry()) || language.getScript() == null || language.getScript().equalsIgnoreCase(locale.getScript()))) {
                return language;
            }
        }
        return null;
    }

    private CCPCountry getDefaultCountry() {
        return this.defaultCCPCountry;
    }

    private void setDefaultCountry(CCPCountry defaultCCPCountry) {
        this.defaultCCPCountry = defaultCCPCountry;
    }

    public TextView getTextView_selectedCountry() {
        return this.textView_selectedCountry;
    }

    public void setTextView_selectedCountry(TextView textView_selectedCountry) {
        this.textView_selectedCountry = textView_selectedCountry;
    }

    public ImageView getImageViewFlag() {
        return this.imageViewFlag;
    }

    public void setImageViewFlag(ImageView imageViewFlag) {
        this.imageViewFlag = imageViewFlag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CCPCountry getSelectedCountry() {
        if (this.selectedCCPCountry == null) {
            setSelectedCountry(getDefaultCountry());
        }
        return this.selectedCCPCountry;
    }

    void setSelectedCountry(CCPCountry selectedCCPCountry) {
        CCPTalkBackTextProvider cCPTalkBackTextProvider = this.talkBackTextProvider;
        if (cCPTalkBackTextProvider != null && cCPTalkBackTextProvider.getTalkBackTextForCountry(selectedCCPCountry) != null) {
            this.textView_selectedCountry.setContentDescription(this.talkBackTextProvider.getTalkBackTextForCountry(selectedCCPCountry));
        }
        this.countryDetectionBasedOnAreaAllowed = false;
        String str = "";
        this.lastCheckedAreaCode = "";
        if (selectedCCPCountry == null && (selectedCCPCountry = CCPCountry.getCountryForCode(getContext(), getLanguageToApply(), this.preferredCountries, this.defaultCountryCode)) == null) {
            return;
        }
        this.selectedCCPCountry = selectedCCPCountry;
        if (this.showFlag && this.ccpUseEmoji) {
            str = isInEditMode() ? this.ccpUseDummyEmojiForPreview ? "🏁\u200b " : "" + CCPCountry.getFlagEmoji(selectedCCPCountry) + "\u200b " : "" + CCPCountry.getFlagEmoji(selectedCCPCountry) + "  ";
        }
        if (this.showFullName) {
            str = str + selectedCCPCountry.getName();
        }
        if (this.showNameCode) {
            if (this.showFullName) {
                str = str + " (" + selectedCCPCountry.getNameCode().toUpperCase() + ")";
            } else {
                str = str + " " + selectedCCPCountry.getNameCode().toUpperCase();
            }
        }
        if (this.showPhoneCode) {
            if (str.length() > 0) {
                str = str + "  ";
            }
            str = str + MqttTopic.SINGLE_LEVEL_WILDCARD + selectedCCPCountry.getPhoneCode();
        }
        this.textView_selectedCountry.setText(str);
        if (!this.showFlag && str.length() == 0) {
            this.textView_selectedCountry.setText(str + MqttTopic.SINGLE_LEVEL_WILDCARD + selectedCCPCountry.getPhoneCode());
        }
        this.imageViewFlag.setImageResource(selectedCCPCountry.getFlagID());
        OnCountryChangeListener onCountryChangeListener = this.onCountryChangeListener;
        if (onCountryChangeListener != null) {
            onCountryChangeListener.onCountrySelected();
        }
        updateFormattingTextWatcher();
        updateHint();
        if (this.editText_registeredCarrierNumber != null && this.phoneNumberValidityChangeListener != null) {
            boolean zIsValidFullNumber = isValidFullNumber();
            this.reportedValidity = zIsValidFullNumber;
            this.phoneNumberValidityChangeListener.onValidityChanged(zIsValidFullNumber);
        }
        this.countryDetectionBasedOnAreaAllowed = true;
        if (this.countryChangedDueToAreaCode) {
            try {
                this.editText_registeredCarrierNumber.setSelection(this.lastCursorPosition);
                this.countryChangedDueToAreaCode = false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        updateCountryGroup();
    }

    private void updateCountryGroup() {
        this.currentCountryGroup = CCPCountryGroup.getCountryGroupForPhoneCode(getSelectedCountryCodeAsInt());
    }

    private void updateHint() {
        if (this.editText_registeredCarrierNumber == null || !this.hintExampleNumberEnabled) {
            return;
        }
        Phonenumber.PhoneNumber exampleNumberForType = getPhoneUtil().getExampleNumberForType(getSelectedCountryNameCode(), getSelectedHintNumberType());
        String number = "";
        if (exampleNumberForType != null) {
            number = PhoneNumberUtils.formatNumber(getSelectedCountryCodeWithPlus() + (exampleNumberForType.getNationalNumber() + ""), getSelectedCountryNameCode());
            if (number != null) {
                number = number.substring(getSelectedCountryCodeWithPlus().length()).trim();
            }
        }
        if (number == null) {
            number = this.originalHint;
        }
        this.editText_registeredCarrierNumber.setHint(number);
    }

    /* JADX INFO: renamed from: com.hbb20.CountryCodePicker$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType;

        static {
            int[] iArr = new int[PhoneNumberType.values().length];
            $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType = iArr;
            try {
                iArr[PhoneNumberType.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[PhoneNumberType.FIXED_LINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[PhoneNumberType.TOLL_FREE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[PhoneNumberType.PREMIUM_RATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[PhoneNumberType.UNKNOWN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private PhoneNumberUtil.PhoneNumberType getSelectedHintNumberType() {
        switch (AnonymousClass4.$SwitchMap$com$hbb20$CountryCodePicker$PhoneNumberType[this.hintExampleNumberType.ordinal()]) {
            case 1:
                return PhoneNumberUtil.PhoneNumberType.MOBILE;
            case 2:
                return PhoneNumberUtil.PhoneNumberType.FIXED_LINE;
            case 3:
                return PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE;
            case 4:
                return PhoneNumberUtil.PhoneNumberType.TOLL_FREE;
            case 5:
                return PhoneNumberUtil.PhoneNumberType.PREMIUM_RATE;
            case 6:
                return PhoneNumberUtil.PhoneNumberType.SHARED_COST;
            case 7:
                return PhoneNumberUtil.PhoneNumberType.VOIP;
            case 8:
                return PhoneNumberUtil.PhoneNumberType.PERSONAL_NUMBER;
            case 9:
                return PhoneNumberUtil.PhoneNumberType.PAGER;
            case 10:
                return PhoneNumberUtil.PhoneNumberType.UAN;
            case 11:
                return PhoneNumberUtil.PhoneNumberType.VOICEMAIL;
            case 12:
                return PhoneNumberUtil.PhoneNumberType.UNKNOWN;
            default:
                return PhoneNumberUtil.PhoneNumberType.MOBILE;
        }
    }

    public Language getLanguageToApply() {
        if (this.languageToApply == null) {
            updateLanguageToApply();
        }
        return this.languageToApply;
    }

    void setLanguageToApply(Language languageToApply) {
        this.languageToApply = languageToApply;
    }

    private void updateFormattingTextWatcher() {
        EditText editText = this.editText_registeredCarrierNumber;
        if (editText == null || this.selectedCCPCountry == null) {
            if (editText == null) {
                Log.v(TAG, "updateFormattingTextWatcher: EditText not registered " + this.selectionMemoryTag);
                return;
            } else {
                Log.v(TAG, "updateFormattingTextWatcher: selected country is null " + this.selectionMemoryTag);
                return;
            }
        }
        String strNormalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(getEditText_registeredCarrierNumber().getText().toString());
        InternationalPhoneTextWatcher internationalPhoneTextWatcher = this.formattingTextWatcher;
        if (internationalPhoneTextWatcher != null) {
            this.editText_registeredCarrierNumber.removeTextChangedListener(internationalPhoneTextWatcher);
        }
        TextWatcher textWatcher = this.areaCodeCountryDetectorTextWatcher;
        if (textWatcher != null) {
            this.editText_registeredCarrierNumber.removeTextChangedListener(textWatcher);
        }
        if (this.numberAutoFormattingEnabled) {
            InternationalPhoneTextWatcher internationalPhoneTextWatcher2 = new InternationalPhoneTextWatcher(this.context, getSelectedCountryNameCode(), getSelectedCountryCodeAsInt(), this.internationalFormattingOnly);
            this.formattingTextWatcher = internationalPhoneTextWatcher2;
            this.editText_registeredCarrierNumber.addTextChangedListener(internationalPhoneTextWatcher2);
        }
        if (this.detectCountryWithAreaCode) {
            TextWatcher countryDetectorTextWatcher = getCountryDetectorTextWatcher();
            this.areaCodeCountryDetectorTextWatcher = countryDetectorTextWatcher;
            this.editText_registeredCarrierNumber.addTextChangedListener(countryDetectorTextWatcher);
        }
        this.editText_registeredCarrierNumber.setText("");
        this.editText_registeredCarrierNumber.setText(strNormalizeDigitsOnly);
        EditText editText2 = this.editText_registeredCarrierNumber;
        editText2.setSelection(editText2.getText().length());
    }

    private TextWatcher getCountryDetectorTextWatcher() {
        if (this.editText_registeredCarrierNumber != null && this.areaCodeCountryDetectorTextWatcher == null) {
            this.areaCodeCountryDetectorTextWatcher = new TextWatcher() { // from class: com.hbb20.CountryCodePicker.2
                String lastCheckedNumber = null;

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    CCPCountry selectedCountry = CountryCodePicker.this.getSelectedCountry();
                    if (selectedCountry != null) {
                        String str = this.lastCheckedNumber;
                        if ((str == null || !str.equals(s.toString())) && CountryCodePicker.this.countryDetectionBasedOnAreaAllowed) {
                            if (CountryCodePicker.this.currentCountryGroup != null) {
                                String string = CountryCodePicker.this.getEditText_registeredCarrierNumber().getText().toString();
                                if (string.length() >= CountryCodePicker.this.currentCountryGroup.areaCodeLength) {
                                    String strNormalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(string);
                                    if (strNormalizeDigitsOnly.length() >= CountryCodePicker.this.currentCountryGroup.areaCodeLength) {
                                        String strSubstring = strNormalizeDigitsOnly.substring(0, CountryCodePicker.this.currentCountryGroup.areaCodeLength);
                                        if (!strSubstring.equals(CountryCodePicker.this.lastCheckedAreaCode)) {
                                            CCPCountry countryForAreaCode = CountryCodePicker.this.currentCountryGroup.getCountryForAreaCode(CountryCodePicker.this.context, CountryCodePicker.this.getLanguageToApply(), strSubstring);
                                            if (!countryForAreaCode.equals(selectedCountry)) {
                                                CountryCodePicker.this.countryChangedDueToAreaCode = true;
                                                CountryCodePicker.this.lastCursorPosition = Selection.getSelectionEnd(s);
                                                CountryCodePicker.this.setSelectedCountry(countryForAreaCode);
                                            }
                                            CountryCodePicker.this.lastCheckedAreaCode = strSubstring;
                                        }
                                    }
                                }
                            }
                            this.lastCheckedNumber = s.toString();
                        }
                    }
                }
            };
        }
        return this.areaCodeCountryDetectorTextWatcher;
    }

    Language getCustomDefaultLanguage() {
        return this.customDefaultLanguage;
    }

    private void setCustomDefaultLanguage(Language customDefaultLanguage) {
        this.customDefaultLanguage = customDefaultLanguage;
        updateLanguageToApply();
        setSelectedCountry(CCPCountry.getCountryForNameCodeFromLibraryMasterList(this.context, getLanguageToApply(), this.selectedCCPCountry.getNameCode()));
    }

    private View getHolderView() {
        return this.holderView;
    }

    private void setHolderView(View holderView) {
        this.holderView = holderView;
    }

    public RelativeLayout getHolder() {
        return this.holder;
    }

    private void setHolder(RelativeLayout holder) {
        this.holder = holder;
    }

    boolean isAutoDetectLanguageEnabled() {
        return this.autoDetectLanguageEnabled;
    }

    boolean isAutoDetectCountryEnabled() {
        return this.autoDetectCountryEnabled;
    }

    boolean isDialogKeyboardAutoPopup() {
        return this.dialogKeyboardAutoPopup;
    }

    public void setDialogKeyboardAutoPopup(boolean dialogKeyboardAutoPopup) {
        this.dialogKeyboardAutoPopup = dialogKeyboardAutoPopup;
    }

    boolean isShowFastScroller() {
        return this.showFastScroller;
    }

    public void setShowFastScroller(boolean showFastScroller) {
        this.showFastScroller = showFastScroller;
    }

    protected boolean isShowCloseIcon() {
        return this.showCloseIcon;
    }

    public void showCloseIcon(boolean showCloseIcon) {
        this.showCloseIcon = showCloseIcon;
    }

    EditText getEditText_registeredCarrierNumber() {
        return this.editText_registeredCarrierNumber;
    }

    void setEditText_registeredCarrierNumber(EditText editText_registeredCarrierNumber) {
        this.editText_registeredCarrierNumber = editText_registeredCarrierNumber;
        if (editText_registeredCarrierNumber.getHint() != null) {
            this.originalHint = this.editText_registeredCarrierNumber.getHint().toString();
        }
        updateValidityTextWatcher();
        updateFormattingTextWatcher();
        updateHint();
    }

    private void updateValidityTextWatcher() {
        try {
            this.editText_registeredCarrierNumber.removeTextChangedListener(this.validityTextWatcher);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        boolean zIsValidFullNumber = isValidFullNumber();
        this.reportedValidity = zIsValidFullNumber;
        PhoneNumberValidityChangeListener phoneNumberValidityChangeListener = this.phoneNumberValidityChangeListener;
        if (phoneNumberValidityChangeListener != null) {
            phoneNumberValidityChangeListener.onValidityChanged(zIsValidFullNumber);
        }
        TextWatcher textWatcher = new TextWatcher() { // from class: com.hbb20.CountryCodePicker.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                boolean zIsValidFullNumber2;
                if (CountryCodePicker.this.phoneNumberValidityChangeListener == null || (zIsValidFullNumber2 = CountryCodePicker.this.isValidFullNumber()) == CountryCodePicker.this.reportedValidity) {
                    return;
                }
                CountryCodePicker.this.reportedValidity = zIsValidFullNumber2;
                CountryCodePicker.this.phoneNumberValidityChangeListener.onValidityChanged(CountryCodePicker.this.reportedValidity);
            }
        };
        this.validityTextWatcher = textWatcher;
        this.editText_registeredCarrierNumber.addTextChangedListener(textWatcher);
    }

    private LayoutInflater getmInflater() {
        return this.mInflater;
    }

    private View.OnClickListener getCountryCodeHolderClickListener() {
        return this.countryCodeHolderClickListener;
    }

    int getDialogBackgroundColor() {
        return this.dialogBackgroundColor;
    }

    public void setDialogBackgroundColor(int dialogBackgroundColor) {
        this.dialogBackgroundColor = dialogBackgroundColor;
    }

    int getDialogBackgroundResId() {
        return this.dialogBackgroundResId;
    }

    public void setDialogBackground(int dialogBackgroundResId) {
        this.dialogBackgroundResId = dialogBackgroundResId;
    }

    int getDialogSearchEditTextTintColor() {
        return this.dialogSearchEditTextTintColor;
    }

    public void setDialogSearchEditTextTintColor(int dialogSearchEditTextTintColor) {
        this.dialogSearchEditTextTintColor = dialogSearchEditTextTintColor;
    }

    public float getDialogCornerRadius() {
        return this.dialogCornerRadius;
    }

    public void setDialogCornerRaius(float dialogCornerRadius) {
        this.dialogCornerRadius = dialogCornerRadius;
    }

    int getDialogTextColor() {
        return this.dialogTextColor;
    }

    public void setDialogTextColor(int dialogTextColor) {
        this.dialogTextColor = dialogTextColor;
    }

    int getDialogTypeFaceStyle() {
        return this.dialogTypeFaceStyle;
    }

    Typeface getDialogTypeFace() {
        return this.dialogTypeFace;
    }

    public void setDialogTypeFace(Typeface typeFace) {
        try {
            this.dialogTypeFace = typeFace;
            this.dialogTypeFaceStyle = DEFAULT_UNSET;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    void refreshPreferredCountries() {
        String str = this.countryPreference;
        if (str == null || str.length() == 0) {
            this.preferredCountries = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (String str2 : this.countryPreference.split(Constants.SEPARATOR_COMMA)) {
                CCPCountry countryForNameCodeFromCustomMasterList = CCPCountry.getCountryForNameCodeFromCustomMasterList(getContext(), this.customMasterCountriesList, getLanguageToApply(), str2);
                if (countryForNameCodeFromCustomMasterList != null && !isAlreadyInList(countryForNameCodeFromCustomMasterList, arrayList)) {
                    arrayList.add(countryForNameCodeFromCustomMasterList);
                }
            }
            if (arrayList.size() == 0) {
                this.preferredCountries = null;
            } else {
                this.preferredCountries = arrayList;
            }
        }
        List<CCPCountry> list = this.preferredCountries;
        if (list != null) {
            Iterator<CCPCountry> it = list.iterator();
            while (it.hasNext()) {
                it.next().log();
            }
        }
    }

    void refreshCustomMasterList() {
        String str = this.customMasterCountriesParam;
        if (str == null || str.length() == 0) {
            String str2 = this.excludedCountriesParam;
            if (str2 != null && str2.length() != 0) {
                this.excludedCountriesParam = this.excludedCountriesParam.toLowerCase();
                List<CCPCountry> libraryMasterCountryList = CCPCountry.getLibraryMasterCountryList(this.context, getLanguageToApply());
                ArrayList arrayList = new ArrayList();
                for (CCPCountry cCPCountry : libraryMasterCountryList) {
                    if (!this.excludedCountriesParam.contains(cCPCountry.getNameCode().toLowerCase())) {
                        arrayList.add(cCPCountry);
                    }
                }
                if (arrayList.size() > 0) {
                    this.customMasterCountriesList = arrayList;
                } else {
                    this.customMasterCountriesList = null;
                }
            } else {
                this.customMasterCountriesList = null;
            }
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (String str3 : this.customMasterCountriesParam.split(Constants.SEPARATOR_COMMA)) {
                CCPCountry countryForNameCodeFromLibraryMasterList = CCPCountry.getCountryForNameCodeFromLibraryMasterList(getContext(), getLanguageToApply(), str3);
                if (countryForNameCodeFromLibraryMasterList != null && !isAlreadyInList(countryForNameCodeFromLibraryMasterList, arrayList2)) {
                    arrayList2.add(countryForNameCodeFromLibraryMasterList);
                }
            }
            if (arrayList2.size() == 0) {
                this.customMasterCountriesList = null;
            } else {
                this.customMasterCountriesList = arrayList2;
            }
        }
        List<CCPCountry> list = this.customMasterCountriesList;
        if (list != null) {
            Iterator<CCPCountry> it = list.iterator();
            while (it.hasNext()) {
                it.next().log();
            }
        }
    }

    List<CCPCountry> getCustomMasterCountriesList() {
        return this.customMasterCountriesList;
    }

    void setCustomMasterCountriesList(List<CCPCountry> customMasterCountriesList) {
        this.customMasterCountriesList = customMasterCountriesList;
    }

    String getCustomMasterCountriesParam() {
        return this.customMasterCountriesParam;
    }

    public void setCustomMasterCountries(String customMasterCountriesParam) {
        this.customMasterCountriesParam = customMasterCountriesParam;
    }

    public void setExcludedCountries(String excludedCountries) {
        this.excludedCountriesParam = excludedCountries;
        refreshCustomMasterList();
    }

    boolean isCcpClickable() {
        return this.ccpClickable;
    }

    public void setCcpClickable(boolean ccpClickable) {
        this.ccpClickable = ccpClickable;
        if (!ccpClickable) {
            this.relativeClickConsumer.setOnClickListener(null);
            this.relativeClickConsumer.setClickable(false);
            this.relativeClickConsumer.setEnabled(false);
        } else {
            this.relativeClickConsumer.setOnClickListener(this.countryCodeHolderClickListener);
            this.relativeClickConsumer.setClickable(true);
            this.relativeClickConsumer.setEnabled(true);
        }
    }

    private boolean isAlreadyInList(CCPCountry CCPCountry, List<CCPCountry> CCPCountryList) {
        if (CCPCountry == null || CCPCountryList == null) {
            return false;
        }
        Iterator<CCPCountry> it = CCPCountryList.iterator();
        while (it.hasNext()) {
            if (it.next().getNameCode().equalsIgnoreCase(CCPCountry.getNameCode())) {
                return true;
            }
        }
        return false;
    }

    private String detectCarrierNumber(String fullNumber, CCPCountry CCPCountry) {
        int iIndexOf;
        return (CCPCountry == null || fullNumber == null || fullNumber.isEmpty() || (iIndexOf = fullNumber.indexOf(CCPCountry.getPhoneCode())) == -1) ? fullNumber : fullNumber.substring(iIndexOf + CCPCountry.getPhoneCode().length());
    }

    private Language getLanguageEnum(int index) {
        if (index < Language.values().length) {
            return Language.values()[index];
        }
        return Language.ENGLISH;
    }

    String getDialogTitle() {
        String dialogTitle = CCPCountry.getDialogTitle(this.context, getLanguageToApply());
        CustomDialogTextProvider customDialogTextProvider = this.customDialogTextProvider;
        return customDialogTextProvider != null ? customDialogTextProvider.getCCPDialogTitle(getLanguageToApply(), dialogTitle) : dialogTitle;
    }

    String getSearchHintText() {
        String searchHintMessage = CCPCountry.getSearchHintMessage(this.context, getLanguageToApply());
        CustomDialogTextProvider customDialogTextProvider = this.customDialogTextProvider;
        return customDialogTextProvider != null ? customDialogTextProvider.getCCPDialogSearchHintText(getLanguageToApply(), searchHintMessage) : searchHintMessage;
    }

    String getNoResultACK() {
        String noResultFoundAckMessage = CCPCountry.getNoResultFoundAckMessage(this.context, getLanguageToApply());
        CustomDialogTextProvider customDialogTextProvider = this.customDialogTextProvider;
        return customDialogTextProvider != null ? customDialogTextProvider.getCCPDialogNoResultACK(getLanguageToApply(), noResultFoundAckMessage) : noResultFoundAckMessage;
    }

    @Deprecated
    public void setDefaultCountryUsingPhoneCode(int defaultCountryCode) {
        CCPCountry countryForCode = CCPCountry.getCountryForCode(getContext(), getLanguageToApply(), this.preferredCountries, defaultCountryCode);
        if (countryForCode == null) {
            return;
        }
        this.defaultCountryCode = defaultCountryCode;
        setDefaultCountry(countryForCode);
    }

    public void setDefaultCountryUsingNameCode(String defaultCountryNameCode) {
        CCPCountry countryForNameCodeFromLibraryMasterList = CCPCountry.getCountryForNameCodeFromLibraryMasterList(getContext(), getLanguageToApply(), defaultCountryNameCode);
        if (countryForNameCodeFromLibraryMasterList == null) {
            return;
        }
        this.defaultCountryNameCode = countryForNameCodeFromLibraryMasterList.getNameCode();
        setDefaultCountry(countryForNameCodeFromLibraryMasterList);
    }

    public String getDefaultCountryCode() {
        return this.defaultCCPCountry.phoneCode;
    }

    public int getDefaultCountryCodeAsInt() {
        try {
            return Integer.parseInt(getDefaultCountryCode());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public String getDefaultCountryCodeWithPlus() {
        return MqttTopic.SINGLE_LEVEL_WILDCARD + getDefaultCountryCode();
    }

    public String getDefaultCountryName() {
        return getDefaultCountry().name;
    }

    public String getDefaultCountryNameCode() {
        return getDefaultCountry().nameCode.toUpperCase();
    }

    public void resetToDefaultCountry() {
        CCPCountry countryForNameCodeFromLibraryMasterList = CCPCountry.getCountryForNameCodeFromLibraryMasterList(getContext(), getLanguageToApply(), getDefaultCountryNameCode());
        this.defaultCCPCountry = countryForNameCodeFromLibraryMasterList;
        setSelectedCountry(countryForNameCodeFromLibraryMasterList);
    }

    public String getSelectedCountryCode() {
        return getSelectedCountry().phoneCode;
    }

    public String getSelectedCountryCodeWithPlus() {
        return MqttTopic.SINGLE_LEVEL_WILDCARD + getSelectedCountryCode();
    }

    public int getSelectedCountryCodeAsInt() {
        try {
            return Integer.parseInt(getSelectedCountryCode());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public String getSelectedCountryName() {
        return getSelectedCountry().name;
    }

    public String getSelectedCountryEnglishName() {
        return getSelectedCountry().getEnglishName();
    }

    public String getSelectedCountryNameCode() {
        return getSelectedCountry().nameCode.toUpperCase();
    }

    public int getSelectedCountryFlagResourceId() {
        return getSelectedCountry().flagResID;
    }

    public void setCountryForPhoneCode(int countryCode) {
        CCPCountry countryForCode = CCPCountry.getCountryForCode(getContext(), getLanguageToApply(), this.preferredCountries, countryCode);
        if (countryForCode == null) {
            if (this.defaultCCPCountry == null) {
                this.defaultCCPCountry = CCPCountry.getCountryForCode(getContext(), getLanguageToApply(), this.preferredCountries, this.defaultCountryCode);
            }
            setSelectedCountry(this.defaultCCPCountry);
            return;
        }
        setSelectedCountry(countryForCode);
    }

    public void setCountryForNameCode(String countryNameCode) {
        CCPCountry countryForNameCodeFromLibraryMasterList = CCPCountry.getCountryForNameCodeFromLibraryMasterList(getContext(), getLanguageToApply(), countryNameCode);
        if (countryForNameCodeFromLibraryMasterList == null) {
            if (this.defaultCCPCountry == null) {
                this.defaultCCPCountry = CCPCountry.getCountryForCode(getContext(), getLanguageToApply(), this.preferredCountries, this.defaultCountryCode);
            }
            setSelectedCountry(this.defaultCCPCountry);
            return;
        }
        setSelectedCountry(countryForNameCodeFromLibraryMasterList);
    }

    public void registerCarrierNumberEditText(EditText editTextCarrierNumber) {
        setEditText_registeredCarrierNumber(editTextCarrierNumber);
    }

    public void deregisterCarrierNumberEditText() {
        EditText editText = this.editText_registeredCarrierNumber;
        if (editText != null) {
            try {
                editText.removeTextChangedListener(this.validityTextWatcher);
            } catch (Exception unused) {
            }
            try {
                this.editText_registeredCarrierNumber.removeTextChangedListener(this.formattingTextWatcher);
            } catch (Exception unused2) {
            }
            this.editText_registeredCarrierNumber.setHint("");
            this.editText_registeredCarrierNumber = null;
        }
    }

    private Phonenumber.PhoneNumber getEnteredPhoneNumber() throws NumberParseException {
        String strNormalizeDigitsOnly;
        EditText editText = this.editText_registeredCarrierNumber;
        if (editText == null) {
            strNormalizeDigitsOnly = "";
        } else {
            strNormalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(editText.getText().toString());
        }
        return getPhoneUtil().parse(strNormalizeDigitsOnly, getSelectedCountryNameCode());
    }

    public String getFullNumber() {
        try {
            return getPhoneUtil().format(getEnteredPhoneNumber(), PhoneNumberUtil.PhoneNumberFormat.E164).substring(1);
        } catch (NumberParseException unused) {
            Log.e(TAG, "getFullNumber: Could not parse number");
            return getSelectedCountryCode() + PhoneNumberUtil.normalizeDigitsOnly(this.editText_registeredCarrierNumber.getText().toString());
        }
    }

    public void setFullNumber(String fullNumber) {
        CCPCountry countryForNumber = CCPCountry.getCountryForNumber(getContext(), getLanguageToApply(), this.preferredCountries, fullNumber);
        if (countryForNumber == null) {
            countryForNumber = getDefaultCountry();
        }
        setSelectedCountry(countryForNumber);
        String strDetectCarrierNumber = detectCarrierNumber(fullNumber, countryForNumber);
        if (getEditText_registeredCarrierNumber() != null) {
            getEditText_registeredCarrierNumber().setText(strDetectCarrierNumber);
            updateFormattingTextWatcher();
        } else {
            Log.w(TAG, "EditText for carrier number is not registered. Register it using registerCarrierNumberEditText() before getFullNumber() or setFullNumber().");
        }
    }

    public String getFormattedFullNumber() {
        try {
            return MqttTopic.SINGLE_LEVEL_WILDCARD + getPhoneUtil().format(getEnteredPhoneNumber(), PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL).substring(1);
        } catch (NumberParseException unused) {
            Log.e(TAG, "getFullNumber: Could not parse number");
            return getFullNumberWithPlus();
        }
    }

    public String getFullNumberWithPlus() {
        return MqttTopic.SINGLE_LEVEL_WILDCARD + getFullNumber();
    }

    public int getContentColor() {
        return this.contentColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
        this.textView_selectedCountry.setTextColor(contentColor);
        if (this.arrowColor == DEFAULT_UNSET) {
            this.imageViewArrow.setColorFilter(this.contentColor, PorterDuff.Mode.SRC_IN);
        }
    }

    public void setArrowColor(int arrowColor) {
        this.arrowColor = arrowColor;
        if (arrowColor == DEFAULT_UNSET) {
            int i = this.contentColor;
            if (i != DEFAULT_UNSET) {
                this.imageViewArrow.setColorFilter(i, PorterDuff.Mode.SRC_IN);
                return;
            }
            return;
        }
        this.imageViewArrow.setColorFilter(arrowColor, PorterDuff.Mode.SRC_IN);
    }

    public void setFlagBorderColor(int borderFlagColor) {
        this.borderFlagColor = borderFlagColor;
        this.linearFlagBorder.setBackgroundColor(borderFlagColor);
    }

    public void setTextSize(int textSize) {
        if (textSize > 0) {
            this.textView_selectedCountry.setTextSize(0, textSize);
            setArrowSize(textSize);
            setFlagSize(textSize);
        }
    }

    public void setArrowSize(int arrowSize) {
        if (arrowSize > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.imageViewArrow.getLayoutParams();
            layoutParams.width = arrowSize;
            layoutParams.height = arrowSize;
            this.imageViewArrow.setLayoutParams(layoutParams);
        }
    }

    public void showNameCode(boolean showNameCode) {
        this.showNameCode = showNameCode;
        setSelectedCountry(this.selectedCCPCountry);
    }

    public void showArrow(boolean showArrow) {
        this.showArrow = showArrow;
        refreshArrowViewVisibility();
    }

    public void setCountryPreference(String countryPreference) {
        this.countryPreference = countryPreference;
    }

    public void changeDefaultLanguage(Language language) {
        setCustomDefaultLanguage(language);
    }

    public void setTypeFace(Typeface typeFace) {
        try {
            this.textView_selectedCountry.setTypeface(typeFace);
            setDialogTypeFace(typeFace);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setDialogTypeFace(Typeface typeFace, int style) {
        try {
            this.dialogTypeFace = typeFace;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setTypeFace(Typeface typeFace, int style) {
        try {
            this.textView_selectedCountry.setTypeface(typeFace, style);
            setDialogTypeFace(typeFace, style);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setOnCountryChangeListener(OnCountryChangeListener onCountryChangeListener) {
        this.onCountryChangeListener = onCountryChangeListener;
    }

    public void setFlagSize(int flagSize) {
        this.imageViewFlag.getLayoutParams().height = flagSize;
        this.imageViewFlag.requestLayout();
    }

    public void showFlag(boolean showFlag) {
        this.showFlag = showFlag;
        refreshFlagVisibility();
        if (isInEditMode()) {
            return;
        }
        setSelectedCountry(this.selectedCCPCountry);
    }

    private void refreshFlagVisibility() {
        if (this.showFlag) {
            if (this.ccpUseEmoji) {
                this.linearFlagHolder.setVisibility(8);
                return;
            } else {
                this.linearFlagHolder.setVisibility(0);
                return;
            }
        }
        this.linearFlagHolder.setVisibility(8);
    }

    public void useFlagEmoji(boolean useFlagEmoji) {
        this.ccpUseEmoji = useFlagEmoji;
        refreshFlagVisibility();
        setSelectedCountry(this.selectedCCPCountry);
    }

    public void showFullName(boolean showFullName) {
        this.showFullName = showFullName;
        setSelectedCountry(this.selectedCCPCountry);
    }

    public boolean isSearchAllowed() {
        return this.searchAllowed;
    }

    public void setSearchAllowed(boolean searchAllowed) {
        this.searchAllowed = searchAllowed;
    }

    public void setPhoneNumberValidityChangeListener(PhoneNumberValidityChangeListener phoneNumberValidityChangeListener) {
        this.phoneNumberValidityChangeListener = phoneNumberValidityChangeListener;
        if (this.editText_registeredCarrierNumber == null || phoneNumberValidityChangeListener == null) {
            return;
        }
        boolean zIsValidFullNumber = isValidFullNumber();
        this.reportedValidity = zIsValidFullNumber;
        phoneNumberValidityChangeListener.onValidityChanged(zIsValidFullNumber);
    }

    public void setAutoDetectionFailureListener(FailureListener failureListener) {
        this.failureListener = failureListener;
    }

    public void setCustomDialogTextProvider(CustomDialogTextProvider customDialogTextProvider) {
        this.customDialogTextProvider = customDialogTextProvider;
    }

    public void launchCountrySelectionDialog() {
        launchCountrySelectionDialog(null);
    }

    public void launchCountrySelectionDialog(final String countryNameCode) {
        CountryCodeDialog.openCountryCodeDialog(this.codePicker, countryNameCode);
    }

    public boolean isValidFullNumber() {
        if (getEditText_registeredCarrierNumber() != null && getEditText_registeredCarrierNumber().getText().length() != 0) {
            return getPhoneUtil().isValidNumber(getPhoneUtil().parse(MqttTopic.SINGLE_LEVEL_WILDCARD + this.selectedCCPCountry.getPhoneCode() + getEditText_registeredCarrierNumber().getText().toString(), this.selectedCCPCountry.getNameCode()));
        }
        if (getEditText_registeredCarrierNumber() == null) {
            Toast.makeText(this.context, "No editText for Carrier number found.", 0).show();
        }
        return false;
    }

    private PhoneNumberUtil getPhoneUtil() {
        if (this.phoneUtil == null) {
            this.phoneUtil = PhoneNumberUtil.createInstance(this.context);
        }
        return this.phoneUtil;
    }

    public void setAutoDetectedCountry(boolean loadDefaultWhenFails) {
        boolean zDetectSIMCountry = false;
        for (int i = 0; i < this.selectedAutoDetectionPref.representation.length(); i++) {
            try {
                switch (this.selectedAutoDetectionPref.representation.charAt(i)) {
                    case '1':
                        zDetectSIMCountry = detectSIMCountry(false);
                        break;
                    case '2':
                        zDetectSIMCountry = detectNetworkCountry(false);
                        break;
                    case '3':
                        zDetectSIMCountry = detectLocaleCountry(false);
                        break;
                }
                if (zDetectSIMCountry) {
                    if (zDetectSIMCountry && loadDefaultWhenFails) {
                        resetToDefaultCountry();
                        return;
                    }
                }
                FailureListener failureListener = this.failureListener;
                if (failureListener != null) {
                    failureListener.onCountryAutoDetectionFailed();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.w(TAG, "setAutoDetectCountry: Exception" + e2.getMessage());
                if (loadDefaultWhenFails) {
                    resetToDefaultCountry();
                    return;
                }
                return;
            }
        }
        if (zDetectSIMCountry) {
        }
    }

    public boolean detectSIMCountry(boolean loadDefaultWhenFails) {
        try {
            String simCountryIso = ((TelephonyManager) this.context.getSystemService("phone")).getSimCountryIso();
            if (simCountryIso != null && !simCountryIso.isEmpty()) {
                setSelectedCountry(CCPCountry.getCountryForNameCodeFromLibraryMasterList(getContext(), getLanguageToApply(), simCountryIso));
                return true;
            }
            if (loadDefaultWhenFails) {
                resetToDefaultCountry();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (loadDefaultWhenFails) {
                resetToDefaultCountry();
            }
            return false;
        }
    }

    public boolean detectNetworkCountry(boolean loadDefaultWhenFails) {
        try {
            String networkCountryIso = ((TelephonyManager) this.context.getSystemService("phone")).getNetworkCountryIso();
            if (networkCountryIso != null && !networkCountryIso.isEmpty()) {
                setSelectedCountry(CCPCountry.getCountryForNameCodeFromLibraryMasterList(getContext(), getLanguageToApply(), networkCountryIso));
                return true;
            }
            if (loadDefaultWhenFails) {
                resetToDefaultCountry();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (loadDefaultWhenFails) {
                resetToDefaultCountry();
            }
            return false;
        }
    }

    public boolean detectLocaleCountry(boolean loadDefaultWhenFails) {
        try {
            String country = this.context.getResources().getConfiguration().locale.getCountry();
            if (country != null && !country.isEmpty()) {
                setSelectedCountry(CCPCountry.getCountryForNameCodeFromLibraryMasterList(getContext(), getLanguageToApply(), country));
                return true;
            }
            if (loadDefaultWhenFails) {
                resetToDefaultCountry();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (loadDefaultWhenFails) {
                resetToDefaultCountry();
            }
            return false;
        }
    }

    public void setCountryAutoDetectionPref(AutoDetectionPref selectedAutoDetectionPref) {
        this.selectedAutoDetectionPref = selectedAutoDetectionPref;
    }

    protected void onUserTappedCountry(CCPCountry CCPCountry) {
        CountryCodePicker countryCodePicker = this.codePicker;
        if (countryCodePicker.rememberLastSelection) {
            countryCodePicker.storeSelectedCountryNameCode(CCPCountry.getNameCode());
        }
        setSelectedCountry(CCPCountry);
    }

    public void setDetectCountryWithAreaCode(boolean detectCountryWithAreaCode) {
        this.detectCountryWithAreaCode = detectCountryWithAreaCode;
        updateFormattingTextWatcher();
    }

    public void setHintExampleNumberEnabled(boolean hintExampleNumberEnabled) {
        this.hintExampleNumberEnabled = hintExampleNumberEnabled;
        updateHint();
    }

    public void setHintExampleNumberType(PhoneNumberType hintExampleNumberType) {
        this.hintExampleNumberType = hintExampleNumberType;
        updateHint();
    }

    public boolean isDialogInitialScrollToSelectionEnabled() {
        return this.ccpDialogInitialScrollToSelection;
    }

    public void setTalkBackTextProvider(CCPTalkBackTextProvider talkBackTextProvider) {
        this.talkBackTextProvider = talkBackTextProvider;
        setSelectedCountry(this.selectedCCPCountry);
    }

    public void enableDialogInitialScrollToSelection(boolean initialScrollToSelection) {
        this.ccpDialogInitialScrollToSelection = this.ccpDialogInitialScrollToSelection;
    }

    public void overrideClickListener(View.OnClickListener clickListener) {
        this.customClickListener = clickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        CountryCodeDialog.clear();
        super.onDetachedFromWindow();
    }

    public enum Language {
        AFRIKAANS("af"),
        ARABIC("ar"),
        BENGALI("bn"),
        CHINESE_SIMPLIFIED("zh", "CN", "Hans"),
        CHINESE_TRADITIONAL("zh", "TW", "Hant"),
        CZECH(Constants.KEY_ENCRYPTION_INAPP_CS),
        DANISH(Const.CONTENT_daily_assign),
        DUTCH("nl"),
        ENGLISH(Const.ENGLISH),
        FARSI("fa"),
        FRENCH("fr"),
        GERMAN("de"),
        GREEK("el"),
        GUJARATI("gu"),
        HEBREW("iw"),
        HINDI(Const.HINDI),
        INDONESIA("in"),
        ITALIAN("it"),
        JAPANESE("ja"),
        KAZAKH("kk"),
        KOREAN("ko"),
        MARATHI("mr"),
        POLISH("pl"),
        PORTUGUESE(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT),
        PUNJABI("pa"),
        RUSSIAN("ru"),
        SLOVAK("sk"),
        SLOVENIAN("si"),
        SPANISH("es"),
        SWEDISH("sv"),
        TAGALOG("tl"),
        TURKISH("tr"),
        UKRAINIAN("uk"),
        URDU("ur"),
        UZBEK("uz"),
        VIETNAMESE("vi");

        private String code;
        private String country;
        private String script;

        Language(String code, String country, String script) {
            this.code = code;
            this.country = country;
            this.script = script;
        }

        Language(String code) {
            this.code = code;
        }

        public static Language forCountryNameCode(String code) {
            Language language = ENGLISH;
            for (Language language2 : values()) {
                if (language2.code.equals(code)) {
                    language = language2;
                }
            }
            return language;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCountry() {
            return this.country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getScript() {
            return this.script;
        }

        public void setScript(String script) {
            this.script = script;
        }
    }

    public enum AutoDetectionPref {
        SIM_ONLY("1"),
        NETWORK_ONLY("2"),
        LOCALE_ONLY("3"),
        SIM_NETWORK("12"),
        NETWORK_SIM("21"),
        SIM_LOCALE("13"),
        LOCALE_SIM(Constants.LEFT_NAV_KEY.Course_Chat),
        NETWORK_LOCALE("23"),
        LOCALE_NETWORK(Constants.LEFT_NAV_KEY.attendance_report),
        SIM_NETWORK_LOCALE("123"),
        SIM_LOCALE_NETWORK("132"),
        NETWORK_SIM_LOCALE("213"),
        NETWORK_LOCALE_SIM("231"),
        LOCALE_SIM_NETWORK("312"),
        LOCALE_NETWORK_SIM("321");

        String representation;

        AutoDetectionPref(String representation) {
            this.representation = representation;
        }

        public static AutoDetectionPref getPrefForValue(String value) {
            for (AutoDetectionPref autoDetectionPref : values()) {
                if (autoDetectionPref.representation.equals(value)) {
                    return autoDetectionPref;
                }
            }
            return SIM_NETWORK_LOCALE;
        }
    }

    public enum TextGravity {
        LEFT(-1),
        CENTER(0),
        RIGHT(1);

        int enumIndex;

        TextGravity(int i) {
            this.enumIndex = i;
        }
    }
}
