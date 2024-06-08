package com.example.firebasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        DatabaseHelper databaseHelper = new DatabaseHelper();

        //Create
//        Task task = new Task(null,"Title","Description");
//        databaseHelper.createTask(task);

        //Update
//        Task task = new Task(null,"Title 22","Description 22");
//        databaseHelper.updateTask("-NokGvtxwDZOqOpLRccw",task);

        //Remove
//        databaseHelper.removeTask("-NokGvtxwDZOqOpLRccw");

        //Read
        databaseHelper.getAllTasks(new DatabaseHelper.TaskListener() {
            @Override
            public void onTasksLoaded(List<Task> taskList) {
                // Handle the loaded tasks, e.g., update UI
                int number = 0;
                for (Task task : taskList) {
                    // Do something with each task
                    number++;
                }
                textView.setText(String.valueOf(number));
            }
        });

    }
}