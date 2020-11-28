package com.caneru.notesjava.di.modules;

import com.caneru.notesjava.ui.features.list.ListNotesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract ListNotesFragment contributesListFragment();
}
