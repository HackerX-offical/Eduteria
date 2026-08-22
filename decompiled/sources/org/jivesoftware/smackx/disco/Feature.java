package org.jivesoftware.smackx.disco;

/* JADX INFO: loaded from: classes10.dex */
public class Feature {

    public enum Support {
        optional,
        recommended,
        required;

        public boolean isRequired() {
            return this == required;
        }

        public boolean isNotRequired() {
            return !isRequired();
        }
    }
}
