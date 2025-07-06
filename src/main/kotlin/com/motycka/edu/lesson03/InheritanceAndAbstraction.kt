package com.motycka.edu.lesson03

import kotlin.math.PI

interface Shape2D {
    fun area(): Double
    fun perimeter(): Double
}

interface Shape3D {
    fun volume(): Double
    fun surfaceArea(): Double
}

interface Quadrilateral {
    val width: Double
    val length: Double
    fun to3D(depth: Double): Shape3D
}

interface Ellipse {
    val radius: Double
    fun to3D(): Shape3D
}

open class Rectangle(
    override val width: Double,
    override val length: Double
) : Shape2D, Quadrilateral {
    override fun area(): Double = width * length
    override fun perimeter(): Double = 2 * (width + length)
    override fun to3D(depth: Double): Shape3D = Cuboid(width, length, depth)
}

class Square(side: Double) : Rectangle(side, side) {
    fun to3D(): Shape3D = super.to3D(width)
}

class Cuboid(
    val width: Double,
    val length: Double,
    val height: Double
) : Shape3D {
    override fun volume(): Double = width * length * height
    override fun surfaceArea(): Double =
        2 * (width * length + width * height + length * height)
}

class Circle(override val radius: Double) : Shape2D, Ellipse {
    override fun area(): Double = PI * radius * radius
    override fun perimeter(): Double = 2 * PI * radius
    override fun to3D(): Shape3D = Sphere(radius)
}

class Sphere(val radius: Double) : Shape3D {
    override fun volume(): Double = 4.0 / 3.0 * PI * radius * radius * radius
    override fun surfaceArea(): Double = 4.0 * PI * radius * radius
}


fun main() {
    val rectangle = Rectangle(2.0, 3.0)
    println("Rectangle area: ${rectangle.area()}")
    println("Rectangle perimeter: ${rectangle.perimeter()}")

    val square = Square(5.0)
    println("Square area: ${square.area()}")
    println("Square perimeter: ${square.perimeter()}")

    val cube = square.to3D(square.width)
    println("Cube volume: ${cube.volume()}")
    println("Cube surface area: ${cube.surfaceArea()}")

    val cuboid = rectangle.to3D(4.0)
    println("Cuboid volume: ${cuboid.volume()}")
    println("Cuboid surface area: ${cuboid.surfaceArea()}")

    val circle = Circle(4.0)
    println("Circle area: ${circle.area()}")
    println("Circle perimeter: ${circle.perimeter()}")

    val sphere = circle.to3D()
    println("Sphere volume: ${sphere.volume()}")
    println("Sphere surface area: ${sphere.surfaceArea()}")
}