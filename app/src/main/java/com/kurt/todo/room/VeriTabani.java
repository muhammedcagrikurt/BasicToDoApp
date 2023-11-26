package com.kurt.todo.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.kurt.todo.data.entity.Todo;

@Database(entities = {Todo.class},version = 1)
public abstract class VeriTabani extends RoomDatabase {

    public abstract TodoDao getTodoDao();
}
