package io.michaelrocks.libphonenumber.android;

import io.michaelrocks.libphonenumber.android.Phonemetadata;
import io.michaelrocks.libphonenumber.android.internal.RegexCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class AsYouTypeFormatter {
    private static final int MIN_LEADING_DIGITS_LENGTH = 3;
    private static final char SEPARATOR_BEFORE_NATIONAL_NUMBER = ' ';
    private Phonemetadata.PhoneMetadata currentMetadata;
    private String defaultCountry;
    private Phonemetadata.PhoneMetadata defaultMetadata;
    private final PhoneNumberUtil phoneUtil;
    private static final Phonemetadata.PhoneMetadata EMPTY_METADATA = new Phonemetadata.PhoneMetadata().setInternationalPrefix("NA");
    private static final Pattern ELIGIBLE_FORMAT_PATTERN = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]*(\\$\\d[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]*)+");
    private static final Pattern NATIONAL_PREFIX_SEPARATORS_PATTERN = Pattern.compile("[- ]");
    private static final String DIGIT_PLACEHOLDER = "\u2008";
    private static final Pattern DIGIT_PATTERN = Pattern.compile(DIGIT_PLACEHOLDER);
    private String currentOutput = "";
    private StringBuilder formattingTemplate = new StringBuilder();
    private String currentFormattingPattern = "";
    private StringBuilder accruedInput = new StringBuilder();
    private StringBuilder accruedInputWithoutFormatting = new StringBuilder();
    private boolean ableToFormat = true;
    private boolean inputHasFormatting = false;
    private boolean isCompleteNumber = false;
    private boolean isExpectingCountryCallingCode = false;
    private int lastMatchPosition = 0;
    private int originalPosition = 0;
    private int positionToRemember = 0;
    private StringBuilder prefixBeforeNationalNumber = new StringBuilder();
    private boolean shouldAddSpaceAfterNationalPrefix = false;
    private String extractedNationalPrefix = "";
    private StringBuilder nationalNumber = new StringBuilder();
    private List<Phonemetadata.NumberFormat> possibleFormats = new ArrayList();
    private RegexCache regexCache = new RegexCache(64);

    AsYouTypeFormatter(PhoneNumberUtil phoneUtil, String regionCode) {
        this.phoneUtil = phoneUtil;
        this.defaultCountry = regionCode;
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(regionCode);
        this.currentMetadata = metadataForRegion;
        this.defaultMetadata = metadataForRegion;
    }

    private Phonemetadata.PhoneMetadata getMetadataForRegion(String regionCode) {
        Phonemetadata.PhoneMetadata metadataForRegion = this.phoneUtil.getMetadataForRegion(this.phoneUtil.getRegionCodeForCountryCode(this.phoneUtil.getCountryCodeForRegion(regionCode)));
        return metadataForRegion != null ? metadataForRegion : EMPTY_METADATA;
    }

    private boolean maybeCreateNewTemplate() {
        Iterator<Phonemetadata.NumberFormat> it = this.possibleFormats.iterator();
        while (it.hasNext()) {
            Phonemetadata.NumberFormat next = it.next();
            String pattern = next.getPattern();
            if (this.currentFormattingPattern.equals(pattern)) {
                return false;
            }
            if (createFormattingTemplate(next)) {
                this.currentFormattingPattern = pattern;
                this.shouldAddSpaceAfterNationalPrefix = NATIONAL_PREFIX_SEPARATORS_PATTERN.matcher(next.getNationalPrefixFormattingRule()).find();
                this.lastMatchPosition = 0;
                return true;
            }
            it.remove();
        }
        this.ableToFormat = false;
        return false;
    }

    private void getAvailableFormats(String leadingDigits) {
        List<Phonemetadata.NumberFormat> listNumberFormats;
        if (this.isCompleteNumber && this.extractedNationalPrefix.length() == 0 && this.currentMetadata.intlNumberFormatSize() > 0) {
            listNumberFormats = this.currentMetadata.intlNumberFormats();
        } else {
            listNumberFormats = this.currentMetadata.numberFormats();
        }
        for (Phonemetadata.NumberFormat numberFormat : listNumberFormats) {
            if (this.extractedNationalPrefix.length() <= 0 || !PhoneNumberUtil.formattingRuleHasFirstGroupOnly(numberFormat.getNationalPrefixFormattingRule()) || numberFormat.getNationalPrefixOptionalWhenFormatting() || numberFormat.hasDomesticCarrierCodeFormattingRule()) {
                if (this.extractedNationalPrefix.length() != 0 || this.isCompleteNumber || PhoneNumberUtil.formattingRuleHasFirstGroupOnly(numberFormat.getNationalPrefixFormattingRule()) || numberFormat.getNationalPrefixOptionalWhenFormatting()) {
                    if (ELIGIBLE_FORMAT_PATTERN.matcher(numberFormat.getFormat()).matches()) {
                        this.possibleFormats.add(numberFormat);
                    }
                }
            }
        }
        narrowDownPossibleFormats(leadingDigits);
    }

    private void narrowDownPossibleFormats(String leadingDigits) {
        int length = leadingDigits.length() - 3;
        Iterator<Phonemetadata.NumberFormat> it = this.possibleFormats.iterator();
        while (it.hasNext()) {
            Phonemetadata.NumberFormat next = it.next();
            if (next.leadingDigitsPatternSize() != 0) {
                if (!this.regexCache.getPatternForRegex(next.getLeadingDigitsPattern(Math.min(length, next.leadingDigitsPatternSize() - 1))).matcher(leadingDigits).lookingAt()) {
                    it.remove();
                }
            }
        }
    }

    private boolean createFormattingTemplate(Phonemetadata.NumberFormat format) {
        String pattern = format.getPattern();
        this.formattingTemplate.setLength(0);
        String formattingTemplate = getFormattingTemplate(pattern, format.getFormat());
        if (formattingTemplate.length() <= 0) {
            return false;
        }
        this.formattingTemplate.append(formattingTemplate);
        return true;
    }

    private String getFormattingTemplate(String numberPattern, String numberFormat) {
        Matcher matcher = this.regexCache.getPatternForRegex(numberPattern).matcher("999999999999999");
        matcher.find();
        String strGroup = matcher.group();
        if (strGroup.length() < this.nationalNumber.length()) {
            return "";
        }
        return strGroup.replaceAll(numberPattern, numberFormat).replaceAll("9", DIGIT_PLACEHOLDER);
    }

    public void clear() {
        this.currentOutput = "";
        this.accruedInput.setLength(0);
        this.accruedInputWithoutFormatting.setLength(0);
        this.formattingTemplate.setLength(0);
        this.lastMatchPosition = 0;
        this.currentFormattingPattern = "";
        this.prefixBeforeNationalNumber.setLength(0);
        this.extractedNationalPrefix = "";
        this.nationalNumber.setLength(0);
        this.ableToFormat = true;
        this.inputHasFormatting = false;
        this.positionToRemember = 0;
        this.originalPosition = 0;
        this.isCompleteNumber = false;
        this.isExpectingCountryCallingCode = false;
        this.possibleFormats.clear();
        this.shouldAddSpaceAfterNationalPrefix = false;
        if (this.currentMetadata.equals(this.defaultMetadata)) {
            return;
        }
        this.currentMetadata = getMetadataForRegion(this.defaultCountry);
    }

    public String inputDigit(char nextChar) {
        String strInputDigitWithOptionToRememberPosition = inputDigitWithOptionToRememberPosition(nextChar, false);
        this.currentOutput = strInputDigitWithOptionToRememberPosition;
        return strInputDigitWithOptionToRememberPosition;
    }

    public String inputDigitAndRememberPosition(char nextChar) {
        String strInputDigitWithOptionToRememberPosition = inputDigitWithOptionToRememberPosition(nextChar, true);
        this.currentOutput = strInputDigitWithOptionToRememberPosition;
        return strInputDigitWithOptionToRememberPosition;
    }

    private String inputDigitWithOptionToRememberPosition(char nextChar, boolean rememberPosition) {
        this.accruedInput.append(nextChar);
        if (rememberPosition) {
            this.originalPosition = this.accruedInput.length();
        }
        if (!isDigitOrLeadingPlusSign(nextChar)) {
            this.ableToFormat = false;
            this.inputHasFormatting = true;
        } else {
            nextChar = normalizeAndAccrueDigitsAndPlusSign(nextChar, rememberPosition);
        }
        if (!this.ableToFormat) {
            if (this.inputHasFormatting) {
                return this.accruedInput.toString();
            }
            if (attemptToExtractIdd()) {
                if (attemptToExtractCountryCallingCode()) {
                    return attemptToChoosePatternWithPrefixExtracted();
                }
            } else if (ableToExtractLongerNdd()) {
                this.prefixBeforeNationalNumber.append(' ');
                return attemptToChoosePatternWithPrefixExtracted();
            }
            return this.accruedInput.toString();
        }
        int length = this.accruedInputWithoutFormatting.length();
        if (length == 0 || length == 1 || length == 2) {
            return this.accruedInput.toString();
        }
        if (length == 3) {
            if (attemptToExtractIdd()) {
                this.isExpectingCountryCallingCode = true;
            } else {
                this.extractedNationalPrefix = removeNationalPrefixFromNationalNumber();
                return attemptToChooseFormattingPattern();
            }
        }
        if (this.isExpectingCountryCallingCode) {
            if (attemptToExtractCountryCallingCode()) {
                this.isExpectingCountryCallingCode = false;
            }
            return ((Object) this.prefixBeforeNationalNumber) + this.nationalNumber.toString();
        }
        if (this.possibleFormats.size() > 0) {
            String strInputDigitHelper = inputDigitHelper(nextChar);
            String strAttemptToFormatAccruedDigits = attemptToFormatAccruedDigits();
            if (strAttemptToFormatAccruedDigits.length() > 0) {
                return strAttemptToFormatAccruedDigits;
            }
            narrowDownPossibleFormats(this.nationalNumber.toString());
            if (maybeCreateNewTemplate()) {
                return inputAccruedNationalNumber();
            }
            if (this.ableToFormat) {
                return appendNationalNumber(strInputDigitHelper);
            }
            return this.accruedInput.toString();
        }
        return attemptToChooseFormattingPattern();
    }

    private String attemptToChoosePatternWithPrefixExtracted() {
        this.ableToFormat = true;
        this.isExpectingCountryCallingCode = false;
        this.possibleFormats.clear();
        this.lastMatchPosition = 0;
        this.formattingTemplate.setLength(0);
        this.currentFormattingPattern = "";
        return attemptToChooseFormattingPattern();
    }

    String getExtractedNationalPrefix() {
        return this.extractedNationalPrefix;
    }

    private boolean ableToExtractLongerNdd() {
        if (this.extractedNationalPrefix.length() > 0) {
            this.nationalNumber.insert(0, this.extractedNationalPrefix);
            this.prefixBeforeNationalNumber.setLength(this.prefixBeforeNationalNumber.lastIndexOf(this.extractedNationalPrefix));
        }
        return !this.extractedNationalPrefix.equals(removeNationalPrefixFromNationalNumber());
    }

    private boolean isDigitOrLeadingPlusSign(char nextChar) {
        return Character.isDigit(nextChar) || (this.accruedInput.length() == 1 && PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(Character.toString(nextChar)).matches());
    }

    String attemptToFormatAccruedDigits() {
        for (Phonemetadata.NumberFormat numberFormat : this.possibleFormats) {
            Matcher matcher = this.regexCache.getPatternForRegex(numberFormat.getPattern()).matcher(this.nationalNumber);
            if (matcher.matches()) {
                this.shouldAddSpaceAfterNationalPrefix = NATIONAL_PREFIX_SEPARATORS_PATTERN.matcher(numberFormat.getNationalPrefixFormattingRule()).find();
                String strAppendNationalNumber = appendNationalNumber(matcher.replaceAll(numberFormat.getFormat()));
                if (PhoneNumberUtil.normalizeDiallableCharsOnly(strAppendNationalNumber).contentEquals(this.accruedInputWithoutFormatting)) {
                    return strAppendNationalNumber;
                }
            }
        }
        return "";
    }

    public int getRememberedPosition() {
        if (!this.ableToFormat) {
            return this.originalPosition;
        }
        int i = 0;
        int i2 = 0;
        while (i < this.positionToRemember && i2 < this.currentOutput.length()) {
            if (this.accruedInputWithoutFormatting.charAt(i) == this.currentOutput.charAt(i2)) {
                i++;
            }
            i2++;
        }
        return i2;
    }

    private String appendNationalNumber(String nationalNumber) {
        int length = this.prefixBeforeNationalNumber.length();
        if (this.shouldAddSpaceAfterNationalPrefix && length > 0 && this.prefixBeforeNationalNumber.charAt(length - 1) != ' ') {
            return new String(this.prefixBeforeNationalNumber) + ' ' + nationalNumber;
        }
        return ((Object) this.prefixBeforeNationalNumber) + nationalNumber;
    }

    private String attemptToChooseFormattingPattern() {
        if (this.nationalNumber.length() >= 3) {
            getAvailableFormats(this.nationalNumber.toString());
            String strAttemptToFormatAccruedDigits = attemptToFormatAccruedDigits();
            return strAttemptToFormatAccruedDigits.length() > 0 ? strAttemptToFormatAccruedDigits : maybeCreateNewTemplate() ? inputAccruedNationalNumber() : this.accruedInput.toString();
        }
        return appendNationalNumber(this.nationalNumber.toString());
    }

    private String inputAccruedNationalNumber() {
        int length = this.nationalNumber.length();
        if (length > 0) {
            String strInputDigitHelper = "";
            for (int i = 0; i < length; i++) {
                strInputDigitHelper = inputDigitHelper(this.nationalNumber.charAt(i));
            }
            return this.ableToFormat ? appendNationalNumber(strInputDigitHelper) : this.accruedInput.toString();
        }
        return this.prefixBeforeNationalNumber.toString();
    }

    private boolean isNanpaNumberWithNationalPrefix() {
        return this.currentMetadata.getCountryCode() == 1 && this.nationalNumber.charAt(0) == '1' && this.nationalNumber.charAt(1) != '0' && this.nationalNumber.charAt(1) != '1';
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String removeNationalPrefixFromNationalNumber() {
        /*
            r4 = this;
            boolean r0 = r4.isNanpaNumberWithNationalPrefix()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L18
            java.lang.StringBuilder r0 = r4.prefixBeforeNationalNumber
            r3 = 49
            java.lang.StringBuilder r0 = r0.append(r3)
            r3 = 32
            r0.append(r3)
            r4.isCompleteNumber = r1
            goto L51
        L18:
            io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneMetadata r0 = r4.currentMetadata
            boolean r0 = r0.hasNationalPrefixForParsing()
            if (r0 == 0) goto L50
            io.michaelrocks.libphonenumber.android.internal.RegexCache r0 = r4.regexCache
            io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneMetadata r3 = r4.currentMetadata
            java.lang.String r3 = r3.getNationalPrefixForParsing()
            java.util.regex.Pattern r0 = r0.getPatternForRegex(r3)
            java.lang.StringBuilder r3 = r4.nationalNumber
            java.util.regex.Matcher r0 = r0.matcher(r3)
            boolean r3 = r0.lookingAt()
            if (r3 == 0) goto L50
            int r3 = r0.end()
            if (r3 <= 0) goto L50
            r4.isCompleteNumber = r1
            int r1 = r0.end()
            java.lang.StringBuilder r0 = r4.prefixBeforeNationalNumber
            java.lang.StringBuilder r3 = r4.nationalNumber
            java.lang.String r3 = r3.substring(r2, r1)
            r0.append(r3)
            goto L51
        L50:
            r1 = r2
        L51:
            java.lang.StringBuilder r0 = r4.nationalNumber
            java.lang.String r0 = r0.substring(r2, r1)
            java.lang.StringBuilder r3 = r4.nationalNumber
            r3.delete(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.michaelrocks.libphonenumber.android.AsYouTypeFormatter.removeNationalPrefixFromNationalNumber():java.lang.String");
    }

    private boolean attemptToExtractIdd() {
        Matcher matcher = this.regexCache.getPatternForRegex("\\+|" + this.currentMetadata.getInternationalPrefix()).matcher(this.accruedInputWithoutFormatting);
        if (!matcher.lookingAt()) {
            return false;
        }
        this.isCompleteNumber = true;
        int iEnd = matcher.end();
        this.nationalNumber.setLength(0);
        this.nationalNumber.append(this.accruedInputWithoutFormatting.substring(iEnd));
        this.prefixBeforeNationalNumber.setLength(0);
        this.prefixBeforeNationalNumber.append(this.accruedInputWithoutFormatting.substring(0, iEnd));
        if (this.accruedInputWithoutFormatting.charAt(0) != '+') {
            this.prefixBeforeNationalNumber.append(' ');
        }
        return true;
    }

    private boolean attemptToExtractCountryCallingCode() {
        StringBuilder sb;
        int iExtractCountryCode;
        if (this.nationalNumber.length() == 0 || (iExtractCountryCode = this.phoneUtil.extractCountryCode(this.nationalNumber, (sb = new StringBuilder()))) == 0) {
            return false;
        }
        this.nationalNumber.setLength(0);
        this.nationalNumber.append((CharSequence) sb);
        String regionCodeForCountryCode = this.phoneUtil.getRegionCodeForCountryCode(iExtractCountryCode);
        if (PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY.equals(regionCodeForCountryCode)) {
            this.currentMetadata = this.phoneUtil.getMetadataForNonGeographicalRegion(iExtractCountryCode);
        } else if (!regionCodeForCountryCode.equals(this.defaultCountry)) {
            this.currentMetadata = getMetadataForRegion(regionCodeForCountryCode);
        }
        this.prefixBeforeNationalNumber.append(Integer.toString(iExtractCountryCode)).append(' ');
        this.extractedNationalPrefix = "";
        return true;
    }

    private char normalizeAndAccrueDigitsAndPlusSign(char nextChar, boolean rememberPosition) {
        if (nextChar == '+') {
            this.accruedInputWithoutFormatting.append(nextChar);
        } else {
            nextChar = Character.forDigit(Character.digit(nextChar, 10), 10);
            this.accruedInputWithoutFormatting.append(nextChar);
            this.nationalNumber.append(nextChar);
        }
        if (rememberPosition) {
            this.positionToRemember = this.accruedInputWithoutFormatting.length();
        }
        return nextChar;
    }

    private String inputDigitHelper(char nextChar) {
        Matcher matcher = DIGIT_PATTERN.matcher(this.formattingTemplate);
        if (matcher.find(this.lastMatchPosition)) {
            String strReplaceFirst = matcher.replaceFirst(Character.toString(nextChar));
            this.formattingTemplate.replace(0, strReplaceFirst.length(), strReplaceFirst);
            int iStart = matcher.start();
            this.lastMatchPosition = iStart;
            return this.formattingTemplate.substring(0, iStart + 1);
        }
        if (this.possibleFormats.size() == 1) {
            this.ableToFormat = false;
        }
        this.currentFormattingPattern = "";
        return this.accruedInput.toString();
    }
}
