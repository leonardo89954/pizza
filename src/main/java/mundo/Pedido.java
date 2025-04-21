/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author leona
 */
public class Pedido implements Comparable<Pedido>{

	// ----------------------------------
	// Atributos
	// ----------------------------------

	/**
	 * Precio del pedido
	 */
	private double precio;
	
	/**
	 * Autor del pedido
	 */
	private String autorPedido;
	
	/**
	 * Cercania del pedido
	 */
	private int cercania;
	
	// ----------------------------------
	// Constructor
	// ----------------------------------
	public Pedido(String autorPedido, double precio, int cercania) {
        this.autorPedido = autorPedido;
        this.precio = precio;
        this.cercania = cercania;
    }
	/**
	 * Constructor del pedido
	 * TODO Defina el constructor de la clase
	 */
	
	// ----------------------------------
	// Métodos
	// ----------------------------------
	
	/**
	 * Getter del precio del pedido
	 */
	public double getPrecio()
	{
		return precio;
	}
	
	/**
	 * Getter del autor del pedido
	 */
	public String getAutorPedido()
	{
		return autorPedido;
	}
	
	/**
	 * Getter de la cercania del pedido
	 */
	public int getCercania() {
		return cercania;
	}
	
	// TODO 
        @Override
    public int compareTo(Pedido otro) {
        // Comparación por precio para MaxPQ (pedidos recibidos)
        return Double.compare(this.precio, otro.precio);
    }

    @Override
    public String toString() {
        return "Pedido{" + "autor=" + autorPedido + ", precio=" + precio + ", cercania=" + cercania + '}';
    }
}