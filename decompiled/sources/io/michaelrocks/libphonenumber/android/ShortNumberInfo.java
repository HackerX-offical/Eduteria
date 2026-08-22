package io.michaelrocks.libphonenumber.android;

import io.michaelrocks.libphonenumber.android.Phonemetadata;
import io.michaelrocks.libphonenumber.android.Phonenumber;
import io.michaelrocks.libphonenumber.android.internal.MatcherApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes9.dex */
public class ShortNumberInfo {
    private static final Set<String> REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT;
    private static final Logger logger = Logger.getLogger(ShortNumberInfo.class.getName());
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap = CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap();
    private final MatcherApi matcherApi;
    private final MetadataSource metadataSource;

    public enum ShortNumberCost {
        TOLL_FREE,
        STANDARD_RATE,
        PREMIUM_RATE,
        UNKNOWN_COST
    }

    static {
        HashSet hashSet = new HashSet();
        REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT = hashSet;
        hashSet.add("BR");
        hashSet.add("CL");
        hashSet.add("NI");
    }

    ShortNumberInfo(MetadataSource metadataSource, MatcherApi matcherApi) {
        this.metadataSource = metadataSource;
        this.matcherApi = matcherApi;
    }

    private List<String> getRegionCodesForCountryCode(int countryCallingCode) {
        List<String> arrayList = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(countryCallingCode));
        if (arrayList == null) {
            arrayList = new ArrayList<>(0);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private boolean regionDialingFromMatchesNumber(Phonenumber.PhoneNumber number, String regionDialingFrom) {
        return getRegionCodesForCountryCode(number.getCountryCode()).contains(regionDialingFrom);
    }

    public boolean isPossibleShortNumberForRegion(Phonenumber.PhoneNumber number, String regionDialingFrom) {
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion;
        if (regionDialingFromMatchesNumber(number, regionDialingFrom) && (shortNumberMetadataForRegion = this.metadataSource.getShortNumberMetadataForRegion(regionDialingFrom)) != null) {
            return shortNumberMetadataForRegion.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(getNationalSignificantNumber(number).length()));
        }
        return false;
    }

