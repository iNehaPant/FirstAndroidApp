package com.example.oop

import android.util.Log

class Car {

    var carName: String = ""

   fun start() {
       Log.i("My tag", "Car is starting at with car Name $carName")
   }
}