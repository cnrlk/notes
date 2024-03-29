package com.caneru.notesjava.service;

import android.content.SharedPreferences;

import com.caneru.notesjava.model.Note;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SharedPrefsLocalStore implements LocalStore {

    private final String ALL_NOTES = "ALL_NOTES";

    private final SharedPreferences preferences;

    private Gson gsonConverter;

    public SharedPrefsLocalStore(SharedPreferences preferences) {
        this.preferences = preferences;
        gsonConverter = new Gson();
    }

    @Override
    public ArrayList<Note> getAllNotes() {
        Type type = new TypeToken<ArrayList<Note>>(){}.getType();
        String notesString = preferences.getString(ALL_NOTES, null);
        if (notesString == null) {
            return null;
        } else {
            return gsonConverter.fromJson(notesString,type);
        }
    }

    @Override
    public void addNote(Note note) {
        ArrayList<Note> notes = getAllNotes();
        if (notes == null) {
            notes = new ArrayList<>();
        }
        notes.add(note);
        preferences.edit().putString(ALL_NOTES, gsonConverter.toJson(notes)).apply();
    }

    @Override
    public void deleteNote(int position) {
        ArrayList<Note> notes = getAllNotes();
        notes.remove(position);
        preferences.edit().putString(ALL_NOTES, gsonConverter.toJson(notes)).apply();

    }

    @Override
    public void editNote(Note note, int position) {
        ArrayList<Note> notes = getAllNotes();
        notes.remove(position);
        notes.add(position, note);
        preferences.edit().putString(ALL_NOTES, gsonConverter.toJson(notes)).apply();
    }
}
