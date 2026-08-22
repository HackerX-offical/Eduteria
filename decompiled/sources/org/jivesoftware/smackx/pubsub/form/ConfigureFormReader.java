package org.jivesoftware.smackx.pubsub.form;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.ChildrenAssociationPolicy;
import org.jivesoftware.smackx.pubsub.ConfigureNodeFields;
import org.jivesoftware.smackx.pubsub.ItemReply;
import org.jivesoftware.smackx.pubsub.NodeType;
import org.jivesoftware.smackx.pubsub.NotificationType;
import org.jivesoftware.smackx.pubsub.PublishModel;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.JidMultiFormField;
import org.jivesoftware.smackx.xdata.form.FormReader;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public interface ConfigureFormReader extends FormReader {
    public static final String FORM_TYPE = "http://jabber.org/protocol/pubsub#node_config";

    default AccessModel getAccessModel() {
        String firstValue = readFirstValue(ConfigureNodeFields.access_model.getFieldName());
        if (firstValue == null) {
            return null;
        }
        return AccessModel.valueOf(firstValue);
    }

    default String getBodyXSLT() {
        return readFirstValue(ConfigureNodeFields.body_xslt.getFieldName());
    }

    default List<String> getChildren() {
        return readStringValues(ConfigureNodeFields.children.getFieldName());
    }

    default ChildrenAssociationPolicy getChildrenAssociationPolicy() {
        String firstValue = readFirstValue(ConfigureNodeFields.children_association_policy.getFieldName());
        if (firstValue == null) {
            return null;
        }
        return ChildrenAssociationPolicy.valueOf(firstValue);
    }

    default List<Jid> getChildrenAssociationWhitelist() {
        FormField field = getField(ConfigureNodeFields.children_association_whitelist.getFieldName());
        if (field == null) {
            Collections.emptyList();
        }
        return ((JidMultiFormField) field.ifPossibleAs(JidMultiFormField.class)).getValues();
    }

    default Integer getChildrenMax() {
        return readInteger(ConfigureNodeFields.children_max.getFieldName());
    }

    default List<? extends CharSequence> getCollection() {
        return readValues(ConfigureNodeFields.collection.getFieldName());
    }

    default String getDataformXSLT() {
        return readFirstValue(ConfigureNodeFields.dataform_xslt.getFieldName());
    }

    default Boolean isDeliverPayloads() {
        return readBoolean(ConfigureNodeFields.deliver_payloads.getFieldName());
    }

    default ItemReply getItemReply() {
        String firstValue = readFirstValue(ConfigureNodeFields.itemreply.getFieldName());
        if (firstValue == null) {
            return null;
        }
        return ItemReply.valueOf(firstValue);
    }

    default Integer getMaxItems() {
        return readInteger(ConfigureNodeFields.max_items.getFieldName());
    }

    default Integer getMaxPayloadSize() {
        return readInteger(ConfigureNodeFields.max_payload_size.getFieldName());
    }

    default NodeType getNodeType() {
        String firstValue = readFirstValue(ConfigureNodeFields.node_type.getFieldName());
        if (firstValue == null) {
            return null;
        }
        return NodeType.valueOf(firstValue);
    }

    default Boolean isNotifyConfig() {
        return readBoolean(ConfigureNodeFields.notify_config.getFieldName());
    }

    default Boolean isNotifyDelete() {
        return readBoolean(ConfigureNodeFields.notify_delete.getFieldName());
    }

    default Boolean isNotifyRetract() {
        return readBoolean(ConfigureNodeFields.notify_retract.getFieldName());
    }

    default NotificationType getNotificationType() {
        String firstValue = readFirstValue(ConfigureNodeFields.notification_type.getFieldName());
        if (firstValue == null) {
            return null;
        }
        return NotificationType.valueOf(firstValue);
    }

    default boolean isPersistItems() {
        return readBoolean(ConfigureNodeFields.persist_items.getFieldName()).booleanValue();
    }

    default boolean isPresenceBasedDelivery() {
        return readBoolean(ConfigureNodeFields.presence_based_delivery.getFieldName()).booleanValue();
    }

    default PublishModel getPublishModel() {
        String firstValue = readFirstValue(ConfigureNodeFields.publish_model.getFieldName());
        if (firstValue == null) {
            return null;
        }
        return PublishModel.valueOf(firstValue);
    }

    default List<String> getRosterGroupsAllowed() {
        return readStringValues(ConfigureNodeFields.roster_groups_allowed.getFieldName());
    }

    default boolean isSubscribe() {
        return readBoolean(ConfigureNodeFields.subscribe.getFieldName()).booleanValue();
    }

    default String getTitle() {
        return readFirstValue(ConfigureNodeFields.title.getFieldName());
    }

    default String getDataType() {
        return readFirstValue(ConfigureNodeFields.type.getFieldName());
    }
}
