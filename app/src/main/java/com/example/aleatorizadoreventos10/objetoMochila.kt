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
class Mochila(private var pesoMochila: Int){
    private var contenido=ArrayList<Articulo>()

    fun getPesoMochila():Int{
        return pesoMochila
    }
    fun addArticulo(articulo:Articulo, context: Context) {
        if (articulo.getPeso()<=pesoMochila){
            contenido.add(articulo)
            this.pesoMochila-=articulo.getPeso()
            return Toast.makeText(context.applicationContext,"Objeto recogido", Toast.LENGTH_SHORT).show()
        }else{
            return Toast.makeText(context.applicationContext,"Mochila llena", Toast.LENGTH_SHORT).show()
        }
        println("Peso restante de la Mochila: "+pesoMochila)

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