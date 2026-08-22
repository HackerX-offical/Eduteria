package com.appnew.android.Dao;

import com.appnew.android.table.PDFDataTable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface PDFDataDao {
    void delete(PDFDataTable model);

    void delete_pdf_data(String test_id);

    List<PDFDataTable> getListOfData();

    void insert(PDFDataTable model);

    boolean pdfData(String test_id);

    PDFDataTable pdf_data(String pdf_id, String pdfName, String userid);

    void update(PDFDataTable model);
}
