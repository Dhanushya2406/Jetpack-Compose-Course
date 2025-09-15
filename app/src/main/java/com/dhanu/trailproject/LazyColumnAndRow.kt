package com.dhanu.trailproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dhanu.trailproject.ui.theme.TrailProjectTheme

// This file is based on Recyclerview in XML but in Compose we use LazyColumn and LazyRow
// We can load data using list and Data class in ArrayList
class LazyColumnAndRow : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    createUI()
                }
            }
        }
    }
}

data class User(val testOne: String, val testTwo: String)



@Preview(showBackground = true)
@Composable
fun createUI() {


    val modelArray: ArrayList<User> = ArrayList()

    repeat(30){
        modelArray.add(User("Dhanu","Abi"))
    }



    LazyColumn(Modifier.fillMaxWidth()) {

        items(modelArray){test ->
            Card(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(12.dp)
            ) {
                Text(
                    text = "${test.testOne} ${test.testTwo}",
                    Modifier.fillMaxWidth(),
                    style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center)
                )
            }

        }


        /*
        // This method is load data using list.
        val simpleList = listOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "End")

        items(simpleList.size) { index ->
            Card(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(12.dp)
            ) {
                Text(
                    text = simpleList[index],
                    Modifier.fillMaxWidth(),
                    style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center)
                )
            }

        }
        */
    }
}