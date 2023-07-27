package com.example.recyclerviewapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var todosList = mutableListOf<Todo>(
            Todo("Go to Gym",false),
            Todo("Go to Home after 5",true),
            Todo("do productive things",false),
            Todo("send hi",false),
            Todo("go for a bike ride",false)
        )

        val adapter = TodoAdapter(todosList)
        val rvId = findViewById<RecyclerView>(R.id.rvTodos)
        rvId.adapter = adapter
        rvId.layoutManager = LinearLayoutManager(this)

        val addBtnTodo = findViewById<Button>(R.id.btnAddTodo)
        val todoEt = findViewById<EditText>(R.id.etTodos)
        addBtnTodo.setOnClickListener {
            val title = todoEt.text.toString()
            val todo = Todo(title,false)
            todosList.add(todo)

            adapter.notifyItemInserted(todosList.size-1)
        }
    }
}