package org.jivesoftware.smack.initializer;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class VmArgInitializer extends UrlInitializer {
    protected String getFilePath() {
        return System.getProperty("smack.provider.file");
    }

    @Override // org.jivesoftware.smack.initializer.UrlInitializer, org.jivesoftware.smack.initializer.SmackInitializer
    public List<Exception> initialize() {
        if (getFilePath() != null) {
            super.initialize();
        }
        return Collections.emptyList();
    }
}
