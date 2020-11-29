package com.caneru.notesjava.ui.features.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.caneru.notesjava.R;
import com.caneru.notesjava.databinding.ViewNoteItemLayoutBinding;
import com.caneru.notesjava.model.Note;

import java.util.ArrayList;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    private ArrayList<Note> notes;
    private MenuClickListeners menuClickListeners;

    NoteListAdapter(ArrayList<Note> notes, MenuClickListeners menuClickListeners) {
        this.notes = notes;
        this.menuClickListeners = menuClickListeners;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewNoteItemLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.view_note_item_layout, parent,false);
        return new NoteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.binding.setNote(notes.get(position));
        holder.binding.buttonMenu.setDeleteListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuClickListeners.deleteClickListener(position);
            }
        });

        holder.binding.buttonMenu.setEditListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuClickListeners.editClickListener(notes.get(position), position);
            }
        });
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @Override
    public int getItemCount() {
        if (notes == null) {
            return 0;
        }
        return notes.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {

        ViewNoteItemLayoutBinding binding;

        public NoteViewHolder(ViewNoteItemLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

    public interface MenuClickListeners {
        public void editClickListener(Note note, int position);
        public void deleteClickListener(int position);
    }
}
