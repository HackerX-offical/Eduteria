package org.jivesoftware.smackx.ox;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.chat2.IncomingChatMessageListener;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.ox.callback.backup.AskForBackupCodeCallback;
import org.jivesoftware.smackx.ox.callback.backup.SecretKeyBackupSelectionCallback;
import org.jivesoftware.smackx.ox.crypto.OpenPgpProvider;
import org.jivesoftware.smackx.ox.element.OpenPgpElement;
import org.jivesoftware.smackx.ox.element.PubkeyElement;
import org.jivesoftware.smackx.ox.element.PublicKeysListElement;
import org.jivesoftware.smackx.ox.element.SecretkeyElement;
import org.jivesoftware.smackx.ox.exception.InvalidBackupCodeException;
import org.jivesoftware.smackx.ox.exception.MissingOpenPgpKeyException;
import org.jivesoftware.smackx.ox.exception.MissingUserIdOnKeyException;
import org.jivesoftware.smackx.ox.exception.NoBackupFoundException;
import org.jivesoftware.smackx.ox.listener.CryptElementReceivedListener;
import org.jivesoftware.smackx.ox.listener.SignElementReceivedListener;
import org.jivesoftware.smackx.ox.listener.SigncryptElementReceivedListener;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore;
import org.jivesoftware.smackx.ox.util.OpenPgpPubSubUtil;
import org.jivesoftware.smackx.ox.util.SecretKeyBackupHelper;
import org.jivesoftware.smackx.pep.PepEventListener;
import org.jivesoftware.smackx.pep.PepManager;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jivesoftware.smackx.pubsub.PubSubFeature;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.EntityBareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.key.collection.PGPKeyRing;
import org.pgpainless.util.BCUtil;

/* JADX INFO: loaded from: classes10.dex */
public final class OpenPgpManager extends Manager {
    private final Set<CryptElementReceivedListener> cryptElementReceivedListeners;
    private final PepManager pepManager;
    private final PepEventListener<PublicKeysListElement> pepPublicKeyListElementListener;
    private OpenPgpProvider provider;
    private final Set<SignElementReceivedListener> signElementReceivedListeners;
    private final Set<SigncryptElementReceivedListener> signcryptElementReceivedListeners;
    private static final Logger LOGGER = Logger.getLogger(OpenPgpManager.class.getName());
    private static final Map<XMPPConnection, OpenPgpManager> INSTANCES = new WeakHashMap();

    /* JADX INFO: renamed from: lambda$new$0$org-jivesoftware-smackx-ox-OpenPgpManager, reason: not valid java name */
    /* synthetic */ void m14248lambda$new$0$orgjivesoftwaresmackxoxOpenPgpManager(EntityBareJid entityBareJid, PublicKeysListElement publicKeysListElement, String str, Message message) {
        processPublicKeysListElement(entityBareJid, publicKeysListElement);
    }

