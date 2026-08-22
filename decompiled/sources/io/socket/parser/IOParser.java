package io.socket.parser;

import com.clevertap.android.sdk.Constants;
import io.socket.hasbinary.HasBinary;
import io.socket.parser.Binary;
import io.socket.parser.Parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes9.dex */
public final class IOParser implements Parser {
    private static final Logger logger = Logger.getLogger(IOParser.class.getName());

    private IOParser() {
    }

    public static final class Encoder implements Parser.Encoder {
        @Override // io.socket.parser.Parser.Encoder
        public void encode(Packet packet, Parser.Encoder.Callback callback) {
            if ((packet.type == 2 || packet.type == 3) && HasBinary.hasBinary(packet.data)) {
                packet.type = packet.type == 2 ? 5 : 6;
            }
            if (IOParser.logger.isLoggable(Level.FINE)) {
                IOParser.logger.fine(String.format("encoding packet %s", packet));
            }
            if (5 == packet.type || 6 == packet.type) {
                encodeAsBinary(packet, callback);
            } else {
                callback.call(new String[]{encodeAsString(packet)});
            }
        }

        private String encodeAsString(Packet packet) {
            StringBuilder sb = new StringBuilder("" + packet.type);
            if (5 == packet.type || 6 == packet.type) {
                sb.append(packet.attachments);
                sb.append("-");
            }
            if (packet.nsp != null && packet.nsp.length() != 0 && !MqttTopic.TOPIC_LEVEL_SEPARATOR.equals(packet.nsp)) {
                sb.append(packet.nsp);
                sb.append(Constants.SEPARATOR_COMMA);
            }
            if (packet.id >= 0) {
                sb.append(packet.id);
            }
            if (packet.data != 0) {
                sb.append(packet.data);
            }
            if (IOParser.logger.isLoggable(Level.FINE)) {
                IOParser.logger.fine(String.format("encoded %s as %s", packet, sb));
            }
            return sb.toString();
        }

        private void encodeAsBinary(Packet packet, Parser.Encoder.Callback callback) {
            Binary.DeconstructedPacket deconstructedPacketDeconstructPacket = Binary.deconstructPacket(packet);
            String strEncodeAsString = encodeAsString(deconstructedPacketDeconstructPacket.packet);
            ArrayList arrayList = new ArrayList(Arrays.asList(deconstructedPacketDeconstructPacket.buffers));
            arrayList.add(0, strEncodeAsString);
            callback.call(arrayList.toArray());
        }
    }

    public static final class Decoder implements Parser.Decoder {
        private Parser.Decoder.Callback onDecodedCallback;
        BinaryReconstructor reconstructor = null;

        @Override // io.socket.parser.Parser.Decoder
        public void add(String str) {
            Parser.Decoder.Callback callback;
            Packet packetDecodeString = decodeString(str);
            if (5 == packetDecodeString.type || 6 == packetDecodeString.type) {
                BinaryReconstructor binaryReconstructor = new BinaryReconstructor(packetDecodeString);
                this.reconstructor = binaryReconstructor;
                if (binaryReconstructor.reconPack.attachments != 0 || (callback = this.onDecodedCallback) == null) {
                    return;
                }
                callback.call(packetDecodeString);
                return;
            }
            Parser.Decoder.Callback callback2 = this.onDecodedCallback;
            if (callback2 != null) {
                callback2.call(packetDecodeString);
            }
        }

