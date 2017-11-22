package xyz.twbdev.samplemvp.news

import android.os.CountDownTimer

/**
 * Created by TWBDEV on 11/22/2017.
 */
class NewsPresenter(val view: INews.INewsView) : INews.INewsPresenter {

    override fun getAllData() {
        view.showLoading()
        view.showData("start")
        object : CountDownTimer(5000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                view.showData((millisUntilFinished / 1000).toString())
            }

            override fun onFinish() {
                view.hideLoading()
                view.showData("finish")
            }
        }.start()
    }
}