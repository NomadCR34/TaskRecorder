package ir.aminr.taskrecorder.repository

import ir.aminr.taskrecorder.db.dao.TaskDao
import ir.aminr.taskrecorder.db.mapper.OfflineTaskMapper
import ir.aminr.taskrecorder.model.Task
import ir.aminr.taskrecorder.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TaskRepository
@Inject constructor(
    private val taskDao: TaskDao,
    private val offlineTaskMapper: OfflineTaskMapper
) {

    fun saveTask(task: Task): Flow<DataState<Long>> = flow {
        emit(DataState.Loading)
        val id = taskDao.saveTask(
            offlineTaskMapper.fromEntity(task = task)
        )
        emit(DataState.Success(id))
    }

    fun updateTask(task: Task): Flow<DataState<Unit>> = flow {
        emit(DataState.Loading)
        taskDao.updateTask(
            offlineTaskMapper.fromEntity(task = task)
        )
        emit(DataState.Success(Unit))
    }

    fun deleteTask(task: Task): Flow<DataState<Unit>> = flow {
        emit(DataState.Loading)
        taskDao.deleteTask(
            offlineTaskMapper.fromEntity(task = task)
        )
        emit(DataState.Success(Unit))
    }

    fun getTask(taskId: Long): Flow<DataState<Task>> = flow {
        emit(DataState.Loading)
        val task = offlineTaskMapper.toEntity(
            taskDao.getTask(taskId = taskId)
        )
        emit(DataState.Success(task))
    }

    fun getTasks(): Flow<DataState<List<Task>>> = flow {
        emit(DataState.Loading)
        val tasks = offlineTaskMapper.toEntityList(
            taskDao.getTasks()
        )
        emit(DataState.Success(tasks))
    }


}