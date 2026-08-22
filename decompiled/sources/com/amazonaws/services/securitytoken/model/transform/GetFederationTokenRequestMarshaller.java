package com.amazonaws.services.securitytoken.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.services.securitytoken.model.GetFederationTokenRequest;
import com.amazonaws.services.securitytoken.model.PolicyDescriptorType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class GetFederationTokenRequestMarshaller implements Marshaller<Request<GetFederationTokenRequest>, GetFederationTokenRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<GetFederationTokenRequest> marshall(GetFederationTokenRequest getFederationTokenRequest) {
        if (getFederationTokenRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(GetFederationTokenRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(getFederationTokenRequest, "AWSSecurityTokenService");
        defaultRequest.addParameter(JsonDocumentFields.ACTION, "GetFederationToken");
        defaultRequest.addParameter("Version", "2011-06-15");
        if (getFederationTokenRequest.getName() != null) {
            defaultRequest.addParameter(Constants.KEY_ENCRYPTION_NAME, StringUtils.fromString(getFederationTokenRequest.getName()));
        }
        if (getFederationTokenRequest.getPolicy() != null) {
            defaultRequest.addParameter("Policy", StringUtils.fromString(getFederationTokenRequest.getPolicy()));
        }
        if (getFederationTokenRequest.getPolicyArns() != null) {
            int i = 1;
            for (PolicyDescriptorType policyDescriptorType : getFederationTokenRequest.getPolicyArns()) {
                String str = "PolicyArns.member." + i;
                if (policyDescriptorType != null) {
                    PolicyDescriptorTypeStaxMarshaller.getInstance().marshall(policyDescriptorType, defaultRequest, str + InstructionFileId.DOT);
                }
                i++;
            }
        }
        if (getFederationTokenRequest.getDurationSeconds() != null) {
            defaultRequest.addParameter("DurationSeconds", StringUtils.fromInteger(getFederationTokenRequest.getDurationSeconds()));
        }
        return defaultRequest;
    }
}
