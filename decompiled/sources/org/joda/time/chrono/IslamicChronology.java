package org.joda.time.chrono;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.AssembledChronology;

/* JADX INFO: loaded from: classes10.dex */
public final class IslamicChronology extends BasicChronology {
    public static final int AH = 1;
    private static final int CYCLE = 30;
    private static final int LONG_MONTH_LENGTH = 30;
    private static final int MAX_YEAR = 292271022;
    private static final long MILLIS_PER_CYCLE = 918518400000L;
    private static final long MILLIS_PER_LONG_MONTH = 2592000000L;
    private static final long MILLIS_PER_LONG_YEAR = 30672000000L;
    private static final long MILLIS_PER_MONTH = 2551440384L;
    private static final long MILLIS_PER_MONTH_PAIR = 5097600000L;
    private static final long MILLIS_PER_SHORT_YEAR = 30585600000L;
    private static final long MILLIS_PER_YEAR = 30617280288L;
    private static final long MILLIS_YEAR_1 = -42521587200000L;
    private static final int MIN_YEAR = -292269337;
    private static final int MONTH_PAIR_LENGTH = 59;
    private static final int SHORT_MONTH_LENGTH = 29;
    private static final long serialVersionUID = -3663823829888L;
    private final LeapYearPatternType iLeapYears;
    private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField("AH");
    public static final LeapYearPatternType LEAP_YEAR_15_BASED = new LeapYearPatternType(0, 623158436);
    public static final LeapYearPatternType LEAP_YEAR_16_BASED = new LeapYearPatternType(1, 623191204);
    public static final LeapYearPatternType LEAP_YEAR_INDIAN = new LeapYearPatternType(2, 690562340);
    public static final LeapYearPatternType LEAP_YEAR_HABASH_AL_HASIB = new LeapYearPatternType(3, 153692453);
    private static final ConcurrentHashMap<DateTimeZone, IslamicChronology[]> cCache = new ConcurrentHashMap<>();
    private static final IslamicChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);

    @Override // org.joda.time.chrono.BasicChronology
    long getApproxMillisAtEpochDividedByTwo() {
        return 21260793600000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    long getAverageMillisPerMonth() {
        return MILLIS_PER_MONTH;
    }

    @Override // org.joda.time.chrono.BasicChronology
    long getAverageMillisPerYear() {
        return MILLIS_PER_YEAR;
    }

    @Override // org.joda.time.chrono.BasicChronology
    long getAverageMillisPerYearDividedByTwo() {
        return 15308640144L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getDaysInMonthMax() {
        return 30;
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getDaysInYearMax() {
        return 355;
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getMaxYear() {
        return MAX_YEAR;
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getMinYear() {
        return 1;
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    public /* bridge */ /* synthetic */ long getDateTimeMillis(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        return super.getDateTimeMillis(i, i2, i3, i4);
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    public /* bridge */ /* synthetic */ long getDateTimeMillis(int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalArgumentException {
        return super.getDateTimeMillis(i, i2, i3, i4, i5, i6, i7);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public /* bridge */ /* synthetic */ int getMinimumDaysInFirstWeek() {
        return super.getMinimumDaysInFirstWeek();
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    public /* bridge */ /* synthetic */ DateTimeZone getZone() {
        return super.getZone();
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static IslamicChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    public static IslamicChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), LEAP_YEAR_16_BASED);
    }

    public static IslamicChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, LEAP_YEAR_16_BASED);
    }

    public static IslamicChronology getInstance(DateTimeZone dateTimeZone, LeapYearPatternType leapYearPatternType) {
        IslamicChronology islamicChronology;
        IslamicChronology[] islamicChronologyArrPutIfAbsent;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap<DateTimeZone, IslamicChronology[]> concurrentHashMap = cCache;
        IslamicChronology[] islamicChronologyArr = concurrentHashMap.get(dateTimeZone);
        if (islamicChronologyArr == null && (islamicChronologyArrPutIfAbsent = concurrentHashMap.putIfAbsent(dateTimeZone, (islamicChronologyArr = new IslamicChronology[4]))) != null) {
            islamicChronologyArr = islamicChronologyArrPutIfAbsent;
        }
        IslamicChronology islamicChronology2 = islamicChronologyArr[leapYearPatternType.index];
        if (islamicChronology2 != null) {
            return islamicChronology2;
        }
        synchronized (islamicChronologyArr) {
            islamicChronology = islamicChronologyArr[leapYearPatternType.index];
            if (islamicChronology == null) {
                if (dateTimeZone == DateTimeZone.UTC) {
                    IslamicChronology islamicChronology3 = new IslamicChronology(null, null, leapYearPatternType);
                    islamicChronology = new IslamicChronology(LimitChronology.getInstance(islamicChronology3, new DateTime(1, 1, 1, 0, 0, 0, 0, islamicChronology3), null), null, leapYearPatternType);
                } else {
                    islamicChronology = new IslamicChronology(ZonedChronology.getInstance(getInstance(DateTimeZone.UTC, leapYearPatternType), dateTimeZone), null, leapYearPatternType);
                }
                islamicChronologyArr[leapYearPatternType.index] = islamicChronology;
            }
        }
        return islamicChronology;
    }

    IslamicChronology(Chronology chronology, Object obj, LeapYearPatternType leapYearPatternType) {
        super(chronology, obj, 4);
        this.iLeapYears = leapYearPatternType;
    }

    private Object readResolve() {
        Chronology base = getBase();
        return base == null ? getInstanceUTC() : getInstance(base.getZone());
    }

    public LeapYearPatternType getLeapYearPatternType() {
        return this.iLeapYears;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    public Chronology withUTC() {
        return INSTANCE_UTC;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.Chronology
    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return dateTimeZone == getZone() ? this : getInstance(dateTimeZone);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IslamicChronology) && getLeapYearPatternType().index == ((IslamicChronology) obj).getLeapYearPatternType().index && super.equals(obj);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int hashCode() {
        return (super.hashCode() * 13) + getLeapYearPatternType().hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        r6 = 30585600000L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0023, code lost:
    
        if (isLeapYear(r0) != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0025, code lost:
    
        r6 = 30672000000L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
    
        r6 = 30585600000L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
    
        if (r9 < r6) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002c, code lost:
    
        r9 = r9 - r6;
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
    
        if (isLeapYear(r0) == false) goto L5;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0033 -> B:4:0x0025). Please report as a decompilation issue!!! */
    @Override // org.joda.time.chrono.BasicChronology
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int getYear(long r9) {
        /*
            r8 = this;
            r0 = -42521587200000(0xffffd953abe65000, double:NaN)
            long r9 = r9 - r0
            r0 = 918518400000(0xd5dbf68400, double:4.53808386513E-312)
            long r2 = r9 / r0
            long r9 = r9 % r0
            r0 = 30
            long r2 = r2 * r0
            r0 = 1
            long r2 = r2 + r0
            int r0 = (int) r2
            boolean r1 = r8.isLeapYear(r0)
            r2 = 30672000000(0x724319400, double:1.5153981489E-313)
            r4 = 30585600000(0x71f0b3800, double:1.51112942174E-313)
            if (r1 == 0) goto L27
        L25:
            r6 = r2
            goto L28
        L27:
            r6 = r4
        L28:
            int r1 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r1 < 0) goto L36
            long r9 = r9 - r6
            int r0 = r0 + 1
            boolean r1 = r8.isLeapYear(r0)
            if (r1 == 0) goto L27
            goto L25
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.chrono.IslamicChronology.getYear(long):int");
    }

    @Override // org.joda.time.chrono.BasicChronology
    long setYear(long j, int i) {
        int dayOfYear = getDayOfYear(j, getYear(j));
        int millisOfDay = getMillisOfDay(j);
        if (dayOfYear > 354 && !isLeapYear(i)) {
            dayOfYear--;
        }
        return getYearMonthDayMillis(i, 1, dayOfYear) + ((long) millisOfDay);
    }

    @Override // org.joda.time.chrono.BasicChronology
    long getYearDifference(long j, long j2) {
        int year = getYear(j);
        int year2 = getYear(j2);
        long yearMillis = j - getYearMillis(year);
        int i = year - year2;
        if (yearMillis < j2 - getYearMillis(year2)) {
            i--;
        }
        return i;
    }

    @Override // org.joda.time.chrono.BasicChronology
    long getTotalMillisByYearMonth(int i, int i2) {
        int i3 = i2 - 1;
        if (i3 % 2 == 1) {
            return (((long) (i3 / 2)) * MILLIS_PER_MONTH_PAIR) + MILLIS_PER_LONG_MONTH;
        }
        return ((long) (i3 / 2)) * MILLIS_PER_MONTH_PAIR;
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getDayOfMonth(long j) {
        int dayOfYear = getDayOfYear(j) - 1;
        if (dayOfYear == 354) {
            return 30;
        }
        return ((dayOfYear % 59) % 30) + 1;
    }

    @Override // org.joda.time.chrono.BasicChronology
    boolean isLeapYear(int i) {
        return this.iLeapYears.isLeapYear(i);
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getDaysInYear(int i) {
        return isLeapYear(i) ? 355 : 354;
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getDaysInYearMonth(int i, int i2) {
        return ((i2 == 12 && isLeapYear(i)) || (i2 + (-1)) % 2 == 0) ? 30 : 29;
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getDaysInMonthMax(int i) {
        return (i == 12 || (i + (-1)) % 2 == 0) ? 30 : 29;
    }

    @Override // org.joda.time.chrono.BasicChronology
    int getMonthOfYear(long j, int i) {
        int yearMillis = (int) ((j - getYearMillis(i)) / 86400000);
        if (yearMillis == 354) {
            return 12;
        }
        return ((yearMillis * 2) / 59) + 1;
    }

    @Override // org.joda.time.chrono.BasicChronology
    long calculateFirstDayOfYearMillis(int i) {
        if (i > MAX_YEAR) {
            throw new ArithmeticException("Year is too large: " + i + " > 292271022");
        }
        if (i < MIN_YEAR) {
            throw new ArithmeticException("Year is too small: " + i + " < -292269337");
        }
        int i2 = i - 1;
        long j = (((long) (i2 / 30)) * MILLIS_PER_CYCLE) + MILLIS_YEAR_1;
        int i3 = (i2 % 30) + 1;
        for (int i4 = 1; i4 < i3; i4++) {
            j += isLeapYear(i4) ? MILLIS_PER_LONG_YEAR : MILLIS_PER_SHORT_YEAR;
        }
        return j;
    }

    @Override // org.joda.time.chrono.BasicChronology, org.joda.time.chrono.AssembledChronology
    protected void assemble(AssembledChronology.Fields fields) {
        if (getBase() == null) {
            super.assemble(fields);
            fields.era = ERA_FIELD;
            fields.monthOfYear = new BasicMonthOfYearDateTimeField(this, 12);
            fields.months = fields.monthOfYear.getDurationField();
        }
    }

    public static class LeapYearPatternType implements Serializable {
        private static final long serialVersionUID = 26581275372698L;
        final byte index;
        final int pattern;

        LeapYearPatternType(int i, int i2) {
            this.index = (byte) i;
            this.pattern = i2;
        }

        boolean isLeapYear(int i) {
            return ((1 << (i % 30)) & this.pattern) > 0;
        }

        private Object readResolve() {
            byte b2 = this.index;
            if (b2 == 0) {
                return IslamicChronology.LEAP_YEAR_15_BASED;
            }
            if (b2 == 1) {
                return IslamicChronology.LEAP_YEAR_16_BASED;
            }
            if (b2 != 2) {
                return b2 != 3 ? this : IslamicChronology.LEAP_YEAR_HABASH_AL_HASIB;
            }
            return IslamicChronology.LEAP_YEAR_INDIAN;
        }

        public boolean equals(Object obj) {
            return (obj instanceof LeapYearPatternType) && this.index == ((LeapYearPatternType) obj).index;
        }

        public int hashCode() {
            return this.index;
        }
    }
}
