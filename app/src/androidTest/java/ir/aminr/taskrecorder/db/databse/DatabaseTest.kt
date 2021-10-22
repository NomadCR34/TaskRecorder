package ir.aminr.taskrecorder.db.databse

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import ir.aminr.taskrecorder.db.dao.TaskDao
import ir.aminr.taskrecorder.db.database.AppDatabase
import ir.aminr.taskrecorder.di.DatabaseModel
import ir.aminr.taskrecorder.model.CacheTask
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Singleton

@UninstallModules(DatabaseModel::class)
@HiltAndroidTest
class DatabaseTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Module
    @InstallIn(SingletonComponent::class)
    object DatabaseModule {
        @Provides
        @Singleton
        fun provideDatabase(
        ): AppDatabase {
            val context: Context = ApplicationProvider.getApplicationContext()
            return  Room.inMemoryDatabaseBuilder(
                context,
                AppDatabase::class.java,
            )
                .allowMainThreadQueries()
                .build()
        }

        @Provides
        @Singleton
        fun provideTaskDao(appDatabase: AppDatabase): TaskDao =
            appDatabase.getTaskDao()
    }

    @Inject
    lateinit var taskDao: TaskDao

    @Test
    fun testInsertTask() {
        val offlineTask = CacheTask(
            "Task 1",
            12345,
            123456
        ).apply {
            id = 0
        }
        runBlocking {
            val id = taskDao.saveTask(offlineTask)
            assertThat(id.compareTo(1) == 0).isTrue()
        }

    }

    @Test
    fun testGetTaskByID(){
        val offlineTask = CacheTask(
            "Task 1",
            12345,
            123456
        ).apply {
            id = 0
        }
        runBlocking {
            val id = taskDao.saveTask(offlineTask)
            val task = taskDao.getTask(id)
            assertThat(task.id.compareTo(id) == 0).isTrue()
            assertThat(task.startDate.compareTo(12345) == 0).isTrue()
            assertThat(task.endDate.compareTo(123456) == 0).isTrue()
            assertThat(task.title == "Task 1").isTrue()
        }
    }

    @Test
    fun testUpdateTask(){
        val offlineTask = CacheTask(
            "Task 1",
            12345,
            123456
        ).apply {
            id = 0
        }
        runBlocking {
            val id = taskDao.saveTask(offlineTask)
            offlineTask.apply {
                this.id = id
                this.title = "Updated Title"
            }
            taskDao.updateTask(offlineTask)
            val task = taskDao.getTask(id)
            assertThat(task.id.compareTo(id) == 0).isTrue()
            assertThat(task.startDate.compareTo(12345) == 0).isTrue()
            assertThat(task.endDate.compareTo(123456) == 0).isTrue()
            assertThat(task.title == "Updated Title").isTrue()
        }
    }

    @Test
    fun testGetTasks(){
        val offlineTask = CacheTask(
            "Task 1",
            12345,
            123456
        ).apply {
            id = 0
        }
        runBlocking {
            val id = taskDao.saveTask(offlineTask)
            val task = taskDao.getTasks()
            assertThat(task.size.compareTo(1) == 0).isTrue()
            assertThat(task[0].id.compareTo(id) == 0).isTrue()
            assertThat(task[0].startDate.compareTo(12345) == 0).isTrue()
            assertThat(task[0].endDate.compareTo(123456) == 0).isTrue()
            assertThat(task[0].title == "Task 1").isTrue()
        }
    }

    @Test
    fun testDeleteTask(){
        val offlineTask = CacheTask(
            "Task 1",
            12345,
            123456
        ).apply {
            id = 0
        }
        runBlocking {
            val id = taskDao.saveTask(offlineTask)
            offlineTask.apply {
                this.id = id
            }
            taskDao.deleteTask(offlineTask)
            val task = taskDao.getTasks()
            assertThat(task.size.compareTo(0) == 0).isTrue()
        }
    }


}