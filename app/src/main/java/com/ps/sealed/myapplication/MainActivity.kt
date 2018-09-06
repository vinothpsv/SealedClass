package com.ps.sealed.myapplication

import android.app.Activity
import android.os.Bundle
import android.view.View

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun clickMeFunction(view: View) {
        greetMammal(Mammal.Cat("Hello"))
    }

    sealed class Mammal(val name: String) {
        class Cat(val catName: String) : Mammal(catName)
        class Human(val humanName: String, val job: String) : Mammal(humanName)
    }

    private fun greetMammal(mammal: Mammal): String {
        return when (mammal) {
            is Mammal.Cat -> println(mammal.catName).toString()
            is Mammal.Human -> println(mammal.humanName).toString() + println(mammal.job).toString()
        }
    }
}