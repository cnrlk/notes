package com.caneru.notesjava.ui.features.create;

import android.app.Application;

import androidx.annotation.NonNull;

import com.caneru.notesjava.model.Note;
import com.caneru.notesjava.service.LocalStore;
import com.caneru.notesjava.ui.base.BaseViewModel;

import javax.inject.Inject;

public class CreateNoteViewModel extends BaseViewModel {

    @Inject
    LocalStore localStore;

    @Inject
    public CreateNoteViewModel(@NonNull Application application) {
        super(application);
    }

    public void createNote(String title, String description, String imageUrl, String createDate, String editDate) {
        Note note = new Note(title, description, imageUrl, createDate, editDate);
        localStore.addNote(note);
    }

    public void editNote(String title, String description, String imageUrl, String createDate, String editDate, int position) {
        Note note = new Note(title, description, imageUrl, createDate, editDate);
        localStore.editNote(note, position);
    }
}
