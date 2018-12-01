package implementation;

import java.util.ArrayList;

public class RedNeuronal {
	
	private double[][] X;
	private double[] Y;
	//Arreglo para el numero de neuronas de cada capa oculta.
	private int[] tamCapasOcultas;
	
	private ArrayList<Capa> capas;
	
	public RedNeuronal(double[][] X, double[] Y, int[] tamCapasOcultas) {
		this.X = X;
		this.Y = Y;
		this.tamCapasOcultas = tamCapasOcultas;
		
		this.capas = new ArrayList<Capa>();
	}
	
	private void inicializarRed() {
		//Primera capa
		capas.add(new Capa(X.length, tamCapasOcultas[0]));		
		
		//capas ocultas		
		for(int i = 1; i < tamCapasOcultas.length; i++) {
			
		}
		
		//Capa de salida
	}
	
	
	
	
	
	
	
	
}
