package com.caneru.notesjava.ui.features.list;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.caneru.notesjava.model.Note;
import com.caneru.notesjava.service.LocalStore;
import com.caneru.notesjava.ui.base.BaseViewModel;
import java.util.ArrayList;
import javax.inject.Inject;

public class ListNotesViewModel extends BaseViewModel {

    @Inject
    public LocalStore localStore;

    private MutableLiveData<ArrayList<Note>> notes;

    @Inject
    public ListNotesViewModel(Application application) {
        super(application);
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
