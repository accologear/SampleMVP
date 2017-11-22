package xyz.twbdev.samplemvp.count

import android.os.CountDownTimer

/**
 * Created by TWBDEV on 11/22/2017.
 */
class CountDownPresenter(val view: ICountDown.INewsView) : ICountDown.INewsPresenter {

    var isStart: Boolean = false
    lateinit var timer: CountDownTimer

    init {
        initContDownTimer()
    }

    override fun isStarted(): Boolean = isStart

    override fun startCountDown() {
        isStart = true
        timer.start()
        view.start()
    }

    override fun stopCountDown() {
        isStart = false
        timer.cancel()
        view.finish()
    }

    private fun initContDownTimer() {
        timer = object : CountDownTimer(5000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                view.showData((millisUntilFinished / 1000).toString())
            }

            override fun onFinish() {
                isStart = false
                view.showData("finish")
                view.finish()

            }
        }
    }
}