package org.jivesoftware.smackx.jingle.transports;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JingleTransportInitiationException extends Exception {
    private static final long serialVersionUID = 1;

    public static class CandidateError extends JingleTransportInitiationException {
        private static final long serialVersionUID = 1;
    }

    public static class ProxyError extends JingleTransportInitiationException {
        private static final long serialVersionUID = 1;
    }
}
