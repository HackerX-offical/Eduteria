package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smackx.disco.Feature;

/* JADX INFO: loaded from: classes10.dex */
public enum PubSubFeature implements CharSequence {
    access_authorize(Feature.Support.optional),
    access_open(Feature.Support.optional),
    access_presence(Feature.Support.optional),
    access_roster(Feature.Support.optional),
    access_whitelist(Feature.Support.optional),
    auto_create(Feature.Support.optional),
    auto_subscribe(Feature.Support.recommended),
    collections(Feature.Support.optional),
    config_node(Feature.Support.recommended),
    create_and_configure(Feature.Support.recommended),
    create_nodes(Feature.Support.recommended),
    delete_items(Feature.Support.recommended),
    delete_nodes(Feature.Support.recommended),
    get_pending(Feature.Support.optional),
    item_ids(Feature.Support.recommended),
    last_published(Feature.Support.recommended),
    leased_subscription(Feature.Support.optional),
    manage_subscriptions(Feature.Support.optional),
    member_affiliation(Feature.Support.recommended),
    meta_data(Feature.Support.recommended),
    modify_affiliations(Feature.Support.optional),
    multi_collection(Feature.Support.optional),
    multi_subscribe(Feature.Support.optional),
    outcast_affiliation(Feature.Support.recommended),
    persistent_items(Feature.Support.recommended),
    presence_notifications(Feature.Support.optional),
    presence_subscribe(Feature.Support.recommended),
    publish(Feature.Support.required),
    publish_options(Feature.Support.optional),
    publish_only_affiliation(Feature.Support.optional),
    publisher_affiliation(Feature.Support.recommended),
    purge_nodes(Feature.Support.optional),
    retract_items(Feature.Support.optional),
    retrieve_affiliations(Feature.Support.recommended),
    retrieve_default(Feature.Support.recommended),
    retrieve_default_sub(Feature.Support.optional),
    retrieve_items(Feature.Support.recommended),
    retrieve_subscriptions(Feature.Support.recommended),
    subscribe(Feature.Support.required),
    subscription_options(Feature.Support.optional),
    subscriptions_notifications(Feature.Support.optional),
    instant_nodes(Feature.Support.recommended),
    filtered_notifications(Feature.Support.recommended);

    private final String feature;
    private final String qualifiedFeature;
    private final Feature.Support support;

    PubSubFeature(Feature.Support support) {
        String strReplace = name().replace('_', '-');
        this.feature = strReplace;
        this.qualifiedFeature = "http://jabber.org/protocol/pubsub#" + strReplace;
        this.support = support;
    }

    public String getFeatureName() {
        return this.feature;
    }

    @Override // java.lang.Enum, java.lang.CharSequence
    public String toString() {
        return this.qualifiedFeature;
    }

    public Feature.Support support() {
        return this.support;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.qualifiedFeature.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.qualifiedFeature.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.qualifiedFeature.subSequence(i, i2);
    }
}
