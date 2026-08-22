package org.jivesoftware.smackx.httpfileupload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.httpfileupload.UploadService;
import org.jivesoftware.smackx.httpfileupload.element.Slot;
import org.jivesoftware.smackx.httpfileupload.element.SlotRequest;
import org.jivesoftware.smackx.httpfileupload.element.SlotRequest_V0_2;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.DomainBareJid;

/* JADX INFO: loaded from: classes10.dex */
public final class HttpFileUploadManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Map<XMPPConnection, HttpFileUploadManager> INSTANCES;
    private static final Logger LOGGER = Logger.getLogger(HttpFileUploadManager.class.getName());
    public static final String NAMESPACE = "urn:xmpp:http:upload:0";
    public static final String NAMESPACE_0_2 = "urn:xmpp:http:upload";
    private UploadService defaultUploadService;
    private SSLSocketFactory tlsSocketFactory;

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.httpfileupload.HttpFileUploadManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                HttpFileUploadManager.getInstanceFor(xMPPConnection);
            }
        });
        INSTANCES = new WeakHashMap();
    }

    public static synchronized HttpFileUploadManager getInstanceFor(XMPPConnection xMPPConnection) {
        HttpFileUploadManager httpFileUploadManager;
        Map<XMPPConnection, HttpFileUploadManager> map = INSTANCES;
        httpFileUploadManager = map.get(xMPPConnection);
        if (httpFileUploadManager == null) {
            httpFileUploadManager = new HttpFileUploadManager(xMPPConnection);
            map.put(xMPPConnection, httpFileUploadManager);
        }
        return httpFileUploadManager;
    }

    private HttpFileUploadManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        xMPPConnection.addConnectionListener(new ConnectionListener() { // from class: org.jivesoftware.smackx.httpfileupload.HttpFileUploadManager.2
            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                if (z) {
                    return;
                }
                try {
                    HttpFileUploadManager.this.discoverUploadService();
                } catch (InterruptedException | SmackException.NoResponseException | SmackException.NotConnectedException | XMPPException.XMPPErrorException e2) {
                    HttpFileUploadManager.LOGGER.log(Level.WARNING, "Error during discovering HTTP File Upload service", e2);
                }
            }
        });
    }

    private static UploadService uploadServiceFrom(DiscoverInfo discoverInfo) {
        UploadService.Version version;
        if (discoverInfo.containsFeature("urn:xmpp:http:upload:0")) {
            version = UploadService.Version.v0_3;
        } else if (discoverInfo.containsFeature("urn:xmpp:http:upload")) {
            version = UploadService.Version.v0_2;
        } else {
            throw new AssertionError();
        }
        DomainBareJid domainBareJidAsDomainBareJid = discoverInfo.getFrom().asDomainBareJid();
        DataForm dataFormFrom = DataForm.from(discoverInfo);
        if (dataFormFrom == null) {
            return new UploadService(domainBareJidAsDomainBareJid, version);
        }
        FormField field = dataFormFrom.getField("max-file-size");
        if (field == null) {
            return new UploadService(domainBareJidAsDomainBareJid, version);
        }
        String firstValue = field.getFirstValue();
        if (firstValue == null) {
            return new UploadService(domainBareJidAsDomainBareJid, version);
        }
        return new UploadService(domainBareJidAsDomainBareJid, version, Long.valueOf(firstValue));
    }

    public boolean discoverUploadService() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(connection());
        List<DiscoverInfo> listFindServicesDiscoverInfo = instanceFor.findServicesDiscoverInfo("urn:xmpp:http:upload:0", true, true);
        if (listFindServicesDiscoverInfo.isEmpty()) {
            listFindServicesDiscoverInfo = instanceFor.findServicesDiscoverInfo("urn:xmpp:http:upload", true, true);
            if (listFindServicesDiscoverInfo.isEmpty()) {
                return false;
            }
        }
        this.defaultUploadService = uploadServiceFrom(listFindServicesDiscoverInfo.get(0));
        return true;
    }

    public boolean isUploadServiceDiscovered() {
        return this.defaultUploadService != null;
    }

    public UploadService getDefaultUploadService() {
        return this.defaultUploadService;
    }

    public URL uploadFile(File file) throws SmackException, InterruptedException, IOException, XMPPException.XMPPErrorException {
        return uploadFile(file, null);
    }

    public URL uploadFile(File file, UploadProgressListener uploadProgressListener) throws SmackException, InterruptedException, IOException, XMPPException.XMPPErrorException {
        if (!file.isFile()) {
            throw new FileNotFoundException("The path " + file.getAbsolutePath() + " is not a file");
        }
        Slot slotRequestSlot = requestSlot(file.getName(), file.length(), "application/octet-stream");
        upload(new FileInputStream(file), file.length(), slotRequestSlot, uploadProgressListener);
        return slotRequestSlot.getGetUrl();
    }

    public URL uploadFile(InputStream inputStream, String str, long j) throws SmackException, InterruptedException, IOException, XMPPException.XMPPErrorException {
        return uploadFile(inputStream, str, j, null);
    }

    public URL uploadFile(InputStream inputStream, String str, long j, UploadProgressListener uploadProgressListener) throws SmackException, InterruptedException, IOException, XMPPException.XMPPErrorException {
        Objects.requireNonNull(inputStream, "Input Stream cannot be null");
        Objects.requireNonNull(str, "Filename Stream cannot be null");
        if (j < 0) {
            throw new IllegalArgumentException("File size cannot be negative");
        }
        Slot slotRequestSlot = requestSlot(str, j, "application/octet-stream");
        upload(inputStream, j, slotRequestSlot, uploadProgressListener);
        return slotRequestSlot.getGetUrl();
    }

    public Slot requestSlot(String str, long j) throws SmackException, InterruptedException, XMPPException.XMPPErrorException {
        return requestSlot(str, j, null, null);
    }

    public Slot requestSlot(String str, long j, String str2) throws SmackException, InterruptedException, XMPPException.XMPPErrorException {
        return requestSlot(str, j, str2, null);
    }

    public Slot requestSlot(String str, long j, String str2, DomainBareJid domainBareJid) throws SmackException, InterruptedException, XMPPException.XMPPErrorException {
        SlotRequest slotRequest;
        XMPPConnection xMPPConnectionConnection = connection();
        UploadService uploadServiceUploadServiceFrom = this.defaultUploadService;
        if (domainBareJid != null && (uploadServiceUploadServiceFrom == null || !uploadServiceUploadServiceFrom.getAddress().equals((CharSequence) domainBareJid))) {
            DiscoverInfo discoverInfo = ServiceDiscoveryManager.getInstanceFor(xMPPConnectionConnection).discoverInfo(domainBareJid);
            if (!containsHttpFileUploadNamespace(discoverInfo)) {
                throw new IllegalArgumentException("There is no HTTP upload service running at the given address '" + ((Object) domainBareJid) + '\'');
            }
            uploadServiceUploadServiceFrom = uploadServiceFrom(discoverInfo);
        }
        if (uploadServiceUploadServiceFrom == null) {
            throw new SmackException.SmackMessageException("No upload service specified and also none discovered.");
        }
        if (!uploadServiceUploadServiceFrom.acceptsFileOfSize(j)) {
            throw new IllegalArgumentException("Requested file size " + j + " is greater than max allowed size " + uploadServiceUploadServiceFrom.getMaxFileSize());
        }
        int i = AnonymousClass3.$SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version[uploadServiceUploadServiceFrom.getVersion().ordinal()];
        if (i == 1) {
            slotRequest = new SlotRequest(uploadServiceUploadServiceFrom.getAddress(), str, j, str2);
        } else if (i == 2) {
            slotRequest = new SlotRequest_V0_2(uploadServiceUploadServiceFrom.getAddress(), str, j, str2);
        } else {
            throw new AssertionError();
        }
        return (Slot) xMPPConnectionConnection.createStanzaCollectorAndSend(slotRequest).nextResultOrThrow();
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.httpfileupload.HttpFileUploadManager$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version;

        static {
            int[] iArr = new int[UploadService.Version.values().length];
            $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version = iArr;
            try {
                iArr[UploadService.Version.v0_3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version[UploadService.Version.v0_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void setTlsContext(SSLContext sSLContext) {
        if (sSLContext == null) {
            return;
        }
        this.tlsSocketFactory = sSLContext.getSocketFactory();
    }

    private void upload(InputStream inputStream, long j, Slot slot, UploadProgressListener uploadProgressListener) throws IOException {
        URL putUrl = slot.getPutUrl();
        HttpURLConnection httpURLConnectionCreateURLConnection = createURLConnection(connection(), putUrl);
        httpURLConnectionCreateURLConnection.setRequestMethod("PUT");
        httpURLConnectionCreateURLConnection.setUseCaches(false);
        httpURLConnectionCreateURLConnection.setDoOutput(true);
        httpURLConnectionCreateURLConnection.setFixedLengthStreamingMode(j);
        httpURLConnectionCreateURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
        for (Map.Entry<String, String> entry : slot.getHeaders().entrySet()) {
            httpURLConnectionCreateURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        SSLSocketFactory sSLSocketFactory = this.tlsSocketFactory;
        if (sSLSocketFactory != null && (httpURLConnectionCreateURLConnection instanceof HttpsURLConnection)) {
            ((HttpsURLConnection) httpURLConnectionCreateURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        try {
            OutputStream outputStream = httpURLConnectionCreateURLConnection.getOutputStream();
            long j2 = 0;
            if (uploadProgressListener != null) {
                uploadProgressListener.onUploadProgress(0L, j);
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bArr = new byte[4096];
            while (true) {
                try {
                    int i = bufferedInputStream.read(bArr);
                    if (i != -1) {
                        outputStream.write(bArr, 0, i);
                        j2 += (long) i;
                        if (uploadProgressListener != null) {
                            uploadProgressListener.onUploadProgress(j2, j);
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            LOGGER.log(Level.WARNING, "Exception while closing input stream", (Throwable) e2);
                        }
                    }
                } finally {
                }
            }
            bufferedInputStream.close();
            try {
                outputStream.close();
            } catch (IOException e3) {
                LOGGER.log(Level.WARNING, "Exception while closing output stream", (Throwable) e3);
            }
            int responseCode = httpURLConnectionCreateURLConnection.getResponseCode();
            if (responseCode != 200 && responseCode != 201 && responseCode != 204) {
                throw new IOException("Error response " + responseCode + " from server during file upload: " + httpURLConnectionCreateURLConnection.getResponseMessage() + ", file size: " + j + ", put URL: " + putUrl);
            }
        } finally {
            httpURLConnectionCreateURLConnection.disconnect();
        }
    }

    private static HttpURLConnection createURLConnection(XMPPConnection xMPPConnection, URL url) throws IOException {
        Objects.requireNonNull(xMPPConnection);
        Objects.requireNonNull(url);
        ProxyInfo proxyInfoFetchProxyInfo = fetchProxyInfo(xMPPConnection);
        if (proxyInfoFetchProxyInfo != null) {
            return createProxiedURLConnection(proxyInfoFetchProxyInfo, url);
        }
        return (HttpURLConnection) url.openConnection();
    }

    private static HttpURLConnection createProxiedURLConnection(ProxyInfo proxyInfo, URL url) throws IOException {
        Objects.requireNonNull(proxyInfo);
        Objects.requireNonNull(url);
        return (HttpURLConnection) url.openConnection(proxyInfo.toJavaProxy());
    }

    private static ProxyInfo fetchProxyInfo(XMPPConnection xMPPConnection) {
        if (xMPPConnection instanceof AbstractXMPPConnection) {
            return ((AbstractXMPPConnection) xMPPConnection).getConfiguration().getProxyInfo();
        }
        return null;
    }

    public static UploadService.Version namespaceToVersion(String str) {
        str.hashCode();
        if (str.equals("urn:xmpp:http:upload:0")) {
            return UploadService.Version.v0_3;
        }
        if (str.equals("urn:xmpp:http:upload")) {
            return UploadService.Version.v0_2;
        }
        return null;
    }

    private static boolean containsHttpFileUploadNamespace(DiscoverInfo discoverInfo) {
        return discoverInfo.containsFeature("urn:xmpp:http:upload:0") || discoverInfo.containsFeature("urn:xmpp:http:upload");
    }
}