        @Override // io.socket.parser.Parser.Decoder
        public void add(byte[] bArr) {
            BinaryReconstructor binaryReconstructor = this.reconstructor;
            if (binaryReconstructor == null) {
                throw new RuntimeException("got binary data when not reconstructing a packet");
            }
            Packet packetTakeBinaryData = binaryReconstructor.takeBinaryData(bArr);
            if (packetTakeBinaryData != null) {
                this.reconstructor = null;
                Parser.Decoder.Callback callback = this.onDecodedCallback;
                if (callback != null) {
                    callback.call(packetTakeBinaryData);
                }
            }
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.Object] */
        private static Packet decodeString(String str) {
            int i;
            int length = str.length();
            int i2 = 0;
            Packet packet = new Packet(Character.getNumericValue(str.charAt(0)));
            if (packet.type < 0 || packet.type > Parser.types.length - 1) {
                throw new DecodingException("unknown packet type " + packet.type);
            }
            if (5 == packet.type || 6 == packet.type) {
                if (!str.contains("-") || length <= 1) {
                    throw new DecodingException("illegal attachments");
                }
                StringBuilder sb = new StringBuilder();
                while (true) {
                    i2++;
                    if (str.charAt(i2) == '-') {
                        break;
                    }
                    sb.append(str.charAt(i2));
                }
                packet.attachments = Integer.parseInt(sb.toString());
            }
            int i3 = i2 + 1;
            if (length > i3 && '/' == str.charAt(i3)) {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    i = i2 + 1;
                    char cCharAt = str.charAt(i);
                    if (',' == cCharAt) {
                        break;
                    }
                    sb2.append(cCharAt);
                    if (i2 + 2 == length) {
                        break;
                    }
                    i2 = i;
                }
                packet.nsp = sb2.toString();
                i2 = i;
            } else {
                packet.nsp = MqttTopic.TOPIC_LEVEL_SEPARATOR;
            }
            int i4 = i2 + 1;
            if (length > i4 && Character.getNumericValue(Character.valueOf(str.charAt(i4)).charValue()) > -1) {
                StringBuilder sb3 = new StringBuilder();
                while (true) {
                    int i5 = i2 + 1;
                    char cCharAt2 = str.charAt(i5);
                    if (Character.getNumericValue(cCharAt2) >= 0) {
                        sb3.append(cCharAt2);
                        if (i2 + 2 == length) {
                            i2 = i5;
                            break;
                        }
                        i2 = i5;
                    }
                }
                try {
                    packet.id = Integer.parseInt(sb3.toString());
                    break;
                } catch (NumberFormatException unused) {
                    throw new DecodingException("invalid payload");
                }
            }
            int i6 = i2 + 1;
            if (length > i6) {
                try {
                    str.charAt(i6);
                    packet.data = new JSONTokener(str.substring(i6)).nextValue();
                    if (!isPayloadValid(packet.type, packet.data)) {
                        throw new DecodingException("invalid payload");
                    }
                } catch (JSONException e2) {
                    IOParser.logger.log(Level.WARNING, "An error occured while retrieving data from JSONTokener", (Throwable) e2);
                    throw new DecodingException("invalid payload");
                }
            }
            if (IOParser.logger.isLoggable(Level.FINE)) {
                IOParser.logger.fine(String.format("decoded %s as %s", str, packet));
            }
            return packet;
        }

        private static boolean isPayloadValid(int i, Object obj) {
            switch (i) {
                case 0:
                case 4:
                    return obj instanceof JSONObject;
                case 1:
                    return obj == null;
                case 2:
                case 5:
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray.length() > 0 && !jSONArray.isNull(0)) {
                            return true;
                        }
                    }
                    return false;
                case 3:
                case 6:
                    return obj instanceof JSONArray;
                default:
                    return false;
            }
        }

        @Override // io.socket.parser.Parser.Decoder
        public void destroy() {
            BinaryReconstructor binaryReconstructor = this.reconstructor;
            if (binaryReconstructor != null) {
                binaryReconstructor.finishReconstruction();
            }
            this.onDecodedCallback = null;
        }

        @Override // io.socket.parser.Parser.Decoder
        public void onDecoded(Parser.Decoder.Callback callback) {
            this.onDecodedCallback = callback;
        }
    }

    static class BinaryReconstructor {
        List<byte[]> buffers = new ArrayList();
        public Packet reconPack;

        BinaryReconstructor(Packet packet) {
            this.reconPack = packet;
        }

        public Packet takeBinaryData(byte[] bArr) {
            this.buffers.add(bArr);
            if (this.buffers.size() != this.reconPack.attachments) {
                return null;
            }
            Packet packet = this.reconPack;
            List<byte[]> list = this.buffers;
            Packet packetReconstructPacket = Binary.reconstructPacket(packet, (byte[][]) list.toArray(new byte[list.size()][]));
            finishReconstruction();
            return packetReconstructPacket;
        }

        public void finishReconstruction() {
            this.reconPack = null;
            this.buffers = new ArrayList();
        }
    }
}
