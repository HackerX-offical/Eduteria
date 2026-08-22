package org.jivesoftware.smackx.xdata;

import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smackx.xdata.FormField;

/* JADX INFO: loaded from: classes10.dex */
public interface FormFieldChildElement extends FullyQualifiedElement {
    default void checkConsistency(FormField.Builder<?, ?> builder) throws IllegalArgumentException {
    }

    default boolean isExclusiveElement() {
        return false;
    }

    default boolean mustBeOnlyOfHisKind() {
        return false;
    }

    default void validate(FormField formField) throws IllegalArgumentException {
    }

    default boolean requiresNoTypeSet() {
        return isExclusiveElement();
    }
}
