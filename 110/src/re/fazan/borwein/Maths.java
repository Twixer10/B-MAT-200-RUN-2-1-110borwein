package re.fazan.borwein;

public class Maths {
	
	protected static double compute(int n, double value) {
		int i = 0;
		double res = 1;
		
		while (i <= n) {
			if (value != 0)
				res *= Math.sin(value / ((2 * i) + 1)) / (value / ((2 * i) + 1));
			i++;
		}
		return(res);
	}
	
	protected static void midpoint(int n) {
		int i = 0;
		double res = 0.0;
		double h = 5000.0 / 10000.0;
		
		while (i < 10000) {
			res += compute(n, (0.25 + i * h));
			i++;
		}
		res *= h;
		System.out.printf("Midpoint:\nI%d = %.10f\ndiff = %.10f\n\n", n, res, Math.abs((res - (Math.PI / 2))));
	}
	
	protected static void trapezoidal(int n) {
		int i = 1;
		double res = 0.0;
		double h = 5000.0 / 10000.0;
		
		while (i < 10000) {
			res += compute(n, i * h);
			i++;
		}
		res = 0.25 * (compute(n, 0) + compute(n, 5000) + 2 * res);
		System.out.printf("Trapezoidal:\nI%d = %.10f\ndiff = %.10f\n\n", n, res, Math.abs((res - (Math.PI / 2))));
	}
	
	protected static void simpson(int n) {
		int i = 1;
		double res = 0.0;
		double tmp1 = 0.0;
		double tmp2 = 0.0;
		double h = 5000.0 / 10000.0;
		
		while (i < 10000) {
			tmp1 += compute(n, i * h);
			i++;
		}
		i = 0;
		while (i < 10000) {
			tmp2 += compute(n, (i * h + (h * 0.5)));
			i++;
		}
		res = 5000.0 / 60000.0 * (compute(n, 0) + compute(n, 5000) + 2 * tmp1 + 4 * tmp2);
		System.out.printf("Simpson:\nI%d = %.10f\ndiff = %.10f\n", n, res, Math.abs((res - (Math.PI / 2))));
	}
}
