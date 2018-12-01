package implementation;

public class Capa {

	private String tipo;
    private int numNeuronas;
	
	
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
	
	
}
