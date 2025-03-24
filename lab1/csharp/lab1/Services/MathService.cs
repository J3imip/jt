namespace lab1.Services;

public static class MathService
{
    private const double Gamma = 0.5772156649;

    // Naive product of the first n terms of the harmonic series
    private static double _calculateSeriesProductNaive(int terms = 10)
    {
        var product = 1.0;

        for (var i = 1; i <= terms; i++) product *= 1.0 + 1.0 / i;

        return product;
    }

    // Asymptotic expansion of the product of the first n terms of the harmonic series
    private static double _calculateSeriesProductNaiveApproximation(int terms = 10)
    {
        return terms + Math.Log(terms) + Gamma + 1.0 / (2 * terms) - 1.0 / (12 * terms * terms);
    }

    // (1 + 1/2) * (1 + 1/3) * (1 + 1/4) * ... * (1 + 1/n) can be simplified to n + 1
    public static double CalculateSeriesProduct(int terms = 10)
    {
        return terms + 1;
    }
}