package com.kurt.todo.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kurt.todo.R;
import com.kurt.todo.databinding.FragmentNotKayitBinding;
import com.kurt.todo.ui.viewmodel.NotKayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NotKayitFragment extends Fragment {

    private FragmentNotKayitBinding binding;
    private NotKayitViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentNotKayitBinding.inflate(inflater,container,false);

        binding.imageViewKaydet.setOnClickListener(view -> {
            String name = binding.editTextToDoKayit.getText().toString();

            viewModel.kaydet(name);
        });






        return binding.getRoot();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(NotKayitViewModel.class);
    }

}