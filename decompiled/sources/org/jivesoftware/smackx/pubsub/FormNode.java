package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class FormNode extends NodeExtension {
    private final DataForm configForm;

    public FormNode(FormNodeType formNodeType, DataForm dataForm) {
        this(formNodeType, null, dataForm);
    }

    public FormNode(FormNodeType formNodeType, String str, DataForm dataForm) {
        super(formNodeType.getNodeElement(), str);
        this.configForm = dataForm;
    }

    public DataForm getForm() {
        return this.configForm;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        if (this.configForm == null) {
            xmlStringBuilder.closeEmptyElement();
            return;
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.configForm);
        xmlStringBuilder.closeElement(this);
    }
}
