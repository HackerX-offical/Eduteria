package io.michaelrocks.libphonenumber.android;

import android.content.Context;
import com.amazonaws.services.s3.internal.Constants;
import com.csvreader.CsvReader;
import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberMatcher;
import io.michaelrocks.libphonenumber.android.Phonemetadata;
import io.michaelrocks.libphonenumber.android.Phonenumber;
import io.michaelrocks.libphonenumber.android.internal.MatcherApi;
import io.michaelrocks.libphonenumber.android.internal.RegexBasedMatcher;
import io.michaelrocks.libphonenumber.android.internal.RegexCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class PhoneNumberUtil {
    private static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    private static final Map<Character, Character> ALPHA_MAPPINGS;
    private static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    private static final Pattern CAPTURING_DIGIT_PATTERN;
    private static final String CAPTURING_EXTN_DIGITS = "(\\p{Nd}{1,7})";
    private static final String CC_STRING = "$CC";
    private static final String COLOMBIA_MOBILE_TO_FIXED_LINE_PREFIX = "3";
    private static final String DEFAULT_EXTN_PREFIX = " ext. ";
    private static final Map<Character, Character> DIALLABLE_CHAR_MAPPINGS;
    private static final String DIGITS = "\\p{Nd}";
    private static final Pattern EXTN_PATTERN;
    static final String EXTN_PATTERNS_FOR_MATCHING;
    private static final String EXTN_PATTERNS_FOR_PARSING;
    private static final String FG_STRING = "$FG";
    private static final Pattern FIRST_GROUP_ONLY_PREFIX_PATTERN;
    private static final Pattern FIRST_GROUP_PATTERN;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES;
    private static final int MAX_INPUT_STRING_LENGTH = 250;
    static final int MAX_LENGTH_COUNTRY_CODE = 3;
    static final int MAX_LENGTH_FOR_NSN = 17;
    private static final int MIN_LENGTH_FOR_NSN = 2;
    private static final Map<Integer, String> MOBILE_TOKEN_MAPPINGS;
    private static final int NANPA_COUNTRY_CODE = 1;
    static final Pattern NON_DIGITS_PATTERN;
    private static final String NP_STRING = "$NP";
    static final String PLUS_CHARS = "+＋";
    static final Pattern PLUS_CHARS_PATTERN;
    static final char PLUS_SIGN = '+';
    static final int REGEX_FLAGS = 66;
    public static final String REGION_CODE_FOR_NON_GEO_ENTITY = "001";
    private static final String RFC3966_EXTN_PREFIX = ";ext=";
    private static final String RFC3966_ISDN_SUBADDRESS = ";isub=";
    private static final String RFC3966_PHONE_CONTEXT = ";phone-context=";
    private static final String RFC3966_PREFIX = "tel:";
    private static final String SECOND_NUMBER_START = "[\\\\/] *x";
    static final Pattern SECOND_NUMBER_START_PATTERN;
    private static final Pattern SEPARATOR_PATTERN;
    private static final Pattern SINGLE_INTERNATIONAL_PREFIX;
    private static final char STAR_SIGN = '*';
    private static final String UNKNOWN_REGION = "ZZ";
    private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
    static final Pattern UNWANTED_END_CHAR_PATTERN;
    private static final String VALID_ALPHA;
    private static final Pattern VALID_ALPHA_PHONE_PATTERN;
    private static final String VALID_PHONE_NUMBER;
    private static final Pattern VALID_PHONE_NUMBER_PATTERN;
    static final String VALID_PUNCTUATION = "-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～";
    private static final String VALID_START_CHAR = "[+＋\\p{Nd}]";
    private static final Pattern VALID_START_CHAR_PATTERN;
    private static final Logger logger = Logger.getLogger(PhoneNumberUtil.class.getName());
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    private final MetadataSource metadataSource;
    private volatile ShortNumberInfo shortNumberInfo;
    private final MatcherApi matcherApi = RegexBasedMatcher.create();
    private final Set<String> nanpaRegions = new HashSet(35);
    private final RegexCache regexCache = new RegexCache(100);
    private final Set<String> supportedRegions = new HashSet(320);
    private final Set<Integer> countryCodesForNonGeographicalRegion = new HashSet();

    public enum Leniency {
        POSSIBLE { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.1
            @Override // io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency
            boolean verify(Phonenumber.PhoneNumber number, CharSequence candidate, PhoneNumberUtil util, PhoneNumberMatcher matcher) {
                return util.isPossibleNumber(number);
            }
        },
        VALID { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.2
            @Override // io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency
            boolean verify(Phonenumber.PhoneNumber number, CharSequence candidate, PhoneNumberUtil util, PhoneNumberMatcher matcher) {
                if (util.isValidNumber(number) && PhoneNumberMatcher.containsOnlyValidXChars(number, candidate.toString(), util)) {
                    return PhoneNumberMatcher.isNationalPrefixPresentIfRequired(number, util);
                }
                return false;
            }
        },
        STRICT_GROUPING { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.3
            @Override // io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency
            boolean verify(Phonenumber.PhoneNumber number, CharSequence candidate, PhoneNumberUtil util, PhoneNumberMatcher matcher) {
                String string = candidate.toString();
                if (util.isValidNumber(number) && PhoneNumberMatcher.containsOnlyValidXChars(number, string, util) && !PhoneNumberMatcher.containsMoreThanOneSlashInNationalNumber(number, string) && PhoneNumberMatcher.isNationalPrefixPresentIfRequired(number, util)) {
                    return matcher.checkNumberGroupingIsValid(number, candidate, util, new PhoneNumberMatcher.NumberGroupingChecker() { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.3.1
                        @Override // io.michaelrocks.libphonenumber.android.PhoneNumberMatcher.NumberGroupingChecker
                        public boolean checkGroups(PhoneNumberUtil util2, Phonenumber.PhoneNumber number2, StringBuilder normalizedCandidate, String[] expectedNumberGroups) {
                            return PhoneNumberMatcher.allNumberGroupsRemainGrouped(util2, number2, normalizedCandidate, expectedNumberGroups);
                        }
                    });
                }
                return false;
            }
        },
        EXACT_GROUPING { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.4
            @Override // io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency
            boolean verify(Phonenumber.PhoneNumber number, CharSequence candidate, PhoneNumberUtil util, PhoneNumberMatcher matcher) {
                String string = candidate.toString();
                if (util.isValidNumber(number) && PhoneNumberMatcher.containsOnlyValidXChars(number, string, util) && !PhoneNumberMatcher.containsMoreThanOneSlashInNationalNumber(number, string) && PhoneNumberMatcher.isNationalPrefixPresentIfRequired(number, util)) {
                    return matcher.checkNumberGroupingIsValid(number, candidate, util, new PhoneNumberMatcher.NumberGroupingChecker() { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.4.1
                        @Override // io.michaelrocks.libphonenumber.android.PhoneNumberMatcher.NumberGroupingChecker
                        public boolean checkGroups(PhoneNumberUtil util2, Phonenumber.PhoneNumber number2, StringBuilder normalizedCandidate, String[] expectedNumberGroups) {
                            return PhoneNumberMatcher.allNumberGroupsAreExactlyPresent(util2, number2, normalizedCandidate, expectedNumberGroups);
                        }
                    });
                }
                return false;
            }
        };

        abstract boolean verify(Phonenumber.PhoneNumber number, CharSequence candidate, PhoneNumberUtil util, PhoneNumberMatcher matcher);
    }

    public enum MatchType {
        NOT_A_NUMBER,
        NO_MATCH,
        SHORT_NSN_MATCH,
        NSN_MATCH,
        EXACT_MATCH
    }

    public enum PhoneNumberFormat {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    public enum PhoneNumberType {
        FIXED_LINE,
        MOBILE,
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

    public enum ValidationResult {
        IS_POSSIBLE,
        IS_POSSIBLE_LOCAL_ONLY,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        INVALID_LENGTH,
        TOO_LONG
    }

    static {
        HashMap map = new HashMap();
        map.put(54, "9");
        MOBILE_TOKEN_MAPPINGS = Collections.unmodifiableMap(map);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        hashSet2.add(54);
        hashSet2.add(55);
        hashSet2.add(62);
        hashSet2.addAll(hashSet);
        GEO_MOBILE_COUNTRIES = Collections.unmodifiableSet(hashSet2);
        HashMap map2 = new HashMap();
        map2.put('0', '0');
        map2.put('1', '1');
        map2.put('2', '2');
        map2.put('3', '3');
        map2.put('4', '4');
        map2.put('5', '5');
        map2.put('6', '6');
        map2.put('7', '7');
        map2.put('8', '8');
        map2.put('9', '9');
        HashMap map3 = new HashMap(40);
        map3.put('A', '2');
        map3.put('B', '2');
        map3.put('C', '2');
        map3.put('D', '3');
        map3.put('E', '3');
        map3.put('F', '3');
        map3.put('G', '4');
        map3.put('H', '4');
        map3.put('I', '4');
        map3.put('J', '5');
        map3.put('K', '5');
        map3.put(Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_LT), '5');
        map3.put('M', '6');
        map3.put('N', '6');
        map3.put('O', '6');
        map3.put('P', '7');
        map3.put('Q', '7');
        map3.put(Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_REGULAR), '7');
        map3.put('S', '7');
        map3.put('T', '8');
        map3.put(Character.valueOf(Matrix.MATRIX_TYPE_RANDOM_UT), '8');
        map3.put('V', '8');
        map3.put('W', '9');
        map3.put('X', '9');
        map3.put('Y', '9');
        map3.put(Character.valueOf(Matrix.MATRIX_TYPE_ZERO), '9');
        Map<Character, Character> mapUnmodifiableMap = Collections.unmodifiableMap(map3);
        ALPHA_MAPPINGS = mapUnmodifiableMap;
        HashMap map4 = new HashMap(100);
        map4.putAll(mapUnmodifiableMap);
        map4.putAll(map2);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(map4);
        HashMap map5 = new HashMap();
        map5.putAll(map2);
        Character chValueOf = Character.valueOf(PLUS_SIGN);
        map5.put(chValueOf, chValueOf);
        Character chValueOf2 = Character.valueOf(STAR_SIGN);
        map5.put(chValueOf2, chValueOf2);
        Character chValueOf3 = Character.valueOf(CsvReader.Letters.POUND);
        map5.put(chValueOf3, chValueOf3);
        DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap(map5);
        HashMap map6 = new HashMap();
        Iterator<Character> it = mapUnmodifiableMap.keySet().iterator();
        while (it.hasNext()) {
            char cCharValue = it.next().charValue();
            map6.put(Character.valueOf(Character.toLowerCase(cCharValue)), Character.valueOf(cCharValue));
            map6.put(Character.valueOf(cCharValue), Character.valueOf(cCharValue));
        }
        map6.putAll(map2);
        map6.put('-', '-');
        map6.put((char) 65293, '-');
        map6.put((char) 8208, '-');
        map6.put((char) 8209, '-');
        map6.put((char) 8210, '-');
        map6.put(Character.valueOf(Typography.ndash), '-');
        map6.put(Character.valueOf(Typography.mdash), '-');
        map6.put((char) 8213, '-');
        map6.put((char) 8722, '-');
        map6.put('/', '/');
        map6.put((char) 65295, '/');
        map6.put(' ', ' ');
        map6.put((char) 12288, ' ');
        map6.put((char) 8288, ' ');
        map6.put('.', '.');
        map6.put((char) 65294, '.');
        ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap(map6);
        SINGLE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map7 = ALPHA_MAPPINGS;
        String string = sb.append(Arrays.toString(map7.keySet().toArray()).replaceAll("[, \\[\\]]", "")).append(Arrays.toString(map7.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", "")).toString();
        VALID_ALPHA = string;
        PLUS_CHARS_PATTERN = Pattern.compile("[+＋]+");
        SEPARATOR_PATTERN = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
        VALID_START_CHAR_PATTERN = Pattern.compile(VALID_START_CHAR);
        SECOND_NUMBER_START_PATTERN = Pattern.compile(SECOND_NUMBER_START);
        UNWANTED_END_CHAR_PATTERN = Pattern.compile(UNWANTED_END_CHARS);
        VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        String str = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + string + "\\p{Nd}]*";
        VALID_PHONE_NUMBER = str;
        String strCreateExtnPattern = createExtnPattern(",;xｘ#＃~～");
        EXTN_PATTERNS_FOR_PARSING = strCreateExtnPattern;
        EXTN_PATTERNS_FOR_MATCHING = createExtnPattern("xｘ#＃~～");
        EXTN_PATTERN = Pattern.compile("(?:" + strCreateExtnPattern + ")$", 66);
        VALID_PHONE_NUMBER_PATTERN = Pattern.compile(str + "(?:" + strCreateExtnPattern + ")?", 66);
        NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
        FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
        FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile("\\(?\\$1\\)?");
    }

    private static String createExtnPattern(String singleExtnSymbols) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|[" + singleExtnSymbols + "]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*(\\p{Nd}{1,7})#?|[- ]+(\\p{Nd}{1,5})#";
    }

    PhoneNumberUtil(MetadataSource metadataSource, Map<Integer, List<String>> countryCallingCodeToRegionCodeMap) {
        this.metadataSource = metadataSource;
        this.countryCallingCodeToRegionCodeMap = countryCallingCodeToRegionCodeMap;
        for (Map.Entry<Integer, List<String>> entry : countryCallingCodeToRegionCodeMap.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() == 1 && REGION_CODE_FOR_NON_GEO_ENTITY.equals(value.get(0))) {
                this.countryCodesForNonGeographicalRegion.add(entry.getKey());
            } else {
                this.supportedRegions.addAll(value);
            }
        }
        if (this.supportedRegions.remove(REGION_CODE_FOR_NON_GEO_ENTITY)) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.nanpaRegions.addAll(countryCallingCodeToRegionCodeMap.get(1));
    }

    MetadataSource getMetadataSource() {
        return this.metadataSource;
    }

    public ShortNumberInfo getShortNumberInfo() {
        if (this.shortNumberInfo == null) {
            synchronized (this) {
                if (this.shortNumberInfo == null) {
                    this.shortNumberInfo = new ShortNumberInfo(this.metadataSource, RegexBasedMatcher.create());
                }
            }
        }
        return this.shortNumberInfo;
    }

    static CharSequence extractPossibleNumber(CharSequence number) {
        Matcher matcher = VALID_START_CHAR_PATTERN.matcher(number);
        if (matcher.find()) {
            CharSequence charSequenceSubSequence = number.subSequence(matcher.start(), number.length());
            Matcher matcher2 = UNWANTED_END_CHAR_PATTERN.matcher(charSequenceSubSequence);
            if (matcher2.find()) {
                charSequenceSubSequence = charSequenceSubSequence.subSequence(0, matcher2.start());
            }
            Matcher matcher3 = SECOND_NUMBER_START_PATTERN.matcher(charSequenceSubSequence);
            return matcher3.find() ? charSequenceSubSequence.subSequence(0, matcher3.start()) : charSequenceSubSequence;
        }
        return "";
    }

    static boolean isViablePhoneNumber(CharSequence number) {
        if (number.length() < 2) {
            return false;
        }
        return VALID_PHONE_NUMBER_PATTERN.matcher(number).matches();
    }

    static StringBuilder normalize(StringBuilder number) {
        if (VALID_ALPHA_PHONE_PATTERN.matcher(number).matches()) {
            number.replace(0, number.length(), normalizeHelper(number, ALPHA_PHONE_MAPPINGS, true));
            return number;
        }
        number.replace(0, number.length(), normalizeDigitsOnly(number));
        return number;
    }

    public static String normalizeDigitsOnly(CharSequence number) {
        return normalizeDigits(number, false).toString();
    }

    static StringBuilder normalizeDigits(CharSequence number, boolean keepNonDigits) {
        StringBuilder sb = new StringBuilder(number.length());
        for (int i = 0; i < number.length(); i++) {
            char cCharAt = number.charAt(i);
            int iDigit = Character.digit(cCharAt, 10);
            if (iDigit != -1) {
                sb.append(iDigit);
            } else if (keepNonDigits) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    public static String normalizeDiallableCharsOnly(CharSequence number) {
        return normalizeHelper(number, DIALLABLE_CHAR_MAPPINGS, true);
    }

    public static String convertAlphaCharactersInNumber(CharSequence number) {
        return normalizeHelper(number, ALPHA_PHONE_MAPPINGS, false);
    }

    public int getLengthOfGeographicalAreaCode(Phonenumber.PhoneNumber number) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(getRegionCodeForNumber(number));
        if (metadataForRegion == null) {
            return 0;
        }
        if (!metadataForRegion.hasNationalPrefix() && !number.isItalianLeadingZero()) {
            return 0;
        }
        PhoneNumberType numberType = getNumberType(number);
        int countryCode = number.getCountryCode();
        if (!(numberType == PhoneNumberType.MOBILE && GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES.contains(Integer.valueOf(countryCode))) && isNumberGeographical(numberType, countryCode)) {
            return getLengthOfNationalDestinationCode(number);
        }
        return 0;
    }

    public int getLengthOfNationalDestinationCode(Phonenumber.PhoneNumber number) {
        Phonenumber.PhoneNumber phoneNumber;
        if (number.hasExtension()) {
            phoneNumber = new Phonenumber.PhoneNumber();
            phoneNumber.mergeFrom(number);
            phoneNumber.clearExtension();
        } else {
            phoneNumber = number;
        }
        String[] strArrSplit = NON_DIGITS_PATTERN.split(format(phoneNumber, PhoneNumberFormat.INTERNATIONAL));
        if (strArrSplit.length <= 3) {
            return 0;
        }
        if (getNumberType(number) == PhoneNumberType.MOBILE && !getCountryMobileToken(number.getCountryCode()).equals("")) {
            return strArrSplit[2].length() + strArrSplit[3].length();
        }
        return strArrSplit[2].length();
    }

    public static String getCountryMobileToken(int countryCallingCode) {
        Map<Integer, String> map = MOBILE_TOKEN_MAPPINGS;
        if (map.containsKey(Integer.valueOf(countryCallingCode))) {
            return map.get(Integer.valueOf(countryCallingCode));
        }
        return "";
    }

    private static String normalizeHelper(CharSequence number, Map<Character, Character> normalizationReplacements, boolean removeNonMatches) {
        StringBuilder sb = new StringBuilder(number.length());
        for (int i = 0; i < number.length(); i++) {
            char cCharAt = number.charAt(i);
            Character ch = normalizationReplacements.get(Character.valueOf(Character.toUpperCase(cCharAt)));
            if (ch != null) {
                sb.append(ch);
            } else if (!removeNonMatches) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public Set<String> getSupportedRegions() {
        return Collections.unmodifiableSet(this.supportedRegions);
    }

    public Set<Integer> getSupportedGlobalNetworkCallingCodes() {
        return Collections.unmodifiableSet(this.countryCodesForNonGeographicalRegion);
    }

    public Set<Integer> getSupportedCallingCodes() {
        return Collections.unmodifiableSet(this.countryCallingCodeToRegionCodeMap.keySet());
    }

    private static boolean descHasPossibleNumberData(Phonemetadata.PhoneNumberDesc desc) {
        return (desc.getPossibleLengthCount() == 1 && desc.getPossibleLength(0) == -1) ? false : true;
    }

    private static boolean descHasData(Phonemetadata.PhoneNumberDesc desc) {
        return desc.hasExampleNumber() || descHasPossibleNumberData(desc) || desc.hasNationalNumberPattern();
    }

    private Set<PhoneNumberType> getSupportedTypesForMetadata(Phonemetadata.PhoneMetadata metadata) {
        TreeSet treeSet = new TreeSet();
        for (PhoneNumberType phoneNumberType : PhoneNumberType.values()) {
            if (phoneNumberType != PhoneNumberType.FIXED_LINE_OR_MOBILE && phoneNumberType != PhoneNumberType.UNKNOWN && descHasData(getNumberDescByType(metadata, phoneNumberType))) {
                treeSet.add(phoneNumberType);
            }
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public Set<PhoneNumberType> getSupportedTypesForRegion(String regionCode) {
        if (!isValidRegionCode(regionCode)) {
            logger.log(Level.WARNING, "Invalid or unknown region code provided: " + regionCode);
            return Collections.unmodifiableSet(new TreeSet());
        }
        return getSupportedTypesForMetadata(getMetadataForRegion(regionCode));
    }

    public Set<PhoneNumberType> getSupportedTypesForNonGeoEntity(int countryCallingCode) {
        Phonemetadata.PhoneMetadata metadataForNonGeographicalRegion = getMetadataForNonGeographicalRegion(countryCallingCode);
        if (metadataForNonGeographicalRegion == null) {
            logger.log(Level.WARNING, "Unknown country calling code for a non-geographical entity provided: " + countryCallingCode);
            return Collections.unmodifiableSet(new TreeSet());
        }
        return getSupportedTypesForMetadata(metadataForNonGeographicalRegion);
    }

    public static PhoneNumberUtil createInstance(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context could not be null.");
        }
        return createInstance(new AssetsMetadataLoader(context.getAssets()));
    }

    public static PhoneNumberUtil createInstance(MetadataSource metadataSource) {
        if (metadataSource == null) {
            throw new IllegalArgumentException("metadataSource could not be null.");
        }
        return new PhoneNumberUtil(metadataSource, CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
    }

    public static PhoneNumberUtil createInstance(MetadataLoader metadataLoader) {
        if (metadataLoader == null) {
            throw new IllegalArgumentException("metadataLoader could not be null.");
        }
        return createInstance(new MultiFileMetadataSourceImpl(metadataLoader));
    }

    static boolean formattingRuleHasFirstGroupOnly(String nationalPrefixFormattingRule) {
        return nationalPrefixFormattingRule.length() == 0 || FIRST_GROUP_ONLY_PREFIX_PATTERN.matcher(nationalPrefixFormattingRule).matches();
    }

    public boolean isNumberGeographical(Phonenumber.PhoneNumber phoneNumber) {
        return isNumberGeographical(getNumberType(phoneNumber), phoneNumber.getCountryCode());
    }

    public boolean isNumberGeographical(PhoneNumberType phoneNumberType, int countryCallingCode) {
        if (phoneNumberType == PhoneNumberType.FIXED_LINE || phoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
            return true;
        }
        return GEO_MOBILE_COUNTRIES.contains(Integer.valueOf(countryCallingCode)) && phoneNumberType == PhoneNumberType.MOBILE;
    }

    private boolean isValidRegionCode(String regionCode) {
        return regionCode != null && this.supportedRegions.contains(regionCode);
    }

    private boolean hasValidCountryCallingCode(int countryCallingCode) {
        return this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(countryCallingCode));
    }

    public String format(Phonenumber.PhoneNumber number, PhoneNumberFormat numberFormat) {
        if (number.getNationalNumber() == 0 && number.hasRawInput()) {
            String rawInput = number.getRawInput();
            if (rawInput.length() > 0) {
                return rawInput;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        format(number, numberFormat, sb);
        return sb.toString();
    }

    public void format(Phonenumber.PhoneNumber number, PhoneNumberFormat numberFormat, StringBuilder formattedNumber) {
        formattedNumber.setLength(0);
        int countryCode = number.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        if (numberFormat == PhoneNumberFormat.E164) {
            formattedNumber.append(nationalSignificantNumber);
            prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.E164, formattedNumber);
        } else {
            if (!hasValidCountryCallingCode(countryCode)) {
                formattedNumber.append(nationalSignificantNumber);
                return;
            }
            Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
            formattedNumber.append(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, numberFormat));
            maybeAppendFormattedExtension(number, metadataForRegionOrCallingCode, numberFormat, formattedNumber);
            prefixNumberWithCountryCallingCode(countryCode, numberFormat, formattedNumber);
        }
    }

    public String formatByPattern(Phonenumber.PhoneNumber number, PhoneNumberFormat numberFormat, List<Phonemetadata.NumberFormat> userDefinedFormats) {
        int countryCode = number.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        if (!hasValidCountryCallingCode(countryCode)) {
            return nationalSignificantNumber;
        }
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        StringBuilder sb = new StringBuilder(20);
        Phonemetadata.NumberFormat numberFormatChooseFormattingPatternForNumber = chooseFormattingPatternForNumber(userDefinedFormats, nationalSignificantNumber);
        if (numberFormatChooseFormattingPatternForNumber == null) {
            sb.append(nationalSignificantNumber);
        } else {
            Phonemetadata.NumberFormat.Builder builderNewBuilder = Phonemetadata.NumberFormat.newBuilder();
            builderNewBuilder.mergeFrom(numberFormatChooseFormattingPatternForNumber);
            String nationalPrefixFormattingRule = numberFormatChooseFormattingPatternForNumber.getNationalPrefixFormattingRule();
            if (nationalPrefixFormattingRule.length() > 0) {
                String nationalPrefix = metadataForRegionOrCallingCode.getNationalPrefix();
                if (nationalPrefix.length() > 0) {
                    builderNewBuilder.setNationalPrefixFormattingRule(nationalPrefixFormattingRule.replace(NP_STRING, nationalPrefix).replace(FG_STRING, "$1"));
                } else {
                    builderNewBuilder.clearNationalPrefixFormattingRule();
                }
            }
            sb.append(formatNsnUsingPattern(nationalSignificantNumber, builderNewBuilder, numberFormat));
        }
        maybeAppendFormattedExtension(number, metadataForRegionOrCallingCode, numberFormat, sb);
        prefixNumberWithCountryCallingCode(countryCode, numberFormat, sb);
        return sb.toString();
    }

    public String formatNationalNumberWithCarrierCode(Phonenumber.PhoneNumber number, CharSequence carrierCode) {
        int countryCode = number.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        if (!hasValidCountryCallingCode(countryCode)) {
            return nationalSignificantNumber;
        }
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        StringBuilder sb = new StringBuilder(20);
        sb.append(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, PhoneNumberFormat.NATIONAL, carrierCode));
        maybeAppendFormattedExtension(number, metadataForRegionOrCallingCode, PhoneNumberFormat.NATIONAL, sb);
        prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.NATIONAL, sb);
        return sb.toString();
    }

    private Phonemetadata.PhoneMetadata getMetadataForRegionOrCallingCode(int countryCallingCode, String regionCode) {
        if (REGION_CODE_FOR_NON_GEO_ENTITY.equals(regionCode)) {
            return getMetadataForNonGeographicalRegion(countryCallingCode);
        }
        return getMetadataForRegion(regionCode);
    }

    public String formatNationalNumberWithPreferredCarrierCode(Phonenumber.PhoneNumber number, CharSequence fallbackCarrierCode) {
        if (number.getPreferredDomesticCarrierCode().length() > 0) {
            fallbackCarrierCode = number.getPreferredDomesticCarrierCode();
        }
        return formatNationalNumberWithCarrierCode(number, fallbackCarrierCode);
    }

    public String formatNumberForMobileDialing(Phonenumber.PhoneNumber number, String regionCallingFrom, boolean withFormatting) {
        String nationalNumberWithCarrierCode;
        int countryCode = number.getCountryCode();
        String nationalNumberWithPreferredCarrierCode = "";
        if (!hasValidCountryCallingCode(countryCode)) {
            return number.hasRawInput() ? number.getRawInput() : "";
        }
        Phonenumber.PhoneNumber phoneNumberClearExtension = new Phonenumber.PhoneNumber().mergeFrom(number).clearExtension();
        String regionCodeForCountryCode = getRegionCodeForCountryCode(countryCode);
        PhoneNumberType numberType = getNumberType(phoneNumberClearExtension);
        boolean z = numberType != PhoneNumberType.UNKNOWN;
        if (regionCallingFrom.equals(regionCodeForCountryCode)) {
            boolean z2 = numberType == PhoneNumberType.FIXED_LINE || numberType == PhoneNumberType.MOBILE || numberType == PhoneNumberType.FIXED_LINE_OR_MOBILE;
            if (regionCodeForCountryCode.equals("CO") && numberType == PhoneNumberType.FIXED_LINE) {
                nationalNumberWithCarrierCode = formatNationalNumberWithCarrierCode(phoneNumberClearExtension, "3");
            } else if (regionCodeForCountryCode.equals("BR") && z2) {
                if (phoneNumberClearExtension.getPreferredDomesticCarrierCode().length() > 0) {
                    nationalNumberWithPreferredCarrierCode = formatNationalNumberWithPreferredCarrierCode(phoneNumberClearExtension, "");
                }
            } else if (countryCode == 1) {
                Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(regionCallingFrom);
                if (canBeInternationallyDialled(phoneNumberClearExtension) && testNumberLength(getNationalSignificantNumber(phoneNumberClearExtension), metadataForRegion) != ValidationResult.TOO_SHORT) {
                    nationalNumberWithCarrierCode = format(phoneNumberClearExtension, PhoneNumberFormat.INTERNATIONAL);
                } else {
                    nationalNumberWithCarrierCode = format(phoneNumberClearExtension, PhoneNumberFormat.NATIONAL);
                }
            } else if ((regionCodeForCountryCode.equals(REGION_CODE_FOR_NON_GEO_ENTITY) || ((regionCodeForCountryCode.equals("MX") || regionCodeForCountryCode.equals("CL") || regionCodeForCountryCode.equals("UZ")) && z2)) && canBeInternationallyDialled(phoneNumberClearExtension)) {
                nationalNumberWithCarrierCode = format(phoneNumberClearExtension, PhoneNumberFormat.INTERNATIONAL);
            } else {
                nationalNumberWithCarrierCode = format(phoneNumberClearExtension, PhoneNumberFormat.NATIONAL);
            }
            nationalNumberWithPreferredCarrierCode = nationalNumberWithCarrierCode;
        } else if (z && canBeInternationallyDialled(phoneNumberClearExtension)) {
            if (withFormatting) {
                return format(phoneNumberClearExtension, PhoneNumberFormat.INTERNATIONAL);
            }
            return format(phoneNumberClearExtension, PhoneNumberFormat.E164);
        }
        return withFormatting ? nationalNumberWithPreferredCarrierCode : normalizeDiallableCharsOnly(nationalNumberWithPreferredCarrierCode);
    }

    public String formatOutOfCountryCallingNumber(Phonenumber.PhoneNumber number, String regionCallingFrom) {
        if (!isValidRegionCode(regionCallingFrom)) {
            logger.log(Level.WARNING, "Trying to format number from invalid region " + regionCallingFrom + ". International formatting applied.");
            return format(number, PhoneNumberFormat.INTERNATIONAL);
        }
        int countryCode = number.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        if (!hasValidCountryCallingCode(countryCode)) {
            return nationalSignificantNumber;
        }
        if (countryCode == 1) {
            if (isNANPACountry(regionCallingFrom)) {
                return countryCode + " " + format(number, PhoneNumberFormat.NATIONAL);
            }
        } else if (countryCode == getCountryCodeForValidRegion(regionCallingFrom)) {
            return format(number, PhoneNumberFormat.NATIONAL);
        }
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(regionCallingFrom);
        String internationalPrefix = metadataForRegion.getInternationalPrefix();
        if (!SINGLE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches()) {
            if (!metadataForRegion.hasPreferredInternationalPrefix()) {
                internationalPrefix = "";
            } else {
                internationalPrefix = metadataForRegion.getPreferredInternationalPrefix();
            }
        }
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        StringBuilder sb = new StringBuilder(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, PhoneNumberFormat.INTERNATIONAL));
        maybeAppendFormattedExtension(number, metadataForRegionOrCallingCode, PhoneNumberFormat.INTERNATIONAL, sb);
        if (internationalPrefix.length() > 0) {
            sb.insert(0, " ").insert(0, countryCode).insert(0, " ").insert(0, internationalPrefix);
        } else {
            prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.INTERNATIONAL, sb);
        }
        return sb.toString();
    }

    public String formatInOriginalFormat(Phonenumber.PhoneNumber number, String regionCallingFrom) {
        String outOfCountryCallingNumber;
        String nationalPrefixFormattingRule;
        int iIndexOf;
        if (number.hasRawInput() && !hasFormattingPatternForNumber(number)) {
            return number.getRawInput();
        }
        if (!number.hasCountryCodeSource()) {
            return format(number, PhoneNumberFormat.NATIONAL);
        }
        int i = AnonymousClass2.$SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource[number.getCountryCodeSource().ordinal()];
        if (i == 1) {
            outOfCountryCallingNumber = format(number, PhoneNumberFormat.INTERNATIONAL);
        } else if (i == 2) {
            outOfCountryCallingNumber = formatOutOfCountryCallingNumber(number, regionCallingFrom);
        } else if (i == 3) {
            outOfCountryCallingNumber = format(number, PhoneNumberFormat.INTERNATIONAL).substring(1);
        } else {
            String regionCodeForCountryCode = getRegionCodeForCountryCode(number.getCountryCode());
            String nddPrefixForRegion = getNddPrefixForRegion(regionCodeForCountryCode, true);
            outOfCountryCallingNumber = format(number, PhoneNumberFormat.NATIONAL);
            if (nddPrefixForRegion != null && nddPrefixForRegion.length() != 0 && !rawInputContainsNationalPrefix(number.getRawInput(), nddPrefixForRegion, regionCodeForCountryCode)) {
                Phonemetadata.NumberFormat numberFormatChooseFormattingPatternForNumber = chooseFormattingPatternForNumber(getMetadataForRegion(regionCodeForCountryCode).numberFormats(), getNationalSignificantNumber(number));
                if (numberFormatChooseFormattingPatternForNumber != null && (iIndexOf = (nationalPrefixFormattingRule = numberFormatChooseFormattingPatternForNumber.getNationalPrefixFormattingRule()).indexOf("$1")) > 0 && normalizeDigitsOnly(nationalPrefixFormattingRule.substring(0, iIndexOf)).length() != 0) {
                    Phonemetadata.NumberFormat.Builder builderNewBuilder = Phonemetadata.NumberFormat.newBuilder();
                    builderNewBuilder.mergeFrom(numberFormatChooseFormattingPatternForNumber);
                    builderNewBuilder.clearNationalPrefixFormattingRule();
                    List<Phonemetadata.NumberFormat> arrayList = new ArrayList<>(1);
                    arrayList.add(builderNewBuilder);
                    outOfCountryCallingNumber = formatByPattern(number, PhoneNumberFormat.NATIONAL, arrayList);
                }
            }
        }
        String rawInput = number.getRawInput();
        return (outOfCountryCallingNumber == null || rawInput.length() <= 0 || normalizeDiallableCharsOnly(outOfCountryCallingNumber).equals(normalizeDiallableCharsOnly(rawInput))) ? outOfCountryCallingNumber : rawInput;
    }

    private boolean rawInputContainsNationalPrefix(String rawInput, String nationalPrefix, String regionCode) {
        String strNormalizeDigitsOnly = normalizeDigitsOnly(rawInput);
        if (strNormalizeDigitsOnly.startsWith(nationalPrefix)) {
            try {
                return isValidNumber(parse(strNormalizeDigitsOnly.substring(nationalPrefix.length()), regionCode));
            } catch (NumberParseException unused) {
            }
        }
        return false;
    }

    private boolean hasFormattingPatternForNumber(Phonenumber.PhoneNumber number) {
        int countryCode = number.getCountryCode();
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        if (metadataForRegionOrCallingCode == null) {
            return false;
        }
        return chooseFormattingPatternForNumber(metadataForRegionOrCallingCode.numberFormats(), getNationalSignificantNumber(number)) != null;
    }

    public String formatOutOfCountryKeepingAlphaChars(Phonenumber.PhoneNumber number, String regionCallingFrom) {
        String internationalPrefix;
        int iIndexOf;
        String rawInput = number.getRawInput();
        if (rawInput.length() == 0) {
            return formatOutOfCountryCallingNumber(number, regionCallingFrom);
        }
        int countryCode = number.getCountryCode();
        if (!hasValidCountryCallingCode(countryCode)) {
            return rawInput;
        }
        String strNormalizeHelper = normalizeHelper(rawInput, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        if (nationalSignificantNumber.length() > 3 && (iIndexOf = strNormalizeHelper.indexOf(nationalSignificantNumber.substring(0, 3))) != -1) {
            strNormalizeHelper = strNormalizeHelper.substring(iIndexOf);
        }
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(regionCallingFrom);
        if (countryCode == 1) {
            if (isNANPACountry(regionCallingFrom)) {
                return countryCode + " " + strNormalizeHelper;
            }
        } else if (metadataForRegion != null && countryCode == getCountryCodeForValidRegion(regionCallingFrom)) {
            Phonemetadata.NumberFormat numberFormatChooseFormattingPatternForNumber = chooseFormattingPatternForNumber(metadataForRegion.numberFormats(), nationalSignificantNumber);
            if (numberFormatChooseFormattingPatternForNumber == null) {
                return strNormalizeHelper;
            }
            Phonemetadata.NumberFormat.Builder builderNewBuilder = Phonemetadata.NumberFormat.newBuilder();
            builderNewBuilder.mergeFrom(numberFormatChooseFormattingPatternForNumber);
            builderNewBuilder.setPattern("(\\d+)(.*)");
            builderNewBuilder.setFormat("$1$2");
            return formatNsnUsingPattern(strNormalizeHelper, builderNewBuilder, PhoneNumberFormat.NATIONAL);
        }
        if (metadataForRegion == null) {
            internationalPrefix = "";
        } else {
            internationalPrefix = metadataForRegion.getInternationalPrefix();
            if (!SINGLE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches()) {
                internationalPrefix = metadataForRegion.getPreferredInternationalPrefix();
            }
        }
        StringBuilder sb = new StringBuilder(strNormalizeHelper);
        maybeAppendFormattedExtension(number, getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode)), PhoneNumberFormat.INTERNATIONAL, sb);
        if (internationalPrefix.length() > 0) {
            sb.insert(0, " ").insert(0, countryCode).insert(0, " ").insert(0, internationalPrefix);
        } else {
            if (!isValidRegionCode(regionCallingFrom)) {
                logger.log(Level.WARNING, "Trying to format number from invalid region " + regionCallingFrom + ". International formatting applied.");
            }
            prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.INTERNATIONAL, sb);
        }
        return sb.toString();
    }

    public String getNationalSignificantNumber(Phonenumber.PhoneNumber number) {
        StringBuilder sb = new StringBuilder();
        if (number.isItalianLeadingZero() && number.getNumberOfLeadingZeros() > 0) {
            char[] cArr = new char[number.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(number.getNationalNumber());
        return sb.toString();
    }

    private void prefixNumberWithCountryCallingCode(int countryCallingCode, PhoneNumberFormat numberFormat, StringBuilder formattedNumber) {
        int i = AnonymousClass2.$SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[numberFormat.ordinal()];
        if (i == 1) {
            formattedNumber.insert(0, countryCallingCode).insert(0, PLUS_SIGN);
        } else if (i == 2) {
            formattedNumber.insert(0, " ").insert(0, countryCallingCode).insert(0, PLUS_SIGN);
        } else {
            if (i != 3) {
                return;
            }
            formattedNumber.insert(0, "-").insert(0, countryCallingCode).insert(0, PLUS_SIGN).insert(0, RFC3966_PREFIX);
        }
    }

    private String formatNsn(String number, Phonemetadata.PhoneMetadata metadata, PhoneNumberFormat numberFormat) {
        return formatNsn(number, metadata, numberFormat, null);
    }

    private String formatNsn(String number, Phonemetadata.PhoneMetadata metadata, PhoneNumberFormat numberFormat, CharSequence carrierCode) {
        List<Phonemetadata.NumberFormat> listNumberFormats;
        if (metadata.intlNumberFormats().size() == 0 || numberFormat == PhoneNumberFormat.NATIONAL) {
            listNumberFormats = metadata.numberFormats();
        } else {
            listNumberFormats = metadata.intlNumberFormats();
        }
        Phonemetadata.NumberFormat numberFormatChooseFormattingPatternForNumber = chooseFormattingPatternForNumber(listNumberFormats, number);
        return numberFormatChooseFormattingPatternForNumber == null ? number : formatNsnUsingPattern(number, numberFormatChooseFormattingPatternForNumber, numberFormat, carrierCode);
    }

    Phonemetadata.NumberFormat chooseFormattingPatternForNumber(List<Phonemetadata.NumberFormat> availableFormats, String nationalNumber) {
        for (Phonemetadata.NumberFormat numberFormat : availableFormats) {
            int iLeadingDigitsPatternSize = numberFormat.leadingDigitsPatternSize();
            if (iLeadingDigitsPatternSize == 0 || this.regexCache.getPatternForRegex(numberFormat.getLeadingDigitsPattern(iLeadingDigitsPatternSize - 1)).matcher(nationalNumber).lookingAt()) {
                if (this.regexCache.getPatternForRegex(numberFormat.getPattern()).matcher(nationalNumber).matches()) {
                    return numberFormat;
                }
            }
        }
        return null;
    }

    String formatNsnUsingPattern(String nationalNumber, Phonemetadata.NumberFormat formattingPattern, PhoneNumberFormat numberFormat) {
        return formatNsnUsingPattern(nationalNumber, formattingPattern, numberFormat, null);
    }

    private String formatNsnUsingPattern(String nationalNumber, Phonemetadata.NumberFormat formattingPattern, PhoneNumberFormat numberFormat, CharSequence carrierCode) {
        String strReplaceAll;
        String format = formattingPattern.getFormat();
        Matcher matcher = this.regexCache.getPatternForRegex(formattingPattern.getPattern()).matcher(nationalNumber);
        if (numberFormat == PhoneNumberFormat.NATIONAL && carrierCode != null && carrierCode.length() > 0 && formattingPattern.getDomesticCarrierCodeFormattingRule().length() > 0) {
            strReplaceAll = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(formattingPattern.getDomesticCarrierCodeFormattingRule().replace(CC_STRING, carrierCode)));
        } else {
            String nationalPrefixFormattingRule = formattingPattern.getNationalPrefixFormattingRule();
            if (numberFormat == PhoneNumberFormat.NATIONAL && nationalPrefixFormattingRule != null && nationalPrefixFormattingRule.length() > 0) {
                strReplaceAll = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(nationalPrefixFormattingRule));
            } else {
                strReplaceAll = matcher.replaceAll(format);
            }
        }
        if (numberFormat != PhoneNumberFormat.RFC3966) {
            return strReplaceAll;
        }
        Matcher matcher2 = SEPARATOR_PATTERN.matcher(strReplaceAll);
        if (matcher2.lookingAt()) {
            strReplaceAll = matcher2.replaceFirst("");
        }
        return matcher2.reset(strReplaceAll).replaceAll("-");
    }

    public Phonenumber.PhoneNumber getExampleNumber(String regionCode) {
        return getExampleNumberForType(regionCode, PhoneNumberType.FIXED_LINE);
    }

    /*  JADX ERROR: NullPointerException in pass: BlockProcessor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getPredecessors()" because "to" is null
        	at jadx.core.dex.visitors.blocks.BlockSplitter.connect(BlockSplitter.java:159)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectSplittersAndHandlers(BlockExceptionHandler.java:480)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.wrapBlocksWithTryCatch(BlockExceptionHandler.java:381)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:90)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:61)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:380)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    public io.michaelrocks.libphonenumber.android.Phonenumber.PhoneNumber getInvalidExampleNumber(java.lang.String r6) {
        /*
            r5 = this;
            boolean r0 = r5.isValidRegionCode(r6)
            r1 = 0
            if (r0 != 0) goto L1e
            java.util.logging.Logger r0 = io.michaelrocks.libphonenumber.android.PhoneNumberUtil.logger
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Invalid or unknown region code provided: "
            r3.<init>(r4)
            java.lang.StringBuilder r6 = r3.append(r6)
            java.lang.String r6 = r6.toString()
            r0.log(r2, r6)
            return r1
        L1e:
            io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneMetadata r0 = r5.getMetadataForRegion(r6)
            io.michaelrocks.libphonenumber.android.PhoneNumberUtil$PhoneNumberType r2 = io.michaelrocks.libphonenumber.android.PhoneNumberUtil.PhoneNumberType.FIXED_LINE
            io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneNumberDesc r0 = r5.getNumberDescByType(r0, r2)
            boolean r2 = r0.hasExampleNumber()
            if (r2 != 0) goto L2f
            return r1
        L2f:
            java.lang.String r0 = r0.getExampleNumber()
            int r2 = r0.length()
            int r2 = r2 + (-1)
        L39:
            r3 = 2
            if (r2 < r3) goto L4f
            r3 = 0
            java.lang.String r3 = r0.substring(r3, r2)
            io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber r3 = r5.parse(r3, r6)     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L4c
            boolean r4 = r5.isValidNumber(r3)     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L4c
            if (r4 != 0) goto L4c
            return r3
        L4c:
            int r2 = r2 + (-1)
            goto L39
        L4f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.getInvalidExampleNumber(java.lang.String):io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber");
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(String regionCode, PhoneNumberType type) {
        if (!isValidRegionCode(regionCode)) {
            logger.log(Level.WARNING, "Invalid or unknown region code provided: " + regionCode);
            return null;
        }
        Phonemetadata.PhoneNumberDesc numberDescByType = getNumberDescByType(getMetadataForRegion(regionCode), type);
        try {
            if (numberDescByType.hasExampleNumber()) {
                return parse(numberDescByType.getExampleNumber(), regionCode);
            }
        } catch (NumberParseException e2) {
            logger.log(Level.SEVERE, e2.toString());
        }
        return null;
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(PhoneNumberType type) {
        Iterator<String> it = getSupportedRegions().iterator();
        while (it.hasNext()) {
            Phonenumber.PhoneNumber exampleNumberForType = getExampleNumberForType(it.next(), type);
            if (exampleNumberForType != null) {
                return exampleNumberForType;
            }
        }
        Iterator<Integer> it2 = getSupportedGlobalNetworkCallingCodes().iterator();
        while (it2.hasNext()) {
            int iIntValue = it2.next().intValue();
            Phonemetadata.PhoneNumberDesc numberDescByType = getNumberDescByType(getMetadataForNonGeographicalRegion(iIntValue), type);
            try {
                if (numberDescByType.hasExampleNumber()) {
                    return parse(MqttTopic.SINGLE_LEVEL_WILDCARD + iIntValue + numberDescByType.getExampleNumber(), UNKNOWN_REGION);
                }
                continue;
            } catch (NumberParseException e2) {
                logger.log(Level.SEVERE, e2.toString());
            }
        }
        return null;
    }

    public Phonenumber.PhoneNumber getExampleNumberForNonGeoEntity(int countryCallingCode) {
        Phonemetadata.PhoneMetadata metadataForNonGeographicalRegion = getMetadataForNonGeographicalRegion(countryCallingCode);
        if (metadataForNonGeographicalRegion != null) {
            for (Phonemetadata.PhoneNumberDesc phoneNumberDesc : Arrays.asList(metadataForNonGeographicalRegion.getMobile(), metadataForNonGeographicalRegion.getTollFree(), metadataForNonGeographicalRegion.getSharedCost(), metadataForNonGeographicalRegion.getVoip(), metadataForNonGeographicalRegion.getVoicemail(), metadataForNonGeographicalRegion.getUan(), metadataForNonGeographicalRegion.getPremiumRate())) {
                if (phoneNumberDesc != null) {
                    try {
                        if (phoneNumberDesc.hasExampleNumber()) {
                            return parse(MqttTopic.SINGLE_LEVEL_WILDCARD + countryCallingCode + phoneNumberDesc.getExampleNumber(), UNKNOWN_REGION);
                        }
                        continue;
                    } catch (NumberParseException e2) {
                        logger.log(Level.SEVERE, e2.toString());
                    }
                }
            }
            return null;
        }
        logger.log(Level.WARNING, "Invalid or unknown country calling code provided: " + countryCallingCode);
        return null;
    }

    private void maybeAppendFormattedExtension(Phonenumber.PhoneNumber number, Phonemetadata.PhoneMetadata metadata, PhoneNumberFormat numberFormat, StringBuilder formattedNumber) {
        if (!number.hasExtension() || number.getExtension().length() <= 0) {
            return;
        }
        if (numberFormat == PhoneNumberFormat.RFC3966) {
            formattedNumber.append(RFC3966_EXTN_PREFIX).append(number.getExtension());
        } else if (metadata.hasPreferredExtnPrefix()) {
            formattedNumber.append(metadata.getPreferredExtnPrefix()).append(number.getExtension());
        } else {
            formattedNumber.append(DEFAULT_EXTN_PREFIX).append(number.getExtension());
        }
    }

    /* JADX INFO: renamed from: io.michaelrocks.libphonenumber.android.PhoneNumberUtil$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat;
        static final /* synthetic */ int[] $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType;
        static final /* synthetic */ int[] $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource;

        static {
            int[] iArr = new int[PhoneNumberType.values().length];
            $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType = iArr;
            try {
                iArr[PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr2 = new int[PhoneNumberFormat.values().length];
            $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat = iArr2;
            try {
                iArr2[PhoneNumberFormat.E164.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[Phonenumber.PhoneNumber.CountryCodeSource.values().length];
            $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource = iArr3;
            try {
                iArr3[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    Phonemetadata.PhoneNumberDesc getNumberDescByType(Phonemetadata.PhoneMetadata metadata, PhoneNumberType type) {
        switch (AnonymousClass2.$SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[type.ordinal()]) {
            case 1:
                return metadata.getPremiumRate();
            case 2:
                return metadata.getTollFree();
            case 3:
                return metadata.getMobile();
            case 4:
            case 5:
                return metadata.getFixedLine();
            case 6:
                return metadata.getSharedCost();
            case 7:
                return metadata.getVoip();
            case 8:
                return metadata.getPersonalNumber();
            case 9:
                return metadata.getPager();
            case 10:
                return metadata.getUan();
            case 11:
                return metadata.getVoicemail();
            default:
                return metadata.getGeneralDesc();
        }
    }

    public PhoneNumberType getNumberType(Phonenumber.PhoneNumber number) {
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(number.getCountryCode(), getRegionCodeForNumber(number));
        if (metadataForRegionOrCallingCode == null) {
            return PhoneNumberType.UNKNOWN;
        }
        return getNumberTypeHelper(getNationalSignificantNumber(number), metadataForRegionOrCallingCode);
    }

    private PhoneNumberType getNumberTypeHelper(String nationalNumber, Phonemetadata.PhoneMetadata metadata) {
        if (!isNumberMatchingDesc(nationalNumber, metadata.getGeneralDesc())) {
            return PhoneNumberType.UNKNOWN;
        }
        if (isNumberMatchingDesc(nationalNumber, metadata.getPremiumRate())) {
            return PhoneNumberType.PREMIUM_RATE;
        }
        if (isNumberMatchingDesc(nationalNumber, metadata.getTollFree())) {
            return PhoneNumberType.TOLL_FREE;
        }
        if (isNumberMatchingDesc(nationalNumber, metadata.getSharedCost())) {
            return PhoneNumberType.SHARED_COST;
        }
        if (isNumberMatchingDesc(nationalNumber, metadata.getVoip())) {
            return PhoneNumberType.VOIP;
        }
        if (isNumberMatchingDesc(nationalNumber, metadata.getPersonalNumber())) {
            return PhoneNumberType.PERSONAL_NUMBER;
        }
        if (isNumberMatchingDesc(nationalNumber, metadata.getPager())) {
            return PhoneNumberType.PAGER;
        }
        if (isNumberMatchingDesc(nationalNumber, metadata.getUan())) {
            return PhoneNumberType.UAN;
        }
        if (isNumberMatchingDesc(nationalNumber, metadata.getVoicemail())) {
            return PhoneNumberType.VOICEMAIL;
        }
        if (isNumberMatchingDesc(nationalNumber, metadata.getFixedLine())) {
            if (metadata.getSameMobileAndFixedLinePattern()) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            if (isNumberMatchingDesc(nationalNumber, metadata.getMobile())) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            return PhoneNumberType.FIXED_LINE;
        }
        if (!metadata.getSameMobileAndFixedLinePattern() && isNumberMatchingDesc(nationalNumber, metadata.getMobile())) {
            return PhoneNumberType.MOBILE;
        }
        return PhoneNumberType.UNKNOWN;
    }

    Phonemetadata.PhoneMetadata getMetadataForRegion(String regionCode) {
        if (isValidRegionCode(regionCode)) {
            return this.metadataSource.getMetadataForRegion(regionCode);
        }
        return null;
    }

    Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int countryCallingCode) {
        if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(countryCallingCode))) {
            return this.metadataSource.getMetadataForNonGeographicalRegion(countryCallingCode);
        }
        return null;
    }

    boolean isNumberMatchingDesc(String nationalNumber, Phonemetadata.PhoneNumberDesc numberDesc) {
        int length = nationalNumber.length();
        List<Integer> possibleLengthList = numberDesc.getPossibleLengthList();
        if (possibleLengthList.size() <= 0 || possibleLengthList.contains(Integer.valueOf(length))) {
            return this.matcherApi.matchNationalNumber(nationalNumber, numberDesc, false);
        }
        return false;
    }

    public boolean isValidNumber(Phonenumber.PhoneNumber number) {
        return isValidNumberForRegion(number, getRegionCodeForNumber(number));
    }

    public boolean isValidNumberForRegion(Phonenumber.PhoneNumber number, String regionCode) {
        int countryCode = number.getCountryCode();
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, regionCode);
        return metadataForRegionOrCallingCode != null && (REGION_CODE_FOR_NON_GEO_ENTITY.equals(regionCode) || countryCode == getCountryCodeForValidRegion(regionCode)) && getNumberTypeHelper(getNationalSignificantNumber(number), metadataForRegionOrCallingCode) != PhoneNumberType.UNKNOWN;
    }

    public String getRegionCodeForNumber(Phonenumber.PhoneNumber number) {
        int countryCode = number.getCountryCode();
        List<String> list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(countryCode));
        if (list == null) {
            logger.log(Level.INFO, "Missing/invalid country_code (" + countryCode + ")");
            return null;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return getRegionCodeForNumberFromRegionList(number, list);
    }

    private String getRegionCodeForNumberFromRegionList(Phonenumber.PhoneNumber number, List<String> regionCodes) {
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        for (String str : regionCodes) {
            Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
            if (metadataForRegion.hasLeadingDigits()) {
                if (this.regexCache.getPatternForRegex(metadataForRegion.getLeadingDigits()).matcher(nationalSignificantNumber).lookingAt()) {
                    return str;
                }
            } else if (getNumberTypeHelper(nationalSignificantNumber, metadataForRegion) != PhoneNumberType.UNKNOWN) {
                return str;
            }
        }
        return null;
    }

    public String getRegionCodeForCountryCode(int countryCallingCode) {
        List<String> list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(countryCallingCode));
        return list == null ? UNKNOWN_REGION : list.get(0);
    }

    public List<String> getRegionCodesForCountryCode(int countryCallingCode) {
        List<String> arrayList = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(countryCallingCode));
        if (arrayList == null) {
            arrayList = new ArrayList<>(0);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int getCountryCodeForRegion(String regionCode) {
        if (!isValidRegionCode(regionCode)) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder("Invalid or missing region code (");
            if (regionCode == null) {
                regionCode = Constants.NULL_VERSION_ID;
            }
            logger2.log(level, sb.append(regionCode).append(") provided.").toString());
            return 0;
        }
        return getCountryCodeForValidRegion(regionCode);
    }

    private int getCountryCodeForValidRegion(String regionCode) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(regionCode);
        if (metadataForRegion == null) {
            throw new IllegalArgumentException("Invalid region code: " + regionCode);
        }
        return metadataForRegion.getCountryCode();
    }

    public String getNddPrefixForRegion(String regionCode, boolean stripNonDigits) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(regionCode);
        if (metadataForRegion == null) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder("Invalid or missing region code (");
            if (regionCode == null) {
                regionCode = Constants.NULL_VERSION_ID;
            }
            logger2.log(level, sb.append(regionCode).append(") provided.").toString());
            return null;
        }
        String nationalPrefix = metadataForRegion.getNationalPrefix();
        if (nationalPrefix.length() == 0) {
            return null;
        }
        return stripNonDigits ? nationalPrefix.replace("~", "") : nationalPrefix;
    }

    public boolean isNANPACountry(String regionCode) {
        return this.nanpaRegions.contains(regionCode);
    }

    public boolean isAlphaNumber(CharSequence number) {
        if (!isViablePhoneNumber(number)) {
            return false;
        }
        StringBuilder sb = new StringBuilder(number);
        maybeStripExtension(sb);
        return VALID_ALPHA_PHONE_PATTERN.matcher(sb).matches();
    }

    public boolean isPossibleNumber(Phonenumber.PhoneNumber number) {
        ValidationResult validationResultIsPossibleNumberWithReason = isPossibleNumberWithReason(number);
        return validationResultIsPossibleNumberWithReason == ValidationResult.IS_POSSIBLE || validationResultIsPossibleNumberWithReason == ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
    }

    public boolean isPossibleNumberForType(Phonenumber.PhoneNumber number, PhoneNumberType type) {
        ValidationResult validationResultIsPossibleNumberForTypeWithReason = isPossibleNumberForTypeWithReason(number, type);
        return validationResultIsPossibleNumberForTypeWithReason == ValidationResult.IS_POSSIBLE || validationResultIsPossibleNumberForTypeWithReason == ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
    }

    private ValidationResult testNumberLength(CharSequence number, Phonemetadata.PhoneMetadata metadata) {
        return testNumberLength(number, metadata, PhoneNumberType.UNKNOWN);
    }

    private ValidationResult testNumberLength(CharSequence number, Phonemetadata.PhoneMetadata metadata, PhoneNumberType type) {
        List<Integer> possibleLengthList;
        Phonemetadata.PhoneNumberDesc numberDescByType = getNumberDescByType(metadata, type);
        List<Integer> possibleLengthList2 = numberDescByType.getPossibleLengthList().isEmpty() ? metadata.getGeneralDesc().getPossibleLengthList() : numberDescByType.getPossibleLengthList();
        List<Integer> possibleLengthLocalOnlyList = numberDescByType.getPossibleLengthLocalOnlyList();
        if (type == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
            if (!descHasPossibleNumberData(getNumberDescByType(metadata, PhoneNumberType.FIXED_LINE))) {
                return testNumberLength(number, metadata, PhoneNumberType.MOBILE);
            }
            Phonemetadata.PhoneNumberDesc numberDescByType2 = getNumberDescByType(metadata, PhoneNumberType.MOBILE);
            if (descHasPossibleNumberData(numberDescByType2)) {
                ArrayList arrayList = new ArrayList(possibleLengthList2);
                if (numberDescByType2.getPossibleLengthList().size() == 0) {
                    possibleLengthList = metadata.getGeneralDesc().getPossibleLengthList();
                } else {
                    possibleLengthList = numberDescByType2.getPossibleLengthList();
                }
                arrayList.addAll(possibleLengthList);
                Collections.sort(arrayList);
                if (possibleLengthLocalOnlyList.isEmpty()) {
                    possibleLengthLocalOnlyList = numberDescByType2.getPossibleLengthLocalOnlyList();
                } else {
                    ArrayList arrayList2 = new ArrayList(possibleLengthLocalOnlyList);
                    arrayList2.addAll(numberDescByType2.getPossibleLengthLocalOnlyList());
                    Collections.sort(arrayList2);
                    possibleLengthLocalOnlyList = arrayList2;
                }
                possibleLengthList2 = arrayList;
            }
        }
        if (possibleLengthList2.get(0).intValue() == -1) {
            return ValidationResult.INVALID_LENGTH;
        }
        int length = number.length();
        if (possibleLengthLocalOnlyList.contains(Integer.valueOf(length))) {
            return ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
        }
        int iIntValue = possibleLengthList2.get(0).intValue();
        if (iIntValue == length) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (iIntValue > length) {
            return ValidationResult.TOO_SHORT;
        }
        if (possibleLengthList2.get(possibleLengthList2.size() - 1).intValue() < length) {
            return ValidationResult.TOO_LONG;
        }
        return possibleLengthList2.subList(1, possibleLengthList2.size()).contains(Integer.valueOf(length)) ? ValidationResult.IS_POSSIBLE : ValidationResult.INVALID_LENGTH;
    }

    public ValidationResult isPossibleNumberWithReason(Phonenumber.PhoneNumber number) {
        return isPossibleNumberForTypeWithReason(number, PhoneNumberType.UNKNOWN);
    }

    public ValidationResult isPossibleNumberForTypeWithReason(Phonenumber.PhoneNumber number, PhoneNumberType type) {
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        int countryCode = number.getCountryCode();
        if (!hasValidCountryCallingCode(countryCode)) {
            return ValidationResult.INVALID_COUNTRY_CODE;
        }
        return testNumberLength(nationalSignificantNumber, getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode)), type);
    }

    public boolean isPossibleNumber(CharSequence number, String regionDialingFrom) {
        try {
            return isPossibleNumber(parse(number, regionDialingFrom));
        } catch (NumberParseException unused) {
            return false;
        }
    }

    public boolean truncateTooLongNumber(Phonenumber.PhoneNumber number) {
        if (isValidNumber(number)) {
            return true;
        }
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        phoneNumber.mergeFrom(number);
        long nationalNumber = number.getNationalNumber();
        do {
            nationalNumber /= 10;
            phoneNumber.setNationalNumber(nationalNumber);
            if (isPossibleNumberWithReason(phoneNumber) == ValidationResult.TOO_SHORT || nationalNumber == 0) {
                return false;
            }
        } while (!isValidNumber(phoneNumber));
        number.setNationalNumber(nationalNumber);
        return true;
    }

    public AsYouTypeFormatter getAsYouTypeFormatter(String regionCode) {
        return new AsYouTypeFormatter(this, regionCode);
    }

    int extractCountryCode(StringBuilder fullNumber, StringBuilder nationalNumber) {
        if (fullNumber.length() != 0 && fullNumber.charAt(0) != '0') {
            int length = fullNumber.length();
            for (int i = 1; i <= 3 && i <= length; i++) {
                int i2 = Integer.parseInt(fullNumber.substring(0, i));
                if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i2))) {
                    nationalNumber.append(fullNumber.substring(i));
                    return i2;
                }
            }
        }
        return 0;
    }

    int maybeExtractCountryCode(CharSequence number, Phonemetadata.PhoneMetadata defaultRegionMetadata, StringBuilder nationalNumber, boolean keepRawInput, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        String internationalPrefix;
        if (number.length() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(number);
        if (defaultRegionMetadata == null) {
            internationalPrefix = "NonMatch";
        } else {
            internationalPrefix = defaultRegionMetadata.getInternationalPrefix();
        }
        Phonenumber.PhoneNumber.CountryCodeSource countryCodeSourceMaybeStripInternationalPrefixAndNormalize = maybeStripInternationalPrefixAndNormalize(sb, internationalPrefix);
        if (keepRawInput) {
            phoneNumber.setCountryCodeSource(countryCodeSourceMaybeStripInternationalPrefixAndNormalize);
        }
        if (countryCodeSourceMaybeStripInternationalPrefixAndNormalize != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (sb.length() <= 2) {
                throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
            }
            int iExtractCountryCode = extractCountryCode(sb, nationalNumber);
            if (iExtractCountryCode != 0) {
                phoneNumber.setCountryCode(iExtractCountryCode);
                return iExtractCountryCode;
            }
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        }
        if (defaultRegionMetadata != null) {
            int countryCode = defaultRegionMetadata.getCountryCode();
            String strValueOf = String.valueOf(countryCode);
            String string = sb.toString();
            if (string.startsWith(strValueOf)) {
                StringBuilder sb2 = new StringBuilder(string.substring(strValueOf.length()));
                Phonemetadata.PhoneNumberDesc generalDesc = defaultRegionMetadata.getGeneralDesc();
                maybeStripNationalPrefixAndCarrierCode(sb2, defaultRegionMetadata, null);
                if ((!this.matcherApi.matchNationalNumber(sb, generalDesc, false) && this.matcherApi.matchNationalNumber(sb2, generalDesc, false)) || testNumberLength(sb, defaultRegionMetadata) == ValidationResult.TOO_LONG) {
                    nationalNumber.append((CharSequence) sb2);
                    if (keepRawInput) {
                        phoneNumber.setCountryCodeSource(Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    }
                    phoneNumber.setCountryCode(countryCode);
                    return countryCode;
                }
            }
        }
        phoneNumber.setCountryCode(0);
        return 0;
    }

    private boolean parsePrefixAsIdd(Pattern iddPattern, StringBuilder number) {
        Matcher matcher = iddPattern.matcher(number);
        if (!matcher.lookingAt()) {
            return false;
        }
        int iEnd = matcher.end();
        Matcher matcher2 = CAPTURING_DIGIT_PATTERN.matcher(number.substring(iEnd));
        if (matcher2.find() && normalizeDigitsOnly(matcher2.group(1)).equals("0")) {
            return false;
        }
        number.delete(0, iEnd);
        return true;
    }

    Phonenumber.PhoneNumber.CountryCodeSource maybeStripInternationalPrefixAndNormalize(StringBuilder number, String possibleIddPrefix) {
        if (number.length() == 0) {
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = PLUS_CHARS_PATTERN.matcher(number);
        if (matcher.lookingAt()) {
            number.delete(0, matcher.end());
            normalize(number);
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern patternForRegex = this.regexCache.getPatternForRegex(possibleIddPrefix);
        normalize(number);
        return parsePrefixAsIdd(patternForRegex, number) ? Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD : Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder number, Phonemetadata.PhoneMetadata metadata, StringBuilder carrierCode) {
        int length = number.length();
        String nationalPrefixForParsing = metadata.getNationalPrefixForParsing();
        if (length != 0 && nationalPrefixForParsing.length() != 0) {
            Matcher matcher = this.regexCache.getPatternForRegex(nationalPrefixForParsing).matcher(number);
            if (matcher.lookingAt()) {
                Phonemetadata.PhoneNumberDesc generalDesc = metadata.getGeneralDesc();
                boolean zMatchNationalNumber = this.matcherApi.matchNationalNumber(number, generalDesc, false);
                int iGroupCount = matcher.groupCount();
                String nationalPrefixTransformRule = metadata.getNationalPrefixTransformRule();
                if (nationalPrefixTransformRule == null || nationalPrefixTransformRule.length() == 0 || matcher.group(iGroupCount) == null) {
                    if (zMatchNationalNumber && !this.matcherApi.matchNationalNumber(number.substring(matcher.end()), generalDesc, false)) {
                        return false;
                    }
                    if (carrierCode != null && iGroupCount > 0 && matcher.group(iGroupCount) != null) {
                        carrierCode.append(matcher.group(1));
                    }
                    number.delete(0, matcher.end());
                    return true;
                }
                StringBuilder sb = new StringBuilder(number);
                sb.replace(0, length, matcher.replaceFirst(nationalPrefixTransformRule));
                if (zMatchNationalNumber && !this.matcherApi.matchNationalNumber(sb.toString(), generalDesc, false)) {
                    return false;
                }
                if (carrierCode != null && iGroupCount > 1) {
                    carrierCode.append(matcher.group(1));
                }
                number.replace(0, number.length(), sb.toString());
                return true;
            }
        }
        return false;
    }

    String maybeStripExtension(StringBuilder number) {
        Matcher matcher = EXTN_PATTERN.matcher(number);
        if (matcher.find() && isViablePhoneNumber(number.substring(0, matcher.start()))) {
            int iGroupCount = matcher.groupCount();
            for (int i = 1; i <= iGroupCount; i++) {
                if (matcher.group(i) != null) {
                    String strGroup = matcher.group(i);
                    number.delete(matcher.start(), number.length());
                    return strGroup;
                }
            }
            return "";
        }
        return "";
    }

    private boolean checkRegionForParsing(CharSequence numberToParse, String defaultRegion) {
        if (isValidRegionCode(defaultRegion)) {
            return true;
        }
        return (numberToParse == null || numberToParse.length() == 0 || !PLUS_CHARS_PATTERN.matcher(numberToParse).lookingAt()) ? false : true;
    }

    public Phonenumber.PhoneNumber parse(CharSequence numberToParse, String defaultRegion) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        parse(numberToParse, defaultRegion, phoneNumber);
        return phoneNumber;
    }

    public void parse(CharSequence numberToParse, String defaultRegion, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(numberToParse, defaultRegion, false, true, phoneNumber);
    }

    public Phonenumber.PhoneNumber parseAndKeepRawInput(CharSequence numberToParse, String defaultRegion) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        parseAndKeepRawInput(numberToParse, defaultRegion, phoneNumber);
        return phoneNumber;
    }

    public void parseAndKeepRawInput(CharSequence numberToParse, String defaultRegion, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(numberToParse, defaultRegion, true, true, phoneNumber);
    }

    public Iterable<PhoneNumberMatch> findNumbers(CharSequence text, String defaultRegion) {
        return findNumbers(text, defaultRegion, Leniency.VALID, Long.MAX_VALUE);
    }

    public Iterable<PhoneNumberMatch> findNumbers(final CharSequence text, final String defaultRegion, final Leniency leniency, final long maxTries) {
        return new Iterable<PhoneNumberMatch>() { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.1
            @Override // java.lang.Iterable
            public Iterator<PhoneNumberMatch> iterator() {
                return new PhoneNumberMatcher(PhoneNumberUtil.this, text, defaultRegion, leniency, maxTries);
            }
        };
    }

    static void setItalianLeadingZerosForPhoneNumber(CharSequence nationalNumber, Phonenumber.PhoneNumber phoneNumber) {
        if (nationalNumber.length() <= 1 || nationalNumber.charAt(0) != '0') {
            return;
        }
        phoneNumber.setItalianLeadingZero(true);
        int i = 1;
        while (i < nationalNumber.length() - 1 && nationalNumber.charAt(i) == '0') {
            i++;
        }
        if (i != 1) {
            phoneNumber.setNumberOfLeadingZeros(i);
        }
    }

    private void parseHelper(CharSequence numberToParse, String defaultRegion, boolean keepRawInput, boolean checkRegion, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        int iMaybeExtractCountryCode;
        if (numberToParse == null) {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        }
        if (numberToParse.length() > 250) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        }
        StringBuilder sb = new StringBuilder();
        String string = numberToParse.toString();
        buildNationalNumberForParsing(string, sb);
        if (!isViablePhoneNumber(sb)) {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
        }
        if (checkRegion && !checkRegionForParsing(sb, defaultRegion)) {
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
        }
        if (keepRawInput) {
            phoneNumber.setRawInput(string);
        }
        String strMaybeStripExtension = maybeStripExtension(sb);
        if (strMaybeStripExtension.length() > 0) {
            phoneNumber.setExtension(strMaybeStripExtension);
        }
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(defaultRegion);
        StringBuilder sb2 = new StringBuilder();
        boolean z = keepRawInput;
        Phonenumber.PhoneNumber phoneNumber2 = phoneNumber;
        try {
            iMaybeExtractCountryCode = maybeExtractCountryCode(sb, metadataForRegion, sb2, z, phoneNumber2);
        } catch (NumberParseException e2) {
            Matcher matcher = PLUS_CHARS_PATTERN.matcher(sb);
            if (e2.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                iMaybeExtractCountryCode = maybeExtractCountryCode(sb.substring(matcher.end()), metadataForRegion, sb2, z, phoneNumber2);
                metadataForRegion = metadataForRegion;
                sb2 = sb2;
                z = z;
                phoneNumber2 = phoneNumber2;
                if (iMaybeExtractCountryCode == 0) {
                    throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                }
            } else {
                throw new NumberParseException(e2.getErrorType(), e2.getMessage());
            }
        }
        if (iMaybeExtractCountryCode != 0) {
            String regionCodeForCountryCode = getRegionCodeForCountryCode(iMaybeExtractCountryCode);
            if (!regionCodeForCountryCode.equals(defaultRegion)) {
                metadataForRegion = getMetadataForRegionOrCallingCode(iMaybeExtractCountryCode, regionCodeForCountryCode);
            }
        } else {
            sb2.append((CharSequence) normalize(sb));
            if (defaultRegion != null) {
                phoneNumber2.setCountryCode(metadataForRegion.getCountryCode());
            } else if (z) {
                phoneNumber2.clearCountryCodeSource();
            }
        }
        if (sb2.length() < 2) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (metadataForRegion != null) {
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder(sb2);
            maybeStripNationalPrefixAndCarrierCode(sb4, metadataForRegion, sb3);
            ValidationResult validationResultTestNumberLength = testNumberLength(sb4, metadataForRegion);
            if (validationResultTestNumberLength != ValidationResult.TOO_SHORT && validationResultTestNumberLength != ValidationResult.IS_POSSIBLE_LOCAL_ONLY && validationResultTestNumberLength != ValidationResult.INVALID_LENGTH) {
                if (z && sb3.length() > 0) {
                    phoneNumber2.setPreferredDomesticCarrierCode(sb3.toString());
                }
                sb2 = sb4;
            }
        }
        int length = sb2.length();
        if (length < 2) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (length > 17) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
        }
        setItalianLeadingZerosForPhoneNumber(sb2, phoneNumber2);
        phoneNumber2.setNationalNumber(Long.parseLong(sb2.toString()));
    }

    private void buildNationalNumberForParsing(String numberToParse, StringBuilder nationalNumber) {
        int iIndexOf = numberToParse.indexOf(RFC3966_PHONE_CONTEXT);
        if (iIndexOf >= 0) {
            int length = RFC3966_PHONE_CONTEXT.length() + iIndexOf;
            if (length < numberToParse.length() - 1 && numberToParse.charAt(length) == '+') {
                int iIndexOf2 = numberToParse.indexOf(59, length);
                if (iIndexOf2 > 0) {
                    nationalNumber.append(numberToParse.substring(length, iIndexOf2));
                } else {
                    nationalNumber.append(numberToParse.substring(length));
                }
            }
            int iIndexOf3 = numberToParse.indexOf(RFC3966_PREFIX);
            nationalNumber.append(numberToParse.substring(iIndexOf3 >= 0 ? iIndexOf3 + RFC3966_PREFIX.length() : 0, iIndexOf));
        } else {
            nationalNumber.append(extractPossibleNumber(numberToParse));
        }
        int iIndexOf4 = nationalNumber.indexOf(RFC3966_ISDN_SUBADDRESS);
        if (iIndexOf4 > 0) {
            nationalNumber.delete(iIndexOf4, nationalNumber.length());
        }
    }

    private static Phonenumber.PhoneNumber copyCoreFieldsOnly(Phonenumber.PhoneNumber phoneNumberIn) {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        phoneNumber.setCountryCode(phoneNumberIn.getCountryCode());
        phoneNumber.setNationalNumber(phoneNumberIn.getNationalNumber());
        if (phoneNumberIn.getExtension().length() > 0) {
            phoneNumber.setExtension(phoneNumberIn.getExtension());
        }
        if (phoneNumberIn.isItalianLeadingZero()) {
            phoneNumber.setItalianLeadingZero(true);
            phoneNumber.setNumberOfLeadingZeros(phoneNumberIn.getNumberOfLeadingZeros());
        }
        return phoneNumber;
    }

    public MatchType isNumberMatch(Phonenumber.PhoneNumber firstNumberIn, Phonenumber.PhoneNumber secondNumberIn) {
        Phonenumber.PhoneNumber phoneNumberCopyCoreFieldsOnly = copyCoreFieldsOnly(firstNumberIn);
        Phonenumber.PhoneNumber phoneNumberCopyCoreFieldsOnly2 = copyCoreFieldsOnly(secondNumberIn);
        if (phoneNumberCopyCoreFieldsOnly.hasExtension() && phoneNumberCopyCoreFieldsOnly2.hasExtension() && !phoneNumberCopyCoreFieldsOnly.getExtension().equals(phoneNumberCopyCoreFieldsOnly2.getExtension())) {
            return MatchType.NO_MATCH;
        }
        int countryCode = phoneNumberCopyCoreFieldsOnly.getCountryCode();
        int countryCode2 = phoneNumberCopyCoreFieldsOnly2.getCountryCode();
        if (countryCode != 0 && countryCode2 != 0) {
            if (phoneNumberCopyCoreFieldsOnly.exactlySameAs(phoneNumberCopyCoreFieldsOnly2)) {
                return MatchType.EXACT_MATCH;
            }
            if (countryCode == countryCode2 && isNationalNumberSuffixOfTheOther(phoneNumberCopyCoreFieldsOnly, phoneNumberCopyCoreFieldsOnly2)) {
                return MatchType.SHORT_NSN_MATCH;
            }
            return MatchType.NO_MATCH;
        }
        phoneNumberCopyCoreFieldsOnly.setCountryCode(countryCode2);
        if (phoneNumberCopyCoreFieldsOnly.exactlySameAs(phoneNumberCopyCoreFieldsOnly2)) {
            return MatchType.NSN_MATCH;
        }
        if (isNationalNumberSuffixOfTheOther(phoneNumberCopyCoreFieldsOnly, phoneNumberCopyCoreFieldsOnly2)) {
            return MatchType.SHORT_NSN_MATCH;
        }
        return MatchType.NO_MATCH;
    }

    private boolean isNationalNumberSuffixOfTheOther(Phonenumber.PhoneNumber firstNumber, Phonenumber.PhoneNumber secondNumber) {
        String strValueOf = String.valueOf(firstNumber.getNationalNumber());
        String strValueOf2 = String.valueOf(secondNumber.getNationalNumber());
        return strValueOf.endsWith(strValueOf2) || strValueOf2.endsWith(strValueOf);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.michaelrocks.libphonenumber.android.PhoneNumberUtil.MatchType isNumberMatch(java.lang.CharSequence r9, java.lang.CharSequence r10) {
        /*
            r8 = this;
            java.lang.String r1 = "ZZ"
            io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber r0 = r8.parse(r9, r1)     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> Lb
            io.michaelrocks.libphonenumber.android.PhoneNumberUtil$MatchType r9 = r8.isNumberMatch(r0, r10)     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> Lb
            return r9
        Lb:
            r0 = move-exception
            io.michaelrocks.libphonenumber.android.NumberParseException$ErrorType r0 = r0.getErrorType()
            io.michaelrocks.libphonenumber.android.NumberParseException$ErrorType r2 = io.michaelrocks.libphonenumber.android.NumberParseException.ErrorType.INVALID_COUNTRY_CODE
            if (r0 != r2) goto L48
            io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber r0 = r8.parse(r10, r1)     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L1d
            io.michaelrocks.libphonenumber.android.PhoneNumberUtil$MatchType r9 = r8.isNumberMatch(r0, r9)     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L1d
            return r9
        L1d:
            r0 = move-exception
            io.michaelrocks.libphonenumber.android.NumberParseException$ErrorType r0 = r0.getErrorType()
            io.michaelrocks.libphonenumber.android.NumberParseException$ErrorType r1 = io.michaelrocks.libphonenumber.android.NumberParseException.ErrorType.INVALID_COUNTRY_CODE
            if (r0 != r1) goto L48
            io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber r7 = new io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L48
            r7.<init>()     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L48
            io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber r0 = new io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L48
            r0.<init>()     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L48
            r5 = 0
            r6 = 0
            r4 = 0
            r2 = r8
            r3 = r9
            r2.parseHelper(r3, r4, r5, r6, r7)     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L46
            r4 = 0
            r5 = 0
            r3 = 0
            r1 = r8
            r2 = r10
            r6 = r0
            r1.parseHelper(r2, r3, r4, r5, r6)     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L49
            io.michaelrocks.libphonenumber.android.PhoneNumberUtil$MatchType r9 = r8.isNumberMatch(r7, r6)     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L49
            return r9
        L46:
            r1 = r2
            goto L49
        L48:
            r1 = r8
        L49:
            io.michaelrocks.libphonenumber.android.PhoneNumberUtil$MatchType r9 = io.michaelrocks.libphonenumber.android.PhoneNumberUtil.MatchType.NOT_A_NUMBER
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.isNumberMatch(java.lang.CharSequence, java.lang.CharSequence):io.michaelrocks.libphonenumber.android.PhoneNumberUtil$MatchType");
    }

    public MatchType isNumberMatch(Phonenumber.PhoneNumber firstNumber, CharSequence secondNumber) {
        try {
            return isNumberMatch(firstNumber, parse(secondNumber, UNKNOWN_REGION));
        } catch (NumberParseException e2) {
            if (e2.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                String regionCodeForCountryCode = getRegionCodeForCountryCode(firstNumber.getCountryCode());
                try {
                    if (!regionCodeForCountryCode.equals(UNKNOWN_REGION)) {
                        MatchType matchTypeIsNumberMatch = isNumberMatch(firstNumber, parse(secondNumber, regionCodeForCountryCode));
                        return matchTypeIsNumberMatch == MatchType.EXACT_MATCH ? MatchType.NSN_MATCH : matchTypeIsNumberMatch;
                    }
                    Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
                    try {
                        parseHelper(secondNumber, null, false, false, phoneNumber);
                        return isNumberMatch(firstNumber, phoneNumber);
                    } catch (NumberParseException unused) {
                        return MatchType.NOT_A_NUMBER;
                    }
                } catch (NumberParseException unused2) {
                    return MatchType.NOT_A_NUMBER;
                }
            }
            return MatchType.NOT_A_NUMBER;
        }
    }

    public boolean canBeInternationallyDialled(Phonenumber.PhoneNumber number) {
        if (getMetadataForRegion(getRegionCodeForNumber(number)) == null) {
            return true;
        }
        return !isNumberMatchingDesc(getNationalSignificantNumber(number), r0.getNoInternationalDialling());
    }

    public boolean isMobileNumberPortableRegion(String regionCode) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(regionCode);
        if (metadataForRegion == null) {
            logger.log(Level.WARNING, "Invalid or unknown region code provided: " + regionCode);
            return false;
        }
        return metadataForRegion.isMobileNumberPortableRegion();
    }
}
