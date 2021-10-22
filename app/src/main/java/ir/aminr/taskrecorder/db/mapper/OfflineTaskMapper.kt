package ir.aminr.taskrecorder.db.mapper

import ir.aminr.taskrecorder.model.Task
import ir.aminr.taskrecorder.model.CacheTask
import ir.aminr.taskrecorder.util.Mapper

class OfflineTaskMapper : Mapper<CacheTask, Task> {

    override fun toEntity(cacheTask: CacheTask): Task {
        return Task(
            cacheTask.title,
            cacheTask.startDate,
            cacheTask.endDate
        ).apply {
            id = cacheTask.id
        }
    }

    override fun fromEntity(task: Task): CacheTask {
        return CacheTask(
            task.title,
            task.startDate,
            task.endDate
        ).apply {
            id = task.id
        }
    }

    fun toEntityList(cacheTasks: List<CacheTask>): List<Task> =
        cacheTasks.map { toEntity(it) }
}