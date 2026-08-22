package org.jivesoftware.smack.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public class ToStringUtil {
    public static Builder builderFor(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getSimpleName()).append('(');
        return new Builder(sb);
    }

    public static final class Builder {
        private final StringBuilder sb;

        private Builder(StringBuilder sb) {
            this.sb = sb;
        }

        public Builder addValue(String str, Object obj) {
            if (obj == null) {
                return this;
            }
            if (this.sb.charAt(r0.length() - 1) != '(') {
                this.sb.append(' ');
            }
            this.sb.append(str).append("='").append(obj).append('\'');
            return this;
        }

        public <V> Builder add(String str, Collection<? extends V> collection, Function<?, V> function) {
            if (collection.isEmpty()) {
                return this;
            }
            this.sb.append(' ').append(str).append('[');
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<? extends V> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(function.apply(it.next()).toString());
            }
            StringUtils.appendTo(arrayList, ", ", this.sb);
            this.sb.append(']');
            return this;
        }

        public String build() {
            this.sb.append(')');
            return this.sb.toString();
        }
    }
}
