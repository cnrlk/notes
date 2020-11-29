package com.caneru.notesjava.ui;

import android.os.Bundle;

import com.caneru.notesjava.R;
import com.caneru.notesjava.ui.base.BaseActivity;
import com.caneru.notesjava.ui.features.list.ListNotesFragment;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // disable dark theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        // add note list fragment
        addFragment(new ListNotesFragment());
    }
}