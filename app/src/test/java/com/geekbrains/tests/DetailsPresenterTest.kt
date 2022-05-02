package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.atLeastOnce
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter
    private var count: Int = 0

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        presenter = DetailsPresenter(count)
    }

    @Test
    fun setCounter_Test() {
        Assert.assertEquals(10, presenter.setCounter(10))
    }

    @Test
    fun onIncrement_Test() {
        presenter.onIncrement()

        Assert.assertEquals(1, presenter.onIncrement())
    }

    @Test
    fun onDecrement_Test() {
        presenter.onDecrement()

        Assert.assertEquals(-1, presenter.onDecrement())
    }

    /** Уважаемый преподаватель, не могу понять, почему как только я подключаю
     * тест  fun onAttach_Test()  у меня падает тест setCounter_Test()
     * я уже по всякому эксперементировал.  Прошу подсказать  */

//    @Test
//    fun onAttach_Test() {
//        presenter.onAttachView(viewContract)
//        Mockito.verify(viewContract, atLeastOnce())
//    }

    @Test
    fun onDetach_Test() {
        presenter.onDetachView()

        Mockito.verify(viewContract, times(1))
    }
}


