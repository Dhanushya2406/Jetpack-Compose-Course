package com.dhanu.trailproject

/*
import androidx.activity.ComponentActivity

class ArtSpace : ComponentActivity(){

}*/


fun main(){
    val obj: Any = "Hello"
    val str: String? = obj as String
    val num: Int? = obj as Int

    println("str: $str")
    println("num: $num")
}