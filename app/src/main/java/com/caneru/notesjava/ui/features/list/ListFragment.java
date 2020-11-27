package com.caneru.notesjava.ui.features.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.caneru.notesjava.R;
import com.caneru.notesjava.service.LocalStore;
import com.caneru.notesjava.databinding.FragmentListBindingImpl;
import com.caneru.notesjava.di.DaggerAppComponent;
import com.caneru.notesjava.di.MainApplication;
import com.caneru.notesjava.ui.base.BaseFragment;
import com.caneru.notesjava.util.ViewModelFactory;

import javax.inject.Inject;


public class ListFragment extends BaseFragment {

    FragmentListBindingImpl binding;
    ListViewModel viewModel;

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
        viewModel = new ViewModelProvider(this, viewModelFactory).get(ListViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DaggerAppComponent.builder().application(getActivity().getApplication()).build().inject((MainApplication) getActivity().getApplication());

        viewModel.getAllNotes();
    }
}
