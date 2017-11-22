package xyz.twbdev.samplemvp.count

/**
 * Created by TWBDEV on 11/22/2017.
 */
interface ICountDown {
    interface INewsView {
        fun showData(msg: String)
        fun start()
        fun finish()
    }

    interface INewsPresenter {
        fun startCountDown()
        fun stopCountDown()
        fun isStarted(): Boolean
    }
}