    public boolean isPossibleShortNumber(Phonenumber.PhoneNumber number) {
        List<String> regionCodesForCountryCode = getRegionCodesForCountryCode(number.getCountryCode());
        int length = getNationalSignificantNumber(number).length();
        Iterator<String> it = regionCodesForCountryCode.iterator();
        while (it.hasNext()) {
            Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = this.metadataSource.getShortNumberMetadataForRegion(it.next());
            if (shortNumberMetadataForRegion != null && shortNumberMetadataForRegion.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(length))) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidShortNumberForRegion(Phonenumber.PhoneNumber number, String regionDialingFrom) {
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion;
        if (!regionDialingFromMatchesNumber(number, regionDialingFrom) || (shortNumberMetadataForRegion = this.metadataSource.getShortNumberMetadataForRegion(regionDialingFrom)) == null) {
            return false;
        }
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        if (matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getGeneralDesc())) {
            return matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getShortCode());
        }
        return false;
    }

    public boolean isValidShortNumber(Phonenumber.PhoneNumber number) {
        List<String> regionCodesForCountryCode = getRegionCodesForCountryCode(number.getCountryCode());
        String regionCodeForShortNumberFromRegionList = getRegionCodeForShortNumberFromRegionList(number, regionCodesForCountryCode);
        if (regionCodesForCountryCode.size() <= 1 || regionCodeForShortNumberFromRegionList == null) {
            return isValidShortNumberForRegion(number, regionCodeForShortNumberFromRegionList);
        }
        return true;
    }

    public ShortNumberCost getExpectedCostForRegion(Phonenumber.PhoneNumber number, String regionDialingFrom) {
        if (!regionDialingFromMatchesNumber(number, regionDialingFrom)) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = this.metadataSource.getShortNumberMetadataForRegion(regionDialingFrom);
        if (shortNumberMetadataForRegion == null) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        if (!shortNumberMetadataForRegion.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(nationalSignificantNumber.length()))) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        if (matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getPremiumRate())) {
            return ShortNumberCost.PREMIUM_RATE;
        }
        if (matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getStandardRate())) {
            return ShortNumberCost.STANDARD_RATE;
        }
        if (matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getTollFree())) {
            return ShortNumberCost.TOLL_FREE;
        }
        if (isEmergencyNumber(nationalSignificantNumber, regionDialingFrom)) {
            return ShortNumberCost.TOLL_FREE;
        }
        return ShortNumberCost.UNKNOWN_COST;
    }

    public ShortNumberCost getExpectedCost(Phonenumber.PhoneNumber number) {
        List<String> regionCodesForCountryCode = getRegionCodesForCountryCode(number.getCountryCode());
        if (regionCodesForCountryCode.size() == 0) {
            return ShortNumberCost.UNKNOWN_COST;
        }
        if (regionCodesForCountryCode.size() == 1) {
            return getExpectedCostForRegion(number, regionCodesForCountryCode.get(0));
        }
        ShortNumberCost shortNumberCost = ShortNumberCost.TOLL_FREE;
        Iterator<String> it = regionCodesForCountryCode.iterator();
        while (it.hasNext()) {
            ShortNumberCost expectedCostForRegion = getExpectedCostForRegion(number, it.next());
            int i = AnonymousClass1.$SwitchMap$io$michaelrocks$libphonenumber$android$ShortNumberInfo$ShortNumberCost[expectedCostForRegion.ordinal()];
            if (i == 1) {
                return ShortNumberCost.PREMIUM_RATE;
            }
            if (i == 2) {
                shortNumberCost = ShortNumberCost.UNKNOWN_COST;
            } else if (i != 3) {
                if (i != 4) {
                    logger.log(Level.SEVERE, "Unrecognised cost for region: " + expectedCostForRegion);
                }
            } else if (shortNumberCost != ShortNumberCost.UNKNOWN_COST) {
                shortNumberCost = ShortNumberCost.STANDARD_RATE;
            }
        }
        return shortNumberCost;
    }

    /* JADX INFO: renamed from: io.michaelrocks.libphonenumber.android.ShortNumberInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$michaelrocks$libphonenumber$android$ShortNumberInfo$ShortNumberCost;

        static {
            int[] iArr = new int[ShortNumberCost.values().length];
            $SwitchMap$io$michaelrocks$libphonenumber$android$ShortNumberInfo$ShortNumberCost = iArr;
            try {
                iArr[ShortNumberCost.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$ShortNumberInfo$ShortNumberCost[ShortNumberCost.UNKNOWN_COST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$ShortNumberInfo$ShortNumberCost[ShortNumberCost.STANDARD_RATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$ShortNumberInfo$ShortNumberCost[ShortNumberCost.TOLL_FREE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private String getRegionCodeForShortNumberFromRegionList(Phonenumber.PhoneNumber number, List<String> regionCodes) {
        if (regionCodes.size() == 0) {
            return null;
        }
        if (regionCodes.size() == 1) {
            return regionCodes.get(0);
        }
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        for (String str : regionCodes) {
            Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = this.metadataSource.getShortNumberMetadataForRegion(str);
            if (shortNumberMetadataForRegion != null && matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getShortCode())) {
                return str;
            }
        }
        return null;
    }

    Set<String> getSupportedRegions() {
        return Collections.emptySet();
    }

    String getExampleShortNumber(String regionCode) {
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = this.metadataSource.getShortNumberMetadataForRegion(regionCode);
        if (shortNumberMetadataForRegion == null) {
            return "";
        }
        Phonemetadata.PhoneNumberDesc shortCode = shortNumberMetadataForRegion.getShortCode();
        if (!shortCode.hasExampleNumber()) {
            return "";
        }
        return shortCode.getExampleNumber();
    }

    String getExampleShortNumberForCost(String regionCode, ShortNumberCost cost) {
        Phonemetadata.PhoneNumberDesc premiumRate;
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = this.metadataSource.getShortNumberMetadataForRegion(regionCode);
        if (shortNumberMetadataForRegion == null) {
            return "";
        }
        int i = AnonymousClass1.$SwitchMap$io$michaelrocks$libphonenumber$android$ShortNumberInfo$ShortNumberCost[cost.ordinal()];
        if (i == 1) {
            premiumRate = shortNumberMetadataForRegion.getPremiumRate();
        } else if (i != 3) {
            premiumRate = i != 4 ? null : shortNumberMetadataForRegion.getTollFree();
        } else {
            premiumRate = shortNumberMetadataForRegion.getStandardRate();
        }
        if (premiumRate == null || !premiumRate.hasExampleNumber()) {
            return "";
        }
        return premiumRate.getExampleNumber();
    }

    public boolean connectsToEmergencyNumber(String number, String regionCode) {
        return matchesEmergencyNumberHelper(number, regionCode, true);
    }

    public boolean isEmergencyNumber(CharSequence number, String regionCode) {
        return matchesEmergencyNumberHelper(number, regionCode, false);
    }

    private boolean matchesEmergencyNumberHelper(CharSequence number, String regionCode, boolean allowPrefixMatch) {
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion;
        CharSequence charSequenceExtractPossibleNumber = PhoneNumberUtil.extractPossibleNumber(number);
        boolean z = false;
        if (PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(charSequenceExtractPossibleNumber).lookingAt() || (shortNumberMetadataForRegion = this.metadataSource.getShortNumberMetadataForRegion(regionCode)) == null || !shortNumberMetadataForRegion.hasEmergency()) {
            return false;
        }
        String strNormalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(charSequenceExtractPossibleNumber);
        if (allowPrefixMatch && !REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.contains(regionCode)) {
            z = true;
        }
        return this.matcherApi.matchNationalNumber(strNormalizeDigitsOnly, shortNumberMetadataForRegion.getEmergency(), z);
    }

    public boolean isCarrierSpecific(Phonenumber.PhoneNumber number) {
        String regionCodeForShortNumberFromRegionList = getRegionCodeForShortNumberFromRegionList(number, getRegionCodesForCountryCode(number.getCountryCode()));
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = this.metadataSource.getShortNumberMetadataForRegion(regionCodeForShortNumberFromRegionList);
        return shortNumberMetadataForRegion != null && matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getCarrierSpecific());
    }

    public boolean isCarrierSpecificForRegion(Phonenumber.PhoneNumber number, String regionDialingFrom) {
        if (!regionDialingFromMatchesNumber(number, regionDialingFrom)) {
            return false;
        }
        String nationalSignificantNumber = getNationalSignificantNumber(number);
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion = this.metadataSource.getShortNumberMetadataForRegion(regionDialingFrom);
        return shortNumberMetadataForRegion != null && matchesPossibleNumberAndNationalNumber(nationalSignificantNumber, shortNumberMetadataForRegion.getCarrierSpecific());
    }

    public boolean isSmsServiceForRegion(Phonenumber.PhoneNumber number, String regionDialingFrom) {
        Phonemetadata.PhoneMetadata shortNumberMetadataForRegion;
        return regionDialingFromMatchesNumber(number, regionDialingFrom) && (shortNumberMetadataForRegion = this.metadataSource.getShortNumberMetadataForRegion(regionDialingFrom)) != null && matchesPossibleNumberAndNationalNumber(getNationalSignificantNumber(number), shortNumberMetadataForRegion.getSmsServices());
    }

    private static String getNationalSignificantNumber(Phonenumber.PhoneNumber number) {
        StringBuilder sb = new StringBuilder();
        if (number.isItalianLeadingZero()) {
            char[] cArr = new char[number.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(number.getNationalNumber());
        return sb.toString();
    }

    private boolean matchesPossibleNumberAndNationalNumber(String number, Phonemetadata.PhoneNumberDesc numberDesc) {
        if (numberDesc.getPossibleLengthCount() <= 0 || numberDesc.getPossibleLengthList().contains(Integer.valueOf(number.length()))) {
            return this.matcherApi.matchNationalNumber(number, numberDesc, false);
        }
        return false;
    }
}
