//GameControler.java
package sieteymedia

import recursos.Baraja
import recursos.Carta

class SieteYMedia {
    var baraja: Baraja
    var cartasJugador: Array<Carta?>
    var cartasBanca: Array<Carta?>

    init {
        baraja = Baraja()
        baraja.barajar()
        cartasJugador = arrayOfNulls(15)
        cartasBanca = arrayOfNulls(15)
    }

    fun valorCartas(cartas: Array<Carta?>): Double {
        var total = 0.0
        var `val`: Int
        var i = 0
        var aux:Double
        while (cartas[i] != null) {
            `val` = cartas[i]!!.numero
            if (`val` > 7) aux=0.5 else aux= `val`.toDouble()
            total += aux
            i++
        }
        return total
    }

    fun insertarCartaEnArray(cartas: Array<Carta?>, c: Carta?) {
        var i = 0
        while (cartas[i] != null) {
            i++
        }
        cartas[i] = c
    }

    fun turnoJugador() {
        val c = baraja.darCartas(1)[0]!!
        insertarCartaEnArray(cartasJugador, c)
    }

    fun turnoBanca() {
        while (valorCartas(cartasBanca) < valorCartas(cartasJugador)) {
            val c = baraja.darCartas(1)[0]!!
            insertarCartaEnArray(cartasBanca, c)
        }
    }
}