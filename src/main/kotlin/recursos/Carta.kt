//Carta.java
package recursos

class Carta(palo: Palo, numero: Int) {
    private val palo: Palo
    val numero: Int

    init {
        this.palo = palo
        this.numero = numero
    }

    fun getPalo(): String {
        return palo.toString()
    }

    override fun toString(): String {
        return "($palo, $numero)"
    }
}