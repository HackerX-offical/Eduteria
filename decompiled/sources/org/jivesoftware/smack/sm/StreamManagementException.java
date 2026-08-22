package org.jivesoftware.smack.sm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.Stanza;

/* JADX INFO: loaded from: classes10.dex */
public abstract class StreamManagementException extends SmackException {
    private static final long serialVersionUID = 3767590115788821101L;

    public static class StreamManagementNotEnabledException extends StreamManagementException {
        private static final long serialVersionUID = 2624821584352571307L;
    }

    public StreamManagementException() {
    }

    public StreamManagementException(String str) {
        super(str);
    }

    public static class StreamIdDoesNotMatchException extends StreamManagementException {
        private static final long serialVersionUID = 1191073341336559621L;

        public StreamIdDoesNotMatchException(String str, String str2) {
            super("Stream IDs do not match. Expected '" + str + "', but got '" + str2 + "'");
        }
    }

    public static class StreamManagementCounterError extends StreamManagementException {
        private static final long serialVersionUID = 1;
        private final long ackedStanzaCount;
        private final List<Stanza> ackedStanzas;
        private final long handledCount;
        private final int outstandingStanzasCount;
        private final long previousServerHandledCount;

        public StreamManagementCounterError(long j, long j2, long j3, List<Stanza> list) {
            super("There was an error regarding the Stream Management counters. Server reported " + j + " handled stanzas, which means that the " + j3 + " recently send stanzas by client are now acked by the server. But Smack had only " + list.size() + " to acknowledge. The stanza id of the last acked outstanding stanza is " + (list.isEmpty() ? "<no acked stanzas>" : list.get(list.size() - 1).getStanzaId()));
            this.handledCount = j;
            this.previousServerHandledCount = j2;
            this.ackedStanzaCount = j3;
            this.outstandingStanzasCount = list.size();
            this.ackedStanzas = Collections.unmodifiableList(list);
        }

        public long getHandledCount() {
            return this.handledCount;
        }

        public long getPreviousServerHandledCount() {
            return this.previousServerHandledCount;
        }

        public long getAckedStanzaCount() {
            return this.ackedStanzaCount;
        }

        public int getOutstandingStanzasCount() {
            return this.outstandingStanzasCount;
        }

        public List<Stanza> getAckedStanzas() {
            return this.ackedStanzas;
        }
    }

    public static final class UnacknowledgedQueueFullException extends StreamManagementException {
        private static final long serialVersionUID = 1;
        private final int droppedElements;
        private final List<Element> elements;
        private final int overflowElementNum;
        private final List<Stanza> unacknowledgesStanzas;

        private UnacknowledgedQueueFullException(String str, int i, int i2, List<Element> list, List<Stanza> list2) {
            super(str);
            this.overflowElementNum = i;
            this.droppedElements = i2;
            this.elements = list;
            this.unacknowledgesStanzas = list2;
        }

        public int getOverflowElementNum() {
            return this.overflowElementNum;
        }

        public int getDroppedElements() {
            return this.droppedElements;
        }

        public List<Element> getElements() {
            return this.elements;
        }

        public List<Stanza> getUnacknowledgesStanzas() {
            return this.unacknowledgesStanzas;
        }

        public static UnacknowledgedQueueFullException newWith(int i, List<Element> list, BlockingQueue<Stanza> blockingQueue) {
            int size = blockingQueue.size();
            ArrayList arrayList = new ArrayList(size);
            arrayList.addAll(blockingQueue);
            int size2 = (list.size() - i) - 1;
            return new UnacknowledgedQueueFullException("The queue size " + size + " is not able to fit another " + size2 + " potential stanzas type top-level stream-elements.", i, size2, list, arrayList);
        }
    }
}
