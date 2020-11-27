package com.caneru.notesjava.service;

import android.content.SharedPreferences;

public class SharedPrefsLocalStore implements LocalStore {

    private SharedPreferences preferences;

    public SharedPrefsLocalStore(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public void getAllNotes() {

    }
}
