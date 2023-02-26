package com.example.aleatorizadoreventos10

import android.content.Context
import android.widget.Toast

class objetoMochila {

}
class Articulo (private var id:String, private var peso:Int, private var valor:Int, private var vida:Int){

    fun getPeso():Int{
        return peso
    }
    fun getValor():Int{
        return valor
    }
    fun getId():String{
        return id
    }
    fun getVida():Int{
        return vida
    }
    override fun toString(): String {
        return "[ID:$id, Peso:$peso, Valor:$valor, Vida:$vida]"
    }
}
class Mochila(private var pesoMochila: Int) {
    private var contenido=ArrayList<Articulo>()
    var monedero = HashMap<Int, Int>()

    init {
        monedero.put(1, 0)
        monedero.put(5, 0)
        monedero.put(10, 0)
        monedero.put(25, 0)
        monedero.put(100, 2)
    }

    fun getPesoMochila():Int{
        return pesoMochila
    }
    fun addArticulo(articulo:Articulo, context: Context) {
        var dinero = 0

        for ((valor,cantidad) in monedero){
            dinero += cantidad * valor
        }


            if (articulo.getPeso()<=pesoMochila){
                contenido.add(articulo)
                this.pesoMochila-=articulo.getPeso()
                cashConverter(articulo)
                return Toast.makeText(context.applicationContext,"Objeto recogido", Toast.LENGTH_SHORT).show()
            }else{
                return Toast.makeText(context.applicationContext,"Mochila llena", Toast.LENGTH_SHORT).show()
            }


        println("Peso restante de la Mochila: "+pesoMochila)

    }
    fun comprarArticulo(articulo:Articulo, context: Context) {
        var dinero = 0

        for ((valor,cantidad) in monedero){
            dinero += cantidad * valor
        }


        if (articulo.getPeso()<=pesoMochila){
            if (articulo.getValor() <= dinero){
                contenido.add(articulo)
                this.pesoMochila-=articulo.getPeso()
                cashConverter2(articulo)
                return Toast.makeText(context.applicationContext,"Objeto recogido", Toast.LENGTH_SHORT).show()
            }else{
                return Toast.makeText(context.applicationContext,"Eres demasiado pobre", Toast.LENGTH_SHORT).show()
            }
        }else{
            return Toast.makeText(context.applicationContext,"Mochila llena", Toast.LENGTH_SHORT).show()
        }


        println("Peso restante de la Mochila: "+pesoMochila)

    }
    fun vender(articulo: Articulo, context: Context) {
        var id: String
        var posicion: Int
            if(this.getContenido().size!=0){
                println("Tienes ${this.getContenido().size} objetos")
                this.getContenido().forEach { println(it) }
                posicion=this.findObjeto(articulo.getId())
                if(posicion!=-1){
                    cashConverter(this.getContenido()[posicion])
                    this.getContenido().remove(this.getContenido()[posicion])
                }
                Toast.makeText(context.applicationContext,"Se ha vendido bien", Toast.LENGTH_SHORT).show()
            }else return Toast.makeText(context.applicationContext,"No tienes objetos para vender", Toast.LENGTH_SHORT).show()

            println("Te quedan ${this.getContenido().size} objetos")
    }
    fun cashConverter(articulo: Articulo){
        var total = 0
        var i = 0
        var coins = arrayListOf(1, 5, 10, 25, 100)
        coins.sortDescending()

        while(total < articulo.getValor() && i < coins.size) {
            if (total + coins[i] <= articulo.getValor()) {
                total += coins[i]
                monedero[coins[i]] = monedero[coins[i]]!! + 1
            } else
                i++
        }
    }
    fun cashConverter2(articulo: Articulo){
        var total = 0
        var i = 0
        var coins = arrayListOf(1, 5, 10, 25, 100)
        coins.sortDescending()

        while(total < articulo.getValor() && i < coins.size) {
            if (total + coins[i] <= articulo.getValor()) {
                if (monedero[coins[i]]!! > 0) {
                    total += coins[i]
                    monedero[coins[i]] = monedero[coins[i]]!! - 1
                } else {
                    i++
                }
            } else {
                i++
            }
        }
    }
    fun getContenido(): ArrayList<Articulo> {
        return contenido
    }
    fun findObjeto(id: String):Int{
        for((indice,item) in contenido.withIndex()){
            if (item.getId() == id) {
                return indice
            }
        }
        return -1
    }
}