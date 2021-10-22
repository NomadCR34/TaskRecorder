package ir.aminr.taskrecorder.repository

import ir.aminr.taskrecorder.db.dao.TaskDao
import ir.aminr.taskrecorder.db.mapper.TaskOfflineMapper
import ir.aminr.taskrecorder.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TaskRepository
@Inject constructor(
    private val taskDao: TaskDao,
    private val taskOfflineMapper: TaskOfflineMapper
) {

    fun saveTask(task: Task): Flow<Int> = flow{
        taskDao.saveTask(
            taskOfflineMapper.fromEntity(task = task)
        )
    }

    fun updateTask(task: Task):Flow<Int> = flow {

    }

}