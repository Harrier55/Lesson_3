package com.geekbrains.tests.presenter.details

import android.view.View
import com.geekbrains.tests.view.ViewContract
import com.geekbrains.tests.view.details.DetailsActivity
import com.geekbrains.tests.view.details.ViewDetailsContract
import java.util.function.DoubleBinaryOperator

internal open class DetailsPresenter internal constructor(
    private var count: Int = 0
) : PresenterDetailsContract {

    private var viewContract: ViewDetailsContract? = null

    override fun setCounter(count: Int): Int {
        this.count = count
        return count
    }

    override fun onIncrement(): Int {
        val result = count++
        viewContract?.setCount(result)
        return result
    }

    override fun onDecrement(): Int {
        val result = count--
        viewContract?.setCount(result)
        return result
    }

    override fun onAttachView(view: ViewContract) {
        this.viewContract = view as ViewDetailsContract
    }

    override fun onDetachView() {
        viewContract = null
    }
}
