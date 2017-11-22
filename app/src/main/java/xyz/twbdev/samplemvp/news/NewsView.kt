package xyz.twbdev.samplemvp.news


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_news.*

import xyz.twbdev.samplemvp.R


class NewsView : Fragment(), INews.INewsView {

    private val presenter: NewsPresenter = NewsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_news, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()

        presenter.getAllData()
    }

    private fun initListener() {
        refreshLayout?.setOnRefreshListener {
            presenter.getAllData()
        }
    }

    override fun showLoading() {
        refreshLayout?.isRefreshing = true
    }

    override fun hideLoading() {
        refreshLayout?.isRefreshing = false
    }

    override fun showData(msg: String) {
        tvTitle?.text = msg
    }

    companion object {

        fun newInstance(): NewsView {
            val fragment = NewsView()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
