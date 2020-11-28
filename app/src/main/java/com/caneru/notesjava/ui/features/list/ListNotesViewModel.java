package com.caneru.notesjava.ui.features.list;

import androidx.lifecycle.ViewModel;

import com.caneru.notesjava.model.Note;
import com.caneru.notesjava.service.LocalStore;

import java.util.ArrayList;

import javax.inject.Inject;

public class ListNotesViewModel extends ViewModel {

    public LocalStore localStore;

    private ArrayList<Note> notes;

    @Inject
    public ListNotesViewModel(LocalStore localStore) {
        this.localStore = localStore;
    }

    public void fetchNotes() {
        notes = localStore.getAllNotes();
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public void createNote(Note dummyNote) {
        localStore.addNote(dummyNote);
    }
}
