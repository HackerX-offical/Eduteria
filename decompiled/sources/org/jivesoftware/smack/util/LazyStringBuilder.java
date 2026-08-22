package org.jivesoftware.smack.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class LazyStringBuilder implements Appendable, CharSequence {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private String cache;
    private final List<CharSequence> list = new ArrayList(20);

    private void invalidateCache() {
        this.cache = null;
    }

    public LazyStringBuilder append(LazyStringBuilder lazyStringBuilder) {
        this.list.addAll(lazyStringBuilder.list);
        invalidateCache();
        return this;
    }

    @Override // java.lang.Appendable
    public LazyStringBuilder append(CharSequence charSequence) {
        this.list.add(charSequence);
        invalidateCache();
        return this;
    }

    @Override // java.lang.Appendable
    public LazyStringBuilder append(CharSequence charSequence, int i, int i2) {
        this.list.add(charSequence.subSequence(i, i2));
        invalidateCache();
        return this;
    }

    @Override // java.lang.Appendable
    public LazyStringBuilder append(char c2) {
        this.list.add(Character.toString(c2));
        invalidateCache();
        return this;
    }

    @Override // java.lang.CharSequence
    public int length() {
        String str = this.cache;
        if (str != null) {
            return str.length();
        }
        try {
            Iterator<CharSequence> it = this.list.iterator();
            int length = 0;
            while (it.hasNext()) {
                length += it.next().length();
            }
            return length;
        } catch (NullPointerException e2) {
            throw new RuntimeException("The following LazyStringBuilder threw a NullPointerException:  " + ((Object) safeToStringBuilder()), e2);
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        String str = this.cache;
        if (str != null) {
            return str.charAt(i);
        }
        for (CharSequence charSequence : this.list) {
            if (i < charSequence.length()) {
                return charSequence.charAt(i);
            }
            i -= charSequence.length();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return toString().subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        if (this.cache == null) {
            StringBuilder sb = new StringBuilder(length());
            Iterator<CharSequence> it = this.list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            this.cache = sb.toString();
        }
        return this.cache;
    }

    public StringBuilder safeToStringBuilder() {
        StringBuilder sb = new StringBuilder();
        Iterator<CharSequence> it = this.list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb;
    }

    public List<CharSequence> getAsList() {
        String str = this.cache;
        if (str != null) {
            return Collections.singletonList(str);
        }
        return Collections.unmodifiableList(this.list);
    }
}
