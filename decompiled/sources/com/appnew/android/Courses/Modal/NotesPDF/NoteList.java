package com.appnew.android.Courses.Modal.NotesPDF;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class NoteList implements Serializable {
    ArrayList<NoteData> noteList;

    public NoteList(ArrayList<NoteData> noteList) {
        this.noteList = noteList;
    }

    public ArrayList<NoteData> getNoteList() {
        return this.noteList;
    }

    public void setNoteList(ArrayList<NoteData> noteList) {
        this.noteList = noteList;
    }
}
