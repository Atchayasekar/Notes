package com.atchaya.notes;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;

import com.atchaya.notes.models.Note;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";
    private String title;
    private String content;
    private String timestamp;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Note note = new Note("some title","some content", "some timestamp");

        Log.d(TAG, "onCreate: my Note: \" + note.getTitle()");



    }

}

