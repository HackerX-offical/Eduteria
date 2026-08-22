package org.xmlpull.v1.builder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;
import org.xmlpull.v1.builder.impl.XmlInfosetBuilderImpl;

/* JADX INFO: loaded from: classes9.dex */
public abstract class XmlInfosetBuilder {
    protected XmlPullParserFactory factory;

    public abstract XmlDocument newDocument(String str, Boolean bool, String str2) throws XmlBuilderException;

    public abstract XmlElement newFragment(String str) throws XmlBuilderException;

    public abstract XmlElement newFragment(String str, String str2) throws XmlBuilderException;

    public abstract XmlElement newFragment(XmlNamespace xmlNamespace, String str) throws XmlBuilderException;

    public abstract XmlNamespace newNamespace(String str) throws XmlBuilderException;

    public abstract XmlNamespace newNamespace(String str, String str2) throws XmlBuilderException;

    public abstract XmlDocument parse(XmlPullParser xmlPullParser) throws XmlBuilderException;

    public abstract XmlElement parseFragment(XmlPullParser xmlPullParser) throws XmlBuilderException;

    public abstract Object parseItem(XmlPullParser xmlPullParser) throws XmlBuilderException;

    public abstract XmlDocument parseLocation(String str) throws XmlBuilderException;

    public abstract XmlElement parseStartTag(XmlPullParser xmlPullParser) throws XmlBuilderException;

    public abstract void serialize(Object obj, XmlSerializer xmlSerializer) throws XmlBuilderException;

    public abstract void serializeEndTag(XmlElement xmlElement, XmlSerializer xmlSerializer) throws XmlBuilderException;

    public abstract void serializeItem(Object obj, XmlSerializer xmlSerializer) throws XmlBuilderException;

    public abstract void serializeStartTag(XmlElement xmlElement, XmlSerializer xmlSerializer) throws XmlBuilderException;

    public static XmlInfosetBuilder newInstance() throws XmlBuilderException {
        XmlInfosetBuilderImpl xmlInfosetBuilderImpl = new XmlInfosetBuilderImpl();
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance(System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
            xmlInfosetBuilderImpl.factory = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            return xmlInfosetBuilderImpl;
        } catch (XmlPullParserException e2) {
            throw new XmlBuilderException(new StringBuffer("could not create XmlPull factory:").append(e2).toString(), e2);
        }
    }

    public static XmlInfosetBuilder newInstance(XmlPullParserFactory xmlPullParserFactory) throws XmlBuilderException {
        if (xmlPullParserFactory == null) {
            throw new IllegalArgumentException();
        }
        XmlInfosetBuilderImpl xmlInfosetBuilderImpl = new XmlInfosetBuilderImpl();
        xmlInfosetBuilderImpl.factory = xmlPullParserFactory;
        xmlPullParserFactory.setNamespaceAware(true);
        return xmlInfosetBuilderImpl;
    }

    public XmlPullParserFactory getFactory() throws XmlBuilderException {
        return this.factory;
    }

    public XmlDocument newDocument() throws XmlBuilderException {
        return newDocument(null, null, null);
    }

    public XmlDocument parseInputStream(InputStream inputStream) throws XmlBuilderException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            return parse(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e2) {
            throw new XmlBuilderException("could not start parsing input stream", e2);
        }
    }

    public XmlDocument parseInputStream(InputStream inputStream, String str) throws XmlBuilderException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, str);
            return parse(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e2) {
            throw new XmlBuilderException(new StringBuffer("could not start parsing input stream (encoding=").append(str).append(")").toString(), e2);
        }
    }

    public XmlDocument parseReader(Reader reader) throws XmlBuilderException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(reader);
            return parse(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e2) {
            throw new XmlBuilderException("could not start parsing input from reader", e2);
        }
    }

    public XmlElement parseFragmentFromInputStream(InputStream inputStream) throws XmlBuilderException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            try {
                xmlPullParserNewPullParser.nextTag();
                return parseFragment(xmlPullParserNewPullParser);
            } catch (IOException e2) {
                throw new XmlBuilderException("IO error when starting to parse input stream", e2);
            }
        } catch (XmlPullParserException e3) {
            throw new XmlBuilderException("could not start parsing input stream", e3);
        }
    }

    public XmlElement parseFragementFromInputStream(InputStream inputStream, String str) throws XmlBuilderException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, str);
            try {
                xmlPullParserNewPullParser.nextTag();
                return parseFragment(xmlPullParserNewPullParser);
            } catch (IOException e2) {
                throw new XmlBuilderException(new StringBuffer("IO error when starting to parse input stream (encoding=").append(str).append(")").toString(), e2);
            }
        } catch (XmlPullParserException e3) {
            throw new XmlBuilderException(new StringBuffer("could not start parsing input stream (encoding=").append(str).append(")").toString(), e3);
        }
    }

    public XmlElement parseFragmentFromReader(Reader reader) throws XmlBuilderException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.factory.newPullParser();
            xmlPullParserNewPullParser.setInput(reader);
            try {
                xmlPullParserNewPullParser.nextTag();
                return parseFragment(xmlPullParserNewPullParser);
            } catch (IOException e2) {
                throw new XmlBuilderException("IO error when starting to parse from reader", e2);
            }
        } catch (XmlPullParserException e3) {
            throw new XmlBuilderException("could not start parsing input from reader", e3);
        }
    }

    public void skipSubTree(XmlPullParser xmlPullParser) throws XmlBuilderException {
        try {
            xmlPullParser.require(2, null, null);
            int i = 1;
            while (i > 0) {
                int next = xmlPullParser.next();
                if (next == 3) {
                    i--;
                } else if (next == 2) {
                    i++;
                }
            }
        } catch (IOException e2) {
            throw new XmlBuilderException("IO error when skipping subtree", e2);
        } catch (XmlPullParserException e3) {
            throw new XmlBuilderException("could not skip subtree", e3);
        }
    }

    public void serializeToOutputStream(Object obj, OutputStream outputStream) throws XmlBuilderException {
        serializeToOutputStream(obj, outputStream, "UTF8");
    }

    public void serializeToOutputStream(Object obj, OutputStream outputStream, String str) throws XmlBuilderException {
        try {
            XmlSerializer xmlSerializerNewSerializer = this.factory.newSerializer();
            xmlSerializerNewSerializer.setOutput(outputStream, str);
            serialize(obj, xmlSerializerNewSerializer);
            try {
                xmlSerializerNewSerializer.flush();
            } catch (IOException e2) {
                throw new XmlBuilderException("could not flush output", e2);
            }
        } catch (Exception e3) {
            throw new XmlBuilderException(new StringBuffer("could not serialize node to output stream (encoding=").append(str).append(")").toString(), e3);
        }
    }

    public void serializeToWriter(Object obj, Writer writer) throws XmlBuilderException {
        try {
            XmlSerializer xmlSerializerNewSerializer = this.factory.newSerializer();
            xmlSerializerNewSerializer.setOutput(writer);
            serialize(obj, xmlSerializerNewSerializer);
            try {
                xmlSerializerNewSerializer.flush();
            } catch (IOException e2) {
                throw new XmlBuilderException("could not flush output", e2);
            }
        } catch (Exception e3) {
            throw new XmlBuilderException("could not serialize node to writer", e3);
        }
    }

    public String serializeToString(Object obj) throws XmlBuilderException {
        StringWriter stringWriter = new StringWriter();
        serializeToWriter(obj, stringWriter);
        return stringWriter.toString();
    }
}
