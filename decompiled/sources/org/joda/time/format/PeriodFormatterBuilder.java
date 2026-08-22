package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;
import org.joda.time.DurationFieldType;
import org.joda.time.PeriodType;
import org.joda.time.ReadWritablePeriod;
import org.joda.time.ReadablePeriod;

/* JADX INFO: loaded from: classes10.dex */
public class PeriodFormatterBuilder {
    private static final int DAYS = 3;
    private static final int HOURS = 4;
    private static final int MAX_FIELD = 9;
    private static final int MILLIS = 7;
    private static final int MINUTES = 5;
    private static final int MONTHS = 1;
    private static final ConcurrentMap<String, Pattern> PATTERNS = new ConcurrentHashMap();
    private static final int PRINT_ZERO_ALWAYS = 4;
    private static final int PRINT_ZERO_IF_SUPPORTED = 3;
    private static final int PRINT_ZERO_NEVER = 5;
    private static final int PRINT_ZERO_RARELY_FIRST = 1;
    private static final int PRINT_ZERO_RARELY_LAST = 2;
    private static final int SECONDS = 6;
    private static final int SECONDS_MILLIS = 8;
    private static final int SECONDS_OPTIONAL_MILLIS = 9;
    private static final int WEEKS = 2;
    private static final int YEARS = 0;
    private List<Object> iElementPairs;
    private FieldFormatter[] iFieldFormatters;
    private int iMaxParsedDigits;
    private int iMinPrintedDigits;
    private boolean iNotParser;
    private boolean iNotPrinter;
    private PeriodFieldAffix iPrefix;
    private int iPrintZeroSetting;
    private boolean iRejectSignedValues;

    interface PeriodFieldAffix {
        int calculatePrintedLength(int i);

        void finish(Set<PeriodFieldAffix> set);

        String[] getAffixes();

        int parse(String str, int i);

        void printTo(Writer writer, int i) throws IOException;

        void printTo(StringBuffer stringBuffer, int i);

        int scan(String str, int i);
    }

    public PeriodFormatterBuilder() {
        clear();
    }

    public PeriodFormatter toFormatter() {
        PeriodFormatter formatter = toFormatter(this.iElementPairs, this.iNotPrinter, this.iNotParser);
        for (FieldFormatter fieldFormatter : this.iFieldFormatters) {
            if (fieldFormatter != null) {
                fieldFormatter.finish(this.iFieldFormatters);
            }
        }
        this.iFieldFormatters = (FieldFormatter[]) this.iFieldFormatters.clone();
        return formatter;
    }

    public PeriodPrinter toPrinter() {
        if (this.iNotPrinter) {
            return null;
        }
        return toFormatter().getPrinter();
    }

    public PeriodParser toParser() {
        if (this.iNotParser) {
            return null;
        }
        return toFormatter().getParser();
    }

    public void clear() {
        this.iMinPrintedDigits = 1;
        this.iPrintZeroSetting = 2;
        this.iMaxParsedDigits = 10;
        this.iRejectSignedValues = false;
        this.iPrefix = null;
        List<Object> list = this.iElementPairs;
        if (list == null) {
            this.iElementPairs = new ArrayList();
        } else {
            list.clear();
        }
        this.iNotPrinter = false;
        this.iNotParser = false;
        this.iFieldFormatters = new FieldFormatter[10];
    }

    public PeriodFormatterBuilder append(PeriodFormatter periodFormatter) {
        if (periodFormatter == null) {
            throw new IllegalArgumentException("No formatter supplied");
        }
        clearPrefix();
        append0(periodFormatter.getPrinter(), periodFormatter.getParser());
        return this;
    }

    public PeriodFormatterBuilder append(PeriodPrinter periodPrinter, PeriodParser periodParser) {
        if (periodPrinter == null && periodParser == null) {
            throw new IllegalArgumentException("No printer or parser supplied");
        }
        clearPrefix();
        append0(periodPrinter, periodParser);
        return this;
    }

