package org.jivesoftware.smackx.ox.store.filebased;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.FileUtils;
import org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpTrustStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore;
import org.jivesoftware.smackx.ox.util.Util;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public class FileBasedOpenPgpTrustStore extends AbstractOpenPgpTrustStore {
    private static final Logger LOGGER = Logger.getLogger(FileBasedOpenPgpTrustStore.class.getName());
    private final File basePath;

    public static String TRUST_RECORD(OpenPgpV4Fingerprint openPgpV4Fingerprint) {
        return openPgpV4Fingerprint.toString() + ".trust";
    }

    public FileBasedOpenPgpTrustStore(File file) {
        this.basePath = file;
    }

    @Override // org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpTrustStore
    protected OpenPgpTrustStore.Trust readTrust(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws Throwable {
        File trustPath = getTrustPath(bareJid, openPgpV4Fingerprint);
        BufferedReader bufferedReader = null;
        OpenPgpTrustStore.Trust trustValueOf = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(FileUtils.prepareFileInputStream(trustPath), Util.UTF8));
                int i = 0;
                while (true) {
                    try {
                        String line = bufferedReader3.readLine();
                        if (line == null) {
                            break;
                        }
                        i++;
                        try {
                            trustValueOf = OpenPgpTrustStore.Trust.valueOf(line);
                            break;
                        } catch (IllegalArgumentException unused) {
                            LOGGER.log(Level.WARNING, "Skipping invalid trust record in line " + i + " \"" + line + "\" of file " + trustPath.getAbsolutePath());
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader3;
                        if (e instanceof FileNotFoundException) {
                            OpenPgpTrustStore.Trust trust = OpenPgpTrustStore.Trust.undecided;
                            CloseableUtil.maybeClose(bufferedReader2, LOGGER);
                            return trust;
                        }
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        CloseableUtil.maybeClose(bufferedReader, LOGGER);
                        throw th;
                    }
                }
                if (trustValueOf == null) {
                    trustValueOf = OpenPgpTrustStore.Trust.undecided;
                }
                CloseableUtil.maybeClose(bufferedReader3, LOGGER);
                return trustValueOf;
            } catch (IOException e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpTrustStore
    protected void writeTrust(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint, OpenPgpTrustStore.Trust trust) throws Throwable {
        Throwable th;
        BufferedWriter bufferedWriter;
        File trustPath = getTrustPath(bareJid, openPgpV4Fingerprint);
        if (trust == null || trust == OpenPgpTrustStore.Trust.undecided) {
            FileUtils.maybeDeleteFileOrThrow(trustPath);
        }
        FileUtils.maybeCreateFileWithParentDirectories(trustPath);
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(FileUtils.prepareFileOutputStream(trustPath), Util.UTF8));
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
        }
        try {
            bufferedWriter.write(trust.toString());
            CloseableUtil.maybeClose(bufferedWriter, LOGGER);
        } catch (Throwable th3) {
            th = th3;
            CloseableUtil.maybeClose(bufferedWriter, LOGGER);
            throw th;
        }
    }

    private File getTrustPath(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) {
        return new File(FileBasedOpenPgpStore.getContactsPath(this.basePath, bareJid), TRUST_RECORD(openPgpV4Fingerprint));
    }
}
