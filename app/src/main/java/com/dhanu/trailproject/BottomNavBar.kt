package com.dhanu.trailproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dhanu.trailproject.ui.theme.TrailProjectTheme

class BottomNavBar : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailProjectTheme {
                mainBottomBar()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun mainBottomBar(){

    var onSelectItem by remember {
        mutableStateOf(0)
    }
    Scaffold(bottomBar = { myBottomBar(onSelectItem) { onSelectItem = it } }) { o->
        when(onSelectItem){
            0 -> TabOne()
            1 -> TabTwo()
            2 -> TabThree()
        }
    }
}



@Composable
fun myBottomBar(currentIndex: Int, onSelectItem: (Int) -> Unit){
    BottomNavigation {
        BottomNavigationItem(
            selected = currentIndex == 0,
            onClick = { onSelectItem(0) },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home",Modifier.padding(bottom = 10.dp, top = 10.dp)) },
            label = { labelText(text = "Home")}
        )

        BottomNavigationItem(
            selected = currentIndex == 1,
            onClick = { onSelectItem(1) },
            icon = { Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings",Modifier.padding(bottom = 10.dp, top = 10.dp)) },
            label = { labelText(text = "Settings")}
        )

        BottomNavigationItem(
            selected = currentIndex == 2,
            onClick = { onSelectItem(2) },
            icon = { Icon(imageVector = Icons.Filled.Call, contentDescription = "Call",Modifier.padding(bottom = 10.dp, top = 10.dp)) },
            label = { labelText(text = "Call")}
        )
    }

}

@Composable
fun labelText(text: String){
    Text(text = text,Modifier.padding(top = 20.dp, bottom = 10.dp))
}


@Composable
fun TabOne(){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Tab One", fontSize = 24.sp)
    }
}


@Composable
fun TabTwo(){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Tab Two", fontSize = 24.sp)
    }
}


@Composable
fun TabThree(){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Tab Three", fontSize = 24.sp)
    }
}

