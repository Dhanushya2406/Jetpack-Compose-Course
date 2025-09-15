package com.dhanu.trailproject.memoryleaks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dhanu.trailproject.ui.theme.TrailProjectTheme

class MainActivity1: ComponentActivity() {

    private val listener = Listener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailProjectTheme {
                GlobalApp()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        GlobalSingleton.register(listener)
    }

    override fun onStop() {
        super.onStop()
//        GlobalSingleton.unregister(listener)
    }

    private inner class Listener: GlobalSingleton.GlobalSingletonListener {
        override fun onEvent() {
            TODO("Not yet implemented")
        }

    }

}


@Composable
fun GlobalApp(){
    Column(Modifier
        .fillMaxSize()) {
        Text(text = "This Activity leaks..")
    }
}

/*class MainActivity1: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Intent(this,SecondActivity::class.java).also {
            startActivity(it)
        }
    }

    companion object{
        lateinit var context: Context
    }
}*/


