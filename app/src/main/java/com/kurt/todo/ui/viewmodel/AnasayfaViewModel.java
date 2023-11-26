package com.kurt.todo.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurt.todo.data.entity.Todo;
import com.kurt.todo.data.repo.TodoDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {

    public TodoDaoRepository todoDaoRepository;
    public MutableLiveData<List<Todo>> todoList;
    @Inject
    public AnasayfaViewModel(TodoDaoRepository todoDaoRepository){
        this.todoDaoRepository=todoDaoRepository;
        todoYukle();
        todoList=todoDaoRepository.todoList;
    }

    public void ara(String aramaKelimesi){
        todoDaoRepository.ara(aramaKelimesi);
    }
    public void sil(int id){
        todoDaoRepository.sil(id);
    }

    public void todoYukle(){
        todoDaoRepository.todoYukle();
    }

}
