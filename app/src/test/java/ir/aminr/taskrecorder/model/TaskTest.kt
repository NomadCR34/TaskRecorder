package ir.aminr.taskrecorder.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TaskTest {

    @Test
    fun testTask() {
        val task = Task(
            "Task 1",
            12345,
            123456
        ).apply {
            id = 1
        }

        assertThat(task.id.compareTo(1) == 0).isTrue()
        assertThat(task.title == "Task 1").isTrue()
        assertThat(task.startDate.compareTo(12345) == 0).isTrue()
        assertThat(task.endDate.compareTo(123456) == 0).isTrue()
    }

    @Test
    fun testOfflineTask() {
        val task = CacheTask(
            "Task 1",
            12345,
            123456
        ).apply {
            id = 1
        }

        assertThat(task.id.compareTo(1) == 0).isTrue()
        assertThat(task.title == "Task 1").isTrue()
        assertThat(task.startDate.compareTo(12345) == 0).isTrue()
        assertThat(task.endDate.compareTo(123456) == 0).isTrue()
    }

}