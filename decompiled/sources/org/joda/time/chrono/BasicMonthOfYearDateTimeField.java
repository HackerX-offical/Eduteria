package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

/* JADX INFO: loaded from: classes10.dex */
class BasicMonthOfYearDateTimeField extends ImpreciseDateTimeField {
    private static final int MIN = 1;
    private static final long serialVersionUID = -8258715387168736L;
    private final BasicChronology iChronology;
    private final int iLeapMonth;
    private final int iMax;

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public int getMinimumValue() {
        return 1;
    }

    @Override // org.joda.time.DateTimeField
    public boolean isLenient() {
        return false;
    }

    BasicMonthOfYearDateTimeField(BasicChronology basicChronology, int i) {
        super(DateTimeFieldType.monthOfYear(), basicChronology.getAverageMillisPerMonth());
        this.iChronology = basicChronology;
        this.iMax = basicChronology.getMaxMonth();
        this.iLeapMonth = i;
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public int get(long j) {
        return this.iChronology.getMonthOfYear(j);
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public long add(long j, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (i == 0) {
            return j;
        }
        long millisOfDay = this.iChronology.getMillisOfDay(j);
        int year = this.iChronology.getYear(j);
        int monthOfYear = this.iChronology.getMonthOfYear(j, year);
        int i7 = monthOfYear - 1;
        int i8 = i7 + i;
        if (monthOfYear <= 0 || i8 >= 0) {
            i2 = year;
        } else {
            if (Math.signum(this.iMax + i) == Math.signum(i)) {
                i5 = year - 1;
                i6 = i + this.iMax;
            } else {
                i5 = year + 1;
                i6 = i - this.iMax;
            }
            int i9 = i5;
            i8 = i6 + i7;
            i2 = i9;
        }
        if (i8 >= 0) {
            int i10 = this.iMax;
            i3 = i2 + (i8 / i10);
            i4 = (i8 % i10) + 1;
        } else {
            i3 = i2 + (i8 / this.iMax);
            int i11 = i3 - 1;
            int iAbs = Math.abs(i8);
            int i12 = this.iMax;
            int i13 = iAbs % i12;
            if (i13 == 0) {
                i13 = i12;
            }
            i4 = (i12 - i13) + 1;
            if (i4 != 1) {
                i3 = i11;
            }
        }
        int dayOfMonth = this.iChronology.getDayOfMonth(j, year, monthOfYear);
        int daysInYearMonth = this.iChronology.getDaysInYearMonth(i3, i4);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.iChronology.getYearMonthDayMillis(i3, i4, dayOfMonth) + millisOfDay;
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public long add(long j, long j2) {
        long j3;
        long j4;
        long j5;
        int i = (int) j2;
        if (i == j2) {
            return add(j, i);
        }
        long millisOfDay = this.iChronology.getMillisOfDay(j);
        int year = this.iChronology.getYear(j);
        int monthOfYear = this.iChronology.getMonthOfYear(j, year);
        long j6 = ((long) (monthOfYear - 1)) + j2;
        if (j6 >= 0) {
            int i2 = this.iMax;
            j3 = ((long) year) + (j6 / ((long) i2));
            j5 = (j6 % ((long) i2)) + 1;
            j4 = millisOfDay;
        } else {
            j3 = ((long) year) + (j6 / ((long) this.iMax));
            long j7 = j3 - 1;
            long jAbs = Math.abs(j6);
            int i3 = this.iMax;
            j4 = millisOfDay;
            int i4 = (int) (jAbs % ((long) i3));
            if (i4 == 0) {
                i4 = i3;
            }
            j5 = (i3 - i4) + 1;
            if (j5 != 1) {
                j3 = j7;
            }
        }
        if (j3 < this.iChronology.getMinYear() || j3 > this.iChronology.getMaxYear()) {
            throw new IllegalArgumentException("Magnitude of add amount is too large: " + j2);
        }
        int i5 = (int) j3;
        int i6 = (int) j5;
        int dayOfMonth = this.iChronology.getDayOfMonth(j, year, monthOfYear);
        int daysInYearMonth = this.iChronology.getDaysInYearMonth(i5, i6);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.iChronology.getYearMonthDayMillis(i5, i6, dayOfMonth) + j4;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public int[] add(ReadablePartial readablePartial, int i, int[] iArr, int i2) {
        if (i2 == 0) {
            return iArr;
        }
        if (readablePartial.size() > 0 && readablePartial.getFieldType(0).equals(DateTimeFieldType.monthOfYear()) && i == 0) {
            return set(readablePartial, 0, iArr, ((((iArr[0] - 1) + (i2 % 12)) + 12) % 12) + 1);
        }
        if (DateTimeUtils.isContiguous(readablePartial)) {
            int size = readablePartial.size();
            long j = 0;
            for (int i3 = 0; i3 < size; i3++) {
                j = readablePartial.getFieldType(i3).getField(this.iChronology).set(j, iArr[i3]);
            }
            return this.iChronology.get(readablePartial, add(j, i2));
        }
        return super.add(readablePartial, i, iArr, i2);
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public long addWrapField(long j, int i) {
        return set(j, FieldUtils.getWrappedValue(get(j), i, 1, this.iMax));
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public long getDifferenceAsLong(long j, long j2) {
        if (j < j2) {
            return -getDifference(j2, j);
        }
        int year = this.iChronology.getYear(j);
        int monthOfYear = this.iChronology.getMonthOfYear(j, year);
        int year2 = this.iChronology.getYear(j2);
        int monthOfYear2 = this.iChronology.getMonthOfYear(j2, year2);
        long j3 = ((((long) (year - year2)) * ((long) this.iMax)) + ((long) monthOfYear)) - ((long) monthOfYear2);
        int dayOfMonth = this.iChronology.getDayOfMonth(j, year, monthOfYear);
        if (dayOfMonth == this.iChronology.getDaysInYearMonth(year, monthOfYear) && this.iChronology.getDayOfMonth(j2, year2, monthOfYear2) > dayOfMonth) {
            j2 = this.iChronology.dayOfMonth().set(j2, dayOfMonth);
        }
        return j - this.iChronology.getYearMonthMillis(year, monthOfYear) < j2 - this.iChronology.getYearMonthMillis(year2, monthOfYear2) ? j3 - 1 : j3;
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public long set(long j, int i) {
        FieldUtils.verifyValueBounds(this, i, 1, this.iMax);
        int year = this.iChronology.getYear(j);
        int dayOfMonth = this.iChronology.getDayOfMonth(j, year);
        int daysInYearMonth = this.iChronology.getDaysInYearMonth(year, i);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.iChronology.getYearMonthDayMillis(year, i, dayOfMonth) + ((long) this.iChronology.getMillisOfDay(j));
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public DurationField getRangeDurationField() {
        return this.iChronology.years();
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public boolean isLeap(long j) {
        int year = this.iChronology.getYear(j);
        return this.iChronology.isLeapYear(year) && this.iChronology.getMonthOfYear(j, year) == this.iLeapMonth;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public int getLeapAmount(long j) {
        return isLeap(j) ? 1 : 0;
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public DurationField getLeapDurationField() {
        return this.iChronology.days();
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public int getMaximumValue() {
        return this.iMax;
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public long roundFloor(long j) {
        int year = this.iChronology.getYear(j);
        return this.iChronology.getYearMonthMillis(year, this.iChronology.getMonthOfYear(j, year));
    }

    @Override // org.joda.time.field.BaseDateTimeField, org.joda.time.DateTimeField
    public long remainder(long j) {
        return j - roundFloor(j);
    }

    private Object readResolve() {
        return this.iChronology.monthOfYear();
    }
}
