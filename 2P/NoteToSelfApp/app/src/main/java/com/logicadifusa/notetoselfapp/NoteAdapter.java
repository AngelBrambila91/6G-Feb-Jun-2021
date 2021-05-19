package com.logicadifusa.notetoselfapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
// Intents
//
public class NoteAdapter  extends RecyclerView.Adapter<NoteAdapter.ListItemHolder>{
    private List<Note> mNoteList;
    private MainActivity mMainActivity;

    public NoteAdapter(List<Note> noteList, MainActivity mainActivity) {
        this.mNoteList = noteList;
        this.mMainActivity = mainActivity;
    }

    @NonNull
    @Override
    public NoteAdapter.ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from((parent.getContext())).inflate(R.layout.listitem, parent, false);
        return new ListItemHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ListItemHolder holder, int position) {
        Note note = mNoteList.get(position);
        holder.mTitle.setText(note.getTitle());
        // show 15 characters
        if(note.getDescription().length() > 15) {
            holder.mDescription.setText(note.getDescription().substring(0,15));
        }
        else {
            holder.mDescription.setText(note.getDescription().substring(0, note.getDescription().length() / 2));
        }

        // Get status of note
        if(note.ismIdea()) {
            holder.mStatus.setText(R.string.idea_text);
        }
        else if(note.ismImportant()) {
            holder.mStatus.setText(R.string.important_text);
        }
        else if(note.ismTodo()) {
            holder.mStatus.setText(R.string.todo_text);
        }
    }

    @Override
    public int getItemCount() {
            return mNoteList.size();
    }

    public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTitle;
        TextView mDescription;
        TextView mStatus;

        public ListItemHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.textViewTitle);
            mDescription = itemView.findViewById(R.id.textViewDescription);
            mStatus = itemView.findViewById(R.id.textViewStatus);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mMainActivity.showNote(getAdapterPosition());
        }
    }
}
