package evaluacion3;

import java.io.Serializable;

public class ContadorGenerico<T> implements Serializable{
	
	private static final long serialVersionUID = 4078106165388763136L;
	private T valor;
	private int contador;
	
	// constructor por defecto
	ContadorGenerico(){
		contador = 0;
	}
	
	// costructor atributos
	ContadorGenerico(T v){
		valor = v;
		contador = 0;
	}
	ContadorGenerico(T v, int c){
		valor = v;
		contador = c;
	}
	
	// constructor copia
	ContadorGenerico(ContadorGenerico<T> cg){
		 valor = cg.valor;
		 contador = cg.contador;
	}
	
	// conversion a String para escribir por pantalla
	@Override
	public String toString() {
		return ("Valor: " + valor + " Contador: " + contador);
	}
	
	// Setters and Getters
	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

}
