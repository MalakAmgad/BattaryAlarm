package com.depi.battaryalarm

import android.os.BatteryManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.depi.battaryalarm.ui.theme.BattaryAlarmTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BattaryAlarmTheme {
                val viewModel: BatteryViewModel = viewModel()
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    BatteryAlarmApp(viewModel)

                }
            }
        }
    }
}

@Composable
fun BatteryAlarmApp( viewModel: BatteryViewModel) {
    val batteryLevel by viewModel.batteryLevel.collectAsState()
    val isLowBattery by viewModel.islowbattery.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Text(text="Battary Level: $batteryLevel%")
        Image(painter = painterResource(id = (if(isLowBattery)R.drawable.battery_low else R.drawable.battery_full))
            , contentDescription ="Battery Status" )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BattaryAlarmTheme {

    }
}