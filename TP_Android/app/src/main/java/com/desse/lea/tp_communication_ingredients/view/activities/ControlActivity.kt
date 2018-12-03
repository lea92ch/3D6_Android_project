package com.desse.lea.tp_communication_ingredients

import android.app.ProgressDialog
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.desse.lea.tp_communication_ingredients.view.activities.data.dao.AppDatabase
import kotlinx.android.synthetic.main.activity_control.*
import java.io.IOException
import java.util.*

class ControlActivity: AppCompatActivity() {

    companion object {
        //var m_myUUID: UUID = UUID.fromString("A8:F2:74:EB:B3:4D")
        var m_bluetoothSocket: BluetoothSocket? = null
        //lateinit var m_progress: ProgressDialog
        //lateinit var m_bluetoothAdapter: BluetoothAdapter
        var m_isConnected: Boolean = false
        //lateinit var m_address: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)
        my_ingredients.setOnClickListener{getbasket()}
        disconnect.setOnClickListener{disconnect()}
    }


    private lateinit var mlistview: ListView
    var mDb: AppDatabase? = null

    private fun getbasket() {
        setContentView(R.layout.activity_basketblue)

        mDb = AppDatabase.getInMemoryDatabase(application)
        val ingres = mDb?.ingredientModel()?.loadAllIngredients()

        mlistview = findViewById<ListView>(R.id.list_item2)


        val list = arrayOfNulls<String>(ingres?.size!!)


        for (i in 0 until ingres.size) {
            val ingre = ingres[i]
            list[i] = ingre.mName
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        mlistview.adapter = adapter
    }

    private fun disconnect() {
        if (m_bluetoothSocket != null) {
            try{
                m_bluetoothSocket!!.close()
                m_bluetoothSocket = null
                m_isConnected = false
            }catch(e: IOException) {
                e.printStackTrace()
            }
        }
        finish()
    }

/*
    companion object {
        var m_myUUID: UUID = UUID.fromString("A8:F2:74:EB:B3:4D")
        var m_bluetoothSocket: BluetoothSocket? = null
        lateinit var m_progress: ProgressDialog
        lateinit var m_bluetoothAdapter: BluetoothAdapter
        var m_isConnected: Boolean = false
        lateinit var m_address: String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)
        //m_address = intent.getStringExtra(SelectDeviceActivity.EXTRA_ACCESS)

        ConnectToDevice(this).execute()

        friends_ingredients.setOnClickListener{sendCommand("fi")}
        my_ingredients.setOnClickListener{sendCommand("mi")}
        shared_ingredients.setOnClickListener{sendCommand("si")}
        disconnect.setOnClickListener{disconnect()}
    }


    private fun sendCommand(input: String){
        if (m_bluetoothSocket != null) {
            try{
                m_bluetoothSocket!!.outputStream.write(input.toByteArray())
            }catch(e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun disconnect() {
        if (m_bluetoothSocket != null) {
            try{
                m_bluetoothSocket!!.close()
                m_bluetoothSocket = null
                m_isConnected = false
            }catch(e: IOException) {
                e.printStackTrace()
            }
        }
        finish()
    }

    private class ConnectToDevice(c: Context) : AsyncTask<Void, Void, String>() {
        private var connectSuccess: Boolean = true
        private val context: Context

        init {
            this.context = c
        }

        override fun onPreExecute() {
            super.onPreExecute()
            m_progress = ProgressDialog.show(context, "Connecting ...", "please wait ...")
        }

        override fun doInBackground(vararg p0: Void?): String? {
            try {
                if (m_bluetoothSocket == null || !m_isConnected){
                            m_bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
                            val device: BluetoothDevice = m_bluetoothAdapter.getRemoteDevice(m_address)
                            m_bluetoothSocket = device.createInsecureRfcommSocketToServiceRecord(m_myUUID)
                            BluetoothAdapter.getDefaultAdapter().cancelDiscovery()
                            m_bluetoothSocket!!.connect()
                }
            }catch(e: IOException) {
                connectSuccess = false
                e.printStackTrace()
            }
            return null
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (!connectSuccess) {
                Log.i("data", "couldn't connect")
            } else {
                m_isConnected = true
            }
            m_progress.dismiss()
        }
    }
    */
}