import kotlinx.coroutines.*
import java.util.*

fun main() {

    val min = 1
    val max = 6

    val random = Random()
    var numSacado = 0

    val listaJ1 = mutableListOf<Int>()
    val listaJ2 = mutableListOf<Int>()

    var totalJ1 = 0
    var totalJ2 = 0

    runBlocking {

        this.launch {
            repeat(10) {
                numSacado = random.nextInt(6)+1 //Genera Numeros del 1 al 6
                println("\nTirada ${it + 1} del Jugador 1, ha sacado: $numSacado")
                listaJ1.add(numSacado)
                delay(1000)
                totalJ1 += numSacado
            }
            println("Todos los resultados del Jugador 1 son: $listaJ1")
            println("\nJugador 1 ha terminado")
        }

        this.launch {
            repeat(10) {
                numSacado = (min..max).random() //Genera Numeros del 1 al 6
                println("\nTirada ${it + 1} del Juagador 2, ha sacado: $numSacado")
                listaJ2.add(numSacado)
                delay(1500)
                totalJ2 += numSacado
            }
            println("Todos los resultados del Jugador 2 son: $listaJ2")
            println("\nJugador 2 ha terminado")
        }
    }

    println("\nJugador 1 ha sacado $totalJ1 en total")
    println("Jugador 2 ha sacado $totalJ2 en total")

    if (totalJ1 > totalJ2) println("\nJugador 1 ha sacado el numero más alto") else println("\nJugador 2 ha sacado el numero más alto")

}
