package org.jivesoftware.smackx.disco.packet;

import com.appnew.android.Utils.Const;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jxmpp.util.XmppStringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class DiscoverInfo extends IQ implements DiscoverInfoView {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "http://jabber.org/protocol/disco#info";
    private boolean containsDuplicateFeatures;
    private final List<Feature> features;
    private final Set<Feature> featuresSet;
    private final List<Identity> identities;
    private final Set<String> identitiesSet;
    private String node;

    DiscoverInfo(DiscoverInfoBuilder discoverInfoBuilder, boolean z) {
        super(discoverInfoBuilder, "query", NAMESPACE);
        ArrayList arrayList = new ArrayList();
        this.features = arrayList;
        this.featuresSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        this.identities = arrayList2;
        this.identitiesSet = new HashSet();
        arrayList.addAll(discoverInfoBuilder.getFeatures());
        arrayList2.addAll(discoverInfoBuilder.getIdentities());
        this.node = discoverInfoBuilder.getNode();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!this.featuresSet.add((Feature) it.next())) {
                this.containsDuplicateFeatures = true;
            }
        }
        Iterator<Identity> it2 = this.identities.iterator();
        while (it2.hasNext()) {
            this.identitiesSet.add(it2.next().getKey());
        }
        if (z && this.containsDuplicateFeatures) {
            throw new IllegalArgumentException("The disco#info request contains duplicate features.");
        }
    }

    @Deprecated
    public DiscoverInfo() {
        super("query", NAMESPACE);
        this.features = new ArrayList();
        this.featuresSet = new HashSet();
        this.identities = new ArrayList();
        this.identitiesSet = new HashSet();
    }

    public DiscoverInfo(DiscoverInfo discoverInfo) {
        super(discoverInfo);
        ArrayList arrayList = new ArrayList();
        this.features = arrayList;
        HashSet hashSet = new HashSet();
        this.featuresSet = hashSet;
        ArrayList arrayList2 = new ArrayList();
        this.identities = arrayList2;
        HashSet hashSet2 = new HashSet();
        this.identitiesSet = hashSet2;
        this.node = discoverInfo.getNode();
        arrayList.addAll(discoverInfo.features);
        hashSet.addAll(discoverInfo.featuresSet);
        arrayList2.addAll(discoverInfo.identities);
        hashSet2.addAll(discoverInfo.identitiesSet);
    }

    @Deprecated
    public boolean addFeature(String str) {
        return addFeature(new Feature(str));
    }

    @Deprecated
    public void addFeatures(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            addFeature(it.next());
        }
    }

    @Deprecated
    public boolean addFeature(Feature feature) {
        this.features.add(feature);
        boolean zAdd = this.featuresSet.add(feature);
        if (!zAdd) {
            this.containsDuplicateFeatures = true;
        }
        return zAdd;
    }

    @Override // org.jivesoftware.smackx.disco.packet.DiscoverInfoView
    public List<Feature> getFeatures() {
        return Collections.unmodifiableList(this.features);
    }

    @Deprecated
    public void addIdentity(Identity identity) {
        this.identities.add(identity);
        this.identitiesSet.add(identity.getKey());
    }

    @Deprecated
    public void addIdentities(Collection<Identity> collection) {
        if (collection == null) {
            return;
        }
        Iterator<Identity> it = collection.iterator();
        while (it.hasNext()) {
            addIdentity(it.next());
        }
    }

    @Override // org.jivesoftware.smackx.disco.packet.DiscoverInfoView
    public List<Identity> getIdentities() {
        return Collections.unmodifiableList(this.identities);
    }

    public boolean hasIdentity(String str, String str2) {
        return this.identitiesSet.contains(XmppStringUtils.generateKey(str, str2));
    }

    public List<Identity> getIdentities(String str, String str2) {
        ArrayList arrayList = new ArrayList(this.identities.size());
        for (Identity identity : this.identities) {
            if (identity.getCategory().equals(str) && identity.getType().equals(str2)) {
                arrayList.add(identity);
            }
        }
        return arrayList;
    }

    @Override // org.jivesoftware.smackx.disco.packet.DiscoverInfoView
    public String getNode() {
        return this.node;
    }

    @Deprecated
    public void setNode(String str) {
        this.node = (String) StringUtils.requireNullOrNotEmpty(str, "The node can not be the empty string");
    }

    public boolean containsFeature(CharSequence charSequence) {
        return this.features.contains(new Feature(charSequence));
    }

    public static boolean nullSafeContainsFeature(DiscoverInfo discoverInfo, CharSequence charSequence) {
        if (discoverInfo == null) {
            return false;
        }
        return discoverInfo.containsFeature(charSequence);
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.optAttribute(NodeElement.ELEMENT, getNode());
        iQChildElementXmlStringBuilder.rightAngleBracket();
        Iterator<Identity> it = this.identities.iterator();
        while (it.hasNext()) {
            iQChildElementXmlStringBuilder.append(it.next().toXML());
        }
        Iterator<Feature> it2 = this.features.iterator();
        while (it2.hasNext()) {
            iQChildElementXmlStringBuilder.append(it2.next().toXML());
        }
        return iQChildElementXmlStringBuilder;
    }

    public boolean containsDuplicateIdentities() {
        LinkedList linkedList = new LinkedList();
        for (Identity identity : this.identities) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (identity.equals((Identity) it.next())) {
                    return true;
                }
            }
            linkedList.add(identity);
        }
        return false;
    }

    public boolean containsDuplicateFeatures() {
        return this.containsDuplicateFeatures;
    }

    public DiscoverInfoBuilder asBuilder(String str) {
        return new DiscoverInfoBuilder(this, str);
    }

    @Deprecated
    public DiscoverInfo clone() {
        return new DiscoverInfo(this);
    }

    public static DiscoverInfoBuilder builder(XMPPConnection xMPPConnection) {
        return new DiscoverInfoBuilder(xMPPConnection);
    }

    public static DiscoverInfoBuilder builder(IqData iqData) {
        return new DiscoverInfoBuilder(iqData);
    }

    public static DiscoverInfoBuilder builder(String str) {
        return new DiscoverInfoBuilder(str);
    }

    public static final class Identity implements Comparable<Identity> {
        private final String category;
        private final HashCode.Cache hashCodeCache;
        private final String key;
        private final String lang;
        private final String name;
        private final String type;

        public Identity(String str, String str2) {
            this(str, str2, null, null);
        }

        public Identity(String str, String str2, String str3) {
            this(str, str3, str2, null);
        }

        public Identity(String str, String str2, String str3, String str4) {
            this.hashCodeCache = new HashCode.Cache();
            this.category = (String) StringUtils.requireNotNullNorEmpty(str, "category cannot be null");
            this.type = (String) StringUtils.requireNotNullNorEmpty(str2, "type cannot be null");
            this.key = XmppStringUtils.generateKey(str, str2);
            this.name = str3;
            this.lang = str4;
        }

        public String getCategory() {
            return this.category;
        }

        public String getName() {
            return this.name;
        }

        public String getType() {
            return this.type;
        }

        public String getLanguage() {
            return this.lang;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getKey() {
            return this.key;
        }

        public boolean isOfCategoryAndType(String str, String str2) {
            return this.category.equals(str) && this.type.equals(str2);
        }

        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement(HTTP.IDENTITY_CODING);
            xmlStringBuilder.xmllangAttribute(this.lang);
            xmlStringBuilder.attribute(Const.CATEGORY, this.category);
            xmlStringBuilder.optAttribute("name", this.name);
            xmlStringBuilder.optAttribute("type", this.type);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smackx.disco.packet.DiscoverInfo$Identity$$ExternalSyntheticLambda1
                @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
                public final void compare(EqualsUtil.Builder builder, Object obj2) {
                    this.f$0.m14240xce40b2ca(builder, (DiscoverInfo.Identity) obj2);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smackx-disco-packet-DiscoverInfo$Identity, reason: not valid java name */
        /* synthetic */ void m14240xce40b2ca(EqualsUtil.Builder builder, Identity identity) {
            builder.append(this.key, identity.key).append(this.lang, identity.lang).append(this.name, identity.name);
        }

        public int hashCode() {
            return this.hashCodeCache.getHashCode(new HashCode.Calculator() { // from class: org.jivesoftware.smackx.disco.packet.DiscoverInfo$Identity$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.util.HashCode.Calculator
                public final void calculateHash(HashCode.Builder builder) {
                    this.f$0.m14241xa6fe128d(builder);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$hashCode$1$org-jivesoftware-smackx-disco-packet-DiscoverInfo$Identity, reason: not valid java name */
        /* synthetic */ void m14241xa6fe128d(HashCode.Builder builder) {
            builder.append(this.key).append(this.lang).append(this.name);
        }

        @Override // java.lang.Comparable
        public int compareTo(Identity identity) {
            String str = identity.lang;
            if (str == null) {
                str = "";
            }
            String str2 = this.lang;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = identity.type;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = this.type;
            String str5 = str4 != null ? str4 : "";
            if (this.category.equals(identity.category)) {
                if (str5.equals(str3)) {
                    if (str2.equals(str)) {
                        return 0;
                    }
                    return str2.compareTo(str);
                }
                return str5.compareTo(str3);
            }
            return this.category.compareTo(identity.category);
        }

        public String toString() {
            return toXML().toString();
        }
    }

    public static final class Feature {
        private final String variable;

        public Feature(Feature feature) {
            this.variable = feature.variable;
        }

        public Feature(CharSequence charSequence) {
            this(charSequence.toString());
        }

        public Feature(String str) {
            this.variable = (String) StringUtils.requireNotNullNorEmpty(str, "variable cannot be null");
        }

        public String getVar() {
            return this.variable;
        }

        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement("feature");
            xmlStringBuilder.attribute("var", this.variable);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public boolean equals(Object obj) {
            return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smackx.disco.packet.DiscoverInfo$Feature$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
                public final void compare(EqualsUtil.Builder builder, Object obj2) {
                    this.f$0.m14239x6973c76a(builder, (DiscoverInfo.Feature) obj2);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smackx-disco-packet-DiscoverInfo$Feature, reason: not valid java name */
        /* synthetic */ void m14239x6973c76a(EqualsUtil.Builder builder, Feature feature) {
            builder.append(this.variable, feature.variable);
        }

        public int hashCode() {
            return this.variable.hashCode();
        }

        public String toString() {
            return toXML().toString();
        }
    }
}
