package com.caneru.notesjava.service;

import com.caneru.notesjava.model.Note;

import java.util.ArrayList;

public interface LocalStore {

    public ArrayList<Note> getAllNotes();

    public void addNote(Note note);

    void deleteNote(int position);

    public void editNote(Note note, int position);
}
