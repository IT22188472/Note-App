package com.example.sms.respository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.sms.dao.TaskDao
import com.example.sms.database.TaskDatabase
import com.example.sms.models.Task
import com.example.sms.utils.Resource
import com.example.sms.utils.Resource.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class TaskRepository(application: Application) {

    private val taskDao: TaskDao = TaskDatabase.getInstance(application).taskDao

    fun getTaskList() = flow {
        emit(Loading())
        try{
            val result = taskDao.getTaskList()
            emit(Success(result))
        }catch (e:Exception){
            emit(Error(e.message.toString()))
        }
    }

    fun insertTask(task: Task) = MutableLiveData<Resource<Long>>().apply {
        postValue(Resource.Loading())

        try{
            CoroutineScope(Dispatchers.IO).launch{
                val result = taskDao.insertTask(task)
                postValue(Success(result))
            }
        }catch (e: Exception){
            postValue(Error(e.message.toString()))
        }
    }

    fun deleteTask(task: Task) = MutableLiveData<Resource<Int>>().apply {
        postValue(Resource.Loading())

        try{
            CoroutineScope(Dispatchers.IO).launch{
                val result = taskDao.deleteTask(task)
                postValue(Success(result))
            }
        }catch (e: Exception){
            postValue(Error(e.message.toString()))
        }
    }

    fun deleteTaskUsingId(taskId: String) = MutableLiveData<Resource<Int>>().apply {
        postValue(Resource.Loading())

        try{
            CoroutineScope(Dispatchers.IO).launch{
                val result = taskDao.deleteTaskUsingId(taskId)
                postValue(Success(result))
            }
        }catch (e: Exception){
            postValue(Error(e.message.toString()))
        }
    }

    fun updateTask(task: Task) = MutableLiveData<Resource<Int>>().apply {
        postValue(Resource.Loading())

        try{
            CoroutineScope(Dispatchers.IO).launch{
                val result = taskDao.updateTask(task)
                postValue(Success(result))
            }
        }catch (e: Exception){
            postValue(Error(e.message.toString()))
        }
    }

    fun updateTaskParticularField(taskId: String,title: String, description: String) = MutableLiveData<Resource<Int>>().apply {
        postValue(Resource.Loading())

        try{
            CoroutineScope(Dispatchers.IO).launch{
                val result = taskDao.updateTaskParticularField(taskId, title, description)
                postValue(Success(result))
            }
        }catch (e: Exception){
            postValue(Error(e.message.toString()))
        }
    }

}