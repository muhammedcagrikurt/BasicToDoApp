package com.kurt.todo.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.kurt.todo.data.repo.TodoDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NotDetayViewModel extends ViewModel {

    TodoDaoRepository todoDaoRepository;
    @Inject
    public NotDetayViewModel(TodoDaoRepository todoDaoRepository){
        this.todoDaoRepository=todoDaoRepository;
    }

    public void guncelle(int id, String name ){
        todoDaoRepository.guncelle(id, name);
    }
}
