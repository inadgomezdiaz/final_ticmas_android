package com.curso.android.app.trabajo_final_ticmas

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.trabajo_final_ticmas.view.MainViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    var instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheackInitialValue() = runTest {
        val initialValue = viewModel.comparationResult.value?.sonIguales
        assertEquals(initialValue, null)
    }

    @Test
    fun mainViewModel_equailStrings() = runTest {
        val string1 = "hello"
        val string2 = "hello"
        launch {
            viewModel.compareStrings(string1, string2)
        }
        advanceUntilIdle()
        val value = viewModel.comparationResult.value?.sonIguales
        assertEquals(value, true)
    }

    @Test
    fun mainViewModel_notEqualStrings() = runTest {

        val string1 = "hello"
        val string2 = "hell"
        launch {
            viewModel.compareStrings(string1, string2)
        }
        advanceUntilIdle()
        val value = viewModel.comparationResult.value?.sonIguales

        assertEquals(value, false)
    }


}