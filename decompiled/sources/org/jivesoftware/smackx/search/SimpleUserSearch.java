package org.jivesoftware.smackx.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.search.ReportedData;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
class SimpleUserSearch extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "jabber:iq:search";
    private ReportedData data;
    private DataForm form;

    SimpleUserSearch() {
        super("query", "jabber:iq:search");
    }

    public void setForm(DataForm dataForm) {
        this.form = dataForm;
    }

    public ReportedData getReportedData() {
        return this.data;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append((CharSequence) getItemsToSearch());
        return iQChildElementXmlStringBuilder;
    }

    private String getItemsToSearch() {
        StringBuilder sb = new StringBuilder();
        if (this.form == null) {
            this.form = DataForm.from(this);
        }
        DataForm dataForm = this.form;
        if (dataForm == null) {
            return "";
        }
        for (FormField formField : dataForm.getFields()) {
            String fieldName = formField.getFieldName();
            String singleValue = getSingleValue(formField);
            if (singleValue.trim().length() > 0) {
                sb.append(Typography.less).append(fieldName).append(Typography.greater).append(singleValue).append("</").append(fieldName).append(Typography.greater);
            }
        }
        return sb.toString();
    }

    private static String getSingleValue(FormField formField) {
        List<String> valuesAsString = formField.getValuesAsString();
        if (valuesAsString.isEmpty()) {
            return "";
        }
        return valuesAsString.get(0);
    }

    protected void parseItems(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ReportedData reportedData = new ReportedData();
        reportedData.addColumn(new ReportedData.Column("JID", "jid", FormField.Type.text_single));
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (!z) {
            if (xmlPullParser.getAttributeCount() > 0) {
                String attributeValue = xmlPullParser.getAttributeValue("", "jid");
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(attributeValue);
                arrayList.add(new ReportedData.Field("jid", arrayList2));
            }
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getName().equals("item")) {
                arrayList = new ArrayList();
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("item")) {
                reportedData.addRow(new ReportedData.Row(arrayList));
            } else if (next == XmlPullParser.Event.START_ELEMENT) {
                String name = xmlPullParser.getName();
                String strNextText = xmlPullParser.nextText();
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(strNextText);
                arrayList.add(new ReportedData.Field(name, arrayList3));
                Iterator<ReportedData.Column> it = reportedData.getColumns().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getVariable().equals(name)) {
                            break;
                        }
                    } else {
                        reportedData.addColumn(new ReportedData.Column(name, name, FormField.Type.text_single));
                        break;
                    }
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("query")) {
                z = true;
            }
        }
        this.data = reportedData;
    }
}
