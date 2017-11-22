package xyz.twbdev.samplemvp.news

/**
 * Created by TWBDEV on 11/22/2017.
 */
interface INews {
    interface INewsView{
        fun showLoading()
        fun hideLoading()
        fun showData(msg: String)
    }

    interface INewsPresenter{
        fun getAllData()
    }
}