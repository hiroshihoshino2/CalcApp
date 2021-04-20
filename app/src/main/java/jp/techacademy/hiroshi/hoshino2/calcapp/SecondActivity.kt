package jp.techacademy.hiroshi.hoshino2.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val value1 = intent.getDoubleExtra("VALUE1", 0.0)
        val value2 = intent.getDoubleExtra("VALUE2", 0.0)
        val str1 = intent.getStringExtra("STR1")
        val ans = intent.getDoubleExtra("ANS",0.0)

        textView.text = "${value1} ${ str1 } ${value2} の答えは、${ans}です。"
    }
}
