package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.util.Async;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;

/* JADX INFO: loaded from: classes10.dex */
public class Socks5Client {
    private static final Logger LOGGER = Logger.getLogger(Socks5Client.class.getName());
    protected String digest;
    protected Bytestream.StreamHost streamHost;

    public Socks5Client(Bytestream.StreamHost streamHost, String str) {
        this.streamHost = streamHost;
        this.digest = str;
    }

    public Socket getSocket(int i) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, TimeoutException, IOException, SmackException.SmackMessageException, XMPPException {
        FutureTask futureTask = new FutureTask(new Callable<Socket>() { // from class: org.jivesoftware.smackx.bytestreams.socks5.Socks5Client.1
            @Override // java.util.concurrent.Callable
            public Socket call() throws IOException, SmackException.SmackMessageException {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(Socks5Client.this.streamHost.getAddress().asInetAddress(), Socks5Client.this.streamHost.getPort()));
                try {
                    Socks5Client.this.establish(socket);
                    return socket;
                } catch (SmackException.SmackMessageException e2) {
                    if (!socket.isClosed()) {
                        CloseableUtil.maybeClose(socket, Socks5Client.LOGGER);
                    }
                    throw e2;
                }
            }
        });
        Async.go(futureTask, "SOCKS5 client connecting to " + this.streamHost);
        try {
            return (Socket) futureTask.get(i, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            throw new IOException("ExecutionException while SOCKS5 client attempting to connect to " + this.streamHost, e2);
        }
    }

    protected void establish(Socket socket) throws IOException, SmackException.SmackMessageException {
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.write(new byte[]{5, 1, 0});
        dataOutputStream.flush();
        byte[] bArr = new byte[2];
        dataInputStream.readFully(bArr);
        if (bArr[0] != 5 || bArr[1] != 0) {
            throw new SmackException.SmackMessageException("Remote SOCKS5 server responded with unexpected version: " + ((int) bArr[0]) + ' ' + ((int) bArr[1]) + ". Should be 0x05 0x00.");
        }
        byte[] bArrCreateSocks5ConnectRequest = createSocks5ConnectRequest();
        dataOutputStream.write(bArrCreateSocks5ConnectRequest);
        dataOutputStream.flush();
        byte[] bArrReceiveSocks5Message = Socks5Utils.receiveSocks5Message(dataInputStream);
        bArrCreateSocks5ConnectRequest[1] = 0;
        if (!Arrays.equals(bArrCreateSocks5ConnectRequest, bArrReceiveSocks5Message)) {
            throw new SmackException.SmackMessageException("Connection request does not equal connection response. Response: " + Arrays.toString(bArrReceiveSocks5Message) + ". Request: " + Arrays.toString(bArrCreateSocks5ConnectRequest));
        }
    }

    private byte[] createSocks5ConnectRequest() {
        byte[] bytes = this.digest.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;
        byte[] bArr = new byte[length + 7];
        bArr[0] = 5;
        bArr[1] = 1;
        bArr[2] = 0;
        bArr[3] = 3;
        bArr[4] = (byte) bytes.length;
        System.arraycopy(bytes, 0, bArr, 5, bytes.length);
        bArr[length + 5] = 0;
        bArr[length + 6] = 0;
        return bArr;
    }
}
