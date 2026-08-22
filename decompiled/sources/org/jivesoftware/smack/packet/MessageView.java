package org.jivesoftware.smack.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public interface MessageView extends StanzaView {
    Message.Type getType();

    default String getSubject() {
        return getSubject(null);
    }

    default String getSubject(String str) {
        Message.Subject messageSubject = getMessageSubject(str);
        if (messageSubject == null) {
            return null;
        }
        return messageSubject.getSubject();
    }

    default Message.Subject getMessageSubject(String str) {
        String strDetermineLanguage = Stanza.determineLanguage(this, str);
        for (Message.Subject subject : getSubjects()) {
            if (Objects.equals(strDetermineLanguage, subject.getLanguage()) || (subject.getLanguage() == null && Objects.equals(getLanguage(), strDetermineLanguage))) {
                return subject;
            }
        }
        return null;
    }

    default Set<Message.Subject> getSubjects() {
        List extensions = getExtensions(Message.Subject.class);
        HashSet hashSet = new HashSet(extensions.size());
        hashSet.addAll(extensions);
        return hashSet;
    }

    default List<String> getSubjectLanguages() {
        Message.Subject messageSubject = getMessageSubject(null);
        ArrayList arrayList = new ArrayList();
        for (Message.Subject subject : getExtensions(Message.Subject.class)) {
            if (!subject.equals(messageSubject)) {
                arrayList.add(subject.getLanguage());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    default String getBody() {
        return getBody(getLanguage());
    }

    default String getBody(String str) {
        Message.Body messageBody = getMessageBody(str);
        if (messageBody == null) {
            return null;
        }
        return messageBody.getMessage();
    }

    default Message.Body getMessageBody(String str) {
        String strDetermineLanguage = Stanza.determineLanguage(this, str);
        for (Message.Body body : getBodies()) {
            if (Objects.equals(strDetermineLanguage, body.getLanguage()) || (strDetermineLanguage != null && strDetermineLanguage.equals(getLanguage()) && body.getLanguage() == null)) {
                return body;
            }
        }
        return null;
    }

    default Set<Message.Body> getBodies() {
        List<ExtensionElement> extensions = getExtensions(Message.Body.QNAME);
        HashSet hashSet = new HashSet(extensions.size());
        Iterator<ExtensionElement> it = extensions.iterator();
        while (it.hasNext()) {
            hashSet.add((Message.Body) it.next());
        }
        return hashSet;
    }

    default List<String> getBodyLanguages() {
        Message.Body messageBody = getMessageBody(null);
        ArrayList arrayList = new ArrayList();
        for (Message.Body body : getBodies()) {
            if (!body.equals(messageBody)) {
                arrayList.add(body.getLanguage());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    default String getThread() {
        Message.Thread thread = (Message.Thread) getExtension(Message.Thread.class);
        if (thread == null) {
            return null;
        }
        return thread.getThread();
    }
}
