package implementation;


public class Cliente {

	public static void main(String[] args) {
		Double[][] x = { { 0.0, 1.0 } };
		Double[] y = { 1.0, 1.0 };

		double[][] x1 = { { 0.0, 1.0 } };

		double[][] e1 = { { 0.0, 0.1 } };

		int[] capasOcultas = { 3, 4, 3 };

		RedNeuronal red = new RedNeuronal(x, y, capasOcultas, 0.01, 0.001);

		red.feedforward(x1);

		for (int i = 0; i < red.getCapas().size(); i++) {
			System.out.println("El tama�o de la cap es"+red.getCapas().size() );

			double[] m = red.getCapas().get(i).getSalidaCapa();

			for (int j = 0; j < m.length; j++) {

				System.out.print(m[j] + "\t");
			}
			System.out.println();

		}

		// Ensayo ciclos cada vez agregandoCapasDeSalida, cu�ndo
		// este el forward se reemplaza agregarCapasSalida
//		red.agregarCapasSalida();
//
//		red.backpropagation();
//
//		System.out.println("Salida: " + red.getCapas().get(red.getCapas().size() - 1).getSalidaCapa()[0]);
//		red.agregarCapasSalida();
//		red.backpropagation();
//
//		System.out.println("Salida: " + red.getCapas().get(red.getCapas().size() - 1).getSalidaCapa()[0]);
//
//		red.agregarCapasSalida();
//
//		red.backpropagation();
//		System.out.println("Salida: " + red.getCapas().get(red.getCapas().size() - 1).getSalidaCapa()[0]);
//		
//		
//
//		RedNeuronal red2 = new RedNeuronal(x, y, capasOcultas,0.01,0.001);
//		
//		//se entrena la red
//		red2.entrenarRed();
//		

	}

}
