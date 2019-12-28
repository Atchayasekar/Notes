package com.atchaya.notes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atchaya.notes.adapters.NotesRecyclerAdapter;
import com.atchaya.notes.models.Note;
import com.atchaya.notes.models.util.VerticalSpacingItemDecorator;
import com.atchaya.notes.persistence.async.NoteRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        NotesRecyclerAdapter.OnNoteListener,
        View.OnClickListener {
    private static final String TAG = "MainActivity";
    // ui components
    private RecyclerView mRecyclerview;
    // vars
    private ArrayList<Note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter mNoteRecyclerAdapter;
    private NoteRepository mNoteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerview = findViewById(R.id.recyclerView);

        findViewById(R.id.fab).setOnClickListener(this);
        mNoteRepository = new NoteRepository(this);

        initRecyclerView();
        retrieveNotes();
        //    insertFakeNoteS();

        Log.d(TAG, "onCreate: thread: " + Thread.currentThread().getName());
        mNoteRepository.insertNoteTask(new Note());

        setSupportActionBar((Toolbar) findViewById(R.id.notes_toolbar));
        setTitle("Notes");
    }


    private void retrieveNotes() {
        mNoteRepository.retrieveNotesTask().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {

                if (mNotes.size() > 0) {
                    mNotes.clear();
                }
                if (notes != null) {
                    mNotes.addAll(notes);
                }
                mNoteRecyclerAdapter.notifyDataSetChanged();
            }
        });
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


    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerview.addItemDecoration(itemDecorator);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mRecyclerview);
        mNoteRecyclerAdapter = new NotesRecyclerAdapter(mNotes, this);
        mRecyclerview.setAdapter(mNoteRecyclerAdapter);
    }

    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "onNoteClick: clicked." + position);

        Intent intent = new Intent(this, NoteActivity.class);
        intent.putExtra("selected_note", mNotes.get(position));
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

    private void deleteNote(Note note) {
        mNotes.remove(note);
        mNoteRecyclerAdapter.notifyDataSetChanged();

    }

    private ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            deleteNote(mNotes.get(viewHolder.getAdapterPosition()));

        }
    };
    private ItemTouchHelper.Callback someOtherThing = new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return 0;
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };
}



