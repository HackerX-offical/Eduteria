package org.jivesoftware.smackx.filetransfer;

import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.filetransfer.FileTransferException;
import org.jivesoftware.smackx.formtypes.FormFieldRegistry;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.ListSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class FileTransferNegotiator extends Manager {
    public static boolean IBB_ONLY = false;
    public static final String SI_NAMESPACE = "http://jabber.org/protocol/si";
    protected static final String STREAM_DATA_FIELD_NAME = "stream-method";
    private static final String STREAM_INIT_PREFIX = "jsi_";
    private static final Random randomGenerator;
    private final StreamNegotiator byteStreamTransferManager;
    private final StreamNegotiator inbandTransferManager;
    public static final String SI_PROFILE_FILE_TRANSFER_NAMESPACE = "http://jabber.org/protocol/si/profile/file-transfer";
    private static final String[] NAMESPACE = {"http://jabber.org/protocol/si", SI_PROFILE_FILE_TRANSFER_NAMESPACE};
    private static final Map<XMPPConnection, FileTransferNegotiator> INSTANCES = new WeakHashMap();

    static {
        FormFieldRegistry.addLookasideFieldRegistryEntry(STREAM_DATA_FIELD_NAME, FormField.Type.list_single);
        randomGenerator = new Random();
        IBB_ONLY = System.getProperty(AbstractHttpOverXmpp.Ibb.ELEMENT) != null;
    }

    public static synchronized FileTransferNegotiator getInstanceFor(XMPPConnection xMPPConnection) {
        FileTransferNegotiator fileTransferNegotiator;
        Map<XMPPConnection, FileTransferNegotiator> map = INSTANCES;
        fileTransferNegotiator = map.get(xMPPConnection);
        if (fileTransferNegotiator == null) {
            fileTransferNegotiator = new FileTransferNegotiator(xMPPConnection);
            map.put(xMPPConnection, fileTransferNegotiator);
        }
        return fileTransferNegotiator;
    }

    private static void setServiceEnabled(XMPPConnection xMPPConnection, boolean z) {
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(NAMESPACE));
        arrayList.add("http://jabber.org/protocol/ibb");
        if (!IBB_ONLY) {
            arrayList.add(Bytestream.NAMESPACE);
        }
        for (String str : arrayList) {
            if (z) {
                instanceFor.addFeature(str);
            } else {
                instanceFor.removeFeature(str);
            }
        }
    }

    public static boolean isServiceEnabled(XMPPConnection xMPPConnection) {
        ServiceDiscoveryManager instanceFor = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(NAMESPACE));
        arrayList.add("http://jabber.org/protocol/ibb");
        if (!IBB_ONLY) {
            arrayList.add(Bytestream.NAMESPACE);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!instanceFor.includesFeature((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static Collection<String> getSupportedProtocols() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("http://jabber.org/protocol/ibb");
        if (!IBB_ONLY) {
            arrayList.add(Bytestream.NAMESPACE);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private FileTransferNegotiator(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.byteStreamTransferManager = new Socks5TransferNegotiator(xMPPConnection);
        this.inbandTransferManager = new IBBTransferNegotiator(xMPPConnection);
        setServiceEnabled(xMPPConnection, true);
    }

    public StreamNegotiator selectStreamNegotiator(FileTransferRequest fileTransferRequest) throws SmackException.NotConnectedException, InterruptedException, FileTransferException.NoAcceptableTransferMechanisms, FileTransferException.NoStreamMethodsOfferedException {
        StreamInitiation streamInitiation = fileTransferRequest.getStreamInitiation();
        ListSingleFormField streamMethodField = getStreamMethodField(streamInitiation.getFeatureNegotiationForm());
        if (streamMethodField == null) {
            connection().sendStanza(IQ.createErrorResponse(streamInitiation, StanzaError.from(StanzaError.Condition.bad_request, "No stream methods contained in stanza.").build()));
            throw new FileTransferException.NoStreamMethodsOfferedException();
        }
        try {
            return getNegotiator(streamMethodField);
        } catch (FileTransferException.NoAcceptableTransferMechanisms e2) {
            connection().sendStanza(IQ.createErrorResponse(streamInitiation, StanzaError.from(StanzaError.Condition.bad_request, "No acceptable transfer mechanism").build()));
            throw e2;
        }
    }

    private static ListSingleFormField getStreamMethodField(DataForm dataForm) {
        return (ListSingleFormField) dataForm.getField(STREAM_DATA_FIELD_NAME);
    }

    private StreamNegotiator getNegotiator(ListSingleFormField listSingleFormField) throws FileTransferException.NoAcceptableTransferMechanisms {
        Iterator<FormField.Option> it = listSingleFormField.getOptions().iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            String valueString = it.next().getValueString();
            if (valueString.equals(Bytestream.NAMESPACE) && !IBB_ONLY) {
                z = true;
            } else if (valueString.equals("http://jabber.org/protocol/ibb")) {
                z2 = true;
            }
        }
        if (!z && !z2) {
            throw new FileTransferException.NoAcceptableTransferMechanisms();
        }
        if (z) {
            return this.byteStreamTransferManager;
        }
        return this.inbandTransferManager;
    }

    public static String getNextStreamID() {
        StringBuilder sb = new StringBuilder(STREAM_INIT_PREFIX);
        Random random = randomGenerator;
        sb.append(random.nextInt(Integer.MAX_VALUE) + random.nextInt(Integer.MAX_VALUE));
        return sb.toString();
    }

    public StreamNegotiator negotiateOutgoingTransfer(Jid jid, String str, String str2, long j, String str3, int i) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, FileTransferException.NoAcceptableTransferMechanisms, XMPPException.XMPPErrorException {
        StreamInitiation streamInitiation = new StreamInitiation();
        streamInitiation.setSessionID(str);
        streamInitiation.setMimeType(URLConnection.guessContentTypeFromName(str2));
        StreamInitiation.File file = new StreamInitiation.File(str2, j);
        file.setDesc(str3);
        streamInitiation.setFile(file);
        streamInitiation.setFeatureNegotiationForm(createDefaultInitiationForm());
        streamInitiation.setFrom(connection().getUser());
        streamInitiation.setTo(jid);
        streamInitiation.setType(IQ.Type.set);
        Stanza stanzaNextResultOrThrow = connection().createStanzaCollectorAndSend(streamInitiation).nextResultOrThrow(i);
        if (!(stanzaNextResultOrThrow instanceof IQ)) {
            return null;
        }
        IQ iq = (IQ) stanzaNextResultOrThrow;
        if (iq.getType().equals(IQ.Type.result)) {
            return getOutgoingNegotiator(getStreamMethodField(((StreamInitiation) stanzaNextResultOrThrow).getFeatureNegotiationForm()));
        }
        throw new XMPPException.XMPPErrorException(iq, iq.getError());
    }

    private StreamNegotiator getOutgoingNegotiator(FormField formField) throws FileTransferException.NoAcceptableTransferMechanisms {
        Iterator<? extends CharSequence> it = formField.getValues().iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            String string = it.next().toString();
            if (string.equals(Bytestream.NAMESPACE) && !IBB_ONLY) {
                z = true;
            } else if (string.equals("http://jabber.org/protocol/ibb")) {
                z2 = true;
            }
        }
        if (!z && !z2) {
            throw new FileTransferException.NoAcceptableTransferMechanisms();
        }
        if (z) {
            return this.byteStreamTransferManager;
        }
        return this.inbandTransferManager;
    }

    private static DataForm createDefaultInitiationForm() {
        DataForm.Builder builder = DataForm.builder(DataForm.Type.form);
        ListSingleFormField.Builder builderListSingleBuilder = FormField.listSingleBuilder(STREAM_DATA_FIELD_NAME);
        if (!IBB_ONLY) {
            builderListSingleBuilder.addOption(Bytestream.NAMESPACE);
        }
        builderListSingleBuilder.addOption("http://jabber.org/protocol/ibb");
        builder.addField(builderListSingleBuilder.build());
        return builder.build();
    }
}
