package implementation;

import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

public class Cliente {

	public static void main(String[] args) {
		Double[][] x = { { 0.0, 1.0 }, { 1.0, 0.0 } };
		Double[] y = { 1.0, 1.0 };

		int[] capasOcultas = { 3, 4, 3 };

		RedNeuronal red = new RedNeuronal(x, y, capasOcultas);

		
		
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
		
		

	}

}
