package datamodels;

import java.io.Serializable;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes9.dex */
public class EmiPlansModel implements Serializable {
    public double emi_amount;
    public String emi_desc;
    public double emi_discount;
    public double emi_interest;
    public String emi_plan_id;
    public double emi_process_flat;
    public double emi_roi;
    public double emi_tenure;
    public double emi_total_cost;
    public double principal_amount;

    public EmiPlansModel(String str, String str2, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.emi_plan_id = str;
        this.emi_desc = str2;
        this.emi_amount = d2;
        this.principal_amount = d3;
        this.emi_total_cost = d4;
        this.emi_tenure = d5;
        this.emi_roi = d6;
        this.emi_process_flat = d7;
        this.emi_discount = d8;
        this.emi_interest = d9;
    }

    public EmiPlansModel() {
    }

    public String getEmi_plan_id() {
        return this.emi_plan_id;
    }

    public void setEmi_plan_id(String str) {
        this.emi_plan_id = str;
    }

    public String getEmi_desc() {
        return this.emi_desc;
    }

    public void setEmi_desc(String str) {
        this.emi_desc = str;
    }

    public double getEmi_amount() {
        return this.emi_amount;
    }

    public void setEmi_amount(double d2) {
        this.emi_amount = Double.parseDouble(new DecimalFormat("##.##").format(d2));
    }

    public double getEmi_tenure() {
        return this.emi_tenure;
    }

    public void setEmi_tenure(double d2) {
        this.emi_tenure = Double.parseDouble(new DecimalFormat("##.##").format(d2));
    }

    public double getEmi_roi() {
        return this.emi_roi;
    }

    public void setEmi_roi(double d2) {
        this.emi_roi = Double.parseDouble(new DecimalFormat("##.##").format(d2));
    }

    public double getEmi_process_flat() {
        return this.emi_process_flat;
    }

    public void setEmi_process_flat(double d2) {
        this.emi_process_flat = Double.parseDouble(new DecimalFormat("##.##").format(d2));
    }

    public double getEmi_discount() {
        return this.emi_discount;
    }

    public void setEmi_discount(double d2) {
        this.emi_discount = Double.parseDouble(new DecimalFormat("##.##").format(d2));
    }

    public double getEmi_interest() {
        return this.emi_interest;
    }

    public void setEmi_interest(double d2) {
        this.emi_interest = Double.parseDouble(new DecimalFormat("##.##").format(d2));
    }

    public double getPrincipal_amount() {
        return this.principal_amount;
    }

    public void setPrincipal_amount(double d2) {
        this.principal_amount = Double.parseDouble(new DecimalFormat("##.##").format(d2));
    }

    public double getEmi_total_cost() {
        return this.emi_total_cost;
    }

    public void setEmi_total_cost(double d2) {
        this.emi_total_cost = Double.parseDouble(new DecimalFormat("##.##").format(d2));
    }
}
