package org.joda.time;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.Comparator;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.InstantConverter;

/* JADX INFO: loaded from: classes10.dex */
public class DateTimeComparator implements Comparator<Object>, Serializable {
    private static final DateTimeComparator ALL_INSTANCE = new DateTimeComparator(null, null);
    private static final DateTimeComparator DATE_INSTANCE = new DateTimeComparator(DateTimeFieldType.dayOfYear(), null);
    private static final DateTimeComparator TIME_INSTANCE = new DateTimeComparator(null, DateTimeFieldType.dayOfYear());
    private static final long serialVersionUID = -6097339773320178364L;
    private final DateTimeFieldType iLowerLimit;
    private final DateTimeFieldType iUpperLimit;

    public static DateTimeComparator getInstance() {
        return ALL_INSTANCE;
    }

    public static DateTimeComparator getInstance(DateTimeFieldType dateTimeFieldType) {
        return getInstance(dateTimeFieldType, null);
    }

    public static DateTimeComparator getInstance(DateTimeFieldType dateTimeFieldType, DateTimeFieldType dateTimeFieldType2) {
        if (dateTimeFieldType == null && dateTimeFieldType2 == null) {
            return ALL_INSTANCE;
        }
        if (dateTimeFieldType == DateTimeFieldType.dayOfYear() && dateTimeFieldType2 == null) {
            return DATE_INSTANCE;
        }
        if (dateTimeFieldType == null && dateTimeFieldType2 == DateTimeFieldType.dayOfYear()) {
            return TIME_INSTANCE;
        }
        return new DateTimeComparator(dateTimeFieldType, dateTimeFieldType2);
    }

    public static DateTimeComparator getDateOnlyInstance() {
        return DATE_INSTANCE;
    }

    public static DateTimeComparator getTimeOnlyInstance() {
        return TIME_INSTANCE;
    }

    protected DateTimeComparator(DateTimeFieldType dateTimeFieldType, DateTimeFieldType dateTimeFieldType2) {
        this.iLowerLimit = dateTimeFieldType;
        this.iUpperLimit = dateTimeFieldType2;
    }

    public DateTimeFieldType getLowerLimit() {
        return this.iLowerLimit;
    }

    public DateTimeFieldType getUpperLimit() {
        return this.iUpperLimit;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        InstantConverter instantConverter = ConverterManager.getInstance().getInstantConverter(obj);
        Chronology chronology = instantConverter.getChronology(obj, (Chronology) null);
        long instantMillis = instantConverter.getInstantMillis(obj, chronology);
        if (obj == obj2) {
            return 0;
        }
        InstantConverter instantConverter2 = ConverterManager.getInstance().getInstantConverter(obj2);
        Chronology chronology2 = instantConverter2.getChronology(obj2, (Chronology) null);
        long instantMillis2 = instantConverter2.getInstantMillis(obj2, chronology2);
        DateTimeFieldType dateTimeFieldType = this.iLowerLimit;
        if (dateTimeFieldType != null) {
            instantMillis = dateTimeFieldType.getField(chronology).roundFloor(instantMillis);
            instantMillis2 = this.iLowerLimit.getField(chronology2).roundFloor(instantMillis2);
        }
        DateTimeFieldType dateTimeFieldType2 = this.iUpperLimit;
        if (dateTimeFieldType2 != null) {
            instantMillis = dateTimeFieldType2.getField(chronology).remainder(instantMillis);
            instantMillis2 = this.iUpperLimit.getField(chronology2).remainder(instantMillis2);
        }
        if (instantMillis < instantMillis2) {
            return -1;
        }
        return instantMillis > instantMillis2 ? 1 : 0;
    }

    private Object readResolve() {
        return getInstance(this.iLowerLimit, this.iUpperLimit);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        DateTimeFieldType dateTimeFieldType;
        if (!(obj instanceof DateTimeComparator)) {
            return false;
        }
        DateTimeComparator dateTimeComparator = (DateTimeComparator) obj;
        if (this.iLowerLimit == dateTimeComparator.getLowerLimit() || ((dateTimeFieldType = this.iLowerLimit) != null && dateTimeFieldType.equals(dateTimeComparator.getLowerLimit()))) {
            if (this.iUpperLimit == dateTimeComparator.getUpperLimit()) {
                return true;
            }
            DateTimeFieldType dateTimeFieldType2 = this.iUpperLimit;
            if (dateTimeFieldType2 != null && dateTimeFieldType2.equals(dateTimeComparator.getUpperLimit())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        DateTimeFieldType dateTimeFieldType = this.iLowerLimit;
        int iHashCode = dateTimeFieldType == null ? 0 : dateTimeFieldType.hashCode();
        DateTimeFieldType dateTimeFieldType2 = this.iUpperLimit;
        return iHashCode + ((dateTimeFieldType2 != null ? dateTimeFieldType2.hashCode() : 0) * 123);
    }

    public String toString() {
        if (this.iLowerLimit == this.iUpperLimit) {
            StringBuilder sb = new StringBuilder("DateTimeComparator[");
            DateTimeFieldType dateTimeFieldType = this.iLowerLimit;
            return sb.append(dateTimeFieldType != null ? dateTimeFieldType.getName() : "").append(Constants.AES_SUFFIX).toString();
        }
        StringBuilder sb2 = new StringBuilder("DateTimeComparator[");
        DateTimeFieldType dateTimeFieldType2 = this.iLowerLimit;
        StringBuilder sbAppend = sb2.append(dateTimeFieldType2 == null ? "" : dateTimeFieldType2.getName()).append("-");
        DateTimeFieldType dateTimeFieldType3 = this.iUpperLimit;
        return sbAppend.append(dateTimeFieldType3 != null ? dateTimeFieldType3.getName() : "").append(Constants.AES_SUFFIX).toString();
    }
}
