package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GetFederationTokenRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer durationSeconds;
    private String name;
    private String policy;
    private List<PolicyDescriptorType> policyArns;

    public GetFederationTokenRequest() {
    }

    public GetFederationTokenRequest(String str) {
        setName(str);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public GetFederationTokenRequest withName(String str) {
        this.name = str;
        return this;
    }

    public String getPolicy() {
        return this.policy;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public GetFederationTokenRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public List<PolicyDescriptorType> getPolicyArns() {
        return this.policyArns;
    }

    public void setPolicyArns(Collection<PolicyDescriptorType> collection) {
        if (collection == null) {
            this.policyArns = null;
        } else {
            this.policyArns = new ArrayList(collection);
        }
    }

    public GetFederationTokenRequest withPolicyArns(PolicyDescriptorType... policyDescriptorTypeArr) {
        if (getPolicyArns() == null) {
            this.policyArns = new ArrayList(policyDescriptorTypeArr.length);
        }
        for (PolicyDescriptorType policyDescriptorType : policyDescriptorTypeArr) {
            this.policyArns.add(policyDescriptorType);
        }
        return this;
    }

    public GetFederationTokenRequest withPolicyArns(Collection<PolicyDescriptorType> collection) {
        setPolicyArns(collection);
        return this;
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public GetFederationTokenRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getName() != null) {
            sb.append("Name: " + getName() + Constants.SEPARATOR_COMMA);
        }
        if (getPolicy() != null) {
            sb.append("Policy: " + getPolicy() + Constants.SEPARATOR_COMMA);
        }
        if (getPolicyArns() != null) {
            sb.append("PolicyArns: " + getPolicyArns() + Constants.SEPARATOR_COMMA);
        }
        if (getDurationSeconds() != null) {
            sb.append("DurationSeconds: " + getDurationSeconds());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getName() == null ? 0 : getName().hashCode()) + 31) * 31) + (getPolicy() == null ? 0 : getPolicy().hashCode())) * 31) + (getPolicyArns() == null ? 0 : getPolicyArns().hashCode())) * 31) + (getDurationSeconds() != null ? getDurationSeconds().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetFederationTokenRequest)) {
            return false;
        }
        GetFederationTokenRequest getFederationTokenRequest = (GetFederationTokenRequest) obj;
        if ((getFederationTokenRequest.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (getFederationTokenRequest.getName() != null && !getFederationTokenRequest.getName().equals(getName())) {
            return false;
        }
        if ((getFederationTokenRequest.getPolicy() == null) ^ (getPolicy() == null)) {
            return false;
        }
        if (getFederationTokenRequest.getPolicy() != null && !getFederationTokenRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if ((getFederationTokenRequest.getPolicyArns() == null) ^ (getPolicyArns() == null)) {
            return false;
        }
        if (getFederationTokenRequest.getPolicyArns() != null && !getFederationTokenRequest.getPolicyArns().equals(getPolicyArns())) {
            return false;
        }
        if ((getFederationTokenRequest.getDurationSeconds() == null) ^ (getDurationSeconds() == null)) {
            return false;
        }
        return getFederationTokenRequest.getDurationSeconds() == null || getFederationTokenRequest.getDurationSeconds().equals(getDurationSeconds());
    }
}
