package com.dhanu.trailproject.oldmethodusingretrofit

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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dhanu.trailproject.ui.theme.TrailProjectTheme

class UsingRetrofit : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailProjectTheme {
                OldMethodFetching()
            }
        }
    }
}


@Composable
fun OldMethodFetching(){
    val viewModel: DetailsViewModel = viewModel()
    Column {
        OldMethodDetailsUI(viewModel)
    }
}

@Composable
fun OldMethodDetailsUI(viewModel: DetailsViewModel) {

    LaunchedEffect(Unit){
        viewModel.fetchDetails()
    }

    Column {
        LazyColumn{
            items(viewModel.details){det ->
                OldMDetailsItem(oldMDetails = det)
            }
        }
    }
}


@Composable
fun OldMDetailsItem(oldMDetails: OldMDetails){
    Card(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)){
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)) {

            Row {
                Text(text = "Name: ", fontWeight = FontWeight.Bold)
                Text(text = oldMDetails.name)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(text = "Email: ", fontWeight = FontWeight.Bold)
                Text(text = oldMDetails.email)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                Text(text = "Body: ", fontWeight = FontWeight.Bold)
                Text(text = oldMDetails.body)
            }


        }
    }


}

