package org.jivesoftware.smackx.ox.store.filebased;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.FileUtils;
import org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpMetadataStore;
import org.jivesoftware.smackx.ox.util.Util;
import org.jxmpp.jid.BareJid;
import org.jxmpp.util.XmppDateTime;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public class FileBasedOpenPgpMetadataStore extends AbstractOpenPgpMetadataStore {
    public static final String ANNOUNCED = "announced.list";
    private static final Logger LOGGER = Logger.getLogger(FileBasedOpenPgpMetadataStore.class.getName());
    private final File basePath;

    public FileBasedOpenPgpMetadataStore(File file) {
        this.basePath = file;
    }

    @Override // org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpMetadataStore
    public Map<OpenPgpV4Fingerprint, Date> readAnnouncedFingerprintsOf(BareJid bareJid) throws IOException {
        return readFingerprintsAndDates(getAnnouncedFingerprintsPath(bareJid));
    }

    @Override // org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpMetadataStore
    public void writeAnnouncedFingerprintsOf(BareJid bareJid, Map<OpenPgpV4Fingerprint, Date> map) throws IOException {
        writeFingerprintsAndDates(map, getAnnouncedFingerprintsPath(bareJid));
    }

    static Map<OpenPgpV4Fingerprint, Date> readFingerprintsAndDates(File file) throws Throwable {
        if (!file.exists() || file.isDirectory()) {
            return new HashMap();
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(FileUtils.prepareFileInputStream(file), Util.UTF8));
            try {
                HashMap map = new HashMap();
                int i = 0;
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        i++;
                        String[] strArrSplit = line.trim().split(" ");
                        if (strArrSplit.length != 2) {
                            LOGGER.log(Level.FINE, "Skipping invalid line " + i + " in file " + file.getAbsolutePath());
                        } else {
                            try {
                                map.put(new OpenPgpV4Fingerprint(strArrSplit[0]), XmppDateTime.parseXEP0082Date(strArrSplit[1]));
                            } catch (IllegalArgumentException | ParseException e2) {
                                LOGGER.log(Level.WARNING, "Error parsing fingerprint/date touple in line " + i + " of file " + file.getAbsolutePath(), e2);
                            }
                        }
                    } else {
                        CloseableUtil.maybeClose(bufferedReader2, LOGGER);
                        return map;
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                CloseableUtil.maybeClose(bufferedReader, LOGGER);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static void writeFingerprintsAndDates(Map<OpenPgpV4Fingerprint, Date> map, File file) throws IOException {
        if (map == null || map.isEmpty()) {
            FileUtils.maybeDeleteFileOrThrow(file);
            return;
        }
        FileUtils.maybeCreateFileWithParentDirectories(file);
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(FileUtils.prepareFileOutputStream(file), Util.UTF8));
            try {
                for (OpenPgpV4Fingerprint openPgpV4Fingerprint : map.keySet()) {
                    Date date = map.get(openPgpV4Fingerprint);
                    StringBuilder sbAppend = new StringBuilder().append(openPgpV4Fingerprint.toString()).append(" ");
                    if (date == null) {
                        date = new Date();
                    }
                    bufferedWriter2.write(sbAppend.append(XmppDateTime.formatXEP0082Date(date)).toString());
                    bufferedWriter2.newLine();
                }
                CloseableUtil.maybeClose(bufferedWriter2, LOGGER);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                CloseableUtil.maybeClose(bufferedWriter, LOGGER);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private File getAnnouncedFingerprintsPath(BareJid bareJid) {
        return new File(FileBasedOpenPgpStore.getContactsPath(this.basePath, bareJid), ANNOUNCED);
    }
}
