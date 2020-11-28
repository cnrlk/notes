package com.caneru.notesjava.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.caneru.notesjava.ui.features.list.ListNotesViewModel;
import com.caneru.notesjava.di.ViewModelKey;
import com.caneru.notesjava.util.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListNotesViewModel.class)
    abstract ViewModel contributesListViewModel(ListNotesViewModel listNotesViewModel);

    @Binds
    abstract ViewModelProvider.Factory contributesViewModelFactory(ViewModelFactory factory);
}
