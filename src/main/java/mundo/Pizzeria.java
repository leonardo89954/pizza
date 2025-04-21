/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.util.ArrayList;
import estructuras.IHeap;
import estructuras.MaxPQ;
import estructuras.MinPQ;



public class Pizzeria 
{	
	// ----------------------------------
    // Constantes
    // ----------------------------------
	
	/**
	 * Constante que define la accion de recibir un pedido
	 */
	public final static String RECIBIR_PEDIDO = "RECIBIR";
	/**
	 * Constante que define la accion de atender un pedido
	 */
	public final static String ATENDER_PEDIDO = "ATENDER";
	/**
	 * Constante que define la accion de despachar un pedido
	 */
	public final static String DESPACHAR_PEDIDO = "DESPACHAR";
	/**
	 * Constante que define la accion de finalizar la secuencia de acciones
	 */
	public final static String FIN = "FIN";
	
	// ----------------------------------
    // Atributos
    // ----------------------------------
	
	/**
	 * Heap que almacena los pedidos recibidos
	 */
	// TODO 
	/**
	 * Getter de pedidos recibidos
	 */
	// TODO 
 	/** 
	 * Cola de elementos por despachar
	 */
	// TODO 
	/**
	 * Getter de elementos por despachar
	 */
	// TODO 
	 private IHeap<Pedido> colaPedidosRecibidos;
         private IHeap<Pedido> colaDespachos;
         
	// ----------------------------------
    // Constructor
    // ----------------------------------

	/**
	 * Constructor de la case Pizzeria
	 */
	public Pizzeria()
	{
             colaPedidosRecibidos = new MaxPQ<>();
             colaDespachos = new MinPQ<>();
		// TODO 
	}
	
	// ----------------------------------
    // Métodos
    // ----------------------------------
	
	/**
	 * Agrega un pedido a la cola de prioridad de pedidos recibidos
	 * @param nombreAutor nombre del autor del pedido
	 * @param precio precio del pedido 
	 * @param cercania cercania del autor del pedido 
	 */
	public void agregarPedido(String nombreAutor, double precio, int cercania)
	{if (precio < 0) {
        throw new IllegalArgumentException("El precio no puede ser negativo");
    }
    if (cercania < 1 || cercania > 10) {
        throw new IllegalArgumentException("La cercanía debe estar entre 1 y 10");
    }

    Pedido nuevoPedido = new Pedido(nombreAutor, precio, cercania);
    colaPedidosRecibidos.add(nuevoPedido);
    System.out.println(RECIBIR_PEDIDO + ": " + nuevoPedido);
		// TODO 
	}
	
	// Atender al pedido más importante de la cola
	
	/**
	 * Retorna el proximo pedido en la cola de prioridad o null si no existe.
	 * @return p El pedido proximo en la cola de prioridad
	 */
	public Pedido atenderPedido()
	{if (!colaPedidosRecibidos.isEmpty()) {
            // Retirar el pedido con el precio más alto (máximo)
            Pedido pedidoAtendido = colaPedidosRecibidos.poll();
            // Agregar el pedido a la cola de despachos (por cercanía)
            colaDespachos.add(pedidoAtendido);
            return pedidoAtendido;
        }
		return  null;
	}

	/**
	 * Despacha al pedido proximo a ser despachado. 
	 * @return Pedido proximo pedido a despachar
	 */
	public Pedido despacharPedido()
	{if (!colaDespachos.isEmpty()) {
            // Retirar el pedido con la cercanía más baja (mínimo)
            return colaDespachos.poll();
        }
	    return  null;
	}
	
	/**
	 * Retorna la cola de prioridad de pedidos recibidos como una lista. 
	 * @return list lista de pedidos recibidos.
	 */
	 public ArrayList<Pedido> pedidosRecibidosList()
	 {    
             ArrayList<Pedido> lista = new ArrayList<>();
        for (Pedido p : colaPedidosRecibidos) {
            lista.add(p);
        }
        return lista;
	 }
	 
	 /**
	  * Retorna la cola de prioridad de despachos como una lista. 
	  * @return list cola de prioridad de despachos.
	  */
	 public ArrayList<Pedido> colaDespachosList()
	 {    ArrayList<Pedido> lista = new ArrayList<>();
        for (Pedido p : colaDespachos) {
            lista.add(p);
        }
        return lista;
    
	 }
}
