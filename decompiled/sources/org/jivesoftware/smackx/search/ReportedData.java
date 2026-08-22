package org.jivesoftware.smackx.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.packet.DataForm;

/* JADX INFO: loaded from: classes10.dex */
public class ReportedData {
    private final List<Column> columns;
    private final List<Row> rows;
    private String title;

    public static ReportedData getReportedDataFrom(Stanza stanza) {
        DataForm dataFormFrom = DataForm.from(stanza);
        if (dataFormFrom == null || dataFormFrom.getReportedData() == null) {
            return null;
        }
        return new ReportedData(dataFormFrom);
    }

    private ReportedData(DataForm dataForm) {
        this.columns = new ArrayList();
        this.rows = new ArrayList();
        this.title = "";
        for (FormField formField : dataForm.getReportedData().getFields()) {
            this.columns.add(new Column(formField.getLabel(), formField.getFieldName(), formField.getType()));
        }
        for (DataForm.Item item : dataForm.getItems()) {
            ArrayList arrayList = new ArrayList(this.columns.size());
            for (FormField formField2 : item.getFields()) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(formField2.getValues());
                arrayList.add(new Field(formField2.getFieldName(), arrayList2));
            }
            this.rows.add(new Row(arrayList));
        }
        this.title = dataForm.getTitle();
    }

    public ReportedData() {
        this.columns = new ArrayList();
        this.rows = new ArrayList();
        this.title = "";
    }

    public void addRow(Row row) {
        this.rows.add(row);
    }

    public void addColumn(Column column) {
        this.columns.add(column);
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(new ArrayList(this.rows));
    }

    public List<Column> getColumns() {
        return Collections.unmodifiableList(new ArrayList(this.columns));
    }

    public String getTitle() {
        return this.title;
    }

    public static class Column {
        private final String label;
        private final FormField.Type type;
        private final String variable;

        public Column(String str, String str2, FormField.Type type) {
            this.label = str;
            this.variable = str2;
            this.type = type;
        }

        public String getLabel() {
            return this.label;
        }

        public FormField.Type getType() {
            return this.type;
        }

        public String getVariable() {
            return this.variable;
        }
    }

    public static class Row {
        private List<Field> fields;

        public Row(List<Field> list) {
            new ArrayList();
            this.fields = list;
        }

        public List<CharSequence> getValues(String str) {
            for (Field field : getFields()) {
                if (str.equalsIgnoreCase(field.getVariable())) {
                    return field.getValues();
                }
            }
            return null;
        }

        private List<Field> getFields() {
            return Collections.unmodifiableList(new ArrayList(this.fields));
        }
    }

    public static class Field {
        private final List<? extends CharSequence> values;
        private final String variable;

        public Field(String str, List<? extends CharSequence> list) {
            this.variable = str;
            this.values = list;
        }

        public String getVariable() {
            return this.variable;
        }

        public List<CharSequence> getValues() {
            return Collections.unmodifiableList(this.values);
        }
    }
}
