/**
 * Created by Nikita on 26.02.15.
 */
public class GoldenMiddle {
    private double epsilon;
    private double delta;
    private double initialX;
    private double finalX;
    private double a;
    private double b;

    public GoldenMiddle(double initialX, double finalX, double epsilon, double delta, double a, double b) {
        setInitialX(initialX);
        setFinalX(finalX);
        setEpsilon(epsilon);
        setDelta(delta);
        setA(a);
        setB(b);
    }

    public void methodForExp() {
        double leftBracket = initialX;
        double rightBracket = finalX;
        double epsilonStep = finalX - initialX;
        int i = 0;
        while(epsilonStep >= epsilon) {
            double xLeft = leftBracket + ((3 - Math.sqrt(5)) / 2) * (rightBracket - leftBracket);
            double xRight = leftBracket + ((Math.sqrt(5) - 1) / 2) * (rightBracket - leftBracket);
            if ((a / Math.exp(xLeft)) + b * xLeft <= (a / Math.exp(xRight)) + b * xRight) {
                rightBracket = xRight;
            } else {
                leftBracket = xLeft;
            }
            System.out.println("leftBracket = " + leftBracket + " rightBracket = " + rightBracket + " epsilon = "
                    + epsilonStep + " xRight = " + (leftBracket + ((Math.sqrt(5) - 1) / 2) * (rightBracket - leftBracket))
                    + " xLeft = " + (leftBracket + ((3 - Math.sqrt(5)) / 2) * (rightBracket - leftBracket))
                    + " leftValue = " + ((a / Math.exp(xLeft)) + b * xLeft)
                    + " rightValue = " + ((a / Math.exp(xRight)) + b * xRight));
            i++;
            epsilonStep = Math.pow((Math.sqrt(5) - 1) / 2, i) * (rightBracket - leftBracket);
        }
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public double getInitialX() {
        return initialX;
    }

    public void setInitialX(double initialX) {
        this.initialX = initialX;
    }

    public double getFinalX() {
        return finalX;
    }

    public void setFinalX(double finalX) {
        this.finalX = finalX;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }
}
