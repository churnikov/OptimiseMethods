import java.awt.geom.Point2D;
import java.util.*;

/**
 * Created by Nikita on 18.05.15.
 */
public class DME {
    private double mirror;
    private double decrease;
    private double increase;
    private Map <MyPoint, Double> pointValue;
    private MyPoint maxX;
    private MyPoint beforeMaxX;
    private MyPoint minX;
    private MyPoint centreOfMass;
    private int numberOfFunction;

    public DME(int numberOfFunction) {
        this.mirror = 1;
        this.decrease = 0.5;
        this.increase = 2;
        pointValue = new HashMap<MyPoint, Double>();
        this.numberOfFunction = numberOfFunction;
        if (numberOfFunction == 1) {
            this.pointValue.put(new MyPoint(10, 9), Function.taskTwoFuncOne(10, 9));
            this.pointValue.put(new MyPoint(10, -2), Function.taskTwoFuncOne(10, -2));
            this.pointValue.put(new MyPoint(21, 1), Function.taskTwoFuncOne(21, 1));
        } else if (numberOfFunction == 2) {
            this.pointValue.put(new MyPoint(10, 9), Function.taskTwoFuncTwo (10, 9));
            this.pointValue.put(new MyPoint(10, -2), Function.taskTwoFuncTwo(10, -2));
            this.pointValue.put(new MyPoint(21, 1), Function.taskTwoFuncTwo (21, 1));
        }
    }

    public MyPoint getCentreOfMass() {
        return centreOfMass;
    }

    public void setCentreOfMass(MyPoint centreOfMass) {
        this.centreOfMass = centreOfMass;
    }

    public double getMirror() {
        return mirror;
    }

    public double getDecrease() {
        return decrease;
    }

    public double getIncrease() {
        return increase;
    }

    public Map<MyPoint, Double> getPointValue() {
        return pointValue;
    }

    public void setPointValue(Map<MyPoint, Double> pointValue) {
        this.pointValue = pointValue;
    }

    public MyPoint getMaxX() {
        return maxX;
    }

    public void setMaxX(MyPoint maxX) {
        this.maxX = maxX;
    }

    public MyPoint getBeforeMaxX() {
        return beforeMaxX;
    }

    public void setBeforeMaxX(MyPoint beforeMaxX) {
        this.beforeMaxX = beforeMaxX;
    }

    public MyPoint getMinX() {
        return minX;
    }

    public void setMinX(MyPoint minX) {
        this.minX = minX;
    }

    public double calculateFunction(double x1, double x2) {
        if (numberOfFunction == 1) {
            return Function.taskTwoFuncOne(x1, x2);
        } else {
            return Function.taskTwoFuncTwo(x1, x2);
        }
    }
    public double calculateFunction(MyPoint point) {
        if (numberOfFunction == 1) {
            return Function.taskTwoFuncOne(point.getX(), point.getY());
        } else {
            return Function.taskTwoFuncTwo(point.getX(), point.getY());
        }
    }
}
