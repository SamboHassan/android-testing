package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import org.hamcrest.core.Is.`is`
import org.junit.Before

//import org.hamcrest.CoreMatchers.not
//import org.hamcrest.CoreMatchers.nullValue
//import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config



@Config(manifest=Config.NONE)
@RunWith(AndroidJUnit4::class)
class TasksViewModelTest{
    //In this step you add a view model test to test that when you call
    // the addNewTask method, the Event for opening the new task window is fired.

    // Subject under test
    private lateinit var tasksViewModel: TasksViewModel

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule();

    @Before
    fun setupViewModel() {
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun addNewTask_setsNewTaskEvent(){
        // Given a fresh TasksViewModel

        // When adding a new task
        tasksViewModel.addNewTask()

        // Then the new task event is triggered
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
        //val value = tasksViewModel.newTaskEvent.awaitNextValue()

        assertThat(
                value?.getContentIfNotHandled(), (not(nullValue()))
        )
    }

    @Test
    fun setFilterAllTasks_tasksAddViewVisible() {


        // When the filter type is ALL_TASKS
        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)

        // Then the "Add task" action is visible
        //assertThat(tasksViewModel.tasksAddViewVisible.awaitNextValue(), `is`(true))

        assertThat(tasksViewModel.tasksAddViewVisible.getOrAwaitValue(), `is`(true))

        /*// Given a fresh ViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
        // When the filter type is ALL_TASKS
        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)
        // Then the "Add task" action is visible
        assertThat(tasksViewModel.tasksAddViewVisible.getOrAwaitValue(),`is` (true))*/
    }
}