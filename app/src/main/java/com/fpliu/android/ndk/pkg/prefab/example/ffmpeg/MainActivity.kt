package com.fpliu.android.ndk.pkg.prefab.example.ffmpeg

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    init {
        System.loadLibrary("app")
    }

    private external fun test(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        findViewById<TextView>(R.id.tv).text = if (test() == 1) "success"  else "failed"
    }
}