    public PeriodFormatterBuilder appendLiteral(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Literal must not be null");
        }
        clearPrefix();
        Literal literal = new Literal(str);
        append0(literal, literal);
        return this;
    }

    public PeriodFormatterBuilder minimumPrintedDigits(int i) {
        this.iMinPrintedDigits = i;
        return this;
    }

    public PeriodFormatterBuilder maximumParsedDigits(int i) {
        this.iMaxParsedDigits = i;
        return this;
    }

    public PeriodFormatterBuilder rejectSignedValues(boolean z) {
        this.iRejectSignedValues = z;
        return this;
    }

    public PeriodFormatterBuilder printZeroRarelyLast() {
        this.iPrintZeroSetting = 2;
        return this;
    }

    public PeriodFormatterBuilder printZeroRarelyFirst() {
        this.iPrintZeroSetting = 1;
        return this;
    }

    public PeriodFormatterBuilder printZeroIfSupported() {
        this.iPrintZeroSetting = 3;
        return this;
    }

    public PeriodFormatterBuilder printZeroAlways() {
        this.iPrintZeroSetting = 4;
        return this;
    }

    public PeriodFormatterBuilder printZeroNever() {
        this.iPrintZeroSetting = 5;
        return this;
    }

    public PeriodFormatterBuilder appendPrefix(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        return appendPrefix(new SimpleAffix(str));
    }

    public PeriodFormatterBuilder appendPrefix(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException();
        }
        return appendPrefix(new PluralAffix(str, str2));
    }

    public PeriodFormatterBuilder appendPrefix(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length < 1 || strArr.length != strArr2.length) {
            throw new IllegalArgumentException();
        }
        return appendPrefix(new RegExAffix(strArr, strArr2));
    }

    private PeriodFormatterBuilder appendPrefix(PeriodFieldAffix periodFieldAffix) {
        if (periodFieldAffix == null) {
            throw new IllegalArgumentException();
        }
        if (this.iPrefix != null) {
            periodFieldAffix = new CompositeAffix(this.iPrefix, periodFieldAffix);
        }
        this.iPrefix = periodFieldAffix;
        return this;
    }

    public PeriodFormatterBuilder appendYears() {
        appendField(0);
        return this;
    }

    public PeriodFormatterBuilder appendMonths() {
        appendField(1);
        return this;
    }

    public PeriodFormatterBuilder appendWeeks() {
        appendField(2);
        return this;
    }

    public PeriodFormatterBuilder appendDays() {
        appendField(3);
        return this;
    }

    public PeriodFormatterBuilder appendHours() {
        appendField(4);
        return this;
    }

    public PeriodFormatterBuilder appendMinutes() {
        appendField(5);
        return this;
    }

    public PeriodFormatterBuilder appendSeconds() {
        appendField(6);
        return this;
    }

    public PeriodFormatterBuilder appendSecondsWithMillis() {
        appendField(8);
        return this;
    }

    public PeriodFormatterBuilder appendSecondsWithOptionalMillis() {
        appendField(9);
        return this;
    }

    public PeriodFormatterBuilder appendMillis() {
        appendField(7);
        return this;
    }

    public PeriodFormatterBuilder appendMillis3Digit() {
        appendField(7, 3);
        return this;
    }

    private void appendField(int i) {
        appendField(i, this.iMinPrintedDigits);
    }

    private void appendField(int i, int i2) {
        FieldFormatter fieldFormatter = new FieldFormatter(i2, this.iPrintZeroSetting, this.iMaxParsedDigits, this.iRejectSignedValues, i, this.iFieldFormatters, this.iPrefix, null);
        append0(fieldFormatter, fieldFormatter);
        this.iFieldFormatters[i] = fieldFormatter;
        this.iPrefix = null;
    }

    public PeriodFormatterBuilder appendSuffix(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        return appendSuffix(new SimpleAffix(str));
    }

    public PeriodFormatterBuilder appendSuffix(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException();
        }
        return appendSuffix(new PluralAffix(str, str2));
    }

    public PeriodFormatterBuilder appendSuffix(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length < 1 || strArr.length != strArr2.length) {
            throw new IllegalArgumentException();
        }
        return appendSuffix(new RegExAffix(strArr, strArr2));
    }

    private PeriodFormatterBuilder appendSuffix(PeriodFieldAffix periodFieldAffix) {
        Object obj;
        Object obj2;
        if (this.iElementPairs.size() > 0) {
            obj = this.iElementPairs.get(r0.size() - 2);
            obj2 = this.iElementPairs.get(r1.size() - 1);
        } else {
            obj = null;
            obj2 = null;
        }
        if (obj == null || obj2 == null || obj != obj2 || !(obj instanceof FieldFormatter)) {
            throw new IllegalStateException("No field to apply suffix to");
        }
        clearPrefix();
        FieldFormatter fieldFormatter = new FieldFormatter((FieldFormatter) obj, periodFieldAffix);
        this.iElementPairs.set(r4.size() - 2, fieldFormatter);
        this.iElementPairs.set(r4.size() - 1, fieldFormatter);
        this.iFieldFormatters[fieldFormatter.getFieldType()] = fieldFormatter;
        return this;
    }

    public PeriodFormatterBuilder appendSeparator(String str) {
        return appendSeparator(str, str, null, true, true);
    }

    public PeriodFormatterBuilder appendSeparatorIfFieldsAfter(String str) {
        return appendSeparator(str, str, null, false, true);
    }

    public PeriodFormatterBuilder appendSeparatorIfFieldsBefore(String str) {
        return appendSeparator(str, str, null, true, false);
    }

    public PeriodFormatterBuilder appendSeparator(String str, String str2) {
        return appendSeparator(str, str2, null, true, true);
    }

    public PeriodFormatterBuilder appendSeparator(String str, String str2, String[] strArr) {
        return appendSeparator(str, str2, strArr, true, true);
    }

    private PeriodFormatterBuilder appendSeparator(String str, String str2, String[] strArr, boolean z, boolean z2) {
        Separator separator;
        if (str == null || str2 == null) {
            throw new IllegalArgumentException();
        }
        clearPrefix();
        List<Object> listSubList = this.iElementPairs;
        if (listSubList.size() == 0) {
            if (z2 && !z) {
                Separator separator2 = new Separator(str, str2, strArr, Literal.EMPTY, Literal.EMPTY, z, z2);
                append0(separator2, separator2);
            }
            return this;
        }
        int size = listSubList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                separator = null;
                break;
            }
            if (listSubList.get(i) instanceof Separator) {
                separator = (Separator) listSubList.get(i);
                listSubList = listSubList.subList(size, listSubList.size());
                break;
            }
            size -= 2;
        }
        if (separator != null && listSubList.size() == 0) {
            throw new IllegalStateException("Cannot have two adjacent separators");
        }
        Object[] objArrCreateComposite = createComposite(listSubList);
        listSubList.clear();
        Separator separator3 = new Separator(str, str2, strArr, (PeriodPrinter) objArrCreateComposite[0], (PeriodParser) objArrCreateComposite[1], z, z2);
        listSubList.add(separator3);
        listSubList.add(separator3);
        return this;
    }

    private void clearPrefix() throws IllegalStateException {
        if (this.iPrefix != null) {
            throw new IllegalStateException("Prefix not followed by field");
        }
        this.iPrefix = null;
    }

    private PeriodFormatterBuilder append0(PeriodPrinter periodPrinter, PeriodParser periodParser) {
        this.iElementPairs.add(periodPrinter);
        this.iElementPairs.add(periodParser);
        this.iNotPrinter = (periodPrinter == null) | this.iNotPrinter;
        this.iNotParser |= periodParser == null;
        return this;
    }

    private static PeriodFormatter toFormatter(List<Object> list, boolean z, boolean z2) {
        if (z && z2) {
            throw new IllegalStateException("Builder has created neither a printer nor a parser");
        }
        int size = list.size();
        if (size >= 2 && (list.get(0) instanceof Separator)) {
            Separator separator = (Separator) list.get(0);
            if (separator.iAfterParser == null && separator.iAfterPrinter == null) {
                PeriodFormatter formatter = toFormatter(list.subList(2, size), z, z2);
                Separator separatorFinish = separator.finish(formatter.getPrinter(), formatter.getParser());
                return new PeriodFormatter(separatorFinish, separatorFinish);
            }
        }
        Object[] objArrCreateComposite = createComposite(list);
        if (z) {
            return new PeriodFormatter(null, (PeriodParser) objArrCreateComposite[1]);
        }
        if (z2) {
            return new PeriodFormatter((PeriodPrinter) objArrCreateComposite[0], null);
        }
        return new PeriodFormatter((PeriodPrinter) objArrCreateComposite[0], (PeriodParser) objArrCreateComposite[1]);
    }

    private static Object[] createComposite(List<Object> list) {
        int size = list.size();
        if (size == 0) {
            return new Object[]{Literal.EMPTY, Literal.EMPTY};
        }
        if (size == 1) {
            return new Object[]{list.get(0), list.get(1)};
        }
        Composite composite = new Composite(list);
        return new Object[]{composite, composite};
    }

    static abstract class IgnorableAffix implements PeriodFieldAffix {
        private volatile String[] iOtherAffixes;

        IgnorableAffix() {
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public void finish(Set<PeriodFieldAffix> set) {
            if (this.iOtherAffixes == null) {
                int length = Integer.MAX_VALUE;
                String str = null;
                for (String str2 : getAffixes()) {
                    if (str2.length() < length) {
                        length = str2.length();
                        str = str2;
                    }
                }
                HashSet hashSet = new HashSet();
                for (PeriodFieldAffix periodFieldAffix : set) {
                    if (periodFieldAffix != null) {
                        for (String str3 : periodFieldAffix.getAffixes()) {
                            if (str3.length() > length || (str3.equalsIgnoreCase(str) && !str3.equals(str))) {
                                hashSet.add(str3);
                            }
                        }
                    }
                }
                this.iOtherAffixes = (String[]) hashSet.toArray(new String[hashSet.size()]);
            }
        }

        protected boolean matchesOtherAffix(int i, String str, int i2) {
            String str2;
            int i3;
            if (this.iOtherAffixes != null) {
                String[] strArr = this.iOtherAffixes;
                int length = strArr.length;
                int i4 = 0;
                while (i4 < length) {
                    String str3 = strArr[i4];
                    int length2 = str3.length();
                    if (i < length2) {
                        str2 = str;
                        i3 = i2;
                        if (str2.regionMatches(true, i3, str3, 0, length2)) {
                            return true;
                        }
                    } else {
                        str2 = str;
                        i3 = i2;
                    }
                    if (i == length2 && str2.regionMatches(false, i3, str3, 0, length2)) {
                        return true;
                    }
                    i4++;
                    str = str2;
                    i2 = i3;
                }
            }
            return false;
        }
    }

    static class SimpleAffix extends IgnorableAffix {
        private final String iText;

        SimpleAffix(String str) {
            this.iText = str;
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int calculatePrintedLength(int i) {
            return this.iText.length();
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public void printTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append(this.iText);
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public void printTo(Writer writer, int i) throws IOException {
            writer.write(this.iText);
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int parse(String str, int i) {
            String str2 = this.iText;
            int length = str2.length();
            return (!str.regionMatches(true, i, str2, 0, length) || matchesOtherAffix(length, str, i)) ? ~i : i + length;
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int scan(String str, int i) {
            String str2 = this.iText;
            int length = str2.length();
            int length2 = str.length();
            int i2 = i;
            while (i2 < length2) {
                String str3 = str;
                if (str3.regionMatches(true, i2, str2, 0, length) && !matchesOtherAffix(length, str3, i2)) {
                    return i2;
                }
                switch (str3.charAt(i2)) {
                    case '+':
                    case ',':
                    case '-':
                    case '.':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        i2++;
                        str = str3;
                        break;
                }
                return ~i;
            }
            return ~i;
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public String[] getAffixes() {
            return new String[]{this.iText};
        }
    }

    static class PluralAffix extends IgnorableAffix {
        private final String iPluralText;
        private final String iSingularText;

        PluralAffix(String str, String str2) {
            this.iSingularText = str;
            this.iPluralText = str2;
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int calculatePrintedLength(int i) {
            return (i == 1 ? this.iSingularText : this.iPluralText).length();
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public void printTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append(i == 1 ? this.iSingularText : this.iPluralText);
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public void printTo(Writer writer, int i) throws IOException {
            writer.write(i == 1 ? this.iSingularText : this.iPluralText);
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int parse(String str, int i) {
            String str2;
            String str3;
            int length;
            String str4 = this.iPluralText;
            String str5 = this.iSingularText;
            if (str4.length() < str5.length()) {
                str3 = str4;
                str2 = str5;
            } else {
                str2 = str4;
                str3 = str5;
            }
            if (str.regionMatches(true, i, str2, 0, str2.length()) && !matchesOtherAffix(str2.length(), str, i)) {
                length = str2.length();
            } else {
                if (!str.regionMatches(true, i, str3, 0, str3.length()) || matchesOtherAffix(str3.length(), str, i)) {
                    return ~i;
                }
                length = str3.length();
            }
            return i + length;
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int scan(String str, int i) {
            String str2;
            String str3;
            String str4 = this.iPluralText;
            String str5 = this.iSingularText;
            if (str4.length() < str5.length()) {
                str3 = str4;
                str2 = str5;
            } else {
                str2 = str4;
                str3 = str5;
            }
            int length = str2.length();
            int length2 = str3.length();
            int length3 = str.length();
            int i2 = i;
            while (i2 < length3) {
                String str6 = str;
                if (!str6.regionMatches(true, i2, str2, 0, length) || matchesOtherAffix(str2.length(), str6, i2)) {
                    int i3 = length2;
                    if (!str6.regionMatches(true, i2, str3, 0, i3) || matchesOtherAffix(str3.length(), str6, i2)) {
                        i2++;
                        str = str6;
                        length2 = i3;
                    }
                }
                return i2;
            }
            return ~i;
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public String[] getAffixes() {
            return new String[]{this.iSingularText, this.iPluralText};
        }
    }

    static class RegExAffix extends IgnorableAffix {
        private static final Comparator<String> LENGTH_DESC_COMPARATOR = new Comparator<String>() { // from class: org.joda.time.format.PeriodFormatterBuilder.RegExAffix.1
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str2.length() - str.length();
            }
        };
        private final Pattern[] iPatterns;
        private final String[] iSuffixes;
        private final String[] iSuffixesSortedDescByLength;

        RegExAffix(String[] strArr, String[] strArr2) {
            this.iSuffixes = (String[]) strArr2.clone();
            this.iPatterns = new Pattern[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                Pattern patternCompile = (Pattern) PeriodFormatterBuilder.PATTERNS.get(strArr[i]);
                if (patternCompile == null) {
                    patternCompile = Pattern.compile(strArr[i]);
                    PeriodFormatterBuilder.PATTERNS.putIfAbsent(strArr[i], patternCompile);
                }
                this.iPatterns[i] = patternCompile;
            }
            String[] strArr3 = (String[]) this.iSuffixes.clone();
            this.iSuffixesSortedDescByLength = strArr3;
            Arrays.sort(strArr3, LENGTH_DESC_COMPARATOR);
        }

        private int selectSuffixIndex(int i) {
            String strValueOf = String.valueOf(i);
            int i2 = 0;
            while (true) {
                Pattern[] patternArr = this.iPatterns;
                if (i2 < patternArr.length) {
                    if (patternArr[i2].matcher(strValueOf).matches()) {
                        return i2;
                    }
                    i2++;
                } else {
                    return patternArr.length - 1;
                }
            }
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int calculatePrintedLength(int i) {
            return this.iSuffixes[selectSuffixIndex(i)].length();
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public void printTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append(this.iSuffixes[selectSuffixIndex(i)]);
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public void printTo(Writer writer, int i) throws IOException {
            writer.write(this.iSuffixes[selectSuffixIndex(i)]);
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int parse(String str, int i) {
            String[] strArr = this.iSuffixesSortedDescByLength;
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str2 = strArr[i2];
                String str3 = str;
                int i3 = i;
                if (str3.regionMatches(true, i3, str2, 0, str2.length()) && !matchesOtherAffix(str2.length(), str3, i3)) {
                    return i3 + str2.length();
                }
                i2++;
                str = str3;
                i = i3;
            }
            return ~i;
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int scan(String str, int i) {
            int length = str.length();
            for (int i2 = i; i2 < length; i2++) {
                String[] strArr = this.iSuffixesSortedDescByLength;
                int length2 = strArr.length;
                int i3 = 0;
                while (i3 < length2) {
                    String str2 = strArr[i3];
                    String str3 = str;
                    if (str3.regionMatches(true, i2, str2, 0, str2.length()) && !matchesOtherAffix(str2.length(), str3, i2)) {
                        return i2;
                    }
                    i3++;
                    str = str3;
                }
            }
            return ~i;
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public String[] getAffixes() {
            return (String[]) this.iSuffixes.clone();
        }
    }

    static class CompositeAffix extends IgnorableAffix {
        private final PeriodFieldAffix iLeft;
        private final String[] iLeftRightCombinations;
        private final PeriodFieldAffix iRight;

        CompositeAffix(PeriodFieldAffix periodFieldAffix, PeriodFieldAffix periodFieldAffix2) {
            this.iLeft = periodFieldAffix;
            this.iRight = periodFieldAffix2;
            HashSet hashSet = new HashSet();
            for (String str : periodFieldAffix.getAffixes()) {
                for (String str2 : this.iRight.getAffixes()) {
                    hashSet.add(str + str2);
                }
            }
            this.iLeftRightCombinations = (String[]) hashSet.toArray(new String[hashSet.size()]);
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int calculatePrintedLength(int i) {
            return this.iLeft.calculatePrintedLength(i) + this.iRight.calculatePrintedLength(i);
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public void printTo(StringBuffer stringBuffer, int i) {
            this.iLeft.printTo(stringBuffer, i);
            this.iRight.printTo(stringBuffer, i);
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public void printTo(Writer writer, int i) throws IOException {
            this.iLeft.printTo(writer, i);
            this.iRight.printTo(writer, i);
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int parse(String str, int i) {
            int i2 = this.iLeft.parse(str, i);
            return (i2 < 0 || (i2 = this.iRight.parse(str, i2)) < 0 || !matchesOtherAffix(parse(str, i2) - i2, str, i)) ? i2 : ~i;
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public int scan(String str, int i) {
            int iScan;
            int iScan2 = this.iLeft.scan(str, i);
            return (iScan2 < 0 || ((iScan = this.iRight.scan(str, this.iLeft.parse(str, iScan2))) >= 0 && matchesOtherAffix(this.iRight.parse(str, iScan) - iScan2, str, i))) ? ~i : iScan2 > 0 ? iScan2 : iScan;
        }

        @Override // org.joda.time.format.PeriodFormatterBuilder.PeriodFieldAffix
        public String[] getAffixes() {
            return (String[]) this.iLeftRightCombinations.clone();
        }
    }

    static class FieldFormatter implements PeriodPrinter, PeriodParser {
        private final FieldFormatter[] iFieldFormatters;
        private final int iFieldType;
        private final int iMaxParsedDigits;
        private final int iMinPrintedDigits;
        private final PeriodFieldAffix iPrefix;
        private final int iPrintZeroSetting;
        private final boolean iRejectSignedValues;
        private final PeriodFieldAffix iSuffix;

        FieldFormatter(int i, int i2, int i3, boolean z, int i4, FieldFormatter[] fieldFormatterArr, PeriodFieldAffix periodFieldAffix, PeriodFieldAffix periodFieldAffix2) {
            this.iMinPrintedDigits = i;
            this.iPrintZeroSetting = i2;
            this.iMaxParsedDigits = i3;
            this.iRejectSignedValues = z;
            this.iFieldType = i4;
            this.iFieldFormatters = fieldFormatterArr;
            this.iPrefix = periodFieldAffix;
            this.iSuffix = periodFieldAffix2;
        }

        FieldFormatter(FieldFormatter fieldFormatter, PeriodFieldAffix periodFieldAffix) {
            this.iMinPrintedDigits = fieldFormatter.iMinPrintedDigits;
            this.iPrintZeroSetting = fieldFormatter.iPrintZeroSetting;
            this.iMaxParsedDigits = fieldFormatter.iMaxParsedDigits;
            this.iRejectSignedValues = fieldFormatter.iRejectSignedValues;
            this.iFieldType = fieldFormatter.iFieldType;
            this.iFieldFormatters = fieldFormatter.iFieldFormatters;
            this.iPrefix = fieldFormatter.iPrefix;
            this.iSuffix = fieldFormatter.iSuffix != null ? new CompositeAffix(fieldFormatter.iSuffix, periodFieldAffix) : periodFieldAffix;
        }

        public void finish(FieldFormatter[] fieldFormatterArr) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (FieldFormatter fieldFormatter : fieldFormatterArr) {
                if (fieldFormatter != null && !equals(fieldFormatter)) {
                    hashSet.add(fieldFormatter.iPrefix);
                    hashSet2.add(fieldFormatter.iSuffix);
                }
            }
            PeriodFieldAffix periodFieldAffix = this.iPrefix;
            if (periodFieldAffix != null) {
                periodFieldAffix.finish(hashSet);
            }
            PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
            if (periodFieldAffix2 != null) {
                periodFieldAffix2.finish(hashSet2);
            }
        }

        @Override // org.joda.time.format.PeriodPrinter
        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i, Locale locale) {
            if (i <= 0) {
                return 0;
            }
            return (this.iPrintZeroSetting == 4 || getFieldValue(readablePeriod) != Long.MAX_VALUE) ? 1 : 0;
        }

        @Override // org.joda.time.format.PeriodPrinter
        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            long fieldValue = getFieldValue(readablePeriod);
            if (fieldValue == Long.MAX_VALUE) {
                return 0;
            }
            int iMax = Math.max(FormatUtils.calculateDigitCount(fieldValue), this.iMinPrintedDigits);
            if (this.iFieldType >= 8) {
                int iMax2 = Math.max(iMax, fieldValue < 0 ? 5 : 4);
                iMax = (this.iFieldType == 9 && Math.abs(fieldValue) % 1000 == 0) ? iMax2 - 3 : iMax2 + 1;
                fieldValue /= 1000;
            }
            int i = (int) fieldValue;
            PeriodFieldAffix periodFieldAffix = this.iPrefix;
            if (periodFieldAffix != null) {
                iMax += periodFieldAffix.calculatePrintedLength(i);
            }
            PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
            return periodFieldAffix2 != null ? iMax + periodFieldAffix2.calculatePrintedLength(i) : iMax;
        }

        @Override // org.joda.time.format.PeriodPrinter
        public void printTo(StringBuffer stringBuffer, ReadablePeriod readablePeriod, Locale locale) {
            long fieldValue = getFieldValue(readablePeriod);
            if (fieldValue == Long.MAX_VALUE) {
                return;
            }
            int i = (int) fieldValue;
            if (this.iFieldType >= 8) {
                i = (int) (fieldValue / 1000);
            }
            PeriodFieldAffix periodFieldAffix = this.iPrefix;
            if (periodFieldAffix != null) {
                periodFieldAffix.printTo(stringBuffer, i);
            }
            int length = stringBuffer.length();
            int i2 = this.iMinPrintedDigits;
            if (i2 <= 1) {
                FormatUtils.appendUnpaddedInteger(stringBuffer, i);
            } else {
                FormatUtils.appendPaddedInteger(stringBuffer, i, i2);
            }
            if (this.iFieldType >= 8) {
                int iAbs = (int) (Math.abs(fieldValue) % 1000);
                if (this.iFieldType == 8 || iAbs > 0) {
                    if (fieldValue < 0 && fieldValue > -1000) {
                        stringBuffer.insert(length, '-');
                    }
                    stringBuffer.append('.');
                    FormatUtils.appendPaddedInteger(stringBuffer, iAbs, 3);
                }
            }
            PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
            if (periodFieldAffix2 != null) {
                periodFieldAffix2.printTo(stringBuffer, i);
            }
        }

        @Override // org.joda.time.format.PeriodPrinter
        public void printTo(Writer writer, ReadablePeriod readablePeriod, Locale locale) throws IOException {
            long fieldValue = getFieldValue(readablePeriod);
            if (fieldValue == Long.MAX_VALUE) {
                return;
            }
            int i = (int) fieldValue;
            if (this.iFieldType >= 8) {
                i = (int) (fieldValue / 1000);
            }
            PeriodFieldAffix periodFieldAffix = this.iPrefix;
            if (periodFieldAffix != null) {
                periodFieldAffix.printTo(writer, i);
            }
            int i2 = this.iMinPrintedDigits;
            if (i2 <= 1) {
                FormatUtils.writeUnpaddedInteger(writer, i);
            } else {
                FormatUtils.writePaddedInteger(writer, i, i2);
            }
            if (this.iFieldType >= 8) {
                int iAbs = (int) (Math.abs(fieldValue) % 1000);
                if (this.iFieldType == 8 || iAbs > 0) {
                    writer.write(46);
                    FormatUtils.writePaddedInteger(writer, iAbs, 3);
                }
            }
            PeriodFieldAffix periodFieldAffix2 = this.iSuffix;
            if (periodFieldAffix2 != null) {
                periodFieldAffix2.printTo(writer, i);
            }
        }

        @Override // org.joda.time.format.PeriodParser
        public int parseInto(ReadWritablePeriod readWritablePeriod, String str, int i, Locale locale) {
            int iScan;
            int iMin;
            int i2;
            PeriodFieldAffix periodFieldAffix;
            int i3;
            char cCharAt;
            int i4 = i;
            boolean z = this.iPrintZeroSetting == 4;
            if (i4 >= str.length()) {
                return z ? ~i4 : i4;
            }
            PeriodFieldAffix periodFieldAffix2 = this.iPrefix;
            if (periodFieldAffix2 != null) {
                i4 = periodFieldAffix2.parse(str, i4);
                if (i4 < 0) {
                    return !z ? ~i4 : i4;
                }
                z = true;
            }
            PeriodFieldAffix periodFieldAffix3 = this.iSuffix;
            int i5 = -1;
            if (periodFieldAffix3 == null || z) {
                iScan = -1;
            } else {
                iScan = periodFieldAffix3.scan(str, i4);
                if (iScan < 0) {
                    return !z ? ~iScan : iScan;
                }
                z = true;
            }
            if (!z && !isSupported(readWritablePeriod.getPeriodType(), this.iFieldType)) {
                return i4;
            }
            if (iScan > 0) {
                iMin = Math.min(this.iMaxParsedDigits, iScan - i4);
            } else {
                iMin = Math.min(this.iMaxParsedDigits, str.length() - i4);
            }
            int i6 = 0;
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                if (i6 >= iMin) {
                    i2 = 1;
                    break;
                }
                int i7 = i4 + i6;
                char cCharAt2 = str.charAt(i7);
                i2 = 1;
                if (i6 != 0 || (!(cCharAt2 == '-' || cCharAt2 == '+') || this.iRejectSignedValues)) {
                    if (cCharAt2 >= '0' && cCharAt2 <= '9') {
                        z2 = true;
                    } else {
                        if ((cCharAt2 != '.' && cCharAt2 != ',') || (((i3 = this.iFieldType) != 8 && i3 != 9) || i5 >= 0)) {
                            break;
                        }
                        iMin = Math.min(iMin + 1, str.length() - i4);
                        i5 = i7 + 1;
                    }
                    i6++;
                } else {
                    z3 = cCharAt2 == '-';
                    int i8 = i6 + 1;
                    if (i8 >= iMin || (cCharAt = str.charAt(i7 + 1)) < '0' || cCharAt > '9') {
                        break;
                    }
                    if (z3) {
                        i6 = i8;
                    } else {
                        i4++;
                    }
                    iMin = Math.min(iMin + 1, str.length() - i4);
                }
            }
            if (!z2) {
                return ~i4;
            }
            if (iScan >= 0 && i4 + i6 != iScan) {
                return i4;
            }
            int i9 = this.iFieldType;
            if (i9 != 8 && i9 != 9) {
                setFieldValue(readWritablePeriod, i9, parseInt(str, i4, i6));
            } else if (i5 < 0) {
                setFieldValue(readWritablePeriod, 6, parseInt(str, i4, i6));
                setFieldValue(readWritablePeriod, 7, 0);
            } else {
                int i10 = 0;
                int i11 = parseInt(str, i4, (i5 - i4) - 1);
                setFieldValue(readWritablePeriod, 6, i11);
                int i12 = (i4 + i6) - i5;
                if (i12 > 0) {
                    if (i12 >= 3) {
                        i10 = parseInt(str, i5, 3);
                    } else {
                        int i13 = parseInt(str, i5, i12);
                        i10 = i12 == i2 ? i13 * 100 : i13 * 10;
                    }
                    if (z3 || i11 < 0) {
                        i10 = -i10;
                    }
                }
                setFieldValue(readWritablePeriod, 7, i10);
            }
            int i14 = i4 + i6;
            return (i14 < 0 || (periodFieldAffix = this.iSuffix) == null) ? i14 : periodFieldAffix.parse(str, i14);
        }

        private int parseInt(String str, int i, int i2) {
            if (i2 >= 10) {
                return Integer.parseInt(str.substring(i, i2 + i));
            }
            boolean z = false;
            if (i2 <= 0) {
                return 0;
            }
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            int i4 = i2 - 1;
            if (cCharAt == '-') {
                i4 = i2 - 2;
                if (i4 < 0) {
                    return 0;
                }
                cCharAt = str.charAt(i3);
                z = true;
                i3 = i + 2;
            }
            int i5 = cCharAt - '0';
            while (true) {
                int i6 = i4 - 1;
                if (i4 <= 0) {
                    break;
                }
                int iCharAt = (((i5 << 3) + (i5 << 1)) + str.charAt(i3)) - 48;
                i4 = i6;
                i3++;
                i5 = iCharAt;
            }
            return z ? -i5 : i5;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        long getFieldValue(org.joda.time.ReadablePeriod r10) {
            /*
                Method dump skipped, instruction units count: 248
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.PeriodFormatterBuilder.FieldFormatter.getFieldValue(org.joda.time.ReadablePeriod):long");
        }

        boolean isZero(ReadablePeriod readablePeriod) {
            int size = readablePeriod.size();
            for (int i = 0; i < size; i++) {
                if (readablePeriod.getValue(i) != 0) {
                    return false;
                }
            }
            return true;
        }

        boolean isSupported(PeriodType periodType, int i) {
            switch (i) {
                case 8:
                case 9:
                    if (periodType.isSupported(DurationFieldType.seconds()) || periodType.isSupported(DurationFieldType.millis())) {
                    }
                    break;
            }
            return false;
        }

        void setFieldValue(ReadWritablePeriod readWritablePeriod, int i, int i2) {
            switch (i) {
                case 0:
                    readWritablePeriod.setYears(i2);
                    break;
                case 1:
                    readWritablePeriod.setMonths(i2);
                    break;
                case 2:
                    readWritablePeriod.setWeeks(i2);
                    break;
                case 3:
                    readWritablePeriod.setDays(i2);
                    break;
                case 4:
                    readWritablePeriod.setHours(i2);
                    break;
                case 5:
                    readWritablePeriod.setMinutes(i2);
                    break;
                case 6:
                    readWritablePeriod.setSeconds(i2);
                    break;
                case 7:
                    readWritablePeriod.setMillis(i2);
                    break;
            }
        }

        int getFieldType() {
            return this.iFieldType;
        }
    }

    static class Literal implements PeriodPrinter, PeriodParser {
        static final Literal EMPTY = new Literal("");
        private final String iText;

        @Override // org.joda.time.format.PeriodPrinter
        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i, Locale locale) {
            return 0;
        }

        Literal(String str) {
            this.iText = str;
        }

        @Override // org.joda.time.format.PeriodPrinter
        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            return this.iText.length();
        }

        @Override // org.joda.time.format.PeriodPrinter
        public void printTo(StringBuffer stringBuffer, ReadablePeriod readablePeriod, Locale locale) {
            stringBuffer.append(this.iText);
        }

        @Override // org.joda.time.format.PeriodPrinter
        public void printTo(Writer writer, ReadablePeriod readablePeriod, Locale locale) throws IOException {
            writer.write(this.iText);
        }

        @Override // org.joda.time.format.PeriodParser
        public int parseInto(ReadWritablePeriod readWritablePeriod, String str, int i, Locale locale) {
            String str2 = this.iText;
            return str.regionMatches(true, i, str2, 0, str2.length()) ? i + this.iText.length() : ~i;
        }
    }

    static class Separator implements PeriodPrinter, PeriodParser {
        private volatile PeriodParser iAfterParser;
        private volatile PeriodPrinter iAfterPrinter;
        private final PeriodParser iBeforeParser;
        private final PeriodPrinter iBeforePrinter;
        private final String iFinalText;
        private final String[] iParsedForms;
        private final String iText;
        private final boolean iUseAfter;
        private final boolean iUseBefore;

        Separator(String str, String str2, String[] strArr, PeriodPrinter periodPrinter, PeriodParser periodParser, boolean z, boolean z2) {
            this.iText = str;
            this.iFinalText = str2;
            if ((str2 == null || str.equals(str2)) && (strArr == null || strArr.length == 0)) {
                this.iParsedForms = new String[]{str};
            } else {
                TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                treeSet.add(str);
                treeSet.add(str2);
                if (strArr != null) {
                    int length = strArr.length;
                    while (true) {
                        length--;
                        if (length < 0) {
                            break;
                        } else {
                            treeSet.add(strArr[length]);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList(treeSet);
                Collections.reverse(arrayList);
                this.iParsedForms = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            this.iBeforePrinter = periodPrinter;
            this.iBeforeParser = periodParser;
            this.iUseBefore = z;
            this.iUseAfter = z2;
        }

        @Override // org.joda.time.format.PeriodPrinter
        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i, Locale locale) {
            int iCountFieldsToPrint = this.iBeforePrinter.countFieldsToPrint(readablePeriod, i, locale);
            return iCountFieldsToPrint < i ? iCountFieldsToPrint + this.iAfterPrinter.countFieldsToPrint(readablePeriod, i, locale) : iCountFieldsToPrint;
        }

        @Override // org.joda.time.format.PeriodPrinter
        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            int length;
            PeriodPrinter periodPrinter = this.iBeforePrinter;
            PeriodPrinter periodPrinter2 = this.iAfterPrinter;
            int iCalculatePrintedLength = periodPrinter.calculatePrintedLength(readablePeriod, locale) + periodPrinter2.calculatePrintedLength(readablePeriod, locale);
            if (this.iUseBefore) {
                if (periodPrinter.countFieldsToPrint(readablePeriod, 1, locale) > 0) {
                    if (this.iUseAfter) {
                        int iCountFieldsToPrint = periodPrinter2.countFieldsToPrint(readablePeriod, 2, locale);
                        if (iCountFieldsToPrint > 0) {
                            length = (iCountFieldsToPrint > 1 ? this.iText : this.iFinalText).length();
                        }
                    } else {
                        length = this.iText.length();
                    }
                    return iCalculatePrintedLength + length;
                }
                return iCalculatePrintedLength;
            }
            if (this.iUseAfter && periodPrinter2.countFieldsToPrint(readablePeriod, 1, locale) > 0) {
                length = this.iText.length();
                return iCalculatePrintedLength + length;
            }
            return iCalculatePrintedLength;
        }

        @Override // org.joda.time.format.PeriodPrinter
        public void printTo(StringBuffer stringBuffer, ReadablePeriod readablePeriod, Locale locale) {
            PeriodPrinter periodPrinter = this.iBeforePrinter;
            PeriodPrinter periodPrinter2 = this.iAfterPrinter;
            periodPrinter.printTo(stringBuffer, readablePeriod, locale);
            if (this.iUseBefore) {
                if (periodPrinter.countFieldsToPrint(readablePeriod, 1, locale) > 0) {
                    if (this.iUseAfter) {
                        int iCountFieldsToPrint = periodPrinter2.countFieldsToPrint(readablePeriod, 2, locale);
                        if (iCountFieldsToPrint > 0) {
                            stringBuffer.append(iCountFieldsToPrint > 1 ? this.iText : this.iFinalText);
                        }
                    } else {
                        stringBuffer.append(this.iText);
                    }
                }
            } else if (this.iUseAfter && periodPrinter2.countFieldsToPrint(readablePeriod, 1, locale) > 0) {
                stringBuffer.append(this.iText);
            }
            periodPrinter2.printTo(stringBuffer, readablePeriod, locale);
        }

        @Override // org.joda.time.format.PeriodPrinter
        public void printTo(Writer writer, ReadablePeriod readablePeriod, Locale locale) throws IOException {
            PeriodPrinter periodPrinter = this.iBeforePrinter;
            PeriodPrinter periodPrinter2 = this.iAfterPrinter;
            periodPrinter.printTo(writer, readablePeriod, locale);
            if (this.iUseBefore) {
                if (periodPrinter.countFieldsToPrint(readablePeriod, 1, locale) > 0) {
                    if (this.iUseAfter) {
                        int iCountFieldsToPrint = periodPrinter2.countFieldsToPrint(readablePeriod, 2, locale);
                        if (iCountFieldsToPrint > 0) {
                            writer.write(iCountFieldsToPrint > 1 ? this.iText : this.iFinalText);
                        }
                    } else {
                        writer.write(this.iText);
                    }
                }
            } else if (this.iUseAfter && periodPrinter2.countFieldsToPrint(readablePeriod, 1, locale) > 0) {
                writer.write(this.iText);
            }
            periodPrinter2.printTo(writer, readablePeriod, locale);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
        @Override // org.joda.time.format.PeriodParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int parseInto(org.joda.time.ReadWritablePeriod r11, java.lang.String r12, int r13, java.util.Locale r14) {
            /*
                r10 = this;
                org.joda.time.format.PeriodParser r0 = r10.iBeforeParser
                int r3 = r0.parseInto(r11, r12, r13, r14)
                if (r3 >= 0) goto L9
                return r3
            L9:
                r0 = 0
                if (r3 <= r13) goto L3c
                java.lang.String[] r13 = r10.iParsedForms
                int r7 = r13.length
                r8 = r0
            L10:
                if (r8 >= r7) goto L3c
                r4 = r13[r8]
                if (r4 == 0) goto L2e
                int r1 = r4.length()
                if (r1 == 0) goto L2e
                r5 = 0
                int r6 = r4.length()
                r2 = 1
                r1 = r12
                boolean r12 = r1.regionMatches(r2, r3, r4, r5, r6)
                if (r12 == 0) goto L2a
                goto L2f
            L2a:
                int r8 = r8 + 1
                r12 = r1
                goto L10
            L2e:
                r1 = r12
            L2f:
                if (r4 != 0) goto L32
                goto L36
            L32:
                int r0 = r4.length()
            L36:
                int r3 = r3 + r0
                r12 = 1
                r9 = r0
                r0 = r12
                r12 = r9
                goto L3e
            L3c:
                r1 = r12
                r12 = -1
            L3e:
                org.joda.time.format.PeriodParser r13 = r10.iAfterParser
                int r11 = r13.parseInto(r11, r1, r3, r14)
                if (r11 >= 0) goto L47
                goto L58
            L47:
                if (r0 == 0) goto L4f
                if (r11 != r3) goto L4f
                if (r12 <= 0) goto L4f
                int r11 = ~r3
                return r11
            L4f:
                if (r11 <= r3) goto L58
                if (r0 != 0) goto L58
                boolean r12 = r10.iUseBefore
                if (r12 != 0) goto L58
                int r11 = ~r3
            L58:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.PeriodFormatterBuilder.Separator.parseInto(org.joda.time.ReadWritablePeriod, java.lang.String, int, java.util.Locale):int");
        }

        Separator finish(PeriodPrinter periodPrinter, PeriodParser periodParser) {
            this.iAfterPrinter = periodPrinter;
            this.iAfterParser = periodParser;
            return this;
        }
    }

    static class Composite implements PeriodPrinter, PeriodParser {
        private final PeriodParser[] iParsers;
        private final PeriodPrinter[] iPrinters;

        Composite(List<Object> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            decompose(list, arrayList, arrayList2);
            if (arrayList.size() <= 0) {
                this.iPrinters = null;
            } else {
                this.iPrinters = (PeriodPrinter[]) arrayList.toArray(new PeriodPrinter[arrayList.size()]);
            }
            if (arrayList2.size() <= 0) {
                this.iParsers = null;
            } else {
                this.iParsers = (PeriodParser[]) arrayList2.toArray(new PeriodParser[arrayList2.size()]);
            }
        }

        @Override // org.joda.time.format.PeriodPrinter
        public int countFieldsToPrint(ReadablePeriod readablePeriod, int i, Locale locale) {
            PeriodPrinter[] periodPrinterArr = this.iPrinters;
            int length = periodPrinterArr.length;
            int iCountFieldsToPrint = 0;
            while (iCountFieldsToPrint < i) {
                length--;
                if (length < 0) {
                    break;
                }
                iCountFieldsToPrint += periodPrinterArr[length].countFieldsToPrint(readablePeriod, Integer.MAX_VALUE, locale);
            }
            return iCountFieldsToPrint;
        }

        @Override // org.joda.time.format.PeriodPrinter
        public int calculatePrintedLength(ReadablePeriod readablePeriod, Locale locale) {
            PeriodPrinter[] periodPrinterArr = this.iPrinters;
            int length = periodPrinterArr.length;
            int iCalculatePrintedLength = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return iCalculatePrintedLength;
                }
                iCalculatePrintedLength += periodPrinterArr[length].calculatePrintedLength(readablePeriod, locale);
            }
        }

        @Override // org.joda.time.format.PeriodPrinter
        public void printTo(StringBuffer stringBuffer, ReadablePeriod readablePeriod, Locale locale) {
            for (PeriodPrinter periodPrinter : this.iPrinters) {
                periodPrinter.printTo(stringBuffer, readablePeriod, locale);
            }
        }

        @Override // org.joda.time.format.PeriodPrinter
        public void printTo(Writer writer, ReadablePeriod readablePeriod, Locale locale) throws IOException {
            for (PeriodPrinter periodPrinter : this.iPrinters) {
                periodPrinter.printTo(writer, readablePeriod, locale);
            }
        }

        @Override // org.joda.time.format.PeriodParser
        public int parseInto(ReadWritablePeriod readWritablePeriod, String str, int i, Locale locale) {
            PeriodParser[] periodParserArr = this.iParsers;
            if (periodParserArr == null) {
                throw new UnsupportedOperationException();
            }
            int length = periodParserArr.length;
            for (int i2 = 0; i2 < length && i >= 0; i2++) {
                i = periodParserArr[i2].parseInto(readWritablePeriod, str, i, locale);
            }
            return i;
        }

        private void decompose(List<Object> list, List<Object> list2, List<Object> list3) {
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                Object obj = list.get(i);
                if (obj instanceof PeriodPrinter) {
                    if (obj instanceof Composite) {
                        addArrayToList(list2, ((Composite) obj).iPrinters);
                    } else {
                        list2.add(obj);
                    }
                }
                Object obj2 = list.get(i + 1);
                if (obj2 instanceof PeriodParser) {
                    if (obj2 instanceof Composite) {
                        addArrayToList(list3, ((Composite) obj2).iParsers);
                    } else {
                        list3.add(obj2);
                    }
                }
            }
        }

        private void addArrayToList(List<Object> list, Object[] objArr) {
            if (objArr != null) {
                for (Object obj : objArr) {
                    list.add(obj);
                }
            }
        }
    }
}
