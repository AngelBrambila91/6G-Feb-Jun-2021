package com.logicadifusa.notetoselfapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // temporary note
    //Note mTempNote = new Note();
    private JSONSerializer mSerializer;
    //private List<Note> noteList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NoteAdapter mAdapter;
    private List<Note> noteList;


    @Override
    protected void onPause() {
        super.onPause();
        saveNotes();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mPrefs = getSharedPreferences("Note to self", MODE_PRIVATE);
        mShowDividers = mPrefs.getBoolean("dividers", true);
        if(mShowDividers) {
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        }
        else {
            if(recyclerView.getItemDecorationCount() > 0) {
                recyclerView.removeItemDecorationAt(0);
            }
        }
    }

    private boolean mShowDividers;
    private SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogNewNote dialog = new DialogNewNote();
                dialog.show(getSupportFragmentManager(), "New Note");
            }
        });
        mSerializer = new JSONSerializer("NoteToSelf.json", getApplicationContext());
        try {
            noteList = mSerializer.load();
        } catch (Exception e) {
            noteList = new ArrayList<Note>();
            Log.e("Error loading notes : ", "", e);
        }
        recyclerView = findViewById(R.id.recyclerView);
        mAdapter = new NoteAdapter(noteList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        /*recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));*/
        recyclerView.setAdapter(mAdapter);



/*        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogShowNote dialog = new DialogShowNote();
                dialog.sendNoteSelected(mTempNote);
                dialog.show(getSupportFragmentManager(), "Your note");
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createNewNote(Note n) {
        noteList.add(n);
        mAdapter.notifyDataSetChanged();
    }

    public void showNote(int adapterPosition) {
        DialogShowNote dialog = new DialogShowNote();
        dialog.sendNoteSelected(noteList.get(adapterPosition));
        dialog.show(getSupportFragmentManager(),"");
    }

    public void saveNotes() {
        try {
            mSerializer.save(noteList);
        } catch (Exception e) {
            Log.e("Error saving Notes", "", e);
        }
    }
}