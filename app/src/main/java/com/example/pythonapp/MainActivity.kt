package com.example.pythonapp

import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }

        val python = Python.getInstance()
        val pyObject = python.getModule("hello")
        val result = pyObject.callAttr("greet", "John")
        val greeting: String? = result?.toString()
        if(greeting!=null)
        Log.e("Test",greeting)
        else
            Log.e("Test", "chal raha hai")
    }
}
