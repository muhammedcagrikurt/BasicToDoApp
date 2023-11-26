package com.kurt.todo.di;

import android.content.Context;

import androidx.room.Room;

import com.kurt.todo.data.repo.TodoDaoRepository;
import com.kurt.todo.room.TodoDao;
import com.kurt.todo.room.VeriTabani;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public TodoDaoRepository provideTodoDaoRepository(TodoDao todoDao){
        return new TodoDaoRepository(todoDao);
    }

    @Provides
    @Singleton
    public TodoDao provideTodoDao(@ApplicationContext Context context){
        VeriTabani veriTabani = Room.databaseBuilder(context,VeriTabani.class,"todo.sqlite")
                .createFromAsset("todo.sqlite").build();
        return veriTabani.getTodoDao();
    }



}
