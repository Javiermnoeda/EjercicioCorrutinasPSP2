import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.random.nextInt

fun main() {

    //Creamos las dos listas

    val lista1 = listOf<Int>(1, 2, 3, 4, 5, 6)
    val lista2 = listOf<Int>(1, 2, 3, 4, 5, 6)

    var x = 0
    var y = 0

    runBlocking {
        this.launch {
            repeat(10) {
                println("\nTirada ${it + 1} de J1, ha sacado: ${lista1.random()}")
                delay(1000)
                x += lista1.random()
            }
            println("\nJ1 ha terminado")
        }


        this.launch {
            repeat(10) {
                println("\nTirada ${it + 1} de J2, ha sacado: ${lista2.random()}")
                delay(1500)
                y += lista2.random()
            }
            println("\nJ2 ha terminado")
        }
    }

    println("\nJ1 ha sacado $x en total")
    println("J2 ha sacado $y en total")

    if (x > y) println("\nJ1 ha sacado el numero más alto") else println("\nJ2 ha sacado el numero más alto")
}
