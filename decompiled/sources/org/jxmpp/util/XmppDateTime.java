package org.jxmpp.util;

import androidx.exifinterface.media.ExifInterface;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.storage.internal.Util;
import g.b;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.joda.time.DateTimeConstants;

/* JADX INFO: loaded from: classes10.dex */
public class XmppDateTime {
    private static final Pattern SECOND_FRACTION;
    private static final TimeZone TIME_ZONE_UTC;
    private static final List<PatternCouplings> couplings;
    private static final DateFormatType dateFormatter;
    private static final Pattern datePattern;
    private static final DateFormatType dateTimeFormatter;
    private static final DateFormatType dateTimeNoMillisFormatter;
    private static final Pattern dateTimeNoMillisPattern;
    private static final Pattern dateTimePattern;
    private static final DateFormatType timeFormatter;
    private static final DateFormatType timeNoMillisFormatter;
    private static final DateFormatType timeNoMillisNoZoneFormatter;
    private static final Pattern timeNoMillisNoZonePattern;
    private static final Pattern timeNoMillisPattern;
    private static final DateFormatType timeNoZoneFormatter;
    private static final Pattern timeNoZonePattern;
    private static final Pattern timePattern;
    private static final ThreadLocal<DateFormat> xep0091Date6DigitFormatter;
    private static final ThreadLocal<DateFormat> xep0091Date7Digit1MonthFormatter;
    private static final ThreadLocal<DateFormat> xep0091Date7Digit2MonthFormatter;
    private static final ThreadLocal<DateFormat> xep0091Formatter;
    private static final Pattern xep0091Pattern;

