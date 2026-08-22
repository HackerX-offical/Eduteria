package org.jivesoftware.smackx.amp.packet;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.text.Typography;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;

/* JADX INFO: loaded from: classes10.dex */
public class AMPExtension implements ExtensionElement {
    public static final String ELEMENT = "amp";
    public static final String NAMESPACE = "http://jabber.org/protocol/amp";
    private final String from;
    private boolean perHop;
    private final CopyOnWriteArrayList<Rule> rules;
    private final Status status;
    private final String to;

    public enum Action {
        alert,
        drop,
        error,
        notify;

        public static final String ATTRIBUTE_NAME = "action";
    }

    public interface Condition {
        public static final String ATTRIBUTE_NAME = "condition";

        String getName();

        String getValue();
    }

    public enum Status {
        alert,
        error,
        notify
    }

    public AMPExtension(String str, String str2, Status status) {
        this.rules = new CopyOnWriteArrayList<>();
        this.perHop = false;
        this.from = str;
        this.to = str2;
        this.status = status;
    }

    public AMPExtension() {
        this.rules = new CopyOnWriteArrayList<>();
        this.perHop = false;
        this.from = null;
        this.to = null;
        this.status = null;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public Status getStatus() {
        return this.status;
    }

    public List<Rule> getRules() {
        return Collections.unmodifiableList(this.rules);
    }

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public int getRulesCount() {
        return this.rules.size();
    }

    public synchronized void setPerHop(boolean z) {
        this.perHop = z;
    }

    public synchronized boolean isPerHop() {
        return this.perHop;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getElementName()).append(" xmlns=\"").append(getNamespace()).append('\"');
        if (this.status != null) {
            sb.append(" status=\"").append(this.status.toString()).append('\"');
        }
        if (this.to != null) {
            sb.append(" to=\"").append(this.to).append('\"');
        }
        if (this.from != null) {
            sb.append(" from=\"").append(this.from).append('\"');
        }
        if (this.perHop) {
            sb.append(" per-hop=\"true\"");
        }
        sb.append(Typography.greater);
        Iterator<Rule> it = getRules().iterator();
        while (it.hasNext()) {
            sb.append(it.next().toXML());
        }
        sb.append("</").append(getElementName()).append(Typography.greater);
        return sb.toString();
    }

    public static class Rule {
        public static final String ELEMENT = "rule";
        private final Action action;
        private final Condition condition;

        public Action getAction() {
            return this.action;
        }

        public Condition getCondition() {
            return this.condition;
        }

        public Rule(Action action, Condition condition) {
            if (action == null) {
                throw new NullPointerException("Can't create Rule with null action");
            }
            if (condition == null) {
                throw new NullPointerException("Can't create Rule with null condition");
            }
            this.action = action;
            this.condition = condition;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String toXML() {
            return "<rule action=\"" + this.action.toString() + "\" condition=\"" + this.condition.getName() + "\" value=\"" + this.condition.getValue() + "\"/>";
        }
    }
}
