package com.depi.battaryalarm

import android.app.Application
import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BatteryViewModel(application: Application): AndroidViewModel(application){
    private var _batteryLevel = MutableStateFlow(100)
    private var _islowbattery = MutableStateFlow(false)
    private var _isExtralowbattery = MutableStateFlow(false)
    val batteryLevel :StateFlow<Int>get() = _batteryLevel
    val islowbattery :StateFlow<Boolean>get() = _islowbattery
    val batteryReceiver:BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context,intent: Intent){
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            val batteryPct = level * 100 / scale

            viewModelScope.launch {
                _batteryLevel.value=batteryPct
                _islowbattery.value=batteryPct<20
                if (_islowbattery.value){
                    NotificationUtils.showBatteryLowNotification(context, batteryPct)
                }
            }

        }
    }
    init {
        // Register the receiver to listen for battery changes
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        getApplication<Application>().registerReceiver(batteryReceiver, filter)
    }

    override fun onCleared() {
        super.onCleared()
        getApplication<Application>().unregisterReceiver(batteryReceiver)
    }

}