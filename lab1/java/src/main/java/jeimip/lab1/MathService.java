package jeimip.lab1;

public class MathService {
    private static final double Gamma = 0.5772156649;

    private static double _calculateSeriesProductNaive(int n) {
        double product = 1.0;
        for (int i = 1; i <= n; i++) {
            product *= (1.0 + 1.0 / i);
        }
        return product;
    }

    private static double _calculateSeriesProductNaiveApproximation(int n) {
        return n + Math.log(n) + Gamma + 1.0 / (2 * n) - 1.0 / (12 * n * n);
    }

    public static double CalculateSeriesProduct(int n) {
        return n + 1;
    }
}
