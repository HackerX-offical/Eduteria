package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class MyRewardPoints implements Serializable {
    private String conversion_rate;
    private String current_wallet;
    private String id;
    private String minimum_coin_to_redeem;
    private String refer_code;
    private String refer_points;
    private String reward_points;
    private String total_earned_point;
    private String total_earned_wallet;

    public String getRefer_points() {
        return this.refer_points;
    }

    public void setRefer_points(String refer_points) {
        this.refer_points = refer_points;
    }

    public String getTotal_earned_wallet() {
        return this.total_earned_wallet;
    }

    public void setTotal_earned_wallet(String total_earned_wallet) {
        this.total_earned_wallet = total_earned_wallet;
    }

    public String getCurrent_wallet() {
        return this.current_wallet;
    }

    public void setCurrent_wallet(String current_wallet) {
        this.current_wallet = current_wallet;
    }

    public String getConversion_rate() {
        return this.conversion_rate;
    }

    public void setConversion_rate(String conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public String getTotal_earned_point() {
        return this.total_earned_point;
    }

    public void setTotal_earned_point(String total_earned_point) {
        this.total_earned_point = total_earned_point;
    }

    public String getMinimum_coin_to_redeem() {
        return this.minimum_coin_to_redeem;
    }

    public void setMinimum_coin_to_redeem(String minimum_coin_to_redeem) {
        this.minimum_coin_to_redeem = minimum_coin_to_redeem;
    }

    public String getRefer_code() {
        return this.refer_code;
    }

    public void setRefer_code(String refer_code) {
        this.refer_code = refer_code;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReward_points() {
        return this.reward_points;
    }

    public void setReward_points(String reward_points) {
        this.reward_points = reward_points;
    }

    public String toString() {
        return "ClassPojo [id = " + this.id + ", reward_points = " + this.reward_points + Constants.AES_SUFFIX;
    }
}
