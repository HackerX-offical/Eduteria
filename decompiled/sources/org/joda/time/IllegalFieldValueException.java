package org.joda.time;

import com.amazonaws.services.s3.internal.Constants;
import com.csvreader.CsvReader;

/* JADX INFO: loaded from: classes10.dex */
public class IllegalFieldValueException extends IllegalArgumentException {
    private static final long serialVersionUID = 6305711765985447737L;
    private final DateTimeFieldType iDateTimeFieldType;
    private final DurationFieldType iDurationFieldType;
    private final String iFieldName;
    private final Number iLowerBound;
    private String iMessage;
    private final Number iNumberValue;
    private final String iStringValue;
    private final Number iUpperBound;

    private static String createMessage(String str, Number number, Number number2, Number number3, String str2) {
        StringBuilder sbAppend = new StringBuilder("Value ").append(number).append(" for ").append(str).append(' ');
        if (number2 == null) {
            if (number3 == null) {
                sbAppend.append("is not supported");
            } else {
                sbAppend.append("must not be larger than ").append(number3);
            }
        } else if (number3 == null) {
            sbAppend.append("must not be smaller than ").append(number2);
        } else {
            sbAppend.append("must be in the range [").append(number2).append(CsvReader.Letters.COMMA).append(number3).append(']');
        }
        if (str2 != null) {
            sbAppend.append(": ").append(str2);
        }
        return sbAppend.toString();
    }

    private static String createMessage(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer("Value ");
        if (str2 == null) {
            stringBuffer.append(Constants.NULL_VERSION_ID);
        } else {
            stringBuffer.append('\"');
            stringBuffer.append(str2);
            stringBuffer.append('\"');
        }
        stringBuffer.append(" for ").append(str).append(" is not supported");
        return stringBuffer.toString();
    }

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, Number number, Number number2, Number number3) {
        super(createMessage(dateTimeFieldType.getName(), number, number2, number3, null));
        this.iDateTimeFieldType = dateTimeFieldType;
        this.iDurationFieldType = null;
        this.iFieldName = dateTimeFieldType.getName();
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = number2;
        this.iUpperBound = number3;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, Number number, Number number2, Number number3, String str) {
        super(createMessage(dateTimeFieldType.getName(), number, number2, number3, str));
        this.iDateTimeFieldType = dateTimeFieldType;
        this.iDurationFieldType = null;
        this.iFieldName = dateTimeFieldType.getName();
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = number2;
        this.iUpperBound = number3;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, Number number, String str) {
        super(createMessage(dateTimeFieldType.getName(), number, null, null, str));
        this.iDateTimeFieldType = dateTimeFieldType;
        this.iDurationFieldType = null;
        this.iFieldName = dateTimeFieldType.getName();
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(DurationFieldType durationFieldType, Number number, Number number2, Number number3) {
        super(createMessage(durationFieldType.getName(), number, number2, number3, null));
        this.iDateTimeFieldType = null;
        this.iDurationFieldType = durationFieldType;
        this.iFieldName = durationFieldType.getName();
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = number2;
        this.iUpperBound = number3;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(String str, Number number, Number number2, Number number3) {
        super(createMessage(str, number, number2, number3, null));
        this.iDateTimeFieldType = null;
        this.iDurationFieldType = null;
        this.iFieldName = str;
        this.iNumberValue = number;
        this.iStringValue = null;
        this.iLowerBound = number2;
        this.iUpperBound = number3;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(DateTimeFieldType dateTimeFieldType, String str) {
        super(createMessage(dateTimeFieldType.getName(), str));
        this.iDateTimeFieldType = dateTimeFieldType;
        this.iDurationFieldType = null;
        this.iFieldName = dateTimeFieldType.getName();
        this.iStringValue = str;
        this.iNumberValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(DurationFieldType durationFieldType, String str) {
        super(createMessage(durationFieldType.getName(), str));
        this.iDateTimeFieldType = null;
        this.iDurationFieldType = durationFieldType;
        this.iFieldName = durationFieldType.getName();
        this.iStringValue = str;
        this.iNumberValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }

    public IllegalFieldValueException(String str, String str2) {
        super(createMessage(str, str2));
        this.iDateTimeFieldType = null;
        this.iDurationFieldType = null;
        this.iFieldName = str;
        this.iStringValue = str2;
        this.iNumberValue = null;
        this.iLowerBound = null;
        this.iUpperBound = null;
        this.iMessage = super.getMessage();
    }

    public DateTimeFieldType getDateTimeFieldType() {
        return this.iDateTimeFieldType;
    }

    public DurationFieldType getDurationFieldType() {
        return this.iDurationFieldType;
    }

    public String getFieldName() {
        return this.iFieldName;
    }

    public Number getIllegalNumberValue() {
        return this.iNumberValue;
    }

    public String getIllegalStringValue() {
        return this.iStringValue;
    }

    public String getIllegalValueAsString() {
        String str = this.iStringValue;
        return str == null ? String.valueOf(this.iNumberValue) : str;
    }

    public Number getLowerBound() {
        return this.iLowerBound;
    }

    public Number getUpperBound() {
        return this.iUpperBound;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.iMessage;
    }

    public void prependMessage(String str) {
        if (this.iMessage == null) {
            this.iMessage = str;
        } else if (str != null) {
            this.iMessage = str + ": " + this.iMessage;
        }
    }
}
