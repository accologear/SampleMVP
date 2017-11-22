package xyz.twbdev.samplemvp.count


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.count_down_fragment.*

import xyz.twbdev.samplemvp.R


class CountDownView : Fragment(), ICountDown.INewsView {

    private val presenter: CountDownPresenter = CountDownPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.count_down_fragment, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()

    }

    private fun initAction() {
        if (presenter.isStarted()) {
            buttonCancel?.isEnabled = true
            buttonStart?.isEnabled = false
        } else {
            buttonCancel?.isEnabled = false
            buttonStart?.isEnabled = true
        }
    }

    private fun initListener() {
        buttonStart?.setOnClickListener {
            presenter.startCountDown()
        }

        buttonCancel?.setOnClickListener {
            presenter.stopCountDown()
        }
    }

    override fun showData(msg: String) {
        tvTitle?.text = msg
    }

    override fun start() {
       initAction()
    }

    override fun finish() {
        initAction()
    }
    companion object {

        fun newInstance(): CountDownView {
            val fragment = CountDownView()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
