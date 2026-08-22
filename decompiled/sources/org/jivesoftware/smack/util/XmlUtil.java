package org.jivesoftware.smack.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/* JADX INFO: loaded from: classes10.dex */
public class XmlUtil {
    private static final Logger LOGGER = Logger.getLogger(XmlUtil.class.getName());
    private static final TransformerFactory transformerFactory;

    static {
        TransformerFactory transformerFactoryNewInstance = TransformerFactory.newInstance();
        transformerFactory = transformerFactoryNewInstance;
        try {
            transformerFactoryNewInstance.setAttribute("indent-number", 2);
        } catch (IllegalArgumentException e2) {
            LOGGER.log(Level.INFO, "XML TransformerFactory does not support indent-number attribute", (Throwable) e2);
        }
    }

    public static String prettyFormatXml(CharSequence charSequence) {
        String string = charSequence.toString();
        StreamSource streamSource = new StreamSource(new StringReader(string));
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        try {
            Transformer transformerNewTransformer = transformerFactory.newTransformer();
            transformerNewTransformer.setOutputProperty("omit-xml-declaration", "yes");
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformerNewTransformer.transform(streamSource, streamResult);
            return stringWriter.toString();
        } catch (IllegalArgumentException | TransformerException e2) {
            LOGGER.log(Level.SEVERE, "Transformer error", e2);
            return string;
        }
    }

    public static boolean isClarkNotation(String str) {
        return !str.isEmpty() && str.charAt(0) == '{';
    }
}
