package io.michaelrocks.libphonenumber.android;

import com.clevertap.android.sdk.Constants;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.michaelrocks.libphonenumber.android.Phonemetadata;
import io.michaelrocks.libphonenumber.android.Phonenumber;
import io.michaelrocks.libphonenumber.android.internal.RegexCache;
import java.lang.Character;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
final class PhoneNumberMatcher implements Iterator<PhoneNumberMatch> {
    private static final Pattern LEAD_CLASS;
    private static final Pattern PATTERN;
    private final PhoneNumberUtil.Leniency leniency;
    private long maxTries;
    private final PhoneNumberUtil phoneUtil;
    private final String preferredRegion;
    private final CharSequence text;
    private static final Pattern PUB_PAGES = Pattern.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");
    private static final Pattern SLASH_SEPARATED_DATES = Pattern.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");
    private static final Pattern TIME_STAMPS = Pattern.compile("[12]\\d{3}[-/]?[01]\\d[-/]?[0-3]\\d +[0-2]\\d$");
    private static final Pattern TIME_STAMPS_SUFFIX = Pattern.compile(":[0-5]\\d");
    private static final Pattern[] INNER_MATCHES = {Pattern.compile("/+(.*)"), Pattern.compile("(\\([^(]*)"), Pattern.compile("(?:\\p{Z}-|-\\p{Z})\\p{Z}*(.+)"), Pattern.compile("[‒-―－]\\p{Z}*(.+)"), Pattern.compile("\\.+\\p{Z}*([^.]+)"), Pattern.compile("\\p{Z}+(\\P{Z}+)")};
    private static final Pattern MATCHING_BRACKETS = Pattern.compile("(?:[(\\[（［])?(?:[^(\\[（［)\\]）］]+[)\\]）］])?[^(\\[（［)\\]）］]+(?:[(\\[（［][^(\\[（［)\\]）］]+[)\\]）］])" + limit(0, 3) + "[^(\\[（［)\\]）］]*");
    private State state = State.NOT_READY;
    private PhoneNumberMatch lastMatch = null;
    private int searchIndex = 0;
    private final RegexCache regexCache = new RegexCache(32);

    interface NumberGroupingChecker {
        boolean checkGroups(PhoneNumberUtil util, Phonenumber.PhoneNumber number, StringBuilder normalizedCandidate, String[] expectedNumberGroups);
    }

    private enum State {
        NOT_READY,
        READY,
        DONE
    }

    static {
        String strLimit = limit(0, 2);
        String strLimit2 = limit(0, 4);
        String strLimit3 = limit(0, 20);
        String str = "[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]" + strLimit2;
        String str2 = "\\p{Nd}" + limit(1, 20);
        LEAD_CLASS = Pattern.compile("[(\\[（［+＋]");
        PATTERN = Pattern.compile("(?:[(\\[（［+＋]" + str + ")" + strLimit + str2 + "(?:" + str + str2 + ")" + strLimit3 + "(?:" + PhoneNumberUtil.EXTN_PATTERNS_FOR_MATCHING + ")?", 66);
    }

    private static String limit(int lower, int upper) {
        if (lower < 0 || upper <= 0 || upper < lower) {
            throw new IllegalArgumentException();
        }
        return "{" + lower + Constants.SEPARATOR_COMMA + upper + "}";
    }

    PhoneNumberMatcher(PhoneNumberUtil util, String text, String country, PhoneNumberUtil.Leniency leniency, long maxTries) {
        if (util == null || leniency == null) {
            throw null;
        }
        if (maxTries < 0) {
            throw new IllegalArgumentException();
        }
        this.phoneUtil = util;
        this.text = text == null ? "" : text;
        this.preferredRegion = country;
        this.leniency = leniency;
        this.maxTries = maxTries;
    }

