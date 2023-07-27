package com.example.recyclerviewapplication

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TodoAdapter (var Todos : List<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    inner class TodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.tvTitle)
        val checkBox : CheckBox = itemView.findViewById(R.id.cbIsCheck)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.todo_view,parent,false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val cbDone = holder.itemView.findViewById<TextView>(R.id.cbIsCheck)

        holder.textView.text = Todos[position].title
        holder.checkBox.isChecked = Todos[position].isChecked
    }

}