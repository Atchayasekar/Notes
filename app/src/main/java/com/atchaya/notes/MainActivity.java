package com.atchaya.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.atchaya.notes.adapters.NotesRecyclerAdapter;
import com.atchaya.notes.models.Note;
import com.atchaya.notes.models.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
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
        mRecyclerview = findViewById( R.id.recyclerview);

          initRecyclerView();
          insertFakeNoteS();

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
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(verticalSpaceHeight:(10));
        mRecyclerview.addItemDecoration(itemDecorator);
        mNoteRecyclerAdapter = new NotesRecyclerAdapter(mNotes);
        mRecyclerview.setAdapter(mNoteRecyclerAdapter);



    }








}



