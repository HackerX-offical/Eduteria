package org.jivesoftware.smackx.mam.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class MamQueryIQ extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "urn:xmpp:mam:2";
    private final DataForm dataForm;
    private final String node;
    private final String queryId;

    public MamQueryIQ(String str) {
        this(str, null, null);
        setType(IQ.Type.get);
    }

    public MamQueryIQ(DataForm dataForm) {
        this(null, null, dataForm);
    }

    public MamQueryIQ(String str, DataForm dataForm) {
        this(str, null, dataForm);
    }

    public MamQueryIQ(String str, String str2, DataForm dataForm) {
        super("query", "urn:xmpp:mam:2");
        this.queryId = str;
        this.node = str2;
        this.dataForm = dataForm;
        if (dataForm != null) {
            String formType = dataForm.getFormType();
            if (formType == null) {
                throw new IllegalArgumentException("If a data form is given it must posses a hidden form type field");
            }
            if (!formType.equals("urn:xmpp:mam:2")) {
                throw new IllegalArgumentException("Value of the hidden form type field must be 'urn:xmpp:mam:2'");
            }
            addExtension(dataForm);
        }
    }

    public String getQueryId() {
        return this.queryId;
    }

    public String getNode() {
        return this.node;
    }

    public DataForm getDataForm() {
        return this.dataForm;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optAttribute("queryid", this.queryId);
        iQChildElementXmlStringBuilder.optAttribute(NodeElement.ELEMENT, this.node);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }
}
