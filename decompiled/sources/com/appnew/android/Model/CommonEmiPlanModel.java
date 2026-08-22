package com.appnew.android.Model;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class CommonEmiPlanModel {
    List<String> cycleList;
    List<String> cycleList_date_ms;
    List<String> emiList;
    List<String> taxList;
    List<String> total_amount;

    public CommonEmiPlanModel(List<String> cycleList, List<String> emiList, List<String> taxList, List<String> cycleList_date_ms) {
        this.cycleList = cycleList;
        this.emiList = emiList;
        this.taxList = taxList;
        this.cycleList_date_ms = cycleList_date_ms;
    }

    public List<String> getCycleList() {
        return this.cycleList;
    }

    public void setCycleList(List<String> cycleList) {
        this.cycleList = cycleList;
    }

    public List<String> getEmiList() {
        return this.emiList;
    }

    public void setEmiList(List<String> emiList) {
        this.emiList = emiList;
    }

    public List<String> getTaxList() {
        return this.taxList;
    }

    public void setTaxList(List<String> taxList) {
        this.taxList = taxList;
    }

    public List<String> getCycleList_date_ms() {
        return this.cycleList_date_ms;
    }

    public void setCycleList_date_ms(List<String> cycleList_date_ms) {
        this.cycleList_date_ms = cycleList_date_ms;
    }

    public CommonEmiPlanModel(List<String> cycleList, List<String> emiList, List<String> taxList, List<String> cycleList_date_ms, List<String> total_amount) {
        this.cycleList = cycleList;
        this.emiList = emiList;
        this.taxList = taxList;
        this.cycleList_date_ms = cycleList_date_ms;
        this.total_amount = total_amount;
    }

    public List<String> getTotal_amount() {
        return this.total_amount;
    }

    public void setTotal_amount(List<String> total_amount) {
        this.total_amount = total_amount;
    }
}
