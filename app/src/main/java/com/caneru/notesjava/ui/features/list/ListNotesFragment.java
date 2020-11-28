package com.caneru.notesjava.ui.features.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.caneru.notesjava.R;
import com.caneru.notesjava.model.Note;
import com.caneru.notesjava.service.LocalStore;
import com.caneru.notesjava.databinding.FragmentListBindingImpl;
import com.caneru.notesjava.di.DaggerAppComponent;
import com.caneru.notesjava.di.MainApplication;
import com.caneru.notesjava.ui.base.BaseFragment;
import com.caneru.notesjava.util.ViewModelFactory;

import java.util.Calendar;

import javax.inject.Inject;


public class ListNotesFragment extends BaseFragment {

    FragmentListBindingImpl binding;
    ListNotesViewModel viewModel;

    @Inject
    ViewModelFactory viewModelFactory;


    @Inject
    public LocalStore localStore;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(ListNotesViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DaggerAppComponent.builder().application(getActivity().getApplication()).build().inject((MainApplication) getActivity().getApplication());

        Note dummyNote = new Note("Title", "description asfjgsfga",
                null, Calendar.getInstance().getTime().toString(), null);

        viewModel.createNote(dummyNote);
        viewModel.fetchNotes();

        NoteListAdapter adapter = new NoteListAdapter(viewModel.getNotes());
        binding.rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvList.setAdapter(adapter);
    }
}
