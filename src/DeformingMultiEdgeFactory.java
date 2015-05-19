
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Nikita on 18.05.15.
 */
public class DeformingMultiEdgeFactory {

    public static void findMin(DME defMultiEdge) {

        defMultiEdge.setMaxX(max(defMultiEdge.getPointValue()));
        defMultiEdge.setBeforeMaxX(beforeMax(defMultiEdge.getPointValue()));
        defMultiEdge.setMinX(min(defMultiEdge.getPointValue()));
        defMultiEdge.setCentreOfMass(centreOfMass(defMultiEdge.getPointValue().keySet(),
                                            defMultiEdge.getMaxX()));

        while (!stop(defMultiEdge, defMultiEdge.getCentreOfMass())) {
            MyPoint reflectedPoint = (MyPoint) reflectPoint(defMultiEdge.getCentreOfMass(), defMultiEdge.getMaxX(),
                                                    defMultiEdge.getMirror());
            MyPoint increasedPoint = (MyPoint) increasePoint(defMultiEdge.getCentreOfMass(), reflectedPoint,
                    defMultiEdge.getIncrease());
            MyPoint decreasedPoint = (MyPoint) decreasePoint(defMultiEdge.getCentreOfMass(), defMultiEdge.getMaxX(),
                                                    defMultiEdge.getDecrease());
            if (defMultiEdge.calculateFunction(reflectedPoint) <=
                                        defMultiEdge.calculateFunction(defMultiEdge.getMinX())) {
                if (defMultiEdge.calculateFunction(increasedPoint) <=
                                        defMultiEdge.calculateFunction(reflectedPoint)) {
                    defMultiEdge.getPointValue().remove(defMultiEdge.getMaxX());
                    defMultiEdge.setMaxX(increasedPoint);
                    defMultiEdge.getPointValue().put(increasedPoint, defMultiEdge.calculateFunction(increasedPoint));
                    System.out.println("xMax = " + defMultiEdge.getMaxX() + " valueFunc = " +
                            defMultiEdge.calculateFunction(defMultiEdge.getMaxX()) +
                            " xMin = " + defMultiEdge.getMinX() +
                            " valueFunc = " +
                            defMultiEdge.calculateFunction(defMultiEdge.getMinX()));
                    findMin(defMultiEdge);
                } else {
                    defMultiEdge.getPointValue().remove(defMultiEdge.getMaxX());
                    defMultiEdge.setMaxX(reflectedPoint);
                    defMultiEdge.getPointValue().put(reflectedPoint, defMultiEdge.calculateFunction(reflectedPoint));
                    System.out.println("xMax = " + defMultiEdge.getMaxX() + " valueFunc = " +
                            defMultiEdge.calculateFunction(defMultiEdge.getMaxX()) +
                            " xMin = " + defMultiEdge.getMinX() +
                            " valueFunc = " +
                            defMultiEdge.calculateFunction(defMultiEdge.getMinX()));
                    findMin(defMultiEdge);
                }
            } else if (defMultiEdge.calculateFunction(defMultiEdge.getMinX()) <
                        defMultiEdge.calculateFunction(reflectedPoint) &&
                            defMultiEdge.calculateFunction(reflectedPoint) <=
                                defMultiEdge.calculateFunction(defMultiEdge.getBeforeMaxX())) {
                defMultiEdge.getPointValue().remove(defMultiEdge.getMaxX());
                defMultiEdge.setMaxX(reflectedPoint);
                defMultiEdge.getPointValue().put(reflectedPoint, defMultiEdge.calculateFunction(reflectedPoint));
                System.out.println("xMax = " + defMultiEdge.getMaxX() + " valueFunc = " +
                        defMultiEdge.calculateFunction(defMultiEdge.getMaxX()) +
                        " xMin = " + defMultiEdge.getMinX() +
                        " valueFunc = " +
                        defMultiEdge.calculateFunction(defMultiEdge.getMinX()));
                findMin(defMultiEdge);
            } else if (defMultiEdge.calculateFunction(defMultiEdge.getBeforeMaxX()) <
                        defMultiEdge.calculateFunction(reflectedPoint) &&
                            defMultiEdge.calculateFunction(reflectedPoint) <=
                                defMultiEdge.calculateFunction(defMultiEdge.getMaxX())) {
                defMultiEdge.getPointValue().remove(defMultiEdge.getMaxX());
                defMultiEdge.setMaxX(decreasedPoint);
                defMultiEdge.getPointValue().put(decreasedPoint, defMultiEdge.calculateFunction(decreasedPoint));
                System.out.println("xMax = " + defMultiEdge.getMaxX() + " valueFunc = " +
                        defMultiEdge.calculateFunction(defMultiEdge.getMaxX()) +
                        " xMin = " + defMultiEdge.getMinX() +
                        " valueFunc = " +
                        defMultiEdge.calculateFunction(defMultiEdge.getMinX()));
                findMin(defMultiEdge);
            } else if (defMultiEdge.calculateFunction(reflectedPoint) >
                        defMultiEdge.calculateFunction(defMultiEdge.getMaxX())) {
                reductionOfAllPoints(defMultiEdge);
                System.out.println("xMax = " + defMultiEdge.getMaxX() + " valueFunc = " +
                        defMultiEdge.calculateFunction(defMultiEdge.getMaxX()) +
                        " xMin = " + defMultiEdge.getMinX() +
                        " valueFunc = " +
                        defMultiEdge.calculateFunction(defMultiEdge.getMinX()));
                findMin(defMultiEdge);
            }
        }
    }

