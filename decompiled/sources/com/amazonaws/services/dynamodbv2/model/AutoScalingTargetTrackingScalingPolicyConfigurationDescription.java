package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class AutoScalingTargetTrackingScalingPolicyConfigurationDescription implements Serializable {
    private Boolean disableScaleIn;
    private Integer scaleInCooldown;
    private Integer scaleOutCooldown;
    private Double targetValue;

    public Boolean isDisableScaleIn() {
        return this.disableScaleIn;
    }

    public Boolean getDisableScaleIn() {
        return this.disableScaleIn;
    }

    public void setDisableScaleIn(Boolean bool) {
        this.disableScaleIn = bool;
    }

    public AutoScalingTargetTrackingScalingPolicyConfigurationDescription withDisableScaleIn(Boolean bool) {
        this.disableScaleIn = bool;
        return this;
    }

    public Integer getScaleInCooldown() {
        return this.scaleInCooldown;
    }

    public void setScaleInCooldown(Integer num) {
        this.scaleInCooldown = num;
    }

    public AutoScalingTargetTrackingScalingPolicyConfigurationDescription withScaleInCooldown(Integer num) {
        this.scaleInCooldown = num;
        return this;
    }

    public Integer getScaleOutCooldown() {
        return this.scaleOutCooldown;
    }

    public void setScaleOutCooldown(Integer num) {
        this.scaleOutCooldown = num;
    }

    public AutoScalingTargetTrackingScalingPolicyConfigurationDescription withScaleOutCooldown(Integer num) {
        this.scaleOutCooldown = num;
        return this;
    }

    public Double getTargetValue() {
        return this.targetValue;
    }

    public void setTargetValue(Double d2) {
        this.targetValue = d2;
    }

    public AutoScalingTargetTrackingScalingPolicyConfigurationDescription withTargetValue(Double d2) {
        this.targetValue = d2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getDisableScaleIn() != null) {
            sb.append("DisableScaleIn: " + getDisableScaleIn() + Constants.SEPARATOR_COMMA);
        }
        if (getScaleInCooldown() != null) {
            sb.append("ScaleInCooldown: " + getScaleInCooldown() + Constants.SEPARATOR_COMMA);
        }
        if (getScaleOutCooldown() != null) {
            sb.append("ScaleOutCooldown: " + getScaleOutCooldown() + Constants.SEPARATOR_COMMA);
        }
        if (getTargetValue() != null) {
            sb.append("TargetValue: " + getTargetValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getDisableScaleIn() == null ? 0 : getDisableScaleIn().hashCode()) + 31) * 31) + (getScaleInCooldown() == null ? 0 : getScaleInCooldown().hashCode())) * 31) + (getScaleOutCooldown() == null ? 0 : getScaleOutCooldown().hashCode())) * 31) + (getTargetValue() != null ? getTargetValue().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AutoScalingTargetTrackingScalingPolicyConfigurationDescription)) {
            return false;
        }
        AutoScalingTargetTrackingScalingPolicyConfigurationDescription autoScalingTargetTrackingScalingPolicyConfigurationDescription = (AutoScalingTargetTrackingScalingPolicyConfigurationDescription) obj;
        if ((autoScalingTargetTrackingScalingPolicyConfigurationDescription.getDisableScaleIn() == null) ^ (getDisableScaleIn() == null)) {
            return false;
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationDescription.getDisableScaleIn() != null && !autoScalingTargetTrackingScalingPolicyConfigurationDescription.getDisableScaleIn().equals(getDisableScaleIn())) {
            return false;
        }
        if ((autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleInCooldown() == null) ^ (getScaleInCooldown() == null)) {
            return false;
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleInCooldown() != null && !autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleInCooldown().equals(getScaleInCooldown())) {
            return false;
        }
        if ((autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleOutCooldown() == null) ^ (getScaleOutCooldown() == null)) {
            return false;
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleOutCooldown() != null && !autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleOutCooldown().equals(getScaleOutCooldown())) {
            return false;
        }
        if ((autoScalingTargetTrackingScalingPolicyConfigurationDescription.getTargetValue() == null) ^ (getTargetValue() == null)) {
            return false;
        }
        return autoScalingTargetTrackingScalingPolicyConfigurationDescription.getTargetValue() == null || autoScalingTargetTrackingScalingPolicyConfigurationDescription.getTargetValue().equals(getTargetValue());
    }
}
