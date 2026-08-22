package com.appnew.android.Educator.model;

/* JADX INFO: loaded from: classes6.dex */
public class HomeTrendingClassItem {
    int courseBannerTC;
    String courseTitleTC;
    int discountTc;
    double originalPriceTC;
    double priceTC;
    int validityTC;

    public HomeTrendingClassItem(int courseBannerTC, String courseTitleTC, int validityTC, double priceTC, int discountTc, double originalPriceTC) {
        this.courseBannerTC = courseBannerTC;
        this.courseTitleTC = courseTitleTC;
        this.validityTC = validityTC;
        this.priceTC = priceTC;
        this.discountTc = discountTc;
        this.originalPriceTC = originalPriceTC;
    }

    public int getCourseBannerTC() {
        return this.courseBannerTC;
    }

    public void setCourseBannerTC(int courseBannerTC) {
        this.courseBannerTC = courseBannerTC;
    }

    public String getCourseTitleTC() {
        return this.courseTitleTC;
    }

    public void setCourseTitleTC(String courseTitleTC) {
        this.courseTitleTC = courseTitleTC;
    }

    public int getValidityTC() {
        return this.validityTC;
    }

    public void setValidityTC(int validityTC) {
        this.validityTC = validityTC;
    }

    public double getPriceTC() {
        return this.priceTC;
    }

    public void setPriceTC(double priceTC) {
        this.priceTC = priceTC;
    }

    public int getDiscountTc() {
        return this.discountTc;
    }

    public void setDiscountTc(int discountTc) {
        this.discountTc = discountTc;
    }

    public double getOriginalPriceTC() {
        return this.originalPriceTC;
    }

    public void setOriginalPriceTC(double originalPriceTC) {
        this.originalPriceTC = originalPriceTC;
    }
}