    private static MyPoint max(Map<MyPoint, Double> pointValue) {
        MyPoint maxPoint = (MyPoint)pointValue.keySet().toArray()[0];
        Double maxValue = (Double)pointValue.values().toArray()[0];
        for (MyPoint key : pointValue.keySet()) {
            if (pointValue.get(key) > maxValue) {
                maxValue = pointValue.get(key);
                maxPoint = key;
            }
        }
        return maxPoint;
    }

    private static MyPoint min(Map<MyPoint, Double> pointValue) {
        MyPoint minPoint = (MyPoint)pointValue.keySet().toArray()[0];
        Double minValue = (Double)pointValue.values().toArray()[0];
        for (MyPoint key : pointValue.keySet()) {
            if (pointValue.get(key) < minValue) {
                minValue = pointValue.get(key);
                minPoint = key;
            }
        }
        return minPoint;
    }

    private static MyPoint beforeMax(Map<MyPoint, Double> pointValue) {
        MyPoint maxPoint = (MyPoint)pointValue.keySet().toArray()[0];
        MyPoint beforeMaxPoint = (MyPoint)pointValue.keySet().toArray()[1];
        Double maxValue = (Double)pointValue.values().toArray()[0];
        for (MyPoint key : pointValue.keySet()) {
            if (pointValue.get(key) > maxValue) {
                maxValue = pointValue.get(key);
                beforeMaxPoint = maxPoint;
                maxPoint = key;
            }
        }
        return beforeMaxPoint;
    }

    private static MyPoint centreOfMass(Set<MyPoint> points, MyPoint maxPoint) {
        Double x = 0d;
        Double y = 0d;
        Double n = 0d;
        for (MyPoint point : points) {
            if (!point.equals(maxPoint)) {
                x += point.getX();
                y += point.getY();
                n++;
            }
        }
        return new MyPoint(x/n, y/n);
    }

    private static boolean stop (DME defMultiEdge, MyPoint centreMass) {
        double epsilon = 1e-6;
        double sum = 0;
        double n = 0;
        for (MyPoint point : defMultiEdge.getPointValue().keySet()) {
            sum += Math.pow(defMultiEdge.calculateFunction(centreMass.getX(), centreMass.getY()) -
                            defMultiEdge.calculateFunction(point.getX(), point.getY()), 2);
            n++;
        }
        sum = Math.sqrt(sum/n);
        if (sum <= epsilon) {
            return true;
        } else {
            return false;
        }
    }

    private static MyPoint reflectPoint(MyPoint centreMass, MyPoint maxX, double mirror) {
        double x = centreMass.getX() + mirror * (centreMass.getX() - maxX.getY());
        double y = centreMass.getY() + mirror * (centreMass.getY() - maxX.getY());
        return new MyPoint(x, y);
    }

    private static MyPoint increasePoint(MyPoint centreMass, MyPoint reflectedPoint, double increase) {
        double x = centreMass.getX() + increase * (centreMass.getX() - reflectedPoint.getY());
        double y = centreMass.getY() + increase * (centreMass.getY() - reflectedPoint.getY());
        return new MyPoint(x, y);
    }

    private static MyPoint decreasePoint (MyPoint centreMass, MyPoint maxX, double decrease) {
        double x = centreMass.getX() + decrease * (centreMass.getX() - maxX.getY());
        double y = centreMass.getY() + decrease * (centreMass.getY() - maxX.getY());
        return new MyPoint(x, y);
    }

    private static void reductionOfAllPoints (DME defMultiEdge) {
        Map<MyPoint, Double> newPointValue = new HashMap<MyPoint, Double>();
        for (MyPoint point : defMultiEdge.getPointValue().keySet()) {
            if (point != defMultiEdge.getMinX()) {
                double x = defMultiEdge.getMinX().getX() + 0.5 * (point.getX() - defMultiEdge.getMinX().getX());
                double y = defMultiEdge.getMinX().getY() + 0.5 * (point.getY() - defMultiEdge.getMinX().getY());
                newPointValue.put(new MyPoint(x, y), defMultiEdge.calculateFunction(x, y));
            } else {
                newPointValue.put(point, defMultiEdge.calculateFunction(point));
            }
        }
        defMultiEdge.setPointValue(newPointValue);
    }
}
