package jp.techacademy.hiroshi.hoshino2.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var value1: Double = 0.0
    var value2: Double = 0.0
    var ans: Double = 0.0
    var str1 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondActivity::class.java)

         if(editText1.text.toString() != "" && editText2.text.toString() != "") {
            value1 = editText1.text.toString().toDouble()
            value2 = editText2.text.toString().toDouble()
            // textView3.text = ""

            intent.putExtra("VALUE1", value1)
            intent.putExtra("VALUE2", value2)

            if (v == button4 && value2 == 0.0) {
                val rootLayout: View = findViewById(android.R.id.content)
                val snackbar = Snackbar.make(rootLayout , "ゼロで割ることはできません！", Snackbar.LENGTH_LONG)
                snackbar.show()
            } else {
                when {
                    v == button1 -> {
                        ans = value1 + value2
                        str1 = "+"
                    } // 足し算
                    v == button2 -> {
                        ans = value1 - value2
                        str1 = "-"
                    } // 引き算
                    v == button3 -> {
                        ans = value1 * value2
                        str1 = "×"
                    } // 掛け算
                    v == button4 -> {
                        ans = value1 / value2
                        str1 = "÷"
                    } // 割り算
                    else -> {
                        val rootLayout: View = findViewById(android.R.id.content)
                        val snackbar = Snackbar.make(rootLayout , "申し訳ありません。何らかの異常が発生しました！", Snackbar.LENGTH_LONG)
                        snackbar.show()
                    }
                }
                intent.putExtra("ANS", ans)
                intent.putExtra("STR1", str1)
                startActivity(intent)
            }
        } else {
             val rootLayout: View = findViewById(android.R.id.content)
             val snackbar = Snackbar.make(rootLayout , "数値を入力してください！", Snackbar.LENGTH_LONG)
             snackbar.show()
        }
    }
}
