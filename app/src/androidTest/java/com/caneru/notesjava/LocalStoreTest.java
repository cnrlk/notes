package com.caneru.notesjava;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.caneru.notesjava.model.Note;
import com.caneru.notesjava.service.LocalStore;
import com.caneru.notesjava.service.SharedPrefsLocalStore;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class LocalStoreTest  {

    @Test
    public void addNewNote() {
        Note dummyNote = new Note("Title", "description asfjgsfga",
                null, Calendar.getInstance().getTime().toString(), null);

        SharedPreferences preferences = ApplicationProvider.getApplicationContext()
                .getSharedPreferences("notes", Context.MODE_PRIVATE);


        LocalStore localStore = new SharedPrefsLocalStore(preferences);

        localStore.addNote(dummyNote);

        Gson converter = new Gson();

        String notesString = preferences.getString("ALL_NOTES", null);
        if (notesString == null) {
            fail();
        }
        Type type = new TypeToken < ArrayList<Note> >(){}.getType();
        ArrayList<Note> list = converter.fromJson(notesString, type);
        if (list==null) {
            fail();
        } else {
            assertTrue(list.contains(dummyNote));
        }

    }

    @Test
    public void getAllNotes() {
        SharedPreferences preferences = ApplicationProvider.getApplicationContext()
                .getSharedPreferences("notes", Context.MODE_PRIVATE);

        LocalStore localStore = new SharedPrefsLocalStore(preferences);

        ArrayList<Note> notes = localStore.getAllNotes();

        Gson converter = new Gson();

        String notesString = preferences.getString("ALL_NOTES", null);
        if (notesString == null) {
            fail();
        }
        Type type = new TypeToken < ArrayList<Note> >(){}.getType();
        ArrayList<Note> list = converter.fromJson(notesString, type);
        if (list==null) {
            fail();
        } else {
            assertEquals(notes.size(), list.size());
        }
    }

}
