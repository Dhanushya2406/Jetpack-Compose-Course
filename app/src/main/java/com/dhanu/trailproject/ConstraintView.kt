package com.dhanu.trailproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.dhanu.trailproject.ui.theme.TrailProjectTheme

class ConstraintView : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintPreview()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintPreview(){

    val context = LocalContext.current

ConstraintLayout(
    Modifier
        .fillMaxSize()
        .background(Color.White)) {
    
    val (one, two, three, four, five) = createRefs()

    createVerticalChain(one,two,three,four,five, chainStyle = ChainStyle.Packed)

    Button(onClick = {
        val intent = Intent(context,MainActivity::class.java)
        context.startActivity(intent)
    }, Modifier.constrainAs(one){
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }, shape = RoundedCornerShape(16.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Gray) ) {
        Text(text = "Article Button")
    }

    Button(onClick = {
        val intent = Intent(context,LazyColumnAndRow::class.java)
        context.startActivity(intent)
    }, Modifier.constrainAs(two){
        top.linkTo(one.bottom)
        start.linkTo(one.start)
        end.linkTo(one.end)
    },shape = RoundedCornerShape(16.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
        Text(text = "LazyColumn and Row Button")
    }

    Button(onClick = {
        val intent = Intent(context,Quadrant::class.java)
        context.startActivity(intent)
    }, Modifier.constrainAs(three){
        top.linkTo(two.bottom)
        start.linkTo(two.start)
        end.linkTo(two.end)
    },shape = RoundedCornerShape(16.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
        Text(text = "Quadrant Button")
    }

    Button(onClick = {
        val intent = Intent(context,TaskCompleted::class.java)
        context.startActivity(intent)
    }, Modifier.constrainAs(four){
        top.linkTo(three.bottom)
        start.linkTo(three.start)
        end.linkTo(three.end)
    },shape = RoundedCornerShape(16.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
        Text(text = "Task Completed Button")
    }

    Button(onClick = {
        val intent = Intent(context,Trail::class.java)
        context.startActivity(intent)
    }, Modifier.constrainAs(five){
        top.linkTo(four.bottom)
        start.linkTo(four.start)
        end.linkTo(four.end)
    },shape = RoundedCornerShape(16.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
        Text(text = "Trail Button")
    }
}
}