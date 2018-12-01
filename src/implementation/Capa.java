package implementation;

public class Capa {

	private String tipo;
    private int neuronasFuente;
    private int neuronasDestino;
    
    private double[][] capa;
    
    private double[] salidaCapa;
    
    public Capa(int neuronasFuente, int neuronasDestino) {
    	this.neuronasFuente = neuronasFuente;
    	this.neuronasDestino = neuronasDestino;
    	
    	generarMatriz();
    }
    
    private void generarMatriz() {
    	capa = new double[neuronasFuente][neuronasDestino];
    	
    	for(int i = 0; i < neuronasFuente;i++) {
    		for(int j = 0; j< neuronasDestino; j ++) {
    			capa[i][j] = Math.random();
    		}
    	}
    }
    
    public int getNeuronasFuente() {
		return neuronasFuente;
	}

	public void setNeuronasFuente(int neuronasFuente) {
		this.neuronasFuente = neuronasFuente;
	}

	public int getNeuronasDestino() {
		return neuronasDestino;
	}

	public void setNeuronasDestino(int neuronasDestino) {
		this.neuronasDestino = neuronasDestino;
	}

	public double[][] getCapa() {
		return capa;
	}

	public void setCapa(double[][] capa) {
		this.capa = capa;
	}

	public double[] getSalidaCapa() {
		return salidaCapa;
	}

	public void setSalidaCapa(double[] salidaCapa) {
		this.salidaCapa = salidaCapa;
	}

	
	
	
	public final static String entrada = "ENTRADA";
	public final static String oculta = "OCULTA";
	public final static String salida = "SALIDA";

	public Capa(String tipo, int numNeuronas) {
		// TODO Auto-generated constructor stub
		if (tipo.equals(entrada))
			tipo = entrada;
		else if (tipo.equals(oculta))
			tipo = oculta;
		else
			tipo = salida;

	}

	
	
	public boolean esCapaEntrada() {
		return tipo.equals(entrada);
	}
	/*
	 * Método a usar para verificar si es capa oculta, de la cuál sus
	 * neuronas se les va a calcular el error (BackPropagation)
	 */
	public boolean esCapaOcultada() {
		return tipo.equals(oculta);
	}
	/*
	 * Método a usar para verificar si es capa salida, de la cuál sus
	 * neuronas se les va a calcular el error (BackPropagation)
	 */
	public boolean esCapaSalida() {
		return tipo.equals(salida);
	}
	

	
	/* 
	 * Este método se encarga de  multipplicar las matrices 
	 * recibidas por parametro 
	 * 
	 */
	public double[][] multiplicacionMtrix(double[][]a, double[][]b) {
		
		double [][] VectorSalida= new double[a.length][b[0].length];
		//* es necesario verificar que las matrices se pueden multiplicar
		
		if(a[0].length== b.length ) {
			
			for(int i=0; i< a.length; i++) {
				for(int j=0; j< b[0].length; j++) {
					for(int k=0; k<a[0].length; k++) {
						/* aqui se multiplica la matriz*/
						VectorSalida[i][j]+= a[i][k]* b[k][j];
					}
				}
			}
		}
		
		
		/* si la condición no se cumple la matriz se retorna vacia*/
		return VectorSalida;
	}
	
	
	
	public double[][] Activacion(double[][] matrix){
		
		/*
		 * matriz de salida de neuronas ocultas
		 */
		double[][]sno= new double[matrix.length][ matrix[0].length];

		
		for(int i=0; i< matrix.length; i++) {
			
			for (int j=0; j< matrix[0].length; j++) {
				
				sno[i][j]=  1 / (1 + Math.pow(Math.E, -(matrix[i][j]))); 
				
				
				
			}
		}
		
		

		return sno;
		
	}
	
	
	
	
	
 

	
	
	
	
	
}
