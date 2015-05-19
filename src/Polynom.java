import java.lang.Double;import java.lang.Math;import java.util.List;

/**
 * Created by Nikita on 24.02.15.
 */
public class Polynom {
    int degree;
    List<Double> coefficients;

    Polynom(int degree, List<Double> coefficients) {
        setDegree(degree);
        setCoefficients(coefficients);
    }

    public double calculate(double x) {
        double result = 0;
        for (int i = 0; i <= degree; i++){
            result = result + (Math.pow(x,i)) * coefficients.get(i);
        }
        return result;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setCoefficients(List<Double> coefficients) {
        this.coefficients = coefficients;
    }
}
