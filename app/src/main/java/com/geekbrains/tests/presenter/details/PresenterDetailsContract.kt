package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.presenter.PresenterContract

internal interface PresenterDetailsContract : PresenterContract {
    fun setCounter(count: Int):Int
    fun onIncrement():Int
    fun onDecrement():Int
}
