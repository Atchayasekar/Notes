package com.atchaya.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.atchaya.notes.models.note;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Note note = new Note( title: "some title", content: "some content", timestamp: "some timestamp" );

        log.d(TAG,  msg: "oncreate: my note: " + note.getTitle());



    }

}

