package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Ensayo<T> extends ArrayList<T>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		ArrayList<Double []> en = new ArrayList<>();
		
		
		
		
	   //lleno para que me deje modificar
		
		for (int i = 0; i < 10; i++) {
			en.add( new Double [] {0.5,0.4});
		}
		
		
		
          en.set(3, new Double [] {0.6,0.7});
		
          en.set(7, new Double [] {0.6,0.8});
		
				
	}

}
