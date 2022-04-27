package com.geekbrains.tests.presenter

import android.view.View
import com.geekbrains.tests.view.ViewContract

internal interface PresenterContract {
    fun attachView(view: ViewContract)
    fun detachView()
}
