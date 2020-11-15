package kr.co.tjoeun.librarypractice_20201115

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.tjoeun.lifecycle_20201114.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvents()
        setValues()
    }


    override fun setupEvents() {

    }

    override fun setValues() {

    }

}