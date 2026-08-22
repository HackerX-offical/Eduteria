package org.jivesoftware.smackx.bytestreams.socks5;

import com.csvreader.CsvReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Socks5Exception extends SmackException {
    private static final long serialVersionUID = 1;

    protected Socks5Exception(String str) {
        super(str);
    }

    public static final class NoSocks5StreamHostsProvided extends Socks5Exception {
        private static final long serialVersionUID = 1;

        NoSocks5StreamHostsProvided() {
            super("No SOCKS5 stream hosts provided.");
        }
    }

    public static final class CouldNotConnectToAnyProvidedSocks5Host extends Socks5Exception {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long serialVersionUID = 1;
        private final Map<Bytestream.StreamHost, Exception> streamHostsExceptions;

        private CouldNotConnectToAnyProvidedSocks5Host(String str, Map<Bytestream.StreamHost, Exception> map) {
            super(str);
            this.streamHostsExceptions = Collections.unmodifiableMap(map);
        }

        public Map<Bytestream.StreamHost, Exception> getStreamHostsExceptions() {
            return this.streamHostsExceptions;
        }

        static CouldNotConnectToAnyProvidedSocks5Host construct(Map<Bytestream.StreamHost, Exception> map) {
            StringBuilder sb = new StringBuilder(256);
            sb.append("Could not establish socket with any provided SOCKS5 stream host.");
            Iterator<Bytestream.StreamHost> it = map.keySet().iterator();
            while (it.hasNext()) {
                Bytestream.StreamHost next = it.next();
                sb.append(' ').append(next).append(" Exception: '").append(map.get(next)).append('\'');
                if (it.hasNext()) {
                    sb.append(CsvReader.Letters.COMMA);
                }
            }
            return new CouldNotConnectToAnyProvidedSocks5Host(sb.toString(), map);
        }
    }
}
