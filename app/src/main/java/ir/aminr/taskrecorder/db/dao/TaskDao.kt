package ir.aminr.taskrecorder.db.dao

import androidx.room.*
import ir.aminr.taskrecorder.model.CacheTask

@Dao
interface TaskDao {

    @Insert
    fun saveTask(task: CacheTask):Long

    @Delete
    fun deleteTask(task: CacheTask)

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    fun getTask(taskId: Long):CacheTask

    @Query("SELECT * FROM tasks")
    fun getTasks():List<CacheTask>

    @Update
    fun updateTask(task: CacheTask):Int
}