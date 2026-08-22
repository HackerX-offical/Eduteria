package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.util.CloseableUtil;

/* JADX INFO: loaded from: classes10.dex */
public class Socks5Proxy {
    private static Socks5Proxy socks5Server;
    private ServerSocket serverSocket;
    private Thread serverThread;
    private static final Logger LOGGER = Logger.getLogger(Socks5Proxy.class.getName());
    private static final List<Socks5Proxy> RUNNING_PROXIES = new CopyOnWriteArrayList();
    private static boolean localSocks5ProxyEnabled = true;
    private static int DEFAULT_LOCAL_SOCKS5_PROXY_PORT = -7777;
    private int localSocks5ProxyPort = -7777;
    private final Map<String, Socket> connectionMap = new ConcurrentHashMap();
    private final List<String> allowedConnections = Collections.synchronizedList(new LinkedList());
    private final Set<InetAddress> localAddresses = new LinkedHashSet(4);
    private final Socks5ServerProcess serverProcess = new Socks5ServerProcess();
    private final boolean allowAllConnections = false;

    Socks5Proxy() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            HashSet hashSet = new HashSet();
            Iterator it = Collections.list(networkInterfaces).iterator();
            while (it.hasNext()) {
                Iterator<InterfaceAddress> it2 = ((NetworkInterface) it.next()).getInterfaceAddresses().iterator();
                while (it2.hasNext()) {
                    hashSet.add(it2.next().getAddress());
                }
            }
            if (hashSet.isEmpty()) {
                throw new IllegalStateException("Could not determine any local internet address");
            }
            replaceLocalAddresses(hashSet);
        } catch (SocketException e2) {
            throw new IllegalStateException(e2);
        }
    }

    protected Socks5Proxy(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        startServerThread();
    }

    public static boolean isLocalSocks5ProxyEnabled() {
        return localSocks5ProxyEnabled;
    }

    public static void setLocalSocks5ProxyEnabled(boolean z) {
        localSocks5ProxyEnabled = z;
    }

    private static void checkLocalSocks5ProxyPortArgument(int i) {
        if (Math.abs(i) > 65535) {
            throw new IllegalArgumentException("Local SOCKS5 proxy port must be within (-65535,65535)");
        }
    }

    public static int getDefaultLocalSocks5ProxyPort() {
        return DEFAULT_LOCAL_SOCKS5_PROXY_PORT;
    }

    public static void setDefaultLocalSocsk5ProxyPort(int i) {
        checkLocalSocks5ProxyPortArgument(i);
        DEFAULT_LOCAL_SOCKS5_PROXY_PORT = i;
    }

    public int getLocalSocks5ProxyPort() {
        return this.localSocks5ProxyPort;
    }

    public void setLocalSocks5ProxyPort(int i) {
        checkLocalSocks5ProxyPortArgument(i);
        this.localSocks5ProxyPort = i;
    }

    public static synchronized Socks5Proxy getSocks5Proxy() {
        if (socks5Server == null) {
            socks5Server = new Socks5Proxy();
        }
        if (isLocalSocks5ProxyEnabled()) {
            socks5Server.start();
        }
        return socks5Server;
    }

    public synchronized ServerSocket start() {
        if (isRunning()) {
            return this.serverSocket;
        }
        try {
            if (getLocalSocks5ProxyPort() < 0) {
                int iAbs = Math.abs(getLocalSocks5ProxyPort());
                for (int i = 0; i < 65535 - iAbs; i++) {
                    try {
                        this.serverSocket = new ServerSocket(iAbs + i);
                        break;
                    } catch (IOException unused) {
                    }
                }
            } else {
                this.serverSocket = new ServerSocket(getLocalSocks5ProxyPort());
            }
            if (this.serverSocket != null) {
                startServerThread();
            }
        } catch (IOException e2) {
            LOGGER.log(Level.SEVERE, "couldn't setup local SOCKS5 proxy on port " + getLocalSocks5ProxyPort(), (Throwable) e2);
        }
        return this.serverSocket;
    }

    private synchronized void startServerThread() {
        Thread thread = new Thread(this.serverProcess);
        this.serverThread = thread;
        thread.setName("Smack Local SOCKS5 Proxy [" + this.serverSocket + ']');
        this.serverThread.setDaemon(true);
        RUNNING_PROXIES.add(this);
        this.serverThread.start();
    }

    public synchronized void stop() {
        if (isRunning()) {
            RUNNING_PROXIES.remove(this);
            CloseableUtil.maybeClose(this.serverSocket, LOGGER);
            Thread thread = this.serverThread;
            if (thread != null && thread.isAlive()) {
                try {
                    this.serverThread.interrupt();
                    this.serverThread.join();
                } catch (InterruptedException e2) {
                    LOGGER.log(Level.WARNING, "SOCKS5 server thread termination was interrupted", (Throwable) e2);
                }
                this.serverThread = null;
                this.serverSocket = null;
                return;
            }
            this.serverThread = null;
            this.serverSocket = null;
            return;
        }
    }

    public void addLocalAddress(InetAddress inetAddress) {
        if (inetAddress == null) {
            return;
        }
        synchronized (this.localAddresses) {
            this.localAddresses.add(inetAddress);
        }
    }

    public boolean removeLocalAddress(InetAddress inetAddress) {
        boolean zRemove;
        synchronized (this.localAddresses) {
            zRemove = this.localAddresses.remove(inetAddress);
        }
        return zRemove;
    }

    public List<InetAddress> getLocalAddresses() {
        LinkedList linkedList;
        synchronized (this.localAddresses) {
            linkedList = new LinkedList(this.localAddresses);
        }
        return linkedList;
    }

    public void replaceLocalAddresses(Collection<? extends InetAddress> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("list must not be null");
        }
        synchronized (this.localAddresses) {
            this.localAddresses.clear();
            this.localAddresses.addAll(collection);
        }
    }

    public int getPort() {
        if (isRunning()) {
            return this.serverSocket.getLocalPort();
        }
        return -1;
    }

    protected Socket getSocket(String str) {
        return this.connectionMap.get(str);
    }

    public void addTransfer(String str) {
        this.allowedConnections.add(str);
    }

    protected void removeTransfer(String str) {
        this.allowedConnections.remove(str);
        this.connectionMap.remove(str);
    }

    public boolean isRunning() {
        return this.serverSocket != null;
    }

    private class Socks5ServerProcess implements Runnable {
        private Socks5ServerProcess() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                ServerSocket serverSocket = Socks5Proxy.this.serverSocket;
                if (serverSocket == null || serverSocket.isClosed() || Thread.currentThread().isInterrupted()) {
                    return;
                }
                Socket socketAccept = null;
                try {
                    socketAccept = serverSocket.accept();
                    establishConnection(socketAccept);
                } catch (IOException | SmackException e2) {
                    Socks5Proxy.LOGGER.log(Level.FINE, "Exception while " + Socks5Proxy.this + " was handling connection", e2);
                    CloseableUtil.maybeClose(socketAccept, Socks5Proxy.LOGGER);
                }
            }
        }

        private void establishConnection(Socket socket) throws SmackException, IOException {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            int i = dataInputStream.read();
            if (i != 5) {
                throw new SmackException.SmackMessageException("Only SOCKS5 supported: Peer send " + i + " but we expect 5");
            }
            int i2 = dataInputStream.read();
            byte[] bArr = new byte[i2];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[2];
            bArr2[0] = 5;
            for (int i3 = 0; i3 < i2; i3++) {
                if (bArr[i3] == 0) {
                    bArr2[1] = 0;
                    dataOutputStream.write(bArr2);
                    dataOutputStream.flush();
                    byte[] bArrReceiveSocks5Message = Socks5Utils.receiveSocks5Message(dataInputStream);
                    String str = new String(bArrReceiveSocks5Message, 5, bArrReceiveSocks5Message[4], StandardCharsets.UTF_8);
                    if (Socks5Proxy.this.allowAllConnections || Socks5Proxy.this.allowedConnections.contains(str)) {
                        Socks5Proxy.this.connectionMap.put(str, socket);
                        bArrReceiveSocks5Message[1] = 0;
                        dataOutputStream.write(bArrReceiveSocks5Message);
                        dataOutputStream.flush();
                        return;
                    }
                    bArrReceiveSocks5Message[1] = 5;
                    dataOutputStream.write(bArrReceiveSocks5Message);
                    dataOutputStream.flush();
                    throw new SmackException.SmackMessageException("Connection with digest '" + str + "' is not allowed");
                }
            }
            bArr2[1] = -1;
            dataOutputStream.write(bArr2);
            dataOutputStream.flush();
            throw new SmackException.SmackMessageException("Authentication method not supported");
        }
    }

    public static Socket getSocketForDigest(String str) {
        Iterator<Socks5Proxy> it = RUNNING_PROXIES.iterator();
        while (it.hasNext()) {
            Socket socket = it.next().getSocket(str);
            if (socket != null) {
                return socket;
            }
        }
        return null;
    }

    static List<Socks5Proxy> getRunningProxies() {
        return RUNNING_PROXIES;
    }
}
