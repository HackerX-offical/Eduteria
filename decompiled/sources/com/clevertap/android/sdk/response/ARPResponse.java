package com.clevertap.android.sdk.response;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.network.ArpRepo;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.validation.Validator;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class ARPResponse extends CleverTapResponseDecorator {
    private final ArpRepo arpRepo;
    private final CleverTapInstanceConfig config;
    private final CTProductConfigController ctProductConfigController;
    private final Logger logger;
    private final Validator validator;

    public ARPResponse(CleverTapInstanceConfig cleverTapInstanceConfig, Validator validator, ControllerManager controllerManager, ArpRepo arpRepo) {
        this.config = cleverTapInstanceConfig;
        this.ctProductConfigController = controllerManager.getCTProductConfigController();
        this.logger = cleverTapInstanceConfig.getLogger();
        this.validator = validator;
        this.arpRepo = arpRepo;
    }

    @Override // com.clevertap.android.sdk.response.CleverTapResponseDecorator, com.clevertap.android.sdk.response.CleverTapResponse
    public void processResponse(JSONObject jSONObject, String str, Context context) {
        try {
            if (jSONObject.has("arp")) {
                JSONObject jSONObject2 = (JSONObject) jSONObject.get("arp");
                if (jSONObject2.length() > 0) {
                    CTProductConfigController cTProductConfigController = this.ctProductConfigController;
                    if (cTProductConfigController != null) {
                        cTProductConfigController.setArpValue(jSONObject2);
                    }
                    try {
                        processDiscardedEventsList(jSONObject2);
                    } catch (Throwable th) {
                        this.logger.verbose("Error handling discarded events response: " + th.getLocalizedMessage());
                    }
                    this.arpRepo.handleARPUpdate(context, jSONObject2);
                }
            }
        } catch (Throwable th2) {
            this.logger.verbose(this.config.getAccountId(), "Failed to process ARP", th2);
        }
    }

    private void processDiscardedEventsList(JSONObject jSONObject) {
        if (!jSONObject.has(Constants.DISCARDED_EVENT_JSON_KEY)) {
            this.logger.verbose(this.config.getAccountId(), "ARP doesn't contain the Discarded Events key");
            return;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            JSONArray jSONArray = jSONObject.getJSONArray(Constants.DISCARDED_EVENT_JSON_KEY);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            Validator validator = this.validator;
            if (validator != null) {
                validator.setDiscardedEvents(arrayList);
            } else {
                this.logger.verbose(this.config.getAccountId(), "Validator object is NULL");
            }
        } catch (JSONException e2) {
            this.logger.verbose(this.config.getAccountId(), "Error parsing discarded events list" + e2.getLocalizedMessage());
        }
    }
}
