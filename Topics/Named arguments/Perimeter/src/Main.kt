fun perimeter(
    x1: Double,
    y1: Double,
    x2: Double,
    y2: Double,
    x3: Double,
    y3: Double,
    x4: Double = x1,
    y4: Double = y1
): Double {
    val sideA = Math.hypot(x2 - x1, y2 - y1)
    val sideB = Math.hypot(x3 - x2, y3 - y2)
    val sideC = Math.hypot(x4 - x3, y4 - y3)
    val sideD = Math.hypot(x1 - x4, y1 - y4)
    return sideA + sideB + sideC + sideD
}
