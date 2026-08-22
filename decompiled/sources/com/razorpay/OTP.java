package com.razorpay;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class OTP {
    String bank;
    String pin;
    String sender;

    OTP(String str, String str2, String str3) {
        this.pin = str;
        this.bank = str2;
        this.sender = str3;
        sanitizeOTP();
    }

    private void sanitizeOTP() {
        if (!Pattern.compile("^\\d").matcher(this.pin).find()) {
            this.pin = this.pin.substring(1);
        }
        if (Pattern.compile("\\d$").matcher(this.pin).find()) {
            return;
        }
        String str = this.pin;
        this.pin = str.substring(0, str.length() - 1);
    }

    String getBank() {
        return this.bank;
    }

    String getSender() {
        return this.sender;
    }

    String getPin() {
        return this.pin;
    }

    public String toString() {
        return "Pin: " + this.pin + " bank: " + this.bank + " sender: " + this.sender;
    }
}
