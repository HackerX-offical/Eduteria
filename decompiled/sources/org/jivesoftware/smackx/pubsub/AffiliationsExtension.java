package org.jivesoftware.smackx.pubsub;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.pubsub.Affiliation;

/* JADX INFO: loaded from: classes10.dex */
public class AffiliationsExtension extends NodeExtension {
    protected List<Affiliation> items;

    public AffiliationsExtension() {
        this(null);
    }

    public AffiliationsExtension(List<Affiliation> list) {
        this(list, (String) null);
    }

    public AffiliationsExtension(Affiliation.AffiliationNamespace affiliationNamespace, List<Affiliation> list) {
        this(affiliationNamespace, list, null);
    }

    public AffiliationsExtension(List<Affiliation> list, String str) {
        this(Affiliation.AffiliationNamespace.basic, list, str);
    }

    public AffiliationsExtension(Affiliation.AffiliationNamespace affiliationNamespace, List<Affiliation> list, String str) {
        super(affiliationNamespace.type, str);
        Collections.emptyList();
        this.items = list;
    }

    public List<Affiliation> getAffiliations() {
        return this.items;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        List<Affiliation> list = this.items;
        if (list == null || list.size() == 0) {
            xmlStringBuilder.closeEmptyElement();
            return;
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.items);
        xmlStringBuilder.closeElement(this);
    }
}
