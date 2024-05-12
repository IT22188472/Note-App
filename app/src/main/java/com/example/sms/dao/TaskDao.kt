package com.example.sms.dao

import android.adservices.adid.AdId
import androidx.room.*
import com.example.sms.models.Task
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {

    @Query("SELECT * FROM Task ORDER BY date DESC")
    fun getTaskList() : Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task):Long

    @Delete
    suspend fun deleteTask(task : Task) :Int


    @Query("DELETE FROM Task WHERE taskId == :taskId")
    suspend fun deleteTaskUsingId(taskId: String) : Int

    @Update
    suspend fun updateTask(task: Task):Int

    @Query("UPDATE Task SET taskTitle = :title,description = :description WHERE taskId = :taskId")
    suspend fun updateTaskParticularField(taskId: String,title: String, description: String) : Int
}