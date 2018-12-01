package implementation;

public class Cliente {

	public static void main(String[] args) {
		Double[][] x = {{0.0,1.0},{1.0,0.0}};
		Double[] y = {0.0,1.0};
		
		int[] capasOcultas = {3,4,3};
		
		RedNeuronal red = new RedNeuronal(x, y, capasOcultas);

	}

}
