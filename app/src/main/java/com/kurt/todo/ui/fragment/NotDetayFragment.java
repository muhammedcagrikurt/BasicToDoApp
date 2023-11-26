package com.kurt.todo.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kurt.todo.R;
import com.kurt.todo.data.entity.Todo;
import com.kurt.todo.databinding.FragmentNotDetayBinding;
import com.kurt.todo.ui.viewmodel.NotDetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NotDetayFragment extends Fragment {

    private FragmentNotDetayBinding binding;

    private NotDetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotDetayBinding.inflate(inflater,container,false);
        NotDetayFragmentArgs bundle = NotDetayFragmentArgs.fromBundle(getArguments());
        Todo gelenToDo = bundle.getTodo();

        binding.editTextToDo.setText(gelenToDo.getName());

        binding.imageViewGuncelle.setOnClickListener(view -> {
            String name = binding.editTextToDo.getText().toString();

            viewModel.guncelle(gelenToDo.getId(),name);
        });




        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel=new ViewModelProvider(this).get(NotDetayViewModel.class);
    }
}