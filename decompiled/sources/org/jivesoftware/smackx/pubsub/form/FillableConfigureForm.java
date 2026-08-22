package org.jivesoftware.smackx.pubsub.form;

import java.net.URL;
import java.util.Collection;
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
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class FillableConfigureForm extends FillableForm implements ConfigureFormReader {
    FillableConfigureForm(DataForm dataForm) {
        super(dataForm);
    }

    public void setAccessModel(AccessModel accessModel) {
        write(FormField.listSingleBuilder(ConfigureNodeFields.access_model.getFieldName()).setValue(accessModel).build());
    }

    public void setBodyXSLT(String str) {
        write(FormField.listSingleBuilder(ConfigureNodeFields.body_xslt.getFieldName()).setValue(str).build());
    }

    public void setChildren(List<String> list) {
        write(FormField.textMultiBuilder(ConfigureNodeFields.children.getFieldName()).addValues(list).build());
    }

    public void setChildrenAssociationPolicy(ChildrenAssociationPolicy childrenAssociationPolicy) {
        write(FormField.listSingleBuilder(ConfigureNodeFields.children_association_policy.getFieldName()).setValue(childrenAssociationPolicy).build());
    }

    public void setChildrenAssociationWhitelist(List<? extends Jid> list) {
        write(FormField.jidMultiBuilder(ConfigureNodeFields.children_association_whitelist.getFieldName()).addValues(list).build());
    }

    public void setChildrenMax(int i) {
        write(FormField.textSingleBuilder(ConfigureNodeFields.children_max.getFieldName()).setValue(i).build());
    }

    public void setCollection(String str) {
        setCollections(Collections.singletonList(str));
    }

    public void setCollections(Collection<String> collection) {
        write(FormField.textMultiBuilder(ConfigureNodeFields.collection.getFieldName()).addValues(collection).build());
    }

    public void setDataformXSLT(URL url) {
        write(FormField.textSingleBuilder(ConfigureNodeFields.dataform_xslt.getFieldName()).setValue(url).build());
    }

    public void setDeliverPayloads(boolean z) {
        writeBoolean(ConfigureNodeFields.deliver_payloads.getFieldName(), z);
    }

    public void setItemReply(ItemReply itemReply) {
        write(FormField.listSingleBuilder(ConfigureNodeFields.itemreply.getFieldName()).setValue(itemReply).build());
    }

    public void setMaxItems(int i) {
        write(FormField.textSingleBuilder(ConfigureNodeFields.max_items.getFieldName()).setValue(i).build());
    }

    public void setMaxPayloadSize(int i) {
        write(FormField.textSingleBuilder(ConfigureNodeFields.max_payload_size.getFieldName()).setValue(i).build());
    }

    public void setNodeType(NodeType nodeType) {
        write(FormField.listSingleBuilder(ConfigureNodeFields.node_type.getFieldName()).setValue(nodeType).build());
    }

    public void setNotifyConfig(boolean z) {
        writeBoolean(ConfigureNodeFields.notify_config.getFieldName(), z);
    }

    public void setNotifyDelete(boolean z) {
        writeBoolean(ConfigureNodeFields.notify_delete.getFieldName(), z);
    }

    public void setNotifyRetract(boolean z) {
        writeBoolean(ConfigureNodeFields.notify_retract.getFieldName(), z);
    }

    public void setNotificationType(NotificationType notificationType) {
        write(FormField.listSingleBuilder(ConfigureNodeFields.notification_type.getFieldName()).setValue(notificationType).build());
    }

    public void setPersistentItems(boolean z) {
        writeBoolean(ConfigureNodeFields.persist_items.getFieldName(), z);
    }

    public void setPresenceBasedDelivery(boolean z) {
        writeBoolean(ConfigureNodeFields.presence_based_delivery.getFieldName(), z);
    }

    public void setPublishModel(PublishModel publishModel) {
        write(FormField.listSingleBuilder(ConfigureNodeFields.publish_model.getFieldName()).setValue(publishModel).build());
    }

    public void setRosterGroupsAllowed(List<? extends CharSequence> list) {
        writeListMulti(ConfigureNodeFields.roster_groups_allowed.getFieldName(), list);
    }

    public void setSubscribe(boolean z) {
        writeBoolean(ConfigureNodeFields.subscribe.getFieldName(), z);
    }

    public void setTitle(CharSequence charSequence) {
        writeTextSingle(ConfigureNodeFields.title.getFieldName(), charSequence);
    }

    public void setDataType(CharSequence charSequence) {
        writeTextSingle(ConfigureNodeFields.type.getFieldName(), charSequence);
    }
}
