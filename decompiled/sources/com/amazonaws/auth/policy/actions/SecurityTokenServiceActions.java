package com.amazonaws.auth.policy.actions;

import com.amazonaws.auth.policy.Action;

/* JADX INFO: loaded from: classes4.dex */
public enum SecurityTokenServiceActions implements Action {
    AllSecurityTokenServiceActions("sts:*"),
    AssumeRole("sts:AssumeRole"),
    AssumeRoleWithWebIdentity("sts:AssumeRoleWithWebIdentity"),
    GetCallerIdentity("sts:GetCallerIdentity"),
    GetFederationToken("sts:GetFederationToken"),
    GetSessionToken("sts:GetSessionToken");

    private final String action;

    SecurityTokenServiceActions(String str) {
        this.action = str;
    }

    @Override // com.amazonaws.auth.policy.Action
    public String getActionName() {
        return this.action;
    }
}
