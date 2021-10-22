package ir.aminr.taskrecorder.db.dao

import androidx.room.*
import ir.aminr.taskrecorder.model.OfflineTask

@Dao
interface TaskDao {

    @Insert
    fun saveTask(task: OfflineTask):Int

    @Delete
    fun deleteTask(task: OfflineTask)

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    fun getTask(taskId: Int)

    @Query("SELECT * FROM tasks")
    fun getTasks()

    @Update
    fun updateTask(task: OfflineTask):Int
}