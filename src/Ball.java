import java.util.Calendar;
import java.util.Date;

public class Ball {

	public enum Balls {
		BASEBALL(149, 73), BASKETBALL(624, 239), FOOTBALL(450, 216), GOLF(46, 43), POOL(156, 60), SOFTBALL(180,
				97), TENNIS(59, 64), VOLLEYBALL(260, 218);

		protected int weight, diameter;

		protected Calendar date;
		Balls(int w, int d) {
			this.weight = w;
			this.diameter = d;
		}
	}

	public static double getCircumference(int diam) {
		double cir;
		double rad = diam / 2;

		cir = 2 * Math.PI * rad;

		return cir;

	}

	public static double getVolume(int diam) {
		double vol;
		double rad = 36.5;

		double rad3 = (rad) * (rad) * (rad);
		vol = ((double) 4 / 3 * Math.PI) * rad3;

		return vol;

	}
}
