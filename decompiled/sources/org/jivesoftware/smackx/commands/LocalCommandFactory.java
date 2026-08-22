package org.jivesoftware.smackx.commands;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes10.dex */
public interface LocalCommandFactory {
    LocalCommand getInstance() throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException;
}
