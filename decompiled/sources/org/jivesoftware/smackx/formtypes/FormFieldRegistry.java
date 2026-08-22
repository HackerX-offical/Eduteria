package org.jivesoftware.smackx.formtypes;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlUtil;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.TextSingleFormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class FormFieldRegistry {
    private static final Logger LOGGER = Logger.getLogger(FormFieldRegistry.class.getName());
    private static final Map<String, Map<String, FormField.Type>> REGISTRY = new HashMap();
    private static final Map<String, FormField.Type> CLARK_NOTATION_FIELD_REGISTRY = new ConcurrentHashMap();
    private static final Map<String, FormField.Type> LOOKASIDE_FIELD_REGISTRY = new ConcurrentHashMap();

    public static void register(DataForm dataForm) {
        FormField.Type type;
        if (dataForm.getType() != DataForm.Type.form) {
            throw new IllegalArgumentException();
        }
        TextSingleFormField hiddenFormTypeField = dataForm.getHiddenFormTypeField();
        String value = hiddenFormTypeField != null ? hiddenFormTypeField.getValue() : null;
        for (FormField formField : dataForm.getFields()) {
            if (formField != hiddenFormTypeField && (type = formField.getType()) != FormField.Type.fixed) {
                register(value, formField.getFieldName(), type);
            }
        }
    }

    public static void register(String str, String str2, FormField.Type type) {
        FormField.Type typePut;
        StringUtils.requireNotNullNorEmpty(str2, "fieldName must be provided");
        Objects.requireNonNull(type);
        if (str == null) {
            if (XmlUtil.isClarkNotation(str2)) {
                CLARK_NOTATION_FIELD_REGISTRY.put(str2, type);
                return;
            }
            return;
        }
        Map<String, Map<String, FormField.Type>> map = REGISTRY;
        synchronized (map) {
            Map<String, FormField.Type> map2 = map.get(str);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(str, map2);
            } else {
                FormField.Type type2 = map2.get(str2);
                if (type2 != null && type2 != type) {
                    throw new IllegalArgumentException();
                }
            }
            typePut = map2.put(str2, type);
        }
        if (typePut == null || type == typePut) {
            return;
        }
        LOGGER.warning("Form field registry inconsitency detected: Registered field '" + str2 + "' of type " + type + " but previous type was " + typePut);
    }

    public static FormField.Type lookup(String str, String str2) {
        FormField.Type type;
        if (str == null) {
            if (XmlUtil.isClarkNotation(str2)) {
                return CLARK_NOTATION_FIELD_REGISTRY.get(str2);
            }
            return LOOKASIDE_FIELD_REGISTRY.get(str2);
        }
        Map<String, Map<String, FormField.Type>> map = REGISTRY;
        synchronized (map) {
            Map<String, FormField.Type> map2 = map.get(str);
            if (map2 == null || (type = map2.get(str2)) == null) {
                return null;
            }
            return type;
        }
    }

    public static synchronized FormField.Type lookup(String str) {
        return lookup(null, str);
    }

    public static void addLookasideFieldRegistryEntry(String str, FormField.Type type) {
        LOOKASIDE_FIELD_REGISTRY.put(str, type);
    }
}
