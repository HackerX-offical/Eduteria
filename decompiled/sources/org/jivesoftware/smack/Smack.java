package org.jivesoftware.smack;

import java.io.InputStream;
import java.util.logging.Logger;
import org.jivesoftware.smack.util.FileUtils;

/* JADX INFO: loaded from: classes10.dex */
public class Smack {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger(Smack.class.getName());
    private static final String NOTICE_RESOURCE = "org.jivesoftware.smack/NOTICE";
    private static final String SMACK_ORG = "org.jivesoftware";
    public static final String SMACK_PACKAGE = "org.jivesoftware.smack";

    public static String getVersion() {
        return SmackInitialization.SMACK_VERSION;
    }

    public static InputStream getNoticeStream() {
        return FileUtils.getInputStreamForClasspathFile(NOTICE_RESOURCE);
    }

    public static void ensureInitialized() {
        if (SmackConfiguration.isSmackInitialized()) {
            return;
        }
        LOGGER.finest("Smack " + getVersion() + " has been initialized");
    }
}
