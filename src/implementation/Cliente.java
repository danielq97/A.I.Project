package implementation;

public class Cliente {

	public static void main(String[] args) {
		/* // XOR:
		double[][] x = { { 0.0, 0.0 },
						{0.0, 1.0},
						{1.0, 0.0},
						{1.0, 1.0}};
		double[] y = { 0.0 , 1.0, 1.0, 0.0};
		*/		
		
		double[][] x = { { 0.0, 0.0 },
				{0.0, 1.0},
				{1.0, 0.0},
				{1.0, 1.0}};
		double[] y = { 0.0 , 0.0, 0.0, 1.0};
		
		int[] capasOcultas = {2,2,2};

		RedNeuronal red = new RedNeuronal(x, y, capasOcultas, 0.001, 100);	
		
		red.entrenarRed();

	}

}
