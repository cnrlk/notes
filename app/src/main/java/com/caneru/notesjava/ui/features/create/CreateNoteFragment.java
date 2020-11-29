package com.caneru.notesjava.ui.features.create;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.caneru.notesjava.R;
import com.caneru.notesjava.databinding.FragmentCreateBindingImpl;
import com.caneru.notesjava.model.Note;
import com.caneru.notesjava.ui.base.BaseActivity;
import com.caneru.notesjava.ui.base.BaseFragment;

import org.parceler.Parcels;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import static com.caneru.notesjava.util.validator.Validator.isValid;
import static com.caneru.notesjava.util.validator.Validator.removeValidator;

public class CreateNoteFragment extends BaseFragment {

    FragmentCreateBindingImpl binding;

    SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM d, yyyy 'at' h:mm a");

    public static final int CREATE_MODE = 0;
    public static final int EDIT_MODE = 1;

    private int mode = CREATE_MODE;
    private int position;
    private Note note;

    @Inject
    CreateNoteViewModel viewModel;

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        if (args != null) {
            mode = args.getInt("MODE");
            position = args.getInt("POSITION");
            note = Parcels.unwrap(args.getParcelable("NOTE"));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create, container, false);

        ((BaseActivity) getActivity()).toolbar.setTitle("Create Note");

        if (mode == EDIT_MODE) {
            ((BaseActivity) getActivity()).toolbar.setTitle("Edit Notes");
            binding.etTitle.setText(note.getTitle());
            binding.etDescription.setText(note.getDescription());
            binding.etImage.setText(note.getImage());
        }

        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValid()) {
                    if (mode == CREATE_MODE) {    // CREATE
                        viewModel.createNote(binding.etTitle.getText().toString(),
                                binding.etDescription.getText().toString(),
                                binding.etImage.getText().toString(),
                                format.format(Calendar.getInstance().getTime()),
                                null);
                    } else {
                        viewModel.editNote(binding.etTitle.getText().toString(),
                                binding.etDescription.getText().toString(),
                                binding.etImage.getText().toString(),
                                note.getCreateDate(),
                                format.format(Calendar.getInstance().getTime()),
                                position);
                    }

                    getActivity().getSupportFragmentManager().popBackStack();

                }
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        removeValidator(binding.etTitle);
        removeValidator(binding.etDescription);
    }
}
