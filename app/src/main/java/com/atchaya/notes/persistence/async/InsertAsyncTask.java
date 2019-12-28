package com.atchaya.notes.persistence.async;

import android.os.AsyncTask;
import android.util.Log;

import com.atchaya.notes.models.Note;
import com.atchaya.notes.persistence.NoteDao;

public class InsertAsyncTask extends AsyncTask<Note, Void,Void> {
    private static final String TAG = "InsertAsyncTask";
    private NoteDao mNoteDao;

    public InsertAsyncTask(NoteDao mNoteDao) {
        this.mNoteDao = mNoteDao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        Log.d(TAG, "doInBackground: thread: " + Thread.currentThread().getName());
         mNoteDao.insertNotes();
         return null;


    }
}
