package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RedNeuronal {

	// Variables independientes.
	private Double[][] X;
	

	// Variables dependientes u objetivos.
	private Double[] Y;

	

	// Arreglo para el numero de neuronas de cada capa oculta.
	private int[] tamCapasOcultas;

	private ArrayList<Capa> capas;
	
	private double learningRate;
	private double minLearning;



	public RedNeuronal(Double[][] X, Double[] Y, int[] tamCapasOcultas, double learningRate, double minLearning) {
		this.X = X;
		this.Y = Y;
		this.tamCapasOcultas = tamCapasOcultas;
		this.learningRate = learningRate;
		this.learningRate = minLearning;

		this.capas = new ArrayList<Capa>();

		inicializarRed();
		
		 
		for (int i = 0; i < capas.size(); i++) {
			Capa capa = capas.get(i);
			System.out.println(capa.getNeuronasFuente() + "-" + capa.getNeuronasDestino());
		}
	}
	
	//Metodo para entrenar la red.
	public void entrenarRed() {
		boolean keepLearning = true;
		while(keepLearning) {
			//feedforward
			backpropagation();
			double[] erroresUltimaCapa = capas.get(capas.size()-1).getErrores();
			for(int i = 0; i < erroresUltimaCapa.length; i++) {
				if(erroresUltimaCapa[i]<minLearning) {keepLearning=false;}
			}
		}
	}
	
	public void predecir() {
		
	}

	public ArrayList<Capa> getCapas() {
		return capas;
	}

	public void setCapas(ArrayList<Capa> capas) {
		this.capas = capas;
	}

	private void inicializarRed() {
		// Primera capa
		capas.add(new Capa(X.length, tamCapasOcultas[0]));

		System.out.println(X.length);
		// capas ocultas
		for (int i = 1; i < tamCapasOcultas.length; i++) {
			capas.add(new Capa(tamCapasOcultas[i - 1], tamCapasOcultas[i]));
		}

		// Capa de �ltima oculta a neuronas salida
		capas.add(new Capa(tamCapasOcultas[tamCapasOcultas.length - 1], getNumNeuronasSalida()));
		
		
	}

	private int getNumNeuronasSalida() {
		HashSet<Double> hash = new HashSet<Double>();
		ArrayList<Double> aux = new ArrayList<>(Arrays.asList(Y));
		hash.addAll(aux);

		if (hash.size() > 2) {
			return hash.size();
		} else {
			return 1;
		}
	}
	
	//Este m�todo se hizo, s�lo para agregar capas de salida aleatorias
	//pero todo esto lo debe reemplazar la propagaci�n hacia adelante
	public void agregarCapasSalida( ) {
		for (int i = 0; i < capas.size(); i++) {
			int numeroNeuronasDestino = capas.get(i).getNeuronasDestino();
			double [] salidas = new double [numeroNeuronasDestino];
			for (int j = 0; j < salidas.length; j++) {
				salidas[j] = Math.random();
			}
			capas.get(i).setSalidaCapa(salidas);
		}
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * @param x1: matriz que ser� multiplicada por la matriz de pesos indicada
	 */
	
	
	public void feedforward(double [][] x1) {
			
		
		/*salida capa*/
	 double[][] salida= capas.get(0).multiplicacionMtrix(x1, capas.get(0).getPesos());
	 
	 /* 2b*/
	 double[][] c= capas.get(0).Activacion(salida);
	 
	 capas.get(0).setSalidaCapa(c[0]);
	 
	 double[][] example=new double[1][ capas.get(0).getSalidaCapa().length];
	 example[0]=capas.get(0).getSalidaCapa();
	 
	 
	 
	 for ( int i=1; i<capas.size();i++) {
		 
		 double[][] salid1= capas.get(i).multiplicacionMtrix(example, capas.get(i).getPesos());
		 
		 /* 2b*/
		 
		capas.get(i).setSalidaCapa(capas.get(i).Activacion(salid1)[0]) ; 
		
 
	 }
	 
	 
	 
	 
		
	}
	

	public void backpropagation() {

		/**
		 * Para la capa de salida hallo el error
		 */
		// Obtengo el n�mero de salidas de la red (salidas de la capa salida)
		int tama�oSalidas = capas.get(capas.size() - 1).getSalidaCapa().length;
		double[] erroresCapaSalida = new double[tama�oSalidas];
		// Hago un respaldo de los errores de capa salida, porque los necesito
		// a la hroa de cambiar pesos
		double[] respaldoErroresCapaSalida = new double[tama�oSalidas];
		double[] capaDeSalida = capas.get(capas.size() - 1).getSalidaCapa();
		for (int i = 0; i < tama�oSalidas; i++) {
			// Saco el valor de salida de cada neurona
			double error = (Y[i] - capaDeSalida[i]) * capaDeSalida[i] * (1 - capaDeSalida[i]);
			// Lo agrego a los errores
			erroresCapaSalida[i] = error;
			respaldoErroresCapaSalida[i] = error;
		}

		System.out.println("numero capas salida: " + getNumNeuronasSalida());

		// Lo hago ahora para las capas ocultas, creo una lista de arreglos
		// de double para guardar los errores de cada capa
		ArrayList<double[]> erroresCapasOcultas = new ArrayList<>();
		// Inicializo en valores 0 para que me permita despu�s hacer seteo, de las
		// posiciones e insertar inverso
		for (int i = 0; i < (capas.size() - 1); i++) {
			erroresCapasOcultas.add(new double[] { 0.0 });
		}
		// Pongo que recorra las capas ocultas, le resto al tama�o de las capas 2, que
		// son
		// la de entrada y la de salida , empiza desde la �ltima oculta
		for (int i = (capas.size() - 2); i >= 0; i--) {
			// Error de capa espec�fica, obtengo el tama�o de salidas de
			// la capa oculta especifica. Obtengo la capa de salida de la capa actual, y la
			// capa actual
			Capa actual = capas.get(i);
			double[] salidasCapa = capas.get(i).getSalidaCapa();
			double[] errorCapas = new double[capas.get(i).getSalidaCapa().length];
			// Hallo los errores por cada salida de la capa
			for (int j = 0, L= 0; j < actual.getPesos().length && L <salidasCapa.length; j++, L++) {
				// Saco la sumatoria desde K=1 hasta P de Who(j,k) * ERROR DE SALIDAS DE P
				// Pesos a todas las salidas
				double sum = 0;
				double[] pesos = actual.getPesos()[j];
				// Multiplico las parejas
				for (int k = 0; k < pesos.length; k++) {
					for (int k2 = 0; k2 < erroresCapaSalida.length; k2++) {
						sum += pesos[k] * erroresCapaSalida[k2];
					}		
					
				}
				double error = salidasCapa[L] * (1 - salidasCapa[L]) * sum;
				errorCapas[j] = error;

			}
			// Agrego los errores de cada capa a La lista de Arreglos
			//i para que inserte d�nde es
			erroresCapasOcultas.set(i, errorCapas);
			// Actualizo los errores de la capa de salida, que ya van a ser los nuevos,
			// porque
			// voy a analizar una capa m�s atr�s
			erroresCapaSalida = errorCapas;
		}

		// Ahora la segunda fase del BackPropagation, calcular los nuevos pesos
		// De la capa de salida nunca se analiza los pesos.
		// Para la �ltima capa oculta y de salida, empiezo a modificar los pesos de
		// atr�s para adelante
		// ac� estoy modificando matriz Who:
		Capa ultimaOculta = capas.get(capas.size() - 1);
		double[] salidasCapa = ultimaOculta.getSalidaCapa();
		double pesosSalida[][] = ultimaOculta.getPesos();
		
		for (int j = 0; j < pesosSalida.length; j++) {
			for (int k = 0; k < pesosSalida[j].length; k++) {
				pesosSalida[j][k] = pesosSalida[j][k]
						+ learningRate * salidasCapa[k] * respaldoErroresCapaSalida[k];
			}
		}
		// Modifico la matriz de pesos
		ultimaOculta.setPesos(pesosSalida);

		// Ahora cambio desde la pen�ltima capa oculta, a la de entrada.
		// Empiezo cambiando Whh, y al final Weh
		for (int i = (capas.size() - 2); i >= 0; i--) {

			Capa actual = capas.get(i);
			double[] salidasCapa1 = actual.getSalidaCapa();
			double pesosSalida1[][] = actual.getPesos();
			// Modifico todos los pesos
			// Uso alfa igual a 0,25 , pero se puede poner parametrizable la tasa de
			// aprendizaje
			// La primera vez modifica la matriz Who , y despu�s modifica matriz Whh, hasta
			// llegar a Weh

			double[] erroresCapa = erroresCapasOcultas.get(i);
			for (int j = 0; j < pesosSalida1.length; j++) {
				

				for (int k = 0; k < pesosSalida1[j].length; k++) {
					pesosSalida1[j][k] = pesosSalida1[j][k] + learningRate * salidasCapa1[k] * erroresCapa[k];
				}
			}
			// Modifico la matriz de pesos
			actual.setPesos(pesosSalida1);

		}
	}

}
