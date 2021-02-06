package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
//import junit.framework.Assert.assertEquals
//import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test


//class StatisticsUtilsTest : TestCase(){
class StatisticsUtilsTest{

//    You're going to write a test that checks:
//    if there are no completed tasks and one active task,
//    that the percentage of active tests is 100%,
//    and the percentage of completed tasks is 0%

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero(){
        // Create an active task
        val tasks = listOf<Task>(
                Task("title", "description", isCompleted = false)
        )

        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        //REPLACE
//        assertEquals(result.completedTasksPercent, 0f)
//        assertEquals(result.activeTasksPercent, 100f)

        // WITH
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }



    /*Instead of starting by fixing the bug, you'll start by writing the tests first.
    Then you can confirm that you have tests protecting you from ever accidentally
    reintroducing these bugs in the future.

    1.If there is an empty list (emptyList()), then both percentages should be 0f.
    2.If there was an error loading the tasks, the list will be null, and both percentages should be 0f.
    3.Run your tests and confirm that they fail:*/

    //getActiveAndCompletedStats_noActive_returnsZeroHundred
    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
        val tasks = listOf(
                Task("title", "desc", isCompleted = true)
        )
        // When the list of tasks is computed with a completed task
        val result = getActiveAndCompletedStats(tasks)

        // Then the percentages are 0 and 100
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }


    //getActiveAndCompletedStats_both_returnsFortySixty
    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        // Given 3 completed tasks and 2 active tasks
        val tasks = listOf(
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false)
        )
        // When the list of tasks is computed
        val result = getActiveAndCompletedStats(tasks)

        // Then the result is 40-60
        assertThat(result.activeTasksPercent, `is`(40f))
        assertThat(result.completedTasksPercent, `is`(60f))
    }


    //getActiveAndCompletedStats_error_returnsZeros
    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        // When there's an error loading stats
        val result = getActiveAndCompletedStats(null)

        // Both active and completed tasks are 0
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }


    //getActiveAndCompletedStats_empty_returnsZeros
    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {
        // When there are no tasks
        val result = getActiveAndCompletedStats(emptyList())

        // Both active and completed tasks are 0
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }
}