    private PhoneNumberMatch find(int index) {
        Matcher matcher = PATTERN.matcher(this.text);
        while (this.maxTries > 0 && matcher.find(index)) {
            int iStart = matcher.start();
            CharSequence charSequenceTrimAfterFirstMatch = trimAfterFirstMatch(PhoneNumberUtil.SECOND_NUMBER_START_PATTERN, this.text.subSequence(iStart, matcher.end()));
            PhoneNumberMatch phoneNumberMatchExtractMatch = extractMatch(charSequenceTrimAfterFirstMatch, iStart);
            if (phoneNumberMatchExtractMatch != null) {
                return phoneNumberMatchExtractMatch;
            }
            index = iStart + charSequenceTrimAfterFirstMatch.length();
            this.maxTries--;
        }
        return null;
    }

    private static CharSequence trimAfterFirstMatch(Pattern pattern, CharSequence candidate) {
        Matcher matcher = pattern.matcher(candidate);
        return matcher.find() ? candidate.subSequence(0, matcher.start()) : candidate;
    }

    static boolean isLatinLetter(char letter) {
        if (!Character.isLetter(letter) && Character.getType(letter) != 6) {
            return false;
        }
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(letter);
        return unicodeBlockOf.equals(Character.UnicodeBlock.BASIC_LATIN) || unicodeBlockOf.equals(Character.UnicodeBlock.LATIN_1_SUPPLEMENT) || unicodeBlockOf.equals(Character.UnicodeBlock.LATIN_EXTENDED_A) || unicodeBlockOf.equals(Character.UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) || unicodeBlockOf.equals(Character.UnicodeBlock.LATIN_EXTENDED_B) || unicodeBlockOf.equals(Character.UnicodeBlock.COMBINING_DIACRITICAL_MARKS);
    }

    private static boolean isInvalidPunctuationSymbol(char character) {
        return character == '%' || Character.getType(character) == 26;
    }

    private PhoneNumberMatch extractMatch(CharSequence candidate, int offset) {
        if (SLASH_SEPARATED_DATES.matcher(candidate).find()) {
            return null;
        }
        if (TIME_STAMPS.matcher(candidate).find()) {
            if (TIME_STAMPS_SUFFIX.matcher(this.text.toString().substring(candidate.length() + offset)).lookingAt()) {
                return null;
            }
        }
        PhoneNumberMatch andVerify = parseAndVerify(candidate, offset);
        return andVerify != null ? andVerify : extractInnerMatch(candidate, offset);
    }