    private OpenPgpManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.signcryptElementReceivedListeners = new HashSet();
        this.signElementReceivedListeners = new HashSet();
        this.cryptElementReceivedListeners = new HashSet();
        this.pepPublicKeyListElementListener = new PepEventListener() { // from class: org.jivesoftware.smackx.ox.OpenPgpManager$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smackx.pep.PepEventListener
            public final void onPepEvent(EntityBareJid entityBareJid, ExtensionElement extensionElement, String str, Message message) {
                this.f$0.m14248lambda$new$0$orgjivesoftwaresmackxoxOpenPgpManager(entityBareJid, (PublicKeysListElement) extensionElement, str, message);
            }
        };
        ChatManager.getInstanceFor(xMPPConnection).addIncomingListener(new IncomingChatMessageListener() { // from class: org.jivesoftware.smackx.ox.OpenPgpManager$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.chat2.IncomingChatMessageListener
            public final void newIncomingMessage(EntityBareJid entityBareJid, Message message, Chat chat) {
                this.f$0.incomingChatMessageListener(entityBareJid, message, chat);
            }
        });
        this.pepManager = PepManager.getInstanceFor(xMPPConnection);
    }

    public static synchronized OpenPgpManager getInstanceFor(XMPPConnection xMPPConnection) {
        OpenPgpManager openPgpManager;
        Map<XMPPConnection, OpenPgpManager> map = INSTANCES;
        openPgpManager = map.get(xMPPConnection);
        if (openPgpManager == null) {
            openPgpManager = new OpenPgpManager(xMPPConnection);
            map.put(xMPPConnection, openPgpManager);
        }
        return openPgpManager;
    }

    public BareJid getJidOrThrow() throws SmackException.NotLoggedInException {
        throwIfNotAuthenticated();
        return connection().getUser().asEntityBareJidOrThrow();
    }

    public void setOpenPgpProvider(OpenPgpProvider openPgpProvider) {
        this.provider = openPgpProvider;
    }

    public OpenPgpProvider getOpenPgpProvider() {
        return this.provider;
    }

    public OpenPgpSelf getOpenPgpSelf() throws SmackException.NotLoggedInException {
        throwIfNoProviderSet();
        return new OpenPgpSelf(getJidOrThrow(), this.provider.getStore());
    }

    public void announceSupportAndPublish() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, NoSuchAlgorithmException, IOException, PGPException, NoSuchProviderException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException, InvalidAlgorithmParameterException {
        throwIfNoProviderSet();
        throwIfNotAuthenticated();
        OpenPgpV4Fingerprint ourFingerprint = getOurFingerprint();
        if (ourFingerprint == null) {
            ourFingerprint = generateAndImportKeyPair(getJidOrThrow());
        }
        try {
            OpenPgpPubSubUtil.publishPublicKey(this.pepManager, createPubkeyElement(getJidOrThrow(), ourFingerprint, new Date()), ourFingerprint);
            this.pepManager.addPepEventListener(OpenPgpPubSubUtil.PEP_NODE_PUBLIC_KEYS, PublicKeysListElement.class, this.pepPublicKeyListElementListener);
            ServiceDiscoveryManager.getInstanceFor(connection()).addFeature(OpenPgpPubSubUtil.PEP_NODE_PUBLIC_KEYS_NOTIFY);
        } catch (MissingOpenPgpKeyException unused) {
            throw new AssertionError("Cannot publish our public key, since it is missing (MUST NOT happen!)");
        }
    }

    public OpenPgpV4Fingerprint generateAndImportKeyPair(BareJid bareJid) throws NoSuchAlgorithmException, IOException, PGPException, NoSuchProviderException, InvalidAlgorithmParameterException {
        throwIfNoProviderSet();
        OpenPgpStore store = this.provider.getStore();
        PGPKeyRing pGPKeyRingGenerateKeyRing = generateKeyRing(bareJid);
        importKeyRing(bareJid, pGPKeyRingGenerateKeyRing);
        OpenPgpV4Fingerprint openPgpV4Fingerprint = new OpenPgpV4Fingerprint(pGPKeyRingGenerateKeyRing.getSecretKeys());
        store.setTrust(bareJid, openPgpV4Fingerprint, OpenPgpTrustStore.Trust.trusted);
        return openPgpV4Fingerprint;
    }

    public PGPKeyRing generateKeyRing(BareJid bareJid) throws NoSuchAlgorithmException, PGPException, NoSuchProviderException, InvalidAlgorithmParameterException {
        throwIfNoProviderSet();
        return this.provider.getStore().generateKeyRing(bareJid);
    }

    private void importKeyRing(BareJid bareJid, PGPKeyRing pGPKeyRing) throws IOException, PGPException {
        try {
            this.provider.getStore().importSecretKey(bareJid, pGPKeyRing.getSecretKeys());
            this.provider.getStore().importPublicKey(bareJid, pGPKeyRing.getPublicKeys());
        } catch (MissingUserIdOnKeyException e2) {
            throw new AssertionError(e2);
        }
    }

    public OpenPgpV4Fingerprint getOurFingerprint() throws IOException, PGPException, SmackException.NotLoggedInException {
        return getOpenPgpSelf().getSigningKeyFingerprint();
    }

    public OpenPgpContact getOpenPgpContact(EntityBareJid entityBareJid) {
        throwIfNoProviderSet();
        return this.provider.getStore().getOpenPgpContact(entityBareJid);
    }

    public boolean hasSecretKeysAvailable() throws IOException, PGPException, SmackException.NotLoggedInException {
        throwIfNoProviderSet();
        return getOpenPgpSelf().hasSecretKeyAvailable();
    }

    public static boolean serverSupportsSecretKeyBackups(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).serverSupportsFeature(PubSubFeature.access_whitelist.toString());
    }

    public void stopMetadataListener() {
        this.pepManager.removePepEventListener(this.pepPublicKeyListElementListener);
    }

    public OpenPgpSecretKeyBackupPassphrase backupSecretKeyToServer(SecretKeyBackupSelectionCallback secretKeyBackupSelectionCallback) throws SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.FeatureNotSupportedException, InterruptedException, PubSubException.NotALeafNodeException, IOException, PGPException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException, MissingOpenPgpKeyException {
        OpenPgpSecretKeyBackupPassphrase openPgpSecretKeyBackupPassphraseGenerateBackupPassword = SecretKeyBackupHelper.generateBackupPassword();
        backupSecretKeyToServer(secretKeyBackupSelectionCallback, openPgpSecretKeyBackupPassphraseGenerateBackupPassword);
        return openPgpSecretKeyBackupPassphraseGenerateBackupPassword;
    }

    public void backupSecretKeyToServer(SecretKeyBackupSelectionCallback secretKeyBackupSelectionCallback, OpenPgpSecretKeyBackupPassphrase openPgpSecretKeyBackupPassphrase) throws SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.FeatureNotSupportedException, InterruptedException, PubSubException.NotALeafNodeException, IOException, PGPException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException, MissingOpenPgpKeyException {
        throwIfNoProviderSet();
        throwIfNotAuthenticated();
        BareJid bareJidAsBareJid = connection().getUser().asBareJid();
        PGPSecretKeyRingCollection secretKeysOf = this.provider.getStore().getSecretKeysOf(bareJidAsBareJid);
        HashSet hashSet = new HashSet();
        Iterator<PGPSecretKeyRing> it = secretKeysOf.iterator();
        while (it.hasNext()) {
            hashSet.add(new OpenPgpV4Fingerprint(it.next()));
        }
        OpenPgpPubSubUtil.depositSecretKey(connection(), SecretKeyBackupHelper.createSecretkeyElement(this.provider, bareJidAsBareJid, secretKeyBackupSelectionCallback.selectKeysToBackup(hashSet), openPgpSecretKeyBackupPassphrase));
    }

    public void deleteSecretKeyServerBackup() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        throwIfNotAuthenticated();
        OpenPgpPubSubUtil.deleteSecretKeyNode(this.pepManager);
    }

    public OpenPgpV4Fingerprint restoreSecretKeyServerBackup(AskForBackupCodeCallback askForBackupCodeCallback) throws SmackException.NotConnectedException, SmackException.NoResponseException, InvalidBackupCodeException, NoBackupFoundException, InterruptedException, PubSubException.NotALeafNodeException, MissingUserIdOnKeyException, IOException, PGPException, XMPPException.XMPPErrorException, SmackException.NotLoggedInException {
        throwIfNoProviderSet();
        throwIfNotAuthenticated();
        SecretkeyElement secretkeyElementFetchSecretKey = OpenPgpPubSubUtil.fetchSecretKey(this.pepManager);
        if (secretkeyElementFetchSecretKey == null) {
            throw new NoBackupFoundException();
        }
        PGPSecretKeyRing pGPSecretKeyRingRestoreSecretKeyBackup = SecretKeyBackupHelper.restoreSecretKeyBackup(secretkeyElementFetchSecretKey, askForBackupCodeCallback.askForBackupCode());
        OpenPgpV4Fingerprint openPgpV4Fingerprint = new OpenPgpV4Fingerprint(pGPSecretKeyRingRestoreSecretKeyBackup);
        this.provider.getStore().importSecretKey(getJidOrThrow(), pGPSecretKeyRingRestoreSecretKeyBackup);
        this.provider.getStore().importPublicKey(getJidOrThrow(), BCUtil.publicKeyRingFromSecretKeyRing(pGPSecretKeyRingRestoreSecretKeyBackup));
        getOpenPgpSelf().trust(openPgpV4Fingerprint);
        return new OpenPgpV4Fingerprint(pGPSecretKeyRingRestoreSecretKeyBackup);
    }

    private void processPublicKeysListElement(BareJid bareJid, PublicKeysListElement publicKeysListElement) {
        try {
            getOpenPgpContact(bareJid.asEntityBareJidIfPossible()).updateKeys(connection(), publicKeysListElement);
        } catch (Exception e2) {
            LOGGER.log(Level.WARNING, "Could not update contacts keys", (Throwable) e2);
        }
    }

    public OpenPgpMessage decryptOpenPgpElement(OpenPgpElement openPgpElement, OpenPgpContact openPgpContact) throws IOException, PGPException, SmackException.NotLoggedInException {
        return this.provider.decryptAndOrVerify(getAuthenticatedConnectionOrThrow(), openPgpElement, getOpenPgpSelf(), openPgpContact);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void incomingChatMessageListener(final EntityBareJid entityBareJid, final Message message, Chat chat) {
        Async.go(new Runnable() { // from class: org.jivesoftware.smackx.ox.OpenPgpManager.1
            /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instruction units count: 232
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.ox.OpenPgpManager.AnonymousClass1.run():void");
            }
        });
    }

    private PubkeyElement createPubkeyElement(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint, Date date) throws IOException, PGPException, MissingOpenPgpKeyException {
        PGPPublicKeyRing publicKeyRing = this.provider.getStore().getPublicKeyRing(bareJid, openPgpV4Fingerprint);
        if (publicKeyRing != null) {
            return createPubkeyElement(publicKeyRing.getEncoded(true), date);
        }
        throw new MissingOpenPgpKeyException(bareJid, openPgpV4Fingerprint);
    }

    private static PubkeyElement createPubkeyElement(byte[] bArr, Date date) {
        return new PubkeyElement(new PubkeyElement.PubkeyDataElement(Base64.encodeToString(bArr)), date);
    }

    public void registerSigncryptReceivedListener(SigncryptElementReceivedListener signcryptElementReceivedListener) {
        this.signcryptElementReceivedListeners.add(signcryptElementReceivedListener);
    }

    void unregisterSigncryptElementReceivedListener(SigncryptElementReceivedListener signcryptElementReceivedListener) {
        this.signcryptElementReceivedListeners.remove(signcryptElementReceivedListener);
    }

    void registerSignElementReceivedListener(SignElementReceivedListener signElementReceivedListener) {
        this.signElementReceivedListeners.add(signElementReceivedListener);
    }

    void unregisterSignElementReceivedListener(SignElementReceivedListener signElementReceivedListener) {
        this.signElementReceivedListeners.remove(signElementReceivedListener);
    }

    void registerCryptElementReceivedListener(CryptElementReceivedListener cryptElementReceivedListener) {
        this.cryptElementReceivedListeners.add(cryptElementReceivedListener);
    }

    void unregisterCryptElementReceivedListener(CryptElementReceivedListener cryptElementReceivedListener) {
        this.cryptElementReceivedListeners.remove(cryptElementReceivedListener);
    }

    private void throwIfNoProviderSet() {
        if (this.provider == null) {
            throw new IllegalStateException("No OpenPgpProvider set!");
        }
    }

    private void throwIfNotAuthenticated() throws SmackException.NotLoggedInException {
        if (!connection().isAuthenticated()) {
            throw new SmackException.NotLoggedInException();
        }
    }
}
