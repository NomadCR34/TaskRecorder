package ir.aminr.taskrecorder.db.mapper

import ir.aminr.taskrecorder.model.Task
import ir.aminr.taskrecorder.model.OfflineTask
import ir.aminr.taskrecorder.util.Mapper

class TaskOfflineMapper : Mapper<OfflineTask, Task> {

    override fun toEntity(offlineTask: OfflineTask): Task {
        return Task(
            offlineTask.title,
            offlineTask.startDate,
            offlineTask.endDate
        ).apply {
            id = offlineTask.id
        }
    }

    override fun fromEntity(task: Task): OfflineTask {
        return OfflineTask(
            task.title,
            task.startDate,
            task.endDate
        ).apply {
            id = task.id
        }
    }

    fun toEntityList(offlineTasks: List<OfflineTask>): List<Task> =
        offlineTasks.map { toEntity(it) }
}