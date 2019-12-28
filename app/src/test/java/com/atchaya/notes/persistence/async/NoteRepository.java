package com.atchaya.notes.persistence.async;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.atchaya.notes.models.Note;
import com.atchaya.notes.persistence.NoteDatabase;

import java.util.List;

public class NoteRepository {
    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context){
        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNoteTask(Note note) {
        new InsertAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }

    public void updateNote(Note note) {

    }

    public LiveData<List<Note>> retrieveNotesTask() {
        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNote(Note note) {

    }
}
