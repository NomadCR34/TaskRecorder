package ir.aminr.taskrecorder.db.mapper

import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import ir.aminr.taskrecorder.model.CacheTask
import ir.aminr.taskrecorder.model.Task
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class CacheTaskMapperTest{

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var offlineManagerTask:OfflineTaskMapper

    @Before
    fun init(){
        hiltRule.inject()
    }

    @Test
    fun testToTaskEntity(){
        val offlineTask = CacheTask(
            "Task 1",
            12345,
            123456
        ).apply {
            id = 1
        }

        val task = offlineManagerTask.toEntity(offlineTask)

        assertThat(task.id.compareTo(offlineTask.id) == 0).isTrue()
        assertThat(task.title == offlineTask.title).isTrue()
        assertThat(task.startDate.compareTo(offlineTask.startDate) == 0).isTrue()
        assertThat(task.endDate.compareTo(offlineTask.endDate) == 0).isTrue()
    }

    @Test
    fun testFromTask(){
        val task = Task(
            "Task 1",
            12345,
            123456
        ).apply {
            id = 1
        }

        val offlineTask = offlineManagerTask.fromEntity(task)

        assertThat(task.id == offlineTask.id).isTrue()
        assertThat(task.title == offlineTask.title).isTrue()
        assertThat(task.startDate.compareTo(offlineTask.startDate) == 0).isTrue()
        assertThat(task.endDate.compareTo(offlineTask.endDate) == 0).isTrue()
    }


}