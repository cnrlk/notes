package com.caneru.notesjava.ui.features.list;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.caneru.notesjava.model.Note;
import com.caneru.notesjava.service.LocalStore;

import java.util.ArrayList;

import javax.inject.Inject;

public class ListNotesViewModel extends ViewModel {

    public LocalStore localStore;

    private MutableLiveData<ArrayList<Note>> notes;

    @Inject
    public ListNotesViewModel(LocalStore localStore) {
        this.localStore = localStore;
        notes = new MutableLiveData<>();
    }

    public void fetchNotes() {
        notes.setValue(localStore.getAllNotes());
    }

    public ArrayList<Note> getNotesData() {
        return notes.getValue();
    }

    public MutableLiveData<ArrayList<Note>> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes.setValue(notes);
    }

    public void createNote(Note dummyNote) {
        localStore.addNote(dummyNote);
    }

    public void deleteNote(int position) {
        localStore.deleteNote(position);
    }
}
