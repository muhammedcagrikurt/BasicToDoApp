package com.kurt.todo.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kurt.todo.data.entity.Todo;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface TodoDao {

    @Query("SELECT * FROM toDos")
    Single<List<Todo>> todoYukle();

    @Insert
    Completable kaydet(Todo todo);

    @Update
    Completable guncelle(Todo todo);

    @Delete
    Completable sil(Todo todo);

    @Query("SELECT * FROM toDos WHERE name like '%' || :aramaKelimesi ||  '%' ")
    Single<List<Todo>> ara(String aramaKelimesi);

}
