package com.example.iteradmin.broadcastreciever

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.net.ConnectivityManagerCompat

var br : BroadcastReceiver? = null
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         br  = MyBroadCastReciever()

        val intentFilter : IntentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)

        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        registerReceiver(br,intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(br)
    }
}
