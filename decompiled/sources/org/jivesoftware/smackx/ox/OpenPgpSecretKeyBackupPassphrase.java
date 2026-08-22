package org.jivesoftware.smackx.ox;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes10.dex */
public class OpenPgpSecretKeyBackupPassphrase implements CharSequence {
    private static final Pattern PASSPHRASE_PATTERN = Pattern.compile("^([123456789ABCDEFGHIJKLMNPQRSTUVWXYZ]{4}-){5}[123456789ABCDEFGHIJKLMNPQRSTUVWXYZ]{4}$");
    private final String passphrase;

    public OpenPgpSecretKeyBackupPassphrase(String str) {
        if (!PASSPHRASE_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("Passphrase must be 24 upper case letters and numbers from the english alphabet without 'O' and '0', divided into blocks of 4 and separated with dashes ('-').");
        }
        this.passphrase = str;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.passphrase.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.passphrase.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.passphrase.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.passphrase;
    }
}
