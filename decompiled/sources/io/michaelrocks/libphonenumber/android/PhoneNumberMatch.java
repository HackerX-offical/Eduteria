package io.michaelrocks.libphonenumber.android;

import com.clevertap.android.sdk.Constants;
import io.michaelrocks.libphonenumber.android.Phonenumber;
import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
public final class PhoneNumberMatch {
    private final Phonenumber.PhoneNumber number;
    private final String rawString;
    private final int start;

    PhoneNumberMatch(int start, String rawString, Phonenumber.PhoneNumber number) {
        if (start < 0) {
            throw new IllegalArgumentException("Start index must be >= 0.");
        }
        if (rawString == null || number == null) {
            throw null;
        }
        this.start = start;
        this.rawString = rawString;
        this.number = number;
    }

    public Phonenumber.PhoneNumber number() {
        return this.number;
    }

    public int start() {
        return this.start;
    }

    public int end() {
        return this.start + this.rawString.length();
    }

    public String rawString() {
        return this.rawString;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.start), this.rawString, this.number});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneNumberMatch)) {
            return false;
        }
        PhoneNumberMatch phoneNumberMatch = (PhoneNumberMatch) obj;
        return this.rawString.equals(phoneNumberMatch.rawString) && this.start == phoneNumberMatch.start && this.number.equals(phoneNumberMatch.number);
    }

    public String toString() {
        return "PhoneNumberMatch [" + start() + Constants.SEPARATOR_COMMA + end() + ") " + this.rawString;
    }
}
