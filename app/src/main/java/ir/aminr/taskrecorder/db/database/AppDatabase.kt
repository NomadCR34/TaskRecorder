package ir.aminr.taskrecorder.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.aminr.taskrecorder.db.dao.TaskDao
import ir.aminr.taskrecorder.model.CacheTask

@Database(
    entities = [
        CacheTask::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTaskDao():TaskDao

    companion object{
        const val databaseName = "APP_DATABASE"
    }
}