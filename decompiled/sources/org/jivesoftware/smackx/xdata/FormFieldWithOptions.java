package org.jivesoftware.smackx.xdata;

import java.util.List;
import org.jivesoftware.smackx.xdata.FormField;

/* JADX INFO: loaded from: classes10.dex */
public interface FormFieldWithOptions {
    List<FormField.Option> getOptions();

    public interface Builder<B extends FormField.Builder<?, ?>> {
        B addOption(FormField.Option option);

        default B addOption(String str) {
            return (B) addOption(new FormField.Option(str));
        }
    }
}
