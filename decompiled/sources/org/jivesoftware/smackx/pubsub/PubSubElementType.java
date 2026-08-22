package org.jivesoftware.smackx.pubsub;

import com.android.billingclient.api.BillingClient;
import com.appnew.android.Utils.Const;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.util.Locale;
import org.jivesoftware.smackx.message_retraction.element.RetractElement;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

/* JADX INFO: loaded from: classes10.dex */
public enum PubSubElementType {
    CREATE("create", PubSubNamespace.basic),
    DELETE("delete", PubSubNamespace.owner),
    DELETE_EVENT("delete", PubSubNamespace.event),
    CONFIGURE("configure", PubSubNamespace.basic),
    CONFIGURE_OWNER("configure", PubSubNamespace.owner),
    CONFIGURATION("configuration", PubSubNamespace.event),
    OPTIONS(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, PubSubNamespace.basic),
    DEFAULT(CookieSpecs.DEFAULT, PubSubNamespace.owner),
    ITEMS(FirebaseAnalytics.Param.ITEMS, PubSubNamespace.basic),
    ITEMS_EVENT(FirebaseAnalytics.Param.ITEMS, PubSubNamespace.event),
    ITEM("item", PubSubNamespace.basic),
    ITEM_EVENT("item", PubSubNamespace.event),
    PUBLISH("publish", PubSubNamespace.basic),
    PUBLISH_OPTIONS("publish-options", PubSubNamespace.basic),
    PURGE_OWNER("purge", PubSubNamespace.owner),
    PURGE_EVENT("purge", PubSubNamespace.event),
    RETRACT(RetractElement.ELEMENT, PubSubNamespace.basic),
    AFFILIATIONS("affiliations", PubSubNamespace.basic),
    AFFILIATIONS_OWNER("affiliations", PubSubNamespace.owner),
    SUBSCRIBE("subscribe", PubSubNamespace.basic),
    SUBSCRIPTION(Const.SUBSCRIPTION, PubSubNamespace.basic),
    SUBSCRIPTIONS(BillingClient.FeatureType.SUBSCRIPTIONS, PubSubNamespace.basic),
    SUBSCRIPTIONS_OWNER(BillingClient.FeatureType.SUBSCRIPTIONS, PubSubNamespace.owner),
    UNSUBSCRIBE("unsubscribe", PubSubNamespace.basic);

    private final String eName;
    private final PubSubNamespace nSpace;

    PubSubElementType(String str, PubSubNamespace pubSubNamespace) {
        this.eName = str;
        this.nSpace = pubSubNamespace;
    }

    public PubSubNamespace getNamespace() {
        return this.nSpace;
    }

    public String getElementName() {
        return this.eName;
    }

    public static PubSubElementType valueOfFromElemName(String str, String str2) {
        int iLastIndexOf = str2.lastIndexOf(35);
        String strSubstring = iLastIndexOf == -1 ? null : str2.substring(iLastIndexOf + 1);
        if (strSubstring != null) {
            return valueOf((str + '_' + strSubstring).toUpperCase(Locale.US));
        }
        return valueOf(str.toUpperCase(Locale.US).replace('-', '_'));
    }
}
