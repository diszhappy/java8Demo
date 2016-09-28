package in.diszhappy.test;

import in.diszhappy.iface.MyInterface;

/**
 * 
 * @author Saumm Friday 16 09 2016
 *
 *
 */
public class DemoMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		checkFeaturesOfLambda();

	}
	
	private static void checkFeaturesOfLambda() {
		/**
		 * The below myInterface reference will hold one object of MyInterface
		 * and the abstract method getSqure is overridden by the lambda
		 * expression.
		 */
		MyInterface myInterface = (number) -> number * number;
		System.out.println(myInterface.getSquare(12398));
	}

}
