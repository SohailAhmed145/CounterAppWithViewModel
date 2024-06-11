package com.example.counterwithviewmapp

import android.icu.number.Precision.increment
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.counterwithviewmapp.ui.theme.CounterWithViewMAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterWithViewMAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)){
                       Column (
                           modifier = Modifier
                               .fillMaxSize(),
                           horizontalAlignment = Alignment.CenterHorizontally,
                           verticalArrangement = Arrangement.Center
                       ){
                           Counter()
                           Spacer(modifier = Modifier.height(20.dp))
                           CounterVModel()
                       }

                    }

                }
            }
        }
    }
}

//Counter without viewModel
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Column {
        Text(text = "This is Counter without viewModel")
        Button(onClick = { count++ }) {
            Text(text = "Click me")
        }
        Text(text = "Counter : $count")
    }

}


//Counter with viewModel
@Composable
fun CounterVModel(model: MyViewModel = viewModel()) {


    Column {
        Text(text = "This is Counter using viewModel")
        Button(onClick = {
            model.increment()
        }) {
            Text(text = "Click me")
        }
        Text(text = "Counter : ${model.count}")
    }

}

