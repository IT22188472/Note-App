package com.example.sms.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.sms.models.Task
import com.example.sms.respository.TaskRepository
import com.example.sms.utils.Resource

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val taskRepository = TaskRepository(application)

    fun getTaskList() = taskRepository.getTaskList()

    fun insertTask(task : Task) : MutableLiveData<Resource<Long>>{
        return taskRepository.insertTask(task)
    }

    fun deleteTask(task : Task) : MutableLiveData<Resource<Int>>{
        return taskRepository.deleteTask(task)
    }

    fun deleteTaskUsingId(taskId : String) : MutableLiveData<Resource<Int>>{
        return taskRepository.deleteTaskUsingId(taskId)
    }

    fun updateTask(task : Task) : MutableLiveData<Resource<Int>>{
        return taskRepository.updateTask(task)
    }

    fun updateTaskParticularField(taskId: String,title: String, description: String) : MutableLiveData<Resource<Int>>{
        return taskRepository.updateTaskParticularField(taskId, title, description)
    }
}