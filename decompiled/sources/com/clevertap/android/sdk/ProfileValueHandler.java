package com.clevertap.android.sdk;

import com.clevertap.android.sdk.utils.CTJsonConverter;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.clevertap.android.sdk.validation.ValidationResultFactory;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import com.clevertap.android.sdk.validation.Validator;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.json.JSONArray;

/* JADX INFO: compiled from: ProfileValueHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J3\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u0019H\u0002¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/clevertap/android/sdk/ProfileValueHandler;", "", "validator", "Lcom/clevertap/android/sdk/validation/Validator;", "validationResultStack", "Lcom/clevertap/android/sdk/validation/ValidationResultStack;", "<init>", "(Lcom/clevertap/android/sdk/validation/Validator;Lcom/clevertap/android/sdk/validation/ValidationResultStack;)V", "numberValueType", "Lcom/clevertap/android/sdk/ProfileValueHandler$NumberValueType;", "handleIncrementDecrementValues", "", "value", AdHocCommandData.ELEMENT, "", "existingValue", "getNumberValueType", "handleMultiValues", "Lorg/json/JSONArray;", "key", "values", "existingValues", "constructExistingMultiValue", "existing", "cleanMultiValues", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)Lorg/json/JSONArray;", "generateEmptyMultiValueError", "", "stringifyAndCleanScalarProfilePropValue", "NumberValueType", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProfileValueHandler {
    private NumberValueType numberValueType;
    private final ValidationResultStack validationResultStack;
    private final Validator validator;

    /* JADX INFO: compiled from: ProfileValueHandler.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NumberValueType.values().length];
            try {
                iArr[NumberValueType.DOUBLE_NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NumberValueType.FLOAT_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ProfileValueHandler(Validator validator, ValidationResultStack validationResultStack) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(validationResultStack, "validationResultStack");
        this.validator = validator;
        this.validationResultStack = validationResultStack;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: ProfileValueHandler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/clevertap/android/sdk/ProfileValueHandler$NumberValueType;", "", "<init>", "(Ljava/lang/String;I)V", "INT_NUMBER", "FLOAT_NUMBER", "DOUBLE_NUMBER", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NumberValueType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NumberValueType[] $VALUES;
        public static final NumberValueType INT_NUMBER = new NumberValueType("INT_NUMBER", 0);
        public static final NumberValueType FLOAT_NUMBER = new NumberValueType("FLOAT_NUMBER", 1);
        public static final NumberValueType DOUBLE_NUMBER = new NumberValueType("DOUBLE_NUMBER", 2);

        private static final /* synthetic */ NumberValueType[] $values() {
            return new NumberValueType[]{INT_NUMBER, FLOAT_NUMBER, DOUBLE_NUMBER};
        }

        public static EnumEntries<NumberValueType> getEntries() {
            return $ENTRIES;
        }

        private NumberValueType(String str, int i) {
        }

        static {
            NumberValueType[] numberValueTypeArr$values = $values();
            $VALUES = numberValueTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(numberValueTypeArr$values);
        }

        public static NumberValueType valueOf(String str) {
            return (NumberValueType) Enum.valueOf(NumberValueType.class, str);
        }

        public static NumberValueType[] values() {
            return (NumberValueType[]) $VALUES.clone();
        }
    }

    public final Number handleIncrementDecrementValues(Number value, String command, Number existingValue) {
        int i;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(command, "command");
        if (existingValue == null) {
            NumberValueType numberValueType = getNumberValueType(value);
            i = numberValueType != null ? WhenMappings.$EnumSwitchMapping$0[numberValueType.ordinal()] : -1;
            if (i == 1) {
                if (Intrinsics.areEqual(command, Constants.COMMAND_INCREMENT)) {
                    return Double.valueOf(value.doubleValue());
                }
                if (Intrinsics.areEqual(command, Constants.COMMAND_DECREMENT)) {
                    return Double.valueOf(-value.doubleValue());
                }
                return null;
            }
            if (i == 2) {
                if (Intrinsics.areEqual(command, Constants.COMMAND_INCREMENT)) {
                    return Float.valueOf(value.floatValue());
                }
                if (Intrinsics.areEqual(command, Constants.COMMAND_DECREMENT)) {
                    return Float.valueOf(-value.floatValue());
                }
                return null;
            }
            if (Intrinsics.areEqual(command, Constants.COMMAND_INCREMENT)) {
                return Integer.valueOf(value.intValue());
            }
            if (Intrinsics.areEqual(command, Constants.COMMAND_DECREMENT)) {
                return Integer.valueOf(-value.intValue());
            }
            return null;
        }
        NumberValueType numberValueType2 = getNumberValueType(existingValue);
        i = numberValueType2 != null ? WhenMappings.$EnumSwitchMapping$0[numberValueType2.ordinal()] : -1;
        if (i == 1) {
            if (Intrinsics.areEqual(command, Constants.COMMAND_INCREMENT)) {
                return Double.valueOf(existingValue.doubleValue() + value.doubleValue());
            }
            if (Intrinsics.areEqual(command, Constants.COMMAND_DECREMENT)) {
                return Double.valueOf(existingValue.doubleValue() - value.doubleValue());
            }
            return null;
        }
        if (i == 2) {
            if (Intrinsics.areEqual(command, Constants.COMMAND_INCREMENT)) {
                return Float.valueOf(existingValue.floatValue() + value.floatValue());
            }
            if (Intrinsics.areEqual(command, Constants.COMMAND_DECREMENT)) {
                return Float.valueOf(existingValue.floatValue() - value.floatValue());
            }
            return null;
        }
        if (Intrinsics.areEqual(command, Constants.COMMAND_INCREMENT)) {
            return Integer.valueOf(existingValue.intValue() + value.intValue());
        }
        if (Intrinsics.areEqual(command, Constants.COMMAND_DECREMENT)) {
            return Integer.valueOf(existingValue.intValue() - value.intValue());
        }
        return null;
    }

    private final NumberValueType getNumberValueType(Number value) {
        return Intrinsics.areEqual(value, Integer.valueOf(value.intValue())) ? NumberValueType.INT_NUMBER : Intrinsics.areEqual(value, Double.valueOf(value.doubleValue())) ? NumberValueType.DOUBLE_NUMBER : Intrinsics.areEqual(value, Float.valueOf(value.floatValue())) ? NumberValueType.FLOAT_NUMBER : this.numberValueType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final JSONArray handleMultiValues(String key, JSONArray values, String command, Object existingValues) {
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(command, "command");
        JSONArray jSONArrayConstructExistingMultiValue = constructExistingMultiValue(command, existingValues);
        Intrinsics.checkNotNull(values);
        ArrayList<?> list = CTJsonConverter.toList(values);
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        JSONArray jSONArrayCleanMultiValues = cleanMultiValues(key, list);
        if (jSONArrayConstructExistingMultiValue == null || jSONArrayCleanMultiValues == null) {
            return null;
        }
        if (Intrinsics.areEqual(command, Constants.COMMAND_REMOVE)) {
            str = Validator.REMOVE_VALUES_OPERATION;
        } else {
            str = Validator.ADD_VALUES_OPERATION;
        }
        ValidationResult validationResultMergeMultiValuePropertyForKey = this.validator.mergeMultiValuePropertyForKey(jSONArrayConstructExistingMultiValue, jSONArrayCleanMultiValues, str, key);
        if (validationResultMergeMultiValuePropertyForKey.getErrorCode() != 0) {
            this.validationResultStack.pushValidationResult(validationResultMergeMultiValuePropertyForKey);
        }
        Object object = validationResultMergeMultiValuePropertyForKey.getObject();
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type org.json.JSONArray");
        JSONArray jSONArray = (JSONArray) object;
        if (jSONArray.length() <= 0) {
            return null;
        }
        return jSONArray;
    }

    private final JSONArray constructExistingMultiValue(String command, Object existing) {
        boolean zAreEqual = Intrinsics.areEqual(command, Constants.COMMAND_REMOVE);
        boolean zAreEqual2 = Intrinsics.areEqual(command, Constants.COMMAND_ADD);
        if (!zAreEqual && !zAreEqual2) {
            return new JSONArray();
        }
        if (existing == null) {
            if (zAreEqual) {
                return null;
            }
            return new JSONArray();
        }
        if (existing instanceof JSONArray) {
            return (JSONArray) existing;
        }
        JSONArray jSONArray = zAreEqual2 ? new JSONArray() : null;
        String strStringifyAndCleanScalarProfilePropValue = stringifyAndCleanScalarProfilePropValue(existing);
        return strStringifyAndCleanScalarProfilePropValue != null ? new JSONArray().put(strStringifyAndCleanScalarProfilePropValue) : jSONArray;
    }

    private final JSONArray cleanMultiValues(String key, ArrayList<String> values) {
        if (values == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = values.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                String next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                String str = next;
                ValidationResult validationResultCleanMultiValuePropertyValue = this.validator.cleanMultiValuePropertyValue(str);
                if (validationResultCleanMultiValuePropertyValue.getErrorCode() != 0) {
                    this.validationResultStack.pushValidationResult(validationResultCleanMultiValuePropertyValue);
                }
                String string = validationResultCleanMultiValuePropertyValue.getObject() != null ? validationResultCleanMultiValuePropertyValue.getObject().toString() : null;
                if (str.length() == 0) {
                    generateEmptyMultiValueError(key);
                    return null;
                }
                jSONArray.put(string);
            }
            return jSONArray;
        } catch (Throwable th) {
            Logger.v("Error cleaning multi values for key " + key, th);
            generateEmptyMultiValueError(key);
            return null;
        }
    }

    private final void generateEmptyMultiValueError(String key) {
        ValidationResult validationResultCreate = ValidationResultFactory.create(512, 1, key);
        this.validationResultStack.pushValidationResult(validationResultCreate);
        Logger.v(validationResultCreate.getErrorDesc());
    }

    private final String stringifyAndCleanScalarProfilePropValue(Object value) {
        String jsonString = CTJsonConverter.toJsonString(value);
        if (jsonString == null) {
            return jsonString;
        }
        ValidationResult validationResultCleanMultiValuePropertyValue = this.validator.cleanMultiValuePropertyValue(jsonString);
        if (validationResultCleanMultiValuePropertyValue.getErrorCode() != 0) {
            this.validationResultStack.pushValidationResult(validationResultCleanMultiValuePropertyValue);
        }
        if (validationResultCleanMultiValuePropertyValue.getObject() != null) {
            return validationResultCleanMultiValuePropertyValue.getObject().toString();
        }
        return null;
    }
}
