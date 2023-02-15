fun main() {
    alertWeather("Ankara", 27, 31, 82)
    alertWeather("Tokyo", 32, 36, 10)
    alertWeather("Cape Town", 59, 64, 2)
    alertWeather("Guatemala City", 50, 55, 7)
}

fun alertWeather(city: String, lowTemperature: Int, highTemperature: Int, chanceOfRain: Int) {
    println("City: $city")
    println("Low temperature: $lowTemperature, High temperature: $highTemperature")
    println("Chance of rain: $chanceOfRain%")
    println()
}