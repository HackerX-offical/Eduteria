package com.hbb20;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import io.michaelrocks.libphonenumber.android.AsYouTypeFormatter;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class InternationalPhoneTextWatcher implements TextWatcher {
    private static final String TAG = "Int'l Phone TextWatcher";
    private String countryNameCode;
    private int countryPhoneCode;
    private boolean internationalOnly;
    Editable lastFormatted;
    private AsYouTypeFormatter mFormatter;
    private boolean mSelfChange;
    private boolean mStopFormatting;
    private boolean needUpdateForCountryChange;
    PhoneNumberUtil phoneNumberUtil;

    public InternationalPhoneTextWatcher(Context context, String countryNameCode, int countryPhoneCode) {
        this(context, countryNameCode, countryPhoneCode, true);
    }

    public InternationalPhoneTextWatcher(Context context, String countryNameCode, int countryPhoneCode, boolean internationalOnly) {
        this.mSelfChange = false;
        this.lastFormatted = null;
        this.needUpdateForCountryChange = false;
        if (countryNameCode == null || countryNameCode.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.phoneNumberUtil = PhoneNumberUtil.createInstance(context);
        updateCountry(countryNameCode, countryPhoneCode);
        this.internationalOnly = internationalOnly;
    }

    public void updateCountry(String countryNameCode, int countryPhoneCode) {
        this.countryNameCode = countryNameCode;
        this.countryPhoneCode = countryPhoneCode;
        AsYouTypeFormatter asYouTypeFormatter = this.phoneNumberUtil.getAsYouTypeFormatter(countryNameCode);
        this.mFormatter = asYouTypeFormatter;
        asYouTypeFormatter.clear();
        Editable editable = this.lastFormatted;
        if (editable != null) {
            this.needUpdateForCountryChange = true;
            String strNormalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(editable);
            Editable editable2 = this.lastFormatted;
            editable2.replace(0, editable2.length(), strNormalizeDigitsOnly, 0, strNormalizeDigitsOnly.length());
            this.needUpdateForCountryChange = false;
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (this.mSelfChange || this.mStopFormatting || count <= 0 || !hasSeparator(s, start, count) || this.needUpdateForCountryChange) {
            return;
        }
        stopFormatting();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (this.mSelfChange || this.mStopFormatting || count <= 0 || !hasSeparator(s, start, count)) {
            return;
        }
        stopFormatting();
    }

    @Override // android.text.TextWatcher
    public synchronized void afterTextChanged(Editable s) {
        boolean z = true;
        if (this.mStopFormatting) {
            if (s.length() == 0) {
                z = false;
            }
            this.mStopFormatting = z;
            return;
        }
        if (this.mSelfChange) {
            return;
        }
        int selectionEnd = Selection.getSelectionEnd(s);
        boolean z2 = selectionEnd == s.length();
        String strReformat = reformat(s);
        if (!strReformat.equals(s.toString())) {
            if (z2) {
                selectionEnd = strReformat.length();
            } else {
                int i = 0;
                for (int i2 = 0; i2 < s.length() && i2 < selectionEnd; i2++) {
                    if (PhoneNumberUtils.isNonSeparator(s.charAt(i2))) {
                        i++;
                    }
                }
                selectionEnd = 0;
                int i3 = 0;
                while (true) {
                    if (selectionEnd >= strReformat.length()) {
                        selectionEnd = 0;
                        break;
                    } else {
                        if (i3 == i) {
                            break;
                        }
                        if (PhoneNumberUtils.isNonSeparator(strReformat.charAt(selectionEnd))) {
                            i3++;
                        }
                        selectionEnd++;
                    }
                }
            }
        }
        if (!z2) {
            while (true) {
                int i4 = selectionEnd - 1;
                if (i4 <= 0 || PhoneNumberUtils.isNonSeparator(strReformat.charAt(i4))) {
                    break;
                } else {
                    selectionEnd--;
                }
            }
        }
        if (strReformat != null) {
            try {
                this.mSelfChange = true;
                s.replace(0, s.length(), strReformat, 0, strReformat.length());
                this.mSelfChange = false;
                this.lastFormatted = s;
                Selection.setSelection(s, selectionEnd);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private String reformat(CharSequence s) {
        this.mFormatter.clear();
        String str = MqttTopic.SINGLE_LEVEL_WILDCARD + this.countryPhoneCode;
        if (this.internationalOnly || (s.length() > 0 && s.charAt(0) != '0')) {
            s = str + ((Object) s);
        }
        int length = s.length();
        char c2 = 0;
        String strInputDigit = "";
        for (int i = 0; i < length; i++) {
            char cCharAt = s.charAt(i);
            if (PhoneNumberUtils.isNonSeparator(cCharAt)) {
                if (c2 != 0) {
                    strInputDigit = this.mFormatter.inputDigit(c2);
                }
                c2 = cCharAt;
            }
        }
        if (c2 != 0) {
            strInputDigit = this.mFormatter.inputDigit(c2);
        }
        String strTrim = strInputDigit.trim();
        if (this.internationalOnly || s.length() == 0 || s.charAt(0) != '0') {
            if (strTrim.length() <= str.length()) {
                strTrim = "";
            } else if (strTrim.charAt(str.length()) == ' ') {
                strTrim = strTrim.substring(str.length() + 1);
            } else {
                strTrim = strTrim.substring(str.length());
            }
        }
        return TextUtils.isEmpty(strTrim) ? "" : strTrim;
    }

    private void stopFormatting() {
        this.mStopFormatting = true;
        this.mFormatter.clear();
    }

    private boolean hasSeparator(final CharSequence s, final int start, final int count) {
        for (int i = start; i < start + count; i++) {
            if (!PhoneNumberUtils.isNonSeparator(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
