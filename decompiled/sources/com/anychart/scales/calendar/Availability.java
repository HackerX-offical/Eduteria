package com.anychart.scales.calendar;

import com.anychart.JsObject;
import com.anychart.enums.AvailabilityPeriod;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class Availability extends JsObject {
    public Availability(AvailabilityPeriod availabilityPeriod, Number number, Number number2, Boolean bool, Number number3, Number number4, Number number5) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, number2, bool, number3, number4, number5));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, Number number2, Boolean bool, Number number3, Number number4, String str) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, number2, bool, number3, number4, wrapQuotes(str)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, Number number2, Boolean bool, Number number3, String str, Number number4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, number2, bool, number3, wrapQuotes(str), number4));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, Number number2, Boolean bool, Number number3, String str, String str2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, number2, bool, number3, wrapQuotes(str), wrapQuotes(str2)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, Number number2, Boolean bool, String str, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, number2, bool, wrapQuotes(str), number3, number4));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, Number number2, Boolean bool, String str, Number number3, String str2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, number2, bool, wrapQuotes(str), number3, wrapQuotes(str2)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, Number number2, Boolean bool, String str, String str2, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, number2, bool, wrapQuotes(str), wrapQuotes(str2), number3));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, Number number2, Boolean bool, String str, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, number2, bool, wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, String str, Boolean bool, Number number2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, wrapQuotes(str), bool, number2, number3, number4));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, String str, Boolean bool, Number number2, Number number3, String str2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, wrapQuotes(str), bool, number2, number3, wrapQuotes(str2)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, String str, Boolean bool, Number number2, String str2, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, wrapQuotes(str), bool, number2, wrapQuotes(str2), number3));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, String str, Boolean bool, Number number2, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, wrapQuotes(str), bool, number2, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, String str, Boolean bool, String str2, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, wrapQuotes(str), bool, wrapQuotes(str2), number2, number3));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, String str, Boolean bool, String str2, Number number2, String str3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, wrapQuotes(str), bool, wrapQuotes(str2), number2, wrapQuotes(str3)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, String str, Boolean bool, String str2, String str3, Number number2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, wrapQuotes(str), bool, wrapQuotes(str2), wrapQuotes(str3), number2));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, Number number, String str, Boolean bool, String str2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, number, wrapQuotes(str), bool, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, Number number, Boolean bool, Number number2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), number, bool, number2, number3, number4));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, Number number, Boolean bool, Number number2, Number number3, String str2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), number, bool, number2, number3, wrapQuotes(str2)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, Number number, Boolean bool, Number number2, String str2, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), number, bool, number2, wrapQuotes(str2), number3));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, Number number, Boolean bool, Number number2, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), number, bool, number2, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, Number number, Boolean bool, String str2, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), number, bool, wrapQuotes(str2), number2, number3));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, Number number, Boolean bool, String str2, Number number2, String str3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), number, bool, wrapQuotes(str2), number2, wrapQuotes(str3)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, Number number, Boolean bool, String str2, String str3, Number number2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), number, bool, wrapQuotes(str2), wrapQuotes(str3), number2));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, Number number, Boolean bool, String str2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), number, bool, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, String str2, Boolean bool, Number number, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), bool, number, number2, number3));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, String str2, Boolean bool, Number number, Number number2, String str3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), bool, number, number2, wrapQuotes(str3)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, String str2, Boolean bool, Number number, String str3, Number number2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), bool, number, wrapQuotes(str3), number2));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, String str2, Boolean bool, Number number, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), bool, number, wrapQuotes(str3), wrapQuotes(str4)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, String str2, Boolean bool, String str3, Number number, Number number2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), bool, wrapQuotes(str3), number, number2));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, String str2, Boolean bool, String str3, Number number, String str4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), bool, wrapQuotes(str3), number, wrapQuotes(str4)));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, String str2, Boolean bool, String str3, String str4, Number number) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), bool, wrapQuotes(str3), wrapQuotes(str4), number));
    }

    public Availability(AvailabilityPeriod availabilityPeriod, String str, String str2, Boolean bool, String str3, String str4, String str5) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", availabilityPeriod != null ? availabilityPeriod.getJsBase() : null, wrapQuotes(str), wrapQuotes(str2), bool, wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5)));
    }

    public Availability(String str, Number number, Number number2, Boolean bool, Number number3, Number number4, Number number5) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, number2, bool, number3, number4, number5));
    }

    public Availability(String str, Number number, Number number2, Boolean bool, Number number3, Number number4, String str2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, number2, bool, number3, number4, wrapQuotes(str2)));
    }

    public Availability(String str, Number number, Number number2, Boolean bool, Number number3, String str2, Number number4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, number2, bool, number3, wrapQuotes(str2), number4));
    }

    public Availability(String str, Number number, Number number2, Boolean bool, Number number3, String str2, String str3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, number2, bool, number3, wrapQuotes(str2), wrapQuotes(str3)));
    }

    public Availability(String str, Number number, Number number2, Boolean bool, String str2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, number2, bool, wrapQuotes(str2), number3, number4));
    }

    public Availability(String str, Number number, Number number2, Boolean bool, String str2, Number number3, String str3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, number2, bool, wrapQuotes(str2), number3, wrapQuotes(str3)));
    }

    public Availability(String str, Number number, Number number2, Boolean bool, String str2, String str3, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, number2, bool, wrapQuotes(str2), wrapQuotes(str3), number3));
    }

    public Availability(String str, Number number, Number number2, Boolean bool, String str2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, number2, bool, wrapQuotes(str2), wrapQuotes(str3), wrapQuotes(str4)));
    }

    public Availability(String str, Number number, String str2, Boolean bool, Number number2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), bool, number2, number3, number4));
    }

    public Availability(String str, Number number, String str2, Boolean bool, Number number2, Number number3, String str3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), bool, number2, number3, wrapQuotes(str3)));
    }

    public Availability(String str, Number number, String str2, Boolean bool, Number number2, String str3, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), bool, number2, wrapQuotes(str3), number3));
    }

    public Availability(String str, Number number, String str2, Boolean bool, Number number2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), bool, number2, wrapQuotes(str3), wrapQuotes(str4)));
    }

    public Availability(String str, Number number, String str2, Boolean bool, String str3, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), bool, wrapQuotes(str3), number2, number3));
    }

    public Availability(String str, Number number, String str2, Boolean bool, String str3, Number number2, String str4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), bool, wrapQuotes(str3), number2, wrapQuotes(str4)));
    }

    public Availability(String str, Number number, String str2, Boolean bool, String str3, String str4, Number number2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), bool, wrapQuotes(str3), wrapQuotes(str4), number2));
    }

    public Availability(String str, Number number, String str2, Boolean bool, String str3, String str4, String str5) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), number, wrapQuotes(str2), bool, wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5)));
    }

    public Availability(String str, String str2, Number number, Boolean bool, Number number2, Number number3, Number number4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, bool, number2, number3, number4));
    }

    public Availability(String str, String str2, Number number, Boolean bool, Number number2, Number number3, String str3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, bool, number2, number3, wrapQuotes(str3)));
    }

    public Availability(String str, String str2, Number number, Boolean bool, Number number2, String str3, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, bool, number2, wrapQuotes(str3), number3));
    }

    public Availability(String str, String str2, Number number, Boolean bool, Number number2, String str3, String str4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, bool, number2, wrapQuotes(str3), wrapQuotes(str4)));
    }

    public Availability(String str, String str2, Number number, Boolean bool, String str3, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, bool, wrapQuotes(str3), number2, number3));
    }

    public Availability(String str, String str2, Number number, Boolean bool, String str3, Number number2, String str4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, bool, wrapQuotes(str3), number2, wrapQuotes(str4)));
    }

    public Availability(String str, String str2, Number number, Boolean bool, String str3, String str4, Number number2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, bool, wrapQuotes(str3), wrapQuotes(str4), number2));
    }

    public Availability(String str, String str2, Number number, Boolean bool, String str3, String str4, String str5) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), number, bool, wrapQuotes(str3), wrapQuotes(str4), wrapQuotes(str5)));
    }

    public Availability(String str, String str2, String str3, Boolean bool, Number number, Number number2, Number number3) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), bool, number, number2, number3));
    }

    public Availability(String str, String str2, String str3, Boolean bool, Number number, Number number2, String str4) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), bool, number, number2, wrapQuotes(str4)));
    }

    public Availability(String str, String str2, String str3, Boolean bool, Number number, String str4, Number number2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), bool, number, wrapQuotes(str4), number2));
    }

    public Availability(String str, String str2, String str3, Boolean bool, Number number, String str4, String str5) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), bool, number, wrapQuotes(str4), wrapQuotes(str5)));
    }

    public Availability(String str, String str2, String str3, Boolean bool, String str4, Number number, Number number2) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), bool, wrapQuotes(str4), number, number2));
    }

    public Availability(String str, String str2, String str3, Boolean bool, String str4, Number number, String str5) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), bool, wrapQuotes(str4), number, wrapQuotes(str5)));
    }

    public Availability(String str, String str2, String str3, Boolean bool, String str4, String str5, Number number) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), bool, wrapQuotes(str4), wrapQuotes(str5), number));
    }

    public Availability(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6) {
        this.js.append(String.format(Locale.US, "{each:%s, ends: %s, from: %s, isWorking: %s, on: %s, starts: %s, to: %s, } ", wrapQuotes(str), wrapQuotes(str2), wrapQuotes(str3), bool, wrapQuotes(str4), wrapQuotes(str5), wrapQuotes(str6)));
    }

    @Override // com.anychart.JsObject
    public String getJsBase() {
        return this.js.toString();
    }
}
