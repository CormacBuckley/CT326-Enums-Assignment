public class Test {

	public static void main(String args[]) {
		int x = 3, i;

		for (i = 0; i < Ball.Balls.values().length; i++) {
			System.out.println(Ball.Balls.values()[i] + ": " + Ball.Balls.values()[i].weight + "g "
					+ Ball.Balls.values()[i].diameter + "mm");
		}

		System.out.println("\nCircumference of " + Ball.Balls.values()[x] + " "
				+ Ball.getCircumference(Ball.Balls.values()[x].diameter));
		System.out.println(
				"Volume of " + Ball.Balls.values()[x] + " " + Ball.getVolume(Ball.Balls.values()[x].diameter) + " ");

		Rational r1, r2, r3, r4, r5;

		r1 = new Rational(Ball.Balls.BASEBALL.weight, Ball.Balls.BASKETBALL.weight);
		r2 = new Rational(Ball.Balls.FOOTBALL.weight, Ball.Balls.GOLF.weight);
		r3 = new Rational(Ball.Balls.POOL.diameter, Ball.Balls.SOFTBALL.diameter);
		r4 = new Rational(Ball.Balls.TENNIS.diameter, Ball.Balls.VOLLEYBALL.diameter);
		r5 = new Rational(15, 40);
		
		System.out.println("\n");
		System.out.println(r5.divide(null));//Dividing 15/40 by passing null into divide method
		System.out.println(r1.plus(r2));
		System.out.println(r2.minus(r3));
		System.out.println(r3.multiply(r4));
		System.out.println(r4.divide(r1));

	}
}
