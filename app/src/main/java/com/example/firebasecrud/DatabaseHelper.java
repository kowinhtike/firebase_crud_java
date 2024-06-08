package com.example.firebasecrud;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private FirebaseDatabase database;
    private DatabaseReference tasksRef;
    public DatabaseHelper(){
        database = FirebaseDatabase.getInstance();
        tasksRef = database.getReference("tasks");
    }

    public void createTask(Task task){
        String taskId = tasksRef.push().getKey();
        task.setId(taskId);
        tasksRef.child(taskId).setValue(task);
        Log.d("task_id","Create");
    }

    public void updateTask(String taskId,Task task){
        tasksRef.child(taskId).setValue(task);
        Log.d("task_id","Update");
    }

    public void removeTask(String taskId){
        tasksRef.child(taskId).removeValue();
        Log.d("task_id","Remove");
    }

    public void getAllTasks(final TaskListener taskListener) {
        tasksRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Task> taskList = new ArrayList<>();
                for (DataSnapshot taskSnapshot : dataSnapshot.getChildren()) {
                    Task task = taskSnapshot.getValue(Task.class);
                    taskList.add(task);
                }
                taskListener.onTasksLoaded(taskList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
    }

    // Interface for callback
    public interface TaskListener {
        void onTasksLoaded(List<Task> taskList);
    }

}
