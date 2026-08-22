package io.michaelrocks.libphonenumber.android;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class Phonemetadata {
    private Phonemetadata() {
    }

    public static class NumberFormat implements Externalizable {
        private static final long serialVersionUID = 1;
        private boolean hasDomesticCarrierCodeFormattingRule;
        private boolean hasFormat;
        private boolean hasNationalPrefixFormattingRule;
        private boolean hasNationalPrefixOptionalWhenFormatting;
        private boolean hasPattern;
        private String pattern_ = "";
        private String format_ = "";
        private List<String> leadingDigitsPattern_ = new ArrayList();
        private String nationalPrefixFormattingRule_ = "";
        private boolean nationalPrefixOptionalWhenFormatting_ = false;
        private String domesticCarrierCodeFormattingRule_ = "";

        public static final class Builder extends NumberFormat {
            public NumberFormat build() {
                return this;
            }

            public Builder mergeFrom(NumberFormat other) {
                if (other.hasPattern()) {
                    setPattern(other.getPattern());
                }
                if (other.hasFormat()) {
                    setFormat(other.getFormat());
                }
                for (int i = 0; i < other.leadingDigitsPatternSize(); i++) {
                    addLeadingDigitsPattern(other.getLeadingDigitsPattern(i));
                }
                if (other.hasNationalPrefixFormattingRule()) {
                    setNationalPrefixFormattingRule(other.getNationalPrefixFormattingRule());
                }
                if (other.hasDomesticCarrierCodeFormattingRule()) {
                    setDomesticCarrierCodeFormattingRule(other.getDomesticCarrierCodeFormattingRule());
                }
                if (other.hasNationalPrefixOptionalWhenFormatting()) {
                    setNationalPrefixOptionalWhenFormatting(other.getNationalPrefixOptionalWhenFormatting());
                }
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean hasPattern() {
            return this.hasPattern;
        }

        public String getPattern() {
            return this.pattern_;
        }

        public NumberFormat setPattern(String value) {
            this.hasPattern = true;
            this.pattern_ = value;
            return this;
        }

        public boolean hasFormat() {
            return this.hasFormat;
        }

        public String getFormat() {
            return this.format_;
        }

        public NumberFormat setFormat(String value) {
            this.hasFormat = true;
            this.format_ = value;
            return this;
        }

        public List<String> leadingDigitPatterns() {
            return this.leadingDigitsPattern_;
        }

        public int leadingDigitsPatternSize() {
            return this.leadingDigitsPattern_.size();
        }

        public String getLeadingDigitsPattern(int index) {
            return this.leadingDigitsPattern_.get(index);
        }

        public NumberFormat addLeadingDigitsPattern(String value) {
            value.getClass();
            this.leadingDigitsPattern_.add(value);
            return this;
        }

        public boolean hasNationalPrefixFormattingRule() {
            return this.hasNationalPrefixFormattingRule;
        }

        public String getNationalPrefixFormattingRule() {
            return this.nationalPrefixFormattingRule_;
        }

        public NumberFormat setNationalPrefixFormattingRule(String value) {
            this.hasNationalPrefixFormattingRule = true;
            this.nationalPrefixFormattingRule_ = value;
            return this;
        }

        public NumberFormat clearNationalPrefixFormattingRule() {
            this.hasNationalPrefixFormattingRule = false;
            this.nationalPrefixFormattingRule_ = "";
            return this;
        }

        public boolean hasNationalPrefixOptionalWhenFormatting() {
            return this.hasNationalPrefixOptionalWhenFormatting;
        }

        public boolean getNationalPrefixOptionalWhenFormatting() {
            return this.nationalPrefixOptionalWhenFormatting_;
        }

        public NumberFormat setNationalPrefixOptionalWhenFormatting(boolean value) {
            this.hasNationalPrefixOptionalWhenFormatting = true;
            this.nationalPrefixOptionalWhenFormatting_ = value;
            return this;
        }

        public boolean hasDomesticCarrierCodeFormattingRule() {
            return this.hasDomesticCarrierCodeFormattingRule;
        }

        public String getDomesticCarrierCodeFormattingRule() {
            return this.domesticCarrierCodeFormattingRule_;
        }

        public NumberFormat setDomesticCarrierCodeFormattingRule(String value) {
            this.hasDomesticCarrierCodeFormattingRule = true;
            this.domesticCarrierCodeFormattingRule_ = value;
            return this;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeUTF(this.pattern_);
            objectOutput.writeUTF(this.format_);
            int iLeadingDigitsPatternSize = leadingDigitsPatternSize();
            objectOutput.writeInt(iLeadingDigitsPatternSize);
            for (int i = 0; i < iLeadingDigitsPatternSize; i++) {
                objectOutput.writeUTF(this.leadingDigitsPattern_.get(i));
            }
            objectOutput.writeBoolean(this.hasNationalPrefixFormattingRule);
            if (this.hasNationalPrefixFormattingRule) {
                objectOutput.writeUTF(this.nationalPrefixFormattingRule_);
            }
            objectOutput.writeBoolean(this.hasDomesticCarrierCodeFormattingRule);
            if (this.hasDomesticCarrierCodeFormattingRule) {
                objectOutput.writeUTF(this.domesticCarrierCodeFormattingRule_);
            }
            objectOutput.writeBoolean(this.nationalPrefixOptionalWhenFormatting_);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            setPattern(objectInput.readUTF());
            setFormat(objectInput.readUTF());
            int i = objectInput.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                this.leadingDigitsPattern_.add(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setNationalPrefixFormattingRule(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setDomesticCarrierCodeFormattingRule(objectInput.readUTF());
            }
            setNationalPrefixOptionalWhenFormatting(objectInput.readBoolean());
        }
    }

    public static class PhoneNumberDesc implements Externalizable {
        private static final long serialVersionUID = 1;
        private boolean hasExampleNumber;
        private boolean hasNationalNumberPattern;
        private String nationalNumberPattern_ = "";
        private List<Integer> possibleLength_ = new ArrayList();
        private List<Integer> possibleLengthLocalOnly_ = new ArrayList();
        private String exampleNumber_ = "";

        public static final class Builder extends PhoneNumberDesc {
            public PhoneNumberDesc build() {
                return this;
            }

            public Builder mergeFrom(PhoneNumberDesc other) {
                if (other.hasNationalNumberPattern()) {
                    setNationalNumberPattern(other.getNationalNumberPattern());
                }
                for (int i = 0; i < other.getPossibleLengthCount(); i++) {
                    addPossibleLength(other.getPossibleLength(i));
                }
                for (int i2 = 0; i2 < other.getPossibleLengthLocalOnlyCount(); i2++) {
                    addPossibleLengthLocalOnly(other.getPossibleLengthLocalOnly(i2));
                }
                if (other.hasExampleNumber()) {
                    setExampleNumber(other.getExampleNumber());
                }
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean hasNationalNumberPattern() {
            return this.hasNationalNumberPattern;
        }

        public String getNationalNumberPattern() {
            return this.nationalNumberPattern_;
        }

        public PhoneNumberDesc setNationalNumberPattern(String value) {
            this.hasNationalNumberPattern = true;
            this.nationalNumberPattern_ = value;
            return this;
        }

        public PhoneNumberDesc clearNationalNumberPattern() {
            this.hasNationalNumberPattern = false;
            this.nationalNumberPattern_ = "";
            return this;
        }

        public List<Integer> getPossibleLengthList() {
            return this.possibleLength_;
        }

        public int getPossibleLengthCount() {
            return this.possibleLength_.size();
        }

        public int getPossibleLength(int index) {
            return this.possibleLength_.get(index).intValue();
        }

        public PhoneNumberDesc addPossibleLength(int value) {
            this.possibleLength_.add(Integer.valueOf(value));
            return this;
        }

        public PhoneNumberDesc clearPossibleLength() {
            this.possibleLength_.clear();
            return this;
        }

        public List<Integer> getPossibleLengthLocalOnlyList() {
            return this.possibleLengthLocalOnly_;
        }

        public int getPossibleLengthLocalOnlyCount() {
            return this.possibleLengthLocalOnly_.size();
        }

        public int getPossibleLengthLocalOnly(int index) {
            return this.possibleLengthLocalOnly_.get(index).intValue();
        }

        public PhoneNumberDesc addPossibleLengthLocalOnly(int value) {
            this.possibleLengthLocalOnly_.add(Integer.valueOf(value));
            return this;
        }

        public PhoneNumberDesc clearPossibleLengthLocalOnly() {
            this.possibleLengthLocalOnly_.clear();
            return this;
        }

        public boolean hasExampleNumber() {
            return this.hasExampleNumber;
        }

        public String getExampleNumber() {
            return this.exampleNumber_;
        }

        public PhoneNumberDesc setExampleNumber(String value) {
            this.hasExampleNumber = true;
            this.exampleNumber_ = value;
            return this;
        }

        public PhoneNumberDesc clearExampleNumber() {
            this.hasExampleNumber = false;
            this.exampleNumber_ = "";
            return this;
        }

        public boolean exactlySameAs(PhoneNumberDesc other) {
            return this.nationalNumberPattern_.equals(other.nationalNumberPattern_) && this.possibleLength_.equals(other.possibleLength_) && this.possibleLengthLocalOnly_.equals(other.possibleLengthLocalOnly_) && this.exampleNumber_.equals(other.exampleNumber_);
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeBoolean(this.hasNationalNumberPattern);
            if (this.hasNationalNumberPattern) {
                objectOutput.writeUTF(this.nationalNumberPattern_);
            }
            int possibleLengthCount = getPossibleLengthCount();
            objectOutput.writeInt(possibleLengthCount);
            for (int i = 0; i < possibleLengthCount; i++) {
                objectOutput.writeInt(this.possibleLength_.get(i).intValue());
            }
            int possibleLengthLocalOnlyCount = getPossibleLengthLocalOnlyCount();
            objectOutput.writeInt(possibleLengthLocalOnlyCount);
            for (int i2 = 0; i2 < possibleLengthLocalOnlyCount; i2++) {
                objectOutput.writeInt(this.possibleLengthLocalOnly_.get(i2).intValue());
            }
            objectOutput.writeBoolean(this.hasExampleNumber);
            if (this.hasExampleNumber) {
                objectOutput.writeUTF(this.exampleNumber_);
            }
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readBoolean()) {
                setNationalNumberPattern(objectInput.readUTF());
            }
            int i = objectInput.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                this.possibleLength_.add(Integer.valueOf(objectInput.readInt()));
            }
            int i3 = objectInput.readInt();
            for (int i4 = 0; i4 < i3; i4++) {
                this.possibleLengthLocalOnly_.add(Integer.valueOf(objectInput.readInt()));
            }
            if (objectInput.readBoolean()) {
                setExampleNumber(objectInput.readUTF());
            }
        }
    }

    public static class PhoneMetadata implements Externalizable {
        private static final long serialVersionUID = 1;
        private boolean hasCarrierSpecific;
        private boolean hasCountryCode;
        private boolean hasEmergency;
        private boolean hasFixedLine;
        private boolean hasGeneralDesc;
        private boolean hasId;
        private boolean hasInternationalPrefix;
        private boolean hasLeadingDigits;
        private boolean hasLeadingZeroPossible;
        private boolean hasMainCountryForCode;
        private boolean hasMobile;
        private boolean hasMobileNumberPortableRegion;
        private boolean hasNationalPrefix;
        private boolean hasNationalPrefixForParsing;
        private boolean hasNationalPrefixTransformRule;
        private boolean hasNoInternationalDialling;
        private boolean hasPager;
        private boolean hasPersonalNumber;
        private boolean hasPreferredExtnPrefix;
        private boolean hasPreferredInternationalPrefix;
        private boolean hasPremiumRate;
        private boolean hasSameMobileAndFixedLinePattern;
        private boolean hasSharedCost;
        private boolean hasShortCode;
        private boolean hasSmsServices;
        private boolean hasStandardRate;
        private boolean hasTollFree;
        private boolean hasUan;
        private boolean hasVoicemail;
        private boolean hasVoip;
        private PhoneNumberDesc generalDesc_ = null;
        private PhoneNumberDesc fixedLine_ = null;
        private PhoneNumberDesc mobile_ = null;
        private PhoneNumberDesc tollFree_ = null;
        private PhoneNumberDesc premiumRate_ = null;
        private PhoneNumberDesc sharedCost_ = null;
        private PhoneNumberDesc personalNumber_ = null;
        private PhoneNumberDesc voip_ = null;
        private PhoneNumberDesc pager_ = null;
        private PhoneNumberDesc uan_ = null;
        private PhoneNumberDesc emergency_ = null;
        private PhoneNumberDesc voicemail_ = null;
        private PhoneNumberDesc shortCode_ = null;
        private PhoneNumberDesc standardRate_ = null;
        private PhoneNumberDesc carrierSpecific_ = null;
        private PhoneNumberDesc smsServices_ = null;
        private PhoneNumberDesc noInternationalDialling_ = null;
        private String id_ = "";
        private int countryCode_ = 0;
        private String internationalPrefix_ = "";
        private String preferredInternationalPrefix_ = "";
        private String nationalPrefix_ = "";
        private String preferredExtnPrefix_ = "";
        private String nationalPrefixForParsing_ = "";
        private String nationalPrefixTransformRule_ = "";
        private boolean sameMobileAndFixedLinePattern_ = false;
        private List<NumberFormat> numberFormat_ = new ArrayList();
        private List<NumberFormat> intlNumberFormat_ = new ArrayList();
        private boolean mainCountryForCode_ = false;
        private String leadingDigits_ = "";
        private boolean leadingZeroPossible_ = false;
        private boolean mobileNumberPortableRegion_ = false;

        public static final class Builder extends PhoneMetadata {
            public PhoneMetadata build() {
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean hasGeneralDesc() {
            return this.hasGeneralDesc;
        }

        public PhoneNumberDesc getGeneralDesc() {
            return this.generalDesc_;
        }

        public PhoneMetadata setGeneralDesc(PhoneNumberDesc value) {
            value.getClass();
            this.hasGeneralDesc = true;
            this.generalDesc_ = value;
            return this;
        }

        public boolean hasFixedLine() {
            return this.hasFixedLine;
        }

        public PhoneNumberDesc getFixedLine() {
            return this.fixedLine_;
        }

        public PhoneMetadata setFixedLine(PhoneNumberDesc value) {
            value.getClass();
            this.hasFixedLine = true;
            this.fixedLine_ = value;
            return this;
        }

        public boolean hasMobile() {
            return this.hasMobile;
        }

        public PhoneNumberDesc getMobile() {
            return this.mobile_;
        }

        public PhoneMetadata setMobile(PhoneNumberDesc value) {
            value.getClass();
            this.hasMobile = true;
            this.mobile_ = value;
            return this;
        }

        public boolean hasTollFree() {
            return this.hasTollFree;
        }

        public PhoneNumberDesc getTollFree() {
            return this.tollFree_;
        }

        public PhoneMetadata setTollFree(PhoneNumberDesc value) {
            value.getClass();
            this.hasTollFree = true;
            this.tollFree_ = value;
            return this;
        }

        public boolean hasPremiumRate() {
            return this.hasPremiumRate;
        }

        public PhoneNumberDesc getPremiumRate() {
            return this.premiumRate_;
        }

        public PhoneMetadata setPremiumRate(PhoneNumberDesc value) {
            value.getClass();
            this.hasPremiumRate = true;
            this.premiumRate_ = value;
            return this;
        }

        public boolean hasSharedCost() {
            return this.hasSharedCost;
        }

        public PhoneNumberDesc getSharedCost() {
            return this.sharedCost_;
        }

        public PhoneMetadata setSharedCost(PhoneNumberDesc value) {
            value.getClass();
            this.hasSharedCost = true;
            this.sharedCost_ = value;
            return this;
        }

        public boolean hasPersonalNumber() {
            return this.hasPersonalNumber;
        }

        public PhoneNumberDesc getPersonalNumber() {
            return this.personalNumber_;
        }

        public PhoneMetadata setPersonalNumber(PhoneNumberDesc value) {
            value.getClass();
            this.hasPersonalNumber = true;
            this.personalNumber_ = value;
            return this;
        }

        public boolean hasVoip() {
            return this.hasVoip;
        }

        public PhoneNumberDesc getVoip() {
            return this.voip_;
        }

        public PhoneMetadata setVoip(PhoneNumberDesc value) {
            value.getClass();
            this.hasVoip = true;
            this.voip_ = value;
            return this;
        }

        public boolean hasPager() {
            return this.hasPager;
        }

        public PhoneNumberDesc getPager() {
            return this.pager_;
        }

        public PhoneMetadata setPager(PhoneNumberDesc value) {
            value.getClass();
            this.hasPager = true;
            this.pager_ = value;
            return this;
        }

        public boolean hasUan() {
            return this.hasUan;
        }

        public PhoneNumberDesc getUan() {
            return this.uan_;
        }

        public PhoneMetadata setUan(PhoneNumberDesc value) {
            value.getClass();
            this.hasUan = true;
            this.uan_ = value;
            return this;
        }

        public boolean hasEmergency() {
            return this.hasEmergency;
        }

        public PhoneNumberDesc getEmergency() {
            return this.emergency_;
        }

        public PhoneMetadata setEmergency(PhoneNumberDesc value) {
            value.getClass();
            this.hasEmergency = true;
            this.emergency_ = value;
            return this;
        }

        public boolean hasVoicemail() {
            return this.hasVoicemail;
        }

        public PhoneNumberDesc getVoicemail() {
            return this.voicemail_;
        }

        public PhoneMetadata setVoicemail(PhoneNumberDesc value) {
            value.getClass();
            this.hasVoicemail = true;
            this.voicemail_ = value;
            return this;
        }

        public boolean hasShortCode() {
            return this.hasShortCode;
        }

        public PhoneNumberDesc getShortCode() {
            return this.shortCode_;
        }

        public PhoneMetadata setShortCode(PhoneNumberDesc value) {
            value.getClass();
            this.hasShortCode = true;
            this.shortCode_ = value;
            return this;
        }

        public boolean hasStandardRate() {
            return this.hasStandardRate;
        }

        public PhoneNumberDesc getStandardRate() {
            return this.standardRate_;
        }

        public PhoneMetadata setStandardRate(PhoneNumberDesc value) {
            value.getClass();
            this.hasStandardRate = true;
            this.standardRate_ = value;
            return this;
        }

        public boolean hasCarrierSpecific() {
            return this.hasCarrierSpecific;
        }

        public PhoneNumberDesc getCarrierSpecific() {
            return this.carrierSpecific_;
        }

        public PhoneMetadata setCarrierSpecific(PhoneNumberDesc value) {
            value.getClass();
            this.hasCarrierSpecific = true;
            this.carrierSpecific_ = value;
            return this;
        }

        public boolean hasSmsServices() {
            return this.hasSmsServices;
        }

        public PhoneNumberDesc getSmsServices() {
            return this.smsServices_;
        }

        public PhoneMetadata setSmsServices(PhoneNumberDesc value) {
            value.getClass();
            this.hasSmsServices = true;
            this.smsServices_ = value;
            return this;
        }

        public boolean hasNoInternationalDialling() {
            return this.hasNoInternationalDialling;
        }

        public PhoneNumberDesc getNoInternationalDialling() {
            return this.noInternationalDialling_;
        }

        public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc value) {
            value.getClass();
            this.hasNoInternationalDialling = true;
            this.noInternationalDialling_ = value;
            return this;
        }

        public boolean hasId() {
            return this.hasId;
        }

        public String getId() {
            return this.id_;
        }

        public PhoneMetadata setId(String value) {
            this.hasId = true;
            this.id_ = value;
            return this;
        }

        public boolean hasCountryCode() {
            return this.hasCountryCode;
        }

        public int getCountryCode() {
            return this.countryCode_;
        }

        public PhoneMetadata setCountryCode(int value) {
            this.hasCountryCode = true;
            this.countryCode_ = value;
            return this;
        }

        public boolean hasInternationalPrefix() {
            return this.hasInternationalPrefix;
        }

        public String getInternationalPrefix() {
            return this.internationalPrefix_;
        }

        public PhoneMetadata setInternationalPrefix(String value) {
            this.hasInternationalPrefix = true;
            this.internationalPrefix_ = value;
            return this;
        }

        public boolean hasPreferredInternationalPrefix() {
            return this.hasPreferredInternationalPrefix;
        }

        public String getPreferredInternationalPrefix() {
            return this.preferredInternationalPrefix_;
        }

        public PhoneMetadata setPreferredInternationalPrefix(String value) {
            this.hasPreferredInternationalPrefix = true;
            this.preferredInternationalPrefix_ = value;
            return this;
        }

        public PhoneMetadata clearPreferredInternationalPrefix() {
            this.hasPreferredInternationalPrefix = false;
            this.preferredInternationalPrefix_ = "";
            return this;
        }

        public boolean hasNationalPrefix() {
            return this.hasNationalPrefix;
        }

        public String getNationalPrefix() {
            return this.nationalPrefix_;
        }

        public PhoneMetadata setNationalPrefix(String value) {
            this.hasNationalPrefix = true;
            this.nationalPrefix_ = value;
            return this;
        }

        public PhoneMetadata clearNationalPrefix() {
            this.hasNationalPrefix = false;
            this.nationalPrefix_ = "";
            return this;
        }

        public boolean hasPreferredExtnPrefix() {
            return this.hasPreferredExtnPrefix;
        }

        public String getPreferredExtnPrefix() {
            return this.preferredExtnPrefix_;
        }

        public PhoneMetadata setPreferredExtnPrefix(String value) {
            this.hasPreferredExtnPrefix = true;
            this.preferredExtnPrefix_ = value;
            return this;
        }

        public PhoneMetadata clearPreferredExtnPrefix() {
            this.hasPreferredExtnPrefix = false;
            this.preferredExtnPrefix_ = "";
            return this;
        }

        public boolean hasNationalPrefixForParsing() {
            return this.hasNationalPrefixForParsing;
        }

        public String getNationalPrefixForParsing() {
            return this.nationalPrefixForParsing_;
        }

        public PhoneMetadata setNationalPrefixForParsing(String value) {
            this.hasNationalPrefixForParsing = true;
            this.nationalPrefixForParsing_ = value;
            return this;
        }

        public boolean hasNationalPrefixTransformRule() {
            return this.hasNationalPrefixTransformRule;
        }

        public String getNationalPrefixTransformRule() {
            return this.nationalPrefixTransformRule_;
        }

        public PhoneMetadata setNationalPrefixTransformRule(String value) {
            this.hasNationalPrefixTransformRule = true;
            this.nationalPrefixTransformRule_ = value;
            return this;
        }

        public PhoneMetadata clearNationalPrefixTransformRule() {
            this.hasNationalPrefixTransformRule = false;
            this.nationalPrefixTransformRule_ = "";
            return this;
        }

        public boolean hasSameMobileAndFixedLinePattern() {
            return this.hasSameMobileAndFixedLinePattern;
        }

        public boolean getSameMobileAndFixedLinePattern() {
            return this.sameMobileAndFixedLinePattern_;
        }

        public PhoneMetadata setSameMobileAndFixedLinePattern(boolean value) {
            this.hasSameMobileAndFixedLinePattern = true;
            this.sameMobileAndFixedLinePattern_ = value;
            return this;
        }

        public PhoneMetadata clearSameMobileAndFixedLinePattern() {
            this.hasSameMobileAndFixedLinePattern = false;
            this.sameMobileAndFixedLinePattern_ = false;
            return this;
        }

        public List<NumberFormat> numberFormats() {
            return this.numberFormat_;
        }

        public int numberFormatSize() {
            return this.numberFormat_.size();
        }

        public NumberFormat getNumberFormat(int index) {
            return this.numberFormat_.get(index);
        }

        public PhoneMetadata addNumberFormat(NumberFormat value) {
            value.getClass();
            this.numberFormat_.add(value);
            return this;
        }

        public List<NumberFormat> intlNumberFormats() {
            return this.intlNumberFormat_;
        }

        public int intlNumberFormatSize() {
            return this.intlNumberFormat_.size();
        }

        public NumberFormat getIntlNumberFormat(int index) {
            return this.intlNumberFormat_.get(index);
        }

        public PhoneMetadata addIntlNumberFormat(NumberFormat value) {
            value.getClass();
            this.intlNumberFormat_.add(value);
            return this;
        }

        public PhoneMetadata clearIntlNumberFormat() {
            this.intlNumberFormat_.clear();
            return this;
        }

        public boolean hasMainCountryForCode() {
            return this.hasMainCountryForCode;
        }

        public boolean isMainCountryForCode() {
            return this.mainCountryForCode_;
        }

        public boolean getMainCountryForCode() {
            return this.mainCountryForCode_;
        }

        public PhoneMetadata setMainCountryForCode(boolean value) {
            this.hasMainCountryForCode = true;
            this.mainCountryForCode_ = value;
            return this;
        }

        public PhoneMetadata clearMainCountryForCode() {
            this.hasMainCountryForCode = false;
            this.mainCountryForCode_ = false;
            return this;
        }

        public boolean hasLeadingDigits() {
            return this.hasLeadingDigits;
        }

        public String getLeadingDigits() {
            return this.leadingDigits_;
        }

        public PhoneMetadata setLeadingDigits(String value) {
            this.hasLeadingDigits = true;
            this.leadingDigits_ = value;
            return this;
        }

        public boolean hasLeadingZeroPossible() {
            return this.hasLeadingZeroPossible;
        }

        public boolean isLeadingZeroPossible() {
            return this.leadingZeroPossible_;
        }

        public PhoneMetadata setLeadingZeroPossible(boolean value) {
            this.hasLeadingZeroPossible = true;
            this.leadingZeroPossible_ = value;
            return this;
        }

        public PhoneMetadata clearLeadingZeroPossible() {
            this.hasLeadingZeroPossible = false;
            this.leadingZeroPossible_ = false;
            return this;
        }

        public boolean hasMobileNumberPortableRegion() {
            return this.hasMobileNumberPortableRegion;
        }

        public boolean isMobileNumberPortableRegion() {
            return this.mobileNumberPortableRegion_;
        }

        public PhoneMetadata setMobileNumberPortableRegion(boolean value) {
            this.hasMobileNumberPortableRegion = true;
            this.mobileNumberPortableRegion_ = value;
            return this;
        }

        public PhoneMetadata clearMobileNumberPortableRegion() {
            this.hasMobileNumberPortableRegion = false;
            this.mobileNumberPortableRegion_ = false;
            return this;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeBoolean(this.hasGeneralDesc);
            if (this.hasGeneralDesc) {
                this.generalDesc_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasFixedLine);
            if (this.hasFixedLine) {
                this.fixedLine_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasMobile);
            if (this.hasMobile) {
                this.mobile_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasTollFree);
            if (this.hasTollFree) {
                this.tollFree_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPremiumRate);
            if (this.hasPremiumRate) {
                this.premiumRate_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasSharedCost);
            if (this.hasSharedCost) {
                this.sharedCost_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPersonalNumber);
            if (this.hasPersonalNumber) {
                this.personalNumber_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasVoip);
            if (this.hasVoip) {
                this.voip_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasPager);
            if (this.hasPager) {
                this.pager_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasUan);
            if (this.hasUan) {
                this.uan_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasEmergency);
            if (this.hasEmergency) {
                this.emergency_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasVoicemail);
            if (this.hasVoicemail) {
                this.voicemail_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasShortCode);
            if (this.hasShortCode) {
                this.shortCode_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasStandardRate);
            if (this.hasStandardRate) {
                this.standardRate_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasCarrierSpecific);
            if (this.hasCarrierSpecific) {
                this.carrierSpecific_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasSmsServices);
            if (this.hasSmsServices) {
                this.smsServices_.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.hasNoInternationalDialling);
            if (this.hasNoInternationalDialling) {
                this.noInternationalDialling_.writeExternal(objectOutput);
            }
            objectOutput.writeUTF(this.id_);
            objectOutput.writeInt(this.countryCode_);
            objectOutput.writeUTF(this.internationalPrefix_);
            objectOutput.writeBoolean(this.hasPreferredInternationalPrefix);
            if (this.hasPreferredInternationalPrefix) {
                objectOutput.writeUTF(this.preferredInternationalPrefix_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefix);
            if (this.hasNationalPrefix) {
                objectOutput.writeUTF(this.nationalPrefix_);
            }
            objectOutput.writeBoolean(this.hasPreferredExtnPrefix);
            if (this.hasPreferredExtnPrefix) {
                objectOutput.writeUTF(this.preferredExtnPrefix_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefixForParsing);
            if (this.hasNationalPrefixForParsing) {
                objectOutput.writeUTF(this.nationalPrefixForParsing_);
            }
            objectOutput.writeBoolean(this.hasNationalPrefixTransformRule);
            if (this.hasNationalPrefixTransformRule) {
                objectOutput.writeUTF(this.nationalPrefixTransformRule_);
            }
            objectOutput.writeBoolean(this.sameMobileAndFixedLinePattern_);
            int iNumberFormatSize = numberFormatSize();
            objectOutput.writeInt(iNumberFormatSize);
            for (int i = 0; i < iNumberFormatSize; i++) {
                this.numberFormat_.get(i).writeExternal(objectOutput);
            }
            int iIntlNumberFormatSize = intlNumberFormatSize();
            objectOutput.writeInt(iIntlNumberFormatSize);
            for (int i2 = 0; i2 < iIntlNumberFormatSize; i2++) {
                this.intlNumberFormat_.get(i2).writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.mainCountryForCode_);
            objectOutput.writeBoolean(this.hasLeadingDigits);
            if (this.hasLeadingDigits) {
                objectOutput.writeUTF(this.leadingDigits_);
            }
            objectOutput.writeBoolean(this.leadingZeroPossible_);
            objectOutput.writeBoolean(this.mobileNumberPortableRegion_);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setGeneralDesc(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc2 = new PhoneNumberDesc();
                phoneNumberDesc2.readExternal(objectInput);
                setFixedLine(phoneNumberDesc2);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc3 = new PhoneNumberDesc();
                phoneNumberDesc3.readExternal(objectInput);
                setMobile(phoneNumberDesc3);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc4 = new PhoneNumberDesc();
                phoneNumberDesc4.readExternal(objectInput);
                setTollFree(phoneNumberDesc4);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc5 = new PhoneNumberDesc();
                phoneNumberDesc5.readExternal(objectInput);
                setPremiumRate(phoneNumberDesc5);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc6 = new PhoneNumberDesc();
                phoneNumberDesc6.readExternal(objectInput);
                setSharedCost(phoneNumberDesc6);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc7 = new PhoneNumberDesc();
                phoneNumberDesc7.readExternal(objectInput);
                setPersonalNumber(phoneNumberDesc7);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc8 = new PhoneNumberDesc();
                phoneNumberDesc8.readExternal(objectInput);
                setVoip(phoneNumberDesc8);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc9 = new PhoneNumberDesc();
                phoneNumberDesc9.readExternal(objectInput);
                setPager(phoneNumberDesc9);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc10 = new PhoneNumberDesc();
                phoneNumberDesc10.readExternal(objectInput);
                setUan(phoneNumberDesc10);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc11 = new PhoneNumberDesc();
                phoneNumberDesc11.readExternal(objectInput);
                setEmergency(phoneNumberDesc11);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc12 = new PhoneNumberDesc();
                phoneNumberDesc12.readExternal(objectInput);
                setVoicemail(phoneNumberDesc12);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc13 = new PhoneNumberDesc();
                phoneNumberDesc13.readExternal(objectInput);
                setShortCode(phoneNumberDesc13);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc14 = new PhoneNumberDesc();
                phoneNumberDesc14.readExternal(objectInput);
                setStandardRate(phoneNumberDesc14);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc15 = new PhoneNumberDesc();
                phoneNumberDesc15.readExternal(objectInput);
                setCarrierSpecific(phoneNumberDesc15);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc16 = new PhoneNumberDesc();
                phoneNumberDesc16.readExternal(objectInput);
                setSmsServices(phoneNumberDesc16);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc17 = new PhoneNumberDesc();
                phoneNumberDesc17.readExternal(objectInput);
                setNoInternationalDialling(phoneNumberDesc17);
            }
            setId(objectInput.readUTF());
            setCountryCode(objectInput.readInt());
            setInternationalPrefix(objectInput.readUTF());
            if (objectInput.readBoolean()) {
                setPreferredInternationalPrefix(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setNationalPrefix(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setPreferredExtnPrefix(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setNationalPrefixForParsing(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setNationalPrefixTransformRule(objectInput.readUTF());
            }
            setSameMobileAndFixedLinePattern(objectInput.readBoolean());
            int i = objectInput.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                NumberFormat numberFormat = new NumberFormat();
                numberFormat.readExternal(objectInput);
                this.numberFormat_.add(numberFormat);
            }
            int i3 = objectInput.readInt();
            for (int i4 = 0; i4 < i3; i4++) {
                NumberFormat numberFormat2 = new NumberFormat();
                numberFormat2.readExternal(objectInput);
                this.intlNumberFormat_.add(numberFormat2);
            }
            setMainCountryForCode(objectInput.readBoolean());
            if (objectInput.readBoolean()) {
                setLeadingDigits(objectInput.readUTF());
            }
            setLeadingZeroPossible(objectInput.readBoolean());
            setMobileNumberPortableRegion(objectInput.readBoolean());
        }
    }

    public static class PhoneMetadataCollection implements Externalizable {
        private static final long serialVersionUID = 1;
        private List<PhoneMetadata> metadata_ = new ArrayList();

        public static final class Builder extends PhoneMetadataCollection {
            public PhoneMetadataCollection build() {
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public List<PhoneMetadata> getMetadataList() {
            return this.metadata_;
        }

        public int getMetadataCount() {
            return this.metadata_.size();
        }

        public PhoneMetadataCollection addMetadata(PhoneMetadata value) {
            value.getClass();
            this.metadata_.add(value);
            return this;
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            int metadataCount = getMetadataCount();
            objectOutput.writeInt(metadataCount);
            for (int i = 0; i < metadataCount; i++) {
                this.metadata_.get(i).writeExternal(objectOutput);
            }
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) throws IOException {
            int i = objectInput.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                PhoneMetadata phoneMetadata = new PhoneMetadata();
                phoneMetadata.readExternal(objectInput);
                this.metadata_.add(phoneMetadata);
            }
        }

        public PhoneMetadataCollection clear() {
            this.metadata_.clear();
            return this;
        }
    }
}
