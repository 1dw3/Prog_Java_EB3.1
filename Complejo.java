package evaluacion3;

import java.io.Serializable;

public class Complejo implements Comparable<Complejo>, Serializable{

	private static final long	serialVersionUID	= -111203257934114735L;
	private double real;
	private double imaginaria;
	
	// constructor por defecto
	Complejo(){
		real = 0.0;
		imaginaria = 0.0;
	}
	
	// constructor con valores
	Complejo (double r, double i){
		 real = r;
		 imaginaria = i;
	}
	
	// constructor copia
	Complejo (Complejo c){
		 real = c.real;
		 imaginaria = c. imaginaria;
	}

	// Setters and Getters
	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(double imaginaria) {
		this.imaginaria = imaginaria;
	}
	
	// toString
	@Override
	public String toString() {
		return (real + " + " + imaginaria + "i");
	}

	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imaginaria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)	// si es el mismo objeto
			return true;	 
		if (obj == null)	// si el objeto es nulo
			return false;
		if (getClass() != obj.getClass()) // si los objetos no son de la misma clase
			return false;
		Complejo other = (Complejo) obj; // creo un objeto temporal
		if (Double.doubleToLongBits(imaginaria) != Double.doubleToLongBits(other.imaginaria)) // comparo el primer campo
			return false;
		if (Double.doubleToLongBits(real) != Double.doubleToLongBits(other.real)) // comparo el segundo campo
			return false;
		return true;
	}

	// compareTo
	@Override
	public int compareTo(Complejo c1) {
		//Complejo c1 = (Complejo) obj; // creo un objeto temporal	
		if(real > c1.real){
			return 1;
		}
		else if(real < c1.real){
			return -1;
		}
		else {
			if (imaginaria > c1.imaginaria){
				return 1;
			}
			else if(imaginaria < c1.imaginaria){
				return -1;
			}
			else {
				return 0;
			}
		}
	}

	
}
