package implementation;





public class Cliente {

	public static void main(String[] args) {
		Double[][] x = { { 0.0, 1.0 }, { 1.0, 0.0 } };
		Double[] y = { 1.0, 1.0 };

		int[] capasOcultas = { 3, 4, 3 };

		RedNeuronal red = new RedNeuronal(x, y, capasOcultas,0.01,0.001);

		
		

		//Ensayo ciclos cada vez agregandoCapasDeSalida, cuándo
		//este el forward se reemplaza agregarCapasSalida
		red.agregarCapasSalida();

		red.backpropagation();

		System.out.println("Salida: " + red.getCapas().get(red.getCapas().size() - 1).getSalidaCapa()[0]);
		red.agregarCapasSalida();
		red.backpropagation();

		System.out.println("Salida: " + red.getCapas().get(red.getCapas().size() - 1).getSalidaCapa()[0]);

		red.agregarCapasSalida();

		red.backpropagation();
		System.out.println("Salida: " + red.getCapas().get(red.getCapas().size() - 1).getSalidaCapa()[0]);
		
		

		RedNeuronal red2 = new RedNeuronal(x, y, capasOcultas,0.01,0.001);
		
		//se entrena la red
		red2.entrenarRed();
		
		

	}

}
