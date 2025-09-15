package com.dhanu.trailproject.trailapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dhanu.trailproject.ui.theme.TrailProjectTheme

class UsingKtor : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailProjectTheme {
                AppView()
            }
        }

    }
}

@Composable
fun AppView(){
    Column {
        PostList()
    }
}


@Composable
fun PostList(){

    var posts by remember {
        mutableStateOf(emptyList<Post>())
    }
    
    LaunchedEffect(Unit){
        posts = ApiClient.getPost()
    }

    Column {
        LazyColumn{
            items(posts){post ->
                PostListItem(post = post)
            }
        }
    }

}


@Composable
fun PostListItem(post: Post){
    Card(Modifier.fillMaxWidth().padding(10.dp)) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)) {

            Text(text = post.title, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = post.body, fontSize = 14.sp)

        }
    }

}