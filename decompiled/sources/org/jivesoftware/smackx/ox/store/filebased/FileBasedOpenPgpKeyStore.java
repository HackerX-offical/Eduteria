package org.jivesoftware.smackx.ox.store.filebased;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.FileUtils;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpKeyStore;
import org.jxmpp.jid.BareJid;
import org.pgpainless.PGPainless;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public class FileBasedOpenPgpKeyStore extends AbstractOpenPgpKeyStore {
    private static final String FETCH_DATES = "fetchDates.list";
    private static final String PUB_RING = "pubring.pkr";
    private static final String SEC_RING = "secring.skr";
    private final File basePath;

    public FileBasedOpenPgpKeyStore(File file) {
        this.basePath = (File) Objects.requireNonNull(file);
    }

    @Override // org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpKeyStore
    public void writePublicKeysOf(BareJid bareJid, PGPPublicKeyRingCollection pGPPublicKeyRingCollection) throws Throwable {
        FileOutputStream fileOutputStreamPrepareFileOutputStream;
        File publicKeyRingPath = getPublicKeyRingPath(bareJid);
        if (pGPPublicKeyRingCollection == null) {
            FileUtils.maybeDeleteFileOrThrow(publicKeyRingPath);
            return;
        }
        try {
            fileOutputStreamPrepareFileOutputStream = FileUtils.prepareFileOutputStream(publicKeyRingPath);
            try {
                pGPPublicKeyRingCollection.encode(fileOutputStreamPrepareFileOutputStream);
                CloseableUtil.maybeClose(fileOutputStreamPrepareFileOutputStream, LOGGER);
            } catch (Throwable th) {
                th = th;
                CloseableUtil.maybeClose(fileOutputStreamPrepareFileOutputStream, LOGGER);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStreamPrepareFileOutputStream = null;
        }
    }

    @Override // org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpKeyStore
    public void writeSecretKeysOf(BareJid bareJid, PGPSecretKeyRingCollection pGPSecretKeyRingCollection) throws Throwable {
        FileOutputStream fileOutputStreamPrepareFileOutputStream;
        File secretKeyRingPath = getSecretKeyRingPath(bareJid);
        if (pGPSecretKeyRingCollection == null) {
            FileUtils.maybeDeleteFileOrThrow(secretKeyRingPath);
            return;
        }
        try {
            fileOutputStreamPrepareFileOutputStream = FileUtils.prepareFileOutputStream(secretKeyRingPath);
            try {
                pGPSecretKeyRingCollection.encode(fileOutputStreamPrepareFileOutputStream);
                CloseableUtil.maybeClose(fileOutputStreamPrepareFileOutputStream, LOGGER);
            } catch (Throwable th) {
                th = th;
                CloseableUtil.maybeClose(fileOutputStreamPrepareFileOutputStream, LOGGER);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStreamPrepareFileOutputStream = null;
        }
    }

    @Override // org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpKeyStore
    public PGPPublicKeyRingCollection readPublicKeysOf(BareJid bareJid) throws IOException, PGPException {
        File publicKeyRingPath = getPublicKeyRingPath(bareJid);
        if (!publicKeyRingPath.exists()) {
            return null;
        }
        FileInputStream fileInputStreamPrepareFileInputStream = FileUtils.prepareFileInputStream(publicKeyRingPath);
        PGPPublicKeyRingCollection pGPPublicKeyRingCollectionPublicKeyRingCollection = PGPainless.readKeyRing().publicKeyRingCollection(fileInputStreamPrepareFileInputStream);
        fileInputStreamPrepareFileInputStream.close();
        return pGPPublicKeyRingCollectionPublicKeyRingCollection;
    }

    @Override // org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpKeyStore
    public PGPSecretKeyRingCollection readSecretKeysOf(BareJid bareJid) throws IOException, PGPException {
        File secretKeyRingPath = getSecretKeyRingPath(bareJid);
        if (!secretKeyRingPath.exists()) {
            return null;
        }
        FileInputStream fileInputStreamPrepareFileInputStream = FileUtils.prepareFileInputStream(secretKeyRingPath);
        PGPSecretKeyRingCollection pGPSecretKeyRingCollectionSecretKeyRingCollection = PGPainless.readKeyRing().secretKeyRingCollection(fileInputStreamPrepareFileInputStream);
        fileInputStreamPrepareFileInputStream.close();
        return pGPSecretKeyRingCollectionSecretKeyRingCollection;
    }

    @Override // org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpKeyStore
    protected Map<OpenPgpV4Fingerprint, Date> readKeyFetchDates(BareJid bareJid) throws IOException {
        return FileBasedOpenPgpMetadataStore.readFingerprintsAndDates(getFetchDatesPath(bareJid));
    }

    @Override // org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpKeyStore
    protected void writeKeyFetchDates(BareJid bareJid, Map<OpenPgpV4Fingerprint, Date> map) throws IOException {
        FileBasedOpenPgpMetadataStore.writeFingerprintsAndDates(map, getFetchDatesPath(bareJid));
    }

    private File getPublicKeyRingPath(BareJid bareJid) {
        return new File(FileBasedOpenPgpStore.getContactsPath(this.basePath, bareJid), PUB_RING);
    }

    private File getSecretKeyRingPath(BareJid bareJid) {
        return new File(FileBasedOpenPgpStore.getContactsPath(this.basePath, bareJid), SEC_RING);
    }

    private File getFetchDatesPath(BareJid bareJid) {
        return new File(FileBasedOpenPgpStore.getContactsPath(this.basePath, bareJid), FETCH_DATES);
    }
}
