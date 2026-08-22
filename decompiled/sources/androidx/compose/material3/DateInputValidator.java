package androidx.compose.material3;

import androidx.compose.material3.internal.DateInputFormat;
import com.x5.template.ThemeConfig;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement;

/* JADX INFO: compiled from: DateInput.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0004\b#\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016¨\u0006%"}, d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "<init>", "(Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "currentStartDateMillis", "", "getCurrentStartDateMillis", "()Ljava/lang/Long;", "setCurrentStartDateMillis", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "currentEndDateMillis", "getCurrentEndDateMillis", "setCurrentEndDateMillis", ValidateElement.ELEMENT, "dateToValidate", "Landroidx/compose/material3/internal/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", ThemeConfig.LOCALE, "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "validate-XivgLIo", "(Landroidx/compose/material3/internal/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DateInputValidator {
    public static final int $stable = 0;
    private Long currentEndDateMillis;
    private Long currentStartDateMillis;
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final SelectableDates selectableDates;
    private final IntRange yearRange;

    public DateInputValidator(IntRange intRange, SelectableDates selectableDates, DateInputFormat dateInputFormat, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4) {
        this.yearRange = intRange;
        this.selectableDates = selectableDates;
        this.dateInputFormat = dateInputFormat;
        this.dateFormatter = datePickerFormatter;
        this.errorDatePattern = str;
        this.errorDateOutOfYearRange = str2;
        this.errorInvalidNotAllowed = str3;
        this.errorInvalidRangeInput = str4;
    }

    public final Long getCurrentStartDateMillis() {
        return this.currentStartDateMillis;
    }

    public final void setCurrentStartDateMillis(Long l) {
        this.currentStartDateMillis = l;
    }

    public final Long getCurrentEndDateMillis() {
        return this.currentEndDateMillis;
    }

    public final void setCurrentEndDateMillis(Long l) {
        this.currentEndDateMillis = l;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX INFO: renamed from: validate-XivgLIo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m2719validateXivgLIo(androidx.compose.material3.internal.CalendarDate r8, int r9, java.util.Locale r10) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.m2719validateXivgLIo(androidx.compose.material3.internal.CalendarDate, int, java.util.Locale):java.lang.String");
    }
}
