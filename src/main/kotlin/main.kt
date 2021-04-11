import kotlinx.coroutines.*

fun main() {

    val lista1 = listOf<Int>(1, 2, 3, 4, 5, 6)
    val lista2 = listOf<Int>(1, 2, 3, 4, 5, 6)

    var totalJ1 = 0
    var totalJ2 = 0

    runBlocking {
        this.launch {
            repeat(10) {
                println("\nTirada ${it + 1} de J1, ha sacado: ${lista1.random()}")
                delay(1000)
                totalJ1 += lista1.random()
            }
            println("\nJ1 ha terminado")
        }

        this.launch {
            repeat(10) {
                println("\nTirada ${it + 1} de J2, ha sacado: ${lista2.random()}")
                delay(1500)
                totalJ2 += lista2.random()
            }
            println("\nJ2 ha terminado")
        }
    }

    println("\nJ1 ha sacado $totalJ1 en total")
    println("J2 ha sacado $totalJ2 en total")

    if (totalJ1 > totalJ2) println("\nJ1 ha sacado el numero más alto") else println("\nJ2 ha sacado el numero más alto")
}
