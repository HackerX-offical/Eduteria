package com.appnew.android.Courses.Interfaces;

import com.appnew.android.Courses.Modal.NotesPDF.NoteData;

/* JADX INFO: loaded from: classes6.dex */
public interface OnMyNotesItemListener {
    void onMyNotesDeleteClick(NoteData myNotes, int position);

    void onMyNotesEditClick(NoteData myNotes, int position);

    void onMyNotesItemClick(NoteData myNotes);
}
