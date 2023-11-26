package com.kurt.todo.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.kurt.todo.data.repo.TodoDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class NotKayitViewModel extends ViewModel {

    public TodoDaoRepository todoDaoRepository;

    @Inject
    public NotKayitViewModel(TodoDaoRepository todoDaoRepository){
        this.todoDaoRepository=todoDaoRepository;
    }

    public void kaydet(String name){
        todoDaoRepository.kaydet(name);
    }


}
