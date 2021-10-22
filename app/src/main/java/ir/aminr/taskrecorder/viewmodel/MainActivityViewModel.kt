package ir.aminr.taskrecorder.viewmodel

import android.app.Application
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.aminr.taskrecorder.repository.TaskRepository
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel
@Inject
constructor(
    private val taskRepository: TaskRepository,
    application: Application
): AndroidViewModel(application) {
}