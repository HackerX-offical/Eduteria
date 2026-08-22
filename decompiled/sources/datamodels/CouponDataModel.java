package datamodels;

import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class CouponDataModel implements Serializable {
    public String coupon_brand;
    public String coupon_brand_info;
    public String coupon_brand_url;
    public String coupon_content;
    public int coupon_id;
    public String coupon_image_location;
    public String coupon_image_name;
    public String coupon_offer_title;
    public float coupon_price;
    public int coupon_selectedFlag;
    public String coupon_site_address;
    public String coupon_tnc;
    public String coupon_validity;

    public CouponDataModel(int i, String str, String str2, String str3, String str4, float f2, String str5, String str6, String str7, String str8, int i2) {
        this.coupon_id = i;
        this.coupon_brand = str;
        this.coupon_offer_title = str2;
        this.coupon_brand_info = str3;
        this.coupon_tnc = str4;
        this.coupon_price = f2;
        this.coupon_content = str5;
        this.coupon_validity = str6;
        this.coupon_site_address = str7;
        this.coupon_image_location = str8;
        this.coupon_selectedFlag = i2;
    }

    public CouponDataModel(int i, String str, String str2, String str3, String str4, float f2, String str5, String str6, int i2, String str7) {
        this.coupon_id = i;
        this.coupon_brand = str;
        this.coupon_offer_title = str2;
        this.coupon_brand_url = str3;
        this.coupon_tnc = str4;
        this.coupon_price = f2;
        this.coupon_content = this.coupon_content;
        this.coupon_validity = str5;
        this.coupon_site_address = this.coupon_site_address;
        this.coupon_image_location = str6;
        this.coupon_selectedFlag = i2;
        this.coupon_image_name = str7;
    }

    public CouponDataModel(String str, String str2, float f2, String str3) {
        this.coupon_selectedFlag = 0;
        this.coupon_brand = str;
        this.coupon_offer_title = str2;
        this.coupon_price = f2;
        this.coupon_image_location = str3;
    }
}
