package xyz.twbdev.samplemvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import xyz.twbdev.samplemvp.news.NewsView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(R.id.content_container, NewsView.newInstance())
                .commit()
    }
}
