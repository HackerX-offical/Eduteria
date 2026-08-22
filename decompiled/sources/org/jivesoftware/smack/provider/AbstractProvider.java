package org.jivesoftware.smack.provider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.jivesoftware.smack.packet.Element;

/* JADX INFO: loaded from: classes10.dex */
public class AbstractProvider<E extends Element> {
    private final Class<E> elementClass;

    protected AbstractProvider() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        while (!(genericSuperclass instanceof ParameterizedType)) {
            genericSuperclass = ((Class) genericSuperclass).getGenericSuperclass();
        }
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        if (type instanceof Class) {
            this.elementClass = (Class) type;
        } else if (type instanceof ParameterizedType) {
            this.elementClass = (Class) ((ParameterizedType) type).getRawType();
        } else {
            if (type instanceof TypeVariable) {
                this.elementClass = (Class<E>) ((TypeVariable) type).getClass();
                return;
            }
            throw new AssertionError("Element type '" + type + "' (" + type.getClass() + ") is neither of type Class, ParameterizedType or TypeVariable");
        }
    }

    public final Class<E> getElementClass() {
        return this.elementClass;
    }
}
