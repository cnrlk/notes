package com.caneru.notesjava.ui.features.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.caneru.notesjava.R;
import com.caneru.notesjava.model.Note;
import com.caneru.notesjava.service.LocalStore;
import com.caneru.notesjava.databinding.FragmentListBindingImpl;
import com.caneru.notesjava.ui.base.BaseActivity;
import com.caneru.notesjava.ui.base.BaseFragment;
import com.caneru.notesjava.ui.features.create.CreateNoteFragment;

import org.parceler.Parcel;
import org.parceler.Parcels;

import java.util.ArrayList;

import javax.inject.Inject;


public class ListNotesFragment extends BaseFragment implements NoteListAdapter.MenuClickListeners {

    FragmentListBindingImpl binding;

    @Inject
    ListNotesViewModel viewModel;

    @Inject
    public LocalStore localStore;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        //viewModel = new ViewModelProvider(this, viewModelFactory).get(ListNotesViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.fetchNotes();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // replace note list fragment with create note fragment
                ((BaseActivity) ListNotesFragment.super.getActivity()).replaceFragment(new CreateNoteFragment());
            }
        });

        NoteListAdapter adapter = new NoteListAdapter(viewModel.getNotesData(), this);
        binding.rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvList.setAdapter(adapter);

        viewModel.getNotes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Note>>() {
            @Override
            public void onChanged(ArrayList<Note> notes) {
                adapter.setNotes(notes);
                adapter.notifyDataSetChanged();
                if (notes == null || notes.size() == 0) {
                    binding.tvEmptyInfo.setVisibility(View.VISIBLE);
                    binding.rvList.setVisibility(View.GONE);
                } else {
                    binding.tvEmptyInfo.setVisibility(View.GONE);
                    binding.rvList.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public void editClickListener(Note note, int position) {
        CreateNoteFragment fragment = new CreateNoteFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("MODE", CreateNoteFragment.EDIT_MODE);
        bundle.putInt("POSITION", position);
        bundle.putParcelable("NOTE", Parcels.wrap(note));
        fragment.setArguments(bundle);
        ((BaseActivity) ListNotesFragment.super.getActivity()).replaceFragment(fragment);
    }

    @Override
    public void deleteClickListener(int position) {
        viewModel.deleteNote(position);
        viewModel.fetchNotes();
    }
}
