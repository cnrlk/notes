package com.caneru.notesjava.service;

import com.caneru.notesjava.model.Note;

import java.util.ArrayList;
import java.util.List;

public interface LocalStore {

    public ArrayList<Note> getAllNotes();

    public void addNote(Note note);

}
