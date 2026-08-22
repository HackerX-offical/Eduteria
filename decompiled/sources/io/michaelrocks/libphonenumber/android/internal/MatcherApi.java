package io.michaelrocks.libphonenumber.android.internal;

import io.michaelrocks.libphonenumber.android.Phonemetadata;

/* JADX INFO: loaded from: classes9.dex */
public interface MatcherApi {
    boolean matchNationalNumber(CharSequence number, Phonemetadata.PhoneNumberDesc numberDesc, boolean allowPrefixMatch);
}
