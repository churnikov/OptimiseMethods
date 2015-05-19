/**
 * Created by Nikita on 18.05.15.
 */
public class MyPoint {
    private double x;
    private double y;

    MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof MyPoint))return false;
        MyPoint otherMyClass = (MyPoint)other;
        if (this.x == ((MyPoint) other).getX() && this.y == ((MyPoint) other).getY())
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "MyPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
