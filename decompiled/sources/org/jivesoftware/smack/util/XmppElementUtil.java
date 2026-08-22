package org.jivesoftware.smack.util;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jxmpp.util.cache.LruCache;

/* JADX INFO: loaded from: classes10.dex */
public class XmppElementUtil {
    private static final LruCache<Class<? extends FullyQualifiedElement>, QName> CLASS_TO_QNAME_CACHE = new LruCache<>(512);
    public static final Logger LOGGER = Logger.getLogger(XmppElementUtil.class.getName());

    public static QName getQNameFor(Class<? extends FullyQualifiedElement> cls) {
        Object obj;
        LruCache<Class<? extends FullyQualifiedElement>, QName> lruCache = CLASS_TO_QNAME_CACHE;
        QName qName = lruCache.get(cls);
        if (qName != null) {
            return qName;
        }
        try {
            obj = cls.getField("QNAME").get(null);
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException e2) {
            throw new IllegalArgumentException(e2);
        } catch (NoSuchFieldException unused) {
            LOGGER.finer("The " + cls + " has no static QNAME field. Consider adding one.");
        }
        if (QName.class.isAssignableFrom(obj.getClass())) {
            QName qName2 = (QName) obj;
            lruCache.put(cls, qName2);
            return qName2;
        }
        LOGGER.warning("The QNAME field of " + cls + " is not of type QNAME.");
        try {
            QName qName3 = new QName((String) cls.getField("NAMESPACE").get(null), (String) cls.getField("ELEMENT").get(null));
            CLASS_TO_QNAME_CACHE.put(cls, qName3);
            return qName3;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e3) {
            throw new IllegalArgumentException("The " + cls + " has no ELEMENT, NAMESPACE or QNAME member. Consider adding QNAME", e3);
        }
    }

    public static <E extends ExtensionElement> List<E> getElementsFrom(MultiMap<QName, ExtensionElement> multiMap, Class<E> cls) {
        List<ExtensionElement> all = multiMap.getAll(getQNameFor(cls));
        if (all.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(all.size());
        Iterator<ExtensionElement> it = all.iterator();
        while (it.hasNext()) {
            arrayList.add(castOrThrow(it.next(), cls));
        }
        return arrayList;
    }

    public static <E extends ExtensionElement> E castOrThrow(ExtensionElement extensionElement, Class<E> cls) {
        String str;
        if (!cls.isInstance(extensionElement)) {
            QName qNameFor = getQNameFor(cls);
            if (extensionElement instanceof StandardExtensionElement) {
                str = "because there is no according extension element provider registered with ProviderManager for " + qNameFor + ". WARNING: This indicates a serious problem with your Smack setup, probably causing Smack not being able to properly initialize itself.";
            } else {
                str = "because there is an inconsistency with the provider registered with ProviderManager: the active provider for " + qNameFor + " '" + ProviderManager.getExtensionProvider(qNameFor).getClass() + "' does not return instances of type " + cls + ", but instead returns instances of type " + extensionElement.getClass() + InstructionFileId.DOT;
            }
            throw new IllegalStateException("Extension element is not of expected class '" + cls.getName() + "', " + str);
        }
        return cls.cast(extensionElement);
    }
}
