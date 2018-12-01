package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RedNeuronal {
	
	//Variables independientes.
	private Double[][] X;
	
	//Variables dependientes u objetivos.
	private Double[] Y;
	
	//Arreglo para el numero de neuronas de cada capa oculta.
	private int[] tamCapasOcultas;
	
	private ArrayList<Capa> capas;
	
	public RedNeuronal(Double[][] X, Double[] Y, int[] tamCapasOcultas) {
		this.X = X;
		this.Y = Y;
		this.tamCapasOcultas = tamCapasOcultas;
		
		this.capas = new ArrayList<Capa>();
		
		inicializarRed();
		for(int i = 0; i < capas.size();i++) {
			Capa capa = capas.get(i);
			System.out.println(capa.getNeuronasFuente()+"-"+capa.getNeuronasDestino());
		}
	}
	
	private void inicializarRed() {
		//Primera capa
		capas.add(new Capa(X.length, tamCapasOcultas[0]));		
		
		//capas ocultas		
		for(int i = 1; i < tamCapasOcultas.length; i++) {
			capas.add(new Capa(tamCapasOcultas[i-1], tamCapasOcultas[i]));			
		}
		
		//Capa de salida
		capas.add(new Capa(tamCapasOcultas[tamCapasOcultas.length-1], getNumNeuronasSalida()));
	}
	
	private int getNumNeuronasSalida() {
		HashSet<Double> hash = new HashSet<Double>();
		ArrayList<Double> aux = new ArrayList<Double>(Arrays.asList(Y));
		hash.addAll(aux);
		
		if(hash.size()>2) {return hash.size();}
		else {return 1;}
	}
	
	
	
	
	
	
	
	
}
