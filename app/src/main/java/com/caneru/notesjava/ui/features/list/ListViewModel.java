package com.caneru.notesjava.ui.features.list;

import androidx.lifecycle.ViewModel;

import com.caneru.notesjava.service.LocalStore;

import javax.inject.Inject;

public class ListViewModel extends ViewModel {

    public LocalStore localStore;

    @Inject
    public ListViewModel(LocalStore localStore) {
        this.localStore = localStore;
    }

    public void getAllNotes() {
        localStore.getAllNotes();
    }
}
