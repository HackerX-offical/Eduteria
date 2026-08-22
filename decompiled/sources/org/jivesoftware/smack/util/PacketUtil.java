package org.jivesoftware.smack.util;

import java.util.Collection;
import java.util.Iterator;
import org.jivesoftware.smack.packet.ExtensionElement;

/* JADX INFO: loaded from: classes10.dex */
public class PacketUtil {
    public static <PE extends ExtensionElement> PE extensionElementFrom(Collection<ExtensionElement> collection, String str, String str2) {
        Iterator<ExtensionElement> it = collection.iterator();
        while (it.hasNext()) {
            PE pe = (PE) it.next();
            if (str == null || pe.getElementName().equals(str)) {
                if (pe.getNamespace().equals(str2)) {
                    return pe;
                }
            }
        }
        return null;
    }
}