    static {
        DateFormatType dateFormatType = DateFormatType.XEP_0082_DATE_PROFILE;
        dateFormatter = dateFormatType;
        Pattern patternCompile = Pattern.compile("^\\d+-\\d+-\\d+$");
        datePattern = patternCompile;
        DateFormatType dateFormatType2 = DateFormatType.XEP_0082_TIME_MILLIS_ZONE_PROFILE;
        timeFormatter = dateFormatType2;
        Pattern patternCompile2 = Pattern.compile("^(\\d+:){2}\\d+.\\d+(Z|([+-](\\d+:\\d+)))$");
        timePattern = patternCompile2;
        DateFormatType dateFormatType3 = DateFormatType.XEP_0082_TIME_MILLIS_PROFILE;
        timeNoZoneFormatter = dateFormatType3;
        Pattern patternCompile3 = Pattern.compile("^(\\d+:){2}\\d+.\\d+$");
        timeNoZonePattern = patternCompile3;
        DateFormatType dateFormatType4 = DateFormatType.XEP_0082_TIME_ZONE_PROFILE;
        timeNoMillisFormatter = dateFormatType4;
        Pattern patternCompile4 = Pattern.compile("^(\\d+:){2}\\d+(Z|([+-](\\d+:\\d+)))$");
        timeNoMillisPattern = patternCompile4;
        DateFormatType dateFormatType5 = DateFormatType.XEP_0082_TIME_PROFILE;
        timeNoMillisNoZoneFormatter = dateFormatType5;
        Pattern patternCompile5 = Pattern.compile("^(\\d+:){2}\\d+$");
        timeNoMillisNoZonePattern = patternCompile5;
        DateFormatType dateFormatType6 = DateFormatType.XEP_0082_DATETIME_MILLIS_PROFILE;
        dateTimeFormatter = dateFormatType6;
        Pattern patternCompile6 = Pattern.compile("^\\d+(-\\d+){2}+T(\\d+:){2}\\d+.\\d+(Z|([+-](\\d+:\\d+)))$");
        dateTimePattern = patternCompile6;
        DateFormatType dateFormatType7 = DateFormatType.XEP_0082_DATETIME_PROFILE;
        dateTimeNoMillisFormatter = dateFormatType7;
        Pattern patternCompile7 = Pattern.compile("^\\d+(-\\d+){2}+T(\\d+:){2}\\d+(Z|([+-](\\d+:\\d+)))$");
        dateTimeNoMillisPattern = patternCompile7;
        TIME_ZONE_UTC = TimeZone.getTimeZone("UTC");
        xep0091Formatter = new ThreadLocal<DateFormat>() { // from class: org.jxmpp.util.XmppDateTime.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public DateFormat initialValue() {
                return XmppDateTime.constructUtcDateFormat("yyyyMMdd'T'HH:mm:ss");
            }
        };
        xep0091Date6DigitFormatter = new ThreadLocal<DateFormat>() { // from class: org.jxmpp.util.XmppDateTime.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public DateFormat initialValue() {
                return XmppDateTime.constructUtcDateFormat("yyyyMd'T'HH:mm:ss");
            }
        };
        xep0091Date7Digit1MonthFormatter = new ThreadLocal<DateFormat>() { // from class: org.jxmpp.util.XmppDateTime.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public DateFormat initialValue() {
                DateFormat dateFormatConstructUtcDateFormat = XmppDateTime.constructUtcDateFormat("yyyyMdd'T'HH:mm:ss");
                dateFormatConstructUtcDateFormat.setLenient(false);
                return dateFormatConstructUtcDateFormat;
            }
        };
        xep0091Date7Digit2MonthFormatter = new ThreadLocal<DateFormat>() { // from class: org.jxmpp.util.XmppDateTime.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public DateFormat initialValue() {
                DateFormat dateFormatConstructUtcDateFormat = XmppDateTime.constructUtcDateFormat("yyyyMMd'T'HH:mm:ss");
                dateFormatConstructUtcDateFormat.setLenient(false);
                return dateFormatConstructUtcDateFormat;
            }
        };
        xep0091Pattern = Pattern.compile("^\\d+T\\d+:\\d+:\\d+$");
        ArrayList arrayList = new ArrayList();
        couplings = arrayList;
        arrayList.add(new PatternCouplings(patternCompile, dateFormatType));
        arrayList.add(new PatternCouplings(patternCompile6, dateFormatType6));
        arrayList.add(new PatternCouplings(patternCompile7, dateFormatType7));
        arrayList.add(new PatternCouplings(patternCompile2, dateFormatType2));
        arrayList.add(new PatternCouplings(patternCompile3, dateFormatType3));
        arrayList.add(new PatternCouplings(patternCompile4, dateFormatType4));
        arrayList.add(new PatternCouplings(patternCompile5, dateFormatType5));
        SECOND_FRACTION = Pattern.compile(".*\\.(\\d{1,})(Z|((\\+|-)\\d{4}))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DateFormat constructUtcDateFormat(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TIME_ZONE_UTC);
        return simpleDateFormat;
    }

    private enum DateFormatType {
        XEP_0082_DATE_PROFILE("yyyy-MM-dd"),
        XEP_0082_DATETIME_PROFILE(b.f1309e),
        XEP_0082_DATETIME_MILLIS_PROFILE(Util.ISO_8601_FORMAT),
        XEP_0082_TIME_PROFILE("hh:mm:ss"),
        XEP_0082_TIME_ZONE_PROFILE("hh:mm:ssZ"),
        XEP_0082_TIME_MILLIS_PROFILE("hh:mm:ss.SSS"),
        XEP_0082_TIME_MILLIS_ZONE_PROFILE("hh:mm:ss.SSSZ"),
        XEP_0091_DATETIME("yyyyMMdd'T'HH:mm:ss");

        private final boolean CONVERT_TIMEZONE;
        private final ThreadLocal<DateFormat> FORMATTER = new ThreadLocal<DateFormat>() { // from class: org.jxmpp.util.XmppDateTime.DateFormatType.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public DateFormat initialValue() {
                return XmppDateTime.constructUtcDateFormat(DateFormatType.this.FORMAT_STRING);
            }
        };
        private final String FORMAT_STRING;
        private final boolean HANDLE_MILLIS;

        DateFormatType(String str) {
            this.FORMAT_STRING = str;
            this.CONVERT_TIMEZONE = str.charAt(str.length() - 1) == 'Z';
            this.HANDLE_MILLIS = str.contains("SSS");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String format(Date date) {
            String str = this.FORMATTER.get().format(date);
            return this.CONVERT_TIMEZONE ? XmppDateTime.convertRfc822TimezoneToXep82(str) : str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Date parse(String str) throws ParseException {
            if (this.CONVERT_TIMEZONE) {
                str = XmppDateTime.convertXep82TimezoneToRfc822(str);
            }
            if (this.HANDLE_MILLIS) {
                str = XmppDateTime.handleMilliseconds(str);
            }
            return this.FORMATTER.get().parse(str);
        }
    }

    public static Date parseXEP0082Date(String str) throws ParseException {
        for (PatternCouplings patternCouplings : couplings) {
            if (patternCouplings.pattern.matcher(str).matches()) {
                return patternCouplings.formatter.parse(str);
            }
        }
        return dateTimeNoMillisFormatter.parse(str);
    }

    public static Date parseDate(String str) throws ParseException {
        if (xep0091Pattern.matcher(str).matches()) {
            int length = str.split(ExifInterface.GPS_DIRECTION_TRUE)[0].length();
            if (length < 8) {
                Date dateHandleDateWithMissingLeadingZeros = handleDateWithMissingLeadingZeros(str, length);
                if (dateHandleDateWithMissingLeadingZeros != null) {
                    return dateHandleDateWithMissingLeadingZeros;
                }
            } else {
                return xep0091Formatter.get().parse(str);
            }
        }
        return parseXEP0082Date(str);
    }

    public static String formatXEP0082Date(Date date) {
        return dateTimeFormatter.format(date);
    }

    public static String convertXep82TimezoneToRfc822(String str) {
        if (str.charAt(str.length() - 1) == 'Z') {
            return str.replace("Z", "+0000");
        }
        return str.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
    }

    public static String convertRfc822TimezoneToXep82(String str) {
        int length = str.length();
        int i = length - 2;
        return (str.substring(0, i) + ':') + str.substring(i, length);
    }

    public static String asString(TimeZone timeZone) {
        int rawOffset = timeZone.getRawOffset();
        int i = rawOffset / DateTimeConstants.MILLIS_PER_HOUR;
        return String.format("%+d:%02d", Integer.valueOf(i), Integer.valueOf(Math.abs((rawOffset / DateTimeConstants.MILLIS_PER_MINUTE) - (i * 60))));
    }

    private static Date handleDateWithMissingLeadingZeros(String str, int i) throws ParseException {
        if (i == 6) {
            return xep0091Date6DigitFormatter.get().parse(str);
        }
        Calendar calendar = Calendar.getInstance();
        List<Calendar> listFilterDatesBefore = filterDatesBefore(calendar, parseXEP91Date(str, xep0091Date7Digit1MonthFormatter.get()), parseXEP91Date(str, xep0091Date7Digit2MonthFormatter.get()));
        if (listFilterDatesBefore.isEmpty()) {
            return null;
        }
        return determineNearestDate(calendar, listFilterDatesBefore).getTime();
    }

    private static Calendar parseXEP91Date(String str, DateFormat dateFormat) {
        try {
            dateFormat.parse(str);
            return dateFormat.getCalendar();
        } catch (ParseException unused) {
            return null;
        }
    }

    private static List<Calendar> filterDatesBefore(Calendar calendar, Calendar... calendarArr) {
        ArrayList arrayList = new ArrayList();
        for (Calendar calendar2 : calendarArr) {
            if (calendar2 != null && calendar2.before(calendar)) {
                arrayList.add(calendar2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String handleMilliseconds(String str) {
        int length;
        Matcher matcher = SECOND_FRACTION.matcher(str);
        if (!matcher.matches() || (length = matcher.group(1).length()) == 3) {
            return str;
        }
        int iIndexOf = str.indexOf(InstructionFileId.DOT);
        StringBuilder sb = new StringBuilder((str.length() - length) + 3);
        if (length > 3) {
            sb.append(str.substring(0, iIndexOf + 4));
        } else {
            sb.append(str.substring(0, iIndexOf + length + 1));
            for (int i = length; i < 3; i++) {
                sb.append('0');
            }
        }
        sb.append(str.substring(iIndexOf + length + 1));
        return sb.toString();
    }

    private static Calendar determineNearestDate(final Calendar calendar, List<Calendar> list) {
        Collections.sort(list, new Comparator<Calendar>() { // from class: org.jxmpp.util.XmppDateTime.5
            @Override // java.util.Comparator
            public int compare(Calendar calendar2, Calendar calendar3) {
                return Long.valueOf(calendar.getTimeInMillis() - calendar2.getTimeInMillis()).compareTo(Long.valueOf(calendar.getTimeInMillis() - calendar3.getTimeInMillis()));
            }
        });
        return list.get(0);
    }

    private static class PatternCouplings {
        final DateFormatType formatter;
        final Pattern pattern;

        PatternCouplings(Pattern pattern, DateFormatType dateFormatType) {
            this.pattern = pattern;
            this.formatter = dateFormatType;
        }
    }
}
