import java.lang.Double;import java.lang.System;import java.util.List;

/**
 * Created by Nikita on 24.02.15.
 */
public class Dihotomiya {
    private double eps;
    private double initialX;
    private double finalX ;
    private double delta;
    private Polynom polynom;
    private double a;
    private double b;

    Dihotomiya(double initalX, double finalX, double eps, double delta, int degree, List<Double> coefficients) {
        setEps(eps);
        setInitialX(initalX);
        setFinalX(finalX);
        setDelta(delta);
        this.polynom = new Polynom(degree, coefficients);
    }

    Dihotomiya(double initialX, double finalX, double eps, double delta, double a, double b) {
        setEps(eps);
        setDelta(delta);
        setInitialX(initialX);
        setFinalX(finalX);
        setA(a);
        setB(b);
    }

    public double methodForPolynom() {
        double leftBracket = initialX;
        double rightBracket = finalX;
        double epsilonStep = (rightBracket - leftBracket)/2;
        while (epsilonStep > eps) {
            if (polynom.calculate((leftBracket + rightBracket)/2 - delta)
                    <= polynom.calculate((leftBracket + rightBracket)/2 + delta)) {
                rightBracket = (leftBracket + rightBracket)/2 + delta;
            }
            else {
                leftBracket = (leftBracket + rightBracket)/2 - delta;
            }
            System.out.println("leftBracket = " + leftBracket + " rightBracket = " + rightBracket + " epsilon = "
                                + epsilonStep + " xRight = " + ((leftBracket + rightBracket)/2 + delta)
                                + " xLeft = " + ((leftBracket + rightBracket)/2 - delta)
                                + " leftValue = " + (polynom.calculate((leftBracket + rightBracket)/2 - delta))
                                + " rightValue = " + (polynom.calculate((leftBracket + rightBracket)/2 + delta)));
            epsilonStep = (rightBracket - leftBracket)/2;
        }
        return polynom.calculate((leftBracket + rightBracket)/2);
    }



    public double methodForExp() {
        double leftBracket = initialX;
        double rightBracket = finalX;
        double epsilonStep = (rightBracket - leftBracket)/2;
        while (epsilonStep > eps) {
            double deltaMinusX = (leftBracket + rightBracket) / 2 - delta;
            double deltaPlusX = (leftBracket + rightBracket)/2 + delta;
            if ((a/Math.exp(deltaMinusX)) + b * deltaMinusX <= (a/Math.exp(deltaPlusX)) + b * deltaPlusX) {
                rightBracket = deltaPlusX;
            }
            else {
                leftBracket = deltaMinusX;
            }
            System.out.println("leftBracket = " + leftBracket + " rightBracket = " + rightBracket + " epsilon = "
                                + epsilonStep + " xRight = " + (deltaPlusX) + "xLeft = " + (deltaMinusX)
                                + " leftValue = " + ((a/Math.exp(deltaMinusX)) + b * deltaMinusX)
                                + " rightValue = " + ((a/Math.exp(deltaPlusX)) + b * deltaPlusX));
            epsilonStep = (rightBracket - leftBracket)/2;
        }
        return (a/Math.exp((leftBracket + rightBracket)/2)) + b * (leftBracket + rightBracket)/2;
    }

    public void setInitialX(double initialX) {
        this.initialX = initialX;
    }

    public void setFinalX(double finalX) {
        this.finalX = finalX;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }
}
