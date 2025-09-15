package com.dhanu.trailproject.trailapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dhanu.trailproject.ui.theme.TrailProjectTheme

class AnotherApiUsingKtor : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailProjectTheme {
                SecondApiCall()
            }
        }
    }
}

@Composable
fun SecondApiCall(){
    Column {
        DetailsUI()
    }
}


@Composable
fun DetailsUI(){

    var details by remember {
        mutableStateOf(emptyList<Details>())
    }

    LaunchedEffect(Unit){
        details = SecondApiClient.getDetails()
    }

        Column {
            LazyColumn{
                items(details){det ->
                    DetailsItem(details = det)
                }
            }
        }
}


@Composable
fun DetailsItem(details: Details){
    Card(
        Modifier.fillMaxWidth().padding(10.dp)){
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)) {

            Row {
                Text(text = "Name: ", fontWeight = FontWeight.Bold)
                Text(text = details.name)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(text = "Email: ", fontWeight = FontWeight.Bold)
                Text(text = details.email)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(text = "Body: ", fontWeight = FontWeight.Bold)
                Text(text = details.body)
            }


        }
    }
}