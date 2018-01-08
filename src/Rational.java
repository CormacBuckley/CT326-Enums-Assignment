import java.text.DecimalFormat;
import java.util.List;

public class Rational {

	protected List<Rational> r;
	private double result;
	private double p, q, simpleP, simpleQ, rP, rQ;
	private String simple,simple2,op;
	private static DecimalFormat df2 = new DecimalFormat(".##");
	//Restricting output to 2 decimal places
	
	//operator "op" is determined dynamically depending on which method is called

	public Rational(double weight, double diam) {
		this.p = weight;
		this.q = diam;
		//simplifying number as soon as it is instantiated for ease later on
		this.simple = (simplify(p, q));
	}

	public String multiply(Rational r) {
		// This if statement allows for numbers to be added together
		// without needing to pass in another rational number.
		// This is used in all methods below.
		if (r == null) {
			this.result = p * q;
		}
		this.op = " * ";
		this.rP = r.p;
		this.rQ = r.q;
		this.simple2 = (simplify(r.p, r.q));

		simpleP = this.p * r.p;
		simpleQ = this.q * r.q;
		this.simple = (simplify(simpleP, simpleQ));
		this.result = simpleP / simpleQ;
		return toString();

	}

	public String divide(Rational r) {

		if (r == null) {
			this.result = p / q;
		} else {
			double a, b;
			a = r.p;
			b = r.q;
			double temp = r.p;
			r.p = r.q;
			r.q = temp;
			// Creating new rational number out of inverted fraction
			// and passing it to the multiply method
			Rational r1 = new Rational(r.p, r.q);
			multiply(r1);
			this.op = " / ";
			// Reverting fraction to orignal orientation
			// for accuracy of print out.
			this.rP = a;
			this.rQ = b;
		}
		return toString();

	}

	public String plus(Rational r) {

		if (r == null) {
			this.result = p + q;
		}
		this.op = " + ";
		this.simple2 = (simplify(r.p, r.q));
		this.rP = r.p;
		this.rQ = r.q;
		double multi, multir;
		double denom = lcd(q, r.q);

		multi = denom / q;
		multir = denom / r.q;

		this.simple = simplify(((multi * p) + (multir * r.p)), denom);

		this.result = ((multi * p) + (multir * r.p)) / denom;
		return toString();

	}

	public String minus(Rational r) {

		if (r == null) {
			this.result = p - q;
		}

		this.result = p - q;
		this.simple2 = (simplify(r.p, r.q));
		this.rP = r.p;
		this.rQ = r.q;
		this.op = " - ";

		double multi, multir;
		double denom = lcd(q, r.q);

		multi = denom / q;
		multir = denom / r.q;

		this.simple = simplify(((multi * p) - (multir * r.p)), denom);

		this.result = ((multi * p) - (multir * r.p)) / denom;

		return toString();

	}

	public double gcm(double p, double q) {
		return q == 0 ? p : gcm(q, p % q);
	}

	private double lcd(double denom1, double denom2) {
		double factor = denom1;
		while ((denom1 % denom2) != 0)
			denom1 += factor;
		return denom1;
	}

	public String simplify(double p, double q) {
		double gcm = gcm(p, q);
		return (p / gcm) + "/" + (q / gcm);
	}

	public String toString() {
		//Allowing for use of single Rational object operations.
		//Used in 15/40 calculation
		if (simple2 != null) {
			return "(" + p + "/" + q + ")" + op + "(" + rP + "/" + rQ + ")" + " = " + simple + " = "
					+ df2.format(result);
		} else {
			return p + "/" + q + " = " + simple + " = " + result;
		}
	}

}