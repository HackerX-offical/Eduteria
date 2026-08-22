package org.jivesoftware.smack.compression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.compress.packet.Compress;

/* JADX INFO: loaded from: classes10.dex */
public class XmppCompressionManager {
    private static final List<XmppCompressionFactory> xmppCompressionFactories = new ArrayList(4);

    public static XmppCompressionFactory registerXmppCompressionFactory(XmppCompressionFactory xmppCompressionFactory) {
        XmppCompressionFactory next;
        String compressionMethod = xmppCompressionFactory.getCompressionMethod();
        List<XmppCompressionFactory> list = xmppCompressionFactories;
        synchronized (list) {
            Iterator<XmppCompressionFactory> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.getCompressionMethod().equals(compressionMethod)) {
                    it.remove();
                    break;
                }
            }
            List<XmppCompressionFactory> list2 = xmppCompressionFactories;
            list2.add(xmppCompressionFactory);
            Collections.sort(list2);
        }
        return next;
    }

    public static XmppCompressionFactory getBestFactory(Compress.Feature feature) {
        List<String> methods = feature.getMethods();
        List<XmppCompressionFactory> list = xmppCompressionFactories;
        synchronized (list) {
            for (XmppCompressionFactory xmppCompressionFactory : list) {
                if (methods.contains(xmppCompressionFactory.getCompressionMethod())) {
                    return xmppCompressionFactory;
                }
            }
            return null;
        }
    }
}
