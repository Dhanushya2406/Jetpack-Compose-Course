package com.dhanu.trailproject.memoryleaks

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.dhanu.trailproject.ui.theme.TrailProjectTheme


class SecondActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailProjectTheme {
                GlbButton()
            }
        }
//        MainActivity1.context = this
    }
}

@Composable
fun GlbButton(){

    val context = LocalContext.current

    Column(Modifier.fillMaxSize()) {
        Button(onClick = {
           val intent = Intent(context, MainActivity1::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "Checking Button")
        }
    }
}