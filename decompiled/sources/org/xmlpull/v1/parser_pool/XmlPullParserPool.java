package org.xmlpull.v1.parser_pool;

import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes9.dex */
public class XmlPullParserPool {
    protected XmlPullParserFactory factory;
    protected List pool;

    public XmlPullParserPool() throws XmlPullParserException {
        this(XmlPullParserFactory.newInstance());
    }

    public XmlPullParserPool(XmlPullParserFactory xmlPullParserFactory) {
        this.pool = new ArrayList();
        if (xmlPullParserFactory == null) {
            throw new IllegalArgumentException();
        }
        this.factory = xmlPullParserFactory;
    }

    protected XmlPullParser newParser() throws XmlPullParserException {
        return this.factory.newPullParser();
    }

    public XmlPullParser getPullParserFromPool() throws XmlPullParserException {
        XmlPullParser xmlPullParser = null;
        if (this.pool.size() > 0) {
            synchronized (this.pool) {
                if (this.pool.size() > 0) {
                    xmlPullParser = (XmlPullParser) this.pool.remove(r1.size() - 1);
                }
            }
        }
        return xmlPullParser == null ? newParser() : xmlPullParser;
    }

    public void returnPullParserToPool(XmlPullParser xmlPullParser) {
        if (xmlPullParser == null) {
            throw new IllegalArgumentException();
        }
        synchronized (this.pool) {
            this.pool.add(xmlPullParser);
        }
    }

    public static void main(String[] strArr) throws Exception {
        XmlPullParserPool xmlPullParserPool = new XmlPullParserPool();
        XmlPullParser pullParserFromPool = xmlPullParserPool.getPullParserFromPool();
        xmlPullParserPool.returnPullParserToPool(pullParserFromPool);
        XmlPullParser pullParserFromPool2 = xmlPullParserPool.getPullParserFromPool();
        if (pullParserFromPool != pullParserFromPool2) {
            throw new RuntimeException();
        }
        xmlPullParserPool.returnPullParserToPool(pullParserFromPool2);
        System.out.println(new StringBuffer().append(xmlPullParserPool.getClass()).append(" OK").toString());
    }
}
