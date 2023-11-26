package com.kurt.todo.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.kurt.todo.R;
import com.kurt.todo.databinding.FragmentAnasayfaBinding;
import com.kurt.todo.ui.adapter.TodoAdapter;
import com.kurt.todo.ui.viewmodel.AnasayfaViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AnasayfaFragment extends Fragment {

    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater,container,false);



        binding.todoRV.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.todoList.observe(getViewLifecycleOwner(),todoList -> {
            TodoAdapter adapter = new TodoAdapter(todoList,requireContext(),viewModel);

            binding.todoRV.setAdapter(adapter);
        });

        binding.fabButton.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.anasayfaKayitGecis);
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                viewModel.ara(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                viewModel.ara(s);
                return true;
            }
        });



        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.todoYukle();
    }
}