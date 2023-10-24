package com.example.tiptime

class Circle(var firstName: String, var lastName: String) {
    var fullName:String = ""
        get() = "$firstName $lastName"
        set(value) {
            val components = value.split(" ")
            firstName = components[0]
            lastName = components[1]
            field = value
        }
}
fun main(){
    var a = Circle("a", "b")
    a.fullName = "Hello World"
    println(a.firstName)
}

