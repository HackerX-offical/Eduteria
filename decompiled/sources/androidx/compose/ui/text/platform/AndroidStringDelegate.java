package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.PlatformStringDelegate;
import androidx.compose.ui.text.intl.Locale;
import com.x5.template.ThemeConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: AndroidStringDelegate.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidStringDelegate;", "Landroidx/compose/ui/text/PlatformStringDelegate;", "<init>", "()V", "toUpperCase", "", "string", ThemeConfig.LOCALE, "Landroidx/compose/ui/text/intl/Locale;", "toLowerCase", "capitalize", "decapitalize", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidStringDelegate implements PlatformStringDelegate {
    public static final int $stable = 0;

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String toUpperCase(String string, Locale locale) {
        String upperCase = string.toUpperCase(locale.getPlatformLocale());
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String toLowerCase(String string, Locale locale) {
        String lowerCase = string.toLowerCase(locale.getPlatformLocale());
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String capitalize(String string, Locale locale) {
        if (string.length() <= 0) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = string.charAt(0);
        StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(cCharAt) ? CharsKt.titlecase(cCharAt, locale.getPlatformLocale()) : String.valueOf(cCharAt)));
        String strSubstring = string.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String decapitalize(String string, Locale locale) {
        if (string.length() <= 0) {
            return string;
        }
        StringBuilder sbAppend = new StringBuilder().append((Object) CharsKt.lowercase(string.charAt(0), locale.getPlatformLocale()));
        String strSubstring = string.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }
}
