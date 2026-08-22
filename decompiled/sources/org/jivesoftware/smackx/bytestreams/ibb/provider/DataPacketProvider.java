package org.jivesoftware.smackx.bytestreams.ibb.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Data;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

/* JADX INFO: loaded from: classes10.dex */
public class DataPacketProvider {

    public static class IQProvider extends org.jivesoftware.smack.provider.IQProvider<Data> {
        private static final PacketExtensionProvider packetExtensionProvider = new PacketExtensionProvider();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.jivesoftware.smack.provider.IQProvider
        public Data parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
            return new Data((DataPacketExtension) packetExtensionProvider.parse(xmlPullParser));
        }
    }

    public static class PacketExtensionProvider extends ExtensionElementProvider<DataPacketExtension> {
        @Override // org.jivesoftware.smack.provider.Provider
        public DataPacketExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException.RequiredAttributeMissingException {
            return new DataPacketExtension(xmlPullParser.getAttributeValue("", "sid"), ParserUtils.getRequiredUInt16Attribute(xmlPullParser, "seq"), xmlPullParser.nextText());
        }
    }
}
