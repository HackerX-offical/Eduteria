package org.jsoup.nodes;

import com.google.firebase.analytics.FirebaseAnalytics;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

/* JADX INFO: loaded from: classes10.dex */
public class FormElement extends Element {
    private final Elements elements;

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
        this.elements = new Elements();
    }

    public Elements elements() {
        return this.elements;
    }

    public FormElement addElement(Element element) {
        this.elements.add(element);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    protected void removeChild(Node node) {
        super.removeChild(node);
        this.elements.remove(node);
    }

    public Connection submit() {
        String strAbsUrl = hasAttr("action") ? absUrl("action") : baseUri();
        Validate.notEmpty(strAbsUrl, "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
        Connection.Method method = attr(FirebaseAnalytics.Param.METHOD).equalsIgnoreCase(HttpPost.METHOD_NAME) ? Connection.Method.POST : Connection.Method.GET;
        Document documentOwnerDocument = ownerDocument();
        return (documentOwnerDocument != null ? documentOwnerDocument.connection().newRequest() : Jsoup.newSession()).url(strAbsUrl).data(formData()).method(method);
    }

    public List<Connection.KeyVal> formData() {
        Element elementSelectFirst;
        ArrayList arrayList = new ArrayList();
        for (Element element : this.elements) {
            if (element.tag().isFormSubmittable() && !element.hasAttr("disabled")) {
                String strAttr = element.attr("name");
                if (strAttr.length() != 0) {
                    String strAttr2 = element.attr("type");
                    if (!strAttr2.equalsIgnoreCase("button")) {
                        if ("select".equals(element.normalName())) {
                            Iterator<Element> it = element.select("option[selected]").iterator();
                            boolean z = false;
                            while (it.hasNext()) {
                                arrayList.add(HttpConnection.KeyVal.create(strAttr, it.next().val()));
                                z = true;
                            }
                            if (!z && (elementSelectFirst = element.selectFirst("option")) != null) {
                                arrayList.add(HttpConnection.KeyVal.create(strAttr, elementSelectFirst.val()));
                            }
                        } else if ("checkbox".equalsIgnoreCase(strAttr2) || "radio".equalsIgnoreCase(strAttr2)) {
                            if (element.hasAttr("checked")) {
                                arrayList.add(HttpConnection.KeyVal.create(strAttr, element.val().length() > 0 ? element.val() : DebugKt.DEBUG_PROPERTY_VALUE_ON));
                            }
                        } else {
                            arrayList.add(HttpConnection.KeyVal.create(strAttr, element.val()));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    /* JADX INFO: renamed from: clone */
    public FormElement mo14259clone() {
        return (FormElement) super.mo14259clone();
    }
}
