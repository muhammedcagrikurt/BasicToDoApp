package com.kurt.todo.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.kurt.todo.data.entity.Todo;
import com.kurt.todo.room.TodoDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TodoDaoRepository {
    private TodoDao todoDao;

    public MutableLiveData<List<Todo>> todoList = new MutableLiveData<>();

    public TodoDaoRepository(TodoDao todoDao){
        this.todoDao=todoDao;
    }

    public void kaydet(String name){
        Todo yeniToDo = new Todo(0,name);
        todoDao.kaydet(yeniToDo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void guncelle(int id , String name){
        Todo guncellenenToDo = new Todo(id,name);
        todoDao.guncelle(guncellenenToDo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void ara(String aramaKelimesi){
        todoDao.ara(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Todo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Todo> todos) {
                        todoList.setValue(todos);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }


    public void sil(int id){
        Todo silinenTodo = new Todo(id,"");
        todoDao.sil(silinenTodo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {todoYukle();


                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void todoYukle(){
        todoDao.todoYukle().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Todo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Todo> todos) {
                        todoList.setValue(todos);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }


}
