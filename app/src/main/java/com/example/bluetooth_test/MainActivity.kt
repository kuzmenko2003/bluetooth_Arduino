package com.example.bluetooth_test

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private var btAdapter: BluetoothAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        val btManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        btAdapter = btManager.adapter
        getPairedDevices()
    }
    @SuppressLint("MissingPermission")
    private fun getPairedDevices(){
        val pairedDeveces: Set<BluetoothDevice>? = btAdapter?.bondedDevices
        pairedDeveces?.forEach {
            Log.d("MyLog","Name: ${it.name}");
        }
    }
}