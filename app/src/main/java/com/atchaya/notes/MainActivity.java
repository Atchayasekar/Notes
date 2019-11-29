package com.atchaya.notes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atchaya.notes.adapters.NotesRecyclerAdapter;
import com.atchaya.notes.models.Note;
import com.atchaya.notes.models.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NotesRecyclerAdapter.OnNoteListener {
    private static final String TAG ="MainActivity";

    // ui components

    private RecyclerView mRecyclerview;



    // vars
    private ArrayList<Note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mNoteRecyclerAdapter;


    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerview = findViewById( R.id.recyclerView);

          initRecyclerView();
          insertFakeNoteS();

          setSupportActionBar((Toolbar)findViewById(R.id.notes_toolbar));
          setTitle("Notes");
    }
     private void insertFakeNoteS() {
         for (int i = 0; i < 1000; i++) {
             Note note = new Note();
             note.setTitle(" title # " + i);
             note.setContent("content #:" + i);
             note.setTimestamp("Jan 2019");
             mNotes.add(note);
         }
         mNoteRecyclerAdapter.notifyDataSetChanged();
     }


    private void  initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerview.addItemDecoration(itemDecorator);
        mNoteRecyclerAdapter = new NotesRecyclerAdapter(mNotes, this );
        mRecyclerview.setAdapter(mNoteRecyclerAdapter);



    }

    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "onNoteClick: clicked." + position);

        Intent intent = new Intent( this, NoteActivity.class);
        intent.putExtra("selected_note", mNotes.get(position));
        startActivity(intent);




    }
}



