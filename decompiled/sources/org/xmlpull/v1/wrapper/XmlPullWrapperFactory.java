package org.xmlpull.v1.wrapper;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import org.xmlpull.v1.wrapper.classic.StaticXmlPullParserWrapper;
import org.xmlpull.v1.wrapper.classic.StaticXmlSerializerWrapper;

/* JADX INFO: loaded from: classes9.dex */
public class XmlPullWrapperFactory {
    private static final boolean DEBUG = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected XmlPullParserFactory f1511f;

    public static XmlPullWrapperFactory newInstance() throws XmlPullParserException {
        return new XmlPullWrapperFactory(null);
    }

    public static XmlPullWrapperFactory newInstance(XmlPullParserFactory xmlPullParserFactory) throws XmlPullParserException {
        return new XmlPullWrapperFactory(xmlPullParserFactory);
    }

    public static XmlPullWrapperFactory newInstance(String str, Class cls) throws XmlPullParserException {
        return new XmlPullWrapperFactory(XmlPullParserFactory.newInstance(str, cls));
    }

    protected XmlPullWrapperFactory(XmlPullParserFactory xmlPullParserFactory) throws XmlPullParserException {
        if (xmlPullParserFactory != null) {
            this.f1511f = xmlPullParserFactory;
        } else {
            this.f1511f = XmlPullParserFactory.newInstance();
        }
    }

    public XmlPullParserFactory getFactory() throws XmlPullParserException {
        return this.f1511f;
    }

    public void setFeature(String str, boolean z) throws XmlPullParserException {
        this.f1511f.setFeature(str, z);
    }

    public boolean getFeature(String str) {
        return this.f1511f.getFeature(str);
    }

    public void setNamespaceAware(boolean z) {
        this.f1511f.setNamespaceAware(z);
    }

    public boolean isNamespaceAware() {
        return this.f1511f.isNamespaceAware();
    }

    public void setValidating(boolean z) {
        this.f1511f.setValidating(z);
    }

    public boolean isValidating() {
        return this.f1511f.isValidating();
    }

    public XmlPullParserWrapper newPullParserWrapper() throws XmlPullParserException {
        return new StaticXmlPullParserWrapper(this.f1511f.newPullParser());
    }

    public XmlPullParserWrapper newPullParserWrapper(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return new StaticXmlPullParserWrapper(xmlPullParser);
    }

    public XmlSerializerWrapper newSerializerWrapper() throws XmlPullParserException {
        return new StaticXmlSerializerWrapper(this.f1511f.newSerializer(), this);
    }

    public XmlSerializerWrapper newSerializerWrapper(XmlSerializer xmlSerializer) throws XmlPullParserException {
        return new StaticXmlSerializerWrapper(xmlSerializer, this);
    }
}
