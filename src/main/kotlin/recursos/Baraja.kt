//Baraja.java
package recursos

import java.util.*

class Baraja {
    //baraja española de 40 cartas. No hay 8 y 9.
    private val NUM_CARTAS = 40
    private val cartas: Array<Carta?> = arrayOfNulls<Carta>(NUM_CARTAS)
    var primeraMazo = 0 //el indice de la primera carta sin dar. A las cartas sin dar le llamo mazo.

    init {
//crea una baraja ordenada por palos y números
        var ultimaCarta = 0
        for (p in Palo.values()) {
            for (j in 0..11) {
                if (j == 7 || j == 8) {
                    continue
                }
                cartas[ultimaCarta] = Carta(p, j + 1)
                ultimaCarta++
            }
        }
    }

    fun barajar() {
//baraja el mazo, es decir, la cartas sin dar
        val r = Random()
        for (i in primeraMazo until cartas.size) {
            val posicionAzar = r.nextInt(cartas.size - primeraMazo) + primeraMazo
            val temp: Carta? = cartas[i]
            cartas[i] = cartas[posicionAzar]
            cartas[posicionAzar] = temp
        }
    }

    fun darCartas(numCartasDar: Int): Array<Carta?> {
//coge cartas del mazo para dar
//si no hay suficientes cartas o el mazo está vacío se devuelve array vacio
        val cartasParaDar: Array<Carta?>
        val cartasEnMazo = cartas.size - primeraMazo
        if (cartasEnMazo < numCartasDar) {
            cartasParaDar = arrayOfNulls<Carta>(0)
        } else {
            cartasParaDar = arrayOfNulls<Carta>(numCartasDar)
            var i = 0
            while (i < cartasParaDar.size) {
                cartasParaDar[i] = cartas[i + primeraMazo]
                i++
            }
            primeraMazo = i + primeraMazo
        }
        return cartasParaDar
    }
}