    private PhoneNumberMatch extractInnerMatch(CharSequence candidate, int offset) {
        for (Pattern pattern : INNER_MATCHES) {
            Matcher matcher = pattern.matcher(candidate);
            boolean z = true;
            while (matcher.find() && this.maxTries > 0) {
                if (z) {
                    PhoneNumberMatch andVerify = parseAndVerify(trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, candidate.subSequence(0, matcher.start())), offset);
                    if (andVerify != null) {
                        return andVerify;
                    }
                    this.maxTries--;
                    z = false;
                }
                PhoneNumberMatch andVerify2 = parseAndVerify(trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, matcher.group(1)), matcher.start(1) + offset);
                if (andVerify2 != null) {
                    return andVerify2;
                }
                this.maxTries--;
            }
        }
        return null;
    }

    private PhoneNumberMatch parseAndVerify(CharSequence candidate, int offset) {
        try {
            if (MATCHING_BRACKETS.matcher(candidate).matches() && !PUB_PAGES.matcher(candidate).find()) {
                if (this.leniency.compareTo(PhoneNumberUtil.Leniency.VALID) >= 0) {
                    if (offset > 0 && !LEAD_CLASS.matcher(candidate).lookingAt()) {
                        char cCharAt = this.text.charAt(offset - 1);
                        if (isInvalidPunctuationSymbol(cCharAt) || isLatinLetter(cCharAt)) {
                            return null;
                        }
                    }
                    int length = candidate.length() + offset;
                    if (length < this.text.length()) {
                        char cCharAt2 = this.text.charAt(length);
                        if (isInvalidPunctuationSymbol(cCharAt2) || isLatinLetter(cCharAt2)) {
                            return null;
                        }
                    }
                }
                Phonenumber.PhoneNumber andKeepRawInput = this.phoneUtil.parseAndKeepRawInput(candidate, this.preferredRegion);
                if (this.leniency.verify(andKeepRawInput, candidate, this.phoneUtil, this)) {
                    andKeepRawInput.clearCountryCodeSource();
                    andKeepRawInput.clearRawInput();
                    andKeepRawInput.clearPreferredDomesticCarrierCode();
                    return new PhoneNumberMatch(offset, candidate.toString(), andKeepRawInput);
                }
            }
        } catch (NumberParseException unused) {
        }
        return null;
    }

    static boolean allNumberGroupsRemainGrouped(PhoneNumberUtil util, Phonenumber.PhoneNumber number, StringBuilder normalizedCandidate, String[] formattedNumberGroups) {
        int length;
        if (number.getCountryCodeSource() != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            String string = Integer.toString(number.getCountryCode());
            length = normalizedCandidate.indexOf(string) + string.length();
        } else {
            length = 0;
        }
        for (int i = 0; i < formattedNumberGroups.length; i++) {
            int iIndexOf = normalizedCandidate.indexOf(formattedNumberGroups[i], length);
            if (iIndexOf < 0) {
                return false;
            }
            length = iIndexOf + formattedNumberGroups[i].length();
            if (i == 0 && length < normalizedCandidate.length() && util.getNddPrefixForRegion(util.getRegionCodeForCountryCode(number.getCountryCode()), true) != null && Character.isDigit(normalizedCandidate.charAt(length))) {
                return normalizedCandidate.substring(length - formattedNumberGroups[i].length()).startsWith(util.getNationalSignificantNumber(number));
            }
        }
        return normalizedCandidate.substring(length).contains(number.getExtension());
    }

    static boolean allNumberGroupsAreExactlyPresent(PhoneNumberUtil util, Phonenumber.PhoneNumber number, StringBuilder normalizedCandidate, String[] formattedNumberGroups) {
        String[] strArrSplit = PhoneNumberUtil.NON_DIGITS_PATTERN.split(normalizedCandidate.toString());
        int length = number.hasExtension() ? strArrSplit.length - 2 : strArrSplit.length - 1;
        if (strArrSplit.length == 1 || strArrSplit[length].contains(util.getNationalSignificantNumber(number))) {
            return true;
        }
        int length2 = formattedNumberGroups.length - 1;
        while (length2 > 0 && length >= 0) {
            if (!strArrSplit[length].equals(formattedNumberGroups[length2])) {
                return false;
            }
            length2--;
            length--;
        }
        return length >= 0 && strArrSplit[length].endsWith(formattedNumberGroups[0]);
    }

    private static String[] getNationalNumberGroups(PhoneNumberUtil util, Phonenumber.PhoneNumber number) {
        String str = util.format(number, PhoneNumberUtil.PhoneNumberFormat.RFC3966);
        int iIndexOf = str.indexOf(59);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        return str.substring(str.indexOf(45) + 1, iIndexOf).split("-");
    }

    private static String[] getNationalNumberGroups(PhoneNumberUtil util, Phonenumber.PhoneNumber number, Phonemetadata.NumberFormat formattingPattern) {
        return util.formatNsnUsingPattern(util.getNationalSignificantNumber(number), formattingPattern, PhoneNumberUtil.PhoneNumberFormat.RFC3966).split("-");
    }

    boolean checkNumberGroupingIsValid(Phonenumber.PhoneNumber number, CharSequence candidate, PhoneNumberUtil util, NumberGroupingChecker checker) {
        StringBuilder sbNormalizeDigits = PhoneNumberUtil.normalizeDigits(candidate, true);
        if (checker.checkGroups(util, number, sbNormalizeDigits, getNationalNumberGroups(util, number))) {
            return true;
        }
        Phonemetadata.PhoneMetadata alternateFormatsForCountry = util.getMetadataSource().getAlternateFormatsForCountry(number.getCountryCode());
        String nationalSignificantNumber = util.getNationalSignificantNumber(number);
        if (alternateFormatsForCountry != null) {
            for (Phonemetadata.NumberFormat numberFormat : alternateFormatsForCountry.numberFormats()) {
                if (numberFormat.leadingDigitsPatternSize() <= 0 || this.regexCache.getPatternForRegex(numberFormat.getLeadingDigitsPattern(0)).matcher(nationalSignificantNumber).lookingAt()) {
                    if (checker.checkGroups(util, number, sbNormalizeDigits, getNationalNumberGroups(util, number, numberFormat))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean containsMoreThanOneSlashInNationalNumber(Phonenumber.PhoneNumber number, String candidate) {
        int iIndexOf;
        int iIndexOf2 = candidate.indexOf(47);
        if (iIndexOf2 < 0 || (iIndexOf = candidate.indexOf(47, iIndexOf2 + 1)) < 0) {
            return false;
        }
        if ((number.getCountryCodeSource() == Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN || number.getCountryCodeSource() == Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN) && PhoneNumberUtil.normalizeDigitsOnly(candidate.substring(0, iIndexOf2)).equals(Integer.toString(number.getCountryCode()))) {
            return candidate.substring(iIndexOf + 1).contains(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        }
        return true;
    }

    static boolean containsOnlyValidXChars(Phonenumber.PhoneNumber number, String candidate, PhoneNumberUtil util) {
        int i = 0;
        while (i < candidate.length() - 1) {
            char cCharAt = candidate.charAt(i);
            if (cCharAt == 'x' || cCharAt == 'X') {
                int i2 = i + 1;
                char cCharAt2 = candidate.charAt(i2);
                if (cCharAt2 == 'x' || cCharAt2 == 'X') {
                    if (util.isNumberMatch(number, candidate.substring(i2)) != PhoneNumberUtil.MatchType.NSN_MATCH) {
                        return false;
                    }
                    i = i2;
                } else if (!PhoneNumberUtil.normalizeDigitsOnly(candidate.substring(i)).equals(number.getExtension())) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    static boolean isNationalPrefixPresentIfRequired(Phonenumber.PhoneNumber number, PhoneNumberUtil util) {
        Phonemetadata.PhoneMetadata metadataForRegion;
        if (number.getCountryCodeSource() != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY || (metadataForRegion = util.getMetadataForRegion(util.getRegionCodeForCountryCode(number.getCountryCode()))) == null) {
            return true;
        }
        Phonemetadata.NumberFormat numberFormatChooseFormattingPatternForNumber = util.chooseFormattingPatternForNumber(metadataForRegion.numberFormats(), util.getNationalSignificantNumber(number));
        if (numberFormatChooseFormattingPatternForNumber == null || numberFormatChooseFormattingPatternForNumber.getNationalPrefixFormattingRule().length() <= 0 || numberFormatChooseFormattingPatternForNumber.getNationalPrefixOptionalWhenFormatting() || PhoneNumberUtil.formattingRuleHasFirstGroupOnly(numberFormatChooseFormattingPatternForNumber.getNationalPrefixFormattingRule())) {
            return true;
        }
        return util.maybeStripNationalPrefixAndCarrierCode(new StringBuilder(PhoneNumberUtil.normalizeDigitsOnly(number.getRawInput())), metadataForRegion, null);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.state == State.NOT_READY) {
            PhoneNumberMatch phoneNumberMatchFind = find(this.searchIndex);
            this.lastMatch = phoneNumberMatchFind;
            if (phoneNumberMatchFind == null) {
                this.state = State.DONE;
            } else {
                this.searchIndex = phoneNumberMatchFind.end();
                this.state = State.READY;
            }
        }
        return this.state == State.READY;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public PhoneNumberMatch next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        PhoneNumberMatch phoneNumberMatch = this.lastMatch;
        this.lastMatch = null;
        this.state = State.NOT_READY;
        return phoneNumberMatch;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
